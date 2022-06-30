from django.template.loader import render_to_string
from django.core.mail import EmailMessage
import os
from django.core import mail
from medex.settings import __MY_DEBUG__
from time import sleep

def get_template_dir(is_project):
    cwd = os.getcwd()
    if __MY_DEBUG__:
        text_body_dir = os.path.join(cwd, "medex", "templates", "emails")
    else:
        text_body_dir = os.path.join(cwd, "templates", "emails")
    
    if is_project:
        text_body_dir = os.path.join(text_body_dir, "proj_result_email.txt")
    else:
        text_body_dir = os.path.join(text_body_dir, "result_email.txt")

    return text_body_dir
    
def send_feedback_email(email, username, result):
    mail_subject = "MEDICAL - Your Quote"

    if result['Project Name']:
        context = {'name': username, 'email': email, 'project_link': result['Link'], 'project_name': result['Project Name']}
        text_body_dir = get_template_dir(True)
    else:
        context = {'name': username, 'email': email, 'so_link': result['Link'], 'so_name': result['Name']}
        text_body_dir = get_template_dir(False)

    mail_body = render_to_string(text_body_dir, context=context)

    with mail.get_connection() as connection:
        mail.EmailMessage(subject=mail_subject, 
                          body=mail_body, 
                          to=[email,]).send(fail_silently=False)
    
    # sleep(10)
