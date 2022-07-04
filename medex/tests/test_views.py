""" This file is used to test the medex application.
    The celery and background processes are tested as well as
    the views, movement of data and dataypes. 
        """

from django.test import TestCase
from django.test.client import Client, RequestFactory
from quote_creator.forms import UploadExcelFileForm
import os
from pandas import ExcelFile

class CreateQuoteTestCase(TestCase):
    def setUp(self):
        """ Instatntiate a request factory object to simulate requests.
            Every test will require this object. """
        self.client = Client()
        self.factory = RequestFactory()
        self.test_file_dir = os.path.join(os.getcwd(), "tests", "bin")

    def test_page_is_active(self):
        """ Test that the quote_creator page is active. """
        response = self.client.post("/quote_creator/create_quote")
        self.assertEqual(response.status_code, 200)

    def test_XLSX_File_starts_bot(self):
        """ Tests that if a xlsx file is uploaded, a bot process gets initiated. """
        pass
    def test_NonXLSXExcel_File(self):
        """ Tests what happens if a non-.xlsx file is uploaded. 
            Should not allow it.  """
        form = UploadExcelFileForm()
        other_file_for_test_location = os.path.join(self.test_file_dir, "TestingText")
        excel_file_for_test = ExcelFile(other_file_for_test_location)


    def test_NonExcel_File(self):
        """ Tests what happens if a non-.xlsx (xlsb) file is uploaded. 
            Should not allow it.  """
        form = UploadExcelFileForm()
        other_file_for_test_location = os.path.join(self.test_file_dir, "TestingText")
        other_file_for_test = ExcelFile(other_file_for_test_location)
        
# if __name__ == "__main__":
#     testcase = CreateQuoteTestCase()
#     testcase.setUp()
#     testcase.test_page_is_active()
