-- 建表语句
CREATE TABLE `bns_equip_grow` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`equip_id` BIGINT(20)  DEFAULT NULL  COMMENT 'Equip表主键',
`equip_id2` BIGINT(20)  DEFAULT NULL  COMMENT 'Equip表主键',
`type` INTEGER(11)  DEFAULT NULL  COMMENT '装备类型',
`start_sort` BIGINT(20)  DEFAULT NULL  COMMENT '开始段数',
`end_sort` BIGINT(20)  DEFAULT NULL  COMMENT '结束段数',
`grow_type` INTEGER(11)  DEFAULT NULL  COMMENT '成长方式',
`discount` DECIMAL(12,2)  DEFAULT NULL  COMMENT '成长折扣',
`gold` DECIMAL(12,2)  DEFAULT NULL  COMMENT '金',
`start_item_id` BIGINT(20)  DEFAULT NULL  COMMENT '起始项',
`end_item_id` BIGINT(20)  DEFAULT NULL  COMMENT '目标项',
`materials` VARCHAR(32)  DEFAULT NULL  COMMENT '材料明细',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `bns_equip_grow` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `bns_equip_grow` ADD COLUMN equip_id BIGINT(20)  DEFAULT NULL  COMMENT 'Equip表主键';
ALTER TABLE `bns_equip_grow` ADD COLUMN equip_id2 BIGINT(20)  DEFAULT NULL  COMMENT 'Equip表主键';
ALTER TABLE `bns_equip_grow` ADD COLUMN type INTEGER(11)  DEFAULT NULL  COMMENT '装备类型';
ALTER TABLE `bns_equip_grow` ADD COLUMN start_sort BIGINT(20)  DEFAULT NULL  COMMENT '开始段数';
ALTER TABLE `bns_equip_grow` ADD COLUMN end_sort BIGINT(20)  DEFAULT NULL  COMMENT '结束段数';
ALTER TABLE `bns_equip_grow` ADD COLUMN grow_type INTEGER(11)  DEFAULT NULL  COMMENT '成长方式';
ALTER TABLE `bns_equip_grow` ADD COLUMN discount DECIMAL(12,2)  DEFAULT NULL  COMMENT '成长折扣';
ALTER TABLE `bns_equip_grow` ADD COLUMN gold DECIMAL(12,2)  DEFAULT NULL  COMMENT '金';
ALTER TABLE `bns_equip_grow` ADD COLUMN start_item_id BIGINT(20)  DEFAULT NULL  COMMENT '起始项';
ALTER TABLE `bns_equip_grow` ADD COLUMN end_item_id BIGINT(20)  DEFAULT NULL  COMMENT '目标项';
ALTER TABLE `bns_equip_grow` ADD COLUMN materials VARCHAR(32)  DEFAULT NULL  COMMENT '材料明细';

