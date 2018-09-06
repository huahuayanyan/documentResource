package com.huateng.scf.bas.brp.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBrpWarnParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBrpWarnParamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BBrpWarnParamExample(BBrpWarnParamExample example) {
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

        public Criteria andWarnNoIsNull() {
            addCriterion("WARN_NO is null");
            return (Criteria) this;
        }

        public Criteria andWarnNoIsNotNull() {
            addCriterion("WARN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWarnNoEqualTo(String value) {
            addCriterion("WARN_NO =", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotEqualTo(String value) {
            addCriterion("WARN_NO <>", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoGreaterThan(String value) {
            addCriterion("WARN_NO >", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_NO >=", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLessThan(String value) {
            addCriterion("WARN_NO <", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLessThanOrEqualTo(String value) {
            addCriterion("WARN_NO <=", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLike(String value) {
            addCriterion("WARN_NO like", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotLike(String value) {
            addCriterion("WARN_NO not like", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoIn(List<String> values) {
            addCriterion("WARN_NO in", values, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotIn(List<String> values) {
            addCriterion("WARN_NO not in", values, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoBetween(String value1, String value2) {
            addCriterion("WARN_NO between", value1, value2, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotBetween(String value1, String value2) {
            addCriterion("WARN_NO not between", value1, value2, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNameIsNull() {
            addCriterion("WARN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWarnNameIsNotNull() {
            addCriterion("WARN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWarnNameEqualTo(String value) {
            addCriterion("WARN_NAME =", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameNotEqualTo(String value) {
            addCriterion("WARN_NAME <>", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameGreaterThan(String value) {
            addCriterion("WARN_NAME >", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_NAME >=", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameLessThan(String value) {
            addCriterion("WARN_NAME <", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameLessThanOrEqualTo(String value) {
            addCriterion("WARN_NAME <=", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameLike(String value) {
            addCriterion("WARN_NAME like", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameNotLike(String value) {
            addCriterion("WARN_NAME not like", value, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameIn(List<String> values) {
            addCriterion("WARN_NAME in", values, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameNotIn(List<String> values) {
            addCriterion("WARN_NAME not in", values, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameBetween(String value1, String value2) {
            addCriterion("WARN_NAME between", value1, value2, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnNameNotBetween(String value1, String value2) {
            addCriterion("WARN_NAME not between", value1, value2, "warnName");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNull() {
            addCriterion("WARN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNotNull() {
            addCriterion("WARN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeEqualTo(String value) {
            addCriterion("WARN_TYPE =", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotEqualTo(String value) {
            addCriterion("WARN_TYPE <>", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThan(String value) {
            addCriterion("WARN_TYPE >", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_TYPE >=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThan(String value) {
            addCriterion("WARN_TYPE <", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThanOrEqualTo(String value) {
            addCriterion("WARN_TYPE <=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLike(String value) {
            addCriterion("WARN_TYPE like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotLike(String value) {
            addCriterion("WARN_TYPE not like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIn(List<String> values) {
            addCriterion("WARN_TYPE in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotIn(List<String> values) {
            addCriterion("WARN_TYPE not in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeBetween(String value1, String value2) {
            addCriterion("WARN_TYPE between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotBetween(String value1, String value2) {
            addCriterion("WARN_TYPE not between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagIsNull() {
            addCriterion("SUSPEND_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagIsNotNull() {
            addCriterion("SUSPEND_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagEqualTo(String value) {
            addCriterion("SUSPEND_FLAG =", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagNotEqualTo(String value) {
            addCriterion("SUSPEND_FLAG <>", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagGreaterThan(String value) {
            addCriterion("SUSPEND_FLAG >", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SUSPEND_FLAG >=", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagLessThan(String value) {
            addCriterion("SUSPEND_FLAG <", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagLessThanOrEqualTo(String value) {
            addCriterion("SUSPEND_FLAG <=", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagLike(String value) {
            addCriterion("SUSPEND_FLAG like", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagNotLike(String value) {
            addCriterion("SUSPEND_FLAG not like", value, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagIn(List<String> values) {
            addCriterion("SUSPEND_FLAG in", values, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagNotIn(List<String> values) {
            addCriterion("SUSPEND_FLAG not in", values, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagBetween(String value1, String value2) {
            addCriterion("SUSPEND_FLAG between", value1, value2, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendFlagNotBetween(String value1, String value2) {
            addCriterion("SUSPEND_FLAG not between", value1, value2, "suspendFlag");
            return (Criteria) this;
        }

        public Criteria andSuspendDayIsNull() {
            addCriterion("SUSPEND_DAY is null");
            return (Criteria) this;
        }

        public Criteria andSuspendDayIsNotNull() {
            addCriterion("SUSPEND_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andSuspendDayEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAY =", value, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayNotEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAY <>", value, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayGreaterThan(BigDecimal value) {
            addCriterion("SUSPEND_DAY >", value, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAY >=", value, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayLessThan(BigDecimal value) {
            addCriterion("SUSPEND_DAY <", value, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUSPEND_DAY <=", value, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayIn(List<BigDecimal> values) {
            addCriterion("SUSPEND_DAY in", values, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayNotIn(List<BigDecimal> values) {
            addCriterion("SUSPEND_DAY not in", values, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUSPEND_DAY between", value1, value2, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andSuspendDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUSPEND_DAY not between", value1, value2, "suspendDay");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("TARGET_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("TARGET_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(String value) {
            addCriterion("TARGET_TYPE =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(String value) {
            addCriterion("TARGET_TYPE <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(String value) {
            addCriterion("TARGET_TYPE >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_TYPE >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(String value) {
            addCriterion("TARGET_TYPE <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(String value) {
            addCriterion("TARGET_TYPE <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLike(String value) {
            addCriterion("TARGET_TYPE like", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotLike(String value) {
            addCriterion("TARGET_TYPE not like", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<String> values) {
            addCriterion("TARGET_TYPE in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<String> values) {
            addCriterion("TARGET_TYPE not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(String value1, String value2) {
            addCriterion("TARGET_TYPE between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(String value1, String value2) {
            addCriterion("TARGET_TYPE not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassIsNull() {
            addCriterion("TARGET_BRCLASS is null");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassIsNotNull() {
            addCriterion("TARGET_BRCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassEqualTo(String value) {
            addCriterion("TARGET_BRCLASS =", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassNotEqualTo(String value) {
            addCriterion("TARGET_BRCLASS <>", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassGreaterThan(String value) {
            addCriterion("TARGET_BRCLASS >", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_BRCLASS >=", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassLessThan(String value) {
            addCriterion("TARGET_BRCLASS <", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassLessThanOrEqualTo(String value) {
            addCriterion("TARGET_BRCLASS <=", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassLike(String value) {
            addCriterion("TARGET_BRCLASS like", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassNotLike(String value) {
            addCriterion("TARGET_BRCLASS not like", value, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassIn(List<String> values) {
            addCriterion("TARGET_BRCLASS in", values, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassNotIn(List<String> values) {
            addCriterion("TARGET_BRCLASS not in", values, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassBetween(String value1, String value2) {
            addCriterion("TARGET_BRCLASS between", value1, value2, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetBrclassNotBetween(String value1, String value2) {
            addCriterion("TARGET_BRCLASS not between", value1, value2, "targetBrclass");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidIsNull() {
            addCriterion("TARGET_ROLEID is null");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidIsNotNull() {
            addCriterion("TARGET_ROLEID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidEqualTo(BigDecimal value) {
            addCriterion("TARGET_ROLEID =", value, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidNotEqualTo(BigDecimal value) {
            addCriterion("TARGET_ROLEID <>", value, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidGreaterThan(BigDecimal value) {
            addCriterion("TARGET_ROLEID >", value, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TARGET_ROLEID >=", value, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidLessThan(BigDecimal value) {
            addCriterion("TARGET_ROLEID <", value, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TARGET_ROLEID <=", value, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidIn(List<BigDecimal> values) {
            addCriterion("TARGET_ROLEID in", values, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidNotIn(List<BigDecimal> values) {
            addCriterion("TARGET_ROLEID not in", values, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TARGET_ROLEID between", value1, value2, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andTargetRoleidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TARGET_ROLEID not between", value1, value2, "targetRoleid");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNull() {
            addCriterion("PACKAGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("PACKAGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(String value) {
            addCriterion("PACKAGE_ID =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(String value) {
            addCriterion("PACKAGE_ID <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(String value) {
            addCriterion("PACKAGE_ID >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(String value) {
            addCriterion("PACKAGE_ID >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(String value) {
            addCriterion("PACKAGE_ID <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(String value) {
            addCriterion("PACKAGE_ID <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLike(String value) {
            addCriterion("PACKAGE_ID like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotLike(String value) {
            addCriterion("PACKAGE_ID not like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<String> values) {
            addCriterion("PACKAGE_ID in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<String> values) {
            addCriterion("PACKAGE_ID not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(String value1, String value2) {
            addCriterion("PACKAGE_ID between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(String value1, String value2) {
            addCriterion("PACKAGE_ID not between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andWarnProcessIsNull() {
            addCriterion("WARN_PROCESS is null");
            return (Criteria) this;
        }

        public Criteria andWarnProcessIsNotNull() {
            addCriterion("WARN_PROCESS is not null");
            return (Criteria) this;
        }

        public Criteria andWarnProcessEqualTo(String value) {
            addCriterion("WARN_PROCESS =", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessNotEqualTo(String value) {
            addCriterion("WARN_PROCESS <>", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessGreaterThan(String value) {
            addCriterion("WARN_PROCESS >", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_PROCESS >=", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessLessThan(String value) {
            addCriterion("WARN_PROCESS <", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessLessThanOrEqualTo(String value) {
            addCriterion("WARN_PROCESS <=", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessLike(String value) {
            addCriterion("WARN_PROCESS like", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessNotLike(String value) {
            addCriterion("WARN_PROCESS not like", value, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessIn(List<String> values) {
            addCriterion("WARN_PROCESS in", values, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessNotIn(List<String> values) {
            addCriterion("WARN_PROCESS not in", values, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessBetween(String value1, String value2) {
            addCriterion("WARN_PROCESS between", value1, value2, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnProcessNotBetween(String value1, String value2) {
            addCriterion("WARN_PROCESS not between", value1, value2, "warnProcess");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowIsNull() {
            addCriterion("WARN_LEVEL_LOW is null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowIsNotNull() {
            addCriterion("WARN_LEVEL_LOW is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowEqualTo(String value) {
            addCriterion("WARN_LEVEL_LOW =", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowNotEqualTo(String value) {
            addCriterion("WARN_LEVEL_LOW <>", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowGreaterThan(String value) {
            addCriterion("WARN_LEVEL_LOW >", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL_LOW >=", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowLessThan(String value) {
            addCriterion("WARN_LEVEL_LOW <", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowLessThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL_LOW <=", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowLike(String value) {
            addCriterion("WARN_LEVEL_LOW like", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowNotLike(String value) {
            addCriterion("WARN_LEVEL_LOW not like", value, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowIn(List<String> values) {
            addCriterion("WARN_LEVEL_LOW in", values, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowNotIn(List<String> values) {
            addCriterion("WARN_LEVEL_LOW not in", values, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL_LOW between", value1, value2, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLowNotBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL_LOW not between", value1, value2, "warnLevelLow");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiIsNull() {
            addCriterion("WARN_LEVEL_MIDI is null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiIsNotNull() {
            addCriterion("WARN_LEVEL_MIDI is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiEqualTo(String value) {
            addCriterion("WARN_LEVEL_MIDI =", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiNotEqualTo(String value) {
            addCriterion("WARN_LEVEL_MIDI <>", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiGreaterThan(String value) {
            addCriterion("WARN_LEVEL_MIDI >", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL_MIDI >=", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiLessThan(String value) {
            addCriterion("WARN_LEVEL_MIDI <", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiLessThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL_MIDI <=", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiLike(String value) {
            addCriterion("WARN_LEVEL_MIDI like", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiNotLike(String value) {
            addCriterion("WARN_LEVEL_MIDI not like", value, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiIn(List<String> values) {
            addCriterion("WARN_LEVEL_MIDI in", values, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiNotIn(List<String> values) {
            addCriterion("WARN_LEVEL_MIDI not in", values, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL_MIDI between", value1, value2, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelMidiNotBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL_MIDI not between", value1, value2, "warnLevelMidi");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighIsNull() {
            addCriterion("WARN_LEVEL_HIGH is null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighIsNotNull() {
            addCriterion("WARN_LEVEL_HIGH is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighEqualTo(String value) {
            addCriterion("WARN_LEVEL_HIGH =", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighNotEqualTo(String value) {
            addCriterion("WARN_LEVEL_HIGH <>", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighGreaterThan(String value) {
            addCriterion("WARN_LEVEL_HIGH >", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL_HIGH >=", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighLessThan(String value) {
            addCriterion("WARN_LEVEL_HIGH <", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighLessThanOrEqualTo(String value) {
            addCriterion("WARN_LEVEL_HIGH <=", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighLike(String value) {
            addCriterion("WARN_LEVEL_HIGH like", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighNotLike(String value) {
            addCriterion("WARN_LEVEL_HIGH not like", value, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighIn(List<String> values) {
            addCriterion("WARN_LEVEL_HIGH in", values, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighNotIn(List<String> values) {
            addCriterion("WARN_LEVEL_HIGH not in", values, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL_HIGH between", value1, value2, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnLevelHighNotBetween(String value1, String value2) {
            addCriterion("WARN_LEVEL_HIGH not between", value1, value2, "warnLevelHigh");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeIsNull() {
            addCriterion("WARN_BUSS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeIsNotNull() {
            addCriterion("WARN_BUSS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeEqualTo(String value) {
            addCriterion("WARN_BUSS_TYPE =", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeNotEqualTo(String value) {
            addCriterion("WARN_BUSS_TYPE <>", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeGreaterThan(String value) {
            addCriterion("WARN_BUSS_TYPE >", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_BUSS_TYPE >=", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeLessThan(String value) {
            addCriterion("WARN_BUSS_TYPE <", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeLessThanOrEqualTo(String value) {
            addCriterion("WARN_BUSS_TYPE <=", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeLike(String value) {
            addCriterion("WARN_BUSS_TYPE like", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeNotLike(String value) {
            addCriterion("WARN_BUSS_TYPE not like", value, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeIn(List<String> values) {
            addCriterion("WARN_BUSS_TYPE in", values, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeNotIn(List<String> values) {
            addCriterion("WARN_BUSS_TYPE not in", values, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeBetween(String value1, String value2) {
            addCriterion("WARN_BUSS_TYPE between", value1, value2, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andWarnBussTypeNotBetween(String value1, String value2) {
            addCriterion("WARN_BUSS_TYPE not between", value1, value2, "warnBussType");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNull() {
            addCriterion("TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andTlrnoIsNotNull() {
            addCriterion("TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andTlrnoEqualTo(String value) {
            addCriterion("TLRNO =", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotEqualTo(String value) {
            addCriterion("TLRNO <>", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThan(String value) {
            addCriterion("TLRNO >", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("TLRNO >=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThan(String value) {
            addCriterion("TLRNO <", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLessThanOrEqualTo(String value) {
            addCriterion("TLRNO <=", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoLike(String value) {
            addCriterion("TLRNO like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotLike(String value) {
            addCriterion("TLRNO not like", value, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoIn(List<String> values) {
            addCriterion("TLRNO in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotIn(List<String> values) {
            addCriterion("TLRNO not in", values, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoBetween(String value1, String value2) {
            addCriterion("TLRNO between", value1, value2, "tlrno");
            return (Criteria) this;
        }

        public Criteria andTlrnoNotBetween(String value1, String value2) {
            addCriterion("TLRNO not between", value1, value2, "tlrno");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}