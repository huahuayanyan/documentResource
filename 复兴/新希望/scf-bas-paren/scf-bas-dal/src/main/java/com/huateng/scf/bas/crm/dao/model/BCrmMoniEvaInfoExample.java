package com.huateng.scf.bas.crm.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrmMoniEvaInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrmMoniEvaInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrmMoniEvaInfoExample(BCrmMoniEvaInfoExample example) {
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

        public Criteria andLevelsIsNull() {
            addCriterion("LEVELS is null");
            return (Criteria) this;
        }

        public Criteria andLevelsIsNotNull() {
            addCriterion("LEVELS is not null");
            return (Criteria) this;
        }

        public Criteria andLevelsEqualTo(String value) {
            addCriterion("LEVELS =", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotEqualTo(String value) {
            addCriterion("LEVELS <>", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThan(String value) {
            addCriterion("LEVELS >", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThanOrEqualTo(String value) {
            addCriterion("LEVELS >=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThan(String value) {
            addCriterion("LEVELS <", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThanOrEqualTo(String value) {
            addCriterion("LEVELS <=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLike(String value) {
            addCriterion("LEVELS like", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotLike(String value) {
            addCriterion("LEVELS not like", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsIn(List<String> values) {
            addCriterion("LEVELS in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotIn(List<String> values) {
            addCriterion("LEVELS not in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsBetween(String value1, String value2) {
            addCriterion("LEVELS between", value1, value2, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotBetween(String value1, String value2) {
            addCriterion("LEVELS not between", value1, value2, "levels");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaIsNull() {
            addCriterion("MONITOR_AREA is null");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaIsNotNull() {
            addCriterion("MONITOR_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaEqualTo(String value) {
            addCriterion("MONITOR_AREA =", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaNotEqualTo(String value) {
            addCriterion("MONITOR_AREA <>", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaGreaterThan(String value) {
            addCriterion("MONITOR_AREA >", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaGreaterThanOrEqualTo(String value) {
            addCriterion("MONITOR_AREA >=", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaLessThan(String value) {
            addCriterion("MONITOR_AREA <", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaLessThanOrEqualTo(String value) {
            addCriterion("MONITOR_AREA <=", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaLike(String value) {
            addCriterion("MONITOR_AREA like", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaNotLike(String value) {
            addCriterion("MONITOR_AREA not like", value, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaIn(List<String> values) {
            addCriterion("MONITOR_AREA in", values, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaNotIn(List<String> values) {
            addCriterion("MONITOR_AREA not in", values, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaBetween(String value1, String value2) {
            addCriterion("MONITOR_AREA between", value1, value2, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitorAreaNotBetween(String value1, String value2) {
            addCriterion("MONITOR_AREA not between", value1, value2, "monitorArea");
            return (Criteria) this;
        }

        public Criteria andMonitortypeIsNull() {
            addCriterion("MONITORTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMonitortypeIsNotNull() {
            addCriterion("MONITORTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMonitortypeEqualTo(String value) {
            addCriterion("MONITORTYPE =", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeNotEqualTo(String value) {
            addCriterion("MONITORTYPE <>", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeGreaterThan(String value) {
            addCriterion("MONITORTYPE >", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeGreaterThanOrEqualTo(String value) {
            addCriterion("MONITORTYPE >=", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeLessThan(String value) {
            addCriterion("MONITORTYPE <", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeLessThanOrEqualTo(String value) {
            addCriterion("MONITORTYPE <=", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeLike(String value) {
            addCriterion("MONITORTYPE like", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeNotLike(String value) {
            addCriterion("MONITORTYPE not like", value, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeIn(List<String> values) {
            addCriterion("MONITORTYPE in", values, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeNotIn(List<String> values) {
            addCriterion("MONITORTYPE not in", values, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeBetween(String value1, String value2) {
            addCriterion("MONITORTYPE between", value1, value2, "monitortype");
            return (Criteria) this;
        }

        public Criteria andMonitortypeNotBetween(String value1, String value2) {
            addCriterion("MONITORTYPE not between", value1, value2, "monitortype");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaIsNull() {
            addCriterion("DETAIL_MONITOR_AREA is null");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaIsNotNull() {
            addCriterion("DETAIL_MONITOR_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaEqualTo(String value) {
            addCriterion("DETAIL_MONITOR_AREA =", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaNotEqualTo(String value) {
            addCriterion("DETAIL_MONITOR_AREA <>", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaGreaterThan(String value) {
            addCriterion("DETAIL_MONITOR_AREA >", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_MONITOR_AREA >=", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaLessThan(String value) {
            addCriterion("DETAIL_MONITOR_AREA <", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_MONITOR_AREA <=", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaLike(String value) {
            addCriterion("DETAIL_MONITOR_AREA like", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaNotLike(String value) {
            addCriterion("DETAIL_MONITOR_AREA not like", value, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaIn(List<String> values) {
            addCriterion("DETAIL_MONITOR_AREA in", values, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaNotIn(List<String> values) {
            addCriterion("DETAIL_MONITOR_AREA not in", values, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaBetween(String value1, String value2) {
            addCriterion("DETAIL_MONITOR_AREA between", value1, value2, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andDetailMonitorAreaNotBetween(String value1, String value2) {
            addCriterion("DETAIL_MONITOR_AREA not between", value1, value2, "detailMonitorArea");
            return (Criteria) this;
        }

        public Criteria andLimitSumIsNull() {
            addCriterion("LIMIT_SUM is null");
            return (Criteria) this;
        }

        public Criteria andLimitSumIsNotNull() {
            addCriterion("LIMIT_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andLimitSumEqualTo(BigDecimal value) {
            addCriterion("LIMIT_SUM =", value, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumNotEqualTo(BigDecimal value) {
            addCriterion("LIMIT_SUM <>", value, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumGreaterThan(BigDecimal value) {
            addCriterion("LIMIT_SUM >", value, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_SUM >=", value, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumLessThan(BigDecimal value) {
            addCriterion("LIMIT_SUM <", value, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_SUM <=", value, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumIn(List<BigDecimal> values) {
            addCriterion("LIMIT_SUM in", values, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumNotIn(List<BigDecimal> values) {
            addCriterion("LIMIT_SUM not in", values, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_SUM between", value1, value2, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLimitSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_SUM not between", value1, value2, "limitSum");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateIsNull() {
            addCriterion("LEVEL_COGNI_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateIsNotNull() {
            addCriterion("LEVEL_COGNI_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateEqualTo(String value) {
            addCriterion("LEVEL_COGNI_DATE =", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateNotEqualTo(String value) {
            addCriterion("LEVEL_COGNI_DATE <>", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateGreaterThan(String value) {
            addCriterion("LEVEL_COGNI_DATE >", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateGreaterThanOrEqualTo(String value) {
            addCriterion("LEVEL_COGNI_DATE >=", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateLessThan(String value) {
            addCriterion("LEVEL_COGNI_DATE <", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateLessThanOrEqualTo(String value) {
            addCriterion("LEVEL_COGNI_DATE <=", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateLike(String value) {
            addCriterion("LEVEL_COGNI_DATE like", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateNotLike(String value) {
            addCriterion("LEVEL_COGNI_DATE not like", value, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateIn(List<String> values) {
            addCriterion("LEVEL_COGNI_DATE in", values, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateNotIn(List<String> values) {
            addCriterion("LEVEL_COGNI_DATE not in", values, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateBetween(String value1, String value2) {
            addCriterion("LEVEL_COGNI_DATE between", value1, value2, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelCogniDateNotBetween(String value1, String value2) {
            addCriterion("LEVEL_COGNI_DATE not between", value1, value2, "levelCogniDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateIsNull() {
            addCriterion("LEVEL_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateIsNotNull() {
            addCriterion("LEVEL_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateEqualTo(String value) {
            addCriterion("LEVEL_END_DATE =", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateNotEqualTo(String value) {
            addCriterion("LEVEL_END_DATE <>", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateGreaterThan(String value) {
            addCriterion("LEVEL_END_DATE >", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("LEVEL_END_DATE >=", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateLessThan(String value) {
            addCriterion("LEVEL_END_DATE <", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateLessThanOrEqualTo(String value) {
            addCriterion("LEVEL_END_DATE <=", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateLike(String value) {
            addCriterion("LEVEL_END_DATE like", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateNotLike(String value) {
            addCriterion("LEVEL_END_DATE not like", value, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateIn(List<String> values) {
            addCriterion("LEVEL_END_DATE in", values, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateNotIn(List<String> values) {
            addCriterion("LEVEL_END_DATE not in", values, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateBetween(String value1, String value2) {
            addCriterion("LEVEL_END_DATE between", value1, value2, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelEndDateNotBetween(String value1, String value2) {
            addCriterion("LEVEL_END_DATE not between", value1, value2, "levelEndDate");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusIsNull() {
            addCriterion("MONITOR_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusIsNotNull() {
            addCriterion("MONITOR_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusEqualTo(String value) {
            addCriterion("MONITOR_STATUS =", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusNotEqualTo(String value) {
            addCriterion("MONITOR_STATUS <>", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusGreaterThan(String value) {
            addCriterion("MONITOR_STATUS >", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MONITOR_STATUS >=", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusLessThan(String value) {
            addCriterion("MONITOR_STATUS <", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusLessThanOrEqualTo(String value) {
            addCriterion("MONITOR_STATUS <=", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusLike(String value) {
            addCriterion("MONITOR_STATUS like", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusNotLike(String value) {
            addCriterion("MONITOR_STATUS not like", value, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusIn(List<String> values) {
            addCriterion("MONITOR_STATUS in", values, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusNotIn(List<String> values) {
            addCriterion("MONITOR_STATUS not in", values, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusBetween(String value1, String value2) {
            addCriterion("MONITOR_STATUS between", value1, value2, "monitorStatus");
            return (Criteria) this;
        }

        public Criteria andMonitorStatusNotBetween(String value1, String value2) {
            addCriterion("MONITOR_STATUS not between", value1, value2, "monitorStatus");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
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