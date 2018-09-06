package com.huateng.scf.sto.nwr.vo;

import java.util.Date;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * 
 * <p>仓单管理查询VO</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月11日上午11:12:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月11日上午11:12:10	     新增
 *
 * </pre>
 */
public class BillstandardQryVO extends CommonQryVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String billno;
	private String billcode;
	private Date startDate_to;
	private Date startDate_from;
	private Date endDate_to;
	private Date endDate_from;
	private String supplyChainPdId;
	private String appliType;
	private String state;
	private String id;
	private String selectId;
	private boolean selectFlag;
	private Date startDate;
	private Date endDate;
	private String secName;
	private String thrCd;
	public String getMortgageNo() {
		return mortgageNo;
	}
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

	private String mortgageNo;
	public String getThrCd() {
		return thrCd;
	}
	public void setThrCd(String thrCd) {
		this.thrCd = thrCd;
	}
	public String getSecName() {
		return secName;
	}
	public void setSecName(String secName) {
		this.secName = secName;
	}
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
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
	public String getMortgageLevelThree() {
		return mortgageLevelThree;
	}
	public void setMortgageLevelThree(String mortgageLevelThree) {
		this.mortgageLevelThree = mortgageLevelThree;
	}

	private String exchangeName;
	private String mortgageClass;
	private String mortgageClassNo;
	private String mortgageLevelThree;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getSelectFlag() {
		return selectFlag;
	}
	public void setSelectFlag(boolean selectFlag) {
		this.selectFlag = selectFlag;
	}
	public String getSelectId() {
		return selectId;
	}
	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppliType() {
		return appliType;
	}
	public void setAppliType(String appliType) {
		this.appliType = appliType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBillcode() {
		return billcode;
	}
	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public Date getStartDate_from() {
		return startDate_from;
	}
	public void setStartDate_from(Date startDate_from) {
		this.startDate_from = startDate_from;
	}
	public Date getStartDate_to() {
		return startDate_to;
	}
	public void setStartDate_to(Date startDate_to) {
		this.startDate_to = startDate_to;
	}
	public Date getEndDate_to() {
		return endDate_to;
	}
	public void setEndDate_to(Date endDate_to) {
		this.endDate_to = endDate_to;
	}
	public Date getEndDate_from() {
		return endDate_from;
	}
	public void setEndDate_from(Date endDate_from) {
		this.endDate_from = endDate_from;
	}
}
