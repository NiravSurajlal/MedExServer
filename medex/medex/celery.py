from __future__ import absolute_import
import logging
import os
from celery import Celery 
from django.conf import settings

__logger = logging.getLogger("MEDEX")
__logger.debug("Starting celery. ")

# set the default Django settings module for this celery 
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'medex.settings')
medex_Celery = Celery("medex")

# Using a string here means the worker will not have to pickle the object when using Windows.
medex_Celery.config_from_object("django.conf:settings")
medex_Celery.autodiscover_tasks(lambda: settings.INSTALLED_APPS)

# can use the same settings as the actual bot
# pinging_Celery = Celery()
# pinging_Celery.config_from_object("django.conf:settings")
# pinging_Celery.autodiscover_tasks(lambda: settings.INSTALLED_APPS)

@medex_Celery.task(bind=True)
def debug_task(self):
    print('Request: {0!r}'.format(self.request))
