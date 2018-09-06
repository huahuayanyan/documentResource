package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysLnCdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysLnCdExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysLnCdExample(BSysLnCdExample example) {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRatecodeIsNull() {
            addCriterion("RATECODE is null");
            return (Criteria) this;
        }

        public Criteria andRatecodeIsNotNull() {
            addCriterion("RATECODE is not null");
            return (Criteria) this;
        }

        public Criteria andRatecodeEqualTo(String value) {
            addCriterion("RATECODE =", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeNotEqualTo(String value) {
            addCriterion("RATECODE <>", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeGreaterThan(String value) {
            addCriterion("RATECODE >", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeGreaterThanOrEqualTo(String value) {
            addCriterion("RATECODE >=", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeLessThan(String value) {
            addCriterion("RATECODE <", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeLessThanOrEqualTo(String value) {
            addCriterion("RATECODE <=", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeLike(String value) {
            addCriterion("RATECODE like", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeNotLike(String value) {
            addCriterion("RATECODE not like", value, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeIn(List<String> values) {
            addCriterion("RATECODE in", values, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeNotIn(List<String> values) {
            addCriterion("RATECODE not in", values, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeBetween(String value1, String value2) {
            addCriterion("RATECODE between", value1, value2, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatecodeNotBetween(String value1, String value2) {
            addCriterion("RATECODE not between", value1, value2, "ratecode");
            return (Criteria) this;
        }

        public Criteria andRatenameIsNull() {
            addCriterion("RATENAME is null");
            return (Criteria) this;
        }

        public Criteria andRatenameIsNotNull() {
            addCriterion("RATENAME is not null");
            return (Criteria) this;
        }

        public Criteria andRatenameEqualTo(String value) {
            addCriterion("RATENAME =", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameNotEqualTo(String value) {
            addCriterion("RATENAME <>", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameGreaterThan(String value) {
            addCriterion("RATENAME >", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameGreaterThanOrEqualTo(String value) {
            addCriterion("RATENAME >=", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameLessThan(String value) {
            addCriterion("RATENAME <", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameLessThanOrEqualTo(String value) {
            addCriterion("RATENAME <=", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameLike(String value) {
            addCriterion("RATENAME like", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameNotLike(String value) {
            addCriterion("RATENAME not like", value, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameIn(List<String> values) {
            addCriterion("RATENAME in", values, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameNotIn(List<String> values) {
            addCriterion("RATENAME not in", values, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameBetween(String value1, String value2) {
            addCriterion("RATENAME between", value1, value2, "ratename");
            return (Criteria) this;
        }

        public Criteria andRatenameNotBetween(String value1, String value2) {
            addCriterion("RATENAME not between", value1, value2, "ratename");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}