package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

/**
 * @author htrad0055
 *	未收款确认预警查询
 */
public interface IBNoConfirmPayWarnDAO {
	
	public static final String BeanId ="IBNoConfirmPayWarnDAO";
	
	/**
	 * 分页查询获取未收款确认预警列表
	 * @param params
	 * @param page
	 * @return
	 */
	List queryNoConfirmPayWarnListByPage(Map<String, Object> params,Page page);
	
	/**
	 * 查询获取未收款确认预警列表条目数
	 * @param params
	 * @return
	 */
	Integer queryNoConfirmPayWarnListCount(Map<String, Object> params);

}
