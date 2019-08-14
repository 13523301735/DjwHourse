package cn.com.dhc.domain;

public class Hourse {
    private Integer hourseid;//房屋id

    private Integer uid;//所属用户id

    private String oneplace;//一级区域

    private String twoplace;//二级区域

    private Integer area;//面积

    private String direction;//朝向

    private Integer roomnum;//卧室数量

    private String fitment;//装修情况

    private String unit;//户型

    private String daylighting;//采光

    private Integer floor;//所在楼层

    private Integer totalfloor;//总楼层

    private String picture;//图片链接

    private String description;//描述信息

    private String location;//具体位置

    private Double unitprice;//单位价格

    private Double price;//总价格

    private Integer status;//状态  （0:未上架，1:已上架）

    private Integer type;//房屋类型 （0:新房，1:毛坯，2:二手房）

    private Integer form;//房源类型  (0:普通房源，1:精品房源)

    private String village;//小区

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

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