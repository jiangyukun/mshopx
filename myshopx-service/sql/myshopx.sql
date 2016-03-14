/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : myshopx

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2016-03-14 22:33:10
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
INSERT INTO `admin_menu` VALUES ('297e40e3534c326301534c326b410000', '商品分页功能', '', '/admin/goods/pager', 'Y', '297e40e35370130e0153701fc8ba0002', '', '2016-03-06 21:51:26', '2016-03-13 21:18:54', '1.00', 'admin_goods_pager');
INSERT INTO `admin_menu` VALUES ('297e40e3534c35b001534c35b7e90000', '商品分页查看', '分页查看功能', '/admin/goods/dopager', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 21:55:02', '2016-03-06 21:55:02', '4.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c37d001534c37d80d0000', '增加商品', '增加商品功能', '/admin/goods/doadd', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 21:57:21', '2016-03-06 21:57:21', '5.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2bad0000', '修改商品', '修改商品功能', '/admin/goods/doadd', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2bfb0001', '放到回收站', '商品放到回收站功能', '/admin/goods/toecyclebin', 'Y', '297e40e3534c35b001534c35b7e90000', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c0a0002', '回收站', '回收站页面', '/admin/goods/ecyclebin', 'N', '297e40e3534c28be01534c28c6d10000', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c120003', '删除', '从回收站删除功能', '/admin/goods/dodel', 'Y', '297e40e3534c3d2301534c3d2c0a0002', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0004', '还原', '从回收站回收功能', '/admin/goods/dodel', 'Y', '297e40e3534c3d2301534c3d2c0a0002', '', '2016-03-06 22:03:10', '2016-03-06 22:03:10', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0009', '系统管理', '', '', 'N', '0', '', '2016-03-05 20:23:12', '2016-03-07 20:23:20', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0010', '菜单管理', '', '/admin/menu', 'N', '297e40e3534c3d2301534c3d2c1a0009', '', '2016-03-05 20:24:14', '2016-03-13 10:42:15', '1.00', '');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0011', '创建菜单', '创建菜单', '/admin/menu/doadd', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:25:17', '2016-03-09 20:25:21', '3.00', 'admin_menu_doadd');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0012', '修改菜单', '修改菜单', '/admin/menu/doupdate', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:26:06', '2016-03-07 20:26:11', '4.00', 'admin_menu_doupdate');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0013', '删除菜单', '删除菜单', '/admin/menu/dodel', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:26:49', '2016-03-07 20:26:54', '5.00', 'admin_menu_dodel');
INSERT INTO `admin_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0014', '查看所有菜单', '查看所有菜单', '/admin/menu/list', 'Y', '297e40e3534c3d2301534c3d2c1a0010', '', '2016-03-05 20:27:45', '2016-03-08 20:27:49', '6.00', 'admin_menu_list');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc70153561693120001', '角色管理', '', '/admin/role', 'N', '297e40e3534c3d2301534c3d2c1a0009', '', '2016-03-08 19:57:13', '2016-03-13 10:42:06', '2.00', '');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc70153561757580002', '创建角色', '', '/admin/role/doadd', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 19:58:04', '2016-03-11 19:45:43', '1.00', 'admin_role_doadd');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc701535622dcde0003', '修改角色', '', '/admin/role/doupdate', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 20:10:39', '2016-03-08 20:10:39', '1.00', 'admin_role_doupdate');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc701535623a3fd0004', '删除角色', '', '/admin/role/dodel', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 20:11:30', '2016-03-08 20:11:30', '1.00', 'admin_role_dodel');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc70153562421bb0005', '分页查看角色', '', '/admin/role/dopager', 'Y', '8a8a80ea53560fc70153561693120001', '', '2016-03-08 20:12:02', '2016-03-08 20:12:02', '1.00', 'admin_role_dopager');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53560fc701535624d7c40006', '管理员管理 ', '', '/admin/adminuser', 'N', '297e40e3534c3d2301534c3d2c1a0009', '', '2016-03-08 20:12:48', '2016-03-08 20:12:48', '1.00', '');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53657b320153658e50c90002', '增加管理员', '', '/admin/adminuser/doadd', 'Y', '8a8a80ea53560fc701535624d7c40006', '', '2016-03-11 20:02:19', '2016-03-13 10:41:59', '1.00', 'admin_adminuser_doadd');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53657b320153658ee18b0003', '修改管理员', '', '/admin/adminuser/doupdate', 'Y', '8a8a80ea53560fc701535624d7c40006', '', '2016-03-11 20:02:56', '2016-03-11 20:02:56', '1.00', 'admin_adminuser_doupdate');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53657b320153658f98420004', '删除管理员', '', '/admin/adminuser/dodel', 'Y', '8a8a80ea53560fc701535624d7c40006', '', '2016-03-11 20:03:43', '2016-03-11 20:03:43', '1.00', 'admin_adminuser_dodel');
INSERT INTO `admin_menu` VALUES ('8a8a80ea53657b320153659034090005', '管理员分页查看', '', '/admin/adminuser/dopager', 'Y', '8a8a80ea53560fc701535624d7c40006', '', '2016-03-11 20:04:23', '2016-03-11 20:04:23', '1.00', 'admin_adminuser_dopager');
INSERT INTO `admin_menu` VALUES ('297e40e3536dcbfb01536dcf31090000', '设置角色', '', '/admin/adminuser/setroles', 'Y', '8a8a80ea53560fc701535624d7c40006', '', '2016-03-13 10:30:07', '2016-03-13 10:30:07', '1.00', 'admin_adminuser_setroles');
INSERT INTO `admin_menu` VALUES ('297e40e3536dcbfb01536dd064240001', '查看可选角色', '', '/admin/adminuser/canselroles', 'Y', '8a8a80ea53560fc701535624d7c40006', '', '2016-03-13 10:31:27', '2016-03-13 10:31:35', '1.00', 'admin_adminuser_canselroles');
INSERT INTO `admin_menu` VALUES ('297e40e3536dcbfb01536dd1d5ff0002', '取消管理员', '', '/admin/adminuser/cancleadmin', 'Y', '8a8a80ea53560fc701535624d7c40006', '', '2016-03-13 10:33:01', '2016-03-13 10:33:08', '1.00', 'admin_adminuser_cancleadmin');
INSERT INTO `admin_menu` VALUES ('297e40e35370130e0153701fc8ba0002', '商品信息', '', '/admin/goods', 'N', '297e40e3534c28be01534c28c6d10000', '', '2016-03-13 21:17:24', '2016-03-13 21:17:24', '999.00', 'admin_goods');
INSERT INTO `admin_menu` VALUES ('297e40e35370130e01537021e86c0003', '增加商品', '', '/admin/goods/docreate', 'Y', '297e40e35370130e0153701fc8ba0002', '', '2016-03-13 21:19:43', '2016-03-13 21:19:43', '999.00', 'admin_goods_docreate');
INSERT INTO `admin_menu` VALUES ('297e40e35370130e01537022c12a0004', '修改商品', '', '/admin/goods/doupdate', 'Y', '297e40e35370130e0153701fc8ba0002', '', '2016-03-13 21:20:39', '2016-03-13 21:20:39', '999.00', 'admin_goods_doupdate');
INSERT INTO `admin_menu` VALUES ('297e40e35370130e01537024891d0005', '放入回收站', '', '/admin/goods/torecycleBin', 'Y', '297e40e35370130e0153701fc8ba0002', '', '2016-03-13 21:22:35', '2016-03-13 21:22:43', '995.00', 'admin_goods_torecycleBin');

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
  `is_show` char(4) NOT NULL DEFAULT 'Y',
  `states` char(8) NOT NULL,
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
  `show_in_nav` char(4) NOT NULL DEFAULT '0',
  `style` varchar(256) NOT NULL,
  `is_show` char(4) NOT NULL DEFAULT '1',
  `grade` tinyint(4) NOT NULL DEFAULT '0',
  `filter_attr` varchar(255) NOT NULL DEFAULT '0',
  `states` varchar(16) NOT NULL,
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
-- Table structure for `rel_admin_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `rel_admin_user_role`;
CREATE TABLE `rel_admin_user_role` (
  `user_id` varchar(32) NOT NULL,
  `admin_role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`admin_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rel_admin_user_role
-- ----------------------------
INSERT INTO `rel_admin_user_role` VALUES ('8a8a80ea53560fc701535610afe10000', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_admin_user_role` VALUES ('8a8a80ea53560fc701535610afe10000', '297e40e35370130e0153701dabd30001');
INSERT INTO `rel_admin_user_role` VALUES ('8a8a80ea53560fc701535610afe10000', '297e40e35370130e0153702668060006');

-- ----------------------------
-- Table structure for `rel_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_menu`;
CREATE TABLE `rel_role_menu` (
  `menuid` varchar(32) NOT NULL,
  `roleid` varchar(32) NOT NULL,
  PRIMARY KEY (`menuid`,`roleid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rel_role_menu
-- ----------------------------
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c28be01534c28c6d10000', '297e40e35370130e0153701dabd30001');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c28be01534c28c6d10000', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c326301534c326b410000', '297e40e35370130e0153701dabd30001');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c326301534c326b410000', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c0a0002', '297e40e35370130e0153701dabd30001');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c0a0002', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c120003', '297e40e35370130e0153701dabd30001');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c120003', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0004', '297e40e35370130e0153701dabd30001');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0004', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0009', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0010', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0011', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0012', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0013', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3534c3d2301534c3d2c1a0014', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3536dcbfb01536dcf31090000', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3536dcbfb01536dd064240001', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e3536dcbfb01536dd1d5ff0002', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('297e40e35370130e0153701fc8ba0002', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e35370130e01537021e86c0003', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e35370130e01537022c12a0004', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('297e40e35370130e01537024891d0005', '297e40e35370130e0153702668060006');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53560fc70153561693120001', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53560fc70153561757580002', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53560fc701535622dcde0003', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53560fc701535623a3fd0004', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53560fc70153562421bb0005', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53560fc701535624d7c40006', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53657b320153658e50c90002', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53657b320153658ee18b0003', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53657b320153658f98420004', '297e40e35370130e0153701d4f660000');
INSERT INTO `rel_role_menu` VALUES ('8a8a80ea53657b320153659034090005', '297e40e35370130e0153701d4f660000');

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
INSERT INTO `role` VALUES ('297e40e35370130e0153701d4f660000', '2016-03-13 21:14:42', '2016-03-13 21:14:42', '系统管理员', 'NORMAL');
INSERT INTO `role` VALUES ('297e40e35370130e0153701dabd30001', '2016-03-13 21:15:06', '2016-03-13 21:15:06', '测试管理员', 'NORMAL');
INSERT INTO `role` VALUES ('297e40e35370130e0153702668060006', '2016-03-13 21:24:38', '2016-03-13 21:24:59', '商品管理角色', 'NORMAL');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL,
  `uname` varchar(64) NOT NULL,
  `qq` varchar(32) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `state` varchar(32) NOT NULL,
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
INSERT INTO `user` VALUES ('8a8a80ea53560fc701535610afe10000', 'xubaoyong', '346745719', null, 'NORMAL', 'MAN', 'Y', '2016-03-08 19:50:47', '2016-03-08 19:50:47');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc6890000', '', '346745720', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:34', '2016-03-11 21:46:34');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7390001', '', '346745721', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7410002', '', '346745722', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc74e0003', '', '346745723', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7720004', '', '346745724', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc77d0005', '', '346745725', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7880006', '', '346745726', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7940007', '', '346745727', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7a40008', '', '346745728', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7ac0009', '', '346745729', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7b2000a', '', '346745730', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7bb000b', '', '346745731', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7c5000c', '', '346745732', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7d3000d', '', '346745733', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7db000e', '', '346745734', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7e5000f', '', '346745735', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7f40010', '', '346745736', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc7fc0011', '', '346745737', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8040012', '', '346745738', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8170013', '', '346745739', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8290014', '', '346745740', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8390015', '', '346745741', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8430016', '', '346745742', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8510017', '', '346745743', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc85d0018', '', '346745744', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc86d0019', '', '346745745', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc876001a', '', '346745746', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc87f001b', '', '346745747', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc884001c', '', '346745748', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc88b001d', '', '346745749', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc894001e', '', '346745750', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc89c001f', '', '346745751', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8a60020', '', '346745752', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8ad0021', '', '346745753', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8b10022', '', '346745754', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8b90023', '', '346745755', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8be0024', '', '346745756', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8c80025', '', '346745757', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8cd0026', '', '346745758', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8d20027', '', '346745759', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8d90028', '', '346745760', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8df0029', '', '346745761', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8e4002a', '', '346745762', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8eb002b', '', '346745763', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8f7002c', '', '346745764', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc8fe002d', '', '346745765', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc908002e', '', '346745766', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc90e002f', '', '346745767', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9190030', '', '346745768', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9270031', '', '346745769', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9300032', '', '346745770', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc93a0033', '', '346745771', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9450034', '', '346745772', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc94e0035', '', '346745773', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9530036', '', '346745774', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc95a0037', '', '346745775', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc96c0038', '', '346745776', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9730039', '', '346745777', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc977003a', '', '346745778', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc97c003b', '', '346745779', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc980003c', '', '346745780', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc985003d', '', '346745781', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc98c003e', '', '346745782', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc993003f', '', '346745783', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc99d0040', '', '346745784', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9a30041', '', '346745785', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9a90042', '', '346745786', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9af0043', '', '346745787', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9b50044', '', '346745788', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9b90045', '', '346745789', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9be0046', '', '346745790', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9c40047', '', '346745791', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9cd0048', '', '346745792', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9d40049', '', '346745793', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9dd004a', '', '346745794', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9e3004b', '', '346745795', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9e9004c', '', '346745796', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9f0004d', '', '346745797', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9f5004e', '', '346745798', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edc9fa004f', '', '346745799', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca000050', '', '346745800', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca070051', '', '346745801', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca110052', '', '346745802', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca180053', '', '346745803', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca1d0054', '', '346745804', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca230055', '', '346745805', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca2c0056', '', '346745806', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca320057', '', '346745807', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca370058', '', '346745808', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca3e0059', '', '346745809', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca43005a', '', '346745810', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca47005b', '', '346745811', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca4d005c', '', '346745812', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca53005d', '', '346745813', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca5b005e', '', '346745814', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:35', '2016-03-11 21:46:35');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca66005f', '', '346745815', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:36', '2016-03-11 21:46:36');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca6c0060', '', '346745816', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:36', '2016-03-11 21:46:36');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca740061', '', '346745817', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:36', '2016-03-11 21:46:36');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca7a0062', '', '346745818', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:36', '2016-03-11 21:46:36');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca800063', '', '346745819', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:36', '2016-03-11 21:46:36');
INSERT INTO `user` VALUES ('297e40e35365edbf015365edca880064', '', '346745820', null, 'NORMAL', 'MAN', 'N', '2016-03-11 21:46:36', '2016-03-11 21:46:36');
