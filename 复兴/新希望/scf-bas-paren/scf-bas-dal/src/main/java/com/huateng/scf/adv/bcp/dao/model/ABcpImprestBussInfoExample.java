package com.huateng.scf.adv.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ABcpImprestBussInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ABcpImprestBussInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected ABcpImprestBussInfoExample(ABcpImprestBussInfoExample example) {
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

        public Criteria andGuaranteeCustcdIsNull() {
            addCriterion("GUARANTEE_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdIsNotNull() {
            addCriterion("GUARANTEE_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdEqualTo(String value) {
            addCriterion("GUARANTEE_CUSTCD =", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdNotEqualTo(String value) {
            addCriterion("GUARANTEE_CUSTCD <>", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdGreaterThan(String value) {
            addCriterion("GUARANTEE_CUSTCD >", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("GUARANTEE_CUSTCD >=", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdLessThan(String value) {
            addCriterion("GUARANTEE_CUSTCD <", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdLessThanOrEqualTo(String value) {
            addCriterion("GUARANTEE_CUSTCD <=", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdLike(String value) {
            addCriterion("GUARANTEE_CUSTCD like", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdNotLike(String value) {
            addCriterion("GUARANTEE_CUSTCD not like", value, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdIn(List<String> values) {
            addCriterion("GUARANTEE_CUSTCD in", values, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdNotIn(List<String> values) {
            addCriterion("GUARANTEE_CUSTCD not in", values, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdBetween(String value1, String value2) {
            addCriterion("GUARANTEE_CUSTCD between", value1, value2, "guaranteeCustcd");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCustcdNotBetween(String value1, String value2) {
            addCriterion("GUARANTEE_CUSTCD not between", value1, value2, "guaranteeCustcd");
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

        public Criteria andMoniProtocolNoIsNull() {
            addCriterion("MONI_PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoIsNotNull() {
            addCriterion("MONI_PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_NO =", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoNotEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_NO <>", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoGreaterThan(String value) {
            addCriterion("MONI_PROTOCOL_NO >", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_NO >=", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoLessThan(String value) {
            addCriterion("MONI_PROTOCOL_NO <", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("MONI_PROTOCOL_NO <=", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoLike(String value) {
            addCriterion("MONI_PROTOCOL_NO like", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoNotLike(String value) {
            addCriterion("MONI_PROTOCOL_NO not like", value, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoIn(List<String> values) {
            addCriterion("MONI_PROTOCOL_NO in", values, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoNotIn(List<String> values) {
            addCriterion("MONI_PROTOCOL_NO not in", values, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoBetween(String value1, String value2) {
            addCriterion("MONI_PROTOCOL_NO between", value1, value2, "moniProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMoniProtocolNoNotBetween(String value1, String value2) {
            addCriterion("MONI_PROTOCOL_NO not between", value1, value2, "moniProtocolNo");
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

        public Criteria andCollectedAmtIsNull() {
            addCriterion("COLLECTED_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtIsNotNull() {
            addCriterion("COLLECTED_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtEqualTo(BigDecimal value) {
            addCriterion("COLLECTED_AMT =", value, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtNotEqualTo(BigDecimal value) {
            addCriterion("COLLECTED_AMT <>", value, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtGreaterThan(BigDecimal value) {
            addCriterion("COLLECTED_AMT >", value, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTED_AMT >=", value, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtLessThan(BigDecimal value) {
            addCriterion("COLLECTED_AMT <", value, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTED_AMT <=", value, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtIn(List<BigDecimal> values) {
            addCriterion("COLLECTED_AMT in", values, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtNotIn(List<BigDecimal> values) {
            addCriterion("COLLECTED_AMT not in", values, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTED_AMT between", value1, value2, "collectedAmt");
            return (Criteria) this;
        }

        public Criteria andCollectedAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTED_AMT not between", value1, value2, "collectedAmt");
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

        public Criteria andUndeliveryAmtIsNull() {
            addCriterion("UNDELIVERY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtIsNotNull() {
            addCriterion("UNDELIVERY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtEqualTo(BigDecimal value) {
            addCriterion("UNDELIVERY_AMT =", value, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtNotEqualTo(BigDecimal value) {
            addCriterion("UNDELIVERY_AMT <>", value, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtGreaterThan(BigDecimal value) {
            addCriterion("UNDELIVERY_AMT >", value, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UNDELIVERY_AMT >=", value, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtLessThan(BigDecimal value) {
            addCriterion("UNDELIVERY_AMT <", value, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UNDELIVERY_AMT <=", value, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtIn(List<BigDecimal> values) {
            addCriterion("UNDELIVERY_AMT in", values, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtNotIn(List<BigDecimal> values) {
            addCriterion("UNDELIVERY_AMT not in", values, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNDELIVERY_AMT between", value1, value2, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andUndeliveryAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNDELIVERY_AMT not between", value1, value2, "undeliveryAmt");
            return (Criteria) this;
        }

        public Criteria andPaybackTermIsNull() {
            addCriterion("PAYBACK_TERM is null");
            return (Criteria) this;
        }

        public Criteria andPaybackTermIsNotNull() {
            addCriterion("PAYBACK_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andPaybackTermEqualTo(BigDecimal value) {
            addCriterion("PAYBACK_TERM =", value, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermNotEqualTo(BigDecimal value) {
            addCriterion("PAYBACK_TERM <>", value, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermGreaterThan(BigDecimal value) {
            addCriterion("PAYBACK_TERM >", value, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYBACK_TERM >=", value, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermLessThan(BigDecimal value) {
            addCriterion("PAYBACK_TERM <", value, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYBACK_TERM <=", value, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermIn(List<BigDecimal> values) {
            addCriterion("PAYBACK_TERM in", values, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermNotIn(List<BigDecimal> values) {
            addCriterion("PAYBACK_TERM not in", values, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYBACK_TERM between", value1, value2, "paybackTerm");
            return (Criteria) this;
        }

        public Criteria andPaybackTermNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYBACK_TERM not between", value1, value2, "paybackTerm");
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

        public Criteria andPaybackAcctNoIsNull() {
            addCriterion("PAYBACK_ACCT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoIsNotNull() {
            addCriterion("PAYBACK_ACCT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoEqualTo(String value) {
            addCriterion("PAYBACK_ACCT_NO =", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoNotEqualTo(String value) {
            addCriterion("PAYBACK_ACCT_NO <>", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoGreaterThan(String value) {
            addCriterion("PAYBACK_ACCT_NO >", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYBACK_ACCT_NO >=", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoLessThan(String value) {
            addCriterion("PAYBACK_ACCT_NO <", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoLessThanOrEqualTo(String value) {
            addCriterion("PAYBACK_ACCT_NO <=", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoLike(String value) {
            addCriterion("PAYBACK_ACCT_NO like", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoNotLike(String value) {
            addCriterion("PAYBACK_ACCT_NO not like", value, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoIn(List<String> values) {
            addCriterion("PAYBACK_ACCT_NO in", values, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoNotIn(List<String> values) {
            addCriterion("PAYBACK_ACCT_NO not in", values, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoBetween(String value1, String value2) {
            addCriterion("PAYBACK_ACCT_NO between", value1, value2, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andPaybackAcctNoNotBetween(String value1, String value2) {
            addCriterion("PAYBACK_ACCT_NO not between", value1, value2, "paybackAcctNo");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNull() {
            addCriterion("DEPOSIT_BANK is null");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNotNull() {
            addCriterion("DEPOSIT_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBankEqualTo(String value) {
            addCriterion("DEPOSIT_BANK =", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotEqualTo(String value) {
            addCriterion("DEPOSIT_BANK <>", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThan(String value) {
            addCriterion("DEPOSIT_BANK >", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BANK >=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThan(String value) {
            addCriterion("DEPOSIT_BANK <", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BANK <=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLike(String value) {
            addCriterion("DEPOSIT_BANK like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotLike(String value) {
            addCriterion("DEPOSIT_BANK not like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankIn(List<String> values) {
            addCriterion("DEPOSIT_BANK in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotIn(List<String> values) {
            addCriterion("DEPOSIT_BANK not in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BANK between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BANK not between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonIsNull() {
            addCriterion("PAYBACK_REASON is null");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonIsNotNull() {
            addCriterion("PAYBACK_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonEqualTo(String value) {
            addCriterion("PAYBACK_REASON =", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonNotEqualTo(String value) {
            addCriterion("PAYBACK_REASON <>", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonGreaterThan(String value) {
            addCriterion("PAYBACK_REASON >", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonGreaterThanOrEqualTo(String value) {
            addCriterion("PAYBACK_REASON >=", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonLessThan(String value) {
            addCriterion("PAYBACK_REASON <", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonLessThanOrEqualTo(String value) {
            addCriterion("PAYBACK_REASON <=", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonLike(String value) {
            addCriterion("PAYBACK_REASON like", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonNotLike(String value) {
            addCriterion("PAYBACK_REASON not like", value, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonIn(List<String> values) {
            addCriterion("PAYBACK_REASON in", values, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonNotIn(List<String> values) {
            addCriterion("PAYBACK_REASON not in", values, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonBetween(String value1, String value2) {
            addCriterion("PAYBACK_REASON between", value1, value2, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPaybackReasonNotBetween(String value1, String value2) {
            addCriterion("PAYBACK_REASON not between", value1, value2, "paybackReason");
            return (Criteria) this;
        }

        public Criteria andPickAmtIsNull() {
            addCriterion("PICK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andPickAmtIsNotNull() {
            addCriterion("PICK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andPickAmtEqualTo(BigDecimal value) {
            addCriterion("PICK_AMT =", value, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtNotEqualTo(BigDecimal value) {
            addCriterion("PICK_AMT <>", value, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtGreaterThan(BigDecimal value) {
            addCriterion("PICK_AMT >", value, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PICK_AMT >=", value, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtLessThan(BigDecimal value) {
            addCriterion("PICK_AMT <", value, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PICK_AMT <=", value, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtIn(List<BigDecimal> values) {
            addCriterion("PICK_AMT in", values, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtNotIn(List<BigDecimal> values) {
            addCriterion("PICK_AMT not in", values, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PICK_AMT between", value1, value2, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andPickAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PICK_AMT not between", value1, value2, "pickAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtIsNull() {
            addCriterion("ADD_BAIL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtIsNotNull() {
            addCriterion("ADD_BAIL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMT =", value, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtNotEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMT <>", value, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtGreaterThan(BigDecimal value) {
            addCriterion("ADD_BAIL_AMT >", value, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMT >=", value, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtLessThan(BigDecimal value) {
            addCriterion("ADD_BAIL_AMT <", value, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMT <=", value, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtIn(List<BigDecimal> values) {
            addCriterion("ADD_BAIL_AMT in", values, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtNotIn(List<BigDecimal> values) {
            addCriterion("ADD_BAIL_AMT not in", values, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_BAIL_AMT between", value1, value2, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andAddBailAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_BAIL_AMT not between", value1, value2, "addBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtIsNull() {
            addCriterion("CORE_BAIL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtIsNotNull() {
            addCriterion("CORE_BAIL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtEqualTo(BigDecimal value) {
            addCriterion("CORE_BAIL_AMT =", value, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtNotEqualTo(BigDecimal value) {
            addCriterion("CORE_BAIL_AMT <>", value, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtGreaterThan(BigDecimal value) {
            addCriterion("CORE_BAIL_AMT >", value, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CORE_BAIL_AMT >=", value, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtLessThan(BigDecimal value) {
            addCriterion("CORE_BAIL_AMT <", value, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CORE_BAIL_AMT <=", value, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtIn(List<BigDecimal> values) {
            addCriterion("CORE_BAIL_AMT in", values, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtNotIn(List<BigDecimal> values) {
            addCriterion("CORE_BAIL_AMT not in", values, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CORE_BAIL_AMT between", value1, value2, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andCoreBailAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CORE_BAIL_AMT not between", value1, value2, "coreBailAmt");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentIsNull() {
            addCriterion("INIT_AMT_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentIsNotNull() {
            addCriterion("INIT_AMT_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentEqualTo(BigDecimal value) {
            addCriterion("INIT_AMT_PERCENT =", value, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentNotEqualTo(BigDecimal value) {
            addCriterion("INIT_AMT_PERCENT <>", value, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentGreaterThan(BigDecimal value) {
            addCriterion("INIT_AMT_PERCENT >", value, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INIT_AMT_PERCENT >=", value, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentLessThan(BigDecimal value) {
            addCriterion("INIT_AMT_PERCENT <", value, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INIT_AMT_PERCENT <=", value, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentIn(List<BigDecimal> values) {
            addCriterion("INIT_AMT_PERCENT in", values, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentNotIn(List<BigDecimal> values) {
            addCriterion("INIT_AMT_PERCENT not in", values, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INIT_AMT_PERCENT between", value1, value2, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andInitAmtPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INIT_AMT_PERCENT not between", value1, value2, "initAmtPercent");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtIsNull() {
            addCriterion("CASH_EQT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtIsNotNull() {
            addCriterion("CASH_EQT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT =", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtNotEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT <>", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtGreaterThan(BigDecimal value) {
            addCriterion("CASH_EQT_AMT >", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT >=", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtLessThan(BigDecimal value) {
            addCriterion("CASH_EQT_AMT <", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT <=", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtIn(List<BigDecimal> values) {
            addCriterion("CASH_EQT_AMT in", values, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtNotIn(List<BigDecimal> values) {
            addCriterion("CASH_EQT_AMT not in", values, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_EQT_AMT between", value1, value2, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_EQT_AMT not between", value1, value2, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIsNull() {
            addCriterion("LNCI_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIsNotNull() {
            addCriterion("LNCI_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLnciAmtEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT =", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT <>", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtGreaterThan(BigDecimal value) {
            addCriterion("LNCI_AMT >", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT >=", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtLessThan(BigDecimal value) {
            addCriterion("LNCI_AMT <", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT <=", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIn(List<BigDecimal> values) {
            addCriterion("LNCI_AMT in", values, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotIn(List<BigDecimal> values) {
            addCriterion("LNCI_AMT not in", values, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_AMT between", value1, value2, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_AMT not between", value1, value2, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciBalIsNull() {
            addCriterion("LNCI_BAL is null");
            return (Criteria) this;
        }

        public Criteria andLnciBalIsNotNull() {
            addCriterion("LNCI_BAL is not null");
            return (Criteria) this;
        }

        public Criteria andLnciBalEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL =", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL <>", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalGreaterThan(BigDecimal value) {
            addCriterion("LNCI_BAL >", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL >=", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalLessThan(BigDecimal value) {
            addCriterion("LNCI_BAL <", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL <=", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalIn(List<BigDecimal> values) {
            addCriterion("LNCI_BAL in", values, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotIn(List<BigDecimal> values) {
            addCriterion("LNCI_BAL not in", values, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_BAL between", value1, value2, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_BAL not between", value1, value2, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNull() {
            addCriterion("RISK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNotNull() {
            addCriterion("RISK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT =", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <>", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("RISK_AMT >", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT >=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThan(BigDecimal value) {
            addCriterion("RISK_AMT <", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT not in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT not between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andMgrnoIsNull() {
            addCriterion("MGRNO is null");
            return (Criteria) this;
        }

        public Criteria andMgrnoIsNotNull() {
            addCriterion("MGRNO is not null");
            return (Criteria) this;
        }

        public Criteria andMgrnoEqualTo(String value) {
            addCriterion("MGRNO =", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotEqualTo(String value) {
            addCriterion("MGRNO <>", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoGreaterThan(String value) {
            addCriterion("MGRNO >", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoGreaterThanOrEqualTo(String value) {
            addCriterion("MGRNO >=", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLessThan(String value) {
            addCriterion("MGRNO <", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLessThanOrEqualTo(String value) {
            addCriterion("MGRNO <=", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLike(String value) {
            addCriterion("MGRNO like", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotLike(String value) {
            addCriterion("MGRNO not like", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoIn(List<String> values) {
            addCriterion("MGRNO in", values, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotIn(List<String> values) {
            addCriterion("MGRNO not in", values, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoBetween(String value1, String value2) {
            addCriterion("MGRNO between", value1, value2, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotBetween(String value1, String value2) {
            addCriterion("MGRNO not between", value1, value2, "mgrno");
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

        public Criteria andConfigNoIsNull() {
            addCriterion("CONFIG_NO is null");
            return (Criteria) this;
        }

        public Criteria andConfigNoIsNotNull() {
            addCriterion("CONFIG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andConfigNoEqualTo(String value) {
            addCriterion("CONFIG_NO =", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotEqualTo(String value) {
            addCriterion("CONFIG_NO <>", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThan(String value) {
            addCriterion("CONFIG_NO >", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIG_NO >=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThan(String value) {
            addCriterion("CONFIG_NO <", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThanOrEqualTo(String value) {
            addCriterion("CONFIG_NO <=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLike(String value) {
            addCriterion("CONFIG_NO like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotLike(String value) {
            addCriterion("CONFIG_NO not like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoIn(List<String> values) {
            addCriterion("CONFIG_NO in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotIn(List<String> values) {
            addCriterion("CONFIG_NO not in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoBetween(String value1, String value2) {
            addCriterion("CONFIG_NO between", value1, value2, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotBetween(String value1, String value2) {
            addCriterion("CONFIG_NO not between", value1, value2, "configNo");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNull() {
            addCriterion("INSERT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNotNull() {
            addCriterion("INSERT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDateEqualTo(String value) {
            addCriterion("INSERT_DATE =", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotEqualTo(String value) {
            addCriterion("INSERT_DATE <>", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThan(String value) {
            addCriterion("INSERT_DATE >", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThanOrEqualTo(String value) {
            addCriterion("INSERT_DATE >=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThan(String value) {
            addCriterion("INSERT_DATE <", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThanOrEqualTo(String value) {
            addCriterion("INSERT_DATE <=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLike(String value) {
            addCriterion("INSERT_DATE like", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotLike(String value) {
            addCriterion("INSERT_DATE not like", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateIn(List<String> values) {
            addCriterion("INSERT_DATE in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotIn(List<String> values) {
            addCriterion("INSERT_DATE not in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateBetween(String value1, String value2) {
            addCriterion("INSERT_DATE between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotBetween(String value1, String value2) {
            addCriterion("INSERT_DATE not between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeIsNull() {
            addCriterion("FIRST_BAIL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeIsNotNull() {
            addCriterion("FIRST_BAIL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE =", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE <>", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeGreaterThan(String value) {
            addCriterion("FIRST_BAIL_TYPE >", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE >=", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeLessThan(String value) {
            addCriterion("FIRST_BAIL_TYPE <", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeLessThanOrEqualTo(String value) {
            addCriterion("FIRST_BAIL_TYPE <=", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeLike(String value) {
            addCriterion("FIRST_BAIL_TYPE like", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotLike(String value) {
            addCriterion("FIRST_BAIL_TYPE not like", value, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeIn(List<String> values) {
            addCriterion("FIRST_BAIL_TYPE in", values, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotIn(List<String> values) {
            addCriterion("FIRST_BAIL_TYPE not in", values, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeBetween(String value1, String value2) {
            addCriterion("FIRST_BAIL_TYPE between", value1, value2, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andFirstBailTypeNotBetween(String value1, String value2) {
            addCriterion("FIRST_BAIL_TYPE not between", value1, value2, "firstBailType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNull() {
            addCriterion("APPLY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("APPLY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(String value) {
            addCriterion("APPLY_TYPE =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(String value) {
            addCriterion("APPLY_TYPE <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(String value) {
            addCriterion("APPLY_TYPE >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_TYPE >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(String value) {
            addCriterion("APPLY_TYPE <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(String value) {
            addCriterion("APPLY_TYPE <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLike(String value) {
            addCriterion("APPLY_TYPE like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotLike(String value) {
            addCriterion("APPLY_TYPE not like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<String> values) {
            addCriterion("APPLY_TYPE in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<String> values) {
            addCriterion("APPLY_TYPE not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(String value1, String value2) {
            addCriterion("APPLY_TYPE between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(String value1, String value2) {
            addCriterion("APPLY_TYPE not between", value1, value2, "applyType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}