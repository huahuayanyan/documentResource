package com.huateng.scf.bas.brp.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BBrpIndustryTypesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBrpIndustryTypesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BBrpIndustryTypesExample(BBrpIndustryTypesExample example) {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIndustryCodeIsNull() {
            addCriterion("INDUSTRY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNotNull() {
            addCriterion("INDUSTRY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeEqualTo(String value) {
            addCriterion("INDUSTRY_CODE =", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotEqualTo(String value) {
            addCriterion("INDUSTRY_CODE <>", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThan(String value) {
            addCriterion("INDUSTRY_CODE >", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_CODE >=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThan(String value) {
            addCriterion("INDUSTRY_CODE <", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_CODE <=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLike(String value) {
            addCriterion("INDUSTRY_CODE like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotLike(String value) {
            addCriterion("INDUSTRY_CODE not like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIn(List<String> values) {
            addCriterion("INDUSTRY_CODE in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotIn(List<String> values) {
            addCriterion("INDUSTRY_CODE not in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeBetween(String value1, String value2) {
            addCriterion("INDUSTRY_CODE between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_CODE not between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNull() {
            addCriterion("INDUSTRY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNotNull() {
            addCriterion("INDUSTRY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEqualTo(String value) {
            addCriterion("INDUSTRY_NAME =", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotEqualTo(String value) {
            addCriterion("INDUSTRY_NAME <>", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThan(String value) {
            addCriterion("INDUSTRY_NAME >", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_NAME >=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThan(String value) {
            addCriterion("INDUSTRY_NAME <", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_NAME <=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLike(String value) {
            addCriterion("INDUSTRY_NAME like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotLike(String value) {
            addCriterion("INDUSTRY_NAME not like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIn(List<String> values) {
            addCriterion("INDUSTRY_NAME in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotIn(List<String> values) {
            addCriterion("INDUSTRY_NAME not in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameBetween(String value1, String value2) {
            addCriterion("INDUSTRY_NAME between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_NAME not between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelIsNull() {
            addCriterion("INDUSTRY_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelIsNotNull() {
            addCriterion("INDUSTRY_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelEqualTo(String value) {
            addCriterion("INDUSTRY_LEVEL =", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelNotEqualTo(String value) {
            addCriterion("INDUSTRY_LEVEL <>", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelGreaterThan(String value) {
            addCriterion("INDUSTRY_LEVEL >", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_LEVEL >=", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelLessThan(String value) {
            addCriterion("INDUSTRY_LEVEL <", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_LEVEL <=", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelLike(String value) {
            addCriterion("INDUSTRY_LEVEL like", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelNotLike(String value) {
            addCriterion("INDUSTRY_LEVEL not like", value, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelIn(List<String> values) {
            addCriterion("INDUSTRY_LEVEL in", values, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelNotIn(List<String> values) {
            addCriterion("INDUSTRY_LEVEL not in", values, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelBetween(String value1, String value2) {
            addCriterion("INDUSTRY_LEVEL between", value1, value2, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryLevelNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_LEVEL not between", value1, value2, "industryLevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelIsNull() {
            addCriterion("INDUSTRY_UPLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelIsNotNull() {
            addCriterion("INDUSTRY_UPLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelEqualTo(String value) {
            addCriterion("INDUSTRY_UPLEVEL =", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelNotEqualTo(String value) {
            addCriterion("INDUSTRY_UPLEVEL <>", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelGreaterThan(String value) {
            addCriterion("INDUSTRY_UPLEVEL >", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_UPLEVEL >=", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelLessThan(String value) {
            addCriterion("INDUSTRY_UPLEVEL <", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_UPLEVEL <=", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelLike(String value) {
            addCriterion("INDUSTRY_UPLEVEL like", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelNotLike(String value) {
            addCriterion("INDUSTRY_UPLEVEL not like", value, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelIn(List<String> values) {
            addCriterion("INDUSTRY_UPLEVEL in", values, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelNotIn(List<String> values) {
            addCriterion("INDUSTRY_UPLEVEL not in", values, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelBetween(String value1, String value2) {
            addCriterion("INDUSTRY_UPLEVEL between", value1, value2, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andIndustryUplevelNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_UPLEVEL not between", value1, value2, "industryUplevel");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIsNull() {
            addCriterion("LAST_UPD_TLR is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIsNotNull() {
            addCriterion("LAST_UPD_TLR is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR =", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLR <>", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrGreaterThan(String value) {
            addCriterion("LAST_UPD_TLR >", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR >=", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLessThan(String value) {
            addCriterion("LAST_UPD_TLR <", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR <=", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLike(String value) {
            addCriterion("LAST_UPD_TLR like", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotLike(String value) {
            addCriterion("LAST_UPD_TLR not like", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIn(List<String> values) {
            addCriterion("LAST_UPD_TLR in", values, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLR not in", values, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLR between", value1, value2, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLR not between", value1, value2, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNull() {
            addCriterion("LAST_UPD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNotNull() {
            addCriterion("LAST_UPD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE =", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE <>", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE >", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE >=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThan(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE <", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE <=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_UPD_DATE in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_UPD_DATE not in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_UPD_DATE between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_UPD_DATE not between", value1, value2, "lastUpdDate");
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

        public Criteria andTimestampsIsNull() {
            addCriterion("TIMESTAMPS is null");
            return (Criteria) this;
        }

        public Criteria andTimestampsIsNotNull() {
            addCriterion("TIMESTAMPS is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampsEqualTo(Date value) {
            addCriterion("TIMESTAMPS =", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotEqualTo(Date value) {
            addCriterion("TIMESTAMPS <>", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsGreaterThan(Date value) {
            addCriterion("TIMESTAMPS >", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsGreaterThanOrEqualTo(Date value) {
            addCriterion("TIMESTAMPS >=", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsLessThan(Date value) {
            addCriterion("TIMESTAMPS <", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsLessThanOrEqualTo(Date value) {
            addCriterion("TIMESTAMPS <=", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsIn(List<Date> values) {
            addCriterion("TIMESTAMPS in", values, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotIn(List<Date> values) {
            addCriterion("TIMESTAMPS not in", values, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsBetween(Date value1, Date value2) {
            addCriterion("TIMESTAMPS between", value1, value2, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotBetween(Date value1, Date value2) {
            addCriterion("TIMESTAMPS not between", value1, value2, "timestamps");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}