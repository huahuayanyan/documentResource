package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntMprotCmInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntMprotCmInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntMprotCmInfoExample(BCntMprotCmInfoExample example) {
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

        public Criteria andGroupedIsNull() {
            addCriterion("GROUPED is null");
            return (Criteria) this;
        }

        public Criteria andGroupedIsNotNull() {
            addCriterion("GROUPED is not null");
            return (Criteria) this;
        }

        public Criteria andGroupedEqualTo(String value) {
            addCriterion("GROUPED =", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedNotEqualTo(String value) {
            addCriterion("GROUPED <>", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedGreaterThan(String value) {
            addCriterion("GROUPED >", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPED >=", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedLessThan(String value) {
            addCriterion("GROUPED <", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedLessThanOrEqualTo(String value) {
            addCriterion("GROUPED <=", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedLike(String value) {
            addCriterion("GROUPED like", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedNotLike(String value) {
            addCriterion("GROUPED not like", value, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedIn(List<String> values) {
            addCriterion("GROUPED in", values, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedNotIn(List<String> values) {
            addCriterion("GROUPED not in", values, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedBetween(String value1, String value2) {
            addCriterion("GROUPED between", value1, value2, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedNotBetween(String value1, String value2) {
            addCriterion("GROUPED not between", value1, value2, "grouped");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberIsNull() {
            addCriterion("GROUPED_MEMBER is null");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberIsNotNull() {
            addCriterion("GROUPED_MEMBER is not null");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberEqualTo(String value) {
            addCriterion("GROUPED_MEMBER =", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberNotEqualTo(String value) {
            addCriterion("GROUPED_MEMBER <>", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberGreaterThan(String value) {
            addCriterion("GROUPED_MEMBER >", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPED_MEMBER >=", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberLessThan(String value) {
            addCriterion("GROUPED_MEMBER <", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberLessThanOrEqualTo(String value) {
            addCriterion("GROUPED_MEMBER <=", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberLike(String value) {
            addCriterion("GROUPED_MEMBER like", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberNotLike(String value) {
            addCriterion("GROUPED_MEMBER not like", value, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberIn(List<String> values) {
            addCriterion("GROUPED_MEMBER in", values, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberNotIn(List<String> values) {
            addCriterion("GROUPED_MEMBER not in", values, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberBetween(String value1, String value2) {
            addCriterion("GROUPED_MEMBER between", value1, value2, "groupedMember");
            return (Criteria) this;
        }

        public Criteria andGroupedMemberNotBetween(String value1, String value2) {
            addCriterion("GROUPED_MEMBER not between", value1, value2, "groupedMember");
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

        public Criteria andMoniWarehouseTypeIsNull() {
            addCriterion("MONI_WAREHOUSE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeIsNotNull() {
            addCriterion("MONI_WAREHOUSE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE =", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE <>", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeGreaterThan(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE >", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE >=", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeLessThan(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE <", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeLessThanOrEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE <=", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeLike(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE like", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotLike(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE not like", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeIn(List<String> values) {
            addCriterion("MONI_WAREHOUSE_TYPE in", values, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotIn(List<String> values) {
            addCriterion("MONI_WAREHOUSE_TYPE not in", values, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeBetween(String value1, String value2) {
            addCriterion("MONI_WAREHOUSE_TYPE between", value1, value2, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotBetween(String value1, String value2) {
            addCriterion("MONI_WAREHOUSE_TYPE not between", value1, value2, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeIsNull() {
            addCriterion("MONI_AREA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeIsNotNull() {
            addCriterion("MONI_AREA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeEqualTo(String value) {
            addCriterion("MONI_AREA_TYPE =", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeNotEqualTo(String value) {
            addCriterion("MONI_AREA_TYPE <>", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeGreaterThan(String value) {
            addCriterion("MONI_AREA_TYPE >", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_AREA_TYPE >=", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeLessThan(String value) {
            addCriterion("MONI_AREA_TYPE <", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeLessThanOrEqualTo(String value) {
            addCriterion("MONI_AREA_TYPE <=", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeLike(String value) {
            addCriterion("MONI_AREA_TYPE like", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeNotLike(String value) {
            addCriterion("MONI_AREA_TYPE not like", value, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeIn(List<String> values) {
            addCriterion("MONI_AREA_TYPE in", values, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeNotIn(List<String> values) {
            addCriterion("MONI_AREA_TYPE not in", values, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeBetween(String value1, String value2) {
            addCriterion("MONI_AREA_TYPE between", value1, value2, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andMoniAreaTypeNotBetween(String value1, String value2) {
            addCriterion("MONI_AREA_TYPE not between", value1, value2, "moniAreaType");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionIsNull() {
            addCriterion("LOGISTICS_MONI_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionIsNotNull() {
            addCriterion("LOGISTICS_MONI_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionEqualTo(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION =", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionNotEqualTo(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION <>", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionGreaterThan(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION >", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionGreaterThanOrEqualTo(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION >=", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionLessThan(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION <", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionLessThanOrEqualTo(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION <=", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionLike(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION like", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionNotLike(String value) {
            addCriterion("LOGISTICS_MONI_CONDITION not like", value, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionIn(List<String> values) {
            addCriterion("LOGISTICS_MONI_CONDITION in", values, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionNotIn(List<String> values) {
            addCriterion("LOGISTICS_MONI_CONDITION not in", values, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionBetween(String value1, String value2) {
            addCriterion("LOGISTICS_MONI_CONDITION between", value1, value2, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andLogisticsMoniConditionNotBetween(String value1, String value2) {
            addCriterion("LOGISTICS_MONI_CONDITION not between", value1, value2, "logisticsMoniCondition");
            return (Criteria) this;
        }

        public Criteria andWarehousedressIsNull() {
            addCriterion("WAREHOUSEDRESS is null");
            return (Criteria) this;
        }

        public Criteria andWarehousedressIsNotNull() {
            addCriterion("WAREHOUSEDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andWarehousedressEqualTo(String value) {
            addCriterion("WAREHOUSEDRESS =", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressNotEqualTo(String value) {
            addCriterion("WAREHOUSEDRESS <>", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressGreaterThan(String value) {
            addCriterion("WAREHOUSEDRESS >", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSEDRESS >=", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressLessThan(String value) {
            addCriterion("WAREHOUSEDRESS <", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSEDRESS <=", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressLike(String value) {
            addCriterion("WAREHOUSEDRESS like", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressNotLike(String value) {
            addCriterion("WAREHOUSEDRESS not like", value, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressIn(List<String> values) {
            addCriterion("WAREHOUSEDRESS in", values, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressNotIn(List<String> values) {
            addCriterion("WAREHOUSEDRESS not in", values, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressBetween(String value1, String value2) {
            addCriterion("WAREHOUSEDRESS between", value1, value2, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andWarehousedressNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSEDRESS not between", value1, value2, "warehousedress");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeIsNull() {
            addCriterion("MORTGAGE_PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeIsNotNull() {
            addCriterion("MORTGAGE_PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeEqualTo(String value) {
            addCriterion("MORTGAGE_PAY_TYPE =", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeNotEqualTo(String value) {
            addCriterion("MORTGAGE_PAY_TYPE <>", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeGreaterThan(String value) {
            addCriterion("MORTGAGE_PAY_TYPE >", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_PAY_TYPE >=", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeLessThan(String value) {
            addCriterion("MORTGAGE_PAY_TYPE <", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_PAY_TYPE <=", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeLike(String value) {
            addCriterion("MORTGAGE_PAY_TYPE like", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeNotLike(String value) {
            addCriterion("MORTGAGE_PAY_TYPE not like", value, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeIn(List<String> values) {
            addCriterion("MORTGAGE_PAY_TYPE in", values, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeNotIn(List<String> values) {
            addCriterion("MORTGAGE_PAY_TYPE not in", values, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeBetween(String value1, String value2) {
            addCriterion("MORTGAGE_PAY_TYPE between", value1, value2, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andMortgagePayTypeNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_PAY_TYPE not between", value1, value2, "mortgagePayType");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionIsNull() {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionIsNotNull() {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionEqualTo(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION =", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionNotEqualTo(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION <>", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionGreaterThan(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION >", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION >=", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionLessThan(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION <", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionLessThanOrEqualTo(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION <=", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionLike(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION like", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionNotLike(String value) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION not like", value, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionIn(List<String> values) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION in", values, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionNotIn(List<String> values) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION not in", values, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionBetween(String value1, String value2) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION between", value1, value2, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialWarehouseConditionNotBetween(String value1, String value2) {
            addCriterion("SPECIAL_WAREHOUSE_CONDITION not between", value1, value2, "specialWarehouseCondition");
            return (Criteria) this;
        }

        public Criteria andCostBearIsNull() {
            addCriterion("COST_BEAR is null");
            return (Criteria) this;
        }

        public Criteria andCostBearIsNotNull() {
            addCriterion("COST_BEAR is not null");
            return (Criteria) this;
        }

        public Criteria andCostBearEqualTo(String value) {
            addCriterion("COST_BEAR =", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearNotEqualTo(String value) {
            addCriterion("COST_BEAR <>", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearGreaterThan(String value) {
            addCriterion("COST_BEAR >", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearGreaterThanOrEqualTo(String value) {
            addCriterion("COST_BEAR >=", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearLessThan(String value) {
            addCriterion("COST_BEAR <", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearLessThanOrEqualTo(String value) {
            addCriterion("COST_BEAR <=", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearLike(String value) {
            addCriterion("COST_BEAR like", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearNotLike(String value) {
            addCriterion("COST_BEAR not like", value, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearIn(List<String> values) {
            addCriterion("COST_BEAR in", values, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearNotIn(List<String> values) {
            addCriterion("COST_BEAR not in", values, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearBetween(String value1, String value2) {
            addCriterion("COST_BEAR between", value1, value2, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostBearNotBetween(String value1, String value2) {
            addCriterion("COST_BEAR not between", value1, value2, "costBear");
            return (Criteria) this;
        }

        public Criteria andCostStandardIsNull() {
            addCriterion("COST_STANDARD is null");
            return (Criteria) this;
        }

        public Criteria andCostStandardIsNotNull() {
            addCriterion("COST_STANDARD is not null");
            return (Criteria) this;
        }

        public Criteria andCostStandardEqualTo(String value) {
            addCriterion("COST_STANDARD =", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotEqualTo(String value) {
            addCriterion("COST_STANDARD <>", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardGreaterThan(String value) {
            addCriterion("COST_STANDARD >", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardGreaterThanOrEqualTo(String value) {
            addCriterion("COST_STANDARD >=", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardLessThan(String value) {
            addCriterion("COST_STANDARD <", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardLessThanOrEqualTo(String value) {
            addCriterion("COST_STANDARD <=", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardLike(String value) {
            addCriterion("COST_STANDARD like", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotLike(String value) {
            addCriterion("COST_STANDARD not like", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardIn(List<String> values) {
            addCriterion("COST_STANDARD in", values, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotIn(List<String> values) {
            addCriterion("COST_STANDARD not in", values, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardBetween(String value1, String value2) {
            addCriterion("COST_STANDARD between", value1, value2, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotBetween(String value1, String value2) {
            addCriterion("COST_STANDARD not between", value1, value2, "costStandard");
            return (Criteria) this;
        }

        public Criteria andMoniCostIsNull() {
            addCriterion("MONI_COST is null");
            return (Criteria) this;
        }

        public Criteria andMoniCostIsNotNull() {
            addCriterion("MONI_COST is not null");
            return (Criteria) this;
        }

        public Criteria andMoniCostEqualTo(BigDecimal value) {
            addCriterion("MONI_COST =", value, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostNotEqualTo(BigDecimal value) {
            addCriterion("MONI_COST <>", value, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostGreaterThan(BigDecimal value) {
            addCriterion("MONI_COST >", value, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONI_COST >=", value, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostLessThan(BigDecimal value) {
            addCriterion("MONI_COST <", value, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONI_COST <=", value, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostIn(List<BigDecimal> values) {
            addCriterion("MONI_COST in", values, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostNotIn(List<BigDecimal> values) {
            addCriterion("MONI_COST not in", values, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONI_COST between", value1, value2, "moniCost");
            return (Criteria) this;
        }

        public Criteria andMoniCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONI_COST not between", value1, value2, "moniCost");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNull() {
            addCriterion("PAY_WAY is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("PAY_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(String value) {
            addCriterion("PAY_WAY =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(String value) {
            addCriterion("PAY_WAY <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(String value) {
            addCriterion("PAY_WAY >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_WAY >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(String value) {
            addCriterion("PAY_WAY <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(String value) {
            addCriterion("PAY_WAY <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLike(String value) {
            addCriterion("PAY_WAY like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotLike(String value) {
            addCriterion("PAY_WAY not like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<String> values) {
            addCriterion("PAY_WAY in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<String> values) {
            addCriterion("PAY_WAY not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(String value1, String value2) {
            addCriterion("PAY_WAY between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(String value1, String value2) {
            addCriterion("PAY_WAY not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("PAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("PAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("PAY_TIME =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("PAY_TIME <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("PAY_TIME >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PAY_TIME >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("PAY_TIME <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("PAY_TIME <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("PAY_TIME in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("PAY_TIME not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("PAY_TIME between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("PAY_TIME not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andMoniNameIsNull() {
            addCriterion("MONI_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMoniNameIsNotNull() {
            addCriterion("MONI_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMoniNameEqualTo(String value) {
            addCriterion("MONI_NAME =", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameNotEqualTo(String value) {
            addCriterion("MONI_NAME <>", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameGreaterThan(String value) {
            addCriterion("MONI_NAME >", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_NAME >=", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameLessThan(String value) {
            addCriterion("MONI_NAME <", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameLessThanOrEqualTo(String value) {
            addCriterion("MONI_NAME <=", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameLike(String value) {
            addCriterion("MONI_NAME like", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameNotLike(String value) {
            addCriterion("MONI_NAME not like", value, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameIn(List<String> values) {
            addCriterion("MONI_NAME in", values, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameNotIn(List<String> values) {
            addCriterion("MONI_NAME not in", values, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameBetween(String value1, String value2) {
            addCriterion("MONI_NAME between", value1, value2, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniNameNotBetween(String value1, String value2) {
            addCriterion("MONI_NAME not between", value1, value2, "moniName");
            return (Criteria) this;
        }

        public Criteria andMoniTelIsNull() {
            addCriterion("MONI_TEL is null");
            return (Criteria) this;
        }

        public Criteria andMoniTelIsNotNull() {
            addCriterion("MONI_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andMoniTelEqualTo(String value) {
            addCriterion("MONI_TEL =", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelNotEqualTo(String value) {
            addCriterion("MONI_TEL <>", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelGreaterThan(String value) {
            addCriterion("MONI_TEL >", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_TEL >=", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelLessThan(String value) {
            addCriterion("MONI_TEL <", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelLessThanOrEqualTo(String value) {
            addCriterion("MONI_TEL <=", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelLike(String value) {
            addCriterion("MONI_TEL like", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelNotLike(String value) {
            addCriterion("MONI_TEL not like", value, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelIn(List<String> values) {
            addCriterion("MONI_TEL in", values, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelNotIn(List<String> values) {
            addCriterion("MONI_TEL not in", values, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelBetween(String value1, String value2) {
            addCriterion("MONI_TEL between", value1, value2, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniTelNotBetween(String value1, String value2) {
            addCriterion("MONI_TEL not between", value1, value2, "moniTel");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeIsNull() {
            addCriterion("MONI_PROTOCOL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeIsNotNull() {
            addCriterion("MONI_PROTOCOL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_TYPE =", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeNotEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_TYPE <>", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeGreaterThan(String value) {
            addCriterion("MONI_PROTOCOL_TYPE >", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_TYPE >=", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeLessThan(String value) {
            addCriterion("MONI_PROTOCOL_TYPE <", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeLessThanOrEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_TYPE <=", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeLike(String value) {
            addCriterion("MONI_PROTOCOL_TYPE like", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeNotLike(String value) {
            addCriterion("MONI_PROTOCOL_TYPE not like", value, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeIn(List<String> values) {
            addCriterion("MONI_PROTOCOL_TYPE in", values, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeNotIn(List<String> values) {
            addCriterion("MONI_PROTOCOL_TYPE not in", values, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeBetween(String value1, String value2) {
            addCriterion("MONI_PROTOCOL_TYPE between", value1, value2, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolTypeNotBetween(String value1, String value2) {
            addCriterion("MONI_PROTOCOL_TYPE not between", value1, value2, "moniProtocolType");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitIsNull() {
            addCriterion("IS_HIGHEST_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitIsNotNull() {
            addCriterion("IS_HIGHEST_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitEqualTo(String value) {
            addCriterion("IS_HIGHEST_LIMIT =", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitNotEqualTo(String value) {
            addCriterion("IS_HIGHEST_LIMIT <>", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitGreaterThan(String value) {
            addCriterion("IS_HIGHEST_LIMIT >", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitGreaterThanOrEqualTo(String value) {
            addCriterion("IS_HIGHEST_LIMIT >=", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitLessThan(String value) {
            addCriterion("IS_HIGHEST_LIMIT <", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitLessThanOrEqualTo(String value) {
            addCriterion("IS_HIGHEST_LIMIT <=", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitLike(String value) {
            addCriterion("IS_HIGHEST_LIMIT like", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitNotLike(String value) {
            addCriterion("IS_HIGHEST_LIMIT not like", value, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitIn(List<String> values) {
            addCriterion("IS_HIGHEST_LIMIT in", values, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitNotIn(List<String> values) {
            addCriterion("IS_HIGHEST_LIMIT not in", values, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitBetween(String value1, String value2) {
            addCriterion("IS_HIGHEST_LIMIT between", value1, value2, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andIsHighestLimitNotBetween(String value1, String value2) {
            addCriterion("IS_HIGHEST_LIMIT not between", value1, value2, "isHighestLimit");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelIsNull() {
            addCriterion("MONI_PRICE_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelIsNotNull() {
            addCriterion("MONI_PRICE_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelEqualTo(String value) {
            addCriterion("MONI_PRICE_MODEL =", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelNotEqualTo(String value) {
            addCriterion("MONI_PRICE_MODEL <>", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelGreaterThan(String value) {
            addCriterion("MONI_PRICE_MODEL >", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_PRICE_MODEL >=", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelLessThan(String value) {
            addCriterion("MONI_PRICE_MODEL <", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelLessThanOrEqualTo(String value) {
            addCriterion("MONI_PRICE_MODEL <=", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelLike(String value) {
            addCriterion("MONI_PRICE_MODEL like", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelNotLike(String value) {
            addCriterion("MONI_PRICE_MODEL not like", value, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelIn(List<String> values) {
            addCriterion("MONI_PRICE_MODEL in", values, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelNotIn(List<String> values) {
            addCriterion("MONI_PRICE_MODEL not in", values, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelBetween(String value1, String value2) {
            addCriterion("MONI_PRICE_MODEL between", value1, value2, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniPriceModelNotBetween(String value1, String value2) {
            addCriterion("MONI_PRICE_MODEL not between", value1, value2, "moniPriceModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelIsNull() {
            addCriterion("MONI_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andMoniModelIsNotNull() {
            addCriterion("MONI_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andMoniModelEqualTo(String value) {
            addCriterion("MONI_MODEL =", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelNotEqualTo(String value) {
            addCriterion("MONI_MODEL <>", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelGreaterThan(String value) {
            addCriterion("MONI_MODEL >", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_MODEL >=", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelLessThan(String value) {
            addCriterion("MONI_MODEL <", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelLessThanOrEqualTo(String value) {
            addCriterion("MONI_MODEL <=", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelLike(String value) {
            addCriterion("MONI_MODEL like", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelNotLike(String value) {
            addCriterion("MONI_MODEL not like", value, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelIn(List<String> values) {
            addCriterion("MONI_MODEL in", values, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelNotIn(List<String> values) {
            addCriterion("MONI_MODEL not in", values, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelBetween(String value1, String value2) {
            addCriterion("MONI_MODEL between", value1, value2, "moniModel");
            return (Criteria) this;
        }

        public Criteria andMoniModelNotBetween(String value1, String value2) {
            addCriterion("MONI_MODEL not between", value1, value2, "moniModel");
            return (Criteria) this;
        }

        public Criteria andDeallineRateIsNull() {
            addCriterion("DEALLINE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andDeallineRateIsNotNull() {
            addCriterion("DEALLINE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andDeallineRateEqualTo(BigDecimal value) {
            addCriterion("DEALLINE_RATE =", value, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateNotEqualTo(BigDecimal value) {
            addCriterion("DEALLINE_RATE <>", value, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateGreaterThan(BigDecimal value) {
            addCriterion("DEALLINE_RATE >", value, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEALLINE_RATE >=", value, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateLessThan(BigDecimal value) {
            addCriterion("DEALLINE_RATE <", value, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEALLINE_RATE <=", value, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateIn(List<BigDecimal> values) {
            addCriterion("DEALLINE_RATE in", values, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateNotIn(List<BigDecimal> values) {
            addCriterion("DEALLINE_RATE not in", values, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEALLINE_RATE between", value1, value2, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andDeallineRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEALLINE_RATE not between", value1, value2, "deallineRate");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeIsNull() {
            addCriterion("WAREHOUSE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeIsNotNull() {
            addCriterion("WAREHOUSE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeEqualTo(String value) {
            addCriterion("WAREHOUSE_TYPE =", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeNotEqualTo(String value) {
            addCriterion("WAREHOUSE_TYPE <>", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeGreaterThan(String value) {
            addCriterion("WAREHOUSE_TYPE >", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_TYPE >=", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeLessThan(String value) {
            addCriterion("WAREHOUSE_TYPE <", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_TYPE <=", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeLike(String value) {
            addCriterion("WAREHOUSE_TYPE like", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeNotLike(String value) {
            addCriterion("WAREHOUSE_TYPE not like", value, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeIn(List<String> values) {
            addCriterion("WAREHOUSE_TYPE in", values, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeNotIn(List<String> values) {
            addCriterion("WAREHOUSE_TYPE not in", values, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_TYPE between", value1, value2, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseTypeNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_TYPE not between", value1, value2, "warehouseType");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolIsNull() {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolIsNotNull() {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL =", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolNotEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL <>", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolGreaterThan(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL >", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL >=", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolLessThan(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL <", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL <=", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolLike(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL like", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolNotLike(String value) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL not like", value, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolIn(List<String> values) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL in", values, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolNotIn(List<String> values) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL not in", values, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL between", value1, value2, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireProtocolNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_HIRE_PROTOCOL not between", value1, value2, "warehouseHireProtocol");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateIsNull() {
            addCriterion("WAREHOUSE_HIRE_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateIsNotNull() {
            addCriterion("WAREHOUSE_HIRE_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE =", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateNotEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE <>", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateGreaterThan(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE >", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE >=", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateLessThan(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE <", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE <=", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateLike(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE like", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateNotLike(String value) {
            addCriterion("WAREHOUSE_HIRE_START_DATE not like", value, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateIn(List<String> values) {
            addCriterion("WAREHOUSE_HIRE_START_DATE in", values, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateNotIn(List<String> values) {
            addCriterion("WAREHOUSE_HIRE_START_DATE not in", values, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_HIRE_START_DATE between", value1, value2, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireStartDateNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_HIRE_START_DATE not between", value1, value2, "warehouseHireStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateIsNull() {
            addCriterion("WAREHOUSE_HIRE_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateIsNotNull() {
            addCriterion("WAREHOUSE_HIRE_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE =", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateNotEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE <>", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateGreaterThan(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE >", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE >=", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateLessThan(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE <", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE <=", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateLike(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE like", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateNotLike(String value) {
            addCriterion("WAREHOUSE_HIRE_END_DATE not like", value, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateIn(List<String> values) {
            addCriterion("WAREHOUSE_HIRE_END_DATE in", values, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateNotIn(List<String> values) {
            addCriterion("WAREHOUSE_HIRE_END_DATE not in", values, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_HIRE_END_DATE between", value1, value2, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseHireEndDateNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_HIRE_END_DATE not between", value1, value2, "warehouseHireEndDate");
            return (Criteria) this;
        }

        public Criteria andOtherDesIsNull() {
            addCriterion("OTHER_DES is null");
            return (Criteria) this;
        }

        public Criteria andOtherDesIsNotNull() {
            addCriterion("OTHER_DES is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDesEqualTo(String value) {
            addCriterion("OTHER_DES =", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotEqualTo(String value) {
            addCriterion("OTHER_DES <>", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesGreaterThan(String value) {
            addCriterion("OTHER_DES >", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_DES >=", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesLessThan(String value) {
            addCriterion("OTHER_DES <", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesLessThanOrEqualTo(String value) {
            addCriterion("OTHER_DES <=", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesLike(String value) {
            addCriterion("OTHER_DES like", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotLike(String value) {
            addCriterion("OTHER_DES not like", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesIn(List<String> values) {
            addCriterion("OTHER_DES in", values, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotIn(List<String> values) {
            addCriterion("OTHER_DES not in", values, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesBetween(String value1, String value2) {
            addCriterion("OTHER_DES between", value1, value2, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotBetween(String value1, String value2) {
            addCriterion("OTHER_DES not between", value1, value2, "otherDes");
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

        public Criteria andSeHighestPercentIsNull() {
            addCriterion("SE_HIGHEST_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentIsNotNull() {
            addCriterion("SE_HIGHEST_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentEqualTo(BigDecimal value) {
            addCriterion("SE_HIGHEST_PERCENT =", value, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentNotEqualTo(BigDecimal value) {
            addCriterion("SE_HIGHEST_PERCENT <>", value, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentGreaterThan(BigDecimal value) {
            addCriterion("SE_HIGHEST_PERCENT >", value, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SE_HIGHEST_PERCENT >=", value, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentLessThan(BigDecimal value) {
            addCriterion("SE_HIGHEST_PERCENT <", value, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SE_HIGHEST_PERCENT <=", value, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentIn(List<BigDecimal> values) {
            addCriterion("SE_HIGHEST_PERCENT in", values, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentNotIn(List<BigDecimal> values) {
            addCriterion("SE_HIGHEST_PERCENT not in", values, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SE_HIGHEST_PERCENT between", value1, value2, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andSeHighestPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SE_HIGHEST_PERCENT not between", value1, value2, "seHighestPercent");
            return (Criteria) this;
        }

        public Criteria andIsPledgeIsNull() {
            addCriterion("IS_PLEDGE is null");
            return (Criteria) this;
        }

        public Criteria andIsPledgeIsNotNull() {
            addCriterion("IS_PLEDGE is not null");
            return (Criteria) this;
        }

        public Criteria andIsPledgeEqualTo(String value) {
            addCriterion("IS_PLEDGE =", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeNotEqualTo(String value) {
            addCriterion("IS_PLEDGE <>", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeGreaterThan(String value) {
            addCriterion("IS_PLEDGE >", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PLEDGE >=", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeLessThan(String value) {
            addCriterion("IS_PLEDGE <", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeLessThanOrEqualTo(String value) {
            addCriterion("IS_PLEDGE <=", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeLike(String value) {
            addCriterion("IS_PLEDGE like", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeNotLike(String value) {
            addCriterion("IS_PLEDGE not like", value, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeIn(List<String> values) {
            addCriterion("IS_PLEDGE in", values, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeNotIn(List<String> values) {
            addCriterion("IS_PLEDGE not in", values, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeBetween(String value1, String value2) {
            addCriterion("IS_PLEDGE between", value1, value2, "isPledge");
            return (Criteria) this;
        }

        public Criteria andIsPledgeNotBetween(String value1, String value2) {
            addCriterion("IS_PLEDGE not between", value1, value2, "isPledge");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}