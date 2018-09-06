package com.huateng.scf.bas.sys.service;

import java.util.Map;

import com.huateng.scf.bas.sys.dao.model.ChkResult;

/**
 * @author HTRAD0055 风险检查回调类
 */
public abstract class SysChkCallService {
	// 执行成功
	protected final String SUCCESS = "1";
	// 执行失败
	protected final String ERROR = "2";

	public String getSUCCESS() {
		return SUCCESS;
	}

	public String getERROR() {
		return ERROR;
	}

	/**
	 * 
	 * 需要实现的方法，写业务逻辑
	 * 
	 * @param chkMap
	 *            检查对象map
	 * @param chkResult
	 *            返回结果描述
	 */
	public abstract void doWork(Map chkMap, ChkResult chkResult);

}
