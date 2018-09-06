package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrDuebillAppExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrDuebillAppExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrDuebillAppExample(BCrrDuebillAppExample example) {
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

        public Criteria andLnNoIsNull() {
            addCriterion("LN_NO is null");
            return (Criteria) this;
        }

        public Criteria andLnNoIsNotNull() {
            addCriterion("LN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLnNoEqualTo(String value) {
            addCriterion("LN_NO =", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoNotEqualTo(String value) {
            addCriterion("LN_NO <>", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoGreaterThan(String value) {
            addCriterion("LN_NO >", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoGreaterThanOrEqualTo(String value) {
            addCriterion("LN_NO >=", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoLessThan(String value) {
            addCriterion("LN_NO <", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoLessThanOrEqualTo(String value) {
            addCriterion("LN_NO <=", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoLike(String value) {
            addCriterion("LN_NO like", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoNotLike(String value) {
            addCriterion("LN_NO not like", value, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoIn(List<String> values) {
            addCriterion("LN_NO in", values, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoNotIn(List<String> values) {
            addCriterion("LN_NO not in", values, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoBetween(String value1, String value2) {
            addCriterion("LN_NO between", value1, value2, "lnNo");
            return (Criteria) this;
        }

        public Criteria andLnNoNotBetween(String value1, String value2) {
            addCriterion("LN_NO not between", value1, value2, "lnNo");
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

        public Criteria andIsDtIsNull() {
            addCriterion("IS_DT is null");
            return (Criteria) this;
        }

        public Criteria andIsDtIsNotNull() {
            addCriterion("IS_DT is not null");
            return (Criteria) this;
        }

        public Criteria andIsDtEqualTo(String value) {
            addCriterion("IS_DT =", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtNotEqualTo(String value) {
            addCriterion("IS_DT <>", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtGreaterThan(String value) {
            addCriterion("IS_DT >", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DT >=", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtLessThan(String value) {
            addCriterion("IS_DT <", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtLessThanOrEqualTo(String value) {
            addCriterion("IS_DT <=", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtLike(String value) {
            addCriterion("IS_DT like", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtNotLike(String value) {
            addCriterion("IS_DT not like", value, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtIn(List<String> values) {
            addCriterion("IS_DT in", values, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtNotIn(List<String> values) {
            addCriterion("IS_DT not in", values, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtBetween(String value1, String value2) {
            addCriterion("IS_DT between", value1, value2, "isDt");
            return (Criteria) this;
        }

        public Criteria andIsDtNotBetween(String value1, String value2) {
            addCriterion("IS_DT not between", value1, value2, "isDt");
            return (Criteria) this;
        }

        public Criteria andTeDtIsNull() {
            addCriterion("TE_DT is null");
            return (Criteria) this;
        }

        public Criteria andTeDtIsNotNull() {
            addCriterion("TE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andTeDtEqualTo(String value) {
            addCriterion("TE_DT =", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtNotEqualTo(String value) {
            addCriterion("TE_DT <>", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtGreaterThan(String value) {
            addCriterion("TE_DT >", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtGreaterThanOrEqualTo(String value) {
            addCriterion("TE_DT >=", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtLessThan(String value) {
            addCriterion("TE_DT <", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtLessThanOrEqualTo(String value) {
            addCriterion("TE_DT <=", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtLike(String value) {
            addCriterion("TE_DT like", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtNotLike(String value) {
            addCriterion("TE_DT not like", value, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtIn(List<String> values) {
            addCriterion("TE_DT in", values, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtNotIn(List<String> values) {
            addCriterion("TE_DT not in", values, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtBetween(String value1, String value2) {
            addCriterion("TE_DT between", value1, value2, "teDt");
            return (Criteria) this;
        }

        public Criteria andTeDtNotBetween(String value1, String value2) {
            addCriterion("TE_DT not between", value1, value2, "teDt");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypIsNull() {
            addCriterion("TRM_CTL_TYP is null");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypIsNotNull() {
            addCriterion("TRM_CTL_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypEqualTo(String value) {
            addCriterion("TRM_CTL_TYP =", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypNotEqualTo(String value) {
            addCriterion("TRM_CTL_TYP <>", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypGreaterThan(String value) {
            addCriterion("TRM_CTL_TYP >", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypGreaterThanOrEqualTo(String value) {
            addCriterion("TRM_CTL_TYP >=", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypLessThan(String value) {
            addCriterion("TRM_CTL_TYP <", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypLessThanOrEqualTo(String value) {
            addCriterion("TRM_CTL_TYP <=", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypLike(String value) {
            addCriterion("TRM_CTL_TYP like", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypNotLike(String value) {
            addCriterion("TRM_CTL_TYP not like", value, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypIn(List<String> values) {
            addCriterion("TRM_CTL_TYP in", values, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypNotIn(List<String> values) {
            addCriterion("TRM_CTL_TYP not in", values, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypBetween(String value1, String value2) {
            addCriterion("TRM_CTL_TYP between", value1, value2, "trmCtlTyp");
            return (Criteria) this;
        }

        public Criteria andTrmCtlTypNotBetween(String value1, String value2) {
            addCriterion("TRM_CTL_TYP not between", value1, value2, "trmCtlTyp");
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

        public Criteria andTrmRgeIsNull() {
            addCriterion("TRM_RGE is null");
            return (Criteria) this;
        }

        public Criteria andTrmRgeIsNotNull() {
            addCriterion("TRM_RGE is not null");
            return (Criteria) this;
        }

        public Criteria andTrmRgeEqualTo(String value) {
            addCriterion("TRM_RGE =", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeNotEqualTo(String value) {
            addCriterion("TRM_RGE <>", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeGreaterThan(String value) {
            addCriterion("TRM_RGE >", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeGreaterThanOrEqualTo(String value) {
            addCriterion("TRM_RGE >=", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeLessThan(String value) {
            addCriterion("TRM_RGE <", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeLessThanOrEqualTo(String value) {
            addCriterion("TRM_RGE <=", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeLike(String value) {
            addCriterion("TRM_RGE like", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeNotLike(String value) {
            addCriterion("TRM_RGE not like", value, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeIn(List<String> values) {
            addCriterion("TRM_RGE in", values, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeNotIn(List<String> values) {
            addCriterion("TRM_RGE not in", values, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeBetween(String value1, String value2) {
            addCriterion("TRM_RGE between", value1, value2, "trmRge");
            return (Criteria) this;
        }

        public Criteria andTrmRgeNotBetween(String value1, String value2) {
            addCriterion("TRM_RGE not between", value1, value2, "trmRge");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlIsNull() {
            addCriterion("PER_ADJ_EQL is null");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlIsNotNull() {
            addCriterion("PER_ADJ_EQL is not null");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlEqualTo(BigDecimal value) {
            addCriterion("PER_ADJ_EQL =", value, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlNotEqualTo(BigDecimal value) {
            addCriterion("PER_ADJ_EQL <>", value, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlGreaterThan(BigDecimal value) {
            addCriterion("PER_ADJ_EQL >", value, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PER_ADJ_EQL >=", value, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlLessThan(BigDecimal value) {
            addCriterion("PER_ADJ_EQL <", value, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PER_ADJ_EQL <=", value, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlIn(List<BigDecimal> values) {
            addCriterion("PER_ADJ_EQL in", values, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlNotIn(List<BigDecimal> values) {
            addCriterion("PER_ADJ_EQL not in", values, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PER_ADJ_EQL between", value1, value2, "perAdjEql");
            return (Criteria) this;
        }

        public Criteria andPerAdjEqlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PER_ADJ_EQL not between", value1, value2, "perAdjEql");
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

        public Criteria andNonEqlMdIsNull() {
            addCriterion("NON_EQL_MD is null");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdIsNotNull() {
            addCriterion("NON_EQL_MD is not null");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdEqualTo(String value) {
            addCriterion("NON_EQL_MD =", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdNotEqualTo(String value) {
            addCriterion("NON_EQL_MD <>", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdGreaterThan(String value) {
            addCriterion("NON_EQL_MD >", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdGreaterThanOrEqualTo(String value) {
            addCriterion("NON_EQL_MD >=", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdLessThan(String value) {
            addCriterion("NON_EQL_MD <", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdLessThanOrEqualTo(String value) {
            addCriterion("NON_EQL_MD <=", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdLike(String value) {
            addCriterion("NON_EQL_MD like", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdNotLike(String value) {
            addCriterion("NON_EQL_MD not like", value, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdIn(List<String> values) {
            addCriterion("NON_EQL_MD in", values, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdNotIn(List<String> values) {
            addCriterion("NON_EQL_MD not in", values, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdBetween(String value1, String value2) {
            addCriterion("NON_EQL_MD between", value1, value2, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlMdNotBetween(String value1, String value2) {
            addCriterion("NON_EQL_MD not between", value1, value2, "nonEqlMd");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtIsNull() {
            addCriterion("NON_EQL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtIsNotNull() {
            addCriterion("NON_EQL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtEqualTo(BigDecimal value) {
            addCriterion("NON_EQL_AMT =", value, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtNotEqualTo(BigDecimal value) {
            addCriterion("NON_EQL_AMT <>", value, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtGreaterThan(BigDecimal value) {
            addCriterion("NON_EQL_AMT >", value, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NON_EQL_AMT >=", value, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtLessThan(BigDecimal value) {
            addCriterion("NON_EQL_AMT <", value, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NON_EQL_AMT <=", value, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtIn(List<BigDecimal> values) {
            addCriterion("NON_EQL_AMT in", values, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtNotIn(List<BigDecimal> values) {
            addCriterion("NON_EQL_AMT not in", values, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NON_EQL_AMT between", value1, value2, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andNonEqlAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NON_EQL_AMT not between", value1, value2, "nonEqlAmt");
            return (Criteria) this;
        }

        public Criteria andRtnMdIsNull() {
            addCriterion("RTN_MD is null");
            return (Criteria) this;
        }

        public Criteria andRtnMdIsNotNull() {
            addCriterion("RTN_MD is not null");
            return (Criteria) this;
        }

        public Criteria andRtnMdEqualTo(String value) {
            addCriterion("RTN_MD =", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdNotEqualTo(String value) {
            addCriterion("RTN_MD <>", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdGreaterThan(String value) {
            addCriterion("RTN_MD >", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_MD >=", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdLessThan(String value) {
            addCriterion("RTN_MD <", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdLessThanOrEqualTo(String value) {
            addCriterion("RTN_MD <=", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdLike(String value) {
            addCriterion("RTN_MD like", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdNotLike(String value) {
            addCriterion("RTN_MD not like", value, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdIn(List<String> values) {
            addCriterion("RTN_MD in", values, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdNotIn(List<String> values) {
            addCriterion("RTN_MD not in", values, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdBetween(String value1, String value2) {
            addCriterion("RTN_MD between", value1, value2, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnMdNotBetween(String value1, String value2) {
            addCriterion("RTN_MD not between", value1, value2, "rtnMd");
            return (Criteria) this;
        }

        public Criteria andRtnNoIsNull() {
            addCriterion("RTN_NO is null");
            return (Criteria) this;
        }

        public Criteria andRtnNoIsNotNull() {
            addCriterion("RTN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRtnNoEqualTo(String value) {
            addCriterion("RTN_NO =", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoNotEqualTo(String value) {
            addCriterion("RTN_NO <>", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoGreaterThan(String value) {
            addCriterion("RTN_NO >", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_NO >=", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoLessThan(String value) {
            addCriterion("RTN_NO <", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoLessThanOrEqualTo(String value) {
            addCriterion("RTN_NO <=", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoLike(String value) {
            addCriterion("RTN_NO like", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoNotLike(String value) {
            addCriterion("RTN_NO not like", value, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoIn(List<String> values) {
            addCriterion("RTN_NO in", values, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoNotIn(List<String> values) {
            addCriterion("RTN_NO not in", values, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoBetween(String value1, String value2) {
            addCriterion("RTN_NO between", value1, value2, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnNoNotBetween(String value1, String value2) {
            addCriterion("RTN_NO not between", value1, value2, "rtnNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoIsNull() {
            addCriterion("RTN_ACT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRtnActNoIsNotNull() {
            addCriterion("RTN_ACT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRtnActNoEqualTo(String value) {
            addCriterion("RTN_ACT_NO =", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoNotEqualTo(String value) {
            addCriterion("RTN_ACT_NO <>", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoGreaterThan(String value) {
            addCriterion("RTN_ACT_NO >", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_ACT_NO >=", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoLessThan(String value) {
            addCriterion("RTN_ACT_NO <", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoLessThanOrEqualTo(String value) {
            addCriterion("RTN_ACT_NO <=", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoLike(String value) {
            addCriterion("RTN_ACT_NO like", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoNotLike(String value) {
            addCriterion("RTN_ACT_NO not like", value, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoIn(List<String> values) {
            addCriterion("RTN_ACT_NO in", values, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoNotIn(List<String> values) {
            addCriterion("RTN_ACT_NO not in", values, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoBetween(String value1, String value2) {
            addCriterion("RTN_ACT_NO between", value1, value2, "rtnActNo");
            return (Criteria) this;
        }

        public Criteria andRtnActNoNotBetween(String value1, String value2) {
            addCriterion("RTN_ACT_NO not between", value1, value2, "rtnActNo");
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

        public Criteria andPhsFlgIsNull() {
            addCriterion("PHS_FLG is null");
            return (Criteria) this;
        }

        public Criteria andPhsFlgIsNotNull() {
            addCriterion("PHS_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andPhsFlgEqualTo(String value) {
            addCriterion("PHS_FLG =", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgNotEqualTo(String value) {
            addCriterion("PHS_FLG <>", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgGreaterThan(String value) {
            addCriterion("PHS_FLG >", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgGreaterThanOrEqualTo(String value) {
            addCriterion("PHS_FLG >=", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgLessThan(String value) {
            addCriterion("PHS_FLG <", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgLessThanOrEqualTo(String value) {
            addCriterion("PHS_FLG <=", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgLike(String value) {
            addCriterion("PHS_FLG like", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgNotLike(String value) {
            addCriterion("PHS_FLG not like", value, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgIn(List<String> values) {
            addCriterion("PHS_FLG in", values, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgNotIn(List<String> values) {
            addCriterion("PHS_FLG not in", values, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgBetween(String value1, String value2) {
            addCriterion("PHS_FLG between", value1, value2, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsFlgNotBetween(String value1, String value2) {
            addCriterion("PHS_FLG not between", value1, value2, "phsFlg");
            return (Criteria) this;
        }

        public Criteria andPhsNoIsNull() {
            addCriterion("PHS_NO is null");
            return (Criteria) this;
        }

        public Criteria andPhsNoIsNotNull() {
            addCriterion("PHS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPhsNoEqualTo(BigDecimal value) {
            addCriterion("PHS_NO =", value, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoNotEqualTo(BigDecimal value) {
            addCriterion("PHS_NO <>", value, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoGreaterThan(BigDecimal value) {
            addCriterion("PHS_NO >", value, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PHS_NO >=", value, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoLessThan(BigDecimal value) {
            addCriterion("PHS_NO <", value, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PHS_NO <=", value, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoIn(List<BigDecimal> values) {
            addCriterion("PHS_NO in", values, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoNotIn(List<BigDecimal> values) {
            addCriterion("PHS_NO not in", values, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PHS_NO between", value1, value2, "phsNo");
            return (Criteria) this;
        }

        public Criteria andPhsNoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PHS_NO not between", value1, value2, "phsNo");
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

        public Criteria andRatDtIsNull() {
            addCriterion("RAT_DT is null");
            return (Criteria) this;
        }

        public Criteria andRatDtIsNotNull() {
            addCriterion("RAT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andRatDtEqualTo(String value) {
            addCriterion("RAT_DT =", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtNotEqualTo(String value) {
            addCriterion("RAT_DT <>", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtGreaterThan(String value) {
            addCriterion("RAT_DT >", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtGreaterThanOrEqualTo(String value) {
            addCriterion("RAT_DT >=", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtLessThan(String value) {
            addCriterion("RAT_DT <", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtLessThanOrEqualTo(String value) {
            addCriterion("RAT_DT <=", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtLike(String value) {
            addCriterion("RAT_DT like", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtNotLike(String value) {
            addCriterion("RAT_DT not like", value, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtIn(List<String> values) {
            addCriterion("RAT_DT in", values, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtNotIn(List<String> values) {
            addCriterion("RAT_DT not in", values, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtBetween(String value1, String value2) {
            addCriterion("RAT_DT between", value1, value2, "ratDt");
            return (Criteria) this;
        }

        public Criteria andRatDtNotBetween(String value1, String value2) {
            addCriterion("RAT_DT not between", value1, value2, "ratDt");
            return (Criteria) this;
        }

        public Criteria andFltIntIsNull() {
            addCriterion("FLT_INT is null");
            return (Criteria) this;
        }

        public Criteria andFltIntIsNotNull() {
            addCriterion("FLT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andFltIntEqualTo(BigDecimal value) {
            addCriterion("FLT_INT =", value, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntNotEqualTo(BigDecimal value) {
            addCriterion("FLT_INT <>", value, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntGreaterThan(BigDecimal value) {
            addCriterion("FLT_INT >", value, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLT_INT >=", value, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntLessThan(BigDecimal value) {
            addCriterion("FLT_INT <", value, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLT_INT <=", value, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntIn(List<BigDecimal> values) {
            addCriterion("FLT_INT in", values, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntNotIn(List<BigDecimal> values) {
            addCriterion("FLT_INT not in", values, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLT_INT between", value1, value2, "fltInt");
            return (Criteria) this;
        }

        public Criteria andFltIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLT_INT not between", value1, value2, "fltInt");
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

        public Criteria andMispPfltOptIsNull() {
            addCriterion("MISP_PFLT_OPT is null");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptIsNotNull() {
            addCriterion("MISP_PFLT_OPT is not null");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptEqualTo(String value) {
            addCriterion("MISP_PFLT_OPT =", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptNotEqualTo(String value) {
            addCriterion("MISP_PFLT_OPT <>", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptGreaterThan(String value) {
            addCriterion("MISP_PFLT_OPT >", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptGreaterThanOrEqualTo(String value) {
            addCriterion("MISP_PFLT_OPT >=", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptLessThan(String value) {
            addCriterion("MISP_PFLT_OPT <", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptLessThanOrEqualTo(String value) {
            addCriterion("MISP_PFLT_OPT <=", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptLike(String value) {
            addCriterion("MISP_PFLT_OPT like", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptNotLike(String value) {
            addCriterion("MISP_PFLT_OPT not like", value, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptIn(List<String> values) {
            addCriterion("MISP_PFLT_OPT in", values, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptNotIn(List<String> values) {
            addCriterion("MISP_PFLT_OPT not in", values, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptBetween(String value1, String value2) {
            addCriterion("MISP_PFLT_OPT between", value1, value2, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltOptNotBetween(String value1, String value2) {
            addCriterion("MISP_PFLT_OPT not between", value1, value2, "mispPfltOpt");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdIsNull() {
            addCriterion("MISP_PFLT_CD is null");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdIsNotNull() {
            addCriterion("MISP_PFLT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdEqualTo(String value) {
            addCriterion("MISP_PFLT_CD =", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdNotEqualTo(String value) {
            addCriterion("MISP_PFLT_CD <>", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdGreaterThan(String value) {
            addCriterion("MISP_PFLT_CD >", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdGreaterThanOrEqualTo(String value) {
            addCriterion("MISP_PFLT_CD >=", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdLessThan(String value) {
            addCriterion("MISP_PFLT_CD <", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdLessThanOrEqualTo(String value) {
            addCriterion("MISP_PFLT_CD <=", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdLike(String value) {
            addCriterion("MISP_PFLT_CD like", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdNotLike(String value) {
            addCriterion("MISP_PFLT_CD not like", value, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdIn(List<String> values) {
            addCriterion("MISP_PFLT_CD in", values, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdNotIn(List<String> values) {
            addCriterion("MISP_PFLT_CD not in", values, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdBetween(String value1, String value2) {
            addCriterion("MISP_PFLT_CD between", value1, value2, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltCdNotBetween(String value1, String value2) {
            addCriterion("MISP_PFLT_CD not between", value1, value2, "mispPfltCd");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltIsNull() {
            addCriterion("MISP_PFLT_FLT is null");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltIsNotNull() {
            addCriterion("MISP_PFLT_FLT is not null");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_FLT =", value, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltNotEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_FLT <>", value, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltGreaterThan(BigDecimal value) {
            addCriterion("MISP_PFLT_FLT >", value, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_FLT >=", value, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltLessThan(BigDecimal value) {
            addCriterion("MISP_PFLT_FLT <", value, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_FLT <=", value, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltIn(List<BigDecimal> values) {
            addCriterion("MISP_PFLT_FLT in", values, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltNotIn(List<BigDecimal> values) {
            addCriterion("MISP_PFLT_FLT not in", values, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MISP_PFLT_FLT between", value1, value2, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltFltNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MISP_PFLT_FLT not between", value1, value2, "mispPfltFlt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntIsNull() {
            addCriterion("MISP_PFLT_INT is null");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntIsNotNull() {
            addCriterion("MISP_PFLT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_INT =", value, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntNotEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_INT <>", value, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntGreaterThan(BigDecimal value) {
            addCriterion("MISP_PFLT_INT >", value, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_INT >=", value, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntLessThan(BigDecimal value) {
            addCriterion("MISP_PFLT_INT <", value, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MISP_PFLT_INT <=", value, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntIn(List<BigDecimal> values) {
            addCriterion("MISP_PFLT_INT in", values, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntNotIn(List<BigDecimal> values) {
            addCriterion("MISP_PFLT_INT not in", values, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MISP_PFLT_INT between", value1, value2, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andMispPfltIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MISP_PFLT_INT not between", value1, value2, "mispPfltInt");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypIsNull() {
            addCriterion("OVD_RAT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypIsNotNull() {
            addCriterion("OVD_RAT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypEqualTo(String value) {
            addCriterion("OVD_RAT_TYP =", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypNotEqualTo(String value) {
            addCriterion("OVD_RAT_TYP <>", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypGreaterThan(String value) {
            addCriterion("OVD_RAT_TYP >", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypGreaterThanOrEqualTo(String value) {
            addCriterion("OVD_RAT_TYP >=", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypLessThan(String value) {
            addCriterion("OVD_RAT_TYP <", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypLessThanOrEqualTo(String value) {
            addCriterion("OVD_RAT_TYP <=", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypLike(String value) {
            addCriterion("OVD_RAT_TYP like", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypNotLike(String value) {
            addCriterion("OVD_RAT_TYP not like", value, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypIn(List<String> values) {
            addCriterion("OVD_RAT_TYP in", values, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypNotIn(List<String> values) {
            addCriterion("OVD_RAT_TYP not in", values, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypBetween(String value1, String value2) {
            addCriterion("OVD_RAT_TYP between", value1, value2, "ovdRatTyp");
            return (Criteria) this;
        }

        public Criteria andOvdRatTypNotBetween(String value1, String value2) {
            addCriterion("OVD_RAT_TYP not between", value1, value2, "ovdRatTyp");
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

        public Criteria andPayDrctIsNull() {
            addCriterion("PAY_DRCT is null");
            return (Criteria) this;
        }

        public Criteria andPayDrctIsNotNull() {
            addCriterion("PAY_DRCT is not null");
            return (Criteria) this;
        }

        public Criteria andPayDrctEqualTo(String value) {
            addCriterion("PAY_DRCT =", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctNotEqualTo(String value) {
            addCriterion("PAY_DRCT <>", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctGreaterThan(String value) {
            addCriterion("PAY_DRCT >", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_DRCT >=", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctLessThan(String value) {
            addCriterion("PAY_DRCT <", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctLessThanOrEqualTo(String value) {
            addCriterion("PAY_DRCT <=", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctLike(String value) {
            addCriterion("PAY_DRCT like", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctNotLike(String value) {
            addCriterion("PAY_DRCT not like", value, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctIn(List<String> values) {
            addCriterion("PAY_DRCT in", values, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctNotIn(List<String> values) {
            addCriterion("PAY_DRCT not in", values, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctBetween(String value1, String value2) {
            addCriterion("PAY_DRCT between", value1, value2, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayDrctNotBetween(String value1, String value2) {
            addCriterion("PAY_DRCT not between", value1, value2, "payDrct");
            return (Criteria) this;
        }

        public Criteria andPayMdIsNull() {
            addCriterion("PAY_MD is null");
            return (Criteria) this;
        }

        public Criteria andPayMdIsNotNull() {
            addCriterion("PAY_MD is not null");
            return (Criteria) this;
        }

        public Criteria andPayMdEqualTo(String value) {
            addCriterion("PAY_MD =", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdNotEqualTo(String value) {
            addCriterion("PAY_MD <>", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdGreaterThan(String value) {
            addCriterion("PAY_MD >", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_MD >=", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdLessThan(String value) {
            addCriterion("PAY_MD <", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdLessThanOrEqualTo(String value) {
            addCriterion("PAY_MD <=", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdLike(String value) {
            addCriterion("PAY_MD like", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdNotLike(String value) {
            addCriterion("PAY_MD not like", value, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdIn(List<String> values) {
            addCriterion("PAY_MD in", values, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdNotIn(List<String> values) {
            addCriterion("PAY_MD not in", values, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdBetween(String value1, String value2) {
            addCriterion("PAY_MD between", value1, value2, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayMdNotBetween(String value1, String value2) {
            addCriterion("PAY_MD not between", value1, value2, "payMd");
            return (Criteria) this;
        }

        public Criteria andPayCdNoIsNull() {
            addCriterion("PAY_CD_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayCdNoIsNotNull() {
            addCriterion("PAY_CD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayCdNoEqualTo(String value) {
            addCriterion("PAY_CD_NO =", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoNotEqualTo(String value) {
            addCriterion("PAY_CD_NO <>", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoGreaterThan(String value) {
            addCriterion("PAY_CD_NO >", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_CD_NO >=", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoLessThan(String value) {
            addCriterion("PAY_CD_NO <", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoLessThanOrEqualTo(String value) {
            addCriterion("PAY_CD_NO <=", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoLike(String value) {
            addCriterion("PAY_CD_NO like", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoNotLike(String value) {
            addCriterion("PAY_CD_NO not like", value, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoIn(List<String> values) {
            addCriterion("PAY_CD_NO in", values, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoNotIn(List<String> values) {
            addCriterion("PAY_CD_NO not in", values, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoBetween(String value1, String value2) {
            addCriterion("PAY_CD_NO between", value1, value2, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayCdNoNotBetween(String value1, String value2) {
            addCriterion("PAY_CD_NO not between", value1, value2, "payCdNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoIsNull() {
            addCriterion("PAY_ACT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayActNoIsNotNull() {
            addCriterion("PAY_ACT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayActNoEqualTo(String value) {
            addCriterion("PAY_ACT_NO =", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotEqualTo(String value) {
            addCriterion("PAY_ACT_NO <>", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoGreaterThan(String value) {
            addCriterion("PAY_ACT_NO >", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_ACT_NO >=", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoLessThan(String value) {
            addCriterion("PAY_ACT_NO <", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoLessThanOrEqualTo(String value) {
            addCriterion("PAY_ACT_NO <=", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoLike(String value) {
            addCriterion("PAY_ACT_NO like", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotLike(String value) {
            addCriterion("PAY_ACT_NO not like", value, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoIn(List<String> values) {
            addCriterion("PAY_ACT_NO in", values, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotIn(List<String> values) {
            addCriterion("PAY_ACT_NO not in", values, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoBetween(String value1, String value2) {
            addCriterion("PAY_ACT_NO between", value1, value2, "payActNo");
            return (Criteria) this;
        }

        public Criteria andPayActNoNotBetween(String value1, String value2) {
            addCriterion("PAY_ACT_NO not between", value1, value2, "payActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoIsNull() {
            addCriterion("BAIL_ACT_NO is null");
            return (Criteria) this;
        }

        public Criteria andBailActNoIsNotNull() {
            addCriterion("BAIL_ACT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBailActNoEqualTo(String value) {
            addCriterion("BAIL_ACT_NO =", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoNotEqualTo(String value) {
            addCriterion("BAIL_ACT_NO <>", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoGreaterThan(String value) {
            addCriterion("BAIL_ACT_NO >", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACT_NO >=", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoLessThan(String value) {
            addCriterion("BAIL_ACT_NO <", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACT_NO <=", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoLike(String value) {
            addCriterion("BAIL_ACT_NO like", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoNotLike(String value) {
            addCriterion("BAIL_ACT_NO not like", value, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoIn(List<String> values) {
            addCriterion("BAIL_ACT_NO in", values, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoNotIn(List<String> values) {
            addCriterion("BAIL_ACT_NO not in", values, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoBetween(String value1, String value2) {
            addCriterion("BAIL_ACT_NO between", value1, value2, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailActNoNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACT_NO not between", value1, value2, "bailActNo");
            return (Criteria) this;
        }

        public Criteria andBailRatIsNull() {
            addCriterion("BAIL_RAT is null");
            return (Criteria) this;
        }

        public Criteria andBailRatIsNotNull() {
            addCriterion("BAIL_RAT is not null");
            return (Criteria) this;
        }

        public Criteria andBailRatEqualTo(BigDecimal value) {
            addCriterion("BAIL_RAT =", value, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_RAT <>", value, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatGreaterThan(BigDecimal value) {
            addCriterion("BAIL_RAT >", value, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RAT >=", value, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatLessThan(BigDecimal value) {
            addCriterion("BAIL_RAT <", value, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RAT <=", value, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatIn(List<BigDecimal> values) {
            addCriterion("BAIL_RAT in", values, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_RAT not in", values, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RAT between", value1, value2, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailRatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RAT not between", value1, value2, "bailRat");
            return (Criteria) this;
        }

        public Criteria andBailAmtIsNull() {
            addCriterion("BAIL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBailAmtIsNotNull() {
            addCriterion("BAIL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBailAmtEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT =", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT <>", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtGreaterThan(BigDecimal value) {
            addCriterion("BAIL_AMT >", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT >=", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtLessThan(BigDecimal value) {
            addCriterion("BAIL_AMT <", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT <=", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMT in", values, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMT not in", values, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMT between", value1, value2, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMT not between", value1, value2, "bailAmt");
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

        public Criteria andRtnNo2IsNull() {
            addCriterion("RTN_NO2 is null");
            return (Criteria) this;
        }

        public Criteria andRtnNo2IsNotNull() {
            addCriterion("RTN_NO2 is not null");
            return (Criteria) this;
        }

        public Criteria andRtnNo2EqualTo(String value) {
            addCriterion("RTN_NO2 =", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2NotEqualTo(String value) {
            addCriterion("RTN_NO2 <>", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2GreaterThan(String value) {
            addCriterion("RTN_NO2 >", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2GreaterThanOrEqualTo(String value) {
            addCriterion("RTN_NO2 >=", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2LessThan(String value) {
            addCriterion("RTN_NO2 <", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2LessThanOrEqualTo(String value) {
            addCriterion("RTN_NO2 <=", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2Like(String value) {
            addCriterion("RTN_NO2 like", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2NotLike(String value) {
            addCriterion("RTN_NO2 not like", value, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2In(List<String> values) {
            addCriterion("RTN_NO2 in", values, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2NotIn(List<String> values) {
            addCriterion("RTN_NO2 not in", values, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2Between(String value1, String value2) {
            addCriterion("RTN_NO2 between", value1, value2, "rtnNo2");
            return (Criteria) this;
        }

        public Criteria andRtnNo2NotBetween(String value1, String value2) {
            addCriterion("RTN_NO2 not between", value1, value2, "rtnNo2");
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

        public Criteria andPfltIntMdIsNull() {
            addCriterion("PFLT_INT_MD is null");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdIsNotNull() {
            addCriterion("PFLT_INT_MD is not null");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdEqualTo(String value) {
            addCriterion("PFLT_INT_MD =", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdNotEqualTo(String value) {
            addCriterion("PFLT_INT_MD <>", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdGreaterThan(String value) {
            addCriterion("PFLT_INT_MD >", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdGreaterThanOrEqualTo(String value) {
            addCriterion("PFLT_INT_MD >=", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdLessThan(String value) {
            addCriterion("PFLT_INT_MD <", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdLessThanOrEqualTo(String value) {
            addCriterion("PFLT_INT_MD <=", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdLike(String value) {
            addCriterion("PFLT_INT_MD like", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdNotLike(String value) {
            addCriterion("PFLT_INT_MD not like", value, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdIn(List<String> values) {
            addCriterion("PFLT_INT_MD in", values, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdNotIn(List<String> values) {
            addCriterion("PFLT_INT_MD not in", values, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdBetween(String value1, String value2) {
            addCriterion("PFLT_INT_MD between", value1, value2, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntMdNotBetween(String value1, String value2) {
            addCriterion("PFLT_INT_MD not between", value1, value2, "pfltIntMd");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtIsNull() {
            addCriterion("PFLT_INT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtIsNotNull() {
            addCriterion("PFLT_INT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT_AMT =", value, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtNotEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT_AMT <>", value, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtGreaterThan(BigDecimal value) {
            addCriterion("PFLT_INT_AMT >", value, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT_AMT >=", value, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtLessThan(BigDecimal value) {
            addCriterion("PFLT_INT_AMT <", value, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFLT_INT_AMT <=", value, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtIn(List<BigDecimal> values) {
            addCriterion("PFLT_INT_AMT in", values, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtNotIn(List<BigDecimal> values) {
            addCriterion("PFLT_INT_AMT not in", values, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFLT_INT_AMT between", value1, value2, "pfltIntAmt");
            return (Criteria) this;
        }

        public Criteria andPfltIntAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFLT_INT_AMT not between", value1, value2, "pfltIntAmt");
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

        public Criteria andWrtNoIsNull() {
            addCriterion("WRT_NO is null");
            return (Criteria) this;
        }

        public Criteria andWrtNoIsNotNull() {
            addCriterion("WRT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWrtNoEqualTo(String value) {
            addCriterion("WRT_NO =", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoNotEqualTo(String value) {
            addCriterion("WRT_NO <>", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoGreaterThan(String value) {
            addCriterion("WRT_NO >", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoGreaterThanOrEqualTo(String value) {
            addCriterion("WRT_NO >=", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoLessThan(String value) {
            addCriterion("WRT_NO <", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoLessThanOrEqualTo(String value) {
            addCriterion("WRT_NO <=", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoLike(String value) {
            addCriterion("WRT_NO like", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoNotLike(String value) {
            addCriterion("WRT_NO not like", value, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoIn(List<String> values) {
            addCriterion("WRT_NO in", values, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoNotIn(List<String> values) {
            addCriterion("WRT_NO not in", values, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoBetween(String value1, String value2) {
            addCriterion("WRT_NO between", value1, value2, "wrtNo");
            return (Criteria) this;
        }

        public Criteria andWrtNoNotBetween(String value1, String value2) {
            addCriterion("WRT_NO not between", value1, value2, "wrtNo");
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

        public Criteria andIndrctCrdtIsNull() {
            addCriterion("INDRCT_CRDT is null");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtIsNotNull() {
            addCriterion("INDRCT_CRDT is not null");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtEqualTo(String value) {
            addCriterion("INDRCT_CRDT =", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtNotEqualTo(String value) {
            addCriterion("INDRCT_CRDT <>", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtGreaterThan(String value) {
            addCriterion("INDRCT_CRDT >", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtGreaterThanOrEqualTo(String value) {
            addCriterion("INDRCT_CRDT >=", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtLessThan(String value) {
            addCriterion("INDRCT_CRDT <", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtLessThanOrEqualTo(String value) {
            addCriterion("INDRCT_CRDT <=", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtLike(String value) {
            addCriterion("INDRCT_CRDT like", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtNotLike(String value) {
            addCriterion("INDRCT_CRDT not like", value, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtIn(List<String> values) {
            addCriterion("INDRCT_CRDT in", values, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtNotIn(List<String> values) {
            addCriterion("INDRCT_CRDT not in", values, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtBetween(String value1, String value2) {
            addCriterion("INDRCT_CRDT between", value1, value2, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andIndrctCrdtNotBetween(String value1, String value2) {
            addCriterion("INDRCT_CRDT not between", value1, value2, "indrctCrdt");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdIsNull() {
            addCriterion("CRDT_CUST_CD is null");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdIsNotNull() {
            addCriterion("CRDT_CUST_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdEqualTo(String value) {
            addCriterion("CRDT_CUST_CD =", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdNotEqualTo(String value) {
            addCriterion("CRDT_CUST_CD <>", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdGreaterThan(String value) {
            addCriterion("CRDT_CUST_CD >", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdGreaterThanOrEqualTo(String value) {
            addCriterion("CRDT_CUST_CD >=", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdLessThan(String value) {
            addCriterion("CRDT_CUST_CD <", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdLessThanOrEqualTo(String value) {
            addCriterion("CRDT_CUST_CD <=", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdLike(String value) {
            addCriterion("CRDT_CUST_CD like", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdNotLike(String value) {
            addCriterion("CRDT_CUST_CD not like", value, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdIn(List<String> values) {
            addCriterion("CRDT_CUST_CD in", values, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdNotIn(List<String> values) {
            addCriterion("CRDT_CUST_CD not in", values, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdBetween(String value1, String value2) {
            addCriterion("CRDT_CUST_CD between", value1, value2, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustCdNotBetween(String value1, String value2) {
            addCriterion("CRDT_CUST_CD not between", value1, value2, "crdtCustCd");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmIsNull() {
            addCriterion("CRDT_CUST_NM is null");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmIsNotNull() {
            addCriterion("CRDT_CUST_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmEqualTo(String value) {
            addCriterion("CRDT_CUST_NM =", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmNotEqualTo(String value) {
            addCriterion("CRDT_CUST_NM <>", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmGreaterThan(String value) {
            addCriterion("CRDT_CUST_NM >", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmGreaterThanOrEqualTo(String value) {
            addCriterion("CRDT_CUST_NM >=", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmLessThan(String value) {
            addCriterion("CRDT_CUST_NM <", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmLessThanOrEqualTo(String value) {
            addCriterion("CRDT_CUST_NM <=", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmLike(String value) {
            addCriterion("CRDT_CUST_NM like", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmNotLike(String value) {
            addCriterion("CRDT_CUST_NM not like", value, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmIn(List<String> values) {
            addCriterion("CRDT_CUST_NM in", values, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmNotIn(List<String> values) {
            addCriterion("CRDT_CUST_NM not in", values, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmBetween(String value1, String value2) {
            addCriterion("CRDT_CUST_NM between", value1, value2, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andCrdtCustNmNotBetween(String value1, String value2) {
            addCriterion("CRDT_CUST_NM not between", value1, value2, "crdtCustNm");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andElecFlgIsNull() {
            addCriterion("ELEC_FLG is null");
            return (Criteria) this;
        }

        public Criteria andElecFlgIsNotNull() {
            addCriterion("ELEC_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andElecFlgEqualTo(String value) {
            addCriterion("ELEC_FLG =", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgNotEqualTo(String value) {
            addCriterion("ELEC_FLG <>", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgGreaterThan(String value) {
            addCriterion("ELEC_FLG >", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ELEC_FLG >=", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgLessThan(String value) {
            addCriterion("ELEC_FLG <", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgLessThanOrEqualTo(String value) {
            addCriterion("ELEC_FLG <=", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgLike(String value) {
            addCriterion("ELEC_FLG like", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgNotLike(String value) {
            addCriterion("ELEC_FLG not like", value, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgIn(List<String> values) {
            addCriterion("ELEC_FLG in", values, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgNotIn(List<String> values) {
            addCriterion("ELEC_FLG not in", values, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgBetween(String value1, String value2) {
            addCriterion("ELEC_FLG between", value1, value2, "elecFlg");
            return (Criteria) this;
        }

        public Criteria andElecFlgNotBetween(String value1, String value2) {
            addCriterion("ELEC_FLG not between", value1, value2, "elecFlg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}