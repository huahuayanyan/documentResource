package com.huateng.scf.bas.sys.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysApplyDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysApplyDtlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysApplyDtlExample(BSysApplyDtlExample example) {
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

        public Criteria andTransnoIsNull() {
            addCriterion("TRANSNO is null");
            return (Criteria) this;
        }

        public Criteria andTransnoIsNotNull() {
            addCriterion("TRANSNO is not null");
            return (Criteria) this;
        }

        public Criteria andTransnoEqualTo(String value) {
            addCriterion("TRANSNO =", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotEqualTo(String value) {
            addCriterion("TRANSNO <>", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoGreaterThan(String value) {
            addCriterion("TRANSNO >", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSNO >=", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoLessThan(String value) {
            addCriterion("TRANSNO <", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoLessThanOrEqualTo(String value) {
            addCriterion("TRANSNO <=", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoLike(String value) {
            addCriterion("TRANSNO like", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotLike(String value) {
            addCriterion("TRANSNO not like", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoIn(List<String> values) {
            addCriterion("TRANSNO in", values, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotIn(List<String> values) {
            addCriterion("TRANSNO not in", values, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoBetween(String value1, String value2) {
            addCriterion("TRANSNO between", value1, value2, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotBetween(String value1, String value2) {
            addCriterion("TRANSNO not between", value1, value2, "transno");
            return (Criteria) this;
        }

        public Criteria andAppnoIsNull() {
            addCriterion("APPNO is null");
            return (Criteria) this;
        }

        public Criteria andAppnoIsNotNull() {
            addCriterion("APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andAppnoEqualTo(String value) {
            addCriterion("APPNO =", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotEqualTo(String value) {
            addCriterion("APPNO <>", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoGreaterThan(String value) {
            addCriterion("APPNO >", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("APPNO >=", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLessThan(String value) {
            addCriterion("APPNO <", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLessThanOrEqualTo(String value) {
            addCriterion("APPNO <=", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoLike(String value) {
            addCriterion("APPNO like", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotLike(String value) {
            addCriterion("APPNO not like", value, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoIn(List<String> values) {
            addCriterion("APPNO in", values, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotIn(List<String> values) {
            addCriterion("APPNO not in", values, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoBetween(String value1, String value2) {
            addCriterion("APPNO between", value1, value2, "appno");
            return (Criteria) this;
        }

        public Criteria andAppnoNotBetween(String value1, String value2) {
            addCriterion("APPNO not between", value1, value2, "appno");
            return (Criteria) this;
        }

        public Criteria andTxdateIsNull() {
            addCriterion("TXDATE is null");
            return (Criteria) this;
        }

        public Criteria andTxdateIsNotNull() {
            addCriterion("TXDATE is not null");
            return (Criteria) this;
        }

        public Criteria andTxdateEqualTo(String value) {
            addCriterion("TXDATE =", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotEqualTo(String value) {
            addCriterion("TXDATE <>", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateGreaterThan(String value) {
            addCriterion("TXDATE >", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateGreaterThanOrEqualTo(String value) {
            addCriterion("TXDATE >=", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLessThan(String value) {
            addCriterion("TXDATE <", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLessThanOrEqualTo(String value) {
            addCriterion("TXDATE <=", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateLike(String value) {
            addCriterion("TXDATE like", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotLike(String value) {
            addCriterion("TXDATE not like", value, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateIn(List<String> values) {
            addCriterion("TXDATE in", values, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotIn(List<String> values) {
            addCriterion("TXDATE not in", values, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateBetween(String value1, String value2) {
            addCriterion("TXDATE between", value1, value2, "txdate");
            return (Criteria) this;
        }

        public Criteria andTxdateNotBetween(String value1, String value2) {
            addCriterion("TXDATE not between", value1, value2, "txdate");
            return (Criteria) this;
        }

        public Criteria andBrhnoIsNull() {
            addCriterion("BRHNO is null");
            return (Criteria) this;
        }

        public Criteria andBrhnoIsNotNull() {
            addCriterion("BRHNO is not null");
            return (Criteria) this;
        }

        public Criteria andBrhnoEqualTo(String value) {
            addCriterion("BRHNO =", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoNotEqualTo(String value) {
            addCriterion("BRHNO <>", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoGreaterThan(String value) {
            addCriterion("BRHNO >", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoGreaterThanOrEqualTo(String value) {
            addCriterion("BRHNO >=", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoLessThan(String value) {
            addCriterion("BRHNO <", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoLessThanOrEqualTo(String value) {
            addCriterion("BRHNO <=", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoLike(String value) {
            addCriterion("BRHNO like", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoNotLike(String value) {
            addCriterion("BRHNO not like", value, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoIn(List<String> values) {
            addCriterion("BRHNO in", values, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoNotIn(List<String> values) {
            addCriterion("BRHNO not in", values, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoBetween(String value1, String value2) {
            addCriterion("BRHNO between", value1, value2, "brhno");
            return (Criteria) this;
        }

        public Criteria andBrhnoNotBetween(String value1, String value2) {
            addCriterion("BRHNO not between", value1, value2, "brhno");
            return (Criteria) this;
        }

        public Criteria andOprnoIsNull() {
            addCriterion("OPRNO is null");
            return (Criteria) this;
        }

        public Criteria andOprnoIsNotNull() {
            addCriterion("OPRNO is not null");
            return (Criteria) this;
        }

        public Criteria andOprnoEqualTo(String value) {
            addCriterion("OPRNO =", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotEqualTo(String value) {
            addCriterion("OPRNO <>", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoGreaterThan(String value) {
            addCriterion("OPRNO >", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoGreaterThanOrEqualTo(String value) {
            addCriterion("OPRNO >=", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoLessThan(String value) {
            addCriterion("OPRNO <", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoLessThanOrEqualTo(String value) {
            addCriterion("OPRNO <=", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoLike(String value) {
            addCriterion("OPRNO like", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotLike(String value) {
            addCriterion("OPRNO not like", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoIn(List<String> values) {
            addCriterion("OPRNO in", values, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotIn(List<String> values) {
            addCriterion("OPRNO not in", values, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoBetween(String value1, String value2) {
            addCriterion("OPRNO between", value1, value2, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotBetween(String value1, String value2) {
            addCriterion("OPRNO not between", value1, value2, "oprno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoIsNull() {
            addCriterion("TLSRNO is null");
            return (Criteria) this;
        }

        public Criteria andTlsrnoIsNotNull() {
            addCriterion("TLSRNO is not null");
            return (Criteria) this;
        }

        public Criteria andTlsrnoEqualTo(String value) {
            addCriterion("TLSRNO =", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoNotEqualTo(String value) {
            addCriterion("TLSRNO <>", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoGreaterThan(String value) {
            addCriterion("TLSRNO >", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoGreaterThanOrEqualTo(String value) {
            addCriterion("TLSRNO >=", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoLessThan(String value) {
            addCriterion("TLSRNO <", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoLessThanOrEqualTo(String value) {
            addCriterion("TLSRNO <=", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoLike(String value) {
            addCriterion("TLSRNO like", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoNotLike(String value) {
            addCriterion("TLSRNO not like", value, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoIn(List<String> values) {
            addCriterion("TLSRNO in", values, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoNotIn(List<String> values) {
            addCriterion("TLSRNO not in", values, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoBetween(String value1, String value2) {
            addCriterion("TLSRNO between", value1, value2, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTlsrnoNotBetween(String value1, String value2) {
            addCriterion("TLSRNO not between", value1, value2, "tlsrno");
            return (Criteria) this;
        }

        public Criteria andTxtimeIsNull() {
            addCriterion("TXTIME is null");
            return (Criteria) this;
        }

        public Criteria andTxtimeIsNotNull() {
            addCriterion("TXTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTxtimeEqualTo(String value) {
            addCriterion("TXTIME =", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotEqualTo(String value) {
            addCriterion("TXTIME <>", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeGreaterThan(String value) {
            addCriterion("TXTIME >", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeGreaterThanOrEqualTo(String value) {
            addCriterion("TXTIME >=", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeLessThan(String value) {
            addCriterion("TXTIME <", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeLessThanOrEqualTo(String value) {
            addCriterion("TXTIME <=", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeLike(String value) {
            addCriterion("TXTIME like", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotLike(String value) {
            addCriterion("TXTIME not like", value, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeIn(List<String> values) {
            addCriterion("TXTIME in", values, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotIn(List<String> values) {
            addCriterion("TXTIME not in", values, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeBetween(String value1, String value2) {
            addCriterion("TXTIME between", value1, value2, "txtime");
            return (Criteria) this;
        }

        public Criteria andTxtimeNotBetween(String value1, String value2) {
            addCriterion("TXTIME not between", value1, value2, "txtime");
            return (Criteria) this;
        }

        public Criteria andFuncCodeIsNull() {
            addCriterion("FUNC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFuncCodeIsNotNull() {
            addCriterion("FUNC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFuncCodeEqualTo(String value) {
            addCriterion("FUNC_CODE =", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotEqualTo(String value) {
            addCriterion("FUNC_CODE <>", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeGreaterThan(String value) {
            addCriterion("FUNC_CODE >", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_CODE >=", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeLessThan(String value) {
            addCriterion("FUNC_CODE <", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeLessThanOrEqualTo(String value) {
            addCriterion("FUNC_CODE <=", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeLike(String value) {
            addCriterion("FUNC_CODE like", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotLike(String value) {
            addCriterion("FUNC_CODE not like", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeIn(List<String> values) {
            addCriterion("FUNC_CODE in", values, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotIn(List<String> values) {
            addCriterion("FUNC_CODE not in", values, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeBetween(String value1, String value2) {
            addCriterion("FUNC_CODE between", value1, value2, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotBetween(String value1, String value2) {
            addCriterion("FUNC_CODE not between", value1, value2, "funcCode");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNull() {
            addCriterion("BUSS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNotNull() {
            addCriterion("BUSS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBussTypeEqualTo(String value) {
            addCriterion("BUSS_TYPE =", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotEqualTo(String value) {
            addCriterion("BUSS_TYPE <>", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThan(String value) {
            addCriterion("BUSS_TYPE >", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE >=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThan(String value) {
            addCriterion("BUSS_TYPE <", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSS_TYPE <=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLike(String value) {
            addCriterion("BUSS_TYPE like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotLike(String value) {
            addCriterion("BUSS_TYPE not like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeIn(List<String> values) {
            addCriterion("BUSS_TYPE in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotIn(List<String> values) {
            addCriterion("BUSS_TYPE not in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotBetween(String value1, String value2) {
            addCriterion("BUSS_TYPE not between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andAttitudeIsNull() {
            addCriterion("ATTITUDE is null");
            return (Criteria) this;
        }

        public Criteria andAttitudeIsNotNull() {
            addCriterion("ATTITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudeEqualTo(String value) {
            addCriterion("ATTITUDE =", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotEqualTo(String value) {
            addCriterion("ATTITUDE <>", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeGreaterThan(String value) {
            addCriterion("ATTITUDE >", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ATTITUDE >=", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLessThan(String value) {
            addCriterion("ATTITUDE <", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLessThanOrEqualTo(String value) {
            addCriterion("ATTITUDE <=", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLike(String value) {
            addCriterion("ATTITUDE like", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotLike(String value) {
            addCriterion("ATTITUDE not like", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeIn(List<String> values) {
            addCriterion("ATTITUDE in", values, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotIn(List<String> values) {
            addCriterion("ATTITUDE not in", values, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeBetween(String value1, String value2) {
            addCriterion("ATTITUDE between", value1, value2, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotBetween(String value1, String value2) {
            addCriterion("ATTITUDE not between", value1, value2, "attitude");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(BigDecimal value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(BigDecimal value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(BigDecimal value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(BigDecimal value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<BigDecimal> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<BigDecimal> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNull() {
            addCriterion("ROLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNotNull() {
            addCriterion("ROLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeEqualTo(String value) {
            addCriterion("ROLE_TYPE =", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotEqualTo(String value) {
            addCriterion("ROLE_TYPE <>", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThan(String value) {
            addCriterion("ROLE_TYPE >", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_TYPE >=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThan(String value) {
            addCriterion("ROLE_TYPE <", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_TYPE <=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLike(String value) {
            addCriterion("ROLE_TYPE like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotLike(String value) {
            addCriterion("ROLE_TYPE not like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIn(List<String> values) {
            addCriterion("ROLE_TYPE in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotIn(List<String> values) {
            addCriterion("ROLE_TYPE not in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeBetween(String value1, String value2) {
            addCriterion("ROLE_TYPE between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotBetween(String value1, String value2) {
            addCriterion("ROLE_TYPE not between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}