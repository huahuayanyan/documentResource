package com.huateng.scf.adv.wrn.dao.model;


/**
 * @author htrad0055
 *	跌破最低控货价值/警戒线预警信息表扩展表
 */
public class DownLowPriceNewVO extends BWrnDropCtlInfo {
	private String warnDate;
	private String custManager;
	private String brcode;
	private String productId;
	private String mgrNm;
	private String brcodeNm;
	private String productNm;

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

	public String getWarnDate() {
		return warnDate;
	}

	public void setWarnDate(String warnDate) {
		this.warnDate = warnDate;
	}

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

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	
}