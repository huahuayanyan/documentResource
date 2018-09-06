package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcMtgMktPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcMtgMktPriceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcMtgMktPriceExample(BPbcMtgMktPriceExample example) {
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

        public Criteria andMortgageSubClassIsNull() {
            addCriterion("MORTGAGE_SUB_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassIsNotNull() {
            addCriterion("MORTGAGE_SUB_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS =", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS <>", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassGreaterThan(String value) {
            addCriterion("MORTGAGE_SUB_CLASS >", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS >=", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassLessThan(String value) {
            addCriterion("MORTGAGE_SUB_CLASS <", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS <=", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassLike(String value) {
            addCriterion("MORTGAGE_SUB_CLASS like", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotLike(String value) {
            addCriterion("MORTGAGE_SUB_CLASS not like", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassIn(List<String> values) {
            addCriterion("MORTGAGE_SUB_CLASS in", values, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotIn(List<String> values) {
            addCriterion("MORTGAGE_SUB_CLASS not in", values, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassBetween(String value1, String value2) {
            addCriterion("MORTGAGE_SUB_CLASS between", value1, value2, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_SUB_CLASS not between", value1, value2, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageModelIsNull() {
            addCriterion("MORTGAGE_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andMortgageModelIsNotNull() {
            addCriterion("MORTGAGE_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageModelEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL =", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL <>", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelGreaterThan(String value) {
            addCriterion("MORTGAGE_MODEL >", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL >=", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelLessThan(String value) {
            addCriterion("MORTGAGE_MODEL <", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL <=", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelLike(String value) {
            addCriterion("MORTGAGE_MODEL like", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotLike(String value) {
            addCriterion("MORTGAGE_MODEL not like", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelIn(List<String> values) {
            addCriterion("MORTGAGE_MODEL in", values, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotIn(List<String> values) {
            addCriterion("MORTGAGE_MODEL not in", values, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelBetween(String value1, String value2) {
            addCriterion("MORTGAGE_MODEL between", value1, value2, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_MODEL not between", value1, value2, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoIsNull() {
            addCriterion("MORTGAGE_CLASS_NO is null");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoIsNotNull() {
            addCriterion("MORTGAGE_CLASS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS_NO =", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoNotEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS_NO <>", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoGreaterThan(String value) {
            addCriterion("MORTGAGE_CLASS_NO >", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS_NO >=", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoLessThan(String value) {
            addCriterion("MORTGAGE_CLASS_NO <", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS_NO <=", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoLike(String value) {
            addCriterion("MORTGAGE_CLASS_NO like", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoNotLike(String value) {
            addCriterion("MORTGAGE_CLASS_NO not like", value, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoIn(List<String> values) {
            addCriterion("MORTGAGE_CLASS_NO in", values, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoNotIn(List<String> values) {
            addCriterion("MORTGAGE_CLASS_NO not in", values, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoBetween(String value1, String value2) {
            addCriterion("MORTGAGE_CLASS_NO between", value1, value2, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNoNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_CLASS_NO not between", value1, value2, "mortgageClassNo");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcIsNull() {
            addCriterion("MARKET_PRICE_SRC is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcIsNotNull() {
            addCriterion("MARKET_PRICE_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcEqualTo(String value) {
            addCriterion("MARKET_PRICE_SRC =", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcNotEqualTo(String value) {
            addCriterion("MARKET_PRICE_SRC <>", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcGreaterThan(String value) {
            addCriterion("MARKET_PRICE_SRC >", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcGreaterThanOrEqualTo(String value) {
            addCriterion("MARKET_PRICE_SRC >=", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcLessThan(String value) {
            addCriterion("MARKET_PRICE_SRC <", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcLessThanOrEqualTo(String value) {
            addCriterion("MARKET_PRICE_SRC <=", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcLike(String value) {
            addCriterion("MARKET_PRICE_SRC like", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcNotLike(String value) {
            addCriterion("MARKET_PRICE_SRC not like", value, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcIn(List<String> values) {
            addCriterion("MARKET_PRICE_SRC in", values, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcNotIn(List<String> values) {
            addCriterion("MARKET_PRICE_SRC not in", values, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcBetween(String value1, String value2) {
            addCriterion("MARKET_PRICE_SRC between", value1, value2, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andMarketPriceSrcNotBetween(String value1, String value2) {
            addCriterion("MARKET_PRICE_SRC not between", value1, value2, "marketPriceSrc");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionIsNull() {
            addCriterion("SRC_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionIsNotNull() {
            addCriterion("SRC_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionEqualTo(String value) {
            addCriterion("SRC_DESCRIPTION =", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionNotEqualTo(String value) {
            addCriterion("SRC_DESCRIPTION <>", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionGreaterThan(String value) {
            addCriterion("SRC_DESCRIPTION >", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("SRC_DESCRIPTION >=", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionLessThan(String value) {
            addCriterion("SRC_DESCRIPTION <", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionLessThanOrEqualTo(String value) {
            addCriterion("SRC_DESCRIPTION <=", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionLike(String value) {
            addCriterion("SRC_DESCRIPTION like", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionNotLike(String value) {
            addCriterion("SRC_DESCRIPTION not like", value, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionIn(List<String> values) {
            addCriterion("SRC_DESCRIPTION in", values, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionNotIn(List<String> values) {
            addCriterion("SRC_DESCRIPTION not in", values, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionBetween(String value1, String value2) {
            addCriterion("SRC_DESCRIPTION between", value1, value2, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andSrcDescriptionNotBetween(String value1, String value2) {
            addCriterion("SRC_DESCRIPTION not between", value1, value2, "srcDescription");
            return (Criteria) this;
        }

        public Criteria andCurcdIsNull() {
            addCriterion("CURCD is null");
            return (Criteria) this;
        }

        public Criteria andCurcdIsNotNull() {
            addCriterion("CURCD is not null");
            return (Criteria) this;
        }

        public Criteria andCurcdEqualTo(String value) {
            addCriterion("CURCD =", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotEqualTo(String value) {
            addCriterion("CURCD <>", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdGreaterThan(String value) {
            addCriterion("CURCD >", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdGreaterThanOrEqualTo(String value) {
            addCriterion("CURCD >=", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdLessThan(String value) {
            addCriterion("CURCD <", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdLessThanOrEqualTo(String value) {
            addCriterion("CURCD <=", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdLike(String value) {
            addCriterion("CURCD like", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotLike(String value) {
            addCriterion("CURCD not like", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdIn(List<String> values) {
            addCriterion("CURCD in", values, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotIn(List<String> values) {
            addCriterion("CURCD not in", values, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdBetween(String value1, String value2) {
            addCriterion("CURCD between", value1, value2, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotBetween(String value1, String value2) {
            addCriterion("CURCD not between", value1, value2, "curcd");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsIsNull() {
            addCriterion("MORTGAGE_UNITS is null");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsIsNotNull() {
            addCriterion("MORTGAGE_UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS =", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS <>", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsGreaterThan(String value) {
            addCriterion("MORTGAGE_UNITS >", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS >=", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsLessThan(String value) {
            addCriterion("MORTGAGE_UNITS <", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS <=", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsLike(String value) {
            addCriterion("MORTGAGE_UNITS like", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotLike(String value) {
            addCriterion("MORTGAGE_UNITS not like", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsIn(List<String> values) {
            addCriterion("MORTGAGE_UNITS in", values, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotIn(List<String> values) {
            addCriterion("MORTGAGE_UNITS not in", values, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsBetween(String value1, String value2) {
            addCriterion("MORTGAGE_UNITS between", value1, value2, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_UNITS not between", value1, value2, "mortgageUnits");
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

        public Criteria andMortgageLevelOneIsNull() {
            addCriterion("MORTGAGE_LEVEL_ONE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_ONE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE =", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE <>", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE >", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE >=", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE <", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE <=", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneLike(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE like", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE not like", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_ONE in", values, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_ONE not in", values, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_ONE between", value1, value2, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_ONE not between", value1, value2, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoIsNull() {
            addCriterion("MORTGAGE_LEVEL_TWO is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_TWO is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO =", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO <>", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO >", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO >=", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO <", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO <=", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoLike(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO like", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO not like", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_TWO in", values, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_TWO not in", values, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_TWO between", value1, value2, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_TWO not between", value1, value2, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeIsNull() {
            addCriterion("MORTGAGE_LEVEL_THREE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_THREE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE =", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE <>", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE >", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE >=", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE <", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE <=", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeLike(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE like", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE not like", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_THREE in", values, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_THREE not in", values, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_THREE between", value1, value2, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_THREE not between", value1, value2, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIsNull() {
            addCriterion("MORTGAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIsNotNull() {
            addCriterion("MORTGAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoEqualTo(String value) {
            addCriterion("MORTGAGE_NO =", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotEqualTo(String value) {
            addCriterion("MORTGAGE_NO <>", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThan(String value) {
            addCriterion("MORTGAGE_NO >", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NO >=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThan(String value) {
            addCriterion("MORTGAGE_NO <", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NO <=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLike(String value) {
            addCriterion("MORTGAGE_NO like", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotLike(String value) {
            addCriterion("MORTGAGE_NO not like", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIn(List<String> values) {
            addCriterion("MORTGAGE_NO in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotIn(List<String> values) {
            addCriterion("MORTGAGE_NO not in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NO between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NO not between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameIsNull() {
            addCriterion("MORTGAGE_THREE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameIsNotNull() {
            addCriterion("MORTGAGE_THREE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameEqualTo(String value) {
            addCriterion("MORTGAGE_THREE_NAME =", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameNotEqualTo(String value) {
            addCriterion("MORTGAGE_THREE_NAME <>", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameGreaterThan(String value) {
            addCriterion("MORTGAGE_THREE_NAME >", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_THREE_NAME >=", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameLessThan(String value) {
            addCriterion("MORTGAGE_THREE_NAME <", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_THREE_NAME <=", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameLike(String value) {
            addCriterion("MORTGAGE_THREE_NAME like", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameNotLike(String value) {
            addCriterion("MORTGAGE_THREE_NAME not like", value, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameIn(List<String> values) {
            addCriterion("MORTGAGE_THREE_NAME in", values, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameNotIn(List<String> values) {
            addCriterion("MORTGAGE_THREE_NAME not in", values, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameBetween(String value1, String value2) {
            addCriterion("MORTGAGE_THREE_NAME between", value1, value2, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andMortgageThreeNameNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_THREE_NAME not between", value1, value2, "mortgageThreeName");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andPriceDateIsNull() {
            addCriterion("PRICE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPriceDateIsNotNull() {
            addCriterion("PRICE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDateEqualTo(String value) {
            addCriterion("PRICE_DATE =", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotEqualTo(String value) {
            addCriterion("PRICE_DATE <>", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateGreaterThan(String value) {
            addCriterion("PRICE_DATE >", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_DATE >=", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateLessThan(String value) {
            addCriterion("PRICE_DATE <", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateLessThanOrEqualTo(String value) {
            addCriterion("PRICE_DATE <=", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateLike(String value) {
            addCriterion("PRICE_DATE like", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotLike(String value) {
            addCriterion("PRICE_DATE not like", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateIn(List<String> values) {
            addCriterion("PRICE_DATE in", values, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotIn(List<String> values) {
            addCriterion("PRICE_DATE not in", values, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateBetween(String value1, String value2) {
            addCriterion("PRICE_DATE between", value1, value2, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotBetween(String value1, String value2) {
            addCriterion("PRICE_DATE not between", value1, value2, "priceDate");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceIsNull() {
            addCriterion("UP_DOWN_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceIsNotNull() {
            addCriterion("UP_DOWN_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_PRICE =", value, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceNotEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_PRICE <>", value, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceGreaterThan(BigDecimal value) {
            addCriterion("UP_DOWN_PRICE >", value, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_PRICE >=", value, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceLessThan(BigDecimal value) {
            addCriterion("UP_DOWN_PRICE <", value, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_PRICE <=", value, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceIn(List<BigDecimal> values) {
            addCriterion("UP_DOWN_PRICE in", values, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceNotIn(List<BigDecimal> values) {
            addCriterion("UP_DOWN_PRICE not in", values, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UP_DOWN_PRICE between", value1, value2, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andUpDownPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UP_DOWN_PRICE not between", value1, value2, "upDownPrice");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("ADD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("ADD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(String value) {
            addCriterion("ADD_DATE =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(String value) {
            addCriterion("ADD_DATE <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(String value) {
            addCriterion("ADD_DATE >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_DATE >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(String value) {
            addCriterion("ADD_DATE <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(String value) {
            addCriterion("ADD_DATE <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLike(String value) {
            addCriterion("ADD_DATE like", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotLike(String value) {
            addCriterion("ADD_DATE not like", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<String> values) {
            addCriterion("ADD_DATE in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<String> values) {
            addCriterion("ADD_DATE not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(String value1, String value2) {
            addCriterion("ADD_DATE between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(String value1, String value2) {
            addCriterion("ADD_DATE not between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameIsNull() {
            addCriterion("MORT_UNITS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameIsNotNull() {
            addCriterion("MORT_UNITS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameEqualTo(String value) {
            addCriterion("MORT_UNITS_NAME =", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameNotEqualTo(String value) {
            addCriterion("MORT_UNITS_NAME <>", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameGreaterThan(String value) {
            addCriterion("MORT_UNITS_NAME >", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameGreaterThanOrEqualTo(String value) {
            addCriterion("MORT_UNITS_NAME >=", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameLessThan(String value) {
            addCriterion("MORT_UNITS_NAME <", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameLessThanOrEqualTo(String value) {
            addCriterion("MORT_UNITS_NAME <=", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameLike(String value) {
            addCriterion("MORT_UNITS_NAME like", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameNotLike(String value) {
            addCriterion("MORT_UNITS_NAME not like", value, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameIn(List<String> values) {
            addCriterion("MORT_UNITS_NAME in", values, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameNotIn(List<String> values) {
            addCriterion("MORT_UNITS_NAME not in", values, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameBetween(String value1, String value2) {
            addCriterion("MORT_UNITS_NAME between", value1, value2, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andMortUnitsNameNotBetween(String value1, String value2) {
            addCriterion("MORT_UNITS_NAME not between", value1, value2, "mortUnitsName");
            return (Criteria) this;
        }

        public Criteria andTlrcdIsNull() {
            addCriterion("TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andTlrcdIsNotNull() {
            addCriterion("TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andTlrcdEqualTo(String value) {
            addCriterion("TLRCD =", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotEqualTo(String value) {
            addCriterion("TLRCD <>", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdGreaterThan(String value) {
            addCriterion("TLRCD >", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("TLRCD >=", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdLessThan(String value) {
            addCriterion("TLRCD <", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdLessThanOrEqualTo(String value) {
            addCriterion("TLRCD <=", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdLike(String value) {
            addCriterion("TLRCD like", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotLike(String value) {
            addCriterion("TLRCD not like", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdIn(List<String> values) {
            addCriterion("TLRCD in", values, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotIn(List<String> values) {
            addCriterion("TLRCD not in", values, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdBetween(String value1, String value2) {
            addCriterion("TLRCD between", value1, value2, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotBetween(String value1, String value2) {
            addCriterion("TLRCD not between", value1, value2, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME not between", value1, value2, "crtTime");
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

        public Criteria andLastUpdTlrcdIsNull() {
            addCriterion("LAST_UPD_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIsNotNull() {
            addCriterion("LAST_UPD_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD =", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <>", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThan(String value) {
            addCriterion("LAST_UPD_TLRCD >", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD >=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThan(String value) {
            addCriterion("LAST_UPD_TLRCD <", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLike(String value) {
            addCriterion("LAST_UPD_TLRCD like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotLike(String value) {
            addCriterion("LAST_UPD_TLRCD not like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD not in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD not between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNull() {
            addCriterion("LAST_UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNotNull() {
            addCriterion("LAST_UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME =", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <>", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThan(Date value) {
            addCriterion("LAST_UPD_TIME >", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME >=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThan(Date value) {
            addCriterion("LAST_UPD_TIME <", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME not in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME not between", value1, value2, "lastUpdTime");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}