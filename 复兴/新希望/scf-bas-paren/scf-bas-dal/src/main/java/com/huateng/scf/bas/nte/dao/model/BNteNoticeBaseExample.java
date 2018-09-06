package com.huateng.scf.bas.nte.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNteNoticeBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BNteNoticeBaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BNteNoticeBaseExample(BNteNoticeBaseExample example) {
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

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("NUM like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("NUM not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("NUM not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoIsNull() {
            addCriterion("MONITOR_PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoIsNotNull() {
            addCriterion("MONITOR_PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO =", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO <>", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoGreaterThan(String value) {
            addCriterion("MONITOR_PROTOCOL_NO >", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO >=", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoLessThan(String value) {
            addCriterion("MONITOR_PROTOCOL_NO <", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO <=", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoLike(String value) {
            addCriterion("MONITOR_PROTOCOL_NO like", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotLike(String value) {
            addCriterion("MONITOR_PROTOCOL_NO not like", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoIn(List<String> values) {
            addCriterion("MONITOR_PROTOCOL_NO in", values, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotIn(List<String> values) {
            addCriterion("MONITOR_PROTOCOL_NO not in", values, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoBetween(String value1, String value2) {
            addCriterion("MONITOR_PROTOCOL_NO between", value1, value2, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotBetween(String value1, String value2) {
            addCriterion("MONITOR_PROTOCOL_NO not between", value1, value2, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIsNull() {
            addCriterion("PROTOCOL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIsNotNull() {
            addCriterion("PROTOCOL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeEqualTo(String value) {
            addCriterion("PROTOCOL_CODE =", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotEqualTo(String value) {
            addCriterion("PROTOCOL_CODE <>", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeGreaterThan(String value) {
            addCriterion("PROTOCOL_CODE >", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_CODE >=", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLessThan(String value) {
            addCriterion("PROTOCOL_CODE <", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_CODE <=", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLike(String value) {
            addCriterion("PROTOCOL_CODE like", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotLike(String value) {
            addCriterion("PROTOCOL_CODE not like", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIn(List<String> values) {
            addCriterion("PROTOCOL_CODE in", values, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotIn(List<String> values) {
            addCriterion("PROTOCOL_CODE not in", values, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeBetween(String value1, String value2) {
            addCriterion("PROTOCOL_CODE between", value1, value2, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_CODE not between", value1, value2, "protocolCode");
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

        public Criteria andMoniOfCustcdIsNull() {
            addCriterion("MONI_OF_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdIsNotNull() {
            addCriterion("MONI_OF_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD =", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD <>", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdGreaterThan(String value) {
            addCriterion("MONI_OF_CUSTCD >", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD >=", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdLessThan(String value) {
            addCriterion("MONI_OF_CUSTCD <", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdLessThanOrEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD <=", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdLike(String value) {
            addCriterion("MONI_OF_CUSTCD like", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotLike(String value) {
            addCriterion("MONI_OF_CUSTCD not like", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdIn(List<String> values) {
            addCriterion("MONI_OF_CUSTCD in", values, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotIn(List<String> values) {
            addCriterion("MONI_OF_CUSTCD not in", values, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdBetween(String value1, String value2) {
            addCriterion("MONI_OF_CUSTCD between", value1, value2, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotBetween(String value1, String value2) {
            addCriterion("MONI_OF_CUSTCD not between", value1, value2, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNull() {
            addCriterion("NOTICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNotNull() {
            addCriterion("NOTICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeEqualTo(String value) {
            addCriterion("NOTICE_TYPE =", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotEqualTo(String value) {
            addCriterion("NOTICE_TYPE <>", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThan(String value) {
            addCriterion("NOTICE_TYPE >", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE >=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThan(String value) {
            addCriterion("NOTICE_TYPE <", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE <=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLike(String value) {
            addCriterion("NOTICE_TYPE like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotLike(String value) {
            addCriterion("NOTICE_TYPE not like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIn(List<String> values) {
            addCriterion("NOTICE_TYPE in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotIn(List<String> values) {
            addCriterion("NOTICE_TYPE not in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE not between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeIsNull() {
            addCriterion("MORTGAGE_CHANGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeIsNotNull() {
            addCriterion("MORTGAGE_CHANGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeEqualTo(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE =", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeNotEqualTo(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE <>", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeGreaterThan(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE >", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE >=", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeLessThan(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE <", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE <=", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeLike(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE like", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeNotLike(String value) {
            addCriterion("MORTGAGE_CHANGE_TYPE not like", value, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeIn(List<String> values) {
            addCriterion("MORTGAGE_CHANGE_TYPE in", values, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeNotIn(List<String> values) {
            addCriterion("MORTGAGE_CHANGE_TYPE not in", values, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeBetween(String value1, String value2) {
            addCriterion("MORTGAGE_CHANGE_TYPE between", value1, value2, "mortgageChangeType");
            return (Criteria) this;
        }

        public Criteria andMortgageChangeTypeNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_CHANGE_TYPE not between", value1, value2, "mortgageChangeType");
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

        public Criteria andMoniOfDateIsNull() {
            addCriterion("MONI_OF_DATE is null");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateIsNotNull() {
            addCriterion("MONI_OF_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateEqualTo(String value) {
            addCriterion("MONI_OF_DATE =", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateNotEqualTo(String value) {
            addCriterion("MONI_OF_DATE <>", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateGreaterThan(String value) {
            addCriterion("MONI_OF_DATE >", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_OF_DATE >=", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateLessThan(String value) {
            addCriterion("MONI_OF_DATE <", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateLessThanOrEqualTo(String value) {
            addCriterion("MONI_OF_DATE <=", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateLike(String value) {
            addCriterion("MONI_OF_DATE like", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateNotLike(String value) {
            addCriterion("MONI_OF_DATE not like", value, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateIn(List<String> values) {
            addCriterion("MONI_OF_DATE in", values, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateNotIn(List<String> values) {
            addCriterion("MONI_OF_DATE not in", values, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateBetween(String value1, String value2) {
            addCriterion("MONI_OF_DATE between", value1, value2, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfDateNotBetween(String value1, String value2) {
            addCriterion("MONI_OF_DATE not between", value1, value2, "moniOfDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateIsNull() {
            addCriterion("APPLI_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAppliDateIsNotNull() {
            addCriterion("APPLI_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAppliDateEqualTo(String value) {
            addCriterion("APPLI_DATE =", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateNotEqualTo(String value) {
            addCriterion("APPLI_DATE <>", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateGreaterThan(String value) {
            addCriterion("APPLI_DATE >", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateGreaterThanOrEqualTo(String value) {
            addCriterion("APPLI_DATE >=", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateLessThan(String value) {
            addCriterion("APPLI_DATE <", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateLessThanOrEqualTo(String value) {
            addCriterion("APPLI_DATE <=", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateLike(String value) {
            addCriterion("APPLI_DATE like", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateNotLike(String value) {
            addCriterion("APPLI_DATE not like", value, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateIn(List<String> values) {
            addCriterion("APPLI_DATE in", values, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateNotIn(List<String> values) {
            addCriterion("APPLI_DATE not in", values, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateBetween(String value1, String value2) {
            addCriterion("APPLI_DATE between", value1, value2, "appliDate");
            return (Criteria) this;
        }

        public Criteria andAppliDateNotBetween(String value1, String value2) {
            addCriterion("APPLI_DATE not between", value1, value2, "appliDate");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameIsNull() {
            addCriterion("MONI_OF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameIsNotNull() {
            addCriterion("MONI_OF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameEqualTo(String value) {
            addCriterion("MONI_OF_NAME =", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameNotEqualTo(String value) {
            addCriterion("MONI_OF_NAME <>", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameGreaterThan(String value) {
            addCriterion("MONI_OF_NAME >", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_OF_NAME >=", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameLessThan(String value) {
            addCriterion("MONI_OF_NAME <", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameLessThanOrEqualTo(String value) {
            addCriterion("MONI_OF_NAME <=", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameLike(String value) {
            addCriterion("MONI_OF_NAME like", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameNotLike(String value) {
            addCriterion("MONI_OF_NAME not like", value, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameIn(List<String> values) {
            addCriterion("MONI_OF_NAME in", values, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameNotIn(List<String> values) {
            addCriterion("MONI_OF_NAME not in", values, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameBetween(String value1, String value2) {
            addCriterion("MONI_OF_NAME between", value1, value2, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andMoniOfNameNotBetween(String value1, String value2) {
            addCriterion("MONI_OF_NAME not between", value1, value2, "moniOfName");
            return (Criteria) this;
        }

        public Criteria andTlrnIsNull() {
            addCriterion("TLRN is null");
            return (Criteria) this;
        }

        public Criteria andTlrnIsNotNull() {
            addCriterion("TLRN is not null");
            return (Criteria) this;
        }

        public Criteria andTlrnEqualTo(String value) {
            addCriterion("TLRN =", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnNotEqualTo(String value) {
            addCriterion("TLRN <>", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnGreaterThan(String value) {
            addCriterion("TLRN >", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnGreaterThanOrEqualTo(String value) {
            addCriterion("TLRN >=", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnLessThan(String value) {
            addCriterion("TLRN <", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnLessThanOrEqualTo(String value) {
            addCriterion("TLRN <=", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnLike(String value) {
            addCriterion("TLRN like", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnNotLike(String value) {
            addCriterion("TLRN not like", value, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnIn(List<String> values) {
            addCriterion("TLRN in", values, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnNotIn(List<String> values) {
            addCriterion("TLRN not in", values, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnBetween(String value1, String value2) {
            addCriterion("TLRN between", value1, value2, "tlrn");
            return (Criteria) this;
        }

        public Criteria andTlrnNotBetween(String value1, String value2) {
            addCriterion("TLRN not between", value1, value2, "tlrn");
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

        public Criteria andPledgeModeIsNull() {
            addCriterion("PLEDGE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andPledgeModeIsNotNull() {
            addCriterion("PLEDGE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeModeEqualTo(String value) {
            addCriterion("PLEDGE_MODE =", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotEqualTo(String value) {
            addCriterion("PLEDGE_MODE <>", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeGreaterThan(String value) {
            addCriterion("PLEDGE_MODE >", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeGreaterThanOrEqualTo(String value) {
            addCriterion("PLEDGE_MODE >=", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeLessThan(String value) {
            addCriterion("PLEDGE_MODE <", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeLessThanOrEqualTo(String value) {
            addCriterion("PLEDGE_MODE <=", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeLike(String value) {
            addCriterion("PLEDGE_MODE like", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotLike(String value) {
            addCriterion("PLEDGE_MODE not like", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeIn(List<String> values) {
            addCriterion("PLEDGE_MODE in", values, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotIn(List<String> values) {
            addCriterion("PLEDGE_MODE not in", values, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeBetween(String value1, String value2) {
            addCriterion("PLEDGE_MODE between", value1, value2, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotBetween(String value1, String value2) {
            addCriterion("PLEDGE_MODE not between", value1, value2, "pledgeMode");
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

        public Criteria andCommonAmtIsNull() {
            addCriterion("COMMON_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCommonAmtIsNotNull() {
            addCriterion("COMMON_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCommonAmtEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMT =", value, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtNotEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMT <>", value, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtGreaterThan(BigDecimal value) {
            addCriterion("COMMON_AMT >", value, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMT >=", value, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtLessThan(BigDecimal value) {
            addCriterion("COMMON_AMT <", value, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMT <=", value, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtIn(List<BigDecimal> values) {
            addCriterion("COMMON_AMT in", values, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtNotIn(List<BigDecimal> values) {
            addCriterion("COMMON_AMT not in", values, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMON_AMT between", value1, value2, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andCommonAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMON_AMT not between", value1, value2, "commonAmt");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andCommonNumIsNull() {
            addCriterion("COMMON_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCommonNumIsNotNull() {
            addCriterion("COMMON_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCommonNumEqualTo(String value) {
            addCriterion("COMMON_NUM =", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumNotEqualTo(String value) {
            addCriterion("COMMON_NUM <>", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumGreaterThan(String value) {
            addCriterion("COMMON_NUM >", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumGreaterThanOrEqualTo(String value) {
            addCriterion("COMMON_NUM >=", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumLessThan(String value) {
            addCriterion("COMMON_NUM <", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumLessThanOrEqualTo(String value) {
            addCriterion("COMMON_NUM <=", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumLike(String value) {
            addCriterion("COMMON_NUM like", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumNotLike(String value) {
            addCriterion("COMMON_NUM not like", value, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumIn(List<String> values) {
            addCriterion("COMMON_NUM in", values, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumNotIn(List<String> values) {
            addCriterion("COMMON_NUM not in", values, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumBetween(String value1, String value2) {
            addCriterion("COMMON_NUM between", value1, value2, "commonNum");
            return (Criteria) this;
        }

        public Criteria andCommonNumNotBetween(String value1, String value2) {
            addCriterion("COMMON_NUM not between", value1, value2, "commonNum");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIsNull() {
            addCriterion("MAST_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIsNotNull() {
            addCriterion("MAST_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeEqualTo(String value) {
            addCriterion("MAST_CONTCODE =", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotEqualTo(String value) {
            addCriterion("MAST_CONTCODE <>", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThan(String value) {
            addCriterion("MAST_CONTCODE >", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE >=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThan(String value) {
            addCriterion("MAST_CONTCODE <", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE <=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLike(String value) {
            addCriterion("MAST_CONTCODE like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotLike(String value) {
            addCriterion("MAST_CONTCODE not like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIn(List<String> values) {
            addCriterion("MAST_CONTCODE in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotIn(List<String> values) {
            addCriterion("MAST_CONTCODE not in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE between", value1, value2, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE not between", value1, value2, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdIsNull() {
            addCriterion("OTHER_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdIsNotNull() {
            addCriterion("OTHER_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdEqualTo(String value) {
            addCriterion("OTHER_CUSTCD =", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotEqualTo(String value) {
            addCriterion("OTHER_CUSTCD <>", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdGreaterThan(String value) {
            addCriterion("OTHER_CUSTCD >", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_CUSTCD >=", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLessThan(String value) {
            addCriterion("OTHER_CUSTCD <", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLessThanOrEqualTo(String value) {
            addCriterion("OTHER_CUSTCD <=", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLike(String value) {
            addCriterion("OTHER_CUSTCD like", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotLike(String value) {
            addCriterion("OTHER_CUSTCD not like", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdIn(List<String> values) {
            addCriterion("OTHER_CUSTCD in", values, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotIn(List<String> values) {
            addCriterion("OTHER_CUSTCD not in", values, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdBetween(String value1, String value2) {
            addCriterion("OTHER_CUSTCD between", value1, value2, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotBetween(String value1, String value2) {
            addCriterion("OTHER_CUSTCD not between", value1, value2, "otherCustcd");
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

        public Criteria andAccountNameIsNull() {
            addCriterion("ACCOUNT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("ACCOUNT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("ACCOUNT_NAME =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("ACCOUNT_NAME <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("ACCOUNT_NAME >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NAME >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("ACCOUNT_NAME <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NAME <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("ACCOUNT_NAME like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("ACCOUNT_NAME not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("ACCOUNT_NAME in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("ACCOUNT_NAME not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NAME between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NAME not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNull() {
            addCriterion("ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("ACCOUNT_NO =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("ACCOUNT_NO <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("ACCOUNT_NO >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("ACCOUNT_NO <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("ACCOUNT_NO like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("ACCOUNT_NO not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("ACCOUNT_NO in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("ACCOUNT_NO not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO not between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeIsNull() {
            addCriterion("DEPOSIT_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeIsNotNull() {
            addCriterion("DEPOSIT_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE =", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE <>", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeGreaterThan(String value) {
            addCriterion("DEPOSIT_BRCODE >", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE >=", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeLessThan(String value) {
            addCriterion("DEPOSIT_BRCODE <", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE <=", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeLike(String value) {
            addCriterion("DEPOSIT_BRCODE like", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotLike(String value) {
            addCriterion("DEPOSIT_BRCODE not like", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeIn(List<String> values) {
            addCriterion("DEPOSIT_BRCODE in", values, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotIn(List<String> values) {
            addCriterion("DEPOSIT_BRCODE not in", values, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BRCODE between", value1, value2, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BRCODE not between", value1, value2, "depositBrcode");
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

        public Criteria andDebetIdIsNull() {
            addCriterion("DEBET_ID is null");
            return (Criteria) this;
        }

        public Criteria andDebetIdIsNotNull() {
            addCriterion("DEBET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDebetIdEqualTo(String value) {
            addCriterion("DEBET_ID =", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotEqualTo(String value) {
            addCriterion("DEBET_ID <>", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdGreaterThan(String value) {
            addCriterion("DEBET_ID >", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEBET_ID >=", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdLessThan(String value) {
            addCriterion("DEBET_ID <", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdLessThanOrEqualTo(String value) {
            addCriterion("DEBET_ID <=", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdLike(String value) {
            addCriterion("DEBET_ID like", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotLike(String value) {
            addCriterion("DEBET_ID not like", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdIn(List<String> values) {
            addCriterion("DEBET_ID in", values, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotIn(List<String> values) {
            addCriterion("DEBET_ID not in", values, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdBetween(String value1, String value2) {
            addCriterion("DEBET_ID between", value1, value2, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotBetween(String value1, String value2) {
            addCriterion("DEBET_ID not between", value1, value2, "debetId");
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

        public Criteria andSignDateIsNull() {
            addCriterion("SIGN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("SIGN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(String value) {
            addCriterion("SIGN_DATE =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(String value) {
            addCriterion("SIGN_DATE <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(String value) {
            addCriterion("SIGN_DATE >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_DATE >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(String value) {
            addCriterion("SIGN_DATE <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(String value) {
            addCriterion("SIGN_DATE <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLike(String value) {
            addCriterion("SIGN_DATE like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotLike(String value) {
            addCriterion("SIGN_DATE not like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<String> values) {
            addCriterion("SIGN_DATE in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<String> values) {
            addCriterion("SIGN_DATE not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(String value1, String value2) {
            addCriterion("SIGN_DATE between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(String value1, String value2) {
            addCriterion("SIGN_DATE not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateIsNull() {
            addCriterion("COMMON_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCommonDateIsNotNull() {
            addCriterion("COMMON_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCommonDateEqualTo(String value) {
            addCriterion("COMMON_DATE =", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotEqualTo(String value) {
            addCriterion("COMMON_DATE <>", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateGreaterThan(String value) {
            addCriterion("COMMON_DATE >", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateGreaterThanOrEqualTo(String value) {
            addCriterion("COMMON_DATE >=", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLessThan(String value) {
            addCriterion("COMMON_DATE <", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLessThanOrEqualTo(String value) {
            addCriterion("COMMON_DATE <=", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLike(String value) {
            addCriterion("COMMON_DATE like", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotLike(String value) {
            addCriterion("COMMON_DATE not like", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateIn(List<String> values) {
            addCriterion("COMMON_DATE in", values, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotIn(List<String> values) {
            addCriterion("COMMON_DATE not in", values, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateBetween(String value1, String value2) {
            addCriterion("COMMON_DATE between", value1, value2, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotBetween(String value1, String value2) {
            addCriterion("COMMON_DATE not between", value1, value2, "commonDate");
            return (Criteria) this;
        }

        public Criteria andExt1AmountIsNull() {
            addCriterion("EXT1_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andExt1AmountIsNotNull() {
            addCriterion("EXT1_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andExt1AmountEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT =", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountNotEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT <>", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountGreaterThan(BigDecimal value) {
            addCriterion("EXT1_AMOUNT >", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT >=", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountLessThan(BigDecimal value) {
            addCriterion("EXT1_AMOUNT <", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT <=", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountIn(List<BigDecimal> values) {
            addCriterion("EXT1_AMOUNT in", values, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountNotIn(List<BigDecimal> values) {
            addCriterion("EXT1_AMOUNT not in", values, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT1_AMOUNT between", value1, value2, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT1_AMOUNT not between", value1, value2, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountIsNull() {
            addCriterion("EXT2_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andExt2AmountIsNotNull() {
            addCriterion("EXT2_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andExt2AmountEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT =", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountNotEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT <>", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountGreaterThan(BigDecimal value) {
            addCriterion("EXT2_AMOUNT >", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT >=", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountLessThan(BigDecimal value) {
            addCriterion("EXT2_AMOUNT <", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT <=", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountIn(List<BigDecimal> values) {
            addCriterion("EXT2_AMOUNT in", values, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountNotIn(List<BigDecimal> values) {
            addCriterion("EXT2_AMOUNT not in", values, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT2_AMOUNT between", value1, value2, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT2_AMOUNT not between", value1, value2, "ext2Amount");
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

        public Criteria andExt2IsNull() {
            addCriterion("EXT2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("EXT2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("EXT2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("EXT2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("EXT2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("EXT2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("EXT2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("EXT2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("EXT2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("EXT2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("EXT2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("EXT2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("EXT2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("EXT2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNull() {
            addCriterion("BUSS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNotNull() {
            addCriterion("BUSS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBussTypeEqualTo(String value) {
            addCriterion("BUSS_TYPE =", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotEqualTo(String value) {
            addCriterion("BUSS_TYPE <>", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThan(String value) {
            addCriterion("BUSS_TYPE >", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE >=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThan(String value) {
            addCriterion("BUSS_TYPE <", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE <=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLike(String value) {
            addCriterion("BUSS_TYPE like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotLike(String value) {
            addCriterion("BUSS_TYPE not like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeIn(List<String> values) {
            addCriterion("BUSS_TYPE in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotIn(List<String> values) {
            addCriterion("BUSS_TYPE not in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE not between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNull() {
            addCriterion("PAYEE is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNotNull() {
            addCriterion("PAYEE is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeEqualTo(String value) {
            addCriterion("PAYEE =", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotEqualTo(String value) {
            addCriterion("PAYEE <>", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThan(String value) {
            addCriterion("PAYEE >", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE >=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThan(String value) {
            addCriterion("PAYEE <", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThanOrEqualTo(String value) {
            addCriterion("PAYEE <=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLike(String value) {
            addCriterion("PAYEE like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotLike(String value) {
            addCriterion("PAYEE not like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeIn(List<String> values) {
            addCriterion("PAYEE in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotIn(List<String> values) {
            addCriterion("PAYEE not in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeBetween(String value1, String value2) {
            addCriterion("PAYEE between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotBetween(String value1, String value2) {
            addCriterion("PAYEE not between", value1, value2, "payee");
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

        public Criteria andDepositBrnameIsNull() {
            addCriterion("DEPOSIT_BRNAME is null");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameIsNotNull() {
            addCriterion("DEPOSIT_BRNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameEqualTo(String value) {
            addCriterion("DEPOSIT_BRNAME =", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameNotEqualTo(String value) {
            addCriterion("DEPOSIT_BRNAME <>", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameGreaterThan(String value) {
            addCriterion("DEPOSIT_BRNAME >", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BRNAME >=", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameLessThan(String value) {
            addCriterion("DEPOSIT_BRNAME <", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BRNAME <=", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameLike(String value) {
            addCriterion("DEPOSIT_BRNAME like", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameNotLike(String value) {
            addCriterion("DEPOSIT_BRNAME not like", value, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameIn(List<String> values) {
            addCriterion("DEPOSIT_BRNAME in", values, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameNotIn(List<String> values) {
            addCriterion("DEPOSIT_BRNAME not in", values, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BRNAME between", value1, value2, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andDepositBrnameNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BRNAME not between", value1, value2, "depositBrname");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("LINKMAN =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("LINKMAN <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("LINKMAN >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("LINKMAN >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("LINKMAN <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("LINKMAN <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("LINKMAN like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("LINKMAN not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("LINKMAN in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("LINKMAN not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("LINKMAN between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("LINKMAN not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between", value1, value2, "telephone");
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

        public Criteria andTonsIsNull() {
            addCriterion("TONS is null");
            return (Criteria) this;
        }

        public Criteria andTonsIsNotNull() {
            addCriterion("TONS is not null");
            return (Criteria) this;
        }

        public Criteria andTonsEqualTo(BigDecimal value) {
            addCriterion("TONS =", value, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsNotEqualTo(BigDecimal value) {
            addCriterion("TONS <>", value, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsGreaterThan(BigDecimal value) {
            addCriterion("TONS >", value, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TONS >=", value, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsLessThan(BigDecimal value) {
            addCriterion("TONS <", value, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TONS <=", value, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsIn(List<BigDecimal> values) {
            addCriterion("TONS in", values, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsNotIn(List<BigDecimal> values) {
            addCriterion("TONS not in", values, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TONS between", value1, value2, "tons");
            return (Criteria) this;
        }

        public Criteria andTonsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TONS not between", value1, value2, "tons");
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

        public Criteria andDeliveryQuantityIsNull() {
            addCriterion("DELIVERY_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityIsNotNull() {
            addCriterion("DELIVERY_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY =", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityNotEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY <>", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityGreaterThan(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY >", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY >=", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityLessThan(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY <", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY <=", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_QUANTITY in", values, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityNotIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_QUANTITY not in", values, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_QUANTITY between", value1, value2, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_QUANTITY not between", value1, value2, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtIsNull() {
            addCriterion("DELIVERY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtIsNotNull() {
            addCriterion("DELIVERY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMT =", value, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtNotEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMT <>", value, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtGreaterThan(BigDecimal value) {
            addCriterion("DELIVERY_AMT >", value, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMT >=", value, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtLessThan(BigDecimal value) {
            addCriterion("DELIVERY_AMT <", value, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_AMT <=", value, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_AMT in", values, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtNotIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_AMT not in", values, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_AMT between", value1, value2, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_AMT not between", value1, value2, "deliveryAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtIsNull() {
            addCriterion("BALANCE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtIsNotNull() {
            addCriterion("BALANCE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtEqualTo(BigDecimal value) {
            addCriterion("BALANCE_AMT =", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtNotEqualTo(BigDecimal value) {
            addCriterion("BALANCE_AMT <>", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtGreaterThan(BigDecimal value) {
            addCriterion("BALANCE_AMT >", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE_AMT >=", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtLessThan(BigDecimal value) {
            addCriterion("BALANCE_AMT <", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE_AMT <=", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtIn(List<BigDecimal> values) {
            addCriterion("BALANCE_AMT in", values, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtNotIn(List<BigDecimal> values) {
            addCriterion("BALANCE_AMT not in", values, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE_AMT between", value1, value2, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE_AMT not between", value1, value2, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateIsNull() {
            addCriterion("PRICE_DROP_RATE is null");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateIsNotNull() {
            addCriterion("PRICE_DROP_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE =", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateNotEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE <>", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateGreaterThan(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE >", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE >=", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateLessThan(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE <", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE <=", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateIn(List<BigDecimal> values) {
            addCriterion("PRICE_DROP_RATE in", values, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateNotIn(List<BigDecimal> values) {
            addCriterion("PRICE_DROP_RATE not in", values, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_DROP_RATE between", value1, value2, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_DROP_RATE not between", value1, value2, "priceDropRate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}