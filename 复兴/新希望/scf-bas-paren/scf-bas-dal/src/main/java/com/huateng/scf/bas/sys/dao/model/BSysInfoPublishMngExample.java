package com.huateng.scf.bas.sys.dao.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSysInfoPublishMngExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSysInfoPublishMngExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BSysInfoPublishMngExample(BSysInfoPublishMngExample example) {
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoIsNull() {
            addCriterion("AUTHOR_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoIsNotNull() {
            addCriterion("AUTHOR_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoEqualTo(String value) {
            addCriterion("AUTHOR_TLRNO =", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoNotEqualTo(String value) {
            addCriterion("AUTHOR_TLRNO <>", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoGreaterThan(String value) {
            addCriterion("AUTHOR_TLRNO >", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHOR_TLRNO >=", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoLessThan(String value) {
            addCriterion("AUTHOR_TLRNO <", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoLessThanOrEqualTo(String value) {
            addCriterion("AUTHOR_TLRNO <=", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoLike(String value) {
            addCriterion("AUTHOR_TLRNO like", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoNotLike(String value) {
            addCriterion("AUTHOR_TLRNO not like", value, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoIn(List<String> values) {
            addCriterion("AUTHOR_TLRNO in", values, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoNotIn(List<String> values) {
            addCriterion("AUTHOR_TLRNO not in", values, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoBetween(String value1, String value2) {
            addCriterion("AUTHOR_TLRNO between", value1, value2, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andAuthorTlrnoNotBetween(String value1, String value2) {
            addCriterion("AUTHOR_TLRNO not between", value1, value2, "authorTlrno");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("PUBLISH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("PUBLISH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(String value) {
            addCriterion("PUBLISH_DATE =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(String value) {
            addCriterion("PUBLISH_DATE <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(String value) {
            addCriterion("PUBLISH_DATE >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLISH_DATE >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(String value) {
            addCriterion("PUBLISH_DATE <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(String value) {
            addCriterion("PUBLISH_DATE <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLike(String value) {
            addCriterion("PUBLISH_DATE like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotLike(String value) {
            addCriterion("PUBLISH_DATE not like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<String> values) {
            addCriterion("PUBLISH_DATE in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<String> values) {
            addCriterion("PUBLISH_DATE not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(String value1, String value2) {
            addCriterion("PUBLISH_DATE between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(String value1, String value2) {
            addCriterion("PUBLISH_DATE not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateIsNull() {
            addCriterion("INFO_DELETE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateIsNotNull() {
            addCriterion("INFO_DELETE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateEqualTo(String value) {
            addCriterion("INFO_DELETE_DATE =", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateNotEqualTo(String value) {
            addCriterion("INFO_DELETE_DATE <>", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateGreaterThan(String value) {
            addCriterion("INFO_DELETE_DATE >", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_DELETE_DATE >=", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateLessThan(String value) {
            addCriterion("INFO_DELETE_DATE <", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateLessThanOrEqualTo(String value) {
            addCriterion("INFO_DELETE_DATE <=", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateLike(String value) {
            addCriterion("INFO_DELETE_DATE like", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateNotLike(String value) {
            addCriterion("INFO_DELETE_DATE not like", value, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateIn(List<String> values) {
            addCriterion("INFO_DELETE_DATE in", values, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateNotIn(List<String> values) {
            addCriterion("INFO_DELETE_DATE not in", values, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateBetween(String value1, String value2) {
            addCriterion("INFO_DELETE_DATE between", value1, value2, "infoDeleteDate");
            return (Criteria) this;
        }

        public Criteria andInfoDeleteDateNotBetween(String value1, String value2) {
            addCriterion("INFO_DELETE_DATE not between", value1, value2, "infoDeleteDate");
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

        public Criteria andInfoDelTlrnoIsNull() {
            addCriterion("INFO_DEL_TLRNO is null");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoIsNotNull() {
            addCriterion("INFO_DEL_TLRNO is not null");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoEqualTo(String value) {
            addCriterion("INFO_DEL_TLRNO =", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoNotEqualTo(String value) {
            addCriterion("INFO_DEL_TLRNO <>", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoGreaterThan(String value) {
            addCriterion("INFO_DEL_TLRNO >", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_DEL_TLRNO >=", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoLessThan(String value) {
            addCriterion("INFO_DEL_TLRNO <", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoLessThanOrEqualTo(String value) {
            addCriterion("INFO_DEL_TLRNO <=", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoLike(String value) {
            addCriterion("INFO_DEL_TLRNO like", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoNotLike(String value) {
            addCriterion("INFO_DEL_TLRNO not like", value, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoIn(List<String> values) {
            addCriterion("INFO_DEL_TLRNO in", values, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoNotIn(List<String> values) {
            addCriterion("INFO_DEL_TLRNO not in", values, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoBetween(String value1, String value2) {
            addCriterion("INFO_DEL_TLRNO between", value1, value2, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andInfoDelTlrnoNotBetween(String value1, String value2) {
            addCriterion("INFO_DEL_TLRNO not between", value1, value2, "infoDelTlrno");
            return (Criteria) this;
        }

        public Criteria andProtocolTextIsNull() {
            addCriterion("PROTOCOL_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andProtocolTextIsNotNull() {
            addCriterion("PROTOCOL_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolTextEqualTo(String value) {
            addCriterion("PROTOCOL_TEXT =", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextNotEqualTo(String value) {
            addCriterion("PROTOCOL_TEXT <>", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextGreaterThan(String value) {
            addCriterion("PROTOCOL_TEXT >", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_TEXT >=", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextLessThan(String value) {
            addCriterion("PROTOCOL_TEXT <", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL_TEXT <=", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextLike(String value) {
            addCriterion("PROTOCOL_TEXT like", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextNotLike(String value) {
            addCriterion("PROTOCOL_TEXT not like", value, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextIn(List<String> values) {
            addCriterion("PROTOCOL_TEXT in", values, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextNotIn(List<String> values) {
            addCriterion("PROTOCOL_TEXT not in", values, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextBetween(String value1, String value2) {
            addCriterion("PROTOCOL_TEXT between", value1, value2, "protocolText");
            return (Criteria) this;
        }

        public Criteria andProtocolTextNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL_TEXT not between", value1, value2, "protocolText");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}