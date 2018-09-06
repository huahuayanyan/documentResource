package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrGntyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrGntyInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrGntyInfoExample(BCrrGntyInfoExample example) {
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

        public Criteria andGntyIdIsNull() {
            addCriterion("GNTY_ID is null");
            return (Criteria) this;
        }

        public Criteria andGntyIdIsNotNull() {
            addCriterion("GNTY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGntyIdEqualTo(String value) {
            addCriterion("GNTY_ID =", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotEqualTo(String value) {
            addCriterion("GNTY_ID <>", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdGreaterThan(String value) {
            addCriterion("GNTY_ID >", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_ID >=", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdLessThan(String value) {
            addCriterion("GNTY_ID <", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdLessThanOrEqualTo(String value) {
            addCriterion("GNTY_ID <=", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdLike(String value) {
            addCriterion("GNTY_ID like", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotLike(String value) {
            addCriterion("GNTY_ID not like", value, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdIn(List<String> values) {
            addCriterion("GNTY_ID in", values, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotIn(List<String> values) {
            addCriterion("GNTY_ID not in", values, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdBetween(String value1, String value2) {
            addCriterion("GNTY_ID between", value1, value2, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyIdNotBetween(String value1, String value2) {
            addCriterion("GNTY_ID not between", value1, value2, "gntyId");
            return (Criteria) this;
        }

        public Criteria andGntyNmIsNull() {
            addCriterion("GNTY_NM is null");
            return (Criteria) this;
        }

        public Criteria andGntyNmIsNotNull() {
            addCriterion("GNTY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andGntyNmEqualTo(String value) {
            addCriterion("GNTY_NM =", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotEqualTo(String value) {
            addCriterion("GNTY_NM <>", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmGreaterThan(String value) {
            addCriterion("GNTY_NM >", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_NM >=", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmLessThan(String value) {
            addCriterion("GNTY_NM <", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmLessThanOrEqualTo(String value) {
            addCriterion("GNTY_NM <=", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmLike(String value) {
            addCriterion("GNTY_NM like", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotLike(String value) {
            addCriterion("GNTY_NM not like", value, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmIn(List<String> values) {
            addCriterion("GNTY_NM in", values, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotIn(List<String> values) {
            addCriterion("GNTY_NM not in", values, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmBetween(String value1, String value2) {
            addCriterion("GNTY_NM between", value1, value2, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyNmNotBetween(String value1, String value2) {
            addCriterion("GNTY_NM not between", value1, value2, "gntyNm");
            return (Criteria) this;
        }

        public Criteria andGntyTypIsNull() {
            addCriterion("GNTY_TYP is null");
            return (Criteria) this;
        }

        public Criteria andGntyTypIsNotNull() {
            addCriterion("GNTY_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andGntyTypEqualTo(String value) {
            addCriterion("GNTY_TYP =", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotEqualTo(String value) {
            addCriterion("GNTY_TYP <>", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypGreaterThan(String value) {
            addCriterion("GNTY_TYP >", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_TYP >=", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypLessThan(String value) {
            addCriterion("GNTY_TYP <", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypLessThanOrEqualTo(String value) {
            addCriterion("GNTY_TYP <=", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypLike(String value) {
            addCriterion("GNTY_TYP like", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotLike(String value) {
            addCriterion("GNTY_TYP not like", value, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypIn(List<String> values) {
            addCriterion("GNTY_TYP in", values, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotIn(List<String> values) {
            addCriterion("GNTY_TYP not in", values, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypBetween(String value1, String value2) {
            addCriterion("GNTY_TYP between", value1, value2, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andGntyTypNotBetween(String value1, String value2) {
            addCriterion("GNTY_TYP not between", value1, value2, "gntyTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypIsNull() {
            addCriterion("CERT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andCertTypIsNotNull() {
            addCriterion("CERT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypEqualTo(String value) {
            addCriterion("CERT_TYP =", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypNotEqualTo(String value) {
            addCriterion("CERT_TYP <>", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypGreaterThan(String value) {
            addCriterion("CERT_TYP >", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYP >=", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypLessThan(String value) {
            addCriterion("CERT_TYP <", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYP <=", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypLike(String value) {
            addCriterion("CERT_TYP like", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypNotLike(String value) {
            addCriterion("CERT_TYP not like", value, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypIn(List<String> values) {
            addCriterion("CERT_TYP in", values, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypNotIn(List<String> values) {
            addCriterion("CERT_TYP not in", values, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypBetween(String value1, String value2) {
            addCriterion("CERT_TYP between", value1, value2, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertTypNotBetween(String value1, String value2) {
            addCriterion("CERT_TYP not between", value1, value2, "certTyp");
            return (Criteria) this;
        }

        public Criteria andCertIdIsNull() {
            addCriterion("CERT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCertIdIsNotNull() {
            addCriterion("CERT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCertIdEqualTo(String value) {
            addCriterion("CERT_ID =", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotEqualTo(String value) {
            addCriterion("CERT_ID <>", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdGreaterThan(String value) {
            addCriterion("CERT_ID >", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_ID >=", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLessThan(String value) {
            addCriterion("CERT_ID <", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLessThanOrEqualTo(String value) {
            addCriterion("CERT_ID <=", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLike(String value) {
            addCriterion("CERT_ID like", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotLike(String value) {
            addCriterion("CERT_ID not like", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdIn(List<String> values) {
            addCriterion("CERT_ID in", values, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotIn(List<String> values) {
            addCriterion("CERT_ID not in", values, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdBetween(String value1, String value2) {
            addCriterion("CERT_ID between", value1, value2, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotBetween(String value1, String value2) {
            addCriterion("CERT_ID not between", value1, value2, "certId");
            return (Criteria) this;
        }

        public Criteria andOwnerNmIsNull() {
            addCriterion("OWNER_NM is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNmIsNotNull() {
            addCriterion("OWNER_NM is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNmEqualTo(String value) {
            addCriterion("OWNER_NM =", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmNotEqualTo(String value) {
            addCriterion("OWNER_NM <>", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmGreaterThan(String value) {
            addCriterion("OWNER_NM >", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER_NM >=", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmLessThan(String value) {
            addCriterion("OWNER_NM <", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmLessThanOrEqualTo(String value) {
            addCriterion("OWNER_NM <=", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmLike(String value) {
            addCriterion("OWNER_NM like", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmNotLike(String value) {
            addCriterion("OWNER_NM not like", value, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmIn(List<String> values) {
            addCriterion("OWNER_NM in", values, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmNotIn(List<String> values) {
            addCriterion("OWNER_NM not in", values, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmBetween(String value1, String value2) {
            addCriterion("OWNER_NM between", value1, value2, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andOwnerNmNotBetween(String value1, String value2) {
            addCriterion("OWNER_NM not between", value1, value2, "ownerNm");
            return (Criteria) this;
        }

        public Criteria andCertLnNoIsNull() {
            addCriterion("CERT_LN_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertLnNoIsNotNull() {
            addCriterion("CERT_LN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertLnNoEqualTo(String value) {
            addCriterion("CERT_LN_NO =", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoNotEqualTo(String value) {
            addCriterion("CERT_LN_NO <>", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoGreaterThan(String value) {
            addCriterion("CERT_LN_NO >", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_LN_NO >=", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoLessThan(String value) {
            addCriterion("CERT_LN_NO <", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoLessThanOrEqualTo(String value) {
            addCriterion("CERT_LN_NO <=", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoLike(String value) {
            addCriterion("CERT_LN_NO like", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoNotLike(String value) {
            addCriterion("CERT_LN_NO not like", value, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoIn(List<String> values) {
            addCriterion("CERT_LN_NO in", values, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoNotIn(List<String> values) {
            addCriterion("CERT_LN_NO not in", values, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoBetween(String value1, String value2) {
            addCriterion("CERT_LN_NO between", value1, value2, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andCertLnNoNotBetween(String value1, String value2) {
            addCriterion("CERT_LN_NO not between", value1, value2, "certLnNo");
            return (Criteria) this;
        }

        public Criteria andOwnerTypIsNull() {
            addCriterion("OWNER_TYP is null");
            return (Criteria) this;
        }

        public Criteria andOwnerTypIsNotNull() {
            addCriterion("OWNER_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerTypEqualTo(String value) {
            addCriterion("OWNER_TYP =", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypNotEqualTo(String value) {
            addCriterion("OWNER_TYP <>", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypGreaterThan(String value) {
            addCriterion("OWNER_TYP >", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER_TYP >=", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypLessThan(String value) {
            addCriterion("OWNER_TYP <", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypLessThanOrEqualTo(String value) {
            addCriterion("OWNER_TYP <=", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypLike(String value) {
            addCriterion("OWNER_TYP like", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypNotLike(String value) {
            addCriterion("OWNER_TYP not like", value, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypIn(List<String> values) {
            addCriterion("OWNER_TYP in", values, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypNotIn(List<String> values) {
            addCriterion("OWNER_TYP not in", values, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypBetween(String value1, String value2) {
            addCriterion("OWNER_TYP between", value1, value2, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andOwnerTypNotBetween(String value1, String value2) {
            addCriterion("OWNER_TYP not between", value1, value2, "ownerTyp");
            return (Criteria) this;
        }

        public Criteria andGntyRidIsNull() {
            addCriterion("GNTY_RID is null");
            return (Criteria) this;
        }

        public Criteria andGntyRidIsNotNull() {
            addCriterion("GNTY_RID is not null");
            return (Criteria) this;
        }

        public Criteria andGntyRidEqualTo(String value) {
            addCriterion("GNTY_RID =", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidNotEqualTo(String value) {
            addCriterion("GNTY_RID <>", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidGreaterThan(String value) {
            addCriterion("GNTY_RID >", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_RID >=", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidLessThan(String value) {
            addCriterion("GNTY_RID <", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidLessThanOrEqualTo(String value) {
            addCriterion("GNTY_RID <=", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidLike(String value) {
            addCriterion("GNTY_RID like", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidNotLike(String value) {
            addCriterion("GNTY_RID not like", value, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidIn(List<String> values) {
            addCriterion("GNTY_RID in", values, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidNotIn(List<String> values) {
            addCriterion("GNTY_RID not in", values, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidBetween(String value1, String value2) {
            addCriterion("GNTY_RID between", value1, value2, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntyRidNotBetween(String value1, String value2) {
            addCriterion("GNTY_RID not between", value1, value2, "gntyRid");
            return (Criteria) this;
        }

        public Criteria andGntySubTypIsNull() {
            addCriterion("GNTY_SUB_TYP is null");
            return (Criteria) this;
        }

        public Criteria andGntySubTypIsNotNull() {
            addCriterion("GNTY_SUB_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andGntySubTypEqualTo(String value) {
            addCriterion("GNTY_SUB_TYP =", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypNotEqualTo(String value) {
            addCriterion("GNTY_SUB_TYP <>", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypGreaterThan(String value) {
            addCriterion("GNTY_SUB_TYP >", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_SUB_TYP >=", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypLessThan(String value) {
            addCriterion("GNTY_SUB_TYP <", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypLessThanOrEqualTo(String value) {
            addCriterion("GNTY_SUB_TYP <=", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypLike(String value) {
            addCriterion("GNTY_SUB_TYP like", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypNotLike(String value) {
            addCriterion("GNTY_SUB_TYP not like", value, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypIn(List<String> values) {
            addCriterion("GNTY_SUB_TYP in", values, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypNotIn(List<String> values) {
            addCriterion("GNTY_SUB_TYP not in", values, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypBetween(String value1, String value2) {
            addCriterion("GNTY_SUB_TYP between", value1, value2, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubTypNotBetween(String value1, String value2) {
            addCriterion("GNTY_SUB_TYP not between", value1, value2, "gntySubTyp");
            return (Criteria) this;
        }

        public Criteria andGntySubNmIsNull() {
            addCriterion("GNTY_SUB_NM is null");
            return (Criteria) this;
        }

        public Criteria andGntySubNmIsNotNull() {
            addCriterion("GNTY_SUB_NM is not null");
            return (Criteria) this;
        }

        public Criteria andGntySubNmEqualTo(String value) {
            addCriterion("GNTY_SUB_NM =", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmNotEqualTo(String value) {
            addCriterion("GNTY_SUB_NM <>", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmGreaterThan(String value) {
            addCriterion("GNTY_SUB_NM >", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_SUB_NM >=", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmLessThan(String value) {
            addCriterion("GNTY_SUB_NM <", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmLessThanOrEqualTo(String value) {
            addCriterion("GNTY_SUB_NM <=", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmLike(String value) {
            addCriterion("GNTY_SUB_NM like", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmNotLike(String value) {
            addCriterion("GNTY_SUB_NM not like", value, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmIn(List<String> values) {
            addCriterion("GNTY_SUB_NM in", values, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmNotIn(List<String> values) {
            addCriterion("GNTY_SUB_NM not in", values, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmBetween(String value1, String value2) {
            addCriterion("GNTY_SUB_NM between", value1, value2, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntySubNmNotBetween(String value1, String value2) {
            addCriterion("GNTY_SUB_NM not between", value1, value2, "gntySubNm");
            return (Criteria) this;
        }

        public Criteria andGntyLocIsNull() {
            addCriterion("GNTY_LOC is null");
            return (Criteria) this;
        }

        public Criteria andGntyLocIsNotNull() {
            addCriterion("GNTY_LOC is not null");
            return (Criteria) this;
        }

        public Criteria andGntyLocEqualTo(String value) {
            addCriterion("GNTY_LOC =", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocNotEqualTo(String value) {
            addCriterion("GNTY_LOC <>", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocGreaterThan(String value) {
            addCriterion("GNTY_LOC >", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_LOC >=", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocLessThan(String value) {
            addCriterion("GNTY_LOC <", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocLessThanOrEqualTo(String value) {
            addCriterion("GNTY_LOC <=", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocLike(String value) {
            addCriterion("GNTY_LOC like", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocNotLike(String value) {
            addCriterion("GNTY_LOC not like", value, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocIn(List<String> values) {
            addCriterion("GNTY_LOC in", values, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocNotIn(List<String> values) {
            addCriterion("GNTY_LOC not in", values, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocBetween(String value1, String value2) {
            addCriterion("GNTY_LOC between", value1, value2, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyLocNotBetween(String value1, String value2) {
            addCriterion("GNTY_LOC not between", value1, value2, "gntyLoc");
            return (Criteria) this;
        }

        public Criteria andGntyAreaIsNull() {
            addCriterion("GNTY_AREA is null");
            return (Criteria) this;
        }

        public Criteria andGntyAreaIsNotNull() {
            addCriterion("GNTY_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andGntyAreaEqualTo(BigDecimal value) {
            addCriterion("GNTY_AREA =", value, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaNotEqualTo(BigDecimal value) {
            addCriterion("GNTY_AREA <>", value, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaGreaterThan(BigDecimal value) {
            addCriterion("GNTY_AREA >", value, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GNTY_AREA >=", value, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaLessThan(BigDecimal value) {
            addCriterion("GNTY_AREA <", value, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GNTY_AREA <=", value, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaIn(List<BigDecimal> values) {
            addCriterion("GNTY_AREA in", values, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaNotIn(List<BigDecimal> values) {
            addCriterion("GNTY_AREA not in", values, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GNTY_AREA between", value1, value2, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GNTY_AREA not between", value1, value2, "gntyArea");
            return (Criteria) this;
        }

        public Criteria andGntyAttrIsNull() {
            addCriterion("GNTY_ATTR is null");
            return (Criteria) this;
        }

        public Criteria andGntyAttrIsNotNull() {
            addCriterion("GNTY_ATTR is not null");
            return (Criteria) this;
        }

        public Criteria andGntyAttrEqualTo(String value) {
            addCriterion("GNTY_ATTR =", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrNotEqualTo(String value) {
            addCriterion("GNTY_ATTR <>", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrGreaterThan(String value) {
            addCriterion("GNTY_ATTR >", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_ATTR >=", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrLessThan(String value) {
            addCriterion("GNTY_ATTR <", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrLessThanOrEqualTo(String value) {
            addCriterion("GNTY_ATTR <=", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrLike(String value) {
            addCriterion("GNTY_ATTR like", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrNotLike(String value) {
            addCriterion("GNTY_ATTR not like", value, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrIn(List<String> values) {
            addCriterion("GNTY_ATTR in", values, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrNotIn(List<String> values) {
            addCriterion("GNTY_ATTR not in", values, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrBetween(String value1, String value2) {
            addCriterion("GNTY_ATTR between", value1, value2, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyAttrNotBetween(String value1, String value2) {
            addCriterion("GNTY_ATTR not between", value1, value2, "gntyAttr");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayIsNull() {
            addCriterion("GNTY_OWN_WAY is null");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayIsNotNull() {
            addCriterion("GNTY_OWN_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayEqualTo(String value) {
            addCriterion("GNTY_OWN_WAY =", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayNotEqualTo(String value) {
            addCriterion("GNTY_OWN_WAY <>", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayGreaterThan(String value) {
            addCriterion("GNTY_OWN_WAY >", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_OWN_WAY >=", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayLessThan(String value) {
            addCriterion("GNTY_OWN_WAY <", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayLessThanOrEqualTo(String value) {
            addCriterion("GNTY_OWN_WAY <=", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayLike(String value) {
            addCriterion("GNTY_OWN_WAY like", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayNotLike(String value) {
            addCriterion("GNTY_OWN_WAY not like", value, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayIn(List<String> values) {
            addCriterion("GNTY_OWN_WAY in", values, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayNotIn(List<String> values) {
            addCriterion("GNTY_OWN_WAY not in", values, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayBetween(String value1, String value2) {
            addCriterion("GNTY_OWN_WAY between", value1, value2, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyOwnWayNotBetween(String value1, String value2) {
            addCriterion("GNTY_OWN_WAY not between", value1, value2, "gntyOwnWay");
            return (Criteria) this;
        }

        public Criteria andGntyUsingIsNull() {
            addCriterion("GNTY_USING is null");
            return (Criteria) this;
        }

        public Criteria andGntyUsingIsNotNull() {
            addCriterion("GNTY_USING is not null");
            return (Criteria) this;
        }

        public Criteria andGntyUsingEqualTo(String value) {
            addCriterion("GNTY_USING =", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingNotEqualTo(String value) {
            addCriterion("GNTY_USING <>", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingGreaterThan(String value) {
            addCriterion("GNTY_USING >", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_USING >=", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingLessThan(String value) {
            addCriterion("GNTY_USING <", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingLessThanOrEqualTo(String value) {
            addCriterion("GNTY_USING <=", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingLike(String value) {
            addCriterion("GNTY_USING like", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingNotLike(String value) {
            addCriterion("GNTY_USING not like", value, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingIn(List<String> values) {
            addCriterion("GNTY_USING in", values, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingNotIn(List<String> values) {
            addCriterion("GNTY_USING not in", values, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingBetween(String value1, String value2) {
            addCriterion("GNTY_USING between", value1, value2, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyUsingNotBetween(String value1, String value2) {
            addCriterion("GNTY_USING not between", value1, value2, "gntyUsing");
            return (Criteria) this;
        }

        public Criteria andGntyPrcIsNull() {
            addCriterion("GNTY_PRC is null");
            return (Criteria) this;
        }

        public Criteria andGntyPrcIsNotNull() {
            addCriterion("GNTY_PRC is not null");
            return (Criteria) this;
        }

        public Criteria andGntyPrcEqualTo(BigDecimal value) {
            addCriterion("GNTY_PRC =", value, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcNotEqualTo(BigDecimal value) {
            addCriterion("GNTY_PRC <>", value, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcGreaterThan(BigDecimal value) {
            addCriterion("GNTY_PRC >", value, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GNTY_PRC >=", value, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcLessThan(BigDecimal value) {
            addCriterion("GNTY_PRC <", value, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GNTY_PRC <=", value, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcIn(List<BigDecimal> values) {
            addCriterion("GNTY_PRC in", values, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcNotIn(List<BigDecimal> values) {
            addCriterion("GNTY_PRC not in", values, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GNTY_PRC between", value1, value2, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andGntyPrcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GNTY_PRC not between", value1, value2, "gntyPrc");
            return (Criteria) this;
        }

        public Criteria andEvalMthdIsNull() {
            addCriterion("EVAL_MTHD is null");
            return (Criteria) this;
        }

        public Criteria andEvalMthdIsNotNull() {
            addCriterion("EVAL_MTHD is not null");
            return (Criteria) this;
        }

        public Criteria andEvalMthdEqualTo(String value) {
            addCriterion("EVAL_MTHD =", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdNotEqualTo(String value) {
            addCriterion("EVAL_MTHD <>", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdGreaterThan(String value) {
            addCriterion("EVAL_MTHD >", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_MTHD >=", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdLessThan(String value) {
            addCriterion("EVAL_MTHD <", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdLessThanOrEqualTo(String value) {
            addCriterion("EVAL_MTHD <=", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdLike(String value) {
            addCriterion("EVAL_MTHD like", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdNotLike(String value) {
            addCriterion("EVAL_MTHD not like", value, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdIn(List<String> values) {
            addCriterion("EVAL_MTHD in", values, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdNotIn(List<String> values) {
            addCriterion("EVAL_MTHD not in", values, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdBetween(String value1, String value2) {
            addCriterion("EVAL_MTHD between", value1, value2, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalMthdNotBetween(String value1, String value2) {
            addCriterion("EVAL_MTHD not between", value1, value2, "evalMthd");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmIsNull() {
            addCriterion("EVAL_ORG_NM is null");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmIsNotNull() {
            addCriterion("EVAL_ORG_NM is not null");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmEqualTo(String value) {
            addCriterion("EVAL_ORG_NM =", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmNotEqualTo(String value) {
            addCriterion("EVAL_ORG_NM <>", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmGreaterThan(String value) {
            addCriterion("EVAL_ORG_NM >", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_ORG_NM >=", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmLessThan(String value) {
            addCriterion("EVAL_ORG_NM <", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmLessThanOrEqualTo(String value) {
            addCriterion("EVAL_ORG_NM <=", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmLike(String value) {
            addCriterion("EVAL_ORG_NM like", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmNotLike(String value) {
            addCriterion("EVAL_ORG_NM not like", value, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmIn(List<String> values) {
            addCriterion("EVAL_ORG_NM in", values, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmNotIn(List<String> values) {
            addCriterion("EVAL_ORG_NM not in", values, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmBetween(String value1, String value2) {
            addCriterion("EVAL_ORG_NM between", value1, value2, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalOrgNmNotBetween(String value1, String value2) {
            addCriterion("EVAL_ORG_NM not between", value1, value2, "evalOrgNm");
            return (Criteria) this;
        }

        public Criteria andEvalDtIsNull() {
            addCriterion("EVAL_DT is null");
            return (Criteria) this;
        }

        public Criteria andEvalDtIsNotNull() {
            addCriterion("EVAL_DT is not null");
            return (Criteria) this;
        }

        public Criteria andEvalDtEqualTo(String value) {
            addCriterion("EVAL_DT =", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotEqualTo(String value) {
            addCriterion("EVAL_DT <>", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtGreaterThan(String value) {
            addCriterion("EVAL_DT >", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtGreaterThanOrEqualTo(String value) {
            addCriterion("EVAL_DT >=", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtLessThan(String value) {
            addCriterion("EVAL_DT <", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtLessThanOrEqualTo(String value) {
            addCriterion("EVAL_DT <=", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtLike(String value) {
            addCriterion("EVAL_DT like", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotLike(String value) {
            addCriterion("EVAL_DT not like", value, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtIn(List<String> values) {
            addCriterion("EVAL_DT in", values, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotIn(List<String> values) {
            addCriterion("EVAL_DT not in", values, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtBetween(String value1, String value2) {
            addCriterion("EVAL_DT between", value1, value2, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalDtNotBetween(String value1, String value2) {
            addCriterion("EVAL_DT not between", value1, value2, "evalDt");
            return (Criteria) this;
        }

        public Criteria andEvalNetValIsNull() {
            addCriterion("EVAL_NET_VAL is null");
            return (Criteria) this;
        }

        public Criteria andEvalNetValIsNotNull() {
            addCriterion("EVAL_NET_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andEvalNetValEqualTo(BigDecimal value) {
            addCriterion("EVAL_NET_VAL =", value, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValNotEqualTo(BigDecimal value) {
            addCriterion("EVAL_NET_VAL <>", value, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValGreaterThan(BigDecimal value) {
            addCriterion("EVAL_NET_VAL >", value, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_NET_VAL >=", value, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValLessThan(BigDecimal value) {
            addCriterion("EVAL_NET_VAL <", value, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_NET_VAL <=", value, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValIn(List<BigDecimal> values) {
            addCriterion("EVAL_NET_VAL in", values, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValNotIn(List<BigDecimal> values) {
            addCriterion("EVAL_NET_VAL not in", values, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_NET_VAL between", value1, value2, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andEvalNetValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_NET_VAL not between", value1, value2, "evalNetVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValIsNull() {
            addCriterion("CONFIRM_VAL is null");
            return (Criteria) this;
        }

        public Criteria andConfirmValIsNotNull() {
            addCriterion("CONFIRM_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmValEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_VAL =", value, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValNotEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_VAL <>", value, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValGreaterThan(BigDecimal value) {
            addCriterion("CONFIRM_VAL >", value, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_VAL >=", value, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValLessThan(BigDecimal value) {
            addCriterion("CONFIRM_VAL <", value, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONFIRM_VAL <=", value, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValIn(List<BigDecimal> values) {
            addCriterion("CONFIRM_VAL in", values, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValNotIn(List<BigDecimal> values) {
            addCriterion("CONFIRM_VAL not in", values, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONFIRM_VAL between", value1, value2, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andConfirmValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONFIRM_VAL not between", value1, value2, "confirmVal");
            return (Criteria) this;
        }

        public Criteria andGntyAmtIsNull() {
            addCriterion("GNTY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andGntyAmtIsNotNull() {
            addCriterion("GNTY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andGntyAmtEqualTo(BigDecimal value) {
            addCriterion("GNTY_AMT =", value, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtNotEqualTo(BigDecimal value) {
            addCriterion("GNTY_AMT <>", value, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtGreaterThan(BigDecimal value) {
            addCriterion("GNTY_AMT >", value, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GNTY_AMT >=", value, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtLessThan(BigDecimal value) {
            addCriterion("GNTY_AMT <", value, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GNTY_AMT <=", value, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtIn(List<BigDecimal> values) {
            addCriterion("GNTY_AMT in", values, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtNotIn(List<BigDecimal> values) {
            addCriterion("GNTY_AMT not in", values, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GNTY_AMT between", value1, value2, "gntyAmt");
            return (Criteria) this;
        }

        public Criteria andGntyAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GNTY_AMT not between", value1, value2, "gntyAmt");
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

        public Criteria andGntyRegOrgIsNull() {
            addCriterion("GNTY_REG_ORG is null");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgIsNotNull() {
            addCriterion("GNTY_REG_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgEqualTo(String value) {
            addCriterion("GNTY_REG_ORG =", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgNotEqualTo(String value) {
            addCriterion("GNTY_REG_ORG <>", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgGreaterThan(String value) {
            addCriterion("GNTY_REG_ORG >", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_REG_ORG >=", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgLessThan(String value) {
            addCriterion("GNTY_REG_ORG <", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgLessThanOrEqualTo(String value) {
            addCriterion("GNTY_REG_ORG <=", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgLike(String value) {
            addCriterion("GNTY_REG_ORG like", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgNotLike(String value) {
            addCriterion("GNTY_REG_ORG not like", value, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgIn(List<String> values) {
            addCriterion("GNTY_REG_ORG in", values, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgNotIn(List<String> values) {
            addCriterion("GNTY_REG_ORG not in", values, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgBetween(String value1, String value2) {
            addCriterion("GNTY_REG_ORG between", value1, value2, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegOrgNotBetween(String value1, String value2) {
            addCriterion("GNTY_REG_ORG not between", value1, value2, "gntyRegOrg");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtIsNull() {
            addCriterion("GNTY_REG_DT is null");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtIsNotNull() {
            addCriterion("GNTY_REG_DT is not null");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtEqualTo(String value) {
            addCriterion("GNTY_REG_DT =", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtNotEqualTo(String value) {
            addCriterion("GNTY_REG_DT <>", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtGreaterThan(String value) {
            addCriterion("GNTY_REG_DT >", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_REG_DT >=", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtLessThan(String value) {
            addCriterion("GNTY_REG_DT <", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtLessThanOrEqualTo(String value) {
            addCriterion("GNTY_REG_DT <=", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtLike(String value) {
            addCriterion("GNTY_REG_DT like", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtNotLike(String value) {
            addCriterion("GNTY_REG_DT not like", value, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtIn(List<String> values) {
            addCriterion("GNTY_REG_DT in", values, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtNotIn(List<String> values) {
            addCriterion("GNTY_REG_DT not in", values, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtBetween(String value1, String value2) {
            addCriterion("GNTY_REG_DT between", value1, value2, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyRegDtNotBetween(String value1, String value2) {
            addCriterion("GNTY_REG_DT not between", value1, value2, "gntyRegDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtIsNull() {
            addCriterion("GNTY_WO_DT is null");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtIsNotNull() {
            addCriterion("GNTY_WO_DT is not null");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtEqualTo(String value) {
            addCriterion("GNTY_WO_DT =", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtNotEqualTo(String value) {
            addCriterion("GNTY_WO_DT <>", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtGreaterThan(String value) {
            addCriterion("GNTY_WO_DT >", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtGreaterThanOrEqualTo(String value) {
            addCriterion("GNTY_WO_DT >=", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtLessThan(String value) {
            addCriterion("GNTY_WO_DT <", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtLessThanOrEqualTo(String value) {
            addCriterion("GNTY_WO_DT <=", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtLike(String value) {
            addCriterion("GNTY_WO_DT like", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtNotLike(String value) {
            addCriterion("GNTY_WO_DT not like", value, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtIn(List<String> values) {
            addCriterion("GNTY_WO_DT in", values, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtNotIn(List<String> values) {
            addCriterion("GNTY_WO_DT not in", values, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtBetween(String value1, String value2) {
            addCriterion("GNTY_WO_DT between", value1, value2, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andGntyWoDtNotBetween(String value1, String value2) {
            addCriterion("GNTY_WO_DT not between", value1, value2, "gntyWoDt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtIsNull() {
            addCriterion("ABT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAbtAmtIsNotNull() {
            addCriterion("ABT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAbtAmtEqualTo(BigDecimal value) {
            addCriterion("ABT_AMT =", value, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtNotEqualTo(BigDecimal value) {
            addCriterion("ABT_AMT <>", value, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtGreaterThan(BigDecimal value) {
            addCriterion("ABT_AMT >", value, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_AMT >=", value, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtLessThan(BigDecimal value) {
            addCriterion("ABT_AMT <", value, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_AMT <=", value, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtIn(List<BigDecimal> values) {
            addCriterion("ABT_AMT in", values, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtNotIn(List<BigDecimal> values) {
            addCriterion("ABT_AMT not in", values, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_AMT between", value1, value2, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_AMT not between", value1, value2, "abtAmt");
            return (Criteria) this;
        }

        public Criteria andAbtSum1IsNull() {
            addCriterion("ABT_SUM1 is null");
            return (Criteria) this;
        }

        public Criteria andAbtSum1IsNotNull() {
            addCriterion("ABT_SUM1 is not null");
            return (Criteria) this;
        }

        public Criteria andAbtSum1EqualTo(BigDecimal value) {
            addCriterion("ABT_SUM1 =", value, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1NotEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM1 <>", value, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1GreaterThan(BigDecimal value) {
            addCriterion("ABT_SUM1 >", value, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM1 >=", value, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1LessThan(BigDecimal value) {
            addCriterion("ABT_SUM1 <", value, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM1 <=", value, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1In(List<BigDecimal> values) {
            addCriterion("ABT_SUM1 in", values, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1NotIn(List<BigDecimal> values) {
            addCriterion("ABT_SUM1 not in", values, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_SUM1 between", value1, value2, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_SUM1 not between", value1, value2, "abtSum1");
            return (Criteria) this;
        }

        public Criteria andAbtSum2IsNull() {
            addCriterion("ABT_SUM2 is null");
            return (Criteria) this;
        }

        public Criteria andAbtSum2IsNotNull() {
            addCriterion("ABT_SUM2 is not null");
            return (Criteria) this;
        }

        public Criteria andAbtSum2EqualTo(BigDecimal value) {
            addCriterion("ABT_SUM2 =", value, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2NotEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM2 <>", value, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2GreaterThan(BigDecimal value) {
            addCriterion("ABT_SUM2 >", value, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM2 >=", value, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2LessThan(BigDecimal value) {
            addCriterion("ABT_SUM2 <", value, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM2 <=", value, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2In(List<BigDecimal> values) {
            addCriterion("ABT_SUM2 in", values, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2NotIn(List<BigDecimal> values) {
            addCriterion("ABT_SUM2 not in", values, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_SUM2 between", value1, value2, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_SUM2 not between", value1, value2, "abtSum2");
            return (Criteria) this;
        }

        public Criteria andAbtSum3IsNull() {
            addCriterion("ABT_SUM3 is null");
            return (Criteria) this;
        }

        public Criteria andAbtSum3IsNotNull() {
            addCriterion("ABT_SUM3 is not null");
            return (Criteria) this;
        }

        public Criteria andAbtSum3EqualTo(BigDecimal value) {
            addCriterion("ABT_SUM3 =", value, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3NotEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM3 <>", value, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3GreaterThan(BigDecimal value) {
            addCriterion("ABT_SUM3 >", value, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM3 >=", value, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3LessThan(BigDecimal value) {
            addCriterion("ABT_SUM3 <", value, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_SUM3 <=", value, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3In(List<BigDecimal> values) {
            addCriterion("ABT_SUM3 in", values, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3NotIn(List<BigDecimal> values) {
            addCriterion("ABT_SUM3 not in", values, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_SUM3 between", value1, value2, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtSum3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_SUM3 not between", value1, value2, "abtSum3");
            return (Criteria) this;
        }

        public Criteria andAbtRateIsNull() {
            addCriterion("ABT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andAbtRateIsNotNull() {
            addCriterion("ABT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andAbtRateEqualTo(BigDecimal value) {
            addCriterion("ABT_RATE =", value, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateNotEqualTo(BigDecimal value) {
            addCriterion("ABT_RATE <>", value, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateGreaterThan(BigDecimal value) {
            addCriterion("ABT_RATE >", value, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_RATE >=", value, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateLessThan(BigDecimal value) {
            addCriterion("ABT_RATE <", value, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ABT_RATE <=", value, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateIn(List<BigDecimal> values) {
            addCriterion("ABT_RATE in", values, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateNotIn(List<BigDecimal> values) {
            addCriterion("ABT_RATE not in", values, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_RATE between", value1, value2, "abtRate");
            return (Criteria) this;
        }

        public Criteria andAbtRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ABT_RATE not between", value1, value2, "abtRate");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoIsNull() {
            addCriterion("OT_RTN_NO is null");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoIsNotNull() {
            addCriterion("OT_RTN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoEqualTo(String value) {
            addCriterion("OT_RTN_NO =", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoNotEqualTo(String value) {
            addCriterion("OT_RTN_NO <>", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoGreaterThan(String value) {
            addCriterion("OT_RTN_NO >", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoGreaterThanOrEqualTo(String value) {
            addCriterion("OT_RTN_NO >=", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoLessThan(String value) {
            addCriterion("OT_RTN_NO <", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoLessThanOrEqualTo(String value) {
            addCriterion("OT_RTN_NO <=", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoLike(String value) {
            addCriterion("OT_RTN_NO like", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoNotLike(String value) {
            addCriterion("OT_RTN_NO not like", value, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoIn(List<String> values) {
            addCriterion("OT_RTN_NO in", values, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoNotIn(List<String> values) {
            addCriterion("OT_RTN_NO not in", values, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoBetween(String value1, String value2) {
            addCriterion("OT_RTN_NO between", value1, value2, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andOtRtnNoNotBetween(String value1, String value2) {
            addCriterion("OT_RTN_NO not between", value1, value2, "otRtnNo");
            return (Criteria) this;
        }

        public Criteria andFlg1IsNull() {
            addCriterion("FLG1 is null");
            return (Criteria) this;
        }

        public Criteria andFlg1IsNotNull() {
            addCriterion("FLG1 is not null");
            return (Criteria) this;
        }

        public Criteria andFlg1EqualTo(String value) {
            addCriterion("FLG1 =", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotEqualTo(String value) {
            addCriterion("FLG1 <>", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1GreaterThan(String value) {
            addCriterion("FLG1 >", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1GreaterThanOrEqualTo(String value) {
            addCriterion("FLG1 >=", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1LessThan(String value) {
            addCriterion("FLG1 <", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1LessThanOrEqualTo(String value) {
            addCriterion("FLG1 <=", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1Like(String value) {
            addCriterion("FLG1 like", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotLike(String value) {
            addCriterion("FLG1 not like", value, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1In(List<String> values) {
            addCriterion("FLG1 in", values, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotIn(List<String> values) {
            addCriterion("FLG1 not in", values, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1Between(String value1, String value2) {
            addCriterion("FLG1 between", value1, value2, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg1NotBetween(String value1, String value2) {
            addCriterion("FLG1 not between", value1, value2, "flg1");
            return (Criteria) this;
        }

        public Criteria andFlg2IsNull() {
            addCriterion("FLG2 is null");
            return (Criteria) this;
        }

        public Criteria andFlg2IsNotNull() {
            addCriterion("FLG2 is not null");
            return (Criteria) this;
        }

        public Criteria andFlg2EqualTo(String value) {
            addCriterion("FLG2 =", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotEqualTo(String value) {
            addCriterion("FLG2 <>", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2GreaterThan(String value) {
            addCriterion("FLG2 >", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2GreaterThanOrEqualTo(String value) {
            addCriterion("FLG2 >=", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2LessThan(String value) {
            addCriterion("FLG2 <", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2LessThanOrEqualTo(String value) {
            addCriterion("FLG2 <=", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2Like(String value) {
            addCriterion("FLG2 like", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotLike(String value) {
            addCriterion("FLG2 not like", value, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2In(List<String> values) {
            addCriterion("FLG2 in", values, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotIn(List<String> values) {
            addCriterion("FLG2 not in", values, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2Between(String value1, String value2) {
            addCriterion("FLG2 between", value1, value2, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg2NotBetween(String value1, String value2) {
            addCriterion("FLG2 not between", value1, value2, "flg2");
            return (Criteria) this;
        }

        public Criteria andFlg3IsNull() {
            addCriterion("FLG3 is null");
            return (Criteria) this;
        }

        public Criteria andFlg3IsNotNull() {
            addCriterion("FLG3 is not null");
            return (Criteria) this;
        }

        public Criteria andFlg3EqualTo(String value) {
            addCriterion("FLG3 =", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3NotEqualTo(String value) {
            addCriterion("FLG3 <>", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3GreaterThan(String value) {
            addCriterion("FLG3 >", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3GreaterThanOrEqualTo(String value) {
            addCriterion("FLG3 >=", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3LessThan(String value) {
            addCriterion("FLG3 <", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3LessThanOrEqualTo(String value) {
            addCriterion("FLG3 <=", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3Like(String value) {
            addCriterion("FLG3 like", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3NotLike(String value) {
            addCriterion("FLG3 not like", value, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3In(List<String> values) {
            addCriterion("FLG3 in", values, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3NotIn(List<String> values) {
            addCriterion("FLG3 not in", values, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3Between(String value1, String value2) {
            addCriterion("FLG3 between", value1, value2, "flg3");
            return (Criteria) this;
        }

        public Criteria andFlg3NotBetween(String value1, String value2) {
            addCriterion("FLG3 not between", value1, value2, "flg3");
            return (Criteria) this;
        }

        public Criteria andIfrmBakIsNull() {
            addCriterion("IFRM_BAK is null");
            return (Criteria) this;
        }

        public Criteria andIfrmBakIsNotNull() {
            addCriterion("IFRM_BAK is not null");
            return (Criteria) this;
        }

        public Criteria andIfrmBakEqualTo(String value) {
            addCriterion("IFRM_BAK =", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakNotEqualTo(String value) {
            addCriterion("IFRM_BAK <>", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakGreaterThan(String value) {
            addCriterion("IFRM_BAK >", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakGreaterThanOrEqualTo(String value) {
            addCriterion("IFRM_BAK >=", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakLessThan(String value) {
            addCriterion("IFRM_BAK <", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakLessThanOrEqualTo(String value) {
            addCriterion("IFRM_BAK <=", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakLike(String value) {
            addCriterion("IFRM_BAK like", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakNotLike(String value) {
            addCriterion("IFRM_BAK not like", value, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakIn(List<String> values) {
            addCriterion("IFRM_BAK in", values, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakNotIn(List<String> values) {
            addCriterion("IFRM_BAK not in", values, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakBetween(String value1, String value2) {
            addCriterion("IFRM_BAK between", value1, value2, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andIfrmBakNotBetween(String value1, String value2) {
            addCriterion("IFRM_BAK not between", value1, value2, "ifrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakIsNull() {
            addCriterion("CFRM_BAK is null");
            return (Criteria) this;
        }

        public Criteria andCfrmBakIsNotNull() {
            addCriterion("CFRM_BAK is not null");
            return (Criteria) this;
        }

        public Criteria andCfrmBakEqualTo(String value) {
            addCriterion("CFRM_BAK =", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakNotEqualTo(String value) {
            addCriterion("CFRM_BAK <>", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakGreaterThan(String value) {
            addCriterion("CFRM_BAK >", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakGreaterThanOrEqualTo(String value) {
            addCriterion("CFRM_BAK >=", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakLessThan(String value) {
            addCriterion("CFRM_BAK <", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakLessThanOrEqualTo(String value) {
            addCriterion("CFRM_BAK <=", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakLike(String value) {
            addCriterion("CFRM_BAK like", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakNotLike(String value) {
            addCriterion("CFRM_BAK not like", value, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakIn(List<String> values) {
            addCriterion("CFRM_BAK in", values, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakNotIn(List<String> values) {
            addCriterion("CFRM_BAK not in", values, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakBetween(String value1, String value2) {
            addCriterion("CFRM_BAK between", value1, value2, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andCfrmBakNotBetween(String value1, String value2) {
            addCriterion("CFRM_BAK not between", value1, value2, "cfrmBak");
            return (Criteria) this;
        }

        public Criteria andAbtNmIsNull() {
            addCriterion("ABT_NM is null");
            return (Criteria) this;
        }

        public Criteria andAbtNmIsNotNull() {
            addCriterion("ABT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andAbtNmEqualTo(String value) {
            addCriterion("ABT_NM =", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmNotEqualTo(String value) {
            addCriterion("ABT_NM <>", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmGreaterThan(String value) {
            addCriterion("ABT_NM >", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmGreaterThanOrEqualTo(String value) {
            addCriterion("ABT_NM >=", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmLessThan(String value) {
            addCriterion("ABT_NM <", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmLessThanOrEqualTo(String value) {
            addCriterion("ABT_NM <=", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmLike(String value) {
            addCriterion("ABT_NM like", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmNotLike(String value) {
            addCriterion("ABT_NM not like", value, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmIn(List<String> values) {
            addCriterion("ABT_NM in", values, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmNotIn(List<String> values) {
            addCriterion("ABT_NM not in", values, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmBetween(String value1, String value2) {
            addCriterion("ABT_NM between", value1, value2, "abtNm");
            return (Criteria) this;
        }

        public Criteria andAbtNmNotBetween(String value1, String value2) {
            addCriterion("ABT_NM not between", value1, value2, "abtNm");
            return (Criteria) this;
        }

        public Criteria andPayNmIsNull() {
            addCriterion("PAY_NM is null");
            return (Criteria) this;
        }

        public Criteria andPayNmIsNotNull() {
            addCriterion("PAY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andPayNmEqualTo(String value) {
            addCriterion("PAY_NM =", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmNotEqualTo(String value) {
            addCriterion("PAY_NM <>", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmGreaterThan(String value) {
            addCriterion("PAY_NM >", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_NM >=", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmLessThan(String value) {
            addCriterion("PAY_NM <", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmLessThanOrEqualTo(String value) {
            addCriterion("PAY_NM <=", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmLike(String value) {
            addCriterion("PAY_NM like", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmNotLike(String value) {
            addCriterion("PAY_NM not like", value, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmIn(List<String> values) {
            addCriterion("PAY_NM in", values, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmNotIn(List<String> values) {
            addCriterion("PAY_NM not in", values, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmBetween(String value1, String value2) {
            addCriterion("PAY_NM between", value1, value2, "payNm");
            return (Criteria) this;
        }

        public Criteria andPayNmNotBetween(String value1, String value2) {
            addCriterion("PAY_NM not between", value1, value2, "payNm");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaIsNull() {
            addCriterion("CFRM_AREA is null");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaIsNotNull() {
            addCriterion("CFRM_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaEqualTo(String value) {
            addCriterion("CFRM_AREA =", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaNotEqualTo(String value) {
            addCriterion("CFRM_AREA <>", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaGreaterThan(String value) {
            addCriterion("CFRM_AREA >", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaGreaterThanOrEqualTo(String value) {
            addCriterion("CFRM_AREA >=", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaLessThan(String value) {
            addCriterion("CFRM_AREA <", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaLessThanOrEqualTo(String value) {
            addCriterion("CFRM_AREA <=", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaLike(String value) {
            addCriterion("CFRM_AREA like", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaNotLike(String value) {
            addCriterion("CFRM_AREA not like", value, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaIn(List<String> values) {
            addCriterion("CFRM_AREA in", values, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaNotIn(List<String> values) {
            addCriterion("CFRM_AREA not in", values, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaBetween(String value1, String value2) {
            addCriterion("CFRM_AREA between", value1, value2, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andCfrmAreaNotBetween(String value1, String value2) {
            addCriterion("CFRM_AREA not between", value1, value2, "cfrmArea");
            return (Criteria) this;
        }

        public Criteria andSapVchTypIsNull() {
            addCriterion("SAP_VCH_TYP is null");
            return (Criteria) this;
        }

        public Criteria andSapVchTypIsNotNull() {
            addCriterion("SAP_VCH_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andSapVchTypEqualTo(String value) {
            addCriterion("SAP_VCH_TYP =", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypNotEqualTo(String value) {
            addCriterion("SAP_VCH_TYP <>", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypGreaterThan(String value) {
            addCriterion("SAP_VCH_TYP >", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypGreaterThanOrEqualTo(String value) {
            addCriterion("SAP_VCH_TYP >=", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypLessThan(String value) {
            addCriterion("SAP_VCH_TYP <", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypLessThanOrEqualTo(String value) {
            addCriterion("SAP_VCH_TYP <=", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypLike(String value) {
            addCriterion("SAP_VCH_TYP like", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypNotLike(String value) {
            addCriterion("SAP_VCH_TYP not like", value, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypIn(List<String> values) {
            addCriterion("SAP_VCH_TYP in", values, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypNotIn(List<String> values) {
            addCriterion("SAP_VCH_TYP not in", values, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypBetween(String value1, String value2) {
            addCriterion("SAP_VCH_TYP between", value1, value2, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andSapVchTypNotBetween(String value1, String value2) {
            addCriterion("SAP_VCH_TYP not between", value1, value2, "sapVchTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypIsNull() {
            addCriterion("ABT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andAbtTypIsNotNull() {
            addCriterion("ABT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andAbtTypEqualTo(String value) {
            addCriterion("ABT_TYP =", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypNotEqualTo(String value) {
            addCriterion("ABT_TYP <>", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypGreaterThan(String value) {
            addCriterion("ABT_TYP >", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypGreaterThanOrEqualTo(String value) {
            addCriterion("ABT_TYP >=", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypLessThan(String value) {
            addCriterion("ABT_TYP <", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypLessThanOrEqualTo(String value) {
            addCriterion("ABT_TYP <=", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypLike(String value) {
            addCriterion("ABT_TYP like", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypNotLike(String value) {
            addCriterion("ABT_TYP not like", value, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypIn(List<String> values) {
            addCriterion("ABT_TYP in", values, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypNotIn(List<String> values) {
            addCriterion("ABT_TYP not in", values, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypBetween(String value1, String value2) {
            addCriterion("ABT_TYP between", value1, value2, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andAbtTypNotBetween(String value1, String value2) {
            addCriterion("ABT_TYP not between", value1, value2, "abtTyp");
            return (Criteria) this;
        }

        public Criteria andRemIsNull() {
            addCriterion("REM is null");
            return (Criteria) this;
        }

        public Criteria andRemIsNotNull() {
            addCriterion("REM is not null");
            return (Criteria) this;
        }

        public Criteria andRemEqualTo(String value) {
            addCriterion("REM =", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotEqualTo(String value) {
            addCriterion("REM <>", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThan(String value) {
            addCriterion("REM >", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThanOrEqualTo(String value) {
            addCriterion("REM >=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThan(String value) {
            addCriterion("REM <", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThanOrEqualTo(String value) {
            addCriterion("REM <=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLike(String value) {
            addCriterion("REM like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotLike(String value) {
            addCriterion("REM not like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemIn(List<String> values) {
            addCriterion("REM in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotIn(List<String> values) {
            addCriterion("REM not in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemBetween(String value1, String value2) {
            addCriterion("REM between", value1, value2, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotBetween(String value1, String value2) {
            addCriterion("REM not between", value1, value2, "rem");
            return (Criteria) this;
        }

        public Criteria andTlrNoIsNull() {
            addCriterion("TLR_NO is null");
            return (Criteria) this;
        }

        public Criteria andTlrNoIsNotNull() {
            addCriterion("TLR_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTlrNoEqualTo(String value) {
            addCriterion("TLR_NO =", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotEqualTo(String value) {
            addCriterion("TLR_NO <>", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoGreaterThan(String value) {
            addCriterion("TLR_NO >", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoGreaterThanOrEqualTo(String value) {
            addCriterion("TLR_NO >=", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLessThan(String value) {
            addCriterion("TLR_NO <", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLessThanOrEqualTo(String value) {
            addCriterion("TLR_NO <=", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoLike(String value) {
            addCriterion("TLR_NO like", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotLike(String value) {
            addCriterion("TLR_NO not like", value, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoIn(List<String> values) {
            addCriterion("TLR_NO in", values, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotIn(List<String> values) {
            addCriterion("TLR_NO not in", values, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoBetween(String value1, String value2) {
            addCriterion("TLR_NO between", value1, value2, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNoNotBetween(String value1, String value2) {
            addCriterion("TLR_NO not between", value1, value2, "tlrNo");
            return (Criteria) this;
        }

        public Criteria andTlrNmIsNull() {
            addCriterion("TLR_NM is null");
            return (Criteria) this;
        }

        public Criteria andTlrNmIsNotNull() {
            addCriterion("TLR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andTlrNmEqualTo(String value) {
            addCriterion("TLR_NM =", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotEqualTo(String value) {
            addCriterion("TLR_NM <>", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmGreaterThan(String value) {
            addCriterion("TLR_NM >", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmGreaterThanOrEqualTo(String value) {
            addCriterion("TLR_NM >=", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLessThan(String value) {
            addCriterion("TLR_NM <", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLessThanOrEqualTo(String value) {
            addCriterion("TLR_NM <=", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmLike(String value) {
            addCriterion("TLR_NM like", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotLike(String value) {
            addCriterion("TLR_NM not like", value, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmIn(List<String> values) {
            addCriterion("TLR_NM in", values, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotIn(List<String> values) {
            addCriterion("TLR_NM not in", values, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmBetween(String value1, String value2) {
            addCriterion("TLR_NM between", value1, value2, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andTlrNmNotBetween(String value1, String value2) {
            addCriterion("TLR_NM not between", value1, value2, "tlrNm");
            return (Criteria) this;
        }

        public Criteria andBrCdIsNull() {
            addCriterion("BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andBrCdIsNotNull() {
            addCriterion("BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andBrCdEqualTo(String value) {
            addCriterion("BR_CD =", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotEqualTo(String value) {
            addCriterion("BR_CD <>", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdGreaterThan(String value) {
            addCriterion("BR_CD >", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("BR_CD >=", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLessThan(String value) {
            addCriterion("BR_CD <", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLessThanOrEqualTo(String value) {
            addCriterion("BR_CD <=", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdLike(String value) {
            addCriterion("BR_CD like", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotLike(String value) {
            addCriterion("BR_CD not like", value, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdIn(List<String> values) {
            addCriterion("BR_CD in", values, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotIn(List<String> values) {
            addCriterion("BR_CD not in", values, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdBetween(String value1, String value2) {
            addCriterion("BR_CD between", value1, value2, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrCdNotBetween(String value1, String value2) {
            addCriterion("BR_CD not between", value1, value2, "brCd");
            return (Criteria) this;
        }

        public Criteria andBrNmIsNull() {
            addCriterion("BR_NM is null");
            return (Criteria) this;
        }

        public Criteria andBrNmIsNotNull() {
            addCriterion("BR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andBrNmEqualTo(String value) {
            addCriterion("BR_NM =", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotEqualTo(String value) {
            addCriterion("BR_NM <>", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmGreaterThan(String value) {
            addCriterion("BR_NM >", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmGreaterThanOrEqualTo(String value) {
            addCriterion("BR_NM >=", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLessThan(String value) {
            addCriterion("BR_NM <", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLessThanOrEqualTo(String value) {
            addCriterion("BR_NM <=", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmLike(String value) {
            addCriterion("BR_NM like", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotLike(String value) {
            addCriterion("BR_NM not like", value, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmIn(List<String> values) {
            addCriterion("BR_NM in", values, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotIn(List<String> values) {
            addCriterion("BR_NM not in", values, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmBetween(String value1, String value2) {
            addCriterion("BR_NM between", value1, value2, "brNm");
            return (Criteria) this;
        }

        public Criteria andBrNmNotBetween(String value1, String value2) {
            addCriterion("BR_NM not between", value1, value2, "brNm");
            return (Criteria) this;
        }

        public Criteria andInpDtIsNull() {
            addCriterion("INP_DT is null");
            return (Criteria) this;
        }

        public Criteria andInpDtIsNotNull() {
            addCriterion("INP_DT is not null");
            return (Criteria) this;
        }

        public Criteria andInpDtEqualTo(String value) {
            addCriterion("INP_DT =", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotEqualTo(String value) {
            addCriterion("INP_DT <>", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtGreaterThan(String value) {
            addCriterion("INP_DT >", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtGreaterThanOrEqualTo(String value) {
            addCriterion("INP_DT >=", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLessThan(String value) {
            addCriterion("INP_DT <", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLessThanOrEqualTo(String value) {
            addCriterion("INP_DT <=", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtLike(String value) {
            addCriterion("INP_DT like", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotLike(String value) {
            addCriterion("INP_DT not like", value, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtIn(List<String> values) {
            addCriterion("INP_DT in", values, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotIn(List<String> values) {
            addCriterion("INP_DT not in", values, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtBetween(String value1, String value2) {
            addCriterion("INP_DT between", value1, value2, "inpDt");
            return (Criteria) this;
        }

        public Criteria andInpDtNotBetween(String value1, String value2) {
            addCriterion("INP_DT not between", value1, value2, "inpDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrIsNull() {
            addCriterion("LST_UPD_TLR is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrIsNotNull() {
            addCriterion("LST_UPD_TLR is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrEqualTo(String value) {
            addCriterion("LST_UPD_TLR =", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotEqualTo(String value) {
            addCriterion("LST_UPD_TLR <>", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrGreaterThan(String value) {
            addCriterion("LST_UPD_TLR >", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR >=", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrLessThan(String value) {
            addCriterion("LST_UPD_TLR <", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR <=", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrLike(String value) {
            addCriterion("LST_UPD_TLR like", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotLike(String value) {
            addCriterion("LST_UPD_TLR not like", value, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrIn(List<String> values) {
            addCriterion("LST_UPD_TLR in", values, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotIn(List<String> values) {
            addCriterion("LST_UPD_TLR not in", values, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR between", value1, value2, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR not between", value1, value2, "lstUpdTlr");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmIsNull() {
            addCriterion("LST_UPD_TLR_NM is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmIsNotNull() {
            addCriterion("LST_UPD_TLR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM =", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM <>", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmGreaterThan(String value) {
            addCriterion("LST_UPD_TLR_NM >", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM >=", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmLessThan(String value) {
            addCriterion("LST_UPD_TLR_NM <", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_TLR_NM <=", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmLike(String value) {
            addCriterion("LST_UPD_TLR_NM like", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotLike(String value) {
            addCriterion("LST_UPD_TLR_NM not like", value, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmIn(List<String> values) {
            addCriterion("LST_UPD_TLR_NM in", values, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotIn(List<String> values) {
            addCriterion("LST_UPD_TLR_NM not in", values, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR_NM between", value1, value2, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdTlrNmNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_TLR_NM not between", value1, value2, "lstUpdTlrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdIsNull() {
            addCriterion("LST_UPD_BR_CD is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdIsNotNull() {
            addCriterion("LST_UPD_BR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD =", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD <>", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdGreaterThan(String value) {
            addCriterion("LST_UPD_BR_CD >", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD >=", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdLessThan(String value) {
            addCriterion("LST_UPD_BR_CD <", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_CD <=", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdLike(String value) {
            addCriterion("LST_UPD_BR_CD like", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotLike(String value) {
            addCriterion("LST_UPD_BR_CD not like", value, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdIn(List<String> values) {
            addCriterion("LST_UPD_BR_CD in", values, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotIn(List<String> values) {
            addCriterion("LST_UPD_BR_CD not in", values, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_CD between", value1, value2, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrCdNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_CD not between", value1, value2, "lstUpdBrCd");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmIsNull() {
            addCriterion("LST_UPD_BR_NM is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmIsNotNull() {
            addCriterion("LST_UPD_BR_NM is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM =", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM <>", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmGreaterThan(String value) {
            addCriterion("LST_UPD_BR_NM >", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM >=", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmLessThan(String value) {
            addCriterion("LST_UPD_BR_NM <", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_BR_NM <=", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmLike(String value) {
            addCriterion("LST_UPD_BR_NM like", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotLike(String value) {
            addCriterion("LST_UPD_BR_NM not like", value, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmIn(List<String> values) {
            addCriterion("LST_UPD_BR_NM in", values, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotIn(List<String> values) {
            addCriterion("LST_UPD_BR_NM not in", values, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_NM between", value1, value2, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdBrNmNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_BR_NM not between", value1, value2, "lstUpdBrNm");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtIsNull() {
            addCriterion("LST_UPD_DT is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtIsNotNull() {
            addCriterion("LST_UPD_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtEqualTo(String value) {
            addCriterion("LST_UPD_DT =", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotEqualTo(String value) {
            addCriterion("LST_UPD_DT <>", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtGreaterThan(String value) {
            addCriterion("LST_UPD_DT >", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtGreaterThanOrEqualTo(String value) {
            addCriterion("LST_UPD_DT >=", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtLessThan(String value) {
            addCriterion("LST_UPD_DT <", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtLessThanOrEqualTo(String value) {
            addCriterion("LST_UPD_DT <=", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtLike(String value) {
            addCriterion("LST_UPD_DT like", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotLike(String value) {
            addCriterion("LST_UPD_DT not like", value, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtIn(List<String> values) {
            addCriterion("LST_UPD_DT in", values, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotIn(List<String> values) {
            addCriterion("LST_UPD_DT not in", values, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtBetween(String value1, String value2) {
            addCriterion("LST_UPD_DT between", value1, value2, "lstUpdDt");
            return (Criteria) this;
        }

        public Criteria andLstUpdDtNotBetween(String value1, String value2) {
            addCriterion("LST_UPD_DT not between", value1, value2, "lstUpdDt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}