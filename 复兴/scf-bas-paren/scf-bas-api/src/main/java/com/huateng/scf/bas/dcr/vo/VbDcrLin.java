package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class VbDcrLin implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 授信合同号
     */
    private String bcCrId;

    /**
     * VARCHAR(32) 必填<br>
     * 授信申请流水号
     */
    private String appCrId;

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
     * VARCHAR(40)<br>
     * 人工授信额度协议号
     */
    private String contractNo;

    /**
     * VARCHAR(10)<br>
     * 生效日
     */
    private String effectDt;

    /**
     * VARCHAR(10)<br>
     * 协议起始日
     */
    private String begDt;

    /**
     * VARCHAR(10)<br>
     * 协议到期日
     */
    private String endDt;

    /**
     * VARCHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(14,2)<br>
     * 授信额度
     */
    private BigDecimal crAmt;

    /**
     * DECIMAL(14,2)<br>
     * 风险敞口额度
     */
    private BigDecimal riskAmt;

    /**
     * CHAR(2)<br>
     * 担保方式
     */
    private String guatTyp;

    /**
     * CHAR(1)<br>
     * 循环标志
     */
    private String circFlag;

    /**
     * VARCHAR(32)<br>
     * 父额度ID
     */
    private String parentId;

    /**
     * DECIMAL(14,2)<br>
     * 已占用额度
     */
    private BigDecimal usedNum;

    /**
     * DECIMAL(14,2)<br>
     * 可用额度
     */
    private BigDecimal ableNum;

    /**
     * CHAR(1)<br>
     * 状态
     */
    private String stat;

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
     * 获得 授信合同号
     */
    public String getBcCrId() {
        return bcCrId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 授信合同号
     */
    public void setBcCrId(String bcCrId) {
        this.bcCrId = bcCrId == null ? null : bcCrId.trim();
    }

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
     * VARCHAR(40)<br>
     * 获得 人工授信额度协议号
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 人工授信额度协议号
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 生效日
     */
    public String getEffectDt() {
        return effectDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 生效日
     */
    public void setEffectDt(String effectDt) {
        this.effectDt = effectDt == null ? null : effectDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 协议起始日
     */
    public String getBegDt() {
        return begDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 协议起始日
     */
    public void setBegDt(String begDt) {
        this.begDt = begDt == null ? null : begDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 协议到期日
     */
    public String getEndDt() {
        return endDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 协议到期日
     */
    public void setEndDt(String endDt) {
        this.endDt = endDt == null ? null : endDt.trim();
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
     * 获得 授信额度
     */
    public BigDecimal getCrAmt() {
        return crAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 授信额度
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
     * VARCHAR(32)<br>
     * 获得 父额度ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 父额度ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 已占用额度
     */
    public BigDecimal getUsedNum() {
        return usedNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 已占用额度
     */
    public void setUsedNum(BigDecimal usedNum) {
        this.usedNum = usedNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 可用额度
     */
    public BigDecimal getAbleNum() {
        return ableNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 可用额度
     */
    public void setAbleNum(BigDecimal ableNum) {
        this.ableNum = ableNum;
    }

    /**
     * CHAR(1)<br>
     * 获得 状态
     */
    public String getStat() {
        return stat;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
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
        sb.append(", bcCrId=").append(bcCrId);
        sb.append(", appCrId=").append(appCrId);
        sb.append(", crId=").append(crId);
        sb.append(", crNm=").append(crNm);
        sb.append(", custId=").append(custId);
        sb.append(", custNm=").append(custNm);
        sb.append(", contractNo=").append(contractNo);
        sb.append(", effectDt=").append(effectDt);
        sb.append(", begDt=").append(begDt);
        sb.append(", endDt=").append(endDt);
        sb.append(", curcd=").append(curcd);
        sb.append(", crAmt=").append(crAmt);
        sb.append(", riskAmt=").append(riskAmt);
        sb.append(", guatTyp=").append(guatTyp);
        sb.append(", circFlag=").append(circFlag);
        sb.append(", parentId=").append(parentId);
        sb.append(", usedNum=").append(usedNum);
        sb.append(", ableNum=").append(ableNum);
        sb.append(", stat=").append(stat);
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
        VbDcrLin other = (VbDcrLin) that;
        return (this.getBcCrId() == null ? other.getBcCrId() == null : this.getBcCrId().equals(other.getBcCrId()))
            && (this.getAppCrId() == null ? other.getAppCrId() == null : this.getAppCrId().equals(other.getAppCrId()))
            && (this.getCrId() == null ? other.getCrId() == null : this.getCrId().equals(other.getCrId()))
            && (this.getCrNm() == null ? other.getCrNm() == null : this.getCrNm().equals(other.getCrNm()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustNm() == null ? other.getCustNm() == null : this.getCustNm().equals(other.getCustNm()))
            && (this.getContractNo() == null ? other.getContractNo() == null : this.getContractNo().equals(other.getContractNo()))
            && (this.getEffectDt() == null ? other.getEffectDt() == null : this.getEffectDt().equals(other.getEffectDt()))
            && (this.getBegDt() == null ? other.getBegDt() == null : this.getBegDt().equals(other.getBegDt()))
            && (this.getEndDt() == null ? other.getEndDt() == null : this.getEndDt().equals(other.getEndDt()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getCrAmt() == null ? other.getCrAmt() == null : this.getCrAmt().equals(other.getCrAmt()))
            && (this.getRiskAmt() == null ? other.getRiskAmt() == null : this.getRiskAmt().equals(other.getRiskAmt()))
            && (this.getGuatTyp() == null ? other.getGuatTyp() == null : this.getGuatTyp().equals(other.getGuatTyp()))
            && (this.getCircFlag() == null ? other.getCircFlag() == null : this.getCircFlag().equals(other.getCircFlag()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getUsedNum() == null ? other.getUsedNum() == null : this.getUsedNum().equals(other.getUsedNum()))
            && (this.getAbleNum() == null ? other.getAbleNum() == null : this.getAbleNum().equals(other.getAbleNum()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
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
        result = prime * result + ((getBcCrId() == null) ? 0 : getBcCrId().hashCode());
        result = prime * result + ((getAppCrId() == null) ? 0 : getAppCrId().hashCode());
        result = prime * result + ((getCrId() == null) ? 0 : getCrId().hashCode());
        result = prime * result + ((getCrNm() == null) ? 0 : getCrNm().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustNm() == null) ? 0 : getCustNm().hashCode());
        result = prime * result + ((getContractNo() == null) ? 0 : getContractNo().hashCode());
        result = prime * result + ((getEffectDt() == null) ? 0 : getEffectDt().hashCode());
        result = prime * result + ((getBegDt() == null) ? 0 : getBegDt().hashCode());
        result = prime * result + ((getEndDt() == null) ? 0 : getEndDt().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getCrAmt() == null) ? 0 : getCrAmt().hashCode());
        result = prime * result + ((getRiskAmt() == null) ? 0 : getRiskAmt().hashCode());
        result = prime * result + ((getGuatTyp() == null) ? 0 : getGuatTyp().hashCode());
        result = prime * result + ((getCircFlag() == null) ? 0 : getCircFlag().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getUsedNum() == null) ? 0 : getUsedNum().hashCode());
        result = prime * result + ((getAbleNum() == null) ? 0 : getAbleNum().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
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