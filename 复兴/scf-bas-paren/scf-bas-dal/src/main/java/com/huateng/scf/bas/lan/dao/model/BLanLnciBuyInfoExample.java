package com.huateng.scf.bas.lan.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLanLnciBuyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BLanLnciBuyInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BLanLnciBuyInfoExample(BLanLnciBuyInfoExample example) {
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

        public Criteria andContAmtIsNull() {
            addCriterion("CONT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andContAmtIsNotNull() {
            addCriterion("CONT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andContAmtEqualTo(BigDecimal value) {
            addCriterion("CONT_AMT =", value, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtNotEqualTo(BigDecimal value) {
            addCriterion("CONT_AMT <>", value, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtGreaterThan(BigDecimal value) {
            addCriterion("CONT_AMT >", value, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_AMT >=", value, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtLessThan(BigDecimal value) {
            addCriterion("CONT_AMT <", value, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_AMT <=", value, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtIn(List<BigDecimal> values) {
            addCriterion("CONT_AMT in", values, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtNotIn(List<BigDecimal> values) {
            addCriterion("CONT_AMT not in", values, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_AMT between", value1, value2, "contAmt");
            return (Criteria) this;
        }

        public Criteria andContAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_AMT not between", value1, value2, "contAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtIsNull() {
            addCriterion("ACCU_LOAN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtIsNotNull() {
            addCriterion("ACCU_LOAN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtEqualTo(BigDecimal value) {
            addCriterion("ACCU_LOAN_AMT =", value, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtNotEqualTo(BigDecimal value) {
            addCriterion("ACCU_LOAN_AMT <>", value, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtGreaterThan(BigDecimal value) {
            addCriterion("ACCU_LOAN_AMT >", value, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCU_LOAN_AMT >=", value, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtLessThan(BigDecimal value) {
            addCriterion("ACCU_LOAN_AMT <", value, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCU_LOAN_AMT <=", value, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtIn(List<BigDecimal> values) {
            addCriterion("ACCU_LOAN_AMT in", values, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtNotIn(List<BigDecimal> values) {
            addCriterion("ACCU_LOAN_AMT not in", values, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCU_LOAN_AMT between", value1, value2, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andAccuLoanAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCU_LOAN_AMT not between", value1, value2, "accuLoanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNull() {
            addCriterion("LOAN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNotNull() {
            addCriterion("LOAN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT =", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT <>", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThan(BigDecimal value) {
            addCriterion("LOAN_AMT >", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT >=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThan(BigDecimal value) {
            addCriterion("LOAN_AMT <", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT <=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMT in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMT not in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMT between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMT not between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}