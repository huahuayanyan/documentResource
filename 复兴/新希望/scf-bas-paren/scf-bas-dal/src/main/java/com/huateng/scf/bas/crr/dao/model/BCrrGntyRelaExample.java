package com.huateng.scf.bas.crr.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrGntyRelaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrGntyRelaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrGntyRelaExample(BCrrGntyRelaExample example) {
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

        public Criteria andRltNoIsNull() {
            addCriterion("RLT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRltNoIsNotNull() {
            addCriterion("RLT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRltNoEqualTo(String value) {
            addCriterion("RLT_NO =", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoNotEqualTo(String value) {
            addCriterion("RLT_NO <>", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoGreaterThan(String value) {
            addCriterion("RLT_NO >", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_NO >=", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoLessThan(String value) {
            addCriterion("RLT_NO <", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoLessThanOrEqualTo(String value) {
            addCriterion("RLT_NO <=", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoLike(String value) {
            addCriterion("RLT_NO like", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoNotLike(String value) {
            addCriterion("RLT_NO not like", value, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoIn(List<String> values) {
            addCriterion("RLT_NO in", values, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoNotIn(List<String> values) {
            addCriterion("RLT_NO not in", values, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoBetween(String value1, String value2) {
            addCriterion("RLT_NO between", value1, value2, "rltNo");
            return (Criteria) this;
        }

        public Criteria andRltNoNotBetween(String value1, String value2) {
            addCriterion("RLT_NO not between", value1, value2, "rltNo");
            return (Criteria) this;
        }

        public Criteria andConNoIsNull() {
            addCriterion("CON_NO is null");
            return (Criteria) this;
        }

        public Criteria andConNoIsNotNull() {
            addCriterion("CON_NO is not null");
            return (Criteria) this;
        }

        public Criteria andConNoEqualTo(String value) {
            addCriterion("CON_NO =", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotEqualTo(String value) {
            addCriterion("CON_NO <>", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoGreaterThan(String value) {
            addCriterion("CON_NO >", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoGreaterThanOrEqualTo(String value) {
            addCriterion("CON_NO >=", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoLessThan(String value) {
            addCriterion("CON_NO <", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoLessThanOrEqualTo(String value) {
            addCriterion("CON_NO <=", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoLike(String value) {
            addCriterion("CON_NO like", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotLike(String value) {
            addCriterion("CON_NO not like", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoIn(List<String> values) {
            addCriterion("CON_NO in", values, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotIn(List<String> values) {
            addCriterion("CON_NO not in", values, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoBetween(String value1, String value2) {
            addCriterion("CON_NO between", value1, value2, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotBetween(String value1, String value2) {
            addCriterion("CON_NO not between", value1, value2, "conNo");
            return (Criteria) this;
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

        public Criteria andChannelIsNull() {
            addCriterion("CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("CHANNEL <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("CHANNEL >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("CHANNEL <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("CHANNEL like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("CHANNEL not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("CHANNEL in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("CHANNEL not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("CHANNEL between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("CHANNEL not between", value1, value2, "channel");
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

        public Criteria andOthGntyRidIsNull() {
            addCriterion("OTH_GNTY_RID is null");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidIsNotNull() {
            addCriterion("OTH_GNTY_RID is not null");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidEqualTo(String value) {
            addCriterion("OTH_GNTY_RID =", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidNotEqualTo(String value) {
            addCriterion("OTH_GNTY_RID <>", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidGreaterThan(String value) {
            addCriterion("OTH_GNTY_RID >", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidGreaterThanOrEqualTo(String value) {
            addCriterion("OTH_GNTY_RID >=", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidLessThan(String value) {
            addCriterion("OTH_GNTY_RID <", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidLessThanOrEqualTo(String value) {
            addCriterion("OTH_GNTY_RID <=", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidLike(String value) {
            addCriterion("OTH_GNTY_RID like", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidNotLike(String value) {
            addCriterion("OTH_GNTY_RID not like", value, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidIn(List<String> values) {
            addCriterion("OTH_GNTY_RID in", values, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidNotIn(List<String> values) {
            addCriterion("OTH_GNTY_RID not in", values, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidBetween(String value1, String value2) {
            addCriterion("OTH_GNTY_RID between", value1, value2, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andOthGntyRidNotBetween(String value1, String value2) {
            addCriterion("OTH_GNTY_RID not between", value1, value2, "othGntyRid");
            return (Criteria) this;
        }

        public Criteria andGntySumIsNull() {
            addCriterion("GNTY_SUM is null");
            return (Criteria) this;
        }

        public Criteria andGntySumIsNotNull() {
            addCriterion("GNTY_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andGntySumEqualTo(String value) {
            addCriterion("GNTY_SUM =", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumNotEqualTo(String value) {
            addCriterion("GNTY_SUM <>", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumGreaterThan(String value) {
            addCriterion("GNTY_SUM >", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_SUM >=", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumLessThan(String value) {
            addCriterion("GNTY_SUM <", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumLessThanOrEqualTo(String value) {
            addCriterion("GNTY_SUM <=", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumLike(String value) {
            addCriterion("GNTY_SUM like", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumNotLike(String value) {
            addCriterion("GNTY_SUM not like", value, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumIn(List<String> values) {
            addCriterion("GNTY_SUM in", values, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumNotIn(List<String> values) {
            addCriterion("GNTY_SUM not in", values, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumBetween(String value1, String value2) {
            addCriterion("GNTY_SUM between", value1, value2, "gntySum");
            return (Criteria) this;
        }

        public Criteria andGntySumNotBetween(String value1, String value2) {
            addCriterion("GNTY_SUM not between", value1, value2, "gntySum");
            return (Criteria) this;
        }

        public Criteria andDesIsNull() {
            addCriterion("DES is null");
            return (Criteria) this;
        }

        public Criteria andDesIsNotNull() {
            addCriterion("DES is not null");
            return (Criteria) this;
        }

        public Criteria andDesEqualTo(String value) {
            addCriterion("DES =", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotEqualTo(String value) {
            addCriterion("DES <>", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThan(String value) {
            addCriterion("DES >", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThanOrEqualTo(String value) {
            addCriterion("DES >=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThan(String value) {
            addCriterion("DES <", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThanOrEqualTo(String value) {
            addCriterion("DES <=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLike(String value) {
            addCriterion("DES like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotLike(String value) {
            addCriterion("DES not like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesIn(List<String> values) {
            addCriterion("DES in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotIn(List<String> values) {
            addCriterion("DES not in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesBetween(String value1, String value2) {
            addCriterion("DES between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotBetween(String value1, String value2) {
            addCriterion("DES not between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andPayOrdIsNull() {
            addCriterion("PAY_ORD is null");
            return (Criteria) this;
        }

        public Criteria andPayOrdIsNotNull() {
            addCriterion("PAY_ORD is not null");
            return (Criteria) this;
        }

        public Criteria andPayOrdEqualTo(String value) {
            addCriterion("PAY_ORD =", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdNotEqualTo(String value) {
            addCriterion("PAY_ORD <>", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdGreaterThan(String value) {
            addCriterion("PAY_ORD >", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_ORD >=", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdLessThan(String value) {
            addCriterion("PAY_ORD <", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdLessThanOrEqualTo(String value) {
            addCriterion("PAY_ORD <=", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdLike(String value) {
            addCriterion("PAY_ORD like", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdNotLike(String value) {
            addCriterion("PAY_ORD not like", value, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdIn(List<String> values) {
            addCriterion("PAY_ORD in", values, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdNotIn(List<String> values) {
            addCriterion("PAY_ORD not in", values, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdBetween(String value1, String value2) {
            addCriterion("PAY_ORD between", value1, value2, "payOrd");
            return (Criteria) this;
        }

        public Criteria andPayOrdNotBetween(String value1, String value2) {
            addCriterion("PAY_ORD not between", value1, value2, "payOrd");
            return (Criteria) this;
        }

        public Criteria andTypIsNull() {
            addCriterion("TYP is null");
            return (Criteria) this;
        }

        public Criteria andTypIsNotNull() {
            addCriterion("TYP is not null");
            return (Criteria) this;
        }

        public Criteria andTypEqualTo(String value) {
            addCriterion("TYP =", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypNotEqualTo(String value) {
            addCriterion("TYP <>", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypGreaterThan(String value) {
            addCriterion("TYP >", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypGreaterThanOrEqualTo(String value) {
            addCriterion("TYP >=", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypLessThan(String value) {
            addCriterion("TYP <", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypLessThanOrEqualTo(String value) {
            addCriterion("TYP <=", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypLike(String value) {
            addCriterion("TYP like", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypNotLike(String value) {
            addCriterion("TYP not like", value, "typ");
            return (Criteria) this;
        }

        public Criteria andTypIn(List<String> values) {
            addCriterion("TYP in", values, "typ");
            return (Criteria) this;
        }

        public Criteria andTypNotIn(List<String> values) {
            addCriterion("TYP not in", values, "typ");
            return (Criteria) this;
        }

        public Criteria andTypBetween(String value1, String value2) {
            addCriterion("TYP between", value1, value2, "typ");
            return (Criteria) this;
        }

        public Criteria andTypNotBetween(String value1, String value2) {
            addCriterion("TYP not between", value1, value2, "typ");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}