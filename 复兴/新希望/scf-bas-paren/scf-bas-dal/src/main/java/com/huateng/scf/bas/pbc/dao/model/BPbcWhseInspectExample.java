package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcWhseInspectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcWhseInspectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcWhseInspectExample(BPbcWhseInspectExample example) {
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

        public Criteria andCustCdIsNull() {
            addCriterion("CUST_CD is null");
            return (Criteria) this;
        }

        public Criteria andCustCdIsNotNull() {
            addCriterion("CUST_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCustCdEqualTo(String value) {
            addCriterion("CUST_CD =", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdNotEqualTo(String value) {
            addCriterion("CUST_CD <>", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdGreaterThan(String value) {
            addCriterion("CUST_CD >", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_CD >=", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdLessThan(String value) {
            addCriterion("CUST_CD <", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdLessThanOrEqualTo(String value) {
            addCriterion("CUST_CD <=", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdLike(String value) {
            addCriterion("CUST_CD like", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdNotLike(String value) {
            addCriterion("CUST_CD not like", value, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdIn(List<String> values) {
            addCriterion("CUST_CD in", values, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdNotIn(List<String> values) {
            addCriterion("CUST_CD not in", values, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdBetween(String value1, String value2) {
            addCriterion("CUST_CD between", value1, value2, "custCd");
            return (Criteria) this;
        }

        public Criteria andCustCdNotBetween(String value1, String value2) {
            addCriterion("CUST_CD not between", value1, value2, "custCd");
            return (Criteria) this;
        }

        public Criteria andInspectElement1IsNull() {
            addCriterion("INSPECT_ELEMENT1 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement1IsNotNull() {
            addCriterion("INSPECT_ELEMENT1 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement1EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT1 =", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT1 <>", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT1 >", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT1 >=", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1LessThan(String value) {
            addCriterion("INSPECT_ELEMENT1 <", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT1 <=", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1Like(String value) {
            addCriterion("INSPECT_ELEMENT1 like", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1NotLike(String value) {
            addCriterion("INSPECT_ELEMENT1 not like", value, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1In(List<String> values) {
            addCriterion("INSPECT_ELEMENT1 in", values, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT1 not in", values, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT1 between", value1, value2, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement1NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT1 not between", value1, value2, "inspectElement1");
            return (Criteria) this;
        }

        public Criteria andInspectElement2IsNull() {
            addCriterion("INSPECT_ELEMENT2 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement2IsNotNull() {
            addCriterion("INSPECT_ELEMENT2 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement2EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT2 =", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT2 <>", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT2 >", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT2 >=", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2LessThan(String value) {
            addCriterion("INSPECT_ELEMENT2 <", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT2 <=", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2Like(String value) {
            addCriterion("INSPECT_ELEMENT2 like", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2NotLike(String value) {
            addCriterion("INSPECT_ELEMENT2 not like", value, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2In(List<String> values) {
            addCriterion("INSPECT_ELEMENT2 in", values, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT2 not in", values, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT2 between", value1, value2, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement2NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT2 not between", value1, value2, "inspectElement2");
            return (Criteria) this;
        }

        public Criteria andInspectElement3IsNull() {
            addCriterion("INSPECT_ELEMENT3 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement3IsNotNull() {
            addCriterion("INSPECT_ELEMENT3 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement3EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT3 =", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT3 <>", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT3 >", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT3 >=", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3LessThan(String value) {
            addCriterion("INSPECT_ELEMENT3 <", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT3 <=", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3Like(String value) {
            addCriterion("INSPECT_ELEMENT3 like", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3NotLike(String value) {
            addCriterion("INSPECT_ELEMENT3 not like", value, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3In(List<String> values) {
            addCriterion("INSPECT_ELEMENT3 in", values, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT3 not in", values, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT3 between", value1, value2, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement3NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT3 not between", value1, value2, "inspectElement3");
            return (Criteria) this;
        }

        public Criteria andInspectElement4IsNull() {
            addCriterion("INSPECT_ELEMENT4 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement4IsNotNull() {
            addCriterion("INSPECT_ELEMENT4 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement4EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT4 =", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT4 <>", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT4 >", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT4 >=", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4LessThan(String value) {
            addCriterion("INSPECT_ELEMENT4 <", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT4 <=", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4Like(String value) {
            addCriterion("INSPECT_ELEMENT4 like", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4NotLike(String value) {
            addCriterion("INSPECT_ELEMENT4 not like", value, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4In(List<String> values) {
            addCriterion("INSPECT_ELEMENT4 in", values, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT4 not in", values, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT4 between", value1, value2, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement4NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT4 not between", value1, value2, "inspectElement4");
            return (Criteria) this;
        }

        public Criteria andInspectElement5IsNull() {
            addCriterion("INSPECT_ELEMENT5 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement5IsNotNull() {
            addCriterion("INSPECT_ELEMENT5 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement5EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT5 =", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT5 <>", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT5 >", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT5 >=", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5LessThan(String value) {
            addCriterion("INSPECT_ELEMENT5 <", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT5 <=", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5Like(String value) {
            addCriterion("INSPECT_ELEMENT5 like", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5NotLike(String value) {
            addCriterion("INSPECT_ELEMENT5 not like", value, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5In(List<String> values) {
            addCriterion("INSPECT_ELEMENT5 in", values, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT5 not in", values, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT5 between", value1, value2, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement5NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT5 not between", value1, value2, "inspectElement5");
            return (Criteria) this;
        }

        public Criteria andInspectElement6IsNull() {
            addCriterion("INSPECT_ELEMENT6 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement6IsNotNull() {
            addCriterion("INSPECT_ELEMENT6 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement6EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT6 =", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT6 <>", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT6 >", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT6 >=", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6LessThan(String value) {
            addCriterion("INSPECT_ELEMENT6 <", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT6 <=", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6Like(String value) {
            addCriterion("INSPECT_ELEMENT6 like", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6NotLike(String value) {
            addCriterion("INSPECT_ELEMENT6 not like", value, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6In(List<String> values) {
            addCriterion("INSPECT_ELEMENT6 in", values, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT6 not in", values, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT6 between", value1, value2, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement6NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT6 not between", value1, value2, "inspectElement6");
            return (Criteria) this;
        }

        public Criteria andInspectElement7IsNull() {
            addCriterion("INSPECT_ELEMENT7 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement7IsNotNull() {
            addCriterion("INSPECT_ELEMENT7 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement7EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT7 =", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT7 <>", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT7 >", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT7 >=", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7LessThan(String value) {
            addCriterion("INSPECT_ELEMENT7 <", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT7 <=", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7Like(String value) {
            addCriterion("INSPECT_ELEMENT7 like", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7NotLike(String value) {
            addCriterion("INSPECT_ELEMENT7 not like", value, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7In(List<String> values) {
            addCriterion("INSPECT_ELEMENT7 in", values, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT7 not in", values, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT7 between", value1, value2, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement7NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT7 not between", value1, value2, "inspectElement7");
            return (Criteria) this;
        }

        public Criteria andInspectElement8IsNull() {
            addCriterion("INSPECT_ELEMENT8 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement8IsNotNull() {
            addCriterion("INSPECT_ELEMENT8 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement8EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT8 =", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT8 <>", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT8 >", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT8 >=", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8LessThan(String value) {
            addCriterion("INSPECT_ELEMENT8 <", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT8 <=", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8Like(String value) {
            addCriterion("INSPECT_ELEMENT8 like", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8NotLike(String value) {
            addCriterion("INSPECT_ELEMENT8 not like", value, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8In(List<String> values) {
            addCriterion("INSPECT_ELEMENT8 in", values, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT8 not in", values, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT8 between", value1, value2, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement8NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT8 not between", value1, value2, "inspectElement8");
            return (Criteria) this;
        }

        public Criteria andInspectElement9IsNull() {
            addCriterion("INSPECT_ELEMENT9 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement9IsNotNull() {
            addCriterion("INSPECT_ELEMENT9 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement9EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT9 =", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT9 <>", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT9 >", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT9 >=", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9LessThan(String value) {
            addCriterion("INSPECT_ELEMENT9 <", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT9 <=", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9Like(String value) {
            addCriterion("INSPECT_ELEMENT9 like", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9NotLike(String value) {
            addCriterion("INSPECT_ELEMENT9 not like", value, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9In(List<String> values) {
            addCriterion("INSPECT_ELEMENT9 in", values, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT9 not in", values, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT9 between", value1, value2, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement9NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT9 not between", value1, value2, "inspectElement9");
            return (Criteria) this;
        }

        public Criteria andInspectElement10IsNull() {
            addCriterion("INSPECT_ELEMENT10 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement10IsNotNull() {
            addCriterion("INSPECT_ELEMENT10 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement10EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT10 =", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT10 <>", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT10 >", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT10 >=", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10LessThan(String value) {
            addCriterion("INSPECT_ELEMENT10 <", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT10 <=", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10Like(String value) {
            addCriterion("INSPECT_ELEMENT10 like", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10NotLike(String value) {
            addCriterion("INSPECT_ELEMENT10 not like", value, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10In(List<String> values) {
            addCriterion("INSPECT_ELEMENT10 in", values, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT10 not in", values, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT10 between", value1, value2, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement10NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT10 not between", value1, value2, "inspectElement10");
            return (Criteria) this;
        }

        public Criteria andInspectElement11IsNull() {
            addCriterion("INSPECT_ELEMENT11 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement11IsNotNull() {
            addCriterion("INSPECT_ELEMENT11 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement11EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT11 =", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT11 <>", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT11 >", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT11 >=", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11LessThan(String value) {
            addCriterion("INSPECT_ELEMENT11 <", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT11 <=", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11Like(String value) {
            addCriterion("INSPECT_ELEMENT11 like", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11NotLike(String value) {
            addCriterion("INSPECT_ELEMENT11 not like", value, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11In(List<String> values) {
            addCriterion("INSPECT_ELEMENT11 in", values, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT11 not in", values, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT11 between", value1, value2, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement11NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT11 not between", value1, value2, "inspectElement11");
            return (Criteria) this;
        }

        public Criteria andInspectElement12IsNull() {
            addCriterion("INSPECT_ELEMENT12 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement12IsNotNull() {
            addCriterion("INSPECT_ELEMENT12 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement12EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT12 =", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT12 <>", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT12 >", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT12 >=", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12LessThan(String value) {
            addCriterion("INSPECT_ELEMENT12 <", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT12 <=", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12Like(String value) {
            addCriterion("INSPECT_ELEMENT12 like", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12NotLike(String value) {
            addCriterion("INSPECT_ELEMENT12 not like", value, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12In(List<String> values) {
            addCriterion("INSPECT_ELEMENT12 in", values, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT12 not in", values, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT12 between", value1, value2, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement12NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT12 not between", value1, value2, "inspectElement12");
            return (Criteria) this;
        }

        public Criteria andInspectElement13IsNull() {
            addCriterion("INSPECT_ELEMENT13 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement13IsNotNull() {
            addCriterion("INSPECT_ELEMENT13 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement13EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT13 =", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT13 <>", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT13 >", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT13 >=", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13LessThan(String value) {
            addCriterion("INSPECT_ELEMENT13 <", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT13 <=", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13Like(String value) {
            addCriterion("INSPECT_ELEMENT13 like", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13NotLike(String value) {
            addCriterion("INSPECT_ELEMENT13 not like", value, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13In(List<String> values) {
            addCriterion("INSPECT_ELEMENT13 in", values, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT13 not in", values, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT13 between", value1, value2, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement13NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT13 not between", value1, value2, "inspectElement13");
            return (Criteria) this;
        }

        public Criteria andInspectElement14IsNull() {
            addCriterion("INSPECT_ELEMENT14 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement14IsNotNull() {
            addCriterion("INSPECT_ELEMENT14 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement14EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT14 =", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT14 <>", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT14 >", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT14 >=", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14LessThan(String value) {
            addCriterion("INSPECT_ELEMENT14 <", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT14 <=", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14Like(String value) {
            addCriterion("INSPECT_ELEMENT14 like", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14NotLike(String value) {
            addCriterion("INSPECT_ELEMENT14 not like", value, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14In(List<String> values) {
            addCriterion("INSPECT_ELEMENT14 in", values, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT14 not in", values, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT14 between", value1, value2, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement14NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT14 not between", value1, value2, "inspectElement14");
            return (Criteria) this;
        }

        public Criteria andInspectElement15IsNull() {
            addCriterion("INSPECT_ELEMENT15 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement15IsNotNull() {
            addCriterion("INSPECT_ELEMENT15 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement15EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT15 =", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT15 <>", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT15 >", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT15 >=", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15LessThan(String value) {
            addCriterion("INSPECT_ELEMENT15 <", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT15 <=", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15Like(String value) {
            addCriterion("INSPECT_ELEMENT15 like", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15NotLike(String value) {
            addCriterion("INSPECT_ELEMENT15 not like", value, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15In(List<String> values) {
            addCriterion("INSPECT_ELEMENT15 in", values, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT15 not in", values, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT15 between", value1, value2, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement15NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT15 not between", value1, value2, "inspectElement15");
            return (Criteria) this;
        }

        public Criteria andInspectElement16IsNull() {
            addCriterion("INSPECT_ELEMENT16 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement16IsNotNull() {
            addCriterion("INSPECT_ELEMENT16 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement16EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT16 =", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT16 <>", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT16 >", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT16 >=", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16LessThan(String value) {
            addCriterion("INSPECT_ELEMENT16 <", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT16 <=", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16Like(String value) {
            addCriterion("INSPECT_ELEMENT16 like", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16NotLike(String value) {
            addCriterion("INSPECT_ELEMENT16 not like", value, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16In(List<String> values) {
            addCriterion("INSPECT_ELEMENT16 in", values, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT16 not in", values, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT16 between", value1, value2, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement16NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT16 not between", value1, value2, "inspectElement16");
            return (Criteria) this;
        }

        public Criteria andInspectElement17IsNull() {
            addCriterion("INSPECT_ELEMENT17 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement17IsNotNull() {
            addCriterion("INSPECT_ELEMENT17 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement17EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT17 =", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT17 <>", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT17 >", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT17 >=", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17LessThan(String value) {
            addCriterion("INSPECT_ELEMENT17 <", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT17 <=", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17Like(String value) {
            addCriterion("INSPECT_ELEMENT17 like", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17NotLike(String value) {
            addCriterion("INSPECT_ELEMENT17 not like", value, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17In(List<String> values) {
            addCriterion("INSPECT_ELEMENT17 in", values, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT17 not in", values, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT17 between", value1, value2, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement17NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT17 not between", value1, value2, "inspectElement17");
            return (Criteria) this;
        }

        public Criteria andInspectElement18IsNull() {
            addCriterion("INSPECT_ELEMENT18 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement18IsNotNull() {
            addCriterion("INSPECT_ELEMENT18 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement18EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT18 =", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT18 <>", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT18 >", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT18 >=", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18LessThan(String value) {
            addCriterion("INSPECT_ELEMENT18 <", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT18 <=", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18Like(String value) {
            addCriterion("INSPECT_ELEMENT18 like", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18NotLike(String value) {
            addCriterion("INSPECT_ELEMENT18 not like", value, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18In(List<String> values) {
            addCriterion("INSPECT_ELEMENT18 in", values, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT18 not in", values, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT18 between", value1, value2, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement18NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT18 not between", value1, value2, "inspectElement18");
            return (Criteria) this;
        }

        public Criteria andInspectElement19IsNull() {
            addCriterion("INSPECT_ELEMENT19 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement19IsNotNull() {
            addCriterion("INSPECT_ELEMENT19 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement19EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT19 =", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT19 <>", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT19 >", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT19 >=", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19LessThan(String value) {
            addCriterion("INSPECT_ELEMENT19 <", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT19 <=", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19Like(String value) {
            addCriterion("INSPECT_ELEMENT19 like", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19NotLike(String value) {
            addCriterion("INSPECT_ELEMENT19 not like", value, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19In(List<String> values) {
            addCriterion("INSPECT_ELEMENT19 in", values, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT19 not in", values, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT19 between", value1, value2, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement19NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT19 not between", value1, value2, "inspectElement19");
            return (Criteria) this;
        }

        public Criteria andInspectElement20IsNull() {
            addCriterion("INSPECT_ELEMENT20 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement20IsNotNull() {
            addCriterion("INSPECT_ELEMENT20 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement20EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT20 =", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT20 <>", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT20 >", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT20 >=", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20LessThan(String value) {
            addCriterion("INSPECT_ELEMENT20 <", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT20 <=", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20Like(String value) {
            addCriterion("INSPECT_ELEMENT20 like", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20NotLike(String value) {
            addCriterion("INSPECT_ELEMENT20 not like", value, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20In(List<String> values) {
            addCriterion("INSPECT_ELEMENT20 in", values, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT20 not in", values, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT20 between", value1, value2, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement20NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT20 not between", value1, value2, "inspectElement20");
            return (Criteria) this;
        }

        public Criteria andInspectElement21IsNull() {
            addCriterion("INSPECT_ELEMENT21 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement21IsNotNull() {
            addCriterion("INSPECT_ELEMENT21 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement21EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT21 =", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT21 <>", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT21 >", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT21 >=", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21LessThan(String value) {
            addCriterion("INSPECT_ELEMENT21 <", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT21 <=", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21Like(String value) {
            addCriterion("INSPECT_ELEMENT21 like", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21NotLike(String value) {
            addCriterion("INSPECT_ELEMENT21 not like", value, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21In(List<String> values) {
            addCriterion("INSPECT_ELEMENT21 in", values, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT21 not in", values, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT21 between", value1, value2, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement21NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT21 not between", value1, value2, "inspectElement21");
            return (Criteria) this;
        }

        public Criteria andInspectElement31IsNull() {
            addCriterion("INSPECT_ELEMENT31 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement31IsNotNull() {
            addCriterion("INSPECT_ELEMENT31 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement31EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT31 =", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT31 <>", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT31 >", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT31 >=", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31LessThan(String value) {
            addCriterion("INSPECT_ELEMENT31 <", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT31 <=", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31Like(String value) {
            addCriterion("INSPECT_ELEMENT31 like", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31NotLike(String value) {
            addCriterion("INSPECT_ELEMENT31 not like", value, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31In(List<String> values) {
            addCriterion("INSPECT_ELEMENT31 in", values, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT31 not in", values, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT31 between", value1, value2, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement31NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT31 not between", value1, value2, "inspectElement31");
            return (Criteria) this;
        }

        public Criteria andInspectElement30IsNull() {
            addCriterion("INSPECT_ELEMENT30 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement30IsNotNull() {
            addCriterion("INSPECT_ELEMENT30 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement30EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT30 =", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT30 <>", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT30 >", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT30 >=", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30LessThan(String value) {
            addCriterion("INSPECT_ELEMENT30 <", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT30 <=", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30Like(String value) {
            addCriterion("INSPECT_ELEMENT30 like", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30NotLike(String value) {
            addCriterion("INSPECT_ELEMENT30 not like", value, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30In(List<String> values) {
            addCriterion("INSPECT_ELEMENT30 in", values, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT30 not in", values, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT30 between", value1, value2, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement30NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT30 not between", value1, value2, "inspectElement30");
            return (Criteria) this;
        }

        public Criteria andInspectElement29IsNull() {
            addCriterion("INSPECT_ELEMENT29 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement29IsNotNull() {
            addCriterion("INSPECT_ELEMENT29 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement29EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT29 =", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT29 <>", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT29 >", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT29 >=", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29LessThan(String value) {
            addCriterion("INSPECT_ELEMENT29 <", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT29 <=", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29Like(String value) {
            addCriterion("INSPECT_ELEMENT29 like", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29NotLike(String value) {
            addCriterion("INSPECT_ELEMENT29 not like", value, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29In(List<String> values) {
            addCriterion("INSPECT_ELEMENT29 in", values, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT29 not in", values, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT29 between", value1, value2, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement29NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT29 not between", value1, value2, "inspectElement29");
            return (Criteria) this;
        }

        public Criteria andInspectElement28IsNull() {
            addCriterion("INSPECT_ELEMENT28 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement28IsNotNull() {
            addCriterion("INSPECT_ELEMENT28 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement28EqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT28 =", value, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28NotEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT28 <>", value, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28GreaterThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT28 >", value, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT28 >=", value, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28LessThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT28 <", value, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28LessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT28 <=", value, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28In(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT28 in", values, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28NotIn(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT28 not in", values, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT28 between", value1, value2, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement28NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT28 not between", value1, value2, "inspectElement28");
            return (Criteria) this;
        }

        public Criteria andInspectElement27IsNull() {
            addCriterion("INSPECT_ELEMENT27 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement27IsNotNull() {
            addCriterion("INSPECT_ELEMENT27 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement27EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT27 =", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT27 <>", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT27 >", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT27 >=", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27LessThan(String value) {
            addCriterion("INSPECT_ELEMENT27 <", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT27 <=", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27Like(String value) {
            addCriterion("INSPECT_ELEMENT27 like", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27NotLike(String value) {
            addCriterion("INSPECT_ELEMENT27 not like", value, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27In(List<String> values) {
            addCriterion("INSPECT_ELEMENT27 in", values, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT27 not in", values, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT27 between", value1, value2, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement27NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT27 not between", value1, value2, "inspectElement27");
            return (Criteria) this;
        }

        public Criteria andInspectElement26IsNull() {
            addCriterion("INSPECT_ELEMENT26 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement26IsNotNull() {
            addCriterion("INSPECT_ELEMENT26 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement26EqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT26 =", value, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26NotEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT26 <>", value, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26GreaterThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT26 >", value, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT26 >=", value, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26LessThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT26 <", value, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26LessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT26 <=", value, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26In(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT26 in", values, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26NotIn(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT26 not in", values, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT26 between", value1, value2, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement26NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT26 not between", value1, value2, "inspectElement26");
            return (Criteria) this;
        }

        public Criteria andInspectElement25IsNull() {
            addCriterion("INSPECT_ELEMENT25 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement25IsNotNull() {
            addCriterion("INSPECT_ELEMENT25 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement25EqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT25 =", value, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25NotEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT25 <>", value, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25GreaterThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT25 >", value, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT25 >=", value, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25LessThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT25 <", value, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25LessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT25 <=", value, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25In(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT25 in", values, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25NotIn(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT25 not in", values, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT25 between", value1, value2, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement25NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT25 not between", value1, value2, "inspectElement25");
            return (Criteria) this;
        }

        public Criteria andInspectElement24IsNull() {
            addCriterion("INSPECT_ELEMENT24 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement24IsNotNull() {
            addCriterion("INSPECT_ELEMENT24 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement24EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT24 =", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT24 <>", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT24 >", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT24 >=", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24LessThan(String value) {
            addCriterion("INSPECT_ELEMENT24 <", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT24 <=", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24Like(String value) {
            addCriterion("INSPECT_ELEMENT24 like", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24NotLike(String value) {
            addCriterion("INSPECT_ELEMENT24 not like", value, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24In(List<String> values) {
            addCriterion("INSPECT_ELEMENT24 in", values, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT24 not in", values, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT24 between", value1, value2, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement24NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT24 not between", value1, value2, "inspectElement24");
            return (Criteria) this;
        }

        public Criteria andInspectElement23IsNull() {
            addCriterion("INSPECT_ELEMENT23 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement23IsNotNull() {
            addCriterion("INSPECT_ELEMENT23 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement23EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT23 =", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT23 <>", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT23 >", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT23 >=", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23LessThan(String value) {
            addCriterion("INSPECT_ELEMENT23 <", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT23 <=", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23Like(String value) {
            addCriterion("INSPECT_ELEMENT23 like", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23NotLike(String value) {
            addCriterion("INSPECT_ELEMENT23 not like", value, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23In(List<String> values) {
            addCriterion("INSPECT_ELEMENT23 in", values, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT23 not in", values, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT23 between", value1, value2, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement23NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT23 not between", value1, value2, "inspectElement23");
            return (Criteria) this;
        }

        public Criteria andInspectElement22IsNull() {
            addCriterion("INSPECT_ELEMENT22 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement22IsNotNull() {
            addCriterion("INSPECT_ELEMENT22 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement22EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT22 =", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT22 <>", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT22 >", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT22 >=", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22LessThan(String value) {
            addCriterion("INSPECT_ELEMENT22 <", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT22 <=", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22Like(String value) {
            addCriterion("INSPECT_ELEMENT22 like", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22NotLike(String value) {
            addCriterion("INSPECT_ELEMENT22 not like", value, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22In(List<String> values) {
            addCriterion("INSPECT_ELEMENT22 in", values, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT22 not in", values, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT22 between", value1, value2, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andInspectElement22NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT22 not between", value1, value2, "inspectElement22");
            return (Criteria) this;
        }

        public Criteria andResultsIsNull() {
            addCriterion("RESULTS is null");
            return (Criteria) this;
        }

        public Criteria andResultsIsNotNull() {
            addCriterion("RESULTS is not null");
            return (Criteria) this;
        }

        public Criteria andResultsEqualTo(String value) {
            addCriterion("RESULTS =", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsNotEqualTo(String value) {
            addCriterion("RESULTS <>", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsGreaterThan(String value) {
            addCriterion("RESULTS >", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsGreaterThanOrEqualTo(String value) {
            addCriterion("RESULTS >=", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsLessThan(String value) {
            addCriterion("RESULTS <", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsLessThanOrEqualTo(String value) {
            addCriterion("RESULTS <=", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsLike(String value) {
            addCriterion("RESULTS like", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsNotLike(String value) {
            addCriterion("RESULTS not like", value, "results");
            return (Criteria) this;
        }

        public Criteria andResultsIn(List<String> values) {
            addCriterion("RESULTS in", values, "results");
            return (Criteria) this;
        }

        public Criteria andResultsNotIn(List<String> values) {
            addCriterion("RESULTS not in", values, "results");
            return (Criteria) this;
        }

        public Criteria andResultsBetween(String value1, String value2) {
            addCriterion("RESULTS between", value1, value2, "results");
            return (Criteria) this;
        }

        public Criteria andResultsNotBetween(String value1, String value2) {
            addCriterion("RESULTS not between", value1, value2, "results");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNull() {
            addCriterion("APP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNotNull() {
            addCriterion("APP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAppDateEqualTo(String value) {
            addCriterion("APP_DATE =", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotEqualTo(String value) {
            addCriterion("APP_DATE <>", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThan(String value) {
            addCriterion("APP_DATE >", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThanOrEqualTo(String value) {
            addCriterion("APP_DATE >=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThan(String value) {
            addCriterion("APP_DATE <", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThanOrEqualTo(String value) {
            addCriterion("APP_DATE <=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLike(String value) {
            addCriterion("APP_DATE like", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotLike(String value) {
            addCriterion("APP_DATE not like", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateIn(List<String> values) {
            addCriterion("APP_DATE in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotIn(List<String> values) {
            addCriterion("APP_DATE not in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateBetween(String value1, String value2) {
            addCriterion("APP_DATE between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotBetween(String value1, String value2) {
            addCriterion("APP_DATE not between", value1, value2, "appDate");
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

        public Criteria andMoniCustcdIsNull() {
            addCriterion("MONI_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdIsNotNull() {
            addCriterion("MONI_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdEqualTo(String value) {
            addCriterion("MONI_CUSTCD =", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotEqualTo(String value) {
            addCriterion("MONI_CUSTCD <>", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdGreaterThan(String value) {
            addCriterion("MONI_CUSTCD >", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_CUSTCD >=", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLessThan(String value) {
            addCriterion("MONI_CUSTCD <", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLessThanOrEqualTo(String value) {
            addCriterion("MONI_CUSTCD <=", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLike(String value) {
            addCriterion("MONI_CUSTCD like", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotLike(String value) {
            addCriterion("MONI_CUSTCD not like", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdIn(List<String> values) {
            addCriterion("MONI_CUSTCD in", values, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotIn(List<String> values) {
            addCriterion("MONI_CUSTCD not in", values, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdBetween(String value1, String value2) {
            addCriterion("MONI_CUSTCD between", value1, value2, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotBetween(String value1, String value2) {
            addCriterion("MONI_CUSTCD not between", value1, value2, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andIdeaIsNull() {
            addCriterion("IDEA is null");
            return (Criteria) this;
        }

        public Criteria andIdeaIsNotNull() {
            addCriterion("IDEA is not null");
            return (Criteria) this;
        }

        public Criteria andIdeaEqualTo(String value) {
            addCriterion("IDEA =", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotEqualTo(String value) {
            addCriterion("IDEA <>", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaGreaterThan(String value) {
            addCriterion("IDEA >", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaGreaterThanOrEqualTo(String value) {
            addCriterion("IDEA >=", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaLessThan(String value) {
            addCriterion("IDEA <", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaLessThanOrEqualTo(String value) {
            addCriterion("IDEA <=", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaLike(String value) {
            addCriterion("IDEA like", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotLike(String value) {
            addCriterion("IDEA not like", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaIn(List<String> values) {
            addCriterion("IDEA in", values, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotIn(List<String> values) {
            addCriterion("IDEA not in", values, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaBetween(String value1, String value2) {
            addCriterion("IDEA between", value1, value2, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotBetween(String value1, String value2) {
            addCriterion("IDEA not between", value1, value2, "idea");
            return (Criteria) this;
        }

        public Criteria andReinspectIsNull() {
            addCriterion("REINSPECT is null");
            return (Criteria) this;
        }

        public Criteria andReinspectIsNotNull() {
            addCriterion("REINSPECT is not null");
            return (Criteria) this;
        }

        public Criteria andReinspectEqualTo(String value) {
            addCriterion("REINSPECT =", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectNotEqualTo(String value) {
            addCriterion("REINSPECT <>", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectGreaterThan(String value) {
            addCriterion("REINSPECT >", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectGreaterThanOrEqualTo(String value) {
            addCriterion("REINSPECT >=", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectLessThan(String value) {
            addCriterion("REINSPECT <", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectLessThanOrEqualTo(String value) {
            addCriterion("REINSPECT <=", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectLike(String value) {
            addCriterion("REINSPECT like", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectNotLike(String value) {
            addCriterion("REINSPECT not like", value, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectIn(List<String> values) {
            addCriterion("REINSPECT in", values, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectNotIn(List<String> values) {
            addCriterion("REINSPECT not in", values, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectBetween(String value1, String value2) {
            addCriterion("REINSPECT between", value1, value2, "reinspect");
            return (Criteria) this;
        }

        public Criteria andReinspectNotBetween(String value1, String value2) {
            addCriterion("REINSPECT not between", value1, value2, "reinspect");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoIsNull() {
            addCriterion("INSPECT_REPORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoIsNotNull() {
            addCriterion("INSPECT_REPORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoEqualTo(String value) {
            addCriterion("INSPECT_REPORT_NO =", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoNotEqualTo(String value) {
            addCriterion("INSPECT_REPORT_NO <>", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoGreaterThan(String value) {
            addCriterion("INSPECT_REPORT_NO >", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoGreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_REPORT_NO >=", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoLessThan(String value) {
            addCriterion("INSPECT_REPORT_NO <", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoLessThanOrEqualTo(String value) {
            addCriterion("INSPECT_REPORT_NO <=", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoLike(String value) {
            addCriterion("INSPECT_REPORT_NO like", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoNotLike(String value) {
            addCriterion("INSPECT_REPORT_NO not like", value, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoIn(List<String> values) {
            addCriterion("INSPECT_REPORT_NO in", values, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoNotIn(List<String> values) {
            addCriterion("INSPECT_REPORT_NO not in", values, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoBetween(String value1, String value2) {
            addCriterion("INSPECT_REPORT_NO between", value1, value2, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectReportNoNotBetween(String value1, String value2) {
            addCriterion("INSPECT_REPORT_NO not between", value1, value2, "inspectReportNo");
            return (Criteria) this;
        }

        public Criteria andInspectElement32IsNull() {
            addCriterion("INSPECT_ELEMENT32 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement32IsNotNull() {
            addCriterion("INSPECT_ELEMENT32 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement32EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT32 =", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT32 <>", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT32 >", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT32 >=", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32LessThan(String value) {
            addCriterion("INSPECT_ELEMENT32 <", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT32 <=", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32Like(String value) {
            addCriterion("INSPECT_ELEMENT32 like", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32NotLike(String value) {
            addCriterion("INSPECT_ELEMENT32 not like", value, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32In(List<String> values) {
            addCriterion("INSPECT_ELEMENT32 in", values, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT32 not in", values, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT32 between", value1, value2, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement32NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT32 not between", value1, value2, "inspectElement32");
            return (Criteria) this;
        }

        public Criteria andInspectElement33IsNull() {
            addCriterion("INSPECT_ELEMENT33 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement33IsNotNull() {
            addCriterion("INSPECT_ELEMENT33 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement33EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT33 =", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT33 <>", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT33 >", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT33 >=", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33LessThan(String value) {
            addCriterion("INSPECT_ELEMENT33 <", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT33 <=", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33Like(String value) {
            addCriterion("INSPECT_ELEMENT33 like", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33NotLike(String value) {
            addCriterion("INSPECT_ELEMENT33 not like", value, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33In(List<String> values) {
            addCriterion("INSPECT_ELEMENT33 in", values, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT33 not in", values, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT33 between", value1, value2, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement33NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT33 not between", value1, value2, "inspectElement33");
            return (Criteria) this;
        }

        public Criteria andInspectElement34IsNull() {
            addCriterion("INSPECT_ELEMENT34 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement34IsNotNull() {
            addCriterion("INSPECT_ELEMENT34 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement34EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT34 =", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT34 <>", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT34 >", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT34 >=", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34LessThan(String value) {
            addCriterion("INSPECT_ELEMENT34 <", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT34 <=", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34Like(String value) {
            addCriterion("INSPECT_ELEMENT34 like", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34NotLike(String value) {
            addCriterion("INSPECT_ELEMENT34 not like", value, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34In(List<String> values) {
            addCriterion("INSPECT_ELEMENT34 in", values, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT34 not in", values, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT34 between", value1, value2, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement34NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT34 not between", value1, value2, "inspectElement34");
            return (Criteria) this;
        }

        public Criteria andInspectElement35IsNull() {
            addCriterion("INSPECT_ELEMENT35 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement35IsNotNull() {
            addCriterion("INSPECT_ELEMENT35 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement35EqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT35 =", value, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35NotEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT35 <>", value, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35GreaterThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT35 >", value, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT35 >=", value, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35LessThan(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT35 <", value, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35LessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPECT_ELEMENT35 <=", value, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35In(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT35 in", values, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35NotIn(List<BigDecimal> values) {
            addCriterion("INSPECT_ELEMENT35 not in", values, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT35 between", value1, value2, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement35NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPECT_ELEMENT35 not between", value1, value2, "inspectElement35");
            return (Criteria) this;
        }

        public Criteria andInspectElement36IsNull() {
            addCriterion("INSPECT_ELEMENT36 is null");
            return (Criteria) this;
        }

        public Criteria andInspectElement36IsNotNull() {
            addCriterion("INSPECT_ELEMENT36 is not null");
            return (Criteria) this;
        }

        public Criteria andInspectElement36EqualTo(String value) {
            addCriterion("INSPECT_ELEMENT36 =", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36NotEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT36 <>", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36GreaterThan(String value) {
            addCriterion("INSPECT_ELEMENT36 >", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36GreaterThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT36 >=", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36LessThan(String value) {
            addCriterion("INSPECT_ELEMENT36 <", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36LessThanOrEqualTo(String value) {
            addCriterion("INSPECT_ELEMENT36 <=", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36Like(String value) {
            addCriterion("INSPECT_ELEMENT36 like", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36NotLike(String value) {
            addCriterion("INSPECT_ELEMENT36 not like", value, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36In(List<String> values) {
            addCriterion("INSPECT_ELEMENT36 in", values, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36NotIn(List<String> values) {
            addCriterion("INSPECT_ELEMENT36 not in", values, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36Between(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT36 between", value1, value2, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andInspectElement36NotBetween(String value1, String value2) {
            addCriterion("INSPECT_ELEMENT36 not between", value1, value2, "inspectElement36");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIsNull() {
            addCriterion("PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIsNotNull() {
            addCriterion("PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoEqualTo(String value) {
            addCriterion("PROTOCOL_NO =", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotEqualTo(String value) {
            addCriterion("PROTOCOL_NO <>", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThan(String value) {
            addCriterion("PROTOCOL_NO >", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO >=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThan(String value) {
            addCriterion("PROTOCOL_NO <", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO <=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLike(String value) {
            addCriterion("PROTOCOL_NO like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotLike(String value) {
            addCriterion("PROTOCOL_NO not like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIn(List<String> values) {
            addCriterion("PROTOCOL_NO in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotIn(List<String> values) {
            addCriterion("PROTOCOL_NO not in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO between", value1, value2, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO not between", value1, value2, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNull() {
            addCriterion("WAREHOUSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNotNull() {
            addCriterion("WAREHOUSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME =", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME <>", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThan(String value) {
            addCriterion("WAREHOUSE_NAME >", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME >=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThan(String value) {
            addCriterion("WAREHOUSE_NAME <", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME <=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLike(String value) {
            addCriterion("WAREHOUSE_NAME like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotLike(String value) {
            addCriterion("WAREHOUSE_NAME not like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIn(List<String> values) {
            addCriterion("WAREHOUSE_NAME in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotIn(List<String> values) {
            addCriterion("WAREHOUSE_NAME not in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_NAME between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_NAME not between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNull() {
            addCriterion("LOAN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNotNull() {
            addCriterion("LOAN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT =", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT <>", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThan(BigDecimal value) {
            addCriterion("LOAN_AMT >", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT >=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThan(BigDecimal value) {
            addCriterion("LOAN_AMT <", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT <=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMT in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMT not in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMT between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMT not between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtIsNull() {
            addCriterion("LOAN_RISK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtIsNotNull() {
            addCriterion("LOAN_RISK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtEqualTo(BigDecimal value) {
            addCriterion("LOAN_RISK_AMT =", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_RISK_AMT <>", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("LOAN_RISK_AMT >", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_RISK_AMT >=", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtLessThan(BigDecimal value) {
            addCriterion("LOAN_RISK_AMT <", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_RISK_AMT <=", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtIn(List<BigDecimal> values) {
            addCriterion("LOAN_RISK_AMT in", values, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_RISK_AMT not in", values, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_RISK_AMT between", value1, value2, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_RISK_AMT not between", value1, value2, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("OPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("OPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("OPER_TYPE =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("OPER_TYPE <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("OPER_TYPE >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("OPER_TYPE <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("OPER_TYPE like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("OPER_TYPE not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("OPER_TYPE in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("OPER_TYPE not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("OPER_TYPE between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("OPER_TYPE not between", value1, value2, "operType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}