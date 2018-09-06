package com.huateng.scf.adv.nte.service;

import java.math.BigDecimal;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class FourWareGuaranBuyNoticeQryVO extends CommonQryVO {
	private String coreCustcd_Q;//核心厂商
	private String appno_Q;//申请编号
	private BigDecimal moneyFrom_Q;//金额
	private BigDecimal moneyTo_Q;//金额
	private String num_Q;//通知书编号
	private String coreName_Q;//核心厂商名称
	private String signDate1_Q;
	private String signDate2_Q;
	private String commonDate1_Q;
	private String commonDate2_Q;
	private String noticeStatus_Q;
	private String product_Q;
	private String noticeType_Q;
	private String productId_Q;
	
	public String getProduct_Q() {
		return product_Q;
	}
	public void setProduct_Q(String product_Q) {
		this.product_Q = product_Q;
	}
	
	public String getCoreCustcd_Q() {
		return coreCustcd_Q;
	}
	public void setCoreCustcd_Q(String coreCustcdQ) {
		coreCustcd_Q = coreCustcdQ;
	}
	public String getAppno_Q() {
		return appno_Q;
	}
	public void setAppno_Q(String appno_Q) {
		this.appno_Q = appno_Q;
	}
	public BigDecimal getMoneyFrom_Q() {
		return moneyFrom_Q;
	}
	public void setMoneyFrom_Q(BigDecimal moneyFrom_Q) {
		this.moneyFrom_Q = moneyFrom_Q;
	}
	public BigDecimal getMoneyTo_Q() {
		return moneyTo_Q;
	}
	public void setMoneyTo_Q(BigDecimal moneyTo_Q) {
		this.moneyTo_Q = moneyTo_Q;
	}
	public String getNum_Q() {
		return num_Q;
	}
	public void setNum_Q(String num_Q) {
		this.num_Q = num_Q;
	}
	public String getCoreName_Q() {
		return coreName_Q;
	}
	public void setCoreName_Q(String coreName_Q) {
		this.coreName_Q = coreName_Q;
	}
	public String getSignDate1_Q() {
		return signDate1_Q;
	}
	public void setSignDate1_Q(String signDate1_Q) {
		this.signDate1_Q = signDate1_Q;
	}
	public String getSignDate2_Q() {
		return signDate2_Q;
	}
	public void setSignDate2_Q(String signDate2_Q) {
		this.signDate2_Q = signDate2_Q;
	}
	public String getCommonDate1_Q() {
		return commonDate1_Q;
	}
	public void setCommonDate1_Q(String commonDate1_Q) {
		this.commonDate1_Q = commonDate1_Q;
	}
	public String getCommonDate2_Q() {
		return commonDate2_Q;
	}
	public void setCommonDate2_Q(String commonDate2_Q) {
		this.commonDate2_Q = commonDate2_Q;
	}
	public String getNoticeStatus_Q() {
		return noticeStatus_Q;
	}
	public void setNoticeStatus_Q(String noticeStatus_Q) {
		this.noticeStatus_Q = noticeStatus_Q;
	}
	public String getNoticeType_Q() {
		return noticeType_Q;
	}
	public void setNoticeType_Q(String noticeType_Q) {
		this.noticeType_Q = noticeType_Q;
	}
	
	public String getProductId_Q() {
		return productId_Q;
	}
	
	public void setProductId_Q(String productId_Q) {
		this.productId_Q = productId_Q;
	}
	
	
}
