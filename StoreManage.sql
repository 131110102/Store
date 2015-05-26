-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.0.27-community-nt - MySQL Community Edition (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 store 的数据库结构
CREATE DATABASE IF NOT EXISTS `store` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `store`;


-- 导出  表 store.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `COMPANYNAME` varchar(50) NOT NULL,
  `CITY` varchar(10) default NULL,
  `CITYNUM` varchar(50) default NULL,
  `FAX` varchar(20) default NULL,
  `ADDRESS` varchar(50) default NULL,
  `PHONE` varchar(50) default NULL,
  PRIMARY KEY  (`COMPANYNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- 正在导出表  store.customer 的数据：~7 rows (大约)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`COMPANYNAME`, `CITY`, `CITYNUM`, `FAX`, `ADDRESS`, `PHONE`) VALUES
	('000', '', '', '', '', ''),
	('都比', '', '', '', '', ''),
	('咪咪', '', '', '', '', ''),
	('匹配', '', '', '', '', ''),
	('铁柱二蛋有限公司', NULL, NULL, NULL, NULL, NULL),
	('我试试', '', '', '', '', ''),
	('赵柱2', '', '', '', '', '');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- 导出  表 store.product 结构
CREATE TABLE IF NOT EXISTS `product` (
  `PRODUCTNAME` varchar(20) NOT NULL default '',
  `SPEC` varchar(50) default NULL,
  `UNIT` varchar(5) default NULL,
  `MEMO` text,
  PRIMARY KEY  (`PRODUCTNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- 正在导出表  store.product 的数据：~8 rows (大约)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`PRODUCTNAME`, `SPEC`, `UNIT`, `MEMO`) VALUES
	('000', NULL, NULL, NULL),
	('333', NULL, NULL, NULL),
	('dd', NULL, NULL, NULL),
	('douyu', NULL, NULL, NULL),
	('www', NULL, NULL, NULL),
	('爽歪歪', '5cm', '瓶', '好喝'),
	('娃娃', NULL, NULL, NULL),
	('我是', NULL, NULL, NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- 导出  表 store.purchase 结构
CREATE TABLE IF NOT EXISTS `purchase` (
  `ORDERNO` varchar(50) NOT NULL,
  `PRODUCTNAME` varchar(20) NOT NULL,
  `CUSTOMER` varchar(50) NOT NULL,
  `QUANTITY` float default NULL,
  `UNITPRICE` double default NULL,
  `ORDERDATE` date default NULL,
  `MEMO` mediumtext,
  PRIMARY KEY  (`ORDERNO`),
  KEY `FK_purchase_product` (`PRODUCTNAME`),
  KEY `FK_purchase_customer` (`CUSTOMER`),
  CONSTRAINT `FK_purchase_customer` FOREIGN KEY (`CUSTOMER`) REFERENCES `customer` (`COMPANYNAME`),
  CONSTRAINT `FK_purchase_product` FOREIGN KEY (`PRODUCTNAME`) REFERENCES `product` (`PRODUCTNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- 正在导出表  store.purchase 的数据：~3 rows (大约)
DELETE FROM `purchase`;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`ORDERNO`, `PRODUCTNAME`, `CUSTOMER`, `QUANTITY`, `UNITPRICE`, `ORDERDATE`, `MEMO`) VALUES
	('20150526200026', '000', '000', 1, 1, '2015-05-26', ''),
	('20150526200608', '000', '000', 2, 2, '2015-05-26', ''),
	('20150526200617', '000', '000', 1.2, 2.2, '2015-05-26', '');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


-- 导出  表 store.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  PRIMARY KEY  (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- 正在导出表  store.user 的数据：~2 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`NAME`, `PASSWORD`) VALUES
	('131110102\r\n', '1311101'),
	('ccy', '1311101');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
