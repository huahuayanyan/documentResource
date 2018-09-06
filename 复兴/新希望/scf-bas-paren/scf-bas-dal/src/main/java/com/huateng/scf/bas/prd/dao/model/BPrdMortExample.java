package com.huateng.scf.bas.prd.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPrdMortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPrdMortExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPrdMortExample(BPrdMortExample example) {
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

        public Criteria andMoniTypeIsNull() {
            addCriterion("MONI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMoniTypeIsNotNull() {
            addCriterion("MONI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniTypeEqualTo(String value) {
            addCriterion("MONI_TYPE =", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotEqualTo(String value) {
            addCriterion("MONI_TYPE <>", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeGreaterThan(String value) {
            addCriterion("MONI_TYPE >", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_TYPE >=", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeLessThan(String value) {
            addCriterion("MONI_TYPE <", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeLessThanOrEqualTo(String value) {
            addCriterion("MONI_TYPE <=", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeLike(String value) {
            addCriterion("MONI_TYPE like", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotLike(String value) {
            addCriterion("MONI_TYPE not like", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeIn(List<String> values) {
            addCriterion("MONI_TYPE in", values, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotIn(List<String> values) {
            addCriterion("MONI_TYPE not in", values, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeBetween(String value1, String value2) {
            addCriterion("MONI_TYPE between", value1, value2, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotBetween(String value1, String value2) {
            addCriterion("MONI_TYPE not between", value1, value2, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideIsNull() {
            addCriterion("MONI_MODE_INSIDE is null");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideIsNotNull() {
            addCriterion("MONI_MODE_INSIDE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideEqualTo(String value) {
            addCriterion("MONI_MODE_INSIDE =", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideNotEqualTo(String value) {
            addCriterion("MONI_MODE_INSIDE <>", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideGreaterThan(String value) {
            addCriterion("MONI_MODE_INSIDE >", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_MODE_INSIDE >=", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideLessThan(String value) {
            addCriterion("MONI_MODE_INSIDE <", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideLessThanOrEqualTo(String value) {
            addCriterion("MONI_MODE_INSIDE <=", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideLike(String value) {
            addCriterion("MONI_MODE_INSIDE like", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideNotLike(String value) {
            addCriterion("MONI_MODE_INSIDE not like", value, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideIn(List<String> values) {
            addCriterion("MONI_MODE_INSIDE in", values, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideNotIn(List<String> values) {
            addCriterion("MONI_MODE_INSIDE not in", values, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideBetween(String value1, String value2) {
            addCriterion("MONI_MODE_INSIDE between", value1, value2, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeInsideNotBetween(String value1, String value2) {
            addCriterion("MONI_MODE_INSIDE not between", value1, value2, "moniModeInside");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdIsNull() {
            addCriterion("MONI_MODE_THIRD is null");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdIsNotNull() {
            addCriterion("MONI_MODE_THIRD is not null");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdEqualTo(String value) {
            addCriterion("MONI_MODE_THIRD =", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdNotEqualTo(String value) {
            addCriterion("MONI_MODE_THIRD <>", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdGreaterThan(String value) {
            addCriterion("MONI_MODE_THIRD >", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_MODE_THIRD >=", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdLessThan(String value) {
            addCriterion("MONI_MODE_THIRD <", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdLessThanOrEqualTo(String value) {
            addCriterion("MONI_MODE_THIRD <=", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdLike(String value) {
            addCriterion("MONI_MODE_THIRD like", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdNotLike(String value) {
            addCriterion("MONI_MODE_THIRD not like", value, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdIn(List<String> values) {
            addCriterion("MONI_MODE_THIRD in", values, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdNotIn(List<String> values) {
            addCriterion("MONI_MODE_THIRD not in", values, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdBetween(String value1, String value2) {
            addCriterion("MONI_MODE_THIRD between", value1, value2, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeThirdNotBetween(String value1, String value2) {
            addCriterion("MONI_MODE_THIRD not between", value1, value2, "moniModeThird");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnIsNull() {
            addCriterion("MONI_MODE_OWN is null");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnIsNotNull() {
            addCriterion("MONI_MODE_OWN is not null");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnEqualTo(String value) {
            addCriterion("MONI_MODE_OWN =", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnNotEqualTo(String value) {
            addCriterion("MONI_MODE_OWN <>", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnGreaterThan(String value) {
            addCriterion("MONI_MODE_OWN >", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_MODE_OWN >=", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnLessThan(String value) {
            addCriterion("MONI_MODE_OWN <", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnLessThanOrEqualTo(String value) {
            addCriterion("MONI_MODE_OWN <=", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnLike(String value) {
            addCriterion("MONI_MODE_OWN like", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnNotLike(String value) {
            addCriterion("MONI_MODE_OWN not like", value, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnIn(List<String> values) {
            addCriterion("MONI_MODE_OWN in", values, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnNotIn(List<String> values) {
            addCriterion("MONI_MODE_OWN not in", values, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnBetween(String value1, String value2) {
            addCriterion("MONI_MODE_OWN between", value1, value2, "moniModeOwn");
            return (Criteria) this;
        }

        public Criteria andMoniModeOwnNotBetween(String value1, String value2) {
            addCriterion("MONI_MODE_OWN not between", value1, value2, "moniModeOwn");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}