/**
 * 
 */
package com.huateng.scf.adv.tcs.model;

/**
 * <p>三方保兑仓提货VO</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月25日下午12:42:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月25日下午12:42:53              新增
 *
 * </pre>
 */

import java.math.BigDecimal;

public class ThreeDeliveryVO {
	private String debetId;//借据号
	private String custcd;//经销商
	private String coreCustcd;//核心厂商
	private String fouCd;//回购商
	private BigDecimal currDeliveryAmt;//提货金额
	private String insertDate;//提货日期
	private BigDecimal firstBailRatio;//初始保证金比率
	private String startDate;//出账日期
	private String endDate;//结束日期
	private String limitDate;//最迟应赎完货/单日期
	private BigDecimal lnciAmt;//借据金额
	private BigDecimal  openAmount;//敞口金额
	private java.math.BigDecimal amountOut;//累计提货金额
	private java.math.BigDecimal amountIn;//剩余提货金额
	private java.math.BigDecimal okPrice;//可提货金额
	private java.lang.String firstBailType;//首笔保证金提货模式
	private BigDecimal bailAmount;//初始保证金及等价物总额
	private BigDecimal refundAmount;//还款金额
	private BigDecimal canDeliveryAmt;//本次可提货金额
	private BigDecimal amount;//本次申请提货总金额
	private String debetNo;//借据号
	private String appno;//申请编号
	private BigDecimal lnciBal;//借据余额
	private String productId;//产品Id
	private String noticeId;
	private String protocolNo;//协议
	private String mastContno;//合同
	private BigDecimal addBailAmount;//追加保证金
	private BigDecimal initCashEqtAmt;//初始现金等价物
	private BigDecimal addCashEqtAmt;//追加现金等价物
	private BigDecimal cashEqtAmt;//现金等价物总额
	private BigDecimal coreBailAmount;//查询核心保证金金额
	private String loanWay;//出账方式
	private String confirmStatus;//收款确认状态
	private String cname;//经销商名称
	private String coreNm;//核心厂商名称

	private String mgrno;//客户经理
	private String brcode;//经办机构
	private String brcodeName;//机构名称
	private String tlrName;//客户经理
	private String memo;//备注
	private String ifspFlag;//是否由FS操作
	private String  productName;
	
	private BigDecimal initCashAndBailAmt;//初始现金及保证金金额
	private BigDecimal addCashAndBailAmt;//追加现金及保证金金额
	

	public String getIfspFlag() {
		return ifspFlag;
	}
	public void setIfspFlag(String ifspFlag) {
		this.ifspFlag = ifspFlag;
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
	public String getFouCd() {
		return fouCd;
	}
	public void setFouCd(String fouCd) {
		this.fouCd = fouCd;
	}
	public BigDecimal getCurrDeliveryAmt() {
		return currDeliveryAmt;
	}
	public void setCurrDeliveryAmt(BigDecimal currDeliveryAmt) {
		this.currDeliveryAmt = currDeliveryAmt;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
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

	public java.math.BigDecimal getAmountOut() {
		return amountOut;
	}
	public void setAmountOut(java.math.BigDecimal amountOut) {
		this.amountOut = amountOut;
	}
	public java.math.BigDecimal getAmountIn() {
		return amountIn;
	}
	public void setAmountIn(java.math.BigDecimal amountIn) {
		this.amountIn = amountIn;
	}
	public java.math.BigDecimal getOkPrice() {
		return okPrice;
	}
	public void setOkPrice(java.math.BigDecimal okPrice) {
		this.okPrice = okPrice;
	}
	public java.lang.String getFirstBailType() {
		return firstBailType;
	}
	public void setFirstBailType(java.lang.String firstBailType) {
		this.firstBailType = firstBailType;
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
	public BigDecimal getCanDeliveryAmt() {
		return canDeliveryAmt;
	}
	public void setCanDeliveryAmt(BigDecimal canDeliveryAmt) {
		this.canDeliveryAmt = canDeliveryAmt;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public BigDecimal getLnciBal() {
		return lnciBal;
	}
	public void setLnciBal(BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public BigDecimal getInitCashEqtAmt() {
		return initCashEqtAmt;
	}
	public void setInitCashEqtAmt(BigDecimal initCashEqtAmt) {
		this.initCashEqtAmt = initCashEqtAmt;
	}
	public BigDecimal getAddCashEqtAmt() {
		return addCashEqtAmt;
	}
	public void setAddCashEqtAmt(BigDecimal addCashEqtAmt) {
		this.addCashEqtAmt = addCashEqtAmt;
	}
	public BigDecimal getCashEqtAmt() {
		return cashEqtAmt;
	}
	public void setCashEqtAmt(BigDecimal cashEqtAmt) {
		this.cashEqtAmt = cashEqtAmt;
	}
	public BigDecimal getCoreBailAmount() {
		return coreBailAmount;
	}
	public void setCoreBailAmount(BigDecimal coreBailAmount) {
		this.coreBailAmount = coreBailAmount;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public String getMgrno() {
		return mgrno;
	}
	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the coreNm
	 */
	public String getCoreNm() {
		return coreNm;
	}
	/**
	 * @param coreNm the coreNm to set
	 */
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
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
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * @return the initCashAndBailAmt
	 */
	public BigDecimal getInitCashAndBailAmt() {
		return initCashAndBailAmt;
	}
	/**
	 * @param initCashAndBailAmt the initCashAndBailAmt to set
	 */
	public void setInitCashAndBailAmt(BigDecimal initCashAndBailAmt) {
		this.initCashAndBailAmt = initCashAndBailAmt;
	}
	/**
	 * @return the addCashAndBailAmt
	 */
	public BigDecimal getAddCashAndBailAmt() {
		return addCashAndBailAmt;
	}
	/**
	 * @param addCashAndBailAmt the addCashAndBailAmt to set
	 */
	public void setAddCashAndBailAmt(BigDecimal addCashAndBailAmt) {
		this.addCashAndBailAmt = addCashAndBailAmt;
	}

	
}

