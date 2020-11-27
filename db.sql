create database if not exists dbms;

use dbms;

DROP TABLE IF EXISTS `Brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Brand` (
  `id` varchar(10) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Brand`
--

LOCK TABLES `Brand` WRITE;
/*!40000 ALTER TABLE `Brand` DISABLE KEYS */;
INSERT INTO `Brand` VALUES ('cstrl','engine oil','castrol'),('glf','oil','gulf');
/*!40000 ALTER TABLE `Brand` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `Expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Expenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(15) NOT NULL,
  `date` date NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Expenses`
--

LOCK TABLES `Expenses` WRITE;
/*!40000 ALTER TABLE `Expenses` DISABLE KEYS */;
INSERT INTO `Expenses` VALUES (1,'tax','2019-10-11',5000),(2,'rent','2019-10-12',10000);
/*!40000 ALTER TABLE `Expenses` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (100,'sathyanarayana','9848464815','choppadandi karimnagar'),(102,'saikiran','7896789777','madhuvan'),(103,'praveen','7891718181','madhuvan'),(104,'newo','1234567890','vrindavan'),(105,'mohan','9703364614','gsmc');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `distributor`;

CREATE TABLE `distributor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `GSTIN` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `payment_pending` int(11) DEFAULT NULL,
  `firm_name` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` text,
  `startdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1731 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributor`
--

LOCK TABLES `distributor` WRITE;
/*!40000 ALTER TABLE `distributor` DISABLE KEYS */;
INSERT INTO `distributor` VALUES (1729,'AWER12345OIP','muralidar',5000,'geetha stores','9876543210','9-56/2,geetha nagar,chennai,TN. Pincode=221005','2017-10-13'),(1730,'12345678','newo',23000,NULL,'7896789777','aysdgajdbasjdbasjdbas','2019-10-11');
/*!40000 ALTER TABLE `distributor` ENABLE KEYS */;
UNLOCK TABLES;



DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `dob` date DEFAULT NULL,
  `address` text NOT NULL,
  `aadhar` varchar(30) NOT NULL,
  `wagepermonth` int(11) NOT NULL,
  `phone` char(10) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('krish','krishna','2000-01-01','vrindavan','1234567890',7000,'','employee'),('myempid','madhava','2000-08-22','9-56 street colony cty state','2908323283290320',20000,'1234567890','admin');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `color` varchar(15) DEFAULT NULL,
  `MRP` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `mech_discount` int(11) NOT NULL,
  `brandId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `brandId` (`brandId`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `Brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES ('10mmbolt','10mmboltnout','',10,1100,10,'glf'),('cstrlsctyeng','newscootyengineoil','green',278,1110,20,'cstrl'),('itemid1','itemname1','color',100,100,10,'glf');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `mechanic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mechanic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `aadhar` varchar(20) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `payment_left` int(11) DEFAULT NULL,
  `address` text,
  `shopname` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanic`
--

LOCK TABLES `mechanic` WRITE;
/*!40000 ALTER TABLE `mechanic` DISABLE KEYS */;
INSERT INTO `mechanic` VALUES (100,'srinivas','293210938201382','9188112345',23444,'addrsss vrindavan','tirumala'),(101,'chaitanya','62512871628','1234567890',20000,'jadasdbashdbasjh','swiggy');
/*!40000 ALTER TABLE `mechanic` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `pid` varchar(30) NOT NULL,
  `bank_name` varchar(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `mode` varchar(15) DEFAULT NULL,
  `distrId` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `fk4` (`distrId`),
  CONSTRAINT `fk4` FOREIGN KEY (`distrId`) REFERENCES `distributor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('100','SBI',6000,'2019-10-11','UPI',1729),('45678292','UNION',400,'2019-10-12','UPI',1730),('873648324','ICICI',1000,'2019-10-14','UPI',1729);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `wage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `date` date NOT NULL,
  `empId` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `empId` (`empId`),
  CONSTRAINT `wage_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `employee` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wage`
--

LOCK TABLES `wage` WRITE;
/*!40000 ALTER TABLE `wage` DISABLE KEYS */;
INSERT INTO `wage` VALUES (2,5000,'2019-10-12','myempid'),(3,5000,'2019-10-12','myempid');
/*!40000 ALTER TABLE `wage` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `total` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT '0',
  `netamount` int(11) DEFAULT NULL,
  `custId` int(11) DEFAULT NULL,
  `mechId` int(11) DEFAULT NULL,
  `empId` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk6` (`custId`),
  KEY `fk7` (`mechId`),
  KEY `fk10` (`empId`),
  CONSTRAINT `fk10` FOREIGN KEY (`empId`) REFERENCES `employee` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk6` FOREIGN KEY (`custId`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk7` FOREIGN KEY (`mechId`) REFERENCES `mechanic` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1051 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `DistributorBrand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DistributorBrand` (
  `brandId` varchar(10) NOT NULL,
  `distrId` int(11) NOT NULL,
  PRIMARY KEY (`brandId`,`distrId`),
  KEY `fk2` (`distrId`),
  CONSTRAINT `fk1` FOREIGN KEY (`brandId`) REFERENCES `Brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`distrId`) REFERENCES `distributor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `Invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Invoice` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `amount` int(11) NOT NULL,
  `delivery_charge` int(11) DEFAULT NULL,
  `delivery_by` varchar(30) DEFAULT NULL,
  `distrId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk20` (`distrId`),
  CONSTRAINT `fk20` FOREIGN KEY (`distrId`) REFERENCES `distributor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `Login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Login` (
  `empId` varchar(30) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  KEY `empId` (`empId`),
  CONSTRAINT `Login_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Login`
--

LOCK TABLES `Login` WRITE;
/*!40000 ALTER TABLE `Login` DISABLE KEYS */;
INSERT INTO `Login` VALUES ('myempid','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8'),('krish','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8');
/*!40000 ALTER TABLE `Login` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custId` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `remarks` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `custId` (`custId`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`custId`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `item_voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_voucher` (
  `vid` int(11) DEFAULT NULL,
  `itemId` varchar(20) DEFAULT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  KEY `fk15` (`vid`),
  KEY `fk16` (`itemId`),
  CONSTRAINT `fk15` FOREIGN KEY (`vid`) REFERENCES `voucher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk16` FOREIGN KEY (`itemId`) REFERENCES `items` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `supplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplies` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` varchar(30) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `InvoiceId` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `fk17` (`itemId`),
  KEY `fk18` (`InvoiceId`),
  CONSTRAINT `fk17` FOREIGN KEY (`itemId`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk18` FOREIGN KEY (`InvoiceId`) REFERENCES `Invoice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


delimiter @@

create trigger updatequantity after insert on item_voucher for each row begin if((select quantity from items where id=new.itemId)-new.quantity >=0) then update items set quantity=quantity-new.quantity where id=new.itemId; else signal sqlstate '45000' set message_text="items insufficient";end if;end@@

create trigger supplies_item_quantity_update
after insert on supplies for each row
begin update items set quantity=quantity+new.quantity where id=new.itemId;
end@@

create trigger updatepaymentdistr
after insert on payment for each row begin
update distributor set payment_pending=payment_pending-new.amount where id=new.distrId;
end@@

create trigger mechanicsell
after insert on item_voucher for each row
begin if (select custId from voucher where id=new.vid) is NULL then update voucher set total=total+(select MRP from items where id=new.itemId)*(new.quantity), discount=discount+(0.01)*(select mech_discount from items where id=new.itemId)*(select MRP from items where id=new.itemId)*(new.quantity),netamount=total where id=new.vid; end if;
end@@

create trigger customersell
after insert on item_voucher for each row
begin if (select mechId from voucher where id=new.vid) is NULL then update voucher set total=total+(select MRP from items where id=new.itemId)*(new.quantity), discount=0,netamount=total where id=new.vid;end if;
end@@

delimiter ;
