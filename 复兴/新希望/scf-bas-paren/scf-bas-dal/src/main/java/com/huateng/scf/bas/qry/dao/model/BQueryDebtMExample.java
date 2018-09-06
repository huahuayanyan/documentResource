package com.huateng.scf.bas.qry.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BQueryDebtMExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BQueryDebtMExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BQueryDebtMExample(BQueryDebtMExample example) {
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

        public Criteria andInputdateIsNull() {
            addCriterion("INPUTDATE is null");
            return (Criteria) this;
        }

        public Criteria andInputdateIsNotNull() {
            addCriterion("INPUTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andInputdateEqualTo(String value) {
            addCriterion("INPUTDATE =", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateNotEqualTo(String value) {
            addCriterion("INPUTDATE <>", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateGreaterThan(String value) {
            addCriterion("INPUTDATE >", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateGreaterThanOrEqualTo(String value) {
            addCriterion("INPUTDATE >=", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateLessThan(String value) {
            addCriterion("INPUTDATE <", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateLessThanOrEqualTo(String value) {
            addCriterion("INPUTDATE <=", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateLike(String value) {
            addCriterion("INPUTDATE like", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateNotLike(String value) {
            addCriterion("INPUTDATE not like", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateIn(List<String> values) {
            addCriterion("INPUTDATE in", values, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateNotIn(List<String> values) {
            addCriterion("INPUTDATE not in", values, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateBetween(String value1, String value2) {
            addCriterion("INPUTDATE between", value1, value2, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateNotBetween(String value1, String value2) {
            addCriterion("INPUTDATE not between", value1, value2, "inputdate");
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

        public Criteria andDebtNumIsNull() {
            addCriterion("DEBT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andDebtNumIsNotNull() {
            addCriterion("DEBT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andDebtNumEqualTo(BigDecimal value) {
            addCriterion("DEBT_NUM =", value, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumNotEqualTo(BigDecimal value) {
            addCriterion("DEBT_NUM <>", value, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumGreaterThan(BigDecimal value) {
            addCriterion("DEBT_NUM >", value, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBT_NUM >=", value, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumLessThan(BigDecimal value) {
            addCriterion("DEBT_NUM <", value, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBT_NUM <=", value, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumIn(List<BigDecimal> values) {
            addCriterion("DEBT_NUM in", values, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumNotIn(List<BigDecimal> values) {
            addCriterion("DEBT_NUM not in", values, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBT_NUM between", value1, value2, "debtNum");
            return (Criteria) this;
        }

        public Criteria andDebtNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBT_NUM not between", value1, value2, "debtNum");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountIsNull() {
            addCriterion("TOTAL_DEBT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountIsNotNull() {
            addCriterion("TOTAL_DEBT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_AMOUNT =", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_AMOUNT <>", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_DEBT_AMOUNT >", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_AMOUNT >=", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_DEBT_AMOUNT <", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_AMOUNT <=", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_DEBT_AMOUNT in", values, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_DEBT_AMOUNT not in", values, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_DEBT_AMOUNT between", value1, value2, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_DEBT_AMOUNT not between", value1, value2, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andFinacingCostIsNull() {
            addCriterion("FINACING_COST is null");
            return (Criteria) this;
        }

        public Criteria andFinacingCostIsNotNull() {
            addCriterion("FINACING_COST is not null");
            return (Criteria) this;
        }

        public Criteria andFinacingCostEqualTo(BigDecimal value) {
            addCriterion("FINACING_COST =", value, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostNotEqualTo(BigDecimal value) {
            addCriterion("FINACING_COST <>", value, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostGreaterThan(BigDecimal value) {
            addCriterion("FINACING_COST >", value, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FINACING_COST >=", value, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostLessThan(BigDecimal value) {
            addCriterion("FINACING_COST <", value, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FINACING_COST <=", value, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostIn(List<BigDecimal> values) {
            addCriterion("FINACING_COST in", values, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostNotIn(List<BigDecimal> values) {
            addCriterion("FINACING_COST not in", values, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINACING_COST between", value1, value2, "finacingCost");
            return (Criteria) this;
        }

        public Criteria andFinacingCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINACING_COST not between", value1, value2, "finacingCost");
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

        public Criteria andHandlingFeeIsNull() {
            addCriterion("HANDLING_FEE is null");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeIsNotNull() {
            addCriterion("HANDLING_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeEqualTo(BigDecimal value) {
            addCriterion("HANDLING_FEE =", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeNotEqualTo(BigDecimal value) {
            addCriterion("HANDLING_FEE <>", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeGreaterThan(BigDecimal value) {
            addCriterion("HANDLING_FEE >", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HANDLING_FEE >=", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeLessThan(BigDecimal value) {
            addCriterion("HANDLING_FEE <", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HANDLING_FEE <=", value, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeIn(List<BigDecimal> values) {
            addCriterion("HANDLING_FEE in", values, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeNotIn(List<BigDecimal> values) {
            addCriterion("HANDLING_FEE not in", values, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HANDLING_FEE between", value1, value2, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andHandlingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HANDLING_FEE not between", value1, value2, "handlingFee");
            return (Criteria) this;
        }

        public Criteria andReduceAmountIsNull() {
            addCriterion("REDUCE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReduceAmountIsNotNull() {
            addCriterion("REDUCE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReduceAmountEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMOUNT =", value, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountNotEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMOUNT <>", value, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountGreaterThan(BigDecimal value) {
            addCriterion("REDUCE_AMOUNT >", value, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMOUNT >=", value, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountLessThan(BigDecimal value) {
            addCriterion("REDUCE_AMOUNT <", value, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_AMOUNT <=", value, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountIn(List<BigDecimal> values) {
            addCriterion("REDUCE_AMOUNT in", values, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountNotIn(List<BigDecimal> values) {
            addCriterion("REDUCE_AMOUNT not in", values, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_AMOUNT between", value1, value2, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andReduceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_AMOUNT not between", value1, value2, "reduceAmount");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("TOTAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("TOTAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_FEE >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("TOTAL_FEE <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("TOTAL_FEE in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_FEE not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_FEE between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_FEE not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalReduceIsNull() {
            addCriterion("TOTAL_REDUCE is null");
            return (Criteria) this;
        }

        public Criteria andTotalReduceIsNotNull() {
            addCriterion("TOTAL_REDUCE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalReduceEqualTo(BigDecimal value) {
            addCriterion("TOTAL_REDUCE =", value, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_REDUCE <>", value, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_REDUCE >", value, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_REDUCE >=", value, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceLessThan(BigDecimal value) {
            addCriterion("TOTAL_REDUCE <", value, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_REDUCE <=", value, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceIn(List<BigDecimal> values) {
            addCriterion("TOTAL_REDUCE in", values, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_REDUCE not in", values, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_REDUCE between", value1, value2, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andTotalReduceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_REDUCE not between", value1, value2, "totalReduce");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIsNull() {
            addCriterion("RECEIVE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIsNotNull() {
            addCriterion("RECEIVE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT =", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT <>", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountGreaterThan(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT >", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT >=", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountLessThan(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT <", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVE_AMOUNT <=", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIn(List<BigDecimal> values) {
            addCriterion("RECEIVE_AMOUNT in", values, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVE_AMOUNT not in", values, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVE_AMOUNT between", value1, value2, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVE_AMOUNT not between", value1, value2, "receiveAmount");
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

        public Criteria andLoanTypeIsNull() {
            addCriterion("LOAN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("LOAN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(String value) {
            addCriterion("LOAN_TYPE =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(String value) {
            addCriterion("LOAN_TYPE <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(String value) {
            addCriterion("LOAN_TYPE >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_TYPE >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(String value) {
            addCriterion("LOAN_TYPE <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(String value) {
            addCriterion("LOAN_TYPE <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLike(String value) {
            addCriterion("LOAN_TYPE like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotLike(String value) {
            addCriterion("LOAN_TYPE not like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<String> values) {
            addCriterion("LOAN_TYPE in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<String> values) {
            addCriterion("LOAN_TYPE not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(String value1, String value2) {
            addCriterion("LOAN_TYPE between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(String value1, String value2) {
            addCriterion("LOAN_TYPE not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andBanknoIsNull() {
            addCriterion("BANKNO is null");
            return (Criteria) this;
        }

        public Criteria andBanknoIsNotNull() {
            addCriterion("BANKNO is not null");
            return (Criteria) this;
        }

        public Criteria andBanknoEqualTo(String value) {
            addCriterion("BANKNO =", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoNotEqualTo(String value) {
            addCriterion("BANKNO <>", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoGreaterThan(String value) {
            addCriterion("BANKNO >", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoGreaterThanOrEqualTo(String value) {
            addCriterion("BANKNO >=", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoLessThan(String value) {
            addCriterion("BANKNO <", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoLessThanOrEqualTo(String value) {
            addCriterion("BANKNO <=", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoLike(String value) {
            addCriterion("BANKNO like", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoNotLike(String value) {
            addCriterion("BANKNO not like", value, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoIn(List<String> values) {
            addCriterion("BANKNO in", values, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoNotIn(List<String> values) {
            addCriterion("BANKNO not in", values, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoBetween(String value1, String value2) {
            addCriterion("BANKNO between", value1, value2, "bankno");
            return (Criteria) this;
        }

        public Criteria andBanknoNotBetween(String value1, String value2) {
            addCriterion("BANKNO not between", value1, value2, "bankno");
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

        public Criteria andAppDateIsNull() {
            addCriterion("APP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNotNull() {
            addCriterion("APP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAppDateEqualTo(Date value) {
            addCriterionForJDBCDate("APP_DATE =", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("APP_DATE <>", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThan(Date value) {
            addCriterionForJDBCDate("APP_DATE >", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("APP_DATE >=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThan(Date value) {
            addCriterionForJDBCDate("APP_DATE <", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("APP_DATE <=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateIn(List<Date> values) {
            addCriterionForJDBCDate("APP_DATE in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("APP_DATE not in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("APP_DATE between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("APP_DATE not between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNull() {
            addCriterion("RETURN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNotNull() {
            addCriterion("RETURN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(Date value) {
            addCriterionForJDBCDate("RETURN_DATE =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("RETURN_DATE <>", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("RETURN_DATE >", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RETURN_DATE >=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThan(Date value) {
            addCriterionForJDBCDate("RETURN_DATE <", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RETURN_DATE <=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIn(List<Date> values) {
            addCriterionForJDBCDate("RETURN_DATE in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("RETURN_DATE not in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RETURN_DATE between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RETURN_DATE not between", value1, value2, "returnDate");
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

        public Criteria andBrcodeBussIsNull() {
            addCriterion("BRCODE_BUSS is null");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussIsNotNull() {
            addCriterion("BRCODE_BUSS is not null");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussEqualTo(String value) {
            addCriterion("BRCODE_BUSS =", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussNotEqualTo(String value) {
            addCriterion("BRCODE_BUSS <>", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussGreaterThan(String value) {
            addCriterion("BRCODE_BUSS >", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussGreaterThanOrEqualTo(String value) {
            addCriterion("BRCODE_BUSS >=", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussLessThan(String value) {
            addCriterion("BRCODE_BUSS <", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussLessThanOrEqualTo(String value) {
            addCriterion("BRCODE_BUSS <=", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussLike(String value) {
            addCriterion("BRCODE_BUSS like", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussNotLike(String value) {
            addCriterion("BRCODE_BUSS not like", value, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussIn(List<String> values) {
            addCriterion("BRCODE_BUSS in", values, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussNotIn(List<String> values) {
            addCriterion("BRCODE_BUSS not in", values, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussBetween(String value1, String value2) {
            addCriterion("BRCODE_BUSS between", value1, value2, "brcodeBuss");
            return (Criteria) this;
        }

        public Criteria andBrcodeBussNotBetween(String value1, String value2) {
            addCriterion("BRCODE_BUSS not between", value1, value2, "brcodeBuss");
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

        public Criteria andReturnAmountIsNull() {
            addCriterion("RETURN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIsNotNull() {
            addCriterion("RETURN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountEqualTo(BigDecimal value) {
            addCriterion("RETURN_AMOUNT =", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotEqualTo(BigDecimal value) {
            addCriterion("RETURN_AMOUNT <>", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountGreaterThan(BigDecimal value) {
            addCriterion("RETURN_AMOUNT >", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_AMOUNT >=", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountLessThan(BigDecimal value) {
            addCriterion("RETURN_AMOUNT <", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_AMOUNT <=", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIn(List<BigDecimal> values) {
            addCriterion("RETURN_AMOUNT in", values, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotIn(List<BigDecimal> values) {
            addCriterion("RETURN_AMOUNT not in", values, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_AMOUNT between", value1, value2, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_AMOUNT not between", value1, value2, "returnAmount");
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

        public Criteria andReturnInterestAmountIsNull() {
            addCriterion("RETURN_INTEREST_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountIsNotNull() {
            addCriterion("RETURN_INTEREST_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountEqualTo(BigDecimal value) {
            addCriterion("RETURN_INTEREST_AMOUNT =", value, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountNotEqualTo(BigDecimal value) {
            addCriterion("RETURN_INTEREST_AMOUNT <>", value, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountGreaterThan(BigDecimal value) {
            addCriterion("RETURN_INTEREST_AMOUNT >", value, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_INTEREST_AMOUNT >=", value, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountLessThan(BigDecimal value) {
            addCriterion("RETURN_INTEREST_AMOUNT <", value, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_INTEREST_AMOUNT <=", value, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountIn(List<BigDecimal> values) {
            addCriterion("RETURN_INTEREST_AMOUNT in", values, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountNotIn(List<BigDecimal> values) {
            addCriterion("RETURN_INTEREST_AMOUNT not in", values, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_INTEREST_AMOUNT between", value1, value2, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnInterestAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_INTEREST_AMOUNT not between", value1, value2, "returnInterestAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountIsNull() {
            addCriterion("RETURN_CAPITAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountIsNotNull() {
            addCriterion("RETURN_CAPITAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountEqualTo(BigDecimal value) {
            addCriterion("RETURN_CAPITAL_AMOUNT =", value, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountNotEqualTo(BigDecimal value) {
            addCriterion("RETURN_CAPITAL_AMOUNT <>", value, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountGreaterThan(BigDecimal value) {
            addCriterion("RETURN_CAPITAL_AMOUNT >", value, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_CAPITAL_AMOUNT >=", value, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountLessThan(BigDecimal value) {
            addCriterion("RETURN_CAPITAL_AMOUNT <", value, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_CAPITAL_AMOUNT <=", value, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountIn(List<BigDecimal> values) {
            addCriterion("RETURN_CAPITAL_AMOUNT in", values, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountNotIn(List<BigDecimal> values) {
            addCriterion("RETURN_CAPITAL_AMOUNT not in", values, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_CAPITAL_AMOUNT between", value1, value2, "returnCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andReturnCapitalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_CAPITAL_AMOUNT not between", value1, value2, "returnCapitalAmount");
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

        public Criteria andTobailAmountIsNull() {
            addCriterion("TOBAIL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTobailAmountIsNotNull() {
            addCriterion("TOBAIL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTobailAmountEqualTo(BigDecimal value) {
            addCriterion("TOBAIL_AMOUNT =", value, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOBAIL_AMOUNT <>", value, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountGreaterThan(BigDecimal value) {
            addCriterion("TOBAIL_AMOUNT >", value, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOBAIL_AMOUNT >=", value, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountLessThan(BigDecimal value) {
            addCriterion("TOBAIL_AMOUNT <", value, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOBAIL_AMOUNT <=", value, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountIn(List<BigDecimal> values) {
            addCriterion("TOBAIL_AMOUNT in", values, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOBAIL_AMOUNT not in", values, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOBAIL_AMOUNT between", value1, value2, "tobailAmount");
            return (Criteria) this;
        }

        public Criteria andTobailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOBAIL_AMOUNT not between", value1, value2, "tobailAmount");
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

        public Criteria andTotalOverAmountIsNull() {
            addCriterion("TOTAL_OVER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountIsNotNull() {
            addCriterion("TOTAL_OVER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_OVER_AMOUNT =", value, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_OVER_AMOUNT <>", value, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_OVER_AMOUNT >", value, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_OVER_AMOUNT >=", value, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_OVER_AMOUNT <", value, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_OVER_AMOUNT <=", value, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_OVER_AMOUNT in", values, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_OVER_AMOUNT not in", values, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_OVER_AMOUNT between", value1, value2, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andTotalOverAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_OVER_AMOUNT not between", value1, value2, "totalOverAmount");
            return (Criteria) this;
        }

        public Criteria andSettleMethodIsNull() {
            addCriterion("SETTLE_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andSettleMethodIsNotNull() {
            addCriterion("SETTLE_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andSettleMethodEqualTo(String value) {
            addCriterion("SETTLE_METHOD =", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodNotEqualTo(String value) {
            addCriterion("SETTLE_METHOD <>", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodGreaterThan(String value) {
            addCriterion("SETTLE_METHOD >", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_METHOD >=", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodLessThan(String value) {
            addCriterion("SETTLE_METHOD <", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_METHOD <=", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodLike(String value) {
            addCriterion("SETTLE_METHOD like", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodNotLike(String value) {
            addCriterion("SETTLE_METHOD not like", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodIn(List<String> values) {
            addCriterion("SETTLE_METHOD in", values, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodNotIn(List<String> values) {
            addCriterion("SETTLE_METHOD not in", values, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodBetween(String value1, String value2) {
            addCriterion("SETTLE_METHOD between", value1, value2, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andSettleMethodNotBetween(String value1, String value2) {
            addCriterion("SETTLE_METHOD not between", value1, value2, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeIsNull() {
            addCriterion("REPAY_PURPOSE is null");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeIsNotNull() {
            addCriterion("REPAY_PURPOSE is not null");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeEqualTo(String value) {
            addCriterion("REPAY_PURPOSE =", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeNotEqualTo(String value) {
            addCriterion("REPAY_PURPOSE <>", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeGreaterThan(String value) {
            addCriterion("REPAY_PURPOSE >", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("REPAY_PURPOSE >=", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeLessThan(String value) {
            addCriterion("REPAY_PURPOSE <", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeLessThanOrEqualTo(String value) {
            addCriterion("REPAY_PURPOSE <=", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeLike(String value) {
            addCriterion("REPAY_PURPOSE like", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeNotLike(String value) {
            addCriterion("REPAY_PURPOSE not like", value, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeIn(List<String> values) {
            addCriterion("REPAY_PURPOSE in", values, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeNotIn(List<String> values) {
            addCriterion("REPAY_PURPOSE not in", values, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeBetween(String value1, String value2) {
            addCriterion("REPAY_PURPOSE between", value1, value2, "repayPurpose");
            return (Criteria) this;
        }

        public Criteria andRepayPurposeNotBetween(String value1, String value2) {
            addCriterion("REPAY_PURPOSE not between", value1, value2, "repayPurpose");
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

        public Criteria andEnameIsNull() {
            addCriterion("ENAME is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("ENAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("ENAME =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("ENAME <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("ENAME >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ENAME >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("ENAME <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("ENAME <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("ENAME like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("ENAME not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("ENAME in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("ENAME not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("ENAME between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("ENAME not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNull() {
            addCriterion("ALIAS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNotNull() {
            addCriterion("ALIAS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAliasNameEqualTo(String value) {
            addCriterion("ALIAS_NAME =", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotEqualTo(String value) {
            addCriterion("ALIAS_NAME <>", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThan(String value) {
            addCriterion("ALIAS_NAME >", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThanOrEqualTo(String value) {
            addCriterion("ALIAS_NAME >=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThan(String value) {
            addCriterion("ALIAS_NAME <", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThanOrEqualTo(String value) {
            addCriterion("ALIAS_NAME <=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLike(String value) {
            addCriterion("ALIAS_NAME like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotLike(String value) {
            addCriterion("ALIAS_NAME not like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameIn(List<String> values) {
            addCriterion("ALIAS_NAME in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotIn(List<String> values) {
            addCriterion("ALIAS_NAME not in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameBetween(String value1, String value2) {
            addCriterion("ALIAS_NAME between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotBetween(String value1, String value2) {
            addCriterion("ALIAS_NAME not between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("ORG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("ORG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("ORG_CODE =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("ORG_CODE <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("ORG_CODE >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_CODE >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("ORG_CODE <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("ORG_CODE <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("ORG_CODE like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("ORG_CODE not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("ORG_CODE in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("ORG_CODE not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("ORG_CODE between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("ORG_CODE not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNull() {
            addCriterion("CUST_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNotNull() {
            addCriterion("CUST_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCustStatusEqualTo(String value) {
            addCriterion("CUST_STATUS =", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotEqualTo(String value) {
            addCriterion("CUST_STATUS <>", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThan(String value) {
            addCriterion("CUST_STATUS >", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_STATUS >=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThan(String value) {
            addCriterion("CUST_STATUS <", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThanOrEqualTo(String value) {
            addCriterion("CUST_STATUS <=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLike(String value) {
            addCriterion("CUST_STATUS like", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotLike(String value) {
            addCriterion("CUST_STATUS not like", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusIn(List<String> values) {
            addCriterion("CUST_STATUS in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotIn(List<String> values) {
            addCriterion("CUST_STATUS not in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusBetween(String value1, String value2) {
            addCriterion("CUST_STATUS between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotBetween(String value1, String value2) {
            addCriterion("CUST_STATUS not between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andMgrnoIsNull() {
            addCriterion("MGRNO is null");
            return (Criteria) this;
        }

        public Criteria andMgrnoIsNotNull() {
            addCriterion("MGRNO is not null");
            return (Criteria) this;
        }

        public Criteria andMgrnoEqualTo(String value) {
            addCriterion("MGRNO =", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotEqualTo(String value) {
            addCriterion("MGRNO <>", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoGreaterThan(String value) {
            addCriterion("MGRNO >", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoGreaterThanOrEqualTo(String value) {
            addCriterion("MGRNO >=", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLessThan(String value) {
            addCriterion("MGRNO <", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLessThanOrEqualTo(String value) {
            addCriterion("MGRNO <=", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoLike(String value) {
            addCriterion("MGRNO like", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotLike(String value) {
            addCriterion("MGRNO not like", value, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoIn(List<String> values) {
            addCriterion("MGRNO in", values, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotIn(List<String> values) {
            addCriterion("MGRNO not in", values, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoBetween(String value1, String value2) {
            addCriterion("MGRNO between", value1, value2, "mgrno");
            return (Criteria) this;
        }

        public Criteria andMgrnoNotBetween(String value1, String value2) {
            addCriterion("MGRNO not between", value1, value2, "mgrno");
            return (Criteria) this;
        }

        public Criteria andCoreFlagIsNull() {
            addCriterion("CORE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCoreFlagIsNotNull() {
            addCriterion("CORE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCoreFlagEqualTo(String value) {
            addCriterion("CORE_FLAG =", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotEqualTo(String value) {
            addCriterion("CORE_FLAG <>", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagGreaterThan(String value) {
            addCriterion("CORE_FLAG >", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_FLAG >=", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagLessThan(String value) {
            addCriterion("CORE_FLAG <", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagLessThanOrEqualTo(String value) {
            addCriterion("CORE_FLAG <=", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagLike(String value) {
            addCriterion("CORE_FLAG like", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotLike(String value) {
            addCriterion("CORE_FLAG not like", value, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagIn(List<String> values) {
            addCriterion("CORE_FLAG in", values, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotIn(List<String> values) {
            addCriterion("CORE_FLAG not in", values, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagBetween(String value1, String value2) {
            addCriterion("CORE_FLAG between", value1, value2, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andCoreFlagNotBetween(String value1, String value2) {
            addCriterion("CORE_FLAG not between", value1, value2, "coreFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagIsNull() {
            addCriterion("MONI_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andMoniFlagIsNotNull() {
            addCriterion("MONI_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andMoniFlagEqualTo(String value) {
            addCriterion("MONI_FLAG =", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotEqualTo(String value) {
            addCriterion("MONI_FLAG <>", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagGreaterThan(String value) {
            addCriterion("MONI_FLAG >", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_FLAG >=", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagLessThan(String value) {
            addCriterion("MONI_FLAG <", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagLessThanOrEqualTo(String value) {
            addCriterion("MONI_FLAG <=", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagLike(String value) {
            addCriterion("MONI_FLAG like", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotLike(String value) {
            addCriterion("MONI_FLAG not like", value, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagIn(List<String> values) {
            addCriterion("MONI_FLAG in", values, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotIn(List<String> values) {
            addCriterion("MONI_FLAG not in", values, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagBetween(String value1, String value2) {
            addCriterion("MONI_FLAG between", value1, value2, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andMoniFlagNotBetween(String value1, String value2) {
            addCriterion("MONI_FLAG not between", value1, value2, "moniFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagIsNull() {
            addCriterion("FUTURES_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagIsNotNull() {
            addCriterion("FUTURES_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagEqualTo(String value) {
            addCriterion("FUTURES_FLAG =", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotEqualTo(String value) {
            addCriterion("FUTURES_FLAG <>", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagGreaterThan(String value) {
            addCriterion("FUTURES_FLAG >", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FUTURES_FLAG >=", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagLessThan(String value) {
            addCriterion("FUTURES_FLAG <", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagLessThanOrEqualTo(String value) {
            addCriterion("FUTURES_FLAG <=", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagLike(String value) {
            addCriterion("FUTURES_FLAG like", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotLike(String value) {
            addCriterion("FUTURES_FLAG not like", value, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagIn(List<String> values) {
            addCriterion("FUTURES_FLAG in", values, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotIn(List<String> values) {
            addCriterion("FUTURES_FLAG not in", values, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagBetween(String value1, String value2) {
            addCriterion("FUTURES_FLAG between", value1, value2, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFuturesFlagNotBetween(String value1, String value2) {
            addCriterion("FUTURES_FLAG not between", value1, value2, "futuresFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagIsNull() {
            addCriterion("FLC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlcFlagIsNotNull() {
            addCriterion("FLC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlcFlagEqualTo(String value) {
            addCriterion("FLC_FLAG =", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotEqualTo(String value) {
            addCriterion("FLC_FLAG <>", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagGreaterThan(String value) {
            addCriterion("FLC_FLAG >", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLC_FLAG >=", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagLessThan(String value) {
            addCriterion("FLC_FLAG <", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagLessThanOrEqualTo(String value) {
            addCriterion("FLC_FLAG <=", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagLike(String value) {
            addCriterion("FLC_FLAG like", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotLike(String value) {
            addCriterion("FLC_FLAG not like", value, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagIn(List<String> values) {
            addCriterion("FLC_FLAG in", values, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotIn(List<String> values) {
            addCriterion("FLC_FLAG not in", values, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagBetween(String value1, String value2) {
            addCriterion("FLC_FLAG between", value1, value2, "flcFlag");
            return (Criteria) this;
        }

        public Criteria andFlcFlagNotBetween(String value1, String value2) {
            addCriterion("FLC_FLAG not between", value1, value2, "flcFlag");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIsNull() {
            addCriterion("CREDIT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIsNotNull() {
            addCriterion("CREDIT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCreditFlagEqualTo(String value) {
            addCriterion("CREDIT_FLAG =", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotEqualTo(String value) {
            addCriterion("CREDIT_FLAG <>", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagGreaterThan(String value) {
            addCriterion("CREDIT_FLAG >", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_FLAG >=", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLessThan(String value) {
            addCriterion("CREDIT_FLAG <", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_FLAG <=", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLike(String value) {
            addCriterion("CREDIT_FLAG like", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotLike(String value) {
            addCriterion("CREDIT_FLAG not like", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIn(List<String> values) {
            addCriterion("CREDIT_FLAG in", values, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotIn(List<String> values) {
            addCriterion("CREDIT_FLAG not in", values, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagBetween(String value1, String value2) {
            addCriterion("CREDIT_FLAG between", value1, value2, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotBetween(String value1, String value2) {
            addCriterion("CREDIT_FLAG not between", value1, value2, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagIsNull() {
            addCriterion("BLACK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBlackFlagIsNotNull() {
            addCriterion("BLACK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBlackFlagEqualTo(String value) {
            addCriterion("BLACK_FLAG =", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotEqualTo(String value) {
            addCriterion("BLACK_FLAG <>", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagGreaterThan(String value) {
            addCriterion("BLACK_FLAG >", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BLACK_FLAG >=", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagLessThan(String value) {
            addCriterion("BLACK_FLAG <", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagLessThanOrEqualTo(String value) {
            addCriterion("BLACK_FLAG <=", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagLike(String value) {
            addCriterion("BLACK_FLAG like", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotLike(String value) {
            addCriterion("BLACK_FLAG not like", value, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagIn(List<String> values) {
            addCriterion("BLACK_FLAG in", values, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotIn(List<String> values) {
            addCriterion("BLACK_FLAG not in", values, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagBetween(String value1, String value2) {
            addCriterion("BLACK_FLAG between", value1, value2, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andBlackFlagNotBetween(String value1, String value2) {
            addCriterion("BLACK_FLAG not between", value1, value2, "blackFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagIsNull() {
            addCriterion("INSURE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andInsureFlagIsNotNull() {
            addCriterion("INSURE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInsureFlagEqualTo(String value) {
            addCriterion("INSURE_FLAG =", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotEqualTo(String value) {
            addCriterion("INSURE_FLAG <>", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagGreaterThan(String value) {
            addCriterion("INSURE_FLAG >", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagGreaterThanOrEqualTo(String value) {
            addCriterion("INSURE_FLAG >=", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagLessThan(String value) {
            addCriterion("INSURE_FLAG <", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagLessThanOrEqualTo(String value) {
            addCriterion("INSURE_FLAG <=", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagLike(String value) {
            addCriterion("INSURE_FLAG like", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotLike(String value) {
            addCriterion("INSURE_FLAG not like", value, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagIn(List<String> values) {
            addCriterion("INSURE_FLAG in", values, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotIn(List<String> values) {
            addCriterion("INSURE_FLAG not in", values, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagBetween(String value1, String value2) {
            addCriterion("INSURE_FLAG between", value1, value2, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andInsureFlagNotBetween(String value1, String value2) {
            addCriterion("INSURE_FLAG not between", value1, value2, "insureFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagIsNull() {
            addCriterion("FACTOR_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFactorFlagIsNotNull() {
            addCriterion("FACTOR_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFactorFlagEqualTo(String value) {
            addCriterion("FACTOR_FLAG =", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotEqualTo(String value) {
            addCriterion("FACTOR_FLAG <>", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagGreaterThan(String value) {
            addCriterion("FACTOR_FLAG >", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FACTOR_FLAG >=", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagLessThan(String value) {
            addCriterion("FACTOR_FLAG <", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagLessThanOrEqualTo(String value) {
            addCriterion("FACTOR_FLAG <=", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagLike(String value) {
            addCriterion("FACTOR_FLAG like", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotLike(String value) {
            addCriterion("FACTOR_FLAG not like", value, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagIn(List<String> values) {
            addCriterion("FACTOR_FLAG in", values, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotIn(List<String> values) {
            addCriterion("FACTOR_FLAG not in", values, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagBetween(String value1, String value2) {
            addCriterion("FACTOR_FLAG between", value1, value2, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andFactorFlagNotBetween(String value1, String value2) {
            addCriterion("FACTOR_FLAG not between", value1, value2, "factorFlag");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdIsNull() {
            addCriterion("CCMS_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdIsNotNull() {
            addCriterion("CCMS_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdEqualTo(String value) {
            addCriterion("CCMS_CUSTCD =", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotEqualTo(String value) {
            addCriterion("CCMS_CUSTCD <>", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdGreaterThan(String value) {
            addCriterion("CCMS_CUSTCD >", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CCMS_CUSTCD >=", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdLessThan(String value) {
            addCriterion("CCMS_CUSTCD <", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdLessThanOrEqualTo(String value) {
            addCriterion("CCMS_CUSTCD <=", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdLike(String value) {
            addCriterion("CCMS_CUSTCD like", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotLike(String value) {
            addCriterion("CCMS_CUSTCD not like", value, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdIn(List<String> values) {
            addCriterion("CCMS_CUSTCD in", values, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotIn(List<String> values) {
            addCriterion("CCMS_CUSTCD not in", values, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdBetween(String value1, String value2) {
            addCriterion("CCMS_CUSTCD between", value1, value2, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andCcmsCustcdNotBetween(String value1, String value2) {
            addCriterion("CCMS_CUSTCD not between", value1, value2, "ccmsCustcd");
            return (Criteria) this;
        }

        public Criteria andImportantFlagIsNull() {
            addCriterion("IMPORTANT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andImportantFlagIsNotNull() {
            addCriterion("IMPORTANT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andImportantFlagEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG =", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG <>", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagGreaterThan(String value) {
            addCriterion("IMPORTANT_FLAG >", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagGreaterThanOrEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG >=", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagLessThan(String value) {
            addCriterion("IMPORTANT_FLAG <", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagLessThanOrEqualTo(String value) {
            addCriterion("IMPORTANT_FLAG <=", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagLike(String value) {
            addCriterion("IMPORTANT_FLAG like", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotLike(String value) {
            addCriterion("IMPORTANT_FLAG not like", value, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagIn(List<String> values) {
            addCriterion("IMPORTANT_FLAG in", values, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotIn(List<String> values) {
            addCriterion("IMPORTANT_FLAG not in", values, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagBetween(String value1, String value2) {
            addCriterion("IMPORTANT_FLAG between", value1, value2, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andImportantFlagNotBetween(String value1, String value2) {
            addCriterion("IMPORTANT_FLAG not between", value1, value2, "importantFlag");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgIsNull() {
            addCriterion("COMMERCIAL_FALG is null");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgIsNotNull() {
            addCriterion("COMMERCIAL_FALG is not null");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG =", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG <>", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgGreaterThan(String value) {
            addCriterion("COMMERCIAL_FALG >", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgGreaterThanOrEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG >=", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgLessThan(String value) {
            addCriterion("COMMERCIAL_FALG <", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgLessThanOrEqualTo(String value) {
            addCriterion("COMMERCIAL_FALG <=", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgLike(String value) {
            addCriterion("COMMERCIAL_FALG like", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotLike(String value) {
            addCriterion("COMMERCIAL_FALG not like", value, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgIn(List<String> values) {
            addCriterion("COMMERCIAL_FALG in", values, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotIn(List<String> values) {
            addCriterion("COMMERCIAL_FALG not in", values, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgBetween(String value1, String value2) {
            addCriterion("COMMERCIAL_FALG between", value1, value2, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andCommercialFalgNotBetween(String value1, String value2) {
            addCriterion("COMMERCIAL_FALG not between", value1, value2, "commercialFalg");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagIsNull() {
            addCriterion("OVERSEAS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagIsNotNull() {
            addCriterion("OVERSEAS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG =", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG <>", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagGreaterThan(String value) {
            addCriterion("OVERSEAS_FLAG >", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagGreaterThanOrEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG >=", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagLessThan(String value) {
            addCriterion("OVERSEAS_FLAG <", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagLessThanOrEqualTo(String value) {
            addCriterion("OVERSEAS_FLAG <=", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagLike(String value) {
            addCriterion("OVERSEAS_FLAG like", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotLike(String value) {
            addCriterion("OVERSEAS_FLAG not like", value, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagIn(List<String> values) {
            addCriterion("OVERSEAS_FLAG in", values, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotIn(List<String> values) {
            addCriterion("OVERSEAS_FLAG not in", values, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagBetween(String value1, String value2) {
            addCriterion("OVERSEAS_FLAG between", value1, value2, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andOverseasFlagNotBetween(String value1, String value2) {
            addCriterion("OVERSEAS_FLAG not between", value1, value2, "overseasFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagIsNull() {
            addCriterion("BANKS_CUST_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagIsNotNull() {
            addCriterion("BANKS_CUST_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG =", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG <>", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagGreaterThan(String value) {
            addCriterion("BANKS_CUST_FLAG >", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG >=", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagLessThan(String value) {
            addCriterion("BANKS_CUST_FLAG <", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagLessThanOrEqualTo(String value) {
            addCriterion("BANKS_CUST_FLAG <=", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagLike(String value) {
            addCriterion("BANKS_CUST_FLAG like", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotLike(String value) {
            addCriterion("BANKS_CUST_FLAG not like", value, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagIn(List<String> values) {
            addCriterion("BANKS_CUST_FLAG in", values, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotIn(List<String> values) {
            addCriterion("BANKS_CUST_FLAG not in", values, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagBetween(String value1, String value2) {
            addCriterion("BANKS_CUST_FLAG between", value1, value2, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andBanksCustFlagNotBetween(String value1, String value2) {
            addCriterion("BANKS_CUST_FLAG not between", value1, value2, "banksCustFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagIsNull() {
            addCriterion("EF_BUYER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagIsNotNull() {
            addCriterion("EF_BUYER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG =", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG <>", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagGreaterThan(String value) {
            addCriterion("EF_BUYER_FLAG >", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagGreaterThanOrEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG >=", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagLessThan(String value) {
            addCriterion("EF_BUYER_FLAG <", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagLessThanOrEqualTo(String value) {
            addCriterion("EF_BUYER_FLAG <=", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagLike(String value) {
            addCriterion("EF_BUYER_FLAG like", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotLike(String value) {
            addCriterion("EF_BUYER_FLAG not like", value, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagIn(List<String> values) {
            addCriterion("EF_BUYER_FLAG in", values, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotIn(List<String> values) {
            addCriterion("EF_BUYER_FLAG not in", values, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagBetween(String value1, String value2) {
            addCriterion("EF_BUYER_FLAG between", value1, value2, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andEfBuyerFlagNotBetween(String value1, String value2) {
            addCriterion("EF_BUYER_FLAG not between", value1, value2, "efBuyerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagIsNull() {
            addCriterion("IF_SELLER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagIsNotNull() {
            addCriterion("IF_SELLER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG =", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG <>", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagGreaterThan(String value) {
            addCriterion("IF_SELLER_FLAG >", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagGreaterThanOrEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG >=", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagLessThan(String value) {
            addCriterion("IF_SELLER_FLAG <", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagLessThanOrEqualTo(String value) {
            addCriterion("IF_SELLER_FLAG <=", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagLike(String value) {
            addCriterion("IF_SELLER_FLAG like", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotLike(String value) {
            addCriterion("IF_SELLER_FLAG not like", value, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagIn(List<String> values) {
            addCriterion("IF_SELLER_FLAG in", values, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotIn(List<String> values) {
            addCriterion("IF_SELLER_FLAG not in", values, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagBetween(String value1, String value2) {
            addCriterion("IF_SELLER_FLAG between", value1, value2, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIfSellerFlagNotBetween(String value1, String value2) {
            addCriterion("IF_SELLER_FLAG not between", value1, value2, "ifSellerFlag");
            return (Criteria) this;
        }

        public Criteria andIsBankIsNull() {
            addCriterion("IS_BANK is null");
            return (Criteria) this;
        }

        public Criteria andIsBankIsNotNull() {
            addCriterion("IS_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andIsBankEqualTo(String value) {
            addCriterion("IS_BANK =", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotEqualTo(String value) {
            addCriterion("IS_BANK <>", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankGreaterThan(String value) {
            addCriterion("IS_BANK >", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BANK >=", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankLessThan(String value) {
            addCriterion("IS_BANK <", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankLessThanOrEqualTo(String value) {
            addCriterion("IS_BANK <=", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankLike(String value) {
            addCriterion("IS_BANK like", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotLike(String value) {
            addCriterion("IS_BANK not like", value, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankIn(List<String> values) {
            addCriterion("IS_BANK in", values, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotIn(List<String> values) {
            addCriterion("IS_BANK not in", values, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankBetween(String value1, String value2) {
            addCriterion("IS_BANK between", value1, value2, "isBank");
            return (Criteria) this;
        }

        public Criteria andIsBankNotBetween(String value1, String value2) {
            addCriterion("IS_BANK not between", value1, value2, "isBank");
            return (Criteria) this;
        }

        public Criteria andFciCodeIsNull() {
            addCriterion("FCI_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFciCodeIsNotNull() {
            addCriterion("FCI_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFciCodeEqualTo(String value) {
            addCriterion("FCI_CODE =", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotEqualTo(String value) {
            addCriterion("FCI_CODE <>", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeGreaterThan(String value) {
            addCriterion("FCI_CODE >", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FCI_CODE >=", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeLessThan(String value) {
            addCriterion("FCI_CODE <", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeLessThanOrEqualTo(String value) {
            addCriterion("FCI_CODE <=", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeLike(String value) {
            addCriterion("FCI_CODE like", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotLike(String value) {
            addCriterion("FCI_CODE not like", value, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeIn(List<String> values) {
            addCriterion("FCI_CODE in", values, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotIn(List<String> values) {
            addCriterion("FCI_CODE not in", values, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeBetween(String value1, String value2) {
            addCriterion("FCI_CODE between", value1, value2, "fciCode");
            return (Criteria) this;
        }

        public Criteria andFciCodeNotBetween(String value1, String value2) {
            addCriterion("FCI_CODE not between", value1, value2, "fciCode");
            return (Criteria) this;
        }

        public Criteria andIsIntlIsNull() {
            addCriterion("IS_INTL is null");
            return (Criteria) this;
        }

        public Criteria andIsIntlIsNotNull() {
            addCriterion("IS_INTL is not null");
            return (Criteria) this;
        }

        public Criteria andIsIntlEqualTo(String value) {
            addCriterion("IS_INTL =", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotEqualTo(String value) {
            addCriterion("IS_INTL <>", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlGreaterThan(String value) {
            addCriterion("IS_INTL >", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlGreaterThanOrEqualTo(String value) {
            addCriterion("IS_INTL >=", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlLessThan(String value) {
            addCriterion("IS_INTL <", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlLessThanOrEqualTo(String value) {
            addCriterion("IS_INTL <=", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlLike(String value) {
            addCriterion("IS_INTL like", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotLike(String value) {
            addCriterion("IS_INTL not like", value, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlIn(List<String> values) {
            addCriterion("IS_INTL in", values, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotIn(List<String> values) {
            addCriterion("IS_INTL not in", values, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlBetween(String value1, String value2) {
            addCriterion("IS_INTL between", value1, value2, "isIntl");
            return (Criteria) this;
        }

        public Criteria andIsIntlNotBetween(String value1, String value2) {
            addCriterion("IS_INTL not between", value1, value2, "isIntl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNull() {
            addCriterion("ENTERPRISE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNotNull() {
            addCriterion("ENTERPRISE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE =", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE <>", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThan(String value) {
            addCriterion("ENTERPRISE_TYPE >", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE >=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThan(String value) {
            addCriterion("ENTERPRISE_TYPE <", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE <=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLike(String value) {
            addCriterion("ENTERPRISE_TYPE like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotLike(String value) {
            addCriterion("ENTERPRISE_TYPE not like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIn(List<String> values) {
            addCriterion("ENTERPRISE_TYPE in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotIn(List<String> values) {
            addCriterion("ENTERPRISE_TYPE not in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_TYPE between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_TYPE not between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNull() {
            addCriterion("INDUSTRY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNotNull() {
            addCriterion("INDUSTRY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE =", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE <>", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThan(String value) {
            addCriterion("INDUSTRY_TYPE >", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE >=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThan(String value) {
            addCriterion("INDUSTRY_TYPE <", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE <=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLike(String value) {
            addCriterion("INDUSTRY_TYPE like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotLike(String value) {
            addCriterion("INDUSTRY_TYPE not like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE not in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE not between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeIsNull() {
            addCriterion("ENTERPRISE_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeIsNotNull() {
            addCriterion("ENTERPRISE_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE =", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE <>", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeGreaterThan(String value) {
            addCriterion("ENTERPRISE_SCOPE >", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE >=", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeLessThan(String value) {
            addCriterion("ENTERPRISE_SCOPE <", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_SCOPE <=", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeLike(String value) {
            addCriterion("ENTERPRISE_SCOPE like", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotLike(String value) {
            addCriterion("ENTERPRISE_SCOPE not like", value, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeIn(List<String> values) {
            addCriterion("ENTERPRISE_SCOPE in", values, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotIn(List<String> values) {
            addCriterion("ENTERPRISE_SCOPE not in", values, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_SCOPE between", value1, value2, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScopeNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_SCOPE not between", value1, value2, "enterpriseScope");
            return (Criteria) this;
        }

        public Criteria andCustLevelIsNull() {
            addCriterion("CUST_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCustLevelIsNotNull() {
            addCriterion("CUST_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCustLevelEqualTo(String value) {
            addCriterion("CUST_LEVEL =", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotEqualTo(String value) {
            addCriterion("CUST_LEVEL <>", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelGreaterThan(String value) {
            addCriterion("CUST_LEVEL >", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_LEVEL >=", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLessThan(String value) {
            addCriterion("CUST_LEVEL <", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLessThanOrEqualTo(String value) {
            addCriterion("CUST_LEVEL <=", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLike(String value) {
            addCriterion("CUST_LEVEL like", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotLike(String value) {
            addCriterion("CUST_LEVEL not like", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelIn(List<String> values) {
            addCriterion("CUST_LEVEL in", values, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotIn(List<String> values) {
            addCriterion("CUST_LEVEL not in", values, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelBetween(String value1, String value2) {
            addCriterion("CUST_LEVEL between", value1, value2, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotBetween(String value1, String value2) {
            addCriterion("CUST_LEVEL not between", value1, value2, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelIsNull() {
            addCriterion("CORE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCoreLevelIsNotNull() {
            addCriterion("CORE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCoreLevelEqualTo(String value) {
            addCriterion("CORE_LEVEL =", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotEqualTo(String value) {
            addCriterion("CORE_LEVEL <>", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelGreaterThan(String value) {
            addCriterion("CORE_LEVEL >", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_LEVEL >=", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelLessThan(String value) {
            addCriterion("CORE_LEVEL <", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelLessThanOrEqualTo(String value) {
            addCriterion("CORE_LEVEL <=", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelLike(String value) {
            addCriterion("CORE_LEVEL like", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotLike(String value) {
            addCriterion("CORE_LEVEL not like", value, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelIn(List<String> values) {
            addCriterion("CORE_LEVEL in", values, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotIn(List<String> values) {
            addCriterion("CORE_LEVEL not in", values, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelBetween(String value1, String value2) {
            addCriterion("CORE_LEVEL between", value1, value2, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andCoreLevelNotBetween(String value1, String value2) {
            addCriterion("CORE_LEVEL not between", value1, value2, "coreLevel");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionIsNull() {
            addCriterion("SUPPLY_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionIsNotNull() {
            addCriterion("SUPPLY_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionEqualTo(String value) {
            addCriterion("SUPPLY_POSITION =", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotEqualTo(String value) {
            addCriterion("SUPPLY_POSITION <>", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionGreaterThan(String value) {
            addCriterion("SUPPLY_POSITION >", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLY_POSITION >=", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionLessThan(String value) {
            addCriterion("SUPPLY_POSITION <", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionLessThanOrEqualTo(String value) {
            addCriterion("SUPPLY_POSITION <=", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionLike(String value) {
            addCriterion("SUPPLY_POSITION like", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotLike(String value) {
            addCriterion("SUPPLY_POSITION not like", value, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionIn(List<String> values) {
            addCriterion("SUPPLY_POSITION in", values, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotIn(List<String> values) {
            addCriterion("SUPPLY_POSITION not in", values, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionBetween(String value1, String value2) {
            addCriterion("SUPPLY_POSITION between", value1, value2, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andSupplyPositionNotBetween(String value1, String value2) {
            addCriterion("SUPPLY_POSITION not between", value1, value2, "supplyPosition");
            return (Criteria) this;
        }

        public Criteria andBrnameIsNull() {
            addCriterion("BRNAME is null");
            return (Criteria) this;
        }

        public Criteria andBrnameIsNotNull() {
            addCriterion("BRNAME is not null");
            return (Criteria) this;
        }

        public Criteria andBrnameEqualTo(String value) {
            addCriterion("BRNAME =", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotEqualTo(String value) {
            addCriterion("BRNAME <>", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameGreaterThan(String value) {
            addCriterion("BRNAME >", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameGreaterThanOrEqualTo(String value) {
            addCriterion("BRNAME >=", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameLessThan(String value) {
            addCriterion("BRNAME <", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameLessThanOrEqualTo(String value) {
            addCriterion("BRNAME <=", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameLike(String value) {
            addCriterion("BRNAME like", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotLike(String value) {
            addCriterion("BRNAME not like", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameIn(List<String> values) {
            addCriterion("BRNAME in", values, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotIn(List<String> values) {
            addCriterion("BRNAME not in", values, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameBetween(String value1, String value2) {
            addCriterion("BRNAME between", value1, value2, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotBetween(String value1, String value2) {
            addCriterion("BRNAME not between", value1, value2, "brname");
            return (Criteria) this;
        }

        public Criteria andBrclassIsNull() {
            addCriterion("BRCLASS is null");
            return (Criteria) this;
        }

        public Criteria andBrclassIsNotNull() {
            addCriterion("BRCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andBrclassEqualTo(String value) {
            addCriterion("BRCLASS =", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotEqualTo(String value) {
            addCriterion("BRCLASS <>", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassGreaterThan(String value) {
            addCriterion("BRCLASS >", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassGreaterThanOrEqualTo(String value) {
            addCriterion("BRCLASS >=", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassLessThan(String value) {
            addCriterion("BRCLASS <", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassLessThanOrEqualTo(String value) {
            addCriterion("BRCLASS <=", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassLike(String value) {
            addCriterion("BRCLASS like", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotLike(String value) {
            addCriterion("BRCLASS not like", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassIn(List<String> values) {
            addCriterion("BRCLASS in", values, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotIn(List<String> values) {
            addCriterion("BRCLASS not in", values, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassBetween(String value1, String value2) {
            addCriterion("BRCLASS between", value1, value2, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotBetween(String value1, String value2) {
            addCriterion("BRCLASS not between", value1, value2, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrnameBussIsNull() {
            addCriterion("BRNAME_BUSS is null");
            return (Criteria) this;
        }

        public Criteria andBrnameBussIsNotNull() {
            addCriterion("BRNAME_BUSS is not null");
            return (Criteria) this;
        }

        public Criteria andBrnameBussEqualTo(String value) {
            addCriterion("BRNAME_BUSS =", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussNotEqualTo(String value) {
            addCriterion("BRNAME_BUSS <>", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussGreaterThan(String value) {
            addCriterion("BRNAME_BUSS >", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussGreaterThanOrEqualTo(String value) {
            addCriterion("BRNAME_BUSS >=", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussLessThan(String value) {
            addCriterion("BRNAME_BUSS <", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussLessThanOrEqualTo(String value) {
            addCriterion("BRNAME_BUSS <=", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussLike(String value) {
            addCriterion("BRNAME_BUSS like", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussNotLike(String value) {
            addCriterion("BRNAME_BUSS not like", value, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussIn(List<String> values) {
            addCriterion("BRNAME_BUSS in", values, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussNotIn(List<String> values) {
            addCriterion("BRNAME_BUSS not in", values, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussBetween(String value1, String value2) {
            addCriterion("BRNAME_BUSS between", value1, value2, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andBrnameBussNotBetween(String value1, String value2) {
            addCriterion("BRNAME_BUSS not between", value1, value2, "brnameBuss");
            return (Criteria) this;
        }

        public Criteria andTlrNameIsNull() {
            addCriterion("TLR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTlrNameIsNotNull() {
            addCriterion("TLR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTlrNameEqualTo(String value) {
            addCriterion("TLR_NAME =", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameNotEqualTo(String value) {
            addCriterion("TLR_NAME <>", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameGreaterThan(String value) {
            addCriterion("TLR_NAME >", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameGreaterThanOrEqualTo(String value) {
            addCriterion("TLR_NAME >=", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameLessThan(String value) {
            addCriterion("TLR_NAME <", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameLessThanOrEqualTo(String value) {
            addCriterion("TLR_NAME <=", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameLike(String value) {
            addCriterion("TLR_NAME like", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameNotLike(String value) {
            addCriterion("TLR_NAME not like", value, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameIn(List<String> values) {
            addCriterion("TLR_NAME in", values, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameNotIn(List<String> values) {
            addCriterion("TLR_NAME not in", values, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameBetween(String value1, String value2) {
            addCriterion("TLR_NAME between", value1, value2, "tlrName");
            return (Criteria) this;
        }

        public Criteria andTlrNameNotBetween(String value1, String value2) {
            addCriterion("TLR_NAME not between", value1, value2, "tlrName");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andDebtContnoIsNull() {
            addCriterion("DEBT_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andDebtContnoIsNotNull() {
            addCriterion("DEBT_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andDebtContnoEqualTo(String value) {
            addCriterion("DEBT_CONTNO =", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoNotEqualTo(String value) {
            addCriterion("DEBT_CONTNO <>", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoGreaterThan(String value) {
            addCriterion("DEBT_CONTNO >", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoGreaterThanOrEqualTo(String value) {
            addCriterion("DEBT_CONTNO >=", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoLessThan(String value) {
            addCriterion("DEBT_CONTNO <", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoLessThanOrEqualTo(String value) {
            addCriterion("DEBT_CONTNO <=", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoLike(String value) {
            addCriterion("DEBT_CONTNO like", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoNotLike(String value) {
            addCriterion("DEBT_CONTNO not like", value, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoIn(List<String> values) {
            addCriterion("DEBT_CONTNO in", values, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoNotIn(List<String> values) {
            addCriterion("DEBT_CONTNO not in", values, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoBetween(String value1, String value2) {
            addCriterion("DEBT_CONTNO between", value1, value2, "debtContno");
            return (Criteria) this;
        }

        public Criteria andDebtContnoNotBetween(String value1, String value2) {
            addCriterion("DEBT_CONTNO not between", value1, value2, "debtContno");
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

        public Criteria andFactTypeIsNull() {
            addCriterion("FACT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFactTypeIsNotNull() {
            addCriterion("FACT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFactTypeEqualTo(String value) {
            addCriterion("FACT_TYPE =", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotEqualTo(String value) {
            addCriterion("FACT_TYPE <>", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeGreaterThan(String value) {
            addCriterion("FACT_TYPE >", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FACT_TYPE >=", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeLessThan(String value) {
            addCriterion("FACT_TYPE <", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeLessThanOrEqualTo(String value) {
            addCriterion("FACT_TYPE <=", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeLike(String value) {
            addCriterion("FACT_TYPE like", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotLike(String value) {
            addCriterion("FACT_TYPE not like", value, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeIn(List<String> values) {
            addCriterion("FACT_TYPE in", values, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotIn(List<String> values) {
            addCriterion("FACT_TYPE not in", values, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeBetween(String value1, String value2) {
            addCriterion("FACT_TYPE between", value1, value2, "factType");
            return (Criteria) this;
        }

        public Criteria andFactTypeNotBetween(String value1, String value2) {
            addCriterion("FACT_TYPE not between", value1, value2, "factType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeIsNull() {
            addCriterion("FINANCING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeIsNotNull() {
            addCriterion("FINANCING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeEqualTo(String value) {
            addCriterion("FINANCING_TYPE =", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotEqualTo(String value) {
            addCriterion("FINANCING_TYPE <>", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeGreaterThan(String value) {
            addCriterion("FINANCING_TYPE >", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FINANCING_TYPE >=", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeLessThan(String value) {
            addCriterion("FINANCING_TYPE <", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeLessThanOrEqualTo(String value) {
            addCriterion("FINANCING_TYPE <=", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeLike(String value) {
            addCriterion("FINANCING_TYPE like", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotLike(String value) {
            addCriterion("FINANCING_TYPE not like", value, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeIn(List<String> values) {
            addCriterion("FINANCING_TYPE in", values, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotIn(List<String> values) {
            addCriterion("FINANCING_TYPE not in", values, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeBetween(String value1, String value2) {
            addCriterion("FINANCING_TYPE between", value1, value2, "financingType");
            return (Criteria) this;
        }

        public Criteria andFinancingTypeNotBetween(String value1, String value2) {
            addCriterion("FINANCING_TYPE not between", value1, value2, "financingType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("CHARGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("CHARGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(String value) {
            addCriterion("CHARGE_TYPE =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(String value) {
            addCriterion("CHARGE_TYPE <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(String value) {
            addCriterion("CHARGE_TYPE >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGE_TYPE >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(String value) {
            addCriterion("CHARGE_TYPE <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(String value) {
            addCriterion("CHARGE_TYPE <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLike(String value) {
            addCriterion("CHARGE_TYPE like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotLike(String value) {
            addCriterion("CHARGE_TYPE not like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<String> values) {
            addCriterion("CHARGE_TYPE in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<String> values) {
            addCriterion("CHARGE_TYPE not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(String value1, String value2) {
            addCriterion("CHARGE_TYPE between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(String value1, String value2) {
            addCriterion("CHARGE_TYPE not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNull() {
            addCriterion("NOTICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNotNull() {
            addCriterion("NOTICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeEqualTo(String value) {
            addCriterion("NOTICE_TYPE =", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotEqualTo(String value) {
            addCriterion("NOTICE_TYPE <>", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThan(String value) {
            addCriterion("NOTICE_TYPE >", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE >=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThan(String value) {
            addCriterion("NOTICE_TYPE <", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE <=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLike(String value) {
            addCriterion("NOTICE_TYPE like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotLike(String value) {
            addCriterion("NOTICE_TYPE not like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIn(List<String> values) {
            addCriterion("NOTICE_TYPE in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotIn(List<String> values) {
            addCriterion("NOTICE_TYPE not in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE not between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayIsNull() {
            addCriterion("IS_AUTO_PAY is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayIsNotNull() {
            addCriterion("IS_AUTO_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayEqualTo(String value) {
            addCriterion("IS_AUTO_PAY =", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayNotEqualTo(String value) {
            addCriterion("IS_AUTO_PAY <>", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayGreaterThan(String value) {
            addCriterion("IS_AUTO_PAY >", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayGreaterThanOrEqualTo(String value) {
            addCriterion("IS_AUTO_PAY >=", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayLessThan(String value) {
            addCriterion("IS_AUTO_PAY <", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayLessThanOrEqualTo(String value) {
            addCriterion("IS_AUTO_PAY <=", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayLike(String value) {
            addCriterion("IS_AUTO_PAY like", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayNotLike(String value) {
            addCriterion("IS_AUTO_PAY not like", value, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayIn(List<String> values) {
            addCriterion("IS_AUTO_PAY in", values, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayNotIn(List<String> values) {
            addCriterion("IS_AUTO_PAY not in", values, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayBetween(String value1, String value2) {
            addCriterion("IS_AUTO_PAY between", value1, value2, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andIsAutoPayNotBetween(String value1, String value2) {
            addCriterion("IS_AUTO_PAY not between", value1, value2, "isAutoPay");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysIsNull() {
            addCriterion("AUTO_PAY_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysIsNotNull() {
            addCriterion("AUTO_PAY_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysEqualTo(BigDecimal value) {
            addCriterion("AUTO_PAY_DAYS =", value, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysNotEqualTo(BigDecimal value) {
            addCriterion("AUTO_PAY_DAYS <>", value, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysGreaterThan(BigDecimal value) {
            addCriterion("AUTO_PAY_DAYS >", value, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AUTO_PAY_DAYS >=", value, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysLessThan(BigDecimal value) {
            addCriterion("AUTO_PAY_DAYS <", value, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AUTO_PAY_DAYS <=", value, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysIn(List<BigDecimal> values) {
            addCriterion("AUTO_PAY_DAYS in", values, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysNotIn(List<BigDecimal> values) {
            addCriterion("AUTO_PAY_DAYS not in", values, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AUTO_PAY_DAYS between", value1, value2, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andAutoPayDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AUTO_PAY_DAYS not between", value1, value2, "autoPayDays");
            return (Criteria) this;
        }

        public Criteria andServiceContentIsNull() {
            addCriterion("SERVICE_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andServiceContentIsNotNull() {
            addCriterion("SERVICE_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andServiceContentEqualTo(String value) {
            addCriterion("SERVICE_CONTENT =", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotEqualTo(String value) {
            addCriterion("SERVICE_CONTENT <>", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentGreaterThan(String value) {
            addCriterion("SERVICE_CONTENT >", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_CONTENT >=", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLessThan(String value) {
            addCriterion("SERVICE_CONTENT <", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_CONTENT <=", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLike(String value) {
            addCriterion("SERVICE_CONTENT like", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotLike(String value) {
            addCriterion("SERVICE_CONTENT not like", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentIn(List<String> values) {
            addCriterion("SERVICE_CONTENT in", values, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotIn(List<String> values) {
            addCriterion("SERVICE_CONTENT not in", values, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentBetween(String value1, String value2) {
            addCriterion("SERVICE_CONTENT between", value1, value2, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotBetween(String value1, String value2) {
            addCriterion("SERVICE_CONTENT not between", value1, value2, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIsNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIsNotNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID =", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <>", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID not like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID not in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID not between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andCustcdContIsNull() {
            addCriterion("CUSTCD_CONT is null");
            return (Criteria) this;
        }

        public Criteria andCustcdContIsNotNull() {
            addCriterion("CUSTCD_CONT is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdContEqualTo(String value) {
            addCriterion("CUSTCD_CONT =", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContNotEqualTo(String value) {
            addCriterion("CUSTCD_CONT <>", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContGreaterThan(String value) {
            addCriterion("CUSTCD_CONT >", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD_CONT >=", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContLessThan(String value) {
            addCriterion("CUSTCD_CONT <", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD_CONT <=", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContLike(String value) {
            addCriterion("CUSTCD_CONT like", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContNotLike(String value) {
            addCriterion("CUSTCD_CONT not like", value, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContIn(List<String> values) {
            addCriterion("CUSTCD_CONT in", values, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContNotIn(List<String> values) {
            addCriterion("CUSTCD_CONT not in", values, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContBetween(String value1, String value2) {
            addCriterion("CUSTCD_CONT between", value1, value2, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCustcdContNotBetween(String value1, String value2) {
            addCriterion("CUSTCD_CONT not between", value1, value2, "custcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContIsNull() {
            addCriterion("CURCD_CONT is null");
            return (Criteria) this;
        }

        public Criteria andCurcdContIsNotNull() {
            addCriterion("CURCD_CONT is not null");
            return (Criteria) this;
        }

        public Criteria andCurcdContEqualTo(String value) {
            addCriterion("CURCD_CONT =", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContNotEqualTo(String value) {
            addCriterion("CURCD_CONT <>", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContGreaterThan(String value) {
            addCriterion("CURCD_CONT >", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContGreaterThanOrEqualTo(String value) {
            addCriterion("CURCD_CONT >=", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContLessThan(String value) {
            addCriterion("CURCD_CONT <", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContLessThanOrEqualTo(String value) {
            addCriterion("CURCD_CONT <=", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContLike(String value) {
            addCriterion("CURCD_CONT like", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContNotLike(String value) {
            addCriterion("CURCD_CONT not like", value, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContIn(List<String> values) {
            addCriterion("CURCD_CONT in", values, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContNotIn(List<String> values) {
            addCriterion("CURCD_CONT not in", values, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContBetween(String value1, String value2) {
            addCriterion("CURCD_CONT between", value1, value2, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andCurcdContNotBetween(String value1, String value2) {
            addCriterion("CURCD_CONT not between", value1, value2, "curcdCont");
            return (Criteria) this;
        }

        public Criteria andContAmountIsNull() {
            addCriterion("CONT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andContAmountIsNotNull() {
            addCriterion("CONT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andContAmountEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT =", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountNotEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT <>", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountGreaterThan(BigDecimal value) {
            addCriterion("CONT_AMOUNT >", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT >=", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountLessThan(BigDecimal value) {
            addCriterion("CONT_AMOUNT <", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_AMOUNT <=", value, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountIn(List<BigDecimal> values) {
            addCriterion("CONT_AMOUNT in", values, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountNotIn(List<BigDecimal> values) {
            addCriterion("CONT_AMOUNT not in", values, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_AMOUNT between", value1, value2, "contAmount");
            return (Criteria) this;
        }

        public Criteria andContAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_AMOUNT not between", value1, value2, "contAmount");
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

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("START_DATE not between", value1, value2, "startDate");
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

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE not between", value1, value2, "endDate");
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

        public Criteria andContStatusIsNull() {
            addCriterion("CONT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andContStatusIsNotNull() {
            addCriterion("CONT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andContStatusEqualTo(String value) {
            addCriterion("CONT_STATUS =", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotEqualTo(String value) {
            addCriterion("CONT_STATUS <>", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusGreaterThan(String value) {
            addCriterion("CONT_STATUS >", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_STATUS >=", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusLessThan(String value) {
            addCriterion("CONT_STATUS <", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusLessThanOrEqualTo(String value) {
            addCriterion("CONT_STATUS <=", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusLike(String value) {
            addCriterion("CONT_STATUS like", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotLike(String value) {
            addCriterion("CONT_STATUS not like", value, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusIn(List<String> values) {
            addCriterion("CONT_STATUS in", values, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotIn(List<String> values) {
            addCriterion("CONT_STATUS not in", values, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusBetween(String value1, String value2) {
            addCriterion("CONT_STATUS between", value1, value2, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContStatusNotBetween(String value1, String value2) {
            addCriterion("CONT_STATUS not between", value1, value2, "contStatus");
            return (Criteria) this;
        }

        public Criteria andContAccountNoIsNull() {
            addCriterion("CONT_ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andContAccountNoIsNotNull() {
            addCriterion("CONT_ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andContAccountNoEqualTo(String value) {
            addCriterion("CONT_ACCOUNT_NO =", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoNotEqualTo(String value) {
            addCriterion("CONT_ACCOUNT_NO <>", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoGreaterThan(String value) {
            addCriterion("CONT_ACCOUNT_NO >", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_ACCOUNT_NO >=", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoLessThan(String value) {
            addCriterion("CONT_ACCOUNT_NO <", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoLessThanOrEqualTo(String value) {
            addCriterion("CONT_ACCOUNT_NO <=", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoLike(String value) {
            addCriterion("CONT_ACCOUNT_NO like", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoNotLike(String value) {
            addCriterion("CONT_ACCOUNT_NO not like", value, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoIn(List<String> values) {
            addCriterion("CONT_ACCOUNT_NO in", values, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoNotIn(List<String> values) {
            addCriterion("CONT_ACCOUNT_NO not in", values, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoBetween(String value1, String value2) {
            addCriterion("CONT_ACCOUNT_NO between", value1, value2, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andContAccountNoNotBetween(String value1, String value2) {
            addCriterion("CONT_ACCOUNT_NO not between", value1, value2, "contAccountNo");
            return (Criteria) this;
        }

        public Criteria andMgrnoContIsNull() {
            addCriterion("MGRNO_CONT is null");
            return (Criteria) this;
        }

        public Criteria andMgrnoContIsNotNull() {
            addCriterion("MGRNO_CONT is not null");
            return (Criteria) this;
        }

        public Criteria andMgrnoContEqualTo(String value) {
            addCriterion("MGRNO_CONT =", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContNotEqualTo(String value) {
            addCriterion("MGRNO_CONT <>", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContGreaterThan(String value) {
            addCriterion("MGRNO_CONT >", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContGreaterThanOrEqualTo(String value) {
            addCriterion("MGRNO_CONT >=", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContLessThan(String value) {
            addCriterion("MGRNO_CONT <", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContLessThanOrEqualTo(String value) {
            addCriterion("MGRNO_CONT <=", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContLike(String value) {
            addCriterion("MGRNO_CONT like", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContNotLike(String value) {
            addCriterion("MGRNO_CONT not like", value, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContIn(List<String> values) {
            addCriterion("MGRNO_CONT in", values, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContNotIn(List<String> values) {
            addCriterion("MGRNO_CONT not in", values, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContBetween(String value1, String value2) {
            addCriterion("MGRNO_CONT between", value1, value2, "mgrnoCont");
            return (Criteria) this;
        }

        public Criteria andMgrnoContNotBetween(String value1, String value2) {
            addCriterion("MGRNO_CONT not between", value1, value2, "mgrnoCont");
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

        public Criteria andLastUpdTlrnoIsNull() {
            addCriterion("LAST_UPD_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoIsNotNull() {
            addCriterion("LAST_UPD_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoEqualTo(String value) {
            addCriterion("LAST_UPD_TLRNO =", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLRNO <>", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoGreaterThan(String value) {
            addCriterion("LAST_UPD_TLRNO >", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRNO >=", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoLessThan(String value) {
            addCriterion("LAST_UPD_TLRNO <", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLRNO <=", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoLike(String value) {
            addCriterion("LAST_UPD_TLRNO like", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoNotLike(String value) {
            addCriterion("LAST_UPD_TLRNO not like", value, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoIn(List<String> values) {
            addCriterion("LAST_UPD_TLRNO in", values, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLRNO not in", values, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRNO between", value1, value2, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrnoNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLRNO not between", value1, value2, "lastUpdTlrno");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNull() {
            addCriterion("LAST_UPD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNotNull() {
            addCriterion("LAST_UPD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE =", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE <>", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE >", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE >=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThan(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE <", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPD_DATE <=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_UPD_DATE in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_UPD_DATE not in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_UPD_DATE between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_UPD_DATE not between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andBrcodeContIsNull() {
            addCriterion("BRCODE_CONT is null");
            return (Criteria) this;
        }

        public Criteria andBrcodeContIsNotNull() {
            addCriterion("BRCODE_CONT is not null");
            return (Criteria) this;
        }

        public Criteria andBrcodeContEqualTo(String value) {
            addCriterion("BRCODE_CONT =", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContNotEqualTo(String value) {
            addCriterion("BRCODE_CONT <>", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContGreaterThan(String value) {
            addCriterion("BRCODE_CONT >", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContGreaterThanOrEqualTo(String value) {
            addCriterion("BRCODE_CONT >=", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContLessThan(String value) {
            addCriterion("BRCODE_CONT <", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContLessThanOrEqualTo(String value) {
            addCriterion("BRCODE_CONT <=", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContLike(String value) {
            addCriterion("BRCODE_CONT like", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContNotLike(String value) {
            addCriterion("BRCODE_CONT not like", value, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContIn(List<String> values) {
            addCriterion("BRCODE_CONT in", values, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContNotIn(List<String> values) {
            addCriterion("BRCODE_CONT not in", values, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContBetween(String value1, String value2) {
            addCriterion("BRCODE_CONT between", value1, value2, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBrcodeContNotBetween(String value1, String value2) {
            addCriterion("BRCODE_CONT not between", value1, value2, "brcodeCont");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoIsNull() {
            addCriterion("BAIL_ACCT_NO is null");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoIsNotNull() {
            addCriterion("BAIL_ACCT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoEqualTo(String value) {
            addCriterion("BAIL_ACCT_NO =", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoNotEqualTo(String value) {
            addCriterion("BAIL_ACCT_NO <>", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoGreaterThan(String value) {
            addCriterion("BAIL_ACCT_NO >", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCT_NO >=", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoLessThan(String value) {
            addCriterion("BAIL_ACCT_NO <", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACCT_NO <=", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoLike(String value) {
            addCriterion("BAIL_ACCT_NO like", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoNotLike(String value) {
            addCriterion("BAIL_ACCT_NO not like", value, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoIn(List<String> values) {
            addCriterion("BAIL_ACCT_NO in", values, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoNotIn(List<String> values) {
            addCriterion("BAIL_ACCT_NO not in", values, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoBetween(String value1, String value2) {
            addCriterion("BAIL_ACCT_NO between", value1, value2, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andBailAcctNoNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACCT_NO not between", value1, value2, "bailAcctNo");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountIsNull() {
            addCriterion("CONT_RETU_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountIsNotNull() {
            addCriterion("CONT_RETU_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountEqualTo(String value) {
            addCriterion("CONT_RETU_ACCOUNT =", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountNotEqualTo(String value) {
            addCriterion("CONT_RETU_ACCOUNT <>", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountGreaterThan(String value) {
            addCriterion("CONT_RETU_ACCOUNT >", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_RETU_ACCOUNT >=", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountLessThan(String value) {
            addCriterion("CONT_RETU_ACCOUNT <", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountLessThanOrEqualTo(String value) {
            addCriterion("CONT_RETU_ACCOUNT <=", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountLike(String value) {
            addCriterion("CONT_RETU_ACCOUNT like", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountNotLike(String value) {
            addCriterion("CONT_RETU_ACCOUNT not like", value, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountIn(List<String> values) {
            addCriterion("CONT_RETU_ACCOUNT in", values, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountNotIn(List<String> values) {
            addCriterion("CONT_RETU_ACCOUNT not in", values, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountBetween(String value1, String value2) {
            addCriterion("CONT_RETU_ACCOUNT between", value1, value2, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andContRetuAccountNotBetween(String value1, String value2) {
            addCriterion("CONT_RETU_ACCOUNT not between", value1, value2, "contRetuAccount");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeIsNull() {
            addCriterion("RECOVER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeIsNotNull() {
            addCriterion("RECOVER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeEqualTo(String value) {
            addCriterion("RECOVER_TYPE =", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotEqualTo(String value) {
            addCriterion("RECOVER_TYPE <>", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeGreaterThan(String value) {
            addCriterion("RECOVER_TYPE >", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RECOVER_TYPE >=", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeLessThan(String value) {
            addCriterion("RECOVER_TYPE <", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeLessThanOrEqualTo(String value) {
            addCriterion("RECOVER_TYPE <=", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeLike(String value) {
            addCriterion("RECOVER_TYPE like", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotLike(String value) {
            addCriterion("RECOVER_TYPE not like", value, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeIn(List<String> values) {
            addCriterion("RECOVER_TYPE in", values, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotIn(List<String> values) {
            addCriterion("RECOVER_TYPE not in", values, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeBetween(String value1, String value2) {
            addCriterion("RECOVER_TYPE between", value1, value2, "recoverType");
            return (Criteria) this;
        }

        public Criteria andRecoverTypeNotBetween(String value1, String value2) {
            addCriterion("RECOVER_TYPE not between", value1, value2, "recoverType");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeIsNull() {
            addCriterion("CONT_REPAY_PURPOSE is null");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeIsNotNull() {
            addCriterion("CONT_REPAY_PURPOSE is not null");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeEqualTo(String value) {
            addCriterion("CONT_REPAY_PURPOSE =", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeNotEqualTo(String value) {
            addCriterion("CONT_REPAY_PURPOSE <>", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeGreaterThan(String value) {
            addCriterion("CONT_REPAY_PURPOSE >", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_REPAY_PURPOSE >=", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeLessThan(String value) {
            addCriterion("CONT_REPAY_PURPOSE <", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeLessThanOrEqualTo(String value) {
            addCriterion("CONT_REPAY_PURPOSE <=", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeLike(String value) {
            addCriterion("CONT_REPAY_PURPOSE like", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeNotLike(String value) {
            addCriterion("CONT_REPAY_PURPOSE not like", value, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeIn(List<String> values) {
            addCriterion("CONT_REPAY_PURPOSE in", values, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeNotIn(List<String> values) {
            addCriterion("CONT_REPAY_PURPOSE not in", values, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeBetween(String value1, String value2) {
            addCriterion("CONT_REPAY_PURPOSE between", value1, value2, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andContRepayPurposeNotBetween(String value1, String value2) {
            addCriterion("CONT_REPAY_PURPOSE not between", value1, value2, "contRepayPurpose");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleIsNull() {
            addCriterion("DUE_BALANCE_RULE is null");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleIsNotNull() {
            addCriterion("DUE_BALANCE_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleEqualTo(String value) {
            addCriterion("DUE_BALANCE_RULE =", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleNotEqualTo(String value) {
            addCriterion("DUE_BALANCE_RULE <>", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleGreaterThan(String value) {
            addCriterion("DUE_BALANCE_RULE >", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleGreaterThanOrEqualTo(String value) {
            addCriterion("DUE_BALANCE_RULE >=", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleLessThan(String value) {
            addCriterion("DUE_BALANCE_RULE <", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleLessThanOrEqualTo(String value) {
            addCriterion("DUE_BALANCE_RULE <=", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleLike(String value) {
            addCriterion("DUE_BALANCE_RULE like", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleNotLike(String value) {
            addCriterion("DUE_BALANCE_RULE not like", value, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleIn(List<String> values) {
            addCriterion("DUE_BALANCE_RULE in", values, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleNotIn(List<String> values) {
            addCriterion("DUE_BALANCE_RULE not in", values, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleBetween(String value1, String value2) {
            addCriterion("DUE_BALANCE_RULE between", value1, value2, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andDueBalanceRuleNotBetween(String value1, String value2) {
            addCriterion("DUE_BALANCE_RULE not between", value1, value2, "dueBalanceRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleIsNull() {
            addCriterion("PAYMENT_VERIFY_RULE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleIsNotNull() {
            addCriterion("PAYMENT_VERIFY_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleEqualTo(String value) {
            addCriterion("PAYMENT_VERIFY_RULE =", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleNotEqualTo(String value) {
            addCriterion("PAYMENT_VERIFY_RULE <>", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleGreaterThan(String value) {
            addCriterion("PAYMENT_VERIFY_RULE >", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_VERIFY_RULE >=", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleLessThan(String value) {
            addCriterion("PAYMENT_VERIFY_RULE <", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_VERIFY_RULE <=", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleLike(String value) {
            addCriterion("PAYMENT_VERIFY_RULE like", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleNotLike(String value) {
            addCriterion("PAYMENT_VERIFY_RULE not like", value, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleIn(List<String> values) {
            addCriterion("PAYMENT_VERIFY_RULE in", values, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleNotIn(List<String> values) {
            addCriterion("PAYMENT_VERIFY_RULE not in", values, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleBetween(String value1, String value2) {
            addCriterion("PAYMENT_VERIFY_RULE between", value1, value2, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andPaymentVerifyRuleNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_VERIFY_RULE not between", value1, value2, "paymentVerifyRule");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoIsNull() {
            addCriterion("REPARATION_PROT_NO is null");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoIsNotNull() {
            addCriterion("REPARATION_PROT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO =", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO <>", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoGreaterThan(String value) {
            addCriterion("REPARATION_PROT_NO >", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoGreaterThanOrEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO >=", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoLessThan(String value) {
            addCriterion("REPARATION_PROT_NO <", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoLessThanOrEqualTo(String value) {
            addCriterion("REPARATION_PROT_NO <=", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoLike(String value) {
            addCriterion("REPARATION_PROT_NO like", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotLike(String value) {
            addCriterion("REPARATION_PROT_NO not like", value, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoIn(List<String> values) {
            addCriterion("REPARATION_PROT_NO in", values, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotIn(List<String> values) {
            addCriterion("REPARATION_PROT_NO not in", values, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoBetween(String value1, String value2) {
            addCriterion("REPARATION_PROT_NO between", value1, value2, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andReparationProtNoNotBetween(String value1, String value2) {
            addCriterion("REPARATION_PROT_NO not between", value1, value2, "reparationProtNo");
            return (Criteria) this;
        }

        public Criteria andLeaseIsNull() {
            addCriterion("LEASE is null");
            return (Criteria) this;
        }

        public Criteria andLeaseIsNotNull() {
            addCriterion("LEASE is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEqualTo(String value) {
            addCriterion("LEASE =", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotEqualTo(String value) {
            addCriterion("LEASE <>", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseGreaterThan(String value) {
            addCriterion("LEASE >", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseGreaterThanOrEqualTo(String value) {
            addCriterion("LEASE >=", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseLessThan(String value) {
            addCriterion("LEASE <", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseLessThanOrEqualTo(String value) {
            addCriterion("LEASE <=", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseLike(String value) {
            addCriterion("LEASE like", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotLike(String value) {
            addCriterion("LEASE not like", value, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseIn(List<String> values) {
            addCriterion("LEASE in", values, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotIn(List<String> values) {
            addCriterion("LEASE not in", values, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseBetween(String value1, String value2) {
            addCriterion("LEASE between", value1, value2, "lease");
            return (Criteria) this;
        }

        public Criteria andLeaseNotBetween(String value1, String value2) {
            addCriterion("LEASE not between", value1, value2, "lease");
            return (Criteria) this;
        }

        public Criteria andRepurchaserIsNull() {
            addCriterion("REPURCHASER is null");
            return (Criteria) this;
        }

        public Criteria andRepurchaserIsNotNull() {
            addCriterion("REPURCHASER is not null");
            return (Criteria) this;
        }

        public Criteria andRepurchaserEqualTo(String value) {
            addCriterion("REPURCHASER =", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotEqualTo(String value) {
            addCriterion("REPURCHASER <>", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserGreaterThan(String value) {
            addCriterion("REPURCHASER >", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserGreaterThanOrEqualTo(String value) {
            addCriterion("REPURCHASER >=", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserLessThan(String value) {
            addCriterion("REPURCHASER <", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserLessThanOrEqualTo(String value) {
            addCriterion("REPURCHASER <=", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserLike(String value) {
            addCriterion("REPURCHASER like", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotLike(String value) {
            addCriterion("REPURCHASER not like", value, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserIn(List<String> values) {
            addCriterion("REPURCHASER in", values, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotIn(List<String> values) {
            addCriterion("REPURCHASER not in", values, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserBetween(String value1, String value2) {
            addCriterion("REPURCHASER between", value1, value2, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaserNotBetween(String value1, String value2) {
            addCriterion("REPURCHASER not between", value1, value2, "repurchaser");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoIsNull() {
            addCriterion("REPURCHASE_PROT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoIsNotNull() {
            addCriterion("REPURCHASE_PROT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO =", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO <>", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoGreaterThan(String value) {
            addCriterion("REPURCHASE_PROT_NO >", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoGreaterThanOrEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO >=", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoLessThan(String value) {
            addCriterion("REPURCHASE_PROT_NO <", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoLessThanOrEqualTo(String value) {
            addCriterion("REPURCHASE_PROT_NO <=", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoLike(String value) {
            addCriterion("REPURCHASE_PROT_NO like", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotLike(String value) {
            addCriterion("REPURCHASE_PROT_NO not like", value, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoIn(List<String> values) {
            addCriterion("REPURCHASE_PROT_NO in", values, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotIn(List<String> values) {
            addCriterion("REPURCHASE_PROT_NO not in", values, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoBetween(String value1, String value2) {
            addCriterion("REPURCHASE_PROT_NO between", value1, value2, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseProtNoNotBetween(String value1, String value2) {
            addCriterion("REPURCHASE_PROT_NO not between", value1, value2, "repurchaseProtNo");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeIsNull() {
            addCriterion("FACTORING_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeIsNotNull() {
            addCriterion("FACTORING_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeEqualTo(String value) {
            addCriterion("FACTORING_BRCODE =", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotEqualTo(String value) {
            addCriterion("FACTORING_BRCODE <>", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeGreaterThan(String value) {
            addCriterion("FACTORING_BRCODE >", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("FACTORING_BRCODE >=", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeLessThan(String value) {
            addCriterion("FACTORING_BRCODE <", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeLessThanOrEqualTo(String value) {
            addCriterion("FACTORING_BRCODE <=", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeLike(String value) {
            addCriterion("FACTORING_BRCODE like", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotLike(String value) {
            addCriterion("FACTORING_BRCODE not like", value, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeIn(List<String> values) {
            addCriterion("FACTORING_BRCODE in", values, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotIn(List<String> values) {
            addCriterion("FACTORING_BRCODE not in", values, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeBetween(String value1, String value2) {
            addCriterion("FACTORING_BRCODE between", value1, value2, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andFactoringBrcodeNotBetween(String value1, String value2) {
            addCriterion("FACTORING_BRCODE not between", value1, value2, "factoringBrcode");
            return (Criteria) this;
        }

        public Criteria andReparationTermIsNull() {
            addCriterion("REPARATION_TERM is null");
            return (Criteria) this;
        }

        public Criteria andReparationTermIsNotNull() {
            addCriterion("REPARATION_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andReparationTermEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM =", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermNotEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM <>", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermGreaterThan(BigDecimal value) {
            addCriterion("REPARATION_TERM >", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM >=", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermLessThan(BigDecimal value) {
            addCriterion("REPARATION_TERM <", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_TERM <=", value, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermIn(List<BigDecimal> values) {
            addCriterion("REPARATION_TERM in", values, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermNotIn(List<BigDecimal> values) {
            addCriterion("REPARATION_TERM not in", values, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_TERM between", value1, value2, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationTermNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_TERM not between", value1, value2, "reparationTerm");
            return (Criteria) this;
        }

        public Criteria andReparationPercentIsNull() {
            addCriterion("REPARATION_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andReparationPercentIsNotNull() {
            addCriterion("REPARATION_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andReparationPercentEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT =", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentNotEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT <>", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentGreaterThan(BigDecimal value) {
            addCriterion("REPARATION_PERCENT >", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT >=", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentLessThan(BigDecimal value) {
            addCriterion("REPARATION_PERCENT <", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPARATION_PERCENT <=", value, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentIn(List<BigDecimal> values) {
            addCriterion("REPARATION_PERCENT in", values, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentNotIn(List<BigDecimal> values) {
            addCriterion("REPARATION_PERCENT not in", values, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_PERCENT between", value1, value2, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andReparationPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPARATION_PERCENT not between", value1, value2, "reparationPercent");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtIsNull() {
            addCriterion("CUMULATIVE_REPARATION_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtIsNotNull() {
            addCriterion("CUMULATIVE_REPARATION_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT =", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtNotEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT <>", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtGreaterThan(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT >", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT >=", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtLessThan(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT <", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CUMULATIVE_REPARATION_AMT <=", value, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtIn(List<BigDecimal> values) {
            addCriterion("CUMULATIVE_REPARATION_AMT in", values, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtNotIn(List<BigDecimal> values) {
            addCriterion("CUMULATIVE_REPARATION_AMT not in", values, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUMULATIVE_REPARATION_AMT between", value1, value2, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andCumulativeReparationAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUMULATIVE_REPARATION_AMT not between", value1, value2, "cumulativeReparationAmt");
            return (Criteria) this;
        }

        public Criteria andFactPatternIsNull() {
            addCriterion("FACT_PATTERN is null");
            return (Criteria) this;
        }

        public Criteria andFactPatternIsNotNull() {
            addCriterion("FACT_PATTERN is not null");
            return (Criteria) this;
        }

        public Criteria andFactPatternEqualTo(String value) {
            addCriterion("FACT_PATTERN =", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotEqualTo(String value) {
            addCriterion("FACT_PATTERN <>", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternGreaterThan(String value) {
            addCriterion("FACT_PATTERN >", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternGreaterThanOrEqualTo(String value) {
            addCriterion("FACT_PATTERN >=", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternLessThan(String value) {
            addCriterion("FACT_PATTERN <", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternLessThanOrEqualTo(String value) {
            addCriterion("FACT_PATTERN <=", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternLike(String value) {
            addCriterion("FACT_PATTERN like", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotLike(String value) {
            addCriterion("FACT_PATTERN not like", value, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternIn(List<String> values) {
            addCriterion("FACT_PATTERN in", values, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotIn(List<String> values) {
            addCriterion("FACT_PATTERN not in", values, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternBetween(String value1, String value2) {
            addCriterion("FACT_PATTERN between", value1, value2, "factPattern");
            return (Criteria) this;
        }

        public Criteria andFactPatternNotBetween(String value1, String value2) {
            addCriterion("FACT_PATTERN not between", value1, value2, "factPattern");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIsNull() {
            addCriterion("COOPERATION_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIsNotNull() {
            addCriterion("COOPERATION_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE =", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE <>", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeGreaterThan(String value) {
            addCriterion("COOPERATION_BRCODE >", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE >=", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLessThan(String value) {
            addCriterion("COOPERATION_BRCODE <", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLessThanOrEqualTo(String value) {
            addCriterion("COOPERATION_BRCODE <=", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeLike(String value) {
            addCriterion("COOPERATION_BRCODE like", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotLike(String value) {
            addCriterion("COOPERATION_BRCODE not like", value, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeIn(List<String> values) {
            addCriterion("COOPERATION_BRCODE in", values, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotIn(List<String> values) {
            addCriterion("COOPERATION_BRCODE not in", values, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeBetween(String value1, String value2) {
            addCriterion("COOPERATION_BRCODE between", value1, value2, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andCooperationBrcodeNotBetween(String value1, String value2) {
            addCriterion("COOPERATION_BRCODE not between", value1, value2, "cooperationBrcode");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayIsNull() {
            addCriterion("RENT_SETTLE_WAY is null");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayIsNotNull() {
            addCriterion("RENT_SETTLE_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY =", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY <>", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayGreaterThan(String value) {
            addCriterion("RENT_SETTLE_WAY >", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayGreaterThanOrEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY >=", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayLessThan(String value) {
            addCriterion("RENT_SETTLE_WAY <", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayLessThanOrEqualTo(String value) {
            addCriterion("RENT_SETTLE_WAY <=", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayLike(String value) {
            addCriterion("RENT_SETTLE_WAY like", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotLike(String value) {
            addCriterion("RENT_SETTLE_WAY not like", value, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayIn(List<String> values) {
            addCriterion("RENT_SETTLE_WAY in", values, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotIn(List<String> values) {
            addCriterion("RENT_SETTLE_WAY not in", values, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayBetween(String value1, String value2) {
            addCriterion("RENT_SETTLE_WAY between", value1, value2, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andRentSettleWayNotBetween(String value1, String value2) {
            addCriterion("RENT_SETTLE_WAY not between", value1, value2, "rentSettleWay");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtIsNull() {
            addCriterion("POOL_BAIL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtIsNotNull() {
            addCriterion("POOL_BAIL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtEqualTo(BigDecimal value) {
            addCriterion("POOL_BAIL_AMT =", value, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtNotEqualTo(BigDecimal value) {
            addCriterion("POOL_BAIL_AMT <>", value, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtGreaterThan(BigDecimal value) {
            addCriterion("POOL_BAIL_AMT >", value, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("POOL_BAIL_AMT >=", value, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtLessThan(BigDecimal value) {
            addCriterion("POOL_BAIL_AMT <", value, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("POOL_BAIL_AMT <=", value, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtIn(List<BigDecimal> values) {
            addCriterion("POOL_BAIL_AMT in", values, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtNotIn(List<BigDecimal> values) {
            addCriterion("POOL_BAIL_AMT not in", values, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POOL_BAIL_AMT between", value1, value2, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andPoolBailAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POOL_BAIL_AMT not between", value1, value2, "poolBailAmt");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountIsNull() {
            addCriterion("SUMDEBT_BILLS_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountIsNotNull() {
            addCriterion("SUMDEBT_BILLS_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT =", value, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT <>", value, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT >", value, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT >=", value, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT <", value, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT <=", value, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_BILLS_AMOUNT in", values, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_BILLS_AMOUNT not in", values, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_BILLS_AMOUNT between", value1, value2, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_BILLS_AMOUNT not between", value1, value2, "sumdebtBillsAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewIsNull() {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewIsNotNull() {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW =", value, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW <>", value, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW >", value, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW >=", value, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW <", value, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW <=", value, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW in", values, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW not in", values, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW between", value1, value2, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtBillsAmountViewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_BILLS_AMOUNT_VIEW not between", value1, value2, "sumdebtBillsAmountView");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountIsNull() {
            addCriterion("SUMDEBT_REMAINING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountIsNotNull() {
            addCriterion("SUMDEBT_REMAINING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT =", value, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT <>", value, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT >", value, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT >=", value, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT <", value, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT <=", value, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT in", values, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT not in", values, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT between", value1, value2, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REMAINING_AMOUNT not between", value1, value2, "sumdebtRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouIsNull() {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouIsNotNull() {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU =", value, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU <>", value, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU >", value, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU >=", value, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU <", value, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU <=", value, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU in", values, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU not in", values, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU between", value1, value2, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemainingUseableAmouNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REMAINING_USEABLE_AMOU not between", value1, value2, "sumdebtRemainingUseableAmou");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountIsNull() {
            addCriterion("SUMDEBT_REBATE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountIsNotNull() {
            addCriterion("SUMDEBT_REBATE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REBATE_AMOUNT =", value, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REBATE_AMOUNT <>", value, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_REBATE_AMOUNT >", value, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REBATE_AMOUNT >=", value, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_REBATE_AMOUNT <", value, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REBATE_AMOUNT <=", value, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REBATE_AMOUNT in", values, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REBATE_AMOUNT not in", values, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REBATE_AMOUNT between", value1, value2, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRebateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REBATE_AMOUNT not between", value1, value2, "sumdebtRebateAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountIsNull() {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountIsNotNull() {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT =", value, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT <>", value, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT >", value, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT >=", value, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT <", value, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT <=", value, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT in", values, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT not in", values, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT between", value1, value2, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtBuyBackAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_BUY_BACK_AMOUNT not between", value1, value2, "sumdebtBuyBackAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountIsNull() {
            addCriterion("SUMDEBT_PAY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountIsNotNull() {
            addCriterion("SUMDEBT_PAY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_PAY_AMOUNT =", value, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_PAY_AMOUNT <>", value, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_PAY_AMOUNT >", value, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_PAY_AMOUNT >=", value, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_PAY_AMOUNT <", value, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_PAY_AMOUNT <=", value, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_PAY_AMOUNT in", values, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_PAY_AMOUNT not in", values, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_PAY_AMOUNT between", value1, value2, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_PAY_AMOUNT not between", value1, value2, "sumdebtPayAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountIsNull() {
            addCriterion("SUMDEBT_REMOVE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountIsNotNull() {
            addCriterion("SUMDEBT_REMOVE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT =", value, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT <>", value, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT >", value, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT >=", value, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT <", value, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT <=", value, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT in", values, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT not in", values, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT between", value1, value2, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtRemoveAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_REMOVE_AMOUNT not between", value1, value2, "sumdebtRemoveAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountIsNull() {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountIsNotNull() {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT =", value, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT <>", value, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT >", value, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT >=", value, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountLessThan(BigDecimal value) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT <", value, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT <=", value, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT in", values, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountNotIn(List<BigDecimal> values) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT not in", values, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT between", value1, value2, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumdebtCashRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMDEBT_CASH_REMAINING_AMOUNT not between", value1, value2, "sumdebtCashRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagIsNull() {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagIsNotNull() {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG =", value, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagNotEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG <>", value, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagGreaterThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG >", value, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG >=", value, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagLessThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG <", value, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG <=", value, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG in", values, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagNotIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG not in", values, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG between", value1, value2, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtFlawFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_FLAW_FLAG not between", value1, value2, "sumamtDebtFlawFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagIsNull() {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagIsNotNull() {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG =", value, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagNotEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG <>", value, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagGreaterThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG >", value, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG >=", value, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagLessThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG <", value, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG <=", value, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG in", values, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagNotIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG not in", values, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG between", value1, value2, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtIssueFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_ISSUE_FLAG not between", value1, value2, "sumamtDebtIssueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagIsNull() {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagIsNotNull() {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG =", value, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagNotEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG <>", value, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagGreaterThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG >", value, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG >=", value, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagLessThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG <", value, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG <=", value, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG in", values, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagNotIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG not in", values, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG between", value1, value2, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtOverdueFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_OVERDUE_FLAG not between", value1, value2, "sumamtDebtOverdueFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagIsNull() {
            addCriterion("SUMAMT_DEBT_BAD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagIsNotNull() {
            addCriterion("SUMAMT_DEBT_BAD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG =", value, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagNotEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG <>", value, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagGreaterThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG >", value, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG >=", value, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagLessThan(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG <", value, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG <=", value, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG in", values, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagNotIn(List<BigDecimal> values) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG not in", values, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG between", value1, value2, "sumamtDebtBadFlag");
            return (Criteria) this;
        }

        public Criteria andSumamtDebtBadFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUMAMT_DEBT_BAD_FLAG not between", value1, value2, "sumamtDebtBadFlag");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}