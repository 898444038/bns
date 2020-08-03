-- 建表语句
CREATE TABLE `bns_equip_type` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '名称',
`code` INTEGER(11)  DEFAULT NULL  COMMENT '类型 EquipTypeEnum',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `bns_equip_type` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `bns_equip_type` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '名称';
ALTER TABLE `bns_equip_type` ADD COLUMN code INTEGER(11)  DEFAULT NULL  COMMENT '类型 EquipTypeEnum';
