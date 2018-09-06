package com.huateng.scf.bas.crr.model;

import java.math.BigDecimal;

/**
 * 
 * <p>
 * BCrrDuebillApp实体类
 * </p>
 *
 * @author liph
 * @date 2016年12月22日上午9:36:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月22日上午9:36:31	     新增
 *
 *            </pre>
 */
public class BCrrDueBillDetail {
	private static final long serialVersionUID = 1L;

	/**
	 * 审批意见
	 */
	private String taskComment;
	
	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

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
	private String loanWay;// 出账方式
	private String xh;// 是否循环
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
	/**
	 * VARCHAR(3)<br>
	 * 申请状态
	 */
	private String appStat;

	/**
	 * VARCHAR(40)<br>
	 * 贷款账号/结算帐号
	 */
	private String lnNo;

	/**
	 * VARCHAR(20)<br>
	 * 客户号
	 */
	private String custCd;

	/**
	 * VARCHAR(60) 必填<br>
	 * 客户名称
	 */
	private String custNm;

	/**
	 * VARCHAR(20)<br>
	 * 账务机构
	 */
	private String actBrCd;

	/**
	 * VARCHAR(6)<br>
	 * 产品编号
	 */
	private String prdId;

	/**
	 * VARCHAR(60) 必填<br>
	 * 产品名称
	 */
	private String prdNm;

	/**
	 * VARCHAR(10)<br>
	 * 放款日期
	 */
	private String isDt;

	/**
	 * VARCHAR(10)<br>
	 * 到期日期
	 */
	private String teDt;

	/**
	 * VARCHAR(10)<br>
	 * 期限控制方式
	 */
	private String trmCtlTyp;

	/**
	 * VARCHAR(20)<br>
	 * 贷款期限
	 */
	private String trm;

	/**
	 * DECIMAL(22)<br>
	 * 期限年
	 */
	private BigDecimal trmYear;

	/**
	 * DECIMAL(22)<br>
	 * 期限月
	 */
	private BigDecimal trmMon;

	/**
	 * DECIMAL(22)<br>
	 * 期限日
	 */
	private BigDecimal trmDay;

	/**
	 * VARCHAR(10)<br>
	 * 期限范围
	 */
	private String trmRge;

	/**
	 * DECIMAL(22) 默认值[0]<br>
	 * 当前已还期数
	 */
	private BigDecimal perAdjEql;

	/**
	 * DECIMAL(15,2) 默认值[0]<br>
	 * 贷款金额
	 */
	private BigDecimal lnAmt;

	/**
	 * VARCHAR(10)<br>
	 * 还款方式
	 */
	private String rtnTyp;

	/**
	 * VARCHAR(10)<br>
	 * 还款间隔
	 */
	private String rtnInvl;

	/**
	 * VARCHAR(10)<br>
	 * 计息周期
	 */
	private String rtnIntInvl;

	/**
	 * DECIMAL(22) 默认值[0]<br>
	 * 固定周期
	 */
	private BigDecimal rtnPd;

	/**
	 * VARCHAR(10)<br>
	 * 不等额方式
	 */
	private String nonEqlMd;

	/**
	 * DECIMAL(15,2) 默认值[0]<br>
	 * 不等额方式金额
	 */
	private BigDecimal nonEqlAmt;

	/**
	 * VARCHAR(10)<br>
	 * 还款途径
	 */
	private String rtnMd;

	/**
	 * VARCHAR(20)<br>
	 * 还款卡号
	 */
	private String rtnNo;

	/**
	 * VARCHAR(20)<br>
	 * 还款账号
	 */
	private String rtnActNo;

	/**
	 * VARCHAR(10)<br>
	 * 还款日确定方式
	 */
	private String rtnDtTyp;

	/**
	 * CHAR(2)<br>
	 * 还款日
	 */
	private String rtnDt;

	/**
	 * VARCHAR(10)<br>
	 * 是否分阶段标志
	 */
	private String phsFlg;

	/**
	 * DECIMAL(22) 默认值[0]<br>
	 * 阶段数
	 */
	private BigDecimal phsNo;

	/**
	 * VARCHAR(10)<br>
	 * 利率调整方式
	 */
	private String intAdj;

	/**
	 * VARCHAR(10)<br>
	 * 利率调整日期
	 */
	private String intAdjDt;

	/**
	 * CHAR(4)<br>
	 * 利率代码
	 */
	private String intCd;

	/**
	 * DECIMAL(8,6) 默认值[0]<br>
	 * 基准利率
	 */
	private BigDecimal basInt;

	/**
	 * VARCHAR(10)<br>
	 * 利率确定日期
	 */
	private String ratDt;

	/**
	 * DECIMAL(7,4) 默认值[0]<br>
	 * 利率浮动
	 */
	private BigDecimal fltInt;

	/**
	 * DECIMAL(8,6) 默认值[0]<br>
	 * 利率浮动值
	 */
	private BigDecimal fltIntVal;

	/**
	 * DECIMAL(8,6) 默认值[0]<br>
	 * 执行利率
	 */
	private BigDecimal actInt;

	/**
	 * VARCHAR(10)<br>
	 * 罚息浮动选项
	 */
	private String pfltIntOpt;

	/**
	 * CHAR(4)<br>
	 * 罚息利率代码
	 */
	private String pfltCd;

	/**
	 * DECIMAL(7,4) 默认值[0]<br>
	 * 罚息浮动率
	 */
	private BigDecimal pfltFlt;

	/**
	 * DECIMAL(8,6) 默认值[0]<br>
	 * 罚息利率
	 */
	private BigDecimal pfltInt;

	/**
	 * VARCHAR(10)<br>
	 * 挪用罚息浮动选项
	 */
	private String mispPfltOpt;

	/**
	 * CHAR(4)<br>
	 * 挪用罚息利率代码
	 */
	private String mispPfltCd;

	/**
	 * DECIMAL(22,4) 默认值[0]<br>
	 * 挪用罚息浮动率
	 */
	private BigDecimal mispPfltFlt;

	/**
	 * DECIMAL(22,6) 默认值[0]<br>
	 * 挪用罚息利率
	 */
	private BigDecimal mispPfltInt;

	/**
	 * VARCHAR(10)<br>
	 * 逾期计息方式
	 */
	private String ovdRatTyp;

	/**
	 * VARCHAR(10)<br>
	 * 计复息标志
	 */
	private String isComint;

	/**
	 * VARCHAR(10)<br>
	 * 放款方向
	 */
	private String payDrct;

	/**
	 * VARCHAR(10)<br>
	 * 放款途径
	 */
	private String payMd;

	/**
	 * VARCHAR(20)<br>
	 * 放款卡号
	 */
	private String payCdNo;

	/**
	 * VARCHAR(20)<br>
	 * 放款账号
	 */
	private String payActNo;

	/**
	 * VARCHAR(10)<br>
	 * 保证金账号
	 */
	private String bailActNo;

	/**
	 * DECIMAL(5,2) 默认值[0]<br>
	 * 保证金比例
	 */
	private BigDecimal bailRat;

	/**
	 * DECIMAL(15,2) 默认值[0]<br>
	 * 保证金金额
	 */
	private BigDecimal bailAmt;

	/**
	 * VARCHAR(256)<br>
	 * 手续费收取方式
	 */
	private String feeTyp;

	/**
	 * DECIMAL(15,2) 默认值[0]<br>
	 * 手续费
	 */
	private BigDecimal feeAmt;

	/**
	 * DECIMAL(5,2) 默认值[0]<br>
	 * 手续费比例
	 */
	private BigDecimal feeRat;

	/**
	 * VARCHAR(5)<br>
	 * 手续费收取周期
	 */
	private String feePd;

	/**
	 * VARCHAR(20)<br>
	 * 还款卡号2
	 */
	private String rtnNo2;

	/**
	 * VARCHAR(10)<br>
	 * 利率浮动方式
	 */
	private String intFltTyp;

	/**
	 * VARCHAR(10)<br>
	 * 罚息收取方式
	 */
	private String pfltIntMd;

	/**
	 * DECIMAL(15,2) 默认值[0]<br>
	 * 罚金金额
	 */
	private BigDecimal pfltIntAmt;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * VARCHAR(32)<br>
	 * 出票人帐号
	 */
	private String wrtNo;

	/**
	 * CHAR(1)<br>
	 * 占用额度模式
	 */
	private String crMdl;

	/**
	 * DECIMAL(16,2)<br>
	 * 使用额度金额
	 */
	private BigDecimal crAmt;

	/**
	 * VARCHAR(32)<br>
	 * 额度编号
	 */
	private String crNo;

	/**
	 * VARCHAR(32)<br>
	 * 授信额度协议编号
	 */
	private String bcCrId;

	/**
	 * VARCHAR(32)<br>
	 * 登记人
	 */
	private String tlrNo;

	/**
	 * VARCHAR(60)<br>
	 * 登记人姓名
	 */
	private String tlrNm;

	/**
	 * VARCHAR(20)<br>
	 * 机构号
	 */
	private String brCd;

	/**
	 * VARCHAR(60)<br>
	 * 登记机构名称
	 */
	private String brNm;

	/**
	 * VARCHAR(20)<br>
	 * 登记时间
	 */
	private String inpDt;

	/**
	 * VARCHAR(20)<br>
	 * 最后更新操作员号
	 */
	private String lstUpdTlr;

	/**
	 * VARCHAR(60)<br>
	 * 更新人名称
	 */
	private String lstUpdTlrNm;

	/**
	 * VARCHAR(32)<br>
	 * 更新机构
	 */
	private String lstUpdBrCd;

	/**
	 * VARCHAR(60)<br>
	 * 更新机构名称
	 */
	private String lstUpdBrNm;

	/**
	 * VARCHAR(20)<br>
	 * 最后更新时间
	 */
	private String lstUpdDt;

	/**
	 * VARCHAR(10)<br>
	 * 间接额度类型
	 */
	private String indrctCrdt;

	/**
	 * VARCHAR(60)<br>
	 * 间接额度占用客户号
	 */
	private String crdtCustCd;

	/**
	 * VARCHAR(32)<br>
	 * 间接额度占用客户名
	 */
	private String crdtCustNm;

	/**
	 * CHAR(1)<br>
	 * 是否显示供应链标志
	 */
	private String flag;
	/**
	 * 应收账款总额
	 */
	private BigDecimal ysTotalAmt;
	/**
	 * 赎货期限
	 */
	private BigDecimal drawbackTerm;

	/**
	 * 有效间接额度可用余额
	 */
	private BigDecimal creditBalAmt;

	/**
	 * 买方名称
	 */
	private String cname;
	private String name;

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

	public String getAppStat() {
		return appStat;
	}

	public void setAppStat(String appStat) {
		this.appStat = appStat;
	}

	public String getLnNo() {
		return lnNo;
	}

	public void setLnNo(String lnNo) {
		this.lnNo = lnNo;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getActBrCd() {
		return actBrCd;
	}

	public void setActBrCd(String actBrCd) {
		this.actBrCd = actBrCd;
	}

	public String getPrdId() {
		return prdId;
	}

	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}

	public String getPrdNm() {
		return prdNm;
	}

	public void setPrdNm(String prdNm) {
		this.prdNm = prdNm;
	}

	public String getIsDt() {
		return isDt;
	}

	public void setIsDt(String isDt) {
		this.isDt = isDt;
	}

	public String getTeDt() {
		return teDt;
	}

	public void setTeDt(String teDt) {
		this.teDt = teDt;
	}

	public String getTrmCtlTyp() {
		return trmCtlTyp;
	}

	public void setTrmCtlTyp(String trmCtlTyp) {
		this.trmCtlTyp = trmCtlTyp;
	}

	public String getTrm() {
		return trm;
	}

	public void setTrm(String trm) {
		this.trm = trm;
	}

	public BigDecimal getTrmYear() {
		return trmYear;
	}

	public void setTrmYear(BigDecimal trmYear) {
		this.trmYear = trmYear;
	}

	public BigDecimal getTrmMon() {
		return trmMon;
	}

	public void setTrmMon(BigDecimal trmMon) {
		this.trmMon = trmMon;
	}

	public BigDecimal getTrmDay() {
		return trmDay;
	}

	public void setTrmDay(BigDecimal trmDay) {
		this.trmDay = trmDay;
	}

	public String getTrmRge() {
		return trmRge;
	}

	public void setTrmRge(String trmRge) {
		this.trmRge = trmRge;
	}

	public BigDecimal getPerAdjEql() {
		return perAdjEql;
	}

	public void setPerAdjEql(BigDecimal perAdjEql) {
		this.perAdjEql = perAdjEql;
	}

	public BigDecimal getLnAmt() {
		return lnAmt;
	}

	public void setLnAmt(BigDecimal lnAmt) {
		this.lnAmt = lnAmt;
	}

	public String getRtnTyp() {
		return rtnTyp;
	}

	public void setRtnTyp(String rtnTyp) {
		this.rtnTyp = rtnTyp;
	}

	public String getRtnInvl() {
		return rtnInvl;
	}

	public void setRtnInvl(String rtnInvl) {
		this.rtnInvl = rtnInvl;
	}

	public String getRtnIntInvl() {
		return rtnIntInvl;
	}

	public void setRtnIntInvl(String rtnIntInvl) {
		this.rtnIntInvl = rtnIntInvl;
	}

	public BigDecimal getRtnPd() {
		return rtnPd;
	}

	public void setRtnPd(BigDecimal rtnPd) {
		this.rtnPd = rtnPd;
	}

	public String getNonEqlMd() {
		return nonEqlMd;
	}

	public void setNonEqlMd(String nonEqlMd) {
		this.nonEqlMd = nonEqlMd;
	}

	public BigDecimal getNonEqlAmt() {
		return nonEqlAmt;
	}

	public void setNonEqlAmt(BigDecimal nonEqlAmt) {
		this.nonEqlAmt = nonEqlAmt;
	}

	public String getRtnMd() {
		return rtnMd;
	}

	public void setRtnMd(String rtnMd) {
		this.rtnMd = rtnMd;
	}

	public String getRtnNo() {
		return rtnNo;
	}

	public void setRtnNo(String rtnNo) {
		this.rtnNo = rtnNo;
	}

	public String getRtnActNo() {
		return rtnActNo;
	}

	public void setRtnActNo(String rtnActNo) {
		this.rtnActNo = rtnActNo;
	}

	public String getRtnDtTyp() {
		return rtnDtTyp;
	}

	public void setRtnDtTyp(String rtnDtTyp) {
		this.rtnDtTyp = rtnDtTyp;
	}

	public String getRtnDt() {
		return rtnDt;
	}

	public void setRtnDt(String rtnDt) {
		this.rtnDt = rtnDt;
	}

	public String getPhsFlg() {
		return phsFlg;
	}

	public void setPhsFlg(String phsFlg) {
		this.phsFlg = phsFlg;
	}

	public BigDecimal getPhsNo() {
		return phsNo;
	}

	public void setPhsNo(BigDecimal phsNo) {
		this.phsNo = phsNo;
	}

	public String getIntAdj() {
		return intAdj;
	}

	public void setIntAdj(String intAdj) {
		this.intAdj = intAdj;
	}

	public String getIntAdjDt() {
		return intAdjDt;
	}

	public void setIntAdjDt(String intAdjDt) {
		this.intAdjDt = intAdjDt;
	}

	public String getIntCd() {
		return intCd;
	}

	public void setIntCd(String intCd) {
		this.intCd = intCd;
	}

	public BigDecimal getBasInt() {
		return basInt;
	}

	public void setBasInt(BigDecimal basInt) {
		this.basInt = basInt;
	}

	public String getRatDt() {
		return ratDt;
	}

	public void setRatDt(String ratDt) {
		this.ratDt = ratDt;
	}

	public BigDecimal getFltInt() {
		return fltInt;
	}

	public void setFltInt(BigDecimal fltInt) {
		this.fltInt = fltInt;
	}

	public BigDecimal getFltIntVal() {
		return fltIntVal;
	}

	public void setFltIntVal(BigDecimal fltIntVal) {
		this.fltIntVal = fltIntVal;
	}

	public BigDecimal getActInt() {
		return actInt;
	}

	public void setActInt(BigDecimal actInt) {
		this.actInt = actInt;
	}

	public String getPfltIntOpt() {
		return pfltIntOpt;
	}

	public void setPfltIntOpt(String pfltIntOpt) {
		this.pfltIntOpt = pfltIntOpt;
	}

	public String getPfltCd() {
		return pfltCd;
	}

	public void setPfltCd(String pfltCd) {
		this.pfltCd = pfltCd;
	}

	public BigDecimal getPfltFlt() {
		return pfltFlt;
	}

	public void setPfltFlt(BigDecimal pfltFlt) {
		this.pfltFlt = pfltFlt;
	}

	public BigDecimal getPfltInt() {
		return pfltInt;
	}

	public void setPfltInt(BigDecimal pfltInt) {
		this.pfltInt = pfltInt;
	}

	public String getMispPfltOpt() {
		return mispPfltOpt;
	}

	public void setMispPfltOpt(String mispPfltOpt) {
		this.mispPfltOpt = mispPfltOpt;
	}

	public String getMispPfltCd() {
		return mispPfltCd;
	}

	public void setMispPfltCd(String mispPfltCd) {
		this.mispPfltCd = mispPfltCd;
	}

	public BigDecimal getMispPfltFlt() {
		return mispPfltFlt;
	}

	public void setMispPfltFlt(BigDecimal mispPfltFlt) {
		this.mispPfltFlt = mispPfltFlt;
	}

	public BigDecimal getMispPfltInt() {
		return mispPfltInt;
	}

	public void setMispPfltInt(BigDecimal mispPfltInt) {
		this.mispPfltInt = mispPfltInt;
	}

	public String getOvdRatTyp() {
		return ovdRatTyp;
	}

	public void setOvdRatTyp(String ovdRatTyp) {
		this.ovdRatTyp = ovdRatTyp;
	}

	public String getIsComint() {
		return isComint;
	}

	public void setIsComint(String isComint) {
		this.isComint = isComint;
	}

	public String getPayDrct() {
		return payDrct;
	}

	public void setPayDrct(String payDrct) {
		this.payDrct = payDrct;
	}

	public String getPayMd() {
		return payMd;
	}

	public void setPayMd(String payMd) {
		this.payMd = payMd;
	}

	public String getPayCdNo() {
		return payCdNo;
	}

	public void setPayCdNo(String payCdNo) {
		this.payCdNo = payCdNo;
	}

	public String getPayActNo() {
		return payActNo;
	}

	public void setPayActNo(String payActNo) {
		this.payActNo = payActNo;
	}

	public String getBailActNo() {
		return bailActNo;
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

	public void setBailActNo(String bailActNo) {
		this.bailActNo = bailActNo;
	}

	public BigDecimal getBailRat() {
		return bailRat;
	}

	public void setBailRat(BigDecimal bailRat) {
		this.bailRat = bailRat;
	}

	public BigDecimal getBailAmt() {
		return bailAmt;
	}

	public void setBailAmt(BigDecimal bailAmt) {
		this.bailAmt = bailAmt;
	}

	public String getFeeTyp() {
		return feeTyp;
	}

	public void setFeeTyp(String feeTyp) {
		this.feeTyp = feeTyp;
	}

	public BigDecimal getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}

	public BigDecimal getFeeRat() {
		return feeRat;
	}

	public void setFeeRat(BigDecimal feeRat) {
		this.feeRat = feeRat;
	}

	public String getFeePd() {
		return feePd;
	}

	public void setFeePd(String feePd) {
		this.feePd = feePd;
	}

	public String getRtnNo2() {
		return rtnNo2;
	}

	public void setRtnNo2(String rtnNo2) {
		this.rtnNo2 = rtnNo2;
	}

	public String getIntFltTyp() {
		return intFltTyp;
	}

	public void setIntFltTyp(String intFltTyp) {
		this.intFltTyp = intFltTyp;
	}

	public String getPfltIntMd() {
		return pfltIntMd;
	}

	public void setPfltIntMd(String pfltIntMd) {
		this.pfltIntMd = pfltIntMd;
	}

	public BigDecimal getPfltIntAmt() {
		return pfltIntAmt;
	}

	public void setPfltIntAmt(BigDecimal pfltIntAmt) {
		this.pfltIntAmt = pfltIntAmt;
	}

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	public String getWrtNo() {
		return wrtNo;
	}

	public void setWrtNo(String wrtNo) {
		this.wrtNo = wrtNo;
	}

	public String getCrMdl() {
		return crMdl;
	}

	public void setCrMdl(String crMdl) {
		this.crMdl = crMdl;
	}

	public BigDecimal getCrAmt() {
		return crAmt;
	}

	public void setCrAmt(BigDecimal crAmt) {
		this.crAmt = crAmt;
	}

	public String getCrNo() {
		return crNo;
	}

	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	public String getBcCrId() {
		return bcCrId;
	}

	public void setBcCrId(String bcCrId) {
		this.bcCrId = bcCrId;
	}

	public String getTlrNo() {
		return tlrNo;
	}

	public void setTlrNo(String tlrNo) {
		this.tlrNo = tlrNo;
	}

	public String getTlrNm() {
		return tlrNm;
	}

	public void setTlrNm(String tlrNm) {
		this.tlrNm = tlrNm;
	}

	public String getBrCd() {
		return brCd;
	}

	public void setBrCd(String brCd) {
		this.brCd = brCd;
	}

	public String getBrNm() {
		return brNm;
	}

	public void setBrNm(String brNm) {
		this.brNm = brNm;
	}

	public String getInpDt() {
		return inpDt;
	}

	public void setInpDt(String inpDt) {
		this.inpDt = inpDt;
	}

	public String getLstUpdTlr() {
		return lstUpdTlr;
	}

	public void setLstUpdTlr(String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}

	public String getLstUpdTlrNm() {
		return lstUpdTlrNm;
	}

	public void setLstUpdTlrNm(String lstUpdTlrNm) {
		this.lstUpdTlrNm = lstUpdTlrNm;
	}

	public String getLstUpdBrCd() {
		return lstUpdBrCd;
	}

	public void setLstUpdBrCd(String lstUpdBrCd) {
		this.lstUpdBrCd = lstUpdBrCd;
	}

	public String getLstUpdBrNm() {
		return lstUpdBrNm;
	}

	public void setLstUpdBrNm(String lstUpdBrNm) {
		this.lstUpdBrNm = lstUpdBrNm;
	}

	public String getLstUpdDt() {
		return lstUpdDt;
	}

	public void setLstUpdDt(String lstUpdDt) {
		this.lstUpdDt = lstUpdDt;
	}

	public String getIndrctCrdt() {
		return indrctCrdt;
	}

	public void setIndrctCrdt(String indrctCrdt) {
		this.indrctCrdt = indrctCrdt;
	}

	public String getCrdtCustCd() {
		return crdtCustCd;
	}

	public void setCrdtCustCd(String crdtCustCd) {
		this.crdtCustCd = crdtCustCd;
	}

	public String getCrdtCustNm() {
		return crdtCustNm;
	}

	public void setCrdtCustNm(String crdtCustNm) {
		this.crdtCustNm = crdtCustNm;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public BigDecimal getDrawbackTerm() {
		return drawbackTerm;
	}

	public void setDrawbackTerm(BigDecimal drawbackTerm) {
		this.drawbackTerm = drawbackTerm;
	}

	public BigDecimal getCreditBalAmt() {
		return creditBalAmt;
	}

	public void setCreditBalAmt(BigDecimal creditBalAmt) {
		this.creditBalAmt = creditBalAmt;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getYsTotalAmt() {
		return ysTotalAmt;
	}

	public void setYsTotalAmt(BigDecimal ysTotalAmt) {
		this.ysTotalAmt = ysTotalAmt;
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

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
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

	public String getJggsmc() {
		return jggsmc;
	}

	public void setJggsmc(String jggsmc) {
		this.jggsmc = jggsmc;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
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

	public BigDecimal getBbfxck() {
		return bbfxck;
	}

	public void setBbfxck(BigDecimal bbfxck) {
		this.bbfxck = bbfxck;
	}

	public BigDecimal getCkye() {
		return ckye;
	}

	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
	}

	public BigDecimal getJjje() {
		return jjje;
	}

	public void setJjje(BigDecimal jjje) {
		this.jjje = jjje;
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

	public String getFdlltzfs() {
		return fdlltzfs;
	}

	public void setFdlltzfs(String fdlltzfs) {
		this.fdlltzfs = fdlltzfs;
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

	public BigDecimal getBillNum() {
		return billNum;
	}

	public void setBillNum(BigDecimal billNum) {
		this.billNum = billNum;
	}

	public String getCreditProId() {
		return creditProId;
	}

	public void setCreditProId(String creditProId) {
		this.creditProId = creditProId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRzbl() {
		return rzbl;
	}

	public void setRzbl(BigDecimal rzbl) {
		this.rzbl = rzbl;
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

	public String getRzzh() {
		return rzzh;
	}

	public void setRzzh(String rzzh) {
		this.rzzh = rzzh;
	}

	/**
	 * @return the sqjghName
	 */
	public String getSqjghName() {
		return sqjghName;
	}

	/**
	 * @param sqjghName the sqjghName to set
	 */
	public void setSqjghName(String sqjghName) {
		this.sqjghName = sqjghName;
	}

	/**
	 * @return the dkjghName
	 */
	public String getDkjghName() {
		return dkjghName;
	}

	/**
	 * @param dkjghName the dkjghName to set
	 */
	public void setDkjghName(String dkjghName) {
		this.dkjghName = dkjghName;
	}

	/**
	 * @return the cdjghName
	 */
	public String getCdjghName() {
		return cdjghName;
	}

	/**
	 * @param cdjghName the cdjghName to set
	 */
	public void setCdjghName(String cdjghName) {
		this.cdjghName = cdjghName;
	}

	/**
	 * @return the qfjghName
	 */
	public String getQfjghName() {
		return qfjghName;
	}

	/**
	 * @param qfjghName the qfjghName to set
	 */
	public void setQfjghName(String qfjghName) {
		this.qfjghName = qfjghName;
	}

}
