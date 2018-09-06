package com.huateng.scf.bas.crg.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrgEvalRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrgEvalRecExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrgEvalRecExample(BCrgEvalRecExample example) {
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

        public Criteria andEvalIdIsNull() {
            addCriterion("EVAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andEvalIdIsNotNull() {
            addCriterion("EVAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEvalIdEqualTo(String value) {
            addCriterion("EVAL_ID =", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotEqualTo(String value) {
            addCriterion("EVAL_ID <>", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdGreaterThan(String value) {
            addCriterion("EVAL_ID >", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_ID >=", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdLessThan(String value) {
            addCriterion("EVAL_ID <", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdLessThanOrEqualTo(String value) {
            addCriterion("EVAL_ID <=", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdLike(String value) {
            addCriterion("EVAL_ID like", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotLike(String value) {
            addCriterion("EVAL_ID not like", value, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdIn(List<String> values) {
            addCriterion("EVAL_ID in", values, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotIn(List<String> values) {
            addCriterion("EVAL_ID not in", values, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdBetween(String value1, String value2) {
            addCriterion("EVAL_ID between", value1, value2, "evalId");
            return (Criteria) this;
        }

        public Criteria andEvalIdNotBetween(String value1, String value2) {
            addCriterion("EVAL_ID not between", value1, value2, "evalId");
            return (Criteria) this;
        }

        public Criteria andRltTypIsNull() {
            addCriterion("RLT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRltTypIsNotNull() {
            addCriterion("RLT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRltTypEqualTo(String value) {
            addCriterion("RLT_TYP =", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotEqualTo(String value) {
            addCriterion("RLT_TYP <>", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypGreaterThan(String value) {
            addCriterion("RLT_TYP >", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_TYP >=", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLessThan(String value) {
            addCriterion("RLT_TYP <", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLessThanOrEqualTo(String value) {
            addCriterion("RLT_TYP <=", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLike(String value) {
            addCriterion("RLT_TYP like", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotLike(String value) {
            addCriterion("RLT_TYP not like", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypIn(List<String> values) {
            addCriterion("RLT_TYP in", values, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotIn(List<String> values) {
            addCriterion("RLT_TYP not in", values, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypBetween(String value1, String value2) {
            addCriterion("RLT_TYP between", value1, value2, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotBetween(String value1, String value2) {
            addCriterion("RLT_TYP not between", value1, value2, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltIdIsNull() {
            addCriterion("RLT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRltIdIsNotNull() {
            addCriterion("RLT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRltIdEqualTo(String value) {
            addCriterion("RLT_ID =", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotEqualTo(String value) {
            addCriterion("RLT_ID <>", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdGreaterThan(String value) {
            addCriterion("RLT_ID >", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_ID >=", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdLessThan(String value) {
            addCriterion("RLT_ID <", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdLessThanOrEqualTo(String value) {
            addCriterion("RLT_ID <=", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdLike(String value) {
            addCriterion("RLT_ID like", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotLike(String value) {
            addCriterion("RLT_ID not like", value, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdIn(List<String> values) {
            addCriterion("RLT_ID in", values, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotIn(List<String> values) {
            addCriterion("RLT_ID not in", values, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdBetween(String value1, String value2) {
            addCriterion("RLT_ID between", value1, value2, "rltId");
            return (Criteria) this;
        }

        public Criteria andRltIdNotBetween(String value1, String value2) {
            addCriterion("RLT_ID not between", value1, value2, "rltId");
            return (Criteria) this;
        }

        public Criteria andFinDtIsNull() {
            addCriterion("FIN_DT is null");
            return (Criteria) this;
        }

        public Criteria andFinDtIsNotNull() {
            addCriterion("FIN_DT is not null");
            return (Criteria) this;
        }

        public Criteria andFinDtEqualTo(String value) {
            addCriterion("FIN_DT =", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotEqualTo(String value) {
            addCriterion("FIN_DT <>", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtGreaterThan(String value) {
            addCriterion("FIN_DT >", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_DT >=", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtLessThan(String value) {
            addCriterion("FIN_DT <", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtLessThanOrEqualTo(String value) {
            addCriterion("FIN_DT <=", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtLike(String value) {
            addCriterion("FIN_DT like", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotLike(String value) {
            addCriterion("FIN_DT not like", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtIn(List<String> values) {
            addCriterion("FIN_DT in", values, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotIn(List<String> values) {
            addCriterion("FIN_DT not in", values, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtBetween(String value1, String value2) {
            addCriterion("FIN_DT between", value1, value2, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotBetween(String value1, String value2) {
            addCriterion("FIN_DT not between", value1, value2, "finDt");
            return (Criteria) this;
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

        public Criteria andEvalDtIsNull() {
            addCriterion("EVAL_DT is null");
            return (Criteria) this;
        }

        public Criteria andEvalDtIsNotNull() {
            addCriterion("EVAL_DT is not null");
            return (Criteria) this;
        }

        public Criteria andEvalDtEqualTo(String value) {
            addCriterion("EVAL_DT =", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotEqualTo(String value) {
            addCriterion("EVAL_DT <>", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtGreaterThan(String value) {
            addCriterion("EVAL_DT >", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_DT >=", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtLessThan(String value) {
            addCriterion("EVAL_DT <", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtLessThanOrEqualTo(String value) {
            addCriterion("EVAL_DT <=", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtLike(String value) {
            addCriterion("EVAL_DT like", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotLike(String value) {
            addCriterion("EVAL_DT not like", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtIn(List<String> values) {
            addCriterion("EVAL_DT in", values, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotIn(List<String> values) {
            addCriterion("EVAL_DT not in", values, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtBetween(String value1, String value2) {
            addCriterion("EVAL_DT between", value1, value2, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotBetween(String value1, String value2) {
            addCriterion("EVAL_DT not between", value1, value2, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalScrIsNull() {
            addCriterion("EVAL_SCR is null");
            return (Criteria) this;
        }

        public Criteria andEvalScrIsNotNull() {
            addCriterion("EVAL_SCR is not null");
            return (Criteria) this;
        }

        public Criteria andEvalScrEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCR =", value, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrNotEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCR <>", value, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrGreaterThan(BigDecimal value) {
            addCriterion("EVAL_SCR >", value, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCR >=", value, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrLessThan(BigDecimal value) {
            addCriterion("EVAL_SCR <", value, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCR <=", value, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrIn(List<BigDecimal> values) {
            addCriterion("EVAL_SCR in", values, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrNotIn(List<BigDecimal> values) {
            addCriterion("EVAL_SCR not in", values, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_SCR between", value1, value2, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalScrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_SCR not between", value1, value2, "evalScr");
            return (Criteria) this;
        }

        public Criteria andEvalRsltIsNull() {
            addCriterion("EVAL_RSLT is null");
            return (Criteria) this;
        }

        public Criteria andEvalRsltIsNotNull() {
            addCriterion("EVAL_RSLT is not null");
            return (Criteria) this;
        }

        public Criteria andEvalRsltEqualTo(String value) {
            addCriterion("EVAL_RSLT =", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltNotEqualTo(String value) {
            addCriterion("EVAL_RSLT <>", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltGreaterThan(String value) {
            addCriterion("EVAL_RSLT >", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_RSLT >=", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltLessThan(String value) {
            addCriterion("EVAL_RSLT <", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltLessThanOrEqualTo(String value) {
            addCriterion("EVAL_RSLT <=", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltLike(String value) {
            addCriterion("EVAL_RSLT like", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltNotLike(String value) {
            addCriterion("EVAL_RSLT not like", value, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltIn(List<String> values) {
            addCriterion("EVAL_RSLT in", values, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltNotIn(List<String> values) {
            addCriterion("EVAL_RSLT not in", values, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltBetween(String value1, String value2) {
            addCriterion("EVAL_RSLT between", value1, value2, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andEvalRsltNotBetween(String value1, String value2) {
            addCriterion("EVAL_RSLT not between", value1, value2, "evalRslt");
            return (Criteria) this;
        }

        public Criteria andCognScrIsNull() {
            addCriterion("COGN_SCR is null");
            return (Criteria) this;
        }

        public Criteria andCognScrIsNotNull() {
            addCriterion("COGN_SCR is not null");
            return (Criteria) this;
        }

        public Criteria andCognScrEqualTo(BigDecimal value) {
            addCriterion("COGN_SCR =", value, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrNotEqualTo(BigDecimal value) {
            addCriterion("COGN_SCR <>", value, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrGreaterThan(BigDecimal value) {
            addCriterion("COGN_SCR >", value, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COGN_SCR >=", value, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrLessThan(BigDecimal value) {
            addCriterion("COGN_SCR <", value, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COGN_SCR <=", value, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrIn(List<BigDecimal> values) {
            addCriterion("COGN_SCR in", values, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrNotIn(List<BigDecimal> values) {
            addCriterion("COGN_SCR not in", values, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COGN_SCR between", value1, value2, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognScrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COGN_SCR not between", value1, value2, "cognScr");
            return (Criteria) this;
        }

        public Criteria andCognRsltIsNull() {
            addCriterion("COGN_RSLT is null");
            return (Criteria) this;
        }

        public Criteria andCognRsltIsNotNull() {
            addCriterion("COGN_RSLT is not null");
            return (Criteria) this;
        }

        public Criteria andCognRsltEqualTo(String value) {
            addCriterion("COGN_RSLT =", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltNotEqualTo(String value) {
            addCriterion("COGN_RSLT <>", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltGreaterThan(String value) {
            addCriterion("COGN_RSLT >", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltGreaterThanOrEqualTo(String value) {
            addCriterion("COGN_RSLT >=", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltLessThan(String value) {
            addCriterion("COGN_RSLT <", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltLessThanOrEqualTo(String value) {
            addCriterion("COGN_RSLT <=", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltLike(String value) {
            addCriterion("COGN_RSLT like", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltNotLike(String value) {
            addCriterion("COGN_RSLT not like", value, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltIn(List<String> values) {
            addCriterion("COGN_RSLT in", values, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltNotIn(List<String> values) {
            addCriterion("COGN_RSLT not in", values, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltBetween(String value1, String value2) {
            addCriterion("COGN_RSLT between", value1, value2, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andCognRsltNotBetween(String value1, String value2) {
            addCriterion("COGN_RSLT not between", value1, value2, "cognRslt");
            return (Criteria) this;
        }

        public Criteria andEftDtIsNull() {
            addCriterion("EFT_DT is null");
            return (Criteria) this;
        }

        public Criteria andEftDtIsNotNull() {
            addCriterion("EFT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andEftDtEqualTo(String value) {
            addCriterion("EFT_DT =", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtNotEqualTo(String value) {
            addCriterion("EFT_DT <>", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtGreaterThan(String value) {
            addCriterion("EFT_DT >", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtGreaterThanOrEqualTo(String value) {
            addCriterion("EFT_DT >=", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtLessThan(String value) {
            addCriterion("EFT_DT <", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtLessThanOrEqualTo(String value) {
            addCriterion("EFT_DT <=", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtLike(String value) {
            addCriterion("EFT_DT like", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtNotLike(String value) {
            addCriterion("EFT_DT not like", value, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtIn(List<String> values) {
            addCriterion("EFT_DT in", values, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtNotIn(List<String> values) {
            addCriterion("EFT_DT not in", values, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtBetween(String value1, String value2) {
            addCriterion("EFT_DT between", value1, value2, "eftDt");
            return (Criteria) this;
        }

        public Criteria andEftDtNotBetween(String value1, String value2) {
            addCriterion("EFT_DT not between", value1, value2, "eftDt");
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

        public Criteria andIsVldIsNull() {
            addCriterion("IS_VLD is null");
            return (Criteria) this;
        }

        public Criteria andIsVldIsNotNull() {
            addCriterion("IS_VLD is not null");
            return (Criteria) this;
        }

        public Criteria andIsVldEqualTo(String value) {
            addCriterion("IS_VLD =", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldNotEqualTo(String value) {
            addCriterion("IS_VLD <>", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldGreaterThan(String value) {
            addCriterion("IS_VLD >", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldGreaterThanOrEqualTo(String value) {
            addCriterion("IS_VLD >=", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldLessThan(String value) {
            addCriterion("IS_VLD <", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldLessThanOrEqualTo(String value) {
            addCriterion("IS_VLD <=", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldLike(String value) {
            addCriterion("IS_VLD like", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldNotLike(String value) {
            addCriterion("IS_VLD not like", value, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldIn(List<String> values) {
            addCriterion("IS_VLD in", values, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldNotIn(List<String> values) {
            addCriterion("IS_VLD not in", values, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldBetween(String value1, String value2) {
            addCriterion("IS_VLD between", value1, value2, "isVld");
            return (Criteria) this;
        }

        public Criteria andIsVldNotBetween(String value1, String value2) {
            addCriterion("IS_VLD not between", value1, value2, "isVld");
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

        public Criteria andLastUpdTlrIsNull() {
            addCriterion("LAST_UPD_TLR is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIsNotNull() {
            addCriterion("LAST_UPD_TLR is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR =", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLR <>", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrGreaterThan(String value) {
            addCriterion("LAST_UPD_TLR >", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR >=", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLessThan(String value) {
            addCriterion("LAST_UPD_TLR <", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR <=", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLike(String value) {
            addCriterion("LAST_UPD_TLR like", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotLike(String value) {
            addCriterion("LAST_UPD_TLR not like", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIn(List<String> values) {
            addCriterion("LAST_UPD_TLR in", values, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLR not in", values, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLR between", value1, value2, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLR not between", value1, value2, "lastUpdTlr");
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

        public Criteria andProcessIdIsNull() {
            addCriterion("PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(String value) {
            addCriterion("PROCESS_ID =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(String value) {
            addCriterion("PROCESS_ID <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(String value) {
            addCriterion("PROCESS_ID >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_ID >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(String value) {
            addCriterion("PROCESS_ID <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_ID <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLike(String value) {
            addCriterion("PROCESS_ID like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotLike(String value) {
            addCriterion("PROCESS_ID not like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<String> values) {
            addCriterion("PROCESS_ID in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<String> values) {
            addCriterion("PROCESS_ID not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(String value1, String value2) {
            addCriterion("PROCESS_ID between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(String value1, String value2) {
            addCriterion("PROCESS_ID not between", value1, value2, "processId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}