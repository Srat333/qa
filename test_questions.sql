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
  `question_uid` bigint(20) DEFAULT NULL,
  `q_content` longtext,
  `create_time` datetime DEFAULT NULL,
  `tag` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `q_title` varchar(45) DEFAULT NULL,
  `pid` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,NULL,'谁是2020 NBA总冠军?','2020-06-30 21:41:35','湖人队',0.99,NULL,NULL,NULL),(2,111,'吴亦凡发明了什么？','2020-07-01 11:30:22','无线充电',0.99,NULL,NULL,NULL),(3,111,'TLOU2为什么这么烂','2020-07-01 11:31:44','diversity',0.99,NULL,NULL,NULL),(4,111,'p4G的凶手是谁','2020-07-01 11:32:33','菜菜子',0.99,NULL,NULL,NULL),(5,111,'2020欧冠冠军是谁?','2020-07-01 11:33:40','AC Milan',0.99,NULL,NULL,NULL),(6,111,'创造营谁会出道？','2020-07-01 11:34:52','atm',0.99,NULL,NULL,NULL),(8,111,'脑瘫♿️','2020-07-01 11:37:01','snh48 SII',0.99,'张艺凡的外号是什么',NULL,NULL),(9,111,'泪失禁纯恶心人','2020-07-04 15:32:00','黑幕',0.99,'张艺凡赶紧爬',NULL,'偶像');
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

-- Dump completed on 2020-07-04 18:55:35
