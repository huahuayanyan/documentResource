package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntInsuranceBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntInsuranceBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntInsuranceBaseInfoExample(BCntInsuranceBaseInfoExample example) {
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

        public Criteria andInsuranceNoIsNull() {
            addCriterion("INSURANCE_NO is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIsNotNull() {
            addCriterion("INSURANCE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoEqualTo(String value) {
            addCriterion("INSURANCE_NO =", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotEqualTo(String value) {
            addCriterion("INSURANCE_NO <>", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoGreaterThan(String value) {
            addCriterion("INSURANCE_NO >", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoGreaterThanOrEqualTo(String value) {
            addCriterion("INSURANCE_NO >=", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLessThan(String value) {
            addCriterion("INSURANCE_NO <", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLessThanOrEqualTo(String value) {
            addCriterion("INSURANCE_NO <=", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLike(String value) {
            addCriterion("INSURANCE_NO like", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotLike(String value) {
            addCriterion("INSURANCE_NO not like", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIn(List<String> values) {
            addCriterion("INSURANCE_NO in", values, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotIn(List<String> values) {
            addCriterion("INSURANCE_NO not in", values, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoBetween(String value1, String value2) {
            addCriterion("INSURANCE_NO between", value1, value2, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotBetween(String value1, String value2) {
            addCriterion("INSURANCE_NO not between", value1, value2, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeIsNull() {
            addCriterion("INSURANCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeIsNotNull() {
            addCriterion("INSURANCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeEqualTo(String value) {
            addCriterion("INSURANCE_CODE =", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeNotEqualTo(String value) {
            addCriterion("INSURANCE_CODE <>", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeGreaterThan(String value) {
            addCriterion("INSURANCE_CODE >", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INSURANCE_CODE >=", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeLessThan(String value) {
            addCriterion("INSURANCE_CODE <", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeLessThanOrEqualTo(String value) {
            addCriterion("INSURANCE_CODE <=", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeLike(String value) {
            addCriterion("INSURANCE_CODE like", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeNotLike(String value) {
            addCriterion("INSURANCE_CODE not like", value, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeIn(List<String> values) {
            addCriterion("INSURANCE_CODE in", values, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeNotIn(List<String> values) {
            addCriterion("INSURANCE_CODE not in", values, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeBetween(String value1, String value2) {
            addCriterion("INSURANCE_CODE between", value1, value2, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceCodeNotBetween(String value1, String value2) {
            addCriterion("INSURANCE_CODE not between", value1, value2, "insuranceCode");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeIsNull() {
            addCriterion("INSURANCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeIsNotNull() {
            addCriterion("INSURANCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeEqualTo(String value) {
            addCriterion("INSURANCE_TYPE =", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeNotEqualTo(String value) {
            addCriterion("INSURANCE_TYPE <>", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeGreaterThan(String value) {
            addCriterion("INSURANCE_TYPE >", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INSURANCE_TYPE >=", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeLessThan(String value) {
            addCriterion("INSURANCE_TYPE <", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeLessThanOrEqualTo(String value) {
            addCriterion("INSURANCE_TYPE <=", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeLike(String value) {
            addCriterion("INSURANCE_TYPE like", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeNotLike(String value) {
            addCriterion("INSURANCE_TYPE not like", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeIn(List<String> values) {
            addCriterion("INSURANCE_TYPE in", values, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeNotIn(List<String> values) {
            addCriterion("INSURANCE_TYPE not in", values, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeBetween(String value1, String value2) {
            addCriterion("INSURANCE_TYPE between", value1, value2, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeNotBetween(String value1, String value2) {
            addCriterion("INSURANCE_TYPE not between", value1, value2, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryIsNull() {
            addCriterion("BENEFICIARY is null");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryIsNotNull() {
            addCriterion("BENEFICIARY is not null");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryEqualTo(String value) {
            addCriterion("BENEFICIARY =", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotEqualTo(String value) {
            addCriterion("BENEFICIARY <>", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryGreaterThan(String value) {
            addCriterion("BENEFICIARY >", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryGreaterThanOrEqualTo(String value) {
            addCriterion("BENEFICIARY >=", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryLessThan(String value) {
            addCriterion("BENEFICIARY <", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryLessThanOrEqualTo(String value) {
            addCriterion("BENEFICIARY <=", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryLike(String value) {
            addCriterion("BENEFICIARY like", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotLike(String value) {
            addCriterion("BENEFICIARY not like", value, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryIn(List<String> values) {
            addCriterion("BENEFICIARY in", values, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotIn(List<String> values) {
            addCriterion("BENEFICIARY not in", values, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryBetween(String value1, String value2) {
            addCriterion("BENEFICIARY between", value1, value2, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andBeneficiaryNotBetween(String value1, String value2) {
            addCriterion("BENEFICIARY not between", value1, value2, "beneficiary");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
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

        public Criteria andInsuranceNameIsNull() {
            addCriterion("INSURANCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameIsNotNull() {
            addCriterion("INSURANCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameEqualTo(String value) {
            addCriterion("INSURANCE_NAME =", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotEqualTo(String value) {
            addCriterion("INSURANCE_NAME <>", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameGreaterThan(String value) {
            addCriterion("INSURANCE_NAME >", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameGreaterThanOrEqualTo(String value) {
            addCriterion("INSURANCE_NAME >=", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameLessThan(String value) {
            addCriterion("INSURANCE_NAME <", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameLessThanOrEqualTo(String value) {
            addCriterion("INSURANCE_NAME <=", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameLike(String value) {
            addCriterion("INSURANCE_NAME like", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotLike(String value) {
            addCriterion("INSURANCE_NAME not like", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameIn(List<String> values) {
            addCriterion("INSURANCE_NAME in", values, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotIn(List<String> values) {
            addCriterion("INSURANCE_NAME not in", values, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameBetween(String value1, String value2) {
            addCriterion("INSURANCE_NAME between", value1, value2, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotBetween(String value1, String value2) {
            addCriterion("INSURANCE_NAME not between", value1, value2, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}