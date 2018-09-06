package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysFlowUrlRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysFlowUrlRelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysFlowUrlRelExample(BSysFlowUrlRelExample example) {
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

        public Criteria andFlowIdIsNull() {
            addCriterion("FLOW_ID is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("FLOW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(String value) {
            addCriterion("FLOW_ID =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(String value) {
            addCriterion("FLOW_ID <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(String value) {
            addCriterion("FLOW_ID >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(String value) {
            addCriterion("FLOW_ID >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(String value) {
            addCriterion("FLOW_ID <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(String value) {
            addCriterion("FLOW_ID <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLike(String value) {
            addCriterion("FLOW_ID like", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotLike(String value) {
            addCriterion("FLOW_ID not like", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<String> values) {
            addCriterion("FLOW_ID in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<String> values) {
            addCriterion("FLOW_ID not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(String value1, String value2) {
            addCriterion("FLOW_ID between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(String value1, String value2) {
            addCriterion("FLOW_ID not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("NODE_ID =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("NODE_ID <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("NODE_ID >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_ID >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("NODE_ID <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("NODE_ID <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("NODE_ID like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("NODE_ID not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("NODE_ID in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("NODE_ID not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("NODE_ID between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("NODE_ID not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andPgUrlIsNull() {
            addCriterion("PG_URL is null");
            return (Criteria) this;
        }

        public Criteria andPgUrlIsNotNull() {
            addCriterion("PG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andPgUrlEqualTo(String value) {
            addCriterion("PG_URL =", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlNotEqualTo(String value) {
            addCriterion("PG_URL <>", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlGreaterThan(String value) {
            addCriterion("PG_URL >", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("PG_URL >=", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlLessThan(String value) {
            addCriterion("PG_URL <", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlLessThanOrEqualTo(String value) {
            addCriterion("PG_URL <=", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlLike(String value) {
            addCriterion("PG_URL like", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlNotLike(String value) {
            addCriterion("PG_URL not like", value, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlIn(List<String> values) {
            addCriterion("PG_URL in", values, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlNotIn(List<String> values) {
            addCriterion("PG_URL not in", values, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlBetween(String value1, String value2) {
            addCriterion("PG_URL between", value1, value2, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andPgUrlNotBetween(String value1, String value2) {
            addCriterion("PG_URL not between", value1, value2, "pgUrl");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNull() {
            addCriterion("BUSS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNotNull() {
            addCriterion("BUSS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBussTypeEqualTo(String value) {
            addCriterion("BUSS_TYPE =", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotEqualTo(String value) {
            addCriterion("BUSS_TYPE <>", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThan(String value) {
            addCriterion("BUSS_TYPE >", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE >=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThan(String value) {
            addCriterion("BUSS_TYPE <", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE <=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLike(String value) {
            addCriterion("BUSS_TYPE like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotLike(String value) {
            addCriterion("BUSS_TYPE not like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeIn(List<String> values) {
            addCriterion("BUSS_TYPE in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotIn(List<String> values) {
            addCriterion("BUSS_TYPE not in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE not between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andNodeButtonIsNull() {
            addCriterion("NODE_BUTTON is null");
            return (Criteria) this;
        }

        public Criteria andNodeButtonIsNotNull() {
            addCriterion("NODE_BUTTON is not null");
            return (Criteria) this;
        }

        public Criteria andNodeButtonEqualTo(String value) {
            addCriterion("NODE_BUTTON =", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonNotEqualTo(String value) {
            addCriterion("NODE_BUTTON <>", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonGreaterThan(String value) {
            addCriterion("NODE_BUTTON >", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_BUTTON >=", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonLessThan(String value) {
            addCriterion("NODE_BUTTON <", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonLessThanOrEqualTo(String value) {
            addCriterion("NODE_BUTTON <=", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonLike(String value) {
            addCriterion("NODE_BUTTON like", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonNotLike(String value) {
            addCriterion("NODE_BUTTON not like", value, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonIn(List<String> values) {
            addCriterion("NODE_BUTTON in", values, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonNotIn(List<String> values) {
            addCriterion("NODE_BUTTON not in", values, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonBetween(String value1, String value2) {
            addCriterion("NODE_BUTTON between", value1, value2, "nodeButton");
            return (Criteria) this;
        }

        public Criteria andNodeButtonNotBetween(String value1, String value2) {
            addCriterion("NODE_BUTTON not between", value1, value2, "nodeButton");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}