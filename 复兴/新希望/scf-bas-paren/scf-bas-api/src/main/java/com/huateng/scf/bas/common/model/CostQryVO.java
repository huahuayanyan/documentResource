/*
 * 功  能：
 * 文件名：CostVO.java
 * 描  述：
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2012-6-6    huateng        huang_jianfeng          create
 * -----------------------------------------------------------------------------
 * Copyright (c) 2010 huateng  All Rights Reserved.
 */
package com.huateng.scf.bas.common.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * 类功能：
 * <p>
 * <a href="CostVO.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:Zhongxin-Cao@huateng.com">huangjianfeng</a>
 * @version Revision: 1.0 Date: 2012-6-6
 * 
 */
public class CostQryVO extends CommonQryVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.String id_Q;
	private java.lang.String appno_Q;
	private java.lang.String costCode_Q;
	private java.lang.String costName_Q;
	private java.lang.String costPhase_Q;
	private java.lang.String productId_Q;
	private java.lang.String costInfoId_Q;
	private java.lang.String applyType_Q;
	private java.lang.String bussType_Q;
	private java.lang.String chargeType_Q;
	private java.lang.String status_Q;
	private java.util.Date beginDate_Q;
	private java.util.Date endDate_Q;
	private java.util.Date commonDate_Q;
	private java.util.Date commonDate_from_Q;
	private java.util.Date commonDate_to_Q;
	private String chargeClass_Q;

	public CostQryVO() {
		super();
	}

	public java.lang.String getId_Q() {
		return id_Q;
	}

	public void setId_Q(java.lang.String id_Q) {
		this.id_Q = id_Q;
	}

	public java.lang.String getCostCode_Q() {
		return costCode_Q;
	}

	public void setCostCode_Q(java.lang.String costCode_Q) {
		this.costCode_Q = costCode_Q;
	}

	public java.lang.String getCostName_Q() {
		return costName_Q;
	}

	public void setCostName_Q(java.lang.String costName_Q) {
		this.costName_Q = costName_Q;
	}

	public java.lang.String getProductId_Q() {
		return productId_Q;
	}

	public void setProductId_Q(java.lang.String productId_Q) {
		this.productId_Q = productId_Q;
	}

	public java.lang.String getCostPhase_Q() {
		return costPhase_Q;
	}

	public void setCostPhase_Q(java.lang.String costPhase_Q) {
		this.costPhase_Q = costPhase_Q;
	}

	public java.lang.String getAppno_Q() {
		return appno_Q;
	}

	public void setAppno_Q(java.lang.String appno_Q) {
		this.appno_Q = appno_Q;
	}

	public java.lang.String getCostInfoId_Q() {
		return costInfoId_Q;
	}

	public void setCostInfoId_Q(java.lang.String costInfoId_Q) {
		this.costInfoId_Q = costInfoId_Q;
	}

	public java.lang.String getApplyType_Q() {
		return applyType_Q;
	}

	public void setApplyType_Q(java.lang.String applyType_Q) {
		this.applyType_Q = applyType_Q;
	}

	public java.lang.String getBussType_Q() {
		return bussType_Q;
	}

	public void setBussType_Q(java.lang.String bussType_Q) {
		this.bussType_Q = bussType_Q;
	}

	public java.lang.String getChargeType_Q() {
		return chargeType_Q;
	}

	public void setChargeType_Q(java.lang.String chargeType_Q) {
		this.chargeType_Q = chargeType_Q;
	}

	public java.lang.String getStatus_Q() {
		return status_Q;
	}

	public void setStatus_Q(java.lang.String status_Q) {
		this.status_Q = status_Q;
	}

	public java.util.Date getBeginDate_Q() {
		return beginDate_Q;
	}

	public void setBeginDate_Q(java.util.Date beginDate_Q) {
		this.beginDate_Q = beginDate_Q;
	}

	public java.util.Date getEndDate_Q() {
		return endDate_Q;
	}

	public void setEndDate_Q(java.util.Date endDate_Q) {
		this.endDate_Q = endDate_Q;
	}

	public java.util.Date getCommonDate_Q() {
		return commonDate_Q;
	}

	public void setCommonDate_Q(java.util.Date commonDate_Q) {
		this.commonDate_Q = commonDate_Q;
	}

	public java.util.Date getCommonDate_from_Q() {
		return commonDate_from_Q;
	}

	public void setCommonDate_from_Q(java.util.Date commonDate_from_Q) {
		this.commonDate_from_Q = commonDate_from_Q;
	}

	public java.util.Date getCommonDate_to_Q() {
		return commonDate_to_Q;
	}

	public void setCommonDate_to_Q(java.util.Date commonDate_to_Q) {
		this.commonDate_to_Q = commonDate_to_Q;
	}

	public String getChargeClass_Q() {
		return chargeClass_Q;
	}

	public void setChargeClass_Q(String chargeClass_Q) {
		this.chargeClass_Q = chargeClass_Q;
	}

}
