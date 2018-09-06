package com.huateng.scf.adv.wrn.dao.model;

import com.huateng.scf.bas.common.dao.model.CommonQryVO;

/**
 * @author htrad0055
 *
 *         预警查询条件VO
 * 
 */
public class WarnQryVO extends CommonQryVO {

	private static final long serialVersionUID = 1L;
	private String id_Q;
	private String paramId_Q;// 预警编号
	private String warnLevel_Q;// 预警级别
	private String superId_Q;
	private String warnDueType_Q;
	private String status_Q;
	private String warnType_Q;
	private String fluctuation1_Q;
	private String fluctuation2_Q;
	private String appno_Q;
	private String endDateFrom_Q;
	private String endDateTo_Q;
	private String tlrcd_Q;
	private String creditNo_Q;
	private String bussType_Q;
	private String billsNo_Q;
	private String custcdBuyer_Q;
	private String custcdSaller_Q;
	private String debetId_Q;
	private String num_Q;
	private String coreNm_Q;
	private String packageId_Q;
	private String warnNo_Q;
	private String productId_Q;
	private String startDate_Q;
	private String endDate_Q;
	private String moniName_Q;
	private String checkStockWay_Q;
	private String warnName_Q;
	private String currentDate_Q;
	private String brcode_Q;
	private String cnameBuyer_Q;
	private String checkType_Q;
	private String protocolCode_Q;
	private String brattr;
	private String warehouseType;
	private String loanWay_Q;
	private String cnameSeller_Q;

	public String getWarnName_Q() {
		return warnName_Q;
	}

	public String getCnameSeller_Q() {
		return cnameSeller_Q;
	}

	public void setCnameSeller_Q(String cnameSeller_Q) {
		this.cnameSeller_Q = cnameSeller_Q;
	}

	public void setWarnName_Q(String warnName_Q) {
		this.warnName_Q = warnName_Q;
	}

	public String getCheckStockWay_Q() {
		return checkStockWay_Q;
	}

	public void setCheckStockWay_Q(String checkStockWay_Q) {
		this.checkStockWay_Q = checkStockWay_Q;
	}

	public String getMoniName_Q() {
		return moniName_Q;
	}

	public void setMoniName_Q(String moniName_Q) {
		this.moniName_Q = moniName_Q;
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

	public String getProductId_Q() {
		return productId_Q;
	}

	public void setProductId_Q(String productId_Q) {
		this.productId_Q = productId_Q;
	}

	public WarnQryVO() {

	}

	public String getParamId_Q() {
		return paramId_Q;
	}

	public void setParamId_Q(String paramId_Q) {
		this.paramId_Q = paramId_Q;
	}

	public String getWarnLevel_Q() {
		return warnLevel_Q;
	}

	public void setWarnLevel_Q(String warnLevel_Q) {
		this.warnLevel_Q = warnLevel_Q;
	}

	public String getId_Q() {
		return id_Q;
	}

	public void setId_Q(String id_Q) {
		this.id_Q = id_Q;
	}

	public String getSuperId_Q() {
		return superId_Q;
	}

	public void setSuperId_Q(String superId_Q) {
		this.superId_Q = superId_Q;
	}

	public String getWarnDueType_Q() {
		return warnDueType_Q;
	}

	public void setWarnDueType_Q(String warnDueType_Q) {
		this.warnDueType_Q = warnDueType_Q;
	}

	public String getStatus_Q() {
		return status_Q;
	}

	public void setStatus_Q(String status_Q) {
		this.status_Q = status_Q;
	}

	public String getWarnType_Q() {
		return warnType_Q;
	}

	public void setWarnType_Q(String warnType_Q) {
		this.warnType_Q = warnType_Q;
	}

	public String getFluctuation1_Q() {
		return fluctuation1_Q;
	}

	public void setFluctuation1_Q(String fluctuation1_Q) {
		this.fluctuation1_Q = fluctuation1_Q;
	}

	public String getFluctuation2_Q() {
		return fluctuation2_Q;
	}

	public void setFluctuation2_Q(String fluctuation2_Q) {
		this.fluctuation2_Q = fluctuation2_Q;
	}

	public String getAppno_Q() {
		return appno_Q;
	}

	public void setAppno_Q(String appno_Q) {
		this.appno_Q = appno_Q;
	}

	public String getEndDateFrom_Q() {
		return endDateFrom_Q;
	}

	public void setEndDateFrom_Q(String endDateFrom_Q) {
		this.endDateFrom_Q = endDateFrom_Q;
	}

	public String getEndDateTo_Q() {
		return endDateTo_Q;
	}

	public void setEndDateTo_Q(String endDateTo_Q) {
		this.endDateTo_Q = endDateTo_Q;
	}

	public String getTlrcd_Q() {
		return tlrcd_Q;
	}

	public void setTlrcd_Q(String tlrcd_Q) {
		this.tlrcd_Q = tlrcd_Q;
	}

	public String getCreditNo_Q() {
		return creditNo_Q;
	}

	public void setCreditNo_Q(String creditNo_Q) {
		this.creditNo_Q = creditNo_Q;
	}

	public String getBussType_Q() {
		return bussType_Q;
	}

	public void setBussType_Q(String bussType_Q) {
		this.bussType_Q = bussType_Q;
	}

	public String getBillsNo_Q() {
		return billsNo_Q;
	}

	public void setBillsNo_Q(String billsNo_Q) {
		this.billsNo_Q = billsNo_Q;
	}

	public String getCustcdBuyer_Q() {
		return custcdBuyer_Q;
	}

	public void setCustcdBuyer_Q(String custcdBuyer_Q) {
		this.custcdBuyer_Q = custcdBuyer_Q;
	}

	public String getCustcdSaller_Q() {
		return custcdSaller_Q;
	}

	public void setCustcdSaller_Q(String custcdSaller_Q) {
		this.custcdSaller_Q = custcdSaller_Q;
	}

	public String getDebetId_Q() {
		return debetId_Q;
	}

	public void setDebetId_Q(String debetId_Q) {
		this.debetId_Q = debetId_Q;
	}

	public String getNum_Q() {
		return num_Q;
	}

	public void setNum_Q(String num_Q) {
		this.num_Q = num_Q;
	}

	public String getCoreNm_Q() {
		return coreNm_Q;
	}

	public void setCoreNm_Q(String coreNm_Q) {
		this.coreNm_Q = coreNm_Q;
	}

	public String getPackageId_Q() {
		return packageId_Q;
	}

	public void setPackageId_Q(String packageId_Q) {
		this.packageId_Q = packageId_Q;
	}

	public String getWarnNo_Q() {
		return warnNo_Q;
	}

	public void setWarnNo_Q(String warnNo_Q) {
		this.warnNo_Q = warnNo_Q;
	}

	public String getCnameBuyer_Q() {
		return cnameBuyer_Q;
	}

	public void setCnameBuyer_Q(String cnameBuyer_Q) {
		this.cnameBuyer_Q = cnameBuyer_Q;
	}

	public String getCheckType_Q() {
		return checkType_Q;
	}

	public void setCheckType_Q(String checkType_Q) {
		this.checkType_Q = checkType_Q;
	}

	public String getCurrentDate_Q() {
		return currentDate_Q;
	}

	public void setCurrentDate_Q(String currentDate_Q) {
		this.currentDate_Q = currentDate_Q;
	}

	public String getBrcode_Q() {
		return brcode_Q;
	}

	public void setBrcode_Q(String brcode_Q) {
		this.brcode_Q = brcode_Q;
	}

	public String getProtocolCode_Q() {
		return protocolCode_Q;
	}

	public void setProtocolCode_Q(String protocolCode_Q) {
		this.protocolCode_Q = protocolCode_Q;
	}

	public String getBrattr() {
		return brattr;
	}

	public void setBrattr(String brattr) {
		this.brattr = brattr;
	}

	public String getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(String warehouseType) {
		this.warehouseType = warehouseType;
	}

	public String getLoanWay_Q() {
		return loanWay_Q;
	}

	public void setLoanWay_Q(String loanWay_Q) {
		this.loanWay_Q = loanWay_Q;
	}
	
}