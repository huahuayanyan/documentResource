package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */



/**
 *  标准仓单押品查询VO
 *
 * @author <a href="mailto:huangshan@topscf.com">huangshan</a>
 *
 * @version Revision: 1.0  Date: 2013-9-13 上午09:44:07
 *
 */

public class BillstandardMortgageQryVO extends CommonQryVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mortgageNo;
	private String billno;
	private String mortgageBizType;
	private String supplyChainPdId;
	private String secCd;
	private String thrCd;
	private String mortgageClass;
	private String mortgageClassNo;
	private String mortgageModel;
	private String monitorProtocolNo;
	private String otherProtocolNo;

	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}

	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}

	public String getOtherProtocolNo() {
		return otherProtocolNo;
	}

	public void setOtherProtocolNo(String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getSecCd() {
		return secCd;
	}

	public void setSecCd(String secCd) {
		this.secCd = secCd;
	}

	public String getThrCd() {
		return thrCd;
	}

	public void setThrCd(String thrCd) {
		this.thrCd = thrCd;
	}

	public String getMortgageClass() {
		return mortgageClass;
	}

	public void setMortgageClass(String mortgageClass) {
		this.mortgageClass = mortgageClass;
	}

	public String getMortgageClassNo() {
		return mortgageClassNo;
	}

	public void setMortgageClassNo(String mortgageClassNo) {
		this.mortgageClassNo = mortgageClassNo;
	}

	public String getMortgageModel() {
		return mortgageModel;
	}

	public void setMortgageModel(String mortgageModel) {
		this.mortgageModel = mortgageModel;
	}

	public String getMortgageBizType() {
		return mortgageBizType;
	}

	public void setMortgageBizType(String mortgageBizType) {
		this.mortgageBizType = mortgageBizType;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

}
