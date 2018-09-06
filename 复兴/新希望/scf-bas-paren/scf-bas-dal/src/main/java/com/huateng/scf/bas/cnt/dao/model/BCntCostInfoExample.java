package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntCostInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntCostInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntCostInfoExample(BCntCostInfoExample example) {
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

        public Criteria andRelaTypeIsNull() {
            addCriterion("RELA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRelaTypeIsNotNull() {
            addCriterion("RELA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRelaTypeEqualTo(String value) {
            addCriterion("RELA_TYPE =", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotEqualTo(String value) {
            addCriterion("RELA_TYPE <>", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeGreaterThan(String value) {
            addCriterion("RELA_TYPE >", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_TYPE >=", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLessThan(String value) {
            addCriterion("RELA_TYPE <", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLessThanOrEqualTo(String value) {
            addCriterion("RELA_TYPE <=", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLike(String value) {
            addCriterion("RELA_TYPE like", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotLike(String value) {
            addCriterion("RELA_TYPE not like", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeIn(List<String> values) {
            addCriterion("RELA_TYPE in", values, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotIn(List<String> values) {
            addCriterion("RELA_TYPE not in", values, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeBetween(String value1, String value2) {
            addCriterion("RELA_TYPE between", value1, value2, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotBetween(String value1, String value2) {
            addCriterion("RELA_TYPE not between", value1, value2, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNull() {
            addCriterion("RELA_NO is null");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNotNull() {
            addCriterion("RELA_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRelaNoEqualTo(String value) {
            addCriterion("RELA_NO =", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotEqualTo(String value) {
            addCriterion("RELA_NO <>", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThan(String value) {
            addCriterion("RELA_NO >", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_NO >=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThan(String value) {
            addCriterion("RELA_NO <", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThanOrEqualTo(String value) {
            addCriterion("RELA_NO <=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLike(String value) {
            addCriterion("RELA_NO like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotLike(String value) {
            addCriterion("RELA_NO not like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoIn(List<String> values) {
            addCriterion("RELA_NO in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotIn(List<String> values) {
            addCriterion("RELA_NO not in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoBetween(String value1, String value2) {
            addCriterion("RELA_NO between", value1, value2, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotBetween(String value1, String value2) {
            addCriterion("RELA_NO not between", value1, value2, "relaNo");
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

        public Criteria andCostRateIsNull() {
            addCriterion("COST_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNotNull() {
            addCriterion("COST_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCostRateEqualTo(BigDecimal value) {
            addCriterion("COST_RATE =", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotEqualTo(BigDecimal value) {
            addCriterion("COST_RATE <>", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThan(BigDecimal value) {
            addCriterion("COST_RATE >", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_RATE >=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThan(BigDecimal value) {
            addCriterion("COST_RATE <", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_RATE <=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateIn(List<BigDecimal> values) {
            addCriterion("COST_RATE in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotIn(List<BigDecimal> values) {
            addCriterion("COST_RATE not in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_RATE between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_RATE not between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostAmtIsNull() {
            addCriterion("COST_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCostAmtIsNotNull() {
            addCriterion("COST_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCostAmtEqualTo(BigDecimal value) {
            addCriterion("COST_AMT =", value, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtNotEqualTo(BigDecimal value) {
            addCriterion("COST_AMT <>", value, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtGreaterThan(BigDecimal value) {
            addCriterion("COST_AMT >", value, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_AMT >=", value, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtLessThan(BigDecimal value) {
            addCriterion("COST_AMT <", value, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_AMT <=", value, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtIn(List<BigDecimal> values) {
            addCriterion("COST_AMT in", values, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtNotIn(List<BigDecimal> values) {
            addCriterion("COST_AMT not in", values, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_AMT between", value1, value2, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_AMT not between", value1, value2, "costAmt");
            return (Criteria) this;
        }

        public Criteria andCostPhaseIsNull() {
            addCriterion("COST_PHASE is null");
            return (Criteria) this;
        }

        public Criteria andCostPhaseIsNotNull() {
            addCriterion("COST_PHASE is not null");
            return (Criteria) this;
        }

        public Criteria andCostPhaseEqualTo(String value) {
            addCriterion("COST_PHASE =", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotEqualTo(String value) {
            addCriterion("COST_PHASE <>", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseGreaterThan(String value) {
            addCriterion("COST_PHASE >", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseGreaterThanOrEqualTo(String value) {
            addCriterion("COST_PHASE >=", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseLessThan(String value) {
            addCriterion("COST_PHASE <", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseLessThanOrEqualTo(String value) {
            addCriterion("COST_PHASE <=", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseLike(String value) {
            addCriterion("COST_PHASE like", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotLike(String value) {
            addCriterion("COST_PHASE not like", value, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseIn(List<String> values) {
            addCriterion("COST_PHASE in", values, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotIn(List<String> values) {
            addCriterion("COST_PHASE not in", values, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseBetween(String value1, String value2) {
            addCriterion("COST_PHASE between", value1, value2, "costPhase");
            return (Criteria) this;
        }

        public Criteria andCostPhaseNotBetween(String value1, String value2) {
            addCriterion("COST_PHASE not between", value1, value2, "costPhase");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}