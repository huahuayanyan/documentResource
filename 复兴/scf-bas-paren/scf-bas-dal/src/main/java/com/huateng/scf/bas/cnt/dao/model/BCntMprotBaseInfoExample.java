package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntMprotBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntMprotBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntMprotBaseInfoExample(BCntMprotBaseInfoExample example) {
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

        public Criteria andProtocolCodeIsNull() {
            addCriterion("PROTOCOL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIsNotNull() {
            addCriterion("PROTOCOL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeEqualTo(String value) {
            addCriterion("PROTOCOL_CODE =", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotEqualTo(String value) {
            addCriterion("PROTOCOL_CODE <>", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeGreaterThan(String value) {
            addCriterion("PROTOCOL_CODE >", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_CODE >=", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLessThan(String value) {
            addCriterion("PROTOCOL_CODE <", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_CODE <=", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLike(String value) {
            addCriterion("PROTOCOL_CODE like", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotLike(String value) {
            addCriterion("PROTOCOL_CODE not like", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIn(List<String> values) {
            addCriterion("PROTOCOL_CODE in", values, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotIn(List<String> values) {
            addCriterion("PROTOCOL_CODE not in", values, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeBetween(String value1, String value2) {
            addCriterion("PROTOCOL_CODE between", value1, value2, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_CODE not between", value1, value2, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNull() {
            addCriterion("PROTOCOL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNotNull() {
            addCriterion("PROTOCOL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeEqualTo(String value) {
            addCriterion("PROTOCOL_TYPE =", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotEqualTo(String value) {
            addCriterion("PROTOCOL_TYPE <>", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThan(String value) {
            addCriterion("PROTOCOL_TYPE >", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_TYPE >=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThan(String value) {
            addCriterion("PROTOCOL_TYPE <", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_TYPE <=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLike(String value) {
            addCriterion("PROTOCOL_TYPE like", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotLike(String value) {
            addCriterion("PROTOCOL_TYPE not like", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIn(List<String> values) {
            addCriterion("PROTOCOL_TYPE in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotIn(List<String> values) {
            addCriterion("PROTOCOL_TYPE not in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeBetween(String value1, String value2) {
            addCriterion("PROTOCOL_TYPE between", value1, value2, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_TYPE not between", value1, value2, "protocolType");
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

        public Criteria andSignDateIsNull() {
            addCriterion("SIGN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("SIGN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(String value) {
            addCriterion("SIGN_DATE =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(String value) {
            addCriterion("SIGN_DATE <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(String value) {
            addCriterion("SIGN_DATE >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_DATE >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(String value) {
            addCriterion("SIGN_DATE <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(String value) {
            addCriterion("SIGN_DATE <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLike(String value) {
            addCriterion("SIGN_DATE like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotLike(String value) {
            addCriterion("SIGN_DATE not like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<String> values) {
            addCriterion("SIGN_DATE in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<String> values) {
            addCriterion("SIGN_DATE not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(String value1, String value2) {
            addCriterion("SIGN_DATE between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(String value1, String value2) {
            addCriterion("SIGN_DATE not between", value1, value2, "signDate");
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

        public Criteria andTenorIsNull() {
            addCriterion("TENOR is null");
            return (Criteria) this;
        }

        public Criteria andTenorIsNotNull() {
            addCriterion("TENOR is not null");
            return (Criteria) this;
        }

        public Criteria andTenorEqualTo(String value) {
            addCriterion("TENOR =", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorNotEqualTo(String value) {
            addCriterion("TENOR <>", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorGreaterThan(String value) {
            addCriterion("TENOR >", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorGreaterThanOrEqualTo(String value) {
            addCriterion("TENOR >=", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorLessThan(String value) {
            addCriterion("TENOR <", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorLessThanOrEqualTo(String value) {
            addCriterion("TENOR <=", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorLike(String value) {
            addCriterion("TENOR like", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorNotLike(String value) {
            addCriterion("TENOR not like", value, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorIn(List<String> values) {
            addCriterion("TENOR in", values, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorNotIn(List<String> values) {
            addCriterion("TENOR not in", values, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorBetween(String value1, String value2) {
            addCriterion("TENOR between", value1, value2, "tenor");
            return (Criteria) this;
        }

        public Criteria andTenorNotBetween(String value1, String value2) {
            addCriterion("TENOR not between", value1, value2, "tenor");
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

        public Criteria andProtAmtIsNull() {
            addCriterion("PROT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andProtAmtIsNotNull() {
            addCriterion("PROT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andProtAmtEqualTo(BigDecimal value) {
            addCriterion("PROT_AMT =", value, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtNotEqualTo(BigDecimal value) {
            addCriterion("PROT_AMT <>", value, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtGreaterThan(BigDecimal value) {
            addCriterion("PROT_AMT >", value, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROT_AMT >=", value, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtLessThan(BigDecimal value) {
            addCriterion("PROT_AMT <", value, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROT_AMT <=", value, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtIn(List<BigDecimal> values) {
            addCriterion("PROT_AMT in", values, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtNotIn(List<BigDecimal> values) {
            addCriterion("PROT_AMT not in", values, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROT_AMT between", value1, value2, "protAmt");
            return (Criteria) this;
        }

        public Criteria andProtAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROT_AMT not between", value1, value2, "protAmt");
            return (Criteria) this;
        }

        public Criteria andSignInIsNull() {
            addCriterion("SIGN_IN is null");
            return (Criteria) this;
        }

        public Criteria andSignInIsNotNull() {
            addCriterion("SIGN_IN is not null");
            return (Criteria) this;
        }

        public Criteria andSignInEqualTo(String value) {
            addCriterion("SIGN_IN =", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotEqualTo(String value) {
            addCriterion("SIGN_IN <>", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInGreaterThan(String value) {
            addCriterion("SIGN_IN >", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_IN >=", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInLessThan(String value) {
            addCriterion("SIGN_IN <", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInLessThanOrEqualTo(String value) {
            addCriterion("SIGN_IN <=", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInLike(String value) {
            addCriterion("SIGN_IN like", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotLike(String value) {
            addCriterion("SIGN_IN not like", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInIn(List<String> values) {
            addCriterion("SIGN_IN in", values, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotIn(List<String> values) {
            addCriterion("SIGN_IN not in", values, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInBetween(String value1, String value2) {
            addCriterion("SIGN_IN between", value1, value2, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotBetween(String value1, String value2) {
            addCriterion("SIGN_IN not between", value1, value2, "signIn");
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

        public Criteria andOtherDesIsNull() {
            addCriterion("OTHER_DES is null");
            return (Criteria) this;
        }

        public Criteria andOtherDesIsNotNull() {
            addCriterion("OTHER_DES is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDesEqualTo(String value) {
            addCriterion("OTHER_DES =", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotEqualTo(String value) {
            addCriterion("OTHER_DES <>", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesGreaterThan(String value) {
            addCriterion("OTHER_DES >", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_DES >=", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesLessThan(String value) {
            addCriterion("OTHER_DES <", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesLessThanOrEqualTo(String value) {
            addCriterion("OTHER_DES <=", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesLike(String value) {
            addCriterion("OTHER_DES like", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotLike(String value) {
            addCriterion("OTHER_DES not like", value, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesIn(List<String> values) {
            addCriterion("OTHER_DES in", values, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotIn(List<String> values) {
            addCriterion("OTHER_DES not in", values, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesBetween(String value1, String value2) {
            addCriterion("OTHER_DES between", value1, value2, "otherDes");
            return (Criteria) this;
        }

        public Criteria andOtherDesNotBetween(String value1, String value2) {
            addCriterion("OTHER_DES not between", value1, value2, "otherDes");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNull() {
            addCriterion("TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNotNull() {
            addCriterion("TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andTlrnoEqualTo(String value) {
            addCriterion("TLRNO =", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotEqualTo(String value) {
            addCriterion("TLRNO <>", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThan(String value) {
            addCriterion("TLRNO >", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("TLRNO >=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThan(String value) {
            addCriterion("TLRNO <", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThanOrEqualTo(String value) {
            addCriterion("TLRNO <=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLike(String value) {
            addCriterion("TLRNO like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotLike(String value) {
            addCriterion("TLRNO not like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoIn(List<String> values) {
            addCriterion("TLRNO in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotIn(List<String> values) {
            addCriterion("TLRNO not in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoBetween(String value1, String value2) {
            addCriterion("TLRNO between", value1, value2, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotBetween(String value1, String value2) {
            addCriterion("TLRNO not between", value1, value2, "tlrno");
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

        public Criteria andUpdateStateIsNull() {
            addCriterion("UPDATE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateStateIsNotNull() {
            addCriterion("UPDATE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateStateEqualTo(String value) {
            addCriterion("UPDATE_STATE =", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateNotEqualTo(String value) {
            addCriterion("UPDATE_STATE <>", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateGreaterThan(String value) {
            addCriterion("UPDATE_STATE >", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_STATE >=", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateLessThan(String value) {
            addCriterion("UPDATE_STATE <", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_STATE <=", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateLike(String value) {
            addCriterion("UPDATE_STATE like", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateNotLike(String value) {
            addCriterion("UPDATE_STATE not like", value, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateIn(List<String> values) {
            addCriterion("UPDATE_STATE in", values, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateNotIn(List<String> values) {
            addCriterion("UPDATE_STATE not in", values, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateBetween(String value1, String value2) {
            addCriterion("UPDATE_STATE between", value1, value2, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateStateNotBetween(String value1, String value2) {
            addCriterion("UPDATE_STATE not between", value1, value2, "updateState");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoIsNull() {
            addCriterion("OTHERPROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoIsNotNull() {
            addCriterion("OTHERPROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoEqualTo(String value) {
            addCriterion("OTHERPROTOCOL_NO =", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoNotEqualTo(String value) {
            addCriterion("OTHERPROTOCOL_NO <>", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoGreaterThan(String value) {
            addCriterion("OTHERPROTOCOL_NO >", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERPROTOCOL_NO >=", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoLessThan(String value) {
            addCriterion("OTHERPROTOCOL_NO <", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoLessThanOrEqualTo(String value) {
            addCriterion("OTHERPROTOCOL_NO <=", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoLike(String value) {
            addCriterion("OTHERPROTOCOL_NO like", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoNotLike(String value) {
            addCriterion("OTHERPROTOCOL_NO not like", value, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoIn(List<String> values) {
            addCriterion("OTHERPROTOCOL_NO in", values, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoNotIn(List<String> values) {
            addCriterion("OTHERPROTOCOL_NO not in", values, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoBetween(String value1, String value2) {
            addCriterion("OTHERPROTOCOL_NO between", value1, value2, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherprotocolNoNotBetween(String value1, String value2) {
            addCriterion("OTHERPROTOCOL_NO not between", value1, value2, "otherprotocolNo");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIsNull() {
            addCriterion("LOAN_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIsNotNull() {
            addCriterion("LOAN_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPercentEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT =", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT <>", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentGreaterThan(BigDecimal value) {
            addCriterion("LOAN_PERCENT >", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT >=", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentLessThan(BigDecimal value) {
            addCriterion("LOAN_PERCENT <", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT <=", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIn(List<BigDecimal> values) {
            addCriterion("LOAN_PERCENT in", values, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_PERCENT not in", values, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PERCENT between", value1, value2, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PERCENT not between", value1, value2, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andMoniTypeIsNull() {
            addCriterion("MONI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMoniTypeIsNotNull() {
            addCriterion("MONI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniTypeEqualTo(String value) {
            addCriterion("MONI_TYPE =", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotEqualTo(String value) {
            addCriterion("MONI_TYPE <>", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeGreaterThan(String value) {
            addCriterion("MONI_TYPE >", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_TYPE >=", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeLessThan(String value) {
            addCriterion("MONI_TYPE <", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeLessThanOrEqualTo(String value) {
            addCriterion("MONI_TYPE <=", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeLike(String value) {
            addCriterion("MONI_TYPE like", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotLike(String value) {
            addCriterion("MONI_TYPE not like", value, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeIn(List<String> values) {
            addCriterion("MONI_TYPE in", values, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotIn(List<String> values) {
            addCriterion("MONI_TYPE not in", values, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeBetween(String value1, String value2) {
            addCriterion("MONI_TYPE between", value1, value2, "moniType");
            return (Criteria) this;
        }

        public Criteria andMoniTypeNotBetween(String value1, String value2) {
            addCriterion("MONI_TYPE not between", value1, value2, "moniType");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewIsNull() {
            addCriterion("LOW_PRICE_NEW is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewIsNotNull() {
            addCriterion("LOW_PRICE_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW =", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewNotEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW <>", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewGreaterThan(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW >", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW >=", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewLessThan(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW <", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE_NEW <=", value, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE_NEW in", values, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewNotIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE_NEW not in", values, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE_NEW between", value1, value2, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andLowPriceNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE_NEW not between", value1, value2, "lowPriceNew");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeIsNull() {
            addCriterion("ARRIVED_MANAGE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeIsNotNull() {
            addCriterion("ARRIVED_MANAGE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE =", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE <>", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeGreaterThan(String value) {
            addCriterion("ARRIVED_MANAGE_MODE >", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeGreaterThanOrEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE >=", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeLessThan(String value) {
            addCriterion("ARRIVED_MANAGE_MODE <", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeLessThanOrEqualTo(String value) {
            addCriterion("ARRIVED_MANAGE_MODE <=", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeLike(String value) {
            addCriterion("ARRIVED_MANAGE_MODE like", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotLike(String value) {
            addCriterion("ARRIVED_MANAGE_MODE not like", value, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeIn(List<String> values) {
            addCriterion("ARRIVED_MANAGE_MODE in", values, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotIn(List<String> values) {
            addCriterion("ARRIVED_MANAGE_MODE not in", values, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeBetween(String value1, String value2) {
            addCriterion("ARRIVED_MANAGE_MODE between", value1, value2, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andArrivedManageModeNotBetween(String value1, String value2) {
            addCriterion("ARRIVED_MANAGE_MODE not between", value1, value2, "arrivedManageMode");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagIsNull() {
            addCriterion("SELL_OFF_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagIsNotNull() {
            addCriterion("SELL_OFF_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagEqualTo(String value) {
            addCriterion("SELL_OFF_FLAG =", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagNotEqualTo(String value) {
            addCriterion("SELL_OFF_FLAG <>", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagGreaterThan(String value) {
            addCriterion("SELL_OFF_FLAG >", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SELL_OFF_FLAG >=", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagLessThan(String value) {
            addCriterion("SELL_OFF_FLAG <", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagLessThanOrEqualTo(String value) {
            addCriterion("SELL_OFF_FLAG <=", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagLike(String value) {
            addCriterion("SELL_OFF_FLAG like", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagNotLike(String value) {
            addCriterion("SELL_OFF_FLAG not like", value, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagIn(List<String> values) {
            addCriterion("SELL_OFF_FLAG in", values, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagNotIn(List<String> values) {
            addCriterion("SELL_OFF_FLAG not in", values, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagBetween(String value1, String value2) {
            addCriterion("SELL_OFF_FLAG between", value1, value2, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andSellOffFlagNotBetween(String value1, String value2) {
            addCriterion("SELL_OFF_FLAG not between", value1, value2, "sellOffFlag");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateIsNull() {
            addCriterion("PRICE_DROP_RATE is null");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateIsNotNull() {
            addCriterion("PRICE_DROP_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE =", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateNotEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE <>", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateGreaterThan(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE >", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE >=", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateLessThan(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE <", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_DROP_RATE <=", value, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateIn(List<BigDecimal> values) {
            addCriterion("PRICE_DROP_RATE in", values, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateNotIn(List<BigDecimal> values) {
            addCriterion("PRICE_DROP_RATE not in", values, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_DROP_RATE between", value1, value2, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andPriceDropRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_DROP_RATE not between", value1, value2, "priceDropRate");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIsNull() {
            addCriterion("COOPERATION_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIsNotNull() {
            addCriterion("COOPERATION_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE =", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE <>", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeGreaterThan(String value) {
            addCriterion("COOPERATION_BRCODE >", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE >=", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLessThan(String value) {
            addCriterion("COOPERATION_BRCODE <", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLessThanOrEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE <=", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLike(String value) {
            addCriterion("COOPERATION_BRCODE like", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotLike(String value) {
            addCriterion("COOPERATION_BRCODE not like", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIn(List<String> values) {
            addCriterion("COOPERATION_BRCODE in", values, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotIn(List<String> values) {
            addCriterion("COOPERATION_BRCODE not in", values, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeBetween(String value1, String value2) {
            addCriterion("COOPERATION_BRCODE between", value1, value2, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotBetween(String value1, String value2) {
            addCriterion("COOPERATION_BRCODE not between", value1, value2, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagIsNull() {
            addCriterion("CIRCLE_LOAN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagIsNotNull() {
            addCriterion("CIRCLE_LOAN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagEqualTo(String value) {
            addCriterion("CIRCLE_LOAN_FLAG =", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagNotEqualTo(String value) {
            addCriterion("CIRCLE_LOAN_FLAG <>", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagGreaterThan(String value) {
            addCriterion("CIRCLE_LOAN_FLAG >", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CIRCLE_LOAN_FLAG >=", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagLessThan(String value) {
            addCriterion("CIRCLE_LOAN_FLAG <", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagLessThanOrEqualTo(String value) {
            addCriterion("CIRCLE_LOAN_FLAG <=", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagLike(String value) {
            addCriterion("CIRCLE_LOAN_FLAG like", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagNotLike(String value) {
            addCriterion("CIRCLE_LOAN_FLAG not like", value, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagIn(List<String> values) {
            addCriterion("CIRCLE_LOAN_FLAG in", values, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagNotIn(List<String> values) {
            addCriterion("CIRCLE_LOAN_FLAG not in", values, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagBetween(String value1, String value2) {
            addCriterion("CIRCLE_LOAN_FLAG between", value1, value2, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andCircleLoanFlagNotBetween(String value1, String value2) {
            addCriterion("CIRCLE_LOAN_FLAG not between", value1, value2, "circleLoanFlag");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeIsNull() {
            addCriterion("TRIPLE_PROTOCOL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeIsNotNull() {
            addCriterion("TRIPLE_PROTOCOL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeEqualTo(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE =", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeNotEqualTo(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE <>", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeGreaterThan(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE >", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE >=", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeLessThan(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE <", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeLessThanOrEqualTo(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE <=", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeLike(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE like", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeNotLike(String value) {
            addCriterion("TRIPLE_PROTOCOL_TYPE not like", value, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeIn(List<String> values) {
            addCriterion("TRIPLE_PROTOCOL_TYPE in", values, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeNotIn(List<String> values) {
            addCriterion("TRIPLE_PROTOCOL_TYPE not in", values, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeBetween(String value1, String value2) {
            addCriterion("TRIPLE_PROTOCOL_TYPE between", value1, value2, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andTripleProtocolTypeNotBetween(String value1, String value2) {
            addCriterion("TRIPLE_PROTOCOL_TYPE not between", value1, value2, "tripleProtocolType");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeIsNull() {
            addCriterion("DELIVERY_MODE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeIsNotNull() {
            addCriterion("DELIVERY_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeEqualTo(String value) {
            addCriterion("DELIVERY_MODE =", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotEqualTo(String value) {
            addCriterion("DELIVERY_MODE <>", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeGreaterThan(String value) {
            addCriterion("DELIVERY_MODE >", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_MODE >=", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeLessThan(String value) {
            addCriterion("DELIVERY_MODE <", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_MODE <=", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeLike(String value) {
            addCriterion("DELIVERY_MODE like", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotLike(String value) {
            addCriterion("DELIVERY_MODE not like", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeIn(List<String> values) {
            addCriterion("DELIVERY_MODE in", values, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotIn(List<String> values) {
            addCriterion("DELIVERY_MODE not in", values, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeBetween(String value1, String value2) {
            addCriterion("DELIVERY_MODE between", value1, value2, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_MODE not between", value1, value2, "deliveryMode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}