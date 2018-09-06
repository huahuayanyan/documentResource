package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcMtgChkStockInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcMtgChkStockInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcMtgChkStockInfoExample(BPbcMtgChkStockInfoExample example) {
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

        public Criteria andCheckStockDateIsNull() {
            addCriterion("CHECK_STOCK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateIsNotNull() {
            addCriterion("CHECK_STOCK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateEqualTo(String value) {
            addCriterion("CHECK_STOCK_DATE =", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateNotEqualTo(String value) {
            addCriterion("CHECK_STOCK_DATE <>", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateGreaterThan(String value) {
            addCriterion("CHECK_STOCK_DATE >", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_DATE >=", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateLessThan(String value) {
            addCriterion("CHECK_STOCK_DATE <", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_DATE <=", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateLike(String value) {
            addCriterion("CHECK_STOCK_DATE like", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateNotLike(String value) {
            addCriterion("CHECK_STOCK_DATE not like", value, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateIn(List<String> values) {
            addCriterion("CHECK_STOCK_DATE in", values, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateNotIn(List<String> values) {
            addCriterion("CHECK_STOCK_DATE not in", values, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_DATE between", value1, value2, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockDateNotBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_DATE not between", value1, value2, "checkStockDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeIsNull() {
            addCriterion("CHECK_STOCK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeIsNotNull() {
            addCriterion("CHECK_STOCK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeEqualTo(Date value) {
            addCriterion("CHECK_STOCK_TIME =", value, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeNotEqualTo(Date value) {
            addCriterion("CHECK_STOCK_TIME <>", value, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeGreaterThan(Date value) {
            addCriterion("CHECK_STOCK_TIME >", value, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_STOCK_TIME >=", value, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeLessThan(Date value) {
            addCriterion("CHECK_STOCK_TIME <", value, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_STOCK_TIME <=", value, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeIn(List<Date> values) {
            addCriterion("CHECK_STOCK_TIME in", values, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeNotIn(List<Date> values) {
            addCriterion("CHECK_STOCK_TIME not in", values, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_STOCK_TIME between", value1, value2, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_STOCK_TIME not between", value1, value2, "checkStockTime");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdIsNull() {
            addCriterion("CHECK_STOCK_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdIsNotNull() {
            addCriterion("CHECK_STOCK_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdEqualTo(String value) {
            addCriterion("CHECK_STOCK_TLRCD =", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdNotEqualTo(String value) {
            addCriterion("CHECK_STOCK_TLRCD <>", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdGreaterThan(String value) {
            addCriterion("CHECK_STOCK_TLRCD >", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_TLRCD >=", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdLessThan(String value) {
            addCriterion("CHECK_STOCK_TLRCD <", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_TLRCD <=", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdLike(String value) {
            addCriterion("CHECK_STOCK_TLRCD like", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdNotLike(String value) {
            addCriterion("CHECK_STOCK_TLRCD not like", value, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdIn(List<String> values) {
            addCriterion("CHECK_STOCK_TLRCD in", values, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdNotIn(List<String> values) {
            addCriterion("CHECK_STOCK_TLRCD not in", values, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_TLRCD between", value1, value2, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTlrcdNotBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_TLRCD not between", value1, value2, "checkStockTlrcd");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeIsNull() {
            addCriterion("CHECK_STOCK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeIsNotNull() {
            addCriterion("CHECK_STOCK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeEqualTo(String value) {
            addCriterion("CHECK_STOCK_TYPE =", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeNotEqualTo(String value) {
            addCriterion("CHECK_STOCK_TYPE <>", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeGreaterThan(String value) {
            addCriterion("CHECK_STOCK_TYPE >", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_TYPE >=", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeLessThan(String value) {
            addCriterion("CHECK_STOCK_TYPE <", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_TYPE <=", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeLike(String value) {
            addCriterion("CHECK_STOCK_TYPE like", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeNotLike(String value) {
            addCriterion("CHECK_STOCK_TYPE not like", value, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeIn(List<String> values) {
            addCriterion("CHECK_STOCK_TYPE in", values, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeNotIn(List<String> values) {
            addCriterion("CHECK_STOCK_TYPE not in", values, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_TYPE between", value1, value2, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_TYPE not between", value1, value2, "checkStockType");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayIsNull() {
            addCriterion("CHECK_STOCK_WAY is null");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayIsNotNull() {
            addCriterion("CHECK_STOCK_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayEqualTo(String value) {
            addCriterion("CHECK_STOCK_WAY =", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayNotEqualTo(String value) {
            addCriterion("CHECK_STOCK_WAY <>", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayGreaterThan(String value) {
            addCriterion("CHECK_STOCK_WAY >", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_WAY >=", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayLessThan(String value) {
            addCriterion("CHECK_STOCK_WAY <", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_WAY <=", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayLike(String value) {
            addCriterion("CHECK_STOCK_WAY like", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayNotLike(String value) {
            addCriterion("CHECK_STOCK_WAY not like", value, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayIn(List<String> values) {
            addCriterion("CHECK_STOCK_WAY in", values, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayNotIn(List<String> values) {
            addCriterion("CHECK_STOCK_WAY not in", values, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_WAY between", value1, value2, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockWayNotBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_WAY not between", value1, value2, "checkStockWay");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsIsNull() {
            addCriterion("CHECK_STOCK_RESULTS is null");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsIsNotNull() {
            addCriterion("CHECK_STOCK_RESULTS is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsEqualTo(String value) {
            addCriterion("CHECK_STOCK_RESULTS =", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsNotEqualTo(String value) {
            addCriterion("CHECK_STOCK_RESULTS <>", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsGreaterThan(String value) {
            addCriterion("CHECK_STOCK_RESULTS >", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_RESULTS >=", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsLessThan(String value) {
            addCriterion("CHECK_STOCK_RESULTS <", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_RESULTS <=", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsLike(String value) {
            addCriterion("CHECK_STOCK_RESULTS like", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsNotLike(String value) {
            addCriterion("CHECK_STOCK_RESULTS not like", value, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsIn(List<String> values) {
            addCriterion("CHECK_STOCK_RESULTS in", values, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsNotIn(List<String> values) {
            addCriterion("CHECK_STOCK_RESULTS not in", values, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_RESULTS between", value1, value2, "checkStockResults");
            return (Criteria) this;
        }

        public Criteria andCheckStockResultsNotBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_RESULTS not between", value1, value2, "checkStockResults");
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

        public Criteria andWarehouseIdIsNull() {
            addCriterion("WAREHOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNotNull() {
            addCriterion("WAREHOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdEqualTo(String value) {
            addCriterion("WAREHOUSE_ID =", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotEqualTo(String value) {
            addCriterion("WAREHOUSE_ID <>", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThan(String value) {
            addCriterion("WAREHOUSE_ID >", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ID >=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThan(String value) {
            addCriterion("WAREHOUSE_ID <", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ID <=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLike(String value) {
            addCriterion("WAREHOUSE_ID like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotLike(String value) {
            addCriterion("WAREHOUSE_ID not like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIn(List<String> values) {
            addCriterion("WAREHOUSE_ID in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotIn(List<String> values) {
            addCriterion("WAREHOUSE_ID not in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ID between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ID not between", value1, value2, "warehouseId");
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

        public Criteria andPowerCheckTypeIsNull() {
            addCriterion("POWER_CHECK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeIsNotNull() {
            addCriterion("POWER_CHECK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeEqualTo(String value) {
            addCriterion("POWER_CHECK_TYPE =", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeNotEqualTo(String value) {
            addCriterion("POWER_CHECK_TYPE <>", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeGreaterThan(String value) {
            addCriterion("POWER_CHECK_TYPE >", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeGreaterThanOrEqualTo(String value) {
            addCriterion("POWER_CHECK_TYPE >=", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeLessThan(String value) {
            addCriterion("POWER_CHECK_TYPE <", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeLessThanOrEqualTo(String value) {
            addCriterion("POWER_CHECK_TYPE <=", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeLike(String value) {
            addCriterion("POWER_CHECK_TYPE like", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeNotLike(String value) {
            addCriterion("POWER_CHECK_TYPE not like", value, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeIn(List<String> values) {
            addCriterion("POWER_CHECK_TYPE in", values, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeNotIn(List<String> values) {
            addCriterion("POWER_CHECK_TYPE not in", values, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeBetween(String value1, String value2) {
            addCriterion("POWER_CHECK_TYPE between", value1, value2, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckTypeNotBetween(String value1, String value2) {
            addCriterion("POWER_CHECK_TYPE not between", value1, value2, "powerCheckType");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesIsNull() {
            addCriterion("POWER_CHECK_FAILDES is null");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesIsNotNull() {
            addCriterion("POWER_CHECK_FAILDES is not null");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesEqualTo(String value) {
            addCriterion("POWER_CHECK_FAILDES =", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesNotEqualTo(String value) {
            addCriterion("POWER_CHECK_FAILDES <>", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesGreaterThan(String value) {
            addCriterion("POWER_CHECK_FAILDES >", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesGreaterThanOrEqualTo(String value) {
            addCriterion("POWER_CHECK_FAILDES >=", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesLessThan(String value) {
            addCriterion("POWER_CHECK_FAILDES <", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesLessThanOrEqualTo(String value) {
            addCriterion("POWER_CHECK_FAILDES <=", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesLike(String value) {
            addCriterion("POWER_CHECK_FAILDES like", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesNotLike(String value) {
            addCriterion("POWER_CHECK_FAILDES not like", value, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesIn(List<String> values) {
            addCriterion("POWER_CHECK_FAILDES in", values, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesNotIn(List<String> values) {
            addCriterion("POWER_CHECK_FAILDES not in", values, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesBetween(String value1, String value2) {
            addCriterion("POWER_CHECK_FAILDES between", value1, value2, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckFaildesNotBetween(String value1, String value2) {
            addCriterion("POWER_CHECK_FAILDES not between", value1, value2, "powerCheckFaildes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesIsNull() {
            addCriterion("POWER_CHECK_OTHERDES is null");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesIsNotNull() {
            addCriterion("POWER_CHECK_OTHERDES is not null");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesEqualTo(String value) {
            addCriterion("POWER_CHECK_OTHERDES =", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesNotEqualTo(String value) {
            addCriterion("POWER_CHECK_OTHERDES <>", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesGreaterThan(String value) {
            addCriterion("POWER_CHECK_OTHERDES >", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesGreaterThanOrEqualTo(String value) {
            addCriterion("POWER_CHECK_OTHERDES >=", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesLessThan(String value) {
            addCriterion("POWER_CHECK_OTHERDES <", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesLessThanOrEqualTo(String value) {
            addCriterion("POWER_CHECK_OTHERDES <=", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesLike(String value) {
            addCriterion("POWER_CHECK_OTHERDES like", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesNotLike(String value) {
            addCriterion("POWER_CHECK_OTHERDES not like", value, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesIn(List<String> values) {
            addCriterion("POWER_CHECK_OTHERDES in", values, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesNotIn(List<String> values) {
            addCriterion("POWER_CHECK_OTHERDES not in", values, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesBetween(String value1, String value2) {
            addCriterion("POWER_CHECK_OTHERDES between", value1, value2, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andPowerCheckOtherdesNotBetween(String value1, String value2) {
            addCriterion("POWER_CHECK_OTHERDES not between", value1, value2, "powerCheckOtherdes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeIsNull() {
            addCriterion("CHECK_ADDRESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeIsNotNull() {
            addCriterion("CHECK_ADDRESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_TYPE =", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeNotEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_TYPE <>", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeGreaterThan(String value) {
            addCriterion("CHECK_ADDRESS_TYPE >", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_TYPE >=", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeLessThan(String value) {
            addCriterion("CHECK_ADDRESS_TYPE <", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_TYPE <=", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeLike(String value) {
            addCriterion("CHECK_ADDRESS_TYPE like", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeNotLike(String value) {
            addCriterion("CHECK_ADDRESS_TYPE not like", value, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeIn(List<String> values) {
            addCriterion("CHECK_ADDRESS_TYPE in", values, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeNotIn(List<String> values) {
            addCriterion("CHECK_ADDRESS_TYPE not in", values, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeBetween(String value1, String value2) {
            addCriterion("CHECK_ADDRESS_TYPE between", value1, value2, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_ADDRESS_TYPE not between", value1, value2, "checkAddressType");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesIsNull() {
            addCriterion("CHECK_ADDRESS_FAILDES is null");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesIsNotNull() {
            addCriterion("CHECK_ADDRESS_FAILDES is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES =", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesNotEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES <>", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesGreaterThan(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES >", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES >=", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesLessThan(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES <", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesLessThanOrEqualTo(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES <=", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesLike(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES like", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesNotLike(String value) {
            addCriterion("CHECK_ADDRESS_FAILDES not like", value, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesIn(List<String> values) {
            addCriterion("CHECK_ADDRESS_FAILDES in", values, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesNotIn(List<String> values) {
            addCriterion("CHECK_ADDRESS_FAILDES not in", values, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesBetween(String value1, String value2) {
            addCriterion("CHECK_ADDRESS_FAILDES between", value1, value2, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckAddressFaildesNotBetween(String value1, String value2) {
            addCriterion("CHECK_ADDRESS_FAILDES not between", value1, value2, "checkAddressFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeIsNull() {
            addCriterion("CHECK_NEED_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeIsNotNull() {
            addCriterion("CHECK_NEED_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeEqualTo(String value) {
            addCriterion("CHECK_NEED_TYPE =", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeNotEqualTo(String value) {
            addCriterion("CHECK_NEED_TYPE <>", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeGreaterThan(String value) {
            addCriterion("CHECK_NEED_TYPE >", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_NEED_TYPE >=", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeLessThan(String value) {
            addCriterion("CHECK_NEED_TYPE <", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_NEED_TYPE <=", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeLike(String value) {
            addCriterion("CHECK_NEED_TYPE like", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeNotLike(String value) {
            addCriterion("CHECK_NEED_TYPE not like", value, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeIn(List<String> values) {
            addCriterion("CHECK_NEED_TYPE in", values, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeNotIn(List<String> values) {
            addCriterion("CHECK_NEED_TYPE not in", values, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeBetween(String value1, String value2) {
            addCriterion("CHECK_NEED_TYPE between", value1, value2, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckNeedTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_NEED_TYPE not between", value1, value2, "checkNeedType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeIsNull() {
            addCriterion("CHECK_METHOD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeIsNotNull() {
            addCriterion("CHECK_METHOD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeEqualTo(String value) {
            addCriterion("CHECK_METHOD_TYPE =", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeNotEqualTo(String value) {
            addCriterion("CHECK_METHOD_TYPE <>", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeGreaterThan(String value) {
            addCriterion("CHECK_METHOD_TYPE >", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_METHOD_TYPE >=", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeLessThan(String value) {
            addCriterion("CHECK_METHOD_TYPE <", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_METHOD_TYPE <=", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeLike(String value) {
            addCriterion("CHECK_METHOD_TYPE like", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeNotLike(String value) {
            addCriterion("CHECK_METHOD_TYPE not like", value, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeIn(List<String> values) {
            addCriterion("CHECK_METHOD_TYPE in", values, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeNotIn(List<String> values) {
            addCriterion("CHECK_METHOD_TYPE not in", values, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeBetween(String value1, String value2) {
            addCriterion("CHECK_METHOD_TYPE between", value1, value2, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_METHOD_TYPE not between", value1, value2, "checkMethodType");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataIsNull() {
            addCriterion("CHECK_METHOD_DATA is null");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataIsNotNull() {
            addCriterion("CHECK_METHOD_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataEqualTo(BigDecimal value) {
            addCriterion("CHECK_METHOD_DATA =", value, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataNotEqualTo(BigDecimal value) {
            addCriterion("CHECK_METHOD_DATA <>", value, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataGreaterThan(BigDecimal value) {
            addCriterion("CHECK_METHOD_DATA >", value, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHECK_METHOD_DATA >=", value, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataLessThan(BigDecimal value) {
            addCriterion("CHECK_METHOD_DATA <", value, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHECK_METHOD_DATA <=", value, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataIn(List<BigDecimal> values) {
            addCriterion("CHECK_METHOD_DATA in", values, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataNotIn(List<BigDecimal> values) {
            addCriterion("CHECK_METHOD_DATA not in", values, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHECK_METHOD_DATA between", value1, value2, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckMethodDataNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHECK_METHOD_DATA not between", value1, value2, "checkMethodData");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeIsNull() {
            addCriterion("CHECK_RESULT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeIsNotNull() {
            addCriterion("CHECK_RESULT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeEqualTo(String value) {
            addCriterion("CHECK_RESULT_TYPE =", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeNotEqualTo(String value) {
            addCriterion("CHECK_RESULT_TYPE <>", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeGreaterThan(String value) {
            addCriterion("CHECK_RESULT_TYPE >", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT_TYPE >=", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeLessThan(String value) {
            addCriterion("CHECK_RESULT_TYPE <", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT_TYPE <=", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeLike(String value) {
            addCriterion("CHECK_RESULT_TYPE like", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeNotLike(String value) {
            addCriterion("CHECK_RESULT_TYPE not like", value, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeIn(List<String> values) {
            addCriterion("CHECK_RESULT_TYPE in", values, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeNotIn(List<String> values) {
            addCriterion("CHECK_RESULT_TYPE not in", values, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT_TYPE between", value1, value2, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT_TYPE not between", value1, value2, "checkResultType");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesIsNull() {
            addCriterion("CHECK_RESULT_FAILDES is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesIsNotNull() {
            addCriterion("CHECK_RESULT_FAILDES is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesEqualTo(String value) {
            addCriterion("CHECK_RESULT_FAILDES =", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesNotEqualTo(String value) {
            addCriterion("CHECK_RESULT_FAILDES <>", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesGreaterThan(String value) {
            addCriterion("CHECK_RESULT_FAILDES >", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT_FAILDES >=", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesLessThan(String value) {
            addCriterion("CHECK_RESULT_FAILDES <", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesLessThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT_FAILDES <=", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesLike(String value) {
            addCriterion("CHECK_RESULT_FAILDES like", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesNotLike(String value) {
            addCriterion("CHECK_RESULT_FAILDES not like", value, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesIn(List<String> values) {
            addCriterion("CHECK_RESULT_FAILDES in", values, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesNotIn(List<String> values) {
            addCriterion("CHECK_RESULT_FAILDES not in", values, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT_FAILDES between", value1, value2, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckResultFaildesNotBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT_FAILDES not between", value1, value2, "checkResultFaildes");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoIsNull() {
            addCriterion("CHECK_REPORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoIsNotNull() {
            addCriterion("CHECK_REPORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoEqualTo(String value) {
            addCriterion("CHECK_REPORT_NO =", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoNotEqualTo(String value) {
            addCriterion("CHECK_REPORT_NO <>", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoGreaterThan(String value) {
            addCriterion("CHECK_REPORT_NO >", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_REPORT_NO >=", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoLessThan(String value) {
            addCriterion("CHECK_REPORT_NO <", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoLessThanOrEqualTo(String value) {
            addCriterion("CHECK_REPORT_NO <=", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoLike(String value) {
            addCriterion("CHECK_REPORT_NO like", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoNotLike(String value) {
            addCriterion("CHECK_REPORT_NO not like", value, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoIn(List<String> values) {
            addCriterion("CHECK_REPORT_NO in", values, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoNotIn(List<String> values) {
            addCriterion("CHECK_REPORT_NO not in", values, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoBetween(String value1, String value2) {
            addCriterion("CHECK_REPORT_NO between", value1, value2, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCheckReportNoNotBetween(String value1, String value2) {
            addCriterion("CHECK_REPORT_NO not between", value1, value2, "checkReportNo");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtIsNull() {
            addCriterion("CURRENT_CREDIT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtIsNotNull() {
            addCriterion("CURRENT_CREDIT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtEqualTo(BigDecimal value) {
            addCriterion("CURRENT_CREDIT_AMT =", value, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtNotEqualTo(BigDecimal value) {
            addCriterion("CURRENT_CREDIT_AMT <>", value, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtGreaterThan(BigDecimal value) {
            addCriterion("CURRENT_CREDIT_AMT >", value, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_CREDIT_AMT >=", value, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtLessThan(BigDecimal value) {
            addCriterion("CURRENT_CREDIT_AMT <", value, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_CREDIT_AMT <=", value, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtIn(List<BigDecimal> values) {
            addCriterion("CURRENT_CREDIT_AMT in", values, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtNotIn(List<BigDecimal> values) {
            addCriterion("CURRENT_CREDIT_AMT not in", values, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_CREDIT_AMT between", value1, value2, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andCurrentCreditAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_CREDIT_AMT not between", value1, value2, "currentCreditAmt");
            return (Criteria) this;
        }

        public Criteria andRationIsNull() {
            addCriterion("RATION is null");
            return (Criteria) this;
        }

        public Criteria andRationIsNotNull() {
            addCriterion("RATION is not null");
            return (Criteria) this;
        }

        public Criteria andRationEqualTo(BigDecimal value) {
            addCriterion("RATION =", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotEqualTo(BigDecimal value) {
            addCriterion("RATION <>", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThan(BigDecimal value) {
            addCriterion("RATION >", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION >=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThan(BigDecimal value) {
            addCriterion("RATION <", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION <=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationIn(List<BigDecimal> values) {
            addCriterion("RATION in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotIn(List<BigDecimal> values) {
            addCriterion("RATION not in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION between", value1, value2, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION not between", value1, value2, "ration");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeIsNull() {
            addCriterion("CHECK_LOW_PRICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeIsNotNull() {
            addCriterion("CHECK_LOW_PRICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeEqualTo(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE =", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeNotEqualTo(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE <>", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeGreaterThan(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE >", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE >=", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeLessThan(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE <", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE <=", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeLike(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE like", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeNotLike(String value) {
            addCriterion("CHECK_LOW_PRICE_TYPE not like", value, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeIn(List<String> values) {
            addCriterion("CHECK_LOW_PRICE_TYPE in", values, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeNotIn(List<String> values) {
            addCriterion("CHECK_LOW_PRICE_TYPE not in", values, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeBetween(String value1, String value2) {
            addCriterion("CHECK_LOW_PRICE_TYPE between", value1, value2, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andCheckLowPriceTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_LOW_PRICE_TYPE not between", value1, value2, "checkLowPriceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagIsNull() {
            addCriterion("INVOICE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagIsNotNull() {
            addCriterion("INVOICE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagEqualTo(String value) {
            addCriterion("INVOICE_FLAG =", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagNotEqualTo(String value) {
            addCriterion("INVOICE_FLAG <>", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagGreaterThan(String value) {
            addCriterion("INVOICE_FLAG >", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_FLAG >=", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagLessThan(String value) {
            addCriterion("INVOICE_FLAG <", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_FLAG <=", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagLike(String value) {
            addCriterion("INVOICE_FLAG like", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagNotLike(String value) {
            addCriterion("INVOICE_FLAG not like", value, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagIn(List<String> values) {
            addCriterion("INVOICE_FLAG in", values, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagNotIn(List<String> values) {
            addCriterion("INVOICE_FLAG not in", values, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagBetween(String value1, String value2) {
            addCriterion("INVOICE_FLAG between", value1, value2, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceFlagNotBetween(String value1, String value2) {
            addCriterion("INVOICE_FLAG not between", value1, value2, "invoiceFlag");
            return (Criteria) this;
        }

        public Criteria andNoticeNoIsNull() {
            addCriterion("NOTICE_NO is null");
            return (Criteria) this;
        }

        public Criteria andNoticeNoIsNotNull() {
            addCriterion("NOTICE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeNoEqualTo(String value) {
            addCriterion("NOTICE_NO =", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoNotEqualTo(String value) {
            addCriterion("NOTICE_NO <>", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoGreaterThan(String value) {
            addCriterion("NOTICE_NO >", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_NO >=", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoLessThan(String value) {
            addCriterion("NOTICE_NO <", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_NO <=", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoLike(String value) {
            addCriterion("NOTICE_NO like", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoNotLike(String value) {
            addCriterion("NOTICE_NO not like", value, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoIn(List<String> values) {
            addCriterion("NOTICE_NO in", values, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoNotIn(List<String> values) {
            addCriterion("NOTICE_NO not in", values, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoBetween(String value1, String value2) {
            addCriterion("NOTICE_NO between", value1, value2, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andNoticeNoNotBetween(String value1, String value2) {
            addCriterion("NOTICE_NO not between", value1, value2, "noticeNo");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andAdviceidIsNull() {
            addCriterion("ADVICEID is null");
            return (Criteria) this;
        }

        public Criteria andAdviceidIsNotNull() {
            addCriterion("ADVICEID is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceidEqualTo(String value) {
            addCriterion("ADVICEID =", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidNotEqualTo(String value) {
            addCriterion("ADVICEID <>", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidGreaterThan(String value) {
            addCriterion("ADVICEID >", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidGreaterThanOrEqualTo(String value) {
            addCriterion("ADVICEID >=", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidLessThan(String value) {
            addCriterion("ADVICEID <", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidLessThanOrEqualTo(String value) {
            addCriterion("ADVICEID <=", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidLike(String value) {
            addCriterion("ADVICEID like", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidNotLike(String value) {
            addCriterion("ADVICEID not like", value, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidIn(List<String> values) {
            addCriterion("ADVICEID in", values, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidNotIn(List<String> values) {
            addCriterion("ADVICEID not in", values, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidBetween(String value1, String value2) {
            addCriterion("ADVICEID between", value1, value2, "adviceid");
            return (Criteria) this;
        }

        public Criteria andAdviceidNotBetween(String value1, String value2) {
            addCriterion("ADVICEID not between", value1, value2, "adviceid");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNull() {
            addCriterion("APPLYID is null");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNotNull() {
            addCriterion("APPLYID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyidEqualTo(String value) {
            addCriterion("APPLYID =", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotEqualTo(String value) {
            addCriterion("APPLYID <>", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThan(String value) {
            addCriterion("APPLYID >", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThanOrEqualTo(String value) {
            addCriterion("APPLYID >=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThan(String value) {
            addCriterion("APPLYID <", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThanOrEqualTo(String value) {
            addCriterion("APPLYID <=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLike(String value) {
            addCriterion("APPLYID like", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotLike(String value) {
            addCriterion("APPLYID not like", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidIn(List<String> values) {
            addCriterion("APPLYID in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotIn(List<String> values) {
            addCriterion("APPLYID not in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidBetween(String value1, String value2) {
            addCriterion("APPLYID between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotBetween(String value1, String value2) {
            addCriterion("APPLYID not between", value1, value2, "applyid");
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

        public Criteria andWarehouseNameIsNull() {
            addCriterion("WAREHOUSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNotNull() {
            addCriterion("WAREHOUSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME =", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME <>", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThan(String value) {
            addCriterion("WAREHOUSE_NAME >", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME >=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThan(String value) {
            addCriterion("WAREHOUSE_NAME <", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME <=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLike(String value) {
            addCriterion("WAREHOUSE_NAME like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotLike(String value) {
            addCriterion("WAREHOUSE_NAME not like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIn(List<String> values) {
            addCriterion("WAREHOUSE_NAME in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotIn(List<String> values) {
            addCriterion("WAREHOUSE_NAME not in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_NAME between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_NAME not between", value1, value2, "warehouseName");
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

        public Criteria andMoniPrincipalIsNull() {
            addCriterion("MONI_PRINCIPAL is null");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalIsNotNull() {
            addCriterion("MONI_PRINCIPAL is not null");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalEqualTo(String value) {
            addCriterion("MONI_PRINCIPAL =", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalNotEqualTo(String value) {
            addCriterion("MONI_PRINCIPAL <>", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalGreaterThan(String value) {
            addCriterion("MONI_PRINCIPAL >", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_PRINCIPAL >=", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalLessThan(String value) {
            addCriterion("MONI_PRINCIPAL <", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalLessThanOrEqualTo(String value) {
            addCriterion("MONI_PRINCIPAL <=", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalLike(String value) {
            addCriterion("MONI_PRINCIPAL like", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalNotLike(String value) {
            addCriterion("MONI_PRINCIPAL not like", value, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalIn(List<String> values) {
            addCriterion("MONI_PRINCIPAL in", values, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalNotIn(List<String> values) {
            addCriterion("MONI_PRINCIPAL not in", values, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalBetween(String value1, String value2) {
            addCriterion("MONI_PRINCIPAL between", value1, value2, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andMoniPrincipalNotBetween(String value1, String value2) {
            addCriterion("MONI_PRINCIPAL not between", value1, value2, "moniPrincipal");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateIsNull() {
            addCriterion("CHECK_STOCK_CONFIRM_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateIsNotNull() {
            addCriterion("CHECK_STOCK_CONFIRM_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateEqualTo(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE =", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateNotEqualTo(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE <>", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateGreaterThan(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE >", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE >=", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateLessThan(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE <", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE <=", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateLike(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE like", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateNotLike(String value) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE not like", value, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateIn(List<String> values) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE in", values, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateNotIn(List<String> values) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE not in", values, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE between", value1, value2, "checkStockConfirmDate");
            return (Criteria) this;
        }

        public Criteria andCheckStockConfirmDateNotBetween(String value1, String value2) {
            addCriterion("CHECK_STOCK_CONFIRM_DATE not between", value1, value2, "checkStockConfirmDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}