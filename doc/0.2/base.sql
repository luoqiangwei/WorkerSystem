CREATE DATABASE  IF NOT EXISTS `studio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `studio`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: ovea4    Database: studio
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
  `user_id` char(20) NOT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
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
  `notice_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `title` varchar(2050) NOT NULL,
  `content` varchar(2050) DEFAULT NULL,
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`notice_id`)
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
  `facial_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `storage_uri` varchar(2050) NOT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`facial_id`)
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
  `fingerprint_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `storage_uri` varchar(2050) NOT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`fingerprint_id`)
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
  `user_id` char(20) NOT NULL,
  `student_id` varchar(2050) NOT NULL,
  `name` varchar(2050) DEFAULT NULL,
  `email` varchar(2050) NOT NULL,
  `password` char(129) NOT NULL,
  `verification_code` char(40) DEFAULT NULL,
  `validation_code_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `phone_number` varchar(2050) DEFAULT NULL,
  `qq` varchar(2050) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `grade` varchar(2050) DEFAULT NULL,
  `head_image_uri` varchar(2050) DEFAULT NULL,
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
  `record_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `title` varchar(2050) NOT NULL,
  `content` varchar(2050) NOT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  `release_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`record_id`)
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
  `mission_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `title` varchar(2050) NOT NULL,
  `content` varchar(2050) NOT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  `grade` varchar(2050) NOT NULL,
  `storage_uri` varchar(2050) DEFAULT NULL,
  `release_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expire_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`mission_id`)
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
  `score_id` char(20) NOT NULL,
  `submission_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `score` varchar(2050) NOT NULL,
  `comment` varchar(2050) DEFAULT NULL,
  `score_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`score_id`)
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
  `submission_id` char(20) NOT NULL,
  `mission_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `content` varchar(2050) DEFAULT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  `storage_uri` varchar(2050) NOT NULL,
  `submission_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`submission_id`)
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
  `punch_id` char(20) NOT NULL,
  `user_id` char(20) NOT NULL,
  `punch_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `punch_location` varchar(2050) DEFAULT NULL,
  `punch_ip` varchar(2050) DEFAULT NULL,
  `remarks` varchar(2050) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`punch_id`)
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
  `user_id` char(20) NOT NULL,
  `staff_id` varchar(2050) NOT NULL,
  `name` varchar(2050) DEFAULT NULL,
  `email` varchar(2050) NOT NULL,
  `password` char(129) NOT NULL,
  `verification_code` char(40) DEFAULT NULL,
  `validation_code_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `phone_number` varchar(2050) DEFAULT NULL,
  `qq` varchar(2050) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `head_image_uri` varchar(2050) DEFAULT NULL,
  `is_effective` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_information`
--

LOCK TABLES `teacher_information` WRITE;
/*!40000 ALTER TABLE `teacher_information` DISABLE KEYS */;
INSERT INTO `teacher_information` VALUES ('fffa8e8b56b3e8c6','785c7c7ee0ab255752655095af43e065bedd56567256d942e754319811ea09703aa00077d16291a8c3cd84debf7ba22eb6abefa6dc6c2ce20a7d1eba1b13436ffe40b95db4baafd956362ff9d7aa375bb55bcf7ca7d3a1d39b936a29bb85e0f4d7ba55b9ec6db2b2404b06ada68c9d6c752131468a693c5da3c848593b7c5714fe19f5848b5db24bcd86cc0f98daef64465efb4f93fe4221716640f642e3834d1f764c3381e6c7614085ed98aa77a8a77f8baa4d5937660cc4c36e51872ac4d25e2ddf25eddb2ed24313055ffc81305cd5f8fcca311d10082d982fca1d4732e7154f60e63f75574818518b1159c31360d9068531cebbb2b88f887fa431f3aa932a49ce3983d29de112019cc1d895f51c34485910a667ed2ad1d2802bcaa75d5e5834db1094f953487eaef6c14716dcc30f4cdf63612d17c7d4301989532bd012927c6f27bdb34e64c1870c7847c6491cc47a114f288db79f994ea572d9453e7b00cef9d2225b4e1772597967882de89f14f0fd6b6575c7f617b53f76ff294f9a2ca82bc50c44ea01473506fcda368eb21df875ccda4dcea1f03750a1a3618638426f87c43a7cf3d97397b0270f7538f30761579c69524568a720d098b5e6bb672789e2389d5dac3e2e811748f3c70836249b3de756ed631b050f8499cbf50015a6118ebf527415a6fc28e8272ce1c81466994530108ab9264959820ac8c0579d79019f8448e82d5ec70d30b108e54c6a67adb9a1b0c79b490b0470c929bb2d7b724855fb9e07aca3908b9199a0e18b938fc69420f43fe9d6c7f8091400cb6c035de0101159327bff5e563e7f475a6b41cc3fcf33b748cb3f113bffbbb4a57179372208bacb2a8dd096d650b2316dc34abfc5bf5fd7cd70ab603b8f909355a9b2feb67516857ba9af2468f9063b8bf38ce7d89e0356eb8cacad4b31e001e5d3f6113ea381554767b9de78cae0ff2d5a428ef57194ddea1f993334ce2b959a1db1621a6013d1a29b2ee7218a453de57e2436269e7e27e8ade1f82f2cb1f7188e6877018d77d73d4a6cd8f0bc69b5ca952b1754002175c84075571aea832ad77eac89b05ebe1d2adce81fcb8aaeafce3fe883fddfc212ff4feb372fb2798e0137d923c481278dfd9397b1eec7529c4659478c038342e78624c98988e431f66592d15de66aec9759c1a3a3023f802f8d0f3ee9b6661e97d95d15800422a4d1513e75ef36478d85b5e480cf6c8fb5f0e725f5224230d2ddaf157474e693e4eeda3f8f65b86d8c2eabf7b2eee997ed04dc61935d519ab6b5bc0dc61486be8d627f316145f45667a5d2379b386f05a0e26a5e72722d3e0dfc65f206a6ef0af519c3c453334e109c753dba42cbf00ca94e45c5374b756ea939c7210926301e41a96b9fa174f7400f1cd7846d3cdcf7bf52c42e8ae8e44aa93e9ffcc2e258fcf0ba12052f',NULL,'6a4ba5ca8751547cf4eaf29ae5d8bc51f342938b6a6cd80bf6840541099edadb3a9ae4da0696c91c9a4ab74e3f83f1c3468219800de8017f29305a9b136b7fda274591b7655f58640bf9f3b548862ed60c2f7b24ffb5822115abdd4d8676238d17122a794e6e1678e4ae8747977ac651f9796a51977b5279ac89b7207b46a68d88592228f37dd1e72484661887c22aa83ea0f6179ec5d0a600a8417a04c98230c6a703291415cc53ffd2ce351cbdb51b74114b3f080de8ab8a3a9ddb0e704679ee5680c7a5959d5ad916b23ffb3684014acde46cd62720937bc3b45c435b5df0a7bb3b90fb0baa252f1538ebbbfc4609996620e5b0e04acb3e9a09b0775439588d877a70126141b5351aca1e91a4b37a598d62cbdb2915dd0aec5a0670a94b805f8e9d0f195af0aa567c15fcfa5abb710f96af8288475ead9bafac3994344400792c3380a9297f0e573c6bfd0dcc37ec60f112d2a875e05e00b9821fa53fc22fc869a1f1b35af8f4926de189c07079840bed248c0e949c320f9d6fa1fcc3413fdff9175ff21d8789578724290ca8b72fa6d9d0950a70e914d91e44bfcb47c97135fce30dea8e4add52eaa0f2ba6594573687daa886273d0161c1889e58472af328dd7b4ba49254ed734cf8ecc1b948a4ea09bd4861b5e99a6690a956166e86bde42a09a4e55e6cf49682c106104f1355684b6d9cc282b6286b1f4fc2d224495415b55da596b84ec4824a1bbba89a37574bf1e986c83fb92701a62c599424cee5be65f7a0a4ee6c927a91f3bc962fb7a7bf41776fcb6c530bf8251176811f15c1ba5a0a1ac723ae4cdddd1d328ae4eb92901c174433cd7231cffb4a0ca5b62b0b3d6ef8fcdbc74384d71f6b4a6e4d9fba3daf9604db67105ce7705db331738929f56da69feb668f03343f12e7730427b12cf00d15a57e935b6c90d878d3304dbaedff781f9dc70cba2b6ee55df0d5553b6b6ee7f622bc6662bbd5b2a1bc01a814e9393e49525c1077176a4499d73dc45027eea42572ebf75f53a29104ea47c7a4af14298910412804243d358e21eafe2f1fce27569077c3f446657814d155882546ec503939122a55185390b5b8af9a3e230b88a62a3d8059886750b4f6099e952f9f576f36e1e9607be0ec044958aabd6433cacd51237db7fb844abe3fceccefe40d1bdc6cc440d03ad734919c92bf439b5b08a889a3a2026f319458f34f2e939b5a12796189f0924a940fba516b2d9c720c0853d680bcc894708e6ed022d206ed069da782ce58340909773743099cd8aecf517beb42999253a5aa39f09dd18e3bfbc59731228cb0dce4507246be2c9267ccbc015bda31494291b24c91bc15026b6b3327d3cab1165b875c3cc764a2c978a30073a6b158b968aab0d58d3eafa63b0ced6e853f9a56e3be8bcf01d0d106241dc4d3d56dea4dccfff8ec37ca393d','62670d1e1eea06b6c975e12bc8a16131b278f6d7bcbe017b65f854c58476baba86c2082b259fd0c1310935b365dc40f609971b6810b065e528b0b60119e69f61',NULL,NULL,NULL,NULL,0,NULL,1);
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
 1 AS `validation_code_update_time`,
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
/*!50001 VIEW `user_information` AS select `member_information`.`user_id` AS `user_id`,`member_information`.`email` AS `email`,`member_information`.`password` AS `password`,`member_information`.`verification_code` AS `verification_code`,`member_information`.`validation_code_update_time` AS `validation_code_update_time`,`member_information`.`is_effective` AS `is_effective` from `member_information` union select `teacher_information`.`user_id` AS `user_id`,`teacher_information`.`email` AS `email`,`teacher_information`.`password` AS `password`,`teacher_information`.`verification_code` AS `verification_code`,`teacher_information`.`validation_code_update_time` AS `validation_code_update_time`,`teacher_information`.`is_effective` AS `is_effective` from `teacher_information` */;
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

-- Dump completed on 2018-08-05 15:22:57
