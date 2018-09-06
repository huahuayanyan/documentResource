package com.huateng.scf.bas.crr.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrGntyAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrGntyAuditExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrGntyAuditExample(BCrrGntyAuditExample example) {
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

        public Criteria andGntyNmIsNull() {
            addCriterion("GNTY_NM is null");
            return (Criteria) this;
        }

        public Criteria andGntyNmIsNotNull() {
            addCriterion("GNTY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andGntyNmEqualTo(String value) {
            addCriterion("GNTY_NM =", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotEqualTo(String value) {
            addCriterion("GNTY_NM <>", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmGreaterThan(String value) {
            addCriterion("GNTY_NM >", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_NM >=", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmLessThan(String value) {
            addCriterion("GNTY_NM <", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmLessThanOrEqualTo(String value) {
            addCriterion("GNTY_NM <=", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmLike(String value) {
            addCriterion("GNTY_NM like", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotLike(String value) {
            addCriterion("GNTY_NM not like", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmIn(List<String> values) {
            addCriterion("GNTY_NM in", values, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotIn(List<String> values) {
            addCriterion("GNTY_NM not in", values, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmBetween(String value1, String value2) {
            addCriterion("GNTY_NM between", value1, value2, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotBetween(String value1, String value2) {
            addCriterion("GNTY_NM not between", value1, value2, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyTypIsNull() {
            addCriterion("GNTY_TYP is null");
            return (Criteria) this;
        }

        public Criteria andGntyTypIsNotNull() {
            addCriterion("GNTY_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andGntyTypEqualTo(String value) {
            addCriterion("GNTY_TYP =", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotEqualTo(String value) {
            addCriterion("GNTY_TYP <>", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypGreaterThan(String value) {
            addCriterion("GNTY_TYP >", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_TYP >=", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypLessThan(String value) {
            addCriterion("GNTY_TYP <", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypLessThanOrEqualTo(String value) {
            addCriterion("GNTY_TYP <=", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypLike(String value) {
            addCriterion("GNTY_TYP like", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotLike(String value) {
            addCriterion("GNTY_TYP not like", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypIn(List<String> values) {
            addCriterion("GNTY_TYP in", values, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotIn(List<String> values) {
            addCriterion("GNTY_TYP not in", values, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypBetween(String value1, String value2) {
            addCriterion("GNTY_TYP between", value1, value2, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotBetween(String value1, String value2) {
            addCriterion("GNTY_TYP not between", value1, value2, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyStatIsNull() {
            addCriterion("GNTY_STAT is null");
            return (Criteria) this;
        }

        public Criteria andGntyStatIsNotNull() {
            addCriterion("GNTY_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andGntyStatEqualTo(String value) {
            addCriterion("GNTY_STAT =", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatNotEqualTo(String value) {
            addCriterion("GNTY_STAT <>", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatGreaterThan(String value) {
            addCriterion("GNTY_STAT >", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_STAT >=", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatLessThan(String value) {
            addCriterion("GNTY_STAT <", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatLessThanOrEqualTo(String value) {
            addCriterion("GNTY_STAT <=", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatLike(String value) {
            addCriterion("GNTY_STAT like", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatNotLike(String value) {
            addCriterion("GNTY_STAT not like", value, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatIn(List<String> values) {
            addCriterion("GNTY_STAT in", values, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatNotIn(List<String> values) {
            addCriterion("GNTY_STAT not in", values, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatBetween(String value1, String value2) {
            addCriterion("GNTY_STAT between", value1, value2, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andGntyStatNotBetween(String value1, String value2) {
            addCriterion("GNTY_STAT not between", value1, value2, "gntyStat");
            return (Criteria) this;
        }

        public Criteria andHoldDtIsNull() {
            addCriterion("HOLD_DT is null");
            return (Criteria) this;
        }

        public Criteria andHoldDtIsNotNull() {
            addCriterion("HOLD_DT is not null");
            return (Criteria) this;
        }

        public Criteria andHoldDtEqualTo(String value) {
            addCriterion("HOLD_DT =", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtNotEqualTo(String value) {
            addCriterion("HOLD_DT <>", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtGreaterThan(String value) {
            addCriterion("HOLD_DT >", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtGreaterThanOrEqualTo(String value) {
            addCriterion("HOLD_DT >=", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtLessThan(String value) {
            addCriterion("HOLD_DT <", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtLessThanOrEqualTo(String value) {
            addCriterion("HOLD_DT <=", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtLike(String value) {
            addCriterion("HOLD_DT like", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtNotLike(String value) {
            addCriterion("HOLD_DT not like", value, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtIn(List<String> values) {
            addCriterion("HOLD_DT in", values, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtNotIn(List<String> values) {
            addCriterion("HOLD_DT not in", values, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtBetween(String value1, String value2) {
            addCriterion("HOLD_DT between", value1, value2, "holdDt");
            return (Criteria) this;
        }

        public Criteria andHoldDtNotBetween(String value1, String value2) {
            addCriterion("HOLD_DT not between", value1, value2, "holdDt");
            return (Criteria) this;
        }

        public Criteria andLostDtIsNull() {
            addCriterion("LOST_DT is null");
            return (Criteria) this;
        }

        public Criteria andLostDtIsNotNull() {
            addCriterion("LOST_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLostDtEqualTo(String value) {
            addCriterion("LOST_DT =", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtNotEqualTo(String value) {
            addCriterion("LOST_DT <>", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtGreaterThan(String value) {
            addCriterion("LOST_DT >", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtGreaterThanOrEqualTo(String value) {
            addCriterion("LOST_DT >=", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtLessThan(String value) {
            addCriterion("LOST_DT <", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtLessThanOrEqualTo(String value) {
            addCriterion("LOST_DT <=", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtLike(String value) {
            addCriterion("LOST_DT like", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtNotLike(String value) {
            addCriterion("LOST_DT not like", value, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtIn(List<String> values) {
            addCriterion("LOST_DT in", values, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtNotIn(List<String> values) {
            addCriterion("LOST_DT not in", values, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtBetween(String value1, String value2) {
            addCriterion("LOST_DT between", value1, value2, "lostDt");
            return (Criteria) this;
        }

        public Criteria andLostDtNotBetween(String value1, String value2) {
            addCriterion("LOST_DT not between", value1, value2, "lostDt");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtIsNull() {
            addCriterion("PLAN_RN_DT is null");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtIsNotNull() {
            addCriterion("PLAN_RN_DT is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtEqualTo(String value) {
            addCriterion("PLAN_RN_DT =", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtNotEqualTo(String value) {
            addCriterion("PLAN_RN_DT <>", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtGreaterThan(String value) {
            addCriterion("PLAN_RN_DT >", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_RN_DT >=", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtLessThan(String value) {
            addCriterion("PLAN_RN_DT <", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtLessThanOrEqualTo(String value) {
            addCriterion("PLAN_RN_DT <=", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtLike(String value) {
            addCriterion("PLAN_RN_DT like", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtNotLike(String value) {
            addCriterion("PLAN_RN_DT not like", value, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtIn(List<String> values) {
            addCriterion("PLAN_RN_DT in", values, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtNotIn(List<String> values) {
            addCriterion("PLAN_RN_DT not in", values, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtBetween(String value1, String value2) {
            addCriterion("PLAN_RN_DT between", value1, value2, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andPlanRnDtNotBetween(String value1, String value2) {
            addCriterion("PLAN_RN_DT not between", value1, value2, "planRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtIsNull() {
            addCriterion("FACT_RN_DT is null");
            return (Criteria) this;
        }

        public Criteria andFactRnDtIsNotNull() {
            addCriterion("FACT_RN_DT is not null");
            return (Criteria) this;
        }

        public Criteria andFactRnDtEqualTo(String value) {
            addCriterion("FACT_RN_DT =", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtNotEqualTo(String value) {
            addCriterion("FACT_RN_DT <>", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtGreaterThan(String value) {
            addCriterion("FACT_RN_DT >", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtGreaterThanOrEqualTo(String value) {
            addCriterion("FACT_RN_DT >=", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtLessThan(String value) {
            addCriterion("FACT_RN_DT <", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtLessThanOrEqualTo(String value) {
            addCriterion("FACT_RN_DT <=", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtLike(String value) {
            addCriterion("FACT_RN_DT like", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtNotLike(String value) {
            addCriterion("FACT_RN_DT not like", value, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtIn(List<String> values) {
            addCriterion("FACT_RN_DT in", values, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtNotIn(List<String> values) {
            addCriterion("FACT_RN_DT not in", values, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtBetween(String value1, String value2) {
            addCriterion("FACT_RN_DT between", value1, value2, "factRnDt");
            return (Criteria) this;
        }

        public Criteria andFactRnDtNotBetween(String value1, String value2) {
            addCriterion("FACT_RN_DT not between", value1, value2, "factRnDt");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}