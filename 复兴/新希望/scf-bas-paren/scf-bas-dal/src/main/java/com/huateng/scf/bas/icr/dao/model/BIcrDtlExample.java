package com.huateng.scf.bas.icr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BIcrDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BIcrDtlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BIcrDtlExample(BIcrDtlExample example) {
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

        public Criteria andCreditNoIsNull() {
            addCriterion("CREDIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCreditNoIsNotNull() {
            addCriterion("CREDIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCreditNoEqualTo(String value) {
            addCriterion("CREDIT_NO =", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotEqualTo(String value) {
            addCriterion("CREDIT_NO <>", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoGreaterThan(String value) {
            addCriterion("CREDIT_NO >", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_NO >=", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLessThan(String value) {
            addCriterion("CREDIT_NO <", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_NO <=", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLike(String value) {
            addCriterion("CREDIT_NO like", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotLike(String value) {
            addCriterion("CREDIT_NO not like", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoIn(List<String> values) {
            addCriterion("CREDIT_NO in", values, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotIn(List<String> values) {
            addCriterion("CREDIT_NO not in", values, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoBetween(String value1, String value2) {
            addCriterion("CREDIT_NO between", value1, value2, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotBetween(String value1, String value2) {
            addCriterion("CREDIT_NO not between", value1, value2, "creditNo");
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

        public Criteria andTxtimeIsNull() {
            addCriterion("TXTIME is null");
            return (Criteria) this;
        }

        public Criteria andTxtimeIsNotNull() {
            addCriterion("TXTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTxtimeEqualTo(Date value) {
            addCriterion("TXTIME =", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotEqualTo(Date value) {
            addCriterion("TXTIME <>", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeGreaterThan(Date value) {
            addCriterion("TXTIME >", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TXTIME >=", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeLessThan(Date value) {
            addCriterion("TXTIME <", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeLessThanOrEqualTo(Date value) {
            addCriterion("TXTIME <=", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeIn(List<Date> values) {
            addCriterion("TXTIME in", values, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotIn(List<Date> values) {
            addCriterion("TXTIME not in", values, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeBetween(Date value1, Date value2) {
            addCriterion("TXTIME between", value1, value2, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotBetween(Date value1, Date value2) {
            addCriterion("TXTIME not between", value1, value2, "txtime");
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

        public Criteria andRelaTypeIsNull() {
            addCriterion("RELA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRelaTypeIsNotNull() {
            addCriterion("RELA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRelaTypeEqualTo(String value) {
            addCriterion("RELA_TYPE =", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotEqualTo(String value) {
            addCriterion("RELA_TYPE <>", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeGreaterThan(String value) {
            addCriterion("RELA_TYPE >", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_TYPE >=", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLessThan(String value) {
            addCriterion("RELA_TYPE <", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLessThanOrEqualTo(String value) {
            addCriterion("RELA_TYPE <=", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLike(String value) {
            addCriterion("RELA_TYPE like", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotLike(String value) {
            addCriterion("RELA_TYPE not like", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeIn(List<String> values) {
            addCriterion("RELA_TYPE in", values, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotIn(List<String> values) {
            addCriterion("RELA_TYPE not in", values, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeBetween(String value1, String value2) {
            addCriterion("RELA_TYPE between", value1, value2, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotBetween(String value1, String value2) {
            addCriterion("RELA_TYPE not between", value1, value2, "relaType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoIsNull() {
            addCriterion("BUSINESSNO is null");
            return (Criteria) this;
        }

        public Criteria andBusinessnoIsNotNull() {
            addCriterion("BUSINESSNO is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessnoEqualTo(String value) {
            addCriterion("BUSINESSNO =", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotEqualTo(String value) {
            addCriterion("BUSINESSNO <>", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoGreaterThan(String value) {
            addCriterion("BUSINESSNO >", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSNO >=", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoLessThan(String value) {
            addCriterion("BUSINESSNO <", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSNO <=", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoLike(String value) {
            addCriterion("BUSINESSNO like", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotLike(String value) {
            addCriterion("BUSINESSNO not like", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoIn(List<String> values) {
            addCriterion("BUSINESSNO in", values, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotIn(List<String> values) {
            addCriterion("BUSINESSNO not in", values, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoBetween(String value1, String value2) {
            addCriterion("BUSINESSNO between", value1, value2, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotBetween(String value1, String value2) {
            addCriterion("BUSINESSNO not between", value1, value2, "businessno");
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

        public Criteria andApplyTypeIsNull() {
            addCriterion("APPLY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("APPLY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(String value) {
            addCriterion("APPLY_TYPE =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(String value) {
            addCriterion("APPLY_TYPE <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(String value) {
            addCriterion("APPLY_TYPE >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_TYPE >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(String value) {
            addCriterion("APPLY_TYPE <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(String value) {
            addCriterion("APPLY_TYPE <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLike(String value) {
            addCriterion("APPLY_TYPE like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotLike(String value) {
            addCriterion("APPLY_TYPE not like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<String> values) {
            addCriterion("APPLY_TYPE in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<String> values) {
            addCriterion("APPLY_TYPE not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(String value1, String value2) {
            addCriterion("APPLY_TYPE between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(String value1, String value2) {
            addCriterion("APPLY_TYPE not between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("OPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("OPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("OPER_TYPE =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("OPER_TYPE <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("OPER_TYPE >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("OPER_TYPE <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("OPER_TYPE like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("OPER_TYPE not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("OPER_TYPE in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("OPER_TYPE not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("OPER_TYPE between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("OPER_TYPE not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
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

        public Criteria andPreUsedAmountIsNull() {
            addCriterion("PRE_USED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountIsNotNull() {
            addCriterion("PRE_USED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT =", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountNotEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT <>", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountGreaterThan(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT >", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT >=", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountLessThan(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT <", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRE_USED_AMOUNT <=", value, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountIn(List<BigDecimal> values) {
            addCriterion("PRE_USED_AMOUNT in", values, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountNotIn(List<BigDecimal> values) {
            addCriterion("PRE_USED_AMOUNT not in", values, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRE_USED_AMOUNT between", value1, value2, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andPreUsedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRE_USED_AMOUNT not between", value1, value2, "preUsedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIsNull() {
            addCriterion("USED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIsNotNull() {
            addCriterion("USED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUsedAmountEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT =", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT <>", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountGreaterThan(BigDecimal value) {
            addCriterion("USED_AMOUNT >", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT >=", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountLessThan(BigDecimal value) {
            addCriterion("USED_AMOUNT <", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT <=", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIn(List<BigDecimal> values) {
            addCriterion("USED_AMOUNT in", values, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotIn(List<BigDecimal> values) {
            addCriterion("USED_AMOUNT not in", values, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_AMOUNT between", value1, value2, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_AMOUNT not between", value1, value2, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountIsNull() {
            addCriterion("FRZ_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFrzAmountIsNotNull() {
            addCriterion("FRZ_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFrzAmountEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT =", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountNotEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT <>", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountGreaterThan(BigDecimal value) {
            addCriterion("FRZ_AMOUNT >", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT >=", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountLessThan(BigDecimal value) {
            addCriterion("FRZ_AMOUNT <", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FRZ_AMOUNT <=", value, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountIn(List<BigDecimal> values) {
            addCriterion("FRZ_AMOUNT in", values, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountNotIn(List<BigDecimal> values) {
            addCriterion("FRZ_AMOUNT not in", values, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRZ_AMOUNT between", value1, value2, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andFrzAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRZ_AMOUNT not between", value1, value2, "frzAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountIsNull() {
            addCriterion("CREDIT_USABLE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountIsNotNull() {
            addCriterion("CREDIT_USABLE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT =", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT <>", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT >", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT >=", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountLessThan(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT <", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_USABLE_AMOUNT <=", value, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountIn(List<BigDecimal> values) {
            addCriterion("CREDIT_USABLE_AMOUNT in", values, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_USABLE_AMOUNT not in", values, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_USABLE_AMOUNT between", value1, value2, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCreditUsableAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_USABLE_AMOUNT not between", value1, value2, "creditUsableAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountIsNull() {
            addCriterion("COMMON_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCommonAmountIsNotNull() {
            addCriterion("COMMON_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCommonAmountEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMOUNT =", value, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountNotEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMOUNT <>", value, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountGreaterThan(BigDecimal value) {
            addCriterion("COMMON_AMOUNT >", value, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMOUNT >=", value, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountLessThan(BigDecimal value) {
            addCriterion("COMMON_AMOUNT <", value, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMON_AMOUNT <=", value, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountIn(List<BigDecimal> values) {
            addCriterion("COMMON_AMOUNT in", values, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountNotIn(List<BigDecimal> values) {
            addCriterion("COMMON_AMOUNT not in", values, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMON_AMOUNT between", value1, value2, "commonAmount");
            return (Criteria) this;
        }

        public Criteria andCommonAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMON_AMOUNT not between", value1, value2, "commonAmount");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME not between", value1, value2, "crtTime");
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

        public Criteria andLastUpdTlrcdIsNull() {
            addCriterion("LAST_UPD_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIsNotNull() {
            addCriterion("LAST_UPD_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD =", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <>", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThan(String value) {
            addCriterion("LAST_UPD_TLRCD >", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD >=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThan(String value) {
            addCriterion("LAST_UPD_TLRCD <", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRCD <=", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdLike(String value) {
            addCriterion("LAST_UPD_TLRCD like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotLike(String value) {
            addCriterion("LAST_UPD_TLRCD not like", value, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLRCD not in", values, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrcdNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRCD not between", value1, value2, "lastUpdTlrcd");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNull() {
            addCriterion("LAST_UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIsNotNull() {
            addCriterion("LAST_UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME =", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <>", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThan(Date value) {
            addCriterion("LAST_UPD_TIME >", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME >=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThan(Date value) {
            addCriterion("LAST_UPD_TIME <", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPD_TIME <=", value, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPD_TIME not in", values, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPD_TIME not between", value1, value2, "lastUpdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNull() {
            addCriterion("LAST_UPD_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIsNotNull() {
            addCriterion("LAST_UPD_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE =", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <>", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThan(String value) {
            addCriterion("LAST_UPD_BRCODE >", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE >=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThan(String value) {
            addCriterion("LAST_UPD_BRCODE <", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_BRCODE <=", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeLike(String value) {
            addCriterion("LAST_UPD_BRCODE like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotLike(String value) {
            addCriterion("LAST_UPD_BRCODE not like", value, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotIn(List<String> values) {
            addCriterion("LAST_UPD_BRCODE not in", values, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE between", value1, value2, "lastUpdBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdBrcodeNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_BRCODE not between", value1, value2, "lastUpdBrcode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}