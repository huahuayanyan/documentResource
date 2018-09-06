package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.DownLowPriceNewQryVO;

public interface IBOverMoniLimitWrnDAO {
	
	public static final String BeanId ="IBOverMoniLimitWrnDAO";

	List findOverMoniLimitWrnListByPage(Map<String, Object> params, Page page);

	Integer findOverMoniLimitWrnCount(Map<String, Object> params);

	

}
