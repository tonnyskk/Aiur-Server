-- Init db infor: create user/ db
CREATE USER `airuadmin`@`%` IDENTIFIED BY 'adsk45td';
CREATE USER `airuadmin`@`localhost` IDENTIFIED BY 'adsk45td';
CREATE DATABASE `aiurdb`CHARACTER SET utf8 COLLATE utf8_bin;

-- Manage privilage
GRANT ALL ON `aiurdb`.* TO `airuadmin`@`%`;
GRANT ALL ON `aiurdb`.* TO `airuadmin`@`localhost`;

-- create table
DROP TABLE IF EXISTS `aiur_users`;
CREATE TABLE `aiur_users`(
  `user_id` INT(16) NOT NULL AUTO_INCREMENT,
  `login_name` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
  `password` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
  `create_time` DATETIME DEFAULT NULL,
  `update_time` DATETIME DEFAULT NULL,
   PRIMARY KEY (`user_id`),
   KEY `idx_user_01` (`login_name`)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `aiur_groups`;
CREATE TABLE `aiur_groups`(
  `group_id` INT(16) NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
  `group_desc` VARCHAR(256) COLLATE utf8_bin DEFAULT NULL,
  `owner_id` DECIMAL(16, 0) DEFAULT NULL,
  `create_time` DATETIME DEFAULT NULL,
  `update_time` DATETIME DEFAULT NULL,
   PRIMARY KEY (`group_id`),
   KEY `idx_group_01` (`owner_id`)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `aiur_rel_user_group`;
CREATE TABLE `aiur_rel_user_group`(
  `rel_id` INT(16) NOT NULL AUTO_INCREMENT,
  `user_id` DECIMAL(16, 0) DEFAULT NULL,
  `group_id` DECIMAL(16, 0) DEFAULT NULL,
  `status` ENUM('PENDING', 'JOINED', 'REJECT') DEFAULT 'PENDING',
  `create_time` DATETIME DEFAULT NULL,
  `update_time` DATETIME DEFAULT NULL,
   PRIMARY KEY (`rel_id`),
   KEY `idx_rel_01` (`user_id`),
   KEY `idx_rel_02` (`group_id`)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `aiur_user_incomming`;
CREATE TABLE `aiur_user_incomming`(
  `incoming_id` INT(16) NOT NULL AUTO_INCREMENT,
  `user_id` DECIMAL(16, 0) DEFAULT NULL,
  `group_id` DECIMAL(16, 0) DEFAULT NULL,
  `money` DECIMAL(16, 2) DEFAULT 0,
  `status` ENUM('PENDING', 'OK', 'INVALID') DEFAULT 'PENDING',
  `create_time` DATETIME DEFAULT NULL,
  `update_time` DATETIME DEFAULT NULL,
   PRIMARY KEY (`incoming_id`),
   KEY `idx_inc_01` (`user_id`),
   KEY `idx_inc_02` (`group_id`)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `aiur_group_consume`;
CREATE TABLE `aiur_group_consume`(
  `consume_id` INT(16) NOT NULL AUTO_INCREMENT,
  `group_id` DECIMAL(16, 0) DEFAULT NULL,
  `description` VARCHAR(128) COLLATE utf8_bin DEFAULT NULL,
  `money` DECIMAL(16, 2) DEFAULT 0,
  `status` ENUM('PENDING', 'OK', 'INVALID') DEFAULT 'PENDING',
  `create_time` DATETIME DEFAULT NULL,
  `update_time` DATETIME DEFAULT NULL,
   PRIMARY KEY (`consume_id`),
   KEY `idx_con_01` (`group_id`)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `aiur_user_consume_detail`;
CREATE TABLE `aiur_user_consume_detail`(
  `ct_id` INT(16) NOT NULL AUTO_INCREMENT,
  `consume_id` DECIMAL(16, 0) DEFAULT NULL,
  `user_id` DECIMAL(16, 0) DEFAULT NULL,
  `money` DECIMAL(16, 2) DEFAULT 0,
  `create_time` DATETIME DEFAULT NULL,
  `update_time` DATETIME DEFAULT NULL,
   PRIMARY KEY (`ct_id`),
   KEY `idx_cte_01` (`consume_id`)
)ENGINE=MYISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;