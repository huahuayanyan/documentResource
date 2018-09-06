package com.huateng.scf.nrec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RBcpDuebillRegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RBcpDuebillRegisterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RBcpDuebillRegisterExample(RBcpDuebillRegisterExample example) {
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

        public Criteria andReceiveNoIsNull() {
            addCriterion("RECEIVE_NO is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoIsNotNull() {
            addCriterion("RECEIVE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoEqualTo(String value) {
            addCriterion("RECEIVE_NO =", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotEqualTo(String value) {
            addCriterion("RECEIVE_NO <>", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoGreaterThan(String value) {
            addCriterion("RECEIVE_NO >", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NO >=", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoLessThan(String value) {
            addCriterion("RECEIVE_NO <", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NO <=", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoLike(String value) {
            addCriterion("RECEIVE_NO like", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotLike(String value) {
            addCriterion("RECEIVE_NO not like", value, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoIn(List<String> values) {
            addCriterion("RECEIVE_NO in", values, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotIn(List<String> values) {
            addCriterion("RECEIVE_NO not in", values, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoBetween(String value1, String value2) {
            addCriterion("RECEIVE_NO between", value1, value2, "receiveNo");
            return (Criteria) this;
        }

        public Criteria andReceiveNoNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_NO not between", value1, value2, "receiveNo");
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

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
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

        public Criteria andBusinessCustcdIsNull() {
            addCriterion("BUSINESS_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdIsNotNull() {
            addCriterion("BUSINESS_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdEqualTo(String value) {
            addCriterion("BUSINESS_CUSTCD =", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdNotEqualTo(String value) {
            addCriterion("BUSINESS_CUSTCD <>", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdGreaterThan(String value) {
            addCriterion("BUSINESS_CUSTCD >", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_CUSTCD >=", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdLessThan(String value) {
            addCriterion("BUSINESS_CUSTCD <", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_CUSTCD <=", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdLike(String value) {
            addCriterion("BUSINESS_CUSTCD like", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdNotLike(String value) {
            addCriterion("BUSINESS_CUSTCD not like", value, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdIn(List<String> values) {
            addCriterion("BUSINESS_CUSTCD in", values, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdNotIn(List<String> values) {
            addCriterion("BUSINESS_CUSTCD not in", values, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdBetween(String value1, String value2) {
            addCriterion("BUSINESS_CUSTCD between", value1, value2, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andBusinessCustcdNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_CUSTCD not between", value1, value2, "businessCustcd");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIsNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIsNotNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID =", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <>", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID not like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID not in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID not between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andLnAmtIsNull() {
            addCriterion("LN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLnAmtIsNotNull() {
            addCriterion("LN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLnAmtEqualTo(BigDecimal value) {
            addCriterion("LN_AMT =", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtNotEqualTo(BigDecimal value) {
            addCriterion("LN_AMT <>", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtGreaterThan(BigDecimal value) {
            addCriterion("LN_AMT >", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LN_AMT >=", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtLessThan(BigDecimal value) {
            addCriterion("LN_AMT <", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LN_AMT <=", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtIn(List<BigDecimal> values) {
            addCriterion("LN_AMT in", values, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtNotIn(List<BigDecimal> values) {
            addCriterion("LN_AMT not in", values, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LN_AMT between", value1, value2, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LN_AMT not between", value1, value2, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnSumIsNull() {
            addCriterion("LN_SUM is null");
            return (Criteria) this;
        }

        public Criteria andLnSumIsNotNull() {
            addCriterion("LN_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andLnSumEqualTo(BigDecimal value) {
            addCriterion("LN_SUM =", value, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumNotEqualTo(BigDecimal value) {
            addCriterion("LN_SUM <>", value, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumGreaterThan(BigDecimal value) {
            addCriterion("LN_SUM >", value, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LN_SUM >=", value, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumLessThan(BigDecimal value) {
            addCriterion("LN_SUM <", value, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LN_SUM <=", value, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumIn(List<BigDecimal> values) {
            addCriterion("LN_SUM in", values, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumNotIn(List<BigDecimal> values) {
            addCriterion("LN_SUM not in", values, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LN_SUM between", value1, value2, "lnSum");
            return (Criteria) this;
        }

        public Criteria andLnSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LN_SUM not between", value1, value2, "lnSum");
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

        public Criteria andReturnAccountIsNull() {
            addCriterion("RETURN_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReturnAccountIsNotNull() {
            addCriterion("RETURN_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAccountEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT =", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT <>", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountGreaterThan(String value) {
            addCriterion("RETURN_ACCOUNT >", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT >=", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountLessThan(String value) {
            addCriterion("RETURN_ACCOUNT <", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountLessThanOrEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT <=", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountLike(String value) {
            addCriterion("RETURN_ACCOUNT like", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotLike(String value) {
            addCriterion("RETURN_ACCOUNT not like", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountIn(List<String> values) {
            addCriterion("RETURN_ACCOUNT in", values, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotIn(List<String> values) {
            addCriterion("RETURN_ACCOUNT not in", values, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBetween(String value1, String value2) {
            addCriterion("RETURN_ACCOUNT between", value1, value2, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotBetween(String value1, String value2) {
            addCriterion("RETURN_ACCOUNT not between", value1, value2, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andActBrCdIsNull() {
            addCriterion("ACT_BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andActBrCdIsNotNull() {
            addCriterion("ACT_BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andActBrCdEqualTo(String value) {
            addCriterion("ACT_BR_CD =", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotEqualTo(String value) {
            addCriterion("ACT_BR_CD <>", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdGreaterThan(String value) {
            addCriterion("ACT_BR_CD >", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_BR_CD >=", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdLessThan(String value) {
            addCriterion("ACT_BR_CD <", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdLessThanOrEqualTo(String value) {
            addCriterion("ACT_BR_CD <=", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdLike(String value) {
            addCriterion("ACT_BR_CD like", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotLike(String value) {
            addCriterion("ACT_BR_CD not like", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdIn(List<String> values) {
            addCriterion("ACT_BR_CD in", values, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotIn(List<String> values) {
            addCriterion("ACT_BR_CD not in", values, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdBetween(String value1, String value2) {
            addCriterion("ACT_BR_CD between", value1, value2, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotBetween(String value1, String value2) {
            addCriterion("ACT_BR_CD not between", value1, value2, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andPayActNoIsNull() {
            addCriterion("PAY_ACT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayActNoIsNotNull() {
            addCriterion("PAY_ACT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayActNoEqualTo(String value) {
            addCriterion("PAY_ACT_NO =", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotEqualTo(String value) {
            addCriterion("PAY_ACT_NO <>", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoGreaterThan(String value) {
            addCriterion("PAY_ACT_NO >", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_ACT_NO >=", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoLessThan(String value) {
            addCriterion("PAY_ACT_NO <", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoLessThanOrEqualTo(String value) {
            addCriterion("PAY_ACT_NO <=", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoLike(String value) {
            addCriterion("PAY_ACT_NO like", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotLike(String value) {
            addCriterion("PAY_ACT_NO not like", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoIn(List<String> values) {
            addCriterion("PAY_ACT_NO in", values, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotIn(List<String> values) {
            addCriterion("PAY_ACT_NO not in", values, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoBetween(String value1, String value2) {
            addCriterion("PAY_ACT_NO between", value1, value2, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotBetween(String value1, String value2) {
            addCriterion("PAY_ACT_NO not between", value1, value2, "payActNo");
            return (Criteria) this;
        }

        public Criteria andActIntIsNull() {
            addCriterion("ACT_INT is null");
            return (Criteria) this;
        }

        public Criteria andActIntIsNotNull() {
            addCriterion("ACT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andActIntEqualTo(BigDecimal value) {
            addCriterion("ACT_INT =", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotEqualTo(BigDecimal value) {
            addCriterion("ACT_INT <>", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntGreaterThan(BigDecimal value) {
            addCriterion("ACT_INT >", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT_INT >=", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntLessThan(BigDecimal value) {
            addCriterion("ACT_INT <", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT_INT <=", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntIn(List<BigDecimal> values) {
            addCriterion("ACT_INT in", values, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotIn(List<BigDecimal> values) {
            addCriterion("ACT_INT not in", values, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT_INT between", value1, value2, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT_INT not between", value1, value2, "actInt");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNull() {
            addCriterion("FEE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNotNull() {
            addCriterion("FEE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRateEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE =", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE <>", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThan(BigDecimal value) {
            addCriterion("FEE_RATE >", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE >=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThan(BigDecimal value) {
            addCriterion("FEE_RATE <", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE <=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateIn(List<BigDecimal> values) {
            addCriterion("FEE_RATE in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotIn(List<BigDecimal> values) {
            addCriterion("FEE_RATE not in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RATE between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RATE not between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateIsNull() {
            addCriterion("BL_FEE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateIsNotNull() {
            addCriterion("BL_FEE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateEqualTo(BigDecimal value) {
            addCriterion("BL_FEE_RATE =", value, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateNotEqualTo(BigDecimal value) {
            addCriterion("BL_FEE_RATE <>", value, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateGreaterThan(BigDecimal value) {
            addCriterion("BL_FEE_RATE >", value, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BL_FEE_RATE >=", value, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateLessThan(BigDecimal value) {
            addCriterion("BL_FEE_RATE <", value, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BL_FEE_RATE <=", value, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateIn(List<BigDecimal> values) {
            addCriterion("BL_FEE_RATE in", values, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateNotIn(List<BigDecimal> values) {
            addCriterion("BL_FEE_RATE not in", values, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BL_FEE_RATE between", value1, value2, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andBlFeeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BL_FEE_RATE not between", value1, value2, "blFeeRate");
            return (Criteria) this;
        }

        public Criteria andJxPeriodIsNull() {
            addCriterion("JX_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andJxPeriodIsNotNull() {
            addCriterion("JX_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andJxPeriodEqualTo(String value) {
            addCriterion("JX_PERIOD =", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodNotEqualTo(String value) {
            addCriterion("JX_PERIOD <>", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodGreaterThan(String value) {
            addCriterion("JX_PERIOD >", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("JX_PERIOD >=", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodLessThan(String value) {
            addCriterion("JX_PERIOD <", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodLessThanOrEqualTo(String value) {
            addCriterion("JX_PERIOD <=", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodLike(String value) {
            addCriterion("JX_PERIOD like", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodNotLike(String value) {
            addCriterion("JX_PERIOD not like", value, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodIn(List<String> values) {
            addCriterion("JX_PERIOD in", values, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodNotIn(List<String> values) {
            addCriterion("JX_PERIOD not in", values, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodBetween(String value1, String value2) {
            addCriterion("JX_PERIOD between", value1, value2, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxPeriodNotBetween(String value1, String value2) {
            addCriterion("JX_PERIOD not between", value1, value2, "jxPeriod");
            return (Criteria) this;
        }

        public Criteria andJxDayIsNull() {
            addCriterion("JX_DAY is null");
            return (Criteria) this;
        }

        public Criteria andJxDayIsNotNull() {
            addCriterion("JX_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andJxDayEqualTo(Short value) {
            addCriterion("JX_DAY =", value, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayNotEqualTo(Short value) {
            addCriterion("JX_DAY <>", value, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayGreaterThan(Short value) {
            addCriterion("JX_DAY >", value, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayGreaterThanOrEqualTo(Short value) {
            addCriterion("JX_DAY >=", value, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayLessThan(Short value) {
            addCriterion("JX_DAY <", value, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayLessThanOrEqualTo(Short value) {
            addCriterion("JX_DAY <=", value, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayIn(List<Short> values) {
            addCriterion("JX_DAY in", values, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayNotIn(List<Short> values) {
            addCriterion("JX_DAY not in", values, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayBetween(Short value1, Short value2) {
            addCriterion("JX_DAY between", value1, value2, "jxDay");
            return (Criteria) this;
        }

        public Criteria andJxDayNotBetween(Short value1, Short value2) {
            addCriterion("JX_DAY not between", value1, value2, "jxDay");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNull() {
            addCriterion("RETURN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNotNull() {
            addCriterion("RETURN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeEqualTo(String value) {
            addCriterion("RETURN_TYPE =", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotEqualTo(String value) {
            addCriterion("RETURN_TYPE <>", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThan(String value) {
            addCriterion("RETURN_TYPE >", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_TYPE >=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThan(String value) {
            addCriterion("RETURN_TYPE <", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThanOrEqualTo(String value) {
            addCriterion("RETURN_TYPE <=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLike(String value) {
            addCriterion("RETURN_TYPE like", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotLike(String value) {
            addCriterion("RETURN_TYPE not like", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIn(List<String> values) {
            addCriterion("RETURN_TYPE in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotIn(List<String> values) {
            addCriterion("RETURN_TYPE not in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeBetween(String value1, String value2) {
            addCriterion("RETURN_TYPE between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotBetween(String value1, String value2) {
            addCriterion("RETURN_TYPE not between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andYqDayIsNull() {
            addCriterion("YQ_DAY is null");
            return (Criteria) this;
        }

        public Criteria andYqDayIsNotNull() {
            addCriterion("YQ_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andYqDayEqualTo(Short value) {
            addCriterion("YQ_DAY =", value, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayNotEqualTo(Short value) {
            addCriterion("YQ_DAY <>", value, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayGreaterThan(Short value) {
            addCriterion("YQ_DAY >", value, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayGreaterThanOrEqualTo(Short value) {
            addCriterion("YQ_DAY >=", value, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayLessThan(Short value) {
            addCriterion("YQ_DAY <", value, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayLessThanOrEqualTo(Short value) {
            addCriterion("YQ_DAY <=", value, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayIn(List<Short> values) {
            addCriterion("YQ_DAY in", values, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayNotIn(List<Short> values) {
            addCriterion("YQ_DAY not in", values, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayBetween(Short value1, Short value2) {
            addCriterion("YQ_DAY between", value1, value2, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqDayNotBetween(Short value1, Short value2) {
            addCriterion("YQ_DAY not between", value1, value2, "yqDay");
            return (Criteria) this;
        }

        public Criteria andYqRateIsNull() {
            addCriterion("YQ_RATE is null");
            return (Criteria) this;
        }

        public Criteria andYqRateIsNotNull() {
            addCriterion("YQ_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andYqRateEqualTo(BigDecimal value) {
            addCriterion("YQ_RATE =", value, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateNotEqualTo(BigDecimal value) {
            addCriterion("YQ_RATE <>", value, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateGreaterThan(BigDecimal value) {
            addCriterion("YQ_RATE >", value, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YQ_RATE >=", value, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateLessThan(BigDecimal value) {
            addCriterion("YQ_RATE <", value, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YQ_RATE <=", value, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateIn(List<BigDecimal> values) {
            addCriterion("YQ_RATE in", values, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateNotIn(List<BigDecimal> values) {
            addCriterion("YQ_RATE not in", values, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YQ_RATE between", value1, value2, "yqRate");
            return (Criteria) this;
        }

        public Criteria andYqRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YQ_RATE not between", value1, value2, "yqRate");
            return (Criteria) this;
        }

        public Criteria andTrmMonIsNull() {
            addCriterion("TRM_MON is null");
            return (Criteria) this;
        }

        public Criteria andTrmMonIsNotNull() {
            addCriterion("TRM_MON is not null");
            return (Criteria) this;
        }

        public Criteria andTrmMonEqualTo(BigDecimal value) {
            addCriterion("TRM_MON =", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonNotEqualTo(BigDecimal value) {
            addCriterion("TRM_MON <>", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonGreaterThan(BigDecimal value) {
            addCriterion("TRM_MON >", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_MON >=", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonLessThan(BigDecimal value) {
            addCriterion("TRM_MON <", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_MON <=", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonIn(List<BigDecimal> values) {
            addCriterion("TRM_MON in", values, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonNotIn(List<BigDecimal> values) {
            addCriterion("TRM_MON not in", values, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_MON between", value1, value2, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_MON not between", value1, value2, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmDayIsNull() {
            addCriterion("TRM_DAY is null");
            return (Criteria) this;
        }

        public Criteria andTrmDayIsNotNull() {
            addCriterion("TRM_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andTrmDayEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY =", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayNotEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY <>", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayGreaterThan(BigDecimal value) {
            addCriterion("TRM_DAY >", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY >=", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayLessThan(BigDecimal value) {
            addCriterion("TRM_DAY <", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY <=", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayIn(List<BigDecimal> values) {
            addCriterion("TRM_DAY in", values, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayNotIn(List<BigDecimal> values) {
            addCriterion("TRM_DAY not in", values, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_DAY between", value1, value2, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_DAY not between", value1, value2, "trmDay");
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

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("END_DATE like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("END_DATE not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andTlrNoIsNull() {
            addCriterion("TLR_NO is null");
            return (Criteria) this;
        }

        public Criteria andTlrNoIsNotNull() {
            addCriterion("TLR_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTlrNoEqualTo(String value) {
            addCriterion("TLR_NO =", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotEqualTo(String value) {
            addCriterion("TLR_NO <>", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoGreaterThan(String value) {
            addCriterion("TLR_NO >", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoGreaterThanOrEqualTo(String value) {
            addCriterion("TLR_NO >=", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLessThan(String value) {
            addCriterion("TLR_NO <", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLessThanOrEqualTo(String value) {
            addCriterion("TLR_NO <=", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLike(String value) {
            addCriterion("TLR_NO like", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotLike(String value) {
            addCriterion("TLR_NO not like", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoIn(List<String> values) {
            addCriterion("TLR_NO in", values, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotIn(List<String> values) {
            addCriterion("TLR_NO not in", values, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoBetween(String value1, String value2) {
            addCriterion("TLR_NO between", value1, value2, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotBetween(String value1, String value2) {
            addCriterion("TLR_NO not between", value1, value2, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNmIsNull() {
            addCriterion("TLR_NM is null");
            return (Criteria) this;
        }

        public Criteria andTlrNmIsNotNull() {
            addCriterion("TLR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andTlrNmEqualTo(String value) {
            addCriterion("TLR_NM =", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotEqualTo(String value) {
            addCriterion("TLR_NM <>", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmGreaterThan(String value) {
            addCriterion("TLR_NM >", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmGreaterThanOrEqualTo(String value) {
            addCriterion("TLR_NM >=", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLessThan(String value) {
            addCriterion("TLR_NM <", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLessThanOrEqualTo(String value) {
            addCriterion("TLR_NM <=", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLike(String value) {
            addCriterion("TLR_NM like", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotLike(String value) {
            addCriterion("TLR_NM not like", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmIn(List<String> values) {
            addCriterion("TLR_NM in", values, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotIn(List<String> values) {
            addCriterion("TLR_NM not in", values, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmBetween(String value1, String value2) {
            addCriterion("TLR_NM between", value1, value2, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotBetween(String value1, String value2) {
            addCriterion("TLR_NM not between", value1, value2, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andBrCdIsNull() {
            addCriterion("BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andBrCdIsNotNull() {
            addCriterion("BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andBrCdEqualTo(String value) {
            addCriterion("BR_CD =", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotEqualTo(String value) {
            addCriterion("BR_CD <>", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdGreaterThan(String value) {
            addCriterion("BR_CD >", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("BR_CD >=", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLessThan(String value) {
            addCriterion("BR_CD <", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLessThanOrEqualTo(String value) {
            addCriterion("BR_CD <=", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLike(String value) {
            addCriterion("BR_CD like", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotLike(String value) {
            addCriterion("BR_CD not like", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdIn(List<String> values) {
            addCriterion("BR_CD in", values, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotIn(List<String> values) {
            addCriterion("BR_CD not in", values, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdBetween(String value1, String value2) {
            addCriterion("BR_CD between", value1, value2, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotBetween(String value1, String value2) {
            addCriterion("BR_CD not between", value1, value2, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrNmIsNull() {
            addCriterion("BR_NM is null");
            return (Criteria) this;
        }

        public Criteria andBrNmIsNotNull() {
            addCriterion("BR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andBrNmEqualTo(String value) {
            addCriterion("BR_NM =", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotEqualTo(String value) {
            addCriterion("BR_NM <>", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmGreaterThan(String value) {
            addCriterion("BR_NM >", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmGreaterThanOrEqualTo(String value) {
            addCriterion("BR_NM >=", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLessThan(String value) {
            addCriterion("BR_NM <", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLessThanOrEqualTo(String value) {
            addCriterion("BR_NM <=", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLike(String value) {
            addCriterion("BR_NM like", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotLike(String value) {
            addCriterion("BR_NM not like", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmIn(List<String> values) {
            addCriterion("BR_NM in", values, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotIn(List<String> values) {
            addCriterion("BR_NM not in", values, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmBetween(String value1, String value2) {
            addCriterion("BR_NM between", value1, value2, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotBetween(String value1, String value2) {
            addCriterion("BR_NM not between", value1, value2, "brNm");
            return (Criteria) this;
        }

        public Criteria andInpDtIsNull() {
            addCriterion("INP_DT is null");
            return (Criteria) this;
        }

        public Criteria andInpDtIsNotNull() {
            addCriterion("INP_DT is not null");
            return (Criteria) this;
        }

        public Criteria andInpDtEqualTo(String value) {
            addCriterion("INP_DT =", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotEqualTo(String value) {
            addCriterion("INP_DT <>", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtGreaterThan(String value) {
            addCriterion("INP_DT >", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtGreaterThanOrEqualTo(String value) {
            addCriterion("INP_DT >=", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLessThan(String value) {
            addCriterion("INP_DT <", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLessThanOrEqualTo(String value) {
            addCriterion("INP_DT <=", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLike(String value) {
            addCriterion("INP_DT like", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotLike(String value) {
            addCriterion("INP_DT not like", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtIn(List<String> values) {
            addCriterion("INP_DT in", values, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotIn(List<String> values) {
            addCriterion("INP_DT not in", values, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtBetween(String value1, String value2) {
            addCriterion("INP_DT between", value1, value2, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotBetween(String value1, String value2) {
            addCriterion("INP_DT not between", value1, value2, "inpDt");
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

        public Criteria andExt4IsNull() {
            addCriterion("EXT4 is null");
            return (Criteria) this;
        }

        public Criteria andExt4IsNotNull() {
            addCriterion("EXT4 is not null");
            return (Criteria) this;
        }

        public Criteria andExt4EqualTo(String value) {
            addCriterion("EXT4 =", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotEqualTo(String value) {
            addCriterion("EXT4 <>", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThan(String value) {
            addCriterion("EXT4 >", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThanOrEqualTo(String value) {
            addCriterion("EXT4 >=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThan(String value) {
            addCriterion("EXT4 <", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThanOrEqualTo(String value) {
            addCriterion("EXT4 <=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Like(String value) {
            addCriterion("EXT4 like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotLike(String value) {
            addCriterion("EXT4 not like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4In(List<String> values) {
            addCriterion("EXT4 in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotIn(List<String> values) {
            addCriterion("EXT4 not in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Between(String value1, String value2) {
            addCriterion("EXT4 between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotBetween(String value1, String value2) {
            addCriterion("EXT4 not between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt5IsNull() {
            addCriterion("EXT5 is null");
            return (Criteria) this;
        }

        public Criteria andExt5IsNotNull() {
            addCriterion("EXT5 is not null");
            return (Criteria) this;
        }

        public Criteria andExt5EqualTo(String value) {
            addCriterion("EXT5 =", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotEqualTo(String value) {
            addCriterion("EXT5 <>", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThan(String value) {
            addCriterion("EXT5 >", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThanOrEqualTo(String value) {
            addCriterion("EXT5 >=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThan(String value) {
            addCriterion("EXT5 <", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThanOrEqualTo(String value) {
            addCriterion("EXT5 <=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Like(String value) {
            addCriterion("EXT5 like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotLike(String value) {
            addCriterion("EXT5 not like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5In(List<String> values) {
            addCriterion("EXT5 in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotIn(List<String> values) {
            addCriterion("EXT5 not in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Between(String value1, String value2) {
            addCriterion("EXT5 between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotBetween(String value1, String value2) {
            addCriterion("EXT5 not between", value1, value2, "ext5");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}