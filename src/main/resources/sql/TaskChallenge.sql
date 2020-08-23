-- 建表语句
CREATE TABLE `bns_task_challenge` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '任务名称',
`chivalrous1` VARCHAR(32)  DEFAULT NULL  COMMENT '任务侠义值',
`chivalrous2` VARCHAR(32)  DEFAULT NULL  COMMENT '挑战侠义值',
`chivalrous3` VARCHAR(32)  DEFAULT NULL  COMMENT '斩首侠义值',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `bns_task_challenge` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `bns_task_challenge` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '任务名称';
ALTER TABLE `bns_task_challenge` ADD COLUMN chivalrous1 VARCHAR(32)  DEFAULT NULL  COMMENT '任务侠义值';
ALTER TABLE `bns_task_challenge` ADD COLUMN chivalrous2 VARCHAR(32)  DEFAULT NULL  COMMENT '挑战侠义值';
ALTER TABLE `bns_task_challenge` ADD COLUMN chivalrous3 VARCHAR(32)  DEFAULT NULL  COMMENT '斩首侠义值';

