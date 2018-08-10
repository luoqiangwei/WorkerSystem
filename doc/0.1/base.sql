CREATE DATABASE  IF NOT EXISTS `studio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `studio`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 115.159.146.57    Database: studio
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_rights`
--

DROP TABLE IF EXISTS `admin_rights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_rights` (
  `user_id` char(10) NOT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_admin_rights_user_idm` FOREIGN KEY (`user_id`) REFERENCES `member_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_admin_rights_user_idt` FOREIGN KEY (`user_id`) REFERENCES `teacher_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_rights`
--

LOCK TABLES `admin_rights` WRITE;
/*!40000 ALTER TABLE `admin_rights` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_rights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bulletin_information`
--

DROP TABLE IF EXISTS `bulletin_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bulletin_information` (
  `notice_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `title` varchar(2050) NOT NULL,
  `content` varchar(2050) DEFAULT NULL,
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`notice_id`),
  KEY `fk_bulletin_information_user_id_idx` (`user_id`),
  CONSTRAINT `fk_bulletin_information_user_id` FOREIGN KEY (`user_id`) REFERENCES `admin_rights` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulletin_information`
--

LOCK TABLES `bulletin_information` WRITE;
/*!40000 ALTER TABLE `bulletin_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `bulletin_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facial_feature`
--

DROP TABLE IF EXISTS `facial_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facial_feature` (
  `facial_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `storage_uri` varchar(2050) NOT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`facial_id`),
  KEY `fk_user_idm_idx` (`user_id`),
  CONSTRAINT `fk_facial_feature_user_idm` FOREIGN KEY (`user_id`) REFERENCES `member_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_facial_feature_user_idt` FOREIGN KEY (`user_id`) REFERENCES `teacher_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facial_feature`
--

LOCK TABLES `facial_feature` WRITE;
/*!40000 ALTER TABLE `facial_feature` DISABLE KEYS */;
/*!40000 ALTER TABLE `facial_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fingerprint_feature`
--

DROP TABLE IF EXISTS `fingerprint_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fingerprint_feature` (
  `fingerprint_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `storage_uri` varchar(2050) NOT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`fingerprint_id`),
  KEY `fk_fingerprint_feature_user_idm_idx` (`user_id`),
  CONSTRAINT `fk_fingerprint_feature_user_idm` FOREIGN KEY (`user_id`) REFERENCES `member_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_fingerprint_feature_user_idt` FOREIGN KEY (`user_id`) REFERENCES `teacher_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fingerprint_feature`
--

LOCK TABLES `fingerprint_feature` WRITE;
/*!40000 ALTER TABLE `fingerprint_feature` DISABLE KEYS */;
/*!40000 ALTER TABLE `fingerprint_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_information`
--

DROP TABLE IF EXISTS `member_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_information` (
  `user_id` char(10) NOT NULL,
  `student_id` varchar(2050) DEFAULT NULL,
  `name` varchar(2050) NOT NULL,
  `email` varchar(2050) NOT NULL,
  `password` char(129) NOT NULL,
  `verification_code` char(40) DEFAULT NULL,
  `validation_code_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `phone_number` varchar(2050) DEFAULT NULL,
  `qq` varchar(2050) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `grade` varchar(2050) DEFAULT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_information`
--

LOCK TABLES `member_information` WRITE;
/*!40000 ALTER TABLE `member_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_learning_records`
--

DROP TABLE IF EXISTS `member_learning_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_learning_records` (
  `record_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `title` varchar(2050) NOT NULL,
  `content` varchar(2050) NOT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  `release_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`record_id`),
  KEY `fk_Member_learning_records_user_idm_idx` (`user_id`),
  CONSTRAINT `fk_Member_learning_records_user_idm` FOREIGN KEY (`user_id`) REFERENCES `member_information` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Member_learning_records_user_idt` FOREIGN KEY (`user_id`) REFERENCES `teacher_information` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_learning_records`
--

LOCK TABLES `member_learning_records` WRITE;
/*!40000 ALTER TABLE `member_learning_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_learning_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission_release`
--

DROP TABLE IF EXISTS `mission_release`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mission_release` (
  `mission_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `title` varchar(2050) NOT NULL,
  `content` varchar(2050) NOT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  `grade` varchar(2050) NOT NULL,
  `storage_uri` varchar(2050) DEFAULT NULL,
  `release_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expire_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`mission_id`),
  KEY `fk_mission_release_user_id_idx` (`user_id`),
  CONSTRAINT `fk_mission_release_user_id` FOREIGN KEY (`user_id`) REFERENCES `admin_rights` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission_release`
--

LOCK TABLES `mission_release` WRITE;
/*!40000 ALTER TABLE `mission_release` DISABLE KEYS */;
/*!40000 ALTER TABLE `mission_release` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission_score`
--

DROP TABLE IF EXISTS `mission_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mission_score` (
  `score_id` char(10) NOT NULL,
  `submission_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `score` varchar(2050) NOT NULL,
  `comment` varchar(2050) DEFAULT NULL,
  `score_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`score_id`),
  KEY `fk_mission_score_submission_id_idx` (`submission_id`),
  KEY `fk_mission_score_user_id_idx` (`user_id`),
  CONSTRAINT `fk_mission_score_submission_id` FOREIGN KEY (`submission_id`) REFERENCES `mission_submission` (`submission_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mission_score_user_id` FOREIGN KEY (`user_id`) REFERENCES `admin_rights` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission_score`
--

LOCK TABLES `mission_score` WRITE;
/*!40000 ALTER TABLE `mission_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `mission_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission_submission`
--

DROP TABLE IF EXISTS `mission_submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mission_submission` (
  `submission_id` char(10) NOT NULL,
  `mission_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `content` varchar(2050) DEFAULT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  `storage_uri` varchar(2050) NOT NULL,
  `submission_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`submission_id`),
  KEY `fk_mission_submission_user_id_idx` (`user_id`),
  CONSTRAINT `fk_mission_submission_mission_id` FOREIGN KEY (`submission_id`) REFERENCES `mission_release` (`mission_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mission_submission_user_id` FOREIGN KEY (`user_id`) REFERENCES `member_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission_submission`
--

LOCK TABLES `mission_submission` WRITE;
/*!40000 ALTER TABLE `mission_submission` DISABLE KEYS */;
/*!40000 ALTER TABLE `mission_submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punch_the_clock`
--

DROP TABLE IF EXISTS `punch_the_clock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `punch_the_clock` (
  `punch_id` char(10) NOT NULL,
  `user_id` char(10) NOT NULL,
  `punch_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `punch_location` varchar(2050) DEFAULT NULL,
  `punch_ip` varchar(2050) DEFAULT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  PRIMARY KEY (`punch_id`),
  KEY `fk_punch_the_clock_user_id` (`user_id`),
  CONSTRAINT `fk_punch_the_clock_user_id` FOREIGN KEY (`user_id`) REFERENCES `member_information` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punch_the_clock`
--

LOCK TABLES `punch_the_clock` WRITE;
/*!40000 ALTER TABLE `punch_the_clock` DISABLE KEYS */;
/*!40000 ALTER TABLE `punch_the_clock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_information`
--

DROP TABLE IF EXISTS `teacher_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_information` (
  `user_id` char(10) NOT NULL,
  `staff_id` varchar(2050) DEFAULT NULL,
  `name` varchar(2050) NOT NULL,
  `email` varchar(2050) NOT NULL,
  `password` char(129) NOT NULL,
  `verification_code` char(40) DEFAULT NULL,
  `validation_code_update_time` timestamp NULL DEFAULT NULL,
  `phone_number` varchar(2050) DEFAULT NULL,
  `qq` varchar(2050) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_information`
--

LOCK TABLES `teacher_information` WRITE;
/*!40000 ALTER TABLE `teacher_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!50001 DROP VIEW IF EXISTS `user_information`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_information` AS SELECT 
 1 AS `user_id`,
 1 AS `email`,
 1 AS `password`,
 1 AS `verification_code`,
 1 AS `is_effective`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `user_information`
--

/*!50001 DROP VIEW IF EXISTS `user_information`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`studio`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `user_information` AS select `member_information`.`user_id` AS `user_id`,`member_information`.`email` AS `email`,`member_information`.`password` AS `password`,`member_information`.`verification_code` AS `verification_code`,`member_information`.`is_effective` AS `is_effective` from `member_information` union select `teacher_information`.`user_id` AS `user_id`,`teacher_information`.`email` AS `email`,`teacher_information`.`password` AS `password`,`teacher_information`.`verification_code` AS `verification_code`,`teacher_information`.`is_effective` AS `is_effective` from `teacher_information` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-06  8:23:44
