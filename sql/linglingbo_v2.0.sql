/*
 Navicat Premium Data Transfer

 Source Server         : linglingbo
 Source Server Type    : MySQL
 Source Server Version : 50718 (5.7.18-cynos-log)
 Source Host           : sh-cynosdbmysql-grp-gt0q8bdg.sql.tencentcdb.com:27950
 Source Schema         : linglingbo

 Target Server Type    : MySQL
 Target Server Version : 50718 (5.7.18-cynos-log)
 File Encoding         : 65001

 Date: 22/11/2022 14:57:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_cate_goods_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_cate_goods_relation`;
CREATE TABLE `tbl_cate_goods_relation`  (
  `id` bigint(20) NOT NULL,
  `object_id` bigint(20) NULL DEFAULT NULL COMMENT '业务对象id（task_id，streamer_id，owner_id）',
  `cate_goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类id',
  `client_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'id 类型(streamer,owner,task)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_cate_goods_relation
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_category_goods
-- ----------------------------
DROP TABLE IF EXISTS `tbl_category_goods`;
CREATE TABLE `tbl_category_goods`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '带货商品分类名',
  `category_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品分类描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '带货商品分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_category_goods
-- ----------------------------
INSERT INTO `tbl_category_goods` VALUES (1, 'test', 'test', NULL, '2022-10-25 13:50:34', 1);
INSERT INTO `tbl_category_goods` VALUES (2, '分类1-2', NULL, NULL, '2022-11-16 14:16:28', 1);
INSERT INTO `tbl_category_goods` VALUES (3, '分类1-3', NULL, NULL, '2022-11-16 14:17:05', 1);
INSERT INTO `tbl_category_goods` VALUES (4, '分类2', NULL, NULL, '2022-11-16 14:17:30', 1);
INSERT INTO `tbl_category_goods` VALUES (1365341598605312, '东北特色', '炖锅', '2022-10-25 13:45:56', NULL, 0);
INSERT INTO `tbl_category_goods` VALUES (1365341607936000, '书籍', '金瓶梅', '2022-10-25 13:46:08', NULL, 0);
INSERT INTO `tbl_category_goods` VALUES (1365341623779328, '手机数码', 'iphone17', '2022-10-25 13:46:27', '2022-11-16 15:24:14', 0);
INSERT INTO `tbl_category_goods` VALUES (1365341630332928, '护肤', '自然堂', '2022-10-25 13:46:35', NULL, 0);
INSERT INTO `tbl_category_goods` VALUES (1365341637877760, '玩具', '奥特曼', '2022-10-25 13:46:44', NULL, 0);
INSERT INTO `tbl_category_goods` VALUES (1365341647224832, '珠宝首饰', '钻戒', '2022-10-25 13:46:55', NULL, 0);
INSERT INTO `tbl_category_goods` VALUES (1365341684768768, '童装', 'Adidas', '2022-10-25 13:47:41', NULL, 0);
INSERT INTO `tbl_category_goods` VALUES (1365341692575744, '男装', '花花公子', '2022-10-25 13:47:51', NULL, 0);
INSERT INTO `tbl_category_goods` VALUES (1366900834910208, '笔记本电脑', '温故而知新。', '2022-11-16 14:28:41', '2022-11-16 15:24:26', 0);
INSERT INTO `tbl_category_goods` VALUES (1366900922572800, '手机', '众恶之，必察焉；众好之，必察焉。', '2022-11-16 14:30:28', NULL, 0);

-- ----------------------------
-- Table structure for tbl_client_withdraw_cash
-- ----------------------------
DROP TABLE IF EXISTS `tbl_client_withdraw_cash`;
CREATE TABLE `tbl_client_withdraw_cash`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `client_id` bigint(20) NULL DEFAULT NULL COMMENT '主播/品牌商id',
  `company_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属企业名称(主播可不填，也可以填主播账号名称)',
  `withdraw_amount` decimal(8, 2) NULL DEFAULT NULL COMMENT '提现金额',
  `card_num` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提现卡号',
  `bank` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '开户行',
  `person_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提现人姓名',
  `remark` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注描述',
  `withdraw_status` int(10) NULL DEFAULT 1 COMMENT '状态 1: 审核中2: 已完成 3: 提现失败',
  `auditor_admin_id` bigint(20) NOT NULL COMMENT '审核人id(管理员)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '主播/品牌商提现表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_client_withdraw_cash
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_goods
-- ----------------------------
DROP TABLE IF EXISTS `tbl_goods`;
CREATE TABLE `tbl_goods`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `owner_id` bigint(20) NULL DEFAULT NULL COMMENT '品牌商id，对应owner的id属性',
  `goods_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_num` int(10) NULL DEFAULT 0 COMMENT '商品数量',
  `goods_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '商品售价',
  `is_shelf` tinyint(3) NULL DEFAULT NULL COMMENT '是否上架 1: 已上架 2: 已下架',
  `image_id` bigint(20) NULL DEFAULT NULL COMMENT '图片id',
  `goods_brand` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品品牌',
  `category_id` bigint(20) NOT NULL COMMENT '商品所属分类',
  `goods_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goods_spec` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_goods
-- ----------------------------
INSERT INTO `tbl_goods` VALUES (0, 1364909252878336, 'string', 0, 0.00, NULL, 0, '', 6, 'string', 'string', '2022-11-07 18:16:55', NULL, 0);
INSERT INTO `tbl_goods` VALUES (1366547574513664, 1364909252878336, '山东交通大学', 100, 100.00, NULL, 0, '江西省州庭展欧安房地产有限公司', 0, '生死有命，富贵在天。', '1', '2022-11-11 14:41:35', NULL, 0);
INSERT INTO `tbl_goods` VALUES (1366761785212928, 1364909252878336, NULL, 0, NULL, NULL, NULL, NULL, 0, NULL, NULL, '2022-11-14 15:19:42', NULL, 0);
INSERT INTO `tbl_goods` VALUES (1366889424224256, 1364909252878336, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 10, 100.00, NULL, NULL, '湖北省昌爱泽俊情房地产普通合伙', 1365341598605312, '以约失之者鲜矣。', 'xl', '2022-11-16 10:36:32', NULL, 0);
INSERT INTO `tbl_goods` VALUES (1366889459245056, 1364909252878336, '百亿补贴：美特斯邦威 男士羽绒服 229432', 10, 100.00, NULL, NULL, '湖北省昌爱泽俊情房地产普通合伙', 1365341598605312, '以约失之者鲜矣。', 'xl', '2022-11-16 10:37:14', NULL, 0);
INSERT INTO `tbl_goods` VALUES (1366889751158784, 1364909252878336, 'NIKE 耐克 Zoom Pulse 男/女运动鞋 CT1629', 10, 100.00, NULL, NULL, '湖北省昌爱泽俊情房地产普通合伙', 1365341598605312, '以约失之者鲜矣。', 'xl', '2022-11-16 10:43:11', NULL, 0);
INSERT INTO `tbl_goods` VALUES (1366890482737152, 1364909252878336, '361° 潮戈 男子运动板鞋 117554', 10, 10.00, NULL, NULL, '湖北省昌爱泽俊情房地产普通合伙', 1365341630332928, '10', '10', '2022-11-16 10:58:04', NULL, 0);
INSERT INTO `tbl_goods` VALUES (1366890975518720, 1364909252878336, 'Lanchey 86底盒修复神器 两只装', 10, 10.00, NULL, NULL, '湖北省昌爱泽俊情房地产普通合伙', 2, '10', '10', '2022-11-16 11:08:05', NULL, 0);

-- ----------------------------
-- Table structure for tbl_image
-- ----------------------------
DROP TABLE IF EXISTS `tbl_image`;
CREATE TABLE `tbl_image`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `image_id` bigint(20) NOT NULL COMMENT '图片id',
  `image_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `image_url` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片相对路径',
  `bucket_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'minio桶名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图片信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_image
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_industry_category
-- ----------------------------
DROP TABLE IF EXISTS `tbl_industry_category`;
CREATE TABLE `tbl_industry_category`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `industry_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业分类名称',
  `industry_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '行业分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_industry_category
-- ----------------------------
INSERT INTO `tbl_industry_category` VALUES (1365331957374976, '计算机', '计算机行业', '2022-10-25 10:29:47', '2022-10-25 10:42:49', 0);
INSERT INTO `tbl_industry_category` VALUES (1365331993206784, '机械', '机械自动化', '2022-10-25 10:30:31', NULL, 0);
INSERT INTO `tbl_industry_category` VALUES (1365332002349056, '土木', '土木工程', '2022-10-25 10:30:42', NULL, 0);
INSERT INTO `tbl_industry_category` VALUES (1365332013907968, '服装', '服装制作', '2022-10-25 10:30:56', NULL, 0);
INSERT INTO `tbl_industry_category` VALUES (1365332044800000, '餐饮', '重庆小面', '2022-10-25 10:31:34', NULL, 0);
INSERT INTO `tbl_industry_category` VALUES (1365332050034688, '餐饮', '麻辣香锅', '2022-10-25 10:31:40', '2022-10-25 13:39:46', 1);
INSERT INTO `tbl_industry_category` VALUES (1366904500830208, '新闻', '先天下之忧而忧，后天下之乐而乐。', '2022-11-16 15:43:16', '2022-11-16 15:56:51', 1);
INSERT INTO `tbl_industry_category` VALUES (1366904527896576, '农业', '君子喻于义，小人喻于利。11111', '2022-11-16 15:43:49', '2022-11-16 15:56:37', 1);
INSERT INTO `tbl_industry_category` VALUES (1366906393247744, '汽车', '学而不厌，诲人不倦。', '2022-11-16 16:21:46', NULL, 0);
INSERT INTO `tbl_industry_category` VALUES (1366906407747584, '出租', '子曰：君子周而不比，小人比而不周。', '2022-11-16 16:22:04', NULL, 0);

-- ----------------------------
-- Table structure for tbl_task
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task`;
CREATE TABLE `tbl_task`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `owner_id` bigint(20) NULL DEFAULT NULL COMMENT '品牌商id',
  `task_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `cooperation_model` int(10) NULL DEFAULT 1 COMMENT '合作模式： 1: 纯佣金模式 2: 佣金加坑位费',
  `commission_percent` decimal(8, 2) NULL DEFAULT NULL COMMENT '佣金比例',
  `budget` decimal(8, 2) NULL DEFAULT NULL COMMENT '预算金额',
  `task_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务描述',
  `earnest_money` decimal(8, 2) NULL DEFAULT NULL COMMENT '保证金额度',
  `task_status` int(10) NULL DEFAULT 1 COMMENT '任务状态 1: 发布中 2: 待承接 3:发布失败4: 履约中 5: 已完成 ',
  `auditor_admin_id` bigint(20) NULL DEFAULT NULL COMMENT '审核人id(管理员)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_task
-- ----------------------------
INSERT INTO `tbl_task` VALUES (0, NULL, 'string', 1, 5.00, 100.00, 'test', 100.00, 1, NULL, '2022-11-07 10:40:57', NULL, 0);
INSERT INTO `tbl_task` VALUES (5, NULL, 'test', 1, 10.00, 10.00, '君子喻于义，小人喻于利。', 10.00, 1, NULL, '2022-11-09 15:45:28', NULL, 0);
INSERT INTO `tbl_task` VALUES (10, NULL, 'test', 1, 10.00, 10.00, '君子喻于义，小人喻于利。', 10.00, 1, NULL, '2022-11-09 15:44:49', NULL, 0);

-- ----------------------------
-- Table structure for tbl_task_brand
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_brand`;
CREATE TABLE `tbl_task_brand`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `task_id` bigint(20) NULL DEFAULT NULL COMMENT '任务id',
  `brand_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌商名（已认证）',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '品牌名表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_task_brand
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_task_goods
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_goods`;
CREATE TABLE `tbl_task_goods`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `task_id` bigint(20) NULL DEFAULT NULL COMMENT '任务id',
  `goods_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_num` int(10) NULL DEFAULT 0 COMMENT '商品数量',
  `goods_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '商品售价',
  `goods_spec` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务商品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_task_goods
-- ----------------------------
INSERT INTO `tbl_task_goods` VALUES (1366252631891968, 0, '2', 0, 0.00, 'string', 111, '2022-11-07 10:40:57', NULL, 0);
INSERT INTO `tbl_task_goods` VALUES (1366409125404672, 10, '杜瑾春', 10, 10.00, '111', 31231, '2022-11-09 15:44:49', NULL, 0);
INSERT INTO `tbl_task_goods` VALUES (1366409156984832, 5, '杜瑾春', 10, 10.00, '111', 31231, '2022-11-09 15:45:28', NULL, 0);

-- ----------------------------
-- Table structure for tbl_task_settle
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_settle`;
CREATE TABLE `tbl_task_settle`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id，对应tbl_goods的id属性',
  `streamer_id` bigint(20) NULL DEFAULT NULL COMMENT '播主id',
  `task_id` bigint(20) NULL DEFAULT NULL COMMENT '任务id',
  `goods_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `sale_num` int(10) NULL DEFAULT 0 COMMENT '商品带货数量',
  `goods_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '商品售价',
  `goods_spec` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务结算商品销量表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_task_settle
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_task_streamer
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_streamer`;
CREATE TABLE `tbl_task_streamer`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `task_id` bigint(20) NULL DEFAULT NULL COMMENT '任务id，对应tbl_task的id属性',
  `auditor_owner_id` bigint(19) NULL DEFAULT NULL COMMENT '承接审核人id(品牌商)',
  `streamer_id` bigint(20) NULL DEFAULT NULL COMMENT '主播的用户id',
  `streamer_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播主的用户名',
  `commission_percent` decimal(8, 2) NULL DEFAULT NULL COMMENT '播主佣金比例',
  `fee` decimal(8, 2) NULL DEFAULT NULL COMMENT '播主坑位费金额',
  `operate_info` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播主运营信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `settle_money` decimal(8, 2) NULL DEFAULT 0.00 COMMENT '结算金额',
  `settle_remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结算备注',
  `complete_num` int(10) NULL DEFAULT 0 COMMENT '播主完成量',
  `platform_commission` decimal(8, 2) NULL DEFAULT 0.00 COMMENT '平台佣金金额',
  `task_detail_status` tinyint(3) NULL DEFAULT 1 COMMENT '任务状态：1.待承接 2.承接审核中 3.承接审核失败 4.履约中 5. 结算审核中 6. 结算审核失败 7. 已完成',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务承接结算表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_task_streamer
-- ----------------------------

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `client_id` bigint(20) NULL DEFAULT NULL COMMENT '播主/品牌商 id',
  `company_id` bigint(20) NULL DEFAULT NULL COMMENT '组织机构id',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1366911899934721 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES (1, 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', '0', '测试账号', NULL, '2018-09-29 13:55:30', '2018-09-29 13:55:39', 1, 5, NULL, NULL, '2022-10-18 12:46:12', 1);
INSERT INTO `ums_admin` VALUES (3, 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', '0', '系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-04-20 12:45:16', 1, 5, NULL, NULL, '2022-10-18 12:46:17', 1);
INSERT INTO `ums_admin` VALUES (4, 'macro', '$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa', 'string', '0', 'macro', 'macro专用', '2019-10-06 15:53:51', '2020-02-03 14:55:55', 1, 5, NULL, NULL, '2022-10-19 05:16:03', 1);
INSERT INTO `ums_admin` VALUES (16, 'dujlhv', '$2a$10$VxxQrAlp76xZ7Lza/Qm.3.8e1PxMabAzgmgYxw11vxpJkb/4og0sa', 'icon', '13758161316', 'djh', 'djh use only', '2022-09-23 09:22:20', '2022-10-20 11:58:55', 1, 5, NULL, NULL, '2022-11-11 16:13:49', 1);
INSERT INTO `ums_admin` VALUES (1364909252878336, 'zyzyzy', '$2a$10$Evp40dzH7p9XZHYJEwEoYePcB0kdIsDlgexSiq/yuakZW3i2puBxO', 'string', 'string', '张元', 'string', '2022-10-19 03:09:50', '2022-11-21 15:45:09', 1, 5, NULL, NULL, '2022-11-21 15:45:09', 0);
INSERT INTO `ums_admin` VALUES (1364909556760576, 'zhanghongliang', '$2a$10$fKxFr1oT2vwOS4CX8L2AKuKmEke0tB.ERL6kbfQ5D7gFXNj87.GPS', 'string', 'string', '张红亮', 'string', '2022-10-19 03:16:01', '2022-11-16 16:20:38', 1, 5, NULL, NULL, '2022-11-16 16:20:38', 0);
INSERT INTO `ums_admin` VALUES (1364909645873152, 'lixinwei', '$2a$10$F5SbyvLitww3aBrMZC9OjucOoUxMd37TejXchPnE/28e3cP5S1fYy', 'string', 'string', 'x蔚', 'string', '2022-10-19 03:17:50', '2022-11-17 11:06:23', 1, 5, NULL, NULL, '2022-11-17 11:06:23', 0);
INSERT INTO `ums_admin` VALUES (1364916962410496, 'streamer001', '$2a$10$x4mDcJJ010w3xzGkTJwpqOzdUfiRN/vEnRlSgTcUGsYwczQA1yzhO', 'string', 'string', 'streamer001', 'string', '2022-10-19 05:46:41', '2022-10-20 01:32:45', 1, 9, 1364916962402304, NULL, '2022-10-20 01:32:45', 0);
INSERT INTO `ums_admin` VALUES (1364982471729152, 'owner001', '$2a$10$nSjMQ7EWgUnYvGTqYNkZUelobAzVlFgxGLWC.cAwccUWgGlxbIknq', 'string', 'string', 'string', 'string', '2022-10-20 11:59:29', '2022-11-15 14:22:35', 1, 10, 1364982471720960, NULL, '2022-11-15 14:22:35', 0);
INSERT INTO `ums_admin` VALUES (1364982482960384, 'operator001', '$2a$10$3u//T7l0WBg96CVM.xzjjOPOihBlpcn5IUx23WCfPoceDHFulOqsm', 'string', 'string', 'string', 'string', '2022-10-20 11:59:42', '2022-10-25 14:14:08', 1, 8, NULL, NULL, '2022-10-25 14:14:08', 0);
INSERT INTO `ums_admin` VALUES (1365349230714880, 'string', '$2a$10$s6DIrVgVCadQaxIgvbhELu2eIeE9cCevueQScqI9qEp.LqcWi8yKW', 'string', 'string', 'string', 'string', '2022-10-25 16:21:12', '2022-11-15 16:41:34', 1, NULL, NULL, NULL, '2022-11-15 16:41:34', 0);
INSERT INTO `ums_admin` VALUES (1366054568673280, 'wujiaojiao', '$2a$10$Ho59P6DQ9WiQkV6D.vkxr.p0sTvrDoWgpBti3qENQFXj8hnRPfYyu', '', '', '', '', '2022-11-04 15:31:21', '2022-11-04 15:50:55', 1, NULL, NULL, NULL, '2022-11-04 15:50:55', 0);
INSERT INTO `ums_admin` VALUES (1366057050955776, 'luyong', '$2a$10$A/RLDwEt9IPlYtXUfxVBiOlnNF8BkPJgWfcEscUE/Q9QT0jl1UOie', '', '', 'xx', '', '2022-11-04 16:21:51', '2022-11-04 17:12:01', 1, NULL, NULL, NULL, '2022-11-04 17:12:01', 0);
INSERT INTO `ums_admin` VALUES (1366550210060288, 'zzz', '$2a$10$AO6.9ZsK53OM84PCWjmOh.e6hRPYUm2HKcRF4QmSDNdQTGltlg7uu', '', '13675967269', '孟欣汝', '', '2022-11-11 15:35:12', NULL, 1, 10, 1366550210052096, NULL, '2022-11-11 16:16:27', 1);
INSERT INTO `ums_admin` VALUES (1366551046397952, 'aaa', '$2a$10$UKe0.XTKV2wn.axkoTs5z.dEDg7ofTRgL2TgFwDGuqzwIOuo5zC2O', '', '18355790621', '侯涵越', '', '2022-11-11 15:52:13', NULL, 1, 9, 1366551046381568, NULL, '2022-11-11 16:16:31', 1);
INSERT INTO `ums_admin` VALUES (1366551137402880, 'vvv', '$2a$10$HIqqMzi4OSiB9x5lvNa.Suh78E0Xeniy0S2aWdGjIpekBLJVzyAL6', '', '18249657984', '阎勇', '', '2022-11-11 15:54:04', NULL, 1, 9, 2, 50, '2022-11-16 17:26:23', 1);
INSERT INTO `ums_admin` VALUES (1366551171907584, 'acc', '$2a$10$mRtyCLoP51C8JPtPviTZgOFdQQ.YOHsUlvSlK13Asiy.ApX8Y8mGy', '', '', '田雅涵', '', '2022-11-11 15:54:46', NULL, 1, 9, 1366551171899392, NULL, '2022-11-11 15:54:46', 0);
INSERT INTO `ums_admin` VALUES (1366551215767552, 'll', '$2a$10$mlwTkx6Asixv2xHHbxyLn.EEZ7uOK8LIiV3JWSE.Ca9mzv.YIYUCq', '', '', '卢榕润', '', '2022-11-11 15:55:39', NULL, 1, 9, 1366551215759360, NULL, '2022-11-16 17:22:02', 1);
INSERT INTO `ums_admin` VALUES (1366551249354752, 'ddd', '$2a$10$o9mtqgXCt7g5cUW9CboiV.ZxzQPGsH72qMoiwPnHvwUi22gG2UEIS', '', '', '田玥傲', '', '2022-11-11 15:56:20', NULL, 1, 9, 1366551249346560, NULL, '2022-11-16 17:21:49', 1);
INSERT INTO `ums_admin` VALUES (1366551291461632, 'lmj', '$2a$10$wTc660FsMKb3fcGPZb5cQ.LhQNpzyI/cp31UvxHmO3NveTmI/cK6K', '', '', '龚翔', '', '2022-11-11 15:57:12', NULL, 1, 9, 1366551291453440, NULL, '2022-11-14 14:16:15', 1);
INSERT INTO `ums_admin` VALUES (1366909527973888, '尹禹辰', '$2a$10$aqrhN8I4pnvngXLXQagbf.j93lZaPGFQa.JIkWbOHFMDsM7eqoso2', '', '', '邓娜', '', '2022-11-16 17:25:32', NULL, 1, 9, 1366909527965696, NULL, '2022-11-16 17:25:32', 0);
INSERT INTO `ums_admin` VALUES (1366909545095168, '田冰枫', '$2a$10$2Zg9fi9QSap75ZQ5Jl.7bOEf0UwaoSxlVrFL5ngz3Q.uoH.hstPjC', '', '', '邓娜', '', '2022-11-16 17:25:53', NULL, 1, 9, 1366909545086976, NULL, '2022-11-16 17:26:10', 1);
INSERT INTO `ums_admin` VALUES (1366909550903296, '黄雅晗', '$2a$10$Tc0zHyQ/UjGRl.fwAP4rQOHKp7y/PoiUm4a/Annk9hy58OnI1SDDK', '', '', '邓娜', '', '2022-11-16 17:26:00', NULL, 1, 9, 1366909550895104, NULL, '2022-11-16 17:26:04', 1);
INSERT INTO `ums_admin` VALUES (1366909726670848, '李涛', '$2a$10$yijlGu6Yp6bbYdftKHf6PuSJbYzeOQG4jxwC1jlYILB80V2sVUKN.', '', '', '吕易轩', '', '2022-11-16 17:29:35', NULL, 1, 9, 1366909726662656, NULL, '2022-11-16 18:10:28', 1);
INSERT INTO `ums_admin` VALUES (1366909731758080, '吴美欣', '$2a$10$NLsoaF17TwWIkANHBHWM2.sjko/TW18fuJb6g2b2RIAcVE8b1eYUO', '', '', '吕易轩', '', '2022-11-16 17:29:41', NULL, 1, 9, 1366909731749888, NULL, '2022-11-16 17:31:22', 1);
INSERT INTO `ums_admin` VALUES (1366909789356032, '史晓庆', '$2a$10$Szy5X7RWmzCQ4xv8yuFNbuDq4slaJ6v64NYNph/b.IWOHZ3V7FzJm', '', '', '吕易轩', '', '2022-11-16 17:30:51', NULL, 1, 9, 1366909789347840, NULL, '2022-11-16 17:31:14', 1);
INSERT INTO `ums_admin` VALUES (1366910520098816, '蔡汝鑫', '$2a$10$9venczIyWBA2rMERj6sR1e4DGBSPq2ahrkJt2hGSWaTKJEHTPtt9i', '', '', '', '', '2022-11-16 17:45:43', NULL, 1, 9, 1366910520090624, NULL, '2022-11-16 17:48:23', 1);
INSERT INTO `ums_admin` VALUES (1366910530584576, '郑清妍', '$2a$10$tx8N8bHcKa4.IqYehVSf4.aH6oQaAf46YZsXyut0NEAI0m2BE3NzK', '', '', '', '', '2022-11-16 17:45:56', NULL, 1, 9, 1366910530576384, NULL, '2022-11-16 17:48:18', 1);
INSERT INTO `ums_admin` VALUES (1366911297298432, '易子辰', '$2a$10$VTzeq3/FtIRbM0UzyV6x6ec.hl/iaFS7vADv5N9Mthh2.wyI1bFpu', '', '', '', '', '2022-11-16 18:01:32', NULL, 1, 9, 1366911297290240, NULL, '2022-11-16 18:02:04', 1);
INSERT INTO `ums_admin` VALUES (1366911892512768, '孙文昊', '$2a$10$DQqccGvVjyoTquWO/WfG0OuYjSLyLTH9JHDe34Bxegm.gcyAXv95S', '', '', '', '', '2022-11-16 18:13:39', NULL, 1, 9, 1366911892504576, NULL, '2022-11-16 18:13:39', 0);
INSERT INTO `ums_admin` VALUES (1366911899934720, '王淼', '$2a$10$Ulsdo4dN3hvSRX6IGVr0re/fWnmhptGXp9iXclKXEE84Q0Y.DHqeG', '', '', '', '', '2022-11-16 18:13:48', NULL, 1, 9, 1366911899926528, NULL, '2022-11-16 18:14:33', 1);

-- ----------------------------
-- Table structure for ums_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_agent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1367258487734273 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户登录日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------
INSERT INTO `ums_admin_login_log` VALUES (285, 3, '2020-08-24 14:05:21', '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (286, 10, '2020-08-24 14:05:39', '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (287, 16, '2022-09-23 09:22:49', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (288, 16, '2022-09-26 07:15:47', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (289, 16, '2022-09-26 07:17:22', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (290, 3, '2022-09-26 08:09:21', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (291, 3, '2022-09-26 08:10:40', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (292, 16, '2022-09-26 13:29:43', '58.101.9.178', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (293, 16, '2022-09-27 00:14:27', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (294, 16, '2022-09-27 00:25:44', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (295, 16, '2022-09-27 00:25:45', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (296, 16, '2022-09-27 00:50:54', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (297, 16, '2022-09-27 00:50:58', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (298, 3, '2022-09-27 00:51:13', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (299, 3, '2022-09-27 02:32:09', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (300, 3, '2022-09-27 02:32:44', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (301, 3, '2022-09-27 02:37:01', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (302, 3, '2022-09-27 14:01:21', '115.200.1.249', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364127962324992, 16, '2022-10-08 02:14:27', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364572877553664, 3, '2022-10-14 09:06:16', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364573017710592, 3, '2022-10-14 09:09:07', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364573384179712, 3, '2022-10-14 09:16:34', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364625849393152, 16, '2022-10-15 03:03:59', '125.121.4.94', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364714712252416, 3, '2022-10-16 09:11:54', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364762413907968, 3, '2022-10-17 01:22:24', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364802852200448, 16, '2022-10-17 15:05:07', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364832333873152, 16, '2022-10-18 01:04:55', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847315574784, 3, '2022-10-18 06:09:43', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847318917120, 3, '2022-10-18 06:09:47', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847323643904, 3, '2022-10-18 06:09:53', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847338242048, 3, '2022-10-18 06:10:11', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847396421632, 3, '2022-10-18 06:11:22', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847404744704, 3, '2022-10-18 06:11:32', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847411126272, 3, '2022-10-18 06:11:40', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847415517184, 3, '2022-10-18 06:11:45', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847477604352, 3, '2022-10-18 06:13:01', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847480463360, 3, '2022-10-18 06:13:05', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847502934016, 3, '2022-10-18 06:13:32', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847507783680, 3, '2022-10-18 06:13:38', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847591735296, 3, '2022-10-18 06:15:20', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847725518848, 3, '2022-10-18 06:18:04', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847758565376, 3, '2022-10-18 06:18:44', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847787728896, 16, '2022-10-18 06:19:20', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847798902784, 3, '2022-10-18 06:19:33', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847801466880, 16, '2022-10-18 06:19:36', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847893798912, 16, '2022-10-18 06:21:29', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847916081152, 3, '2022-10-18 06:21:56', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364847961579520, 16, '2022-10-18 06:22:52', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364848908410880, 16, '2022-10-18 06:42:08', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364848920616960, 3, '2022-10-18 06:42:23', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909176315904, 16, '2022-10-19 03:08:17', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909407428608, 1364909252878336, '2022-10-19 03:12:59', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909409591296, 1364909252878336, '2022-10-19 03:13:02', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909444145152, 1364909252878336, '2022-10-19 03:13:44', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909452386304, 1364909252878336, '2022-10-19 03:13:54', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909465034752, 1364909252878336, '2022-10-19 03:14:09', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909477126144, 1364909252878336, '2022-10-19 03:14:24', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909479067648, 1364909252878336, '2022-10-19 03:14:26', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909480026112, 1364909252878336, '2022-10-19 03:14:28', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909489373184, 1364909252878336, '2022-10-19 03:14:39', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909494108160, 1364909252878336, '2022-10-19 03:14:45', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909589487616, 1364909556760576, '2022-10-19 03:16:41', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909594828800, 1364909556760576, '2022-10-19 03:16:48', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364909650722816, 1364909645873152, '2022-10-19 03:17:56', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364913516945408, 1364909645873152, '2022-10-19 04:36:35', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364913544994816, 1364909252878336, '2022-10-19 04:37:10', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364913550090240, 1364909252878336, '2022-10-19 04:37:16', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364913573937152, 1364909252878336, '2022-10-19 04:37:45', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364913580916736, 1364909252878336, '2022-10-19 04:37:54', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364913614495744, 16, '2022-10-19 04:38:35', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364914039455744, 1364909645873152, '2022-10-19 04:47:13', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364914106515456, 16, '2022-10-19 04:48:35', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364915410534400, 1364909252878336, '2022-10-19 05:15:07', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364916973813760, 1364916962410496, '2022-10-19 05:46:55', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364917137981440, 16, '2022-10-19 05:50:16', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364917175230464, 16, '2022-10-19 05:51:01', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364926115012608, 1364909556760576, '2022-10-19 08:52:54', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364940927467520, 1364916962410496, '2022-10-19 13:54:16', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364940940386304, 16, '2022-10-19 13:54:31', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364941069377536, 1364909556760576, '2022-10-19 13:57:09', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364975194488832, 1364909556760576, '2022-10-20 01:31:25', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364975259402240, 1364916962410496, '2022-10-20 01:32:45', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364975278473216, 1364909556760576, '2022-10-20 01:33:08', '39.170.47.228', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364982444163072, 16, '2022-10-20 11:58:55', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1364982498713600, 1364909252878336, '2022-10-20 12:00:02', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1365063289470976, 1364982471729152, '2022-10-21 15:23:43', '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1365331935387648, 1364909556760576, '2022-10-25 10:29:20', '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1365342941659136, 1364909556760576, '2022-10-25 14:13:16', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1365342984339456, 1364982482960384, '2022-10-25 14:14:08', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1365343040405504, 1364909556760576, '2022-10-25 14:15:16', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1365401657425920, 1364909252878336, '2022-10-26 10:07:50', '39.170.47.227', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1365415812939776, 1365349230714880, '2022-10-26 14:55:50', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366053251006464, 1364909252878336, '2022-11-04 15:04:32', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366054281134080, 1364909556760576, '2022-11-04 15:25:30', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366054416891904, 1364909556760576, '2022-11-04 15:28:16', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366054588407808, 1366054568673280, '2022-11-04 15:31:45', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366054700982272, 1366054568673280, '2022-11-04 15:34:02', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366054824968192, 1366054568673280, '2022-11-04 15:36:34', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366054966403072, 1366054568673280, '2022-11-04 15:39:26', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366055030456320, 1364909252878336, '2022-11-04 15:40:45', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366055204085760, 1366054568673280, '2022-11-04 15:44:17', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366055386308608, 1364909252878336, '2022-11-04 15:47:59', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366055530586112, 1366054568673280, '2022-11-04 15:50:55', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366055659675648, 1364909252878336, '2022-11-04 15:53:33', '49.5.2.54', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366055983833088, 1364909252878336, '2022-11-04 16:00:08', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366057219629056, 1366057050955776, '2022-11-04 16:25:17', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366057399590912, 1366057050955776, '2022-11-04 16:28:57', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366057851428864, 1364909252878336, '2022-11-04 16:38:08', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366057886580736, 1364909252878336, '2022-11-04 16:38:51', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366057968058368, 1364909252878336, '2022-11-04 16:40:31', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366059380752384, 1366057050955776, '2022-11-04 17:09:15', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366059516452864, 1366057050955776, '2022-11-04 17:12:01', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366059577294848, 1364909252878336, '2022-11-04 17:13:15', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366249981829120, 1364909252878336, '2022-11-07 09:47:02', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366262024790016, 1364909252878336, '2022-11-07 13:52:03', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366262231269376, 1364909252878336, '2022-11-07 13:56:15', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366263300800512, 1364909252878336, '2022-11-07 14:18:01', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366263468081152, 1364909252878336, '2022-11-07 14:21:25', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366263720435712, 1364909252878336, '2022-11-07 14:26:33', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366263816527872, 1364909252878336, '2022-11-07 14:28:30', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366264184897536, 1364909252878336, '2022-11-07 14:36:00', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366264188149760, 1364909252878336, '2022-11-07 14:36:04', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366264219435008, 1364909252878336, '2022-11-07 14:36:42', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366264368889856, 1364909252878336, '2022-11-07 14:39:45', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366264679882752, 1364909252878336, '2022-11-07 14:46:04', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366265297174528, 1364909252878336, '2022-11-07 14:58:38', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366265839239168, 1364909252878336, '2022-11-07 15:09:40', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366265842524160, 1364909252878336, '2022-11-07 15:09:44', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366265925763072, 1364909252878336, '2022-11-07 15:11:25', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366265941131264, 1364909252878336, '2022-11-07 15:11:44', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266183622656, 1364909252878336, '2022-11-07 15:16:40', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266221420544, 1364909252878336, '2022-11-07 15:17:26', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266261970944, 1364909252878336, '2022-11-07 15:18:16', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266426900480, 1364909252878336, '2022-11-07 15:21:37', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266438361088, 1364909252878336, '2022-11-07 15:21:51', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266500636672, 1364909252878336, '2022-11-07 15:23:07', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266582056960, 1364909252878336, '2022-11-07 15:24:46', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366266616840192, 1364909252878336, '2022-11-07 15:25:29', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366272774758400, 1364909252878336, '2022-11-07 17:30:46', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366273194459136, 1364909252878336, '2022-11-07 17:39:18', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366274627567616, 1364909252878336, '2022-11-07 18:08:27', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366274668912640, 1364909252878336, '2022-11-07 18:09:18', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366274675195904, 1364909252878336, '2022-11-07 18:09:26', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366345511075840, 1364909252878336, '2022-11-08 18:10:35', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366463584477184, 1365349230714880, '2022-11-10 10:12:48', '115.233.205.175', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366463743565824, 1364909645873152, '2022-11-10 10:16:02', '115.233.205.175', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366476319653888, 1364909252878336, '2022-11-10 14:31:54', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366544048422912, 1364909252878336, '2022-11-11 13:29:50', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366745569337344, 1364909252878336, '2022-11-14 09:49:48', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366757816934400, 1364909645873152, '2022-11-14 13:58:58', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366758577496064, 1365349230714880, '2022-11-14 14:14:27', '39.170.47.229', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366759034454016, 1364909645873152, '2022-11-14 14:23:44', '223.104.165.247', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366759048486912, 1364909252878336, '2022-11-14 14:24:02', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366759091134464, 1364909252878336, '2022-11-14 14:24:54', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366759949672448, 1365349230714880, '2022-11-14 14:42:22', '223.104.165.247', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366768695885824, 1364909252878336, '2022-11-14 17:40:18', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366816651919360, 1364909252878336, '2022-11-15 09:55:58', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366829420740608, 1365349230714880, '2022-11-15 14:15:45', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366829451689984, 1364909645873152, '2022-11-15 14:16:23', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366829678673920, 1364909645873152, '2022-11-15 14:21:00', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366829748428800, 1365349230714880, '2022-11-15 14:22:25', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366829756538880, 1364982471729152, '2022-11-15 14:22:35', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366832762445824, 1364909556760576, '2022-11-15 15:23:44', '115.233.205.171', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366836587446272, 1365349230714880, '2022-11-15 16:41:34', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366836611940352, 1364909645873152, '2022-11-15 16:42:04', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366886962069504, 1364909252878336, '2022-11-16 09:46:26', '59.108.166.121', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366906337689600, 1364909556760576, '2022-11-16 16:20:38', '115.233.205.171', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1366961670258688, 1364909645873152, '2022-11-17 11:06:23', '115.233.205.182', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1367031968120832, 1364909252878336, '2022-11-18 10:56:35', '59.109.157.223', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1367242991419392, 1364909252878336, '2022-11-21 10:29:52', '59.109.157.223', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1367254927392768, 1364909252878336, '2022-11-21 14:32:43', '59.109.157.223', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1367254975356928, 1364909252878336, '2022-11-21 14:33:41', '59.109.157.223', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1367255002800128, 1364909252878336, '2022-11-21 14:34:15', '59.109.157.223', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1367255046234112, 1364909252878336, '2022-11-21 14:35:08', '59.109.157.223', NULL, NULL, NULL, 0);
INSERT INTO `ums_admin_login_log` VALUES (1367258487734272, 1364909252878336, '2022-11-21 15:45:09', '59.109.157.223', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for ums_admin_owner
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_owner`;
CREATE TABLE `ums_admin_owner`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `owner_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌商/政府机构名称',
  `real_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人姓名',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `certification` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未认证' COMMENT '认证状态（审核中、已认证、未认证）',
  `image_id` bigint(20) NULL DEFAULT NULL COMMENT '图片id',
  `account_balance` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '账户余额',
  `industry` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属行业',
  `contact_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `contact_tel` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人手机号',
  `company_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属企业名称',
  `deposit_status` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未缴费' COMMENT '保证金缴纳状态（未缴费、已缴费、余额不足）',
  `owner_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌商描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1366887164248065 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品牌商/政府机构表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_admin_owner
-- ----------------------------
INSERT INTO `ums_admin_owner` VALUES (1364982471720960, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '未缴费', NULL, '2022-10-20 11:59:29', '2022-11-08 16:00:49', 1);
INSERT INTO `ums_admin_owner` VALUES (1364982471720961, '', '', '', '', 0, 0.00, '', '卢汝鑫', '19134182962', '天津理工大学', '未缴费', NULL, '2022-11-08 14:40:03', '2022-11-08 16:00:58', 1);
INSERT INTO `ums_admin_owner` VALUES (1364982471720962, '湖北省昌爱泽俊情房地产普通合伙', '', '', '未认证', 0, 0.00, '', '卢汝鑫', '19134182962', '天津理工大学', '未缴费', NULL, '2022-11-08 16:03:45', NULL, 0);
INSERT INTO `ums_admin_owner` VALUES (1364982471720963, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', '', '', '已认证', 0, 0.00, '', '文晶滢', '17819545268', '新疆师范大学', '未缴费', NULL, '2022-11-08 16:04:22', NULL, 0);
INSERT INTO `ums_admin_owner` VALUES (1364982471720964, '陕西省利晨弘名贝餐饮普通合伙', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', NULL, '2022-11-08 16:04:53', '2022-11-08 16:20:17', 1);
INSERT INTO `ums_admin_owner` VALUES (1364982471720965, 'test', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', NULL, '2022-11-08 16:07:29', '2022-11-08 16:19:55', 1);
INSERT INTO `ums_admin_owner` VALUES (1364982471720966, 'test', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', NULL, '2022-11-08 16:20:39', '2022-11-08 16:20:53', 1);
INSERT INTO `ums_admin_owner` VALUES (1364982471720967, 'test', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', NULL, '2022-11-08 16:22:46', NULL, 0);
INSERT INTO `ums_admin_owner` VALUES (1364982471720968, 'test', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', NULL, '2022-11-08 16:22:48', '2022-11-08 16:23:00', 1);
INSERT INTO `ums_admin_owner` VALUES (1364982471720969, 'test', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', NULL, '2022-11-08 16:22:50', NULL, 0);
INSERT INTO `ums_admin_owner` VALUES (1366550210052096, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '未缴费', NULL, '2022-11-11 15:35:12', NULL, 1);
INSERT INTO `ums_admin_owner` VALUES (1366887164248064, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '未缴费', NULL, '2022-11-16 09:50:33', NULL, 0);

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1366911899951105 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation` VALUES (26, 3, 5, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (27, 6, 1, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (28, 7, 2, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (29, 1, 5, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (30, 4, 5, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (31, 8, 5, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (34, 12, 6, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (38, 13, 5, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (39, 10, 8, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (47, 16, 5, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (48, 16, 8, NULL, NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1364914126872576, 1364909252878336, 5, '2022-10-19 04:49:00', NULL, 1);
INSERT INTO `ums_admin_role_relation` VALUES (1364914137546752, 1364909556760576, 5, '2022-10-19 04:49:13', NULL, 1);
INSERT INTO `ums_admin_role_relation` VALUES (1364914149351424, 1364909645873152, 5, '2022-10-19 04:49:27', NULL, 1);
INSERT INTO `ums_admin_role_relation` VALUES (1364914166792192, 1364909556760576, 5, '2022-10-19 04:49:49', NULL, 1);
INSERT INTO `ums_admin_role_relation` VALUES (1364914232639488, 1364909252878336, 5, '2022-10-19 04:51:09', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1364916962435072, 1364916962410496, 9, '2022-10-19 05:46:41', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1364917205835776, 1364909556760576, 5, '2022-10-19 05:51:39', NULL, 1);
INSERT INTO `ums_admin_role_relation` VALUES (1364917210693632, 1364909556760576, 5, '2022-10-19 05:51:44', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1364917213356032, 1364909645873152, 5, '2022-10-19 05:51:48', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1364982471753728, 1364982471729152, 10, '2022-10-20 11:59:29', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1364982482976768, 1364982482960384, 8, '2022-10-20 11:59:43', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366550210068480, 1366550210060288, 10, '2022-11-11 15:35:12', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366551046406144, 1366551046397952, 9, '2022-11-11 15:52:13', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366551137411072, 1366551137402880, 9, '2022-11-11 15:54:04', NULL, 1);
INSERT INTO `ums_admin_role_relation` VALUES (1366551171923968, 1366551171907584, 9, '2022-11-11 15:54:46', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366551215783936, 1366551215767552, 9, '2022-11-11 15:55:40', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366551249371136, 1366551249354752, 9, '2022-11-11 15:56:21', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366551291478016, 1366551291461632, 9, '2022-11-11 15:57:12', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366557974896640, 1366551137402880, 9, '2022-11-11 18:13:10', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366909527990272, 1366909527973888, 9, '2022-11-16 17:25:32', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366909545111552, 1366909545095168, 9, '2022-11-16 17:25:53', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366909550919680, 1366909550903296, 9, '2022-11-16 17:26:00', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366909726687232, 1366909726670848, 9, '2022-11-16 17:29:35', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366909731774464, 1366909731758080, 9, '2022-11-16 17:29:41', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366909789372416, 1366909789356032, 9, '2022-11-16 17:30:51', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366910520115200, 1366910520098816, 9, '2022-11-16 17:45:44', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366910530600960, 1366910530584576, 9, '2022-11-16 17:45:56', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366911297314816, 1366911297298432, 9, '2022-11-16 18:01:32', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366911892529152, 1366911892512768, 9, '2022-11-16 18:13:39', NULL, 0);
INSERT INTO `ums_admin_role_relation` VALUES (1366911899951104, 1366911899934720, 9, '2022-11-16 18:13:48', NULL, 0);

-- ----------------------------
-- Table structure for ums_admin_streamer
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_streamer`;
CREATE TABLE `ums_admin_streamer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `host_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主播名称',
  `real_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `certification` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未认证' COMMENT '认证状态（审核中、已认证、未认证）',
  `image_id` bigint(20) NULL DEFAULT NULL COMMENT '图片id',
  `account_balance` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '账户余额',
  `industry` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属行业',
  `belong_to` bigint(20) NULL DEFAULT NULL COMMENT '播主所属MCN，若为-1则为MCN机构，不是-1就是主播',
  `platform` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属平台(抖音、快手、淘宝)\r\n',
  `streamer_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主播描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1366911899926529 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '播主/MCN 表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_admin_streamer
-- ----------------------------
INSERT INTO `ums_admin_streamer` VALUES (1364916962402304, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-10-19 05:46:41', '2022-11-16 17:11:33', 1);
INSERT INTO `ums_admin_streamer` VALUES (1366551046381568, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-11 15:52:13', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366551137394688, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-11 15:54:04', '2022-11-16 17:11:31', 1);
INSERT INTO `ums_admin_streamer` VALUES (1366551171899392, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-11 15:54:46', '2022-11-16 17:11:29', 1);
INSERT INTO `ums_admin_streamer` VALUES (1366551215759360, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-11 15:55:40', '2022-11-16 17:11:26', 1);
INSERT INTO `ums_admin_streamer` VALUES (1366551249346560, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-11 15:56:21', '2022-11-16 17:11:07', 1);
INSERT INTO `ums_admin_streamer` VALUES (1366551291453440, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-11 15:57:12', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366909527965696, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:25:32', NULL, 0);
INSERT INTO `ums_admin_streamer` VALUES (1366909545086976, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:25:53', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366909550895104, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:26:00', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366909726662656, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:29:35', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366909731749888, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:29:41', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366909789347840, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:30:51', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366910520090624, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:45:43', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366910530576384, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 17:45:56', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366911297290240, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 18:01:32', NULL, 1);
INSERT INTO `ums_admin_streamer` VALUES (1366911892504576, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 18:13:39', NULL, 0);
INSERT INTO `ums_admin_streamer` VALUES (1366911899926528, NULL, NULL, NULL, '未认证', NULL, 0.00, NULL, NULL, NULL, NULL, '2022-11-16 18:13:48', NULL, 1);

-- ----------------------------
-- Table structure for ums_department
-- ----------------------------
DROP TABLE IF EXISTS `ums_department`;
CREATE TABLE `ums_department`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `company_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_department
-- ----------------------------
INSERT INTO `ums_department` VALUES (0, 'test', '2022-11-04 16:34:11', '2022-11-04 16:35:24', 1);
INSERT INTO `ums_department` VALUES (5, 'test', '2022-11-04 17:17:29', NULL, 0);
INSERT INTO `ums_department` VALUES (9, 'test', '2022-11-04 17:17:35', NULL, 0);
INSERT INTO `ums_department` VALUES (20, '射手座', '2022-11-10 13:48:33', NULL, 0);
INSERT INTO `ums_department` VALUES (50, '河南省蓝竹康波易湘美容有限责任公司', '2022-11-11 17:26:40', '2022-11-11 17:27:30', 0);
INSERT INTO `ums_department` VALUES (1366758216564736, 'string', '2022-11-14 14:07:06', NULL, 0);
INSERT INTO `ums_department` VALUES (1366758260432896, 'string', '2022-11-14 14:08:00', NULL, 0);
INSERT INTO `ums_department` VALUES (1366758294282240, 'hello world', '2022-11-14 14:08:41', NULL, 0);

-- ----------------------------
-- Table structure for ums_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) NULL DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) NULL DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) NULL DEFAULT NULL COMMENT '前端隐藏',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_menu
-- ----------------------------
INSERT INTO `ums_menu` VALUES (2, 1, '2020-02-02 14:51:50', '商品列表', 1, 0, 'product', 'product-list', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (3, 1, '2020-02-02 14:52:44', '添加商品', 1, 0, 'addProduct', 'product-add', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (4, 1, '2020-02-02 14:53:51', '商品分类', 1, 0, 'productCate', 'product-cate', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (5, 1, '2020-02-02 14:54:51', '商品类型', 1, 0, 'productAttr', 'product-attr', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (6, 1, '2020-02-02 14:56:29', '品牌管理', 1, 0, 'brand', 'product-brand', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (8, 7, '2020-02-02 16:55:18', '订单列表', 1, 0, 'order', 'product-list', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (9, 7, '2020-02-02 16:56:46', '订单设置', 1, 0, 'orderSetting', 'order-setting', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (10, 7, '2020-02-02 16:57:39', '退货申请处理', 1, 0, 'returnApply', 'order-return', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (11, 7, '2020-02-02 16:59:40', '退货原因设置', 1, 0, 'returnReason', 'order-return-reason', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (13, 12, '2020-02-04 16:19:22', '秒杀活动列表', 1, 0, 'flash', 'sms-flash', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (14, 12, '2020-02-04 16:20:16', '优惠券列表', 1, 0, 'coupon', 'sms-coupon', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (16, 12, '2020-02-07 16:22:38', '品牌推荐', 1, 0, 'homeBrand', 'product-brand', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (17, 12, '2020-02-07 16:23:14', '新品推荐', 1, 0, 'homeNew', 'sms-new', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (18, 12, '2020-02-07 16:26:38', '人气推荐', 1, 0, 'homeHot', 'sms-hot', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (19, 12, '2020-02-07 16:28:16', '专题推荐', 1, 0, 'homeSubject', 'sms-subject', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (20, 12, '2020-02-07 16:28:42', '广告列表', 1, 0, 'homeAdvertise', 'sms-ad', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (21, 0, '2020-02-07 16:29:13', '权限', 0, 0, 'ums', 'ums', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (22, 21, '2020-02-07 16:29:51', '用户列表', 1, 0, 'admin', 'ums-admin', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (23, 21, '2020-02-07 16:30:13', '角色列表', 1, 0, 'role', 'ums-role', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (24, 21, '2020-02-07 16:30:53', '菜单列表', 1, 0, 'menu', 'ums-menu', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (25, 21, '2020-02-07 16:31:13', '资源列表', 1, 0, 'resource', 'ums-resource', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (29, 0, '2022-09-27 02:26:09', '主播分析', 0, 9, 'streamer', 'streamer', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (30, 0, '2022-09-27 02:27:59', '数据监测', 0, 8, 'monitor', 'monitor', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (31, 0, '2022-09-27 02:29:04', '电商分析', 0, 7, 'analysis', 'analysis', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (32, 0, '2022-09-27 02:29:49', '品牌推广', 0, 6, 'brand', 'brand', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (33, 1, '2022-09-27 02:41:37', '1111', 1, 0, '11', '1111', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (35, 29, '2022-09-27 14:08:10', '搜索页面', 1, 7, 'searchPage', 'searchPage', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (36, 29, '2022-09-27 14:09:36', '搜索列表', 1, 6, 'searchList', 'searchList', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (37, 29, '2022-09-27 14:11:54', '主播详细', 1, 5, 'detail', 'detail', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (38, 29, '2022-09-27 14:12:18', '主播排行榜', 1, 4, 'rank', 'rank', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (39, 29, '2022-09-27 14:13:20', '星图热榜', 1, 3, 'starChart', 'starChart', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (40, 29, '2022-09-27 14:14:24', '抖音号对比', 1, 2, 'streamerCompare', 'streamerCompare', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (41, 29, '2022-09-27 14:16:14', 'MCN媒体库', 1, 1, 'MCN', 'MCN', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (42, 30, '2022-09-27 14:17:24', '我的抖音号', 1, 4, 'accountList', 'accountList', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (43, 30, '2022-09-27 14:18:07', '我的授权', 1, 3, 'authorize', 'authorize', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (44, 30, '2022-09-27 14:18:58', '我的收藏', 1, 2, 'collection', 'collection', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (45, 30, '2022-09-27 14:19:54', '带货能力诊断', 1, 1, 'saleCheck', 'saleCheck', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (46, 31, '2022-09-27 14:20:47', '商品搜索', 1, 5, 'productSearch', 'productSearch', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (47, 31, '2022-09-27 14:21:45', '热门带货视频', 1, 4, 'video', 'video', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (48, 31, '2022-09-27 14:22:47', '电商视频排行', 1, 3, 'videoRank', 'videoRank', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (49, 31, '2022-09-27 14:23:30', '电商商品排行', 1, 2, 'productRank', 'productRank', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (50, 31, '2022-09-27 14:24:15', '明星达人销售榜', 1, 1, 'saleRank', 'saleRank', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (51, 32, '2022-09-27 14:26:38', '电商品牌排行', 1, 3, 'brandRank', 'brandRank', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (52, 32, '2022-09-27 14:27:21', '品牌精准搜索', 1, 2, 'brandRearch', 'brandRearch', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (53, 32, '2022-09-27 14:27:46', '品牌多维对比', 1, 1, 'brandCompare', 'brandCompare', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (54, 0, '2022-09-27 14:33:47', '商品管理', 0, 5, 'pms', 'pms', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (55, 54, '2022-09-27 14:34:55', '商品分类管理', 1, 2, 'categoryGoods', 'categoryGoods', 0, '2022-10-25 14:15:53', 0);
INSERT INTO `ums_menu` VALUES (56, 54, '2022-09-27 14:35:23', '商品管理', 1, 1, 'product', 'product', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (57, 0, '2022-09-27 14:37:27', '客户管理', 0, 4, 'userManagement', 'userManagement', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (58, 57, '2022-09-27 14:38:11', '品牌商管理', 1, 2, 'brandManage', 'brandManage', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (59, 57, '2022-09-27 14:38:50', '主播管理', 1, 1, 'streamerManage', 'streamerManage', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (60, 0, '2022-09-27 14:39:19', '任务管理', 0, 3, 'taskManage', 'taskManage', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (61, 60, '2022-09-27 14:40:25', '任务管理', 1, 3, 'taskManage', 'taskManage', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (62, 60, '2022-09-27 14:41:13', '任务承接', 1, 2, 'taskApply', 'taskApply', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (63, 60, '2022-09-27 14:41:38', '任务结算', 1, 1, 'taskSettle', 'taskSettle', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (64, 0, '2022-09-27 14:43:10', '审核管理', 0, 2, 'examine', 'examine', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (65, 64, '2022-09-27 14:44:43', '任务发布审核', 1, 4, 'taskReleaseExa', 'taskReleaseExa', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (66, 64, '2022-09-27 14:45:35', '任务承接审核', 1, 3, 'taskApplyExa', 'taskApplyExa', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (67, 64, '2022-09-27 14:46:08', '任务结算审核', 1, 2, 'taskSettleExa', 'taskSettleExa', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (68, 64, '2022-09-27 14:47:11', '提现审核', 1, 1, 'withdrawExa', 'withdrawExa', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (69, 0, '2022-09-27 14:47:52', '账户中心', 0, 1, 'account', 'account', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (70, 69, '2022-09-27 14:49:27', '保证金管理', 1, 3, 'earnestMoney', 'earnestMoney', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (71, 69, '2022-09-27 14:50:10', '收益/收入', 1, 2, 'income', 'income', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (72, 69, '2022-09-27 14:50:56', '提现记录', 1, 1, 'withdrawRecord', 'withdrawRecord', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (73, 0, '2022-09-27 14:51:39', '个人中心', 0, 0, 'personal', 'personal', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (74, 73, '2022-09-27 14:52:19', '个人信息', 1, 5, 'userInfo', 'userInfo', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (75, 73, '2022-09-27 14:52:42', '用户管理', 1, 4, 'userManage', 'userManage', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (76, 73, '2022-09-27 14:53:05', '角色管理', 1, 3, 'roleManage', 'roleManage', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (77, 73, '2022-09-27 14:54:44', '实名认证审核', 1, 2, 'realExa', 'realExa', 0, NULL, 0);
INSERT INTO `ums_menu` VALUES (78, 73, '2022-09-27 14:55:43', '个人设置', 1, 1, 'personalSet', 'personalSet', 0, NULL, 0);

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '资源分类ID',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1364926673190913 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台资源表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
INSERT INTO `ums_resource` VALUES (2, '2020-02-04 17:05:35', '商品分类管理', '/category/goods/**', NULL, 1, '2022-10-25 14:16:20', 0);
INSERT INTO `ums_resource` VALUES (5, '2020-02-04 17:09:16', '商品管理', '/goods/**', NULL, 1, NULL, 0);
INSERT INTO `ums_resource` VALUES (25, '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', 4, NULL, 0);
INSERT INTO `ums_resource` VALUES (26, '2020-02-07 16:48:24', '后台用户角色管理', '/role/**', '', 4, NULL, 0);
INSERT INTO `ums_resource` VALUES (27, '2020-02-07 16:48:48', '后台菜单管理', '/menu/**', '', 4, NULL, 0);
INSERT INTO `ums_resource` VALUES (28, '2020-02-07 16:49:18', '后台资源分类管理', '/resourceCategory/**', '', 4, NULL, 0);
INSERT INTO `ums_resource` VALUES (29, '2020-02-07 16:49:45', '后台资源管理', '/resource/**', '', 4, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364763873550336, '2022-10-17 01:52:05', '行业分类管理', '/category/industry/**', '', 1, '2022-10-25 14:16:52', 0);
INSERT INTO `ums_resource` VALUES (1364764033875968, '2022-10-17 01:55:21', '品牌商管理', '/owner/**', '', 1364763385634816, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364764072247296, '2022-10-17 01:56:08', '播主管理', '/streamer/**', '', 1364763385634816, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364764108660736, '2022-10-17 01:56:52', '任务管理-品牌方', '/task/owner/**', '', 1364763164188672, '2022-10-20 03:36:51', 0);
INSERT INTO `ums_resource` VALUES (1364764507725824, '2022-10-17 02:04:59', '任务管理-播主', '/task/streamer/**', '', 1364763164188672, '2022-10-20 03:41:25', 0);
INSERT INTO `ums_resource` VALUES (1364764534751232, '2022-10-17 02:05:32', '任务管理-运营人员', '/task/operator/**', '', 1364763164188672, '2022-10-20 03:41:51', 0);
INSERT INTO `ums_resource` VALUES (1364764823814144, '2022-10-17 02:11:25', '任务发布审核', '/examine/task/**', '', 1364763393245184, '2022-10-20 03:42:00', 1);
INSERT INTO `ums_resource` VALUES (1364764972646400, '2022-10-17 02:14:27', '组织机构管理', '/department/**', '', 4, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364765009125376, '2022-10-17 02:15:12', '图片上传', '/oss/**', '', 1364764990332928, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364849805377536, '2022-10-18 07:00:23', '审核管理-品牌方', '/audit/owner/**', '', 1364763393245184, '2022-10-18 07:07:26', 0);
INSERT INTO `ums_resource` VALUES (1364849855004672, '2022-10-18 07:01:23', '审核管理-运营人员', '/audit/operator/**', '', 1364763393245184, '2022-10-18 07:02:51', 0);
INSERT INTO `ums_resource` VALUES (1364849910964224, '2022-10-18 07:02:31', '提现审核', '/audit/withdraw/**', '', 1364763393245184, '2022-10-20 03:44:47', 1);
INSERT INTO `ums_resource` VALUES (1364850221801472, '2022-10-18 07:08:51', '保证金管理', '/account/deposit/**', '', 1364763424997376, '2022-10-19 09:07:49', 0);
INSERT INTO `ums_resource` VALUES (1364850299772928, '2022-10-18 07:10:26', '收益/收入', '/account/income/**', '', 1364763424997376, '2022-10-18 07:12:07', 0);
INSERT INTO `ums_resource` VALUES (1364850371919872, '2022-10-18 07:11:54', '提现记录', '/account/withdrawRecord/**', '', 1364763424997376, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364850464333824, '2022-10-18 07:13:47', '个人中心', '/user/Info/**', '', 1364763414249472, '2022-10-18 07:15:17', 0);
INSERT INTO `ums_resource` VALUES (1364850531729408, '2022-10-18 07:15:09', '实名认证审核', '/user/infoExamine/**', '', 1364763414249472, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364850565226496, '2022-10-18 07:15:50', '个人设置', '/user/setting/**', '', 1364763414249472, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364850751111168, '2022-10-18 07:19:37', '登录', '/login/**', '', 6, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364850770911232, '2022-10-18 07:20:01', '注册', '/register/**', '', 6, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364850802933760, '2022-10-18 07:20:40', '首页工作台', '/platform/**', '', 6, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851008716800, '2022-10-18 07:24:52', '搜索页面', '/streamer/searchPage/**', '', 1364850862768128, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851032096768, '2022-10-18 07:25:20', '搜索列表', '/streamer/searchList/**', '', 1364850862768128, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851097837568, '2022-10-18 07:26:40', '主播详细', '/streamer/detail/**', '', 1364850862768128, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851137036288, '2022-10-18 07:27:28', '主播排行榜', '/streamer/rank/**', '', 1364850862768128, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851168141312, '2022-10-18 07:28:06', '星图热榜', '/streamer/startChart/**', '', 1364850862768128, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851206561792, '2022-10-18 07:28:53', '抖音号对比', '/streamer/streamerCompare/**', '', 1364850862768128, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851226083328, '2022-10-18 07:29:17', 'MCN媒体库', '/streamer/MCN/**', '', 1364850862768128, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851264036864, '2022-10-18 07:30:03', '我的抖音号', '/monitor/accountList/**', '', 1364850874744832, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851299868672, '2022-10-18 07:30:47', '我的授权', '/monitor/authorize/**', '', 1364850874744832, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851335880704, '2022-10-18 07:31:31', '我的收藏', '/monitor/collection/**', '', 1364850874744832, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364851351740416, '2022-10-18 07:31:50', '带货能力诊断', '/monitor/saleCheck/**', '', 1364850874744832, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364926290870272, '2022-10-19 08:56:29', '商品搜索', '/analysis/productSearch/**', '', 1364850884575232, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364926326693888, '2022-10-19 08:57:12', '热门带货视频', '/analysis/video/**', '', 1364850884575232, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364926392999936, '2022-10-19 08:58:33', '电商视频排行', '/analysis/videoRank/**', '', 1364850884575232, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364926457298944, '2022-10-19 08:59:52', '电商商品排行', '/analysis/productRank/**', '', 1364850884575232, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364926513152000, '2022-10-19 09:01:00', '明星达人销售榜', '/analysis/saleRank/**', '', 1364850884575232, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364926592032768, '2022-10-19 09:02:36', '电商品牌排行', '/brand/brandRank/**', '', 1364850890481664, '2022-10-19 09:03:16', 0);
INSERT INTO `ums_resource` VALUES (1364926648254464, '2022-10-19 09:03:45', '品牌精准搜索', '/brand/brandRearch/**', '', 1364850890481664, NULL, 0);
INSERT INTO `ums_resource` VALUES (1364926673190912, '2022-10-19 09:04:15', '品牌多维对比', '/brand/brandCompare/**', '', 1364850890481664, NULL, 0);

-- ----------------------------
-- Table structure for ums_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource_category`;
CREATE TABLE `ums_resource_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1364850890481665 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_resource_category
-- ----------------------------
INSERT INTO `ums_resource_category` VALUES (1, '2020-02-05 10:21:44', '商品模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (4, '2020-02-05 10:23:04', '权限模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (6, '2020-02-07 16:35:49', '其他模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (1364763164188672, '2022-10-17 01:37:39', '任务模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (1364763385634816, '2022-10-17 01:42:10', '客户模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (1364763393245184, '2022-10-17 01:42:19', '审核模块', 0, '2022-10-20 03:24:07', 0);
INSERT INTO `ums_resource_category` VALUES (1364763414249472, '2022-10-17 01:42:45', '个人中心模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (1364763424997376, '2022-10-17 01:42:58', '账户中心模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (1364764990332928, '2022-10-17 02:14:49', '图片管理模块', 0, NULL, 0);
INSERT INTO `ums_resource_category` VALUES (1364850862768128, '2022-10-18 07:21:53', '主播查找模块', 0, '2022-10-18 07:22:45', 0);
INSERT INTO `ums_resource_category` VALUES (1364850874744832, '2022-10-18 07:22:08', '数据监测模块', 0, '2022-10-18 07:22:52', 0);
INSERT INTO `ums_resource_category` VALUES (1364850884575232, '2022-10-18 07:22:20', '电商分析模块', 0, '2022-10-18 07:22:58', 0);
INSERT INTO `ums_resource_category` VALUES (1364850890481664, '2022-10-18 07:22:27', '品牌推广模块', 0, '2022-10-18 07:23:04', 0);

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) NULL DEFAULT NULL COMMENT '后台用户数量',
  `status` int(1) NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES (5, '超级管理员', '享有最高权限', 0, 1, 0, NULL, NULL, 0);
INSERT INTO `ums_role` VALUES (8, '运营人员', '负责审核和权限模块操作', 0, 1, 0, NULL, NULL, 0);
INSERT INTO `ums_role` VALUES (9, '播主', '主播/MCN', 0, 1, 0, NULL, NULL, 0);
INSERT INTO `ums_role` VALUES (10, '品牌方', '品牌商/政府', 0, 1, 0, NULL, NULL, 0);
INSERT INTO `ums_role` VALUES (20, '吕天昊', '子温而厉，威而不猛，恭而安。', 0, 1, 0, '2022-11-10 17:14:47', '2022-11-11 10:58:21', 0);
INSERT INTO `ums_role` VALUES (21, '董忠林', '子曰：君子周而不比，小人比而不周。', 0, 1, 0, '2022-11-10 17:16:19', NULL, 0);
INSERT INTO `ums_role` VALUES (22, '金芳', '夷狄之有君，不如诸夏之无也。', 0, 1, 0, '2022-11-10 17:17:30', '2022-11-10 18:24:14', 1);
INSERT INTO `ums_role` VALUES (23, '金芳', '夷狄之有君，不如诸夏之无也。', 0, 1, 0, '2022-11-10 17:17:39', NULL, 0);
INSERT INTO `ums_role` VALUES (24, '钱佳琪', '夫子温、良、恭、俭、让。', 0, 1, 0, '2022-11-10 17:18:03', NULL, 0);
INSERT INTO `ums_role` VALUES (25, '卢运昊', '弟子入则孝，出则悌，谨而信，泛爱众而亲仁，行有余力，则以学文。', 0, 1, 0, '2022-11-10 17:20:06', '2022-11-10 17:52:59', 1);
INSERT INTO `ums_role` VALUES (26, '邵益辰', '自古皆有死，民无信不立。', 0, 1, 0, '2022-11-10 17:44:23', '2022-11-10 17:52:59', 1);
INSERT INTO `ums_role` VALUES (27, 'string', 'hhhhhhhh', 0, 0, 0, '2022-11-10 18:08:58', '2022-11-14 14:26:57', 0);
INSERT INTO `ums_role` VALUES (28, '高尚', '道不同，不相为谋。', 0, 1, 0, '2022-11-10 18:25:49', NULL, 0);
INSERT INTO `ums_role` VALUES (29, '吕佳玉', '爱之欲其生，恶之欲其死。', 0, 1, 0, '2022-11-11 11:04:48', '2022-11-14 14:17:36', 1);

-- ----------------------------
-- Table structure for ums_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_menu_relation`;
CREATE TABLE `ums_role_menu_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1364715460018212 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台角色菜单关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_role_menu_relation
-- ----------------------------
INSERT INTO `ums_role_menu_relation` VALUES (33, 1, 1, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (34, 1, 2, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (35, 1, 3, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (36, 1, 4, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (37, 1, 5, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (38, 1, 6, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (53, 2, 7, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (54, 2, 8, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (55, 2, 9, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (56, 2, 10, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (57, 2, 11, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (96, 6, 21, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (97, 6, 22, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (98, 6, 23, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (99, 6, 24, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (100, 6, 25, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (101, 7, 21, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (102, 7, 22, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (103, 7, 23, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (104, 7, 24, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (105, 7, 25, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975168, 9, 29, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975169, 9, 35, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975170, 9, 36, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975171, 9, 37, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975172, 9, 38, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975173, 9, 39, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975174, 9, 40, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975175, 9, 41, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975176, 9, 30, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975177, 9, 42, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975178, 9, 43, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975179, 9, 44, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975180, 9, 45, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975181, 9, 31, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975182, 9, 46, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975183, 9, 47, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975184, 9, 48, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975185, 9, 49, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975186, 9, 50, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975187, 9, 32, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975188, 9, 51, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975189, 9, 52, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975190, 9, 53, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975191, 9, 62, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975192, 9, 60, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975193, 9, 63, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975194, 9, 71, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975195, 9, 69, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975196, 9, 72, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975197, 9, 74, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975198, 9, 73, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715235975199, 9, 78, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311497216, 8, 55, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311497217, 8, 54, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311497218, 8, 57, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505408, 8, 58, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505409, 8, 59, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505410, 8, 65, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505411, 8, 64, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505412, 8, 68, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505413, 8, 74, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505414, 8, 73, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505415, 8, 77, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715311505416, 8, 78, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526208, 5, 21, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526209, 5, 22, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526210, 5, 23, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526211, 5, 24, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526212, 5, 25, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526213, 5, 75, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526214, 5, 73, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715346526215, 5, 76, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018176, 10, 29, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018177, 10, 35, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018178, 10, 36, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018179, 10, 37, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018180, 10, 38, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018181, 10, 39, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018182, 10, 40, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018183, 10, 41, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018184, 10, 30, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018185, 10, 42, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018186, 10, 43, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018187, 10, 44, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018188, 10, 45, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018189, 10, 31, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018190, 10, 46, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018191, 10, 47, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018192, 10, 48, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018193, 10, 49, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018194, 10, 50, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018195, 10, 32, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018196, 10, 51, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018197, 10, 52, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018198, 10, 53, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018199, 10, 56, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018200, 10, 54, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018201, 10, 61, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018202, 10, 60, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018203, 10, 66, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018204, 10, 64, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018205, 10, 67, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018206, 10, 70, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018207, 10, 69, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018208, 10, 72, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018209, 10, 74, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018210, 10, 73, NULL, NULL, 0);
INSERT INTO `ums_role_menu_relation` VALUES (1364715460018211, 10, 78, NULL, NULL, 0);

-- ----------------------------
-- Table structure for ums_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource_relation`;
CREATE TABLE `ums_role_resource_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识（0为否，1为是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1364981848178720 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台角色资源关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_role_resource_relation
-- ----------------------------
INSERT INTO `ums_role_resource_relation` VALUES (103, 2, 8, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (104, 2, 9, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (105, 2, 10, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (106, 2, 11, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (107, 2, 12, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (170, 1, 1, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (171, 1, 2, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (172, 1, 3, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (173, 1, 4, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (174, 1, 5, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (175, 1, 6, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (176, 1, 23, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (177, 1, 24, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (178, 6, 25, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (179, 6, 26, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (180, 6, 27, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (181, 6, 28, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (182, 6, 29, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (205, 7, 25, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (206, 7, 26, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (207, 7, 27, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (208, 7, 28, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (209, 7, 29, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (210, 7, 31, NULL, NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (244, 8, 25, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (245, 8, 26, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (246, 8, 27, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (247, 8, 28, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (248, 8, 29, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356864, 5, 2, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356865, 5, 5, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356866, 5, 25, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356867, 5, 26, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356868, 5, 27, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356869, 5, 28, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356870, 5, 29, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356871, 5, 1364764972646400, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364765048356872, 5, 1364765009125376, NULL, NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233280, 5, 2, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233281, 5, 25, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233282, 5, 26, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233283, 5, 27, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233284, 5, 28, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233285, 5, 29, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233286, 5, 1364763873550336, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233287, 5, 1364764033875968, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233288, 5, 1364764072247296, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233289, 5, 1364764972646400, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233290, 5, 1364765009125376, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926827233291, 5, 1364850751111168, '2022-10-19 09:07:23', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889639936, 5, 2, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889639937, 5, 5, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889639938, 5, 25, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889639939, 5, 26, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889639940, 5, 27, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889639941, 5, 28, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889648128, 5, 29, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889648129, 5, 1364763873550336, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889648130, 5, 1364764033875968, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889648131, 5, 1364764072247296, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889648132, 5, 1364764972646400, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889648133, 5, 1364765009125376, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364926889648134, 5, 1364850751111168, '2022-10-19 09:08:40', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499968, 8, 2, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499969, 8, 1364763873550336, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499970, 8, 1364764033875968, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499971, 8, 1364764072247296, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499972, 8, 1364764823814144, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499973, 8, 1364764972646400, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499974, 8, 1364765009125376, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499975, 8, 1364849910964224, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499976, 8, 1364850464333824, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499977, 8, 1364850531729408, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499978, 8, 1364850565226496, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927004499979, 8, 1364850751111168, '2022-10-19 09:11:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607360, 9, 1364764507725824, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607361, 9, 1364764534751232, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607362, 9, 1364765009125376, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607363, 9, 1364850299772928, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607364, 9, 1364850371919872, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607365, 9, 1364850464333824, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607366, 9, 1364850531729408, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102607367, 9, 1364850565226496, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615552, 9, 1364850751111168, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615553, 9, 1364850770911232, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615554, 9, 1364850802933760, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615555, 9, 1364851008716800, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615556, 9, 1364851032096768, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615557, 9, 1364851097837568, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615558, 9, 1364851137036288, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615559, 9, 1364851168141312, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615560, 9, 1364851206561792, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615561, 9, 1364851226083328, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615562, 9, 1364851264036864, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615563, 9, 1364851299868672, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615564, 9, 1364851335880704, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615565, 9, 1364851351740416, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615566, 9, 1364926290870272, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615567, 9, 1364926326693888, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615568, 9, 1364926392999936, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615569, 9, 1364926457298944, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615570, 9, 1364926513152000, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615571, 9, 1364926592032768, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102615572, 9, 1364926648254464, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927102623744, 9, 1364926673190912, '2022-10-19 09:13:00', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006656, 10, 5, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006657, 10, 1364764108660736, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006658, 10, 1364765009125376, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006659, 10, 1364849805377536, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006660, 10, 1364849855004672, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006661, 10, 1364850221801472, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006662, 10, 1364850299772928, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006663, 10, 1364850371919872, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006664, 10, 1364850464333824, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006665, 10, 1364850531729408, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006666, 10, 1364850565226496, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006667, 10, 1364850751111168, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006668, 10, 1364850770911232, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006669, 10, 1364850802933760, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006670, 10, 1364851008716800, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006671, 10, 1364851032096768, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006672, 10, 1364851097837568, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006673, 10, 1364851137036288, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192006674, 10, 1364851168141312, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014848, 10, 1364851206561792, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014849, 10, 1364851226083328, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014850, 10, 1364851264036864, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014851, 10, 1364851299868672, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014852, 10, 1364851335880704, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014853, 10, 1364851351740416, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014854, 10, 1364926290870272, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014855, 10, 1364926326693888, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014856, 10, 1364926392999936, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014857, 10, 1364926457298944, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014858, 10, 1364926513152000, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014859, 10, 1364926592032768, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014860, 10, 1364926648254464, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364927192014861, 10, 1364926673190912, '2022-10-19 09:14:49', NULL, 1);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502400, 5, 2, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502401, 5, 5, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502402, 5, 25, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502403, 5, 26, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502404, 5, 27, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502405, 5, 28, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502406, 5, 29, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502407, 5, 1364763873550336, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502408, 5, 1364764033875968, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502409, 5, 1364764072247296, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502410, 5, 1364764108660736, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502411, 5, 1364764507725824, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502412, 5, 1364764534751232, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502413, 5, 1364764823814144, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502414, 5, 1364764972646400, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502415, 5, 1364765009125376, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502416, 5, 1364849805377536, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502417, 5, 1364849855004672, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502418, 5, 1364849910964224, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502419, 5, 1364850221801472, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502420, 5, 1364850299772928, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094502421, 5, 1364850371919872, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510592, 5, 1364850464333824, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510593, 5, 1364850531729408, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510594, 5, 1364850565226496, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510595, 5, 1364850751111168, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510596, 5, 1364850770911232, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510597, 5, 1364850802933760, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510598, 5, 1364851008716800, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510599, 5, 1364851032096768, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510600, 5, 1364851097837568, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510601, 5, 1364851137036288, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510602, 5, 1364851168141312, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510603, 5, 1364851206561792, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510604, 5, 1364851226083328, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510605, 5, 1364851264036864, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510606, 5, 1364851299868672, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510607, 5, 1364851335880704, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510608, 5, 1364851351740416, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510609, 5, 1364926290870272, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510610, 5, 1364926326693888, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510611, 5, 1364926392999936, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510612, 5, 1364926457298944, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510613, 5, 1364926513152000, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510614, 5, 1364926592032768, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510615, 5, 1364926648254464, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364941094510616, 5, 1364926673190912, '2022-10-19 13:57:40', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695104, 8, 2, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695105, 8, 25, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695106, 8, 26, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695107, 8, 27, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695108, 8, 28, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695109, 8, 29, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695110, 8, 1364763873550336, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695111, 8, 1364764033875968, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695112, 8, 1364764072247296, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695113, 8, 1364764534751232, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695114, 8, 1364764972646400, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695115, 8, 1364765009125376, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695116, 8, 1364849855004672, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695117, 8, 1364850464333824, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695118, 8, 1364850531729408, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695119, 8, 1364850565226496, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981819695120, 8, 1364850751111168, '2022-10-20 03:46:13', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687616, 9, 1364764507725824, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687617, 9, 1364765009125376, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687618, 9, 1364850299772928, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687619, 9, 1364850371919872, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687620, 9, 1364850464333824, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687621, 9, 1364850531729408, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687622, 9, 1364850565226496, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687623, 9, 1364850751111168, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687624, 9, 1364850770911232, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687625, 9, 1364850802933760, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687626, 9, 1364851008716800, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687627, 9, 1364851032096768, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687628, 9, 1364851097837568, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687629, 9, 1364851137036288, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687630, 9, 1364851168141312, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687631, 9, 1364851206561792, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687632, 9, 1364851226083328, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687633, 9, 1364851264036864, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687634, 9, 1364851299868672, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687635, 9, 1364851335880704, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687636, 9, 1364851351740416, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687637, 9, 1364926290870272, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687638, 9, 1364926326693888, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687639, 9, 1364926392999936, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687640, 9, 1364926457298944, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687641, 9, 1364926513152000, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687642, 9, 1364926592032768, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687643, 9, 1364926648254464, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981832687644, 9, 1364926673190912, '2022-10-20 03:46:29', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178688, 10, 5, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178689, 10, 1364764108660736, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178690, 10, 1364765009125376, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178691, 10, 1364849805377536, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178692, 10, 1364850221801472, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178693, 10, 1364850299772928, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178694, 10, 1364850371919872, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178695, 10, 1364850464333824, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178696, 10, 1364850531729408, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178697, 10, 1364850565226496, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178698, 10, 1364850751111168, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178699, 10, 1364850770911232, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178700, 10, 1364850802933760, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178701, 10, 1364851008716800, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178702, 10, 1364851032096768, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178703, 10, 1364851097837568, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178704, 10, 1364851137036288, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178705, 10, 1364851168141312, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178706, 10, 1364851206561792, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178707, 10, 1364851226083328, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178708, 10, 1364851264036864, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178709, 10, 1364851299868672, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178710, 10, 1364851335880704, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178711, 10, 1364851351740416, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178712, 10, 1364926290870272, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178713, 10, 1364926326693888, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178714, 10, 1364926392999936, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178715, 10, 1364926457298944, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178716, 10, 1364926513152000, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178717, 10, 1364926592032768, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178718, 10, 1364926648254464, '2022-10-20 03:46:48', NULL, 0);
INSERT INTO `ums_role_resource_relation` VALUES (1364981848178719, 10, 1364926673190912, '2022-10-20 03:46:48', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
