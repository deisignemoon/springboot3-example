/*
 Navicat Premium Data Transfer

 Source Server         : local-docker-mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 192.168.197.100:3306
 Source Schema         : maindata

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 14/05/2024 16:15:48
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_usr
-- ----------------------------
DROP TABLE IF EXISTS `sys_usr`;
CREATE TABLE `sys_usr`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `usr_no`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户编号',
    `usr_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
    `birthday`    date                                                          NOT NULL COMMENT '生日',
    `passwd`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
    `status`      tinyint(1) NOT NULL DEFAULT 0 COMMENT '生效状态(0-不生效，1-已生效)',
    `del_status`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除状态（0-已删除，1-未删除）',
    `create_time` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `create_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
    `update_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_usr
-- ----------------------------
INSERT INTO `sys_usr`
VALUES (1, '001', 'zoe', '2004-01-01', 'passwd', 0, 0, '2024-05-09 07:17:08', '2024-05-14 07:24:15', '000', NULL);
INSERT INTO `sys_usr`
VALUES (2, '002', 'bob', '2013-01-09', 'passwd', 1, 1, '2024-05-09 07:17:35', '2024-05-10 03:32:20', '000', NULL);
INSERT INTO `sys_usr`
VALUES (3, '003', 'alice', '2021-01-01', 'passwd', 1, 1, '2024-05-09 07:19:08', '2024-05-10 03:32:20', '000', NULL);

SET
FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `sys_group`
(
    `id`          int      NOT NULL AUTO_INCREMENT,
    `group_code`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户组编号',
    `group_name`  varchar(255) COLLATE utf8mb4_general_ci                      DEFAULT NULL COMMENT '用户组名称',
    `status`      tinyint(1) NOT NULL DEFAULT '0' COMMENT '生效状态',
    `del_status`  tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
    `create_time` datetime NOT NULL                                            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL                                            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `create_by`   varchar(32) COLLATE utf8mb4_general_ci                       DEFAULT NULL COMMENT '创建人',
    `update_by`   varchar(32) COLLATE utf8mb4_general_ci                       DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户组表';

CREATE TABLE `sys_permission`
(
    `id`              int                                                           NOT NULL,
    `permission_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL COMMENT '权限编号',
    `permission_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
    `status`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '生效状态',
    `del_status`      tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
    `create_time`     datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `create_by`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL COMMENT '创建人',
    `update_by`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限表';

CREATE TABLE `sys_role`
(
    `id`             int                                                           NOT NULL,
    `role_code`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '角色编号',
    `parent_role_no` varchar(32) COLLATE utf8mb4_general_ci                                 DEFAULT NULL COMMENT '父角色编号',
    `role_name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色姓名',
    `status`         tinyint(1) NOT NULL DEFAULT '0' COMMENT '生效状态',
    `del_status`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
    `create_time`    datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `create_by`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL COMMENT '创建人',
    `update_by`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

CREATE TABLE `sys_role_permission`
(
    `role_code`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色编号',
    `permission_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限编号',
    UNIQUE KEY `uni_role_code_permission_code` (`role_code`,`permission_code`) USING BTREE COMMENT '角色-权限唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色-权限关联表';

CREATE TABLE `sys_usr_group`
(
    `usr_no`     varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户编号',
    `group_code` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户组编号',
    UNIQUE KEY `uni_user_group_code` (`usr_no`,`group_code`) USING BTREE COMMENT '用户-用户组唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户-用户组关联表';

CREATE TABLE `sys_usr_role`
(
    `usr_no`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户编号',
    `role_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色编号',
    UNIQUE KEY `uni_user_role_code` (`usr_no`,`role_code`) USING BTREE COMMENT '用户-权限唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户-角色关联表';

CREATE TABLE `sys_group_role`
(
    `group_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户组编号',
    `role_code`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色编号',
    UNIQUE KEY `uni_role_code_group_code` (`group_code`,`role_code`) USING BTREE COMMENT '角色-用户组唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户组-角色关联表';
