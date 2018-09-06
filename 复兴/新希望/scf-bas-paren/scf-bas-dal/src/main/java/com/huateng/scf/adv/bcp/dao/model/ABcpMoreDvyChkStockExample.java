package com.huateng.scf.adv.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ABcpMoreDvyChkStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ABcpMoreDvyChkStockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected ABcpMoreDvyChkStockExample(ABcpMoreDvyChkStockExample example) {
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

        public Criteria andUpCustcdIsNull() {
            addCriterion("UP_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andUpCustcdIsNotNull() {
            addCriterion("UP_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andUpCustcdEqualTo(String value) {
            addCriterion("UP_CUSTCD =", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdNotEqualTo(String value) {
            addCriterion("UP_CUSTCD <>", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdGreaterThan(String value) {
            addCriterion("UP_CUSTCD >", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("UP_CUSTCD >=", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdLessThan(String value) {
            addCriterion("UP_CUSTCD <", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdLessThanOrEqualTo(String value) {
            addCriterion("UP_CUSTCD <=", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdLike(String value) {
            addCriterion("UP_CUSTCD like", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdNotLike(String value) {
            addCriterion("UP_CUSTCD not like", value, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdIn(List<String> values) {
            addCriterion("UP_CUSTCD in", values, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdNotIn(List<String> values) {
            addCriterion("UP_CUSTCD not in", values, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdBetween(String value1, String value2) {
            addCriterion("UP_CUSTCD between", value1, value2, "upCustcd");
            return (Criteria) this;
        }

        public Criteria andUpCustcdNotBetween(String value1, String value2) {
            addCriterion("UP_CUSTCD not between", value1, value2, "upCustcd");
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

        public Criteria andCheckBrcodeIsNull() {
            addCriterion("CHECK_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeIsNotNull() {
            addCriterion("CHECK_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeEqualTo(String value) {
            addCriterion("CHECK_BRCODE =", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeNotEqualTo(String value) {
            addCriterion("CHECK_BRCODE <>", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeGreaterThan(String value) {
            addCriterion("CHECK_BRCODE >", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_BRCODE >=", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeLessThan(String value) {
            addCriterion("CHECK_BRCODE <", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_BRCODE <=", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeLike(String value) {
            addCriterion("CHECK_BRCODE like", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeNotLike(String value) {
            addCriterion("CHECK_BRCODE not like", value, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeIn(List<String> values) {
            addCriterion("CHECK_BRCODE in", values, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeNotIn(List<String> values) {
            addCriterion("CHECK_BRCODE not in", values, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeBetween(String value1, String value2) {
            addCriterion("CHECK_BRCODE between", value1, value2, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckBrcodeNotBetween(String value1, String value2) {
            addCriterion("CHECK_BRCODE not between", value1, value2, "checkBrcode");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoIsNull() {
            addCriterion("CHECK_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoIsNotNull() {
            addCriterion("CHECK_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoEqualTo(String value) {
            addCriterion("CHECK_TLRNO =", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoNotEqualTo(String value) {
            addCriterion("CHECK_TLRNO <>", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoGreaterThan(String value) {
            addCriterion("CHECK_TLRNO >", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_TLRNO >=", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoLessThan(String value) {
            addCriterion("CHECK_TLRNO <", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoLessThanOrEqualTo(String value) {
            addCriterion("CHECK_TLRNO <=", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoLike(String value) {
            addCriterion("CHECK_TLRNO like", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoNotLike(String value) {
            addCriterion("CHECK_TLRNO not like", value, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoIn(List<String> values) {
            addCriterion("CHECK_TLRNO in", values, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoNotIn(List<String> values) {
            addCriterion("CHECK_TLRNO not in", values, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoBetween(String value1, String value2) {
            addCriterion("CHECK_TLRNO between", value1, value2, "checkTlrno");
            return (Criteria) this;
        }

        public Criteria andCheckTlrnoNotBetween(String value1, String value2) {
            addCriterion("CHECK_TLRNO not between", value1, value2, "checkTlrno");
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

        public Criteria andReceivedTotAmtIsNull() {
            addCriterion("RECEIVED_TOT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtIsNotNull() {
            addCriterion("RECEIVED_TOT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_TOT_AMT =", value, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_TOT_AMT <>", value, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtGreaterThan(BigDecimal value) {
            addCriterion("RECEIVED_TOT_AMT >", value, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_TOT_AMT >=", value, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtLessThan(BigDecimal value) {
            addCriterion("RECEIVED_TOT_AMT <", value, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_TOT_AMT <=", value, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtIn(List<BigDecimal> values) {
            addCriterion("RECEIVED_TOT_AMT in", values, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVED_TOT_AMT not in", values, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVED_TOT_AMT between", value1, value2, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedTotAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVED_TOT_AMT not between", value1, value2, "receivedTotAmt");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueIsNull() {
            addCriterion("DELIVRIED_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueIsNotNull() {
            addCriterion("DELIVRIED_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueEqualTo(BigDecimal value) {
            addCriterion("DELIVRIED_VALUE =", value, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueNotEqualTo(BigDecimal value) {
            addCriterion("DELIVRIED_VALUE <>", value, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueGreaterThan(BigDecimal value) {
            addCriterion("DELIVRIED_VALUE >", value, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVRIED_VALUE >=", value, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueLessThan(BigDecimal value) {
            addCriterion("DELIVRIED_VALUE <", value, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVRIED_VALUE <=", value, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueIn(List<BigDecimal> values) {
            addCriterion("DELIVRIED_VALUE in", values, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueNotIn(List<BigDecimal> values) {
            addCriterion("DELIVRIED_VALUE not in", values, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVRIED_VALUE between", value1, value2, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andDelivriedValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVRIED_VALUE not between", value1, value2, "delivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueIsNull() {
            addCriterion("NOT_DELIVRIED_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueIsNotNull() {
            addCriterion("NOT_DELIVRIED_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueEqualTo(BigDecimal value) {
            addCriterion("NOT_DELIVRIED_VALUE =", value, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueNotEqualTo(BigDecimal value) {
            addCriterion("NOT_DELIVRIED_VALUE <>", value, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueGreaterThan(BigDecimal value) {
            addCriterion("NOT_DELIVRIED_VALUE >", value, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NOT_DELIVRIED_VALUE >=", value, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueLessThan(BigDecimal value) {
            addCriterion("NOT_DELIVRIED_VALUE <", value, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NOT_DELIVRIED_VALUE <=", value, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueIn(List<BigDecimal> values) {
            addCriterion("NOT_DELIVRIED_VALUE in", values, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueNotIn(List<BigDecimal> values) {
            addCriterion("NOT_DELIVRIED_VALUE not in", values, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NOT_DELIVRIED_VALUE between", value1, value2, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andNotDelivriedValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NOT_DELIVRIED_VALUE not between", value1, value2, "notDelivriedValue");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("CHECK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("CHECK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(String value) {
            addCriterion("CHECK_DATE =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(String value) {
            addCriterion("CHECK_DATE <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(String value) {
            addCriterion("CHECK_DATE >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_DATE >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(String value) {
            addCriterion("CHECK_DATE <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(String value) {
            addCriterion("CHECK_DATE <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLike(String value) {
            addCriterion("CHECK_DATE like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotLike(String value) {
            addCriterion("CHECK_DATE not like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<String> values) {
            addCriterion("CHECK_DATE in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<String> values) {
            addCriterion("CHECK_DATE not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(String value1, String value2) {
            addCriterion("CHECK_DATE between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(String value1, String value2) {
            addCriterion("CHECK_DATE not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIsNull() {
            addCriterion("CHECK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIsNotNull() {
            addCriterion("CHECK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTypeEqualTo(String value) {
            addCriterion("CHECK_TYPE =", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotEqualTo(String value) {
            addCriterion("CHECK_TYPE <>", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeGreaterThan(String value) {
            addCriterion("CHECK_TYPE >", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_TYPE >=", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLessThan(String value) {
            addCriterion("CHECK_TYPE <", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_TYPE <=", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLike(String value) {
            addCriterion("CHECK_TYPE like", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotLike(String value) {
            addCriterion("CHECK_TYPE not like", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIn(List<String> values) {
            addCriterion("CHECK_TYPE in", values, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotIn(List<String> values) {
            addCriterion("CHECK_TYPE not in", values, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeBetween(String value1, String value2) {
            addCriterion("CHECK_TYPE between", value1, value2, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_TYPE not between", value1, value2, "checkType");
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

        public Criteria andCheckConfirmDateIsNull() {
            addCriterion("CHECK_CONFIRM_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateIsNotNull() {
            addCriterion("CHECK_CONFIRM_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateEqualTo(String value) {
            addCriterion("CHECK_CONFIRM_DATE =", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateNotEqualTo(String value) {
            addCriterion("CHECK_CONFIRM_DATE <>", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateGreaterThan(String value) {
            addCriterion("CHECK_CONFIRM_DATE >", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_CONFIRM_DATE >=", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateLessThan(String value) {
            addCriterion("CHECK_CONFIRM_DATE <", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateLessThanOrEqualTo(String value) {
            addCriterion("CHECK_CONFIRM_DATE <=", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateLike(String value) {
            addCriterion("CHECK_CONFIRM_DATE like", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateNotLike(String value) {
            addCriterion("CHECK_CONFIRM_DATE not like", value, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateIn(List<String> values) {
            addCriterion("CHECK_CONFIRM_DATE in", values, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateNotIn(List<String> values) {
            addCriterion("CHECK_CONFIRM_DATE not in", values, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateBetween(String value1, String value2) {
            addCriterion("CHECK_CONFIRM_DATE between", value1, value2, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckConfirmDateNotBetween(String value1, String value2) {
            addCriterion("CHECK_CONFIRM_DATE not between", value1, value2, "checkConfirmDate");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerIsNull() {
            addCriterion("SELLER_CHECKER is null");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerIsNotNull() {
            addCriterion("SELLER_CHECKER is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerEqualTo(String value) {
            addCriterion("SELLER_CHECKER =", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerNotEqualTo(String value) {
            addCriterion("SELLER_CHECKER <>", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerGreaterThan(String value) {
            addCriterion("SELLER_CHECKER >", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_CHECKER >=", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerLessThan(String value) {
            addCriterion("SELLER_CHECKER <", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerLessThanOrEqualTo(String value) {
            addCriterion("SELLER_CHECKER <=", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerLike(String value) {
            addCriterion("SELLER_CHECKER like", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerNotLike(String value) {
            addCriterion("SELLER_CHECKER not like", value, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerIn(List<String> values) {
            addCriterion("SELLER_CHECKER in", values, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerNotIn(List<String> values) {
            addCriterion("SELLER_CHECKER not in", values, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerBetween(String value1, String value2) {
            addCriterion("SELLER_CHECKER between", value1, value2, "sellerChecker");
            return (Criteria) this;
        }

        public Criteria andSellerCheckerNotBetween(String value1, String value2) {
            addCriterion("SELLER_CHECKER not between", value1, value2, "sellerChecker");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}