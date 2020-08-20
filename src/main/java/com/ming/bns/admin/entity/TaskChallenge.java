package com.ming.bns.admin.entity;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;

@Generate(isEffective = true,isCover = false,desc = "任务挑战",tablePrefix = "bns")
public class TaskChallenge {

    @Column
    @PrimaryKey
    private Long id;

    /*@Column
    @Comment("类型[0:任务,1:入门,2:普通,3:熟练]")
    private String type;*/

    @Column
    @Comment("任务名称")
    private String challenge;

    @Column
    @Comment("任务侠义值")
    private String chivalrous1;

    @Column
    @Comment("挑战侠义值")
    private String chivalrous2;

    @Column
    @Comment("斩首侠义值")
    private String chivalrous3;
}
