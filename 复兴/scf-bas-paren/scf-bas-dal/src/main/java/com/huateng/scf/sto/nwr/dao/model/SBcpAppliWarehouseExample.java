package com.huateng.scf.sto.nwr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SBcpAppliWarehouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SBcpAppliWarehouseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected SBcpAppliWarehouseExample(SBcpAppliWarehouseExample example) {
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

        public Criteria andTheRPAmountIsNull() {
            addCriterion("THE_R_P_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountIsNotNull() {
            addCriterion("THE_R_P_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountEqualTo(BigDecimal value) {
            addCriterion("THE_R_P_AMOUNT =", value, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountNotEqualTo(BigDecimal value) {
            addCriterion("THE_R_P_AMOUNT <>", value, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountGreaterThan(BigDecimal value) {
            addCriterion("THE_R_P_AMOUNT >", value, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THE_R_P_AMOUNT >=", value, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountLessThan(BigDecimal value) {
            addCriterion("THE_R_P_AMOUNT <", value, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THE_R_P_AMOUNT <=", value, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountIn(List<BigDecimal> values) {
            addCriterion("THE_R_P_AMOUNT in", values, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountNotIn(List<BigDecimal> values) {
            addCriterion("THE_R_P_AMOUNT not in", values, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THE_R_P_AMOUNT between", value1, value2, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andTheRPAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THE_R_P_AMOUNT not between", value1, value2, "theRPAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountIsNull() {
            addCriterion("RISK_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRiskAmountIsNotNull() {
            addCriterion("RISK_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAmountEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT =", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountNotEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT <>", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountGreaterThan(BigDecimal value) {
            addCriterion("RISK_AMOUNT >", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT >=", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountLessThan(BigDecimal value) {
            addCriterion("RISK_AMOUNT <", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT <=", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountIn(List<BigDecimal> values) {
            addCriterion("RISK_AMOUNT in", values, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountNotIn(List<BigDecimal> values) {
            addCriterion("RISK_AMOUNT not in", values, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMOUNT between", value1, value2, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMOUNT not between", value1, value2, "riskAmount");
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

        public Criteria andRemovePledgeAmountIsNull() {
            addCriterion("REMOVE_PLEDGE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountIsNotNull() {
            addCriterion("REMOVE_PLEDGE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_AMOUNT =", value, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountNotEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_AMOUNT <>", value, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountGreaterThan(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_AMOUNT >", value, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_AMOUNT >=", value, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountLessThan(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_AMOUNT <", value, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_AMOUNT <=", value, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountIn(List<BigDecimal> values) {
            addCriterion("REMOVE_PLEDGE_AMOUNT in", values, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountNotIn(List<BigDecimal> values) {
            addCriterion("REMOVE_PLEDGE_AMOUNT not in", values, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMOVE_PLEDGE_AMOUNT between", value1, value2, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMOVE_PLEDGE_AMOUNT not between", value1, value2, "removePledgeAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountIsNull() {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountIsNotNull() {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT =", value, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountNotEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT <>", value, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountGreaterThan(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT >", value, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT >=", value, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountLessThan(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT <", value, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT <=", value, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountIn(List<BigDecimal> values) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT in", values, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountNotIn(List<BigDecimal> values) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT not in", values, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT between", value1, value2, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andRemovePledgeHighestAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMOVE_PLEDGE_HIGHEST_AMOUNT not between", value1, value2, "removePledgeHighestAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountIsNull() {
            addCriterion("RECEIPT_PLEDGE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountIsNotNull() {
            addCriterion("RECEIPT_PLEDGE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountEqualTo(BigDecimal value) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT =", value, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountNotEqualTo(BigDecimal value) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT <>", value, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountGreaterThan(BigDecimal value) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT >", value, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT >=", value, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountLessThan(BigDecimal value) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT <", value, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT <=", value, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountIn(List<BigDecimal> values) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT in", values, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountNotIn(List<BigDecimal> values) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT not in", values, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT between", value1, value2, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptPledgeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIPT_PLEDGE_AMOUNT not between", value1, value2, "receiptPledgeAmount");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}