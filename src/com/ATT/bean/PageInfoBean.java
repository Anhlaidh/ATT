package com.ATT.bean;

import java.util.LinkedList;

public class PageInfoBean {
    private int currentPage;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private LinkedList beans;

    public PageInfoBean() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:totalCount/this.pageSize+1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public LinkedList getBeans() {
        return beans;
    }

    public void setBeans(LinkedList beans) {
        this.beans = beans;
    }
}
