package com.huateng.scf.bas.pbc.model;

/**
 * @author htrad0055
 *
 */
public class BPbcMtgMktPriceHisVO extends BPbcMtgMktPriceHis {
	
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
    
    

}
