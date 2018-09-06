package com.huateng.scf.bas.nte.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNteNoticeLnciExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BNteNoticeLnciExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BNteNoticeLnciExample(BNteNoticeLnciExample example) {
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

        public Criteria andCnameIsNull() {
            addCriterion("CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("CNAME =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("CNAME <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("CNAME >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("CNAME <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("CNAME <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("CNAME like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("CNAME not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("CNAME in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("CNAME not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("CNAME between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("CNAME not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andThrCdIsNull() {
            addCriterion("THR_CD is null");
            return (Criteria) this;
        }

        public Criteria andThrCdIsNotNull() {
            addCriterion("THR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andThrCdEqualTo(String value) {
            addCriterion("THR_CD =", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdNotEqualTo(String value) {
            addCriterion("THR_CD <>", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdGreaterThan(String value) {
            addCriterion("THR_CD >", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdGreaterThanOrEqualTo(String value) {
            addCriterion("THR_CD >=", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdLessThan(String value) {
            addCriterion("THR_CD <", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdLessThanOrEqualTo(String value) {
            addCriterion("THR_CD <=", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdLike(String value) {
            addCriterion("THR_CD like", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdNotLike(String value) {
            addCriterion("THR_CD not like", value, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdIn(List<String> values) {
            addCriterion("THR_CD in", values, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdNotIn(List<String> values) {
            addCriterion("THR_CD not in", values, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdBetween(String value1, String value2) {
            addCriterion("THR_CD between", value1, value2, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrCdNotBetween(String value1, String value2) {
            addCriterion("THR_CD not between", value1, value2, "thrCd");
            return (Criteria) this;
        }

        public Criteria andThrNameIsNull() {
            addCriterion("THR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andThrNameIsNotNull() {
            addCriterion("THR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andThrNameEqualTo(String value) {
            addCriterion("THR_NAME =", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameNotEqualTo(String value) {
            addCriterion("THR_NAME <>", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameGreaterThan(String value) {
            addCriterion("THR_NAME >", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameGreaterThanOrEqualTo(String value) {
            addCriterion("THR_NAME >=", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameLessThan(String value) {
            addCriterion("THR_NAME <", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameLessThanOrEqualTo(String value) {
            addCriterion("THR_NAME <=", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameLike(String value) {
            addCriterion("THR_NAME like", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameNotLike(String value) {
            addCriterion("THR_NAME not like", value, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameIn(List<String> values) {
            addCriterion("THR_NAME in", values, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameNotIn(List<String> values) {
            addCriterion("THR_NAME not in", values, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameBetween(String value1, String value2) {
            addCriterion("THR_NAME between", value1, value2, "thrName");
            return (Criteria) this;
        }

        public Criteria andThrNameNotBetween(String value1, String value2) {
            addCriterion("THR_NAME not between", value1, value2, "thrName");
            return (Criteria) this;
        }

        public Criteria andFouCdIsNull() {
            addCriterion("FOU_CD is null");
            return (Criteria) this;
        }

        public Criteria andFouCdIsNotNull() {
            addCriterion("FOU_CD is not null");
            return (Criteria) this;
        }

        public Criteria andFouCdEqualTo(String value) {
            addCriterion("FOU_CD =", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdNotEqualTo(String value) {
            addCriterion("FOU_CD <>", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdGreaterThan(String value) {
            addCriterion("FOU_CD >", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdGreaterThanOrEqualTo(String value) {
            addCriterion("FOU_CD >=", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdLessThan(String value) {
            addCriterion("FOU_CD <", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdLessThanOrEqualTo(String value) {
            addCriterion("FOU_CD <=", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdLike(String value) {
            addCriterion("FOU_CD like", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdNotLike(String value) {
            addCriterion("FOU_CD not like", value, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdIn(List<String> values) {
            addCriterion("FOU_CD in", values, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdNotIn(List<String> values) {
            addCriterion("FOU_CD not in", values, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdBetween(String value1, String value2) {
            addCriterion("FOU_CD between", value1, value2, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouCdNotBetween(String value1, String value2) {
            addCriterion("FOU_CD not between", value1, value2, "fouCd");
            return (Criteria) this;
        }

        public Criteria andFouNameIsNull() {
            addCriterion("FOU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFouNameIsNotNull() {
            addCriterion("FOU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFouNameEqualTo(String value) {
            addCriterion("FOU_NAME =", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameNotEqualTo(String value) {
            addCriterion("FOU_NAME <>", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameGreaterThan(String value) {
            addCriterion("FOU_NAME >", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameGreaterThanOrEqualTo(String value) {
            addCriterion("FOU_NAME >=", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameLessThan(String value) {
            addCriterion("FOU_NAME <", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameLessThanOrEqualTo(String value) {
            addCriterion("FOU_NAME <=", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameLike(String value) {
            addCriterion("FOU_NAME like", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameNotLike(String value) {
            addCriterion("FOU_NAME not like", value, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameIn(List<String> values) {
            addCriterion("FOU_NAME in", values, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameNotIn(List<String> values) {
            addCriterion("FOU_NAME not in", values, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameBetween(String value1, String value2) {
            addCriterion("FOU_NAME between", value1, value2, "fouName");
            return (Criteria) this;
        }

        public Criteria andFouNameNotBetween(String value1, String value2) {
            addCriterion("FOU_NAME not between", value1, value2, "fouName");
            return (Criteria) this;
        }

        public Criteria andCreditAmountIsNull() {
            addCriterion("CREDIT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreditAmountIsNotNull() {
            addCriterion("CREDIT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditAmountEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT =", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT <>", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT >", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT >=", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountLessThan(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT <", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_AMOUNT <=", value, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountIn(List<BigDecimal> values) {
            addCriterion("CREDIT_AMOUNT in", values, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_AMOUNT not in", values, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_AMOUNT between", value1, value2, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andCreditAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_AMOUNT not between", value1, value2, "creditAmount");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNull() {
            addCriterion("LOW_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNotNull() {
            addCriterion("LOW_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE =", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE <>", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThan(BigDecimal value) {
            addCriterion("LOW_PRICE >", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE >=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThan(BigDecimal value) {
            addCriterion("LOW_PRICE <", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW_PRICE <=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotIn(List<BigDecimal> values) {
            addCriterion("LOW_PRICE not in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW_PRICE not between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountIsNull() {
            addCriterion("TOT_RISK_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountIsNotNull() {
            addCriterion("TOT_RISK_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountEqualTo(BigDecimal value) {
            addCriterion("TOT_RISK_AMOUNT =", value, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOT_RISK_AMOUNT <>", value, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountGreaterThan(BigDecimal value) {
            addCriterion("TOT_RISK_AMOUNT >", value, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_RISK_AMOUNT >=", value, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountLessThan(BigDecimal value) {
            addCriterion("TOT_RISK_AMOUNT <", value, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_RISK_AMOUNT <=", value, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountIn(List<BigDecimal> values) {
            addCriterion("TOT_RISK_AMOUNT in", values, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOT_RISK_AMOUNT not in", values, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_RISK_AMOUNT between", value1, value2, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andTotRiskAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_RISK_AMOUNT not between", value1, value2, "totRiskAmount");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIsNull() {
            addCriterion("LNCI_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIsNotNull() {
            addCriterion("LNCI_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLnciAmtEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT =", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT <>", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtGreaterThan(BigDecimal value) {
            addCriterion("LNCI_AMT >", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT >=", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtLessThan(BigDecimal value) {
            addCriterion("LNCI_AMT <", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT <=", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIn(List<BigDecimal> values) {
            addCriterion("LNCI_AMT in", values, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotIn(List<BigDecimal> values) {
            addCriterion("LNCI_AMT not in", values, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_AMT between", value1, value2, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_AMT not between", value1, value2, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("START_DATE like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("START_DATE not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("END_DATE like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("END_DATE not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("END_DATE not between", value1, value2, "endDate");
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

        public Criteria andLoanWayIsNull() {
            addCriterion("LOAN_WAY is null");
            return (Criteria) this;
        }

        public Criteria andLoanWayIsNotNull() {
            addCriterion("LOAN_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andLoanWayEqualTo(String value) {
            addCriterion("LOAN_WAY =", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotEqualTo(String value) {
            addCriterion("LOAN_WAY <>", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayGreaterThan(String value) {
            addCriterion("LOAN_WAY >", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_WAY >=", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLessThan(String value) {
            addCriterion("LOAN_WAY <", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLessThanOrEqualTo(String value) {
            addCriterion("LOAN_WAY <=", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayLike(String value) {
            addCriterion("LOAN_WAY like", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotLike(String value) {
            addCriterion("LOAN_WAY not like", value, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayIn(List<String> values) {
            addCriterion("LOAN_WAY in", values, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotIn(List<String> values) {
            addCriterion("LOAN_WAY not in", values, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayBetween(String value1, String value2) {
            addCriterion("LOAN_WAY between", value1, value2, "loanWay");
            return (Criteria) this;
        }

        public Criteria andLoanWayNotBetween(String value1, String value2) {
            addCriterion("LOAN_WAY not between", value1, value2, "loanWay");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitIsNull() {
            addCriterion("SLAVE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitIsNotNull() {
            addCriterion("SLAVE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitEqualTo(String value) {
            addCriterion("SLAVE_LIMIT =", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotEqualTo(String value) {
            addCriterion("SLAVE_LIMIT <>", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitGreaterThan(String value) {
            addCriterion("SLAVE_LIMIT >", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitGreaterThanOrEqualTo(String value) {
            addCriterion("SLAVE_LIMIT >=", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitLessThan(String value) {
            addCriterion("SLAVE_LIMIT <", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitLessThanOrEqualTo(String value) {
            addCriterion("SLAVE_LIMIT <=", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitLike(String value) {
            addCriterion("SLAVE_LIMIT like", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotLike(String value) {
            addCriterion("SLAVE_LIMIT not like", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitIn(List<String> values) {
            addCriterion("SLAVE_LIMIT in", values, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotIn(List<String> values) {
            addCriterion("SLAVE_LIMIT not in", values, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitBetween(String value1, String value2) {
            addCriterion("SLAVE_LIMIT between", value1, value2, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotBetween(String value1, String value2) {
            addCriterion("SLAVE_LIMIT not between", value1, value2, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andBailAmountIsNull() {
            addCriterion("BAIL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBailAmountIsNotNull() {
            addCriterion("BAIL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBailAmountEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT =", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <>", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountGreaterThan(BigDecimal value) {
            addCriterion("BAIL_AMOUNT >", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT >=", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountLessThan(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <=", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMOUNT in", values, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMOUNT not in", values, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMOUNT between", value1, value2, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMOUNT not between", value1, value2, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoIsNull() {
            addCriterion("BAIL_ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoIsNotNull() {
            addCriterion("BAIL_ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT_NO =", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoNotEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT_NO <>", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoGreaterThan(String value) {
            addCriterion("BAIL_ACCOUNT_NO >", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT_NO >=", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoLessThan(String value) {
            addCriterion("BAIL_ACCOUNT_NO <", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT_NO <=", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoLike(String value) {
            addCriterion("BAIL_ACCOUNT_NO like", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoNotLike(String value) {
            addCriterion("BAIL_ACCOUNT_NO not like", value, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoIn(List<String> values) {
            addCriterion("BAIL_ACCOUNT_NO in", values, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoNotIn(List<String> values) {
            addCriterion("BAIL_ACCOUNT_NO not in", values, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNT_NO between", value1, value2, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andBailAccountNoNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNT_NO not between", value1, value2, "bailAccountNo");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIsNull() {
            addCriterion("FIRST_BAIL_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIsNotNull() {
            addCriterion("FIRST_BAIL_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO =", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <>", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioGreaterThan(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO >", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO >=", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioLessThan(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <=", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIn(List<BigDecimal> values) {
            addCriterion("FIRST_BAIL_RATIO in", values, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotIn(List<BigDecimal> values) {
            addCriterion("FIRST_BAIL_RATIO not in", values, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIRST_BAIL_RATIO between", value1, value2, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIRST_BAIL_RATIO not between", value1, value2, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andRiskAmountIsNull() {
            addCriterion("RISK_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRiskAmountIsNotNull() {
            addCriterion("RISK_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAmountEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT =", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountNotEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT <>", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountGreaterThan(BigDecimal value) {
            addCriterion("RISK_AMOUNT >", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT >=", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountLessThan(BigDecimal value) {
            addCriterion("RISK_AMOUNT <", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMOUNT <=", value, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountIn(List<BigDecimal> values) {
            addCriterion("RISK_AMOUNT in", values, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountNotIn(List<BigDecimal> values) {
            addCriterion("RISK_AMOUNT not in", values, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMOUNT between", value1, value2, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andRiskAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMOUNT not between", value1, value2, "riskAmount");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("COST is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("COST is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("COST =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("COST <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("COST >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("COST <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("COST in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("COST not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtIsNull() {
            addCriterion("USED_CREDIT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtIsNotNull() {
            addCriterion("USED_CREDIT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtEqualTo(BigDecimal value) {
            addCriterion("USED_CREDIT_AMT =", value, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtNotEqualTo(BigDecimal value) {
            addCriterion("USED_CREDIT_AMT <>", value, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtGreaterThan(BigDecimal value) {
            addCriterion("USED_CREDIT_AMT >", value, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_CREDIT_AMT >=", value, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtLessThan(BigDecimal value) {
            addCriterion("USED_CREDIT_AMT <", value, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_CREDIT_AMT <=", value, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtIn(List<BigDecimal> values) {
            addCriterion("USED_CREDIT_AMT in", values, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtNotIn(List<BigDecimal> values) {
            addCriterion("USED_CREDIT_AMT not in", values, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_CREDIT_AMT between", value1, value2, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andUsedCreditAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_CREDIT_AMT not between", value1, value2, "usedCreditAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtIsNull() {
            addCriterion("TOTAL_MORT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtIsNotNull() {
            addCriterion("TOTAL_MORT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MORT_AMT =", value, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MORT_AMT <>", value, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_MORT_AMT >", value, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MORT_AMT >=", value, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtLessThan(BigDecimal value) {
            addCriterion("TOTAL_MORT_AMT <", value, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MORT_AMT <=", value, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtIn(List<BigDecimal> values) {
            addCriterion("TOTAL_MORT_AMT in", values, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_MORT_AMT not in", values, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_MORT_AMT between", value1, value2, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andTotalMortAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_MORT_AMT not between", value1, value2, "totalMortAmt");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoIsNull() {
            addCriterion("MORT_BAIL_ACCOUNTNO is null");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoIsNotNull() {
            addCriterion("MORT_BAIL_ACCOUNTNO is not null");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoEqualTo(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO =", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoNotEqualTo(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO <>", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoGreaterThan(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO >", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO >=", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoLessThan(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO <", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoLessThanOrEqualTo(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO <=", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoLike(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO like", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoNotLike(String value) {
            addCriterion("MORT_BAIL_ACCOUNTNO not like", value, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoIn(List<String> values) {
            addCriterion("MORT_BAIL_ACCOUNTNO in", values, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoNotIn(List<String> values) {
            addCriterion("MORT_BAIL_ACCOUNTNO not in", values, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoBetween(String value1, String value2) {
            addCriterion("MORT_BAIL_ACCOUNTNO between", value1, value2, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAccountnoNotBetween(String value1, String value2) {
            addCriterion("MORT_BAIL_ACCOUNTNO not between", value1, value2, "mortBailAccountno");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountIsNull() {
            addCriterion("MORT_BAIL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountIsNotNull() {
            addCriterion("MORT_BAIL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountEqualTo(BigDecimal value) {
            addCriterion("MORT_BAIL_AMOUNT =", value, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountNotEqualTo(BigDecimal value) {
            addCriterion("MORT_BAIL_AMOUNT <>", value, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountGreaterThan(BigDecimal value) {
            addCriterion("MORT_BAIL_AMOUNT >", value, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_BAIL_AMOUNT >=", value, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountLessThan(BigDecimal value) {
            addCriterion("MORT_BAIL_AMOUNT <", value, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_BAIL_AMOUNT <=", value, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountIn(List<BigDecimal> values) {
            addCriterion("MORT_BAIL_AMOUNT in", values, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountNotIn(List<BigDecimal> values) {
            addCriterion("MORT_BAIL_AMOUNT not in", values, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_BAIL_AMOUNT between", value1, value2, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andMortBailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_BAIL_AMOUNT not between", value1, value2, "mortBailAmount");
            return (Criteria) this;
        }

        public Criteria andBailRateIsNull() {
            addCriterion("BAIL_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBailRateIsNotNull() {
            addCriterion("BAIL_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBailRateEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE =", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE <>", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateGreaterThan(BigDecimal value) {
            addCriterion("BAIL_RATE >", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE >=", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateLessThan(BigDecimal value) {
            addCriterion("BAIL_RATE <", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_RATE <=", value, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateIn(List<BigDecimal> values) {
            addCriterion("BAIL_RATE in", values, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_RATE not in", values, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RATE between", value1, value2, "bailRate");
            return (Criteria) this;
        }

        public Criteria andBailRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_RATE not between", value1, value2, "bailRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtIsNull() {
            addCriterion("INSURANCE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtIsNotNull() {
            addCriterion("INSURANCE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_AMT =", value, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtNotEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_AMT <>", value, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtGreaterThan(BigDecimal value) {
            addCriterion("INSURANCE_AMT >", value, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_AMT >=", value, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtLessThan(BigDecimal value) {
            addCriterion("INSURANCE_AMT <", value, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSURANCE_AMT <=", value, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtIn(List<BigDecimal> values) {
            addCriterion("INSURANCE_AMT in", values, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtNotIn(List<BigDecimal> values) {
            addCriterion("INSURANCE_AMT not in", values, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSURANCE_AMT between", value1, value2, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSURANCE_AMT not between", value1, value2, "insuranceAmt");
            return (Criteria) this;
        }

        public Criteria andRationIsNull() {
            addCriterion("RATION is null");
            return (Criteria) this;
        }

        public Criteria andRationIsNotNull() {
            addCriterion("RATION is not null");
            return (Criteria) this;
        }

        public Criteria andRationEqualTo(BigDecimal value) {
            addCriterion("RATION =", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotEqualTo(BigDecimal value) {
            addCriterion("RATION <>", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThan(BigDecimal value) {
            addCriterion("RATION >", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION >=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThan(BigDecimal value) {
            addCriterion("RATION <", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION <=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationIn(List<BigDecimal> values) {
            addCriterion("RATION in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotIn(List<BigDecimal> values) {
            addCriterion("RATION not in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION between", value1, value2, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION not between", value1, value2, "ration");
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

        public Criteria andAuditRateIsNull() {
            addCriterion("AUDIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andAuditRateIsNotNull() {
            addCriterion("AUDIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andAuditRateEqualTo(BigDecimal value) {
            addCriterion("AUDIT_RATE =", value, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateNotEqualTo(BigDecimal value) {
            addCriterion("AUDIT_RATE <>", value, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateGreaterThan(BigDecimal value) {
            addCriterion("AUDIT_RATE >", value, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AUDIT_RATE >=", value, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateLessThan(BigDecimal value) {
            addCriterion("AUDIT_RATE <", value, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AUDIT_RATE <=", value, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateIn(List<BigDecimal> values) {
            addCriterion("AUDIT_RATE in", values, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateNotIn(List<BigDecimal> values) {
            addCriterion("AUDIT_RATE not in", values, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AUDIT_RATE between", value1, value2, "auditRate");
            return (Criteria) this;
        }

        public Criteria andAuditRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AUDIT_RATE not between", value1, value2, "auditRate");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
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

        public Criteria andDeliveryQuantityIsNull() {
            addCriterion("DELIVERY_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityIsNotNull() {
            addCriterion("DELIVERY_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY =", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityNotEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY <>", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityGreaterThan(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY >", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY >=", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityLessThan(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY <", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_QUANTITY <=", value, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_QUANTITY in", values, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityNotIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_QUANTITY not in", values, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_QUANTITY between", value1, value2, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_QUANTITY not between", value1, value2, "deliveryQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueIsNull() {
            addCriterion("DELIVERY_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueIsNotNull() {
            addCriterion("DELIVERY_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_VALUE =", value, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueNotEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_VALUE <>", value, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueGreaterThan(BigDecimal value) {
            addCriterion("DELIVERY_VALUE >", value, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_VALUE >=", value, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueLessThan(BigDecimal value) {
            addCriterion("DELIVERY_VALUE <", value, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELIVERY_VALUE <=", value, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_VALUE in", values, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueNotIn(List<BigDecimal> values) {
            addCriterion("DELIVERY_VALUE not in", values, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_VALUE between", value1, value2, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELIVERY_VALUE not between", value1, value2, "deliveryValue");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassIsNull() {
            addCriterion("DELIVERY_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassIsNotNull() {
            addCriterion("DELIVERY_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassEqualTo(String value) {
            addCriterion("DELIVERY_CLASS =", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassNotEqualTo(String value) {
            addCriterion("DELIVERY_CLASS <>", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassGreaterThan(String value) {
            addCriterion("DELIVERY_CLASS >", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_CLASS >=", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassLessThan(String value) {
            addCriterion("DELIVERY_CLASS <", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_CLASS <=", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassLike(String value) {
            addCriterion("DELIVERY_CLASS like", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassNotLike(String value) {
            addCriterion("DELIVERY_CLASS not like", value, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassIn(List<String> values) {
            addCriterion("DELIVERY_CLASS in", values, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassNotIn(List<String> values) {
            addCriterion("DELIVERY_CLASS not in", values, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassBetween(String value1, String value2) {
            addCriterion("DELIVERY_CLASS between", value1, value2, "deliveryClass");
            return (Criteria) this;
        }

        public Criteria andDeliveryClassNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_CLASS not between", value1, value2, "deliveryClass");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}