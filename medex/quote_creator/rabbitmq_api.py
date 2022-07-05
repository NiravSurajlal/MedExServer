from http import client
import kombu
import socket

hostname = socket.gethostname()
ip_addr = socket.gethostbyname(hostname)

requested_queues = [
    'main_queue',
    'pinger_queue'
]

def get_current_queue():
    conn = kombu.Connection(f'amqp://niravs:UuVZad3eEYPeXtFWRgwA@{ip_addr}:5672')
    conn.connect()
    client = conn.get_manager()
    queues = client.get_queues()
    # for queue in queues:
    #     if queue.get("name") in requested_queues:
    #         print(queue["name"])
    #         print(queue["messages_ready"])
    #         print(queue['messages_unacknowledged'])
    return queues