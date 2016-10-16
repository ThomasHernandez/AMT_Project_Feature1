DROP SCHEMA IF EXISTS users;
CREATE SCHEMA users;

USE users;

CREATE TABLE user (

	user_id int(15) NOT NULL AUTO_INCREMENT,
	user_username VARCHAR(15) UNIQUE NOT NULL,
	user_password VARCHAR(15) NOT NULL,
	user_first_name VARCHAR(45) NOT NULL,
    user_last_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (user_id)
	
);







