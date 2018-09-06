package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntBuyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntBuyInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntBuyInfoExample(BCntBuyInfoExample example) {
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

        public Criteria andTradeContcodeIsNull() {
            addCriterion("TRADE_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeIsNotNull() {
            addCriterion("TRADE_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeEqualTo(String value) {
            addCriterion("TRADE_CONTCODE =", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeNotEqualTo(String value) {
            addCriterion("TRADE_CONTCODE <>", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeGreaterThan(String value) {
            addCriterion("TRADE_CONTCODE >", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_CONTCODE >=", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeLessThan(String value) {
            addCriterion("TRADE_CONTCODE <", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeLessThanOrEqualTo(String value) {
            addCriterion("TRADE_CONTCODE <=", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeLike(String value) {
            addCriterion("TRADE_CONTCODE like", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeNotLike(String value) {
            addCriterion("TRADE_CONTCODE not like", value, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeIn(List<String> values) {
            addCriterion("TRADE_CONTCODE in", values, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeNotIn(List<String> values) {
            addCriterion("TRADE_CONTCODE not in", values, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeBetween(String value1, String value2) {
            addCriterion("TRADE_CONTCODE between", value1, value2, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andTradeContcodeNotBetween(String value1, String value2) {
            addCriterion("TRADE_CONTCODE not between", value1, value2, "tradeContcode");
            return (Criteria) this;
        }

        public Criteria andMastContnoIsNull() {
            addCriterion("MAST_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andMastContnoIsNotNull() {
            addCriterion("MAST_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andMastContnoEqualTo(String value) {
            addCriterion("MAST_CONTNO =", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotEqualTo(String value) {
            addCriterion("MAST_CONTNO <>", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoGreaterThan(String value) {
            addCriterion("MAST_CONTNO >", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoGreaterThanOrEqualTo(String value) {
            addCriterion("MAST_CONTNO >=", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLessThan(String value) {
            addCriterion("MAST_CONTNO <", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLessThanOrEqualTo(String value) {
            addCriterion("MAST_CONTNO <=", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLike(String value) {
            addCriterion("MAST_CONTNO like", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotLike(String value) {
            addCriterion("MAST_CONTNO not like", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoIn(List<String> values) {
            addCriterion("MAST_CONTNO in", values, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotIn(List<String> values) {
            addCriterion("MAST_CONTNO not in", values, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoBetween(String value1, String value2) {
            addCriterion("MAST_CONTNO between", value1, value2, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotBetween(String value1, String value2) {
            addCriterion("MAST_CONTNO not between", value1, value2, "mastContno");
            return (Criteria) this;
        }

        public Criteria andCustcdIsNull() {
            addCriterion("CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCustcdIsNotNull() {
            addCriterion("CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdEqualTo(String value) {
            addCriterion("CUSTCD =", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotEqualTo(String value) {
            addCriterion("CUSTCD <>", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThan(String value) {
            addCriterion("CUSTCD >", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD >=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThan(String value) {
            addCriterion("CUSTCD <", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD <=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLike(String value) {
            addCriterion("CUSTCD like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotLike(String value) {
            addCriterion("CUSTCD not like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdIn(List<String> values) {
            addCriterion("CUSTCD in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotIn(List<String> values) {
            addCriterion("CUSTCD not in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdBetween(String value1, String value2) {
            addCriterion("CUSTCD between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotBetween(String value1, String value2) {
            addCriterion("CUSTCD not between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("APPLY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("APPLY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(String value) {
            addCriterion("APPLY_DATE =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(String value) {
            addCriterion("APPLY_DATE <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(String value) {
            addCriterion("APPLY_DATE >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_DATE >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(String value) {
            addCriterion("APPLY_DATE <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(String value) {
            addCriterion("APPLY_DATE <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLike(String value) {
            addCriterion("APPLY_DATE like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotLike(String value) {
            addCriterion("APPLY_DATE not like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<String> values) {
            addCriterion("APPLY_DATE in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<String> values) {
            addCriterion("APPLY_DATE not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(String value1, String value2) {
            addCriterion("APPLY_DATE between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(String value1, String value2) {
            addCriterion("APPLY_DATE not between", value1, value2, "applyDate");
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

        public Criteria andTotAmtIsNull() {
            addCriterion("TOT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTotAmtIsNotNull() {
            addCriterion("TOT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTotAmtEqualTo(BigDecimal value) {
            addCriterion("TOT_AMT =", value, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtNotEqualTo(BigDecimal value) {
            addCriterion("TOT_AMT <>", value, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtGreaterThan(BigDecimal value) {
            addCriterion("TOT_AMT >", value, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_AMT >=", value, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtLessThan(BigDecimal value) {
            addCriterion("TOT_AMT <", value, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_AMT <=", value, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtIn(List<BigDecimal> values) {
            addCriterion("TOT_AMT in", values, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtNotIn(List<BigDecimal> values) {
            addCriterion("TOT_AMT not in", values, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_AMT between", value1, value2, "totAmt");
            return (Criteria) this;
        }

        public Criteria andTotAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_AMT not between", value1, value2, "totAmt");
            return (Criteria) this;
        }

        public Criteria andAmtIsNull() {
            addCriterion("AMT is null");
            return (Criteria) this;
        }

        public Criteria andAmtIsNotNull() {
            addCriterion("AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAmtEqualTo(BigDecimal value) {
            addCriterion("AMT =", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotEqualTo(BigDecimal value) {
            addCriterion("AMT <>", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThan(BigDecimal value) {
            addCriterion("AMT >", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMT >=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThan(BigDecimal value) {
            addCriterion("AMT <", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMT <=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtIn(List<BigDecimal> values) {
            addCriterion("AMT in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotIn(List<BigDecimal> values) {
            addCriterion("AMT not in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMT between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMT not between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtIsNull() {
            addCriterion("REMAIN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andRemainAmtIsNotNull() {
            addCriterion("REMAIN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andRemainAmtEqualTo(BigDecimal value) {
            addCriterion("REMAIN_AMT =", value, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtNotEqualTo(BigDecimal value) {
            addCriterion("REMAIN_AMT <>", value, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtGreaterThan(BigDecimal value) {
            addCriterion("REMAIN_AMT >", value, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMAIN_AMT >=", value, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtLessThan(BigDecimal value) {
            addCriterion("REMAIN_AMT <", value, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMAIN_AMT <=", value, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtIn(List<BigDecimal> values) {
            addCriterion("REMAIN_AMT in", values, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtNotIn(List<BigDecimal> values) {
            addCriterion("REMAIN_AMT not in", values, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMAIN_AMT between", value1, value2, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMAIN_AMT not between", value1, value2, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("CNAME =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("CNAME <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("CNAME >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("CNAME <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("CNAME <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("CNAME like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("CNAME not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("CNAME in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("CNAME not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("CNAME between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("CNAME not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("POSTCODE =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("POSTCODE <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("POSTCODE >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("POSTCODE >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("POSTCODE <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("POSTCODE <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("POSTCODE like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("POSTCODE not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("POSTCODE in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("POSTCODE not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("POSTCODE between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("POSTCODE not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("BANK is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("BANK is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("BANK =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("BANK <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("BANK >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("BANK >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("BANK <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("BANK <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("BANK like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("BANK not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("BANK in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("BANK not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("BANK between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("BANK not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andSecCustcdIsNull() {
            addCriterion("SEC_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andSecCustcdIsNotNull() {
            addCriterion("SEC_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andSecCustcdEqualTo(String value) {
            addCriterion("SEC_CUSTCD =", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdNotEqualTo(String value) {
            addCriterion("SEC_CUSTCD <>", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdGreaterThan(String value) {
            addCriterion("SEC_CUSTCD >", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_CUSTCD >=", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdLessThan(String value) {
            addCriterion("SEC_CUSTCD <", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdLessThanOrEqualTo(String value) {
            addCriterion("SEC_CUSTCD <=", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdLike(String value) {
            addCriterion("SEC_CUSTCD like", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdNotLike(String value) {
            addCriterion("SEC_CUSTCD not like", value, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdIn(List<String> values) {
            addCriterion("SEC_CUSTCD in", values, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdNotIn(List<String> values) {
            addCriterion("SEC_CUSTCD not in", values, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdBetween(String value1, String value2) {
            addCriterion("SEC_CUSTCD between", value1, value2, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCustcdNotBetween(String value1, String value2) {
            addCriterion("SEC_CUSTCD not between", value1, value2, "secCustcd");
            return (Criteria) this;
        }

        public Criteria andSecCnameIsNull() {
            addCriterion("SEC_CNAME is null");
            return (Criteria) this;
        }

        public Criteria andSecCnameIsNotNull() {
            addCriterion("SEC_CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSecCnameEqualTo(String value) {
            addCriterion("SEC_CNAME =", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameNotEqualTo(String value) {
            addCriterion("SEC_CNAME <>", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameGreaterThan(String value) {
            addCriterion("SEC_CNAME >", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_CNAME >=", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameLessThan(String value) {
            addCriterion("SEC_CNAME <", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameLessThanOrEqualTo(String value) {
            addCriterion("SEC_CNAME <=", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameLike(String value) {
            addCriterion("SEC_CNAME like", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameNotLike(String value) {
            addCriterion("SEC_CNAME not like", value, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameIn(List<String> values) {
            addCriterion("SEC_CNAME in", values, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameNotIn(List<String> values) {
            addCriterion("SEC_CNAME not in", values, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameBetween(String value1, String value2) {
            addCriterion("SEC_CNAME between", value1, value2, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecCnameNotBetween(String value1, String value2) {
            addCriterion("SEC_CNAME not between", value1, value2, "secCname");
            return (Criteria) this;
        }

        public Criteria andSecTelIsNull() {
            addCriterion("SEC_TEL is null");
            return (Criteria) this;
        }

        public Criteria andSecTelIsNotNull() {
            addCriterion("SEC_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andSecTelEqualTo(String value) {
            addCriterion("SEC_TEL =", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelNotEqualTo(String value) {
            addCriterion("SEC_TEL <>", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelGreaterThan(String value) {
            addCriterion("SEC_TEL >", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_TEL >=", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelLessThan(String value) {
            addCriterion("SEC_TEL <", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelLessThanOrEqualTo(String value) {
            addCriterion("SEC_TEL <=", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelLike(String value) {
            addCriterion("SEC_TEL like", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelNotLike(String value) {
            addCriterion("SEC_TEL not like", value, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelIn(List<String> values) {
            addCriterion("SEC_TEL in", values, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelNotIn(List<String> values) {
            addCriterion("SEC_TEL not in", values, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelBetween(String value1, String value2) {
            addCriterion("SEC_TEL between", value1, value2, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecTelNotBetween(String value1, String value2) {
            addCriterion("SEC_TEL not between", value1, value2, "secTel");
            return (Criteria) this;
        }

        public Criteria andSecAddressIsNull() {
            addCriterion("SEC_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andSecAddressIsNotNull() {
            addCriterion("SEC_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andSecAddressEqualTo(String value) {
            addCriterion("SEC_ADDRESS =", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressNotEqualTo(String value) {
            addCriterion("SEC_ADDRESS <>", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressGreaterThan(String value) {
            addCriterion("SEC_ADDRESS >", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_ADDRESS >=", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressLessThan(String value) {
            addCriterion("SEC_ADDRESS <", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressLessThanOrEqualTo(String value) {
            addCriterion("SEC_ADDRESS <=", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressLike(String value) {
            addCriterion("SEC_ADDRESS like", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressNotLike(String value) {
            addCriterion("SEC_ADDRESS not like", value, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressIn(List<String> values) {
            addCriterion("SEC_ADDRESS in", values, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressNotIn(List<String> values) {
            addCriterion("SEC_ADDRESS not in", values, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressBetween(String value1, String value2) {
            addCriterion("SEC_ADDRESS between", value1, value2, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecAddressNotBetween(String value1, String value2) {
            addCriterion("SEC_ADDRESS not between", value1, value2, "secAddress");
            return (Criteria) this;
        }

        public Criteria andSecBankIsNull() {
            addCriterion("SEC_BANK is null");
            return (Criteria) this;
        }

        public Criteria andSecBankIsNotNull() {
            addCriterion("SEC_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andSecBankEqualTo(String value) {
            addCriterion("SEC_BANK =", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankNotEqualTo(String value) {
            addCriterion("SEC_BANK <>", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankGreaterThan(String value) {
            addCriterion("SEC_BANK >", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_BANK >=", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankLessThan(String value) {
            addCriterion("SEC_BANK <", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankLessThanOrEqualTo(String value) {
            addCriterion("SEC_BANK <=", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankLike(String value) {
            addCriterion("SEC_BANK like", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankNotLike(String value) {
            addCriterion("SEC_BANK not like", value, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankIn(List<String> values) {
            addCriterion("SEC_BANK in", values, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankNotIn(List<String> values) {
            addCriterion("SEC_BANK not in", values, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankBetween(String value1, String value2) {
            addCriterion("SEC_BANK between", value1, value2, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecBankNotBetween(String value1, String value2) {
            addCriterion("SEC_BANK not between", value1, value2, "secBank");
            return (Criteria) this;
        }

        public Criteria andSecFaxIsNull() {
            addCriterion("SEC_FAX is null");
            return (Criteria) this;
        }

        public Criteria andSecFaxIsNotNull() {
            addCriterion("SEC_FAX is not null");
            return (Criteria) this;
        }

        public Criteria andSecFaxEqualTo(String value) {
            addCriterion("SEC_FAX =", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxNotEqualTo(String value) {
            addCriterion("SEC_FAX <>", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxGreaterThan(String value) {
            addCriterion("SEC_FAX >", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_FAX >=", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxLessThan(String value) {
            addCriterion("SEC_FAX <", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxLessThanOrEqualTo(String value) {
            addCriterion("SEC_FAX <=", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxLike(String value) {
            addCriterion("SEC_FAX like", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxNotLike(String value) {
            addCriterion("SEC_FAX not like", value, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxIn(List<String> values) {
            addCriterion("SEC_FAX in", values, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxNotIn(List<String> values) {
            addCriterion("SEC_FAX not in", values, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxBetween(String value1, String value2) {
            addCriterion("SEC_FAX between", value1, value2, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecFaxNotBetween(String value1, String value2) {
            addCriterion("SEC_FAX not between", value1, value2, "secFax");
            return (Criteria) this;
        }

        public Criteria andSecBankNameIsNull() {
            addCriterion("SEC_BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSecBankNameIsNotNull() {
            addCriterion("SEC_BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSecBankNameEqualTo(String value) {
            addCriterion("SEC_BANK_NAME =", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameNotEqualTo(String value) {
            addCriterion("SEC_BANK_NAME <>", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameGreaterThan(String value) {
            addCriterion("SEC_BANK_NAME >", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_BANK_NAME >=", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameLessThan(String value) {
            addCriterion("SEC_BANK_NAME <", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameLessThanOrEqualTo(String value) {
            addCriterion("SEC_BANK_NAME <=", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameLike(String value) {
            addCriterion("SEC_BANK_NAME like", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameNotLike(String value) {
            addCriterion("SEC_BANK_NAME not like", value, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameIn(List<String> values) {
            addCriterion("SEC_BANK_NAME in", values, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameNotIn(List<String> values) {
            addCriterion("SEC_BANK_NAME not in", values, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameBetween(String value1, String value2) {
            addCriterion("SEC_BANK_NAME between", value1, value2, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecBankNameNotBetween(String value1, String value2) {
            addCriterion("SEC_BANK_NAME not between", value1, value2, "secBankName");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeIsNull() {
            addCriterion("SEC_POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeIsNotNull() {
            addCriterion("SEC_POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeEqualTo(String value) {
            addCriterion("SEC_POSTCODE =", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeNotEqualTo(String value) {
            addCriterion("SEC_POSTCODE <>", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeGreaterThan(String value) {
            addCriterion("SEC_POSTCODE >", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_POSTCODE >=", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeLessThan(String value) {
            addCriterion("SEC_POSTCODE <", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeLessThanOrEqualTo(String value) {
            addCriterion("SEC_POSTCODE <=", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeLike(String value) {
            addCriterion("SEC_POSTCODE like", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeNotLike(String value) {
            addCriterion("SEC_POSTCODE not like", value, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeIn(List<String> values) {
            addCriterion("SEC_POSTCODE in", values, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeNotIn(List<String> values) {
            addCriterion("SEC_POSTCODE not in", values, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeBetween(String value1, String value2) {
            addCriterion("SEC_POSTCODE between", value1, value2, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andSecPostcodeNotBetween(String value1, String value2) {
            addCriterion("SEC_POSTCODE not between", value1, value2, "secPostcode");
            return (Criteria) this;
        }

        public Criteria andBailAccountIsNull() {
            addCriterion("BAIL_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBailAccountIsNotNull() {
            addCriterion("BAIL_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBailAccountEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT =", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT <>", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountGreaterThan(String value) {
            addCriterion("BAIL_ACCOUNT >", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT >=", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountLessThan(String value) {
            addCriterion("BAIL_ACCOUNT <", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT <=", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountLike(String value) {
            addCriterion("BAIL_ACCOUNT like", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotLike(String value) {
            addCriterion("BAIL_ACCOUNT not like", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountIn(List<String> values) {
            addCriterion("BAIL_ACCOUNT in", values, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotIn(List<String> values) {
            addCriterion("BAIL_ACCOUNT not in", values, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNT between", value1, value2, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNT not between", value1, value2, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAmountIsNull() {
            addCriterion("BAIL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBailAmountIsNotNull() {
            addCriterion("BAIL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBailAmountEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT =", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <>", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountGreaterThan(BigDecimal value) {
            addCriterion("BAIL_AMOUNT >", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT >=", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountLessThan(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <=", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMOUNT in", values, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMOUNT not in", values, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMOUNT between", value1, value2, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMOUNT not between", value1, value2, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailRateIsNull() {
            addCriterion("BAIL_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBailRateIsNotNull() {
            addCriterion("BAIL_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBailRateEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE =", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE <>", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateGreaterThan(BigDecimal value) {
            addCriterion("BAIL_RATE >", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE >=", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateLessThan(BigDecimal value) {
            addCriterion("BAIL_RATE <", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE <=", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateIn(List<BigDecimal> values) {
            addCriterion("BAIL_RATE in", values, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_RATE not in", values, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RATE between", value1, value2, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RATE not between", value1, value2, "bailRate");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIsNull() {
            addCriterion("TRANSPORT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIsNotNull() {
            addCriterion("TRANSPORT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeEqualTo(String value) {
            addCriterion("TRANSPORT_TYPE =", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotEqualTo(String value) {
            addCriterion("TRANSPORT_TYPE <>", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeGreaterThan(String value) {
            addCriterion("TRANSPORT_TYPE >", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSPORT_TYPE >=", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLessThan(String value) {
            addCriterion("TRANSPORT_TYPE <", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLessThanOrEqualTo(String value) {
            addCriterion("TRANSPORT_TYPE <=", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLike(String value) {
            addCriterion("TRANSPORT_TYPE like", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotLike(String value) {
            addCriterion("TRANSPORT_TYPE not like", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIn(List<String> values) {
            addCriterion("TRANSPORT_TYPE in", values, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotIn(List<String> values) {
            addCriterion("TRANSPORT_TYPE not in", values, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeBetween(String value1, String value2) {
            addCriterion("TRANSPORT_TYPE between", value1, value2, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotBetween(String value1, String value2) {
            addCriterion("TRANSPORT_TYPE not between", value1, value2, "transportType");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressIsNull() {
            addCriterion("EFFECTIVE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressIsNotNull() {
            addCriterion("EFFECTIVE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressEqualTo(String value) {
            addCriterion("EFFECTIVE_ADDRESS =", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressNotEqualTo(String value) {
            addCriterion("EFFECTIVE_ADDRESS <>", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressGreaterThan(String value) {
            addCriterion("EFFECTIVE_ADDRESS >", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECTIVE_ADDRESS >=", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressLessThan(String value) {
            addCriterion("EFFECTIVE_ADDRESS <", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressLessThanOrEqualTo(String value) {
            addCriterion("EFFECTIVE_ADDRESS <=", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressLike(String value) {
            addCriterion("EFFECTIVE_ADDRESS like", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressNotLike(String value) {
            addCriterion("EFFECTIVE_ADDRESS not like", value, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressIn(List<String> values) {
            addCriterion("EFFECTIVE_ADDRESS in", values, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressNotIn(List<String> values) {
            addCriterion("EFFECTIVE_ADDRESS not in", values, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressBetween(String value1, String value2) {
            addCriterion("EFFECTIVE_ADDRESS between", value1, value2, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddressNotBetween(String value1, String value2) {
            addCriterion("EFFECTIVE_ADDRESS not between", value1, value2, "effectiveAddress");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIsNull() {
            addCriterion("COST_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIsNotNull() {
            addCriterion("COST_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andCostMoneyEqualTo(BigDecimal value) {
            addCriterion("COST_MONEY =", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotEqualTo(BigDecimal value) {
            addCriterion("COST_MONEY <>", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyGreaterThan(BigDecimal value) {
            addCriterion("COST_MONEY >", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_MONEY >=", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyLessThan(BigDecimal value) {
            addCriterion("COST_MONEY <", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_MONEY <=", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIn(List<BigDecimal> values) {
            addCriterion("COST_MONEY in", values, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotIn(List<BigDecimal> values) {
            addCriterion("COST_MONEY not in", values, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_MONEY between", value1, value2, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_MONEY not between", value1, value2, "costMoney");
            return (Criteria) this;
        }

        public Criteria andGuattypeIsNull() {
            addCriterion("GUATTYPE is null");
            return (Criteria) this;
        }

        public Criteria andGuattypeIsNotNull() {
            addCriterion("GUATTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andGuattypeEqualTo(String value) {
            addCriterion("GUATTYPE =", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeNotEqualTo(String value) {
            addCriterion("GUATTYPE <>", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeGreaterThan(String value) {
            addCriterion("GUATTYPE >", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeGreaterThanOrEqualTo(String value) {
            addCriterion("GUATTYPE >=", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeLessThan(String value) {
            addCriterion("GUATTYPE <", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeLessThanOrEqualTo(String value) {
            addCriterion("GUATTYPE <=", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeLike(String value) {
            addCriterion("GUATTYPE like", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeNotLike(String value) {
            addCriterion("GUATTYPE not like", value, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeIn(List<String> values) {
            addCriterion("GUATTYPE in", values, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeNotIn(List<String> values) {
            addCriterion("GUATTYPE not in", values, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeBetween(String value1, String value2) {
            addCriterion("GUATTYPE between", value1, value2, "guattype");
            return (Criteria) this;
        }

        public Criteria andGuattypeNotBetween(String value1, String value2) {
            addCriterion("GUATTYPE not between", value1, value2, "guattype");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNull() {
            addCriterion("TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNotNull() {
            addCriterion("TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andTlrnoEqualTo(String value) {
            addCriterion("TLRNO =", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotEqualTo(String value) {
            addCriterion("TLRNO <>", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThan(String value) {
            addCriterion("TLRNO >", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("TLRNO >=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThan(String value) {
            addCriterion("TLRNO <", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThanOrEqualTo(String value) {
            addCriterion("TLRNO <=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLike(String value) {
            addCriterion("TLRNO like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotLike(String value) {
            addCriterion("TLRNO not like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoIn(List<String> values) {
            addCriterion("TLRNO in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotIn(List<String> values) {
            addCriterion("TLRNO not in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoBetween(String value1, String value2) {
            addCriterion("TLRNO between", value1, value2, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotBetween(String value1, String value2) {
            addCriterion("TLRNO not between", value1, value2, "tlrno");
            return (Criteria) this;
        }

        public Criteria andFirNameIsNull() {
            addCriterion("FIR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFirNameIsNotNull() {
            addCriterion("FIR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFirNameEqualTo(String value) {
            addCriterion("FIR_NAME =", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameNotEqualTo(String value) {
            addCriterion("FIR_NAME <>", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameGreaterThan(String value) {
            addCriterion("FIR_NAME >", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameGreaterThanOrEqualTo(String value) {
            addCriterion("FIR_NAME >=", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameLessThan(String value) {
            addCriterion("FIR_NAME <", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameLessThanOrEqualTo(String value) {
            addCriterion("FIR_NAME <=", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameLike(String value) {
            addCriterion("FIR_NAME like", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameNotLike(String value) {
            addCriterion("FIR_NAME not like", value, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameIn(List<String> values) {
            addCriterion("FIR_NAME in", values, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameNotIn(List<String> values) {
            addCriterion("FIR_NAME not in", values, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameBetween(String value1, String value2) {
            addCriterion("FIR_NAME between", value1, value2, "firName");
            return (Criteria) this;
        }

        public Criteria andFirNameNotBetween(String value1, String value2) {
            addCriterion("FIR_NAME not between", value1, value2, "firName");
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

        public Criteria andIndustryOneIsNull() {
            addCriterion("INDUSTRY_ONE is null");
            return (Criteria) this;
        }

        public Criteria andIndustryOneIsNotNull() {
            addCriterion("INDUSTRY_ONE is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryOneEqualTo(String value) {
            addCriterion("INDUSTRY_ONE =", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotEqualTo(String value) {
            addCriterion("INDUSTRY_ONE <>", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneGreaterThan(String value) {
            addCriterion("INDUSTRY_ONE >", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_ONE >=", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneLessThan(String value) {
            addCriterion("INDUSTRY_ONE <", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_ONE <=", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneLike(String value) {
            addCriterion("INDUSTRY_ONE like", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotLike(String value) {
            addCriterion("INDUSTRY_ONE not like", value, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneIn(List<String> values) {
            addCriterion("INDUSTRY_ONE in", values, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotIn(List<String> values) {
            addCriterion("INDUSTRY_ONE not in", values, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneBetween(String value1, String value2) {
            addCriterion("INDUSTRY_ONE between", value1, value2, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryOneNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_ONE not between", value1, value2, "industryOne");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoIsNull() {
            addCriterion("INDUSTRY_TWO is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoIsNotNull() {
            addCriterion("INDUSTRY_TWO is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoEqualTo(String value) {
            addCriterion("INDUSTRY_TWO =", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotEqualTo(String value) {
            addCriterion("INDUSTRY_TWO <>", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoGreaterThan(String value) {
            addCriterion("INDUSTRY_TWO >", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TWO >=", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoLessThan(String value) {
            addCriterion("INDUSTRY_TWO <", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TWO <=", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoLike(String value) {
            addCriterion("INDUSTRY_TWO like", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotLike(String value) {
            addCriterion("INDUSTRY_TWO not like", value, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoIn(List<String> values) {
            addCriterion("INDUSTRY_TWO in", values, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotIn(List<String> values) {
            addCriterion("INDUSTRY_TWO not in", values, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TWO between", value1, value2, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andIndustryTwoNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TWO not between", value1, value2, "industryTwo");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("EXT1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT1 not between", value1, value2, "ext1");
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

        public Criteria andSupplyChainPdIdIsNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIsNotNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID =", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <>", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID not like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID not in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID not between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoIsNull() {
            addCriterion("EBANK_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoIsNotNull() {
            addCriterion("EBANK_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoEqualTo(String value) {
            addCriterion("EBANK_APPNO =", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotEqualTo(String value) {
            addCriterion("EBANK_APPNO <>", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoGreaterThan(String value) {
            addCriterion("EBANK_APPNO >", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("EBANK_APPNO >=", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoLessThan(String value) {
            addCriterion("EBANK_APPNO <", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoLessThanOrEqualTo(String value) {
            addCriterion("EBANK_APPNO <=", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoLike(String value) {
            addCriterion("EBANK_APPNO like", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotLike(String value) {
            addCriterion("EBANK_APPNO not like", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoIn(List<String> values) {
            addCriterion("EBANK_APPNO in", values, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotIn(List<String> values) {
            addCriterion("EBANK_APPNO not in", values, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoBetween(String value1, String value2) {
            addCriterion("EBANK_APPNO between", value1, value2, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotBetween(String value1, String value2) {
            addCriterion("EBANK_APPNO not between", value1, value2, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andChannelFlagIsNull() {
            addCriterion("CHANNEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andChannelFlagIsNotNull() {
            addCriterion("CHANNEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFlagEqualTo(String value) {
            addCriterion("CHANNEL_FLAG =", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotEqualTo(String value) {
            addCriterion("CHANNEL_FLAG <>", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagGreaterThan(String value) {
            addCriterion("CHANNEL_FLAG >", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_FLAG >=", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagLessThan(String value) {
            addCriterion("CHANNEL_FLAG <", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_FLAG <=", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagLike(String value) {
            addCriterion("CHANNEL_FLAG like", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotLike(String value) {
            addCriterion("CHANNEL_FLAG not like", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagIn(List<String> values) {
            addCriterion("CHANNEL_FLAG in", values, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotIn(List<String> values) {
            addCriterion("CHANNEL_FLAG not in", values, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagBetween(String value1, String value2) {
            addCriterion("CHANNEL_FLAG between", value1, value2, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_FLAG not between", value1, value2, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtIsNull() {
            addCriterion("ACCU_DELI_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtIsNotNull() {
            addCriterion("ACCU_DELI_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtEqualTo(BigDecimal value) {
            addCriterion("ACCU_DELI_AMT =", value, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtNotEqualTo(BigDecimal value) {
            addCriterion("ACCU_DELI_AMT <>", value, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtGreaterThan(BigDecimal value) {
            addCriterion("ACCU_DELI_AMT >", value, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCU_DELI_AMT >=", value, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtLessThan(BigDecimal value) {
            addCriterion("ACCU_DELI_AMT <", value, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCU_DELI_AMT <=", value, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtIn(List<BigDecimal> values) {
            addCriterion("ACCU_DELI_AMT in", values, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtNotIn(List<BigDecimal> values) {
            addCriterion("ACCU_DELI_AMT not in", values, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCU_DELI_AMT between", value1, value2, "accuDeliAmt");
            return (Criteria) this;
        }

        public Criteria andAccuDeliAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCU_DELI_AMT not between", value1, value2, "accuDeliAmt");
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