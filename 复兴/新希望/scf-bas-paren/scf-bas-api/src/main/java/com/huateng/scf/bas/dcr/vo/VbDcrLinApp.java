package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class VbDcrLinApp implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 授信申请流水号
     */
    private String appCrId;

    /**
     * VARCHAR(32)<br>
     * 关联流水号
     */
    private String rltNo;

    /**
     * VARCHAR(32)<br>
     * 授信类型编号
     */
    private String crId;

    /**
     * VARCHAR(80)<br>
     * 授信类型
     */
    private String crNm;

    /**
     * CHAR(1)<br>
     * 发生方式
     */
    private String occTyp;

    /**
     * VARCHAR(32)<br>
     * 客户编号
     */
    private String custId;

    /**
     * VARCHAR(80)<br>
     * 客户名称
     */
    private String custNm;

    /**
     * VARCHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(14,2)<br>
     * 额度
     */
    private BigDecimal crAmt;

    /**
     * DECIMAL(14,2)<br>
     * 风险敞口额度
     */
    private BigDecimal riskAmt;

    /**
     * CHAR(1)<br>
     * 循环标志
     */
    private String circFlag;

    /**
     * CHAR(2)<br>
     * 担保方式
     */
    private String guatTyp;

    /**
     * VARCHAR(10)<br>
     * 起始日
     */
    private String begDt;

    /**
     * VARCHAR(10)<br>
     * 到期日
     */
    private String endDt;

    /**
     * VARCHAR(32)<br>
     * 根额度ID
     */
    private String parentId;

    /**
     * VARCHAR(10)<br>
     * 审批状态
     */
    private String aprvStat;

    /**
     * VARCHAR(60)<br>
     * 登记人
     */
    private String tlrNm;

    /**
     * VARCHAR(32)<br>
     * 登记人ID
     */
    private String tlrNo;

    /**
     * VARCHAR(32)<br>
     * 登记机构ID
     */
    private String brCd;

    /**
     * VARCHAR(60)<br>
     * 登记机构
     */
    private String brNm;

    /**
     * CHAR(8)<br>
     * 登记日期
     */
    private String inputDt;

    /**
     * VARCHAR(32)<br>
     * 更新人ID
     */
    private String lstUpdTlr;

    /**
     * VARCHAR(60)<br>
     * 更新人
     */
    private String lstUpdTlrNm;

    /**
     * VARCHAR(32)<br>
     * 更新机构ID
     */
    private String lstUpdBrCd;

    /**
     * VARCHAR(60)<br>
     * 更新机构
     */
    private String lstUpdBrNm;

    /**
     * CHAR(8)<br>
     * 更新日期
     */
    private String lstUpdDt;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 授信申请流水号
     */
    public String getAppCrId() {
        return appCrId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 授信申请流水号
     */
    public void setAppCrId(String appCrId) {
        this.appCrId = appCrId == null ? null : appCrId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 关联流水号
     */
    public String getRltNo() {
        return rltNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 关联流水号
     */
    public void setRltNo(String rltNo) {
        this.rltNo = rltNo == null ? null : rltNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 授信类型编号
     */
    public String getCrId() {
        return crId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 授信类型编号
     */
    public void setCrId(String crId) {
        this.crId = crId == null ? null : crId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 授信类型
     */
    public String getCrNm() {
        return crNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 授信类型
     */
    public void setCrNm(String crNm) {
        this.crNm = crNm == null ? null : crNm.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 发生方式
     */
    public String getOccTyp() {
        return occTyp;
    }

    /**
     * CHAR(1)<br>
     * 设置 发生方式
     */
    public void setOccTyp(String occTyp) {
        this.occTyp = occTyp == null ? null : occTyp.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 客户编号
     */
    public String getCustId() {
        return custId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 客户编号
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 客户名称
     */
    public String getCustNm() {
        return custNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 客户名称
     */
    public void setCustNm(String custNm) {
        this.custNm = custNm == null ? null : custNm.trim();
    }

    /**
     * VARCHAR(3)<br>
     * 获得 币种
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 币种
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 额度
     */
    public BigDecimal getCrAmt() {
        return crAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 额度
     */
    public void setCrAmt(BigDecimal crAmt) {
        this.crAmt = crAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 风险敞口额度
     */
    public BigDecimal getRiskAmt() {
        return riskAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 风险敞口额度
     */
    public void setRiskAmt(BigDecimal riskAmt) {
        this.riskAmt = riskAmt;
    }

    /**
     * CHAR(1)<br>
     * 获得 循环标志
     */
    public String getCircFlag() {
        return circFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 循环标志
     */
    public void setCircFlag(String circFlag) {
        this.circFlag = circFlag == null ? null : circFlag.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 担保方式
     */
    public String getGuatTyp() {
        return guatTyp;
    }

    /**
     * CHAR(2)<br>
     * 设置 担保方式
     */
    public void setGuatTyp(String guatTyp) {
        this.guatTyp = guatTyp == null ? null : guatTyp.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 起始日
     */
    public String getBegDt() {
        return begDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 起始日
     */
    public void setBegDt(String begDt) {
        this.begDt = begDt == null ? null : begDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 到期日
     */
    public String getEndDt() {
        return endDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 到期日
     */
    public void setEndDt(String endDt) {
        this.endDt = endDt == null ? null : endDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 根额度ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 根额度ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 审批状态
     */
    public String getAprvStat() {
        return aprvStat;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 审批状态
     */
    public void setAprvStat(String aprvStat) {
        this.aprvStat = aprvStat == null ? null : aprvStat.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 登记人
     */
    public String getTlrNm() {
        return tlrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 登记人
     */
    public void setTlrNm(String tlrNm) {
        this.tlrNm = tlrNm == null ? null : tlrNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记人ID
     */
    public String getTlrNo() {
        return tlrNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人ID
     */
    public void setTlrNo(String tlrNo) {
        this.tlrNo = tlrNo == null ? null : tlrNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记机构ID
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记机构ID
     */
    public void setBrCd(String brCd) {
        this.brCd = brCd == null ? null : brCd.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 登记机构
     */
    public String getBrNm() {
        return brNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 登记机构
     */
    public void setBrNm(String brNm) {
        this.brNm = brNm == null ? null : brNm.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 登记日期
     */
    public String getInputDt() {
        return inputDt;
    }

    /**
     * CHAR(8)<br>
     * 设置 登记日期
     */
    public void setInputDt(String inputDt) {
        this.inputDt = inputDt == null ? null : inputDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新人ID
     */
    public String getLstUpdTlr() {
        return lstUpdTlr;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新人ID
     */
    public void setLstUpdTlr(String lstUpdTlr) {
        this.lstUpdTlr = lstUpdTlr == null ? null : lstUpdTlr.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 更新人
     */
    public String getLstUpdTlrNm() {
        return lstUpdTlrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 更新人
     */
    public void setLstUpdTlrNm(String lstUpdTlrNm) {
        this.lstUpdTlrNm = lstUpdTlrNm == null ? null : lstUpdTlrNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新机构ID
     */
    public String getLstUpdBrCd() {
        return lstUpdBrCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新机构ID
     */
    public void setLstUpdBrCd(String lstUpdBrCd) {
        this.lstUpdBrCd = lstUpdBrCd == null ? null : lstUpdBrCd.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 更新机构
     */
    public String getLstUpdBrNm() {
        return lstUpdBrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 更新机构
     */
    public void setLstUpdBrNm(String lstUpdBrNm) {
        this.lstUpdBrNm = lstUpdBrNm == null ? null : lstUpdBrNm.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 更新日期
     */
    public String getLstUpdDt() {
        return lstUpdDt;
    }

    /**
     * CHAR(8)<br>
     * 设置 更新日期
     */
    public void setLstUpdDt(String lstUpdDt) {
        this.lstUpdDt = lstUpdDt == null ? null : lstUpdDt.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appCrId=").append(appCrId);
        sb.append(", rltNo=").append(rltNo);
        sb.append(", crId=").append(crId);
        sb.append(", crNm=").append(crNm);
        sb.append(", occTyp=").append(occTyp);
        sb.append(", custId=").append(custId);
        sb.append(", custNm=").append(custNm);
        sb.append(", curcd=").append(curcd);
        sb.append(", crAmt=").append(crAmt);
        sb.append(", riskAmt=").append(riskAmt);
        sb.append(", circFlag=").append(circFlag);
        sb.append(", guatTyp=").append(guatTyp);
        sb.append(", begDt=").append(begDt);
        sb.append(", endDt=").append(endDt);
        sb.append(", parentId=").append(parentId);
        sb.append(", aprvStat=").append(aprvStat);
        sb.append(", tlrNm=").append(tlrNm);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", brCd=").append(brCd);
        sb.append(", brNm=").append(brNm);
        sb.append(", inputDt=").append(inputDt);
        sb.append(", lstUpdTlr=").append(lstUpdTlr);
        sb.append(", lstUpdTlrNm=").append(lstUpdTlrNm);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdBrNm=").append(lstUpdBrNm);
        sb.append(", lstUpdDt=").append(lstUpdDt);
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
        VbDcrLinApp other = (VbDcrLinApp) that;
        return (this.getAppCrId() == null ? other.getAppCrId() == null : this.getAppCrId().equals(other.getAppCrId()))
            && (this.getRltNo() == null ? other.getRltNo() == null : this.getRltNo().equals(other.getRltNo()))
            && (this.getCrId() == null ? other.getCrId() == null : this.getCrId().equals(other.getCrId()))
            && (this.getCrNm() == null ? other.getCrNm() == null : this.getCrNm().equals(other.getCrNm()))
            && (this.getOccTyp() == null ? other.getOccTyp() == null : this.getOccTyp().equals(other.getOccTyp()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustNm() == null ? other.getCustNm() == null : this.getCustNm().equals(other.getCustNm()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getCrAmt() == null ? other.getCrAmt() == null : this.getCrAmt().equals(other.getCrAmt()))
            && (this.getRiskAmt() == null ? other.getRiskAmt() == null : this.getRiskAmt().equals(other.getRiskAmt()))
            && (this.getCircFlag() == null ? other.getCircFlag() == null : this.getCircFlag().equals(other.getCircFlag()))
            && (this.getGuatTyp() == null ? other.getGuatTyp() == null : this.getGuatTyp().equals(other.getGuatTyp()))
            && (this.getBegDt() == null ? other.getBegDt() == null : this.getBegDt().equals(other.getBegDt()))
            && (this.getEndDt() == null ? other.getEndDt() == null : this.getEndDt().equals(other.getEndDt()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getAprvStat() == null ? other.getAprvStat() == null : this.getAprvStat().equals(other.getAprvStat()))
            && (this.getTlrNm() == null ? other.getTlrNm() == null : this.getTlrNm().equals(other.getTlrNm()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getBrNm() == null ? other.getBrNm() == null : this.getBrNm().equals(other.getBrNm()))
            && (this.getInputDt() == null ? other.getInputDt() == null : this.getInputDt().equals(other.getInputDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdTlrNm() == null ? other.getLstUpdTlrNm() == null : this.getLstUpdTlrNm().equals(other.getLstUpdTlrNm()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdBrNm() == null ? other.getLstUpdBrNm() == null : this.getLstUpdBrNm().equals(other.getLstUpdBrNm()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppCrId() == null) ? 0 : getAppCrId().hashCode());
        result = prime * result + ((getRltNo() == null) ? 0 : getRltNo().hashCode());
        result = prime * result + ((getCrId() == null) ? 0 : getCrId().hashCode());
        result = prime * result + ((getCrNm() == null) ? 0 : getCrNm().hashCode());
        result = prime * result + ((getOccTyp() == null) ? 0 : getOccTyp().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustNm() == null) ? 0 : getCustNm().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getCrAmt() == null) ? 0 : getCrAmt().hashCode());
        result = prime * result + ((getRiskAmt() == null) ? 0 : getRiskAmt().hashCode());
        result = prime * result + ((getCircFlag() == null) ? 0 : getCircFlag().hashCode());
        result = prime * result + ((getGuatTyp() == null) ? 0 : getGuatTyp().hashCode());
        result = prime * result + ((getBegDt() == null) ? 0 : getBegDt().hashCode());
        result = prime * result + ((getEndDt() == null) ? 0 : getEndDt().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getAprvStat() == null) ? 0 : getAprvStat().hashCode());
        result = prime * result + ((getTlrNm() == null) ? 0 : getTlrNm().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getBrNm() == null) ? 0 : getBrNm().hashCode());
        result = prime * result + ((getInputDt() == null) ? 0 : getInputDt().hashCode());
        result = prime * result + ((getLstUpdTlr() == null) ? 0 : getLstUpdTlr().hashCode());
        result = prime * result + ((getLstUpdTlrNm() == null) ? 0 : getLstUpdTlrNm().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdBrNm() == null) ? 0 : getLstUpdBrNm().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        return result;
    }
}