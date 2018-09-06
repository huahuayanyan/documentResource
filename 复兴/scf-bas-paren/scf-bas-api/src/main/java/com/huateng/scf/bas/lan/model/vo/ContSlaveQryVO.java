/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2013 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.lan.model.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 *
 * 质押合同查询VO
 *
 * @author <a href="mailto:wenkui.xu@huateng.com">wenkui.xu</a>
 *
 * @version Revision: 1.0  Date: 2013-5-14 下午01:58:28
 *
 */
public class ContSlaveQryVO extends CommonQryVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String supplyChainPdId_Q;// 供应链产品类型
	private String value;// 输入的查询条件值
	private String status_Q;// 合同状态
	private String coreCustcd_Q;// 核心厂商客户号
	private String bussType_Q;//业务类型
	private String SlaveContcode_Q;//质押合同编号
	private String moniWarehouseType;  //监管模式
	private String  moniCname_Q ;
	private String assureType_Q ;
	private String  brName_Q;
	private String  startDate1_Q ;
	private String  startDate2_Q ;

	public String getSupplyChainPdId_Q() {
		return supplyChainPdId_Q;
	}

	public void setSupplyChainPdId_Q(String supplyChainPdId_Q) {
		this.supplyChainPdId_Q = supplyChainPdId_Q;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus_Q() {
		return status_Q;
	}

	public void setStatus_Q(String status_Q) {
		this.status_Q = status_Q;
	}

	public String getCoreCustcd_Q() {
		return coreCustcd_Q;
	}

	public void setCoreCustcd_Q(String coreCustcd_Q) {
		this.coreCustcd_Q = coreCustcd_Q;
	}

	public String getBussType_Q() {
		return bussType_Q;
	}

	public void setBussType_Q(String bussType_Q) {
		this.bussType_Q = bussType_Q;
	}

	public String getSlaveContcode_Q() {
		return SlaveContcode_Q;
	}

	public void setSlaveContcode_Q(String slaveContcode_Q) {
		SlaveContcode_Q = slaveContcode_Q;
	}

	public String getMoniWarehouseType() {
		return moniWarehouseType;
	}

	public void setMoniWarehouseType(String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}

	public String getMoniCname_Q() {
		return moniCname_Q;
	}

	public void setMoniCname_Q(String moniCname_Q) {
		this.moniCname_Q = moniCname_Q;
	}

	public String getAssureType_Q() {
		return assureType_Q;
	}

	public void setAssureType_Q(String assureType_Q) {
		this.assureType_Q = assureType_Q;
	}

	public String getBrName_Q() {
		return brName_Q;
	}

	public void setBrName_Q(String brName_Q) {
		this.brName_Q = brName_Q;
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

}
