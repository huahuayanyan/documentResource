/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;

/**
 *  在这里添加类的文档注释
 *
 * @author <a href="mailto:Administrator@topscf.com">Administrator</a>
 *
 * @version Revision: 1.0  Date: 2013-9-12 下午07:26:47
 *
 */

public class BillStandardMortgageBaseVO extends BPbcMtgBaseInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
