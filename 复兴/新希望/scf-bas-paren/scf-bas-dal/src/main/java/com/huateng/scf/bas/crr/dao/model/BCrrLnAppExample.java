package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrLnAppExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrLnAppExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrLnAppExample(BCrrLnAppExample example) {
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

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andPrdIdIsNull() {
            addCriterion("PRD_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrdIdIsNotNull() {
            addCriterion("PRD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrdIdEqualTo(String value) {
            addCriterion("PRD_ID =", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotEqualTo(String value) {
            addCriterion("PRD_ID <>", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdGreaterThan(String value) {
            addCriterion("PRD_ID >", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRD_ID >=", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdLessThan(String value) {
            addCriterion("PRD_ID <", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdLessThanOrEqualTo(String value) {
            addCriterion("PRD_ID <=", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdLike(String value) {
            addCriterion("PRD_ID like", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotLike(String value) {
            addCriterion("PRD_ID not like", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdIn(List<String> values) {
            addCriterion("PRD_ID in", values, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotIn(List<String> values) {
            addCriterion("PRD_ID not in", values, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdBetween(String value1, String value2) {
            addCriterion("PRD_ID between", value1, value2, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotBetween(String value1, String value2) {
            addCriterion("PRD_ID not between", value1, value2, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdNmIsNull() {
            addCriterion("PRD_NM is null");
            return (Criteria) this;
        }

        public Criteria andPrdNmIsNotNull() {
            addCriterion("PRD_NM is not null");
            return (Criteria) this;
        }

        public Criteria andPrdNmEqualTo(String value) {
            addCriterion("PRD_NM =", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmNotEqualTo(String value) {
            addCriterion("PRD_NM <>", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmGreaterThan(String value) {
            addCriterion("PRD_NM >", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmGreaterThanOrEqualTo(String value) {
            addCriterion("PRD_NM >=", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmLessThan(String value) {
            addCriterion("PRD_NM <", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmLessThanOrEqualTo(String value) {
            addCriterion("PRD_NM <=", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmLike(String value) {
            addCriterion("PRD_NM like", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmNotLike(String value) {
            addCriterion("PRD_NM not like", value, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmIn(List<String> values) {
            addCriterion("PRD_NM in", values, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmNotIn(List<String> values) {
            addCriterion("PRD_NM not in", values, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmBetween(String value1, String value2) {
            addCriterion("PRD_NM between", value1, value2, "prdNm");
            return (Criteria) this;
        }

        public Criteria andPrdNmNotBetween(String value1, String value2) {
            addCriterion("PRD_NM not between", value1, value2, "prdNm");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNmIsNull() {
            addCriterion("CUST_NM is null");
            return (Criteria) this;
        }

        public Criteria andCustNmIsNotNull() {
            addCriterion("CUST_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCustNmEqualTo(String value) {
            addCriterion("CUST_NM =", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotEqualTo(String value) {
            addCriterion("CUST_NM <>", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmGreaterThan(String value) {
            addCriterion("CUST_NM >", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NM >=", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmLessThan(String value) {
            addCriterion("CUST_NM <", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmLessThanOrEqualTo(String value) {
            addCriterion("CUST_NM <=", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmLike(String value) {
            addCriterion("CUST_NM like", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotLike(String value) {
            addCriterion("CUST_NM not like", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmIn(List<String> values) {
            addCriterion("CUST_NM in", values, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotIn(List<String> values) {
            addCriterion("CUST_NM not in", values, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmBetween(String value1, String value2) {
            addCriterion("CUST_NM between", value1, value2, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotBetween(String value1, String value2) {
            addCriterion("CUST_NM not between", value1, value2, "custNm");
            return (Criteria) this;
        }

        public Criteria andPrdClIsNull() {
            addCriterion("PRD_CL is null");
            return (Criteria) this;
        }

        public Criteria andPrdClIsNotNull() {
            addCriterion("PRD_CL is not null");
            return (Criteria) this;
        }

        public Criteria andPrdClEqualTo(String value) {
            addCriterion("PRD_CL =", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClNotEqualTo(String value) {
            addCriterion("PRD_CL <>", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClGreaterThan(String value) {
            addCriterion("PRD_CL >", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClGreaterThanOrEqualTo(String value) {
            addCriterion("PRD_CL >=", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClLessThan(String value) {
            addCriterion("PRD_CL <", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClLessThanOrEqualTo(String value) {
            addCriterion("PRD_CL <=", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClLike(String value) {
            addCriterion("PRD_CL like", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClNotLike(String value) {
            addCriterion("PRD_CL not like", value, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClIn(List<String> values) {
            addCriterion("PRD_CL in", values, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClNotIn(List<String> values) {
            addCriterion("PRD_CL not in", values, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClBetween(String value1, String value2) {
            addCriterion("PRD_CL between", value1, value2, "prdCl");
            return (Criteria) this;
        }

        public Criteria andPrdClNotBetween(String value1, String value2) {
            addCriterion("PRD_CL not between", value1, value2, "prdCl");
            return (Criteria) this;
        }

        public Criteria andExtIdIsNull() {
            addCriterion("EXT_ID is null");
            return (Criteria) this;
        }

        public Criteria andExtIdIsNotNull() {
            addCriterion("EXT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExtIdEqualTo(String value) {
            addCriterion("EXT_ID =", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotEqualTo(String value) {
            addCriterion("EXT_ID <>", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThan(String value) {
            addCriterion("EXT_ID >", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_ID >=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThan(String value) {
            addCriterion("EXT_ID <", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThanOrEqualTo(String value) {
            addCriterion("EXT_ID <=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLike(String value) {
            addCriterion("EXT_ID like", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotLike(String value) {
            addCriterion("EXT_ID not like", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdIn(List<String> values) {
            addCriterion("EXT_ID in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotIn(List<String> values) {
            addCriterion("EXT_ID not in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdBetween(String value1, String value2) {
            addCriterion("EXT_ID between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotBetween(String value1, String value2) {
            addCriterion("EXT_ID not between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andExtTypIsNull() {
            addCriterion("EXT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andExtTypIsNotNull() {
            addCriterion("EXT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andExtTypEqualTo(String value) {
            addCriterion("EXT_TYP =", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypNotEqualTo(String value) {
            addCriterion("EXT_TYP <>", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypGreaterThan(String value) {
            addCriterion("EXT_TYP >", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_TYP >=", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypLessThan(String value) {
            addCriterion("EXT_TYP <", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypLessThanOrEqualTo(String value) {
            addCriterion("EXT_TYP <=", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypLike(String value) {
            addCriterion("EXT_TYP like", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypNotLike(String value) {
            addCriterion("EXT_TYP not like", value, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypIn(List<String> values) {
            addCriterion("EXT_TYP in", values, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypNotIn(List<String> values) {
            addCriterion("EXT_TYP not in", values, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypBetween(String value1, String value2) {
            addCriterion("EXT_TYP between", value1, value2, "extTyp");
            return (Criteria) this;
        }

        public Criteria andExtTypNotBetween(String value1, String value2) {
            addCriterion("EXT_TYP not between", value1, value2, "extTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypIsNull() {
            addCriterion("LN_TYP is null");
            return (Criteria) this;
        }

        public Criteria andLnTypIsNotNull() {
            addCriterion("LN_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andLnTypEqualTo(String value) {
            addCriterion("LN_TYP =", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypNotEqualTo(String value) {
            addCriterion("LN_TYP <>", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypGreaterThan(String value) {
            addCriterion("LN_TYP >", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypGreaterThanOrEqualTo(String value) {
            addCriterion("LN_TYP >=", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypLessThan(String value) {
            addCriterion("LN_TYP <", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypLessThanOrEqualTo(String value) {
            addCriterion("LN_TYP <=", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypLike(String value) {
            addCriterion("LN_TYP like", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypNotLike(String value) {
            addCriterion("LN_TYP not like", value, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypIn(List<String> values) {
            addCriterion("LN_TYP in", values, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypNotIn(List<String> values) {
            addCriterion("LN_TYP not in", values, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypBetween(String value1, String value2) {
            addCriterion("LN_TYP between", value1, value2, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnTypNotBetween(String value1, String value2) {
            addCriterion("LN_TYP not between", value1, value2, "lnTyp");
            return (Criteria) this;
        }

        public Criteria andLnNatIsNull() {
            addCriterion("LN_NAT is null");
            return (Criteria) this;
        }

        public Criteria andLnNatIsNotNull() {
            addCriterion("LN_NAT is not null");
            return (Criteria) this;
        }

        public Criteria andLnNatEqualTo(String value) {
            addCriterion("LN_NAT =", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatNotEqualTo(String value) {
            addCriterion("LN_NAT <>", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatGreaterThan(String value) {
            addCriterion("LN_NAT >", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatGreaterThanOrEqualTo(String value) {
            addCriterion("LN_NAT >=", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatLessThan(String value) {
            addCriterion("LN_NAT <", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatLessThanOrEqualTo(String value) {
            addCriterion("LN_NAT <=", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatLike(String value) {
            addCriterion("LN_NAT like", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatNotLike(String value) {
            addCriterion("LN_NAT not like", value, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatIn(List<String> values) {
            addCriterion("LN_NAT in", values, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatNotIn(List<String> values) {
            addCriterion("LN_NAT not in", values, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatBetween(String value1, String value2) {
            addCriterion("LN_NAT between", value1, value2, "lnNat");
            return (Criteria) this;
        }

        public Criteria andLnNatNotBetween(String value1, String value2) {
            addCriterion("LN_NAT not between", value1, value2, "lnNat");
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

        public Criteria andExchgRtIsNull() {
            addCriterion("EXCHG_RT is null");
            return (Criteria) this;
        }

        public Criteria andExchgRtIsNotNull() {
            addCriterion("EXCHG_RT is not null");
            return (Criteria) this;
        }

        public Criteria andExchgRtEqualTo(BigDecimal value) {
            addCriterion("EXCHG_RT =", value, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtNotEqualTo(BigDecimal value) {
            addCriterion("EXCHG_RT <>", value, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtGreaterThan(BigDecimal value) {
            addCriterion("EXCHG_RT >", value, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXCHG_RT >=", value, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtLessThan(BigDecimal value) {
            addCriterion("EXCHG_RT <", value, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXCHG_RT <=", value, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtIn(List<BigDecimal> values) {
            addCriterion("EXCHG_RT in", values, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtNotIn(List<BigDecimal> values) {
            addCriterion("EXCHG_RT not in", values, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXCHG_RT between", value1, value2, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andExchgRtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXCHG_RT not between", value1, value2, "exchgRt");
            return (Criteria) this;
        }

        public Criteria andLnAmtIsNull() {
            addCriterion("LN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLnAmtIsNotNull() {
            addCriterion("LN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLnAmtEqualTo(BigDecimal value) {
            addCriterion("LN_AMT =", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtNotEqualTo(BigDecimal value) {
            addCriterion("LN_AMT <>", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtGreaterThan(BigDecimal value) {
            addCriterion("LN_AMT >", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LN_AMT >=", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtLessThan(BigDecimal value) {
            addCriterion("LN_AMT <", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LN_AMT <=", value, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtIn(List<BigDecimal> values) {
            addCriterion("LN_AMT in", values, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtNotIn(List<BigDecimal> values) {
            addCriterion("LN_AMT not in", values, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LN_AMT between", value1, value2, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LN_AMT not between", value1, value2, "lnAmt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtIsNull() {
            addCriterion("LN_STRT_DT is null");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtIsNotNull() {
            addCriterion("LN_STRT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtEqualTo(String value) {
            addCriterion("LN_STRT_DT =", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtNotEqualTo(String value) {
            addCriterion("LN_STRT_DT <>", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtGreaterThan(String value) {
            addCriterion("LN_STRT_DT >", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtGreaterThanOrEqualTo(String value) {
            addCriterion("LN_STRT_DT >=", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtLessThan(String value) {
            addCriterion("LN_STRT_DT <", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtLessThanOrEqualTo(String value) {
            addCriterion("LN_STRT_DT <=", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtLike(String value) {
            addCriterion("LN_STRT_DT like", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtNotLike(String value) {
            addCriterion("LN_STRT_DT not like", value, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtIn(List<String> values) {
            addCriterion("LN_STRT_DT in", values, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtNotIn(List<String> values) {
            addCriterion("LN_STRT_DT not in", values, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtBetween(String value1, String value2) {
            addCriterion("LN_STRT_DT between", value1, value2, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnStrtDtNotBetween(String value1, String value2) {
            addCriterion("LN_STRT_DT not between", value1, value2, "lnStrtDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtIsNull() {
            addCriterion("LN_END_DT is null");
            return (Criteria) this;
        }

        public Criteria andLnEndDtIsNotNull() {
            addCriterion("LN_END_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLnEndDtEqualTo(String value) {
            addCriterion("LN_END_DT =", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtNotEqualTo(String value) {
            addCriterion("LN_END_DT <>", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtGreaterThan(String value) {
            addCriterion("LN_END_DT >", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtGreaterThanOrEqualTo(String value) {
            addCriterion("LN_END_DT >=", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtLessThan(String value) {
            addCriterion("LN_END_DT <", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtLessThanOrEqualTo(String value) {
            addCriterion("LN_END_DT <=", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtLike(String value) {
            addCriterion("LN_END_DT like", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtNotLike(String value) {
            addCriterion("LN_END_DT not like", value, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtIn(List<String> values) {
            addCriterion("LN_END_DT in", values, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtNotIn(List<String> values) {
            addCriterion("LN_END_DT not in", values, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtBetween(String value1, String value2) {
            addCriterion("LN_END_DT between", value1, value2, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andLnEndDtNotBetween(String value1, String value2) {
            addCriterion("LN_END_DT not between", value1, value2, "lnEndDt");
            return (Criteria) this;
        }

        public Criteria andTrmTypIsNull() {
            addCriterion("TRM_TYP is null");
            return (Criteria) this;
        }

        public Criteria andTrmTypIsNotNull() {
            addCriterion("TRM_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andTrmTypEqualTo(String value) {
            addCriterion("TRM_TYP =", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypNotEqualTo(String value) {
            addCriterion("TRM_TYP <>", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypGreaterThan(String value) {
            addCriterion("TRM_TYP >", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypGreaterThanOrEqualTo(String value) {
            addCriterion("TRM_TYP >=", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypLessThan(String value) {
            addCriterion("TRM_TYP <", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypLessThanOrEqualTo(String value) {
            addCriterion("TRM_TYP <=", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypLike(String value) {
            addCriterion("TRM_TYP like", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypNotLike(String value) {
            addCriterion("TRM_TYP not like", value, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypIn(List<String> values) {
            addCriterion("TRM_TYP in", values, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypNotIn(List<String> values) {
            addCriterion("TRM_TYP not in", values, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypBetween(String value1, String value2) {
            addCriterion("TRM_TYP between", value1, value2, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmTypNotBetween(String value1, String value2) {
            addCriterion("TRM_TYP not between", value1, value2, "trmTyp");
            return (Criteria) this;
        }

        public Criteria andTrmIsNull() {
            addCriterion("TRM is null");
            return (Criteria) this;
        }

        public Criteria andTrmIsNotNull() {
            addCriterion("TRM is not null");
            return (Criteria) this;
        }

        public Criteria andTrmEqualTo(String value) {
            addCriterion("TRM =", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotEqualTo(String value) {
            addCriterion("TRM <>", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmGreaterThan(String value) {
            addCriterion("TRM >", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmGreaterThanOrEqualTo(String value) {
            addCriterion("TRM >=", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmLessThan(String value) {
            addCriterion("TRM <", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmLessThanOrEqualTo(String value) {
            addCriterion("TRM <=", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmLike(String value) {
            addCriterion("TRM like", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotLike(String value) {
            addCriterion("TRM not like", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmIn(List<String> values) {
            addCriterion("TRM in", values, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotIn(List<String> values) {
            addCriterion("TRM not in", values, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmBetween(String value1, String value2) {
            addCriterion("TRM between", value1, value2, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotBetween(String value1, String value2) {
            addCriterion("TRM not between", value1, value2, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmYearIsNull() {
            addCriterion("TRM_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andTrmYearIsNotNull() {
            addCriterion("TRM_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andTrmYearEqualTo(BigDecimal value) {
            addCriterion("TRM_YEAR =", value, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearNotEqualTo(BigDecimal value) {
            addCriterion("TRM_YEAR <>", value, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearGreaterThan(BigDecimal value) {
            addCriterion("TRM_YEAR >", value, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_YEAR >=", value, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearLessThan(BigDecimal value) {
            addCriterion("TRM_YEAR <", value, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_YEAR <=", value, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearIn(List<BigDecimal> values) {
            addCriterion("TRM_YEAR in", values, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearNotIn(List<BigDecimal> values) {
            addCriterion("TRM_YEAR not in", values, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_YEAR between", value1, value2, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmYearNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_YEAR not between", value1, value2, "trmYear");
            return (Criteria) this;
        }

        public Criteria andTrmMonIsNull() {
            addCriterion("TRM_MON is null");
            return (Criteria) this;
        }

        public Criteria andTrmMonIsNotNull() {
            addCriterion("TRM_MON is not null");
            return (Criteria) this;
        }

        public Criteria andTrmMonEqualTo(BigDecimal value) {
            addCriterion("TRM_MON =", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonNotEqualTo(BigDecimal value) {
            addCriterion("TRM_MON <>", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonGreaterThan(BigDecimal value) {
            addCriterion("TRM_MON >", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_MON >=", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonLessThan(BigDecimal value) {
            addCriterion("TRM_MON <", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_MON <=", value, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonIn(List<BigDecimal> values) {
            addCriterion("TRM_MON in", values, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonNotIn(List<BigDecimal> values) {
            addCriterion("TRM_MON not in", values, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_MON between", value1, value2, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmMonNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_MON not between", value1, value2, "trmMon");
            return (Criteria) this;
        }

        public Criteria andTrmDayIsNull() {
            addCriterion("TRM_DAY is null");
            return (Criteria) this;
        }

        public Criteria andTrmDayIsNotNull() {
            addCriterion("TRM_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andTrmDayEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY =", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayNotEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY <>", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayGreaterThan(BigDecimal value) {
            addCriterion("TRM_DAY >", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY >=", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayLessThan(BigDecimal value) {
            addCriterion("TRM_DAY <", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRM_DAY <=", value, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayIn(List<BigDecimal> values) {
            addCriterion("TRM_DAY in", values, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayNotIn(List<BigDecimal> values) {
            addCriterion("TRM_DAY not in", values, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_DAY between", value1, value2, "trmDay");
            return (Criteria) this;
        }

        public Criteria andTrmDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRM_DAY not between", value1, value2, "trmDay");
            return (Criteria) this;
        }

        public Criteria andBasIntIsNull() {
            addCriterion("BAS_INT is null");
            return (Criteria) this;
        }

        public Criteria andBasIntIsNotNull() {
            addCriterion("BAS_INT is not null");
            return (Criteria) this;
        }

        public Criteria andBasIntEqualTo(BigDecimal value) {
            addCriterion("BAS_INT =", value, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntNotEqualTo(BigDecimal value) {
            addCriterion("BAS_INT <>", value, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntGreaterThan(BigDecimal value) {
            addCriterion("BAS_INT >", value, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAS_INT >=", value, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntLessThan(BigDecimal value) {
            addCriterion("BAS_INT <", value, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAS_INT <=", value, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntIn(List<BigDecimal> values) {
            addCriterion("BAS_INT in", values, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntNotIn(List<BigDecimal> values) {
            addCriterion("BAS_INT not in", values, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAS_INT between", value1, value2, "basInt");
            return (Criteria) this;
        }

        public Criteria andBasIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAS_INT not between", value1, value2, "basInt");
            return (Criteria) this;
        }

        public Criteria andRtnTypIsNull() {
            addCriterion("RTN_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRtnTypIsNotNull() {
            addCriterion("RTN_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRtnTypEqualTo(String value) {
            addCriterion("RTN_TYP =", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypNotEqualTo(String value) {
            addCriterion("RTN_TYP <>", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypGreaterThan(String value) {
            addCriterion("RTN_TYP >", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_TYP >=", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypLessThan(String value) {
            addCriterion("RTN_TYP <", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypLessThanOrEqualTo(String value) {
            addCriterion("RTN_TYP <=", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypLike(String value) {
            addCriterion("RTN_TYP like", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypNotLike(String value) {
            addCriterion("RTN_TYP not like", value, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypIn(List<String> values) {
            addCriterion("RTN_TYP in", values, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypNotIn(List<String> values) {
            addCriterion("RTN_TYP not in", values, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypBetween(String value1, String value2) {
            addCriterion("RTN_TYP between", value1, value2, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnTypNotBetween(String value1, String value2) {
            addCriterion("RTN_TYP not between", value1, value2, "rtnTyp");
            return (Criteria) this;
        }

        public Criteria andRtnInvlIsNull() {
            addCriterion("RTN_INVL is null");
            return (Criteria) this;
        }

        public Criteria andRtnInvlIsNotNull() {
            addCriterion("RTN_INVL is not null");
            return (Criteria) this;
        }

        public Criteria andRtnInvlEqualTo(String value) {
            addCriterion("RTN_INVL =", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlNotEqualTo(String value) {
            addCriterion("RTN_INVL <>", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlGreaterThan(String value) {
            addCriterion("RTN_INVL >", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_INVL >=", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlLessThan(String value) {
            addCriterion("RTN_INVL <", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlLessThanOrEqualTo(String value) {
            addCriterion("RTN_INVL <=", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlLike(String value) {
            addCriterion("RTN_INVL like", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlNotLike(String value) {
            addCriterion("RTN_INVL not like", value, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlIn(List<String> values) {
            addCriterion("RTN_INVL in", values, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlNotIn(List<String> values) {
            addCriterion("RTN_INVL not in", values, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlBetween(String value1, String value2) {
            addCriterion("RTN_INVL between", value1, value2, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnInvlNotBetween(String value1, String value2) {
            addCriterion("RTN_INVL not between", value1, value2, "rtnInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlIsNull() {
            addCriterion("RTN_INT_INVL is null");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlIsNotNull() {
            addCriterion("RTN_INT_INVL is not null");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlEqualTo(String value) {
            addCriterion("RTN_INT_INVL =", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlNotEqualTo(String value) {
            addCriterion("RTN_INT_INVL <>", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlGreaterThan(String value) {
            addCriterion("RTN_INT_INVL >", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_INT_INVL >=", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlLessThan(String value) {
            addCriterion("RTN_INT_INVL <", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlLessThanOrEqualTo(String value) {
            addCriterion("RTN_INT_INVL <=", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlLike(String value) {
            addCriterion("RTN_INT_INVL like", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlNotLike(String value) {
            addCriterion("RTN_INT_INVL not like", value, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlIn(List<String> values) {
            addCriterion("RTN_INT_INVL in", values, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlNotIn(List<String> values) {
            addCriterion("RTN_INT_INVL not in", values, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlBetween(String value1, String value2) {
            addCriterion("RTN_INT_INVL between", value1, value2, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnIntInvlNotBetween(String value1, String value2) {
            addCriterion("RTN_INT_INVL not between", value1, value2, "rtnIntInvl");
            return (Criteria) this;
        }

        public Criteria andRtnPdIsNull() {
            addCriterion("RTN_PD is null");
            return (Criteria) this;
        }

        public Criteria andRtnPdIsNotNull() {
            addCriterion("RTN_PD is not null");
            return (Criteria) this;
        }

        public Criteria andRtnPdEqualTo(BigDecimal value) {
            addCriterion("RTN_PD =", value, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdNotEqualTo(BigDecimal value) {
            addCriterion("RTN_PD <>", value, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdGreaterThan(BigDecimal value) {
            addCriterion("RTN_PD >", value, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RTN_PD >=", value, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdLessThan(BigDecimal value) {
            addCriterion("RTN_PD <", value, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RTN_PD <=", value, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdIn(List<BigDecimal> values) {
            addCriterion("RTN_PD in", values, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdNotIn(List<BigDecimal> values) {
            addCriterion("RTN_PD not in", values, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTN_PD between", value1, value2, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andRtnPdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTN_PD not between", value1, value2, "rtnPd");
            return (Criteria) this;
        }

        public Criteria andDogTypIsNull() {
            addCriterion("DOG_TYP is null");
            return (Criteria) this;
        }

        public Criteria andDogTypIsNotNull() {
            addCriterion("DOG_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andDogTypEqualTo(String value) {
            addCriterion("DOG_TYP =", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypNotEqualTo(String value) {
            addCriterion("DOG_TYP <>", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypGreaterThan(String value) {
            addCriterion("DOG_TYP >", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypGreaterThanOrEqualTo(String value) {
            addCriterion("DOG_TYP >=", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypLessThan(String value) {
            addCriterion("DOG_TYP <", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypLessThanOrEqualTo(String value) {
            addCriterion("DOG_TYP <=", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypLike(String value) {
            addCriterion("DOG_TYP like", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypNotLike(String value) {
            addCriterion("DOG_TYP not like", value, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypIn(List<String> values) {
            addCriterion("DOG_TYP in", values, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypNotIn(List<String> values) {
            addCriterion("DOG_TYP not in", values, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypBetween(String value1, String value2) {
            addCriterion("DOG_TYP between", value1, value2, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogTypNotBetween(String value1, String value2) {
            addCriterion("DOG_TYP not between", value1, value2, "dogTyp");
            return (Criteria) this;
        }

        public Criteria andDogIsNull() {
            addCriterion("DOG is null");
            return (Criteria) this;
        }

        public Criteria andDogIsNotNull() {
            addCriterion("DOG is not null");
            return (Criteria) this;
        }

        public Criteria andDogEqualTo(BigDecimal value) {
            addCriterion("DOG =", value, "dog");
            return (Criteria) this;
        }

        public Criteria andDogNotEqualTo(BigDecimal value) {
            addCriterion("DOG <>", value, "dog");
            return (Criteria) this;
        }

        public Criteria andDogGreaterThan(BigDecimal value) {
            addCriterion("DOG >", value, "dog");
            return (Criteria) this;
        }

        public Criteria andDogGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DOG >=", value, "dog");
            return (Criteria) this;
        }

        public Criteria andDogLessThan(BigDecimal value) {
            addCriterion("DOG <", value, "dog");
            return (Criteria) this;
        }

        public Criteria andDogLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DOG <=", value, "dog");
            return (Criteria) this;
        }

        public Criteria andDogIn(List<BigDecimal> values) {
            addCriterion("DOG in", values, "dog");
            return (Criteria) this;
        }

        public Criteria andDogNotIn(List<BigDecimal> values) {
            addCriterion("DOG not in", values, "dog");
            return (Criteria) this;
        }

        public Criteria andDogBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DOG between", value1, value2, "dog");
            return (Criteria) this;
        }

        public Criteria andDogNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DOG not between", value1, value2, "dog");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainIsNull() {
            addCriterion("GUAT_TYP_MAIN is null");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainIsNotNull() {
            addCriterion("GUAT_TYP_MAIN is not null");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainEqualTo(String value) {
            addCriterion("GUAT_TYP_MAIN =", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainNotEqualTo(String value) {
            addCriterion("GUAT_TYP_MAIN <>", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainGreaterThan(String value) {
            addCriterion("GUAT_TYP_MAIN >", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainGreaterThanOrEqualTo(String value) {
            addCriterion("GUAT_TYP_MAIN >=", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainLessThan(String value) {
            addCriterion("GUAT_TYP_MAIN <", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainLessThanOrEqualTo(String value) {
            addCriterion("GUAT_TYP_MAIN <=", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainLike(String value) {
            addCriterion("GUAT_TYP_MAIN like", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainNotLike(String value) {
            addCriterion("GUAT_TYP_MAIN not like", value, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainIn(List<String> values) {
            addCriterion("GUAT_TYP_MAIN in", values, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainNotIn(List<String> values) {
            addCriterion("GUAT_TYP_MAIN not in", values, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainBetween(String value1, String value2) {
            addCriterion("GUAT_TYP_MAIN between", value1, value2, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypMainNotBetween(String value1, String value2) {
            addCriterion("GUAT_TYP_MAIN not between", value1, value2, "guatTypMain");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthIsNull() {
            addCriterion("GUAT_TYP_OTH is null");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthIsNotNull() {
            addCriterion("GUAT_TYP_OTH is not null");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthEqualTo(String value) {
            addCriterion("GUAT_TYP_OTH =", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthNotEqualTo(String value) {
            addCriterion("GUAT_TYP_OTH <>", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthGreaterThan(String value) {
            addCriterion("GUAT_TYP_OTH >", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthGreaterThanOrEqualTo(String value) {
            addCriterion("GUAT_TYP_OTH >=", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthLessThan(String value) {
            addCriterion("GUAT_TYP_OTH <", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthLessThanOrEqualTo(String value) {
            addCriterion("GUAT_TYP_OTH <=", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthLike(String value) {
            addCriterion("GUAT_TYP_OTH like", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthNotLike(String value) {
            addCriterion("GUAT_TYP_OTH not like", value, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthIn(List<String> values) {
            addCriterion("GUAT_TYP_OTH in", values, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthNotIn(List<String> values) {
            addCriterion("GUAT_TYP_OTH not in", values, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthBetween(String value1, String value2) {
            addCriterion("GUAT_TYP_OTH between", value1, value2, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andGuatTypOthNotBetween(String value1, String value2) {
            addCriterion("GUAT_TYP_OTH not between", value1, value2, "guatTypOth");
            return (Criteria) this;
        }

        public Criteria andLnDirIsNull() {
            addCriterion("LN_DIR is null");
            return (Criteria) this;
        }

        public Criteria andLnDirIsNotNull() {
            addCriterion("LN_DIR is not null");
            return (Criteria) this;
        }

        public Criteria andLnDirEqualTo(String value) {
            addCriterion("LN_DIR =", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirNotEqualTo(String value) {
            addCriterion("LN_DIR <>", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirGreaterThan(String value) {
            addCriterion("LN_DIR >", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirGreaterThanOrEqualTo(String value) {
            addCriterion("LN_DIR >=", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirLessThan(String value) {
            addCriterion("LN_DIR <", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirLessThanOrEqualTo(String value) {
            addCriterion("LN_DIR <=", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirLike(String value) {
            addCriterion("LN_DIR like", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirNotLike(String value) {
            addCriterion("LN_DIR not like", value, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirIn(List<String> values) {
            addCriterion("LN_DIR in", values, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirNotIn(List<String> values) {
            addCriterion("LN_DIR not in", values, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirBetween(String value1, String value2) {
            addCriterion("LN_DIR between", value1, value2, "lnDir");
            return (Criteria) this;
        }

        public Criteria andLnDirNotBetween(String value1, String value2) {
            addCriterion("LN_DIR not between", value1, value2, "lnDir");
            return (Criteria) this;
        }

        public Criteria andDirNmIsNull() {
            addCriterion("DIR_NM is null");
            return (Criteria) this;
        }

        public Criteria andDirNmIsNotNull() {
            addCriterion("DIR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andDirNmEqualTo(String value) {
            addCriterion("DIR_NM =", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmNotEqualTo(String value) {
            addCriterion("DIR_NM <>", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmGreaterThan(String value) {
            addCriterion("DIR_NM >", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmGreaterThanOrEqualTo(String value) {
            addCriterion("DIR_NM >=", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmLessThan(String value) {
            addCriterion("DIR_NM <", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmLessThanOrEqualTo(String value) {
            addCriterion("DIR_NM <=", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmLike(String value) {
            addCriterion("DIR_NM like", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmNotLike(String value) {
            addCriterion("DIR_NM not like", value, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmIn(List<String> values) {
            addCriterion("DIR_NM in", values, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmNotIn(List<String> values) {
            addCriterion("DIR_NM not in", values, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmBetween(String value1, String value2) {
            addCriterion("DIR_NM between", value1, value2, "dirNm");
            return (Criteria) this;
        }

        public Criteria andDirNmNotBetween(String value1, String value2) {
            addCriterion("DIR_NM not between", value1, value2, "dirNm");
            return (Criteria) this;
        }

        public Criteria andFeeAmtIsNull() {
            addCriterion("FEE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andFeeAmtIsNotNull() {
            addCriterion("FEE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andFeeAmtEqualTo(BigDecimal value) {
            addCriterion("FEE_AMT =", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtNotEqualTo(BigDecimal value) {
            addCriterion("FEE_AMT <>", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtGreaterThan(BigDecimal value) {
            addCriterion("FEE_AMT >", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_AMT >=", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtLessThan(BigDecimal value) {
            addCriterion("FEE_AMT <", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_AMT <=", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtIn(List<BigDecimal> values) {
            addCriterion("FEE_AMT in", values, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtNotIn(List<BigDecimal> values) {
            addCriterion("FEE_AMT not in", values, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_AMT between", value1, value2, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_AMT not between", value1, value2, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeRatIsNull() {
            addCriterion("FEE_RAT is null");
            return (Criteria) this;
        }

        public Criteria andFeeRatIsNotNull() {
            addCriterion("FEE_RAT is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRatEqualTo(BigDecimal value) {
            addCriterion("FEE_RAT =", value, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatNotEqualTo(BigDecimal value) {
            addCriterion("FEE_RAT <>", value, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatGreaterThan(BigDecimal value) {
            addCriterion("FEE_RAT >", value, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RAT >=", value, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatLessThan(BigDecimal value) {
            addCriterion("FEE_RAT <", value, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RAT <=", value, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatIn(List<BigDecimal> values) {
            addCriterion("FEE_RAT in", values, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatNotIn(List<BigDecimal> values) {
            addCriterion("FEE_RAT not in", values, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RAT between", value1, value2, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeRatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RAT not between", value1, value2, "feeRat");
            return (Criteria) this;
        }

        public Criteria andFeeTypIsNull() {
            addCriterion("FEE_TYP is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypIsNotNull() {
            addCriterion("FEE_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypEqualTo(String value) {
            addCriterion("FEE_TYP =", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypNotEqualTo(String value) {
            addCriterion("FEE_TYP <>", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypGreaterThan(String value) {
            addCriterion("FEE_TYP >", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_TYP >=", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypLessThan(String value) {
            addCriterion("FEE_TYP <", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypLessThanOrEqualTo(String value) {
            addCriterion("FEE_TYP <=", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypLike(String value) {
            addCriterion("FEE_TYP like", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypNotLike(String value) {
            addCriterion("FEE_TYP not like", value, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypIn(List<String> values) {
            addCriterion("FEE_TYP in", values, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypNotIn(List<String> values) {
            addCriterion("FEE_TYP not in", values, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypBetween(String value1, String value2) {
            addCriterion("FEE_TYP between", value1, value2, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeeTypNotBetween(String value1, String value2) {
            addCriterion("FEE_TYP not between", value1, value2, "feeTyp");
            return (Criteria) this;
        }

        public Criteria andFeePdIsNull() {
            addCriterion("FEE_PD is null");
            return (Criteria) this;
        }

        public Criteria andFeePdIsNotNull() {
            addCriterion("FEE_PD is not null");
            return (Criteria) this;
        }

        public Criteria andFeePdEqualTo(String value) {
            addCriterion("FEE_PD =", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdNotEqualTo(String value) {
            addCriterion("FEE_PD <>", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdGreaterThan(String value) {
            addCriterion("FEE_PD >", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_PD >=", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdLessThan(String value) {
            addCriterion("FEE_PD <", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdLessThanOrEqualTo(String value) {
            addCriterion("FEE_PD <=", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdLike(String value) {
            addCriterion("FEE_PD like", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdNotLike(String value) {
            addCriterion("FEE_PD not like", value, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdIn(List<String> values) {
            addCriterion("FEE_PD in", values, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdNotIn(List<String> values) {
            addCriterion("FEE_PD not in", values, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdBetween(String value1, String value2) {
            addCriterion("FEE_PD between", value1, value2, "feePd");
            return (Criteria) this;
        }

        public Criteria andFeePdNotBetween(String value1, String value2) {
            addCriterion("FEE_PD not between", value1, value2, "feePd");
            return (Criteria) this;
        }

        public Criteria andRtnSrcIsNull() {
            addCriterion("RTN_SRC is null");
            return (Criteria) this;
        }

        public Criteria andRtnSrcIsNotNull() {
            addCriterion("RTN_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andRtnSrcEqualTo(String value) {
            addCriterion("RTN_SRC =", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcNotEqualTo(String value) {
            addCriterion("RTN_SRC <>", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcGreaterThan(String value) {
            addCriterion("RTN_SRC >", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_SRC >=", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcLessThan(String value) {
            addCriterion("RTN_SRC <", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcLessThanOrEqualTo(String value) {
            addCriterion("RTN_SRC <=", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcLike(String value) {
            addCriterion("RTN_SRC like", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcNotLike(String value) {
            addCriterion("RTN_SRC not like", value, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcIn(List<String> values) {
            addCriterion("RTN_SRC in", values, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcNotIn(List<String> values) {
            addCriterion("RTN_SRC not in", values, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcBetween(String value1, String value2) {
            addCriterion("RTN_SRC between", value1, value2, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRtnSrcNotBetween(String value1, String value2) {
            addCriterion("RTN_SRC not between", value1, value2, "rtnSrc");
            return (Criteria) this;
        }

        public Criteria andRiskClsIsNull() {
            addCriterion("RISK_CLS is null");
            return (Criteria) this;
        }

        public Criteria andRiskClsIsNotNull() {
            addCriterion("RISK_CLS is not null");
            return (Criteria) this;
        }

        public Criteria andRiskClsEqualTo(String value) {
            addCriterion("RISK_CLS =", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsNotEqualTo(String value) {
            addCriterion("RISK_CLS <>", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsGreaterThan(String value) {
            addCriterion("RISK_CLS >", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_CLS >=", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsLessThan(String value) {
            addCriterion("RISK_CLS <", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsLessThanOrEqualTo(String value) {
            addCriterion("RISK_CLS <=", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsLike(String value) {
            addCriterion("RISK_CLS like", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsNotLike(String value) {
            addCriterion("RISK_CLS not like", value, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsIn(List<String> values) {
            addCriterion("RISK_CLS in", values, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsNotIn(List<String> values) {
            addCriterion("RISK_CLS not in", values, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsBetween(String value1, String value2) {
            addCriterion("RISK_CLS between", value1, value2, "riskCls");
            return (Criteria) this;
        }

        public Criteria andRiskClsNotBetween(String value1, String value2) {
            addCriterion("RISK_CLS not between", value1, value2, "riskCls");
            return (Criteria) this;
        }

        public Criteria andInvstConclIsNull() {
            addCriterion("INVST_CONCL is null");
            return (Criteria) this;
        }

        public Criteria andInvstConclIsNotNull() {
            addCriterion("INVST_CONCL is not null");
            return (Criteria) this;
        }

        public Criteria andInvstConclEqualTo(String value) {
            addCriterion("INVST_CONCL =", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclNotEqualTo(String value) {
            addCriterion("INVST_CONCL <>", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclGreaterThan(String value) {
            addCriterion("INVST_CONCL >", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclGreaterThanOrEqualTo(String value) {
            addCriterion("INVST_CONCL >=", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclLessThan(String value) {
            addCriterion("INVST_CONCL <", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclLessThanOrEqualTo(String value) {
            addCriterion("INVST_CONCL <=", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclLike(String value) {
            addCriterion("INVST_CONCL like", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclNotLike(String value) {
            addCriterion("INVST_CONCL not like", value, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclIn(List<String> values) {
            addCriterion("INVST_CONCL in", values, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclNotIn(List<String> values) {
            addCriterion("INVST_CONCL not in", values, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclBetween(String value1, String value2) {
            addCriterion("INVST_CONCL between", value1, value2, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andInvstConclNotBetween(String value1, String value2) {
            addCriterion("INVST_CONCL not between", value1, value2, "invstConcl");
            return (Criteria) this;
        }

        public Criteria andCrMdlIsNull() {
            addCriterion("CR_MDL is null");
            return (Criteria) this;
        }

        public Criteria andCrMdlIsNotNull() {
            addCriterion("CR_MDL is not null");
            return (Criteria) this;
        }

        public Criteria andCrMdlEqualTo(String value) {
            addCriterion("CR_MDL =", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlNotEqualTo(String value) {
            addCriterion("CR_MDL <>", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlGreaterThan(String value) {
            addCriterion("CR_MDL >", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlGreaterThanOrEqualTo(String value) {
            addCriterion("CR_MDL >=", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlLessThan(String value) {
            addCriterion("CR_MDL <", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlLessThanOrEqualTo(String value) {
            addCriterion("CR_MDL <=", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlLike(String value) {
            addCriterion("CR_MDL like", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlNotLike(String value) {
            addCriterion("CR_MDL not like", value, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlIn(List<String> values) {
            addCriterion("CR_MDL in", values, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlNotIn(List<String> values) {
            addCriterion("CR_MDL not in", values, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlBetween(String value1, String value2) {
            addCriterion("CR_MDL between", value1, value2, "crMdl");
            return (Criteria) this;
        }

        public Criteria andCrMdlNotBetween(String value1, String value2) {
            addCriterion("CR_MDL not between", value1, value2, "crMdl");
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

        public Criteria andCrNoIsNull() {
            addCriterion("CR_NO is null");
            return (Criteria) this;
        }

        public Criteria andCrNoIsNotNull() {
            addCriterion("CR_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCrNoEqualTo(String value) {
            addCriterion("CR_NO =", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoNotEqualTo(String value) {
            addCriterion("CR_NO <>", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoGreaterThan(String value) {
            addCriterion("CR_NO >", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoGreaterThanOrEqualTo(String value) {
            addCriterion("CR_NO >=", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoLessThan(String value) {
            addCriterion("CR_NO <", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoLessThanOrEqualTo(String value) {
            addCriterion("CR_NO <=", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoLike(String value) {
            addCriterion("CR_NO like", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoNotLike(String value) {
            addCriterion("CR_NO not like", value, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoIn(List<String> values) {
            addCriterion("CR_NO in", values, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoNotIn(List<String> values) {
            addCriterion("CR_NO not in", values, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoBetween(String value1, String value2) {
            addCriterion("CR_NO between", value1, value2, "crNo");
            return (Criteria) this;
        }

        public Criteria andCrNoNotBetween(String value1, String value2) {
            addCriterion("CR_NO not between", value1, value2, "crNo");
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

        public Criteria andRtnDtTypIsNull() {
            addCriterion("RTN_DT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypIsNotNull() {
            addCriterion("RTN_DT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypEqualTo(String value) {
            addCriterion("RTN_DT_TYP =", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypNotEqualTo(String value) {
            addCriterion("RTN_DT_TYP <>", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypGreaterThan(String value) {
            addCriterion("RTN_DT_TYP >", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_DT_TYP >=", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypLessThan(String value) {
            addCriterion("RTN_DT_TYP <", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypLessThanOrEqualTo(String value) {
            addCriterion("RTN_DT_TYP <=", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypLike(String value) {
            addCriterion("RTN_DT_TYP like", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypNotLike(String value) {
            addCriterion("RTN_DT_TYP not like", value, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypIn(List<String> values) {
            addCriterion("RTN_DT_TYP in", values, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypNotIn(List<String> values) {
            addCriterion("RTN_DT_TYP not in", values, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypBetween(String value1, String value2) {
            addCriterion("RTN_DT_TYP between", value1, value2, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtTypNotBetween(String value1, String value2) {
            addCriterion("RTN_DT_TYP not between", value1, value2, "rtnDtTyp");
            return (Criteria) this;
        }

        public Criteria andRtnDtIsNull() {
            addCriterion("RTN_DT is null");
            return (Criteria) this;
        }

        public Criteria andRtnDtIsNotNull() {
            addCriterion("RTN_DT is not null");
            return (Criteria) this;
        }

        public Criteria andRtnDtEqualTo(String value) {
            addCriterion("RTN_DT =", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtNotEqualTo(String value) {
            addCriterion("RTN_DT <>", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtGreaterThan(String value) {
            addCriterion("RTN_DT >", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_DT >=", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtLessThan(String value) {
            addCriterion("RTN_DT <", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtLessThanOrEqualTo(String value) {
            addCriterion("RTN_DT <=", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtLike(String value) {
            addCriterion("RTN_DT like", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtNotLike(String value) {
            addCriterion("RTN_DT not like", value, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtIn(List<String> values) {
            addCriterion("RTN_DT in", values, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtNotIn(List<String> values) {
            addCriterion("RTN_DT not in", values, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtBetween(String value1, String value2) {
            addCriterion("RTN_DT between", value1, value2, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andRtnDtNotBetween(String value1, String value2) {
            addCriterion("RTN_DT not between", value1, value2, "rtnDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjIsNull() {
            addCriterion("INT_ADJ is null");
            return (Criteria) this;
        }

        public Criteria andIntAdjIsNotNull() {
            addCriterion("INT_ADJ is not null");
            return (Criteria) this;
        }

        public Criteria andIntAdjEqualTo(String value) {
            addCriterion("INT_ADJ =", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjNotEqualTo(String value) {
            addCriterion("INT_ADJ <>", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjGreaterThan(String value) {
            addCriterion("INT_ADJ >", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjGreaterThanOrEqualTo(String value) {
            addCriterion("INT_ADJ >=", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjLessThan(String value) {
            addCriterion("INT_ADJ <", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjLessThanOrEqualTo(String value) {
            addCriterion("INT_ADJ <=", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjLike(String value) {
            addCriterion("INT_ADJ like", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjNotLike(String value) {
            addCriterion("INT_ADJ not like", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjIn(List<String> values) {
            addCriterion("INT_ADJ in", values, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjNotIn(List<String> values) {
            addCriterion("INT_ADJ not in", values, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjBetween(String value1, String value2) {
            addCriterion("INT_ADJ between", value1, value2, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjNotBetween(String value1, String value2) {
            addCriterion("INT_ADJ not between", value1, value2, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtIsNull() {
            addCriterion("INT_ADJ_DT is null");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtIsNotNull() {
            addCriterion("INT_ADJ_DT is not null");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtEqualTo(String value) {
            addCriterion("INT_ADJ_DT =", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtNotEqualTo(String value) {
            addCriterion("INT_ADJ_DT <>", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtGreaterThan(String value) {
            addCriterion("INT_ADJ_DT >", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtGreaterThanOrEqualTo(String value) {
            addCriterion("INT_ADJ_DT >=", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtLessThan(String value) {
            addCriterion("INT_ADJ_DT <", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtLessThanOrEqualTo(String value) {
            addCriterion("INT_ADJ_DT <=", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtLike(String value) {
            addCriterion("INT_ADJ_DT like", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtNotLike(String value) {
            addCriterion("INT_ADJ_DT not like", value, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtIn(List<String> values) {
            addCriterion("INT_ADJ_DT in", values, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtNotIn(List<String> values) {
            addCriterion("INT_ADJ_DT not in", values, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtBetween(String value1, String value2) {
            addCriterion("INT_ADJ_DT between", value1, value2, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntAdjDtNotBetween(String value1, String value2) {
            addCriterion("INT_ADJ_DT not between", value1, value2, "intAdjDt");
            return (Criteria) this;
        }

        public Criteria andIntCdIsNull() {
            addCriterion("INT_CD is null");
            return (Criteria) this;
        }

        public Criteria andIntCdIsNotNull() {
            addCriterion("INT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andIntCdEqualTo(String value) {
            addCriterion("INT_CD =", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdNotEqualTo(String value) {
            addCriterion("INT_CD <>", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdGreaterThan(String value) {
            addCriterion("INT_CD >", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdGreaterThanOrEqualTo(String value) {
            addCriterion("INT_CD >=", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdLessThan(String value) {
            addCriterion("INT_CD <", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdLessThanOrEqualTo(String value) {
            addCriterion("INT_CD <=", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdLike(String value) {
            addCriterion("INT_CD like", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdNotLike(String value) {
            addCriterion("INT_CD not like", value, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdIn(List<String> values) {
            addCriterion("INT_CD in", values, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdNotIn(List<String> values) {
            addCriterion("INT_CD not in", values, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdBetween(String value1, String value2) {
            addCriterion("INT_CD between", value1, value2, "intCd");
            return (Criteria) this;
        }

        public Criteria andIntCdNotBetween(String value1, String value2) {
            addCriterion("INT_CD not between", value1, value2, "intCd");
            return (Criteria) this;
        }

        public Criteria andFixFlgIsNull() {
            addCriterion("FIX_FLG is null");
            return (Criteria) this;
        }

        public Criteria andFixFlgIsNotNull() {
            addCriterion("FIX_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andFixFlgEqualTo(String value) {
            addCriterion("FIX_FLG =", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgNotEqualTo(String value) {
            addCriterion("FIX_FLG <>", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgGreaterThan(String value) {
            addCriterion("FIX_FLG >", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgGreaterThanOrEqualTo(String value) {
            addCriterion("FIX_FLG >=", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgLessThan(String value) {
            addCriterion("FIX_FLG <", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgLessThanOrEqualTo(String value) {
            addCriterion("FIX_FLG <=", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgLike(String value) {
            addCriterion("FIX_FLG like", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgNotLike(String value) {
            addCriterion("FIX_FLG not like", value, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgIn(List<String> values) {
            addCriterion("FIX_FLG in", values, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgNotIn(List<String> values) {
            addCriterion("FIX_FLG not in", values, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgBetween(String value1, String value2) {
            addCriterion("FIX_FLG between", value1, value2, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFixFlgNotBetween(String value1, String value2) {
            addCriterion("FIX_FLG not between", value1, value2, "fixFlg");
            return (Criteria) this;
        }

        public Criteria andFltIntValIsNull() {
            addCriterion("FLT_INT_VAL is null");
            return (Criteria) this;
        }

        public Criteria andFltIntValIsNotNull() {
            addCriterion("FLT_INT_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andFltIntValEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_VAL =", value, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValNotEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_VAL <>", value, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValGreaterThan(BigDecimal value) {
            addCriterion("FLT_INT_VAL >", value, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_VAL >=", value, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValLessThan(BigDecimal value) {
            addCriterion("FLT_INT_VAL <", value, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_VAL <=", value, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValIn(List<BigDecimal> values) {
            addCriterion("FLT_INT_VAL in", values, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValNotIn(List<BigDecimal> values) {
            addCriterion("FLT_INT_VAL not in", values, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLT_INT_VAL between", value1, value2, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLT_INT_VAL not between", value1, value2, "fltIntVal");
            return (Criteria) this;
        }

        public Criteria andFltIntRtIsNull() {
            addCriterion("FLT_INT_RT is null");
            return (Criteria) this;
        }

        public Criteria andFltIntRtIsNotNull() {
            addCriterion("FLT_INT_RT is not null");
            return (Criteria) this;
        }

        public Criteria andFltIntRtEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_RT =", value, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtNotEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_RT <>", value, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtGreaterThan(BigDecimal value) {
            addCriterion("FLT_INT_RT >", value, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_RT >=", value, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtLessThan(BigDecimal value) {
            addCriterion("FLT_INT_RT <", value, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLT_INT_RT <=", value, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtIn(List<BigDecimal> values) {
            addCriterion("FLT_INT_RT in", values, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtNotIn(List<BigDecimal> values) {
            addCriterion("FLT_INT_RT not in", values, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLT_INT_RT between", value1, value2, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFltIntRtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLT_INT_RT not between", value1, value2, "fltIntRt");
            return (Criteria) this;
        }

        public Criteria andFixTrmIsNull() {
            addCriterion("FIX_TRM is null");
            return (Criteria) this;
        }

        public Criteria andFixTrmIsNotNull() {
            addCriterion("FIX_TRM is not null");
            return (Criteria) this;
        }

        public Criteria andFixTrmEqualTo(String value) {
            addCriterion("FIX_TRM =", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmNotEqualTo(String value) {
            addCriterion("FIX_TRM <>", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmGreaterThan(String value) {
            addCriterion("FIX_TRM >", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmGreaterThanOrEqualTo(String value) {
            addCriterion("FIX_TRM >=", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmLessThan(String value) {
            addCriterion("FIX_TRM <", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmLessThanOrEqualTo(String value) {
            addCriterion("FIX_TRM <=", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmLike(String value) {
            addCriterion("FIX_TRM like", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmNotLike(String value) {
            addCriterion("FIX_TRM not like", value, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmIn(List<String> values) {
            addCriterion("FIX_TRM in", values, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmNotIn(List<String> values) {
            addCriterion("FIX_TRM not in", values, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmBetween(String value1, String value2) {
            addCriterion("FIX_TRM between", value1, value2, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixTrmNotBetween(String value1, String value2) {
            addCriterion("FIX_TRM not between", value1, value2, "fixTrm");
            return (Criteria) this;
        }

        public Criteria andFixIntIsNull() {
            addCriterion("FIX_INT is null");
            return (Criteria) this;
        }

        public Criteria andFixIntIsNotNull() {
            addCriterion("FIX_INT is not null");
            return (Criteria) this;
        }

        public Criteria andFixIntEqualTo(BigDecimal value) {
            addCriterion("FIX_INT =", value, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntNotEqualTo(BigDecimal value) {
            addCriterion("FIX_INT <>", value, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntGreaterThan(BigDecimal value) {
            addCriterion("FIX_INT >", value, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FIX_INT >=", value, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntLessThan(BigDecimal value) {
            addCriterion("FIX_INT <", value, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FIX_INT <=", value, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntIn(List<BigDecimal> values) {
            addCriterion("FIX_INT in", values, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntNotIn(List<BigDecimal> values) {
            addCriterion("FIX_INT not in", values, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIX_INT between", value1, value2, "fixInt");
            return (Criteria) this;
        }

        public Criteria andFixIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIX_INT not between", value1, value2, "fixInt");
            return (Criteria) this;
        }

        public Criteria andActIntIsNull() {
            addCriterion("ACT_INT is null");
            return (Criteria) this;
        }

        public Criteria andActIntIsNotNull() {
            addCriterion("ACT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andActIntEqualTo(BigDecimal value) {
            addCriterion("ACT_INT =", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotEqualTo(BigDecimal value) {
            addCriterion("ACT_INT <>", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntGreaterThan(BigDecimal value) {
            addCriterion("ACT_INT >", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT_INT >=", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntLessThan(BigDecimal value) {
            addCriterion("ACT_INT <", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT_INT <=", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntIn(List<BigDecimal> values) {
            addCriterion("ACT_INT in", values, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotIn(List<BigDecimal> values) {
            addCriterion("ACT_INT not in", values, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT_INT between", value1, value2, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT_INT not between", value1, value2, "actInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptIsNull() {
            addCriterion("PFLT_INT_OPT is null");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptIsNotNull() {
            addCriterion("PFLT_INT_OPT is not null");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptEqualTo(String value) {
            addCriterion("PFLT_INT_OPT =", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptNotEqualTo(String value) {
            addCriterion("PFLT_INT_OPT <>", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptGreaterThan(String value) {
            addCriterion("PFLT_INT_OPT >", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptGreaterThanOrEqualTo(String value) {
            addCriterion("PFLT_INT_OPT >=", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptLessThan(String value) {
            addCriterion("PFLT_INT_OPT <", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptLessThanOrEqualTo(String value) {
            addCriterion("PFLT_INT_OPT <=", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptLike(String value) {
            addCriterion("PFLT_INT_OPT like", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptNotLike(String value) {
            addCriterion("PFLT_INT_OPT not like", value, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptIn(List<String> values) {
            addCriterion("PFLT_INT_OPT in", values, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptNotIn(List<String> values) {
            addCriterion("PFLT_INT_OPT not in", values, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptBetween(String value1, String value2) {
            addCriterion("PFLT_INT_OPT between", value1, value2, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltIntOptNotBetween(String value1, String value2) {
            addCriterion("PFLT_INT_OPT not between", value1, value2, "pfltIntOpt");
            return (Criteria) this;
        }

        public Criteria andPfltCdIsNull() {
            addCriterion("PFLT_CD is null");
            return (Criteria) this;
        }

        public Criteria andPfltCdIsNotNull() {
            addCriterion("PFLT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andPfltCdEqualTo(String value) {
            addCriterion("PFLT_CD =", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdNotEqualTo(String value) {
            addCriterion("PFLT_CD <>", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdGreaterThan(String value) {
            addCriterion("PFLT_CD >", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdGreaterThanOrEqualTo(String value) {
            addCriterion("PFLT_CD >=", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdLessThan(String value) {
            addCriterion("PFLT_CD <", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdLessThanOrEqualTo(String value) {
            addCriterion("PFLT_CD <=", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdLike(String value) {
            addCriterion("PFLT_CD like", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdNotLike(String value) {
            addCriterion("PFLT_CD not like", value, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdIn(List<String> values) {
            addCriterion("PFLT_CD in", values, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdNotIn(List<String> values) {
            addCriterion("PFLT_CD not in", values, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdBetween(String value1, String value2) {
            addCriterion("PFLT_CD between", value1, value2, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltCdNotBetween(String value1, String value2) {
            addCriterion("PFLT_CD not between", value1, value2, "pfltCd");
            return (Criteria) this;
        }

        public Criteria andPfltFltIsNull() {
            addCriterion("PFLT_FLT is null");
            return (Criteria) this;
        }

        public Criteria andPfltFltIsNotNull() {
            addCriterion("PFLT_FLT is not null");
            return (Criteria) this;
        }

        public Criteria andPfltFltEqualTo(BigDecimal value) {
            addCriterion("PFLT_FLT =", value, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltNotEqualTo(BigDecimal value) {
            addCriterion("PFLT_FLT <>", value, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltGreaterThan(BigDecimal value) {
            addCriterion("PFLT_FLT >", value, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFLT_FLT >=", value, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltLessThan(BigDecimal value) {
            addCriterion("PFLT_FLT <", value, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFLT_FLT <=", value, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltIn(List<BigDecimal> values) {
            addCriterion("PFLT_FLT in", values, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltNotIn(List<BigDecimal> values) {
            addCriterion("PFLT_FLT not in", values, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFLT_FLT between", value1, value2, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltFltNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFLT_FLT not between", value1, value2, "pfltFlt");
            return (Criteria) this;
        }

        public Criteria andPfltIntIsNull() {
            addCriterion("PFLT_INT is null");
            return (Criteria) this;
        }

        public Criteria andPfltIntIsNotNull() {
            addCriterion("PFLT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andPfltIntEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT =", value, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntNotEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT <>", value, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntGreaterThan(BigDecimal value) {
            addCriterion("PFLT_INT >", value, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT >=", value, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntLessThan(BigDecimal value) {
            addCriterion("PFLT_INT <", value, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT <=", value, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntIn(List<BigDecimal> values) {
            addCriterion("PFLT_INT in", values, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntNotIn(List<BigDecimal> values) {
            addCriterion("PFLT_INT not in", values, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFLT_INT between", value1, value2, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFLT_INT not between", value1, value2, "pfltInt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptIsNull() {
            addCriterion("PFLT_FLT_OPT is null");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptIsNotNull() {
            addCriterion("PFLT_FLT_OPT is not null");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptEqualTo(String value) {
            addCriterion("PFLT_FLT_OPT =", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptNotEqualTo(String value) {
            addCriterion("PFLT_FLT_OPT <>", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptGreaterThan(String value) {
            addCriterion("PFLT_FLT_OPT >", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptGreaterThanOrEqualTo(String value) {
            addCriterion("PFLT_FLT_OPT >=", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptLessThan(String value) {
            addCriterion("PFLT_FLT_OPT <", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptLessThanOrEqualTo(String value) {
            addCriterion("PFLT_FLT_OPT <=", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptLike(String value) {
            addCriterion("PFLT_FLT_OPT like", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptNotLike(String value) {
            addCriterion("PFLT_FLT_OPT not like", value, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptIn(List<String> values) {
            addCriterion("PFLT_FLT_OPT in", values, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptNotIn(List<String> values) {
            addCriterion("PFLT_FLT_OPT not in", values, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptBetween(String value1, String value2) {
            addCriterion("PFLT_FLT_OPT between", value1, value2, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andPfltFltOptNotBetween(String value1, String value2) {
            addCriterion("PFLT_FLT_OPT not between", value1, value2, "pfltFltOpt");
            return (Criteria) this;
        }

        public Criteria andIsComintIsNull() {
            addCriterion("IS_COMINT is null");
            return (Criteria) this;
        }

        public Criteria andIsComintIsNotNull() {
            addCriterion("IS_COMINT is not null");
            return (Criteria) this;
        }

        public Criteria andIsComintEqualTo(String value) {
            addCriterion("IS_COMINT =", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintNotEqualTo(String value) {
            addCriterion("IS_COMINT <>", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintGreaterThan(String value) {
            addCriterion("IS_COMINT >", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintGreaterThanOrEqualTo(String value) {
            addCriterion("IS_COMINT >=", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintLessThan(String value) {
            addCriterion("IS_COMINT <", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintLessThanOrEqualTo(String value) {
            addCriterion("IS_COMINT <=", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintLike(String value) {
            addCriterion("IS_COMINT like", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintNotLike(String value) {
            addCriterion("IS_COMINT not like", value, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintIn(List<String> values) {
            addCriterion("IS_COMINT in", values, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintNotIn(List<String> values) {
            addCriterion("IS_COMINT not in", values, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintBetween(String value1, String value2) {
            addCriterion("IS_COMINT between", value1, value2, "isComint");
            return (Criteria) this;
        }

        public Criteria andIsComintNotBetween(String value1, String value2) {
            addCriterion("IS_COMINT not between", value1, value2, "isComint");
            return (Criteria) this;
        }

        public Criteria andAppDtIsNull() {
            addCriterion("APP_DT is null");
            return (Criteria) this;
        }

        public Criteria andAppDtIsNotNull() {
            addCriterion("APP_DT is not null");
            return (Criteria) this;
        }

        public Criteria andAppDtEqualTo(String value) {
            addCriterion("APP_DT =", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtNotEqualTo(String value) {
            addCriterion("APP_DT <>", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtGreaterThan(String value) {
            addCriterion("APP_DT >", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtGreaterThanOrEqualTo(String value) {
            addCriterion("APP_DT >=", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtLessThan(String value) {
            addCriterion("APP_DT <", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtLessThanOrEqualTo(String value) {
            addCriterion("APP_DT <=", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtLike(String value) {
            addCriterion("APP_DT like", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtNotLike(String value) {
            addCriterion("APP_DT not like", value, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtIn(List<String> values) {
            addCriterion("APP_DT in", values, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtNotIn(List<String> values) {
            addCriterion("APP_DT not in", values, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtBetween(String value1, String value2) {
            addCriterion("APP_DT between", value1, value2, "appDt");
            return (Criteria) this;
        }

        public Criteria andAppDtNotBetween(String value1, String value2) {
            addCriterion("APP_DT not between", value1, value2, "appDt");
            return (Criteria) this;
        }

        public Criteria andIntFltTypIsNull() {
            addCriterion("INT_FLT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andIntFltTypIsNotNull() {
            addCriterion("INT_FLT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andIntFltTypEqualTo(String value) {
            addCriterion("INT_FLT_TYP =", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypNotEqualTo(String value) {
            addCriterion("INT_FLT_TYP <>", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypGreaterThan(String value) {
            addCriterion("INT_FLT_TYP >", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypGreaterThanOrEqualTo(String value) {
            addCriterion("INT_FLT_TYP >=", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypLessThan(String value) {
            addCriterion("INT_FLT_TYP <", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypLessThanOrEqualTo(String value) {
            addCriterion("INT_FLT_TYP <=", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypLike(String value) {
            addCriterion("INT_FLT_TYP like", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypNotLike(String value) {
            addCriterion("INT_FLT_TYP not like", value, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypIn(List<String> values) {
            addCriterion("INT_FLT_TYP in", values, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypNotIn(List<String> values) {
            addCriterion("INT_FLT_TYP not in", values, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypBetween(String value1, String value2) {
            addCriterion("INT_FLT_TYP between", value1, value2, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andIntFltTypNotBetween(String value1, String value2) {
            addCriterion("INT_FLT_TYP not between", value1, value2, "intFltTyp");
            return (Criteria) this;
        }

        public Criteria andActBrCdIsNull() {
            addCriterion("ACT_BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andActBrCdIsNotNull() {
            addCriterion("ACT_BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andActBrCdEqualTo(String value) {
            addCriterion("ACT_BR_CD =", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotEqualTo(String value) {
            addCriterion("ACT_BR_CD <>", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdGreaterThan(String value) {
            addCriterion("ACT_BR_CD >", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_BR_CD >=", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdLessThan(String value) {
            addCriterion("ACT_BR_CD <", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdLessThanOrEqualTo(String value) {
            addCriterion("ACT_BR_CD <=", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdLike(String value) {
            addCriterion("ACT_BR_CD like", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotLike(String value) {
            addCriterion("ACT_BR_CD not like", value, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdIn(List<String> values) {
            addCriterion("ACT_BR_CD in", values, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotIn(List<String> values) {
            addCriterion("ACT_BR_CD not in", values, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdBetween(String value1, String value2) {
            addCriterion("ACT_BR_CD between", value1, value2, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andActBrCdNotBetween(String value1, String value2) {
            addCriterion("ACT_BR_CD not between", value1, value2, "actBrCd");
            return (Criteria) this;
        }

        public Criteria andAppStatIsNull() {
            addCriterion("APP_STAT is null");
            return (Criteria) this;
        }

        public Criteria andAppStatIsNotNull() {
            addCriterion("APP_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andAppStatEqualTo(String value) {
            addCriterion("APP_STAT =", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatNotEqualTo(String value) {
            addCriterion("APP_STAT <>", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatGreaterThan(String value) {
            addCriterion("APP_STAT >", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatGreaterThanOrEqualTo(String value) {
            addCriterion("APP_STAT >=", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatLessThan(String value) {
            addCriterion("APP_STAT <", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatLessThanOrEqualTo(String value) {
            addCriterion("APP_STAT <=", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatLike(String value) {
            addCriterion("APP_STAT like", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatNotLike(String value) {
            addCriterion("APP_STAT not like", value, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatIn(List<String> values) {
            addCriterion("APP_STAT in", values, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatNotIn(List<String> values) {
            addCriterion("APP_STAT not in", values, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatBetween(String value1, String value2) {
            addCriterion("APP_STAT between", value1, value2, "appStat");
            return (Criteria) this;
        }

        public Criteria andAppStatNotBetween(String value1, String value2) {
            addCriterion("APP_STAT not between", value1, value2, "appStat");
            return (Criteria) this;
        }

        public Criteria andTlrNoIsNull() {
            addCriterion("TLR_NO is null");
            return (Criteria) this;
        }

        public Criteria andTlrNoIsNotNull() {
            addCriterion("TLR_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTlrNoEqualTo(String value) {
            addCriterion("TLR_NO =", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotEqualTo(String value) {
            addCriterion("TLR_NO <>", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoGreaterThan(String value) {
            addCriterion("TLR_NO >", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoGreaterThanOrEqualTo(String value) {
            addCriterion("TLR_NO >=", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLessThan(String value) {
            addCriterion("TLR_NO <", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLessThanOrEqualTo(String value) {
            addCriterion("TLR_NO <=", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLike(String value) {
            addCriterion("TLR_NO like", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotLike(String value) {
            addCriterion("TLR_NO not like", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoIn(List<String> values) {
            addCriterion("TLR_NO in", values, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotIn(List<String> values) {
            addCriterion("TLR_NO not in", values, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoBetween(String value1, String value2) {
            addCriterion("TLR_NO between", value1, value2, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotBetween(String value1, String value2) {
            addCriterion("TLR_NO not between", value1, value2, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNmIsNull() {
            addCriterion("TLR_NM is null");
            return (Criteria) this;
        }

        public Criteria andTlrNmIsNotNull() {
            addCriterion("TLR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andTlrNmEqualTo(String value) {
            addCriterion("TLR_NM =", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotEqualTo(String value) {
            addCriterion("TLR_NM <>", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmGreaterThan(String value) {
            addCriterion("TLR_NM >", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmGreaterThanOrEqualTo(String value) {
            addCriterion("TLR_NM >=", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLessThan(String value) {
            addCriterion("TLR_NM <", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLessThanOrEqualTo(String value) {
            addCriterion("TLR_NM <=", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLike(String value) {
            addCriterion("TLR_NM like", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotLike(String value) {
            addCriterion("TLR_NM not like", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmIn(List<String> values) {
            addCriterion("TLR_NM in", values, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotIn(List<String> values) {
            addCriterion("TLR_NM not in", values, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmBetween(String value1, String value2) {
            addCriterion("TLR_NM between", value1, value2, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotBetween(String value1, String value2) {
            addCriterion("TLR_NM not between", value1, value2, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andBrCdIsNull() {
            addCriterion("BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andBrCdIsNotNull() {
            addCriterion("BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andBrCdEqualTo(String value) {
            addCriterion("BR_CD =", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotEqualTo(String value) {
            addCriterion("BR_CD <>", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdGreaterThan(String value) {
            addCriterion("BR_CD >", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("BR_CD >=", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLessThan(String value) {
            addCriterion("BR_CD <", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLessThanOrEqualTo(String value) {
            addCriterion("BR_CD <=", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLike(String value) {
            addCriterion("BR_CD like", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotLike(String value) {
            addCriterion("BR_CD not like", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdIn(List<String> values) {
            addCriterion("BR_CD in", values, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotIn(List<String> values) {
            addCriterion("BR_CD not in", values, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdBetween(String value1, String value2) {
            addCriterion("BR_CD between", value1, value2, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotBetween(String value1, String value2) {
            addCriterion("BR_CD not between", value1, value2, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrNmIsNull() {
            addCriterion("BR_NM is null");
            return (Criteria) this;
        }

        public Criteria andBrNmIsNotNull() {
            addCriterion("BR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andBrNmEqualTo(String value) {
            addCriterion("BR_NM =", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotEqualTo(String value) {
            addCriterion("BR_NM <>", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmGreaterThan(String value) {
            addCriterion("BR_NM >", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmGreaterThanOrEqualTo(String value) {
            addCriterion("BR_NM >=", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLessThan(String value) {
            addCriterion("BR_NM <", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLessThanOrEqualTo(String value) {
            addCriterion("BR_NM <=", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLike(String value) {
            addCriterion("BR_NM like", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotLike(String value) {
            addCriterion("BR_NM not like", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmIn(List<String> values) {
            addCriterion("BR_NM in", values, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotIn(List<String> values) {
            addCriterion("BR_NM not in", values, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmBetween(String value1, String value2) {
            addCriterion("BR_NM between", value1, value2, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotBetween(String value1, String value2) {
            addCriterion("BR_NM not between", value1, value2, "brNm");
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

        public Criteria andLstUpdTlrIsNull() {
            addCriterion("LST_UPD_TLR is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrIsNotNull() {
            addCriterion("LST_UPD_TLR is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrEqualTo(String value) {
            addCriterion("LST_UPD_TLR =", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotEqualTo(String value) {
            addCriterion("LST_UPD_TLR <>", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrGreaterThan(String value) {
            addCriterion("LST_UPD_TLR >", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR >=", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrLessThan(String value) {
            addCriterion("LST_UPD_TLR <", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR <=", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrLike(String value) {
            addCriterion("LST_UPD_TLR like", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotLike(String value) {
            addCriterion("LST_UPD_TLR not like", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrIn(List<String> values) {
            addCriterion("LST_UPD_TLR in", values, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotIn(List<String> values) {
            addCriterion("LST_UPD_TLR not in", values, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR between", value1, value2, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR not between", value1, value2, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmIsNull() {
            addCriterion("LST_UPD_TLR_NM is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmIsNotNull() {
            addCriterion("LST_UPD_TLR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM =", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM <>", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmGreaterThan(String value) {
            addCriterion("LST_UPD_TLR_NM >", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM >=", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmLessThan(String value) {
            addCriterion("LST_UPD_TLR_NM <", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM <=", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmLike(String value) {
            addCriterion("LST_UPD_TLR_NM like", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotLike(String value) {
            addCriterion("LST_UPD_TLR_NM not like", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmIn(List<String> values) {
            addCriterion("LST_UPD_TLR_NM in", values, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotIn(List<String> values) {
            addCriterion("LST_UPD_TLR_NM not in", values, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR_NM between", value1, value2, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR_NM not between", value1, value2, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdIsNull() {
            addCriterion("LST_UPD_BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdIsNotNull() {
            addCriterion("LST_UPD_BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD =", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD <>", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdGreaterThan(String value) {
            addCriterion("LST_UPD_BR_CD >", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD >=", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdLessThan(String value) {
            addCriterion("LST_UPD_BR_CD <", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD <=", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdLike(String value) {
            addCriterion("LST_UPD_BR_CD like", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotLike(String value) {
            addCriterion("LST_UPD_BR_CD not like", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdIn(List<String> values) {
            addCriterion("LST_UPD_BR_CD in", values, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotIn(List<String> values) {
            addCriterion("LST_UPD_BR_CD not in", values, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_CD between", value1, value2, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_CD not between", value1, value2, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmIsNull() {
            addCriterion("LST_UPD_BR_NM is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmIsNotNull() {
            addCriterion("LST_UPD_BR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM =", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM <>", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmGreaterThan(String value) {
            addCriterion("LST_UPD_BR_NM >", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM >=", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmLessThan(String value) {
            addCriterion("LST_UPD_BR_NM <", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM <=", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmLike(String value) {
            addCriterion("LST_UPD_BR_NM like", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotLike(String value) {
            addCriterion("LST_UPD_BR_NM not like", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmIn(List<String> values) {
            addCriterion("LST_UPD_BR_NM in", values, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotIn(List<String> values) {
            addCriterion("LST_UPD_BR_NM not in", values, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_NM between", value1, value2, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_NM not between", value1, value2, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtIsNull() {
            addCriterion("LST_UPD_DT is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtIsNotNull() {
            addCriterion("LST_UPD_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtEqualTo(String value) {
            addCriterion("LST_UPD_DT =", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotEqualTo(String value) {
            addCriterion("LST_UPD_DT <>", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtGreaterThan(String value) {
            addCriterion("LST_UPD_DT >", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_DT >=", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtLessThan(String value) {
            addCriterion("LST_UPD_DT <", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_DT <=", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtLike(String value) {
            addCriterion("LST_UPD_DT like", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotLike(String value) {
            addCriterion("LST_UPD_DT not like", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtIn(List<String> values) {
            addCriterion("LST_UPD_DT in", values, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotIn(List<String> values) {
            addCriterion("LST_UPD_DT not in", values, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtBetween(String value1, String value2) {
            addCriterion("LST_UPD_DT between", value1, value2, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_DT not between", value1, value2, "lstUpdDt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}