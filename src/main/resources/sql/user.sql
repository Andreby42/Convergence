/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : skyeye

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-03-11 12:50:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `locked` int(11) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
