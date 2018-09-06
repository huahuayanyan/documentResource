package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrGntyChgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrGntyChgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrGntyChgExample(BCrrGntyChgExample example) {
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

        public Criteria andGntyIdIsNull() {
            addCriterion("GNTY_ID is null");
            return (Criteria) this;
        }

        public Criteria andGntyIdIsNotNull() {
            addCriterion("GNTY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGntyIdEqualTo(String value) {
            addCriterion("GNTY_ID =", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotEqualTo(String value) {
            addCriterion("GNTY_ID <>", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdGreaterThan(String value) {
            addCriterion("GNTY_ID >", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_ID >=", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdLessThan(String value) {
            addCriterion("GNTY_ID <", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdLessThanOrEqualTo(String value) {
            addCriterion("GNTY_ID <=", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdLike(String value) {
            addCriterion("GNTY_ID like", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotLike(String value) {
            addCriterion("GNTY_ID not like", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdIn(List<String> values) {
            addCriterion("GNTY_ID in", values, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotIn(List<String> values) {
            addCriterion("GNTY_ID not in", values, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdBetween(String value1, String value2) {
            addCriterion("GNTY_ID between", value1, value2, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotBetween(String value1, String value2) {
            addCriterion("GNTY_ID not between", value1, value2, "gntyId");
            return (Criteria) this;
        }

        public Criteria andChgDtIsNull() {
            addCriterion("CHG_DT is null");
            return (Criteria) this;
        }

        public Criteria andChgDtIsNotNull() {
            addCriterion("CHG_DT is not null");
            return (Criteria) this;
        }

        public Criteria andChgDtEqualTo(String value) {
            addCriterion("CHG_DT =", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtNotEqualTo(String value) {
            addCriterion("CHG_DT <>", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtGreaterThan(String value) {
            addCriterion("CHG_DT >", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtGreaterThanOrEqualTo(String value) {
            addCriterion("CHG_DT >=", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtLessThan(String value) {
            addCriterion("CHG_DT <", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtLessThanOrEqualTo(String value) {
            addCriterion("CHG_DT <=", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtLike(String value) {
            addCriterion("CHG_DT like", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtNotLike(String value) {
            addCriterion("CHG_DT not like", value, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtIn(List<String> values) {
            addCriterion("CHG_DT in", values, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtNotIn(List<String> values) {
            addCriterion("CHG_DT not in", values, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtBetween(String value1, String value2) {
            addCriterion("CHG_DT between", value1, value2, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgDtNotBetween(String value1, String value2) {
            addCriterion("CHG_DT not between", value1, value2, "chgDt");
            return (Criteria) this;
        }

        public Criteria andChgTypIsNull() {
            addCriterion("CHG_TYP is null");
            return (Criteria) this;
        }

        public Criteria andChgTypIsNotNull() {
            addCriterion("CHG_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andChgTypEqualTo(String value) {
            addCriterion("CHG_TYP =", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypNotEqualTo(String value) {
            addCriterion("CHG_TYP <>", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypGreaterThan(String value) {
            addCriterion("CHG_TYP >", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypGreaterThanOrEqualTo(String value) {
            addCriterion("CHG_TYP >=", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypLessThan(String value) {
            addCriterion("CHG_TYP <", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypLessThanOrEqualTo(String value) {
            addCriterion("CHG_TYP <=", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypLike(String value) {
            addCriterion("CHG_TYP like", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypNotLike(String value) {
            addCriterion("CHG_TYP not like", value, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypIn(List<String> values) {
            addCriterion("CHG_TYP in", values, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypNotIn(List<String> values) {
            addCriterion("CHG_TYP not in", values, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypBetween(String value1, String value2) {
            addCriterion("CHG_TYP between", value1, value2, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgTypNotBetween(String value1, String value2) {
            addCriterion("CHG_TYP not between", value1, value2, "chgTyp");
            return (Criteria) this;
        }

        public Criteria andChgReasonIsNull() {
            addCriterion("CHG_REASON is null");
            return (Criteria) this;
        }

        public Criteria andChgReasonIsNotNull() {
            addCriterion("CHG_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andChgReasonEqualTo(String value) {
            addCriterion("CHG_REASON =", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonNotEqualTo(String value) {
            addCriterion("CHG_REASON <>", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonGreaterThan(String value) {
            addCriterion("CHG_REASON >", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonGreaterThanOrEqualTo(String value) {
            addCriterion("CHG_REASON >=", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonLessThan(String value) {
            addCriterion("CHG_REASON <", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonLessThanOrEqualTo(String value) {
            addCriterion("CHG_REASON <=", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonLike(String value) {
            addCriterion("CHG_REASON like", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonNotLike(String value) {
            addCriterion("CHG_REASON not like", value, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonIn(List<String> values) {
            addCriterion("CHG_REASON in", values, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonNotIn(List<String> values) {
            addCriterion("CHG_REASON not in", values, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonBetween(String value1, String value2) {
            addCriterion("CHG_REASON between", value1, value2, "chgReason");
            return (Criteria) this;
        }

        public Criteria andChgReasonNotBetween(String value1, String value2) {
            addCriterion("CHG_REASON not between", value1, value2, "chgReason");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdIsNull() {
            addCriterion("OLD_EVAL_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdIsNotNull() {
            addCriterion("OLD_EVAL_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_ID =", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdNotEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_ID <>", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdGreaterThan(String value) {
            addCriterion("OLD_EVAL_ORG_ID >", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_ID >=", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdLessThan(String value) {
            addCriterion("OLD_EVAL_ORG_ID <", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdLessThanOrEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_ID <=", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdLike(String value) {
            addCriterion("OLD_EVAL_ORG_ID like", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdNotLike(String value) {
            addCriterion("OLD_EVAL_ORG_ID not like", value, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdIn(List<String> values) {
            addCriterion("OLD_EVAL_ORG_ID in", values, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdNotIn(List<String> values) {
            addCriterion("OLD_EVAL_ORG_ID not in", values, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdBetween(String value1, String value2) {
            addCriterion("OLD_EVAL_ORG_ID between", value1, value2, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgIdNotBetween(String value1, String value2) {
            addCriterion("OLD_EVAL_ORG_ID not between", value1, value2, "oldEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmIsNull() {
            addCriterion("OLD_EVAL_ORG_NM is null");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmIsNotNull() {
            addCriterion("OLD_EVAL_ORG_NM is not null");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_NM =", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmNotEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_NM <>", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmGreaterThan(String value) {
            addCriterion("OLD_EVAL_ORG_NM >", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_NM >=", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmLessThan(String value) {
            addCriterion("OLD_EVAL_ORG_NM <", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmLessThanOrEqualTo(String value) {
            addCriterion("OLD_EVAL_ORG_NM <=", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmLike(String value) {
            addCriterion("OLD_EVAL_ORG_NM like", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmNotLike(String value) {
            addCriterion("OLD_EVAL_ORG_NM not like", value, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmIn(List<String> values) {
            addCriterion("OLD_EVAL_ORG_NM in", values, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmNotIn(List<String> values) {
            addCriterion("OLD_EVAL_ORG_NM not in", values, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmBetween(String value1, String value2) {
            addCriterion("OLD_EVAL_ORG_NM between", value1, value2, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalOrgNmNotBetween(String value1, String value2) {
            addCriterion("OLD_EVAL_ORG_NM not between", value1, value2, "oldEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValIsNull() {
            addCriterion("OLD_EVAL_NET_VAL is null");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValIsNotNull() {
            addCriterion("OLD_EVAL_NET_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValEqualTo(BigDecimal value) {
            addCriterion("OLD_EVAL_NET_VAL =", value, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValNotEqualTo(BigDecimal value) {
            addCriterion("OLD_EVAL_NET_VAL <>", value, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValGreaterThan(BigDecimal value) {
            addCriterion("OLD_EVAL_NET_VAL >", value, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OLD_EVAL_NET_VAL >=", value, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValLessThan(BigDecimal value) {
            addCriterion("OLD_EVAL_NET_VAL <", value, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OLD_EVAL_NET_VAL <=", value, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValIn(List<BigDecimal> values) {
            addCriterion("OLD_EVAL_NET_VAL in", values, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValNotIn(List<BigDecimal> values) {
            addCriterion("OLD_EVAL_NET_VAL not in", values, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OLD_EVAL_NET_VAL between", value1, value2, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldEvalNetValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OLD_EVAL_NET_VAL not between", value1, value2, "oldEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValIsNull() {
            addCriterion("OLD_CONFIRM_VAL is null");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValIsNotNull() {
            addCriterion("OLD_CONFIRM_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_VAL =", value, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValNotEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_VAL <>", value, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValGreaterThan(BigDecimal value) {
            addCriterion("OLD_CONFIRM_VAL >", value, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_VAL >=", value, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValLessThan(BigDecimal value) {
            addCriterion("OLD_CONFIRM_VAL <", value, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_VAL <=", value, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValIn(List<BigDecimal> values) {
            addCriterion("OLD_CONFIRM_VAL in", values, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValNotIn(List<BigDecimal> values) {
            addCriterion("OLD_CONFIRM_VAL not in", values, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OLD_CONFIRM_VAL between", value1, value2, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldConfirmValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OLD_CONFIRM_VAL not between", value1, value2, "oldConfirmVal");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdIsNull() {
            addCriterion("OLD_OWNER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdIsNotNull() {
            addCriterion("OLD_OWNER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdEqualTo(String value) {
            addCriterion("OLD_OWNER_ID =", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdNotEqualTo(String value) {
            addCriterion("OLD_OWNER_ID <>", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdGreaterThan(String value) {
            addCriterion("OLD_OWNER_ID >", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_OWNER_ID >=", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdLessThan(String value) {
            addCriterion("OLD_OWNER_ID <", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("OLD_OWNER_ID <=", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdLike(String value) {
            addCriterion("OLD_OWNER_ID like", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdNotLike(String value) {
            addCriterion("OLD_OWNER_ID not like", value, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdIn(List<String> values) {
            addCriterion("OLD_OWNER_ID in", values, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdNotIn(List<String> values) {
            addCriterion("OLD_OWNER_ID not in", values, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdBetween(String value1, String value2) {
            addCriterion("OLD_OWNER_ID between", value1, value2, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerIdNotBetween(String value1, String value2) {
            addCriterion("OLD_OWNER_ID not between", value1, value2, "oldOwnerId");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmIsNull() {
            addCriterion("OLD_OWNER_NM is null");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmIsNotNull() {
            addCriterion("OLD_OWNER_NM is not null");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmEqualTo(String value) {
            addCriterion("OLD_OWNER_NM =", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmNotEqualTo(String value) {
            addCriterion("OLD_OWNER_NM <>", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmGreaterThan(String value) {
            addCriterion("OLD_OWNER_NM >", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_OWNER_NM >=", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmLessThan(String value) {
            addCriterion("OLD_OWNER_NM <", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmLessThanOrEqualTo(String value) {
            addCriterion("OLD_OWNER_NM <=", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmLike(String value) {
            addCriterion("OLD_OWNER_NM like", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmNotLike(String value) {
            addCriterion("OLD_OWNER_NM not like", value, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmIn(List<String> values) {
            addCriterion("OLD_OWNER_NM in", values, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmNotIn(List<String> values) {
            addCriterion("OLD_OWNER_NM not in", values, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmBetween(String value1, String value2) {
            addCriterion("OLD_OWNER_NM between", value1, value2, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldOwnerNmNotBetween(String value1, String value2) {
            addCriterion("OLD_OWNER_NM not between", value1, value2, "oldOwnerNm");
            return (Criteria) this;
        }

        public Criteria andOldInfoIsNull() {
            addCriterion("OLD_INFO is null");
            return (Criteria) this;
        }

        public Criteria andOldInfoIsNotNull() {
            addCriterion("OLD_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andOldInfoEqualTo(String value) {
            addCriterion("OLD_INFO =", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoNotEqualTo(String value) {
            addCriterion("OLD_INFO <>", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoGreaterThan(String value) {
            addCriterion("OLD_INFO >", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_INFO >=", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoLessThan(String value) {
            addCriterion("OLD_INFO <", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoLessThanOrEqualTo(String value) {
            addCriterion("OLD_INFO <=", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoLike(String value) {
            addCriterion("OLD_INFO like", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoNotLike(String value) {
            addCriterion("OLD_INFO not like", value, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoIn(List<String> values) {
            addCriterion("OLD_INFO in", values, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoNotIn(List<String> values) {
            addCriterion("OLD_INFO not in", values, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoBetween(String value1, String value2) {
            addCriterion("OLD_INFO between", value1, value2, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andOldInfoNotBetween(String value1, String value2) {
            addCriterion("OLD_INFO not between", value1, value2, "oldInfo");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdIsNull() {
            addCriterion("NEW_EVAL_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdIsNotNull() {
            addCriterion("NEW_EVAL_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_ID =", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdNotEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_ID <>", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdGreaterThan(String value) {
            addCriterion("NEW_EVAL_ORG_ID >", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_ID >=", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdLessThan(String value) {
            addCriterion("NEW_EVAL_ORG_ID <", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdLessThanOrEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_ID <=", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdLike(String value) {
            addCriterion("NEW_EVAL_ORG_ID like", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdNotLike(String value) {
            addCriterion("NEW_EVAL_ORG_ID not like", value, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdIn(List<String> values) {
            addCriterion("NEW_EVAL_ORG_ID in", values, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdNotIn(List<String> values) {
            addCriterion("NEW_EVAL_ORG_ID not in", values, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdBetween(String value1, String value2) {
            addCriterion("NEW_EVAL_ORG_ID between", value1, value2, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgIdNotBetween(String value1, String value2) {
            addCriterion("NEW_EVAL_ORG_ID not between", value1, value2, "newEvalOrgId");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmIsNull() {
            addCriterion("NEW_EVAL_ORG_NM is null");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmIsNotNull() {
            addCriterion("NEW_EVAL_ORG_NM is not null");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_NM =", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmNotEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_NM <>", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmGreaterThan(String value) {
            addCriterion("NEW_EVAL_ORG_NM >", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_NM >=", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmLessThan(String value) {
            addCriterion("NEW_EVAL_ORG_NM <", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmLessThanOrEqualTo(String value) {
            addCriterion("NEW_EVAL_ORG_NM <=", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmLike(String value) {
            addCriterion("NEW_EVAL_ORG_NM like", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmNotLike(String value) {
            addCriterion("NEW_EVAL_ORG_NM not like", value, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmIn(List<String> values) {
            addCriterion("NEW_EVAL_ORG_NM in", values, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmNotIn(List<String> values) {
            addCriterion("NEW_EVAL_ORG_NM not in", values, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmBetween(String value1, String value2) {
            addCriterion("NEW_EVAL_ORG_NM between", value1, value2, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalOrgNmNotBetween(String value1, String value2) {
            addCriterion("NEW_EVAL_ORG_NM not between", value1, value2, "newEvalOrgNm");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValIsNull() {
            addCriterion("NEW_EVAL_NET_VAL is null");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValIsNotNull() {
            addCriterion("NEW_EVAL_NET_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValEqualTo(BigDecimal value) {
            addCriterion("NEW_EVAL_NET_VAL =", value, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValNotEqualTo(BigDecimal value) {
            addCriterion("NEW_EVAL_NET_VAL <>", value, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValGreaterThan(BigDecimal value) {
            addCriterion("NEW_EVAL_NET_VAL >", value, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NEW_EVAL_NET_VAL >=", value, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValLessThan(BigDecimal value) {
            addCriterion("NEW_EVAL_NET_VAL <", value, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NEW_EVAL_NET_VAL <=", value, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValIn(List<BigDecimal> values) {
            addCriterion("NEW_EVAL_NET_VAL in", values, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValNotIn(List<BigDecimal> values) {
            addCriterion("NEW_EVAL_NET_VAL not in", values, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEW_EVAL_NET_VAL between", value1, value2, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewEvalNetValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEW_EVAL_NET_VAL not between", value1, value2, "newEvalNetVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValIsNull() {
            addCriterion("NEW_CONFIRM_VAL is null");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValIsNotNull() {
            addCriterion("NEW_CONFIRM_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValEqualTo(BigDecimal value) {
            addCriterion("NEW_CONFIRM_VAL =", value, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValNotEqualTo(BigDecimal value) {
            addCriterion("NEW_CONFIRM_VAL <>", value, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValGreaterThan(BigDecimal value) {
            addCriterion("NEW_CONFIRM_VAL >", value, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NEW_CONFIRM_VAL >=", value, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValLessThan(BigDecimal value) {
            addCriterion("NEW_CONFIRM_VAL <", value, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NEW_CONFIRM_VAL <=", value, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValIn(List<BigDecimal> values) {
            addCriterion("NEW_CONFIRM_VAL in", values, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValNotIn(List<BigDecimal> values) {
            addCriterion("NEW_CONFIRM_VAL not in", values, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEW_CONFIRM_VAL between", value1, value2, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewConfirmValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEW_CONFIRM_VAL not between", value1, value2, "newConfirmVal");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridIsNull() {
            addCriterion("NEW_OWN_ERID is null");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridIsNotNull() {
            addCriterion("NEW_OWN_ERID is not null");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridEqualTo(String value) {
            addCriterion("NEW_OWN_ERID =", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridNotEqualTo(String value) {
            addCriterion("NEW_OWN_ERID <>", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridGreaterThan(String value) {
            addCriterion("NEW_OWN_ERID >", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_OWN_ERID >=", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridLessThan(String value) {
            addCriterion("NEW_OWN_ERID <", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridLessThanOrEqualTo(String value) {
            addCriterion("NEW_OWN_ERID <=", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridLike(String value) {
            addCriterion("NEW_OWN_ERID like", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridNotLike(String value) {
            addCriterion("NEW_OWN_ERID not like", value, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridIn(List<String> values) {
            addCriterion("NEW_OWN_ERID in", values, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridNotIn(List<String> values) {
            addCriterion("NEW_OWN_ERID not in", values, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridBetween(String value1, String value2) {
            addCriterion("NEW_OWN_ERID between", value1, value2, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnEridNotBetween(String value1, String value2) {
            addCriterion("NEW_OWN_ERID not between", value1, value2, "newOwnErid");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmIsNull() {
            addCriterion("NEW_OWNER_NM is null");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmIsNotNull() {
            addCriterion("NEW_OWNER_NM is not null");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmEqualTo(String value) {
            addCriterion("NEW_OWNER_NM =", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmNotEqualTo(String value) {
            addCriterion("NEW_OWNER_NM <>", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmGreaterThan(String value) {
            addCriterion("NEW_OWNER_NM >", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_OWNER_NM >=", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmLessThan(String value) {
            addCriterion("NEW_OWNER_NM <", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmLessThanOrEqualTo(String value) {
            addCriterion("NEW_OWNER_NM <=", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmLike(String value) {
            addCriterion("NEW_OWNER_NM like", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmNotLike(String value) {
            addCriterion("NEW_OWNER_NM not like", value, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmIn(List<String> values) {
            addCriterion("NEW_OWNER_NM in", values, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmNotIn(List<String> values) {
            addCriterion("NEW_OWNER_NM not in", values, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmBetween(String value1, String value2) {
            addCriterion("NEW_OWNER_NM between", value1, value2, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewOwnerNmNotBetween(String value1, String value2) {
            addCriterion("NEW_OWNER_NM not between", value1, value2, "newOwnerNm");
            return (Criteria) this;
        }

        public Criteria andNewInfoIsNull() {
            addCriterion("NEW_INFO is null");
            return (Criteria) this;
        }

        public Criteria andNewInfoIsNotNull() {
            addCriterion("NEW_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andNewInfoEqualTo(String value) {
            addCriterion("NEW_INFO =", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoNotEqualTo(String value) {
            addCriterion("NEW_INFO <>", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoGreaterThan(String value) {
            addCriterion("NEW_INFO >", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_INFO >=", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoLessThan(String value) {
            addCriterion("NEW_INFO <", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoLessThanOrEqualTo(String value) {
            addCriterion("NEW_INFO <=", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoLike(String value) {
            addCriterion("NEW_INFO like", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoNotLike(String value) {
            addCriterion("NEW_INFO not like", value, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoIn(List<String> values) {
            addCriterion("NEW_INFO in", values, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoNotIn(List<String> values) {
            addCriterion("NEW_INFO not in", values, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoBetween(String value1, String value2) {
            addCriterion("NEW_INFO between", value1, value2, "newInfo");
            return (Criteria) this;
        }

        public Criteria andNewInfoNotBetween(String value1, String value2) {
            addCriterion("NEW_INFO not between", value1, value2, "newInfo");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdIsNull() {
            addCriterion("OPT_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdIsNotNull() {
            addCriterion("OPT_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdEqualTo(String value) {
            addCriterion("OPT_ORG_ID =", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdNotEqualTo(String value) {
            addCriterion("OPT_ORG_ID <>", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdGreaterThan(String value) {
            addCriterion("OPT_ORG_ID >", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPT_ORG_ID >=", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdLessThan(String value) {
            addCriterion("OPT_ORG_ID <", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdLessThanOrEqualTo(String value) {
            addCriterion("OPT_ORG_ID <=", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdLike(String value) {
            addCriterion("OPT_ORG_ID like", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdNotLike(String value) {
            addCriterion("OPT_ORG_ID not like", value, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdIn(List<String> values) {
            addCriterion("OPT_ORG_ID in", values, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdNotIn(List<String> values) {
            addCriterion("OPT_ORG_ID not in", values, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdBetween(String value1, String value2) {
            addCriterion("OPT_ORG_ID between", value1, value2, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptOrgIdNotBetween(String value1, String value2) {
            addCriterion("OPT_ORG_ID not between", value1, value2, "optOrgId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdIsNull() {
            addCriterion("OPT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOptUserIdIsNotNull() {
            addCriterion("OPT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOptUserIdEqualTo(String value) {
            addCriterion("OPT_USER_ID =", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdNotEqualTo(String value) {
            addCriterion("OPT_USER_ID <>", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdGreaterThan(String value) {
            addCriterion("OPT_USER_ID >", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPT_USER_ID >=", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdLessThan(String value) {
            addCriterion("OPT_USER_ID <", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdLessThanOrEqualTo(String value) {
            addCriterion("OPT_USER_ID <=", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdLike(String value) {
            addCriterion("OPT_USER_ID like", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdNotLike(String value) {
            addCriterion("OPT_USER_ID not like", value, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdIn(List<String> values) {
            addCriterion("OPT_USER_ID in", values, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdNotIn(List<String> values) {
            addCriterion("OPT_USER_ID not in", values, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdBetween(String value1, String value2) {
            addCriterion("OPT_USER_ID between", value1, value2, "optUserId");
            return (Criteria) this;
        }

        public Criteria andOptUserIdNotBetween(String value1, String value2) {
            addCriterion("OPT_USER_ID not between", value1, value2, "optUserId");
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

        public Criteria andTlrIsNull() {
            addCriterion("TLR is null");
            return (Criteria) this;
        }

        public Criteria andTlrIsNotNull() {
            addCriterion("TLR is not null");
            return (Criteria) this;
        }

        public Criteria andTlrEqualTo(String value) {
            addCriterion("TLR =", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrNotEqualTo(String value) {
            addCriterion("TLR <>", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrGreaterThan(String value) {
            addCriterion("TLR >", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrGreaterThanOrEqualTo(String value) {
            addCriterion("TLR >=", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrLessThan(String value) {
            addCriterion("TLR <", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrLessThanOrEqualTo(String value) {
            addCriterion("TLR <=", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrLike(String value) {
            addCriterion("TLR like", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrNotLike(String value) {
            addCriterion("TLR not like", value, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrIn(List<String> values) {
            addCriterion("TLR in", values, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrNotIn(List<String> values) {
            addCriterion("TLR not in", values, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrBetween(String value1, String value2) {
            addCriterion("TLR between", value1, value2, "tlr");
            return (Criteria) this;
        }

        public Criteria andTlrNotBetween(String value1, String value2) {
            addCriterion("TLR not between", value1, value2, "tlr");
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

        public Criteria andOldCertTypIsNull() {
            addCriterion("OLD_CERT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andOldCertTypIsNotNull() {
            addCriterion("OLD_CERT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andOldCertTypEqualTo(String value) {
            addCriterion("OLD_CERT_TYP =", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypNotEqualTo(String value) {
            addCriterion("OLD_CERT_TYP <>", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypGreaterThan(String value) {
            addCriterion("OLD_CERT_TYP >", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_CERT_TYP >=", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypLessThan(String value) {
            addCriterion("OLD_CERT_TYP <", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypLessThanOrEqualTo(String value) {
            addCriterion("OLD_CERT_TYP <=", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypLike(String value) {
            addCriterion("OLD_CERT_TYP like", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypNotLike(String value) {
            addCriterion("OLD_CERT_TYP not like", value, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypIn(List<String> values) {
            addCriterion("OLD_CERT_TYP in", values, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypNotIn(List<String> values) {
            addCriterion("OLD_CERT_TYP not in", values, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypBetween(String value1, String value2) {
            addCriterion("OLD_CERT_TYP between", value1, value2, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertTypNotBetween(String value1, String value2) {
            addCriterion("OLD_CERT_TYP not between", value1, value2, "oldCertTyp");
            return (Criteria) this;
        }

        public Criteria andOldCertIdIsNull() {
            addCriterion("OLD_CERT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOldCertIdIsNotNull() {
            addCriterion("OLD_CERT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOldCertIdEqualTo(String value) {
            addCriterion("OLD_CERT_ID =", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdNotEqualTo(String value) {
            addCriterion("OLD_CERT_ID <>", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdGreaterThan(String value) {
            addCriterion("OLD_CERT_ID >", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_CERT_ID >=", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdLessThan(String value) {
            addCriterion("OLD_CERT_ID <", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdLessThanOrEqualTo(String value) {
            addCriterion("OLD_CERT_ID <=", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdLike(String value) {
            addCriterion("OLD_CERT_ID like", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdNotLike(String value) {
            addCriterion("OLD_CERT_ID not like", value, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdIn(List<String> values) {
            addCriterion("OLD_CERT_ID in", values, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdNotIn(List<String> values) {
            addCriterion("OLD_CERT_ID not in", values, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdBetween(String value1, String value2) {
            addCriterion("OLD_CERT_ID between", value1, value2, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertIdNotBetween(String value1, String value2) {
            addCriterion("OLD_CERT_ID not between", value1, value2, "oldCertId");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoIsNull() {
            addCriterion("OLD_CERT_LN_NO is null");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoIsNotNull() {
            addCriterion("OLD_CERT_LN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoEqualTo(String value) {
            addCriterion("OLD_CERT_LN_NO =", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoNotEqualTo(String value) {
            addCriterion("OLD_CERT_LN_NO <>", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoGreaterThan(String value) {
            addCriterion("OLD_CERT_LN_NO >", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_CERT_LN_NO >=", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoLessThan(String value) {
            addCriterion("OLD_CERT_LN_NO <", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoLessThanOrEqualTo(String value) {
            addCriterion("OLD_CERT_LN_NO <=", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoLike(String value) {
            addCriterion("OLD_CERT_LN_NO like", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoNotLike(String value) {
            addCriterion("OLD_CERT_LN_NO not like", value, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoIn(List<String> values) {
            addCriterion("OLD_CERT_LN_NO in", values, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoNotIn(List<String> values) {
            addCriterion("OLD_CERT_LN_NO not in", values, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoBetween(String value1, String value2) {
            addCriterion("OLD_CERT_LN_NO between", value1, value2, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andOldCertLnNoNotBetween(String value1, String value2) {
            addCriterion("OLD_CERT_LN_NO not between", value1, value2, "oldCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertTypIsNull() {
            addCriterion("NEW_CERT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andNewCertTypIsNotNull() {
            addCriterion("NEW_CERT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andNewCertTypEqualTo(String value) {
            addCriterion("NEW_CERT_TYP =", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypNotEqualTo(String value) {
            addCriterion("NEW_CERT_TYP <>", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypGreaterThan(String value) {
            addCriterion("NEW_CERT_TYP >", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_CERT_TYP >=", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypLessThan(String value) {
            addCriterion("NEW_CERT_TYP <", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypLessThanOrEqualTo(String value) {
            addCriterion("NEW_CERT_TYP <=", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypLike(String value) {
            addCriterion("NEW_CERT_TYP like", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypNotLike(String value) {
            addCriterion("NEW_CERT_TYP not like", value, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypIn(List<String> values) {
            addCriterion("NEW_CERT_TYP in", values, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypNotIn(List<String> values) {
            addCriterion("NEW_CERT_TYP not in", values, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypBetween(String value1, String value2) {
            addCriterion("NEW_CERT_TYP between", value1, value2, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertTypNotBetween(String value1, String value2) {
            addCriterion("NEW_CERT_TYP not between", value1, value2, "newCertTyp");
            return (Criteria) this;
        }

        public Criteria andNewCertIdIsNull() {
            addCriterion("NEW_CERT_ID is null");
            return (Criteria) this;
        }

        public Criteria andNewCertIdIsNotNull() {
            addCriterion("NEW_CERT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNewCertIdEqualTo(String value) {
            addCriterion("NEW_CERT_ID =", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdNotEqualTo(String value) {
            addCriterion("NEW_CERT_ID <>", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdGreaterThan(String value) {
            addCriterion("NEW_CERT_ID >", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_CERT_ID >=", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdLessThan(String value) {
            addCriterion("NEW_CERT_ID <", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdLessThanOrEqualTo(String value) {
            addCriterion("NEW_CERT_ID <=", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdLike(String value) {
            addCriterion("NEW_CERT_ID like", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdNotLike(String value) {
            addCriterion("NEW_CERT_ID not like", value, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdIn(List<String> values) {
            addCriterion("NEW_CERT_ID in", values, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdNotIn(List<String> values) {
            addCriterion("NEW_CERT_ID not in", values, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdBetween(String value1, String value2) {
            addCriterion("NEW_CERT_ID between", value1, value2, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertIdNotBetween(String value1, String value2) {
            addCriterion("NEW_CERT_ID not between", value1, value2, "newCertId");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoIsNull() {
            addCriterion("NEW_CERT_LN_NO is null");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoIsNotNull() {
            addCriterion("NEW_CERT_LN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoEqualTo(String value) {
            addCriterion("NEW_CERT_LN_NO =", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoNotEqualTo(String value) {
            addCriterion("NEW_CERT_LN_NO <>", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoGreaterThan(String value) {
            addCriterion("NEW_CERT_LN_NO >", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_CERT_LN_NO >=", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoLessThan(String value) {
            addCriterion("NEW_CERT_LN_NO <", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoLessThanOrEqualTo(String value) {
            addCriterion("NEW_CERT_LN_NO <=", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoLike(String value) {
            addCriterion("NEW_CERT_LN_NO like", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoNotLike(String value) {
            addCriterion("NEW_CERT_LN_NO not like", value, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoIn(List<String> values) {
            addCriterion("NEW_CERT_LN_NO in", values, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoNotIn(List<String> values) {
            addCriterion("NEW_CERT_LN_NO not in", values, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoBetween(String value1, String value2) {
            addCriterion("NEW_CERT_LN_NO between", value1, value2, "newCertLnNo");
            return (Criteria) this;
        }

        public Criteria andNewCertLnNoNotBetween(String value1, String value2) {
            addCriterion("NEW_CERT_LN_NO not between", value1, value2, "newCertLnNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}