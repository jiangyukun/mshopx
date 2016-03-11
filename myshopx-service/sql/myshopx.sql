/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : myshopx

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-03-11 19:46:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_menu`
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL DEFAULT '',
  `des` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT '',
  `is_button` char(4) NOT NULL,
  `parent_id` varchar(64) NOT NULL DEFAULT '0',
  `action` varchar(128) DEFAULT '',
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `sort` double(10,2) NOT NULL DEFAULT '0.00',
  `authority_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES ('297e40e3534c28be01534c28c6d10000', '商品管理', '', '', 'N', '0', '', '2016-03-06 21:40:54', '2016-03-06 21:55:02', '2.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c326301534c326b410000', '商品分页页面', '商品管理分页页面', '/admin/goods/pager', 'N', '297e40e3534c28be01534c28c6d10000', '', '2016-03-06 21:51:26', '2016-03-06 21:55:02', '3.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c35b001534c35b7e90000', '商品分页查看', '分页查看功能', '/admin/goods/dopager', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 21:55:02', '2016-03-06 21:55:02', '4.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c37d001534c37d80d0000', '增加商品', '增加商品功能', '/admin/goods/doadd', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 21:57:21', '2016-03-06 21:57:21', '5.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2bad0000', '修改商品', '修改商品功能', '/admin/goods/doadd', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2bfb0001', '放到回收站', '商品放到回收站功能', '/admin/goods/toecyclebin', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c0a0002', '回收站', '回收站页面', '/admin/goods/ecyclebin', 'N', '297e40e3534c28be01534c28c6d10000', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c120003', '删除', '从回收站删除功能', '/admin/goods/dodel', 'Y', '297e40e3534c3d2301534c3d2c0a0002', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0004', '还原', '从回收站回收功能', '/admin/goods/dodel', 'Y', '297e40e3534c3d2301534c3d2c0a0002', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0009', '系统管理', '', '', 'N', '0', '', '2016-03-05 20:23:12', '2016-03-07 20:23:20', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0010', '菜单管理', '', '/admin/menu', 'N', '297e40e3534c3d2301534c3d2c1a0009', '', '2016-03-05 20:24:14', '2016-03-08 20:24:17', '2.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0011', '创建菜单', '创建菜单', '/admin/menu/doadd', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:25:17', '2016-03-09 20:25:21', '3.00', 'admin_menu_doadd');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0012', '修改菜单', '修改菜单', '/admin/menu/doupdate', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:26:06', '2016-03-07 20:26:11', '4.00', 'admin_menu_doupdate');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0013', '删除菜单', '删除菜单', '/admin/menu/dodel', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:26:49', '2016-03-07 20:26:54', '5.00', 'admin_menu_dodel');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0014', '分页查看菜单', '分页查看菜单', '/admin/menu/dopager', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:27:45', '2016-03-08 20:27:49', '6.00', 'admin_menu_dopager');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc70153561693120001', '角色管理', '', '/admin/role', 'N', '297e40e3534c3d2301534c3d2c1a0009', '', '2016-03-08 19:57:13', '2016-03-08 19:57:13', '1.00', '');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc70153561757580002', '创建角色', '', '/admin/role/doadd', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 19:58:04', '2016-03-11 19:45:43', '1.00', 'admin_role_doadd');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc701535622dcde0003', '修改角色', '', '/admin/role/doupdate', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 20:10:39', '2016-03-08 20:10:39', '1.00', '');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc701535623a3fd0004', '删除角色', '', '/admin/role/dodel', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 20:11:30', '2016-03-08 20:11:30', '1.00', '');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc70153562421bb0005', '分页查看角色', '', '/admin/role/dopager', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 20:12:02', '2016-03-08 20:12:02', '1.00', '');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc701535624d7c40006', '管理员管理 ', '', '/admin/user', 'N', '297e40e3534c3d2301534c3d2c1a0009', '', '2016-03-08 20:12:48', '2016-03-08 20:12:48', '1.00', '');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53657b320153657d10320000', '2222', '', 'dddd', 'N', '0', '', '2016-03-11 19:43:28', '2016-03-11 19:43:28', '1.00', '');

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` varchar(64) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `brand_name` varchar(60) NOT NULL DEFAULT '',
  `brand_logo` varchar(80) NOT NULL DEFAULT '',
  `brand_desc` text NOT NULL,
  `site_url` varchar(255) NOT NULL DEFAULT '',
  `sort_order` tinyint(3) NOT NULL DEFAULT '50',
  `is_show` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(64) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `cat_name` varchar(90) NOT NULL DEFAULT '',
  `keywords` varchar(256) NOT NULL DEFAULT '',
  `cat_desc` varchar(256) NOT NULL DEFAULT '',
  `parent_id` varchar(64) NOT NULL DEFAULT '0',
  `sort_order` tinyint(1) NOT NULL DEFAULT '50',
  `template_file` varchar(50) NOT NULL DEFAULT '',
  `measure_unit` varchar(15) NOT NULL DEFAULT '',
  `show_in_nav` tinyint(1) NOT NULL DEFAULT '0',
  `style` varchar(256) NOT NULL,
  `is_show` tinyint(1) NOT NULL DEFAULT '1',
  `grade` tinyint(4) NOT NULL DEFAULT '0',
  `filter_attr` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(10) NOT NULL,
  `comment_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `id_value` varchar(64) NOT NULL DEFAULT '0',
  `email` varchar(64) NOT NULL DEFAULT '',
  `user_name` varchar(64) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `comment_rank` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0',
  `ip_address` varchar(15) NOT NULL DEFAULT '',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `parent_id` varchar(64) NOT NULL DEFAULT '0',
  `user_id` varchar(64) NOT NULL DEFAULT '0',
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `id_value` (`id_value`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` varchar(64) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `cat_id` varchar(64) NOT NULL DEFAULT '0',
  `goods_sn` varchar(60) NOT NULL DEFAULT '',
  `goods_name` varchar(120) NOT NULL DEFAULT '',
  `goods_name_style` varchar(60) NOT NULL DEFAULT '+',
  `click_count` int(10) unsigned NOT NULL DEFAULT '0',
  `brand_id` varchar(64) NOT NULL DEFAULT '0',
  `provider_name` varchar(100) NOT NULL DEFAULT '',
  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '0',
  `goods_weight` decimal(10,3) unsigned NOT NULL DEFAULT '0.000',
  `market_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `shop_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `promote_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `promote_start_date` int(11) unsigned NOT NULL DEFAULT '0',
  `promote_end_date` int(11) unsigned NOT NULL DEFAULT '0',
  `warn_number` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `keywords` varchar(256) NOT NULL DEFAULT '',
  `goods_brief` varchar(256) NOT NULL DEFAULT '',
  `goods_desc` text NOT NULL,
  `goods_thumb` varchar(256) NOT NULL DEFAULT '',
  `goods_img` varchar(255) NOT NULL DEFAULT '',
  `original_img` varchar(255) NOT NULL DEFAULT '',
  `is_real` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `extension_code` varchar(30) NOT NULL DEFAULT '',
  `is_on_sale` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `is_alone_sale` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `is_shipping` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `integral` int(10) unsigned NOT NULL DEFAULT '0',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0',
  `sort_order` smallint(4) unsigned NOT NULL DEFAULT '100',
  `is_delete` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_best` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_new` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_hot` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_promote` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `bonus_type_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `last_update` int(10) unsigned NOT NULL DEFAULT '0',
  `goods_type` smallint(5) unsigned NOT NULL DEFAULT '0',
  `seller_note` varchar(256) NOT NULL DEFAULT '',
  `give_integral` int(11) NOT NULL DEFAULT '-1',
  `rank_integral` int(11) NOT NULL DEFAULT '-1',
  `suppliers_id` varchar(64) DEFAULT NULL,
  `is_check` tinyint(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_sn` (`goods_sn`),
  KEY `cat_id` (`cat_id`),
  KEY `last_update` (`last_update`),
  KEY `brand_id` (`brand_id`),
  KEY `goods_weight` (`goods_weight`),
  KEY `promote_end_date` (`promote_end_date`),
  KEY `promote_start_date` (`promote_start_date`),
  KEY `goods_number` (`goods_number`),
  KEY `sort_order` (`sort_order`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_activity`
-- ----------------------------
DROP TABLE IF EXISTS `goods_activity`;
CREATE TABLE `goods_activity` (
  `id` varchar(64) NOT NULL,
  `act_name` varchar(256) NOT NULL,
  `act_desc` text NOT NULL,
  `act_type` tinyint(3) unsigned NOT NULL,
  `goods_id` varchar(64) NOT NULL,
  `product_id` varchar(64) NOT NULL DEFAULT '0',
  `goods_name` varchar(256) NOT NULL,
  `start_time` int(10) unsigned NOT NULL,
  `end_time` int(10) unsigned NOT NULL,
  `is_finished` tinyint(3) unsigned NOT NULL,
  `ext_info` text NOT NULL,
  `update_at` datetime NOT NULL,
  `create_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `act_name` (`act_name`,`act_type`,`goods_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_activity
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_attr`
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr`;
CREATE TABLE `goods_attr` (
  `id` varchar(64) NOT NULL,
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `attr_id` varchar(64) NOT NULL DEFAULT '0',
  `attr_value` text NOT NULL,
  `attr_price` varchar(256) NOT NULL DEFAULT '',
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  KEY `attr_id` (`attr_id`)
) ENGINE=MyISAM AUTO_INCREMENT=241 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_attr
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_cat`
-- ----------------------------
DROP TABLE IF EXISTS `goods_cat`;
CREATE TABLE `goods_cat` (
  `goods_id` varchar(64) NOT NULL DEFAULT '0',
  `cat_id` varchar(64) NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_id`,`cat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_cat
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_gallery`
-- ----------------------------
DROP TABLE IF EXISTS `goods_gallery`;
CREATE TABLE `goods_gallery` (
  `id` varchar(64) NOT NULL,
  `goods_id` varchar(64) NOT NULL DEFAULT '0',
  `img_url` varchar(256) NOT NULL DEFAULT '',
  `img_desc` varchar(256) NOT NULL DEFAULT '',
  `thumb_url` varchar(256) NOT NULL DEFAULT '',
  `img_original` varchar(256) NOT NULL DEFAULT '',
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_gallery
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `cat_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(60) NOT NULL DEFAULT '',
  `enabled` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `attr_group` varchar(255) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------

-- ----------------------------
-- Table structure for `group_goods`
-- ----------------------------
DROP TABLE IF EXISTS `group_goods`;
CREATE TABLE `group_goods` (
  `parent_id` varchar(64) NOT NULL DEFAULT '0',
  `goods_id` varchar(64) NOT NULL DEFAULT '0',
  `goods_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `admin_id` varchar(64) NOT NULL DEFAULT '0',
  PRIMARY KEY (`parent_id`,`goods_id`,`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` varchar(64) NOT NULL,
  `goods_id` varchar(64) NOT NULL DEFAULT '0',
  `goods_attr` varchar(50) DEFAULT NULL,
  `product_sn` varchar(60) DEFAULT NULL,
  `product_number` smallint(5) unsigned DEFAULT '0',
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `name` varchar(64) NOT NULL,
  `state` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('8a8a80ea53641ba70153641bd1e70000', '2016-03-11 13:17:38', '2016-03-11 13:51:14', '122', 'DEL');
INSERT INTO `role` VALUES ('8a8a80ea53643a710153643aee4d0000', '2016-03-11 13:51:37', '2016-03-11 13:51:37', '222', 'NORMAL');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL,
  `qq` varchar(32) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `staus` varchar(32) NOT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `is_admin` char(1) NOT NULL DEFAULT '0',
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_qq` (`qq`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8a8a80ea53560fc701535610afe10000', '346745719', null, 'NORMAL', null, 'N', '2016-03-08 19:50:47', '2016-03-08 19:50:47');
