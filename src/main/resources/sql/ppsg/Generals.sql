-- 建表语句
CREATE TABLE `ppsg_generals` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`code` VARCHAR(32)  DEFAULT NULL  COMMENT '编号',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '名称',
`generals4` VARCHAR(32)  DEFAULT NULL  COMMENT '4星名称',
`country_name` VARCHAR(32)  DEFAULT NULL  COMMENT '国家名称',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_generals` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_generals` ADD COLUMN code VARCHAR(32)  DEFAULT NULL  COMMENT '编号';
ALTER TABLE `ppsg_generals` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '名称';
ALTER TABLE `ppsg_generals` ADD COLUMN generals4 VARCHAR(32)  DEFAULT NULL  COMMENT '4星名称';
ALTER TABLE `ppsg_generals` ADD COLUMN country_name VARCHAR(32)  DEFAULT NULL  COMMENT '国家名称';

