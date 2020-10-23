package com.ming.bns.admin.entity.ppsg;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

@GenerateDataSource(dataSource = "dataSource2")
@Generate(isEffective = true,isCover = false,desc = "武将表",tablePrefix = "ppsg",parentPackage = "ppsg")
public class Generals {
    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("编号")
    private String code;

    @Column
    @Comment("名称")
    private String name;

    @Column
    @Comment("4星名称")
    private String generals4;

    @Column
    @Comment("国家名称")
    private String countryName;

    public Generals() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenerals4() {
        return generals4;
    }

    public void setGenerals4(String generals4) {
        this.generals4 = generals4;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
