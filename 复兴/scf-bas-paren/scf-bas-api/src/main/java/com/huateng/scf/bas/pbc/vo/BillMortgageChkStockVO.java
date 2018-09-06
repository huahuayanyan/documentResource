package com.huateng.scf.bas.pbc.vo;

import com.huateng.scf.bas.pbc.model.BPbcMtgChkStockInfoVO;

/**
 *
 * 在这里添加类的文档注释
 *
 * @author <a href="mailto:zhangwu@topscf.com">zhangwu</a>
 *
 * @version Revision: 1.0  Date: 2013-11-8 下午02:32:39
 *
 */
public class BillMortgageChkStockVO extends BPbcMtgChkStockInfoVO {

	public static final long serialVersionUID = 1L;
	private String productId;
	private String moniWarehouseType;
	private String warehouseType;
	private String mgrno;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getMoniWarehouseType() {
		return moniWarehouseType;
	}
	public void setMoniWarehouseType(String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}
	public String getMgrno() {
		return mgrno;
	}
	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}
	public String getWarehouseType() {
		return warehouseType;
	}
	public void setWarehouseType(String warehouseType) {
		this.warehouseType = warehouseType;
	}

}
