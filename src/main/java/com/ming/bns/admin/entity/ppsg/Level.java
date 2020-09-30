package com.ming.bns.admin.entity.ppsg;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

@GenerateDataSource(dataSource = "dataSource2")
@Generate(isEffective = true,isCover = false,desc = "等级表",tablePrefix = "ppsg",parentPackage = "ppsg")
public class Level {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("名称")
    private String name;

    @Column
    @Comment("战力")
    private Integer combat;

    public Level() {
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

    public Integer getCombat() {
        return combat;
    }

    public void setCombat(Integer combat) {
        this.combat = combat;
    }
}
