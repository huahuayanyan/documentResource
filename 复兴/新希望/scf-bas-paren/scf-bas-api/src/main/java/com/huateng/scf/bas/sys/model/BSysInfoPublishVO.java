package com.huateng.scf.bas.sys.model;

public class BSysInfoPublishVO extends BSysInfoPublishMng {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20)<br>
     * 发布人
     */
    private String authorTlrnoName;

	/**
	 * @return the authorTlrnoName
	 */
	public String getAuthorTlrnoName() {
		return authorTlrnoName;
	}

	/**
	 * @param authorTlrnoName the authorTlrnoName to set
	 */
	public void setAuthorTlrnoName(String authorTlrnoName) {
		this.authorTlrnoName = authorTlrnoName;
	}

}