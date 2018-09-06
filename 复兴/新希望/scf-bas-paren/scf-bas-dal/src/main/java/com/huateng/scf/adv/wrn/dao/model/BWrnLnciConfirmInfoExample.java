package com.huateng.scf.adv.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWrnLnciConfirmInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWrnLnciConfirmInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWrnLnciConfirmInfoExample(BWrnLnciConfirmInfoExample example) {
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

        public Criteria andWarnIdEqualTo(String value) {
            addCriterion("WARN_ID =", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotEqualTo(String value) {
            addCriterion("WARN_ID <>", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThan(String value) {
            addCriterion("WARN_ID >", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_ID >=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThan(String value) {
            addCriterion("WARN_ID <", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThanOrEqualTo(String value) {
            addCriterion("WARN_ID <=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLike(String value) {
            addCriterion("WARN_ID like", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotLike(String value) {
            addCriterion("WARN_ID not like", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdIn(List<String> values) {
            addCriterion("WARN_ID in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotIn(List<String> values) {
            addCriterion("WARN_ID not in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdBetween(String value1, String value2) {
            addCriterion("WARN_ID between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotBetween(String value1, String value2) {
            addCriterion("WARN_ID not between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerIsNull() {
            addCriterion("CUSTCD_SELLER is null");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerIsNotNull() {
            addCriterion("CUSTCD_SELLER is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerEqualTo(String value) {
            addCriterion("CUSTCD_SELLER =", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerNotEqualTo(String value) {
            addCriterion("CUSTCD_SELLER <>", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerGreaterThan(String value) {
            addCriterion("CUSTCD_SELLER >", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD_SELLER >=", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerLessThan(String value) {
            addCriterion("CUSTCD_SELLER <", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD_SELLER <=", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerLike(String value) {
            addCriterion("CUSTCD_SELLER like", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerNotLike(String value) {
            addCriterion("CUSTCD_SELLER not like", value, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerIn(List<String> values) {
            addCriterion("CUSTCD_SELLER in", values, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerNotIn(List<String> values) {
            addCriterion("CUSTCD_SELLER not in", values, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerBetween(String value1, String value2) {
            addCriterion("CUSTCD_SELLER between", value1, value2, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdSellerNotBetween(String value1, String value2) {
            addCriterion("CUSTCD_SELLER not between", value1, value2, "custcdSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerIsNull() {
            addCriterion("CNAME_SELLER is null");
            return (Criteria) this;
        }

        public Criteria andCnameSellerIsNotNull() {
            addCriterion("CNAME_SELLER is not null");
            return (Criteria) this;
        }

        public Criteria andCnameSellerEqualTo(String value) {
            addCriterion("CNAME_SELLER =", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerNotEqualTo(String value) {
            addCriterion("CNAME_SELLER <>", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerGreaterThan(String value) {
            addCriterion("CNAME_SELLER >", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME_SELLER >=", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerLessThan(String value) {
            addCriterion("CNAME_SELLER <", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerLessThanOrEqualTo(String value) {
            addCriterion("CNAME_SELLER <=", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerLike(String value) {
            addCriterion("CNAME_SELLER like", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerNotLike(String value) {
            addCriterion("CNAME_SELLER not like", value, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerIn(List<String> values) {
            addCriterion("CNAME_SELLER in", values, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerNotIn(List<String> values) {
            addCriterion("CNAME_SELLER not in", values, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerBetween(String value1, String value2) {
            addCriterion("CNAME_SELLER between", value1, value2, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCnameSellerNotBetween(String value1, String value2) {
            addCriterion("CNAME_SELLER not between", value1, value2, "cnameSeller");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerIsNull() {
            addCriterion("CUSTCD_BUYER is null");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerIsNotNull() {
            addCriterion("CUSTCD_BUYER is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerEqualTo(String value) {
            addCriterion("CUSTCD_BUYER =", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerNotEqualTo(String value) {
            addCriterion("CUSTCD_BUYER <>", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerGreaterThan(String value) {
            addCriterion("CUSTCD_BUYER >", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD_BUYER >=", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerLessThan(String value) {
            addCriterion("CUSTCD_BUYER <", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD_BUYER <=", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerLike(String value) {
            addCriterion("CUSTCD_BUYER like", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerNotLike(String value) {
            addCriterion("CUSTCD_BUYER not like", value, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerIn(List<String> values) {
            addCriterion("CUSTCD_BUYER in", values, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerNotIn(List<String> values) {
            addCriterion("CUSTCD_BUYER not in", values, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerBetween(String value1, String value2) {
            addCriterion("CUSTCD_BUYER between", value1, value2, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCustcdBuyerNotBetween(String value1, String value2) {
            addCriterion("CUSTCD_BUYER not between", value1, value2, "custcdBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerIsNull() {
            addCriterion("CNAME_BUYER is null");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerIsNotNull() {
            addCriterion("CNAME_BUYER is not null");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerEqualTo(String value) {
            addCriterion("CNAME_BUYER =", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerNotEqualTo(String value) {
            addCriterion("CNAME_BUYER <>", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerGreaterThan(String value) {
            addCriterion("CNAME_BUYER >", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME_BUYER >=", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerLessThan(String value) {
            addCriterion("CNAME_BUYER <", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerLessThanOrEqualTo(String value) {
            addCriterion("CNAME_BUYER <=", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerLike(String value) {
            addCriterion("CNAME_BUYER like", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerNotLike(String value) {
            addCriterion("CNAME_BUYER not like", value, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerIn(List<String> values) {
            addCriterion("CNAME_BUYER in", values, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerNotIn(List<String> values) {
            addCriterion("CNAME_BUYER not in", values, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerBetween(String value1, String value2) {
            addCriterion("CNAME_BUYER between", value1, value2, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andCnameBuyerNotBetween(String value1, String value2) {
            addCriterion("CNAME_BUYER not between", value1, value2, "cnameBuyer");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIsNull() {
            addCriterion("PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIsNotNull() {
            addCriterion("PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoEqualTo(String value) {
            addCriterion("PROTOCOL_NO =", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotEqualTo(String value) {
            addCriterion("PROTOCOL_NO <>", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThan(String value) {
            addCriterion("PROTOCOL_NO >", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO >=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThan(String value) {
            addCriterion("PROTOCOL_NO <", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO <=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLike(String value) {
            addCriterion("PROTOCOL_NO like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotLike(String value) {
            addCriterion("PROTOCOL_NO not like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIn(List<String> values) {
            addCriterion("PROTOCOL_NO in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotIn(List<String> values) {
            addCriterion("PROTOCOL_NO not in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO between", value1, value2, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO not between", value1, value2, "protocolNo");
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

        public Criteria andLoanAmtIsNull() {
            addCriterion("LOAN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNotNull() {
            addCriterion("LOAN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT =", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT <>", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThan(BigDecimal value) {
            addCriterion("LOAN_AMT >", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT >=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThan(BigDecimal value) {
            addCriterion("LOAN_AMT <", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMT <=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMT in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMT not in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMT between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMT not between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanDateIsNull() {
            addCriterion("LOAN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLoanDateIsNotNull() {
            addCriterion("LOAN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDateEqualTo(String value) {
            addCriterion("LOAN_DATE =", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateNotEqualTo(String value) {
            addCriterion("LOAN_DATE <>", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateGreaterThan(String value) {
            addCriterion("LOAN_DATE >", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_DATE >=", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateLessThan(String value) {
            addCriterion("LOAN_DATE <", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateLessThanOrEqualTo(String value) {
            addCriterion("LOAN_DATE <=", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateLike(String value) {
            addCriterion("LOAN_DATE like", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateNotLike(String value) {
            addCriterion("LOAN_DATE not like", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateIn(List<String> values) {
            addCriterion("LOAN_DATE in", values, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateNotIn(List<String> values) {
            addCriterion("LOAN_DATE not in", values, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateBetween(String value1, String value2) {
            addCriterion("LOAN_DATE between", value1, value2, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateNotBetween(String value1, String value2) {
            addCriterion("LOAN_DATE not between", value1, value2, "loanDate");
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

        public Criteria andConfirmStausIsNull() {
            addCriterion("CONFIRM_STAUS is null");
            return (Criteria) this;
        }

        public Criteria andConfirmStausIsNotNull() {
            addCriterion("CONFIRM_STAUS is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmStausEqualTo(String value) {
            addCriterion("CONFIRM_STAUS =", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausNotEqualTo(String value) {
            addCriterion("CONFIRM_STAUS <>", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausGreaterThan(String value) {
            addCriterion("CONFIRM_STAUS >", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_STAUS >=", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausLessThan(String value) {
            addCriterion("CONFIRM_STAUS <", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_STAUS <=", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausLike(String value) {
            addCriterion("CONFIRM_STAUS like", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausNotLike(String value) {
            addCriterion("CONFIRM_STAUS not like", value, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausIn(List<String> values) {
            addCriterion("CONFIRM_STAUS in", values, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausNotIn(List<String> values) {
            addCriterion("CONFIRM_STAUS not in", values, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausBetween(String value1, String value2) {
            addCriterion("CONFIRM_STAUS between", value1, value2, "confirmStaus");
            return (Criteria) this;
        }

        public Criteria andConfirmStausNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_STAUS not between", value1, value2, "confirmStaus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}