import os
from re import template
from django.http import HttpResponse
from django.shortcuts import redirect, render
from django.template import loader
from django.contrib.auth import authenticate, login, logout
from psycopg2 import IntegrityError

from .forms import CreateNewUser
from django.contrib.auth.forms import AuthenticationForm 
from django.contrib import messages
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
    error = ''
    if request.method == "POST":
        form = CreateNewUser(request.POST)

        if form.is_valid():
            try:
                user = form.save()
                login(request, user)
                messages.success(request, "Registration successful." )
            except IntegrityError as e:
                error = "Registration unsuccessful. Please try another email and check that conditions are met and that a @tecex.com email address is used. "
            return redirect("create_quote")

        error = "Registration unsuccessful. Please check that conditions are met and that a @tecex.com email address is used. "
        messages.error(request, error)
    form = CreateNewUser()
    template_name = os.path.join('quote_creator', 'register.html')
    return render(request=request, template_name=template_name, context={"register_form":form, "error": error})

def login_view(request):
    error = ''
    if request.method == "POST":
        form = AuthenticationForm(request, data=request.POST)
        if form.is_valid():
            username = form.cleaned_data.get('username')
            password = form.cleaned_data.get('password')
            user = authenticate(username=username, password=password)
            if user is not None:
                login(request, user)
                messages.info(request, f"You are now logged in as {username}.")
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
    logout(request)
    return redirect('register')


def create_quote(request):
    if (request.user is None) or (str(request.user) == "AnonymousUser"):
        return redirect('login')
    template_name = os.path.join('quote_creator', 'create_quote.html')
    return render(request=request, template_name=template_name)