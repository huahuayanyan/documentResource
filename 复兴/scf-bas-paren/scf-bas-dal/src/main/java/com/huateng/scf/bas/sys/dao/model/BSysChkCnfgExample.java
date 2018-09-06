package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysChkCnfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysChkCnfgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysChkCnfgExample(BSysChkCnfgExample example) {
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

        public Criteria andChkItIdIsNull() {
            addCriterion("CHK_IT_ID is null");
            return (Criteria) this;
        }

        public Criteria andChkItIdIsNotNull() {
            addCriterion("CHK_IT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChkItIdEqualTo(String value) {
            addCriterion("CHK_IT_ID =", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotEqualTo(String value) {
            addCriterion("CHK_IT_ID <>", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdGreaterThan(String value) {
            addCriterion("CHK_IT_ID >", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_IT_ID >=", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdLessThan(String value) {
            addCriterion("CHK_IT_ID <", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdLessThanOrEqualTo(String value) {
            addCriterion("CHK_IT_ID <=", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdLike(String value) {
            addCriterion("CHK_IT_ID like", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotLike(String value) {
            addCriterion("CHK_IT_ID not like", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdIn(List<String> values) {
            addCriterion("CHK_IT_ID in", values, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotIn(List<String> values) {
            addCriterion("CHK_IT_ID not in", values, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdBetween(String value1, String value2) {
            addCriterion("CHK_IT_ID between", value1, value2, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotBetween(String value1, String value2) {
            addCriterion("CHK_IT_ID not between", value1, value2, "chkItId");
            return (Criteria) this;
        }

        public Criteria andRemIsNull() {
            addCriterion("REM is null");
            return (Criteria) this;
        }

        public Criteria andRemIsNotNull() {
            addCriterion("REM is not null");
            return (Criteria) this;
        }

        public Criteria andRemEqualTo(String value) {
            addCriterion("REM =", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotEqualTo(String value) {
            addCriterion("REM <>", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThan(String value) {
            addCriterion("REM >", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThanOrEqualTo(String value) {
            addCriterion("REM >=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThan(String value) {
            addCriterion("REM <", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThanOrEqualTo(String value) {
            addCriterion("REM <=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLike(String value) {
            addCriterion("REM like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotLike(String value) {
            addCriterion("REM not like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemIn(List<String> values) {
            addCriterion("REM in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotIn(List<String> values) {
            addCriterion("REM not in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemBetween(String value1, String value2) {
            addCriterion("REM between", value1, value2, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotBetween(String value1, String value2) {
            addCriterion("REM not between", value1, value2, "rem");
            return (Criteria) this;
        }

        public Criteria andClazzIsNull() {
            addCriterion("CLAZZ is null");
            return (Criteria) this;
        }

        public Criteria andClazzIsNotNull() {
            addCriterion("CLAZZ is not null");
            return (Criteria) this;
        }

        public Criteria andClazzEqualTo(String value) {
            addCriterion("CLAZZ =", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotEqualTo(String value) {
            addCriterion("CLAZZ <>", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThan(String value) {
            addCriterion("CLAZZ >", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThanOrEqualTo(String value) {
            addCriterion("CLAZZ >=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThan(String value) {
            addCriterion("CLAZZ <", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThanOrEqualTo(String value) {
            addCriterion("CLAZZ <=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLike(String value) {
            addCriterion("CLAZZ like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotLike(String value) {
            addCriterion("CLAZZ not like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzIn(List<String> values) {
            addCriterion("CLAZZ in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotIn(List<String> values) {
            addCriterion("CLAZZ not in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzBetween(String value1, String value2) {
            addCriterion("CLAZZ between", value1, value2, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotBetween(String value1, String value2) {
            addCriterion("CLAZZ not between", value1, value2, "clazz");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}