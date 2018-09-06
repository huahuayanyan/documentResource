/**
 * 
 */
package com.huateng.scf.bas.lan.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月11日下午4:18:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月11日下午4:18:34              新增
 *
 * </pre>
 */
public class MortgageLnciBaseInfoLDVO extends BLanAppliLnciBase{
	
	private String taskComment;//审批意见
	
	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	private static final long serialVersionUID = 2131323077207824358L;
	private BigDecimal bailPercent;// 保证金比例
	private String cname;// 出质人名称
	private String mastContcode;// 信贷合同号
	private String mastContno; // 信贷合同号
	private String businessNo;// 业务合同号
	private BigDecimal contAmount;// 合同金额
	private BigDecimal avaliableRiskAmt;// 信贷合同可用敞口
	private BigDecimal contRiskAmt;// 信贷合同总敞口
	private String loanWay;// 出账方式
	private String incomeAppno;// 出账流水号，信贷系统返回
	private String appliStatusDtl;// 审批状态
	private String mastContStatus;// 信贷合同状态
	private String creditProtNo;// 额度协议流水号
	private String contStartDate; // 信贷合同生效日
	private String contEndDate; // 信贷合同到期日
	private String protocolNo; // 监管合同号
	private String protocolCode; // 纸质监管合同号
	private String slaveContcode; // 业务合同号
	private String cycle; // 额度循环标志
	private BigDecimal ration; // 质押率
	private String moniCustcd; // 监管公司客户号
	private String moniName; // 监管公司名称
	private BigDecimal mortgageTotalValue; // 现货押品总价值
	private String supplyChainPdId; //产品ID
	private BigDecimal lowPriceNew;//最低控货价值
	private String hasIndirectCredit; //预付款：间接额度类型:有、无
	private BigDecimal indirectCreaditLastAmt; //预付款:间接额度余额
	private String assureCname; //预付款：担保方名称
	private BigDecimal openAmount;   // 该笔业务合同的敞口余额
	private String appBrcode;  //申请机构号 
	private String productName;  //产品名称
	/**
	 * VARCHAR(32) 必填<br>
	 * 出账流水号
	 */
	private String id;

	/**
	 * VARCHAR(40)<br>
	 * 合同流水号
	 */
	private String appId;
	/**
	 * 协议流水号
	 */
	private String vidNo;// 协议号--质押合同好
	private String appStatus;// 申请状态
	private BigDecimal totAmt;// 总敞口
	private BigDecimal lnSum;// 可用金额
	private String htsxr;// 合同生效日
	private String htdqr;// 合同到期日
	private String xh;// 是否循环
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getVidNo() {
		return vidNo;
	}

	public void setVidNo(String vidNo) {
		this.vidNo = vidNo;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public BigDecimal getTotAmt() {
		return totAmt;
	}

	public void setTotAmt(BigDecimal totAmt) {
		this.totAmt = totAmt;
	}

	public BigDecimal getLnSum() {
		return lnSum;
	}

	public void setLnSum(BigDecimal lnSum) {
		this.lnSum = lnSum;
	}

	public String getHtsxr() {
		return htsxr;
	}

	public void setHtsxr(String htsxr) {
		this.htsxr = htsxr;
	}

	public String getHtdqr() {
		return htdqr;
	}

	public void setHtdqr(String htdqr) {
		this.htdqr = htdqr;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getVidBusTyp() {
		return vidBusTyp;
	}

	public void setVidBusTyp(String vidBusTyp) {
		this.vidBusTyp = vidBusTyp;
	}

	public String getJght() {
		return jght;
	}

	public void setJght(String jght) {
		this.jght = jght;
	}

	public BigDecimal getDzyl() {
		return dzyl;
	}

	public void setDzyl(BigDecimal dzyl) {
		this.dzyl = dzyl;
	}

	public BigDecimal getZdkhjz() {
		return zdkhjz;
	}

	public void setZdkhjz(BigDecimal zdkhjz) {
		this.zdkhjz = zdkhjz;
	}

	public BigDecimal getXhypzjz() {
		return xhypzjz;
	}

	public void setXhypzjz(BigDecimal xhypzjz) {
		this.xhypzjz = xhypzjz;
	}

	public BigDecimal getKrzje() {
		return krzje;
	}

	public void setKrzje(BigDecimal krzje) {
		this.krzje = krzje;
	}

	public BigDecimal getRzbl() {
		return rzbl;
	}

	public void setRzbl(BigDecimal rzbl) {
		this.rzbl = rzbl;
	}

	public BigDecimal getBbfxck() {
		return bbfxck;
	}

	public void setBbfxck(BigDecimal bbfxck) {
		this.bbfxck = bbfxck;
	}

	public String getJggsmc() {
		return jggsmc;
	}

	public void setJggsmc(String jggsmc) {
		this.jggsmc = jggsmc;
	}

	public BigDecimal getCkye() {
		return ckye;
	}

	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}

	public BigDecimal getJjje() {
		return jjje;
	}

	public void setJjje(BigDecimal jjje) {
		this.jjje = jjje;
	}

	public String getRzzh() {
		return rzzh;
	}

	public void setRzzh(String rzzh) {
		this.rzzh = rzzh;
	}

	public String getQxrq() {
		return qxrq;
	}

	public void setQxrq(String qxrq) {
		this.qxrq = qxrq;
	}

	public String getDqrq() {
		return dqrq;
	}

	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
	}

	public String getRzjg() {
		return rzjg;
	}

	public void setRzjg(String rzjg) {
		this.rzjg = rzjg;
	}

	public String getRzjgName() {
		return rzjgName;
	}

	public void setRzjgName(String rzjgName) {
		this.rzjgName = rzjgName;
	}

	public String getHkfs() {
		return hkfs;
	}

	public void setHkfs(String hkfs) {
		this.hkfs = hkfs;
	}

	public BigDecimal getKxq() {
		return kxq;
	}

	public void setKxq(BigDecimal kxq) {
		this.kxq = kxq;
	}

	public BigDecimal getCsbzjje() {
		return csbzjje;
	}

	public void setCsbzjje(BigDecimal csbzjje) {
		this.csbzjje = csbzjje;
	}

	public BigDecimal getCsbzjbl() {
		return csbzjbl;
	}

	public void setCsbzjbl(BigDecimal csbzjbl) {
		this.csbzjbl = csbzjbl;
	}

	public BigDecimal getCsxjdjwbl() {
		return csxjdjwbl;
	}

	public void setCsxjdjwbl(BigDecimal csxjdjwbl) {
		this.csxjdjwbl = csxjdjwbl;
	}

	public String getLllx() {
		return lllx;
	}

	public void setLllx(String lllx) {
		this.lllx = lllx;
	}

	public String getLlfdfs() {
		return llfdfs;
	}

	public void setLlfdfs(String llfdfs) {
		this.llfdfs = llfdfs;
	}

	public String getFdlltzfs() {
		return fdlltzfs;
	}

	public void setFdlltzfs(String fdlltzfs) {
		this.fdlltzfs = fdlltzfs;
	}

	public BigDecimal getLlfdz() {
		return llfdz;
	}

	public void setLlfdz(BigDecimal llfdz) {
		this.llfdz = llfdz;
	}

	public BigDecimal getZxll() {
		return zxll;
	}

	public void setZxll(BigDecimal zxll) {
		this.zxll = zxll;
	}

	public String getLldm() {
		return lldm;
	}

	public void setLldm(String lldm) {
		this.lldm = lldm;
	}

	public BigDecimal getJzlv() {
		return jzlv;
	}

	public void setJzlv(BigDecimal jzlv) {
		this.jzlv = jzlv;
	}

	public String getCreditProId() {
		return creditProId;
	}

	public void setCreditProId(String creditProId) {
		this.creditProId = creditProId;
	}

	public String getCdjgh() {
		return cdjgh;
	}

	public void setCdjgh(String cdjgh) {
		this.cdjgh = cdjgh;
	}

	public String getQfjgh() {
		return qfjgh;
	}

	public void setQfjgh(String qfjgh) {
		this.qfjgh = qfjgh;
	}

	public String getSqjgh() {
		return sqjgh;
	}

	public void setSqjgh(String sqjgh) {
		this.sqjgh = sqjgh;
	}

	public String getDkjgh() {
		return dkjgh;
	}

	public void setDkjgh(String dkjgh) {
		this.dkjgh = dkjgh;
	}

	public String getCdjghName() {
		return cdjghName;
	}

	public void setCdjghName(String cdjghName) {
		this.cdjghName = cdjghName;
	}

	public String getQfjghName() {
		return qfjghName;
	}

	public void setQfjghName(String qfjghName) {
		this.qfjghName = qfjghName;
	}

	public String getSqjghName() {
		return sqjghName;
	}

	public void setSqjghName(String sqjghName) {
		this.sqjghName = sqjghName;
	}

	public String getDkjghName() {
		return dkjghName;
	}

	public void setDkjghName(String dkjghName) {
		this.dkjghName = dkjghName;
	}

	public BigDecimal getBillNum() {
		return billNum;
	}

	public void setBillNum(BigDecimal billNum) {
		this.billNum = billNum;
	}

	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}

	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}

	public BigDecimal getTotalBillsAmount() {
		return totalBillsAmount;
	}

	public void setTotalBillsAmount(BigDecimal totalBillsAmount) {
		this.totalBillsAmount = totalBillsAmount;
	}

	public BigDecimal getPoolUseableAmount() {
		return poolUseableAmount;
	}

	public void setPoolUseableAmount(BigDecimal poolUseableAmount) {
		this.poolUseableAmount = poolUseableAmount;
	}

	public BigDecimal getTotalBailAmount() {
		return totalBailAmount;
	}

	public void setTotalBailAmount(BigDecimal totalBailAmount) {
		this.totalBailAmount = totalBailAmount;
	}

	public String getBigProductId() {
		return bigProductId;
	}

	public void setBigProductId(String bigProductId) {
		this.bigProductId = bigProductId;
	}

	private String vidBusTyp;// 业务品种
	private String jght;// 监管合同号
	private BigDecimal dzyl;// 抵质押率
	private BigDecimal zdkhjz;// 最低控货价值
	private BigDecimal xhypzjz;// 现货押品总价值
	private BigDecimal krzje;// 可融资金额
	private BigDecimal rzbl;// 融资比例
	private BigDecimal bbfxck;// 本笔风险敞口
	private String jggsmc;// 监管公司名称
	private BigDecimal ckye;// 敞口余额
	private String debetNo;// 借据号
	private BigDecimal jjje;// 借据金额
	private String rzzh;// 贷款入账帐号
	private String qxrq;// 起息日期
	private String dqrq;// 到期日期
	private String rzjg;// 入账机构
	private String rzjgName;// 入账机构名称
	private String hkfs;// 还款方式
	private BigDecimal kxq;// 宽限期
	private BigDecimal csbzjje;// 初始保证金金额
	private BigDecimal csbzjbl;// 初始保证金比例
	private BigDecimal csxjdjwbl;// 初始现金等价物金额
	private String lllx;// 利率类型
	private String llfdfs;// 利率浮动方式
	private String fdlltzfs;// 浮动利率调整方式
	private BigDecimal llfdz;// 利率浮动值
	private BigDecimal zxll;// 执行利率
	private String lldm;// 利率代码
	private BigDecimal jzlv;// 基准利率
	private String creditProId;// 额度协议流水号
	// 银承
	private String cdjgh;// 承兑机构号
	private String qfjgh;// 签发机构号
	private String sqjgh;// 申请机构号
	private String dkjgh;// 垫款机构号
	private String cdjghName;// 承兑机构号名称
	private String qfjghName;// 签发机构号名称
	private String sqjghName;// 申请机构名称
	private String dkjghName;// 垫款机构号名称
	
	private BigDecimal billNum;// 出票张数
	private BigDecimal poolRiskAmt;// 池敞口余额
	private BigDecimal totalBillsAmount;// 应收账款总额
	private BigDecimal poolUseableAmount;// TBL_DEBT_POOL中可融资金额
	private BigDecimal totalBailAmount;
	private String bigProductId;
	
	
	public String getAppBrcode() {
		return appBrcode;
	}


	public void setAppBrcode(String appBrcode) {
		this.appBrcode = appBrcode;
	}


	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	

	public BigDecimal getOpenAmount() {
		return openAmount;
	}


	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}


	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
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

	public String getMastContno() {
		return mastContno;
	}

	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public BigDecimal getContAmount() {
		return contAmount;
	}

	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
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

	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}

	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
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

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public BigDecimal getRation() {
		return ration;
	}

	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
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

	public BigDecimal getContRiskAmt() {
		return contRiskAmt;
	}

	public void setContRiskAmt(BigDecimal contRiskAmt) {
		this.contRiskAmt = contRiskAmt;
	}

	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	public String getHasIndirectCredit() {
		return hasIndirectCredit;
	}

	public void setHasIndirectCredit(String hasIndirectCredit) {
		this.hasIndirectCredit = hasIndirectCredit;
	}

	public BigDecimal getIndirectCreaditLastAmt() {
		return indirectCreaditLastAmt;
	}

	public void setIndirectCreaditLastAmt(BigDecimal indirectCreaditLastAmt) {
		this.indirectCreaditLastAmt = indirectCreaditLastAmt;
	}

	public String getAssureCname() {
		return assureCname;
	}

	public void setAssureCname(String assureCname) {
		this.assureCname = assureCname;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
}
