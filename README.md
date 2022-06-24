# MedExServer
Allows registered Microsoft Vat IT users to create quote for medical by:
    1) Logging in with their Microsoft account.
    2) Uploading a .xlsx file.
    3) A bot will start in the background.
    4) The result will be emailed to the user.
    
## Loggers
Located in the log_config.json file and loaded when the server starts up.
'MEDEX'         : Overall & misc. Users on pages, logged in and logged out.
'quote_creator' : Quote creation process. Start, end & other.
'taskhandler'   : To log from the queue on individual tasks.  