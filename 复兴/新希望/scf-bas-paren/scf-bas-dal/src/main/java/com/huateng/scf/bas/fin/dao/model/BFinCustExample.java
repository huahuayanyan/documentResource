package com.huateng.scf.bas.fin.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFinCustExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BFinCustExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BFinCustExample(BFinCustExample example) {
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

        public Criteria andFinIdIsNull() {
            addCriterion("FIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andFinIdIsNotNull() {
            addCriterion("FIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFinIdEqualTo(String value) {
            addCriterion("FIN_ID =", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdNotEqualTo(String value) {
            addCriterion("FIN_ID <>", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdGreaterThan(String value) {
            addCriterion("FIN_ID >", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_ID >=", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdLessThan(String value) {
            addCriterion("FIN_ID <", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdLessThanOrEqualTo(String value) {
            addCriterion("FIN_ID <=", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdLike(String value) {
            addCriterion("FIN_ID like", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdNotLike(String value) {
            addCriterion("FIN_ID not like", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdIn(List<String> values) {
            addCriterion("FIN_ID in", values, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdNotIn(List<String> values) {
            addCriterion("FIN_ID not in", values, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdBetween(String value1, String value2) {
            addCriterion("FIN_ID between", value1, value2, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdNotBetween(String value1, String value2) {
            addCriterion("FIN_ID not between", value1, value2, "finId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andFinDtIsNull() {
            addCriterion("FIN_DT is null");
            return (Criteria) this;
        }

        public Criteria andFinDtIsNotNull() {
            addCriterion("FIN_DT is not null");
            return (Criteria) this;
        }

        public Criteria andFinDtEqualTo(String value) {
            addCriterion("FIN_DT =", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotEqualTo(String value) {
            addCriterion("FIN_DT <>", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtGreaterThan(String value) {
            addCriterion("FIN_DT >", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_DT >=", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtLessThan(String value) {
            addCriterion("FIN_DT <", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtLessThanOrEqualTo(String value) {
            addCriterion("FIN_DT <=", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtLike(String value) {
            addCriterion("FIN_DT like", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotLike(String value) {
            addCriterion("FIN_DT not like", value, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtIn(List<String> values) {
            addCriterion("FIN_DT in", values, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotIn(List<String> values) {
            addCriterion("FIN_DT not in", values, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtBetween(String value1, String value2) {
            addCriterion("FIN_DT between", value1, value2, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinDtNotBetween(String value1, String value2) {
            addCriterion("FIN_DT not between", value1, value2, "finDt");
            return (Criteria) this;
        }

        public Criteria andFinScpIsNull() {
            addCriterion("FIN_SCP is null");
            return (Criteria) this;
        }

        public Criteria andFinScpIsNotNull() {
            addCriterion("FIN_SCP is not null");
            return (Criteria) this;
        }

        public Criteria andFinScpEqualTo(String value) {
            addCriterion("FIN_SCP =", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpNotEqualTo(String value) {
            addCriterion("FIN_SCP <>", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpGreaterThan(String value) {
            addCriterion("FIN_SCP >", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_SCP >=", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpLessThan(String value) {
            addCriterion("FIN_SCP <", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpLessThanOrEqualTo(String value) {
            addCriterion("FIN_SCP <=", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpLike(String value) {
            addCriterion("FIN_SCP like", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpNotLike(String value) {
            addCriterion("FIN_SCP not like", value, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpIn(List<String> values) {
            addCriterion("FIN_SCP in", values, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpNotIn(List<String> values) {
            addCriterion("FIN_SCP not in", values, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpBetween(String value1, String value2) {
            addCriterion("FIN_SCP between", value1, value2, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinScpNotBetween(String value1, String value2) {
            addCriterion("FIN_SCP not between", value1, value2, "finScp");
            return (Criteria) this;
        }

        public Criteria andFinPdIsNull() {
            addCriterion("FIN_PD is null");
            return (Criteria) this;
        }

        public Criteria andFinPdIsNotNull() {
            addCriterion("FIN_PD is not null");
            return (Criteria) this;
        }

        public Criteria andFinPdEqualTo(String value) {
            addCriterion("FIN_PD =", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdNotEqualTo(String value) {
            addCriterion("FIN_PD <>", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdGreaterThan(String value) {
            addCriterion("FIN_PD >", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_PD >=", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdLessThan(String value) {
            addCriterion("FIN_PD <", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdLessThanOrEqualTo(String value) {
            addCriterion("FIN_PD <=", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdLike(String value) {
            addCriterion("FIN_PD like", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdNotLike(String value) {
            addCriterion("FIN_PD not like", value, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdIn(List<String> values) {
            addCriterion("FIN_PD in", values, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdNotIn(List<String> values) {
            addCriterion("FIN_PD not in", values, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdBetween(String value1, String value2) {
            addCriterion("FIN_PD between", value1, value2, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinPdNotBetween(String value1, String value2) {
            addCriterion("FIN_PD not between", value1, value2, "finPd");
            return (Criteria) this;
        }

        public Criteria andFinCyIsNull() {
            addCriterion("FIN_CY is null");
            return (Criteria) this;
        }

        public Criteria andFinCyIsNotNull() {
            addCriterion("FIN_CY is not null");
            return (Criteria) this;
        }

        public Criteria andFinCyEqualTo(String value) {
            addCriterion("FIN_CY =", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyNotEqualTo(String value) {
            addCriterion("FIN_CY <>", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyGreaterThan(String value) {
            addCriterion("FIN_CY >", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_CY >=", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyLessThan(String value) {
            addCriterion("FIN_CY <", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyLessThanOrEqualTo(String value) {
            addCriterion("FIN_CY <=", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyLike(String value) {
            addCriterion("FIN_CY like", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyNotLike(String value) {
            addCriterion("FIN_CY not like", value, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyIn(List<String> values) {
            addCriterion("FIN_CY in", values, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyNotIn(List<String> values) {
            addCriterion("FIN_CY not in", values, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyBetween(String value1, String value2) {
            addCriterion("FIN_CY between", value1, value2, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinCyNotBetween(String value1, String value2) {
            addCriterion("FIN_CY not between", value1, value2, "finCy");
            return (Criteria) this;
        }

        public Criteria andFinUnIsNull() {
            addCriterion("FIN_UN is null");
            return (Criteria) this;
        }

        public Criteria andFinUnIsNotNull() {
            addCriterion("FIN_UN is not null");
            return (Criteria) this;
        }

        public Criteria andFinUnEqualTo(String value) {
            addCriterion("FIN_UN =", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnNotEqualTo(String value) {
            addCriterion("FIN_UN <>", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnGreaterThan(String value) {
            addCriterion("FIN_UN >", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnGreaterThanOrEqualTo(String value) {
            addCriterion("FIN_UN >=", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnLessThan(String value) {
            addCriterion("FIN_UN <", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnLessThanOrEqualTo(String value) {
            addCriterion("FIN_UN <=", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnLike(String value) {
            addCriterion("FIN_UN like", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnNotLike(String value) {
            addCriterion("FIN_UN not like", value, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnIn(List<String> values) {
            addCriterion("FIN_UN in", values, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnNotIn(List<String> values) {
            addCriterion("FIN_UN not in", values, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnBetween(String value1, String value2) {
            addCriterion("FIN_UN between", value1, value2, "finUn");
            return (Criteria) this;
        }

        public Criteria andFinUnNotBetween(String value1, String value2) {
            addCriterion("FIN_UN not between", value1, value2, "finUn");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andChkFlgIsNull() {
            addCriterion("CHK_FLG is null");
            return (Criteria) this;
        }

        public Criteria andChkFlgIsNotNull() {
            addCriterion("CHK_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andChkFlgEqualTo(String value) {
            addCriterion("CHK_FLG =", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotEqualTo(String value) {
            addCriterion("CHK_FLG <>", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgGreaterThan(String value) {
            addCriterion("CHK_FLG >", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_FLG >=", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgLessThan(String value) {
            addCriterion("CHK_FLG <", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgLessThanOrEqualTo(String value) {
            addCriterion("CHK_FLG <=", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgLike(String value) {
            addCriterion("CHK_FLG like", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotLike(String value) {
            addCriterion("CHK_FLG not like", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgIn(List<String> values) {
            addCriterion("CHK_FLG in", values, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotIn(List<String> values) {
            addCriterion("CHK_FLG not in", values, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgBetween(String value1, String value2) {
            addCriterion("CHK_FLG between", value1, value2, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotBetween(String value1, String value2) {
            addCriterion("CHK_FLG not between", value1, value2, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgIsNull() {
            addCriterion("AUD_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAudFlgIsNotNull() {
            addCriterion("AUD_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAudFlgEqualTo(String value) {
            addCriterion("AUD_FLG =", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgNotEqualTo(String value) {
            addCriterion("AUD_FLG <>", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgGreaterThan(String value) {
            addCriterion("AUD_FLG >", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgGreaterThanOrEqualTo(String value) {
            addCriterion("AUD_FLG >=", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgLessThan(String value) {
            addCriterion("AUD_FLG <", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgLessThanOrEqualTo(String value) {
            addCriterion("AUD_FLG <=", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgLike(String value) {
            addCriterion("AUD_FLG like", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgNotLike(String value) {
            addCriterion("AUD_FLG not like", value, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgIn(List<String> values) {
            addCriterion("AUD_FLG in", values, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgNotIn(List<String> values) {
            addCriterion("AUD_FLG not in", values, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgBetween(String value1, String value2) {
            addCriterion("AUD_FLG between", value1, value2, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudFlgNotBetween(String value1, String value2) {
            addCriterion("AUD_FLG not between", value1, value2, "audFlg");
            return (Criteria) this;
        }

        public Criteria andAudUnIsNull() {
            addCriterion("AUD_UN is null");
            return (Criteria) this;
        }

        public Criteria andAudUnIsNotNull() {
            addCriterion("AUD_UN is not null");
            return (Criteria) this;
        }

        public Criteria andAudUnEqualTo(String value) {
            addCriterion("AUD_UN =", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnNotEqualTo(String value) {
            addCriterion("AUD_UN <>", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnGreaterThan(String value) {
            addCriterion("AUD_UN >", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnGreaterThanOrEqualTo(String value) {
            addCriterion("AUD_UN >=", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnLessThan(String value) {
            addCriterion("AUD_UN <", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnLessThanOrEqualTo(String value) {
            addCriterion("AUD_UN <=", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnLike(String value) {
            addCriterion("AUD_UN like", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnNotLike(String value) {
            addCriterion("AUD_UN not like", value, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnIn(List<String> values) {
            addCriterion("AUD_UN in", values, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnNotIn(List<String> values) {
            addCriterion("AUD_UN not in", values, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnBetween(String value1, String value2) {
            addCriterion("AUD_UN between", value1, value2, "audUn");
            return (Criteria) this;
        }

        public Criteria andAudUnNotBetween(String value1, String value2) {
            addCriterion("AUD_UN not between", value1, value2, "audUn");
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

        public Criteria andInputDtIsNull() {
            addCriterion("INPUT_DT is null");
            return (Criteria) this;
        }

        public Criteria andInputDtIsNotNull() {
            addCriterion("INPUT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andInputDtEqualTo(String value) {
            addCriterion("INPUT_DT =", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotEqualTo(String value) {
            addCriterion("INPUT_DT <>", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtGreaterThan(String value) {
            addCriterion("INPUT_DT >", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_DT >=", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtLessThan(String value) {
            addCriterion("INPUT_DT <", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtLessThanOrEqualTo(String value) {
            addCriterion("INPUT_DT <=", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtLike(String value) {
            addCriterion("INPUT_DT like", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotLike(String value) {
            addCriterion("INPUT_DT not like", value, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtIn(List<String> values) {
            addCriterion("INPUT_DT in", values, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotIn(List<String> values) {
            addCriterion("INPUT_DT not in", values, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtBetween(String value1, String value2) {
            addCriterion("INPUT_DT between", value1, value2, "inputDt");
            return (Criteria) this;
        }

        public Criteria andInputDtNotBetween(String value1, String value2) {
            addCriterion("INPUT_DT not between", value1, value2, "inputDt");
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

        public Criteria andCustNmIsNull() {
            addCriterion("CUST_NM is null");
            return (Criteria) this;
        }

        public Criteria andCustNmIsNotNull() {
            addCriterion("CUST_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCustNmEqualTo(String value) {
            addCriterion("CUST_NM =", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotEqualTo(String value) {
            addCriterion("CUST_NM <>", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmGreaterThan(String value) {
            addCriterion("CUST_NM >", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NM >=", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmLessThan(String value) {
            addCriterion("CUST_NM <", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmLessThanOrEqualTo(String value) {
            addCriterion("CUST_NM <=", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmLike(String value) {
            addCriterion("CUST_NM like", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotLike(String value) {
            addCriterion("CUST_NM not like", value, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmIn(List<String> values) {
            addCriterion("CUST_NM in", values, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotIn(List<String> values) {
            addCriterion("CUST_NM not in", values, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmBetween(String value1, String value2) {
            addCriterion("CUST_NM between", value1, value2, "custNm");
            return (Criteria) this;
        }

        public Criteria andCustNmNotBetween(String value1, String value2) {
            addCriterion("CUST_NM not between", value1, value2, "custNm");
            return (Criteria) this;
        }

        public Criteria andRptNoIsNull() {
            addCriterion("RPT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRptNoIsNotNull() {
            addCriterion("RPT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRptNoEqualTo(String value) {
            addCriterion("RPT_NO =", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotEqualTo(String value) {
            addCriterion("RPT_NO <>", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoGreaterThan(String value) {
            addCriterion("RPT_NO >", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoGreaterThanOrEqualTo(String value) {
            addCriterion("RPT_NO >=", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoLessThan(String value) {
            addCriterion("RPT_NO <", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoLessThanOrEqualTo(String value) {
            addCriterion("RPT_NO <=", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoLike(String value) {
            addCriterion("RPT_NO like", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotLike(String value) {
            addCriterion("RPT_NO not like", value, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoIn(List<String> values) {
            addCriterion("RPT_NO in", values, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotIn(List<String> values) {
            addCriterion("RPT_NO not in", values, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoBetween(String value1, String value2) {
            addCriterion("RPT_NO between", value1, value2, "rptNo");
            return (Criteria) this;
        }

        public Criteria andRptNoNotBetween(String value1, String value2) {
            addCriterion("RPT_NO not between", value1, value2, "rptNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}