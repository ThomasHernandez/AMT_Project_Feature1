# AMT\_Project\_Feature1 - CIANI Antony, HERNANDEZ Thomas


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

The REST API can be used to administrate the users and provides the standard HTTP methods (GET, PUT, POST and DELETE)

A bunch of requests are provided in the postman script in order to test the REST API.

###Add new user

Stores a new User in the database if the username does not already exist.

	URL: POST /amt/api/users
	Json body:
	{
		"username":"exequia",
		"password":"psw123",
		"firstname":"Tom",
		"lastname":"Hernan"
	}

###Find all users

Returns all the Users in the database and displays all the users' infos as a Json tab.

	URL: GET /amt/api/users
	Response (Json):
	[
	  {
	    "firstname": "Thomas",
	    "lastname": "Hernandez",
	    "username": "Tom"
	  },
	  {
	    "firstname": "Antony",
	    "lastname": "Ciani",
	    "username": "Tony"
	  }
	]

###Find user

Returns a User object with the specified username. In this example, let's assume that the username value is `tony`

	URL: GET /amt/api/users/{username}
	Response (Json): 
	{
	    "firstname": "Antony",
	    "lastname": "Ciani",
	    "username": "tony"
	}

###Update user

Updates a specific user with specified non empty fields. If a field remains empty, it won't be updated. Note that the username can't be updated because this field defines the user and thus is final.

	URL: PUT /amt/api/users/{username}
	Json body:
	{
		"password": "toor"
	    "firstname": "Antonini",
	    "lastname": "Cianini"    
	}

###Delete user

Deletes the user with the specified username.

	URL: DELETE /amt/api/users/{username}


## Database

The database contains a single table to store our users informations composed by the following fields:

	user_id int(15) NOT NULL AUTO_INCREMENT,
	user_username VARCHAR(20) UNIQUE NOT NULL,
	user_password VARCHAR(20) NOT NULL,
	user_first_name VARCHAR(50) NOT NULL,
    user_last_name VARCHAR(50) NOT NULL,



## Sitemap

Home page: [http://192.168.99.100:9090/amt/home](http://192.168.99.100:9090/amt/home)

Login page: [http://192.168.99.100:9090/amt/login](http://192.168.99.100:9090/amt/login)

Register page: [http://192.168.99.100:9090/amt/register](http://192.168.99.100:9090/amt/register)

Protected page (only accessible when logged in) : [http://192.168.99.100:9090/amt/protected](http://192.168.99.100:9090/amt/protected)

## Postman Script

To use the provided Postman collection, import **AMT\_Project1.postman\_collection.json** from the **postman** directory into your Postman app.

Either use your own environment by setting the variables "ip" and "port" where "ip" is the IP Address of the wilfly docker container and "port" the port it is listening on.

Or you can simply import the provided Postman environment by importing **AMT\_WildflyServerDocker.postman\_environment.json** from the **postman** directory

The collection provides 5 requests to test all the different REST calls you can do with our REST API.




