package com.huateng.scf.adv.wrn.dao.model;

/**
 * @author htrad0055
 *	价格跌幅预警扩展类
 */
public class BWanMortFlucPriceVO extends BWanMortFlucPrice {

	private static final long serialVersionUID = 1L;
	private String protocolCode;
	private String mortgageLevelOneName;
	private String mortgageLevelTwoName;
	private String mortgageLevelThreeName;
	private String custManager;
	private String brcodeName;

	public String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public String getMortgageLevelOneName() {
		return mortgageLevelOneName;
	}

	public void setMortgageLevelOneName(String mortgageLevelOneName) {
		this.mortgageLevelOneName = mortgageLevelOneName;
	}

	public String getMortgageLevelTwoName() {
		return mortgageLevelTwoName;
	}

	public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
		this.mortgageLevelTwoName = mortgageLevelTwoName;
	}

	public String getMortgageLevelThreeName() {
		return mortgageLevelThreeName;
	}

	public void setMortgageLevelThreeName(String mortgageLevelThreeName) {
		this.mortgageLevelThreeName = mortgageLevelThreeName;
	}

	public String getCustManager() {
		return custManager;
	}

	public void setCustManager(String custManager) {
		this.custManager = custManager;
	}

	public String getBrcodeName() {
		return brcodeName;
	}

	public void setBrcodeName(String brcodeName) {
		this.brcodeName = brcodeName;
	}

}
