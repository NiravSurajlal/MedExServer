from msilib.schema import Error
from sqlite3 import IntegrityError
from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from django.db import IntegrityError as IE
import logging

__LOGGER = logging.getLogger("quote_creator")

class CreateNewUser(UserCreationForm):
    email = forms.EmailField(required=True)
    class Meta:
        model = User
        fields = ("email", "password1", "password2")
    
    def save(self, commit=True):
        error = None
        user = super(CreateNewUser, self).save(commit=False)
        user.email = self.cleaned_data['email']
        user.username = self.cleaned_data['email']

        if "@tecex.com" not in str(user.username):
            error = "Registration unsuccessful. Please make sure you used a tecex (@tecex.com) email address. "

        else:
            if commit:
                try:
                    user.save()
                except IE as e:
                    # str(type(e)) == "<class 'django.db.utils.IntegrityError'>"
                    # __LOGGER.debug(f"Unable to save user because of ERROR: {e}")
                    error = e
        return (user, error)
        