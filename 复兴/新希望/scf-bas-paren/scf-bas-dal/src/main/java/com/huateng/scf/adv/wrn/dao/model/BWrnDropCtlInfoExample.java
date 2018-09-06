package com.huateng.scf.adv.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWrnDropCtlInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWrnDropCtlInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWrnDropCtlInfoExample(BWrnDropCtlInfoExample example) {
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

        public Criteria andLeastMortAmtIsNull() {
            addCriterion("LEAST_MORT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtIsNotNull() {
            addCriterion("LEAST_MORT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtEqualTo(BigDecimal value) {
            addCriterion("LEAST_MORT_AMT =", value, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtNotEqualTo(BigDecimal value) {
            addCriterion("LEAST_MORT_AMT <>", value, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtGreaterThan(BigDecimal value) {
            addCriterion("LEAST_MORT_AMT >", value, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LEAST_MORT_AMT >=", value, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtLessThan(BigDecimal value) {
            addCriterion("LEAST_MORT_AMT <", value, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LEAST_MORT_AMT <=", value, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtIn(List<BigDecimal> values) {
            addCriterion("LEAST_MORT_AMT in", values, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtNotIn(List<BigDecimal> values) {
            addCriterion("LEAST_MORT_AMT not in", values, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LEAST_MORT_AMT between", value1, value2, "leastMortAmt");
            return (Criteria) this;
        }

        public Criteria andLeastMortAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LEAST_MORT_AMT not between", value1, value2, "leastMortAmt");
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

        public Criteria andRatioIsNull() {
            addCriterion("RATIO is null");
            return (Criteria) this;
        }

        public Criteria andRatioIsNotNull() {
            addCriterion("RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andRatioEqualTo(BigDecimal value) {
            addCriterion("RATIO =", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotEqualTo(BigDecimal value) {
            addCriterion("RATIO <>", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThan(BigDecimal value) {
            addCriterion("RATIO >", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATIO >=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThan(BigDecimal value) {
            addCriterion("RATIO <", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATIO <=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioIn(List<BigDecimal> values) {
            addCriterion("RATIO in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotIn(List<BigDecimal> values) {
            addCriterion("RATIO not in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATIO between", value1, value2, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATIO not between", value1, value2, "ratio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioIsNull() {
            addCriterion("CURRENT_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioIsNotNull() {
            addCriterion("CURRENT_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioEqualTo(BigDecimal value) {
            addCriterion("CURRENT_RATIO =", value, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioNotEqualTo(BigDecimal value) {
            addCriterion("CURRENT_RATIO <>", value, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioGreaterThan(BigDecimal value) {
            addCriterion("CURRENT_RATIO >", value, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_RATIO >=", value, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioLessThan(BigDecimal value) {
            addCriterion("CURRENT_RATIO <", value, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_RATIO <=", value, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioIn(List<BigDecimal> values) {
            addCriterion("CURRENT_RATIO in", values, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioNotIn(List<BigDecimal> values) {
            addCriterion("CURRENT_RATIO not in", values, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_RATIO between", value1, value2, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andCurrentRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_RATIO not between", value1, value2, "currentRatio");
            return (Criteria) this;
        }

        public Criteria andWarnLineIsNull() {
            addCriterion("WARN_LINE is null");
            return (Criteria) this;
        }

        public Criteria andWarnLineIsNotNull() {
            addCriterion("WARN_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLineEqualTo(BigDecimal value) {
            addCriterion("WARN_LINE =", value, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineNotEqualTo(BigDecimal value) {
            addCriterion("WARN_LINE <>", value, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineGreaterThan(BigDecimal value) {
            addCriterion("WARN_LINE >", value, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WARN_LINE >=", value, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineLessThan(BigDecimal value) {
            addCriterion("WARN_LINE <", value, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WARN_LINE <=", value, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineIn(List<BigDecimal> values) {
            addCriterion("WARN_LINE in", values, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineNotIn(List<BigDecimal> values) {
            addCriterion("WARN_LINE not in", values, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WARN_LINE between", value1, value2, "warnLine");
            return (Criteria) this;
        }

        public Criteria andWarnLineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WARN_LINE not between", value1, value2, "warnLine");
            return (Criteria) this;
        }

        public Criteria andMortBalanceIsNull() {
            addCriterion("MORT_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andMortBalanceIsNotNull() {
            addCriterion("MORT_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andMortBalanceEqualTo(BigDecimal value) {
            addCriterion("MORT_BALANCE =", value, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceNotEqualTo(BigDecimal value) {
            addCriterion("MORT_BALANCE <>", value, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceGreaterThan(BigDecimal value) {
            addCriterion("MORT_BALANCE >", value, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_BALANCE >=", value, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceLessThan(BigDecimal value) {
            addCriterion("MORT_BALANCE <", value, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_BALANCE <=", value, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceIn(List<BigDecimal> values) {
            addCriterion("MORT_BALANCE in", values, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceNotIn(List<BigDecimal> values) {
            addCriterion("MORT_BALANCE not in", values, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_BALANCE between", value1, value2, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andMortBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_BALANCE not between", value1, value2, "mortBalance");
            return (Criteria) this;
        }

        public Criteria andRiskBalIsNull() {
            addCriterion("RISK_BAL is null");
            return (Criteria) this;
        }

        public Criteria andRiskBalIsNotNull() {
            addCriterion("RISK_BAL is not null");
            return (Criteria) this;
        }

        public Criteria andRiskBalEqualTo(BigDecimal value) {
            addCriterion("RISK_BAL =", value, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalNotEqualTo(BigDecimal value) {
            addCriterion("RISK_BAL <>", value, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalGreaterThan(BigDecimal value) {
            addCriterion("RISK_BAL >", value, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_BAL >=", value, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalLessThan(BigDecimal value) {
            addCriterion("RISK_BAL <", value, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_BAL <=", value, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalIn(List<BigDecimal> values) {
            addCriterion("RISK_BAL in", values, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalNotIn(List<BigDecimal> values) {
            addCriterion("RISK_BAL not in", values, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_BAL between", value1, value2, "riskBal");
            return (Criteria) this;
        }

        public Criteria andRiskBalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_BAL not between", value1, value2, "riskBal");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}