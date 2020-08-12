package com.ming.bns.admin.entity;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;

import java.io.Serializable;

/**
 * 接口访问统计项
 */
@Generate(isEffective = true,isCover = false,desc = "统计项",tablePrefix = "bns")
public class StatisticsItem implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("Statistics主键")
    private Long statisticsId;

    @Column
    @Comment("日期(2020-08-12)")
    private String date;

    @Column
    @Comment("统计次数")
    private Integer count;

    public StatisticsItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(Long statisticsId) {
        this.statisticsId = statisticsId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
