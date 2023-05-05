DROP TABLE IF EXISTS loan;

CREATE TABLE `loan`(
	`loan_number` int PRIMARY KEY AUTO_INCREMENT,
	`customer_id` int NOT NULL,
	`loan_type` varchar(20) NOT NULL,
	`loan_amount` int NOT NULL,
	`loan_end_date` date DEFAULT CURDATE()+1
);

INSERT INTO `loan`(`customer_id`,`loan_type`,`loan_amount`,`loan_end_date`)
VALUES (1, 'HOUSING LOAN', 10000, CURDATE()+1000);

INSERT INTO `loan`(`customer_id`,`loan_type`,`loan_amount`,`loan_end_date`)
VALUES (1, 'VEHICLE LOAN', 50000, CURDATE()+100);

INSERT INTO `loan`(`customer_id`,`loan_type`,`loan_amount`,`loan_end_date`)
VALUES (1, 'HOUSING LOAN', 10000, CURDATE()+1000);

INSERT INTO `loan`(`customer_id`,`loan_type`,`loan_amount`,`loan_end_date`)
VALUES (2, 'HOUSING LOAN', 80000, CURDATE()+5000);

INSERT INTO `loan`(`customer_id`,`loan_type`,`loan_amount`,`loan_end_date`)
VALUES (2, 'PERSONAL LOAN', 7000, CURDATE()+10);

