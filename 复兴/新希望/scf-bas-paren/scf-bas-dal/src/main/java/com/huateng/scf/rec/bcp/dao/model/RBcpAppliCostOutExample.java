package com.huateng.scf.rec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RBcpAppliCostOutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RBcpAppliCostOutExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RBcpAppliCostOutExample(RBcpAppliCostOutExample example) {
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

        public Criteria andCostInfoIdIsNull() {
            addCriterion("COST_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdIsNotNull() {
            addCriterion("COST_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdEqualTo(String value) {
            addCriterion("COST_INFO_ID =", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdNotEqualTo(String value) {
            addCriterion("COST_INFO_ID <>", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdGreaterThan(String value) {
            addCriterion("COST_INFO_ID >", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("COST_INFO_ID >=", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdLessThan(String value) {
            addCriterion("COST_INFO_ID <", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdLessThanOrEqualTo(String value) {
            addCriterion("COST_INFO_ID <=", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdLike(String value) {
            addCriterion("COST_INFO_ID like", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdNotLike(String value) {
            addCriterion("COST_INFO_ID not like", value, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdIn(List<String> values) {
            addCriterion("COST_INFO_ID in", values, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdNotIn(List<String> values) {
            addCriterion("COST_INFO_ID not in", values, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdBetween(String value1, String value2) {
            addCriterion("COST_INFO_ID between", value1, value2, "costInfoId");
            return (Criteria) this;
        }

        public Criteria andCostInfoIdNotBetween(String value1, String value2) {
            addCriterion("COST_INFO_ID not between", value1, value2, "costInfoId");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBussAmtIsNull() {
            addCriterion("BUSS_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBussAmtIsNotNull() {
            addCriterion("BUSS_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBussAmtEqualTo(BigDecimal value) {
            addCriterion("BUSS_AMT =", value, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtNotEqualTo(BigDecimal value) {
            addCriterion("BUSS_AMT <>", value, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtGreaterThan(BigDecimal value) {
            addCriterion("BUSS_AMT >", value, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUSS_AMT >=", value, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtLessThan(BigDecimal value) {
            addCriterion("BUSS_AMT <", value, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUSS_AMT <=", value, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtIn(List<BigDecimal> values) {
            addCriterion("BUSS_AMT in", values, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtNotIn(List<BigDecimal> values) {
            addCriterion("BUSS_AMT not in", values, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUSS_AMT between", value1, value2, "bussAmt");
            return (Criteria) this;
        }

        public Criteria andBussAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUSS_AMT not between", value1, value2, "bussAmt");
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

        public Criteria andReduceAmtIsNull() {
            addCriterion("REDUCE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andReduceAmtIsNotNull() {
            addCriterion("REDUCE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andReduceAmtEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMT =", value, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtNotEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMT <>", value, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtGreaterThan(BigDecimal value) {
            addCriterion("REDUCE_AMT >", value, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMT >=", value, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtLessThan(BigDecimal value) {
            addCriterion("REDUCE_AMT <", value, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMT <=", value, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtIn(List<BigDecimal> values) {
            addCriterion("REDUCE_AMT in", values, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtNotIn(List<BigDecimal> values) {
            addCriterion("REDUCE_AMT not in", values, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_AMT between", value1, value2, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReduceAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_AMT not between", value1, value2, "reduceAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIsNull() {
            addCriterion("RECEIVE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIsNotNull() {
            addCriterion("RECEIVE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT =", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT <>", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountGreaterThan(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT >", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT >=", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountLessThan(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT <", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT <=", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIn(List<BigDecimal> values) {
            addCriterion("RECEIVE_AMOUNT in", values, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVE_AMOUNT not in", values, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVE_AMOUNT between", value1, value2, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVE_AMOUNT not between", value1, value2, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andCostAccountIsNull() {
            addCriterion("COST_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCostAccountIsNotNull() {
            addCriterion("COST_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCostAccountEqualTo(String value) {
            addCriterion("COST_ACCOUNT =", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountNotEqualTo(String value) {
            addCriterion("COST_ACCOUNT <>", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountGreaterThan(String value) {
            addCriterion("COST_ACCOUNT >", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountGreaterThanOrEqualTo(String value) {
            addCriterion("COST_ACCOUNT >=", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountLessThan(String value) {
            addCriterion("COST_ACCOUNT <", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountLessThanOrEqualTo(String value) {
            addCriterion("COST_ACCOUNT <=", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountLike(String value) {
            addCriterion("COST_ACCOUNT like", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountNotLike(String value) {
            addCriterion("COST_ACCOUNT not like", value, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountIn(List<String> values) {
            addCriterion("COST_ACCOUNT in", values, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountNotIn(List<String> values) {
            addCriterion("COST_ACCOUNT not in", values, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountBetween(String value1, String value2) {
            addCriterion("COST_ACCOUNT between", value1, value2, "costAccount");
            return (Criteria) this;
        }

        public Criteria andCostAccountNotBetween(String value1, String value2) {
            addCriterion("COST_ACCOUNT not between", value1, value2, "costAccount");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNull() {
            addCriterion("BUSS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNotNull() {
            addCriterion("BUSS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBussTypeEqualTo(String value) {
            addCriterion("BUSS_TYPE =", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotEqualTo(String value) {
            addCriterion("BUSS_TYPE <>", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThan(String value) {
            addCriterion("BUSS_TYPE >", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE >=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThan(String value) {
            addCriterion("BUSS_TYPE <", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE <=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLike(String value) {
            addCriterion("BUSS_TYPE like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotLike(String value) {
            addCriterion("BUSS_TYPE not like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeIn(List<String> values) {
            addCriterion("BUSS_TYPE in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotIn(List<String> values) {
            addCriterion("BUSS_TYPE not in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE not between", value1, value2, "bussType");
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

        public Criteria andCommonDateIsNull() {
            addCriterion("COMMON_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCommonDateIsNotNull() {
            addCriterion("COMMON_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCommonDateEqualTo(String value) {
            addCriterion("COMMON_DATE =", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotEqualTo(String value) {
            addCriterion("COMMON_DATE <>", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateGreaterThan(String value) {
            addCriterion("COMMON_DATE >", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateGreaterThanOrEqualTo(String value) {
            addCriterion("COMMON_DATE >=", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLessThan(String value) {
            addCriterion("COMMON_DATE <", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLessThanOrEqualTo(String value) {
            addCriterion("COMMON_DATE <=", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLike(String value) {
            addCriterion("COMMON_DATE like", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotLike(String value) {
            addCriterion("COMMON_DATE not like", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateIn(List<String> values) {
            addCriterion("COMMON_DATE in", values, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotIn(List<String> values) {
            addCriterion("COMMON_DATE not in", values, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateBetween(String value1, String value2) {
            addCriterion("COMMON_DATE between", value1, value2, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotBetween(String value1, String value2) {
            addCriterion("COMMON_DATE not between", value1, value2, "commonDate");
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

        public Criteria andBussAppnoIsNull() {
            addCriterion("BUSS_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andBussAppnoIsNotNull() {
            addCriterion("BUSS_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andBussAppnoEqualTo(String value) {
            addCriterion("BUSS_APPNO =", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoNotEqualTo(String value) {
            addCriterion("BUSS_APPNO <>", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoGreaterThan(String value) {
            addCriterion("BUSS_APPNO >", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_APPNO >=", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoLessThan(String value) {
            addCriterion("BUSS_APPNO <", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoLessThanOrEqualTo(String value) {
            addCriterion("BUSS_APPNO <=", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoLike(String value) {
            addCriterion("BUSS_APPNO like", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoNotLike(String value) {
            addCriterion("BUSS_APPNO not like", value, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoIn(List<String> values) {
            addCriterion("BUSS_APPNO in", values, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoNotIn(List<String> values) {
            addCriterion("BUSS_APPNO not in", values, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoBetween(String value1, String value2) {
            addCriterion("BUSS_APPNO between", value1, value2, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andBussAppnoNotBetween(String value1, String value2) {
            addCriterion("BUSS_APPNO not between", value1, value2, "bussAppno");
            return (Criteria) this;
        }

        public Criteria andTotalAmtIsNull() {
            addCriterion("TOTAL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmtIsNotNull() {
            addCriterion("TOTAL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmtEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMT =", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMT <>", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_AMT >", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMT >=", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtLessThan(BigDecimal value) {
            addCriterion("TOTAL_AMT <", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMT <=", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtIn(List<BigDecimal> values) {
            addCriterion("TOTAL_AMT in", values, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_AMT not in", values, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_AMT between", value1, value2, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_AMT not between", value1, value2, "totalAmt");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}