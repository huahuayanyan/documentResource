package com.huateng.scf.bas.crm.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;

public interface IBCrmCustomerDAO {
	
	public List<BCrmBaseInfo> queryContDebtInfoByBuyercustcd(Map<String, Object> params,int pageSize,int pageNo);
	
	public Integer queryContDebtCountByBuyercustcd(Map<String, Object> params);

	public List selectFlcCustomerListByPage(Map<String, Object> params, Page page);

	public int selectFlcCustomerCount(Map<String, Object> params);
	

}
