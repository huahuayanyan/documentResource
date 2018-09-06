package com.huateng.scf.bas.crr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrLgInfo实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:42:31	     新增
 *
 * </pre>
 */
public class BCrrLgInfo extends BCrrBillKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String lgId;

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
     * VARCHAR(32)<br>
     * 保函号码
     */
    private String lgNo;

    /**
     * VARCHAR(18)<br>
     * 保函类型
     */
    private String lgTyp;

    /**
     * VARCHAR(80)<br>
     * 开立银行
     */
    private String iseBak;

    /**
     * VARCHAR(80)<br>
     * 申请人
     */
    private String aplat;

    /**
     * VARCHAR(80)<br>
     * 受益人
     */
    private String bnfcy;

    /**
     * VARCHAR(18)<br>
     * 币种
     */
    private String lgCurcd;

    /**
     * DECIMAL(24,6)<br>
     * 金额
     */
    private BigDecimal lgSum;

    /**
     * VARCHAR(10)<br>
     * 开立日期
     */
    private String wrtDt;

    /**
     * VARCHAR(10)<br>
     * 到期日期
     */
    private String mtrDt;

    /**
     * VARCHAR(80)<br>
     * 期限
     */
    private String trm;

    /**
     * VARCHAR(200)<br>
     * 用途
     */
    private String purPos;

    /**
     * VARCHAR(32)<br>
     * 登记人
     */
    private String tlrNo;

    /**
     * VARCHAR(60)<br>
     * 登记人姓名
     */
    private String tlrNm;

    /**
     * VARCHAR(32)<br>
     * 登记机构
     */
    private String brCd;

    /**
     * VARCHAR(60)<br>
     * 登记机构名称
     */
    private String brNm;

    /**
     * VARCHAR(10)<br>
     * 登记时间
     */
    private String inpDt;

    /**
     * VARCHAR(32)<br>
     * 更新人
     */
    private String lstUpdTlr;

    /**
     * VARCHAR(60)<br>
     * 更新人名称
     */
    private String lstUpdTlrNm;

    /**
     * VARCHAR(32)<br>
     * 更新机构
     */
    private String lstUpdBrCd;

    /**
     * VARCHAR(60)<br>
     * 更新机构名称
     */
    private String lstUpdBrNm;

    /**
     * VARCHAR(20)<br>
     * 更新日期
     */
    private String lstUpdDt;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 流水号
     */
    public String getLgId() {
        return lgId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 流水号
     */
    public void setLgId(String lgId) {
        this.lgId = lgId == null ? null : lgId.trim();
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
     * VARCHAR(32)<br>
     * 获得 保函号码
     */
    public String getLgNo() {
        return lgNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 保函号码
     */
    public void setLgNo(String lgNo) {
        this.lgNo = lgNo == null ? null : lgNo.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 保函类型
     */
    public String getLgTyp() {
        return lgTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 保函类型
     */
    public void setLgTyp(String lgTyp) {
        this.lgTyp = lgTyp == null ? null : lgTyp.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 开立银行
     */
    public String getIseBak() {
        return iseBak;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 开立银行
     */
    public void setIseBak(String iseBak) {
        this.iseBak = iseBak == null ? null : iseBak.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 申请人
     */
    public String getAplat() {
        return aplat;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 申请人
     */
    public void setAplat(String aplat) {
        this.aplat = aplat == null ? null : aplat.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 受益人
     */
    public String getBnfcy() {
        return bnfcy;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 受益人
     */
    public void setBnfcy(String bnfcy) {
        this.bnfcy = bnfcy == null ? null : bnfcy.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 币种
     */
    public String getLgCurcd() {
        return lgCurcd;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 币种
     */
    public void setLgCurcd(String lgCurcd) {
        this.lgCurcd = lgCurcd == null ? null : lgCurcd.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 金额
     */
    public BigDecimal getLgSum() {
        return lgSum;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 金额
     */
    public void setLgSum(BigDecimal lgSum) {
        this.lgSum = lgSum;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 开立日期
     */
    public String getWrtDt() {
        return wrtDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 开立日期
     */
    public void setWrtDt(String wrtDt) {
        this.wrtDt = wrtDt == null ? null : wrtDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 到期日期
     */
    public String getMtrDt() {
        return mtrDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 到期日期
     */
    public void setMtrDt(String mtrDt) {
        this.mtrDt = mtrDt == null ? null : mtrDt.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 期限
     */
    public String getTrm() {
        return trm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 期限
     */
    public void setTrm(String trm) {
        this.trm = trm == null ? null : trm.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 用途
     */
    public String getPurPos() {
        return purPos;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 用途
     */
    public void setPurPos(String purPos) {
        this.purPos = purPos == null ? null : purPos.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记人
     */
    public String getTlrNo() {
        return tlrNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人
     */
    public void setTlrNo(String tlrNo) {
        this.tlrNo = tlrNo == null ? null : tlrNo.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 登记人姓名
     */
    public String getTlrNm() {
        return tlrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 登记人姓名
     */
    public void setTlrNm(String tlrNm) {
        this.tlrNm = tlrNm == null ? null : tlrNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记机构
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记机构
     */
    public void setBrCd(String brCd) {
        this.brCd = brCd == null ? null : brCd.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 登记机构名称
     */
    public String getBrNm() {
        return brNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 登记机构名称
     */
    public void setBrNm(String brNm) {
        this.brNm = brNm == null ? null : brNm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 登记时间
     */
    public String getInpDt() {
        return inpDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 登记时间
     */
    public void setInpDt(String inpDt) {
        this.inpDt = inpDt == null ? null : inpDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新人
     */
    public String getLstUpdTlr() {
        return lstUpdTlr;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新人
     */
    public void setLstUpdTlr(String lstUpdTlr) {
        this.lstUpdTlr = lstUpdTlr == null ? null : lstUpdTlr.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 更新人名称
     */
    public String getLstUpdTlrNm() {
        return lstUpdTlrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 更新人名称
     */
    public void setLstUpdTlrNm(String lstUpdTlrNm) {
        this.lstUpdTlrNm = lstUpdTlrNm == null ? null : lstUpdTlrNm.trim();
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
     * VARCHAR(60)<br>
     * 获得 更新机构名称
     */
    public String getLstUpdBrNm() {
        return lstUpdBrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 更新机构名称
     */
    public void setLstUpdBrNm(String lstUpdBrNm) {
        this.lstUpdBrNm = lstUpdBrNm == null ? null : lstUpdBrNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 更新日期
     */
    public String getLstUpdDt() {
        return lstUpdDt;
    }

    /**
     * VARCHAR(20)<br>
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
        sb.append(", lgId=").append(lgId);
        sb.append(", relaTyp=").append(relaTyp);
        sb.append(", relaNo=").append(relaNo);
        sb.append(", lgNo=").append(lgNo);
        sb.append(", lgTyp=").append(lgTyp);
        sb.append(", iseBak=").append(iseBak);
        sb.append(", aplat=").append(aplat);
        sb.append(", bnfcy=").append(bnfcy);
        sb.append(", lgCurcd=").append(lgCurcd);
        sb.append(", lgSum=").append(lgSum);
        sb.append(", wrtDt=").append(wrtDt);
        sb.append(", mtrDt=").append(mtrDt);
        sb.append(", trm=").append(trm);
        sb.append(", purPos=").append(purPos);
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
        BCrrLgInfo other = (BCrrLgInfo) that;
        return (this.getLgId() == null ? other.getLgId() == null : this.getLgId().equals(other.getLgId()))
            && (this.getRelaTyp() == null ? other.getRelaTyp() == null : this.getRelaTyp().equals(other.getRelaTyp()))
            && (this.getRelaNo() == null ? other.getRelaNo() == null : this.getRelaNo().equals(other.getRelaNo()))
            && (this.getLgNo() == null ? other.getLgNo() == null : this.getLgNo().equals(other.getLgNo()))
            && (this.getLgTyp() == null ? other.getLgTyp() == null : this.getLgTyp().equals(other.getLgTyp()))
            && (this.getIseBak() == null ? other.getIseBak() == null : this.getIseBak().equals(other.getIseBak()))
            && (this.getAplat() == null ? other.getAplat() == null : this.getAplat().equals(other.getAplat()))
            && (this.getBnfcy() == null ? other.getBnfcy() == null : this.getBnfcy().equals(other.getBnfcy()))
            && (this.getLgCurcd() == null ? other.getLgCurcd() == null : this.getLgCurcd().equals(other.getLgCurcd()))
            && (this.getLgSum() == null ? other.getLgSum() == null : this.getLgSum().equals(other.getLgSum()))
            && (this.getWrtDt() == null ? other.getWrtDt() == null : this.getWrtDt().equals(other.getWrtDt()))
            && (this.getMtrDt() == null ? other.getMtrDt() == null : this.getMtrDt().equals(other.getMtrDt()))
            && (this.getTrm() == null ? other.getTrm() == null : this.getTrm().equals(other.getTrm()))
            && (this.getPurPos() == null ? other.getPurPos() == null : this.getPurPos().equals(other.getPurPos()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getTlrNm() == null ? other.getTlrNm() == null : this.getTlrNm().equals(other.getTlrNm()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getBrNm() == null ? other.getBrNm() == null : this.getBrNm().equals(other.getBrNm()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
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
        result = prime * result + ((getLgId() == null) ? 0 : getLgId().hashCode());
        result = prime * result + ((getRelaTyp() == null) ? 0 : getRelaTyp().hashCode());
        result = prime * result + ((getRelaNo() == null) ? 0 : getRelaNo().hashCode());
        result = prime * result + ((getLgNo() == null) ? 0 : getLgNo().hashCode());
        result = prime * result + ((getLgTyp() == null) ? 0 : getLgTyp().hashCode());
        result = prime * result + ((getIseBak() == null) ? 0 : getIseBak().hashCode());
        result = prime * result + ((getAplat() == null) ? 0 : getAplat().hashCode());
        result = prime * result + ((getBnfcy() == null) ? 0 : getBnfcy().hashCode());
        result = prime * result + ((getLgCurcd() == null) ? 0 : getLgCurcd().hashCode());
        result = prime * result + ((getLgSum() == null) ? 0 : getLgSum().hashCode());
        result = prime * result + ((getWrtDt() == null) ? 0 : getWrtDt().hashCode());
        result = prime * result + ((getMtrDt() == null) ? 0 : getMtrDt().hashCode());
        result = prime * result + ((getTrm() == null) ? 0 : getTrm().hashCode());
        result = prime * result + ((getPurPos() == null) ? 0 : getPurPos().hashCode());
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
        return result;
    }
}