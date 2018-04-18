package yxinfo.dct.framework.service.dal;

import java.io.Serializable;

/**
 * Created by hanley on 2016/6/18.
 */
public class Page implements Serializable {


    private int pageNum = 1; // 页码
    private int numPerPage = 20; // 每页数据量
    private long total; // 数据总量
    private long totalPage; //总页数

    private int pageStart;


    public Page() {
    }

    public Page(int pageNum, int numPerPage) {
        this.pageNum = pageNum;
        this.numPerPage = numPerPage;
    }


    public int getPageNum() {
        return pageNum;
    }

    public Page setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public Page setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
        return this;
    }

    public int getPageStart() {
        return this.pageStart != 0 ? this.pageStart : ( getPageNum() > 0 ? (getPageNum() - 1) * getNumPerPage() : 0 );
    }

    public Page setPageStart(int pageStart) {
        this.pageStart = pageStart;
        return this;
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPage() {
        return (long) Math.ceil((double)total / numPerPage);
    }

}
