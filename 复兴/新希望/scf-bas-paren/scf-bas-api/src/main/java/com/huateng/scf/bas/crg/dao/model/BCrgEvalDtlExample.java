package com.huateng.scf.bas.crg.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtlExample;

public class BCrgEvalDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrgEvalDtlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrgEvalDtlExample(BCrgEvalDtlExample example) {
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

        public Criteria andEvalDtlIdIsNull() {
            addCriterion("EVAL_DTL_ID is null");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdIsNotNull() {
            addCriterion("EVAL_DTL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdEqualTo(String value) {
            addCriterion("EVAL_DTL_ID =", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdNotEqualTo(String value) {
            addCriterion("EVAL_DTL_ID <>", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdGreaterThan(String value) {
            addCriterion("EVAL_DTL_ID >", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_DTL_ID >=", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdLessThan(String value) {
            addCriterion("EVAL_DTL_ID <", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdLessThanOrEqualTo(String value) {
            addCriterion("EVAL_DTL_ID <=", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdLike(String value) {
            addCriterion("EVAL_DTL_ID like", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdNotLike(String value) {
            addCriterion("EVAL_DTL_ID not like", value, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdIn(List<String> values) {
            addCriterion("EVAL_DTL_ID in", values, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdNotIn(List<String> values) {
            addCriterion("EVAL_DTL_ID not in", values, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdBetween(String value1, String value2) {
            addCriterion("EVAL_DTL_ID between", value1, value2, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalDtlIdNotBetween(String value1, String value2) {
            addCriterion("EVAL_DTL_ID not between", value1, value2, "evalDtlId");
            return (Criteria) this;
        }

        public Criteria andEvalIdIsNull() {
            addCriterion("EVAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andEvalIdIsNotNull() {
            addCriterion("EVAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEvalIdEqualTo(String value) {
            addCriterion("EVAL_ID =", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotEqualTo(String value) {
            addCriterion("EVAL_ID <>", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdGreaterThan(String value) {
            addCriterion("EVAL_ID >", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_ID >=", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdLessThan(String value) {
            addCriterion("EVAL_ID <", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdLessThanOrEqualTo(String value) {
            addCriterion("EVAL_ID <=", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdLike(String value) {
            addCriterion("EVAL_ID like", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotLike(String value) {
            addCriterion("EVAL_ID not like", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdIn(List<String> values) {
            addCriterion("EVAL_ID in", values, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotIn(List<String> values) {
            addCriterion("EVAL_ID not in", values, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdBetween(String value1, String value2) {
            addCriterion("EVAL_ID between", value1, value2, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotBetween(String value1, String value2) {
            addCriterion("EVAL_ID not between", value1, value2, "evalId");
            return (Criteria) this;
        }

        public Criteria andRltTypIsNull() {
            addCriterion("RLT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRltTypIsNotNull() {
            addCriterion("RLT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRltTypEqualTo(String value) {
            addCriterion("RLT_TYP =", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotEqualTo(String value) {
            addCriterion("RLT_TYP <>", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypGreaterThan(String value) {
            addCriterion("RLT_TYP >", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_TYP >=", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLessThan(String value) {
            addCriterion("RLT_TYP <", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLessThanOrEqualTo(String value) {
            addCriterion("RLT_TYP <=", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLike(String value) {
            addCriterion("RLT_TYP like", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotLike(String value) {
            addCriterion("RLT_TYP not like", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypIn(List<String> values) {
            addCriterion("RLT_TYP in", values, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotIn(List<String> values) {
            addCriterion("RLT_TYP not in", values, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypBetween(String value1, String value2) {
            addCriterion("RLT_TYP between", value1, value2, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotBetween(String value1, String value2) {
            addCriterion("RLT_TYP not between", value1, value2, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltIdIsNull() {
            addCriterion("RLT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRltIdIsNotNull() {
            addCriterion("RLT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRltIdEqualTo(String value) {
            addCriterion("RLT_ID =", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotEqualTo(String value) {
            addCriterion("RLT_ID <>", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdGreaterThan(String value) {
            addCriterion("RLT_ID >", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_ID >=", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdLessThan(String value) {
            addCriterion("RLT_ID <", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdLessThanOrEqualTo(String value) {
            addCriterion("RLT_ID <=", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdLike(String value) {
            addCriterion("RLT_ID like", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotLike(String value) {
            addCriterion("RLT_ID not like", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdIn(List<String> values) {
            addCriterion("RLT_ID in", values, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotIn(List<String> values) {
            addCriterion("RLT_ID not in", values, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdBetween(String value1, String value2) {
            addCriterion("RLT_ID between", value1, value2, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotBetween(String value1, String value2) {
            addCriterion("RLT_ID not between", value1, value2, "rltId");
            return (Criteria) this;
        }

        public Criteria andItNoIsNull() {
            addCriterion("IT_NO is null");
            return (Criteria) this;
        }

        public Criteria andItNoIsNotNull() {
            addCriterion("IT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andItNoEqualTo(String value) {
            addCriterion("IT_NO =", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoNotEqualTo(String value) {
            addCriterion("IT_NO <>", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoGreaterThan(String value) {
            addCriterion("IT_NO >", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoGreaterThanOrEqualTo(String value) {
            addCriterion("IT_NO >=", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoLessThan(String value) {
            addCriterion("IT_NO <", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoLessThanOrEqualTo(String value) {
            addCriterion("IT_NO <=", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoLike(String value) {
            addCriterion("IT_NO like", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoNotLike(String value) {
            addCriterion("IT_NO not like", value, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoIn(List<String> values) {
            addCriterion("IT_NO in", values, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoNotIn(List<String> values) {
            addCriterion("IT_NO not in", values, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoBetween(String value1, String value2) {
            addCriterion("IT_NO between", value1, value2, "itNo");
            return (Criteria) this;
        }

        public Criteria andItNoNotBetween(String value1, String value2) {
            addCriterion("IT_NO not between", value1, value2, "itNo");
            return (Criteria) this;
        }

        public Criteria andItValIsNull() {
            addCriterion("IT_VAL is null");
            return (Criteria) this;
        }

        public Criteria andItValIsNotNull() {
            addCriterion("IT_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andItValEqualTo(String value) {
            addCriterion("IT_VAL =", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValNotEqualTo(String value) {
            addCriterion("IT_VAL <>", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValGreaterThan(String value) {
            addCriterion("IT_VAL >", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValGreaterThanOrEqualTo(String value) {
            addCriterion("IT_VAL >=", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValLessThan(String value) {
            addCriterion("IT_VAL <", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValLessThanOrEqualTo(String value) {
            addCriterion("IT_VAL <=", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValLike(String value) {
            addCriterion("IT_VAL like", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValNotLike(String value) {
            addCriterion("IT_VAL not like", value, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValIn(List<String> values) {
            addCriterion("IT_VAL in", values, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValNotIn(List<String> values) {
            addCriterion("IT_VAL not in", values, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValBetween(String value1, String value2) {
            addCriterion("IT_VAL between", value1, value2, "itVal");
            return (Criteria) this;
        }

        public Criteria andItValNotBetween(String value1, String value2) {
            addCriterion("IT_VAL not between", value1, value2, "itVal");
            return (Criteria) this;
        }

        public Criteria andChgValIsNull() {
            addCriterion("CHG_VAL is null");
            return (Criteria) this;
        }

        public Criteria andChgValIsNotNull() {
            addCriterion("CHG_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andChgValEqualTo(BigDecimal value) {
            addCriterion("CHG_VAL =", value, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValNotEqualTo(BigDecimal value) {
            addCriterion("CHG_VAL <>", value, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValGreaterThan(BigDecimal value) {
            addCriterion("CHG_VAL >", value, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHG_VAL >=", value, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValLessThan(BigDecimal value) {
            addCriterion("CHG_VAL <", value, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHG_VAL <=", value, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValIn(List<BigDecimal> values) {
            addCriterion("CHG_VAL in", values, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValNotIn(List<BigDecimal> values) {
            addCriterion("CHG_VAL not in", values, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHG_VAL between", value1, value2, "chgVal");
            return (Criteria) this;
        }

        public Criteria andChgValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHG_VAL not between", value1, value2, "chgVal");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}