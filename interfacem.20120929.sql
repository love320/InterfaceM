-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.54-log - MySQL Community Server (GPL)
-- Server OS:                    unknown-linux-gnu
-- HeidiSQL version:             7.0.0.4197
-- Date/time:                    2012-09-29 16:39:28
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table interfacem.interface
CREATE TABLE IF NOT EXISTS `interface` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `groupid` int(11) DEFAULT NULL COMMENT '组id',
  `name` varchar(50) DEFAULT NULL COMMENT '接口名',
  `type` int(10) DEFAULT '0' COMMENT '接口类型',
  `status` int(10) DEFAULT '0' COMMENT '接口状态',
  `text` text COMMENT '接口说明',
  `version` int(11) DEFAULT '0' COMMENT '接口版本',
  `faceurl` varchar(255) DEFAULT NULL COMMENT '接口地址串',
  `url` varchar(255) DEFAULT NULL COMMENT '接口完整地址串',
  `method` int(11) DEFAULT '0' COMMENT '请求方法',
  `return` varchar(255) DEFAULT NULL COMMENT '返回格式说明',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `writers` varchar(50) DEFAULT NULL COMMENT '撰写者',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='接口名表';

-- Data exporting was unselected.


-- Dumping structure for table interfacem.interfacegroup
CREATE TABLE IF NOT EXISTS `interfacegroup` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '组名',
  `type` int(11) DEFAULT NULL COMMENT '组类型',
  `status` int(10) DEFAULT NULL COMMENT '组状态',
  `text` text COMMENT '组说明',
  `createtime` datetime DEFAULT NULL COMMENT '组创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='组表';

-- Data exporting was unselected.


-- Dumping structure for table interfacem.parameter
CREATE TABLE IF NOT EXISTS `parameter` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `faceid` int(10) NOT NULL DEFAULT '0' COMMENT '接口id',
  `superior` int(10) NOT NULL DEFAULT '0' COMMENT '上级id',
  `type` int(10) NOT NULL DEFAULT '0' COMMENT '参数类型',
  `name` varchar(50) DEFAULT NULL COMMENT '字段名',
  `nametext` varchar(50) DEFAULT NULL COMMENT '字段名说明',
  `value` varchar(50) DEFAULT NULL COMMENT '值',
  `isnull` int(10) DEFAULT '0' COMMENT '是否为空',
  `valuetype` int(10) NOT NULL DEFAULT '0' COMMENT '值类型',
  `text` int(10) NOT NULL DEFAULT '0' COMMENT '说明',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `order` int(10) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='参数表';

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
