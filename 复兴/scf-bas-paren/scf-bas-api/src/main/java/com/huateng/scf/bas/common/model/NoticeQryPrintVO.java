/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * <p>
 * 通知书查询VO
 * </p>
 *
 * @author mengjiajia
 * @date 2017年4月20日上午9:44:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月20日上午9:44:35	     新增
 *
 *            </pre>
 */

public class NoticeQryPrintVO extends CommonQryVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;// 编号
	private String pid;//
	private String num;// 通知书编号
	private String moniOfCustcd;// 监管公司客户号
	private String slaveContcode_Q;// 质押合同号
	private String noticeType;// 通知书类型
	private String startDate_Q;// 查询开始日期
	private String endDate_Q;// 查询结束日期
	private String brcodes;// 机构集
	private String brcode;// 经办机构
	private String appno_Q;// 申请编号
	private String pawneeorgid;// 出质人
	private String mortgageType;// 押品类型
	private String loanWay;// 融资方式
	private String status;
	private String coreCustcd;// 核心厂商
	private String thrCd;//
	private String debetId;// 借据编号
	private String modelType;// 通知书模板类型
	private String fileType_Q;// 模板上传文件类型
	private BigDecimal lnciAmtFrom;// 借据金额从
	private BigDecimal lnciAmtTo;// 至
	private String productId;// 产品小类
	private String moniOfName;// 监管公司名称
	private String coreCustName;// 核心厂商名称
	private String monitorProtocolNo;
	private String brcodeNm;
	private String signDate1;
	private String signDate2;
	private String commonDate1_;
	private String commonDate2;
	private String ext1;// 巡库编号
	private String pressMode;// 催收方式
	private Date endDate_from_Q;// 回执日期从
	private Date endDate_to_Q;
	private Date startDate_from_Q;// 签发日期从
	private Date startDate_to_Q;
	private String bussType; // 业务品种
	private String channelFlag;
	private String deliFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMoniOfCustcd() {
		return moniOfCustcd;
	}

	public void setMoniOfCustcd(String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd;
	}

	public String getSlaveContcode_Q() {
		return slaveContcode_Q;
	}

	public void setSlaveContcode_Q(String slaveContcode_Q) {
		this.slaveContcode_Q = slaveContcode_Q;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
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

	public String getBrcodes() {
		return brcodes;
	}

	public void setBrcodes(String brcodes) {
		this.brcodes = brcodes;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getAppno_Q() {
		return appno_Q;
	}

	public void setAppno_Q(String appno_Q) {
		this.appno_Q = appno_Q;
	}

	public String getPawneeorgid() {
		return pawneeorgid;
	}

	public void setPawneeorgid(String pawneeorgid) {
		this.pawneeorgid = pawneeorgid;
	}

	public String getMortgageType() {
		return mortgageType;
	}

	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCoreCustcd() {
		return coreCustcd;
	}

	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}

	public String getThrCd() {
		return thrCd;
	}

	public void setThrCd(String thrCd) {
		this.thrCd = thrCd;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getFileType_Q() {
		return fileType_Q;
	}

	public void setFileType_Q(String fileType_Q) {
		this.fileType_Q = fileType_Q;
	}

	public BigDecimal getLnciAmtFrom() {
		return lnciAmtFrom;
	}

	public void setLnciAmtFrom(BigDecimal lnciAmtFrom) {
		this.lnciAmtFrom = lnciAmtFrom;
	}

	public BigDecimal getLnciAmtTo() {
		return lnciAmtTo;
	}

	public void setLnciAmtTo(BigDecimal lnciAmtTo) {
		this.lnciAmtTo = lnciAmtTo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMoniOfName() {
		return moniOfName;
	}

	public void setMoniOfName(String moniOfName) {
		this.moniOfName = moniOfName;
	}

	public String getCoreCustName() {
		return coreCustName;
	}

	public void setCoreCustName(String coreCustName) {
		this.coreCustName = coreCustName;
	}

	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}

	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}

	public String getBrcodeNm() {
		return brcodeNm;
	}

	public void setBrcodeNm(String brcodeNm) {
		this.brcodeNm = brcodeNm;
	}

	public String getSignDate1() {
		return signDate1;
	}

	public void setSignDate1(String signDate1) {
		this.signDate1 = signDate1;
	}

	public String getSignDate2() {
		return signDate2;
	}

	public void setSignDate2(String signDate2) {
		this.signDate2 = signDate2;
	}

	public String getCommonDate1_() {
		return commonDate1_;
	}

	public void setCommonDate1_(String commonDate1_) {
		this.commonDate1_ = commonDate1_;
	}

	public String getCommonDate2() {
		return commonDate2;
	}

	public void setCommonDate2(String commonDate2) {
		this.commonDate2 = commonDate2;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getPressMode() {
		return pressMode;
	}

	public void setPressMode(String pressMode) {
		this.pressMode = pressMode;
	}

	public Date getEndDate_from_Q() {
		return endDate_from_Q;
	}

	public void setEndDate_from_Q(Date endDate_from_Q) {
		this.endDate_from_Q = endDate_from_Q;
	}

	public Date getEndDate_to_Q() {
		return endDate_to_Q;
	}

	public void setEndDate_to_Q(Date endDate_to_Q) {
		this.endDate_to_Q = endDate_to_Q;
	}

	public Date getStartDate_from_Q() {
		return startDate_from_Q;
	}

	public void setStartDate_from_Q(Date startDate_from_Q) {
		this.startDate_from_Q = startDate_from_Q;
	}

	public Date getStartDate_to_Q() {
		return startDate_to_Q;
	}

	public void setStartDate_to_Q(Date startDate_to_Q) {
		this.startDate_to_Q = startDate_to_Q;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public String getChannelFlag() {
		return channelFlag;
	}

	public void setChannelFlag(String channelFlag) {
		this.channelFlag = channelFlag;
	}

	public String getDeliFlag() {
		return deliFlag;
	}

	public void setDeliFlag(String deliFlag) {
		this.deliFlag = deliFlag;
	}

}
