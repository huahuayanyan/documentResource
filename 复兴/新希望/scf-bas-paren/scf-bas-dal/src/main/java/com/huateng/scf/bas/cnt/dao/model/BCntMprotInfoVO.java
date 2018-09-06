package com.huateng.scf.bas.cnt.dao.model;

/**
 * @author htrad0055
 *
 */
/**
 * @author htrad0055
 *
 */
public class BCntMprotInfoVO extends BCntMprotInfo {
	
    /**
     * VARCHAR(100)<br>
     * 押品一级名称
     */
    private String mortgageLevelOneName;
    
    /**
     * VARCHAR(100)<br>
     * 押品二级名称
     */
    private String mortgageLevelTwoName;
    
    /**
     * VARCHAR(100)<br>
     * 押品三级名称
     */
    private String mortgageLevelThreeName;
    
    /**
     * VARCHAR(100)<br>
     * 押品四级名称
     */
    private String mortgageLevelFourName;
    

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

	public String getMortgageLevelFourName() {
		return mortgageLevelFourName;
	}

	public void setMortgageLevelFourName(String mortgageLevelFourName) {
		this.mortgageLevelFourName = mortgageLevelFourName;
	}
    
    

}
