-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `questions` (
  `qid` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_uid` varchar(45) DEFAULT NULL,
  `q_content` longtext,
  `create_time` datetime DEFAULT NULL,
  `tag` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `q_title` varchar(45) DEFAULT NULL,
  `pid` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `audits` varchar(45) DEFAULT NULL,
  `is_answered` int(11) DEFAULT NULL,
  `is_commented` int(11) DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'111','test-101','2020-08-06 15:39:35','test-101',0.99,'testing-updated-101',NULL,'test-101',NULL,NULL,NULL),(2,'testuser','question-102-updated','2020-08-07 12:26:32','test-102',0.99,'testing-102-updated',NULL,'test-102','nulltestuser2,',NULL,NULL),(3,'testuser3','question-103-updated','2020-08-07 12:39:14','test-103',0.99,'testing-103-updated',NULL,'test-103','testuser2,testuser1,',NULL,NULL),(4,'testuser1','question-104-updated-answered','2020-08-09 11:45:22','test-103',0.99,'testing-104-updated-answered',NULL,'test-103',NULL,NULL,NULL),(5,'testuser2','question-105-updated-again','2020-08-10 16:26:48','test-105',0.99,'testing-105-updated-again',NULL,'test-105',NULL,NULL,NULL),(6,'testuser3','question-106','2020-08-10 17:06:56','test-106',0.99,'testing-106',NULL,'test-106',NULL,NULL,NULL),(7,'testuser3','question-106','2020-08-10 17:12:06','test-106',0.99,'testing-106',NULL,'test-106',NULL,NULL,NULL),(8,'testuser3','question-108','2020-08-10 18:40:27','test-108',0.99,'testing-108',NULL,'test-108',NULL,NULL,NULL),(9,'testUser5','test-110','2020-08-10 20:19:29','test-110',0.99,'testing110',NULL,'test-110',NULL,NULL,NULL),(10,'testUser6','test-101','2020-08-10 20:23:15','test-101',0.99,'testing101',NULL,'test-101',NULL,0,0),(11,'testuser1','question-104-updated-answered','2020-08-10 20:32:40','test-103',0.99,'testing-104-updated-answered',NULL,'test-103',NULL,0,0),(12,'testUser6','test-1111','2020-08-10 21:19:30','test-1111',0.99,'testing1111',NULL,'test-1111',NULL,1,1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-10 21:24:46
