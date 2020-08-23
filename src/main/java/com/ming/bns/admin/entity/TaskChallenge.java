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
    private String name;

    @Column
    @Comment("任务侠义值")
    private String chivalrous1;

    @Column
    @Comment("挑战侠义值")
    private String chivalrous2;

    @Column
    @Comment("斩首侠义值")
    private String chivalrous3;

    public TaskChallenge() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChivalrous1() {
        return chivalrous1;
    }

    public void setChivalrous1(String chivalrous1) {
        this.chivalrous1 = chivalrous1;
    }

    public String getChivalrous2() {
        return chivalrous2;
    }

    public void setChivalrous2(String chivalrous2) {
        this.chivalrous2 = chivalrous2;
    }

    public String getChivalrous3() {
        return chivalrous3;
    }

    public void setChivalrous3(String chivalrous3) {
        this.chivalrous3 = chivalrous3;
    }
}
