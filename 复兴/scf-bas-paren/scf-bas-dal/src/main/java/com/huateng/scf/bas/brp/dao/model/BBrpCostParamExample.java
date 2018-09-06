package com.huateng.scf.bas.brp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBrpCostParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBrpCostParamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BBrpCostParamExample(BBrpCostParamExample example) {
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

        public Criteria andCostCodeIsNull() {
            addCriterion("COST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCostCodeIsNotNull() {
            addCriterion("COST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCostCodeEqualTo(String value) {
            addCriterion("COST_CODE =", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotEqualTo(String value) {
            addCriterion("COST_CODE <>", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeGreaterThan(String value) {
            addCriterion("COST_CODE >", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COST_CODE >=", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeLessThan(String value) {
            addCriterion("COST_CODE <", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeLessThanOrEqualTo(String value) {
            addCriterion("COST_CODE <=", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeLike(String value) {
            addCriterion("COST_CODE like", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotLike(String value) {
            addCriterion("COST_CODE not like", value, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeIn(List<String> values) {
            addCriterion("COST_CODE in", values, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotIn(List<String> values) {
            addCriterion("COST_CODE not in", values, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeBetween(String value1, String value2) {
            addCriterion("COST_CODE between", value1, value2, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostCodeNotBetween(String value1, String value2) {
            addCriterion("COST_CODE not between", value1, value2, "costCode");
            return (Criteria) this;
        }

        public Criteria andCostNameIsNull() {
            addCriterion("COST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCostNameIsNotNull() {
            addCriterion("COST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCostNameEqualTo(String value) {
            addCriterion("COST_NAME =", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotEqualTo(String value) {
            addCriterion("COST_NAME <>", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameGreaterThan(String value) {
            addCriterion("COST_NAME >", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameGreaterThanOrEqualTo(String value) {
            addCriterion("COST_NAME >=", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameLessThan(String value) {
            addCriterion("COST_NAME <", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameLessThanOrEqualTo(String value) {
            addCriterion("COST_NAME <=", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameLike(String value) {
            addCriterion("COST_NAME like", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotLike(String value) {
            addCriterion("COST_NAME not like", value, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameIn(List<String> values) {
            addCriterion("COST_NAME in", values, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotIn(List<String> values) {
            addCriterion("COST_NAME not in", values, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameBetween(String value1, String value2) {
            addCriterion("COST_NAME between", value1, value2, "costName");
            return (Criteria) this;
        }

        public Criteria andCostNameNotBetween(String value1, String value2) {
            addCriterion("COST_NAME not between", value1, value2, "costName");
            return (Criteria) this;
        }

        public Criteria andCostClassIsNull() {
            addCriterion("COST_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andCostClassIsNotNull() {
            addCriterion("COST_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andCostClassEqualTo(String value) {
            addCriterion("COST_CLASS =", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotEqualTo(String value) {
            addCriterion("COST_CLASS <>", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassGreaterThan(String value) {
            addCriterion("COST_CLASS >", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassGreaterThanOrEqualTo(String value) {
            addCriterion("COST_CLASS >=", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassLessThan(String value) {
            addCriterion("COST_CLASS <", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassLessThanOrEqualTo(String value) {
            addCriterion("COST_CLASS <=", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassLike(String value) {
            addCriterion("COST_CLASS like", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotLike(String value) {
            addCriterion("COST_CLASS not like", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassIn(List<String> values) {
            addCriterion("COST_CLASS in", values, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotIn(List<String> values) {
            addCriterion("COST_CLASS not in", values, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassBetween(String value1, String value2) {
            addCriterion("COST_CLASS between", value1, value2, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotBetween(String value1, String value2) {
            addCriterion("COST_CLASS not between", value1, value2, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNull() {
            addCriterion("COST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNotNull() {
            addCriterion("COST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeEqualTo(String value) {
            addCriterion("COST_TYPE =", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotEqualTo(String value) {
            addCriterion("COST_TYPE <>", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThan(String value) {
            addCriterion("COST_TYPE >", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("COST_TYPE >=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThan(String value) {
            addCriterion("COST_TYPE <", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThanOrEqualTo(String value) {
            addCriterion("COST_TYPE <=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLike(String value) {
            addCriterion("COST_TYPE like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotLike(String value) {
            addCriterion("COST_TYPE not like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeIn(List<String> values) {
            addCriterion("COST_TYPE in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotIn(List<String> values) {
            addCriterion("COST_TYPE not in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeBetween(String value1, String value2) {
            addCriterion("COST_TYPE between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotBetween(String value1, String value2) {
            addCriterion("COST_TYPE not between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeIsNull() {
            addCriterion("COST_CALC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeIsNotNull() {
            addCriterion("COST_CALC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeEqualTo(String value) {
            addCriterion("COST_CALC_TYPE =", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeNotEqualTo(String value) {
            addCriterion("COST_CALC_TYPE <>", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeGreaterThan(String value) {
            addCriterion("COST_CALC_TYPE >", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("COST_CALC_TYPE >=", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeLessThan(String value) {
            addCriterion("COST_CALC_TYPE <", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeLessThanOrEqualTo(String value) {
            addCriterion("COST_CALC_TYPE <=", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeLike(String value) {
            addCriterion("COST_CALC_TYPE like", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeNotLike(String value) {
            addCriterion("COST_CALC_TYPE not like", value, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeIn(List<String> values) {
            addCriterion("COST_CALC_TYPE in", values, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeNotIn(List<String> values) {
            addCriterion("COST_CALC_TYPE not in", values, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeBetween(String value1, String value2) {
            addCriterion("COST_CALC_TYPE between", value1, value2, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andCostCalcTypeNotBetween(String value1, String value2) {
            addCriterion("COST_CALC_TYPE not between", value1, value2, "costCalcType");
            return (Criteria) this;
        }

        public Criteria andMinRateIsNull() {
            addCriterion("MIN_RATE is null");
            return (Criteria) this;
        }

        public Criteria andMinRateIsNotNull() {
            addCriterion("MIN_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andMinRateEqualTo(BigDecimal value) {
            addCriterion("MIN_RATE =", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateNotEqualTo(BigDecimal value) {
            addCriterion("MIN_RATE <>", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateGreaterThan(BigDecimal value) {
            addCriterion("MIN_RATE >", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_RATE >=", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateLessThan(BigDecimal value) {
            addCriterion("MIN_RATE <", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_RATE <=", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateIn(List<BigDecimal> values) {
            addCriterion("MIN_RATE in", values, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateNotIn(List<BigDecimal> values) {
            addCriterion("MIN_RATE not in", values, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_RATE between", value1, value2, "minRate");
            return (Criteria) this;
        }

        public Criteria andMinRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_RATE not between", value1, value2, "minRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateIsNull() {
            addCriterion("MAX_RATE is null");
            return (Criteria) this;
        }

        public Criteria andMaxRateIsNotNull() {
            addCriterion("MAX_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRateEqualTo(BigDecimal value) {
            addCriterion("MAX_RATE =", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateNotEqualTo(BigDecimal value) {
            addCriterion("MAX_RATE <>", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateGreaterThan(BigDecimal value) {
            addCriterion("MAX_RATE >", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_RATE >=", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateLessThan(BigDecimal value) {
            addCriterion("MAX_RATE <", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_RATE <=", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateIn(List<BigDecimal> values) {
            addCriterion("MAX_RATE in", values, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateNotIn(List<BigDecimal> values) {
            addCriterion("MAX_RATE not in", values, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_RATE between", value1, value2, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_RATE not between", value1, value2, "maxRate");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("CHARGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("CHARGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(String value) {
            addCriterion("CHARGE_TYPE =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(String value) {
            addCriterion("CHARGE_TYPE <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(String value) {
            addCriterion("CHARGE_TYPE >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGE_TYPE >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(String value) {
            addCriterion("CHARGE_TYPE <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(String value) {
            addCriterion("CHARGE_TYPE <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLike(String value) {
            addCriterion("CHARGE_TYPE like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotLike(String value) {
            addCriterion("CHARGE_TYPE not like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<String> values) {
            addCriterion("CHARGE_TYPE in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<String> values) {
            addCriterion("CHARGE_TYPE not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(String value1, String value2) {
            addCriterion("CHARGE_TYPE between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(String value1, String value2) {
            addCriterion("CHARGE_TYPE not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andCostDescIsNull() {
            addCriterion("COST_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCostDescIsNotNull() {
            addCriterion("COST_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCostDescEqualTo(String value) {
            addCriterion("COST_DESC =", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotEqualTo(String value) {
            addCriterion("COST_DESC <>", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescGreaterThan(String value) {
            addCriterion("COST_DESC >", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescGreaterThanOrEqualTo(String value) {
            addCriterion("COST_DESC >=", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescLessThan(String value) {
            addCriterion("COST_DESC <", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescLessThanOrEqualTo(String value) {
            addCriterion("COST_DESC <=", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescLike(String value) {
            addCriterion("COST_DESC like", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotLike(String value) {
            addCriterion("COST_DESC not like", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescIn(List<String> values) {
            addCriterion("COST_DESC in", values, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotIn(List<String> values) {
            addCriterion("COST_DESC not in", values, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescBetween(String value1, String value2) {
            addCriterion("COST_DESC between", value1, value2, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotBetween(String value1, String value2) {
            addCriterion("COST_DESC not between", value1, value2, "costDesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}