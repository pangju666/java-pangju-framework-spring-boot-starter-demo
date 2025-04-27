CREATE TABLE `test`
(
    `id`            bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
    `label`         varchar(255)             DEFAULT NULL COMMENT '标签',
    `create_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time`   datetime                 DEFAULT NULL COMMENT '删除时间',
    `delete_status` bigint unsigned NOT NULL DEFAULT '0' COMMENT '删除状态',
    PRIMARY KEY (`id`)
);

INSERT INTO `test` (`label`) VALUES ('test');
