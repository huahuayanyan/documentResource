package com.huateng.scf.bas.fin.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFinCustDsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BFinCustDsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BFinCustDsExample(BFinCustDsExample example) {
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

        public Criteria andFinDirIdIsNull() {
            addCriterion("FIN_DIR_ID is null");
            return (Criteria) this;
        }

        public Criteria andFinDirIdIsNotNull() {
            addCriterion("FIN_DIR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFinDirIdEqualTo(String value) {
            addCriterion("FIN_DIR_ID =", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdNotEqualTo(String value) {
            addCriterion("FIN_DIR_ID <>", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdGreaterThan(String value) {
            addCriterion("FIN_DIR_ID >", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_DIR_ID >=", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdLessThan(String value) {
            addCriterion("FIN_DIR_ID <", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdLessThanOrEqualTo(String value) {
            addCriterion("FIN_DIR_ID <=", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdLike(String value) {
            addCriterion("FIN_DIR_ID like", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdNotLike(String value) {
            addCriterion("FIN_DIR_ID not like", value, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdIn(List<String> values) {
            addCriterion("FIN_DIR_ID in", values, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdNotIn(List<String> values) {
            addCriterion("FIN_DIR_ID not in", values, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdBetween(String value1, String value2) {
            addCriterion("FIN_DIR_ID between", value1, value2, "finDirId");
            return (Criteria) this;
        }

        public Criteria andFinDirIdNotBetween(String value1, String value2) {
            addCriterion("FIN_DIR_ID not between", value1, value2, "finDirId");
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

        public Criteria andColVal1IsNull() {
            addCriterion("COL_VAL1 is null");
            return (Criteria) this;
        }

        public Criteria andColVal1IsNotNull() {
            addCriterion("COL_VAL1 is not null");
            return (Criteria) this;
        }

        public Criteria andColVal1EqualTo(BigDecimal value) {
            addCriterion("COL_VAL1 =", value, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1NotEqualTo(BigDecimal value) {
            addCriterion("COL_VAL1 <>", value, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1GreaterThan(BigDecimal value) {
            addCriterion("COL_VAL1 >", value, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COL_VAL1 >=", value, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1LessThan(BigDecimal value) {
            addCriterion("COL_VAL1 <", value, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("COL_VAL1 <=", value, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1In(List<BigDecimal> values) {
            addCriterion("COL_VAL1 in", values, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1NotIn(List<BigDecimal> values) {
            addCriterion("COL_VAL1 not in", values, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("COL_VAL1 between", value1, value2, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COL_VAL1 not between", value1, value2, "colVal1");
            return (Criteria) this;
        }

        public Criteria andColVal2IsNull() {
            addCriterion("COL_VAL2 is null");
            return (Criteria) this;
        }

        public Criteria andColVal2IsNotNull() {
            addCriterion("COL_VAL2 is not null");
            return (Criteria) this;
        }

        public Criteria andColVal2EqualTo(BigDecimal value) {
            addCriterion("COL_VAL2 =", value, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2NotEqualTo(BigDecimal value) {
            addCriterion("COL_VAL2 <>", value, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2GreaterThan(BigDecimal value) {
            addCriterion("COL_VAL2 >", value, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COL_VAL2 >=", value, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2LessThan(BigDecimal value) {
            addCriterion("COL_VAL2 <", value, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("COL_VAL2 <=", value, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2In(List<BigDecimal> values) {
            addCriterion("COL_VAL2 in", values, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2NotIn(List<BigDecimal> values) {
            addCriterion("COL_VAL2 not in", values, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("COL_VAL2 between", value1, value2, "colVal2");
            return (Criteria) this;
        }

        public Criteria andColVal2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COL_VAL2 not between", value1, value2, "colVal2");
            return (Criteria) this;
        }

        public Criteria andRpSourceIsNull() {
            addCriterion("RP_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andRpSourceIsNotNull() {
            addCriterion("RP_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andRpSourceEqualTo(String value) {
            addCriterion("RP_SOURCE =", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceNotEqualTo(String value) {
            addCriterion("RP_SOURCE <>", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceGreaterThan(String value) {
            addCriterion("RP_SOURCE >", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceGreaterThanOrEqualTo(String value) {
            addCriterion("RP_SOURCE >=", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceLessThan(String value) {
            addCriterion("RP_SOURCE <", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceLessThanOrEqualTo(String value) {
            addCriterion("RP_SOURCE <=", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceLike(String value) {
            addCriterion("RP_SOURCE like", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceNotLike(String value) {
            addCriterion("RP_SOURCE not like", value, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceIn(List<String> values) {
            addCriterion("RP_SOURCE in", values, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceNotIn(List<String> values) {
            addCriterion("RP_SOURCE not in", values, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceBetween(String value1, String value2) {
            addCriterion("RP_SOURCE between", value1, value2, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRpSourceNotBetween(String value1, String value2) {
            addCriterion("RP_SOURCE not between", value1, value2, "rpSource");
            return (Criteria) this;
        }

        public Criteria andRptNoIsNull() {
            addCriterion("RPT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRptNoIsNotNull() {
            addCriterion("RPT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRptNoEqualTo(String value) {
            addCriterion("RPT_NO =", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotEqualTo(String value) {
            addCriterion("RPT_NO <>", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoGreaterThan(String value) {
            addCriterion("RPT_NO >", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoGreaterThanOrEqualTo(String value) {
            addCriterion("RPT_NO >=", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoLessThan(String value) {
            addCriterion("RPT_NO <", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoLessThanOrEqualTo(String value) {
            addCriterion("RPT_NO <=", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoLike(String value) {
            addCriterion("RPT_NO like", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotLike(String value) {
            addCriterion("RPT_NO not like", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoIn(List<String> values) {
            addCriterion("RPT_NO in", values, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotIn(List<String> values) {
            addCriterion("RPT_NO not in", values, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoBetween(String value1, String value2) {
            addCriterion("RPT_NO between", value1, value2, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotBetween(String value1, String value2) {
            addCriterion("RPT_NO not between", value1, value2, "rptNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}