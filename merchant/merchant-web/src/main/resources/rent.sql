/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : rent

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 15/09/2020 23:03:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rent_bill_info
-- ----------------------------
DROP TABLE IF EXISTS `rent_bill_info`;
CREATE TABLE rent.`rent_bill_info`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `unit_id` bigint(0) NOT NULL COMMENT '单元id',
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `tenant_id` bigint(0) NOT NULL COMMENT '租户id',
  `fee_level` decimal(15, 3) NOT NULL COMMENT '账单数量',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账单类型（water：水费；ele：电费；net：网费）',
  `bill_times` int(0) NOT NULL DEFAULT 0 COMMENT '账单期数',
  `bill_money` decimal(15, 3) NOT NULL COMMENT '核算金额',
  `bill_date` datetime(0) NULL DEFAULT NULL COMMENT '账单时间',
  `deleted` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal' COMMENT '是否使用（正常：normal , 删除: deleted）',
  `bill_repay_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账单付款状态 not_repay：未付款 some_repay：部分付款 all_repay：已付款',
  `overdue_day` int(0) NULL DEFAULT NULL COMMENT '逾期天数',
  `created` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `creator` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建人',
  `updated` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `modifier` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rent_building_info
-- ----------------------------
DROP TABLE IF EXISTS `rent_building_info`;
CREATE TABLE rent.`rent_building_info`  (
  `id` bigint(0) NOT NULL,
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼道地址',
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `gate_way` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络网关',
  `contact_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `contact_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `deleted` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal' COMMENT '是否删除 正常：normal 删除：delete',
  `created` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商户楼道信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rent_unit_info
-- ----------------------------
DROP TABLE IF EXISTS `rent_unit_info`;
CREATE TABLE rent.`rent_unit_info`  (
  `id` bigint(0) NOT NULL,
  `unit_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单元',
  `floor` int(0) NOT NULL COMMENT '层数',
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `building_id` bigint(0) NOT NULL COMMENT '楼道id',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络ip',
  `deleted` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal' COMMENT '是否删除 正常：normal 删除：delete',
  `created` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '楼道单元信息' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
