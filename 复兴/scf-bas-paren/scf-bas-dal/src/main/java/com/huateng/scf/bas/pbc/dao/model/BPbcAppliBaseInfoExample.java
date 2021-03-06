package com.huateng.scf.bas.pbc.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BPbcAppliBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPbcAppliBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BPbcAppliBaseInfoExample(BPbcAppliBaseInfoExample example) {
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

        public Criteria andPiidIsNull() {
            addCriterion("PIID is null");
            return (Criteria) this;
        }

        public Criteria andPiidIsNotNull() {
            addCriterion("PIID is not null");
            return (Criteria) this;
        }

        public Criteria andPiidEqualTo(String value) {
            addCriterion("PIID =", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidNotEqualTo(String value) {
            addCriterion("PIID <>", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidGreaterThan(String value) {
            addCriterion("PIID >", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidGreaterThanOrEqualTo(String value) {
            addCriterion("PIID >=", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidLessThan(String value) {
            addCriterion("PIID <", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidLessThanOrEqualTo(String value) {
            addCriterion("PIID <=", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidLike(String value) {
            addCriterion("PIID like", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidNotLike(String value) {
            addCriterion("PIID not like", value, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidIn(List<String> values) {
            addCriterion("PIID in", values, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidNotIn(List<String> values) {
            addCriterion("PIID not in", values, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidBetween(String value1, String value2) {
            addCriterion("PIID between", value1, value2, "piid");
            return (Criteria) this;
        }

        public Criteria andPiidNotBetween(String value1, String value2) {
            addCriterion("PIID not between", value1, value2, "piid");
            return (Criteria) this;
        }

        public Criteria andAppliTypeIsNull() {
            addCriterion("APPLI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAppliTypeIsNotNull() {
            addCriterion("APPLI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAppliTypeEqualTo(String value) {
            addCriterion("APPLI_TYPE =", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotEqualTo(String value) {
            addCriterion("APPLI_TYPE <>", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeGreaterThan(String value) {
            addCriterion("APPLI_TYPE >", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLI_TYPE >=", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeLessThan(String value) {
            addCriterion("APPLI_TYPE <", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeLessThanOrEqualTo(String value) {
            addCriterion("APPLI_TYPE <=", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeLike(String value) {
            addCriterion("APPLI_TYPE like", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotLike(String value) {
            addCriterion("APPLI_TYPE not like", value, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeIn(List<String> values) {
            addCriterion("APPLI_TYPE in", values, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotIn(List<String> values) {
            addCriterion("APPLI_TYPE not in", values, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeBetween(String value1, String value2) {
            addCriterion("APPLI_TYPE between", value1, value2, "appliType");
            return (Criteria) this;
        }

        public Criteria andAppliTypeNotBetween(String value1, String value2) {
            addCriterion("APPLI_TYPE not between", value1, value2, "appliType");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameIsNull() {
            addCriterion("PROCESS_TEMPLATE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameIsNotNull() {
            addCriterion("PROCESS_TEMPLATE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameEqualTo(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME =", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameNotEqualTo(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME <>", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameGreaterThan(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME >", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME >=", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameLessThan(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME <", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME <=", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameLike(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME like", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameNotLike(String value) {
            addCriterion("PROCESS_TEMPLATE_NAME not like", value, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameIn(List<String> values) {
            addCriterion("PROCESS_TEMPLATE_NAME in", values, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameNotIn(List<String> values) {
            addCriterion("PROCESS_TEMPLATE_NAME not in", values, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameBetween(String value1, String value2) {
            addCriterion("PROCESS_TEMPLATE_NAME between", value1, value2, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andProcessTemplateNameNotBetween(String value1, String value2) {
            addCriterion("PROCESS_TEMPLATE_NAME not between", value1, value2, "processTemplateName");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeIsNull() {
            addCriterion("BUSINESSNO_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeIsNotNull() {
            addCriterion("BUSINESSNO_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeEqualTo(String value) {
            addCriterion("BUSINESSNO_TYPE =", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeNotEqualTo(String value) {
            addCriterion("BUSINESSNO_TYPE <>", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeGreaterThan(String value) {
            addCriterion("BUSINESSNO_TYPE >", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSNO_TYPE >=", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeLessThan(String value) {
            addCriterion("BUSINESSNO_TYPE <", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSNO_TYPE <=", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeLike(String value) {
            addCriterion("BUSINESSNO_TYPE like", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeNotLike(String value) {
            addCriterion("BUSINESSNO_TYPE not like", value, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeIn(List<String> values) {
            addCriterion("BUSINESSNO_TYPE in", values, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeNotIn(List<String> values) {
            addCriterion("BUSINESSNO_TYPE not in", values, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeBetween(String value1, String value2) {
            addCriterion("BUSINESSNO_TYPE between", value1, value2, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoTypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESSNO_TYPE not between", value1, value2, "businessnoType");
            return (Criteria) this;
        }

        public Criteria andBusinessnoIsNull() {
            addCriterion("BUSINESSNO is null");
            return (Criteria) this;
        }

        public Criteria andBusinessnoIsNotNull() {
            addCriterion("BUSINESSNO is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessnoEqualTo(String value) {
            addCriterion("BUSINESSNO =", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotEqualTo(String value) {
            addCriterion("BUSINESSNO <>", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoGreaterThan(String value) {
            addCriterion("BUSINESSNO >", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSNO >=", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoLessThan(String value) {
            addCriterion("BUSINESSNO <", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSNO <=", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoLike(String value) {
            addCriterion("BUSINESSNO like", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotLike(String value) {
            addCriterion("BUSINESSNO not like", value, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoIn(List<String> values) {
            addCriterion("BUSINESSNO in", values, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotIn(List<String> values) {
            addCriterion("BUSINESSNO not in", values, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoBetween(String value1, String value2) {
            addCriterion("BUSINESSNO between", value1, value2, "businessno");
            return (Criteria) this;
        }

        public Criteria andBusinessnoNotBetween(String value1, String value2) {
            addCriterion("BUSINESSNO not between", value1, value2, "businessno");
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

        public Criteria andAmtIsNull() {
            addCriterion("AMT is null");
            return (Criteria) this;
        }

        public Criteria andAmtIsNotNull() {
            addCriterion("AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAmtEqualTo(BigDecimal value) {
            addCriterion("AMT =", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotEqualTo(BigDecimal value) {
            addCriterion("AMT <>", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThan(BigDecimal value) {
            addCriterion("AMT >", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMT >=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThan(BigDecimal value) {
            addCriterion("AMT <", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMT <=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtIn(List<BigDecimal> values) {
            addCriterion("AMT in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotIn(List<BigDecimal> values) {
            addCriterion("AMT not in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMT between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMT not between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeIsNull() {
            addCriterion("START_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeIsNotNull() {
            addCriterion("START_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeEqualTo(String value) {
            addCriterion("START_BRCODE =", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeNotEqualTo(String value) {
            addCriterion("START_BRCODE <>", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeGreaterThan(String value) {
            addCriterion("START_BRCODE >", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("START_BRCODE >=", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeLessThan(String value) {
            addCriterion("START_BRCODE <", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeLessThanOrEqualTo(String value) {
            addCriterion("START_BRCODE <=", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeLike(String value) {
            addCriterion("START_BRCODE like", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeNotLike(String value) {
            addCriterion("START_BRCODE not like", value, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeIn(List<String> values) {
            addCriterion("START_BRCODE in", values, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeNotIn(List<String> values) {
            addCriterion("START_BRCODE not in", values, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeBetween(String value1, String value2) {
            addCriterion("START_BRCODE between", value1, value2, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartBrcodeNotBetween(String value1, String value2) {
            addCriterion("START_BRCODE not between", value1, value2, "startBrcode");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdIsNull() {
            addCriterion("START_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdIsNotNull() {
            addCriterion("START_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdEqualTo(String value) {
            addCriterion("START_TLRCD =", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdNotEqualTo(String value) {
            addCriterion("START_TLRCD <>", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdGreaterThan(String value) {
            addCriterion("START_TLRCD >", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("START_TLRCD >=", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdLessThan(String value) {
            addCriterion("START_TLRCD <", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdLessThanOrEqualTo(String value) {
            addCriterion("START_TLRCD <=", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdLike(String value) {
            addCriterion("START_TLRCD like", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdNotLike(String value) {
            addCriterion("START_TLRCD not like", value, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdIn(List<String> values) {
            addCriterion("START_TLRCD in", values, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdNotIn(List<String> values) {
            addCriterion("START_TLRCD not in", values, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdBetween(String value1, String value2) {
            addCriterion("START_TLRCD between", value1, value2, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStartTlrcdNotBetween(String value1, String value2) {
            addCriterion("START_TLRCD not between", value1, value2, "startTlrcd");
            return (Criteria) this;
        }

        public Criteria andStratDateIsNull() {
            addCriterion("STRAT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStratDateIsNotNull() {
            addCriterion("STRAT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStratDateEqualTo(String value) {
            addCriterion("STRAT_DATE =", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateNotEqualTo(String value) {
            addCriterion("STRAT_DATE <>", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateGreaterThan(String value) {
            addCriterion("STRAT_DATE >", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateGreaterThanOrEqualTo(String value) {
            addCriterion("STRAT_DATE >=", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateLessThan(String value) {
            addCriterion("STRAT_DATE <", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateLessThanOrEqualTo(String value) {
            addCriterion("STRAT_DATE <=", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateLike(String value) {
            addCriterion("STRAT_DATE like", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateNotLike(String value) {
            addCriterion("STRAT_DATE not like", value, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateIn(List<String> values) {
            addCriterion("STRAT_DATE in", values, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateNotIn(List<String> values) {
            addCriterion("STRAT_DATE not in", values, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateBetween(String value1, String value2) {
            addCriterion("STRAT_DATE between", value1, value2, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStratDateNotBetween(String value1, String value2) {
            addCriterion("STRAT_DATE not between", value1, value2, "stratDate");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andAppliStatusIsNull() {
            addCriterion("APPLI_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAppliStatusIsNotNull() {
            addCriterion("APPLI_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAppliStatusEqualTo(String value) {
            addCriterion("APPLI_STATUS =", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusNotEqualTo(String value) {
            addCriterion("APPLI_STATUS <>", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusGreaterThan(String value) {
            addCriterion("APPLI_STATUS >", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusGreaterThanOrEqualTo(String value) {
            addCriterion("APPLI_STATUS >=", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusLessThan(String value) {
            addCriterion("APPLI_STATUS <", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusLessThanOrEqualTo(String value) {
            addCriterion("APPLI_STATUS <=", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusLike(String value) {
            addCriterion("APPLI_STATUS like", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusNotLike(String value) {
            addCriterion("APPLI_STATUS not like", value, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusIn(List<String> values) {
            addCriterion("APPLI_STATUS in", values, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusNotIn(List<String> values) {
            addCriterion("APPLI_STATUS not in", values, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusBetween(String value1, String value2) {
            addCriterion("APPLI_STATUS between", value1, value2, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andAppliStatusNotBetween(String value1, String value2) {
            addCriterion("APPLI_STATUS not between", value1, value2, "appliStatus");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeIsNull() {
            addCriterion("APPROVE_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeIsNotNull() {
            addCriterion("APPROVE_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeEqualTo(String value) {
            addCriterion("APPROVE_BRCODE =", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotEqualTo(String value) {
            addCriterion("APPROVE_BRCODE <>", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeGreaterThan(String value) {
            addCriterion("APPROVE_BRCODE >", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_BRCODE >=", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeLessThan(String value) {
            addCriterion("APPROVE_BRCODE <", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_BRCODE <=", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeLike(String value) {
            addCriterion("APPROVE_BRCODE like", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotLike(String value) {
            addCriterion("APPROVE_BRCODE not like", value, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeIn(List<String> values) {
            addCriterion("APPROVE_BRCODE in", values, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotIn(List<String> values) {
            addCriterion("APPROVE_BRCODE not in", values, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeBetween(String value1, String value2) {
            addCriterion("APPROVE_BRCODE between", value1, value2, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproveBrcodeNotBetween(String value1, String value2) {
            addCriterion("APPROVE_BRCODE not between", value1, value2, "approveBrcode");
            return (Criteria) this;
        }

        public Criteria andApproverIsNull() {
            addCriterion("APPROVER is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsNotNull() {
            addCriterion("APPROVER is not null");
            return (Criteria) this;
        }

        public Criteria andApproverEqualTo(String value) {
            addCriterion("APPROVER =", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotEqualTo(String value) {
            addCriterion("APPROVER <>", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThan(String value) {
            addCriterion("APPROVER >", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVER >=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThan(String value) {
            addCriterion("APPROVER <", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThanOrEqualTo(String value) {
            addCriterion("APPROVER <=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLike(String value) {
            addCriterion("APPROVER like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotLike(String value) {
            addCriterion("APPROVER not like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverIn(List<String> values) {
            addCriterion("APPROVER in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotIn(List<String> values) {
            addCriterion("APPROVER not in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverBetween(String value1, String value2) {
            addCriterion("APPROVER between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotBetween(String value1, String value2) {
            addCriterion("APPROVER not between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNull() {
            addCriterion("APPROVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNotNull() {
            addCriterion("APPROVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDateEqualTo(String value) {
            addCriterion("APPROVE_DATE =", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotEqualTo(String value) {
            addCriterion("APPROVE_DATE <>", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThan(String value) {
            addCriterion("APPROVE_DATE >", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_DATE >=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThan(String value) {
            addCriterion("APPROVE_DATE <", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_DATE <=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLike(String value) {
            addCriterion("APPROVE_DATE like", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotLike(String value) {
            addCriterion("APPROVE_DATE not like", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateIn(List<String> values) {
            addCriterion("APPROVE_DATE in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotIn(List<String> values) {
            addCriterion("APPROVE_DATE not in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateBetween(String value1, String value2) {
            addCriterion("APPROVE_DATE between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotBetween(String value1, String value2) {
            addCriterion("APPROVE_DATE not between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNull() {
            addCriterion("APPROVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNotNull() {
            addCriterion("APPROVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeEqualTo(Date value) {
            addCriterion("APPROVE_TIME =", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotEqualTo(Date value) {
            addCriterion("APPROVE_TIME <>", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThan(Date value) {
            addCriterion("APPROVE_TIME >", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPROVE_TIME >=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThan(Date value) {
            addCriterion("APPROVE_TIME <", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPROVE_TIME <=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIn(List<Date> values) {
            addCriterion("APPROVE_TIME in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotIn(List<Date> values) {
            addCriterion("APPROVE_TIME not in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeBetween(Date value1, Date value2) {
            addCriterion("APPROVE_TIME between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPROVE_TIME not between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoIsNull() {
            addCriterion("WORKFLOW_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoIsNotNull() {
            addCriterion("WORKFLOW_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoEqualTo(String value) {
            addCriterion("WORKFLOW_APPNO =", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoNotEqualTo(String value) {
            addCriterion("WORKFLOW_APPNO <>", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoGreaterThan(String value) {
            addCriterion("WORKFLOW_APPNO >", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("WORKFLOW_APPNO >=", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoLessThan(String value) {
            addCriterion("WORKFLOW_APPNO <", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoLessThanOrEqualTo(String value) {
            addCriterion("WORKFLOW_APPNO <=", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoLike(String value) {
            addCriterion("WORKFLOW_APPNO like", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoNotLike(String value) {
            addCriterion("WORKFLOW_APPNO not like", value, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoIn(List<String> values) {
            addCriterion("WORKFLOW_APPNO in", values, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoNotIn(List<String> values) {
            addCriterion("WORKFLOW_APPNO not in", values, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoBetween(String value1, String value2) {
            addCriterion("WORKFLOW_APPNO between", value1, value2, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andWorkflowAppnoNotBetween(String value1, String value2) {
            addCriterion("WORKFLOW_APPNO not between", value1, value2, "workflowAppno");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlIsNull() {
            addCriterion("APPLI_STATUS_DTL is null");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlIsNotNull() {
            addCriterion("APPLI_STATUS_DTL is not null");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlEqualTo(String value) {
            addCriterion("APPLI_STATUS_DTL =", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlNotEqualTo(String value) {
            addCriterion("APPLI_STATUS_DTL <>", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlGreaterThan(String value) {
            addCriterion("APPLI_STATUS_DTL >", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlGreaterThanOrEqualTo(String value) {
            addCriterion("APPLI_STATUS_DTL >=", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlLessThan(String value) {
            addCriterion("APPLI_STATUS_DTL <", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlLessThanOrEqualTo(String value) {
            addCriterion("APPLI_STATUS_DTL <=", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlLike(String value) {
            addCriterion("APPLI_STATUS_DTL like", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlNotLike(String value) {
            addCriterion("APPLI_STATUS_DTL not like", value, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlIn(List<String> values) {
            addCriterion("APPLI_STATUS_DTL in", values, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlNotIn(List<String> values) {
            addCriterion("APPLI_STATUS_DTL not in", values, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlBetween(String value1, String value2) {
            addCriterion("APPLI_STATUS_DTL between", value1, value2, "appliStatusDtl");
            return (Criteria) this;
        }

        public Criteria andAppliStatusDtlNotBetween(String value1, String value2) {
            addCriterion("APPLI_STATUS_DTL not between", value1, value2, "appliStatusDtl");
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

        public Criteria andAppDateIsNull() {
            addCriterion("APP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNotNull() {
            addCriterion("APP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAppDateEqualTo(String value) {
            addCriterion("APP_DATE =", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotEqualTo(String value) {
            addCriterion("APP_DATE <>", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThan(String value) {
            addCriterion("APP_DATE >", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThanOrEqualTo(String value) {
            addCriterion("APP_DATE >=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThan(String value) {
            addCriterion("APP_DATE <", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThanOrEqualTo(String value) {
            addCriterion("APP_DATE <=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLike(String value) {
            addCriterion("APP_DATE like", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotLike(String value) {
            addCriterion("APP_DATE not like", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateIn(List<String> values) {
            addCriterion("APP_DATE in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotIn(List<String> values) {
            addCriterion("APP_DATE not in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateBetween(String value1, String value2) {
            addCriterion("APP_DATE between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotBetween(String value1, String value2) {
            addCriterion("APP_DATE not between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdIsNull() {
            addCriterion("APP_TLRCD is null");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdIsNotNull() {
            addCriterion("APP_TLRCD is not null");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdEqualTo(String value) {
            addCriterion("APP_TLRCD =", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotEqualTo(String value) {
            addCriterion("APP_TLRCD <>", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdGreaterThan(String value) {
            addCriterion("APP_TLRCD >", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_TLRCD >=", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdLessThan(String value) {
            addCriterion("APP_TLRCD <", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdLessThanOrEqualTo(String value) {
            addCriterion("APP_TLRCD <=", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdLike(String value) {
            addCriterion("APP_TLRCD like", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotLike(String value) {
            addCriterion("APP_TLRCD not like", value, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdIn(List<String> values) {
            addCriterion("APP_TLRCD in", values, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotIn(List<String> values) {
            addCriterion("APP_TLRCD not in", values, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdBetween(String value1, String value2) {
            addCriterion("APP_TLRCD between", value1, value2, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppTlrcdNotBetween(String value1, String value2) {
            addCriterion("APP_TLRCD not between", value1, value2, "appTlrcd");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeIsNull() {
            addCriterion("APP_BRCODE is null");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeIsNotNull() {
            addCriterion("APP_BRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeEqualTo(String value) {
            addCriterion("APP_BRCODE =", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeNotEqualTo(String value) {
            addCriterion("APP_BRCODE <>", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeGreaterThan(String value) {
            addCriterion("APP_BRCODE >", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("APP_BRCODE >=", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeLessThan(String value) {
            addCriterion("APP_BRCODE <", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeLessThanOrEqualTo(String value) {
            addCriterion("APP_BRCODE <=", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeLike(String value) {
            addCriterion("APP_BRCODE like", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeNotLike(String value) {
            addCriterion("APP_BRCODE not like", value, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeIn(List<String> values) {
            addCriterion("APP_BRCODE in", values, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeNotIn(List<String> values) {
            addCriterion("APP_BRCODE not in", values, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeBetween(String value1, String value2) {
            addCriterion("APP_BRCODE between", value1, value2, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andAppBrcodeNotBetween(String value1, String value2) {
            addCriterion("APP_BRCODE not between", value1, value2, "appBrcode");
            return (Criteria) this;
        }

        public Criteria andBailAmountIsNull() {
            addCriterion("BAIL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBailAmountIsNotNull() {
            addCriterion("BAIL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBailAmountEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT =", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <>", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountGreaterThan(BigDecimal value) {
            addCriterion("BAIL_AMOUNT >", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT >=", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountLessThan(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAIL_AMOUNT <=", value, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMOUNT in", values, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotIn(List<BigDecimal> values) {
            addCriterion("BAIL_AMOUNT not in", values, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMOUNT between", value1, value2, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andBailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAIL_AMOUNT not between", value1, value2, "bailAmount");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIsNull() {
            addCriterion("SLAVE_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIsNotNull() {
            addCriterion("SLAVE_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoEqualTo(String value) {
            addCriterion("SLAVE_CONTNO =", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotEqualTo(String value) {
            addCriterion("SLAVE_CONTNO <>", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoGreaterThan(String value) {
            addCriterion("SLAVE_CONTNO >", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoGreaterThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTNO >=", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLessThan(String value) {
            addCriterion("SLAVE_CONTNO <", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLessThanOrEqualTo(String value) {
            addCriterion("SLAVE_CONTNO <=", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoLike(String value) {
            addCriterion("SLAVE_CONTNO like", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotLike(String value) {
            addCriterion("SLAVE_CONTNO not like", value, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoIn(List<String> values) {
            addCriterion("SLAVE_CONTNO in", values, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotIn(List<String> values) {
            addCriterion("SLAVE_CONTNO not in", values, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTNO between", value1, value2, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andSlaveContnoNotBetween(String value1, String value2) {
            addCriterion("SLAVE_CONTNO not between", value1, value2, "slaveContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoIsNull() {
            addCriterion("MAST_CONTNO is null");
            return (Criteria) this;
        }

        public Criteria andMastContnoIsNotNull() {
            addCriterion("MAST_CONTNO is not null");
            return (Criteria) this;
        }

        public Criteria andMastContnoEqualTo(String value) {
            addCriterion("MAST_CONTNO =", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotEqualTo(String value) {
            addCriterion("MAST_CONTNO <>", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoGreaterThan(String value) {
            addCriterion("MAST_CONTNO >", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoGreaterThanOrEqualTo(String value) {
            addCriterion("MAST_CONTNO >=", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLessThan(String value) {
            addCriterion("MAST_CONTNO <", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLessThanOrEqualTo(String value) {
            addCriterion("MAST_CONTNO <=", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoLike(String value) {
            addCriterion("MAST_CONTNO like", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotLike(String value) {
            addCriterion("MAST_CONTNO not like", value, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoIn(List<String> values) {
            addCriterion("MAST_CONTNO in", values, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotIn(List<String> values) {
            addCriterion("MAST_CONTNO not in", values, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoBetween(String value1, String value2) {
            addCriterion("MAST_CONTNO between", value1, value2, "mastContno");
            return (Criteria) this;
        }

        public Criteria andMastContnoNotBetween(String value1, String value2) {
            addCriterion("MAST_CONTNO not between", value1, value2, "mastContno");
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

        public Criteria andSupplyChainPdIdIsNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIsNotNull() {
            addCriterion("SUPPLY_CHAIN_PD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID =", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <>", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID >=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThan(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLessThanOrEqualTo(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID <=", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotLike(String value) {
            addCriterion("SUPPLY_CHAIN_PD_ID not like", value, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotIn(List<String> values) {
            addCriterion("SUPPLY_CHAIN_PD_ID not in", values, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andSupplyChainPdIdNotBetween(String value1, String value2) {
            addCriterion("SUPPLY_CHAIN_PD_ID not between", value1, value2, "supplyChainPdId");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoIsNull() {
            addCriterion("INCOME_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoIsNotNull() {
            addCriterion("INCOME_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoEqualTo(String value) {
            addCriterion("INCOME_APPNO =", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoNotEqualTo(String value) {
            addCriterion("INCOME_APPNO <>", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoGreaterThan(String value) {
            addCriterion("INCOME_APPNO >", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_APPNO >=", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoLessThan(String value) {
            addCriterion("INCOME_APPNO <", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoLessThanOrEqualTo(String value) {
            addCriterion("INCOME_APPNO <=", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoLike(String value) {
            addCriterion("INCOME_APPNO like", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoNotLike(String value) {
            addCriterion("INCOME_APPNO not like", value, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoIn(List<String> values) {
            addCriterion("INCOME_APPNO in", values, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoNotIn(List<String> values) {
            addCriterion("INCOME_APPNO not in", values, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoBetween(String value1, String value2) {
            addCriterion("INCOME_APPNO between", value1, value2, "incomeAppno");
            return (Criteria) this;
        }

        public Criteria andIncomeAppnoNotBetween(String value1, String value2) {
            addCriterion("INCOME_APPNO not between", value1, value2, "incomeAppno");
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

        public Criteria andPledgeModeIsNull() {
            addCriterion("PLEDGE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andPledgeModeIsNotNull() {
            addCriterion("PLEDGE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeModeEqualTo(String value) {
            addCriterion("PLEDGE_MODE =", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotEqualTo(String value) {
            addCriterion("PLEDGE_MODE <>", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeGreaterThan(String value) {
            addCriterion("PLEDGE_MODE >", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeGreaterThanOrEqualTo(String value) {
            addCriterion("PLEDGE_MODE >=", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeLessThan(String value) {
            addCriterion("PLEDGE_MODE <", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeLessThanOrEqualTo(String value) {
            addCriterion("PLEDGE_MODE <=", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeLike(String value) {
            addCriterion("PLEDGE_MODE like", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotLike(String value) {
            addCriterion("PLEDGE_MODE not like", value, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeIn(List<String> values) {
            addCriterion("PLEDGE_MODE in", values, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotIn(List<String> values) {
            addCriterion("PLEDGE_MODE not in", values, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeBetween(String value1, String value2) {
            addCriterion("PLEDGE_MODE between", value1, value2, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andPledgeModeNotBetween(String value1, String value2) {
            addCriterion("PLEDGE_MODE not between", value1, value2, "pledgeMode");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIsNull() {
            addCriterion("OTHER_PROTOCOL_NO is null");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIsNotNull() {
            addCriterion("OTHER_PROTOCOL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO =", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO <>", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoGreaterThan(String value) {
            addCriterion("OTHER_PROTOCOL_NO >", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO >=", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLessThan(String value) {
            addCriterion("OTHER_PROTOCOL_NO <", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLessThanOrEqualTo(String value) {
            addCriterion("OTHER_PROTOCOL_NO <=", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoLike(String value) {
            addCriterion("OTHER_PROTOCOL_NO like", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotLike(String value) {
            addCriterion("OTHER_PROTOCOL_NO not like", value, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoIn(List<String> values) {
            addCriterion("OTHER_PROTOCOL_NO in", values, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotIn(List<String> values) {
            addCriterion("OTHER_PROTOCOL_NO not in", values, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoBetween(String value1, String value2) {
            addCriterion("OTHER_PROTOCOL_NO between", value1, value2, "otherProtocolNo");
            return (Criteria) this;
        }

        public Criteria andOtherProtocolNoNotBetween(String value1, String value2) {
            addCriterion("OTHER_PROTOCOL_NO not between", value1, value2, "otherProtocolNo");
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

        public Criteria andEbankAppnoIsNull() {
            addCriterion("EBANK_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoIsNotNull() {
            addCriterion("EBANK_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoEqualTo(String value) {
            addCriterion("EBANK_APPNO =", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotEqualTo(String value) {
            addCriterion("EBANK_APPNO <>", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoGreaterThan(String value) {
            addCriterion("EBANK_APPNO >", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("EBANK_APPNO >=", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoLessThan(String value) {
            addCriterion("EBANK_APPNO <", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoLessThanOrEqualTo(String value) {
            addCriterion("EBANK_APPNO <=", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoLike(String value) {
            addCriterion("EBANK_APPNO like", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotLike(String value) {
            addCriterion("EBANK_APPNO not like", value, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoIn(List<String> values) {
            addCriterion("EBANK_APPNO in", values, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotIn(List<String> values) {
            addCriterion("EBANK_APPNO not in", values, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoBetween(String value1, String value2) {
            addCriterion("EBANK_APPNO between", value1, value2, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andEbankAppnoNotBetween(String value1, String value2) {
            addCriterion("EBANK_APPNO not between", value1, value2, "ebankAppno");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIsNull() {
            addCriterion("MAST_CONTCODE is null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIsNotNull() {
            addCriterion("MAST_CONTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andMastContcodeEqualTo(String value) {
            addCriterion("MAST_CONTCODE =", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotEqualTo(String value) {
            addCriterion("MAST_CONTCODE <>", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThan(String value) {
            addCriterion("MAST_CONTCODE >", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeGreaterThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE >=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThan(String value) {
            addCriterion("MAST_CONTCODE <", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLessThanOrEqualTo(String value) {
            addCriterion("MAST_CONTCODE <=", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeLike(String value) {
            addCriterion("MAST_CONTCODE like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotLike(String value) {
            addCriterion("MAST_CONTCODE not like", value, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeIn(List<String> values) {
            addCriterion("MAST_CONTCODE in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotIn(List<String> values) {
            addCriterion("MAST_CONTCODE not in", values, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE between", value1, value2, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andMastContcodeNotBetween(String value1, String value2) {
            addCriterion("MAST_CONTCODE not between", value1, value2, "mastContcode");
            return (Criteria) this;
        }

        public Criteria andChannelFlagIsNull() {
            addCriterion("CHANNEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andChannelFlagIsNotNull() {
            addCriterion("CHANNEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFlagEqualTo(String value) {
            addCriterion("CHANNEL_FLAG =", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotEqualTo(String value) {
            addCriterion("CHANNEL_FLAG <>", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagGreaterThan(String value) {
            addCriterion("CHANNEL_FLAG >", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_FLAG >=", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagLessThan(String value) {
            addCriterion("CHANNEL_FLAG <", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_FLAG <=", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagLike(String value) {
            addCriterion("CHANNEL_FLAG like", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotLike(String value) {
            addCriterion("CHANNEL_FLAG not like", value, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagIn(List<String> values) {
            addCriterion("CHANNEL_FLAG in", values, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotIn(List<String> values) {
            addCriterion("CHANNEL_FLAG not in", values, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagBetween(String value1, String value2) {
            addCriterion("CHANNEL_FLAG between", value1, value2, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andChannelFlagNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_FLAG not between", value1, value2, "channelFlag");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndIsNull() {
            addCriterion("IS_FLOW_END is null");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndIsNotNull() {
            addCriterion("IS_FLOW_END is not null");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndEqualTo(String value) {
            addCriterion("IS_FLOW_END =", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndNotEqualTo(String value) {
            addCriterion("IS_FLOW_END <>", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndGreaterThan(String value) {
            addCriterion("IS_FLOW_END >", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FLOW_END >=", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndLessThan(String value) {
            addCriterion("IS_FLOW_END <", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndLessThanOrEqualTo(String value) {
            addCriterion("IS_FLOW_END <=", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndLike(String value) {
            addCriterion("IS_FLOW_END like", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndNotLike(String value) {
            addCriterion("IS_FLOW_END not like", value, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndIn(List<String> values) {
            addCriterion("IS_FLOW_END in", values, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndNotIn(List<String> values) {
            addCriterion("IS_FLOW_END not in", values, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndBetween(String value1, String value2) {
            addCriterion("IS_FLOW_END between", value1, value2, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIsFlowEndNotBetween(String value1, String value2) {
            addCriterion("IS_FLOW_END not between", value1, value2, "isFlowEnd");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoIsNull() {
            addCriterion("IFSP_APPNO is null");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoIsNotNull() {
            addCriterion("IFSP_APPNO is not null");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoEqualTo(String value) {
            addCriterion("IFSP_APPNO =", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoNotEqualTo(String value) {
            addCriterion("IFSP_APPNO <>", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoGreaterThan(String value) {
            addCriterion("IFSP_APPNO >", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoGreaterThanOrEqualTo(String value) {
            addCriterion("IFSP_APPNO >=", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoLessThan(String value) {
            addCriterion("IFSP_APPNO <", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoLessThanOrEqualTo(String value) {
            addCriterion("IFSP_APPNO <=", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoLike(String value) {
            addCriterion("IFSP_APPNO like", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoNotLike(String value) {
            addCriterion("IFSP_APPNO not like", value, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoIn(List<String> values) {
            addCriterion("IFSP_APPNO in", values, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoNotIn(List<String> values) {
            addCriterion("IFSP_APPNO not in", values, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoBetween(String value1, String value2) {
            addCriterion("IFSP_APPNO between", value1, value2, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspAppnoNotBetween(String value1, String value2) {
            addCriterion("IFSP_APPNO not between", value1, value2, "ifspAppno");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoIsNull() {
            addCriterion("IFSP_ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoIsNotNull() {
            addCriterion("IFSP_ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoEqualTo(String value) {
            addCriterion("IFSP_ORDER_NO =", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoNotEqualTo(String value) {
            addCriterion("IFSP_ORDER_NO <>", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoGreaterThan(String value) {
            addCriterion("IFSP_ORDER_NO >", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("IFSP_ORDER_NO >=", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoLessThan(String value) {
            addCriterion("IFSP_ORDER_NO <", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoLessThanOrEqualTo(String value) {
            addCriterion("IFSP_ORDER_NO <=", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoLike(String value) {
            addCriterion("IFSP_ORDER_NO like", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoNotLike(String value) {
            addCriterion("IFSP_ORDER_NO not like", value, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoIn(List<String> values) {
            addCriterion("IFSP_ORDER_NO in", values, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoNotIn(List<String> values) {
            addCriterion("IFSP_ORDER_NO not in", values, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoBetween(String value1, String value2) {
            addCriterion("IFSP_ORDER_NO between", value1, value2, "ifspOrderNo");
            return (Criteria) this;
        }

        public Criteria andIfspOrderNoNotBetween(String value1, String value2) {
            addCriterion("IFSP_ORDER_NO not between", value1, value2, "ifspOrderNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}