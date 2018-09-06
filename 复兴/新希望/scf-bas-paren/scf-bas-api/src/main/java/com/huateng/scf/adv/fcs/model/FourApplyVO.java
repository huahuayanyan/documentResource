/**
 * 
 */
package com.huateng.scf.adv.fcs.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月20日下午2:59:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月20日下午2:59:06              新增
 *
 * </pre>
 */

public class FourApplyVO {
	
	private String appno;//审批编号
	private String appliType;
	private String dataNo;// 任务类型号
	private String debetNo;// 借据号
	private String noticeId;// 通知书id
	private String num;// 通知书编号
	private String ext1;// 拓展字段
	private String id;// 通知书
	private String loanWay;
	private String slaveContno;
	private String slaveContcode;
	private String monitorProtocolNo;
	private String protocolNo;
	private String businessno;
	private String mastContno;
	private String startDate;//出账日期
	private String endDate;//结束日期
	private String curcd;
	private String custcd;
	private String coreCustcd;// 核心厂商
	private String firstBailType;// 提货规程
	private String firName;// 质权人
	private String moniModel;// 质押监管模式
	private BigDecimal ration;// 质押率
	private BigDecimal mottgageTotAmount;// 入库押品总价值
	private BigDecimal exposureAmount;// 业务敞口金额
	private BigDecimal bailAmount;// 保证金金额
	private BigDecimal sendMortAmountSum;// 在库押品价值
	private BigDecimal amt;// 交易金额
	private BigDecimal okPrice;// 可提货金额
	private BigDecimal accountAmountSum;// 保证金及现金等价物总额
	private BigDecimal amountOut;// 累计提货金额
	private BigDecimal amount;//
	private BigDecimal lnciAmt;//借据金额
	private BigDecimal lnciBal;//借据余额
	private BigDecimal amountIn;//
	private BigDecimal amountUpOut;//
	private BigDecimal refundAmount;//
	private BigDecimal pledgeAmt;// 已到货金额
	private BigDecimal mottgageTotPrice;// 入库货物总价值
	private BigDecimal totConfirmPrice;
	private BigDecimal loanAmt;// 收款总金额
	private BigDecimal unDeliveryAmt;// 未发货金额
	private String productId;//业务品种
	private BigDecimal addBailAmount;
	private String moniCustcd;// 监管公司客户号
	private String moniType;//货押模式
	private String ebankAppno; //网银流水号
	private String channelFlag; //渠道标识
	private String debetId;//借据号
	private String fouCd;//回购商
	private BigDecimal currDeliveryAmt;//提货金额
	private String insertDate;//提货日期
	private BigDecimal firstBailRatio;//初始保证金比率
	private String limitDate;//最迟应赎完货/单日期
	private BigDecimal  openAmount;//敞口金额
	private String lnciType;//出账品种
	private String  dept;//机构
	private String  mgno;//客户经理
	private String slaveLimit;//填平敞口期限
	private BigDecimal contAmount;//合同金额
	private String brcode;//机构
	private String coreAccount;//核心厂商结算账号
	private String balanceAccount;//
	private String bailAccount;
	private BigDecimal riskamt;
	private String memo;//备注
	private String quantityCount;//对账通知书列表使用：已发货总量
	//private String amountOut;//对账通知书列表使用：已发货价值
	private String startDateStr; //对账通知书列表使用：出账日期
	//放款信息
	private BigDecimal bailPercent;// 保证金比例
	private String cname;// 出质人名称
	private String mastContcode;// 信贷合同号
	//private String mastContno; // 信贷合同号
	private String businessNo;// 业务合同号
	//private BigDecimal contAmount;// 合同金额
	private BigDecimal avaliableRiskAmt;// 信贷合同可用敞口
	private BigDecimal contRiskAmt;// 信贷合同总敞口
	//private String loanWay;// 出账方式
	private String incomeAppno;// 出账流水号，信贷系统返回
	private String appliStatusDtl;// 审批状态
	private String mastContStatus;// 信贷合同状态
	private String creditProtNo;// 额度协议流水号
	private String contStartDate; // 信贷合同生效日
	private String contEndDate; // 信贷合同到期日
	//private String protocolNo; // 监管合同号
	private String protocolCode; // 协议合同号
	private String cycle; // 额度循环标志
	private String moniName; // 监管公司名称
	private BigDecimal mortgageTotalValue; // 现货押品总价值
	private String supplyChainPdId; //产品ID
	private BigDecimal lowPriceNew;//最低控货价值
	private BigDecimal creditUseBal;//间接额度可用额度
	private String appBrcode;  //申请机构号   
	private String productName;//产品名称
	private String coreNm;//核心厂商名称
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

	public BigDecimal getAmountIn() {
		return amountIn;
	}

	public void setAmountIn(BigDecimal amountIn) {
		this.amountIn = amountIn;
	}

	public BigDecimal getAmountUpOut() {
		return amountUpOut;
	}

	public void setAmountUpOut(BigDecimal amountUpOut) {
		this.amountUpOut = amountUpOut;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAccountAmountSum() {
		return accountAmountSum;
	}

	public void setAccountAmountSum(BigDecimal accountAmountSum) {
		this.accountAmountSum = accountAmountSum;
	}

	public BigDecimal getAmountOut() {
		return amountOut;
	}

	public void setAmountOut(BigDecimal amountOut) {
		this.amountOut = amountOut;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getAppliType() {
		return appliType;
	}

	public void setAppliType(String appliType) {
		this.appliType = appliType;
	}

	public String getDataNo() {
		return dataNo;
	}

	public void setDataNo(String dataNo) {
		this.dataNo = dataNo;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	public String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}

	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}

	public String getBusinessno() {
		return businessno;
	}

	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	}

	public String getMastContno() {
		return mastContno;
	}

	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
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

	public BigDecimal getRation() {
		return ration;
	}

	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
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

	public String getFirName() {
		return firName;
	}

	public void setFirName(String firName) {
		this.firName = firName;
	}

	public String getMoniModel() {
		return moniModel;
	}

	public void setMoniModel(String moniModel) {
		this.moniModel = moniModel;
	}

	public java.math.BigDecimal getMottgageTotAmount() {
		return mottgageTotAmount;
	}

	public void setMottgageTotAmount(BigDecimal mottgageTotAmount) {
		this.mottgageTotAmount = mottgageTotAmount;
	}

	public BigDecimal getExposureAmount() {
		return exposureAmount;
	}

	public void setExposureAmount(BigDecimal exposureAmount) {
		this.exposureAmount = exposureAmount;
	}

	public BigDecimal getBailAmount() {
		return bailAmount;
	}

	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	public BigDecimal getSendMortAmountSum() {
		return sendMortAmountSum;
	}

	public void setSendMortAmountSum(BigDecimal sendMortAmountSum) {
		this.sendMortAmountSum = sendMortAmountSum;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getFirstBailType() {
		return firstBailType;
	}

	public void setFirstBailType(String firstBailType) {
		this.firstBailType = firstBailType;
	}

	public BigDecimal getOkPrice() {
		return okPrice;
	}

	public void setOkPrice(BigDecimal okPrice) {
		this.okPrice = okPrice;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public BigDecimal getPledgeAmt() {
		return pledgeAmt;
	}

	public void setPledgeAmt(BigDecimal pledgeAmt) {
		this.pledgeAmt = pledgeAmt;
	}

	public BigDecimal getMottgageTotPrice() {
		return mottgageTotPrice;
	}

	public void setMottgageTotPrice(BigDecimal mottgageTotPrice) {
		this.mottgageTotPrice = mottgageTotPrice;
	}

	public BigDecimal getTotConfirmPrice() {
		return totConfirmPrice;
	}

	public void setTotConfirmPrice(BigDecimal totConfirmPrice) {
		this.totConfirmPrice = totConfirmPrice;
	}

	public BigDecimal getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}

	public BigDecimal getUnDeliveryAmt() {
		return unDeliveryAmt;
	}

	public void setUnDeliveryAmt(BigDecimal unDeliveryAmt) {
		this.unDeliveryAmt = unDeliveryAmt;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}

	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public String getEbankAppno() {
		return ebankAppno;
	}

	public void setEbankAppno(String ebankAppno) {
		this.ebankAppno = ebankAppno;
	}

	public String getChannelFlag() {
		return channelFlag;
	}

	public void setChannelFlag(String channelFlag) {
		this.channelFlag = channelFlag;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
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

	public String getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public String getLnciType() {
		return lnciType;
	}

	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMgno() {
		return mgno;
	}

	public void setMgno(String mgno) {
		this.mgno = mgno;
	}

	public String getSlaveLimit() {
		return slaveLimit;
	}

	public void setSlaveLimit(String slaveLimit) {
		this.slaveLimit = slaveLimit;
	}

	public BigDecimal getContAmount() {
		return contAmount;
	}

	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getCoreAccount() {
		return coreAccount;
	}

	public void setCoreAccount(String coreAccount) {
		this.coreAccount = coreAccount;
	}

	public String getBalanceAccount() {
		return balanceAccount;
	}

	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}

	public String getBailAccount() {
		return bailAccount;
	}

	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}

	public BigDecimal getRiskamt() {
		return riskamt;
	}

	public void setRiskamt(BigDecimal riskamt) {
		this.riskamt = riskamt;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getQuantityCount() {
		return quantityCount;
	}

	public void setQuantityCount(String quantityCount) {
		this.quantityCount = quantityCount;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public BigDecimal getBailPercent() {
		return bailPercent;
	}

	public void setBailPercent(BigDecimal bailPercent) {
		this.bailPercent = bailPercent;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMastContcode() {
		return mastContcode;
	}

	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}

	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}

	public BigDecimal getContRiskAmt() {
		return contRiskAmt;
	}

	public void setContRiskAmt(BigDecimal contRiskAmt) {
		this.contRiskAmt = contRiskAmt;
	}

	public String getIncomeAppno() {
		return incomeAppno;
	}

	public void setIncomeAppno(String incomeAppno) {
		this.incomeAppno = incomeAppno;
	}

	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}

	public String getMastContStatus() {
		return mastContStatus;
	}

	public void setMastContStatus(String mastContStatus) {
		this.mastContStatus = mastContStatus;
	}

	public String getCreditProtNo() {
		return creditProtNo;
	}

	public void setCreditProtNo(String creditProtNo) {
		this.creditProtNo = creditProtNo;
	}

	public String getContStartDate() {
		return contStartDate;
	}

	public void setContStartDate(String contStartDate) {
		this.contStartDate = contStartDate;
	}

	public String getContEndDate() {
		return contEndDate;
	}

	public void setContEndDate(String contEndDate) {
		this.contEndDate = contEndDate;
	}

	public String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getMoniName() {
		return moniName;
	}

	public void setMoniName(String moniName) {
		this.moniName = moniName;
	}

	public BigDecimal getMortgageTotalValue() {
		return mortgageTotalValue;
	}

	public void setMortgageTotalValue(BigDecimal mortgageTotalValue) {
		this.mortgageTotalValue = mortgageTotalValue;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	public BigDecimal getCreditUseBal() {
		return creditUseBal;
	}

	public void setCreditUseBal(BigDecimal creditUseBal) {
		this.creditUseBal = creditUseBal;
	}

	public String getAppBrcode() {
		return appBrcode;
	}

	public void setAppBrcode(String appBrcode) {
		this.appBrcode = appBrcode;
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
	
}
