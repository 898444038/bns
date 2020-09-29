package com.ming.bns.ppsg.entity;

import com.ming.tools.bind.anno.BindKey;
import com.ming.tools.bind.anno.BindTable;

@BindTable(tableName = "t_level")
public class Level {

    @BindKey
    private Long id;

    private String name;

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
