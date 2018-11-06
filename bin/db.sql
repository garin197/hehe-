/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : db_heherentcar

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 06/11/2018 17:10:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car`  (
  `carID` int(11) NOT NULL,
  `rent` double(255, 0) NOT NULL COMMENT '1日为计算单位，eg：100/日',
  `carName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `brank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆状况，eg：几年车等描述',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '几座的、“小巴、5座、7座“',
  `carInfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`carID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of t_car
-- ----------------------------
BEGIN;
INSERT INTO `t_car` VALUES (1, 550, '卡罗拉', '丰田', '5座', '紧凑型', 5), (2, 550, '轩逸', '日产', '5座', '紧凑型', 5), (3, 350, '五菱宏光', '五菱', '7座', 'MPV', 5), (4, 550, '昂克赛拉', '马自达', '5座', '紧凑型', 5), (5, 400, '捷达', '大众', '5座', '紧凑型', 5), (6, 900, 'CR-V', '本田', '5座', 'SUV', 5), (7, 850, 'H6', '哈佛', '5座', 'SUV', 5), (8, 550, '雷凌', '丰田', '5座', '紧凑型', 5), (9, 650, 'M50V', '启辰', '7座', 'MPV', 5), (10, 880, 'GL6', '别克', '7座', 'MPV', 5), (11, 650, '雅阁', '本田', '5座', '紧凑型', 5), (12, 550, '飞度', '本田', '5座', '紧凑型', 5);
COMMIT;

-- ----------------------------
-- Table structure for t_contract
-- ----------------------------
DROP TABLE IF EXISTS `t_contract`;
CREATE TABLE `t_contract`  (
  `carID` int(11) NOT NULL COMMENT '车辆编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `license` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '驾驶证',
  `time` date NOT NULL COMMENT '时间',
  `rent` double(255, 0) UNSIGNED NOT NULL COMMENT '租金',
  `userID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`carID`, `userID`) USING BTREE,
  CONSTRAINT `carID_contract` FOREIGN KEY (`carID`) REFERENCES `t_car` (`carID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Table structure for t_login
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `userPassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of t_login
-- ----------------------------
BEGIN;
INSERT INTO `t_login` VALUES (1, 'rjl', '123456'), (2, 'lrh', '123456'), (3, 'xx', '123456');
COMMIT;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `userID` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `license` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '驾驶证',
  `IDCard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证',
  `carID` int(11) NOT NULL COMMENT '车辆编号',
  PRIMARY KEY (`userID`) USING BTREE,
  INDEX `carID_user`(`carID`) USING BTREE,
  CONSTRAINT `carID_user` FOREIGN KEY (`carID`) REFERENCES `t_car` (`carID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
