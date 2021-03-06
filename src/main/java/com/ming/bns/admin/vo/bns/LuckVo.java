package com.ming.bns.admin.vo.bns;

import com.ming.bns.admin.entity.bns.Luck;


/**
 * 抽奖表
 * @author: Administrator
 * @date: 2020-10-23
 */
public class LuckVo extends Luck {

    private Integer pageNo;

    private Integer pageSize;

    private Integer pageStart;

    private String pageSort;

    private Integer loop;//轮数
    private Integer count;//每轮次数

    public LuckVo() {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo == null) {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public Integer getLoop() {
        return loop;
    }

    public void setLoop(Integer loop) {
        this.loop = loop;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

