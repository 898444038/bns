package com.ming.bns.admin.vo.bns;

import com.ming.bns.admin.entity.bns.Chivalrous;


/**
 * 侠义团等级
 * @author: Administrator
 * @date: 2020-07-21
 */
public class ChivalrousVo extends Chivalrous {

    private Integer pageNo;

    private Integer pageSize;

    private Integer pageStart;

    private String pageSort;

    private Long start;//起始星级
    private Long end;//截至星级
    private Long currExp;//当前经验
    private String dayExp;//每日获取经验 支持逗号分隔

    public ChivalrousVo() {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo == null) {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getCurrExp() {
        return currExp;
    }

    public void setCurrExp(Long currExp) {
        this.currExp = currExp;
    }

    public String getDayExp() {
        return dayExp;
    }

    public void setDayExp(String dayExp) {
        this.dayExp = dayExp;
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

