package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysChkDirExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysChkDirExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysChkDirExample(BSysChkDirExample example) {
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

        public Criteria andMdlIdIsNull() {
            addCriterion("MDL_ID is null");
            return (Criteria) this;
        }

        public Criteria andMdlIdIsNotNull() {
            addCriterion("MDL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMdlIdEqualTo(String value) {
            addCriterion("MDL_ID =", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotEqualTo(String value) {
            addCriterion("MDL_ID <>", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThan(String value) {
            addCriterion("MDL_ID >", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThanOrEqualTo(String value) {
            addCriterion("MDL_ID >=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThan(String value) {
            addCriterion("MDL_ID <", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThanOrEqualTo(String value) {
            addCriterion("MDL_ID <=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLike(String value) {
            addCriterion("MDL_ID like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotLike(String value) {
            addCriterion("MDL_ID not like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdIn(List<String> values) {
            addCriterion("MDL_ID in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotIn(List<String> values) {
            addCriterion("MDL_ID not in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdBetween(String value1, String value2) {
            addCriterion("MDL_ID between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotBetween(String value1, String value2) {
            addCriterion("MDL_ID not between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlNmIsNull() {
            addCriterion("MDL_NM is null");
            return (Criteria) this;
        }

        public Criteria andMdlNmIsNotNull() {
            addCriterion("MDL_NM is not null");
            return (Criteria) this;
        }

        public Criteria andMdlNmEqualTo(String value) {
            addCriterion("MDL_NM =", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotEqualTo(String value) {
            addCriterion("MDL_NM <>", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmGreaterThan(String value) {
            addCriterion("MDL_NM >", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmGreaterThanOrEqualTo(String value) {
            addCriterion("MDL_NM >=", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmLessThan(String value) {
            addCriterion("MDL_NM <", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmLessThanOrEqualTo(String value) {
            addCriterion("MDL_NM <=", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmLike(String value) {
            addCriterion("MDL_NM like", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotLike(String value) {
            addCriterion("MDL_NM not like", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmIn(List<String> values) {
            addCriterion("MDL_NM in", values, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotIn(List<String> values) {
            addCriterion("MDL_NM not in", values, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmBetween(String value1, String value2) {
            addCriterion("MDL_NM between", value1, value2, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotBetween(String value1, String value2) {
            addCriterion("MDL_NM not between", value1, value2, "mdlNm");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}