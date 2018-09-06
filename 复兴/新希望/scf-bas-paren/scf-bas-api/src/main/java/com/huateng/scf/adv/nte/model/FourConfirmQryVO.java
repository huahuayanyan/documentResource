package com.huateng.scf.adv.nte.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class FourConfirmQryVO extends CommonQryVO{

	private String appno_Q;//appno
	private String coreCustcd_Q;//核心厂商ID
	private String custName_Q;//经销商名称
	private String coreCustName_Q;//
	private String loanWay_Q;//出账方式
	private String startDate_Q;//开始时间从
	private String endDate_Q;//开始时间止
	private String debetId_Q;//借据编号
	private String debetNo_Q;//借据编号
	private String status_Q;//状态
	private String noticeType_Q;//通知书类型
	private String thrCd_Q;//核心厂商
	private BigDecimal lnciAmtFrom_Q;//出账金额
	private BigDecimal lnciAmtTo_Q;
	private String num_Q;//通知书编号
	private String warnLevel_Q;//预警级别
	private String confirmStatus_Q; // 收款确认状态
	private String brname_Q; //经办机构
	private String noticeStatus_Q; //通知书状态
	private String signDate1_Q;
	private String signDate2_Q;
	private String commonDate1_Q;
	private String commonDate2_Q;
	private String productId_Q; //业务品种
	private String bussType;
	
	public String getProductId_Q() {
		return productId_Q;
	}

	public void setProductId_Q(String productId_Q) {
		this.productId_Q = productId_Q;
	}


	public FourConfirmQryVO() {
	}


	public String getCoreCustcd_Q() {
		return coreCustcd_Q;
	}
	public void setCoreCustcd_Q(String coreCustcd_Q) {
		this.coreCustcd_Q = coreCustcd_Q;
	}
	public String getLoanWay_Q() {
		return loanWay_Q;
	}
	public void setLoanWay_Q(String loanWay_Q) {
		this.loanWay_Q = loanWay_Q;
	}

	public String getStartDate_Q() {
		return startDate_Q;
	}
	public void setStartDate_Q(String startDate_Q) {
		this.startDate_Q = startDate_Q;
	}
	public String getEndDate_Q() {
		return endDate_Q;
	}
	public void setEndDate_Q(String endDate_Q) {
		this.endDate_Q = endDate_Q;
	}
	public String getCustName_Q() {
		return custName_Q;
	}
	public void setCustName_Q(String custName_Q) {
		this.custName_Q = custName_Q;
	}
	public String getCoreCustName_Q() {
		return coreCustName_Q;
	}
	public void setCoreCustName_Q(String coreCustName_Q) {
		this.coreCustName_Q = coreCustName_Q;
	}
	public String getDebetId_Q() {
		return debetId_Q;
	}
	public void setDebetId_Q(String debetId_Q) {
		this.debetId_Q = debetId_Q;
	}
	public String getDebetNo_Q() {
		return debetNo_Q;
	}
	public void setDebetNo_Q(String debetNo_Q) {
		this.debetNo_Q = debetNo_Q;
	}

	public String getStatus_Q() {
		return status_Q;
	}

	public void setStatus_Q(String status_Q) {
		this.status_Q = status_Q;
	}

	public String getAppno_Q() {
		return appno_Q;
	}

	public void setAppno_Q(String appno_Q) {
		this.appno_Q = appno_Q;
	}

	public String getNoticeType_Q() {
		return noticeType_Q;
	}

	public void setNoticeType_Q(String noticeType_Q) {
		this.noticeType_Q = noticeType_Q;
	}

	public String getThrCd_Q() {
		return thrCd_Q;
	}

	public void setThrCd_Q(String thrCd_Q) {
		this.thrCd_Q = thrCd_Q;
	}

	public BigDecimal getLnciAmtFrom_Q() {
		return lnciAmtFrom_Q;
	}

	public void setLnciAmtFrom_Q(BigDecimal lnciAmtFrom_Q) {
		this.lnciAmtFrom_Q = lnciAmtFrom_Q;
	}

	public BigDecimal getLnciAmtTo_Q() {
		return lnciAmtTo_Q;
	}

	public void setLnciAmtTo_Q(BigDecimal lnciAmtTo_Q) {
		this.lnciAmtTo_Q = lnciAmtTo_Q;
	}

	public String getNum_Q() {
		return num_Q;
	}

	public void setNum_Q(String num_Q) {
		this.num_Q = num_Q;
	}

	public String getWarnLevel_Q() {
		return warnLevel_Q;
	}

	public void setWarnLevel_Q(String warnLevel_Q) {
		this.warnLevel_Q = warnLevel_Q;
	}

	public String getConfirmStatus_Q() {
		return confirmStatus_Q;
	}

	public void setConfirmStatus_Q(String confirmStatus_Q) {
		this.confirmStatus_Q = confirmStatus_Q;
	}

	public String getBrname_Q() {
		return brname_Q;
	}

	public void setBrname_Q(String brname_Q) {
		this.brname_Q = brname_Q;
	}

	public String getNoticeStatus_Q() {
		return noticeStatus_Q;
	}

	public void setNoticeStatus_Q(String noticeStatus_Q) {
		this.noticeStatus_Q = noticeStatus_Q;
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

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}
	
	
}
