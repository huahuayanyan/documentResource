package com.huateng.scf.nrec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntBcpExtInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntBcpExtInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntBcpExtInfoExample(BCntBcpExtInfoExample example) {
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

        public Criteria andBusinessNoIsNull() {
            addCriterion("BUSINESS_NO is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIsNotNull() {
            addCriterion("BUSINESS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoEqualTo(String value) {
            addCriterion("BUSINESS_NO =", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotEqualTo(String value) {
            addCriterion("BUSINESS_NO <>", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThan(String value) {
            addCriterion("BUSINESS_NO >", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NO >=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThan(String value) {
            addCriterion("BUSINESS_NO <", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NO <=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLike(String value) {
            addCriterion("BUSINESS_NO like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotLike(String value) {
            addCriterion("BUSINESS_NO not like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIn(List<String> values) {
            addCriterion("BUSINESS_NO in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotIn(List<String> values) {
            addCriterion("BUSINESS_NO not in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoBetween(String value1, String value2) {
            addCriterion("BUSINESS_NO between", value1, value2, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_NO not between", value1, value2, "businessNo");
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

        public Criteria andLoanDaysIsNull() {
            addCriterion("LOAN_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIsNotNull() {
            addCriterion("LOAN_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDaysEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS =", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS <>", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysGreaterThan(BigDecimal value) {
            addCriterion("LOAN_DAYS >", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS >=", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysLessThan(BigDecimal value) {
            addCriterion("LOAN_DAYS <", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_DAYS <=", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIn(List<BigDecimal> values) {
            addCriterion("LOAN_DAYS in", values, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_DAYS not in", values, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_DAYS between", value1, value2, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_DAYS not between", value1, value2, "loanDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysIsNull() {
            addCriterion("DEBT_GRACE_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysIsNotNull() {
            addCriterion("DEBT_GRACE_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysEqualTo(BigDecimal value) {
            addCriterion("DEBT_GRACE_DAYS =", value, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysNotEqualTo(BigDecimal value) {
            addCriterion("DEBT_GRACE_DAYS <>", value, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysGreaterThan(BigDecimal value) {
            addCriterion("DEBT_GRACE_DAYS >", value, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBT_GRACE_DAYS >=", value, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysLessThan(BigDecimal value) {
            addCriterion("DEBT_GRACE_DAYS <", value, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBT_GRACE_DAYS <=", value, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysIn(List<BigDecimal> values) {
            addCriterion("DEBT_GRACE_DAYS in", values, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysNotIn(List<BigDecimal> values) {
            addCriterion("DEBT_GRACE_DAYS not in", values, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBT_GRACE_DAYS between", value1, value2, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andDebtGraceDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBT_GRACE_DAYS not between", value1, value2, "debtGraceDays");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNull() {
            addCriterion("BUSINESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNotNull() {
            addCriterion("BUSINESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameEqualTo(String value) {
            addCriterion("BUSINESS_NAME =", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotEqualTo(String value) {
            addCriterion("BUSINESS_NAME <>", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThan(String value) {
            addCriterion("BUSINESS_NAME >", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME >=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThan(String value) {
            addCriterion("BUSINESS_NAME <", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME <=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLike(String value) {
            addCriterion("BUSINESS_NAME like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotLike(String value) {
            addCriterion("BUSINESS_NAME not like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIn(List<String> values) {
            addCriterion("BUSINESS_NAME in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotIn(List<String> values) {
            addCriterion("BUSINESS_NAME not in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME not between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNull() {
            addCriterion("BATCH_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNotNull() {
            addCriterion("BATCH_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberEqualTo(String value) {
            addCriterion("BATCH_NUMBER =", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("BATCH_NUMBER <>", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("BATCH_NUMBER >", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NUMBER >=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThan(String value) {
            addCriterion("BATCH_NUMBER <", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NUMBER <=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLike(String value) {
            addCriterion("BATCH_NUMBER like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotLike(String value) {
            addCriterion("BATCH_NUMBER not like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIn(List<String> values) {
            addCriterion("BATCH_NUMBER in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("BATCH_NUMBER not in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("BATCH_NUMBER between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("BATCH_NUMBER not between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andCreditTermIsNull() {
            addCriterion("CREDIT_TERM is null");
            return (Criteria) this;
        }

        public Criteria andCreditTermIsNotNull() {
            addCriterion("CREDIT_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andCreditTermEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TERM =", value, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TERM <>", value, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_TERM >", value, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TERM >=", value, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermLessThan(BigDecimal value) {
            addCriterion("CREDIT_TERM <", value, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TERM <=", value, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermIn(List<BigDecimal> values) {
            addCriterion("CREDIT_TERM in", values, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_TERM not in", values, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_TERM between", value1, value2, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditTermNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_TERM not between", value1, value2, "creditTerm");
            return (Criteria) this;
        }

        public Criteria andCreditAmtIsNull() {
            addCriterion("CREDIT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCreditAmtIsNotNull() {
            addCriterion("CREDIT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditAmtEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMT =", value, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMT <>", value, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_AMT >", value, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMT >=", value, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtLessThan(BigDecimal value) {
            addCriterion("CREDIT_AMT <", value, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMT <=", value, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtIn(List<BigDecimal> values) {
            addCriterion("CREDIT_AMT in", values, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_AMT not in", values, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_AMT between", value1, value2, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andCreditAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_AMT not between", value1, value2, "creditAmt");
            return (Criteria) this;
        }

        public Criteria andRiskTermIsNull() {
            addCriterion("RISK_TERM is null");
            return (Criteria) this;
        }

        public Criteria andRiskTermIsNotNull() {
            addCriterion("RISK_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andRiskTermEqualTo(BigDecimal value) {
            addCriterion("RISK_TERM =", value, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermNotEqualTo(BigDecimal value) {
            addCriterion("RISK_TERM <>", value, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermGreaterThan(BigDecimal value) {
            addCriterion("RISK_TERM >", value, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_TERM >=", value, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermLessThan(BigDecimal value) {
            addCriterion("RISK_TERM <", value, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_TERM <=", value, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermIn(List<BigDecimal> values) {
            addCriterion("RISK_TERM in", values, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermNotIn(List<BigDecimal> values) {
            addCriterion("RISK_TERM not in", values, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_TERM between", value1, value2, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRiskTermNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_TERM not between", value1, value2, "riskTerm");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeIsNull() {
            addCriterion("RECOVER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeIsNotNull() {
            addCriterion("RECOVER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeEqualTo(String value) {
            addCriterion("RECOVER_TYPE =", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotEqualTo(String value) {
            addCriterion("RECOVER_TYPE <>", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeGreaterThan(String value) {
            addCriterion("RECOVER_TYPE >", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RECOVER_TYPE >=", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeLessThan(String value) {
            addCriterion("RECOVER_TYPE <", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeLessThanOrEqualTo(String value) {
            addCriterion("RECOVER_TYPE <=", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeLike(String value) {
            addCriterion("RECOVER_TYPE like", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotLike(String value) {
            addCriterion("RECOVER_TYPE not like", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeIn(List<String> values) {
            addCriterion("RECOVER_TYPE in", values, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotIn(List<String> values) {
            addCriterion("RECOVER_TYPE not in", values, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeBetween(String value1, String value2) {
            addCriterion("RECOVER_TYPE between", value1, value2, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotBetween(String value1, String value2) {
            addCriterion("RECOVER_TYPE not between", value1, value2, "recoverType");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}