
CREATE DATABASE IF NOT EXISTS Novant_health;
USE Novant_health;



DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `specilization` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;



INSERT INTO `doctor` (`id`,`username`,`password`,`name`,`address`,`mobile`,`email`,`specilization`) VALUES 
 (1,'doctor1','doctor1','ABC','UT','3299692396','doctor1@gmail.com','heart'),
 (2,'doctor2','doctor2','XYZ','UTN','7489462985','doctor2@rediffmail.com','Cancer Specialist');


DROP TABLE IF EXISTS `pappointment`;
CREATE TABLE `pappointment` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `doctor` varchar(45) NOT NULL,
  `symtoms` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `did` int(10) unsigned NOT NULL,
  `image` varchar(55) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;




INSERT INTO `pappointment` (`id`,`name`,`age`,`sex`,`address`,`mobile`,`email`,`doctor`,`symtoms`,`date`,`did`,`image`) VALUES 
 (9,'pat1','19','male','si','3299692396','mj0506@gmail.com','ABC','Maleria','2016-12-22',0,'a.jpg'),
 (10,'pat2','19','male','si','3299692396','mj0506@gmail.com','ABC','Maleria','2016-12-11',0,'a.jpg');



DROP TABLE IF EXISTS `phar`;
CREATE TABLE `phar` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `did` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `phar` (`id`,`username`,`password`,`name`,`address`,`mobile`,`email`,`did`) VALUES 
 (1,'phar1','phar1','ABC','ASH','9898989898','phar1@gmail.com',1),
 (2,'phar2','phar2','mjhd','ASH','75534853483','phar2@gmail.com',0);


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `pname` varchar(45) NOT NULL,
  `p_price` varchar(45) NOT NULL,
  `stockinhand` varchar(45) NOT NULL,
  `dangerlevel` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `product` (`pid`,`pname`,`p_price`,`stockinhand`,`dangerlevel`) VALUES 
 (3,'medicine2','244.0','41','10'),
 (4,'medicine3','100.0','35','20');
