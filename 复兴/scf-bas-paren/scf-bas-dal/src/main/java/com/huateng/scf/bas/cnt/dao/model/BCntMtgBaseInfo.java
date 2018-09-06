package com.huateng.scf.bas.cnt.dao.model;

import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;

public class BCntMtgBaseInfo extends BPbcMtgBaseInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8077674011867722638L;

	private String mortgageLevelOneName;
	
	private String mortgageLevelTwoName;
	
	private String mortgageLevelThreeName;

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


}
