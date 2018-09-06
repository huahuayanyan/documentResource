package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrLcInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrLcInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrLcInfoExample(BCrrLcInfoExample example) {
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

        public Criteria andLcIdIsNull() {
            addCriterion("LC_ID is null");
            return (Criteria) this;
        }

        public Criteria andLcIdIsNotNull() {
            addCriterion("LC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLcIdEqualTo(String value) {
            addCriterion("LC_ID =", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdNotEqualTo(String value) {
            addCriterion("LC_ID <>", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdGreaterThan(String value) {
            addCriterion("LC_ID >", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdGreaterThanOrEqualTo(String value) {
            addCriterion("LC_ID >=", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdLessThan(String value) {
            addCriterion("LC_ID <", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdLessThanOrEqualTo(String value) {
            addCriterion("LC_ID <=", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdLike(String value) {
            addCriterion("LC_ID like", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdNotLike(String value) {
            addCriterion("LC_ID not like", value, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdIn(List<String> values) {
            addCriterion("LC_ID in", values, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdNotIn(List<String> values) {
            addCriterion("LC_ID not in", values, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdBetween(String value1, String value2) {
            addCriterion("LC_ID between", value1, value2, "lcId");
            return (Criteria) this;
        }

        public Criteria andLcIdNotBetween(String value1, String value2) {
            addCriterion("LC_ID not between", value1, value2, "lcId");
            return (Criteria) this;
        }

        public Criteria andRelaTypIsNull() {
            addCriterion("RELA_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRelaTypIsNotNull() {
            addCriterion("RELA_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRelaTypEqualTo(String value) {
            addCriterion("RELA_TYP =", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotEqualTo(String value) {
            addCriterion("RELA_TYP <>", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypGreaterThan(String value) {
            addCriterion("RELA_TYP >", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_TYP >=", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLessThan(String value) {
            addCriterion("RELA_TYP <", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLessThanOrEqualTo(String value) {
            addCriterion("RELA_TYP <=", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLike(String value) {
            addCriterion("RELA_TYP like", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotLike(String value) {
            addCriterion("RELA_TYP not like", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypIn(List<String> values) {
            addCriterion("RELA_TYP in", values, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotIn(List<String> values) {
            addCriterion("RELA_TYP not in", values, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypBetween(String value1, String value2) {
            addCriterion("RELA_TYP between", value1, value2, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotBetween(String value1, String value2) {
            addCriterion("RELA_TYP not between", value1, value2, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNull() {
            addCriterion("RELA_NO is null");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNotNull() {
            addCriterion("RELA_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRelaNoEqualTo(String value) {
            addCriterion("RELA_NO =", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotEqualTo(String value) {
            addCriterion("RELA_NO <>", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThan(String value) {
            addCriterion("RELA_NO >", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_NO >=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThan(String value) {
            addCriterion("RELA_NO <", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThanOrEqualTo(String value) {
            addCriterion("RELA_NO <=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLike(String value) {
            addCriterion("RELA_NO like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotLike(String value) {
            addCriterion("RELA_NO not like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoIn(List<String> values) {
            addCriterion("RELA_NO in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotIn(List<String> values) {
            addCriterion("RELA_NO not in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoBetween(String value1, String value2) {
            addCriterion("RELA_NO between", value1, value2, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotBetween(String value1, String value2) {
            addCriterion("RELA_NO not between", value1, value2, "relaNo");
            return (Criteria) this;
        }

        public Criteria andLcNoIsNull() {
            addCriterion("LC_NO is null");
            return (Criteria) this;
        }

        public Criteria andLcNoIsNotNull() {
            addCriterion("LC_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLcNoEqualTo(String value) {
            addCriterion("LC_NO =", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotEqualTo(String value) {
            addCriterion("LC_NO <>", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoGreaterThan(String value) {
            addCriterion("LC_NO >", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoGreaterThanOrEqualTo(String value) {
            addCriterion("LC_NO >=", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoLessThan(String value) {
            addCriterion("LC_NO <", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoLessThanOrEqualTo(String value) {
            addCriterion("LC_NO <=", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoLike(String value) {
            addCriterion("LC_NO like", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotLike(String value) {
            addCriterion("LC_NO not like", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoIn(List<String> values) {
            addCriterion("LC_NO in", values, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotIn(List<String> values) {
            addCriterion("LC_NO not in", values, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoBetween(String value1, String value2) {
            addCriterion("LC_NO between", value1, value2, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotBetween(String value1, String value2) {
            addCriterion("LC_NO not between", value1, value2, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcTypIsNull() {
            addCriterion("LC_TYP is null");
            return (Criteria) this;
        }

        public Criteria andLcTypIsNotNull() {
            addCriterion("LC_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andLcTypEqualTo(String value) {
            addCriterion("LC_TYP =", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypNotEqualTo(String value) {
            addCriterion("LC_TYP <>", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypGreaterThan(String value) {
            addCriterion("LC_TYP >", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypGreaterThanOrEqualTo(String value) {
            addCriterion("LC_TYP >=", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypLessThan(String value) {
            addCriterion("LC_TYP <", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypLessThanOrEqualTo(String value) {
            addCriterion("LC_TYP <=", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypLike(String value) {
            addCriterion("LC_TYP like", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypNotLike(String value) {
            addCriterion("LC_TYP not like", value, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypIn(List<String> values) {
            addCriterion("LC_TYP in", values, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypNotIn(List<String> values) {
            addCriterion("LC_TYP not in", values, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypBetween(String value1, String value2) {
            addCriterion("LC_TYP between", value1, value2, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andLcTypNotBetween(String value1, String value2) {
            addCriterion("LC_TYP not between", value1, value2, "lcTyp");
            return (Criteria) this;
        }

        public Criteria andIseBakIsNull() {
            addCriterion("ISE_BAK is null");
            return (Criteria) this;
        }

        public Criteria andIseBakIsNotNull() {
            addCriterion("ISE_BAK is not null");
            return (Criteria) this;
        }

        public Criteria andIseBakEqualTo(String value) {
            addCriterion("ISE_BAK =", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotEqualTo(String value) {
            addCriterion("ISE_BAK <>", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakGreaterThan(String value) {
            addCriterion("ISE_BAK >", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakGreaterThanOrEqualTo(String value) {
            addCriterion("ISE_BAK >=", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakLessThan(String value) {
            addCriterion("ISE_BAK <", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakLessThanOrEqualTo(String value) {
            addCriterion("ISE_BAK <=", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakLike(String value) {
            addCriterion("ISE_BAK like", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotLike(String value) {
            addCriterion("ISE_BAK not like", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakIn(List<String> values) {
            addCriterion("ISE_BAK in", values, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotIn(List<String> values) {
            addCriterion("ISE_BAK not in", values, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakBetween(String value1, String value2) {
            addCriterion("ISE_BAK between", value1, value2, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotBetween(String value1, String value2) {
            addCriterion("ISE_BAK not between", value1, value2, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseStatIsNull() {
            addCriterion("ISE_STAT is null");
            return (Criteria) this;
        }

        public Criteria andIseStatIsNotNull() {
            addCriterion("ISE_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andIseStatEqualTo(String value) {
            addCriterion("ISE_STAT =", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatNotEqualTo(String value) {
            addCriterion("ISE_STAT <>", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatGreaterThan(String value) {
            addCriterion("ISE_STAT >", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatGreaterThanOrEqualTo(String value) {
            addCriterion("ISE_STAT >=", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatLessThan(String value) {
            addCriterion("ISE_STAT <", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatLessThanOrEqualTo(String value) {
            addCriterion("ISE_STAT <=", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatLike(String value) {
            addCriterion("ISE_STAT like", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatNotLike(String value) {
            addCriterion("ISE_STAT not like", value, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatIn(List<String> values) {
            addCriterion("ISE_STAT in", values, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatNotIn(List<String> values) {
            addCriterion("ISE_STAT not in", values, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatBetween(String value1, String value2) {
            addCriterion("ISE_STAT between", value1, value2, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseStatNotBetween(String value1, String value2) {
            addCriterion("ISE_STAT not between", value1, value2, "iseStat");
            return (Criteria) this;
        }

        public Criteria andIseCdIsNull() {
            addCriterion("ISE_CD is null");
            return (Criteria) this;
        }

        public Criteria andIseCdIsNotNull() {
            addCriterion("ISE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andIseCdEqualTo(String value) {
            addCriterion("ISE_CD =", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdNotEqualTo(String value) {
            addCriterion("ISE_CD <>", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdGreaterThan(String value) {
            addCriterion("ISE_CD >", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdGreaterThanOrEqualTo(String value) {
            addCriterion("ISE_CD >=", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdLessThan(String value) {
            addCriterion("ISE_CD <", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdLessThanOrEqualTo(String value) {
            addCriterion("ISE_CD <=", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdLike(String value) {
            addCriterion("ISE_CD like", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdNotLike(String value) {
            addCriterion("ISE_CD not like", value, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdIn(List<String> values) {
            addCriterion("ISE_CD in", values, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdNotIn(List<String> values) {
            addCriterion("ISE_CD not in", values, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdBetween(String value1, String value2) {
            addCriterion("ISE_CD between", value1, value2, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseCdNotBetween(String value1, String value2) {
            addCriterion("ISE_CD not between", value1, value2, "iseCd");
            return (Criteria) this;
        }

        public Criteria andIseDtIsNull() {
            addCriterion("ISE_DT is null");
            return (Criteria) this;
        }

        public Criteria andIseDtIsNotNull() {
            addCriterion("ISE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andIseDtEqualTo(String value) {
            addCriterion("ISE_DT =", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtNotEqualTo(String value) {
            addCriterion("ISE_DT <>", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtGreaterThan(String value) {
            addCriterion("ISE_DT >", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtGreaterThanOrEqualTo(String value) {
            addCriterion("ISE_DT >=", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtLessThan(String value) {
            addCriterion("ISE_DT <", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtLessThanOrEqualTo(String value) {
            addCriterion("ISE_DT <=", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtLike(String value) {
            addCriterion("ISE_DT like", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtNotLike(String value) {
            addCriterion("ISE_DT not like", value, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtIn(List<String> values) {
            addCriterion("ISE_DT in", values, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtNotIn(List<String> values) {
            addCriterion("ISE_DT not in", values, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtBetween(String value1, String value2) {
            addCriterion("ISE_DT between", value1, value2, "iseDt");
            return (Criteria) this;
        }

        public Criteria andIseDtNotBetween(String value1, String value2) {
            addCriterion("ISE_DT not between", value1, value2, "iseDt");
            return (Criteria) this;
        }

        public Criteria andPrpsIsNull() {
            addCriterion("PRPS is null");
            return (Criteria) this;
        }

        public Criteria andPrpsIsNotNull() {
            addCriterion("PRPS is not null");
            return (Criteria) this;
        }

        public Criteria andPrpsEqualTo(String value) {
            addCriterion("PRPS =", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotEqualTo(String value) {
            addCriterion("PRPS <>", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsGreaterThan(String value) {
            addCriterion("PRPS >", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsGreaterThanOrEqualTo(String value) {
            addCriterion("PRPS >=", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsLessThan(String value) {
            addCriterion("PRPS <", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsLessThanOrEqualTo(String value) {
            addCriterion("PRPS <=", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsLike(String value) {
            addCriterion("PRPS like", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotLike(String value) {
            addCriterion("PRPS not like", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsIn(List<String> values) {
            addCriterion("PRPS in", values, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotIn(List<String> values) {
            addCriterion("PRPS not in", values, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsBetween(String value1, String value2) {
            addCriterion("PRPS between", value1, value2, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotBetween(String value1, String value2) {
            addCriterion("PRPS not between", value1, value2, "prps");
            return (Criteria) this;
        }

        public Criteria andAplatNoIsNull() {
            addCriterion("APLAT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAplatNoIsNotNull() {
            addCriterion("APLAT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAplatNoEqualTo(String value) {
            addCriterion("APLAT_NO =", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoNotEqualTo(String value) {
            addCriterion("APLAT_NO <>", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoGreaterThan(String value) {
            addCriterion("APLAT_NO >", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoGreaterThanOrEqualTo(String value) {
            addCriterion("APLAT_NO >=", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoLessThan(String value) {
            addCriterion("APLAT_NO <", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoLessThanOrEqualTo(String value) {
            addCriterion("APLAT_NO <=", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoLike(String value) {
            addCriterion("APLAT_NO like", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoNotLike(String value) {
            addCriterion("APLAT_NO not like", value, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoIn(List<String> values) {
            addCriterion("APLAT_NO in", values, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoNotIn(List<String> values) {
            addCriterion("APLAT_NO not in", values, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoBetween(String value1, String value2) {
            addCriterion("APLAT_NO between", value1, value2, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNoNotBetween(String value1, String value2) {
            addCriterion("APLAT_NO not between", value1, value2, "aplatNo");
            return (Criteria) this;
        }

        public Criteria andAplatNmIsNull() {
            addCriterion("APLAT_NM is null");
            return (Criteria) this;
        }

        public Criteria andAplatNmIsNotNull() {
            addCriterion("APLAT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andAplatNmEqualTo(String value) {
            addCriterion("APLAT_NM =", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmNotEqualTo(String value) {
            addCriterion("APLAT_NM <>", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmGreaterThan(String value) {
            addCriterion("APLAT_NM >", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmGreaterThanOrEqualTo(String value) {
            addCriterion("APLAT_NM >=", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmLessThan(String value) {
            addCriterion("APLAT_NM <", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmLessThanOrEqualTo(String value) {
            addCriterion("APLAT_NM <=", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmLike(String value) {
            addCriterion("APLAT_NM like", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmNotLike(String value) {
            addCriterion("APLAT_NM not like", value, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmIn(List<String> values) {
            addCriterion("APLAT_NM in", values, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmNotIn(List<String> values) {
            addCriterion("APLAT_NM not in", values, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmBetween(String value1, String value2) {
            addCriterion("APLAT_NM between", value1, value2, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatNmNotBetween(String value1, String value2) {
            addCriterion("APLAT_NM not between", value1, value2, "aplatNm");
            return (Criteria) this;
        }

        public Criteria andAplatAdsIsNull() {
            addCriterion("APLAT_ADS is null");
            return (Criteria) this;
        }

        public Criteria andAplatAdsIsNotNull() {
            addCriterion("APLAT_ADS is not null");
            return (Criteria) this;
        }

        public Criteria andAplatAdsEqualTo(String value) {
            addCriterion("APLAT_ADS =", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsNotEqualTo(String value) {
            addCriterion("APLAT_ADS <>", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsGreaterThan(String value) {
            addCriterion("APLAT_ADS >", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsGreaterThanOrEqualTo(String value) {
            addCriterion("APLAT_ADS >=", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsLessThan(String value) {
            addCriterion("APLAT_ADS <", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsLessThanOrEqualTo(String value) {
            addCriterion("APLAT_ADS <=", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsLike(String value) {
            addCriterion("APLAT_ADS like", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsNotLike(String value) {
            addCriterion("APLAT_ADS not like", value, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsIn(List<String> values) {
            addCriterion("APLAT_ADS in", values, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsNotIn(List<String> values) {
            addCriterion("APLAT_ADS not in", values, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsBetween(String value1, String value2) {
            addCriterion("APLAT_ADS between", value1, value2, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andAplatAdsNotBetween(String value1, String value2) {
            addCriterion("APLAT_ADS not between", value1, value2, "aplatAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoIsNull() {
            addCriterion("BNFCY_NO is null");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoIsNotNull() {
            addCriterion("BNFCY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoEqualTo(String value) {
            addCriterion("BNFCY_NO =", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoNotEqualTo(String value) {
            addCriterion("BNFCY_NO <>", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoGreaterThan(String value) {
            addCriterion("BNFCY_NO >", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoGreaterThanOrEqualTo(String value) {
            addCriterion("BNFCY_NO >=", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoLessThan(String value) {
            addCriterion("BNFCY_NO <", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoLessThanOrEqualTo(String value) {
            addCriterion("BNFCY_NO <=", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoLike(String value) {
            addCriterion("BNFCY_NO like", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoNotLike(String value) {
            addCriterion("BNFCY_NO not like", value, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoIn(List<String> values) {
            addCriterion("BNFCY_NO in", values, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoNotIn(List<String> values) {
            addCriterion("BNFCY_NO not in", values, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoBetween(String value1, String value2) {
            addCriterion("BNFCY_NO between", value1, value2, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNoNotBetween(String value1, String value2) {
            addCriterion("BNFCY_NO not between", value1, value2, "bnfcyNo");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmIsNull() {
            addCriterion("BNFCY_NM is null");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmIsNotNull() {
            addCriterion("BNFCY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmEqualTo(String value) {
            addCriterion("BNFCY_NM =", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotEqualTo(String value) {
            addCriterion("BNFCY_NM <>", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmGreaterThan(String value) {
            addCriterion("BNFCY_NM >", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmGreaterThanOrEqualTo(String value) {
            addCriterion("BNFCY_NM >=", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmLessThan(String value) {
            addCriterion("BNFCY_NM <", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmLessThanOrEqualTo(String value) {
            addCriterion("BNFCY_NM <=", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmLike(String value) {
            addCriterion("BNFCY_NM like", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotLike(String value) {
            addCriterion("BNFCY_NM not like", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmIn(List<String> values) {
            addCriterion("BNFCY_NM in", values, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotIn(List<String> values) {
            addCriterion("BNFCY_NM not in", values, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmBetween(String value1, String value2) {
            addCriterion("BNFCY_NM between", value1, value2, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotBetween(String value1, String value2) {
            addCriterion("BNFCY_NM not between", value1, value2, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsIsNull() {
            addCriterion("BNFCY_ADS is null");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsIsNotNull() {
            addCriterion("BNFCY_ADS is not null");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsEqualTo(String value) {
            addCriterion("BNFCY_ADS =", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsNotEqualTo(String value) {
            addCriterion("BNFCY_ADS <>", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsGreaterThan(String value) {
            addCriterion("BNFCY_ADS >", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsGreaterThanOrEqualTo(String value) {
            addCriterion("BNFCY_ADS >=", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsLessThan(String value) {
            addCriterion("BNFCY_ADS <", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsLessThanOrEqualTo(String value) {
            addCriterion("BNFCY_ADS <=", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsLike(String value) {
            addCriterion("BNFCY_ADS like", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsNotLike(String value) {
            addCriterion("BNFCY_ADS not like", value, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsIn(List<String> values) {
            addCriterion("BNFCY_ADS in", values, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsNotIn(List<String> values) {
            addCriterion("BNFCY_ADS not in", values, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsBetween(String value1, String value2) {
            addCriterion("BNFCY_ADS between", value1, value2, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyAdsNotBetween(String value1, String value2) {
            addCriterion("BNFCY_ADS not between", value1, value2, "bnfcyAds");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdIsNull() {
            addCriterion("BNFCY_CD is null");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdIsNotNull() {
            addCriterion("BNFCY_CD is not null");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdEqualTo(String value) {
            addCriterion("BNFCY_CD =", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdNotEqualTo(String value) {
            addCriterion("BNFCY_CD <>", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdGreaterThan(String value) {
            addCriterion("BNFCY_CD >", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdGreaterThanOrEqualTo(String value) {
            addCriterion("BNFCY_CD >=", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdLessThan(String value) {
            addCriterion("BNFCY_CD <", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdLessThanOrEqualTo(String value) {
            addCriterion("BNFCY_CD <=", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdLike(String value) {
            addCriterion("BNFCY_CD like", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdNotLike(String value) {
            addCriterion("BNFCY_CD not like", value, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdIn(List<String> values) {
            addCriterion("BNFCY_CD in", values, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdNotIn(List<String> values) {
            addCriterion("BNFCY_CD not in", values, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdBetween(String value1, String value2) {
            addCriterion("BNFCY_CD between", value1, value2, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andBnfcyCdNotBetween(String value1, String value2) {
            addCriterion("BNFCY_CD not between", value1, value2, "bnfcyCd");
            return (Criteria) this;
        }

        public Criteria andLstDocDtIsNull() {
            addCriterion("LST_DOC_DT is null");
            return (Criteria) this;
        }

        public Criteria andLstDocDtIsNotNull() {
            addCriterion("LST_DOC_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLstDocDtEqualTo(String value) {
            addCriterion("LST_DOC_DT =", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtNotEqualTo(String value) {
            addCriterion("LST_DOC_DT <>", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtGreaterThan(String value) {
            addCriterion("LST_DOC_DT >", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtGreaterThanOrEqualTo(String value) {
            addCriterion("LST_DOC_DT >=", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtLessThan(String value) {
            addCriterion("LST_DOC_DT <", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtLessThanOrEqualTo(String value) {
            addCriterion("LST_DOC_DT <=", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtLike(String value) {
            addCriterion("LST_DOC_DT like", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtNotLike(String value) {
            addCriterion("LST_DOC_DT not like", value, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtIn(List<String> values) {
            addCriterion("LST_DOC_DT in", values, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtNotIn(List<String> values) {
            addCriterion("LST_DOC_DT not in", values, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtBetween(String value1, String value2) {
            addCriterion("LST_DOC_DT between", value1, value2, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andLstDocDtNotBetween(String value1, String value2) {
            addCriterion("LST_DOC_DT not between", value1, value2, "lstDocDt");
            return (Criteria) this;
        }

        public Criteria andDocDtIsNull() {
            addCriterion("DOC_DT is null");
            return (Criteria) this;
        }

        public Criteria andDocDtIsNotNull() {
            addCriterion("DOC_DT is not null");
            return (Criteria) this;
        }

        public Criteria andDocDtEqualTo(String value) {
            addCriterion("DOC_DT =", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtNotEqualTo(String value) {
            addCriterion("DOC_DT <>", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtGreaterThan(String value) {
            addCriterion("DOC_DT >", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_DT >=", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtLessThan(String value) {
            addCriterion("DOC_DT <", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtLessThanOrEqualTo(String value) {
            addCriterion("DOC_DT <=", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtLike(String value) {
            addCriterion("DOC_DT like", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtNotLike(String value) {
            addCriterion("DOC_DT not like", value, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtIn(List<String> values) {
            addCriterion("DOC_DT in", values, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtNotIn(List<String> values) {
            addCriterion("DOC_DT not in", values, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtBetween(String value1, String value2) {
            addCriterion("DOC_DT between", value1, value2, "docDt");
            return (Criteria) this;
        }

        public Criteria andDocDtNotBetween(String value1, String value2) {
            addCriterion("DOC_DT not between", value1, value2, "docDt");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypIsNull() {
            addCriterion("LC_TRM_TYP is null");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypIsNotNull() {
            addCriterion("LC_TRM_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypEqualTo(String value) {
            addCriterion("LC_TRM_TYP =", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypNotEqualTo(String value) {
            addCriterion("LC_TRM_TYP <>", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypGreaterThan(String value) {
            addCriterion("LC_TRM_TYP >", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypGreaterThanOrEqualTo(String value) {
            addCriterion("LC_TRM_TYP >=", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypLessThan(String value) {
            addCriterion("LC_TRM_TYP <", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypLessThanOrEqualTo(String value) {
            addCriterion("LC_TRM_TYP <=", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypLike(String value) {
            addCriterion("LC_TRM_TYP like", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypNotLike(String value) {
            addCriterion("LC_TRM_TYP not like", value, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypIn(List<String> values) {
            addCriterion("LC_TRM_TYP in", values, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypNotIn(List<String> values) {
            addCriterion("LC_TRM_TYP not in", values, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypBetween(String value1, String value2) {
            addCriterion("LC_TRM_TYP between", value1, value2, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andLcTrmTypNotBetween(String value1, String value2) {
            addCriterion("LC_TRM_TYP not between", value1, value2, "lcTrmTyp");
            return (Criteria) this;
        }

        public Criteria andFlgIsNull() {
            addCriterion("FLG is null");
            return (Criteria) this;
        }

        public Criteria andFlgIsNotNull() {
            addCriterion("FLG is not null");
            return (Criteria) this;
        }

        public Criteria andFlgEqualTo(String value) {
            addCriterion("FLG =", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgNotEqualTo(String value) {
            addCriterion("FLG <>", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgGreaterThan(String value) {
            addCriterion("FLG >", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgGreaterThanOrEqualTo(String value) {
            addCriterion("FLG >=", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgLessThan(String value) {
            addCriterion("FLG <", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgLessThanOrEqualTo(String value) {
            addCriterion("FLG <=", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgLike(String value) {
            addCriterion("FLG like", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgNotLike(String value) {
            addCriterion("FLG not like", value, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgIn(List<String> values) {
            addCriterion("FLG in", values, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgNotIn(List<String> values) {
            addCriterion("FLG not in", values, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgBetween(String value1, String value2) {
            addCriterion("FLG between", value1, value2, "flg");
            return (Criteria) this;
        }

        public Criteria andFlgNotBetween(String value1, String value2) {
            addCriterion("FLG not between", value1, value2, "flg");
            return (Criteria) this;
        }

        public Criteria andBatLoadIsNull() {
            addCriterion("BAT_LOAD is null");
            return (Criteria) this;
        }

        public Criteria andBatLoadIsNotNull() {
            addCriterion("BAT_LOAD is not null");
            return (Criteria) this;
        }

        public Criteria andBatLoadEqualTo(String value) {
            addCriterion("BAT_LOAD =", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadNotEqualTo(String value) {
            addCriterion("BAT_LOAD <>", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadGreaterThan(String value) {
            addCriterion("BAT_LOAD >", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadGreaterThanOrEqualTo(String value) {
            addCriterion("BAT_LOAD >=", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadLessThan(String value) {
            addCriterion("BAT_LOAD <", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadLessThanOrEqualTo(String value) {
            addCriterion("BAT_LOAD <=", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadLike(String value) {
            addCriterion("BAT_LOAD like", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadNotLike(String value) {
            addCriterion("BAT_LOAD not like", value, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadIn(List<String> values) {
            addCriterion("BAT_LOAD in", values, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadNotIn(List<String> values) {
            addCriterion("BAT_LOAD not in", values, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadBetween(String value1, String value2) {
            addCriterion("BAT_LOAD between", value1, value2, "batLoad");
            return (Criteria) this;
        }

        public Criteria andBatLoadNotBetween(String value1, String value2) {
            addCriterion("BAT_LOAD not between", value1, value2, "batLoad");
            return (Criteria) this;
        }

        public Criteria andTrsptIsNull() {
            addCriterion("TRSPT is null");
            return (Criteria) this;
        }

        public Criteria andTrsptIsNotNull() {
            addCriterion("TRSPT is not null");
            return (Criteria) this;
        }

        public Criteria andTrsptEqualTo(String value) {
            addCriterion("TRSPT =", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptNotEqualTo(String value) {
            addCriterion("TRSPT <>", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptGreaterThan(String value) {
            addCriterion("TRSPT >", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptGreaterThanOrEqualTo(String value) {
            addCriterion("TRSPT >=", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptLessThan(String value) {
            addCriterion("TRSPT <", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptLessThanOrEqualTo(String value) {
            addCriterion("TRSPT <=", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptLike(String value) {
            addCriterion("TRSPT like", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptNotLike(String value) {
            addCriterion("TRSPT not like", value, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptIn(List<String> values) {
            addCriterion("TRSPT in", values, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptNotIn(List<String> values) {
            addCriterion("TRSPT not in", values, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptBetween(String value1, String value2) {
            addCriterion("TRSPT between", value1, value2, "trspt");
            return (Criteria) this;
        }

        public Criteria andTrsptNotBetween(String value1, String value2) {
            addCriterion("TRSPT not between", value1, value2, "trspt");
            return (Criteria) this;
        }

        public Criteria andLoadAreaIsNull() {
            addCriterion("LOAD_AREA is null");
            return (Criteria) this;
        }

        public Criteria andLoadAreaIsNotNull() {
            addCriterion("LOAD_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andLoadAreaEqualTo(String value) {
            addCriterion("LOAD_AREA =", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaNotEqualTo(String value) {
            addCriterion("LOAD_AREA <>", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaGreaterThan(String value) {
            addCriterion("LOAD_AREA >", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaGreaterThanOrEqualTo(String value) {
            addCriterion("LOAD_AREA >=", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaLessThan(String value) {
            addCriterion("LOAD_AREA <", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaLessThanOrEqualTo(String value) {
            addCriterion("LOAD_AREA <=", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaLike(String value) {
            addCriterion("LOAD_AREA like", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaNotLike(String value) {
            addCriterion("LOAD_AREA not like", value, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaIn(List<String> values) {
            addCriterion("LOAD_AREA in", values, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaNotIn(List<String> values) {
            addCriterion("LOAD_AREA not in", values, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaBetween(String value1, String value2) {
            addCriterion("LOAD_AREA between", value1, value2, "loadArea");
            return (Criteria) this;
        }

        public Criteria andLoadAreaNotBetween(String value1, String value2) {
            addCriterion("LOAD_AREA not between", value1, value2, "loadArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaIsNull() {
            addCriterion("DEST_AREA is null");
            return (Criteria) this;
        }

        public Criteria andDestAreaIsNotNull() {
            addCriterion("DEST_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andDestAreaEqualTo(String value) {
            addCriterion("DEST_AREA =", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaNotEqualTo(String value) {
            addCriterion("DEST_AREA <>", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaGreaterThan(String value) {
            addCriterion("DEST_AREA >", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaGreaterThanOrEqualTo(String value) {
            addCriterion("DEST_AREA >=", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaLessThan(String value) {
            addCriterion("DEST_AREA <", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaLessThanOrEqualTo(String value) {
            addCriterion("DEST_AREA <=", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaLike(String value) {
            addCriterion("DEST_AREA like", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaNotLike(String value) {
            addCriterion("DEST_AREA not like", value, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaIn(List<String> values) {
            addCriterion("DEST_AREA in", values, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaNotIn(List<String> values) {
            addCriterion("DEST_AREA not in", values, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaBetween(String value1, String value2) {
            addCriterion("DEST_AREA between", value1, value2, "destArea");
            return (Criteria) this;
        }

        public Criteria andDestAreaNotBetween(String value1, String value2) {
            addCriterion("DEST_AREA not between", value1, value2, "destArea");
            return (Criteria) this;
        }

        public Criteria andLoadTypIsNull() {
            addCriterion("LOAD_TYP is null");
            return (Criteria) this;
        }

        public Criteria andLoadTypIsNotNull() {
            addCriterion("LOAD_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andLoadTypEqualTo(String value) {
            addCriterion("LOAD_TYP =", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypNotEqualTo(String value) {
            addCriterion("LOAD_TYP <>", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypGreaterThan(String value) {
            addCriterion("LOAD_TYP >", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypGreaterThanOrEqualTo(String value) {
            addCriterion("LOAD_TYP >=", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypLessThan(String value) {
            addCriterion("LOAD_TYP <", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypLessThanOrEqualTo(String value) {
            addCriterion("LOAD_TYP <=", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypLike(String value) {
            addCriterion("LOAD_TYP like", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypNotLike(String value) {
            addCriterion("LOAD_TYP not like", value, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypIn(List<String> values) {
            addCriterion("LOAD_TYP in", values, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypNotIn(List<String> values) {
            addCriterion("LOAD_TYP not in", values, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypBetween(String value1, String value2) {
            addCriterion("LOAD_TYP between", value1, value2, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andLoadTypNotBetween(String value1, String value2) {
            addCriterion("LOAD_TYP not between", value1, value2, "loadTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypIsNull() {
            addCriterion("SEND_TYP is null");
            return (Criteria) this;
        }

        public Criteria andSendTypIsNotNull() {
            addCriterion("SEND_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypEqualTo(String value) {
            addCriterion("SEND_TYP =", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypNotEqualTo(String value) {
            addCriterion("SEND_TYP <>", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypGreaterThan(String value) {
            addCriterion("SEND_TYP >", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_TYP >=", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypLessThan(String value) {
            addCriterion("SEND_TYP <", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypLessThanOrEqualTo(String value) {
            addCriterion("SEND_TYP <=", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypLike(String value) {
            addCriterion("SEND_TYP like", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypNotLike(String value) {
            addCriterion("SEND_TYP not like", value, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypIn(List<String> values) {
            addCriterion("SEND_TYP in", values, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypNotIn(List<String> values) {
            addCriterion("SEND_TYP not in", values, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypBetween(String value1, String value2) {
            addCriterion("SEND_TYP between", value1, value2, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andSendTypNotBetween(String value1, String value2) {
            addCriterion("SEND_TYP not between", value1, value2, "sendTyp");
            return (Criteria) this;
        }

        public Criteria andPaySiteIsNull() {
            addCriterion("PAY_SITE is null");
            return (Criteria) this;
        }

        public Criteria andPaySiteIsNotNull() {
            addCriterion("PAY_SITE is not null");
            return (Criteria) this;
        }

        public Criteria andPaySiteEqualTo(String value) {
            addCriterion("PAY_SITE =", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteNotEqualTo(String value) {
            addCriterion("PAY_SITE <>", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteGreaterThan(String value) {
            addCriterion("PAY_SITE >", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_SITE >=", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteLessThan(String value) {
            addCriterion("PAY_SITE <", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteLessThanOrEqualTo(String value) {
            addCriterion("PAY_SITE <=", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteLike(String value) {
            addCriterion("PAY_SITE like", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteNotLike(String value) {
            addCriterion("PAY_SITE not like", value, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteIn(List<String> values) {
            addCriterion("PAY_SITE in", values, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteNotIn(List<String> values) {
            addCriterion("PAY_SITE not in", values, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteBetween(String value1, String value2) {
            addCriterion("PAY_SITE between", value1, value2, "paySite");
            return (Criteria) this;
        }

        public Criteria andPaySiteNotBetween(String value1, String value2) {
            addCriterion("PAY_SITE not between", value1, value2, "paySite");
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

        public Criteria andLcTrmIsNull() {
            addCriterion("LC_TRM is null");
            return (Criteria) this;
        }

        public Criteria andLcTrmIsNotNull() {
            addCriterion("LC_TRM is not null");
            return (Criteria) this;
        }

        public Criteria andLcTrmEqualTo(BigDecimal value) {
            addCriterion("LC_TRM =", value, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmNotEqualTo(BigDecimal value) {
            addCriterion("LC_TRM <>", value, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmGreaterThan(BigDecimal value) {
            addCriterion("LC_TRM >", value, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LC_TRM >=", value, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmLessThan(BigDecimal value) {
            addCriterion("LC_TRM <", value, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LC_TRM <=", value, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmIn(List<BigDecimal> values) {
            addCriterion("LC_TRM in", values, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmNotIn(List<BigDecimal> values) {
            addCriterion("LC_TRM not in", values, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LC_TRM between", value1, value2, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andLcTrmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LC_TRM not between", value1, value2, "lcTrm");
            return (Criteria) this;
        }

        public Criteria andPayTypIsNull() {
            addCriterion("PAY_TYP is null");
            return (Criteria) this;
        }

        public Criteria andPayTypIsNotNull() {
            addCriterion("PAY_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypEqualTo(String value) {
            addCriterion("PAY_TYP =", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypNotEqualTo(String value) {
            addCriterion("PAY_TYP <>", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypGreaterThan(String value) {
            addCriterion("PAY_TYP >", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYP >=", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypLessThan(String value) {
            addCriterion("PAY_TYP <", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYP <=", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypLike(String value) {
            addCriterion("PAY_TYP like", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypNotLike(String value) {
            addCriterion("PAY_TYP not like", value, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypIn(List<String> values) {
            addCriterion("PAY_TYP in", values, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypNotIn(List<String> values) {
            addCriterion("PAY_TYP not in", values, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypBetween(String value1, String value2) {
            addCriterion("PAY_TYP between", value1, value2, "payTyp");
            return (Criteria) this;
        }

        public Criteria andPayTypNotBetween(String value1, String value2) {
            addCriterion("PAY_TYP not between", value1, value2, "payTyp");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}