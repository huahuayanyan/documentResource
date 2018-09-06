package com.huateng.scf.bas.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWrnBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWrnBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWrnBaseInfoExample(BWrnBaseInfoExample example) {
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

        public Criteria andParamIdIsNull() {
            addCriterion("PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andParamIdIsNotNull() {
            addCriterion("PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParamIdEqualTo(String value) {
            addCriterion("PARAM_ID =", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotEqualTo(String value) {
            addCriterion("PARAM_ID <>", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThan(String value) {
            addCriterion("PARAM_ID >", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_ID >=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThan(String value) {
            addCriterion("PARAM_ID <", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThanOrEqualTo(String value) {
            addCriterion("PARAM_ID <=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLike(String value) {
            addCriterion("PARAM_ID like", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotLike(String value) {
            addCriterion("PARAM_ID not like", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdIn(List<String> values) {
            addCriterion("PARAM_ID in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotIn(List<String> values) {
            addCriterion("PARAM_ID not in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdBetween(String value1, String value2) {
            addCriterion("PARAM_ID between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotBetween(String value1, String value2) {
            addCriterion("PARAM_ID not between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andWarnDateIsNull() {
            addCriterion("WARN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWarnDateIsNotNull() {
            addCriterion("WARN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnDateEqualTo(String value) {
            addCriterion("WARN_DATE =", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateNotEqualTo(String value) {
            addCriterion("WARN_DATE <>", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateGreaterThan(String value) {
            addCriterion("WARN_DATE >", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_DATE >=", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateLessThan(String value) {
            addCriterion("WARN_DATE <", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateLessThanOrEqualTo(String value) {
            addCriterion("WARN_DATE <=", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateLike(String value) {
            addCriterion("WARN_DATE like", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateNotLike(String value) {
            addCriterion("WARN_DATE not like", value, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateIn(List<String> values) {
            addCriterion("WARN_DATE in", values, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateNotIn(List<String> values) {
            addCriterion("WARN_DATE not in", values, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateBetween(String value1, String value2) {
            addCriterion("WARN_DATE between", value1, value2, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnDateNotBetween(String value1, String value2) {
            addCriterion("WARN_DATE not between", value1, value2, "warnDate");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNull() {
            addCriterion("WARN_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNotNull() {
            addCriterion("WARN_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelEqualTo(String value) {
            addCriterion("WARN_LEVEL =", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotEqualTo(String value) {
            addCriterion("WARN_LEVEL <>", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThan(String value) {
            addCriterion("WARN_LEVEL >", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL >=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThan(String value) {
            addCriterion("WARN_LEVEL <", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL <=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLike(String value) {
            addCriterion("WARN_LEVEL like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotLike(String value) {
            addCriterion("WARN_LEVEL not like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIn(List<String> values) {
            addCriterion("WARN_LEVEL in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotIn(List<String> values) {
            addCriterion("WARN_LEVEL not in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL not between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSuspendDateIsNull() {
            addCriterion("SUSPEND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSuspendDateIsNotNull() {
            addCriterion("SUSPEND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSuspendDateEqualTo(String value) {
            addCriterion("SUSPEND_DATE =", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateNotEqualTo(String value) {
            addCriterion("SUSPEND_DATE <>", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateGreaterThan(String value) {
            addCriterion("SUSPEND_DATE >", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateGreaterThanOrEqualTo(String value) {
            addCriterion("SUSPEND_DATE >=", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateLessThan(String value) {
            addCriterion("SUSPEND_DATE <", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateLessThanOrEqualTo(String value) {
            addCriterion("SUSPEND_DATE <=", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateLike(String value) {
            addCriterion("SUSPEND_DATE like", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateNotLike(String value) {
            addCriterion("SUSPEND_DATE not like", value, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateIn(List<String> values) {
            addCriterion("SUSPEND_DATE in", values, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateNotIn(List<String> values) {
            addCriterion("SUSPEND_DATE not in", values, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateBetween(String value1, String value2) {
            addCriterion("SUSPEND_DATE between", value1, value2, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDateNotBetween(String value1, String value2) {
            addCriterion("SUSPEND_DATE not between", value1, value2, "suspendDate");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysIsNull() {
            addCriterion("SUSPEND_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysIsNotNull() {
            addCriterion("SUSPEND_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAYS =", value, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysNotEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAYS <>", value, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysGreaterThan(BigDecimal value) {
            addCriterion("SUSPEND_DAYS >", value, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAYS >=", value, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysLessThan(BigDecimal value) {
            addCriterion("SUSPEND_DAYS <", value, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAYS <=", value, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysIn(List<BigDecimal> values) {
            addCriterion("SUSPEND_DAYS in", values, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysNotIn(List<BigDecimal> values) {
            addCriterion("SUSPEND_DAYS not in", values, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUSPEND_DAYS between", value1, value2, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUSPEND_DAYS not between", value1, value2, "suspendDays");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoIsNull() {
            addCriterion("SUSPEND_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoIsNotNull() {
            addCriterion("SUSPEND_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoEqualTo(String value) {
            addCriterion("SUSPEND_TLRNO =", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoNotEqualTo(String value) {
            addCriterion("SUSPEND_TLRNO <>", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoGreaterThan(String value) {
            addCriterion("SUSPEND_TLRNO >", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("SUSPEND_TLRNO >=", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoLessThan(String value) {
            addCriterion("SUSPEND_TLRNO <", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoLessThanOrEqualTo(String value) {
            addCriterion("SUSPEND_TLRNO <=", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoLike(String value) {
            addCriterion("SUSPEND_TLRNO like", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoNotLike(String value) {
            addCriterion("SUSPEND_TLRNO not like", value, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoIn(List<String> values) {
            addCriterion("SUSPEND_TLRNO in", values, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoNotIn(List<String> values) {
            addCriterion("SUSPEND_TLRNO not in", values, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoBetween(String value1, String value2) {
            addCriterion("SUSPEND_TLRNO between", value1, value2, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andSuspendTlrnoNotBetween(String value1, String value2) {
            addCriterion("SUSPEND_TLRNO not between", value1, value2, "suspendTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoIsNull() {
            addCriterion("PROCESS_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoIsNotNull() {
            addCriterion("PROCESS_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoEqualTo(String value) {
            addCriterion("PROCESS_TLRNO =", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoNotEqualTo(String value) {
            addCriterion("PROCESS_TLRNO <>", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoGreaterThan(String value) {
            addCriterion("PROCESS_TLRNO >", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_TLRNO >=", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoLessThan(String value) {
            addCriterion("PROCESS_TLRNO <", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_TLRNO <=", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoLike(String value) {
            addCriterion("PROCESS_TLRNO like", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoNotLike(String value) {
            addCriterion("PROCESS_TLRNO not like", value, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoIn(List<String> values) {
            addCriterion("PROCESS_TLRNO in", values, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoNotIn(List<String> values) {
            addCriterion("PROCESS_TLRNO not in", values, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoBetween(String value1, String value2) {
            addCriterion("PROCESS_TLRNO between", value1, value2, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessTlrnoNotBetween(String value1, String value2) {
            addCriterion("PROCESS_TLRNO not between", value1, value2, "processTlrno");
            return (Criteria) this;
        }

        public Criteria andProcessDateIsNull() {
            addCriterion("PROCESS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andProcessDateIsNotNull() {
            addCriterion("PROCESS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDateEqualTo(String value) {
            addCriterion("PROCESS_DATE =", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateNotEqualTo(String value) {
            addCriterion("PROCESS_DATE <>", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateGreaterThan(String value) {
            addCriterion("PROCESS_DATE >", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_DATE >=", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateLessThan(String value) {
            addCriterion("PROCESS_DATE <", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_DATE <=", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateLike(String value) {
            addCriterion("PROCESS_DATE like", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateNotLike(String value) {
            addCriterion("PROCESS_DATE not like", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateIn(List<String> values) {
            addCriterion("PROCESS_DATE in", values, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateNotIn(List<String> values) {
            addCriterion("PROCESS_DATE not in", values, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateBetween(String value1, String value2) {
            addCriterion("PROCESS_DATE between", value1, value2, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateNotBetween(String value1, String value2) {
            addCriterion("PROCESS_DATE not between", value1, value2, "processDate");
            return (Criteria) this;
        }

        public Criteria andCustManagerIsNull() {
            addCriterion("CUST_MANAGER is null");
            return (Criteria) this;
        }

        public Criteria andCustManagerIsNotNull() {
            addCriterion("CUST_MANAGER is not null");
            return (Criteria) this;
        }

        public Criteria andCustManagerEqualTo(String value) {
            addCriterion("CUST_MANAGER =", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerNotEqualTo(String value) {
            addCriterion("CUST_MANAGER <>", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerGreaterThan(String value) {
            addCriterion("CUST_MANAGER >", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_MANAGER >=", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerLessThan(String value) {
            addCriterion("CUST_MANAGER <", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerLessThanOrEqualTo(String value) {
            addCriterion("CUST_MANAGER <=", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerLike(String value) {
            addCriterion("CUST_MANAGER like", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerNotLike(String value) {
            addCriterion("CUST_MANAGER not like", value, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerIn(List<String> values) {
            addCriterion("CUST_MANAGER in", values, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerNotIn(List<String> values) {
            addCriterion("CUST_MANAGER not in", values, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerBetween(String value1, String value2) {
            addCriterion("CUST_MANAGER between", value1, value2, "custManager");
            return (Criteria) this;
        }

        public Criteria andCustManagerNotBetween(String value1, String value2) {
            addCriterion("CUST_MANAGER not between", value1, value2, "custManager");
            return (Criteria) this;
        }

        public Criteria andBrcodeIsNull() {
            addCriterion("BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andBrcodeIsNotNull() {
            addCriterion("BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBrcodeEqualTo(String value) {
            addCriterion("BRCODE =", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotEqualTo(String value) {
            addCriterion("BRCODE <>", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeGreaterThan(String value) {
            addCriterion("BRCODE >", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BRCODE >=", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeLessThan(String value) {
            addCriterion("BRCODE <", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeLessThanOrEqualTo(String value) {
            addCriterion("BRCODE <=", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeLike(String value) {
            addCriterion("BRCODE like", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotLike(String value) {
            addCriterion("BRCODE not like", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeIn(List<String> values) {
            addCriterion("BRCODE in", values, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotIn(List<String> values) {
            addCriterion("BRCODE not in", values, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeBetween(String value1, String value2) {
            addCriterion("BRCODE between", value1, value2, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotBetween(String value1, String value2) {
            addCriterion("BRCODE not between", value1, value2, "brcode");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateIsNull() {
            addCriterion("WARN_DUE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateIsNotNull() {
            addCriterion("WARN_DUE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateEqualTo(String value) {
            addCriterion("WARN_DUE_DATE =", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateNotEqualTo(String value) {
            addCriterion("WARN_DUE_DATE <>", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateGreaterThan(String value) {
            addCriterion("WARN_DUE_DATE >", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_DUE_DATE >=", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateLessThan(String value) {
            addCriterion("WARN_DUE_DATE <", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateLessThanOrEqualTo(String value) {
            addCriterion("WARN_DUE_DATE <=", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateLike(String value) {
            addCriterion("WARN_DUE_DATE like", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateNotLike(String value) {
            addCriterion("WARN_DUE_DATE not like", value, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateIn(List<String> values) {
            addCriterion("WARN_DUE_DATE in", values, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateNotIn(List<String> values) {
            addCriterion("WARN_DUE_DATE not in", values, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateBetween(String value1, String value2) {
            addCriterion("WARN_DUE_DATE between", value1, value2, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andWarnDueDateNotBetween(String value1, String value2) {
            addCriterion("WARN_DUE_DATE not between", value1, value2, "warnDueDate");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdIsNull() {
            addCriterion("TOP_PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTopProductIdIsNotNull() {
            addCriterion("TOP_PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTopProductIdEqualTo(String value) {
            addCriterion("TOP_PRODUCT_ID =", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdNotEqualTo(String value) {
            addCriterion("TOP_PRODUCT_ID <>", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdGreaterThan(String value) {
            addCriterion("TOP_PRODUCT_ID >", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("TOP_PRODUCT_ID >=", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdLessThan(String value) {
            addCriterion("TOP_PRODUCT_ID <", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdLessThanOrEqualTo(String value) {
            addCriterion("TOP_PRODUCT_ID <=", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdLike(String value) {
            addCriterion("TOP_PRODUCT_ID like", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdNotLike(String value) {
            addCriterion("TOP_PRODUCT_ID not like", value, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdIn(List<String> values) {
            addCriterion("TOP_PRODUCT_ID in", values, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdNotIn(List<String> values) {
            addCriterion("TOP_PRODUCT_ID not in", values, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdBetween(String value1, String value2) {
            addCriterion("TOP_PRODUCT_ID between", value1, value2, "topProductId");
            return (Criteria) this;
        }

        public Criteria andTopProductIdNotBetween(String value1, String value2) {
            addCriterion("TOP_PRODUCT_ID not between", value1, value2, "topProductId");
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

        public Criteria andLastUpdDateIsNull() {
            addCriterion("LAST_UPD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNotNull() {
            addCriterion("LAST_UPD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE =", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE <>", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThan(Date value) {
            addCriterion("LAST_UPD_DATE >", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE >=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThan(Date value) {
            addCriterion("LAST_UPD_DATE <", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE <=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIn(List<Date> values) {
            addCriterion("LAST_UPD_DATE in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotIn(List<Date> values) {
            addCriterion("LAST_UPD_DATE not in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_DATE between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_DATE not between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}