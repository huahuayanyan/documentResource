package com.huateng.scf.bas.dcr.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDcrLinInfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDcrLinInfExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BDcrLinInfExample(BDcrLinInfExample example) {
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

        public Criteria andLinIdIsNull() {
            addCriterion("LIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andLinIdIsNotNull() {
            addCriterion("LIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLinIdEqualTo(String value) {
            addCriterion("LIN_ID =", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotEqualTo(String value) {
            addCriterion("LIN_ID <>", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdGreaterThan(String value) {
            addCriterion("LIN_ID >", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdGreaterThanOrEqualTo(String value) {
            addCriterion("LIN_ID >=", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdLessThan(String value) {
            addCriterion("LIN_ID <", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdLessThanOrEqualTo(String value) {
            addCriterion("LIN_ID <=", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdLike(String value) {
            addCriterion("LIN_ID like", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotLike(String value) {
            addCriterion("LIN_ID not like", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdIn(List<String> values) {
            addCriterion("LIN_ID in", values, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotIn(List<String> values) {
            addCriterion("LIN_ID not in", values, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdBetween(String value1, String value2) {
            addCriterion("LIN_ID between", value1, value2, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotBetween(String value1, String value2) {
            addCriterion("LIN_ID not between", value1, value2, "linId");
            return (Criteria) this;
        }

        public Criteria andLinTypIsNull() {
            addCriterion("LIN_TYP is null");
            return (Criteria) this;
        }

        public Criteria andLinTypIsNotNull() {
            addCriterion("LIN_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andLinTypEqualTo(String value) {
            addCriterion("LIN_TYP =", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypNotEqualTo(String value) {
            addCriterion("LIN_TYP <>", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypGreaterThan(String value) {
            addCriterion("LIN_TYP >", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypGreaterThanOrEqualTo(String value) {
            addCriterion("LIN_TYP >=", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypLessThan(String value) {
            addCriterion("LIN_TYP <", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypLessThanOrEqualTo(String value) {
            addCriterion("LIN_TYP <=", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypLike(String value) {
            addCriterion("LIN_TYP like", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypNotLike(String value) {
            addCriterion("LIN_TYP not like", value, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypIn(List<String> values) {
            addCriterion("LIN_TYP in", values, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypNotIn(List<String> values) {
            addCriterion("LIN_TYP not in", values, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypBetween(String value1, String value2) {
            addCriterion("LIN_TYP between", value1, value2, "linTyp");
            return (Criteria) this;
        }

        public Criteria andLinTypNotBetween(String value1, String value2) {
            addCriterion("LIN_TYP not between", value1, value2, "linTyp");
            return (Criteria) this;
        }

        public Criteria andBusNmIsNull() {
            addCriterion("BUS_NM is null");
            return (Criteria) this;
        }

        public Criteria andBusNmIsNotNull() {
            addCriterion("BUS_NM is not null");
            return (Criteria) this;
        }

        public Criteria andBusNmEqualTo(String value) {
            addCriterion("BUS_NM =", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmNotEqualTo(String value) {
            addCriterion("BUS_NM <>", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmGreaterThan(String value) {
            addCriterion("BUS_NM >", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmGreaterThanOrEqualTo(String value) {
            addCriterion("BUS_NM >=", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmLessThan(String value) {
            addCriterion("BUS_NM <", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmLessThanOrEqualTo(String value) {
            addCriterion("BUS_NM <=", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmLike(String value) {
            addCriterion("BUS_NM like", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmNotLike(String value) {
            addCriterion("BUS_NM not like", value, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmIn(List<String> values) {
            addCriterion("BUS_NM in", values, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmNotIn(List<String> values) {
            addCriterion("BUS_NM not in", values, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmBetween(String value1, String value2) {
            addCriterion("BUS_NM between", value1, value2, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusNmNotBetween(String value1, String value2) {
            addCriterion("BUS_NM not between", value1, value2, "busNm");
            return (Criteria) this;
        }

        public Criteria andBusTypIsNull() {
            addCriterion("BUS_TYP is null");
            return (Criteria) this;
        }

        public Criteria andBusTypIsNotNull() {
            addCriterion("BUS_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andBusTypEqualTo(String value) {
            addCriterion("BUS_TYP =", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypNotEqualTo(String value) {
            addCriterion("BUS_TYP <>", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypGreaterThan(String value) {
            addCriterion("BUS_TYP >", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypGreaterThanOrEqualTo(String value) {
            addCriterion("BUS_TYP >=", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypLessThan(String value) {
            addCriterion("BUS_TYP <", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypLessThanOrEqualTo(String value) {
            addCriterion("BUS_TYP <=", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypLike(String value) {
            addCriterion("BUS_TYP like", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypNotLike(String value) {
            addCriterion("BUS_TYP not like", value, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypIn(List<String> values) {
            addCriterion("BUS_TYP in", values, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypNotIn(List<String> values) {
            addCriterion("BUS_TYP not in", values, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypBetween(String value1, String value2) {
            addCriterion("BUS_TYP between", value1, value2, "busTyp");
            return (Criteria) this;
        }

        public Criteria andBusTypNotBetween(String value1, String value2) {
            addCriterion("BUS_TYP not between", value1, value2, "busTyp");
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

        public Criteria andCrAmtIsNull() {
            addCriterion("CR_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCrAmtIsNotNull() {
            addCriterion("CR_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCrAmtEqualTo(BigDecimal value) {
            addCriterion("CR_AMT =", value, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtNotEqualTo(BigDecimal value) {
            addCriterion("CR_AMT <>", value, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtGreaterThan(BigDecimal value) {
            addCriterion("CR_AMT >", value, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CR_AMT >=", value, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtLessThan(BigDecimal value) {
            addCriterion("CR_AMT <", value, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CR_AMT <=", value, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtIn(List<BigDecimal> values) {
            addCriterion("CR_AMT in", values, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtNotIn(List<BigDecimal> values) {
            addCriterion("CR_AMT not in", values, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CR_AMT between", value1, value2, "crAmt");
            return (Criteria) this;
        }

        public Criteria andCrAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CR_AMT not between", value1, value2, "crAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNull() {
            addCriterion("RISK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNotNull() {
            addCriterion("RISK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT =", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <>", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("RISK_AMT >", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT >=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThan(BigDecimal value) {
            addCriterion("RISK_AMT <", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT not in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT not between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andCircFlagIsNull() {
            addCriterion("CIRC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCircFlagIsNotNull() {
            addCriterion("CIRC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCircFlagEqualTo(String value) {
            addCriterion("CIRC_FLAG =", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagNotEqualTo(String value) {
            addCriterion("CIRC_FLAG <>", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagGreaterThan(String value) {
            addCriterion("CIRC_FLAG >", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CIRC_FLAG >=", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagLessThan(String value) {
            addCriterion("CIRC_FLAG <", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagLessThanOrEqualTo(String value) {
            addCriterion("CIRC_FLAG <=", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagLike(String value) {
            addCriterion("CIRC_FLAG like", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagNotLike(String value) {
            addCriterion("CIRC_FLAG not like", value, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagIn(List<String> values) {
            addCriterion("CIRC_FLAG in", values, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagNotIn(List<String> values) {
            addCriterion("CIRC_FLAG not in", values, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagBetween(String value1, String value2) {
            addCriterion("CIRC_FLAG between", value1, value2, "circFlag");
            return (Criteria) this;
        }

        public Criteria andCircFlagNotBetween(String value1, String value2) {
            addCriterion("CIRC_FLAG not between", value1, value2, "circFlag");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andLinLvlIsNull() {
            addCriterion("LIN_LVL is null");
            return (Criteria) this;
        }

        public Criteria andLinLvlIsNotNull() {
            addCriterion("LIN_LVL is not null");
            return (Criteria) this;
        }

        public Criteria andLinLvlEqualTo(BigDecimal value) {
            addCriterion("LIN_LVL =", value, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlNotEqualTo(BigDecimal value) {
            addCriterion("LIN_LVL <>", value, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlGreaterThan(BigDecimal value) {
            addCriterion("LIN_LVL >", value, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIN_LVL >=", value, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlLessThan(BigDecimal value) {
            addCriterion("LIN_LVL <", value, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIN_LVL <=", value, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlIn(List<BigDecimal> values) {
            addCriterion("LIN_LVL in", values, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlNotIn(List<BigDecimal> values) {
            addCriterion("LIN_LVL not in", values, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIN_LVL between", value1, value2, "linLvl");
            return (Criteria) this;
        }

        public Criteria andLinLvlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIN_LVL not between", value1, value2, "linLvl");
            return (Criteria) this;
        }

        public Criteria andUsedNumIsNull() {
            addCriterion("USED_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUsedNumIsNotNull() {
            addCriterion("USED_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUsedNumEqualTo(BigDecimal value) {
            addCriterion("USED_NUM =", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotEqualTo(BigDecimal value) {
            addCriterion("USED_NUM <>", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumGreaterThan(BigDecimal value) {
            addCriterion("USED_NUM >", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_NUM >=", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumLessThan(BigDecimal value) {
            addCriterion("USED_NUM <", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_NUM <=", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumIn(List<BigDecimal> values) {
            addCriterion("USED_NUM in", values, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotIn(List<BigDecimal> values) {
            addCriterion("USED_NUM not in", values, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_NUM between", value1, value2, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_NUM not between", value1, value2, "usedNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumIsNull() {
            addCriterion("ABLE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAbleNumIsNotNull() {
            addCriterion("ABLE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAbleNumEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM =", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumNotEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM <>", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumGreaterThan(BigDecimal value) {
            addCriterion("ABLE_NUM >", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM >=", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumLessThan(BigDecimal value) {
            addCriterion("ABLE_NUM <", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM <=", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumIn(List<BigDecimal> values) {
            addCriterion("ABLE_NUM in", values, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumNotIn(List<BigDecimal> values) {
            addCriterion("ABLE_NUM not in", values, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABLE_NUM between", value1, value2, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABLE_NUM not between", value1, value2, "ableNum");
            return (Criteria) this;
        }

        public Criteria andBcCrIdIsNull() {
            addCriterion("BC_CR_ID is null");
            return (Criteria) this;
        }

        public Criteria andBcCrIdIsNotNull() {
            addCriterion("BC_CR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBcCrIdEqualTo(String value) {
            addCriterion("BC_CR_ID =", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdNotEqualTo(String value) {
            addCriterion("BC_CR_ID <>", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdGreaterThan(String value) {
            addCriterion("BC_CR_ID >", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdGreaterThanOrEqualTo(String value) {
            addCriterion("BC_CR_ID >=", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdLessThan(String value) {
            addCriterion("BC_CR_ID <", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdLessThanOrEqualTo(String value) {
            addCriterion("BC_CR_ID <=", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdLike(String value) {
            addCriterion("BC_CR_ID like", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdNotLike(String value) {
            addCriterion("BC_CR_ID not like", value, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdIn(List<String> values) {
            addCriterion("BC_CR_ID in", values, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdNotIn(List<String> values) {
            addCriterion("BC_CR_ID not in", values, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdBetween(String value1, String value2) {
            addCriterion("BC_CR_ID between", value1, value2, "bcCrId");
            return (Criteria) this;
        }

        public Criteria andBcCrIdNotBetween(String value1, String value2) {
            addCriterion("BC_CR_ID not between", value1, value2, "bcCrId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}