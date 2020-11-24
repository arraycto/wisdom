/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : wisdom

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 08/05/2019 18:14:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_lecturer
-- ----------------------------
DROP TABLE IF EXISTS `apply_lecturer`;
CREATE TABLE `apply_lecturer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `advantage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '个人优势',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '理由',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `apply_time` datetime(0) NOT NULL COMMENT '申请时间',
  `status` int(20) NOT NULL COMMENT '0：待审核 1：通过 2： 未通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply_lecturer
-- ----------------------------
INSERT INTO `apply_lecturer` VALUES (2, '我很强', '我很强', 2, 'shanji', '2019-04-27 15:24:13', 0);
INSERT INTO `apply_lecturer` VALUES (3, '我是崔志文', '我是崔志文', 5, 'cuizhiwen', '2019-04-27 15:47:30', 0);

-- ----------------------------
-- Table structure for common_carousel
-- ----------------------------
DROP TABLE IF EXISTS `common_carousel`;
CREATE TABLE `common_carousel`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `corousel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图名称',
  `carousel_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图图片地址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_classify
-- ----------------------------
DROP TABLE IF EXISTS `course_classify`;
CREATE TABLE `course_classify`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父节点',
  `classify_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `create_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_classify
-- ----------------------------
INSERT INTO `course_classify` VALUES (1, 0, '前端 | 小程序 | JS', 'oldghoast', '2019-02-26 10:27:29', 'oldghoast', '2019-02-26 11:49:30');
INSERT INTO `course_classify` VALUES (2, 0, '后端 | Java | Python', 'oldghoast', '2019-02-26 10:27:32', 'oldghoast', '2019-02-26 11:49:33');
INSERT INTO `course_classify` VALUES (3, 0, '移动 | Android | iOS', 'oldghoast', '2019-02-26 10:27:35', 'oldghoast', '2019-02-26 11:49:35');
INSERT INTO `course_classify` VALUES (4, 0, '云计算 | 大数据 | 容器', 'oldghoast', '2019-02-26 10:27:37', 'oldghoast', '2019-02-26 11:49:37');
INSERT INTO `course_classify` VALUES (5, 0, '运维 | 测试 | 数据库', 'oldghoast', '2019-02-26 10:27:41', 'oldghoast', '2019-02-26 11:49:41');
INSERT INTO `course_classify` VALUES (6, 0, 'UI设计 | 3D动画 | 游戏', 'oldghoast', '2019-02-26 10:27:43', 'oldghoast', '2019-02-26 11:49:44');
INSERT INTO `course_classify` VALUES (7, 1, '小程序', 'oldghoast', '2019-02-26 10:40:06', 'oldghoast', '2019-02-26 11:49:46');
INSERT INTO `course_classify` VALUES (8, 1, 'JavaScript', 'oldghoast', '2019-02-26 10:40:37', 'oldghoast', '2019-02-26 11:49:50');
INSERT INTO `course_classify` VALUES (9, 1, 'HTML/CSS', 'oldghoast', '2019-02-26 10:42:03', 'oldghoast', '2019-02-26 11:49:52');
INSERT INTO `course_classify` VALUES (10, 1, 'Vue.js', 'oldghoast', '2019-02-26 10:43:58', 'oldghoast', '2019-02-26 11:49:55');
INSERT INTO `course_classify` VALUES (11, 1, 'Node.js', 'oldghoast', '2019-02-26 10:44:27', 'oldghoast', '2019-02-26 11:49:57');
INSERT INTO `course_classify` VALUES (12, 1, 'jQuery', 'oldghoast', '2019-02-26 10:44:53', 'oldghoast', '2019-02-26 11:49:59');
INSERT INTO `course_classify` VALUES (13, 1, 'BootStrap', 'oldghoast', '2019-02-26 10:45:25', 'oldghoast', '2019-02-26 11:50:01');
INSERT INTO `course_classify` VALUES (14, 1, 'AngularJS', 'oldghoast', '2019-02-26 10:46:49', 'oldghoast', '2019-02-26 11:50:04');
INSERT INTO `course_classify` VALUES (15, 2, 'Java', 'oldghoast', '2019-02-26 10:48:45', 'oldghoast', '2019-02-26 11:50:06');
INSERT INTO `course_classify` VALUES (16, 2, 'Python', 'oldghoast', '2019-02-26 10:49:15', 'oldghoast', '2019-02-26 11:50:08');
INSERT INTO `course_classify` VALUES (17, 2, 'C', 'oldghoast', '2019-02-26 10:49:59', 'oldghoast', '2019-02-26 11:50:10');
INSERT INTO `course_classify` VALUES (18, 2, 'C++', 'oldghoast', '2019-02-26 10:50:16', 'oldghoast', '2019-02-26 11:50:13');
INSERT INTO `course_classify` VALUES (19, 2, 'C#', 'oldghoast', '2019-02-26 10:50:40', 'oldghoast', '2019-02-26 11:50:16');
INSERT INTO `course_classify` VALUES (20, 2, 'PHP', 'oldghoast', '2019-02-26 10:51:15', 'oldghoast', '2019-02-26 11:50:19');
INSERT INTO `course_classify` VALUES (21, 3, 'Android', 'oldghoast', '2019-02-26 10:51:58', 'oldghoast', '2019-02-26 11:50:22');
INSERT INTO `course_classify` VALUES (22, 3, 'iOS', 'oldghoast', '2019-02-26 10:52:08', 'oldghoast', '2019-02-26 11:50:24');
INSERT INTO `course_classify` VALUES (23, 4, '算法与数据结构', 'oldghoast', '2019-02-26 13:04:35', 'oldghoast', '2019-02-26 13:04:37');
INSERT INTO `course_classify` VALUES (24, 4, '大数据', 'oldghoast', '2019-02-26 13:05:09', 'oldghoast', '2019-02-26 13:05:12');
INSERT INTO `course_classify` VALUES (25, 4, '云计算', 'oldghoast', '2019-02-26 13:05:44', 'oldghoast', '2019-02-26 13:05:47');
INSERT INTO `course_classify` VALUES (26, 5, 'Linux', 'oldghoast', '2019-02-26 13:06:44', 'oldghoast', '2019-02-26 13:12:29');
INSERT INTO `course_classify` VALUES (27, 5, '自动化测试', 'oldghoast', '2019-02-26 13:07:22', 'oldghoast', '2019-02-26 13:12:31');
INSERT INTO `course_classify` VALUES (28, 5, 'MySQL', 'oldghoast', '2019-02-26 13:08:01', 'oldghoast', '2019-02-26 13:12:36');
INSERT INTO `course_classify` VALUES (29, 5, 'Redis', 'oldghoast', '2019-02-26 13:08:19', 'oldghoast', '2019-02-26 13:12:34');
INSERT INTO `course_classify` VALUES (30, 5, 'Oracle', 'oldghoast', '2019-02-26 13:08:52', 'oldghoast', '2019-02-26 13:12:38');
INSERT INTO `course_classify` VALUES (31, 5, 'MongoDB', 'oldghoast', '2019-02-26 13:09:20', 'oldghoast', '2019-02-26 13:12:39');
INSERT INTO `course_classify` VALUES (32, 6, '模型制作', 'oldghoast', '2019-02-26 13:09:50', 'oldghoast', '2019-02-26 13:12:41');
INSERT INTO `course_classify` VALUES (33, 6, '动画特效', 'oldghoast', '2019-02-26 13:10:34', 'oldghoast', '2019-02-26 13:12:45');
INSERT INTO `course_classify` VALUES (34, 6, 'Unity 3D', 'oldghoast', '2019-02-26 13:10:36', 'oldghoast', '2019-02-26 13:12:44');

-- ----------------------------
-- Table structure for course_collection
-- ----------------------------
DROP TABLE IF EXISTS `course_collection`;
CREATE TABLE `course_collection`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `course_id` bigint(20) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_collection
-- ----------------------------
INSERT INTO `course_collection` VALUES (4, 2, 11);
INSERT INTO `course_collection` VALUES (7, 2, 12);

-- ----------------------------
-- Table structure for course_comment
-- ----------------------------
DROP TABLE IF EXISTS `course_comment`;
CREATE TABLE `course_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论人姓名',
  `head_portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论人头像',
  `course_id` bigint(20) NOT NULL COMMENT '课程id',
  `comment_time` datetime(0) NOT NULL COMMENT '评论时间',
  `status` int(20) NOT NULL COMMENT '0：删除 1：通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_comment
-- ----------------------------
INSERT INTO `course_comment` VALUES (4, '评论大撒大撒', 'shanji', 'http://localhost:8080/files/default/user-default-image.jpg', 12, '2019-04-24 21:39:50', 1);

-- ----------------------------
-- Table structure for course_detail
-- ----------------------------
DROP TABLE IF EXISTS `course_detail`;
CREATE TABLE `course_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程标题',
  `course_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程封面图片',
  `course_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程视频地址',
  `course_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程介绍',
  `course_classify` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程分类',
  `course_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程发布人',
  `upload_time` datetime(0) NOT NULL COMMENT '上传时间',
  `status` int(20) NOT NULL DEFAULT 1 COMMENT '0:未审核 1：审核通过 2：审核未通过',
  `recommendation_index` int(20) NOT NULL DEFAULT 1 COMMENT '推荐指数（1-3）',
  `click_rate` bigint(20) NOT NULL DEFAULT 0 COMMENT '点击量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_detail
-- ----------------------------
INSERT INTO `course_detail` VALUES (7, '01_课程内容简介', 'http://localhost:8080/files/shiweida/01_课程内容简介/cover.jpg', 'http://localhost:8080/files/shiweida/01_课程内容简介/video.mp4', 'SpringBoot与Shiro整合-权限管理实战视频', 'Java', 'shiweida', '2019-04-07 17:14:33', 1, 3, 122);
INSERT INTO `course_detail` VALUES (8, '02_shiro框架介绍', 'http://localhost:8080/files/shiweida/02_shiro框架介绍/cover.jpg', 'http://localhost:8080/files/shiweida/02_shiro框架介绍/video.mp4', 'SpringBoot与Shiro整合-权限管理实战视频', 'Java', 'shiweida', '2019-04-08 21:49:48', 1, 2, 233);
INSERT INTO `course_detail` VALUES (9, '03_快速搭建开发运行环境', 'http://localhost:8080/files/shiweida/03_快速搭建开发运行环境/cover.jpg', 'http://localhost:8080/files/shiweida/03_快速搭建开发运行环境/video.mp4', 'SpringBoot与Shiro整合-权限管理实战视频', 'Java', 'shiweida', '2019-04-08 21:54:47', 1, 2, 343);
INSERT INTO `course_detail` VALUES (10, '04_项目引入Thymeleaf', 'http://localhost:8080/files/shiweida/04_项目引入Thymeleaf/cover.jpg', 'http://localhost:8080/files/shiweida/04_项目引入Thymeleaf/video.mp4', 'SpringBoot与Shiro整合-权限管理实战视频', 'Java', 'shiweida', '2019-04-08 21:56:53', 1, 1, 213);
INSERT INTO `course_detail` VALUES (11, '05_Shiro认证-配置类', 'http://localhost:8080/files/shiweida/05_Shiro认证-配置类/cover.jpg', 'http://localhost:8080/files/shiweida/05_Shiro认证-配置类/video.mp4', 'SpringBoot与Shiro整合-权限管理实战视频', 'Java', 'shiweida', '2019-04-08 21:59:30', 1, 2, 4326);
INSERT INTO `course_detail` VALUES (12, '06_使用Shiro过滤器实现认证资源', 'http://localhost:8080/files/shiweida/06_使用Shiro过滤器实现认证资源/cover.jpg', 'http://localhost:8080/files/shiweida/06_使用Shiro过滤器实现认证资源/video.mp4', 'SpringBoot与Shiro整合-权限管理实战视频', 'Java', 'shiweida', '2019-04-14 14:40:48', 1, 1, 43);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '系统管理者');
INSERT INTO `sys_role` VALUES (2, '讲师', '发布教学视频');
INSERT INTO `sys_role` VALUES (3, '普通用户', '网站浏览者');

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting`  (
  `id` int(20) NOT NULL,
  `setting_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设置名称',
  `setting_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设置内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_setting
-- ----------------------------
INSERT INTO `sys_setting` VALUES (1, 'upload_path', 'D:/Resource/wisdom/');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `head_portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birth` date NULL DEFAULT NULL COMMENT '出生日期',
  `phone` bigint(255) NULL DEFAULT NULL COMMENT '联系方式',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` int(20) NOT NULL DEFAULT 1 COMMENT '0：禁用 1：正常',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '038bdaf98f2037b31f1e75b5b4c9b26e', 'http://localhost:8080/files/default/admin-image.jpg', '陈小兵', '男', '1997-07-31', 18852968693, '2281901186@qq.com', 1, '2019-01-27 19:13:02', 1);
INSERT INTO `sys_user` VALUES (2, 'shanji', '06f25e81787446face9299d90a60c639', 'http://localhost:8080/files/default/user-default-image.jpg', '陈桧庆', '男', '1996-02-23', 18852968693, 'das@qq.com', 1, '2019-01-31 21:16:18', 3);
INSERT INTO `sys_user` VALUES (3, 'shiweida', '6e6bf44d5a52effef60759d2406b7918', 'http://localhost:8080/files/default/user-default-image.jpg', '施伟大', '男', NULL, NULL, '', 1, '2019-01-31 21:25:56', 2);
INSERT INTO `sys_user` VALUES (4, 'chenlei', 'c8db30d13b404f635b673c2c66431673', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-01-31 21:31:09', 3);
INSERT INTO `sys_user` VALUES (5, 'cuizhiwen', 'bba025bee8bed935b3ad8c9de42fa664', 'http://localhost:8080/files/default/user-default-image.jpg', '崔志文', '', NULL, NULL, '', 1, '2019-01-31 21:40:07', 3);
INSERT INTO `sys_user` VALUES (6, 'huawei', '961062ea95ae930494cbcc285064f139', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 01:21:56', 3);
INSERT INTO `sys_user` VALUES (7, 'apple', '705de5b7ee3313a9e0d551e7b735f9ed', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 01:28:53', 3);
INSERT INTO `sys_user` VALUES (8, 'oneplus', '159b51f9fdae4fb582a2cec8ec4ce1a8', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 01:32:38', 3);
INSERT INTO `sys_user` VALUES (9, 'honor', '561cb87cc73e7341afe0b36f8462657b', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 01:35:39', 3);
INSERT INTO `sys_user` VALUES (10, 'dell', '9494e5b532455be8eb6b56c3469eb2b3', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 01:49:59', 3);
INSERT INTO `sys_user` VALUES (11, 'spring', '03576d51aaf6384e54c06b423473bdfe', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 20:40:07', 3);
INSERT INTO `sys_user` VALUES (12, 'layui', 'cf8e2e8755afd512f4f979a9acbffcab', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 20:40:59', 3);
INSERT INTO `sys_user` VALUES (13, 'bootstrap', 'ae51fb0319890ba7a73aed31a17075e2', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-01 20:41:59', 3);
INSERT INTO `sys_user` VALUES (14, 'google', '891226cbab4f6361cbf4c0426f710037', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-05 02:42:43', 3);
INSERT INTO `sys_user` VALUES (16, 'cxbcxb', '1b63fe558b979a584b7845c6638b2a3d', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 03:05:55', 3);
INSERT INTO `sys_user` VALUES (17, 'lololol', '6c376834f0b86a5bbed5f74092e2117b', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 03:16:14', 3);
INSERT INTO `sys_user` VALUES (18, 'lengula', '446179a8c253fe0a785b174119390415', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 03:17:39', 3);
INSERT INTO `sys_user` VALUES (19, 'sasdasd', 'd0660b9084f618c5400eff831981311e', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 03:27:05', 3);
INSERT INTO `sys_user` VALUES (20, 'dsadsa', '54b9c484ca3109cd75fb8dcc0b4e7fca', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 11:38:08', 3);
INSERT INTO `sys_user` VALUES (21, '123456', 'fa89e5302256d3da3007cad3234742a4', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 11:39:16', 3);
INSERT INTO `sys_user` VALUES (22, 'qwerqwer', '9e8f61e3ac73f896b1be32a8e85eab72', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 11:41:46', 3);
INSERT INTO `sys_user` VALUES (23, 'swd', '074b5b09c4be38c97f73dadd2943221f', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-02-27 16:39:34', 3);
INSERT INTO `sys_user` VALUES (25, 'tly', '308afc3bb8170e705071caa94fc01847', 'http://localhost:8080/files/default/user-default-image.jpg', NULL, NULL, NULL, NULL, NULL, 1, '2019-04-06 13:43:28', 3);

SET FOREIGN_KEY_CHECKS = 1;
