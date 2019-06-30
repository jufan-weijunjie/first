package com.wei.first.common;

import java.io.Serializable;

/**
 * FileName BasePageBean
 * Describe :
 *
 * @Author weijunjie
 * @DATE 15:47 2019/6/30
 **/
public class BasePageBean implements Serializable {

    private int pageNum;

    private int pageSize;

    private int startIndex;

    private int count;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
