package com.huateng.scf.bas.prd.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPrdReceMatlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPrdReceMatlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPrdReceMatlExample(BPrdReceMatlExample example) {
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

        public Criteria andReceMatlNameIsNull() {
            addCriterion("RECE_MATL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameIsNotNull() {
            addCriterion("RECE_MATL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameEqualTo(String value) {
            addCriterion("RECE_MATL_NAME =", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameNotEqualTo(String value) {
            addCriterion("RECE_MATL_NAME <>", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameGreaterThan(String value) {
            addCriterion("RECE_MATL_NAME >", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameGreaterThanOrEqualTo(String value) {
            addCriterion("RECE_MATL_NAME >=", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameLessThan(String value) {
            addCriterion("RECE_MATL_NAME <", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameLessThanOrEqualTo(String value) {
            addCriterion("RECE_MATL_NAME <=", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameLike(String value) {
            addCriterion("RECE_MATL_NAME like", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameNotLike(String value) {
            addCriterion("RECE_MATL_NAME not like", value, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameIn(List<String> values) {
            addCriterion("RECE_MATL_NAME in", values, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameNotIn(List<String> values) {
            addCriterion("RECE_MATL_NAME not in", values, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameBetween(String value1, String value2) {
            addCriterion("RECE_MATL_NAME between", value1, value2, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlNameNotBetween(String value1, String value2) {
            addCriterion("RECE_MATL_NAME not between", value1, value2, "receMatlName");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeIsNull() {
            addCriterion("RECE_MATL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeIsNotNull() {
            addCriterion("RECE_MATL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeEqualTo(String value) {
            addCriterion("RECE_MATL_TYPE =", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeNotEqualTo(String value) {
            addCriterion("RECE_MATL_TYPE <>", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeGreaterThan(String value) {
            addCriterion("RECE_MATL_TYPE >", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RECE_MATL_TYPE >=", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeLessThan(String value) {
            addCriterion("RECE_MATL_TYPE <", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeLessThanOrEqualTo(String value) {
            addCriterion("RECE_MATL_TYPE <=", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeLike(String value) {
            addCriterion("RECE_MATL_TYPE like", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeNotLike(String value) {
            addCriterion("RECE_MATL_TYPE not like", value, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeIn(List<String> values) {
            addCriterion("RECE_MATL_TYPE in", values, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeNotIn(List<String> values) {
            addCriterion("RECE_MATL_TYPE not in", values, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeBetween(String value1, String value2) {
            addCriterion("RECE_MATL_TYPE between", value1, value2, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andReceMatlTypeNotBetween(String value1, String value2) {
            addCriterion("RECE_MATL_TYPE not between", value1, value2, "receMatlType");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagIsNull() {
            addCriterion("IS_NEED_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagIsNotNull() {
            addCriterion("IS_NEED_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagEqualTo(String value) {
            addCriterion("IS_NEED_FLAG =", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagNotEqualTo(String value) {
            addCriterion("IS_NEED_FLAG <>", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagGreaterThan(String value) {
            addCriterion("IS_NEED_FLAG >", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NEED_FLAG >=", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagLessThan(String value) {
            addCriterion("IS_NEED_FLAG <", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagLessThanOrEqualTo(String value) {
            addCriterion("IS_NEED_FLAG <=", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagLike(String value) {
            addCriterion("IS_NEED_FLAG like", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagNotLike(String value) {
            addCriterion("IS_NEED_FLAG not like", value, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagIn(List<String> values) {
            addCriterion("IS_NEED_FLAG in", values, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagNotIn(List<String> values) {
            addCriterion("IS_NEED_FLAG not in", values, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagBetween(String value1, String value2) {
            addCriterion("IS_NEED_FLAG between", value1, value2, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andIsNeedFlagNotBetween(String value1, String value2) {
            addCriterion("IS_NEED_FLAG not between", value1, value2, "isNeedFlag");
            return (Criteria) this;
        }

        public Criteria andOrigNumIsNull() {
            addCriterion("ORIG_NUM is null");
            return (Criteria) this;
        }

        public Criteria andOrigNumIsNotNull() {
            addCriterion("ORIG_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andOrigNumEqualTo(BigDecimal value) {
            addCriterion("ORIG_NUM =", value, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumNotEqualTo(BigDecimal value) {
            addCriterion("ORIG_NUM <>", value, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumGreaterThan(BigDecimal value) {
            addCriterion("ORIG_NUM >", value, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIG_NUM >=", value, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumLessThan(BigDecimal value) {
            addCriterion("ORIG_NUM <", value, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIG_NUM <=", value, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumIn(List<BigDecimal> values) {
            addCriterion("ORIG_NUM in", values, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumNotIn(List<BigDecimal> values) {
            addCriterion("ORIG_NUM not in", values, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIG_NUM between", value1, value2, "origNum");
            return (Criteria) this;
        }

        public Criteria andOrigNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIG_NUM not between", value1, value2, "origNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumIsNull() {
            addCriterion("COPY_ORIG_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumIsNotNull() {
            addCriterion("COPY_ORIG_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumEqualTo(BigDecimal value) {
            addCriterion("COPY_ORIG_NUM =", value, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumNotEqualTo(BigDecimal value) {
            addCriterion("COPY_ORIG_NUM <>", value, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumGreaterThan(BigDecimal value) {
            addCriterion("COPY_ORIG_NUM >", value, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COPY_ORIG_NUM >=", value, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumLessThan(BigDecimal value) {
            addCriterion("COPY_ORIG_NUM <", value, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COPY_ORIG_NUM <=", value, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumIn(List<BigDecimal> values) {
            addCriterion("COPY_ORIG_NUM in", values, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumNotIn(List<BigDecimal> values) {
            addCriterion("COPY_ORIG_NUM not in", values, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COPY_ORIG_NUM between", value1, value2, "copyOrigNum");
            return (Criteria) this;
        }

        public Criteria andCopyOrigNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COPY_ORIG_NUM not between", value1, value2, "copyOrigNum");
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