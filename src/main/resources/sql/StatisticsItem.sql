-- 建表语句
CREATE TABLE `bns_statistics_item` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`statistics_id` BIGINT(20)  DEFAULT NULL  COMMENT 'Statistics主键',
`date` VARCHAR(32)  DEFAULT NULL  COMMENT '日期(2020-08-12)',
`count` INTEGER(11)  DEFAULT NULL  COMMENT '统计次数',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `bns_statistics_item` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `bns_statistics_item` ADD COLUMN statistics_id BIGINT(20)  DEFAULT NULL  COMMENT 'Statistics主键';
ALTER TABLE `bns_statistics_item` ADD COLUMN date VARCHAR(32)  DEFAULT NULL  COMMENT '日期(2020-08-12)';
ALTER TABLE `bns_statistics_item` ADD COLUMN count INTEGER(11)  DEFAULT NULL  COMMENT '统计次数';

