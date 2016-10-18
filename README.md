# AMT_Project_Feature1 - CIANI Antony, HERNANDEZ Thomas


## Description

This project is part of the AMT course taught at HEIG-VD by professor Olivier Liechti.

It is a simple Java EE web application where the user can register an then login using the credentials he provided into a secret page.

It is based on Wildfly Application Server to serve the pages and do the processing job and a MySql server to handle the database where the users information is stored. A PhpMyAdmin docker image is used to easily view the content of the database.

The whole setup relies on Docker images and on a Docker Compose topology so it can be easily deployed and for reproducibility concerns (correction). 

## Deployment Instructions for Docker

Clone the repo to your machine, open your preferred terminal where you can use docker commands.

Move to **topology-amt** directory. There should be the **docker-compose.yml** file describing the topology.

Run the 

	docker-compose down 

command to remove previous running containers.

Run the 

	docker-compose up --build 

command. This should build the mysql, phpmyadmin and wildfly images and start them.

To access the main application go to:

[http://192.168.99.100:9090/amt/home](http://192.168.99.100:9090/amt/home)

**N.B: The IP address may differ depending on your docker environment, the one provided is the one assigned in case there is no other docker containers using this IP.**





## REST API

//TODO

## Database

//TODO



## Sitemap

Login page: [http://192.168.99.100:9090/amt/login](http://192.168.99.100:9090/amt/login)

Register page: [http://192.168.99.100:9090/amt/register](http://192.168.99.100:9090/amt/register)

Protected page (only accessible when logged in) : [http://192.168.99.100:9090/amt/protected](http://192.168.99.100:9090/amt/protected)




