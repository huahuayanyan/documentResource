package com.huateng.scf.adv.wrn.dao.model;


/**
 * @author htrad0055
 *	对账不平预警扩张类
 */
public class BWanCheckStockVO extends BWanCheckStock {
	
	private String mgrNm;
	
	private String brcodeNm;
	
	private String custManager;
	
	private String brcode;
	
	private String productId; 

	private String productNm;
	
	public String getMgrNm() {
		return mgrNm;
	}

	public void setMgrNm(String mgrNm) {
		this.mgrNm = mgrNm;
	}

	public String getBrcodeNm() {
		return brcodeNm;
	}

	public void setBrcodeNm(String brcodeNm) {
		this.brcodeNm = brcodeNm;
	}

	public String getCustManager() {
		return custManager;
	}

	public void setCustManager(String custManager) {
		this.custManager = custManager;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	
	
}
