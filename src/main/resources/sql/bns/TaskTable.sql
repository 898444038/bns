-- 建表语句
CREATE TABLE `bns_task_table` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`week_name` VARCHAR(32)  DEFAULT NULL  COMMENT '周几',
`type` INTEGER(11)  DEFAULT NULL  COMMENT '类型[1:任务,2:入门,3:普通,4:熟练]',
`task_challenge_id` BIGINT(20)  DEFAULT NULL  COMMENT 'taskChallenge主键',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `bns_task_table` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `bns_task_table` ADD COLUMN week_name VARCHAR(32)  DEFAULT NULL  COMMENT '周几';
ALTER TABLE `bns_task_table` ADD COLUMN type INTEGER(11)  DEFAULT NULL  COMMENT '类型[1:任务,2:入门,3:普通,4:熟练]';
ALTER TABLE `bns_task_table` ADD COLUMN task_challenge_id BIGINT(20)  DEFAULT NULL  COMMENT 'taskChallenge主键';

