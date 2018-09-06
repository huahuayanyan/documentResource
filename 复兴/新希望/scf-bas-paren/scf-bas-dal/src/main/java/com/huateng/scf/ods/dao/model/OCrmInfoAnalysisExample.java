package com.huateng.scf.ods.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OCrmInfoAnalysisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OCrmInfoAnalysisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected OCrmInfoAnalysisExample(OCrmInfoAnalysisExample example) {
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

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNull() {
            addCriterion("INDUSTRY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNotNull() {
            addCriterion("INDUSTRY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE =", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE <>", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThan(String value) {
            addCriterion("INDUSTRY_TYPE >", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE >=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThan(String value) {
            addCriterion("INDUSTRY_TYPE <", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE <=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLike(String value) {
            addCriterion("INDUSTRY_TYPE like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotLike(String value) {
            addCriterion("INDUSTRY_TYPE not like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE not in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE not between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(String value) {
            addCriterion("OPEN_DATE =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(String value) {
            addCriterion("OPEN_DATE <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(String value) {
            addCriterion("OPEN_DATE >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_DATE >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(String value) {
            addCriterion("OPEN_DATE <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(String value) {
            addCriterion("OPEN_DATE <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLike(String value) {
            addCriterion("OPEN_DATE like", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotLike(String value) {
            addCriterion("OPEN_DATE not like", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<String> values) {
            addCriterion("OPEN_DATE in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<String> values) {
            addCriterion("OPEN_DATE not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(String value1, String value2) {
            addCriterion("OPEN_DATE between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(String value1, String value2) {
            addCriterion("OPEN_DATE not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtIsNull() {
            addCriterion("ANNUAL_SALES_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtIsNotNull() {
            addCriterion("ANNUAL_SALES_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_SALES_AMT =", value, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtNotEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_SALES_AMT <>", value, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtGreaterThan(BigDecimal value) {
            addCriterion("ANNUAL_SALES_AMT >", value, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_SALES_AMT >=", value, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtLessThan(BigDecimal value) {
            addCriterion("ANNUAL_SALES_AMT <", value, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_SALES_AMT <=", value, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_SALES_AMT in", values, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtNotIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_SALES_AMT not in", values, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_SALES_AMT between", value1, value2, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualSalesAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_SALES_AMT not between", value1, value2, "annualSalesAmt");
            return (Criteria) this;
        }

        public Criteria andSalesRateIsNull() {
            addCriterion("SALES_RATE is null");
            return (Criteria) this;
        }

        public Criteria andSalesRateIsNotNull() {
            addCriterion("SALES_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andSalesRateEqualTo(BigDecimal value) {
            addCriterion("SALES_RATE =", value, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateNotEqualTo(BigDecimal value) {
            addCriterion("SALES_RATE <>", value, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateGreaterThan(BigDecimal value) {
            addCriterion("SALES_RATE >", value, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_RATE >=", value, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateLessThan(BigDecimal value) {
            addCriterion("SALES_RATE <", value, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_RATE <=", value, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateIn(List<BigDecimal> values) {
            addCriterion("SALES_RATE in", values, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateNotIn(List<BigDecimal> values) {
            addCriterion("SALES_RATE not in", values, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_RATE between", value1, value2, "salesRate");
            return (Criteria) this;
        }

        public Criteria andSalesRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_RATE not between", value1, value2, "salesRate");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtIsNull() {
            addCriterion("ANNUAL_PURCHASE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtIsNotNull() {
            addCriterion("ANNUAL_PURCHASE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PURCHASE_AMT =", value, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtNotEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PURCHASE_AMT <>", value, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtGreaterThan(BigDecimal value) {
            addCriterion("ANNUAL_PURCHASE_AMT >", value, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PURCHASE_AMT >=", value, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtLessThan(BigDecimal value) {
            addCriterion("ANNUAL_PURCHASE_AMT <", value, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PURCHASE_AMT <=", value, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_PURCHASE_AMT in", values, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtNotIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_PURCHASE_AMT not in", values, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_PURCHASE_AMT between", value1, value2, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andAnnualPurchaseAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_PURCHASE_AMT not between", value1, value2, "annualPurchaseAmt");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateIsNull() {
            addCriterion("PURCHASE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateIsNotNull() {
            addCriterion("PURCHASE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_RATE =", value, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateNotEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_RATE <>", value, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateGreaterThan(BigDecimal value) {
            addCriterion("PURCHASE_RATE >", value, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_RATE >=", value, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateLessThan(BigDecimal value) {
            addCriterion("PURCHASE_RATE <", value, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_RATE <=", value, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateIn(List<BigDecimal> values) {
            addCriterion("PURCHASE_RATE in", values, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateNotIn(List<BigDecimal> values) {
            addCriterion("PURCHASE_RATE not in", values, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PURCHASE_RATE between", value1, value2, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PURCHASE_RATE not between", value1, value2, "purchaseRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRecIsNull() {
            addCriterion("ANNUAL_REC is null");
            return (Criteria) this;
        }

        public Criteria andAnnualRecIsNotNull() {
            addCriterion("ANNUAL_REC is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualRecEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_REC =", value, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecNotEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_REC <>", value, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecGreaterThan(BigDecimal value) {
            addCriterion("ANNUAL_REC >", value, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_REC >=", value, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecLessThan(BigDecimal value) {
            addCriterion("ANNUAL_REC <", value, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_REC <=", value, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_REC in", values, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecNotIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_REC not in", values, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_REC between", value1, value2, "annualRec");
            return (Criteria) this;
        }

        public Criteria andAnnualRecNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_REC not between", value1, value2, "annualRec");
            return (Criteria) this;
        }

        public Criteria andOverdueRateIsNull() {
            addCriterion("OVERDUE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andOverdueRateIsNotNull() {
            addCriterion("OVERDUE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueRateEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_RATE =", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateNotEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_RATE <>", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateGreaterThan(BigDecimal value) {
            addCriterion("OVERDUE_RATE >", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_RATE >=", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateLessThan(BigDecimal value) {
            addCriterion("OVERDUE_RATE <", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_RATE <=", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_RATE in", values, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateNotIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_RATE not in", values, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_RATE between", value1, value2, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_RATE not between", value1, value2, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andAverageAgeIsNull() {
            addCriterion("AVERAGE_AGE is null");
            return (Criteria) this;
        }

        public Criteria andAverageAgeIsNotNull() {
            addCriterion("AVERAGE_AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAverageAgeEqualTo(BigDecimal value) {
            addCriterion("AVERAGE_AGE =", value, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeNotEqualTo(BigDecimal value) {
            addCriterion("AVERAGE_AGE <>", value, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeGreaterThan(BigDecimal value) {
            addCriterion("AVERAGE_AGE >", value, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AVERAGE_AGE >=", value, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeLessThan(BigDecimal value) {
            addCriterion("AVERAGE_AGE <", value, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AVERAGE_AGE <=", value, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeIn(List<BigDecimal> values) {
            addCriterion("AVERAGE_AGE in", values, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeNotIn(List<BigDecimal> values) {
            addCriterion("AVERAGE_AGE not in", values, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AVERAGE_AGE between", value1, value2, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAverageAgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AVERAGE_AGE not between", value1, value2, "averageAge");
            return (Criteria) this;
        }

        public Criteria andAnnualPayIsNull() {
            addCriterion("ANNUAL_PAY is null");
            return (Criteria) this;
        }

        public Criteria andAnnualPayIsNotNull() {
            addCriterion("ANNUAL_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualPayEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PAY =", value, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayNotEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PAY <>", value, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayGreaterThan(BigDecimal value) {
            addCriterion("ANNUAL_PAY >", value, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PAY >=", value, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayLessThan(BigDecimal value) {
            addCriterion("ANNUAL_PAY <", value, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAL_PAY <=", value, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_PAY in", values, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayNotIn(List<BigDecimal> values) {
            addCriterion("ANNUAL_PAY not in", values, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_PAY between", value1, value2, "annualPay");
            return (Criteria) this;
        }

        public Criteria andAnnualPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAL_PAY not between", value1, value2, "annualPay");
            return (Criteria) this;
        }

        public Criteria andProfitRateIsNull() {
            addCriterion("PROFIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andProfitRateIsNotNull() {
            addCriterion("PROFIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andProfitRateEqualTo(BigDecimal value) {
            addCriterion("PROFIT_RATE =", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateNotEqualTo(BigDecimal value) {
            addCriterion("PROFIT_RATE <>", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateGreaterThan(BigDecimal value) {
            addCriterion("PROFIT_RATE >", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROFIT_RATE >=", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateLessThan(BigDecimal value) {
            addCriterion("PROFIT_RATE <", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROFIT_RATE <=", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateIn(List<BigDecimal> values) {
            addCriterion("PROFIT_RATE in", values, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateNotIn(List<BigDecimal> values) {
            addCriterion("PROFIT_RATE not in", values, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROFIT_RATE between", value1, value2, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROFIT_RATE not between", value1, value2, "profitRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateIsNull() {
            addCriterion("ERP_USED_RATE is null");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateIsNotNull() {
            addCriterion("ERP_USED_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateEqualTo(BigDecimal value) {
            addCriterion("ERP_USED_RATE =", value, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateNotEqualTo(BigDecimal value) {
            addCriterion("ERP_USED_RATE <>", value, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateGreaterThan(BigDecimal value) {
            addCriterion("ERP_USED_RATE >", value, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ERP_USED_RATE >=", value, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateLessThan(BigDecimal value) {
            addCriterion("ERP_USED_RATE <", value, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ERP_USED_RATE <=", value, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateIn(List<BigDecimal> values) {
            addCriterion("ERP_USED_RATE in", values, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateNotIn(List<BigDecimal> values) {
            addCriterion("ERP_USED_RATE not in", values, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ERP_USED_RATE between", value1, value2, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andErpUsedRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ERP_USED_RATE not between", value1, value2, "erpUsedRate");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("RELATION is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("RELATION is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(BigDecimal value) {
            addCriterion("RELATION =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(BigDecimal value) {
            addCriterion("RELATION <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(BigDecimal value) {
            addCriterion("RELATION >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RELATION >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(BigDecimal value) {
            addCriterion("RELATION <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RELATION <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<BigDecimal> values) {
            addCriterion("RELATION in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<BigDecimal> values) {
            addCriterion("RELATION not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RELATION between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RELATION not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirIsNull() {
            addCriterion("QUALITY_ENVIR is null");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirIsNotNull() {
            addCriterion("QUALITY_ENVIR is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirEqualTo(BigDecimal value) {
            addCriterion("QUALITY_ENVIR =", value, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirNotEqualTo(BigDecimal value) {
            addCriterion("QUALITY_ENVIR <>", value, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirGreaterThan(BigDecimal value) {
            addCriterion("QUALITY_ENVIR >", value, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUALITY_ENVIR >=", value, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirLessThan(BigDecimal value) {
            addCriterion("QUALITY_ENVIR <", value, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUALITY_ENVIR <=", value, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirIn(List<BigDecimal> values) {
            addCriterion("QUALITY_ENVIR in", values, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirNotIn(List<BigDecimal> values) {
            addCriterion("QUALITY_ENVIR not in", values, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUALITY_ENVIR between", value1, value2, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andQualityEnvirNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUALITY_ENVIR not between", value1, value2, "qualityEnvir");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateIsNull() {
            addCriterion("SALES_PROFIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateIsNotNull() {
            addCriterion("SALES_PROFIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateEqualTo(BigDecimal value) {
            addCriterion("SALES_PROFIT_RATE =", value, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateNotEqualTo(BigDecimal value) {
            addCriterion("SALES_PROFIT_RATE <>", value, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateGreaterThan(BigDecimal value) {
            addCriterion("SALES_PROFIT_RATE >", value, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_PROFIT_RATE >=", value, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateLessThan(BigDecimal value) {
            addCriterion("SALES_PROFIT_RATE <", value, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_PROFIT_RATE <=", value, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateIn(List<BigDecimal> values) {
            addCriterion("SALES_PROFIT_RATE in", values, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateNotIn(List<BigDecimal> values) {
            addCriterion("SALES_PROFIT_RATE not in", values, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_PROFIT_RATE between", value1, value2, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andSalesProfitRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_PROFIT_RATE not between", value1, value2, "salesProfitRate");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthIsNull() {
            addCriterion("ANNUAN_GROWTH is null");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthIsNotNull() {
            addCriterion("ANNUAN_GROWTH is not null");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthEqualTo(BigDecimal value) {
            addCriterion("ANNUAN_GROWTH =", value, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthNotEqualTo(BigDecimal value) {
            addCriterion("ANNUAN_GROWTH <>", value, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthGreaterThan(BigDecimal value) {
            addCriterion("ANNUAN_GROWTH >", value, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAN_GROWTH >=", value, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthLessThan(BigDecimal value) {
            addCriterion("ANNUAN_GROWTH <", value, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUAN_GROWTH <=", value, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthIn(List<BigDecimal> values) {
            addCriterion("ANNUAN_GROWTH in", values, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthNotIn(List<BigDecimal> values) {
            addCriterion("ANNUAN_GROWTH not in", values, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAN_GROWTH between", value1, value2, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andAnnuanGrowthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUAN_GROWTH not between", value1, value2, "annuanGrowth");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateIsNull() {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateIsNotNull() {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE =", value, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateNotEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE <>", value, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateGreaterThan(BigDecimal value) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE >", value, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE >=", value, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateLessThan(BigDecimal value) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE <", value, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE <=", value, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE in", values, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateNotIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE not in", values, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE between", value1, value2, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaSaleActiveRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_SALE_ACTIVE_RATE not between", value1, value2, "lastquaSaleActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateIsNull() {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateIsNotNull() {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE =", value, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateNotEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE <>", value, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateGreaterThan(BigDecimal value) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE >", value, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE >=", value, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateLessThan(BigDecimal value) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE <", value, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE <=", value, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE in", values, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateNotIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE not in", values, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE between", value1, value2, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaPuaActiveRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_PUA_ACTIVE_RATE not between", value1, value2, "lastquaPuaActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateIsNull() {
            addCriterion("LASTQUA_IN_ACTIVE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateIsNotNull() {
            addCriterion("LASTQUA_IN_ACTIVE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE =", value, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateNotEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE <>", value, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateGreaterThan(BigDecimal value) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE >", value, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE >=", value, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateLessThan(BigDecimal value) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE <", value, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE <=", value, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE in", values, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateNotIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE not in", values, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE between", value1, value2, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaInActiveRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_IN_ACTIVE_RATE not between", value1, value2, "lastquaInActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateIsNull() {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateIsNotNull() {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE =", value, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateNotEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE <>", value, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateGreaterThan(BigDecimal value) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE >", value, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE >=", value, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateLessThan(BigDecimal value) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE <", value, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE <=", value, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE in", values, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateNotIn(List<BigDecimal> values) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE not in", values, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE between", value1, value2, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andLastquaOutActiveRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTQUA_OUT_ACTIVE_RATE not between", value1, value2, "lastquaOutActiveRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateIsNull() {
            addCriterion("DEPOSIT_MY_RATE is null");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateIsNotNull() {
            addCriterion("DEPOSIT_MY_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_MY_RATE =", value, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_MY_RATE <>", value, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateGreaterThan(BigDecimal value) {
            addCriterion("DEPOSIT_MY_RATE >", value, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_MY_RATE >=", value, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateLessThan(BigDecimal value) {
            addCriterion("DEPOSIT_MY_RATE <", value, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_MY_RATE <=", value, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT_MY_RATE in", values, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT_MY_RATE not in", values, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT_MY_RATE between", value1, value2, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andDepositMyRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT_MY_RATE not between", value1, value2, "depositMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNull() {
            addCriterion("CREDIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNotNull() {
            addCriterion("CREDIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRateEqualTo(BigDecimal value) {
            addCriterion("CREDIT_RATE =", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_RATE <>", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_RATE >", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_RATE >=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThan(BigDecimal value) {
            addCriterion("CREDIT_RATE <", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_RATE <=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateIn(List<Long> values) {
            addCriterion("CREDIT_RATE in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotIn(List<Long> values) {
            addCriterion("CREDIT_RATE not in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateBetween(Long value1, Long value2) {
            addCriterion("CREDIT_RATE between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotBetween(Long value1, Long value2) {
            addCriterion("CREDIT_RATE not between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateIsNull() {
            addCriterion("CREDIT_MY_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateIsNotNull() {
            addCriterion("CREDIT_MY_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MY_RATE =", value, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MY_RATE <>", value, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_MY_RATE >", value, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MY_RATE >=", value, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateLessThan(BigDecimal value) {
            addCriterion("CREDIT_MY_RATE <", value, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MY_RATE <=", value, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateIn(List<BigDecimal> values) {
            addCriterion("CREDIT_MY_RATE in", values, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_MY_RATE not in", values, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_MY_RATE between", value1, value2, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andCreditMyRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_MY_RATE not between", value1, value2, "creditMyRate");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsIsNull() {
            addCriterion("THREEM_DALIY_ASSETS is null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsIsNotNull() {
            addCriterion("THREEM_DALIY_ASSETS is not null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_ASSETS =", value, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsNotEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_ASSETS <>", value, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsGreaterThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_ASSETS >", value, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_ASSETS >=", value, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsLessThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_ASSETS <", value, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_ASSETS <=", value, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_ASSETS in", values, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsNotIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_ASSETS not in", values, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_ASSETS between", value1, value2, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyAssetsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_ASSETS not between", value1, value2, "threemDaliyAssets");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositIsNull() {
            addCriterion("THREEM_DALIY_DEPOSIT is null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositIsNotNull() {
            addCriterion("THREEM_DALIY_DEPOSIT is not null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_DEPOSIT =", value, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositNotEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_DEPOSIT <>", value, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositGreaterThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_DEPOSIT >", value, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_DEPOSIT >=", value, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositLessThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_DEPOSIT <", value, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_DEPOSIT <=", value, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_DEPOSIT in", values, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositNotIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_DEPOSIT not in", values, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_DEPOSIT between", value1, value2, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_DEPOSIT not between", value1, value2, "threemDaliyDeposit");
            return (Criteria) this;
        }

        public Criteria andAssetsIsNull() {
            addCriterion("ASSETS is null");
            return (Criteria) this;
        }

        public Criteria andAssetsIsNotNull() {
            addCriterion("ASSETS is not null");
            return (Criteria) this;
        }

        public Criteria andAssetsEqualTo(BigDecimal value) {
            addCriterion("ASSETS =", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsNotEqualTo(BigDecimal value) {
            addCriterion("ASSETS <>", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsGreaterThan(BigDecimal value) {
            addCriterion("ASSETS >", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSETS >=", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsLessThan(BigDecimal value) {
            addCriterion("ASSETS <", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSETS <=", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsIn(List<BigDecimal> values) {
            addCriterion("ASSETS in", values, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsNotIn(List<BigDecimal> values) {
            addCriterion("ASSETS not in", values, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSETS between", value1, value2, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSETS not between", value1, value2, "assets");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("DEPOSIT is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("DEPOSIT is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("DEPOSIT >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("DEPOSIT <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInIsNull() {
            addCriterion("THREEM_DALIY_LOAN_IN is null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInIsNotNull() {
            addCriterion("THREEM_DALIY_LOAN_IN is not null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_IN =", value, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInNotEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_IN <>", value, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInGreaterThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_IN >", value, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_IN >=", value, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInLessThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_IN <", value, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_IN <=", value, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_LOAN_IN in", values, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInNotIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_LOAN_IN not in", values, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_LOAN_IN between", value1, value2, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_LOAN_IN not between", value1, value2, "threemDaliyLoanIn");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutIsNull() {
            addCriterion("THREEM_DALIY_LOAN_OUT is null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutIsNotNull() {
            addCriterion("THREEM_DALIY_LOAN_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_OUT =", value, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutNotEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_OUT <>", value, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutGreaterThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_OUT >", value, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_OUT >=", value, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutLessThan(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_OUT <", value, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THREEM_DALIY_LOAN_OUT <=", value, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_LOAN_OUT in", values, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutNotIn(List<BigDecimal> values) {
            addCriterion("THREEM_DALIY_LOAN_OUT not in", values, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_LOAN_OUT between", value1, value2, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andThreemDaliyLoanOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THREEM_DALIY_LOAN_OUT not between", value1, value2, "threemDaliyLoanOut");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIsNull() {
            addCriterion("OVERDUE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIsNotNull() {
            addCriterion("OVERDUE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT =", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT <>", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountGreaterThan(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT >", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT >=", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountLessThan(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT <", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_AMOUNT <=", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_AMOUNT in", values, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_AMOUNT not in", values, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_AMOUNT between", value1, value2, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_AMOUNT not between", value1, value2, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtIsNull() {
            addCriterion("PRINCIPAL_LOSS_AMT is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtIsNotNull() {
            addCriterion("PRINCIPAL_LOSS_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtEqualTo(BigDecimal value) {
            addCriterion("PRINCIPAL_LOSS_AMT =", value, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtNotEqualTo(BigDecimal value) {
            addCriterion("PRINCIPAL_LOSS_AMT <>", value, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtGreaterThan(BigDecimal value) {
            addCriterion("PRINCIPAL_LOSS_AMT >", value, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRINCIPAL_LOSS_AMT >=", value, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtLessThan(BigDecimal value) {
            addCriterion("PRINCIPAL_LOSS_AMT <", value, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRINCIPAL_LOSS_AMT <=", value, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtIn(List<BigDecimal> values) {
            addCriterion("PRINCIPAL_LOSS_AMT in", values, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtNotIn(List<BigDecimal> values) {
            addCriterion("PRINCIPAL_LOSS_AMT not in", values, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRINCIPAL_LOSS_AMT between", value1, value2, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalLossAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRINCIPAL_LOSS_AMT not between", value1, value2, "principalLossAmt");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateIsNull() {
            addCriterion("MARGIN_COVER_RATE is null");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateIsNotNull() {
            addCriterion("MARGIN_COVER_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateEqualTo(BigDecimal value) {
            addCriterion("MARGIN_COVER_RATE =", value, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateNotEqualTo(BigDecimal value) {
            addCriterion("MARGIN_COVER_RATE <>", value, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateGreaterThan(BigDecimal value) {
            addCriterion("MARGIN_COVER_RATE >", value, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGIN_COVER_RATE >=", value, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateLessThan(BigDecimal value) {
            addCriterion("MARGIN_COVER_RATE <", value, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGIN_COVER_RATE <=", value, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateIn(List<BigDecimal> values) {
            addCriterion("MARGIN_COVER_RATE in", values, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateNotIn(List<BigDecimal> values) {
            addCriterion("MARGIN_COVER_RATE not in", values, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGIN_COVER_RATE between", value1, value2, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andMarginCoverRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGIN_COVER_RATE not between", value1, value2, "marginCoverRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateIsNull() {
            addCriterion("SALE_GROWTH_RATE is null");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateIsNotNull() {
            addCriterion("SALE_GROWTH_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateEqualTo(BigDecimal value) {
            addCriterion("SALE_GROWTH_RATE =", value, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateNotEqualTo(BigDecimal value) {
            addCriterion("SALE_GROWTH_RATE <>", value, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateGreaterThan(BigDecimal value) {
            addCriterion("SALE_GROWTH_RATE >", value, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_GROWTH_RATE >=", value, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateLessThan(BigDecimal value) {
            addCriterion("SALE_GROWTH_RATE <", value, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_GROWTH_RATE <=", value, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateIn(List<BigDecimal> values) {
            addCriterion("SALE_GROWTH_RATE in", values, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateNotIn(List<BigDecimal> values) {
            addCriterion("SALE_GROWTH_RATE not in", values, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_GROWTH_RATE between", value1, value2, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andSaleGrowthRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_GROWTH_RATE not between", value1, value2, "saleGrowthRate");
            return (Criteria) this;
        }

        public Criteria andRecRateIsNull() {
            addCriterion("REC_RATE is null");
            return (Criteria) this;
        }

        public Criteria andRecRateIsNotNull() {
            addCriterion("REC_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRecRateEqualTo(BigDecimal value) {
            addCriterion("REC_RATE =", value, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateNotEqualTo(BigDecimal value) {
            addCriterion("REC_RATE <>", value, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateGreaterThan(BigDecimal value) {
            addCriterion("REC_RATE >", value, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REC_RATE >=", value, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateLessThan(BigDecimal value) {
            addCriterion("REC_RATE <", value, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REC_RATE <=", value, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateIn(List<BigDecimal> values) {
            addCriterion("REC_RATE in", values, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateNotIn(List<BigDecimal> values) {
            addCriterion("REC_RATE not in", values, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REC_RATE between", value1, value2, "recRate");
            return (Criteria) this;
        }

        public Criteria andRecRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REC_RATE not between", value1, value2, "recRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateIsNull() {
            addCriterion("PREPAY_RATE is null");
            return (Criteria) this;
        }

        public Criteria andPrepayRateIsNotNull() {
            addCriterion("PREPAY_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayRateEqualTo(BigDecimal value) {
            addCriterion("PREPAY_RATE =", value, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateNotEqualTo(BigDecimal value) {
            addCriterion("PREPAY_RATE <>", value, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateGreaterThan(BigDecimal value) {
            addCriterion("PREPAY_RATE >", value, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PREPAY_RATE >=", value, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateLessThan(BigDecimal value) {
            addCriterion("PREPAY_RATE <", value, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PREPAY_RATE <=", value, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateIn(List<BigDecimal> values) {
            addCriterion("PREPAY_RATE in", values, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateNotIn(List<BigDecimal> values) {
            addCriterion("PREPAY_RATE not in", values, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PREPAY_RATE between", value1, value2, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andPrepayRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PREPAY_RATE not between", value1, value2, "prepayRate");
            return (Criteria) this;
        }

        public Criteria andBadRateIsNull() {
            addCriterion("BAD_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBadRateIsNotNull() {
            addCriterion("BAD_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBadRateEqualTo(BigDecimal value) {
            addCriterion("BAD_RATE =", value, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateNotEqualTo(BigDecimal value) {
            addCriterion("BAD_RATE <>", value, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateGreaterThan(BigDecimal value) {
            addCriterion("BAD_RATE >", value, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BAD_RATE >=", value, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateLessThan(BigDecimal value) {
            addCriterion("BAD_RATE <", value, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BAD_RATE <=", value, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateIn(List<BigDecimal> values) {
            addCriterion("BAD_RATE in", values, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateNotIn(List<BigDecimal> values) {
            addCriterion("BAD_RATE not in", values, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAD_RATE between", value1, value2, "badRate");
            return (Criteria) this;
        }

        public Criteria andBadRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BAD_RATE not between", value1, value2, "badRate");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtIsNull() {
            addCriterion("TOTAL_LOAN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtIsNotNull() {
            addCriterion("TOTAL_LOAN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_AMT =", value, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_AMT <>", value, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_LOAN_AMT >", value, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_AMT >=", value, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtLessThan(BigDecimal value) {
            addCriterion("TOTAL_LOAN_AMT <", value, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_AMT <=", value, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtIn(List<BigDecimal> values) {
            addCriterion("TOTAL_LOAN_AMT in", values, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_LOAN_AMT not in", values, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_LOAN_AMT between", value1, value2, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andTotalLoanAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_LOAN_AMT not between", value1, value2, "totalLoanAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtIsNull() {
            addCriterion("REPAYMENT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtIsNotNull() {
            addCriterion("REPAYMENT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_AMT =", value, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtNotEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_AMT <>", value, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtGreaterThan(BigDecimal value) {
            addCriterion("REPAYMENT_AMT >", value, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_AMT >=", value, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtLessThan(BigDecimal value) {
            addCriterion("REPAYMENT_AMT <", value, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_AMT <=", value, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtIn(List<BigDecimal> values) {
            addCriterion("REPAYMENT_AMT in", values, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtNotIn(List<BigDecimal> values) {
            addCriterion("REPAYMENT_AMT not in", values, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAYMENT_AMT between", value1, value2, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andRepaymentAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAYMENT_AMT not between", value1, value2, "repaymentAmt");
            return (Criteria) this;
        }

        public Criteria andOverdueNumIsNull() {
            addCriterion("OVERDUE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andOverdueNumIsNotNull() {
            addCriterion("OVERDUE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueNumEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_NUM =", value, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumNotEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_NUM <>", value, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumGreaterThan(BigDecimal value) {
            addCriterion("OVERDUE_NUM >", value, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_NUM >=", value, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumLessThan(BigDecimal value) {
            addCriterion("OVERDUE_NUM <", value, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDUE_NUM <=", value, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_NUM in", values, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumNotIn(List<BigDecimal> values) {
            addCriterion("OVERDUE_NUM not in", values, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_NUM between", value1, value2, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andOverdueNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDUE_NUM not between", value1, value2, "overdueNum");
            return (Criteria) this;
        }

        public Criteria andLossAmtIsNull() {
            addCriterion("LOSS_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLossAmtIsNotNull() {
            addCriterion("LOSS_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLossAmtEqualTo(BigDecimal value) {
            addCriterion("LOSS_AMT =", value, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtNotEqualTo(BigDecimal value) {
            addCriterion("LOSS_AMT <>", value, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtGreaterThan(BigDecimal value) {
            addCriterion("LOSS_AMT >", value, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOSS_AMT >=", value, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtLessThan(BigDecimal value) {
            addCriterion("LOSS_AMT <", value, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOSS_AMT <=", value, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtIn(List<BigDecimal> values) {
            addCriterion("LOSS_AMT in", values, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtNotIn(List<BigDecimal> values) {
            addCriterion("LOSS_AMT not in", values, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOSS_AMT between", value1, value2, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andLossAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOSS_AMT not between", value1, value2, "lossAmt");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeIsNull() {
            addCriterion("TOTAL_CHAN_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeIsNotNull() {
            addCriterion("TOTAL_CHAN_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CHAN_FEE =", value, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CHAN_FEE <>", value, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_CHAN_FEE >", value, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CHAN_FEE >=", value, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeLessThan(BigDecimal value) {
            addCriterion("TOTAL_CHAN_FEE <", value, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_CHAN_FEE <=", value, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeIn(List<BigDecimal> values) {
            addCriterion("TOTAL_CHAN_FEE in", values, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_CHAN_FEE not in", values, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_CHAN_FEE between", value1, value2, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalChanFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_CHAN_FEE not between", value1, value2, "totalChanFee");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIsNull() {
            addCriterion("TOTAL_INCOME is null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIsNotNull() {
            addCriterion("TOTAL_INCOME is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeEqualTo(BigDecimal value) {
            addCriterion("TOTAL_INCOME =", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_INCOME <>", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_INCOME >", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_INCOME >=", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeLessThan(BigDecimal value) {
            addCriterion("TOTAL_INCOME <", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_INCOME <=", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIn(List<BigDecimal> values) {
            addCriterion("TOTAL_INCOME in", values, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_INCOME not in", values, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_INCOME between", value1, value2, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_INCOME not between", value1, value2, "totalIncome");
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

        public Criteria andExt1EqualTo(BigDecimal value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(BigDecimal value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(BigDecimal value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(BigDecimal value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<BigDecimal> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<BigDecimal> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andExt2EqualTo(BigDecimal value) {
            addCriterion("EXT2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(BigDecimal value) {
            addCriterion("EXT2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(BigDecimal value) {
            addCriterion("EXT2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(BigDecimal value) {
            addCriterion("EXT2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXT2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<BigDecimal> values) {
            addCriterion("EXT2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<BigDecimal> values) {
            addCriterion("EXT2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXT2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andIndustryTypeNameIsNull() {
            addCriterion("INDUSTRY_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameIsNotNull() {
            addCriterion("INDUSTRY_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NAME =", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NAME <>", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameGreaterThan(String value) {
            addCriterion("INDUSTRY_TYPE_NAME >", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NAME >=", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameLessThan(String value) {
            addCriterion("INDUSTRY_TYPE_NAME <", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_TYPE_NAME <=", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameLike(String value) {
            addCriterion("INDUSTRY_TYPE_NAME like", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotLike(String value) {
            addCriterion("INDUSTRY_TYPE_NAME not like", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE_NAME in", values, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotIn(List<String> values) {
            addCriterion("INDUSTRY_TYPE_NAME not in", values, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE_NAME between", value1, value2, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_TYPE_NAME not between", value1, value2, "industryTypeName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}