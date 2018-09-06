package com.huateng.scf.bas.fin.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFinCnfgDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BFinCnfgDefExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BFinCnfgDefExample(BFinCnfgDefExample example) {
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

        public Criteria andSerialnoIsNull() {
            addCriterion("SERIALNO is null");
            return (Criteria) this;
        }

        public Criteria andSerialnoIsNotNull() {
            addCriterion("SERIALNO is not null");
            return (Criteria) this;
        }

        public Criteria andSerialnoEqualTo(String value) {
            addCriterion("SERIALNO =", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotEqualTo(String value) {
            addCriterion("SERIALNO <>", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoGreaterThan(String value) {
            addCriterion("SERIALNO >", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoGreaterThanOrEqualTo(String value) {
            addCriterion("SERIALNO >=", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoLessThan(String value) {
            addCriterion("SERIALNO <", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoLessThanOrEqualTo(String value) {
            addCriterion("SERIALNO <=", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoLike(String value) {
            addCriterion("SERIALNO like", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotLike(String value) {
            addCriterion("SERIALNO not like", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoIn(List<String> values) {
            addCriterion("SERIALNO in", values, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotIn(List<String> values) {
            addCriterion("SERIALNO not in", values, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoBetween(String value1, String value2) {
            addCriterion("SERIALNO between", value1, value2, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotBetween(String value1, String value2) {
            addCriterion("SERIALNO not between", value1, value2, "serialno");
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
        public Criteria andRpSourceEqualTo(String value) {
            addCriterion("RP_SOURCE =", value, "rpSource");
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

        public Criteria andSubjIdIsNull() {
            addCriterion("SUBJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubjIdIsNotNull() {
            addCriterion("SUBJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubjIdEqualTo(String value) {
            addCriterion("SUBJ_ID =", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdNotEqualTo(String value) {
            addCriterion("SUBJ_ID <>", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdGreaterThan(String value) {
            addCriterion("SUBJ_ID >", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJ_ID >=", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdLessThan(String value) {
            addCriterion("SUBJ_ID <", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdLessThanOrEqualTo(String value) {
            addCriterion("SUBJ_ID <=", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdLike(String value) {
            addCriterion("SUBJ_ID like", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdNotLike(String value) {
            addCriterion("SUBJ_ID not like", value, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdIn(List<String> values) {
            addCriterion("SUBJ_ID in", values, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdNotIn(List<String> values) {
            addCriterion("SUBJ_ID not in", values, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdBetween(String value1, String value2) {
            addCriterion("SUBJ_ID between", value1, value2, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjIdNotBetween(String value1, String value2) {
            addCriterion("SUBJ_ID not between", value1, value2, "subjId");
            return (Criteria) this;
        }

        public Criteria andSubjNmIsNull() {
            addCriterion("SUBJ_NM is null");
            return (Criteria) this;
        }

        public Criteria andSubjNmIsNotNull() {
            addCriterion("SUBJ_NM is not null");
            return (Criteria) this;
        }

        public Criteria andSubjNmEqualTo(String value) {
            addCriterion("SUBJ_NM =", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmNotEqualTo(String value) {
            addCriterion("SUBJ_NM <>", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmGreaterThan(String value) {
            addCriterion("SUBJ_NM >", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJ_NM >=", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmLessThan(String value) {
            addCriterion("SUBJ_NM <", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmLessThanOrEqualTo(String value) {
            addCriterion("SUBJ_NM <=", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmLike(String value) {
            addCriterion("SUBJ_NM like", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmNotLike(String value) {
            addCriterion("SUBJ_NM not like", value, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmIn(List<String> values) {
            addCriterion("SUBJ_NM in", values, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmNotIn(List<String> values) {
            addCriterion("SUBJ_NM not in", values, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmBetween(String value1, String value2) {
            addCriterion("SUBJ_NM between", value1, value2, "subjNm");
            return (Criteria) this;
        }

        public Criteria andSubjNmNotBetween(String value1, String value2) {
            addCriterion("SUBJ_NM not between", value1, value2, "subjNm");
            return (Criteria) this;
        }

        public Criteria andOrdIsNull() {
            addCriterion("ORD is null");
            return (Criteria) this;
        }

        public Criteria andOrdIsNotNull() {
            addCriterion("ORD is not null");
            return (Criteria) this;
        }

        public Criteria andOrdEqualTo(BigDecimal value) {
            addCriterion("ORD =", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotEqualTo(BigDecimal value) {
            addCriterion("ORD <>", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdGreaterThan(BigDecimal value) {
            addCriterion("ORD >", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORD >=", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdLessThan(BigDecimal value) {
            addCriterion("ORD <", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORD <=", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdIn(List<BigDecimal> values) {
            addCriterion("ORD in", values, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotIn(List<BigDecimal> values) {
            addCriterion("ORD not in", values, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORD between", value1, value2, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORD not between", value1, value2, "ord");
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

        public Criteria andRowFlgIsNull() {
            addCriterion("ROW_FLG is null");
            return (Criteria) this;
        }

        public Criteria andRowFlgIsNotNull() {
            addCriterion("ROW_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andRowFlgEqualTo(String value) {
            addCriterion("ROW_FLG =", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgNotEqualTo(String value) {
            addCriterion("ROW_FLG <>", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgGreaterThan(String value) {
            addCriterion("ROW_FLG >", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ROW_FLG >=", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgLessThan(String value) {
            addCriterion("ROW_FLG <", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgLessThanOrEqualTo(String value) {
            addCriterion("ROW_FLG <=", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgLike(String value) {
            addCriterion("ROW_FLG like", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgNotLike(String value) {
            addCriterion("ROW_FLG not like", value, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgIn(List<String> values) {
            addCriterion("ROW_FLG in", values, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgNotIn(List<String> values) {
            addCriterion("ROW_FLG not in", values, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgBetween(String value1, String value2) {
            addCriterion("ROW_FLG between", value1, value2, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andRowFlgNotBetween(String value1, String value2) {
            addCriterion("ROW_FLG not between", value1, value2, "rowFlg");
            return (Criteria) this;
        }

        public Criteria andEdTypIsNull() {
            addCriterion("ED_TYP is null");
            return (Criteria) this;
        }

        public Criteria andEdTypIsNotNull() {
            addCriterion("ED_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andEdTypEqualTo(String value) {
            addCriterion("ED_TYP =", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypNotEqualTo(String value) {
            addCriterion("ED_TYP <>", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypGreaterThan(String value) {
            addCriterion("ED_TYP >", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypGreaterThanOrEqualTo(String value) {
            addCriterion("ED_TYP >=", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypLessThan(String value) {
            addCriterion("ED_TYP <", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypLessThanOrEqualTo(String value) {
            addCriterion("ED_TYP <=", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypLike(String value) {
            addCriterion("ED_TYP like", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypNotLike(String value) {
            addCriterion("ED_TYP not like", value, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypIn(List<String> values) {
            addCriterion("ED_TYP in", values, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypNotIn(List<String> values) {
            addCriterion("ED_TYP not in", values, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypBetween(String value1, String value2) {
            addCriterion("ED_TYP between", value1, value2, "edTyp");
            return (Criteria) this;
        }

        public Criteria andEdTypNotBetween(String value1, String value2) {
            addCriterion("ED_TYP not between", value1, value2, "edTyp");
            return (Criteria) this;
        }

        public Criteria andChkIsNull() {
            addCriterion("CHK is null");
            return (Criteria) this;
        }

        public Criteria andChkIsNotNull() {
            addCriterion("CHK is not null");
            return (Criteria) this;
        }

        public Criteria andChkEqualTo(String value) {
            addCriterion("CHK =", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotEqualTo(String value) {
            addCriterion("CHK <>", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkGreaterThan(String value) {
            addCriterion("CHK >", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkGreaterThanOrEqualTo(String value) {
            addCriterion("CHK >=", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkLessThan(String value) {
            addCriterion("CHK <", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkLessThanOrEqualTo(String value) {
            addCriterion("CHK <=", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkLike(String value) {
            addCriterion("CHK like", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotLike(String value) {
            addCriterion("CHK not like", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkIn(List<String> values) {
            addCriterion("CHK in", values, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotIn(List<String> values) {
            addCriterion("CHK not in", values, "chk");
            return (Criteria) this;
        }

        public Criteria andChkBetween(String value1, String value2) {
            addCriterion("CHK between", value1, value2, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotBetween(String value1, String value2) {
            addCriterion("CHK not between", value1, value2, "chk");
            return (Criteria) this;
        }

        public Criteria andCalIsNull() {
            addCriterion("CAL is null");
            return (Criteria) this;
        }

        public Criteria andCalIsNotNull() {
            addCriterion("CAL is not null");
            return (Criteria) this;
        }

        public Criteria andCalEqualTo(String value) {
            addCriterion("CAL =", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalNotEqualTo(String value) {
            addCriterion("CAL <>", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalGreaterThan(String value) {
            addCriterion("CAL >", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalGreaterThanOrEqualTo(String value) {
            addCriterion("CAL >=", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalLessThan(String value) {
            addCriterion("CAL <", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalLessThanOrEqualTo(String value) {
            addCriterion("CAL <=", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalLike(String value) {
            addCriterion("CAL like", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalNotLike(String value) {
            addCriterion("CAL not like", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalIn(List<String> values) {
            addCriterion("CAL in", values, "cal");
            return (Criteria) this;
        }

        public Criteria andCalNotIn(List<String> values) {
            addCriterion("CAL not in", values, "cal");
            return (Criteria) this;
        }

        public Criteria andCalBetween(String value1, String value2) {
            addCriterion("CAL between", value1, value2, "cal");
            return (Criteria) this;
        }

        public Criteria andCalNotBetween(String value1, String value2) {
            addCriterion("CAL not between", value1, value2, "cal");
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