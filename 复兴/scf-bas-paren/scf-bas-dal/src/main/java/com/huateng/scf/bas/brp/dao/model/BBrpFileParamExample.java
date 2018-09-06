package com.huateng.scf.bas.brp.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBrpFileParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBrpFileParamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BBrpFileParamExample(BBrpFileParamExample example) {
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

        public Criteria andContNameIsNull() {
            addCriterion("CONT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContNameIsNotNull() {
            addCriterion("CONT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContNameEqualTo(String value) {
            addCriterion("CONT_NAME =", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotEqualTo(String value) {
            addCriterion("CONT_NAME <>", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameGreaterThan(String value) {
            addCriterion("CONT_NAME >", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_NAME >=", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLessThan(String value) {
            addCriterion("CONT_NAME <", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLessThanOrEqualTo(String value) {
            addCriterion("CONT_NAME <=", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLike(String value) {
            addCriterion("CONT_NAME like", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotLike(String value) {
            addCriterion("CONT_NAME not like", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameIn(List<String> values) {
            addCriterion("CONT_NAME in", values, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotIn(List<String> values) {
            addCriterion("CONT_NAME not in", values, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameBetween(String value1, String value2) {
            addCriterion("CONT_NAME between", value1, value2, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotBetween(String value1, String value2) {
            addCriterion("CONT_NAME not between", value1, value2, "contName");
            return (Criteria) this;
        }

        public Criteria andContCodeIsNull() {
            addCriterion("CONT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContCodeIsNotNull() {
            addCriterion("CONT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContCodeEqualTo(String value) {
            addCriterion("CONT_CODE =", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeNotEqualTo(String value) {
            addCriterion("CONT_CODE <>", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeGreaterThan(String value) {
            addCriterion("CONT_CODE >", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_CODE >=", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeLessThan(String value) {
            addCriterion("CONT_CODE <", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeLessThanOrEqualTo(String value) {
            addCriterion("CONT_CODE <=", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeLike(String value) {
            addCriterion("CONT_CODE like", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeNotLike(String value) {
            addCriterion("CONT_CODE not like", value, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeIn(List<String> values) {
            addCriterion("CONT_CODE in", values, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeNotIn(List<String> values) {
            addCriterion("CONT_CODE not in", values, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeBetween(String value1, String value2) {
            addCriterion("CONT_CODE between", value1, value2, "contCode");
            return (Criteria) this;
        }

        public Criteria andContCodeNotBetween(String value1, String value2) {
            addCriterion("CONT_CODE not between", value1, value2, "contCode");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("EXT1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("EXT2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("EXT2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("EXT2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("EXT2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("EXT2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("EXT2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("EXT2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("EXT2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("EXT2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("EXT2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("EXT2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("EXT2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("EXT2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("EXT2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("EXT3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("EXT3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("EXT3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("EXT3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("EXT3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("EXT3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("EXT3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("EXT3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("EXT3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("EXT3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("EXT3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("EXT3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("EXT3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("EXT3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt4IsNull() {
            addCriterion("EXT4 is null");
            return (Criteria) this;
        }

        public Criteria andExt4IsNotNull() {
            addCriterion("EXT4 is not null");
            return (Criteria) this;
        }

        public Criteria andExt4EqualTo(String value) {
            addCriterion("EXT4 =", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotEqualTo(String value) {
            addCriterion("EXT4 <>", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThan(String value) {
            addCriterion("EXT4 >", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThanOrEqualTo(String value) {
            addCriterion("EXT4 >=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThan(String value) {
            addCriterion("EXT4 <", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThanOrEqualTo(String value) {
            addCriterion("EXT4 <=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Like(String value) {
            addCriterion("EXT4 like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotLike(String value) {
            addCriterion("EXT4 not like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4In(List<String> values) {
            addCriterion("EXT4 in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotIn(List<String> values) {
            addCriterion("EXT4 not in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Between(String value1, String value2) {
            addCriterion("EXT4 between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotBetween(String value1, String value2) {
            addCriterion("EXT4 not between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt5IsNull() {
            addCriterion("EXT5 is null");
            return (Criteria) this;
        }

        public Criteria andExt5IsNotNull() {
            addCriterion("EXT5 is not null");
            return (Criteria) this;
        }

        public Criteria andExt5EqualTo(String value) {
            addCriterion("EXT5 =", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotEqualTo(String value) {
            addCriterion("EXT5 <>", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThan(String value) {
            addCriterion("EXT5 >", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThanOrEqualTo(String value) {
            addCriterion("EXT5 >=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThan(String value) {
            addCriterion("EXT5 <", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThanOrEqualTo(String value) {
            addCriterion("EXT5 <=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Like(String value) {
            addCriterion("EXT5 like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotLike(String value) {
            addCriterion("EXT5 not like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5In(List<String> values) {
            addCriterion("EXT5 in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotIn(List<String> values) {
            addCriterion("EXT5 not in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Between(String value1, String value2) {
            addCriterion("EXT5 between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotBetween(String value1, String value2) {
            addCriterion("EXT5 not between", value1, value2, "ext5");
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