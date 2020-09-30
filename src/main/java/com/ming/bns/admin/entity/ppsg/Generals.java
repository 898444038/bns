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
}
