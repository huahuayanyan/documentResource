/**
 * 
 */
package com.huateng.scf.adv.tcs.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月8日下午1:16:30	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月8日下午1:16:30              新增
 *
 * </pre>
 */
public class ThreeConfirmVO {
	private String appno;//申请编号
	private String debetId;//借据号
	private String custcd;//经销商
	private String coreCustcd;//核心厂商
	private BigDecimal firstBailRatio;//初始保证金比率
	private String startDate;//出账日期
	private String endDate;//结束日期
	private String limitDate;//最迟应赎完货/单日期
	private BigDecimal lnciAmt;//借据金额
	private BigDecimal  openAmount;//敞口金额
	private BigDecimal lnciBal;//借据余额
	private BigDecimal bailAmount;//初始保证金
	private BigDecimal refundAmount;//累计还款金额
	private String  protocolNo;//协议号
	private String debetNo;//借据号
	private String loanWay;//出账品种
	private String curcd;//币种
	private String brcode;//机构
	private String lnciType;//出账品种
	private String cname;//经销商名称
	private String coreNm;//核心厂商名称
	private String protocolCode;//协议编号
	private String productId;//产品ID
	private String confirmStatus;//收款状态
	private String mastContno;//合同号
	private String billNo;//汇票编号 
	private BigDecimal amount;// 汇票金额  
	private String billDate;//出票日期
	private String billEndDate;//汇票票结束日期
	private String receiverName;//收款人名称
	private String noticeId;
	private String noticeNum;
	private String id;
	private BigDecimal initCashEqtAmt;//初始现金等价物金额
	private Integer loanDays;//汇票期限
	
	private String tlrno;//客户经理
	private Integer billNum;//票据笔数
	
	private BigDecimal initCashAndBailAmt;//初始现金及保证金金额
	private BigDecimal addCashAndBailAmt;//追加现金及保证金金额
	
	private String brcodeName;//机构名称
	private String tlrName;//客户经理
	
    private BigDecimal addBailAmount; //追加保证金金额

    private BigDecimal addCashEqtAmt;//追加现金等价物金额
	
	private String  productName;
	
	private String  protocolType; //协议类型
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public BigDecimal getOpenAmount() {
		return openAmount;
	}
	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}
	public BigDecimal getLnciBal() {
		return lnciBal;
	}
	public void setLnciBal(BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getLnciType() {
		return lnciType;
	}
	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCoreNm() {
		return coreNm;
	}
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillEndDate() {
		return billEndDate;
	}
	public void setBillEndDate(String billEndDate) {
		this.billEndDate = billEndDate;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getInitCashEqtAmt() {
		return initCashEqtAmt;
	}
	public void setInitCashEqtAmt(BigDecimal initCashEqtAmt) {
		this.initCashEqtAmt = initCashEqtAmt;
	}
	public Integer getLoanDays() {
		return loanDays;
	}
	public void setLoanDays(Integer loanDays) {
		this.loanDays = loanDays;
	}
	public String getTlrno() {
		return tlrno;
	}
	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}
	public Integer getBillNum() {
		return billNum;
	}
	public void setBillNum(Integer billNum) {
		this.billNum = billNum;
	}
	public BigDecimal getInitCashAndBailAmt() {
		return initCashAndBailAmt;
	}
	public void setInitCashAndBailAmt(BigDecimal initCashAndBailAmt) {
		this.initCashAndBailAmt = initCashAndBailAmt;
	}
	public BigDecimal getAddCashAndBailAmt() {
		return addCashAndBailAmt;
	}
	public void setAddCashAndBailAmt(BigDecimal addCashAndBailAmt) {
		this.addCashAndBailAmt = addCashAndBailAmt;
	}
	/**
	 * @return the brcodeName
	 */
	public String getBrcodeName() {
		return brcodeName;
	}
	/**
	 * @param brcodeName the brcodeName to set
	 */
	public void setBrcodeName(String brcodeName) {
		this.brcodeName = brcodeName;
	}
	/**
	 * @return the tlrName
	 */
	public String getTlrName() {
		return tlrName;
	}
	/**
	 * @param tlrName the tlrName to set
	 */
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the addBailAmount
	 */
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	/**
	 * @param addBailAmount the addBailAmount to set
	 */
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	/**
	 * @return the addCashEqtAmt
	 */
	public BigDecimal getAddCashEqtAmt() {
		return addCashEqtAmt;
	}
	/**
	 * @param addCashEqtAmt the addCashEqtAmt to set
	 */
	public void setAddCashEqtAmt(BigDecimal addCashEqtAmt) {
		this.addCashEqtAmt = addCashEqtAmt;
	}
	/**
	 * @return the protocolType
	 */
	public String getProtocolType() {
		return protocolType;
	}
	/**
	 * @param protocolType the protocolType to set
	 */
	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}
}