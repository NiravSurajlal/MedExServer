import os
from django.shortcuts import redirect, render
from django.template import loader
from django.contrib.auth import authenticate, login, logout

from .forms import CreateNewUser
from django.contrib.auth.forms import AuthenticationForm 
from django.contrib import messages
import logging
from medex.celery import medex_Celery
from .creation import CreateQuote

__LOGGER = logging.getLogger("quote_creator")
_medex_queue_inspector = medex_Celery.control.inspect()
# Create your views here.

# def login_required(view):
#     """ Decorator for view function to check if logged in. """

#     def wrapped_view(**kwargs):
#         if .user is None:
#             return redirect(os.path.join('quote_creator', 'login'))
#         return view(**kwargs)
        
#     return wrapped_view

def home(request):
    return redirect("login")

def register_user(request):
    __LOGGER.debug("Loading register_user view.")
    display_error = ''
    print(request.user)

    if request.method == "POST":
        form = CreateNewUser(request.POST)

        if form.is_valid():
            __LOGGER.debug("Attempting to register user.")
            (user, error) = form.save()
            if error is not None:
                display_error = "Registration unsuccessful. Please try another tecex (@tecex.com) email address. "
                __LOGGER.debug(f"Unable to save user because of ERROR: {error}")
                form = CreateNewUser()
                template_name = os.path.join('quote_creator', 'register.html')
                return render(request=request, template_name=template_name, context={"register_form":form, "error": display_error})
            else:
                __LOGGER.debug(f"Registration of {user.username} successful.")
                messages.success(request, "Registration successful." )
                login(request, user)
                return redirect("create_quote")

        display_error = "Registration unsuccessful. Please check that conditions are met and that a @tecex.com email address is used. "
        messages.error(request, display_error)
    form = CreateNewUser()
    template_name = os.path.join('quote_creator', 'register.html')
    return render(request=request, template_name=template_name, context={"register_form":form, "error": display_error})

def login_view(request):
    __LOGGER.debug("Loading login view.")
    error = ''
    if request.method == "POST":
        form = AuthenticationForm(request, data=request.POST)
        if form.is_valid():
            username = form.cleaned_data.get('username')
            password = form.cleaned_data.get('password')
            __LOGGER.debug(f"Attempting to login user: {username}.")
            user = authenticate(username=username, password=password)
            if user is not None:
                login(request, user)
                messages.info(request, f"You are now logged in as {username}.")
                __LOGGER.info(f"You are now logged in as {username}.")
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
    __LOGGER.info(f"Logging out {request.user}.")
    logout(request)
    return redirect('register')


def create_quote(request):
    __LOGGER.debug("Loading create_quote view.")
    if (request.user is None) or (str(request.user) == "AnonymousUser"):
        return redirect('login')
    
    creation = CreateQuote("Loaded File", str(request.user))
    creation.send_email()
    # updates celery tasks to include a new one
    # medex_Celery.conf.update(task_routes = {'medex.quote_creator.tasks.add': {'queue': 'hipri'},},)
    # medex_Celery.apply_async((2, 2), queue='hipri')
    # username = str(request.user).split("@")[0]
    # add.apply_async((username, ))
    template_name = os.path.join('quote_creator', 'create_quote.html')
    return render(request=request, template_name=template_name)
    