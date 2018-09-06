package com.huateng.scf.rec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RBcpAppliBussDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RBcpAppliBussDtlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RBcpAppliBussDtlExample(RBcpAppliBussDtlExample example) {
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

        public Criteria andDebtIdIsNull() {
            addCriterion("DEBT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDebtIdIsNotNull() {
            addCriterion("DEBT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDebtIdEqualTo(String value) {
            addCriterion("DEBT_ID =", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotEqualTo(String value) {
            addCriterion("DEBT_ID <>", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdGreaterThan(String value) {
            addCriterion("DEBT_ID >", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEBT_ID >=", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdLessThan(String value) {
            addCriterion("DEBT_ID <", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdLessThanOrEqualTo(String value) {
            addCriterion("DEBT_ID <=", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdLike(String value) {
            addCriterion("DEBT_ID like", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotLike(String value) {
            addCriterion("DEBT_ID not like", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdIn(List<String> values) {
            addCriterion("DEBT_ID in", values, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotIn(List<String> values) {
            addCriterion("DEBT_ID not in", values, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdBetween(String value1, String value2) {
            addCriterion("DEBT_ID between", value1, value2, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotBetween(String value1, String value2) {
            addCriterion("DEBT_ID not between", value1, value2, "debtId");
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

        public Criteria andCustcdSallerIsNull() {
            addCriterion("CUSTCD_SALLER is null");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerIsNotNull() {
            addCriterion("CUSTCD_SALLER is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerEqualTo(String value) {
            addCriterion("CUSTCD_SALLER =", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerNotEqualTo(String value) {
            addCriterion("CUSTCD_SALLER <>", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerGreaterThan(String value) {
            addCriterion("CUSTCD_SALLER >", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD_SALLER >=", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerLessThan(String value) {
            addCriterion("CUSTCD_SALLER <", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD_SALLER <=", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerLike(String value) {
            addCriterion("CUSTCD_SALLER like", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerNotLike(String value) {
            addCriterion("CUSTCD_SALLER not like", value, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerIn(List<String> values) {
            addCriterion("CUSTCD_SALLER in", values, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerNotIn(List<String> values) {
            addCriterion("CUSTCD_SALLER not in", values, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerBetween(String value1, String value2) {
            addCriterion("CUSTCD_SALLER between", value1, value2, "custcdSaller");
            return (Criteria) this;
        }

        public Criteria andCustcdSallerNotBetween(String value1, String value2) {
            addCriterion("CUSTCD_SALLER not between", value1, value2, "custcdSaller");
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

        public Criteria andInsertDateIsNull() {
            addCriterion("INSERT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNotNull() {
            addCriterion("INSERT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDateEqualTo(String value) {
            addCriterion("INSERT_DATE =", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotEqualTo(String value) {
            addCriterion("INSERT_DATE <>", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThan(String value) {
            addCriterion("INSERT_DATE >", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThanOrEqualTo(String value) {
            addCriterion("INSERT_DATE >=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThan(String value) {
            addCriterion("INSERT_DATE <", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThanOrEqualTo(String value) {
            addCriterion("INSERT_DATE <=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLike(String value) {
            addCriterion("INSERT_DATE like", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotLike(String value) {
            addCriterion("INSERT_DATE not like", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateIn(List<String> values) {
            addCriterion("INSERT_DATE in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotIn(List<String> values) {
            addCriterion("INSERT_DATE not in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateBetween(String value1, String value2) {
            addCriterion("INSERT_DATE between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotBetween(String value1, String value2) {
            addCriterion("INSERT_DATE not between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andAgingIsNull() {
            addCriterion("AGING is null");
            return (Criteria) this;
        }

        public Criteria andAgingIsNotNull() {
            addCriterion("AGING is not null");
            return (Criteria) this;
        }

        public Criteria andAgingEqualTo(String value) {
            addCriterion("AGING =", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingNotEqualTo(String value) {
            addCriterion("AGING <>", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingGreaterThan(String value) {
            addCriterion("AGING >", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingGreaterThanOrEqualTo(String value) {
            addCriterion("AGING >=", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingLessThan(String value) {
            addCriterion("AGING <", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingLessThanOrEqualTo(String value) {
            addCriterion("AGING <=", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingLike(String value) {
            addCriterion("AGING like", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingNotLike(String value) {
            addCriterion("AGING not like", value, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingIn(List<String> values) {
            addCriterion("AGING in", values, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingNotIn(List<String> values) {
            addCriterion("AGING not in", values, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingBetween(String value1, String value2) {
            addCriterion("AGING between", value1, value2, "aging");
            return (Criteria) this;
        }

        public Criteria andAgingNotBetween(String value1, String value2) {
            addCriterion("AGING not between", value1, value2, "aging");
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

        public Criteria andBillsNoIsNull() {
            addCriterion("BILLS_NO is null");
            return (Criteria) this;
        }

        public Criteria andBillsNoIsNotNull() {
            addCriterion("BILLS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBillsNoEqualTo(String value) {
            addCriterion("BILLS_NO =", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoNotEqualTo(String value) {
            addCriterion("BILLS_NO <>", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoGreaterThan(String value) {
            addCriterion("BILLS_NO >", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoGreaterThanOrEqualTo(String value) {
            addCriterion("BILLS_NO >=", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoLessThan(String value) {
            addCriterion("BILLS_NO <", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoLessThanOrEqualTo(String value) {
            addCriterion("BILLS_NO <=", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoLike(String value) {
            addCriterion("BILLS_NO like", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoNotLike(String value) {
            addCriterion("BILLS_NO not like", value, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoIn(List<String> values) {
            addCriterion("BILLS_NO in", values, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoNotIn(List<String> values) {
            addCriterion("BILLS_NO not in", values, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoBetween(String value1, String value2) {
            addCriterion("BILLS_NO between", value1, value2, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsNoNotBetween(String value1, String value2) {
            addCriterion("BILLS_NO not between", value1, value2, "billsNo");
            return (Criteria) this;
        }

        public Criteria andBillsTypeIsNull() {
            addCriterion("BILLS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBillsTypeIsNotNull() {
            addCriterion("BILLS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBillsTypeEqualTo(String value) {
            addCriterion("BILLS_TYPE =", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotEqualTo(String value) {
            addCriterion("BILLS_TYPE <>", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeGreaterThan(String value) {
            addCriterion("BILLS_TYPE >", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BILLS_TYPE >=", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeLessThan(String value) {
            addCriterion("BILLS_TYPE <", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeLessThanOrEqualTo(String value) {
            addCriterion("BILLS_TYPE <=", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeLike(String value) {
            addCriterion("BILLS_TYPE like", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotLike(String value) {
            addCriterion("BILLS_TYPE not like", value, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeIn(List<String> values) {
            addCriterion("BILLS_TYPE in", values, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotIn(List<String> values) {
            addCriterion("BILLS_TYPE not in", values, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeBetween(String value1, String value2) {
            addCriterion("BILLS_TYPE between", value1, value2, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsTypeNotBetween(String value1, String value2) {
            addCriterion("BILLS_TYPE not between", value1, value2, "billsType");
            return (Criteria) this;
        }

        public Criteria andBillsDateIsNull() {
            addCriterion("BILLS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillsDateIsNotNull() {
            addCriterion("BILLS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillsDateEqualTo(String value) {
            addCriterion("BILLS_DATE =", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateNotEqualTo(String value) {
            addCriterion("BILLS_DATE <>", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateGreaterThan(String value) {
            addCriterion("BILLS_DATE >", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateGreaterThanOrEqualTo(String value) {
            addCriterion("BILLS_DATE >=", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateLessThan(String value) {
            addCriterion("BILLS_DATE <", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateLessThanOrEqualTo(String value) {
            addCriterion("BILLS_DATE <=", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateLike(String value) {
            addCriterion("BILLS_DATE like", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateNotLike(String value) {
            addCriterion("BILLS_DATE not like", value, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateIn(List<String> values) {
            addCriterion("BILLS_DATE in", values, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateNotIn(List<String> values) {
            addCriterion("BILLS_DATE not in", values, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateBetween(String value1, String value2) {
            addCriterion("BILLS_DATE between", value1, value2, "billsDate");
            return (Criteria) this;
        }

        public Criteria andBillsDateNotBetween(String value1, String value2) {
            addCriterion("BILLS_DATE not between", value1, value2, "billsDate");
            return (Criteria) this;
        }

        public Criteria andDebtEndIsNull() {
            addCriterion("DEBT_END is null");
            return (Criteria) this;
        }

        public Criteria andDebtEndIsNotNull() {
            addCriterion("DEBT_END is not null");
            return (Criteria) this;
        }

        public Criteria andDebtEndEqualTo(String value) {
            addCriterion("DEBT_END =", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndNotEqualTo(String value) {
            addCriterion("DEBT_END <>", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndGreaterThan(String value) {
            addCriterion("DEBT_END >", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndGreaterThanOrEqualTo(String value) {
            addCriterion("DEBT_END >=", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndLessThan(String value) {
            addCriterion("DEBT_END <", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndLessThanOrEqualTo(String value) {
            addCriterion("DEBT_END <=", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndLike(String value) {
            addCriterion("DEBT_END like", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndNotLike(String value) {
            addCriterion("DEBT_END not like", value, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndIn(List<String> values) {
            addCriterion("DEBT_END in", values, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndNotIn(List<String> values) {
            addCriterion("DEBT_END not in", values, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndBetween(String value1, String value2) {
            addCriterion("DEBT_END between", value1, value2, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andDebtEndNotBetween(String value1, String value2) {
            addCriterion("DEBT_END not between", value1, value2, "debtEnd");
            return (Criteria) this;
        }

        public Criteria andBillsAmountIsNull() {
            addCriterion("BILLS_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBillsAmountIsNotNull() {
            addCriterion("BILLS_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBillsAmountEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT =", value, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountNotEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT <>", value, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountGreaterThan(BigDecimal value) {
            addCriterion("BILLS_AMOUNT >", value, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT >=", value, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountLessThan(BigDecimal value) {
            addCriterion("BILLS_AMOUNT <", value, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT <=", value, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountIn(List<BigDecimal> values) {
            addCriterion("BILLS_AMOUNT in", values, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountNotIn(List<BigDecimal> values) {
            addCriterion("BILLS_AMOUNT not in", values, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_AMOUNT between", value1, value2, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_AMOUNT not between", value1, value2, "billsAmount");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewIsNull() {
            addCriterion("BILLS_AMOUNT_VIEW is null");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewIsNotNull() {
            addCriterion("BILLS_AMOUNT_VIEW is not null");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT_VIEW =", value, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewNotEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT_VIEW <>", value, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewGreaterThan(BigDecimal value) {
            addCriterion("BILLS_AMOUNT_VIEW >", value, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT_VIEW >=", value, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewLessThan(BigDecimal value) {
            addCriterion("BILLS_AMOUNT_VIEW <", value, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_AMOUNT_VIEW <=", value, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewIn(List<BigDecimal> values) {
            addCriterion("BILLS_AMOUNT_VIEW in", values, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewNotIn(List<BigDecimal> values) {
            addCriterion("BILLS_AMOUNT_VIEW not in", values, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_AMOUNT_VIEW between", value1, value2, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andBillsAmountViewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_AMOUNT_VIEW not between", value1, value2, "billsAmountView");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountIsNull() {
            addCriterion("REMAINING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountIsNotNull() {
            addCriterion("REMAINING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("REMAINING_AMOUNT =", value, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("REMAINING_AMOUNT <>", value, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("REMAINING_AMOUNT >", value, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMAINING_AMOUNT >=", value, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountLessThan(BigDecimal value) {
            addCriterion("REMAINING_AMOUNT <", value, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMAINING_AMOUNT <=", value, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountIn(List<BigDecimal> values) {
            addCriterion("REMAINING_AMOUNT in", values, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountNotIn(List<BigDecimal> values) {
            addCriterion("REMAINING_AMOUNT not in", values, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMAINING_AMOUNT between", value1, value2, "remainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMAINING_AMOUNT not between", value1, value2, "remainingAmount");
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

        public Criteria andLoanAmountIsNull() {
            addCriterion("LOAN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNotNull() {
            addCriterion("LOAN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT =", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT <>", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThan(BigDecimal value) {
            addCriterion("LOAN_AMOUNT >", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT >=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThan(BigDecimal value) {
            addCriterion("LOAN_AMOUNT <", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT <=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMOUNT in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMOUNT not in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMOUNT between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMOUNT not between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNull() {
            addCriterion("PURCHASE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNotNull() {
            addCriterion("PURCHASE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateEqualTo(String value) {
            addCriterion("PURCHASE_DATE =", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotEqualTo(String value) {
            addCriterion("PURCHASE_DATE <>", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThan(String value) {
            addCriterion("PURCHASE_DATE >", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThanOrEqualTo(String value) {
            addCriterion("PURCHASE_DATE >=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThan(String value) {
            addCriterion("PURCHASE_DATE <", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThanOrEqualTo(String value) {
            addCriterion("PURCHASE_DATE <=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLike(String value) {
            addCriterion("PURCHASE_DATE like", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotLike(String value) {
            addCriterion("PURCHASE_DATE not like", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIn(List<String> values) {
            addCriterion("PURCHASE_DATE in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotIn(List<String> values) {
            addCriterion("PURCHASE_DATE not in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateBetween(String value1, String value2) {
            addCriterion("PURCHASE_DATE between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotBetween(String value1, String value2) {
            addCriterion("PURCHASE_DATE not between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountIsNull() {
            addCriterion("LOAN_REMAINING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountIsNotNull() {
            addCriterion("LOAN_REMAINING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("LOAN_REMAINING_AMOUNT =", value, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_REMAINING_AMOUNT <>", value, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("LOAN_REMAINING_AMOUNT >", value, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_REMAINING_AMOUNT >=", value, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountLessThan(BigDecimal value) {
            addCriterion("LOAN_REMAINING_AMOUNT <", value, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_REMAINING_AMOUNT <=", value, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountIn(List<BigDecimal> values) {
            addCriterion("LOAN_REMAINING_AMOUNT in", values, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_REMAINING_AMOUNT not in", values, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_REMAINING_AMOUNT between", value1, value2, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_REMAINING_AMOUNT not between", value1, value2, "loanRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountIsNull() {
            addCriterion("REMAINING_USEABLE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountIsNotNull() {
            addCriterion("REMAINING_USEABLE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountEqualTo(BigDecimal value) {
            addCriterion("REMAINING_USEABLE_AMOUNT =", value, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountNotEqualTo(BigDecimal value) {
            addCriterion("REMAINING_USEABLE_AMOUNT <>", value, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountGreaterThan(BigDecimal value) {
            addCriterion("REMAINING_USEABLE_AMOUNT >", value, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMAINING_USEABLE_AMOUNT >=", value, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountLessThan(BigDecimal value) {
            addCriterion("REMAINING_USEABLE_AMOUNT <", value, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMAINING_USEABLE_AMOUNT <=", value, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountIn(List<BigDecimal> values) {
            addCriterion("REMAINING_USEABLE_AMOUNT in", values, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountNotIn(List<BigDecimal> values) {
            addCriterion("REMAINING_USEABLE_AMOUNT not in", values, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMAINING_USEABLE_AMOUNT between", value1, value2, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingUseableAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMAINING_USEABLE_AMOUNT not between", value1, value2, "remainingUseableAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountIsNull() {
            addCriterion("RATE_COLLECT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountIsNotNull() {
            addCriterion("RATE_COLLECT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountEqualTo(BigDecimal value) {
            addCriterion("RATE_COLLECT_AMOUNT =", value, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountNotEqualTo(BigDecimal value) {
            addCriterion("RATE_COLLECT_AMOUNT <>", value, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountGreaterThan(BigDecimal value) {
            addCriterion("RATE_COLLECT_AMOUNT >", value, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_COLLECT_AMOUNT >=", value, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountLessThan(BigDecimal value) {
            addCriterion("RATE_COLLECT_AMOUNT <", value, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_COLLECT_AMOUNT <=", value, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountIn(List<BigDecimal> values) {
            addCriterion("RATE_COLLECT_AMOUNT in", values, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountNotIn(List<BigDecimal> values) {
            addCriterion("RATE_COLLECT_AMOUNT not in", values, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_COLLECT_AMOUNT between", value1, value2, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andRateCollectAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_COLLECT_AMOUNT not between", value1, value2, "rateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountIsNull() {
            addCriterion("OWN_RATE_COLLECT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountIsNotNull() {
            addCriterion("OWN_RATE_COLLECT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountEqualTo(BigDecimal value) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT =", value, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountNotEqualTo(BigDecimal value) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT <>", value, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountGreaterThan(BigDecimal value) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT >", value, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT >=", value, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountLessThan(BigDecimal value) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT <", value, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT <=", value, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountIn(List<BigDecimal> values) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT in", values, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountNotIn(List<BigDecimal> values) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT not in", values, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT between", value1, value2, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andOwnRateCollectAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OWN_RATE_COLLECT_AMOUNT not between", value1, value2, "ownRateCollectAmount");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateIsNull() {
            addCriterion("LOAN_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateIsNotNull() {
            addCriterion("LOAN_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateEqualTo(String value) {
            addCriterion("LOAN_END_DATE =", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateNotEqualTo(String value) {
            addCriterion("LOAN_END_DATE <>", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateGreaterThan(String value) {
            addCriterion("LOAN_END_DATE >", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_END_DATE >=", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateLessThan(String value) {
            addCriterion("LOAN_END_DATE <", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateLessThanOrEqualTo(String value) {
            addCriterion("LOAN_END_DATE <=", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateLike(String value) {
            addCriterion("LOAN_END_DATE like", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateNotLike(String value) {
            addCriterion("LOAN_END_DATE not like", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateIn(List<String> values) {
            addCriterion("LOAN_END_DATE in", values, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateNotIn(List<String> values) {
            addCriterion("LOAN_END_DATE not in", values, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateBetween(String value1, String value2) {
            addCriterion("LOAN_END_DATE between", value1, value2, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateNotBetween(String value1, String value2) {
            addCriterion("LOAN_END_DATE not between", value1, value2, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andAssurePercentIsNull() {
            addCriterion("ASSURE_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andAssurePercentIsNotNull() {
            addCriterion("ASSURE_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andAssurePercentEqualTo(BigDecimal value) {
            addCriterion("ASSURE_PERCENT =", value, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentNotEqualTo(BigDecimal value) {
            addCriterion("ASSURE_PERCENT <>", value, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentGreaterThan(BigDecimal value) {
            addCriterion("ASSURE_PERCENT >", value, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSURE_PERCENT >=", value, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentLessThan(BigDecimal value) {
            addCriterion("ASSURE_PERCENT <", value, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSURE_PERCENT <=", value, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentIn(List<BigDecimal> values) {
            addCriterion("ASSURE_PERCENT in", values, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentNotIn(List<BigDecimal> values) {
            addCriterion("ASSURE_PERCENT not in", values, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSURE_PERCENT between", value1, value2, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSURE_PERCENT not between", value1, value2, "assurePercent");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateIsNull() {
            addCriterion("ASSURE_PAY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateIsNotNull() {
            addCriterion("ASSURE_PAY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateEqualTo(String value) {
            addCriterion("ASSURE_PAY_DATE =", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateNotEqualTo(String value) {
            addCriterion("ASSURE_PAY_DATE <>", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateGreaterThan(String value) {
            addCriterion("ASSURE_PAY_DATE >", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateGreaterThanOrEqualTo(String value) {
            addCriterion("ASSURE_PAY_DATE >=", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateLessThan(String value) {
            addCriterion("ASSURE_PAY_DATE <", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateLessThanOrEqualTo(String value) {
            addCriterion("ASSURE_PAY_DATE <=", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateLike(String value) {
            addCriterion("ASSURE_PAY_DATE like", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateNotLike(String value) {
            addCriterion("ASSURE_PAY_DATE not like", value, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateIn(List<String> values) {
            addCriterion("ASSURE_PAY_DATE in", values, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateNotIn(List<String> values) {
            addCriterion("ASSURE_PAY_DATE not in", values, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateBetween(String value1, String value2) {
            addCriterion("ASSURE_PAY_DATE between", value1, value2, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andAssurePayDateNotBetween(String value1, String value2) {
            addCriterion("ASSURE_PAY_DATE not between", value1, value2, "assurePayDate");
            return (Criteria) this;
        }

        public Criteria andRebateAmountIsNull() {
            addCriterion("REBATE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRebateAmountIsNotNull() {
            addCriterion("REBATE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRebateAmountEqualTo(BigDecimal value) {
            addCriterion("REBATE_AMOUNT =", value, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountNotEqualTo(BigDecimal value) {
            addCriterion("REBATE_AMOUNT <>", value, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountGreaterThan(BigDecimal value) {
            addCriterion("REBATE_AMOUNT >", value, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REBATE_AMOUNT >=", value, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountLessThan(BigDecimal value) {
            addCriterion("REBATE_AMOUNT <", value, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REBATE_AMOUNT <=", value, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountIn(List<BigDecimal> values) {
            addCriterion("REBATE_AMOUNT in", values, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountNotIn(List<BigDecimal> values) {
            addCriterion("REBATE_AMOUNT not in", values, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REBATE_AMOUNT between", value1, value2, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andRebateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REBATE_AMOUNT not between", value1, value2, "rebateAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountIsNull() {
            addCriterion("BUY_BACK_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountIsNotNull() {
            addCriterion("BUY_BACK_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountEqualTo(BigDecimal value) {
            addCriterion("BUY_BACK_AMOUNT =", value, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountNotEqualTo(BigDecimal value) {
            addCriterion("BUY_BACK_AMOUNT <>", value, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountGreaterThan(BigDecimal value) {
            addCriterion("BUY_BACK_AMOUNT >", value, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_BACK_AMOUNT >=", value, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountLessThan(BigDecimal value) {
            addCriterion("BUY_BACK_AMOUNT <", value, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_BACK_AMOUNT <=", value, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountIn(List<BigDecimal> values) {
            addCriterion("BUY_BACK_AMOUNT in", values, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountNotIn(List<BigDecimal> values) {
            addCriterion("BUY_BACK_AMOUNT not in", values, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_BACK_AMOUNT between", value1, value2, "buyBackAmount");
            return (Criteria) this;
        }

        public Criteria andBuyBackAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_BACK_AMOUNT not between", value1, value2, "buyBackAmount");
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

        public Criteria andRemoveAmountIsNull() {
            addCriterion("REMOVE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountIsNotNull() {
            addCriterion("REMOVE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountEqualTo(BigDecimal value) {
            addCriterion("REMOVE_AMOUNT =", value, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountNotEqualTo(BigDecimal value) {
            addCriterion("REMOVE_AMOUNT <>", value, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountGreaterThan(BigDecimal value) {
            addCriterion("REMOVE_AMOUNT >", value, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMOVE_AMOUNT >=", value, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountLessThan(BigDecimal value) {
            addCriterion("REMOVE_AMOUNT <", value, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMOVE_AMOUNT <=", value, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountIn(List<BigDecimal> values) {
            addCriterion("REMOVE_AMOUNT in", values, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountNotIn(List<BigDecimal> values) {
            addCriterion("REMOVE_AMOUNT not in", values, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMOVE_AMOUNT between", value1, value2, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMOVE_AMOUNT not between", value1, value2, "removeAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountIsNull() {
            addCriterion("CASH_REMAINING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountIsNotNull() {
            addCriterion("CASH_REMAINING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("CASH_REMAINING_AMOUNT =", value, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("CASH_REMAINING_AMOUNT <>", value, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("CASH_REMAINING_AMOUNT >", value, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_REMAINING_AMOUNT >=", value, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountLessThan(BigDecimal value) {
            addCriterion("CASH_REMAINING_AMOUNT <", value, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_REMAINING_AMOUNT <=", value, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountIn(List<BigDecimal> values) {
            addCriterion("CASH_REMAINING_AMOUNT in", values, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountNotIn(List<BigDecimal> values) {
            addCriterion("CASH_REMAINING_AMOUNT not in", values, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_REMAINING_AMOUNT between", value1, value2, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andCashRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_REMAINING_AMOUNT not between", value1, value2, "cashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andFlawFlagIsNull() {
            addCriterion("FLAW_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlawFlagIsNotNull() {
            addCriterion("FLAW_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlawFlagEqualTo(String value) {
            addCriterion("FLAW_FLAG =", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagNotEqualTo(String value) {
            addCriterion("FLAW_FLAG <>", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagGreaterThan(String value) {
            addCriterion("FLAW_FLAG >", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAW_FLAG >=", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagLessThan(String value) {
            addCriterion("FLAW_FLAG <", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAW_FLAG <=", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagLike(String value) {
            addCriterion("FLAW_FLAG like", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagNotLike(String value) {
            addCriterion("FLAW_FLAG not like", value, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagIn(List<String> values) {
            addCriterion("FLAW_FLAG in", values, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagNotIn(List<String> values) {
            addCriterion("FLAW_FLAG not in", values, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagBetween(String value1, String value2) {
            addCriterion("FLAW_FLAG between", value1, value2, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawFlagNotBetween(String value1, String value2) {
            addCriterion("FLAW_FLAG not between", value1, value2, "flawFlag");
            return (Criteria) this;
        }

        public Criteria andFlawReasonIsNull() {
            addCriterion("FLAW_REASON is null");
            return (Criteria) this;
        }

        public Criteria andFlawReasonIsNotNull() {
            addCriterion("FLAW_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andFlawReasonEqualTo(String value) {
            addCriterion("FLAW_REASON =", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonNotEqualTo(String value) {
            addCriterion("FLAW_REASON <>", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonGreaterThan(String value) {
            addCriterion("FLAW_REASON >", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonGreaterThanOrEqualTo(String value) {
            addCriterion("FLAW_REASON >=", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonLessThan(String value) {
            addCriterion("FLAW_REASON <", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonLessThanOrEqualTo(String value) {
            addCriterion("FLAW_REASON <=", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonLike(String value) {
            addCriterion("FLAW_REASON like", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonNotLike(String value) {
            addCriterion("FLAW_REASON not like", value, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonIn(List<String> values) {
            addCriterion("FLAW_REASON in", values, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonNotIn(List<String> values) {
            addCriterion("FLAW_REASON not in", values, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonBetween(String value1, String value2) {
            addCriterion("FLAW_REASON between", value1, value2, "flawReason");
            return (Criteria) this;
        }

        public Criteria andFlawReasonNotBetween(String value1, String value2) {
            addCriterion("FLAW_REASON not between", value1, value2, "flawReason");
            return (Criteria) this;
        }

        public Criteria andIssueFlagIsNull() {
            addCriterion("ISSUE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIssueFlagIsNotNull() {
            addCriterion("ISSUE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIssueFlagEqualTo(String value) {
            addCriterion("ISSUE_FLAG =", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagNotEqualTo(String value) {
            addCriterion("ISSUE_FLAG <>", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagGreaterThan(String value) {
            addCriterion("ISSUE_FLAG >", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ISSUE_FLAG >=", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagLessThan(String value) {
            addCriterion("ISSUE_FLAG <", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagLessThanOrEqualTo(String value) {
            addCriterion("ISSUE_FLAG <=", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagLike(String value) {
            addCriterion("ISSUE_FLAG like", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagNotLike(String value) {
            addCriterion("ISSUE_FLAG not like", value, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagIn(List<String> values) {
            addCriterion("ISSUE_FLAG in", values, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagNotIn(List<String> values) {
            addCriterion("ISSUE_FLAG not in", values, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagBetween(String value1, String value2) {
            addCriterion("ISSUE_FLAG between", value1, value2, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueFlagNotBetween(String value1, String value2) {
            addCriterion("ISSUE_FLAG not between", value1, value2, "issueFlag");
            return (Criteria) this;
        }

        public Criteria andIssueReasonIsNull() {
            addCriterion("ISSUE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andIssueReasonIsNotNull() {
            addCriterion("ISSUE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andIssueReasonEqualTo(String value) {
            addCriterion("ISSUE_REASON =", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonNotEqualTo(String value) {
            addCriterion("ISSUE_REASON <>", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonGreaterThan(String value) {
            addCriterion("ISSUE_REASON >", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ISSUE_REASON >=", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonLessThan(String value) {
            addCriterion("ISSUE_REASON <", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonLessThanOrEqualTo(String value) {
            addCriterion("ISSUE_REASON <=", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonLike(String value) {
            addCriterion("ISSUE_REASON like", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonNotLike(String value) {
            addCriterion("ISSUE_REASON not like", value, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonIn(List<String> values) {
            addCriterion("ISSUE_REASON in", values, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonNotIn(List<String> values) {
            addCriterion("ISSUE_REASON not in", values, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonBetween(String value1, String value2) {
            addCriterion("ISSUE_REASON between", value1, value2, "issueReason");
            return (Criteria) this;
        }

        public Criteria andIssueReasonNotBetween(String value1, String value2) {
            addCriterion("ISSUE_REASON not between", value1, value2, "issueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagIsNull() {
            addCriterion("OVERDUE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagIsNotNull() {
            addCriterion("OVERDUE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagEqualTo(String value) {
            addCriterion("OVERDUE_FLAG =", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagNotEqualTo(String value) {
            addCriterion("OVERDUE_FLAG <>", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagGreaterThan(String value) {
            addCriterion("OVERDUE_FLAG >", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagGreaterThanOrEqualTo(String value) {
            addCriterion("OVERDUE_FLAG >=", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagLessThan(String value) {
            addCriterion("OVERDUE_FLAG <", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagLessThanOrEqualTo(String value) {
            addCriterion("OVERDUE_FLAG <=", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagLike(String value) {
            addCriterion("OVERDUE_FLAG like", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagNotLike(String value) {
            addCriterion("OVERDUE_FLAG not like", value, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagIn(List<String> values) {
            addCriterion("OVERDUE_FLAG in", values, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagNotIn(List<String> values) {
            addCriterion("OVERDUE_FLAG not in", values, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagBetween(String value1, String value2) {
            addCriterion("OVERDUE_FLAG between", value1, value2, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueFlagNotBetween(String value1, String value2) {
            addCriterion("OVERDUE_FLAG not between", value1, value2, "overdueFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonIsNull() {
            addCriterion("OVERDUE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonIsNotNull() {
            addCriterion("OVERDUE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonEqualTo(String value) {
            addCriterion("OVERDUE_REASON =", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonNotEqualTo(String value) {
            addCriterion("OVERDUE_REASON <>", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonGreaterThan(String value) {
            addCriterion("OVERDUE_REASON >", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonGreaterThanOrEqualTo(String value) {
            addCriterion("OVERDUE_REASON >=", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonLessThan(String value) {
            addCriterion("OVERDUE_REASON <", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonLessThanOrEqualTo(String value) {
            addCriterion("OVERDUE_REASON <=", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonLike(String value) {
            addCriterion("OVERDUE_REASON like", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonNotLike(String value) {
            addCriterion("OVERDUE_REASON not like", value, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonIn(List<String> values) {
            addCriterion("OVERDUE_REASON in", values, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonNotIn(List<String> values) {
            addCriterion("OVERDUE_REASON not in", values, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonBetween(String value1, String value2) {
            addCriterion("OVERDUE_REASON between", value1, value2, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andOverdueReasonNotBetween(String value1, String value2) {
            addCriterion("OVERDUE_REASON not between", value1, value2, "overdueReason");
            return (Criteria) this;
        }

        public Criteria andBadFlagIsNull() {
            addCriterion("BAD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBadFlagIsNotNull() {
            addCriterion("BAD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBadFlagEqualTo(String value) {
            addCriterion("BAD_FLAG =", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagNotEqualTo(String value) {
            addCriterion("BAD_FLAG <>", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagGreaterThan(String value) {
            addCriterion("BAD_FLAG >", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BAD_FLAG >=", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagLessThan(String value) {
            addCriterion("BAD_FLAG <", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagLessThanOrEqualTo(String value) {
            addCriterion("BAD_FLAG <=", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagLike(String value) {
            addCriterion("BAD_FLAG like", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagNotLike(String value) {
            addCriterion("BAD_FLAG not like", value, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagIn(List<String> values) {
            addCriterion("BAD_FLAG in", values, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagNotIn(List<String> values) {
            addCriterion("BAD_FLAG not in", values, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagBetween(String value1, String value2) {
            addCriterion("BAD_FLAG between", value1, value2, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadFlagNotBetween(String value1, String value2) {
            addCriterion("BAD_FLAG not between", value1, value2, "badFlag");
            return (Criteria) this;
        }

        public Criteria andBadReasonIsNull() {
            addCriterion("BAD_REASON is null");
            return (Criteria) this;
        }

        public Criteria andBadReasonIsNotNull() {
            addCriterion("BAD_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andBadReasonEqualTo(String value) {
            addCriterion("BAD_REASON =", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonNotEqualTo(String value) {
            addCriterion("BAD_REASON <>", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonGreaterThan(String value) {
            addCriterion("BAD_REASON >", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonGreaterThanOrEqualTo(String value) {
            addCriterion("BAD_REASON >=", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonLessThan(String value) {
            addCriterion("BAD_REASON <", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonLessThanOrEqualTo(String value) {
            addCriterion("BAD_REASON <=", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonLike(String value) {
            addCriterion("BAD_REASON like", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonNotLike(String value) {
            addCriterion("BAD_REASON not like", value, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonIn(List<String> values) {
            addCriterion("BAD_REASON in", values, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonNotIn(List<String> values) {
            addCriterion("BAD_REASON not in", values, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonBetween(String value1, String value2) {
            addCriterion("BAD_REASON between", value1, value2, "badReason");
            return (Criteria) this;
        }

        public Criteria andBadReasonNotBetween(String value1, String value2) {
            addCriterion("BAD_REASON not between", value1, value2, "badReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonIsNull() {
            addCriterion("OTHER_REASON is null");
            return (Criteria) this;
        }

        public Criteria andOtherReasonIsNotNull() {
            addCriterion("OTHER_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andOtherReasonEqualTo(String value) {
            addCriterion("OTHER_REASON =", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotEqualTo(String value) {
            addCriterion("OTHER_REASON <>", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonGreaterThan(String value) {
            addCriterion("OTHER_REASON >", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_REASON >=", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonLessThan(String value) {
            addCriterion("OTHER_REASON <", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonLessThanOrEqualTo(String value) {
            addCriterion("OTHER_REASON <=", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonLike(String value) {
            addCriterion("OTHER_REASON like", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotLike(String value) {
            addCriterion("OTHER_REASON not like", value, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonIn(List<String> values) {
            addCriterion("OTHER_REASON in", values, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotIn(List<String> values) {
            addCriterion("OTHER_REASON not in", values, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonBetween(String value1, String value2) {
            addCriterion("OTHER_REASON between", value1, value2, "otherReason");
            return (Criteria) this;
        }

        public Criteria andOtherReasonNotBetween(String value1, String value2) {
            addCriterion("OTHER_REASON not between", value1, value2, "otherReason");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andPoolFlagIsNull() {
            addCriterion("POOL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPoolFlagIsNotNull() {
            addCriterion("POOL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPoolFlagEqualTo(String value) {
            addCriterion("POOL_FLAG =", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagNotEqualTo(String value) {
            addCriterion("POOL_FLAG <>", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagGreaterThan(String value) {
            addCriterion("POOL_FLAG >", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagGreaterThanOrEqualTo(String value) {
            addCriterion("POOL_FLAG >=", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagLessThan(String value) {
            addCriterion("POOL_FLAG <", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagLessThanOrEqualTo(String value) {
            addCriterion("POOL_FLAG <=", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagLike(String value) {
            addCriterion("POOL_FLAG like", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagNotLike(String value) {
            addCriterion("POOL_FLAG not like", value, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagIn(List<String> values) {
            addCriterion("POOL_FLAG in", values, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagNotIn(List<String> values) {
            addCriterion("POOL_FLAG not in", values, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagBetween(String value1, String value2) {
            addCriterion("POOL_FLAG between", value1, value2, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andPoolFlagNotBetween(String value1, String value2) {
            addCriterion("POOL_FLAG not between", value1, value2, "poolFlag");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIsNull() {
            addCriterion("OVERDUE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIsNotNull() {
            addCriterion("OVERDUE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT =", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT <>", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountGreaterThan(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT >", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT >=", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountLessThan(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT <", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT <=", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_AMOUNT in", values, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_AMOUNT not in", values, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_AMOUNT between", value1, value2, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_AMOUNT not between", value1, value2, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusIsNull() {
            addCriterion("PLEDGE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusIsNotNull() {
            addCriterion("PLEDGE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusEqualTo(String value) {
            addCriterion("PLEDGE_STATUS =", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusNotEqualTo(String value) {
            addCriterion("PLEDGE_STATUS <>", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusGreaterThan(String value) {
            addCriterion("PLEDGE_STATUS >", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PLEDGE_STATUS >=", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusLessThan(String value) {
            addCriterion("PLEDGE_STATUS <", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusLessThanOrEqualTo(String value) {
            addCriterion("PLEDGE_STATUS <=", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusLike(String value) {
            addCriterion("PLEDGE_STATUS like", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusNotLike(String value) {
            addCriterion("PLEDGE_STATUS not like", value, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusIn(List<String> values) {
            addCriterion("PLEDGE_STATUS in", values, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusNotIn(List<String> values) {
            addCriterion("PLEDGE_STATUS not in", values, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusBetween(String value1, String value2) {
            addCriterion("PLEDGE_STATUS between", value1, value2, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeStatusNotBetween(String value1, String value2) {
            addCriterion("PLEDGE_STATUS not between", value1, value2, "pledgeStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIsNull() {
            addCriterion("OVERDUE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIsNotNull() {
            addCriterion("OVERDUE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusEqualTo(String value) {
            addCriterion("OVERDUE_STATUS =", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotEqualTo(String value) {
            addCriterion("OVERDUE_STATUS <>", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusGreaterThan(String value) {
            addCriterion("OVERDUE_STATUS >", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusGreaterThanOrEqualTo(String value) {
            addCriterion("OVERDUE_STATUS >=", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLessThan(String value) {
            addCriterion("OVERDUE_STATUS <", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLessThanOrEqualTo(String value) {
            addCriterion("OVERDUE_STATUS <=", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLike(String value) {
            addCriterion("OVERDUE_STATUS like", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotLike(String value) {
            addCriterion("OVERDUE_STATUS not like", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIn(List<String> values) {
            addCriterion("OVERDUE_STATUS in", values, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotIn(List<String> values) {
            addCriterion("OVERDUE_STATUS not in", values, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusBetween(String value1, String value2) {
            addCriterion("OVERDUE_STATUS between", value1, value2, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotBetween(String value1, String value2) {
            addCriterion("OVERDUE_STATUS not between", value1, value2, "overdueStatus");
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

        public Criteria andReturnStatusIsNull() {
            addCriterion("RETURN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNotNull() {
            addCriterion("RETURN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusEqualTo(String value) {
            addCriterion("RETURN_STATUS =", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotEqualTo(String value) {
            addCriterion("RETURN_STATUS <>", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThan(String value) {
            addCriterion("RETURN_STATUS >", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_STATUS >=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThan(String value) {
            addCriterion("RETURN_STATUS <", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThanOrEqualTo(String value) {
            addCriterion("RETURN_STATUS <=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLike(String value) {
            addCriterion("RETURN_STATUS like", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotLike(String value) {
            addCriterion("RETURN_STATUS not like", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIn(List<String> values) {
            addCriterion("RETURN_STATUS in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotIn(List<String> values) {
            addCriterion("RETURN_STATUS not in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusBetween(String value1, String value2) {
            addCriterion("RETURN_STATUS between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotBetween(String value1, String value2) {
            addCriterion("RETURN_STATUS not between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateIsNull() {
            addCriterion("PLEDGE_ACTIVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateIsNotNull() {
            addCriterion("PLEDGE_ACTIVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateEqualTo(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE =", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateNotEqualTo(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE <>", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateGreaterThan(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE >", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE >=", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateLessThan(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE <", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateLessThanOrEqualTo(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE <=", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateLike(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE like", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateNotLike(String value) {
            addCriterion("PLEDGE_ACTIVE_DATE not like", value, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateIn(List<String> values) {
            addCriterion("PLEDGE_ACTIVE_DATE in", values, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateNotIn(List<String> values) {
            addCriterion("PLEDGE_ACTIVE_DATE not in", values, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateBetween(String value1, String value2) {
            addCriterion("PLEDGE_ACTIVE_DATE between", value1, value2, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andPledgeActiveDateNotBetween(String value1, String value2) {
            addCriterion("PLEDGE_ACTIVE_DATE not between", value1, value2, "pledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateIsNull() {
            addCriterion("UNPLEDGE_ACTIVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateIsNotNull() {
            addCriterion("UNPLEDGE_ACTIVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateEqualTo(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE =", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateNotEqualTo(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE <>", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateGreaterThan(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE >", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE >=", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateLessThan(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE <", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateLessThanOrEqualTo(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE <=", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateLike(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE like", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateNotLike(String value) {
            addCriterion("UNPLEDGE_ACTIVE_DATE not like", value, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateIn(List<String> values) {
            addCriterion("UNPLEDGE_ACTIVE_DATE in", values, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateNotIn(List<String> values) {
            addCriterion("UNPLEDGE_ACTIVE_DATE not in", values, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateBetween(String value1, String value2) {
            addCriterion("UNPLEDGE_ACTIVE_DATE between", value1, value2, "unpledgeActiveDate");
            return (Criteria) this;
        }

        public Criteria andUnpledgeActiveDateNotBetween(String value1, String value2) {
            addCriterion("UNPLEDGE_ACTIVE_DATE not between", value1, value2, "unpledgeActiveDate");
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

        public Criteria andPressCountIsNull() {
            addCriterion("PRESS_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPressCountIsNotNull() {
            addCriterion("PRESS_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPressCountEqualTo(BigDecimal value) {
            addCriterion("PRESS_COUNT =", value, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountNotEqualTo(BigDecimal value) {
            addCriterion("PRESS_COUNT <>", value, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountGreaterThan(BigDecimal value) {
            addCriterion("PRESS_COUNT >", value, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRESS_COUNT >=", value, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountLessThan(BigDecimal value) {
            addCriterion("PRESS_COUNT <", value, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRESS_COUNT <=", value, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountIn(List<BigDecimal> values) {
            addCriterion("PRESS_COUNT in", values, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountNotIn(List<BigDecimal> values) {
            addCriterion("PRESS_COUNT not in", values, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRESS_COUNT between", value1, value2, "pressCount");
            return (Criteria) this;
        }

        public Criteria andPressCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRESS_COUNT not between", value1, value2, "pressCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountIsNull() {
            addCriterion("WARN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andWarnCountIsNotNull() {
            addCriterion("WARN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWarnCountEqualTo(BigDecimal value) {
            addCriterion("WARN_COUNT =", value, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountNotEqualTo(BigDecimal value) {
            addCriterion("WARN_COUNT <>", value, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountGreaterThan(BigDecimal value) {
            addCriterion("WARN_COUNT >", value, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WARN_COUNT >=", value, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountLessThan(BigDecimal value) {
            addCriterion("WARN_COUNT <", value, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WARN_COUNT <=", value, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountIn(List<BigDecimal> values) {
            addCriterion("WARN_COUNT in", values, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountNotIn(List<BigDecimal> values) {
            addCriterion("WARN_COUNT not in", values, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WARN_COUNT between", value1, value2, "warnCount");
            return (Criteria) this;
        }

        public Criteria andWarnCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WARN_COUNT not between", value1, value2, "warnCount");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodIsNull() {
            addCriterion("BILLS_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodIsNotNull() {
            addCriterion("BILLS_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodEqualTo(String value) {
            addCriterion("BILLS_PERIOD =", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodNotEqualTo(String value) {
            addCriterion("BILLS_PERIOD <>", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodGreaterThan(String value) {
            addCriterion("BILLS_PERIOD >", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("BILLS_PERIOD >=", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodLessThan(String value) {
            addCriterion("BILLS_PERIOD <", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodLessThanOrEqualTo(String value) {
            addCriterion("BILLS_PERIOD <=", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodLike(String value) {
            addCriterion("BILLS_PERIOD like", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodNotLike(String value) {
            addCriterion("BILLS_PERIOD not like", value, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodIn(List<String> values) {
            addCriterion("BILLS_PERIOD in", values, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodNotIn(List<String> values) {
            addCriterion("BILLS_PERIOD not in", values, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodBetween(String value1, String value2) {
            addCriterion("BILLS_PERIOD between", value1, value2, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBillsPeriodNotBetween(String value1, String value2) {
            addCriterion("BILLS_PERIOD not between", value1, value2, "billsPeriod");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("BEGIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("BEGIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(String value) {
            addCriterion("BEGIN_DATE =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(String value) {
            addCriterion("BEGIN_DATE <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(String value) {
            addCriterion("BEGIN_DATE >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("BEGIN_DATE >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(String value) {
            addCriterion("BEGIN_DATE <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(String value) {
            addCriterion("BEGIN_DATE <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLike(String value) {
            addCriterion("BEGIN_DATE like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotLike(String value) {
            addCriterion("BEGIN_DATE not like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<String> values) {
            addCriterion("BEGIN_DATE in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<String> values) {
            addCriterion("BEGIN_DATE not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(String value1, String value2) {
            addCriterion("BEGIN_DATE between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(String value1, String value2) {
            addCriterion("BEGIN_DATE not between", value1, value2, "beginDate");
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

        public Criteria andPaydateIsNull() {
            addCriterion("PAYDATE is null");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNotNull() {
            addCriterion("PAYDATE is not null");
            return (Criteria) this;
        }

        public Criteria andPaydateEqualTo(String value) {
            addCriterion("PAYDATE =", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotEqualTo(String value) {
            addCriterion("PAYDATE <>", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThan(String value) {
            addCriterion("PAYDATE >", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThanOrEqualTo(String value) {
            addCriterion("PAYDATE >=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThan(String value) {
            addCriterion("PAYDATE <", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThanOrEqualTo(String value) {
            addCriterion("PAYDATE <=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLike(String value) {
            addCriterion("PAYDATE like", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotLike(String value) {
            addCriterion("PAYDATE not like", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateIn(List<String> values) {
            addCriterion("PAYDATE in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotIn(List<String> values) {
            addCriterion("PAYDATE not in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateBetween(String value1, String value2) {
            addCriterion("PAYDATE between", value1, value2, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotBetween(String value1, String value2) {
            addCriterion("PAYDATE not between", value1, value2, "paydate");
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

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountIsNull() {
            addCriterion("BAIL_REMAINING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountIsNotNull() {
            addCriterion("BAIL_REMAINING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("BAIL_REMAINING_AMOUNT =", value, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_REMAINING_AMOUNT <>", value, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("BAIL_REMAINING_AMOUNT >", value, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_REMAINING_AMOUNT >=", value, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountLessThan(BigDecimal value) {
            addCriterion("BAIL_REMAINING_AMOUNT <", value, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_REMAINING_AMOUNT <=", value, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountIn(List<BigDecimal> values) {
            addCriterion("BAIL_REMAINING_AMOUNT in", values, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_REMAINING_AMOUNT not in", values, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_REMAINING_AMOUNT between", value1, value2, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andBailRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_REMAINING_AMOUNT not between", value1, value2, "bailRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountIsNull() {
            addCriterion("OPEN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOpenAmountIsNotNull() {
            addCriterion("OPEN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAmountEqualTo(BigDecimal value) {
            addCriterion("OPEN_AMOUNT =", value, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountNotEqualTo(BigDecimal value) {
            addCriterion("OPEN_AMOUNT <>", value, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountGreaterThan(BigDecimal value) {
            addCriterion("OPEN_AMOUNT >", value, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OPEN_AMOUNT >=", value, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountLessThan(BigDecimal value) {
            addCriterion("OPEN_AMOUNT <", value, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OPEN_AMOUNT <=", value, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountIn(List<BigDecimal> values) {
            addCriterion("OPEN_AMOUNT in", values, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountNotIn(List<BigDecimal> values) {
            addCriterion("OPEN_AMOUNT not in", values, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPEN_AMOUNT between", value1, value2, "openAmount");
            return (Criteria) this;
        }

        public Criteria andOpenAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPEN_AMOUNT not between", value1, value2, "openAmount");
            return (Criteria) this;
        }

        public Criteria andBailAccountIsNull() {
            addCriterion("BAIL_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBailAccountIsNotNull() {
            addCriterion("BAIL_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBailAccountEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT =", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT <>", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountGreaterThan(String value) {
            addCriterion("BAIL_ACCOUNT >", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT >=", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountLessThan(String value) {
            addCriterion("BAIL_ACCOUNT <", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCOUNT <=", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountLike(String value) {
            addCriterion("BAIL_ACCOUNT like", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotLike(String value) {
            addCriterion("BAIL_ACCOUNT not like", value, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountIn(List<String> values) {
            addCriterion("BAIL_ACCOUNT in", values, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotIn(List<String> values) {
            addCriterion("BAIL_ACCOUNT not in", values, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNT between", value1, value2, "bailAccount");
            return (Criteria) this;
        }

        public Criteria andBailAccountNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACCOUNT not between", value1, value2, "bailAccount");
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

        public Criteria andAddBailAmountIsNull() {
            addCriterion("ADD_BAIL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountIsNotNull() {
            addCriterion("ADD_BAIL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMOUNT =", value, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountNotEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMOUNT <>", value, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountGreaterThan(BigDecimal value) {
            addCriterion("ADD_BAIL_AMOUNT >", value, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMOUNT >=", value, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountLessThan(BigDecimal value) {
            addCriterion("ADD_BAIL_AMOUNT <", value, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_BAIL_AMOUNT <=", value, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountIn(List<BigDecimal> values) {
            addCriterion("ADD_BAIL_AMOUNT in", values, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountNotIn(List<BigDecimal> values) {
            addCriterion("ADD_BAIL_AMOUNT not in", values, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_BAIL_AMOUNT between", value1, value2, "addBailAmount");
            return (Criteria) this;
        }

        public Criteria andAddBailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_BAIL_AMOUNT not between", value1, value2, "addBailAmount");
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

        public Criteria andBussContcodeIsNull() {
            addCriterion("BUSS_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andBussContcodeIsNotNull() {
            addCriterion("BUSS_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBussContcodeEqualTo(String value) {
            addCriterion("BUSS_CONTCODE =", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeNotEqualTo(String value) {
            addCriterion("BUSS_CONTCODE <>", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeGreaterThan(String value) {
            addCriterion("BUSS_CONTCODE >", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_CONTCODE >=", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeLessThan(String value) {
            addCriterion("BUSS_CONTCODE <", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeLessThanOrEqualTo(String value) {
            addCriterion("BUSS_CONTCODE <=", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeLike(String value) {
            addCriterion("BUSS_CONTCODE like", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeNotLike(String value) {
            addCriterion("BUSS_CONTCODE not like", value, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeIn(List<String> values) {
            addCriterion("BUSS_CONTCODE in", values, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeNotIn(List<String> values) {
            addCriterion("BUSS_CONTCODE not in", values, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeBetween(String value1, String value2) {
            addCriterion("BUSS_CONTCODE between", value1, value2, "bussContcode");
            return (Criteria) this;
        }

        public Criteria andBussContcodeNotBetween(String value1, String value2) {
            addCriterion("BUSS_CONTCODE not between", value1, value2, "bussContcode");
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