package com.huateng.scf.bas.prd.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPrdBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPrdBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPrdBaseInfoExample(BPrdBaseInfoExample example) {
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

        public Criteria andLoansFlagIsNull() {
            addCriterion("LOANS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andLoansFlagIsNotNull() {
            addCriterion("LOANS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andLoansFlagEqualTo(String value) {
            addCriterion("LOANS_FLAG =", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagNotEqualTo(String value) {
            addCriterion("LOANS_FLAG <>", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagGreaterThan(String value) {
            addCriterion("LOANS_FLAG >", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagGreaterThanOrEqualTo(String value) {
            addCriterion("LOANS_FLAG >=", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagLessThan(String value) {
            addCriterion("LOANS_FLAG <", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagLessThanOrEqualTo(String value) {
            addCriterion("LOANS_FLAG <=", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagLike(String value) {
            addCriterion("LOANS_FLAG like", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagNotLike(String value) {
            addCriterion("LOANS_FLAG not like", value, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagIn(List<String> values) {
            addCriterion("LOANS_FLAG in", values, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagNotIn(List<String> values) {
            addCriterion("LOANS_FLAG not in", values, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagBetween(String value1, String value2) {
            addCriterion("LOANS_FLAG between", value1, value2, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andLoansFlagNotBetween(String value1, String value2) {
            addCriterion("LOANS_FLAG not between", value1, value2, "loansFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagIsNull() {
            addCriterion("ACCEPTANCE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagIsNotNull() {
            addCriterion("ACCEPTANCE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagEqualTo(String value) {
            addCriterion("ACCEPTANCE_FLAG =", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagNotEqualTo(String value) {
            addCriterion("ACCEPTANCE_FLAG <>", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagGreaterThan(String value) {
            addCriterion("ACCEPTANCE_FLAG >", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPTANCE_FLAG >=", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagLessThan(String value) {
            addCriterion("ACCEPTANCE_FLAG <", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagLessThanOrEqualTo(String value) {
            addCriterion("ACCEPTANCE_FLAG <=", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagLike(String value) {
            addCriterion("ACCEPTANCE_FLAG like", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagNotLike(String value) {
            addCriterion("ACCEPTANCE_FLAG not like", value, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagIn(List<String> values) {
            addCriterion("ACCEPTANCE_FLAG in", values, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagNotIn(List<String> values) {
            addCriterion("ACCEPTANCE_FLAG not in", values, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagBetween(String value1, String value2) {
            addCriterion("ACCEPTANCE_FLAG between", value1, value2, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andAcceptanceFlagNotBetween(String value1, String value2) {
            addCriterion("ACCEPTANCE_FLAG not between", value1, value2, "acceptanceFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagIsNull() {
            addCriterion("GUARANTEE_LETTER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagIsNotNull() {
            addCriterion("GUARANTEE_LETTER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagEqualTo(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG =", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagNotEqualTo(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG <>", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagGreaterThan(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG >", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagGreaterThanOrEqualTo(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG >=", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagLessThan(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG <", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagLessThanOrEqualTo(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG <=", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagLike(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG like", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagNotLike(String value) {
            addCriterion("GUARANTEE_LETTER_FLAG not like", value, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagIn(List<String> values) {
            addCriterion("GUARANTEE_LETTER_FLAG in", values, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagNotIn(List<String> values) {
            addCriterion("GUARANTEE_LETTER_FLAG not in", values, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagBetween(String value1, String value2) {
            addCriterion("GUARANTEE_LETTER_FLAG between", value1, value2, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLetterFlagNotBetween(String value1, String value2) {
            addCriterion("GUARANTEE_LETTER_FLAG not between", value1, value2, "guaranteeLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagIsNull() {
            addCriterion("CREDITR_LETTER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagIsNotNull() {
            addCriterion("CREDITR_LETTER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagEqualTo(String value) {
            addCriterion("CREDITR_LETTER_FLAG =", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagNotEqualTo(String value) {
            addCriterion("CREDITR_LETTER_FLAG <>", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagGreaterThan(String value) {
            addCriterion("CREDITR_LETTER_FLAG >", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CREDITR_LETTER_FLAG >=", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagLessThan(String value) {
            addCriterion("CREDITR_LETTER_FLAG <", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagLessThanOrEqualTo(String value) {
            addCriterion("CREDITR_LETTER_FLAG <=", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagLike(String value) {
            addCriterion("CREDITR_LETTER_FLAG like", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagNotLike(String value) {
            addCriterion("CREDITR_LETTER_FLAG not like", value, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagIn(List<String> values) {
            addCriterion("CREDITR_LETTER_FLAG in", values, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagNotIn(List<String> values) {
            addCriterion("CREDITR_LETTER_FLAG not in", values, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagBetween(String value1, String value2) {
            addCriterion("CREDITR_LETTER_FLAG between", value1, value2, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCreditrLetterFlagNotBetween(String value1, String value2) {
            addCriterion("CREDITR_LETTER_FLAG not between", value1, value2, "creditrLetterFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagIsNull() {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagIsNotNull() {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagEqualTo(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG =", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagNotEqualTo(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG <>", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagGreaterThan(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG >", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagGreaterThanOrEqualTo(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG >=", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagLessThan(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG <", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagLessThanOrEqualTo(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG <=", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagLike(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG like", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagNotLike(String value) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG not like", value, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagIn(List<String> values) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG in", values, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagNotIn(List<String> values) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG not in", values, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagBetween(String value1, String value2) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG between", value1, value2, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialDiscountFlagNotBetween(String value1, String value2) {
            addCriterion("COMMERCIAL_DISCOUNT_FLAG not between", value1, value2, "commercialDiscountFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagIsNull() {
            addCriterion("ADV_GOLD_PRICE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagIsNotNull() {
            addCriterion("ADV_GOLD_PRICE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagEqualTo(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG =", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagNotEqualTo(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG <>", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagGreaterThan(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG >", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG >=", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagLessThan(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG <", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagLessThanOrEqualTo(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG <=", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagLike(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG like", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagNotLike(String value) {
            addCriterion("ADV_GOLD_PRICE_FLAG not like", value, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagIn(List<String> values) {
            addCriterion("ADV_GOLD_PRICE_FLAG in", values, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagNotIn(List<String> values) {
            addCriterion("ADV_GOLD_PRICE_FLAG not in", values, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagBetween(String value1, String value2) {
            addCriterion("ADV_GOLD_PRICE_FLAG between", value1, value2, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvGoldPriceFlagNotBetween(String value1, String value2) {
            addCriterion("ADV_GOLD_PRICE_FLAG not between", value1, value2, "advGoldPriceFlag");
            return (Criteria) this;
        }

        public Criteria andTraStrueIsNull() {
            addCriterion("TRA_STRUE is null");
            return (Criteria) this;
        }

        public Criteria andTraStrueIsNotNull() {
            addCriterion("TRA_STRUE is not null");
            return (Criteria) this;
        }

        public Criteria andTraStrueEqualTo(String value) {
            addCriterion("TRA_STRUE =", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueNotEqualTo(String value) {
            addCriterion("TRA_STRUE <>", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueGreaterThan(String value) {
            addCriterion("TRA_STRUE >", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueGreaterThanOrEqualTo(String value) {
            addCriterion("TRA_STRUE >=", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueLessThan(String value) {
            addCriterion("TRA_STRUE <", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueLessThanOrEqualTo(String value) {
            addCriterion("TRA_STRUE <=", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueLike(String value) {
            addCriterion("TRA_STRUE like", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueNotLike(String value) {
            addCriterion("TRA_STRUE not like", value, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueIn(List<String> values) {
            addCriterion("TRA_STRUE in", values, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueNotIn(List<String> values) {
            addCriterion("TRA_STRUE not in", values, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueBetween(String value1, String value2) {
            addCriterion("TRA_STRUE between", value1, value2, "traStrue");
            return (Criteria) this;
        }

        public Criteria andTraStrueNotBetween(String value1, String value2) {
            addCriterion("TRA_STRUE not between", value1, value2, "traStrue");
            return (Criteria) this;
        }

        public Criteria andFinModelIsNull() {
            addCriterion("FIN_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andFinModelIsNotNull() {
            addCriterion("FIN_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andFinModelEqualTo(String value) {
            addCriterion("FIN_MODEL =", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelNotEqualTo(String value) {
            addCriterion("FIN_MODEL <>", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelGreaterThan(String value) {
            addCriterion("FIN_MODEL >", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_MODEL >=", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelLessThan(String value) {
            addCriterion("FIN_MODEL <", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelLessThanOrEqualTo(String value) {
            addCriterion("FIN_MODEL <=", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelLike(String value) {
            addCriterion("FIN_MODEL like", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelNotLike(String value) {
            addCriterion("FIN_MODEL not like", value, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelIn(List<String> values) {
            addCriterion("FIN_MODEL in", values, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelNotIn(List<String> values) {
            addCriterion("FIN_MODEL not in", values, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelBetween(String value1, String value2) {
            addCriterion("FIN_MODEL between", value1, value2, "finModel");
            return (Criteria) this;
        }

        public Criteria andFinModelNotBetween(String value1, String value2) {
            addCriterion("FIN_MODEL not between", value1, value2, "finModel");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagIsNull() {
            addCriterion("IS_USE_ACCESS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagIsNotNull() {
            addCriterion("IS_USE_ACCESS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagEqualTo(String value) {
            addCriterion("IS_USE_ACCESS_FLAG =", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagNotEqualTo(String value) {
            addCriterion("IS_USE_ACCESS_FLAG <>", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagGreaterThan(String value) {
            addCriterion("IS_USE_ACCESS_FLAG >", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagGreaterThanOrEqualTo(String value) {
            addCriterion("IS_USE_ACCESS_FLAG >=", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagLessThan(String value) {
            addCriterion("IS_USE_ACCESS_FLAG <", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagLessThanOrEqualTo(String value) {
            addCriterion("IS_USE_ACCESS_FLAG <=", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagLike(String value) {
            addCriterion("IS_USE_ACCESS_FLAG like", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagNotLike(String value) {
            addCriterion("IS_USE_ACCESS_FLAG not like", value, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagIn(List<String> values) {
            addCriterion("IS_USE_ACCESS_FLAG in", values, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagNotIn(List<String> values) {
            addCriterion("IS_USE_ACCESS_FLAG not in", values, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagBetween(String value1, String value2) {
            addCriterion("IS_USE_ACCESS_FLAG between", value1, value2, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsUseAccessFlagNotBetween(String value1, String value2) {
            addCriterion("IS_USE_ACCESS_FLAG not between", value1, value2, "isUseAccessFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagIsNull() {
            addCriterion("ISNFIN_GUA_LET_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagIsNotNull() {
            addCriterion("ISNFIN_GUA_LET_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagEqualTo(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG =", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagNotEqualTo(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG <>", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagGreaterThan(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG >", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG >=", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagLessThan(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG <", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagLessThanOrEqualTo(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG <=", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagLike(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG like", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagNotLike(String value) {
            addCriterion("ISNFIN_GUA_LET_FLAG not like", value, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagIn(List<String> values) {
            addCriterion("ISNFIN_GUA_LET_FLAG in", values, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagNotIn(List<String> values) {
            addCriterion("ISNFIN_GUA_LET_FLAG not in", values, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagBetween(String value1, String value2) {
            addCriterion("ISNFIN_GUA_LET_FLAG between", value1, value2, "isnfinGuaLetFlag");
            return (Criteria) this;
        }

        public Criteria andIsnfinGuaLetFlagNotBetween(String value1, String value2) {
            addCriterion("ISNFIN_GUA_LET_FLAG not between", value1, value2, "isnfinGuaLetFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}