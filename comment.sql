/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : springioc

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-16 18:01:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `msg` varchar(100) NOT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '我什么都不会', '2020-08-08 10:10:10');
INSERT INTO `comment` VALUES ('2', '1', '这句话是真的', '2020-09-09 22:00:01');
INSERT INTO `comment` VALUES ('3', '2', '你说的什么呀', '2020-08-07 20:00:01');
INSERT INTO `comment` VALUES ('4', '2', '我也什么都不会', '2020-09-09 23:00:01');
