-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.41 - Source distribution
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2012-10-07 00:41:15
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table interfacem.interface
CREATE TABLE IF NOT EXISTS `interface` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `groupid` int(11) DEFAULT NULL COMMENT '组id',
  `name` varchar(50) DEFAULT NULL COMMENT '接口名',
  `type` int(10) DEFAULT '0' COMMENT '接口类型',
  `status` int(10) DEFAULT '0' COMMENT '接口状态',
  `text` text COMMENT '接口说明',
  `version` varchar(25) DEFAULT '0' COMMENT '接口版本',
  `faceurl` varchar(255) DEFAULT NULL COMMENT '接口地址串',
  `url` varchar(255) DEFAULT NULL COMMENT '接口完整地址串',
  `method` int(11) DEFAULT '0' COMMENT '请求方法',
  `returntext` text COMMENT '返回格式说明',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `writers` varchar(50) DEFAULT NULL COMMENT '撰写者',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='接口名表';

-- Dumping data for table interfacem.interface: 12 rows
DELETE FROM `interface`;
/*!40000 ALTER TABLE `interface` DISABLE KEYS */;
INSERT INTO `interface` (`id`, `groupid`, `name`, `type`, `status`, `text`, `version`, `faceurl`, `url`, `method`, `returntext`, `createtime`, `updatetime`, `writers`) VALUES
	(1, 1, '统计成功备份Rom次数的接口', 1, 1, '备份系统成功后，请求该接口。返回格式为JSON，请求方式为GET。', '0', 'gphone_bakup_succ.json', '', 1, '{"code":"1"}', NULL, '2012-10-06 16:27:26', '张迪'),
	(29, 1, '获取“开机画面”资源列表', 1, 1, '客户端因要展示“开机画面”资源列表以便用户下载。故需要请求服务器，传回所需信息。', '0', 'getstartpage.json', '', 1, '{\r\n“code”:”1”,\r\n”result”:[\r\n{\r\n“starpage_img”:”http://www.baidu.com”,\r\n”startpage_id”:”123”,\r\n“startpage_name”:”刷机画面啦”\r\n},……\r\n],\r\n			“pagecount”:”101”\r\n}', '2012-10-06 16:28:19', '2012-10-06 16:35:00', '');
/*!40000 ALTER TABLE `interface` ENABLE KEYS */;


-- Dumping structure for table interfacem.interfacegroup
CREATE TABLE IF NOT EXISTS `interfacegroup` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '组名',
  `type` int(11) DEFAULT NULL COMMENT '组类型',
  `status` int(10) DEFAULT NULL COMMENT '组状态',
  `text` text COMMENT '组说明',
  `createtime` datetime DEFAULT NULL COMMENT '组创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='组表';

-- Dumping data for table interfacem.interfacegroup: 2 rows
DELETE FROM `interfacegroup`;
/*!40000 ALTER TABLE `interfacegroup` DISABLE KEYS */;
INSERT INTO `interfacegroup` (`id`, `name`, `type`, `status`, `text`, `createtime`) VALUES
	(1, '手机端接口', 1, 1, '显示手机的', '2012-10-01 15:51:50'),
	(2, '电脑端接口', 1, 1, '显示电脑的', '2012-10-01 15:51:50');
/*!40000 ALTER TABLE `interfacegroup` ENABLE KEYS */;


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
  `species` int(10) NOT NULL DEFAULT '0' COMMENT '参数类型',
  `text` int(10) NOT NULL DEFAULT '0' COMMENT '说明',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `order` int(10) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COMMENT='参数表';

-- Dumping data for table interfacem.parameter: 22 rows
DELETE FROM `parameter`;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` (`id`, `faceid`, `superior`, `type`, `name`, `nametext`, `value`, `isnull`, `species`, `text`, `createtime`, `updatetime`, `order`) VALUES
	(1, 1, 1, 1, 'name', '说明 ', '1', 1, 1, 0, '2012-10-03 15:08:49', '2012-10-06 07:25:44', 1),
	(60, 1, 0, 3, 'fac', '厂商名称', NULL, 2, 1, 0, '2012-10-06 07:26:04', '2012-10-06 15:31:53', 0),
	(103, 29, 0, 3, 'fac', '厂商名称', NULL, 2, 1, 0, '2012-10-06 16:28:59', NULL, 0),
	(104, 29, 0, 3, 'dev', '当前手机名称', NULL, 2, 1, 0, '2012-10-06 16:29:16', NULL, 0),
	(94, 1, 0, 3, 'dev', '当前手机名称', NULL, 2, 1, 0, '2012-10-06 15:32:10', NULL, 0),
	(93, 1, 0, 1, 'code', '1代表成功，-1代表失败。 ', NULL, 2, 2, 0, '2012-10-06 14:59:49', '2012-10-06 15:34:45', 0),
	(105, 29, 0, 1, 'width', '手机分辨率宽', NULL, 2, 1, 0, '2012-10-06 16:31:33', NULL, 0),
	(95, 1, 0, 1, 'flag', '行为区分值1代表与备份2代表成功备份（此处取2）', NULL, 2, 1, 0, '2012-10-06 15:32:54', NULL, 0),
	(96, 1, 0, 3, 'cid', '渠道号', NULL, 1, 1, 0, '2012-10-06 15:33:11', NULL, 0),
	(97, 1, 0, 3, 'mac', '手机imei码', NULL, 1, 1, 0, '2012-10-06 15:33:26', NULL, 0),
	(98, 1, 0, 3, 'imsi', 'SIM卡序列号', NULL, 1, 1, 0, '2012-10-06 15:33:40', NULL, 0),
	(99, 1, 0, 3, 'version', '绿豆版本号', NULL, 1, 1, 0, '2012-10-06 15:33:53', NULL, 0),
	(100, 1, 0, 3, 'result', '失败的理由。（UTF-8）编码', NULL, 2, 2, 0, '2012-10-06 15:34:51', NULL, 0),
	(106, 29, 0, 1, 'high', '手机分辨率高', NULL, 2, 1, 0, '2012-10-06 16:31:34', NULL, 0),
	(107, 29, 0, 1, 'orderby', '1代表全部2代表最新3按排行', NULL, 2, 1, 0, '2012-10-06 16:31:37', NULL, 0),
	(108, 29, 0, 1, 'page', '当前页数', NULL, 1, 1, 0, '2012-10-06 16:31:38', NULL, 0),
	(109, 29, 0, 3, 'pagesize', '分页大小', NULL, 2, 1, 0, '2012-10-06 16:31:39', NULL, 0),
	(110, 29, 0, 3, 'cid', '渠道号', NULL, 2, 1, 0, '2012-10-06 16:31:42', NULL, 0),
	(111, 29, 0, 3, 'mac', '手机imei码', NULL, 1, 1, 0, '2012-10-06 16:31:44', NULL, 0),
	(112, 29, 0, 3, 'imsi', 'SIM卡序列号', NULL, 2, 1, 0, '2012-10-06 16:31:46', NULL, 0),
	(113, 29, 0, 3, 'version', '绿豆版本号', NULL, 1, 1, 0, '2012-10-06 16:31:48', NULL, 0),
	(114, 29, 0, 1, 'code', '1代表成功，-1代表失败。 ', NULL, 2, 2, 0, '2012-10-06 16:32:48', NULL, 0),
	(115, 29, 0, 1, 'result', '返回结果数组。 ', NULL, 2, 2, 0, '2012-10-06 16:32:50', '2012-10-06 16:33:56', 0),
	(116, 29, 115, 3, 'starpage_img', '开机画面的缩略图 ', NULL, 2, 2, 0, '2012-10-06 16:33:06', '2012-10-06 16:34:05', 0),
	(117, 29, 115, 1, 'startpage_id', '开机画面的id', NULL, 2, 2, 0, '2012-10-06 16:33:29', '2012-10-06 16:34:02', 0),
	(118, 29, 115, 3, 'startpage_name', '开机画面名称', NULL, 2, 2, 0, '2012-10-06 16:33:58', NULL, 0),
	(119, 29, 115, 1, 'pagecount', '总页数', NULL, 2, 2, 0, '2012-10-06 16:33:59', NULL, 0);
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
