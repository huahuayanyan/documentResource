package com.huateng.scf.bas.crm.dao;

import java.util.List;
import java.util.Map;

import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmInsureInfo;

public interface IBCrmInsureCustomerDAO {

	List<BCrmInsureInfo> queryInsureCustomerByParams(Map<String, Object> params, int pageNo, int pageSize);
	
	Integer queryInsureCustomerCount(Map<String, Object> params);

	List<BCrmBaseInfo> queryBCrmBaseInfoByParams(Map<String, Object> params, int pageNo, int pageSize);

	int queryBCrmBaseInfoCount(Map<String, Object> params);

	List<BCrmEntInfo> queryBCrmEntInfoByParams(Map<String, Object> params, int pageNo, int pageSize);

	int queryBCrmEntInfoCount(Map<String, Object> params);

}
