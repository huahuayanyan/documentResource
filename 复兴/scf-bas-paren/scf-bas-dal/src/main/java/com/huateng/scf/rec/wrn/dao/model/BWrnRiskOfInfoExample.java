package com.huateng.scf.rec.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWrnRiskOfInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWrnRiskOfInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWrnRiskOfInfoExample(BWrnRiskOfInfoExample example) {
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

        public Criteria andWarnIdIsNull() {
            addCriterion("WARN_ID is null");
            return (Criteria) this;
        }

        public Criteria andWarnIdIsNotNull() {
            addCriterion("WARN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWarnIdEqualTo(BigDecimal value) {
            addCriterion("WARN_ID =", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotEqualTo(BigDecimal value) {
            addCriterion("WARN_ID <>", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThan(BigDecimal value) {
            addCriterion("WARN_ID >", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WARN_ID >=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThan(BigDecimal value) {
            addCriterion("WARN_ID <", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WARN_ID <=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdIn(List<BigDecimal> values) {
            addCriterion("WARN_ID in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotIn(List<BigDecimal> values) {
            addCriterion("WARN_ID not in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WARN_ID between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WARN_ID not between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andBussContnoIsNull() {
            addCriterion("BUSS_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andBussContnoIsNotNull() {
            addCriterion("BUSS_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andBussContnoEqualTo(String value) {
            addCriterion("BUSS_CONTNO =", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoNotEqualTo(String value) {
            addCriterion("BUSS_CONTNO <>", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoGreaterThan(String value) {
            addCriterion("BUSS_CONTNO >", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_CONTNO >=", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoLessThan(String value) {
            addCriterion("BUSS_CONTNO <", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoLessThanOrEqualTo(String value) {
            addCriterion("BUSS_CONTNO <=", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoLike(String value) {
            addCriterion("BUSS_CONTNO like", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoNotLike(String value) {
            addCriterion("BUSS_CONTNO not like", value, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoIn(List<String> values) {
            addCriterion("BUSS_CONTNO in", values, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoNotIn(List<String> values) {
            addCriterion("BUSS_CONTNO not in", values, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoBetween(String value1, String value2) {
            addCriterion("BUSS_CONTNO between", value1, value2, "bussContno");
            return (Criteria) this;
        }

        public Criteria andBussContnoNotBetween(String value1, String value2) {
            addCriterion("BUSS_CONTNO not between", value1, value2, "bussContno");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdIsNull() {
            addCriterion("SELLER_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdIsNotNull() {
            addCriterion("SELLER_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdEqualTo(String value) {
            addCriterion("SELLER_CUSTCD =", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotEqualTo(String value) {
            addCriterion("SELLER_CUSTCD <>", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdGreaterThan(String value) {
            addCriterion("SELLER_CUSTCD >", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_CUSTCD >=", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdLessThan(String value) {
            addCriterion("SELLER_CUSTCD <", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdLessThanOrEqualTo(String value) {
            addCriterion("SELLER_CUSTCD <=", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdLike(String value) {
            addCriterion("SELLER_CUSTCD like", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotLike(String value) {
            addCriterion("SELLER_CUSTCD not like", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdIn(List<String> values) {
            addCriterion("SELLER_CUSTCD in", values, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotIn(List<String> values) {
            addCriterion("SELLER_CUSTCD not in", values, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdBetween(String value1, String value2) {
            addCriterion("SELLER_CUSTCD between", value1, value2, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotBetween(String value1, String value2) {
            addCriterion("SELLER_CUSTCD not between", value1, value2, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerNameIsNull() {
            addCriterion("SELLER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSellerNameIsNotNull() {
            addCriterion("SELLER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNameEqualTo(String value) {
            addCriterion("SELLER_NAME =", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotEqualTo(String value) {
            addCriterion("SELLER_NAME <>", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThan(String value) {
            addCriterion("SELLER_NAME >", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_NAME >=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThan(String value) {
            addCriterion("SELLER_NAME <", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThanOrEqualTo(String value) {
            addCriterion("SELLER_NAME <=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLike(String value) {
            addCriterion("SELLER_NAME like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotLike(String value) {
            addCriterion("SELLER_NAME not like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameIn(List<String> values) {
            addCriterion("SELLER_NAME in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotIn(List<String> values) {
            addCriterion("SELLER_NAME not in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameBetween(String value1, String value2) {
            addCriterion("SELLER_NAME between", value1, value2, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotBetween(String value1, String value2) {
            addCriterion("SELLER_NAME not between", value1, value2, "sellerName");
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

        public Criteria andMastContcodeIsNull() {
            addCriterion("MAST_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIsNotNull() {
            addCriterion("MAST_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeEqualTo(String value) {
            addCriterion("MAST_CONTCODE =", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotEqualTo(String value) {
            addCriterion("MAST_CONTCODE <>", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThan(String value) {
            addCriterion("MAST_CONTCODE >", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE >=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThan(String value) {
            addCriterion("MAST_CONTCODE <", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE <=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLike(String value) {
            addCriterion("MAST_CONTCODE like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotLike(String value) {
            addCriterion("MAST_CONTCODE not like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIn(List<String> values) {
            addCriterion("MAST_CONTCODE in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotIn(List<String> values) {
            addCriterion("MAST_CONTCODE not in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE between", value1, value2, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE not between", value1, value2, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoIsNull() {
            addCriterion("LOAN_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoIsNotNull() {
            addCriterion("LOAN_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoEqualTo(String value) {
            addCriterion("LOAN_APPNO =", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotEqualTo(String value) {
            addCriterion("LOAN_APPNO <>", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoGreaterThan(String value) {
            addCriterion("LOAN_APPNO >", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_APPNO >=", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoLessThan(String value) {
            addCriterion("LOAN_APPNO <", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoLessThanOrEqualTo(String value) {
            addCriterion("LOAN_APPNO <=", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoLike(String value) {
            addCriterion("LOAN_APPNO like", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotLike(String value) {
            addCriterion("LOAN_APPNO not like", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoIn(List<String> values) {
            addCriterion("LOAN_APPNO in", values, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotIn(List<String> values) {
            addCriterion("LOAN_APPNO not in", values, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoBetween(String value1, String value2) {
            addCriterion("LOAN_APPNO between", value1, value2, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotBetween(String value1, String value2) {
            addCriterion("LOAN_APPNO not between", value1, value2, "loanAppno");
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

        public Criteria andLnciBalIsNull() {
            addCriterion("LNCI_BAL is null");
            return (Criteria) this;
        }

        public Criteria andLnciBalIsNotNull() {
            addCriterion("LNCI_BAL is not null");
            return (Criteria) this;
        }

        public Criteria andLnciBalEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL =", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL <>", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalGreaterThan(BigDecimal value) {
            addCriterion("LNCI_BAL >", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL >=", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalLessThan(BigDecimal value) {
            addCriterion("LNCI_BAL <", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL <=", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalIn(List<BigDecimal> values) {
            addCriterion("LNCI_BAL in", values, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotIn(List<BigDecimal> values) {
            addCriterion("LNCI_BAL not in", values, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_BAL between", value1, value2, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_BAL not between", value1, value2, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andDebtAmtIsNull() {
            addCriterion("DEBT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andDebtAmtIsNotNull() {
            addCriterion("DEBT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andDebtAmtEqualTo(BigDecimal value) {
            addCriterion("DEBT_AMT =", value, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtNotEqualTo(BigDecimal value) {
            addCriterion("DEBT_AMT <>", value, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtGreaterThan(BigDecimal value) {
            addCriterion("DEBT_AMT >", value, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBT_AMT >=", value, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtLessThan(BigDecimal value) {
            addCriterion("DEBT_AMT <", value, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBT_AMT <=", value, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtIn(List<BigDecimal> values) {
            addCriterion("DEBT_AMT in", values, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtNotIn(List<BigDecimal> values) {
            addCriterion("DEBT_AMT not in", values, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBT_AMT between", value1, value2, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBT_AMT not between", value1, value2, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIsNull() {
            addCriterion("LOAN_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIsNotNull() {
            addCriterion("LOAN_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPercentEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT =", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT <>", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentGreaterThan(BigDecimal value) {
            addCriterion("LOAN_PERCENT >", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT >=", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentLessThan(BigDecimal value) {
            addCriterion("LOAN_PERCENT <", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PERCENT <=", value, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentIn(List<BigDecimal> values) {
            addCriterion("LOAN_PERCENT in", values, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_PERCENT not in", values, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PERCENT between", value1, value2, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andLoanPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PERCENT not between", value1, value2, "loanPercent");
            return (Criteria) this;
        }

        public Criteria andBailAmtIsNull() {
            addCriterion("BAIL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBailAmtIsNotNull() {
            addCriterion("BAIL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBailAmtEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT =", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT <>", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtGreaterThan(BigDecimal value) {
            addCriterion("BAIL_AMT >", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT >=", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtLessThan(BigDecimal value) {
            addCriterion("BAIL_AMT <", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMT <=", value, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMT in", values, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMT not in", values, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMT between", value1, value2, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andBailAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMT not between", value1, value2, "bailAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtIsNull() {
            addCriterion("CASH_EQT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtIsNotNull() {
            addCriterion("CASH_EQT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT =", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtNotEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT <>", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtGreaterThan(BigDecimal value) {
            addCriterion("CASH_EQT_AMT >", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT >=", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtLessThan(BigDecimal value) {
            addCriterion("CASH_EQT_AMT <", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_EQT_AMT <=", value, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtIn(List<BigDecimal> values) {
            addCriterion("CASH_EQT_AMT in", values, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtNotIn(List<BigDecimal> values) {
            addCriterion("CASH_EQT_AMT not in", values, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_EQT_AMT between", value1, value2, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andCashEqtAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_EQT_AMT not between", value1, value2, "cashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNull() {
            addCriterion("RISK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNotNull() {
            addCriterion("RISK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT =", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <>", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("RISK_AMT >", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT >=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThan(BigDecimal value) {
            addCriterion("RISK_AMT <", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RISK_AMT <=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("RISK_AMT not in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RISK_AMT not between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtIsNull() {
            addCriterion("OVERFLOW_AMT is null");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtIsNotNull() {
            addCriterion("OVERFLOW_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtEqualTo(BigDecimal value) {
            addCriterion("OVERFLOW_AMT =", value, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtNotEqualTo(BigDecimal value) {
            addCriterion("OVERFLOW_AMT <>", value, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtGreaterThan(BigDecimal value) {
            addCriterion("OVERFLOW_AMT >", value, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERFLOW_AMT >=", value, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtLessThan(BigDecimal value) {
            addCriterion("OVERFLOW_AMT <", value, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERFLOW_AMT <=", value, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtIn(List<BigDecimal> values) {
            addCriterion("OVERFLOW_AMT in", values, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtNotIn(List<BigDecimal> values) {
            addCriterion("OVERFLOW_AMT not in", values, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERFLOW_AMT between", value1, value2, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andOverflowAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERFLOW_AMT not between", value1, value2, "overflowAmt");
            return (Criteria) this;
        }

        public Criteria andRatioIsNull() {
            addCriterion("RATIO is null");
            return (Criteria) this;
        }

        public Criteria andRatioIsNotNull() {
            addCriterion("RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andRatioEqualTo(BigDecimal value) {
            addCriterion("RATIO =", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotEqualTo(BigDecimal value) {
            addCriterion("RATIO <>", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThan(BigDecimal value) {
            addCriterion("RATIO >", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATIO >=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThan(BigDecimal value) {
            addCriterion("RATIO <", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATIO <=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioIn(List<BigDecimal> values) {
            addCriterion("RATIO in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotIn(List<BigDecimal> values) {
            addCriterion("RATIO not in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATIO between", value1, value2, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATIO not between", value1, value2, "ratio");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}