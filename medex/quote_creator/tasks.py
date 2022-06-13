import logging
import os
from medex.celery import medex_Celery 
from .emails import send_feedback_email

@medex_Celery.task(name="send_feedback_email_task")
def send_feedback_email_task(email, message="test"):
    __taskhandler_LOG = logging.getLogger("taskhandler")
    print(f"{email} : {message}")
    __taskhandler_LOG.info("Attempting to send email. ") 
    return send_feedback_email(email, message) 
    
# @shared_task
# def add2(x, y):
#     return x + y