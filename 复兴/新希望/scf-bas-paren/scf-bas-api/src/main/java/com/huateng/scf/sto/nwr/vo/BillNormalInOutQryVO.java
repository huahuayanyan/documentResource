package com.huateng.scf.sto.nwr.vo;

import java.util.Date;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * 
 * <p>普通仓单台帐查询VO</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月11日上午10:18:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月11日上午10:18:45	     新增
 *
 * </pre>
 */
public class BillNormalInOutQryVO  extends CommonQryVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	// fields

	private String billno;
	private String billcode;

	private String address;
	private String postno;
	private String warehouseId;
	private String storageAddress;
	private Date signDate;
	private String phone;
	private String fax;
	private String startDate;
	private String endDate;
	private String standLose;
	private String storageCostEndDate;
	private String tlrcd;

	private String status;
	private String pid;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getBillcode() {
		return billcode;
	}
	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostno() {
		return postno;
	}
	public void setPostno(String postno) {
		this.postno = postno;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getStorageAddress() {
		return storageAddress;
	}
	public void setStorageAddress(String storageAddress) {
		this.storageAddress = storageAddress;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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
	public String getStandLose() {
		return standLose;
	}
	public void setStandLose(String standLose) {
		this.standLose = standLose;
	}
	public String getStorageCostEndDate() {
		return storageCostEndDate;
	}
	public void setStorageCostEndDate(String storageCostEndDate) {
		this.storageCostEndDate = storageCostEndDate;
	}
	public String getTlrcd() {
		return tlrcd;
	}
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
}
