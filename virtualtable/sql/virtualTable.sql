CREATE TABLE `virtual_table`
(
    `id`           int unsigned NOT NULL AUTO_INCREMENT,
    `table_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名',
    `memo`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '描述',
    `delete_sts`   char(1) COLLATE utf8mb4_general_ci                            NOT NULL DEFAULT '0',
    `gmt_create`   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='虚拟表定义表';
CREATE TABLE `virtual_table_columns`
(
    `id`           int                                                           NOT NULL AUTO_INCREMENT,
    `table_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名',
    `column_id`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字段名称',
    `column_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '字段描述',
    `column_type`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '字段数据类型',
    `sort`         int                                                           NOT NULL COMMENT '字段顺序',
    `memo`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '描述',
    `key_sts`      char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NOT NULL DEFAULT '0' COMMENT '是否为键，0-普通字段，1-键字段',
    `delete_sts`   char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-已删除',
    `gmt_create`   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    KEY            `idx_table_name` (`table_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='虚拟表字段定义表';
CREATE TABLE `virtual_table_data`
(
    `id`           int                                                           NOT NULL AUTO_INCREMENT,
    `table_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名',
    `field_value`  longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据',
    `pk_value`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '键值',
    `delete_sts`   char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否删除（0-未删除，1-已删除）',
    `gmt_create`   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    KEY            `idx_field_index` (`pk_value`) USING BTREE COMMENT '虚拟表索引值'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='虚拟表数据表';
CREATE TABLE `virtual_table_index`
(
    `id`           int                                                           NOT NULL AUTO_INCREMENT,
    `tabel_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `index_value`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '键值，使用“-”拼接',
    `pk_value`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '索引值',
    `delete_sts`   char(1) COLLATE utf8mb4_general_ci                            NOT NULL DEFAULT '0',
    `gmt_create`   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_index_value` (`tabel_name`,`index_value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='虚拟表索引表';