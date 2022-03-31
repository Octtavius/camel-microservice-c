# camel-microservice-c
This microservice is part of the same project as microservice a and b. 
Microservice-c reads files in a folder and will transfer them on ActiveMQ.
It uses two routes, one for xml and one for json. The files are unmarshalled to Java objects and then sent to activemq.

To run an activemq, execute the below command in docker cmd

	docker run -p 61616:61616 -p 8161:8161 rmohr/activemq


