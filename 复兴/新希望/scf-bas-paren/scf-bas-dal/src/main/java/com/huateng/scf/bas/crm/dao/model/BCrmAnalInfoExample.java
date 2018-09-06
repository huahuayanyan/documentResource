package com.huateng.scf.bas.crm.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrmAnalInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrmAnalInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrmAnalInfoExample(BCrmAnalInfoExample example) {
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

        public Criteria andAnalDateIsNull() {
            addCriterion("ANAL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAnalDateIsNotNull() {
            addCriterion("ANAL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAnalDateEqualTo(String value) {
            addCriterion("ANAL_DATE =", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateNotEqualTo(String value) {
            addCriterion("ANAL_DATE <>", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateGreaterThan(String value) {
            addCriterion("ANAL_DATE >", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateGreaterThanOrEqualTo(String value) {
            addCriterion("ANAL_DATE >=", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateLessThan(String value) {
            addCriterion("ANAL_DATE <", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateLessThanOrEqualTo(String value) {
            addCriterion("ANAL_DATE <=", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateLike(String value) {
            addCriterion("ANAL_DATE like", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateNotLike(String value) {
            addCriterion("ANAL_DATE not like", value, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateIn(List<String> values) {
            addCriterion("ANAL_DATE in", values, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateNotIn(List<String> values) {
            addCriterion("ANAL_DATE not in", values, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateBetween(String value1, String value2) {
            addCriterion("ANAL_DATE between", value1, value2, "analDate");
            return (Criteria) this;
        }

        public Criteria andAnalDateNotBetween(String value1, String value2) {
            addCriterion("ANAL_DATE not between", value1, value2, "analDate");
            return (Criteria) this;
        }

        public Criteria andManageQualIsNull() {
            addCriterion("MANAGE_QUAL is null");
            return (Criteria) this;
        }

        public Criteria andManageQualIsNotNull() {
            addCriterion("MANAGE_QUAL is not null");
            return (Criteria) this;
        }

        public Criteria andManageQualEqualTo(String value) {
            addCriterion("MANAGE_QUAL =", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualNotEqualTo(String value) {
            addCriterion("MANAGE_QUAL <>", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualGreaterThan(String value) {
            addCriterion("MANAGE_QUAL >", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualGreaterThanOrEqualTo(String value) {
            addCriterion("MANAGE_QUAL >=", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualLessThan(String value) {
            addCriterion("MANAGE_QUAL <", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualLessThanOrEqualTo(String value) {
            addCriterion("MANAGE_QUAL <=", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualLike(String value) {
            addCriterion("MANAGE_QUAL like", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualNotLike(String value) {
            addCriterion("MANAGE_QUAL not like", value, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualIn(List<String> values) {
            addCriterion("MANAGE_QUAL in", values, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualNotIn(List<String> values) {
            addCriterion("MANAGE_QUAL not in", values, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualBetween(String value1, String value2) {
            addCriterion("MANAGE_QUAL between", value1, value2, "manageQual");
            return (Criteria) this;
        }

        public Criteria andManageQualNotBetween(String value1, String value2) {
            addCriterion("MANAGE_QUAL not between", value1, value2, "manageQual");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirIsNull() {
            addCriterion("MARKET_ENVIR is null");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirIsNotNull() {
            addCriterion("MARKET_ENVIR is not null");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirEqualTo(String value) {
            addCriterion("MARKET_ENVIR =", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirNotEqualTo(String value) {
            addCriterion("MARKET_ENVIR <>", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirGreaterThan(String value) {
            addCriterion("MARKET_ENVIR >", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirGreaterThanOrEqualTo(String value) {
            addCriterion("MARKET_ENVIR >=", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirLessThan(String value) {
            addCriterion("MARKET_ENVIR <", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirLessThanOrEqualTo(String value) {
            addCriterion("MARKET_ENVIR <=", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirLike(String value) {
            addCriterion("MARKET_ENVIR like", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirNotLike(String value) {
            addCriterion("MARKET_ENVIR not like", value, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirIn(List<String> values) {
            addCriterion("MARKET_ENVIR in", values, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirNotIn(List<String> values) {
            addCriterion("MARKET_ENVIR not in", values, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirBetween(String value1, String value2) {
            addCriterion("MARKET_ENVIR between", value1, value2, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andMarketEnvirNotBetween(String value1, String value2) {
            addCriterion("MARKET_ENVIR not between", value1, value2, "marketEnvir");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRegisterIsNull() {
            addCriterion("REGISTER is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIsNotNull() {
            addCriterion("REGISTER is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterEqualTo(String value) {
            addCriterion("REGISTER =", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotEqualTo(String value) {
            addCriterion("REGISTER <>", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterGreaterThan(String value) {
            addCriterion("REGISTER >", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER >=", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLessThan(String value) {
            addCriterion("REGISTER <", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLessThanOrEqualTo(String value) {
            addCriterion("REGISTER <=", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLike(String value) {
            addCriterion("REGISTER like", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotLike(String value) {
            addCriterion("REGISTER not like", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterIn(List<String> values) {
            addCriterion("REGISTER in", values, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotIn(List<String> values) {
            addCriterion("REGISTER not in", values, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterBetween(String value1, String value2) {
            addCriterion("REGISTER between", value1, value2, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotBetween(String value1, String value2) {
            addCriterion("REGISTER not between", value1, value2, "register");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}