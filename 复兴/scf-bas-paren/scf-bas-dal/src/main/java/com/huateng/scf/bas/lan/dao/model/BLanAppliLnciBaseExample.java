package com.huateng.scf.bas.lan.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLanAppliLnciBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BLanAppliLnciBaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BLanAppliLnciBaseExample(BLanAppliLnciBaseExample example) {
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

        public Criteria andTotalBailAmountIsNull() {
            addCriterion("TOTAL_BAIL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountIsNotNull() {
            addCriterion("TOTAL_BAIL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BAIL_AMOUNT =", value, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BAIL_AMOUNT <>", value, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_BAIL_AMOUNT >", value, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BAIL_AMOUNT >=", value, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_BAIL_AMOUNT <", value, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BAIL_AMOUNT <=", value, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_BAIL_AMOUNT in", values, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_BAIL_AMOUNT not in", values, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_BAIL_AMOUNT between", value1, value2, "totalBailAmount");
            return (Criteria) this;
        }

        public Criteria andTotalBailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_BAIL_AMOUNT not between", value1, value2, "totalBailAmount");
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

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("NUM like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("NUM not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("NUM not between", value1, value2, "num");
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

        public Criteria andOtherCustcdIsNull() {
            addCriterion("OTHER_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdIsNotNull() {
            addCriterion("OTHER_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdEqualTo(String value) {
            addCriterion("OTHER_CUSTCD =", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotEqualTo(String value) {
            addCriterion("OTHER_CUSTCD <>", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdGreaterThan(String value) {
            addCriterion("OTHER_CUSTCD >", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_CUSTCD >=", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLessThan(String value) {
            addCriterion("OTHER_CUSTCD <", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLessThanOrEqualTo(String value) {
            addCriterion("OTHER_CUSTCD <=", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdLike(String value) {
            addCriterion("OTHER_CUSTCD like", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotLike(String value) {
            addCriterion("OTHER_CUSTCD not like", value, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdIn(List<String> values) {
            addCriterion("OTHER_CUSTCD in", values, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotIn(List<String> values) {
            addCriterion("OTHER_CUSTCD not in", values, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdBetween(String value1, String value2) {
            addCriterion("OTHER_CUSTCD between", value1, value2, "otherCustcd");
            return (Criteria) this;
        }

        public Criteria andOtherCustcdNotBetween(String value1, String value2) {
            addCriterion("OTHER_CUSTCD not between", value1, value2, "otherCustcd");
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

        public Criteria andDrawbackTermIsNull() {
            addCriterion("DRAWBACK_TERM is null");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermIsNotNull() {
            addCriterion("DRAWBACK_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermEqualTo(BigDecimal value) {
            addCriterion("DRAWBACK_TERM =", value, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermNotEqualTo(BigDecimal value) {
            addCriterion("DRAWBACK_TERM <>", value, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermGreaterThan(BigDecimal value) {
            addCriterion("DRAWBACK_TERM >", value, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DRAWBACK_TERM >=", value, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermLessThan(BigDecimal value) {
            addCriterion("DRAWBACK_TERM <", value, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DRAWBACK_TERM <=", value, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermIn(List<BigDecimal> values) {
            addCriterion("DRAWBACK_TERM in", values, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermNotIn(List<BigDecimal> values) {
            addCriterion("DRAWBACK_TERM not in", values, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DRAWBACK_TERM between", value1, value2, "drawbackTerm");
            return (Criteria) this;
        }

        public Criteria andDrawbackTermNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DRAWBACK_TERM not between", value1, value2, "drawbackTerm");
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