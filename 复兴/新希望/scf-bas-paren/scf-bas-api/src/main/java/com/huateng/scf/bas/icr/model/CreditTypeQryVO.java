/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.icr.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 *  额度品种查询
 *
 * @author <a href="mailto:wenkui.xu@huateng.com">michael</a>
 *
 * @version Revision: 1.0  Date: 2013-7-16 上午11:57:00
 *
 */

public class CreditTypeQryVO  extends CommonQryVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id_Q;
	private String creditType_Q;
	private String creditClass_Q;
	
	public String getCreditType_Q() {
		return creditType_Q;
	}

	public void setCreditType_Q(String creditType_Q) {
		this.creditType_Q = creditType_Q;
	}

	public String getCreditClass_Q() {
		return creditClass_Q;
	}

	public void setCreditClass_Q(String creditClass_Q) {
		this.creditClass_Q = creditClass_Q;
	}

	public String getId_Q() {
		return id_Q;
	}

	public void setId_Q(String id_Q) {
		this.id_Q = id_Q;
	}
}
