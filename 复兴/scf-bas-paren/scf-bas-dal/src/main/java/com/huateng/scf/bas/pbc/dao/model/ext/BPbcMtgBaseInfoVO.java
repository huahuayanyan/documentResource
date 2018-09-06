package com.huateng.scf.bas.pbc.dao.model.ext;

import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;

public class BPbcMtgBaseInfoVO extends BPbcMtgBaseInfo {
	private String custName;
	private String moniOfCustName;
	private String supplyChainPdIdName;
	private String mortgageLevelOneName;
	private String mortgageLevelTwoName;
	private String mortgageLevelThreeName;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMoniOfCustName() {
		return moniOfCustName;
	}

	public void setMoniOfCustName(String moniOfCustName) {
		this.moniOfCustName = moniOfCustName;
	}

	public String getSupplyChainPdIdName() {
		return supplyChainPdIdName;
	}

	public void setSupplyChainPdIdName(String supplyChainPdIdName) {
		this.supplyChainPdIdName = supplyChainPdIdName;
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

	@Override
	public String toString() {
		return "BPbcMtgBaseInfoVO [custName=" + custName + ", moniOfCustName=" + moniOfCustName + ", supplyChainPdIdName=" + supplyChainPdIdName
				+ ", mortgageLevelOneName=" + mortgageLevelOneName + ", mortgageLevelTwoName=" + mortgageLevelTwoName + "]";
	}

}
