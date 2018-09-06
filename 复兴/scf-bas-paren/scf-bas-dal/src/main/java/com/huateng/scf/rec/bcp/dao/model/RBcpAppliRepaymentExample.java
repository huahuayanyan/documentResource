package com.huateng.scf.rec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RBcpAppliRepaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RBcpAppliRepaymentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RBcpAppliRepaymentExample(RBcpAppliRepaymentExample example) {
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

        public Criteria andAppnoIsNull() {
            addCriterion("APPNO is null");
            return (Criteria) this;
        }

        public Criteria andAppnoIsNotNull() {
            addCriterion("APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andAppnoEqualTo(String value) {
            addCriterion("APPNO =", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotEqualTo(String value) {
            addCriterion("APPNO <>", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoGreaterThan(String value) {
            addCriterion("APPNO >", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("APPNO >=", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLessThan(String value) {
            addCriterion("APPNO <", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLessThanOrEqualTo(String value) {
            addCriterion("APPNO <=", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLike(String value) {
            addCriterion("APPNO like", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotLike(String value) {
            addCriterion("APPNO not like", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoIn(List<String> values) {
            addCriterion("APPNO in", values, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotIn(List<String> values) {
            addCriterion("APPNO not in", values, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoBetween(String value1, String value2) {
            addCriterion("APPNO between", value1, value2, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotBetween(String value1, String value2) {
            addCriterion("APPNO not between", value1, value2, "appno");
            return (Criteria) this;
        }

        public Criteria andReturnIdIsNull() {
            addCriterion("RETURN_ID is null");
            return (Criteria) this;
        }

        public Criteria andReturnIdIsNotNull() {
            addCriterion("RETURN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReturnIdEqualTo(String value) {
            addCriterion("RETURN_ID =", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdNotEqualTo(String value) {
            addCriterion("RETURN_ID <>", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdGreaterThan(String value) {
            addCriterion("RETURN_ID >", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_ID >=", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdLessThan(String value) {
            addCriterion("RETURN_ID <", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdLessThanOrEqualTo(String value) {
            addCriterion("RETURN_ID <=", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdLike(String value) {
            addCriterion("RETURN_ID like", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdNotLike(String value) {
            addCriterion("RETURN_ID not like", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdIn(List<String> values) {
            addCriterion("RETURN_ID in", values, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdNotIn(List<String> values) {
            addCriterion("RETURN_ID not in", values, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdBetween(String value1, String value2) {
            addCriterion("RETURN_ID between", value1, value2, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdNotBetween(String value1, String value2) {
            addCriterion("RETURN_ID not between", value1, value2, "returnId");
            return (Criteria) this;
        }

        public Criteria andDebetNoIsNull() {
            addCriterion("DEBET_NO is null");
            return (Criteria) this;
        }

        public Criteria andDebetNoIsNotNull() {
            addCriterion("DEBET_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDebetNoEqualTo(String value) {
            addCriterion("DEBET_NO =", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotEqualTo(String value) {
            addCriterion("DEBET_NO <>", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoGreaterThan(String value) {
            addCriterion("DEBET_NO >", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoGreaterThanOrEqualTo(String value) {
            addCriterion("DEBET_NO >=", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoLessThan(String value) {
            addCriterion("DEBET_NO <", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoLessThanOrEqualTo(String value) {
            addCriterion("DEBET_NO <=", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoLike(String value) {
            addCriterion("DEBET_NO like", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotLike(String value) {
            addCriterion("DEBET_NO not like", value, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoIn(List<String> values) {
            addCriterion("DEBET_NO in", values, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotIn(List<String> values) {
            addCriterion("DEBET_NO not in", values, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoBetween(String value1, String value2) {
            addCriterion("DEBET_NO between", value1, value2, "debetNo");
            return (Criteria) this;
        }

        public Criteria andDebetNoNotBetween(String value1, String value2) {
            addCriterion("DEBET_NO not between", value1, value2, "debetNo");
            return (Criteria) this;
        }

        public Criteria andAmountOverIsNull() {
            addCriterion("AMOUNT_OVER is null");
            return (Criteria) this;
        }

        public Criteria andAmountOverIsNotNull() {
            addCriterion("AMOUNT_OVER is not null");
            return (Criteria) this;
        }

        public Criteria andAmountOverEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OVER =", value, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OVER <>", value, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_OVER >", value, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OVER >=", value, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverLessThan(BigDecimal value) {
            addCriterion("AMOUNT_OVER <", value, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OVER <=", value, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_OVER in", values, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_OVER not in", values, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_OVER between", value1, value2, "amountOver");
            return (Criteria) this;
        }

        public Criteria andAmountOverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_OVER not between", value1, value2, "amountOver");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNull() {
            addCriterion("RETURN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNotNull() {
            addCriterion("RETURN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeEqualTo(String value) {
            addCriterion("RETURN_TYPE =", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotEqualTo(String value) {
            addCriterion("RETURN_TYPE <>", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThan(String value) {
            addCriterion("RETURN_TYPE >", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_TYPE >=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThan(String value) {
            addCriterion("RETURN_TYPE <", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThanOrEqualTo(String value) {
            addCriterion("RETURN_TYPE <=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLike(String value) {
            addCriterion("RETURN_TYPE like", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotLike(String value) {
            addCriterion("RETURN_TYPE not like", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIn(List<String> values) {
            addCriterion("RETURN_TYPE in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotIn(List<String> values) {
            addCriterion("RETURN_TYPE not in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeBetween(String value1, String value2) {
            addCriterion("RETURN_TYPE between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotBetween(String value1, String value2) {
            addCriterion("RETURN_TYPE not between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnMethodIsNull() {
            addCriterion("RETURN_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andReturnMethodIsNotNull() {
            addCriterion("RETURN_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andReturnMethodEqualTo(String value) {
            addCriterion("RETURN_METHOD =", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodNotEqualTo(String value) {
            addCriterion("RETURN_METHOD <>", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodGreaterThan(String value) {
            addCriterion("RETURN_METHOD >", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_METHOD >=", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodLessThan(String value) {
            addCriterion("RETURN_METHOD <", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodLessThanOrEqualTo(String value) {
            addCriterion("RETURN_METHOD <=", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodLike(String value) {
            addCriterion("RETURN_METHOD like", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodNotLike(String value) {
            addCriterion("RETURN_METHOD not like", value, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodIn(List<String> values) {
            addCriterion("RETURN_METHOD in", values, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodNotIn(List<String> values) {
            addCriterion("RETURN_METHOD not in", values, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodBetween(String value1, String value2) {
            addCriterion("RETURN_METHOD between", value1, value2, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andReturnMethodNotBetween(String value1, String value2) {
            addCriterion("RETURN_METHOD not between", value1, value2, "returnMethod");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountIsNull() {
            addCriterion("TO_SALLER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountIsNotNull() {
            addCriterion("TO_SALLER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountEqualTo(BigDecimal value) {
            addCriterion("TO_SALLER_AMOUNT =", value, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountNotEqualTo(BigDecimal value) {
            addCriterion("TO_SALLER_AMOUNT <>", value, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountGreaterThan(BigDecimal value) {
            addCriterion("TO_SALLER_AMOUNT >", value, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TO_SALLER_AMOUNT >=", value, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountLessThan(BigDecimal value) {
            addCriterion("TO_SALLER_AMOUNT <", value, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TO_SALLER_AMOUNT <=", value, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountIn(List<BigDecimal> values) {
            addCriterion("TO_SALLER_AMOUNT in", values, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountNotIn(List<BigDecimal> values) {
            addCriterion("TO_SALLER_AMOUNT not in", values, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TO_SALLER_AMOUNT between", value1, value2, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToSallerAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TO_SALLER_AMOUNT not between", value1, value2, "toSallerAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountIsNull() {
            addCriterion("TO_POOL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountIsNotNull() {
            addCriterion("TO_POOL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountEqualTo(BigDecimal value) {
            addCriterion("TO_POOL_AMOUNT =", value, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountNotEqualTo(BigDecimal value) {
            addCriterion("TO_POOL_AMOUNT <>", value, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountGreaterThan(BigDecimal value) {
            addCriterion("TO_POOL_AMOUNT >", value, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TO_POOL_AMOUNT >=", value, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountLessThan(BigDecimal value) {
            addCriterion("TO_POOL_AMOUNT <", value, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TO_POOL_AMOUNT <=", value, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountIn(List<BigDecimal> values) {
            addCriterion("TO_POOL_AMOUNT in", values, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountNotIn(List<BigDecimal> values) {
            addCriterion("TO_POOL_AMOUNT not in", values, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TO_POOL_AMOUNT between", value1, value2, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andToPoolAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TO_POOL_AMOUNT not between", value1, value2, "toPoolAmount");
            return (Criteria) this;
        }

        public Criteria andCustcdIsNull() {
            addCriterion("CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCustcdIsNotNull() {
            addCriterion("CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdEqualTo(String value) {
            addCriterion("CUSTCD =", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotEqualTo(String value) {
            addCriterion("CUSTCD <>", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThan(String value) {
            addCriterion("CUSTCD >", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD >=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThan(String value) {
            addCriterion("CUSTCD <", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD <=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLike(String value) {
            addCriterion("CUSTCD like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotLike(String value) {
            addCriterion("CUSTCD not like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdIn(List<String> values) {
            addCriterion("CUSTCD in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotIn(List<String> values) {
            addCriterion("CUSTCD not in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdBetween(String value1, String value2) {
            addCriterion("CUSTCD between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotBetween(String value1, String value2) {
            addCriterion("CUSTCD not between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoIsNull() {
            addCriterion("DEBT_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoIsNotNull() {
            addCriterion("DEBT_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoEqualTo(String value) {
            addCriterion("DEBT_APPNO =", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoNotEqualTo(String value) {
            addCriterion("DEBT_APPNO <>", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoGreaterThan(String value) {
            addCriterion("DEBT_APPNO >", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("DEBT_APPNO >=", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoLessThan(String value) {
            addCriterion("DEBT_APPNO <", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoLessThanOrEqualTo(String value) {
            addCriterion("DEBT_APPNO <=", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoLike(String value) {
            addCriterion("DEBT_APPNO like", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoNotLike(String value) {
            addCriterion("DEBT_APPNO not like", value, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoIn(List<String> values) {
            addCriterion("DEBT_APPNO in", values, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoNotIn(List<String> values) {
            addCriterion("DEBT_APPNO not in", values, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoBetween(String value1, String value2) {
            addCriterion("DEBT_APPNO between", value1, value2, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andDebtAppnoNotBetween(String value1, String value2) {
            addCriterion("DEBT_APPNO not between", value1, value2, "debtAppno");
            return (Criteria) this;
        }

        public Criteria andCurcdIsNull() {
            addCriterion("CURCD is null");
            return (Criteria) this;
        }

        public Criteria andCurcdIsNotNull() {
            addCriterion("CURCD is not null");
            return (Criteria) this;
        }

        public Criteria andCurcdEqualTo(String value) {
            addCriterion("CURCD =", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotEqualTo(String value) {
            addCriterion("CURCD <>", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdGreaterThan(String value) {
            addCriterion("CURCD >", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdGreaterThanOrEqualTo(String value) {
            addCriterion("CURCD >=", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdLessThan(String value) {
            addCriterion("CURCD <", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdLessThanOrEqualTo(String value) {
            addCriterion("CURCD <=", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdLike(String value) {
            addCriterion("CURCD like", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotLike(String value) {
            addCriterion("CURCD not like", value, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdIn(List<String> values) {
            addCriterion("CURCD in", values, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotIn(List<String> values) {
            addCriterion("CURCD not in", values, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdBetween(String value1, String value2) {
            addCriterion("CURCD between", value1, value2, "curcd");
            return (Criteria) this;
        }

        public Criteria andCurcdNotBetween(String value1, String value2) {
            addCriterion("CURCD not between", value1, value2, "curcd");
            return (Criteria) this;
        }

        public Criteria andCommonDateIsNull() {
            addCriterion("COMMON_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCommonDateIsNotNull() {
            addCriterion("COMMON_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCommonDateEqualTo(String value) {
            addCriterion("COMMON_DATE =", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotEqualTo(String value) {
            addCriterion("COMMON_DATE <>", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateGreaterThan(String value) {
            addCriterion("COMMON_DATE >", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateGreaterThanOrEqualTo(String value) {
            addCriterion("COMMON_DATE >=", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLessThan(String value) {
            addCriterion("COMMON_DATE <", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLessThanOrEqualTo(String value) {
            addCriterion("COMMON_DATE <=", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateLike(String value) {
            addCriterion("COMMON_DATE like", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotLike(String value) {
            addCriterion("COMMON_DATE not like", value, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateIn(List<String> values) {
            addCriterion("COMMON_DATE in", values, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotIn(List<String> values) {
            addCriterion("COMMON_DATE not in", values, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateBetween(String value1, String value2) {
            addCriterion("COMMON_DATE between", value1, value2, "commonDate");
            return (Criteria) this;
        }

        public Criteria andCommonDateNotBetween(String value1, String value2) {
            addCriterion("COMMON_DATE not between", value1, value2, "commonDate");
            return (Criteria) this;
        }

        public Criteria andTlrcdIsNull() {
            addCriterion("TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andTlrcdIsNotNull() {
            addCriterion("TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andTlrcdEqualTo(String value) {
            addCriterion("TLRCD =", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotEqualTo(String value) {
            addCriterion("TLRCD <>", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdGreaterThan(String value) {
            addCriterion("TLRCD >", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("TLRCD >=", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdLessThan(String value) {
            addCriterion("TLRCD <", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdLessThanOrEqualTo(String value) {
            addCriterion("TLRCD <=", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdLike(String value) {
            addCriterion("TLRCD like", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotLike(String value) {
            addCriterion("TLRCD not like", value, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdIn(List<String> values) {
            addCriterion("TLRCD in", values, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotIn(List<String> values) {
            addCriterion("TLRCD not in", values, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdBetween(String value1, String value2) {
            addCriterion("TLRCD between", value1, value2, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andTlrcdNotBetween(String value1, String value2) {
            addCriterion("TLRCD not between", value1, value2, "tlrcd");
            return (Criteria) this;
        }

        public Criteria andBrcodeIsNull() {
            addCriterion("BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andBrcodeIsNotNull() {
            addCriterion("BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBrcodeEqualTo(String value) {
            addCriterion("BRCODE =", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotEqualTo(String value) {
            addCriterion("BRCODE <>", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeGreaterThan(String value) {
            addCriterion("BRCODE >", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BRCODE >=", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeLessThan(String value) {
            addCriterion("BRCODE <", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeLessThanOrEqualTo(String value) {
            addCriterion("BRCODE <=", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeLike(String value) {
            addCriterion("BRCODE like", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotLike(String value) {
            addCriterion("BRCODE not like", value, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeIn(List<String> values) {
            addCriterion("BRCODE in", values, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotIn(List<String> values) {
            addCriterion("BRCODE not in", values, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeBetween(String value1, String value2) {
            addCriterion("BRCODE between", value1, value2, "brcode");
            return (Criteria) this;
        }

        public Criteria andBrcodeNotBetween(String value1, String value2) {
            addCriterion("BRCODE not between", value1, value2, "brcode");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtIsNull() {
            addCriterion("REPAY_INTAMT is null");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtIsNotNull() {
            addCriterion("REPAY_INTAMT is not null");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtEqualTo(BigDecimal value) {
            addCriterion("REPAY_INTAMT =", value, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtNotEqualTo(BigDecimal value) {
            addCriterion("REPAY_INTAMT <>", value, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtGreaterThan(BigDecimal value) {
            addCriterion("REPAY_INTAMT >", value, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAY_INTAMT >=", value, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtLessThan(BigDecimal value) {
            addCriterion("REPAY_INTAMT <", value, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAY_INTAMT <=", value, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtIn(List<BigDecimal> values) {
            addCriterion("REPAY_INTAMT in", values, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtNotIn(List<BigDecimal> values) {
            addCriterion("REPAY_INTAMT not in", values, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAY_INTAMT between", value1, value2, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayIntamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAY_INTAMT not between", value1, value2, "repayIntamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtIsNull() {
            addCriterion("REPAY_BALAMT is null");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtIsNotNull() {
            addCriterion("REPAY_BALAMT is not null");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtEqualTo(BigDecimal value) {
            addCriterion("REPAY_BALAMT =", value, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtNotEqualTo(BigDecimal value) {
            addCriterion("REPAY_BALAMT <>", value, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtGreaterThan(BigDecimal value) {
            addCriterion("REPAY_BALAMT >", value, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAY_BALAMT >=", value, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtLessThan(BigDecimal value) {
            addCriterion("REPAY_BALAMT <", value, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAY_BALAMT <=", value, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtIn(List<BigDecimal> values) {
            addCriterion("REPAY_BALAMT in", values, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtNotIn(List<BigDecimal> values) {
            addCriterion("REPAY_BALAMT not in", values, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAY_BALAMT between", value1, value2, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayBalamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAY_BALAMT not between", value1, value2, "repayBalamt");
            return (Criteria) this;
        }

        public Criteria andRepayAmountIsNull() {
            addCriterion("REPAY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRepayAmountIsNotNull() {
            addCriterion("REPAY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRepayAmountEqualTo(BigDecimal value) {
            addCriterion("REPAY_AMOUNT =", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountNotEqualTo(BigDecimal value) {
            addCriterion("REPAY_AMOUNT <>", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountGreaterThan(BigDecimal value) {
            addCriterion("REPAY_AMOUNT >", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAY_AMOUNT >=", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountLessThan(BigDecimal value) {
            addCriterion("REPAY_AMOUNT <", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAY_AMOUNT <=", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountIn(List<BigDecimal> values) {
            addCriterion("REPAY_AMOUNT in", values, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountNotIn(List<BigDecimal> values) {
            addCriterion("REPAY_AMOUNT not in", values, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAY_AMOUNT between", value1, value2, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAY_AMOUNT not between", value1, value2, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayDateIsNull() {
            addCriterion("REPAY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRepayDateIsNotNull() {
            addCriterion("REPAY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRepayDateEqualTo(String value) {
            addCriterion("REPAY_DATE =", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotEqualTo(String value) {
            addCriterion("REPAY_DATE <>", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateGreaterThan(String value) {
            addCriterion("REPAY_DATE >", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateGreaterThanOrEqualTo(String value) {
            addCriterion("REPAY_DATE >=", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateLessThan(String value) {
            addCriterion("REPAY_DATE <", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateLessThanOrEqualTo(String value) {
            addCriterion("REPAY_DATE <=", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateLike(String value) {
            addCriterion("REPAY_DATE like", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotLike(String value) {
            addCriterion("REPAY_DATE not like", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateIn(List<String> values) {
            addCriterion("REPAY_DATE in", values, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotIn(List<String> values) {
            addCriterion("REPAY_DATE not in", values, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateBetween(String value1, String value2) {
            addCriterion("REPAY_DATE between", value1, value2, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotBetween(String value1, String value2) {
            addCriterion("REPAY_DATE not between", value1, value2, "repayDate");
            return (Criteria) this;
        }

        public Criteria andMastContnoIsNull() {
            addCriterion("MAST_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andMastContnoIsNotNull() {
            addCriterion("MAST_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andMastContnoEqualTo(String value) {
            addCriterion("MAST_CONTNO =", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotEqualTo(String value) {
            addCriterion("MAST_CONTNO <>", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoGreaterThan(String value) {
            addCriterion("MAST_CONTNO >", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoGreaterThanOrEqualTo(String value) {
            addCriterion("MAST_CONTNO >=", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLessThan(String value) {
            addCriterion("MAST_CONTNO <", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLessThanOrEqualTo(String value) {
            addCriterion("MAST_CONTNO <=", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLike(String value) {
            addCriterion("MAST_CONTNO like", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotLike(String value) {
            addCriterion("MAST_CONTNO not like", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoIn(List<String> values) {
            addCriterion("MAST_CONTNO in", values, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotIn(List<String> values) {
            addCriterion("MAST_CONTNO not in", values, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoBetween(String value1, String value2) {
            addCriterion("MAST_CONTNO between", value1, value2, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotBetween(String value1, String value2) {
            addCriterion("MAST_CONTNO not between", value1, value2, "mastContno");
            return (Criteria) this;
        }

        public Criteria andDebetIdIsNull() {
            addCriterion("DEBET_ID is null");
            return (Criteria) this;
        }

        public Criteria andDebetIdIsNotNull() {
            addCriterion("DEBET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDebetIdEqualTo(String value) {
            addCriterion("DEBET_ID =", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotEqualTo(String value) {
            addCriterion("DEBET_ID <>", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdGreaterThan(String value) {
            addCriterion("DEBET_ID >", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEBET_ID >=", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdLessThan(String value) {
            addCriterion("DEBET_ID <", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdLessThanOrEqualTo(String value) {
            addCriterion("DEBET_ID <=", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdLike(String value) {
            addCriterion("DEBET_ID like", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotLike(String value) {
            addCriterion("DEBET_ID not like", value, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdIn(List<String> values) {
            addCriterion("DEBET_ID in", values, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotIn(List<String> values) {
            addCriterion("DEBET_ID not in", values, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdBetween(String value1, String value2) {
            addCriterion("DEBET_ID between", value1, value2, "debetId");
            return (Criteria) this;
        }

        public Criteria andDebetIdNotBetween(String value1, String value2) {
            addCriterion("DEBET_ID not between", value1, value2, "debetId");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("PAY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("PAY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(BigDecimal value) {
            addCriterion("PAY_AMOUNT >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(BigDecimal value) {
            addCriterion("PAY_AMOUNT <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<BigDecimal> values) {
            addCriterion("PAY_AMOUNT in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<BigDecimal> values) {
            addCriterion("PAY_AMOUNT not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_AMOUNT between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_AMOUNT not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNull() {
            addCriterion("ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("ACCOUNT_NO =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("ACCOUNT_NO <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("ACCOUNT_NO >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("ACCOUNT_NO <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("ACCOUNT_NO like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("ACCOUNT_NO not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("ACCOUNT_NO in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("ACCOUNT_NO not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO not between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}