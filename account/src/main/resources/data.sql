DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;

CREATE TABLE `customer`(
	`customer_id` int AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(100) NOT NULL,
	`mobile_number` varchar(13) NOT NULL,
	`email_id` varchar(100) NOT NULL,
	`created_date` date DEFAULT NULL
);

CREATE TABLE `account` (
	`account_number` int AUTO_INCREMENT PRIMARY KEY,
	`customer_id` int NOT NULL,
	`account_type` varchar(100) NOT NULL,
	`branch` varchar(100) NOT NULL,
	`created_date` date DEFAULT NULL
);

INSERT INTO `customer` (`name`,`mobile_number`,`email_id`,`created_date`)
VALUES ('SHUBHAM','9552885037','shubhamjadhav5842@gmail.com',CURDATE());

INSERT INTO `customer` (`name`,`mobile_number`,`email_id`,`created_date`)
VALUES ('PRANAY','8421515244','pranaybafna137@gmail.com',CURDATE());

INSERT INTO `customer` (`name`,`mobile_number`,`email_id`,`created_date`)
VALUES ('DIVIESH','7030149108','cdiviesh@gmail.com',CURDATE());

INSERT INTO `account` (`account_number`,`customer_id`,`account_type`,`branch`,`created_date`)
VALUES (123,1,'Saving','Shahada',CURDATE());

INSERT INTO `account` (`account_number`,`customer_id`,`account_type`,`branch`,`created_date`)
VALUES (1234,2,'Saving','Dhule',CURDATE());

INSERT INTO `account` (`account_number`,`customer_id`,`account_type`,`branch`,`created_date`)
VALUES (1235,3,'Saving','Jalgoan',CURDATE());