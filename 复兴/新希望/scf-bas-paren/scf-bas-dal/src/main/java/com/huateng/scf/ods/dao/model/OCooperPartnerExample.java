package com.huateng.scf.ods.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OCooperPartnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OCooperPartnerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected OCooperPartnerExample(OCooperPartnerExample example) {
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

        public Criteria andCustcdIsNull() {
            addCriterion("CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCustcdIsNotNull() {
            addCriterion("CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdEqualTo(String value) {
            addCriterion("CUSTCD =", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotEqualTo(String value) {
            addCriterion("CUSTCD <>", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThan(String value) {
            addCriterion("CUSTCD >", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD >=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThan(String value) {
            addCriterion("CUSTCD <", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD <=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLike(String value) {
            addCriterion("CUSTCD like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotLike(String value) {
            addCriterion("CUSTCD not like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdIn(List<String> values) {
            addCriterion("CUSTCD in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotIn(List<String> values) {
            addCriterion("CUSTCD not in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdBetween(String value1, String value2) {
            addCriterion("CUSTCD between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotBetween(String value1, String value2) {
            addCriterion("CUSTCD not between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdIsNull() {
            addCriterion("COOP_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdIsNotNull() {
            addCriterion("COOP_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdEqualTo(String value) {
            addCriterion("COOP_CUSTCD =", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdNotEqualTo(String value) {
            addCriterion("COOP_CUSTCD <>", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdGreaterThan(String value) {
            addCriterion("COOP_CUSTCD >", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("COOP_CUSTCD >=", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdLessThan(String value) {
            addCriterion("COOP_CUSTCD <", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdLessThanOrEqualTo(String value) {
            addCriterion("COOP_CUSTCD <=", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdLike(String value) {
            addCriterion("COOP_CUSTCD like", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdNotLike(String value) {
            addCriterion("COOP_CUSTCD not like", value, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdIn(List<String> values) {
            addCriterion("COOP_CUSTCD in", values, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdNotIn(List<String> values) {
            addCriterion("COOP_CUSTCD not in", values, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdBetween(String value1, String value2) {
            addCriterion("COOP_CUSTCD between", value1, value2, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopCustcdNotBetween(String value1, String value2) {
            addCriterion("COOP_CUSTCD not between", value1, value2, "coopCustcd");
            return (Criteria) this;
        }

        public Criteria andCoopRateIsNull() {
            addCriterion("COOP_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCoopRateIsNotNull() {
            addCriterion("COOP_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCoopRateEqualTo(BigDecimal value) {
            addCriterion("COOP_RATE =", value, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateNotEqualTo(BigDecimal value) {
            addCriterion("COOP_RATE <>", value, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateGreaterThan(BigDecimal value) {
            addCriterion("COOP_RATE >", value, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COOP_RATE >=", value, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateLessThan(BigDecimal value) {
            addCriterion("COOP_RATE <", value, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COOP_RATE <=", value, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateIn(List<BigDecimal> values) {
            addCriterion("COOP_RATE in", values, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateNotIn(List<BigDecimal> values) {
            addCriterion("COOP_RATE not in", values, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COOP_RATE between", value1, value2, "coopRate");
            return (Criteria) this;
        }

        public Criteria andCoopRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COOP_RATE not between", value1, value2, "coopRate");
            return (Criteria) this;
        }

        public Criteria andBelongYearIsNull() {
            addCriterion("BELONG_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andBelongYearIsNotNull() {
            addCriterion("BELONG_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andBelongYearEqualTo(String value) {
            addCriterion("BELONG_YEAR =", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearNotEqualTo(String value) {
            addCriterion("BELONG_YEAR <>", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearGreaterThan(String value) {
            addCriterion("BELONG_YEAR >", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_YEAR >=", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearLessThan(String value) {
            addCriterion("BELONG_YEAR <", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearLessThanOrEqualTo(String value) {
            addCriterion("BELONG_YEAR <=", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearLike(String value) {
            addCriterion("BELONG_YEAR like", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearNotLike(String value) {
            addCriterion("BELONG_YEAR not like", value, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearIn(List<String> values) {
            addCriterion("BELONG_YEAR in", values, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearNotIn(List<String> values) {
            addCriterion("BELONG_YEAR not in", values, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearBetween(String value1, String value2) {
            addCriterion("BELONG_YEAR between", value1, value2, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongYearNotBetween(String value1, String value2) {
            addCriterion("BELONG_YEAR not between", value1, value2, "belongYear");
            return (Criteria) this;
        }

        public Criteria andBelongMonthIsNull() {
            addCriterion("BELONG_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andBelongMonthIsNotNull() {
            addCriterion("BELONG_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andBelongMonthEqualTo(String value) {
            addCriterion("BELONG_MONTH =", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthNotEqualTo(String value) {
            addCriterion("BELONG_MONTH <>", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthGreaterThan(String value) {
            addCriterion("BELONG_MONTH >", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_MONTH >=", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthLessThan(String value) {
            addCriterion("BELONG_MONTH <", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthLessThanOrEqualTo(String value) {
            addCriterion("BELONG_MONTH <=", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthLike(String value) {
            addCriterion("BELONG_MONTH like", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthNotLike(String value) {
            addCriterion("BELONG_MONTH not like", value, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthIn(List<String> values) {
            addCriterion("BELONG_MONTH in", values, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthNotIn(List<String> values) {
            addCriterion("BELONG_MONTH not in", values, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthBetween(String value1, String value2) {
            addCriterion("BELONG_MONTH between", value1, value2, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andBelongMonthNotBetween(String value1, String value2) {
            addCriterion("BELONG_MONTH not between", value1, value2, "belongMonth");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNull() {
            addCriterion("MONTH_RATE is null");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNotNull() {
            addCriterion("MONTH_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andMonthRateEqualTo(BigDecimal value) {
            addCriterion("MONTH_RATE =", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotEqualTo(BigDecimal value) {
            addCriterion("MONTH_RATE <>", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThan(BigDecimal value) {
            addCriterion("MONTH_RATE >", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_RATE >=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThan(BigDecimal value) {
            addCriterion("MONTH_RATE <", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_RATE <=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateIn(List<BigDecimal> values) {
            addCriterion("MONTH_RATE in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotIn(List<BigDecimal> values) {
            addCriterion("MONTH_RATE not in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_RATE between", value1, value2, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_RATE not between", value1, value2, "monthRate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}