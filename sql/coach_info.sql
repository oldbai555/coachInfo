/*
Navicat MySQL Data Transfer

Source Server         : docker_mysql
Source Server Version : 50732
Source Host           : 192.168.30.132:3306
Source Database       : coach_info

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-07 17:26:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');
INSERT INTO `admin` VALUES ('2', 'admin1', '123456');
INSERT INTO `admin` VALUES ('3', 'admin2', '123456');
INSERT INTO `admin` VALUES ('4', 'admin3', '123456');
INSERT INTO `admin` VALUES ('5', 'admin4', '123456');
INSERT INTO `admin` VALUES ('6', 'admin5', '123456');
INSERT INTO `admin` VALUES ('7', 'admin6', '123456');
INSERT INTO `admin` VALUES ('8', 'admin7', '123456');
INSERT INTO `admin` VALUES ('9', 'admin8', '123456');
INSERT INTO `admin` VALUES ('10', 'admin9', '123456');
INSERT INTO `admin` VALUES ('20', 'admin1好久没', '123456');

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `car_id` int(10) NOT NULL COMMENT '汽车型号，级联车种表,存车种表id',
  `route_start` varchar(255) NOT NULL COMMENT '起始点',
  `route_end` varchar(255) NOT NULL COMMENT '终点',
  `car_start_time` varchar(255) NOT NULL COMMENT '发车时间',
  `probably_time` double(10,1) unsigned zerofill NOT NULL COMMENT '预计行驶时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES ('1', '1', '柳州', '来宾', '8:00', '00000002.0');
INSERT INTO `car_info` VALUES ('2', '2', '柳州', '南宁', '8:10', '00000002.5');
INSERT INTO `car_info` VALUES ('3', '3', '柳州', '宾阳', '8:05', '00000002.5');
INSERT INTO `car_info` VALUES ('4', '4', '柳州', '桂林', '8:15', '00000002.0');
INSERT INTO `car_info` VALUES ('5', '5', '柳州', '惠州', '8:20', '00000008.0');
INSERT INTO `car_info` VALUES ('6', '6', '柳州', '广州', '8:30', '00000009.0');
INSERT INTO `car_info` VALUES ('7', '7', '柳州', '深圳', '8:25', '00000008.5');
INSERT INTO `car_info` VALUES ('8', '8', '柳州', '佛山', '8:35', '00000008.0');
INSERT INTO `car_info` VALUES ('9', '9', '柳州', '湛江', '9:00', '00000009.0');
INSERT INTO `car_info` VALUES ('10', '10', '柳州', '北海', '9:10', '00000010.0');
INSERT INTO `car_info` VALUES ('11', '11', '柳州', '徐州', '7:30', '00000020.0');
INSERT INTO `car_info` VALUES ('12', '12', '柳州', '钦州', '9:30', '00000005.0');
INSERT INTO `car_info` VALUES ('13', '13', '柳州', '西藏', '9:20', '00000009.5');
INSERT INTO `car_info` VALUES ('14', '14', '柳州', '新疆', '9:10', '00000015.5');
INSERT INTO `car_info` VALUES ('15', '15', '柳州', '北京', '9:50', '00000016.0');
INSERT INTO `car_info` VALUES ('16', '16', '柳州', '重庆', '9:01', '00000010.5');
INSERT INTO `car_info` VALUES ('21', '35', '柳州', '新加坡', '6:00', '00000025.0');
INSERT INTO `car_info` VALUES ('22', '36', '柳州', '旧加坡', '6:00', '00000025.0');

-- ----------------------------
-- Table structure for car_start_tab
-- ----------------------------
DROP TABLE IF EXISTS `car_start_tab`;
CREATE TABLE `car_start_tab` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `car_id` int(10) NOT NULL COMMENT '汽车型号,存车种表的Id',
  `actual_num` int(10) NOT NULL COMMENT '实际承载量',
  `start_time` datetime NOT NULL COMMENT '实际发车时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of car_start_tab
-- ----------------------------
INSERT INTO `car_start_tab` VALUES ('1', '1', '18', '2021-01-06 00:00:00');
INSERT INTO `car_start_tab` VALUES ('2', '2', '15', '2021-01-04 08:10:00');
INSERT INTO `car_start_tab` VALUES ('3', '3', '25', '2021-01-04 08:05:00');
INSERT INTO `car_start_tab` VALUES ('4', '4', '45', '2021-01-04 08:15:00');
INSERT INTO `car_start_tab` VALUES ('5', '5', '45', '2021-01-04 08:20:00');
INSERT INTO `car_start_tab` VALUES ('6', '6', '45', '2021-01-04 08:30:00');
INSERT INTO `car_start_tab` VALUES ('7', '7', '35', '2021-01-01 08:25:00');
INSERT INTO `car_start_tab` VALUES ('8', '8', '20', '2021-01-04 08:35:00');
INSERT INTO `car_start_tab` VALUES ('9', '9', '5', '2021-01-04 09:00:00');
INSERT INTO `car_start_tab` VALUES ('10', '10', '35', '2021-01-04 09:10:00');
INSERT INTO `car_start_tab` VALUES ('11', '11', '35', '2021-01-04 07:30:00');
INSERT INTO `car_start_tab` VALUES ('12', '12', '15', '2021-01-04 09:30:00');
INSERT INTO `car_start_tab` VALUES ('13', '13', '25', '2021-01-04 09:20:00');
INSERT INTO `car_start_tab` VALUES ('14', '14', '45', '2021-01-04 09:10:00');
INSERT INTO `car_start_tab` VALUES ('15', '15', '45', '2021-01-04 09:50:00');
INSERT INTO `car_start_tab` VALUES ('16', '16', '48', '2021-01-04 09:01:00');
INSERT INTO `car_start_tab` VALUES ('17', '2', '5', '2021-01-06 00:00:00');
INSERT INTO `car_start_tab` VALUES ('18', '2', '18', '2021-01-06 00:00:00');
INSERT INTO `car_start_tab` VALUES ('19', '1', '20', '2021-01-06 00:00:00');
INSERT INTO `car_start_tab` VALUES ('20', '1', '20', '2021-01-06 00:00:00');
INSERT INTO `car_start_tab` VALUES ('21', '35', '1', '2021-01-07 00:00:00');
INSERT INTO `car_start_tab` VALUES ('22', '35', '1', '2021-01-07 00:00:00');
INSERT INTO `car_start_tab` VALUES ('24', '1', '18', '2021-01-07 00:00:00');

-- ----------------------------
-- Table structure for car_ticket_info
-- ----------------------------
DROP TABLE IF EXISTS `car_ticket_info`;
CREATE TABLE `car_ticket_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `car_id` int(10) NOT NULL COMMENT '汽车型号，级联车种表',
  `ticket_name` varchar(255) NOT NULL COMMENT '车票名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_id` (`car_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of car_ticket_info
-- ----------------------------
INSERT INTO `car_ticket_info` VALUES ('1', '1', '柳来票');
INSERT INTO `car_ticket_info` VALUES ('2', '2', '柳南票');
INSERT INTO `car_ticket_info` VALUES ('3', '3', '柳宾票');
INSERT INTO `car_ticket_info` VALUES ('4', '4', '柳桂票');
INSERT INTO `car_ticket_info` VALUES ('5', '5', '柳惠票');
INSERT INTO `car_ticket_info` VALUES ('6', '6', '柳广票');
INSERT INTO `car_ticket_info` VALUES ('7', '7', '柳深票');
INSERT INTO `car_ticket_info` VALUES ('8', '8', '柳佛票');
INSERT INTO `car_ticket_info` VALUES ('9', '9', '柳湛票');
INSERT INTO `car_ticket_info` VALUES ('10', '10', '柳北票');
INSERT INTO `car_ticket_info` VALUES ('11', '11', '柳徐票');
INSERT INTO `car_ticket_info` VALUES ('12', '12', '柳钦票');
INSERT INTO `car_ticket_info` VALUES ('13', '13', '柳西票');
INSERT INTO `car_ticket_info` VALUES ('14', '14', '柳新票');
INSERT INTO `car_ticket_info` VALUES ('15', '15', '柳京票');
INSERT INTO `car_ticket_info` VALUES ('16', '16', '柳重票');
INSERT INTO `car_ticket_info` VALUES ('19', '35', '西八票');
INSERT INTO `car_ticket_info` VALUES ('20', '36', '西十票');

-- ----------------------------
-- Table structure for car_ticket_tab
-- ----------------------------
DROP TABLE IF EXISTS `car_ticket_tab`;
CREATE TABLE `car_ticket_tab` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ticket_info_id` int(10) NOT NULL COMMENT '车票信息，级联车票信息表,存 车票信息表id',
  `ticket_num` int(10) NOT NULL COMMENT '总票',
  `ticket_sum` int(10) NOT NULL DEFAULT '0' COMMENT '实际卖出',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of car_ticket_tab
-- ----------------------------
INSERT INTO `car_ticket_tab` VALUES ('1', '1', '20', '18');
INSERT INTO `car_ticket_tab` VALUES ('2', '2', '20', '16');
INSERT INTO `car_ticket_tab` VALUES ('3', '3', '30', '26');
INSERT INTO `car_ticket_tab` VALUES ('4', '4', '50', '46');
INSERT INTO `car_ticket_tab` VALUES ('5', '5', '50', '45');
INSERT INTO `car_ticket_tab` VALUES ('6', '6', '50', '30');
INSERT INTO `car_ticket_tab` VALUES ('7', '7', '35', '21');
INSERT INTO `car_ticket_tab` VALUES ('8', '8', '30', '21');
INSERT INTO `car_ticket_tab` VALUES ('9', '9', '25', '14');
INSERT INTO `car_ticket_tab` VALUES ('10', '10', '51', '45');
INSERT INTO `car_ticket_tab` VALUES ('11', '11', '60', '46');
INSERT INTO `car_ticket_tab` VALUES ('12', '12', '18', '17');
INSERT INTO `car_ticket_tab` VALUES ('13', '13', '25', '18');
INSERT INTO `car_ticket_tab` VALUES ('14', '14', '50', '32');
INSERT INTO `car_ticket_tab` VALUES ('15', '15', '50', '30');
INSERT INTO `car_ticket_tab` VALUES ('16', '16', '50', '38');
INSERT INTO `car_ticket_tab` VALUES ('18', '19', '21', '6');
INSERT INTO `car_ticket_tab` VALUES ('19', '20', '52', '1');

-- ----------------------------
-- Table structure for car_type
-- ----------------------------
DROP TABLE IF EXISTS `car_type`;
CREATE TABLE `car_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(255) NOT NULL COMMENT '车种名字',
  `people_num` int(10) NOT NULL,
  `license_plate` varchar(255) NOT NULL COMMENT '车牌号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `license_plate` (`license_plate`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of car_type
-- ----------------------------
INSERT INTO `car_type` VALUES ('1', '五菱之光', '22', '桂A-0000');
INSERT INTO `car_type` VALUES ('2', '五菱神光', '20', '桂A-0001');
INSERT INTO `car_type` VALUES ('3', '五菱荣光', '30', '桂A-0002');
INSERT INTO `car_type` VALUES ('4', '五菱发光', '50', '桂A-0003');
INSERT INTO `car_type` VALUES ('5', '霸龙重卡', '50', '桂A-0004');
INSERT INTO `car_type` VALUES ('6', '擎天柱', '50', '桂A-0005');
INSERT INTO `car_type` VALUES ('7', '大黄蜂', '35', '桂A-0006');
INSERT INTO `car_type` VALUES ('8', '红蜘蛛', '30', '桂A-0007');
INSERT INTO `car_type` VALUES ('9', '宝骏630', '5', '桂A-0008');
INSERT INTO `car_type` VALUES ('10', '五菱神车', '51', '桂A-0010');
INSERT INTO `car_type` VALUES ('11', '五菱魔改', '60', '桂A-0011');
INSERT INTO `car_type` VALUES ('12', '霸天虎', '18', '桂A-0012');
INSERT INTO `car_type` VALUES ('13', '威震天', '25', '桂A-0013');
INSERT INTO `car_type` VALUES ('14', '乘风大运', '50', '桂A-0014');
INSERT INTO `car_type` VALUES ('15', '大Q吧', '50', '桂A-0015');
INSERT INTO `car_type` VALUES ('16', '奔驰客运', '50', '桂A-0016');
INSERT INTO `car_type` VALUES ('17', '五菱发光', '50', '桂A-0017');
INSERT INTO `car_type` VALUES ('18', '大黄蜂', '35', '桂A-0018');
INSERT INTO `car_type` VALUES ('19', '红蜘蛛', '30', '桂A-0019');
INSERT INTO `car_type` VALUES ('20', '擎天柱', '50', '桂A-0020');
INSERT INTO `car_type` VALUES ('21', '奔驰客运', '50', '桂A-0021');
INSERT INTO `car_type` VALUES ('22', '大Q吧', '50', '桂A-0022');
INSERT INTO `car_type` VALUES ('23', '宝骏630', '5', '桂A-0023');
INSERT INTO `car_type` VALUES ('24', '霸龙重卡', '50', '桂A-0024');
INSERT INTO `car_type` VALUES ('25', '大黄蜂', '35', '桂A-0025');
INSERT INTO `car_type` VALUES ('26', '五菱魔改', '60', '桂A-0026');
INSERT INTO `car_type` VALUES ('27', '霸天虎', '18', '桂A-0027');
INSERT INTO `car_type` VALUES ('28', '乘风大运', '50', '桂A-0028');
INSERT INTO `car_type` VALUES ('29', '霸天虎', '18', '桂A-0029');
INSERT INTO `car_type` VALUES ('30', '威震天', '25', '桂A-0030');
INSERT INTO `car_type` VALUES ('35', 'mini大奔', '21', '桂B-0001');
INSERT INTO `car_type` VALUES ('36', 'mini小奔', '52', '桂B-0002');

-- ----------------------------
-- Table structure for flow_count
-- ----------------------------
DROP TABLE IF EXISTS `flow_count`;
CREATE TABLE `flow_count` (
  `id` int(11) NOT NULL,
  `flow` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of flow_count
-- ----------------------------
INSERT INTO `flow_count` VALUES ('1', '106');

-- ----------------------------
-- Table structure for sell_ticket_info
-- ----------------------------
DROP TABLE IF EXISTS `sell_ticket_info`;
CREATE TABLE `sell_ticket_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ticket_info_id` int(10) NOT NULL COMMENT '车票信息，级联车票信息表,写的是车票信息表的Id',
  `people_name` varchar(255) NOT NULL COMMENT '购买人姓名',
  `people_id_card` varchar(255) NOT NULL COMMENT '购买人身份证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `people_id_card` (`people_id_card`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sell_ticket_info
-- ----------------------------
INSERT INTO `sell_ticket_info` VALUES ('1', '1', '老白1号', '452226200001011234');
INSERT INTO `sell_ticket_info` VALUES ('2', '1', '老白2号', '452226200001011230');
INSERT INTO `sell_ticket_info` VALUES ('3', '1', 'bai001', '452226200001011231');
INSERT INTO `sell_ticket_info` VALUES ('4', '1', 'bai002', '452226200001011232');
INSERT INTO `sell_ticket_info` VALUES ('6', '1', 'bai004', '452226200001011235');
INSERT INTO `sell_ticket_info` VALUES ('7', '2', 'bai005', '452226200001011236');
INSERT INTO `sell_ticket_info` VALUES ('8', '1', 'bai006', '452226200001011237');
INSERT INTO `sell_ticket_info` VALUES ('9', '1', 'bai007', '452226200001011238');
INSERT INTO `sell_ticket_info` VALUES ('10', '1', 'bai008', '452226200001011239');
INSERT INTO `sell_ticket_info` VALUES ('11', '1', 'bai009', '452226200001011240');
INSERT INTO `sell_ticket_info` VALUES ('12', '1', 'bai010', '452226200001011241');
INSERT INTO `sell_ticket_info` VALUES ('13', '1', 'bai011', '452226200001011242');
INSERT INTO `sell_ticket_info` VALUES ('14', '1', 'bai012', '452226200001011243');
INSERT INTO `sell_ticket_info` VALUES ('15', '1', 'bai013', '452226200001011244');
INSERT INTO `sell_ticket_info` VALUES ('16', '1', 'bai014', '452226200001011245');
INSERT INTO `sell_ticket_info` VALUES ('17', '1', '王小明', '45222000100010001');
INSERT INTO `sell_ticket_info` VALUES ('20', '1', '王小明', '45222000100010002');
INSERT INTO `sell_ticket_info` VALUES ('21', '1', '王小明', '45222000100010003');
INSERT INTO `sell_ticket_info` VALUES ('22', '1', '王小明', '45222000100010004');
INSERT INTO `sell_ticket_info` VALUES ('23', '19', '王大明', '452226000000000001');
INSERT INTO `sell_ticket_info` VALUES ('29', '2', '大王', '452226000100020003');
INSERT INTO `sell_ticket_info` VALUES ('30', '20', '迷你小王', '452226000100020005');
