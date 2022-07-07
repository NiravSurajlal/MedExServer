#!/usr/bin/env python
"""
Django's command-line utility for administrative tasks.

Intialises the logger from the log_config.json file.

Starts up the RabbitMQ and Celery processes.
"""

import os
import sys

import logging
import json
from logging.config import dictConfig
import subprocess
from time import sleep

from medex.celery import medex_Celery
from medex.settings import __MY_DEBUG__

def start_rabbitmq(medex_LOGGER):
    medex_LOGGER.info("Starting up Rabbitmq.")
    rabbitmq_path = os.path.join("C:", os.sep, "Program Files", "RabbitMQ Server", "rabbitmq_server-3.10.5", "sbin", "rabbitmq-server" )
    rabbitmq_cmd = ['cmd', '/c', f"{rabbitmq_path}"]
    rabbit_process = subprocess.Popen(rabbitmq_cmd, creationflags=subprocess.CREATE_NEW_CONSOLE)
    sleep(40)

def start_celery(medex_LOGGER):
    medex_LOGGER.info("... Clearing Celery Queue ...")

    medex_Celery.control.purge()
    
    medex_LOGGER.info("Starting up Celery 1. ")
    celery_cmd_1 = ['celery', '-A', 'medex', 'worker', '--loglevel=info', '-Q', 'medical_queue', '--concurrency', '1', '-E', '--without-heartbeat', '-P', 'eventlet', '-n', 'worker_medical@nirav']
    celery_process_1 = subprocess.Popen(celery_cmd_1, creationflags=subprocess.CREATE_NEW_CONSOLE)
    sleep(15)
    medex_LOGGER.info("Starting up Celery 2. ")
    celery_cmd_2 = ['celery', '-A', 'medex', 'worker', '--loglevel=info', '-Q', 'pinger_queue', '--concurrency', '2', '-E', '--without-heartbeat', '-P', 'eventlet', '-n', 'worker_pinger@nirav']
    celery_process_2 = subprocess.Popen(celery_cmd_2, creationflags=subprocess.CREATE_NEW_CONSOLE)
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
    print(f"\n\t << DEBUG_MODE = {__MY_DEBUG__} >> \n")
    with open("log_config.json", 'r') as f:
        log_config_data = json.load(f)
        dictConfig(log_config_data)
        medex_log = logging.getLogger("MEDEX")
        medex_log.info('Logger Started.')

    if not __MY_DEBUG__:
        start_rabbitmq(medex_log)
        start_celery(medex_log)
        print("Start alles. ")
    else:
        medex_log.info("Please start rabbitmq and celery. ")
    try:
        main()
    except KeyboardInterrupt as e:
        print("\n ENGING \n")
