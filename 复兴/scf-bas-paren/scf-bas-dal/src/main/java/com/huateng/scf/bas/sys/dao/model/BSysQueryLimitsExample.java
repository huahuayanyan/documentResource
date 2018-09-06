package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysQueryLimitsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysQueryLimitsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysQueryLimitsExample(BSysQueryLimitsExample example) {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNoIsNull() {
            addCriterion("ROLE_NO is null");
            return (Criteria) this;
        }

        public Criteria andRoleNoIsNotNull() {
            addCriterion("ROLE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNoEqualTo(String value) {
            addCriterion("ROLE_NO =", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoNotEqualTo(String value) {
            addCriterion("ROLE_NO <>", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoGreaterThan(String value) {
            addCriterion("ROLE_NO >", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NO >=", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoLessThan(String value) {
            addCriterion("ROLE_NO <", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NO <=", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoLike(String value) {
            addCriterion("ROLE_NO like", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoNotLike(String value) {
            addCriterion("ROLE_NO not like", value, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoIn(List<String> values) {
            addCriterion("ROLE_NO in", values, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoNotIn(List<String> values) {
            addCriterion("ROLE_NO not in", values, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoBetween(String value1, String value2) {
            addCriterion("ROLE_NO between", value1, value2, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleNoNotBetween(String value1, String value2) {
            addCriterion("ROLE_NO not between", value1, value2, "roleNo");
            return (Criteria) this;
        }

        public Criteria andRoleModelIsNull() {
            addCriterion("ROLE_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andRoleModelIsNotNull() {
            addCriterion("ROLE_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andRoleModelEqualTo(String value) {
            addCriterion("ROLE_MODEL =", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelNotEqualTo(String value) {
            addCriterion("ROLE_MODEL <>", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelGreaterThan(String value) {
            addCriterion("ROLE_MODEL >", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_MODEL >=", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelLessThan(String value) {
            addCriterion("ROLE_MODEL <", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelLessThanOrEqualTo(String value) {
            addCriterion("ROLE_MODEL <=", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelLike(String value) {
            addCriterion("ROLE_MODEL like", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelNotLike(String value) {
            addCriterion("ROLE_MODEL not like", value, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelIn(List<String> values) {
            addCriterion("ROLE_MODEL in", values, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelNotIn(List<String> values) {
            addCriterion("ROLE_MODEL not in", values, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelBetween(String value1, String value2) {
            addCriterion("ROLE_MODEL between", value1, value2, "roleModel");
            return (Criteria) this;
        }

        public Criteria andRoleModelNotBetween(String value1, String value2) {
            addCriterion("ROLE_MODEL not between", value1, value2, "roleModel");
            return (Criteria) this;
        }

        public Criteria andInpDtIsNull() {
            addCriterion("INP_DT is null");
            return (Criteria) this;
        }

        public Criteria andInpDtIsNotNull() {
            addCriterion("INP_DT is not null");
            return (Criteria) this;
        }

        public Criteria andInpDtEqualTo(String value) {
            addCriterion("INP_DT =", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotEqualTo(String value) {
            addCriterion("INP_DT <>", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtGreaterThan(String value) {
            addCriterion("INP_DT >", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtGreaterThanOrEqualTo(String value) {
            addCriterion("INP_DT >=", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLessThan(String value) {
            addCriterion("INP_DT <", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLessThanOrEqualTo(String value) {
            addCriterion("INP_DT <=", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLike(String value) {
            addCriterion("INP_DT like", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotLike(String value) {
            addCriterion("INP_DT not like", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtIn(List<String> values) {
            addCriterion("INP_DT in", values, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotIn(List<String> values) {
            addCriterion("INP_DT not in", values, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtBetween(String value1, String value2) {
            addCriterion("INP_DT between", value1, value2, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotBetween(String value1, String value2) {
            addCriterion("INP_DT not between", value1, value2, "inpDt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}