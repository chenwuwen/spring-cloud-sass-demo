/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : primary

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 08/11/2019 16:26:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tenant_biz
-- ----------------------------
DROP TABLE IF EXISTS `tenant_biz`;
CREATE TABLE `tenant_biz`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `BIZ_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `BIZ_COMMENT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_biz
-- ----------------------------
INSERT INTO `tenant_biz` VALUES (1, '默认库业务1', '默认库业务说明1');
INSERT INTO `tenant_biz` VALUES (2, '默认库业务2', '默认库业务说明2');

-- ----------------------------
-- Table structure for tenant_user
-- ----------------------------
DROP TABLE IF EXISTS `tenant_user`;
CREATE TABLE `tenant_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `REGISTER_DATE` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_user
-- ----------------------------
INSERT INTO `tenant_user` VALUES (1, '默认库', '默认库', NULL);

SET FOREIGN_KEY_CHECKS = 1;
