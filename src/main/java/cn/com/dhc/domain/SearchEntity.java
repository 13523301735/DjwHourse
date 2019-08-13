package cn.com.dhc.domain;

import java.io.Serializable;

public class SearchEntity implements Serializable {

    private static final long serialVersionUID = 5857007919416873301L;

    private String onePlace;
    private String twoPlace;
    private String area;
    private String direction;
    private String unit;
    private String floor;
    private String minPrice;
    private String maxPrice;
    private Integer pageNum;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getOnePlace() {
        return onePlace;
    }

    public void setOnePlace(String onePlace) {
        this.onePlace = onePlace;
    }

    public String getTwoPlace() {
        return twoPlace;
    }

    public void setTwoPlace(String twoPlace) {
        this.twoPlace = twoPlace;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }
}
