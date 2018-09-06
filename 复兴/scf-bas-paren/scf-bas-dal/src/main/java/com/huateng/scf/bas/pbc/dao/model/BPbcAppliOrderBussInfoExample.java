package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BPbcAppliOrderBussInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcAppliOrderBussInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcAppliOrderBussInfoExample(BPbcAppliOrderBussInfoExample example) {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOrderContnoIsNull() {
            addCriterion("ORDER_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andOrderContnoIsNotNull() {
            addCriterion("ORDER_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContnoEqualTo(String value) {
            addCriterion("ORDER_CONTNO =", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoNotEqualTo(String value) {
            addCriterion("ORDER_CONTNO <>", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoGreaterThan(String value) {
            addCriterion("ORDER_CONTNO >", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_CONTNO >=", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoLessThan(String value) {
            addCriterion("ORDER_CONTNO <", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_CONTNO <=", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoLike(String value) {
            addCriterion("ORDER_CONTNO like", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoNotLike(String value) {
            addCriterion("ORDER_CONTNO not like", value, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoIn(List<String> values) {
            addCriterion("ORDER_CONTNO in", values, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoNotIn(List<String> values) {
            addCriterion("ORDER_CONTNO not in", values, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoBetween(String value1, String value2) {
            addCriterion("ORDER_CONTNO between", value1, value2, "orderContno");
            return (Criteria) this;
        }

        public Criteria andOrderContnoNotBetween(String value1, String value2) {
            addCriterion("ORDER_CONTNO not between", value1, value2, "orderContno");
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

        public Criteria andInsertDateIsNull() {
            addCriterion("INSERT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNotNull() {
            addCriterion("INSERT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDateEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_DATE =", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_DATE <>", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThan(Date value) {
            addCriterionForJDBCDate("INSERT_DATE >", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_DATE >=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThan(Date value) {
            addCriterionForJDBCDate("INSERT_DATE <", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_DATE <=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateIn(List<Date> values) {
            addCriterionForJDBCDate("INSERT_DATE in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("INSERT_DATE not in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSERT_DATE between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSERT_DATE not between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andBillsNumIsNull() {
            addCriterion("BILLS_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBillsNumIsNotNull() {
            addCriterion("BILLS_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBillsNumEqualTo(BigDecimal value) {
            addCriterion("BILLS_NUM =", value, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumNotEqualTo(BigDecimal value) {
            addCriterion("BILLS_NUM <>", value, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumGreaterThan(BigDecimal value) {
            addCriterion("BILLS_NUM >", value, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_NUM >=", value, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumLessThan(BigDecimal value) {
            addCriterion("BILLS_NUM <", value, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_NUM <=", value, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumIn(List<BigDecimal> values) {
            addCriterion("BILLS_NUM in", values, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumNotIn(List<BigDecimal> values) {
            addCriterion("BILLS_NUM not in", values, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_NUM between", value1, value2, "billsNum");
            return (Criteria) this;
        }

        public Criteria andBillsNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_NUM not between", value1, value2, "billsNum");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("TOTAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("TOTAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_AMOUNT in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_AMOUNT not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_AMOUNT between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_AMOUNT not between", value1, value2, "totalAmount");
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

        public Criteria andBussDateIsNull() {
            addCriterion("BUSS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBussDateIsNotNull() {
            addCriterion("BUSS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBussDateEqualTo(Date value) {
            addCriterionForJDBCDate("BUSS_DATE =", value, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("BUSS_DATE <>", value, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateGreaterThan(Date value) {
            addCriterionForJDBCDate("BUSS_DATE >", value, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BUSS_DATE >=", value, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateLessThan(Date value) {
            addCriterionForJDBCDate("BUSS_DATE <", value, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BUSS_DATE <=", value, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateIn(List<Date> values) {
            addCriterionForJDBCDate("BUSS_DATE in", values, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("BUSS_DATE not in", values, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BUSS_DATE between", value1, value2, "bussDate");
            return (Criteria) this;
        }

        public Criteria andBussDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BUSS_DATE not between", value1, value2, "bussDate");
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

        public Criteria andOrderDebetNoIsNull() {
            addCriterion("ORDER_DEBET_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoIsNotNull() {
            addCriterion("ORDER_DEBET_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoEqualTo(String value) {
            addCriterion("ORDER_DEBET_NO =", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoNotEqualTo(String value) {
            addCriterion("ORDER_DEBET_NO <>", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoGreaterThan(String value) {
            addCriterion("ORDER_DEBET_NO >", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DEBET_NO >=", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoLessThan(String value) {
            addCriterion("ORDER_DEBET_NO <", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DEBET_NO <=", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoLike(String value) {
            addCriterion("ORDER_DEBET_NO like", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoNotLike(String value) {
            addCriterion("ORDER_DEBET_NO not like", value, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoIn(List<String> values) {
            addCriterion("ORDER_DEBET_NO in", values, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoNotIn(List<String> values) {
            addCriterion("ORDER_DEBET_NO not in", values, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoBetween(String value1, String value2) {
            addCriterion("ORDER_DEBET_NO between", value1, value2, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andOrderDebetNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_DEBET_NO not between", value1, value2, "orderDebetNo");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtIsNull() {
            addCriterion("BALANCE_RISK_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtIsNotNull() {
            addCriterion("BALANCE_RISK_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtEqualTo(BigDecimal value) {
            addCriterion("BALANCE_RISK_AMT =", value, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("BALANCE_RISK_AMT <>", value, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("BALANCE_RISK_AMT >", value, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE_RISK_AMT >=", value, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtLessThan(BigDecimal value) {
            addCriterion("BALANCE_RISK_AMT <", value, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE_RISK_AMT <=", value, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtIn(List<BigDecimal> values) {
            addCriterion("BALANCE_RISK_AMT in", values, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("BALANCE_RISK_AMT not in", values, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE_RISK_AMT between", value1, value2, "balanceRiskAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE_RISK_AMT not between", value1, value2, "balanceRiskAmt");
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

        public Criteria andBussWayIsNull() {
            addCriterion("BUSS_WAY is null");
            return (Criteria) this;
        }

        public Criteria andBussWayIsNotNull() {
            addCriterion("BUSS_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andBussWayEqualTo(String value) {
            addCriterion("BUSS_WAY =", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayNotEqualTo(String value) {
            addCriterion("BUSS_WAY <>", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayGreaterThan(String value) {
            addCriterion("BUSS_WAY >", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_WAY >=", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayLessThan(String value) {
            addCriterion("BUSS_WAY <", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayLessThanOrEqualTo(String value) {
            addCriterion("BUSS_WAY <=", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayLike(String value) {
            addCriterion("BUSS_WAY like", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayNotLike(String value) {
            addCriterion("BUSS_WAY not like", value, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayIn(List<String> values) {
            addCriterion("BUSS_WAY in", values, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayNotIn(List<String> values) {
            addCriterion("BUSS_WAY not in", values, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayBetween(String value1, String value2) {
            addCriterion("BUSS_WAY between", value1, value2, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBussWayNotBetween(String value1, String value2) {
            addCriterion("BUSS_WAY not between", value1, value2, "bussWay");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountIsNull() {
            addCriterion("BILLS_TTL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountIsNotNull() {
            addCriterion("BILLS_TTL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountEqualTo(BigDecimal value) {
            addCriterion("BILLS_TTL_AMOUNT =", value, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountNotEqualTo(BigDecimal value) {
            addCriterion("BILLS_TTL_AMOUNT <>", value, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountGreaterThan(BigDecimal value) {
            addCriterion("BILLS_TTL_AMOUNT >", value, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_TTL_AMOUNT >=", value, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountLessThan(BigDecimal value) {
            addCriterion("BILLS_TTL_AMOUNT <", value, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILLS_TTL_AMOUNT <=", value, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountIn(List<BigDecimal> values) {
            addCriterion("BILLS_TTL_AMOUNT in", values, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountNotIn(List<BigDecimal> values) {
            addCriterion("BILLS_TTL_AMOUNT not in", values, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_TTL_AMOUNT between", value1, value2, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andBillsTtlAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILLS_TTL_AMOUNT not between", value1, value2, "billsTtlAmount");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtIsNull() {
            addCriterion("AVALIABLE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtIsNotNull() {
            addCriterion("AVALIABLE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtEqualTo(BigDecimal value) {
            addCriterion("AVALIABLE_AMT =", value, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtNotEqualTo(BigDecimal value) {
            addCriterion("AVALIABLE_AMT <>", value, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtGreaterThan(BigDecimal value) {
            addCriterion("AVALIABLE_AMT >", value, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AVALIABLE_AMT >=", value, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtLessThan(BigDecimal value) {
            addCriterion("AVALIABLE_AMT <", value, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AVALIABLE_AMT <=", value, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtIn(List<BigDecimal> values) {
            addCriterion("AVALIABLE_AMT in", values, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtNotIn(List<BigDecimal> values) {
            addCriterion("AVALIABLE_AMT not in", values, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AVALIABLE_AMT between", value1, value2, "avaliableAmt");
            return (Criteria) this;
        }

        public Criteria andAvaliableAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AVALIABLE_AMT not between", value1, value2, "avaliableAmt");
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

        public Criteria andTransactionNoIsNull() {
            addCriterion("TRANSACTION_NO is null");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIsNotNull() {
            addCriterion("TRANSACTION_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionNoEqualTo(String value) {
            addCriterion("TRANSACTION_NO =", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotEqualTo(String value) {
            addCriterion("TRANSACTION_NO <>", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoGreaterThan(String value) {
            addCriterion("TRANSACTION_NO >", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSACTION_NO >=", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLessThan(String value) {
            addCriterion("TRANSACTION_NO <", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLessThanOrEqualTo(String value) {
            addCriterion("TRANSACTION_NO <=", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLike(String value) {
            addCriterion("TRANSACTION_NO like", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotLike(String value) {
            addCriterion("TRANSACTION_NO not like", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIn(List<String> values) {
            addCriterion("TRANSACTION_NO in", values, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotIn(List<String> values) {
            addCriterion("TRANSACTION_NO not in", values, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoBetween(String value1, String value2) {
            addCriterion("TRANSACTION_NO between", value1, value2, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotBetween(String value1, String value2) {
            addCriterion("TRANSACTION_NO not between", value1, value2, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andAssignRuleIsNull() {
            addCriterion("ASSIGN_RULE is null");
            return (Criteria) this;
        }

        public Criteria andAssignRuleIsNotNull() {
            addCriterion("ASSIGN_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andAssignRuleEqualTo(String value) {
            addCriterion("ASSIGN_RULE =", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleNotEqualTo(String value) {
            addCriterion("ASSIGN_RULE <>", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleGreaterThan(String value) {
            addCriterion("ASSIGN_RULE >", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleGreaterThanOrEqualTo(String value) {
            addCriterion("ASSIGN_RULE >=", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleLessThan(String value) {
            addCriterion("ASSIGN_RULE <", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleLessThanOrEqualTo(String value) {
            addCriterion("ASSIGN_RULE <=", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleLike(String value) {
            addCriterion("ASSIGN_RULE like", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleNotLike(String value) {
            addCriterion("ASSIGN_RULE not like", value, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleIn(List<String> values) {
            addCriterion("ASSIGN_RULE in", values, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleNotIn(List<String> values) {
            addCriterion("ASSIGN_RULE not in", values, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleBetween(String value1, String value2) {
            addCriterion("ASSIGN_RULE between", value1, value2, "assignRule");
            return (Criteria) this;
        }

        public Criteria andAssignRuleNotBetween(String value1, String value2) {
            addCriterion("ASSIGN_RULE not between", value1, value2, "assignRule");
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

        public Criteria andReturnAccountIsNull() {
            addCriterion("RETURN_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReturnAccountIsNotNull() {
            addCriterion("RETURN_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAccountEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT =", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT <>", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountGreaterThan(String value) {
            addCriterion("RETURN_ACCOUNT >", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT >=", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountLessThan(String value) {
            addCriterion("RETURN_ACCOUNT <", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountLessThanOrEqualTo(String value) {
            addCriterion("RETURN_ACCOUNT <=", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountLike(String value) {
            addCriterion("RETURN_ACCOUNT like", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotLike(String value) {
            addCriterion("RETURN_ACCOUNT not like", value, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountIn(List<String> values) {
            addCriterion("RETURN_ACCOUNT in", values, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotIn(List<String> values) {
            addCriterion("RETURN_ACCOUNT not in", values, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBetween(String value1, String value2) {
            addCriterion("RETURN_ACCOUNT between", value1, value2, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountNotBetween(String value1, String value2) {
            addCriterion("RETURN_ACCOUNT not between", value1, value2, "returnAccount");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceIsNull() {
            addCriterion("RETURN_ACCOUNT_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceIsNotNull() {
            addCriterion("RETURN_ACCOUNT_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceEqualTo(BigDecimal value) {
            addCriterion("RETURN_ACCOUNT_BALANCE =", value, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceNotEqualTo(BigDecimal value) {
            addCriterion("RETURN_ACCOUNT_BALANCE <>", value, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceGreaterThan(BigDecimal value) {
            addCriterion("RETURN_ACCOUNT_BALANCE >", value, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_ACCOUNT_BALANCE >=", value, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceLessThan(BigDecimal value) {
            addCriterion("RETURN_ACCOUNT_BALANCE <", value, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_ACCOUNT_BALANCE <=", value, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceIn(List<BigDecimal> values) {
            addCriterion("RETURN_ACCOUNT_BALANCE in", values, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceNotIn(List<BigDecimal> values) {
            addCriterion("RETURN_ACCOUNT_BALANCE not in", values, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_ACCOUNT_BALANCE between", value1, value2, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andReturnAccountBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_ACCOUNT_BALANCE not between", value1, value2, "returnAccountBalance");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagIsNull() {
            addCriterion("TO_SALLER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagIsNotNull() {
            addCriterion("TO_SALLER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagEqualTo(String value) {
            addCriterion("TO_SALLER_FLAG =", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagNotEqualTo(String value) {
            addCriterion("TO_SALLER_FLAG <>", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagGreaterThan(String value) {
            addCriterion("TO_SALLER_FLAG >", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagGreaterThanOrEqualTo(String value) {
            addCriterion("TO_SALLER_FLAG >=", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagLessThan(String value) {
            addCriterion("TO_SALLER_FLAG <", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagLessThanOrEqualTo(String value) {
            addCriterion("TO_SALLER_FLAG <=", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagLike(String value) {
            addCriterion("TO_SALLER_FLAG like", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagNotLike(String value) {
            addCriterion("TO_SALLER_FLAG not like", value, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagIn(List<String> values) {
            addCriterion("TO_SALLER_FLAG in", values, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagNotIn(List<String> values) {
            addCriterion("TO_SALLER_FLAG not in", values, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagBetween(String value1, String value2) {
            addCriterion("TO_SALLER_FLAG between", value1, value2, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andToSallerFlagNotBetween(String value1, String value2) {
            addCriterion("TO_SALLER_FLAG not between", value1, value2, "toSallerFlag");
            return (Criteria) this;
        }

        public Criteria andOverAmountIsNull() {
            addCriterion("OVER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOverAmountIsNotNull() {
            addCriterion("OVER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOverAmountEqualTo(BigDecimal value) {
            addCriterion("OVER_AMOUNT =", value, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountNotEqualTo(BigDecimal value) {
            addCriterion("OVER_AMOUNT <>", value, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountGreaterThan(BigDecimal value) {
            addCriterion("OVER_AMOUNT >", value, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVER_AMOUNT >=", value, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountLessThan(BigDecimal value) {
            addCriterion("OVER_AMOUNT <", value, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVER_AMOUNT <=", value, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountIn(List<BigDecimal> values) {
            addCriterion("OVER_AMOUNT in", values, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountNotIn(List<BigDecimal> values) {
            addCriterion("OVER_AMOUNT not in", values, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVER_AMOUNT between", value1, value2, "overAmount");
            return (Criteria) this;
        }

        public Criteria andOverAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVER_AMOUNT not between", value1, value2, "overAmount");
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

        public Criteria andReturnUsageIsNull() {
            addCriterion("RETURN_USAGE is null");
            return (Criteria) this;
        }

        public Criteria andReturnUsageIsNotNull() {
            addCriterion("RETURN_USAGE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUsageEqualTo(String value) {
            addCriterion("RETURN_USAGE =", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageNotEqualTo(String value) {
            addCriterion("RETURN_USAGE <>", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageGreaterThan(String value) {
            addCriterion("RETURN_USAGE >", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_USAGE >=", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageLessThan(String value) {
            addCriterion("RETURN_USAGE <", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageLessThanOrEqualTo(String value) {
            addCriterion("RETURN_USAGE <=", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageLike(String value) {
            addCriterion("RETURN_USAGE like", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageNotLike(String value) {
            addCriterion("RETURN_USAGE not like", value, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageIn(List<String> values) {
            addCriterion("RETURN_USAGE in", values, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageNotIn(List<String> values) {
            addCriterion("RETURN_USAGE not in", values, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageBetween(String value1, String value2) {
            addCriterion("RETURN_USAGE between", value1, value2, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andReturnUsageNotBetween(String value1, String value2) {
            addCriterion("RETURN_USAGE not between", value1, value2, "returnUsage");
            return (Criteria) this;
        }

        public Criteria andClearWayIsNull() {
            addCriterion("CLEAR_WAY is null");
            return (Criteria) this;
        }

        public Criteria andClearWayIsNotNull() {
            addCriterion("CLEAR_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andClearWayEqualTo(String value) {
            addCriterion("CLEAR_WAY =", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayNotEqualTo(String value) {
            addCriterion("CLEAR_WAY <>", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayGreaterThan(String value) {
            addCriterion("CLEAR_WAY >", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayGreaterThanOrEqualTo(String value) {
            addCriterion("CLEAR_WAY >=", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayLessThan(String value) {
            addCriterion("CLEAR_WAY <", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayLessThanOrEqualTo(String value) {
            addCriterion("CLEAR_WAY <=", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayLike(String value) {
            addCriterion("CLEAR_WAY like", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayNotLike(String value) {
            addCriterion("CLEAR_WAY not like", value, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayIn(List<String> values) {
            addCriterion("CLEAR_WAY in", values, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayNotIn(List<String> values) {
            addCriterion("CLEAR_WAY not in", values, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayBetween(String value1, String value2) {
            addCriterion("CLEAR_WAY between", value1, value2, "clearWay");
            return (Criteria) this;
        }

        public Criteria andClearWayNotBetween(String value1, String value2) {
            addCriterion("CLEAR_WAY not between", value1, value2, "clearWay");
            return (Criteria) this;
        }

        public Criteria andPayerIsNull() {
            addCriterion("PAYER is null");
            return (Criteria) this;
        }

        public Criteria andPayerIsNotNull() {
            addCriterion("PAYER is not null");
            return (Criteria) this;
        }

        public Criteria andPayerEqualTo(String value) {
            addCriterion("PAYER =", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotEqualTo(String value) {
            addCriterion("PAYER <>", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerGreaterThan(String value) {
            addCriterion("PAYER >", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER >=", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLessThan(String value) {
            addCriterion("PAYER <", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLessThanOrEqualTo(String value) {
            addCriterion("PAYER <=", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLike(String value) {
            addCriterion("PAYER like", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotLike(String value) {
            addCriterion("PAYER not like", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerIn(List<String> values) {
            addCriterion("PAYER in", values, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotIn(List<String> values) {
            addCriterion("PAYER not in", values, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerBetween(String value1, String value2) {
            addCriterion("PAYER between", value1, value2, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotBetween(String value1, String value2) {
            addCriterion("PAYER not between", value1, value2, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoIsNull() {
            addCriterion("PAYER_ACCT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoIsNotNull() {
            addCriterion("PAYER_ACCT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoEqualTo(String value) {
            addCriterion("PAYER_ACCT_NO =", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoNotEqualTo(String value) {
            addCriterion("PAYER_ACCT_NO <>", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoGreaterThan(String value) {
            addCriterion("PAYER_ACCT_NO >", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_ACCT_NO >=", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoLessThan(String value) {
            addCriterion("PAYER_ACCT_NO <", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoLessThanOrEqualTo(String value) {
            addCriterion("PAYER_ACCT_NO <=", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoLike(String value) {
            addCriterion("PAYER_ACCT_NO like", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoNotLike(String value) {
            addCriterion("PAYER_ACCT_NO not like", value, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoIn(List<String> values) {
            addCriterion("PAYER_ACCT_NO in", values, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoNotIn(List<String> values) {
            addCriterion("PAYER_ACCT_NO not in", values, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoBetween(String value1, String value2) {
            addCriterion("PAYER_ACCT_NO between", value1, value2, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNoNotBetween(String value1, String value2) {
            addCriterion("PAYER_ACCT_NO not between", value1, value2, "payerAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerBankIsNull() {
            addCriterion("PAYER_BANK is null");
            return (Criteria) this;
        }

        public Criteria andPayerBankIsNotNull() {
            addCriterion("PAYER_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andPayerBankEqualTo(String value) {
            addCriterion("PAYER_BANK =", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankNotEqualTo(String value) {
            addCriterion("PAYER_BANK <>", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankGreaterThan(String value) {
            addCriterion("PAYER_BANK >", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_BANK >=", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankLessThan(String value) {
            addCriterion("PAYER_BANK <", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankLessThanOrEqualTo(String value) {
            addCriterion("PAYER_BANK <=", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankLike(String value) {
            addCriterion("PAYER_BANK like", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankNotLike(String value) {
            addCriterion("PAYER_BANK not like", value, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankIn(List<String> values) {
            addCriterion("PAYER_BANK in", values, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankNotIn(List<String> values) {
            addCriterion("PAYER_BANK not in", values, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankBetween(String value1, String value2) {
            addCriterion("PAYER_BANK between", value1, value2, "payerBank");
            return (Criteria) this;
        }

        public Criteria andPayerBankNotBetween(String value1, String value2) {
            addCriterion("PAYER_BANK not between", value1, value2, "payerBank");
            return (Criteria) this;
        }

        public Criteria andTransferAmtIsNull() {
            addCriterion("TRANSFER_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTransferAmtIsNotNull() {
            addCriterion("TRANSFER_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTransferAmtEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMT =", value, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtNotEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMT <>", value, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtGreaterThan(BigDecimal value) {
            addCriterion("TRANSFER_AMT >", value, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMT >=", value, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtLessThan(BigDecimal value) {
            addCriterion("TRANSFER_AMT <", value, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMT <=", value, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtIn(List<BigDecimal> values) {
            addCriterion("TRANSFER_AMT in", values, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtNotIn(List<BigDecimal> values) {
            addCriterion("TRANSFER_AMT not in", values, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRANSFER_AMT between", value1, value2, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransferAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRANSFER_AMT not between", value1, value2, "transferAmt");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIsNull() {
            addCriterion("TRANSACTION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIsNotNull() {
            addCriterion("TRANSACTION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionDateEqualTo(Date value) {
            addCriterionForJDBCDate("TRANSACTION_DATE =", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("TRANSACTION_DATE <>", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("TRANSACTION_DATE >", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TRANSACTION_DATE >=", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThan(Date value) {
            addCriterionForJDBCDate("TRANSACTION_DATE <", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TRANSACTION_DATE <=", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIn(List<Date> values) {
            addCriterionForJDBCDate("TRANSACTION_DATE in", values, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("TRANSACTION_DATE not in", values, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TRANSACTION_DATE between", value1, value2, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TRANSACTION_DATE not between", value1, value2, "transactionDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}