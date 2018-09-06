package com.huateng.scf.bas.crm.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrmRelationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrmRelationInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrmRelationInfoExample(BCrmRelationInfoExample example) {
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

        public Criteria andBuyerCustcdIsNull() {
            addCriterion("BUYER_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdIsNotNull() {
            addCriterion("BUYER_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdEqualTo(String value) {
            addCriterion("BUYER_CUSTCD =", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdNotEqualTo(String value) {
            addCriterion("BUYER_CUSTCD <>", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdGreaterThan(String value) {
            addCriterion("BUYER_CUSTCD >", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("BUYER_CUSTCD >=", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdLessThan(String value) {
            addCriterion("BUYER_CUSTCD <", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdLessThanOrEqualTo(String value) {
            addCriterion("BUYER_CUSTCD <=", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdLike(String value) {
            addCriterion("BUYER_CUSTCD like", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdNotLike(String value) {
            addCriterion("BUYER_CUSTCD not like", value, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdIn(List<String> values) {
            addCriterion("BUYER_CUSTCD in", values, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdNotIn(List<String> values) {
            addCriterion("BUYER_CUSTCD not in", values, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdBetween(String value1, String value2) {
            addCriterion("BUYER_CUSTCD between", value1, value2, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andBuyerCustcdNotBetween(String value1, String value2) {
            addCriterion("BUYER_CUSTCD not between", value1, value2, "buyerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdIsNull() {
            addCriterion("SELLER_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdIsNotNull() {
            addCriterion("SELLER_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdEqualTo(String value) {
            addCriterion("SELLER_CUSTCD =", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotEqualTo(String value) {
            addCriterion("SELLER_CUSTCD <>", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdGreaterThan(String value) {
            addCriterion("SELLER_CUSTCD >", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_CUSTCD >=", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdLessThan(String value) {
            addCriterion("SELLER_CUSTCD <", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdLessThanOrEqualTo(String value) {
            addCriterion("SELLER_CUSTCD <=", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdLike(String value) {
            addCriterion("SELLER_CUSTCD like", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotLike(String value) {
            addCriterion("SELLER_CUSTCD not like", value, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdIn(List<String> values) {
            addCriterion("SELLER_CUSTCD in", values, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotIn(List<String> values) {
            addCriterion("SELLER_CUSTCD not in", values, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdBetween(String value1, String value2) {
            addCriterion("SELLER_CUSTCD between", value1, value2, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andSellerCustcdNotBetween(String value1, String value2) {
            addCriterion("SELLER_CUSTCD not between", value1, value2, "sellerCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdIsNull() {
            addCriterion("CORE_CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdIsNotNull() {
            addCriterion("CORE_CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdEqualTo(String value) {
            addCriterion("CORE_CUSTCD =", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdNotEqualTo(String value) {
            addCriterion("CORE_CUSTCD <>", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdGreaterThan(String value) {
            addCriterion("CORE_CUSTCD >", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CORE_CUSTCD >=", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdLessThan(String value) {
            addCriterion("CORE_CUSTCD <", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdLessThanOrEqualTo(String value) {
            addCriterion("CORE_CUSTCD <=", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdLike(String value) {
            addCriterion("CORE_CUSTCD like", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdNotLike(String value) {
            addCriterion("CORE_CUSTCD not like", value, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdIn(List<String> values) {
            addCriterion("CORE_CUSTCD in", values, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdNotIn(List<String> values) {
            addCriterion("CORE_CUSTCD not in", values, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdBetween(String value1, String value2) {
            addCriterion("CORE_CUSTCD between", value1, value2, "coreCustcd");
            return (Criteria) this;
        }

        public Criteria andCoreCustcdNotBetween(String value1, String value2) {
            addCriterion("CORE_CUSTCD not between", value1, value2, "coreCustcd");
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

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRelaTypeIsNull() {
            addCriterion("RELA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRelaTypeIsNotNull() {
            addCriterion("RELA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRelaTypeEqualTo(String value) {
            addCriterion("RELA_TYPE =", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotEqualTo(String value) {
            addCriterion("RELA_TYPE <>", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeGreaterThan(String value) {
            addCriterion("RELA_TYPE >", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_TYPE >=", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLessThan(String value) {
            addCriterion("RELA_TYPE <", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLessThanOrEqualTo(String value) {
            addCriterion("RELA_TYPE <=", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeLike(String value) {
            addCriterion("RELA_TYPE like", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotLike(String value) {
            addCriterion("RELA_TYPE not like", value, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeIn(List<String> values) {
            addCriterion("RELA_TYPE in", values, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotIn(List<String> values) {
            addCriterion("RELA_TYPE not in", values, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeBetween(String value1, String value2) {
            addCriterion("RELA_TYPE between", value1, value2, "relaType");
            return (Criteria) this;
        }

        public Criteria andRelaTypeNotBetween(String value1, String value2) {
            addCriterion("RELA_TYPE not between", value1, value2, "relaType");
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