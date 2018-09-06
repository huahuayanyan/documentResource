/**
 * 
 */
package com.huateng.scf.bas.pbc.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>押品查询条件VO</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月28日下午1:10:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月28日下午1:10:04              新增
 *
 * </pre>
 */
public class MortgageQryVO extends CommonQryVO {
	private static final long serialVersionUID = 674421597378570026L;
	private String appno;
	private String monitorProtocolNo;
	private String supplyChainPdId;
	private String billno;
	private String mortgageName;// 押品名称
	private String parentCode;// 押品上级编号
	private String mortgageLevelOne;// 押品一级
	private String mortgageLevelTwo;// 押品二级
	private String levels;// 押品级别
	private String mortgageCode;
	private String mortgageClass;
	private String mortgageClassNo;
	private String mortgageNo;//押品编号
	private String storOrDeli;//业务类型

	public String getStorOrDeli() {
		return storOrDeli;
	}

	public void setStorOrDeli(String storOrDeli) {
		this.storOrDeli = storOrDeli;
	}

	public MortgageQryVO() {
		super();
	}

	public String getMortgageName() {
		return mortgageName;
	}

	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getMortgageLevelOne() {
		return mortgageLevelOne;
	}

	public void setMortgageLevelOne(String mortgageLevelOne) {
		this.mortgageLevelOne = mortgageLevelOne;
	}

	public String getMortgageLevelTwo() {
		return mortgageLevelTwo;
	}

	public void setMortgageLevelTwo(String mortgageLevelTwo) {
		this.mortgageLevelTwo = mortgageLevelTwo;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}

	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getMortgageCode() {
		return mortgageCode;
	}

	public void setMortgageCode(String mortgageCode) {
		this.mortgageCode = mortgageCode;
	}

	public String getMortgageClass() {
		return mortgageClass;
	}

	public void setMortgageClass(String mortgageClass) {
		this.mortgageClass = mortgageClass;
	}

	public String getMortgageClassNo() {
		return mortgageClassNo;
	}

	public void setMortgageClassNo(String mortgageClassNo) {
		this.mortgageClassNo = mortgageClassNo;
	}

	public String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

}
