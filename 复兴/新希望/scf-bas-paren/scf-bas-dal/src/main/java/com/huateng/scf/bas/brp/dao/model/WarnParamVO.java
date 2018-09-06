/**
 * 
 */
package com.huateng.scf.bas.brp.dao.model;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月19日下午1:44:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月19日下午1:44:51              新增
 *
 * </pre>
 */
public class WarnParamVO extends BBrpWarnParam {
	private static final long serialVersionUID = -5449179633754992886L;
	private Integer warnLevelH;// 高级预警总数
	private Integer warnLevelM;// 中级预警总数
	private Integer warnLevelL;// 低级预警总数
	private java.lang.String id;// 预警包ID
	private java.lang.String name;// 预警报名
	private java.lang.String superId;// 上级预警包ID
	private java.lang.String remark;// 备注
	private java.lang.String productId;
	private java.lang.String productName;
	
	
	public java.lang.String getProductId() {
		return productId;
	}

	public void setProductId(java.lang.String productId) {
		this.productId = productId;
	}

	public java.lang.String getProductName() {
		return productName;
	}

	public void setProductName(java.lang.String productName) {
		this.productName = productName;
	}

	public Integer getWarnLevelH() {
		return warnLevelH;
	}

	public void setWarnLevelH(Integer warnLevelH) {
		this.warnLevelH = warnLevelH;
	}

	public Integer getWarnLevelM() {
		return warnLevelM;
	}

	public void setWarnLevelM(Integer warnLevelM) {
		this.warnLevelM = warnLevelM;
	}

	public Integer getWarnLevelL() {
		return warnLevelL;
	}

	public void setWarnLevelL(Integer warnLevelL) {
		this.warnLevelL = warnLevelL;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getSuperId() {
		return superId;
	}

	public void setSuperId(java.lang.String superId) {
		this.superId = superId;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
}
