package com.huateng.scf.bas.dcr.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDcrLinTypExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDcrLinTypExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BDcrLinTypExample(BDcrLinTypExample example) {
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

        public Criteria andCrIdIsNull() {
            addCriterion("CR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCrIdIsNotNull() {
            addCriterion("CR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCrIdEqualTo(String value) {
            addCriterion("CR_ID =", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotEqualTo(String value) {
            addCriterion("CR_ID <>", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdGreaterThan(String value) {
            addCriterion("CR_ID >", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdGreaterThanOrEqualTo(String value) {
            addCriterion("CR_ID >=", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdLessThan(String value) {
            addCriterion("CR_ID <", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdLessThanOrEqualTo(String value) {
            addCriterion("CR_ID <=", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdLike(String value) {
            addCriterion("CR_ID like", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotLike(String value) {
            addCriterion("CR_ID not like", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdIn(List<String> values) {
            addCriterion("CR_ID in", values, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotIn(List<String> values) {
            addCriterion("CR_ID not in", values, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdBetween(String value1, String value2) {
            addCriterion("CR_ID between", value1, value2, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotBetween(String value1, String value2) {
            addCriterion("CR_ID not between", value1, value2, "crId");
            return (Criteria) this;
        }

        public Criteria andCrNmIsNull() {
            addCriterion("CR_NM is null");
            return (Criteria) this;
        }

        public Criteria andCrNmIsNotNull() {
            addCriterion("CR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCrNmEqualTo(String value) {
            addCriterion("CR_NM =", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmNotEqualTo(String value) {
            addCriterion("CR_NM <>", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmGreaterThan(String value) {
            addCriterion("CR_NM >", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmGreaterThanOrEqualTo(String value) {
            addCriterion("CR_NM >=", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmLessThan(String value) {
            addCriterion("CR_NM <", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmLessThanOrEqualTo(String value) {
            addCriterion("CR_NM <=", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmLike(String value) {
            addCriterion("CR_NM like", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmNotLike(String value) {
            addCriterion("CR_NM not like", value, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmIn(List<String> values) {
            addCriterion("CR_NM in", values, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmNotIn(List<String> values) {
            addCriterion("CR_NM not in", values, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmBetween(String value1, String value2) {
            addCriterion("CR_NM between", value1, value2, "crNm");
            return (Criteria) this;
        }

        public Criteria andCrNmNotBetween(String value1, String value2) {
            addCriterion("CR_NM not between", value1, value2, "crNm");
            return (Criteria) this;
        }

        public Criteria andChkExprIsNull() {
            addCriterion("CHK_EXPR is null");
            return (Criteria) this;
        }

        public Criteria andChkExprIsNotNull() {
            addCriterion("CHK_EXPR is not null");
            return (Criteria) this;
        }

        public Criteria andChkExprEqualTo(String value) {
            addCriterion("CHK_EXPR =", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprNotEqualTo(String value) {
            addCriterion("CHK_EXPR <>", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprGreaterThan(String value) {
            addCriterion("CHK_EXPR >", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_EXPR >=", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprLessThan(String value) {
            addCriterion("CHK_EXPR <", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprLessThanOrEqualTo(String value) {
            addCriterion("CHK_EXPR <=", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprLike(String value) {
            addCriterion("CHK_EXPR like", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprNotLike(String value) {
            addCriterion("CHK_EXPR not like", value, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprIn(List<String> values) {
            addCriterion("CHK_EXPR in", values, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprNotIn(List<String> values) {
            addCriterion("CHK_EXPR not in", values, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprBetween(String value1, String value2) {
            addCriterion("CHK_EXPR between", value1, value2, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andChkExprNotBetween(String value1, String value2) {
            addCriterion("CHK_EXPR not between", value1, value2, "chkExpr");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}