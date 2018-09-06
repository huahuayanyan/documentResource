package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntMprotCmPriceHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntMprotCmPriceHisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntMprotCmPriceHisExample(BCntMprotCmPriceHisExample example) {
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

        public Criteria andTxdateIsNull() {
            addCriterion("TXDATE is null");
            return (Criteria) this;
        }

        public Criteria andTxdateIsNotNull() {
            addCriterion("TXDATE is not null");
            return (Criteria) this;
        }

        public Criteria andTxdateEqualTo(String value) {
            addCriterion("TXDATE =", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotEqualTo(String value) {
            addCriterion("TXDATE <>", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateGreaterThan(String value) {
            addCriterion("TXDATE >", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateGreaterThanOrEqualTo(String value) {
            addCriterion("TXDATE >=", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLessThan(String value) {
            addCriterion("TXDATE <", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLessThanOrEqualTo(String value) {
            addCriterion("TXDATE <=", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLike(String value) {
            addCriterion("TXDATE like", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotLike(String value) {
            addCriterion("TXDATE not like", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateIn(List<String> values) {
            addCriterion("TXDATE in", values, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotIn(List<String> values) {
            addCriterion("TXDATE not in", values, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateBetween(String value1, String value2) {
            addCriterion("TXDATE between", value1, value2, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotBetween(String value1, String value2) {
            addCriterion("TXDATE not between", value1, value2, "txdate");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNull() {
            addCriterion("LOW_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNotNull() {
            addCriterion("LOW_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE =", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE <>", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThan(BigDecimal value) {
            addCriterion("LOW_PRICE >", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE >=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThan(BigDecimal value) {
            addCriterion("LOW_PRICE <", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE <=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE not in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE not between", value1, value2, "lowPrice");
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

        public Criteria andLowPriceNewIsNull() {
            addCriterion("LOW_PRICE_NEW is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewIsNotNull() {
            addCriterion("LOW_PRICE_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW =", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewNotEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW <>", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewGreaterThan(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW >", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW >=", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewLessThan(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW <", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW <=", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE_NEW in", values, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewNotIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE_NEW not in", values, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE_NEW between", value1, value2, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE_NEW not between", value1, value2, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIsNull() {
            addCriterion("SLAVE_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIsNotNull() {
            addCriterion("SLAVE_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoEqualTo(String value) {
            addCriterion("SLAVE_CONTNO =", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotEqualTo(String value) {
            addCriterion("SLAVE_CONTNO <>", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoGreaterThan(String value) {
            addCriterion("SLAVE_CONTNO >", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoGreaterThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTNO >=", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLessThan(String value) {
            addCriterion("SLAVE_CONTNO <", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLessThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTNO <=", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLike(String value) {
            addCriterion("SLAVE_CONTNO like", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotLike(String value) {
            addCriterion("SLAVE_CONTNO not like", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIn(List<String> values) {
            addCriterion("SLAVE_CONTNO in", values, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotIn(List<String> values) {
            addCriterion("SLAVE_CONTNO not in", values, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTNO between", value1, value2, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTNO not between", value1, value2, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdIsNull() {
            addCriterion("RECORD_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdIsNotNull() {
            addCriterion("RECORD_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdEqualTo(String value) {
            addCriterion("RECORD_TLRCD =", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdNotEqualTo(String value) {
            addCriterion("RECORD_TLRCD <>", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdGreaterThan(String value) {
            addCriterion("RECORD_TLRCD >", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_TLRCD >=", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdLessThan(String value) {
            addCriterion("RECORD_TLRCD <", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdLessThanOrEqualTo(String value) {
            addCriterion("RECORD_TLRCD <=", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdLike(String value) {
            addCriterion("RECORD_TLRCD like", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdNotLike(String value) {
            addCriterion("RECORD_TLRCD not like", value, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdIn(List<String> values) {
            addCriterion("RECORD_TLRCD in", values, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdNotIn(List<String> values) {
            addCriterion("RECORD_TLRCD not in", values, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdBetween(String value1, String value2) {
            addCriterion("RECORD_TLRCD between", value1, value2, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordTlrcdNotBetween(String value1, String value2) {
            addCriterion("RECORD_TLRCD not between", value1, value2, "recordTlrcd");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeIsNull() {
            addCriterion("RECORD_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeIsNotNull() {
            addCriterion("RECORD_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeEqualTo(String value) {
            addCriterion("RECORD_BRCODE =", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeNotEqualTo(String value) {
            addCriterion("RECORD_BRCODE <>", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeGreaterThan(String value) {
            addCriterion("RECORD_BRCODE >", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_BRCODE >=", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeLessThan(String value) {
            addCriterion("RECORD_BRCODE <", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeLessThanOrEqualTo(String value) {
            addCriterion("RECORD_BRCODE <=", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeLike(String value) {
            addCriterion("RECORD_BRCODE like", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeNotLike(String value) {
            addCriterion("RECORD_BRCODE not like", value, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeIn(List<String> values) {
            addCriterion("RECORD_BRCODE in", values, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeNotIn(List<String> values) {
            addCriterion("RECORD_BRCODE not in", values, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeBetween(String value1, String value2) {
            addCriterion("RECORD_BRCODE between", value1, value2, "recordBrcode");
            return (Criteria) this;
        }

        public Criteria andRecordBrcodeNotBetween(String value1, String value2) {
            addCriterion("RECORD_BRCODE not between", value1, value2, "recordBrcode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}