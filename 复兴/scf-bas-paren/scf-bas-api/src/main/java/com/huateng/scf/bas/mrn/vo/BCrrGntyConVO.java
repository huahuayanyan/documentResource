package com.huateng.scf.bas.mrn.vo;

import com.huateng.scf.bas.crr.model.BCrrGntyCon;
/**
 * 
 * <p>BCrrGntyCon实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月24日下午3:29:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午3:29:12	     新增
 *
 * </pre>
 */
public class BCrrGntyConVO extends BCrrGntyCon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appno;

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}
	
}