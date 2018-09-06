/**
 * 
 */
package com.huateng.scf.adv.fcs.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>四方保兑仓提货VO类</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月21日上午10:23:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月21日上午10:23:01              新增
 *
 * </pre>
 */
public class FourDeliveryQryVO extends CommonQryVO{

	private static final long serialVersionUID = 2470929903356824644L;
	private String debetNo;//借据号
	private String slaveContcode;//抵质押合同号
	private String monitorProtocolCode;//监管协议号
	private String custName;//经销商名称
	private String coreCustName;//核心厂商名称
	private String backCustName;//回购厂商名称
	private String startDate;
	private String endDate;
	private String minAmt;
	private String maxAmt;
	private String appno;
	private String state;
	private String endDate1;
	private String endDate2;
	private String debetId;
	private String mortgageNo;
	private String billno;
	private String appliMortBizType;
	private String deliveryNo;//发货通知编号
	private String num;//收款确认函编号
	private String productId; //产品类型
	
	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}


	public String getMonitorProtocolCode() {
		return monitorProtocolCode;
	}

	public void setMonitorProtocolCode(String monitorProtocolCode) {
		this.monitorProtocolCode = monitorProtocolCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCoreCustName() {
		return coreCustName;
	}

	public void setCoreCustName(String coreCustName) {
		this.coreCustName = coreCustName;
	}

	public String getBackCustName() {
		return backCustName;
	}

	public void setBackCustName(String backCustName) {
		this.backCustName = backCustName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMinAmt() {
		return minAmt;
	}

	public void setMinAmt(String minAmt) {
		this.minAmt = minAmt;
	}

	public String getMaxAmt() {
		return maxAmt;
	}

	public void setMaxAmt(String maxAmt) {
		this.maxAmt = maxAmt;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEndDate1() {
		return endDate1;
	}

	public void setEndDate1(String endDate1) {
		this.endDate1 = endDate1;
	}

	public String getEndDate2() {
		return endDate2;
	}

	public void setEndDate2(String endDate2) {
		this.endDate2 = endDate2;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getAppliMortBizType() {
		return appliMortBizType;
	}

	public void setAppliMortBizType(String appliMortBizType) {
		this.appliMortBizType = appliMortBizType;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}


	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}
}
