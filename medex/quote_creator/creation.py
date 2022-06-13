from .tasks import send_feedback_email_task

class CreateQuote():
    def __init__(self, loaded_file, email):
        self.loaded_file = loaded_file
        self.associated_email = str(email)
        self.message = "Test"
    
    def create_yaml(self):
        """ Convert the uploaded excel to a YAML file. """
        pass

    def create(self):
        """ Run the seleium bot to create the quote. 
            Returns the result. """
        pass

    def send_email(self):
        """ Sends an email with the result. """
        send_feedback_email_task.delay(self.associated_email, self.message)
