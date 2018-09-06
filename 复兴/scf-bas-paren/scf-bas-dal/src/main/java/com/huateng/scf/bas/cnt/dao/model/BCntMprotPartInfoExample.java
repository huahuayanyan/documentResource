package com.huateng.scf.bas.cnt.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BCntMprotPartInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCntMprotPartInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BCntMprotPartInfoExample(BCntMprotPartInfoExample example) {
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

        public Criteria andProtocolNoIsNull() {
            addCriterion("PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIsNotNull() {
            addCriterion("PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolNoEqualTo(String value) {
            addCriterion("PROTOCOL_NO =", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotEqualTo(String value) {
            addCriterion("PROTOCOL_NO <>", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThan(String value) {
            addCriterion("PROTOCOL_NO >", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO >=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThan(String value) {
            addCriterion("PROTOCOL_NO <", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_NO <=", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoLike(String value) {
            addCriterion("PROTOCOL_NO like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotLike(String value) {
            addCriterion("PROTOCOL_NO not like", value, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoIn(List<String> values) {
            addCriterion("PROTOCOL_NO in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotIn(List<String> values) {
            addCriterion("PROTOCOL_NO not in", values, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO between", value1, value2, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andProtocolNoNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_NO not between", value1, value2, "protocolNo");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("ROLE is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("ROLE =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("ROLE <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("ROLE >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("ROLE <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("ROLE <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("ROLE like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("ROLE not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("ROLE in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("ROLE not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("ROLE between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("ROLE not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andCustcdIsNull() {
            addCriterion("CUSTCD is null");
            return (Criteria) this;
        }

        public Criteria andCustcdIsNotNull() {
            addCriterion("CUSTCD is not null");
            return (Criteria) this;
        }

        public Criteria andCustcdEqualTo(String value) {
            addCriterion("CUSTCD =", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotEqualTo(String value) {
            addCriterion("CUSTCD <>", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThan(String value) {
            addCriterion("CUSTCD >", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTCD >=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThan(String value) {
            addCriterion("CUSTCD <", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLessThanOrEqualTo(String value) {
            addCriterion("CUSTCD <=", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdLike(String value) {
            addCriterion("CUSTCD like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotLike(String value) {
            addCriterion("CUSTCD not like", value, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdIn(List<String> values) {
            addCriterion("CUSTCD in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotIn(List<String> values) {
            addCriterion("CUSTCD not in", values, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdBetween(String value1, String value2) {
            addCriterion("CUSTCD between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andCustcdNotBetween(String value1, String value2) {
            addCriterion("CUSTCD not between", value1, value2, "custcd");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("CNAME =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("CNAME <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("CNAME >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("CNAME <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("CNAME <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("CNAME like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("CNAME not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("CNAME in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("CNAME not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("CNAME between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("CNAME not between", value1, value2, "cname");
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

        public Criteria andLegalIsNull() {
            addCriterion("LEGAL is null");
            return (Criteria) this;
        }

        public Criteria andLegalIsNotNull() {
            addCriterion("LEGAL is not null");
            return (Criteria) this;
        }

        public Criteria andLegalEqualTo(String value) {
            addCriterion("LEGAL =", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotEqualTo(String value) {
            addCriterion("LEGAL <>", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalGreaterThan(String value) {
            addCriterion("LEGAL >", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL >=", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalLessThan(String value) {
            addCriterion("LEGAL <", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalLessThanOrEqualTo(String value) {
            addCriterion("LEGAL <=", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalLike(String value) {
            addCriterion("LEGAL like", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotLike(String value) {
            addCriterion("LEGAL not like", value, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalIn(List<String> values) {
            addCriterion("LEGAL in", values, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotIn(List<String> values) {
            addCriterion("LEGAL not in", values, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalBetween(String value1, String value2) {
            addCriterion("LEGAL between", value1, value2, "legal");
            return (Criteria) this;
        }

        public Criteria andLegalNotBetween(String value1, String value2) {
            addCriterion("LEGAL not between", value1, value2, "legal");
            return (Criteria) this;
        }

        public Criteria andActBanknoIsNull() {
            addCriterion("ACT_BANKNO is null");
            return (Criteria) this;
        }

        public Criteria andActBanknoIsNotNull() {
            addCriterion("ACT_BANKNO is not null");
            return (Criteria) this;
        }

        public Criteria andActBanknoEqualTo(String value) {
            addCriterion("ACT_BANKNO =", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoNotEqualTo(String value) {
            addCriterion("ACT_BANKNO <>", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoGreaterThan(String value) {
            addCriterion("ACT_BANKNO >", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_BANKNO >=", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoLessThan(String value) {
            addCriterion("ACT_BANKNO <", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoLessThanOrEqualTo(String value) {
            addCriterion("ACT_BANKNO <=", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoLike(String value) {
            addCriterion("ACT_BANKNO like", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoNotLike(String value) {
            addCriterion("ACT_BANKNO not like", value, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoIn(List<String> values) {
            addCriterion("ACT_BANKNO in", values, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoNotIn(List<String> values) {
            addCriterion("ACT_BANKNO not in", values, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoBetween(String value1, String value2) {
            addCriterion("ACT_BANKNO between", value1, value2, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActBanknoNotBetween(String value1, String value2) {
            addCriterion("ACT_BANKNO not between", value1, value2, "actBankno");
            return (Criteria) this;
        }

        public Criteria andActnoIsNull() {
            addCriterion("ACTNO is null");
            return (Criteria) this;
        }

        public Criteria andActnoIsNotNull() {
            addCriterion("ACTNO is not null");
            return (Criteria) this;
        }

        public Criteria andActnoEqualTo(String value) {
            addCriterion("ACTNO =", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotEqualTo(String value) {
            addCriterion("ACTNO <>", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoGreaterThan(String value) {
            addCriterion("ACTNO >", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoGreaterThanOrEqualTo(String value) {
            addCriterion("ACTNO >=", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLessThan(String value) {
            addCriterion("ACTNO <", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLessThanOrEqualTo(String value) {
            addCriterion("ACTNO <=", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLike(String value) {
            addCriterion("ACTNO like", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotLike(String value) {
            addCriterion("ACTNO not like", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoIn(List<String> values) {
            addCriterion("ACTNO in", values, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotIn(List<String> values) {
            addCriterion("ACTNO not in", values, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoBetween(String value1, String value2) {
            addCriterion("ACTNO between", value1, value2, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotBetween(String value1, String value2) {
            addCriterion("ACTNO not between", value1, value2, "actno");
            return (Criteria) this;
        }

        public Criteria andBailActnoIsNull() {
            addCriterion("BAIL_ACTNO is null");
            return (Criteria) this;
        }

        public Criteria andBailActnoIsNotNull() {
            addCriterion("BAIL_ACTNO is not null");
            return (Criteria) this;
        }

        public Criteria andBailActnoEqualTo(String value) {
            addCriterion("BAIL_ACTNO =", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoNotEqualTo(String value) {
            addCriterion("BAIL_ACTNO <>", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoGreaterThan(String value) {
            addCriterion("BAIL_ACTNO >", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoGreaterThanOrEqualTo(String value) {
            addCriterion("BAIL_ACTNO >=", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoLessThan(String value) {
            addCriterion("BAIL_ACTNO <", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoLessThanOrEqualTo(String value) {
            addCriterion("BAIL_ACTNO <=", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoLike(String value) {
            addCriterion("BAIL_ACTNO like", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoNotLike(String value) {
            addCriterion("BAIL_ACTNO not like", value, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoIn(List<String> values) {
            addCriterion("BAIL_ACTNO in", values, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoNotIn(List<String> values) {
            addCriterion("BAIL_ACTNO not in", values, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoBetween(String value1, String value2) {
            addCriterion("BAIL_ACTNO between", value1, value2, "bailActno");
            return (Criteria) this;
        }

        public Criteria andBailActnoNotBetween(String value1, String value2) {
            addCriterion("BAIL_ACTNO not between", value1, value2, "bailActno");
            return (Criteria) this;
        }

        public Criteria andAttnIsNull() {
            addCriterion("ATTN is null");
            return (Criteria) this;
        }

        public Criteria andAttnIsNotNull() {
            addCriterion("ATTN is not null");
            return (Criteria) this;
        }

        public Criteria andAttnEqualTo(String value) {
            addCriterion("ATTN =", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotEqualTo(String value) {
            addCriterion("ATTN <>", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnGreaterThan(String value) {
            addCriterion("ATTN >", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnGreaterThanOrEqualTo(String value) {
            addCriterion("ATTN >=", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnLessThan(String value) {
            addCriterion("ATTN <", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnLessThanOrEqualTo(String value) {
            addCriterion("ATTN <=", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnLike(String value) {
            addCriterion("ATTN like", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotLike(String value) {
            addCriterion("ATTN not like", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnIn(List<String> values) {
            addCriterion("ATTN in", values, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotIn(List<String> values) {
            addCriterion("ATTN not in", values, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnBetween(String value1, String value2) {
            addCriterion("ATTN between", value1, value2, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotBetween(String value1, String value2) {
            addCriterion("ATTN not between", value1, value2, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnTelIsNull() {
            addCriterion("ATTN_TEL is null");
            return (Criteria) this;
        }

        public Criteria andAttnTelIsNotNull() {
            addCriterion("ATTN_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andAttnTelEqualTo(String value) {
            addCriterion("ATTN_TEL =", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelNotEqualTo(String value) {
            addCriterion("ATTN_TEL <>", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelGreaterThan(String value) {
            addCriterion("ATTN_TEL >", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelGreaterThanOrEqualTo(String value) {
            addCriterion("ATTN_TEL >=", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelLessThan(String value) {
            addCriterion("ATTN_TEL <", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelLessThanOrEqualTo(String value) {
            addCriterion("ATTN_TEL <=", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelLike(String value) {
            addCriterion("ATTN_TEL like", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelNotLike(String value) {
            addCriterion("ATTN_TEL not like", value, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelIn(List<String> values) {
            addCriterion("ATTN_TEL in", values, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelNotIn(List<String> values) {
            addCriterion("ATTN_TEL not in", values, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelBetween(String value1, String value2) {
            addCriterion("ATTN_TEL between", value1, value2, "attnTel");
            return (Criteria) this;
        }

        public Criteria andAttnTelNotBetween(String value1, String value2) {
            addCriterion("ATTN_TEL not between", value1, value2, "attnTel");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("POST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("POST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("POST_CODE =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("POST_CODE <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("POST_CODE >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POST_CODE >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("POST_CODE <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("POST_CODE <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("POST_CODE like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("POST_CODE not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("POST_CODE in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("POST_CODE not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("POST_CODE between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("POST_CODE not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNull() {
            addCriterion("IDNO is null");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNotNull() {
            addCriterion("IDNO is not null");
            return (Criteria) this;
        }

        public Criteria andIdnoEqualTo(String value) {
            addCriterion("IDNO =", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotEqualTo(String value) {
            addCriterion("IDNO <>", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThan(String value) {
            addCriterion("IDNO >", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThanOrEqualTo(String value) {
            addCriterion("IDNO >=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThan(String value) {
            addCriterion("IDNO <", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThanOrEqualTo(String value) {
            addCriterion("IDNO <=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLike(String value) {
            addCriterion("IDNO like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotLike(String value) {
            addCriterion("IDNO not like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoIn(List<String> values) {
            addCriterion("IDNO in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotIn(List<String> values) {
            addCriterion("IDNO not in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoBetween(String value1, String value2) {
            addCriterion("IDNO between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotBetween(String value1, String value2) {
            addCriterion("IDNO not between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("LICENSE_NO is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("LICENSE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("LICENSE_NO =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("LICENSE_NO <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("LICENSE_NO >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("LICENSE_NO >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("LICENSE_NO <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("LICENSE_NO <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("LICENSE_NO like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("LICENSE_NO not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("LICENSE_NO in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("LICENSE_NO not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("LICENSE_NO between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("LICENSE_NO not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("WEBSITE =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("WEBSITE <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("WEBSITE >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("WEBSITE >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("WEBSITE <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("WEBSITE <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("WEBSITE like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("WEBSITE not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("WEBSITE in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("WEBSITE not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("WEBSITE between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("WEBSITE not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNull() {
            addCriterion("MAILBOX is null");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNotNull() {
            addCriterion("MAILBOX is not null");
            return (Criteria) this;
        }

        public Criteria andMailboxEqualTo(String value) {
            addCriterion("MAILBOX =", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotEqualTo(String value) {
            addCriterion("MAILBOX <>", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThan(String value) {
            addCriterion("MAILBOX >", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThanOrEqualTo(String value) {
            addCriterion("MAILBOX >=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThan(String value) {
            addCriterion("MAILBOX <", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThanOrEqualTo(String value) {
            addCriterion("MAILBOX <=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLike(String value) {
            addCriterion("MAILBOX like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotLike(String value) {
            addCriterion("MAILBOX not like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxIn(List<String> values) {
            addCriterion("MAILBOX in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotIn(List<String> values) {
            addCriterion("MAILBOX not in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxBetween(String value1, String value2) {
            addCriterion("MAILBOX between", value1, value2, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotBetween(String value1, String value2) {
            addCriterion("MAILBOX not between", value1, value2, "mailbox");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}