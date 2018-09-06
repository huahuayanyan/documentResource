package com.huateng.scf.rec.bcp.service;

import java.math.BigDecimal;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.model.ExtInterface;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface InterfaceButtonQueryService {

	/**
	* 
	* @param extInterface
	* @return
	* @throws ScubeBizException
	* @author 	Qinwei
	* @date 	2017年6月1日 下午7:21:10
	*/
	public Page InterfaceButtonQuery(@ScubeParam("extInterface") ExtInterface extInterface) throws ScubeBizException;
	
	
	/**
	* 
	* @param returnAccount
	* @return
	* @throws ScubeBizException
	* @author 	Qinwei
	* @date 	2017年6月1日 下午7:21:14
	*/
	public BigDecimal getAmountFromRaccount(@ScubeParam("returnAccount")String returnAccount) throws ScubeBizException;

}
