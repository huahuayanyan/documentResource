package com.huateng.scf.bas.prd.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPrdCostBindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPrdCostBindExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPrdCostBindExample(BPrdCostBindExample example) {
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

        public Criteria andCostCodeIsNull() {
            addCriterion("COST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCostCodeIsNotNull() {
            addCriterion("COST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCostCodeEqualTo(String value) {
            addCriterion("COST_CODE =", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotEqualTo(String value) {
            addCriterion("COST_CODE <>", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeGreaterThan(String value) {
            addCriterion("COST_CODE >", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COST_CODE >=", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeLessThan(String value) {
            addCriterion("COST_CODE <", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeLessThanOrEqualTo(String value) {
            addCriterion("COST_CODE <=", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeLike(String value) {
            addCriterion("COST_CODE like", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotLike(String value) {
            addCriterion("COST_CODE not like", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeIn(List<String> values) {
            addCriterion("COST_CODE in", values, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotIn(List<String> values) {
            addCriterion("COST_CODE not in", values, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeBetween(String value1, String value2) {
            addCriterion("COST_CODE between", value1, value2, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotBetween(String value1, String value2) {
            addCriterion("COST_CODE not between", value1, value2, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostNameIsNull() {
            addCriterion("COST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCostNameIsNotNull() {
            addCriterion("COST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCostNameEqualTo(String value) {
            addCriterion("COST_NAME =", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotEqualTo(String value) {
            addCriterion("COST_NAME <>", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameGreaterThan(String value) {
            addCriterion("COST_NAME >", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameGreaterThanOrEqualTo(String value) {
            addCriterion("COST_NAME >=", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameLessThan(String value) {
            addCriterion("COST_NAME <", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameLessThanOrEqualTo(String value) {
            addCriterion("COST_NAME <=", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameLike(String value) {
            addCriterion("COST_NAME like", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotLike(String value) {
            addCriterion("COST_NAME not like", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameIn(List<String> values) {
            addCriterion("COST_NAME in", values, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotIn(List<String> values) {
            addCriterion("COST_NAME not in", values, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameBetween(String value1, String value2) {
            addCriterion("COST_NAME between", value1, value2, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotBetween(String value1, String value2) {
            addCriterion("COST_NAME not between", value1, value2, "costName");
            return (Criteria) this;
        }

        public Criteria andCostPhaseIsNull() {
            addCriterion("COST_PHASE is null");
            return (Criteria) this;
        }

        public Criteria andCostPhaseIsNotNull() {
            addCriterion("COST_PHASE is not null");
            return (Criteria) this;
        }

        public Criteria andCostPhaseEqualTo(String value) {
            addCriterion("COST_PHASE =", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotEqualTo(String value) {
            addCriterion("COST_PHASE <>", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseGreaterThan(String value) {
            addCriterion("COST_PHASE >", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseGreaterThanOrEqualTo(String value) {
            addCriterion("COST_PHASE >=", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseLessThan(String value) {
            addCriterion("COST_PHASE <", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseLessThanOrEqualTo(String value) {
            addCriterion("COST_PHASE <=", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseLike(String value) {
            addCriterion("COST_PHASE like", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotLike(String value) {
            addCriterion("COST_PHASE not like", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseIn(List<String> values) {
            addCriterion("COST_PHASE in", values, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotIn(List<String> values) {
            addCriterion("COST_PHASE not in", values, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseBetween(String value1, String value2) {
            addCriterion("COST_PHASE between", value1, value2, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotBetween(String value1, String value2) {
            addCriterion("COST_PHASE not between", value1, value2, "costPhase");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}