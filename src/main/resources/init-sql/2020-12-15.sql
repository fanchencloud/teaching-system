-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: chen
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES UTF8MB3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `content` varchar(2048) NOT NULL DEFAULT '' COMMENT '公告内容',
  `title` varchar(256) NOT NULL DEFAULT '' COMMENT '公告标题',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `flag` int DEFAULT '0' COMMENT '是否发布，0-不发布，1-发布',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appraise`
--

DROP TABLE IF EXISTS `appraise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appraise` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `leader_id` int NOT NULL COMMENT '领导id',
  `teacher_id` int NOT NULL COMMENT '教师id',
  `content` varchar(1024) NOT NULL DEFAULT '' COMMENT '评价内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appraise`
--

LOCK TABLES `appraise` WRITE;
/*!40000 ALTER TABLE `appraise` DISABLE KEYS */;
/*!40000 ALTER TABLE `appraise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `teacher_id` int NOT NULL COMMENT '教师id',
  `capacity` int NOT NULL COMMENT '课程容量',
  `course_name` varchar(256) NOT NULL DEFAULT '' COMMENT '课程名',
  `place` varchar(256) NOT NULL DEFAULT '' COMMENT '上课地点',
  `college` varchar(256) NOT NULL DEFAULT '' COMMENT '所属学院',
  `content` varchar(1024) NOT NULL DEFAULT '' COMMENT '评价内容',
  `start_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开课时间',
  `end_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `type` varchar(64) DEFAULT NULL COMMENT '课程类型',
  `time` varchar(64) DEFAULT NULL COMMENT '上课时间',
  `member` int NOT NULL DEFAULT '0' COMMENT '已选课程的人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,4,3,'操作系统原理','科技楼','信息与安全工程学院','','2020-12-13 20:25:33','2020-12-13 20:25:33','2020-12-13 20:25:33','2020-12-14 23:56:15','科技创新','周一第一大节	',1),(2,4,7,'计算机组成原理','科技楼','信息与安全工程学院','','2020-12-13 20:27:06','2020-12-25 08:00:00','2020-12-13 20:27:06','2020-12-13 20:40:44','专业课','周二第一大节	',0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elective`
--

DROP TABLE IF EXISTS `elective`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elective` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `user_id` int NOT NULL COMMENT '选课用户id',
  `course_id` int NOT NULL COMMENT '课程id',
  `finish` int NOT NULL DEFAULT '0' COMMENT '是否完成：0-未完成，1-完成',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elective`
--

LOCK TABLES `elective` WRITE;
/*!40000 ALTER TABLE `elective` DISABLE KEYS */;
INSERT INTO `elective` VALUES (1,4,1,1,'2020-12-14 23:56:21','2020-12-15 00:56:32');
/*!40000 ALTER TABLE `elective` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionnaire`
--

DROP TABLE IF EXISTS `questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionnaire` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '问卷唯一id',
  `user_id` int NOT NULL COMMENT '评价用户id',
  `teacher_id` int NOT NULL COMMENT '教师id',
  `course_id` int NOT NULL COMMENT '课程id',
  `attitude` int NOT NULL DEFAULT '0' COMMENT '教学态度',
  `content` int NOT NULL DEFAULT '0' COMMENT '教学内容',
  `skill` int NOT NULL DEFAULT '0' COMMENT '教学技巧',
  `effect` int NOT NULL DEFAULT '0' COMMENT '教学效果',
  `feature` int NOT NULL DEFAULT '0' COMMENT '教学特点',
  `total` int NOT NULL DEFAULT '0' COMMENT '总分',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaire`
--

LOCK TABLES `questionnaire` WRITE;
/*!40000 ALTER TABLE `questionnaire` DISABLE KEYS */;
INSERT INTO `questionnaire` VALUES (1,2,4,2,5,5,5,5,5,25,'2020-12-13 22:19:25','2020-12-13 22:19:25');
/*!40000 ALTER TABLE `questionnaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervision`
--

DROP TABLE IF EXISTS `supervision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supervision` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `user_id` int NOT NULL COMMENT '选课用户id',
  `amount` int NOT NULL COMMENT '任务总量',
  `finish` int NOT NULL DEFAULT '0' COMMENT '完成数量',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervision`
--

LOCK TABLES `supervision` WRITE;
/*!40000 ALTER TABLE `supervision` DISABLE KEYS */;
INSERT INTO `supervision` VALUES (1,4,12,0,'2020-12-14 23:29:42','2020-12-14 23:29:42');
/*!40000 ALTER TABLE `supervision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `username` varchar(256) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) DEFAULT '123456' COMMENT '用户密码',
  `name` varchar(256) DEFAULT '' COMMENT '用户名字',
  `user_type` int NOT NULL DEFAULT '0' COMMENT '用户类别：0-教师，1-专家，2-领导，3-管理员',
  `level` int NOT NULL DEFAULT '0' COMMENT '用户级别：0-院级，1-校级',
  `sex` varchar(4) NOT NULL DEFAULT '男' COMMENT '用户性别',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `birthday` varchar(16) DEFAULT NULL COMMENT '出生日期',
  `address` varchar(64) DEFAULT NULL COMMENT '地址',
  `age` int DEFAULT '0' COMMENT '年龄',
  `phone` varchar(11) DEFAULT NULL COMMENT ' 电话',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_AREA` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'chen','123456','fanchen',3,1,'男','2020-12-13 12:02:53','2020-12-13 18:48:02','2020-6-9','北极',18,NULL),(2,'test','123456','测试用户1',2,0,'女','2020-12-13 18:49:32','2020-12-13 19:59:32','1997-11-9','我不在南极',36,'18820369658'),(3,'chen1','123456','1',1,1,'男','2020-12-13 12:02:53','2020-12-13 18:59:35','2020-6-9','北极33',18,NULL),(4,'good','123456','尘',0,0,'男',NULL,NULL,'1987-3-6','测试地址',21,'13675899647'),(5,'yun','123456','尘111',0,0,'男','2020-12-13 11:34:10','2020-12-13 22:18:00','1987-3-6','测试地址',21,'13675899647');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-15  9:24:41
