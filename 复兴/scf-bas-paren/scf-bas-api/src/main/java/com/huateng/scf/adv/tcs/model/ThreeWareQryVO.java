/**
 * 
 */
package com.huateng.scf.adv.tcs.model;

import java.io.Serializable;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>三方协议查询VO</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月20日下午1:28:39
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月20日下午1:28:39              新增
 *
 * </pre>
 */
public class ThreeWareQryVO extends CommonQryVO implements Serializable{

	private static final long serialVersionUID = -836416762926821081L;

	private String coreName;//核心厂商名称
	private String appno;//申请编号
	private String id;
	private String debetNo;//借据编号
	private String sellerCustcd;//经销商
	private String buyerCustcd;//
	private String billId;//
	private String state;//协议状态
	private String debetId;//借据号
	
	public ThreeWareQryVO(){

	}
	public ThreeWareQryVO(String coreName, String appno, String id, String debetNo, String sellerCustcd,
			String buyerCustcd, String billId, String state,String debetId) {
		this.coreName = coreName;
		this.appno = appno;
		this.id = id;
		this.debetNo = debetNo;
		this.sellerCustcd = sellerCustcd;
		this.buyerCustcd = buyerCustcd;
		this.billId = billId;
		this.debetId = debetId;
		this.state = state;
	}
	
	public String getCoreName() {
		return coreName;
	}
	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public String getSellerCustcd() {
		return sellerCustcd;
	}
	public void setSellerCustcd(String sellerCustcd) {
		this.sellerCustcd = sellerCustcd;
	}
	public String getBuyerCustcd() {
		return buyerCustcd;
	}
	public void setBuyerCustcd(String buyerCustcd) {
		this.buyerCustcd = buyerCustcd;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	
	

}
