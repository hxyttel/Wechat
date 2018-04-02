/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : badymall

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-02 11:48:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `pid` int(11) NOT NULL COMMENT '产品id',
  `ccount` int(11) NOT NULL DEFAULT '0' COMMENT '购物数量 默认为0',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '2', '3', '2');
INSERT INTO `cart` VALUES ('2', '2', '5', '1');
INSERT INTO `cart` VALUES ('3', '2', '2', '2');
INSERT INTO `cart` VALUES ('4', '2', '4', '1');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `ctid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户收藏id',
  `uid` int(11) NOT NULL COMMENT '用户uid',
  `pid` int(11) NOT NULL COMMENT '产品id',
  PRIMARY KEY (`ctid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `pname` varchar(10) DEFAULT NULL COMMENT '产品名',
  `pdescribe` varchar(30) DEFAULT NULL COMMENT '产品描述',
  `pcostprice` decimal(5,2) DEFAULT NULL COMMENT '产品原件',
  `psellprice` decimal(5,2) DEFAULT NULL COMMENT '产品销售价',
  `pcount` int(11) DEFAULT '0' COMMENT '产品销售量',
  `ptid` int(11) DEFAULT NULL COMMENT '产品类型id',
  `premark` varchar(150) DEFAULT NULL COMMENT '产品备注',
  `pvideo` varchar(500) DEFAULT NULL COMMENT '产品视频',
  `pstock` int(10) DEFAULT '0' COMMENT '产品库存',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '强生奶粉', '具有一款强吸收能力的高钙奶粉', '189.00', '89.00', '0', '9', '蜜蜂从植物的花中采取含水量约为75%的花蜜或分泌物，存入自己第二个胃中，在体内多种转化的作用下，经过15天左右反复酝酿各种维生素、矿物质和氨基酸丰富到一定的数值时，同时把花蜜中的多糖转变成人体可直接吸收的单糖葡萄糖、果糖，水分含量少于23%存贮到巢洞中，用蜂蜡密封。', 'http://www.w3school.com.cn//i/movie.mp4', '0');
INSERT INTO `product` VALUES ('2', '新生儿衣服套装', '纯棉，0-3个月婴儿', '289.00', '180.00', '0', '11', null, null, '0');
INSERT INTO `product` VALUES ('3', '口水巾', '纯色，纯棉小方巾', '20.00', '9.90', '0', '11', null, null, '0');
INSERT INTO `product` VALUES ('4', '卡通印花T恤童装卫衣', '韩版婴幼童长袖套头上衣', '80.80', '66.60', '0', '10', null, null, '0');
INSERT INTO `product` VALUES ('5', '脚踏键弹钢琴玩具', '开发智力和动手能力vbnmdf', '888.80', '535.50', '0', '11', null, null, '300');
INSERT INTO `product` VALUES ('6', '儿童时尚球鞋', '具有发光,轻便小白鞋', '99.90', '50.00', '0', '10', null, null, '0');
INSERT INTO `product` VALUES ('7', '哼儿米粉', '质地细腻 片状米粉 便利贴心', '65.50', '45.50', '0', '9', '蜜蜂从植物的花中采取含水量约为75%的花蜜或分泌物，存入自己第二个胃中，在体内多种转化的作用下，经过15天左右反复酝酿各种维生素、矿物质和氨基酸丰富到一定的数值时，同时把花蜜中的多糖转变成人体可直接吸收的单糖葡萄糖、果糖，水分含量少于23%存贮到巢洞中，用蜂蜡密封。', null, '0');
INSERT INTO `product` VALUES ('8', '婴童长耳朵兔子爬服', '连身衣,爬服,哈衣', '108.00', '88.00', '0', '9', null, null, '0');

-- ----------------------------
-- Table structure for productimg
-- ----------------------------
DROP TABLE IF EXISTS `productimg`;
CREATE TABLE `productimg` (
  `piid` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品图片id',
  `piurl` varchar(50) DEFAULT NULL COMMENT '图片路径',
  `pid` int(11) NOT NULL COMMENT '产品id',
  PRIMARY KEY (`piid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productimg
-- ----------------------------
INSERT INTO `productimg` VALUES ('1', 'http://localhost:8080/static/image/recoment3.jpg', '1');
INSERT INTO `productimg` VALUES ('2', 'http://localhost:8080/static/image/shop4.jpg', '2');
INSERT INTO `productimg` VALUES ('3', 'http://localhost:8080/static/image/shop5.jpg', '3');
INSERT INTO `productimg` VALUES ('4', 'http://localhost:8080/static/image/close1.jpg', '4');
INSERT INTO `productimg` VALUES ('5', 'http://localhost:8080/static/image/shop6.jpg', '5');
INSERT INTO `productimg` VALUES ('6', 'http://localhost:8080/static/image/shoot1.jpg', '6');
INSERT INTO `productimg` VALUES ('7', 'http://localhost:8080/static/image/recoment4.jpg', '7');
INSERT INTO `productimg` VALUES ('8', 'http://localhost:8080/static/image/recoment5.jpg', '8');

-- ----------------------------
-- Table structure for productype
-- ----------------------------
DROP TABLE IF EXISTS `productype`;
CREATE TABLE `productype` (
  `ptid` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品类型id',
  `ptname` varchar(10) NOT NULL COMMENT '产品类型',
  `ptUrl` varchar(100) NOT NULL COMMENT '产品icon',
  PRIMARY KEY (`ptid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productype
-- ----------------------------
INSERT INTO `productype` VALUES ('1', '奶粉', 'http://localhost:8080/static/image/mike2.jpg');
INSERT INTO `productype` VALUES ('2', '辅食营养', 'http://localhost:8080/static/image/food1.jpg');
INSERT INTO `productype` VALUES ('3', '尿裤纸片', 'http://localhost:8080/static/image/water1.jpg');
INSERT INTO `productype` VALUES ('4', '奶瓶配件', 'http://localhost:8080/static/image/shui1.jpg');
INSERT INTO `productype` VALUES ('5', '婴童用品', 'http://localhost:8080/static/image/icon_need.jpg');
INSERT INTO `productype` VALUES ('6', '孕妇用品', 'http://localhost:8080/static/image/icon_ma.jpg');
INSERT INTO `productype` VALUES ('7', '时尚童装', 'http://localhost:8080/static/image/Icon_weath.jpg');
INSERT INTO `productype` VALUES ('8', '玩具文体', 'http://localhost:8080/static/image/icon_play.jpg');
INSERT INTO `productype` VALUES ('9', '精品推荐', 'http://localhost:8080/static/image/mike1.jpg');
INSERT INTO `productype` VALUES ('10', '热销宝贝', 'http://localhost:8080/static/image/mike2.jpg');
INSERT INTO `productype` VALUES ('11', '新品上市', 'http://localhost:8080/static/image/mike2.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `unickname` varchar(20) NOT NULL COMMENT '用户昵称',
  `uname` varchar(10) DEFAULT NULL COMMENT '用户真实姓名',
  `usex` varchar(4) DEFAULT NULL COMMENT '用户性别',
  `uage` int(11) DEFAULT NULL COMMENT '用户年龄',
  `uarea` varchar(20) DEFAULT NULL COMMENT '用户所属地区',
  `uimg` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('3', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('4', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('5', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('6', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('7', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('8', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('9', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('10', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('11', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('12', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('13', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('14', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('15', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('16', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('17', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('18', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
INSERT INTO `user` VALUES ('19', 'hxy', 'hxy', '2', '20', 'China', 'https://wx.qlogo.cn/mmopen/vi_32/SQ2u1zj7crtNibhmibFM03Xrib9Ol1mXZ8bhOelCITgib6n6Zd3LBDzZTzM6Rfbo8ANibXibBribhMRnxsdeh5eq3Xdyw/0');
