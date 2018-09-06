package com.huateng.scf.bas.crm.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCrmTagCloud implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(15) 必填<br>
     * 客户号
     */
    private String custCd;

    /**
     * VARCHAR(10)<br>
     * 行业
     */
    private String industryType;

    /**
     * VARCHAR(200)<br>
     * 行业名称
     */
    private String industryTypeNm;

    /**
     * VARCHAR(2)<br>
     * 企业规模:
01-大型
02-中型
03-小型
04-微型
05-其他
     */
    private String entScope;

    /**
     * VARCHAR(200)<br>
     * 企业规模名称
     */
    private String entScopeNm;

    /**
     * VARCHAR(2)<br>
     * 企业类型:
01-授信客户
02-核心企业
03-监管公司
     */
    private String entType;

    /**
     * VARCHAR(100)<br>
     * 企业类型名称
     */
    private String entTypeNm;

    /**
     * VARCHAR(80)<br>
     * 信用评级
     */
    private String creditLevel;

    /**
     * DECIMAL(24,2)<br>
     * 企业评级得分
     */
    private BigDecimal creditScr;

    /**
     * VARCHAR(2)<br>
     * 供应链年限
     */
    private String scfAgeLim;

    /**
     * VARCHAR(100)<br>
     * 供应链年限名称
     */
    private String scfAgeLimNm;

    /**
     * VARCHAR(10)<br>
     * 客户质地
     */
    private String custQuality;

    /**
     * VARCHAR(30)<br>
     * 客户质地名称
     */
    private String custQualityNm;

    /**
     * VARCHAR(10)<br>
     * 与我司关系
     */
    private String custRelation;

    /**
     * VARCHAR(30)<br>
     * 与我司关系名称
     */
    private String custRelationNm;

    /**
     * VARCHAR(15) 必填<br>
     * 获得 客户号
     */
    public String getCustCd() {
        return custCd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 客户号
     */
    public void setCustCd(String custCd) {
        this.custCd = custCd == null ? null : custCd.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 行业
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 行业
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType == null ? null : industryType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 行业名称
     */
    public String getIndustryTypeNm() {
        return industryTypeNm;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 行业名称
     */
    public void setIndustryTypeNm(String industryTypeNm) {
        this.industryTypeNm = industryTypeNm == null ? null : industryTypeNm.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 企业规模:
01-大型
02-中型
03-小型
04-微型
05-其他
     */
    public String getEntScope() {
        return entScope;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 企业规模:
01-大型
02-中型
03-小型
04-微型
05-其他
     */
    public void setEntScope(String entScope) {
        this.entScope = entScope == null ? null : entScope.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 企业规模名称
     */
    public String getEntScopeNm() {
        return entScopeNm;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 企业规模名称
     */
    public void setEntScopeNm(String entScopeNm) {
        this.entScopeNm = entScopeNm == null ? null : entScopeNm.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 企业类型:
01-授信客户
02-核心企业
03-监管公司
     */
    public String getEntType() {
        return entType;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 企业类型:
01-授信客户
02-核心企业
03-监管公司
     */
    public void setEntType(String entType) {
        this.entType = entType == null ? null : entType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 企业类型名称
     */
    public String getEntTypeNm() {
        return entTypeNm;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 企业类型名称
     */
    public void setEntTypeNm(String entTypeNm) {
        this.entTypeNm = entTypeNm == null ? null : entTypeNm.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 信用评级
     */
    public String getCreditLevel() {
        return creditLevel;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 信用评级
     */
    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel == null ? null : creditLevel.trim();
    }

    /**
     * DECIMAL(24,2)<br>
     * 获得 企业评级得分
     */
    public BigDecimal getCreditScr() {
        return creditScr;
    }

    /**
     * DECIMAL(24,2)<br>
     * 设置 企业评级得分
     */
    public void setCreditScr(BigDecimal creditScr) {
        this.creditScr = creditScr;
    }

    /**
     * VARCHAR(2)<br>
     * 获得 供应链年限
     */
    public String getScfAgeLim() {
        return scfAgeLim;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 供应链年限
     */
    public void setScfAgeLim(String scfAgeLim) {
        this.scfAgeLim = scfAgeLim == null ? null : scfAgeLim.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 供应链年限名称
     */
    public String getScfAgeLimNm() {
        return scfAgeLimNm;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 供应链年限名称
     */
    public void setScfAgeLimNm(String scfAgeLimNm) {
        this.scfAgeLimNm = scfAgeLimNm == null ? null : scfAgeLimNm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 客户质地
     */
    public String getCustQuality() {
        return custQuality;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 客户质地
     */
    public void setCustQuality(String custQuality) {
        this.custQuality = custQuality == null ? null : custQuality.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 客户质地名称
     */
    public String getCustQualityNm() {
        return custQualityNm;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 客户质地名称
     */
    public void setCustQualityNm(String custQualityNm) {
        this.custQualityNm = custQualityNm == null ? null : custQualityNm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 与我司关系
     */
    public String getCustRelation() {
        return custRelation;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 与我司关系
     */
    public void setCustRelation(String custRelation) {
        this.custRelation = custRelation == null ? null : custRelation.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 与我司关系名称
     */
    public String getCustRelationNm() {
        return custRelationNm;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 与我司关系名称
     */
    public void setCustRelationNm(String custRelationNm) {
        this.custRelationNm = custRelationNm == null ? null : custRelationNm.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", custCd=").append(custCd);
        sb.append(", industryType=").append(industryType);
        sb.append(", industryTypeNm=").append(industryTypeNm);
        sb.append(", entScope=").append(entScope);
        sb.append(", entScopeNm=").append(entScopeNm);
        sb.append(", entType=").append(entType);
        sb.append(", entTypeNm=").append(entTypeNm);
        sb.append(", creditLevel=").append(creditLevel);
        sb.append(", creditScr=").append(creditScr);
        sb.append(", scfAgeLim=").append(scfAgeLim);
        sb.append(", scfAgeLimNm=").append(scfAgeLimNm);
        sb.append(", custQuality=").append(custQuality);
        sb.append(", custQualityNm=").append(custQualityNm);
        sb.append(", custRelation=").append(custRelation);
        sb.append(", custRelationNm=").append(custRelationNm);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BCrmTagCloud other = (BCrmTagCloud) that;
        return (this.getCustCd() == null ? other.getCustCd() == null : this.getCustCd().equals(other.getCustCd()))
            && (this.getIndustryType() == null ? other.getIndustryType() == null : this.getIndustryType().equals(other.getIndustryType()))
            && (this.getIndustryTypeNm() == null ? other.getIndustryTypeNm() == null : this.getIndustryTypeNm().equals(other.getIndustryTypeNm()))
            && (this.getEntScope() == null ? other.getEntScope() == null : this.getEntScope().equals(other.getEntScope()))
            && (this.getEntScopeNm() == null ? other.getEntScopeNm() == null : this.getEntScopeNm().equals(other.getEntScopeNm()))
            && (this.getEntType() == null ? other.getEntType() == null : this.getEntType().equals(other.getEntType()))
            && (this.getEntTypeNm() == null ? other.getEntTypeNm() == null : this.getEntTypeNm().equals(other.getEntTypeNm()))
            && (this.getCreditLevel() == null ? other.getCreditLevel() == null : this.getCreditLevel().equals(other.getCreditLevel()))
            && (this.getCreditScr() == null ? other.getCreditScr() == null : this.getCreditScr().equals(other.getCreditScr()))
            && (this.getScfAgeLim() == null ? other.getScfAgeLim() == null : this.getScfAgeLim().equals(other.getScfAgeLim()))
            && (this.getScfAgeLimNm() == null ? other.getScfAgeLimNm() == null : this.getScfAgeLimNm().equals(other.getScfAgeLimNm()))
            && (this.getCustQuality() == null ? other.getCustQuality() == null : this.getCustQuality().equals(other.getCustQuality()))
            && (this.getCustQualityNm() == null ? other.getCustQualityNm() == null : this.getCustQualityNm().equals(other.getCustQualityNm()))
            && (this.getCustRelation() == null ? other.getCustRelation() == null : this.getCustRelation().equals(other.getCustRelation()))
            && (this.getCustRelationNm() == null ? other.getCustRelationNm() == null : this.getCustRelationNm().equals(other.getCustRelationNm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustCd() == null) ? 0 : getCustCd().hashCode());
        result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
        result = prime * result + ((getIndustryTypeNm() == null) ? 0 : getIndustryTypeNm().hashCode());
        result = prime * result + ((getEntScope() == null) ? 0 : getEntScope().hashCode());
        result = prime * result + ((getEntScopeNm() == null) ? 0 : getEntScopeNm().hashCode());
        result = prime * result + ((getEntType() == null) ? 0 : getEntType().hashCode());
        result = prime * result + ((getEntTypeNm() == null) ? 0 : getEntTypeNm().hashCode());
        result = prime * result + ((getCreditLevel() == null) ? 0 : getCreditLevel().hashCode());
        result = prime * result + ((getCreditScr() == null) ? 0 : getCreditScr().hashCode());
        result = prime * result + ((getScfAgeLim() == null) ? 0 : getScfAgeLim().hashCode());
        result = prime * result + ((getScfAgeLimNm() == null) ? 0 : getScfAgeLimNm().hashCode());
        result = prime * result + ((getCustQuality() == null) ? 0 : getCustQuality().hashCode());
        result = prime * result + ((getCustQualityNm() == null) ? 0 : getCustQualityNm().hashCode());
        result = prime * result + ((getCustRelation() == null) ? 0 : getCustRelation().hashCode());
        result = prime * result + ((getCustRelationNm() == null) ? 0 : getCustRelationNm().hashCode());
        return result;
    }
}