/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.model;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 	额度处理金额字段映射
 * </p>
 *
 * @author huangshuidan
 * @date 2017年1月17日 下午4:49:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年1月17日下午4:49:56             新增
 *
 * </pre>
 */
public class CreditOptFieldMap {

	public static final Map<String, String> fieldMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("00", "riskAmount"); // 00 敞口金额
			put("01", "bussAmount"); // 01 业务金额
		}
	};
}
