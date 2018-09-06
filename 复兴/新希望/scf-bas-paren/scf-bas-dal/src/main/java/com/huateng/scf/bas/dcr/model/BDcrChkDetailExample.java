package com.huateng.scf.bas.dcr.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDcrChkDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDcrChkDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BDcrChkDetailExample(BDcrChkDetailExample example) {
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

        public Criteria andChkDetailIdIsNull() {
            addCriterion("CHK_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdIsNotNull() {
            addCriterion("CHK_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdEqualTo(String value) {
            addCriterion("CHK_DETAIL_ID =", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdNotEqualTo(String value) {
            addCriterion("CHK_DETAIL_ID <>", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdGreaterThan(String value) {
            addCriterion("CHK_DETAIL_ID >", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_DETAIL_ID >=", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdLessThan(String value) {
            addCriterion("CHK_DETAIL_ID <", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdLessThanOrEqualTo(String value) {
            addCriterion("CHK_DETAIL_ID <=", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdLike(String value) {
            addCriterion("CHK_DETAIL_ID like", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdNotLike(String value) {
            addCriterion("CHK_DETAIL_ID not like", value, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdIn(List<String> values) {
            addCriterion("CHK_DETAIL_ID in", values, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdNotIn(List<String> values) {
            addCriterion("CHK_DETAIL_ID not in", values, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdBetween(String value1, String value2) {
            addCriterion("CHK_DETAIL_ID between", value1, value2, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDetailIdNotBetween(String value1, String value2) {
            addCriterion("CHK_DETAIL_ID not between", value1, value2, "chkDetailId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdIsNull() {
            addCriterion("CHK_DIR_ID is null");
            return (Criteria) this;
        }

        public Criteria andChkDirIdIsNotNull() {
            addCriterion("CHK_DIR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChkDirIdEqualTo(String value) {
            addCriterion("CHK_DIR_ID =", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdNotEqualTo(String value) {
            addCriterion("CHK_DIR_ID <>", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdGreaterThan(String value) {
            addCriterion("CHK_DIR_ID >", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_DIR_ID >=", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdLessThan(String value) {
            addCriterion("CHK_DIR_ID <", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdLessThanOrEqualTo(String value) {
            addCriterion("CHK_DIR_ID <=", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdLike(String value) {
            addCriterion("CHK_DIR_ID like", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdNotLike(String value) {
            addCriterion("CHK_DIR_ID not like", value, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdIn(List<String> values) {
            addCriterion("CHK_DIR_ID in", values, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdNotIn(List<String> values) {
            addCriterion("CHK_DIR_ID not in", values, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdBetween(String value1, String value2) {
            addCriterion("CHK_DIR_ID between", value1, value2, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andChkDirIdNotBetween(String value1, String value2) {
            addCriterion("CHK_DIR_ID not between", value1, value2, "chkDirId");
            return (Criteria) this;
        }

        public Criteria andRltVlIsNull() {
            addCriterion("RLT_VL is null");
            return (Criteria) this;
        }

        public Criteria andRltVlIsNotNull() {
            addCriterion("RLT_VL is not null");
            return (Criteria) this;
        }

        public Criteria andRltVlEqualTo(String value) {
            addCriterion("RLT_VL =", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlNotEqualTo(String value) {
            addCriterion("RLT_VL <>", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlGreaterThan(String value) {
            addCriterion("RLT_VL >", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_VL >=", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlLessThan(String value) {
            addCriterion("RLT_VL <", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlLessThanOrEqualTo(String value) {
            addCriterion("RLT_VL <=", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlLike(String value) {
            addCriterion("RLT_VL like", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlNotLike(String value) {
            addCriterion("RLT_VL not like", value, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlIn(List<String> values) {
            addCriterion("RLT_VL in", values, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlNotIn(List<String> values) {
            addCriterion("RLT_VL not in", values, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlBetween(String value1, String value2) {
            addCriterion("RLT_VL between", value1, value2, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltVlNotBetween(String value1, String value2) {
            addCriterion("RLT_VL not between", value1, value2, "rltVl");
            return (Criteria) this;
        }

        public Criteria andRltNmIsNull() {
            addCriterion("RLT_NM is null");
            return (Criteria) this;
        }

        public Criteria andRltNmIsNotNull() {
            addCriterion("RLT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andRltNmEqualTo(String value) {
            addCriterion("RLT_NM =", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmNotEqualTo(String value) {
            addCriterion("RLT_NM <>", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmGreaterThan(String value) {
            addCriterion("RLT_NM >", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_NM >=", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmLessThan(String value) {
            addCriterion("RLT_NM <", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmLessThanOrEqualTo(String value) {
            addCriterion("RLT_NM <=", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmLike(String value) {
            addCriterion("RLT_NM like", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmNotLike(String value) {
            addCriterion("RLT_NM not like", value, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmIn(List<String> values) {
            addCriterion("RLT_NM in", values, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmNotIn(List<String> values) {
            addCriterion("RLT_NM not in", values, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmBetween(String value1, String value2) {
            addCriterion("RLT_NM between", value1, value2, "rltNm");
            return (Criteria) this;
        }

        public Criteria andRltNmNotBetween(String value1, String value2) {
            addCriterion("RLT_NM not between", value1, value2, "rltNm");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}