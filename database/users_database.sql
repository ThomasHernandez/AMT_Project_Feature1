DROP SCHEMA IF EXISTS users;
CREATE SCHEMA users;

USE users;

CREATE TABLE user (

	user_id int(15) NOT NULL AUTO_INCREMENT,
	user_username varchar(15) UNIQUE NOT NULL,
	user_password varchar(15) NOT NULL,
    PRIMARY KEY (user_id)
	
);







