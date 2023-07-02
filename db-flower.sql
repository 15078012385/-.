/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : db-flower

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 02/07/2023 15:41:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `recipient_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1015 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (1005, 0, '***', '北京市朝阳区xx街道xx小区1号楼101室', '13812345678');
INSERT INTO `tb_address` VALUES (1006, 1, '***', '上海市浦东新区xx街道xx小区2号楼202室', '13987654321');
INSERT INTO `tb_address` VALUES (1007, 2, '***', '广州市天河区xx街道xx小区3号楼303室', '13611112222');
INSERT INTO `tb_address` VALUES (1008, 2, '***', '深圳市福田区xx街道xx小区4号楼404室', '13722223333');
INSERT INTO `tb_address` VALUES (1009, 3, '***', '杭州市西湖区xx街道xx小区5号楼505室', '15833334444');
INSERT INTO `tb_address` VALUES (1010, 3, '***', '南京市鼓楼区xx街道xx小区6号楼606室', '18755556666');
INSERT INTO `tb_address` VALUES (1011, 4, '***', '成都市锦江区xx街道xx小区7号楼707室', '13988889999');
INSERT INTO `tb_address` VALUES (1012, 4, '***', '重庆市渝中区xx街道xx小区8号楼808室', '13699991111');
INSERT INTO `tb_address` VALUES (1013, 5, '***', '武汉市江汉区xx街道xx小区9号楼909室', '13900001111');
INSERT INTO `tb_address` VALUES (1014, 5, '***', '西安市雁塔区xx街道xx小区10号楼1010室', '15811112222');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT 0,
  `product_id` int NULL DEFAULT 0,
  `quantity` int NOT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  `order_date` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (19, 0, 0, 10, 260.00, '2023-07-02 14:52:51', '水仙花-26', 'admin', '上海市浦东新区xx街道xx小区2号楼202室');
INSERT INTO `tb_order` VALUES (20, 0, 0, 35, 910.00, '2023-07-02 14:53:09', '水仙花-26', 'test', '南京市鼓楼区xx街道xx小区6号楼606室');

-- ----------------------------
-- Table structure for tb_origin
-- ----------------------------
DROP TABLE IF EXISTS `tb_origin`;
CREATE TABLE `tb_origin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `origin_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_origin
-- ----------------------------
INSERT INTO `tb_origin` VALUES (31, '北京市朝阳区');
INSERT INTO `tb_origin` VALUES (32, '上海市浦东新区');
INSERT INTO `tb_origin` VALUES (33, '广东省深圳市南山区');
INSERT INTO `tb_origin` VALUES (34, '江苏省苏州市工业园区');
INSERT INTO `tb_origin` VALUES (35, '浙江省杭州市西湖区');
INSERT INTO `tb_origin` VALUES (36, '山东省青岛市市南区');
INSERT INTO `tb_origin` VALUES (37, '河南省郑州市金水区');
INSERT INTO `tb_origin` VALUES (38, '湖南省长沙市岳麓区');
INSERT INTO `tb_origin` VALUES (39, '湖北省武汉市洪山区');
INSERT INTO `tb_origin` VALUES (40, '福建省厦门市思明区');
INSERT INTO `tb_origin` VALUES (41, '四川省成都市高新区');
INSERT INTO `tb_origin` VALUES (42, '重庆市渝中区');
INSERT INTO `tb_origin` VALUES (43, '辽宁省大连市西岗区');
INSERT INTO `tb_origin` VALUES (44, '黑龙江省哈尔滨市南岗区');
INSERT INTO `tb_origin` VALUES (45, '河北省石家庄市长安区');
INSERT INTO `tb_origin` VALUES (46, '山西省太原市小店区');
INSERT INTO `tb_origin` VALUES (47, '陕西省西安市雁塔区');
INSERT INTO `tb_origin` VALUES (48, '云南省昆明市盘龙区');
INSERT INTO `tb_origin` VALUES (49, '贵州省贵阳市南明区');
INSERT INTO `tb_origin` VALUES (50, '广西壮族自治区南宁市青秀区');

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `category_id` int NULL DEFAULT NULL,
  `origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `product_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES (13, '水仙花', 26.00, NULL, '江苏省苏州市工业园区', '生日鲜花');

-- ----------------------------
-- Table structure for tb_product_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;
CREATE TABLE `tb_product_category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product_category
-- ----------------------------
INSERT INTO `tb_product_category` VALUES (8, '生日鲜花');
INSERT INTO `tb_product_category` VALUES (9, '情人节鲜花');
INSERT INTO `tb_product_category` VALUES (10, '结婚鲜花');
INSERT INTO `tb_product_category` VALUES (11, '庆祝鲜花');
INSERT INTO `tb_product_category` VALUES (12, '悼念鲜花');

-- ----------------------------
-- Table structure for tb_system_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_log`;
CREATE TABLE `tb_system_log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `access_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `access_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3134 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_system_log
-- ----------------------------
INSERT INTO `tb_system_log` VALUES (3104, '2023-07-02 14:55:56', 'http://localhost:8080/api/system-log', '2023-07-02 14:55:56');
INSERT INTO `tb_system_log` VALUES (3105, '2023-07-02 14:56:07', 'http://localhost:8080/api/system-log', '2023-07-02 14:56:07');
INSERT INTO `tb_system_log` VALUES (3106, '2023-07-02 14:56:31', 'http://localhost:8080/api/system-log', '2023-07-02 14:56:31');
INSERT INTO `tb_system_log` VALUES (3107, '2023-07-02 14:58:41', 'http://localhost:8080/api/system-log', '2023-07-02 14:58:41');
INSERT INTO `tb_system_log` VALUES (3108, '2023-07-02 14:58:41', 'http://localhost:8080/api/user', '2023-07-02 14:58:41');
INSERT INTO `tb_system_log` VALUES (3109, '2023-07-02 14:58:41', 'http://localhost:8080/api/product', '2023-07-02 14:58:41');
INSERT INTO `tb_system_log` VALUES (3110, '2023-07-02 14:58:41', 'http://localhost:8080/api/order', '2023-07-02 14:58:41');
INSERT INTO `tb_system_log` VALUES (3111, '2023-07-02 15:39:31', 'http://localhost:8080/', '2023-07-02 15:39:31');
INSERT INTO `tb_system_log` VALUES (3112, '2023-07-02 15:39:31', 'http://localhost:8080/', '2023-07-02 15:39:31');
INSERT INTO `tb_system_log` VALUES (3113, '2023-07-02 15:39:31', 'http://localhost:8080/', '2023-07-02 15:39:31');
INSERT INTO `tb_system_log` VALUES (3114, '2023-07-02 15:39:35', 'http://localhost:8080/api/system-log', '2023-07-02 15:39:35');
INSERT INTO `tb_system_log` VALUES (3115, '2023-07-02 15:39:35', 'http://localhost:8080/api/product', '2023-07-02 15:39:35');
INSERT INTO `tb_system_log` VALUES (3116, '2023-07-02 15:39:35', 'http://localhost:8080/api/order', '2023-07-02 15:39:35');
INSERT INTO `tb_system_log` VALUES (3117, '2023-07-02 15:39:35', 'http://localhost:8080/api/user', '2023-07-02 15:39:35');
INSERT INTO `tb_system_log` VALUES (3118, '2023-07-02 15:39:40', 'http://localhost:8080/api/system-log', '2023-07-02 15:39:40');
INSERT INTO `tb_system_log` VALUES (3119, '2023-07-02 15:40:19', 'http://localhost:8080/api/address', '2023-07-02 15:40:19');
INSERT INTO `tb_system_log` VALUES (3120, '2023-07-02 15:40:20', 'http://localhost:8080/api/address', '2023-07-02 15:40:20');
INSERT INTO `tb_system_log` VALUES (3121, '2023-07-02 15:40:20', 'http://localhost:8080/api/user', '2023-07-02 15:40:20');
INSERT INTO `tb_system_log` VALUES (3122, '2023-07-02 15:40:20', 'http://localhost:8080/api/order', '2023-07-02 15:40:20');
INSERT INTO `tb_system_log` VALUES (3123, '2023-07-02 15:40:20', 'http://localhost:8080/api/product', '2023-07-02 15:40:20');
INSERT INTO `tb_system_log` VALUES (3124, '2023-07-02 15:40:22', 'http://localhost:8080/api/order', '2023-07-02 15:40:22');
INSERT INTO `tb_system_log` VALUES (3125, '2023-07-02 15:40:27', 'http://localhost:8080/api/origin', '2023-07-02 15:40:27');
INSERT INTO `tb_system_log` VALUES (3126, '2023-07-02 15:40:27', 'http://localhost:8080/api/product-category', '2023-07-02 15:40:27');
INSERT INTO `tb_system_log` VALUES (3127, '2023-07-02 15:40:28', 'http://localhost:8080/api/user-category', '2023-07-02 15:40:28');
INSERT INTO `tb_system_log` VALUES (3128, '2023-07-02 15:40:29', 'http://localhost:8080/api/product', '2023-07-02 15:40:29');
INSERT INTO `tb_system_log` VALUES (3129, '2023-07-02 15:40:37', 'http://localhost:8080/api/user', '2023-07-02 15:40:37');
INSERT INTO `tb_system_log` VALUES (3130, '2023-07-02 15:40:38', 'http://localhost:8080/api/user', '2023-07-02 15:40:38');
INSERT INTO `tb_system_log` VALUES (3131, '2023-07-02 15:40:42', 'http://localhost:8080/api/user', '2023-07-02 15:40:42');
INSERT INTO `tb_system_log` VALUES (3132, '2023-07-02 15:40:42', 'http://localhost:8080/api/product', '2023-07-02 15:40:42');
INSERT INTO `tb_system_log` VALUES (3133, '2023-07-02 15:40:42', 'http://localhost:8080/api/order', '2023-07-02 15:40:42');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (23, 'admin', '123456', '钉钉', '15078021586', '管理员');
INSERT INTO `tb_user` VALUES (24, 'test', '1234566', '测试员', '15078012548', '普通用户');

-- ----------------------------
-- Table structure for tb_user_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_category`;
CREATE TABLE `tb_user_category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_category
-- ----------------------------
INSERT INTO `tb_user_category` VALUES (6, '管理员');
INSERT INTO `tb_user_category` VALUES (7, '普通用户');

SET FOREIGN_KEY_CHECKS = 1;
