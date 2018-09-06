package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCrgEvalRec implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 评估流水号
     */
    private String evalId;

    /**
     * VARCHAR(18) 必填<br>
     * 评估对象类型
     */
    private String rltTyp;

    /**
     * VARCHAR(32) 必填<br>
     * 评估对象编号
     */
    private String rltId;

    /**
     * VARCHAR(8)<br>
     * 会计月份
     */
    private String finDt;

    /**
     * VARCHAR(32)<br>
     * 评估模型编号
     */
    private String mdlId;

    /**
     * VARCHAR(80)<br>
     * 评估模型名
     */
    private String mdlNm;

    /**
     * CHAR(8)<br>
     * 评估日期
     */
    private String evalDt;

    /**
     * DECIMAL(24,2)<br>
     * 机评得分
     */
    private BigDecimal evalScr;

    /**
     * VARCHAR(80)<br>
     * 机评级别
     */
    private String evalRslt;

    /**
     * DECIMAL(24,2)<br>
     * 认定得分
     */
    private BigDecimal cognScr;

    /**
     * VARCHAR(80)<br>
     * 认定级别
     */
    private String cognRslt;

    /**
     * VARCHAR(20)<br>
     * 认定有效期
     */
    private String eftDt;

    /**
     * VARCHAR(256)<br>
     * 认定理由
     */
    private String rem;

    /**
     * CHAR(1)<br>
     * 有效状态
     */
    private String isVld;

    /**
     * VARCHAR(3)<br>
     * 审核状态
     */
    private String stat;

    /**
     * VARCHAR(32)<br>
     * 评估人
     */
    private String tlrNo;

    /**
     * VARCHAR(32)<br>
     * 评估机构
     */
    private String brCd;

    /**
     * VARCHAR(32)<br>
     * 更新人
     */
    private String lastUpdTlr;

    /**
     * VARCHAR(32)<br>
     * 更新机构
     */
    private String lstUpdBrCd;

    /**
     * CHAR(8)<br>
     * 更新日期
     */
    private String lstUpdDt;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String processId;

    /**
     * CLOB(4000)<br>
     * 评级结果
     */
    private String cardRes;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 评估流水号
     */
    public String getEvalId() {
        return evalId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 评估流水号
     */
    public void setEvalId(String evalId) {
        this.evalId = evalId == null ? null : evalId.trim();
    }

    /**
     * VARCHAR(18) 必填<br>
     * 获得 评估对象类型
     */
    public String getRltTyp() {
        return rltTyp;
    }

    /**
     * VARCHAR(18) 必填<br>
     * 设置 评估对象类型
     */
    public void setRltTyp(String rltTyp) {
        this.rltTyp = rltTyp == null ? null : rltTyp.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 评估对象编号
     */
    public String getRltId() {
        return rltId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 评估对象编号
     */
    public void setRltId(String rltId) {
        this.rltId = rltId == null ? null : rltId.trim();
    }

    /**
     * VARCHAR(8)<br>
     * 获得 会计月份
     */
    public String getFinDt() {
        return finDt;
    }

    /**
     * VARCHAR(8)<br>
     * 设置 会计月份
     */
    public void setFinDt(String finDt) {
        this.finDt = finDt == null ? null : finDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 评估模型编号
     */
    public String getMdlId() {
        return mdlId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 评估模型编号
     */
    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 评估模型名
     */
    public String getMdlNm() {
        return mdlNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 评估模型名
     */
    public void setMdlNm(String mdlNm) {
        this.mdlNm = mdlNm == null ? null : mdlNm.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 评估日期
     */
    public String getEvalDt() {
        return evalDt;
    }

    /**
     * CHAR(8)<br>
     * 设置 评估日期
     */
    public void setEvalDt(String evalDt) {
        this.evalDt = evalDt == null ? null : evalDt.trim();
    }

    /**
     * DECIMAL(24,2)<br>
     * 获得 机评得分
     */
    public BigDecimal getEvalScr() {
        return evalScr;
    }

    /**
     * DECIMAL(24,2)<br>
     * 设置 机评得分
     */
    public void setEvalScr(BigDecimal evalScr) {
        this.evalScr = evalScr;
    }

    /**
     * VARCHAR(80)<br>
     * 获得 机评级别
     */
    public String getEvalRslt() {
        return evalRslt;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 机评级别
     */
    public void setEvalRslt(String evalRslt) {
        this.evalRslt = evalRslt == null ? null : evalRslt.trim();
    }

    /**
     * DECIMAL(24,2)<br>
     * 获得 认定得分
     */
    public BigDecimal getCognScr() {
        return cognScr;
    }

    /**
     * DECIMAL(24,2)<br>
     * 设置 认定得分
     */
    public void setCognScr(BigDecimal cognScr) {
        this.cognScr = cognScr;
    }

    /**
     * VARCHAR(80)<br>
     * 获得 认定级别
     */
    public String getCognRslt() {
        return cognRslt;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 认定级别
     */
    public void setCognRslt(String cognRslt) {
        this.cognRslt = cognRslt == null ? null : cognRslt.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 认定有效期
     */
    public String getEftDt() {
        return eftDt;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 认定有效期
     */
    public void setEftDt(String eftDt) {
        this.eftDt = eftDt == null ? null : eftDt.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 认定理由
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 认定理由
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 有效状态
     */
    public String getIsVld() {
        return isVld;
    }

    /**
     * CHAR(1)<br>
     * 设置 有效状态
     */
    public void setIsVld(String isVld) {
        this.isVld = isVld == null ? null : isVld.trim();
    }

    /**
     * VARCHAR(3)<br>
     * 获得 审核状态
     */
    public String getStat() {
        return stat;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 审核状态
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 评估人
     */
    public String getTlrNo() {
        return tlrNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 评估人
     */
    public void setTlrNo(String tlrNo) {
        this.tlrNo = tlrNo == null ? null : tlrNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 评估机构
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 评估机构
     */
    public void setBrCd(String brCd) {
        this.brCd = brCd == null ? null : brCd.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新人
     */
    public String getLastUpdTlr() {
        return lastUpdTlr;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新人
     */
    public void setLastUpdTlr(String lastUpdTlr) {
        this.lastUpdTlr = lastUpdTlr == null ? null : lastUpdTlr.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新机构
     */
    public String getLstUpdBrCd() {
        return lstUpdBrCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新机构
     */
    public void setLstUpdBrCd(String lstUpdBrCd) {
        this.lstUpdBrCd = lstUpdBrCd == null ? null : lstUpdBrCd.trim();
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

    /**
     * VARCHAR(32)<br>
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    /**
     * CLOB(4000)<br>
     * 获得 评级结果
     */
    public String getCardRes() {
        return cardRes;
    }

    /**
     * CLOB(4000)<br>
     * 设置 评级结果
     */
    public void setCardRes(String cardRes) {
        this.cardRes = cardRes == null ? null : cardRes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", evalId=").append(evalId);
        sb.append(", rltTyp=").append(rltTyp);
        sb.append(", rltId=").append(rltId);
        sb.append(", finDt=").append(finDt);
        sb.append(", mdlId=").append(mdlId);
        sb.append(", mdlNm=").append(mdlNm);
        sb.append(", evalDt=").append(evalDt);
        sb.append(", evalScr=").append(evalScr);
        sb.append(", evalRslt=").append(evalRslt);
        sb.append(", cognScr=").append(cognScr);
        sb.append(", cognRslt=").append(cognRslt);
        sb.append(", eftDt=").append(eftDt);
        sb.append(", rem=").append(rem);
        sb.append(", isVld=").append(isVld);
        sb.append(", stat=").append(stat);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", brCd=").append(brCd);
        sb.append(", lastUpdTlr=").append(lastUpdTlr);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        sb.append(", processId=").append(processId);
        sb.append(", cardRes=").append(cardRes);
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
        BCrgEvalRec other = (BCrgEvalRec) that;
        return (this.getEvalId() == null ? other.getEvalId() == null : this.getEvalId().equals(other.getEvalId()))
            && (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()))
            && (this.getRltId() == null ? other.getRltId() == null : this.getRltId().equals(other.getRltId()))
            && (this.getFinDt() == null ? other.getFinDt() == null : this.getFinDt().equals(other.getFinDt()))
            && (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()))
            && (this.getMdlNm() == null ? other.getMdlNm() == null : this.getMdlNm().equals(other.getMdlNm()))
            && (this.getEvalDt() == null ? other.getEvalDt() == null : this.getEvalDt().equals(other.getEvalDt()))
            && (this.getEvalScr() == null ? other.getEvalScr() == null : this.getEvalScr().equals(other.getEvalScr()))
            && (this.getEvalRslt() == null ? other.getEvalRslt() == null : this.getEvalRslt().equals(other.getEvalRslt()))
            && (this.getCognScr() == null ? other.getCognScr() == null : this.getCognScr().equals(other.getCognScr()))
            && (this.getCognRslt() == null ? other.getCognRslt() == null : this.getCognRslt().equals(other.getCognRslt()))
            && (this.getEftDt() == null ? other.getEftDt() == null : this.getEftDt().equals(other.getEftDt()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getIsVld() == null ? other.getIsVld() == null : this.getIsVld().equals(other.getIsVld()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getLastUpdTlr() == null ? other.getLastUpdTlr() == null : this.getLastUpdTlr().equals(other.getLastUpdTlr()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))
            && (this.getProcessId() == null ? other.getProcessId() == null : this.getProcessId().equals(other.getProcessId()))
            && (this.getCardRes() == null ? other.getCardRes() == null : this.getCardRes().equals(other.getCardRes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEvalId() == null) ? 0 : getEvalId().hashCode());
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        result = prime * result + ((getRltId() == null) ? 0 : getRltId().hashCode());
        result = prime * result + ((getFinDt() == null) ? 0 : getFinDt().hashCode());
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        result = prime * result + ((getMdlNm() == null) ? 0 : getMdlNm().hashCode());
        result = prime * result + ((getEvalDt() == null) ? 0 : getEvalDt().hashCode());
        result = prime * result + ((getEvalScr() == null) ? 0 : getEvalScr().hashCode());
        result = prime * result + ((getEvalRslt() == null) ? 0 : getEvalRslt().hashCode());
        result = prime * result + ((getCognScr() == null) ? 0 : getCognScr().hashCode());
        result = prime * result + ((getCognRslt() == null) ? 0 : getCognRslt().hashCode());
        result = prime * result + ((getEftDt() == null) ? 0 : getEftDt().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getIsVld() == null) ? 0 : getIsVld().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getLastUpdTlr() == null) ? 0 : getLastUpdTlr().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        result = prime * result + ((getProcessId() == null) ? 0 : getProcessId().hashCode());
        result = prime * result + ((getCardRes() == null) ? 0 : getCardRes().hashCode());
        return result;
    }
}