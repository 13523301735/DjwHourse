package cn.com.dhc.domain;

public class Hourse {
    private Integer hourseid;

    private Integer uid;

    private String oneplace;

    private String twoplace;

    private Integer area;

    private String direction;

    private Integer roomnum;

    private String fitment;

    private String unit;

    private String daylighting;

    private Integer floor;

    private Integer totalfloor;

    private String picture;

    private String description;

    private String location;

    private Double price;

    private Integer status;

    private Integer type;

    private Integer form;

    public Integer getHourseid() {
        return hourseid;
    }

    public void setHourseid(Integer hourseid) {
        this.hourseid = hourseid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOneplace() {
        return oneplace;
    }

    public void setOneplace(String oneplace) {
        this.oneplace = oneplace == null ? null : oneplace.trim();
    }

    public String getTwoplace() {
        return twoplace;
    }

    public void setTwoplace(String twoplace) {
        this.twoplace = twoplace == null ? null : twoplace.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getFitment() {
        return fitment;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment == null ? null : fitment.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getDaylighting() {
        return daylighting;
    }

    public void setDaylighting(String daylighting) {
        this.daylighting = daylighting == null ? null : daylighting.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalfloor() {
        return totalfloor;
    }

    public void setTotalfloor(Integer totalfloor) {
        this.totalfloor = totalfloor;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }
}