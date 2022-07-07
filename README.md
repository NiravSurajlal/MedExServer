# Medical Server
Allows registered Microsoft Vat IT users to create quote for medical by:
    1) Logging in with their Microsoft account.
    2) Uploading a .xlsx file.
    3) The request will be added to a queue, waiting for a free bot to create the quote. 
    4) The result will be emailed to the user.
    
## Installation
This app is a Django App that uses Celery to process the tasks and RabbitMQ as the messaging broker. RabbitMQ requires Erlang and the bot requires Maven and Java.

### Requirements
- Erlang should be installed before RabbitMQ and must be kept up-to-date.
    - visit https://www.erlang.org/downloads to install. 
- RabbitMQ should be installed next.
    - visit https://lostechies.com/derekgreer/2012/03/05/rabbitmq-for-windows-introduction/ to install.
- Maven and Java can be installed at anytime, but the bot will not run without them. Java must be installed first, and its path must be configured.
    - visit https://phoenixnap.com/kb/install-maven-windows to install them.
    - Running "$ java --version" should return:
        > java --version
        
        	> java 11.0.15.1 2022-04-22 LTS
        	> Java(TM) SE Runtime Environment 18.9 (build 11.0.15.1+2-LTS-10)
        	> Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.15.1+2-LTS-10, mixed mode)
		
    - Running "$ mvn --version" should return:
        > mvn --version
        
        	> Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
        	> Maven home: C:\apache-maven-3.8.4
        	> Java version: 11.0.15.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.15.1
        	> Default locale: en_US, platform encoding: Cp1252
        	> OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
        	
- The python requirements can be found in the requirements.txt file located in the top directory. Use 
    > $ pip install -r requirements.txt
- Finally, this process uses keyringer to get credentials from the (Windows) credentials manager. Please ensure that you have the credentials available or contact niravs@tecex.com. 

## Loggers
Located in the log_config.json file and loaded when the server starts up.
'MEDEX'         : Overall & misc. Users on pages, logged in and logged out, function .
'quote_creator' : Quote creation process. Start, end & other.
'taskhandler'   : To log from the queue on individual tasks.  
