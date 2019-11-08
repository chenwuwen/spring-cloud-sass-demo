/*
 Navicat Premium Data Transfer

 Source Server         : 106.75.96.225
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : 106.75.96.225:4040
 Source Schema         : tt

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : 65001

 Date: 08/11/2019 16:21:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TENANT
-- ----------------------------
DROP TABLE IF EXISTS `TENANT`;
CREATE TABLE `TENANT`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TENANT_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `SIMPLICITY` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DOMAIN` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DB_URL` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DB_USER` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DB_PASS` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `REGISTER_DATE` date NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of TENANT
-- ----------------------------
INSERT INTO `TENANT` VALUES (1, '苏宁', 'suning', 'suning.kanyun.cn', 'jdbc:mysql://localhost:3306/suning?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC', 'root', 'root', '2019-10-23');
INSERT INTO `TENANT` VALUES (2, '物美', 'wumei', 'wumei.kanyun.cn', 'jdbc:mysql://localhost:3306/wumei?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC', 'root', 'root', '2019-10-23');
INSERT INTO `TENANT` VALUES (3, '默认数据库', 'primary', 'master', 'jdbc:mysql://localhost:3306/primary?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC', 'root', 'root', '2019-10-23');

SET FOREIGN_KEY_CHECKS = 1;
