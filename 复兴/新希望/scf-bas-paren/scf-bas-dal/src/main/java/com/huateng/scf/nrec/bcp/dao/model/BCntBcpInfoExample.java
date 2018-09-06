package com.huateng.scf.nrec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntBcpInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntBcpInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntBcpInfoExample(BCntBcpInfoExample example) {
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

        public Criteria andLoanPercentIsNull() {
            addCriterion("LOAN_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIsNotNull() {
            addCriterion("LOAN_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPercentEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT =", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT <>", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentGreaterThan(BigDecimal value) {
            addCriterion("LOAN_PERCENT >", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT >=", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentLessThan(BigDecimal value) {
            addCriterion("LOAN_PERCENT <", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT <=", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIn(List<BigDecimal> values) {
            addCriterion("LOAN_PERCENT in", values, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_PERCENT not in", values, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PERCENT between", value1, value2, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PERCENT not between", value1, value2, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andFactTypeIsNull() {
            addCriterion("FACT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFactTypeIsNotNull() {
            addCriterion("FACT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFactTypeEqualTo(String value) {
            addCriterion("FACT_TYPE =", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotEqualTo(String value) {
            addCriterion("FACT_TYPE <>", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeGreaterThan(String value) {
            addCriterion("FACT_TYPE >", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FACT_TYPE >=", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeLessThan(String value) {
            addCriterion("FACT_TYPE <", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeLessThanOrEqualTo(String value) {
            addCriterion("FACT_TYPE <=", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeLike(String value) {
            addCriterion("FACT_TYPE like", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotLike(String value) {
            addCriterion("FACT_TYPE not like", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeIn(List<String> values) {
            addCriterion("FACT_TYPE in", values, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotIn(List<String> values) {
            addCriterion("FACT_TYPE not in", values, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeBetween(String value1, String value2) {
            addCriterion("FACT_TYPE between", value1, value2, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotBetween(String value1, String value2) {
            addCriterion("FACT_TYPE not between", value1, value2, "factType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeIsNull() {
            addCriterion("FINANCING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeIsNotNull() {
            addCriterion("FINANCING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeEqualTo(String value) {
            addCriterion("FINANCING_TYPE =", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotEqualTo(String value) {
            addCriterion("FINANCING_TYPE <>", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeGreaterThan(String value) {
            addCriterion("FINANCING_TYPE >", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FINANCING_TYPE >=", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeLessThan(String value) {
            addCriterion("FINANCING_TYPE <", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeLessThanOrEqualTo(String value) {
            addCriterion("FINANCING_TYPE <=", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeLike(String value) {
            addCriterion("FINANCING_TYPE like", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotLike(String value) {
            addCriterion("FINANCING_TYPE not like", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeIn(List<String> values) {
            addCriterion("FINANCING_TYPE in", values, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotIn(List<String> values) {
            addCriterion("FINANCING_TYPE not in", values, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeBetween(String value1, String value2) {
            addCriterion("FINANCING_TYPE between", value1, value2, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotBetween(String value1, String value2) {
            addCriterion("FINANCING_TYPE not between", value1, value2, "financingType");
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

        public Criteria andContAmountIsNull() {
            addCriterion("CONT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andContAmountIsNotNull() {
            addCriterion("CONT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andContAmountEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT =", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountNotEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT <>", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountGreaterThan(BigDecimal value) {
            addCriterion("CONT_AMOUNT >", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT >=", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountLessThan(BigDecimal value) {
            addCriterion("CONT_AMOUNT <", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT <=", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountIn(List<BigDecimal> values) {
            addCriterion("CONT_AMOUNT in", values, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountNotIn(List<BigDecimal> values) {
            addCriterion("CONT_AMOUNT not in", values, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_AMOUNT between", value1, value2, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_AMOUNT not between", value1, value2, "contAmount");
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

        public Criteria andContStatusIsNull() {
            addCriterion("CONT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andContStatusIsNotNull() {
            addCriterion("CONT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andContStatusEqualTo(String value) {
            addCriterion("CONT_STATUS =", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotEqualTo(String value) {
            addCriterion("CONT_STATUS <>", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusGreaterThan(String value) {
            addCriterion("CONT_STATUS >", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_STATUS >=", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusLessThan(String value) {
            addCriterion("CONT_STATUS <", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusLessThanOrEqualTo(String value) {
            addCriterion("CONT_STATUS <=", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusLike(String value) {
            addCriterion("CONT_STATUS like", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotLike(String value) {
            addCriterion("CONT_STATUS not like", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusIn(List<String> values) {
            addCriterion("CONT_STATUS in", values, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotIn(List<String> values) {
            addCriterion("CONT_STATUS not in", values, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusBetween(String value1, String value2) {
            addCriterion("CONT_STATUS between", value1, value2, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotBetween(String value1, String value2) {
            addCriterion("CONT_STATUS not between", value1, value2, "contStatus");
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

        public Criteria andReparationProtNoIsNull() {
            addCriterion("REPARATION_PROT_NO is null");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoIsNotNull() {
            addCriterion("REPARATION_PROT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO =", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO <>", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoGreaterThan(String value) {
            addCriterion("REPARATION_PROT_NO >", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoGreaterThanOrEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO >=", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoLessThan(String value) {
            addCriterion("REPARATION_PROT_NO <", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoLessThanOrEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO <=", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoLike(String value) {
            addCriterion("REPARATION_PROT_NO like", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotLike(String value) {
            addCriterion("REPARATION_PROT_NO not like", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoIn(List<String> values) {
            addCriterion("REPARATION_PROT_NO in", values, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotIn(List<String> values) {
            addCriterion("REPARATION_PROT_NO not in", values, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoBetween(String value1, String value2) {
            addCriterion("REPARATION_PROT_NO between", value1, value2, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotBetween(String value1, String value2) {
            addCriterion("REPARATION_PROT_NO not between", value1, value2, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaserIsNull() {
            addCriterion("REPURCHASER is null");
            return (Criteria) this;
        }

        public Criteria andRepurchaserIsNotNull() {
            addCriterion("REPURCHASER is not null");
            return (Criteria) this;
        }

        public Criteria andRepurchaserEqualTo(String value) {
            addCriterion("REPURCHASER =", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotEqualTo(String value) {
            addCriterion("REPURCHASER <>", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserGreaterThan(String value) {
            addCriterion("REPURCHASER >", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserGreaterThanOrEqualTo(String value) {
            addCriterion("REPURCHASER >=", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserLessThan(String value) {
            addCriterion("REPURCHASER <", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserLessThanOrEqualTo(String value) {
            addCriterion("REPURCHASER <=", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserLike(String value) {
            addCriterion("REPURCHASER like", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotLike(String value) {
            addCriterion("REPURCHASER not like", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserIn(List<String> values) {
            addCriterion("REPURCHASER in", values, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotIn(List<String> values) {
            addCriterion("REPURCHASER not in", values, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserBetween(String value1, String value2) {
            addCriterion("REPURCHASER between", value1, value2, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotBetween(String value1, String value2) {
            addCriterion("REPURCHASER not between", value1, value2, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoIsNull() {
            addCriterion("REPURCHASE_PROT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoIsNotNull() {
            addCriterion("REPURCHASE_PROT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO =", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO <>", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoGreaterThan(String value) {
            addCriterion("REPURCHASE_PROT_NO >", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoGreaterThanOrEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO >=", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoLessThan(String value) {
            addCriterion("REPURCHASE_PROT_NO <", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoLessThanOrEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO <=", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoLike(String value) {
            addCriterion("REPURCHASE_PROT_NO like", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotLike(String value) {
            addCriterion("REPURCHASE_PROT_NO not like", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoIn(List<String> values) {
            addCriterion("REPURCHASE_PROT_NO in", values, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotIn(List<String> values) {
            addCriterion("REPURCHASE_PROT_NO not in", values, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoBetween(String value1, String value2) {
            addCriterion("REPURCHASE_PROT_NO between", value1, value2, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotBetween(String value1, String value2) {
            addCriterion("REPURCHASE_PROT_NO not between", value1, value2, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeIsNull() {
            addCriterion("FACTORING_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeIsNotNull() {
            addCriterion("FACTORING_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeEqualTo(String value) {
            addCriterion("FACTORING_BRCODE =", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotEqualTo(String value) {
            addCriterion("FACTORING_BRCODE <>", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeGreaterThan(String value) {
            addCriterion("FACTORING_BRCODE >", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("FACTORING_BRCODE >=", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeLessThan(String value) {
            addCriterion("FACTORING_BRCODE <", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeLessThanOrEqualTo(String value) {
            addCriterion("FACTORING_BRCODE <=", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeLike(String value) {
            addCriterion("FACTORING_BRCODE like", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotLike(String value) {
            addCriterion("FACTORING_BRCODE not like", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeIn(List<String> values) {
            addCriterion("FACTORING_BRCODE in", values, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotIn(List<String> values) {
            addCriterion("FACTORING_BRCODE not in", values, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeBetween(String value1, String value2) {
            addCriterion("FACTORING_BRCODE between", value1, value2, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotBetween(String value1, String value2) {
            addCriterion("FACTORING_BRCODE not between", value1, value2, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andReparationTermIsNull() {
            addCriterion("REPARATION_TERM is null");
            return (Criteria) this;
        }

        public Criteria andReparationTermIsNotNull() {
            addCriterion("REPARATION_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andReparationTermEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM =", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermNotEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM <>", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermGreaterThan(BigDecimal value) {
            addCriterion("REPARATION_TERM >", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM >=", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermLessThan(BigDecimal value) {
            addCriterion("REPARATION_TERM <", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM <=", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermIn(List<BigDecimal> values) {
            addCriterion("REPARATION_TERM in", values, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermNotIn(List<BigDecimal> values) {
            addCriterion("REPARATION_TERM not in", values, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_TERM between", value1, value2, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_TERM not between", value1, value2, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationPercentIsNull() {
            addCriterion("REPARATION_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andReparationPercentIsNotNull() {
            addCriterion("REPARATION_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andReparationPercentEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT =", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentNotEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT <>", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentGreaterThan(BigDecimal value) {
            addCriterion("REPARATION_PERCENT >", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT >=", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentLessThan(BigDecimal value) {
            addCriterion("REPARATION_PERCENT <", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT <=", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentIn(List<BigDecimal> values) {
            addCriterion("REPARATION_PERCENT in", values, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentNotIn(List<BigDecimal> values) {
            addCriterion("REPARATION_PERCENT not in", values, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_PERCENT between", value1, value2, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_PERCENT not between", value1, value2, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtIsNull() {
            addCriterion("CUMULATIVE_REPARATION_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtIsNotNull() {
            addCriterion("CUMULATIVE_REPARATION_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT =", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtNotEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT <>", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtGreaterThan(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT >", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT >=", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtLessThan(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT <", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT <=", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtIn(List<BigDecimal> values) {
            addCriterion("CUMULATIVE_REPARATION_AMT in", values, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtNotIn(List<BigDecimal> values) {
            addCriterion("CUMULATIVE_REPARATION_AMT not in", values, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUMULATIVE_REPARATION_AMT between", value1, value2, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUMULATIVE_REPARATION_AMT not between", value1, value2, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andFactPatternIsNull() {
            addCriterion("FACT_PATTERN is null");
            return (Criteria) this;
        }

        public Criteria andFactPatternIsNotNull() {
            addCriterion("FACT_PATTERN is not null");
            return (Criteria) this;
        }

        public Criteria andFactPatternEqualTo(String value) {
            addCriterion("FACT_PATTERN =", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotEqualTo(String value) {
            addCriterion("FACT_PATTERN <>", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternGreaterThan(String value) {
            addCriterion("FACT_PATTERN >", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternGreaterThanOrEqualTo(String value) {
            addCriterion("FACT_PATTERN >=", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternLessThan(String value) {
            addCriterion("FACT_PATTERN <", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternLessThanOrEqualTo(String value) {
            addCriterion("FACT_PATTERN <=", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternLike(String value) {
            addCriterion("FACT_PATTERN like", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotLike(String value) {
            addCriterion("FACT_PATTERN not like", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternIn(List<String> values) {
            addCriterion("FACT_PATTERN in", values, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotIn(List<String> values) {
            addCriterion("FACT_PATTERN not in", values, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternBetween(String value1, String value2) {
            addCriterion("FACT_PATTERN between", value1, value2, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotBetween(String value1, String value2) {
            addCriterion("FACT_PATTERN not between", value1, value2, "factPattern");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIsNull() {
            addCriterion("COOPERATION_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIsNotNull() {
            addCriterion("COOPERATION_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE =", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE <>", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeGreaterThan(String value) {
            addCriterion("COOPERATION_BRCODE >", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE >=", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLessThan(String value) {
            addCriterion("COOPERATION_BRCODE <", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLessThanOrEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE <=", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLike(String value) {
            addCriterion("COOPERATION_BRCODE like", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotLike(String value) {
            addCriterion("COOPERATION_BRCODE not like", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIn(List<String> values) {
            addCriterion("COOPERATION_BRCODE in", values, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotIn(List<String> values) {
            addCriterion("COOPERATION_BRCODE not in", values, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeBetween(String value1, String value2) {
            addCriterion("COOPERATION_BRCODE between", value1, value2, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotBetween(String value1, String value2) {
            addCriterion("COOPERATION_BRCODE not between", value1, value2, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andLeaseIsNull() {
            addCriterion("LEASE is null");
            return (Criteria) this;
        }

        public Criteria andLeaseIsNotNull() {
            addCriterion("LEASE is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEqualTo(String value) {
            addCriterion("LEASE =", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotEqualTo(String value) {
            addCriterion("LEASE <>", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseGreaterThan(String value) {
            addCriterion("LEASE >", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseGreaterThanOrEqualTo(String value) {
            addCriterion("LEASE >=", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseLessThan(String value) {
            addCriterion("LEASE <", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseLessThanOrEqualTo(String value) {
            addCriterion("LEASE <=", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseLike(String value) {
            addCriterion("LEASE like", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotLike(String value) {
            addCriterion("LEASE not like", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseIn(List<String> values) {
            addCriterion("LEASE in", values, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotIn(List<String> values) {
            addCriterion("LEASE not in", values, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseBetween(String value1, String value2) {
            addCriterion("LEASE between", value1, value2, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotBetween(String value1, String value2) {
            addCriterion("LEASE not between", value1, value2, "lease");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayIsNull() {
            addCriterion("RENT_SETTLE_WAY is null");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayIsNotNull() {
            addCriterion("RENT_SETTLE_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY =", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY <>", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayGreaterThan(String value) {
            addCriterion("RENT_SETTLE_WAY >", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayGreaterThanOrEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY >=", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayLessThan(String value) {
            addCriterion("RENT_SETTLE_WAY <", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayLessThanOrEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY <=", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayLike(String value) {
            addCriterion("RENT_SETTLE_WAY like", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotLike(String value) {
            addCriterion("RENT_SETTLE_WAY not like", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayIn(List<String> values) {
            addCriterion("RENT_SETTLE_WAY in", values, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotIn(List<String> values) {
            addCriterion("RENT_SETTLE_WAY not in", values, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayBetween(String value1, String value2) {
            addCriterion("RENT_SETTLE_WAY between", value1, value2, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotBetween(String value1, String value2) {
            addCriterion("RENT_SETTLE_WAY not between", value1, value2, "rentSettleWay");
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

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME not between", value1, value2, "crtTime");
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

        public Criteria andLastUpdTlrcdIsNull() {
            addCriterion("LAST_UPD_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIsNotNull() {
            addCriterion("LAST_UPD_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD =", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <>", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThan(String value) {
            addCriterion("LAST_UPD_TLRCD >", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD >=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThan(String value) {
            addCriterion("LAST_UPD_TLRCD <", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLike(String value) {
            addCriterion("LAST_UPD_TLRCD like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotLike(String value) {
            addCriterion("LAST_UPD_TLRCD not like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD not in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD not between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNull() {
            addCriterion("LAST_UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNotNull() {
            addCriterion("LAST_UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME =", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <>", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThan(Date value) {
            addCriterion("LAST_UPD_TIME >", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME >=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThan(Date value) {
            addCriterion("LAST_UPD_TIME <", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME not in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME not between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNull() {
            addCriterion("LAST_UPD_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNotNull() {
            addCriterion("LAST_UPD_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE =", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <>", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThan(String value) {
            addCriterion("LAST_UPD_BRCODE >", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE >=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThan(String value) {
            addCriterion("LAST_UPD_BRCODE <", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLike(String value) {
            addCriterion("LAST_UPD_BRCODE like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotLike(String value) {
            addCriterion("LAST_UPD_BRCODE not like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE not in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE between", value1, value2, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE not between", value1, value2, "lastUpdBrcode");
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