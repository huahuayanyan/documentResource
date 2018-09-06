package com.huateng.scf.bas.brp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBrpPrdFactoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBrpPrdFactoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BBrpPrdFactoryExample(BBrpPrdFactoryExample example) {
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

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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

        public Criteria andInoutIsNull() {
            addCriterion("INOUT is null");
            return (Criteria) this;
        }

        public Criteria andInoutIsNotNull() {
            addCriterion("INOUT is not null");
            return (Criteria) this;
        }

        public Criteria andInoutEqualTo(String value) {
            addCriterion("INOUT =", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutNotEqualTo(String value) {
            addCriterion("INOUT <>", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutGreaterThan(String value) {
            addCriterion("INOUT >", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutGreaterThanOrEqualTo(String value) {
            addCriterion("INOUT >=", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutLessThan(String value) {
            addCriterion("INOUT <", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutLessThanOrEqualTo(String value) {
            addCriterion("INOUT <=", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutLike(String value) {
            addCriterion("INOUT like", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutNotLike(String value) {
            addCriterion("INOUT not like", value, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutIn(List<String> values) {
            addCriterion("INOUT in", values, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutNotIn(List<String> values) {
            addCriterion("INOUT not in", values, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutBetween(String value1, String value2) {
            addCriterion("INOUT between", value1, value2, "inout");
            return (Criteria) this;
        }

        public Criteria andInoutNotBetween(String value1, String value2) {
            addCriterion("INOUT not between", value1, value2, "inout");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeIsNull() {
            addCriterion("CALC_RATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeIsNotNull() {
            addCriterion("CALC_RATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeEqualTo(String value) {
            addCriterion("CALC_RATE_TYPE =", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeNotEqualTo(String value) {
            addCriterion("CALC_RATE_TYPE <>", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeGreaterThan(String value) {
            addCriterion("CALC_RATE_TYPE >", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CALC_RATE_TYPE >=", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeLessThan(String value) {
            addCriterion("CALC_RATE_TYPE <", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeLessThanOrEqualTo(String value) {
            addCriterion("CALC_RATE_TYPE <=", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeLike(String value) {
            addCriterion("CALC_RATE_TYPE like", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeNotLike(String value) {
            addCriterion("CALC_RATE_TYPE not like", value, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeIn(List<String> values) {
            addCriterion("CALC_RATE_TYPE in", values, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeNotIn(List<String> values) {
            addCriterion("CALC_RATE_TYPE not in", values, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeBetween(String value1, String value2) {
            addCriterion("CALC_RATE_TYPE between", value1, value2, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andCalcRateTypeNotBetween(String value1, String value2) {
            addCriterion("CALC_RATE_TYPE not between", value1, value2, "calcRateType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeIsNull() {
            addCriterion("RATE_SHARE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeIsNotNull() {
            addCriterion("RATE_SHARE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeEqualTo(String value) {
            addCriterion("RATE_SHARE_TYPE =", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeNotEqualTo(String value) {
            addCriterion("RATE_SHARE_TYPE <>", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeGreaterThan(String value) {
            addCriterion("RATE_SHARE_TYPE >", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RATE_SHARE_TYPE >=", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeLessThan(String value) {
            addCriterion("RATE_SHARE_TYPE <", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeLessThanOrEqualTo(String value) {
            addCriterion("RATE_SHARE_TYPE <=", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeLike(String value) {
            addCriterion("RATE_SHARE_TYPE like", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeNotLike(String value) {
            addCriterion("RATE_SHARE_TYPE not like", value, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeIn(List<String> values) {
            addCriterion("RATE_SHARE_TYPE in", values, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeNotIn(List<String> values) {
            addCriterion("RATE_SHARE_TYPE not in", values, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeBetween(String value1, String value2) {
            addCriterion("RATE_SHARE_TYPE between", value1, value2, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andRateShareTypeNotBetween(String value1, String value2) {
            addCriterion("RATE_SHARE_TYPE not between", value1, value2, "rateShareType");
            return (Criteria) this;
        }

        public Criteria andGraceDaysIsNull() {
            addCriterion("GRACE_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andGraceDaysIsNotNull() {
            addCriterion("GRACE_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andGraceDaysEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS =", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysNotEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS <>", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysGreaterThan(BigDecimal value) {
            addCriterion("GRACE_DAYS >", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS >=", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysLessThan(BigDecimal value) {
            addCriterion("GRACE_DAYS <", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS <=", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysIn(List<BigDecimal> values) {
            addCriterion("GRACE_DAYS in", values, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysNotIn(List<BigDecimal> values) {
            addCriterion("GRACE_DAYS not in", values, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GRACE_DAYS between", value1, value2, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GRACE_DAYS not between", value1, value2, "graceDays");
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

        public Criteria andSellerTypeIsNull() {
            addCriterion("SELLER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSellerTypeIsNotNull() {
            addCriterion("SELLER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSellerTypeEqualTo(String value) {
            addCriterion("SELLER_TYPE =", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotEqualTo(String value) {
            addCriterion("SELLER_TYPE <>", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeGreaterThan(String value) {
            addCriterion("SELLER_TYPE >", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_TYPE >=", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLessThan(String value) {
            addCriterion("SELLER_TYPE <", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLessThanOrEqualTo(String value) {
            addCriterion("SELLER_TYPE <=", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLike(String value) {
            addCriterion("SELLER_TYPE like", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotLike(String value) {
            addCriterion("SELLER_TYPE not like", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeIn(List<String> values) {
            addCriterion("SELLER_TYPE in", values, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotIn(List<String> values) {
            addCriterion("SELLER_TYPE not in", values, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeBetween(String value1, String value2) {
            addCriterion("SELLER_TYPE between", value1, value2, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotBetween(String value1, String value2) {
            addCriterion("SELLER_TYPE not between", value1, value2, "sellerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeIsNull() {
            addCriterion("BUYER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeIsNotNull() {
            addCriterion("BUYER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeEqualTo(String value) {
            addCriterion("BUYER_TYPE =", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeNotEqualTo(String value) {
            addCriterion("BUYER_TYPE <>", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeGreaterThan(String value) {
            addCriterion("BUYER_TYPE >", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUYER_TYPE >=", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeLessThan(String value) {
            addCriterion("BUYER_TYPE <", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeLessThanOrEqualTo(String value) {
            addCriterion("BUYER_TYPE <=", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeLike(String value) {
            addCriterion("BUYER_TYPE like", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeNotLike(String value) {
            addCriterion("BUYER_TYPE not like", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeIn(List<String> values) {
            addCriterion("BUYER_TYPE in", values, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeNotIn(List<String> values) {
            addCriterion("BUYER_TYPE not in", values, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeBetween(String value1, String value2) {
            addCriterion("BUYER_TYPE between", value1, value2, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeNotBetween(String value1, String value2) {
            addCriterion("BUYER_TYPE not between", value1, value2, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeIsNull() {
            addCriterion("BILLS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBillsTypeIsNotNull() {
            addCriterion("BILLS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBillsTypeEqualTo(String value) {
            addCriterion("BILLS_TYPE =", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotEqualTo(String value) {
            addCriterion("BILLS_TYPE <>", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeGreaterThan(String value) {
            addCriterion("BILLS_TYPE >", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BILLS_TYPE >=", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeLessThan(String value) {
            addCriterion("BILLS_TYPE <", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeLessThanOrEqualTo(String value) {
            addCriterion("BILLS_TYPE <=", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeLike(String value) {
            addCriterion("BILLS_TYPE like", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotLike(String value) {
            addCriterion("BILLS_TYPE not like", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeIn(List<String> values) {
            addCriterion("BILLS_TYPE in", values, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotIn(List<String> values) {
            addCriterion("BILLS_TYPE not in", values, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeBetween(String value1, String value2) {
            addCriterion("BILLS_TYPE between", value1, value2, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotBetween(String value1, String value2) {
            addCriterion("BILLS_TYPE not between", value1, value2, "billsType");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagIsNull() {
            addCriterion("LEASE_FACTORING_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagIsNotNull() {
            addCriterion("LEASE_FACTORING_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagEqualTo(String value) {
            addCriterion("LEASE_FACTORING_FLAG =", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagNotEqualTo(String value) {
            addCriterion("LEASE_FACTORING_FLAG <>", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagGreaterThan(String value) {
            addCriterion("LEASE_FACTORING_FLAG >", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagGreaterThanOrEqualTo(String value) {
            addCriterion("LEASE_FACTORING_FLAG >=", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagLessThan(String value) {
            addCriterion("LEASE_FACTORING_FLAG <", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagLessThanOrEqualTo(String value) {
            addCriterion("LEASE_FACTORING_FLAG <=", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagLike(String value) {
            addCriterion("LEASE_FACTORING_FLAG like", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagNotLike(String value) {
            addCriterion("LEASE_FACTORING_FLAG not like", value, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagIn(List<String> values) {
            addCriterion("LEASE_FACTORING_FLAG in", values, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagNotIn(List<String> values) {
            addCriterion("LEASE_FACTORING_FLAG not in", values, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagBetween(String value1, String value2) {
            addCriterion("LEASE_FACTORING_FLAG between", value1, value2, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeaseFactoringFlagNotBetween(String value1, String value2) {
            addCriterion("LEASE_FACTORING_FLAG not between", value1, value2, "leaseFactoringFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagIsNull() {
            addCriterion("LEASEBACK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagIsNotNull() {
            addCriterion("LEASEBACK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagEqualTo(String value) {
            addCriterion("LEASEBACK_FLAG =", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagNotEqualTo(String value) {
            addCriterion("LEASEBACK_FLAG <>", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagGreaterThan(String value) {
            addCriterion("LEASEBACK_FLAG >", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagGreaterThanOrEqualTo(String value) {
            addCriterion("LEASEBACK_FLAG >=", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagLessThan(String value) {
            addCriterion("LEASEBACK_FLAG <", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagLessThanOrEqualTo(String value) {
            addCriterion("LEASEBACK_FLAG <=", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagLike(String value) {
            addCriterion("LEASEBACK_FLAG like", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagNotLike(String value) {
            addCriterion("LEASEBACK_FLAG not like", value, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagIn(List<String> values) {
            addCriterion("LEASEBACK_FLAG in", values, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagNotIn(List<String> values) {
            addCriterion("LEASEBACK_FLAG not in", values, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagBetween(String value1, String value2) {
            addCriterion("LEASEBACK_FLAG between", value1, value2, "leasebackFlag");
            return (Criteria) this;
        }

        public Criteria andLeasebackFlagNotBetween(String value1, String value2) {
            addCriterion("LEASEBACK_FLAG not between", value1, value2, "leasebackFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}