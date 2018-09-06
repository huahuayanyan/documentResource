package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * <p>
 * BCrrGntyCon实体类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年12月24日下午3:29:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午3:29:12	     新增
 *
 *            </pre>
 */
public class BCrrGntyCon extends BCrrLnAppRela implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(40) 必填<br>
	 * 业务流水号，从贷款申请表中带出
	 */
	private String appId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

	/**
	 * VARCHAR(40) 必填<br>
	 * 合同流水号
	 */
	private String conId;

	/**
	 * VARCHAR(20)<br>
	 * 合同类型
	 */
	private String conTyp;

	/**
	 * VARCHAR(20)<br>
	 * 担保类型
	 */
	private String gutyTyp;

	/**
	 * VARCHAR(20)<br>
	 * 合同状态
	 */
	private String conStat;

	/**
	 * VARCHAR(18)<br>
	 * 保证担保形式
	 */
	private String gutFrm;

	/**
	 * VARCHAR(40)<br>
	 * 担保人编号
	 */
	private String gutId;

	/**
	 * VARCHAR(80)<br>
	 * 担保人名称
	 */
	private String gutNm;

	/**
	 * VARCHAR(20)<br>
	 * 担保人证件类型
	 */
	private String gcrtTyp;

	/**
	 * VARCHAR(40)<br>
	 * 担保人证件号码
	 */
	private String gcrtId;

	/**
	 * VARCHAR(32)<br>
	 * 担保人贷款卡编号
	 */
	private String lnNo;

	/**
	 * VARCHAR(20)<br>
	 * 担保币种
	 */
	private String gutCurcd;

	/**
	 * DECIMAL(24,6)<br>
	 * 担保总金额
	 */
	private BigDecimal gutVal;

	/**
	 * VARCHAR(500)<br>
	 * 其它特别约定
	 */
	private String othDscrb;

	/**
	 * DECIMAL(24,6)<br>
	 * 保证金比例
	 */
	private BigDecimal bailRate;

	/**
	 * VARCHAR(10)<br>
	 * 供应链业务品种
	 */
	private String vidPrdId;

	/**
	 * VARCHAR(20)<br>
	 * 监管合同编号
	 */
	private String prtclNo;

	/**
	 * DECIMAL(10,2)<br>
	 * 质押率(%)
	 */
	private BigDecimal ration;

	/**
	 * DECIMAL(16,2)<br>
	 * 新监管下限
	 */
	private BigDecimal lowPriceNew;

	/**
	 * DECIMAL(16,2)<br>
	 * 原监管下限
	 */
	private BigDecimal lowPrice;

	/**
	 * CHAR(1)<br>
	 * 质押模式
	 */
	private String moniMd;

	/**
	 * VARCHAR(10)<br>
	 * 是否最高额担保0-否、1-是
	 */
	private String flg;

	/**
	 * DECIMAL(10,2)<br>
	 * 市值质押率警戒线(%)
	 */
	private BigDecimal guardRat;

	/**
	 * VARCHAR(10)<br>
	 * 担保方式
	 */
	private String gutyWay;

	/**
	 * CHAR(1)<br>
	 * 业务处理状态
	 */
	private String busiStat;

	/**
	 * VARCHAR(32)<br>
	 * 业务申请流水号
	 */
	private String busiNo;

	/**
	 * VARCHAR(60)<br>
	 * 监管公司名称
	 */
	private String prtclBrNm;

	/**
	 * DECIMAL(24,2)<br>
	 * 担保余额
	 */
	private BigDecimal gutSum;

	/**
	 * VARCHAR(10)<br>
	 * 起始日
	 */
	private String strtDt;
	/**
	 * VARCHAR(10)<br>
	 * 起始日
	 */
	private String strtDtFrom;
	/**
	 * VARCHAR(10)<br>
	 * 起始日
	 */
	private String strtDtTo;

	/**
	 * VARCHAR(10)<br>
	 * 到期日
	 */
	private String endDt;
	
	/**
	 */
	private String mortgageNo;

	/**
	 * VARCHAR(40) 必填<br>
	 * 获得 合同流水号
	 */
	public String getConId() {
		return conId;
	}

	/**
	 * VARCHAR(40) 必填<br>
	 * 设置 合同流水号
	 */
	public void setConId(String conId) {
		this.conId = conId == null ? null : conId.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 合同类型
	 */
	public String getConTyp() {
		return conTyp;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 合同类型
	 */
	public void setConTyp(String conTyp) {
		this.conTyp = conTyp == null ? null : conTyp.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 担保类型
	 */
	public String getGutyTyp() {
		return gutyTyp;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 担保类型
	 */
	public void setGutyTyp(String gutyTyp) {
		this.gutyTyp = gutyTyp == null ? null : gutyTyp.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 合同状态
	 */
	public String getConStat() {
		return conStat;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 合同状态
	 */
	public void setConStat(String conStat) {
		this.conStat = conStat == null ? null : conStat.trim();
	}

	/**
	 * VARCHAR(18)<br>
	 * 获得 保证担保形式
	 */
	public String getGutFrm() {
		return gutFrm;
	}

	/**
	 * VARCHAR(18)<br>
	 * 设置 保证担保形式
	 */
	public void setGutFrm(String gutFrm) {
		this.gutFrm = gutFrm == null ? null : gutFrm.trim();
	}

	/**
	 * VARCHAR(40)<br>
	 * 获得 担保人编号
	 */
	public String getGutId() {
		return gutId;
	}

	/**
	 * VARCHAR(40)<br>
	 * 设置 担保人编号
	 */
	public void setGutId(String gutId) {
		this.gutId = gutId == null ? null : gutId.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 担保人名称
	 */
	public String getGutNm() {
		return gutNm;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 担保人名称
	 */
	public void setGutNm(String gutNm) {
		this.gutNm = gutNm == null ? null : gutNm.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 担保人证件类型
	 */
	public String getGcrtTyp() {
		return gcrtTyp;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 担保人证件类型
	 */
	public void setGcrtTyp(String gcrtTyp) {
		this.gcrtTyp = gcrtTyp == null ? null : gcrtTyp.trim();
	}

	/**
	 * VARCHAR(40)<br>
	 * 获得 担保人证件号码
	 */
	public String getGcrtId() {
		return gcrtId;
	}

	/**
	 * VARCHAR(40)<br>
	 * 设置 担保人证件号码
	 */
	public void setGcrtId(String gcrtId) {
		this.gcrtId = gcrtId == null ? null : gcrtId.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 担保人贷款卡编号
	 */
	public String getLnNo() {
		return lnNo;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 担保人贷款卡编号
	 */
	public void setLnNo(String lnNo) {
		this.lnNo = lnNo == null ? null : lnNo.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 担保币种
	 */
	public String getGutCurcd() {
		return gutCurcd;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 担保币种
	 */
	public void setGutCurcd(String gutCurcd) {
		this.gutCurcd = gutCurcd == null ? null : gutCurcd.trim();
	}

	/**
	 * DECIMAL(24,6)<br>
	 * 获得 担保总金额
	 */
	public BigDecimal getGutVal() {
		return gutVal;
	}

	/**
	 * DECIMAL(24,6)<br>
	 * 设置 担保总金额
	 */
	public void setGutVal(BigDecimal gutVal) {
		this.gutVal = gutVal;
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 其它特别约定
	 */
	public String getOthDscrb() {
		return othDscrb;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 其它特别约定
	 */
	public void setOthDscrb(String othDscrb) {
		this.othDscrb = othDscrb == null ? null : othDscrb.trim();
	}

	/**
	 * DECIMAL(24,6)<br>
	 * 获得 保证金比例
	 */
	public BigDecimal getBailRate() {
		return bailRate;
	}

	/**
	 * DECIMAL(24,6)<br>
	 * 设置 保证金比例
	 */
	public void setBailRate(BigDecimal bailRate) {
		this.bailRate = bailRate;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 供应链业务品种
	 */
	public String getVidPrdId() {
		return vidPrdId;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 供应链业务品种
	 */
	public void setVidPrdId(String vidPrdId) {
		this.vidPrdId = vidPrdId == null ? null : vidPrdId.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 监管合同编号
	 */
	public String getPrtclNo() {
		return prtclNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 监管合同编号
	 */
	public void setPrtclNo(String prtclNo) {
		this.prtclNo = prtclNo == null ? null : prtclNo.trim();
	}

	/**
	 * DECIMAL(10,2)<br>
	 * 获得 质押率(%)
	 */
	public BigDecimal getRation() {
		return ration;
	}

	/**
	 * DECIMAL(10,2)<br>
	 * 设置 质押率(%)
	 */
	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 新监管下限
	 */
	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 新监管下限
	 */
	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 原监管下限
	 */
	public BigDecimal getLowPrice() {
		return lowPrice;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 原监管下限
	 */
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 质押模式
	 */
	public String getMoniMd() {
		return moniMd;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 质押模式
	 */
	public void setMoniMd(String moniMd) {
		this.moniMd = moniMd == null ? null : moniMd.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 是否最高额担保0-否、1-是
	 */
	public String getFlg() {
		return flg;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 是否最高额担保0-否、1-是
	 */
	public void setFlg(String flg) {
		this.flg = flg == null ? null : flg.trim();
	}

	/**
	 * DECIMAL(10,2)<br>
	 * 获得 市值质押率警戒线(%)
	 */
	public BigDecimal getGuardRat() {
		return guardRat;
	}

	/**
	 * DECIMAL(10,2)<br>
	 * 设置 市值质押率警戒线(%)
	 */
	public void setGuardRat(BigDecimal guardRat) {
		this.guardRat = guardRat;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 担保方式
	 */
	public String getGutyWay() {
		return gutyWay;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 担保方式
	 */
	public void setGutyWay(String gutyWay) {
		this.gutyWay = gutyWay == null ? null : gutyWay.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 业务处理状态
	 */
	public String getBusiStat() {
		return busiStat;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 业务处理状态
	 */
	public void setBusiStat(String busiStat) {
		this.busiStat = busiStat == null ? null : busiStat.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 业务申请流水号
	 */
	public String getBusiNo() {
		return busiNo;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 业务申请流水号
	 */
	public void setBusiNo(String busiNo) {
		this.busiNo = busiNo == null ? null : busiNo.trim();
	}

	/**
	 * VARCHAR(60)<br>
	 * 获得 监管公司名称
	 */
	public String getPrtclBrNm() {
		return prtclBrNm;
	}

	/**
	 * VARCHAR(60)<br>
	 * 设置 监管公司名称
	 */
	public void setPrtclBrNm(String prtclBrNm) {
		this.prtclBrNm = prtclBrNm == null ? null : prtclBrNm.trim();
	}

	/**
	 * DECIMAL(24,2)<br>
	 * 获得 担保余额
	 */
	public BigDecimal getGutSum() {
		return gutSum;
	}

	/**
	 * DECIMAL(24,2)<br>
	 * 设置 担保余额
	 */
	public void setGutSum(BigDecimal gutSum) {
		this.gutSum = gutSum;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 起始日
	 */
	public String getStrtDt() {
		return strtDt;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 起始日
	 */
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt == null ? null : strtDt.trim();
	}

	public String getStrtDtFrom() {
		return strtDtFrom;
	}

	public void setStrtDtFrom(String strtDtFrom) {
		this.strtDtFrom = strtDtFrom;
	}

	public String getStrtDtTo() {
		return strtDtTo;
	}

	public void setStrtDtTo(String strtDtTo) {
		this.strtDtTo = strtDtTo;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", conId=").append(conId);
		sb.append(", conTyp=").append(conTyp);
		sb.append(", gutyTyp=").append(gutyTyp);
		sb.append(", conStat=").append(conStat);
		sb.append(", gutFrm=").append(gutFrm);
		sb.append(", gutId=").append(gutId);
		sb.append(", gutNm=").append(gutNm);
		sb.append(", gcrtTyp=").append(gcrtTyp);
		sb.append(", gcrtId=").append(gcrtId);
		sb.append(", lnNo=").append(lnNo);
		sb.append(", gutCurcd=").append(gutCurcd);
		sb.append(", gutVal=").append(gutVal);
		sb.append(", othDscrb=").append(othDscrb);
		sb.append(", bailRate=").append(bailRate);
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
		sb.append(", vidPrdId=").append(vidPrdId);
		sb.append(", prtclNo=").append(prtclNo);
		sb.append(", ration=").append(ration);
		sb.append(", lowPriceNew=").append(lowPriceNew);
		sb.append(", lowPrice=").append(lowPrice);
		sb.append(", moniMd=").append(moniMd);
		sb.append(", flg=").append(flg);
		sb.append(", guardRat=").append(guardRat);
		sb.append(", gutyWay=").append(gutyWay);
		sb.append(", busiStat=").append(busiStat);
		sb.append(", busiNo=").append(busiNo);
		sb.append(", prtclBrNm=").append(prtclBrNm);
		sb.append(", gutSum=").append(gutSum);
		sb.append(", strtDt=").append(strtDt);
		sb.append(", endDt=").append(endDt);
		sb.append(", appId=").append(appId);
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
		BCrrGntyCon other = (BCrrGntyCon) that;
		return (this.getConId() == null ? other.getConId() == null : this.getConId().equals(other.getConId()))
				&& (this.getConTyp() == null ? other.getConTyp() == null : this.getConTyp().equals(other.getConTyp()))
				&& (this.getGutyTyp() == null ? other.getGutyTyp() == null : this.getGutyTyp().equals(other.getGutyTyp()))
				&& (this.getConStat() == null ? other.getConStat() == null : this.getConStat().equals(other.getConStat()))
				&& (this.getGutFrm() == null ? other.getGutFrm() == null : this.getGutFrm().equals(other.getGutFrm()))
				&& (this.getGutId() == null ? other.getGutId() == null : this.getGutId().equals(other.getGutId()))
				&& (this.getGutNm() == null ? other.getGutNm() == null : this.getGutNm().equals(other.getGutNm()))
				&& (this.getGcrtTyp() == null ? other.getGcrtTyp() == null : this.getGcrtTyp().equals(other.getGcrtTyp()))
				&& (this.getGcrtId() == null ? other.getGcrtId() == null : this.getGcrtId().equals(other.getGcrtId()))
				&& (this.getLnNo() == null ? other.getLnNo() == null : this.getLnNo().equals(other.getLnNo()))
				&& (this.getGutCurcd() == null ? other.getGutCurcd() == null : this.getGutCurcd().equals(other.getGutCurcd()))
				&& (this.getGutVal() == null ? other.getGutVal() == null : this.getGutVal().equals(other.getGutVal()))
				&& (this.getOthDscrb() == null ? other.getOthDscrb() == null : this.getOthDscrb().equals(other.getOthDscrb()))
				&& (this.getBailRate() == null ? other.getBailRate() == null : this.getBailRate().equals(other.getBailRate()))
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
				&& (this.getVidPrdId() == null ? other.getVidPrdId() == null : this.getVidPrdId().equals(other.getVidPrdId()))
				&& (this.getPrtclNo() == null ? other.getPrtclNo() == null : this.getPrtclNo().equals(other.getPrtclNo()))
				&& (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
				&& (this.getLowPriceNew() == null ? other.getLowPriceNew() == null : this.getLowPriceNew().equals(other.getLowPriceNew()))
				&& (this.getLowPrice() == null ? other.getLowPrice() == null : this.getLowPrice().equals(other.getLowPrice()))
				&& (this.getMoniMd() == null ? other.getMoniMd() == null : this.getMoniMd().equals(other.getMoniMd()))
				&& (this.getFlg() == null ? other.getFlg() == null : this.getFlg().equals(other.getFlg()))
				&& (this.getGuardRat() == null ? other.getGuardRat() == null : this.getGuardRat().equals(other.getGuardRat()))
				&& (this.getGutyWay() == null ? other.getGutyWay() == null : this.getGutyWay().equals(other.getGutyWay()))
				&& (this.getBusiStat() == null ? other.getBusiStat() == null : this.getBusiStat().equals(other.getBusiStat()))
				&& (this.getBusiNo() == null ? other.getBusiNo() == null : this.getBusiNo().equals(other.getBusiNo()))
				&& (this.getPrtclBrNm() == null ? other.getPrtclBrNm() == null : this.getPrtclBrNm().equals(other.getPrtclBrNm()))
				&& (this.getGutSum() == null ? other.getGutSum() == null : this.getGutSum().equals(other.getGutSum()))
				&& (this.getStrtDt() == null ? other.getStrtDt() == null : this.getStrtDt().equals(other.getStrtDt()))
				&& (this.getEndDt() == null ? other.getEndDt() == null : this.getEndDt().equals(other.getEndDt()))
				&& (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getConId() == null) ? 0 : getConId().hashCode());
		result = prime * result + ((getConTyp() == null) ? 0 : getConTyp().hashCode());
		result = prime * result + ((getGutyTyp() == null) ? 0 : getGutyTyp().hashCode());
		result = prime * result + ((getConStat() == null) ? 0 : getConStat().hashCode());
		result = prime * result + ((getGutFrm() == null) ? 0 : getGutFrm().hashCode());
		result = prime * result + ((getGutId() == null) ? 0 : getGutId().hashCode());
		result = prime * result + ((getGutNm() == null) ? 0 : getGutNm().hashCode());
		result = prime * result + ((getGcrtTyp() == null) ? 0 : getGcrtTyp().hashCode());
		result = prime * result + ((getGcrtId() == null) ? 0 : getGcrtId().hashCode());
		result = prime * result + ((getLnNo() == null) ? 0 : getLnNo().hashCode());
		result = prime * result + ((getGutCurcd() == null) ? 0 : getGutCurcd().hashCode());
		result = prime * result + ((getGutVal() == null) ? 0 : getGutVal().hashCode());
		result = prime * result + ((getOthDscrb() == null) ? 0 : getOthDscrb().hashCode());
		result = prime * result + ((getBailRate() == null) ? 0 : getBailRate().hashCode());
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
		result = prime * result + ((getVidPrdId() == null) ? 0 : getVidPrdId().hashCode());
		result = prime * result + ((getPrtclNo() == null) ? 0 : getPrtclNo().hashCode());
		result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
		result = prime * result + ((getLowPriceNew() == null) ? 0 : getLowPriceNew().hashCode());
		result = prime * result + ((getLowPrice() == null) ? 0 : getLowPrice().hashCode());
		result = prime * result + ((getMoniMd() == null) ? 0 : getMoniMd().hashCode());
		result = prime * result + ((getFlg() == null) ? 0 : getFlg().hashCode());
		result = prime * result + ((getGuardRat() == null) ? 0 : getGuardRat().hashCode());
		result = prime * result + ((getGutyWay() == null) ? 0 : getGutyWay().hashCode());
		result = prime * result + ((getBusiStat() == null) ? 0 : getBusiStat().hashCode());
		result = prime * result + ((getBusiNo() == null) ? 0 : getBusiNo().hashCode());
		result = prime * result + ((getPrtclBrNm() == null) ? 0 : getPrtclBrNm().hashCode());
		result = prime * result + ((getGutSum() == null) ? 0 : getGutSum().hashCode());
		result = prime * result + ((getStrtDt() == null) ? 0 : getStrtDt().hashCode());
		result = prime * result + ((getEndDt() == null) ? 0 : getEndDt().hashCode());
		result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
		return result;
	}

	public String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}
}