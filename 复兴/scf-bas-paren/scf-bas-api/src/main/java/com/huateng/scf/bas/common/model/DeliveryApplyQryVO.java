/*
 * 功  能：简单说明该类的功能
 * 
 * 文件名：DeliveryApplyQryVO.java
 * 
 * 描  述：
 * 
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2013-5-10   topcheer   hjf      create
 * -----------------------------------------------------------------------------
 *
 *
 * Copyright (c) 2013 topcheer All Rights Reserved.
 *┌─────────────────────────────────────────────────—────┐
 *│ 版权声明                               topcheer      │
 *└──────────────────────────────—————————————————————───┘
 */

package com.huateng.scf.bas.common.model;


/**
 * 
 * 在这里添加类的文档注释
 * 
 * @author <a href="mailto:jianfeng.huang@topscf.com">jianfeng.huang</a>
 *
 * @version Revision: 1.0  Date: 2013-5-18 下午3:15:02 
 *
 */

public class DeliveryApplyQryVO extends CommonQryVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role_Q;

	public String getRole_Q() {
		return role_Q;
	}

	public void setRole_Q(String role_Q) {
		this.role_Q = role_Q;
	}
}
