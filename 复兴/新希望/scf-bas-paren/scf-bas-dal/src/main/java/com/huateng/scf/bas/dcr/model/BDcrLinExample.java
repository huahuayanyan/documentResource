package com.huateng.scf.bas.dcr.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDcrLinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDcrLinExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BDcrLinExample(BDcrLinExample example) {
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

        public Criteria andAppCrIdIsNull() {
            addCriterion("APP_CR_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppCrIdIsNotNull() {
            addCriterion("APP_CR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppCrIdEqualTo(String value) {
            addCriterion("APP_CR_ID =", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdNotEqualTo(String value) {
            addCriterion("APP_CR_ID <>", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdGreaterThan(String value) {
            addCriterion("APP_CR_ID >", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_CR_ID >=", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdLessThan(String value) {
            addCriterion("APP_CR_ID <", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdLessThanOrEqualTo(String value) {
            addCriterion("APP_CR_ID <=", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdLike(String value) {
            addCriterion("APP_CR_ID like", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdNotLike(String value) {
            addCriterion("APP_CR_ID not like", value, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdIn(List<String> values) {
            addCriterion("APP_CR_ID in", values, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdNotIn(List<String> values) {
            addCriterion("APP_CR_ID not in", values, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdBetween(String value1, String value2) {
            addCriterion("APP_CR_ID between", value1, value2, "appCrId");
            return (Criteria) this;
        }

        public Criteria andAppCrIdNotBetween(String value1, String value2) {
            addCriterion("APP_CR_ID not between", value1, value2, "appCrId");
            return (Criteria) this;
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

        public Criteria andContractNoIsNull() {
            addCriterion("CONTRACT_NO is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("CONTRACT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("CONTRACT_NO =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("CONTRACT_NO <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("CONTRACT_NO >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NO >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("CONTRACT_NO <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NO <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("CONTRACT_NO like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("CONTRACT_NO not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("CONTRACT_NO in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("CONTRACT_NO not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("CONTRACT_NO between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_NO not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andEffectDtIsNull() {
            addCriterion("EFFECT_DT is null");
            return (Criteria) this;
        }

        public Criteria andEffectDtIsNotNull() {
            addCriterion("EFFECT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andEffectDtEqualTo(String value) {
            addCriterion("EFFECT_DT =", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtNotEqualTo(String value) {
            addCriterion("EFFECT_DT <>", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtGreaterThan(String value) {
            addCriterion("EFFECT_DT >", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_DT >=", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtLessThan(String value) {
            addCriterion("EFFECT_DT <", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_DT <=", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtLike(String value) {
            addCriterion("EFFECT_DT like", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtNotLike(String value) {
            addCriterion("EFFECT_DT not like", value, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtIn(List<String> values) {
            addCriterion("EFFECT_DT in", values, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtNotIn(List<String> values) {
            addCriterion("EFFECT_DT not in", values, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtBetween(String value1, String value2) {
            addCriterion("EFFECT_DT between", value1, value2, "effectDt");
            return (Criteria) this;
        }

        public Criteria andEffectDtNotBetween(String value1, String value2) {
            addCriterion("EFFECT_DT not between", value1, value2, "effectDt");
            return (Criteria) this;
        }

        public Criteria andBegDtIsNull() {
            addCriterion("BEG_DT is null");
            return (Criteria) this;
        }

        public Criteria andBegDtIsNotNull() {
            addCriterion("BEG_DT is not null");
            return (Criteria) this;
        }

        public Criteria andBegDtEqualTo(String value) {
            addCriterion("BEG_DT =", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtNotEqualTo(String value) {
            addCriterion("BEG_DT <>", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtGreaterThan(String value) {
            addCriterion("BEG_DT >", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtGreaterThanOrEqualTo(String value) {
            addCriterion("BEG_DT >=", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtLessThan(String value) {
            addCriterion("BEG_DT <", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtLessThanOrEqualTo(String value) {
            addCriterion("BEG_DT <=", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtLike(String value) {
            addCriterion("BEG_DT like", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtNotLike(String value) {
            addCriterion("BEG_DT not like", value, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtIn(List<String> values) {
            addCriterion("BEG_DT in", values, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtNotIn(List<String> values) {
            addCriterion("BEG_DT not in", values, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtBetween(String value1, String value2) {
            addCriterion("BEG_DT between", value1, value2, "begDt");
            return (Criteria) this;
        }

        public Criteria andBegDtNotBetween(String value1, String value2) {
            addCriterion("BEG_DT not between", value1, value2, "begDt");
            return (Criteria) this;
        }

        public Criteria andEndDtIsNull() {
            addCriterion("END_DT is null");
            return (Criteria) this;
        }

        public Criteria andEndDtIsNotNull() {
            addCriterion("END_DT is not null");
            return (Criteria) this;
        }

        public Criteria andEndDtEqualTo(String value) {
            addCriterion("END_DT =", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtNotEqualTo(String value) {
            addCriterion("END_DT <>", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtGreaterThan(String value) {
            addCriterion("END_DT >", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtGreaterThanOrEqualTo(String value) {
            addCriterion("END_DT >=", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtLessThan(String value) {
            addCriterion("END_DT <", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtLessThanOrEqualTo(String value) {
            addCriterion("END_DT <=", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtLike(String value) {
            addCriterion("END_DT like", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtNotLike(String value) {
            addCriterion("END_DT not like", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtIn(List<String> values) {
            addCriterion("END_DT in", values, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtNotIn(List<String> values) {
            addCriterion("END_DT not in", values, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtBetween(String value1, String value2) {
            addCriterion("END_DT between", value1, value2, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtNotBetween(String value1, String value2) {
            addCriterion("END_DT not between", value1, value2, "endDt");
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

        public Criteria andRiskAmtIsNull() {
            addCriterion("RISK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNotNull() {
            addCriterion("RISK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT =", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <>", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("RISK_AMT >", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT >=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThan(BigDecimal value) {
            addCriterion("RISK_AMT <", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT not in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT not between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andGuatTypIsNull() {
            addCriterion("GUAT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andGuatTypIsNotNull() {
            addCriterion("GUAT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andGuatTypEqualTo(String value) {
            addCriterion("GUAT_TYP =", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypNotEqualTo(String value) {
            addCriterion("GUAT_TYP <>", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypGreaterThan(String value) {
            addCriterion("GUAT_TYP >", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypGreaterThanOrEqualTo(String value) {
            addCriterion("GUAT_TYP >=", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypLessThan(String value) {
            addCriterion("GUAT_TYP <", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypLessThanOrEqualTo(String value) {
            addCriterion("GUAT_TYP <=", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypLike(String value) {
            addCriterion("GUAT_TYP like", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypNotLike(String value) {
            addCriterion("GUAT_TYP not like", value, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypIn(List<String> values) {
            addCriterion("GUAT_TYP in", values, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypNotIn(List<String> values) {
            addCriterion("GUAT_TYP not in", values, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypBetween(String value1, String value2) {
            addCriterion("GUAT_TYP between", value1, value2, "guatTyp");
            return (Criteria) this;
        }

        public Criteria andGuatTypNotBetween(String value1, String value2) {
            addCriterion("GUAT_TYP not between", value1, value2, "guatTyp");
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

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andUsedNumIsNull() {
            addCriterion("USED_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUsedNumIsNotNull() {
            addCriterion("USED_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUsedNumEqualTo(BigDecimal value) {
            addCriterion("USED_NUM =", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotEqualTo(BigDecimal value) {
            addCriterion("USED_NUM <>", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumGreaterThan(BigDecimal value) {
            addCriterion("USED_NUM >", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_NUM >=", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumLessThan(BigDecimal value) {
            addCriterion("USED_NUM <", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_NUM <=", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumIn(List<BigDecimal> values) {
            addCriterion("USED_NUM in", values, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotIn(List<BigDecimal> values) {
            addCriterion("USED_NUM not in", values, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_NUM between", value1, value2, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_NUM not between", value1, value2, "usedNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumIsNull() {
            addCriterion("ABLE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAbleNumIsNotNull() {
            addCriterion("ABLE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAbleNumEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM =", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumNotEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM <>", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumGreaterThan(BigDecimal value) {
            addCriterion("ABLE_NUM >", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM >=", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumLessThan(BigDecimal value) {
            addCriterion("ABLE_NUM <", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ABLE_NUM <=", value, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumIn(List<BigDecimal> values) {
            addCriterion("ABLE_NUM in", values, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumNotIn(List<BigDecimal> values) {
            addCriterion("ABLE_NUM not in", values, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABLE_NUM between", value1, value2, "ableNum");
            return (Criteria) this;
        }

        public Criteria andAbleNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABLE_NUM not between", value1, value2, "ableNum");
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

        public Criteria andInputDtIsNull() {
            addCriterion("INPUT_DT is null");
            return (Criteria) this;
        }

        public Criteria andInputDtIsNotNull() {
            addCriterion("INPUT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andInputDtEqualTo(String value) {
            addCriterion("INPUT_DT =", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotEqualTo(String value) {
            addCriterion("INPUT_DT <>", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtGreaterThan(String value) {
            addCriterion("INPUT_DT >", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_DT >=", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtLessThan(String value) {
            addCriterion("INPUT_DT <", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtLessThanOrEqualTo(String value) {
            addCriterion("INPUT_DT <=", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtLike(String value) {
            addCriterion("INPUT_DT like", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotLike(String value) {
            addCriterion("INPUT_DT not like", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtIn(List<String> values) {
            addCriterion("INPUT_DT in", values, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotIn(List<String> values) {
            addCriterion("INPUT_DT not in", values, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtBetween(String value1, String value2) {
            addCriterion("INPUT_DT between", value1, value2, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotBetween(String value1, String value2) {
            addCriterion("INPUT_DT not between", value1, value2, "inputDt");
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