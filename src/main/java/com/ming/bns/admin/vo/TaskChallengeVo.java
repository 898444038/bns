package com.ming.bns.admin.vo;

import com.ming.bns.admin.entity.TaskChallenge;

import java.util.List;
import java.util.Map;


/**
 * 任务挑战
 * @author: Administrator
 * @date: 2020-08-22
 */
public class TaskChallengeVo extends TaskChallenge {

    private Integer pageNo;

    private Integer pageSize;

    private Integer pageStart;

    private String pageSort;

    private String ids1;
    private String ids2;
    private String ids3;
    private String ids4;
    private Integer count;

    public TaskChallengeVo() {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo == null) {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getIds1() {
        return ids1;
    }

    public void setIds1(String ids1) {
        this.ids1 = ids1;
    }

    public String getIds2() {
        return ids2;
    }

    public void setIds2(String ids2) {
        this.ids2 = ids2;
    }

    public String getIds3() {
        return ids3;
    }

    public void setIds3(String ids3) {
        this.ids3 = ids3;
    }

    public String getIds4() {
        return ids4;
    }

    public void setIds4(String ids4) {
        this.ids4 = ids4;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo != null && pageNo > 0) {
            this.pageNo = pageNo;
            this.pageStart = (pageNo - 1) * this.pageSize;
        } else {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public String getPageSort() {
        return pageSort;
    }

    public void setPageSort(String pageSort) {
        this.pageSort = pageSort;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }
}

