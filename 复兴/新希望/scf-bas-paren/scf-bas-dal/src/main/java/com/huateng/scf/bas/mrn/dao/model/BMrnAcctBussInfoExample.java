package com.huateng.scf.bas.mrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BMrnAcctBussInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BMrnAcctBussInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BMrnAcctBussInfoExample(BMrnAcctBussInfoExample example) {
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

        public Criteria andDebetNoIsNull() {
            addCriterion("DEBET_NO is null");
            return (Criteria) this;
        }

        public Criteria andDebetNoIsNotNull() {
            addCriterion("DEBET_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDebetNoEqualTo(String value) {
            addCriterion("DEBET_NO =", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotEqualTo(String value) {
            addCriterion("DEBET_NO <>", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoGreaterThan(String value) {
            addCriterion("DEBET_NO >", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoGreaterThanOrEqualTo(String value) {
            addCriterion("DEBET_NO >=", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoLessThan(String value) {
            addCriterion("DEBET_NO <", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoLessThanOrEqualTo(String value) {
            addCriterion("DEBET_NO <=", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoLike(String value) {
            addCriterion("DEBET_NO like", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotLike(String value) {
            addCriterion("DEBET_NO not like", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoIn(List<String> values) {
            addCriterion("DEBET_NO in", values, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotIn(List<String> values) {
            addCriterion("DEBET_NO not in", values, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoBetween(String value1, String value2) {
            addCriterion("DEBET_NO between", value1, value2, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotBetween(String value1, String value2) {
            addCriterion("DEBET_NO not between", value1, value2, "debetNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoIsNull() {
            addCriterion("BAIL_ACCOUNTNO is null");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoIsNotNull() {
            addCriterion("BAIL_ACCOUNTNO is not null");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoEqualTo(String value) {
            addCriterion("BAIL_ACCOUNTNO =", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoNotEqualTo(String value) {
            addCriterion("BAIL_ACCOUNTNO <>", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoGreaterThan(String value) {
            addCriterion("BAIL_ACCOUNTNO >", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNTNO >=", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoLessThan(String value) {
            addCriterion("BAIL_ACCOUNTNO <", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNTNO <=", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoLike(String value) {
            addCriterion("BAIL_ACCOUNTNO like", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoNotLike(String value) {
            addCriterion("BAIL_ACCOUNTNO not like", value, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoIn(List<String> values) {
            addCriterion("BAIL_ACCOUNTNO in", values, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoNotIn(List<String> values) {
            addCriterion("BAIL_ACCOUNTNO not in", values, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNTNO between", value1, value2, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailAccountnoNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNTNO not between", value1, value2, "bailAccountno");
            return (Criteria) this;
        }

        public Criteria andBailTypeIsNull() {
            addCriterion("BAIL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBailTypeIsNotNull() {
            addCriterion("BAIL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBailTypeEqualTo(String value) {
            addCriterion("BAIL_TYPE =", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeNotEqualTo(String value) {
            addCriterion("BAIL_TYPE <>", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeGreaterThan(String value) {
            addCriterion("BAIL_TYPE >", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_TYPE >=", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeLessThan(String value) {
            addCriterion("BAIL_TYPE <", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeLessThanOrEqualTo(String value) {
            addCriterion("BAIL_TYPE <=", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeLike(String value) {
            addCriterion("BAIL_TYPE like", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeNotLike(String value) {
            addCriterion("BAIL_TYPE not like", value, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeIn(List<String> values) {
            addCriterion("BAIL_TYPE in", values, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeNotIn(List<String> values) {
            addCriterion("BAIL_TYPE not in", values, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeBetween(String value1, String value2) {
            addCriterion("BAIL_TYPE between", value1, value2, "bailType");
            return (Criteria) this;
        }

        public Criteria andBailTypeNotBetween(String value1, String value2) {
            addCriterion("BAIL_TYPE not between", value1, value2, "bailType");
            return (Criteria) this;
        }

        public Criteria andInitTypeIsNull() {
            addCriterion("INIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInitTypeIsNotNull() {
            addCriterion("INIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInitTypeEqualTo(String value) {
            addCriterion("INIT_TYPE =", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeNotEqualTo(String value) {
            addCriterion("INIT_TYPE <>", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeGreaterThan(String value) {
            addCriterion("INIT_TYPE >", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INIT_TYPE >=", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeLessThan(String value) {
            addCriterion("INIT_TYPE <", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeLessThanOrEqualTo(String value) {
            addCriterion("INIT_TYPE <=", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeLike(String value) {
            addCriterion("INIT_TYPE like", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeNotLike(String value) {
            addCriterion("INIT_TYPE not like", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeIn(List<String> values) {
            addCriterion("INIT_TYPE in", values, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeNotIn(List<String> values) {
            addCriterion("INIT_TYPE not in", values, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeBetween(String value1, String value2) {
            addCriterion("INIT_TYPE between", value1, value2, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeNotBetween(String value1, String value2) {
            addCriterion("INIT_TYPE not between", value1, value2, "initType");
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

        public Criteria andConfirmStatusIsNull() {
            addCriterion("CONFIRM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNotNull() {
            addCriterion("CONFIRM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusEqualTo(String value) {
            addCriterion("CONFIRM_STATUS =", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotEqualTo(String value) {
            addCriterion("CONFIRM_STATUS <>", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThan(String value) {
            addCriterion("CONFIRM_STATUS >", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_STATUS >=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThan(String value) {
            addCriterion("CONFIRM_STATUS <", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_STATUS <=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLike(String value) {
            addCriterion("CONFIRM_STATUS like", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotLike(String value) {
            addCriterion("CONFIRM_STATUS not like", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIn(List<String> values) {
            addCriterion("CONFIRM_STATUS in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotIn(List<String> values) {
            addCriterion("CONFIRM_STATUS not in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusBetween(String value1, String value2) {
            addCriterion("CONFIRM_STATUS between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_STATUS not between", value1, value2, "confirmStatus");
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

        public Criteria andBailAcctAttrIsNull() {
            addCriterion("BAIL_ACCT_ATTR is null");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrIsNotNull() {
            addCriterion("BAIL_ACCT_ATTR is not null");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrEqualTo(String value) {
            addCriterion("BAIL_ACCT_ATTR =", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrNotEqualTo(String value) {
            addCriterion("BAIL_ACCT_ATTR <>", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrGreaterThan(String value) {
            addCriterion("BAIL_ACCT_ATTR >", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCT_ATTR >=", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrLessThan(String value) {
            addCriterion("BAIL_ACCT_ATTR <", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCT_ATTR <=", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrLike(String value) {
            addCriterion("BAIL_ACCT_ATTR like", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrNotLike(String value) {
            addCriterion("BAIL_ACCT_ATTR not like", value, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrIn(List<String> values) {
            addCriterion("BAIL_ACCT_ATTR in", values, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrNotIn(List<String> values) {
            addCriterion("BAIL_ACCT_ATTR not in", values, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrBetween(String value1, String value2) {
            addCriterion("BAIL_ACCT_ATTR between", value1, value2, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailAcctAttrNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACCT_ATTR not between", value1, value2, "bailAcctAttr");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentIsNull() {
            addCriterion("BAIL_FROZEN_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentIsNotNull() {
            addCriterion("BAIL_FROZEN_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_PERCENT =", value, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_PERCENT <>", value, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentGreaterThan(BigDecimal value) {
            addCriterion("BAIL_FROZEN_PERCENT >", value, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_PERCENT >=", value, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentLessThan(BigDecimal value) {
            addCriterion("BAIL_FROZEN_PERCENT <", value, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_PERCENT <=", value, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentIn(List<BigDecimal> values) {
            addCriterion("BAIL_FROZEN_PERCENT in", values, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_FROZEN_PERCENT not in", values, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_FROZEN_PERCENT between", value1, value2, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_FROZEN_PERCENT not between", value1, value2, "bailFrozenPercent");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtIsNull() {
            addCriterion("BAIL_FROZEN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtIsNotNull() {
            addCriterion("BAIL_FROZEN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_AMT =", value, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_AMT <>", value, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtGreaterThan(BigDecimal value) {
            addCriterion("BAIL_FROZEN_AMT >", value, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_AMT >=", value, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtLessThan(BigDecimal value) {
            addCriterion("BAIL_FROZEN_AMT <", value, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_FROZEN_AMT <=", value, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtIn(List<BigDecimal> values) {
            addCriterion("BAIL_FROZEN_AMT in", values, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_FROZEN_AMT not in", values, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_FROZEN_AMT between", value1, value2, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBailFrozenAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_FROZEN_AMT not between", value1, value2, "bailFrozenAmt");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("BILL_ID =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("BILL_ID <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("BILL_ID >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_ID >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("BILL_ID <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("BILL_ID <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("BILL_ID like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("BILL_ID not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("BILL_ID in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("BILL_ID not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("BILL_ID between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("BILL_ID not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNull() {
            addCriterion("BILL_NO is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("BILL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("BILL_NO =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("BILL_NO <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("BILL_NO >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_NO >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("BILL_NO <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("BILL_NO <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("BILL_NO like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("BILL_NO not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("BILL_NO in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("BILL_NO not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("BILL_NO between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("BILL_NO not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoIsNull() {
            addCriterion("SUB_ACCT_SEQNO is null");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoIsNotNull() {
            addCriterion("SUB_ACCT_SEQNO is not null");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoEqualTo(String value) {
            addCriterion("SUB_ACCT_SEQNO =", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoNotEqualTo(String value) {
            addCriterion("SUB_ACCT_SEQNO <>", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoGreaterThan(String value) {
            addCriterion("SUB_ACCT_SEQNO >", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_ACCT_SEQNO >=", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoLessThan(String value) {
            addCriterion("SUB_ACCT_SEQNO <", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoLessThanOrEqualTo(String value) {
            addCriterion("SUB_ACCT_SEQNO <=", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoLike(String value) {
            addCriterion("SUB_ACCT_SEQNO like", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoNotLike(String value) {
            addCriterion("SUB_ACCT_SEQNO not like", value, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoIn(List<String> values) {
            addCriterion("SUB_ACCT_SEQNO in", values, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoNotIn(List<String> values) {
            addCriterion("SUB_ACCT_SEQNO not in", values, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoBetween(String value1, String value2) {
            addCriterion("SUB_ACCT_SEQNO between", value1, value2, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andSubAcctSeqnoNotBetween(String value1, String value2) {
            addCriterion("SUB_ACCT_SEQNO not between", value1, value2, "subAcctSeqno");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoIsNull() {
            addCriterion("BAIL_FROZEN_NO is null");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoIsNotNull() {
            addCriterion("BAIL_FROZEN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoEqualTo(String value) {
            addCriterion("BAIL_FROZEN_NO =", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoNotEqualTo(String value) {
            addCriterion("BAIL_FROZEN_NO <>", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoGreaterThan(String value) {
            addCriterion("BAIL_FROZEN_NO >", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_FROZEN_NO >=", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoLessThan(String value) {
            addCriterion("BAIL_FROZEN_NO <", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoLessThanOrEqualTo(String value) {
            addCriterion("BAIL_FROZEN_NO <=", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoLike(String value) {
            addCriterion("BAIL_FROZEN_NO like", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoNotLike(String value) {
            addCriterion("BAIL_FROZEN_NO not like", value, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoIn(List<String> values) {
            addCriterion("BAIL_FROZEN_NO in", values, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoNotIn(List<String> values) {
            addCriterion("BAIL_FROZEN_NO not in", values, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoBetween(String value1, String value2) {
            addCriterion("BAIL_FROZEN_NO between", value1, value2, "bailFrozenNo");
            return (Criteria) this;
        }

        public Criteria andBailFrozenNoNotBetween(String value1, String value2) {
            addCriterion("BAIL_FROZEN_NO not between", value1, value2, "bailFrozenNo");
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