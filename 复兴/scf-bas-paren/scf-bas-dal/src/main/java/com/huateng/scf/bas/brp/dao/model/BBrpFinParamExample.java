package com.huateng.scf.bas.brp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBrpFinParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBrpFinParamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BBrpFinParamExample(BBrpFinParamExample example) {
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

        public Criteria andTitleIdIsNull() {
            addCriterion("TITLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNotNull() {
            addCriterion("TITLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdEqualTo(String value) {
            addCriterion("TITLE_ID =", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotEqualTo(String value) {
            addCriterion("TITLE_ID <>", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThan(String value) {
            addCriterion("TITLE_ID >", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE_ID >=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThan(String value) {
            addCriterion("TITLE_ID <", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThanOrEqualTo(String value) {
            addCriterion("TITLE_ID <=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLike(String value) {
            addCriterion("TITLE_ID like", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotLike(String value) {
            addCriterion("TITLE_ID not like", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIn(List<String> values) {
            addCriterion("TITLE_ID in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotIn(List<String> values) {
            addCriterion("TITLE_ID not in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdBetween(String value1, String value2) {
            addCriterion("TITLE_ID between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotBetween(String value1, String value2) {
            addCriterion("TITLE_ID not between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTradeAverageIsNull() {
            addCriterion("TRADE_AVERAGE is null");
            return (Criteria) this;
        }

        public Criteria andTradeAverageIsNotNull() {
            addCriterion("TRADE_AVERAGE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAverageEqualTo(BigDecimal value) {
            addCriterion("TRADE_AVERAGE =", value, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageNotEqualTo(BigDecimal value) {
            addCriterion("TRADE_AVERAGE <>", value, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageGreaterThan(BigDecimal value) {
            addCriterion("TRADE_AVERAGE >", value, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADE_AVERAGE >=", value, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageLessThan(BigDecimal value) {
            addCriterion("TRADE_AVERAGE <", value, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADE_AVERAGE <=", value, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageIn(List<BigDecimal> values) {
            addCriterion("TRADE_AVERAGE in", values, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageNotIn(List<BigDecimal> values) {
            addCriterion("TRADE_AVERAGE not in", values, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADE_AVERAGE between", value1, value2, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andTradeAverageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADE_AVERAGE not between", value1, value2, "tradeAverage");
            return (Criteria) this;
        }

        public Criteria andSubjLowerIsNull() {
            addCriterion("SUBJ_LOWER is null");
            return (Criteria) this;
        }

        public Criteria andSubjLowerIsNotNull() {
            addCriterion("SUBJ_LOWER is not null");
            return (Criteria) this;
        }

        public Criteria andSubjLowerEqualTo(String value) {
            addCriterion("SUBJ_LOWER =", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerNotEqualTo(String value) {
            addCriterion("SUBJ_LOWER <>", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerGreaterThan(String value) {
            addCriterion("SUBJ_LOWER >", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJ_LOWER >=", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerLessThan(String value) {
            addCriterion("SUBJ_LOWER <", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerLessThanOrEqualTo(String value) {
            addCriterion("SUBJ_LOWER <=", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerLike(String value) {
            addCriterion("SUBJ_LOWER like", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerNotLike(String value) {
            addCriterion("SUBJ_LOWER not like", value, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerIn(List<String> values) {
            addCriterion("SUBJ_LOWER in", values, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerNotIn(List<String> values) {
            addCriterion("SUBJ_LOWER not in", values, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerBetween(String value1, String value2) {
            addCriterion("SUBJ_LOWER between", value1, value2, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowerNotBetween(String value1, String value2) {
            addCriterion("SUBJ_LOWER not between", value1, value2, "subjLower");
            return (Criteria) this;
        }

        public Criteria andSubjLowIsNull() {
            addCriterion("SUBJ_LOW is null");
            return (Criteria) this;
        }

        public Criteria andSubjLowIsNotNull() {
            addCriterion("SUBJ_LOW is not null");
            return (Criteria) this;
        }

        public Criteria andSubjLowEqualTo(String value) {
            addCriterion("SUBJ_LOW =", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowNotEqualTo(String value) {
            addCriterion("SUBJ_LOW <>", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowGreaterThan(String value) {
            addCriterion("SUBJ_LOW >", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJ_LOW >=", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowLessThan(String value) {
            addCriterion("SUBJ_LOW <", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowLessThanOrEqualTo(String value) {
            addCriterion("SUBJ_LOW <=", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowLike(String value) {
            addCriterion("SUBJ_LOW like", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowNotLike(String value) {
            addCriterion("SUBJ_LOW not like", value, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowIn(List<String> values) {
            addCriterion("SUBJ_LOW in", values, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowNotIn(List<String> values) {
            addCriterion("SUBJ_LOW not in", values, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowBetween(String value1, String value2) {
            addCriterion("SUBJ_LOW between", value1, value2, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjLowNotBetween(String value1, String value2) {
            addCriterion("SUBJ_LOW not between", value1, value2, "subjLow");
            return (Criteria) this;
        }

        public Criteria andSubjMidiIsNull() {
            addCriterion("SUBJ_MIDI is null");
            return (Criteria) this;
        }

        public Criteria andSubjMidiIsNotNull() {
            addCriterion("SUBJ_MIDI is not null");
            return (Criteria) this;
        }

        public Criteria andSubjMidiEqualTo(String value) {
            addCriterion("SUBJ_MIDI =", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiNotEqualTo(String value) {
            addCriterion("SUBJ_MIDI <>", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiGreaterThan(String value) {
            addCriterion("SUBJ_MIDI >", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJ_MIDI >=", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiLessThan(String value) {
            addCriterion("SUBJ_MIDI <", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiLessThanOrEqualTo(String value) {
            addCriterion("SUBJ_MIDI <=", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiLike(String value) {
            addCriterion("SUBJ_MIDI like", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiNotLike(String value) {
            addCriterion("SUBJ_MIDI not like", value, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiIn(List<String> values) {
            addCriterion("SUBJ_MIDI in", values, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiNotIn(List<String> values) {
            addCriterion("SUBJ_MIDI not in", values, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiBetween(String value1, String value2) {
            addCriterion("SUBJ_MIDI between", value1, value2, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjMidiNotBetween(String value1, String value2) {
            addCriterion("SUBJ_MIDI not between", value1, value2, "subjMidi");
            return (Criteria) this;
        }

        public Criteria andSubjHighIsNull() {
            addCriterion("SUBJ_HIGH is null");
            return (Criteria) this;
        }

        public Criteria andSubjHighIsNotNull() {
            addCriterion("SUBJ_HIGH is not null");
            return (Criteria) this;
        }

        public Criteria andSubjHighEqualTo(String value) {
            addCriterion("SUBJ_HIGH =", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighNotEqualTo(String value) {
            addCriterion("SUBJ_HIGH <>", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighGreaterThan(String value) {
            addCriterion("SUBJ_HIGH >", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJ_HIGH >=", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighLessThan(String value) {
            addCriterion("SUBJ_HIGH <", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighLessThanOrEqualTo(String value) {
            addCriterion("SUBJ_HIGH <=", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighLike(String value) {
            addCriterion("SUBJ_HIGH like", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighNotLike(String value) {
            addCriterion("SUBJ_HIGH not like", value, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighIn(List<String> values) {
            addCriterion("SUBJ_HIGH in", values, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighNotIn(List<String> values) {
            addCriterion("SUBJ_HIGH not in", values, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighBetween(String value1, String value2) {
            addCriterion("SUBJ_HIGH between", value1, value2, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHighNotBetween(String value1, String value2) {
            addCriterion("SUBJ_HIGH not between", value1, value2, "subjHigh");
            return (Criteria) this;
        }

        public Criteria andSubjHigherIsNull() {
            addCriterion("SUBJ_HIGHER is null");
            return (Criteria) this;
        }

        public Criteria andSubjHigherIsNotNull() {
            addCriterion("SUBJ_HIGHER is not null");
            return (Criteria) this;
        }

        public Criteria andSubjHigherEqualTo(String value) {
            addCriterion("SUBJ_HIGHER =", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherNotEqualTo(String value) {
            addCriterion("SUBJ_HIGHER <>", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherGreaterThan(String value) {
            addCriterion("SUBJ_HIGHER >", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJ_HIGHER >=", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherLessThan(String value) {
            addCriterion("SUBJ_HIGHER <", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherLessThanOrEqualTo(String value) {
            addCriterion("SUBJ_HIGHER <=", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherLike(String value) {
            addCriterion("SUBJ_HIGHER like", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherNotLike(String value) {
            addCriterion("SUBJ_HIGHER not like", value, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherIn(List<String> values) {
            addCriterion("SUBJ_HIGHER in", values, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherNotIn(List<String> values) {
            addCriterion("SUBJ_HIGHER not in", values, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherBetween(String value1, String value2) {
            addCriterion("SUBJ_HIGHER between", value1, value2, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andSubjHigherNotBetween(String value1, String value2) {
            addCriterion("SUBJ_HIGHER not between", value1, value2, "subjHigher");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNull() {
            addCriterion("TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNotNull() {
            addCriterion("TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andTlrnoEqualTo(String value) {
            addCriterion("TLRNO =", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotEqualTo(String value) {
            addCriterion("TLRNO <>", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThan(String value) {
            addCriterion("TLRNO >", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("TLRNO >=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThan(String value) {
            addCriterion("TLRNO <", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThanOrEqualTo(String value) {
            addCriterion("TLRNO <=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLike(String value) {
            addCriterion("TLRNO like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotLike(String value) {
            addCriterion("TLRNO not like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoIn(List<String> values) {
            addCriterion("TLRNO in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotIn(List<String> values) {
            addCriterion("TLRNO not in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoBetween(String value1, String value2) {
            addCriterion("TLRNO between", value1, value2, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotBetween(String value1, String value2) {
            addCriterion("TLRNO not between", value1, value2, "tlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNull() {
            addCriterion("LAST_UPD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNotNull() {
            addCriterion("LAST_UPD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE =", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE <>", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThan(Date value) {
            addCriterion("LAST_UPD_DATE >", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE >=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThan(Date value) {
            addCriterion("LAST_UPD_DATE <", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_DATE <=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIn(List<Date> values) {
            addCriterion("LAST_UPD_DATE in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotIn(List<Date> values) {
            addCriterion("LAST_UPD_DATE not in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_DATE between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_DATE not between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}