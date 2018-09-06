package com.huateng.scf.bas.lan.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLanAppliBillInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BLanAppliBillInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BLanAppliBillInfoExample(BLanAppliBillInfoExample example) {
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

        public Criteria andReceiverIsNull() {
            addCriterion("RECEIVER is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("RECEIVER is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("RECEIVER =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("RECEIVER <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("RECEIVER >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVER >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("RECEIVER <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("RECEIVER <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("RECEIVER like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("RECEIVER not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("RECEIVER in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("RECEIVER not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("RECEIVER between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("RECEIVER not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("RECEIVER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("RECEIVER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("RECEIVER_NAME =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("RECEIVER_NAME <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("RECEIVER_NAME >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVER_NAME >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("RECEIVER_NAME <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("RECEIVER_NAME <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("RECEIVER_NAME like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("RECEIVER_NAME not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("RECEIVER_NAME in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("RECEIVER_NAME not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("RECEIVER_NAME between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("RECEIVER_NAME not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameIsNull() {
            addCriterion("BRCODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameIsNotNull() {
            addCriterion("BRCODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameEqualTo(String value) {
            addCriterion("BRCODE_NAME =", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameNotEqualTo(String value) {
            addCriterion("BRCODE_NAME <>", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameGreaterThan(String value) {
            addCriterion("BRCODE_NAME >", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("BRCODE_NAME >=", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameLessThan(String value) {
            addCriterion("BRCODE_NAME <", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameLessThanOrEqualTo(String value) {
            addCriterion("BRCODE_NAME <=", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameLike(String value) {
            addCriterion("BRCODE_NAME like", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameNotLike(String value) {
            addCriterion("BRCODE_NAME not like", value, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameIn(List<String> values) {
            addCriterion("BRCODE_NAME in", values, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameNotIn(List<String> values) {
            addCriterion("BRCODE_NAME not in", values, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameBetween(String value1, String value2) {
            addCriterion("BRCODE_NAME between", value1, value2, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andBrcodeNameNotBetween(String value1, String value2) {
            addCriterion("BRCODE_NAME not between", value1, value2, "brcodeName");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountIsNull() {
            addCriterion("RECEIVER_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountIsNotNull() {
            addCriterion("RECEIVER_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountEqualTo(String value) {
            addCriterion("RECEIVER_ACCOUNT =", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountNotEqualTo(String value) {
            addCriterion("RECEIVER_ACCOUNT <>", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountGreaterThan(String value) {
            addCriterion("RECEIVER_ACCOUNT >", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVER_ACCOUNT >=", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountLessThan(String value) {
            addCriterion("RECEIVER_ACCOUNT <", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountLessThanOrEqualTo(String value) {
            addCriterion("RECEIVER_ACCOUNT <=", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountLike(String value) {
            addCriterion("RECEIVER_ACCOUNT like", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountNotLike(String value) {
            addCriterion("RECEIVER_ACCOUNT not like", value, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountIn(List<String> values) {
            addCriterion("RECEIVER_ACCOUNT in", values, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountNotIn(List<String> values) {
            addCriterion("RECEIVER_ACCOUNT not in", values, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountBetween(String value1, String value2) {
            addCriterion("RECEIVER_ACCOUNT between", value1, value2, "receiverAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverAccountNotBetween(String value1, String value2) {
            addCriterion("RECEIVER_ACCOUNT not between", value1, value2, "receiverAccount");
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

        public Criteria andElecFlagIsNull() {
            addCriterion("ELEC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andElecFlagIsNotNull() {
            addCriterion("ELEC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andElecFlagEqualTo(String value) {
            addCriterion("ELEC_FLAG =", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagNotEqualTo(String value) {
            addCriterion("ELEC_FLAG <>", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagGreaterThan(String value) {
            addCriterion("ELEC_FLAG >", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ELEC_FLAG >=", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagLessThan(String value) {
            addCriterion("ELEC_FLAG <", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagLessThanOrEqualTo(String value) {
            addCriterion("ELEC_FLAG <=", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagLike(String value) {
            addCriterion("ELEC_FLAG like", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagNotLike(String value) {
            addCriterion("ELEC_FLAG not like", value, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagIn(List<String> values) {
            addCriterion("ELEC_FLAG in", values, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagNotIn(List<String> values) {
            addCriterion("ELEC_FLAG not in", values, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagBetween(String value1, String value2) {
            addCriterion("ELEC_FLAG between", value1, value2, "elecFlag");
            return (Criteria) this;
        }

        public Criteria andElecFlagNotBetween(String value1, String value2) {
            addCriterion("ELEC_FLAG not between", value1, value2, "elecFlag");
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

        public Criteria andPayeeBanknoIsNull() {
            addCriterion("PAYEE_BANKNO is null");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoIsNotNull() {
            addCriterion("PAYEE_BANKNO is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoEqualTo(String value) {
            addCriterion("PAYEE_BANKNO =", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoNotEqualTo(String value) {
            addCriterion("PAYEE_BANKNO <>", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoGreaterThan(String value) {
            addCriterion("PAYEE_BANKNO >", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_BANKNO >=", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoLessThan(String value) {
            addCriterion("PAYEE_BANKNO <", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_BANKNO <=", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoLike(String value) {
            addCriterion("PAYEE_BANKNO like", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoNotLike(String value) {
            addCriterion("PAYEE_BANKNO not like", value, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoIn(List<String> values) {
            addCriterion("PAYEE_BANKNO in", values, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoNotIn(List<String> values) {
            addCriterion("PAYEE_BANKNO not in", values, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoBetween(String value1, String value2) {
            addCriterion("PAYEE_BANKNO between", value1, value2, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andPayeeBanknoNotBetween(String value1, String value2) {
            addCriterion("PAYEE_BANKNO not between", value1, value2, "payeeBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorIsNull() {
            addCriterion("ACCEPTOR is null");
            return (Criteria) this;
        }

        public Criteria andAcceptorIsNotNull() {
            addCriterion("ACCEPTOR is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptorEqualTo(String value) {
            addCriterion("ACCEPTOR =", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorNotEqualTo(String value) {
            addCriterion("ACCEPTOR <>", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorGreaterThan(String value) {
            addCriterion("ACCEPTOR >", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPTOR >=", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorLessThan(String value) {
            addCriterion("ACCEPTOR <", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorLessThanOrEqualTo(String value) {
            addCriterion("ACCEPTOR <=", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorLike(String value) {
            addCriterion("ACCEPTOR like", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorNotLike(String value) {
            addCriterion("ACCEPTOR not like", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorIn(List<String> values) {
            addCriterion("ACCEPTOR in", values, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorNotIn(List<String> values) {
            addCriterion("ACCEPTOR not in", values, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorBetween(String value1, String value2) {
            addCriterion("ACCEPTOR between", value1, value2, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorNotBetween(String value1, String value2) {
            addCriterion("ACCEPTOR not between", value1, value2, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoIsNull() {
            addCriterion("ACCEPTOR_BANKNO is null");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoIsNotNull() {
            addCriterion("ACCEPTOR_BANKNO is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoEqualTo(String value) {
            addCriterion("ACCEPTOR_BANKNO =", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoNotEqualTo(String value) {
            addCriterion("ACCEPTOR_BANKNO <>", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoGreaterThan(String value) {
            addCriterion("ACCEPTOR_BANKNO >", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPTOR_BANKNO >=", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoLessThan(String value) {
            addCriterion("ACCEPTOR_BANKNO <", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoLessThanOrEqualTo(String value) {
            addCriterion("ACCEPTOR_BANKNO <=", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoLike(String value) {
            addCriterion("ACCEPTOR_BANKNO like", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoNotLike(String value) {
            addCriterion("ACCEPTOR_BANKNO not like", value, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoIn(List<String> values) {
            addCriterion("ACCEPTOR_BANKNO in", values, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoNotIn(List<String> values) {
            addCriterion("ACCEPTOR_BANKNO not in", values, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoBetween(String value1, String value2) {
            addCriterion("ACCEPTOR_BANKNO between", value1, value2, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andAcceptorBanknoNotBetween(String value1, String value2) {
            addCriterion("ACCEPTOR_BANKNO not between", value1, value2, "acceptorBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountIsNull() {
            addCriterion("DRAWER_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountIsNotNull() {
            addCriterion("DRAWER_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountEqualTo(String value) {
            addCriterion("DRAWER_ACCOUNT =", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountNotEqualTo(String value) {
            addCriterion("DRAWER_ACCOUNT <>", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountGreaterThan(String value) {
            addCriterion("DRAWER_ACCOUNT >", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountGreaterThanOrEqualTo(String value) {
            addCriterion("DRAWER_ACCOUNT >=", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountLessThan(String value) {
            addCriterion("DRAWER_ACCOUNT <", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountLessThanOrEqualTo(String value) {
            addCriterion("DRAWER_ACCOUNT <=", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountLike(String value) {
            addCriterion("DRAWER_ACCOUNT like", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountNotLike(String value) {
            addCriterion("DRAWER_ACCOUNT not like", value, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountIn(List<String> values) {
            addCriterion("DRAWER_ACCOUNT in", values, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountNotIn(List<String> values) {
            addCriterion("DRAWER_ACCOUNT not in", values, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountBetween(String value1, String value2) {
            addCriterion("DRAWER_ACCOUNT between", value1, value2, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerAccountNotBetween(String value1, String value2) {
            addCriterion("DRAWER_ACCOUNT not between", value1, value2, "drawerAccount");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoIsNull() {
            addCriterion("DRAWER_BANKNO is null");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoIsNotNull() {
            addCriterion("DRAWER_BANKNO is not null");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoEqualTo(String value) {
            addCriterion("DRAWER_BANKNO =", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoNotEqualTo(String value) {
            addCriterion("DRAWER_BANKNO <>", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoGreaterThan(String value) {
            addCriterion("DRAWER_BANKNO >", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoGreaterThanOrEqualTo(String value) {
            addCriterion("DRAWER_BANKNO >=", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoLessThan(String value) {
            addCriterion("DRAWER_BANKNO <", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoLessThanOrEqualTo(String value) {
            addCriterion("DRAWER_BANKNO <=", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoLike(String value) {
            addCriterion("DRAWER_BANKNO like", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoNotLike(String value) {
            addCriterion("DRAWER_BANKNO not like", value, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoIn(List<String> values) {
            addCriterion("DRAWER_BANKNO in", values, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoNotIn(List<String> values) {
            addCriterion("DRAWER_BANKNO not in", values, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoBetween(String value1, String value2) {
            addCriterion("DRAWER_BANKNO between", value1, value2, "drawerBankno");
            return (Criteria) this;
        }

        public Criteria andDrawerBanknoNotBetween(String value1, String value2) {
            addCriterion("DRAWER_BANKNO not between", value1, value2, "drawerBankno");
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

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andPoolStatusIsNull() {
            addCriterion("POOL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPoolStatusIsNotNull() {
            addCriterion("POOL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPoolStatusEqualTo(String value) {
            addCriterion("POOL_STATUS =", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusNotEqualTo(String value) {
            addCriterion("POOL_STATUS <>", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusGreaterThan(String value) {
            addCriterion("POOL_STATUS >", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusGreaterThanOrEqualTo(String value) {
            addCriterion("POOL_STATUS >=", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusLessThan(String value) {
            addCriterion("POOL_STATUS <", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusLessThanOrEqualTo(String value) {
            addCriterion("POOL_STATUS <=", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusLike(String value) {
            addCriterion("POOL_STATUS like", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusNotLike(String value) {
            addCriterion("POOL_STATUS not like", value, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusIn(List<String> values) {
            addCriterion("POOL_STATUS in", values, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusNotIn(List<String> values) {
            addCriterion("POOL_STATUS not in", values, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusBetween(String value1, String value2) {
            addCriterion("POOL_STATUS between", value1, value2, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andPoolStatusNotBetween(String value1, String value2) {
            addCriterion("POOL_STATUS not between", value1, value2, "poolStatus");
            return (Criteria) this;
        }

        public Criteria andBusiFlagIsNull() {
            addCriterion("BUSI_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBusiFlagIsNotNull() {
            addCriterion("BUSI_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBusiFlagEqualTo(String value) {
            addCriterion("BUSI_FLAG =", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagNotEqualTo(String value) {
            addCriterion("BUSI_FLAG <>", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagGreaterThan(String value) {
            addCriterion("BUSI_FLAG >", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_FLAG >=", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagLessThan(String value) {
            addCriterion("BUSI_FLAG <", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagLessThanOrEqualTo(String value) {
            addCriterion("BUSI_FLAG <=", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagLike(String value) {
            addCriterion("BUSI_FLAG like", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagNotLike(String value) {
            addCriterion("BUSI_FLAG not like", value, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagIn(List<String> values) {
            addCriterion("BUSI_FLAG in", values, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagNotIn(List<String> values) {
            addCriterion("BUSI_FLAG not in", values, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagBetween(String value1, String value2) {
            addCriterion("BUSI_FLAG between", value1, value2, "busiFlag");
            return (Criteria) this;
        }

        public Criteria andBusiFlagNotBetween(String value1, String value2) {
            addCriterion("BUSI_FLAG not between", value1, value2, "busiFlag");
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

        public Criteria andLoanNoIsNull() {
            addCriterion("LOAN_NO is null");
            return (Criteria) this;
        }

        public Criteria andLoanNoIsNotNull() {
            addCriterion("LOAN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNoEqualTo(String value) {
            addCriterion("LOAN_NO =", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotEqualTo(String value) {
            addCriterion("LOAN_NO <>", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoGreaterThan(String value) {
            addCriterion("LOAN_NO >", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_NO >=", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoLessThan(String value) {
            addCriterion("LOAN_NO <", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoLessThanOrEqualTo(String value) {
            addCriterion("LOAN_NO <=", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoLike(String value) {
            addCriterion("LOAN_NO like", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotLike(String value) {
            addCriterion("LOAN_NO not like", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoIn(List<String> values) {
            addCriterion("LOAN_NO in", values, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotIn(List<String> values) {
            addCriterion("LOAN_NO not in", values, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoBetween(String value1, String value2) {
            addCriterion("LOAN_NO between", value1, value2, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotBetween(String value1, String value2) {
            addCriterion("LOAN_NO not between", value1, value2, "loanNo");
            return (Criteria) this;
        }

        public Criteria andConversionValueIsNull() {
            addCriterion("CONVERSION_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andConversionValueIsNotNull() {
            addCriterion("CONVERSION_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andConversionValueEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_VALUE =", value, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueNotEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_VALUE <>", value, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueGreaterThan(BigDecimal value) {
            addCriterion("CONVERSION_VALUE >", value, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_VALUE >=", value, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueLessThan(BigDecimal value) {
            addCriterion("CONVERSION_VALUE <", value, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_VALUE <=", value, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueIn(List<BigDecimal> values) {
            addCriterion("CONVERSION_VALUE in", values, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueNotIn(List<BigDecimal> values) {
            addCriterion("CONVERSION_VALUE not in", values, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONVERSION_VALUE between", value1, value2, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONVERSION_VALUE not between", value1, value2, "conversionValue");
            return (Criteria) this;
        }

        public Criteria andConversionRateIsNull() {
            addCriterion("CONVERSION_RATE is null");
            return (Criteria) this;
        }

        public Criteria andConversionRateIsNotNull() {
            addCriterion("CONVERSION_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andConversionRateEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_RATE =", value, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateNotEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_RATE <>", value, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateGreaterThan(BigDecimal value) {
            addCriterion("CONVERSION_RATE >", value, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_RATE >=", value, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateLessThan(BigDecimal value) {
            addCriterion("CONVERSION_RATE <", value, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONVERSION_RATE <=", value, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateIn(List<BigDecimal> values) {
            addCriterion("CONVERSION_RATE in", values, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateNotIn(List<BigDecimal> values) {
            addCriterion("CONVERSION_RATE not in", values, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONVERSION_RATE between", value1, value2, "conversionRate");
            return (Criteria) this;
        }

        public Criteria andConversionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONVERSION_RATE not between", value1, value2, "conversionRate");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}