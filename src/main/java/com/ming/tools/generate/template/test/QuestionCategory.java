package com.ming.tools.generate.template.test;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.GenerateController;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;

import java.util.Date;

/**
 * 问题分类
 * Created by Administrator on 2020/4/13 0013.
 */
@Generate(isEffective = false,desc = "问题分类")
public class QuestionCategory {

    @Column
    @PrimaryKey
    private Long id;
    //分类名称
    @Column
    private String name;
    //父级
    private Long pid;
    @Column
    private Date createTime;
    @Column
    private Boolean delFlag;


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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
