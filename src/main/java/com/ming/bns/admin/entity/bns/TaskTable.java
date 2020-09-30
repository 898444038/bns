package com.ming.bns.admin.entity.bns;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "任务表",tablePrefix = "bns",parentPackage = "bns")
public class TaskTable implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("周几")
    private String weekName;

    @Column
    @Comment("类型[1:任务,2:入门,3:普通,4:熟练]")
    private Integer type;

    @Column
    @Comment("taskChallenge主键")
    private Long taskChallengeId;

    private TaskChallenge taskChallenge;

    private List<Map<String,Object>> taskChallengeMapList;

    public TaskTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getTaskChallengeId() {
        return taskChallengeId;
    }

    public void setTaskChallengeId(Long taskChallengeId) {
        this.taskChallengeId = taskChallengeId;
    }

    public TaskChallenge getTaskChallenge() {
        return taskChallenge;
    }

    public void setTaskChallenge(TaskChallenge taskChallenge) {
        this.taskChallenge = taskChallenge;
    }

    public List<Map<String, Object>> getTaskChallengeMapList() {
        return taskChallengeMapList;
    }

    public void setTaskChallengeMapList(List<Map<String, Object>> taskChallengeMapList) {
        this.taskChallengeMapList = taskChallengeMapList;
    }
}
