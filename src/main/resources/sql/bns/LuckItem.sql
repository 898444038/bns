-- 建表语句
CREATE TABLE `bns_luck_item` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`_luck_id` BIGINT(20)  DEFAULT NULL  COMMENT 'luckId',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '奖品名称',
`weight` INTEGER(11)  DEFAULT NULL  COMMENT '奖品权重',
`sort` INTEGER(11)  DEFAULT NULL  COMMENT '排序',
`remark` VARCHAR(32)  DEFAULT NULL  COMMENT '备注',
`create_time` datetime  DEFAULT NULL  COMMENT '创建时间',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `bns_luck_item` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `bns_luck_item` ADD COLUMN _luck_id BIGINT(20)  DEFAULT NULL  COMMENT 'luckId';
ALTER TABLE `bns_luck_item` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '奖品名称';
ALTER TABLE `bns_luck_item` ADD COLUMN weight INTEGER(11)  DEFAULT NULL  COMMENT '奖品权重';
ALTER TABLE `bns_luck_item` ADD COLUMN sort INTEGER(11)  DEFAULT NULL  COMMENT '排序';
ALTER TABLE `bns_luck_item` ADD COLUMN remark VARCHAR(32)  DEFAULT NULL  COMMENT '备注';
ALTER TABLE `bns_luck_item` ADD COLUMN create_time datetime  DEFAULT NULL  COMMENT '创建时间';
