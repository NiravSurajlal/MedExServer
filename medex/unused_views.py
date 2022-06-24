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