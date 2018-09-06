package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntMprotInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntMprotInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntMprotInfoExample(BCntMprotInfoExample example) {
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

        public Criteria andProtocolNoIsNull() {
            addCriterion("PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIsNotNull() {
            addCriterion("PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoEqualTo(String value) {
            addCriterion("PROTOCOL_NO =", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotEqualTo(String value) {
            addCriterion("PROTOCOL_NO <>", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThan(String value) {
            addCriterion("PROTOCOL_NO >", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO >=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThan(String value) {
            addCriterion("PROTOCOL_NO <", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO <=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLike(String value) {
            addCriterion("PROTOCOL_NO like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotLike(String value) {
            addCriterion("PROTOCOL_NO not like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIn(List<String> values) {
            addCriterion("PROTOCOL_NO in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotIn(List<String> values) {
            addCriterion("PROTOCOL_NO not in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO between", value1, value2, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO not between", value1, value2, "protocolNo");
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

        public Criteria andPledgedAmountIsNull() {
            addCriterion("PLEDGED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountIsNotNull() {
            addCriterion("PLEDGED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountEqualTo(BigDecimal value) {
            addCriterion("PLEDGED_AMOUNT =", value, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountNotEqualTo(BigDecimal value) {
            addCriterion("PLEDGED_AMOUNT <>", value, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountGreaterThan(BigDecimal value) {
            addCriterion("PLEDGED_AMOUNT >", value, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PLEDGED_AMOUNT >=", value, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountLessThan(BigDecimal value) {
            addCriterion("PLEDGED_AMOUNT <", value, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PLEDGED_AMOUNT <=", value, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountIn(List<BigDecimal> values) {
            addCriterion("PLEDGED_AMOUNT in", values, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountNotIn(List<BigDecimal> values) {
            addCriterion("PLEDGED_AMOUNT not in", values, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLEDGED_AMOUNT between", value1, value2, "pledgedAmount");
            return (Criteria) this;
        }

        public Criteria andPledgedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLEDGED_AMOUNT not between", value1, value2, "pledgedAmount");
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

        public Criteria andBalAmountIsNull() {
            addCriterion("BAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBalAmountIsNotNull() {
            addCriterion("BAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBalAmountEqualTo(BigDecimal value) {
            addCriterion("BAL_AMOUNT =", value, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountNotEqualTo(BigDecimal value) {
            addCriterion("BAL_AMOUNT <>", value, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountGreaterThan(BigDecimal value) {
            addCriterion("BAL_AMOUNT >", value, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_AMOUNT >=", value, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountLessThan(BigDecimal value) {
            addCriterion("BAL_AMOUNT <", value, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_AMOUNT <=", value, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountIn(List<BigDecimal> values) {
            addCriterion("BAL_AMOUNT in", values, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountNotIn(List<BigDecimal> values) {
            addCriterion("BAL_AMOUNT not in", values, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_AMOUNT between", value1, value2, "balAmount");
            return (Criteria) this;
        }

        public Criteria andBalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_AMOUNT not between", value1, value2, "balAmount");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}