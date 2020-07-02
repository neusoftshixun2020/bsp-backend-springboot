/*
 Navicat Premium Data Transfer

 Source Server         : bsp
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 49.232.199.44:3306
 Source Schema         : bsp

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 02/07/2020 19:26:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brd_brand
-- ----------------------------
DROP TABLE IF EXISTS `brd_brand`;
CREATE TABLE `brd_brand`  (
  `BRD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `NAME_EN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`BRD_ID`) USING BTREE,
  INDEX `MAN_ID`(`MAN_ID`) USING BTREE,
  CONSTRAINT `brd_brand_ibfk_1` FOREIGN KEY (`MAN_ID`) REFERENCES `man_manufacturer` (`MAN_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cdm_code_master
-- ----------------------------
DROP TABLE IF EXISTS `cdm_code_master`;
CREATE TABLE `cdm_code_master`  (
  `CDM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_TYPE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CODE_VAL` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEQ_NO` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CDM_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for drp_dropship_price
-- ----------------------------
DROP TABLE IF EXISTS `drp_dropship_price`;
CREATE TABLE `drp_dropship_price`  (
  `DRP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OFP_ID` int(11) NULL DEFAULT NULL,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `WAR_ID` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`DRP_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE,
  INDEX `OFP_ID`(`OFP_ID`) USING BTREE,
  CONSTRAINT `drp_dropship_price_ibfk_1` FOREIGN KEY (`DSR_ID`) REFERENCES `dsr_dropshipper` (`DSR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `drp_dropship_price_ibfk_2` FOREIGN KEY (`OFP_ID`) REFERENCES `ofp_offer_price` (`OFP_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dsr_dropshipper
-- ----------------------------
DROP TABLE IF EXISTS `dsr_dropshipper`;
CREATE TABLE `dsr_dropshipper`  (
  `DSR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REGISTER_DATE` timestamp(0) NOT NULL,
  PRIMARY KEY (`DSR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for eba_ebay_authorization
-- ----------------------------
DROP TABLE IF EXISTS `eba_ebay_authorization`;
CREATE TABLE `eba_ebay_authorization`  (
  `EBA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STR_ID` int(11) NULL DEFAULT NULL,
  `APP_ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SECRET_KEY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TOKEN` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXP_DATE` datetime(0) NULL DEFAULT NULL,
  `CANCLE_DATE` datetime(0) NULL DEFAULT NULL,
  `ACCOUNT_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`EBA_ID`) USING BTREE,
  INDEX `STR_ID`(`STR_ID`) USING BTREE,
  CONSTRAINT `eba_ebay_authorization_ibfk_1` FOREIGN KEY (`STR_ID`) REFERENCES `str_store` (`STR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goa_government_area
-- ----------------------------
DROP TABLE IF EXISTS `goa_government_area`;
CREATE TABLE `goa_government_area`  (
  `GOA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ZIP_CODE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE_SHORTHAND` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CITY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`GOA_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for img_image
-- ----------------------------
DROP TABLE IF EXISTS `img_image`;
CREATE TABLE `img_image`  (
  `IMG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WIDTH` int(11) NULL DEFAULT NULL,
  `HEIGHT` int(11) NULL DEFAULT NULL,
  `URI` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE_CD` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ENTITY_ID` int(11) NULL DEFAULT NULL,
  `ENTITY_CD` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEQ_NO` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IMG_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for man_manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `man_manufacturer`;
CREATE TABLE `man_manufacturer`  (
  `MAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_EN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GMC_REPORT_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GMC_REPORT_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MAN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mor_monitor_result
-- ----------------------------
DROP TABLE IF EXISTS `mor_monitor_result`;
CREATE TABLE `mor_monitor_result`  (
  `MOR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASS_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JSON_STRING` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_DATE` datetime(0) NULL DEFAULT NULL,
  `CREATE_BY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UPDATE_DATE` datetime(0) NULL DEFAULT NULL,
  `UPDATE_BY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MOR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ofp_offer_price
-- ----------------------------
DROP TABLE IF EXISTS `ofp_offer_price`;
CREATE TABLE `ofp_offer_price`  (
  `OFP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `EFFETIVE_START_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `EFFECTIVE_END_DATE` timestamp(0) NOT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `PRICE` decimal(8, 2) NULL DEFAULT NULL,
  `TYPE_CD` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL,
  `LAST_UPDATE_BY` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PERIOD` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`OFP_ID`) USING BTREE,
  INDEX `MAN_ID`(`MAN_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  CONSTRAINT `ofp_offer_price_ibfk_1` FOREIGN KEY (`MAN_ID`) REFERENCES `man_manufacturer` (`MAN_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ofp_offer_price_ibfk_2` FOREIGN KEY (`DSR_ID`) REFERENCES `dsr_dropshipper` (`DSR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ofp_offer_price_ibfk_3` FOREIGN KEY (`PRO_ID`) REFERENCES `pro_product` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for par_parameter
-- ----------------------------
DROP TABLE IF EXISTS `par_parameter`;
CREATE TABLE `par_parameter`  (
  `PAR_ID` int(11) NOT NULL,
  `PARAM_CD` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PARAM_VALUE` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PAR_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pck_package_info
-- ----------------------------
DROP TABLE IF EXISTS `pck_package_info`;
CREATE TABLE `pck_package_info`  (
  `PCK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `WAR_ID` int(11) NULL DEFAULT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `TYPE_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WIDTH` decimal(7, 2) NULL DEFAULT NULL,
  `HEIGHT` decimal(7, 2) NULL DEFAULT NULL,
  `LENGTH` decimal(7, 2) NULL DEFAULT NULL,
  `WEIGHT` decimal(5, 2) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HEAVY_CARGO` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LOGISTICS_COMPANY` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PCK_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  CONSTRAINT `pck_package_info_ibfk_1` FOREIGN KEY (`PRO_ID`) REFERENCES `pro_product` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pdn_product_descrition
-- ----------------------------
DROP TABLE IF EXISTS `pdn_product_descrition`;
CREATE TABLE `pdn_product_descrition`  (
  `PDN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `TYPE_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRITION` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PDN_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  CONSTRAINT `pdn_product_descrition_ibfk_1` FOREIGN KEY (`PRO_ID`) REFERENCES `pro_product` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for prc_product_category
-- ----------------------------
DROP TABLE IF EXISTS `prc_product_category`;
CREATE TABLE `prc_product_category`  (
  `PRC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `CATEGORY_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CATEGORY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CATEGORY_PATH` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PLATEFORM_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRC_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pro_product
-- ----------------------------
DROP TABLE IF EXISTS `pro_product`;
CREATE TABLE `pro_product`  (
  `PRO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SKU_CD` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BRD_ID` int(11) NULL DEFAULT NULL,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UPC` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EAN` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MODEL` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WARRANTY_DAY` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `RETAIL_PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MININUM_RETAIL_PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `REPLENISHMENT_PERIOD` int(11) NULL DEFAULT NULL,
  `KEY_WORDS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WARRANTY` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `TIME_UNIT` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STOCKSETING` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`PRO_ID`) USING BTREE,
  INDEX `BRD_ID`(`BRD_ID`) USING BTREE,
  INDEX `MAN_ID`(`MAN_ID`) USING BTREE,
  CONSTRAINT `pro_product_ibfk_1` FOREIGN KEY (`BRD_ID`) REFERENCES `brd_brand` (`BRD_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `pro_product_ibfk_2` FOREIGN KEY (`MAN_ID`) REFERENCES `man_manufacturer` (`MAN_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sal_sales_order_line_item
-- ----------------------------
DROP TABLE IF EXISTS `sal_sales_order_line_item`;
CREATE TABLE `sal_sales_order_line_item`  (
  `SAL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SAO_ID` int(11) NULL DEFAULT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `QTY` int(11) NULL DEFAULT NULL,
  `PRICE` decimal(8, 2) NULL DEFAULT NULL,
  `SOL_ID` int(11) NULL DEFAULT NULL,
  `TRACKING_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WSP_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SAL_ID`) USING BTREE,
  INDEX `SOL_ID`(`SOL_ID`) USING BTREE,
  INDEX `SAO_ID`(`SAO_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  CONSTRAINT `sal_sales_order_line_item_ibfk_1` FOREIGN KEY (`SOL_ID`) REFERENCES `sol_store_order_line_item` (`SOL_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `sal_sales_order_line_item_ibfk_2` FOREIGN KEY (`SAO_ID`) REFERENCES `sao_sales_order` (`SAO_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `sal_sales_order_line_item_ibfk_3` FOREIGN KEY (`PRO_ID`) REFERENCES `pro_product` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sao_sales_order
-- ----------------------------
DROP TABLE IF EXISTS `sao_sales_order`;
CREATE TABLE `sao_sales_order`  (
  `SAO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `WAR_ID` int(11) NULL DEFAULT NULL,
  `SYNC_DATE` timestamp(0) NOT NULL,
  `PAYMENT_DATE` timestamp(0) NOT NULL,
  `PUSH_DATE` timestamp(0) NOT NULL,
  `TRACK_NO_DATE` timestamp(0) NOT NULL,
  `FULFILLMENT_DATE` timestamp(0) NOT NULL,
  `SETTLEMENT_DATE` timestamp(0) NOT NULL,
  `PRODUCT_AMOUNT` decimal(8, 2) NULL DEFAULT NULL,
  `FREIGHT_COST` decimal(8, 2) NULL DEFAULT NULL,
  `HANDLING_FEE` decimal(8, 2) NULL DEFAULT NULL,
  `CUSTOMER_REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_STS` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REFUND_STS` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DELIVERY_STS` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STO_ID` int(11) NULL DEFAULT NULL,
  `LAST_FREIGHT_COST` decimal(8, 2) NULL DEFAULT NULL,
  `CANCLE_TIME` timestamp(0) NOT NULL,
  `AUTO_PAY_STATUS` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BUYER_CHECKOUT_MESSAGE` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `AUTO_PAY_TIME` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SAO_ID`) USING BTREE,
  INDEX `MAN_ID`(`MAN_ID`) USING BTREE,
  INDEX `STO_ID`(`STO_ID`) USING BTREE,
  CONSTRAINT `sao_sales_order_ibfk_1` FOREIGN KEY (`MAN_ID`) REFERENCES `man_manufacturer` (`MAN_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `sao_sales_order_ibfk_2` FOREIGN KEY (`STO_ID`) REFERENCES `sto_store_order` (`STO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sdi_store_dropship_item
-- ----------------------------
DROP TABLE IF EXISTS `sdi_store_dropship_item`;
CREATE TABLE `sdi_store_dropship_item`  (
  `DIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `STR_ID` int(11) NULL DEFAULT NULL,
  `STORE_RETENTION` int(11) NULL DEFAULT NULL,
  `DROPSHIP_PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `DROPSHIP_STATUS` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SHELF_STOCK` int(11) NULL DEFAULT NULL,
  `PREFER_DATE` timestamp(0) NOT NULL,
  PRIMARY KEY (`DIL_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  INDEX `STR_ID`(`STR_ID`) USING BTREE,
  CONSTRAINT `sdi_store_dropship_item_ibfk_1` FOREIGN KEY (`PRO_ID`) REFERENCES `pro_product` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `sdi_store_dropship_item_ibfk_2` FOREIGN KEY (`STR_ID`) REFERENCES `str_store` (`STR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence`  (
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `current_value` int(11) NULL DEFAULT NULL,
  `increment` int(11) NULL DEFAULT NULL,
  `initial` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sha_shipping_address
-- ----------------------------
DROP TABLE IF EXISTS `sha_shipping_address`;
CREATE TABLE `sha_shipping_address`  (
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FAMILY_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GIVEN_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COUNTRY_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COUNTRY_ISO_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE_OR_PROVINCE_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE_OR_PROVINCE_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CITY_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADDRESS_LINE1` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADDRESS_LINE2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADDRESS_LINE3` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `POSTAL_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CONTACT_PHONE_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STO_ID` int(11) NULL DEFAULT NULL,
  `CARRIER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `STO_ID`(`STO_ID`) USING BTREE,
  CONSTRAINT `sha_shipping_address_ibfk_1` FOREIGN KEY (`STO_ID`) REFERENCES `sto_store_order` (`STO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sol_store_order_line_item
-- ----------------------------
DROP TABLE IF EXISTS `sol_store_order_line_item`;
CREATE TABLE `sol_store_order_line_item`  (
  `SOL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_ITEM_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STO_ID` int(11) NULL DEFAULT NULL,
  `SALES_PRICE` decimal(8, 2) NULL DEFAULT NULL,
  `QTY` int(11) NULL DEFAULT NULL,
  `SKU_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BUYER_CHECKOUT_MESSAGE` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`SOL_ID`) USING BTREE,
  INDEX `STO_ID`(`STO_ID`) USING BTREE,
  CONSTRAINT `sol_store_order_line_item_ibfk_1` FOREIGN KEY (`STO_ID`) REFERENCES `sto_store_order` (`STO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for spa_specific_attribute
-- ----------------------------
DROP TABLE IF EXISTS `spa_specific_attribute`;
CREATE TABLE `spa_specific_attribute`  (
  `SPA_ID` int(11) NOT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `NAME_EN` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEQ_NO` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SPA_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  CONSTRAINT `spa_specific_attribute_ibfk_1` FOREIGN KEY (`PRO_ID`) REFERENCES `pro_product` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for spv_specific_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `spv_specific_attribute_value`;
CREATE TABLE `spv_specific_attribute_value`  (
  `SPV_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SPA_ID` int(11) NULL DEFAULT NULL,
  `NAME_EN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SPV_ID`) USING BTREE,
  INDEX `SPA_ID`(`SPA_ID`) USING BTREE,
  CONSTRAINT `spv_specific_attribute_value_ibfk_1` FOREIGN KEY (`SPA_ID`) REFERENCES `spa_specific_attribute` (`SPA_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sto_store_order
-- ----------------------------
DROP TABLE IF EXISTS `sto_store_order`;
CREATE TABLE `sto_store_order`  (
  `STO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STR_ID` int(11) NULL DEFAULT NULL,
  `ORDER_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_CREATED_TIME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PAID_TIME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_MODIFIED_TIME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PLATEFORM_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CANCEL_COMPLETE_DATE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`STO_ID`) USING BTREE,
  INDEX `STR_ID`(`STR_ID`) USING BTREE,
  CONSTRAINT `sto_store_order_ibfk_1` FOREIGN KEY (`STR_ID`) REFERENCES `str_store` (`STR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for str_store
-- ----------------------------
DROP TABLE IF EXISTS `str_store`;
CREATE TABLE `str_store`  (
  `STR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `PLATAEFORM_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STORE_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STORE_STS_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`STR_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE,
  CONSTRAINT `str_store_ibfk_1` FOREIGN KEY (`DSR_ID`) REFERENCES `dsr_dropshipper` (`DSR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_andorra
-- ----------------------------
DROP TABLE IF EXISTS `sys_andorra`;
CREATE TABLE `sys_andorra`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addtime` datetime(0) NULL DEFAULT NULL,
  `uptime` datetime(0) NULL DEFAULT NULL,
  `starttime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tourl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `MENU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PARENT_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_ORDER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_ICON` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_TYPE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `USER_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USERNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `RIGHTS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ROLE_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_LOGIN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IP` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BZ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SKIN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NUMBER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PHONE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MAN_BUYER_ID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ull_user_login_logout_log
-- ----------------------------
DROP TABLE IF EXISTS `ull_user_login_logout_log`;
CREATE TABLE `ull_user_login_logout_log`  (
  `ULL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USI_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TOKEN` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TERMINAL_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATING_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATING_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ULL_ID`) USING BTREE,
  INDEX `USI_ID`(`USI_ID`) USING BTREE,
  CONSTRAINT `ull_user_login_logout_log_ibfk_1` FOREIGN KEY (`USI_ID`) REFERENCES `sys_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for waa_wallet_account
-- ----------------------------
DROP TABLE IF EXISTS `waa_wallet_account`;
CREATE TABLE `waa_wallet_account`  (
  `BUYER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ACTIVE_TIME` datetime(0) NULL DEFAULT NULL,
  `IS_ACTIVE` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` tinyint(2) NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp(0) NOT NULL,
  `ACCOUNT_TYPE` int(11) NULL DEFAULT NULL,
  `HOLD_ORDER_TIME` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `AUTO_PAY_STATUS` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`BUYER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for waf_wallet_account_fund
-- ----------------------------
DROP TABLE IF EXISTS `waf_wallet_account_fund`;
CREATE TABLE `waf_wallet_account_fund`  (
  `BUYER_ID` int(10) NULL DEFAULT NULL,
  `AVAILABLE_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `DEPOSITING_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `WITHDRAWING_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp(0) NOT NULL,
  `CURRENCY` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `BUYER_ID`(`BUYER_ID`) USING BTREE,
  CONSTRAINT `waf_wallet_account_fund_ibfk_1` FOREIGN KEY (`BUYER_ID`) REFERENCES `waa_wallet_account` (`BUYER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wit_wishlist
-- ----------------------------
DROP TABLE IF EXISTS `wit_wishlist`;
CREATE TABLE `wit_wishlist`  (
  `WIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NOT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`WIT_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  CONSTRAINT `wit_wishlist_ibfk_1` FOREIGN KEY (`DSR_ID`) REFERENCES `dsr_dropshipper` (`DSR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `wit_wishlist_ibfk_2` FOREIGN KEY (`PRO_ID`) REFERENCES `pro_product` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wta_wallet_transaction_aduit
-- ----------------------------
DROP TABLE IF EXISTS `wta_wallet_transaction_aduit`;
CREATE TABLE `wta_wallet_transaction_aduit`  (
  `TRANSACTION_AUDIT_ID` int(10) NOT NULL,
  `BUYER_ID` int(10) NULL DEFAULT NULL,
  `TRANSACTION_ID` int(10) NULL DEFAULT NULL,
  `AVAILABLE_MONEY_BEFORE` decimal(10, 4) NULL DEFAULT NULL,
  `DEPOSITING_MONEY_BEFORE` decimal(10, 4) NULL DEFAULT NULL,
  `WITHDRAWING_MONEY_BEFORE` decimal(10, 4) NULL DEFAULT NULL,
  `OPERATE_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `OPERATE_TYPE` tinyint(2) NULL DEFAULT NULL,
  `AVAILABLE_MONEY_AFTER` decimal(10, 4) NULL DEFAULT NULL,
  `DEPOSITING_MONEY_AFTER` decimal(10, 4) NULL DEFAULT NULL,
  `WITHDRAWING_MONEY_AFTER` decimal(10, 4) NULL DEFAULT NULL,
  `OPERATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` tinyint(2) NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp(0) NOT NULL,
  PRIMARY KEY (`TRANSACTION_AUDIT_ID`) USING BTREE,
  INDEX `BUYER_ID`(`BUYER_ID`) USING BTREE,
  CONSTRAINT `wta_wallet_transaction_aduit_ibfk_1` FOREIGN KEY (`BUYER_ID`) REFERENCES `waa_wallet_account` (`BUYER_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wtr_wallet_transaction_record
-- ----------------------------
DROP TABLE IF EXISTS `wtr_wallet_transaction_record`;
CREATE TABLE `wtr_wallet_transaction_record`  (
  `TRANSACTION_ID` int(10) NOT NULL AUTO_INCREMENT,
  `BUYER_ID` int(10) NULL DEFAULT NULL,
  `BANK_CARD_ID` int(10) NULL DEFAULT NULL,
  `TRANSACTION_NUMBER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANSACTION_TYPE` tinyint(2) NULL DEFAULT NULL,
  `ACCOUNT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANSACTION_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `DISCOUNT_COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `TRANSACTION_METHOD` tinyint(2) NULL DEFAULT NULL,
  `COMPLETE_TIME` datetime(0) NULL DEFAULT NULL,
  `STATUS` tinyint(2) NULL DEFAULT NULL,
  `ACTUAL_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `ACTUAL_COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `ACTUAL_DISCOUNT_COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `BALANCE` decimal(10, 4) NULL DEFAULT NULL,
  `BUSINESS_ID` int(10) NULL DEFAULT NULL,
  `FINANCE_TYPE` tinyint(2) NULL DEFAULT NULL,
  `NOTE` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATOR_NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATOR_IP` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp(0) NOT NULL,
  `BANK_RECEIPT_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXCHANGE_RATE` decimal(10, 4) NULL DEFAULT NULL,
  `TRANSACTION_DESC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FOREIGN_EXCHANGE_FEE` decimal(10, 4) NULL DEFAULT NULL,
  `WITHDRAW_FEE` decimal(10, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`TRANSACTION_ID`) USING BTREE,
  INDEX `BUYER_ID`(`BUYER_ID`) USING BTREE,
  CONSTRAINT `wtr_wallet_transaction_record_ibfk_1` FOREIGN KEY (`BUYER_ID`) REFERENCES `waa_wallet_account` (`BUYER_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
