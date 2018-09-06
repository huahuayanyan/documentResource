package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RSysAcctBctlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RSysAcctBctlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RSysAcctBctlExample(RSysAcctBctlExample example) {
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

        public Criteria andBrnoIsNull() {
            addCriterion("BRNO is null");
            return (Criteria) this;
        }

        public Criteria andBrnoIsNotNull() {
            addCriterion("BRNO is not null");
            return (Criteria) this;
        }

        public Criteria andBrnoEqualTo(String value) {
            addCriterion("BRNO =", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoNotEqualTo(String value) {
            addCriterion("BRNO <>", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoGreaterThan(String value) {
            addCriterion("BRNO >", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoGreaterThanOrEqualTo(String value) {
            addCriterion("BRNO >=", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoLessThan(String value) {
            addCriterion("BRNO <", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoLessThanOrEqualTo(String value) {
            addCriterion("BRNO <=", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoLike(String value) {
            addCriterion("BRNO like", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoNotLike(String value) {
            addCriterion("BRNO not like", value, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoIn(List<String> values) {
            addCriterion("BRNO in", values, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoNotIn(List<String> values) {
            addCriterion("BRNO not in", values, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoBetween(String value1, String value2) {
            addCriterion("BRNO between", value1, value2, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnoNotBetween(String value1, String value2) {
            addCriterion("BRNO not between", value1, value2, "brno");
            return (Criteria) this;
        }

        public Criteria andBrnameIsNull() {
            addCriterion("BRNAME is null");
            return (Criteria) this;
        }

        public Criteria andBrnameIsNotNull() {
            addCriterion("BRNAME is not null");
            return (Criteria) this;
        }

        public Criteria andBrnameEqualTo(String value) {
            addCriterion("BRNAME =", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotEqualTo(String value) {
            addCriterion("BRNAME <>", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameGreaterThan(String value) {
            addCriterion("BRNAME >", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameGreaterThanOrEqualTo(String value) {
            addCriterion("BRNAME >=", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameLessThan(String value) {
            addCriterion("BRNAME <", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameLessThanOrEqualTo(String value) {
            addCriterion("BRNAME <=", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameLike(String value) {
            addCriterion("BRNAME like", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotLike(String value) {
            addCriterion("BRNAME not like", value, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameIn(List<String> values) {
            addCriterion("BRNAME in", values, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotIn(List<String> values) {
            addCriterion("BRNAME not in", values, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameBetween(String value1, String value2) {
            addCriterion("BRNAME between", value1, value2, "brname");
            return (Criteria) this;
        }

        public Criteria andBrnameNotBetween(String value1, String value2) {
            addCriterion("BRNAME not between", value1, value2, "brname");
            return (Criteria) this;
        }

        public Criteria andBrclassIsNull() {
            addCriterion("BRCLASS is null");
            return (Criteria) this;
        }

        public Criteria andBrclassIsNotNull() {
            addCriterion("BRCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andBrclassEqualTo(String value) {
            addCriterion("BRCLASS =", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotEqualTo(String value) {
            addCriterion("BRCLASS <>", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassGreaterThan(String value) {
            addCriterion("BRCLASS >", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassGreaterThanOrEqualTo(String value) {
            addCriterion("BRCLASS >=", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassLessThan(String value) {
            addCriterion("BRCLASS <", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassLessThanOrEqualTo(String value) {
            addCriterion("BRCLASS <=", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassLike(String value) {
            addCriterion("BRCLASS like", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotLike(String value) {
            addCriterion("BRCLASS not like", value, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassIn(List<String> values) {
            addCriterion("BRCLASS in", values, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotIn(List<String> values) {
            addCriterion("BRCLASS not in", values, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassBetween(String value1, String value2) {
            addCriterion("BRCLASS between", value1, value2, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrclassNotBetween(String value1, String value2) {
            addCriterion("BRCLASS not between", value1, value2, "brclass");
            return (Criteria) this;
        }

        public Criteria andBrattrIsNull() {
            addCriterion("BRATTR is null");
            return (Criteria) this;
        }

        public Criteria andBrattrIsNotNull() {
            addCriterion("BRATTR is not null");
            return (Criteria) this;
        }

        public Criteria andBrattrEqualTo(String value) {
            addCriterion("BRATTR =", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrNotEqualTo(String value) {
            addCriterion("BRATTR <>", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrGreaterThan(String value) {
            addCriterion("BRATTR >", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrGreaterThanOrEqualTo(String value) {
            addCriterion("BRATTR >=", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrLessThan(String value) {
            addCriterion("BRATTR <", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrLessThanOrEqualTo(String value) {
            addCriterion("BRATTR <=", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrLike(String value) {
            addCriterion("BRATTR like", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrNotLike(String value) {
            addCriterion("BRATTR not like", value, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrIn(List<String> values) {
            addCriterion("BRATTR in", values, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrNotIn(List<String> values) {
            addCriterion("BRATTR not in", values, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrBetween(String value1, String value2) {
            addCriterion("BRATTR between", value1, value2, "brattr");
            return (Criteria) this;
        }

        public Criteria andBrattrNotBetween(String value1, String value2) {
            addCriterion("BRATTR not between", value1, value2, "brattr");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassIsNull() {
            addCriterion("BLN_BRANCH_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassIsNotNull() {
            addCriterion("BLN_BRANCH_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassEqualTo(String value) {
            addCriterion("BLN_BRANCH_CLASS =", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassNotEqualTo(String value) {
            addCriterion("BLN_BRANCH_CLASS <>", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassGreaterThan(String value) {
            addCriterion("BLN_BRANCH_CLASS >", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassGreaterThanOrEqualTo(String value) {
            addCriterion("BLN_BRANCH_CLASS >=", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassLessThan(String value) {
            addCriterion("BLN_BRANCH_CLASS <", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassLessThanOrEqualTo(String value) {
            addCriterion("BLN_BRANCH_CLASS <=", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassLike(String value) {
            addCriterion("BLN_BRANCH_CLASS like", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassNotLike(String value) {
            addCriterion("BLN_BRANCH_CLASS not like", value, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassIn(List<String> values) {
            addCriterion("BLN_BRANCH_CLASS in", values, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassNotIn(List<String> values) {
            addCriterion("BLN_BRANCH_CLASS not in", values, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassBetween(String value1, String value2) {
            addCriterion("BLN_BRANCH_CLASS between", value1, value2, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchClassNotBetween(String value1, String value2) {
            addCriterion("BLN_BRANCH_CLASS not between", value1, value2, "blnBranchClass");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeIsNull() {
            addCriterion("BLN_BRANCH_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeIsNotNull() {
            addCriterion("BLN_BRANCH_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeEqualTo(String value) {
            addCriterion("BLN_BRANCH_BRCODE =", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeNotEqualTo(String value) {
            addCriterion("BLN_BRANCH_BRCODE <>", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeGreaterThan(String value) {
            addCriterion("BLN_BRANCH_BRCODE >", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BLN_BRANCH_BRCODE >=", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeLessThan(String value) {
            addCriterion("BLN_BRANCH_BRCODE <", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeLessThanOrEqualTo(String value) {
            addCriterion("BLN_BRANCH_BRCODE <=", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeLike(String value) {
            addCriterion("BLN_BRANCH_BRCODE like", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeNotLike(String value) {
            addCriterion("BLN_BRANCH_BRCODE not like", value, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeIn(List<String> values) {
            addCriterion("BLN_BRANCH_BRCODE in", values, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeNotIn(List<String> values) {
            addCriterion("BLN_BRANCH_BRCODE not in", values, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeBetween(String value1, String value2) {
            addCriterion("BLN_BRANCH_BRCODE between", value1, value2, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnBranchBrcodeNotBetween(String value1, String value2) {
            addCriterion("BLN_BRANCH_BRCODE not between", value1, value2, "blnBranchBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeIsNull() {
            addCriterion("BLN_MANAGE_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeIsNotNull() {
            addCriterion("BLN_MANAGE_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeEqualTo(String value) {
            addCriterion("BLN_MANAGE_BRCODE =", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeNotEqualTo(String value) {
            addCriterion("BLN_MANAGE_BRCODE <>", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeGreaterThan(String value) {
            addCriterion("BLN_MANAGE_BRCODE >", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BLN_MANAGE_BRCODE >=", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeLessThan(String value) {
            addCriterion("BLN_MANAGE_BRCODE <", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeLessThanOrEqualTo(String value) {
            addCriterion("BLN_MANAGE_BRCODE <=", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeLike(String value) {
            addCriterion("BLN_MANAGE_BRCODE like", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeNotLike(String value) {
            addCriterion("BLN_MANAGE_BRCODE not like", value, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeIn(List<String> values) {
            addCriterion("BLN_MANAGE_BRCODE in", values, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeNotIn(List<String> values) {
            addCriterion("BLN_MANAGE_BRCODE not in", values, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeBetween(String value1, String value2) {
            addCriterion("BLN_MANAGE_BRCODE between", value1, value2, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnManageBrcodeNotBetween(String value1, String value2) {
            addCriterion("BLN_MANAGE_BRCODE not between", value1, value2, "blnManageBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeIsNull() {
            addCriterion("BLN_UP_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeIsNotNull() {
            addCriterion("BLN_UP_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeEqualTo(String value) {
            addCriterion("BLN_UP_BRCODE =", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeNotEqualTo(String value) {
            addCriterion("BLN_UP_BRCODE <>", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeGreaterThan(String value) {
            addCriterion("BLN_UP_BRCODE >", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BLN_UP_BRCODE >=", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeLessThan(String value) {
            addCriterion("BLN_UP_BRCODE <", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeLessThanOrEqualTo(String value) {
            addCriterion("BLN_UP_BRCODE <=", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeLike(String value) {
            addCriterion("BLN_UP_BRCODE like", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeNotLike(String value) {
            addCriterion("BLN_UP_BRCODE not like", value, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeIn(List<String> values) {
            addCriterion("BLN_UP_BRCODE in", values, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeNotIn(List<String> values) {
            addCriterion("BLN_UP_BRCODE not in", values, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeBetween(String value1, String value2) {
            addCriterion("BLN_UP_BRCODE between", value1, value2, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnUpBrcodeNotBetween(String value1, String value2) {
            addCriterion("BLN_UP_BRCODE not between", value1, value2, "blnUpBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeIsNull() {
            addCriterion("TXN_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeIsNotNull() {
            addCriterion("TXN_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeEqualTo(String value) {
            addCriterion("TXN_BRCODE =", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeNotEqualTo(String value) {
            addCriterion("TXN_BRCODE <>", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeGreaterThan(String value) {
            addCriterion("TXN_BRCODE >", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_BRCODE >=", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeLessThan(String value) {
            addCriterion("TXN_BRCODE <", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeLessThanOrEqualTo(String value) {
            addCriterion("TXN_BRCODE <=", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeLike(String value) {
            addCriterion("TXN_BRCODE like", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeNotLike(String value) {
            addCriterion("TXN_BRCODE not like", value, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeIn(List<String> values) {
            addCriterion("TXN_BRCODE in", values, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeNotIn(List<String> values) {
            addCriterion("TXN_BRCODE not in", values, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeBetween(String value1, String value2) {
            addCriterion("TXN_BRCODE between", value1, value2, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andTxnBrcodeNotBetween(String value1, String value2) {
            addCriterion("TXN_BRCODE not between", value1, value2, "txnBrcode");
            return (Criteria) this;
        }

        public Criteria andAuthlvlIsNull() {
            addCriterion("AUTHLVL is null");
            return (Criteria) this;
        }

        public Criteria andAuthlvlIsNotNull() {
            addCriterion("AUTHLVL is not null");
            return (Criteria) this;
        }

        public Criteria andAuthlvlEqualTo(String value) {
            addCriterion("AUTHLVL =", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlNotEqualTo(String value) {
            addCriterion("AUTHLVL <>", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlGreaterThan(String value) {
            addCriterion("AUTHLVL >", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHLVL >=", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlLessThan(String value) {
            addCriterion("AUTHLVL <", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlLessThanOrEqualTo(String value) {
            addCriterion("AUTHLVL <=", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlLike(String value) {
            addCriterion("AUTHLVL like", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlNotLike(String value) {
            addCriterion("AUTHLVL not like", value, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlIn(List<String> values) {
            addCriterion("AUTHLVL in", values, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlNotIn(List<String> values) {
            addCriterion("AUTHLVL not in", values, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlBetween(String value1, String value2) {
            addCriterion("AUTHLVL between", value1, value2, "authlvl");
            return (Criteria) this;
        }

        public Criteria andAuthlvlNotBetween(String value1, String value2) {
            addCriterion("AUTHLVL not between", value1, value2, "authlvl");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("LINKMAN =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("LINKMAN <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("LINKMAN >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("LINKMAN >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("LINKMAN <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("LINKMAN <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("LINKMAN like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("LINKMAN not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("LINKMAN in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("LINKMAN not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("LINKMAN between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("LINKMAN not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andTelenoIsNull() {
            addCriterion("TELENO is null");
            return (Criteria) this;
        }

        public Criteria andTelenoIsNotNull() {
            addCriterion("TELENO is not null");
            return (Criteria) this;
        }

        public Criteria andTelenoEqualTo(String value) {
            addCriterion("TELENO =", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoNotEqualTo(String value) {
            addCriterion("TELENO <>", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoGreaterThan(String value) {
            addCriterion("TELENO >", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoGreaterThanOrEqualTo(String value) {
            addCriterion("TELENO >=", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoLessThan(String value) {
            addCriterion("TELENO <", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoLessThanOrEqualTo(String value) {
            addCriterion("TELENO <=", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoLike(String value) {
            addCriterion("TELENO like", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoNotLike(String value) {
            addCriterion("TELENO not like", value, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoIn(List<String> values) {
            addCriterion("TELENO in", values, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoNotIn(List<String> values) {
            addCriterion("TELENO not in", values, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoBetween(String value1, String value2) {
            addCriterion("TELENO between", value1, value2, "teleno");
            return (Criteria) this;
        }

        public Criteria andTelenoNotBetween(String value1, String value2) {
            addCriterion("TELENO not between", value1, value2, "teleno");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostnoIsNull() {
            addCriterion("POSTNO is null");
            return (Criteria) this;
        }

        public Criteria andPostnoIsNotNull() {
            addCriterion("POSTNO is not null");
            return (Criteria) this;
        }

        public Criteria andPostnoEqualTo(String value) {
            addCriterion("POSTNO =", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoNotEqualTo(String value) {
            addCriterion("POSTNO <>", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoGreaterThan(String value) {
            addCriterion("POSTNO >", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoGreaterThanOrEqualTo(String value) {
            addCriterion("POSTNO >=", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoLessThan(String value) {
            addCriterion("POSTNO <", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoLessThanOrEqualTo(String value) {
            addCriterion("POSTNO <=", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoLike(String value) {
            addCriterion("POSTNO like", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoNotLike(String value) {
            addCriterion("POSTNO not like", value, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoIn(List<String> values) {
            addCriterion("POSTNO in", values, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoNotIn(List<String> values) {
            addCriterion("POSTNO not in", values, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoBetween(String value1, String value2) {
            addCriterion("POSTNO between", value1, value2, "postno");
            return (Criteria) this;
        }

        public Criteria andPostnoNotBetween(String value1, String value2) {
            addCriterion("POSTNO not between", value1, value2, "postno");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagIsNull() {
            addCriterion("OTHER_AREA_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagIsNotNull() {
            addCriterion("OTHER_AREA_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagEqualTo(String value) {
            addCriterion("OTHER_AREA_FLAG =", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagNotEqualTo(String value) {
            addCriterion("OTHER_AREA_FLAG <>", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagGreaterThan(String value) {
            addCriterion("OTHER_AREA_FLAG >", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_AREA_FLAG >=", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagLessThan(String value) {
            addCriterion("OTHER_AREA_FLAG <", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagLessThanOrEqualTo(String value) {
            addCriterion("OTHER_AREA_FLAG <=", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagLike(String value) {
            addCriterion("OTHER_AREA_FLAG like", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagNotLike(String value) {
            addCriterion("OTHER_AREA_FLAG not like", value, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagIn(List<String> values) {
            addCriterion("OTHER_AREA_FLAG in", values, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagNotIn(List<String> values) {
            addCriterion("OTHER_AREA_FLAG not in", values, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagBetween(String value1, String value2) {
            addCriterion("OTHER_AREA_FLAG between", value1, value2, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andOtherAreaFlagNotBetween(String value1, String value2) {
            addCriterion("OTHER_AREA_FLAG not between", value1, value2, "otherAreaFlag");
            return (Criteria) this;
        }

        public Criteria andRegionalismIsNull() {
            addCriterion("REGIONALISM is null");
            return (Criteria) this;
        }

        public Criteria andRegionalismIsNotNull() {
            addCriterion("REGIONALISM is not null");
            return (Criteria) this;
        }

        public Criteria andRegionalismEqualTo(String value) {
            addCriterion("REGIONALISM =", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismNotEqualTo(String value) {
            addCriterion("REGIONALISM <>", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismGreaterThan(String value) {
            addCriterion("REGIONALISM >", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismGreaterThanOrEqualTo(String value) {
            addCriterion("REGIONALISM >=", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismLessThan(String value) {
            addCriterion("REGIONALISM <", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismLessThanOrEqualTo(String value) {
            addCriterion("REGIONALISM <=", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismLike(String value) {
            addCriterion("REGIONALISM like", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismNotLike(String value) {
            addCriterion("REGIONALISM not like", value, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismIn(List<String> values) {
            addCriterion("REGIONALISM in", values, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismNotIn(List<String> values) {
            addCriterion("REGIONALISM not in", values, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismBetween(String value1, String value2) {
            addCriterion("REGIONALISM between", value1, value2, "regionalism");
            return (Criteria) this;
        }

        public Criteria andRegionalismNotBetween(String value1, String value2) {
            addCriterion("REGIONALISM not between", value1, value2, "regionalism");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeIsNull() {
            addCriterion("FINANCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeIsNotNull() {
            addCriterion("FINANCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeEqualTo(String value) {
            addCriterion("FINANCE_CODE =", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeNotEqualTo(String value) {
            addCriterion("FINANCE_CODE <>", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeGreaterThan(String value) {
            addCriterion("FINANCE_CODE >", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FINANCE_CODE >=", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeLessThan(String value) {
            addCriterion("FINANCE_CODE <", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeLessThanOrEqualTo(String value) {
            addCriterion("FINANCE_CODE <=", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeLike(String value) {
            addCriterion("FINANCE_CODE like", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeNotLike(String value) {
            addCriterion("FINANCE_CODE not like", value, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeIn(List<String> values) {
            addCriterion("FINANCE_CODE in", values, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeNotIn(List<String> values) {
            addCriterion("FINANCE_CODE not in", values, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeBetween(String value1, String value2) {
            addCriterion("FINANCE_CODE between", value1, value2, "financeCode");
            return (Criteria) this;
        }

        public Criteria andFinanceCodeNotBetween(String value1, String value2) {
            addCriterion("FINANCE_CODE not between", value1, value2, "financeCode");
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

        public Criteria andMiscflgsIsNull() {
            addCriterion("MISCFLGS is null");
            return (Criteria) this;
        }

        public Criteria andMiscflgsIsNotNull() {
            addCriterion("MISCFLGS is not null");
            return (Criteria) this;
        }

        public Criteria andMiscflgsEqualTo(String value) {
            addCriterion("MISCFLGS =", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotEqualTo(String value) {
            addCriterion("MISCFLGS <>", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsGreaterThan(String value) {
            addCriterion("MISCFLGS >", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsGreaterThanOrEqualTo(String value) {
            addCriterion("MISCFLGS >=", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsLessThan(String value) {
            addCriterion("MISCFLGS <", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsLessThanOrEqualTo(String value) {
            addCriterion("MISCFLGS <=", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsLike(String value) {
            addCriterion("MISCFLGS like", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotLike(String value) {
            addCriterion("MISCFLGS not like", value, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsIn(List<String> values) {
            addCriterion("MISCFLGS in", values, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotIn(List<String> values) {
            addCriterion("MISCFLGS not in", values, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsBetween(String value1, String value2) {
            addCriterion("MISCFLGS between", value1, value2, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscflgsNotBetween(String value1, String value2) {
            addCriterion("MISCFLGS not between", value1, value2, "miscflgs");
            return (Criteria) this;
        }

        public Criteria andMiscIsNull() {
            addCriterion("MISC is null");
            return (Criteria) this;
        }

        public Criteria andMiscIsNotNull() {
            addCriterion("MISC is not null");
            return (Criteria) this;
        }

        public Criteria andMiscEqualTo(String value) {
            addCriterion("MISC =", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotEqualTo(String value) {
            addCriterion("MISC <>", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscGreaterThan(String value) {
            addCriterion("MISC >", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscGreaterThanOrEqualTo(String value) {
            addCriterion("MISC >=", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscLessThan(String value) {
            addCriterion("MISC <", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscLessThanOrEqualTo(String value) {
            addCriterion("MISC <=", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscLike(String value) {
            addCriterion("MISC like", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotLike(String value) {
            addCriterion("MISC not like", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscIn(List<String> values) {
            addCriterion("MISC in", values, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotIn(List<String> values) {
            addCriterion("MISC not in", values, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscBetween(String value1, String value2) {
            addCriterion("MISC between", value1, value2, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotBetween(String value1, String value2) {
            addCriterion("MISC not between", value1, value2, "misc");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeIsNull() {
            addCriterion("BLN_HEAD_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeIsNotNull() {
            addCriterion("BLN_HEAD_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeEqualTo(String value) {
            addCriterion("BLN_HEAD_BRCODE =", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeNotEqualTo(String value) {
            addCriterion("BLN_HEAD_BRCODE <>", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeGreaterThan(String value) {
            addCriterion("BLN_HEAD_BRCODE >", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BLN_HEAD_BRCODE >=", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeLessThan(String value) {
            addCriterion("BLN_HEAD_BRCODE <", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeLessThanOrEqualTo(String value) {
            addCriterion("BLN_HEAD_BRCODE <=", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeLike(String value) {
            addCriterion("BLN_HEAD_BRCODE like", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeNotLike(String value) {
            addCriterion("BLN_HEAD_BRCODE not like", value, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeIn(List<String> values) {
            addCriterion("BLN_HEAD_BRCODE in", values, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeNotIn(List<String> values) {
            addCriterion("BLN_HEAD_BRCODE not in", values, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeBetween(String value1, String value2) {
            addCriterion("BLN_HEAD_BRCODE between", value1, value2, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andBlnHeadBrcodeNotBetween(String value1, String value2) {
            addCriterion("BLN_HEAD_BRCODE not between", value1, value2, "blnHeadBrcode");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIsNull() {
            addCriterion("LAST_UPD_TLR is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIsNotNull() {
            addCriterion("LAST_UPD_TLR is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR =", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotEqualTo(String value) {
            addCriterion("LAST_UPD_TLR <>", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrGreaterThan(String value) {
            addCriterion("LAST_UPD_TLR >", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR >=", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLessThan(String value) {
            addCriterion("LAST_UPD_TLR <", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_TLR <=", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrLike(String value) {
            addCriterion("LAST_UPD_TLR like", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotLike(String value) {
            addCriterion("LAST_UPD_TLR not like", value, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrIn(List<String> values) {
            addCriterion("LAST_UPD_TLR in", values, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotIn(List<String> values) {
            addCriterion("LAST_UPD_TLR not in", values, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLR between", value1, value2, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdTlrNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_TLR not between", value1, value2, "lastUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncIsNull() {
            addCriterion("LAST_UPD_FUNC is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncIsNotNull() {
            addCriterion("LAST_UPD_FUNC is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncEqualTo(String value) {
            addCriterion("LAST_UPD_FUNC =", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncNotEqualTo(String value) {
            addCriterion("LAST_UPD_FUNC <>", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncGreaterThan(String value) {
            addCriterion("LAST_UPD_FUNC >", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_FUNC >=", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncLessThan(String value) {
            addCriterion("LAST_UPD_FUNC <", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_FUNC <=", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncLike(String value) {
            addCriterion("LAST_UPD_FUNC like", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncNotLike(String value) {
            addCriterion("LAST_UPD_FUNC not like", value, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncIn(List<String> values) {
            addCriterion("LAST_UPD_FUNC in", values, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncNotIn(List<String> values) {
            addCriterion("LAST_UPD_FUNC not in", values, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncBetween(String value1, String value2) {
            addCriterion("LAST_UPD_FUNC between", value1, value2, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdFuncNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_FUNC not between", value1, value2, "lastUpdFunc");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNull() {
            addCriterion("LAST_UPD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIsNotNull() {
            addCriterion("LAST_UPD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateEqualTo(String value) {
            addCriterion("LAST_UPD_DATE =", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotEqualTo(String value) {
            addCriterion("LAST_UPD_DATE <>", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThan(String value) {
            addCriterion("LAST_UPD_DATE >", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_DATE >=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThan(String value) {
            addCriterion("LAST_UPD_DATE <", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPD_DATE <=", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateLike(String value) {
            addCriterion("LAST_UPD_DATE like", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotLike(String value) {
            addCriterion("LAST_UPD_DATE not like", value, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateIn(List<String> values) {
            addCriterion("LAST_UPD_DATE in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotIn(List<String> values) {
            addCriterion("LAST_UPD_DATE not in", values, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateBetween(String value1, String value2) {
            addCriterion("LAST_UPD_DATE between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdDateNotBetween(String value1, String value2) {
            addCriterion("LAST_UPD_DATE not between", value1, value2, "lastUpdDate");
            return (Criteria) this;
        }

        public Criteria andTimestampsIsNull() {
            addCriterion("TIMESTAMPS is null");
            return (Criteria) this;
        }

        public Criteria andTimestampsIsNotNull() {
            addCriterion("TIMESTAMPS is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampsEqualTo(Date value) {
            addCriterion("TIMESTAMPS =", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotEqualTo(Date value) {
            addCriterion("TIMESTAMPS <>", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsGreaterThan(Date value) {
            addCriterion("TIMESTAMPS >", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsGreaterThanOrEqualTo(Date value) {
            addCriterion("TIMESTAMPS >=", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsLessThan(Date value) {
            addCriterion("TIMESTAMPS <", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsLessThanOrEqualTo(Date value) {
            addCriterion("TIMESTAMPS <=", value, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsIn(List<Date> values) {
            addCriterion("TIMESTAMPS in", values, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotIn(List<Date> values) {
            addCriterion("TIMESTAMPS not in", values, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsBetween(Date value1, Date value2) {
            addCriterion("TIMESTAMPS between", value1, value2, "timestamps");
            return (Criteria) this;
        }

        public Criteria andTimestampsNotBetween(Date value1, Date value2) {
            addCriterion("TIMESTAMPS not between", value1, value2, "timestamps");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}