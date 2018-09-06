package com.huateng.scf.bas.crr.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrLnConRelaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrLnConRelaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrLnConRelaExample(BCrrLnConRelaExample example) {
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

        public Criteria andIsRelateIsNull() {
            addCriterion("IS_RELATE is null");
            return (Criteria) this;
        }

        public Criteria andIsRelateIsNotNull() {
            addCriterion("IS_RELATE is not null");
            return (Criteria) this;
        }

        public Criteria andIsRelateEqualTo(String value) {
            addCriterion("IS_RELATE =", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateNotEqualTo(String value) {
            addCriterion("IS_RELATE <>", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateGreaterThan(String value) {
            addCriterion("IS_RELATE >", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateGreaterThanOrEqualTo(String value) {
            addCriterion("IS_RELATE >=", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateLessThan(String value) {
            addCriterion("IS_RELATE <", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateLessThanOrEqualTo(String value) {
            addCriterion("IS_RELATE <=", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateLike(String value) {
            addCriterion("IS_RELATE like", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateNotLike(String value) {
            addCriterion("IS_RELATE not like", value, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateIn(List<String> values) {
            addCriterion("IS_RELATE in", values, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateNotIn(List<String> values) {
            addCriterion("IS_RELATE not in", values, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateBetween(String value1, String value2) {
            addCriterion("IS_RELATE between", value1, value2, "isRelate");
            return (Criteria) this;
        }

        public Criteria andIsRelateNotBetween(String value1, String value2) {
            addCriterion("IS_RELATE not between", value1, value2, "isRelate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}