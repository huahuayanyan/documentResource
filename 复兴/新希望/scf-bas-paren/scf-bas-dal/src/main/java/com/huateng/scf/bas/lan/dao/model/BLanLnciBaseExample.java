package com.huateng.scf.bas.lan.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLanLnciBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BLanLnciBaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BLanLnciBaseExample(BLanLnciBaseExample example) {
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

        public Criteria andLnciTypeIsNull() {
            addCriterion("LNCI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLnciTypeIsNotNull() {
            addCriterion("LNCI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLnciTypeEqualTo(String value) {
            addCriterion("LNCI_TYPE =", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeNotEqualTo(String value) {
            addCriterion("LNCI_TYPE <>", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeGreaterThan(String value) {
            addCriterion("LNCI_TYPE >", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LNCI_TYPE >=", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeLessThan(String value) {
            addCriterion("LNCI_TYPE <", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeLessThanOrEqualTo(String value) {
            addCriterion("LNCI_TYPE <=", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeLike(String value) {
            addCriterion("LNCI_TYPE like", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeNotLike(String value) {
            addCriterion("LNCI_TYPE not like", value, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeIn(List<String> values) {
            addCriterion("LNCI_TYPE in", values, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeNotIn(List<String> values) {
            addCriterion("LNCI_TYPE not in", values, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeBetween(String value1, String value2) {
            addCriterion("LNCI_TYPE between", value1, value2, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciTypeNotBetween(String value1, String value2) {
            addCriterion("LNCI_TYPE not between", value1, value2, "lnciType");
            return (Criteria) this;
        }

        public Criteria andLnciStatusIsNull() {
            addCriterion("LNCI_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLnciStatusIsNotNull() {
            addCriterion("LNCI_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLnciStatusEqualTo(String value) {
            addCriterion("LNCI_STATUS =", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusNotEqualTo(String value) {
            addCriterion("LNCI_STATUS <>", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusGreaterThan(String value) {
            addCriterion("LNCI_STATUS >", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusGreaterThanOrEqualTo(String value) {
            addCriterion("LNCI_STATUS >=", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusLessThan(String value) {
            addCriterion("LNCI_STATUS <", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusLessThanOrEqualTo(String value) {
            addCriterion("LNCI_STATUS <=", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusLike(String value) {
            addCriterion("LNCI_STATUS like", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusNotLike(String value) {
            addCriterion("LNCI_STATUS not like", value, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusIn(List<String> values) {
            addCriterion("LNCI_STATUS in", values, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusNotIn(List<String> values) {
            addCriterion("LNCI_STATUS not in", values, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusBetween(String value1, String value2) {
            addCriterion("LNCI_STATUS between", value1, value2, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciStatusNotBetween(String value1, String value2) {
            addCriterion("LNCI_STATUS not between", value1, value2, "lnciStatus");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIsNull() {
            addCriterion("LNCI_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIsNotNull() {
            addCriterion("LNCI_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLnciAmtEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT =", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT <>", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtGreaterThan(BigDecimal value) {
            addCriterion("LNCI_AMT >", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT >=", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtLessThan(BigDecimal value) {
            addCriterion("LNCI_AMT <", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_AMT <=", value, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtIn(List<BigDecimal> values) {
            addCriterion("LNCI_AMT in", values, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotIn(List<BigDecimal> values) {
            addCriterion("LNCI_AMT not in", values, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_AMT between", value1, value2, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_AMT not between", value1, value2, "lnciAmt");
            return (Criteria) this;
        }

        public Criteria andLnciBalIsNull() {
            addCriterion("LNCI_BAL is null");
            return (Criteria) this;
        }

        public Criteria andLnciBalIsNotNull() {
            addCriterion("LNCI_BAL is not null");
            return (Criteria) this;
        }

        public Criteria andLnciBalEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL =", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL <>", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalGreaterThan(BigDecimal value) {
            addCriterion("LNCI_BAL >", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL >=", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalLessThan(BigDecimal value) {
            addCriterion("LNCI_BAL <", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LNCI_BAL <=", value, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalIn(List<BigDecimal> values) {
            addCriterion("LNCI_BAL in", values, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotIn(List<BigDecimal> values) {
            addCriterion("LNCI_BAL not in", values, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_BAL between", value1, value2, "lnciBal");
            return (Criteria) this;
        }

        public Criteria andLnciBalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LNCI_BAL not between", value1, value2, "lnciBal");
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

        public Criteria andFivelevelIsNull() {
            addCriterion("FIVELEVEL is null");
            return (Criteria) this;
        }

        public Criteria andFivelevelIsNotNull() {
            addCriterion("FIVELEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andFivelevelEqualTo(String value) {
            addCriterion("FIVELEVEL =", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelNotEqualTo(String value) {
            addCriterion("FIVELEVEL <>", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelGreaterThan(String value) {
            addCriterion("FIVELEVEL >", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelGreaterThanOrEqualTo(String value) {
            addCriterion("FIVELEVEL >=", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelLessThan(String value) {
            addCriterion("FIVELEVEL <", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelLessThanOrEqualTo(String value) {
            addCriterion("FIVELEVEL <=", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelLike(String value) {
            addCriterion("FIVELEVEL like", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelNotLike(String value) {
            addCriterion("FIVELEVEL not like", value, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelIn(List<String> values) {
            addCriterion("FIVELEVEL in", values, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelNotIn(List<String> values) {
            addCriterion("FIVELEVEL not in", values, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelBetween(String value1, String value2) {
            addCriterion("FIVELEVEL between", value1, value2, "fivelevel");
            return (Criteria) this;
        }

        public Criteria andFivelevelNotBetween(String value1, String value2) {
            addCriterion("FIVELEVEL not between", value1, value2, "fivelevel");
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

        public Criteria andConfirmStatusIsNull() {
            addCriterion("CONFIRM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNotNull() {
            addCriterion("CONFIRM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusEqualTo(String value) {
            addCriterion("CONFIRM_STATUS =", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotEqualTo(String value) {
            addCriterion("CONFIRM_STATUS <>", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThan(String value) {
            addCriterion("CONFIRM_STATUS >", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_STATUS >=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThan(String value) {
            addCriterion("CONFIRM_STATUS <", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_STATUS <=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLike(String value) {
            addCriterion("CONFIRM_STATUS like", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotLike(String value) {
            addCriterion("CONFIRM_STATUS not like", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIn(List<String> values) {
            addCriterion("CONFIRM_STATUS in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotIn(List<String> values) {
            addCriterion("CONFIRM_STATUS not in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusBetween(String value1, String value2) {
            addCriterion("CONFIRM_STATUS between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_STATUS not between", value1, value2, "confirmStatus");
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

        public Criteria andAmountInIsNull() {
            addCriterion("AMOUNT_IN is null");
            return (Criteria) this;
        }

        public Criteria andAmountInIsNotNull() {
            addCriterion("AMOUNT_IN is not null");
            return (Criteria) this;
        }

        public Criteria andAmountInEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN =", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN <>", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_IN >", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN >=", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInLessThan(BigDecimal value) {
            addCriterion("AMOUNT_IN <", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_IN <=", value, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_IN in", values, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_IN not in", values, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_IN between", value1, value2, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_IN not between", value1, value2, "amountIn");
            return (Criteria) this;
        }

        public Criteria andAmountOutIsNull() {
            addCriterion("AMOUNT_OUT is null");
            return (Criteria) this;
        }

        public Criteria andAmountOutIsNotNull() {
            addCriterion("AMOUNT_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountOutEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT =", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT <>", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_OUT >", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT >=", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutLessThan(BigDecimal value) {
            addCriterion("AMOUNT_OUT <", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_OUT <=", value, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_OUT in", values, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_OUT not in", values, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_OUT between", value1, value2, "amountOut");
            return (Criteria) this;
        }

        public Criteria andAmountOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_OUT not between", value1, value2, "amountOut");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIsNull() {
            addCriterion("FIRST_BAIL_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIsNotNull() {
            addCriterion("FIRST_BAIL_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO =", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <>", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioGreaterThan(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO >", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO >=", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioLessThan(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FIRST_BAIL_RATIO <=", value, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioIn(List<BigDecimal> values) {
            addCriterion("FIRST_BAIL_RATIO in", values, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotIn(List<BigDecimal> values) {
            addCriterion("FIRST_BAIL_RATIO not in", values, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIRST_BAIL_RATIO between", value1, value2, "firstBailRatio");
            return (Criteria) this;
        }

        public Criteria andFirstBailRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FIRST_BAIL_RATIO not between", value1, value2, "firstBailRatio");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
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

        public Criteria andBillNumIsNull() {
            addCriterion("BILL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBillNumIsNotNull() {
            addCriterion("BILL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBillNumEqualTo(BigDecimal value) {
            addCriterion("BILL_NUM =", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotEqualTo(BigDecimal value) {
            addCriterion("BILL_NUM <>", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumGreaterThan(BigDecimal value) {
            addCriterion("BILL_NUM >", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_NUM >=", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLessThan(BigDecimal value) {
            addCriterion("BILL_NUM <", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_NUM <=", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumIn(List<BigDecimal> values) {
            addCriterion("BILL_NUM in", values, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotIn(List<BigDecimal> values) {
            addCriterion("BILL_NUM not in", values, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_NUM between", value1, value2, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_NUM not between", value1, value2, "billNum");
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

        public Criteria andSlaveContnoIsNull() {
            addCriterion("SLAVE_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIsNotNull() {
            addCriterion("SLAVE_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoEqualTo(String value) {
            addCriterion("SLAVE_CONTNO =", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotEqualTo(String value) {
            addCriterion("SLAVE_CONTNO <>", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoGreaterThan(String value) {
            addCriterion("SLAVE_CONTNO >", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoGreaterThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTNO >=", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLessThan(String value) {
            addCriterion("SLAVE_CONTNO <", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLessThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTNO <=", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLike(String value) {
            addCriterion("SLAVE_CONTNO like", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotLike(String value) {
            addCriterion("SLAVE_CONTNO not like", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIn(List<String> values) {
            addCriterion("SLAVE_CONTNO in", values, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotIn(List<String> values) {
            addCriterion("SLAVE_CONTNO not in", values, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTNO between", value1, value2, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTNO not between", value1, value2, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutIsNull() {
            addCriterion("AMOUNT_UP_OUT is null");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutIsNotNull() {
            addCriterion("AMOUNT_UP_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT =", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT <>", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT >", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT >=", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutLessThan(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT <", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_UP_OUT <=", value, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_UP_OUT in", values, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_UP_OUT not in", values, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_UP_OUT between", value1, value2, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andAmountUpOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_UP_OUT not between", value1, value2, "amountUpOut");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitIsNull() {
            addCriterion("SLAVE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitIsNotNull() {
            addCriterion("SLAVE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitEqualTo(String value) {
            addCriterion("SLAVE_LIMIT =", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotEqualTo(String value) {
            addCriterion("SLAVE_LIMIT <>", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitGreaterThan(String value) {
            addCriterion("SLAVE_LIMIT >", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitGreaterThanOrEqualTo(String value) {
            addCriterion("SLAVE_LIMIT >=", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitLessThan(String value) {
            addCriterion("SLAVE_LIMIT <", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitLessThanOrEqualTo(String value) {
            addCriterion("SLAVE_LIMIT <=", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitLike(String value) {
            addCriterion("SLAVE_LIMIT like", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotLike(String value) {
            addCriterion("SLAVE_LIMIT not like", value, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitIn(List<String> values) {
            addCriterion("SLAVE_LIMIT in", values, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotIn(List<String> values) {
            addCriterion("SLAVE_LIMIT not in", values, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitBetween(String value1, String value2) {
            addCriterion("SLAVE_LIMIT between", value1, value2, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andSlaveLimitNotBetween(String value1, String value2) {
            addCriterion("SLAVE_LIMIT not between", value1, value2, "slaveLimit");
            return (Criteria) this;
        }

        public Criteria andIsLockedIsNull() {
            addCriterion("IS_LOCKED is null");
            return (Criteria) this;
        }

        public Criteria andIsLockedIsNotNull() {
            addCriterion("IS_LOCKED is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockedEqualTo(String value) {
            addCriterion("IS_LOCKED =", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotEqualTo(String value) {
            addCriterion("IS_LOCKED <>", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedGreaterThan(String value) {
            addCriterion("IS_LOCKED >", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_LOCKED >=", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedLessThan(String value) {
            addCriterion("IS_LOCKED <", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedLessThanOrEqualTo(String value) {
            addCriterion("IS_LOCKED <=", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedLike(String value) {
            addCriterion("IS_LOCKED like", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotLike(String value) {
            addCriterion("IS_LOCKED not like", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedIn(List<String> values) {
            addCriterion("IS_LOCKED in", values, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotIn(List<String> values) {
            addCriterion("IS_LOCKED not in", values, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedBetween(String value1, String value2) {
            addCriterion("IS_LOCKED between", value1, value2, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotBetween(String value1, String value2) {
            addCriterion("IS_LOCKED not between", value1, value2, "isLocked");
            return (Criteria) this;
        }

        public Criteria andLockAppnoIsNull() {
            addCriterion("LOCK_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andLockAppnoIsNotNull() {
            addCriterion("LOCK_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andLockAppnoEqualTo(String value) {
            addCriterion("LOCK_APPNO =", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoNotEqualTo(String value) {
            addCriterion("LOCK_APPNO <>", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoGreaterThan(String value) {
            addCriterion("LOCK_APPNO >", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_APPNO >=", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoLessThan(String value) {
            addCriterion("LOCK_APPNO <", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoLessThanOrEqualTo(String value) {
            addCriterion("LOCK_APPNO <=", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoLike(String value) {
            addCriterion("LOCK_APPNO like", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoNotLike(String value) {
            addCriterion("LOCK_APPNO not like", value, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoIn(List<String> values) {
            addCriterion("LOCK_APPNO in", values, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoNotIn(List<String> values) {
            addCriterion("LOCK_APPNO not in", values, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoBetween(String value1, String value2) {
            addCriterion("LOCK_APPNO between", value1, value2, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andLockAppnoNotBetween(String value1, String value2) {
            addCriterion("LOCK_APPNO not between", value1, value2, "lockAppno");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtIsNull() {
            addCriterion("ADD_CASH_EQT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtIsNotNull() {
            addCriterion("ADD_CASH_EQT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtEqualTo(BigDecimal value) {
            addCriterion("ADD_CASH_EQT_AMT =", value, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtNotEqualTo(BigDecimal value) {
            addCriterion("ADD_CASH_EQT_AMT <>", value, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtGreaterThan(BigDecimal value) {
            addCriterion("ADD_CASH_EQT_AMT >", value, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_CASH_EQT_AMT >=", value, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtLessThan(BigDecimal value) {
            addCriterion("ADD_CASH_EQT_AMT <", value, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_CASH_EQT_AMT <=", value, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtIn(List<BigDecimal> values) {
            addCriterion("ADD_CASH_EQT_AMT in", values, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtNotIn(List<BigDecimal> values) {
            addCriterion("ADD_CASH_EQT_AMT not in", values, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_CASH_EQT_AMT between", value1, value2, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andAddCashEqtAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_CASH_EQT_AMT not between", value1, value2, "addCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtIsNull() {
            addCriterion("INIT_CASH_EQT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtIsNotNull() {
            addCriterion("INIT_CASH_EQT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtEqualTo(BigDecimal value) {
            addCriterion("INIT_CASH_EQT_AMT =", value, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtNotEqualTo(BigDecimal value) {
            addCriterion("INIT_CASH_EQT_AMT <>", value, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtGreaterThan(BigDecimal value) {
            addCriterion("INIT_CASH_EQT_AMT >", value, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INIT_CASH_EQT_AMT >=", value, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtLessThan(BigDecimal value) {
            addCriterion("INIT_CASH_EQT_AMT <", value, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INIT_CASH_EQT_AMT <=", value, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtIn(List<BigDecimal> values) {
            addCriterion("INIT_CASH_EQT_AMT in", values, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtNotIn(List<BigDecimal> values) {
            addCriterion("INIT_CASH_EQT_AMT not in", values, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INIT_CASH_EQT_AMT between", value1, value2, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andInitCashEqtAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INIT_CASH_EQT_AMT not between", value1, value2, "initCashEqtAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoIsNull() {
            addCriterion("LOAN_ACCT_NO is null");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoIsNotNull() {
            addCriterion("LOAN_ACCT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoEqualTo(String value) {
            addCriterion("LOAN_ACCT_NO =", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoNotEqualTo(String value) {
            addCriterion("LOAN_ACCT_NO <>", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoGreaterThan(String value) {
            addCriterion("LOAN_ACCT_NO >", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_ACCT_NO >=", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoLessThan(String value) {
            addCriterion("LOAN_ACCT_NO <", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoLessThanOrEqualTo(String value) {
            addCriterion("LOAN_ACCT_NO <=", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoLike(String value) {
            addCriterion("LOAN_ACCT_NO like", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoNotLike(String value) {
            addCriterion("LOAN_ACCT_NO not like", value, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoIn(List<String> values) {
            addCriterion("LOAN_ACCT_NO in", values, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoNotIn(List<String> values) {
            addCriterion("LOAN_ACCT_NO not in", values, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoBetween(String value1, String value2) {
            addCriterion("LOAN_ACCT_NO between", value1, value2, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andLoanAcctNoNotBetween(String value1, String value2) {
            addCriterion("LOAN_ACCT_NO not between", value1, value2, "loanAcctNo");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIsNull() {
            addCriterion("MAST_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIsNotNull() {
            addCriterion("MAST_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeEqualTo(String value) {
            addCriterion("MAST_CONTCODE =", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotEqualTo(String value) {
            addCriterion("MAST_CONTCODE <>", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThan(String value) {
            addCriterion("MAST_CONTCODE >", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE >=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThan(String value) {
            addCriterion("MAST_CONTCODE <", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE <=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLike(String value) {
            addCriterion("MAST_CONTCODE like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotLike(String value) {
            addCriterion("MAST_CONTCODE not like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIn(List<String> values) {
            addCriterion("MAST_CONTCODE in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotIn(List<String> values) {
            addCriterion("MAST_CONTCODE not in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE between", value1, value2, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE not between", value1, value2, "mastContcode");
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

        public Criteria andBussBrcodeIsNull() {
            addCriterion("BUSS_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeIsNotNull() {
            addCriterion("BUSS_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeEqualTo(String value) {
            addCriterion("BUSS_BRCODE =", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeNotEqualTo(String value) {
            addCriterion("BUSS_BRCODE <>", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeGreaterThan(String value) {
            addCriterion("BUSS_BRCODE >", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_BRCODE >=", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeLessThan(String value) {
            addCriterion("BUSS_BRCODE <", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeLessThanOrEqualTo(String value) {
            addCriterion("BUSS_BRCODE <=", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeLike(String value) {
            addCriterion("BUSS_BRCODE like", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeNotLike(String value) {
            addCriterion("BUSS_BRCODE not like", value, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeIn(List<String> values) {
            addCriterion("BUSS_BRCODE in", values, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeNotIn(List<String> values) {
            addCriterion("BUSS_BRCODE not in", values, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeBetween(String value1, String value2) {
            addCriterion("BUSS_BRCODE between", value1, value2, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andBussBrcodeNotBetween(String value1, String value2) {
            addCriterion("BUSS_BRCODE not between", value1, value2, "bussBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeIsNull() {
            addCriterion("ACCT_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeIsNotNull() {
            addCriterion("ACCT_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeEqualTo(String value) {
            addCriterion("ACCT_BRCODE =", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeNotEqualTo(String value) {
            addCriterion("ACCT_BRCODE <>", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeGreaterThan(String value) {
            addCriterion("ACCT_BRCODE >", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_BRCODE >=", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeLessThan(String value) {
            addCriterion("ACCT_BRCODE <", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeLessThanOrEqualTo(String value) {
            addCriterion("ACCT_BRCODE <=", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeLike(String value) {
            addCriterion("ACCT_BRCODE like", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeNotLike(String value) {
            addCriterion("ACCT_BRCODE not like", value, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeIn(List<String> values) {
            addCriterion("ACCT_BRCODE in", values, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeNotIn(List<String> values) {
            addCriterion("ACCT_BRCODE not in", values, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeBetween(String value1, String value2) {
            addCriterion("ACCT_BRCODE between", value1, value2, "acctBrcode");
            return (Criteria) this;
        }

        public Criteria andAcctBrcodeNotBetween(String value1, String value2) {
            addCriterion("ACCT_BRCODE not between", value1, value2, "acctBrcode");
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

        public Criteria andAccountantTypeIsNull() {
            addCriterion("ACCOUNTANT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeIsNotNull() {
            addCriterion("ACCOUNTANT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeEqualTo(String value) {
            addCriterion("ACCOUNTANT_TYPE =", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeNotEqualTo(String value) {
            addCriterion("ACCOUNTANT_TYPE <>", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeGreaterThan(String value) {
            addCriterion("ACCOUNTANT_TYPE >", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNTANT_TYPE >=", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeLessThan(String value) {
            addCriterion("ACCOUNTANT_TYPE <", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNTANT_TYPE <=", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeLike(String value) {
            addCriterion("ACCOUNTANT_TYPE like", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeNotLike(String value) {
            addCriterion("ACCOUNTANT_TYPE not like", value, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeIn(List<String> values) {
            addCriterion("ACCOUNTANT_TYPE in", values, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeNotIn(List<String> values) {
            addCriterion("ACCOUNTANT_TYPE not in", values, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeBetween(String value1, String value2) {
            addCriterion("ACCOUNTANT_TYPE between", value1, value2, "accountantType");
            return (Criteria) this;
        }

        public Criteria andAccountantTypeNotBetween(String value1, String value2) {
            addCriterion("ACCOUNTANT_TYPE not between", value1, value2, "accountantType");
            return (Criteria) this;
        }

        public Criteria andDepositDateIsNull() {
            addCriterion("DEPOSIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDepositDateIsNotNull() {
            addCriterion("DEPOSIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDepositDateEqualTo(String value) {
            addCriterion("DEPOSIT_DATE =", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateNotEqualTo(String value) {
            addCriterion("DEPOSIT_DATE <>", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateGreaterThan(String value) {
            addCriterion("DEPOSIT_DATE >", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_DATE >=", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateLessThan(String value) {
            addCriterion("DEPOSIT_DATE <", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_DATE <=", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateLike(String value) {
            addCriterion("DEPOSIT_DATE like", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateNotLike(String value) {
            addCriterion("DEPOSIT_DATE not like", value, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateIn(List<String> values) {
            addCriterion("DEPOSIT_DATE in", values, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateNotIn(List<String> values) {
            addCriterion("DEPOSIT_DATE not in", values, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateBetween(String value1, String value2) {
            addCriterion("DEPOSIT_DATE between", value1, value2, "depositDate");
            return (Criteria) this;
        }

        public Criteria andDepositDateNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_DATE not between", value1, value2, "depositDate");
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

        public Criteria andAccruedStatusIsNull() {
            addCriterion("ACCRUED_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusIsNotNull() {
            addCriterion("ACCRUED_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusEqualTo(String value) {
            addCriterion("ACCRUED_STATUS =", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusNotEqualTo(String value) {
            addCriterion("ACCRUED_STATUS <>", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusGreaterThan(String value) {
            addCriterion("ACCRUED_STATUS >", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ACCRUED_STATUS >=", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusLessThan(String value) {
            addCriterion("ACCRUED_STATUS <", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusLessThanOrEqualTo(String value) {
            addCriterion("ACCRUED_STATUS <=", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusLike(String value) {
            addCriterion("ACCRUED_STATUS like", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusNotLike(String value) {
            addCriterion("ACCRUED_STATUS not like", value, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusIn(List<String> values) {
            addCriterion("ACCRUED_STATUS in", values, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusNotIn(List<String> values) {
            addCriterion("ACCRUED_STATUS not in", values, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusBetween(String value1, String value2) {
            addCriterion("ACCRUED_STATUS between", value1, value2, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andAccruedStatusNotBetween(String value1, String value2) {
            addCriterion("ACCRUED_STATUS not between", value1, value2, "accruedStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusIsNull() {
            addCriterion("LOAN_ACCT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusIsNotNull() {
            addCriterion("LOAN_ACCT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusEqualTo(String value) {
            addCriterion("LOAN_ACCT_STATUS =", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusNotEqualTo(String value) {
            addCriterion("LOAN_ACCT_STATUS <>", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusGreaterThan(String value) {
            addCriterion("LOAN_ACCT_STATUS >", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_ACCT_STATUS >=", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusLessThan(String value) {
            addCriterion("LOAN_ACCT_STATUS <", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusLessThanOrEqualTo(String value) {
            addCriterion("LOAN_ACCT_STATUS <=", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusLike(String value) {
            addCriterion("LOAN_ACCT_STATUS like", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusNotLike(String value) {
            addCriterion("LOAN_ACCT_STATUS not like", value, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusIn(List<String> values) {
            addCriterion("LOAN_ACCT_STATUS in", values, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusNotIn(List<String> values) {
            addCriterion("LOAN_ACCT_STATUS not in", values, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusBetween(String value1, String value2) {
            addCriterion("LOAN_ACCT_STATUS between", value1, value2, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoanAcctStatusNotBetween(String value1, String value2) {
            addCriterion("LOAN_ACCT_STATUS not between", value1, value2, "loanAcctStatus");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderIsNull() {
            addCriterion("LOANS_CHARGE_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderIsNotNull() {
            addCriterion("LOANS_CHARGE_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderEqualTo(String value) {
            addCriterion("LOANS_CHARGE_ORDER =", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderNotEqualTo(String value) {
            addCriterion("LOANS_CHARGE_ORDER <>", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderGreaterThan(String value) {
            addCriterion("LOANS_CHARGE_ORDER >", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderGreaterThanOrEqualTo(String value) {
            addCriterion("LOANS_CHARGE_ORDER >=", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderLessThan(String value) {
            addCriterion("LOANS_CHARGE_ORDER <", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderLessThanOrEqualTo(String value) {
            addCriterion("LOANS_CHARGE_ORDER <=", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderLike(String value) {
            addCriterion("LOANS_CHARGE_ORDER like", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderNotLike(String value) {
            addCriterion("LOANS_CHARGE_ORDER not like", value, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderIn(List<String> values) {
            addCriterion("LOANS_CHARGE_ORDER in", values, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderNotIn(List<String> values) {
            addCriterion("LOANS_CHARGE_ORDER not in", values, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderBetween(String value1, String value2) {
            addCriterion("LOANS_CHARGE_ORDER between", value1, value2, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andLoansChargeOrderNotBetween(String value1, String value2) {
            addCriterion("LOANS_CHARGE_ORDER not between", value1, value2, "loansChargeOrder");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtIsNull() {
            addCriterion("ISSUED_AMT is null");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtIsNotNull() {
            addCriterion("ISSUED_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMT =", value, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtNotEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMT <>", value, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtGreaterThan(BigDecimal value) {
            addCriterion("ISSUED_AMT >", value, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMT >=", value, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtLessThan(BigDecimal value) {
            addCriterion("ISSUED_AMT <", value, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMT <=", value, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtIn(List<BigDecimal> values) {
            addCriterion("ISSUED_AMT in", values, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtNotIn(List<BigDecimal> values) {
            addCriterion("ISSUED_AMT not in", values, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISSUED_AMT between", value1, value2, "issuedAmt");
            return (Criteria) this;
        }

        public Criteria andIssuedAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISSUED_AMT not between", value1, value2, "issuedAmt");
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

        public Criteria andNormalCapitalIsNull() {
            addCriterion("NORMAL_CAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalIsNotNull() {
            addCriterion("NORMAL_CAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalEqualTo(BigDecimal value) {
            addCriterion("NORMAL_CAPITAL =", value, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalNotEqualTo(BigDecimal value) {
            addCriterion("NORMAL_CAPITAL <>", value, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalGreaterThan(BigDecimal value) {
            addCriterion("NORMAL_CAPITAL >", value, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NORMAL_CAPITAL >=", value, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalLessThan(BigDecimal value) {
            addCriterion("NORMAL_CAPITAL <", value, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NORMAL_CAPITAL <=", value, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalIn(List<BigDecimal> values) {
            addCriterion("NORMAL_CAPITAL in", values, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalNotIn(List<BigDecimal> values) {
            addCriterion("NORMAL_CAPITAL not in", values, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NORMAL_CAPITAL between", value1, value2, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andNormalCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NORMAL_CAPITAL not between", value1, value2, "normalCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalIsNull() {
            addCriterion("OVERDUE_CAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalIsNotNull() {
            addCriterion("OVERDUE_CAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_CAPITAL =", value, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalNotEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_CAPITAL <>", value, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalGreaterThan(BigDecimal value) {
            addCriterion("OVERDUE_CAPITAL >", value, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_CAPITAL >=", value, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalLessThan(BigDecimal value) {
            addCriterion("OVERDUE_CAPITAL <", value, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_CAPITAL <=", value, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_CAPITAL in", values, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalNotIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_CAPITAL not in", values, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_CAPITAL between", value1, value2, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andOverdueCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_CAPITAL not between", value1, value2, "overdueCapital");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalIsNull() {
            addCriterion("IDLE_CAPITTAL is null");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalIsNotNull() {
            addCriterion("IDLE_CAPITTAL is not null");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalEqualTo(BigDecimal value) {
            addCriterion("IDLE_CAPITTAL =", value, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalNotEqualTo(BigDecimal value) {
            addCriterion("IDLE_CAPITTAL <>", value, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalGreaterThan(BigDecimal value) {
            addCriterion("IDLE_CAPITTAL >", value, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IDLE_CAPITTAL >=", value, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalLessThan(BigDecimal value) {
            addCriterion("IDLE_CAPITTAL <", value, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IDLE_CAPITTAL <=", value, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalIn(List<BigDecimal> values) {
            addCriterion("IDLE_CAPITTAL in", values, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalNotIn(List<BigDecimal> values) {
            addCriterion("IDLE_CAPITTAL not in", values, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IDLE_CAPITTAL between", value1, value2, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andIdleCapittalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IDLE_CAPITTAL not between", value1, value2, "idleCapittal");
            return (Criteria) this;
        }

        public Criteria andBadCapitalIsNull() {
            addCriterion("BAD_CAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andBadCapitalIsNotNull() {
            addCriterion("BAD_CAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andBadCapitalEqualTo(BigDecimal value) {
            addCriterion("BAD_CAPITAL =", value, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalNotEqualTo(BigDecimal value) {
            addCriterion("BAD_CAPITAL <>", value, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalGreaterThan(BigDecimal value) {
            addCriterion("BAD_CAPITAL >", value, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAD_CAPITAL >=", value, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalLessThan(BigDecimal value) {
            addCriterion("BAD_CAPITAL <", value, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAD_CAPITAL <=", value, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalIn(List<BigDecimal> values) {
            addCriterion("BAD_CAPITAL in", values, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalNotIn(List<BigDecimal> values) {
            addCriterion("BAD_CAPITAL not in", values, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAD_CAPITAL between", value1, value2, "badCapital");
            return (Criteria) this;
        }

        public Criteria andBadCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAD_CAPITAL not between", value1, value2, "badCapital");
            return (Criteria) this;
        }

        public Criteria andLoanFundIsNull() {
            addCriterion("LOAN_FUND is null");
            return (Criteria) this;
        }

        public Criteria andLoanFundIsNotNull() {
            addCriterion("LOAN_FUND is not null");
            return (Criteria) this;
        }

        public Criteria andLoanFundEqualTo(BigDecimal value) {
            addCriterion("LOAN_FUND =", value, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_FUND <>", value, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundGreaterThan(BigDecimal value) {
            addCriterion("LOAN_FUND >", value, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_FUND >=", value, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundLessThan(BigDecimal value) {
            addCriterion("LOAN_FUND <", value, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_FUND <=", value, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundIn(List<BigDecimal> values) {
            addCriterion("LOAN_FUND in", values, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_FUND not in", values, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_FUND between", value1, value2, "loanFund");
            return (Criteria) this;
        }

        public Criteria andLoanFundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_FUND not between", value1, value2, "loanFund");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntIsNull() {
            addCriterion("RECEIVABLE_ACCURED_INT is null");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntIsNotNull() {
            addCriterion("RECEIVABLE_ACCURED_INT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_INT =", value, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_INT <>", value, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntGreaterThan(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_INT >", value, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_INT >=", value, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntLessThan(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_INT <", value, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_INT <=", value, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_ACCURED_INT in", values, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_ACCURED_INT not in", values, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_ACCURED_INT between", value1, value2, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_ACCURED_INT not between", value1, value2, "receivableAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntIsNull() {
            addCriterion("COLLECTION_ACCURED_INT is null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntIsNotNull() {
            addCriterion("COLLECTION_ACCURED_INT is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_INT =", value, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntNotEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_INT <>", value, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntGreaterThan(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_INT >", value, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_INT >=", value, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntLessThan(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_INT <", value, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_INT <=", value, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_ACCURED_INT in", values, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntNotIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_ACCURED_INT not in", values, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_ACCURED_INT between", value1, value2, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_ACCURED_INT not between", value1, value2, "collectionAccuredInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntIsNull() {
            addCriterion("RECEIVABLE_INT is null");
            return (Criteria) this;
        }

        public Criteria andReceivableIntIsNotNull() {
            addCriterion("RECEIVABLE_INT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableIntEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_INT =", value, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_INT <>", value, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntGreaterThan(BigDecimal value) {
            addCriterion("RECEIVABLE_INT >", value, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_INT >=", value, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntLessThan(BigDecimal value) {
            addCriterion("RECEIVABLE_INT <", value, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_INT <=", value, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_INT in", values, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_INT not in", values, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_INT between", value1, value2, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andReceivableIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_INT not between", value1, value2, "receivableInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntIsNull() {
            addCriterion("COLLECTION_INT is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIntIsNotNull() {
            addCriterion("COLLECTION_INT is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIntEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_INT =", value, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntNotEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_INT <>", value, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntGreaterThan(BigDecimal value) {
            addCriterion("COLLECTION_INT >", value, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_INT >=", value, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntLessThan(BigDecimal value) {
            addCriterion("COLLECTION_INT <", value, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_INT <=", value, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_INT in", values, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntNotIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_INT not in", values, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_INT between", value1, value2, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andCollectionIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_INT not between", value1, value2, "collectionInt");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintIsNull() {
            addCriterion("RECEIVABLE_ACCURED_PINT is null");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintIsNotNull() {
            addCriterion("RECEIVABLE_ACCURED_PINT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_PINT =", value, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_PINT <>", value, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintGreaterThan(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_PINT >", value, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_PINT >=", value, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintLessThan(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_PINT <", value, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_ACCURED_PINT <=", value, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_ACCURED_PINT in", values, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_ACCURED_PINT not in", values, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_ACCURED_PINT between", value1, value2, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivableAccuredPintNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_ACCURED_PINT not between", value1, value2, "receivableAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintIsNull() {
            addCriterion("COLLECTION_ACCURED_PINT is null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintIsNotNull() {
            addCriterion("COLLECTION_ACCURED_PINT is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_PINT =", value, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintNotEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_PINT <>", value, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintGreaterThan(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_PINT >", value, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_PINT >=", value, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintLessThan(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_PINT <", value, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_ACCURED_PINT <=", value, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_ACCURED_PINT in", values, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintNotIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_ACCURED_PINT not in", values, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_ACCURED_PINT between", value1, value2, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andCollectionAccuredPintNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_ACCURED_PINT not between", value1, value2, "collectionAccuredPint");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntIsNull() {
            addCriterion("RECEIVABLE_PUNISH_INT is null");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntIsNotNull() {
            addCriterion("RECEIVABLE_PUNISH_INT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_PUNISH_INT =", value, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_PUNISH_INT <>", value, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntGreaterThan(BigDecimal value) {
            addCriterion("RECEIVABLE_PUNISH_INT >", value, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_PUNISH_INT >=", value, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntLessThan(BigDecimal value) {
            addCriterion("RECEIVABLE_PUNISH_INT <", value, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_PUNISH_INT <=", value, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_PUNISH_INT in", values, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_PUNISH_INT not in", values, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_PUNISH_INT between", value1, value2, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andReceivablePunishIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_PUNISH_INT not between", value1, value2, "receivablePunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntIsNull() {
            addCriterion("COLLECTION_PUNISH_INT is null");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntIsNotNull() {
            addCriterion("COLLECTION_PUNISH_INT is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_PUNISH_INT =", value, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntNotEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_PUNISH_INT <>", value, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntGreaterThan(BigDecimal value) {
            addCriterion("COLLECTION_PUNISH_INT >", value, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_PUNISH_INT >=", value, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntLessThan(BigDecimal value) {
            addCriterion("COLLECTION_PUNISH_INT <", value, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COLLECTION_PUNISH_INT <=", value, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_PUNISH_INT in", values, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntNotIn(List<BigDecimal> values) {
            addCriterion("COLLECTION_PUNISH_INT not in", values, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_PUNISH_INT between", value1, value2, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andCollectionPunishIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLLECTION_PUNISH_INT not between", value1, value2, "collectionPunishInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntIsNull() {
            addCriterion("ACCURED_COMPOUNT_INT is null");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntIsNotNull() {
            addCriterion("ACCURED_COMPOUNT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntEqualTo(BigDecimal value) {
            addCriterion("ACCURED_COMPOUNT_INT =", value, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntNotEqualTo(BigDecimal value) {
            addCriterion("ACCURED_COMPOUNT_INT <>", value, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntGreaterThan(BigDecimal value) {
            addCriterion("ACCURED_COMPOUNT_INT >", value, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCURED_COMPOUNT_INT >=", value, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntLessThan(BigDecimal value) {
            addCriterion("ACCURED_COMPOUNT_INT <", value, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCURED_COMPOUNT_INT <=", value, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntIn(List<BigDecimal> values) {
            addCriterion("ACCURED_COMPOUNT_INT in", values, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntNotIn(List<BigDecimal> values) {
            addCriterion("ACCURED_COMPOUNT_INT not in", values, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCURED_COMPOUNT_INT between", value1, value2, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredCompountIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCURED_COMPOUNT_INT not between", value1, value2, "accuredCompountInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntIsNull() {
            addCriterion("COMPOUND_INT is null");
            return (Criteria) this;
        }

        public Criteria andCompoundIntIsNotNull() {
            addCriterion("COMPOUND_INT is not null");
            return (Criteria) this;
        }

        public Criteria andCompoundIntEqualTo(BigDecimal value) {
            addCriterion("COMPOUND_INT =", value, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntNotEqualTo(BigDecimal value) {
            addCriterion("COMPOUND_INT <>", value, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntGreaterThan(BigDecimal value) {
            addCriterion("COMPOUND_INT >", value, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMPOUND_INT >=", value, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntLessThan(BigDecimal value) {
            addCriterion("COMPOUND_INT <", value, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMPOUND_INT <=", value, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntIn(List<BigDecimal> values) {
            addCriterion("COMPOUND_INT in", values, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntNotIn(List<BigDecimal> values) {
            addCriterion("COMPOUND_INT not in", values, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMPOUND_INT between", value1, value2, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andCompoundIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMPOUND_INT not between", value1, value2, "compoundInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntIsNull() {
            addCriterion("ACCURED_DISCOUNT_INT is null");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntIsNotNull() {
            addCriterion("ACCURED_DISCOUNT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntEqualTo(BigDecimal value) {
            addCriterion("ACCURED_DISCOUNT_INT =", value, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntNotEqualTo(BigDecimal value) {
            addCriterion("ACCURED_DISCOUNT_INT <>", value, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntGreaterThan(BigDecimal value) {
            addCriterion("ACCURED_DISCOUNT_INT >", value, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCURED_DISCOUNT_INT >=", value, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntLessThan(BigDecimal value) {
            addCriterion("ACCURED_DISCOUNT_INT <", value, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCURED_DISCOUNT_INT <=", value, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntIn(List<BigDecimal> values) {
            addCriterion("ACCURED_DISCOUNT_INT in", values, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntNotIn(List<BigDecimal> values) {
            addCriterion("ACCURED_DISCOUNT_INT not in", values, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCURED_DISCOUNT_INT between", value1, value2, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andAccuredDiscountIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCURED_DISCOUNT_INT not between", value1, value2, "accuredDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntIsNull() {
            addCriterion("RECEIVABLE_DISCOUNT_INT is null");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntIsNotNull() {
            addCriterion("RECEIVABLE_DISCOUNT_INT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_DISCOUNT_INT =", value, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_DISCOUNT_INT <>", value, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntGreaterThan(BigDecimal value) {
            addCriterion("RECEIVABLE_DISCOUNT_INT >", value, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_DISCOUNT_INT >=", value, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntLessThan(BigDecimal value) {
            addCriterion("RECEIVABLE_DISCOUNT_INT <", value, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_DISCOUNT_INT <=", value, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_DISCOUNT_INT in", values, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_DISCOUNT_INT not in", values, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_DISCOUNT_INT between", value1, value2, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andReceivableDiscountIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE_DISCOUNT_INT not between", value1, value2, "receivableDiscountInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntIsNull() {
            addCriterion("DEFERRED_INT is null");
            return (Criteria) this;
        }

        public Criteria andDeferredIntIsNotNull() {
            addCriterion("DEFERRED_INT is not null");
            return (Criteria) this;
        }

        public Criteria andDeferredIntEqualTo(BigDecimal value) {
            addCriterion("DEFERRED_INT =", value, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntNotEqualTo(BigDecimal value) {
            addCriterion("DEFERRED_INT <>", value, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntGreaterThan(BigDecimal value) {
            addCriterion("DEFERRED_INT >", value, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEFERRED_INT >=", value, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntLessThan(BigDecimal value) {
            addCriterion("DEFERRED_INT <", value, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEFERRED_INT <=", value, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntIn(List<BigDecimal> values) {
            addCriterion("DEFERRED_INT in", values, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntNotIn(List<BigDecimal> values) {
            addCriterion("DEFERRED_INT not in", values, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEFERRED_INT between", value1, value2, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andDeferredIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEFERRED_INT not between", value1, value2, "deferredInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalIsNull() {
            addCriterion("VERIFIED_CAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalIsNotNull() {
            addCriterion("VERIFIED_CAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_CAPITAL =", value, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalNotEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_CAPITAL <>", value, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalGreaterThan(BigDecimal value) {
            addCriterion("VERIFIED_CAPITAL >", value, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_CAPITAL >=", value, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalLessThan(BigDecimal value) {
            addCriterion("VERIFIED_CAPITAL <", value, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_CAPITAL <=", value, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalIn(List<BigDecimal> values) {
            addCriterion("VERIFIED_CAPITAL in", values, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalNotIn(List<BigDecimal> values) {
            addCriterion("VERIFIED_CAPITAL not in", values, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERIFIED_CAPITAL between", value1, value2, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERIFIED_CAPITAL not between", value1, value2, "verifiedCapital");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntIsNull() {
            addCriterion("VERIFIED_INT is null");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntIsNotNull() {
            addCriterion("VERIFIED_INT is not null");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_INT =", value, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntNotEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_INT <>", value, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntGreaterThan(BigDecimal value) {
            addCriterion("VERIFIED_INT >", value, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_INT >=", value, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntLessThan(BigDecimal value) {
            addCriterion("VERIFIED_INT <", value, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VERIFIED_INT <=", value, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntIn(List<BigDecimal> values) {
            addCriterion("VERIFIED_INT in", values, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntNotIn(List<BigDecimal> values) {
            addCriterion("VERIFIED_INT not in", values, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERIFIED_INT between", value1, value2, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andVerifiedIntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERIFIED_INT not between", value1, value2, "verifiedInt");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("INTEREST is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("INTEREST is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(BigDecimal value) {
            addCriterion("INTEREST =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(BigDecimal value) {
            addCriterion("INTEREST <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(BigDecimal value) {
            addCriterion("INTEREST >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(BigDecimal value) {
            addCriterion("INTEREST <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<BigDecimal> values) {
            addCriterion("INTEREST in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<BigDecimal> values) {
            addCriterion("INTEREST not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeIsNull() {
            addCriterion("RECEIVALBE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeIsNotNull() {
            addCriterion("RECEIVALBE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FEE =", value, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FEE <>", value, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeGreaterThan(BigDecimal value) {
            addCriterion("RECEIVALBE_FEE >", value, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FEE >=", value, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeLessThan(BigDecimal value) {
            addCriterion("RECEIVALBE_FEE <", value, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FEE <=", value, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeIn(List<BigDecimal> values) {
            addCriterion("RECEIVALBE_FEE in", values, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVALBE_FEE not in", values, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVALBE_FEE between", value1, value2, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVALBE_FEE not between", value1, value2, "receivalbeFee");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("FEE is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineIsNull() {
            addCriterion("RECEIVALBE_FINE is null");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineIsNotNull() {
            addCriterion("RECEIVALBE_FINE is not null");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FINE =", value, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FINE <>", value, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineGreaterThan(BigDecimal value) {
            addCriterion("RECEIVALBE_FINE >", value, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FINE >=", value, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineLessThan(BigDecimal value) {
            addCriterion("RECEIVALBE_FINE <", value, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVALBE_FINE <=", value, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineIn(List<BigDecimal> values) {
            addCriterion("RECEIVALBE_FINE in", values, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVALBE_FINE not in", values, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVALBE_FINE between", value1, value2, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andReceivalbeFineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVALBE_FINE not between", value1, value2, "receivalbeFine");
            return (Criteria) this;
        }

        public Criteria andFineIsNull() {
            addCriterion("FINE is null");
            return (Criteria) this;
        }

        public Criteria andFineIsNotNull() {
            addCriterion("FINE is not null");
            return (Criteria) this;
        }

        public Criteria andFineEqualTo(BigDecimal value) {
            addCriterion("FINE =", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotEqualTo(BigDecimal value) {
            addCriterion("FINE <>", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThan(BigDecimal value) {
            addCriterion("FINE >", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FINE >=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThan(BigDecimal value) {
            addCriterion("FINE <", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FINE <=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineIn(List<BigDecimal> values) {
            addCriterion("FINE in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotIn(List<BigDecimal> values) {
            addCriterion("FINE not in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINE between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINE not between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andReservedAmtIsNull() {
            addCriterion("RESERVED_AMT is null");
            return (Criteria) this;
        }

        public Criteria andReservedAmtIsNotNull() {
            addCriterion("RESERVED_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andReservedAmtEqualTo(BigDecimal value) {
            addCriterion("RESERVED_AMT =", value, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtNotEqualTo(BigDecimal value) {
            addCriterion("RESERVED_AMT <>", value, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtGreaterThan(BigDecimal value) {
            addCriterion("RESERVED_AMT >", value, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_AMT >=", value, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtLessThan(BigDecimal value) {
            addCriterion("RESERVED_AMT <", value, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_AMT <=", value, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtIn(List<BigDecimal> values) {
            addCriterion("RESERVED_AMT in", values, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtNotIn(List<BigDecimal> values) {
            addCriterion("RESERVED_AMT not in", values, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_AMT between", value1, value2, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andReservedAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_AMT not between", value1, value2, "reservedAmt");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateIsNull() {
            addCriterion("LAST_ACCT_TXDATE is null");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateIsNotNull() {
            addCriterion("LAST_ACCT_TXDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateEqualTo(String value) {
            addCriterion("LAST_ACCT_TXDATE =", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateNotEqualTo(String value) {
            addCriterion("LAST_ACCT_TXDATE <>", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateGreaterThan(String value) {
            addCriterion("LAST_ACCT_TXDATE >", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_ACCT_TXDATE >=", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateLessThan(String value) {
            addCriterion("LAST_ACCT_TXDATE <", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateLessThanOrEqualTo(String value) {
            addCriterion("LAST_ACCT_TXDATE <=", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateLike(String value) {
            addCriterion("LAST_ACCT_TXDATE like", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateNotLike(String value) {
            addCriterion("LAST_ACCT_TXDATE not like", value, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateIn(List<String> values) {
            addCriterion("LAST_ACCT_TXDATE in", values, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateNotIn(List<String> values) {
            addCriterion("LAST_ACCT_TXDATE not in", values, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateBetween(String value1, String value2) {
            addCriterion("LAST_ACCT_TXDATE between", value1, value2, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andLastAcctTxdateNotBetween(String value1, String value2) {
            addCriterion("LAST_ACCT_TXDATE not between", value1, value2, "lastAcctTxdate");
            return (Criteria) this;
        }

        public Criteria andDetailNoIsNull() {
            addCriterion("DETAIL_NO is null");
            return (Criteria) this;
        }

        public Criteria andDetailNoIsNotNull() {
            addCriterion("DETAIL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNoEqualTo(String value) {
            addCriterion("DETAIL_NO =", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotEqualTo(String value) {
            addCriterion("DETAIL_NO <>", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoGreaterThan(String value) {
            addCriterion("DETAIL_NO >", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_NO >=", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLessThan(String value) {
            addCriterion("DETAIL_NO <", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_NO <=", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLike(String value) {
            addCriterion("DETAIL_NO like", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotLike(String value) {
            addCriterion("DETAIL_NO not like", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoIn(List<String> values) {
            addCriterion("DETAIL_NO in", values, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotIn(List<String> values) {
            addCriterion("DETAIL_NO not in", values, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoBetween(String value1, String value2) {
            addCriterion("DETAIL_NO between", value1, value2, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotBetween(String value1, String value2) {
            addCriterion("DETAIL_NO not between", value1, value2, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeIsNull() {
            addCriterion("DEPOSIT_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeIsNotNull() {
            addCriterion("DEPOSIT_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE =", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE <>", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeGreaterThan(String value) {
            addCriterion("DEPOSIT_BRCODE >", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE >=", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeLessThan(String value) {
            addCriterion("DEPOSIT_BRCODE <", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BRCODE <=", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeLike(String value) {
            addCriterion("DEPOSIT_BRCODE like", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotLike(String value) {
            addCriterion("DEPOSIT_BRCODE not like", value, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeIn(List<String> values) {
            addCriterion("DEPOSIT_BRCODE in", values, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotIn(List<String> values) {
            addCriterion("DEPOSIT_BRCODE not in", values, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BRCODE between", value1, value2, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositBrcodeNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BRCODE not between", value1, value2, "depositBrcode");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoIsNull() {
            addCriterion("DEPOSIT_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoIsNotNull() {
            addCriterion("DEPOSIT_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoEqualTo(String value) {
            addCriterion("DEPOSIT_TLRNO =", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoNotEqualTo(String value) {
            addCriterion("DEPOSIT_TLRNO <>", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoGreaterThan(String value) {
            addCriterion("DEPOSIT_TLRNO >", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_TLRNO >=", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoLessThan(String value) {
            addCriterion("DEPOSIT_TLRNO <", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_TLRNO <=", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoLike(String value) {
            addCriterion("DEPOSIT_TLRNO like", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoNotLike(String value) {
            addCriterion("DEPOSIT_TLRNO not like", value, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoIn(List<String> values) {
            addCriterion("DEPOSIT_TLRNO in", values, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoNotIn(List<String> values) {
            addCriterion("DEPOSIT_TLRNO not in", values, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoBetween(String value1, String value2) {
            addCriterion("DEPOSIT_TLRNO between", value1, value2, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andDepositTlrnoNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_TLRNO not between", value1, value2, "depositTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateIsNull() {
            addCriterion("MAINTENANCE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateIsNotNull() {
            addCriterion("MAINTENANCE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateEqualTo(String value) {
            addCriterion("MAINTENANCE_DATE =", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateNotEqualTo(String value) {
            addCriterion("MAINTENANCE_DATE <>", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateGreaterThan(String value) {
            addCriterion("MAINTENANCE_DATE >", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateGreaterThanOrEqualTo(String value) {
            addCriterion("MAINTENANCE_DATE >=", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateLessThan(String value) {
            addCriterion("MAINTENANCE_DATE <", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateLessThanOrEqualTo(String value) {
            addCriterion("MAINTENANCE_DATE <=", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateLike(String value) {
            addCriterion("MAINTENANCE_DATE like", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateNotLike(String value) {
            addCriterion("MAINTENANCE_DATE not like", value, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateIn(List<String> values) {
            addCriterion("MAINTENANCE_DATE in", values, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateNotIn(List<String> values) {
            addCriterion("MAINTENANCE_DATE not in", values, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateBetween(String value1, String value2) {
            addCriterion("MAINTENANCE_DATE between", value1, value2, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDateNotBetween(String value1, String value2) {
            addCriterion("MAINTENANCE_DATE not between", value1, value2, "maintenanceDate");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoIsNull() {
            addCriterion("MAINTENANCE_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoIsNotNull() {
            addCriterion("MAINTENANCE_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoEqualTo(String value) {
            addCriterion("MAINTENANCE_TLRNO =", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoNotEqualTo(String value) {
            addCriterion("MAINTENANCE_TLRNO <>", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoGreaterThan(String value) {
            addCriterion("MAINTENANCE_TLRNO >", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("MAINTENANCE_TLRNO >=", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoLessThan(String value) {
            addCriterion("MAINTENANCE_TLRNO <", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoLessThanOrEqualTo(String value) {
            addCriterion("MAINTENANCE_TLRNO <=", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoLike(String value) {
            addCriterion("MAINTENANCE_TLRNO like", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoNotLike(String value) {
            addCriterion("MAINTENANCE_TLRNO not like", value, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoIn(List<String> values) {
            addCriterion("MAINTENANCE_TLRNO in", values, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoNotIn(List<String> values) {
            addCriterion("MAINTENANCE_TLRNO not in", values, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoBetween(String value1, String value2) {
            addCriterion("MAINTENANCE_TLRNO between", value1, value2, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTlrnoNotBetween(String value1, String value2) {
            addCriterion("MAINTENANCE_TLRNO not between", value1, value2, "maintenanceTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationDateIsNull() {
            addCriterion("CANCELLATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCancellationDateIsNotNull() {
            addCriterion("CANCELLATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCancellationDateEqualTo(String value) {
            addCriterion("CANCELLATION_DATE =", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateNotEqualTo(String value) {
            addCriterion("CANCELLATION_DATE <>", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateGreaterThan(String value) {
            addCriterion("CANCELLATION_DATE >", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateGreaterThanOrEqualTo(String value) {
            addCriterion("CANCELLATION_DATE >=", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateLessThan(String value) {
            addCriterion("CANCELLATION_DATE <", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateLessThanOrEqualTo(String value) {
            addCriterion("CANCELLATION_DATE <=", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateLike(String value) {
            addCriterion("CANCELLATION_DATE like", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateNotLike(String value) {
            addCriterion("CANCELLATION_DATE not like", value, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateIn(List<String> values) {
            addCriterion("CANCELLATION_DATE in", values, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateNotIn(List<String> values) {
            addCriterion("CANCELLATION_DATE not in", values, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateBetween(String value1, String value2) {
            addCriterion("CANCELLATION_DATE between", value1, value2, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationDateNotBetween(String value1, String value2) {
            addCriterion("CANCELLATION_DATE not between", value1, value2, "cancellationDate");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoIsNull() {
            addCriterion("CANCELLATION_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoIsNotNull() {
            addCriterion("CANCELLATION_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoEqualTo(String value) {
            addCriterion("CANCELLATION_TLRNO =", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoNotEqualTo(String value) {
            addCriterion("CANCELLATION_TLRNO <>", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoGreaterThan(String value) {
            addCriterion("CANCELLATION_TLRNO >", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("CANCELLATION_TLRNO >=", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoLessThan(String value) {
            addCriterion("CANCELLATION_TLRNO <", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoLessThanOrEqualTo(String value) {
            addCriterion("CANCELLATION_TLRNO <=", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoLike(String value) {
            addCriterion("CANCELLATION_TLRNO like", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoNotLike(String value) {
            addCriterion("CANCELLATION_TLRNO not like", value, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoIn(List<String> values) {
            addCriterion("CANCELLATION_TLRNO in", values, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoNotIn(List<String> values) {
            addCriterion("CANCELLATION_TLRNO not in", values, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoBetween(String value1, String value2) {
            addCriterion("CANCELLATION_TLRNO between", value1, value2, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andCancellationTlrnoNotBetween(String value1, String value2) {
            addCriterion("CANCELLATION_TLRNO not between", value1, value2, "cancellationTlrno");
            return (Criteria) this;
        }

        public Criteria andTimestampsIsNull() {
            addCriterion("TIMESTAMPS is null");
            return (Criteria) this;
        }

        public Criteria andTimestampsIsNotNull() {
            addCriterion("TIMESTAMPS is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampsEqualTo(Date value) {
            addCriterion("TIMESTAMPS =", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotEqualTo(Date value) {
            addCriterion("TIMESTAMPS <>", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsGreaterThan(Date value) {
            addCriterion("TIMESTAMPS >", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsGreaterThanOrEqualTo(Date value) {
            addCriterion("TIMESTAMPS >=", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsLessThan(Date value) {
            addCriterion("TIMESTAMPS <", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsLessThanOrEqualTo(Date value) {
            addCriterion("TIMESTAMPS <=", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsIn(List<Date> values) {
            addCriterion("TIMESTAMPS in", values, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotIn(List<Date> values) {
            addCriterion("TIMESTAMPS not in", values, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsBetween(Date value1, Date value2) {
            addCriterion("TIMESTAMPS between", value1, value2, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotBetween(Date value1, Date value2) {
            addCriterion("TIMESTAMPS not between", value1, value2, "timestamps");
            return (Criteria) this;
        }

        public Criteria andRepayMethodIsNull() {
            addCriterion("REPAY_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andRepayMethodIsNotNull() {
            addCriterion("REPAY_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andRepayMethodEqualTo(String value) {
            addCriterion("REPAY_METHOD =", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodNotEqualTo(String value) {
            addCriterion("REPAY_METHOD <>", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodGreaterThan(String value) {
            addCriterion("REPAY_METHOD >", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("REPAY_METHOD >=", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodLessThan(String value) {
            addCriterion("REPAY_METHOD <", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodLessThanOrEqualTo(String value) {
            addCriterion("REPAY_METHOD <=", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodLike(String value) {
            addCriterion("REPAY_METHOD like", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodNotLike(String value) {
            addCriterion("REPAY_METHOD not like", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodIn(List<String> values) {
            addCriterion("REPAY_METHOD in", values, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodNotIn(List<String> values) {
            addCriterion("REPAY_METHOD not in", values, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodBetween(String value1, String value2) {
            addCriterion("REPAY_METHOD between", value1, value2, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodNotBetween(String value1, String value2) {
            addCriterion("REPAY_METHOD not between", value1, value2, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andGraceDaysIsNull() {
            addCriterion("GRACE_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andGraceDaysIsNotNull() {
            addCriterion("GRACE_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andGraceDaysEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS =", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysNotEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS <>", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysGreaterThan(BigDecimal value) {
            addCriterion("GRACE_DAYS >", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS >=", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysLessThan(BigDecimal value) {
            addCriterion("GRACE_DAYS <", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GRACE_DAYS <=", value, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysIn(List<BigDecimal> values) {
            addCriterion("GRACE_DAYS in", values, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysNotIn(List<BigDecimal> values) {
            addCriterion("GRACE_DAYS not in", values, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GRACE_DAYS between", value1, value2, "graceDays");
            return (Criteria) this;
        }

        public Criteria andGraceDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GRACE_DAYS not between", value1, value2, "graceDays");
            return (Criteria) this;
        }

        public Criteria andRateTypeIsNull() {
            addCriterion("RATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRateTypeIsNotNull() {
            addCriterion("RATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRateTypeEqualTo(String value) {
            addCriterion("RATE_TYPE =", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotEqualTo(String value) {
            addCriterion("RATE_TYPE <>", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeGreaterThan(String value) {
            addCriterion("RATE_TYPE >", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RATE_TYPE >=", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeLessThan(String value) {
            addCriterion("RATE_TYPE <", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeLessThanOrEqualTo(String value) {
            addCriterion("RATE_TYPE <=", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeLike(String value) {
            addCriterion("RATE_TYPE like", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotLike(String value) {
            addCriterion("RATE_TYPE not like", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeIn(List<String> values) {
            addCriterion("RATE_TYPE in", values, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotIn(List<String> values) {
            addCriterion("RATE_TYPE not in", values, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeBetween(String value1, String value2) {
            addCriterion("RATE_TYPE between", value1, value2, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateTypeNotBetween(String value1, String value2) {
            addCriterion("RATE_TYPE not between", value1, value2, "rateType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeIsNull() {
            addCriterion("RATE_FLOAT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeIsNotNull() {
            addCriterion("RATE_FLOAT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeEqualTo(String value) {
            addCriterion("RATE_FLOAT_TYPE =", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeNotEqualTo(String value) {
            addCriterion("RATE_FLOAT_TYPE <>", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeGreaterThan(String value) {
            addCriterion("RATE_FLOAT_TYPE >", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RATE_FLOAT_TYPE >=", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeLessThan(String value) {
            addCriterion("RATE_FLOAT_TYPE <", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeLessThanOrEqualTo(String value) {
            addCriterion("RATE_FLOAT_TYPE <=", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeLike(String value) {
            addCriterion("RATE_FLOAT_TYPE like", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeNotLike(String value) {
            addCriterion("RATE_FLOAT_TYPE not like", value, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeIn(List<String> values) {
            addCriterion("RATE_FLOAT_TYPE in", values, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeNotIn(List<String> values) {
            addCriterion("RATE_FLOAT_TYPE not in", values, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeBetween(String value1, String value2) {
            addCriterion("RATE_FLOAT_TYPE between", value1, value2, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatTypeNotBetween(String value1, String value2) {
            addCriterion("RATE_FLOAT_TYPE not between", value1, value2, "rateFloatType");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueIsNull() {
            addCriterion("RATE_FLOAT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueIsNotNull() {
            addCriterion("RATE_FLOAT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueEqualTo(BigDecimal value) {
            addCriterion("RATE_FLOAT_VALUE =", value, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueNotEqualTo(BigDecimal value) {
            addCriterion("RATE_FLOAT_VALUE <>", value, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueGreaterThan(BigDecimal value) {
            addCriterion("RATE_FLOAT_VALUE >", value, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_FLOAT_VALUE >=", value, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueLessThan(BigDecimal value) {
            addCriterion("RATE_FLOAT_VALUE <", value, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_FLOAT_VALUE <=", value, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueIn(List<BigDecimal> values) {
            addCriterion("RATE_FLOAT_VALUE in", values, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueNotIn(List<BigDecimal> values) {
            addCriterion("RATE_FLOAT_VALUE not in", values, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_FLOAT_VALUE between", value1, value2, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andRateFloatValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_FLOAT_VALUE not between", value1, value2, "rateFloatValue");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateIsNull() {
            addCriterion("BASE_YEAR_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateIsNotNull() {
            addCriterion("BASE_YEAR_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateEqualTo(BigDecimal value) {
            addCriterion("BASE_YEAR_RATE =", value, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateNotEqualTo(BigDecimal value) {
            addCriterion("BASE_YEAR_RATE <>", value, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateGreaterThan(BigDecimal value) {
            addCriterion("BASE_YEAR_RATE >", value, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_YEAR_RATE >=", value, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateLessThan(BigDecimal value) {
            addCriterion("BASE_YEAR_RATE <", value, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_YEAR_RATE <=", value, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateIn(List<BigDecimal> values) {
            addCriterion("BASE_YEAR_RATE in", values, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateNotIn(List<BigDecimal> values) {
            addCriterion("BASE_YEAR_RATE not in", values, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_YEAR_RATE between", value1, value2, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andBaseYearRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_YEAR_RATE not between", value1, value2, "baseYearRate");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeIsNull() {
            addCriterion("RATE_ADJUST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeIsNotNull() {
            addCriterion("RATE_ADJUST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeEqualTo(String value) {
            addCriterion("RATE_ADJUST_TYPE =", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeNotEqualTo(String value) {
            addCriterion("RATE_ADJUST_TYPE <>", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeGreaterThan(String value) {
            addCriterion("RATE_ADJUST_TYPE >", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RATE_ADJUST_TYPE >=", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeLessThan(String value) {
            addCriterion("RATE_ADJUST_TYPE <", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeLessThanOrEqualTo(String value) {
            addCriterion("RATE_ADJUST_TYPE <=", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeLike(String value) {
            addCriterion("RATE_ADJUST_TYPE like", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeNotLike(String value) {
            addCriterion("RATE_ADJUST_TYPE not like", value, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeIn(List<String> values) {
            addCriterion("RATE_ADJUST_TYPE in", values, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeNotIn(List<String> values) {
            addCriterion("RATE_ADJUST_TYPE not in", values, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeBetween(String value1, String value2) {
            addCriterion("RATE_ADJUST_TYPE between", value1, value2, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateAdjustTypeNotBetween(String value1, String value2) {
            addCriterion("RATE_ADJUST_TYPE not between", value1, value2, "rateAdjustType");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("RATE is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("RATE =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("RATE <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("RATE >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("RATE <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("RATE in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("RATE not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andLoanUseIsNull() {
            addCriterion("LOAN_USE is null");
            return (Criteria) this;
        }

        public Criteria andLoanUseIsNotNull() {
            addCriterion("LOAN_USE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanUseEqualTo(String value) {
            addCriterion("LOAN_USE =", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseNotEqualTo(String value) {
            addCriterion("LOAN_USE <>", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseGreaterThan(String value) {
            addCriterion("LOAN_USE >", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_USE >=", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseLessThan(String value) {
            addCriterion("LOAN_USE <", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseLessThanOrEqualTo(String value) {
            addCriterion("LOAN_USE <=", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseLike(String value) {
            addCriterion("LOAN_USE like", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseNotLike(String value) {
            addCriterion("LOAN_USE not like", value, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseIn(List<String> values) {
            addCriterion("LOAN_USE in", values, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseNotIn(List<String> values) {
            addCriterion("LOAN_USE not in", values, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseBetween(String value1, String value2) {
            addCriterion("LOAN_USE between", value1, value2, "loanUse");
            return (Criteria) this;
        }

        public Criteria andLoanUseNotBetween(String value1, String value2) {
            addCriterion("LOAN_USE not between", value1, value2, "loanUse");
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
            addCriterion("INSERT_DATE =", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotEqualTo(Date value) {
            addCriterion("INSERT_DATE <>", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThan(Date value) {
            addCriterion("INSERT_DATE >", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThanOrEqualTo(Date value) {
            addCriterion("INSERT_DATE >=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThan(Date value) {
            addCriterion("INSERT_DATE <", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThanOrEqualTo(Date value) {
            addCriterion("INSERT_DATE <=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateIn(List<Date> values) {
            addCriterion("INSERT_DATE in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotIn(List<Date> values) {
            addCriterion("INSERT_DATE not in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateBetween(Date value1, Date value2) {
            addCriterion("INSERT_DATE between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotBetween(Date value1, Date value2) {
            addCriterion("INSERT_DATE not between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeIsNull() {
            addCriterion("DRAFT_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeIsNotNull() {
            addCriterion("DRAFT_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeEqualTo(String value) {
            addCriterion("DRAFT_BRCODE =", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeNotEqualTo(String value) {
            addCriterion("DRAFT_BRCODE <>", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeGreaterThan(String value) {
            addCriterion("DRAFT_BRCODE >", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("DRAFT_BRCODE >=", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeLessThan(String value) {
            addCriterion("DRAFT_BRCODE <", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeLessThanOrEqualTo(String value) {
            addCriterion("DRAFT_BRCODE <=", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeLike(String value) {
            addCriterion("DRAFT_BRCODE like", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeNotLike(String value) {
            addCriterion("DRAFT_BRCODE not like", value, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeIn(List<String> values) {
            addCriterion("DRAFT_BRCODE in", values, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeNotIn(List<String> values) {
            addCriterion("DRAFT_BRCODE not in", values, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeBetween(String value1, String value2) {
            addCriterion("DRAFT_BRCODE between", value1, value2, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andDraftBrcodeNotBetween(String value1, String value2) {
            addCriterion("DRAFT_BRCODE not between", value1, value2, "draftBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeIsNull() {
            addCriterion("SIGN_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeIsNotNull() {
            addCriterion("SIGN_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeEqualTo(String value) {
            addCriterion("SIGN_BRCODE =", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeNotEqualTo(String value) {
            addCriterion("SIGN_BRCODE <>", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeGreaterThan(String value) {
            addCriterion("SIGN_BRCODE >", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_BRCODE >=", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeLessThan(String value) {
            addCriterion("SIGN_BRCODE <", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeLessThanOrEqualTo(String value) {
            addCriterion("SIGN_BRCODE <=", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeLike(String value) {
            addCriterion("SIGN_BRCODE like", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeNotLike(String value) {
            addCriterion("SIGN_BRCODE not like", value, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeIn(List<String> values) {
            addCriterion("SIGN_BRCODE in", values, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeNotIn(List<String> values) {
            addCriterion("SIGN_BRCODE not in", values, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeBetween(String value1, String value2) {
            addCriterion("SIGN_BRCODE between", value1, value2, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andSignBrcodeNotBetween(String value1, String value2) {
            addCriterion("SIGN_BRCODE not between", value1, value2, "signBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeIsNull() {
            addCriterion("PRE_PAY_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeIsNotNull() {
            addCriterion("PRE_PAY_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeEqualTo(String value) {
            addCriterion("PRE_PAY_BRCODE =", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeNotEqualTo(String value) {
            addCriterion("PRE_PAY_BRCODE <>", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeGreaterThan(String value) {
            addCriterion("PRE_PAY_BRCODE >", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_PAY_BRCODE >=", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeLessThan(String value) {
            addCriterion("PRE_PAY_BRCODE <", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeLessThanOrEqualTo(String value) {
            addCriterion("PRE_PAY_BRCODE <=", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeLike(String value) {
            addCriterion("PRE_PAY_BRCODE like", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeNotLike(String value) {
            addCriterion("PRE_PAY_BRCODE not like", value, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeIn(List<String> values) {
            addCriterion("PRE_PAY_BRCODE in", values, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeNotIn(List<String> values) {
            addCriterion("PRE_PAY_BRCODE not in", values, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeBetween(String value1, String value2) {
            addCriterion("PRE_PAY_BRCODE between", value1, value2, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andPrePayBrcodeNotBetween(String value1, String value2) {
            addCriterion("PRE_PAY_BRCODE not between", value1, value2, "prePayBrcode");
            return (Criteria) this;
        }

        public Criteria andEbFlagIsNull() {
            addCriterion("EB_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEbFlagIsNotNull() {
            addCriterion("EB_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEbFlagEqualTo(String value) {
            addCriterion("EB_FLAG =", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagNotEqualTo(String value) {
            addCriterion("EB_FLAG <>", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagGreaterThan(String value) {
            addCriterion("EB_FLAG >", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagGreaterThanOrEqualTo(String value) {
            addCriterion("EB_FLAG >=", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagLessThan(String value) {
            addCriterion("EB_FLAG <", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagLessThanOrEqualTo(String value) {
            addCriterion("EB_FLAG <=", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagLike(String value) {
            addCriterion("EB_FLAG like", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagNotLike(String value) {
            addCriterion("EB_FLAG not like", value, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagIn(List<String> values) {
            addCriterion("EB_FLAG in", values, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagNotIn(List<String> values) {
            addCriterion("EB_FLAG not in", values, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagBetween(String value1, String value2) {
            addCriterion("EB_FLAG between", value1, value2, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andEbFlagNotBetween(String value1, String value2) {
            addCriterion("EB_FLAG not between", value1, value2, "ebFlag");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditIsNull() {
            addCriterion("HAS_INDIRECT_CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditIsNotNull() {
            addCriterion("HAS_INDIRECT_CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditEqualTo(String value) {
            addCriterion("HAS_INDIRECT_CREDIT =", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditNotEqualTo(String value) {
            addCriterion("HAS_INDIRECT_CREDIT <>", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditGreaterThan(String value) {
            addCriterion("HAS_INDIRECT_CREDIT >", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditGreaterThanOrEqualTo(String value) {
            addCriterion("HAS_INDIRECT_CREDIT >=", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditLessThan(String value) {
            addCriterion("HAS_INDIRECT_CREDIT <", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditLessThanOrEqualTo(String value) {
            addCriterion("HAS_INDIRECT_CREDIT <=", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditLike(String value) {
            addCriterion("HAS_INDIRECT_CREDIT like", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditNotLike(String value) {
            addCriterion("HAS_INDIRECT_CREDIT not like", value, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditIn(List<String> values) {
            addCriterion("HAS_INDIRECT_CREDIT in", values, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditNotIn(List<String> values) {
            addCriterion("HAS_INDIRECT_CREDIT not in", values, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditBetween(String value1, String value2) {
            addCriterion("HAS_INDIRECT_CREDIT between", value1, value2, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andHasIndirectCreditNotBetween(String value1, String value2) {
            addCriterion("HAS_INDIRECT_CREDIT not between", value1, value2, "hasIndirectCredit");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdIsNull() {
            addCriterion("CREDIT_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdIsNotNull() {
            addCriterion("CREDIT_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdEqualTo(String value) {
            addCriterion("CREDIT_CUSTCD =", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdNotEqualTo(String value) {
            addCriterion("CREDIT_CUSTCD <>", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdGreaterThan(String value) {
            addCriterion("CREDIT_CUSTCD >", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_CUSTCD >=", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdLessThan(String value) {
            addCriterion("CREDIT_CUSTCD <", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_CUSTCD <=", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdLike(String value) {
            addCriterion("CREDIT_CUSTCD like", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdNotLike(String value) {
            addCriterion("CREDIT_CUSTCD not like", value, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdIn(List<String> values) {
            addCriterion("CREDIT_CUSTCD in", values, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdNotIn(List<String> values) {
            addCriterion("CREDIT_CUSTCD not in", values, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdBetween(String value1, String value2) {
            addCriterion("CREDIT_CUSTCD between", value1, value2, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andCreditCustcdNotBetween(String value1, String value2) {
            addCriterion("CREDIT_CUSTCD not between", value1, value2, "creditCustcd");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdIsNull() {
            addCriterion("ORG_DEBET_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdIsNotNull() {
            addCriterion("ORG_DEBET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdEqualTo(String value) {
            addCriterion("ORG_DEBET_ID =", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdNotEqualTo(String value) {
            addCriterion("ORG_DEBET_ID <>", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdGreaterThan(String value) {
            addCriterion("ORG_DEBET_ID >", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_DEBET_ID >=", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdLessThan(String value) {
            addCriterion("ORG_DEBET_ID <", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_DEBET_ID <=", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdLike(String value) {
            addCriterion("ORG_DEBET_ID like", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdNotLike(String value) {
            addCriterion("ORG_DEBET_ID not like", value, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdIn(List<String> values) {
            addCriterion("ORG_DEBET_ID in", values, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdNotIn(List<String> values) {
            addCriterion("ORG_DEBET_ID not in", values, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdBetween(String value1, String value2) {
            addCriterion("ORG_DEBET_ID between", value1, value2, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andOrgDebetIdNotBetween(String value1, String value2) {
            addCriterion("ORG_DEBET_ID not between", value1, value2, "orgDebetId");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoIsNull() {
            addCriterion("LOAN_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoIsNotNull() {
            addCriterion("LOAN_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoEqualTo(String value) {
            addCriterion("LOAN_APPNO =", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotEqualTo(String value) {
            addCriterion("LOAN_APPNO <>", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoGreaterThan(String value) {
            addCriterion("LOAN_APPNO >", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_APPNO >=", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoLessThan(String value) {
            addCriterion("LOAN_APPNO <", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoLessThanOrEqualTo(String value) {
            addCriterion("LOAN_APPNO <=", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoLike(String value) {
            addCriterion("LOAN_APPNO like", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotLike(String value) {
            addCriterion("LOAN_APPNO not like", value, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoIn(List<String> values) {
            addCriterion("LOAN_APPNO in", values, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotIn(List<String> values) {
            addCriterion("LOAN_APPNO not in", values, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoBetween(String value1, String value2) {
            addCriterion("LOAN_APPNO between", value1, value2, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andLoanAppnoNotBetween(String value1, String value2) {
            addCriterion("LOAN_APPNO not between", value1, value2, "loanAppno");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("PRODUCT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("PRODUCT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("PRODUCT_CODE =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("PRODUCT_CODE <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("PRODUCT_CODE >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("PRODUCT_CODE <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("PRODUCT_CODE like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("PRODUCT_CODE not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("PRODUCT_CODE in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("PRODUCT_CODE not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeIsNull() {
            addCriterion("PAY_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeIsNotNull() {
            addCriterion("PAY_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeEqualTo(String value) {
            addCriterion("PAY_BRCODE =", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeNotEqualTo(String value) {
            addCriterion("PAY_BRCODE <>", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeGreaterThan(String value) {
            addCriterion("PAY_BRCODE >", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_BRCODE >=", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeLessThan(String value) {
            addCriterion("PAY_BRCODE <", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeLessThanOrEqualTo(String value) {
            addCriterion("PAY_BRCODE <=", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeLike(String value) {
            addCriterion("PAY_BRCODE like", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeNotLike(String value) {
            addCriterion("PAY_BRCODE not like", value, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeIn(List<String> values) {
            addCriterion("PAY_BRCODE in", values, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeNotIn(List<String> values) {
            addCriterion("PAY_BRCODE not in", values, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeBetween(String value1, String value2) {
            addCriterion("PAY_BRCODE between", value1, value2, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayBrcodeNotBetween(String value1, String value2) {
            addCriterion("PAY_BRCODE not between", value1, value2, "payBrcode");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoIsNull() {
            addCriterion("PAY_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoIsNotNull() {
            addCriterion("PAY_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoEqualTo(String value) {
            addCriterion("PAY_TLRNO =", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoNotEqualTo(String value) {
            addCriterion("PAY_TLRNO <>", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoGreaterThan(String value) {
            addCriterion("PAY_TLRNO >", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TLRNO >=", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoLessThan(String value) {
            addCriterion("PAY_TLRNO <", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoLessThanOrEqualTo(String value) {
            addCriterion("PAY_TLRNO <=", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoLike(String value) {
            addCriterion("PAY_TLRNO like", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoNotLike(String value) {
            addCriterion("PAY_TLRNO not like", value, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoIn(List<String> values) {
            addCriterion("PAY_TLRNO in", values, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoNotIn(List<String> values) {
            addCriterion("PAY_TLRNO not in", values, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoBetween(String value1, String value2) {
            addCriterion("PAY_TLRNO between", value1, value2, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayTlrnoNotBetween(String value1, String value2) {
            addCriterion("PAY_TLRNO not between", value1, value2, "payTlrno");
            return (Criteria) this;
        }

        public Criteria andPayCheckerIsNull() {
            addCriterion("PAY_CHECKER is null");
            return (Criteria) this;
        }

        public Criteria andPayCheckerIsNotNull() {
            addCriterion("PAY_CHECKER is not null");
            return (Criteria) this;
        }

        public Criteria andPayCheckerEqualTo(String value) {
            addCriterion("PAY_CHECKER =", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerNotEqualTo(String value) {
            addCriterion("PAY_CHECKER <>", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerGreaterThan(String value) {
            addCriterion("PAY_CHECKER >", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_CHECKER >=", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerLessThan(String value) {
            addCriterion("PAY_CHECKER <", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerLessThanOrEqualTo(String value) {
            addCriterion("PAY_CHECKER <=", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerLike(String value) {
            addCriterion("PAY_CHECKER like", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerNotLike(String value) {
            addCriterion("PAY_CHECKER not like", value, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerIn(List<String> values) {
            addCriterion("PAY_CHECKER in", values, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerNotIn(List<String> values) {
            addCriterion("PAY_CHECKER not in", values, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerBetween(String value1, String value2) {
            addCriterion("PAY_CHECKER between", value1, value2, "payChecker");
            return (Criteria) this;
        }

        public Criteria andPayCheckerNotBetween(String value1, String value2) {
            addCriterion("PAY_CHECKER not between", value1, value2, "payChecker");
            return (Criteria) this;
        }

        public Criteria andIsSettleIsNull() {
            addCriterion("IS_SETTLE is null");
            return (Criteria) this;
        }

        public Criteria andIsSettleIsNotNull() {
            addCriterion("IS_SETTLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsSettleEqualTo(String value) {
            addCriterion("IS_SETTLE =", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleNotEqualTo(String value) {
            addCriterion("IS_SETTLE <>", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleGreaterThan(String value) {
            addCriterion("IS_SETTLE >", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SETTLE >=", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleLessThan(String value) {
            addCriterion("IS_SETTLE <", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleLessThanOrEqualTo(String value) {
            addCriterion("IS_SETTLE <=", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleLike(String value) {
            addCriterion("IS_SETTLE like", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleNotLike(String value) {
            addCriterion("IS_SETTLE not like", value, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleIn(List<String> values) {
            addCriterion("IS_SETTLE in", values, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleNotIn(List<String> values) {
            addCriterion("IS_SETTLE not in", values, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleBetween(String value1, String value2) {
            addCriterion("IS_SETTLE between", value1, value2, "isSettle");
            return (Criteria) this;
        }

        public Criteria andIsSettleNotBetween(String value1, String value2) {
            addCriterion("IS_SETTLE not between", value1, value2, "isSettle");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtIsNull() {
            addCriterion("ACCU_SEND_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtIsNotNull() {
            addCriterion("ACCU_SEND_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtEqualTo(BigDecimal value) {
            addCriterion("ACCU_SEND_AMT =", value, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtNotEqualTo(BigDecimal value) {
            addCriterion("ACCU_SEND_AMT <>", value, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtGreaterThan(BigDecimal value) {
            addCriterion("ACCU_SEND_AMT >", value, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCU_SEND_AMT >=", value, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtLessThan(BigDecimal value) {
            addCriterion("ACCU_SEND_AMT <", value, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCU_SEND_AMT <=", value, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtIn(List<BigDecimal> values) {
            addCriterion("ACCU_SEND_AMT in", values, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtNotIn(List<BigDecimal> values) {
            addCriterion("ACCU_SEND_AMT not in", values, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCU_SEND_AMT between", value1, value2, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andAccuSendAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCU_SEND_AMT not between", value1, value2, "accuSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtIsNull() {
            addCriterion("BAL_SEND_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtIsNotNull() {
            addCriterion("BAL_SEND_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtEqualTo(BigDecimal value) {
            addCriterion("BAL_SEND_AMT =", value, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtNotEqualTo(BigDecimal value) {
            addCriterion("BAL_SEND_AMT <>", value, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtGreaterThan(BigDecimal value) {
            addCriterion("BAL_SEND_AMT >", value, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_SEND_AMT >=", value, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtLessThan(BigDecimal value) {
            addCriterion("BAL_SEND_AMT <", value, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_SEND_AMT <=", value, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtIn(List<BigDecimal> values) {
            addCriterion("BAL_SEND_AMT in", values, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtNotIn(List<BigDecimal> values) {
            addCriterion("BAL_SEND_AMT not in", values, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_SEND_AMT between", value1, value2, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andBalSendAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_SEND_AMT not between", value1, value2, "balSendAmt");
            return (Criteria) this;
        }

        public Criteria andHasSendBpIsNull() {
            addCriterion("HAS_SEND_BP is null");
            return (Criteria) this;
        }

        public Criteria andHasSendBpIsNotNull() {
            addCriterion("HAS_SEND_BP is not null");
            return (Criteria) this;
        }

        public Criteria andHasSendBpEqualTo(String value) {
            addCriterion("HAS_SEND_BP =", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpNotEqualTo(String value) {
            addCriterion("HAS_SEND_BP <>", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpGreaterThan(String value) {
            addCriterion("HAS_SEND_BP >", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpGreaterThanOrEqualTo(String value) {
            addCriterion("HAS_SEND_BP >=", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpLessThan(String value) {
            addCriterion("HAS_SEND_BP <", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpLessThanOrEqualTo(String value) {
            addCriterion("HAS_SEND_BP <=", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpLike(String value) {
            addCriterion("HAS_SEND_BP like", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpNotLike(String value) {
            addCriterion("HAS_SEND_BP not like", value, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpIn(List<String> values) {
            addCriterion("HAS_SEND_BP in", values, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpNotIn(List<String> values) {
            addCriterion("HAS_SEND_BP not in", values, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpBetween(String value1, String value2) {
            addCriterion("HAS_SEND_BP between", value1, value2, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andHasSendBpNotBetween(String value1, String value2) {
            addCriterion("HAS_SEND_BP not between", value1, value2, "hasSendBp");
            return (Criteria) this;
        }

        public Criteria andCoreStateIsNull() {
            addCriterion("CORE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andCoreStateIsNotNull() {
            addCriterion("CORE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andCoreStateEqualTo(String value) {
            addCriterion("CORE_STATE =", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateNotEqualTo(String value) {
            addCriterion("CORE_STATE <>", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateGreaterThan(String value) {
            addCriterion("CORE_STATE >", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_STATE >=", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateLessThan(String value) {
            addCriterion("CORE_STATE <", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateLessThanOrEqualTo(String value) {
            addCriterion("CORE_STATE <=", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateLike(String value) {
            addCriterion("CORE_STATE like", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateNotLike(String value) {
            addCriterion("CORE_STATE not like", value, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateIn(List<String> values) {
            addCriterion("CORE_STATE in", values, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateNotIn(List<String> values) {
            addCriterion("CORE_STATE not in", values, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateBetween(String value1, String value2) {
            addCriterion("CORE_STATE between", value1, value2, "coreState");
            return (Criteria) this;
        }

        public Criteria andCoreStateNotBetween(String value1, String value2) {
            addCriterion("CORE_STATE not between", value1, value2, "coreState");
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

        public Criteria andSaleBrcodeIsNull() {
            addCriterion("SALE_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeIsNotNull() {
            addCriterion("SALE_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeEqualTo(String value) {
            addCriterion("SALE_BRCODE =", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeNotEqualTo(String value) {
            addCriterion("SALE_BRCODE <>", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeGreaterThan(String value) {
            addCriterion("SALE_BRCODE >", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_BRCODE >=", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeLessThan(String value) {
            addCriterion("SALE_BRCODE <", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeLessThanOrEqualTo(String value) {
            addCriterion("SALE_BRCODE <=", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeLike(String value) {
            addCriterion("SALE_BRCODE like", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeNotLike(String value) {
            addCriterion("SALE_BRCODE not like", value, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeIn(List<String> values) {
            addCriterion("SALE_BRCODE in", values, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeNotIn(List<String> values) {
            addCriterion("SALE_BRCODE not in", values, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeBetween(String value1, String value2) {
            addCriterion("SALE_BRCODE between", value1, value2, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andSaleBrcodeNotBetween(String value1, String value2) {
            addCriterion("SALE_BRCODE not between", value1, value2, "saleBrcode");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtIsNull() {
            addCriterion("OWN_FUND_PAY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtIsNotNull() {
            addCriterion("OWN_FUND_PAY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtEqualTo(BigDecimal value) {
            addCriterion("OWN_FUND_PAY_AMT =", value, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtNotEqualTo(BigDecimal value) {
            addCriterion("OWN_FUND_PAY_AMT <>", value, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtGreaterThan(BigDecimal value) {
            addCriterion("OWN_FUND_PAY_AMT >", value, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OWN_FUND_PAY_AMT >=", value, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtLessThan(BigDecimal value) {
            addCriterion("OWN_FUND_PAY_AMT <", value, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OWN_FUND_PAY_AMT <=", value, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtIn(List<BigDecimal> values) {
            addCriterion("OWN_FUND_PAY_AMT in", values, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtNotIn(List<BigDecimal> values) {
            addCriterion("OWN_FUND_PAY_AMT not in", values, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OWN_FUND_PAY_AMT between", value1, value2, "ownFundPayAmt");
            return (Criteria) this;
        }

        public Criteria andOwnFundPayAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OWN_FUND_PAY_AMT not between", value1, value2, "ownFundPayAmt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}