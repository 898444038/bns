package com.ming.bns.admin.entity;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;

import java.io.Serializable;

/**
 * 接口访问统计
 */
@Generate(isEffective = true,isCover = false,desc = "统计",tablePrefix = "bns")
public class Statistics implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("类型")
    private String type;

    @Column
    @Comment("描述")
    private String desc;

    @Column
    @Comment("总次数")
    private Integer totalCount;

    public Statistics() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
