from __future__ import absolute_import
import logging
import os
from celery import Celery 
from django.conf import settings

__logger = logging.getLogger("MEDEX")
__logger.debug("Starting celery. ")

medex_Celery_task_routes = {
    'add_task': {'queue': 'medical_queue'},
    'rabbitmq_pinging_task': {'queue': 'pinger_queue'},
    'start_pinger': {'queue': 'pinger_queue'},
}
pinging_Celery_task_routes = {
    'rabbitmq_pinging_task': {'queue': 'pinger_queue'},
    'start_pinger': {'queue': 'pinger_queue'},
}

# set the default Django settings module for this celery 
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'medex.settings')
medex_Celery = Celery("medex")

# Using a string here means the worker will not have to pickle the object when using Windows.
medex_Celery.config_from_object("django.conf:settings")
medex_Celery.autodiscover_tasks(lambda: settings.INSTALLED_APPS)
medex_Celery.conf.task_routes = medex_Celery_task_routes

@medex_Celery.task(bind=True)
def debug_task(self):
    print('Request: {0!r}'.format(self.request))
