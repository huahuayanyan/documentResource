package com.huateng.scf.bas.pbc.dao.model;

public class BPbcMtgMktPriceVO extends BPbcMtgMktPrice {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * VARCHAR(100)<br>
     * 押品一级
     */
    private String mortgageLevelOneName;

    /**
     * VARCHAR(100)<br>
     * 押品二级
     */
    private String mortgageLevelTwoName;

    /**
     * VARCHAR(100)<br>
     * 押品三级
     */
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
