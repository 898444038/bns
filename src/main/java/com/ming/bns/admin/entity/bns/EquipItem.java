package com.ming.bns.admin.entity.bns;


import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;
import java.util.List;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "装备项",tablePrefix = "bns",parentPackage = "bns")
public class EquipItem implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("装备ID")
    private Long equipId;

    @Column
    @Comment("名称")
    private String name;

    @Column
    @Comment("父级")
    private Long parentId;

    private List<EquipGrow> equipGrowList;

    public EquipItem() {
    }

    public EquipItem(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<EquipGrow> getEquipGrowList() {
        return equipGrowList;
    }

    public void setEquipGrowList(List<EquipGrow> equipGrowList) {
        this.equipGrowList = equipGrowList;
    }

    public Long getEquipId() {
        return equipId;
    }

    public void setEquipId(Long equipId) {
        this.equipId = equipId;
    }

    @Override
    public String toString() {
        return "EquipItem{" +
                "id=" + id +
                ", equipId=" + equipId +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", equipGrowList=" + equipGrowList +
                '}';
    }
}
