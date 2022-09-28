/*
 Navicat Premium Data Transfer

 Source Server         : yicheng
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : a_db_epc

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 28/09/2022 14:11:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_resident
-- ----------------------------
DROP TABLE IF EXISTS `sys_resident`;
CREATE TABLE `sys_resident`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `id_number` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `tenant` int(0) NULL DEFAULT NULL COMMENT '是否为租客：1：租客，0：非租客',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resident
-- ----------------------------
INSERT INTO `sys_resident` VALUES (10001, 'zhangsan1', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, '女', 0, '2022-09-28 11:26:32', '2022-09-28 11:26:28', NULL);
INSERT INTO `sys_resident` VALUES (10002, NULL, '1', NULL, '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_resident` VALUES (10003, 'zhangsan2', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, '女', 0, '2022-09-28 11:26:32', '2022-09-28 11:26:28', NULL);
INSERT INTO `sys_resident` VALUES (10004, 'zhangsan2', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, '女', 0, '2022-09-28 11:26:32', '2022-09-28 11:26:28', NULL);
INSERT INTO `sys_resident` VALUES (10005, 'zhangsan2', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, '女', 0, '2022-09-28 11:26:32', '2022-09-28 11:26:28', NULL);
INSERT INTO `sys_resident` VALUES (10006, NULL, NULL, '2', '2', '2', '12', '2', '2', 11, NULL, '2022-09-28 13:52:07', NULL);
INSERT INTO `sys_resident` VALUES (10007, 'zhangsan2', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, '女', 0, '2022-09-28 11:26:32', '2022-09-28 11:26:28', NULL);
INSERT INTO `sys_resident` VALUES (10008, 'zhangsan2', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, '女', 0, '2022-09-28 11:26:32', '2022-09-28 11:26:28', NULL);
INSERT INTO `sys_resident` VALUES (10009, 'zhangsan6', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, '女', 0, '2022-09-28 11:26:32', '2022-09-28 11:26:28', NULL);
INSERT INTO `sys_resident` VALUES (10010, 'zhangsan6', '123456', '张三', '18203458965', '414148596878985689', NULL, NULL, NULL, 0, NULL, '2022-09-28 13:53:48', NULL);
INSERT INTO `sys_resident` VALUES (10011, 'lisi', 'e10adc3949ba59abbe56e057f20f883e', 'lisi', '18203458965', '414148596878985689', NULL, NULL, NULL, 0, NULL, '2022-09-28 13:53:52', NULL);

SET FOREIGN_KEY_CHECKS = 1;
