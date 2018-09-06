package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrLcInfo实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月17日下午2:50:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月17日下午2:50:10	     新增
 *
 * </pre>
 */
public class BCrrLcInfo extends BCrrBillKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String lcId;

    /**
     * VARCHAR(32)<br>
     * 关联类型
     */
    private String relaTyp;

    /**
     * VARCHAR(18)<br>
     * 关联编号
     */
    private String relaNo;

    /**
     * VARCHAR(32)<br>
     * 信用证编号
     */
    private String lcNo;

    /**
     * VARCHAR(18)<br>
     * 信用证类型
     */
    private String lcTyp;

    /**
     * VARCHAR(80)<br>
     * 开证行行名
     */
    private String iseBak;

    /**
     * VARCHAR(80)<br>
     * 开证行地址
     */
    private String iseStat;

    /**
     * VARCHAR(6)<br>
     * 开证行邮编
     */
    private String iseCd;

    /**
     * VARCHAR(10)<br>
     * 归档日期
     */
    private String iseDt;

    /**
     * VARCHAR(200)<br>
     * 用途
     */
    private String prps;

    /**
     * VARCHAR(32)<br>
     * 开证申请人帐号
     */
    private String aplatNo;

    /**
     * VARCHAR(80)<br>
     * 开证申请人名称
     */
    private String aplatNm;

    /**
     * VARCHAR(200)<br>
     * 开证申请人地址
     */
    private String aplatAds;

    /**
     * VARCHAR(32)<br>
     * 受益人帐号
     */
    private String bnfcyNo;

    /**
     * VARCHAR(80)<br>
     * 受益人
     */
    private String bnfcyNm;

    /**
     * VARCHAR(200)<br>
     * 受益人地址
     */
    private String bnfcyAds;

    /**
     * VARCHAR(6)<br>
     * 受益人邮编
     */
    private String bnfcyCd;

    /**
     * VARCHAR(10)<br>
     * 最晚装运期
     */
    private String lstDocDt;

    /**
     * VARCHAR(10)<br>
     * 信用证交单期
     */
    private String docDt;

    /**
     * VARCHAR(10)<br>
     * 远期信用证付款期限
     */
    private String lcTrmTyp;

    /**
     * VARCHAR(18)<br>
     * 远期信用证是否已承兑/有无其他担保方式
     */
    private String flg;

    /**
     * VARCHAR(2)<br>
     * 分批装运
     */
    private String batLoad;

    /**
     * VARCHAR(2)<br>
     * 转运
     */
    private String trspt;

    /**
     * VARCHAR(60)<br>
     * 装运地
     */
    private String loadArea;

    /**
     * VARCHAR(60)<br>
     * 货物运输目的地
     */
    private String destArea;

    /**
     * VARCHAR(5)<br>
     * 运输方式
     */
    private String loadTyp;

    /**
     * VARCHAR(5)<br>
     * 发送方式
     */
    private String sendTyp;

    /**
     * VARCHAR(5)<br>
     * 费用承担人
     */
    private String paySite;

    /**
     * DECIMAL(22)<br>
     * 付款期限(天)
     */
    private BigDecimal lcTrm;

    /**
     * VARCHAR(5)<br>
     * 付款方式
     */
    private String payTyp;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 流水号
     */
    public String getLcId() {
        return lcId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 流水号
     */
    public void setLcId(String lcId) {
        this.lcId = lcId == null ? null : lcId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 关联类型
     */
    public String getRelaTyp() {
        return relaTyp;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 关联类型
     */
    public void setRelaTyp(String relaTyp) {
        this.relaTyp = relaTyp == null ? null : relaTyp.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 关联编号
     */
    public String getRelaNo() {
        return relaNo;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 关联编号
     */
    public void setRelaNo(String relaNo) {
        this.relaNo = relaNo == null ? null : relaNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 信用证编号
     */
    public String getLcNo() {
        return lcNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 信用证编号
     */
    public void setLcNo(String lcNo) {
        this.lcNo = lcNo == null ? null : lcNo.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 信用证类型
     */
    public String getLcTyp() {
        return lcTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 信用证类型
     */
    public void setLcTyp(String lcTyp) {
        this.lcTyp = lcTyp == null ? null : lcTyp.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 开证行行名
     */
    public String getIseBak() {
        return iseBak;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 开证行行名
     */
    public void setIseBak(String iseBak) {
        this.iseBak = iseBak == null ? null : iseBak.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 开证行地址
     */
    public String getIseStat() {
        return iseStat;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 开证行地址
     */
    public void setIseStat(String iseStat) {
        this.iseStat = iseStat == null ? null : iseStat.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 开证行邮编
     */
    public String getIseCd() {
        return iseCd;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 开证行邮编
     */
    public void setIseCd(String iseCd) {
        this.iseCd = iseCd == null ? null : iseCd.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 归档日期
     */
    public String getIseDt() {
        return iseDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 归档日期
     */
    public void setIseDt(String iseDt) {
        this.iseDt = iseDt == null ? null : iseDt.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 用途
     */
    public String getPrps() {
        return prps;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 用途
     */
    public void setPrps(String prps) {
        this.prps = prps == null ? null : prps.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 开证申请人帐号
     */
    public String getAplatNo() {
        return aplatNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 开证申请人帐号
     */
    public void setAplatNo(String aplatNo) {
        this.aplatNo = aplatNo == null ? null : aplatNo.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 开证申请人名称
     */
    public String getAplatNm() {
        return aplatNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 开证申请人名称
     */
    public void setAplatNm(String aplatNm) {
        this.aplatNm = aplatNm == null ? null : aplatNm.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 开证申请人地址
     */
    public String getAplatAds() {
        return aplatAds;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 开证申请人地址
     */
    public void setAplatAds(String aplatAds) {
        this.aplatAds = aplatAds == null ? null : aplatAds.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 受益人帐号
     */
    public String getBnfcyNo() {
        return bnfcyNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 受益人帐号
     */
    public void setBnfcyNo(String bnfcyNo) {
        this.bnfcyNo = bnfcyNo == null ? null : bnfcyNo.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 受益人
     */
    public String getBnfcyNm() {
        return bnfcyNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 受益人
     */
    public void setBnfcyNm(String bnfcyNm) {
        this.bnfcyNm = bnfcyNm == null ? null : bnfcyNm.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 受益人地址
     */
    public String getBnfcyAds() {
        return bnfcyAds;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 受益人地址
     */
    public void setBnfcyAds(String bnfcyAds) {
        this.bnfcyAds = bnfcyAds == null ? null : bnfcyAds.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 受益人邮编
     */
    public String getBnfcyCd() {
        return bnfcyCd;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 受益人邮编
     */
    public void setBnfcyCd(String bnfcyCd) {
        this.bnfcyCd = bnfcyCd == null ? null : bnfcyCd.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 最晚装运期
     */
    public String getLstDocDt() {
        return lstDocDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 最晚装运期
     */
    public void setLstDocDt(String lstDocDt) {
        this.lstDocDt = lstDocDt == null ? null : lstDocDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 信用证交单期
     */
    public String getDocDt() {
        return docDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 信用证交单期
     */
    public void setDocDt(String docDt) {
        this.docDt = docDt == null ? null : docDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 远期信用证付款期限
     */
    public String getLcTrmTyp() {
        return lcTrmTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 远期信用证付款期限
     */
    public void setLcTrmTyp(String lcTrmTyp) {
        this.lcTrmTyp = lcTrmTyp == null ? null : lcTrmTyp.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 远期信用证是否已承兑/有无其他担保方式
     */
    public String getFlg() {
        return flg;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 远期信用证是否已承兑/有无其他担保方式
     */
    public void setFlg(String flg) {
        this.flg = flg == null ? null : flg.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 分批装运
     */
    public String getBatLoad() {
        return batLoad;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 分批装运
     */
    public void setBatLoad(String batLoad) {
        this.batLoad = batLoad == null ? null : batLoad.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 转运
     */
    public String getTrspt() {
        return trspt;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 转运
     */
    public void setTrspt(String trspt) {
        this.trspt = trspt == null ? null : trspt.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 装运地
     */
    public String getLoadArea() {
        return loadArea;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 装运地
     */
    public void setLoadArea(String loadArea) {
        this.loadArea = loadArea == null ? null : loadArea.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 货物运输目的地
     */
    public String getDestArea() {
        return destArea;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 货物运输目的地
     */
    public void setDestArea(String destArea) {
        this.destArea = destArea == null ? null : destArea.trim();
    }

    /**
     * VARCHAR(5)<br>
     * 获得 运输方式
     */
    public String getLoadTyp() {
        return loadTyp;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 运输方式
     */
    public void setLoadTyp(String loadTyp) {
        this.loadTyp = loadTyp == null ? null : loadTyp.trim();
    }

    /**
     * VARCHAR(5)<br>
     * 获得 发送方式
     */
    public String getSendTyp() {
        return sendTyp;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 发送方式
     */
    public void setSendTyp(String sendTyp) {
        this.sendTyp = sendTyp == null ? null : sendTyp.trim();
    }

    /**
     * VARCHAR(5)<br>
     * 获得 费用承担人
     */
    public String getPaySite() {
        return paySite;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 费用承担人
     */
    public void setPaySite(String paySite) {
        this.paySite = paySite == null ? null : paySite.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 付款期限(天)
     */
    public BigDecimal getLcTrm() {
        return lcTrm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 付款期限(天)
     */
    public void setLcTrm(BigDecimal lcTrm) {
        this.lcTrm = lcTrm;
    }

    /**
     * VARCHAR(5)<br>
     * 获得 付款方式
     */
    public String getPayTyp() {
        return payTyp;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 付款方式
     */
    public void setPayTyp(String payTyp) {
        this.payTyp = payTyp == null ? null : payTyp.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lcId=").append(lcId);
        sb.append(", relaTyp=").append(relaTyp);
        sb.append(", relaNo=").append(relaNo);
        sb.append(", lcNo=").append(lcNo);
        sb.append(", lcTyp=").append(lcTyp);
        sb.append(", iseBak=").append(iseBak);
        sb.append(", iseStat=").append(iseStat);
        sb.append(", iseCd=").append(iseCd);
        sb.append(", iseDt=").append(iseDt);
        sb.append(", prps=").append(prps);
        sb.append(", aplatNo=").append(aplatNo);
        sb.append(", aplatNm=").append(aplatNm);
        sb.append(", aplatAds=").append(aplatAds);
        sb.append(", bnfcyNo=").append(bnfcyNo);
        sb.append(", bnfcyNm=").append(bnfcyNm);
        sb.append(", bnfcyAds=").append(bnfcyAds);
        sb.append(", bnfcyCd=").append(bnfcyCd);
        sb.append(", lstDocDt=").append(lstDocDt);
        sb.append(", docDt=").append(docDt);
        sb.append(", lcTrmTyp=").append(lcTrmTyp);
        sb.append(", flg=").append(flg);
        sb.append(", batLoad=").append(batLoad);
        sb.append(", trspt=").append(trspt);
        sb.append(", loadArea=").append(loadArea);
        sb.append(", destArea=").append(destArea);
        sb.append(", loadTyp=").append(loadTyp);
        sb.append(", sendTyp=").append(sendTyp);
        sb.append(", paySite=").append(paySite);
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
        sb.append(", lcTrm=").append(lcTrm);
        sb.append(", payTyp=").append(payTyp);
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
        BCrrLcInfo other = (BCrrLcInfo) that;
        return (this.getLcId() == null ? other.getLcId() == null : this.getLcId().equals(other.getLcId()))
            && (this.getRelaTyp() == null ? other.getRelaTyp() == null : this.getRelaTyp().equals(other.getRelaTyp()))
            && (this.getRelaNo() == null ? other.getRelaNo() == null : this.getRelaNo().equals(other.getRelaNo()))
            && (this.getLcNo() == null ? other.getLcNo() == null : this.getLcNo().equals(other.getLcNo()))
            && (this.getLcTyp() == null ? other.getLcTyp() == null : this.getLcTyp().equals(other.getLcTyp()))
            && (this.getIseBak() == null ? other.getIseBak() == null : this.getIseBak().equals(other.getIseBak()))
            && (this.getIseStat() == null ? other.getIseStat() == null : this.getIseStat().equals(other.getIseStat()))
            && (this.getIseCd() == null ? other.getIseCd() == null : this.getIseCd().equals(other.getIseCd()))
            && (this.getIseDt() == null ? other.getIseDt() == null : this.getIseDt().equals(other.getIseDt()))
            && (this.getPrps() == null ? other.getPrps() == null : this.getPrps().equals(other.getPrps()))
            && (this.getAplatNo() == null ? other.getAplatNo() == null : this.getAplatNo().equals(other.getAplatNo()))
            && (this.getAplatNm() == null ? other.getAplatNm() == null : this.getAplatNm().equals(other.getAplatNm()))
            && (this.getAplatAds() == null ? other.getAplatAds() == null : this.getAplatAds().equals(other.getAplatAds()))
            && (this.getBnfcyNo() == null ? other.getBnfcyNo() == null : this.getBnfcyNo().equals(other.getBnfcyNo()))
            && (this.getBnfcyNm() == null ? other.getBnfcyNm() == null : this.getBnfcyNm().equals(other.getBnfcyNm()))
            && (this.getBnfcyAds() == null ? other.getBnfcyAds() == null : this.getBnfcyAds().equals(other.getBnfcyAds()))
            && (this.getBnfcyCd() == null ? other.getBnfcyCd() == null : this.getBnfcyCd().equals(other.getBnfcyCd()))
            && (this.getLstDocDt() == null ? other.getLstDocDt() == null : this.getLstDocDt().equals(other.getLstDocDt()))
            && (this.getDocDt() == null ? other.getDocDt() == null : this.getDocDt().equals(other.getDocDt()))
            && (this.getLcTrmTyp() == null ? other.getLcTrmTyp() == null : this.getLcTrmTyp().equals(other.getLcTrmTyp()))
            && (this.getFlg() == null ? other.getFlg() == null : this.getFlg().equals(other.getFlg()))
            && (this.getBatLoad() == null ? other.getBatLoad() == null : this.getBatLoad().equals(other.getBatLoad()))
            && (this.getTrspt() == null ? other.getTrspt() == null : this.getTrspt().equals(other.getTrspt()))
            && (this.getLoadArea() == null ? other.getLoadArea() == null : this.getLoadArea().equals(other.getLoadArea()))
            && (this.getDestArea() == null ? other.getDestArea() == null : this.getDestArea().equals(other.getDestArea()))
            && (this.getLoadTyp() == null ? other.getLoadTyp() == null : this.getLoadTyp().equals(other.getLoadTyp()))
            && (this.getSendTyp() == null ? other.getSendTyp() == null : this.getSendTyp().equals(other.getSendTyp()))
            && (this.getPaySite() == null ? other.getPaySite() == null : this.getPaySite().equals(other.getPaySite()))
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
            && (this.getLcTrm() == null ? other.getLcTrm() == null : this.getLcTrm().equals(other.getLcTrm()))
            && (this.getPayTyp() == null ? other.getPayTyp() == null : this.getPayTyp().equals(other.getPayTyp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLcId() == null) ? 0 : getLcId().hashCode());
        result = prime * result + ((getRelaTyp() == null) ? 0 : getRelaTyp().hashCode());
        result = prime * result + ((getRelaNo() == null) ? 0 : getRelaNo().hashCode());
        result = prime * result + ((getLcNo() == null) ? 0 : getLcNo().hashCode());
        result = prime * result + ((getLcTyp() == null) ? 0 : getLcTyp().hashCode());
        result = prime * result + ((getIseBak() == null) ? 0 : getIseBak().hashCode());
        result = prime * result + ((getIseStat() == null) ? 0 : getIseStat().hashCode());
        result = prime * result + ((getIseCd() == null) ? 0 : getIseCd().hashCode());
        result = prime * result + ((getIseDt() == null) ? 0 : getIseDt().hashCode());
        result = prime * result + ((getPrps() == null) ? 0 : getPrps().hashCode());
        result = prime * result + ((getAplatNo() == null) ? 0 : getAplatNo().hashCode());
        result = prime * result + ((getAplatNm() == null) ? 0 : getAplatNm().hashCode());
        result = prime * result + ((getAplatAds() == null) ? 0 : getAplatAds().hashCode());
        result = prime * result + ((getBnfcyNo() == null) ? 0 : getBnfcyNo().hashCode());
        result = prime * result + ((getBnfcyNm() == null) ? 0 : getBnfcyNm().hashCode());
        result = prime * result + ((getBnfcyAds() == null) ? 0 : getBnfcyAds().hashCode());
        result = prime * result + ((getBnfcyCd() == null) ? 0 : getBnfcyCd().hashCode());
        result = prime * result + ((getLstDocDt() == null) ? 0 : getLstDocDt().hashCode());
        result = prime * result + ((getDocDt() == null) ? 0 : getDocDt().hashCode());
        result = prime * result + ((getLcTrmTyp() == null) ? 0 : getLcTrmTyp().hashCode());
        result = prime * result + ((getFlg() == null) ? 0 : getFlg().hashCode());
        result = prime * result + ((getBatLoad() == null) ? 0 : getBatLoad().hashCode());
        result = prime * result + ((getTrspt() == null) ? 0 : getTrspt().hashCode());
        result = prime * result + ((getLoadArea() == null) ? 0 : getLoadArea().hashCode());
        result = prime * result + ((getDestArea() == null) ? 0 : getDestArea().hashCode());
        result = prime * result + ((getLoadTyp() == null) ? 0 : getLoadTyp().hashCode());
        result = prime * result + ((getSendTyp() == null) ? 0 : getSendTyp().hashCode());
        result = prime * result + ((getPaySite() == null) ? 0 : getPaySite().hashCode());
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
        result = prime * result + ((getLcTrm() == null) ? 0 : getLcTrm().hashCode());
        result = prime * result + ((getPayTyp() == null) ? 0 : getPayTyp().hashCode());
        return result;
    }
}