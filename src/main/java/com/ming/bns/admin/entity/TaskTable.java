package com.ming.bns.admin.entity;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;

import java.io.Serializable;

@Generate(isEffective = true,isCover = false,desc = "任务表",tablePrefix = "bns")
public class TaskTable implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("周几")
    private String weekName;

    @Column
    @Comment("类型[0:任务,1:入门,2:普通,3:熟练]")
    private Integer type;


}
