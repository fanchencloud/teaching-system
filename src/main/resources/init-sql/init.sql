create database if not exists chen;
use chen;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `tb_area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `area`
(
    `area_id`          int(5)       NOT NULL AUTO_INCREMENT,
    `area_name`        varchar(200) NOT NULL,
    `area_description` varchar(1000)         DEFAULT NULL,
    `priority`         int(2)       NOT NULL DEFAULT '0',
    `create_time`      datetime              DEFAULT NULL,
    `last_edit_time`   datetime              DEFAULT NULL,
    PRIMARY KEY (`area_id`),
    UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area`
    DISABLE KEYS */;
INSERT INTO `area`
VALUES (3, '东苑', '东苑', 12, '2017-06-04 19:12:58', '2017-06-04 19:12:58'),
       (4, '南苑', '南苑', 10, '2017-06-04 19:13:09', '2017-06-04 19:13:09'),
       (5, '西苑', '西苑', 9, '2017-06-04 19:13:18', '2017-06-04 19:13:18'),
       (6, '北苑', '北苑', 7, '2017-06-04 19:13:29', '2017-06-04 19:13:29');
/*!40000 ALTER TABLE `area`
    ENABLE KEYS */;
UNLOCK TABLES;