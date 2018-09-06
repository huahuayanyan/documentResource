package com.huateng.scf.bas.nte.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNteNoticeMtgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BNteNoticeMtgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BNteNoticeMtgExample(BNteNoticeMtgExample example) {
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

        public Criteria andAppnoIsNull() {
            addCriterion("APPNO is null");
            return (Criteria) this;
        }

        public Criteria andAppnoIsNotNull() {
            addCriterion("APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andAppnoEqualTo(String value) {
            addCriterion("APPNO =", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotEqualTo(String value) {
            addCriterion("APPNO <>", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoGreaterThan(String value) {
            addCriterion("APPNO >", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("APPNO >=", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLessThan(String value) {
            addCriterion("APPNO <", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLessThanOrEqualTo(String value) {
            addCriterion("APPNO <=", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLike(String value) {
            addCriterion("APPNO like", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotLike(String value) {
            addCriterion("APPNO not like", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoIn(List<String> values) {
            addCriterion("APPNO in", values, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotIn(List<String> values) {
            addCriterion("APPNO not in", values, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoBetween(String value1, String value2) {
            addCriterion("APPNO between", value1, value2, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotBetween(String value1, String value2) {
            addCriterion("APPNO not between", value1, value2, "appno");
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

        public Criteria andMortgageLevelFourIsNull() {
            addCriterion("MORTGAGE_LEVEL_FOUR is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_FOUR is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR =", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR <>", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR >", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR >=", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR <", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR <=", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR like", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR not like", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FOUR in", values, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FOUR not in", values, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FOUR between", value1, value2, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FOUR not between", value1, value2, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveIsNull() {
            addCriterion("MORTGAGE_LEVEL_FIVE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_FIVE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE =", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE <>", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE >", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE >=", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE <", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE <=", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE like", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE not like", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FIVE in", values, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FIVE not in", values, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FIVE between", value1, value2, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FIVE not between", value1, value2, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(BigDecimal value) {
            addCriterion("QUANTITY =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(BigDecimal value) {
            addCriterion("QUANTITY >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(BigDecimal value) {
            addCriterion("QUANTITY <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<BigDecimal> values) {
            addCriterion("QUANTITY in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<BigDecimal> values) {
            addCriterion("QUANTITY not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceIsNull() {
            addCriterion("CONFIRM_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceIsNotNull() {
            addCriterion("CONFIRM_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE =", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceNotEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE <>", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceGreaterThan(BigDecimal value) {
            addCriterion("CONFIRM_PRICE >", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE >=", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceLessThan(BigDecimal value) {
            addCriterion("CONFIRM_PRICE <", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE <=", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceIn(List<BigDecimal> values) {
            addCriterion("CONFIRM_PRICE in", values, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceNotIn(List<BigDecimal> values) {
            addCriterion("CONFIRM_PRICE not in", values, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONFIRM_PRICE between", value1, value2, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONFIRM_PRICE not between", value1, value2, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceIsNull() {
            addCriterion("TOT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotPriceIsNotNull() {
            addCriterion("TOT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotPriceEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE =", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceNotEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE <>", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceGreaterThan(BigDecimal value) {
            addCriterion("TOT_PRICE >", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE >=", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceLessThan(BigDecimal value) {
            addCriterion("TOT_PRICE <", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE <=", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceIn(List<BigDecimal> values) {
            addCriterion("TOT_PRICE in", values, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceNotIn(List<BigDecimal> values) {
            addCriterion("TOT_PRICE not in", values, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_PRICE between", value1, value2, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_PRICE not between", value1, value2, "totPrice");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeIsNull() {
            addCriterion("MORTGAGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeIsNotNull() {
            addCriterion("MORTGAGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeEqualTo(String value) {
            addCriterion("MORTGAGE_TYPE =", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeNotEqualTo(String value) {
            addCriterion("MORTGAGE_TYPE <>", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeGreaterThan(String value) {
            addCriterion("MORTGAGE_TYPE >", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_TYPE >=", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeLessThan(String value) {
            addCriterion("MORTGAGE_TYPE <", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_TYPE <=", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeLike(String value) {
            addCriterion("MORTGAGE_TYPE like", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeNotLike(String value) {
            addCriterion("MORTGAGE_TYPE not like", value, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeIn(List<String> values) {
            addCriterion("MORTGAGE_TYPE in", values, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeNotIn(List<String> values) {
            addCriterion("MORTGAGE_TYPE not in", values, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeBetween(String value1, String value2) {
            addCriterion("MORTGAGE_TYPE between", value1, value2, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andMortgageTypeNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_TYPE not between", value1, value2, "mortgageType");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressIsNull() {
            addCriterion("WAREHOUSE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressIsNotNull() {
            addCriterion("WAREHOUSE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS =", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS <>", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressGreaterThan(String value) {
            addCriterion("WAREHOUSE_ADDRESS >", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS >=", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLessThan(String value) {
            addCriterion("WAREHOUSE_ADDRESS <", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS <=", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLike(String value) {
            addCriterion("WAREHOUSE_ADDRESS like", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotLike(String value) {
            addCriterion("WAREHOUSE_ADDRESS not like", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressIn(List<String> values) {
            addCriterion("WAREHOUSE_ADDRESS in", values, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotIn(List<String> values) {
            addCriterion("WAREHOUSE_ADDRESS not in", values, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ADDRESS between", value1, value2, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ADDRESS not between", value1, value2, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
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

        public Criteria andMortgageNameIsNull() {
            addCriterion("MORTGAGE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMortgageNameIsNotNull() {
            addCriterion("MORTGAGE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageNameEqualTo(String value) {
            addCriterion("MORTGAGE_NAME =", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotEqualTo(String value) {
            addCriterion("MORTGAGE_NAME <>", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameGreaterThan(String value) {
            addCriterion("MORTGAGE_NAME >", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NAME >=", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameLessThan(String value) {
            addCriterion("MORTGAGE_NAME <", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NAME <=", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameLike(String value) {
            addCriterion("MORTGAGE_NAME like", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotLike(String value) {
            addCriterion("MORTGAGE_NAME not like", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameIn(List<String> values) {
            addCriterion("MORTGAGE_NAME in", values, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotIn(List<String> values) {
            addCriterion("MORTGAGE_NAME not in", values, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NAME between", value1, value2, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NAME not between", value1, value2, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
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

        public Criteria andWeightUnitsIsNull() {
            addCriterion("WEIGHT_UNITS is null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIsNotNull() {
            addCriterion("WEIGHT_UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsEqualTo(String value) {
            addCriterion("WEIGHT_UNITS =", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotEqualTo(String value) {
            addCriterion("WEIGHT_UNITS <>", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThan(String value) {
            addCriterion("WEIGHT_UNITS >", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNITS >=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThan(String value) {
            addCriterion("WEIGHT_UNITS <", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNITS <=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLike(String value) {
            addCriterion("WEIGHT_UNITS like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotLike(String value) {
            addCriterion("WEIGHT_UNITS not like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIn(List<String> values) {
            addCriterion("WEIGHT_UNITS in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotIn(List<String> values) {
            addCriterion("WEIGHT_UNITS not in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNITS between", value1, value2, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNITS not between", value1, value2, "weightUnits");
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

        public Criteria andWarehouseIsNull() {
            addCriterion("WAREHOUSE is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNotNull() {
            addCriterion("WAREHOUSE is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEqualTo(String value) {
            addCriterion("WAREHOUSE =", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotEqualTo(String value) {
            addCriterion("WAREHOUSE <>", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThan(String value) {
            addCriterion("WAREHOUSE >", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE >=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThan(String value) {
            addCriterion("WAREHOUSE <", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE <=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLike(String value) {
            addCriterion("WAREHOUSE like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotLike(String value) {
            addCriterion("WAREHOUSE not like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseIn(List<String> values) {
            addCriterion("WAREHOUSE in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotIn(List<String> values) {
            addCriterion("WAREHOUSE not in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseBetween(String value1, String value2) {
            addCriterion("WAREHOUSE between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE not between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWeightAllIsNull() {
            addCriterion("WEIGHT_ALL is null");
            return (Criteria) this;
        }

        public Criteria andWeightAllIsNotNull() {
            addCriterion("WEIGHT_ALL is not null");
            return (Criteria) this;
        }

        public Criteria andWeightAllEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL =", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllNotEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL <>", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllGreaterThan(BigDecimal value) {
            addCriterion("WEIGHT_ALL >", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL >=", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllLessThan(BigDecimal value) {
            addCriterion("WEIGHT_ALL <", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL <=", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllIn(List<BigDecimal> values) {
            addCriterion("WEIGHT_ALL in", values, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllNotIn(List<BigDecimal> values) {
            addCriterion("WEIGHT_ALL not in", values, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT_ALL between", value1, value2, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT_ALL not between", value1, value2, "weightAll");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNull() {
            addCriterion("ENGINE_NO is null");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNotNull() {
            addCriterion("ENGINE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNoEqualTo(String value) {
            addCriterion("ENGINE_NO =", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotEqualTo(String value) {
            addCriterion("ENGINE_NO <>", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThan(String value) {
            addCriterion("ENGINE_NO >", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThanOrEqualTo(String value) {
            addCriterion("ENGINE_NO >=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThan(String value) {
            addCriterion("ENGINE_NO <", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThanOrEqualTo(String value) {
            addCriterion("ENGINE_NO <=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLike(String value) {
            addCriterion("ENGINE_NO like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotLike(String value) {
            addCriterion("ENGINE_NO not like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIn(List<String> values) {
            addCriterion("ENGINE_NO in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotIn(List<String> values) {
            addCriterion("ENGINE_NO not in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoBetween(String value1, String value2) {
            addCriterion("ENGINE_NO between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotBetween(String value1, String value2) {
            addCriterion("ENGINE_NO not between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoIsNull() {
            addCriterion("CHASSIS_NO is null");
            return (Criteria) this;
        }

        public Criteria andChassisNoIsNotNull() {
            addCriterion("CHASSIS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andChassisNoEqualTo(String value) {
            addCriterion("CHASSIS_NO =", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotEqualTo(String value) {
            addCriterion("CHASSIS_NO <>", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoGreaterThan(String value) {
            addCriterion("CHASSIS_NO >", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoGreaterThanOrEqualTo(String value) {
            addCriterion("CHASSIS_NO >=", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoLessThan(String value) {
            addCriterion("CHASSIS_NO <", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoLessThanOrEqualTo(String value) {
            addCriterion("CHASSIS_NO <=", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoLike(String value) {
            addCriterion("CHASSIS_NO like", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotLike(String value) {
            addCriterion("CHASSIS_NO not like", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoIn(List<String> values) {
            addCriterion("CHASSIS_NO in", values, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotIn(List<String> values) {
            addCriterion("CHASSIS_NO not in", values, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoBetween(String value1, String value2) {
            addCriterion("CHASSIS_NO between", value1, value2, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotBetween(String value1, String value2) {
            addCriterion("CHASSIS_NO not between", value1, value2, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoIsNull() {
            addCriterion("CERTIFICATION_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertificationNoIsNotNull() {
            addCriterion("CERTIFICATION_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationNoEqualTo(String value) {
            addCriterion("CERTIFICATION_NO =", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotEqualTo(String value) {
            addCriterion("CERTIFICATION_NO <>", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoGreaterThan(String value) {
            addCriterion("CERTIFICATION_NO >", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATION_NO >=", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoLessThan(String value) {
            addCriterion("CERTIFICATION_NO <", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATION_NO <=", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoLike(String value) {
            addCriterion("CERTIFICATION_NO like", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotLike(String value) {
            addCriterion("CERTIFICATION_NO not like", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoIn(List<String> values) {
            addCriterion("CERTIFICATION_NO in", values, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotIn(List<String> values) {
            addCriterion("CERTIFICATION_NO not in", values, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoBetween(String value1, String value2) {
            addCriterion("CERTIFICATION_NO between", value1, value2, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATION_NO not between", value1, value2, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("START_DATE like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("START_DATE not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("END_DATE like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("END_DATE not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoIsNull() {
            addCriterion("FIX_MORTGAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoIsNotNull() {
            addCriterion("FIX_MORTGAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO =", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO <>", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoGreaterThan(String value) {
            addCriterion("FIX_MORTGAGE_NO >", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoGreaterThanOrEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO >=", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoLessThan(String value) {
            addCriterion("FIX_MORTGAGE_NO <", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoLessThanOrEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO <=", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoLike(String value) {
            addCriterion("FIX_MORTGAGE_NO like", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotLike(String value) {
            addCriterion("FIX_MORTGAGE_NO not like", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoIn(List<String> values) {
            addCriterion("FIX_MORTGAGE_NO in", values, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotIn(List<String> values) {
            addCriterion("FIX_MORTGAGE_NO not in", values, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoBetween(String value1, String value2) {
            addCriterion("FIX_MORTGAGE_NO between", value1, value2, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotBetween(String value1, String value2) {
            addCriterion("FIX_MORTGAGE_NO not between", value1, value2, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andJoinBatchIsNull() {
            addCriterion("JOIN_BATCH is null");
            return (Criteria) this;
        }

        public Criteria andJoinBatchIsNotNull() {
            addCriterion("JOIN_BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andJoinBatchEqualTo(String value) {
            addCriterion("JOIN_BATCH =", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotEqualTo(String value) {
            addCriterion("JOIN_BATCH <>", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchGreaterThan(String value) {
            addCriterion("JOIN_BATCH >", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchGreaterThanOrEqualTo(String value) {
            addCriterion("JOIN_BATCH >=", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchLessThan(String value) {
            addCriterion("JOIN_BATCH <", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchLessThanOrEqualTo(String value) {
            addCriterion("JOIN_BATCH <=", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchLike(String value) {
            addCriterion("JOIN_BATCH like", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotLike(String value) {
            addCriterion("JOIN_BATCH not like", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchIn(List<String> values) {
            addCriterion("JOIN_BATCH in", values, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotIn(List<String> values) {
            addCriterion("JOIN_BATCH not in", values, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchBetween(String value1, String value2) {
            addCriterion("JOIN_BATCH between", value1, value2, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotBetween(String value1, String value2) {
            addCriterion("JOIN_BATCH not between", value1, value2, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("MARKET_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("MARKET_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE =", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE <>", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("MARKET_PRICE >", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE >=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(BigDecimal value) {
            addCriterion("MARKET_PRICE <", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE <=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<BigDecimal> values) {
            addCriterion("MARKET_PRICE in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("MARKET_PRICE not in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARKET_PRICE between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARKET_PRICE not between", value1, value2, "marketPrice");
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

        public Criteria andConfirmAccordingIsNull() {
            addCriterion("CONFIRM_ACCORDING is null");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingIsNotNull() {
            addCriterion("CONFIRM_ACCORDING is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING =", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING <>", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingGreaterThan(String value) {
            addCriterion("CONFIRM_ACCORDING >", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING >=", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingLessThan(String value) {
            addCriterion("CONFIRM_ACCORDING <", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING <=", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingLike(String value) {
            addCriterion("CONFIRM_ACCORDING like", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotLike(String value) {
            addCriterion("CONFIRM_ACCORDING not like", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingIn(List<String> values) {
            addCriterion("CONFIRM_ACCORDING in", values, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotIn(List<String> values) {
            addCriterion("CONFIRM_ACCORDING not in", values, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingBetween(String value1, String value2) {
            addCriterion("CONFIRM_ACCORDING between", value1, value2, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_ACCORDING not between", value1, value2, "confirmAccording");
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

        public Criteria andManufacturerIsNull() {
            addCriterion("MANUFACTURER is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("MANUFACTURER is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("MANUFACTURER =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("MANUFACTURER <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("MANUFACTURER >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("MANUFACTURER <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("MANUFACTURER like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("MANUFACTURER not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("MANUFACTURER in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("MANUFACTURER not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("MANUFACTURER between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("MANUFACTURER not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIsNull() {
            addCriterion("DOCUMENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIsNotNull() {
            addCriterion("DOCUMENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoEqualTo(String value) {
            addCriterion("DOCUMENT_NO =", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotEqualTo(String value) {
            addCriterion("DOCUMENT_NO <>", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThan(String value) {
            addCriterion("DOCUMENT_NO >", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThanOrEqualTo(String value) {
            addCriterion("DOCUMENT_NO >=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThan(String value) {
            addCriterion("DOCUMENT_NO <", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThanOrEqualTo(String value) {
            addCriterion("DOCUMENT_NO <=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLike(String value) {
            addCriterion("DOCUMENT_NO like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotLike(String value) {
            addCriterion("DOCUMENT_NO not like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIn(List<String> values) {
            addCriterion("DOCUMENT_NO in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotIn(List<String> values) {
            addCriterion("DOCUMENT_NO not in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoBetween(String value1, String value2) {
            addCriterion("DOCUMENT_NO between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotBetween(String value1, String value2) {
            addCriterion("DOCUMENT_NO not between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNull() {
            addCriterion("MANUFACTURE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNotNull() {
            addCriterion("MANUFACTURE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE =", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE <>", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThan(String value) {
            addCriterion("MANUFACTURE_DATE >", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThanOrEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE >=", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThan(String value) {
            addCriterion("MANUFACTURE_DATE <", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThanOrEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE <=", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLike(String value) {
            addCriterion("MANUFACTURE_DATE like", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotLike(String value) {
            addCriterion("MANUFACTURE_DATE not like", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIn(List<String> values) {
            addCriterion("MANUFACTURE_DATE in", values, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotIn(List<String> values) {
            addCriterion("MANUFACTURE_DATE not in", values, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateBetween(String value1, String value2) {
            addCriterion("MANUFACTURE_DATE between", value1, value2, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotBetween(String value1, String value2) {
            addCriterion("MANUFACTURE_DATE not between", value1, value2, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andBalQuantityIsNull() {
            addCriterion("BAL_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andBalQuantityIsNotNull() {
            addCriterion("BAL_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andBalQuantityEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY =", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityNotEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY <>", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityGreaterThan(BigDecimal value) {
            addCriterion("BAL_QUANTITY >", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY >=", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityLessThan(BigDecimal value) {
            addCriterion("BAL_QUANTITY <", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY <=", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityIn(List<BigDecimal> values) {
            addCriterion("BAL_QUANTITY in", values, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityNotIn(List<BigDecimal> values) {
            addCriterion("BAL_QUANTITY not in", values, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_QUANTITY between", value1, value2, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_QUANTITY not between", value1, value2, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andTradeContnoIsNull() {
            addCriterion("TRADE_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andTradeContnoIsNotNull() {
            addCriterion("TRADE_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andTradeContnoEqualTo(String value) {
            addCriterion("TRADE_CONTNO =", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotEqualTo(String value) {
            addCriterion("TRADE_CONTNO <>", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoGreaterThan(String value) {
            addCriterion("TRADE_CONTNO >", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_CONTNO >=", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoLessThan(String value) {
            addCriterion("TRADE_CONTNO <", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoLessThanOrEqualTo(String value) {
            addCriterion("TRADE_CONTNO <=", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoLike(String value) {
            addCriterion("TRADE_CONTNO like", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotLike(String value) {
            addCriterion("TRADE_CONTNO not like", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoIn(List<String> values) {
            addCriterion("TRADE_CONTNO in", values, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotIn(List<String> values) {
            addCriterion("TRADE_CONTNO not in", values, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoBetween(String value1, String value2) {
            addCriterion("TRADE_CONTNO between", value1, value2, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotBetween(String value1, String value2) {
            addCriterion("TRADE_CONTNO not between", value1, value2, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoIsNull() {
            addCriterion("SRC_MORTGAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoIsNotNull() {
            addCriterion("SRC_MORTGAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoEqualTo(String value) {
            addCriterion("SRC_MORTGAGE_NO =", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoNotEqualTo(String value) {
            addCriterion("SRC_MORTGAGE_NO <>", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoGreaterThan(String value) {
            addCriterion("SRC_MORTGAGE_NO >", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoGreaterThanOrEqualTo(String value) {
            addCriterion("SRC_MORTGAGE_NO >=", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoLessThan(String value) {
            addCriterion("SRC_MORTGAGE_NO <", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoLessThanOrEqualTo(String value) {
            addCriterion("SRC_MORTGAGE_NO <=", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoLike(String value) {
            addCriterion("SRC_MORTGAGE_NO like", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoNotLike(String value) {
            addCriterion("SRC_MORTGAGE_NO not like", value, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoIn(List<String> values) {
            addCriterion("SRC_MORTGAGE_NO in", values, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoNotIn(List<String> values) {
            addCriterion("SRC_MORTGAGE_NO not in", values, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoBetween(String value1, String value2) {
            addCriterion("SRC_MORTGAGE_NO between", value1, value2, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andSrcMortgageNoNotBetween(String value1, String value2) {
            addCriterion("SRC_MORTGAGE_NO not between", value1, value2, "srcMortgageNo");
            return (Criteria) this;
        }

        public Criteria andPackagewIsNull() {
            addCriterion("PACKAGEW is null");
            return (Criteria) this;
        }

        public Criteria andPackagewIsNotNull() {
            addCriterion("PACKAGEW is not null");
            return (Criteria) this;
        }

        public Criteria andPackagewEqualTo(String value) {
            addCriterion("PACKAGEW =", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotEqualTo(String value) {
            addCriterion("PACKAGEW <>", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewGreaterThan(String value) {
            addCriterion("PACKAGEW >", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewGreaterThanOrEqualTo(String value) {
            addCriterion("PACKAGEW >=", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewLessThan(String value) {
            addCriterion("PACKAGEW <", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewLessThanOrEqualTo(String value) {
            addCriterion("PACKAGEW <=", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewLike(String value) {
            addCriterion("PACKAGEW like", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotLike(String value) {
            addCriterion("PACKAGEW not like", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewIn(List<String> values) {
            addCriterion("PACKAGEW in", values, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotIn(List<String> values) {
            addCriterion("PACKAGEW not in", values, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewBetween(String value1, String value2) {
            addCriterion("PACKAGEW between", value1, value2, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotBetween(String value1, String value2) {
            addCriterion("PACKAGEW not between", value1, value2, "packagew");
            return (Criteria) this;
        }

        public Criteria andQualityLevelIsNull() {
            addCriterion("QUALITY_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andQualityLevelIsNotNull() {
            addCriterion("QUALITY_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andQualityLevelEqualTo(String value) {
            addCriterion("QUALITY_LEVEL =", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotEqualTo(String value) {
            addCriterion("QUALITY_LEVEL <>", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelGreaterThan(String value) {
            addCriterion("QUALITY_LEVEL >", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("QUALITY_LEVEL >=", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelLessThan(String value) {
            addCriterion("QUALITY_LEVEL <", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelLessThanOrEqualTo(String value) {
            addCriterion("QUALITY_LEVEL <=", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelLike(String value) {
            addCriterion("QUALITY_LEVEL like", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotLike(String value) {
            addCriterion("QUALITY_LEVEL not like", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelIn(List<String> values) {
            addCriterion("QUALITY_LEVEL in", values, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotIn(List<String> values) {
            addCriterion("QUALITY_LEVEL not in", values, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelBetween(String value1, String value2) {
            addCriterion("QUALITY_LEVEL between", value1, value2, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotBetween(String value1, String value2) {
            addCriterion("QUALITY_LEVEL not between", value1, value2, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("SN =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("SN <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("SN >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("SN >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("SN <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("SN <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("SN like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("SN not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("SN in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("SN not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("SN between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}