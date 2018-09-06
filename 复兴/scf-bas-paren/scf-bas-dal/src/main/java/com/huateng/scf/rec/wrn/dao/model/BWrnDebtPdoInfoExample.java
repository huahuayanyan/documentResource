package com.huateng.scf.rec.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWrnDebtPdoInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWrnDebtPdoInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWrnDebtPdoInfoExample(BWrnDebtPdoInfoExample example) {
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

        public Criteria andDeadlineIsNull() {
            addCriterion("DEADLINE is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("DEADLINE is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(String value) {
            addCriterion("DEADLINE =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(String value) {
            addCriterion("DEADLINE <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(String value) {
            addCriterion("DEADLINE >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("DEADLINE >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(String value) {
            addCriterion("DEADLINE <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(String value) {
            addCriterion("DEADLINE <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLike(String value) {
            addCriterion("DEADLINE like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotLike(String value) {
            addCriterion("DEADLINE not like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<String> values) {
            addCriterion("DEADLINE in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<String> values) {
            addCriterion("DEADLINE not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(String value1, String value2) {
            addCriterion("DEADLINE between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(String value1, String value2) {
            addCriterion("DEADLINE not between", value1, value2, "deadline");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}