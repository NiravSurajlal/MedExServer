"""
Configures and sends the emails.
"""
import os
from django.template.loader import render_to_string
from django.core import mail
from medex.settings import __MY_DEBUGGER__


def get_template_dir(email_type):
    """ Gets the templates for the email depending on whether a project or
        single so was requested. """

    cwd = os.getcwd()
    if __MY_DEBUGGER__['mode']:
        text_body_dir = os.path.join(cwd, "medex", "templates", "emails")
    else:
        text_body_dir = os.path.join(cwd, "templates", "emails")

    if email_type == 'proj':
        text_body_dir = os.path.join(text_body_dir, "proj_result_email.txt")
    elif email_type == 'single_so':
        text_body_dir = os.path.join(text_body_dir, "result_email.txt")
    elif email_type == 'error':
        text_body_dir = os.path.join(text_body_dir, "error_email.txt")

    return text_body_dir


def send_feedback_email(email, username, result):
    """ Send an email with the result to the user who requested the
        quote. """

    mail_subject = "MEDICAL - Your Quote"

    if result['Project Name']:
        context = {'name': username, 'email': email, 'project_link': result['Link'], 'project_name': result['Project Name']}
        text_body_dir = get_template_dir('proj')
    else:
        context = {'name': username, 'email': email, 'so_link': result['Link'], 'so_name': result['Name']}
        text_body_dir = get_template_dir('single_so')

    mail_body = render_to_string(text_body_dir, context=context)

    with mail.get_connection() as connection:
        mail.EmailMessage(subject=mail_subject,
                          body=mail_body,
                          to=[email, ]).send(fail_silently=False)


def send_error_mail(error_msg, email=None, username=None):
    email_1 = 'niravs@tecex.com'
    mail_subject = "ERROR"

    context = {'name': username, 'email': email, 'error_msg': error_msg}

    text_body_dir = get_template_dir('error')

    mail_body = render_to_string(text_body_dir, context=context)

    if email is not None:
        with mail.get_connection() as connection:
            mail.EmailMessage(subject=mail_subject,
                              body=mail_body,
                              to=[email_1, email]).send(fail_silently=False)
    else:
        with mail.get_connection() as connection:
            mail.EmailMessage(subject=mail_subject,
                              body=mail_body,
                              to=[email_1]).send(fail_silently=False)
