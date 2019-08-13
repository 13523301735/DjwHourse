package cn.com.dhc.domain;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {

    private Integer pageNum;

    private Integer totalCount;

    private List<Hourse> hourseList;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Hourse> getHourseList() {
        return hourseList;
    }

    public void setHourseList(List<Hourse> hourseList) {
        this.hourseList = hourseList;
    }
}
