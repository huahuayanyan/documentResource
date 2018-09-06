package com.huateng.scf.bas.common.model;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月26日上午9:38:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月26日上午9:38:06              新增
 *
 * </pre>
 */

import java.math.BigDecimal;

public class AmountVO {

	private String productId;// 产品小类id
	private String midProductId;//产品中类id
	private String arrivedManageModel;// 融资方式：池，单笔
	private String protocolNo;// 协议号
	private String protocalType;// 协议类型   01--监管协议 02--四方保兑仓协议  03--汽车金融协议  04--保理协议  05--应收账款质押协议  06--订单协议 07--三方保兑仓协议
	private String debetNo;// 借据号
	private String  deliveryModel;// 提货方式
	private String moniType;//监管方式
	private BigDecimal lnciAmt;// 融资金额
	private BigDecimal lnciBal;// 融资余额
	private BigDecimal bailInit;// 初始保证金金额
	private BigDecimal bailRefund;// 追加保证金金额
	private BigDecimal cashInit;// 追加现金等价物价值
	private BigDecimal cashRefund;// 追加现金等价物价值
	private BigDecimal initAmount;// 初始保证金及现金等价物价值
	private BigDecimal refundAmount;// 追加保证金及现金等价物价值
	private BigDecimal BailAmount;// 保证金金额
	private BigDecimal maxBailAmount;// 最高额保证金金额
	private BigDecimal cashAmount;// 现金等价物价值
	private BigDecimal accountAmount;// 保证金及现金等价总金额
	private BigDecimal totPrice;// 押品总价值
	private BigDecimal mortAmount;// 押品价值(计算敞口)
	private BigDecimal firstBailRatio;//初始保证金比例
	private BigDecimal amountOut;//累计提货金额
	private BigDecimal amountUpOut;//向核心累计提货金额
	private BigDecimal amountIn;//可提货提货金额
	private BigDecimal loanPercent;//质押率
	private BigDecimal lowPriceNew;//监管底线(动产动态)
	private Boolean loadFlag=false;
	private String slaveContno;//抵质押合同号
	private BigDecimal addBailAmount;//流程中追加的保证金
	private String cycle;  //合同是否循环
	private String lnciType;  //贷款方式
	private BigDecimal ownFundPayAmt;//自有资金支付金额


	public String getLnciType() {
		return lnciType;
	}

	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
	}

	public BigDecimal getOwnFundPayAmt() {
		return ownFundPayAmt;
	}

	public void setOwnFundPayAmt(BigDecimal ownFundPayAmt) {
		this.ownFundPayAmt = ownFundPayAmt;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public AmountVO() {
		super();
	}

	public AmountVO(String productId, String slaveContno) {
		super();
		this.productId = productId;
		this.slaveContno = slaveContno;
	}

	/**
	 * 编辑构造函数 AmountVO 的文档注释
	 * @param productId 产品类型
	 * @param slaveContno 抵质押合同号
	 * @param protocolNo 协议号
	 * @param debetNo 借据号 可选（池融资时，不填写；单笔时必填）
	 * @param arrivedManageModel 融资方式 可选（不填写，以协议的融资管理模式为准
	 */
	public AmountVO(String productId, String slaveContno, String protocolNo,String debetNo,String arrivedManageModel) {
		super();
		this.productId = productId;
		this.slaveContno = slaveContno;
		this.protocolNo = protocolNo;
		this.debetNo = debetNo;
		this.arrivedManageModel=arrivedManageModel;
	}

	/**
	 * 编辑构造函数 AmountVO 的文档注释
	 * @param midProductId 产品中类 必填
	 * @param protocolNo 抵质押合同号必填
	 * @param protocolType 协议类型 必填
	 * @param debetNo 借据号 可选（池融资时，不填写；单笔时必填）
	 * @param arrivedManageModel 融资方式 可选（不填写，以协议的融资管理模式为准）
	 */
	public AmountVO(String midProductId, String slaveContno,String protocolNo,String protocalType,String debetNo,String arrivedManageModel) {
		super();
		this.midProductId = midProductId;
		this.slaveContno = slaveContno;
		this.protocolNo = protocolNo;
		this.protocalType = protocalType;
		this.debetNo = debetNo;
		this.arrivedManageModel=arrivedManageModel;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public BigDecimal getLoanPercent() {
		return loanPercent;
	}

	public void setLoanPercent(BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}

	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}

	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}

	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}

	public String getArrivedManageModel() {
		return arrivedManageModel;
	}

	public String getDeliveryModel() {
		return deliveryModel;
	}

	public void setDeliveryModel(String deliveryModel) {
		this.deliveryModel = deliveryModel;
	}

	public void setArrivedManageModel(String arrivedManageModel) {
		this.arrivedManageModel = arrivedManageModel;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public BigDecimal getLnciBal() {
		return lnciBal;
	}

	public void setLnciBal(BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}


	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BigDecimal getMortAmount() {
		return mortAmount;
	}

	public void setMortAmount(BigDecimal mortAmount) {
		this.mortAmount = mortAmount;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public BigDecimal getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}

	public BigDecimal getAmountIn() {
		return amountIn;
	}

	public void setAmountIn(BigDecimal amountIn) {
		this.amountIn = amountIn;
	}

	public BigDecimal getAmountOut() {
		return amountOut;
	}
	public void setAmountOut(BigDecimal amountOut) {
		this.amountOut = amountOut;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public Boolean getLoadFlag() {
		return loadFlag;
	}
	public void setLoadFlag(Boolean loadFlag) {
		this.loadFlag = loadFlag;
	}
	public BigDecimal getBailInit() {
		return bailInit;
	}
	public void setBailInit(BigDecimal bailInit) {
		this.bailInit = bailInit;
	}
	public BigDecimal getBailRefund() {
		return bailRefund;
	}
	public void setBailRefund(BigDecimal bailRefund) {
		this.bailRefund = bailRefund;
	}
	public BigDecimal getCashInit() {
		return cashInit;
	}
	public void setCashInit(BigDecimal cashInit) {
		this.cashInit = cashInit;
	}
	public BigDecimal getCashRefund() {
		return cashRefund;
	}
	public void setCashRefund(BigDecimal cashRefund) {
		this.cashRefund = cashRefund;
	}
	public BigDecimal getBailAmount() {
		return BailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		BailAmount = bailAmount;
	}
	public BigDecimal getMaxBailAmount() {
		return maxBailAmount;
	}
	public void setMaxBailAmount(BigDecimal maxBailAmount) {
		this.maxBailAmount = maxBailAmount;
	}
	public BigDecimal getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}
	public BigDecimal getInitAmount() {
		return initAmount;
	}
	public void setInitAmount(BigDecimal initAmount) {
		this.initAmount = initAmount;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getMidProductId() {
		return midProductId;
	}

	public void setMidProductId(String midProductId) {
		this.midProductId = midProductId;
	}

	public String getProtocalType() {
		return protocalType;
	}

	public void setProtocalType(String protocalType) {
		this.protocalType = protocalType;
	}

	public String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public BigDecimal getAmountUpOut() {
		return amountUpOut;
	}

	public void setAmountUpOut(BigDecimal amountUpOut) {
		this.amountUpOut = amountUpOut;
	}
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}

	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
}
