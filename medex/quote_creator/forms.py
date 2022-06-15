from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from django.db import IntegrityError as IE, models
import logging
import openpyxl as opxyl
import os
from medex import __USERDATCACHEPATH__

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
    excel_file = forms.FileField(required=True)

    def save_data_and_get_path(self, user):
        error = None

        user = str(user)
        user = f"{user}.xlsx"
        path = os.path.join(__USERDATCACHEPATH__, user)
        
        excel_doc = self.cleaned_data['excel_file']
        excel_file = opxyl.load_workbook(excel_doc)
        excel_file.save(path)
        # excel_doc = pd.ExcelFile(excel_doc, engine='pyxlsb')
        # excel_doc = pd.read_excel(excel_doc)
        # json_excel_spreadsheet = excel_doc.to_json()
        return path

# class UploadExcelFileForm(models.Model):
#     excel_file = models.FileField()

#     def get_excel(self):
#         error = None
#         excel_doc = self.cleaned_data['excel_file']
#         excel_doc = pd.ExcelFile(excel_doc, engine='pyxlsb')
#         excel_doc = pd.read_excel(excel_doc)
#         json_excel_spreadsheet = excel_doc.to_json()
#         return json_excel_spreadsheet
        
