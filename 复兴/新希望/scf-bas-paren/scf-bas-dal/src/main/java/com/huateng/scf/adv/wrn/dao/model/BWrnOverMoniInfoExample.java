package com.huateng.scf.adv.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWrnOverMoniInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWrnOverMoniInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWrnOverMoniInfoExample(BWrnOverMoniInfoExample example) {
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

        public Criteria andMoniCustcdIsNull() {
            addCriterion("MONI_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdIsNotNull() {
            addCriterion("MONI_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdEqualTo(String value) {
            addCriterion("MONI_CUSTCD =", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotEqualTo(String value) {
            addCriterion("MONI_CUSTCD <>", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdGreaterThan(String value) {
            addCriterion("MONI_CUSTCD >", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_CUSTCD >=", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLessThan(String value) {
            addCriterion("MONI_CUSTCD <", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLessThanOrEqualTo(String value) {
            addCriterion("MONI_CUSTCD <=", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdLike(String value) {
            addCriterion("MONI_CUSTCD like", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotLike(String value) {
            addCriterion("MONI_CUSTCD not like", value, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdIn(List<String> values) {
            addCriterion("MONI_CUSTCD in", values, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotIn(List<String> values) {
            addCriterion("MONI_CUSTCD not in", values, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdBetween(String value1, String value2) {
            addCriterion("MONI_CUSTCD between", value1, value2, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCustcdNotBetween(String value1, String value2) {
            addCriterion("MONI_CUSTCD not between", value1, value2, "moniCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniCnameIsNull() {
            addCriterion("MONI_CNAME is null");
            return (Criteria) this;
        }

        public Criteria andMoniCnameIsNotNull() {
            addCriterion("MONI_CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMoniCnameEqualTo(String value) {
            addCriterion("MONI_CNAME =", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotEqualTo(String value) {
            addCriterion("MONI_CNAME <>", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameGreaterThan(String value) {
            addCriterion("MONI_CNAME >", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_CNAME >=", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameLessThan(String value) {
            addCriterion("MONI_CNAME <", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameLessThanOrEqualTo(String value) {
            addCriterion("MONI_CNAME <=", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameLike(String value) {
            addCriterion("MONI_CNAME like", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotLike(String value) {
            addCriterion("MONI_CNAME not like", value, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameIn(List<String> values) {
            addCriterion("MONI_CNAME in", values, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotIn(List<String> values) {
            addCriterion("MONI_CNAME not in", values, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameBetween(String value1, String value2) {
            addCriterion("MONI_CNAME between", value1, value2, "moniCname");
            return (Criteria) this;
        }

        public Criteria andMoniCnameNotBetween(String value1, String value2) {
            addCriterion("MONI_CNAME not between", value1, value2, "moniCname");
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

        public Criteria andMortAmtIsNull() {
            addCriterion("MORT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andMortAmtIsNotNull() {
            addCriterion("MORT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andMortAmtEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT =", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtNotEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT <>", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtGreaterThan(BigDecimal value) {
            addCriterion("MORT_AMT >", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT >=", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtLessThan(BigDecimal value) {
            addCriterion("MORT_AMT <", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MORT_AMT <=", value, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtIn(List<BigDecimal> values) {
            addCriterion("MORT_AMT in", values, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtNotIn(List<BigDecimal> values) {
            addCriterion("MORT_AMT not in", values, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_AMT between", value1, value2, "mortAmt");
            return (Criteria) this;
        }

        public Criteria andMortAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORT_AMT not between", value1, value2, "mortAmt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}