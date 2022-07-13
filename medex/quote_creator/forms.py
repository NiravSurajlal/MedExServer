"""
Contains the forms to be used.

Has a CreateNewUser class for simple, sqlite databases.

Has an UploadExcelFileForm to allow the user to upload an Excel (.xlsx) file
from the /create_quote page.
"""

from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
import logging
import openpyxl as opxyl
import os
from django.db import IntegrityError as IE
from datetime import datetime

from .emails import send_error_mail
from medex.settings import __USERDATCACHEPATH__
# from medex.medex import __USERDATCACHEPATH__

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


class UploadExcelFileForm(forms.Form):
    """ Class to allow user to upload Excel file. """
    excel_file = forms.FileField(required=True)

    def save_data_and_get_path(self, user):
        """ Saves the data in a local location for use.
            Also limits the file to only .xlsx files.
            All the files saved should be nuked at the end of each process. """

        now = datetime.now()
        ct = now.strftime("%H-%M")
        user = user.split('@')[0]
        user = f"{user}_{ct}.xlsx"
        path = os.path.join(__USERDATCACHEPATH__, user)

        try:
            excel_doc = self.cleaned_data['excel_file']
        except Exception as e:
            error_msg = f"Unable to CLEAN data. Error: {e}"
            send_error_mail(error_msg=error_msg)

        excel_file = opxyl.load_workbook(excel_doc)

        try:
            excel_file.save(path)
        except Exception as e:
            error_msg = f"Unable to SAVE data. Error: {e}"
            send_error_mail(error_msg=error_msg)

        return path
