package com.huateng.scf.bas.prd.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPrdCreditBindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPrdCreditBindExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPrdCreditBindExample(BPrdCreditBindExample example) {
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

        public Criteria andCreditTypeIsNull() {
            addCriterion("CREDIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIsNotNull() {
            addCriterion("CREDIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditTypeEqualTo(String value) {
            addCriterion("CREDIT_TYPE =", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotEqualTo(String value) {
            addCriterion("CREDIT_TYPE <>", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeGreaterThan(String value) {
            addCriterion("CREDIT_TYPE >", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_TYPE >=", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLessThan(String value) {
            addCriterion("CREDIT_TYPE <", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_TYPE <=", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLike(String value) {
            addCriterion("CREDIT_TYPE like", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotLike(String value) {
            addCriterion("CREDIT_TYPE not like", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIn(List<String> values) {
            addCriterion("CREDIT_TYPE in", values, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotIn(List<String> values) {
            addCriterion("CREDIT_TYPE not in", values, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeBetween(String value1, String value2) {
            addCriterion("CREDIT_TYPE between", value1, value2, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotBetween(String value1, String value2) {
            addCriterion("CREDIT_TYPE not between", value1, value2, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseIsNull() {
            addCriterion("CREDIT_PHASE is null");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseIsNotNull() {
            addCriterion("CREDIT_PHASE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseEqualTo(String value) {
            addCriterion("CREDIT_PHASE =", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseNotEqualTo(String value) {
            addCriterion("CREDIT_PHASE <>", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseGreaterThan(String value) {
            addCriterion("CREDIT_PHASE >", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_PHASE >=", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseLessThan(String value) {
            addCriterion("CREDIT_PHASE <", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_PHASE <=", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseLike(String value) {
            addCriterion("CREDIT_PHASE like", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseNotLike(String value) {
            addCriterion("CREDIT_PHASE not like", value, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseIn(List<String> values) {
            addCriterion("CREDIT_PHASE in", values, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseNotIn(List<String> values) {
            addCriterion("CREDIT_PHASE not in", values, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseBetween(String value1, String value2) {
            addCriterion("CREDIT_PHASE between", value1, value2, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andCreditPhaseNotBetween(String value1, String value2) {
            addCriterion("CREDIT_PHASE not between", value1, value2, "creditPhase");
            return (Criteria) this;
        }

        public Criteria andOprTypeIsNull() {
            addCriterion("OPR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOprTypeIsNotNull() {
            addCriterion("OPR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOprTypeEqualTo(String value) {
            addCriterion("OPR_TYPE =", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeNotEqualTo(String value) {
            addCriterion("OPR_TYPE <>", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeGreaterThan(String value) {
            addCriterion("OPR_TYPE >", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPR_TYPE >=", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeLessThan(String value) {
            addCriterion("OPR_TYPE <", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeLessThanOrEqualTo(String value) {
            addCriterion("OPR_TYPE <=", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeLike(String value) {
            addCriterion("OPR_TYPE like", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeNotLike(String value) {
            addCriterion("OPR_TYPE not like", value, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeIn(List<String> values) {
            addCriterion("OPR_TYPE in", values, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeNotIn(List<String> values) {
            addCriterion("OPR_TYPE not in", values, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeBetween(String value1, String value2) {
            addCriterion("OPR_TYPE between", value1, value2, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprTypeNotBetween(String value1, String value2) {
            addCriterion("OPR_TYPE not between", value1, value2, "oprType");
            return (Criteria) this;
        }

        public Criteria andOprFieldIsNull() {
            addCriterion("OPR_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andOprFieldIsNotNull() {
            addCriterion("OPR_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andOprFieldEqualTo(String value) {
            addCriterion("OPR_FIELD =", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldNotEqualTo(String value) {
            addCriterion("OPR_FIELD <>", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldGreaterThan(String value) {
            addCriterion("OPR_FIELD >", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldGreaterThanOrEqualTo(String value) {
            addCriterion("OPR_FIELD >=", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldLessThan(String value) {
            addCriterion("OPR_FIELD <", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldLessThanOrEqualTo(String value) {
            addCriterion("OPR_FIELD <=", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldLike(String value) {
            addCriterion("OPR_FIELD like", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldNotLike(String value) {
            addCriterion("OPR_FIELD not like", value, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldIn(List<String> values) {
            addCriterion("OPR_FIELD in", values, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldNotIn(List<String> values) {
            addCriterion("OPR_FIELD not in", values, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldBetween(String value1, String value2) {
            addCriterion("OPR_FIELD between", value1, value2, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprFieldNotBetween(String value1, String value2) {
            addCriterion("OPR_FIELD not between", value1, value2, "oprField");
            return (Criteria) this;
        }

        public Criteria andOprModeIsNull() {
            addCriterion("OPR_MODE is null");
            return (Criteria) this;
        }

        public Criteria andOprModeIsNotNull() {
            addCriterion("OPR_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andOprModeEqualTo(String value) {
            addCriterion("OPR_MODE =", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeNotEqualTo(String value) {
            addCriterion("OPR_MODE <>", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeGreaterThan(String value) {
            addCriterion("OPR_MODE >", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeGreaterThanOrEqualTo(String value) {
            addCriterion("OPR_MODE >=", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeLessThan(String value) {
            addCriterion("OPR_MODE <", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeLessThanOrEqualTo(String value) {
            addCriterion("OPR_MODE <=", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeLike(String value) {
            addCriterion("OPR_MODE like", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeNotLike(String value) {
            addCriterion("OPR_MODE not like", value, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeIn(List<String> values) {
            addCriterion("OPR_MODE in", values, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeNotIn(List<String> values) {
            addCriterion("OPR_MODE not in", values, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeBetween(String value1, String value2) {
            addCriterion("OPR_MODE between", value1, value2, "oprMode");
            return (Criteria) this;
        }

        public Criteria andOprModeNotBetween(String value1, String value2) {
            addCriterion("OPR_MODE not between", value1, value2, "oprMode");
            return (Criteria) this;
        }

        public Criteria andFunNoIsNull() {
            addCriterion("FUN_NO is null");
            return (Criteria) this;
        }

        public Criteria andFunNoIsNotNull() {
            addCriterion("FUN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFunNoEqualTo(String value) {
            addCriterion("FUN_NO =", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoNotEqualTo(String value) {
            addCriterion("FUN_NO <>", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoGreaterThan(String value) {
            addCriterion("FUN_NO >", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoGreaterThanOrEqualTo(String value) {
            addCriterion("FUN_NO >=", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoLessThan(String value) {
            addCriterion("FUN_NO <", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoLessThanOrEqualTo(String value) {
            addCriterion("FUN_NO <=", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoLike(String value) {
            addCriterion("FUN_NO like", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoNotLike(String value) {
            addCriterion("FUN_NO not like", value, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoIn(List<String> values) {
            addCriterion("FUN_NO in", values, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoNotIn(List<String> values) {
            addCriterion("FUN_NO not in", values, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoBetween(String value1, String value2) {
            addCriterion("FUN_NO between", value1, value2, "funNo");
            return (Criteria) this;
        }

        public Criteria andFunNoNotBetween(String value1, String value2) {
            addCriterion("FUN_NO not between", value1, value2, "funNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}