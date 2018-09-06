package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 三方保兑仓协议
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月22日下午4:24:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午4:24:51              新增
 *
 *            </pre>
 */
public class FourProtocolVO implements Serializable {
	private static final long serialVersionUID = 5172307236300515578L;
	// 预付类，卖卖方与应收类相反
	private String custcd;// 买方客户号
	private String balanceAccount;// 买方结算账号（开户账号）
	private String bailAccount;// 买方保证金账号
	private String sellerBankNo;// 买方开户银行账号
	private String sellerRegAddr;// 买方住所地址
	private String sellerContactName;// 买方联系人

	private String coreCustcd;// 卖方商客户号
	private String coreAccount;// 卖方商结算账号
	private String coreRegAddr;// 卖方商住所地址
	private String coreContactName;// 卖方商联系人

	private String fouCd;// 承担方客户号
	private String refundAccount;// 退款账号

	private String moniCustcd;// 监管方客户号

	private String protocolNo;// 协议号
	private String protocolCode;// 担保提货协议号
	// 协议类型01-监管协议02-四方保兑仓协议03-汽车金融协议04-保理协议05-应收账款质押协议06-订单协议07-三方保兑仓协议
	private String protocolType;// 协议类型
	private String productId;// 业务品种（产品ID）
	private String otherprotocolNo;// 关联协议号
	private String signDate;// 签署日期
	private String startDate;// 协议生效日
	private String endDate;// 协议到期日
	private String tenor;// 期限
	private String curcd;// 币种
	private BigDecimal protAmt;// 协议金额
	private String signIn;// 签署地
	private String status;// 回执状态
	private String otherDes;// 其他描述
	private String state;// 协议状态
	private String tlrno;// 客户经理
	private String brcode;// 经办机构
	private String updateState;// 协议更新状态：0-解除、1-新增、2-修改
	private String updateDate;// 协议更新日期
	private BigDecimal loanPercent;// 质押率
	private String moniType;// 货押模式：1-动态、2-静态
	private BigDecimal lowPriceNew;// 监管底线
	private BigDecimal bailAmount;// 保证金金额
	private BigDecimal firstBailRatio;// 首笔保证金比例
	private String firstBailType;// 首笔保证金提货模式
	private String loanWay;// 出账方式：01-流贷、02-银承
	private Integer loanDays;// 融资期限
	private String arrivedManageMode;// 货物管理模式
	private String goodsNm;// 货物名称
	private String takeMode;// 提货方式：交保证金、提前还款、存单质押、其它现金等价物
	private String isInsurance;// 是否购买保险：1-无需购买保险、2-购买综合保险、3-按单笔出账购买保险
	private String coreCustDuty;// 上游厂商责任
	private String mortgageManageMode;// 押品对应方式
	private String condignee;// 收货人
	private String trasportationMode;// 货物运输方式
	private String deliveryPoints;// 货物交付地点
	private String destination;// 目的港/站/地
	private String triConventions;// 其它约定
	private String fouAddress;// 是否允许直接从上游厂商提货
	private BigDecimal deliveryAmount;// 本次提货金额
	private String tlrName;//
	private String otherCustName;// 其它参与方
	private String dutyAssumeType;// 卖方责任承担方式：授信逾期担保、违约退款

	private String sellerNm;// 买方名称
	private String coreNm;// 卖方商名称
	private String fouName;// 承担方名称
	private String moniNm;// 监管方名称

	private String inputorgname;// 经办机构
	private String cooperationBrcode;// 合作机构代码
	private String cooperationBrcodeNm;// 合作机构名称
	private String sellOffFlag;// 是否签订委托变卖协议：0-否、1-是
	private BigDecimal priceDropRate;// 价格跌幅预警(%)
	private String productName; // 业务品种名称

	private Long consignmentDays; // 发货期限（天）
	private String deliveryMode; // 提货模式 1.一一对应 2.总量对应
	private String circleLoanFlag; // 是否循环走款
	private String tripleProtocolType; // 大小三方

	public FourProtocolVO() {

	}

	public FourProtocolVO(String custcd, String balanceAccount, String bailAccount, String sellerRegAddr, String sellerContactName, String coreCustcd,
			String coreAccount, String coreRegAddr, String coreContactName, String fouCd, String refundAccount, String protocolNo,
			String protocolCode, String protocolType, String productId, String otherprotocolNo, String signDate, String startDate, String endDate,
			String tenor, String curcd, BigDecimal protAmt, String signIn, String status, String otherDes, String state, String tlrno, String brcode,
			String updateState, String updateDate, BigDecimal loanPercent, String moniType, BigDecimal lowPriceNew, BigDecimal bailAmount,
			BigDecimal firstBailRatio, String firstBailType, String loanWay, Integer loanDays, String arrivedManageMode, String goodsNm,
			String takeMode, String isInsurance, String coreCustDuty, String mortgageManageMode, String condignee, String trasportationMode,
			String deliveryPoints, String destination, String triConventions, String fouAddress, BigDecimal deliveryAmount, String tlrName,
			String otherCustName, String dutyAssumeType, String sellerNm, String coreNm, String fouName, String inputorgname,
			String cooperationBrcode, String productName) {
		super();
		this.custcd = custcd;
		this.balanceAccount = balanceAccount;
		this.bailAccount = bailAccount;
		this.sellerRegAddr = sellerRegAddr;
		this.sellerContactName = sellerContactName;
		this.coreCustcd = coreCustcd;
		this.coreAccount = coreAccount;
		this.coreRegAddr = coreRegAddr;
		this.coreContactName = coreContactName;
		this.fouCd = fouCd;
		this.refundAccount = refundAccount;
		this.protocolNo = protocolNo;
		this.protocolCode = protocolCode;
		this.protocolType = protocolType;
		this.productId = productId;
		this.otherprotocolNo = otherprotocolNo;
		this.signDate = signDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tenor = tenor;
		this.curcd = curcd;
		this.protAmt = protAmt;
		this.signIn = signIn;
		this.status = status;
		this.otherDes = otherDes;
		this.state = state;
		this.tlrno = tlrno;
		this.brcode = brcode;
		this.updateState = updateState;
		this.updateDate = updateDate;
		this.loanPercent = loanPercent;
		this.moniType = moniType;
		this.lowPriceNew = lowPriceNew;
		this.bailAmount = bailAmount;
		this.firstBailRatio = firstBailRatio;
		this.firstBailType = firstBailType;
		this.loanWay = loanWay;
		this.loanDays = loanDays;
		this.arrivedManageMode = arrivedManageMode;
		this.goodsNm = goodsNm;
		this.takeMode = takeMode;
		this.isInsurance = isInsurance;
		this.coreCustDuty = coreCustDuty;
		this.mortgageManageMode = mortgageManageMode;
		this.condignee = condignee;
		this.trasportationMode = trasportationMode;
		this.deliveryPoints = deliveryPoints;
		this.destination = destination;
		this.triConventions = triConventions;
		this.fouAddress = fouAddress;
		this.deliveryAmount = deliveryAmount;
		this.tlrName = tlrName;
		this.otherCustName = otherCustName;
		this.dutyAssumeType = dutyAssumeType;
		this.sellerNm = sellerNm;
		this.coreNm = coreNm;
		this.fouName = fouName;
		this.inputorgname = inputorgname;
		this.cooperationBrcode = cooperationBrcode;
		this.setProductName(productName);
	}

	/**
	 * @return the custcd
	 */
	public String getCustcd() {
		return custcd;
	}

	/**
	 * @param custcd
	 *            the custcd to set
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	/**
	 * @return the balanceAccount
	 */
	public String getBalanceAccount() {
		return balanceAccount;
	}

	/**
	 * @param balanceAccount
	 *            the balanceAccount to set
	 */
	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}

	/**
	 * @return the bailAccount
	 */
	public String getBailAccount() {
		return bailAccount;
	}

	/**
	 * @param bailAccount
	 *            the bailAccount to set
	 */
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}

	/**
	 * @return the sellerRegAddr
	 */
	public String getSellerRegAddr() {
		return sellerRegAddr;
	}

	/**
	 * @param sellerRegAddr
	 *            the sellerRegAddr to set
	 */
	public void setSellerRegAddr(String sellerRegAddr) {
		this.sellerRegAddr = sellerRegAddr;
	}

	/**
	 * @return the sellerContactName
	 */
	public String getSellerContactName() {
		return sellerContactName;
	}

	/**
	 * @param sellerContactName
	 *            the sellerContactName to set
	 */
	public void setSellerContactName(String sellerContactName) {
		this.sellerContactName = sellerContactName;
	}

	/**
	 * @return the coreCustcd
	 */
	public String getCoreCustcd() {
		return coreCustcd;
	}

	/**
	 * @param coreCustcd
	 *            the coreCustcd to set
	 */
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}

	/**
	 * @return the coreAccount
	 */
	public String getCoreAccount() {
		return coreAccount;
	}

	/**
	 * @param coreAccount
	 *            the coreAccount to set
	 */
	public void setCoreAccount(String coreAccount) {
		this.coreAccount = coreAccount;
	}

	/**
	 * @return the coreRegAddr
	 */
	public String getCoreRegAddr() {
		return coreRegAddr;
	}

	/**
	 * @param coreRegAddr
	 *            the coreRegAddr to set
	 */
	public void setCoreRegAddr(String coreRegAddr) {
		this.coreRegAddr = coreRegAddr;
	}

	/**
	 * @return the coreContactName
	 */
	public String getCoreContactName() {
		return coreContactName;
	}

	/**
	 * @param coreContactName
	 *            the coreContactName to set
	 */
	public void setCoreContactName(String coreContactName) {
		this.coreContactName = coreContactName;
	}

	/**
	 * @return the fouCd
	 */
	public String getFouCd() {
		return fouCd;
	}

	/**
	 * @param fouCd
	 *            the fouCd to set
	 */
	public void setFouCd(String fouCd) {
		this.fouCd = fouCd;
	}

	/**
	 * @return the refundAccount
	 */
	public String getRefundAccount() {
		return refundAccount;
	}

	/**
	 * @param refundAccount
	 *            the refundAccount to set
	 */
	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	/**
	 * @return the protocolNo
	 */
	public String getProtocolNo() {
		return protocolNo;
	}

	/**
	 * @param protocolNo
	 *            the protocolNo to set
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	/**
	 * @return the protocolCode
	 */
	public String getProtocolCode() {
		return protocolCode;
	}

	/**
	 * @param protocolCode
	 *            the protocolCode to set
	 */
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	/**
	 * @return the protocolType
	 */
	public String getProtocolType() {
		return protocolType;
	}

	/**
	 * @param protocolType
	 *            the protocolType to set
	 */
	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the otherprotocolNo
	 */
	public String getOtherprotocolNo() {
		return otherprotocolNo;
	}

	/**
	 * @param otherprotocolNo
	 *            the otherprotocolNo to set
	 */
	public void setOtherprotocolNo(String otherprotocolNo) {
		this.otherprotocolNo = otherprotocolNo;
	}

	/**
	 * @return the signDate
	 */
	public String getSignDate() {
		return signDate;
	}

	/**
	 * @param signDate
	 *            the signDate to set
	 */
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the tenor
	 */
	public String getTenor() {
		return tenor;
	}

	/**
	 * @param tenor
	 *            the tenor to set
	 */
	public void setTenor(String tenor) {
		this.tenor = tenor;
	}

	/**
	 * @return the curcd
	 */
	public String getCurcd() {
		return curcd;
	}

	/**
	 * @param curcd
	 *            the curcd to set
	 */
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	/**
	 * @return the protAmt
	 */
	public BigDecimal getProtAmt() {
		return protAmt;
	}

	/**
	 * @param protAmt
	 *            the protAmt to set
	 */
	public void setProtAmt(BigDecimal protAmt) {
		this.protAmt = protAmt;
	}

	/**
	 * @return the signIn
	 */
	public String getSignIn() {
		return signIn;
	}

	/**
	 * @param signIn
	 *            the signIn to set
	 */
	public void setSignIn(String signIn) {
		this.signIn = signIn;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the otherDes
	 */
	public String getOtherDes() {
		return otherDes;
	}

	/**
	 * @param otherDes
	 *            the otherDes to set
	 */
	public void setOtherDes(String otherDes) {
		this.otherDes = otherDes;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the tlrno
	 */
	public String getTlrno() {
		return tlrno;
	}

	/**
	 * @param tlrno
	 *            the tlrno to set
	 */
	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

	/**
	 * @return the brcode
	 */
	public String getBrcode() {
		return brcode;
	}

	/**
	 * @param brcode
	 *            the brcode to set
	 */
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	/**
	 * @return the updateState
	 */
	public String getUpdateState() {
		return updateState;
	}

	/**
	 * @param updateState
	 *            the updateState to set
	 */
	public void setUpdateState(String updateState) {
		this.updateState = updateState;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the loanPercent
	 */
	public BigDecimal getLoanPercent() {
		return loanPercent;
	}

	/**
	 * @param loanPercent
	 *            the loanPercent to set
	 */
	public void setLoanPercent(BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	/**
	 * @return the moniType
	 */
	public String getMoniType() {
		return moniType;
	}

	/**
	 * @param moniType
	 *            the moniType to set
	 */
	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	/**
	 * @return the lowPriceNew
	 */
	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	/**
	 * @param lowPriceNew
	 *            the lowPriceNew to set
	 */
	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	/**
	 * @return the bailAmount
	 */
	public BigDecimal getBailAmount() {
		return bailAmount;
	}

	/**
	 * @param bailAmount
	 *            the bailAmount to set
	 */
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	/**
	 * @return the firstBailRatio
	 */
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}

	/**
	 * @param firstBailRatio
	 *            the firstBailRatio to set
	 */
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}

	/**
	 * @return the firstBailType
	 */
	public String getFirstBailType() {
		return firstBailType;
	}

	/**
	 * @param firstBailType
	 *            the firstBailType to set
	 */
	public void setFirstBailType(String firstBailType) {
		this.firstBailType = firstBailType;
	}

	/**
	 * @return the loanWay
	 */
	public String getLoanWay() {
		return loanWay;
	}

	/**
	 * @param loanWay
	 *            the loanWay to set
	 */
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	/**
	 * @return the loanDays
	 */
	public Integer getLoanDays() {
		return loanDays;
	}

	/**
	 * @param loanDays
	 *            the loanDays to set
	 */
	public void setLoanDays(Integer loanDays) {
		this.loanDays = loanDays;
	}

	/**
	 * @return the arrivedManageMode
	 */
	public String getArrivedManageMode() {
		return arrivedManageMode;
	}

	/**
	 * @param arrivedManageMode
	 *            the arrivedManageMode to set
	 */
	public void setArrivedManageMode(String arrivedManageMode) {
		this.arrivedManageMode = arrivedManageMode;
	}

	/**
	 * @return the goodsNm
	 */
	public String getGoodsNm() {
		return goodsNm;
	}

	/**
	 * @param goodsNm
	 *            the goodsNm to set
	 */
	public void setGoodsNm(String goodsNm) {
		this.goodsNm = goodsNm;
	}

	/**
	 * @return the takeMode
	 */
	public String getTakeMode() {
		return takeMode;
	}

	/**
	 * @param takeMode
	 *            the takeMode to set
	 */
	public void setTakeMode(String takeMode) {
		this.takeMode = takeMode;
	}

	/**
	 * @return the isInsurance
	 */
	public String getIsInsurance() {
		return isInsurance;
	}

	/**
	 * @param isInsurance
	 *            the isInsurance to set
	 */
	public void setIsInsurance(String isInsurance) {
		this.isInsurance = isInsurance;
	}

	/**
	 * @return the coreCustDuty
	 */
	public String getCoreCustDuty() {
		return coreCustDuty;
	}

	/**
	 * @param coreCustDuty
	 *            the coreCustDuty to set
	 */
	public void setCoreCustDuty(String coreCustDuty) {
		this.coreCustDuty = coreCustDuty;
	}

	/**
	 * @return the mortgageManageMode
	 */
	public String getMortgageManageMode() {
		return mortgageManageMode;
	}

	/**
	 * @param mortgageManageMode
	 *            the mortgageManageMode to set
	 */
	public void setMortgageManageMode(String mortgageManageMode) {
		this.mortgageManageMode = mortgageManageMode;
	}

	/**
	 * @return the condignee
	 */
	public String getCondignee() {
		return condignee;
	}

	/**
	 * @param condignee
	 *            the condignee to set
	 */
	public void setCondignee(String condignee) {
		this.condignee = condignee;
	}

	/**
	 * @return the trasportationMode
	 */
	public String getTrasportationMode() {
		return trasportationMode;
	}

	/**
	 * @param trasportationMode
	 *            the trasportationMode to set
	 */
	public void setTrasportationMode(String trasportationMode) {
		this.trasportationMode = trasportationMode;
	}

	/**
	 * @return the deliveryPoints
	 */
	public String getDeliveryPoints() {
		return deliveryPoints;
	}

	/**
	 * @param deliveryPoints
	 *            the deliveryPoints to set
	 */
	public void setDeliveryPoints(String deliveryPoints) {
		this.deliveryPoints = deliveryPoints;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the triConventions
	 */
	public String getTriConventions() {
		return triConventions;
	}

	/**
	 * @param triConventions
	 *            the triConventions to set
	 */
	public void setTriConventions(String triConventions) {
		this.triConventions = triConventions;
	}

	/**
	 * @return the fouAddress
	 */
	public String getFouAddress() {
		return fouAddress;
	}

	/**
	 * @param fouAddress
	 *            the fouAddress to set
	 */
	public void setFouAddress(String fouAddress) {
		this.fouAddress = fouAddress;
	}

	/**
	 * @return the deliveryAmount
	 */
	public BigDecimal getDeliveryAmount() {
		return deliveryAmount;
	}

	/**
	 * @param deliveryAmount
	 *            the deliveryAmount to set
	 */
	public void setDeliveryAmount(BigDecimal deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}

	/**
	 * @return the tlrName
	 */
	public String getTlrName() {
		return tlrName;
	}

	/**
	 * @param tlrName
	 *            the tlrName to set
	 */
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	/**
	 * @return the otherCustName
	 */
	public String getOtherCustName() {
		return otherCustName;
	}

	/**
	 * @param otherCustName
	 *            the otherCustName to set
	 */
	public void setOtherCustName(String otherCustName) {
		this.otherCustName = otherCustName;
	}

	/**
	 * @return the dutyAssumeType
	 */
	public String getDutyAssumeType() {
		return dutyAssumeType;
	}

	/**
	 * @param dutyAssumeType
	 *            the dutyAssumeType to set
	 */
	public void setDutyAssumeType(String dutyAssumeType) {
		this.dutyAssumeType = dutyAssumeType;
	}

	/**
	 * @return the sellerNm
	 */
	public String getSellerNm() {
		return sellerNm;
	}

	/**
	 * @param sellerNm
	 *            the sellerNm to set
	 */
	public void setSellerNm(String sellerNm) {
		this.sellerNm = sellerNm;
	}

	/**
	 * @return the coreNm
	 */
	public String getCoreNm() {
		return coreNm;
	}

	/**
	 * @param coreNm
	 *            the coreNm to set
	 */
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}

	/**
	 * @return the fouName
	 */
	public String getFouName() {
		return fouName;
	}

	/**
	 * @param fouName
	 *            the fouName to set
	 */
	public void setFouName(String fouName) {
		this.fouName = fouName;
	}

	/**
	 * @return the inputorgname
	 */
	public String getInputorgname() {
		return inputorgname;
	}

	/**
	 * @param inputorgname
	 *            the inputorgname to set
	 */
	public void setInputorgname(String inputorgname) {
		this.inputorgname = inputorgname;
	}

	/**
	 * @return the cooperationBrcode
	 */
	public String getCooperationBrcode() {
		return cooperationBrcode;
	}

	/**
	 * @param cooperationBrcode
	 *            the cooperationBrcode to set
	 */
	public void setCooperationBrcode(String cooperationBrcode) {
		this.cooperationBrcode = cooperationBrcode;
	}

	/**
	 * @return the sellOffFlag
	 */
	public String getSellOffFlag() {
		return sellOffFlag;
	}

	/**
	 * @param sellOffFlag
	 *            the sellOffFlag to set
	 */
	public void setSellOffFlag(String sellOffFlag) {
		this.sellOffFlag = sellOffFlag;
	}

	/**
	 * @return the priceDropRate
	 */
	public BigDecimal getPriceDropRate() {
		return priceDropRate;
	}

	/**
	 * @param priceDropRate
	 *            the priceDropRate to set
	 */
	public void setPriceDropRate(BigDecimal priceDropRate) {
		this.priceDropRate = priceDropRate;
	}

	/**
	 * @return the cooperationBrcodeNm
	 */
	public String getCooperationBrcodeNm() {
		return cooperationBrcodeNm;
	}

	/**
	 * @param cooperationBrcodeNm
	 *            the cooperationBrcodeNm to set
	 */
	public void setCooperationBrcodeNm(String cooperationBrcodeNm) {
		this.cooperationBrcodeNm = cooperationBrcodeNm;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSellerBankNo() {
		return sellerBankNo;
	}

	public void setSellerBankNo(String sellerBankNo) {
		this.sellerBankNo = sellerBankNo;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public String getMoniNm() {
		return moniNm;
	}

	public void setMoniNm(String moniNm) {
		this.moniNm = moniNm;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getCircleLoanFlag() {
		return circleLoanFlag;
	}

	public void setCircleLoanFlag(String circleLoanFlag) {
		this.circleLoanFlag = circleLoanFlag;
	}

	public String getTripleProtocolType() {
		return tripleProtocolType;
	}

	public void setTripleProtocolType(String tripleProtocolType) {
		this.tripleProtocolType = tripleProtocolType;
	}

	public Long getConsignmentDays() {
		return consignmentDays;
	}

	public void setConsignmentDays(Long consignmentDays) {
		this.consignmentDays = consignmentDays;
	}

}
