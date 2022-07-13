"""
Module for API calls to RabbitMQ.
"""

import kombu
import socket
import logging
import json
import os

from medex.settings import __CACHEPATH__, __MY_DEBUGGER__

hostname = socket.gethostname()
ip_addr = socket.gethostbyname(hostname)

# requested_queues = [
#     'medical_queue'
# ]


def get_queue_length(requested_queues=['medical_queue']):
    """ Gets the queue length for the requested queues. """

    __medex_LOGGER = logging.getLogger("MEDEX")
    with kombu.Connection(f'amqp://niravs:UuVZad3eEYPeXtFWRgwA@{ip_addr}:5672') as conn:
        conn.connect()
        rabbit_client = conn.get_manager()
        queues = rabbit_client.get_queues()
        queue_results = {}
        for queue in queues:
            queue_name = queue.get("name")
            if queue_name in requested_queues:
                num_items = queue['messages_unacknowledged'] + queue["messages_ready"]
                queue_results[queue_name] = num_items
    return queue_results


def get_all_queue_items(requested_queues=['medical_queue']):
    """ Gets data from the requested queues. """

    __medex_LOGGER = logging.getLogger("MEDEX")
    __medex_LOGGER.debug("Getting all queue items. ")
    queue_data = {}
    with kombu.Connection(f'amqp://niravs:UuVZad3eEYPeXtFWRgwA@{ip_addr}:5672') as conn:
        conn.connect()
        rabbit_client = conn.get_manager()
        queues = rabbit_client.get_queues()
        with conn.channel() as ch:
            for queue in queues:
                queue_name = queue.get("name")
                if queue_name in requested_queues:
                    names_in_queue = {}
                    queue = kombu.Queue(queue_name, routing_key='queue', channel=ch)
                    for i in range(0, 10000):
                        msg = queue.get()
                        if msg is None:
                            break
                        names_in_queue[i] = msg.payload
                    queue_data[queue_name] = names_in_queue
    queue_data_path = os.path.join(__CACHEPATH__, "queue_data.json")
    __medex_LOGGER.debug(f"Saving all json data to {queue_data_path}. ")
    with open(queue_data_path, 'w+') as file:
        json.dump(queue_data, file)


def display_all_queue_items():
    """ Function to display the most updated queue to the user.
        Only displays queue name and user name. """

    if __MY_DEBUGGER__['quickly_load_queue']:
        get_all_queue_items()

    queue_data_path = os.path.join(__CACHEPATH__, "queue_data.json")
    try:
        with open(queue_data_path, 'r') as stream:
            data = json.loads(stream.read())
        all_data = []
        for queue_name in data:
            str_queue_name = queue_name.replace('_', " ").upper()  # +':   '
            queue_data = data[queue_name]
            for item in queue_data:
                item_data = queue_data[item]
                file_name = os.path.split(item_data[0][1])[1]
                user_start_time = file_name[-10:-5].replace('-', ':')
                username = item_data[0][2]
                all_data.append("{} {} - {}".format(user_start_time.ljust(9), str_queue_name, username))
        return all_data
    except Exception as e:
        print(e)
        return None
