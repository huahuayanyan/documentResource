/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2013 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.icr.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * 额度查询条件VO
 *
 * @author <a href="mailto:xiong_xiaolong@topscf.com">xiong_xiaolong</a>
 *
 * @version Revision: 1.0 Date: 2013-5-15 下午3:08:58
 *
 */

public class CreditQryVO extends CommonQryVO {

	/**
	 * 
	 */
	private boolean pageFlag = true;
	
	public boolean isPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(boolean pageFlag) {
		this.pageFlag = pageFlag;
	}

	private static final long serialVersionUID = 1L;
	private String creditClass_Q;// 额度品种
	private String creditType_Q;// 额度类型
	private String value;// 输入值
	private String productId_Q;// 供应链产品类型
	private String id_Q;
	private String buyerCustcd_Q;
	private String oprcode_Q;
	private String status_Q;//状态
	private String nodeType_Q;
	private String type_Q;
	private String creditNo_Q;
	private String upCreditNo_Q;//上级额度编号
	private String approvalNo_Q;//授信批复号
	private String startDate_Q;//起始日
	private String endDate_Q;//截至日
	private String otherCustcd_Q;//交易对手、保理买方
	private String otherCustName_Q;//交易对手名称、保理买方
	private String applyType_Q;//业务申请类型
	private String businessNo_Q;//业务合同号
	private String brName_Q;//申请机构名称
	private String loanDate_from_Q;//出账日 从
	private String loanDate_to_Q;//出账日 到
	private String returnDate_from_Q;//归还日 从
	private String returnDate_to_Q;//归还日  到
	private String chiefCreditNo_Q;//总额度编号
	
	public String getChiefCreditNo_Q() {
		return chiefCreditNo_Q;
	}

	public void setChiefCreditNo_Q(String chiefCreditNo_Q) {
		this.chiefCreditNo_Q = chiefCreditNo_Q;
	}

	public String getLoanDate_from_Q() {
		return loanDate_from_Q;
	}

	public void setLoanDate_from_Q(String loanDate_from_Q) {
		this.loanDate_from_Q = loanDate_from_Q;
	}

	public String getLoanDate_to_Q() {
		return loanDate_to_Q;
	}

	public void setLoanDate_to_Q(String loanDate_to_Q) {
		this.loanDate_to_Q = loanDate_to_Q;
	}

	public String getReturnDate_from_Q() {
		return returnDate_from_Q;
	}

	public void setReturnDate_from_Q(String returnDate_from_Q) {
		this.returnDate_from_Q = returnDate_from_Q;
	}

	public String getReturnDate_to_Q() {
		return returnDate_to_Q;
	}

	public void setReturnDate_to_Q(String returnDate_to_Q) {
		this.returnDate_to_Q = returnDate_to_Q;
	}

	public String getBrName_Q() {
		return brName_Q;
	}

	public void setBrName_Q(String brName_Q) {
		this.brName_Q = brName_Q;
	}

	public String getBusinessNo_Q() {
		return businessNo_Q;
	}

	public void setBusinessNo_Q(String businessNo_Q) {
		this.businessNo_Q = businessNo_Q;
	}

	public String getApplyType_Q() {
		return applyType_Q;
	}

	public void setApplyType_Q(String applyType_Q) {
		this.applyType_Q = applyType_Q;
	}

	private String insuranceCustcd_Q;//保理商/保险公司客户号
	


	public String getInsuranceCustcd_Q() {
		return insuranceCustcd_Q;
	}

	public void setInsuranceCustcd_Q(String insuranceCustcd_Q) {
		this.insuranceCustcd_Q = insuranceCustcd_Q;
	}

	public String getOtherCustcd_Q() {
		return otherCustcd_Q;
	}

	public void setOtherCustcd_Q(String otherCustcd_Q) {
		this.otherCustcd_Q = otherCustcd_Q;
	}

	public String getStartDate_Q() {
		return startDate_Q;
	}

	public void setStartDate_Q(String startDate_Q) {
		this.startDate_Q = startDate_Q;
	}

	public String getEndDate_Q() {
		return endDate_Q;
	}

	public void setEndDate_Q(String endDate_Q) {
		this.endDate_Q = endDate_Q;
	}

	public String getCreditClass_Q() {
		return creditClass_Q;
	}

	public void setCreditClass_Q(String creditClass_Q) {
		this.creditClass_Q = creditClass_Q;
	}

	public String getCreditType_Q() {
		return creditType_Q;
	}

	public void setCreditType_Q(String creditType_Q) {
		this.creditType_Q = creditType_Q;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getProductId_Q() {
		return productId_Q;
	}

	public void setProductId_Q(String productId_Q) {
		this.productId_Q = productId_Q;
	}

	public String getId_Q() {
		return id_Q;
	}

	public void setId_Q(String id_Q) {
		this.id_Q = id_Q;
	}

	public String getBuyerCustcd_Q() {
		return buyerCustcd_Q;
	}

	public void setBuyerCustcd_Q(String buyerCustcd_Q) {
		this.buyerCustcd_Q = buyerCustcd_Q;
	}

	public String getOprcode_Q() {
		return oprcode_Q;
	}

	public void setOprcode_Q(String oprcode_Q) {
		this.oprcode_Q = oprcode_Q;
	}

	public String getStatus_Q() {
		return status_Q;
	}

	public void setStatus_Q(String status_Q) {
		this.status_Q = status_Q;
	}

	public String getNodeType_Q() {
		return nodeType_Q;
	}

	public void setNodeType_Q(String nodeType_Q) {
		this.nodeType_Q = nodeType_Q;
	}

	public String getType_Q() {
		return type_Q;
	}

	public void setType_Q(String type_Q) {
		this.type_Q = type_Q;
	}

	public String getCreditNo_Q() {
		return creditNo_Q;
	}

	public void setCreditNo_Q(String creditNo_Q) {
		this.creditNo_Q = creditNo_Q;
	}


	public String getApprovalNo_Q() {
		return approvalNo_Q;
	}

	public void setApprovalNo_Q(String approvalNo_Q) {
		this.approvalNo_Q = approvalNo_Q;
	}

	public String getUpCreditNo_Q() {
		return upCreditNo_Q;
	}

	public void setUpCreditNo_Q(String upCreditNo_Q) {
		this.upCreditNo_Q = upCreditNo_Q;
	}

	public String getOtherCustName_Q() {
		return otherCustName_Q;
	}

	public void setOtherCustName_Q(String otherCustName_Q) {
		this.otherCustName_Q = otherCustName_Q;
	}

}
