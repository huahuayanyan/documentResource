package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrGntyAudit实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:43:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:43:42	     新增
 *
 * </pre>
 */
public class BCrrGntyAudit implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String serialno;

    /**
     * VARCHAR(32)<br>
     * 抵质押物编号
     */
    private String gntyId;

    /**
     * VARCHAR(80)<br>
     * 抵质押物名称
     */
    private String gntyNm;

    /**
     * VARCHAR(18)<br>
     * 抵质押物类型
     */
    private String gntyTyp;

    /**
     * VARCHAR(18)<br>
     * 抵质押物状态
     */
    private String gntyStat;

    /**
     * VARCHAR(10)<br>
     * 入库日期
     */
    private String holdDt;

    /**
     * VARCHAR(10)<br>
     * 出库日期
     */
    private String lostDt;

    /**
     * VARCHAR(200)<br>
     * 出库原因
     */
    private String reason;

    /**
     * VARCHAR(10)<br>
     * 预计再回库日期
     */
    private String planRnDt;

    /**
     * VARCHAR(10)<br>
     * 实际回库日期
     */
    private String factRnDt;

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
     * 获得 抵质押物编号
     */
    public String getGntyId() {
        return gntyId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 抵质押物编号
     */
    public void setGntyId(String gntyId) {
        this.gntyId = gntyId == null ? null : gntyId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 抵质押物名称
     */
    public String getGntyNm() {
        return gntyNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 抵质押物名称
     */
    public void setGntyNm(String gntyNm) {
        this.gntyNm = gntyNm == null ? null : gntyNm.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 抵质押物类型
     */
    public String getGntyTyp() {
        return gntyTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 抵质押物类型
     */
    public void setGntyTyp(String gntyTyp) {
        this.gntyTyp = gntyTyp == null ? null : gntyTyp.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 抵质押物状态
     */
    public String getGntyStat() {
        return gntyStat;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 抵质押物状态
     */
    public void setGntyStat(String gntyStat) {
        this.gntyStat = gntyStat == null ? null : gntyStat.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 入库日期
     */
    public String getHoldDt() {
        return holdDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 入库日期
     */
    public void setHoldDt(String holdDt) {
        this.holdDt = holdDt == null ? null : holdDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 出库日期
     */
    public String getLostDt() {
        return lostDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 出库日期
     */
    public void setLostDt(String lostDt) {
        this.lostDt = lostDt == null ? null : lostDt.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 出库原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 出库原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 预计再回库日期
     */
    public String getPlanRnDt() {
        return planRnDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 预计再回库日期
     */
    public void setPlanRnDt(String planRnDt) {
        this.planRnDt = planRnDt == null ? null : planRnDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 实际回库日期
     */
    public String getFactRnDt() {
        return factRnDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 实际回库日期
     */
    public void setFactRnDt(String factRnDt) {
        this.factRnDt = factRnDt == null ? null : factRnDt.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialno=").append(serialno);
        sb.append(", gntyId=").append(gntyId);
        sb.append(", gntyNm=").append(gntyNm);
        sb.append(", gntyTyp=").append(gntyTyp);
        sb.append(", gntyStat=").append(gntyStat);
        sb.append(", holdDt=").append(holdDt);
        sb.append(", lostDt=").append(lostDt);
        sb.append(", reason=").append(reason);
        sb.append(", planRnDt=").append(planRnDt);
        sb.append(", factRnDt=").append(factRnDt);
        sb.append(", brCd=").append(brCd);
        sb.append(", tlr=").append(tlr);
        sb.append(", inpDt=").append(inpDt);
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
        BCrrGntyAudit other = (BCrrGntyAudit) that;
        return (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getGntyId() == null ? other.getGntyId() == null : this.getGntyId().equals(other.getGntyId()))
            && (this.getGntyNm() == null ? other.getGntyNm() == null : this.getGntyNm().equals(other.getGntyNm()))
            && (this.getGntyTyp() == null ? other.getGntyTyp() == null : this.getGntyTyp().equals(other.getGntyTyp()))
            && (this.getGntyStat() == null ? other.getGntyStat() == null : this.getGntyStat().equals(other.getGntyStat()))
            && (this.getHoldDt() == null ? other.getHoldDt() == null : this.getHoldDt().equals(other.getHoldDt()))
            && (this.getLostDt() == null ? other.getLostDt() == null : this.getLostDt().equals(other.getLostDt()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getPlanRnDt() == null ? other.getPlanRnDt() == null : this.getPlanRnDt().equals(other.getPlanRnDt()))
            && (this.getFactRnDt() == null ? other.getFactRnDt() == null : this.getFactRnDt().equals(other.getFactRnDt()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getTlr() == null ? other.getTlr() == null : this.getTlr().equals(other.getTlr()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getGntyId() == null) ? 0 : getGntyId().hashCode());
        result = prime * result + ((getGntyNm() == null) ? 0 : getGntyNm().hashCode());
        result = prime * result + ((getGntyTyp() == null) ? 0 : getGntyTyp().hashCode());
        result = prime * result + ((getGntyStat() == null) ? 0 : getGntyStat().hashCode());
        result = prime * result + ((getHoldDt() == null) ? 0 : getHoldDt().hashCode());
        result = prime * result + ((getLostDt() == null) ? 0 : getLostDt().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getPlanRnDt() == null) ? 0 : getPlanRnDt().hashCode());
        result = prime * result + ((getFactRnDt() == null) ? 0 : getFactRnDt().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getTlr() == null) ? 0 : getTlr().hashCode());
        result = prime * result + ((getInpDt() == null) ? 0 : getInpDt().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        return result;
    }
}