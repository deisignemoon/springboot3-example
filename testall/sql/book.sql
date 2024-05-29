/*
 Navicat Premium Data Transfer

 Source Server         : local-docker-mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 192.168.197.100:3306
 Source Schema         : maindata

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 14/05/2024 16:15:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age_rating` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Clifford: It\'s Pool Time!', 0);
INSERT INTO `book` VALUES (2, 'The Rescue Mission: (Pokemon: Kalos Reader #1)', 4);
INSERT INTO `book` VALUES (3, 'Dragonlance Chronicles Vol. 1: Dragons of Autumn Twilight', 9);
INSERT INTO `book` VALUES (4, 'The Three-Body Problem', 14);

SET FOREIGN_KEY_CHECKS = 1;
