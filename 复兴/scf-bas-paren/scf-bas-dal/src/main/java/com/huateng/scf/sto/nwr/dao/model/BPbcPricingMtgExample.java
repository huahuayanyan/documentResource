package com.huateng.scf.sto.nwr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcPricingMtgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcPricingMtgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcPricingMtgExample(BPbcPricingMtgExample example) {
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

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
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

        public Criteria andContPriceIsNull() {
            addCriterion("CONT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andContPriceIsNotNull() {
            addCriterion("CONT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andContPriceEqualTo(BigDecimal value) {
            addCriterion("CONT_PRICE =", value, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceNotEqualTo(BigDecimal value) {
            addCriterion("CONT_PRICE <>", value, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceGreaterThan(BigDecimal value) {
            addCriterion("CONT_PRICE >", value, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_PRICE >=", value, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceLessThan(BigDecimal value) {
            addCriterion("CONT_PRICE <", value, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONT_PRICE <=", value, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceIn(List<BigDecimal> values) {
            addCriterion("CONT_PRICE in", values, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceNotIn(List<BigDecimal> values) {
            addCriterion("CONT_PRICE not in", values, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_PRICE between", value1, value2, "contPrice");
            return (Criteria) this;
        }

        public Criteria andContPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONT_PRICE not between", value1, value2, "contPrice");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingIsNull() {
            addCriterion("APPROVE_ACCORDING is null");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingIsNotNull() {
            addCriterion("APPROVE_ACCORDING is not null");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingEqualTo(String value) {
            addCriterion("APPROVE_ACCORDING =", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingNotEqualTo(String value) {
            addCriterion("APPROVE_ACCORDING <>", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingGreaterThan(String value) {
            addCriterion("APPROVE_ACCORDING >", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_ACCORDING >=", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingLessThan(String value) {
            addCriterion("APPROVE_ACCORDING <", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_ACCORDING <=", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingLike(String value) {
            addCriterion("APPROVE_ACCORDING like", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingNotLike(String value) {
            addCriterion("APPROVE_ACCORDING not like", value, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingIn(List<String> values) {
            addCriterion("APPROVE_ACCORDING in", values, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingNotIn(List<String> values) {
            addCriterion("APPROVE_ACCORDING not in", values, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingBetween(String value1, String value2) {
            addCriterion("APPROVE_ACCORDING between", value1, value2, "approveAccording");
            return (Criteria) this;
        }

        public Criteria andApproveAccordingNotBetween(String value1, String value2) {
            addCriterion("APPROVE_ACCORDING not between", value1, value2, "approveAccording");
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

        public Criteria andThirdPartyPriceIsNull() {
            addCriterion("THIRD_PARTY_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceIsNotNull() {
            addCriterion("THIRD_PARTY_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceEqualTo(BigDecimal value) {
            addCriterion("THIRD_PARTY_PRICE =", value, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceNotEqualTo(BigDecimal value) {
            addCriterion("THIRD_PARTY_PRICE <>", value, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceGreaterThan(BigDecimal value) {
            addCriterion("THIRD_PARTY_PRICE >", value, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIRD_PARTY_PRICE >=", value, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceLessThan(BigDecimal value) {
            addCriterion("THIRD_PARTY_PRICE <", value, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIRD_PARTY_PRICE <=", value, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceIn(List<BigDecimal> values) {
            addCriterion("THIRD_PARTY_PRICE in", values, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceNotIn(List<BigDecimal> values) {
            addCriterion("THIRD_PARTY_PRICE not in", values, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIRD_PARTY_PRICE between", value1, value2, "thirdPartyPrice");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIRD_PARTY_PRICE not between", value1, value2, "thirdPartyPrice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}