/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : security

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 13/07/2020 11:51:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NULL DEFAULT NULL,
  `Role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreatedDT` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 1, 'admin', '2020-07-13 10:10:39');
INSERT INTO `role` VALUES (2, 2, 'abc', '2020-07-13 10:10:50');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CreatedDT` datetime(0) NULL DEFAULT NULL,
  `Age` int(11) NULL DEFAULT NULL,
  `Gender` int(11) NULL DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '小明', '2020-07-13 10:09:10', 18, 1, '123456');
INSERT INTO `user` VALUES (2, '小红', '2020-07-13 10:09:38', 19, 0, '123456');

SET FOREIGN_KEY_CHECKS = 1;
