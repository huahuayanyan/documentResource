/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : flowsharp

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-04-12 14:03:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_approveroute_ins`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_approveroute_ins`;
CREATE TABLE `tbl_approveroute_ins` (
  `ID` varchar(32) NOT NULL,
  `MACHINE_ID` varchar(32) NOT NULL,
  `STATE_ID` varchar(32) NOT NULL,
  `ROUTE_ID` varchar(32) NOT NULL,
  `CUR_STOP_ID` varchar(32) DEFAULT NULL,
  `STATUS_CUR_STOP` varchar(255) DEFAULT NULL,
  `CUR_TASK_ID` varchar(32) DEFAULT NULL,
  `STOP_INDEX` int(11) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `START_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `END_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_approveroute_ins
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_approve_rel`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_approve_rel`;
CREATE TABLE `tbl_approve_rel` (
  `MODEL_ID` varchar(32) NOT NULL,
  `NODE_ID` varchar(32) NOT NULL,
  `FILTER_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`MODEL_ID`,`NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_approve_rel
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_assign_record`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_assign_record`;
CREATE TABLE `tbl_assign_record` (
  `ID` varchar(32) NOT NULL,
  `PROCESS_ID` varchar(32) DEFAULT NULL,
  `TASK_ID` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  `UNIT_ID` varchar(50) DEFAULT NULL,
  `ROLE_ID` varchar(50) DEFAULT NULL,
  `ASSIGNED_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_assign_record
-- ----------------------------
INSERT INTO `tbl_assign_record` VALUES ('005ff687fa494bbe934f39aacbca6af2', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0175a5e582c64aa7933b2af4cd7f2169', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('01b5c2ff44d74e70b17f24ce3f363243', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('02b95fda1f914c26b04afe44c39ce398', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('03d53ccc0f434caa84dec5ce26a13327', '760f1448e10e46b6b465524251decabc', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('03ff4dcf31ee4f068fe48e2e33e2a823', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('042e5b0f5d4f4255bc0f7993a5cf190b', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0438e87c142745cdabdc8c9a20baee06', '17f10f77dc654a5e861173544809f785', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('057eb9a811e246509410e7462f0b8d1b', 'f482de153db845c9b50a82faa3dcc75f', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('05820398e9df4fffacaf98b1e3ae9b7e', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0583f718300f49409032892186314a98', '36337f68b5e344c09874606a534c3dfe', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0697355965a741938a1796419d942020', 'a3bac09614d34203a94a823a8199fbbe', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0721043cabfa4e82b917dd6d27e40b59', 'f482de153db845c9b50a82faa3dcc75f', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0777e6f200414e63aafd7fadc8ae36eb', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('07a00eec026b43b39690ff6e60b20497', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('07a8302e1df9452f8fc278ef06d95af4', '17f10f77dc654a5e861173544809f785', 'node4', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('085af658a88f49b8b4f2bf01d6aec6cc', '17f10f77dc654a5e861173544809f785', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('086bfd5e6ac647e5aad15635363b3968', '36337f68b5e344c09874606a534c3dfe', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('08b515f8f81243beab298c386fade63b', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('09032f0e057d4022a66f7739ed796200', '760f1448e10e46b6b465524251decabc', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0915ef2d654448cb955ed063d88fc3de', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('09be32c9cd864bdf910ce7d8bf6cf460', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('09da9d40c26d4104b997561ec57c9b59', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0a2e87cc384a4463bbfbe9f863db442d', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0a4ef34cdf604d8f80c40c9b39e223e3', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0a5389ce28064916b17d2c52bc58e672', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0aa969cba05e4be8a9f24bb69ccc5ed0', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0bda55a28bf748c89d57c13b8e6671b0', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0bfed7b350e3439490d9343d50d9a4b7', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0c013cf052b74aa09d217e6aac9ee8c0', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0c602a29bfaf4ad3a011d1f1f615e8af', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0c9d37abd0f64cb08f37514f10810a3a', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0ca233e92ece4087960493d914b666de', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0cc9c670d8e54aaea90621e0444fd139', '17f10f77dc654a5e861173544809f785', 'node4', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0ebfd8b1c737404993be6b72aebabd73', 'cc4046beca514524820bf894794c6ff4', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0ec6ede8c8ee42729d75c4fbfbffc73a', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0f07dc2f0f7a4fefbca76523baf124e1', 'f482de153db845c9b50a82faa3dcc75f', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0fd173e6dff8416eacfa13394136cd89', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('0ff4da4bd92d4e16a55997e0501277fb', '17f10f77dc654a5e861173544809f785', 'node4', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('108f8ed798f3419d81193bd2fb6c9779', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1096b8897d3e490ebffcef1a0c14225e', '760f1448e10e46b6b465524251decabc', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1113f083c99142bfb85b72fa1999cf05', '36337f68b5e344c09874606a534c3dfe', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('11a271a7533f4d6eb9bd9262fde430ca', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('11df87443871413eb9be7feb3c2b9494', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('11dfba9893d8463f832559f6761e55da', '760f1448e10e46b6b465524251decabc', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('12758c94b26441779be46f7139067e88', '17f10f77dc654a5e861173544809f785', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('12cb272ba4754af281e7fe170c53a6d3', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('12d3e033db4f4f82b4d612753e681f31', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('13079a54f666429e82cf4be535f87039', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('13a3616648f044eeafcda7e76bae451b', '760f1448e10e46b6b465524251decabc', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('13c87c1349544f719fd038d0dc7b598c', 'cc4046beca514524820bf894794c6ff4', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1458fd0ceac74643a70651b89bfdcdc8', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1465107a9e0149658c06e96b910dbbf0', 'a3bac09614d34203a94a823a8199fbbe', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('146b428b918f4825868adf584400771e', 'a3bac09614d34203a94a823a8199fbbe', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1694abfb77584638874534174921eea4', '36337f68b5e344c09874606a534c3dfe', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('16e5be2f38e74fea8d1df611ea51c9c9', '36337f68b5e344c09874606a534c3dfe', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('17d2883628c7486f802cb380dd06f417', '17f10f77dc654a5e861173544809f785', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('17efa9c0946d4efb9033a66262ff7cb5', '36337f68b5e344c09874606a534c3dfe', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1888373555234a48920bba931aee2d53', 'f482de153db845c9b50a82faa3dcc75f', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1899c9e06f4648ea9bc1f723a46ed4ee', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('18d30672741445eb916a2adba3b4fc85', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('19408f929e1d45f6905310155e896963', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('198f1f631651442f9d192379df39d6df', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1a4b565f2c324651a8af737335c32d96', 'cc4046beca514524820bf894794c6ff4', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1a63a54032be4a5dbe50b9ae85755019', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1ac481dfedec460c830a8595e47646fd', 'cc4046beca514524820bf894794c6ff4', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1b076d04b6e94bb7be0baa5ebf4e9f89', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1b5f834dce40409286bb3fea39584a0d', 'cc4046beca514524820bf894794c6ff4', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1c1f329c310e4b618b20c89b97be144b', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1c8569213d80494c8f6b6e15995038a3', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1ce8146d077e4edf99da9d07c4207609', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1df031e7e0bf400cb3bc840d34c9417c', '98713ef0932544ff82e4be380495b48e', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1f2e6c9b7dbd4654b99f17474f20b747', 'a3bac09614d34203a94a823a8199fbbe', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('1f908ddef58147e6b6583d5f17369f56', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('204d094e60fb4271bf3778924b32c397', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('209905aa46254ef58198a9a0ac366ba8', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('209b6faebca646b8b2f09f94387b7086', '36337f68b5e344c09874606a534c3dfe', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('20ae4267ed30413b8555ab2669c11a1a', 'f482de153db845c9b50a82faa3dcc75f', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('21f0c3528abf42a987fd024fa70cd59a', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2217a8cd34c74f62ab573c898356dedf', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('238f620b98844cc392cb9e32e608d1e1', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('23dc5435099f4d7aa8eded2aa79f633f', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('242dbe14bcef429b8fca9bf50130944d', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('246d330d700a46c3808f06f0a7301e0c', 'a3bac09614d34203a94a823a8199fbbe', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('24ced79b0b8d4fef9880a4a2f8103b50', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2542b74d375a4416a08f8ef985a6afec', 'f482de153db845c9b50a82faa3dcc75f', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('255d0b91fb5b4d119ad1fe0032c25d72', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('25ff0704203745b982edb4b93a8d745f', '17f10f77dc654a5e861173544809f785', 'node4', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2651547f868d4cb3802bac95ab53d871', 'a3bac09614d34203a94a823a8199fbbe', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('268150fe0b874edbb407361d616ddf1d', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('27d300cbe522463ea6597773ed2565fb', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('28685bd4c18846c989bcd9e6120f707a', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('28d75bb9f9f74d13946b23d897843fce', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('298e6eeaebd34c848716f8febdb8dfdb', 'f482de153db845c9b50a82faa3dcc75f', 'node4', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('29a450d9538043e0aa25d819cc223ead', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('29ac300084d34d97babeaec0a656e2e3', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2a8e384032424b9588c8d7cb29e47168', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2ae06f4299004cd99b1a432e21b48047', '17f10f77dc654a5e861173544809f785', 'node4', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2bd81da5e4704fd79511298e26679211', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2be5f28dc2a0426591c6bffea4594923', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2c17b3e73e9d440980f2826bb8b9b8e0', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2c2a18d39526472d9d9c7a53048d4a90', '36337f68b5e344c09874606a534c3dfe', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2d506b56ae96444a95ae904e3cb19055', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2ddd544371454241a5b0ac15b86a1081', 'f482de153db845c9b50a82faa3dcc75f', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2dff98fd511b4472884f9dbb36307a19', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2e282cd7c1f742fc99fdbe7a5f0bb4a3', '17f10f77dc654a5e861173544809f785', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2e8a89fbb028450f999f480191ef550f', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2ea5983c335c49e3ba95c5be5b2958d3', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2eacb4ed99ec4fb3a8b9120fafdb63ff', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2f488a61e5694b809a19650796ef4c66', 'f482de153db845c9b50a82faa3dcc75f', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('2fd6e23d1a8746249f8e9fd095960b3d', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('30cb1478a824425583be0b1dde299360', 'a3bac09614d34203a94a823a8199fbbe', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('30d91a55c8484c14967ad02e0abc43c4', 'f482de153db845c9b50a82faa3dcc75f', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3116f045c51244e184551da561b63563', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', '88888888', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('320b2774e9e3464f80b9c936e1c90c37', 'cc4046beca514524820bf894794c6ff4', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('32208f5c0dab4064874af92192cc0a27', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('32de7c9fd4b145edb75950372e92ac4e', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('33992fa43f0b43b1a84255234664f86e', '17f10f77dc654a5e861173544809f785', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('33d4dc5b6ab24656bc6609a59dc959ad', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('340672cabfb04276ac5be69eafd233a4', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('340b51b8c8a144bdad9bc083e85210c9', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('34d5cefaa1194d73802c68a624a2fbe1', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('34e1467f236d43c39a207359089281c7', 'f482de153db845c9b50a82faa3dcc75f', 'node4', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('364cb166fda740aca255a2a60c293404', '760f1448e10e46b6b465524251decabc', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('365ed9008d0741cbb0ed7754e4d279c6', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3666c07e95364beaae8b3534767e7a7f', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', '88888888', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('36e00ee3f3ca4c1ca3b5e094d8defdeb', '760f1448e10e46b6b465524251decabc', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('373c0d3694b345009be9bb8e864b3b37', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('37717900ad9d4c42b455ff659e8d603a', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('389c5f1bb3884093b04bf35002596994', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('38b7ab42a000462ba00fa9899ae3e9b8', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3912865605c94d489eb12933b4719650', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3a2ab3558b644fc2bdc8af7fb0ee55e7', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3b1c3c7992eb4b9b9efa992e31954184', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3b64f9974175493880d3f3f7398555d3', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3c222d1845da4da482068e600b34239d', 'f482de153db845c9b50a82faa3dcc75f', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3c639a13ccba4720b3dad89d0404e9ad', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', '88888888', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3cc221ee1ea84a1ea3312bc413a6aa88', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3d0eb459d82b4884851353a8bcbe4a26', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3d2f56008b6d470ebad65933ad09c831', '36337f68b5e344c09874606a534c3dfe', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3d7dd1cb468642d2b5ca41c482b904ab', '98713ef0932544ff82e4be380495b48e', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3dba4e6241074ce1a5d3e328b26da9c0', '36337f68b5e344c09874606a534c3dfe', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3e44e54fa1f14dda9faa89b07af63a2e', '760f1448e10e46b6b465524251decabc', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3e56ca9d7e9547378cdf02ed25eb0fe5', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('3ef8b18bf6c44bfeb972af88f754aab3', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('405aa1beb4c445c4880c1ab260465d34', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('40921217bb89430e94e632dad37486d8', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4112bb1662c34026a7229e6b2a3d8378', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4199b838907040c4a9f7f46186019d40', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('41ab804b1f0a4925ade91658a795e179', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('41f6e853b899414dac88fd0d620dac16', '36337f68b5e344c09874606a534c3dfe', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4310ad7ba627453fa8c8d4c838ab9da9', 'a3bac09614d34203a94a823a8199fbbe', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4377e2ea7f8d4858878267046c069607', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('43ae8dd2f04a4f76aba5f54028ce4f49', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('43b3161ece174d0f9394acfb222f1898', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('43d584b79cef48be950d5979d7688403', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('43dbbb7ccf06414e8f76e37e0c39af60', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('44100d58877546d9936b3345cfb96bb3', 'cc4046beca514524820bf894794c6ff4', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('442a422a8b4041618954ac7ea4908664', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('450c3c0d4c1e4d05b881e83893ffca84', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('45e8b749445549f2973216c2e71d482f', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('468ce4f00eb44d62bfda99caae1b99b3', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('472d1e6a39e6401897a7dccaee4e047f', '98713ef0932544ff82e4be380495b48e', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('48677f9c0f2541bc9053d4391c7b69d2', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('492ad40d35b64b58a8c5a603b776fe80', '36337f68b5e344c09874606a534c3dfe', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('49802ea5c589489bbfa63534d7675960', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4a1ce090b84b462785eae7acdb31f85c', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4a581d1b08034f84be2e56363239706a', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4ab5ba71ae00485dbd868f5e403582d7', '760f1448e10e46b6b465524251decabc', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4ad18f401cd6448b8f3c2022157309a2', '17f10f77dc654a5e861173544809f785', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4cbceecaf1df4c7997649ddf57d47fcc', 'f482de153db845c9b50a82faa3dcc75f', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4d2fac47786443e4a9c0439fff209122', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4da120b72018462c9d0a7647c4fef351', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4ded247ae2d644d395aad29a91d79cda', '36337f68b5e344c09874606a534c3dfe', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4e22c872084b4b00bf74bc5c0450113a', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4ea88d23b5234dafb2a6203a85f83ac3', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4ef13d90596b48508f77e7d057fdfc70', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('4fcddba8ffc74ae99730f382603d5160', 'a3bac09614d34203a94a823a8199fbbe', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('506ffd20d4ed41ef90979b2d12a7b983', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('50d0a2fba6674000ab4ef30b12232933', '98713ef0932544ff82e4be380495b48e', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('511dd9df3255462683abc55b724ac7e9', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('512b0c6251ab4803a619019adff414e6', 'cc4046beca514524820bf894794c6ff4', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('51557f118bdd45ce90153550756475cd', 'cc4046beca514524820bf894794c6ff4', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5179b07257c142d38b8db50ebce4caf4', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('51c883c118bb4812bd77ff72ac863ffb', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('51d388d1b2ca4f1cbae29d2359c367b0', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('524b6d4535b6437ab365b4f5997f15f7', 'a3bac09614d34203a94a823a8199fbbe', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('52ab77192d00474f8e72875af011ac11', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('532b223e61bd4bb9b3c40aff02dc94d8', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('54ca2b247d09417985aa79b613852a54', '760f1448e10e46b6b465524251decabc', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5507157de74c42a9b2dc8625b8389aa9', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', '88888888', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5544fe31e24e494db9fd26d4b8baae7b', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5627196fb63547e588368ae7c37e91e9', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('56aa5e170d2a4e3eadb8326cfd9700e3', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('56cf9417b5ac405db6cdebe27971eff4', 'cc4046beca514524820bf894794c6ff4', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5704acfe2a2b424cabddbca607c7ef68', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('57659274bd454be7bf436f4388a71f72', '98713ef0932544ff82e4be380495b48e', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('577532c7b2dd4db1881f1b3f19cd1d33', 'f482de153db845c9b50a82faa3dcc75f', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('582a9b89eec4418893e868e0cc4059c9', '98713ef0932544ff82e4be380495b48e', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('58bfd1c5a0d34415a8fc57374673eac4', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5958c4ad35614977ba7a28dafece5647', 'cc4046beca514524820bf894794c6ff4', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5a4bd03812f640b481a1d6549cfca0cf', '36337f68b5e344c09874606a534c3dfe', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5ae2e49b9e1b4e1695628928d5d0282c', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5b130c8257024e96bd24523cbb95fae5', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5be3d2cd64e04eb09533a6b8c1a018a7', '17f10f77dc654a5e861173544809f785', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5c18b65686db4a56a45fb125a4be5a67', '17f10f77dc654a5e861173544809f785', 'node4', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5c927d5b100c4fb9b207280566e17fda', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5ca2a743f5ba4a8c923d6b5fbaacbc0d', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5d16c00c3825494ba003cab4d0b37570', 'f482de153db845c9b50a82faa3dcc75f', 'node4', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5d1edbbf5f0d4967b471916b800d16df', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5dacdeb694fd4ed09619de44ae621da3', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5e42904493744df3b3b9ef6511db1f9f', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5e5e6dbbe1dc4d798b97e97fb4c592ed', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5f470970d3d14d90bf1b846ee5a2142b', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('5f83d554977e49aa99de62b9c535d8dc', '98713ef0932544ff82e4be380495b48e', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('603b4433f2814b329f2fa1152b707a7d', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('60a049243bf54f97886cd5bb54cbc2ab', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('60bdb855b6654610882674114caae4f1', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('61024fb8457d4fabb52581fd9c1292f9', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('61f4d7c37db543d890df9972a790c518', '760f1448e10e46b6b465524251decabc', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('623ff32b6c144ba28f7c35ea0a3333e1', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('637f7200944a41be8e09be390a040d7b', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('63aac6430d47477d9f89659c4b145e66', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('640245cbfbbc45ecabd10943cb550e42', '98713ef0932544ff82e4be380495b48e', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('649b687ccd9940b1a4494ecd7523573e', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('64a5423cb8894e2e9476431976f7b39d', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('64f39177a6524e5e9ae49d95558fbe8f', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('659f70cb6a5f4fd4b368bcbdcb885a73', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('65b5ab04940b4f7b927f2019ac3fa29f', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6687723e70ab41598e0073790e4b525c', '17f10f77dc654a5e861173544809f785', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('682692fc949746dfb5c8336197e9777a', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6931580b748b4a2391cedbd22ed8a306', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('697fe2e81c2f43d58342db474d40b8b9', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6994eb148edc498591847e126fbbc695', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('69b6b360cbf546cbbec6a63217b09484', '17f10f77dc654a5e861173544809f785', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6a2032f4909946c69a74742db66ff9d7', '98713ef0932544ff82e4be380495b48e', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6ad8cd9e48f6457b900338d1097d1e7a', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6bcc7750f4984f8d85601763b6d76177', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6c39ac57108647b0b96360f6310ca6d2', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6c9b2114f6ff401bb599b2e6ebe80a0d', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6ceb2f9be6064aff81a0040776cfcff0', '760f1448e10e46b6b465524251decabc', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6d0e5756647f471dabff912fdc7114a8', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6d753932cdcd42ec8599b7e2fca7dece', '17f10f77dc654a5e861173544809f785', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6df04a1aa193467a9afaa13d1e17898e', '760f1448e10e46b6b465524251decabc', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6e0b7df7622f423ea0e6b9cea3575f13', 'f482de153db845c9b50a82faa3dcc75f', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6e26abea1819414b9d35d01ff4812d15', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6e2f5969a2c54cf3ad00fd36f3c05a0b', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6e7e82e5f541473b9f48b46217bfc24e', 'cc4046beca514524820bf894794c6ff4', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('6f205f9314ca48ccbe38335f9f9ee461', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('70270e2d8aa14aee9f4aff75a840a4fe', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7076e8001dde4380a5ecbcf8e2f9c917', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('70a9a12e49904920a27c022a28a07b0c', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('70c15642c68d49cdbb6c68fa687d11e0', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('70eb12feaf6d45bd905ecc64c41f54a2', '760f1448e10e46b6b465524251decabc', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('70f60705e30849b391497388b14bb4e5', '760f1448e10e46b6b465524251decabc', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('715372e64e0f49f3bf152c66d9e3185b', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('715649b438a4453d8c773e779a6e489c', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('71e0bb30e6084f83ac5f53ba5c122d91', '98713ef0932544ff82e4be380495b48e', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('733afdcf9c70484f8149e4b5c8ffda01', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', '88888888', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7485d215580547dfab8af0bd2cb066af', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('74914c8f471e4ed99ceac6b35595f655', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7587e0154edb4caa98f99d576c6f1077', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('762233956de54f51bec1160704eb37c2', 'cc4046beca514524820bf894794c6ff4', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('76464660729d45afab721f223788753d', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7816c2644f204d4f8011fc8ba53cecdf', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('787c3cb7f0b24e5fa928eae5cc79a002', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7938842ce3b045009f56d5111446b7aa', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7985dda83838496a9f8547806faa590e', 'f482de153db845c9b50a82faa3dcc75f', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('79c141762d4b4967977276b1e65af4b0', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7a68bfb9a9a64d5b808393db13e28a2d', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7a8b2dc022b54f499083a7a0a466e2cc', '36337f68b5e344c09874606a534c3dfe', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7abcc092ddd34ef5ac0b28d4411e3f83', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7adbf6746a00446b887969f00f0dbbc5', '17f10f77dc654a5e861173544809f785', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7aebc6aa5711493689a03f27a3cd3523', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7af7e31a0a5d47aaa52b8ca33265c537', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7b8be01504c44ffeb3e9b26c824ee269', '36337f68b5e344c09874606a534c3dfe', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7bffbc1c789c45eca4870ad29e93cd84', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7d51ed5e8421445ab6e1bb33b367ebd9', '98713ef0932544ff82e4be380495b48e', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7d55840a1f9841f9bf359c779da835d3', 'f482de153db845c9b50a82faa3dcc75f', 'node4', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('7e7a37a2f9ff4dd4875bb3969c2f7629', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('811216ec279a4d0f9bec3c2188accdf6', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('812d4a7fdeef4b67af5703dee8005b5c', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8189e572f6c74bde911847f02b9fd906', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('81a7c71868a64aaa804ac99645310ae9', '36337f68b5e344c09874606a534c3dfe', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('81db4cf1ba4b4d788a63feb198781c1c', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('822c90f757e3471ea408ec3fb0466aec', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('827087f700724ce0b78afdf73296559b', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('839432d7b461490486c2d083fb9ce629', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('840522bc178a45e48c665709f1aefc4d', 'f482de153db845c9b50a82faa3dcc75f', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8452f394730c40ba9cda4667a1cba6b9', 'f482de153db845c9b50a82faa3dcc75f', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('847911de470e4afba43dbdb37604387e', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('87e233b313ee46da94fad57b891f0f37', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('87ef365cec13440680c0337e36231471', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', '88888888', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('87efc00edab04602a7948a7aad3c17e8', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('88bc6e135d5040f28116ce45af590a75', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('88fef7787ab3480f8936a4673ad207b8', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('890ae643b9e44d0b9497ad7d77cf6aff', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('894a370eb9574616a722f63f5f514cf6', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('89a4883851e84d819812c3770d6b107e', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8a0ccf1f5bd04a1cbb304f8814d75ce1', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8a3388bb448648bfa2951152fca58521', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8ac411ce35404077b37dc18f751a11e1', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8adab0bb74824777bbe5bd8e4515ead9', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8b3c9cb74c09435e934b224309cddbe3', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8b7f49230cee4998af6c5da434f59643', '98713ef0932544ff82e4be380495b48e', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8ba24db13d914eb2acb5aa3621df90d5', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8bef71846f6647f5a6f2d58b34efac02', '17f10f77dc654a5e861173544809f785', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8c1dd521ce9747a3943ea6d512ef370b', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8d6618af848b4f6d9d2ebf6abfd292c2', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8d6e1b183a3e4c96ac13de4cd04c8deb', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8d94eea0eb254206acbac9da3a7c414e', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8e9ab932b7764ea586c671f246b632d4', 'a3bac09614d34203a94a823a8199fbbe', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8eba4c150ff6426082c523a24d1f4f6e', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8ebabcbe51ca47b78bab5c4e00936825', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8ebed0a1e24244edad829d06463cfc70', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8f573bd837334bcf9f52a0418ebb9791', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8f6e6e6a37c04702ad7b9772afea3813', '760f1448e10e46b6b465524251decabc', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8f8bb3c145234233b611ffe574250951', 'a3bac09614d34203a94a823a8199fbbe', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('8fc605cad94a48eb8645fa9c68d5d71a', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('904d249a28df4a2790cb3314a5d14d67', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', '88888888', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('907f0442bd38432f8357ccb465f67c93', '760f1448e10e46b6b465524251decabc', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('912c12694b964ba8895fcadecea9d84f', '17f10f77dc654a5e861173544809f785', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('913f7b80c5a34c3faa26013fd3248ae5', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('924f143772f9469abe125715aa9fb7da', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('92882e87cf244688b60e8ae773dd4570', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('94927c20cdc94e1fa3631408322708e8', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('94b8e0d8c1e3464cbe371e319a491a57', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('94b8f741c5f94dd5a4fa044841d6bed9', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('95087eb807f54560b2416eef08d19bdc', '98713ef0932544ff82e4be380495b48e', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('95d9c49132ff41cd888c3be6052fc5b5', 'f482de153db845c9b50a82faa3dcc75f', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9652c735dd154673bc3146c91d5c2525', '17f10f77dc654a5e861173544809f785', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9689cb0ae1674c239de291b2c60aca54', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9781fe28b12046a8bf40529d8dcf6390', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('97eaabc20cc64b22968335068f009822', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('989ebd2d67094dd4a24132b89a5bc31f', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('98f7ee1ea9ae4f1fa47d6742307fb3b4', '760f1448e10e46b6b465524251decabc', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('991fa70ea70f479882a340d2b90dd163', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('99ece9e105d548a587d1d72064ce7303', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9a7882f41b654046be9d8acf300d29cc', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9b3d3f23b57b4481943c79462ab6fdfb', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9bb54b06ebf24cdc9ccc2e017d3d4c22', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9c451ca502eb45948e49a758ad256c3a', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('9e3c77e7c18346b2a592bc869bc97ef4', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a010627ea42749dc9a4ab79d3ff8ce38', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a0fd01a2b1684e6b8b898b5f9d2d83bf', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a20959a2b64743b9b2ed9421b49ca222', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a2dd27dac983475e8c685f7bf119759c', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a2f06eae350746cc960d60c30b25b204', 'cc4046beca514524820bf894794c6ff4', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a340e82dec16476ab62dcbea413a3c3d', '98713ef0932544ff82e4be380495b48e', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a36ebdf789a54d92b988e05032589413', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a372a4d2e893492caeeb46c06f4d91c4', 'f482de153db845c9b50a82faa3dcc75f', 'node4', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a3b95f2411084b74967bba1554f4a2a8', 'cc4046beca514524820bf894794c6ff4', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a3d38dcff4e04a5d9db47ebe980df591', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a44854f471bb4b87b125e63b80e8eff0', 'f482de153db845c9b50a82faa3dcc75f', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a52dfd02e5764ce0b7c6a10789f77c47', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a5c8bf4b8e6d458fad58c3abae31714d', '36337f68b5e344c09874606a534c3dfe', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a638ceed3fb54e518d9443eaf0a66be8', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a6398aeadf8949928a571ca1d76a15e8', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a6d67118fe2e418680ed3644b37a8660', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a784fb844d1a440ea8d542975a87570c', 'a3bac09614d34203a94a823a8199fbbe', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a82ac5f8fb834171ad2fa41cb08100f2', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a98d436745a24ffb9a125319e6968886', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a9d7434a05bb4f0b97312f3f51271c5f', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('a9e09f4f62294b949705c492a4432ad0', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('aab10113af2241688d12a74dbc06ab28', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('aac70cb0876141ccbbf1990095a9da87', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ab89d678df0e443f99469392800ea716', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('aba45cc602104723bef29dad45d2eab8', '17f10f77dc654a5e861173544809f785', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ac46201e8eba4b81b3bc62fd5d1de9d7', '17f10f77dc654a5e861173544809f785', 'node4', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ac5aa075aeaf420a911a3252bab1b4ff', '36337f68b5e344c09874606a534c3dfe', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ac90889a47094dae86cabacff469712c', '36337f68b5e344c09874606a534c3dfe', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ad1a445f475c47a0b2c2006ded8bee2f', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ade692b22d064a4ba690a21fb129896a', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', '88888888', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ade72654529d4c368295994ce02a6f29', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ae29f86bd50f4c3a96deeddfb20efd5a', '69b37cbee8c645e7a4269ad4e062df91', 'bcrrduebillapp_approve', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('aeaeb5afd7954c93b58f106dfb31fccb', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('af5f242cc7aa4c8cb793d39913957032', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('afd67483242945b6be77a8d08f812c30', '17f10f77dc654a5e861173544809f785', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('afeed57425944d6bb96fe7efab7fe286', 'cc4046beca514524820bf894794c6ff4', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b048d77f435248698f81bbc328aa531c', '98713ef0932544ff82e4be380495b48e', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b07a6a31b69f40b5a2dc934ea44dd9c1', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b11713444a7c4012afb3f403c0752131', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b1195e3764fa466c97270f7f83da661f', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b16f95e69362481e92ffec3dc6b65dbe', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b2a2be3b22c74d879f672a94b9f35bab', '17f10f77dc654a5e861173544809f785', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b33c7e4c08d344108163780a04e5fa0d', '17f10f77dc654a5e861173544809f785', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b3a6f3593bde4ac3a25bbd9f8092867c', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b48ec6a4c71b4f90be0238e397ffe794', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b506be253b2f40e79163b6d819132704', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b5417e18732a496d8946c5f510cb644f', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b6e6e595abd041028ce571f1ed7f46f7', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b7381d52d7c1474fa6bd00ae8c022153', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b75d713b09c2449dba2426837c34236d', '760f1448e10e46b6b465524251decabc', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b7a3a60d34f1495791abaeed81091b75', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b7d716c23d7e411ea0986288cb415ba0', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b807ff49b6eb4a5fbd0f1df89bf5bd83', '98713ef0932544ff82e4be380495b48e', 'node3', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b8922aaa77664f1080f0e77df7c85d2b', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b94a649d42674d908a8a4aaca2714006', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('b9b0696cef1748b9a680df94f41b64b5', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ba0b2123580e4046b043776e9721f534', '760f1448e10e46b6b465524251decabc', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ba5dc0b37a0d4d09b4e7a6d4b1f76b17', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('badc6fc8ed1243c2af4725de9b94bf4d', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('baefff7a8b7344b4a3faa2bffc75ee7b', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bb204f15f4d34539bdfd9137a718c643', '760f1448e10e46b6b465524251decabc', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bbe49f5dda9a460daa81d061f94c2aa1', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bc02384853524b56ac58c6cc75742d8a', '760f1448e10e46b6b465524251decabc', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bc05b226c3ad4c04a7f3aa3a307b37b8', '98713ef0932544ff82e4be380495b48e', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bc0fae41a35a4848a226b0a078dea129', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bcc3a88a1f534a119deb9e94e1a33ffb', '36337f68b5e344c09874606a534c3dfe', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bd1b6a98b2f04389b55f6ecac3be6561', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('be6b1fe7e41e4aeaa164debbaa4c50ac', '98713ef0932544ff82e4be380495b48e', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('beef81423fdd4c2184637ce5b2c34090', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bf8fb2ec6f6c4f57aced04f7f970e664', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bfc3bae8e2b84ccea6163c2e799d3ded', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('bfe0758daaa6416cab9eed62098bad5c', 'a3bac09614d34203a94a823a8199fbbe', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c064bf42174746728a5566b2db194245', '98713ef0932544ff82e4be380495b48e', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c10b3c9692a442eb906fd050f473d7a6', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c11082f2a4fa4bbcba6810e4907184ea', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c296cb826b2c4560a7360e9dde3bde25', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c2b2bed4bd5f449595685e982a965d13', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c328da7df6474672908b44b021a910d7', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c375d2eafae54c07b90ef7513f09fd38', 'f482de153db845c9b50a82faa3dcc75f', 'node4', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c4bd2acd919e4764b0d7de9b25624c68', 'f482de153db845c9b50a82faa3dcc75f', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c573b7ad962f4c429b6ffd8b36f907c4', '17f10f77dc654a5e861173544809f785', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c677e3d020fa463682c679dba6745705', '17f10f77dc654a5e861173544809f785', 'node2', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c6bea3d613db4410ac75f81955928968', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c74db41541d04c90bd0b38072cf26be1', 'f482de153db845c9b50a82faa3dcc75f', 'node4', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c75ad1d006a4478597f4c3ecba091ace', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c7c0ae08de4b4ccfa656b78a0fd06201', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c84639f29a85478f858c12f90d25153c', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c88faeace96b438b9500a94b7d51beb6', 'a3bac09614d34203a94a823a8199fbbe', 'node1', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c8efccbbcd094a9c96cf2ababfa7cf41', 'f482de153db845c9b50a82faa3dcc75f', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c90eb9c15d47448fb147b9a097a911f1', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c97785cf7a9f4f7681605a3e27325b07', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c99a4465b4dc4ee7a95cc610f6304543', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c9a4e3fb153d41b591c3ce8b24481e60', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('c9d317c3e0ca418795e1621b71732966', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cab1ea2e665f4325b8195fdcb3cd6aa2', '17f10f77dc654a5e861173544809f785', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cb4f0331a9024c6f920d6cbb1b95b6f4', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cb7bb5e097544ad286ed6481bdc9b339', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cb8ce4b62ea74820bff1e3d978a59d66', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cbc02aee56234a6a9d5f258b0db0ceeb', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cc2f50201e8f474c8d01e26a68e48511', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', '88888888', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cc4397ef26ec4549913b66b8d1bcee9d', '36337f68b5e344c09874606a534c3dfe', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cc5c49b36bde4c18aac6963edf2a50b4', 'cc4046beca514524820bf894794c6ff4', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cc8625ae4dca4261886d95321cb60e01', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cd64d2cf8d8640fa870835bb9d994375', 'f482de153db845c9b50a82faa3dcc75f', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cde5b03310474fe2bb29bd074e4576ae', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', '88888888', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cdf7f8d4678f46f0be86d12280fcf6dd', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cea1f6a4425d49c9ac74e465f6494e39', '17f10f77dc654a5e861173544809f785', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ceb69ea728ba47f1ad17dd48af69cfb8', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cedeaac68d2841b18b31e6ff60abb1cc', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('cf60731704784fec8cd2304b3673d39c', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d065d99683244899a41a3cceb1b8fc9f', 'cc4046beca514524820bf894794c6ff4', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d0d0143825834476949132ee2d7f65a3', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d11c6b58f44e4fd7bdf7271763a8e6d4', 'cc4046beca514524820bf894794c6ff4', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d161ba9b3e114bbe97040f4fb63017de', 'cc4046beca514524820bf894794c6ff4', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d1cf71285f7046feb40e0791a9fe9de6', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d289b7dea1864384a5c740f1fefd6b61', 'a3bac09614d34203a94a823a8199fbbe', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d3a6f0f5106846ef968d7c2a6dbebe1b', '98713ef0932544ff82e4be380495b48e', 'node2', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d3d82c876ac34281b865e3d663c7bcc3', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d48610eddddf405594521c0234408a0c', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d4b97537563741098ae513f3951aed2b', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d4fb29fd48554bfab8ce91946d0b2887', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d51d538a6c384c328b32dca9f14c7b68', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d5b3bd1199364c7c9fbcd324b256cd4b', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d68790cd36cc45f58810122e4e2b6ef2', '17f10f77dc654a5e861173544809f785', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d6bfcca2a01d43b0b07e690660a5be8d', 'cc4046beca514524820bf894794c6ff4', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d73e1a7df83944ac952a80830f478e9e', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d7b8661f7bf04f8b9037e41f18361418', 'a3bac09614d34203a94a823a8199fbbe', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d7b9e22870d24c04979888adf05082f5', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d7cbe9401ba04cd8b8f64d667fb1eb23', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d7d106a046914d06ac0868e95bf4c10b', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d7ee46a237704c3c8c4358d57c0ea75b', '98713ef0932544ff82e4be380495b48e', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d82d5e90ca4347269c75e226cadce04c', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d8bb151537e54c84a1e270c15f94c145', '760f1448e10e46b6b465524251decabc', 'node3', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d8cfa6533309484ab816281c9c1b665a', '760f1448e10e46b6b465524251decabc', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d9a1ea2a921041e087997691a6828536', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('d9a409e22ef5478d84f2b73f44076680', '36337f68b5e344c09874606a534c3dfe', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('da0583127c3e47c8a3a2ad02140a4146', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('da4b8da494414aaba4b5abeb93b7eb5d', 'f482de153db845c9b50a82faa3dcc75f', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('da5d33e9db5048f587130709501a1b6e', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dad07140007c45c0b2bcdcf400f51f3d', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dad724f542894a6b81abf39b8ac3ee4a', '36337f68b5e344c09874606a534c3dfe', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('daeea76179aa45f988c25c102fbdb94c', 'fc8c0641be904bbc9951f37a0bed9502', 'bcrrduebillapp_approve', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dafc395ec2c04c5586429556693d42a1', 'a3bac09614d34203a94a823a8199fbbe', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dbb512a16642474cba92ea5efe238f6d', 'afcd6d37e22e4f52800473bc42920fc4', 'node3', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dc4519309b944bfeb0f0a54cbf8debbc', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dc9a972b0bb74403b86155fc20b5688b', 'f482de153db845c9b50a82faa3dcc75f', 'node4', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dd034698d95d45649a7114c54b450ec2', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dd56559176c945a18addb017c7951122', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove2_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dd7bec2a3f7548cbb3f3be864799a3a1', 'cc4046beca514524820bf894794c6ff4', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('dde3a4c7af71448ea997e5a1e940979b', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('de4334c6f0704df4846a6e8991aafa14', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('de7583aa1ee046538b5f35e4bac2ee77', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('df830dded17a456bb543ad701f320bc0', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('df8316e895a645ea8329f86b160dd3dd', 'cc4046beca514524820bf894794c6ff4', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e0bb6ca3d6db41158764023af9a3da9c', '4d2a4ed671eb408cb6d0cda925489d89', 'node1', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e0bcc15451324048a169b40cab8a5616', 'cc4046beca514524820bf894794c6ff4', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e28fec9607984a8c8985870caa1f146b', '98713ef0932544ff82e4be380495b48e', 'node1', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e42998a7bf8a4470bb32f67df29c11d0', '4d2a4ed671eb408cb6d0cda925489d89', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e45e4601c43944ad96d60b4603747509', '02093a6020734a60acf331ca7744a094', 'LnAppApprove_task', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e4bd013a2173487aaab675284301ff12', '98713ef0932544ff82e4be380495b48e', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e5739e44315c4070a15cb97213f479b8', '17f10f77dc654a5e861173544809f785', 'node2', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e654d3ffe4404c768a83356399fadbd2', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e68a4a1fb14d488ebcc581c11a82c78a', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e70805d566b7444a83b37f199847adb2', 'f482de153db845c9b50a82faa3dcc75f', 'node4', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e75bc648c9c1414284e4797dd4d8c939', '98713ef0932544ff82e4be380495b48e', 'node1', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e75cc3a9bcbb48d68b20ab11fbc6880f', 'f482de153db845c9b50a82faa3dcc75f', 'node2', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e7ffb1eca94345fe82ebe165523858cb', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e8083e53b4184a34acc9c9a208569710', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e81b51bb12b14d25a0c558f51b2ff74b', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e8b41dcc94814dcdb7a5c65215864a03', '98713ef0932544ff82e4be380495b48e', 'node1', 'caimin01', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e91edce0a8d04a32bc864fb18ae9bece', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e96d231ac0e740b4917c3af8f291a455', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', '003', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('e9e259610f854f61b6111c473f453914', 'f482de153db845c9b50a82faa3dcc75f', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ea155968a22b4431a2030a5d1fc29305', 'd10b904cef0d4e95953481e73086cf03', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ea5553ee8ac5471aa1b256488652d79e', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ea6182fdebd24331b12429b6f8e142a1', '98713ef0932544ff82e4be380495b48e', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ebfadf3bc9df414eb3b21a0a0e772c36', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ec4ff04c86ec4ae0a8fe3647d0c2d28e', '4d2a4ed671eb408cb6d0cda925489d89', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ec8c3967fab74c0da1131f97cd1ce820', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ece8b2133ed2439dacc8e0b2b03e99d0', '3a8a3da8e08249459f573f5115d00355', 'LnAppApprove_task', '004', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('edb6d922ce1a477f958224f763cc0207', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ee9d010ef6594c9bb3b9d39d765016ee', '02093a6020734a60acf331ca7744a094', 'LnAppApprove1_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ef02198ef7894f88928df2adea83a960', 'f482de153db845c9b50a82faa3dcc75f', 'node2', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f06f78d03fe84e8198105ed54802ebfe', '36337f68b5e344c09874606a534c3dfe', 'node1', '001', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f0a71b655cc14191877430f83c0a3dd6', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f1523cffcd34439bb9b773c97a0a2b48', '36337f68b5e344c09874606a534c3dfe', 'node3', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f22d01c82f1843099d2da2acc0c8894f', 'f482de153db845c9b50a82faa3dcc75f', 'node3', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f2ac243d4ef648a5bcc705c752758101', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', 'wbz', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f2e1718ba2804b34b0a899b76f32853f', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask02', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f35ce93f7d754cc3b3bc43bae9689d8e', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f39c984027ec4826bffa50d9375e96cf', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f50a7fe6fe474a719331df03c1842b06', 'afcd6d37e22e4f52800473bc42920fc4', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f5178403e07e4796b5238672ed3f16ef', '17f10f77dc654a5e861173544809f785', 'node4', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f5946bc18a9c4fe5b3ce365008bb17b0', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove_task', 'wbz', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f63910e0bf56463c889f17906a742afe', '0d6e979355134535a05b535f77af7d10', 'creditEvalTask01', 'caimin02', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f645ef7773084b9aa724d4cbc8e020aa', 'ead450d1c1414cdf9c9aee379e79376f', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f6de4f9455914febbced1321f024a6b3', '17f10f77dc654a5e861173544809f785', 'node2', '002', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f7b76639dfa041d49b041ca1a23c4763', '98713ef0932544ff82e4be380495b48e', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f7df4a8da14d4531b00d2c7102545e99', '7c75d849c51f448b832977fcb4d92b35', 'LnAppApprove2_task', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f8e2b56ec9ce460bb4d01a5d83ec4eed', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask01', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f9a28a61cf68419fa13b9e53eb72601d', '36337f68b5e344c09874606a534c3dfe', 'node3', 'WBZ', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('f9f085954ce343f9a816f5ac53ef6806', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove1_task', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fa63f9aea12c4298a52c2178ef52e052', 'cc4046beca514524820bf894794c6ff4', 'node2', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fa6f0985cb9f4f6aa462d9c679bf49b5', 'cc4046beca514524820bf894794c6ff4', 'node2', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fae7880b75ff46108bb65347091c2175', '17f10f77dc654a5e861173544809f785', 'node1', '008', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fb6f27c3837344ea9655382d4510a978', '760f1448e10e46b6b465524251decabc', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fb8074e9f6d54702b0113ef720d7935d', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fbafdd0b28714c5ab6040bbf60bbecdd', 'f482de153db845c9b50a82faa3dcc75f', 'node3', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fbed1475ae9146ffa4439571575ee49d', '02093a6020734a60acf331ca7744a094', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fc41e04fad694ed58f074ce58d32026a', 'afcd6d37e22e4f52800473bc42920fc4', 'node2', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fcb3bd75457c42bf9d97e661a7b5d4aa', '0f887815d80647178bfd919b83aab4c9', 'creditEvalTask02', 'caimin01', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fcf6c692705042cb9c3a5fa6666420da', '760f1448e10e46b6b465524251decabc', 'node3', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fcf96517c77740608130c72498e445e3', '8fd551c534ed414f9f013baf9042cef3', 'LnAppApprove1_task', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fd02d8800d5142e78cfaff902e7704a5', '789e55480adc460fabe7451abb90362e', 'LnAppApprove1_task', '004', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fd19101fd1ea4ba1a270da821b366c82', '789e55480adc460fabe7451abb90362e', 'LnAppApprove_task', 'WBZ', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fd502c9b6f404f08a64979dd197c581d', '789e55480adc460fabe7451abb90362e', 'LnAppApprove2_task', '003', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fda0e72c0a8840a7bc2ce58a48f0bd9b', 'cc4046beca514524820bf894794c6ff4', 'node3', '001', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('fdc9b3776d1e41da9e194eb170633c5f', '17f10f77dc654a5e861173544809f785', 'node4', 'caimin02', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ff23d6d4aa5f4734a74f8c2240411749', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnAppApprove_task', '002', '', '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ff56f87f01fd4824a80a10f17de08510', '515ccab46c4e4d1fb1928fd7334e6426', 'LnAppApprove2_task', '008', null, '', '1');
INSERT INTO `tbl_assign_record` VALUES ('ffe69d89a0e64f098f82c04a84e8949c', '760f1448e10e46b6b465524251decabc', 'node2', '001', null, '', '1');

-- ----------------------------
-- Table structure for `tbl_biz_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_biz_mapping`;
CREATE TABLE `tbl_biz_mapping` (
  `ID` varchar(32) NOT NULL,
  `PROCESS_ID` varchar(32) DEFAULT NULL,
  `NODE_ID` varchar(32) DEFAULT NULL,
  `TASK_ID` varchar(32) DEFAULT NULL,
  `TASK_STATU` int(11) DEFAULT NULL,
  `CREATE_TIME` varchar(255) DEFAULT NULL,
  `NAME1` varchar(32) DEFAULT NULL,
  `NAME2` varchar(32) DEFAULT NULL,
  `NAME3` varchar(32) DEFAULT NULL,
  `NAME4` varchar(32) DEFAULT NULL,
  `NAME5` varchar(32) DEFAULT NULL,
  `NAME6` varchar(32) DEFAULT NULL,
  `NAME7` varchar(32) DEFAULT NULL,
  `NAME8` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_biz_mapping
-- ----------------------------
INSERT INTO `tbl_biz_mapping` VALUES ('00bc5da2e0384d828349623e977f58fa', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-19 10:45:33', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('01bcc833af9f4147aab9f847163a567c', '69b37cbee8c645e7a4269ad4e062df91', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '0', '2018-04-03 13:49:32', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0202de4525044d4690c601a0d755733c', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-04-04 16:07:45', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0206f7af9c2841b286345d50589198f1', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node1', 'node1', '2', '2018-03-19 10:25:58', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('03f7aaf74efc4d65b8115967f021bb86', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-04-04 15:13:34', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', 'null', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0526cc5e68cb450cb0794c32b5a8eba8', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve2', 'null', '0', '2018-03-16 10:54:18', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('073d07bb06e74777a452df966d4feeb8', '98713ef0932544ff82e4be380495b48e', 'dcr_node3', 'node3', '0', '2018-03-14 16:51:03', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('079fce2daac548878dbe5d0bb52af01b', '69b37cbee8c645e7a4269ad4e062df91', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '1', '2018-04-03 13:49:31', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('07ea26afc7814a36a89bbdadf686df4b', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node1', 'node1', '1', '2018-03-19 10:25:58', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('084ab2003e294e83a10543eb3bf69fd4', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node1', 'node1', '1', '2018-03-21 14:28:49', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('08e42f7aa70d47afaf4d585b9f1a56ae', '02093a6020734a60acf331ca7744a094', 'LnApp_approve2', 'null', '0', '2018-03-07 13:38:59', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0958432e0aeb4042a9b1b0d6981713e2', '36337f68b5e344c09874606a534c3dfe', 'dcr_node1', 'node1', '0', '2018-03-21 19:48:49', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0a4e4d8b275b4b45a07265d487dbad7f', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-04-04 16:10:09', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0a60d8842f194b56bbba30e19613b333', '6edcce62aeb0406b982ea32a7b12a044', 'Approve', 'Approve_task', '0', '2018-03-05 13:52:48', 'FCNT2018030500000104', 'C20180305000304', '88888888-5', 'FactoringContApply', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0b54f4fa1919477090dbed74bd86f4de', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node2', 'null', '0', '2018-03-21 14:28:49', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0b704830a43245259e80d523bbd2cb29', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node2', 'null', '0', '2018-03-06 15:02:10', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0c22a746e5fb44e4bc42d368e9d23f99', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve1', 'null', '0', '2018-03-06 20:46:26', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0d007d88b6844e95b4cecd630646028b', '02093a6020734a60acf331ca7744a094', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-07 13:39:18', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0f07648436144bbdbb1d457b2cf43d24', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node3', 'node3', '0', '2018-03-21 14:29:04', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0f83277254024d77824ff383d0d037b8', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode1', 'null', '0', '2018-04-02 15:05:47', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('0f937c42ad194bd6a715210c939b3ca8', '36337f68b5e344c09874606a534c3dfe', 'dcr_node2', 'node2', '0', '2018-03-21 19:49:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('1184887adf2544a4b122f9520e0232c0', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node4', 'node4', '0', '2018-03-19 10:26:20', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('11fd8a41ab504ae58cbdfee0feeae235', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-16 10:54:27', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('12a36ed16f124caa978d413b7f49fba2', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node3', 'node3', '1', '2018-03-14 13:28:40', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('149f8ffc2328447bbd7f22c4dbc3cce0', '928807fda9254fae9cf1d3c7c6e524d2', 'credictEvalNode1', 'creditEvalTask01', '0', '2018-04-02 14:53:16', 'XYPJ201804020000002', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('151a0a0eaf89482483b6a6014e87bd82', '5dc5f596fb9d496ca5a192d838a80fb8', 'credictEvalNode1', 'null', '0', '2018-04-02 14:53:14', 'XYPJ201803310000001', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('159b77d6d81d487e94fd0f1b3286d016', 'cc4046beca514524820bf894794c6ff4', 'pass', 'null', '0', '2018-03-27 09:43:17', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('162145b113964f61a6db34e4be2df931', '02093a6020734a60acf331ca7744a094', 'LnApp_approve', 'null', '0', '2018-03-07 13:36:53', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('162e291cd6ed4540a64ac1546032deb2', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-14 15:10:17', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('172d8892b9fc4b469ffb4bddb072b21f', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve1', 'null', '0', '2018-03-17 14:01:11', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('18bcf926159943918ebefc3afba1909b', '17f10f77dc654a5e861173544809f785', 'pass', 'null', '0', '2018-03-05 19:48:29', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('1a89398e488d482992894b586a21d509', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode2', 'creditEvalTask02', '2', '2018-04-03 17:59:12', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('1c0916f7d9134f4e867fe41822a003ff', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-21 16:33:17', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('1ed58bcd139a48e8a2893732f286b849', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-19 10:45:56', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('1ee5bd83bae2498cbbd74d787ce1e0c6', '17f10f77dc654a5e861173544809f785', 'dcr_node1', 'node1', '2', '2018-03-05 19:40:48', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('1ff6045951334b219937a76beb13686c', '36337f68b5e344c09874606a534c3dfe', 'dcr_node1', 'node1', '2', '2018-03-21 19:49:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('202ab53ac80344a2915778194b6299d0', '990bf1563c6b495e83385d233e57a087', 'credictEvalNode1', 'null', '0', '2018-03-19 17:05:09', '1C8U518GA000A441370A0000D24B18CD', '1001', 'test00', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('20a7e9c39bb1456eb2a70db502b1c972', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-04-04 16:09:42', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', 'null', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('230018f9ea974deaacca9d6484280078', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode1', 'creditEvalTask01', '1', '2018-04-02 15:10:05', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('23844a4d43df47d696cc9b53ad5dda26', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-06 20:46:36', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2481a8d2697b4b2b9f6237da7a33e388', '760f1448e10e46b6b465524251decabc', 'dcr_node3', 'node3', '2', '2018-03-14 17:07:27', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('25df66b859e8494daa223b41e4f32d79', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-17 14:01:18', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('26d771ed7ea34e9c8eb1ebf478e3332e', 'ead450d1c1414cdf9c9aee379e79376f', 'pass', 'null', '0', '2018-03-06 20:46:47', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2747a4de8b134fda8d78bcc3caf4634c', '02093a6020734a60acf331ca7744a094', 'pass', 'null', '0', '2018-03-07 13:39:18', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('284ae0ccd2444f8497667c2d5009ed90', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node2', 'node2', '1', '2018-03-12 17:14:19', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2892c14c4fb54e43a3462002b5c10edc', '36337f68b5e344c09874606a534c3dfe', 'dcr_node2', 'node2', '2', '2018-03-21 19:49:58', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('28ccdea31f6240518d952f440b48dbb5', '17f10f77dc654a5e861173544809f785', 'dcr_node4', 'node4', '0', '2018-03-05 19:48:10', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('28dc5c8df68b4a2b8fe2bec40a00e6ec', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-17 14:01:11', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('290d12af36dd48c7be01ff2f032487cf', '789e55480adc460fabe7451abb90362e', 'LnApp_approve2', 'null', '0', '2018-03-05 11:24:39', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('293d080f56da422ab0b60a9b584c75dc', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode2', 'creditEvalTask02', '1', '2018-04-03 17:59:11', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('295c4a68736645e29bd92951c8059651', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-21 16:33:42', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2abd0701f8e84ed8be939bfd7162aff4', '760f1448e10e46b6b465524251decabc', 'dcr_node3', 'node3', '1', '2018-03-14 17:07:27', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2d16c3d042f0489a9ce44c5485dfc2b9', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-19 10:45:41', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2d204d06c56c4756b93c6f3d43d8bc7c', '990bf1563c6b495e83385d233e57a087', 'credictEvalNode1', 'creditEvalTask01', '0', '2018-03-19 17:05:09', '1C8U518GA000A441370A0000D24B18CD', '1001', 'test00', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2d72d4060b274e33833de079aaab5df3', '17f10f77dc654a5e861173544809f785', 'dcr_node2', 'null', '0', '2018-03-05 19:40:48', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2e325535f60c40adae3b65aa75ff2138', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode1', 'creditEvalTask01', '2', '2018-04-02 15:10:06', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('2ff159cba314425e951852b4a555a199', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve', 'null', '0', '2018-04-04 16:09:42', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', 'null', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('33713da1f8de46419e5f0f7393470ce8', '02093a6020734a60acf331ca7744a094', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-07 13:38:59', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3380fcd359e740cd87c4cfff463ba6bd', '789e55480adc460fabe7451abb90362e', 'LnApp_approve1', 'null', '0', '2018-03-05 11:24:29', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('35663734473e4e108c6f9f647ad2c847', 'fc8c0641be904bbc9951f37a0bed9502', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '2', '2018-04-03 14:10:06', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('365021709f9143c98f1d4d8c021882e0', '558f4088198a43518fa36e304cbda1e8', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '0', '2018-04-03 13:32:25', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'DG', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('36c72c51088c41f2a43176ce6f3b3fec', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve1', 'null', '0', '2018-03-21 16:33:17', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('38082212d82d40e79ebc83d4f146446f', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node1', 'null', '0', '2018-03-19 10:25:44', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('38c3b037718b4e3897c40d1e6d10fcc6', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node2', 'node2', '1', '2018-03-21 14:29:04', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('38ddb08e7b2d42f68ac41197bc78e7e6', '36337f68b5e344c09874606a534c3dfe', 'dcr_node3', 'node3', '2', '2018-03-21 19:50:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3a6790e6eadf43ecad7c7df8d7fdeb18', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-06 20:46:26', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3a6a78ad2a164bb2b48262832150436d', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve2', 'null', '0', '2018-03-17 14:01:18', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3b74465277434c759cbae844aa35d386', '760f1448e10e46b6b465524251decabc', 'dcr_node2', 'null', '0', '2018-03-14 17:06:59', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3bdd7fa64d4c4d7b86aab165dbfbdeea', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve', 'null', '0', '2018-03-15 17:08:07', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3eb2f1e9b63b4355ae4858c06d2ba3ca', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node2', 'node2', '1', '2018-03-05 11:16:09', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3ebde06d86054023989bf409b6864f24', '98713ef0932544ff82e4be380495b48e', 'dcr_node3', 'node3', '2', '2018-03-14 16:51:14', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3f201eec62784e0db0c078f002304c45', '558f4088198a43518fa36e304cbda1e8', 'BCrrDuebillApp_approve', 'null', '0', '2018-04-03 13:32:25', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'DG', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3f856820379942f2a114e7a5efac9617', '17f10f77dc654a5e861173544809f785', 'dcr_node3', 'null', '0', '2018-03-05 19:42:34', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3fcaf37fb231459da8226029a75d9c3d', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-17 14:01:18', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('3fe37328486f4dafad85a67d5bdadd0e', '760f1448e10e46b6b465524251decabc', 'dcr_node1', 'node1', '0', '2018-03-14 17:06:50', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('40a8bd3df7cf4e74beb0ac19bf721bdb', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node2', 'node2', '0', '2018-03-05 11:15:58', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('42827b80b73c4caf8ffc964ae5c818f9', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node4', 'null', '0', '2018-03-14 13:28:40', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('431ae761fd404e0799469230d8cb0129', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve', 'null', '0', '2018-03-19 10:45:23', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('439bf0b63c3442908d2e62f6ef199696', 'da96537a56a043ffacd6a165dd080de2', 'credictEvalNode1', 'creditEvalTask01', '0', '2018-03-19 17:03:58', '1C8U518GA000A441370A0000D24B18CD', '1001', 'test00', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('44bd030ce2e1485e8945cf8023451673', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-04-04 15:38:45', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('457422b0ba4c4c208192f047f6f02f90', '789e55480adc460fabe7451abb90362e', 'pass', 'null', '0', '2018-03-05 11:24:51', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('46dfb6e09d944a9f8fbd3ffe3ed504cc', '36337f68b5e344c09874606a534c3dfe', 'dcr_node2', 'node2', '1', '2018-03-21 19:49:58', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('46ed1562134947da9e2ffecfd7106216', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-04-04 16:07:46', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('48260f5d8a5c4fb1bf22573e0de2dc4e', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-19 10:45:33', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('48e5cc5cbb954237ba0c9262f6ce5ead', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-15 17:09:00', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('4999405e4c624168b8f339b51fae6d08', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node3', 'node3', '2', '2018-03-19 10:26:20', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('4a6ea341393442cd8256b4f703cfde62', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode1', 'creditEvalTask01', '0', '2018-04-02 15:05:47', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('4d26db673b064f1893577f16d325bf74', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve', 'null', '0', '2018-03-21 16:32:57', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('4de6fafae1914075a692b3fd1ea87c22', '789e55480adc460fabe7451abb90362e', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-05 11:24:39', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('4e94ad79554e48ad9cbc88c2078893ab', 'f005b3a5fc754975af819bf6a28d6836', 'Approve', 'Approve_task', '0', '2018-03-23 17:09:58', 'FCNT2018032300000106', 'C20180305000304', '88888888-5', 'FactoringContApply', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5078836e63334212b9e7d12a76e76015', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve2', 'null', '0', '2018-04-04 16:07:45', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('50c3a67563fd40f7b565d7925ea011c1', 'cc4046beca514524820bf894794c6ff4', 'dcr_node3', 'null', '0', '2018-03-27 09:43:00', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('515e449a8934488097e6f9ca8e37a7ed', '36337f68b5e344c09874606a534c3dfe', 'dcr_node2', 'null', '0', '2018-03-21 19:49:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('529d49e2e9824ca0aed6f5dfb306ce3e', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-19 10:45:41', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('531bd86bcaaf4ec493ed5221875233bc', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-04-04 16:07:45', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('53385137091f48c087aaa22ea6e5b2b6', '36337f68b5e344c09874606a534c3dfe', 'dcr_node4', 'null', '0', '2018-03-21 19:50:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('53963d2daa08409daa70346a22610108', '36337f68b5e344c09874606a534c3dfe', 'dcr_node4', 'node4', '0', '2018-03-21 19:50:34', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5581ae975a3149eeb95b61ad4d4f0247', '789e55480adc460fabe7451abb90362e', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-05 11:24:29', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('55a3c6c2ee7747ba9ee4d98a0480219a', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node4', 'node4', '2', '2018-03-19 10:26:30', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('55c2ae520c304ecf9baf6fd0a6e9c714', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node3', 'node3', '1', '2018-03-19 10:26:20', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('55f0bf7175e74e619b5bc34184748d94', '17f10f77dc654a5e861173544809f785', 'dcr_node1', 'null', '0', '2018-03-05 09:35:44', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('56853b7b245146fd91157f76d07c568b', '0d6e979355134535a05b535f77af7d10', 'pass', 'null', '0', '2018-04-03 17:59:13', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5b6eb9d63a42481eb40bb1785f17df98', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-17 14:01:18', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5c28cc9f809d4df9badb5186d64e6896', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-15 17:09:00', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5c5d6b670df440898133bf2ad4f575c5', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-06 20:41:59', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5c68bd59ce634f999d4958411ccb6b05', '69b37cbee8c645e7a4269ad4e062df91', 'BCrrDuebillApp_approve', 'null', '0', '2018-04-03 13:49:32', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5d0dc80b1a0745ec9daba8de6146a52a', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-19 10:45:56', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5d1dff18863f4f07bf0536f9dbe9562a', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-15 17:08:07', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5d7bc0e360ff48b0bfe598b9336b436a', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-16 10:54:18', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5ee47c57f257476bb4ee63a93172edcb', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-21 16:33:43', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('5f537d10ce6a4dc2af29981e442e7974', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve', 'null', '0', '2018-03-14 15:01:37', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('61702e7237a841bfb37b58a280e6383a', '98713ef0932544ff82e4be380495b48e', 'dcr_node2', 'null', '0', '2018-03-14 16:50:54', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('628d487c895e4c9c8e34b57592631425', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode1', 'creditEvalTask01', '2', '2018-04-03 17:58:44', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('62d64b3f1d154f99a2f87ffe14cd1340', '98713ef0932544ff82e4be380495b48e', 'reject', 'null', '0', '2018-03-14 16:51:14', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('641b0897d7f34cca9143e99e4535b2a8', '98713ef0932544ff82e4be380495b48e', 'dcr_node1', 'node1', '2', '2018-03-14 16:50:54', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('67147ee17f2e4116ba33c01b7a013c40', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-21 16:33:28', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('67150501e7fe4e0a82895d634a318b3d', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-04-04 15:38:44', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('673f3fb6759141c7a3900f466f25d584', 'cc4046beca514524820bf894794c6ff4', 'dcr_node2', 'node2', '0', '2018-03-27 09:42:42', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('675c893d266c45859352bda799b8775b', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve1', 'null', '0', '2018-04-04 15:38:45', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('69b0d25a6aad4dea95c2ffa6588a4e31', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node1', 'node1', '0', '2018-03-05 11:15:40', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('69f0adc6e5ae46829922ff89e30f8728', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-19 10:45:41', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6a36dec181c34e578c6744098f5fadbc', '7c6c7c3b6e554d2d91468b6e3a5cfe6b', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '0', '2018-04-03 11:26:29', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6abbb504f6eb4fcc8a7493a1faa44416', '760f1448e10e46b6b465524251decabc', 'dcr_node2', 'node2', '0', '2018-03-14 17:06:59', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6b22c551e9b8412189c119c758039973', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node2', 'node2', '0', '2018-03-21 14:28:49', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6b7806b5305c4bef931e2c08c23304cd', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve1', 'null', '0', '2018-03-15 17:08:52', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6be96d66137b4b87944aaeb5cc3ece2b', '17f10f77dc654a5e861173544809f785', 'dcr_node3', 'node3', '2', '2018-03-05 19:48:10', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6c5469e77f3d4d7295173ca763fa29cc', 'fc8c0641be904bbc9951f37a0bed9502', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '1', '2018-04-03 14:10:05', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6c903dcbcafe4b1c89d36143923a7711', '17f10f77dc654a5e861173544809f785', 'dcr_node3', 'node3', '1', '2018-03-05 19:48:10', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6e1b70339e2845cbaf3f7a69b09d009c', '69b37cbee8c645e7a4269ad4e062df91', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '2', '2018-04-03 13:49:32', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('6e2d391817ff4f8396c44c0792ba9625', '760f1448e10e46b6b465524251decabc', 'dcr_node3', 'null', '0', '2018-03-14 17:07:17', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('70f7638b799449d4979a0f77ce0ddeba', '6edcce62aeb0406b982ea32a7b12a044', 'Approve', 'null', '0', '2018-03-05 13:52:48', 'FCNT2018030500000104', 'C20180305000304', '88888888-5', 'FactoringContApply', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('71009a2471394dc89616c0707a8724cc', '98713ef0932544ff82e4be380495b48e', 'dcr_node1', 'null', '0', '2018-03-14 16:44:39', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('712adf1da74548a4a0ed189e9761d0cc', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-17 14:01:32', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('7308cc1f7bad4176947950b67dea2c66', '789e55480adc460fabe7451abb90362e', 'LnApp_approve', 'null', '0', '2018-03-05 11:23:57', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('73146eefd45147439e2563424a2e3776', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node2', 'node2', '0', '2018-03-06 15:02:10', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('75a0c97027f64fbcbe2e6c389554e98d', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-06 20:46:36', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('77f7fe6ee1524282aa7e14c5f1287d73', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-06 20:46:47', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('784ae4a3e5b54ad4807b85f85ac36913', '17f10f77dc654a5e861173544809f785', 'dcr_node1', 'node1', '1', '2018-03-05 19:40:48', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('787e54587db642eba7052a55ba34e9b8', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node2', 'node2', '2', '2018-03-21 14:29:04', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('78b34e7f0cb8435d9cbefabca591248e', 'f005b3a5fc754975af819bf6a28d6836', 'Approve', 'null', '0', '2018-03-23 17:09:58', 'FCNT2018032300000106', 'C20180305000304', '88888888-5', 'FactoringContApply', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('7a2e361816ab44edb9976007495fd9f9', '789e55480adc460fabe7451abb90362e', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-05 11:24:29', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('7bf889dfc18a473eae2accd919abcb1a', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node3', 'node3', '0', '2018-03-05 11:16:10', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('7cb02f7cc90446c0b782669b1ac54d98', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode2', 'creditEvalTask02', '1', '2018-04-02 15:12:22', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('7d16b69e1fe345199af8c121cd94b18e', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-06 20:46:26', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('7e55d435f3d6449388d5d13581a4da83', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode1', 'null', '0', '2018-04-03 17:58:03', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', 'null', 'null', '2', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('7fe0817a10fb448b9b38f8cf692cbd58', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve2', 'null', '0', '2018-03-19 10:45:41', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('808778312c974bdbb181bb1b8d291276', '760f1448e10e46b6b465524251decabc', 'dcr_node1', 'node1', '1', '2018-03-14 17:06:59', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('80eed0c318f34e8a86663dd79e1ee2c7', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-15 17:09:11', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('81044bd8cff743c28b36f1c52dec8589', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node1', 'null', '0', '2018-03-21 14:28:34', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('814682b1de654c1aa322d97d2f4c7372', '02093a6020734a60acf331ca7744a094', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-07 13:38:59', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8231581161934119a65eb2d2d9dfc358', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-17 14:01:32', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('82388bf24cd9457e99d798276f01595c', '98713ef0932544ff82e4be380495b48e', 'dcr_node1', 'node1', '1', '2018-03-14 16:50:54', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8285155a1e7141718649b5d936062f5d', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node3', 'node3', '2', '2018-03-05 11:16:27', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('82ccd9f44e4341f89c8d1ae1fefdc8ec', '928807fda9254fae9cf1d3c7c6e524d2', 'credictEvalNode1', 'null', '0', '2018-04-02 14:53:14', 'XYPJ201804020000002', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8407a7b2e7e84f748b132dfa131c3041', '17f10f77dc654a5e861173544809f785', 'dcr_node3', 'node3', '0', '2018-03-05 19:42:34', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('85997f49ac1042f7bfc2500899e769bc', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve1', 'null', '0', '2018-04-04 16:10:09', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('85ba08c882d34335b6cae6483796c963', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-15 17:08:52', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('85bda3d2c1024fb6ae6b16e9a2af92bb', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node1', 'node1', '0', '2018-03-06 14:59:32', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('86287c76f83b46599e5cc96f96d0d1de', 'cc4046beca514524820bf894794c6ff4', 'dcr_node1', 'null', '0', '2018-03-27 09:42:31', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('871372a76faf40e7b3f57517937d539d', '02093a6020734a60acf331ca7744a094', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-07 13:39:18', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8840f68c82c7430995025a936f8689ff', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node4', 'null', '0', '2018-03-19 10:26:20', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8909f9aa16da4087aa635234417e70bb', '760f1448e10e46b6b465524251decabc', 'dcr_node2', 'node2', '1', '2018-03-14 17:07:17', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8b3177d364094b2989aac5a130cfa51b', '789e55480adc460fabe7451abb90362e', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-05 11:24:39', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8b4aa2ee147345c195030e9a5af6c162', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node3', 'null', '0', '2018-03-19 10:26:06', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8c05a126f257452d8a6d65349914889d', '789e55480adc460fabe7451abb90362e', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-05 11:24:39', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8f34e53e80214834854d58fcc19a52ff', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-06 20:46:36', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('8fafa8c889d4462b8795f66e367789bd', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-06 20:46:47', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('902927850c7249b49514834bf5e9db06', '17f10f77dc654a5e861173544809f785', 'dcr_node1', 'node1', '0', '2018-03-05 09:35:44', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('904523bd1a8347fb9fa0cc412ba0f365', '98713ef0932544ff82e4be380495b48e', 'dcr_node2', 'node2', '1', '2018-03-14 16:51:03', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('909a43f828264255a5ffa3cfa915ff72', '02093a6020734a60acf331ca7744a094', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-07 13:38:01', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('90d089dbdaa049a4871cd226dde93bc9', '98713ef0932544ff82e4be380495b48e', 'dcr_node3', 'null', '0', '2018-03-14 16:51:03', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('914e52cba2fe4d7fa290f902094b9c8c', '36337f68b5e344c09874606a534c3dfe', 'dcr_node3', 'null', '0', '2018-03-21 19:49:58', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('91ef6fb6d64a429e82d268ffbae9ec71', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node2', 'null', '0', '2018-03-19 10:25:58', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('92078b09c916470caf8db7101e3ea475', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node3', 'null', '0', '2018-03-05 11:16:10', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('93b12d461b804d6d990187760b9b0a58', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode2', 'null', '0', '2018-04-02 15:10:07', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('94d3c5b6b21c400fa67a92d188ea6dcf', '7a68a2d9a5b64ac2ae75be02704b1b41', 'pass', 'null', '0', '2018-03-19 10:45:56', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('95ae593af67f49d891b6cbca279bcfb1', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node3', 'node3', '1', '2018-03-05 11:16:27', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('967728059b7449a8b168edd6289ed1c6', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode2', 'null', '0', '2018-04-03 17:58:44', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('96b1935a4de24dc5a16bf193107e0a58', 'cc4046beca514524820bf894794c6ff4', 'dcr_node1', 'node1', '1', '2018-03-27 09:42:42', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('978f488b85ac429bb30bb87c3ca6cf65', '760f1448e10e46b6b465524251decabc', 'dcr_node1', 'null', '0', '2018-03-14 17:06:50', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('97ad678e139941d8a1aebf6ff4c41bcf', 'fc8c0641be904bbc9951f37a0bed9502', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '0', '2018-04-03 14:09:35', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('98b57f4c9f5c4e65b22a2e1ed28931a2', 'cc4046beca514524820bf894794c6ff4', 'dcr_node2', 'node2', '1', '2018-03-27 09:43:00', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('996adb19d2aa4c2d9f0629a65434358d', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-19 10:45:33', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('99939273f13a44d5b5b5f6df45e9db52', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-04-04 16:08:10', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('99eb9a0168b54316b2e42d0563eb7b7f', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-15 17:09:00', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('9a37cba46d324c77a5ed815ac201efc8', '36337f68b5e344c09874606a534c3dfe', 'dcr_node3', 'node3', '0', '2018-03-21 19:49:58', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('9a9df1789f3d4d15ad09e23ecd8b98c2', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node4', 'node4', '0', '2018-03-14 13:28:40', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('9ec6da42ece94ea29541180a8b77b0b8', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-06 20:46:26', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('9eeeb48c2df44c3ea36c2e9d380945f7', '17f10f77dc654a5e861173544809f785', 'dcr_node2', 'node2', '0', '2018-03-05 19:40:48', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('9f9bfbc8ef4a451396fb18a8f5e286c5', '17f10f77dc654a5e861173544809f785', 'dcr_node2', 'node2', '1', '2018-03-05 19:42:34', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('9f9cb5eac282495d9c646741813d1b62', 'cc4046beca514524820bf894794c6ff4', 'dcr_node3', 'node3', '2', '2018-03-27 09:43:17', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a2ae6d3ed64b4b72a0a48ae16f4339a5', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node1', 'node1', '2', '2018-03-05 11:15:57', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a2c7d62382b64128abd47437215069e1', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve2', 'null', '0', '2018-03-15 17:09:00', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a3d57d666eb24f0bb1b9dd850beb0c61', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-04-04 15:38:44', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a525ef58745c41bca4a9c44f9c139018', '760f1448e10e46b6b465524251decabc', 'dcr_node4', 'null', '0', '2018-03-14 17:07:27', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a56ac2c3315442dcb4fe387b9e89eecd', '0f887815d80647178bfd919b83aab4c9', 'pass', 'null', '0', '2018-04-02 15:12:23', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a6263c69683f4743a0c63a6295401921', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-14 15:10:17', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a63aae9e8ce94e02ac7087489958befe', '69b37cbee8c645e7a4269ad4e062df91', 'BCrrDuebillApp_approve', 'null', '0', '2018-04-03 11:39:17', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'DG', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a6a308c0dec54b049293f15ae0abee0e', '02093a6020734a60acf331ca7744a094', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-07 13:36:53', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a744d240b7b8475288114d0987f92e82', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node3', 'null', '0', '2018-03-21 14:29:04', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a7e452e544924fa3957fc30a7e412cb5', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node1', 'node1', '2', '2018-03-21 14:28:49', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a963e6d6ec1f4d38bb362ef9b825ca49', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-04-04 16:10:09', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('a9ae89f58c7840a9a3f0c14dcead8380', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-03-14 15:10:17', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('aab8794013004b14811cbc37cb0891e8', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node2', 'node2', '2', '2018-03-19 10:26:06', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ab14668e5feb423b946ae6b5cc3ba3c0', '36337f68b5e344c09874606a534c3dfe', 'dcr_node1', 'null', '0', '2018-03-21 19:48:49', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ab481a56b6274602970f3449837cd803', '19a802007c5744ab826f25c11b59d84e', 'BCrrDuebillApp_approve', 'null', '0', '2018-04-03 11:22:25', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ab82211391c34c75807140b0bc747697', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'pass', 'null', '0', '2018-03-17 14:01:32', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('abbd3ef98622484faf21b732fb6d2fc5', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve', 'null', '0', '2018-03-17 14:00:44', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ac34568374a84eecb75fd556c05d85fb', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve1', 'null', '0', '2018-03-14 15:10:17', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ac3bb1c7912e437899ff300954864b53', '98713ef0932544ff82e4be380495b48e', 'dcr_node2', 'node2', '2', '2018-03-14 16:51:03', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('acd6972ca4324dc3a6f5b81a7fa43f4d', '6edcce62aeb0406b982ea32a7b12a044', 'start', 'null', '0', '2018-03-05 13:52:48', 'FCNT2018030500000104', 'C20180305000304', '88888888-5', 'FactoringContApply', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ad100e0f4a5c447dbd1b4c94d46900e6', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve2', 'null', '0', '2018-03-21 16:33:28', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ad73a47a16b54abf90475bd0b19ba012', '98713ef0932544ff82e4be380495b48e', 'dcr_node2', 'node2', '0', '2018-03-14 16:50:54', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ae24d397408d4fb99fb6977c6f4becff', '760f1448e10e46b6b465524251decabc', 'dcr_node4', 'node4', '0', '2018-03-14 17:07:27', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ae8f5cfc19b741da8a08eef7572a5196', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node2', 'node2', '2', '2018-03-12 17:14:19', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('aee8e959e89c4aacb34f00b65b7769c7', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node1', 'node1', '0', '2018-03-21 14:28:34', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('b08ec40053bc4ab08e59298ce96dd4e6', '02093a6020734a60acf331ca7744a094', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-07 13:38:59', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('b0d991a1cb3241bba52f0386615feadd', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node1', 'node1', '2', '2018-03-06 15:02:10', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('b170f26f1b204375b2d840c7eed46d91', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-21 16:33:17', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('b2f5c63121aa4cf7923519b30d8f1c44', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode1', 'creditEvalTask01', '1', '2018-04-03 17:58:42', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('b452cd5470f04533b737e78fe239e37c', 'fc8c0641be904bbc9951f37a0bed9502', 'reject', 'null', '0', '2018-04-03 14:10:06', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('b57285d71c78470db7df10932a11c458', '789e55480adc460fabe7451abb90362e', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-05 11:24:51', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('b6c48a491adf4ccea71f88cdac7ccbe9', '5dc5f596fb9d496ca5a192d838a80fb8', 'credictEvalNode1', 'creditEvalTask01', '0', '2018-04-02 14:53:16', 'XYPJ201803310000001', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ba52fc728af64e7e99db9d1552ca8e95', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node1', 'null', '0', '2018-03-06 14:59:32', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('bb74fea42a2445ce902bb066d1aabe99', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-21 16:32:57', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('bb88ff2be7cf4de4b1e045c4127a0c30', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node2', 'node2', '1', '2018-03-19 10:26:06', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('bc74eb9e1f8b42049a54ab6cdba9ea83', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node1', 'null', '0', '2018-03-05 11:15:39', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('be3bdaf7c5284c1d9cf1bd927ed04874', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-14 15:01:37', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('bea71a00b8694d46ba825f5940cee6b9', 'cc4046beca514524820bf894794c6ff4', 'dcr_node1', 'node1', '2', '2018-03-27 09:42:42', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('c12f287d8d9b4f9abb18fb39e9b64365', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node1', 'node1', '1', '2018-03-05 11:15:57', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('c2d4d7d79a6e4b62af8fe2a2763d3f01', 'cc4046beca514524820bf894794c6ff4', 'dcr_node3', 'node3', '0', '2018-03-27 09:43:00', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('c31602d84d8945f7a21be17194806b12', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode2', 'creditEvalTask02', '0', '2018-04-02 15:10:09', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('c5a7a8041bbe4d1bb8253c230c51d0e8', 'cc4046beca514524820bf894794c6ff4', 'dcr_node2', 'null', '0', '2018-03-27 09:42:42', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('c65d5025b8a44e65916b7277fa2a00dc', 'f005b3a5fc754975af819bf6a28d6836', 'start', 'null', '0', '2018-03-23 17:09:58', 'FCNT2018032300000106', 'C20180305000304', '88888888-5', 'FactoringContApply', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('c6a0c7ec9f754a99a787ba8331e68433', '17f10f77dc654a5e861173544809f785', 'dcr_node4', 'node4', '1', '2018-03-05 19:48:29', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('cb88f5b4deb041c69565ca089e83db85', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node3', 'node3', '0', '2018-03-19 10:26:06', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('cbe4518eed6c462da55515b50843eb17', '4d2a4ed671eb408cb6d0cda925489d89', 'pass', 'null', '0', '2018-03-05 11:16:27', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('cbf00b2bc4f44388b2904c0c6e2265ae', 'f482de153db845c9b50a82faa3dcc75f', 'pass', 'null', '0', '2018-03-19 10:26:30', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('cc02a8a4fa244d56b4d715a6848d6b4e', 'cc4046beca514524820bf894794c6ff4', 'dcr_node1', 'node1', '0', '2018-03-27 09:42:31', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ccaa945996124251a775808f1f62764e', '760f1448e10e46b6b465524251decabc', 'dcr_node2', 'node2', '2', '2018-03-14 17:07:17', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ce27d06033a8499e8037c4c688dcde6d', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-17 14:00:44', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('cfa44263b72946378c323c7f3365ba24', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node3', 'node3', '0', '2018-03-12 17:14:19', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('cfb564fb2546424ba93fc8c5a820172f', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-04-04 16:08:10', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('cfef04f86f2c4cf69ab6ad67d5a07edf', '789e55480adc460fabe7451abb90362e', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-05 11:24:29', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d089a90e793b4d5e9479b701fdeb1948', '8fd551c534ed414f9f013baf9042cef3', 'pass', 'null', '0', '2018-03-16 10:54:27', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d10f2b7aa69442cda152bf0348e91f49', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve1', 'null', '0', '2018-03-19 10:45:33', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d18003f712d14bb4a444c1be94e85464', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node4', 'node4', '1', '2018-03-19 10:26:30', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d1938492afaa4deeb5a559a8f9f980fe', '17f10f77dc654a5e861173544809f785', 'dcr_node4', 'node4', '2', '2018-03-05 19:48:29', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d1f23520fc314cc09efda01a97b79e08', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node3', 'node3', '2', '2018-03-14 13:28:40', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d3acdb8e5eca42258171180fcf853d6c', '7c75d849c51f448b832977fcb4d92b35', 'pass', 'null', '0', '2018-04-04 16:08:11', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d3d55fb5d188405b804e4839606e6062', 'cc4046beca514524820bf894794c6ff4', 'dcr_node2', 'node2', '2', '2018-03-27 09:43:00', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d444389911f34fe8b4ccd8b6989724d4', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve', 'LnAppApprove_task', '2', '2018-04-04 16:10:09', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d4fe214d257d4d64a5f36b46945fc579', '17f10f77dc654a5e861173544809f785', 'dcr_node2', 'node2', '2', '2018-03-05 19:42:34', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d63a35c51a9744e0a4a4bd8961bbd85f', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node2', 'node2', '0', '2018-03-19 10:25:58', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d681c1e5b1194f9b8ff608d78202307f', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-21 16:33:17', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d6c6da1acf9d4b9a866158e8a842679c', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-17 14:01:10', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('d6edcd2258e44ed78b7518a03e5e4e7a', '789e55480adc460fabe7451abb90362e', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-05 11:24:51', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('daa4a7ac6cf642ca800e97b429587be4', '3a8a3da8e08249459f573f5115d00355', 'pass', 'null', '0', '2018-03-21 16:33:43', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('db3e93f646b14f10819b1dc95f2579ce', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode1', 'creditEvalTask01', '0', '2018-04-03 17:58:04', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', 'null', 'null', '2', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('dbe0562d2a664ace8daf30a3bbeeab5a', '19a802007c5744ab826f25c11b59d84e', 'BCrrDuebillApp_approve', 'bcrrduebillapp_approve', '0', '2018-04-03 11:22:27', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('dd9f474ce988462aa3e4f88fd278714b', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-19 10:45:23', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ddf1d0ef915b421fa5e7050f1188e8ba', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node2', 'node2', '2', '2018-03-05 11:16:10', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ded410bd75af47ad99f68da085f81ca3', 'fc8c0641be904bbc9951f37a0bed9502', 'BCrrDuebillApp_approve', 'null', '0', '2018-04-03 14:09:35', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('dfcad3c685674709819b49fc7e8f12e3', '7c6c7c3b6e554d2d91468b6e3a5cfe6b', 'BCrrDuebillApp_approve', 'null', '0', '2018-04-03 11:26:29', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('dfe23ee3c2a84572baaa3e9e2ec24607', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve2', 'LnAppApprove2_task', '2', '2018-03-16 10:54:27', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('e0987b24998747c1b40d00a246e3d619', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-15 17:08:52', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('e243e41192234f2d9bb5dc605a3b0edc', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve2', 'LnAppApprove2_task', '0', '2018-03-16 10:54:18', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('e3cffb8ec06448baa0ef74ccfa969c50', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve', 'null', '0', '2018-03-06 20:41:59', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('e658589172744355a7e680f0e082df67', '36337f68b5e344c09874606a534c3dfe', 'dcr_node3', 'node3', '1', '2018-03-21 19:50:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('e8ffded53b934050bef08d6340a698cf', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve1', 'LnAppApprove1_task', '1', '2018-03-21 16:33:28', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ebb88596bbf54f0d957c0be71bfeb64b', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode2', 'creditEvalTask02', '0', '2018-04-03 17:58:45', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ecf104627b5245f1834b9c1729fb7829', '36337f68b5e344c09874606a534c3dfe', 'dcr_node1', 'node1', '1', '2018-03-21 19:49:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ee1fc217a36f48a1bdd90e48c1d36949', '02093a6020734a60acf331ca7744a094', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-07 13:38:01', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ee6a7b654a1a4834aedaf96d2fedbf39', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-15 17:08:52', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f06b38f6017f4668adddcfd773b18ca0', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node3', 'null', '0', '2018-03-12 17:14:19', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f1d3b8e419b443ca8ce21211d7c6bbcb', '02093a6020734a60acf331ca7744a094', 'LnApp_approve1', 'null', '0', '2018-03-07 13:38:01', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f1eaad70512a4389812f7299e43a50ea', '17f10f77dc654a5e861173544809f785', 'dcr_node4', 'null', '0', '2018-03-05 19:48:10', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f286e1bc1e974d60830e18bc5ac6eec6', '02093a6020734a60acf331ca7744a094', 'LnApp_approve', 'LnAppApprove_task', '1', '2018-03-07 13:38:01', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f30887322349416b8c7721dbcd78fc8e', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node2', 'null', '0', '2018-03-05 11:15:57', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f3dc646700574425b368385ebbab71e0', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve2', 'LnAppApprove2_task', '1', '2018-03-15 17:09:11', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f50d3b46e4ad41619a5103471ba01a48', '98713ef0932544ff82e4be380495b48e', 'dcr_node3', 'node3', '1', '2018-03-14 16:51:14', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f54013ed851848d7929e9c501b8402a9', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve2', 'null', '0', '2018-03-06 20:46:36', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f6c74c90de0545a1b0ea8aa82f6b4337', '789e55480adc460fabe7451abb90362e', 'LnApp_approve', 'LnAppApprove_task', '0', '2018-03-05 11:23:57', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f704470627684691a03ab07437a9deeb', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node1', 'node1', '1', '2018-03-06 15:02:10', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f78293e1c8e24f4ead5c38c365a506f2', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve1', 'LnAppApprove1_task', '0', '2018-03-17 14:01:11', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f786914c28504832a88890987724f463', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-21 16:33:28', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f81f9690704c41b9b3af2b658c4de5b5', 'cc4046beca514524820bf894794c6ff4', 'dcr_node3', 'node3', '1', '2018-03-27 09:43:17', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('f9210f824b3943d2969b605d8d108bf1', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve1', 'LnAppApprove1_task', '2', '2018-03-16 10:54:18', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('fa788339246143dc82d2a2cf79ce1dfd', '760f1448e10e46b6b465524251decabc', 'dcr_node3', 'node3', '0', '2018-03-14 17:07:17', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('fac92127f8814cd4950fadb4f69565ce', '515ccab46c4e4d1fb1928fd7334e6426', 'pass', 'null', '0', '2018-03-15 17:09:11', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('fca6eb3fa405473d839fa9041b679078', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode2', 'creditEvalTask02', '2', '2018-04-02 15:12:23', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('fd575a14b18c46c7b918386403320db3', '760f1448e10e46b6b465524251decabc', 'dcr_node1', 'node1', '2', '2018-03-14 17:06:59', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('fd6dc3fb59c140c7ba15deddde42419e', '98713ef0932544ff82e4be380495b48e', 'dcr_node1', 'node1', '0', '2018-03-14 16:44:39', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ff225b60ef8049129864260884a120d2', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node1', 'node1', '0', '2018-03-19 10:25:44', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', 'null', 'null', 'null', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ff34f09623584775a98210ac5d11006f', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve', 'null', '0', '2018-04-04 15:13:34', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', 'null', 'null', '02', 'null');
INSERT INTO `tbl_biz_mapping` VALUES ('ffade7ad79ae488fa4c02de74728fb4b', 'da96537a56a043ffacd6a165dd080de2', 'credictEvalNode1', 'null', '0', '2018-03-19 17:03:57', '1C8U518GA000A441370A0000D24B18CD', '1001', 'test00', 'creditEvalPrcssCreate', 'null', 'null', 'null', 'null');

-- ----------------------------
-- Table structure for `tbl_exception`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_exception`;
CREATE TABLE `tbl_exception` (
  `ID` varchar(32) NOT NULL,
  `PROCESS_ID` varchar(32) DEFAULT NULL,
  `MODEL_ID` varchar(32) DEFAULT NULL,
  `ERROR_CODE` varchar(20) NOT NULL,
  `MESSAGES` varchar(255) DEFAULT NULL,
  `RETRY_FLAG` decimal(8,0) DEFAULT NULL,
  `EXCEPTION_FILE` varchar(255) DEFAULT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `RETRY_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `EXCEPTION_TYPE` varchar(10) NOT NULL,
  `ATOMIC_TYPE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_exception
-- ----------------------------
INSERT INTO `tbl_exception` VALUES ('1C7Q3CILD0001612320A00005B0B8341', null, null, 'FS_0000', 'FS-0001:没有找到审批节点和审批条件之间的关系。', '0', '1C7Q3CILD0001612320A00005B0B8341_20180305113054.exp', '2018-03-05 11:30:54', '0000-00-00 00:00:00', 'NORMAL', null);
INSERT INTO `tbl_exception` VALUES ('1C7Q3EIQP0011612320A00004E4C67AA', null, null, 'FS_0000', 'FS-0001:没有找到审批节点和审批条件之间的关系。', '0', '1C7Q3EIQP0011612320A00004E4C67AA_20180305113159.exp', '2018-03-05 11:31:59', '0000-00-00 00:00:00', 'NORMAL', null);
INSERT INTO `tbl_exception` VALUES ('1C7Q3ERVS0021612320A0000A01FC994', null, null, 'FS_0000', 'FS-0001:没有找到审批节点和审批条件之间的关系。', '0', '1C7Q3ERVS0021612320A0000A01FC994_20180305113209.exp', '2018-03-05 11:32:09', '0000-00-00 00:00:00', 'NORMAL', null);
INSERT INTO `tbl_exception` VALUES ('1C7TDTD7T0031612320A0000AC0DC433', null, null, 'FS_0000', 'FS-0001:没有找到审批节点和审批条件之间的关系。', '0', '1C7TDTD7T0031612320A0000AC0DC433_20180306183234.exp', '2018-03-06 18:32:34', '0000-00-00 00:00:00', 'NORMAL', null);
INSERT INTO `tbl_exception` VALUES ('1C7TE8C7O0041612320A00006A04DA0D', null, null, 'FS_0000', 'FS-0001:没有找到审批节点和审批条件之间的关系。', '0', '1C7TE8C7O0041612320A00006A04DA0D_20180306183834.exp', '2018-03-06 18:38:34', '0000-00-00 00:00:00', 'NORMAL', null);
INSERT INTO `tbl_exception` VALUES ('1C8N2046L0051612320A000028AA63A8', null, null, 'FS_0000', 'FS-0001:没有找到审批节点和审批条件之间的关系。', '0', '1C8N2046L0051612320A000028AA63A8_20180316172436.exp', '2018-03-16 17:24:36', '0000-00-00 00:00:00', 'NORMAL', null);
INSERT INTO `tbl_exception` VALUES ('1C93REBLK0061612320A00003468C79B', null, null, 'FS_0000', 'FS-0001:没有找到审批节点和审批条件之间的关系。', '0', '1C93REBLK0061612320A00003468C79B_20180321164010.exp', '2018-03-21 16:40:10', '0000-00-00 00:00:00', 'NORMAL', null);

-- ----------------------------
-- Table structure for `tbl_model_des`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_model_des`;
CREATE TABLE `tbl_model_des` (
  `ID` varchar(32) NOT NULL,
  `SYS_ID` varchar(32) NOT NULL,
  `MODEL_ID` varchar(32) NOT NULL,
  `MODEL_NAME` varchar(255) DEFAULT NULL,
  `TOP_UNIT_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_model_des
-- ----------------------------
INSERT INTO `tbl_model_des` VALUES ('1B13IA1HF0010100007F00000F99DC62', 'scf-100', 'FactoringLeaseBuyBackApply', '应收租金反转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B1OVVIUB0000100007F0000711BB3C7', 'scf-100', 'creditEvalPrcssCreate', '信用评估流程创建', null);
INSERT INTO `tbl_model_des` VALUES ('1B24VGKTH0010100007F0000810EF717', 'scf-100', 'BCrrDuebillApp', '出账业务', null);
INSERT INTO `tbl_model_des` VALUES ('1B24VGKTH0010100007F0000810EF718', 'scf-100', 'InvoiceFinancingApply', '应收账款融资流贷放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B24VGKTH0010100007F0000810EF719', 'scf-100', 'FinancingPoolApply', '应收账款池融资流贷放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B24VGKTH0010100007F0000810EF720', 'scf-100', 'MortgageCashLoanApply', '现货质押流贷放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B24VGKTH0010100007F0000810EF721', 'scf-100', 'ThreeBillChargeOffApply', '担保提货银承放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B24VGKTH0010100007F0000810EF722', 'scf-100', 'FourLoanBillApply', '先票款后货银承放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B24VLQLF0020100007F0000F1FDD1FB', 'scf-100', 'BCrrLnApp', '贷款业务', null);
INSERT INTO `tbl_model_des` VALUES ('1B2SH96PT0000100007F00001ABC68B6', 'scf-100', 'BDcrLinApp', '授信额度申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B2V72P490020100007F0000A808996D', 'scf-100', 'BDcrLin', '授信额度申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B3RULNPV000A2C7FCAA000097D4BBE6', 'scf-100', 'ThreeAccountConfirmApply', '担保提货收款确认申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B3RULNPV000A2C7FCAA000097D4BBE7', 'scf-100', 'FourAccountConfirmApply', '先票款后货收款确认申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B4B0PF0V000A3C7FCAA0000FDF728BE', 'scf-100', 'BCrrDuebillApp(XD)', '出账申请（信贷）', null);
INSERT INTO `tbl_model_des` VALUES ('1B4I2538N0009BC7FCAA00007B5F2C52', 'scf-100', 'ThreeGuaBuybackApply', '担保提货差额退款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B4I2538N0009BC7FCAA00007B5F2C59', 'scf-100', 'FourGuaBuybackApply', '先票款后货差额退款', null);
INSERT INTO `tbl_model_des` VALUES ('1B4TIIKF70009BC7FCAA000064EF589F', 'scf-100', 'RBcpBussAppli', '应收账款转让/出质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B4TIIKF70011BC7JCAA000064EF589F', 'scf-100', 'FactoringAanwinstApply', '应收账款转让/出质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B4VP3A2N0059BC7FCAA0000D7049BB9', 'scf-100', 'DisputeInvoiceSetApply', '应收账款商纠登记申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B54KISR60069BC7FCAA0000DA069B3B', 'scf-100', 'DynamicQualityApply', '现货动态质押出质入库申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B54KISR60069BC7FCAA0000DA069B3C', 'scf-100', 'FourhousePledgeApply', '先票款后货到货出质入库', null);
INSERT INTO `tbl_model_des` VALUES ('1B54KISR60069BC7FCAA0000DA069B3D', 'scf-100', 'StaticQualityApply', '现货静态质押出质入库申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B5H07CQM000A3C7FCAA0000186461CC', 'scf-100', 'ProtocolAmountApply', '最低控货价值调整', null);
INSERT INTO `tbl_model_des` VALUES ('1B5HO9PSA000A4C7FCAA00008498EF4E', 'scf-100', 'FactoringAccountCancelApply', '应收账款核销申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B5PAC5220008EC7FCAA0000AD2DB960', 'scf-100', 'ThreeDeliveryApply', '担保提货提货申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B62UO24K000A1C7FCAA00002A6C610A', 'scf-100', 'repayment', '应收账款融资回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B6678CMS0039AC7FCAA00009941EBF6', 'scf-100', 'PoolDisputeInvoiceReg', '池融资商纠登记', null);
INSERT INTO `tbl_model_des` VALUES ('1B68M5US1000A4C7FCAA0000ED5BB9BB', 'scf-100', 'FactoringPoolAanwinstApply', '池融资转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B6AR772C0009BC7FCAA0000595173F9', 'scf-100', 'poolRePay', '回款专户转账', null);
INSERT INTO `tbl_model_des` VALUES ('1B6BFI4G4000A2C7FCAA00002DC2EB40', 'scf-100', 'FactoringPoolPaymentApply', '池融资回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B89ELRBM0008AC7FCAA0000628C916C', 'scf-100', 'AllowanceApply', '应收账款融资减值申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8BI0H6I002A3C7FCAA00007F24D081', 'scf-100', 'AccountsReceivableInPool', '应收账款池融资入池申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8BI7Q7M003A3C7FCAA00002575132D', 'scf-100', 'AccountsReceivableOutPool', '应收账款池融资出池申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8BIRUKS004A3C7FCAA00006FA8178E', 'scf-100', 'DebtPoolPressingApply', '应收账款池融资催收申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8BJ19M5005A3C7FCAA00009F5B4F62', 'scf-100', 'DisputePoolInvoicRemoveApply', '应收账款池融资商业纠纷登记解除申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8BRL98U006A3C7FCAA0000F06A911B', 'scf-100', 'FactoringAccountRepurApply', '应收账款融资反转让/解质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8BS4SPE007A3C7FCAA000081673C9C', 'scf-100', 'FactoringPoolBuyBackApply', '应收账款池融资反转让/解质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8EH3B7L0018AC7FCAA0000964CF945', 'scf-100', 'FactoringDebtPoolChargeOffApply', '应收账款池核销申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8GN4Q6J0008AC7FCAA0000614DFF6E', 'scf-100', 'AllowancePoolApply', '应收账款池融资减值申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8RBIFJV0009BC7FCAA000051856E24', 'scf-100', 'DebtPressingApply', '应收账款融资催收申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B8T5ANFN000A4C7FCAA00007410DC6D', 'scf-100', 'DisputeInvoicRemoveApply', '应收账款融资商业纠纷登记解除申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B90GI0KL000A3C7FCAA000023FBF6DF', 'scf-100', 'CashEqualValueRegApply', '现金等价物登记申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B92UAJG6000A4C7FCAA0000E38B3C7E', 'scf-100', 'ReversePaymentTransferApply', '应收账款融资回款专户转账申请', null);
INSERT INTO `tbl_model_des` VALUES ('1B9F8MPLC000A3C7FCAA000009C2AB8F', 'scf-100', 'DisMortgageBill', '现金等价物解押发起', null);
INSERT INTO `tbl_model_des` VALUES ('1B9FIMF66000A1C7FCAA0000DF744226', 'scf-100', 'MarginApply', '保证金追加冻结', null);
INSERT INTO `tbl_model_des` VALUES ('1BA1JN7UF000A3C7FCAA0000981B053D', 'scf-100', 'MaxBailTransferOutApply', '最高额保证金转出申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BB3CV679000A3C7FCAA0000B928D2FD', 'scf-100', 'CashPaymentApply', '应收账款融资回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BB632QHA000A3C7FCAA0000F413E3AE', 'scf-100', 'PoolReturnAccTransferApply', '应收账款池融资回款专户转账申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BDTHG6J3009A3C7FCAA0000CA75AEAB', 'scf-100', 'BillNormalQualityApply', '普通非标准仓单质押申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BE5GRGG8001A3C7FCAA000078C5FD71', 'scf-100', 'BillNormalCashLoanApply', '普通仓单放款-流贷', null);
INSERT INTO `tbl_model_des` VALUES ('1BEK1HS23003A4C7FCAA0000C5C3127F', 'scf-100', 'MultiPriceAdjustApply', '现货质押批量价格调整申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BEKO2DC7002A3C7FCAA0000DF056497', 'scf-100', 'BillNormalDeliveryApply', '非标仓单提货申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BF3IMERR000A3C7FCAA0000787E1A4D', 'scf-100', 'BillNormalAddApply', '普通非标准仓单追加', null);
INSERT INTO `tbl_model_des` VALUES ('1BF5VRTV900D9BC7FCAA0000CED48CF7', 'scf-100', 'One2OneFourDeliveryApply', '先票款后货提货申请(一对一)', null);
INSERT INTO `tbl_model_des` VALUES ('1BF6H12LH000A3C7FCAA0000BC35338E', 'scf-100', 'BillNormalUnpledgeApply', '普通非标准仓单解押申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BF8HGPRO000B2C7FCAA0000AE9AAB62', 'scf-100', 'AdjustPriceApply', '现货质押质物价格调整申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BFJFN1RJ000A3C7FCAA00006887FAB7', 'scf-100', 'BillNormalReplaceApply', '普通非标准仓单置换申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BFRHJNGI008B2C7FCAA000095CD53E1', 'scf-100', 'AdjustPriceApplicationBill', '普通仓单质物价格调整申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BG7GR8J5002A3C7FCAA000004AC5F0D', 'scf-100', 'MortgageBillLoanApply', '现货质押银承放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BG89RDSG003A3C7FCAA00008059E1C1', 'scf-100', 'DeliveryApply', '现货静态质押提货申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BHE1RT8V001A3C7FCAA000012D424DF', 'scf-200', 'N-DebtPoolPressingApply', '应收账款池融资催收申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BHEKSFDR000B2C7FCAA00004206DFA3', 'scf-100', 'AdjustPriceApplyXphh', '现货质押物价格调整', null);
INSERT INTO `tbl_model_des` VALUES ('1BHHBU7VO001B2C7FCAA000071408E48', 'scf-100', 'MultiPriceAdjustApplyXhjt', '现货质押批量价格调整(静态)', null);
INSERT INTO `tbl_model_des` VALUES ('1BHJQH3KB000B2C7FCAA0000F95926C4', 'scf-100', 'AdjustPriceApplyXhdt', '现货质押物价格调整', null);
INSERT INTO `tbl_model_des` VALUES ('1BHRL3RBM00093C7FCAA0000CDE9C248', 'scf-100', 'StockListImportApply', '现货动态库存清单导入', null);
INSERT INTO `tbl_model_des` VALUES ('1BID2VGRJ00093C7FCAA00002ED8F9D9', 'scf-100', 'MultiPriceAdjustApplyXhdt', '现货质押批量价格调整(动态)', null);
INSERT INTO `tbl_model_des` VALUES ('1BJK99426000A3C7FCAA000028E59AF3', 'scf-200', 'FactoringContApply', '应收类业务申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKI7LOA004A3C7FCAA00000CBF2CB4', 'scf-200', 'N-DebtPressingApply', '应收账款融资催收申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKIANJ3005A3C7FCAA00008B95206A', 'scf-200', 'N-DisputePoolInvoicRemoveApply', '应收账款池融资商业纠纷登记解除申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKIDIGI006A3C7FCAA0000ABB725D7', 'scf-200', 'N-AllowancePoolApply', '应收账款池融资减值申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKIK2CM008A3C7FCAA0000AA133755', 'scf-200', 'N-FactoringAccountRepurApply', '应收账款融资反转让/解质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKILRB8009A3C7FCAA0000D7969150', 'scf-200', 'N-CashPaymentApply', '应收账款融资回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKIN63J00AA3C7FCAA0000711D184F', 'scf-200', 'N-DisputeInvoiceSetApply', '应收账款融资商纠登记申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKIQTPO00BA3C7FCAA0000857935C9', 'scf-200', 'N-FactoringPoolPaymentApply', '应收账款池融资回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJ087300EA3C7FCAA0000E1079E2D', 'scf-200', 'N-FactoringAanwinstApply', '应收账款融资转让/出质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJ2IHD00FA3C7FCAA0000DD86BB3D', 'scf-200', 'N-FactoringPoolAanwinstApply', '应收账款池融资转让/出质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJ3AN900GA3C7FCAA00002E2407C3', 'scf-200', 'N-InvoiceFinancingApply', '应收账款融资放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJ5AV500HA3C7FCAA00007D480A57', 'scf-200', 'N-DisputeInvoicRemoveApply', '应收账款融资商业纠纷登记解除申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJ6P9600JA3C7FCAA0000BAE11B24', 'scf-200', 'N-PoolDisputeInvoiceReg', '应收账款池融资商纠登记申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJBNCK00MA3C7FCAA00003EA34463', 'scf-200', 'N-FactoringPoolBuyBackApply', '应收账款池融资反转让/解质申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJFAB700NA3C7FCAA00004713CD6B', 'scf-200', 'N-FactoringAccountCancelApply', '应收账款融资核销申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJK1QG00PA3C7FCAA0000776855E5', 'scf-200', 'N-AllowanceApply', '应收账款融资减值申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJL7BI00QA3C7FCAA00004086C2EC', 'scf-200', 'N-AccountsReceivableOutPool', '应收账款池融资出池申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJME8L00RA3C7FCAA000095DAE9D7', 'scf-200', 'N-AccountsReceivableInPool', '应收账款池融资入池申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJOKH500SA3C7FCAA00005F2F837F', 'scf-200', 'N-FactoringPoolChargeOffApply', '应收账款池融资核销申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJKJR8HM00UA3C7FCAA00005FA352C6', 'scf-200', 'N-FinancingPoolApply', '应收账款池融资放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJMBKKOG006A3C7FCAA000038766F80', 'scf-200', 'N-FactoringDoubleAanwinstApply', '国内双保理应收账款转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJMN6BTG008A3C7FCAA0000BE9F8782', 'scf-200', 'N-DoubleFactFinancingApply', '国内双保理融资放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJMPTKRQ009A3C7FCAA0000C3A5C920', 'scf-200', 'N-FactoringDoublePaymentApply', '国内双保理应收账款回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJON9JMI000A3C7FCAA0000309F8B68', 'scf-200', 'N-DebtDoublePressingApply', '国内双保理应收账款催收申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJONI8KB001A3C7FCAA000028F4ACD8', 'scf-200', 'N-DebtCreditPressingApply', '信保保理应收账款催收申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJONM5VT002A3C7FCAA00005611D7C4', 'scf-200', 'N-DebtLeasePressingApply', '应收租金催收申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOO442V003A3C7FCAA0000DADCFE21', 'scf-200', 'N-LeaseFactFinancingApply', '租赁保理放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOO60KU004A3C7FCAA00004B570AA7', 'scf-200', 'N-CreditFactFinancingApply', '信保保理放款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOOHCJL005A3C7FCAA000035D04F64', 'scf-200', 'N-AllowanceCreditApply', '信保保理应收账款减值申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOOID9R006A3C7FCAA00004AC746BD', 'scf-200', 'N-AllowanceDoubleApply', '国内双保理应收账款减值申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOOKFPI007A3C7FCAA0000C83EC939', 'scf-200', 'N-AllowanceLeaseApply', '应收租金减值申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOOUQDC008A3C7FCAA000075D612CB', 'scf-200', 'N-FactoringCreditBuyBackApply', '信保保理应收账款反转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOOVU9B009A3C7FCAA000009A69E6A', 'scf-200', 'N-FactoringDoubleBuyBackApply', '国内双保理应收账款反转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOP14S700AA3C7FCAA00000C4DF8FE', 'scf-200', 'N-FactoringLeaseBuyBackApply', '应收租金反转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOQ8K1S00BA3C7FCAA0000F9EFB4C0', 'scf-200', 'N-FactoringLeaseChargeOffApply', '应收租金核销申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOQ9LN300CA3C7FCAA0000952B2E6A', 'scf-200', 'N-FactoringDoubleChargeOffApply', '国内双保理应收账款核销申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOQAPB500DA3C7FCAA0000A7B15E9D', 'scf-200', 'N-FactoringCreditChargeOffApply', '信保保理应收账款核销申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOTV1S400EA3C7FCAA0000E68192A8', 'scf-200', 'N-DisputeDoubleInvoiceSetApply', '国内双保理商业纠纷登记申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOU04QN00FA3C7FCAA00004710FA8E', 'scf-200', 'N-DisputeCreditInvoiceSetApply', '信保保理商业纠纷登记申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJOU1K0400GA3C7FCAA0000D0B573C1', 'scf-200', 'N-DisputeLeaseInvoiceSetApply', '租赁保理商业纠纷登记申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJP5PCM300HA3C7FCAA0000399C43C2', 'scf-200', 'N-DisputeDoubleInvoicRemoveApply', '国内双保理商业纠纷登记解除申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJP5QD8800IA3C7FCAA0000DF87C99A', 'scf-200', 'N-DisputeCreditInvoicRemoveApply', '信保保理商业纠纷登记解除申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJP5SKEP00JA3C7FCAA000096FAD72B', 'scf-200', 'N-DisputeLeaseInvoicRemoveApply', '应收租金商业纠纷登记解除申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJP9Q1VQ00KA3C7FCAA0000963EE225', 'scf-200', 'N-FactoringCreditAanwinstApply', '信保保理应收账款转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJP9R5PR00LA3C7FCAA0000C085420C', 'scf-200', 'N-FactoringLeaseAanwinstApply', '应收租金转让申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJPA5O6L00MA3C7FCAA0000D39BA72D', 'scf-200', 'N-FactoringCreditPaymentApply', '信保保理应收账款回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BJPA86RT00NA3C7FCAA0000C0A4DED3', 'scf-200', 'N-FactoringLeasePaymentApply', '应收租金回款申请', null);
INSERT INTO `tbl_model_des` VALUES ('1BL753AC3000B2C7FCAA00001E1D7F72', 'scf-100', 'FourLoanApply', '预付类流贷放款申请', null);

-- ----------------------------
-- Table structure for `tbl_node_des`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_node_des`;
CREATE TABLE `tbl_node_des` (
  `NODE_ID` varchar(32) NOT NULL,
  `MODEL_ID` varchar(32) NOT NULL,
  `NODE_NAME` varchar(255) DEFAULT NULL,
  `NODE_SEQ` int(11) DEFAULT NULL,
  `NODE_TYPE` int(11) DEFAULT NULL,
  `NODE_STRATEGY` int(11) DEFAULT NULL,
  `EXP_PARAM` varchar(100) DEFAULT NULL,
  `EXP_DES` varchar(100) DEFAULT NULL,
  `CALLER_CLASSPATH` varchar(150) DEFAULT NULL,
  `SUB_PROCESS_MODELS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NODE_ID`,`MODEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_node_des
-- ----------------------------
INSERT INTO `tbl_node_des` VALUES ('AdjusPrice_receipt', 'AdjustPriceApplicationBill', '价格调整回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('AdjusPrice_receipt', 'AdjustPriceApply', '价格调整回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('AdjusPrice_receipt', 'AdjustPriceApplyXhdt', '回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('AdjusPrice_receipt', 'AdjustPriceApplyXphh', '回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AccountsReceivableInPool', '应收账款池融资入池审批', '2', '1', '1', null, null, 'RBcpDebtInPoolAccountServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AccountsReceivableOutPool', '回执', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AdjustPriceApplicationBill', '调价审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AdjustPriceApply', '任务审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AdjustPriceApplyXhdt', '任务审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AdjustPriceApplyXphh', '任务审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AllowanceApply', '应收账款减值申请审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'AllowancePoolApply', '应收账款池融资减值申请审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'CashEqualValueRegApply', '现金等价物登记申请审批', '2', '1', '1', null, null, 'CashEqualValueRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'DisMortgageBill', '货权内控岗审批', '2', '1', '1', null, null, 'DismortgageBillServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'DisputeInvoicRemoveApply', '应收账款融资纠纷登记解除审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'DisputePoolInvoicRemoveApply', '应收类池融资商业纠纷解除管理岗审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'DynamicQualityApply', '出质入库审核', '3', '1', '1', null, null, 'QualityApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FactoringAanwinstApply', '应收账款转让申请复核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FactoringAccountRepurApply', '应收账款融资反转让/解质申请审批', '2', '1', '1', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FactoringContApply', '应收类业务申请审批', '2', '1', '1', null, null, 'BCntBcpAppliBaseInfoServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FactoringLeaseBuyBackApply', '审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FactoringPoolAanwinstApply', '应收账款池融资转让申请复核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FactoringPoolBuyBackApply', '应收账款池融资反转让/解质申请审批', '2', '1', '1', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FourGuaBuybackApply', '审核', '2', '1', '1', null, null, 'FourGuaBuybackApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'FourhousePledgeApply', '出质入库审核', '3', '1', '1', null, null, 'FourPledgeServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'MarginApply', '审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'MaxBailTransferOutApply', '中心负责人审批', '4', '1', '1', null, null, 'MaximumBailTransferOutApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'MultiPriceAdjustApply', '批量调价审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'MultiPriceAdjustApplyXhdt', '批量调价审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'MultiPriceAdjustApplyXhjt', '批量调价审核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-AccountsReceivableInPool', '应收账款池融资入池审批', '2', '1', '1', null, null, 'DebtInPoolServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-AccountsReceivableOutPool', '应收账款池融资出池审批', '2', '1', '1', null, null, 'DebtOutPoolServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-AllowanceApply', '应收账款融资减值申请审核', '3', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-AllowanceCreditApply', '信保保理减值申请审核', '3', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-AllowanceDoubleApply', '国内双保理减值申请审核', '3', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-AllowanceLeaseApply', '应收租金减值申请审核', '3', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-AllowancePoolApply', '应收账款池融资减值申请审核', '3', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-CreditFactFinancingApply', '审核岗审批', '3', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeCreditInvoiceSetApply', '信保保理商纠登记审批', '3', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeCreditInvoicRemoveApply', '信保保理商业纠纷登记解除审核', '3', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeDoubleInvoiceSetApply', '国内双保理商纠登记审批', '3', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeDoubleInvoicRemoveApply', '国内双保理商业纠纷登记解除审核', '3', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeInvoiceSetApply', '商纠登记审批', '2', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeInvoicRemoveApply', '应收账款融资纠纷登记解除审核', '2', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeLeaseInvoiceSetApply', '租赁保理商纠登记审批', '3', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputeLeaseInvoicRemoveApply', '应收租金商业纠纷登记解除审核', '3', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DisputePoolInvoicRemoveApply', '应收账款池融资纠纷登记解除审核', '2', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-DoubleFactFinancingApply', '审核岗审批', '3', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringAanwinstApply', '应收账款转让申请复核', '2', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringAccountRepurApply', '应收账款融资反转让/解质申请审批', '3', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringCreditAanwinstApply', '信保保理应收账款转让申请复核', '3', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringCreditBuyBackApply', '信保保理反转让/解质申请审批', '3', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringDoubleAanwinstApply', '国内双保理应收账款转让申请复核', '3', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringDoubleBuyBackApply', '国内双保理反转让/解质申请审批', '3', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringLeaseAanwinstApply', '应收租金转让申请复核', '3', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringLeaseBuyBackApply', '应收租金反转让/解质申请审批', '3', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringPoolAanwinstApply', '应收账款转让申请复核', '2', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FactoringPoolBuyBackApply', '应收账款池融资反转让/解质申请审批', '3', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-FinancingPoolApply', '审核岗审批', '3', '1', '1', null, null, 'FinancingPoolCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-InvoiceFinancingApply', '审核岗审批', '3', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-LeaseFactFinancingApply', '审核岗审批', '3', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'N-PoolDisputeInvoiceReg', '商纠登记审批', '2', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'One2OneFourDeliveryApply', '业务审批', '2', '1', '1', null, null, 'FourDeliveryServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'StaticQualityApply', '出质入库审核', '3', '1', '1', null, null, 'QualityApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'StockListImportApply', '库存清单导入审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'ThreeDeliveryApply', '业务审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve', 'ThreeGuaBuybackApply', '审核', '2', '1', '1', null, null, 'ATcsThreeGuaBuyBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'BCrrDuebillApp', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'BillNormalBillLoanApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'BillNormalCashLoanApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'FinancingPoolApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'FourLoanApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'FourLoanBillApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'InvoiceFinancingApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'MortgageBillLoanApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'MortgageCashLoanApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Approve_DuebillApp', 'ThreeBillChargeOffApply', '出账申请确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('backToModify', 'StockListImportApply', '退回修改', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('BCrrDuebillApp_approve', 'BCrrDuebillApp(XD)', '出账申请确认（信贷）', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('bnode1', 'BDcrLinApp', 'bnode1', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('bnode2', 'BDcrLinApp', 'bnode2', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('bnode3', 'BDcrLinApp', 'bnode3', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('bnode4', 'BDcrLinApp', 'bnode4', '4', '3', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('bnode5', 'BDcrLinApp', 'bnode5', '5', '4', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'BillNormalAddApply', '普通仓单追加核价', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'BillNormalQualityApply', '普通仓单质押核价岗', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'BillNormalUnpledgeApply', '审批岗', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'DynamicQualityApply', '出质入库核价', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'FactoringPoolPaymentApply', '应收账款池融资复核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'FourhousePledgeApply', '出质入库核价', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'MaxBailTransferOutApply', '交易融资部贷权内控岗复核', '3', '1', '1', null, null, 'MaximumBailTransferOutApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'N-CashPaymentApply', '应收账款融资回款复核', '2', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'N-FactoringCreditPaymentApply', '信保保理应收账款回款复核', '3', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'N-FactoringDoublePaymentApply', '国内双保理应收账款回款复核', '3', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'N-FactoringLeasePaymentApply', '应收租金回款复核', '3', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'N-FactoringPoolPaymentApply', '应收账款池融资复核', '2', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'poolRePay', '回款专户转出确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'PoolReturnAccTransferApply', '应收账款融资回款专户转出确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'ReversePaymentTransferApply', '回款专户转出确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Check', 'StaticQualityApply', '出质入库核价', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('checkTransfer', 'RBcpBussAppli', '应收账款转让申请复核', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('checkTransferAgain', 'RBcpBussAppli', '应收账款转让申请回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Confirm', 'BillNormalQualityApply', '普通仓单质押回执确认', '4', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Confirm', 'BillNormalReplaceApply', '普通仓单置换回执确认', '4', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Confirm', 'BillNormalUnpledgeApply', '回执', '4', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('confirm', 'DisMortgageBill', '复核岗审批', '3', '1', '1', null, null, 'DismortgageBillServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Confirm', 'FactoringContApply', '应收类业务回执确认', '3', '1', '1', null, null, 'BCntBcpAppliBaseInfoServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('confirmTransfer', 'RBcpBussAppli', '应收账款转让申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('credictEvalNode1', 'creditEvalPrcssCreate', '申请评审', '1', '1', '1', 'bPass', 'bPass == true', null, null);
INSERT INTO `tbl_node_des` VALUES ('credictEvalNode2', 'creditEvalPrcssCreate', '执行审核', '2', '1', '1', 'bPass', 'bPass == true', null, null);
INSERT INTO `tbl_node_des` VALUES ('dcr_node1', 'BDcrLin', 'dcr_node1', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('dcr_node2', 'BDcrLin', 'dcr_node2', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('dcr_node3', 'BDcrLin', 'dcr_node3', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('dcr_node4', 'BDcrLin', 'dcr_node4', '4', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('DisputeInvoiceSetSave', 'DisputeInvoiceSetApply', '商纠保存', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('DisputeInvoiceSetSubmit', 'DisputeInvoiceSetApply', '商纠审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'BCrrDuebillApp', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'BillNormalBillLoanApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'BillNormalCashLoanApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'FinancingPoolApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'FourLoanApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'FourLoanBillApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'InvoiceFinancingApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'MortgageBillLoanApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'MortgageCashLoanApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebilladd', 'ThreeBillChargeOffApply', '供应链补录', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'BCrrDuebillApp', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'BillNormalBillLoanApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'BillNormalCashLoanApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'FinancingPoolApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'FourLoanApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'FourLoanBillApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'InvoiceFinancingApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'MortgageBillLoanApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'MortgageCashLoanApply', '出账申请复核', '3', '1', '1', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('duebillConfirm', 'ThreeBillChargeOffApply', '出账申请复核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('end', 'DisMortgageBill', '最终审批', '4', '1', '1', null, null, 'DismortgageBillServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Issued', 'BillNormalDeliveryApply', '非标仓单提货审批岗', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Issued', 'DeliveryApply', '现货静态质押提货到货赎货岗', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('LnApp_approve', 'BCrrLnApp', '经办人确认', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('LnApp_approve1', 'BCrrLnApp', '初审', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('LnApp_approve2', 'BCrrLnApp', '复审', '3', '1', '1', null, null, 'BCrrLnAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AccountsReceivableInPool', '审批通过', '3', '2', '0', null, null, 'RBcpDebtInPoolAccountServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AccountsReceivableOutPool', '审批通过', '3', '2', '0', null, null, 'RBcpDebtOutPoolServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AdjustPriceApplicationBill', '审核通过', '4', '2', '0', null, null, 'SinglePriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AdjustPriceApply', '审批通过', '4', '2', '0', null, null, 'SinglePriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AdjustPriceApplyXhdt', '审批通过', '4', '2', '0', null, null, 'SinglePriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AdjustPriceApplyXphh', '审批通过', '4', '2', '0', null, null, 'SinglePriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AllowanceApply', '审批通过', '3', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'AllowancePoolApply', '审批通过', '3', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BCrrDuebillApp', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BCrrDuebillApp(XD)', '审批通过', '2', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BCrrLnApp', '审批通过', '4', '2', '0', null, null, 'BCrrLnAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BDcrLin', '审批通过', '7', '2', '0', null, null, 'BDcrLinServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BillNormalAddApply', '审批通过', '5', '2', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BillNormalBillLoanApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BillNormalCashLoanApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BillNormalDeliveryApply', '审批通过', '4', '2', '0', null, null, 'BillNormalDeliveryApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BillNormalQualityApply', '审批通过', '5', '2', '0', null, null, 'BillNormalPledgeMngServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BillNormalReplaceApply', '审批通过', '5', '2', '0', null, null, 'BillNormalMngExcgServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'BillNormalUnpledgeApply', '审批通过', '5', '2', '0', null, null, 'BillNormalOffMngServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'CashEqualValueRegApply', '审批通过', '3', '2', '0', null, null, 'CashEqualValueRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'CashPaymentApply', '审批通过', '2', '2', '0', null, null, 'RBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'creditEvalPrcssCreate', '通过', '3', '2', '0', null, null, 'BCrgEvalRecServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DebtPoolPressingApply', '审批通过', '3', '2', '0', null, null, 'RDebtPressServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DebtPressingApply', '审批通过', '3', '2', '0', null, null, 'RDebtPressServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DeliveryApply', '现货静态提货审批通过', '4', '2', '0', null, null, 'StaticDeliveryApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DisMortgageBill', '提交审批', '5', '2', '0', null, null, 'DismortgageBillServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DisputeInvoiceSetApply', '商纠审批通过', '3', '2', '0', null, null, 'RBcpDebtDisputRegServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DisputeInvoicRemoveApply', '应收账款融资纠纷登记解除申请通过', '3', '2', '0', null, null, 'RBcpPoolDisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DisputePoolInvoicRemoveApply', '应收账款池融资商业纠纷解除申请通过', '3', '2', '0', null, null, 'RBcpPoolDisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'DynamicQualityApply', '结束', '5', '2', '0', null, null, 'QualityApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringAanwinstApply', '应收账款申请通过', '4', '2', '0', null, null, 'RBcpAppliBussInfoServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringAccountCancelApply', '应收账款核销审批通过', '3', '2', '0', null, null, 'RBcpWriteoffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringAccountRepurApply', '审批通过', '3', '2', '0', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringContApply', '审批通过', '4', '2', '0', null, null, 'BCntBcpAppliBaseInfoServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringDebtPoolChargeOffApply', '应收账款池核销审批通过', '3', '2', '0', null, null, 'RBcpWriteoffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringPoolAanwinstApply', '应收账款池融资转让申请通过', '4', '2', '0', null, null, 'RBcpAppliBussInfoServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringPoolBuyBackApply', '审批通过', '4', '2', '0', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FactoringPoolPaymentApply', '审批通过', '3', '2', '0', null, null, 'RBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FinancingPoolApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FourAccountConfirmApply', '审批通过', '3', '2', '0', null, null, 'ATcsThreeConfirmServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FourGuaBuybackApply', '审批通过', '4', '2', '0', null, null, 'FourGuaBuybackApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FourhousePledgeApply', '结束', '5', '2', '0', null, null, 'FourPledgeServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FourLoanApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'FourLoanBillApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'InvoiceFinancingApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'MarginApply', '审批通过', '3', '2', '0', null, null, 'IncimarginServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'MaxBailTransferOutApply', '审批通过', '5', '2', '0', null, null, 'MaximumBailTransferOutApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'MortgageBillLoanApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'MortgageCashLoanApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'MultiPriceAdjustApply', '审批通过', '3', '2', '0', null, null, 'PriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'MultiPriceAdjustApplyXhdt', '审批通过', '4', '2', '0', null, null, 'PriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'MultiPriceAdjustApplyXhjt', '审批通过', '4', '2', '0', null, null, 'PriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-AccountsReceivableInPool', '审批通过', '3', '2', '0', null, null, 'DebtInPoolServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-AccountsReceivableOutPool', '审批通过', '3', '2', '0', null, null, 'DebtOutPoolServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-AllowanceApply', '审批通过', '4', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-AllowanceCreditApply', '审批通过', '4', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-AllowanceDoubleApply', '审批通过', '4', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-AllowanceLeaseApply', '审批通过', '4', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-AllowancePoolApply', '审批通过', '4', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-CashPaymentApply', '审批通过', '3', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-CreditFactFinancingApply', '审批通过', '4', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DebtCreditPressingApply', '审批通过', '4', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DebtDoublePressingApply', '审批通过', '4', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DebtLeasePressingApply', '审批通过', '4', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DebtPoolPressingApply', '审批通过', '4', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DebtPressingApply', '审批通过', '4', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeCreditInvoiceSetApply', '审批通过', '4', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeCreditInvoicRemoveApply', '审批通过', '4', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeDoubleInvoiceSetApply', '审批通过', '4', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeDoubleInvoicRemoveApply', '审批通过', '4', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeInvoiceSetApply', '商纠审批通过', '3', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeInvoicRemoveApply', '审批通过', '3', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeLeaseInvoiceSetApply', '审批通过', '4', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputeLeaseInvoicRemoveApply', '审批通过', '4', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DisputePoolInvoicRemoveApply', '应收账款池融资纠纷登记解除申请通过', '3', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-DoubleFactFinancingApply', '审批通过', '4', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringAanwinstApply', '通过', '4', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringAccountCancelApply', '审批通过', '4', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringAccountRepurApply', '审批通过', '4', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringCreditAanwinstApply', '审批通过', '4', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringCreditBuyBackApply', '审批通过', '4', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringCreditChargeOffApply', '审批通过', '4', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringCreditPaymentApply', '审批通过', '4', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringDoubleAanwinstApply', '审批通过', '4', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringDoubleBuyBackApply', '审批通过', '4', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringDoubleChargeOffApply', '审批通过', '4', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringDoublePaymentApply', '审批通过', '4', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringLeaseAanwinstApply', '审批通过', '4', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringLeaseBuyBackApply', '审批通过', '4', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringLeaseChargeOffApply', '审批通过', '4', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringLeasePaymentApply', '审批通过', '4', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringPoolAanwinstApply', '审批通过通过', '4', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringPoolBuyBackApply', '审批通过', '4', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringPoolChargeOffApply', '审批通过', '4', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FactoringPoolPaymentApply', '审批通过', '3', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-FinancingPoolApply', '审批通过', '4', '2', '0', null, null, 'FinancingPoolCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-InvoiceFinancingApply', '审批通过', '4', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-LeaseFactFinancingApply', '审批通过', '4', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'N-PoolDisputeInvoiceReg', '商纠审批通过', '3', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'One2OneFourDeliveryApply', '审批通过', '4', '2', '0', null, null, 'FourDeliveryServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'PoolDisputeInvoiceReg', '池融资商纠审批通过', '3', '2', '0', null, null, 'RBcpDebtDisputRegServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Pass', 'poolRePay', '结束', '3', '2', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'PoolReturnAccTransferApply', '审批通过', '3', '2', '0', null, null, 'RBcpPoolRePayServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'ProtocolAmountApply', '审批通过', '4', '2', '0', null, null, 'SBcpAppliLowerPriceServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'RBcpBussAppli', '应收账款转让申请通过', '4', '2', '0', null, null, 'RBcpAppliBussInfoServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'RBcpImpairment', '审批通过', '2', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'RBcpImpairmentPool', '申请通过', '2', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'repayment', '审批通过', '2', '2', '0', null, null, 'RBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'ReversePaymentTransferApply', '回款专户转出确认通过', '3', '2', '0', null, null, 'RBcpPoolRePayServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'StaticQualityApply', '通过', '5', '2', '0', null, null, 'QualityApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'StockListImportApply', '结束', '3', '2', '0', null, null, 'StockListImportApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'ThreeAccountConfirmApply', '审批通过', '3', '2', '0', null, null, 'ATcsThreeConfirmServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'ThreeBillChargeOffApply', '审批通过', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'ThreeDeliveryApply', '审批通过', '4', '2', '0', null, null, 'ATcsThreeDeliveryServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('pass', 'ThreeGuaBuybackApply', '审批通过', '4', '2', '0', null, null, 'ATcsThreeGuaBuyBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('PoolDisputeInvoiceApprove', 'PoolDisputeInvoiceReg', '池融资商纠审批', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Pricing', 'BillNormalReplaceApply', '普通仓单置换核价岗', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'BillNormalAddApply', '普通仓单追加监管商回执', '4', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'BillNormalDeliveryApply', '回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'DebtPoolPressingApply', '通知书回执确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'DebtPressingApply', '通知书回执确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'DeliveryApply', '现货静态质押提货回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'DynamicQualityApply', '出质入库确认', '4', '1', '1', null, null, 'QualityApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FactoringAanwinstApply', '应收账款转让申请回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FactoringAccountCancelApply', '应收账款核销回执确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FactoringDebtPoolChargeOffApply', '应收账款池核销回执确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FactoringLeaseBuyBackApply', '通知书回执', '3', '2', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FactoringPoolAanwinstApply', '应收账款池融资转让申请回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FourAccountConfirmApply', '通知书回执确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FourGuaBuybackApply', '通知书回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'FourhousePledgeApply', '出质入库确认', '4', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-DebtCreditPressingApply', '信保保理催收回执确认', '3', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-DebtDoublePressingApply', '国内双保理催收回执确认', '3', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-DebtLeasePressingApply', '应收租金催收回执确认', '3', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-DebtPoolPressingApply', '应收账款池融资催收回执确认', '3', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-DebtPressingApply', '应收账款融资催收回执确认', '3', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-FactoringAanwinstApply', '应收账款转让申请回执确认', '3', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-FactoringAccountCancelApply', '应收账款融资核销回执确认', '3', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-FactoringCreditChargeOffApply', '信保保理应收账款核销回执确认', '3', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-FactoringDoubleChargeOffApply', '国内双保理应收账款核销回执确认', '3', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-FactoringLeaseChargeOffApply', '应收租金核销回执确认', '3', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-FactoringPoolAanwinstApply', '应收账款转让申请回执确认', '3', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'N-FactoringPoolChargeOffApply', '应收账款池融资核销回执确认', '3', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'One2OneFourDeliveryApply', '通知书回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'StaticQualityApply', '出质入库确认', '4', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'ThreeAccountConfirmApply', '通知书回执确认', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'ThreeDeliveryApply', '通知书回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Receipt', 'ThreeGuaBuybackApply', '通知书回执确认', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'AccountsReceivableInPool', '否决', '3', '2', '0', null, null, 'RBcpDebtInPoolAccountServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'AllowanceApply', '审批否决', '3', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'AllowancePoolApply', '审批否决', '3', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'BCrrDuebillApp', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'BCrrDuebillApp(XD)', '否决', '2', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'BCrrLnApp', '否决', '4', '2', '0', null, null, 'BCrrLnAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'BDcrLin', '否决', '7', '2', '0', null, null, 'BDcrLinServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'BillNormalBillLoanApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'BillNormalQualityApply', '审批否决', '5', '2', '0', null, null, 'BillNormalPledgeMngServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'CashEqualValueRegApply', '审批否决', '3', '2', '0', null, null, 'CashEqualValueRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'CashPaymentApply', '审批否决', '2', '2', '0', null, null, 'RBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'creditEvalPrcssCreate', '通过', '4', '2', '0', null, null, 'BCrgEvalRecServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'DebtPressingApply', '否决', '3', '2', '0', null, null, 'RDebtPressServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'DisputeInvoiceSetApply', '商纠审批拒绝', '3', '2', '0', null, null, 'RBcpDebtDisputRegServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'FactoringAccountRepurApply', '否决', '3', '2', '0', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'FactoringContApply', '审批否决', '5', '2', '0', null, null, 'BCntBcpAppliBaseInfoServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'FactoringPoolBuyBackApply', '否决', '4', '2', '0', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'FactoringPoolPaymentApply', '审批否决', '4', '2', '0', null, null, 'RBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'FinancingPoolApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'FourLoanApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'FourLoanBillApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'InvoiceFinancingApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'MarginApply', '审批否决', '3', '2', '0', null, null, 'IncimarginServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'MortgageBillLoanApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'MortgageCashLoanApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'MultiPriceAdjustApply', '审批否决', '3', '2', '0', null, null, 'PriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'MultiPriceAdjustApplyXhdt', '审批否决', '3', '2', '0', null, null, 'PriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'MultiPriceAdjustApplyXhjt', '审批否决', '3', '2', '0', null, null, 'PriceAdjustServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-AccountsReceivableInPool', '否决', '4', '2', '0', null, null, 'DebtInPoolServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-AccountsReceivableOutPool', '审批否决', '4', '2', '0', null, null, 'DebtOutPoolServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-AllowanceApply', '审批否决', '5', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-AllowanceCreditApply', '审批否决', '5', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-AllowanceDoubleApply', '审批否决', '5', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-AllowanceLeaseApply', '审批否决', '5', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-AllowancePoolApply', '审批否决', '5', '2', '0', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-CashPaymentApply', '审批否决', '4', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-CreditFactFinancingApply', '否决', '5', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DebtCreditPressingApply', '否决', '5', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DebtDoublePressingApply', '否决', '5', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DebtLeasePressingApply', '否决', '5', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DebtPoolPressingApply', '否决', '4', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DebtPressingApply', '否决', '5', '2', '0', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeCreditInvoiceSetApply', '否决', '5', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeCreditInvoicRemoveApply', '否决', '5', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeDoubleInvoiceSetApply', '否决', '5', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeDoubleInvoicRemoveApply', '否决', '5', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeInvoiceSetApply', '商纠审批拒绝', '4', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeInvoicRemoveApply', '否决', '4', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeLeaseInvoiceSetApply', '否决', '5', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputeLeaseInvoicRemoveApply', '否决', '5', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DisputePoolInvoicRemoveApply', '应收账款池融资纠纷登记解除申请否决', '4', '2', '0', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-DoubleFactFinancingApply', '否决', '5', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringAanwinstApply', '否决', '5', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringAccountCancelApply', '审批否决', '5', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringAccountRepurApply', '否决', '5', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringCreditAanwinstApply', '否决', '5', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringCreditBuyBackApply', '否决', '5', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringCreditChargeOffApply', '审批否决', '5', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringCreditPaymentApply', '否决', '5', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringDoubleAanwinstApply', '否决', '5', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringDoubleBuyBackApply', '否决', '5', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringDoubleChargeOffApply', '审批否决', '5', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringDoublePaymentApply', '否决', '5', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringLeaseAanwinstApply', '否决', '5', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringLeaseBuyBackApply', '否决', '5', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringLeaseChargeOffApply', '审批否决', '5', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringLeasePaymentApply', '否决', '5', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringPoolAanwinstApply', '否决', '5', '2', '0', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringPoolBuyBackApply', '否决', '5', '2', '0', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringPoolChargeOffApply', '审批否决', '5', '2', '0', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FactoringPoolPaymentApply', '审批否决', '4', '2', '0', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-FinancingPoolApply', '否决', '5', '2', '0', null, null, 'FinancingPoolCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-InvoiceFinancingApply', '否决', '5', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-LeaseFactFinancingApply', '否决', '5', '2', '0', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'N-PoolDisputeInvoiceReg', '商纠审批拒绝', '4', '2', '0', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'PoolDisputeInvoiceReg', '池融资商纠审批拒绝', '3', '2', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'ProtocolAmountApply', '否决', '4', '2', '0', null, null, 'SBcpAppliLowerPriceServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'RBcpImpairment', '否决', '2', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'RBcpImpairmentPool', '否决', '2', '2', '0', null, null, 'RBcpImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'repayment', '审批否决', '3', '2', '0', null, null, 'RBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('reject', 'ThreeBillChargeOffApply', '否决', '4', '2', '0', null, null, 'BCrrDuebillAppServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('repayment_1', 'repayment', '应收账款管理岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('request', 'RBcpImpairment', '减值申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('request', 'RBcpImpairmentPool', '减值申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Review', 'BillNormalAddApply', '普通仓单追加审核', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Review', 'BillNormalQualityApply', '普通仓单质押经办行复核岗', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Review', 'BillNormalReplaceApply', '普通仓单置换复核岗', '3', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Review', 'BillNormalUnpledgeApply', '复核岗', '2', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Review', 'MaxBailTransferOutApply', '经办机构审查岗复核', '2', '1', '1', null, null, 'MaximumBailTransferOutApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('sbcpappli_approve', 'ProtocolAmountApply', '最低控货价值调整申请', '1', '1', '1', null, null, 'SBcpAppliLowerPriceServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('sbcpappli_check', 'ProtocolAmountApply', '最低控货价值调整复核', '2', '1', '1', null, null, 'SBcpAppliLowerPriceServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('sbcpappli_confirm', 'ProtocolAmountApply', '最低控货价值调整回执确认', '3', '1', '1', null, null, 'SBcpAppliLowerPriceServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('start', 'FactoringContApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-AllowanceApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-AllowanceCreditApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-AllowanceDoubleApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-AllowanceLeaseApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-AllowancePoolApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-CreditFactFinancingApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DebtCreditPressingApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DebtDoublePressingApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DebtLeasePressingApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DebtPoolPressingApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DebtPressingApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DisputeCreditInvoiceSetApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DisputeCreditInvoicRemoveApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DisputeDoubleInvoiceSetApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DisputeDoubleInvoicRemoveApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DisputeLeaseInvoiceSetApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DisputeLeaseInvoicRemoveApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-DoubleFactFinancingApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringAccountCancelApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringAccountRepurApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringCreditAanwinstApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringCreditBuyBackApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringCreditChargeOffApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringCreditPaymentApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringDoubleAanwinstApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringDoubleBuyBackApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringDoubleChargeOffApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringDoublePaymentApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringLeaseAanwinstApply', '开始流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringLeaseBuyBackApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringLeaseChargeOffApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringLeasePaymentApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringPoolBuyBackApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FactoringPoolChargeOffApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-FinancingPoolApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-InvoiceFinancingApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('start', 'N-LeaseFactFinancingApply', '发起流程', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AccountsReceivableInPool', '应收账款池融资入池申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AccountsReceivableOutPool', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AdjustPriceApplicationBill', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AdjustPriceApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AdjustPriceApplyXhdt', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AdjustPriceApplyXphh', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AllowanceApply', '应收账款减值申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'AllowancePoolApply', '应收账款池融资减值申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'BillNormalAddApply', '普通仓单追加填写岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'BillNormalDeliveryApply', '非标仓单提货申请岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'BillNormalQualityApply', '普通仓单质押填写岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'BillNormalReplaceApply', '普通仓单置换填写岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'BillNormalUnpledgeApply', '经办岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'CashEqualValueRegApply', '现金等价物登记', '1', '1', '1', null, null, 'CashEqualValueRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'CashPaymentApply', '应收账款管理岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'DebtPoolPressingApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'DebtPressingApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'DeliveryApply', '现货静态质押提货填写岗', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'DisMortgageBill', '现金等价物解押发起填写', '1', '1', '1', null, null, 'DismortgageBillServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'DisputeInvoicRemoveApply', '应收账款融资纠纷登记解除申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'DisputePoolInvoicRemoveApply', '应收账款池融资商业纠纷登记解除申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'DynamicQualityApply', '出质入库申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringAanwinstApply', '应收账款转让申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringAccountCancelApply', '应收账款核销申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringAccountRepurApply', '应收账款融资反转让/解质申请复核', '1', '1', '1', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringDebtPoolChargeOffApply', '应收账款池核销申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringLeaseBuyBackApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringPoolAanwinstApply', '应收账款池融资转让申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringPoolBuyBackApply', '应收账款池融资反转让/解质申请复核', '1', '1', '1', null, null, 'FactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FactoringPoolPaymentApply', '应收账款池融资回款申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FourAccountConfirmApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FourGuaBuybackApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'FourhousePledgeApply', '出质入库申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'MarginApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'MaxBailTransferOutApply', '保证金转出申请录入提交申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'MultiPriceAdjustApply', '批量调价申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'MultiPriceAdjustApplyXhdt', '批量调价申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'MultiPriceAdjustApplyXhjt', '批量调价申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-AccountsReceivableInPool', '应收账款池融资入池申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-AccountsReceivableOutPool', '应收账款池融资出池申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-AllowanceApply', '应收账款融资减值申请', '2', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-AllowanceCreditApply', '信保保理减值申请', '2', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-AllowanceDoubleApply', '国内双保理减值申请', '2', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-AllowanceLeaseApply', '应收租金减值申请', '2', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-AllowancePoolApply', '应收账款池融资减值申请', '2', '1', '1', null, null, 'NDebtImpairmentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-CashPaymentApply', '应收账款管理岗', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-CreditFactFinancingApply', '供应链补录', '2', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DebtCreditPressingApply', '信保保理催收申请', '2', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DebtDoublePressingApply', '国内双保理催收申请', '2', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DebtLeasePressingApply', '应收租金催收申请', '2', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DebtPoolPressingApply', '应收账款池融资催收申请', '2', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DebtPressingApply', '应收账款融资催收申请', '2', '1', '1', null, null, 'NDebtPressApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeCreditInvoiceSetApply', '信保保理商纠登记申请', '2', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeCreditInvoicRemoveApply', '信保保理商业纠纷登记解除申请', '2', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeDoubleInvoiceSetApply', '国内双保理商纠登记申请', '2', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeDoubleInvoicRemoveApply', '国内双保理商业纠纷登记解除申请', '2', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeInvoiceSetApply', '商纠登记申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeInvoicRemoveApply', '应收账款融资纠纷登记解除申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeLeaseInvoiceSetApply', '租赁保理商纠登记申请', '2', '1', '1', null, null, 'DisputeRegisterServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputeLeaseInvoicRemoveApply', '应收租金商业纠纷登记解除申请', '2', '1', '1', null, null, 'DisputeRemoveServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DisputePoolInvoicRemoveApply', '应收账款池融资纠纷登记解除申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-DoubleFactFinancingApply', '供应链补录', '2', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringAanwinstApply', '应收账款转让申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringAccountCancelApply', '应收账款融资核销申请', '2', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringAccountRepurApply', '应收账款融资反转让/解质申请复核', '2', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringCreditAanwinstApply', '信保保理应收账款转让申请', '2', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringCreditBuyBackApply', '信保保理反转让/解质申请复核', '2', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringCreditChargeOffApply', '信保保理应收账款核销申请', '2', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringCreditPaymentApply', '信保保理应收账款回款申请', '2', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringDoubleAanwinstApply', '国内双保理应收账款转让申请', '2', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringDoubleBuyBackApply', '国内双保理反转让/解质申请复核', '2', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringDoubleChargeOffApply', '国内双保理应收账款核销申请', '2', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringDoublePaymentApply', '国内双保理应收账款回款申请', '2', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringLeaseAanwinstApply', '应收租金转让申请', '2', '1', '1', null, null, 'TransferApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringLeaseBuyBackApply', '应收租金反转让/解质申请复核', '2', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringLeaseChargeOffApply', '应收租金核销申请', '2', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringLeasePaymentApply', '应收租金回款申请', '2', '1', '1', null, null, 'NRBcpPaymentServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringPoolAanwinstApply', '应收账款转让申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringPoolBuyBackApply', '应收账款池融资反转让/解质申请复核', '2', '1', '1', null, null, 'NFactoringDebtBackServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringPoolChargeOffApply', '应收账款池融资核销申请', '2', '1', '1', null, null, 'FactoringChargeOffServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FactoringPoolPaymentApply', '应收账款池融资回款申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-FinancingPoolApply', '供应链补录', '2', '1', '1', null, null, 'FinancingPoolCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-InvoiceFinancingApply', '供应链补录', '2', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-LeaseFactFinancingApply', '供应链补录', '2', '1', '1', null, null, 'InvoiceFinancingCashServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'N-PoolDisputeInvoiceReg', '商纠登记申请', '1', '0', '0', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'One2OneFourDeliveryApply', '提货申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'PoolDisputeInvoiceReg', '池融资商业纠纷申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'poolRePay', '回款专户转出申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'PoolReturnAccTransferApply', '应收账款池融资回款专户转账申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'ReversePaymentTransferApply', '回款专户转账申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'StaticQualityApply', '出质入库申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'StockListImportApply', '库存清单导入申请', '1', '1', '1', null, null, 'StockListImportApplyServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'ThreeAccountConfirmApply', '申请', '1', '1', '1', null, null, null, null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'ThreeDeliveryApply', '提货申请', '1', '1', '1', null, null, 'ATcsThreeDeliveryServiceImpl', null);
INSERT INTO `tbl_node_des` VALUES ('Write', 'ThreeGuaBuybackApply', '申请', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `tbl_repeat_task`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_repeat_task`;
CREATE TABLE `tbl_repeat_task` (
  `TASK_ID` varchar(32) NOT NULL,
  `PROCESS_ID` varchar(32) DEFAULT NULL,
  `NODE_ID` varchar(32) DEFAULT NULL,
  `TASK_NAME` varchar(255) DEFAULT NULL,
  `TASK_FLAG` int(11) DEFAULT NULL,
  `ASSIGN_ID` varchar(32) DEFAULT NULL,
  `TASK_DESCRIPTION` varchar(255) DEFAULT NULL,
  `TASK_COMMENT` varchar(255) DEFAULT NULL,
  `CREATE_TIME` varchar(32) DEFAULT NULL,
  `TAKED_TIME` varchar(32) DEFAULT NULL,
  `DEAL_TIME` varchar(32) DEFAULT NULL,
  `NAME1` varchar(255) DEFAULT NULL,
  `NAME2` varchar(255) DEFAULT NULL,
  `NAME3` varchar(255) DEFAULT NULL,
  `NAME4` varchar(255) DEFAULT NULL,
  `NAME5` varchar(255) DEFAULT NULL,
  `NAME6` varchar(255) DEFAULT NULL,
  `NAME7` varchar(255) DEFAULT NULL,
  `NAME8` varchar(255) DEFAULT NULL,
  `TASK_MARK` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_repeat_task
-- ----------------------------
INSERT INTO `tbl_repeat_task` VALUES ('bcrrduebillapp_approve', '69b37cbee8c645e7a4269ad4e062df91', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '2', '88888888', null, 'aaaaa', '2018-04-03 11:39:17', '2018-04-03 13:49:30', '2018-04-03 13:49:32', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', 'DG', '02', null, 'f34fe8f841ad4baf8e183c8afd6c5a3a');

-- ----------------------------
-- Table structure for `tbl_serprocess`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_serprocess`;
CREATE TABLE `tbl_serprocess` (
  `PROCESS_ID` varchar(32) NOT NULL,
  `PROCESS_NAME` varchar(255) DEFAULT NULL,
  `BIZ_ID` varchar(40) DEFAULT NULL,
  `NODE_ID` varchar(32) DEFAULT NULL,
  `NODE_NAME` varchar(255) DEFAULT NULL,
  `PROCESS_BYTE` longblob,
  `START_DATE` varchar(32) DEFAULT NULL,
  `END_DATE` varchar(32) DEFAULT NULL,
  `STARTED_USER` varchar(32) DEFAULT NULL,
  `MODEL_ID` varchar(32) DEFAULT NULL,
  `SUPER_PROCESS_ID` varchar(32) DEFAULT NULL,
  `RUN_FLAG` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`PROCESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_serprocess
-- ----------------------------
INSERT INTO `tbl_serprocess` VALUES ('02093a6020734a60acf331ca7744a094', '贷款业务', 'LNAPP2018030700488', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333037303034383874000F433230313830333033303030323930740003313233740009424372724C6E4170707400046D656E677400124C4E415050323031383033303730303438387372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203032303933613630323037333461363061636633333163613737343461303934707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161FEF88FD9787371007E001E770800000161FEF88FD978740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D30372031333A33383A3539707400124C4E4150503230313830333037303034383874000F433230313830333033303030323930740003313233740009424372724C6E4170707400046D656E6770707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D30372031333A33383A3031707400124C4E4150503230313830333037303034383874000F433230313830333033303030323930740003313233740009424372724C6E4170707400046D656E6770707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D30372031333A33363A3533707400124C4E4150503230313830333037303034383874000F433230313830333033303030323930740003313233740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E770800000161FEF659A878740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-07 13:36:53', '2018-03-07 13:39:18', '008', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('0d6e979355134535a05b535f77af7d10', '信用评估流程创建', 'XYPJ201804030000004', 'pass', '通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400135859504A32303138303430333030303030303474000F433230313830333235303030313034740012E5A3ABE5A4A7E5A4ABE5A4A7E5B888E582857400156372656469744576616C5072637373437265617465740009E79C8BE6B581E7A88B7400135859504A3230313830343033303030303030347372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A65637474000470617373740006E9809AE8BF8771007E00077400203064366539373933353531333435333561303562353335663737616637643130707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628AF23C8F787371007E001E7708000001628AF23C8F787400156372656469744576616C50726373734372656174657371007E00183F4000000000000677080000000800000004740010637265646963744576616C4E6F6465317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000017371007E00183F4000000000000077080000000100000001737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000074000D6250617373203D3D2074727565787400056250617373740010637265646963744576616C4E6F64653271007E002374000CE794B3E8AFB7E8AF84E5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646531707400106372656469744576616C5461736B30317074000CE68F90E4BAA4E794B3E8AFB770707371007E00300000000077040000000078787371007E00300000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30332031373A35383A3034707400135859504A32303138303430333030303030303474000F433230313830333235303030313034740012E5A3ABE5A4A7E5A4ABE5A4A7E5B888E582857400156372656469744576616C50726373734372656174657070740001327071007E002371007E001D70707071007E00367071007E00377871007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E9809AE8BF8771007E000771007E001D7071007E002E7371007E0024000000010100000001707371007E0016000000017371007E00183F400000000000007708000000010000000171007E002B74000D6250617373203D3D207472756578740005625061737371007E001B71007E002E74000CE689A7E8A18CE5AEA1E6A0B871007E000771007E001D700000000100000000707371007E0030000000017704000000017371007E00320000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646532707400106372656469744576616C5461736B30327074000CE4BFA1E794A8E8AF84E5AEA170707371007E00300000000077040000000078787371007E0030000000017704000000017371007E003A000000010000000070740013323031382D30342D30332031373A35383A3435707400135859504A32303138303430333030303030303474000F433230313830333235303030313034740012E5A3ABE5A4A7E5A4ABE5A4A7E5B888E582857400156372656469744576616C5072637373437265617465740009E79C8BE6B581E7A88B70707071007E002E71007E001D70707071007E00507071007E00517871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D740018E4BFA1E794A8E8AF84E4BCB0E6B581E7A88BE5889BE5BBBA7371007E00300000000377040000000371007E002371007E002E71007E001B787371007E001E7708000001628AF131B2787400083838383838383838707371007E00183F400000000000007708000000010000000078, '2018-04-03 17:58:05', '2018-04-03 17:59:13', '88888888', 'creditEvalPrcssCreate', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('0f887815d80647178bfd919b83aab4c9', '信用评估流程创建', 'XYPJ201804020000003', 'pass', '通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400135859504A32303138303430323030303030303374000F43323031383033323030303030323174000777616E6779616E7400156372656469744576616C5072637373437265617465740009E79C8BE6B581E7A88B7400135859504A3230313830343032303030303030337372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A65637474000470617373740006E9809AE8BF8771007E00077400203066383837383135643830363437313738626664393139623833616162346339707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016285332470787371007E001E77080000016285332470787400156372656469744576616C50726373734372656174657371007E00183F4000000000000677080000000800000004740010637265646963744576616C4E6F6465317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000017371007E00183F4000000000000077080000000100000001737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000074000D6250617373203D3D2074727565787400056250617373740010637265646963744576616C4E6F64653271007E002374000CE794B3E8AFB7E8AF84E5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646531707400106372656469744576616C5461736B30317074000CE68F90E4BAA4E794B3E8AFB770707371007E00300000000077040000000078787371007E00300000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30322031353A30353A3437707400135859504A32303138303430323030303030303374000F43323031383033323030303030323174000777616E6779616E7400156372656469744576616C50726373734372656174657070707071007E002371007E001D70707071007E00367071007E00377871007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E9809AE8BF8771007E000771007E001D7071007E002E7371007E0024000000010100000001707371007E0016000000017371007E00183F400000000000007708000000010000000171007E002B74000D6250617373203D3D207472756578740005625061737371007E001B71007E002E74000CE689A7E8A18CE5AEA1E6A0B871007E000771007E001D700000000100000000707371007E0030000000017704000000017371007E00320000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646532707400106372656469744576616C5461736B30327074000CE4BFA1E794A8E8AF84E5AEA170707371007E00300000000077040000000078787371007E0030000000017704000000017371007E003A000000010000000070740013323031382D30342D30322031353A31303A3039707400135859504A32303138303430323030303030303374000F43323031383033323030303030323174000777616E6779616E7400156372656469744576616C5072637373437265617465740009E79C8BE6B581E7A88B70707071007E002E71007E001D70707071007E004F7071007E00507871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D740018E4BFA1E794A8E8AF84E4BCB0E6B581E7A88BE5889BE5BBBA7371007E00300000000377040000000371007E002371007E002E71007E001B787371007E001E770800000162852D1CE3787400083838383838383838707371007E00183F400000000000007708000000010000000078, '2018-04-02 15:05:49', '2018-04-02 15:12:24', '88888888', 'creditEvalPrcssCreate', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('17f10f77dc654a5e861173544809f785', '授信额度申请', 'CRAPP20180305000000163', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033303530303030303031363374000F43323031383033303330303032393474000474657374740007424463724C696E7400046D656E67740016435241505032303138303330353030303030303136337372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203137663130663737646336353461356538363131373335343438303966373835707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161F5FDD71A787371007E001E770800000161F5FDD71A78740007424463724C696E7371007E00183F40000000000006770800000008000000067400096463725F6E6F6465317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F400000000000007708000000010000000078707400096463725F6E6F64653271007E00237400096463725F6E6F64653171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D30352030393A33353A3434707400164352415050323031383033303530303030303031363374000F43323031383033303330303032393474000474657374740007424463724C696E7070707071007E002371007E001D70707071007E00317071007E00327871007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D707400096463725F6E6F6465347371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E00407400096463725F6E6F64653471007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646534707400056E6F6465347074000CE58886E8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D30352031393A34383A3130707400164352415050323031383033303530303030303031363374000F43323031383033303330303032393474000474657374740007424463724C696E7400046D656E6770707071007E004071007E001D70707071007E00497071007E004A787400096463725F6E6F6465337371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E00547400096463725F6E6F64653371007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D30352031393A34323A3334707400164352415050323031383033303530303030303031363374000F43323031383033303330303032393474000474657374740007424463724C696E7400046D656E6770707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D7071007E00297371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E005471007E00297400096463725F6E6F64653271007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D30352031393A34303A3438707400164352415050323031383033303530303030303031363374000F43323031383033303330303032393474000474657374740007424463724C696E7400046D656E6770707071007E002971007E001D70707071007E00717071007E0072787871007E001D740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E002B0000000577040000000571007E002371007E002971007E005471007E004071007E001B787371007E001E770800000161F3CCDB2D78740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-05 09:35:44', '2018-03-05 19:48:29', '008', 'BDcrLin', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('19a802007c5744ab826f25c11b59d84e', '出账申请（信贷）', 'DUAPP201803300000002', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000004740014445541505032303138303333303030303030303274000F43323031383033323030303030323174000777616E6779616E7400124243727244756562696C6C4170702858442974001444554150503230313830333330303030303030327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007870740004706173737400164243727244756562696C6C4170705F617070726F766574001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC8971007E0007740020313961383032303037633537343461623832366632356331316235396438346570000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30332031313A32323A32377071007E000A71007E000B71007E000C71007E000D7070707071007E001B71007E001D7070707400166263727264756562696C6C6170705F617070726F76657074001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC89737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400124243727244756562696C6C417070285844297400164243727244756562696C6C4170705F617070726F76657071007E00217071007E002270707371007E00230000000077040000000078787371007E00230000000177040000000171007E001F787372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628986FF0A78707400124243727244756562696C6C417070285844297371007E00183F4000000000000C7708000000100000000371007E001B7371007E000F0000000101000000017071007E001771007E001A71007E001B71007E001C71007E000771007E001D7000000001000000007071007E002471007E002A74000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0011000000010100000002707371007E0016000000007371007E00183F400000000000107708000000100000000078707071007E0030740006E590A6E586B371007E000771007E001D7071007E001A7371007E0031000000010100000002707371007E0016000000007371007E00183F4000000000001077080000001000000000787071007E003071007E001A74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001D707871007E001D740018E587BAE8B4A6E794B3E8AFB7EFBC88E4BFA1E8B4B7EFBC897371007E00230000000177040000000171007E001B7871007E002C7400083838383838383838707371007E00183F400000000000107708000000100000000078, '2018-04-03 11:22:28', null, '88888888', 'BCrrDuebillApp(XD)', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('36337f68b5e344c09874606a534c3dfe', '授信额度申请', 'CRAPP20180321000000176', 'dcr_node4', 'dcr_node4', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033323130303030303031373674000F43323031383033313630303033313374000471717171740007424463724C696E7400046D656E67740016435241505032303138303332313030303030303137367372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000000770800000001000000007870740004706173737400096463725F6E6F6465347400096463725F6E6F64653471007E0007740020333633333766363862356533343463303938373436303661353334633364666570000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D32312031393A35303A33347071007E000A71007E000B71007E000C71007E000D71007E000E70707071007E001C71007E001E7070707400056E6F6465347074000CE58886E8A18CE5AEA1E689B9737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F6465347071007E00227071007E002370707371007E00240000000077040000000078787371007E00240000000177040000000171007E0020787372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016248657F107870740007424463724C696E7371007E00193F40000000000006770800000008000000067400096463725F6E6F6465317371007E0010000000010100000001707371007E0017000000007371007E00193F400000000000007708000000010000000078707400096463725F6E6F64653271007E00307400096463725F6E6F64653171007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D32312031393A34383A3439707400164352415050323031383033323130303030303031373674000F43323031383033313630303033313374000471717171740007424463724C696E7070707071007E003071007E001E70707071007E003A7071007E003B7874000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E0044740006E590A6E586B371007E000771007E001E7071007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002B7400096463725F6E6F6465337371007E0010000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E001C71007E004B7400096463725F6E6F64653371007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D32312031393A34393A3538707400164352415050323031383033323130303030303031373674000F43323031383033313630303033313374000471717171740007424463724C696E7400046D656E6770707071007E004B71007E001E70707071007E00547071007E00557871007E00347371007E0010000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004B71007E00347400096463725F6E6F64653271007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D32312031393A34393A3333707400164352415050323031383033323130303030303031373674000F43323031383033313630303033313374000471717171740007424463724C696E7400046D656E6770707071007E003471007E001E70707071007E00677071007E00687871007E001B7371007E0045000000010100000002707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004471007E001B74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E707871007E001E740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E00240000000477040000000471007E003071007E003471007E004B71007E001C787371007E002C7708000001624863E58F78740003303038707371007E00193F400000000000007708000000010000000078, '2018-03-21 19:48:49', null, '008', 'BDcrLin', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('3a8a3da8e08249459f573f5115d00355', '贷款业务', 'LNAPP2018032100503', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333231303035303374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E677400124C4E415050323031383033323130303530337372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203361386133646138653038323439343539663537336635313135643030333535707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016247B1466C787371007E001E77080000016247B1466C78740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D32312031363A33333A3238707400124C4E4150503230313830333231303035303374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D32312031363A33333A3137707400124C4E4150503230313830333231303035303374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D32312031363A33323A3537707400124C4E4150503230313830333231303035303374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E77080000016247B0960178740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-21 16:32:57', '2018-03-21 16:33:43', '008', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('4d2a4ed671eb408cb6d0cda925489d89', '授信额度申请', 'CRAPP20180305000000164', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033303530303030303031363474000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740007424463724C696E7400046D656E67740016435241505032303138303330353030303030303136347372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203464326134656436373165623430386362366430636461393235343839643839707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161F429126E787371007E001E770800000161F429126E78740007424463724C696E7371007E00183F40000000000006770800000008000000067400096463725F6E6F6465317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F400000000000007708000000010000000078707400096463725F6E6F64653271007E00237400096463725F6E6F64653171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D30352031313A31353A3430707400164352415050323031383033303530303030303031363474000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740007424463724C696E7070707071007E002371007E001D70707071007E00317071007E00327871007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D707400096463725F6E6F6465347371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E00407400096463725F6E6F64653471007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646534707400056E6F6465347074000CE58886E8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B00000000770400000000787400096463725F6E6F6465337371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E004D7400096463725F6E6F64653371007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D30352031313A31363A3130707400164352415050323031383033303530303030303031363474000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740007424463724C696E7400046D656E6770707071007E004D71007E001D70707071007E00567071007E00577871007E00297371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004D71007E00297400096463725F6E6F64653271007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D30352031313A31353A3538707400164352415050323031383033303530303030303031363474000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740007424463724C696E7400046D656E6770707071007E002971007E001D70707071007E00697071007E006A7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E002B0000000477040000000471007E002371007E002971007E004D71007E001B787371007E001E770800000161F428576978740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-05 11:15:40', '2018-03-05 11:16:27', '008', 'BDcrLin', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('515ccab46c4e4d1fb1928fd7334e6426', '贷款业务', 'LNAPP2018031500493', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333135303034393374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E417070740009E78E8BE5B08FE5AE817400124C4E415050323031383033313530303439337372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203531356363616234366334653464316662313932386664373333346536343236707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016228EB983E787371007E001E77080000016228EB983E78740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31352031373A30393A3030707400124C4E4150503230313830333135303034393374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E417070740009E78E8BE5B08FE5AE8170707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31352031373A30383A3532707400124C4E4150503230313830333135303034393374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E417070740009E78E8BE5B08FE5AE8170707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31352031373A30383A3037707400124C4E4150503230313830333135303034393374000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E77080000016228EA9FDD78740003303031707371007E00183F400000000000007708000000010000000078, '2018-03-15 17:08:07', '2018-03-15 17:09:11', '001', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('558f4088198a43518fa36e304cbda1e8', '出账申请（信贷）', 'DUAPP201803300000002', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000006740014445541505032303138303333303030303030303274000F43323031383033323030303030323174000777616E6779616E7400124243727244756562696C6C4170702858442970740002444774001444554150503230313830333330303030303030327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007870740004706173737400164243727244756562696C6C4170705F617070726F766574001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC8971007E0007740020353538663430383831393861343335313866613336653330346362646131653870000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30332031333A33323A32357071007E000A71007E000B71007E000C71007E000D7071007E000E707071007E001C71007E001E7070707400166263727264756562696C6C6170705F617070726F76657074001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC89737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400124243727244756562696C6C417070285844297400164243727244756562696C6C4170705F617070726F76657071007E00227071007E002370707371007E00240000000077040000000078787371007E00240000000177040000000171007E0020787372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016289FDFA4778707400124243727244756562696C6C417070285844297371007E00193F4000000000000C7708000000100000000371007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002B74000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F400000000000107708000000100000000078707071007E0031740006E590A6E586B371007E000771007E001E7071007E001B7371007E0032000000010100000002707371007E0017000000007371007E00193F4000000000001077080000001000000000787071007E003171007E001B74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E707871007E001E740018E587BAE8B4A6E794B3E8AFB7EFBC88E4BFA1E8B4B7EFBC897371007E00240000000177040000000171007E001C7871007E002D7400083838383838383838707371007E00193F400000000000107708000000100000000078, '2018-04-03 13:32:26', null, '88888888', 'BCrrDuebillApp(XD)', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('5dc5f596fb9d496ca5a192d838a80fb8', '信用评估流程创建', 'XYPJ201803310000001', 'credictEvalNode1', '申请评审', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000047400135859504A32303138303333313030303030303174000F43323031383033323030303030323174000777616E6779616E7400156372656469744576616C50726373734372656174657400135859504A3230313830333331303030303030317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C77080000001000000001737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000074000D6250617373203D3D2074727565787400056250617373740010637265646963744576616C4E6F646532740010637265646963744576616C4E6F64653174000CE794B3E8AFB7E8AF84E5AEA171007E0007740020356463356635393666623964343936636135613139326438333861383066623870000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30322031343A35333A31367071007E000A71007E000B71007E000C71007E000D7070707071007E002071007E00227070707400106372656469744576616C5461736B30317074000CE68F90E4BAA4E794B3E8AFB7737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F6465317071007E00267071007E002770707371007E00280000000077040000000078787371007E00280000000177040000000171007E0024787372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628521AC3678707400156372656469744576616C50726373734372656174657371007E00183F4000000000000C7708000000100000000474000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0011000000010100000002707371007E0016000000007371007E00183F400000000000107708000000100000000078707071007E0034740006E9809AE8BF8771007E000771007E00227071007E001F7371007E000F000000010100000001707371007E0016000000017371007E00183F4000000000000C7708000000100000000171007E001C74000D6250617373203D3D20747275657874000562506173737400047061737371007E001F74000CE689A7E8A18CE5AEA1E6A0B871007E000771007E0022700000000100000000707371007E0028000000017704000000017371007E002A0000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646532707400106372656469744576616C5461736B30327074000CE4BFA1E794A8E8AF84E5AEA170707371007E00280000000077040000000078787371007E0028000000007704000000007871007E00207371007E000F0000000101000000017071007E001771007E001F71007E002071007E002171007E000771007E00227000000001000000007071007E002971007E002F71007E003F7371007E0035000000010100000002707371007E0016000000007371007E00183F4000000000001077080000001000000000787071007E003471007E003F740006E9809AE8BF8771007E000771007E0022707871007E0022740018E4BFA1E794A8E8AF84E4BCB0E6B581E7A88BE5889BE5BBBA7371007E00280000000177040000000171007E00207871007E00317400083838383838383838707371007E00183F400000000000107708000000100000000078, '2018-04-02 14:53:19', null, '88888888', 'creditEvalPrcssCreate', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('69b37cbee8c645e7a4269ad4e062df91', '出账申请（信贷）', 'DUAPP201803300000002', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000005740014445541505032303138303333303030303030303274000F43323031383033323030303030323174000777616E6779616E7400124243727244756562696C6C41707028584429740009E79C8BE6B581E7A88B74001444554150503230313830333330303030303030327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000000770800000001000000007870740004706173737400164243727244756562696C6C4170705F617070726F766574001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC8971007E0007740020363962333763626565386336343565376134323639616434653036326466393170000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30332031333A34393A33327071007E000A71007E000B71007E000C71007E000D71007E000E70707071007E001C71007E001E7070707400166263727264756562696C6C6170705F617070726F76657074001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC89737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400124243727244756562696C6C417070285844297400164243727244756562696C6C4170705F617070726F76657071007E00227071007E002370707371007E00240000000077040000000078787371007E0024000000027704000000027371007E001F000000010000000070740013323031382D30342D30332031313A33393A313770740014445541505032303138303333303030303030303274000F43323031383033323030303030323174000777616E6779616E7400124243727244756562696C6C41707028584429707400024447707071007E001C71007E001E70707071007E00227071007E002371007E0020787372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628A0DA40378707400124243727244756562696C6C417070285844297371007E00193F400000000000037708000000040000000371007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002B71007E001B7372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F4000000000000077080000000100000000787074000672656A65637471007E001B74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E7071007E003C7371007E0038000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E003C740006E590A6E586B371007E000771007E001E707871007E001E740018E587BAE8B4A6E794B3E8AFB7EFBC88E4BFA1E8B4B7EFBC897371007E00240000000277040000000271007E001C71007E001C787371007E003377080000016289966BD7787400083838383838383838707371007E00193F400000000000007708000000010000000078, '2018-04-03 11:39:19', null, '88888888', 'BCrrDuebillApp(XD)', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('6edcce62aeb0406b982ea32a7b12a044', '应收类业务申请', 'FCNT2018030500000104', 'Approve', '应收类业务申请审批', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B4702000078700000000574001446434E543230313830333035303030303031303474000F43323031383033303530303033303474000A38383838383838382D35740012466163746F72696E67436F6E744170706C797400046D656E6774001446434E54323031383033303530303030303130347372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000000770800000001000000007870740007436F6E6669726D740007417070726F766574001BE5BA94E694B6E7B1BBE4B89AE58AA1E794B3E8AFB7E5AEA1E689B971007E0007740020366564636365363261656230343036623938326561333261376231326130343470000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D30352031333A35323A34387071007E000A71007E000B71007E000C71007E000D71007E000E70707071007E001C71007E001E70707074000C417070726F76655F7461736B7074000CE794B3E8AFB7E5AEA1E689B9737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000000000000000000000740012466163746F72696E67436F6E744170706C79740007417070726F766574000331303071007E00227071007E00237400093230305F303030303074000743555252454E547371007E00240000000077040000000078787371007E00240000000177040000000171007E0020787372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161F4B8365D7870740012466163746F72696E67436F6E744170706C797371007E00193F400000000000067708000000080000000571007E001B7371007E0010000000010100000001707371007E0017000000007371007E00193F400000000000007708000000010000000078707400047061737371007E001B74001BE5BA94E694B6E7B1BBE4B89AE58AA1E59B9EE689A7E7A1AEE8AEA471007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000000000000000000000740012466163746F72696E67436F6E744170706C79740007436F6E6669726D74000331303074000C436F6E6669726D5F7461736B70740021E5BA94E694B6E7B1BBE4B89AE58AA1E794B3E8AFB7E59B9EE689A7E7A1AEE8AEA47400093230305F303030303074000743555252454E547371007E00240000000077040000000078787371007E0024000000007704000000007874000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E004374000CE5AEA1E689B9E590A6E586B371007E000771007E001E7074000573746172747371007E0012000000010100000000707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E001C71007E004974000CE58F91E8B5B7E6B581E7A88B71007E000771007E001E7071007E00367371007E0044000000010100000002707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004371007E003674000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E7071007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002E7871007E001E740015E5BA94E694B6E7B1BBE4B89AE58AA1E794B3E8AFB77371007E00240000000277040000000271007E004971007E001C787371007E002F770800000161F4B833FD78740003303038707371007E00193F400000000000007708000000010000000078, '2018-03-05 13:52:48', null, '008', 'FactoringContApply', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('760f1448e10e46b6b465524251decabc', '授信额度申请', 'CRAPP20180314000000172', 'dcr_node4', 'dcr_node4', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E00057870FFFFFFFF757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033313430303030303031373274000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E740009E78E8BE5B08FE5AE81740016435241505032303138303331343030303030303137327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000000770800000001000000007870740004706173737400096463725F6E6F6465347400096463725F6E6F64653471007E0007740020373630663134343865313065343662366234363535323432353164656361626370000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31342031373A30373A32377071007E000A71007E000B71007E000C71007E000D71007E000E70707071007E001C71007E001E7070707400056E6F6465347074000CE58886E8A18CE5AEA1E689B9737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F6465347071007E00227071007E002370707371007E00240000000077040000000078787371007E00240000000177040000000171007E0020787372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016223C3A6E37870740007424463724C696E7371007E00193F40000000000006770800000008000000067400096463725F6E6F6465317371007E0010000000010100000001707371007E0017000000007371007E00193F400000000000007708000000010000000078707400096463725F6E6F64653271007E00307400096463725F6E6F64653171007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D31342031373A30363A3530707400164352415050323031383033313430303030303031373274000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E7070707071007E003071007E001E70707071007E003A7071007E003B7874000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E0044740006E590A6E586B371007E000771007E001E7071007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002B7400096463725F6E6F6465337371007E0010000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E001C71007E004B7400096463725F6E6F64653371007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D31342031373A30373A3137707400164352415050323031383033313430303030303031373274000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E740009E78E8BE5B08FE5AE8170707071007E004B71007E001E70707071007E00547071007E00557871007E001B7371007E0045000000010100000002707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004471007E001B74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E7071007E00347371007E0010000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004B71007E00347400096463725F6E6F64653271007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D31342031373A30363A3539707400164352415050323031383033313430303030303031373274000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E740009E78E8BE5B08FE5AE8170707071007E003471007E001E70707071007E006B7071007E006C787871007E001E740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E00240000000477040000000471007E003071007E003471007E004B71007E001C787371007E002C77080000016223C3146A78740003303031707371007E00193F400000000000007708000000010000000078, '2018-03-14 17:06:50', null, '001', 'BDcrLin', null, '-1');
INSERT INTO `tbl_serprocess` VALUES ('789e55480adc460fabe7451abb90362e', '贷款业务', 'LNAPP2018030500485', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333035303034383574000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E677400124C4E415050323031383033303530303438357372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203738396535353438306164633436306661626537343531616262393033363265707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161F430C234787371007E001E770800000161F430C23478740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D30352031313A32343A3339707400124C4E4150503230313830333035303034383574000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D30352031313A32343A3239707400124C4E4150503230313830333035303034383574000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D30352031313A32333A3537707400124C4E4150503230313830333035303034383574000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E770800000161F42FED7278740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-05 11:23:57', '2018-03-05 11:24:51', '008', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('7a68a2d9a5b64ac2ae75be02704b1b41', '贷款业务', 'LNAPP2018031900500', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333139303035303074000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E417070740009E78E8BE5B08FE5AE817400124C4E415050323031383033313930303530307372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203761363861326439613562363461633261653735626530323730346231623431707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001623C262A36787371007E001E7708000001623C262A3678740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31392031303A34353A3431707400124C4E4150503230313830333139303035303074000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E417070740009E78E8BE5B08FE5AE8170707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31392031303A34353A3333707400124C4E4150503230313830333139303035303074000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E417070740009E78E8BE5B08FE5AE8170707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31392031303A34353A3233707400124C4E4150503230313830333139303035303074000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E7708000001623C25A5C578740003303031707371007E00183F400000000000007708000000010000000078, '2018-03-19 10:45:23', '2018-03-19 10:45:56', '001', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('7c6c7c3b6e554d2d91468b6e3a5cfe6b', '出账申请（信贷）', 'DUAPP201803300000002', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000004740014445541505032303138303333303030303030303274000F43323031383033323030303030323174000777616E6779616E7400124243727244756562696C6C4170702858442974001444554150503230313830333330303030303030327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007870740004706173737400164243727244756562696C6C4170705F617070726F766574001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC8971007E0007740020376336633763336236653535346432643931343638623665336135636665366270000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30332031313A32363A32397071007E000A71007E000B71007E000C71007E000D7070707071007E001B71007E001D7070707400166263727264756562696C6C6170705F617070726F76657074001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC89737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400124243727244756562696C6C417070285844297400164243727244756562696C6C4170705F617070726F76657071007E00217071007E002270707371007E00230000000077040000000078787371007E00230000000177040000000171007E001F787372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000162898AB13C78707400124243727244756562696C6C417070285844297371007E00183F4000000000000C7708000000100000000371007E001B7371007E000F0000000101000000017071007E001771007E001A71007E001B71007E001C71007E000771007E001D7000000001000000007071007E002471007E002A74000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0011000000010100000002707371007E0016000000007371007E00183F400000000000107708000000100000000078707071007E0030740006E590A6E586B371007E000771007E001D7071007E001A7371007E0031000000010100000002707371007E0016000000007371007E00183F4000000000001077080000001000000000787071007E003071007E001A74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001D707871007E001D740018E587BAE8B4A6E794B3E8AFB7EFBC88E4BFA1E8B4B7EFBC897371007E00230000000177040000000171007E001B7871007E002C7400083838383838383838707371007E00183F400000000000107708000000100000000078, '2018-04-03 11:26:30', null, '88888888', 'BCrrDuebillApp(XD)', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('7c75d849c51f448b832977fcb4d92b35', '贷款业务', 'LNAPP2018040400074', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000077400124C4E4150503230313830343034303030373474000F433230313830333232303030303930740003544447740009424372724C6E417070740009E79C8BE6B581E7A88B7074000230327400124C4E415050323031383034303430303037347372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203763373564383439633531663434386238333239373766636234643932623335707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628FB2EED3787371007E001F7708000001628FB2EED378740009424372724C6E4170707371007E00193F400000000000067708000000080000000571007E001B7371007E0011000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E001B740006E590A6E586B371007E000771007E001E7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0012000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E001C71007E0028740006E5A48DE5AEA171007E000771007E001E70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002F0000000077040000000078787371007E002F0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30342031363A30373A3436707400124C4E4150503230313830343034303030373474000F433230313830333232303030303930740003544447740009424372724C6E417070740009E79C8BE6B581E7A88B7074000230327071007E002871007E001E70707071007E00357071007E00367874000E4C6E4170705F617070726F7665317371007E0029000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E002871007E0042740006E5889DE5AEA171007E000771007E001E700000000100000000707371007E002F000000017704000000017371007E0031000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002F0000000077040000000078787371007E002F000000017704000000017371007E0039000000010000000070740013323031382D30342D30342031353A33383A3435707400124C4E4150503230313830343034303030373474000F433230313830333232303030303930740003544447740009424372724C6E417070740009E79C8BE6B581E7A88B70707071007E004271007E001E70707071007E004B7071007E004C7874000D4C6E4170705F617070726F76657371007E0029000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004271007E005674000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001E700000000100000000707371007E002F000000017704000000017371007E0031000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002F0000000077040000000078787371007E002F000000017704000000017371007E0039000000010000000070740013323031382D30342D30342031353A31333A3334707400124C4E4150503230313830343034303030373474000F433230313830333232303030303930740003544447740009424372724C6E417070707074000230327071007E005671007E001E70707071007E005F7071007E00607871007E001C7371007E00110000000101000000027071007E001871007E001B71007E001C71007E001D71007E000771007E001E707871007E001E74000CE8B4B7E6ACBEE4B89AE58AA17371007E002F0000000477040000000471007E005671007E004271007E002871007E001C787371007E001F7708000001628F80F400787400083838383838383838707371007E00193F400000000000007708000000010000000078, '2018-04-04 15:13:35', '2018-04-04 16:08:11', '88888888', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('8fd551c534ed414f9f013baf9042cef3', '贷款业务', 'LNAPP2018030800489', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333038303034383974000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E417070740009E78E8BE5B08FE5AE817400124C4E415050323031383033303830303438397372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400203866643535316335333465643431346639663031336261663930343263656633707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CBAE16D787371007E001E7708000001622CBAE16D78740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31362031303A35343A3138707400124C4E4150503230313830333038303034383974000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E417070740009E78E8BE5B08FE5AE8170707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31342031353A31303A3137707400124C4E4150503230313830333038303034383974000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E4170707400046D656E6770707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31342031353A30313A3337707400124C4E4150503230313830333038303034383974000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E7708000001622350712978740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-14 15:01:37', '2018-03-16 10:54:27', '008', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('928807fda9254fae9cf1d3c7c6e524d2', '信用评估流程创建', 'XYPJ201804020000002', 'credictEvalNode1', '申请评审', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000047400135859504A32303138303430323030303030303274000F43323031383033323030303030323174000777616E6779616E7400156372656469744576616C50726373734372656174657400135859504A3230313830343032303030303030327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C77080000001000000001737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000074000D6250617373203D3D2074727565787400056250617373740010637265646963744576616C4E6F646532740010637265646963744576616C4E6F64653174000CE794B3E8AFB7E8AF84E5AEA171007E0007740020393238383037666461393235346661653963663164336337633665353234643270000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30322031343A35333A31367071007E000A71007E000B71007E000C71007E000D7070707071007E002071007E00227070707400106372656469744576616C5461736B30317074000CE68F90E4BAA4E794B3E8AFB7737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F6465317071007E00267071007E002770707371007E00280000000077040000000078787371007E00280000000177040000000171007E0024787372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628521AD2978707400156372656469744576616C50726373734372656174657371007E00183F4000000000000C7708000000100000000474000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0011000000010100000002707371007E0016000000007371007E00183F400000000000107708000000100000000078707071007E0034740006E9809AE8BF8771007E000771007E00227071007E001F7371007E000F000000010100000001707371007E0016000000017371007E00183F4000000000000C7708000000100000000171007E001C74000D6250617373203D3D20747275657874000562506173737400047061737371007E001F74000CE689A7E8A18CE5AEA1E6A0B871007E000771007E0022700000000100000000707371007E0028000000017704000000017371007E002A0000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646532707400106372656469744576616C5461736B30327074000CE4BFA1E794A8E8AF84E5AEA170707371007E00280000000077040000000078787371007E0028000000007704000000007871007E00207371007E000F0000000101000000017071007E001771007E001F71007E002071007E002171007E000771007E00227000000001000000007071007E002971007E002F71007E003F7371007E0035000000010100000002707371007E0016000000007371007E00183F4000000000001077080000001000000000787071007E003471007E003F740006E9809AE8BF8771007E000771007E0022707871007E0022740018E4BFA1E794A8E8AF84E4BCB0E6B581E7A88BE5889BE5BBBA7371007E00280000000177040000000171007E00207871007E00317400083838383838383838707371007E00183F400000000000107708000000100000000078, '2018-04-02 14:53:19', null, '88888888', 'creditEvalPrcssCreate', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('98713ef0932544ff82e4be380495b48e', '授信额度申请', 'CRAPP20180314000000171', 'reject', '否决', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033313430303030303031373174000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E740009E78E8BE5B08FE5AE81740016435241505032303138303331343030303030303137317372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000007708000000010000000078707074000672656A656374740006E590A6E586B371007E00077400203938373133656630393332353434666638326534626533383034393562343865707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016223B4CD2F787371007E001D77080000016223B4CD2F78740007424463724C696E7371007E00183F40000000000006770800000008000000067400096463725F6E6F6465317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F400000000000007708000000010000000078707400096463725F6E6F64653271007E00227400096463725F6E6F64653171007E000771007E001C70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E002A0000000077040000000078787371007E002A0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31342031363A34343A3339707400164352415050323031383033313430303030303031373174000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E7070707071007E002271007E001C70707071007E00307071007E00317871007E001A7371007E00100000000101000000027071007E00177071007E001A71007E001B71007E000771007E001C707400096463725F6E6F6465347371007E0023000000010100000001707371007E0016000000007371007E00183F400000000000007708000000010000000078707400047061737371007E003C7400096463725F6E6F64653471007E000771007E001C700000000100000000707371007E002A000000017704000000017371007E002C000000020000000000000000740007424463724C696E7400096463725F6E6F646534707400056E6F6465347074000CE58886E8A18CE5AEA1E689B970707371007E002A0000000077040000000078787371007E002A00000000770400000000787400096463725F6E6F6465337371007E0023000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E003C71007E004A7400096463725F6E6F64653371007E000771007E001C700000000100000000707371007E002A000000017704000000017371007E002C000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E002A0000000077040000000078787371007E002A000000017704000000017371007E0034000000010000000070740013323031382D30332D31342031363A35313A3033707400164352415050323031383033313430303030303031373174000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E740009E78E8BE5B08FE5AE8170707071007E004A71007E001C70707071007E00537071007E00547871007E00287371007E0023000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004A71007E00287400096463725F6E6F64653271007E000771007E001C700000000100000000707371007E002A000000017704000000017371007E002C000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E002A0000000077040000000078787371007E002A000000017704000000017371007E0034000000010000000070740013323031382D30332D31342031363A35303A3534707400164352415050323031383033313430303030303031373174000F433230313830333035303030333037740015E5A4AAE5B9B3E6B48BE4BF9DE999A9E585ACE58FB8740007424463724C696E740009E78E8BE5B08FE5AE8170707071007E002871007E001C70707071007E00667071007E00677871007E00407371007E0010000000010100000002707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001A71007E004074000CE5AEA1E689B9E9809AE8BF8771007E000771007E001C707871007E001C740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E002A0000000477040000000471007E002271007E002871007E004A71007E001A787371007E001D77080000016223AEC85B78740003303031707371007E00183F400000000000007708000000010000000078, '2018-03-14 16:44:39', '2018-03-14 16:51:14', '001', 'BDcrLin', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('990bf1563c6b495e83385d233e57a087', null, '1C8U518GA000A441370A0000D24B18CD', 'credictEvalNode1', '申请评审', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E00057870FFFFFFFF757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000047400203143385535313847413030304134343133373041303030304432344231384344740004313030317400067465737430307400156372656469744576616C507263737343726561746574002031433855353138474130303041343431333730413030303044323442313843447372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000001737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000074000D6250617373203D3D2074727565787400056250617373740010637265646963744576616C4E6F646532740010637265646963744576616C4E6F64653174000CE794B3E8AFB7E8AF84E5AEA171007E0007740020393930626631353633633662343935653833333835643233336535376130383770000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31392031373A30353A30397071007E000A71007E000B71007E000C71007E000D7070707071007E002071007E00227070707400106372656469744576616C5461736B30317074000CE68F90E4BAA4E794B3E8AFB7737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F6465317071007E00267071007E002770707371007E00280000000077040000000078787371007E00280000000177040000000171007E0024787372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001623D815A6F78707400156372656469744576616C50726373734372656174657371007E00183F400000000000067708000000080000000471007E00207371007E000F0000000101000000017071007E001771007E001F71007E002071007E002171007E000771007E00227000000001000000007071007E002971007E002F74000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0011000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E0035740006E9809AE8BF8771007E000771007E00227071007E001F7371007E000F000000010100000001707371007E0016000000017371007E00183F400000000000007708000000010000000171007E001C74000D6250617373203D3D20747275657874000562506173737400047061737371007E001F74000CE689A7E8A18CE5AEA1E6A0B871007E000771007E0022700000000100000000707371007E0028000000017704000000017371007E002A0000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646532707400106372656469744576616C5461736B30327074000CE4BFA1E794A8E8AF84E5AEA170707371007E00280000000077040000000078787371007E0028000000007704000000007871007E00407371007E0036000000010100000002707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E003571007E0040740006E9809AE8BF8771007E000771007E0022707871007E0022707371007E00280000000177040000000171007E00207871007E00317400083838383838383838707371007E00183F400000000000007708000000010000000078, '2018-03-19 17:05:10', null, '88888888', 'creditEvalPrcssCreate', null, '-1');
INSERT INTO `tbl_serprocess` VALUES ('a3bac09614d34203a94a823a8199fbbe', '授信额度申请', 'CRAPP20180313000000169', 'dcr_node3', 'dcr_node3', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E00057870FFFFFFFF757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033313330303030303031363974000F433230313830333033303030323930740003313233740007424463724C696E7400046D656E67740016435241505032303138303331333030303030303136397372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000007708000000010000000078707400096463725F6E6F6465347400096463725F6E6F6465337400096463725F6E6F64653371007E0007740020613362616330393631346433343230336139346138323361383139396662626570000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D32312031343A32393A30347071007E000A71007E000B71007E000C71007E000D71007E000E70707071007E001C71007E001E7070707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA5737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F6465337071007E00227071007E002370707371007E00240000000077040000000078787371007E00240000000177040000000171007E0020787372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000162473F287E7870740007424463724C696E7371007E00193F40000000000006770800000008000000067400096463725F6E6F6465317371007E0010000000010100000001707371007E0017000000007371007E00193F400000000000007708000000010000000078707400096463725F6E6F64653271007E00307400096463725F6E6F64653171007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D32312031343A32383A3334707400164352415050323031383033313330303030303031363974000F433230313830333033303030323930740003313233740007424463724C696E7070707071007E003071007E001E70707071007E003A7071007E003B7874000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E0044740006E590A6E586B371007E000771007E001E7071007E001B7371007E0010000000010100000001707371007E0017000000007371007E00193F400000000000007708000000010000000078707400047061737371007E001B7400096463725F6E6F64653471007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646534707400056E6F6465347074000CE58886E8A18CE5AEA1E689B970707371007E00240000000077040000000078787371007E0024000000007704000000007871007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002B71007E00347371007E0010000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E001C71007E00347400096463725F6E6F64653271007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D32312031343A32383A3439707400164352415050323031383033313330303030303031363974000F433230313830333033303030323930740003313233740007424463724C696E7400046D656E6770707071007E003471007E001E70707071007E00607071007E00617871007E004D7371007E0045000000010100000002707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004471007E004D74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E707871007E001E740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E00240000000377040000000371007E003071007E003471007E001C787371007E002C770800000162473EB45C78740003303038707371007E00193F400000000000007708000000010000000078, '2018-03-21 14:28:34', null, '008', 'BDcrLin', null, '-1');
INSERT INTO `tbl_serprocess` VALUES ('afcd6d37e22e4f52800473bc42920fc4', '授信额度申请', 'CRAPP20180306000000168', 'dcr_node4', 'dcr_node4', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033303630303030303031363874000F433230313830333033303030323930740003313233740007424463724C696E7400046D656E67740016435241505032303138303330363030303030303136387372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000000770800000001000000007870740004706173737400096463725F6E6F6465347400096463725F6E6F64653471007E0007740020616663643664333765323265346635323830303437336263343239323066633470000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31342031333A32383A34307071007E000A71007E000B71007E000C71007E000D71007E000E70707071007E001C71007E001E7070707400056E6F6465347074000CE58886E8A18CE5AEA1E689B9737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F6465347071007E00227071007E002370707371007E00240000000077040000000078787371007E00240000000177040000000171007E0020787372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016222FB59677870740007424463724C696E7371007E00193F40000000000006770800000008000000067400096463725F6E6F6465317371007E0010000000010100000001707371007E0017000000007371007E00193F400000000000007708000000010000000078707400096463725F6E6F64653271007E00307400096463725F6E6F64653171007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D30362031343A35393A3332707400164352415050323031383033303630303030303031363874000F433230313830333033303030323930740003313233740007424463724C696E7070707071007E003071007E001E70707071007E003A7071007E003B7874000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E0044740006E590A6E586B371007E000771007E001E7071007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002B7400096463725F6E6F6465337371007E0010000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E001C71007E004B7400096463725F6E6F64653371007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D31322031373A31343A3139707400164352415050323031383033303630303030303031363874000F433230313830333033303030323930740003313233740007424463724C696E7400046D656E6770707071007E004B71007E001E70707071007E00547071007E00557871007E00347371007E0010000000010100000001707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004B71007E00347400096463725F6E6F64653271007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E00240000000077040000000078787371007E0024000000017704000000017371007E001F000000010000000070740013323031382D30332D30362031353A30323A3130707400164352415050323031383033303630303030303031363874000F433230313830333033303030323930740003313233740007424463724C696E7400046D656E6770707071007E003471007E001E70707071007E00677071007E00687871007E001B7371007E0045000000010100000002707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004471007E001B74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E707871007E001E740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E00240000000477040000000471007E003071007E003471007E004B71007E001C787371007E002C770800000161FA1BA98A78740003303038707371007E00193F400000000000007708000000010000000078, '2018-03-06 14:59:32', null, '008', 'BDcrLin', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('cc4046beca514524820bf894794c6ff4', '授信额度申请', 'CRAPP20180322000000177', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033323230303030303031373774000F43323031383033303530303033303574000A38383838383838382D36740007424463724C696E7400046D656E67740016435241505032303138303332323030303030303137377372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400206363343034366265636135313435323438323062663839343739346336666634707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000162651FAEB1787371007E001E770800000162651FAEB178740007424463724C696E7371007E00183F40000000000006770800000008000000067400096463725F6E6F6465317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F400000000000007708000000010000000078707400096463725F6E6F64653271007E00237400096463725F6E6F64653171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D32372030393A34323A3331707400164352415050323031383033323230303030303031373774000F43323031383033303530303033303574000A38383838383838382D36740007424463724C696E7070707071007E002371007E001D70707071007E00317071007E00327871007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D707400096463725F6E6F6465347371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E00407400096463725F6E6F64653471007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646534707400056E6F6465347074000CE58886E8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B00000000770400000000787400096463725F6E6F6465337371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E004D7400096463725F6E6F64653371007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D32372030393A34333A3030707400164352415050323031383033323230303030303031373774000F43323031383033303530303033303574000A38383838383838382D36740007424463724C696E7400046D656E6770707071007E004D71007E001D70707071007E00567071007E00577871007E00297371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004D71007E00297400096463725F6E6F64653271007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D32372030393A34323A3432707400164352415050323031383033323230303030303031373774000F43323031383033303530303033303574000A38383838383838382D36740007424463724C696E7400046D656E6770707071007E002971007E001D70707071007E00697071007E006A7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E002B0000000477040000000471007E002371007E002971007E004D71007E001B787371007E001E770800000162651EF9BB78740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-27 09:42:31', '2018-03-27 09:43:17', '008', 'BDcrLin', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('d10b904cef0d4e95953481e73086cf03', '贷款业务', 'LNAPP2018040400074', 'LnApp_approve1', '初审', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000077400124C4E4150503230313830343034303030373474000F433230313830333232303030303930740003544447740009424372724C6E417070740009E79C8BE6B581E7A88B7074000230327400124C4E415050323031383034303430303037347372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001478700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000E4C6E4170705F617070726F76653274000E4C6E4170705F617070726F766531740006E5889DE5AEA171007E0007740020643130623930346365663064346539353935333438316537333038366366303370000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30342031363A31303A30397071007E000A71007E000B71007E000C71007E000D71007E000E7071007E000F7071007E001D71007E001F7070707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA1737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F7665317071007E00237071007E002470707371007E00250000000077040000000078787371007E00250000000177040000000171007E0021787372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628FB4BDD27870740009424372724C6E4170707371007E001A3F400000000000067708000000080000000574000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0013000000010100000002707371007E0018000000007371007E001A3F400000000000007708000000010000000078707071007E0031740006E590A6E586B371007E000771007E001F7071007E001C7371007E0011000000010100000001707371007E0018000000007371007E001A3F400000000000007708000000010000000078707400047061737371007E001C740006E5A48DE5AEA171007E000771007E001F700000000100000000707371007E0025000000017704000000017371007E0027000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E00250000000077040000000078787371007E0025000000007704000000007871007E001D7371007E00110000000101000000017071007E001971007E001C71007E001D71007E001E71007E000771007E001F7000000001000000007071007E002671007E002C74000D4C6E4170705F617070726F76657371007E0011000000010100000001707371007E0018000000007371007E001A3F4000000000000077080000000100000000787071007E001D71007E004574000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001F700000000100000000707371007E0025000000017704000000017371007E0027000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E00250000000077040000000078787371007E0025000000017704000000017371007E0020000000010000000070740013323031382D30342D30342031363A30393A3432707400124C4E4150503230313830343034303030373474000F433230313830333232303030303930740003544447740009424372724C6E417070707074000230327071007E004571007E001F70707071007E004E7071007E004F7871007E003A7371007E0032000000010100000002707371007E0018000000007371007E001A3F4000000000000077080000000100000000787071007E003171007E003A74000CE5AEA1E689B9E9809AE8BF8771007E000771007E001F707871007E001F74000CE8B4B7E6ACBEE4B89AE58AA17371007E00250000000277040000000271007E004571007E001D787371007E002D7708000001628FB4552B787400083838383838383838707371007E001A3F400000000000007708000000010000000078, '2018-04-04 16:09:42', null, '88888888', 'BCrrLnApp', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('da96537a56a043ffacd6a165dd080de2', null, '1C8U518GA000A441370A0000D24B18CD', 'credictEvalNode1', '申请评审', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000047400203143385535313847413030304134343133373041303030304432344231384344740004313030317400067465737430307400156372656469744576616C507263737343726561746574002031433855353138474130303041343431333730413030303044323442313843447372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C77080000001000000001737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000074000D6250617373203D3D2074727565787400056250617373740010637265646963744576616C4E6F646532740010637265646963744576616C4E6F64653174000CE794B3E8AFB7E8AF84E5AEA171007E0007740020646139363533376135366130343366666163643661313635646430383064653270000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31392031373A30333A35387071007E000A71007E000B71007E000C71007E000D7070707071007E002071007E00227070707400106372656469744576616C5461736B30317074000CE68F90E4BAA4E794B3E8AFB7737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F6465317071007E00267071007E002770707371007E00280000000077040000000078787371007E00280000000177040000000171007E0024787372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001623D8041E078707400156372656469744576616C50726373734372656174657371007E00183F4000000000000C7708000000100000000471007E00207371007E000F0000000101000000017071007E001771007E001F71007E002071007E002171007E000771007E00227000000001000000007071007E002971007E002F740004706173737372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0011000000010100000002707371007E0016000000007371007E00183F4000000000000077080000001000000000787074000672656A65637471007E0035740006E9809AE8BF8771007E000771007E00227071007E003A7371007E0036000000010100000002707371007E0016000000007371007E00183F400000000000007708000000100000000078707071007E003A740006E9809AE8BF8771007E000771007E00227071007E001F7371007E000F000000010100000001707371007E0016000000017371007E00183F4000000000000C7708000000100000000171007E001C74000D6250617373203D3D207472756578740005625061737371007E003571007E001F74000CE689A7E8A18CE5AEA1E6A0B871007E000771007E0022700000000100000000707371007E0028000000017704000000017371007E002A0000000200000000000000007400156372656469744576616C5072637373437265617465740010637265646963744576616C4E6F646532707400106372656469744576616C5461736B30327074000CE4BFA1E794A8E8AF84E5AEA170707371007E00280000000077040000000078787371007E002800000000770400000000787871007E0022707371007E00280000000177040000000171007E00207871007E00317400083838383838383838707371007E00183F400000000000007708000000100000000078, '2018-03-19 17:03:58', null, '88888888', 'creditEvalPrcssCreate', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('ead450d1c1414cdf9c9aee379e79376f', '贷款业务', 'LNAPP2018030600487', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333036303034383774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E677400124C4E415050323031383033303630303438377372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400206561643435306431633134313463646639633961656533373965373933373666707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161FB5993C2787371007E001E770800000161FB5993C278740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D30362032303A34363A3336707400124C4E4150503230313830333036303034383774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D30362032303A34363A3236707400124C4E4150503230313830333036303034383774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D30362032303A34313A3539707400124C4E4150503230313830333036303034383774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E770800000161FB552F8E78740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-06 20:41:59', '2018-03-06 20:46:47', '008', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('f005b3a5fc754975af819bf6a28d6836', '应收类业务申请', 'FCNT2018032300000106', 'Approve', '应收类业务申请审批', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000001757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B4702000078700000000574001446434E543230313830333233303030303031303674000F43323031383033303530303033303474000A38383838383838382D35740012466163746F72696E67436F6E744170706C797400046D656E6774001446434E54323031383033323330303030303130367372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001378700000000101000000017073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000000770800000001000000007870740007436F6E6669726D740007417070726F766574001BE5BA94E694B6E7B1BBE4B89AE58AA1E794B3E8AFB7E5AEA1E689B971007E0007740020663030356233613566633735343937356166383139626636613238643638333670000000010000000073720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D32332031373A30393A35387071007E000A71007E000B71007E000C71007E000D71007E000E70707071007E001C71007E001E70707074000C417070726F76655F7461736B7074000CE794B3E8AFB7E5AEA1E689B9737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000000000000000000000740012466163746F72696E67436F6E744170706C79740007417070726F766574000331303071007E00227071007E00237400093230305F303030303074000743555252454E547371007E00240000000077040000000078787371007E00240000000177040000000171007E0020787372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000162521F31737870740012466163746F72696E67436F6E744170706C797371007E00193F400000000000067708000000080000000571007E001B7371007E0010000000010100000001707371007E0017000000007371007E00193F400000000000007708000000010000000078707400047061737371007E001B74001BE5BA94E694B6E7B1BBE4B89AE58AA1E59B9EE689A7E7A1AEE8AEA471007E000771007E001E700000000100000000707371007E0024000000017704000000017371007E0026000000000000000000000000740012466163746F72696E67436F6E744170706C79740007436F6E6669726D74000331303074000C436F6E6669726D5F7461736B70740021E5BA94E694B6E7B1BBE4B89AE58AA1E794B3E8AFB7E59B9EE689A7E7A1AEE8AEA47400093230305F303030303074000743555252454E547371007E00240000000077040000000078787371007E0024000000007704000000007874000672656A6563747372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007871007E0012000000010100000002707371007E0017000000007371007E00193F400000000000007708000000010000000078707071007E004374000CE5AEA1E689B9E590A6E586B371007E000771007E001E7074000573746172747371007E0012000000010100000000707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E001C71007E004974000CE58F91E8B5B7E6B581E7A88B71007E000771007E001E7071007E00367371007E0044000000010100000002707371007E0017000000007371007E00193F4000000000000077080000000100000000787071007E004371007E003674000CE5AEA1E689B9E9809AE8BF8771007E000771007E001E7071007E001C7371007E00100000000101000000017071007E001871007E001B71007E001C71007E001D71007E000771007E001E7000000001000000007071007E002571007E002E7871007E001E740015E5BA94E694B6E7B1BBE4B89AE58AA1E794B3E8AFB77371007E00240000000277040000000271007E004971007E001C787371007E002F770800000162521F2F4078740003303038707371007E00193F400000000000007708000000010000000078, '2018-03-23 17:09:58', null, '008', 'FactoringContApply', null, '1');
INSERT INTO `tbl_serprocess` VALUES ('f00cb3b2a6eb4cc78db597efc3483b2f', '贷款业务', 'LNAPP2018031700497', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400124C4E4150503230313830333137303034393774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E677400124C4E415050323031383033313730303439377372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400206630306362336232613665623463633738646235393765666333343833623266707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000162328C845E787371007E001E770800000162328C845E78740009424372724C6E4170707371007E00183F400000000000067708000000080000000571007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D7074000E4C6E4170705F617070726F7665327372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E0027740006E5A48DE5AEA171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766532707400124C6E417070417070726F7665325F7461736B70740006E5A48DE5AEA170707371007E002E0000000077040000000078787371007E002E0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31372031343A30313A3138707400124C4E4150503230313830333137303034393774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E002771007E001D70707071007E00347071007E00357874000E4C6E4170705F617070726F7665317371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E002771007E0040740006E5889DE5AEA171007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000E4C6E4170705F617070726F766531707400124C6E417070417070726F7665315F7461736B70740006E5889DE5AEA170707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31372031343A30313A3131707400124C4E4150503230313830333137303034393774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707400046D656E6770707071007E004071007E001D70707071007E00497071007E004A7874000D4C6E4170705F617070726F76657371007E0028000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E005474000FE7BB8FE58A9EE4BABAE7A1AEE8AEA471007E000771007E001D700000000100000000707371007E002E000000017704000000017371007E0030000000020000000000000000740009424372724C6E41707074000D4C6E4170705F617070726F7665707400114C6E417070417070726F76655F7461736B7074000FE7BB8FE58A9EE4BABAE7A1AEE8AEA470707371007E002E0000000077040000000078787371007E002E000000017704000000017371007E0038000000010000000070740013323031382D30332D31372031343A30303A3434707400124C4E4150503230313830333137303034393774000F43323031383033303330303032383874000CE998B3E58589E5869CE59CBA740009424372724C6E4170707070707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D707871007E001D74000CE8B4B7E6ACBEE4B89AE58AA17371007E002E0000000477040000000471007E005471007E004071007E002771007E001B787371007E001E770800000162328BC72278740003303038707371007E00183F400000000000007708000000010000000078, '2018-03-17 14:00:44', '2018-03-17 14:01:32', '008', 'BCrrLnApp', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('f482de153db845c9b50a82faa3dcc75f', '授信额度申请', 'CRAPP20180319000000174', 'pass', '审批通过', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000057400164352415050323031383033313930303030303031373474000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740007424463724C696E740009E78E8BE5B08FE5AE81740016435241505032303138303331393030303030303137347372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000077080000000100000000787074000672656A6563747400047061737374000CE5AEA1E689B9E9809AE8BF8771007E00077400206634383264653135336462383435633962353061383266616133646363373566707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001623C145EEB787371007E001E7708000001623C145EEB78740007424463724C696E7371007E00183F40000000000006770800000008000000067400096463725F6E6F6465317372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F400000000000007708000000010000000078707400096463725F6E6F64653271007E00237400096463725F6E6F64653171007E000771007E001D70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E00067870000000020000000000000000740007424463724C696E7400096463725F6E6F646531707400056E6F6465317074000CE694AFE8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30332D31392031303A32353A3434707400164352415050323031383033313930303030303031373474000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740007424463724C696E7070707071007E002371007E001D70707071007E00317071007E00327871007E001A7371007E0010000000010100000002707371007E0016000000007371007E00183F400000000000007708000000010000000078707071007E001A740006E590A6E586B371007E000771007E001D707400096463725F6E6F6465347371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001B71007E00407400096463725F6E6F64653471007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646534707400056E6F6465347074000CE58886E8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D31392031303A32363A3230707400164352415050323031383033313930303030303031373474000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740007424463724C696E740009E78E8BE5B08FE5AE8170707071007E004071007E001D70707071007E00497071007E004A787400096463725F6E6F6465337371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E004071007E00547400096463725F6E6F64653371007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646533707400056E6F6465337074000CE58886E8A18CE5AEA1E69FA570707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D31392031303A32363A3036707400164352415050323031383033313930303030303031373474000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740007424463724C696E740009E78E8BE5B08FE5AE8170707071007E005471007E001D70707071007E005D7071007E005E7871007E001B7371007E00100000000101000000027071007E001771007E001A71007E001B71007E001C71007E000771007E001D7071007E00297371007E0024000000010100000001707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E005471007E00297400096463725F6E6F64653271007E000771007E001D700000000100000000707371007E002B000000017704000000017371007E002D000000020000000000000000740007424463724C696E7400096463725F6E6F646532707400056E6F6465327074000CE694AFE8A18CE5AEA1E689B970707371007E002B0000000077040000000078787371007E002B000000017704000000017371007E0035000000010000000070740013323031382D30332D31392031303A32353A3538707400164352415050323031383033313930303030303031373474000F43323031383033303330303033303374000CE4BC8AE588A9E99B86E59BA2740007424463724C696E740009E78E8BE5B08FE5AE8170707071007E002971007E001D70707071007E00717071007E0072787871007E001D740012E68E88E4BFA1E9A29DE5BAA6E794B3E8AFB77371007E002B0000000577040000000571007E002371007E002971007E005471007E004071007E001B787371007E001E7708000001623C13A90F78740003303031707371007E00183F400000000000007708000000010000000078, '2018-03-19 10:25:44', '2018-03-19 10:26:30', '001', 'BDcrLin', null, '2');
INSERT INTO `tbl_serprocess` VALUES ('fc8c0641be904bbc9951f37a0bed9502', '出账申请（信贷）', 'DUAPP201803300000002', 'reject', '否决', 0xACED00057372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E50726F63657373000000000000000102000F49000772756E466C61675B000762697A446174617400135B4C6A6176612F6C616E672F537472696E673B4C000562697A49647400124C6A6176612F6C616E672F537472696E673B4C000B63757272656E744E6F64657400294C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F4E6F64653B4C000864617465466C61677400104C6A6176612F7574696C2F446174653B4C0007656E644461746571007E00044C00076D6F64656C496471007E00024C00076E6F64654D617074000F4C6A6176612F7574696C2F4D61703B4C000970726F63657373496471007E00024C000B70726F636573734E616D6571007E00024C000872756E547261696C7400104C6A6176612F7574696C2F4C6973743B4C000973746172744461746571007E00044C000D7374617274656455736572496471007E00024C000E737570657250726F63657373496471007E00024C00097661726961626C657371007E0005787000000002757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000005740014445541505032303138303333303030303030303274000F43323031383033323030303030323174000777616E6779616E7400124243727244756562696C6C41707028584429740009E79C8BE6B581E7A88B74001444554150503230313830333330303030303030327372002A636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E456E644E6F646500000000000000010200007872002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E426173654E6F6465000000000000000102000B490004666C61675A000869736261636B656449000573747970654C000F656E64547269676765724E616D65737400164C6A6176612F7574696C2F4C696E6B65644C6973743B4C000D65787072657373696F6E4465737400324C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F45787072657373696F6E4465733B4C000A6E6578744E6F6465496471007E00024C00066E6F6465496471007E00024C00086E6F64654E616D6571007E00024C000770726F6365737374002C4C636F6D2F68756174656E672F666C6F7773686172702F696E6E65722F656E746974792F50726F636573733B4C000970726F63657373496471007E00024C00117374617274547269676765724E616D657371007E001278700000000101000000027073720030636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E45787072657373696F6E4465730000000000000001020003490001784C000D65787072657373696F6E4D617071007E00054C0006706172616D7371007E0002787000000000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000007708000000010000000078707074000672656A656374740006E590A6E586B371007E00077400206663386330363431626539303462626339393531663337613062656439353032707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001628A207931787371007E001D7708000001628A207931787400124243727244756562696C6C417070285844297371007E00183F40000000000003770800000004000000037400164243727244756562696C6C4170705F617070726F76657372002B636F6D2E68756174656E672E666C6F7773686172702E696E6E65722E656E746974792E5461736B4E6F6465000000000000000102000549000C6E6F646553747261746567794900067461736B4E6F4C000B63757272656E745461736B7400234C636F6D2F68756174656E672F666C6F7773686172702F656E746974792F5461736B3B4C000B7461736B4465734C69737471007E00064C00087461736B4C69737471007E00067871007E0011000000010100000001707371007E0016000000007371007E00183F400000000000007708000000010000000078707400047061737371007E002274001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC8971007E000771007E001C70000000010000000070737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000173720024636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B446573000000000000000102000C49000E61737369676E53747261746567794900086973536B697065644900077461736B5365714C00076D6F64656C496471007E00024C00066E6F6465496471007E00024C0006726F6C65496471007E00024C00097461736B446573496471007E00024C000F7461736B4465736372697074696F6E71007E00024C00087461736B4E616D6571007E00024C0006756E6974496471007E00024C0009756E69744C6576656C71007E00024C00077573657249647371007E000678700000000200000000000000007400124243727244756562696C6C417070285844297400164243727244756562696C6C4170705F617070726F7665707400166263727264756562696C6C6170705F617070726F76657074001EE587BAE8B4A6E794B3E8AFB7E7A1AEE8AEA4EFBC88E4BFA1E8B4B7EFBC8970707371007E002A0000000077040000000078787371007E002A0000000177040000000173720021636F6D2E68756174656E672E666C6F7773686172702E656E746974792E5461736B00000000000000010200154900086973536B697065644900087461736B466C61674C000861737369676E496471007E00024C000A63726561746554696D6571007E00024C00086465616C54696D6571007E00024C00056E616D653171007E00024C00056E616D653271007E00024C00056E616D653371007E00024C00056E616D653471007E00024C00056E616D653571007E00024C00056E616D653671007E00024C00056E616D653771007E00024C00056E616D653871007E00024C00066E6F6465496471007E00024C000970726F63657373496471007E00024C000974616B656454696D6571007E00024C000B7461736B436F6D6D656E7471007E00024C000F7461736B4465736372697074696F6E71007E00024C00067461736B496471007E00024C00087461736B4D61726B71007E00024C00087461736B4E616D6571007E00027870000000010000000070740013323031382D30342D30332031343A30393A333570740014445541505032303138303333303030303030303274000F43323031383033323030303030323174000777616E6779616E7400124243727244756562696C6C41707028584429707074000230327071007E002271007E001C70707071007E00307071007E00317871007E00287371007E0010000000010100000002707371007E0016000000007371007E00183F4000000000000077080000000100000000787071007E001A71007E002874000CE5AEA1E689B9E9809AE8BF8771007E000771007E001C7071007E001A7371007E00100000000101000000027071007E00177071007E001A71007E001B71007E000771007E001C707871007E001C740018E587BAE8B4A6E794B3E8AFB7EFBC88E4BFA1E8B4B7EFBC897371007E002A0000000277040000000271007E002271007E001A787371007E001D7708000001628A200271787400083838383838383838707371007E00183F400000000000007708000000010000000078, '2018-04-03 14:09:36', '2018-04-03 14:10:06', '88888888', 'BCrrDuebillApp(XD)', null, '2');

-- ----------------------------
-- Table structure for `tbl_serprocess_his`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_serprocess_his`;
CREATE TABLE `tbl_serprocess_his` (
  `ID` varchar(32) NOT NULL,
  `PROCESS_ID` varchar(32) DEFAULT NULL,
  `BIZ_ID` varchar(40) DEFAULT NULL,
  `NODE_ID` varchar(32) DEFAULT NULL,
  `NODE_NAME` varchar(255) DEFAULT NULL,
  `NODE_TYPE` int(11) DEFAULT NULL,
  `START_DATE` varchar(32) DEFAULT NULL,
  `END_DATE` varchar(32) DEFAULT NULL,
  `PROCESS_BYTE` longblob,
  `STARTED_USER` varchar(32) DEFAULT NULL,
  `MODEL_ID` varchar(32) DEFAULT NULL,
  `SUPER_PROCESS_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_serprocess_his
-- ----------------------------
INSERT INTO `tbl_serprocess_his` VALUES ('006b8caeca254e48bd17810baa20848f', '17f10f77dc654a5e861173544809f785', 'CRAPP20180305000000163', 'dcr_node4', 'dcr_node4', '1', '2018-03-05 19:48:10', '2018-03-05 19:48:29', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('03ed65ea06f84d05a846ddf42f75671e', '17f10f77dc654a5e861173544809f785', 'CRAPP20180305000000163', 'pass', '审批通过', '2', '2018-03-05 19:48:29', '2018-03-05 19:48:29', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('04219fe73af24fdabb01199328165f91', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LNAPP2018031700497', 'LnApp_approve', '经办人确认', '1', '2018-03-17 14:00:44', '2018-03-17 14:01:11', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('065e04fa5e1b4bbe8410f042983d2334', '7c75d849c51f448b832977fcb4d92b35', 'LNAPP2018040400074', 'LnApp_approve1', '初审', '1', '2018-04-04 15:38:45', '2018-04-04 16:07:45', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('085163b0a92c4fc286d506f222cd0334', '515ccab46c4e4d1fb1928fd7334e6426', 'LNAPP2018031500493', 'pass', '审批通过', '2', '2018-03-15 17:09:11', '2018-03-15 17:09:11', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('08bc63cf5ac1435984aefc295c87b55e', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LNAPP2018031700497', 'pass', '审批通过', '2', '2018-03-17 14:01:32', '2018-03-17 14:01:32', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('0ece34ca1bac4f778982b02ba2ad5d12', 'a3bac09614d34203a94a823a8199fbbe', 'CRAPP20180313000000169', 'dcr_node1', 'dcr_node1', '1', '2018-03-21 14:28:34', '2018-03-21 14:28:49', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('128f54a5cd254241a60c9f40c9e51697', '3a8a3da8e08249459f573f5115d00355', 'LNAPP2018032100503', 'LnApp_approve1', '初审', '1', '2018-03-21 16:33:17', '2018-03-21 16:33:28', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('12dc7a1778da4fa4b30c43982a3f1613', 'fc8c0641be904bbc9951f37a0bed9502', 'DUAPP201803300000002', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '1', '2018-04-03 14:09:36', '2018-04-03 14:10:06', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('146db714029b406ea6e4bf5aac16c206', 'f005b3a5fc754975af819bf6a28d6836', 'FCNT2018032300000106', 'start', '发起流程', '0', '2018-03-23 17:09:58', '2018-03-23 17:09:58', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('1cdc3024926540c0b5187ae53b9b7dd0', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LNAPP2018031900500', 'LnApp_approve', '经办人确认', '1', '2018-03-19 10:45:23', '2018-03-19 10:45:33', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('1d49c8d04fac4fa19ed3665b627c8c56', 'd10b904cef0d4e95953481e73086cf03', 'LNAPP2018040400074', 'LnApp_approve', '经办人确认', '1', '2018-04-04 16:09:42', '2018-04-04 16:10:09', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('1d5397c6c4174a198b8d1a6151ef0b64', 'f482de153db845c9b50a82faa3dcc75f', 'CRAPP20180319000000174', 'dcr_node1', 'dcr_node1', '1', '2018-03-19 10:25:44', '2018-03-19 10:25:58', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('1d9ebce4b92540ba8a16e2c7c14ca23c', '0f887815d80647178bfd919b83aab4c9', 'XYPJ201804020000003', 'credictEvalNode1', '申请评审', '1', '2018-04-02 15:05:49', '2018-04-02 15:10:08', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('25ade471ba2045c5ba5092a4dfe15fc6', '3a8a3da8e08249459f573f5115d00355', 'LNAPP2018032100503', 'LnApp_approve', '经办人确认', '1', '2018-03-21 16:32:57', '2018-03-21 16:33:17', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('29e7ba4e557d42aeb873554c9212de79', '7c75d849c51f448b832977fcb4d92b35', 'LNAPP2018040400074', 'pass', '审批通过', '2', '2018-04-04 16:08:11', '2018-04-04 16:08:11', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('2a186d25871640febabdd14338f4155d', '760f1448e10e46b6b465524251decabc', 'CRAPP20180314000000172', 'dcr_node3', 'dcr_node3', '1', '2018-03-14 17:07:17', '2018-03-14 17:07:27', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('3220f9745d75457a9986e261458b193f', '17f10f77dc654a5e861173544809f785', 'CRAPP20180305000000163', 'dcr_node1', 'dcr_node1', '1', '2018-03-05 09:35:44', '2018-03-05 19:40:48', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('3483f86418034ecbaa8180dcd9857c16', '98713ef0932544ff82e4be380495b48e', 'CRAPP20180314000000171', 'dcr_node3', 'dcr_node3', '1', '2018-03-14 16:51:03', '2018-03-14 16:51:14', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('36f623098cc5445d9f04f359e0f67da5', '789e55480adc460fabe7451abb90362e', 'LNAPP2018030500485', 'LnApp_approve', '经办人确认', '1', '2018-03-05 11:23:57', '2018-03-05 11:24:29', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('3a62078142164c59b93a176886d6a1c0', '4d2a4ed671eb408cb6d0cda925489d89', 'CRAPP20180305000000164', 'dcr_node3', 'dcr_node3', '1', '2018-03-05 11:16:10', '2018-03-05 11:16:27', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('3ee94ab724cb45cfb405fc1c3acc1181', 'ead450d1c1414cdf9c9aee379e79376f', 'LNAPP2018030600487', 'pass', '审批通过', '2', '2018-03-06 20:46:47', '2018-03-06 20:46:47', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('4234b0a4ff56429dbd73d504794140d0', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LNAPP2018031700497', 'LnApp_approve1', '初审', '1', '2018-03-17 14:01:11', '2018-03-17 14:01:18', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('462c550871074c87bf82add4faa146a3', 'afcd6d37e22e4f52800473bc42920fc4', 'CRAPP20180306000000168', 'dcr_node3', 'dcr_node3', '1', '2018-03-12 17:14:19', '2018-03-14 13:28:40', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('495b23d559ea450aba59f0129652187a', 'ead450d1c1414cdf9c9aee379e79376f', 'LNAPP2018030600487', 'LnApp_approve', '经办人确认', '1', '2018-03-06 20:41:59', '2018-03-06 20:46:26', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('4a31352b9dba44b084b01755fa6b5b68', 'f482de153db845c9b50a82faa3dcc75f', 'CRAPP20180319000000174', 'pass', '审批通过', '2', '2018-03-19 10:26:30', '2018-03-19 10:26:30', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('4a9906581a104121be0d3ca95eac097e', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LNAPP2018031900500', 'LnApp_approve2', '复审', '1', '2018-03-19 10:45:41', '2018-03-19 10:45:56', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('4b1131f129b54a209d11120c1e4ca83f', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LNAPP2018031700497', 'LnApp_approve2', '复审', '1', '2018-03-17 14:01:18', '2018-03-17 14:01:32', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('4c2a7546abf242b29c59df06b51c2eb4', '515ccab46c4e4d1fb1928fd7334e6426', 'LNAPP2018031500493', 'LnApp_approve', '经办人确认', '1', '2018-03-15 17:08:07', '2018-03-15 17:08:52', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('4cb6852d5f494d6cad157cf8ea89e8b2', '7c75d849c51f448b832977fcb4d92b35', 'LNAPP2018040400074', 'LnApp_approve', '经办人确认', '1', '2018-04-04 15:13:35', '2018-04-04 15:38:45', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('4ebe4b2d16a34b58ada7d9ca347e4c72', '8fd551c534ed414f9f013baf9042cef3', 'LNAPP2018030800489', 'pass', '审批通过', '2', '2018-03-16 10:54:27', '2018-03-16 10:54:27', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('50c4b22222fe4eb5a13f41873200a8b9', '789e55480adc460fabe7451abb90362e', 'LNAPP2018030500485', 'LnApp_approve2', '复审', '1', '2018-03-05 11:24:39', '2018-03-05 11:24:51', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('5b9dad19385f4366a1713ee7018da2ba', '36337f68b5e344c09874606a534c3dfe', 'CRAPP20180321000000176', 'dcr_node1', 'dcr_node1', '1', '2018-03-21 19:48:49', '2018-03-21 19:49:33', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('5d5946a2645040e49c01ab8ff53126b8', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LNAPP2018031900500', 'LnApp_approve1', '初审', '1', '2018-03-19 10:45:33', '2018-03-19 10:45:41', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('61ce26738662440ea6bf161b97810112', 'afcd6d37e22e4f52800473bc42920fc4', 'CRAPP20180306000000168', 'dcr_node1', 'dcr_node1', '1', '2018-03-06 14:59:32', '2018-03-06 15:02:10', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('62eda84d79bb4d9eb326b02bf07618ba', 'ead450d1c1414cdf9c9aee379e79376f', 'LNAPP2018030600487', 'LnApp_approve2', '复审', '1', '2018-03-06 20:46:36', '2018-03-06 20:46:47', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('6c17104fc75742d18430804f63feba1a', '515ccab46c4e4d1fb1928fd7334e6426', 'LNAPP2018031500493', 'LnApp_approve2', '复审', '1', '2018-03-15 17:09:00', '2018-03-15 17:09:11', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('78e2dcf0069e4309b34773ee91198670', '8fd551c534ed414f9f013baf9042cef3', 'LNAPP2018030800489', 'LnApp_approve1', '初审', '1', '2018-03-14 15:10:17', '2018-03-16 10:54:18', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('79c478aba48e48bf9a70e2a867327f83', '515ccab46c4e4d1fb1928fd7334e6426', 'LNAPP2018031500493', 'LnApp_approve1', '初审', '1', '2018-03-15 17:08:52', '2018-03-15 17:09:00', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('7aa067bbe54a47cbbfe875c685f7b982', '3a8a3da8e08249459f573f5115d00355', 'LNAPP2018032100503', 'LnApp_approve2', '复审', '1', '2018-03-21 16:33:28', '2018-03-21 16:33:43', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('7d52e48a52ef4fcdb6c2c109f37bd289', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LNAPP2018031900500', 'pass', '审批通过', '2', '2018-03-19 10:45:56', '2018-03-19 10:45:56', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('83a43a6052fa408e8a0473e25ebc014f', '789e55480adc460fabe7451abb90362e', 'LNAPP2018030500485', 'pass', '审批通过', '2', '2018-03-05 11:24:51', '2018-03-05 11:24:51', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('849d4deace594bb5bebd998dca11ca77', '02093a6020734a60acf331ca7744a094', 'LNAPP2018030700488', 'LnApp_approve1', '初审', '1', '2018-03-07 13:38:01', '2018-03-07 13:38:59', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('8534f8064365486880c3efaa1febb9ae', '7c75d849c51f448b832977fcb4d92b35', 'LNAPP2018040400074', 'LnApp_approve2', '复审', '1', '2018-04-04 16:07:46', '2018-04-04 16:08:11', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('8621dca5040b49a5a87664ae677686d8', '0d6e979355134535a05b535f77af7d10', 'XYPJ201804030000004', 'credictEvalNode2', '执行审核', '1', '2018-04-03 17:58:45', '2018-04-03 17:59:13', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('86332bf1153c46a6bfd5bb458403df96', '02093a6020734a60acf331ca7744a094', 'LNAPP2018030700488', 'LnApp_approve', '经办人确认', '1', '2018-03-07 13:36:53', '2018-03-07 13:38:01', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('877dbb977e24461f97f0054c2ad62610', '760f1448e10e46b6b465524251decabc', 'CRAPP20180314000000172', 'dcr_node2', 'dcr_node2', '1', '2018-03-14 17:06:59', '2018-03-14 17:07:17', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('8b064d213f09409188db24941a18cae5', 'cc4046beca514524820bf894794c6ff4', 'CRAPP20180322000000177', 'dcr_node2', 'dcr_node2', '1', '2018-03-27 09:42:42', '2018-03-27 09:43:00', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('8b7315687e8b4f9fb3eae97d63c99136', '36337f68b5e344c09874606a534c3dfe', 'CRAPP20180321000000176', 'dcr_node3', 'dcr_node3', '1', '2018-03-21 19:49:58', '2018-03-21 19:50:33', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('907ea385b4f04adcad2318e9510cf636', '8fd551c534ed414f9f013baf9042cef3', 'LNAPP2018030800489', 'LnApp_approve2', '复审', '1', '2018-03-16 10:54:18', '2018-03-16 10:54:27', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('9439756e5a10421ca80bd367e5d46d49', '98713ef0932544ff82e4be380495b48e', 'CRAPP20180314000000171', 'dcr_node1', 'dcr_node1', '1', '2018-03-14 16:44:39', '2018-03-14 16:50:54', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('947c289759164b678790ce0ef44f8240', 'cc4046beca514524820bf894794c6ff4', 'CRAPP20180322000000177', 'dcr_node3', 'dcr_node3', '1', '2018-03-27 09:43:00', '2018-03-27 09:43:17', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('9715002f42524976ba5a05cff4025331', '3a8a3da8e08249459f573f5115d00355', 'LNAPP2018032100503', 'pass', '审批通过', '2', '2018-03-21 16:33:43', '2018-03-21 16:33:43', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('99845081ba254595a6d121fd3ad7e2ca', 'cc4046beca514524820bf894794c6ff4', 'CRAPP20180322000000177', 'dcr_node1', 'dcr_node1', '1', '2018-03-27 09:42:31', '2018-03-27 09:42:42', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('9d1b5268edb74d76a5f92590d514785f', 'cc4046beca514524820bf894794c6ff4', 'CRAPP20180322000000177', 'pass', '审批通过', '2', '2018-03-27 09:43:17', '2018-03-27 09:43:17', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('9eb3150a88e14a28a111448d90b2cb4e', '17f10f77dc654a5e861173544809f785', 'CRAPP20180305000000163', 'dcr_node2', 'dcr_node2', '1', '2018-03-05 19:40:48', '2018-03-05 19:42:34', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('a258886a03934020985ac2628116d6a6', '0d6e979355134535a05b535f77af7d10', 'XYPJ201804030000004', 'pass', '通过', '2', '2018-04-03 17:59:13', '2018-04-03 17:59:13', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('aad318ddc2934a18aba20775f111d738', 'fc8c0641be904bbc9951f37a0bed9502', 'DUAPP201803300000002', 'reject', '否决', '2', '2018-04-03 14:10:06', '2018-04-03 14:10:06', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('ae1eb6966b62450a83799c685d1e7ddc', 'f482de153db845c9b50a82faa3dcc75f', 'CRAPP20180319000000174', 'dcr_node2', 'dcr_node2', '1', '2018-03-19 10:25:58', '2018-03-19 10:26:06', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('b47374f1c0aa47869d87740bd08b08d1', '17f10f77dc654a5e861173544809f785', 'CRAPP20180305000000163', 'dcr_node3', 'dcr_node3', '1', '2018-03-05 19:42:34', '2018-03-05 19:48:10', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('b7c245faacb94d638eec3b6f988614d8', '760f1448e10e46b6b465524251decabc', 'CRAPP20180314000000172', 'dcr_node1', 'dcr_node1', '1', '2018-03-14 17:06:50', '2018-03-14 17:06:59', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('bcffe98cc286473f9f09f0d077def9c2', '789e55480adc460fabe7451abb90362e', 'LNAPP2018030500485', 'LnApp_approve1', '初审', '1', '2018-03-05 11:24:29', '2018-03-05 11:24:39', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('be31df29b81d43d6b6072145e338ca93', '02093a6020734a60acf331ca7744a094', 'LNAPP2018030700488', 'LnApp_approve2', '复审', '1', '2018-03-07 13:38:59', '2018-03-07 13:39:18', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('c3da022868324b8a8ea23f9035952ee1', '36337f68b5e344c09874606a534c3dfe', 'CRAPP20180321000000176', 'dcr_node2', 'dcr_node2', '1', '2018-03-21 19:49:33', '2018-03-21 19:49:58', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('ca79476ab2a54e72b43e31f6516b8f2d', '4d2a4ed671eb408cb6d0cda925489d89', 'CRAPP20180305000000164', 'pass', '审批通过', '2', '2018-03-05 11:16:27', '2018-03-05 11:16:27', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('cfaffa5e69f7432fa1a4787e4afd1b23', '0d6e979355134535a05b535f77af7d10', 'XYPJ201804030000004', 'credictEvalNode1', '申请评审', '1', '2018-04-03 17:58:05', '2018-04-03 17:58:44', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('d16b23974769424188baeacbd8abd3aa', 'f482de153db845c9b50a82faa3dcc75f', 'CRAPP20180319000000174', 'dcr_node3', 'dcr_node3', '1', '2018-03-19 10:26:06', '2018-03-19 10:26:20', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('dd5b6b569588423c893834218c9225ad', '0f887815d80647178bfd919b83aab4c9', 'XYPJ201804020000003', 'pass', '通过', '2', '2018-04-02 15:12:24', '2018-04-02 15:12:24', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('dde867d7d9b0414b9c7c78718b2dc904', '6edcce62aeb0406b982ea32a7b12a044', 'FCNT2018030500000104', 'start', '发起流程', '0', '2018-03-05 13:52:48', '2018-03-05 13:52:48', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('dee6557b6c784f66919a3ffc413b40ee', 'afcd6d37e22e4f52800473bc42920fc4', 'CRAPP20180306000000168', 'dcr_node2', 'dcr_node2', '1', '2018-03-06 15:02:10', '2018-03-12 17:14:19', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('e03af480401c455e9812ee862c953929', '8fd551c534ed414f9f013baf9042cef3', 'LNAPP2018030800489', 'LnApp_approve', '经办人确认', '1', '2018-03-14 15:01:37', '2018-03-14 15:10:17', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('e14f65225696428a9e72c9e495d3a6b4', 'f482de153db845c9b50a82faa3dcc75f', 'CRAPP20180319000000174', 'dcr_node4', 'dcr_node4', '1', '2018-03-19 10:26:20', '2018-03-19 10:26:30', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('ed655c8ae4dc4604b641426c74ae3183', 'a3bac09614d34203a94a823a8199fbbe', 'CRAPP20180313000000169', 'dcr_node2', 'dcr_node2', '1', '2018-03-21 14:28:49', '2018-03-21 14:29:04', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('f19503b4ab2e45c190258c33e29c2b00', '02093a6020734a60acf331ca7744a094', 'LNAPP2018030700488', 'pass', '审批通过', '2', '2018-03-07 13:39:18', '2018-03-07 13:39:18', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('f1c78ce696a64b5584acaa7fc49cad1d', '0f887815d80647178bfd919b83aab4c9', 'XYPJ201804020000003', 'credictEvalNode2', '执行审核', '1', '2018-04-02 15:10:08', '2018-04-02 15:12:24', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('f34fe8f841ad4baf8e183c8afd6c5a3a', '69b37cbee8c645e7a4269ad4e062df91', 'DUAPP201803300000002', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '1', '2018-04-03 11:39:19', '2018-04-03 13:49:32', null, '88888888', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('f6e47b99ea4f45f48837329779da5fb5', '98713ef0932544ff82e4be380495b48e', 'CRAPP20180314000000171', 'reject', '否决', '2', '2018-03-14 16:51:14', '2018-03-14 16:51:14', null, '001', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('f7ed7ea95fda41b4a8c653f04777dd41', '4d2a4ed671eb408cb6d0cda925489d89', 'CRAPP20180305000000164', 'dcr_node1', 'dcr_node1', '1', '2018-03-05 11:15:40', '2018-03-05 11:15:57', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('fe150f3bd73c473687ac9d8e78a1ca7f', 'ead450d1c1414cdf9c9aee379e79376f', 'LNAPP2018030600487', 'LnApp_approve1', '初审', '1', '2018-03-06 20:46:26', '2018-03-06 20:46:36', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('fe7f1b0f50ea4a49abf7d56d4938aab7', '4d2a4ed671eb408cb6d0cda925489d89', 'CRAPP20180305000000164', 'dcr_node2', 'dcr_node2', '1', '2018-03-05 11:15:57', '2018-03-05 11:16:10', null, '008', 'null', null);
INSERT INTO `tbl_serprocess_his` VALUES ('ff94e1ffb81244a9a14b01180ca4fee2', '98713ef0932544ff82e4be380495b48e', 'CRAPP20180314000000171', 'dcr_node2', 'dcr_node2', '1', '2018-03-14 16:50:54', '2018-03-14 16:51:03', null, '001', 'null', null);

-- ----------------------------
-- Table structure for `tbl_statistics_calculation`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_statistics_calculation`;
CREATE TABLE `tbl_statistics_calculation` (
  `ID` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `TABLE_NAME` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `QUERY_FIELD` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `QUERY_CONDITION` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SELECT_NESTED_ID` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `FROM_NESTED_ID` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `WHERE_NESTED_ID` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `GROUP_BY_FIELD` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `IS_COUNT` int(11) DEFAULT NULL,
  `IS_NEED_FIELD_FROM_NESTED` tinyint(4) DEFAULT NULL,
  `CONTAINED_IN_ORDER` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `RELATION_FIELD` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_statistics_calculation
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_statistics_config`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_statistics_config`;
CREATE TABLE `tbl_statistics_config` (
  `ID` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `CALCULATION_ID` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_statistics_config
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_sys_configuration`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_configuration`;
CREATE TABLE `tbl_sys_configuration` (
  `CONFIG_ID` varchar(255) NOT NULL,
  `CONFIG_NAME` varchar(255) DEFAULT NULL,
  `CONFIG_VALUE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CONFIG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_sys_configuration
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_task`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task`;
CREATE TABLE `tbl_task` (
  `TASK_ID` varchar(32) NOT NULL,
  `PROCESS_ID` varchar(32) NOT NULL,
  `NODE_ID` varchar(32) DEFAULT NULL,
  `TASK_NAME` varchar(255) DEFAULT NULL,
  `TASK_FLAG` int(11) DEFAULT NULL,
  `ASSIGN_ID` varchar(32) DEFAULT NULL,
  `TASK_DESCRIPTION` varchar(255) DEFAULT NULL,
  `TASK_COMMENT` varchar(255) DEFAULT NULL,
  `CREATE_TIME` varchar(32) DEFAULT NULL,
  `TAKED_TIME` varchar(32) DEFAULT NULL,
  `DEAL_TIME` varchar(32) DEFAULT NULL,
  `NAME1` varchar(255) DEFAULT NULL,
  `NAME2` varchar(255) DEFAULT NULL,
  `NAME3` varchar(255) DEFAULT NULL,
  `NAME4` varchar(255) DEFAULT NULL,
  `NAME5` varchar(255) DEFAULT NULL,
  `NAME6` varchar(255) DEFAULT NULL,
  `NAME7` varchar(255) DEFAULT NULL,
  `NAME8` varchar(255) DEFAULT NULL,
  `TASK_MARK` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`TASK_ID`,`PROCESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_task
-- ----------------------------
INSERT INTO `tbl_task` VALUES ('Approve_task', '6edcce62aeb0406b982ea32a7b12a044', 'Approve', '申请审批', '0', null, null, null, '2018-03-05 13:52:48', null, null, 'FCNT2018030500000104', 'C20180305000304', '88888888-5', 'FactoringContApply', 'meng', null, null, null, null);
INSERT INTO `tbl_task` VALUES ('Approve_task', 'f005b3a5fc754975af819bf6a28d6836', 'Approve', '申请审批', '0', null, null, null, '2018-03-23 17:09:58', null, null, 'FCNT2018032300000106', 'C20180305000304', '88888888-5', 'FactoringContApply', 'meng', null, null, null, null);
INSERT INTO `tbl_task` VALUES ('bcrrduebillapp_approve', '19a802007c5744ab826f25c11b59d84e', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '0', null, null, null, '2018-04-03 11:22:27', null, null, 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', null, null, null, null, null);
INSERT INTO `tbl_task` VALUES ('bcrrduebillapp_approve', '558f4088198a43518fa36e304cbda1e8', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '0', null, null, null, '2018-04-03 13:32:25', null, null, 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', null, '', null, null, null);
INSERT INTO `tbl_task` VALUES ('bcrrduebillapp_approve', '69b37cbee8c645e7a4269ad4e062df91', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '0', null, null, null, '2018-04-03 13:49:32', null, null, 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', null, null, null, null);
INSERT INTO `tbl_task` VALUES ('bcrrduebillapp_approve', '7c6c7c3b6e554d2d91468b6e3a5cfe6b', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '0', null, null, null, '2018-04-03 11:26:29', null, null, 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', null, null, null, null, null);
INSERT INTO `tbl_task` VALUES ('bcrrduebillapp_approve', 'fc8c0641be904bbc9951f37a0bed9502', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '2', '88888888', null, 'aaaaaaaa', '2018-04-03 14:09:35', '2018-04-03 14:10:04', '2018-04-03 14:10:06', 'DUAPP201803300000002', 'C20180320000021', 'wangyan', 'BCrrDuebillApp(XD)', '看流程', null, '02', null, '12dc7a1778da4fa4b30c43982a3f1613');
INSERT INTO `tbl_task` VALUES ('creditEvalTask01', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode1', '提交申请', '2', '88888888', null, 'rr', '2018-04-03 17:58:04', '2018-04-03 17:58:39', '2018-04-03 17:58:43', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', null, '2', null, 'cfaffa5e69f7432fa1a4787e4afd1b23');
INSERT INTO `tbl_task` VALUES ('creditEvalTask01', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode1', '提交申请', '2', '88888888', null, 'DFF', '2018-04-02 15:05:47', '2018-04-02 15:10:04', '2018-04-02 15:10:06', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', null, null, null, '1d9ebce4b92540ba8a16e2c7c14ca23c');
INSERT INTO `tbl_task` VALUES ('creditEvalTask01', '5dc5f596fb9d496ca5a192d838a80fb8', 'credictEvalNode1', '提交申请', '0', null, null, null, '2018-04-02 14:53:16', null, null, 'XYPJ201803310000001', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', null, null, null, null, null);
INSERT INTO `tbl_task` VALUES ('creditEvalTask01', '928807fda9254fae9cf1d3c7c6e524d2', 'credictEvalNode1', '提交申请', '0', null, null, null, '2018-04-02 14:53:16', null, null, 'XYPJ201804020000002', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', null, null, null, null, null);
INSERT INTO `tbl_task` VALUES ('creditEvalTask01', 'da96537a56a043ffacd6a165dd080de2', 'credictEvalNode1', '提交申请', '0', null, null, null, '2018-03-19 17:03:58', null, null, '1C8U518GA000A441370A0000D24B18CD', '1001', 'test00', 'creditEvalPrcssCreate', null, null, null, null, null);
INSERT INTO `tbl_task` VALUES ('creditEvalTask02', '0d6e979355134535a05b535f77af7d10', 'credictEvalNode2', '信用评审', '2', '88888888', null, 'ad', '2018-04-03 17:58:45', '2018-04-03 17:59:09', '2018-04-03 17:59:12', 'XYPJ201804030000004', 'C20180325000104', '士大夫大师傅', 'creditEvalPrcssCreate', '看流程', null, null, null, '8621dca5040b49a5a87664ae677686d8');
INSERT INTO `tbl_task` VALUES ('creditEvalTask02', '0f887815d80647178bfd919b83aab4c9', 'credictEvalNode2', '信用评审', '2', '88888888', null, 'ASDDD', '2018-04-02 15:10:09', '2018-04-02 15:12:19', '2018-04-02 15:12:22', 'XYPJ201804020000003', 'C20180320000021', 'wangyan', 'creditEvalPrcssCreate', '看流程', null, null, null, 'f1c78ce696a64b5584acaa7fc49cad1d');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', '02093a6020734a60acf331ca7744a094', 'LnApp_approve1', '初审', '2', '008', null, '同意', '2018-03-07 13:38:01', '2018-03-07 13:38:59', '2018-03-07 13:38:59', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', null, null, null, '849d4deace594bb5bebd998dca11ca77');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve1', '初审', '2', '008', null, 'aaaaaaa', '2018-03-21 16:33:17', '2018-03-21 16:33:28', '2018-03-21 16:33:28', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '128f54a5cd254241a60c9f40c9e51697');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve1', '初审', '2', '001', null, '同意', '2018-03-15 17:08:52', '2018-03-15 17:09:00', '2018-03-15 17:09:00', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', null, null, null, '79c478aba48e48bf9a70e2a867327f83');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', '789e55480adc460fabe7451abb90362e', 'LnApp_approve1', '初审', '2', '008', null, '同意', '2018-03-05 11:24:29', '2018-03-05 11:24:38', '2018-03-05 11:24:39', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, 'bcffe98cc286473f9f09f0d077def9c2');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve1', '初审', '2', '001', null, '同意', '2018-03-19 10:45:33', '2018-03-19 10:45:41', '2018-03-19 10:45:41', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', null, null, null, '5d5946a2645040e49c01ab8ff53126b8');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve1', '初审', '2', '88888888', null, 'aaaa', '2018-04-04 15:38:45', '2018-04-04 16:07:44', '2018-04-04 16:07:45', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', null, '02', null, '065e04fa5e1b4bbe8410f042983d2334');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve1', '初审', '2', '001', null, '同意', '2018-03-14 15:10:17', '2018-03-16 10:54:18', '2018-03-16 10:54:18', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', null, null, null, '78e2dcf0069e4309b34773ee91198670');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve1', '初审', '0', null, null, null, '2018-04-04 16:10:09', null, null, 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', null, '02', null, null);
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve1', '初审', '2', '008', null, '同意', '2018-03-06 20:46:26', '2018-03-06 20:46:36', '2018-03-06 20:46:36', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, 'fe150f3bd73c473687ac9d8e78a1ca7f');
INSERT INTO `tbl_task` VALUES ('LnAppApprove1_task', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve1', '初审', '2', '008', null, '222', '2018-03-17 14:01:11', '2018-03-17 14:01:18', '2018-03-17 14:01:18', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '4234b0a4ff56429dbd73d504794140d0');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', '02093a6020734a60acf331ca7744a094', 'LnApp_approve2', '复审', '2', '008', null, '通过', '2018-03-07 13:38:59', '2018-03-07 13:39:18', '2018-03-07 13:39:18', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', null, null, null, 'be31df29b81d43d6b6072145e338ca93');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve2', '复审', '2', '008', null, 'cccccccc', '2018-03-21 16:33:28', '2018-03-21 16:33:42', '2018-03-21 16:33:42', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '7aa067bbe54a47cbbfe875c685f7b982');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve2', '复审', '2', '001', null, '通过', '2018-03-15 17:09:00', '2018-03-15 17:09:11', '2018-03-15 17:09:11', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', null, null, null, '6c17104fc75742d18430804f63feba1a');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', '789e55480adc460fabe7451abb90362e', 'LnApp_approve2', '复审', '2', '008', null, '通过', '2018-03-05 11:24:39', '2018-03-05 11:24:51', '2018-03-05 11:24:51', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '50c4b22222fe4eb5a13f41873200a8b9');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve2', '复审', '2', '001', null, '通过', '2018-03-19 10:45:41', '2018-03-19 10:45:56', '2018-03-19 10:45:56', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', null, null, null, '4a9906581a104121be0d3ca95eac097e');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve2', '复审', '2', '88888888', null, 'bbbbbb', '2018-04-04 16:07:46', '2018-04-04 16:08:09', '2018-04-04 16:08:10', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', null, '02', null, '8534f8064365486880c3efaa1febb9ae');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve2', '复审', '2', '001', null, '通过', '2018-03-16 10:54:18', '2018-03-16 10:54:27', '2018-03-16 10:54:27', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', null, null, null, '907ea385b4f04adcad2318e9510cf636');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve2', '复审', '2', '008', null, '通过', '2018-03-06 20:46:36', '2018-03-06 20:46:47', '2018-03-06 20:46:47', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '62eda84d79bb4d9eb326b02bf07618ba');
INSERT INTO `tbl_task` VALUES ('LnAppApprove2_task', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve2', '复审', '2', '008', null, '333', '2018-03-17 14:01:18', '2018-03-17 14:01:32', '2018-03-17 14:01:32', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '4b1131f129b54a209d11120c1e4ca83f');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', '02093a6020734a60acf331ca7744a094', 'LnApp_approve', '经办人确认', '2', '008', null, '同意', '2018-03-07 13:36:53', '2018-03-07 13:38:01', '2018-03-07 13:38:01', 'LNAPP2018030700488', 'C20180303000290', '123', 'BCrrLnApp', 'meng', null, null, null, '86332bf1153c46a6bfd5bb458403df96');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', '3a8a3da8e08249459f573f5115d00355', 'LnApp_approve', '经办人确认', '2', '008', null, 'aaaaa', '2018-03-21 16:32:57', '2018-03-21 16:33:17', '2018-03-21 16:33:17', 'LNAPP2018032100503', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '25ade471ba2045c5ba5092a4dfe15fc6');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', '515ccab46c4e4d1fb1928fd7334e6426', 'LnApp_approve', '经办人确认', '2', '001', null, '同意', '2018-03-15 17:08:07', '2018-03-15 17:08:52', '2018-03-15 17:08:52', 'LNAPP2018031500493', 'C20180303000288', '阳光农场', 'BCrrLnApp', '王小宁', null, null, null, '4c2a7546abf242b29c59df06b51c2eb4');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', '789e55480adc460fabe7451abb90362e', 'LnApp_approve', '经办人确认', '2', '008', null, '同意', '2018-03-05 11:23:57', '2018-03-05 11:24:29', '2018-03-05 11:24:29', 'LNAPP2018030500485', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '36f623098cc5445d9f04f359e0f67da5');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', '7a68a2d9a5b64ac2ae75be02704b1b41', 'LnApp_approve', '经办人确认', '2', '001', null, '同意', '2018-03-19 10:45:23', '2018-03-19 10:45:33', '2018-03-19 10:45:33', 'LNAPP2018031900500', 'C20180303000303', '伊利集团', 'BCrrLnApp', '王小宁', null, null, null, '1cdc3024926540c0b5187ae53b9b7dd0');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', '7c75d849c51f448b832977fcb4d92b35', 'LnApp_approve', '经办人确认', '2', '88888888', null, 'aaaa', '2018-04-04 15:13:34', '2018-04-04 15:38:43', '2018-04-04 15:38:44', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', null, '02', null, '4cb6852d5f494d6cad157cf8ea89e8b2');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', '8fd551c534ed414f9f013baf9042cef3', 'LnApp_approve', '经办人确认', '2', '008', null, '同意', '2018-03-14 15:01:37', '2018-03-14 15:10:17', '2018-03-14 15:10:17', 'LNAPP2018030800489', 'C20180303000303', '伊利集团', 'BCrrLnApp', 'meng', null, null, null, 'e03af480401c455e9812ee862c953929');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', 'd10b904cef0d4e95953481e73086cf03', 'LnApp_approve', '经办人确认', '2', '88888888', null, 'aaaa', '2018-04-04 16:09:42', '2018-04-04 16:10:08', '2018-04-04 16:10:09', 'LNAPP2018040400074', 'C20180322000090', 'TDG', 'BCrrLnApp', '看流程', null, '02', null, '1d49c8d04fac4fa19ed3665b627c8c56');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', 'ead450d1c1414cdf9c9aee379e79376f', 'LnApp_approve', '经办人确认', '2', '008', null, '同意', '2018-03-06 20:41:59', '2018-03-06 20:46:26', '2018-03-06 20:46:26', 'LNAPP2018030600487', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '495b23d559ea450aba59f0129652187a');
INSERT INTO `tbl_task` VALUES ('LnAppApprove_task', 'f00cb3b2a6eb4cc78db597efc3483b2f', 'LnApp_approve', '经办人确认', '2', '008', null, '1111', '2018-03-17 14:00:44', '2018-03-17 14:01:10', '2018-03-17 14:01:11', 'LNAPP2018031700497', 'C20180303000288', '阳光农场', 'BCrrLnApp', 'meng', null, null, null, '04219fe73af24fdabb01199328165f91');
INSERT INTO `tbl_task` VALUES ('node1', '17f10f77dc654a5e861173544809f785', 'dcr_node1', '支行审查', '2', '008', null, '同意', '2018-03-05 09:35:44', '2018-03-05 19:40:48', '2018-03-05 19:40:48', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', null, null, null, '3220f9745d75457a9986e261458b193f');
INSERT INTO `tbl_task` VALUES ('node1', '36337f68b5e344c09874606a534c3dfe', 'dcr_node1', '支行审查', '2', '008', null, '同意', '2018-03-21 19:48:49', '2018-03-21 19:49:33', '2018-03-21 19:49:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', null, null, null, '5b9dad19385f4366a1713ee7018da2ba');
INSERT INTO `tbl_task` VALUES ('node1', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node1', '支行审查', '2', '008', null, '同意', '2018-03-05 11:15:40', '2018-03-05 11:15:57', '2018-03-05 11:15:57', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', null, null, null, 'f7ed7ea95fda41b4a8c653f04777dd41');
INSERT INTO `tbl_task` VALUES ('node1', '760f1448e10e46b6b465524251decabc', 'dcr_node1', '支行审查', '2', '001', null, '同意', '2018-03-14 17:06:50', '2018-03-14 17:06:59', '2018-03-14 17:06:59', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', null, null, null, 'b7c245faacb94d638eec3b6f988614d8');
INSERT INTO `tbl_task` VALUES ('node1', '98713ef0932544ff82e4be380495b48e', 'dcr_node1', '支行审查', '2', '001', null, '同意', '2018-03-14 16:44:39', '2018-03-14 16:50:54', '2018-03-14 16:50:54', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', null, null, null, '9439756e5a10421ca80bd367e5d46d49');
INSERT INTO `tbl_task` VALUES ('node1', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node1', '支行审查', '2', '008', null, '同意', '2018-03-21 14:28:34', '2018-03-21 14:28:49', '2018-03-21 14:28:49', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', null, null, null, '0ece34ca1bac4f778982b02ba2ad5d12');
INSERT INTO `tbl_task` VALUES ('node1', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node1', '支行审查', '2', '008', null, '同意', '2018-03-06 14:59:32', '2018-03-06 15:02:10', '2018-03-06 15:02:10', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', null, null, null, '61ce26738662440ea6bf161b97810112');
INSERT INTO `tbl_task` VALUES ('node1', 'cc4046beca514524820bf894794c6ff4', 'dcr_node1', '支行审查', '2', '008', null, '同意', '2018-03-27 09:42:31', '2018-03-27 09:42:42', '2018-03-27 09:42:42', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', null, null, null, '99845081ba254595a6d121fd3ad7e2ca');
INSERT INTO `tbl_task` VALUES ('node1', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node1', '支行审查', '2', '001', null, '同意', '2018-03-19 10:25:44', '2018-03-19 10:25:58', '2018-03-19 10:25:58', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', null, null, null, '1d5397c6c4174a198b8d1a6151ef0b64');
INSERT INTO `tbl_task` VALUES ('node2', '17f10f77dc654a5e861173544809f785', 'dcr_node2', '支行审批', '2', '008', null, '同意', '2018-03-05 19:40:48', '2018-03-05 19:42:34', '2018-03-05 19:42:34', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', null, null, null, '9eb3150a88e14a28a111448d90b2cb4e');
INSERT INTO `tbl_task` VALUES ('node2', '36337f68b5e344c09874606a534c3dfe', 'dcr_node2', '支行审批', '2', '008', null, '同意', '2018-03-21 19:49:33', '2018-03-21 19:49:58', '2018-03-21 19:49:58', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', null, null, null, 'c3da022868324b8a8ea23f9035952ee1');
INSERT INTO `tbl_task` VALUES ('node2', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node2', '支行审批', '2', '008', null, '同意', '2018-03-05 11:15:58', '2018-03-05 11:16:09', '2018-03-05 11:16:10', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', null, null, null, 'fe7f1b0f50ea4a49abf7d56d4938aab7');
INSERT INTO `tbl_task` VALUES ('node2', '760f1448e10e46b6b465524251decabc', 'dcr_node2', '支行审批', '2', '001', null, '同意', '2018-03-14 17:06:59', '2018-03-14 17:07:17', '2018-03-14 17:07:17', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', null, null, null, '877dbb977e24461f97f0054c2ad62610');
INSERT INTO `tbl_task` VALUES ('node2', '98713ef0932544ff82e4be380495b48e', 'dcr_node2', '支行审批', '2', '001', null, '同意', '2018-03-14 16:50:54', '2018-03-14 16:51:03', '2018-03-14 16:51:03', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', null, null, null, 'ff94e1ffb81244a9a14b01180ca4fee2');
INSERT INTO `tbl_task` VALUES ('node2', 'a3bac09614d34203a94a823a8199fbbe', 'dcr_node2', '支行审批', '2', '008', null, '同意', '2018-03-21 14:28:49', '2018-03-21 14:29:04', '2018-03-21 14:29:04', 'CRAPP20180313000000169', 'C20180303000290', '123', 'BDcrLin', 'meng', null, null, null, 'ed655c8ae4dc4604b641426c74ae3183');
INSERT INTO `tbl_task` VALUES ('node2', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node2', '支行审批', '2', '008', null, 'mmmn', '2018-03-06 15:02:10', '2018-03-12 17:14:19', '2018-03-12 17:14:19', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', null, null, null, 'dee6557b6c784f66919a3ffc413b40ee');
INSERT INTO `tbl_task` VALUES ('node2', 'cc4046beca514524820bf894794c6ff4', 'dcr_node2', '支行审批', '2', '008', null, '同意', '2018-03-27 09:42:42', '2018-03-27 09:43:00', '2018-03-27 09:43:00', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', null, null, null, '8b064d213f09409188db24941a18cae5');
INSERT INTO `tbl_task` VALUES ('node2', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node2', '支行审批', '2', '001', null, '同意', '2018-03-19 10:25:58', '2018-03-19 10:26:06', '2018-03-19 10:26:06', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', null, null, null, 'ae1eb6966b62450a83799c685d1e7ddc');
INSERT INTO `tbl_task` VALUES ('node3', '17f10f77dc654a5e861173544809f785', 'dcr_node3', '分行审查', '2', '008', null, '同意', '2018-03-05 19:42:34', '2018-03-05 19:48:10', '2018-03-05 19:48:10', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', null, null, null, 'b47374f1c0aa47869d87740bd08b08d1');
INSERT INTO `tbl_task` VALUES ('node3', '36337f68b5e344c09874606a534c3dfe', 'dcr_node3', '分行审查', '2', '008', null, '同意', '2018-03-21 19:49:58', '2018-03-21 19:50:33', '2018-03-21 19:50:33', 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', null, null, null, '8b7315687e8b4f9fb3eae97d63c99136');
INSERT INTO `tbl_task` VALUES ('node3', '4d2a4ed671eb408cb6d0cda925489d89', 'dcr_node3', '分行审查', '2', '008', null, '通过', '2018-03-05 11:16:10', '2018-03-05 11:16:27', '2018-03-05 11:16:27', 'CRAPP20180305000000164', 'C20180303000288', '阳光农场', 'BDcrLin', 'meng', null, null, null, '3a62078142164c59b93a176886d6a1c0');
INSERT INTO `tbl_task` VALUES ('node3', '760f1448e10e46b6b465524251decabc', 'dcr_node3', '分行审查', '2', '001', null, '同意', '2018-03-14 17:07:17', '2018-03-14 17:07:27', '2018-03-14 17:07:27', 'CRAPP20180314000000172', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', null, null, null, '2a186d25871640febabdd14338f4155d');
INSERT INTO `tbl_task` VALUES ('node3', '98713ef0932544ff82e4be380495b48e', 'dcr_node3', '分行审查', '2', '001', null, '否决', '2018-03-14 16:51:03', '2018-03-14 16:51:14', '2018-03-14 16:51:14', 'CRAPP20180314000000171', 'C20180305000307', '太平洋保险公司', 'BDcrLin', '王小宁', null, null, null, '3483f86418034ecbaa8180dcd9857c16');
INSERT INTO `tbl_task` VALUES ('node3', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node3', '分行审查', '2', '008', null, '同意', '2018-03-12 17:14:19', '2018-03-14 13:28:40', '2018-03-14 13:28:40', 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', null, null, null, '462c550871074c87bf82add4faa146a3');
INSERT INTO `tbl_task` VALUES ('node3', 'cc4046beca514524820bf894794c6ff4', 'dcr_node3', '分行审查', '2', '008', null, '通过', '2018-03-27 09:43:00', '2018-03-27 09:43:17', '2018-03-27 09:43:17', 'CRAPP20180322000000177', 'C20180305000305', '88888888-6', 'BDcrLin', 'meng', null, null, null, '947c289759164b678790ce0ef44f8240');
INSERT INTO `tbl_task` VALUES ('node3', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node3', '分行审查', '2', '001', null, '同意', '2018-03-19 10:26:06', '2018-03-19 10:26:20', '2018-03-19 10:26:20', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', null, null, null, 'd16b23974769424188baeacbd8abd3aa');
INSERT INTO `tbl_task` VALUES ('node4', '17f10f77dc654a5e861173544809f785', 'dcr_node4', '分行审批', '2', '008', null, '通过', '2018-03-05 19:48:10', '2018-03-05 19:48:29', '2018-03-05 19:48:29', 'CRAPP20180305000000163', 'C20180303000294', 'test', 'BDcrLin', 'meng', null, null, null, '006b8caeca254e48bd17810baa20848f');
INSERT INTO `tbl_task` VALUES ('node4', '36337f68b5e344c09874606a534c3dfe', 'dcr_node4', '分行审批', '0', null, null, null, '2018-03-21 19:50:34', null, null, 'CRAPP20180321000000176', 'C20180316000313', 'qqqq', 'BDcrLin', 'meng', null, null, null, null);
INSERT INTO `tbl_task` VALUES ('node4', 'afcd6d37e22e4f52800473bc42920fc4', 'dcr_node4', '分行审批', '0', null, null, null, '2018-03-14 13:28:40', null, null, 'CRAPP20180306000000168', 'C20180303000290', '123', 'BDcrLin', 'meng', null, null, null, null);
INSERT INTO `tbl_task` VALUES ('node4', 'f482de153db845c9b50a82faa3dcc75f', 'dcr_node4', '分行审批', '2', '001', null, '通过', '2018-03-19 10:26:20', '2018-03-19 10:26:30', '2018-03-19 10:26:30', 'CRAPP20180319000000174', 'C20180303000303', '伊利集团', 'BDcrLin', '王小宁', null, null, null, 'e14f65225696428a9e72c9e495d3a6b4');

-- ----------------------------
-- Table structure for `tbl_task_des`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_des`;
CREATE TABLE `tbl_task_des` (
  `TASK_DES_ID` varchar(32) NOT NULL,
  `NODE_ID` varchar(32) NOT NULL,
  `TASK_NAME` varchar(255) DEFAULT NULL,
  `TASK_SEQ` int(11) DEFAULT NULL,
  `TASK_DESCRIPTION` varchar(255) DEFAULT NULL,
  `IS_SKIPED` int(11) DEFAULT NULL,
  `MODEL_ID` varchar(32) NOT NULL,
  `UNIT_ID` varchar(32) DEFAULT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL,
  `ASSIGN_STRATEGY` int(11) DEFAULT NULL,
  `UNIT_LEVEL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`TASK_DES_ID`,`NODE_ID`,`MODEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_task_des
-- ----------------------------
INSERT INTO `tbl_task_des` VALUES ('Approve', 'Approve', '应收账款转让申请复核', '0', null, '0', 'FactoringAanwinstApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审批', '0', null, '0', 'AccountsReceivableInPool', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '回执', '0', null, '0', 'AccountsReceivableOutPool', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '普通仓单质物价格调整审批', '0', null, '0', 'AdjustPriceApplicationBill', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '价格调整审批', '0', '价格调整审批', '0', 'AdjustPriceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '任务审批', '0', null, '0', 'AdjustPriceApplyXhdt', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '任务申请', '0', null, '0', 'AdjustPriceApplyXphh', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审核', '0', null, '0', 'AllowanceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审核', '0', null, '0', 'AllowancePoolApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审批', '0', null, '0', 'CashEqualValueRegApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审批', '0', null, '0', 'DisMortgageBill', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审核', '0', null, '0', 'DisputeInvoicRemoveApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审核', '0', null, '0', 'DisputePoolInvoicRemoveApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '出质入库审核', '0', null, '0', 'DynamicQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '应收账款融资反转让', '0', null, '0', 'FactoringAccountRepurApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '申请审批', '0', null, '0', 'FactoringContApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审核', '0', null, '0', 'FactoringLeaseBuyBackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '复核', '0', null, '0', 'FactoringPoolAanwinstApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审批', '0', null, '0', 'FactoringPoolBuyBackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '审核', '0', null, '0', 'FourGuaBuybackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '出质入库审批', '0', null, '0', 'FourhousePledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审批', '0', null, '0', 'MarginApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审批', '0', null, '0', 'MaxBailTransferOutApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '批量调价审核', '0', null, '0', 'MultiPriceAdjustApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '批量调价审核', '0', null, '0', 'MultiPriceAdjustApplyXhdt', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '批量调价审核', '0', null, '0', 'MultiPriceAdjustApplyXhjt', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '应收账款融资减值申请审核', '0', null, '0', 'N-AllowanceApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '信保保理减值申请审核', '0', null, '0', 'N-AllowanceCreditApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '国内双保理减值申请审核', '0', null, '0', 'N-AllowanceDoubleApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '应收租金减值申请审核', '0', null, '0', 'N-AllowanceLeaseApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '应收账款池融资减值申请审核', '0', null, '0', 'N-AllowancePoolApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '审核岗审批', '0', null, '0', 'N-CreditFactFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '信保保理商纠登记审批', '0', null, '0', 'N-DisputeCreditInvoiceSetApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '信保保理商业纠纷登记解除审核', '0', null, '0', 'N-DisputeCreditInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '国内双保理商纠登记审批', '0', null, '0', 'N-DisputeDoubleInvoiceSetApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '国内双保理商业纠纷登记解除审核', '0', null, '0', 'N-DisputeDoubleInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '租赁保理商纠登记审批', '0', null, '0', 'N-DisputeLeaseInvoiceSetApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '应收租金商业纠纷登记解除审核', '0', null, '0', 'N-DisputeLeaseInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '审核岗审批', '0', null, '0', 'N-DoubleFactFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '申请审批', '0', null, '0', 'N-FactoringAccountRepurApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '信保保理应收账款转让申请复核', '1', null, '1', 'N-FactoringCreditAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '申请审批', '0', null, '0', 'N-FactoringCreditBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '国内双保理应收账款转让申请复核', '1', null, '1', 'N-FactoringDoubleAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '申请审批', '0', null, '0', 'N-FactoringDoubleBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '应收租金转让申请复核', '1', null, '1', 'N-FactoringLeaseAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '申请审批', '0', null, '0', 'N-FactoringLeaseBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '申请审批', '0', null, '0', 'N-FactoringPoolBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '审核岗审批', '0', null, '0', 'N-FinancingPoolApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '审核岗审批', '0', null, '0', 'N-InvoiceFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '审核岗审批', '0', null, '0', 'N-LeaseFactFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Approve_task', 'Approve', '业务审批', '0', null, '0', 'One2OneFourDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '出质入库审核', '0', null, '0', 'StaticQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '库存清单导入审批', '1', null, '1', 'StockListImportApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审批', '0', null, '0', 'ThreeDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('approve_task', 'Approve', '审核', '0', null, '0', 'ThreeGuaBuybackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('backToModify_task', 'backToModify', '退回', '0', null, '0', 'StockListImportApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('bcrrduebillapp_approve', 'BCrrDuebillApp_approve', '出账申请确认（信贷）', '0', null, '0', 'BCrrDuebillApp(XD)', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('bnode1', 'bnode1', '支行审查', '0', null, '0', 'BDcrLinApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('bnode2', 'bnode2', '支行审批', '0', null, '0', 'BDcrLinApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('bnode3', 'bnode3', '分行审查', '0', null, '0', 'BDcrLinApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('checkTransfer', 'checkTransfer', '应收账款转让申请复核', '0', '应收账款转让申请复核', '0', 'RBcpBussAppli', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('checkTransferAgain', 'checkTransferAgain', '应收账款转让申请回执确认', '0', '应收账款转让申请回执确认', '0', 'RBcpBussAppli', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '普通仓单追加核价', '0', null, '0', 'BillNormalAddApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '普通仓单质押核价', '0', null, '0', 'BillNormalQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '审批', '0', null, '0', 'BillNormalUnpledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('check_task', 'Check', '出质入库核价', '0', null, '0', 'DynamicQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '复核', '0', null, '0', 'FactoringPoolPaymentApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('check_task', 'Check', '出质入库核价', '0', null, '0', 'FourhousePledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '应收账款融资回款复核', '0', null, '0', 'N-CashPaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '信保保理应收账款回款复核', '0', null, '0', 'N-FactoringCreditPaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '国内双保理应收账款回款复核', '0', null, '0', 'N-FactoringDoublePaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '应收租金回款复核', '0', null, '0', 'N-FactoringLeasePaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Check_task', 'Check', '应收账款池融资回款复核', '1', null, '1', 'N-FactoringPoolPaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('check_task', 'Check', '回款专户转出确认', '0', null, '0', 'poolRePay', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('check_task', 'Check', '应收账款池融资回款专户转账确认', '0', null, '0', 'PoolReturnAccTransferApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('check_task', 'Check', '回款专户转出确认', '0', null, '0', 'ReversePaymentTransferApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('check_task', 'Check', '出质入库核价', '0', null, '0', 'StaticQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('confirmTransfer', 'confirmTransfer', '应收账款转让申请', '0', '应收账款转让申请', '0', 'RBcpBussAppli', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Confirm_task', 'Confirm', '普通仓单质押回执确认', '0', null, '0', 'BillNormalQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Confirm_task', 'Confirm', '普通仓单置换回执确认', '0', null, '0', 'BillNormalReplaceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Confirm_task', 'Confirm', '回执', '0', null, '0', 'BillNormalUnpledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('confirm_task', 'confirm', '复核岗审批', '0', null, '0', 'DisMortgageBill', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Confirm_task', 'Confirm', '应收类业务申请回执确认', '0', null, '0', 'FactoringContApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('creditEvalTask01', 'credictEvalNode1', '提交申请', '0', null, '0', 'creditEvalPrcssCreate', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('creditEvalTask02', 'credictEvalNode2', '信用评审', '0', null, '0', 'creditEvalPrcssCreate', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('disputeInvoiceSetSaveTask', 'DisputeInvoiceSetSave', '商纠提交', '0', null, '0', 'DisputeInvoiceSetApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('disputeInvoiceSetSubmitTask', 'DisputeInvoiceSetSubmit', '商纠审批', '0', null, '0', 'DisputeInvoiceSetApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DisputeInvoicRemoveApply1', 'Write', '申请', '0', null, '0', 'DisputeInvoicRemoveApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'BCrrDuebillApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '1', null, '1', 'BillNormalBillLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'BillNormalCashLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'FinancingPoolApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '1', null, '1', 'FourLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'FourLoanBillApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'InvoiceFinancingApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'MortgageBillLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'MortgageCashLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebilladd_task', 'duebilladd', '供应链补录', '0', null, '0', 'ThreeBillChargeOffApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'BCrrDuebillApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '1', null, '1', 'BillNormalBillLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'BillNormalCashLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'FinancingPoolApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '1', null, '1', 'FourLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'FourLoanBillApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'InvoiceFinancingApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'MortgageBillLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'MortgageCashLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('duebillappConfirm', 'duebillConfirm', '出账申请复核', '0', null, '0', 'ThreeBillChargeOffApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请审批', '0', '001', '0', 'BCrrDuebillApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请确认', '1', null, '1', 'BillNormalBillLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请确认', '0', null, '0', 'BillNormalCashLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请审批', '0', '001', '0', 'FinancingPoolApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请确认', '1', null, '1', 'FourLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请审批', '0', '001', '0', 'FourLoanBillApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请审批', '0', '001', '0', 'InvoiceFinancingApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请审批', '0', null, '0', 'MortgageBillLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请审批', '0', '001', '0', 'MortgageCashLoanApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('DuebillApp_Task', 'Approve_DuebillApp', '出账申请审批', '0', '001', '0', 'ThreeBillChargeOffApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('end_task', 'end', '最终审批', '0', null, '0', 'DisMortgageBill', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Issued_task', 'Issued', '非标仓单提货审批岗', '0', null, '0', 'BillNormalDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Issued_task', 'Issued', '现货静态质押提货到货赎货岗', '0', null, '0', 'DeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('LnAppApprove1_task', 'LnApp_approve1', '初审', '0', null, '0', 'BCrrLnApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('LnAppApprove2_task', 'LnApp_approve2', '复审', '0', null, '0', 'BCrrLnApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('LnAppApprove_task', 'LnApp_approve', '经办人确认', '0', null, '0', 'BCrrLnApp', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('NdisputeRegisterApprove', 'Approve', '商纠登记申请审批', '0', null, '0', 'N-DisputeInvoiceSetApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NdisputeRegisterApprove', 'Approve', '商纠登记申请审批', '1', null, '1', 'N-PoolDisputeInvoiceReg', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NdisputeRemoveApprove', 'Approve', '商纠登记解除申请审批', '1', null, '1', 'N-DisputeInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NdisputeRemoveApprove', 'Approve', '商纠登记解除申请审批', '0', null, '0', 'N-DisputePoolInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NInPoolApprove', 'Approve', '应收账款池融资入池审批', '1', null, '1', 'N-AccountsReceivableInPool', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('node1', 'dcr_node1', '支行审查', '0', null, '0', 'BDcrLin', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('node1', 'repayment_1', '应收账款管理岗', '0', null, '0', 'repayment', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('node2', 'dcr_node2', '支行审批', '0', null, '0', 'BDcrLin', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('node3', 'dcr_node3', '分行审查', '0', null, '0', 'BDcrLin', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('node4', 'dcr_node4', '分行审批', '0', null, '0', 'BDcrLin', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('noticeConfirm', 'noticeConfirm', '应收账款转让申请通过', '0', '应收账款转让申请通过', '0', 'RBcpBussAppli', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('NOutPoolApprove', 'Approve', '应收类出池申批', '1', null, '1', 'N-AccountsReceivableOutPool', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NPoolTransferApprove', 'Approve', '申请复核', '1', null, '1', 'N-FactoringPoolAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NPoolTransferReceipt', 'Receipt', '回执确认', '1', null, '1', 'N-FactoringPoolAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NTransferApprove', 'Approve', '转让复核', '1', null, '1', 'N-FactoringAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('NTransferReceipt', 'Receipt', '回执确认', '1', null, '1', 'N-FactoringAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('PoolDisputeInvoiceApproveTask', 'PoolDisputeInvoiceApprove', '池融资商纠审批', '0', null, '0', 'PoolDisputeInvoiceReg', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Pricing_task', 'Pricing', '普通仓单置换核价岗', '0', null, '0', 'BillNormalReplaceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt', 'Receipt', '应收账款池融资转让申请回执确认', '0', null, '0', 'FactoringPoolAanwinstApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'AdjusPrice_receipt', '回执确认', '0', null, '0', 'AdjustPriceApplicationBill', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'AdjusPrice_receipt', '回执确认', '0', null, '0', 'AdjustPriceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'AdjusPrice_receipt', '回执确认', '0', null, '0', 'AdjustPriceApplyXhdt', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'AdjusPrice_receipt', '回执确认', '0', null, '0', 'AdjustPriceApplyXphh', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '普通仓单追加监管商回执', '0', null, '0', 'BillNormalAddApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '回执确认', '0', null, '0', 'BillNormalDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '通知书回执确认', '0', null, '0', 'DebtPoolPressingApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '通知书回执确认', '0', null, '0', 'DebtPressingApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '现货静态质押提货回执确认', '0', null, '0', 'DeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'Receipt', '出质入库确认', '0', null, '0', 'DynamicQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '应收账款转让申请回执确认', '0', null, '0', 'FactoringAanwinstApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '应收账款核销回执确认', '0', null, '0', 'FactoringAccountCancelApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '回执确认', '0', null, '0', 'FactoringDebtPoolChargeOffApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '通知书回执确认', '0', null, '0', 'FourAccountConfirmApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '通知书回执确认', '0', null, '0', 'FourGuaBuybackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'Receipt', '出质入库确认', '0', null, '0', 'FourhousePledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '信保保理催收通知书回执确认', '0', null, '0', 'N-DebtCreditPressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '国内双保理催收通知书回执确认', '0', null, '0', 'N-DebtDoublePressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '应收租金催收通知书回执确认', '0', null, '0', 'N-DebtLeasePressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '应收账款池融资催收通知书回执确认', '0', null, '0', 'N-DebtPoolPressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '应收账款催收通知书回执确认', '0', null, '0', 'N-DebtPressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '应收账款融资核销回执确认', '0', null, '0', 'N-FactoringAccountCancelApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '信保保理应收账款融资核销回执确认', '0', null, '0', 'N-FactoringCreditChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '国内双保理应收账款核销回执确认', '0', null, '0', 'N-FactoringDoubleChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '应收租金核销回执确认', '0', null, '0', 'N-FactoringLeaseChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '回执确认', '1', null, '1', 'N-FactoringPoolChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '通知书回执确认', '0', null, '0', 'One2OneFourDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'Receipt', '出质入库确认', '0', null, '0', 'StaticQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'Receipt', '回执确认', '0', null, '0', 'ThreeAccountConfirmApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('receipt_task', 'Receipt', '通知书回执确认', '0', null, '0', 'ThreeDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Receipt_task', 'Receipt', '通知书回执确认', '0', null, '0', 'ThreeGuaBuybackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('requestTask', 'request', '减值申请任务', '0', null, '0', 'RBcpImpairment', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('requestTask', 'request', '减值申请任务', '0', null, '0', 'RBcpImpairmentPool', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Review_task', 'Review', '普通仓单追加审核', '0', null, '0', 'BillNormalAddApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Review_task', 'Review', '普通仓单质押经办行复核岗', '0', null, '0', 'BillNormalQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Review_task', 'Review', '普通仓单置换复核岗', '0', null, '0', 'BillNormalReplaceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Review_task', 'Review', '复核岗', '0', null, '0', 'BillNormalUnpledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Review_task', 'Review', '经办机构审查岗复', '0', null, '0', 'MaxBailTransferOutApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('sbcpappli_approve_task', 'sbcpappli_approve', '最低控货价值调整申请', '0', null, '0', 'ProtocolAmountApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('sbcpappli_check_task', 'sbcpappli_check', '最低控货价值调整复核', '0', null, '0', 'ProtocolAmountApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('sbcpappli_confirm_task', 'sbcpappli_confirm', '最低控货价值调整回执确认', '0', null, '0', 'ProtocolAmountApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Write', 'Write', '申请', '0', null, '0', 'AdjustPriceApplyXphh', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'AccountsReceivableInPool', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'AccountsReceivableOutPool', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'AdjustPriceApplicationBill', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'AdjustPriceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'AdjustPriceApplyXhdt', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'AllowanceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'AllowancePoolApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'BillNormalAddApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请岗', '0', null, '0', 'BillNormalDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', '001,008', '0', 'BillNormalQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'BillNormalReplaceApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'BillNormalUnpledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'CashEqualValueRegApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'CashPaymentApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'DebtPoolPressingApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'DebtPressingApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '现货静态质押提货填写岗', '0', null, '0', 'DeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'DisMortgageBill', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'DisputePoolInvoicRemoveApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'DynamicQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FactoringAanwinstApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'FactoringAccountCancelApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请复核', '0', null, '0', 'FactoringAccountRepurApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FactoringDebtPoolChargeOffApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FactoringLeaseBuyBackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FactoringPoolAanwinstApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FactoringPoolBuyBackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FactoringPoolPaymentApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FourAccountConfirmApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '1', null, '1', 'FourGuaBuybackApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'FourhousePledgeApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'MarginApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'MaxBailTransferOutApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'MultiPriceAdjustApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '批量调价申请', '0', null, '0', 'MultiPriceAdjustApplyXhdt', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'MultiPriceAdjustApplyXhjt', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收账款融资减值申请', '0', null, '0', 'N-AllowanceApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '信保保理减值申请', '0', null, '0', 'N-AllowanceCreditApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '国内双保理减值申请', '0', null, '0', 'N-AllowanceDoubleApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收租金减值申请', '0', null, '0', 'N-AllowanceLeaseApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收账款池融资减值申请', '0', null, '0', 'N-AllowancePoolApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-CreditFactFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '催收申请', '0', null, '0', 'N-DebtCreditPressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '催收申请', '0', null, '0', 'N-DebtDoublePressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '催收申请', '0', null, '0', 'N-DebtLeasePressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-DebtPoolPressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '催收申请', '0', null, '0', 'N-DebtPressingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '信保保理商纠登记申请', '0', null, '0', 'N-DisputeCreditInvoiceSetApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '信保保理商业纠纷登记解除申请', '0', null, '0', 'N-DisputeCreditInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '国内双保理商纠登记申请', '0', null, '0', 'N-DisputeDoubleInvoiceSetApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '国内双保理商业纠纷登记解除申请', '0', null, '0', 'N-DisputeDoubleInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '租赁保理商纠登记申请', '0', null, '0', 'N-DisputeLeaseInvoiceSetApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收租金商业纠纷登记解除申请', '0', null, '0', 'N-DisputeLeaseInvoicRemoveApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-DoubleFactFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收账款融资核销申请', '0', null, '0', 'N-FactoringAccountCancelApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请复核', '0', null, '0', 'N-FactoringAccountRepurApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '信保保理应收账款转让申请', '1', null, '1', 'N-FactoringCreditAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请复核', '0', null, '0', 'N-FactoringCreditBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '信保保理应收账款融资核销申请', '0', null, '0', 'N-FactoringCreditChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '信保保理应收账款回款申请', '0', null, '0', 'N-FactoringCreditPaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '国内双保理应收账款转让申请', '1', null, '1', 'N-FactoringDoubleAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请复核', '0', null, '0', 'N-FactoringDoubleBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '国内双保理应收账款核销申请', '0', null, '0', 'N-FactoringDoubleChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '国内双保理应收账款回款申请', '0', null, '0', 'N-FactoringDoublePaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收租金转让申请', '1', null, '1', 'N-FactoringLeaseAanwinstApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请复核', '0', null, '0', 'N-FactoringLeaseBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收租金核销申请', '0', null, '0', 'N-FactoringLeaseChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '应收租金回款申请', '0', null, '0', 'N-FactoringLeasePaymentApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-FactoringPoolBuyBackApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-FactoringPoolChargeOffApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-FinancingPoolApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-InvoiceFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '申请', '0', null, '0', 'N-LeaseFactFinancingApply', '200_00000', '100', '0', 'CURRENT');
INSERT INTO `tbl_task_des` VALUES ('Write_task', 'Write', '提货申请', '0', null, '0', 'One2OneFourDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'PoolDisputeInvoiceReg', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'poolRePay', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'PoolReturnAccTransferApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'ReversePaymentTransferApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'StaticQualityApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'StockListImportApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'ThreeAccountConfirmApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'ThreeDeliveryApply', null, null, '2', null);
INSERT INTO `tbl_task_des` VALUES ('write_task', 'Write', '申请', '0', null, '0', 'ThreeGuaBuybackApply', null, null, '2', null);

-- ----------------------------
-- Table structure for `tbl_task_des_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_des_user`;
CREATE TABLE `tbl_task_des_user` (
  `TASK_DES_ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `MODEL_ID` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_task_des_user
-- ----------------------------
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'CashPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '008', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'WBZ', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin01', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'caimin02', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'wbz', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'wbz', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'wbz', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'wbz', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', 'wbz', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task1', '001', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task1', '002', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin01', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin01', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin01', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin01', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin01', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin01', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin02', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin02', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin02', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin02', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin02', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'caimin02', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'wbz', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'wbz', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'wbz', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'wbz', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '001', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '002', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '003', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '004', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '008', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '008', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '008', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '008', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', '008', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', 'WBZ', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', 'caimin01', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', 'caimin02', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', 'wbz', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', 'wbz', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', 'wbz', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('Check_task', 'wbz', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Confirm_task', '008', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Confirm_task', '008', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Confirm_task', '008', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('Confirm_task', 'wbz', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Confirm_task', 'wbz', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Confirm_task', 'wbz', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', '001', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', '002', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', '003', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', '004', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', '008', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', 'WBZ', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', 'caimin01', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', 'caimin02', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply1', 'wbz', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', '001', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', '002', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', '003', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', '004', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', '008', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', 'WBZ', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', 'caimin01', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputeInvoicRemoveApply2', 'caimin02', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', '001', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', '002', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', '003', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', '004', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', '008', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', 'WBZ', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', 'caimin01', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply1', 'caimin02', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', '001', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', '002', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', '003', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', '004', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', '008', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', 'WBZ', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', 'caimin01', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DisputePoolInvoicRemoveApply2', 'caimin02', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'FourLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '001', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '001', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '001', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '001', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '001', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '001', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '002', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '002', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '002', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '002', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '002', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '003', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '003', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '003', 'PoolReturnAccTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '003', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '003', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '003', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '004', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '004', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '004', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '008', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '008', 'PoolReturnAccTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '008', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', '008', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'WBZ', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'WBZ', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'WBZ', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'caimin01', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'caimin01', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'caimin01', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'caimin02', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'caimin02', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'caimin02', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'wbz', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'wbz', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'wbz', 'PoolReturnAccTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'wbz', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'wbz', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('check_task', 'wbz', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', '001', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', '002', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', '003', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', '004', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', '008', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', 'WBZ', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', 'caimin01', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', 'caimin02', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirmTransfer', 'wbz', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('confirm_task', '003', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('confirm_task', '008', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('confirm_task', 'wbz', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', '001', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', '002', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', '003', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', '004', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', '88888888', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', 'WBZ', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', 'caimin01', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', 'caimin02', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask01', 'wbz', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', '001', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', '002', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', '003', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', '004', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', '88888888', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', 'WBZ', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', 'caimin01', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', 'caimin02', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEvalTask02', 'wbz', 'creditEvalPrcssCreate');
INSERT INTO `tbl_task_des_user` VALUES ('creditEval_tsk001', '007', 'creditEvalCret');
INSERT INTO `tbl_task_des_user` VALUES ('creditEval_tsk002', '007', 'creditEvalCret');
INSERT INTO `tbl_task_des_user` VALUES ('creditEval_tsk003', '007', 'creditEvalCret');
INSERT INTO `tbl_task_des_user` VALUES ('creditEval_tsk004', '007', 'creditEvalCret');
INSERT INTO `tbl_task_des_user` VALUES ('creditEval_tsk005', '007', 'creditEvalCret');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', '001', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', '002', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', '003', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', '004', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', '008', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', 'WBZ', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', 'caimin01', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', 'caimin02', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSaveTask', 'wbz', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', '001', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', '002', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', '003', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', '004', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', '008', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', 'WBZ', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', 'caimin01', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', 'caimin02', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('disputeInvoiceSetSubmitTask', 'wbz', 'DisputeInvoiceSetApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply1', '001', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply1', '002', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply1', '003', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply1', '008', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply2', '001', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply2', '002', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply2', '003', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowanceApply2', '008', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply1', '001', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply1', '002', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply1', '003', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply1', '008', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply2', '001', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply2', '002', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply2', '003', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('AllowancePoolApply2', '008', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '001', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '001', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '002', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '002', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '003', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '003', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '004', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '004', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '008', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', '008', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', 'WBZ', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', 'WBZ', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', 'caimin01', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', 'caimin01', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', 'caimin02', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', 'caimin02', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve', 'wbz', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '001', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '002', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '003', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '004', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '004', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '004', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '004', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '004', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '004', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '004', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', '008', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'WBZ', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'WBZ', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'WBZ', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'WBZ', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'WBZ', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Approve_task', 'WBZ', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '004', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '004', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '004', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '004', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '004', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '004', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '004', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'BillNormalBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'BillNormalCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'FourLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '008', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'WBZ', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'WBZ', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'WBZ', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'WBZ', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'WBZ', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'WBZ', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'WBZ', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin01', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin01', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin01', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin01', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin01', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin01', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin01', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin02', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin02', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin02', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin02', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin02', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin02', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'caimin02', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'BillNormalCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', 'wbz', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillfinal', '008', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('end_task', '003', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('end_task', '008', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('end_task', 'wbz', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '001', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '001', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '001', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '002', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '002', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '003', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '003', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '004', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '004', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '008', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', '008', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'WBZ', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'WBZ', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'caimin01', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'caimin01', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'caimin02', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'caimin02', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'wbz', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node1', 'wbz', 'repayment');
INSERT INTO `tbl_task_des_user` VALUES ('node1_task', 'user1', 'new_process');
INSERT INTO `tbl_task_des_user` VALUES ('node1_task', 'user2', 'new_process');
INSERT INTO `tbl_task_des_user` VALUES ('node1_task', 'user3', 'new_process');
INSERT INTO `tbl_task_des_user` VALUES ('node2', '001', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', '001', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('node2', '002', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', '003', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', '004', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', '008', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', 'WBZ', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', 'caimin01', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', 'caimin02', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node2', 'wbz', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', '001', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', '001', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('node3', '002', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', '003', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', '004', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', '008', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', 'WBZ', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', 'caimin01', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', 'caimin02', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node3', 'wbz', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', '001', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', '001', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('node4', '002', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', '003', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', '004', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', '008', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', 'WBZ', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', 'caimin01', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', 'caimin02', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('node4', 'wbz', 'BDcrLin');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', '001', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', '002', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', '003', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', '004', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', '008', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', 'WBZ', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', 'caimin01', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', 'caimin02', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('noticeConfirm', 'wbz', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('recInvoceDisputeregApprTask', '007', 'recInvoiceDisputeReg');
INSERT INTO `tbl_task_des_user` VALUES ('recInvoceDisputeregSaveTask', '007', 'recInvoiceDisputeReg');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '001', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '002', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '002', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '002', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '002', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '002', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '002', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '002', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '003', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '003', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '003', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '003', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '003', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '003', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '003', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '004', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '004', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '004', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '004', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '004', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '004', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '004', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'BillNormalBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'BillNormalCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'FourLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', '008', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'WBZ', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'WBZ', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'WBZ', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'WBZ', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'WBZ', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'WBZ', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'WBZ', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin01', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin01', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin01', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin01', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin01', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin01', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin01', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin02', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin02', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin02', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin02', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin02', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin02', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'caimin02', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'BillNormalCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('DuebillApp_Task', 'wbz', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Issued_task', '001', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Issued_task', '008', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Issued_task', '008', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Issued_task', 'wbz', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Issued_task', 'wbz', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', '001', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', '002', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', '003', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', '004', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', '008', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', 'WBZ', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', 'caimin01', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', 'caimin02', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', 'wbz', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', '001', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', '002', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', '003', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', '004', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', '008', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', 'WBZ', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', 'caimin01', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', 'caimin02', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', 'wbz', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', '001', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', '002', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', '003', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', '004', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', '008', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', 'WBZ', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', 'caimin01', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', 'caimin02', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', 'wbz', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnApp_Task', '008', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('MultiPriceAdjustApply1', '001', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('MultiPriceAdjustApply1', '003', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('MultiPriceAdjustApply2', '001', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('MultiPriceAdjustApply2', '003', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', '001', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', '002', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', '003', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', '004', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', '008', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', 'WBZ', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', 'caimin01', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', 'caimin02', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceApproveTask', 'wbz', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceSaveTask', '001', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceSaveTask', '003', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceSaveTask', '008', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('PoolDisputeInvoiceSubmitTask', '001', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('Pricing_task', '008', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Pricing_task', 'wbz', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('QualityApply', '001', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '001', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '001', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '002', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '002', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '003', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '003', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '004', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '004', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '008', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', '008', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', 'WBZ', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', 'WBZ', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', 'caimin01', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', 'caimin01', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', 'caimin02', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', 'caimin02', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt', 'wbz', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '001', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '002', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '003', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '004', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', '008', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'WBZ', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'FourLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '001', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '002', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '002', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '002', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '002', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '002', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '002', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '002', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '003', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '003', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '003', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '003', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '003', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '003', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '003', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '004', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '004', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '004', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '004', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '004', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '004', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '004', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'BillNormalBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'BillNormalCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'FourLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', '008', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'WBZ', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'WBZ', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'WBZ', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'WBZ', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'WBZ', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'WBZ', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'WBZ', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin01', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin01', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin01', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin01', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin01', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin01', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin01', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin02', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin02', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin02', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin02', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin02', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin02', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'caimin02', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'BillNormalCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebilladd_task', 'wbz', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'FourLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '001', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '002', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '002', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '002', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '002', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '002', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '002', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '002', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '003', 'BCrrDuebillApp');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '003', 'FinancingPoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '003', 'FourLoanBillApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '003', 'InvoiceFinancingApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '003', 'MortgageBillLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '003', 'MortgageCashLoanApply');
INSERT INTO `tbl_task_des_user` VALUES ('duebillappConfirm', '003', 'ThreeBillChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin01', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'caimin02', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Receipt_task', 'wbz', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review', '008', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', '008', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', '008', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', '008', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', '008', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', '008', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', 'wbz', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', 'wbz', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', 'wbz', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', 'wbz', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('Review_task', 'wbz', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('Start_task', '001', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '001', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '001', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '001', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '002', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '002', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '003', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '003', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '004', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '004', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '008', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '008', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', '008', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', 'WBZ', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', 'WBZ', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', 'caimin01', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', 'caimin01', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', 'caimin02', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', 'caimin02', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write', 'wbz', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'CashPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'DeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '001', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'CashPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '002', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'CashPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'One2OneFourDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '003', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'DebtPoolPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'DebtPressingApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'FactoringAccountCancelApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('Write_task', '004', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'MarginApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'MultiPriceAdjustApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '001', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '002', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '002', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '002', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '003', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '003', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '003', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '004', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'MultiPriceAdjustApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', '008', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'WBZ', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'caimin01', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'caimin02', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'MarginApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'MultiPriceAdjustApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('approve_task', 'wbz', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('backToModify_task', '001', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('backToModify_task', '008', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('backToModify_task', 'wbz', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('bcrr_lnapprove_task', '008', 'BCrrLnAppService');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', '001', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', '002', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', '003', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', '004', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', '008', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', 'WBZ', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', 'caimin01', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', 'caimin02', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', 'wbz', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', '001', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', '002', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', '003', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', '004', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', '008', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', 'WBZ', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', 'caimin01', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', 'caimin02', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode1', 'wbz', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', '001', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', '002', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', '003', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', '004', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', '008', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', 'WBZ', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', 'caimin01', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', 'caimin02', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode2', 'wbz', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', '001', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', '002', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', '003', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', '004', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', '008', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', 'WBZ', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', 'caimin01', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', 'caimin02', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('bnode3', 'wbz', 'BDcrLinApp');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', '001', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', '002', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', '003', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', '004', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', '008', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', 'WBZ', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', 'caimin01', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', 'caimin02', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransfer', 'wbz', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', '001', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', '002', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', '003', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', '004', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', '008', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', 'WBZ', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', 'caimin01', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', 'caimin02', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('checkTransferAgain', 'wbz', 'RBcpBussAppli');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '002', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '002', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '002', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '003', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '003', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '003', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '004', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '008', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '008', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '008', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '008', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '008', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', '008', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'WBZ', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'caimin01', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'caimin02', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('receipt_task', 'wbz', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('repay_approve', '008', 'BLanRepayApprove');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '001', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '001', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '002', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '002', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '003', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '003', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '004', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '004', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '008', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', '008', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', 'WBZ', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', 'WBZ', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', 'caimin01', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', 'caimin01', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', 'caimin02', 'RBcpImpairment');
INSERT INTO `tbl_task_des_user` VALUES ('requestTask', 'caimin02', 'RBcpImpairmentPool');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', '001', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', '002', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', '003', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', '004', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', '008', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', 'WBZ', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', 'caimin01', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', 'caimin02', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_approve_task', 'wbz', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', '001', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', '002', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', '003', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', '004', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', '008', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', 'WBZ', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', 'caimin01', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', 'caimin02', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_check_task', 'wbz', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', '001', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', '002', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', '003', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', '004', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', '008', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', 'WBZ', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', 'caimin01', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', 'caimin02', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('sbcpappli_confirm_task', 'wbz', 'ProtocolAmountApply');
INSERT INTO `tbl_task_des_user` VALUES ('thsq_task', '008', 'threeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('tzshzqr_task', '008', 'threeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'CashPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'MarginApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'MultiPriceAdjustApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'PoolReturnAccTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '001', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '002', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '002', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '002', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '002', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '002', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '002', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '003', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '003', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '003', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '003', 'PoolReturnAccTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '003', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '003', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '004', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '004', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '004', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'AdjustPriceApplyXphh');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'CashPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'DisputeInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'FourGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'MultiPriceAdjustApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'PoolReturnAccTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', '008', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'WBZ', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'WBZ', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'WBZ', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'WBZ', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin01', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin01', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin01', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin01', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin02', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin02', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin02', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'caimin02', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'AccountsReceivableInPool');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'AccountsReceivableOutPool');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'AdjustPriceApplicationBill');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'AdjustPriceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'AdjustPriceApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'AllowanceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'AllowancePoolApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'BillNormalAddApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'BillNormalDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'BillNormalQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'BillNormalReplaceApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'BillNormalUnpledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'CashEqualValueRegApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'CashPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'DisMortgageBill');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'DisputePoolInvoicRemoveApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'DynamicQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FactoringAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FactoringAccountRepurApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FactoringDebtPoolChargeOffApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FactoringLeaseBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FactoringPoolAanwinstApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FactoringPoolBuyBackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FactoringPoolPaymentApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FourAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'FourhousePledgeApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'MarginApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'MaxBailTransferOutApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'MultiPriceAdjustApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'MultiPriceAdjustApplyXhdt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'MultiPriceAdjustApplyXhjt');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'PoolDisputeInvoiceReg');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'PoolReturnAccTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'ReversePaymentTransferApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'StaticQualityApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'StockListImportApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'ThreeAccountConfirmApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'ThreeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'ThreeGuaBuybackApply');
INSERT INTO `tbl_task_des_user` VALUES ('write_task', 'wbz', 'poolRePay');
INSERT INTO `tbl_task_des_user` VALUES ('yesp_task', '008', 'threeDeliveryApply');
INSERT INTO `tbl_task_des_user` VALUES ('bcrrduebillapp_approve', '88888888', 'BCrrDuebillApp(XD)');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove1_task', '88888888', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove2_task', '88888888', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnAppApprove_task', '88888888', 'BCrrLnApp');
INSERT INTO `tbl_task_des_user` VALUES ('LnApp_Task', '88888888', 'BCrrLnApp');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_user_sys_test`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_sys_test`;
CREATE TABLE `tbl_user_sys_test` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `UNIT_ID` varchar(32) DEFAULT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL,
  `APPROVE_AMT` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user_sys_test
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_user_task`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_task`;
CREATE TABLE `tbl_user_task` (
  `ID` varchar(32) NOT NULL,
  `TASK_ID` varchar(32) DEFAULT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  `UNIT_ID` varchar(32) DEFAULT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL,
  `PROCESS_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user_task
-- ----------------------------
INSERT INTO `tbl_user_task` VALUES ('00b566d9a4154684b3d4eb4aea74b36b', 'creditEvalTask01', '002', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('01c673308e1f4abc850ec3f16f5b4990', 'node4', 'wbz', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('1742a4af8ff846d7a16bb7e69c262b61', 'creditEvalTask01', '004', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('17b29fe572784150aa21bff9e9d55840', 'node4', 'caimin02', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('1b4c265723c340fea272f5eda0780f3b', 'creditEvalTask01', 'WBZ', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('1c08fa97e4e34cc7800b61b92456d6ac', 'creditEvalTask01', '004', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('1d2f198ab5ee490096e63c4e400ce17b', 'creditEvalTask01', 'wbz', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('2089b942ca66487b8c4ee762cc61a920', 'node4', 'wbz', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('24b7d22cc0044d1c9efa57582199c04f', 'creditEvalTask01', 'caimin01', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('27834b279d184b9bab564bd3642f9d82', 'bcrrduebillapp_approve', '001', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('27f8a5e7bbbf40a2839363d9fef1a0cc', 'node4', '003', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('280598b33bc8499d9864ab07899b8535', 'LnAppApprove1_task', '003', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('2822ef6f9a4a45df8ee46d703d83971b', 'bcrrduebillapp_approve', '004', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('29ff9d5801da42ffa658667ebb864449', 'creditEvalTask01', 'WBZ', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('2afc385461de461e96f6f4f3070ba722', 'bcrrduebillapp_approve', '008', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('2b0ab646f18743c89eb8616322960841', 'creditEvalTask01', '003', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('2d39997057534381a52b4237dffe6254', 'creditEvalTask01', 'caimin01', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('2f5874e9bc6c4ccabd92504b2c3b3149', 'creditEvalTask01', '001', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('350f5cb74a444df497a33990bf8ef1a0', 'bcrrduebillapp_approve', '008', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('36219bbb93cf4c65a001364235510d79', 'node4', 'caimin01', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('3c5ce7da2baa4ebe94b3be57a1b0467c', 'bcrrduebillapp_approve', '001', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('3e902650af75478daf3879b7946eaf60', 'bcrrduebillapp_approve', '008', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('41795387a6e641a2bf8392191320718e', 'LnAppApprove1_task', 'caimin01', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('42507bb3a67c4d3da472308c447e6aae', 'LnAppApprove1_task', '008', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('48f7e766a1354a8f816c49c9339c06ca', 'bcrrduebillapp_approve', 'caimin02', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('4ae0448088fc4ca0ac40e1a7acfd7b86', 'bcrrduebillapp_approve', '002', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('4ea49208c1fa4572a5da2b1dd11d83de', 'creditEvalTask01', '003', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('518c4bc6c25148dc8d3b25f4a07b929f', 'bcrrduebillapp_approve', '002', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('55e0bff9c451400cb2b5bc89f9d31fea', 'bcrrduebillapp_approve', 'caimin02', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('588c2d6764d54854b9219741d3c5b5b8', 'node4', '008', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('5abd96c775c6423ba5a5a309668c58d9', 'LnAppApprove1_task', '88888888', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('5f892f367bcb4325b1d831cc5ec97a96', 'node4', 'WBZ', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('5fb5081099664453b906053c9bc0696d', 'creditEvalTask01', '008', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('66fb8d462cd84f42be8ebf353c5ddb4a', 'node4', '001', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('6c65e595fd6c4af98f02d6260ac1d921', 'bcrrduebillapp_approve', '008', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('6cd9bcd505614e50b84511b141890339', 'bcrrduebillapp_approve', 'caimin02', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('6f3d8c9dc0ca46968af6452fc75a6861', 'creditEvalTask01', '002', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('717204f740664ecd9e8c06e54933acf3', 'bcrrduebillapp_approve', '004', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('71d05657ace1475998b547ca91b0740b', 'bcrrduebillapp_approve', '002', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('85ba44e785d44353acd85a53d99df0e1', 'node4', 'caimin01', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('8843764a30af4dd1bac84fe48dd65e25', 'bcrrduebillapp_approve', 'WBZ', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('89d2370734e542a4ba9ead05d3d16138', 'bcrrduebillapp_approve', 'caimin01', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('8a28986bda6e46e4be0d222c3ae6f822', 'LnAppApprove1_task', 'wbz', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('8b849603d3134f0fb446f099e56bbefd', 'bcrrduebillapp_approve', 'WBZ', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('8cc2c5aa97004b5c8f6bcd2d8b7b5c2a', 'LnAppApprove1_task', '001', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('8d482d453de249be9895de5ac6445e54', 'bcrrduebillapp_approve', 'wbz', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('8db418e687d74905ae731ff2005fcb8d', 'node4', '001', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('9220149554bb4d9f8d6f37bfb285f376', 'bcrrduebillapp_approve', 'WBZ', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('953ee2684f244aacab2f6fa71c9f4026', 'creditEvalTask01', 'caimin02', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('98d701f5cf134782b115e8937053550d', 'creditEvalTask01', '004', '', '', 'da96537a56a043ffacd6a165dd080de2');
INSERT INTO `tbl_user_task` VALUES ('9ca7baa1a6f04462a5d570227b1ee66d', 'bcrrduebillapp_approve', 'caimin01', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('9faf3e49b13f46cb976c918a9f41061d', 'bcrrduebillapp_approve', 'caimin01', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('9fd58eb5a2974840b5e845b339e3ab34', 'creditEvalTask01', '008', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('a1108384249a48be9e5ec23b644f8afa', 'bcrrduebillapp_approve', 'wbz', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('a31d8dd4a9d94a6498ac3ee278d8a908', 'creditEvalTask01', 'wbz', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('a73fc5881b0a4abd902945a056e359d8', 'LnAppApprove1_task', 'caimin02', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('aac130ca14af4bc4b60bb550ce8bc0f8', 'bcrrduebillapp_approve', '004', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('af081ec809184d5ab4c4115d1d34eccb', 'bcrrduebillapp_approve', 'wbz', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('af31e8da88144cd99a1920b865f1ee09', 'bcrrduebillapp_approve', 'caimin01', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('afcded1d250547bc9149147a15bdfaa9', 'bcrrduebillapp_approve', '001', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('b06fa6a7faa0454e84f4be67bfe6e876', 'bcrrduebillapp_approve', '003', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('b0e878884cea4875a24b96ab2cd5de78', 'node4', '002', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('b55a4488b2394d3dbb0fcd1ca2d5fd1c', 'bcrrduebillapp_approve', '003', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('b6ca472e7b9e46f380ddc00f280117ff', 'creditEvalTask01', 'caimin02', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('ba77f083f09d4734a377e1a755776361', 'creditEvalTask01', '002', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('bb4f842f36504936b6471d582b804528', 'bcrrduebillapp_approve', '003', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('c0e9c714ffb84d18a67c79e353702a06', 'bcrrduebillapp_approve', '003', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('c1f3fdb80cf04209bb539bc2ca1070c8', 'creditEvalTask01', '003', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('c777b38948754f37a2e6bc21add3d84d', 'LnAppApprove1_task', '002', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('cb750c694bcd4979a7699dc1b77879e2', 'node4', '004', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('d55aa96fbdba4bc28de655bc6abde3db', 'node4', 'WBZ', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('d696908db1824a278f1e25f69df0667a', 'creditEvalTask01', 'WBZ', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('d96c9b04ea5846c6bb952148409cf6ce', 'LnAppApprove1_task', 'WBZ', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('da8de3ef925e45cf8631ab7337d21416', 'bcrrduebillapp_approve', 'WBZ', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('def9541f91ca40a7b4c51c77ef818389', 'node4', '008', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('e10adbb6dd174e79a85e12f643ba13a2', 'creditEvalTask01', 'wbz', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('e362a5fa26824113979372134938aad8', 'creditEvalTask01', '001', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('ec84a0ffb6d84be8b1b0acfbd7e65d2c', 'bcrrduebillapp_approve', 'wbz', '', '', '69b37cbee8c645e7a4269ad4e062df91');
INSERT INTO `tbl_user_task` VALUES ('ed82ed7e902440b19e665f7b59e81ff0', 'node4', '003', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('edb1e84104d148b7a5de2f8e29e683ff', 'LnAppApprove1_task', '004', null, '', 'd10b904cef0d4e95953481e73086cf03');
INSERT INTO `tbl_user_task` VALUES ('f0e5f9dd3e65436eb0f6ff2cd192156a', 'creditEvalTask01', 'caimin01', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('f2e69e496ab54966b4c01ee461845403', 'bcrrduebillapp_approve', '004', '', '', '19a802007c5744ab826f25c11b59d84e');
INSERT INTO `tbl_user_task` VALUES ('f387c700655c43209cde2375a24a1e23', 'node4', '002', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('f574138225f448f4a0dce274430f0b6c', 'node4', 'caimin02', null, '', 'afcd6d37e22e4f52800473bc42920fc4');
INSERT INTO `tbl_user_task` VALUES ('f8b689c895994aa0af119c3dd15eee6e', 'creditEvalTask01', '008', '', '', '5dc5f596fb9d496ca5a192d838a80fb8');
INSERT INTO `tbl_user_task` VALUES ('f8b766ca32a7473d8b188b5690d70fbe', 'creditEvalTask01', '001', '', '', '928807fda9254fae9cf1d3c7c6e524d2');
INSERT INTO `tbl_user_task` VALUES ('fa951e72b4f24f36ac9bd7e62e45613a', 'bcrrduebillapp_approve', '002', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('fb3dcce28259457992726d49dbbd7cd3', 'node4', '004', null, '', '36337f68b5e344c09874606a534c3dfe');
INSERT INTO `tbl_user_task` VALUES ('fc2016dd2af74952b229f3132cee0894', 'bcrrduebillapp_approve', '001', '', '', '7c6c7c3b6e554d2d91468b6e3a5cfe6b');
INSERT INTO `tbl_user_task` VALUES ('fe78fb753a9f425e8828f383183d9d00', 'bcrrduebillapp_approve', 'caimin02', '', '', '558f4088198a43518fa36e304cbda1e8');
INSERT INTO `tbl_user_task` VALUES ('ffffbc85cf644210bc9add62fb1b7b6a', 'creditEvalTask01', 'caimin02', '', '', 'da96537a56a043ffacd6a165dd080de2');
