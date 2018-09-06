package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>三方保兑仓协议</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月22日下午4:24:51	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午4:24:51              新增
 *
 * </pre>
 */
public class ThreeProtocolVO  extends CommonQryVO implements Serializable{
	private static final long serialVersionUID = 5172307236300515578L;
	private String custcd ;
	private String balanceAccount ;
	private String bailAccount ;
	private String sellerRegAddr;
	private String sellerContactName;
	private String coreCustcd ;
	private String coreAccount;
	private String coreRegAddr  ;
	private String coreContactName ;
	private String fouCd ;
	private String refundAccount ;
	private String protocolNo;
	private String protocolCode;	
	private String protocolType;
	private String productId;
	private String otherprotocolNo;
	private String signDate;
	private String startDate;
	private String endDate;
	private String tenor;
	private String curcd;
	private BigDecimal protAmt;
	private String signIn;
	private String status;
	private String otherDes;
	private String state;
	private String tlrno;
	private String brcode;
	private String updateState;
	private String updateDate;
	private BigDecimal loanPercent;
	private String moniType;
	private BigDecimal lowPriceNew;
	private BigDecimal bailAmount;
	private BigDecimal firstBailRatio;
	private String firstBailType;
	private String loanWay;
	private Integer loanDays;
	private String arrivedManageMode;
	private String goodsNm;
	private String takeMode;
	private String isInsurance;
	private String coreCustDuty;
	private String mortgageManageMode;
	private String condignee;
	private String trasportationMode;
	private String deliveryPoints;
	private String destination;
	private String triConventions;
	private String fouAddress;
	private BigDecimal deliveryAmount;
	private String tlrName;
	private String otherCustName;
	private String dutyAssumeType;
	private String sellerNm;
	private String coreNm;
	private String fouName;
	private String inputorgname;
	private String cooperationBrcode;
	private String cooperationBrcodeNm;//合作机构名称
	private String productName;//业务品种
	
	
	public ThreeProtocolVO() {
		
	}
	public ThreeProtocolVO(String custcd, String balanceAccount, String bailAccount, String sellerRegAddr,
			String sellerContactName, String coreCustcd, String coreAccount, String coreRegAddr, String coreContactName,
			String fouCd, String refundAccount, String protocolNo, String protocolCode, String protocolType,
			String productId, String otherprotocolNo, String signDate, String startDate, String endDate, String tenor,
			String curcd, BigDecimal protAmt, String signIn, String status, String otherDes, String state, String tlrno,
			String brcode, String updateState, String updateDate, BigDecimal loanPercent, String moniType,
			BigDecimal lowPriceNew, BigDecimal bailAmount, BigDecimal firstBailRatio, String firstBailType,
			String loanWay, Integer loanDays, String arrivedManageMode, String goodsNm, String takeMode,
			String isInsurance, String coreCustDuty, String mortgageManageMode, String condignee,
			String trasportationMode, String deliveryPoints, String destination, String triConventions,
			String fouAddress, BigDecimal deliveryAmount, String tlrName, String otherCustName, String dutyAssumeType,
			String sellerNm, String coreNm, String fouName, String inputorgname, String cooperationBrcode,String productName) {
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
	 * @param custcd the custcd to set
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
	 * @param balanceAccount the balanceAccount to set
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
	 * @param bailAccount the bailAccount to set
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
	 * @param sellerRegAddr the sellerRegAddr to set
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
	 * @param sellerContactName the sellerContactName to set
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
	 * @param coreCustcd the coreCustcd to set
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
	 * @param coreAccount the coreAccount to set
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
	 * @param coreRegAddr the coreRegAddr to set
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
	 * @param coreContactName the coreContactName to set
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
	 * @param fouCd the fouCd to set
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
	 * @param refundAccount the refundAccount to set
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
	 * @param protocolNo the protocolNo to set
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
	 * @param protocolCode the protocolCode to set
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
	 * @param protocolType the protocolType to set
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
	 * @param productId the productId to set
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
	 * @param otherprotocolNo the otherprotocolNo to set
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
	 * @param signDate the signDate to set
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
	 * @param startDate the startDate to set
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
	 * @param endDate the endDate to set
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
	 * @param tenor the tenor to set
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
	 * @param curcd the curcd to set
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
	 * @param protAmt the protAmt to set
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
	 * @param signIn the signIn to set
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
	 * @param status the status to set
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
	 * @param otherDes the otherDes to set
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
	 * @param state the state to set
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
	 * @param tlrno the tlrno to set
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
	 * @param brcode the brcode to set
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
	 * @param updateState the updateState to set
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
	 * @param updateDate the updateDate to set
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
	 * @param loanPercent the loanPercent to set
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
	 * @param moniType the moniType to set
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
	 * @param lowPriceNew the lowPriceNew to set
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
	 * @param bailAmount the bailAmount to set
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
	 * @param firstBailRatio the firstBailRatio to set
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
	 * @param firstBailType the firstBailType to set
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
	 * @param loanWay the loanWay to set
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
	 * @param loanDays the loanDays to set
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
	 * @param arrivedManageMode the arrivedManageMode to set
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
	 * @param goodsNm the goodsNm to set
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
	 * @param takeMode the takeMode to set
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
	 * @param isInsurance the isInsurance to set
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
	 * @param coreCustDuty the coreCustDuty to set
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
	 * @param mortgageManageMode the mortgageManageMode to set
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
	 * @param condignee the condignee to set
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
	 * @param trasportationMode the trasportationMode to set
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
	 * @param deliveryPoints the deliveryPoints to set
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
	 * @param destination the destination to set
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
	 * @param triConventions the triConventions to set
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
	 * @param fouAddress the fouAddress to set
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
	 * @param deliveryAmount the deliveryAmount to set
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
	 * @param tlrName the tlrName to set
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
	 * @param otherCustName the otherCustName to set
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
	 * @param dutyAssumeType the dutyAssumeType to set
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
	 * @param sellerNm the sellerNm to set
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
	 * @param coreNm the coreNm to set
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
	 * @param fouName the fouName to set
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
	 * @param inputorgname the inputorgname to set
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
	 * @param cooperationBrcode the cooperationBrcode to set
	 */
	public void setCooperationBrcode(String cooperationBrcode) {
		this.cooperationBrcode = cooperationBrcode;
	}
	/**
	 * @return the cooperationBrcodeNm
	 */
	public String getCooperationBrcodeNm() {
		return cooperationBrcodeNm;
	}
	/**
	 * @param cooperationBrcodeNm the cooperationBrcodeNm to set
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
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
