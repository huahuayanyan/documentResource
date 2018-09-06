package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

public interface IBMatureNoDeliveryWarnDAO {
	
	public static final String BeanId ="IBMatureNoDeliveryWarnDAO";
	
	List selectNoDeliveryWarningListByPage(Map<String, Object> params,Page page);
	
	Integer selectNoDeliveryWarningCount(Map<String, Object> params);

}
