package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrEqptInfo实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:42:49	     新增
 *
 * </pre>
 */
public class BCrrEqptInfo extends BCrrBillKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String eqptId;

    /**
     * VARCHAR(32) 必填<br>
     * 关联类型
     */
    private String relaTyp;

    /**
     * VARCHAR(18) 必填<br>
     * 关联编号
     */
    private String relaNo;

    /**
     * VARCHAR(18)<br>
     * 设备类型
     */
    private String eqptTyp;

    /**
     * VARCHAR(80)<br>
     * 设备名称
     */
    private String eqptNm;

    /**
     * VARCHAR(80)<br>
     * 设备供货商国家或地区
     */
    private String prvdArea;

    /**
     * VARCHAR(80)<br>
     * 设备供货商名称
     */
    private String prvdNm;

    /**
     * VARCHAR(80)<br>
     * 设备制造商国家或地区
     */
    private String factArea;

    /**
     * VARCHAR(80)<br>
     * 设备制造商名称
     */
    private String factNm;

    /**
     * DECIMAL(24,6)<br>
     * 租赁期末设备所有权转移价款
     */
    private BigDecimal latValUe;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 流水号
     */
    public String getEqptId() {
        return eqptId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 流水号
     */
    public void setEqptId(String eqptId) {
        this.eqptId = eqptId == null ? null : eqptId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 关联类型
     */
    public String getRelaTyp() {
        return relaTyp;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 关联类型
     */
    public void setRelaTyp(String relaTyp) {
        this.relaTyp = relaTyp == null ? null : relaTyp.trim();
    }

    /**
     * VARCHAR(18) 必填<br>
     * 获得 关联编号
     */
    public String getRelaNo() {
        return relaNo;
    }

    /**
     * VARCHAR(18) 必填<br>
     * 设置 关联编号
     */
    public void setRelaNo(String relaNo) {
        this.relaNo = relaNo == null ? null : relaNo.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 设备类型
     */
    public String getEqptTyp() {
        return eqptTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 设备类型
     */
    public void setEqptTyp(String eqptTyp) {
        this.eqptTyp = eqptTyp == null ? null : eqptTyp.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 设备名称
     */
    public String getEqptNm() {
        return eqptNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 设备名称
     */
    public void setEqptNm(String eqptNm) {
        this.eqptNm = eqptNm == null ? null : eqptNm.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 设备供货商国家或地区
     */
    public String getPrvdArea() {
        return prvdArea;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 设备供货商国家或地区
     */
    public void setPrvdArea(String prvdArea) {
        this.prvdArea = prvdArea == null ? null : prvdArea.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 设备供货商名称
     */
    public String getPrvdNm() {
        return prvdNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 设备供货商名称
     */
    public void setPrvdNm(String prvdNm) {
        this.prvdNm = prvdNm == null ? null : prvdNm.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 设备制造商国家或地区
     */
    public String getFactArea() {
        return factArea;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 设备制造商国家或地区
     */
    public void setFactArea(String factArea) {
        this.factArea = factArea == null ? null : factArea.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 设备制造商名称
     */
    public String getFactNm() {
        return factNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 设备制造商名称
     */
    public void setFactNm(String factNm) {
        this.factNm = factNm == null ? null : factNm.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 租赁期末设备所有权转移价款
     */
    public BigDecimal getLatValUe() {
        return latValUe;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 租赁期末设备所有权转移价款
     */
    public void setLatValUe(BigDecimal latValUe) {
        this.latValUe = latValUe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eqptId=").append(eqptId);
        sb.append(", relaTyp=").append(relaTyp);
        sb.append(", relaNo=").append(relaNo);
        sb.append(", eqptTyp=").append(eqptTyp);
        sb.append(", eqptNm=").append(eqptNm);
        sb.append(", prvdArea=").append(prvdArea);
        sb.append(", prvdNm=").append(prvdNm);
        sb.append(", factArea=").append(factArea);
        sb.append(", factNm=").append(factNm);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", tlrNm=").append(tlrNm);
        sb.append(", brCd=").append(brCd);
        sb.append(", brNm=").append(brNm);
        sb.append(", inpDt=").append(inpDt);
        sb.append(", lstUpdTlr=").append(lstUpdTlr);
        sb.append(", lstUpdTlrNm=").append(lstUpdTlrNm);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdBrNm=").append(lstUpdBrNm);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        sb.append(", latValUe=").append(latValUe);
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
        BCrrEqptInfo other = (BCrrEqptInfo) that;
        return (this.getEqptId() == null ? other.getEqptId() == null : this.getEqptId().equals(other.getEqptId()))
            && (this.getRelaTyp() == null ? other.getRelaTyp() == null : this.getRelaTyp().equals(other.getRelaTyp()))
            && (this.getRelaNo() == null ? other.getRelaNo() == null : this.getRelaNo().equals(other.getRelaNo()))
            && (this.getEqptTyp() == null ? other.getEqptTyp() == null : this.getEqptTyp().equals(other.getEqptTyp()))
            && (this.getEqptNm() == null ? other.getEqptNm() == null : this.getEqptNm().equals(other.getEqptNm()))
            && (this.getPrvdArea() == null ? other.getPrvdArea() == null : this.getPrvdArea().equals(other.getPrvdArea()))
            && (this.getPrvdNm() == null ? other.getPrvdNm() == null : this.getPrvdNm().equals(other.getPrvdNm()))
            && (this.getFactArea() == null ? other.getFactArea() == null : this.getFactArea().equals(other.getFactArea()))
            && (this.getFactNm() == null ? other.getFactNm() == null : this.getFactNm().equals(other.getFactNm()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getTlrNm() == null ? other.getTlrNm() == null : this.getTlrNm().equals(other.getTlrNm()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getBrNm() == null ? other.getBrNm() == null : this.getBrNm().equals(other.getBrNm()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdTlrNm() == null ? other.getLstUpdTlrNm() == null : this.getLstUpdTlrNm().equals(other.getLstUpdTlrNm()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdBrNm() == null ? other.getLstUpdBrNm() == null : this.getLstUpdBrNm().equals(other.getLstUpdBrNm()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))
            && (this.getLatValUe() == null ? other.getLatValUe() == null : this.getLatValUe().equals(other.getLatValUe()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEqptId() == null) ? 0 : getEqptId().hashCode());
        result = prime * result + ((getRelaTyp() == null) ? 0 : getRelaTyp().hashCode());
        result = prime * result + ((getRelaNo() == null) ? 0 : getRelaNo().hashCode());
        result = prime * result + ((getEqptTyp() == null) ? 0 : getEqptTyp().hashCode());
        result = prime * result + ((getEqptNm() == null) ? 0 : getEqptNm().hashCode());
        result = prime * result + ((getPrvdArea() == null) ? 0 : getPrvdArea().hashCode());
        result = prime * result + ((getPrvdNm() == null) ? 0 : getPrvdNm().hashCode());
        result = prime * result + ((getFactArea() == null) ? 0 : getFactArea().hashCode());
        result = prime * result + ((getFactNm() == null) ? 0 : getFactNm().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getTlrNm() == null) ? 0 : getTlrNm().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getBrNm() == null) ? 0 : getBrNm().hashCode());
        result = prime * result + ((getInpDt() == null) ? 0 : getInpDt().hashCode());
        result = prime * result + ((getLstUpdTlr() == null) ? 0 : getLstUpdTlr().hashCode());
        result = prime * result + ((getLstUpdTlrNm() == null) ? 0 : getLstUpdTlrNm().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdBrNm() == null) ? 0 : getLstUpdBrNm().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        result = prime * result + ((getLatValUe() == null) ? 0 : getLatValUe().hashCode());
        return result;
    }
}