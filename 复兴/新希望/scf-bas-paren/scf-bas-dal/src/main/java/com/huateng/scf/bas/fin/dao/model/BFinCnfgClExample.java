package com.huateng.scf.bas.fin.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFinCnfgClExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BFinCnfgClExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BFinCnfgClExample(BFinCnfgClExample example) {
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

        public Criteria andMdlIdIsNull() {
            addCriterion("MDL_ID is null");
            return (Criteria) this;
        }

        public Criteria andMdlIdIsNotNull() {
            addCriterion("MDL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMdlIdEqualTo(String value) {
            addCriterion("MDL_ID =", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotEqualTo(String value) {
            addCriterion("MDL_ID <>", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThan(String value) {
            addCriterion("MDL_ID >", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThanOrEqualTo(String value) {
            addCriterion("MDL_ID >=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThan(String value) {
            addCriterion("MDL_ID <", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThanOrEqualTo(String value) {
            addCriterion("MDL_ID <=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLike(String value) {
            addCriterion("MDL_ID like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotLike(String value) {
            addCriterion("MDL_ID not like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdIn(List<String> values) {
            addCriterion("MDL_ID in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotIn(List<String> values) {
            addCriterion("MDL_ID not in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdBetween(String value1, String value2) {
            addCriterion("MDL_ID between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotBetween(String value1, String value2) {
            addCriterion("MDL_ID not between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlNmIsNull() {
            addCriterion("MDL_NM is null");
            return (Criteria) this;
        }

        public Criteria andMdlNmIsNotNull() {
            addCriterion("MDL_NM is not null");
            return (Criteria) this;
        }

        public Criteria andMdlNmEqualTo(String value) {
            addCriterion("MDL_NM =", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotEqualTo(String value) {
            addCriterion("MDL_NM <>", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmGreaterThan(String value) {
            addCriterion("MDL_NM >", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmGreaterThanOrEqualTo(String value) {
            addCriterion("MDL_NM >=", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmLessThan(String value) {
            addCriterion("MDL_NM <", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmLessThanOrEqualTo(String value) {
            addCriterion("MDL_NM <=", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmLike(String value) {
            addCriterion("MDL_NM like", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotLike(String value) {
            addCriterion("MDL_NM not like", value, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmIn(List<String> values) {
            addCriterion("MDL_NM in", values, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotIn(List<String> values) {
            addCriterion("MDL_NM not in", values, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmBetween(String value1, String value2) {
            addCriterion("MDL_NM between", value1, value2, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlNmNotBetween(String value1, String value2) {
            addCriterion("MDL_NM not between", value1, value2, "mdlNm");
            return (Criteria) this;
        }

        public Criteria andMdlClIsNull() {
            addCriterion("MDL_CL is null");
            return (Criteria) this;
        }

        public Criteria andMdlClIsNotNull() {
            addCriterion("MDL_CL is not null");
            return (Criteria) this;
        }

        public Criteria andMdlClEqualTo(String value) {
            addCriterion("MDL_CL =", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClNotEqualTo(String value) {
            addCriterion("MDL_CL <>", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClGreaterThan(String value) {
            addCriterion("MDL_CL >", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClGreaterThanOrEqualTo(String value) {
            addCriterion("MDL_CL >=", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClLessThan(String value) {
            addCriterion("MDL_CL <", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClLessThanOrEqualTo(String value) {
            addCriterion("MDL_CL <=", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClLike(String value) {
            addCriterion("MDL_CL like", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClNotLike(String value) {
            addCriterion("MDL_CL not like", value, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClIn(List<String> values) {
            addCriterion("MDL_CL in", values, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClNotIn(List<String> values) {
            addCriterion("MDL_CL not in", values, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClBetween(String value1, String value2) {
            addCriterion("MDL_CL between", value1, value2, "mdlCl");
            return (Criteria) this;
        }

        public Criteria andMdlClNotBetween(String value1, String value2) {
            addCriterion("MDL_CL not between", value1, value2, "mdlCl");
            return (Criteria) this;
        }
        
        public Criteria andMdlTypIsNull() {
            addCriterion("MDL_TYP is null");
            return (Criteria) this;
        }

        public Criteria andMdlTypIsNotNull() {
            addCriterion("MDL_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andMdlTypEqualTo(String value) {
            addCriterion("MDL_TYP =", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypNotEqualTo(String value) {
            addCriterion("MDL_TYP <>", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypGreaterThan(String value) {
            addCriterion("MDL_TYP >", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypGreaterThanOrEqualTo(String value) {
            addCriterion("MDL_TYP >=", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypLessThan(String value) {
            addCriterion("MDL_TYP <", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypLessThanOrEqualTo(String value) {
            addCriterion("MDL_TYP <=", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypLike(String value) {
            addCriterion("MDL_TYP like", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypNotLike(String value) {
            addCriterion("MDL_TYP not like", value, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypIn(List<String> values) {
            addCriterion("MDL_TYP in", values, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypNotIn(List<String> values) {
            addCriterion("MDL_TYP not in", values, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypBetween(String value1, String value2) {
            addCriterion("MDL_TYP between", value1, value2, "mdlTyp");
            return (Criteria) this;
        }

        public Criteria andMdlTypNotBetween(String value1, String value2) {
            addCriterion("MDL_TYP not between", value1, value2, "mdlTyp");
            return (Criteria) this;
        }
        

        public Criteria andColIsNull() {
            addCriterion("COL is null");
            return (Criteria) this;
        }

        public Criteria andColIsNotNull() {
            addCriterion("COL is not null");
            return (Criteria) this;
        }

        public Criteria andColEqualTo(BigDecimal value) {
            addCriterion("COL =", value, "col");
            return (Criteria) this;
        }

        public Criteria andColNotEqualTo(BigDecimal value) {
            addCriterion("COL <>", value, "col");
            return (Criteria) this;
        }

        public Criteria andColGreaterThan(BigDecimal value) {
            addCriterion("COL >", value, "col");
            return (Criteria) this;
        }

        public Criteria andColGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COL >=", value, "col");
            return (Criteria) this;
        }

        public Criteria andColLessThan(BigDecimal value) {
            addCriterion("COL <", value, "col");
            return (Criteria) this;
        }

        public Criteria andColLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COL <=", value, "col");
            return (Criteria) this;
        }

        public Criteria andColIn(List<BigDecimal> values) {
            addCriterion("COL in", values, "col");
            return (Criteria) this;
        }

        public Criteria andColNotIn(List<BigDecimal> values) {
            addCriterion("COL not in", values, "col");
            return (Criteria) this;
        }

        public Criteria andColBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COL between", value1, value2, "col");
            return (Criteria) this;
        }

        public Criteria andColNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COL not between", value1, value2, "col");
            return (Criteria) this;
        }

        public Criteria andCotesIsNull() {
            addCriterion("COTES is null");
            return (Criteria) this;
        }

        public Criteria andCotesIsNotNull() {
            addCriterion("COTES is not null");
            return (Criteria) this;
        }

        public Criteria andCotesEqualTo(BigDecimal value) {
            addCriterion("COTES =", value, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesNotEqualTo(BigDecimal value) {
            addCriterion("COTES <>", value, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesGreaterThan(BigDecimal value) {
            addCriterion("COTES >", value, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COTES >=", value, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesLessThan(BigDecimal value) {
            addCriterion("COTES <", value, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COTES <=", value, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesIn(List<BigDecimal> values) {
            addCriterion("COTES in", values, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesNotIn(List<BigDecimal> values) {
            addCriterion("COTES not in", values, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COTES between", value1, value2, "cotes");
            return (Criteria) this;
        }

        public Criteria andCotesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COTES not between", value1, value2, "cotes");
            return (Criteria) this;
        }

        public Criteria andDelFlgIsNull() {
            addCriterion("DEL_FLG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlgIsNotNull() {
            addCriterion("DEL_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlgEqualTo(String value) {
            addCriterion("DEL_FLG =", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotEqualTo(String value) {
            addCriterion("DEL_FLG <>", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgGreaterThan(String value) {
            addCriterion("DEL_FLG >", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLG >=", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLessThan(String value) {
            addCriterion("DEL_FLG <", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLG <=", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLike(String value) {
            addCriterion("DEL_FLG like", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotLike(String value) {
            addCriterion("DEL_FLG not like", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgIn(List<String> values) {
            addCriterion("DEL_FLG in", values, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotIn(List<String> values) {
            addCriterion("DEL_FLG not in", values, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgBetween(String value1, String value2) {
            addCriterion("DEL_FLG between", value1, value2, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotBetween(String value1, String value2) {
            addCriterion("DEL_FLG not between", value1, value2, "delFlg");
            return (Criteria) this;
        }

        public Criteria andRemIsNull() {
            addCriterion("REM is null");
            return (Criteria) this;
        }

        public Criteria andRemIsNotNull() {
            addCriterion("REM is not null");
            return (Criteria) this;
        }

        public Criteria andRemEqualTo(String value) {
            addCriterion("REM =", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotEqualTo(String value) {
            addCriterion("REM <>", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThan(String value) {
            addCriterion("REM >", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThanOrEqualTo(String value) {
            addCriterion("REM >=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThan(String value) {
            addCriterion("REM <", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThanOrEqualTo(String value) {
            addCriterion("REM <=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLike(String value) {
            addCriterion("REM like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotLike(String value) {
            addCriterion("REM not like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemIn(List<String> values) {
            addCriterion("REM in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotIn(List<String> values) {
            addCriterion("REM not in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemBetween(String value1, String value2) {
            addCriterion("REM between", value1, value2, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotBetween(String value1, String value2) {
            addCriterion("REM not between", value1, value2, "rem");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}