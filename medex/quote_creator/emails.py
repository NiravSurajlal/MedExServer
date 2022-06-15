from tempfile import template
from django.conf import settings
from django.template.loader import render_to_string
from django.core.mail import EmailMessage
import os
from django.core import mail

def send_feedback_email(email, message):
    name = email.split("@")
    name = name[0]
    context = {'name': name, 'email': email, 'result': message}
    mail_subject = "Your Quote"
    cwd = os.getcwd()
    text_body_dir = os.path.join(cwd, "medex", "templates", "emails", "result_email.txt")
    mail_body = render_to_string(text_body_dir, context=context)

    with mail.get_connection() as connection:
        mail.EmailMessage(subject=mail_subject, 
                          body=mail_body, 
                          to=[email,]).send(fail_silently=False)
