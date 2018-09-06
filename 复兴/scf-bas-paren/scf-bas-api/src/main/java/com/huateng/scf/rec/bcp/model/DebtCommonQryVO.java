/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 *  应收类通用查询条件VO
 *
 * @author <a href="mailto:zhangwu@topscf.com">zhangwu</a>
 *
 * @version Revision: 1.0  Date: 2013-5-7 下午03:31:28
 *
 */

public class DebtCommonQryVO extends CommonQryVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//分页查询标志
	private boolean pageFlag;
	
	public boolean isPageFlag()
	{
		return pageFlag;
	}

	public void setPageFlag(boolean pageFlag)
	{
		this.pageFlag = pageFlag;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 本次核销金额
	 */
	private BigDecimal rebateAmount_Q;
	public BigDecimal getRebateAmount_Q() {
		return rebateAmount_Q;
	}

	public void setRebateAmount_Q(BigDecimal rebateAmount_Q) {
		this.rebateAmount_Q = rebateAmount_Q;
	}

	private String id_Q;
	private String appno_Q;//申请流水号
	private String custcdSaller_Q;// 卖方名称
	private String custcdBuyer_Q;// 买方名称
	private String insertDate_Q;
	private String insertDate_from_Q;// 发票登记日期
	private String insertDate_to_Q;
	private String billsDate_Q; // 发票日期
	private String billsDate_from_Q; // 发票日期
	private String billsDate_to_Q;
	private String endDate_Q;// 到期日
	private String endDate_from_Q;// 到期日
	private String endDate_to_Q;
	private String debtEnd_Q;
	private String debtEnd_from_Q;
	private String debtEnd_to_Q;
	private String purchaseDate_from_Q;//承购、转让日期
	private String purchaseDate_to_Q;
	private String purchaseDate_Q;
	private BigDecimal billsAmount_from_Q;// 发票金额
	private BigDecimal billsAmount_to_Q;
	private BigDecimal billsAmount_Q;
	private String status_Q;// 发票状态
	private String billsNo_Q;// 发票号码
	private String billsType_Q;// 应收账款类型
	private String factType_Q;  //国内、反向保理标识
	private String flawFlag_Q;//瑕疵
	private String overdueFlag_Q;//逾期
	private String badFlag_Q;
	private String applyType_Q;
	private String bussType_Q;//产品id
	private String financingType_Q;//融资模式：池、发票
	private String payType_Q;
	private String LoanWay_Q;
	private String debetNo_Q;
	private String debtId_Q;
	private String level_Q;
	private String type_Q;//产品id
	private String relaType_Q;//保理客户关系类型
	private String storeCode_Q;
	private String billsPeriod_Q;
	private String returnStatus_Q;//支付状态
	private String supplyChainPdId_Q;   //产品ID
	private String contStatus_Q;   //合同状态
	private String returnMethod_Q;   //回款方式
	private String repayPurpose_Q;   //回款用途
	private String repayAccount_Q;	//回款专户
	private String payDate_from_Q;// 入账日期 从
	private String payDate_to_Q;// 入账日期  到
	private String leaseContno_Q;//租赁合同编号
	private String leaseContcode_Q;//租赁合同号
	private String claimStatus_Q;//理赔状态
	private List<String> bussTypeList_Q;//业务类型集合
	public String getStart_Q() {
		return start_Q;
	}

	public void setStart_Q(String start_Q) {
		this.start_Q = start_Q;
	}

	public String getEnd_Q() {
		return end_Q;
	}

	public void setEnd_Q(String end_Q) {
		this.end_Q = end_Q;
	}

	private String start_Q;
	private String end_Q;
	private String start_to_Q;
	public String getStart_to_Q() {
		return start_to_Q;
	}

	public void setStart_to_Q(String start_to_Q) {
		this.start_to_Q = start_to_Q;
	}

	public String getEnd_to_Q() {
		return end_to_Q;
	}

	public void setEnd_to_Q(String end_to_Q) {
		this.end_to_Q = end_to_Q;
	}

	private String end_to_Q;
	
	public String getClaimStatus_Q() {
		return claimStatus_Q;
	}

	public void setClaimStatus_Q(String claimStatus_Q) {
		this.claimStatus_Q = claimStatus_Q;
	}

	public String getLeaseContcode_Q() {
		return leaseContcode_Q;
	}

	public void setLeaseContcode_Q(String leaseContcode_Q) {
		this.leaseContcode_Q = leaseContcode_Q;
	}

	public String getLeaseContno_Q() {
		return leaseContno_Q;
	}

	public void setLeaseContno_Q(String leaseContno_Q) {
		this.leaseContno_Q = leaseContno_Q;
	}

	public String getSupplyChainPdId_Q() {
		return supplyChainPdId_Q;
	}

	public void setSupplyChainPdId_Q(String supplyChainPdId_Q) {
		this.supplyChainPdId_Q = supplyChainPdId_Q;
	}

	/**
	 * @return the returnStatus_Q
	 */
	public String getReturnStatus_Q() {
		return returnStatus_Q;
	}

	/**
	 * @param returnStatus_Q the returnStatus_Q to set
	 */
	public void setReturnStatus_Q(String returnStatus_Q) {
		this.returnStatus_Q = returnStatus_Q;
	}

	/**
	 * @return the relaType_Q
	 */
	public String getRelaType_Q() {
		return relaType_Q;
	}

	/**
	 * @param relaType_Q the relaType_Q to set
	 */
	public void setRelaType_Q(String relaType_Q) {
		this.relaType_Q = relaType_Q;
	}

	public DebtCommonQryVO() {}
	
	public DebtCommonQryVO(Page result) {
		this.setPageIndex(result.getCurrent()); // 当前页数
		this.setPageSize(result.getPageSize()); // 每页记录
	}

	public String getId_Q() {
		return id_Q;
	}

	public void setId_Q(String id_Q) {
		this.id_Q = id_Q;
	}

	public String getAppno_Q() {
		return appno_Q;
	}

	public void setAppno_Q(String appno_Q) {
		this.appno_Q = appno_Q;
	}

	public String getCustcdSaller_Q() {
		return custcdSaller_Q;
	}

	public void setCustcdSaller_Q(String custcdSaller_Q) {
		this.custcdSaller_Q = custcdSaller_Q;
	}

	public String getCustcdBuyer_Q() {
		return custcdBuyer_Q;
	}

	public void setCustcdBuyer_Q(String custcdBuyer_Q) {
		this.custcdBuyer_Q = custcdBuyer_Q;
	}

	public String getInsertDate_Q() {
		return insertDate_Q;
	}

	public void setInsertDate_Q(String insertDate_Q) {
		this.insertDate_Q = insertDate_Q;
	}

	public String getInsertDate_from_Q() {
		return insertDate_from_Q;
	}

	public void setInsertDate_from_Q(String insertDate_from_Q) {
		this.insertDate_from_Q = insertDate_from_Q;
	}

	public String getInsertDate_to_Q() {
		return insertDate_to_Q;
	}

	public void setInsertDate_to_Q(String insertDate_to_Q) {
		this.insertDate_to_Q = insertDate_to_Q;
	}

	public String getBillsDate_Q() {
		return billsDate_Q;
	}

	public void setBillsDate_Q(String billsDate_Q) {
		this.billsDate_Q = billsDate_Q;
	}

	public String getBillsDate_from_Q() {
		return billsDate_from_Q;
	}

	public void setBillsDate_from_Q(String billsDate_from_Q) {
		this.billsDate_from_Q = billsDate_from_Q;
	}

	public String getBillsDate_to_Q() {
		return billsDate_to_Q;
	}

	public void setBillsDate_to_Q(String billsDate_to_Q) {
		this.billsDate_to_Q = billsDate_to_Q;
	}

	public String getEndDate_Q() {
		return endDate_Q;
	}

	public void setEndDate_Q(String endDate_Q) {
		this.endDate_Q = endDate_Q;
	}

	public String getEndDate_from_Q() {
		return endDate_from_Q;
	}

	public void setEndDate_from_Q(String endDate_from_Q) {
		this.endDate_from_Q = endDate_from_Q;
	}

	public String getEndDate_to_Q() {
		return endDate_to_Q;
	}

	public void setEndDate_to_Q(String endDate_to_Q) {
		this.endDate_to_Q = endDate_to_Q;
	}

	public String getDebtEnd_Q() {
		return debtEnd_Q;
	}

	public void setDebtEnd_Q(String debtEnd_Q) {
		this.debtEnd_Q = debtEnd_Q;
	}

	public String getDebtEnd_from_Q() {
		return debtEnd_from_Q;
	}

	public void setDebtEnd_from_Q(String debtEnd_from_Q) {
		this.debtEnd_from_Q = debtEnd_from_Q;
	}

	public String getDebtEnd_to_Q() {
		return debtEnd_to_Q;
	}

	public void setDebtEnd_to_Q(String debtEnd_to_Q) {
		this.debtEnd_to_Q = debtEnd_to_Q;
	}

	public String getPurchaseDate_from_Q() {
		return purchaseDate_from_Q;
	}

	public void setPurchaseDate_from_Q(String purchaseDate_from_Q) {
		this.purchaseDate_from_Q = purchaseDate_from_Q;
	}

	public String getPurchaseDate_to_Q() {
		return purchaseDate_to_Q;
	}

	public void setPurchaseDate_to_Q(String purchaseDate_to_Q) {
		this.purchaseDate_to_Q = purchaseDate_to_Q;
	}

	public String getPurchaseDate_Q() {
		return purchaseDate_Q;
	}

	public void setPurchaseDate_Q(String purchaseDate_Q) {
		this.purchaseDate_Q = purchaseDate_Q;
	}

	public BigDecimal getBillsAmount_from_Q() {
		return billsAmount_from_Q;
	}

	public void setBillsAmount_from_Q(BigDecimal billsAmount_from_Q) {
		this.billsAmount_from_Q = billsAmount_from_Q;
	}

	public BigDecimal getBillsAmount_to_Q() {
		return billsAmount_to_Q;
	}

	public void setBillsAmount_to_Q(BigDecimal billsAmount_to_Q) {
		this.billsAmount_to_Q = billsAmount_to_Q;
	}

	public BigDecimal getBillsAmount_Q() {
		return billsAmount_Q;
	}

	public void setBillsAmount_Q(BigDecimal billsAmount_Q) {
		this.billsAmount_Q = billsAmount_Q;
	}

	public String getStatus_Q() {
		return status_Q;
	}

	public void setStatus_Q(String status_Q) {
		this.status_Q = status_Q;
	}

	public String getBillsNo_Q() {
		return billsNo_Q;
	}

	public void setBillsNo_Q(String billsNo_Q) {
		this.billsNo_Q = billsNo_Q;
	}

	public String getBillsType_Q() {
		return billsType_Q;
	}

	public void setBillsType_Q(String billsType_Q) {
		this.billsType_Q = billsType_Q;
	}

	public String getFactType_Q() {
		return factType_Q;
	}

	public void setFactType_Q(String factType_Q) {
		this.factType_Q = factType_Q;
	}

	public String getFlawFlag_Q() {
		return flawFlag_Q;
	}

	public void setFlawFlag_Q(String flawFlag_Q) {
		this.flawFlag_Q = flawFlag_Q;
	}

	public String getOverdueFlag_Q() {
		return overdueFlag_Q;
	}

	public void setOverdueFlag_Q(String overdueFlag_Q) {
		this.overdueFlag_Q = overdueFlag_Q;
	}

	public String getBadFlag_Q() {
		return badFlag_Q;
	}

	public void setBadFlag_Q(String badFlag_Q) {
		this.badFlag_Q = badFlag_Q;
	}

	public String getApplyType_Q() {
		return applyType_Q;
	}

	public void setApplyType_Q(String applyType_Q) {
		this.applyType_Q = applyType_Q;
	}

	public String getBussType_Q() {
		return bussType_Q;
	}

	public void setBussType_Q(String bussType_Q) {
		this.bussType_Q = bussType_Q;
	}

	public String getFinancingType_Q() {
		return financingType_Q;
	}

	public void setFinancingType_Q(String financingType_Q) {
		this.financingType_Q = financingType_Q;
	}

	public String getPayType_Q() {
		return payType_Q;
	}

	public void setPayType_Q(String payType_Q) {
		this.payType_Q = payType_Q;
	}

	public String getLoanWay_Q() {
		return LoanWay_Q;
	}

	public void setLoanWay_Q(String loanWay_Q) {
		LoanWay_Q = loanWay_Q;
	}

	public String getDebetNo_Q() {
		return debetNo_Q;
	}

	public void setDebetNo_Q(String debetNo_Q) {
		this.debetNo_Q = debetNo_Q;
	}

	public String getDebtId_Q() {
		return debtId_Q;
	}

	public void setDebtId_Q(String debtId_Q) {
		this.debtId_Q = debtId_Q;
	}

	public String getLevel_Q() {
		return level_Q;
	}

	public void setLevel_Q(String level_Q) {
		this.level_Q = level_Q;
	}

	public String getType_Q() {
		return type_Q;
	}

	public void setType_Q(String type_Q) {
		this.type_Q = type_Q;
	}

	public String getStoreCode_Q() {
		return storeCode_Q;
	}

	public void setStoreCode_Q(String storeCode_Q) {
		this.storeCode_Q = storeCode_Q;
	}

	public String getBillsPeriod_Q() {
		return billsPeriod_Q;
	}

	public void setBillsPeriod_Q(String billsPeriod_Q) {
		this.billsPeriod_Q = billsPeriod_Q;
	}

	public String getContStatus_Q() {
		return contStatus_Q;
	}

	public void setContStatus_Q(String contStatus_Q) {
		this.contStatus_Q = contStatus_Q;
	}

	public String getReturnMethod_Q() {
		return returnMethod_Q;
	}

	public void setReturnMethod_Q(String returnMethod_Q) {
		this.returnMethod_Q = returnMethod_Q;
	}

	public String getRepayPurpose_Q() {
		return repayPurpose_Q;
	}

	public void setRepayPurpose_Q(String repayPurpose_Q) {
		this.repayPurpose_Q = repayPurpose_Q;
	}

	public String getRepayAccount_Q() {
		return repayAccount_Q;
	}

	public void setRepayAccount_Q(String repayAccount_Q) {
		this.repayAccount_Q = repayAccount_Q;
	}

	public String getPayDate_from_Q() {
		return payDate_from_Q;
	}

	public void setPayDate_from_Q(String payDate_from_Q) {
		this.payDate_from_Q = payDate_from_Q;
	}

	public String getPayDate_to_Q() {
		return payDate_to_Q;
	}

	public void setPayDate_to_Q(String payDate_to_Q) {
		this.payDate_to_Q = payDate_to_Q;
	}

	public List<String> getBussTypeList_Q() {
		return bussTypeList_Q;
	}

	public void setBussTypeList_Q(List<String> bussTypeList_Q) {
		this.bussTypeList_Q = bussTypeList_Q;
	}

}