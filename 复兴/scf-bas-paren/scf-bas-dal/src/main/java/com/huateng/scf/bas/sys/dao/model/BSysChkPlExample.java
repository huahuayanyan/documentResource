package com.huateng.scf.bas.sys.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysChkPlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysChkPlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysChkPlExample(BSysChkPlExample example) {
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

        public Criteria andChkPlIdIsNull() {
            addCriterion("CHK_PL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChkPlIdIsNotNull() {
            addCriterion("CHK_PL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChkPlIdEqualTo(String value) {
            addCriterion("CHK_PL_ID =", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdNotEqualTo(String value) {
            addCriterion("CHK_PL_ID <>", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdGreaterThan(String value) {
            addCriterion("CHK_PL_ID >", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_PL_ID >=", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdLessThan(String value) {
            addCriterion("CHK_PL_ID <", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdLessThanOrEqualTo(String value) {
            addCriterion("CHK_PL_ID <=", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdLike(String value) {
            addCriterion("CHK_PL_ID like", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdNotLike(String value) {
            addCriterion("CHK_PL_ID not like", value, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdIn(List<String> values) {
            addCriterion("CHK_PL_ID in", values, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdNotIn(List<String> values) {
            addCriterion("CHK_PL_ID not in", values, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdBetween(String value1, String value2) {
            addCriterion("CHK_PL_ID between", value1, value2, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkPlIdNotBetween(String value1, String value2) {
            addCriterion("CHK_PL_ID not between", value1, value2, "chkPlId");
            return (Criteria) this;
        }

        public Criteria andChkItIdIsNull() {
            addCriterion("CHK_IT_ID is null");
            return (Criteria) this;
        }

        public Criteria andChkItIdIsNotNull() {
            addCriterion("CHK_IT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChkItIdEqualTo(String value) {
            addCriterion("CHK_IT_ID =", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotEqualTo(String value) {
            addCriterion("CHK_IT_ID <>", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdGreaterThan(String value) {
            addCriterion("CHK_IT_ID >", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_IT_ID >=", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdLessThan(String value) {
            addCriterion("CHK_IT_ID <", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdLessThanOrEqualTo(String value) {
            addCriterion("CHK_IT_ID <=", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdLike(String value) {
            addCriterion("CHK_IT_ID like", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotLike(String value) {
            addCriterion("CHK_IT_ID not like", value, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdIn(List<String> values) {
            addCriterion("CHK_IT_ID in", values, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotIn(List<String> values) {
            addCriterion("CHK_IT_ID not in", values, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdBetween(String value1, String value2) {
            addCriterion("CHK_IT_ID between", value1, value2, "chkItId");
            return (Criteria) this;
        }

        public Criteria andChkItIdNotBetween(String value1, String value2) {
            addCriterion("CHK_IT_ID not between", value1, value2, "chkItId");
            return (Criteria) this;
        }

        public Criteria andNmIsNull() {
            addCriterion("NM is null");
            return (Criteria) this;
        }

        public Criteria andNmIsNotNull() {
            addCriterion("NM is not null");
            return (Criteria) this;
        }

        public Criteria andNmEqualTo(String value) {
            addCriterion("NM =", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotEqualTo(String value) {
            addCriterion("NM <>", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmGreaterThan(String value) {
            addCriterion("NM >", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmGreaterThanOrEqualTo(String value) {
            addCriterion("NM >=", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmLessThan(String value) {
            addCriterion("NM <", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmLessThanOrEqualTo(String value) {
            addCriterion("NM <=", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmLike(String value) {
            addCriterion("NM like", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotLike(String value) {
            addCriterion("NM not like", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmIn(List<String> values) {
            addCriterion("NM in", values, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotIn(List<String> values) {
            addCriterion("NM not in", values, "nm");
            return (Criteria) this;
        }

        public Criteria andNmBetween(String value1, String value2) {
            addCriterion("NM between", value1, value2, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotBetween(String value1, String value2) {
            addCriterion("NM not between", value1, value2, "nm");
            return (Criteria) this;
        }

        public Criteria andMdlIdIsNull() {
            addCriterion("MDL_ID is null");
            return (Criteria) this;
        }

        public Criteria andMdlIdIsNotNull() {
            addCriterion("MDL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMdlIdEqualTo(String value) {
            addCriterion("MDL_ID =", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotEqualTo(String value) {
            addCriterion("MDL_ID <>", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThan(String value) {
            addCriterion("MDL_ID >", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThanOrEqualTo(String value) {
            addCriterion("MDL_ID >=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThan(String value) {
            addCriterion("MDL_ID <", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThanOrEqualTo(String value) {
            addCriterion("MDL_ID <=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLike(String value) {
            addCriterion("MDL_ID like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotLike(String value) {
            addCriterion("MDL_ID not like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdIn(List<String> values) {
            addCriterion("MDL_ID in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotIn(List<String> values) {
            addCriterion("MDL_ID not in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdBetween(String value1, String value2) {
            addCriterion("MDL_ID between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotBetween(String value1, String value2) {
            addCriterion("MDL_ID not between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andOrdIsNull() {
            addCriterion("ORD is null");
            return (Criteria) this;
        }

        public Criteria andOrdIsNotNull() {
            addCriterion("ORD is not null");
            return (Criteria) this;
        }

        public Criteria andOrdEqualTo(BigDecimal value) {
            addCriterion("ORD =", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotEqualTo(BigDecimal value) {
            addCriterion("ORD <>", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdGreaterThan(BigDecimal value) {
            addCriterion("ORD >", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORD >=", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdLessThan(BigDecimal value) {
            addCriterion("ORD <", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORD <=", value, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdIn(List<BigDecimal> values) {
            addCriterion("ORD in", values, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotIn(List<BigDecimal> values) {
            addCriterion("ORD not in", values, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORD between", value1, value2, "ord");
            return (Criteria) this;
        }

        public Criteria andOrdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORD not between", value1, value2, "ord");
            return (Criteria) this;
        }

        public Criteria andDealIsNull() {
            addCriterion("DEAL is null");
            return (Criteria) this;
        }

        public Criteria andDealIsNotNull() {
            addCriterion("DEAL is not null");
            return (Criteria) this;
        }

        public Criteria andDealEqualTo(String value) {
            addCriterion("DEAL =", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealNotEqualTo(String value) {
            addCriterion("DEAL <>", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealGreaterThan(String value) {
            addCriterion("DEAL >", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL >=", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealLessThan(String value) {
            addCriterion("DEAL <", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealLessThanOrEqualTo(String value) {
            addCriterion("DEAL <=", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealLike(String value) {
            addCriterion("DEAL like", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealNotLike(String value) {
            addCriterion("DEAL not like", value, "deal");
            return (Criteria) this;
        }

        public Criteria andDealIn(List<String> values) {
            addCriterion("DEAL in", values, "deal");
            return (Criteria) this;
        }

        public Criteria andDealNotIn(List<String> values) {
            addCriterion("DEAL not in", values, "deal");
            return (Criteria) this;
        }

        public Criteria andDealBetween(String value1, String value2) {
            addCriterion("DEAL between", value1, value2, "deal");
            return (Criteria) this;
        }

        public Criteria andDealNotBetween(String value1, String value2) {
            addCriterion("DEAL not between", value1, value2, "deal");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}