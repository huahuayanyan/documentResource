package com.huateng.scf.sto.nwr.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcPricingBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcPricingBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcPricingBaseInfoExample(BPbcPricingBaseInfoExample example) {
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

        public Criteria andPricingNoIsNull() {
            addCriterion("PRICING_NO is null");
            return (Criteria) this;
        }

        public Criteria andPricingNoIsNotNull() {
            addCriterion("PRICING_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPricingNoEqualTo(String value) {
            addCriterion("PRICING_NO =", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoNotEqualTo(String value) {
            addCriterion("PRICING_NO <>", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoGreaterThan(String value) {
            addCriterion("PRICING_NO >", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoGreaterThanOrEqualTo(String value) {
            addCriterion("PRICING_NO >=", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoLessThan(String value) {
            addCriterion("PRICING_NO <", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoLessThanOrEqualTo(String value) {
            addCriterion("PRICING_NO <=", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoLike(String value) {
            addCriterion("PRICING_NO like", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoNotLike(String value) {
            addCriterion("PRICING_NO not like", value, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoIn(List<String> values) {
            addCriterion("PRICING_NO in", values, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoNotIn(List<String> values) {
            addCriterion("PRICING_NO not in", values, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoBetween(String value1, String value2) {
            addCriterion("PRICING_NO between", value1, value2, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andPricingNoNotBetween(String value1, String value2) {
            addCriterion("PRICING_NO not between", value1, value2, "pricingNo");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeIsNull() {
            addCriterion("APPROVE_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeIsNotNull() {
            addCriterion("APPROVE_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeEqualTo(String value) {
            addCriterion("APPROVE_BRCODE =", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotEqualTo(String value) {
            addCriterion("APPROVE_BRCODE <>", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeGreaterThan(String value) {
            addCriterion("APPROVE_BRCODE >", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_BRCODE >=", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeLessThan(String value) {
            addCriterion("APPROVE_BRCODE <", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_BRCODE <=", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeLike(String value) {
            addCriterion("APPROVE_BRCODE like", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotLike(String value) {
            addCriterion("APPROVE_BRCODE not like", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeIn(List<String> values) {
            addCriterion("APPROVE_BRCODE in", values, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotIn(List<String> values) {
            addCriterion("APPROVE_BRCODE not in", values, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeBetween(String value1, String value2) {
            addCriterion("APPROVE_BRCODE between", value1, value2, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotBetween(String value1, String value2) {
            addCriterion("APPROVE_BRCODE not between", value1, value2, "approveBrcode");
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

        public Criteria andWarehouseAddressIsNull() {
            addCriterion("WAREHOUSE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressIsNotNull() {
            addCriterion("WAREHOUSE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS =", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS <>", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressGreaterThan(String value) {
            addCriterion("WAREHOUSE_ADDRESS >", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS >=", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLessThan(String value) {
            addCriterion("WAREHOUSE_ADDRESS <", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS <=", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLike(String value) {
            addCriterion("WAREHOUSE_ADDRESS like", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotLike(String value) {
            addCriterion("WAREHOUSE_ADDRESS not like", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressIn(List<String> values) {
            addCriterion("WAREHOUSE_ADDRESS in", values, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotIn(List<String> values) {
            addCriterion("WAREHOUSE_ADDRESS not in", values, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ADDRESS between", value1, value2, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ADDRESS not between", value1, value2, "warehouseAddress");
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

        public Criteria andPricingReasonIsNull() {
            addCriterion("PRICING_REASON is null");
            return (Criteria) this;
        }

        public Criteria andPricingReasonIsNotNull() {
            addCriterion("PRICING_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andPricingReasonEqualTo(String value) {
            addCriterion("PRICING_REASON =", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonNotEqualTo(String value) {
            addCriterion("PRICING_REASON <>", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonGreaterThan(String value) {
            addCriterion("PRICING_REASON >", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonGreaterThanOrEqualTo(String value) {
            addCriterion("PRICING_REASON >=", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonLessThan(String value) {
            addCriterion("PRICING_REASON <", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonLessThanOrEqualTo(String value) {
            addCriterion("PRICING_REASON <=", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonLike(String value) {
            addCriterion("PRICING_REASON like", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonNotLike(String value) {
            addCriterion("PRICING_REASON not like", value, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonIn(List<String> values) {
            addCriterion("PRICING_REASON in", values, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonNotIn(List<String> values) {
            addCriterion("PRICING_REASON not in", values, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonBetween(String value1, String value2) {
            addCriterion("PRICING_REASON between", value1, value2, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingReasonNotBetween(String value1, String value2) {
            addCriterion("PRICING_REASON not between", value1, value2, "pricingReason");
            return (Criteria) this;
        }

        public Criteria andPricingDateIsNull() {
            addCriterion("PRICING_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPricingDateIsNotNull() {
            addCriterion("PRICING_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPricingDateEqualTo(String value) {
            addCriterion("PRICING_DATE =", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateNotEqualTo(String value) {
            addCriterion("PRICING_DATE <>", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateGreaterThan(String value) {
            addCriterion("PRICING_DATE >", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateGreaterThanOrEqualTo(String value) {
            addCriterion("PRICING_DATE >=", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateLessThan(String value) {
            addCriterion("PRICING_DATE <", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateLessThanOrEqualTo(String value) {
            addCriterion("PRICING_DATE <=", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateLike(String value) {
            addCriterion("PRICING_DATE like", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateNotLike(String value) {
            addCriterion("PRICING_DATE not like", value, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateIn(List<String> values) {
            addCriterion("PRICING_DATE in", values, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateNotIn(List<String> values) {
            addCriterion("PRICING_DATE not in", values, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateBetween(String value1, String value2) {
            addCriterion("PRICING_DATE between", value1, value2, "pricingDate");
            return (Criteria) this;
        }

        public Criteria andPricingDateNotBetween(String value1, String value2) {
            addCriterion("PRICING_DATE not between", value1, value2, "pricingDate");
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

        public Criteria andApproverIsNull() {
            addCriterion("APPROVER is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsNotNull() {
            addCriterion("APPROVER is not null");
            return (Criteria) this;
        }

        public Criteria andApproverEqualTo(String value) {
            addCriterion("APPROVER =", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotEqualTo(String value) {
            addCriterion("APPROVER <>", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThan(String value) {
            addCriterion("APPROVER >", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVER >=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThan(String value) {
            addCriterion("APPROVER <", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThanOrEqualTo(String value) {
            addCriterion("APPROVER <=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLike(String value) {
            addCriterion("APPROVER like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotLike(String value) {
            addCriterion("APPROVER not like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverIn(List<String> values) {
            addCriterion("APPROVER in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotIn(List<String> values) {
            addCriterion("APPROVER not in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverBetween(String value1, String value2) {
            addCriterion("APPROVER between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotBetween(String value1, String value2) {
            addCriterion("APPROVER not between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNull() {
            addCriterion("APPROVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNotNull() {
            addCriterion("APPROVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDateEqualTo(String value) {
            addCriterion("APPROVE_DATE =", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotEqualTo(String value) {
            addCriterion("APPROVE_DATE <>", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThan(String value) {
            addCriterion("APPROVE_DATE >", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_DATE >=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThan(String value) {
            addCriterion("APPROVE_DATE <", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_DATE <=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLike(String value) {
            addCriterion("APPROVE_DATE like", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotLike(String value) {
            addCriterion("APPROVE_DATE not like", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateIn(List<String> values) {
            addCriterion("APPROVE_DATE in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotIn(List<String> values) {
            addCriterion("APPROVE_DATE not in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateBetween(String value1, String value2) {
            addCriterion("APPROVE_DATE between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotBetween(String value1, String value2) {
            addCriterion("APPROVE_DATE not between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdIsNull() {
            addCriterion("APP_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdIsNotNull() {
            addCriterion("APP_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdEqualTo(String value) {
            addCriterion("APP_TLRCD =", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotEqualTo(String value) {
            addCriterion("APP_TLRCD <>", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdGreaterThan(String value) {
            addCriterion("APP_TLRCD >", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_TLRCD >=", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdLessThan(String value) {
            addCriterion("APP_TLRCD <", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdLessThanOrEqualTo(String value) {
            addCriterion("APP_TLRCD <=", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdLike(String value) {
            addCriterion("APP_TLRCD like", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotLike(String value) {
            addCriterion("APP_TLRCD not like", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdIn(List<String> values) {
            addCriterion("APP_TLRCD in", values, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotIn(List<String> values) {
            addCriterion("APP_TLRCD not in", values, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdBetween(String value1, String value2) {
            addCriterion("APP_TLRCD between", value1, value2, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotBetween(String value1, String value2) {
            addCriterion("APP_TLRCD not between", value1, value2, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNull() {
            addCriterion("APP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNotNull() {
            addCriterion("APP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAppDateEqualTo(Date value) {
            addCriterion("APP_DATE =", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotEqualTo(Date value) {
            addCriterion("APP_DATE <>", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThan(Date value) {
            addCriterion("APP_DATE >", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThanOrEqualTo(Date value) {
            addCriterion("APP_DATE >=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThan(Date value) {
            addCriterion("APP_DATE <", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThanOrEqualTo(Date value) {
            addCriterion("APP_DATE <=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateIn(List<Date> values) {
            addCriterion("APP_DATE in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotIn(List<Date> values) {
            addCriterion("APP_DATE not in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateBetween(Date value1, Date value2) {
            addCriterion("APP_DATE between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotBetween(Date value1, Date value2) {
            addCriterion("APP_DATE not between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andOtherReasonIsNull() {
            addCriterion("OTHER_REASON is null");
            return (Criteria) this;
        }

        public Criteria andOtherReasonIsNotNull() {
            addCriterion("OTHER_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andOtherReasonEqualTo(String value) {
            addCriterion("OTHER_REASON =", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotEqualTo(String value) {
            addCriterion("OTHER_REASON <>", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonGreaterThan(String value) {
            addCriterion("OTHER_REASON >", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_REASON >=", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonLessThan(String value) {
            addCriterion("OTHER_REASON <", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonLessThanOrEqualTo(String value) {
            addCriterion("OTHER_REASON <=", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonLike(String value) {
            addCriterion("OTHER_REASON like", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotLike(String value) {
            addCriterion("OTHER_REASON not like", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonIn(List<String> values) {
            addCriterion("OTHER_REASON in", values, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotIn(List<String> values) {
            addCriterion("OTHER_REASON not in", values, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonBetween(String value1, String value2) {
            addCriterion("OTHER_REASON between", value1, value2, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotBetween(String value1, String value2) {
            addCriterion("OTHER_REASON not between", value1, value2, "otherReason");
            return (Criteria) this;
        }

        public Criteria andAppliTypeIsNull() {
            addCriterion("APPLI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAppliTypeIsNotNull() {
            addCriterion("APPLI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAppliTypeEqualTo(String value) {
            addCriterion("APPLI_TYPE =", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotEqualTo(String value) {
            addCriterion("APPLI_TYPE <>", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeGreaterThan(String value) {
            addCriterion("APPLI_TYPE >", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLI_TYPE >=", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeLessThan(String value) {
            addCriterion("APPLI_TYPE <", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeLessThanOrEqualTo(String value) {
            addCriterion("APPLI_TYPE <=", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeLike(String value) {
            addCriterion("APPLI_TYPE like", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotLike(String value) {
            addCriterion("APPLI_TYPE not like", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeIn(List<String> values) {
            addCriterion("APPLI_TYPE in", values, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotIn(List<String> values) {
            addCriterion("APPLI_TYPE not in", values, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeBetween(String value1, String value2) {
            addCriterion("APPLI_TYPE between", value1, value2, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotBetween(String value1, String value2) {
            addCriterion("APPLI_TYPE not between", value1, value2, "appliType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}