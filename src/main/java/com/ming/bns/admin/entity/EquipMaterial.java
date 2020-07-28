package com.ming.bns.admin.entity;


import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;

import java.io.Serializable;

@Generate(isEffective = true,isCover = false,desc = "装备材料",tablePrefix = "bns")
public class EquipMaterial implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("材料名称")
    private String name;

    @Column
    @Comment("材料数量")
    private Integer count;

    public EquipMaterial() {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
