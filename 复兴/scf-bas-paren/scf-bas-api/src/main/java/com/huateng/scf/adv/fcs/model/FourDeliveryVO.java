/**
 * 
 */
package com.huateng.scf.adv.fcs.model;

import java.math.BigDecimal;

/**
 * <p>预付款四方保兑仓对应VO类</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月28日下午4:18:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月28日下午4:18:53              新增
 *
 * </pre>
 */
public class FourDeliveryVO {

	private String id;//通知书id
	private String num;//通知书编码
	private String appno;//通知书编码
	private String debetNo;//借据编号
	private String debetId;//借据编号
	private String custcd;//经销商ID
	private String coreCustcd;//核心厂商ID
	private String custName;//经销商名称
	private String backCustcd;//回购厂商ID
	private String coreCustName;//核心厂商名称
	private String backCustName;//回购厂商名称
	private String mastContno;//主合同号
	private String protocolNo;// 协议ID
	private String protocolCode;//协议编号
	private String noticeType;//通知书类型
	private BigDecimal lnciAmt;//融资金额
	private BigDecimal lnciBal;//融资余额
	private BigDecimal firstBailRatio;//初始保证金比例
	private BigDecimal bailAmount;//初始保证金金额
	private BigDecimal addBailAmount;//追加保证金金额
	private BigDecimal money;//提货金额
	private BigDecimal openAmount;//业务敞口金额
	private BigDecimal amountOut;//累计提货金额
	private String pledgeeDate;//提货日期
	private String fouCd;//回购商
	private BigDecimal currDeliveryAmt;//提货金额
	private String insertDate;//提货日期
	private String startDate;//出账日期
	private String endDate;//结束日期
	private String limitDate;//最迟应赎完货/单日期
	private BigDecimal amountIn;//剩余提货金额
	private BigDecimal okPrice;//可提货金额
	private java.lang.String firstBailType;//首笔保证金提货模式
	private BigDecimal refundAmount;//还款金额
	private BigDecimal canDeliveryAmt;//本次可提货金额
	private BigDecimal amount;//本次申请提货总金额
	private String productId;//产品Id
	private String noticeId;
	private BigDecimal initCashEqtAmt;//初始现金等价物
	private BigDecimal addCashEqtAmt;//追加现金等价物
	private BigDecimal cashEqtAmt;//现金等价物总额
	private BigDecimal coreBailAmount;//查询核心保证金金额
	private String loanWay;//出账方式
	private String confirmStatus;//收款确认状态
	private String mgrno;//客户经理
	private String brcode;//经办机构
	private String memo;//备注
	
	private String cname;//经销商名称
	private String coreNm;//核心厂商名称
	private String  productName; //产品名称
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getPledgeeDate() {
		return pledgeeDate;
	}
	public void setPledgeeDate(String pledgeeDate) {
		this.pledgeeDate = pledgeeDate;
	}

	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
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
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getBackCustcd() {
		return backCustcd;
	}
	public void setBackCustcd(String backCustcd) {
		this.backCustcd = backCustcd;
	}
	public String getCoreCustName() {
		return coreCustName;
	}
	public void setCoreCustName(String coreCustName) {
		this.coreCustName = coreCustName;
	}
	public String getBackCustName() {
		return backCustName;
	}
	public void setBackCustName(String backCustName) {
		this.backCustName = backCustName;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public BigDecimal getLnciBal() {
		return lnciBal;
	}
	public void setLnciBal(BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public BigDecimal getAmountOut() {
		return amountOut;
	}
	public void setAmountOut(BigDecimal amountOut) {
		this.amountOut = amountOut;
	}
	public BigDecimal getOpenAmount() {
		return openAmount;
	}
	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
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
	public BigDecimal getAmountIn() {
		return amountIn;
	}
	public void setAmountIn(BigDecimal amountIn) {
		this.amountIn = amountIn;
	}
	public BigDecimal getOkPrice() {
		return okPrice;
	}
	public void setOkPrice(BigDecimal okPrice) {
		this.okPrice = okPrice;
	}
	public java.lang.String getFirstBailType() {
		return firstBailType;
	}
	public void setFirstBailType(java.lang.String firstBailType) {
		this.firstBailType = firstBailType;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
