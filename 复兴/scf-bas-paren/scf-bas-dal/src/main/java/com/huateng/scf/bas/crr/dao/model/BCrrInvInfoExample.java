package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrInvInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrInvInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrInvInfoExample(BCrrInvInfoExample example) {
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

        public Criteria andInvIdIsNull() {
            addCriterion("INV_ID is null");
            return (Criteria) this;
        }

        public Criteria andInvIdIsNotNull() {
            addCriterion("INV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInvIdEqualTo(String value) {
            addCriterion("INV_ID =", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotEqualTo(String value) {
            addCriterion("INV_ID <>", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdGreaterThan(String value) {
            addCriterion("INV_ID >", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdGreaterThanOrEqualTo(String value) {
            addCriterion("INV_ID >=", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdLessThan(String value) {
            addCriterion("INV_ID <", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdLessThanOrEqualTo(String value) {
            addCriterion("INV_ID <=", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdLike(String value) {
            addCriterion("INV_ID like", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotLike(String value) {
            addCriterion("INV_ID not like", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdIn(List<String> values) {
            addCriterion("INV_ID in", values, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotIn(List<String> values) {
            addCriterion("INV_ID not in", values, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdBetween(String value1, String value2) {
            addCriterion("INV_ID between", value1, value2, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotBetween(String value1, String value2) {
            addCriterion("INV_ID not between", value1, value2, "invId");
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

        public Criteria andInvNoIsNull() {
            addCriterion("INV_NO is null");
            return (Criteria) this;
        }

        public Criteria andInvNoIsNotNull() {
            addCriterion("INV_NO is not null");
            return (Criteria) this;
        }

        public Criteria andInvNoEqualTo(String value) {
            addCriterion("INV_NO =", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoNotEqualTo(String value) {
            addCriterion("INV_NO <>", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoGreaterThan(String value) {
            addCriterion("INV_NO >", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoGreaterThanOrEqualTo(String value) {
            addCriterion("INV_NO >=", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoLessThan(String value) {
            addCriterion("INV_NO <", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoLessThanOrEqualTo(String value) {
            addCriterion("INV_NO <=", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoLike(String value) {
            addCriterion("INV_NO like", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoNotLike(String value) {
            addCriterion("INV_NO not like", value, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoIn(List<String> values) {
            addCriterion("INV_NO in", values, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoNotIn(List<String> values) {
            addCriterion("INV_NO not in", values, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoBetween(String value1, String value2) {
            addCriterion("INV_NO between", value1, value2, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvNoNotBetween(String value1, String value2) {
            addCriterion("INV_NO not between", value1, value2, "invNo");
            return (Criteria) this;
        }

        public Criteria andInvCurcdIsNull() {
            addCriterion("INV_CURCD is null");
            return (Criteria) this;
        }

        public Criteria andInvCurcdIsNotNull() {
            addCriterion("INV_CURCD is not null");
            return (Criteria) this;
        }

        public Criteria andInvCurcdEqualTo(String value) {
            addCriterion("INV_CURCD =", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdNotEqualTo(String value) {
            addCriterion("INV_CURCD <>", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdGreaterThan(String value) {
            addCriterion("INV_CURCD >", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdGreaterThanOrEqualTo(String value) {
            addCriterion("INV_CURCD >=", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdLessThan(String value) {
            addCriterion("INV_CURCD <", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdLessThanOrEqualTo(String value) {
            addCriterion("INV_CURCD <=", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdLike(String value) {
            addCriterion("INV_CURCD like", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdNotLike(String value) {
            addCriterion("INV_CURCD not like", value, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdIn(List<String> values) {
            addCriterion("INV_CURCD in", values, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdNotIn(List<String> values) {
            addCriterion("INV_CURCD not in", values, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdBetween(String value1, String value2) {
            addCriterion("INV_CURCD between", value1, value2, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andInvCurcdNotBetween(String value1, String value2) {
            addCriterion("INV_CURCD not between", value1, value2, "invCurcd");
            return (Criteria) this;
        }

        public Criteria andPrchIdIsNull() {
            addCriterion("PRCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrchIdIsNotNull() {
            addCriterion("PRCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrchIdEqualTo(String value) {
            addCriterion("PRCH_ID =", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdNotEqualTo(String value) {
            addCriterion("PRCH_ID <>", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdGreaterThan(String value) {
            addCriterion("PRCH_ID >", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRCH_ID >=", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdLessThan(String value) {
            addCriterion("PRCH_ID <", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdLessThanOrEqualTo(String value) {
            addCriterion("PRCH_ID <=", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdLike(String value) {
            addCriterion("PRCH_ID like", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdNotLike(String value) {
            addCriterion("PRCH_ID not like", value, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdIn(List<String> values) {
            addCriterion("PRCH_ID in", values, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdNotIn(List<String> values) {
            addCriterion("PRCH_ID not in", values, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdBetween(String value1, String value2) {
            addCriterion("PRCH_ID between", value1, value2, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchIdNotBetween(String value1, String value2) {
            addCriterion("PRCH_ID not between", value1, value2, "prchId");
            return (Criteria) this;
        }

        public Criteria andPrchNmIsNull() {
            addCriterion("PRCH_NM is null");
            return (Criteria) this;
        }

        public Criteria andPrchNmIsNotNull() {
            addCriterion("PRCH_NM is not null");
            return (Criteria) this;
        }

        public Criteria andPrchNmEqualTo(String value) {
            addCriterion("PRCH_NM =", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmNotEqualTo(String value) {
            addCriterion("PRCH_NM <>", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmGreaterThan(String value) {
            addCriterion("PRCH_NM >", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmGreaterThanOrEqualTo(String value) {
            addCriterion("PRCH_NM >=", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmLessThan(String value) {
            addCriterion("PRCH_NM <", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmLessThanOrEqualTo(String value) {
            addCriterion("PRCH_NM <=", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmLike(String value) {
            addCriterion("PRCH_NM like", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmNotLike(String value) {
            addCriterion("PRCH_NM not like", value, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmIn(List<String> values) {
            addCriterion("PRCH_NM in", values, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmNotIn(List<String> values) {
            addCriterion("PRCH_NM not in", values, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmBetween(String value1, String value2) {
            addCriterion("PRCH_NM between", value1, value2, "prchNm");
            return (Criteria) this;
        }

        public Criteria andPrchNmNotBetween(String value1, String value2) {
            addCriterion("PRCH_NM not between", value1, value2, "prchNm");
            return (Criteria) this;
        }

        public Criteria andSellIdIsNull() {
            addCriterion("SELL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSellIdIsNotNull() {
            addCriterion("SELL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSellIdEqualTo(String value) {
            addCriterion("SELL_ID =", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdNotEqualTo(String value) {
            addCriterion("SELL_ID <>", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdGreaterThan(String value) {
            addCriterion("SELL_ID >", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdGreaterThanOrEqualTo(String value) {
            addCriterion("SELL_ID >=", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdLessThan(String value) {
            addCriterion("SELL_ID <", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdLessThanOrEqualTo(String value) {
            addCriterion("SELL_ID <=", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdLike(String value) {
            addCriterion("SELL_ID like", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdNotLike(String value) {
            addCriterion("SELL_ID not like", value, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdIn(List<String> values) {
            addCriterion("SELL_ID in", values, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdNotIn(List<String> values) {
            addCriterion("SELL_ID not in", values, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdBetween(String value1, String value2) {
            addCriterion("SELL_ID between", value1, value2, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellIdNotBetween(String value1, String value2) {
            addCriterion("SELL_ID not between", value1, value2, "sellId");
            return (Criteria) this;
        }

        public Criteria andSellNmIsNull() {
            addCriterion("SELL_NM is null");
            return (Criteria) this;
        }

        public Criteria andSellNmIsNotNull() {
            addCriterion("SELL_NM is not null");
            return (Criteria) this;
        }

        public Criteria andSellNmEqualTo(String value) {
            addCriterion("SELL_NM =", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmNotEqualTo(String value) {
            addCriterion("SELL_NM <>", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmGreaterThan(String value) {
            addCriterion("SELL_NM >", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmGreaterThanOrEqualTo(String value) {
            addCriterion("SELL_NM >=", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmLessThan(String value) {
            addCriterion("SELL_NM <", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmLessThanOrEqualTo(String value) {
            addCriterion("SELL_NM <=", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmLike(String value) {
            addCriterion("SELL_NM like", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmNotLike(String value) {
            addCriterion("SELL_NM not like", value, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmIn(List<String> values) {
            addCriterion("SELL_NM in", values, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmNotIn(List<String> values) {
            addCriterion("SELL_NM not in", values, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmBetween(String value1, String value2) {
            addCriterion("SELL_NM between", value1, value2, "sellNm");
            return (Criteria) this;
        }

        public Criteria andSellNmNotBetween(String value1, String value2) {
            addCriterion("SELL_NM not between", value1, value2, "sellNm");
            return (Criteria) this;
        }

        public Criteria andTrdTypIsNull() {
            addCriterion("TRD_TYP is null");
            return (Criteria) this;
        }

        public Criteria andTrdTypIsNotNull() {
            addCriterion("TRD_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andTrdTypEqualTo(String value) {
            addCriterion("TRD_TYP =", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypNotEqualTo(String value) {
            addCriterion("TRD_TYP <>", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypGreaterThan(String value) {
            addCriterion("TRD_TYP >", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypGreaterThanOrEqualTo(String value) {
            addCriterion("TRD_TYP >=", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypLessThan(String value) {
            addCriterion("TRD_TYP <", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypLessThanOrEqualTo(String value) {
            addCriterion("TRD_TYP <=", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypLike(String value) {
            addCriterion("TRD_TYP like", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypNotLike(String value) {
            addCriterion("TRD_TYP not like", value, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypIn(List<String> values) {
            addCriterion("TRD_TYP in", values, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypNotIn(List<String> values) {
            addCriterion("TRD_TYP not in", values, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypBetween(String value1, String value2) {
            addCriterion("TRD_TYP between", value1, value2, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdTypNotBetween(String value1, String value2) {
            addCriterion("TRD_TYP not between", value1, value2, "trdTyp");
            return (Criteria) this;
        }

        public Criteria andTrdPrdIsNull() {
            addCriterion("TRD_PRD is null");
            return (Criteria) this;
        }

        public Criteria andTrdPrdIsNotNull() {
            addCriterion("TRD_PRD is not null");
            return (Criteria) this;
        }

        public Criteria andTrdPrdEqualTo(String value) {
            addCriterion("TRD_PRD =", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdNotEqualTo(String value) {
            addCriterion("TRD_PRD <>", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdGreaterThan(String value) {
            addCriterion("TRD_PRD >", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdGreaterThanOrEqualTo(String value) {
            addCriterion("TRD_PRD >=", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdLessThan(String value) {
            addCriterion("TRD_PRD <", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdLessThanOrEqualTo(String value) {
            addCriterion("TRD_PRD <=", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdLike(String value) {
            addCriterion("TRD_PRD like", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdNotLike(String value) {
            addCriterion("TRD_PRD not like", value, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdIn(List<String> values) {
            addCriterion("TRD_PRD in", values, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdNotIn(List<String> values) {
            addCriterion("TRD_PRD not in", values, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdBetween(String value1, String value2) {
            addCriterion("TRD_PRD between", value1, value2, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andTrdPrdNotBetween(String value1, String value2) {
            addCriterion("TRD_PRD not between", value1, value2, "trdPrd");
            return (Criteria) this;
        }

        public Criteria andInvDtIsNull() {
            addCriterion("INV_DT is null");
            return (Criteria) this;
        }

        public Criteria andInvDtIsNotNull() {
            addCriterion("INV_DT is not null");
            return (Criteria) this;
        }

        public Criteria andInvDtEqualTo(String value) {
            addCriterion("INV_DT =", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtNotEqualTo(String value) {
            addCriterion("INV_DT <>", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtGreaterThan(String value) {
            addCriterion("INV_DT >", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtGreaterThanOrEqualTo(String value) {
            addCriterion("INV_DT >=", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtLessThan(String value) {
            addCriterion("INV_DT <", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtLessThanOrEqualTo(String value) {
            addCriterion("INV_DT <=", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtLike(String value) {
            addCriterion("INV_DT like", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtNotLike(String value) {
            addCriterion("INV_DT not like", value, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtIn(List<String> values) {
            addCriterion("INV_DT in", values, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtNotIn(List<String> values) {
            addCriterion("INV_DT not in", values, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtBetween(String value1, String value2) {
            addCriterion("INV_DT between", value1, value2, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvDtNotBetween(String value1, String value2) {
            addCriterion("INV_DT not between", value1, value2, "invDt");
            return (Criteria) this;
        }

        public Criteria andInvSumIsNull() {
            addCriterion("INV_SUM is null");
            return (Criteria) this;
        }

        public Criteria andInvSumIsNotNull() {
            addCriterion("INV_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andInvSumEqualTo(BigDecimal value) {
            addCriterion("INV_SUM =", value, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumNotEqualTo(BigDecimal value) {
            addCriterion("INV_SUM <>", value, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumGreaterThan(BigDecimal value) {
            addCriterion("INV_SUM >", value, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INV_SUM >=", value, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumLessThan(BigDecimal value) {
            addCriterion("INV_SUM <", value, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INV_SUM <=", value, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumIn(List<BigDecimal> values) {
            addCriterion("INV_SUM in", values, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumNotIn(List<BigDecimal> values) {
            addCriterion("INV_SUM not in", values, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INV_SUM between", value1, value2, "invSum");
            return (Criteria) this;
        }

        public Criteria andInvSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INV_SUM not between", value1, value2, "invSum");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}