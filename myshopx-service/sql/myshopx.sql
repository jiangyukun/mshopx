/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : myshopx

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2016-03-04 13:19:26
*/

SET FOREIGN_KEY_CHECKS=0;

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
