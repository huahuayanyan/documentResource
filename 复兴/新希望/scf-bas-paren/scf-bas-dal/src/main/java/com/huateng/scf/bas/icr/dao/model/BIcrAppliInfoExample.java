package com.huateng.scf.bas.icr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BIcrAppliInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BIcrAppliInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BIcrAppliInfoExample(BIcrAppliInfoExample example) {
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

        public Criteria andCreditClassIsNull() {
            addCriterion("CREDIT_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andCreditClassIsNotNull() {
            addCriterion("CREDIT_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andCreditClassEqualTo(String value) {
            addCriterion("CREDIT_CLASS =", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassNotEqualTo(String value) {
            addCriterion("CREDIT_CLASS <>", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassGreaterThan(String value) {
            addCriterion("CREDIT_CLASS >", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_CLASS >=", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassLessThan(String value) {
            addCriterion("CREDIT_CLASS <", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_CLASS <=", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassLike(String value) {
            addCriterion("CREDIT_CLASS like", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassNotLike(String value) {
            addCriterion("CREDIT_CLASS not like", value, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassIn(List<String> values) {
            addCriterion("CREDIT_CLASS in", values, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassNotIn(List<String> values) {
            addCriterion("CREDIT_CLASS not in", values, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassBetween(String value1, String value2) {
            addCriterion("CREDIT_CLASS between", value1, value2, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditClassNotBetween(String value1, String value2) {
            addCriterion("CREDIT_CLASS not between", value1, value2, "creditClass");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIsNull() {
            addCriterion("CREDIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIsNotNull() {
            addCriterion("CREDIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditTypeEqualTo(String value) {
            addCriterion("CREDIT_TYPE =", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotEqualTo(String value) {
            addCriterion("CREDIT_TYPE <>", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeGreaterThan(String value) {
            addCriterion("CREDIT_TYPE >", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_TYPE >=", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLessThan(String value) {
            addCriterion("CREDIT_TYPE <", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_TYPE <=", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLike(String value) {
            addCriterion("CREDIT_TYPE like", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotLike(String value) {
            addCriterion("CREDIT_TYPE not like", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIn(List<String> values) {
            addCriterion("CREDIT_TYPE in", values, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotIn(List<String> values) {
            addCriterion("CREDIT_TYPE not in", values, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeBetween(String value1, String value2) {
            addCriterion("CREDIT_TYPE between", value1, value2, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotBetween(String value1, String value2) {
            addCriterion("CREDIT_TYPE not between", value1, value2, "creditType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNull() {
            addCriterion("NODE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNotNull() {
            addCriterion("NODE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeEqualTo(String value) {
            addCriterion("NODE_TYPE =", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotEqualTo(String value) {
            addCriterion("NODE_TYPE <>", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThan(String value) {
            addCriterion("NODE_TYPE >", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_TYPE >=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThan(String value) {
            addCriterion("NODE_TYPE <", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThanOrEqualTo(String value) {
            addCriterion("NODE_TYPE <=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLike(String value) {
            addCriterion("NODE_TYPE like", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotLike(String value) {
            addCriterion("NODE_TYPE not like", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIn(List<String> values) {
            addCriterion("NODE_TYPE in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotIn(List<String> values) {
            addCriterion("NODE_TYPE not in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeBetween(String value1, String value2) {
            addCriterion("NODE_TYPE between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotBetween(String value1, String value2) {
            addCriterion("NODE_TYPE not between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andCreditNoIsNull() {
            addCriterion("CREDIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCreditNoIsNotNull() {
            addCriterion("CREDIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCreditNoEqualTo(String value) {
            addCriterion("CREDIT_NO =", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotEqualTo(String value) {
            addCriterion("CREDIT_NO <>", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoGreaterThan(String value) {
            addCriterion("CREDIT_NO >", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_NO >=", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLessThan(String value) {
            addCriterion("CREDIT_NO <", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_NO <=", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLike(String value) {
            addCriterion("CREDIT_NO like", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotLike(String value) {
            addCriterion("CREDIT_NO not like", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoIn(List<String> values) {
            addCriterion("CREDIT_NO in", values, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotIn(List<String> values) {
            addCriterion("CREDIT_NO not in", values, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoBetween(String value1, String value2) {
            addCriterion("CREDIT_NO between", value1, value2, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotBetween(String value1, String value2) {
            addCriterion("CREDIT_NO not between", value1, value2, "creditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoIsNull() {
            addCriterion("UP_CREDIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoIsNotNull() {
            addCriterion("UP_CREDIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoEqualTo(String value) {
            addCriterion("UP_CREDIT_NO =", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoNotEqualTo(String value) {
            addCriterion("UP_CREDIT_NO <>", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoGreaterThan(String value) {
            addCriterion("UP_CREDIT_NO >", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoGreaterThanOrEqualTo(String value) {
            addCriterion("UP_CREDIT_NO >=", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoLessThan(String value) {
            addCriterion("UP_CREDIT_NO <", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoLessThanOrEqualTo(String value) {
            addCriterion("UP_CREDIT_NO <=", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoLike(String value) {
            addCriterion("UP_CREDIT_NO like", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoNotLike(String value) {
            addCriterion("UP_CREDIT_NO not like", value, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoIn(List<String> values) {
            addCriterion("UP_CREDIT_NO in", values, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoNotIn(List<String> values) {
            addCriterion("UP_CREDIT_NO not in", values, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoBetween(String value1, String value2) {
            addCriterion("UP_CREDIT_NO between", value1, value2, "upCreditNo");
            return (Criteria) this;
        }

        public Criteria andUpCreditNoNotBetween(String value1, String value2) {
            addCriterion("UP_CREDIT_NO not between", value1, value2, "upCreditNo");
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

        public Criteria andOtherCustcdIsNull() {
            addCriterion("OTHER_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdIsNotNull() {
            addCriterion("OTHER_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdEqualTo(String value) {
            addCriterion("OTHER_CUSTCD =", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotEqualTo(String value) {
            addCriterion("OTHER_CUSTCD <>", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdGreaterThan(String value) {
            addCriterion("OTHER_CUSTCD >", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_CUSTCD >=", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLessThan(String value) {
            addCriterion("OTHER_CUSTCD <", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLessThanOrEqualTo(String value) {
            addCriterion("OTHER_CUSTCD <=", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLike(String value) {
            addCriterion("OTHER_CUSTCD like", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotLike(String value) {
            addCriterion("OTHER_CUSTCD not like", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdIn(List<String> values) {
            addCriterion("OTHER_CUSTCD in", values, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotIn(List<String> values) {
            addCriterion("OTHER_CUSTCD not in", values, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdBetween(String value1, String value2) {
            addCriterion("OTHER_CUSTCD between", value1, value2, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotBetween(String value1, String value2) {
            addCriterion("OTHER_CUSTCD not between", value1, value2, "otherCustcd");
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

        public Criteria andControlTypeIsNull() {
            addCriterion("CONTROL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andControlTypeIsNotNull() {
            addCriterion("CONTROL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andControlTypeEqualTo(String value) {
            addCriterion("CONTROL_TYPE =", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotEqualTo(String value) {
            addCriterion("CONTROL_TYPE <>", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThan(String value) {
            addCriterion("CONTROL_TYPE >", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTROL_TYPE >=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThan(String value) {
            addCriterion("CONTROL_TYPE <", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThanOrEqualTo(String value) {
            addCriterion("CONTROL_TYPE <=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLike(String value) {
            addCriterion("CONTROL_TYPE like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotLike(String value) {
            addCriterion("CONTROL_TYPE not like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeIn(List<String> values) {
            addCriterion("CONTROL_TYPE in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotIn(List<String> values) {
            addCriterion("CONTROL_TYPE not in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeBetween(String value1, String value2) {
            addCriterion("CONTROL_TYPE between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotBetween(String value1, String value2) {
            addCriterion("CONTROL_TYPE not between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andCreditAmountIsNull() {
            addCriterion("CREDIT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreditAmountIsNotNull() {
            addCriterion("CREDIT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditAmountEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT =", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT <>", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT >", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT >=", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountLessThan(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT <", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT <=", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountIn(List<BigDecimal> values) {
            addCriterion("CREDIT_AMOUNT in", values, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_AMOUNT not in", values, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_AMOUNT between", value1, value2, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_AMOUNT not between", value1, value2, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountIsNull() {
            addCriterion("CREDIT_USABLE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountIsNotNull() {
            addCriterion("CREDIT_USABLE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT =", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT <>", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT >", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT >=", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountLessThan(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT <", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT <=", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountIn(List<BigDecimal> values) {
            addCriterion("CREDIT_USABLE_AMOUNT in", values, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_USABLE_AMOUNT not in", values, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_USABLE_AMOUNT between", value1, value2, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_USABLE_AMOUNT not between", value1, value2, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountIsNull() {
            addCriterion("PRE_USED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountIsNotNull() {
            addCriterion("PRE_USED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT =", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountNotEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT <>", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountGreaterThan(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT >", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT >=", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountLessThan(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT <", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT <=", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountIn(List<BigDecimal> values) {
            addCriterion("PRE_USED_AMOUNT in", values, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountNotIn(List<BigDecimal> values) {
            addCriterion("PRE_USED_AMOUNT not in", values, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRE_USED_AMOUNT between", value1, value2, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRE_USED_AMOUNT not between", value1, value2, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIsNull() {
            addCriterion("USED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIsNotNull() {
            addCriterion("USED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUsedAmountEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT =", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT <>", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountGreaterThan(BigDecimal value) {
            addCriterion("USED_AMOUNT >", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT >=", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountLessThan(BigDecimal value) {
            addCriterion("USED_AMOUNT <", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT <=", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIn(List<BigDecimal> values) {
            addCriterion("USED_AMOUNT in", values, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotIn(List<BigDecimal> values) {
            addCriterion("USED_AMOUNT not in", values, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_AMOUNT between", value1, value2, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_AMOUNT not between", value1, value2, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountIsNull() {
            addCriterion("FRZ_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFrzAmountIsNotNull() {
            addCriterion("FRZ_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFrzAmountEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT =", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountNotEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT <>", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountGreaterThan(BigDecimal value) {
            addCriterion("FRZ_AMOUNT >", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT >=", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountLessThan(BigDecimal value) {
            addCriterion("FRZ_AMOUNT <", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT <=", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountIn(List<BigDecimal> values) {
            addCriterion("FRZ_AMOUNT in", values, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountNotIn(List<BigDecimal> values) {
            addCriterion("FRZ_AMOUNT not in", values, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRZ_AMOUNT between", value1, value2, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRZ_AMOUNT not between", value1, value2, "frzAmount");
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

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("START_DATE like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("START_DATE not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("END_DATE like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("END_DATE not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIsNull() {
            addCriterion("APPROVAL_NO is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIsNotNull() {
            addCriterion("APPROVAL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoEqualTo(String value) {
            addCriterion("APPROVAL_NO =", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotEqualTo(String value) {
            addCriterion("APPROVAL_NO <>", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoGreaterThan(String value) {
            addCriterion("APPROVAL_NO >", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_NO >=", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLessThan(String value) {
            addCriterion("APPROVAL_NO <", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_NO <=", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLike(String value) {
            addCriterion("APPROVAL_NO like", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotLike(String value) {
            addCriterion("APPROVAL_NO not like", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIn(List<String> values) {
            addCriterion("APPROVAL_NO in", values, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotIn(List<String> values) {
            addCriterion("APPROVAL_NO not in", values, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoBetween(String value1, String value2) {
            addCriterion("APPROVAL_NO between", value1, value2, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_NO not between", value1, value2, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditIsNull() {
            addCriterion("IS_NEED_AUDIT is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditIsNotNull() {
            addCriterion("IS_NEED_AUDIT is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditEqualTo(String value) {
            addCriterion("IS_NEED_AUDIT =", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditNotEqualTo(String value) {
            addCriterion("IS_NEED_AUDIT <>", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditGreaterThan(String value) {
            addCriterion("IS_NEED_AUDIT >", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NEED_AUDIT >=", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditLessThan(String value) {
            addCriterion("IS_NEED_AUDIT <", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditLessThanOrEqualTo(String value) {
            addCriterion("IS_NEED_AUDIT <=", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditLike(String value) {
            addCriterion("IS_NEED_AUDIT like", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditNotLike(String value) {
            addCriterion("IS_NEED_AUDIT not like", value, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditIn(List<String> values) {
            addCriterion("IS_NEED_AUDIT in", values, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditNotIn(List<String> values) {
            addCriterion("IS_NEED_AUDIT not in", values, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditBetween(String value1, String value2) {
            addCriterion("IS_NEED_AUDIT between", value1, value2, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andIsNeedAuditNotBetween(String value1, String value2) {
            addCriterion("IS_NEED_AUDIT not between", value1, value2, "isNeedAudit");
            return (Criteria) this;
        }

        public Criteria andApproveTypeIsNull() {
            addCriterion("APPROVE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApproveTypeIsNotNull() {
            addCriterion("APPROVE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTypeEqualTo(String value) {
            addCriterion("APPROVE_TYPE =", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeNotEqualTo(String value) {
            addCriterion("APPROVE_TYPE <>", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeGreaterThan(String value) {
            addCriterion("APPROVE_TYPE >", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_TYPE >=", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeLessThan(String value) {
            addCriterion("APPROVE_TYPE <", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_TYPE <=", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeLike(String value) {
            addCriterion("APPROVE_TYPE like", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeNotLike(String value) {
            addCriterion("APPROVE_TYPE not like", value, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeIn(List<String> values) {
            addCriterion("APPROVE_TYPE in", values, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeNotIn(List<String> values) {
            addCriterion("APPROVE_TYPE not in", values, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeBetween(String value1, String value2) {
            addCriterion("APPROVE_TYPE between", value1, value2, "approveType");
            return (Criteria) this;
        }

        public Criteria andApproveTypeNotBetween(String value1, String value2) {
            addCriterion("APPROVE_TYPE not between", value1, value2, "approveType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME not between", value1, value2, "crtTime");
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

        public Criteria andLastUpdTlrcdIsNull() {
            addCriterion("LAST_UPD_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIsNotNull() {
            addCriterion("LAST_UPD_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD =", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <>", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThan(String value) {
            addCriterion("LAST_UPD_TLRCD >", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD >=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThan(String value) {
            addCriterion("LAST_UPD_TLRCD <", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLike(String value) {
            addCriterion("LAST_UPD_TLRCD like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotLike(String value) {
            addCriterion("LAST_UPD_TLRCD not like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD not in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD not between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNull() {
            addCriterion("LAST_UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNotNull() {
            addCriterion("LAST_UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME =", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <>", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThan(Date value) {
            addCriterion("LAST_UPD_TIME >", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME >=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThan(Date value) {
            addCriterion("LAST_UPD_TIME <", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME not in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME not between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNull() {
            addCriterion("LAST_UPD_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNotNull() {
            addCriterion("LAST_UPD_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE =", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <>", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThan(String value) {
            addCriterion("LAST_UPD_BRCODE >", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE >=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThan(String value) {
            addCriterion("LAST_UPD_BRCODE <", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLike(String value) {
            addCriterion("LAST_UPD_BRCODE like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotLike(String value) {
            addCriterion("LAST_UPD_BRCODE not like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE not in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE between", value1, value2, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE not between", value1, value2, "lastUpdBrcode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}