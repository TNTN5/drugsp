/*
 Navicat Premium Data Transfer

 Source Server         : DBeaver
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : drug

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 21/03/2022 19:21:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_admin
-- ----------------------------
DROP TABLE IF EXISTS `d_admin`;
CREATE TABLE `d_admin`  (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理員id',
  `a_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理員用戶名',
  `a_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理員密碼',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_admin
-- ----------------------------
INSERT INTO `d_admin` VALUES (1, 'root', 'root');

-- ----------------------------
-- Table structure for d_classify
-- ----------------------------
DROP TABLE IF EXISTS `d_classify`;
CREATE TABLE `d_classify`  (
  `c_id` int(11) NOT NULL COMMENT '分類id',
  `c_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分類名',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_classify
-- ----------------------------
INSERT INTO `d_classify` VALUES (1, '抗菌消炎药');
INSERT INTO `d_classify` VALUES (2, '消化系统药');
INSERT INTO `d_classify` VALUES (3, '呼吸系统药');
INSERT INTO `d_classify` VALUES (4, '泌尿系统药');
INSERT INTO `d_classify` VALUES (5, '妇科用药');
INSERT INTO `d_classify` VALUES (6, '儿科用药');
INSERT INTO `d_classify` VALUES (7, '注射液');

-- ----------------------------
-- Table structure for d_drugs
-- ----------------------------
DROP TABLE IF EXISTS `d_drugs`;
CREATE TABLE `d_drugs`  (
  `d_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '藥品序號',
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '藥品名',
  `d_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '價格',
  `d_decpict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品描述信息',
  `c_id` int(11) NULL DEFAULT NULL COMMENT '分類id',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '發佈商品藥店id',
  `d_stock` int(100) NULL DEFAULT NULL COMMENT '药品库存',
  PRIMARY KEY (`d_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_drugs
-- ----------------------------
INSERT INTO `d_drugs` VALUES (12, '软骨散', 99.90, '偷香窃玉必备，浑身酥软不能动，任由大侠摆布', 5, 5, 67);
INSERT INTO `d_drugs` VALUES (13, '测试药001', 1.00, '测试药001', 2, 5, 23);
INSERT INTO `d_drugs` VALUES (14, '测试药002', 2.00, '测试药002', 2, 5, 5);
INSERT INTO `d_drugs` VALUES (15, '测试药003', 40.80, '测试药003', 1, 5, 24);

-- ----------------------------
-- Table structure for d_message
-- ----------------------------
DROP TABLE IF EXISTS `d_message`;
CREATE TABLE `d_message`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言序號',
  `u_id` int(11) NULL DEFAULT NULL COMMENT '用戶id',
  `m_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  `m_time` datetime(0) NULL DEFAULT NULL COMMENT '留言時間',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_message
-- ----------------------------
INSERT INTO `d_message` VALUES (2, 2, '这也是一条留言这也是一条留言这也是一条留言这也是一条留言这也是一条留言', '2022-03-15 23:13:12');
INSERT INTO `d_message` VALUES (3, 3, '这还是一条留言这还是一条留言这还是一条留言', '2022-03-07 23:14:05');
INSERT INTO `d_message` VALUES (4, 4, '一条留言一条留言一条留言', '2022-03-21 23:18:48');
INSERT INTO `d_message` VALUES (5, 3, '测试留言', '2022-03-19 09:51:57');
INSERT INTO `d_message` VALUES (6, 3, '测试', '2022-03-19 09:53:36');
INSERT INTO `d_message` VALUES (8, 3, 'nmbvcx', '2022-03-21 14:32:49');

-- ----------------------------
-- Table structure for d_order
-- ----------------------------
DROP TABLE IF EXISTS `d_order`;
CREATE TABLE `d_order`  (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序號',
  `d_id` int(11) NULL DEFAULT NULL COMMENT '藥品id',
  `d_num` int(11) NULL DEFAULT NULL COMMENT '药品数量',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '商家id',
  `u_id` int(11) NULL DEFAULT NULL COMMENT '買家用戶id',
  `o_createtime` datetime(0) NULL DEFAULT NULL COMMENT '訂單創建時間',
  `o_finishtime` datetime(0) NULL DEFAULT NULL COMMENT '訂單完成時間',
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_order
-- ----------------------------
INSERT INTO `d_order` VALUES (21, 12, 3, 5, 3, '2022-03-21 19:12:55', NULL);
INSERT INTO `d_order` VALUES (22, 14, 5, 5, 3, '2022-03-21 19:13:02', '2022-03-21 19:13:17');
INSERT INTO `d_order` VALUES (23, 14, 2, 5, 3, '2022-03-21 19:13:05', '2022-03-21 19:13:16');
INSERT INTO `d_order` VALUES (24, 12, 8, 5, 3, '2022-03-21 19:13:10', '2022-03-21 19:13:14');

-- ----------------------------
-- Table structure for d_reply
-- ----------------------------
DROP TABLE IF EXISTS `d_reply`;
CREATE TABLE `d_reply`  (
  `r_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回復id',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '回復人id',
  `m_id` int(11) NULL DEFAULT NULL COMMENT '回復對應的留言id',
  `r_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回復内容',
  `r_time` datetime(0) NULL DEFAULT NULL COMMENT '回復時間',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_reply
-- ----------------------------
INSERT INTO `d_reply` VALUES (9, 5, 4, '回复测试001', '2022-03-21 19:08:28');

-- ----------------------------
-- Table structure for d_shops
-- ----------------------------
DROP TABLE IF EXISTS `d_shops`;
CREATE TABLE `d_shops`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家id',
  `s_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家用戶名',
  `s_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密碼',
  `s_realname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `s_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '電話',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_shops
-- ----------------------------
INSERT INTO `d_shops` VALUES (5, '测试商家001', '001', '周扒皮', '34534534534');

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用戶id',
  `u_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用戶名',
  `u_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密碼',
  `u_realname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真實姓名',
  `u_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '電話',
  `u_sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性別',
  `u_age` int(3) NULL DEFAULT NULL COMMENT '年齡',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of d_user
-- ----------------------------
INSERT INTO `d_user` VALUES (2, 'bb', 'bb', '小夫', '2222222222', '男', 13);
INSERT INTO `d_user` VALUES (3, 'cc', 'cc', '静香111', '3333333333', '男', 15);
INSERT INTO `d_user` VALUES (4, 'dd', 'dd', '迪迦', '4444444444', '男', 89);
INSERT INTO `d_user` VALUES (5, 'ee', 'ee', '桃之柱', '33333333333', '男', 11);
INSERT INTO `d_user` VALUES (16, '测试用户001', '001', '吉吉国王', '12312312311', '男', 23);

SET FOREIGN_KEY_CHECKS = 1;
