package com.huateng.scf.rec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RBcpDebtPoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RBcpDebtPoolExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RBcpDebtPoolExample(RBcpDebtPoolExample example) {
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

        public Criteria andTotalDebtRemainAmountIsNull() {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountIsNotNull() {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT =", value, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT <>", value, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT >", value, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT >=", value, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT <", value, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT <=", value, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT in", values, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT not in", values, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT between", value1, value2, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtRemainAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_DEBT_REMAIN_AMOUNT not between", value1, value2, "totalDebtRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountIsNull() {
            addCriterion("TOTAL_CASH_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountIsNotNull() {
            addCriterion("TOTAL_CASH_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CASH_AMOUNT =", value, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CASH_AMOUNT <>", value, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_CASH_AMOUNT >", value, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CASH_AMOUNT >=", value, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_CASH_AMOUNT <", value, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CASH_AMOUNT <=", value, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_CASH_AMOUNT in", values, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_CASH_AMOUNT not in", values, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_CASH_AMOUNT between", value1, value2, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCashAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_CASH_AMOUNT not between", value1, value2, "totalCashAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountIsNull() {
            addCriterion("POOL_REMAINING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountIsNotNull() {
            addCriterion("POOL_REMAINING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("POOL_REMAINING_AMOUNT =", value, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("POOL_REMAINING_AMOUNT <>", value, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("POOL_REMAINING_AMOUNT >", value, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("POOL_REMAINING_AMOUNT >=", value, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountLessThan(BigDecimal value) {
            addCriterion("POOL_REMAINING_AMOUNT <", value, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("POOL_REMAINING_AMOUNT <=", value, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountIn(List<BigDecimal> values) {
            addCriterion("POOL_REMAINING_AMOUNT in", values, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountNotIn(List<BigDecimal> values) {
            addCriterion("POOL_REMAINING_AMOUNT not in", values, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POOL_REMAINING_AMOUNT between", value1, value2, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POOL_REMAINING_AMOUNT not between", value1, value2, "poolRemainingAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountIsNull() {
            addCriterion("POOL_USEABLE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountIsNotNull() {
            addCriterion("POOL_USEABLE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountEqualTo(BigDecimal value) {
            addCriterion("POOL_USEABLE_AMOUNT =", value, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountNotEqualTo(BigDecimal value) {
            addCriterion("POOL_USEABLE_AMOUNT <>", value, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountGreaterThan(BigDecimal value) {
            addCriterion("POOL_USEABLE_AMOUNT >", value, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("POOL_USEABLE_AMOUNT >=", value, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountLessThan(BigDecimal value) {
            addCriterion("POOL_USEABLE_AMOUNT <", value, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("POOL_USEABLE_AMOUNT <=", value, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountIn(List<BigDecimal> values) {
            addCriterion("POOL_USEABLE_AMOUNT in", values, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountNotIn(List<BigDecimal> values) {
            addCriterion("POOL_USEABLE_AMOUNT not in", values, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POOL_USEABLE_AMOUNT between", value1, value2, "poolUseableAmount");
            return (Criteria) this;
        }

        public Criteria andPoolUseableAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POOL_USEABLE_AMOUNT not between", value1, value2, "poolUseableAmount");
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

        public Criteria andTotalRateRemainAmountIsNull() {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountIsNotNull() {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT =", value, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT <>", value, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT >", value, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT >=", value, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT <", value, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT <=", value, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT in", values, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT not in", values, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT between", value1, value2, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateRemainAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_RATE_REMAIN_AMOUNT not between", value1, value2, "totalRateRemainAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountIsNull() {
            addCriterion("TOTAL_RATE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountIsNotNull() {
            addCriterion("TOTAL_RATE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_AMOUNT =", value, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_AMOUNT <>", value, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_RATE_AMOUNT >", value, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_AMOUNT >=", value, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_RATE_AMOUNT <", value, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_RATE_AMOUNT <=", value, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_RATE_AMOUNT in", values, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_RATE_AMOUNT not in", values, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_RATE_AMOUNT between", value1, value2, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_RATE_AMOUNT not between", value1, value2, "totalRateAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountIsNull() {
            addCriterion("TOTAL_CAPITAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountIsNotNull() {
            addCriterion("TOTAL_CAPITAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CAPITAL_AMOUNT =", value, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CAPITAL_AMOUNT <>", value, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_CAPITAL_AMOUNT >", value, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CAPITAL_AMOUNT >=", value, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_CAPITAL_AMOUNT <", value, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CAPITAL_AMOUNT <=", value, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_CAPITAL_AMOUNT in", values, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_CAPITAL_AMOUNT not in", values, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_CAPITAL_AMOUNT between", value1, value2, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCapitalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_CAPITAL_AMOUNT not between", value1, value2, "totalCapitalAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("REFUND_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("REFUND_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(BigDecimal value) {
            addCriterion("REFUND_AMOUNT =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("REFUND_AMOUNT <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("REFUND_AMOUNT >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND_AMOUNT >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(BigDecimal value) {
            addCriterion("REFUND_AMOUNT <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND_AMOUNT <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<BigDecimal> values) {
            addCriterion("REFUND_AMOUNT in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<BigDecimal> values) {
            addCriterion("REFUND_AMOUNT not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND_AMOUNT between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND_AMOUNT not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountIsNull() {
            addCriterion("RETURN_RATE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountIsNotNull() {
            addCriterion("RETURN_RATE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountEqualTo(BigDecimal value) {
            addCriterion("RETURN_RATE_AMOUNT =", value, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountNotEqualTo(BigDecimal value) {
            addCriterion("RETURN_RATE_AMOUNT <>", value, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountGreaterThan(BigDecimal value) {
            addCriterion("RETURN_RATE_AMOUNT >", value, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_RATE_AMOUNT >=", value, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountLessThan(BigDecimal value) {
            addCriterion("RETURN_RATE_AMOUNT <", value, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RETURN_RATE_AMOUNT <=", value, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountIn(List<BigDecimal> values) {
            addCriterion("RETURN_RATE_AMOUNT in", values, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountNotIn(List<BigDecimal> values) {
            addCriterion("RETURN_RATE_AMOUNT not in", values, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_RATE_AMOUNT between", value1, value2, "returnRateAmount");
            return (Criteria) this;
        }

        public Criteria andReturnRateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RETURN_RATE_AMOUNT not between", value1, value2, "returnRateAmount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}