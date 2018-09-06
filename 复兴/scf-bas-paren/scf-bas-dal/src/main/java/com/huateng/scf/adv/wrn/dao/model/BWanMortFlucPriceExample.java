package com.huateng.scf.adv.wrn.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BWanMortFlucPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWanMortFlucPriceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BWanMortFlucPriceExample(BWanMortFlucPriceExample example) {
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

        public Criteria andCnameIsNull() {
            addCriterion("CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("CNAME =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("CNAME <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("CNAME >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("CNAME <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("CNAME <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("CNAME like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("CNAME not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("CNAME in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("CNAME not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("CNAME between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("CNAME not between", value1, value2, "cname");
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

        public Criteria andPriceDateIsNull() {
            addCriterion("PRICE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPriceDateIsNotNull() {
            addCriterion("PRICE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDateEqualTo(String value) {
            addCriterion("PRICE_DATE =", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotEqualTo(String value) {
            addCriterion("PRICE_DATE <>", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateGreaterThan(String value) {
            addCriterion("PRICE_DATE >", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_DATE >=", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateLessThan(String value) {
            addCriterion("PRICE_DATE <", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateLessThanOrEqualTo(String value) {
            addCriterion("PRICE_DATE <=", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateLike(String value) {
            addCriterion("PRICE_DATE like", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotLike(String value) {
            addCriterion("PRICE_DATE not like", value, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateIn(List<String> values) {
            addCriterion("PRICE_DATE in", values, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotIn(List<String> values) {
            addCriterion("PRICE_DATE not in", values, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateBetween(String value1, String value2) {
            addCriterion("PRICE_DATE between", value1, value2, "priceDate");
            return (Criteria) this;
        }

        public Criteria andPriceDateNotBetween(String value1, String value2) {
            addCriterion("PRICE_DATE not between", value1, value2, "priceDate");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceIsNull() {
            addCriterion("ORIGINAL_MARKET_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceIsNotNull() {
            addCriterion("ORIGINAL_MARKET_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_MARKET_PRICE =", value, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_MARKET_PRICE <>", value, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("ORIGINAL_MARKET_PRICE >", value, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_MARKET_PRICE >=", value, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceLessThan(BigDecimal value) {
            addCriterion("ORIGINAL_MARKET_PRICE <", value, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_MARKET_PRICE <=", value, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_MARKET_PRICE in", values, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_MARKET_PRICE not in", values, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_MARKET_PRICE between", value1, value2, "originalMarketPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_MARKET_PRICE not between", value1, value2, "originalMarketPrice");
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

        public Criteria andFluctuationIsNull() {
            addCriterion("FLUCTUATION is null");
            return (Criteria) this;
        }

        public Criteria andFluctuationIsNotNull() {
            addCriterion("FLUCTUATION is not null");
            return (Criteria) this;
        }

        public Criteria andFluctuationEqualTo(BigDecimal value) {
            addCriterion("FLUCTUATION =", value, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationNotEqualTo(BigDecimal value) {
            addCriterion("FLUCTUATION <>", value, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationGreaterThan(BigDecimal value) {
            addCriterion("FLUCTUATION >", value, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLUCTUATION >=", value, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationLessThan(BigDecimal value) {
            addCriterion("FLUCTUATION <", value, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLUCTUATION <=", value, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationIn(List<BigDecimal> values) {
            addCriterion("FLUCTUATION in", values, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationNotIn(List<BigDecimal> values) {
            addCriterion("FLUCTUATION not in", values, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLUCTUATION between", value1, value2, "fluctuation");
            return (Criteria) this;
        }

        public Criteria andFluctuationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLUCTUATION not between", value1, value2, "fluctuation");
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

        public Criteria andSlaveContcodeIsNull() {
            addCriterion("SLAVE_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeIsNotNull() {
            addCriterion("SLAVE_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE =", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE <>", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeGreaterThan(String value) {
            addCriterion("SLAVE_CONTCODE >", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE >=", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeLessThan(String value) {
            addCriterion("SLAVE_CONTCODE <", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeLessThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTCODE <=", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeLike(String value) {
            addCriterion("SLAVE_CONTCODE like", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotLike(String value) {
            addCriterion("SLAVE_CONTCODE not like", value, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeIn(List<String> values) {
            addCriterion("SLAVE_CONTCODE in", values, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotIn(List<String> values) {
            addCriterion("SLAVE_CONTCODE not in", values, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTCODE between", value1, value2, "slaveContcode");
            return (Criteria) this;
        }

        public Criteria andSlaveContcodeNotBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTCODE not between", value1, value2, "slaveContcode");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}