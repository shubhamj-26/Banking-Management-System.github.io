DROP TABLE IF EXISTS cards;

CREATE TABLE `cards`(
	`card_id` int PRIMARY KEY AUTO_INCREMENT,
	`customer_id` int NOT NULL,
	`card_number` int NOT NULL,
	`card_type` varchar(20) NOT NULL,
	`expiry_date` date DEFAULT NULL
);

INSERT INTO `cards`(`customer_id`,`card_number`,`card_type`,`expiry_date`)
VALUES(1,445566,'CREDIT_CARD',CURDATE());

INSERT INTO `cards`(`customer_id`,`card_number`,`card_type`,`expiry_date`)
VALUES(1,778899,'DEBIT_CARD',CURDATE());

INSERT INTO `cards`(`customer_id`,`card_number`,`card_type`,`expiry_date`)
VALUES(2,996633,'CREDIT_CARD',CURDATE());

INSERT INTO `cards`(`customer_id`,`card_number`,`card_type`,`expiry_date`)
VALUES(2,885522,'DEBIT_CARD',CURDATE());

INSERT INTO `cards`(`customer_id`,`card_number`,`card_type`,`expiry_date`)
VALUES(3,774411,'DEBIT_CARD',CURDATE());