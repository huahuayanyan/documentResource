package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcMtgStorDeliExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcMtgStorDeliExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcMtgStorDeliExample(BPbcMtgStorDeliExample example) {
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

        public Criteria andOtherProtocolNoIsNull() {
            addCriterion("OTHER_PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIsNotNull() {
            addCriterion("OTHER_PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO =", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO <>", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoGreaterThan(String value) {
            addCriterion("OTHER_PROTOCOL_NO >", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO >=", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLessThan(String value) {
            addCriterion("OTHER_PROTOCOL_NO <", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO <=", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLike(String value) {
            addCriterion("OTHER_PROTOCOL_NO like", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotLike(String value) {
            addCriterion("OTHER_PROTOCOL_NO not like", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIn(List<String> values) {
            addCriterion("OTHER_PROTOCOL_NO in", values, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotIn(List<String> values) {
            addCriterion("OTHER_PROTOCOL_NO not in", values, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoBetween(String value1, String value2) {
            addCriterion("OTHER_PROTOCOL_NO between", value1, value2, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotBetween(String value1, String value2) {
            addCriterion("OTHER_PROTOCOL_NO not between", value1, value2, "otherProtocolNo");
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

        public Criteria andTxtimeIsNull() {
            addCriterion("TXTIME is null");
            return (Criteria) this;
        }

        public Criteria andTxtimeIsNotNull() {
            addCriterion("TXTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTxtimeEqualTo(Date value) {
            addCriterion("TXTIME =", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotEqualTo(Date value) {
            addCriterion("TXTIME <>", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeGreaterThan(Date value) {
            addCriterion("TXTIME >", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TXTIME >=", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeLessThan(Date value) {
            addCriterion("TXTIME <", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeLessThanOrEqualTo(Date value) {
            addCriterion("TXTIME <=", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeIn(List<Date> values) {
            addCriterion("TXTIME in", values, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotIn(List<Date> values) {
            addCriterion("TXTIME not in", values, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeBetween(Date value1, Date value2) {
            addCriterion("TXTIME between", value1, value2, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotBetween(Date value1, Date value2) {
            addCriterion("TXTIME not between", value1, value2, "txtime");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliIsNull() {
            addCriterion("STOR_OR_DELI is null");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliIsNotNull() {
            addCriterion("STOR_OR_DELI is not null");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliEqualTo(String value) {
            addCriterion("STOR_OR_DELI =", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliNotEqualTo(String value) {
            addCriterion("STOR_OR_DELI <>", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliGreaterThan(String value) {
            addCriterion("STOR_OR_DELI >", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliGreaterThanOrEqualTo(String value) {
            addCriterion("STOR_OR_DELI >=", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliLessThan(String value) {
            addCriterion("STOR_OR_DELI <", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliLessThanOrEqualTo(String value) {
            addCriterion("STOR_OR_DELI <=", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliLike(String value) {
            addCriterion("STOR_OR_DELI like", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliNotLike(String value) {
            addCriterion("STOR_OR_DELI not like", value, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliIn(List<String> values) {
            addCriterion("STOR_OR_DELI in", values, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliNotIn(List<String> values) {
            addCriterion("STOR_OR_DELI not in", values, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliBetween(String value1, String value2) {
            addCriterion("STOR_OR_DELI between", value1, value2, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorOrDeliNotBetween(String value1, String value2) {
            addCriterion("STOR_OR_DELI not between", value1, value2, "storOrDeli");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeIsNull() {
            addCriterion("STOR_DELI_BIZ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeIsNotNull() {
            addCriterion("STOR_DELI_BIZ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeEqualTo(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE =", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeNotEqualTo(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE <>", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeGreaterThan(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE >", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE >=", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeLessThan(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE <", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeLessThanOrEqualTo(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE <=", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeLike(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE like", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeNotLike(String value) {
            addCriterion("STOR_DELI_BIZ_TYPE not like", value, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeIn(List<String> values) {
            addCriterion("STOR_DELI_BIZ_TYPE in", values, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeNotIn(List<String> values) {
            addCriterion("STOR_DELI_BIZ_TYPE not in", values, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeBetween(String value1, String value2) {
            addCriterion("STOR_DELI_BIZ_TYPE between", value1, value2, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andStorDeliBizTypeNotBetween(String value1, String value2) {
            addCriterion("STOR_DELI_BIZ_TYPE not between", value1, value2, "storDeliBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoIsNull() {
            addCriterion("MORTGAGE_BIZ_NO is null");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoIsNotNull() {
            addCriterion("MORTGAGE_BIZ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_BIZ_NO =", value, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoNotEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_BIZ_NO <>", value, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoGreaterThan(BigDecimal value) {
            addCriterion("MORTGAGE_BIZ_NO >", value, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_BIZ_NO >=", value, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoLessThan(BigDecimal value) {
            addCriterion("MORTGAGE_BIZ_NO <", value, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_BIZ_NO <=", value, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoIn(List<BigDecimal> values) {
            addCriterion("MORTGAGE_BIZ_NO in", values, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoNotIn(List<BigDecimal> values) {
            addCriterion("MORTGAGE_BIZ_NO not in", values, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORTGAGE_BIZ_NO between", value1, value2, "mortgageBizNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizNoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORTGAGE_BIZ_NO not between", value1, value2, "mortgageBizNo");
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

        public Criteria andBillnoIsNull() {
            addCriterion("BILLNO is null");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNotNull() {
            addCriterion("BILLNO is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoEqualTo(String value) {
            addCriterion("BILLNO =", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotEqualTo(String value) {
            addCriterion("BILLNO <>", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThan(String value) {
            addCriterion("BILLNO >", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThanOrEqualTo(String value) {
            addCriterion("BILLNO >=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThan(String value) {
            addCriterion("BILLNO <", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThanOrEqualTo(String value) {
            addCriterion("BILLNO <=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLike(String value) {
            addCriterion("BILLNO like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotLike(String value) {
            addCriterion("BILLNO not like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoIn(List<String> values) {
            addCriterion("BILLNO in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotIn(List<String> values) {
            addCriterion("BILLNO not in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoBetween(String value1, String value2) {
            addCriterion("BILLNO between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotBetween(String value1, String value2) {
            addCriterion("BILLNO not between", value1, value2, "billno");
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

        public Criteria andCreditamtIsNull() {
            addCriterion("CREDITAMT is null");
            return (Criteria) this;
        }

        public Criteria andCreditamtIsNotNull() {
            addCriterion("CREDITAMT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditamtEqualTo(BigDecimal value) {
            addCriterion("CREDITAMT =", value, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtNotEqualTo(BigDecimal value) {
            addCriterion("CREDITAMT <>", value, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtGreaterThan(BigDecimal value) {
            addCriterion("CREDITAMT >", value, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDITAMT >=", value, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtLessThan(BigDecimal value) {
            addCriterion("CREDITAMT <", value, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDITAMT <=", value, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtIn(List<BigDecimal> values) {
            addCriterion("CREDITAMT in", values, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtNotIn(List<BigDecimal> values) {
            addCriterion("CREDITAMT not in", values, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDITAMT between", value1, value2, "creditamt");
            return (Criteria) this;
        }

        public Criteria andCreditamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDITAMT not between", value1, value2, "creditamt");
            return (Criteria) this;
        }

        public Criteria andStockamtIsNull() {
            addCriterion("STOCKAMT is null");
            return (Criteria) this;
        }

        public Criteria andStockamtIsNotNull() {
            addCriterion("STOCKAMT is not null");
            return (Criteria) this;
        }

        public Criteria andStockamtEqualTo(BigDecimal value) {
            addCriterion("STOCKAMT =", value, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtNotEqualTo(BigDecimal value) {
            addCriterion("STOCKAMT <>", value, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtGreaterThan(BigDecimal value) {
            addCriterion("STOCKAMT >", value, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STOCKAMT >=", value, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtLessThan(BigDecimal value) {
            addCriterion("STOCKAMT <", value, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STOCKAMT <=", value, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtIn(List<BigDecimal> values) {
            addCriterion("STOCKAMT in", values, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtNotIn(List<BigDecimal> values) {
            addCriterion("STOCKAMT not in", values, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STOCKAMT between", value1, value2, "stockamt");
            return (Criteria) this;
        }

        public Criteria andStockamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STOCKAMT not between", value1, value2, "stockamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtIsNull() {
            addCriterion("RISKAMT is null");
            return (Criteria) this;
        }

        public Criteria andRiskamtIsNotNull() {
            addCriterion("RISKAMT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskamtEqualTo(BigDecimal value) {
            addCriterion("RISKAMT =", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtNotEqualTo(BigDecimal value) {
            addCriterion("RISKAMT <>", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtGreaterThan(BigDecimal value) {
            addCriterion("RISKAMT >", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISKAMT >=", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtLessThan(BigDecimal value) {
            addCriterion("RISKAMT <", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISKAMT <=", value, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtIn(List<BigDecimal> values) {
            addCriterion("RISKAMT in", values, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtNotIn(List<BigDecimal> values) {
            addCriterion("RISKAMT not in", values, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISKAMT between", value1, value2, "riskamt");
            return (Criteria) this;
        }

        public Criteria andRiskamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISKAMT not between", value1, value2, "riskamt");
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

        public Criteria andFreightareaIsNull() {
            addCriterion("FREIGHTAREA is null");
            return (Criteria) this;
        }

        public Criteria andFreightareaIsNotNull() {
            addCriterion("FREIGHTAREA is not null");
            return (Criteria) this;
        }

        public Criteria andFreightareaEqualTo(String value) {
            addCriterion("FREIGHTAREA =", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotEqualTo(String value) {
            addCriterion("FREIGHTAREA <>", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaGreaterThan(String value) {
            addCriterion("FREIGHTAREA >", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaGreaterThanOrEqualTo(String value) {
            addCriterion("FREIGHTAREA >=", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaLessThan(String value) {
            addCriterion("FREIGHTAREA <", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaLessThanOrEqualTo(String value) {
            addCriterion("FREIGHTAREA <=", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaLike(String value) {
            addCriterion("FREIGHTAREA like", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotLike(String value) {
            addCriterion("FREIGHTAREA not like", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaIn(List<String> values) {
            addCriterion("FREIGHTAREA in", values, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotIn(List<String> values) {
            addCriterion("FREIGHTAREA not in", values, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaBetween(String value1, String value2) {
            addCriterion("FREIGHTAREA between", value1, value2, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotBetween(String value1, String value2) {
            addCriterion("FREIGHTAREA not between", value1, value2, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightlotIsNull() {
            addCriterion("FREIGHTLOT is null");
            return (Criteria) this;
        }

        public Criteria andFreightlotIsNotNull() {
            addCriterion("FREIGHTLOT is not null");
            return (Criteria) this;
        }

        public Criteria andFreightlotEqualTo(String value) {
            addCriterion("FREIGHTLOT =", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotEqualTo(String value) {
            addCriterion("FREIGHTLOT <>", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotGreaterThan(String value) {
            addCriterion("FREIGHTLOT >", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotGreaterThanOrEqualTo(String value) {
            addCriterion("FREIGHTLOT >=", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotLessThan(String value) {
            addCriterion("FREIGHTLOT <", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotLessThanOrEqualTo(String value) {
            addCriterion("FREIGHTLOT <=", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotLike(String value) {
            addCriterion("FREIGHTLOT like", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotLike(String value) {
            addCriterion("FREIGHTLOT not like", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotIn(List<String> values) {
            addCriterion("FREIGHTLOT in", values, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotIn(List<String> values) {
            addCriterion("FREIGHTLOT not in", values, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotBetween(String value1, String value2) {
            addCriterion("FREIGHTLOT between", value1, value2, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotBetween(String value1, String value2) {
            addCriterion("FREIGHTLOT not between", value1, value2, "freightlot");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNull() {
            addCriterion("WAREHOUSE is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNotNull() {
            addCriterion("WAREHOUSE is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEqualTo(String value) {
            addCriterion("WAREHOUSE =", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotEqualTo(String value) {
            addCriterion("WAREHOUSE <>", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThan(String value) {
            addCriterion("WAREHOUSE >", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE >=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThan(String value) {
            addCriterion("WAREHOUSE <", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE <=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLike(String value) {
            addCriterion("WAREHOUSE like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotLike(String value) {
            addCriterion("WAREHOUSE not like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseIn(List<String> values) {
            addCriterion("WAREHOUSE in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotIn(List<String> values) {
            addCriterion("WAREHOUSE not in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseBetween(String value1, String value2) {
            addCriterion("WAREHOUSE between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE not between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIsNull() {
            addCriterion("WEIGHT_UNITS is null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIsNotNull() {
            addCriterion("WEIGHT_UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsEqualTo(String value) {
            addCriterion("WEIGHT_UNITS =", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotEqualTo(String value) {
            addCriterion("WEIGHT_UNITS <>", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThan(String value) {
            addCriterion("WEIGHT_UNITS >", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNITS >=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThan(String value) {
            addCriterion("WEIGHT_UNITS <", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNITS <=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLike(String value) {
            addCriterion("WEIGHT_UNITS like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotLike(String value) {
            addCriterion("WEIGHT_UNITS not like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIn(List<String> values) {
            addCriterion("WEIGHT_UNITS in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotIn(List<String> values) {
            addCriterion("WEIGHT_UNITS not in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNITS between", value1, value2, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNITS not between", value1, value2, "weightUnits");
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

        public Criteria andExt3IsNull() {
            addCriterion("EXT3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("EXT3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("EXT3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("EXT3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("EXT3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("EXT3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("EXT3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("EXT3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("EXT3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("EXT3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("EXT3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("EXT3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("EXT3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("EXT3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}