-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_web
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`),
  CONSTRAINT `FKl70asp4l4w0jmbm1tqyofho4o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_product`
--

DROP TABLE IF EXISTS `cart_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_product` (
  `count` int NOT NULL,
  `cart_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlv5x4iresnv4xspvomrwd8ej9` (`cart_id`),
  KEY `FK2kdlr8hs2bwl14u8oop49vrxi` (`product_id`),
  CONSTRAINT `FK2kdlr8hs2bwl14u8oop49vrxi` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKlv5x4iresnv4xspvomrwd8ej9` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_product`
--

LOCK TABLES `cart_product` WRITE;
/*!40000 ALTER TABLE `cart_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_product_seq`
--

DROP TABLE IF EXISTS `cart_product_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_product_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_product_seq`
--

LOCK TABLES `cart_product_seq` WRITE;
/*!40000 ALTER TABLE `cart_product_seq` DISABLE KEYS */;
INSERT INTO `cart_product_seq` VALUES (1);
/*!40000 ALTER TABLE `cart_product_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_seq`
--

DROP TABLE IF EXISTS `cart_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_seq`
--

LOCK TABLES `cart_seq` WRITE;
/*!40000 ALTER TABLE `cart_seq` DISABLE KEYS */;
INSERT INTO `cart_seq` VALUES (1);
/*!40000 ALTER TABLE `cart_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faq`
--

DROP TABLE IF EXISTS `faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faq` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKindd77321r69a4vielp3cloel` (`user_id`),
  CONSTRAINT `FKindd77321r69a4vielp3cloel` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faq`
--

LOCK TABLES `faq` WRITE;
/*!40000 ALTER TABLE `faq` DISABLE KEYS */;
/*!40000 ALTER TABLE `faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faq_seq`
--

DROP TABLE IF EXISTS `faq_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faq_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faq_seq`
--

LOCK TABLES `faq_seq` WRITE;
/*!40000 ALTER TABLE `faq_seq` DISABLE KEYS */;
INSERT INTO `faq_seq` VALUES (1);
/*!40000 ALTER TABLE `faq_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `count` int NOT NULL,
  `order_price` int NOT NULL,
  `id` bigint NOT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl5mnj9n0di7k1v90yxnthkc73` (`order_id`),
  KEY `FKhnfgqyjx3i80qoymrssls3kno` (`product_id`),
  CONSTRAINT `FKhnfgqyjx3i80qoymrssls3kno` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKl5mnj9n0di7k1v90yxnthkc73` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product_seq`
--

DROP TABLE IF EXISTS `order_product_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product_seq`
--

LOCK TABLES `order_product_seq` WRITE;
/*!40000 ALTER TABLE `order_product_seq` DISABLE KEYS */;
INSERT INTO `order_product_seq` VALUES (1);
/*!40000 ALTER TABLE `order_product_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_seq`
--

DROP TABLE IF EXISTS `orders_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_seq`
--

LOCK TABLES `orders_seq` WRITE;
/*!40000 ALTER TABLE `orders_seq` DISABLE KEYS */;
INSERT INTO `orders_seq` VALUES (1);
/*!40000 ALTER TABLE `orders_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `amount` int NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `method` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments_seq`
--

DROP TABLE IF EXISTS `payments_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments_seq`
--

LOCK TABLES `payments_seq` WRITE;
/*!40000 ALTER TABLE `payments_seq` DISABLE KEYS */;
INSERT INTO `payments_seq` VALUES (1);
/*!40000 ALTER TABLE `payments_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `is_delete` bit(1) DEFAULT NULL,
  `price` int NOT NULL,
  `sales` int NOT NULL,
  `stock` int NOT NULL,
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (_binary '\0',111,0,111,1,'BLACK_상의_S','TOP','BLACK','S'),(_binary '\0',111,0,111,2,'BLACK_상의_M','TOP','BLACK','M'),(_binary '\0',111,0,111,3,'BLACK_상의_L','TOP','BLACK','L'),(_binary '\0',111,0,111,4,'BLACK_하의_S','BOTTOM','BLACK','S'),(_binary '\0',111,0,111,5,'BLACK_하의_M','BOTTOM','BLACK','M'),(_binary '\0',1,0,1,6,'BLACK_하의_L','BOTTOM','BLACK','L'),(_binary '\0',1,0,1,7,'BLACK_반팔티_S','T-SHIRTS','BLACK','S'),(_binary '\0',1,0,111,8,'BLACK_반팔티_M','T-SHIRTS','BLACK','M'),(_binary '\0',111,0,111,9,'BLACK_반팔티_L','T-SHIRTS','BLACK','L'),(_binary '\0',111,0,111,10,'BLACK_셔츠_S','SHIRTS','BLACK','S'),(_binary '\0',111,0,111,11,'BLACK_셔츠_M','SHIRTS','BLACK','M'),(_binary '\0',111,0,111,12,'BLACK_셔츠_L','SHIRTS','BLACK','L'),(_binary '\0',111,0,111,13,'BLACK_아우터_S','OUTER','BLACK','S'),(_binary '\0',111,0,111,14,'BLACK_아우터_M','OUTER','BLACK','L'),(_binary '\0',111,0,111,15,'BLACK_아우터_L','OUTER','BLACK','L'),(_binary '\0',111,0,111,16,'BLACK_신발_260','SHOES','BLACK','260'),(_binary '\0',111,0,111,17,'BLACK_신발_265','SHOES','BLACK','265'),(_binary '\0',111,0,111,18,'BLACK_ACC_기타','ACC','BLACK','기타');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_img`
--

DROP TABLE IF EXISTS `product_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_img` (
  `id` bigint NOT NULL,
  `product_id` bigint DEFAULT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `ori_img_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbnvmhern60vx5hlvaa3ba9u8h` (`product_id`),
  CONSTRAINT `FKbnvmhern60vx5hlvaa3ba9u8h` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_img`
--

LOCK TABLES `product_img` WRITE;
/*!40000 ALTER TABLE `product_img` DISABLE KEYS */;
INSERT INTO `product_img` VALUES (1,1,'a8a90564-5a29-46ed-81eb-a0b11d34b23b.png','/img/productImg/a8a90564-5a29-46ed-81eb-a0b11d34b23b.png','옷메인.png'),(2,1,'','',''),(3,1,'','',''),(4,1,'','',''),(5,1,'','',''),(6,2,'90c79e50-09cf-479f-85d9-0ac6c2e50cfa.png','/img/productImg/90c79e50-09cf-479f-85d9-0ac6c2e50cfa.png','옷메인.png'),(7,2,'','',''),(8,2,'','',''),(9,2,'','',''),(10,2,'','',''),(11,3,'ddc2cab5-05c7-4dd7-bed0-e9d6d84ecc47.png','/img/productImg/ddc2cab5-05c7-4dd7-bed0-e9d6d84ecc47.png','옷메인.png'),(12,3,'','',''),(13,3,'','',''),(14,3,'','',''),(15,3,'','',''),(16,4,'2d4e7e83-dea8-4d22-a1c0-3a7d026b1af6.png','/img/productImg/2d4e7e83-dea8-4d22-a1c0-3a7d026b1af6.png','옷메인.png'),(17,4,'','',''),(18,4,'','',''),(19,4,'','',''),(20,4,'','',''),(21,5,'3c405f6b-5d8b-46e5-84b9-ab33d30a4d8e.png','/img/productImg/3c405f6b-5d8b-46e5-84b9-ab33d30a4d8e.png','옷메인.png'),(22,5,'','',''),(23,5,'','',''),(24,5,'','',''),(25,5,'','',''),(26,6,'66b0d06f-f05b-4675-b854-c034b01f84a8.png','/img/productImg/66b0d06f-f05b-4675-b854-c034b01f84a8.png','옷메인.png'),(27,6,'','',''),(28,6,'','',''),(29,6,'','',''),(30,6,'','',''),(31,7,'07a695f4-1b20-4440-97c2-239f588208f3.png','/img/productImg/07a695f4-1b20-4440-97c2-239f588208f3.png','옷메인.png'),(32,7,'','',''),(33,7,'','',''),(34,7,'','',''),(35,7,'','',''),(36,8,'942e6dcf-fda5-4af1-a57b-4da5e876da6d.png','/img/productImg/942e6dcf-fda5-4af1-a57b-4da5e876da6d.png','옷메인.png'),(37,8,'','',''),(38,8,'','',''),(39,8,'','',''),(40,8,'','',''),(41,9,'e189e28b-d18c-4586-a6c1-23c3686912de.png','/img/productImg/e189e28b-d18c-4586-a6c1-23c3686912de.png','옷메인.png'),(42,9,'','',''),(43,9,'','',''),(44,9,'','',''),(45,9,'','',''),(46,10,'01caa9fd-487c-4526-9e00-cfecc323e31a.png','/img/productImg/01caa9fd-487c-4526-9e00-cfecc323e31a.png','옷메인.png'),(47,10,'','',''),(48,10,'','',''),(49,10,'','',''),(50,10,'','',''),(51,11,'479c7b2e-d104-47ff-8326-03baf90e6a86.png','/img/productImg/479c7b2e-d104-47ff-8326-03baf90e6a86.png','옷메인.png'),(52,11,'','',''),(53,11,'','',''),(54,11,'','',''),(55,11,'','',''),(56,12,'4b91f7aa-d368-4fd0-8201-25f4f72ca36b.png','/img/productImg/4b91f7aa-d368-4fd0-8201-25f4f72ca36b.png','옷메인.png'),(57,12,'','',''),(58,12,'','',''),(59,12,'','',''),(60,12,'','',''),(61,13,'bf6c04fb-6391-47d8-8036-8ec3da398fc7.png','/img/productImg/bf6c04fb-6391-47d8-8036-8ec3da398fc7.png','옷메인.png'),(62,13,'','',''),(63,13,'','',''),(64,13,'','',''),(65,13,'','',''),(66,14,'273a3b9c-5183-4498-832e-6653d65a9e59.png','/img/productImg/273a3b9c-5183-4498-832e-6653d65a9e59.png','옷메인.png'),(67,14,'','',''),(68,14,'','',''),(69,14,'','',''),(70,14,'','',''),(71,15,'53b096db-3d3e-49c6-9d5d-0929be65b513.png','/img/productImg/53b096db-3d3e-49c6-9d5d-0929be65b513.png','옷메인.png'),(72,15,'','',''),(73,15,'','',''),(74,15,'','',''),(75,15,'','',''),(76,16,'057d72c9-de34-44ae-b69f-11fa85184d90.png','/img/productImg/057d72c9-de34-44ae-b69f-11fa85184d90.png','옷메인.png'),(77,16,'','',''),(78,16,'','',''),(79,16,'','',''),(80,16,'','',''),(81,17,'32667f26-3538-4c19-9dc4-d25a32f806e2.png','/img/productImg/32667f26-3538-4c19-9dc4-d25a32f806e2.png','옷메인.png'),(82,17,'','',''),(83,17,'','',''),(84,17,'','',''),(85,17,'','',''),(86,18,'834b84a0-1223-4b5c-bcd6-da2a2e733cc8.png','/img/productImg/834b84a0-1223-4b5c-bcd6-da2a2e733cc8.png','옷메인.png'),(87,18,'','',''),(88,18,'','',''),(89,18,'','',''),(90,18,'','','');
/*!40000 ALTER TABLE `product_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_img_seq`
--

DROP TABLE IF EXISTS `product_img_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_img_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_img_seq`
--

LOCK TABLES `product_img_seq` WRITE;
/*!40000 ALTER TABLE `product_img_seq` DISABLE KEYS */;
INSERT INTO `product_img_seq` VALUES (151);
/*!40000 ALTER TABLE `product_img_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_seq`
--

DROP TABLE IF EXISTS `product_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_seq`
--

LOCK TABLES `product_seq` WRITE;
/*!40000 ALTER TABLE `product_seq` DISABLE KEYS */;
INSERT INTO `product_seq` VALUES (101);
/*!40000 ALTER TABLE `product_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ekrlbqiybwk8abhgclfjwnmc` (`user_id`),
  CONSTRAINT `FK4ekrlbqiybwk8abhgclfjwnmc` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_seq`
--

DROP TABLE IF EXISTS `question_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_seq`
--

LOCK TABLES `question_seq` WRITE;
/*!40000 ALTER TABLE `question_seq` DISABLE KEYS */;
INSERT INTO `question_seq` VALUES (1);
/*!40000 ALTER TABLE `question_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend`
--

DROP TABLE IF EXISTS `recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommend` (
  `category_acc` int NOT NULL,
  `category_bottom` int NOT NULL,
  `category_outer` int NOT NULL,
  `category_shirt` int NOT NULL,
  `category_shoes` int NOT NULL,
  `category_t_shirt` int NOT NULL,
  `category_top` int NOT NULL,
  `color_black` int NOT NULL,
  `color_default` int NOT NULL,
  `color_white` int NOT NULL,
  `size_260` int NOT NULL,
  `size_265` int NOT NULL,
  `size_270` int NOT NULL,
  `size_275` int NOT NULL,
  `size_280` int NOT NULL,
  `size_285` int NOT NULL,
  `size_default` int NOT NULL,
  `size_l` int NOT NULL,
  `size_m` int NOT NULL,
  `size_s` int NOT NULL,
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdtris2o3j7avu24cng8m2gs6i` (`user_id`),
  CONSTRAINT `FKdtris2o3j7avu24cng8m2gs6i` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
INSERT INTO `recommend` VALUES (0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1),(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2);
/*!40000 ALTER TABLE `recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend_seq`
--

DROP TABLE IF EXISTS `recommend_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommend_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend_seq`
--

LOCK TABLES `recommend_seq` WRITE;
/*!40000 ALTER TABLE `recommend_seq` DISABLE KEYS */;
INSERT INTO `recommend_seq` VALUES (101);
/*!40000 ALTER TABLE `recommend_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `used`
--

DROP TABLE IF EXISTS `used`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `used` (
  `price` int NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `order_product_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc3eso9f7cjfvm8co727e1vb29` (`order_product_id`),
  CONSTRAINT `FKc3eso9f7cjfvm8co727e1vb29` FOREIGN KEY (`order_product_id`) REFERENCES `order_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `used`
--

LOCK TABLES `used` WRITE;
/*!40000 ALTER TABLE `used` DISABLE KEYS */;
/*!40000 ALTER TABLE `used` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `used_img`
--

DROP TABLE IF EXISTS `used_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `used_img` (
  `id` bigint NOT NULL,
  `used_id` bigint DEFAULT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `ori_img_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3vn5x6sul4mx48b6v0ti6fb72` (`used_id`),
  CONSTRAINT `FK3vn5x6sul4mx48b6v0ti6fb72` FOREIGN KEY (`used_id`) REFERENCES `used` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `used_img`
--

LOCK TABLES `used_img` WRITE;
/*!40000 ALTER TABLE `used_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `used_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `used_img_seq`
--

DROP TABLE IF EXISTS `used_img_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `used_img_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `used_img_seq`
--

LOCK TABLES `used_img_seq` WRITE;
/*!40000 ALTER TABLE `used_img_seq` DISABLE KEYS */;
INSERT INTO `used_img_seq` VALUES (1);
/*!40000 ALTER TABLE `used_img_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `used_seq`
--

DROP TABLE IF EXISTS `used_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `used_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `used_seq`
--

LOCK TABLES `used_seq` WRITE;
/*!40000 ALTER TABLE `used_seq` DISABLE KEYS */;
INSERT INTO `used_seq` VALUES (1);
/*!40000 ALTER TABLE `used_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usedcomment`
--

DROP TABLE IF EXISTS `usedcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usedcomment` (
  `id` bigint NOT NULL,
  `reply_user_id` bigint DEFAULT NULL,
  `used_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnc507avq77hptjqkgy07nrv4n` (`reply_user_id`),
  KEY `FKiigx316t0wdk37bvv1dlo5ksc` (`used_id`),
  KEY `FKk9fyuaok2ucmb0ero7i2umxi4` (`user_id`),
  CONSTRAINT `FKiigx316t0wdk37bvv1dlo5ksc` FOREIGN KEY (`used_id`) REFERENCES `used` (`id`),
  CONSTRAINT `FKk9fyuaok2ucmb0ero7i2umxi4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKnc507avq77hptjqkgy07nrv4n` FOREIGN KEY (`reply_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usedcomment`
--

LOCK TABLES `usedcomment` WRITE;
/*!40000 ALTER TABLE `usedcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `usedcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usedcomment_seq`
--

DROP TABLE IF EXISTS `usedcomment_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usedcomment_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usedcomment_seq`
--

LOCK TABLES `usedcomment_seq` WRITE;
/*!40000 ALTER TABLE `usedcomment_seq` DISABLE KEYS */;
INSERT INTO `usedcomment_seq` VALUES (1);
/*!40000 ALTER TABLE `usedcomment_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `enabled` bit(1) DEFAULT NULL,
  `id` bigint NOT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` enum('FEMALE','MALE') DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary '',1,'서울 강남구 밤고개로23길 6 (율현동) 23','user@user',NULL,'user','$2a$10$9pCYVSmRG2REQtff6x0uF.MlnlnGto7dAz22u87HNdK.eprHlDvW6','01067873947','user'),(_binary '',2,'서울 송파구 가락로11길 5-3 (석촌동) 2323','admin@admin',NULL,'admin','$2a$10$JNzq0eXvWHQwiNx/sWdU3uybATQoOdnCnQGomkiRjQ6EYlx0A0QMO','admin','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK2oqpqfi5ut3xylw61wqhl5ggo` (`id`),
  CONSTRAINT `FK2oqpqfi5ut3xylw61wqhl5ggo` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (101);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-09 14:49:31
