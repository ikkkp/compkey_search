/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : ebusiness

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 03/12/2023 00:51:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for behavior
-- ----------------------------
DROP TABLE IF EXISTS `behavior`;
CREATE TABLE `behavior`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `behavior` int NOT NULL,
  `commodity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of behavior
-- ----------------------------

-- ----------------------------
-- Table structure for fashion
-- ----------------------------
DROP TABLE IF EXISTS `fashion`;
CREATE TABLE `fashion`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `URL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `degree` float NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fashion
-- ----------------------------

-- ----------------------------
-- Table structure for keyword
-- ----------------------------
DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `between` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `compete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `correlation` float NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of keyword
-- ----------------------------
INSERT INTO `keyword` VALUES (12, '壁纸', '手机', '下载', 0.0154081);
INSERT INTO `keyword` VALUES (13, '壁纸', '高清', '图片', 0.112903);
INSERT INTO `keyword` VALUES (14, '壁纸', '图片', '大全', 0.00366151);
INSERT INTO `keyword` VALUES (15, '壁纸', '大全', '图片', 0.00240881);
INSERT INTO `keyword` VALUES (16, '壁纸', '动漫', '头像', 0.0187793);
INSERT INTO `keyword` VALUES (17, '壁纸', '电脑', '笔记本', 0.00897868);
INSERT INTO `keyword` VALUES (18, '壁纸', '动态', '图片', 0.0855263);
INSERT INTO `keyword` VALUES (19, '壁纸', '权志龙', '无限', 0.0402685);
INSERT INTO `keyword` VALUES (20, '壁纸', '好看', '小说', 0.00794913);
INSERT INTO `keyword` VALUES (21, '壁纸', '长草', '团子', 0.5);
INSERT INTO `keyword` VALUES (22, '照片', '整容', '郑爽', 0.289941);
INSERT INTO `keyword` VALUES (23, '照片', '手机', '下载', 0.00761937);
INSERT INTO `keyword` VALUES (24, '照片', '身份证', '号码', 0.091623);
INSERT INTO `keyword` VALUES (25, '照片', '手持', '身份证', 0);
INSERT INTO `keyword` VALUES (26, '照片', '大全', '图片', 0.0079283);
INSERT INTO `keyword` VALUES (27, '照片', '软件', '手机', 0.0193772);
INSERT INTO `keyword` VALUES (28, '照片', '性感', '图片', 0.129534);
INSERT INTO `keyword` VALUES (29, '照片', '老婆', '总裁', 0.0425894);
INSERT INTO `keyword` VALUES (30, '照片', 'qq', '头像', 0.00941915);
INSERT INTO `keyword` VALUES (31, '照片', '曝光', 'iphone7', 0.155844);

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `keyword_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `seo_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of result
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `usertype` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
