from multiprocessing import context
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
__medex_LOGGER = logging.getLogger("MEDEX")
_medex_queue_inspector = medex_Celery.control.inspect()

def create_quote(request):
    # if (request.user is None) or (str(request.user) == "AnonymousUser"):
    #     return redirect('login')
    try:
        users_name = request.session.get('users_name')
        email = request.session.get('email')
        __medex_LOGGER.debug(f"{users_name} is logged in on create_quote page.")
    except KeyError as e:
        messages.error(request, "No User logged in. ")
        __qc_LOGGER.info(f"No User logged in. Error: {e}")
        return redirect('')

    if request.method == "POST":
        form = UploadExcelFileForm(request.POST, request.FILES)

        if form.is_valid():
            excel_doc_path = form.save_data_and_get_path(request.user)
            messages.success(request, "File uploaded.")
            __qc_LOGGER.info(f"Attempting to create quote for {str(users_name)}")
            add_task.delay(email, excel_doc_path, users_name)
            # add_task(email, excel_doc_path, users_name)
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

#_________________________ FOR MS LOGIN _________________________
def home(request):
    context = initialize_context(request)
    template_name = os.path.join('quote_creator', 'home.html')
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
    __medex_LOGGER.debug("Attemping to log in a user. ")
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
    try:
        users_name = request.session.get('users_name')
        __medex_LOGGER.debug(f"Attempting to logout {users_name}.")
    except KeyError as e:
        messages.error(request, "No User logged in. ")
        __qc_LOGGER.info(f"No User logged in. Error: {e}")
        return redirect('')
    remove_user_and_token(request)
    __medex_LOGGER.debug(f"{users_name} is logged out.")
    return HttpResponseRedirect(reverse('home'))

def callback(request):
    # Make the token request
    result = get_token_from_code(request)
    #Get the user's profile from graph_helper.py script
    user = get_user(result['access_token'])
    # assign current user
    request.session['users_name'] = user['displayName']
    request.session['email'] = user['mail'] 
    # Store user from auth_helper.py script
    store_user(request, user)
    # return HttpResponseRedirect(reverse('home'))
    return redirect('create_quote')
