CREATE TABLE `account`
(
    `id`           int                                                           NOT NULL AUTO_INCREMENT,
    `account_no`   varchar(255) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '账户号',
    `account_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '账户名称',
    `account_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户类型',
    `over`         decimal(10, 2) unsigned zerofill NOT NULL COMMENT '账户余额',
    `create_by`    varchar(255) COLLATE utf8mb4_general_ci                       NOT NULL,
    `create_time`  datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modify_by`    varchar(255) COLLATE utf8mb4_general_ci                       NOT NULL,
    `modify_time`  datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `nui_account_no` (`account_no`) USING BTREE COMMENT '账户唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `posting_flow`
(
    `id`           int                                                           NOT NULL AUTO_INCREMENT,
    `account_src`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `account_dest` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `amt`          decimal(10, 2)                                                NOT NULL,
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL,
    `modify_by`    varchar(255) COLLATE utf8mb4_general_ci                                DEFAULT NULL,
    `create_time`  datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modify_time`  datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;