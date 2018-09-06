package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;
import java.util.Date;
/**
 * 创建日期 2007-9-29
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 控制扫描合同程序子VO</p>
 * @author pei
 * @version :2007-9-29 14:42:33
 */
public class BhLoanInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BhLoanInfoVO() {
		super();
	}

	private String contractNo; //贷款合同号
	private String brCode; //贷款支行
	private String custCd; //客户内部编码
	private String lnId; //贷款种类
	private String term; 
	private String subLnId; //贷款子类
	private double totAmt; //贷款总金额
	private String rtnType; //还款方式
	private String rtnDateType; //还款类型
	private String rtnInterval; //还款间隔
	private double lnamt; //贷款金额
	private double lnBal; //本金余额
	private double rtnAmt; //已还本金
	private double ovdAmt; //逾期金额
	private double payInt; //已还利息
	private double payPint; //已还罚息
	private double oweInt; //应收未收利息
	private double owePint; //应收未收罚息
	private String trmClass; //贷款形态
	private Date trsfDate; //结转时间
	private String clrClass; //五级分类
	private String clrMode; //五级分类方式
	private String lnActno; //贷款帐号
	private double oweBal; //拖欠本金
	private double undueBal; //未到期本金
	private String guattype;

	/**
	 * @return
	 */
	public String getBrCode() {
		return brCode;
	}

	/**
	 * @return
	 */
	public String getClrClass() {
		return clrClass;
	}

	/**
	 * @return
	 */
	public String getClrMode() {
		return clrMode;
	}

	/**
	 * @return
	 */
	public String getContractNo() {
		return contractNo;
	}

	/**
	 * @return
	 */
	public String getCustCd() {
		return custCd;
	}

	/**
	 * @return
	 */
	public String getLnActno() {
		return lnActno;
	}

	/**
	 * @return
	 */
	public double getLnamt() {
		return lnamt;
	}

	/**
	 * @return
	 */
	public double getLnBal() {
		return lnBal;
	}

	/**
	 * @return
	 */
	public String getLnId() {
		return lnId;
	}

	/**
	 * @return
	 */
	public double getOvdAmt() {
		return ovdAmt;
	}

	/**
	 * @return
	 */
	public double getOweBal() {
		return oweBal;
	}

	/**
	 * @return
	 */
	public double getOweInt() {
		return oweInt;
	}

	/**
	 * @return
	 */
	public double getOwePint() {
		return owePint;
	}

	/**
	 * @return
	 */
	public double getPayInt() {
		return payInt;
	}

	/**
	 * @return
	 */
	public double getPayPint() {
		return payPint;
	}

	/**
	 * @return
	 */
	public double getRtnAmt() {
		return rtnAmt;
	}

	/**
	 * @return
	 */
	public String getRtnInterval() {
		return rtnInterval;
	}
	
	/**
	 * @return
	 */
	public String getRtnType() {
		return rtnType;
	}

	/**
	 * @return
	 */
	public String getSubLnId() {
		return subLnId;
	}

	/**
	 * @return
	 */
	public String getTrmClass() {
		return trmClass;
	}

	/**
	 * @return
	 */
	public Date getTrsfDate() {
		return trsfDate;
	}

	/**
	 * @return
	 */
	public double getUndueBal() {
		return undueBal;
	}

	/**
	 * @param string
	 */
	public void setBrCode(String string) {
		brCode = string;
	}

	/**
	 * @param string
	 */
	public void setClrClass(String string) {
		clrClass = string;
	}

	/**
	 * @param string
	 */
	public void setClrMode(String string) {
		clrMode = string;
	}

	/**
	 * @param string
	 */
	public void setContractNo(String string) {
		contractNo = string;
	}

	/**
	 * @param string
	 */
	public void setCustCd(String string) {
		custCd = string;
	}

	/**
	 * @param string
	 */
	public void setLnActno(String string) {
		lnActno = string;
	}

	/**
	 * @param d
	 */
	public void setLnamt(double d) {
		lnamt = d;
	}

	/**
	 * @param d
	 */
	public void setLnBal(double d) {
		lnBal = d;
	}

	/**
	 * @param string
	 */
	public void setLnId(String string) {
		lnId = string;
	}
	
	/**
	 * @param d
	 */
	public void setOvdAmt(double d) {
		ovdAmt = d;
	}

	/**
	 * @param d
	 */
	public void setOweBal(double d) {
		oweBal = d;
	}

	/**
	 * @param d
	 */
	public void setOweInt(double d) {
		oweInt = d;
	}

	/**
	 * @param d
	 */
	public void setOwePint(double d) {
		owePint = d;
	}

	/**
	 * @param d
	 */
	public void setPayInt(double d) {
		payInt = d;
	}

	/**
	 * @param d
	 */
	public void setPayPint(double d) {
		payPint = d;
	}

	/**
	 * @param d
	 */
	public void setRtnAmt(double d) {
		rtnAmt = d;
	}

	/**
	 * @param string
	 */
	public void setRtnInterval(String string) {
		rtnInterval = string;
	}

	/**
	 * @param string
	 */
	public void setRtnType(String string) {
		rtnType = string;
	}

	/**
	 * @param string
	 */
	public void setSubLnId(String string) {
		subLnId = string;
	}

	/**
	 * @param string
	 */
	public void setTrmClass(String string) {
		trmClass = string;
	}

	/**
	 * @param date
	 */
	public void setTrsfDate(Date date) {
		trsfDate = date;
	}

	/**
	 * @param d
	 */
	public void setUndueBal(double d) {
		undueBal = d;
	}

	/**
	 * @return
	 */
	public double getTotAmt() {
		return totAmt;
	}

	/**
	 * @param d
	 */
	public void setTotAmt(double d) {
		totAmt = d;
	}

	/**
	 * @return
	 */
	public String getRtnDateType() {
		return rtnDateType;
	}

	/**
	 * @param string
	 */
	public void setRtnDateType(String string) {
		rtnDateType = string;
	}

	/**
	 * @return
	 */
	public String getGuattype() {
		return guattype;
	}

	/**
	 * @param string
	 */
	public void setGuattype(String string) {
		guattype = string;
	}

	/**
	 * @return
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param string
	 */
	public void setTerm(String string) {
		term = string;
	}

}