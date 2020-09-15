/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : merchant

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 15/09/2020 23:03:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for merchant_base_info
-- ----------------------------
DROP TABLE IF EXISTS `merchant_base_info`;
CREATE TABLE merchant.`merchant_base_info`  (
  `id` bigint(0) NOT NULL,
  `merchant_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户名称',
  `merchant_full_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司全称',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人姓名',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `merchant_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户号（商户唯一）',
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态 启用：enable 禁用：disable',
  `deleted` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'normal' COMMENT '是否删除 正常：normal 删除：delete',
  `created` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `merchant_name`(`merchant_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_product
-- ----------------------------
DROP TABLE IF EXISTS `merchant_product`;
CREATE TABLE merchant.`merchant_product`  (
  `id` bigint(0) NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `product_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品编码',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  `product_desc` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_resource
-- ----------------------------
DROP TABLE IF EXISTS `merchant_resource`;
CREATE TABLE merchant.`merchant_resource`  (
  `id` bigint(0) NOT NULL,
  `resource_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '排序',
  `level` int(0) NOT NULL DEFAULT 0 COMMENT '排序',
  `product_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品类型',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源图标',
  `sys_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'm' COMMENT '系统类型 客户端：s 商户端：m',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '编码',
  `super_pmsn_id` bigint(0) NULL DEFAULT NULL COMMENT '父资源权限表id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`product_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_role
-- ----------------------------
DROP TABLE IF EXISTS `merchant_role`;
CREATE TABLE merchant.`merchant_role`  (
  `id` bigint(0) NOT NULL,
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `product_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品类型',
  `merchant_id` bigint(0) NOT NULL COMMENT '商户ID',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  `role_desc` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `role_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`merchant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_role_resource_relate
-- ----------------------------
DROP TABLE IF EXISTS `merchant_role_resource_relate`;
CREATE TABLE merchant.`merchant_role_resource_relate`  (
  `id` bigint(0) NOT NULL,
  `role_id` bigint(0) NOT NULL COMMENT '角色id',
  `resource_id` bigint(0) NOT NULL COMMENT '资源id',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_sys_relate
-- ----------------------------
DROP TABLE IF EXISTS `merchant_sys_relate`;
CREATE TABLE merchant.`merchant_sys_relate`  (
  `id` bigint(0) NOT NULL,
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `product_id` bigint(0) NOT NULL COMMENT '所属产品id',
  `product_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品类型',
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态：可用：enable 禁用：disable',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`merchant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商户系统关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_user
-- ----------------------------
DROP TABLE IF EXISTS `merchant_user`;
CREATE TABLE merchant.`merchant_user`  (
  `id` bigint(0) NOT NULL,
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `user_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `deleted` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal' COMMENT '是否删除 正常：normal 删除：delete',
  `position` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `is_admin` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'no' COMMENT '是否是管理员 是：yes  否:no ',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`merchant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商户用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_user_identity
-- ----------------------------
DROP TABLE IF EXISTS `merchant_user_identity`;
CREATE TABLE merchant.`merchant_user_identity`  (
  `id` bigint(0) NOT NULL,
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `user_id` bigint(0) NOT NULL COMMENT '用户id',
  `identity_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识编号',
  `identity_type` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识类型 账号：account，手机号：tel',
  `identity_content` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识主体（密码等）',
  `salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加盐',
  `login_error_num` int(0) NOT NULL DEFAULT 0 COMMENT '登录错误次数',
  `pwd_status` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'init' COMMENT '密码状态 初始化：init  重置：reset',
  `deleted` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'normal' COMMENT '是否删除 正常：normal 删除：delete',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`merchant_id`) USING BTREE,
  INDEX `idx2`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户通行证' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_user_identity_log
-- ----------------------------
DROP TABLE IF EXISTS `merchant_user_identity_log`;
CREATE TABLE merchant.`merchant_user_identity_log`  (
  `id` bigint(0) NOT NULL,
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `user_id` bigint(0) NOT NULL COMMENT '用户id',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 登录：login  登出：logout',
  `login_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录ip',
  `operator_id` bigint(0) NOT NULL COMMENT '操作人id',
  `product_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品类型',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`merchant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户登录登出日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_user_role_relate
-- ----------------------------
DROP TABLE IF EXISTS `merchant_user_role_relate`;
CREATE TABLE merchant.`merchant_user_role_relate`  (
  `id` bigint(0) NOT NULL,
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `user_id` bigint(0) NOT NULL COMMENT '用户id',
  `role_id` bigint(0) NOT NULL COMMENT '角色id',
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态：正常：normal 禁用：stop',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`merchant_id`) USING BTREE,
  INDEX `idx2`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchant_user_unit_relate
-- ----------------------------
DROP TABLE IF EXISTS `merchant_user_unit_relate`;
CREATE TABLE merchant.`merchant_user_unit_relate`  (
  `id` bigint(0) NOT NULL,
  `merchant_id` bigint(0) NOT NULL COMMENT '商户id',
  `building_id` bigint(0) NOT NULL COMMENT '楼道id',
  `user_id` bigint(0) NOT NULL COMMENT '用户id',
  `unit_id` bigint(0) NOT NULL COMMENT '单元id',
  `init_water_level` decimal(15, 3) NOT NULL COMMENT '初始水位',
  `water_money` decimal(15, 3) NOT NULL COMMENT '单位水费',
  `init_eletricity_level` decimal(15, 3) NOT NULL COMMENT '初始电位',
  `eletricity_money` decimal(15, 3) NOT NULL COMMENT '单位电费',
  `network_ip` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元IP',
  `network_port` int(0) NULL DEFAULT NULL COMMENT '单元端口',
  `network_speed` int(0) NULL DEFAULT NULL COMMENT '单元网速',
  `network_money` decimal(15, 3) NOT NULL COMMENT '单位网费',
  `bill_date` datetime(0) NOT NULL COMMENT '生成账单时间',
  `start_time` datetime(0) NOT NULL COMMENT '租赁开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '租赁结束时间',
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态：正常：normal 过期：overtime',
  `deleted` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal' COMMENT '是否删除 正常：normal 删除：delete',
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creator` bigint(0) NOT NULL COMMENT '创建人',
  `modifier` bigint(0) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx1`(`merchant_id`) USING BTREE,
  INDEX `idx2`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户单元关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rent_building_info
-- ----------------------------
DROP TABLE IF EXISTS `rent_building_info`;
CREATE TABLE merchant.`rent_building_info`  (
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
CREATE TABLE merchant.`rent_unit_info`  (
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
