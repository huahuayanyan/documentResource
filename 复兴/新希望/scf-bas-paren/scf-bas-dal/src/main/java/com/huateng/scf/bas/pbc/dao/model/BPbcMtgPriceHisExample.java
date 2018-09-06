package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcMtgPriceHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcMtgPriceHisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcMtgPriceHisExample(BPbcMtgPriceHisExample example) {
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

        public Criteria andMortgageNoIsNull() {
            addCriterion("MORTGAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIsNotNull() {
            addCriterion("MORTGAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoEqualTo(String value) {
            addCriterion("MORTGAGE_NO =", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotEqualTo(String value) {
            addCriterion("MORTGAGE_NO <>", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThan(String value) {
            addCriterion("MORTGAGE_NO >", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NO >=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThan(String value) {
            addCriterion("MORTGAGE_NO <", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NO <=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLike(String value) {
            addCriterion("MORTGAGE_NO like", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotLike(String value) {
            addCriterion("MORTGAGE_NO not like", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIn(List<String> values) {
            addCriterion("MORTGAGE_NO in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotIn(List<String> values) {
            addCriterion("MORTGAGE_NO not in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NO between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NO not between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria and申请号IsNull() {
            addCriterion("申请号 is null");
            return (Criteria) this;
        }

        public Criteria and申请号IsNotNull() {
            addCriterion("申请号 is not null");
            return (Criteria) this;
        }

        public Criteria and申请号EqualTo(String value) {
            addCriterion("申请号 =", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号NotEqualTo(String value) {
            addCriterion("申请号 <>", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号GreaterThan(String value) {
            addCriterion("申请号 >", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号GreaterThanOrEqualTo(String value) {
            addCriterion("申请号 >=", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号LessThan(String value) {
            addCriterion("申请号 <", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号LessThanOrEqualTo(String value) {
            addCriterion("申请号 <=", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号Like(String value) {
            addCriterion("申请号 like", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号NotLike(String value) {
            addCriterion("申请号 not like", value, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号In(List<String> values) {
            addCriterion("申请号 in", values, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号NotIn(List<String> values) {
            addCriterion("申请号 not in", values, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号Between(String value1, String value2) {
            addCriterion("申请号 between", value1, value2, "申请号");
            return (Criteria) this;
        }

        public Criteria and申请号NotBetween(String value1, String value2) {
            addCriterion("申请号 not between", value1, value2, "申请号");
            return (Criteria) this;
        }

        public Criteria andTxdateIsNull() {
            addCriterion("TXDATE is null");
            return (Criteria) this;
        }

        public Criteria andTxdateIsNotNull() {
            addCriterion("TXDATE is not null");
            return (Criteria) this;
        }

        public Criteria andTxdateEqualTo(String value) {
            addCriterion("TXDATE =", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotEqualTo(String value) {
            addCriterion("TXDATE <>", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateGreaterThan(String value) {
            addCriterion("TXDATE >", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateGreaterThanOrEqualTo(String value) {
            addCriterion("TXDATE >=", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLessThan(String value) {
            addCriterion("TXDATE <", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLessThanOrEqualTo(String value) {
            addCriterion("TXDATE <=", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLike(String value) {
            addCriterion("TXDATE like", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotLike(String value) {
            addCriterion("TXDATE not like", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateIn(List<String> values) {
            addCriterion("TXDATE in", values, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotIn(List<String> values) {
            addCriterion("TXDATE not in", values, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateBetween(String value1, String value2) {
            addCriterion("TXDATE between", value1, value2, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotBetween(String value1, String value2) {
            addCriterion("TXDATE not between", value1, value2, "txdate");
            return (Criteria) this;
        }

        public Criteria andPriceWayIsNull() {
            addCriterion("PRICE_WAY is null");
            return (Criteria) this;
        }

        public Criteria andPriceWayIsNotNull() {
            addCriterion("PRICE_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andPriceWayEqualTo(String value) {
            addCriterion("PRICE_WAY =", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayNotEqualTo(String value) {
            addCriterion("PRICE_WAY <>", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayGreaterThan(String value) {
            addCriterion("PRICE_WAY >", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_WAY >=", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayLessThan(String value) {
            addCriterion("PRICE_WAY <", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayLessThanOrEqualTo(String value) {
            addCriterion("PRICE_WAY <=", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayLike(String value) {
            addCriterion("PRICE_WAY like", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayNotLike(String value) {
            addCriterion("PRICE_WAY not like", value, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayIn(List<String> values) {
            addCriterion("PRICE_WAY in", values, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayNotIn(List<String> values) {
            addCriterion("PRICE_WAY not in", values, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayBetween(String value1, String value2) {
            addCriterion("PRICE_WAY between", value1, value2, "priceWay");
            return (Criteria) this;
        }

        public Criteria andPriceWayNotBetween(String value1, String value2) {
            addCriterion("PRICE_WAY not between", value1, value2, "priceWay");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIsNull() {
            addCriterion("EVAL_ORG is null");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIsNotNull() {
            addCriterion("EVAL_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andEvalOrgEqualTo(String value) {
            addCriterion("EVAL_ORG =", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNotEqualTo(String value) {
            addCriterion("EVAL_ORG <>", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgGreaterThan(String value) {
            addCriterion("EVAL_ORG >", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_ORG >=", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgLessThan(String value) {
            addCriterion("EVAL_ORG <", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgLessThanOrEqualTo(String value) {
            addCriterion("EVAL_ORG <=", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgLike(String value) {
            addCriterion("EVAL_ORG like", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNotLike(String value) {
            addCriterion("EVAL_ORG not like", value, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIn(List<String> values) {
            addCriterion("EVAL_ORG in", values, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNotIn(List<String> values) {
            addCriterion("EVAL_ORG not in", values, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgBetween(String value1, String value2) {
            addCriterion("EVAL_ORG between", value1, value2, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNotBetween(String value1, String value2) {
            addCriterion("EVAL_ORG not between", value1, value2, "evalOrg");
            return (Criteria) this;
        }

        public Criteria andEvalTimeIsNull() {
            addCriterion("EVAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEvalTimeIsNotNull() {
            addCriterion("EVAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEvalTimeEqualTo(String value) {
            addCriterion("EVAL_TIME =", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeNotEqualTo(String value) {
            addCriterion("EVAL_TIME <>", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeGreaterThan(String value) {
            addCriterion("EVAL_TIME >", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_TIME >=", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeLessThan(String value) {
            addCriterion("EVAL_TIME <", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeLessThanOrEqualTo(String value) {
            addCriterion("EVAL_TIME <=", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeLike(String value) {
            addCriterion("EVAL_TIME like", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeNotLike(String value) {
            addCriterion("EVAL_TIME not like", value, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeIn(List<String> values) {
            addCriterion("EVAL_TIME in", values, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeNotIn(List<String> values) {
            addCriterion("EVAL_TIME not in", values, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeBetween(String value1, String value2) {
            addCriterion("EVAL_TIME between", value1, value2, "evalTime");
            return (Criteria) this;
        }

        public Criteria andEvalTimeNotBetween(String value1, String value2) {
            addCriterion("EVAL_TIME not between", value1, value2, "evalTime");
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

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
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

        public Criteria andPriceBasisIsNull() {
            addCriterion("PRICE_BASIS is null");
            return (Criteria) this;
        }

        public Criteria andPriceBasisIsNotNull() {
            addCriterion("PRICE_BASIS is not null");
            return (Criteria) this;
        }

        public Criteria andPriceBasisEqualTo(String value) {
            addCriterion("PRICE_BASIS =", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisNotEqualTo(String value) {
            addCriterion("PRICE_BASIS <>", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisGreaterThan(String value) {
            addCriterion("PRICE_BASIS >", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_BASIS >=", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisLessThan(String value) {
            addCriterion("PRICE_BASIS <", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisLessThanOrEqualTo(String value) {
            addCriterion("PRICE_BASIS <=", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisLike(String value) {
            addCriterion("PRICE_BASIS like", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisNotLike(String value) {
            addCriterion("PRICE_BASIS not like", value, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisIn(List<String> values) {
            addCriterion("PRICE_BASIS in", values, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisNotIn(List<String> values) {
            addCriterion("PRICE_BASIS not in", values, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisBetween(String value1, String value2) {
            addCriterion("PRICE_BASIS between", value1, value2, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceBasisNotBetween(String value1, String value2) {
            addCriterion("PRICE_BASIS not between", value1, value2, "priceBasis");
            return (Criteria) this;
        }

        public Criteria andPriceSourceIsNull() {
            addCriterion("PRICE_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andPriceSourceIsNotNull() {
            addCriterion("PRICE_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceSourceEqualTo(String value) {
            addCriterion("PRICE_SOURCE =", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceNotEqualTo(String value) {
            addCriterion("PRICE_SOURCE <>", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceGreaterThan(String value) {
            addCriterion("PRICE_SOURCE >", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_SOURCE >=", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceLessThan(String value) {
            addCriterion("PRICE_SOURCE <", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceLessThanOrEqualTo(String value) {
            addCriterion("PRICE_SOURCE <=", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceLike(String value) {
            addCriterion("PRICE_SOURCE like", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceNotLike(String value) {
            addCriterion("PRICE_SOURCE not like", value, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceIn(List<String> values) {
            addCriterion("PRICE_SOURCE in", values, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceNotIn(List<String> values) {
            addCriterion("PRICE_SOURCE not in", values, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceBetween(String value1, String value2) {
            addCriterion("PRICE_SOURCE between", value1, value2, "priceSource");
            return (Criteria) this;
        }

        public Criteria andPriceSourceNotBetween(String value1, String value2) {
            addCriterion("PRICE_SOURCE not between", value1, value2, "priceSource");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPriceOldIsNull() {
            addCriterion("PRICE_OLD is null");
            return (Criteria) this;
        }

        public Criteria andPriceOldIsNotNull() {
            addCriterion("PRICE_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOldEqualTo(BigDecimal value) {
            addCriterion("PRICE_OLD =", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldNotEqualTo(BigDecimal value) {
            addCriterion("PRICE_OLD <>", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldGreaterThan(BigDecimal value) {
            addCriterion("PRICE_OLD >", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_OLD >=", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldLessThan(BigDecimal value) {
            addCriterion("PRICE_OLD <", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_OLD <=", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldIn(List<BigDecimal> values) {
            addCriterion("PRICE_OLD in", values, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldNotIn(List<BigDecimal> values) {
            addCriterion("PRICE_OLD not in", values, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_OLD between", value1, value2, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_OLD not between", value1, value2, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceNewIsNull() {
            addCriterion("PRICE_NEW is null");
            return (Criteria) this;
        }

        public Criteria andPriceNewIsNotNull() {
            addCriterion("PRICE_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andPriceNewEqualTo(BigDecimal value) {
            addCriterion("PRICE_NEW =", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewNotEqualTo(BigDecimal value) {
            addCriterion("PRICE_NEW <>", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewGreaterThan(BigDecimal value) {
            addCriterion("PRICE_NEW >", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_NEW >=", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewLessThan(BigDecimal value) {
            addCriterion("PRICE_NEW <", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE_NEW <=", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewIn(List<BigDecimal> values) {
            addCriterion("PRICE_NEW in", values, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewNotIn(List<BigDecimal> values) {
            addCriterion("PRICE_NEW not in", values, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_NEW between", value1, value2, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE_NEW not between", value1, value2, "priceNew");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("EXT1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("EXT2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("EXT2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("EXT2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("EXT2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("EXT2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("EXT2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("EXT2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("EXT2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("EXT2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("EXT2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("EXT2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("EXT2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("EXT2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("EXT2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("EXT3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("EXT3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("EXT3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("EXT3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("EXT3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("EXT3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("EXT3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("EXT3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("EXT3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("EXT3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("EXT3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("EXT3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("EXT3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("EXT3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}