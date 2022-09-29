/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 29/09/2022 21:16:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `visitTime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问时间',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方法',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, '2022-09-11 22:59:20', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.ProductController.findAll');
INSERT INTO `log` VALUES (2, '2022-09-14 09:23:24', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.ProductController.findAll');
INSERT INTO `log` VALUES (3, '2022-09-14 09:23:44', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.ProductController.findAll');
INSERT INTO `log` VALUES (4, '2022-09-29 21:02:17', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.PermissionContriller.findAll');
INSERT INTO `log` VALUES (5, '2022-09-29 21:02:41', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.findAll');
INSERT INTO `log` VALUES (6, '2022-09-29 21:03:01', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.findAll');
INSERT INTO `log` VALUES (7, '2022-09-29 21:03:04', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.ProductController.findAll');
INSERT INTO `log` VALUES (8, '2022-09-29 21:09:05', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.ProductController.findAll');
INSERT INTO `log` VALUES (9, '2022-09-29 21:09:05', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.findAll');
INSERT INTO `log` VALUES (10, '2022-09-29 21:09:05', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.PermissionContriller.findAll');
INSERT INTO `log` VALUES (11, '2022-09-29 21:10:16', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.PermissionContriller.findAll');
INSERT INTO `log` VALUES (12, '2022-09-29 21:10:20', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.findAll');
INSERT INTO `log` VALUES (13, '2022-09-29 21:10:24', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.addPermissionsToRoleUI');
INSERT INTO `log` VALUES (14, '2022-09-29 21:10:28', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.addPermissionsToRole');
INSERT INTO `log` VALUES (15, '2022-09-29 21:10:28', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.findAll');
INSERT INTO `log` VALUES (16, '2022-09-29 21:10:51', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.RoleController.findAll');
INSERT INTO `log` VALUES (17, '2022-09-29 21:11:00', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.PermissionContriller.findAll');
INSERT INTO `log` VALUES (18, '2022-09-29 21:11:11', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.ProductController.findAll');
INSERT INTO `log` VALUES (19, '2022-09-29 21:11:15', 'admin', '0:0:0:0:0:0:0:1', 'com.emora.controller.OrderController.findAll');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `orderTime` datetime NULL DEFAULT NULL,
  `peopleCount` int NULL DEFAULT NULL,
  `oderDesc` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `payType` int NULL DEFAULT NULL,
  `oderStatus` int NULL DEFAULT NULL,
  `productId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `orderNum`(`orderNum`) USING BTREE,
  INDEX `productId`(`productId`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '1', '2022-09-10 11:29:28', 100, '团建', 1, 1, 1);
INSERT INTO `orders` VALUES (2, '2', '2022-09-10 17:11:03', 200, '玩呀', 0, 1, 2);
INSERT INTO `orders` VALUES (3, '3', '2022-09-10 12:29:00', 46, '爬山', 1, 2, 2);
INSERT INTO `orders` VALUES (4, '4', '2022-09-22 17:13:44', 20, '旅游', 1, 1, 1);
INSERT INTO `orders` VALUES (5, '5', '2022-09-14 17:14:22', 40, '划船', 1, 0, 1);
INSERT INTO `orders` VALUES (6, '6', '2022-09-14 17:15:08', 50, '看日出', 2, 1, 1);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permissionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pid` bigint NULL DEFAULT NULL COMMENT '上级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '系统管理', NULL, 0);
INSERT INTO `permission` VALUES (2, '基础数据', NULL, 0);
INSERT INTO `permission` VALUES (3, '用户管理', '/usr/findAll', 1);
INSERT INTO `permission` VALUES (4, '产品管理', '/product', 2);
INSERT INTO `permission` VALUES (5, '角色管理', '/role/findAll', 1);
INSERT INTO `permission` VALUES (6, '订单管理', '/orders/findAll', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '无意义',
  `productNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '产品编号，唯一，不为空',
  `productName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品名称',
  `cityName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出发城市',
  `departureTime` datetime NULL DEFAULT NULL COMMENT '出发时间',
  `productPrice` double(8, 2) NULL DEFAULT NULL COMMENT '产品价格',
  `productDesc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品描述',
  `status` int NULL DEFAULT NULL COMMENT ' 状态（0 close 1 open）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `产品编号`(`productNum`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '001', '黄淮一日游', '上海', '2022-09-09 19:21:28', 200.00, '校园游', 1);
INSERT INTO `product` VALUES (2, '002', '东方明珠', '北京', '2022-09-28 23:36:06', 515.00, '闲逛', 1);
INSERT INTO `product` VALUES (3, '003', '长沙', '武汉', '2022-09-28 14:44:41', 116.00, '玩呀', 1);
INSERT INTO `product` VALUES (4, '004', '上海', '三门峡', '2022-09-06 14:45:13', 151.00, '团建', 1);
INSERT INTO `product` VALUES (5, '005', '北京', '驻马店', '2022-09-19 14:45:56', 461.00, '玩', 0);
INSERT INTO `product` VALUES (6, '006', '驻马店', '上海', '2022-09-21 14:46:36', 1514.00, '团建', 1);
INSERT INTO `product` VALUES (7, '007', '阿嘎', '不合适', '2022-09-07 15:24:48', 421.00, '刷', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL COMMENT '角色id 主键自增',
  `roleName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  `roleDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ADMIN', '超级管理员');
INSERT INTO `role` VALUES (2, 'USER', '普通用户');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `roleId` int NOT NULL COMMENT '用户id',
  `permissionId` int NOT NULL COMMENT '权限id',
  PRIMARY KEY (`roleId`, `permissionId`) USING BTREE,
  INDEX `permissionId`(`permissionId`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (1, 2);
INSERT INTO `role_permission` VALUES (1, 3);
INSERT INTO `role_permission` VALUES (1, 4);
INSERT INTO `role_permission` VALUES (2, 4);
INSERT INTO `role_permission` VALUES (1, 5);
INSERT INTO `role_permission` VALUES (2, 5);
INSERT INTO `role_permission` VALUES (1, 6);
INSERT INTO `role_permission` VALUES (2, 6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `username` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名字',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户邮箱',
  `password` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `phoneNum` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE COMMENT '用户名字'
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'emora', '1937620103@qq.com', '123456', '15603977353', 1);
INSERT INTO `user` VALUES (2, 'justin', '123456@qq.com', '456789', '126345645', 0);
INSERT INTO `user` VALUES (3, 'nuanu', '12515@qq.com', '13151', '15515515', 1);
INSERT INTO `user` VALUES (4, 'niania', '516565', '165415', '1561615', 0);
INSERT INTO `user` VALUES (5, 'ahg', '3616561', '431231', '1635165', 1);
INSERT INTO `user` VALUES (6, '2161', '4165', '15605', '14565', 0);
INSERT INTO `user` VALUES (7, 'ghjd', 'djjdgjd', '123456', '24534', 1);
INSERT INTO `user` VALUES (8, '嘎嘎嘎', '16515@qq.com', '876b653e96a174bfcb4e25c8bcb226c5', '11651', 1);
INSERT INTO `user` VALUES (9, 'HSERHGA', '416416@agsa', '78ebd2c61cbb5f9b1fd3791f90bc37f4', '1631', 1);
INSERT INTO `user` VALUES (10, 'emoraBoy', '1616@qq.com', '9e757e18c096ad874e023e0f5986e7ed', '15603977353', 1);
INSERT INTO `user` VALUES (11, 'emo', '1840326847@qq.com', '$2a$10$eYsWtzkDWi4iFYmul/GjDOykdM.fKGEepU2AKlYUymXNbS3Hiptsm', '15603977353', 1);
INSERT INTO `user` VALUES (14, 'egag', '54646', '$2a$10$01Dj.DGHk4lxXOQLnL2xYeF4ATwAKsO.pc8ZHXY6GAsRLKvkyA2Ty', '115', 0);
INSERT INTO `user` VALUES (17, 'admin', '1937620103@qq.com', '$2a$10$3nvrU6dzRdZPCwrO5lHoeOtfjy0lGECUTZ9kR.XDXAOEUbW2MfTu2', '15603977353', 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `userId` int NOT NULL,
  `roleId` int NOT NULL,
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 1);
INSERT INTO `user_role` VALUES (17, 1);
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (17, 2);

SET FOREIGN_KEY_CHECKS = 1;
