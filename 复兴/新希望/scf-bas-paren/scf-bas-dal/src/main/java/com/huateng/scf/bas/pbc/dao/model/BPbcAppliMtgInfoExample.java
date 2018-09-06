package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcAppliMtgInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcAppliMtgInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcAppliMtgInfoExample(BPbcAppliMtgInfoExample example) {
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

        public Criteria andAppliMortBizTypeIsNull() {
            addCriterion("APPLI_MORT_BIZ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeIsNotNull() {
            addCriterion("APPLI_MORT_BIZ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeEqualTo(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE =", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeNotEqualTo(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE <>", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeGreaterThan(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE >", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE >=", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeLessThan(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE <", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeLessThanOrEqualTo(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE <=", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeLike(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE like", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeNotLike(String value) {
            addCriterion("APPLI_MORT_BIZ_TYPE not like", value, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeIn(List<String> values) {
            addCriterion("APPLI_MORT_BIZ_TYPE in", values, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeNotIn(List<String> values) {
            addCriterion("APPLI_MORT_BIZ_TYPE not in", values, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeBetween(String value1, String value2) {
            addCriterion("APPLI_MORT_BIZ_TYPE between", value1, value2, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andAppliMortBizTypeNotBetween(String value1, String value2) {
            addCriterion("APPLI_MORT_BIZ_TYPE not between", value1, value2, "appliMortBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIsNull() {
            addCriterion("MORTGAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIsNotNull() {
            addCriterion("MORTGAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoEqualTo(String value) {
            addCriterion("MORTGAGE_NO =", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotEqualTo(String value) {
            addCriterion("MORTGAGE_NO <>", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThan(String value) {
            addCriterion("MORTGAGE_NO >", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NO >=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThan(String value) {
            addCriterion("MORTGAGE_NO <", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NO <=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLike(String value) {
            addCriterion("MORTGAGE_NO like", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotLike(String value) {
            addCriterion("MORTGAGE_NO not like", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIn(List<String> values) {
            addCriterion("MORTGAGE_NO in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotIn(List<String> values) {
            addCriterion("MORTGAGE_NO not in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NO between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NO not between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeIsNull() {
            addCriterion("MORTGAGE_BIZ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeIsNotNull() {
            addCriterion("MORTGAGE_BIZ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeEqualTo(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE =", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeNotEqualTo(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE <>", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeGreaterThan(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE >", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE >=", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeLessThan(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE <", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE <=", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeLike(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE like", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeNotLike(String value) {
            addCriterion("MORTGAGE_BIZ_TYPE not like", value, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeIn(List<String> values) {
            addCriterion("MORTGAGE_BIZ_TYPE in", values, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeNotIn(List<String> values) {
            addCriterion("MORTGAGE_BIZ_TYPE not in", values, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeBetween(String value1, String value2) {
            addCriterion("MORTGAGE_BIZ_TYPE between", value1, value2, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageBizTypeNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_BIZ_TYPE not between", value1, value2, "mortgageBizType");
            return (Criteria) this;
        }

        public Criteria andMortgageClassIsNull() {
            addCriterion("MORTGAGE_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andMortgageClassIsNotNull() {
            addCriterion("MORTGAGE_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageClassEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS =", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNotEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS <>", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassGreaterThan(String value) {
            addCriterion("MORTGAGE_CLASS >", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS >=", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassLessThan(String value) {
            addCriterion("MORTGAGE_CLASS <", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_CLASS <=", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassLike(String value) {
            addCriterion("MORTGAGE_CLASS like", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNotLike(String value) {
            addCriterion("MORTGAGE_CLASS not like", value, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassIn(List<String> values) {
            addCriterion("MORTGAGE_CLASS in", values, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNotIn(List<String> values) {
            addCriterion("MORTGAGE_CLASS not in", values, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassBetween(String value1, String value2) {
            addCriterion("MORTGAGE_CLASS between", value1, value2, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageClassNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_CLASS not between", value1, value2, "mortgageClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassIsNull() {
            addCriterion("MORTGAGE_SUB_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassIsNotNull() {
            addCriterion("MORTGAGE_SUB_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS =", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS <>", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassGreaterThan(String value) {
            addCriterion("MORTGAGE_SUB_CLASS >", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS >=", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassLessThan(String value) {
            addCriterion("MORTGAGE_SUB_CLASS <", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_SUB_CLASS <=", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassLike(String value) {
            addCriterion("MORTGAGE_SUB_CLASS like", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotLike(String value) {
            addCriterion("MORTGAGE_SUB_CLASS not like", value, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassIn(List<String> values) {
            addCriterion("MORTGAGE_SUB_CLASS in", values, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotIn(List<String> values) {
            addCriterion("MORTGAGE_SUB_CLASS not in", values, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassBetween(String value1, String value2) {
            addCriterion("MORTGAGE_SUB_CLASS between", value1, value2, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMortgageSubClassNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_SUB_CLASS not between", value1, value2, "mortgageSubClass");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoIsNull() {
            addCriterion("MONITOR_PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoIsNotNull() {
            addCriterion("MONITOR_PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO =", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO <>", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoGreaterThan(String value) {
            addCriterion("MONITOR_PROTOCOL_NO >", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO >=", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoLessThan(String value) {
            addCriterion("MONITOR_PROTOCOL_NO <", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("MONITOR_PROTOCOL_NO <=", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoLike(String value) {
            addCriterion("MONITOR_PROTOCOL_NO like", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotLike(String value) {
            addCriterion("MONITOR_PROTOCOL_NO not like", value, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoIn(List<String> values) {
            addCriterion("MONITOR_PROTOCOL_NO in", values, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotIn(List<String> values) {
            addCriterion("MONITOR_PROTOCOL_NO not in", values, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoBetween(String value1, String value2) {
            addCriterion("MONITOR_PROTOCOL_NO between", value1, value2, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMonitorProtocolNoNotBetween(String value1, String value2) {
            addCriterion("MONITOR_PROTOCOL_NO not between", value1, value2, "monitorProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIsNull() {
            addCriterion("OTHER_PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIsNotNull() {
            addCriterion("OTHER_PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO =", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO <>", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoGreaterThan(String value) {
            addCriterion("OTHER_PROTOCOL_NO >", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO >=", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLessThan(String value) {
            addCriterion("OTHER_PROTOCOL_NO <", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO <=", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLike(String value) {
            addCriterion("OTHER_PROTOCOL_NO like", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotLike(String value) {
            addCriterion("OTHER_PROTOCOL_NO not like", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIn(List<String> values) {
            addCriterion("OTHER_PROTOCOL_NO in", values, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotIn(List<String> values) {
            addCriterion("OTHER_PROTOCOL_NO not in", values, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoBetween(String value1, String value2) {
            addCriterion("OTHER_PROTOCOL_NO between", value1, value2, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotBetween(String value1, String value2) {
            addCriterion("OTHER_PROTOCOL_NO not between", value1, value2, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andMortgageModelIsNull() {
            addCriterion("MORTGAGE_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andMortgageModelIsNotNull() {
            addCriterion("MORTGAGE_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageModelEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL =", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL <>", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelGreaterThan(String value) {
            addCriterion("MORTGAGE_MODEL >", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL >=", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelLessThan(String value) {
            addCriterion("MORTGAGE_MODEL <", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_MODEL <=", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelLike(String value) {
            addCriterion("MORTGAGE_MODEL like", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotLike(String value) {
            addCriterion("MORTGAGE_MODEL not like", value, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelIn(List<String> values) {
            addCriterion("MORTGAGE_MODEL in", values, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotIn(List<String> values) {
            addCriterion("MORTGAGE_MODEL not in", values, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelBetween(String value1, String value2) {
            addCriterion("MORTGAGE_MODEL between", value1, value2, "mortgageModel");
            return (Criteria) this;
        }

        public Criteria andMortgageModelNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_MODEL not between", value1, value2, "mortgageModel");
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

        public Criteria andMortgageUnitsIsNull() {
            addCriterion("MORTGAGE_UNITS is null");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsIsNotNull() {
            addCriterion("MORTGAGE_UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS =", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS <>", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsGreaterThan(String value) {
            addCriterion("MORTGAGE_UNITS >", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS >=", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsLessThan(String value) {
            addCriterion("MORTGAGE_UNITS <", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_UNITS <=", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsLike(String value) {
            addCriterion("MORTGAGE_UNITS like", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotLike(String value) {
            addCriterion("MORTGAGE_UNITS not like", value, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsIn(List<String> values) {
            addCriterion("MORTGAGE_UNITS in", values, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotIn(List<String> values) {
            addCriterion("MORTGAGE_UNITS not in", values, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsBetween(String value1, String value2) {
            addCriterion("MORTGAGE_UNITS between", value1, value2, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andMortgageUnitsNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_UNITS not between", value1, value2, "mortgageUnits");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(BigDecimal value) {
            addCriterion("QUANTITY =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(BigDecimal value) {
            addCriterion("QUANTITY >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(BigDecimal value) {
            addCriterion("QUANTITY <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<BigDecimal> values) {
            addCriterion("QUANTITY in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<BigDecimal> values) {
            addCriterion("QUANTITY not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTotPriceIsNull() {
            addCriterion("TOT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotPriceIsNotNull() {
            addCriterion("TOT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotPriceEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE =", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceNotEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE <>", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceGreaterThan(BigDecimal value) {
            addCriterion("TOT_PRICE >", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE >=", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceLessThan(BigDecimal value) {
            addCriterion("TOT_PRICE <", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOT_PRICE <=", value, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceIn(List<BigDecimal> values) {
            addCriterion("TOT_PRICE in", values, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceNotIn(List<BigDecimal> values) {
            addCriterion("TOT_PRICE not in", values, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_PRICE between", value1, value2, "totPrice");
            return (Criteria) this;
        }

        public Criteria andTotPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOT_PRICE not between", value1, value2, "totPrice");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("MANUFACTURER is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("MANUFACTURER is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("MANUFACTURER =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("MANUFACTURER <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("MANUFACTURER >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("MANUFACTURER <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("MANUFACTURER like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("MANUFACTURER not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("MANUFACTURER in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("MANUFACTURER not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("MANUFACTURER between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("MANUFACTURER not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNull() {
            addCriterion("WAREHOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNotNull() {
            addCriterion("WAREHOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdEqualTo(String value) {
            addCriterion("WAREHOUSE_ID =", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotEqualTo(String value) {
            addCriterion("WAREHOUSE_ID <>", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThan(String value) {
            addCriterion("WAREHOUSE_ID >", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ID >=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThan(String value) {
            addCriterion("WAREHOUSE_ID <", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ID <=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLike(String value) {
            addCriterion("WAREHOUSE_ID like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotLike(String value) {
            addCriterion("WAREHOUSE_ID not like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIn(List<String> values) {
            addCriterion("WAREHOUSE_ID in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotIn(List<String> values) {
            addCriterion("WAREHOUSE_ID not in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ID between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ID not between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andBalQuantityIsNull() {
            addCriterion("BAL_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andBalQuantityIsNotNull() {
            addCriterion("BAL_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andBalQuantityEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY =", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityNotEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY <>", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityGreaterThan(BigDecimal value) {
            addCriterion("BAL_QUANTITY >", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY >=", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityLessThan(BigDecimal value) {
            addCriterion("BAL_QUANTITY <", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAL_QUANTITY <=", value, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityIn(List<BigDecimal> values) {
            addCriterion("BAL_QUANTITY in", values, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityNotIn(List<BigDecimal> values) {
            addCriterion("BAL_QUANTITY not in", values, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_QUANTITY between", value1, value2, "balQuantity");
            return (Criteria) this;
        }

        public Criteria andBalQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAL_QUANTITY not between", value1, value2, "balQuantity");
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

        public Criteria andMortgageLevelOneIsNull() {
            addCriterion("MORTGAGE_LEVEL_ONE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_ONE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE =", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE <>", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE >", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE >=", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE <", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE <=", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneLike(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE like", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_ONE not like", value, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_ONE in", values, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_ONE not in", values, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_ONE between", value1, value2, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelOneNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_ONE not between", value1, value2, "mortgageLevelOne");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoIsNull() {
            addCriterion("MORTGAGE_LEVEL_TWO is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_TWO is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO =", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO <>", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO >", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO >=", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO <", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO <=", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoLike(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO like", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_TWO not like", value, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_TWO in", values, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_TWO not in", values, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_TWO between", value1, value2, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelTwoNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_TWO not between", value1, value2, "mortgageLevelTwo");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeIsNull() {
            addCriterion("MORTGAGE_LEVEL_THREE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_THREE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE =", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE <>", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE >", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE >=", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE <", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE <=", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeLike(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE like", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_THREE not like", value, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_THREE in", values, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_THREE not in", values, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_THREE between", value1, value2, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelThreeNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_THREE not between", value1, value2, "mortgageLevelThree");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourIsNull() {
            addCriterion("MORTGAGE_LEVEL_FOUR is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_FOUR is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR =", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR <>", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR >", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR >=", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR <", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR <=", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR like", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FOUR not like", value, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FOUR in", values, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FOUR not in", values, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FOUR between", value1, value2, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFourNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FOUR not between", value1, value2, "mortgageLevelFour");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveIsNull() {
            addCriterion("MORTGAGE_LEVEL_FIVE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_FIVE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE =", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE <>", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE >", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE >=", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE <", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE <=", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE like", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_FIVE not like", value, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FIVE in", values, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_FIVE not in", values, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FIVE between", value1, value2, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelFiveNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_FIVE not between", value1, value2, "mortgageLevelFive");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixIsNull() {
            addCriterion("MORTGAGE_LEVEL_SIX is null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixIsNotNull() {
            addCriterion("MORTGAGE_LEVEL_SIX is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX =", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixNotEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX <>", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixGreaterThan(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX >", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX >=", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixLessThan(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX <", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX <=", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixLike(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX like", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixNotLike(String value) {
            addCriterion("MORTGAGE_LEVEL_SIX not like", value, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_SIX in", values, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixNotIn(List<String> values) {
            addCriterion("MORTGAGE_LEVEL_SIX not in", values, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_SIX between", value1, value2, "mortgageLevelSix");
            return (Criteria) this;
        }

        public Criteria andMortgageLevelSixNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_LEVEL_SIX not between", value1, value2, "mortgageLevelSix");
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

        public Criteria andOriginalPriceIsNull() {
            addCriterion("ORIGINAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("ORIGINAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_PRICE =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_PRICE <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("ORIGINAL_PRICE >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_PRICE >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("ORIGINAL_PRICE <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_PRICE <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_PRICE in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_PRICE not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_PRICE between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_PRICE not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceIsNull() {
            addCriterion("ORIGINAL_TOT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceIsNotNull() {
            addCriterion("ORIGINAL_TOT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_TOT_PRICE =", value, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceNotEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_TOT_PRICE <>", value, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceGreaterThan(BigDecimal value) {
            addCriterion("ORIGINAL_TOT_PRICE >", value, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_TOT_PRICE >=", value, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceLessThan(BigDecimal value) {
            addCriterion("ORIGINAL_TOT_PRICE <", value, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_TOT_PRICE <=", value, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_TOT_PRICE in", values, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceNotIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_TOT_PRICE not in", values, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_TOT_PRICE between", value1, value2, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalTotPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_TOT_PRICE not between", value1, value2, "originalTotPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("MARKET_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("MARKET_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE =", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE <>", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("MARKET_PRICE >", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE >=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(BigDecimal value) {
            addCriterion("MARKET_PRICE <", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARKET_PRICE <=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<BigDecimal> values) {
            addCriterion("MARKET_PRICE in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("MARKET_PRICE not in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARKET_PRICE between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARKET_PRICE not between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceIsNull() {
            addCriterion("CONFIRM_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceIsNotNull() {
            addCriterion("CONFIRM_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE =", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceNotEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE <>", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceGreaterThan(BigDecimal value) {
            addCriterion("CONFIRM_PRICE >", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE >=", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceLessThan(BigDecimal value) {
            addCriterion("CONFIRM_PRICE <", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_PRICE <=", value, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceIn(List<BigDecimal> values) {
            addCriterion("CONFIRM_PRICE in", values, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceNotIn(List<BigDecimal> values) {
            addCriterion("CONFIRM_PRICE not in", values, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONFIRM_PRICE between", value1, value2, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONFIRM_PRICE not between", value1, value2, "confirmPrice");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNull() {
            addCriterion("STOCK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNotNull() {
            addCriterion("STOCK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStockStatusEqualTo(String value) {
            addCriterion("STOCK_STATUS =", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotEqualTo(String value) {
            addCriterion("STOCK_STATUS <>", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThan(String value) {
            addCriterion("STOCK_STATUS >", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STOCK_STATUS >=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThan(String value) {
            addCriterion("STOCK_STATUS <", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThanOrEqualTo(String value) {
            addCriterion("STOCK_STATUS <=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLike(String value) {
            addCriterion("STOCK_STATUS like", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotLike(String value) {
            addCriterion("STOCK_STATUS not like", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusIn(List<String> values) {
            addCriterion("STOCK_STATUS in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotIn(List<String> values) {
            addCriterion("STOCK_STATUS not in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusBetween(String value1, String value2) {
            addCriterion("STOCK_STATUS between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotBetween(String value1, String value2) {
            addCriterion("STOCK_STATUS not between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdIsNull() {
            addCriterion("MONI_OF_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdIsNotNull() {
            addCriterion("MONI_OF_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD =", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD <>", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdGreaterThan(String value) {
            addCriterion("MONI_OF_CUSTCD >", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD >=", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdLessThan(String value) {
            addCriterion("MONI_OF_CUSTCD <", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdLessThanOrEqualTo(String value) {
            addCriterion("MONI_OF_CUSTCD <=", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdLike(String value) {
            addCriterion("MONI_OF_CUSTCD like", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotLike(String value) {
            addCriterion("MONI_OF_CUSTCD not like", value, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdIn(List<String> values) {
            addCriterion("MONI_OF_CUSTCD in", values, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotIn(List<String> values) {
            addCriterion("MONI_OF_CUSTCD not in", values, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdBetween(String value1, String value2) {
            addCriterion("MONI_OF_CUSTCD between", value1, value2, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andMoniOfCustcdNotBetween(String value1, String value2) {
            addCriterion("MONI_OF_CUSTCD not between", value1, value2, "moniOfCustcd");
            return (Criteria) this;
        }

        public Criteria andVenderIsNull() {
            addCriterion("VENDER is null");
            return (Criteria) this;
        }

        public Criteria andVenderIsNotNull() {
            addCriterion("VENDER is not null");
            return (Criteria) this;
        }

        public Criteria andVenderEqualTo(String value) {
            addCriterion("VENDER =", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotEqualTo(String value) {
            addCriterion("VENDER <>", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderGreaterThan(String value) {
            addCriterion("VENDER >", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderGreaterThanOrEqualTo(String value) {
            addCriterion("VENDER >=", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderLessThan(String value) {
            addCriterion("VENDER <", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderLessThanOrEqualTo(String value) {
            addCriterion("VENDER <=", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderLike(String value) {
            addCriterion("VENDER like", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotLike(String value) {
            addCriterion("VENDER not like", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderIn(List<String> values) {
            addCriterion("VENDER in", values, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotIn(List<String> values) {
            addCriterion("VENDER not in", values, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderBetween(String value1, String value2) {
            addCriterion("VENDER between", value1, value2, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotBetween(String value1, String value2) {
            addCriterion("VENDER not between", value1, value2, "vender");
            return (Criteria) this;
        }

        public Criteria andProductAreaIsNull() {
            addCriterion("PRODUCT_AREA is null");
            return (Criteria) this;
        }

        public Criteria andProductAreaIsNotNull() {
            addCriterion("PRODUCT_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andProductAreaEqualTo(String value) {
            addCriterion("PRODUCT_AREA =", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaNotEqualTo(String value) {
            addCriterion("PRODUCT_AREA <>", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaGreaterThan(String value) {
            addCriterion("PRODUCT_AREA >", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_AREA >=", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaLessThan(String value) {
            addCriterion("PRODUCT_AREA <", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_AREA <=", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaLike(String value) {
            addCriterion("PRODUCT_AREA like", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaNotLike(String value) {
            addCriterion("PRODUCT_AREA not like", value, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaIn(List<String> values) {
            addCriterion("PRODUCT_AREA in", values, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaNotIn(List<String> values) {
            addCriterion("PRODUCT_AREA not in", values, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaBetween(String value1, String value2) {
            addCriterion("PRODUCT_AREA between", value1, value2, "productArea");
            return (Criteria) this;
        }

        public Criteria andProductAreaNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_AREA not between", value1, value2, "productArea");
            return (Criteria) this;
        }

        public Criteria andIncomeNoIsNull() {
            addCriterion("INCOME_NO is null");
            return (Criteria) this;
        }

        public Criteria andIncomeNoIsNotNull() {
            addCriterion("INCOME_NO is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeNoEqualTo(String value) {
            addCriterion("INCOME_NO =", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoNotEqualTo(String value) {
            addCriterion("INCOME_NO <>", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoGreaterThan(String value) {
            addCriterion("INCOME_NO >", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_NO >=", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoLessThan(String value) {
            addCriterion("INCOME_NO <", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoLessThanOrEqualTo(String value) {
            addCriterion("INCOME_NO <=", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoLike(String value) {
            addCriterion("INCOME_NO like", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoNotLike(String value) {
            addCriterion("INCOME_NO not like", value, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoIn(List<String> values) {
            addCriterion("INCOME_NO in", values, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoNotIn(List<String> values) {
            addCriterion("INCOME_NO not in", values, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoBetween(String value1, String value2) {
            addCriterion("INCOME_NO between", value1, value2, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andIncomeNoNotBetween(String value1, String value2) {
            addCriterion("INCOME_NO not between", value1, value2, "incomeNo");
            return (Criteria) this;
        }

        public Criteria andRationIsNull() {
            addCriterion("RATION is null");
            return (Criteria) this;
        }

        public Criteria andRationIsNotNull() {
            addCriterion("RATION is not null");
            return (Criteria) this;
        }

        public Criteria andRationEqualTo(BigDecimal value) {
            addCriterion("RATION =", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotEqualTo(BigDecimal value) {
            addCriterion("RATION <>", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThan(BigDecimal value) {
            addCriterion("RATION >", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION >=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThan(BigDecimal value) {
            addCriterion("RATION <", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATION <=", value, "ration");
            return (Criteria) this;
        }

        public Criteria andRationIn(List<BigDecimal> values) {
            addCriterion("RATION in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotIn(List<BigDecimal> values) {
            addCriterion("RATION not in", values, "ration");
            return (Criteria) this;
        }

        public Criteria andRationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION between", value1, value2, "ration");
            return (Criteria) this;
        }

        public Criteria andRationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATION not between", value1, value2, "ration");
            return (Criteria) this;
        }

        public Criteria andQualityLevelIsNull() {
            addCriterion("QUALITY_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andQualityLevelIsNotNull() {
            addCriterion("QUALITY_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andQualityLevelEqualTo(String value) {
            addCriterion("QUALITY_LEVEL =", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotEqualTo(String value) {
            addCriterion("QUALITY_LEVEL <>", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelGreaterThan(String value) {
            addCriterion("QUALITY_LEVEL >", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("QUALITY_LEVEL >=", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelLessThan(String value) {
            addCriterion("QUALITY_LEVEL <", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelLessThanOrEqualTo(String value) {
            addCriterion("QUALITY_LEVEL <=", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelLike(String value) {
            addCriterion("QUALITY_LEVEL like", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotLike(String value) {
            addCriterion("QUALITY_LEVEL not like", value, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelIn(List<String> values) {
            addCriterion("QUALITY_LEVEL in", values, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotIn(List<String> values) {
            addCriterion("QUALITY_LEVEL not in", values, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelBetween(String value1, String value2) {
            addCriterion("QUALITY_LEVEL between", value1, value2, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andQualityLevelNotBetween(String value1, String value2) {
            addCriterion("QUALITY_LEVEL not between", value1, value2, "qualityLevel");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("SN =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("SN <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("SN >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("SN >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("SN <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("SN <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("SN like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("SN not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("SN in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("SN not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("SN between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("YEAR is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("YEAR =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("YEAR <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("YEAR >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("YEAR >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("YEAR <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("YEAR <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("YEAR like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("YEAR not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("YEAR in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("YEAR not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("YEAR between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("YEAR not between", value1, value2, "year");
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

        public Criteria andWeightAllIsNull() {
            addCriterion("WEIGHT_ALL is null");
            return (Criteria) this;
        }

        public Criteria andWeightAllIsNotNull() {
            addCriterion("WEIGHT_ALL is not null");
            return (Criteria) this;
        }

        public Criteria andWeightAllEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL =", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllNotEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL <>", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllGreaterThan(BigDecimal value) {
            addCriterion("WEIGHT_ALL >", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL >=", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllLessThan(BigDecimal value) {
            addCriterion("WEIGHT_ALL <", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT_ALL <=", value, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllIn(List<BigDecimal> values) {
            addCriterion("WEIGHT_ALL in", values, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllNotIn(List<BigDecimal> values) {
            addCriterion("WEIGHT_ALL not in", values, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT_ALL between", value1, value2, "weightAll");
            return (Criteria) this;
        }

        public Criteria andWeightAllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT_ALL not between", value1, value2, "weightAll");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyIsNull() {
            addCriterion("UP_DOWN_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyIsNotNull() {
            addCriterion("UP_DOWN_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_MONEY =", value, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyNotEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_MONEY <>", value, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyGreaterThan(BigDecimal value) {
            addCriterion("UP_DOWN_MONEY >", value, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_MONEY >=", value, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyLessThan(BigDecimal value) {
            addCriterion("UP_DOWN_MONEY <", value, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UP_DOWN_MONEY <=", value, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyIn(List<BigDecimal> values) {
            addCriterion("UP_DOWN_MONEY in", values, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyNotIn(List<BigDecimal> values) {
            addCriterion("UP_DOWN_MONEY not in", values, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UP_DOWN_MONEY between", value1, value2, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UP_DOWN_MONEY not between", value1, value2, "upDownMoney");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNull() {
            addCriterion("BILLNO is null");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNotNull() {
            addCriterion("BILLNO is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoEqualTo(String value) {
            addCriterion("BILLNO =", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotEqualTo(String value) {
            addCriterion("BILLNO <>", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThan(String value) {
            addCriterion("BILLNO >", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThanOrEqualTo(String value) {
            addCriterion("BILLNO >=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThan(String value) {
            addCriterion("BILLNO <", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThanOrEqualTo(String value) {
            addCriterion("BILLNO <=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLike(String value) {
            addCriterion("BILLNO like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotLike(String value) {
            addCriterion("BILLNO not like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoIn(List<String> values) {
            addCriterion("BILLNO in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotIn(List<String> values) {
            addCriterion("BILLNO not in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoBetween(String value1, String value2) {
            addCriterion("BILLNO between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotBetween(String value1, String value2) {
            addCriterion("BILLNO not between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillQuantityIsNull() {
            addCriterion("BILL_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andBillQuantityIsNotNull() {
            addCriterion("BILL_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andBillQuantityEqualTo(BigDecimal value) {
            addCriterion("BILL_QUANTITY =", value, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityNotEqualTo(BigDecimal value) {
            addCriterion("BILL_QUANTITY <>", value, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityGreaterThan(BigDecimal value) {
            addCriterion("BILL_QUANTITY >", value, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_QUANTITY >=", value, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityLessThan(BigDecimal value) {
            addCriterion("BILL_QUANTITY <", value, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_QUANTITY <=", value, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityIn(List<BigDecimal> values) {
            addCriterion("BILL_QUANTITY in", values, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityNotIn(List<BigDecimal> values) {
            addCriterion("BILL_QUANTITY not in", values, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_QUANTITY between", value1, value2, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andBillQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_QUANTITY not between", value1, value2, "billQuantity");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdIsNull() {
            addCriterion("FUTURE_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdIsNotNull() {
            addCriterion("FUTURE_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdEqualTo(String value) {
            addCriterion("FUTURE_CUSTCD =", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdNotEqualTo(String value) {
            addCriterion("FUTURE_CUSTCD <>", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdGreaterThan(String value) {
            addCriterion("FUTURE_CUSTCD >", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("FUTURE_CUSTCD >=", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdLessThan(String value) {
            addCriterion("FUTURE_CUSTCD <", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdLessThanOrEqualTo(String value) {
            addCriterion("FUTURE_CUSTCD <=", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdLike(String value) {
            addCriterion("FUTURE_CUSTCD like", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdNotLike(String value) {
            addCriterion("FUTURE_CUSTCD not like", value, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdIn(List<String> values) {
            addCriterion("FUTURE_CUSTCD in", values, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdNotIn(List<String> values) {
            addCriterion("FUTURE_CUSTCD not in", values, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdBetween(String value1, String value2) {
            addCriterion("FUTURE_CUSTCD between", value1, value2, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andFutureCustcdNotBetween(String value1, String value2) {
            addCriterion("FUTURE_CUSTCD not between", value1, value2, "futureCustcd");
            return (Criteria) this;
        }

        public Criteria andBillDueDateIsNull() {
            addCriterion("BILL_DUE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillDueDateIsNotNull() {
            addCriterion("BILL_DUE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillDueDateEqualTo(String value) {
            addCriterion("BILL_DUE_DATE =", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateNotEqualTo(String value) {
            addCriterion("BILL_DUE_DATE <>", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateGreaterThan(String value) {
            addCriterion("BILL_DUE_DATE >", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_DUE_DATE >=", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateLessThan(String value) {
            addCriterion("BILL_DUE_DATE <", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateLessThanOrEqualTo(String value) {
            addCriterion("BILL_DUE_DATE <=", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateLike(String value) {
            addCriterion("BILL_DUE_DATE like", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateNotLike(String value) {
            addCriterion("BILL_DUE_DATE not like", value, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateIn(List<String> values) {
            addCriterion("BILL_DUE_DATE in", values, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateNotIn(List<String> values) {
            addCriterion("BILL_DUE_DATE not in", values, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateBetween(String value1, String value2) {
            addCriterion("BILL_DUE_DATE between", value1, value2, "billDueDate");
            return (Criteria) this;
        }

        public Criteria andBillDueDateNotBetween(String value1, String value2) {
            addCriterion("BILL_DUE_DATE not between", value1, value2, "billDueDate");
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

        public Criteria andWarehouseAddressIsNull() {
            addCriterion("WAREHOUSE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressIsNotNull() {
            addCriterion("WAREHOUSE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS =", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS <>", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressGreaterThan(String value) {
            addCriterion("WAREHOUSE_ADDRESS >", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS >=", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLessThan(String value) {
            addCriterion("WAREHOUSE_ADDRESS <", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ADDRESS <=", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressLike(String value) {
            addCriterion("WAREHOUSE_ADDRESS like", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotLike(String value) {
            addCriterion("WAREHOUSE_ADDRESS not like", value, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressIn(List<String> values) {
            addCriterion("WAREHOUSE_ADDRESS in", values, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotIn(List<String> values) {
            addCriterion("WAREHOUSE_ADDRESS not in", values, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ADDRESS between", value1, value2, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andWarehouseAddressNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ADDRESS not between", value1, value2, "warehouseAddress");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceIsNull() {
            addCriterion("OLD_CONFIRM_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceIsNotNull() {
            addCriterion("OLD_CONFIRM_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_PRICE =", value, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceNotEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_PRICE <>", value, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceGreaterThan(BigDecimal value) {
            addCriterion("OLD_CONFIRM_PRICE >", value, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_PRICE >=", value, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceLessThan(BigDecimal value) {
            addCriterion("OLD_CONFIRM_PRICE <", value, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OLD_CONFIRM_PRICE <=", value, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceIn(List<BigDecimal> values) {
            addCriterion("OLD_CONFIRM_PRICE in", values, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceNotIn(List<BigDecimal> values) {
            addCriterion("OLD_CONFIRM_PRICE not in", values, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OLD_CONFIRM_PRICE between", value1, value2, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andOldConfirmPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OLD_CONFIRM_PRICE not between", value1, value2, "oldConfirmPrice");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingIsNull() {
            addCriterion("CONFIRM_ACCORDING is null");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingIsNotNull() {
            addCriterion("CONFIRM_ACCORDING is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING =", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING <>", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingGreaterThan(String value) {
            addCriterion("CONFIRM_ACCORDING >", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING >=", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingLessThan(String value) {
            addCriterion("CONFIRM_ACCORDING <", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingLessThanOrEqualTo(String value) {
            addCriterion("CONFIRM_ACCORDING <=", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingLike(String value) {
            addCriterion("CONFIRM_ACCORDING like", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotLike(String value) {
            addCriterion("CONFIRM_ACCORDING not like", value, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingIn(List<String> values) {
            addCriterion("CONFIRM_ACCORDING in", values, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotIn(List<String> values) {
            addCriterion("CONFIRM_ACCORDING not in", values, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingBetween(String value1, String value2) {
            addCriterion("CONFIRM_ACCORDING between", value1, value2, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andConfirmAccordingNotBetween(String value1, String value2) {
            addCriterion("CONFIRM_ACCORDING not between", value1, value2, "confirmAccording");
            return (Criteria) this;
        }

        public Criteria andMortgageNameIsNull() {
            addCriterion("MORTGAGE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMortgageNameIsNotNull() {
            addCriterion("MORTGAGE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageNameEqualTo(String value) {
            addCriterion("MORTGAGE_NAME =", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotEqualTo(String value) {
            addCriterion("MORTGAGE_NAME <>", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameGreaterThan(String value) {
            addCriterion("MORTGAGE_NAME >", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameGreaterThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NAME >=", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameLessThan(String value) {
            addCriterion("MORTGAGE_NAME <", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameLessThanOrEqualTo(String value) {
            addCriterion("MORTGAGE_NAME <=", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameLike(String value) {
            addCriterion("MORTGAGE_NAME like", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotLike(String value) {
            addCriterion("MORTGAGE_NAME not like", value, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameIn(List<String> values) {
            addCriterion("MORTGAGE_NAME in", values, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotIn(List<String> values) {
            addCriterion("MORTGAGE_NAME not in", values, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NAME between", value1, value2, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andMortgageNameNotBetween(String value1, String value2) {
            addCriterion("MORTGAGE_NAME not between", value1, value2, "mortgageName");
            return (Criteria) this;
        }

        public Criteria andFreightareaIsNull() {
            addCriterion("FREIGHTAREA is null");
            return (Criteria) this;
        }

        public Criteria andFreightareaIsNotNull() {
            addCriterion("FREIGHTAREA is not null");
            return (Criteria) this;
        }

        public Criteria andFreightareaEqualTo(String value) {
            addCriterion("FREIGHTAREA =", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotEqualTo(String value) {
            addCriterion("FREIGHTAREA <>", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaGreaterThan(String value) {
            addCriterion("FREIGHTAREA >", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaGreaterThanOrEqualTo(String value) {
            addCriterion("FREIGHTAREA >=", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaLessThan(String value) {
            addCriterion("FREIGHTAREA <", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaLessThanOrEqualTo(String value) {
            addCriterion("FREIGHTAREA <=", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaLike(String value) {
            addCriterion("FREIGHTAREA like", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotLike(String value) {
            addCriterion("FREIGHTAREA not like", value, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaIn(List<String> values) {
            addCriterion("FREIGHTAREA in", values, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotIn(List<String> values) {
            addCriterion("FREIGHTAREA not in", values, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaBetween(String value1, String value2) {
            addCriterion("FREIGHTAREA between", value1, value2, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightareaNotBetween(String value1, String value2) {
            addCriterion("FREIGHTAREA not between", value1, value2, "freightarea");
            return (Criteria) this;
        }

        public Criteria andFreightlotIsNull() {
            addCriterion("FREIGHTLOT is null");
            return (Criteria) this;
        }

        public Criteria andFreightlotIsNotNull() {
            addCriterion("FREIGHTLOT is not null");
            return (Criteria) this;
        }

        public Criteria andFreightlotEqualTo(String value) {
            addCriterion("FREIGHTLOT =", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotEqualTo(String value) {
            addCriterion("FREIGHTLOT <>", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotGreaterThan(String value) {
            addCriterion("FREIGHTLOT >", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotGreaterThanOrEqualTo(String value) {
            addCriterion("FREIGHTLOT >=", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotLessThan(String value) {
            addCriterion("FREIGHTLOT <", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotLessThanOrEqualTo(String value) {
            addCriterion("FREIGHTLOT <=", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotLike(String value) {
            addCriterion("FREIGHTLOT like", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotLike(String value) {
            addCriterion("FREIGHTLOT not like", value, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotIn(List<String> values) {
            addCriterion("FREIGHTLOT in", values, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotIn(List<String> values) {
            addCriterion("FREIGHTLOT not in", values, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotBetween(String value1, String value2) {
            addCriterion("FREIGHTLOT between", value1, value2, "freightlot");
            return (Criteria) this;
        }

        public Criteria andFreightlotNotBetween(String value1, String value2) {
            addCriterion("FREIGHTLOT not between", value1, value2, "freightlot");
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

        public Criteria andWarehouseIsNull() {
            addCriterion("WAREHOUSE is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNotNull() {
            addCriterion("WAREHOUSE is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEqualTo(String value) {
            addCriterion("WAREHOUSE =", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotEqualTo(String value) {
            addCriterion("WAREHOUSE <>", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThan(String value) {
            addCriterion("WAREHOUSE >", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE >=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThan(String value) {
            addCriterion("WAREHOUSE <", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE <=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLike(String value) {
            addCriterion("WAREHOUSE like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotLike(String value) {
            addCriterion("WAREHOUSE not like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseIn(List<String> values) {
            addCriterion("WAREHOUSE in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotIn(List<String> values) {
            addCriterion("WAREHOUSE not in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseBetween(String value1, String value2) {
            addCriterion("WAREHOUSE between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE not between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeIsNull() {
            addCriterion("MORTGAGE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeIsNotNull() {
            addCriterion("MORTGAGE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_CODE =", value, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeNotEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_CODE <>", value, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeGreaterThan(BigDecimal value) {
            addCriterion("MORTGAGE_CODE >", value, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_CODE >=", value, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeLessThan(BigDecimal value) {
            addCriterion("MORTGAGE_CODE <", value, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MORTGAGE_CODE <=", value, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeIn(List<BigDecimal> values) {
            addCriterion("MORTGAGE_CODE in", values, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeNotIn(List<BigDecimal> values) {
            addCriterion("MORTGAGE_CODE not in", values, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORTGAGE_CODE between", value1, value2, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andMortgageCodeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MORTGAGE_CODE not between", value1, value2, "mortgageCode");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIsNull() {
            addCriterion("WEIGHT_UNITS is null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIsNotNull() {
            addCriterion("WEIGHT_UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsEqualTo(String value) {
            addCriterion("WEIGHT_UNITS =", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotEqualTo(String value) {
            addCriterion("WEIGHT_UNITS <>", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThan(String value) {
            addCriterion("WEIGHT_UNITS >", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNITS >=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThan(String value) {
            addCriterion("WEIGHT_UNITS <", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLessThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNITS <=", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsLike(String value) {
            addCriterion("WEIGHT_UNITS like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotLike(String value) {
            addCriterion("WEIGHT_UNITS not like", value, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsIn(List<String> values) {
            addCriterion("WEIGHT_UNITS in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotIn(List<String> values) {
            addCriterion("WEIGHT_UNITS not in", values, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNITS between", value1, value2, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andWeightUnitsNotBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNITS not between", value1, value2, "weightUnits");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNull() {
            addCriterion("ENGINE_NO is null");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNotNull() {
            addCriterion("ENGINE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNoEqualTo(String value) {
            addCriterion("ENGINE_NO =", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotEqualTo(String value) {
            addCriterion("ENGINE_NO <>", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThan(String value) {
            addCriterion("ENGINE_NO >", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThanOrEqualTo(String value) {
            addCriterion("ENGINE_NO >=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThan(String value) {
            addCriterion("ENGINE_NO <", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThanOrEqualTo(String value) {
            addCriterion("ENGINE_NO <=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLike(String value) {
            addCriterion("ENGINE_NO like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotLike(String value) {
            addCriterion("ENGINE_NO not like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIn(List<String> values) {
            addCriterion("ENGINE_NO in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotIn(List<String> values) {
            addCriterion("ENGINE_NO not in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoBetween(String value1, String value2) {
            addCriterion("ENGINE_NO between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotBetween(String value1, String value2) {
            addCriterion("ENGINE_NO not between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoIsNull() {
            addCriterion("CHASSIS_NO is null");
            return (Criteria) this;
        }

        public Criteria andChassisNoIsNotNull() {
            addCriterion("CHASSIS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andChassisNoEqualTo(String value) {
            addCriterion("CHASSIS_NO =", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotEqualTo(String value) {
            addCriterion("CHASSIS_NO <>", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoGreaterThan(String value) {
            addCriterion("CHASSIS_NO >", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoGreaterThanOrEqualTo(String value) {
            addCriterion("CHASSIS_NO >=", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoLessThan(String value) {
            addCriterion("CHASSIS_NO <", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoLessThanOrEqualTo(String value) {
            addCriterion("CHASSIS_NO <=", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoLike(String value) {
            addCriterion("CHASSIS_NO like", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotLike(String value) {
            addCriterion("CHASSIS_NO not like", value, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoIn(List<String> values) {
            addCriterion("CHASSIS_NO in", values, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotIn(List<String> values) {
            addCriterion("CHASSIS_NO not in", values, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoBetween(String value1, String value2) {
            addCriterion("CHASSIS_NO between", value1, value2, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andChassisNoNotBetween(String value1, String value2) {
            addCriterion("CHASSIS_NO not between", value1, value2, "chassisNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoIsNull() {
            addCriterion("CERTIFICATION_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertificationNoIsNotNull() {
            addCriterion("CERTIFICATION_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationNoEqualTo(String value) {
            addCriterion("CERTIFICATION_NO =", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotEqualTo(String value) {
            addCriterion("CERTIFICATION_NO <>", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoGreaterThan(String value) {
            addCriterion("CERTIFICATION_NO >", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATION_NO >=", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoLessThan(String value) {
            addCriterion("CERTIFICATION_NO <", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATION_NO <=", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoLike(String value) {
            addCriterion("CERTIFICATION_NO like", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotLike(String value) {
            addCriterion("CERTIFICATION_NO not like", value, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoIn(List<String> values) {
            addCriterion("CERTIFICATION_NO in", values, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotIn(List<String> values) {
            addCriterion("CERTIFICATION_NO not in", values, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoBetween(String value1, String value2) {
            addCriterion("CERTIFICATION_NO between", value1, value2, "certificationNo");
            return (Criteria) this;
        }

        public Criteria andCertificationNoNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATION_NO not between", value1, value2, "certificationNo");
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

        public Criteria andFixMortgageNoIsNull() {
            addCriterion("FIX_MORTGAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoIsNotNull() {
            addCriterion("FIX_MORTGAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO =", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO <>", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoGreaterThan(String value) {
            addCriterion("FIX_MORTGAGE_NO >", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoGreaterThanOrEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO >=", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoLessThan(String value) {
            addCriterion("FIX_MORTGAGE_NO <", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoLessThanOrEqualTo(String value) {
            addCriterion("FIX_MORTGAGE_NO <=", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoLike(String value) {
            addCriterion("FIX_MORTGAGE_NO like", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotLike(String value) {
            addCriterion("FIX_MORTGAGE_NO not like", value, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoIn(List<String> values) {
            addCriterion("FIX_MORTGAGE_NO in", values, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotIn(List<String> values) {
            addCriterion("FIX_MORTGAGE_NO not in", values, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoBetween(String value1, String value2) {
            addCriterion("FIX_MORTGAGE_NO between", value1, value2, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andFixMortgageNoNotBetween(String value1, String value2) {
            addCriterion("FIX_MORTGAGE_NO not between", value1, value2, "fixMortgageNo");
            return (Criteria) this;
        }

        public Criteria andJoinBatchIsNull() {
            addCriterion("JOIN_BATCH is null");
            return (Criteria) this;
        }

        public Criteria andJoinBatchIsNotNull() {
            addCriterion("JOIN_BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andJoinBatchEqualTo(String value) {
            addCriterion("JOIN_BATCH =", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotEqualTo(String value) {
            addCriterion("JOIN_BATCH <>", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchGreaterThan(String value) {
            addCriterion("JOIN_BATCH >", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchGreaterThanOrEqualTo(String value) {
            addCriterion("JOIN_BATCH >=", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchLessThan(String value) {
            addCriterion("JOIN_BATCH <", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchLessThanOrEqualTo(String value) {
            addCriterion("JOIN_BATCH <=", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchLike(String value) {
            addCriterion("JOIN_BATCH like", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotLike(String value) {
            addCriterion("JOIN_BATCH not like", value, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchIn(List<String> values) {
            addCriterion("JOIN_BATCH in", values, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotIn(List<String> values) {
            addCriterion("JOIN_BATCH not in", values, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchBetween(String value1, String value2) {
            addCriterion("JOIN_BATCH between", value1, value2, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andJoinBatchNotBetween(String value1, String value2) {
            addCriterion("JOIN_BATCH not between", value1, value2, "joinBatch");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagIsNull() {
            addCriterion("UP_DOWN_MONEY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagIsNotNull() {
            addCriterion("UP_DOWN_MONEY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagEqualTo(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG =", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagNotEqualTo(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG <>", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagGreaterThan(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG >", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG >=", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagLessThan(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG <", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagLessThanOrEqualTo(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG <=", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagLike(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG like", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagNotLike(String value) {
            addCriterion("UP_DOWN_MONEY_FLAG not like", value, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagIn(List<String> values) {
            addCriterion("UP_DOWN_MONEY_FLAG in", values, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagNotIn(List<String> values) {
            addCriterion("UP_DOWN_MONEY_FLAG not in", values, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagBetween(String value1, String value2) {
            addCriterion("UP_DOWN_MONEY_FLAG between", value1, value2, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andUpDownMoneyFlagNotBetween(String value1, String value2) {
            addCriterion("UP_DOWN_MONEY_FLAG not between", value1, value2, "upDownMoneyFlag");
            return (Criteria) this;
        }

        public Criteria andTradeContnoIsNull() {
            addCriterion("TRADE_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andTradeContnoIsNotNull() {
            addCriterion("TRADE_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andTradeContnoEqualTo(String value) {
            addCriterion("TRADE_CONTNO =", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotEqualTo(String value) {
            addCriterion("TRADE_CONTNO <>", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoGreaterThan(String value) {
            addCriterion("TRADE_CONTNO >", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_CONTNO >=", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoLessThan(String value) {
            addCriterion("TRADE_CONTNO <", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoLessThanOrEqualTo(String value) {
            addCriterion("TRADE_CONTNO <=", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoLike(String value) {
            addCriterion("TRADE_CONTNO like", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotLike(String value) {
            addCriterion("TRADE_CONTNO not like", value, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoIn(List<String> values) {
            addCriterion("TRADE_CONTNO in", values, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotIn(List<String> values) {
            addCriterion("TRADE_CONTNO not in", values, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoBetween(String value1, String value2) {
            addCriterion("TRADE_CONTNO between", value1, value2, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andTradeContnoNotBetween(String value1, String value2) {
            addCriterion("TRADE_CONTNO not between", value1, value2, "tradeContno");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIsNull() {
            addCriterion("OUT_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIsNotNull() {
            addCriterion("OUT_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andOutQuantityEqualTo(BigDecimal value) {
            addCriterion("OUT_QUANTITY =", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotEqualTo(BigDecimal value) {
            addCriterion("OUT_QUANTITY <>", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityGreaterThan(BigDecimal value) {
            addCriterion("OUT_QUANTITY >", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OUT_QUANTITY >=", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityLessThan(BigDecimal value) {
            addCriterion("OUT_QUANTITY <", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OUT_QUANTITY <=", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIn(List<BigDecimal> values) {
            addCriterion("OUT_QUANTITY in", values, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotIn(List<BigDecimal> values) {
            addCriterion("OUT_QUANTITY not in", values, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OUT_QUANTITY between", value1, value2, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OUT_QUANTITY not between", value1, value2, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionIsNull() {
            addCriterion("IS_SL_EXIBITION is null");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionIsNotNull() {
            addCriterion("IS_SL_EXIBITION is not null");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionEqualTo(String value) {
            addCriterion("IS_SL_EXIBITION =", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionNotEqualTo(String value) {
            addCriterion("IS_SL_EXIBITION <>", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionGreaterThan(String value) {
            addCriterion("IS_SL_EXIBITION >", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SL_EXIBITION >=", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionLessThan(String value) {
            addCriterion("IS_SL_EXIBITION <", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionLessThanOrEqualTo(String value) {
            addCriterion("IS_SL_EXIBITION <=", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionLike(String value) {
            addCriterion("IS_SL_EXIBITION like", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionNotLike(String value) {
            addCriterion("IS_SL_EXIBITION not like", value, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionIn(List<String> values) {
            addCriterion("IS_SL_EXIBITION in", values, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionNotIn(List<String> values) {
            addCriterion("IS_SL_EXIBITION not in", values, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionBetween(String value1, String value2) {
            addCriterion("IS_SL_EXIBITION between", value1, value2, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andIsSlExibitionNotBetween(String value1, String value2) {
            addCriterion("IS_SL_EXIBITION not between", value1, value2, "isSlExibition");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNull() {
            addCriterion("MANUFACTURE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNotNull() {
            addCriterion("MANUFACTURE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE =", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE <>", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThan(String value) {
            addCriterion("MANUFACTURE_DATE >", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThanOrEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE >=", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThan(String value) {
            addCriterion("MANUFACTURE_DATE <", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThanOrEqualTo(String value) {
            addCriterion("MANUFACTURE_DATE <=", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLike(String value) {
            addCriterion("MANUFACTURE_DATE like", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotLike(String value) {
            addCriterion("MANUFACTURE_DATE not like", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIn(List<String> values) {
            addCriterion("MANUFACTURE_DATE in", values, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotIn(List<String> values) {
            addCriterion("MANUFACTURE_DATE not in", values, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateBetween(String value1, String value2) {
            addCriterion("MANUFACTURE_DATE between", value1, value2, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotBetween(String value1, String value2) {
            addCriterion("MANUFACTURE_DATE not between", value1, value2, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIsNull() {
            addCriterion("DOCUMENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIsNotNull() {
            addCriterion("DOCUMENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoEqualTo(String value) {
            addCriterion("DOCUMENT_NO =", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotEqualTo(String value) {
            addCriterion("DOCUMENT_NO <>", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThan(String value) {
            addCriterion("DOCUMENT_NO >", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThanOrEqualTo(String value) {
            addCriterion("DOCUMENT_NO >=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThan(String value) {
            addCriterion("DOCUMENT_NO <", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThanOrEqualTo(String value) {
            addCriterion("DOCUMENT_NO <=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLike(String value) {
            addCriterion("DOCUMENT_NO like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotLike(String value) {
            addCriterion("DOCUMENT_NO not like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIn(List<String> values) {
            addCriterion("DOCUMENT_NO in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotIn(List<String> values) {
            addCriterion("DOCUMENT_NO not in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoBetween(String value1, String value2) {
            addCriterion("DOCUMENT_NO between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotBetween(String value1, String value2) {
            addCriterion("DOCUMENT_NO not between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeIsNull() {
            addCriterion("MONI_WAREHOUSE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeIsNotNull() {
            addCriterion("MONI_WAREHOUSE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE =", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE <>", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeGreaterThan(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE >", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE >=", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeLessThan(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE <", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeLessThanOrEqualTo(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE <=", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeLike(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE like", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotLike(String value) {
            addCriterion("MONI_WAREHOUSE_TYPE not like", value, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeIn(List<String> values) {
            addCriterion("MONI_WAREHOUSE_TYPE in", values, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotIn(List<String> values) {
            addCriterion("MONI_WAREHOUSE_TYPE not in", values, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeBetween(String value1, String value2) {
            addCriterion("MONI_WAREHOUSE_TYPE between", value1, value2, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andMoniWarehouseTypeNotBetween(String value1, String value2) {
            addCriterion("MONI_WAREHOUSE_TYPE not between", value1, value2, "moniWarehouseType");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumIsNull() {
            addCriterion("DELIVERY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumIsNotNull() {
            addCriterion("DELIVERY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumEqualTo(String value) {
            addCriterion("DELIVERY_NUM =", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumNotEqualTo(String value) {
            addCriterion("DELIVERY_NUM <>", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumGreaterThan(String value) {
            addCriterion("DELIVERY_NUM >", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_NUM >=", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumLessThan(String value) {
            addCriterion("DELIVERY_NUM <", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_NUM <=", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumLike(String value) {
            addCriterion("DELIVERY_NUM like", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumNotLike(String value) {
            addCriterion("DELIVERY_NUM not like", value, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumIn(List<String> values) {
            addCriterion("DELIVERY_NUM in", values, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumNotIn(List<String> values) {
            addCriterion("DELIVERY_NUM not in", values, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumBetween(String value1, String value2) {
            addCriterion("DELIVERY_NUM between", value1, value2, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryNumNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_NUM not between", value1, value2, "deliveryNum");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andPackagewIsNull() {
            addCriterion("PACKAGEW is null");
            return (Criteria) this;
        }

        public Criteria andPackagewIsNotNull() {
            addCriterion("PACKAGEW is not null");
            return (Criteria) this;
        }

        public Criteria andPackagewEqualTo(String value) {
            addCriterion("PACKAGEW =", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotEqualTo(String value) {
            addCriterion("PACKAGEW <>", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewGreaterThan(String value) {
            addCriterion("PACKAGEW >", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewGreaterThanOrEqualTo(String value) {
            addCriterion("PACKAGEW >=", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewLessThan(String value) {
            addCriterion("PACKAGEW <", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewLessThanOrEqualTo(String value) {
            addCriterion("PACKAGEW <=", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewLike(String value) {
            addCriterion("PACKAGEW like", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotLike(String value) {
            addCriterion("PACKAGEW not like", value, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewIn(List<String> values) {
            addCriterion("PACKAGEW in", values, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotIn(List<String> values) {
            addCriterion("PACKAGEW not in", values, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewBetween(String value1, String value2) {
            addCriterion("PACKAGEW between", value1, value2, "packagew");
            return (Criteria) this;
        }

        public Criteria andPackagewNotBetween(String value1, String value2) {
            addCriterion("PACKAGEW not between", value1, value2, "packagew");
            return (Criteria) this;
        }

        public Criteria andAddQuantityIsNull() {
            addCriterion("ADD_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andAddQuantityIsNotNull() {
            addCriterion("ADD_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andAddQuantityEqualTo(BigDecimal value) {
            addCriterion("ADD_QUANTITY =", value, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityNotEqualTo(BigDecimal value) {
            addCriterion("ADD_QUANTITY <>", value, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityGreaterThan(BigDecimal value) {
            addCriterion("ADD_QUANTITY >", value, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_QUANTITY >=", value, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityLessThan(BigDecimal value) {
            addCriterion("ADD_QUANTITY <", value, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ADD_QUANTITY <=", value, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityIn(List<BigDecimal> values) {
            addCriterion("ADD_QUANTITY in", values, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityNotIn(List<BigDecimal> values) {
            addCriterion("ADD_QUANTITY not in", values, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_QUANTITY between", value1, value2, "addQuantity");
            return (Criteria) this;
        }

        public Criteria andAddQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADD_QUANTITY not between", value1, value2, "addQuantity");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}