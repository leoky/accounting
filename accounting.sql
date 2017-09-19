-- MySQL dump 10.13  Distrib 5.5.24, for Win64 (x86)
--
-- Host: localhost    Database: accounting
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `chart`
--

DROP TABLE IF EXISTS `chart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chart` (
  `chart_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `chart_name` varchar(45) NOT NULL,
  `chart_comment` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`chart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6011 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chart`
--

LOCK TABLES `chart` WRITE;
/*!40000 ALTER TABLE `chart` DISABLE KEYS */;
INSERT INTO `chart` VALUES (1010,'cash',''),(1020,'bank',''),(1030,'account receivable',''),(1050,'tax out',''),(2020,'account payable',''),(4010,'sales income',''),(4020,'sales discount',''),(4030,'sales return',''),(5110,'purchasing',''),(5120,'purchasing discount',''),(5130,'purchasing return',''),(5210,'beginning inventory',''),(5220,'ending inventory',''),(6010,'general expenditure','');
/*!40000 ALTER TABLE `chart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cust_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(30) DEFAULT NULL,
  `cust_company` varchar(30) DEFAULT NULL,
  `cust_phone` varchar(15) DEFAULT NULL,
  `cust_address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'leonardy','leoky','082168311576','jln. siantar no 4'),(2,'leo','leo','123','leo');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `inventory_id` varchar(10) NOT NULL,
  `jurnal_date` date NOT NULL,
  `jurnal_id` varchar(45) NOT NULL,
  `product_name` varchar(45) NOT NULL,
  `p_qty` int(10) unsigned NOT NULL,
  `p_price` int(10) unsigned NOT NULL,
  `p_value` int(10) unsigned NOT NULL,
  `s_qty` int(10) unsigned NOT NULL,
  `s_price` int(10) unsigned NOT NULL,
  `s_value` int(10) unsigned NOT NULL,
  `type` varchar(45) NOT NULL,
  `people` varchar(45) NOT NULL,
  `discount` double NOT NULL,
  `tax` double NOT NULL,
  `price` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('P1','2000-01-01','J1','pen',50,2200,110000,0,0,0,'purchase','leonardy',0,0,2200),('S1','2000-01-02','J2','pen',0,0,0,20,10000,200000,'sales','leonardy',0,0,10000),('P2','2000-01-03','J3','book',100,30000,3000000,0,0,0,'purchase','leonardy',0,0,30000);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `i_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `inventory_id` varchar(10) NOT NULL,
  `jurnal_date` date NOT NULL,
  `jurnal_id` varchar(10) NOT NULL,
  `payment_id` varchar(10) NOT NULL,
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,'P1','2000-01-01','J1','Y1'),(2,'S1','2000-01-02','J2','Y2'),(3,'P2','2000-01-03','J3','Y3');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jurnal`
--

DROP TABLE IF EXISTS `jurnal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jurnal` (
  `jurnal_id` varchar(10) NOT NULL,
  `jurnal_date` date NOT NULL,
  `chart_no` int(11) NOT NULL,
  `chart_name` varchar(45) NOT NULL,
  `debit` int(11) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jurnal`
--

LOCK TABLES `jurnal` WRITE;
/*!40000 ALTER TABLE `jurnal` DISABLE KEYS */;
INSERT INTO `jurnal` VALUES ('J1','2000-01-01',5110,'purchasing',110000,0,''),('J1','2000-01-01',1010,'cash',0,44000,''),('J1','2000-01-01',2020,'account payable',0,66000,''),('J2','2000-01-02',4010,'sales income',0,200000,''),('J2','2000-01-02',1030,'account receivable',200000,0,''),('J3','2000-01-03',5110,'purchasing',3000000,0,''),('J3','2000-01-03',1010,'cash',0,3000000,'');
/*!40000 ALTER TABLE `jurnal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `y_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `payment_id` varchar(20) NOT NULL,
  `payment_type` varchar(10) NOT NULL,
  `jurnal_date` date NOT NULL,
  `jurnal_id` varchar(10) NOT NULL,
  `payment_percent` double NOT NULL,
  `payment_value` double NOT NULL,
  PRIMARY KEY (`y_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'Y1','CASH','2000-01-01','J1',40,44000),(2,'Y1','CREDIT','2000-01-01','J1',60,66000),(3,'Y2','CREDIT','2000-01-02','J2',0,200000),(4,'Y3','CASH','2000-01-03','J3',0,3000000);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `Jurnal_date` date NOT NULL,
  `Jurnal_id` varchar(45) NOT NULL,
  `Product_name` varchar(45) NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` int(10) unsigned NOT NULL,
  `value` int(10) unsigned NOT NULL,
  `type` varchar(45) NOT NULL,
  `people` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES ('2000-01-06','0','pen',0,10000,100000,'purchase','leonardy'),('2000-01-07','0','pen',0,1111,3333,'sales','leonardy'),('2000-01-09','0','pen',0,1000,5000,'purchase','leonardy'),('2000-01-10','0','pen',0,10000,310000,'purchase','leonardy'),('2000-01-13','0','book',0,1000,5000,'purchase','leonardy'),('2000-01-14','0','book',0,100000,4000000,'purchase','leonardy'),('2020-02-02','0','12',0,12,12,'12','12');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `product_comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'pen',''),(2,'book',''),(3,'era','');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `p_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `jurnal_date` date NOT NULL,
  `jurnal_id` varchar(45) NOT NULL,
  `product_name` varchar(45) NOT NULL,
  `p_qty` int(10) unsigned NOT NULL,
  `p_price` int(10) unsigned NOT NULL,
  `p_value` int(10) unsigned NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (1,'2000-01-06','J7','pen',10,10000,100000),(2,'2000-01-07','J8','pen',3,1111,3333);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `sup_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sup_name` varchar(45) DEFAULT NULL,
  `sup_company` varchar(45) DEFAULT NULL,
  `sup_phone` varchar(15) DEFAULT NULL,
  `sup_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system`
--

DROP TABLE IF EXISTS `system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system` (
  `system_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `system_date` date NOT NULL,
  `system_jurnal` int(10) unsigned NOT NULL,
  `system_sales` varchar(5) DEFAULT NULL,
  `system_pur` varchar(5) NOT NULL,
  `system_pay` varchar(5) NOT NULL,
  PRIMARY KEY (`system_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system`
--

LOCK TABLES `system` WRITE;
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
INSERT INTO `system` VALUES (1,'2000-01-01',4,'2','3','4');
/*!40000 ALTER TABLE `system` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-17  7:03:54
