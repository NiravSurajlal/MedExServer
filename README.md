# Medical Server
Allows registered Microsoft Vat IT users to create quote for medical by:
    1) Logging in with their Microsoft account.
    2) Uploading a .xlsx file.
    3) The request will be added to a queue, waiting for a free bot to create the quote. 
    4) The result will be emailed to the user.
    
## Installation
This app is a Django App that uses Celery to process the tasks and RabbitMQ as the messaging broker. RabbitMQ requires Erlang and the bot requires Maven and Java.

### Requirements
- The python requirements can be found in the requirements.txt file located in the top directory. Use 
    >> pip install -r requirements.txt
- 

## Loggers
Located in the log_config.json file and loaded when the server starts up.
'MEDEX'         : Overall & misc. Users on pages, logged in and logged out, function .
'quote_creator' : Quote creation process. Start, end & other.
'taskhandler'   : To log from the queue on individual tasks.  