#!/usr/bin/env python
"""Django's command-line utility for administrative tasks."""
import os
import sys

import logging
import json
from logging.config import dictConfig
import subprocess
from time import sleep

debug = False

def start_rabbitmq(medex_LOGGER):
    medex_LOGGER.info("Starting up Rabbitmq.")
    rabbitmq_path = os.path.join("C:", os.sep, "Program Files", "RabbitMQ Server", "rabbitmq_server-3.10.5", "sbin", "rabbitmq-server" )
    rabbitmq_cmd = ['cmd', '/c', f"{rabbitmq_path}"]
    # self.rabbit_process = subprocess.Popen(rabbitmq_cmd, creationflags=subprocess.CREATE_NEW_PROCESS_GROUP)
    rabbit_process = subprocess.Popen(rabbitmq_cmd, creationflags=subprocess.CREATE_NEW_CONSOLE)
    sleep(20)

def start_celery(medex_LOGGER):
    medex_LOGGER.info("Starting up Celery.")
    celery_cmd = ['celery', '-A', 'medex', 'worker', '--loglevel=info', '-P', 'eventlet']
    celery_process = subprocess.Popen(celery_cmd, creationflags=subprocess.CREATE_NEW_CONSOLE)
    sleep(15)

def main():
    """Run administrative tasks."""
    os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'medex.settings')
    try:
        from django.core.management import execute_from_command_line
    except ImportError as exc:
        raise ImportError(
            "Couldn't import Django. Are you sure it's installed and "
            "available on your PYTHONPATH environment variable? Did you "
            "forget to activate a virtual environment?"
        ) from exc
    execute_from_command_line(sys.argv)


if __name__ == '__main__':
    with open("log_config.json", 'r') as f:
        log_config_data = json.load(f)
        dictConfig(log_config_data)
        medex_log = logging.getLogger("MEDEX")
        medex_log.info('Logger Started.')

    if not debug:
        start_rabbitmq(medex_log)
        start_celery(medex_log)
    else:
        medex_log.info("Please start rabbitmq and celery. ")
    main()
