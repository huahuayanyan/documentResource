package com.huateng.scf.bas.crm.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrmBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrmBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrmBaseInfoExample(BCrmBaseInfoExample example) {
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

        public Criteria andCustnoIsNull() {
            addCriterion("CUSTNO is null");
            return (Criteria) this;
        }

        public Criteria andCustnoIsNotNull() {
            addCriterion("CUSTNO is not null");
            return (Criteria) this;
        }

        public Criteria andCustnoEqualTo(String value) {
            addCriterion("CUSTNO =", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoNotEqualTo(String value) {
            addCriterion("CUSTNO <>", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoGreaterThan(String value) {
            addCriterion("CUSTNO >", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTNO >=", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoLessThan(String value) {
            addCriterion("CUSTNO <", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoLessThanOrEqualTo(String value) {
            addCriterion("CUSTNO <=", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoLike(String value) {
            addCriterion("CUSTNO like", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoNotLike(String value) {
            addCriterion("CUSTNO not like", value, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoIn(List<String> values) {
            addCriterion("CUSTNO in", values, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoNotIn(List<String> values) {
            addCriterion("CUSTNO not in", values, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoBetween(String value1, String value2) {
            addCriterion("CUSTNO between", value1, value2, "custno");
            return (Criteria) this;
        }

        public Criteria andCustnoNotBetween(String value1, String value2) {
            addCriterion("CUSTNO not between", value1, value2, "custno");
            return (Criteria) this;
        }

        public Criteria andCustTypeIsNull() {
            addCriterion("CUST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCustTypeIsNotNull() {
            addCriterion("CUST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCustTypeEqualTo(String value) {
            addCriterion("CUST_TYPE =", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotEqualTo(String value) {
            addCriterion("CUST_TYPE <>", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeGreaterThan(String value) {
            addCriterion("CUST_TYPE >", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_TYPE >=", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeLessThan(String value) {
            addCriterion("CUST_TYPE <", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeLessThanOrEqualTo(String value) {
            addCriterion("CUST_TYPE <=", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeLike(String value) {
            addCriterion("CUST_TYPE like", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotLike(String value) {
            addCriterion("CUST_TYPE not like", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeIn(List<String> values) {
            addCriterion("CUST_TYPE in", values, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotIn(List<String> values) {
            addCriterion("CUST_TYPE not in", values, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeBetween(String value1, String value2) {
            addCriterion("CUST_TYPE between", value1, value2, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotBetween(String value1, String value2) {
            addCriterion("CUST_TYPE not between", value1, value2, "custType");
            return (Criteria) this;
        }

        public Criteria andIdtypeIsNull() {
            addCriterion("IDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andIdtypeIsNotNull() {
            addCriterion("IDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIdtypeEqualTo(String value) {
            addCriterion("IDTYPE =", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotEqualTo(String value) {
            addCriterion("IDTYPE <>", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeGreaterThan(String value) {
            addCriterion("IDTYPE >", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeGreaterThanOrEqualTo(String value) {
            addCriterion("IDTYPE >=", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLessThan(String value) {
            addCriterion("IDTYPE <", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLessThanOrEqualTo(String value) {
            addCriterion("IDTYPE <=", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLike(String value) {
            addCriterion("IDTYPE like", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotLike(String value) {
            addCriterion("IDTYPE not like", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeIn(List<String> values) {
            addCriterion("IDTYPE in", values, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotIn(List<String> values) {
            addCriterion("IDTYPE not in", values, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeBetween(String value1, String value2) {
            addCriterion("IDTYPE between", value1, value2, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotBetween(String value1, String value2) {
            addCriterion("IDTYPE not between", value1, value2, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNull() {
            addCriterion("IDNO is null");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNotNull() {
            addCriterion("IDNO is not null");
            return (Criteria) this;
        }

        public Criteria andIdnoEqualTo(String value) {
            addCriterion("IDNO =", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotEqualTo(String value) {
            addCriterion("IDNO <>", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThan(String value) {
            addCriterion("IDNO >", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThanOrEqualTo(String value) {
            addCriterion("IDNO >=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThan(String value) {
            addCriterion("IDNO <", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThanOrEqualTo(String value) {
            addCriterion("IDNO <=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLike(String value) {
            addCriterion("IDNO like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotLike(String value) {
            addCriterion("IDNO not like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoIn(List<String> values) {
            addCriterion("IDNO in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotIn(List<String> values) {
            addCriterion("IDNO not in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoBetween(String value1, String value2) {
            addCriterion("IDNO between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotBetween(String value1, String value2) {
            addCriterion("IDNO not between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("CNAME =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("CNAME <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("CNAME >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("CNAME <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("CNAME <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("CNAME like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("CNAME not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("CNAME in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("CNAME not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("CNAME between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("CNAME not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andEnameIsNull() {
            addCriterion("ENAME is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("ENAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("ENAME =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("ENAME <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("ENAME >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ENAME >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("ENAME <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("ENAME <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("ENAME like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("ENAME not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("ENAME in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("ENAME not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("ENAME between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("ENAME not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNull() {
            addCriterion("ALIAS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNotNull() {
            addCriterion("ALIAS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAliasNameEqualTo(String value) {
            addCriterion("ALIAS_NAME =", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotEqualTo(String value) {
            addCriterion("ALIAS_NAME <>", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThan(String value) {
            addCriterion("ALIAS_NAME >", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThanOrEqualTo(String value) {
            addCriterion("ALIAS_NAME >=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThan(String value) {
            addCriterion("ALIAS_NAME <", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThanOrEqualTo(String value) {
            addCriterion("ALIAS_NAME <=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLike(String value) {
            addCriterion("ALIAS_NAME like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotLike(String value) {
            addCriterion("ALIAS_NAME not like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameIn(List<String> values) {
            addCriterion("ALIAS_NAME in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotIn(List<String> values) {
            addCriterion("ALIAS_NAME not in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameBetween(String value1, String value2) {
            addCriterion("ALIAS_NAME between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotBetween(String value1, String value2) {
            addCriterion("ALIAS_NAME not between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("ORG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("ORG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("ORG_CODE =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("ORG_CODE <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("ORG_CODE >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_CODE >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("ORG_CODE <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("ORG_CODE <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("ORG_CODE like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("ORG_CODE not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("ORG_CODE in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("ORG_CODE not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("ORG_CODE between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("ORG_CODE not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoIsNull() {
            addCriterion("SOC_CREDIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoIsNotNull() {
            addCriterion("SOC_CREDIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoEqualTo(String value) {
            addCriterion("SOC_CREDIT_NO =", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoNotEqualTo(String value) {
            addCriterion("SOC_CREDIT_NO <>", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoGreaterThan(String value) {
            addCriterion("SOC_CREDIT_NO >", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoGreaterThanOrEqualTo(String value) {
            addCriterion("SOC_CREDIT_NO >=", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoLessThan(String value) {
            addCriterion("SOC_CREDIT_NO <", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoLessThanOrEqualTo(String value) {
            addCriterion("SOC_CREDIT_NO <=", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoLike(String value) {
            addCriterion("SOC_CREDIT_NO like", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoNotLike(String value) {
            addCriterion("SOC_CREDIT_NO not like", value, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoIn(List<String> values) {
            addCriterion("SOC_CREDIT_NO in", values, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoNotIn(List<String> values) {
            addCriterion("SOC_CREDIT_NO not in", values, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoBetween(String value1, String value2) {
            addCriterion("SOC_CREDIT_NO between", value1, value2, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andSocCreditNoNotBetween(String value1, String value2) {
            addCriterion("SOC_CREDIT_NO not between", value1, value2, "socCreditNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("LICENSE_NO is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("LICENSE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("LICENSE_NO =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("LICENSE_NO <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("LICENSE_NO >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("LICENSE_NO >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("LICENSE_NO <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("LICENSE_NO <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("LICENSE_NO like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("LICENSE_NO not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("LICENSE_NO in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("LICENSE_NO not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("LICENSE_NO between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("LICENSE_NO not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseDateIsNull() {
            addCriterion("LICENSE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLicenseDateIsNotNull() {
            addCriterion("LICENSE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseDateEqualTo(String value) {
            addCriterion("LICENSE_DATE =", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateNotEqualTo(String value) {
            addCriterion("LICENSE_DATE <>", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateGreaterThan(String value) {
            addCriterion("LICENSE_DATE >", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateGreaterThanOrEqualTo(String value) {
            addCriterion("LICENSE_DATE >=", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateLessThan(String value) {
            addCriterion("LICENSE_DATE <", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateLessThanOrEqualTo(String value) {
            addCriterion("LICENSE_DATE <=", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateLike(String value) {
            addCriterion("LICENSE_DATE like", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateNotLike(String value) {
            addCriterion("LICENSE_DATE not like", value, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateIn(List<String> values) {
            addCriterion("LICENSE_DATE in", values, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateNotIn(List<String> values) {
            addCriterion("LICENSE_DATE not in", values, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateBetween(String value1, String value2) {
            addCriterion("LICENSE_DATE between", value1, value2, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andLicenseDateNotBetween(String value1, String value2) {
            addCriterion("LICENSE_DATE not between", value1, value2, "licenseDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(String value) {
            addCriterion("OPEN_DATE =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(String value) {
            addCriterion("OPEN_DATE <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(String value) {
            addCriterion("OPEN_DATE >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_DATE >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(String value) {
            addCriterion("OPEN_DATE <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(String value) {
            addCriterion("OPEN_DATE <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLike(String value) {
            addCriterion("OPEN_DATE like", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotLike(String value) {
            addCriterion("OPEN_DATE not like", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<String> values) {
            addCriterion("OPEN_DATE in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<String> values) {
            addCriterion("OPEN_DATE not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(String value1, String value2) {
            addCriterion("OPEN_DATE between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(String value1, String value2) {
            addCriterion("OPEN_DATE not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateIsNull() {
            addCriterion("CORE_OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateIsNotNull() {
            addCriterion("CORE_OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateEqualTo(String value) {
            addCriterion("CORE_OPEN_DATE =", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateNotEqualTo(String value) {
            addCriterion("CORE_OPEN_DATE <>", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateGreaterThan(String value) {
            addCriterion("CORE_OPEN_DATE >", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_OPEN_DATE >=", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateLessThan(String value) {
            addCriterion("CORE_OPEN_DATE <", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateLessThanOrEqualTo(String value) {
            addCriterion("CORE_OPEN_DATE <=", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateLike(String value) {
            addCriterion("CORE_OPEN_DATE like", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateNotLike(String value) {
            addCriterion("CORE_OPEN_DATE not like", value, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateIn(List<String> values) {
            addCriterion("CORE_OPEN_DATE in", values, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateNotIn(List<String> values) {
            addCriterion("CORE_OPEN_DATE not in", values, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateBetween(String value1, String value2) {
            addCriterion("CORE_OPEN_DATE between", value1, value2, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCoreOpenDateNotBetween(String value1, String value2) {
            addCriterion("CORE_OPEN_DATE not between", value1, value2, "coreOpenDate");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNull() {
            addCriterion("CUST_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNotNull() {
            addCriterion("CUST_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCustStatusEqualTo(String value) {
            addCriterion("CUST_STATUS =", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotEqualTo(String value) {
            addCriterion("CUST_STATUS <>", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThan(String value) {
            addCriterion("CUST_STATUS >", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_STATUS >=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThan(String value) {
            addCriterion("CUST_STATUS <", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThanOrEqualTo(String value) {
            addCriterion("CUST_STATUS <=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLike(String value) {
            addCriterion("CUST_STATUS like", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotLike(String value) {
            addCriterion("CUST_STATUS not like", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusIn(List<String> values) {
            addCriterion("CUST_STATUS in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotIn(List<String> values) {
            addCriterion("CUST_STATUS not in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusBetween(String value1, String value2) {
            addCriterion("CUST_STATUS between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotBetween(String value1, String value2) {
            addCriterion("CUST_STATUS not between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andMgrnoIsNull() {
            addCriterion("MGRNO is null");
            return (Criteria) this;
        }

        public Criteria andMgrnoIsNotNull() {
            addCriterion("MGRNO is not null");
            return (Criteria) this;
        }

        public Criteria andMgrnoEqualTo(String value) {
            addCriterion("MGRNO =", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotEqualTo(String value) {
            addCriterion("MGRNO <>", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoGreaterThan(String value) {
            addCriterion("MGRNO >", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoGreaterThanOrEqualTo(String value) {
            addCriterion("MGRNO >=", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLessThan(String value) {
            addCriterion("MGRNO <", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLessThanOrEqualTo(String value) {
            addCriterion("MGRNO <=", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLike(String value) {
            addCriterion("MGRNO like", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotLike(String value) {
            addCriterion("MGRNO not like", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoIn(List<String> values) {
            addCriterion("MGRNO in", values, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotIn(List<String> values) {
            addCriterion("MGRNO not in", values, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoBetween(String value1, String value2) {
            addCriterion("MGRNO between", value1, value2, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotBetween(String value1, String value2) {
            addCriterion("MGRNO not between", value1, value2, "mgrno");
            return (Criteria) this;
        }

        public Criteria andCoreFlagIsNull() {
            addCriterion("CORE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCoreFlagIsNotNull() {
            addCriterion("CORE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCoreFlagEqualTo(String value) {
            addCriterion("CORE_FLAG =", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotEqualTo(String value) {
            addCriterion("CORE_FLAG <>", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagGreaterThan(String value) {
            addCriterion("CORE_FLAG >", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_FLAG >=", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagLessThan(String value) {
            addCriterion("CORE_FLAG <", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagLessThanOrEqualTo(String value) {
            addCriterion("CORE_FLAG <=", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagLike(String value) {
            addCriterion("CORE_FLAG like", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotLike(String value) {
            addCriterion("CORE_FLAG not like", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagIn(List<String> values) {
            addCriterion("CORE_FLAG in", values, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotIn(List<String> values) {
            addCriterion("CORE_FLAG not in", values, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagBetween(String value1, String value2) {
            addCriterion("CORE_FLAG between", value1, value2, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotBetween(String value1, String value2) {
            addCriterion("CORE_FLAG not between", value1, value2, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagIsNull() {
            addCriterion("MONI_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andMoniFlagIsNotNull() {
            addCriterion("MONI_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andMoniFlagEqualTo(String value) {
            addCriterion("MONI_FLAG =", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotEqualTo(String value) {
            addCriterion("MONI_FLAG <>", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagGreaterThan(String value) {
            addCriterion("MONI_FLAG >", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_FLAG >=", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagLessThan(String value) {
            addCriterion("MONI_FLAG <", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagLessThanOrEqualTo(String value) {
            addCriterion("MONI_FLAG <=", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagLike(String value) {
            addCriterion("MONI_FLAG like", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotLike(String value) {
            addCriterion("MONI_FLAG not like", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagIn(List<String> values) {
            addCriterion("MONI_FLAG in", values, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotIn(List<String> values) {
            addCriterion("MONI_FLAG not in", values, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagBetween(String value1, String value2) {
            addCriterion("MONI_FLAG between", value1, value2, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotBetween(String value1, String value2) {
            addCriterion("MONI_FLAG not between", value1, value2, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagIsNull() {
            addCriterion("FUTURES_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagIsNotNull() {
            addCriterion("FUTURES_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagEqualTo(String value) {
            addCriterion("FUTURES_FLAG =", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotEqualTo(String value) {
            addCriterion("FUTURES_FLAG <>", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagGreaterThan(String value) {
            addCriterion("FUTURES_FLAG >", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FUTURES_FLAG >=", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagLessThan(String value) {
            addCriterion("FUTURES_FLAG <", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagLessThanOrEqualTo(String value) {
            addCriterion("FUTURES_FLAG <=", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagLike(String value) {
            addCriterion("FUTURES_FLAG like", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotLike(String value) {
            addCriterion("FUTURES_FLAG not like", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagIn(List<String> values) {
            addCriterion("FUTURES_FLAG in", values, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotIn(List<String> values) {
            addCriterion("FUTURES_FLAG not in", values, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagBetween(String value1, String value2) {
            addCriterion("FUTURES_FLAG between", value1, value2, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotBetween(String value1, String value2) {
            addCriterion("FUTURES_FLAG not between", value1, value2, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagIsNull() {
            addCriterion("FLC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlcFlagIsNotNull() {
            addCriterion("FLC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlcFlagEqualTo(String value) {
            addCriterion("FLC_FLAG =", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotEqualTo(String value) {
            addCriterion("FLC_FLAG <>", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagGreaterThan(String value) {
            addCriterion("FLC_FLAG >", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLC_FLAG >=", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagLessThan(String value) {
            addCriterion("FLC_FLAG <", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagLessThanOrEqualTo(String value) {
            addCriterion("FLC_FLAG <=", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagLike(String value) {
            addCriterion("FLC_FLAG like", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotLike(String value) {
            addCriterion("FLC_FLAG not like", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagIn(List<String> values) {
            addCriterion("FLC_FLAG in", values, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotIn(List<String> values) {
            addCriterion("FLC_FLAG not in", values, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagBetween(String value1, String value2) {
            addCriterion("FLC_FLAG between", value1, value2, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotBetween(String value1, String value2) {
            addCriterion("FLC_FLAG not between", value1, value2, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIsNull() {
            addCriterion("CREDIT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIsNotNull() {
            addCriterion("CREDIT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCreditFlagEqualTo(String value) {
            addCriterion("CREDIT_FLAG =", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotEqualTo(String value) {
            addCriterion("CREDIT_FLAG <>", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagGreaterThan(String value) {
            addCriterion("CREDIT_FLAG >", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_FLAG >=", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLessThan(String value) {
            addCriterion("CREDIT_FLAG <", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_FLAG <=", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLike(String value) {
            addCriterion("CREDIT_FLAG like", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotLike(String value) {
            addCriterion("CREDIT_FLAG not like", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIn(List<String> values) {
            addCriterion("CREDIT_FLAG in", values, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotIn(List<String> values) {
            addCriterion("CREDIT_FLAG not in", values, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagBetween(String value1, String value2) {
            addCriterion("CREDIT_FLAG between", value1, value2, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotBetween(String value1, String value2) {
            addCriterion("CREDIT_FLAG not between", value1, value2, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagIsNull() {
            addCriterion("BLACK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBlackFlagIsNotNull() {
            addCriterion("BLACK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBlackFlagEqualTo(String value) {
            addCriterion("BLACK_FLAG =", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotEqualTo(String value) {
            addCriterion("BLACK_FLAG <>", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagGreaterThan(String value) {
            addCriterion("BLACK_FLAG >", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BLACK_FLAG >=", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagLessThan(String value) {
            addCriterion("BLACK_FLAG <", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagLessThanOrEqualTo(String value) {
            addCriterion("BLACK_FLAG <=", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagLike(String value) {
            addCriterion("BLACK_FLAG like", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotLike(String value) {
            addCriterion("BLACK_FLAG not like", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagIn(List<String> values) {
            addCriterion("BLACK_FLAG in", values, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotIn(List<String> values) {
            addCriterion("BLACK_FLAG not in", values, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagBetween(String value1, String value2) {
            addCriterion("BLACK_FLAG between", value1, value2, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotBetween(String value1, String value2) {
            addCriterion("BLACK_FLAG not between", value1, value2, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagIsNull() {
            addCriterion("INSURE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andInsureFlagIsNotNull() {
            addCriterion("INSURE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInsureFlagEqualTo(String value) {
            addCriterion("INSURE_FLAG =", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotEqualTo(String value) {
            addCriterion("INSURE_FLAG <>", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagGreaterThan(String value) {
            addCriterion("INSURE_FLAG >", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagGreaterThanOrEqualTo(String value) {
            addCriterion("INSURE_FLAG >=", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagLessThan(String value) {
            addCriterion("INSURE_FLAG <", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagLessThanOrEqualTo(String value) {
            addCriterion("INSURE_FLAG <=", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagLike(String value) {
            addCriterion("INSURE_FLAG like", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotLike(String value) {
            addCriterion("INSURE_FLAG not like", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagIn(List<String> values) {
            addCriterion("INSURE_FLAG in", values, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotIn(List<String> values) {
            addCriterion("INSURE_FLAG not in", values, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagBetween(String value1, String value2) {
            addCriterion("INSURE_FLAG between", value1, value2, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotBetween(String value1, String value2) {
            addCriterion("INSURE_FLAG not between", value1, value2, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagIsNull() {
            addCriterion("FACTOR_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFactorFlagIsNotNull() {
            addCriterion("FACTOR_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFactorFlagEqualTo(String value) {
            addCriterion("FACTOR_FLAG =", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotEqualTo(String value) {
            addCriterion("FACTOR_FLAG <>", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagGreaterThan(String value) {
            addCriterion("FACTOR_FLAG >", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FACTOR_FLAG >=", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagLessThan(String value) {
            addCriterion("FACTOR_FLAG <", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagLessThanOrEqualTo(String value) {
            addCriterion("FACTOR_FLAG <=", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagLike(String value) {
            addCriterion("FACTOR_FLAG like", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotLike(String value) {
            addCriterion("FACTOR_FLAG not like", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagIn(List<String> values) {
            addCriterion("FACTOR_FLAG in", values, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotIn(List<String> values) {
            addCriterion("FACTOR_FLAG not in", values, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagBetween(String value1, String value2) {
            addCriterion("FACTOR_FLAG between", value1, value2, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotBetween(String value1, String value2) {
            addCriterion("FACTOR_FLAG not between", value1, value2, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdIsNull() {
            addCriterion("CCMS_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdIsNotNull() {
            addCriterion("CCMS_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdEqualTo(String value) {
            addCriterion("CCMS_CUSTCD =", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotEqualTo(String value) {
            addCriterion("CCMS_CUSTCD <>", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdGreaterThan(String value) {
            addCriterion("CCMS_CUSTCD >", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CCMS_CUSTCD >=", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdLessThan(String value) {
            addCriterion("CCMS_CUSTCD <", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdLessThanOrEqualTo(String value) {
            addCriterion("CCMS_CUSTCD <=", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdLike(String value) {
            addCriterion("CCMS_CUSTCD like", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotLike(String value) {
            addCriterion("CCMS_CUSTCD not like", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdIn(List<String> values) {
            addCriterion("CCMS_CUSTCD in", values, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotIn(List<String> values) {
            addCriterion("CCMS_CUSTCD not in", values, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdBetween(String value1, String value2) {
            addCriterion("CCMS_CUSTCD between", value1, value2, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotBetween(String value1, String value2) {
            addCriterion("CCMS_CUSTCD not between", value1, value2, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andImportantFlagIsNull() {
            addCriterion("IMPORTANT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andImportantFlagIsNotNull() {
            addCriterion("IMPORTANT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andImportantFlagEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG =", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG <>", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagGreaterThan(String value) {
            addCriterion("IMPORTANT_FLAG >", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagGreaterThanOrEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG >=", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagLessThan(String value) {
            addCriterion("IMPORTANT_FLAG <", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagLessThanOrEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG <=", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagLike(String value) {
            addCriterion("IMPORTANT_FLAG like", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotLike(String value) {
            addCriterion("IMPORTANT_FLAG not like", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagIn(List<String> values) {
            addCriterion("IMPORTANT_FLAG in", values, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotIn(List<String> values) {
            addCriterion("IMPORTANT_FLAG not in", values, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagBetween(String value1, String value2) {
            addCriterion("IMPORTANT_FLAG between", value1, value2, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotBetween(String value1, String value2) {
            addCriterion("IMPORTANT_FLAG not between", value1, value2, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgIsNull() {
            addCriterion("COMMERCIAL_FALG is null");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgIsNotNull() {
            addCriterion("COMMERCIAL_FALG is not null");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG =", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG <>", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgGreaterThan(String value) {
            addCriterion("COMMERCIAL_FALG >", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgGreaterThanOrEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG >=", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgLessThan(String value) {
            addCriterion("COMMERCIAL_FALG <", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgLessThanOrEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG <=", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgLike(String value) {
            addCriterion("COMMERCIAL_FALG like", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotLike(String value) {
            addCriterion("COMMERCIAL_FALG not like", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgIn(List<String> values) {
            addCriterion("COMMERCIAL_FALG in", values, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotIn(List<String> values) {
            addCriterion("COMMERCIAL_FALG not in", values, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgBetween(String value1, String value2) {
            addCriterion("COMMERCIAL_FALG between", value1, value2, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotBetween(String value1, String value2) {
            addCriterion("COMMERCIAL_FALG not between", value1, value2, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagIsNull() {
            addCriterion("OVERSEAS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagIsNotNull() {
            addCriterion("OVERSEAS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG =", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG <>", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagGreaterThan(String value) {
            addCriterion("OVERSEAS_FLAG >", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagGreaterThanOrEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG >=", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagLessThan(String value) {
            addCriterion("OVERSEAS_FLAG <", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagLessThanOrEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG <=", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagLike(String value) {
            addCriterion("OVERSEAS_FLAG like", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotLike(String value) {
            addCriterion("OVERSEAS_FLAG not like", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagIn(List<String> values) {
            addCriterion("OVERSEAS_FLAG in", values, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotIn(List<String> values) {
            addCriterion("OVERSEAS_FLAG not in", values, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagBetween(String value1, String value2) {
            addCriterion("OVERSEAS_FLAG between", value1, value2, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotBetween(String value1, String value2) {
            addCriterion("OVERSEAS_FLAG not between", value1, value2, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagIsNull() {
            addCriterion("BANKS_CUST_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagIsNotNull() {
            addCriterion("BANKS_CUST_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG =", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG <>", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagGreaterThan(String value) {
            addCriterion("BANKS_CUST_FLAG >", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG >=", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagLessThan(String value) {
            addCriterion("BANKS_CUST_FLAG <", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagLessThanOrEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG <=", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagLike(String value) {
            addCriterion("BANKS_CUST_FLAG like", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotLike(String value) {
            addCriterion("BANKS_CUST_FLAG not like", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagIn(List<String> values) {
            addCriterion("BANKS_CUST_FLAG in", values, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotIn(List<String> values) {
            addCriterion("BANKS_CUST_FLAG not in", values, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagBetween(String value1, String value2) {
            addCriterion("BANKS_CUST_FLAG between", value1, value2, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotBetween(String value1, String value2) {
            addCriterion("BANKS_CUST_FLAG not between", value1, value2, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagIsNull() {
            addCriterion("EF_BUYER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagIsNotNull() {
            addCriterion("EF_BUYER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG =", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG <>", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagGreaterThan(String value) {
            addCriterion("EF_BUYER_FLAG >", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagGreaterThanOrEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG >=", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagLessThan(String value) {
            addCriterion("EF_BUYER_FLAG <", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagLessThanOrEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG <=", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagLike(String value) {
            addCriterion("EF_BUYER_FLAG like", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotLike(String value) {
            addCriterion("EF_BUYER_FLAG not like", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagIn(List<String> values) {
            addCriterion("EF_BUYER_FLAG in", values, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotIn(List<String> values) {
            addCriterion("EF_BUYER_FLAG not in", values, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagBetween(String value1, String value2) {
            addCriterion("EF_BUYER_FLAG between", value1, value2, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotBetween(String value1, String value2) {
            addCriterion("EF_BUYER_FLAG not between", value1, value2, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagIsNull() {
            addCriterion("IF_SELLER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagIsNotNull() {
            addCriterion("IF_SELLER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG =", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG <>", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagGreaterThan(String value) {
            addCriterion("IF_SELLER_FLAG >", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagGreaterThanOrEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG >=", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagLessThan(String value) {
            addCriterion("IF_SELLER_FLAG <", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagLessThanOrEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG <=", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagLike(String value) {
            addCriterion("IF_SELLER_FLAG like", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotLike(String value) {
            addCriterion("IF_SELLER_FLAG not like", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagIn(List<String> values) {
            addCriterion("IF_SELLER_FLAG in", values, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotIn(List<String> values) {
            addCriterion("IF_SELLER_FLAG not in", values, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagBetween(String value1, String value2) {
            addCriterion("IF_SELLER_FLAG between", value1, value2, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotBetween(String value1, String value2) {
            addCriterion("IF_SELLER_FLAG not between", value1, value2, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIsBankIsNull() {
            addCriterion("IS_BANK is null");
            return (Criteria) this;
        }

        public Criteria andIsBankIsNotNull() {
            addCriterion("IS_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andIsBankEqualTo(String value) {
            addCriterion("IS_BANK =", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotEqualTo(String value) {
            addCriterion("IS_BANK <>", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankGreaterThan(String value) {
            addCriterion("IS_BANK >", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BANK >=", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankLessThan(String value) {
            addCriterion("IS_BANK <", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankLessThanOrEqualTo(String value) {
            addCriterion("IS_BANK <=", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankLike(String value) {
            addCriterion("IS_BANK like", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotLike(String value) {
            addCriterion("IS_BANK not like", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankIn(List<String> values) {
            addCriterion("IS_BANK in", values, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotIn(List<String> values) {
            addCriterion("IS_BANK not in", values, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankBetween(String value1, String value2) {
            addCriterion("IS_BANK between", value1, value2, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotBetween(String value1, String value2) {
            addCriterion("IS_BANK not between", value1, value2, "isBank");
            return (Criteria) this;
        }

        public Criteria andFciCodeIsNull() {
            addCriterion("FCI_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFciCodeIsNotNull() {
            addCriterion("FCI_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFciCodeEqualTo(String value) {
            addCriterion("FCI_CODE =", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotEqualTo(String value) {
            addCriterion("FCI_CODE <>", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeGreaterThan(String value) {
            addCriterion("FCI_CODE >", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FCI_CODE >=", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeLessThan(String value) {
            addCriterion("FCI_CODE <", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeLessThanOrEqualTo(String value) {
            addCriterion("FCI_CODE <=", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeLike(String value) {
            addCriterion("FCI_CODE like", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotLike(String value) {
            addCriterion("FCI_CODE not like", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeIn(List<String> values) {
            addCriterion("FCI_CODE in", values, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotIn(List<String> values) {
            addCriterion("FCI_CODE not in", values, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeBetween(String value1, String value2) {
            addCriterion("FCI_CODE between", value1, value2, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotBetween(String value1, String value2) {
            addCriterion("FCI_CODE not between", value1, value2, "fciCode");
            return (Criteria) this;
        }

        public Criteria andIsIntlIsNull() {
            addCriterion("IS_INTL is null");
            return (Criteria) this;
        }

        public Criteria andIsIntlIsNotNull() {
            addCriterion("IS_INTL is not null");
            return (Criteria) this;
        }

        public Criteria andIsIntlEqualTo(String value) {
            addCriterion("IS_INTL =", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotEqualTo(String value) {
            addCriterion("IS_INTL <>", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlGreaterThan(String value) {
            addCriterion("IS_INTL >", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlGreaterThanOrEqualTo(String value) {
            addCriterion("IS_INTL >=", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlLessThan(String value) {
            addCriterion("IS_INTL <", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlLessThanOrEqualTo(String value) {
            addCriterion("IS_INTL <=", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlLike(String value) {
            addCriterion("IS_INTL like", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotLike(String value) {
            addCriterion("IS_INTL not like", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlIn(List<String> values) {
            addCriterion("IS_INTL in", values, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotIn(List<String> values) {
            addCriterion("IS_INTL not in", values, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlBetween(String value1, String value2) {
            addCriterion("IS_INTL between", value1, value2, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotBetween(String value1, String value2) {
            addCriterion("IS_INTL not between", value1, value2, "isIntl");
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