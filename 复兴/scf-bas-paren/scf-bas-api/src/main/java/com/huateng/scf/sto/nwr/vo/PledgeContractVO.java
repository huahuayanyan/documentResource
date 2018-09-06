package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class PledgeContractVO extends CommonQryVO
{
	private String midProductId;
	private String billType;
	public String getMidProductId() {
		return midProductId;
	}

	public void setMidProductId(String midProductId) {
		this.midProductId = midProductId;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mastContno;
	private String mastContcode;
	private String slaveContno;
	private String slaveContcode;
	private String custcd;
	private String cname;
	private String planMoniEnt;
	private String suppProductName;
	private String financingType;
	private String curcd;
	private String curcdNm;
	private java.math.BigDecimal contAmount;
	private String supplyChainPdId_Q;
	private String moniOfCustcd;

	private String protocolNo;

	private String supplyChainPdId;

	public String getMastContno()
	{
		return mastContno;
	}

	public void setMastContno(String mastContno)
	{
		this.mastContno = mastContno;
	}

	public String getMastContcode()
	{
		return mastContcode;
	}

	public void setMastContcode(String mastContcode)
	{
		this.mastContcode = mastContcode;
	}

	public String getSlaveContno()
	{
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno)
	{
		this.slaveContno = slaveContno;
	}

	public String getSlaveContcode()
	{
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode)
	{
		this.slaveContcode = slaveContcode;
	}

	public String getCustcd()
	{
		return custcd;
	}

	public void setCustcd(String custcd)
	{
		this.custcd = custcd;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public String getPlanMoniEnt()
	{
		return planMoniEnt;
	}

	public void setPlanMoniEnt(String planMoniEnt)
	{
		this.planMoniEnt = planMoniEnt;
	}

	public String getSuppProductName()
	{
		return suppProductName;
	}

	public void setSuppProductName(String suppProductName)
	{
		this.suppProductName = suppProductName;
	}

	public String getFinancingType()
	{
		return financingType;
	}

	public void setFinancingType(String financingType)
	{
		this.financingType = financingType;
	}

	public String getCurcd()
	{
		return curcd;
	}

	public void setCurcd(String curcd)
	{
		this.curcd = curcd;
	}

	public String getCurcdNm()
	{
		return curcdNm;
	}

	public void setCurcdNm(String curcdNm)
	{
		this.curcdNm = curcdNm;
	}

	public java.math.BigDecimal getContAmount()
	{
		return contAmount;
	}

	public void setContAmount(java.math.BigDecimal contAmount)
	{
		this.contAmount = contAmount;
	}

	public String getSupplyChainPdId_Q()
	{
		return supplyChainPdId_Q;
	}

	public void setSupplyChainPdId_Q(String supplyChainPdId_Q)
	{
		this.supplyChainPdId_Q = supplyChainPdId_Q;
	}

	public String getMoniOfCustcd()
	{
		return moniOfCustcd;
	}

	public void setMoniOfCustcd(String moniOfCustcd)
	{
		this.moniOfCustcd = moniOfCustcd;
	}

	public String getProtocolNo()
	{
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo)
	{
		this.protocolNo = protocolNo;
	}

	public String getSupplyChainPdId()
	{
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId)
	{
		this.supplyChainPdId = supplyChainPdId;
	}
}
