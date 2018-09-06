package com.huateng.scf.bas.nte.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNteNoticeBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BNteNoticeBillExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BNteNoticeBillExample(BNteNoticeBillExample example) {
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

        public Criteria andBillIdIsNull() {
            addCriterion("BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("BILL_ID =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("BILL_ID <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("BILL_ID >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_ID >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("BILL_ID <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("BILL_ID <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("BILL_ID like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("BILL_ID not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("BILL_ID in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("BILL_ID not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("BILL_ID between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("BILL_ID not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIsNull() {
            addCriterion("LOAN_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIsNotNull() {
            addCriterion("LOAN_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDaysEqualTo(String value) {
            addCriterion("LOAN_DAYS =", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotEqualTo(String value) {
            addCriterion("LOAN_DAYS <>", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysGreaterThan(String value) {
            addCriterion("LOAN_DAYS >", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_DAYS >=", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysLessThan(String value) {
            addCriterion("LOAN_DAYS <", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysLessThanOrEqualTo(String value) {
            addCriterion("LOAN_DAYS <=", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysLike(String value) {
            addCriterion("LOAN_DAYS like", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotLike(String value) {
            addCriterion("LOAN_DAYS not like", value, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysIn(List<String> values) {
            addCriterion("LOAN_DAYS in", values, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotIn(List<String> values) {
            addCriterion("LOAN_DAYS not in", values, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysBetween(String value1, String value2) {
            addCriterion("LOAN_DAYS between", value1, value2, "loanDays");
            return (Criteria) this;
        }

        public Criteria andLoanDaysNotBetween(String value1, String value2) {
            addCriterion("LOAN_DAYS not between", value1, value2, "loanDays");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNull() {
            addCriterion("BILL_NO is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("BILL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("BILL_NO =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("BILL_NO <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("BILL_NO >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_NO >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("BILL_NO <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("BILL_NO <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("BILL_NO like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("BILL_NO not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("BILL_NO in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("BILL_NO not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("BILL_NO between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("BILL_NO not between", value1, value2, "billNo");
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

        public Criteria andBillDateIsNull() {
            addCriterion("BILL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNotNull() {
            addCriterion("BILL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillDateEqualTo(String value) {
            addCriterion("BILL_DATE =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(String value) {
            addCriterion("BILL_DATE <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(String value) {
            addCriterion("BILL_DATE >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_DATE >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(String value) {
            addCriterion("BILL_DATE <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(String value) {
            addCriterion("BILL_DATE <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLike(String value) {
            addCriterion("BILL_DATE like", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotLike(String value) {
            addCriterion("BILL_DATE not like", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<String> values) {
            addCriterion("BILL_DATE in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<String> values) {
            addCriterion("BILL_DATE not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(String value1, String value2) {
            addCriterion("BILL_DATE between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(String value1, String value2) {
            addCriterion("BILL_DATE not between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateIsNull() {
            addCriterion("BILL_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillEndDateIsNotNull() {
            addCriterion("BILL_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillEndDateEqualTo(String value) {
            addCriterion("BILL_END_DATE =", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateNotEqualTo(String value) {
            addCriterion("BILL_END_DATE <>", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateGreaterThan(String value) {
            addCriterion("BILL_END_DATE >", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_END_DATE >=", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateLessThan(String value) {
            addCriterion("BILL_END_DATE <", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateLessThanOrEqualTo(String value) {
            addCriterion("BILL_END_DATE <=", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateLike(String value) {
            addCriterion("BILL_END_DATE like", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateNotLike(String value) {
            addCriterion("BILL_END_DATE not like", value, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateIn(List<String> values) {
            addCriterion("BILL_END_DATE in", values, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateNotIn(List<String> values) {
            addCriterion("BILL_END_DATE not in", values, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateBetween(String value1, String value2) {
            addCriterion("BILL_END_DATE between", value1, value2, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andBillEndDateNotBetween(String value1, String value2) {
            addCriterion("BILL_END_DATE not between", value1, value2, "billEndDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("APPLY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("APPLY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(String value) {
            addCriterion("APPLY_DATE =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(String value) {
            addCriterion("APPLY_DATE <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(String value) {
            addCriterion("APPLY_DATE >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_DATE >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(String value) {
            addCriterion("APPLY_DATE <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(String value) {
            addCriterion("APPLY_DATE <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLike(String value) {
            addCriterion("APPLY_DATE like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotLike(String value) {
            addCriterion("APPLY_DATE not like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<String> values) {
            addCriterion("APPLY_DATE in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<String> values) {
            addCriterion("APPLY_DATE not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(String value1, String value2) {
            addCriterion("APPLY_DATE between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(String value1, String value2) {
            addCriterion("APPLY_DATE not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andExtDateIsNull() {
            addCriterion("EXT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExtDateIsNotNull() {
            addCriterion("EXT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExtDateEqualTo(String value) {
            addCriterion("EXT_DATE =", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateNotEqualTo(String value) {
            addCriterion("EXT_DATE <>", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateGreaterThan(String value) {
            addCriterion("EXT_DATE >", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_DATE >=", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateLessThan(String value) {
            addCriterion("EXT_DATE <", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateLessThanOrEqualTo(String value) {
            addCriterion("EXT_DATE <=", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateLike(String value) {
            addCriterion("EXT_DATE like", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateNotLike(String value) {
            addCriterion("EXT_DATE not like", value, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateIn(List<String> values) {
            addCriterion("EXT_DATE in", values, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateNotIn(List<String> values) {
            addCriterion("EXT_DATE not in", values, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateBetween(String value1, String value2) {
            addCriterion("EXT_DATE between", value1, value2, "extDate");
            return (Criteria) this;
        }

        public Criteria andExtDateNotBetween(String value1, String value2) {
            addCriterion("EXT_DATE not between", value1, value2, "extDate");
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

        public Criteria andExt1AmountIsNull() {
            addCriterion("EXT1_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andExt1AmountIsNotNull() {
            addCriterion("EXT1_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andExt1AmountEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT =", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountNotEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT <>", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountGreaterThan(BigDecimal value) {
            addCriterion("EXT1_AMOUNT >", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT >=", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountLessThan(BigDecimal value) {
            addCriterion("EXT1_AMOUNT <", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT1_AMOUNT <=", value, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountIn(List<BigDecimal> values) {
            addCriterion("EXT1_AMOUNT in", values, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountNotIn(List<BigDecimal> values) {
            addCriterion("EXT1_AMOUNT not in", values, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT1_AMOUNT between", value1, value2, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt1AmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT1_AMOUNT not between", value1, value2, "ext1Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountIsNull() {
            addCriterion("EXT2_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andExt2AmountIsNotNull() {
            addCriterion("EXT2_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andExt2AmountEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT =", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountNotEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT <>", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountGreaterThan(BigDecimal value) {
            addCriterion("EXT2_AMOUNT >", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT >=", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountLessThan(BigDecimal value) {
            addCriterion("EXT2_AMOUNT <", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT2_AMOUNT <=", value, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountIn(List<BigDecimal> values) {
            addCriterion("EXT2_AMOUNT in", values, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountNotIn(List<BigDecimal> values) {
            addCriterion("EXT2_AMOUNT not in", values, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT2_AMOUNT between", value1, value2, "ext2Amount");
            return (Criteria) this;
        }

        public Criteria andExt2AmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT2_AMOUNT not between", value1, value2, "ext2Amount");
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

        public Criteria andLadingnoIsNull() {
            addCriterion("LADINGNO is null");
            return (Criteria) this;
        }

        public Criteria andLadingnoIsNotNull() {
            addCriterion("LADINGNO is not null");
            return (Criteria) this;
        }

        public Criteria andLadingnoEqualTo(String value) {
            addCriterion("LADINGNO =", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoNotEqualTo(String value) {
            addCriterion("LADINGNO <>", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoGreaterThan(String value) {
            addCriterion("LADINGNO >", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoGreaterThanOrEqualTo(String value) {
            addCriterion("LADINGNO >=", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoLessThan(String value) {
            addCriterion("LADINGNO <", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoLessThanOrEqualTo(String value) {
            addCriterion("LADINGNO <=", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoLike(String value) {
            addCriterion("LADINGNO like", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoNotLike(String value) {
            addCriterion("LADINGNO not like", value, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoIn(List<String> values) {
            addCriterion("LADINGNO in", values, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoNotIn(List<String> values) {
            addCriterion("LADINGNO not in", values, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoBetween(String value1, String value2) {
            addCriterion("LADINGNO between", value1, value2, "ladingno");
            return (Criteria) this;
        }

        public Criteria andLadingnoNotBetween(String value1, String value2) {
            addCriterion("LADINGNO not between", value1, value2, "ladingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoIsNull() {
            addCriterion("PACKINGNO is null");
            return (Criteria) this;
        }

        public Criteria andPackingnoIsNotNull() {
            addCriterion("PACKINGNO is not null");
            return (Criteria) this;
        }

        public Criteria andPackingnoEqualTo(String value) {
            addCriterion("PACKINGNO =", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoNotEqualTo(String value) {
            addCriterion("PACKINGNO <>", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoGreaterThan(String value) {
            addCriterion("PACKINGNO >", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoGreaterThanOrEqualTo(String value) {
            addCriterion("PACKINGNO >=", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoLessThan(String value) {
            addCriterion("PACKINGNO <", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoLessThanOrEqualTo(String value) {
            addCriterion("PACKINGNO <=", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoLike(String value) {
            addCriterion("PACKINGNO like", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoNotLike(String value) {
            addCriterion("PACKINGNO not like", value, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoIn(List<String> values) {
            addCriterion("PACKINGNO in", values, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoNotIn(List<String> values) {
            addCriterion("PACKINGNO not in", values, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoBetween(String value1, String value2) {
            addCriterion("PACKINGNO between", value1, value2, "packingno");
            return (Criteria) this;
        }

        public Criteria andPackingnoNotBetween(String value1, String value2) {
            addCriterion("PACKINGNO not between", value1, value2, "packingno");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("BILL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("BILL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("BILL_TYPE =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(String value) {
            addCriterion("BILL_TYPE <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(String value) {
            addCriterion("BILL_TYPE >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_TYPE >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(String value) {
            addCriterion("BILL_TYPE <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(String value) {
            addCriterion("BILL_TYPE <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLike(String value) {
            addCriterion("BILL_TYPE like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotLike(String value) {
            addCriterion("BILL_TYPE not like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<String> values) {
            addCriterion("BILL_TYPE in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<String> values) {
            addCriterion("BILL_TYPE not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(String value1, String value2) {
            addCriterion("BILL_TYPE between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(String value1, String value2) {
            addCriterion("BILL_TYPE not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillsMescIsNull() {
            addCriterion("BILLS_MESC is null");
            return (Criteria) this;
        }

        public Criteria andBillsMescIsNotNull() {
            addCriterion("BILLS_MESC is not null");
            return (Criteria) this;
        }

        public Criteria andBillsMescEqualTo(String value) {
            addCriterion("BILLS_MESC =", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescNotEqualTo(String value) {
            addCriterion("BILLS_MESC <>", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescGreaterThan(String value) {
            addCriterion("BILLS_MESC >", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescGreaterThanOrEqualTo(String value) {
            addCriterion("BILLS_MESC >=", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescLessThan(String value) {
            addCriterion("BILLS_MESC <", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescLessThanOrEqualTo(String value) {
            addCriterion("BILLS_MESC <=", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescLike(String value) {
            addCriterion("BILLS_MESC like", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescNotLike(String value) {
            addCriterion("BILLS_MESC not like", value, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescIn(List<String> values) {
            addCriterion("BILLS_MESC in", values, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescNotIn(List<String> values) {
            addCriterion("BILLS_MESC not in", values, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescBetween(String value1, String value2) {
            addCriterion("BILLS_MESC between", value1, value2, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andBillsMescNotBetween(String value1, String value2) {
            addCriterion("BILLS_MESC not between", value1, value2, "billsMesc");
            return (Criteria) this;
        }

        public Criteria andDrawerIsNull() {
            addCriterion("DRAWER is null");
            return (Criteria) this;
        }

        public Criteria andDrawerIsNotNull() {
            addCriterion("DRAWER is not null");
            return (Criteria) this;
        }

        public Criteria andDrawerEqualTo(String value) {
            addCriterion("DRAWER =", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerNotEqualTo(String value) {
            addCriterion("DRAWER <>", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerGreaterThan(String value) {
            addCriterion("DRAWER >", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerGreaterThanOrEqualTo(String value) {
            addCriterion("DRAWER >=", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerLessThan(String value) {
            addCriterion("DRAWER <", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerLessThanOrEqualTo(String value) {
            addCriterion("DRAWER <=", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerLike(String value) {
            addCriterion("DRAWER like", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerNotLike(String value) {
            addCriterion("DRAWER not like", value, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerIn(List<String> values) {
            addCriterion("DRAWER in", values, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerNotIn(List<String> values) {
            addCriterion("DRAWER not in", values, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerBetween(String value1, String value2) {
            addCriterion("DRAWER between", value1, value2, "drawer");
            return (Criteria) this;
        }

        public Criteria andDrawerNotBetween(String value1, String value2) {
            addCriterion("DRAWER not between", value1, value2, "drawer");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNull() {
            addCriterion("PAYEE is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNotNull() {
            addCriterion("PAYEE is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeEqualTo(String value) {
            addCriterion("PAYEE =", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotEqualTo(String value) {
            addCriterion("PAYEE <>", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThan(String value) {
            addCriterion("PAYEE >", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE >=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThan(String value) {
            addCriterion("PAYEE <", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThanOrEqualTo(String value) {
            addCriterion("PAYEE <=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLike(String value) {
            addCriterion("PAYEE like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotLike(String value) {
            addCriterion("PAYEE not like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeIn(List<String> values) {
            addCriterion("PAYEE in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotIn(List<String> values) {
            addCriterion("PAYEE not in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeBetween(String value1, String value2) {
            addCriterion("PAYEE between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotBetween(String value1, String value2) {
            addCriterion("PAYEE not between", value1, value2, "payee");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}