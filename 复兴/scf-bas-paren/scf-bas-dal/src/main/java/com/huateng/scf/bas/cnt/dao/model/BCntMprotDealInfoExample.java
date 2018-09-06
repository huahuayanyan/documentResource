package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntMprotDealInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntMprotDealInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntMprotDealInfoExample(BCntMprotDealInfoExample example) {
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

        public Criteria andFirstBailRatioIsNull() {
            addCriterion("FIRST_BAIL_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIsNotNull() {
            addCriterion("FIRST_BAIL_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO =", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <>", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioGreaterThan(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO >", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO >=", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioLessThan(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <=", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIn(List<BigDecimal> values) {
            addCriterion("FIRST_BAIL_RATIO in", values, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotIn(List<BigDecimal> values) {
            addCriterion("FIRST_BAIL_RATIO not in", values, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIRST_BAIL_RATIO between", value1, value2, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIRST_BAIL_RATIO not between", value1, value2, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeIsNull() {
            addCriterion("FIRST_BAIL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeIsNotNull() {
            addCriterion("FIRST_BAIL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE =", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE <>", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeGreaterThan(String value) {
            addCriterion("FIRST_BAIL_TYPE >", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE >=", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeLessThan(String value) {
            addCriterion("FIRST_BAIL_TYPE <", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeLessThanOrEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE <=", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeLike(String value) {
            addCriterion("FIRST_BAIL_TYPE like", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotLike(String value) {
            addCriterion("FIRST_BAIL_TYPE not like", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeIn(List<String> values) {
            addCriterion("FIRST_BAIL_TYPE in", values, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotIn(List<String> values) {
            addCriterion("FIRST_BAIL_TYPE not in", values, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeBetween(String value1, String value2) {
            addCriterion("FIRST_BAIL_TYPE between", value1, value2, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotBetween(String value1, String value2) {
            addCriterion("FIRST_BAIL_TYPE not between", value1, value2, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andLoanWayIsNull() {
            addCriterion("LOAN_WAY is null");
            return (Criteria) this;
        }

        public Criteria andLoanWayIsNotNull() {
            addCriterion("LOAN_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andLoanWayEqualTo(String value) {
            addCriterion("LOAN_WAY =", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotEqualTo(String value) {
            addCriterion("LOAN_WAY <>", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayGreaterThan(String value) {
            addCriterion("LOAN_WAY >", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_WAY >=", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLessThan(String value) {
            addCriterion("LOAN_WAY <", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLessThanOrEqualTo(String value) {
            addCriterion("LOAN_WAY <=", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLike(String value) {
            addCriterion("LOAN_WAY like", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotLike(String value) {
            addCriterion("LOAN_WAY not like", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayIn(List<String> values) {
            addCriterion("LOAN_WAY in", values, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotIn(List<String> values) {
            addCriterion("LOAN_WAY not in", values, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayBetween(String value1, String value2) {
            addCriterion("LOAN_WAY between", value1, value2, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotBetween(String value1, String value2) {
            addCriterion("LOAN_WAY not between", value1, value2, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIsNull() {
            addCriterion("LOAN_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIsNotNull() {
            addCriterion("LOAN_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDaysEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS =", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS <>", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysGreaterThan(BigDecimal value) {
            addCriterion("LOAN_DAYS >", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS >=", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysLessThan(BigDecimal value) {
            addCriterion("LOAN_DAYS <", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS <=", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIn(List<BigDecimal> values) {
            addCriterion("LOAN_DAYS in", values, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_DAYS not in", values, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_DAYS between", value1, value2, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_DAYS not between", value1, value2, "loanDays");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeIsNull() {
            addCriterion("ARRIVED_MANAGE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeIsNotNull() {
            addCriterion("ARRIVED_MANAGE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE =", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE <>", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeGreaterThan(String value) {
            addCriterion("ARRIVED_MANAGE_MODE >", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeGreaterThanOrEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE >=", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeLessThan(String value) {
            addCriterion("ARRIVED_MANAGE_MODE <", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeLessThanOrEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE <=", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeLike(String value) {
            addCriterion("ARRIVED_MANAGE_MODE like", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotLike(String value) {
            addCriterion("ARRIVED_MANAGE_MODE not like", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeIn(List<String> values) {
            addCriterion("ARRIVED_MANAGE_MODE in", values, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotIn(List<String> values) {
            addCriterion("ARRIVED_MANAGE_MODE not in", values, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeBetween(String value1, String value2) {
            addCriterion("ARRIVED_MANAGE_MODE between", value1, value2, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotBetween(String value1, String value2) {
            addCriterion("ARRIVED_MANAGE_MODE not between", value1, value2, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andGoodsNmIsNull() {
            addCriterion("GOODS_NM is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNmIsNotNull() {
            addCriterion("GOODS_NM is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNmEqualTo(String value) {
            addCriterion("GOODS_NM =", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmNotEqualTo(String value) {
            addCriterion("GOODS_NM <>", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmGreaterThan(String value) {
            addCriterion("GOODS_NM >", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_NM >=", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmLessThan(String value) {
            addCriterion("GOODS_NM <", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmLessThanOrEqualTo(String value) {
            addCriterion("GOODS_NM <=", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmLike(String value) {
            addCriterion("GOODS_NM like", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmNotLike(String value) {
            addCriterion("GOODS_NM not like", value, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmIn(List<String> values) {
            addCriterion("GOODS_NM in", values, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmNotIn(List<String> values) {
            addCriterion("GOODS_NM not in", values, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmBetween(String value1, String value2) {
            addCriterion("GOODS_NM between", value1, value2, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andGoodsNmNotBetween(String value1, String value2) {
            addCriterion("GOODS_NM not between", value1, value2, "goodsNm");
            return (Criteria) this;
        }

        public Criteria andTakeModeIsNull() {
            addCriterion("TAKE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andTakeModeIsNotNull() {
            addCriterion("TAKE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andTakeModeEqualTo(String value) {
            addCriterion("TAKE_MODE =", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeNotEqualTo(String value) {
            addCriterion("TAKE_MODE <>", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeGreaterThan(String value) {
            addCriterion("TAKE_MODE >", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeGreaterThanOrEqualTo(String value) {
            addCriterion("TAKE_MODE >=", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeLessThan(String value) {
            addCriterion("TAKE_MODE <", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeLessThanOrEqualTo(String value) {
            addCriterion("TAKE_MODE <=", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeLike(String value) {
            addCriterion("TAKE_MODE like", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeNotLike(String value) {
            addCriterion("TAKE_MODE not like", value, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeIn(List<String> values) {
            addCriterion("TAKE_MODE in", values, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeNotIn(List<String> values) {
            addCriterion("TAKE_MODE not in", values, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeBetween(String value1, String value2) {
            addCriterion("TAKE_MODE between", value1, value2, "takeMode");
            return (Criteria) this;
        }

        public Criteria andTakeModeNotBetween(String value1, String value2) {
            addCriterion("TAKE_MODE not between", value1, value2, "takeMode");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyIsNull() {
            addCriterion("CORE_CUST_DUTY is null");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyIsNotNull() {
            addCriterion("CORE_CUST_DUTY is not null");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyEqualTo(String value) {
            addCriterion("CORE_CUST_DUTY =", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyNotEqualTo(String value) {
            addCriterion("CORE_CUST_DUTY <>", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyGreaterThan(String value) {
            addCriterion("CORE_CUST_DUTY >", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_CUST_DUTY >=", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyLessThan(String value) {
            addCriterion("CORE_CUST_DUTY <", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyLessThanOrEqualTo(String value) {
            addCriterion("CORE_CUST_DUTY <=", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyLike(String value) {
            addCriterion("CORE_CUST_DUTY like", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyNotLike(String value) {
            addCriterion("CORE_CUST_DUTY not like", value, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyIn(List<String> values) {
            addCriterion("CORE_CUST_DUTY in", values, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyNotIn(List<String> values) {
            addCriterion("CORE_CUST_DUTY not in", values, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyBetween(String value1, String value2) {
            addCriterion("CORE_CUST_DUTY between", value1, value2, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andCoreCustDutyNotBetween(String value1, String value2) {
            addCriterion("CORE_CUST_DUTY not between", value1, value2, "coreCustDuty");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeIsNull() {
            addCriterion("MORTGAGE_MANAGE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeIsNotNull() {
            addCriterion("MORTGAGE_MANAGE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeEqualTo(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE =", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeNotEqualTo(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE <>", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeGreaterThan(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE >", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE >=", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeLessThan(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE <", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE <=", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeLike(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE like", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeNotLike(String value) {
            addCriterion("MORTGAGE_MANAGE_MODE not like", value, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeIn(List<String> values) {
            addCriterion("MORTGAGE_MANAGE_MODE in", values, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeNotIn(List<String> values) {
            addCriterion("MORTGAGE_MANAGE_MODE not in", values, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeBetween(String value1, String value2) {
            addCriterion("MORTGAGE_MANAGE_MODE between", value1, value2, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andMortgageManageModeNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_MANAGE_MODE not between", value1, value2, "mortgageManageMode");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceIsNull() {
            addCriterion("IS_INSURANCE is null");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceIsNotNull() {
            addCriterion("IS_INSURANCE is not null");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceEqualTo(String value) {
            addCriterion("IS_INSURANCE =", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceNotEqualTo(String value) {
            addCriterion("IS_INSURANCE <>", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceGreaterThan(String value) {
            addCriterion("IS_INSURANCE >", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("IS_INSURANCE >=", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceLessThan(String value) {
            addCriterion("IS_INSURANCE <", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceLessThanOrEqualTo(String value) {
            addCriterion("IS_INSURANCE <=", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceLike(String value) {
            addCriterion("IS_INSURANCE like", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceNotLike(String value) {
            addCriterion("IS_INSURANCE not like", value, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceIn(List<String> values) {
            addCriterion("IS_INSURANCE in", values, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceNotIn(List<String> values) {
            addCriterion("IS_INSURANCE not in", values, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceBetween(String value1, String value2) {
            addCriterion("IS_INSURANCE between", value1, value2, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andIsInsuranceNotBetween(String value1, String value2) {
            addCriterion("IS_INSURANCE not between", value1, value2, "isInsurance");
            return (Criteria) this;
        }

        public Criteria andFouAddressIsNull() {
            addCriterion("FOU_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andFouAddressIsNotNull() {
            addCriterion("FOU_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andFouAddressEqualTo(String value) {
            addCriterion("FOU_ADDRESS =", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressNotEqualTo(String value) {
            addCriterion("FOU_ADDRESS <>", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressGreaterThan(String value) {
            addCriterion("FOU_ADDRESS >", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressGreaterThanOrEqualTo(String value) {
            addCriterion("FOU_ADDRESS >=", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressLessThan(String value) {
            addCriterion("FOU_ADDRESS <", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressLessThanOrEqualTo(String value) {
            addCriterion("FOU_ADDRESS <=", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressLike(String value) {
            addCriterion("FOU_ADDRESS like", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressNotLike(String value) {
            addCriterion("FOU_ADDRESS not like", value, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressIn(List<String> values) {
            addCriterion("FOU_ADDRESS in", values, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressNotIn(List<String> values) {
            addCriterion("FOU_ADDRESS not in", values, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressBetween(String value1, String value2) {
            addCriterion("FOU_ADDRESS between", value1, value2, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andFouAddressNotBetween(String value1, String value2) {
            addCriterion("FOU_ADDRESS not between", value1, value2, "fouAddress");
            return (Criteria) this;
        }

        public Criteria andTriConventionsIsNull() {
            addCriterion("TRI_CONVENTIONS is null");
            return (Criteria) this;
        }

        public Criteria andTriConventionsIsNotNull() {
            addCriterion("TRI_CONVENTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andTriConventionsEqualTo(String value) {
            addCriterion("TRI_CONVENTIONS =", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsNotEqualTo(String value) {
            addCriterion("TRI_CONVENTIONS <>", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsGreaterThan(String value) {
            addCriterion("TRI_CONVENTIONS >", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsGreaterThanOrEqualTo(String value) {
            addCriterion("TRI_CONVENTIONS >=", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsLessThan(String value) {
            addCriterion("TRI_CONVENTIONS <", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsLessThanOrEqualTo(String value) {
            addCriterion("TRI_CONVENTIONS <=", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsLike(String value) {
            addCriterion("TRI_CONVENTIONS like", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsNotLike(String value) {
            addCriterion("TRI_CONVENTIONS not like", value, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsIn(List<String> values) {
            addCriterion("TRI_CONVENTIONS in", values, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsNotIn(List<String> values) {
            addCriterion("TRI_CONVENTIONS not in", values, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsBetween(String value1, String value2) {
            addCriterion("TRI_CONVENTIONS between", value1, value2, "triConventions");
            return (Criteria) this;
        }

        public Criteria andTriConventionsNotBetween(String value1, String value2) {
            addCriterion("TRI_CONVENTIONS not between", value1, value2, "triConventions");
            return (Criteria) this;
        }

        public Criteria andCondigneeIsNull() {
            addCriterion("CONDIGNEE is null");
            return (Criteria) this;
        }

        public Criteria andCondigneeIsNotNull() {
            addCriterion("CONDIGNEE is not null");
            return (Criteria) this;
        }

        public Criteria andCondigneeEqualTo(String value) {
            addCriterion("CONDIGNEE =", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeNotEqualTo(String value) {
            addCriterion("CONDIGNEE <>", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeGreaterThan(String value) {
            addCriterion("CONDIGNEE >", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeGreaterThanOrEqualTo(String value) {
            addCriterion("CONDIGNEE >=", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeLessThan(String value) {
            addCriterion("CONDIGNEE <", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeLessThanOrEqualTo(String value) {
            addCriterion("CONDIGNEE <=", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeLike(String value) {
            addCriterion("CONDIGNEE like", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeNotLike(String value) {
            addCriterion("CONDIGNEE not like", value, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeIn(List<String> values) {
            addCriterion("CONDIGNEE in", values, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeNotIn(List<String> values) {
            addCriterion("CONDIGNEE not in", values, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeBetween(String value1, String value2) {
            addCriterion("CONDIGNEE between", value1, value2, "condignee");
            return (Criteria) this;
        }

        public Criteria andCondigneeNotBetween(String value1, String value2) {
            addCriterion("CONDIGNEE not between", value1, value2, "condignee");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeIsNull() {
            addCriterion("TRASPORTATION_MODE is null");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeIsNotNull() {
            addCriterion("TRASPORTATION_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeEqualTo(String value) {
            addCriterion("TRASPORTATION_MODE =", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeNotEqualTo(String value) {
            addCriterion("TRASPORTATION_MODE <>", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeGreaterThan(String value) {
            addCriterion("TRASPORTATION_MODE >", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeGreaterThanOrEqualTo(String value) {
            addCriterion("TRASPORTATION_MODE >=", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeLessThan(String value) {
            addCriterion("TRASPORTATION_MODE <", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeLessThanOrEqualTo(String value) {
            addCriterion("TRASPORTATION_MODE <=", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeLike(String value) {
            addCriterion("TRASPORTATION_MODE like", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeNotLike(String value) {
            addCriterion("TRASPORTATION_MODE not like", value, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeIn(List<String> values) {
            addCriterion("TRASPORTATION_MODE in", values, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeNotIn(List<String> values) {
            addCriterion("TRASPORTATION_MODE not in", values, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeBetween(String value1, String value2) {
            addCriterion("TRASPORTATION_MODE between", value1, value2, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andTrasportationModeNotBetween(String value1, String value2) {
            addCriterion("TRASPORTATION_MODE not between", value1, value2, "trasportationMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsIsNull() {
            addCriterion("DELIVERY_POINTS is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsIsNotNull() {
            addCriterion("DELIVERY_POINTS is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsEqualTo(String value) {
            addCriterion("DELIVERY_POINTS =", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsNotEqualTo(String value) {
            addCriterion("DELIVERY_POINTS <>", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsGreaterThan(String value) {
            addCriterion("DELIVERY_POINTS >", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_POINTS >=", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsLessThan(String value) {
            addCriterion("DELIVERY_POINTS <", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_POINTS <=", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsLike(String value) {
            addCriterion("DELIVERY_POINTS like", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsNotLike(String value) {
            addCriterion("DELIVERY_POINTS not like", value, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsIn(List<String> values) {
            addCriterion("DELIVERY_POINTS in", values, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsNotIn(List<String> values) {
            addCriterion("DELIVERY_POINTS not in", values, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsBetween(String value1, String value2) {
            addCriterion("DELIVERY_POINTS between", value1, value2, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDeliveryPointsNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_POINTS not between", value1, value2, "deliveryPoints");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("DESTINATION is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("DESTINATION is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("DESTINATION =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("DESTINATION <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("DESTINATION >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("DESTINATION >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("DESTINATION <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("DESTINATION <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("DESTINATION like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("DESTINATION not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("DESTINATION in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("DESTINATION not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("DESTINATION between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("DESTINATION not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountIsNull() {
            addCriterion("DELIVERY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountIsNotNull() {
            addCriterion("DELIVERY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMOUNT =", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountNotEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMOUNT <>", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountGreaterThan(BigDecimal value) {
            addCriterion("DELIVERY_AMOUNT >", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMOUNT >=", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountLessThan(BigDecimal value) {
            addCriterion("DELIVERY_AMOUNT <", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMOUNT <=", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_AMOUNT in", values, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountNotIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_AMOUNT not in", values, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_AMOUNT between", value1, value2, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_AMOUNT not between", value1, value2, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andAmountInIsNull() {
            addCriterion("AMOUNT_IN is null");
            return (Criteria) this;
        }

        public Criteria andAmountInIsNotNull() {
            addCriterion("AMOUNT_IN is not null");
            return (Criteria) this;
        }

        public Criteria andAmountInEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN =", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN <>", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_IN >", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN >=", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInLessThan(BigDecimal value) {
            addCriterion("AMOUNT_IN <", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN <=", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_IN in", values, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_IN not in", values, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_IN between", value1, value2, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_IN not between", value1, value2, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountOutIsNull() {
            addCriterion("AMOUNT_OUT is null");
            return (Criteria) this;
        }

        public Criteria andAmountOutIsNotNull() {
            addCriterion("AMOUNT_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountOutEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT =", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT <>", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_OUT >", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT >=", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutLessThan(BigDecimal value) {
            addCriterion("AMOUNT_OUT <", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT <=", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_OUT in", values, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_OUT not in", values, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_OUT between", value1, value2, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_OUT not between", value1, value2, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutIsNull() {
            addCriterion("AMOUNT_UP_OUT is null");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutIsNotNull() {
            addCriterion("AMOUNT_UP_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT =", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT <>", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT >", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT >=", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutLessThan(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT <", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT <=", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_UP_OUT in", values, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_UP_OUT not in", values, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_UP_OUT between", value1, value2, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_UP_OUT not between", value1, value2, "amountUpOut");
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

        public Criteria andPledgeAmtIsNull() {
            addCriterion("PLEDGE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtIsNotNull() {
            addCriterion("PLEDGE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtEqualTo(BigDecimal value) {
            addCriterion("PLEDGE_AMT =", value, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtNotEqualTo(BigDecimal value) {
            addCriterion("PLEDGE_AMT <>", value, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtGreaterThan(BigDecimal value) {
            addCriterion("PLEDGE_AMT >", value, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PLEDGE_AMT >=", value, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtLessThan(BigDecimal value) {
            addCriterion("PLEDGE_AMT <", value, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PLEDGE_AMT <=", value, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtIn(List<BigDecimal> values) {
            addCriterion("PLEDGE_AMT in", values, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtNotIn(List<BigDecimal> values) {
            addCriterion("PLEDGE_AMT not in", values, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLEDGE_AMT between", value1, value2, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andPledgeAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLEDGE_AMT not between", value1, value2, "pledgeAmt");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeIsNull() {
            addCriterion("DUTY_ASSUME_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeIsNotNull() {
            addCriterion("DUTY_ASSUME_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeEqualTo(String value) {
            addCriterion("DUTY_ASSUME_TYPE =", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeNotEqualTo(String value) {
            addCriterion("DUTY_ASSUME_TYPE <>", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeGreaterThan(String value) {
            addCriterion("DUTY_ASSUME_TYPE >", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DUTY_ASSUME_TYPE >=", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeLessThan(String value) {
            addCriterion("DUTY_ASSUME_TYPE <", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeLessThanOrEqualTo(String value) {
            addCriterion("DUTY_ASSUME_TYPE <=", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeLike(String value) {
            addCriterion("DUTY_ASSUME_TYPE like", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeNotLike(String value) {
            addCriterion("DUTY_ASSUME_TYPE not like", value, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeIn(List<String> values) {
            addCriterion("DUTY_ASSUME_TYPE in", values, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeNotIn(List<String> values) {
            addCriterion("DUTY_ASSUME_TYPE not in", values, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeBetween(String value1, String value2) {
            addCriterion("DUTY_ASSUME_TYPE between", value1, value2, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andDutyAssumeTypeNotBetween(String value1, String value2) {
            addCriterion("DUTY_ASSUME_TYPE not between", value1, value2, "dutyAssumeType");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysIsNull() {
            addCriterion("CONSIGNMENT_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysIsNotNull() {
            addCriterion("CONSIGNMENT_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysEqualTo(Long value) {
            addCriterion("CONSIGNMENT_DAYS =", value, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysNotEqualTo(Long value) {
            addCriterion("CONSIGNMENT_DAYS <>", value, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysGreaterThan(Long value) {
            addCriterion("CONSIGNMENT_DAYS >", value, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysGreaterThanOrEqualTo(Long value) {
            addCriterion("CONSIGNMENT_DAYS >=", value, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysLessThan(Long value) {
            addCriterion("CONSIGNMENT_DAYS <", value, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysLessThanOrEqualTo(Long value) {
            addCriterion("CONSIGNMENT_DAYS <=", value, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysIn(List<Long> values) {
            addCriterion("CONSIGNMENT_DAYS in", values, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysNotIn(List<Long> values) {
            addCriterion("CONSIGNMENT_DAYS not in", values, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysBetween(Long value1, Long value2) {
            addCriterion("CONSIGNMENT_DAYS between", value1, value2, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andConsignmentDaysNotBetween(Long value1, Long value2) {
            addCriterion("CONSIGNMENT_DAYS not between", value1, value2, "consignmentDays");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameIsNull() {
            addCriterion("OTHER_CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameIsNotNull() {
            addCriterion("OTHER_CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameEqualTo(String value) {
            addCriterion("OTHER_CUST_NAME =", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameNotEqualTo(String value) {
            addCriterion("OTHER_CUST_NAME <>", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameGreaterThan(String value) {
            addCriterion("OTHER_CUST_NAME >", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_CUST_NAME >=", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameLessThan(String value) {
            addCriterion("OTHER_CUST_NAME <", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameLessThanOrEqualTo(String value) {
            addCriterion("OTHER_CUST_NAME <=", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameLike(String value) {
            addCriterion("OTHER_CUST_NAME like", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameNotLike(String value) {
            addCriterion("OTHER_CUST_NAME not like", value, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameIn(List<String> values) {
            addCriterion("OTHER_CUST_NAME in", values, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameNotIn(List<String> values) {
            addCriterion("OTHER_CUST_NAME not in", values, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameBetween(String value1, String value2) {
            addCriterion("OTHER_CUST_NAME between", value1, value2, "otherCustName");
            return (Criteria) this;
        }

        public Criteria andOtherCustNameNotBetween(String value1, String value2) {
            addCriterion("OTHER_CUST_NAME not between", value1, value2, "otherCustName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}