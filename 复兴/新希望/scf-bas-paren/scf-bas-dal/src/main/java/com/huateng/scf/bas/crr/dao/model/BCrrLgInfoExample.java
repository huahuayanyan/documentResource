package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrLgInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrLgInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrLgInfoExample(BCrrLgInfoExample example) {
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

        public Criteria andLgIdIsNull() {
            addCriterion("LG_ID is null");
            return (Criteria) this;
        }

        public Criteria andLgIdIsNotNull() {
            addCriterion("LG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLgIdEqualTo(String value) {
            addCriterion("LG_ID =", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdNotEqualTo(String value) {
            addCriterion("LG_ID <>", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdGreaterThan(String value) {
            addCriterion("LG_ID >", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdGreaterThanOrEqualTo(String value) {
            addCriterion("LG_ID >=", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdLessThan(String value) {
            addCriterion("LG_ID <", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdLessThanOrEqualTo(String value) {
            addCriterion("LG_ID <=", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdLike(String value) {
            addCriterion("LG_ID like", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdNotLike(String value) {
            addCriterion("LG_ID not like", value, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdIn(List<String> values) {
            addCriterion("LG_ID in", values, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdNotIn(List<String> values) {
            addCriterion("LG_ID not in", values, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdBetween(String value1, String value2) {
            addCriterion("LG_ID between", value1, value2, "lgId");
            return (Criteria) this;
        }

        public Criteria andLgIdNotBetween(String value1, String value2) {
            addCriterion("LG_ID not between", value1, value2, "lgId");
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

        public Criteria andLgNoIsNull() {
            addCriterion("LG_NO is null");
            return (Criteria) this;
        }

        public Criteria andLgNoIsNotNull() {
            addCriterion("LG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLgNoEqualTo(String value) {
            addCriterion("LG_NO =", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoNotEqualTo(String value) {
            addCriterion("LG_NO <>", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoGreaterThan(String value) {
            addCriterion("LG_NO >", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoGreaterThanOrEqualTo(String value) {
            addCriterion("LG_NO >=", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoLessThan(String value) {
            addCriterion("LG_NO <", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoLessThanOrEqualTo(String value) {
            addCriterion("LG_NO <=", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoLike(String value) {
            addCriterion("LG_NO like", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoNotLike(String value) {
            addCriterion("LG_NO not like", value, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoIn(List<String> values) {
            addCriterion("LG_NO in", values, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoNotIn(List<String> values) {
            addCriterion("LG_NO not in", values, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoBetween(String value1, String value2) {
            addCriterion("LG_NO between", value1, value2, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgNoNotBetween(String value1, String value2) {
            addCriterion("LG_NO not between", value1, value2, "lgNo");
            return (Criteria) this;
        }

        public Criteria andLgTypIsNull() {
            addCriterion("LG_TYP is null");
            return (Criteria) this;
        }

        public Criteria andLgTypIsNotNull() {
            addCriterion("LG_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andLgTypEqualTo(String value) {
            addCriterion("LG_TYP =", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypNotEqualTo(String value) {
            addCriterion("LG_TYP <>", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypGreaterThan(String value) {
            addCriterion("LG_TYP >", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypGreaterThanOrEqualTo(String value) {
            addCriterion("LG_TYP >=", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypLessThan(String value) {
            addCriterion("LG_TYP <", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypLessThanOrEqualTo(String value) {
            addCriterion("LG_TYP <=", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypLike(String value) {
            addCriterion("LG_TYP like", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypNotLike(String value) {
            addCriterion("LG_TYP not like", value, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypIn(List<String> values) {
            addCriterion("LG_TYP in", values, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypNotIn(List<String> values) {
            addCriterion("LG_TYP not in", values, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypBetween(String value1, String value2) {
            addCriterion("LG_TYP between", value1, value2, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andLgTypNotBetween(String value1, String value2) {
            addCriterion("LG_TYP not between", value1, value2, "lgTyp");
            return (Criteria) this;
        }

        public Criteria andIseBakIsNull() {
            addCriterion("ISE_BAK is null");
            return (Criteria) this;
        }

        public Criteria andIseBakIsNotNull() {
            addCriterion("ISE_BAK is not null");
            return (Criteria) this;
        }

        public Criteria andIseBakEqualTo(String value) {
            addCriterion("ISE_BAK =", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotEqualTo(String value) {
            addCriterion("ISE_BAK <>", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakGreaterThan(String value) {
            addCriterion("ISE_BAK >", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakGreaterThanOrEqualTo(String value) {
            addCriterion("ISE_BAK >=", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakLessThan(String value) {
            addCriterion("ISE_BAK <", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakLessThanOrEqualTo(String value) {
            addCriterion("ISE_BAK <=", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakLike(String value) {
            addCriterion("ISE_BAK like", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotLike(String value) {
            addCriterion("ISE_BAK not like", value, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakIn(List<String> values) {
            addCriterion("ISE_BAK in", values, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotIn(List<String> values) {
            addCriterion("ISE_BAK not in", values, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakBetween(String value1, String value2) {
            addCriterion("ISE_BAK between", value1, value2, "iseBak");
            return (Criteria) this;
        }

        public Criteria andIseBakNotBetween(String value1, String value2) {
            addCriterion("ISE_BAK not between", value1, value2, "iseBak");
            return (Criteria) this;
        }

        public Criteria andAplatIsNull() {
            addCriterion("APLAT is null");
            return (Criteria) this;
        }

        public Criteria andAplatIsNotNull() {
            addCriterion("APLAT is not null");
            return (Criteria) this;
        }

        public Criteria andAplatEqualTo(String value) {
            addCriterion("APLAT =", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatNotEqualTo(String value) {
            addCriterion("APLAT <>", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatGreaterThan(String value) {
            addCriterion("APLAT >", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatGreaterThanOrEqualTo(String value) {
            addCriterion("APLAT >=", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatLessThan(String value) {
            addCriterion("APLAT <", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatLessThanOrEqualTo(String value) {
            addCriterion("APLAT <=", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatLike(String value) {
            addCriterion("APLAT like", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatNotLike(String value) {
            addCriterion("APLAT not like", value, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatIn(List<String> values) {
            addCriterion("APLAT in", values, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatNotIn(List<String> values) {
            addCriterion("APLAT not in", values, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatBetween(String value1, String value2) {
            addCriterion("APLAT between", value1, value2, "aplat");
            return (Criteria) this;
        }

        public Criteria andAplatNotBetween(String value1, String value2) {
            addCriterion("APLAT not between", value1, value2, "aplat");
            return (Criteria) this;
        }

        public Criteria andBnfcyIsNull() {
            addCriterion("BNFCY is null");
            return (Criteria) this;
        }

        public Criteria andBnfcyIsNotNull() {
            addCriterion("BNFCY is not null");
            return (Criteria) this;
        }

        public Criteria andBnfcyEqualTo(String value) {
            addCriterion("BNFCY =", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyNotEqualTo(String value) {
            addCriterion("BNFCY <>", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyGreaterThan(String value) {
            addCriterion("BNFCY >", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyGreaterThanOrEqualTo(String value) {
            addCriterion("BNFCY >=", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyLessThan(String value) {
            addCriterion("BNFCY <", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyLessThanOrEqualTo(String value) {
            addCriterion("BNFCY <=", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyLike(String value) {
            addCriterion("BNFCY like", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyNotLike(String value) {
            addCriterion("BNFCY not like", value, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyIn(List<String> values) {
            addCriterion("BNFCY in", values, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyNotIn(List<String> values) {
            addCriterion("BNFCY not in", values, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyBetween(String value1, String value2) {
            addCriterion("BNFCY between", value1, value2, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andBnfcyNotBetween(String value1, String value2) {
            addCriterion("BNFCY not between", value1, value2, "bnfcy");
            return (Criteria) this;
        }

        public Criteria andLgCurcdIsNull() {
            addCriterion("LG_CURCD is null");
            return (Criteria) this;
        }

        public Criteria andLgCurcdIsNotNull() {
            addCriterion("LG_CURCD is not null");
            return (Criteria) this;
        }

        public Criteria andLgCurcdEqualTo(String value) {
            addCriterion("LG_CURCD =", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdNotEqualTo(String value) {
            addCriterion("LG_CURCD <>", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdGreaterThan(String value) {
            addCriterion("LG_CURCD >", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdGreaterThanOrEqualTo(String value) {
            addCriterion("LG_CURCD >=", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdLessThan(String value) {
            addCriterion("LG_CURCD <", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdLessThanOrEqualTo(String value) {
            addCriterion("LG_CURCD <=", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdLike(String value) {
            addCriterion("LG_CURCD like", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdNotLike(String value) {
            addCriterion("LG_CURCD not like", value, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdIn(List<String> values) {
            addCriterion("LG_CURCD in", values, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdNotIn(List<String> values) {
            addCriterion("LG_CURCD not in", values, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdBetween(String value1, String value2) {
            addCriterion("LG_CURCD between", value1, value2, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgCurcdNotBetween(String value1, String value2) {
            addCriterion("LG_CURCD not between", value1, value2, "lgCurcd");
            return (Criteria) this;
        }

        public Criteria andLgSumIsNull() {
            addCriterion("LG_SUM is null");
            return (Criteria) this;
        }

        public Criteria andLgSumIsNotNull() {
            addCriterion("LG_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andLgSumEqualTo(BigDecimal value) {
            addCriterion("LG_SUM =", value, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumNotEqualTo(BigDecimal value) {
            addCriterion("LG_SUM <>", value, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumGreaterThan(BigDecimal value) {
            addCriterion("LG_SUM >", value, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LG_SUM >=", value, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumLessThan(BigDecimal value) {
            addCriterion("LG_SUM <", value, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LG_SUM <=", value, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumIn(List<BigDecimal> values) {
            addCriterion("LG_SUM in", values, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumNotIn(List<BigDecimal> values) {
            addCriterion("LG_SUM not in", values, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LG_SUM between", value1, value2, "lgSum");
            return (Criteria) this;
        }

        public Criteria andLgSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LG_SUM not between", value1, value2, "lgSum");
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

        public Criteria andPurPosIsNull() {
            addCriterion("PUR_POS is null");
            return (Criteria) this;
        }

        public Criteria andPurPosIsNotNull() {
            addCriterion("PUR_POS is not null");
            return (Criteria) this;
        }

        public Criteria andPurPosEqualTo(String value) {
            addCriterion("PUR_POS =", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosNotEqualTo(String value) {
            addCriterion("PUR_POS <>", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosGreaterThan(String value) {
            addCriterion("PUR_POS >", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosGreaterThanOrEqualTo(String value) {
            addCriterion("PUR_POS >=", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosLessThan(String value) {
            addCriterion("PUR_POS <", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosLessThanOrEqualTo(String value) {
            addCriterion("PUR_POS <=", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosLike(String value) {
            addCriterion("PUR_POS like", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosNotLike(String value) {
            addCriterion("PUR_POS not like", value, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosIn(List<String> values) {
            addCriterion("PUR_POS in", values, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosNotIn(List<String> values) {
            addCriterion("PUR_POS not in", values, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosBetween(String value1, String value2) {
            addCriterion("PUR_POS between", value1, value2, "purPos");
            return (Criteria) this;
        }

        public Criteria andPurPosNotBetween(String value1, String value2) {
            addCriterion("PUR_POS not between", value1, value2, "purPos");
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