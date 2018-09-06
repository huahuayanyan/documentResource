package com.huateng.scf.bas.crr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrInvInfo实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:43:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:43:17	     新增
 *
 * </pre>
 */
public class BCrrInvInfo extends BCrrBillKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String invId;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String extId;

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
     * 发票号码
     */
    private String invNo;

    /**
     * VARCHAR(18)<br>
     * 发票币种
     */
    private String invCurcd;

    /**
     * VARCHAR(32)<br>
     * 买方代码
     */
    private String prchId;

    /**
     * VARCHAR(80)<br>
     * 买方名称
     */
    private String prchNm;

    /**
     * VARCHAR(32)<br>
     * 卖方代码
     */
    private String sellId;

    /**
     * VARCHAR(80)<br>
     * 卖方名称
     */
    private String sellNm;

    /**
     * VARCHAR(18)<br>
     * 贸易方式
     */
    private String trdTyp;

    /**
     * VARCHAR(200)<br>
     * 贸易产品
     */
    private String trdPrd;

    /**
     * VARCHAR(10)<br>
     * 开票日期
     */
    private String invDt;

    /**
     * DECIMAL(16,2)<br>
     * 金额
     */
    private BigDecimal invSum;

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
    public String getInvId() {
        return invId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 流水号
     */
    public void setInvId(String invId) {
        this.invId = invId == null ? null : invId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getExtId() {
        return extId;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setExtId(String extId) {
        this.extId = extId == null ? null : extId.trim();
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
     * 获得 发票号码
     */
    public String getInvNo() {
        return invNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 发票号码
     */
    public void setInvNo(String invNo) {
        this.invNo = invNo == null ? null : invNo.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 发票币种
     */
    public String getInvCurcd() {
        return invCurcd;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 发票币种
     */
    public void setInvCurcd(String invCurcd) {
        this.invCurcd = invCurcd == null ? null : invCurcd.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 买方代码
     */
    public String getPrchId() {
        return prchId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 买方代码
     */
    public void setPrchId(String prchId) {
        this.prchId = prchId == null ? null : prchId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 买方名称
     */
    public String getPrchNm() {
        return prchNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 买方名称
     */
    public void setPrchNm(String prchNm) {
        this.prchNm = prchNm == null ? null : prchNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 卖方代码
     */
    public String getSellId() {
        return sellId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 卖方代码
     */
    public void setSellId(String sellId) {
        this.sellId = sellId == null ? null : sellId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 卖方名称
     */
    public String getSellNm() {
        return sellNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 卖方名称
     */
    public void setSellNm(String sellNm) {
        this.sellNm = sellNm == null ? null : sellNm.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 贸易方式
     */
    public String getTrdTyp() {
        return trdTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 贸易方式
     */
    public void setTrdTyp(String trdTyp) {
        this.trdTyp = trdTyp == null ? null : trdTyp.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 贸易产品
     */
    public String getTrdPrd() {
        return trdPrd;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 贸易产品
     */
    public void setTrdPrd(String trdPrd) {
        this.trdPrd = trdPrd == null ? null : trdPrd.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 开票日期
     */
    public String getInvDt() {
        return invDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 开票日期
     */
    public void setInvDt(String invDt) {
        this.invDt = invDt == null ? null : invDt.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 金额
     */
    public BigDecimal getInvSum() {
        return invSum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 金额
     */
    public void setInvSum(BigDecimal invSum) {
        this.invSum = invSum;
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
        sb.append(", invId=").append(invId);
        sb.append(", extId=").append(extId);
        sb.append(", relaTyp=").append(relaTyp);
        sb.append(", relaNo=").append(relaNo);
        sb.append(", invNo=").append(invNo);
        sb.append(", invCurcd=").append(invCurcd);
        sb.append(", prchId=").append(prchId);
        sb.append(", prchNm=").append(prchNm);
        sb.append(", sellId=").append(sellId);
        sb.append(", sellNm=").append(sellNm);
        sb.append(", trdTyp=").append(trdTyp);
        sb.append(", trdPrd=").append(trdPrd);
        sb.append(", invDt=").append(invDt);
        sb.append(", invSum=").append(invSum);
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
        BCrrInvInfo other = (BCrrInvInfo) that;
        return (this.getInvId() == null ? other.getInvId() == null : this.getInvId().equals(other.getInvId()))
            && (this.getExtId() == null ? other.getExtId() == null : this.getExtId().equals(other.getExtId()))
            && (this.getRelaTyp() == null ? other.getRelaTyp() == null : this.getRelaTyp().equals(other.getRelaTyp()))
            && (this.getRelaNo() == null ? other.getRelaNo() == null : this.getRelaNo().equals(other.getRelaNo()))
            && (this.getInvNo() == null ? other.getInvNo() == null : this.getInvNo().equals(other.getInvNo()))
            && (this.getInvCurcd() == null ? other.getInvCurcd() == null : this.getInvCurcd().equals(other.getInvCurcd()))
            && (this.getPrchId() == null ? other.getPrchId() == null : this.getPrchId().equals(other.getPrchId()))
            && (this.getPrchNm() == null ? other.getPrchNm() == null : this.getPrchNm().equals(other.getPrchNm()))
            && (this.getSellId() == null ? other.getSellId() == null : this.getSellId().equals(other.getSellId()))
            && (this.getSellNm() == null ? other.getSellNm() == null : this.getSellNm().equals(other.getSellNm()))
            && (this.getTrdTyp() == null ? other.getTrdTyp() == null : this.getTrdTyp().equals(other.getTrdTyp()))
            && (this.getTrdPrd() == null ? other.getTrdPrd() == null : this.getTrdPrd().equals(other.getTrdPrd()))
            && (this.getInvDt() == null ? other.getInvDt() == null : this.getInvDt().equals(other.getInvDt()))
            && (this.getInvSum() == null ? other.getInvSum() == null : this.getInvSum().equals(other.getInvSum()))
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
        result = prime * result + ((getInvId() == null) ? 0 : getInvId().hashCode());
        result = prime * result + ((getExtId() == null) ? 0 : getExtId().hashCode());
        result = prime * result + ((getRelaTyp() == null) ? 0 : getRelaTyp().hashCode());
        result = prime * result + ((getRelaNo() == null) ? 0 : getRelaNo().hashCode());
        result = prime * result + ((getInvNo() == null) ? 0 : getInvNo().hashCode());
        result = prime * result + ((getInvCurcd() == null) ? 0 : getInvCurcd().hashCode());
        result = prime * result + ((getPrchId() == null) ? 0 : getPrchId().hashCode());
        result = prime * result + ((getPrchNm() == null) ? 0 : getPrchNm().hashCode());
        result = prime * result + ((getSellId() == null) ? 0 : getSellId().hashCode());
        result = prime * result + ((getSellNm() == null) ? 0 : getSellNm().hashCode());
        result = prime * result + ((getTrdTyp() == null) ? 0 : getTrdTyp().hashCode());
        result = prime * result + ((getTrdPrd() == null) ? 0 : getTrdPrd().hashCode());
        result = prime * result + ((getInvDt() == null) ? 0 : getInvDt().hashCode());
        result = prime * result + ((getInvSum() == null) ? 0 : getInvSum().hashCode());
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