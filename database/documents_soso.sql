-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: documents_soso
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `documents`
--

DROP TABLE IF EXISTS `documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documents` (
  `id` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(4) COLLATE utf8mb4_general_ci NOT NULL,
  `upload_date` date NOT NULL,
  `upload_user` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `download_times` int NOT NULL,
  `size` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `documents_pk2` (`id`),
  KEY `documents_users_name_fk` (`upload_user`),
  CONSTRAINT `documents_users_name_fk` FOREIGN KEY (`upload_user`) REFERENCES `users` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documents`
--

LOCK TABLES `documents` WRITE;
/*!40000 ALTER TABLE `documents` DISABLE KEYS */;
INSERT INTO `documents` VALUES ('9fxDj494yF','Java浼佷笟绾ч」鐩疄璁?璇剧▼璁捐鎶ュ憡-妯℃澘','docx','2023-01-05','cElTtJKvka',19,'26.32KB'),('BZZuqfYwGY','闄勪欢2锛氥€婁笂娴峰簲鐢ㄦ妧鏈ぇ瀛﹀鐢熷绉戞妧鑳界珵璧涘鍔辨潯渚嬨€嬩笂搴斿[2017]74鍙锋枃','doc','2023-01-05','C9de4Y8O0M',10,'33.50KB'),('JnWJUlWstC','Java浼佷笟绾ч」鐩疄璁?鎸囧涔?,'pdf','2023-01-05','cElTtJKvka',28,'674.20KB'),('L9BmuQRMBv','銆婂鐢熸墜鍐?2路鏈銆嬪唴椤?729','pdf','2023-01-05','JPoc2ddJ2Q',2,'5.59MB'),('YGhPJcUUm9','銆婂鐢熸墜鍐?2路鏈銆嬪唴椤?729','pdf','2023-01-05','JPoc2ddJ2Q',0,'5.59MB');
/*!40000 ALTER TABLE `documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `name` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `users_pk2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('4EpJpiJDt7','5456465'),('4Kb2qlQrla','jjjjjjjj'),('azp54o8eJr','32132131'),('BzQdHhGb4l','11111111'),('C9de4Y8O0M','53453453'),('cElTtJKvka','sfsdfsdf'),('Cj7Uer3Run','1321312'),('Ew0iHn0ooX','dsfsdfsd'),('FWi6BvraNQ','12432333'),('fx6jnFPgxE','fsdfdsds'),('JPoc2ddJ2Q','fsdsdfsd'),('KSWM528Z5d','44444444'),('n15YjQ2ekO','33333333'),('Nwvgduk3Io','45646546'),('ogOLA1WeCg','11111111'),('ouDCWkvXn5','kkkkkkkk'),('Q6qtxvp2nj','22222222'),('ro3B3ApN5d','11111111'),('RZPvOrDJE7','11111111'),('ty1uRDOKHm','32132141'),('uTB1JNDFe2','11111111'),('Xjpa19Q5r3','12132121');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-08 13:07:39
