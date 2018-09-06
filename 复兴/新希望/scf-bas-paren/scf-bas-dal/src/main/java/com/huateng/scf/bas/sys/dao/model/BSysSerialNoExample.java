package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysSerialNoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysSerialNoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysSerialNoExample(BSysSerialNoExample example) {
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

        public Criteria andSerialCodeIsNull() {
            addCriterion("SERIAL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSerialCodeIsNotNull() {
            addCriterion("SERIAL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSerialCodeEqualTo(String value) {
            addCriterion("SERIAL_CODE =", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeNotEqualTo(String value) {
            addCriterion("SERIAL_CODE <>", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeGreaterThan(String value) {
            addCriterion("SERIAL_CODE >", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SERIAL_CODE >=", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeLessThan(String value) {
            addCriterion("SERIAL_CODE <", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeLessThanOrEqualTo(String value) {
            addCriterion("SERIAL_CODE <=", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeLike(String value) {
            addCriterion("SERIAL_CODE like", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeNotLike(String value) {
            addCriterion("SERIAL_CODE not like", value, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeIn(List<String> values) {
            addCriterion("SERIAL_CODE in", values, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeNotIn(List<String> values) {
            addCriterion("SERIAL_CODE not in", values, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeBetween(String value1, String value2) {
            addCriterion("SERIAL_CODE between", value1, value2, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialCodeNotBetween(String value1, String value2) {
            addCriterion("SERIAL_CODE not between", value1, value2, "serialCode");
            return (Criteria) this;
        }

        public Criteria andSerialValueIsNull() {
            addCriterion("SERIAL_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andSerialValueIsNotNull() {
            addCriterion("SERIAL_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andSerialValueEqualTo(Long value) {
            addCriterion("SERIAL_VALUE =", value, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueNotEqualTo(Long value) {
            addCriterion("SERIAL_VALUE <>", value, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueGreaterThan(Long value) {
            addCriterion("SERIAL_VALUE >", value, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueGreaterThanOrEqualTo(Long value) {
            addCriterion("SERIAL_VALUE >=", value, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueLessThan(Long value) {
            addCriterion("SERIAL_VALUE <", value, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueLessThanOrEqualTo(Long value) {
            addCriterion("SERIAL_VALUE <=", value, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueIn(List<Long> values) {
            addCriterion("SERIAL_VALUE in", values, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueNotIn(List<Long> values) {
            addCriterion("SERIAL_VALUE not in", values, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueBetween(Long value1, Long value2) {
            addCriterion("SERIAL_VALUE between", value1, value2, "serialValue");
            return (Criteria) this;
        }

        public Criteria andSerialValueNotBetween(Long value1, Long value2) {
            addCriterion("SERIAL_VALUE not between", value1, value2, "serialValue");
            return (Criteria) this;
        }

        public Criteria andPreDateIsNull() {
            addCriterion("PRE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPreDateIsNotNull() {
            addCriterion("PRE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPreDateEqualTo(String value) {
            addCriterion("PRE_DATE =", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotEqualTo(String value) {
            addCriterion("PRE_DATE <>", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateGreaterThan(String value) {
            addCriterion("PRE_DATE >", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_DATE >=", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLessThan(String value) {
            addCriterion("PRE_DATE <", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLessThanOrEqualTo(String value) {
            addCriterion("PRE_DATE <=", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLike(String value) {
            addCriterion("PRE_DATE like", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotLike(String value) {
            addCriterion("PRE_DATE not like", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateIn(List<String> values) {
            addCriterion("PRE_DATE in", values, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotIn(List<String> values) {
            addCriterion("PRE_DATE not in", values, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateBetween(String value1, String value2) {
            addCriterion("PRE_DATE between", value1, value2, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotBetween(String value1, String value2) {
            addCriterion("PRE_DATE not between", value1, value2, "preDate");
            return (Criteria) this;
        }

        public Criteria andSerialNameIsNull() {
            addCriterion("SERIAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSerialNameIsNotNull() {
            addCriterion("SERIAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNameEqualTo(String value) {
            addCriterion("SERIAL_NAME =", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotEqualTo(String value) {
            addCriterion("SERIAL_NAME <>", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameGreaterThan(String value) {
            addCriterion("SERIAL_NAME >", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameGreaterThanOrEqualTo(String value) {
            addCriterion("SERIAL_NAME >=", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLessThan(String value) {
            addCriterion("SERIAL_NAME <", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLessThanOrEqualTo(String value) {
            addCriterion("SERIAL_NAME <=", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLike(String value) {
            addCriterion("SERIAL_NAME like", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotLike(String value) {
            addCriterion("SERIAL_NAME not like", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameIn(List<String> values) {
            addCriterion("SERIAL_NAME in", values, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotIn(List<String> values) {
            addCriterion("SERIAL_NAME not in", values, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameBetween(String value1, String value2) {
            addCriterion("SERIAL_NAME between", value1, value2, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotBetween(String value1, String value2) {
            addCriterion("SERIAL_NAME not between", value1, value2, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialFormatIsNull() {
            addCriterion("SERIAL_FORMAT is null");
            return (Criteria) this;
        }

        public Criteria andSerialFormatIsNotNull() {
            addCriterion("SERIAL_FORMAT is not null");
            return (Criteria) this;
        }

        public Criteria andSerialFormatEqualTo(String value) {
            addCriterion("SERIAL_FORMAT =", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatNotEqualTo(String value) {
            addCriterion("SERIAL_FORMAT <>", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatGreaterThan(String value) {
            addCriterion("SERIAL_FORMAT >", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatGreaterThanOrEqualTo(String value) {
            addCriterion("SERIAL_FORMAT >=", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatLessThan(String value) {
            addCriterion("SERIAL_FORMAT <", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatLessThanOrEqualTo(String value) {
            addCriterion("SERIAL_FORMAT <=", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatLike(String value) {
            addCriterion("SERIAL_FORMAT like", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatNotLike(String value) {
            addCriterion("SERIAL_FORMAT not like", value, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatIn(List<String> values) {
            addCriterion("SERIAL_FORMAT in", values, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatNotIn(List<String> values) {
            addCriterion("SERIAL_FORMAT not in", values, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatBetween(String value1, String value2) {
            addCriterion("SERIAL_FORMAT between", value1, value2, "serialFormat");
            return (Criteria) this;
        }

        public Criteria andSerialFormatNotBetween(String value1, String value2) {
            addCriterion("SERIAL_FORMAT not between", value1, value2, "serialFormat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}