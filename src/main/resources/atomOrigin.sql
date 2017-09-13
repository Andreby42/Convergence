/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : skyeye

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-09-14 00:18:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for atom
-- ----------------------------
DROP TABLE IF EXISTS `atom`;
CREATE TABLE `atom` (
  `atom_id` int(64) NOT NULL AUTO_INCREMENT,
  `citizen_id` varchar(128) DEFAULT NULL,
  `real_name` varchar(128) DEFAULT NULL,
  `copt_level` varchar(255) DEFAULT NULL,
  `copt_address` varchar(255) DEFAULT NULL,
  `copt_contact_info` varchar(255) DEFAULT NULL,
  `copt_zip` varchar(255) DEFAULT NULL,
  `copt_name` varchar(128) DEFAULT NULL,
  `sex` varchar(128) DEFAULT NULL,
  `birth_day` varchar(255) DEFAULT NULL,
  `birth_month` varchar(255) DEFAULT NULL,
  `birth_year` varchar(255) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `education` varchar(128) DEFAULT NULL,
  `workdate` datetime DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `zip` varchar(128) DEFAULT NULL,
  `tel` varchar(128) DEFAULT NULL,
  `fax` varchar(128) DEFAULT NULL,
  `ecotype` varchar(128) DEFAULT NULL,
  `trade_property` varchar(255) DEFAULT NULL,
  `trade_code` varchar(128) DEFAULT NULL,
  `qq` varchar(128) DEFAULT NULL,
  `sh` varchar(128) DEFAULT NULL,
  `hip` varchar(8) DEFAULT NULL,
  `age` varchar(128) DEFAULT NULL,
  `bust` varchar(8) DEFAULT NULL,
  `weibo` varchar(200) DEFAULT NULL,
  `hobby` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `astro` varchar(128) DEFAULT NULL,
  `weight` varchar(16) DEFAULT NULL,
  `height` varchar(16) DEFAULT NULL,
  `weixin` varchar(200) DEFAULT NULL,
  `school` varchar(128) DEFAULT NULL,
  `nation` varchar(128) DEFAULT NULL,
  `tptotal` int(11) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `waistline` varchar(16) DEFAULT NULL,
  `specialty` varchar(100) DEFAULT NULL,
  `birthplace` varchar(128) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `msn` varchar(64) DEFAULT NULL,
  `pay_password` varchar(255) DEFAULT NULL,
  `home_phone` varchar(255) DEFAULT NULL,
  `depart` varchar(255) DEFAULT NULL,
  `aliww` varchar(255) DEFAULT NULL,
  `icq` varchar(255) DEFAULT NULL,
  `yahoo` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `lastip` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `data_from` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`atom_id`),
  KEY `atom_id` (`atom_id`) USING BTREE,
  KEY `citizen_id` (`citizen_id`) USING BTREE,
  KEY `real_name` (`real_name`) USING BTREE,
  KEY `tel` (`tel`) USING BTREE,
  KEY `qq` (`qq`) USING BTREE,
  KEY `weibo` (`weibo`) USING BTREE,
  KEY `email` (`email`) USING BTREE,
  KEY `weixin` (`weixin`) USING BTREE,
  KEY `password` (`password`) USING BTREE,
  KEY `user_name` (`user_name`) USING BTREE,
  KEY `aliww` (`aliww`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=417575 DEFAULT CHARSET=utf8 COMMENT='原子表';
