package com.huateng.scf.ods.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OdsTopCityLineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OdsTopCityLineExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected OdsTopCityLineExample(OdsTopCityLineExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
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
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTopCityIdIsNull() {
            addCriterion("TOP_CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andTopCityIdIsNotNull() {
            addCriterion("TOP_CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTopCityIdEqualTo(String value) {
            addCriterion("TOP_CITY_ID =", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdNotEqualTo(String value) {
            addCriterion("TOP_CITY_ID <>", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdGreaterThan(String value) {
            addCriterion("TOP_CITY_ID >", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("TOP_CITY_ID >=", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdLessThan(String value) {
            addCriterion("TOP_CITY_ID <", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdLessThanOrEqualTo(String value) {
            addCriterion("TOP_CITY_ID <=", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdLike(String value) {
            addCriterion("TOP_CITY_ID like", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdNotLike(String value) {
            addCriterion("TOP_CITY_ID not like", value, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdIn(List<String> values) {
            addCriterion("TOP_CITY_ID in", values, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdNotIn(List<String> values) {
            addCriterion("TOP_CITY_ID not in", values, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdBetween(String value1, String value2) {
            addCriterion("TOP_CITY_ID between", value1, value2, "topCityId");
            return (Criteria) this;
        }

        public Criteria andTopCityIdNotBetween(String value1, String value2) {
            addCriterion("TOP_CITY_ID not between", value1, value2, "topCityId");
            return (Criteria) this;
        }

        public Criteria andEndAreaIsNull() {
            addCriterion("END_AREA is null");
            return (Criteria) this;
        }

        public Criteria andEndAreaIsNotNull() {
            addCriterion("END_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andEndAreaEqualTo(String value) {
            addCriterion("END_AREA =", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaNotEqualTo(String value) {
            addCriterion("END_AREA <>", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaGreaterThan(String value) {
            addCriterion("END_AREA >", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaGreaterThanOrEqualTo(String value) {
            addCriterion("END_AREA >=", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaLessThan(String value) {
            addCriterion("END_AREA <", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaLessThanOrEqualTo(String value) {
            addCriterion("END_AREA <=", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaLike(String value) {
            addCriterion("END_AREA like", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaNotLike(String value) {
            addCriterion("END_AREA not like", value, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaIn(List<String> values) {
            addCriterion("END_AREA in", values, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaNotIn(List<String> values) {
            addCriterion("END_AREA not in", values, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaBetween(String value1, String value2) {
            addCriterion("END_AREA between", value1, value2, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreaNotBetween(String value1, String value2) {
            addCriterion("END_AREA not between", value1, value2, "endArea");
            return (Criteria) this;
        }

        public Criteria andEndAreanmIsNull() {
            addCriterion("END_AREANM is null");
            return (Criteria) this;
        }

        public Criteria andEndAreanmIsNotNull() {
            addCriterion("END_AREANM is not null");
            return (Criteria) this;
        }

        public Criteria andEndAreanmEqualTo(String value) {
            addCriterion("END_AREANM =", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmNotEqualTo(String value) {
            addCriterion("END_AREANM <>", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmGreaterThan(String value) {
            addCriterion("END_AREANM >", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmGreaterThanOrEqualTo(String value) {
            addCriterion("END_AREANM >=", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmLessThan(String value) {
            addCriterion("END_AREANM <", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmLessThanOrEqualTo(String value) {
            addCriterion("END_AREANM <=", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmLike(String value) {
            addCriterion("END_AREANM like", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmNotLike(String value) {
            addCriterion("END_AREANM not like", value, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmIn(List<String> values) {
            addCriterion("END_AREANM in", values, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmNotIn(List<String> values) {
            addCriterion("END_AREANM not in", values, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmBetween(String value1, String value2) {
            addCriterion("END_AREANM between", value1, value2, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andEndAreanmNotBetween(String value1, String value2) {
            addCriterion("END_AREANM not between", value1, value2, "endAreanm");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIsNull() {
            addCriterion("LAST_UPD_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIsNotNull() {
            addCriterion("LAST_UPD_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD =", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <>", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThan(String value) {
            addCriterion("LAST_UPD_TLRCD >", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD >=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThan(String value) {
            addCriterion("LAST_UPD_TLRCD <", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLike(String value) {
            addCriterion("LAST_UPD_TLRCD like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotLike(String value) {
            addCriterion("LAST_UPD_TLRCD not like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD not in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD not between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNull() {
            addCriterion("LAST_UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNotNull() {
            addCriterion("LAST_UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME =", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <>", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThan(Date value) {
            addCriterion("LAST_UPD_TIME >", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME >=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThan(Date value) {
            addCriterion("LAST_UPD_TIME <", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME not in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME not between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNull() {
            addCriterion("LAST_UPD_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNotNull() {
            addCriterion("LAST_UPD_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE =", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <>", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThan(String value) {
            addCriterion("LAST_UPD_BRCODE >", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE >=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThan(String value) {
            addCriterion("LAST_UPD_BRCODE <", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLike(String value) {
            addCriterion("LAST_UPD_BRCODE like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotLike(String value) {
            addCriterion("LAST_UPD_BRCODE not like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE not in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE between", value1, value2, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE not between", value1, value2, "lastUpdBrcode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}