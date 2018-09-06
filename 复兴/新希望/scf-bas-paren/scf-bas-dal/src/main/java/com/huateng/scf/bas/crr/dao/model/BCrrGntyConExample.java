package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrGntyConExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrGntyConExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrGntyConExample(BCrrGntyConExample example) {
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

        public Criteria andConIdIsNull() {
            addCriterion("CON_ID is null");
            return (Criteria) this;
        }

        public Criteria andConIdIsNotNull() {
            addCriterion("CON_ID is not null");
            return (Criteria) this;
        }

        public Criteria andConIdEqualTo(String value) {
            addCriterion("CON_ID =", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotEqualTo(String value) {
            addCriterion("CON_ID <>", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThan(String value) {
            addCriterion("CON_ID >", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThanOrEqualTo(String value) {
            addCriterion("CON_ID >=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThan(String value) {
            addCriterion("CON_ID <", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThanOrEqualTo(String value) {
            addCriterion("CON_ID <=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLike(String value) {
            addCriterion("CON_ID like", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotLike(String value) {
            addCriterion("CON_ID not like", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdIn(List<String> values) {
            addCriterion("CON_ID in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotIn(List<String> values) {
            addCriterion("CON_ID not in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdBetween(String value1, String value2) {
            addCriterion("CON_ID between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotBetween(String value1, String value2) {
            addCriterion("CON_ID not between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andConTypIsNull() {
            addCriterion("CON_TYP is null");
            return (Criteria) this;
        }

        public Criteria andConTypIsNotNull() {
            addCriterion("CON_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andConTypEqualTo(String value) {
            addCriterion("CON_TYP =", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypNotEqualTo(String value) {
            addCriterion("CON_TYP <>", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypGreaterThan(String value) {
            addCriterion("CON_TYP >", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypGreaterThanOrEqualTo(String value) {
            addCriterion("CON_TYP >=", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypLessThan(String value) {
            addCriterion("CON_TYP <", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypLessThanOrEqualTo(String value) {
            addCriterion("CON_TYP <=", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypLike(String value) {
            addCriterion("CON_TYP like", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypNotLike(String value) {
            addCriterion("CON_TYP not like", value, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypIn(List<String> values) {
            addCriterion("CON_TYP in", values, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypNotIn(List<String> values) {
            addCriterion("CON_TYP not in", values, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypBetween(String value1, String value2) {
            addCriterion("CON_TYP between", value1, value2, "conTyp");
            return (Criteria) this;
        }

        public Criteria andConTypNotBetween(String value1, String value2) {
            addCriterion("CON_TYP not between", value1, value2, "conTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypIsNull() {
            addCriterion("GUTY_TYP is null");
            return (Criteria) this;
        }

        public Criteria andGutyTypIsNotNull() {
            addCriterion("GUTY_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andGutyTypEqualTo(String value) {
            addCriterion("GUTY_TYP =", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypNotEqualTo(String value) {
            addCriterion("GUTY_TYP <>", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypGreaterThan(String value) {
            addCriterion("GUTY_TYP >", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypGreaterThanOrEqualTo(String value) {
            addCriterion("GUTY_TYP >=", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypLessThan(String value) {
            addCriterion("GUTY_TYP <", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypLessThanOrEqualTo(String value) {
            addCriterion("GUTY_TYP <=", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypLike(String value) {
            addCriterion("GUTY_TYP like", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypNotLike(String value) {
            addCriterion("GUTY_TYP not like", value, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypIn(List<String> values) {
            addCriterion("GUTY_TYP in", values, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypNotIn(List<String> values) {
            addCriterion("GUTY_TYP not in", values, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypBetween(String value1, String value2) {
            addCriterion("GUTY_TYP between", value1, value2, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andGutyTypNotBetween(String value1, String value2) {
            addCriterion("GUTY_TYP not between", value1, value2, "gutyTyp");
            return (Criteria) this;
        }

        public Criteria andConStatIsNull() {
            addCriterion("CON_STAT is null");
            return (Criteria) this;
        }

        public Criteria andConStatIsNotNull() {
            addCriterion("CON_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andConStatEqualTo(String value) {
            addCriterion("CON_STAT =", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatNotEqualTo(String value) {
            addCriterion("CON_STAT <>", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatGreaterThan(String value) {
            addCriterion("CON_STAT >", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatGreaterThanOrEqualTo(String value) {
            addCriterion("CON_STAT >=", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatLessThan(String value) {
            addCriterion("CON_STAT <", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatLessThanOrEqualTo(String value) {
            addCriterion("CON_STAT <=", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatLike(String value) {
            addCriterion("CON_STAT like", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatNotLike(String value) {
            addCriterion("CON_STAT not like", value, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatIn(List<String> values) {
            addCriterion("CON_STAT in", values, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatNotIn(List<String> values) {
            addCriterion("CON_STAT not in", values, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatBetween(String value1, String value2) {
            addCriterion("CON_STAT between", value1, value2, "conStat");
            return (Criteria) this;
        }

        public Criteria andConStatNotBetween(String value1, String value2) {
            addCriterion("CON_STAT not between", value1, value2, "conStat");
            return (Criteria) this;
        }

        public Criteria andGutFrmIsNull() {
            addCriterion("GUT_FRM is null");
            return (Criteria) this;
        }

        public Criteria andGutFrmIsNotNull() {
            addCriterion("GUT_FRM is not null");
            return (Criteria) this;
        }

        public Criteria andGutFrmEqualTo(String value) {
            addCriterion("GUT_FRM =", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmNotEqualTo(String value) {
            addCriterion("GUT_FRM <>", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmGreaterThan(String value) {
            addCriterion("GUT_FRM >", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmGreaterThanOrEqualTo(String value) {
            addCriterion("GUT_FRM >=", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmLessThan(String value) {
            addCriterion("GUT_FRM <", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmLessThanOrEqualTo(String value) {
            addCriterion("GUT_FRM <=", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmLike(String value) {
            addCriterion("GUT_FRM like", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmNotLike(String value) {
            addCriterion("GUT_FRM not like", value, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmIn(List<String> values) {
            addCriterion("GUT_FRM in", values, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmNotIn(List<String> values) {
            addCriterion("GUT_FRM not in", values, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmBetween(String value1, String value2) {
            addCriterion("GUT_FRM between", value1, value2, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutFrmNotBetween(String value1, String value2) {
            addCriterion("GUT_FRM not between", value1, value2, "gutFrm");
            return (Criteria) this;
        }

        public Criteria andGutIdIsNull() {
            addCriterion("GUT_ID is null");
            return (Criteria) this;
        }

        public Criteria andGutIdIsNotNull() {
            addCriterion("GUT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGutIdEqualTo(String value) {
            addCriterion("GUT_ID =", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdNotEqualTo(String value) {
            addCriterion("GUT_ID <>", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdGreaterThan(String value) {
            addCriterion("GUT_ID >", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdGreaterThanOrEqualTo(String value) {
            addCriterion("GUT_ID >=", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdLessThan(String value) {
            addCriterion("GUT_ID <", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdLessThanOrEqualTo(String value) {
            addCriterion("GUT_ID <=", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdLike(String value) {
            addCriterion("GUT_ID like", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdNotLike(String value) {
            addCriterion("GUT_ID not like", value, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdIn(List<String> values) {
            addCriterion("GUT_ID in", values, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdNotIn(List<String> values) {
            addCriterion("GUT_ID not in", values, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdBetween(String value1, String value2) {
            addCriterion("GUT_ID between", value1, value2, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutIdNotBetween(String value1, String value2) {
            addCriterion("GUT_ID not between", value1, value2, "gutId");
            return (Criteria) this;
        }

        public Criteria andGutNmIsNull() {
            addCriterion("GUT_NM is null");
            return (Criteria) this;
        }

        public Criteria andGutNmIsNotNull() {
            addCriterion("GUT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andGutNmEqualTo(String value) {
            addCriterion("GUT_NM =", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmNotEqualTo(String value) {
            addCriterion("GUT_NM <>", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmGreaterThan(String value) {
            addCriterion("GUT_NM >", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmGreaterThanOrEqualTo(String value) {
            addCriterion("GUT_NM >=", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmLessThan(String value) {
            addCriterion("GUT_NM <", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmLessThanOrEqualTo(String value) {
            addCriterion("GUT_NM <=", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmLike(String value) {
            addCriterion("GUT_NM like", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmNotLike(String value) {
            addCriterion("GUT_NM not like", value, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmIn(List<String> values) {
            addCriterion("GUT_NM in", values, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmNotIn(List<String> values) {
            addCriterion("GUT_NM not in", values, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmBetween(String value1, String value2) {
            addCriterion("GUT_NM between", value1, value2, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGutNmNotBetween(String value1, String value2) {
            addCriterion("GUT_NM not between", value1, value2, "gutNm");
            return (Criteria) this;
        }

        public Criteria andGcrtTypIsNull() {
            addCriterion("GCRT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andGcrtTypIsNotNull() {
            addCriterion("GCRT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andGcrtTypEqualTo(String value) {
            addCriterion("GCRT_TYP =", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypNotEqualTo(String value) {
            addCriterion("GCRT_TYP <>", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypGreaterThan(String value) {
            addCriterion("GCRT_TYP >", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypGreaterThanOrEqualTo(String value) {
            addCriterion("GCRT_TYP >=", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypLessThan(String value) {
            addCriterion("GCRT_TYP <", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypLessThanOrEqualTo(String value) {
            addCriterion("GCRT_TYP <=", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypLike(String value) {
            addCriterion("GCRT_TYP like", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypNotLike(String value) {
            addCriterion("GCRT_TYP not like", value, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypIn(List<String> values) {
            addCriterion("GCRT_TYP in", values, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypNotIn(List<String> values) {
            addCriterion("GCRT_TYP not in", values, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypBetween(String value1, String value2) {
            addCriterion("GCRT_TYP between", value1, value2, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtTypNotBetween(String value1, String value2) {
            addCriterion("GCRT_TYP not between", value1, value2, "gcrtTyp");
            return (Criteria) this;
        }

        public Criteria andGcrtIdIsNull() {
            addCriterion("GCRT_ID is null");
            return (Criteria) this;
        }

        public Criteria andGcrtIdIsNotNull() {
            addCriterion("GCRT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGcrtIdEqualTo(String value) {
            addCriterion("GCRT_ID =", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdNotEqualTo(String value) {
            addCriterion("GCRT_ID <>", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdGreaterThan(String value) {
            addCriterion("GCRT_ID >", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdGreaterThanOrEqualTo(String value) {
            addCriterion("GCRT_ID >=", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdLessThan(String value) {
            addCriterion("GCRT_ID <", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdLessThanOrEqualTo(String value) {
            addCriterion("GCRT_ID <=", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdLike(String value) {
            addCriterion("GCRT_ID like", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdNotLike(String value) {
            addCriterion("GCRT_ID not like", value, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdIn(List<String> values) {
            addCriterion("GCRT_ID in", values, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdNotIn(List<String> values) {
            addCriterion("GCRT_ID not in", values, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdBetween(String value1, String value2) {
            addCriterion("GCRT_ID between", value1, value2, "gcrtId");
            return (Criteria) this;
        }

        public Criteria andGcrtIdNotBetween(String value1, String value2) {
            addCriterion("GCRT_ID not between", value1, value2, "gcrtId");
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

        public Criteria andGutCurcdIsNull() {
            addCriterion("GUT_CURCD is null");
            return (Criteria) this;
        }

        public Criteria andGutCurcdIsNotNull() {
            addCriterion("GUT_CURCD is not null");
            return (Criteria) this;
        }

        public Criteria andGutCurcdEqualTo(String value) {
            addCriterion("GUT_CURCD =", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdNotEqualTo(String value) {
            addCriterion("GUT_CURCD <>", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdGreaterThan(String value) {
            addCriterion("GUT_CURCD >", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdGreaterThanOrEqualTo(String value) {
            addCriterion("GUT_CURCD >=", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdLessThan(String value) {
            addCriterion("GUT_CURCD <", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdLessThanOrEqualTo(String value) {
            addCriterion("GUT_CURCD <=", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdLike(String value) {
            addCriterion("GUT_CURCD like", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdNotLike(String value) {
            addCriterion("GUT_CURCD not like", value, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdIn(List<String> values) {
            addCriterion("GUT_CURCD in", values, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdNotIn(List<String> values) {
            addCriterion("GUT_CURCD not in", values, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdBetween(String value1, String value2) {
            addCriterion("GUT_CURCD between", value1, value2, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutCurcdNotBetween(String value1, String value2) {
            addCriterion("GUT_CURCD not between", value1, value2, "gutCurcd");
            return (Criteria) this;
        }

        public Criteria andGutValIsNull() {
            addCriterion("GUT_VAL is null");
            return (Criteria) this;
        }

        public Criteria andGutValIsNotNull() {
            addCriterion("GUT_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andGutValEqualTo(BigDecimal value) {
            addCriterion("GUT_VAL =", value, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValNotEqualTo(BigDecimal value) {
            addCriterion("GUT_VAL <>", value, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValGreaterThan(BigDecimal value) {
            addCriterion("GUT_VAL >", value, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GUT_VAL >=", value, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValLessThan(BigDecimal value) {
            addCriterion("GUT_VAL <", value, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GUT_VAL <=", value, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValIn(List<BigDecimal> values) {
            addCriterion("GUT_VAL in", values, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValNotIn(List<BigDecimal> values) {
            addCriterion("GUT_VAL not in", values, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GUT_VAL between", value1, value2, "gutVal");
            return (Criteria) this;
        }

        public Criteria andGutValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GUT_VAL not between", value1, value2, "gutVal");
            return (Criteria) this;
        }

        public Criteria andOthDscrbIsNull() {
            addCriterion("OTH_DSCRB is null");
            return (Criteria) this;
        }

        public Criteria andOthDscrbIsNotNull() {
            addCriterion("OTH_DSCRB is not null");
            return (Criteria) this;
        }

        public Criteria andOthDscrbEqualTo(String value) {
            addCriterion("OTH_DSCRB =", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbNotEqualTo(String value) {
            addCriterion("OTH_DSCRB <>", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbGreaterThan(String value) {
            addCriterion("OTH_DSCRB >", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbGreaterThanOrEqualTo(String value) {
            addCriterion("OTH_DSCRB >=", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbLessThan(String value) {
            addCriterion("OTH_DSCRB <", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbLessThanOrEqualTo(String value) {
            addCriterion("OTH_DSCRB <=", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbLike(String value) {
            addCriterion("OTH_DSCRB like", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbNotLike(String value) {
            addCriterion("OTH_DSCRB not like", value, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbIn(List<String> values) {
            addCriterion("OTH_DSCRB in", values, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbNotIn(List<String> values) {
            addCriterion("OTH_DSCRB not in", values, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbBetween(String value1, String value2) {
            addCriterion("OTH_DSCRB between", value1, value2, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andOthDscrbNotBetween(String value1, String value2) {
            addCriterion("OTH_DSCRB not between", value1, value2, "othDscrb");
            return (Criteria) this;
        }

        public Criteria andBailRateIsNull() {
            addCriterion("BAIL_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBailRateIsNotNull() {
            addCriterion("BAIL_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBailRateEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE =", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE <>", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateGreaterThan(BigDecimal value) {
            addCriterion("BAIL_RATE >", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE >=", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateLessThan(BigDecimal value) {
            addCriterion("BAIL_RATE <", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE <=", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateIn(List<BigDecimal> values) {
            addCriterion("BAIL_RATE in", values, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_RATE not in", values, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RATE between", value1, value2, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RATE not between", value1, value2, "bailRate");
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

        public Criteria andVidPrdIdIsNull() {
            addCriterion("VID_PRD_ID is null");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdIsNotNull() {
            addCriterion("VID_PRD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdEqualTo(String value) {
            addCriterion("VID_PRD_ID =", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdNotEqualTo(String value) {
            addCriterion("VID_PRD_ID <>", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdGreaterThan(String value) {
            addCriterion("VID_PRD_ID >", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("VID_PRD_ID >=", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdLessThan(String value) {
            addCriterion("VID_PRD_ID <", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdLessThanOrEqualTo(String value) {
            addCriterion("VID_PRD_ID <=", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdLike(String value) {
            addCriterion("VID_PRD_ID like", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdNotLike(String value) {
            addCriterion("VID_PRD_ID not like", value, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdIn(List<String> values) {
            addCriterion("VID_PRD_ID in", values, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdNotIn(List<String> values) {
            addCriterion("VID_PRD_ID not in", values, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdBetween(String value1, String value2) {
            addCriterion("VID_PRD_ID between", value1, value2, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andVidPrdIdNotBetween(String value1, String value2) {
            addCriterion("VID_PRD_ID not between", value1, value2, "vidPrdId");
            return (Criteria) this;
        }

        public Criteria andPrtclNoIsNull() {
            addCriterion("PRTCL_NO is null");
            return (Criteria) this;
        }

        public Criteria andPrtclNoIsNotNull() {
            addCriterion("PRTCL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPrtclNoEqualTo(String value) {
            addCriterion("PRTCL_NO =", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoNotEqualTo(String value) {
            addCriterion("PRTCL_NO <>", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoGreaterThan(String value) {
            addCriterion("PRTCL_NO >", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoGreaterThanOrEqualTo(String value) {
            addCriterion("PRTCL_NO >=", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoLessThan(String value) {
            addCriterion("PRTCL_NO <", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoLessThanOrEqualTo(String value) {
            addCriterion("PRTCL_NO <=", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoLike(String value) {
            addCriterion("PRTCL_NO like", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoNotLike(String value) {
            addCriterion("PRTCL_NO not like", value, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoIn(List<String> values) {
            addCriterion("PRTCL_NO in", values, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoNotIn(List<String> values) {
            addCriterion("PRTCL_NO not in", values, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoBetween(String value1, String value2) {
            addCriterion("PRTCL_NO between", value1, value2, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andPrtclNoNotBetween(String value1, String value2) {
            addCriterion("PRTCL_NO not between", value1, value2, "prtclNo");
            return (Criteria) this;
        }

        public Criteria andRationIsNull() {
            addCriterion("RATION is null");
            return (Criteria) this;
        }

        public Criteria andRationIsNotNull() {
            addCriterion("RATION is not null");
            return (Criteria) this;
        }

        public Criteria andRationEqualTo(BigDecimal value) {
            addCriterion("RATION =", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotEqualTo(BigDecimal value) {
            addCriterion("RATION <>", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThan(BigDecimal value) {
            addCriterion("RATION >", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION >=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThan(BigDecimal value) {
            addCriterion("RATION <", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION <=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationIn(List<BigDecimal> values) {
            addCriterion("RATION in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotIn(List<BigDecimal> values) {
            addCriterion("RATION not in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION between", value1, value2, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION not between", value1, value2, "ration");
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

        public Criteria andLowPriceIsNull() {
            addCriterion("LOW_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNotNull() {
            addCriterion("LOW_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE =", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE <>", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThan(BigDecimal value) {
            addCriterion("LOW_PRICE >", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE >=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThan(BigDecimal value) {
            addCriterion("LOW_PRICE <", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE <=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE not in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE not between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andMoniMdIsNull() {
            addCriterion("MONI_MD is null");
            return (Criteria) this;
        }

        public Criteria andMoniMdIsNotNull() {
            addCriterion("MONI_MD is not null");
            return (Criteria) this;
        }

        public Criteria andMoniMdEqualTo(String value) {
            addCriterion("MONI_MD =", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdNotEqualTo(String value) {
            addCriterion("MONI_MD <>", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdGreaterThan(String value) {
            addCriterion("MONI_MD >", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_MD >=", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdLessThan(String value) {
            addCriterion("MONI_MD <", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdLessThanOrEqualTo(String value) {
            addCriterion("MONI_MD <=", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdLike(String value) {
            addCriterion("MONI_MD like", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdNotLike(String value) {
            addCriterion("MONI_MD not like", value, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdIn(List<String> values) {
            addCriterion("MONI_MD in", values, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdNotIn(List<String> values) {
            addCriterion("MONI_MD not in", values, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdBetween(String value1, String value2) {
            addCriterion("MONI_MD between", value1, value2, "moniMd");
            return (Criteria) this;
        }

        public Criteria andMoniMdNotBetween(String value1, String value2) {
            addCriterion("MONI_MD not between", value1, value2, "moniMd");
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

        public Criteria andGuardRatIsNull() {
            addCriterion("GUARD_RAT is null");
            return (Criteria) this;
        }

        public Criteria andGuardRatIsNotNull() {
            addCriterion("GUARD_RAT is not null");
            return (Criteria) this;
        }

        public Criteria andGuardRatEqualTo(BigDecimal value) {
            addCriterion("GUARD_RAT =", value, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatNotEqualTo(BigDecimal value) {
            addCriterion("GUARD_RAT <>", value, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatGreaterThan(BigDecimal value) {
            addCriterion("GUARD_RAT >", value, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GUARD_RAT >=", value, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatLessThan(BigDecimal value) {
            addCriterion("GUARD_RAT <", value, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GUARD_RAT <=", value, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatIn(List<BigDecimal> values) {
            addCriterion("GUARD_RAT in", values, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatNotIn(List<BigDecimal> values) {
            addCriterion("GUARD_RAT not in", values, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GUARD_RAT between", value1, value2, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGuardRatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GUARD_RAT not between", value1, value2, "guardRat");
            return (Criteria) this;
        }

        public Criteria andGutyWayIsNull() {
            addCriterion("GUTY_WAY is null");
            return (Criteria) this;
        }

        public Criteria andGutyWayIsNotNull() {
            addCriterion("GUTY_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andGutyWayEqualTo(String value) {
            addCriterion("GUTY_WAY =", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayNotEqualTo(String value) {
            addCriterion("GUTY_WAY <>", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayGreaterThan(String value) {
            addCriterion("GUTY_WAY >", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayGreaterThanOrEqualTo(String value) {
            addCriterion("GUTY_WAY >=", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayLessThan(String value) {
            addCriterion("GUTY_WAY <", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayLessThanOrEqualTo(String value) {
            addCriterion("GUTY_WAY <=", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayLike(String value) {
            addCriterion("GUTY_WAY like", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayNotLike(String value) {
            addCriterion("GUTY_WAY not like", value, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayIn(List<String> values) {
            addCriterion("GUTY_WAY in", values, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayNotIn(List<String> values) {
            addCriterion("GUTY_WAY not in", values, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayBetween(String value1, String value2) {
            addCriterion("GUTY_WAY between", value1, value2, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andGutyWayNotBetween(String value1, String value2) {
            addCriterion("GUTY_WAY not between", value1, value2, "gutyWay");
            return (Criteria) this;
        }

        public Criteria andBusiStatIsNull() {
            addCriterion("BUSI_STAT is null");
            return (Criteria) this;
        }

        public Criteria andBusiStatIsNotNull() {
            addCriterion("BUSI_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andBusiStatEqualTo(String value) {
            addCriterion("BUSI_STAT =", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatNotEqualTo(String value) {
            addCriterion("BUSI_STAT <>", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatGreaterThan(String value) {
            addCriterion("BUSI_STAT >", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_STAT >=", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatLessThan(String value) {
            addCriterion("BUSI_STAT <", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatLessThanOrEqualTo(String value) {
            addCriterion("BUSI_STAT <=", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatLike(String value) {
            addCriterion("BUSI_STAT like", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatNotLike(String value) {
            addCriterion("BUSI_STAT not like", value, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatIn(List<String> values) {
            addCriterion("BUSI_STAT in", values, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatNotIn(List<String> values) {
            addCriterion("BUSI_STAT not in", values, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatBetween(String value1, String value2) {
            addCriterion("BUSI_STAT between", value1, value2, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiStatNotBetween(String value1, String value2) {
            addCriterion("BUSI_STAT not between", value1, value2, "busiStat");
            return (Criteria) this;
        }

        public Criteria andBusiNoIsNull() {
            addCriterion("BUSI_NO is null");
            return (Criteria) this;
        }

        public Criteria andBusiNoIsNotNull() {
            addCriterion("BUSI_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBusiNoEqualTo(String value) {
            addCriterion("BUSI_NO =", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotEqualTo(String value) {
            addCriterion("BUSI_NO <>", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoGreaterThan(String value) {
            addCriterion("BUSI_NO >", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_NO >=", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoLessThan(String value) {
            addCriterion("BUSI_NO <", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoLessThanOrEqualTo(String value) {
            addCriterion("BUSI_NO <=", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoLike(String value) {
            addCriterion("BUSI_NO like", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotLike(String value) {
            addCriterion("BUSI_NO not like", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoIn(List<String> values) {
            addCriterion("BUSI_NO in", values, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotIn(List<String> values) {
            addCriterion("BUSI_NO not in", values, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoBetween(String value1, String value2) {
            addCriterion("BUSI_NO between", value1, value2, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotBetween(String value1, String value2) {
            addCriterion("BUSI_NO not between", value1, value2, "busiNo");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmIsNull() {
            addCriterion("PRTCL_BR_NM is null");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmIsNotNull() {
            addCriterion("PRTCL_BR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmEqualTo(String value) {
            addCriterion("PRTCL_BR_NM =", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmNotEqualTo(String value) {
            addCriterion("PRTCL_BR_NM <>", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmGreaterThan(String value) {
            addCriterion("PRTCL_BR_NM >", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmGreaterThanOrEqualTo(String value) {
            addCriterion("PRTCL_BR_NM >=", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmLessThan(String value) {
            addCriterion("PRTCL_BR_NM <", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmLessThanOrEqualTo(String value) {
            addCriterion("PRTCL_BR_NM <=", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmLike(String value) {
            addCriterion("PRTCL_BR_NM like", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmNotLike(String value) {
            addCriterion("PRTCL_BR_NM not like", value, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmIn(List<String> values) {
            addCriterion("PRTCL_BR_NM in", values, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmNotIn(List<String> values) {
            addCriterion("PRTCL_BR_NM not in", values, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmBetween(String value1, String value2) {
            addCriterion("PRTCL_BR_NM between", value1, value2, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andPrtclBrNmNotBetween(String value1, String value2) {
            addCriterion("PRTCL_BR_NM not between", value1, value2, "prtclBrNm");
            return (Criteria) this;
        }

        public Criteria andGutSumIsNull() {
            addCriterion("GUT_SUM is null");
            return (Criteria) this;
        }

        public Criteria andGutSumIsNotNull() {
            addCriterion("GUT_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andGutSumEqualTo(BigDecimal value) {
            addCriterion("GUT_SUM =", value, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumNotEqualTo(BigDecimal value) {
            addCriterion("GUT_SUM <>", value, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumGreaterThan(BigDecimal value) {
            addCriterion("GUT_SUM >", value, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GUT_SUM >=", value, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumLessThan(BigDecimal value) {
            addCriterion("GUT_SUM <", value, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GUT_SUM <=", value, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumIn(List<BigDecimal> values) {
            addCriterion("GUT_SUM in", values, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumNotIn(List<BigDecimal> values) {
            addCriterion("GUT_SUM not in", values, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GUT_SUM between", value1, value2, "gutSum");
            return (Criteria) this;
        }

        public Criteria andGutSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GUT_SUM not between", value1, value2, "gutSum");
            return (Criteria) this;
        }

        public Criteria andStrtDtIsNull() {
            addCriterion("STRT_DT is null");
            return (Criteria) this;
        }

        public Criteria andStrtDtIsNotNull() {
            addCriterion("STRT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andStrtDtEqualTo(String value) {
            addCriterion("STRT_DT =", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtNotEqualTo(String value) {
            addCriterion("STRT_DT <>", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtGreaterThan(String value) {
            addCriterion("STRT_DT >", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtGreaterThanOrEqualTo(String value) {
            addCriterion("STRT_DT >=", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtLessThan(String value) {
            addCriterion("STRT_DT <", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtLessThanOrEqualTo(String value) {
            addCriterion("STRT_DT <=", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtLike(String value) {
            addCriterion("STRT_DT like", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtNotLike(String value) {
            addCriterion("STRT_DT not like", value, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtIn(List<String> values) {
            addCriterion("STRT_DT in", values, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtNotIn(List<String> values) {
            addCriterion("STRT_DT not in", values, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtBetween(String value1, String value2) {
            addCriterion("STRT_DT between", value1, value2, "strtDt");
            return (Criteria) this;
        }

        public Criteria andStrtDtNotBetween(String value1, String value2) {
            addCriterion("STRT_DT not between", value1, value2, "strtDt");
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

    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}