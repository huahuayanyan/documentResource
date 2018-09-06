package com.huateng.scf.bas.prd.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPrdBizSurBindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPrdBizSurBindExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPrdBizSurBindExample(BPrdBizSurBindExample example) {
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

        public Criteria andBProdBizSurIdIsNull() {
            addCriterion("B_PROD_BIZ_SUR_ID is null");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdIsNotNull() {
            addCriterion("B_PROD_BIZ_SUR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdEqualTo(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID =", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdNotEqualTo(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID <>", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdGreaterThan(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID >", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdGreaterThanOrEqualTo(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID >=", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdLessThan(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID <", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdLessThanOrEqualTo(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID <=", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdLike(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID like", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdNotLike(String value) {
            addCriterion("B_PROD_BIZ_SUR_ID not like", value, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdIn(List<String> values) {
            addCriterion("B_PROD_BIZ_SUR_ID in", values, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdNotIn(List<String> values) {
            addCriterion("B_PROD_BIZ_SUR_ID not in", values, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdBetween(String value1, String value2) {
            addCriterion("B_PROD_BIZ_SUR_ID between", value1, value2, "bProdBizSurId");
            return (Criteria) this;
        }

        public Criteria andBProdBizSurIdNotBetween(String value1, String value2) {
            addCriterion("B_PROD_BIZ_SUR_ID not between", value1, value2, "bProdBizSurId");
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

        public Criteria andMatlTypeIsNull() {
            addCriterion("MATL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMatlTypeIsNotNull() {
            addCriterion("MATL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMatlTypeEqualTo(String value) {
            addCriterion("MATL_TYPE =", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeNotEqualTo(String value) {
            addCriterion("MATL_TYPE <>", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeGreaterThan(String value) {
            addCriterion("MATL_TYPE >", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MATL_TYPE >=", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeLessThan(String value) {
            addCriterion("MATL_TYPE <", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeLessThanOrEqualTo(String value) {
            addCriterion("MATL_TYPE <=", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeLike(String value) {
            addCriterion("MATL_TYPE like", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeNotLike(String value) {
            addCriterion("MATL_TYPE not like", value, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeIn(List<String> values) {
            addCriterion("MATL_TYPE in", values, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeNotIn(List<String> values) {
            addCriterion("MATL_TYPE not in", values, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeBetween(String value1, String value2) {
            addCriterion("MATL_TYPE between", value1, value2, "matlType");
            return (Criteria) this;
        }

        public Criteria andMatlTypeNotBetween(String value1, String value2) {
            addCriterion("MATL_TYPE not between", value1, value2, "matlType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}