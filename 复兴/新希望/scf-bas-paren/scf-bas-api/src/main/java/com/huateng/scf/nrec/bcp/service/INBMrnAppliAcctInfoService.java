package com.huateng.scf.nrec.bcp.service;

import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface INBMrnAppliAcctInfoService {
	
	public static final String BEAN_ID = "NBMrnAppliAcctInfoServiceImpl";

	/**
	* 
	* @param appno
	* @throws ScubeBizException
	* @author 	Qinwei
	* @date 	2017年6月2日 下午4:52:32
	*/
	public void clearTblAppliCustAccountInfo(@ScubeParam("appno") String appno)throws ScubeBizException;

	/**
	* 
	* @param bMrnAppliAcctInfo
	* @author 	Qinwei
	* @date 	2017年6月2日 下午4:52:28
	*/
	public void add(@ScubeParam("bMrnAppliAcctInfo") BMrnAppliAcctInfo bMrnAppliAcctInfo); 
}
