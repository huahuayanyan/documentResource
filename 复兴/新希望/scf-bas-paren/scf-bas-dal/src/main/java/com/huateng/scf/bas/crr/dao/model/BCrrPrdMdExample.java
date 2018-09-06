package com.huateng.scf.bas.crr.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrPrdMdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrPrdMdExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrPrdMdExample(BCrrPrdMdExample example) {
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

        public Criteria andPrdTypIsNull() {
            addCriterion("PRD_TYP is null");
            return (Criteria) this;
        }

        public Criteria andPrdTypIsNotNull() {
            addCriterion("PRD_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andPrdTypEqualTo(String value) {
            addCriterion("PRD_TYP =", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypNotEqualTo(String value) {
            addCriterion("PRD_TYP <>", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypGreaterThan(String value) {
            addCriterion("PRD_TYP >", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypGreaterThanOrEqualTo(String value) {
            addCriterion("PRD_TYP >=", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypLessThan(String value) {
            addCriterion("PRD_TYP <", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypLessThanOrEqualTo(String value) {
            addCriterion("PRD_TYP <=", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypLike(String value) {
            addCriterion("PRD_TYP like", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypNotLike(String value) {
            addCriterion("PRD_TYP not like", value, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypIn(List<String> values) {
            addCriterion("PRD_TYP in", values, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypNotIn(List<String> values) {
            addCriterion("PRD_TYP not in", values, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypBetween(String value1, String value2) {
            addCriterion("PRD_TYP between", value1, value2, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andPrdTypNotBetween(String value1, String value2) {
            addCriterion("PRD_TYP not between", value1, value2, "prdTyp");
            return (Criteria) this;
        }

        public Criteria andAddUrlIsNull() {
            addCriterion("ADD_URL is null");
            return (Criteria) this;
        }

        public Criteria andAddUrlIsNotNull() {
            addCriterion("ADD_URL is not null");
            return (Criteria) this;
        }

        public Criteria andAddUrlEqualTo(String value) {
            addCriterion("ADD_URL =", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlNotEqualTo(String value) {
            addCriterion("ADD_URL <>", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlGreaterThan(String value) {
            addCriterion("ADD_URL >", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_URL >=", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlLessThan(String value) {
            addCriterion("ADD_URL <", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlLessThanOrEqualTo(String value) {
            addCriterion("ADD_URL <=", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlLike(String value) {
            addCriterion("ADD_URL like", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlNotLike(String value) {
            addCriterion("ADD_URL not like", value, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlIn(List<String> values) {
            addCriterion("ADD_URL in", values, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlNotIn(List<String> values) {
            addCriterion("ADD_URL not in", values, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlBetween(String value1, String value2) {
            addCriterion("ADD_URL between", value1, value2, "addUrl");
            return (Criteria) this;
        }

        public Criteria andAddUrlNotBetween(String value1, String value2) {
            addCriterion("ADD_URL not between", value1, value2, "addUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlIsNull() {
            addCriterion("UPD_URL is null");
            return (Criteria) this;
        }

        public Criteria andUpdUrlIsNotNull() {
            addCriterion("UPD_URL is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUrlEqualTo(String value) {
            addCriterion("UPD_URL =", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlNotEqualTo(String value) {
            addCriterion("UPD_URL <>", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlGreaterThan(String value) {
            addCriterion("UPD_URL >", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlGreaterThanOrEqualTo(String value) {
            addCriterion("UPD_URL >=", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlLessThan(String value) {
            addCriterion("UPD_URL <", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlLessThanOrEqualTo(String value) {
            addCriterion("UPD_URL <=", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlLike(String value) {
            addCriterion("UPD_URL like", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlNotLike(String value) {
            addCriterion("UPD_URL not like", value, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlIn(List<String> values) {
            addCriterion("UPD_URL in", values, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlNotIn(List<String> values) {
            addCriterion("UPD_URL not in", values, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlBetween(String value1, String value2) {
            addCriterion("UPD_URL between", value1, value2, "updUrl");
            return (Criteria) this;
        }

        public Criteria andUpdUrlNotBetween(String value1, String value2) {
            addCriterion("UPD_URL not between", value1, value2, "updUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlIsNull() {
            addCriterion("FIN_URL is null");
            return (Criteria) this;
        }

        public Criteria andFinUrlIsNotNull() {
            addCriterion("FIN_URL is not null");
            return (Criteria) this;
        }

        public Criteria andFinUrlEqualTo(String value) {
            addCriterion("FIN_URL =", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlNotEqualTo(String value) {
            addCriterion("FIN_URL <>", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlGreaterThan(String value) {
            addCriterion("FIN_URL >", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_URL >=", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlLessThan(String value) {
            addCriterion("FIN_URL <", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlLessThanOrEqualTo(String value) {
            addCriterion("FIN_URL <=", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlLike(String value) {
            addCriterion("FIN_URL like", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlNotLike(String value) {
            addCriterion("FIN_URL not like", value, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlIn(List<String> values) {
            addCriterion("FIN_URL in", values, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlNotIn(List<String> values) {
            addCriterion("FIN_URL not in", values, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlBetween(String value1, String value2) {
            addCriterion("FIN_URL between", value1, value2, "finUrl");
            return (Criteria) this;
        }

        public Criteria andFinUrlNotBetween(String value1, String value2) {
            addCriterion("FIN_URL not between", value1, value2, "finUrl");
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

        public Criteria andTitNmIsNull() {
            addCriterion("TIT_NM is null");
            return (Criteria) this;
        }

        public Criteria andTitNmIsNotNull() {
            addCriterion("TIT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andTitNmEqualTo(String value) {
            addCriterion("TIT_NM =", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmNotEqualTo(String value) {
            addCriterion("TIT_NM <>", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmGreaterThan(String value) {
            addCriterion("TIT_NM >", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmGreaterThanOrEqualTo(String value) {
            addCriterion("TIT_NM >=", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmLessThan(String value) {
            addCriterion("TIT_NM <", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmLessThanOrEqualTo(String value) {
            addCriterion("TIT_NM <=", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmLike(String value) {
            addCriterion("TIT_NM like", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmNotLike(String value) {
            addCriterion("TIT_NM not like", value, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmIn(List<String> values) {
            addCriterion("TIT_NM in", values, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmNotIn(List<String> values) {
            addCriterion("TIT_NM not in", values, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmBetween(String value1, String value2) {
            addCriterion("TIT_NM between", value1, value2, "titNm");
            return (Criteria) this;
        }

        public Criteria andTitNmNotBetween(String value1, String value2) {
            addCriterion("TIT_NM not between", value1, value2, "titNm");
            return (Criteria) this;
        }

        public Criteria andObjIsNull() {
            addCriterion("OBJ is null");
            return (Criteria) this;
        }

        public Criteria andObjIsNotNull() {
            addCriterion("OBJ is not null");
            return (Criteria) this;
        }

        public Criteria andObjEqualTo(String value) {
            addCriterion("OBJ =", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotEqualTo(String value) {
            addCriterion("OBJ <>", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjGreaterThan(String value) {
            addCriterion("OBJ >", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjGreaterThanOrEqualTo(String value) {
            addCriterion("OBJ >=", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjLessThan(String value) {
            addCriterion("OBJ <", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjLessThanOrEqualTo(String value) {
            addCriterion("OBJ <=", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjLike(String value) {
            addCriterion("OBJ like", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotLike(String value) {
            addCriterion("OBJ not like", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjIn(List<String> values) {
            addCriterion("OBJ in", values, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotIn(List<String> values) {
            addCriterion("OBJ not in", values, "obj");
            return (Criteria) this;
        }

        public Criteria andObjBetween(String value1, String value2) {
            addCriterion("OBJ between", value1, value2, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotBetween(String value1, String value2) {
            addCriterion("OBJ not between", value1, value2, "obj");
            return (Criteria) this;
        }

        public Criteria andPageUrlIsNull() {
            addCriterion("PAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andPageUrlIsNotNull() {
            addCriterion("PAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andPageUrlEqualTo(String value) {
            addCriterion("PAGE_URL =", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotEqualTo(String value) {
            addCriterion("PAGE_URL <>", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThan(String value) {
            addCriterion("PAGE_URL >", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("PAGE_URL >=", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThan(String value) {
            addCriterion("PAGE_URL <", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThanOrEqualTo(String value) {
            addCriterion("PAGE_URL <=", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLike(String value) {
            addCriterion("PAGE_URL like", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotLike(String value) {
            addCriterion("PAGE_URL not like", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlIn(List<String> values) {
            addCriterion("PAGE_URL in", values, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotIn(List<String> values) {
            addCriterion("PAGE_URL not in", values, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlBetween(String value1, String value2) {
            addCriterion("PAGE_URL between", value1, value2, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotBetween(String value1, String value2) {
            addCriterion("PAGE_URL not between", value1, value2, "pageUrl");
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

        public Criteria andStatuIsNull() {
            addCriterion("STATU is null");
            return (Criteria) this;
        }

        public Criteria andStatuIsNotNull() {
            addCriterion("STATU is not null");
            return (Criteria) this;
        }

        public Criteria andStatuEqualTo(String value) {
            addCriterion("STATU =", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotEqualTo(String value) {
            addCriterion("STATU <>", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuGreaterThan(String value) {
            addCriterion("STATU >", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuGreaterThanOrEqualTo(String value) {
            addCriterion("STATU >=", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLessThan(String value) {
            addCriterion("STATU <", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLessThanOrEqualTo(String value) {
            addCriterion("STATU <=", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLike(String value) {
            addCriterion("STATU like", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotLike(String value) {
            addCriterion("STATU not like", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuIn(List<String> values) {
            addCriterion("STATU in", values, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotIn(List<String> values) {
            addCriterion("STATU not in", values, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuBetween(String value1, String value2) {
            addCriterion("STATU between", value1, value2, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotBetween(String value1, String value2) {
            addCriterion("STATU not between", value1, value2, "statu");
            return (Criteria) this;
        }

        public Criteria andLoanWayIsNull() {
            addCriterion("LOAN_WAY is null");
            return (Criteria) this;
        }

        public Criteria andLoanWayIsNotNull() {
            addCriterion("LOAN_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andLoanWayEqualTo(String value) {
            addCriterion("LOAN_WAY =", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotEqualTo(String value) {
            addCriterion("LOAN_WAY <>", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayGreaterThan(String value) {
            addCriterion("LOAN_WAY >", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_WAY >=", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLessThan(String value) {
            addCriterion("LOAN_WAY <", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLessThanOrEqualTo(String value) {
            addCriterion("LOAN_WAY <=", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLike(String value) {
            addCriterion("LOAN_WAY like", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotLike(String value) {
            addCriterion("LOAN_WAY not like", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayIn(List<String> values) {
            addCriterion("LOAN_WAY in", values, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotIn(List<String> values) {
            addCriterion("LOAN_WAY not in", values, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayBetween(String value1, String value2) {
            addCriterion("LOAN_WAY between", value1, value2, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotBetween(String value1, String value2) {
            addCriterion("LOAN_WAY not between", value1, value2, "loanWay");
            return (Criteria) this;
        }

        public Criteria andIsListIsNull() {
            addCriterion("IS_LIST is null");
            return (Criteria) this;
        }

        public Criteria andIsListIsNotNull() {
            addCriterion("IS_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andIsListEqualTo(String value) {
            addCriterion("IS_LIST =", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotEqualTo(String value) {
            addCriterion("IS_LIST <>", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListGreaterThan(String value) {
            addCriterion("IS_LIST >", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListGreaterThanOrEqualTo(String value) {
            addCriterion("IS_LIST >=", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListLessThan(String value) {
            addCriterion("IS_LIST <", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListLessThanOrEqualTo(String value) {
            addCriterion("IS_LIST <=", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListLike(String value) {
            addCriterion("IS_LIST like", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotLike(String value) {
            addCriterion("IS_LIST not like", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListIn(List<String> values) {
            addCriterion("IS_LIST in", values, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotIn(List<String> values) {
            addCriterion("IS_LIST not in", values, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListBetween(String value1, String value2) {
            addCriterion("IS_LIST between", value1, value2, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotBetween(String value1, String value2) {
            addCriterion("IS_LIST not between", value1, value2, "isList");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}