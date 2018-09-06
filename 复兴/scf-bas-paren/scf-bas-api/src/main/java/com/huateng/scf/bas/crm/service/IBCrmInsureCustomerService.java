package com.huateng.scf.bas.crm.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.model.BAccAccountInfo;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmBrInfo;
import com.huateng.scf.bas.crm.model.CustomerQryVO;
import com.huateng.scf.bas.crm.model.CustomerVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmInsureCustomerService {
	
	Page findInsureCustomerByPage(@ScubeParam("customerQryVO") CustomerQryVO customerQryVO,
			@ScubeParam("pageNo")int pageNo,@ScubeParam("pageSize")int pageSize)throws ScubeBizException;
	
	/**
	 * @return
	 */
	String generateCcmsCustcd() throws ScubeBizException;

	/**
	 * @param customerVO
	 * @return
	 */
	CustomerVO addOrUpdateCustomer(@ScubeParam("customerVO") CustomerVO customerVO) throws ScubeBizException;
	
	
	/**
	 * @return
	 */
	public CustomerVO findCustomerInfoDetails(@ScubeParam("customerQryVO") CustomerQryVO customerQryVO);
	
	
	
	/**
	 * @param bCrmBaseInfo
	 * @return
	 */
	public BCrmBaseInfo findBCrmBaseInfoByKey(@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);
	
	
	/**
	 * @param bCrmBaseInfo
	 * @return
	 */
	public CustomerVO findCustomerInfoByKey(@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);

	/**
	 * @param bCrmBrInfoVO
	 * @return
	 */
	BAccAccountInfo findBAccAccountInfo();

	/**
	 * @param acctInfo
	 * @return
	 */
	String addOrUpdateBaccAcct(@ScubeParam("bAccAccountInfo") BAccAccountInfo acctInfo) throws ScubeBizException;

}
