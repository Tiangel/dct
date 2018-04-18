package yxinfo.dct.inteface.dto;

import javax.validation.Valid;

/**
 * Created by hanley on 2016/6/18.
 */
public class PageDTO<T> extends BaseDTO {

    private int pageNum = 1; // 页码
    private int numPerPage = 10; // 每页数据量
    private long total; // 数据总量
    private long totalPage; //总页数

    @Valid
    private T data;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "pageNum=" + pageNum +
                ", numPerPage=" + numPerPage +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
}
