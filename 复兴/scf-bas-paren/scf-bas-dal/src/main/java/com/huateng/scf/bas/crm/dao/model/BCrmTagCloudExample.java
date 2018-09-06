package com.huateng.scf.bas.crm.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrmTagCloudExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrmTagCloudExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrmTagCloudExample(BCrmTagCloudExample example) {
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

        public Criteria andIndustryTypeNmIsNull() {
            addCriterion("INDUSTRY_TYPE_NM is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmIsNotNull() {
            addCriterion("INDUSTRY_TYPE_NM is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NM =", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmNotEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NM <>", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmGreaterThan(String value) {
            addCriterion("INDUSTRY_TYPE_NM >", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NM >=", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmLessThan(String value) {
            addCriterion("INDUSTRY_TYPE_NM <", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NM <=", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmLike(String value) {
            addCriterion("INDUSTRY_TYPE_NM like", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmNotLike(String value) {
            addCriterion("INDUSTRY_TYPE_NM not like", value, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE_NM in", values, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmNotIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE_NM not in", values, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE_NM between", value1, value2, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNmNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE_NM not between", value1, value2, "industryTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeIsNull() {
            addCriterion("ENT_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andEntScopeIsNotNull() {
            addCriterion("ENT_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andEntScopeEqualTo(String value) {
            addCriterion("ENT_SCOPE =", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeNotEqualTo(String value) {
            addCriterion("ENT_SCOPE <>", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeGreaterThan(String value) {
            addCriterion("ENT_SCOPE >", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_SCOPE >=", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeLessThan(String value) {
            addCriterion("ENT_SCOPE <", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeLessThanOrEqualTo(String value) {
            addCriterion("ENT_SCOPE <=", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeLike(String value) {
            addCriterion("ENT_SCOPE like", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeNotLike(String value) {
            addCriterion("ENT_SCOPE not like", value, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeIn(List<String> values) {
            addCriterion("ENT_SCOPE in", values, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeNotIn(List<String> values) {
            addCriterion("ENT_SCOPE not in", values, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeBetween(String value1, String value2) {
            addCriterion("ENT_SCOPE between", value1, value2, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeNotBetween(String value1, String value2) {
            addCriterion("ENT_SCOPE not between", value1, value2, "entScope");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmIsNull() {
            addCriterion("ENT_SCOPE_NM is null");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmIsNotNull() {
            addCriterion("ENT_SCOPE_NM is not null");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmEqualTo(String value) {
            addCriterion("ENT_SCOPE_NM =", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmNotEqualTo(String value) {
            addCriterion("ENT_SCOPE_NM <>", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmGreaterThan(String value) {
            addCriterion("ENT_SCOPE_NM >", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_SCOPE_NM >=", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmLessThan(String value) {
            addCriterion("ENT_SCOPE_NM <", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmLessThanOrEqualTo(String value) {
            addCriterion("ENT_SCOPE_NM <=", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmLike(String value) {
            addCriterion("ENT_SCOPE_NM like", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmNotLike(String value) {
            addCriterion("ENT_SCOPE_NM not like", value, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmIn(List<String> values) {
            addCriterion("ENT_SCOPE_NM in", values, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmNotIn(List<String> values) {
            addCriterion("ENT_SCOPE_NM not in", values, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmBetween(String value1, String value2) {
            addCriterion("ENT_SCOPE_NM between", value1, value2, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntScopeNmNotBetween(String value1, String value2) {
            addCriterion("ENT_SCOPE_NM not between", value1, value2, "entScopeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeIsNull() {
            addCriterion("ENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEntTypeIsNotNull() {
            addCriterion("ENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEntTypeEqualTo(String value) {
            addCriterion("ENT_TYPE =", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotEqualTo(String value) {
            addCriterion("ENT_TYPE <>", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeGreaterThan(String value) {
            addCriterion("ENT_TYPE >", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_TYPE >=", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeLessThan(String value) {
            addCriterion("ENT_TYPE <", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeLessThanOrEqualTo(String value) {
            addCriterion("ENT_TYPE <=", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeLike(String value) {
            addCriterion("ENT_TYPE like", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotLike(String value) {
            addCriterion("ENT_TYPE not like", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeIn(List<String> values) {
            addCriterion("ENT_TYPE in", values, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotIn(List<String> values) {
            addCriterion("ENT_TYPE not in", values, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeBetween(String value1, String value2) {
            addCriterion("ENT_TYPE between", value1, value2, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotBetween(String value1, String value2) {
            addCriterion("ENT_TYPE not between", value1, value2, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmIsNull() {
            addCriterion("ENT_TYPE_NM is null");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmIsNotNull() {
            addCriterion("ENT_TYPE_NM is not null");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmEqualTo(String value) {
            addCriterion("ENT_TYPE_NM =", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmNotEqualTo(String value) {
            addCriterion("ENT_TYPE_NM <>", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmGreaterThan(String value) {
            addCriterion("ENT_TYPE_NM >", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_TYPE_NM >=", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmLessThan(String value) {
            addCriterion("ENT_TYPE_NM <", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmLessThanOrEqualTo(String value) {
            addCriterion("ENT_TYPE_NM <=", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmLike(String value) {
            addCriterion("ENT_TYPE_NM like", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmNotLike(String value) {
            addCriterion("ENT_TYPE_NM not like", value, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmIn(List<String> values) {
            addCriterion("ENT_TYPE_NM in", values, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmNotIn(List<String> values) {
            addCriterion("ENT_TYPE_NM not in", values, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmBetween(String value1, String value2) {
            addCriterion("ENT_TYPE_NM between", value1, value2, "entTypeNm");
            return (Criteria) this;
        }

        public Criteria andEntTypeNmNotBetween(String value1, String value2) {
            addCriterion("ENT_TYPE_NM not between", value1, value2, "entTypeNm");
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

        public Criteria andCreditScrIsNull() {
            addCriterion("CREDIT_SCR is null");
            return (Criteria) this;
        }

        public Criteria andCreditScrIsNotNull() {
            addCriterion("CREDIT_SCR is not null");
            return (Criteria) this;
        }

        public Criteria andCreditScrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_SCR =", value, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_SCR <>", value, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_SCR >", value, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_SCR >=", value, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrLessThan(BigDecimal value) {
            addCriterion("CREDIT_SCR <", value, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_SCR <=", value, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrIn(List<BigDecimal> values) {
            addCriterion("CREDIT_SCR in", values, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_SCR not in", values, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_SCR between", value1, value2, "creditScr");
            return (Criteria) this;
        }

        public Criteria andCreditScrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_SCR not between", value1, value2, "creditScr");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimIsNull() {
            addCriterion("SCF_AGE_LIM is null");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimIsNotNull() {
            addCriterion("SCF_AGE_LIM is not null");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimEqualTo(String value) {
            addCriterion("SCF_AGE_LIM =", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNotEqualTo(String value) {
            addCriterion("SCF_AGE_LIM <>", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimGreaterThan(String value) {
            addCriterion("SCF_AGE_LIM >", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimGreaterThanOrEqualTo(String value) {
            addCriterion("SCF_AGE_LIM >=", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimLessThan(String value) {
            addCriterion("SCF_AGE_LIM <", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimLessThanOrEqualTo(String value) {
            addCriterion("SCF_AGE_LIM <=", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimLike(String value) {
            addCriterion("SCF_AGE_LIM like", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNotLike(String value) {
            addCriterion("SCF_AGE_LIM not like", value, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimIn(List<String> values) {
            addCriterion("SCF_AGE_LIM in", values, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNotIn(List<String> values) {
            addCriterion("SCF_AGE_LIM not in", values, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimBetween(String value1, String value2) {
            addCriterion("SCF_AGE_LIM between", value1, value2, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNotBetween(String value1, String value2) {
            addCriterion("SCF_AGE_LIM not between", value1, value2, "scfAgeLim");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmIsNull() {
            addCriterion("SCF_AGE_LIM_NM is null");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmIsNotNull() {
            addCriterion("SCF_AGE_LIM_NM is not null");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmEqualTo(String value) {
            addCriterion("SCF_AGE_LIM_NM =", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmNotEqualTo(String value) {
            addCriterion("SCF_AGE_LIM_NM <>", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmGreaterThan(String value) {
            addCriterion("SCF_AGE_LIM_NM >", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmGreaterThanOrEqualTo(String value) {
            addCriterion("SCF_AGE_LIM_NM >=", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmLessThan(String value) {
            addCriterion("SCF_AGE_LIM_NM <", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmLessThanOrEqualTo(String value) {
            addCriterion("SCF_AGE_LIM_NM <=", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmLike(String value) {
            addCriterion("SCF_AGE_LIM_NM like", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmNotLike(String value) {
            addCriterion("SCF_AGE_LIM_NM not like", value, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmIn(List<String> values) {
            addCriterion("SCF_AGE_LIM_NM in", values, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmNotIn(List<String> values) {
            addCriterion("SCF_AGE_LIM_NM not in", values, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmBetween(String value1, String value2) {
            addCriterion("SCF_AGE_LIM_NM between", value1, value2, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andScfAgeLimNmNotBetween(String value1, String value2) {
            addCriterion("SCF_AGE_LIM_NM not between", value1, value2, "scfAgeLimNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityIsNull() {
            addCriterion("CUST_QUALITY is null");
            return (Criteria) this;
        }

        public Criteria andCustQualityIsNotNull() {
            addCriterion("CUST_QUALITY is not null");
            return (Criteria) this;
        }

        public Criteria andCustQualityEqualTo(String value) {
            addCriterion("CUST_QUALITY =", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityNotEqualTo(String value) {
            addCriterion("CUST_QUALITY <>", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityGreaterThan(String value) {
            addCriterion("CUST_QUALITY >", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_QUALITY >=", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityLessThan(String value) {
            addCriterion("CUST_QUALITY <", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityLessThanOrEqualTo(String value) {
            addCriterion("CUST_QUALITY <=", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityLike(String value) {
            addCriterion("CUST_QUALITY like", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityNotLike(String value) {
            addCriterion("CUST_QUALITY not like", value, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityIn(List<String> values) {
            addCriterion("CUST_QUALITY in", values, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityNotIn(List<String> values) {
            addCriterion("CUST_QUALITY not in", values, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityBetween(String value1, String value2) {
            addCriterion("CUST_QUALITY between", value1, value2, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityNotBetween(String value1, String value2) {
            addCriterion("CUST_QUALITY not between", value1, value2, "custQuality");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmIsNull() {
            addCriterion("CUST_QUALITY_NM is null");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmIsNotNull() {
            addCriterion("CUST_QUALITY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmEqualTo(String value) {
            addCriterion("CUST_QUALITY_NM =", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmNotEqualTo(String value) {
            addCriterion("CUST_QUALITY_NM <>", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmGreaterThan(String value) {
            addCriterion("CUST_QUALITY_NM >", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_QUALITY_NM >=", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmLessThan(String value) {
            addCriterion("CUST_QUALITY_NM <", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmLessThanOrEqualTo(String value) {
            addCriterion("CUST_QUALITY_NM <=", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmLike(String value) {
            addCriterion("CUST_QUALITY_NM like", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmNotLike(String value) {
            addCriterion("CUST_QUALITY_NM not like", value, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmIn(List<String> values) {
            addCriterion("CUST_QUALITY_NM in", values, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmNotIn(List<String> values) {
            addCriterion("CUST_QUALITY_NM not in", values, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmBetween(String value1, String value2) {
            addCriterion("CUST_QUALITY_NM between", value1, value2, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustQualityNmNotBetween(String value1, String value2) {
            addCriterion("CUST_QUALITY_NM not between", value1, value2, "custQualityNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationIsNull() {
            addCriterion("CUST_RELATION is null");
            return (Criteria) this;
        }

        public Criteria andCustRelationIsNotNull() {
            addCriterion("CUST_RELATION is not null");
            return (Criteria) this;
        }

        public Criteria andCustRelationEqualTo(String value) {
            addCriterion("CUST_RELATION =", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationNotEqualTo(String value) {
            addCriterion("CUST_RELATION <>", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationGreaterThan(String value) {
            addCriterion("CUST_RELATION >", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_RELATION >=", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationLessThan(String value) {
            addCriterion("CUST_RELATION <", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationLessThanOrEqualTo(String value) {
            addCriterion("CUST_RELATION <=", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationLike(String value) {
            addCriterion("CUST_RELATION like", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationNotLike(String value) {
            addCriterion("CUST_RELATION not like", value, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationIn(List<String> values) {
            addCriterion("CUST_RELATION in", values, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationNotIn(List<String> values) {
            addCriterion("CUST_RELATION not in", values, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationBetween(String value1, String value2) {
            addCriterion("CUST_RELATION between", value1, value2, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationNotBetween(String value1, String value2) {
            addCriterion("CUST_RELATION not between", value1, value2, "custRelation");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmIsNull() {
            addCriterion("CUST_RELATION_NM is null");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmIsNotNull() {
            addCriterion("CUST_RELATION_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmEqualTo(String value) {
            addCriterion("CUST_RELATION_NM =", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmNotEqualTo(String value) {
            addCriterion("CUST_RELATION_NM <>", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmGreaterThan(String value) {
            addCriterion("CUST_RELATION_NM >", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_RELATION_NM >=", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmLessThan(String value) {
            addCriterion("CUST_RELATION_NM <", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmLessThanOrEqualTo(String value) {
            addCriterion("CUST_RELATION_NM <=", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmLike(String value) {
            addCriterion("CUST_RELATION_NM like", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmNotLike(String value) {
            addCriterion("CUST_RELATION_NM not like", value, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmIn(List<String> values) {
            addCriterion("CUST_RELATION_NM in", values, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmNotIn(List<String> values) {
            addCriterion("CUST_RELATION_NM not in", values, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmBetween(String value1, String value2) {
            addCriterion("CUST_RELATION_NM between", value1, value2, "custRelationNm");
            return (Criteria) this;
        }

        public Criteria andCustRelationNmNotBetween(String value1, String value2) {
            addCriterion("CUST_RELATION_NM not between", value1, value2, "custRelationNm");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}