/*
 * 功  能：简单说明该类的功能
 *
 * 文件名：ProtocolQryVO.java
 *
 * 描  述：
 *
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2013-5-9   topcheer   hjf      create
 * -----------------------------------------------------------------------------
 *
 *
 * Copyright (c) 2013 topcheer All Rights Reserved.
 *┌─────────────────────────────────────────────────—────┐
 *│ 版权声明                               topcheer      │
 *└──────────────────────────────—————————————————————───┘
 */

package com.huateng.scf.bas.mrn.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * 协议查询条件VO
 *
 * <p>
 * <a href="ProtocolQryVO.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:hjf@topcheer.com">hjf</a>
 *
 * @version Revision: 1.0 Date: 2013-5-9 下午5:00:38
 *
 */

public class ProtocolQryVO extends CommonQryVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String otherProtocolNo_Q;
	private String protocolType_Q;
	private String role_Q;//参与方角色
	private String thrCd_Q;
	private String custcdSaller_Q;
	private String productId_Q;
	private String moniCustcd_Q; //监管人客户号
	private String moniType_Q;  //监管模式
	private String startDate1_Q;
	private String startDate2_Q;
	private String supplyChainPdId_Q;
	private String state_Q;
	private String custName_Q;
	public String getMoniType_Q() {
		return moniType_Q;
	}

	public void setMoniType_Q(String moniType_Q) {
		this.moniType_Q = moniType_Q;
	}

	public String getMoniCustcd_Q() {
		return moniCustcd_Q;
	}

	public void setMoniCustcd_Q(String moniCustcd_Q) {
		this.moniCustcd_Q = moniCustcd_Q;
	}

	public String getProductId_Q() {
		return productId_Q;
	}

	public void setProductId_Q(String productId_Q) {
		this.productId_Q = productId_Q;
	}

	public ProtocolQryVO(){

	}

	public String getOtherProtocolNo_Q() {
		return otherProtocolNo_Q;
	}

	public void setOtherProtocolNo_Q(String otherProtocolNo_Q) {
		this.otherProtocolNo_Q = otherProtocolNo_Q;
	}

	public String getProtocolType_Q() {
		return protocolType_Q;
	}

	public void setProtocolType_Q(String protocolType_Q) {
		this.protocolType_Q = protocolType_Q;
	}

	public String getRole_Q() {
		return role_Q;
	}

	public void setRole_Q(String role_Q) {
		this.role_Q = role_Q;
	}

	public String getThrCd_Q() {
		return thrCd_Q;
	}

	public void setThrCd_Q(String thrCd_Q) {
		this.thrCd_Q = thrCd_Q;
	}

	public String getCustcdSaller_Q() {
		return custcdSaller_Q;
	}

	public void setCustcdSaller_Q(String custcdSaller_Q) {
		this.custcdSaller_Q = custcdSaller_Q;
	}

	public String getStartDate1_Q() {
		return startDate1_Q;
	}

	public void setStartDate1_Q(String startDate1_Q) {
		this.startDate1_Q = startDate1_Q;
	}

	public String getStartDate2_Q() {
		return startDate2_Q;
	}

	public void setStartDate2_Q(String startDate2_Q) {
		this.startDate2_Q = startDate2_Q;
	}

	public String getSupplyChainPdId_Q() {
		return supplyChainPdId_Q;
	}

	public void setSupplyChainPdId_Q(String supplyChainPdId_Q) {
		this.supplyChainPdId_Q = supplyChainPdId_Q;
	}

	public String getState_Q() {
		return state_Q;
	}

	public void setState_Q(String state_Q) {
		this.state_Q = state_Q;
	}

	public String getCustName_Q() {
		return custName_Q;
	}

	public void setCustName_Q(String custName_Q) {
		this.custName_Q = custName_Q;
	}
	
}
