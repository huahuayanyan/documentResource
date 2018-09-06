package com.huateng.scf.bas.dcr.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDcrChkDirExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDcrChkDirExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BDcrChkDirExample(BDcrChkDirExample example) {
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

        public Criteria andLinIdIsNull() {
            addCriterion("LIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andLinIdIsNotNull() {
            addCriterion("LIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLinIdEqualTo(String value) {
            addCriterion("LIN_ID =", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotEqualTo(String value) {
            addCriterion("LIN_ID <>", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdGreaterThan(String value) {
            addCriterion("LIN_ID >", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdGreaterThanOrEqualTo(String value) {
            addCriterion("LIN_ID >=", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdLessThan(String value) {
            addCriterion("LIN_ID <", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdLessThanOrEqualTo(String value) {
            addCriterion("LIN_ID <=", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdLike(String value) {
            addCriterion("LIN_ID like", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotLike(String value) {
            addCriterion("LIN_ID not like", value, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdIn(List<String> values) {
            addCriterion("LIN_ID in", values, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotIn(List<String> values) {
            addCriterion("LIN_ID not in", values, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdBetween(String value1, String value2) {
            addCriterion("LIN_ID between", value1, value2, "linId");
            return (Criteria) this;
        }

        public Criteria andLinIdNotBetween(String value1, String value2) {
            addCriterion("LIN_ID not between", value1, value2, "linId");
            return (Criteria) this;
        }

        public Criteria andTypIdIsNull() {
            addCriterion("TYP_ID is null");
            return (Criteria) this;
        }

        public Criteria andTypIdIsNotNull() {
            addCriterion("TYP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTypIdEqualTo(String value) {
            addCriterion("TYP_ID =", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdNotEqualTo(String value) {
            addCriterion("TYP_ID <>", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdGreaterThan(String value) {
            addCriterion("TYP_ID >", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdGreaterThanOrEqualTo(String value) {
            addCriterion("TYP_ID >=", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdLessThan(String value) {
            addCriterion("TYP_ID <", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdLessThanOrEqualTo(String value) {
            addCriterion("TYP_ID <=", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdLike(String value) {
            addCriterion("TYP_ID like", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdNotLike(String value) {
            addCriterion("TYP_ID not like", value, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdIn(List<String> values) {
            addCriterion("TYP_ID in", values, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdNotIn(List<String> values) {
            addCriterion("TYP_ID not in", values, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdBetween(String value1, String value2) {
            addCriterion("TYP_ID between", value1, value2, "typId");
            return (Criteria) this;
        }

        public Criteria andTypIdNotBetween(String value1, String value2) {
            addCriterion("TYP_ID not between", value1, value2, "typId");
            return (Criteria) this;
        }

        public Criteria andRltTypIsNull() {
            addCriterion("RLT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRltTypIsNotNull() {
            addCriterion("RLT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRltTypEqualTo(String value) {
            addCriterion("RLT_TYP =", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotEqualTo(String value) {
            addCriterion("RLT_TYP <>", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypGreaterThan(String value) {
            addCriterion("RLT_TYP >", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypGreaterThanOrEqualTo(String value) {
            addCriterion("RLT_TYP >=", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLessThan(String value) {
            addCriterion("RLT_TYP <", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLessThanOrEqualTo(String value) {
            addCriterion("RLT_TYP <=", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypLike(String value) {
            addCriterion("RLT_TYP like", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotLike(String value) {
            addCriterion("RLT_TYP not like", value, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypIn(List<String> values) {
            addCriterion("RLT_TYP in", values, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotIn(List<String> values) {
            addCriterion("RLT_TYP not in", values, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypBetween(String value1, String value2) {
            addCriterion("RLT_TYP between", value1, value2, "rltTyp");
            return (Criteria) this;
        }

        public Criteria andRltTypNotBetween(String value1, String value2) {
            addCriterion("RLT_TYP not between", value1, value2, "rltTyp");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}