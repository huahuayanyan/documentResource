package com.huateng.scf.nrec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntInsuranceContInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntInsuranceContInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntInsuranceContInfoExample(BCntInsuranceContInfoExample example) {
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

        public Criteria andInsuranceCustcdIsNull() {
            addCriterion("INSURANCE_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdIsNotNull() {
            addCriterion("INSURANCE_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdEqualTo(String value) {
            addCriterion("INSURANCE_CUSTCD =", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdNotEqualTo(String value) {
            addCriterion("INSURANCE_CUSTCD <>", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdGreaterThan(String value) {
            addCriterion("INSURANCE_CUSTCD >", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("INSURANCE_CUSTCD >=", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdLessThan(String value) {
            addCriterion("INSURANCE_CUSTCD <", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdLessThanOrEqualTo(String value) {
            addCriterion("INSURANCE_CUSTCD <=", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdLike(String value) {
            addCriterion("INSURANCE_CUSTCD like", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdNotLike(String value) {
            addCriterion("INSURANCE_CUSTCD not like", value, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdIn(List<String> values) {
            addCriterion("INSURANCE_CUSTCD in", values, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdNotIn(List<String> values) {
            addCriterion("INSURANCE_CUSTCD not in", values, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdBetween(String value1, String value2) {
            addCriterion("INSURANCE_CUSTCD between", value1, value2, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceCustcdNotBetween(String value1, String value2) {
            addCriterion("INSURANCE_CUSTCD not between", value1, value2, "insuranceCustcd");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIsNull() {
            addCriterion("INSURANCE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIsNotNull() {
            addCriterion("INSURANCE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_FEE =", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_FEE <>", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeGreaterThan(BigDecimal value) {
            addCriterion("INSURANCE_FEE >", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_FEE >=", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeLessThan(BigDecimal value) {
            addCriterion("INSURANCE_FEE <", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_FEE <=", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIn(List<BigDecimal> values) {
            addCriterion("INSURANCE_FEE in", values, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotIn(List<BigDecimal> values) {
            addCriterion("INSURANCE_FEE not in", values, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSURANCE_FEE between", value1, value2, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSURANCE_FEE not between", value1, value2, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andReparationFactorIsNull() {
            addCriterion("REPARATION_FACTOR is null");
            return (Criteria) this;
        }

        public Criteria andReparationFactorIsNotNull() {
            addCriterion("REPARATION_FACTOR is not null");
            return (Criteria) this;
        }

        public Criteria andReparationFactorEqualTo(BigDecimal value) {
            addCriterion("REPARATION_FACTOR =", value, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorNotEqualTo(BigDecimal value) {
            addCriterion("REPARATION_FACTOR <>", value, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorGreaterThan(BigDecimal value) {
            addCriterion("REPARATION_FACTOR >", value, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_FACTOR >=", value, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorLessThan(BigDecimal value) {
            addCriterion("REPARATION_FACTOR <", value, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_FACTOR <=", value, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorIn(List<BigDecimal> values) {
            addCriterion("REPARATION_FACTOR in", values, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorNotIn(List<BigDecimal> values) {
            addCriterion("REPARATION_FACTOR not in", values, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_FACTOR between", value1, value2, "reparationFactor");
            return (Criteria) this;
        }

        public Criteria andReparationFactorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_FACTOR not between", value1, value2, "reparationFactor");
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

        public Criteria andTopReparationAmtIsNull() {
            addCriterion("TOP_REPARATION_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtIsNotNull() {
            addCriterion("TOP_REPARATION_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtEqualTo(BigDecimal value) {
            addCriterion("TOP_REPARATION_AMT =", value, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtNotEqualTo(BigDecimal value) {
            addCriterion("TOP_REPARATION_AMT <>", value, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtGreaterThan(BigDecimal value) {
            addCriterion("TOP_REPARATION_AMT >", value, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOP_REPARATION_AMT >=", value, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtLessThan(BigDecimal value) {
            addCriterion("TOP_REPARATION_AMT <", value, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOP_REPARATION_AMT <=", value, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtIn(List<BigDecimal> values) {
            addCriterion("TOP_REPARATION_AMT in", values, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtNotIn(List<BigDecimal> values) {
            addCriterion("TOP_REPARATION_AMT not in", values, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOP_REPARATION_AMT between", value1, value2, "topReparationAmt");
            return (Criteria) this;
        }

        public Criteria andTopReparationAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOP_REPARATION_AMT not between", value1, value2, "topReparationAmt");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}