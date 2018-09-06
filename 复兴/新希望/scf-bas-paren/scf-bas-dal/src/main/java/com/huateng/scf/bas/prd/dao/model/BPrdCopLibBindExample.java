package com.huateng.scf.bas.prd.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPrdCopLibBindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPrdCopLibBindExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPrdCopLibBindExample(BPrdCopLibBindExample example) {
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

        public Criteria andRelIdIsNull() {
            addCriterion("REL_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNotNull() {
            addCriterion("REL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelIdEqualTo(String value) {
            addCriterion("REL_ID =", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotEqualTo(String value) {
            addCriterion("REL_ID <>", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThan(String value) {
            addCriterion("REL_ID >", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThanOrEqualTo(String value) {
            addCriterion("REL_ID >=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThan(String value) {
            addCriterion("REL_ID <", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThanOrEqualTo(String value) {
            addCriterion("REL_ID <=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLike(String value) {
            addCriterion("REL_ID like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotLike(String value) {
            addCriterion("REL_ID not like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdIn(List<String> values) {
            addCriterion("REL_ID in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotIn(List<String> values) {
            addCriterion("REL_ID not in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdBetween(String value1, String value2) {
            addCriterion("REL_ID between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotBetween(String value1, String value2) {
            addCriterion("REL_ID not between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andCopNameIsNull() {
            addCriterion("COP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCopNameIsNotNull() {
            addCriterion("COP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCopNameEqualTo(String value) {
            addCriterion("COP_NAME =", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotEqualTo(String value) {
            addCriterion("COP_NAME <>", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameGreaterThan(String value) {
            addCriterion("COP_NAME >", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameGreaterThanOrEqualTo(String value) {
            addCriterion("COP_NAME >=", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameLessThan(String value) {
            addCriterion("COP_NAME <", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameLessThanOrEqualTo(String value) {
            addCriterion("COP_NAME <=", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameLike(String value) {
            addCriterion("COP_NAME like", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotLike(String value) {
            addCriterion("COP_NAME not like", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameIn(List<String> values) {
            addCriterion("COP_NAME in", values, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotIn(List<String> values) {
            addCriterion("COP_NAME not in", values, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameBetween(String value1, String value2) {
            addCriterion("COP_NAME between", value1, value2, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotBetween(String value1, String value2) {
            addCriterion("COP_NAME not between", value1, value2, "copName");
            return (Criteria) this;
        }

        public Criteria andCopTypeIsNull() {
            addCriterion("COP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCopTypeIsNotNull() {
            addCriterion("COP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCopTypeEqualTo(String value) {
            addCriterion("COP_TYPE =", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeNotEqualTo(String value) {
            addCriterion("COP_TYPE <>", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeGreaterThan(String value) {
            addCriterion("COP_TYPE >", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeGreaterThanOrEqualTo(String value) {
            addCriterion("COP_TYPE >=", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeLessThan(String value) {
            addCriterion("COP_TYPE <", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeLessThanOrEqualTo(String value) {
            addCriterion("COP_TYPE <=", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeLike(String value) {
            addCriterion("COP_TYPE like", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeNotLike(String value) {
            addCriterion("COP_TYPE not like", value, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeIn(List<String> values) {
            addCriterion("COP_TYPE in", values, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeNotIn(List<String> values) {
            addCriterion("COP_TYPE not in", values, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeBetween(String value1, String value2) {
            addCriterion("COP_TYPE between", value1, value2, "copType");
            return (Criteria) this;
        }

        public Criteria andCopTypeNotBetween(String value1, String value2) {
            addCriterion("COP_TYPE not between", value1, value2, "copType");
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

        public Criteria andCopOrderIsNull() {
            addCriterion("COP_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andCopOrderIsNotNull() {
            addCriterion("COP_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andCopOrderEqualTo(BigDecimal value) {
            addCriterion("COP_ORDER =", value, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderNotEqualTo(BigDecimal value) {
            addCriterion("COP_ORDER <>", value, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderGreaterThan(BigDecimal value) {
            addCriterion("COP_ORDER >", value, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COP_ORDER >=", value, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderLessThan(BigDecimal value) {
            addCriterion("COP_ORDER <", value, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COP_ORDER <=", value, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderIn(List<BigDecimal> values) {
            addCriterion("COP_ORDER in", values, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderNotIn(List<BigDecimal> values) {
            addCriterion("COP_ORDER not in", values, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COP_ORDER between", value1, value2, "copOrder");
            return (Criteria) this;
        }

        public Criteria andCopOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COP_ORDER not between", value1, value2, "copOrder");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}