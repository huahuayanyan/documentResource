package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrGntyChg实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:43:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:43:53	     新增
 *
 * </pre>
 */
public class BCrrGntyChg implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String serialno;

    /**
     * VARCHAR(32)<br>
     * 担保物编号
     */
    private String gntyId;

    /**
     * VARCHAR(10)<br>
     * 变更日期
     */
    private String chgDt;

    /**
     * VARCHAR(18)<br>
     * 变更类型
     */
    private String chgTyp;

    /**
     * VARCHAR(200)<br>
     * 变更原因
     */
    private String chgReason;

    /**
     * VARCHAR(32)<br>
     * 原评估单位代码
     */
    private String oldEvalOrgId;

    /**
     * VARCHAR(80)<br>
     * 原评估单位名称
     */
    private String oldEvalOrgNm;

    /**
     * DECIMAL(24,6)<br>
     * 原评估值
     */
    private BigDecimal oldEvalNetVal;

    /**
     * DECIMAL(24,6)<br>
     * 原认定价值
     */
    private BigDecimal oldConfirmVal;

    /**
     * VARCHAR(32)<br>
     * 原权属人代码
     */
    private String oldOwnerId;

    /**
     * VARCHAR(80)<br>
     * 原权属人名称
     */
    private String oldOwnerNm;

    /**
     * VARCHAR(200)<br>
     * 变更前情况
     */
    private String oldInfo;

    /**
     * VARCHAR(32)<br>
     * 新评估单位代码
     */
    private String newEvalOrgId;

    /**
     * VARCHAR(80)<br>
     * 新评估单位名称
     */
    private String newEvalOrgNm;

    /**
     * DECIMAL(24,6)<br>
     * 新评估值
     */
    private BigDecimal newEvalNetVal;

    /**
     * DECIMAL(24,6)<br>
     * 新认定价值
     */
    private BigDecimal newConfirmVal;

    /**
     * VARCHAR(32)<br>
     * 新权属人代码
     */
    private String newOwnErid;

    /**
     * VARCHAR(80)<br>
     * 新权属人名称
     */
    private String newOwnerNm;

    /**
     * VARCHAR(200)<br>
     * 变更后情况
     */
    private String newInfo;

    /**
     * VARCHAR(32)<br>
     * 经办机构
     */
    private String optOrgId;

    /**
     * VARCHAR(32)<br>
     * 经办人
     */
    private String optUserId;

    /**
     * VARCHAR(40)<br>
     * 登记机构
     */
    private String brCd;

    /**
     * VARCHAR(40)<br>
     * 登记人
     */
    private String tlr;

    /**
     * VARCHAR(10)<br>
     * 登记日期
     */
    private String inpDt;

    /**
     * VARCHAR(10)<br>
     * 更新日期
     */
    private String lstUpdDt;

    /**
     * VARCHAR(200)<br>
     * 备注
     */
    private String rem;

    /**
     * VARCHAR(18)<br>
     * 原权属人证件类型
     */
    private String oldCertTyp;

    /**
     * VARCHAR(32)<br>
     * 原权属人证件编号
     */
    private String oldCertId;

    /**
     * VARCHAR(32)<br>
     * 原权属人贷款卡编号
     */
    private String oldCertLnNo;

    /**
     * VARCHAR(18)<br>
     * 新权属人证件类型
     */
    private String newCertTyp;

    /**
     * VARCHAR(32)<br>
     * 新权属人证件编号
     */
    private String newCertId;

    /**
     * VARCHAR(32)<br>
     * 新权属人贷款卡编号
     */
    private String newCertLnNo;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 担保物编号
     */
    public String getGntyId() {
        return gntyId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 担保物编号
     */
    public void setGntyId(String gntyId) {
        this.gntyId = gntyId == null ? null : gntyId.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 变更日期
     */
    public String getChgDt() {
        return chgDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 变更日期
     */
    public void setChgDt(String chgDt) {
        this.chgDt = chgDt == null ? null : chgDt.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 变更类型
     */
    public String getChgTyp() {
        return chgTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 变更类型
     */
    public void setChgTyp(String chgTyp) {
        this.chgTyp = chgTyp == null ? null : chgTyp.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 变更原因
     */
    public String getChgReason() {
        return chgReason;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 变更原因
     */
    public void setChgReason(String chgReason) {
        this.chgReason = chgReason == null ? null : chgReason.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 原评估单位代码
     */
    public String getOldEvalOrgId() {
        return oldEvalOrgId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 原评估单位代码
     */
    public void setOldEvalOrgId(String oldEvalOrgId) {
        this.oldEvalOrgId = oldEvalOrgId == null ? null : oldEvalOrgId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 原评估单位名称
     */
    public String getOldEvalOrgNm() {
        return oldEvalOrgNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 原评估单位名称
     */
    public void setOldEvalOrgNm(String oldEvalOrgNm) {
        this.oldEvalOrgNm = oldEvalOrgNm == null ? null : oldEvalOrgNm.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 原评估值
     */
    public BigDecimal getOldEvalNetVal() {
        return oldEvalNetVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 原评估值
     */
    public void setOldEvalNetVal(BigDecimal oldEvalNetVal) {
        this.oldEvalNetVal = oldEvalNetVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 原认定价值
     */
    public BigDecimal getOldConfirmVal() {
        return oldConfirmVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 原认定价值
     */
    public void setOldConfirmVal(BigDecimal oldConfirmVal) {
        this.oldConfirmVal = oldConfirmVal;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 原权属人代码
     */
    public String getOldOwnerId() {
        return oldOwnerId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 原权属人代码
     */
    public void setOldOwnerId(String oldOwnerId) {
        this.oldOwnerId = oldOwnerId == null ? null : oldOwnerId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 原权属人名称
     */
    public String getOldOwnerNm() {
        return oldOwnerNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 原权属人名称
     */
    public void setOldOwnerNm(String oldOwnerNm) {
        this.oldOwnerNm = oldOwnerNm == null ? null : oldOwnerNm.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 变更前情况
     */
    public String getOldInfo() {
        return oldInfo;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 变更前情况
     */
    public void setOldInfo(String oldInfo) {
        this.oldInfo = oldInfo == null ? null : oldInfo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 新评估单位代码
     */
    public String getNewEvalOrgId() {
        return newEvalOrgId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 新评估单位代码
     */
    public void setNewEvalOrgId(String newEvalOrgId) {
        this.newEvalOrgId = newEvalOrgId == null ? null : newEvalOrgId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 新评估单位名称
     */
    public String getNewEvalOrgNm() {
        return newEvalOrgNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 新评估单位名称
     */
    public void setNewEvalOrgNm(String newEvalOrgNm) {
        this.newEvalOrgNm = newEvalOrgNm == null ? null : newEvalOrgNm.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 新评估值
     */
    public BigDecimal getNewEvalNetVal() {
        return newEvalNetVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 新评估值
     */
    public void setNewEvalNetVal(BigDecimal newEvalNetVal) {
        this.newEvalNetVal = newEvalNetVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 新认定价值
     */
    public BigDecimal getNewConfirmVal() {
        return newConfirmVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 新认定价值
     */
    public void setNewConfirmVal(BigDecimal newConfirmVal) {
        this.newConfirmVal = newConfirmVal;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 新权属人代码
     */
    public String getNewOwnErid() {
        return newOwnErid;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 新权属人代码
     */
    public void setNewOwnErid(String newOwnErid) {
        this.newOwnErid = newOwnErid == null ? null : newOwnErid.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 新权属人名称
     */
    public String getNewOwnerNm() {
        return newOwnerNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 新权属人名称
     */
    public void setNewOwnerNm(String newOwnerNm) {
        this.newOwnerNm = newOwnerNm == null ? null : newOwnerNm.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 变更后情况
     */
    public String getNewInfo() {
        return newInfo;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 变更后情况
     */
    public void setNewInfo(String newInfo) {
        this.newInfo = newInfo == null ? null : newInfo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 经办机构
     */
    public String getOptOrgId() {
        return optOrgId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 经办机构
     */
    public void setOptOrgId(String optOrgId) {
        this.optOrgId = optOrgId == null ? null : optOrgId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 经办人
     */
    public String getOptUserId() {
        return optUserId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 经办人
     */
    public void setOptUserId(String optUserId) {
        this.optUserId = optUserId == null ? null : optUserId.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 登记机构
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 登记机构
     */
    public void setBrCd(String brCd) {
        this.brCd = brCd == null ? null : brCd.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 登记人
     */
    public String getTlr() {
        return tlr;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 登记人
     */
    public void setTlr(String tlr) {
        this.tlr = tlr == null ? null : tlr.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 登记日期
     */
    public String getInpDt() {
        return inpDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 登记日期
     */
    public void setInpDt(String inpDt) {
        this.inpDt = inpDt == null ? null : inpDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 更新日期
     */
    public String getLstUpdDt() {
        return lstUpdDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 更新日期
     */
    public void setLstUpdDt(String lstUpdDt) {
        this.lstUpdDt = lstUpdDt == null ? null : lstUpdDt.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 备注
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 备注
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 原权属人证件类型
     */
    public String getOldCertTyp() {
        return oldCertTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 原权属人证件类型
     */
    public void setOldCertTyp(String oldCertTyp) {
        this.oldCertTyp = oldCertTyp == null ? null : oldCertTyp.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 原权属人证件编号
     */
    public String getOldCertId() {
        return oldCertId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 原权属人证件编号
     */
    public void setOldCertId(String oldCertId) {
        this.oldCertId = oldCertId == null ? null : oldCertId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 原权属人贷款卡编号
     */
    public String getOldCertLnNo() {
        return oldCertLnNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 原权属人贷款卡编号
     */
    public void setOldCertLnNo(String oldCertLnNo) {
        this.oldCertLnNo = oldCertLnNo == null ? null : oldCertLnNo.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 新权属人证件类型
     */
    public String getNewCertTyp() {
        return newCertTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 新权属人证件类型
     */
    public void setNewCertTyp(String newCertTyp) {
        this.newCertTyp = newCertTyp == null ? null : newCertTyp.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 新权属人证件编号
     */
    public String getNewCertId() {
        return newCertId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 新权属人证件编号
     */
    public void setNewCertId(String newCertId) {
        this.newCertId = newCertId == null ? null : newCertId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 新权属人贷款卡编号
     */
    public String getNewCertLnNo() {
        return newCertLnNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 新权属人贷款卡编号
     */
    public void setNewCertLnNo(String newCertLnNo) {
        this.newCertLnNo = newCertLnNo == null ? null : newCertLnNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialno=").append(serialno);
        sb.append(", gntyId=").append(gntyId);
        sb.append(", chgDt=").append(chgDt);
        sb.append(", chgTyp=").append(chgTyp);
        sb.append(", chgReason=").append(chgReason);
        sb.append(", oldEvalOrgId=").append(oldEvalOrgId);
        sb.append(", oldEvalOrgNm=").append(oldEvalOrgNm);
        sb.append(", oldEvalNetVal=").append(oldEvalNetVal);
        sb.append(", oldConfirmVal=").append(oldConfirmVal);
        sb.append(", oldOwnerId=").append(oldOwnerId);
        sb.append(", oldOwnerNm=").append(oldOwnerNm);
        sb.append(", oldInfo=").append(oldInfo);
        sb.append(", newEvalOrgId=").append(newEvalOrgId);
        sb.append(", newEvalOrgNm=").append(newEvalOrgNm);
        sb.append(", newEvalNetVal=").append(newEvalNetVal);
        sb.append(", newConfirmVal=").append(newConfirmVal);
        sb.append(", newOwnErid=").append(newOwnErid);
        sb.append(", newOwnerNm=").append(newOwnerNm);
        sb.append(", newInfo=").append(newInfo);
        sb.append(", optOrgId=").append(optOrgId);
        sb.append(", optUserId=").append(optUserId);
        sb.append(", brCd=").append(brCd);
        sb.append(", tlr=").append(tlr);
        sb.append(", inpDt=").append(inpDt);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        sb.append(", rem=").append(rem);
        sb.append(", oldCertTyp=").append(oldCertTyp);
        sb.append(", oldCertId=").append(oldCertId);
        sb.append(", oldCertLnNo=").append(oldCertLnNo);
        sb.append(", newCertTyp=").append(newCertTyp);
        sb.append(", newCertId=").append(newCertId);
        sb.append(", newCertLnNo=").append(newCertLnNo);
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
        BCrrGntyChg other = (BCrrGntyChg) that;
        return (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getGntyId() == null ? other.getGntyId() == null : this.getGntyId().equals(other.getGntyId()))
            && (this.getChgDt() == null ? other.getChgDt() == null : this.getChgDt().equals(other.getChgDt()))
            && (this.getChgTyp() == null ? other.getChgTyp() == null : this.getChgTyp().equals(other.getChgTyp()))
            && (this.getChgReason() == null ? other.getChgReason() == null : this.getChgReason().equals(other.getChgReason()))
            && (this.getOldEvalOrgId() == null ? other.getOldEvalOrgId() == null : this.getOldEvalOrgId().equals(other.getOldEvalOrgId()))
            && (this.getOldEvalOrgNm() == null ? other.getOldEvalOrgNm() == null : this.getOldEvalOrgNm().equals(other.getOldEvalOrgNm()))
            && (this.getOldEvalNetVal() == null ? other.getOldEvalNetVal() == null : this.getOldEvalNetVal().equals(other.getOldEvalNetVal()))
            && (this.getOldConfirmVal() == null ? other.getOldConfirmVal() == null : this.getOldConfirmVal().equals(other.getOldConfirmVal()))
            && (this.getOldOwnerId() == null ? other.getOldOwnerId() == null : this.getOldOwnerId().equals(other.getOldOwnerId()))
            && (this.getOldOwnerNm() == null ? other.getOldOwnerNm() == null : this.getOldOwnerNm().equals(other.getOldOwnerNm()))
            && (this.getOldInfo() == null ? other.getOldInfo() == null : this.getOldInfo().equals(other.getOldInfo()))
            && (this.getNewEvalOrgId() == null ? other.getNewEvalOrgId() == null : this.getNewEvalOrgId().equals(other.getNewEvalOrgId()))
            && (this.getNewEvalOrgNm() == null ? other.getNewEvalOrgNm() == null : this.getNewEvalOrgNm().equals(other.getNewEvalOrgNm()))
            && (this.getNewEvalNetVal() == null ? other.getNewEvalNetVal() == null : this.getNewEvalNetVal().equals(other.getNewEvalNetVal()))
            && (this.getNewConfirmVal() == null ? other.getNewConfirmVal() == null : this.getNewConfirmVal().equals(other.getNewConfirmVal()))
            && (this.getNewOwnErid() == null ? other.getNewOwnErid() == null : this.getNewOwnErid().equals(other.getNewOwnErid()))
            && (this.getNewOwnerNm() == null ? other.getNewOwnerNm() == null : this.getNewOwnerNm().equals(other.getNewOwnerNm()))
            && (this.getNewInfo() == null ? other.getNewInfo() == null : this.getNewInfo().equals(other.getNewInfo()))
            && (this.getOptOrgId() == null ? other.getOptOrgId() == null : this.getOptOrgId().equals(other.getOptOrgId()))
            && (this.getOptUserId() == null ? other.getOptUserId() == null : this.getOptUserId().equals(other.getOptUserId()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getTlr() == null ? other.getTlr() == null : this.getTlr().equals(other.getTlr()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getOldCertTyp() == null ? other.getOldCertTyp() == null : this.getOldCertTyp().equals(other.getOldCertTyp()))
            && (this.getOldCertId() == null ? other.getOldCertId() == null : this.getOldCertId().equals(other.getOldCertId()))
            && (this.getOldCertLnNo() == null ? other.getOldCertLnNo() == null : this.getOldCertLnNo().equals(other.getOldCertLnNo()))
            && (this.getNewCertTyp() == null ? other.getNewCertTyp() == null : this.getNewCertTyp().equals(other.getNewCertTyp()))
            && (this.getNewCertId() == null ? other.getNewCertId() == null : this.getNewCertId().equals(other.getNewCertId()))
            && (this.getNewCertLnNo() == null ? other.getNewCertLnNo() == null : this.getNewCertLnNo().equals(other.getNewCertLnNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getGntyId() == null) ? 0 : getGntyId().hashCode());
        result = prime * result + ((getChgDt() == null) ? 0 : getChgDt().hashCode());
        result = prime * result + ((getChgTyp() == null) ? 0 : getChgTyp().hashCode());
        result = prime * result + ((getChgReason() == null) ? 0 : getChgReason().hashCode());
        result = prime * result + ((getOldEvalOrgId() == null) ? 0 : getOldEvalOrgId().hashCode());
        result = prime * result + ((getOldEvalOrgNm() == null) ? 0 : getOldEvalOrgNm().hashCode());
        result = prime * result + ((getOldEvalNetVal() == null) ? 0 : getOldEvalNetVal().hashCode());
        result = prime * result + ((getOldConfirmVal() == null) ? 0 : getOldConfirmVal().hashCode());
        result = prime * result + ((getOldOwnerId() == null) ? 0 : getOldOwnerId().hashCode());
        result = prime * result + ((getOldOwnerNm() == null) ? 0 : getOldOwnerNm().hashCode());
        result = prime * result + ((getOldInfo() == null) ? 0 : getOldInfo().hashCode());
        result = prime * result + ((getNewEvalOrgId() == null) ? 0 : getNewEvalOrgId().hashCode());
        result = prime * result + ((getNewEvalOrgNm() == null) ? 0 : getNewEvalOrgNm().hashCode());
        result = prime * result + ((getNewEvalNetVal() == null) ? 0 : getNewEvalNetVal().hashCode());
        result = prime * result + ((getNewConfirmVal() == null) ? 0 : getNewConfirmVal().hashCode());
        result = prime * result + ((getNewOwnErid() == null) ? 0 : getNewOwnErid().hashCode());
        result = prime * result + ((getNewOwnerNm() == null) ? 0 : getNewOwnerNm().hashCode());
        result = prime * result + ((getNewInfo() == null) ? 0 : getNewInfo().hashCode());
        result = prime * result + ((getOptOrgId() == null) ? 0 : getOptOrgId().hashCode());
        result = prime * result + ((getOptUserId() == null) ? 0 : getOptUserId().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getTlr() == null) ? 0 : getTlr().hashCode());
        result = prime * result + ((getInpDt() == null) ? 0 : getInpDt().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getOldCertTyp() == null) ? 0 : getOldCertTyp().hashCode());
        result = prime * result + ((getOldCertId() == null) ? 0 : getOldCertId().hashCode());
        result = prime * result + ((getOldCertLnNo() == null) ? 0 : getOldCertLnNo().hashCode());
        result = prime * result + ((getNewCertTyp() == null) ? 0 : getNewCertTyp().hashCode());
        result = prime * result + ((getNewCertId() == null) ? 0 : getNewCertId().hashCode());
        result = prime * result + ((getNewCertLnNo() == null) ? 0 : getNewCertLnNo().hashCode());
        return result;
    }
}