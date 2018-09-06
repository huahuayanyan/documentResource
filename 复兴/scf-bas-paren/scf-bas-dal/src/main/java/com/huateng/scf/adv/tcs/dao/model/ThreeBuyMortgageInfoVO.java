/**
 * <p>购销合同及押品信息</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月10日下午1:16:30	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月10日下午1:16:30              新增
 *
 * </pre>
 */
package com.huateng.scf.adv.tcs.dao.model;

import java.math.BigDecimal;

public class ThreeBuyMortgageInfoVO {
	private String id;
	private String appno;//申请编号
	private String tradeContno;//购销合同编号
	private String tradeContcode;//购销合同编号
	private String applyDate;//签订日期
	private String startDate;//开始日期
	private String endDate;//合同到期日
	private BigDecimal amt;//合同金额
	private BigDecimal totAmt;//累计出账金额
	private BigDecimal currOutAmt;//本次出账金额
	private BigDecimal accuDeliAmt; //累计提货金额
	private String curcd;//币种
	private String custcd;//经销商
	private String coreCustcd;//核心厂商
	private String cname;//经销商名称
	private String coreNm;//核心厂商名称
	private String  protocolNo;//协议号
	private String productId;//产品ID
	private String  productName;
	private String costMoney;//其他费用
	private String memo;//备注
	private String debetNo;
	
	private String mortgageNo;//货物编号
	private String appliMortBizType;//申请业务押品清单业务类型
	private String mortgageName;//押品名称
	private String mortgageLevelOne;//押品一级
	private String mortgageLevelTwo;//押品二级
	private String mortgageModel;//规格/型号
	private BigDecimal quantity;//提货数量/重量
	private String mortgageUnits;//计量单位
	private BigDecimal totPrice;//提货金额
	private BigDecimal confirmPrice;//核定单价
	private BigDecimal price;//价格
	private BigDecimal sumPrice; //总价
	private String ext1;//相关凭证号
	private String countUnits;
	private BigDecimal outQuantity;//实际提货数量
	private BigDecimal originalTotPrice;//原货物总价
	private String documentNo;//提货凭证
	private String otherProtocolNo;//协议号
	
	private String mortgageLevelOneName;
	private String mortgageLevelTwoName;


	
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
	public String getTradeContno() {
		return tradeContno;
	}
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno;
	}
	public String getTradeContcode() {
		return tradeContcode;
	}
	public void setTradeContcode(String tradeContcode) {
		this.tradeContcode = tradeContcode;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public BigDecimal getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(BigDecimal totAmt) {
		this.totAmt = totAmt;
	}
	public BigDecimal getCurrOutAmt() {
		return currOutAmt;
	}
	public void setCurrOutAmt(BigDecimal currOutAmt) {
		this.currOutAmt = currOutAmt;
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
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCostMoney() {
		return costMoney;
	}
	public void setCostMoney(String costMoney) {
		this.costMoney = costMoney;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getMortgageNo() {
		return mortgageNo;
	}
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}
	public String getAppliMortBizType() {
		return appliMortBizType;
	}
	public void setAppliMortBizType(String appliMortBizType) {
		this.appliMortBizType = appliMortBizType;
	}
	public String getMortgageName() {
		return mortgageName;
	}
	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
	}
	public String getMortgageLevelOne() {
		return mortgageLevelOne;
	}
	public void setMortgageLevelOne(String mortgageLevelOne) {
		this.mortgageLevelOne = mortgageLevelOne;
	}
	public String getMortgageLevelTwo() {
		return mortgageLevelTwo;
	}
	public void setMortgageLevelTwo(String mortgageLevelTwo) {
		this.mortgageLevelTwo = mortgageLevelTwo;
	}
	public String getMortgageModel() {
		return mortgageModel;
	}
	public void setMortgageModel(String mortgageModel) {
		this.mortgageModel = mortgageModel;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getMortgageUnits() {
		return mortgageUnits;
	}
	public void setMortgageUnits(String mortgageUnits) {
		this.mortgageUnits = mortgageUnits;
	}
	public BigDecimal getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}
	public BigDecimal getConfirmPrice() {
		return confirmPrice;
	}
	public void setConfirmPrice(BigDecimal confirmPrice) {
		this.confirmPrice = confirmPrice;
	}

	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCountUnits() {
		return countUnits;
	}
	public void setCountUnits(String countUnits) {
		this.countUnits = countUnits;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public String getOtherProtocolNo() {
		return otherProtocolNo;
	}
	public void setOtherProtocolNo(String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo;
	}
	public BigDecimal getOutQuantity() {
		return outQuantity;
	}
	public void setOutQuantity(BigDecimal outQuantity) {
		this.outQuantity = outQuantity;
	}
	public BigDecimal getOriginalTotPrice() {
		return originalTotPrice;
	}
	public void setOriginalTotPrice(BigDecimal originalTotPrice) {
		this.originalTotPrice = originalTotPrice;
	}
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	/**
	 * @return the mortgageLevelOneName
	 */
	public String getMortgageLevelOneName() {
		return mortgageLevelOneName;
	}
	/**
	 * @param mortgageLevelOneName the mortgageLevelOneName to set
	 */
	public void setMortgageLevelOneName(String mortgageLevelOneName) {
		this.mortgageLevelOneName = mortgageLevelOneName;
	}
	/**
	 * @return the mortgageLevelTwoName
	 */
	public String getMortgageLevelTwoName() {
		return mortgageLevelTwoName;
	}
	/**
	 * @param mortgageLevelTwoName the mortgageLevelTwoName to set
	 */
	public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
		this.mortgageLevelTwoName = mortgageLevelTwoName;
	}
	/**
	 * @return the debetNo
	 */
	public String getDebetNo() {
		return debetNo;
	}
	/**
	 * @param debetNo the debetNo to set
	 */
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	/**
	 * @return the accuDeliAmt
	 */
	public BigDecimal getAccuDeliAmt() {
		return accuDeliAmt;
	}
	/**
	 * @param accuDeliAmt the accuDeliAmt to set
	 */
	public void setAccuDeliAmt(BigDecimal accuDeliAmt) {
		this.accuDeliAmt = accuDeliAmt;
	}
	/**
	 * @return the sumPrice
	 */
	public BigDecimal getSumPrice() {
		return sumPrice;
	}
	/**
	 * @param sumPrice the sumPrice to set
	 */
	public void setSumPrice(BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}
}
