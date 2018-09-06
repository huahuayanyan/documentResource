package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntDebtInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntDebtInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntDebtInfoExample(BCntDebtInfoExample example) {
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

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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