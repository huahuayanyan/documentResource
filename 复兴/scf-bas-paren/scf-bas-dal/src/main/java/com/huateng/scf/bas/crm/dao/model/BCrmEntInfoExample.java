package com.huateng.scf.bas.crm.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrmEntInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrmEntInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrmEntInfoExample(BCrmEntInfoExample example) {
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

        public Criteria andLegalIsNull() {
            addCriterion("LEGAL is null");
            return (Criteria) this;
        }

        public Criteria andLegalIsNotNull() {
            addCriterion("LEGAL is not null");
            return (Criteria) this;
        }

        public Criteria andLegalEqualTo(String value) {
            addCriterion("LEGAL =", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotEqualTo(String value) {
            addCriterion("LEGAL <>", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalGreaterThan(String value) {
            addCriterion("LEGAL >", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL >=", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalLessThan(String value) {
            addCriterion("LEGAL <", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalLessThanOrEqualTo(String value) {
            addCriterion("LEGAL <=", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalLike(String value) {
            addCriterion("LEGAL like", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotLike(String value) {
            addCriterion("LEGAL not like", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalIn(List<String> values) {
            addCriterion("LEGAL in", values, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotIn(List<String> values) {
            addCriterion("LEGAL not in", values, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalBetween(String value1, String value2) {
            addCriterion("LEGAL between", value1, value2, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotBetween(String value1, String value2) {
            addCriterion("LEGAL not between", value1, value2, "legal");
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

        public Criteria andEnterpriseTypeIsNull() {
            addCriterion("ENTERPRISE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNotNull() {
            addCriterion("ENTERPRISE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE =", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE <>", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThan(String value) {
            addCriterion("ENTERPRISE_TYPE >", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE >=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThan(String value) {
            addCriterion("ENTERPRISE_TYPE <", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE <=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLike(String value) {
            addCriterion("ENTERPRISE_TYPE like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotLike(String value) {
            addCriterion("ENTERPRISE_TYPE not like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIn(List<String> values) {
            addCriterion("ENTERPRISE_TYPE in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotIn(List<String> values) {
            addCriterion("ENTERPRISE_TYPE not in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_TYPE between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_TYPE not between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNull() {
            addCriterion("INDUSTRY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNotNull() {
            addCriterion("INDUSTRY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE =", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE <>", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThan(String value) {
            addCriterion("INDUSTRY_TYPE >", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE >=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThan(String value) {
            addCriterion("INDUSTRY_TYPE <", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE <=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLike(String value) {
            addCriterion("INDUSTRY_TYPE like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotLike(String value) {
            addCriterion("INDUSTRY_TYPE not like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE not in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE not between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeIsNull() {
            addCriterion("ENTERPRISE_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeIsNotNull() {
            addCriterion("ENTERPRISE_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE =", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE <>", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeGreaterThan(String value) {
            addCriterion("ENTERPRISE_SCOPE >", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE >=", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeLessThan(String value) {
            addCriterion("ENTERPRISE_SCOPE <", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE <=", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeLike(String value) {
            addCriterion("ENTERPRISE_SCOPE like", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotLike(String value) {
            addCriterion("ENTERPRISE_SCOPE not like", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeIn(List<String> values) {
            addCriterion("ENTERPRISE_SCOPE in", values, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotIn(List<String> values) {
            addCriterion("ENTERPRISE_SCOPE not in", values, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_SCOPE between", value1, value2, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_SCOPE not between", value1, value2, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andMainBussinessIsNull() {
            addCriterion("MAIN_BUSSINESS is null");
            return (Criteria) this;
        }

        public Criteria andMainBussinessIsNotNull() {
            addCriterion("MAIN_BUSSINESS is not null");
            return (Criteria) this;
        }

        public Criteria andMainBussinessEqualTo(String value) {
            addCriterion("MAIN_BUSSINESS =", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessNotEqualTo(String value) {
            addCriterion("MAIN_BUSSINESS <>", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessGreaterThan(String value) {
            addCriterion("MAIN_BUSSINESS >", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessGreaterThanOrEqualTo(String value) {
            addCriterion("MAIN_BUSSINESS >=", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessLessThan(String value) {
            addCriterion("MAIN_BUSSINESS <", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessLessThanOrEqualTo(String value) {
            addCriterion("MAIN_BUSSINESS <=", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessLike(String value) {
            addCriterion("MAIN_BUSSINESS like", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessNotLike(String value) {
            addCriterion("MAIN_BUSSINESS not like", value, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessIn(List<String> values) {
            addCriterion("MAIN_BUSSINESS in", values, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessNotIn(List<String> values) {
            addCriterion("MAIN_BUSSINESS not in", values, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessBetween(String value1, String value2) {
            addCriterion("MAIN_BUSSINESS between", value1, value2, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andMainBussinessNotBetween(String value1, String value2) {
            addCriterion("MAIN_BUSSINESS not between", value1, value2, "mainBussiness");
            return (Criteria) this;
        }

        public Criteria andContactAddrIsNull() {
            addCriterion("CONTACT_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andContactAddrIsNotNull() {
            addCriterion("CONTACT_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andContactAddrEqualTo(String value) {
            addCriterion("CONTACT_ADDR =", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotEqualTo(String value) {
            addCriterion("CONTACT_ADDR <>", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrGreaterThan(String value) {
            addCriterion("CONTACT_ADDR >", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_ADDR >=", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrLessThan(String value) {
            addCriterion("CONTACT_ADDR <", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_ADDR <=", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrLike(String value) {
            addCriterion("CONTACT_ADDR like", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotLike(String value) {
            addCriterion("CONTACT_ADDR not like", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrIn(List<String> values) {
            addCriterion("CONTACT_ADDR in", values, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotIn(List<String> values) {
            addCriterion("CONTACT_ADDR not in", values, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrBetween(String value1, String value2) {
            addCriterion("CONTACT_ADDR between", value1, value2, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotBetween(String value1, String value2) {
            addCriterion("CONTACT_ADDR not between", value1, value2, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNull() {
            addCriterion("REG_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNotNull() {
            addCriterion("REG_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andRegAddrEqualTo(String value) {
            addCriterion("REG_ADDR =", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotEqualTo(String value) {
            addCriterion("REG_ADDR <>", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThan(String value) {
            addCriterion("REG_ADDR >", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThanOrEqualTo(String value) {
            addCriterion("REG_ADDR >=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThan(String value) {
            addCriterion("REG_ADDR <", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThanOrEqualTo(String value) {
            addCriterion("REG_ADDR <=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLike(String value) {
            addCriterion("REG_ADDR like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotLike(String value) {
            addCriterion("REG_ADDR not like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIn(List<String> values) {
            addCriterion("REG_ADDR in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotIn(List<String> values) {
            addCriterion("REG_ADDR not in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrBetween(String value1, String value2) {
            addCriterion("REG_ADDR between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotBetween(String value1, String value2) {
            addCriterion("REG_ADDR not between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("POST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("POST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("POST_CODE =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("POST_CODE <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("POST_CODE >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POST_CODE >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("POST_CODE <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("POST_CODE <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("POST_CODE like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("POST_CODE not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("POST_CODE in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("POST_CODE not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("POST_CODE between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("POST_CODE not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("CONTACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("CONTACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("CONTACT_NAME =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("CONTACT_NAME <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("CONTACT_NAME >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("CONTACT_NAME <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("CONTACT_NAME like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("CONTACT_NAME not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("CONTACT_NAME in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("CONTACT_NAME not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("CONTACT_TEL is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("CONTACT_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("CONTACT_TEL =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("CONTACT_TEL <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("CONTACT_TEL >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("CONTACT_TEL <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("CONTACT_TEL like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("CONTACT_TEL not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("CONTACT_TEL in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("CONTACT_TEL not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL not between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andCreditLevelIsNull() {
            addCriterion("CREDIT_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCreditLevelIsNotNull() {
            addCriterion("CREDIT_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLevelEqualTo(String value) {
            addCriterion("CREDIT_LEVEL =", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelNotEqualTo(String value) {
            addCriterion("CREDIT_LEVEL <>", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelGreaterThan(String value) {
            addCriterion("CREDIT_LEVEL >", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_LEVEL >=", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelLessThan(String value) {
            addCriterion("CREDIT_LEVEL <", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_LEVEL <=", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelLike(String value) {
            addCriterion("CREDIT_LEVEL like", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelNotLike(String value) {
            addCriterion("CREDIT_LEVEL not like", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelIn(List<String> values) {
            addCriterion("CREDIT_LEVEL in", values, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelNotIn(List<String> values) {
            addCriterion("CREDIT_LEVEL not in", values, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelBetween(String value1, String value2) {
            addCriterion("CREDIT_LEVEL between", value1, value2, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelNotBetween(String value1, String value2) {
            addCriterion("CREDIT_LEVEL not between", value1, value2, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateIsNull() {
            addCriterion("EVALUATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateIsNotNull() {
            addCriterion("EVALUATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateEqualTo(String value) {
            addCriterion("EVALUATE_DATE =", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateNotEqualTo(String value) {
            addCriterion("EVALUATE_DATE <>", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateGreaterThan(String value) {
            addCriterion("EVALUATE_DATE >", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATE_DATE >=", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateLessThan(String value) {
            addCriterion("EVALUATE_DATE <", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateLessThanOrEqualTo(String value) {
            addCriterion("EVALUATE_DATE <=", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateLike(String value) {
            addCriterion("EVALUATE_DATE like", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateNotLike(String value) {
            addCriterion("EVALUATE_DATE not like", value, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateIn(List<String> values) {
            addCriterion("EVALUATE_DATE in", values, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateNotIn(List<String> values) {
            addCriterion("EVALUATE_DATE not in", values, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateBetween(String value1, String value2) {
            addCriterion("EVALUATE_DATE between", value1, value2, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateDateNotBetween(String value1, String value2) {
            addCriterion("EVALUATE_DATE not between", value1, value2, "evaluateDate");
            return (Criteria) this;
        }

        public Criteria andBaseActBankIsNull() {
            addCriterion("BASE_ACT_BANK is null");
            return (Criteria) this;
        }

        public Criteria andBaseActBankIsNotNull() {
            addCriterion("BASE_ACT_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andBaseActBankEqualTo(String value) {
            addCriterion("BASE_ACT_BANK =", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankNotEqualTo(String value) {
            addCriterion("BASE_ACT_BANK <>", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankGreaterThan(String value) {
            addCriterion("BASE_ACT_BANK >", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankGreaterThanOrEqualTo(String value) {
            addCriterion("BASE_ACT_BANK >=", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankLessThan(String value) {
            addCriterion("BASE_ACT_BANK <", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankLessThanOrEqualTo(String value) {
            addCriterion("BASE_ACT_BANK <=", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankLike(String value) {
            addCriterion("BASE_ACT_BANK like", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankNotLike(String value) {
            addCriterion("BASE_ACT_BANK not like", value, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankIn(List<String> values) {
            addCriterion("BASE_ACT_BANK in", values, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankNotIn(List<String> values) {
            addCriterion("BASE_ACT_BANK not in", values, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankBetween(String value1, String value2) {
            addCriterion("BASE_ACT_BANK between", value1, value2, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActBankNotBetween(String value1, String value2) {
            addCriterion("BASE_ACT_BANK not between", value1, value2, "baseActBank");
            return (Criteria) this;
        }

        public Criteria andBaseActnoIsNull() {
            addCriterion("BASE_ACTNO is null");
            return (Criteria) this;
        }

        public Criteria andBaseActnoIsNotNull() {
            addCriterion("BASE_ACTNO is not null");
            return (Criteria) this;
        }

        public Criteria andBaseActnoEqualTo(String value) {
            addCriterion("BASE_ACTNO =", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoNotEqualTo(String value) {
            addCriterion("BASE_ACTNO <>", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoGreaterThan(String value) {
            addCriterion("BASE_ACTNO >", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoGreaterThanOrEqualTo(String value) {
            addCriterion("BASE_ACTNO >=", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoLessThan(String value) {
            addCriterion("BASE_ACTNO <", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoLessThanOrEqualTo(String value) {
            addCriterion("BASE_ACTNO <=", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoLike(String value) {
            addCriterion("BASE_ACTNO like", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoNotLike(String value) {
            addCriterion("BASE_ACTNO not like", value, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoIn(List<String> values) {
            addCriterion("BASE_ACTNO in", values, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoNotIn(List<String> values) {
            addCriterion("BASE_ACTNO not in", values, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoBetween(String value1, String value2) {
            addCriterion("BASE_ACTNO between", value1, value2, "baseActno");
            return (Criteria) this;
        }

        public Criteria andBaseActnoNotBetween(String value1, String value2) {
            addCriterion("BASE_ACTNO not between", value1, value2, "baseActno");
            return (Criteria) this;
        }

        public Criteria andActBrcodeIsNull() {
            addCriterion("ACT_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andActBrcodeIsNotNull() {
            addCriterion("ACT_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andActBrcodeEqualTo(String value) {
            addCriterion("ACT_BRCODE =", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeNotEqualTo(String value) {
            addCriterion("ACT_BRCODE <>", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeGreaterThan(String value) {
            addCriterion("ACT_BRCODE >", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_BRCODE >=", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeLessThan(String value) {
            addCriterion("ACT_BRCODE <", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeLessThanOrEqualTo(String value) {
            addCriterion("ACT_BRCODE <=", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeLike(String value) {
            addCriterion("ACT_BRCODE like", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeNotLike(String value) {
            addCriterion("ACT_BRCODE not like", value, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeIn(List<String> values) {
            addCriterion("ACT_BRCODE in", values, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeNotIn(List<String> values) {
            addCriterion("ACT_BRCODE not in", values, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeBetween(String value1, String value2) {
            addCriterion("ACT_BRCODE between", value1, value2, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActBrcodeNotBetween(String value1, String value2) {
            addCriterion("ACT_BRCODE not between", value1, value2, "actBrcode");
            return (Criteria) this;
        }

        public Criteria andActnoIsNull() {
            addCriterion("ACTNO is null");
            return (Criteria) this;
        }

        public Criteria andActnoIsNotNull() {
            addCriterion("ACTNO is not null");
            return (Criteria) this;
        }

        public Criteria andActnoEqualTo(String value) {
            addCriterion("ACTNO =", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotEqualTo(String value) {
            addCriterion("ACTNO <>", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoGreaterThan(String value) {
            addCriterion("ACTNO >", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoGreaterThanOrEqualTo(String value) {
            addCriterion("ACTNO >=", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLessThan(String value) {
            addCriterion("ACTNO <", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLessThanOrEqualTo(String value) {
            addCriterion("ACTNO <=", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLike(String value) {
            addCriterion("ACTNO like", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotLike(String value) {
            addCriterion("ACTNO not like", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoIn(List<String> values) {
            addCriterion("ACTNO in", values, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotIn(List<String> values) {
            addCriterion("ACTNO not in", values, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoBetween(String value1, String value2) {
            addCriterion("ACTNO between", value1, value2, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotBetween(String value1, String value2) {
            addCriterion("ACTNO not between", value1, value2, "actno");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
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

        public Criteria andRegCapitalIsNull() {
            addCriterion("REG_CAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIsNotNull() {
            addCriterion("REG_CAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andRegCapitalEqualTo(BigDecimal value) {
            addCriterion("REG_CAPITAL =", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotEqualTo(BigDecimal value) {
            addCriterion("REG_CAPITAL <>", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThan(BigDecimal value) {
            addCriterion("REG_CAPITAL >", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REG_CAPITAL >=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThan(BigDecimal value) {
            addCriterion("REG_CAPITAL <", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REG_CAPITAL <=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIn(List<BigDecimal> values) {
            addCriterion("REG_CAPITAL in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotIn(List<BigDecimal> values) {
            addCriterion("REG_CAPITAL not in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REG_CAPITAL between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REG_CAPITAL not between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNull() {
            addCriterion("CAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNotNull() {
            addCriterion("CAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalEqualTo(BigDecimal value) {
            addCriterion("CAPITAL =", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotEqualTo(BigDecimal value) {
            addCriterion("CAPITAL <>", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThan(BigDecimal value) {
            addCriterion("CAPITAL >", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CAPITAL >=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThan(BigDecimal value) {
            addCriterion("CAPITAL <", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CAPITAL <=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalIn(List<BigDecimal> values) {
            addCriterion("CAPITAL in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotIn(List<BigDecimal> values) {
            addCriterion("CAPITAL not in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAPITAL between", value1, value2, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAPITAL not between", value1, value2, "capital");
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

        public Criteria andCustRoleIsNull() {
            addCriterion("CUST_ROLE is null");
            return (Criteria) this;
        }

        public Criteria andCustRoleIsNotNull() {
            addCriterion("CUST_ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andCustRoleEqualTo(String value) {
            addCriterion("CUST_ROLE =", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleNotEqualTo(String value) {
            addCriterion("CUST_ROLE <>", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleGreaterThan(String value) {
            addCriterion("CUST_ROLE >", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ROLE >=", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleLessThan(String value) {
            addCriterion("CUST_ROLE <", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleLessThanOrEqualTo(String value) {
            addCriterion("CUST_ROLE <=", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleLike(String value) {
            addCriterion("CUST_ROLE like", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleNotLike(String value) {
            addCriterion("CUST_ROLE not like", value, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleIn(List<String> values) {
            addCriterion("CUST_ROLE in", values, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleNotIn(List<String> values) {
            addCriterion("CUST_ROLE not in", values, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleBetween(String value1, String value2) {
            addCriterion("CUST_ROLE between", value1, value2, "custRole");
            return (Criteria) this;
        }

        public Criteria andCustRoleNotBetween(String value1, String value2) {
            addCriterion("CUST_ROLE not between", value1, value2, "custRole");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("BUSINESS_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("BUSINESS_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("BUSINESS_SCOPE >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("BUSINESS_SCOPE <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("BUSINESS_SCOPE like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("BUSINESS_SCOPE not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookIsNull() {
            addCriterion("INDUSTRY_OUTLOOK is null");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookIsNotNull() {
            addCriterion("INDUSTRY_OUTLOOK is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookEqualTo(String value) {
            addCriterion("INDUSTRY_OUTLOOK =", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookNotEqualTo(String value) {
            addCriterion("INDUSTRY_OUTLOOK <>", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookGreaterThan(String value) {
            addCriterion("INDUSTRY_OUTLOOK >", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_OUTLOOK >=", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookLessThan(String value) {
            addCriterion("INDUSTRY_OUTLOOK <", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_OUTLOOK <=", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookLike(String value) {
            addCriterion("INDUSTRY_OUTLOOK like", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookNotLike(String value) {
            addCriterion("INDUSTRY_OUTLOOK not like", value, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookIn(List<String> values) {
            addCriterion("INDUSTRY_OUTLOOK in", values, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookNotIn(List<String> values) {
            addCriterion("INDUSTRY_OUTLOOK not in", values, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookBetween(String value1, String value2) {
            addCriterion("INDUSTRY_OUTLOOK between", value1, value2, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andIndustryOutlookNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_OUTLOOK not between", value1, value2, "industryOutlook");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberIsNull() {
            addCriterion("EMPLOYEE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberIsNotNull() {
            addCriterion("EMPLOYEE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberEqualTo(BigDecimal value) {
            addCriterion("EMPLOYEE_NUMBER =", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberNotEqualTo(BigDecimal value) {
            addCriterion("EMPLOYEE_NUMBER <>", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberGreaterThan(BigDecimal value) {
            addCriterion("EMPLOYEE_NUMBER >", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EMPLOYEE_NUMBER >=", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberLessThan(BigDecimal value) {
            addCriterion("EMPLOYEE_NUMBER <", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EMPLOYEE_NUMBER <=", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberIn(List<BigDecimal> values) {
            addCriterion("EMPLOYEE_NUMBER in", values, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberNotIn(List<BigDecimal> values) {
            addCriterion("EMPLOYEE_NUMBER not in", values, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EMPLOYEE_NUMBER between", value1, value2, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EMPLOYEE_NUMBER not between", value1, value2, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNull() {
            addCriterion("TURNOVER is null");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNotNull() {
            addCriterion("TURNOVER is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoverEqualTo(BigDecimal value) {
            addCriterion("TURNOVER =", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotEqualTo(BigDecimal value) {
            addCriterion("TURNOVER <>", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThan(BigDecimal value) {
            addCriterion("TURNOVER >", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TURNOVER >=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThan(BigDecimal value) {
            addCriterion("TURNOVER <", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TURNOVER <=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverIn(List<BigDecimal> values) {
            addCriterion("TURNOVER in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotIn(List<BigDecimal> values) {
            addCriterion("TURNOVER not in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TURNOVER between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TURNOVER not between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationIsNull() {
            addCriterion("BUSINESS_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationIsNotNull() {
            addCriterion("BUSINESS_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationEqualTo(BigDecimal value) {
            addCriterion("BUSINESS_DURATION =", value, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationNotEqualTo(BigDecimal value) {
            addCriterion("BUSINESS_DURATION <>", value, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationGreaterThan(BigDecimal value) {
            addCriterion("BUSINESS_DURATION >", value, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUSINESS_DURATION >=", value, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationLessThan(BigDecimal value) {
            addCriterion("BUSINESS_DURATION <", value, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUSINESS_DURATION <=", value, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationIn(List<BigDecimal> values) {
            addCriterion("BUSINESS_DURATION in", values, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationNotIn(List<BigDecimal> values) {
            addCriterion("BUSINESS_DURATION not in", values, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUSINESS_DURATION between", value1, value2, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andBusinessDurationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUSINESS_DURATION not between", value1, value2, "businessDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationIsNull() {
            addCriterion("ACCOUNT_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andAccountDurationIsNotNull() {
            addCriterion("ACCOUNT_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDurationEqualTo(BigDecimal value) {
            addCriterion("ACCOUNT_DURATION =", value, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationNotEqualTo(BigDecimal value) {
            addCriterion("ACCOUNT_DURATION <>", value, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationGreaterThan(BigDecimal value) {
            addCriterion("ACCOUNT_DURATION >", value, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCOUNT_DURATION >=", value, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationLessThan(BigDecimal value) {
            addCriterion("ACCOUNT_DURATION <", value, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCOUNT_DURATION <=", value, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationIn(List<BigDecimal> values) {
            addCriterion("ACCOUNT_DURATION in", values, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationNotIn(List<BigDecimal> values) {
            addCriterion("ACCOUNT_DURATION not in", values, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCOUNT_DURATION between", value1, value2, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAccountDurationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCOUNT_DURATION not between", value1, value2, "accountDuration");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("AREA is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("AREA is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("AREA =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("AREA <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("AREA >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("AREA >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("AREA <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("AREA <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("AREA like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("AREA not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("AREA in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("AREA not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("AREA between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("AREA not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andBoundaryIsNull() {
            addCriterion("BOUNDARY is null");
            return (Criteria) this;
        }

        public Criteria andBoundaryIsNotNull() {
            addCriterion("BOUNDARY is not null");
            return (Criteria) this;
        }

        public Criteria andBoundaryEqualTo(String value) {
            addCriterion("BOUNDARY =", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryNotEqualTo(String value) {
            addCriterion("BOUNDARY <>", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryGreaterThan(String value) {
            addCriterion("BOUNDARY >", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryGreaterThanOrEqualTo(String value) {
            addCriterion("BOUNDARY >=", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryLessThan(String value) {
            addCriterion("BOUNDARY <", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryLessThanOrEqualTo(String value) {
            addCriterion("BOUNDARY <=", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryLike(String value) {
            addCriterion("BOUNDARY like", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryNotLike(String value) {
            addCriterion("BOUNDARY not like", value, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryIn(List<String> values) {
            addCriterion("BOUNDARY in", values, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryNotIn(List<String> values) {
            addCriterion("BOUNDARY not in", values, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryBetween(String value1, String value2) {
            addCriterion("BOUNDARY between", value1, value2, "boundary");
            return (Criteria) this;
        }

        public Criteria andBoundaryNotBetween(String value1, String value2) {
            addCriterion("BOUNDARY not between", value1, value2, "boundary");
            return (Criteria) this;
        }

        public Criteria andCustLevelIsNull() {
            addCriterion("CUST_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCustLevelIsNotNull() {
            addCriterion("CUST_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCustLevelEqualTo(String value) {
            addCriterion("CUST_LEVEL =", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotEqualTo(String value) {
            addCriterion("CUST_LEVEL <>", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelGreaterThan(String value) {
            addCriterion("CUST_LEVEL >", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_LEVEL >=", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLessThan(String value) {
            addCriterion("CUST_LEVEL <", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLessThanOrEqualTo(String value) {
            addCriterion("CUST_LEVEL <=", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLike(String value) {
            addCriterion("CUST_LEVEL like", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotLike(String value) {
            addCriterion("CUST_LEVEL not like", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelIn(List<String> values) {
            addCriterion("CUST_LEVEL in", values, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotIn(List<String> values) {
            addCriterion("CUST_LEVEL not in", values, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelBetween(String value1, String value2) {
            addCriterion("CUST_LEVEL between", value1, value2, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotBetween(String value1, String value2) {
            addCriterion("CUST_LEVEL not between", value1, value2, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelIsNull() {
            addCriterion("CORE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCoreLevelIsNotNull() {
            addCriterion("CORE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCoreLevelEqualTo(String value) {
            addCriterion("CORE_LEVEL =", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotEqualTo(String value) {
            addCriterion("CORE_LEVEL <>", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelGreaterThan(String value) {
            addCriterion("CORE_LEVEL >", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_LEVEL >=", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelLessThan(String value) {
            addCriterion("CORE_LEVEL <", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelLessThanOrEqualTo(String value) {
            addCriterion("CORE_LEVEL <=", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelLike(String value) {
            addCriterion("CORE_LEVEL like", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotLike(String value) {
            addCriterion("CORE_LEVEL not like", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelIn(List<String> values) {
            addCriterion("CORE_LEVEL in", values, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotIn(List<String> values) {
            addCriterion("CORE_LEVEL not in", values, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelBetween(String value1, String value2) {
            addCriterion("CORE_LEVEL between", value1, value2, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotBetween(String value1, String value2) {
            addCriterion("CORE_LEVEL not between", value1, value2, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionIsNull() {
            addCriterion("SUPPLY_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionIsNotNull() {
            addCriterion("SUPPLY_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionEqualTo(String value) {
            addCriterion("SUPPLY_POSITION =", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotEqualTo(String value) {
            addCriterion("SUPPLY_POSITION <>", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionGreaterThan(String value) {
            addCriterion("SUPPLY_POSITION >", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLY_POSITION >=", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionLessThan(String value) {
            addCriterion("SUPPLY_POSITION <", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionLessThanOrEqualTo(String value) {
            addCriterion("SUPPLY_POSITION <=", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionLike(String value) {
            addCriterion("SUPPLY_POSITION like", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotLike(String value) {
            addCriterion("SUPPLY_POSITION not like", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionIn(List<String> values) {
            addCriterion("SUPPLY_POSITION in", values, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotIn(List<String> values) {
            addCriterion("SUPPLY_POSITION not in", values, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionBetween(String value1, String value2) {
            addCriterion("SUPPLY_POSITION between", value1, value2, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotBetween(String value1, String value2) {
            addCriterion("SUPPLY_POSITION not between", value1, value2, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpIsNull() {
            addCriterion("IS_MARKET_CORP is null");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpIsNotNull() {
            addCriterion("IS_MARKET_CORP is not null");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpEqualTo(String value) {
            addCriterion("IS_MARKET_CORP =", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpNotEqualTo(String value) {
            addCriterion("IS_MARKET_CORP <>", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpGreaterThan(String value) {
            addCriterion("IS_MARKET_CORP >", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpGreaterThanOrEqualTo(String value) {
            addCriterion("IS_MARKET_CORP >=", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpLessThan(String value) {
            addCriterion("IS_MARKET_CORP <", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpLessThanOrEqualTo(String value) {
            addCriterion("IS_MARKET_CORP <=", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpLike(String value) {
            addCriterion("IS_MARKET_CORP like", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpNotLike(String value) {
            addCriterion("IS_MARKET_CORP not like", value, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpIn(List<String> values) {
            addCriterion("IS_MARKET_CORP in", values, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpNotIn(List<String> values) {
            addCriterion("IS_MARKET_CORP not in", values, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpBetween(String value1, String value2) {
            addCriterion("IS_MARKET_CORP between", value1, value2, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andIsMarketCorpNotBetween(String value1, String value2) {
            addCriterion("IS_MARKET_CORP not between", value1, value2, "isMarketCorp");
            return (Criteria) this;
        }

        public Criteria andEstablishDateIsNull() {
            addCriterion("ESTABLISH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEstablishDateIsNotNull() {
            addCriterion("ESTABLISH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEstablishDateEqualTo(Date value) {
            addCriterion("ESTABLISH_DATE =", value, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateNotEqualTo(Date value) {
            addCriterion("ESTABLISH_DATE <>", value, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateGreaterThan(Date value) {
            addCriterion("ESTABLISH_DATE >", value, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ESTABLISH_DATE >=", value, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateLessThan(Date value) {
            addCriterion("ESTABLISH_DATE <", value, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateLessThanOrEqualTo(Date value) {
            addCriterion("ESTABLISH_DATE <=", value, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateIn(List<Date> values) {
            addCriterion("ESTABLISH_DATE in", values, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateNotIn(List<Date> values) {
            addCriterion("ESTABLISH_DATE not in", values, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateBetween(Date value1, Date value2) {
            addCriterion("ESTABLISH_DATE between", value1, value2, "establishDate");
            return (Criteria) this;
        }

        public Criteria andEstablishDateNotBetween(Date value1, Date value2) {
            addCriterion("ESTABLISH_DATE not between", value1, value2, "establishDate");
            return (Criteria) this;
        }

        public Criteria andCounCodeIsNull() {
            addCriterion("COUN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCounCodeIsNotNull() {
            addCriterion("COUN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCounCodeEqualTo(String value) {
            addCriterion("COUN_CODE =", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeNotEqualTo(String value) {
            addCriterion("COUN_CODE <>", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeGreaterThan(String value) {
            addCriterion("COUN_CODE >", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COUN_CODE >=", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeLessThan(String value) {
            addCriterion("COUN_CODE <", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeLessThanOrEqualTo(String value) {
            addCriterion("COUN_CODE <=", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeLike(String value) {
            addCriterion("COUN_CODE like", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeNotLike(String value) {
            addCriterion("COUN_CODE not like", value, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeIn(List<String> values) {
            addCriterion("COUN_CODE in", values, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeNotIn(List<String> values) {
            addCriterion("COUN_CODE not in", values, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeBetween(String value1, String value2) {
            addCriterion("COUN_CODE between", value1, value2, "counCode");
            return (Criteria) this;
        }

        public Criteria andCounCodeNotBetween(String value1, String value2) {
            addCriterion("COUN_CODE not between", value1, value2, "counCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgIsNull() {
            addCriterion("REG_ORG is null");
            return (Criteria) this;
        }

        public Criteria andRegOrgIsNotNull() {
            addCriterion("REG_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andRegOrgEqualTo(String value) {
            addCriterion("REG_ORG =", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotEqualTo(String value) {
            addCriterion("REG_ORG <>", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgGreaterThan(String value) {
            addCriterion("REG_ORG >", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgGreaterThanOrEqualTo(String value) {
            addCriterion("REG_ORG >=", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgLessThan(String value) {
            addCriterion("REG_ORG <", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgLessThanOrEqualTo(String value) {
            addCriterion("REG_ORG <=", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgLike(String value) {
            addCriterion("REG_ORG like", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotLike(String value) {
            addCriterion("REG_ORG not like", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgIn(List<String> values) {
            addCriterion("REG_ORG in", values, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotIn(List<String> values) {
            addCriterion("REG_ORG not in", values, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgBetween(String value1, String value2) {
            addCriterion("REG_ORG between", value1, value2, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotBetween(String value1, String value2) {
            addCriterion("REG_ORG not between", value1, value2, "regOrg");
            return (Criteria) this;
        }

        public Criteria andStreetIsNull() {
            addCriterion("STREET is null");
            return (Criteria) this;
        }

        public Criteria andStreetIsNotNull() {
            addCriterion("STREET is not null");
            return (Criteria) this;
        }

        public Criteria andStreetEqualTo(String value) {
            addCriterion("STREET =", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotEqualTo(String value) {
            addCriterion("STREET <>", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThan(String value) {
            addCriterion("STREET >", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThanOrEqualTo(String value) {
            addCriterion("STREET >=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThan(String value) {
            addCriterion("STREET <", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThanOrEqualTo(String value) {
            addCriterion("STREET <=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLike(String value) {
            addCriterion("STREET like", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotLike(String value) {
            addCriterion("STREET not like", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetIn(List<String> values) {
            addCriterion("STREET in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotIn(List<String> values) {
            addCriterion("STREET not in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetBetween(String value1, String value2) {
            addCriterion("STREET between", value1, value2, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotBetween(String value1, String value2) {
            addCriterion("STREET not between", value1, value2, "street");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andEnAddrIsNull() {
            addCriterion("EN_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andEnAddrIsNotNull() {
            addCriterion("EN_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andEnAddrEqualTo(String value) {
            addCriterion("EN_ADDR =", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrNotEqualTo(String value) {
            addCriterion("EN_ADDR <>", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrGreaterThan(String value) {
            addCriterion("EN_ADDR >", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrGreaterThanOrEqualTo(String value) {
            addCriterion("EN_ADDR >=", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrLessThan(String value) {
            addCriterion("EN_ADDR <", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrLessThanOrEqualTo(String value) {
            addCriterion("EN_ADDR <=", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrLike(String value) {
            addCriterion("EN_ADDR like", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrNotLike(String value) {
            addCriterion("EN_ADDR not like", value, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrIn(List<String> values) {
            addCriterion("EN_ADDR in", values, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrNotIn(List<String> values) {
            addCriterion("EN_ADDR not in", values, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrBetween(String value1, String value2) {
            addCriterion("EN_ADDR between", value1, value2, "enAddr");
            return (Criteria) this;
        }

        public Criteria andEnAddrNotBetween(String value1, String value2) {
            addCriterion("EN_ADDR not between", value1, value2, "enAddr");
            return (Criteria) this;
        }

        public Criteria andContactEnNameIsNull() {
            addCriterion("CONTACT_EN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContactEnNameIsNotNull() {
            addCriterion("CONTACT_EN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContactEnNameEqualTo(String value) {
            addCriterion("CONTACT_EN_NAME =", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameNotEqualTo(String value) {
            addCriterion("CONTACT_EN_NAME <>", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameGreaterThan(String value) {
            addCriterion("CONTACT_EN_NAME >", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_EN_NAME >=", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameLessThan(String value) {
            addCriterion("CONTACT_EN_NAME <", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_EN_NAME <=", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameLike(String value) {
            addCriterion("CONTACT_EN_NAME like", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameNotLike(String value) {
            addCriterion("CONTACT_EN_NAME not like", value, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameIn(List<String> values) {
            addCriterion("CONTACT_EN_NAME in", values, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameNotIn(List<String> values) {
            addCriterion("CONTACT_EN_NAME not in", values, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameBetween(String value1, String value2) {
            addCriterion("CONTACT_EN_NAME between", value1, value2, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andContactEnNameNotBetween(String value1, String value2) {
            addCriterion("CONTACT_EN_NAME not between", value1, value2, "contactEnName");
            return (Criteria) this;
        }

        public Criteria andPayRouteIsNull() {
            addCriterion("PAY_ROUTE is null");
            return (Criteria) this;
        }

        public Criteria andPayRouteIsNotNull() {
            addCriterion("PAY_ROUTE is not null");
            return (Criteria) this;
        }

        public Criteria andPayRouteEqualTo(String value) {
            addCriterion("PAY_ROUTE =", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteNotEqualTo(String value) {
            addCriterion("PAY_ROUTE <>", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteGreaterThan(String value) {
            addCriterion("PAY_ROUTE >", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_ROUTE >=", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteLessThan(String value) {
            addCriterion("PAY_ROUTE <", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteLessThanOrEqualTo(String value) {
            addCriterion("PAY_ROUTE <=", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteLike(String value) {
            addCriterion("PAY_ROUTE like", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteNotLike(String value) {
            addCriterion("PAY_ROUTE not like", value, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteIn(List<String> values) {
            addCriterion("PAY_ROUTE in", values, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteNotIn(List<String> values) {
            addCriterion("PAY_ROUTE not in", values, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteBetween(String value1, String value2) {
            addCriterion("PAY_ROUTE between", value1, value2, "payRoute");
            return (Criteria) this;
        }

        public Criteria andPayRouteNotBetween(String value1, String value2) {
            addCriterion("PAY_ROUTE not between", value1, value2, "payRoute");
            return (Criteria) this;
        }

        public Criteria andServicesIsNull() {
            addCriterion("SERVICES is null");
            return (Criteria) this;
        }

        public Criteria andServicesIsNotNull() {
            addCriterion("SERVICES is not null");
            return (Criteria) this;
        }

        public Criteria andServicesEqualTo(String value) {
            addCriterion("SERVICES =", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotEqualTo(String value) {
            addCriterion("SERVICES <>", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThan(String value) {
            addCriterion("SERVICES >", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICES >=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThan(String value) {
            addCriterion("SERVICES <", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThanOrEqualTo(String value) {
            addCriterion("SERVICES <=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLike(String value) {
            addCriterion("SERVICES like", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotLike(String value) {
            addCriterion("SERVICES not like", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesIn(List<String> values) {
            addCriterion("SERVICES in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotIn(List<String> values) {
            addCriterion("SERVICES not in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesBetween(String value1, String value2) {
            addCriterion("SERVICES between", value1, value2, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotBetween(String value1, String value2) {
            addCriterion("SERVICES not between", value1, value2, "services");
            return (Criteria) this;
        }

        public Criteria andAppendixIsNull() {
            addCriterion("APPENDIX is null");
            return (Criteria) this;
        }

        public Criteria andAppendixIsNotNull() {
            addCriterion("APPENDIX is not null");
            return (Criteria) this;
        }

        public Criteria andAppendixEqualTo(String value) {
            addCriterion("APPENDIX =", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixNotEqualTo(String value) {
            addCriterion("APPENDIX <>", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixGreaterThan(String value) {
            addCriterion("APPENDIX >", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixGreaterThanOrEqualTo(String value) {
            addCriterion("APPENDIX >=", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixLessThan(String value) {
            addCriterion("APPENDIX <", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixLessThanOrEqualTo(String value) {
            addCriterion("APPENDIX <=", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixLike(String value) {
            addCriterion("APPENDIX like", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixNotLike(String value) {
            addCriterion("APPENDIX not like", value, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixIn(List<String> values) {
            addCriterion("APPENDIX in", values, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixNotIn(List<String> values) {
            addCriterion("APPENDIX not in", values, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixBetween(String value1, String value2) {
            addCriterion("APPENDIX between", value1, value2, "appendix");
            return (Criteria) this;
        }

        public Criteria andAppendixNotBetween(String value1, String value2) {
            addCriterion("APPENDIX not between", value1, value2, "appendix");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameIsNull() {
            addCriterion("CORE_NETWORK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameIsNotNull() {
            addCriterion("CORE_NETWORK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameEqualTo(String value) {
            addCriterion("CORE_NETWORK_NAME =", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameNotEqualTo(String value) {
            addCriterion("CORE_NETWORK_NAME <>", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameGreaterThan(String value) {
            addCriterion("CORE_NETWORK_NAME >", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_NETWORK_NAME >=", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameLessThan(String value) {
            addCriterion("CORE_NETWORK_NAME <", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameLessThanOrEqualTo(String value) {
            addCriterion("CORE_NETWORK_NAME <=", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameLike(String value) {
            addCriterion("CORE_NETWORK_NAME like", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameNotLike(String value) {
            addCriterion("CORE_NETWORK_NAME not like", value, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameIn(List<String> values) {
            addCriterion("CORE_NETWORK_NAME in", values, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameNotIn(List<String> values) {
            addCriterion("CORE_NETWORK_NAME not in", values, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameBetween(String value1, String value2) {
            addCriterion("CORE_NETWORK_NAME between", value1, value2, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andCoreNetworkNameNotBetween(String value1, String value2) {
            addCriterion("CORE_NETWORK_NAME not between", value1, value2, "coreNetworkName");
            return (Criteria) this;
        }

        public Criteria andNationalTaxIsNull() {
            addCriterion("NATIONAL_TAX is null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxIsNotNull() {
            addCriterion("NATIONAL_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxEqualTo(String value) {
            addCriterion("NATIONAL_TAX =", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNotEqualTo(String value) {
            addCriterion("NATIONAL_TAX <>", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxGreaterThan(String value) {
            addCriterion("NATIONAL_TAX >", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxGreaterThanOrEqualTo(String value) {
            addCriterion("NATIONAL_TAX >=", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxLessThan(String value) {
            addCriterion("NATIONAL_TAX <", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxLessThanOrEqualTo(String value) {
            addCriterion("NATIONAL_TAX <=", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxLike(String value) {
            addCriterion("NATIONAL_TAX like", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNotLike(String value) {
            addCriterion("NATIONAL_TAX not like", value, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxIn(List<String> values) {
            addCriterion("NATIONAL_TAX in", values, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNotIn(List<String> values) {
            addCriterion("NATIONAL_TAX not in", values, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxBetween(String value1, String value2) {
            addCriterion("NATIONAL_TAX between", value1, value2, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNotBetween(String value1, String value2) {
            addCriterion("NATIONAL_TAX not between", value1, value2, "nationalTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxIsNull() {
            addCriterion("LAND_TAX is null");
            return (Criteria) this;
        }

        public Criteria andLandTaxIsNotNull() {
            addCriterion("LAND_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andLandTaxEqualTo(String value) {
            addCriterion("LAND_TAX =", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxNotEqualTo(String value) {
            addCriterion("LAND_TAX <>", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxGreaterThan(String value) {
            addCriterion("LAND_TAX >", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxGreaterThanOrEqualTo(String value) {
            addCriterion("LAND_TAX >=", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxLessThan(String value) {
            addCriterion("LAND_TAX <", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxLessThanOrEqualTo(String value) {
            addCriterion("LAND_TAX <=", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxLike(String value) {
            addCriterion("LAND_TAX like", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxNotLike(String value) {
            addCriterion("LAND_TAX not like", value, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxIn(List<String> values) {
            addCriterion("LAND_TAX in", values, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxNotIn(List<String> values) {
            addCriterion("LAND_TAX not in", values, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxBetween(String value1, String value2) {
            addCriterion("LAND_TAX between", value1, value2, "landTax");
            return (Criteria) this;
        }

        public Criteria andLandTaxNotBetween(String value1, String value2) {
            addCriterion("LAND_TAX not between", value1, value2, "landTax");
            return (Criteria) this;
        }

        public Criteria andOwnHouseIsNull() {
            addCriterion("OWN_HOUSE is null");
            return (Criteria) this;
        }

        public Criteria andOwnHouseIsNotNull() {
            addCriterion("OWN_HOUSE is not null");
            return (Criteria) this;
        }

        public Criteria andOwnHouseEqualTo(String value) {
            addCriterion("OWN_HOUSE =", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseNotEqualTo(String value) {
            addCriterion("OWN_HOUSE <>", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseGreaterThan(String value) {
            addCriterion("OWN_HOUSE >", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseGreaterThanOrEqualTo(String value) {
            addCriterion("OWN_HOUSE >=", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseLessThan(String value) {
            addCriterion("OWN_HOUSE <", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseLessThanOrEqualTo(String value) {
            addCriterion("OWN_HOUSE <=", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseLike(String value) {
            addCriterion("OWN_HOUSE like", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseNotLike(String value) {
            addCriterion("OWN_HOUSE not like", value, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseIn(List<String> values) {
            addCriterion("OWN_HOUSE in", values, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseNotIn(List<String> values) {
            addCriterion("OWN_HOUSE not in", values, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseBetween(String value1, String value2) {
            addCriterion("OWN_HOUSE between", value1, value2, "ownHouse");
            return (Criteria) this;
        }

        public Criteria andOwnHouseNotBetween(String value1, String value2) {
            addCriterion("OWN_HOUSE not between", value1, value2, "ownHouse");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}