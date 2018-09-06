package com.huateng.scf.adv.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWanCheckStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWanCheckStockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWanCheckStockExample(BWanCheckStockExample example) {
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

        public Criteria andWarnIdIsNull() {
            addCriterion("WARN_ID is null");
            return (Criteria) this;
        }

        public Criteria andWarnIdIsNotNull() {
            addCriterion("WARN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWarnIdEqualTo(String value) {
            addCriterion("WARN_ID =", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotEqualTo(String value) {
            addCriterion("WARN_ID <>", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThan(String value) {
            addCriterion("WARN_ID >", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_ID >=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThan(String value) {
            addCriterion("WARN_ID <", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThanOrEqualTo(String value) {
            addCriterion("WARN_ID <=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLike(String value) {
            addCriterion("WARN_ID like", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotLike(String value) {
            addCriterion("WARN_ID not like", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdIn(List<String> values) {
            addCriterion("WARN_ID in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotIn(List<String> values) {
            addCriterion("WARN_ID not in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdBetween(String value1, String value2) {
            addCriterion("WARN_ID between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotBetween(String value1, String value2) {
            addCriterion("WARN_ID not between", value1, value2, "warnId");
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

        public Criteria andSlaveContcodeIsNull() {
            addCriterion("SLAVE_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeIsNotNull() {
            addCriterion("SLAVE_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE =", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE <>", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeGreaterThan(String value) {
            addCriterion("SLAVE_CONTCODE >", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE >=", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeLessThan(String value) {
            addCriterion("SLAVE_CONTCODE <", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeLessThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE <=", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeLike(String value) {
            addCriterion("SLAVE_CONTCODE like", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotLike(String value) {
            addCriterion("SLAVE_CONTCODE not like", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeIn(List<String> values) {
            addCriterion("SLAVE_CONTCODE in", values, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotIn(List<String> values) {
            addCriterion("SLAVE_CONTCODE not in", values, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTCODE between", value1, value2, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTCODE not between", value1, value2, "slaveContcode");
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

        public Criteria andMoniCustcdIsNull() {
            addCriterion("MONI_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdIsNotNull() {
            addCriterion("MONI_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdEqualTo(String value) {
            addCriterion("MONI_CUSTCD =", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotEqualTo(String value) {
            addCriterion("MONI_CUSTCD <>", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdGreaterThan(String value) {
            addCriterion("MONI_CUSTCD >", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_CUSTCD >=", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLessThan(String value) {
            addCriterion("MONI_CUSTCD <", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLessThanOrEqualTo(String value) {
            addCriterion("MONI_CUSTCD <=", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLike(String value) {
            addCriterion("MONI_CUSTCD like", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotLike(String value) {
            addCriterion("MONI_CUSTCD not like", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdIn(List<String> values) {
            addCriterion("MONI_CUSTCD in", values, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotIn(List<String> values) {
            addCriterion("MONI_CUSTCD not in", values, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdBetween(String value1, String value2) {
            addCriterion("MONI_CUSTCD between", value1, value2, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotBetween(String value1, String value2) {
            addCriterion("MONI_CUSTCD not between", value1, value2, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCnameIsNull() {
            addCriterion("MONI_CNAME is null");
            return (Criteria) this;
        }

        public Criteria andMoniCnameIsNotNull() {
            addCriterion("MONI_CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMoniCnameEqualTo(String value) {
            addCriterion("MONI_CNAME =", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotEqualTo(String value) {
            addCriterion("MONI_CNAME <>", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameGreaterThan(String value) {
            addCriterion("MONI_CNAME >", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_CNAME >=", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameLessThan(String value) {
            addCriterion("MONI_CNAME <", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameLessThanOrEqualTo(String value) {
            addCriterion("MONI_CNAME <=", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameLike(String value) {
            addCriterion("MONI_CNAME like", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotLike(String value) {
            addCriterion("MONI_CNAME not like", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameIn(List<String> values) {
            addCriterion("MONI_CNAME in", values, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotIn(List<String> values) {
            addCriterion("MONI_CNAME not in", values, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameBetween(String value1, String value2) {
            addCriterion("MONI_CNAME between", value1, value2, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotBetween(String value1, String value2) {
            addCriterion("MONI_CNAME not between", value1, value2, "moniCname");
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

        public Criteria andMortAmtIsNull() {
            addCriterion("MORT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andMortAmtIsNotNull() {
            addCriterion("MORT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andMortAmtEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT =", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtNotEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT <>", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtGreaterThan(BigDecimal value) {
            addCriterion("MORT_AMT >", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT >=", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtLessThan(BigDecimal value) {
            addCriterion("MORT_AMT <", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT <=", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtIn(List<BigDecimal> values) {
            addCriterion("MORT_AMT in", values, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtNotIn(List<BigDecimal> values) {
            addCriterion("MORT_AMT not in", values, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_AMT between", value1, value2, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_AMT not between", value1, value2, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtIsNull() {
            addCriterion("CHECK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCheckAmtIsNotNull() {
            addCriterion("CHECK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAmtEqualTo(BigDecimal value) {
            addCriterion("CHECK_AMT =", value, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtNotEqualTo(BigDecimal value) {
            addCriterion("CHECK_AMT <>", value, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtGreaterThan(BigDecimal value) {
            addCriterion("CHECK_AMT >", value, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHECK_AMT >=", value, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtLessThan(BigDecimal value) {
            addCriterion("CHECK_AMT <", value, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHECK_AMT <=", value, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtIn(List<BigDecimal> values) {
            addCriterion("CHECK_AMT in", values, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtNotIn(List<BigDecimal> values) {
            addCriterion("CHECK_AMT not in", values, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHECK_AMT between", value1, value2, "checkAmt");
            return (Criteria) this;
        }

        public Criteria andCheckAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHECK_AMT not between", value1, value2, "checkAmt");
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

        public Criteria andConfirmDateIsNull() {
            addCriterion("CONFIRM_DATE is null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNotNull() {
            addCriterion("CONFIRM_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateEqualTo(String value) {
            addCriterion("CONFIRM_DATE =", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotEqualTo(String value) {
            addCriterion("CONFIRM_DATE <>", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThan(String value) {
            addCriterion("CONFIRM_DATE >", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_DATE >=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThan(String value) {
            addCriterion("CONFIRM_DATE <", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_DATE <=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLike(String value) {
            addCriterion("CONFIRM_DATE like", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotLike(String value) {
            addCriterion("CONFIRM_DATE not like", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIn(List<String> values) {
            addCriterion("CONFIRM_DATE in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotIn(List<String> values) {
            addCriterion("CONFIRM_DATE not in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateBetween(String value1, String value2) {
            addCriterion("CONFIRM_DATE between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_DATE not between", value1, value2, "confirmDate");
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

        public Criteria andCheckResultIsNull() {
            addCriterion("CHECK_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNotNull() {
            addCriterion("CHECK_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("CHECK_RESULT =", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("CHECK_RESULT <>", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("CHECK_RESULT >", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT >=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThan(String value) {
            addCriterion("CHECK_RESULT <", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT <=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLike(String value) {
            addCriterion("CHECK_RESULT like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotLike(String value) {
            addCriterion("CHECK_RESULT not like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("CHECK_RESULT in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("CHECK_RESULT not in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT not between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("CHECK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("CHECK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(String value) {
            addCriterion("CHECK_STATUS =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(String value) {
            addCriterion("CHECK_STATUS <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(String value) {
            addCriterion("CHECK_STATUS >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STATUS >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(String value) {
            addCriterion("CHECK_STATUS <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STATUS <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLike(String value) {
            addCriterion("CHECK_STATUS like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotLike(String value) {
            addCriterion("CHECK_STATUS not like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<String> values) {
            addCriterion("CHECK_STATUS in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<String> values) {
            addCriterion("CHECK_STATUS not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(String value1, String value2) {
            addCriterion("CHECK_STATUS between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(String value1, String value2) {
            addCriterion("CHECK_STATUS not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}