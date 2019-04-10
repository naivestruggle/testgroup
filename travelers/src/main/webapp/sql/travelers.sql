/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : travelers

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-04-10 10:24:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(50) DEFAULT '',
  `user_password` varchar(50) DEFAULT '',
  `user_tel` varchar(11) DEFAULT '',
  `user_email` varchar(50) DEFAULT '',
  `user_birthday` date DEFAULT '1990-01-01',
  `user_sex` int(2) DEFAULT '0',
  `user_imgpath` varchar(255) DEFAULT '',
  `user_status` int(2) DEFAULT '1',
  `user_createtime` datetime DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
