import os
from re import template
from django.shortcuts import redirect, render
from django.contrib.auth import authenticate, login, logout

from .forms import CreateNewUser, UploadExcelFileForm
from django.contrib.auth.forms import AuthenticationForm 
from django.contrib import messages
import logging
from medex.celery import medex_Celery
from .tasks import add_task

# For MS Login Views
from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from medex.auth_helper import get_sign_in_flow, get_token_from_code, store_user, remove_user_and_token, get_token
from medex.graph_helper import *

__qc_LOGGER = logging.getLogger("quote_creator")
_medex_queue_inspector = medex_Celery.control.inspect()
# Create your views here.

# def login_required(view):
#     """ Decorator for view function to check if logged in. """

#     def wrapped_view(**kwargs):
#         if .user is None:
#             return redirect(os.path.join('quote_creator', 'login'))
#         return view(**kwargs)
        
#     return wrapped_view

def old_home(request):
    return redirect("login")

def register_user(request):
    __qc_LOGGER.debug("Loading register_user view.")
    display_error = ''
    print(request.user)

    if request.method == "POST":
        form = CreateNewUser(request.POST)

        if form.is_valid():
            __qc_LOGGER.debug("Attempting to register user.")
            (user, error) = form.save()
            if error is not None:
                display_error = "Registration unsuccessful. Please try another tecex (@tecex.com) email address. "
                __qc_LOGGER.debug(f"Unable to save user because of ERROR: {error}")
                form = CreateNewUser()
                template_name = os.path.join('quote_creator', 'register.html')
                return render(request=request, template_name=template_name, context={"register_form":form, "error": display_error})
            else:
                __qc_LOGGER.debug(f"Registration of {user.username} successful.")
                messages.success(request, "Registration successful." )
                login(request, user)
                return redirect("create_quote")

        display_error = "Registration unsuccessful. Please check that conditions are met and that a @tecex.com email address is used. "
        messages.error(request, display_error)
    form = CreateNewUser()
    template_name = os.path.join('quote_creator', 'register.html')
    return render(request=request, template_name=template_name, context={"register_form":form, "error": display_error})

def login_view(request):
    __qc_LOGGER.debug("Loading login view.")
    error = ''
    if request.method == "POST":
        form = AuthenticationForm(request, data=request.POST)
        if form.is_valid():
            username = form.cleaned_data.get('username')
            password = form.cleaned_data.get('password')
            __qc_LOGGER.debug(f"Attempting to login user: {username}.")
            user = authenticate(username=username, password=password)
            if user is not None:
                login(request, user)
                messages.info(request, f"You are now logged in as {username}.")
                __qc_LOGGER.info(f"You are now logged in as {username}.")
                return redirect("create_quote")
            else:
                error = "Invalid username or password. "
                messages.error(request, error)
        else:
            error = "Invalid username or password. "
            messages.error(request, error)
    
    form = AuthenticationForm()
    template_name = os.path.join('quote_creator', 'login.html')
    return render(request=request, template_name=template_name, context={"login_form":form, "error":error})

def logout_view(request):
    __qc_LOGGER.info(f"Logging out {request.user}.")
    logout(request)
    return redirect('register')

def create_quote(request):
    __qc_LOGGER.debug("Loading create_quote view.")
    if (request.user is None) or (str(request.user) == "AnonymousUser"):
        return redirect('login')
    
    __qc_LOGGER.info(f"Attempting to create quote for {str(request.user)}")
    if request.method == "POST":
        form = UploadExcelFileForm(request.POST, request.FILES)

        if form.is_valid():
            excel_doc_path = form.save_data_and_get_path(request.user)
            messages.success(request, "File uploaded.") 
            add_task.delay(str(request.user), excel_doc_path)
            # add_task(str(request.user), excel_doc_path)
            form = UploadExcelFileForm()
            template_name = os.path.join('quote_creator', 'create_quote.html')
            return render(request=request, template_name=template_name, context={'excel_upload_form': form})
        else:
            messages.error(request, "Unable to upload file. ")
            form = UploadExcelFileForm()
            template_name = os.path.join('quote_creator', 'create_quote.html')
            return render(request=request, template_name=template_name, context={'excel_upload_form': form})

    form = UploadExcelFileForm()
    template_name = os.path.join('quote_creator', 'create_quote.html')
    return render(request=request, template_name=template_name, context={'excel_upload_form': form})

    # add_task.delay(str(request.user))

#_________________________ FOR MS LOGIN _________________________
def home(request):
    context = initialize_context(request)
    template_name = os.path.join('quote_creator', 'ms_home.html')
    return render(request, template_name, context)
def initialize_context(request):
    context = {}
    error = request.session.pop('flash_error', None)
    if error != None:
        context['errors'] = []
        context['errors'].append(error)
    # Check for user in the session
    context['user'] = request.session.get("user", {'is_authenticated': False})
    # context['user'] = request.session.get('user')
    return context
def sign_in(request):
    # Get the sign-in flow
    flow = get_sign_in_flow()
    # Save the expected flow so we can use it in the callback
    try:
        request.session['auth_flow'] = flow
    except Exception as e:
        print(e)
    # Redirect to the Azure sign-in page
    return HttpResponseRedirect(flow['auth_uri'])
def sign_out(request):
    # Clear out the user and token
    remove_user_and_token(request)
    return HttpResponseRedirect(reverse('home'))
def callback(request):
    # Make the token request
    result = get_token_from_code(request)
    #Get the user's profile from graph_helper.py script
    user = get_user(result['access_token']) 
    # Store user from auth_helper.py script
    store_user(request, user)
    return HttpResponseRedirect(reverse('home'))
