package cn.com.dhc.domain;

import java.util.ArrayList;
import java.util.List;

public class HourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HourseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHourseidIsNull() {
            addCriterion("hourseId is null");
            return (Criteria) this;
        }

        public Criteria andHourseidIsNotNull() {
            addCriterion("hourseId is not null");
            return (Criteria) this;
        }

        public Criteria andHourseidEqualTo(Integer value) {
            addCriterion("hourseId =", value, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidNotEqualTo(Integer value) {
            addCriterion("hourseId <>", value, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidGreaterThan(Integer value) {
            addCriterion("hourseId >", value, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hourseId >=", value, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidLessThan(Integer value) {
            addCriterion("hourseId <", value, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidLessThanOrEqualTo(Integer value) {
            addCriterion("hourseId <=", value, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidIn(List<Integer> values) {
            addCriterion("hourseId in", values, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidNotIn(List<Integer> values) {
            addCriterion("hourseId not in", values, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidBetween(Integer value1, Integer value2) {
            addCriterion("hourseId between", value1, value2, "hourseid");
            return (Criteria) this;
        }

        public Criteria andHourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("hourseId not between", value1, value2, "hourseid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uId is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uId is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uId =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uId <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uId >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uId >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uId <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uId <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uId in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uId not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uId between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uId not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andOneplaceIsNull() {
            addCriterion("onePlace is null");
            return (Criteria) this;
        }

        public Criteria andOneplaceIsNotNull() {
            addCriterion("onePlace is not null");
            return (Criteria) this;
        }

        public Criteria andOneplaceEqualTo(String value) {
            addCriterion("onePlace =", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceNotEqualTo(String value) {
            addCriterion("onePlace <>", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceGreaterThan(String value) {
            addCriterion("onePlace >", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceGreaterThanOrEqualTo(String value) {
            addCriterion("onePlace >=", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceLessThan(String value) {
            addCriterion("onePlace <", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceLessThanOrEqualTo(String value) {
            addCriterion("onePlace <=", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceLike(String value) {
            addCriterion("onePlace like", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceNotLike(String value) {
            addCriterion("onePlace not like", value, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceIn(List<String> values) {
            addCriterion("onePlace in", values, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceNotIn(List<String> values) {
            addCriterion("onePlace not in", values, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceBetween(String value1, String value2) {
            addCriterion("onePlace between", value1, value2, "oneplace");
            return (Criteria) this;
        }

        public Criteria andOneplaceNotBetween(String value1, String value2) {
            addCriterion("onePlace not between", value1, value2, "oneplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceIsNull() {
            addCriterion("twoPlace is null");
            return (Criteria) this;
        }

        public Criteria andTwoplaceIsNotNull() {
            addCriterion("twoPlace is not null");
            return (Criteria) this;
        }

        public Criteria andTwoplaceEqualTo(String value) {
            addCriterion("twoPlace =", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceNotEqualTo(String value) {
            addCriterion("twoPlace <>", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceGreaterThan(String value) {
            addCriterion("twoPlace >", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceGreaterThanOrEqualTo(String value) {
            addCriterion("twoPlace >=", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceLessThan(String value) {
            addCriterion("twoPlace <", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceLessThanOrEqualTo(String value) {
            addCriterion("twoPlace <=", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceLike(String value) {
            addCriterion("twoPlace like", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceNotLike(String value) {
            addCriterion("twoPlace not like", value, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceIn(List<String> values) {
            addCriterion("twoPlace in", values, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceNotIn(List<String> values) {
            addCriterion("twoPlace not in", values, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceBetween(String value1, String value2) {
            addCriterion("twoPlace between", value1, value2, "twoplace");
            return (Criteria) this;
        }

        public Criteria andTwoplaceNotBetween(String value1, String value2) {
            addCriterion("twoPlace not between", value1, value2, "twoplace");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Integer value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Integer value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Integer value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Integer value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Integer value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Integer> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Integer> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Integer value1, Integer value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andRoomnumIsNull() {
            addCriterion("roomNum is null");
            return (Criteria) this;
        }

        public Criteria andRoomnumIsNotNull() {
            addCriterion("roomNum is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnumEqualTo(Integer value) {
            addCriterion("roomNum =", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotEqualTo(Integer value) {
            addCriterion("roomNum <>", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThan(Integer value) {
            addCriterion("roomNum >", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomNum >=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThan(Integer value) {
            addCriterion("roomNum <", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThanOrEqualTo(Integer value) {
            addCriterion("roomNum <=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumIn(List<Integer> values) {
            addCriterion("roomNum in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotIn(List<Integer> values) {
            addCriterion("roomNum not in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumBetween(Integer value1, Integer value2) {
            addCriterion("roomNum between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotBetween(Integer value1, Integer value2) {
            addCriterion("roomNum not between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andFitmentIsNull() {
            addCriterion("fitment is null");
            return (Criteria) this;
        }

        public Criteria andFitmentIsNotNull() {
            addCriterion("fitment is not null");
            return (Criteria) this;
        }

        public Criteria andFitmentEqualTo(String value) {
            addCriterion("fitment =", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotEqualTo(String value) {
            addCriterion("fitment <>", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentGreaterThan(String value) {
            addCriterion("fitment >", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentGreaterThanOrEqualTo(String value) {
            addCriterion("fitment >=", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentLessThan(String value) {
            addCriterion("fitment <", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentLessThanOrEqualTo(String value) {
            addCriterion("fitment <=", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentLike(String value) {
            addCriterion("fitment like", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotLike(String value) {
            addCriterion("fitment not like", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentIn(List<String> values) {
            addCriterion("fitment in", values, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotIn(List<String> values) {
            addCriterion("fitment not in", values, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentBetween(String value1, String value2) {
            addCriterion("fitment between", value1, value2, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotBetween(String value1, String value2) {
            addCriterion("fitment not between", value1, value2, "fitment");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andDaylightingIsNull() {
            addCriterion("daylighting is null");
            return (Criteria) this;
        }

        public Criteria andDaylightingIsNotNull() {
            addCriterion("daylighting is not null");
            return (Criteria) this;
        }

        public Criteria andDaylightingEqualTo(String value) {
            addCriterion("daylighting =", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingNotEqualTo(String value) {
            addCriterion("daylighting <>", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingGreaterThan(String value) {
            addCriterion("daylighting >", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingGreaterThanOrEqualTo(String value) {
            addCriterion("daylighting >=", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingLessThan(String value) {
            addCriterion("daylighting <", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingLessThanOrEqualTo(String value) {
            addCriterion("daylighting <=", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingLike(String value) {
            addCriterion("daylighting like", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingNotLike(String value) {
            addCriterion("daylighting not like", value, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingIn(List<String> values) {
            addCriterion("daylighting in", values, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingNotIn(List<String> values) {
            addCriterion("daylighting not in", values, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingBetween(String value1, String value2) {
            addCriterion("daylighting between", value1, value2, "daylighting");
            return (Criteria) this;
        }

        public Criteria andDaylightingNotBetween(String value1, String value2) {
            addCriterion("daylighting not between", value1, value2, "daylighting");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Integer value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Integer value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Integer value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Integer value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Integer value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Integer> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Integer> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Integer value1, Integer value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorIsNull() {
            addCriterion("totalFloor is null");
            return (Criteria) this;
        }

        public Criteria andTotalfloorIsNotNull() {
            addCriterion("totalFloor is not null");
            return (Criteria) this;
        }

        public Criteria andTotalfloorEqualTo(Integer value) {
            addCriterion("totalFloor =", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorNotEqualTo(Integer value) {
            addCriterion("totalFloor <>", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorGreaterThan(Integer value) {
            addCriterion("totalFloor >", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalFloor >=", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorLessThan(Integer value) {
            addCriterion("totalFloor <", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorLessThanOrEqualTo(Integer value) {
            addCriterion("totalFloor <=", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorIn(List<Integer> values) {
            addCriterion("totalFloor in", values, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorNotIn(List<Integer> values) {
            addCriterion("totalFloor not in", values, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorBetween(Integer value1, Integer value2) {
            addCriterion("totalFloor between", value1, value2, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorNotBetween(Integer value1, Integer value2) {
            addCriterion("totalFloor not between", value1, value2, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFormIsNull() {
            addCriterion("form is null");
            return (Criteria) this;
        }

        public Criteria andFormIsNotNull() {
            addCriterion("form is not null");
            return (Criteria) this;
        }

        public Criteria andFormEqualTo(Integer value) {
            addCriterion("form =", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormNotEqualTo(Integer value) {
            addCriterion("form <>", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormGreaterThan(Integer value) {
            addCriterion("form >", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormGreaterThanOrEqualTo(Integer value) {
            addCriterion("form >=", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormLessThan(Integer value) {
            addCriterion("form <", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormLessThanOrEqualTo(Integer value) {
            addCriterion("form <=", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormIn(List<Integer> values) {
            addCriterion("form in", values, "form");
            return (Criteria) this;
        }

        public Criteria andFormNotIn(List<Integer> values) {
            addCriterion("form not in", values, "form");
            return (Criteria) this;
        }

        public Criteria andFormBetween(Integer value1, Integer value2) {
            addCriterion("form between", value1, value2, "form");
            return (Criteria) this;
        }

        public Criteria andFormNotBetween(Integer value1, Integer value2) {
            addCriterion("form not between", value1, value2, "form");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}