package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrBillInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrBillInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrBillInfoExample(BCrrBillInfoExample example) {
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

        public Criteria andBillIdIsNull() {
            addCriterion("BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("BILL_ID =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("BILL_ID <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("BILL_ID >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_ID >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("BILL_ID <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("BILL_ID <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("BILL_ID like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("BILL_ID not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("BILL_ID in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("BILL_ID not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("BILL_ID between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("BILL_ID not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andExtIdIsNull() {
            addCriterion("EXT_ID is null");
            return (Criteria) this;
        }

        public Criteria andExtIdIsNotNull() {
            addCriterion("EXT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExtIdEqualTo(String value) {
            addCriterion("EXT_ID =", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotEqualTo(String value) {
            addCriterion("EXT_ID <>", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThan(String value) {
            addCriterion("EXT_ID >", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_ID >=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThan(String value) {
            addCriterion("EXT_ID <", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLessThanOrEqualTo(String value) {
            addCriterion("EXT_ID <=", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdLike(String value) {
            addCriterion("EXT_ID like", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotLike(String value) {
            addCriterion("EXT_ID not like", value, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdIn(List<String> values) {
            addCriterion("EXT_ID in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotIn(List<String> values) {
            addCriterion("EXT_ID not in", values, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdBetween(String value1, String value2) {
            addCriterion("EXT_ID between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andExtIdNotBetween(String value1, String value2) {
            addCriterion("EXT_ID not between", value1, value2, "extId");
            return (Criteria) this;
        }

        public Criteria andRelaTypIsNull() {
            addCriterion("RELA_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRelaTypIsNotNull() {
            addCriterion("RELA_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRelaTypEqualTo(String value) {
            addCriterion("RELA_TYP =", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotEqualTo(String value) {
            addCriterion("RELA_TYP <>", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypGreaterThan(String value) {
            addCriterion("RELA_TYP >", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_TYP >=", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLessThan(String value) {
            addCriterion("RELA_TYP <", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLessThanOrEqualTo(String value) {
            addCriterion("RELA_TYP <=", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLike(String value) {
            addCriterion("RELA_TYP like", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotLike(String value) {
            addCriterion("RELA_TYP not like", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypIn(List<String> values) {
            addCriterion("RELA_TYP in", values, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotIn(List<String> values) {
            addCriterion("RELA_TYP not in", values, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypBetween(String value1, String value2) {
            addCriterion("RELA_TYP between", value1, value2, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotBetween(String value1, String value2) {
            addCriterion("RELA_TYP not between", value1, value2, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNull() {
            addCriterion("RELA_NO is null");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNotNull() {
            addCriterion("RELA_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRelaNoEqualTo(String value) {
            addCriterion("RELA_NO =", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotEqualTo(String value) {
            addCriterion("RELA_NO <>", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThan(String value) {
            addCriterion("RELA_NO >", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_NO >=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThan(String value) {
            addCriterion("RELA_NO <", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThanOrEqualTo(String value) {
            addCriterion("RELA_NO <=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLike(String value) {
            addCriterion("RELA_NO like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotLike(String value) {
            addCriterion("RELA_NO not like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoIn(List<String> values) {
            addCriterion("RELA_NO in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotIn(List<String> values) {
            addCriterion("RELA_NO not in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoBetween(String value1, String value2) {
            addCriterion("RELA_NO between", value1, value2, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotBetween(String value1, String value2) {
            addCriterion("RELA_NO not between", value1, value2, "relaNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNull() {
            addCriterion("BILL_NO is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("BILL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("BILL_NO =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("BILL_NO <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("BILL_NO >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_NO >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("BILL_NO <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("BILL_NO <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("BILL_NO like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("BILL_NO not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("BILL_NO in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("BILL_NO not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("BILL_NO between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("BILL_NO not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillTypIsNull() {
            addCriterion("BILL_TYP is null");
            return (Criteria) this;
        }

        public Criteria andBillTypIsNotNull() {
            addCriterion("BILL_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypEqualTo(String value) {
            addCriterion("BILL_TYP =", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypNotEqualTo(String value) {
            addCriterion("BILL_TYP <>", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypGreaterThan(String value) {
            addCriterion("BILL_TYP >", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_TYP >=", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypLessThan(String value) {
            addCriterion("BILL_TYP <", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypLessThanOrEqualTo(String value) {
            addCriterion("BILL_TYP <=", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypLike(String value) {
            addCriterion("BILL_TYP like", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypNotLike(String value) {
            addCriterion("BILL_TYP not like", value, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypIn(List<String> values) {
            addCriterion("BILL_TYP in", values, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypNotIn(List<String> values) {
            addCriterion("BILL_TYP not in", values, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypBetween(String value1, String value2) {
            addCriterion("BILL_TYP between", value1, value2, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillTypNotBetween(String value1, String value2) {
            addCriterion("BILL_TYP not between", value1, value2, "billTyp");
            return (Criteria) this;
        }

        public Criteria andBillStatIsNull() {
            addCriterion("BILL_STAT is null");
            return (Criteria) this;
        }

        public Criteria andBillStatIsNotNull() {
            addCriterion("BILL_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatEqualTo(String value) {
            addCriterion("BILL_STAT =", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatNotEqualTo(String value) {
            addCriterion("BILL_STAT <>", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatGreaterThan(String value) {
            addCriterion("BILL_STAT >", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_STAT >=", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatLessThan(String value) {
            addCriterion("BILL_STAT <", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatLessThanOrEqualTo(String value) {
            addCriterion("BILL_STAT <=", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatLike(String value) {
            addCriterion("BILL_STAT like", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatNotLike(String value) {
            addCriterion("BILL_STAT not like", value, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatIn(List<String> values) {
            addCriterion("BILL_STAT in", values, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatNotIn(List<String> values) {
            addCriterion("BILL_STAT not in", values, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatBetween(String value1, String value2) {
            addCriterion("BILL_STAT between", value1, value2, "billStat");
            return (Criteria) this;
        }

        public Criteria andBillStatNotBetween(String value1, String value2) {
            addCriterion("BILL_STAT not between", value1, value2, "billStat");
            return (Criteria) this;
        }

        public Criteria andPrpsIsNull() {
            addCriterion("PRPS is null");
            return (Criteria) this;
        }

        public Criteria andPrpsIsNotNull() {
            addCriterion("PRPS is not null");
            return (Criteria) this;
        }

        public Criteria andPrpsEqualTo(String value) {
            addCriterion("PRPS =", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotEqualTo(String value) {
            addCriterion("PRPS <>", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsGreaterThan(String value) {
            addCriterion("PRPS >", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsGreaterThanOrEqualTo(String value) {
            addCriterion("PRPS >=", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsLessThan(String value) {
            addCriterion("PRPS <", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsLessThanOrEqualTo(String value) {
            addCriterion("PRPS <=", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsLike(String value) {
            addCriterion("PRPS like", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotLike(String value) {
            addCriterion("PRPS not like", value, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsIn(List<String> values) {
            addCriterion("PRPS in", values, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotIn(List<String> values) {
            addCriterion("PRPS not in", values, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsBetween(String value1, String value2) {
            addCriterion("PRPS between", value1, value2, "prps");
            return (Criteria) this;
        }

        public Criteria andPrpsNotBetween(String value1, String value2) {
            addCriterion("PRPS not between", value1, value2, "prps");
            return (Criteria) this;
        }

        public Criteria andWrtIdIsNull() {
            addCriterion("WRT_ID is null");
            return (Criteria) this;
        }

        public Criteria andWrtIdIsNotNull() {
            addCriterion("WRT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWrtIdEqualTo(String value) {
            addCriterion("WRT_ID =", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdNotEqualTo(String value) {
            addCriterion("WRT_ID <>", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdGreaterThan(String value) {
            addCriterion("WRT_ID >", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdGreaterThanOrEqualTo(String value) {
            addCriterion("WRT_ID >=", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdLessThan(String value) {
            addCriterion("WRT_ID <", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdLessThanOrEqualTo(String value) {
            addCriterion("WRT_ID <=", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdLike(String value) {
            addCriterion("WRT_ID like", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdNotLike(String value) {
            addCriterion("WRT_ID not like", value, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdIn(List<String> values) {
            addCriterion("WRT_ID in", values, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdNotIn(List<String> values) {
            addCriterion("WRT_ID not in", values, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdBetween(String value1, String value2) {
            addCriterion("WRT_ID between", value1, value2, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtIdNotBetween(String value1, String value2) {
            addCriterion("WRT_ID not between", value1, value2, "wrtId");
            return (Criteria) this;
        }

        public Criteria andWrtNmIsNull() {
            addCriterion("WRT_NM is null");
            return (Criteria) this;
        }

        public Criteria andWrtNmIsNotNull() {
            addCriterion("WRT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andWrtNmEqualTo(String value) {
            addCriterion("WRT_NM =", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmNotEqualTo(String value) {
            addCriterion("WRT_NM <>", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmGreaterThan(String value) {
            addCriterion("WRT_NM >", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmGreaterThanOrEqualTo(String value) {
            addCriterion("WRT_NM >=", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmLessThan(String value) {
            addCriterion("WRT_NM <", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmLessThanOrEqualTo(String value) {
            addCriterion("WRT_NM <=", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmLike(String value) {
            addCriterion("WRT_NM like", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmNotLike(String value) {
            addCriterion("WRT_NM not like", value, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmIn(List<String> values) {
            addCriterion("WRT_NM in", values, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmNotIn(List<String> values) {
            addCriterion("WRT_NM not in", values, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmBetween(String value1, String value2) {
            addCriterion("WRT_NM between", value1, value2, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andWrtNmNotBetween(String value1, String value2) {
            addCriterion("WRT_NM not between", value1, value2, "wrtNm");
            return (Criteria) this;
        }

        public Criteria andHldIdIsNull() {
            addCriterion("HLD_ID is null");
            return (Criteria) this;
        }

        public Criteria andHldIdIsNotNull() {
            addCriterion("HLD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHldIdEqualTo(String value) {
            addCriterion("HLD_ID =", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdNotEqualTo(String value) {
            addCriterion("HLD_ID <>", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdGreaterThan(String value) {
            addCriterion("HLD_ID >", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdGreaterThanOrEqualTo(String value) {
            addCriterion("HLD_ID >=", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdLessThan(String value) {
            addCriterion("HLD_ID <", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdLessThanOrEqualTo(String value) {
            addCriterion("HLD_ID <=", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdLike(String value) {
            addCriterion("HLD_ID like", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdNotLike(String value) {
            addCriterion("HLD_ID not like", value, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdIn(List<String> values) {
            addCriterion("HLD_ID in", values, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdNotIn(List<String> values) {
            addCriterion("HLD_ID not in", values, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdBetween(String value1, String value2) {
            addCriterion("HLD_ID between", value1, value2, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldIdNotBetween(String value1, String value2) {
            addCriterion("HLD_ID not between", value1, value2, "hldId");
            return (Criteria) this;
        }

        public Criteria andHldNmIsNull() {
            addCriterion("HLD_NM is null");
            return (Criteria) this;
        }

        public Criteria andHldNmIsNotNull() {
            addCriterion("HLD_NM is not null");
            return (Criteria) this;
        }

        public Criteria andHldNmEqualTo(String value) {
            addCriterion("HLD_NM =", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmNotEqualTo(String value) {
            addCriterion("HLD_NM <>", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmGreaterThan(String value) {
            addCriterion("HLD_NM >", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmGreaterThanOrEqualTo(String value) {
            addCriterion("HLD_NM >=", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmLessThan(String value) {
            addCriterion("HLD_NM <", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmLessThanOrEqualTo(String value) {
            addCriterion("HLD_NM <=", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmLike(String value) {
            addCriterion("HLD_NM like", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmNotLike(String value) {
            addCriterion("HLD_NM not like", value, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmIn(List<String> values) {
            addCriterion("HLD_NM in", values, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmNotIn(List<String> values) {
            addCriterion("HLD_NM not in", values, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmBetween(String value1, String value2) {
            addCriterion("HLD_NM between", value1, value2, "hldNm");
            return (Criteria) this;
        }

        public Criteria andHldNmNotBetween(String value1, String value2) {
            addCriterion("HLD_NM not between", value1, value2, "hldNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdIsNull() {
            addCriterion("BNFCY_ID is null");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdIsNotNull() {
            addCriterion("BNFCY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdEqualTo(String value) {
            addCriterion("BNFCY_ID =", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdNotEqualTo(String value) {
            addCriterion("BNFCY_ID <>", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdGreaterThan(String value) {
            addCriterion("BNFCY_ID >", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdGreaterThanOrEqualTo(String value) {
            addCriterion("BNFCY_ID >=", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdLessThan(String value) {
            addCriterion("BNFCY_ID <", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdLessThanOrEqualTo(String value) {
            addCriterion("BNFCY_ID <=", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdLike(String value) {
            addCriterion("BNFCY_ID like", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdNotLike(String value) {
            addCriterion("BNFCY_ID not like", value, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdIn(List<String> values) {
            addCriterion("BNFCY_ID in", values, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdNotIn(List<String> values) {
            addCriterion("BNFCY_ID not in", values, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdBetween(String value1, String value2) {
            addCriterion("BNFCY_ID between", value1, value2, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyIdNotBetween(String value1, String value2) {
            addCriterion("BNFCY_ID not between", value1, value2, "bnfcyId");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmIsNull() {
            addCriterion("BNFCY_NM is null");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmIsNotNull() {
            addCriterion("BNFCY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmEqualTo(String value) {
            addCriterion("BNFCY_NM =", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotEqualTo(String value) {
            addCriterion("BNFCY_NM <>", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmGreaterThan(String value) {
            addCriterion("BNFCY_NM >", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmGreaterThanOrEqualTo(String value) {
            addCriterion("BNFCY_NM >=", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmLessThan(String value) {
            addCriterion("BNFCY_NM <", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmLessThanOrEqualTo(String value) {
            addCriterion("BNFCY_NM <=", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmLike(String value) {
            addCriterion("BNFCY_NM like", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotLike(String value) {
            addCriterion("BNFCY_NM not like", value, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmIn(List<String> values) {
            addCriterion("BNFCY_NM in", values, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotIn(List<String> values) {
            addCriterion("BNFCY_NM not in", values, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmBetween(String value1, String value2) {
            addCriterion("BNFCY_NM between", value1, value2, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andBnfcyNmNotBetween(String value1, String value2) {
            addCriterion("BNFCY_NM not between", value1, value2, "bnfcyNm");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimIsNull() {
            addCriterion("END_ORSE_TIM is null");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimIsNotNull() {
            addCriterion("END_ORSE_TIM is not null");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimEqualTo(BigDecimal value) {
            addCriterion("END_ORSE_TIM =", value, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimNotEqualTo(BigDecimal value) {
            addCriterion("END_ORSE_TIM <>", value, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimGreaterThan(BigDecimal value) {
            addCriterion("END_ORSE_TIM >", value, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("END_ORSE_TIM >=", value, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimLessThan(BigDecimal value) {
            addCriterion("END_ORSE_TIM <", value, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimLessThanOrEqualTo(BigDecimal value) {
            addCriterion("END_ORSE_TIM <=", value, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimIn(List<BigDecimal> values) {
            addCriterion("END_ORSE_TIM in", values, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimNotIn(List<BigDecimal> values) {
            addCriterion("END_ORSE_TIM not in", values, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("END_ORSE_TIM between", value1, value2, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andEndOrseTimNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("END_ORSE_TIM not between", value1, value2, "endOrseTim");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyIsNull() {
            addCriterion("LS_TBFCY is null");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyIsNotNull() {
            addCriterion("LS_TBFCY is not null");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyEqualTo(String value) {
            addCriterion("LS_TBFCY =", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyNotEqualTo(String value) {
            addCriterion("LS_TBFCY <>", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyGreaterThan(String value) {
            addCriterion("LS_TBFCY >", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyGreaterThanOrEqualTo(String value) {
            addCriterion("LS_TBFCY >=", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyLessThan(String value) {
            addCriterion("LS_TBFCY <", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyLessThanOrEqualTo(String value) {
            addCriterion("LS_TBFCY <=", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyLike(String value) {
            addCriterion("LS_TBFCY like", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyNotLike(String value) {
            addCriterion("LS_TBFCY not like", value, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyIn(List<String> values) {
            addCriterion("LS_TBFCY in", values, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyNotIn(List<String> values) {
            addCriterion("LS_TBFCY not in", values, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyBetween(String value1, String value2) {
            addCriterion("LS_TBFCY between", value1, value2, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andLsTbfcyNotBetween(String value1, String value2) {
            addCriterion("LS_TBFCY not between", value1, value2, "lsTbfcy");
            return (Criteria) this;
        }

        public Criteria andAcptIdIsNull() {
            addCriterion("ACPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcptIdIsNotNull() {
            addCriterion("ACPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcptIdEqualTo(String value) {
            addCriterion("ACPT_ID =", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdNotEqualTo(String value) {
            addCriterion("ACPT_ID <>", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdGreaterThan(String value) {
            addCriterion("ACPT_ID >", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACPT_ID >=", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdLessThan(String value) {
            addCriterion("ACPT_ID <", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdLessThanOrEqualTo(String value) {
            addCriterion("ACPT_ID <=", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdLike(String value) {
            addCriterion("ACPT_ID like", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdNotLike(String value) {
            addCriterion("ACPT_ID not like", value, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdIn(List<String> values) {
            addCriterion("ACPT_ID in", values, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdNotIn(List<String> values) {
            addCriterion("ACPT_ID not in", values, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdBetween(String value1, String value2) {
            addCriterion("ACPT_ID between", value1, value2, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptIdNotBetween(String value1, String value2) {
            addCriterion("ACPT_ID not between", value1, value2, "acptId");
            return (Criteria) this;
        }

        public Criteria andAcptNmIsNull() {
            addCriterion("ACPT_NM is null");
            return (Criteria) this;
        }

        public Criteria andAcptNmIsNotNull() {
            addCriterion("ACPT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andAcptNmEqualTo(String value) {
            addCriterion("ACPT_NM =", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmNotEqualTo(String value) {
            addCriterion("ACPT_NM <>", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmGreaterThan(String value) {
            addCriterion("ACPT_NM >", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmGreaterThanOrEqualTo(String value) {
            addCriterion("ACPT_NM >=", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmLessThan(String value) {
            addCriterion("ACPT_NM <", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmLessThanOrEqualTo(String value) {
            addCriterion("ACPT_NM <=", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmLike(String value) {
            addCriterion("ACPT_NM like", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmNotLike(String value) {
            addCriterion("ACPT_NM not like", value, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmIn(List<String> values) {
            addCriterion("ACPT_NM in", values, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmNotIn(List<String> values) {
            addCriterion("ACPT_NM not in", values, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmBetween(String value1, String value2) {
            addCriterion("ACPT_NM between", value1, value2, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptNmNotBetween(String value1, String value2) {
            addCriterion("ACPT_NM not between", value1, value2, "acptNm");
            return (Criteria) this;
        }

        public Criteria andAcptLevIsNull() {
            addCriterion("ACPT_LEV is null");
            return (Criteria) this;
        }

        public Criteria andAcptLevIsNotNull() {
            addCriterion("ACPT_LEV is not null");
            return (Criteria) this;
        }

        public Criteria andAcptLevEqualTo(String value) {
            addCriterion("ACPT_LEV =", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevNotEqualTo(String value) {
            addCriterion("ACPT_LEV <>", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevGreaterThan(String value) {
            addCriterion("ACPT_LEV >", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevGreaterThanOrEqualTo(String value) {
            addCriterion("ACPT_LEV >=", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevLessThan(String value) {
            addCriterion("ACPT_LEV <", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevLessThanOrEqualTo(String value) {
            addCriterion("ACPT_LEV <=", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevLike(String value) {
            addCriterion("ACPT_LEV like", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevNotLike(String value) {
            addCriterion("ACPT_LEV not like", value, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevIn(List<String> values) {
            addCriterion("ACPT_LEV in", values, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevNotIn(List<String> values) {
            addCriterion("ACPT_LEV not in", values, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevBetween(String value1, String value2) {
            addCriterion("ACPT_LEV between", value1, value2, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptLevNotBetween(String value1, String value2) {
            addCriterion("ACPT_LEV not between", value1, value2, "acptLev");
            return (Criteria) this;
        }

        public Criteria andAcptRegIsNull() {
            addCriterion("ACPT_REG is null");
            return (Criteria) this;
        }

        public Criteria andAcptRegIsNotNull() {
            addCriterion("ACPT_REG is not null");
            return (Criteria) this;
        }

        public Criteria andAcptRegEqualTo(String value) {
            addCriterion("ACPT_REG =", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegNotEqualTo(String value) {
            addCriterion("ACPT_REG <>", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegGreaterThan(String value) {
            addCriterion("ACPT_REG >", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegGreaterThanOrEqualTo(String value) {
            addCriterion("ACPT_REG >=", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegLessThan(String value) {
            addCriterion("ACPT_REG <", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegLessThanOrEqualTo(String value) {
            addCriterion("ACPT_REG <=", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegLike(String value) {
            addCriterion("ACPT_REG like", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegNotLike(String value) {
            addCriterion("ACPT_REG not like", value, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegIn(List<String> values) {
            addCriterion("ACPT_REG in", values, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegNotIn(List<String> values) {
            addCriterion("ACPT_REG not in", values, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegBetween(String value1, String value2) {
            addCriterion("ACPT_REG between", value1, value2, "acptReg");
            return (Criteria) this;
        }

        public Criteria andAcptRegNotBetween(String value1, String value2) {
            addCriterion("ACPT_REG not between", value1, value2, "acptReg");
            return (Criteria) this;
        }

        public Criteria andTrmIsNull() {
            addCriterion("TRM is null");
            return (Criteria) this;
        }

        public Criteria andTrmIsNotNull() {
            addCriterion("TRM is not null");
            return (Criteria) this;
        }

        public Criteria andTrmEqualTo(String value) {
            addCriterion("TRM =", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotEqualTo(String value) {
            addCriterion("TRM <>", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmGreaterThan(String value) {
            addCriterion("TRM >", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmGreaterThanOrEqualTo(String value) {
            addCriterion("TRM >=", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmLessThan(String value) {
            addCriterion("TRM <", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmLessThanOrEqualTo(String value) {
            addCriterion("TRM <=", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmLike(String value) {
            addCriterion("TRM like", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotLike(String value) {
            addCriterion("TRM not like", value, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmIn(List<String> values) {
            addCriterion("TRM in", values, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotIn(List<String> values) {
            addCriterion("TRM not in", values, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmBetween(String value1, String value2) {
            addCriterion("TRM between", value1, value2, "trm");
            return (Criteria) this;
        }

        public Criteria andTrmNotBetween(String value1, String value2) {
            addCriterion("TRM not between", value1, value2, "trm");
            return (Criteria) this;
        }

        public Criteria andWrtDtIsNull() {
            addCriterion("WRT_DT is null");
            return (Criteria) this;
        }

        public Criteria andWrtDtIsNotNull() {
            addCriterion("WRT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andWrtDtEqualTo(String value) {
            addCriterion("WRT_DT =", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtNotEqualTo(String value) {
            addCriterion("WRT_DT <>", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtGreaterThan(String value) {
            addCriterion("WRT_DT >", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtGreaterThanOrEqualTo(String value) {
            addCriterion("WRT_DT >=", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtLessThan(String value) {
            addCriterion("WRT_DT <", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtLessThanOrEqualTo(String value) {
            addCriterion("WRT_DT <=", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtLike(String value) {
            addCriterion("WRT_DT like", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtNotLike(String value) {
            addCriterion("WRT_DT not like", value, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtIn(List<String> values) {
            addCriterion("WRT_DT in", values, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtNotIn(List<String> values) {
            addCriterion("WRT_DT not in", values, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtBetween(String value1, String value2) {
            addCriterion("WRT_DT between", value1, value2, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andWrtDtNotBetween(String value1, String value2) {
            addCriterion("WRT_DT not between", value1, value2, "wrtDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtIsNull() {
            addCriterion("MTR_DT is null");
            return (Criteria) this;
        }

        public Criteria andMtrDtIsNotNull() {
            addCriterion("MTR_DT is not null");
            return (Criteria) this;
        }

        public Criteria andMtrDtEqualTo(String value) {
            addCriterion("MTR_DT =", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtNotEqualTo(String value) {
            addCriterion("MTR_DT <>", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtGreaterThan(String value) {
            addCriterion("MTR_DT >", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtGreaterThanOrEqualTo(String value) {
            addCriterion("MTR_DT >=", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtLessThan(String value) {
            addCriterion("MTR_DT <", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtLessThanOrEqualTo(String value) {
            addCriterion("MTR_DT <=", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtLike(String value) {
            addCriterion("MTR_DT like", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtNotLike(String value) {
            addCriterion("MTR_DT not like", value, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtIn(List<String> values) {
            addCriterion("MTR_DT in", values, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtNotIn(List<String> values) {
            addCriterion("MTR_DT not in", values, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtBetween(String value1, String value2) {
            addCriterion("MTR_DT between", value1, value2, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andMtrDtNotBetween(String value1, String value2) {
            addCriterion("MTR_DT not between", value1, value2, "mtrDt");
            return (Criteria) this;
        }

        public Criteria andBillCurcdIsNull() {
            addCriterion("BILL_CURCD is null");
            return (Criteria) this;
        }

        public Criteria andBillCurcdIsNotNull() {
            addCriterion("BILL_CURCD is not null");
            return (Criteria) this;
        }

        public Criteria andBillCurcdEqualTo(String value) {
            addCriterion("BILL_CURCD =", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdNotEqualTo(String value) {
            addCriterion("BILL_CURCD <>", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdGreaterThan(String value) {
            addCriterion("BILL_CURCD >", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_CURCD >=", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdLessThan(String value) {
            addCriterion("BILL_CURCD <", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdLessThanOrEqualTo(String value) {
            addCriterion("BILL_CURCD <=", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdLike(String value) {
            addCriterion("BILL_CURCD like", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdNotLike(String value) {
            addCriterion("BILL_CURCD not like", value, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdIn(List<String> values) {
            addCriterion("BILL_CURCD in", values, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdNotIn(List<String> values) {
            addCriterion("BILL_CURCD not in", values, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdBetween(String value1, String value2) {
            addCriterion("BILL_CURCD between", value1, value2, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCurcdNotBetween(String value1, String value2) {
            addCriterion("BILL_CURCD not between", value1, value2, "billCurcd");
            return (Criteria) this;
        }

        public Criteria andBillCutIsNull() {
            addCriterion("BILL_CUT is null");
            return (Criteria) this;
        }

        public Criteria andBillCutIsNotNull() {
            addCriterion("BILL_CUT is not null");
            return (Criteria) this;
        }

        public Criteria andBillCutEqualTo(BigDecimal value) {
            addCriterion("BILL_CUT =", value, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutNotEqualTo(BigDecimal value) {
            addCriterion("BILL_CUT <>", value, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutGreaterThan(BigDecimal value) {
            addCriterion("BILL_CUT >", value, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_CUT >=", value, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutLessThan(BigDecimal value) {
            addCriterion("BILL_CUT <", value, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_CUT <=", value, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutIn(List<BigDecimal> values) {
            addCriterion("BILL_CUT in", values, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutNotIn(List<BigDecimal> values) {
            addCriterion("BILL_CUT not in", values, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_CUT between", value1, value2, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillCutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_CUT not between", value1, value2, "billCut");
            return (Criteria) this;
        }

        public Criteria andBillSumIsNull() {
            addCriterion("BILL_SUM is null");
            return (Criteria) this;
        }

        public Criteria andBillSumIsNotNull() {
            addCriterion("BILL_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andBillSumEqualTo(BigDecimal value) {
            addCriterion("BILL_SUM =", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumNotEqualTo(BigDecimal value) {
            addCriterion("BILL_SUM <>", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumGreaterThan(BigDecimal value) {
            addCriterion("BILL_SUM >", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_SUM >=", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumLessThan(BigDecimal value) {
            addCriterion("BILL_SUM <", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_SUM <=", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumIn(List<BigDecimal> values) {
            addCriterion("BILL_SUM in", values, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumNotIn(List<BigDecimal> values) {
            addCriterion("BILL_SUM not in", values, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_SUM between", value1, value2, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_SUM not between", value1, value2, "billSum");
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

        public Criteria andActSumIsNull() {
            addCriterion("ACT__SUM is null");
            return (Criteria) this;
        }

        public Criteria andActSumIsNotNull() {
            addCriterion("ACT__SUM is not null");
            return (Criteria) this;
        }

        public Criteria andActSumEqualTo(BigDecimal value) {
            addCriterion("ACT__SUM =", value, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumNotEqualTo(BigDecimal value) {
            addCriterion("ACT__SUM <>", value, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumGreaterThan(BigDecimal value) {
            addCriterion("ACT__SUM >", value, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT__SUM >=", value, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumLessThan(BigDecimal value) {
            addCriterion("ACT__SUM <", value, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT__SUM <=", value, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumIn(List<BigDecimal> values) {
            addCriterion("ACT__SUM in", values, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumNotIn(List<BigDecimal> values) {
            addCriterion("ACT__SUM not in", values, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT__SUM between", value1, value2, "actSum");
            return (Criteria) this;
        }

        public Criteria andActSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT__SUM not between", value1, value2, "actSum");
            return (Criteria) this;
        }

        public Criteria andActIntIsNull() {
            addCriterion("ACT_INT is null");
            return (Criteria) this;
        }

        public Criteria andActIntIsNotNull() {
            addCriterion("ACT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andActIntEqualTo(BigDecimal value) {
            addCriterion("ACT_INT =", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotEqualTo(BigDecimal value) {
            addCriterion("ACT_INT <>", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntGreaterThan(BigDecimal value) {
            addCriterion("ACT_INT >", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT_INT >=", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntLessThan(BigDecimal value) {
            addCriterion("ACT_INT <", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACT_INT <=", value, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntIn(List<BigDecimal> values) {
            addCriterion("ACT_INT in", values, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotIn(List<BigDecimal> values) {
            addCriterion("ACT_INT not in", values, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT_INT between", value1, value2, "actInt");
            return (Criteria) this;
        }

        public Criteria andActIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACT_INT not between", value1, value2, "actInt");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("RATE is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("RATE =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("RATE <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("RATE >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("RATE <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("RATE in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("RATE not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andIntTypIsNull() {
            addCriterion("INT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andIntTypIsNotNull() {
            addCriterion("INT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andIntTypEqualTo(String value) {
            addCriterion("INT_TYP =", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypNotEqualTo(String value) {
            addCriterion("INT_TYP <>", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypGreaterThan(String value) {
            addCriterion("INT_TYP >", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypGreaterThanOrEqualTo(String value) {
            addCriterion("INT_TYP >=", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypLessThan(String value) {
            addCriterion("INT_TYP <", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypLessThanOrEqualTo(String value) {
            addCriterion("INT_TYP <=", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypLike(String value) {
            addCriterion("INT_TYP like", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypNotLike(String value) {
            addCriterion("INT_TYP not like", value, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypIn(List<String> values) {
            addCriterion("INT_TYP in", values, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypNotIn(List<String> values) {
            addCriterion("INT_TYP not in", values, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypBetween(String value1, String value2) {
            addCriterion("INT_TYP between", value1, value2, "intTyp");
            return (Criteria) this;
        }

        public Criteria andIntTypNotBetween(String value1, String value2) {
            addCriterion("INT_TYP not between", value1, value2, "intTyp");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("SCALE is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(BigDecimal value) {
            addCriterion("SCALE =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(BigDecimal value) {
            addCriterion("SCALE <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(BigDecimal value) {
            addCriterion("SCALE >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SCALE >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(BigDecimal value) {
            addCriterion("SCALE <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SCALE <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<BigDecimal> values) {
            addCriterion("SCALE in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<BigDecimal> values) {
            addCriterion("SCALE not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCALE between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCALE not between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andGatrNmIsNull() {
            addCriterion("GATR_NM is null");
            return (Criteria) this;
        }

        public Criteria andGatrNmIsNotNull() {
            addCriterion("GATR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andGatrNmEqualTo(String value) {
            addCriterion("GATR_NM =", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmNotEqualTo(String value) {
            addCriterion("GATR_NM <>", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmGreaterThan(String value) {
            addCriterion("GATR_NM >", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmGreaterThanOrEqualTo(String value) {
            addCriterion("GATR_NM >=", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmLessThan(String value) {
            addCriterion("GATR_NM <", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmLessThanOrEqualTo(String value) {
            addCriterion("GATR_NM <=", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmLike(String value) {
            addCriterion("GATR_NM like", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmNotLike(String value) {
            addCriterion("GATR_NM not like", value, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmIn(List<String> values) {
            addCriterion("GATR_NM in", values, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmNotIn(List<String> values) {
            addCriterion("GATR_NM not in", values, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmBetween(String value1, String value2) {
            addCriterion("GATR_NM between", value1, value2, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andGatrNmNotBetween(String value1, String value2) {
            addCriterion("GATR_NM not between", value1, value2, "gatrNm");
            return (Criteria) this;
        }

        public Criteria andActNoIsNull() {
            addCriterion("ACT_NO is null");
            return (Criteria) this;
        }

        public Criteria andActNoIsNotNull() {
            addCriterion("ACT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andActNoEqualTo(String value) {
            addCriterion("ACT_NO =", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoNotEqualTo(String value) {
            addCriterion("ACT_NO <>", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoGreaterThan(String value) {
            addCriterion("ACT_NO >", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_NO >=", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoLessThan(String value) {
            addCriterion("ACT_NO <", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoLessThanOrEqualTo(String value) {
            addCriterion("ACT_NO <=", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoLike(String value) {
            addCriterion("ACT_NO like", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoNotLike(String value) {
            addCriterion("ACT_NO not like", value, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoIn(List<String> values) {
            addCriterion("ACT_NO in", values, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoNotIn(List<String> values) {
            addCriterion("ACT_NO not in", values, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoBetween(String value1, String value2) {
            addCriterion("ACT_NO between", value1, value2, "actNo");
            return (Criteria) this;
        }

        public Criteria andActNoNotBetween(String value1, String value2) {
            addCriterion("ACT_NO not between", value1, value2, "actNo");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmIsNull() {
            addCriterion("ABT_BAK_NM is null");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmIsNotNull() {
            addCriterion("ABT_BAK_NM is not null");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmEqualTo(String value) {
            addCriterion("ABT_BAK_NM =", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmNotEqualTo(String value) {
            addCriterion("ABT_BAK_NM <>", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmGreaterThan(String value) {
            addCriterion("ABT_BAK_NM >", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmGreaterThanOrEqualTo(String value) {
            addCriterion("ABT_BAK_NM >=", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmLessThan(String value) {
            addCriterion("ABT_BAK_NM <", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmLessThanOrEqualTo(String value) {
            addCriterion("ABT_BAK_NM <=", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmLike(String value) {
            addCriterion("ABT_BAK_NM like", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmNotLike(String value) {
            addCriterion("ABT_BAK_NM not like", value, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmIn(List<String> values) {
            addCriterion("ABT_BAK_NM in", values, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmNotIn(List<String> values) {
            addCriterion("ABT_BAK_NM not in", values, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmBetween(String value1, String value2) {
            addCriterion("ABT_BAK_NM between", value1, value2, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andAbtBakNmNotBetween(String value1, String value2) {
            addCriterion("ABT_BAK_NM not between", value1, value2, "abtBakNm");
            return (Criteria) this;
        }

        public Criteria andIntSialnoIsNull() {
            addCriterion("INT_SIALNO is null");
            return (Criteria) this;
        }

        public Criteria andIntSialnoIsNotNull() {
            addCriterion("INT_SIALNO is not null");
            return (Criteria) this;
        }

        public Criteria andIntSialnoEqualTo(String value) {
            addCriterion("INT_SIALNO =", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoNotEqualTo(String value) {
            addCriterion("INT_SIALNO <>", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoGreaterThan(String value) {
            addCriterion("INT_SIALNO >", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoGreaterThanOrEqualTo(String value) {
            addCriterion("INT_SIALNO >=", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoLessThan(String value) {
            addCriterion("INT_SIALNO <", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoLessThanOrEqualTo(String value) {
            addCriterion("INT_SIALNO <=", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoLike(String value) {
            addCriterion("INT_SIALNO like", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoNotLike(String value) {
            addCriterion("INT_SIALNO not like", value, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoIn(List<String> values) {
            addCriterion("INT_SIALNO in", values, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoNotIn(List<String> values) {
            addCriterion("INT_SIALNO not in", values, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoBetween(String value1, String value2) {
            addCriterion("INT_SIALNO between", value1, value2, "intSialno");
            return (Criteria) this;
        }

        public Criteria andIntSialnoNotBetween(String value1, String value2) {
            addCriterion("INT_SIALNO not between", value1, value2, "intSialno");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdIsNull() {
            addCriterion("ABT_BAK_ID is null");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdIsNotNull() {
            addCriterion("ABT_BAK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdEqualTo(String value) {
            addCriterion("ABT_BAK_ID =", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdNotEqualTo(String value) {
            addCriterion("ABT_BAK_ID <>", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdGreaterThan(String value) {
            addCriterion("ABT_BAK_ID >", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdGreaterThanOrEqualTo(String value) {
            addCriterion("ABT_BAK_ID >=", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdLessThan(String value) {
            addCriterion("ABT_BAK_ID <", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdLessThanOrEqualTo(String value) {
            addCriterion("ABT_BAK_ID <=", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdLike(String value) {
            addCriterion("ABT_BAK_ID like", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdNotLike(String value) {
            addCriterion("ABT_BAK_ID not like", value, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdIn(List<String> values) {
            addCriterion("ABT_BAK_ID in", values, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdNotIn(List<String> values) {
            addCriterion("ABT_BAK_ID not in", values, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdBetween(String value1, String value2) {
            addCriterion("ABT_BAK_ID between", value1, value2, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andAbtBakIdNotBetween(String value1, String value2) {
            addCriterion("ABT_BAK_ID not between", value1, value2, "abtBakId");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoIsNull() {
            addCriterion("RELA_POT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoIsNotNull() {
            addCriterion("RELA_POT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoEqualTo(String value) {
            addCriterion("RELA_POT_NO =", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoNotEqualTo(String value) {
            addCriterion("RELA_POT_NO <>", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoGreaterThan(String value) {
            addCriterion("RELA_POT_NO >", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_POT_NO >=", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoLessThan(String value) {
            addCriterion("RELA_POT_NO <", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoLessThanOrEqualTo(String value) {
            addCriterion("RELA_POT_NO <=", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoLike(String value) {
            addCriterion("RELA_POT_NO like", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoNotLike(String value) {
            addCriterion("RELA_POT_NO not like", value, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoIn(List<String> values) {
            addCriterion("RELA_POT_NO in", values, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoNotIn(List<String> values) {
            addCriterion("RELA_POT_NO not in", values, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoBetween(String value1, String value2) {
            addCriterion("RELA_POT_NO between", value1, value2, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andRelaPotNoNotBetween(String value1, String value2) {
            addCriterion("RELA_POT_NO not between", value1, value2, "relaPotNo");
            return (Criteria) this;
        }

        public Criteria andSendFlgIsNull() {
            addCriterion("SEND_FLG is null");
            return (Criteria) this;
        }

        public Criteria andSendFlgIsNotNull() {
            addCriterion("SEND_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andSendFlgEqualTo(String value) {
            addCriterion("SEND_FLG =", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgNotEqualTo(String value) {
            addCriterion("SEND_FLG <>", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgGreaterThan(String value) {
            addCriterion("SEND_FLG >", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_FLG >=", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgLessThan(String value) {
            addCriterion("SEND_FLG <", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgLessThanOrEqualTo(String value) {
            addCriterion("SEND_FLG <=", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgLike(String value) {
            addCriterion("SEND_FLG like", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgNotLike(String value) {
            addCriterion("SEND_FLG not like", value, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgIn(List<String> values) {
            addCriterion("SEND_FLG in", values, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgNotIn(List<String> values) {
            addCriterion("SEND_FLG not in", values, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgBetween(String value1, String value2) {
            addCriterion("SEND_FLG between", value1, value2, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andSendFlgNotBetween(String value1, String value2) {
            addCriterion("SEND_FLG not between", value1, value2, "sendFlg");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtIsNull() {
            addCriterion("CHK_RPY_DT is null");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtIsNotNull() {
            addCriterion("CHK_RPY_DT is not null");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtEqualTo(String value) {
            addCriterion("CHK_RPY_DT =", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtNotEqualTo(String value) {
            addCriterion("CHK_RPY_DT <>", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtGreaterThan(String value) {
            addCriterion("CHK_RPY_DT >", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_RPY_DT >=", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtLessThan(String value) {
            addCriterion("CHK_RPY_DT <", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtLessThanOrEqualTo(String value) {
            addCriterion("CHK_RPY_DT <=", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtLike(String value) {
            addCriterion("CHK_RPY_DT like", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtNotLike(String value) {
            addCriterion("CHK_RPY_DT not like", value, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtIn(List<String> values) {
            addCriterion("CHK_RPY_DT in", values, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtNotIn(List<String> values) {
            addCriterion("CHK_RPY_DT not in", values, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtBetween(String value1, String value2) {
            addCriterion("CHK_RPY_DT between", value1, value2, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andChkRpyDtNotBetween(String value1, String value2) {
            addCriterion("CHK_RPY_DT not between", value1, value2, "chkRpyDt");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdIsNull() {
            addCriterion("KEP_BILL_BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdIsNotNull() {
            addCriterion("KEP_BILL_BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdEqualTo(String value) {
            addCriterion("KEP_BILL_BR_CD =", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdNotEqualTo(String value) {
            addCriterion("KEP_BILL_BR_CD <>", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdGreaterThan(String value) {
            addCriterion("KEP_BILL_BR_CD >", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("KEP_BILL_BR_CD >=", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdLessThan(String value) {
            addCriterion("KEP_BILL_BR_CD <", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdLessThanOrEqualTo(String value) {
            addCriterion("KEP_BILL_BR_CD <=", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdLike(String value) {
            addCriterion("KEP_BILL_BR_CD like", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdNotLike(String value) {
            addCriterion("KEP_BILL_BR_CD not like", value, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdIn(List<String> values) {
            addCriterion("KEP_BILL_BR_CD in", values, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdNotIn(List<String> values) {
            addCriterion("KEP_BILL_BR_CD not in", values, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdBetween(String value1, String value2) {
            addCriterion("KEP_BILL_BR_CD between", value1, value2, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andKepBillBrCdNotBetween(String value1, String value2) {
            addCriterion("KEP_BILL_BR_CD not between", value1, value2, "kepBillBrCd");
            return (Criteria) this;
        }

        public Criteria andTradConNoIsNull() {
            addCriterion("TRAD_CON_NO is null");
            return (Criteria) this;
        }

        public Criteria andTradConNoIsNotNull() {
            addCriterion("TRAD_CON_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTradConNoEqualTo(String value) {
            addCriterion("TRAD_CON_NO =", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoNotEqualTo(String value) {
            addCriterion("TRAD_CON_NO <>", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoGreaterThan(String value) {
            addCriterion("TRAD_CON_NO >", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoGreaterThanOrEqualTo(String value) {
            addCriterion("TRAD_CON_NO >=", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoLessThan(String value) {
            addCriterion("TRAD_CON_NO <", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoLessThanOrEqualTo(String value) {
            addCriterion("TRAD_CON_NO <=", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoLike(String value) {
            addCriterion("TRAD_CON_NO like", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoNotLike(String value) {
            addCriterion("TRAD_CON_NO not like", value, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoIn(List<String> values) {
            addCriterion("TRAD_CON_NO in", values, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoNotIn(List<String> values) {
            addCriterion("TRAD_CON_NO not in", values, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoBetween(String value1, String value2) {
            addCriterion("TRAD_CON_NO between", value1, value2, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNoNotBetween(String value1, String value2) {
            addCriterion("TRAD_CON_NO not between", value1, value2, "tradConNo");
            return (Criteria) this;
        }

        public Criteria andTradConNmIsNull() {
            addCriterion("TRAD_CON_NM is null");
            return (Criteria) this;
        }

        public Criteria andTradConNmIsNotNull() {
            addCriterion("TRAD_CON_NM is not null");
            return (Criteria) this;
        }

        public Criteria andTradConNmEqualTo(String value) {
            addCriterion("TRAD_CON_NM =", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmNotEqualTo(String value) {
            addCriterion("TRAD_CON_NM <>", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmGreaterThan(String value) {
            addCriterion("TRAD_CON_NM >", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmGreaterThanOrEqualTo(String value) {
            addCriterion("TRAD_CON_NM >=", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmLessThan(String value) {
            addCriterion("TRAD_CON_NM <", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmLessThanOrEqualTo(String value) {
            addCriterion("TRAD_CON_NM <=", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmLike(String value) {
            addCriterion("TRAD_CON_NM like", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmNotLike(String value) {
            addCriterion("TRAD_CON_NM not like", value, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmIn(List<String> values) {
            addCriterion("TRAD_CON_NM in", values, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmNotIn(List<String> values) {
            addCriterion("TRAD_CON_NM not in", values, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmBetween(String value1, String value2) {
            addCriterion("TRAD_CON_NM between", value1, value2, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConNmNotBetween(String value1, String value2) {
            addCriterion("TRAD_CON_NM not between", value1, value2, "tradConNm");
            return (Criteria) this;
        }

        public Criteria andTradConAmtIsNull() {
            addCriterion("TRAD_CON_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTradConAmtIsNotNull() {
            addCriterion("TRAD_CON_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTradConAmtEqualTo(BigDecimal value) {
            addCriterion("TRAD_CON_AMT =", value, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtNotEqualTo(BigDecimal value) {
            addCriterion("TRAD_CON_AMT <>", value, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtGreaterThan(BigDecimal value) {
            addCriterion("TRAD_CON_AMT >", value, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRAD_CON_AMT >=", value, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtLessThan(BigDecimal value) {
            addCriterion("TRAD_CON_AMT <", value, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRAD_CON_AMT <=", value, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtIn(List<BigDecimal> values) {
            addCriterion("TRAD_CON_AMT in", values, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtNotIn(List<BigDecimal> values) {
            addCriterion("TRAD_CON_AMT not in", values, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRAD_CON_AMT between", value1, value2, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andTradConAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRAD_CON_AMT not between", value1, value2, "tradConAmt");
            return (Criteria) this;
        }

        public Criteria andFlg1IsNull() {
            addCriterion("FLG1 is null");
            return (Criteria) this;
        }

        public Criteria andFlg1IsNotNull() {
            addCriterion("FLG1 is not null");
            return (Criteria) this;
        }

        public Criteria andFlg1EqualTo(String value) {
            addCriterion("FLG1 =", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotEqualTo(String value) {
            addCriterion("FLG1 <>", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1GreaterThan(String value) {
            addCriterion("FLG1 >", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1GreaterThanOrEqualTo(String value) {
            addCriterion("FLG1 >=", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1LessThan(String value) {
            addCriterion("FLG1 <", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1LessThanOrEqualTo(String value) {
            addCriterion("FLG1 <=", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1Like(String value) {
            addCriterion("FLG1 like", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotLike(String value) {
            addCriterion("FLG1 not like", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1In(List<String> values) {
            addCriterion("FLG1 in", values, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotIn(List<String> values) {
            addCriterion("FLG1 not in", values, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1Between(String value1, String value2) {
            addCriterion("FLG1 between", value1, value2, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotBetween(String value1, String value2) {
            addCriterion("FLG1 not between", value1, value2, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg2IsNull() {
            addCriterion("FLG2 is null");
            return (Criteria) this;
        }

        public Criteria andFlg2IsNotNull() {
            addCriterion("FLG2 is not null");
            return (Criteria) this;
        }

        public Criteria andFlg2EqualTo(String value) {
            addCriterion("FLG2 =", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotEqualTo(String value) {
            addCriterion("FLG2 <>", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2GreaterThan(String value) {
            addCriterion("FLG2 >", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2GreaterThanOrEqualTo(String value) {
            addCriterion("FLG2 >=", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2LessThan(String value) {
            addCriterion("FLG2 <", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2LessThanOrEqualTo(String value) {
            addCriterion("FLG2 <=", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2Like(String value) {
            addCriterion("FLG2 like", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotLike(String value) {
            addCriterion("FLG2 not like", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2In(List<String> values) {
            addCriterion("FLG2 in", values, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotIn(List<String> values) {
            addCriterion("FLG2 not in", values, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2Between(String value1, String value2) {
            addCriterion("FLG2 between", value1, value2, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotBetween(String value1, String value2) {
            addCriterion("FLG2 not between", value1, value2, "flg2");
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

        public Criteria andOthRemIsNull() {
            addCriterion("OTH_REM is null");
            return (Criteria) this;
        }

        public Criteria andOthRemIsNotNull() {
            addCriterion("OTH_REM is not null");
            return (Criteria) this;
        }

        public Criteria andOthRemEqualTo(String value) {
            addCriterion("OTH_REM =", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemNotEqualTo(String value) {
            addCriterion("OTH_REM <>", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemGreaterThan(String value) {
            addCriterion("OTH_REM >", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemGreaterThanOrEqualTo(String value) {
            addCriterion("OTH_REM >=", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemLessThan(String value) {
            addCriterion("OTH_REM <", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemLessThanOrEqualTo(String value) {
            addCriterion("OTH_REM <=", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemLike(String value) {
            addCriterion("OTH_REM like", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemNotLike(String value) {
            addCriterion("OTH_REM not like", value, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemIn(List<String> values) {
            addCriterion("OTH_REM in", values, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemNotIn(List<String> values) {
            addCriterion("OTH_REM not in", values, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemBetween(String value1, String value2) {
            addCriterion("OTH_REM between", value1, value2, "othRem");
            return (Criteria) this;
        }

        public Criteria andOthRemNotBetween(String value1, String value2) {
            addCriterion("OTH_REM not between", value1, value2, "othRem");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}