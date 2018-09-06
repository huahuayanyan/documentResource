package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCrrEqptInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCrrEqptInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCrrEqptInfoExample(BCrrEqptInfoExample example) {
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

        public Criteria andEqptIdIsNull() {
            addCriterion("EQPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andEqptIdIsNotNull() {
            addCriterion("EQPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEqptIdEqualTo(String value) {
            addCriterion("EQPT_ID =", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdNotEqualTo(String value) {
            addCriterion("EQPT_ID <>", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdGreaterThan(String value) {
            addCriterion("EQPT_ID >", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdGreaterThanOrEqualTo(String value) {
            addCriterion("EQPT_ID >=", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdLessThan(String value) {
            addCriterion("EQPT_ID <", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdLessThanOrEqualTo(String value) {
            addCriterion("EQPT_ID <=", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdLike(String value) {
            addCriterion("EQPT_ID like", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdNotLike(String value) {
            addCriterion("EQPT_ID not like", value, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdIn(List<String> values) {
            addCriterion("EQPT_ID in", values, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdNotIn(List<String> values) {
            addCriterion("EQPT_ID not in", values, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdBetween(String value1, String value2) {
            addCriterion("EQPT_ID between", value1, value2, "eqptId");
            return (Criteria) this;
        }

        public Criteria andEqptIdNotBetween(String value1, String value2) {
            addCriterion("EQPT_ID not between", value1, value2, "eqptId");
            return (Criteria) this;
        }

        public Criteria andRelaTypIsNull() {
            addCriterion("RELA_TYP is null");
            return (Criteria) this;
        }

        public Criteria andRelaTypIsNotNull() {
            addCriterion("RELA_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andRelaTypEqualTo(String value) {
            addCriterion("RELA_TYP =", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotEqualTo(String value) {
            addCriterion("RELA_TYP <>", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypGreaterThan(String value) {
            addCriterion("RELA_TYP >", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_TYP >=", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLessThan(String value) {
            addCriterion("RELA_TYP <", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLessThanOrEqualTo(String value) {
            addCriterion("RELA_TYP <=", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypLike(String value) {
            addCriterion("RELA_TYP like", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotLike(String value) {
            addCriterion("RELA_TYP not like", value, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypIn(List<String> values) {
            addCriterion("RELA_TYP in", values, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotIn(List<String> values) {
            addCriterion("RELA_TYP not in", values, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypBetween(String value1, String value2) {
            addCriterion("RELA_TYP between", value1, value2, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaTypNotBetween(String value1, String value2) {
            addCriterion("RELA_TYP not between", value1, value2, "relaTyp");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNull() {
            addCriterion("RELA_NO is null");
            return (Criteria) this;
        }

        public Criteria andRelaNoIsNotNull() {
            addCriterion("RELA_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRelaNoEqualTo(String value) {
            addCriterion("RELA_NO =", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotEqualTo(String value) {
            addCriterion("RELA_NO <>", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThan(String value) {
            addCriterion("RELA_NO >", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_NO >=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThan(String value) {
            addCriterion("RELA_NO <", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLessThanOrEqualTo(String value) {
            addCriterion("RELA_NO <=", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoLike(String value) {
            addCriterion("RELA_NO like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotLike(String value) {
            addCriterion("RELA_NO not like", value, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoIn(List<String> values) {
            addCriterion("RELA_NO in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotIn(List<String> values) {
            addCriterion("RELA_NO not in", values, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoBetween(String value1, String value2) {
            addCriterion("RELA_NO between", value1, value2, "relaNo");
            return (Criteria) this;
        }

        public Criteria andRelaNoNotBetween(String value1, String value2) {
            addCriterion("RELA_NO not between", value1, value2, "relaNo");
            return (Criteria) this;
        }

        public Criteria andEqptTypIsNull() {
            addCriterion("EQPT_TYP is null");
            return (Criteria) this;
        }

        public Criteria andEqptTypIsNotNull() {
            addCriterion("EQPT_TYP is not null");
            return (Criteria) this;
        }

        public Criteria andEqptTypEqualTo(String value) {
            addCriterion("EQPT_TYP =", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypNotEqualTo(String value) {
            addCriterion("EQPT_TYP <>", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypGreaterThan(String value) {
            addCriterion("EQPT_TYP >", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypGreaterThanOrEqualTo(String value) {
            addCriterion("EQPT_TYP >=", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypLessThan(String value) {
            addCriterion("EQPT_TYP <", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypLessThanOrEqualTo(String value) {
            addCriterion("EQPT_TYP <=", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypLike(String value) {
            addCriterion("EQPT_TYP like", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypNotLike(String value) {
            addCriterion("EQPT_TYP not like", value, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypIn(List<String> values) {
            addCriterion("EQPT_TYP in", values, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypNotIn(List<String> values) {
            addCriterion("EQPT_TYP not in", values, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypBetween(String value1, String value2) {
            addCriterion("EQPT_TYP between", value1, value2, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptTypNotBetween(String value1, String value2) {
            addCriterion("EQPT_TYP not between", value1, value2, "eqptTyp");
            return (Criteria) this;
        }

        public Criteria andEqptNmIsNull() {
            addCriterion("EQPT_NM is null");
            return (Criteria) this;
        }

        public Criteria andEqptNmIsNotNull() {
            addCriterion("EQPT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andEqptNmEqualTo(String value) {
            addCriterion("EQPT_NM =", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmNotEqualTo(String value) {
            addCriterion("EQPT_NM <>", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmGreaterThan(String value) {
            addCriterion("EQPT_NM >", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmGreaterThanOrEqualTo(String value) {
            addCriterion("EQPT_NM >=", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmLessThan(String value) {
            addCriterion("EQPT_NM <", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmLessThanOrEqualTo(String value) {
            addCriterion("EQPT_NM <=", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmLike(String value) {
            addCriterion("EQPT_NM like", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmNotLike(String value) {
            addCriterion("EQPT_NM not like", value, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmIn(List<String> values) {
            addCriterion("EQPT_NM in", values, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmNotIn(List<String> values) {
            addCriterion("EQPT_NM not in", values, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmBetween(String value1, String value2) {
            addCriterion("EQPT_NM between", value1, value2, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andEqptNmNotBetween(String value1, String value2) {
            addCriterion("EQPT_NM not between", value1, value2, "eqptNm");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaIsNull() {
            addCriterion("PRVD_AREA is null");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaIsNotNull() {
            addCriterion("PRVD_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaEqualTo(String value) {
            addCriterion("PRVD_AREA =", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaNotEqualTo(String value) {
            addCriterion("PRVD_AREA <>", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaGreaterThan(String value) {
            addCriterion("PRVD_AREA >", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaGreaterThanOrEqualTo(String value) {
            addCriterion("PRVD_AREA >=", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaLessThan(String value) {
            addCriterion("PRVD_AREA <", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaLessThanOrEqualTo(String value) {
            addCriterion("PRVD_AREA <=", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaLike(String value) {
            addCriterion("PRVD_AREA like", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaNotLike(String value) {
            addCriterion("PRVD_AREA not like", value, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaIn(List<String> values) {
            addCriterion("PRVD_AREA in", values, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaNotIn(List<String> values) {
            addCriterion("PRVD_AREA not in", values, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaBetween(String value1, String value2) {
            addCriterion("PRVD_AREA between", value1, value2, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdAreaNotBetween(String value1, String value2) {
            addCriterion("PRVD_AREA not between", value1, value2, "prvdArea");
            return (Criteria) this;
        }

        public Criteria andPrvdNmIsNull() {
            addCriterion("PRVD_NM is null");
            return (Criteria) this;
        }

        public Criteria andPrvdNmIsNotNull() {
            addCriterion("PRVD_NM is not null");
            return (Criteria) this;
        }

        public Criteria andPrvdNmEqualTo(String value) {
            addCriterion("PRVD_NM =", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmNotEqualTo(String value) {
            addCriterion("PRVD_NM <>", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmGreaterThan(String value) {
            addCriterion("PRVD_NM >", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmGreaterThanOrEqualTo(String value) {
            addCriterion("PRVD_NM >=", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmLessThan(String value) {
            addCriterion("PRVD_NM <", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmLessThanOrEqualTo(String value) {
            addCriterion("PRVD_NM <=", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmLike(String value) {
            addCriterion("PRVD_NM like", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmNotLike(String value) {
            addCriterion("PRVD_NM not like", value, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmIn(List<String> values) {
            addCriterion("PRVD_NM in", values, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmNotIn(List<String> values) {
            addCriterion("PRVD_NM not in", values, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmBetween(String value1, String value2) {
            addCriterion("PRVD_NM between", value1, value2, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andPrvdNmNotBetween(String value1, String value2) {
            addCriterion("PRVD_NM not between", value1, value2, "prvdNm");
            return (Criteria) this;
        }

        public Criteria andFactAreaIsNull() {
            addCriterion("FACT_AREA is null");
            return (Criteria) this;
        }

        public Criteria andFactAreaIsNotNull() {
            addCriterion("FACT_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andFactAreaEqualTo(String value) {
            addCriterion("FACT_AREA =", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaNotEqualTo(String value) {
            addCriterion("FACT_AREA <>", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaGreaterThan(String value) {
            addCriterion("FACT_AREA >", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaGreaterThanOrEqualTo(String value) {
            addCriterion("FACT_AREA >=", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaLessThan(String value) {
            addCriterion("FACT_AREA <", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaLessThanOrEqualTo(String value) {
            addCriterion("FACT_AREA <=", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaLike(String value) {
            addCriterion("FACT_AREA like", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaNotLike(String value) {
            addCriterion("FACT_AREA not like", value, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaIn(List<String> values) {
            addCriterion("FACT_AREA in", values, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaNotIn(List<String> values) {
            addCriterion("FACT_AREA not in", values, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaBetween(String value1, String value2) {
            addCriterion("FACT_AREA between", value1, value2, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactAreaNotBetween(String value1, String value2) {
            addCriterion("FACT_AREA not between", value1, value2, "factArea");
            return (Criteria) this;
        }

        public Criteria andFactNmIsNull() {
            addCriterion("FACT_NM is null");
            return (Criteria) this;
        }

        public Criteria andFactNmIsNotNull() {
            addCriterion("FACT_NM is not null");
            return (Criteria) this;
        }

        public Criteria andFactNmEqualTo(String value) {
            addCriterion("FACT_NM =", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmNotEqualTo(String value) {
            addCriterion("FACT_NM <>", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmGreaterThan(String value) {
            addCriterion("FACT_NM >", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmGreaterThanOrEqualTo(String value) {
            addCriterion("FACT_NM >=", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmLessThan(String value) {
            addCriterion("FACT_NM <", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmLessThanOrEqualTo(String value) {
            addCriterion("FACT_NM <=", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmLike(String value) {
            addCriterion("FACT_NM like", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmNotLike(String value) {
            addCriterion("FACT_NM not like", value, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmIn(List<String> values) {
            addCriterion("FACT_NM in", values, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmNotIn(List<String> values) {
            addCriterion("FACT_NM not in", values, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmBetween(String value1, String value2) {
            addCriterion("FACT_NM between", value1, value2, "factNm");
            return (Criteria) this;
        }

        public Criteria andFactNmNotBetween(String value1, String value2) {
            addCriterion("FACT_NM not between", value1, value2, "factNm");
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

        public Criteria andLatValUeIsNull() {
            addCriterion("LAT_VAL_UE is null");
            return (Criteria) this;
        }

        public Criteria andLatValUeIsNotNull() {
            addCriterion("LAT_VAL_UE is not null");
            return (Criteria) this;
        }

        public Criteria andLatValUeEqualTo(BigDecimal value) {
            addCriterion("LAT_VAL_UE =", value, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeNotEqualTo(BigDecimal value) {
            addCriterion("LAT_VAL_UE <>", value, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeGreaterThan(BigDecimal value) {
            addCriterion("LAT_VAL_UE >", value, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LAT_VAL_UE >=", value, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeLessThan(BigDecimal value) {
            addCriterion("LAT_VAL_UE <", value, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LAT_VAL_UE <=", value, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeIn(List<BigDecimal> values) {
            addCriterion("LAT_VAL_UE in", values, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeNotIn(List<BigDecimal> values) {
            addCriterion("LAT_VAL_UE not in", values, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAT_VAL_UE between", value1, value2, "latValUe");
            return (Criteria) this;
        }

        public Criteria andLatValUeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAT_VAL_UE not between", value1, value2, "latValUe");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}