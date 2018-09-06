package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysGlobalInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysGlobalInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysGlobalInfoExample(BSysGlobalInfoExample example) {
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

        public Criteria andSysCodeIsNull() {
            addCriterion("SYS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSysCodeIsNotNull() {
            addCriterion("SYS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSysCodeEqualTo(String value) {
            addCriterion("SYS_CODE =", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotEqualTo(String value) {
            addCriterion("SYS_CODE <>", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThan(String value) {
            addCriterion("SYS_CODE >", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_CODE >=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThan(String value) {
            addCriterion("SYS_CODE <", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThanOrEqualTo(String value) {
            addCriterion("SYS_CODE <=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLike(String value) {
            addCriterion("SYS_CODE like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotLike(String value) {
            addCriterion("SYS_CODE not like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeIn(List<String> values) {
            addCriterion("SYS_CODE in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotIn(List<String> values) {
            addCriterion("SYS_CODE not in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeBetween(String value1, String value2) {
            addCriterion("SYS_CODE between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotBetween(String value1, String value2) {
            addCriterion("SYS_CODE not between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNull() {
            addCriterion("SYSTEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNotNull() {
            addCriterion("SYSTEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNameEqualTo(String value) {
            addCriterion("SYSTEM_NAME =", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotEqualTo(String value) {
            addCriterion("SYSTEM_NAME <>", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThan(String value) {
            addCriterion("SYSTEM_NAME >", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_NAME >=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThan(String value) {
            addCriterion("SYSTEM_NAME <", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_NAME <=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLike(String value) {
            addCriterion("SYSTEM_NAME like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotLike(String value) {
            addCriterion("SYSTEM_NAME not like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameIn(List<String> values) {
            addCriterion("SYSTEM_NAME in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotIn(List<String> values) {
            addCriterion("SYSTEM_NAME not in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameBetween(String value1, String value2) {
            addCriterion("SYSTEM_NAME between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_NAME not between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andTbsdyIsNull() {
            addCriterion("TBSDY is null");
            return (Criteria) this;
        }

        public Criteria andTbsdyIsNotNull() {
            addCriterion("TBSDY is not null");
            return (Criteria) this;
        }

        public Criteria andTbsdyEqualTo(String value) {
            addCriterion("TBSDY =", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyNotEqualTo(String value) {
            addCriterion("TBSDY <>", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyGreaterThan(String value) {
            addCriterion("TBSDY >", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyGreaterThanOrEqualTo(String value) {
            addCriterion("TBSDY >=", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyLessThan(String value) {
            addCriterion("TBSDY <", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyLessThanOrEqualTo(String value) {
            addCriterion("TBSDY <=", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyLike(String value) {
            addCriterion("TBSDY like", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyNotLike(String value) {
            addCriterion("TBSDY not like", value, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyIn(List<String> values) {
            addCriterion("TBSDY in", values, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyNotIn(List<String> values) {
            addCriterion("TBSDY not in", values, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyBetween(String value1, String value2) {
            addCriterion("TBSDY between", value1, value2, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andTbsdyNotBetween(String value1, String value2) {
            addCriterion("TBSDY not between", value1, value2, "tbsdy");
            return (Criteria) this;
        }

        public Criteria andBhdateIsNull() {
            addCriterion("BHDATE is null");
            return (Criteria) this;
        }

        public Criteria andBhdateIsNotNull() {
            addCriterion("BHDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBhdateEqualTo(String value) {
            addCriterion("BHDATE =", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateNotEqualTo(String value) {
            addCriterion("BHDATE <>", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateGreaterThan(String value) {
            addCriterion("BHDATE >", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateGreaterThanOrEqualTo(String value) {
            addCriterion("BHDATE >=", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateLessThan(String value) {
            addCriterion("BHDATE <", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateLessThanOrEqualTo(String value) {
            addCriterion("BHDATE <=", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateLike(String value) {
            addCriterion("BHDATE like", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateNotLike(String value) {
            addCriterion("BHDATE not like", value, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateIn(List<String> values) {
            addCriterion("BHDATE in", values, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateNotIn(List<String> values) {
            addCriterion("BHDATE not in", values, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateBetween(String value1, String value2) {
            addCriterion("BHDATE between", value1, value2, "bhdate");
            return (Criteria) this;
        }

        public Criteria andBhdateNotBetween(String value1, String value2) {
            addCriterion("BHDATE not between", value1, value2, "bhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateIsNull() {
            addCriterion("LBHDATE is null");
            return (Criteria) this;
        }

        public Criteria andLbhdateIsNotNull() {
            addCriterion("LBHDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLbhdateEqualTo(String value) {
            addCriterion("LBHDATE =", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateNotEqualTo(String value) {
            addCriterion("LBHDATE <>", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateGreaterThan(String value) {
            addCriterion("LBHDATE >", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateGreaterThanOrEqualTo(String value) {
            addCriterion("LBHDATE >=", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateLessThan(String value) {
            addCriterion("LBHDATE <", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateLessThanOrEqualTo(String value) {
            addCriterion("LBHDATE <=", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateLike(String value) {
            addCriterion("LBHDATE like", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateNotLike(String value) {
            addCriterion("LBHDATE not like", value, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateIn(List<String> values) {
            addCriterion("LBHDATE in", values, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateNotIn(List<String> values) {
            addCriterion("LBHDATE not in", values, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateBetween(String value1, String value2) {
            addCriterion("LBHDATE between", value1, value2, "lbhdate");
            return (Criteria) this;
        }

        public Criteria andLbhdateNotBetween(String value1, String value2) {
            addCriterion("LBHDATE not between", value1, value2, "lbhdate");
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

        public Criteria andSystemTypeIsNull() {
            addCriterion("SYSTEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSystemTypeIsNotNull() {
            addCriterion("SYSTEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSystemTypeEqualTo(String value) {
            addCriterion("SYSTEM_TYPE =", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeNotEqualTo(String value) {
            addCriterion("SYSTEM_TYPE <>", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeGreaterThan(String value) {
            addCriterion("SYSTEM_TYPE >", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_TYPE >=", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeLessThan(String value) {
            addCriterion("SYSTEM_TYPE <", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_TYPE <=", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeLike(String value) {
            addCriterion("SYSTEM_TYPE like", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeNotLike(String value) {
            addCriterion("SYSTEM_TYPE not like", value, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeIn(List<String> values) {
            addCriterion("SYSTEM_TYPE in", values, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeNotIn(List<String> values) {
            addCriterion("SYSTEM_TYPE not in", values, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeBetween(String value1, String value2) {
            addCriterion("SYSTEM_TYPE between", value1, value2, "systemType");
            return (Criteria) this;
        }

        public Criteria andSystemTypeNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_TYPE not between", value1, value2, "systemType");
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

        public Criteria andMiscflgsIsNull() {
            addCriterion("MISCFLGS is null");
            return (Criteria) this;
        }

        public Criteria andMiscflgsIsNotNull() {
            addCriterion("MISCFLGS is not null");
            return (Criteria) this;
        }

        public Criteria andMiscflgsEqualTo(String value) {
            addCriterion("MISCFLGS =", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotEqualTo(String value) {
            addCriterion("MISCFLGS <>", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsGreaterThan(String value) {
            addCriterion("MISCFLGS >", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsGreaterThanOrEqualTo(String value) {
            addCriterion("MISCFLGS >=", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsLessThan(String value) {
            addCriterion("MISCFLGS <", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsLessThanOrEqualTo(String value) {
            addCriterion("MISCFLGS <=", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsLike(String value) {
            addCriterion("MISCFLGS like", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotLike(String value) {
            addCriterion("MISCFLGS not like", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsIn(List<String> values) {
            addCriterion("MISCFLGS in", values, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotIn(List<String> values) {
            addCriterion("MISCFLGS not in", values, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsBetween(String value1, String value2) {
            addCriterion("MISCFLGS between", value1, value2, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotBetween(String value1, String value2) {
            addCriterion("MISCFLGS not between", value1, value2, "miscflgs");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}