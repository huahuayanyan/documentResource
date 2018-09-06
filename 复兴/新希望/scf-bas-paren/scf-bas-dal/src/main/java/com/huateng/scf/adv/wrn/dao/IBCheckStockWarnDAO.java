package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStock;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStockVO;

/**
 * @author htrad0055
 *对账不平预警列表
 */
public interface IBCheckStockWarnDAO {
	
	public static final String BeanId ="BCheckStockWarnDAOImpl";

	/**
	 * 分页查询对账不平预警列表
	 * @param params
	 * @param page
	 * @return
	 */
	List<BWanCheckStockVO> findCheckStockWarnByPage(Map<String, Object> params, Page page);

	/**
	 * 查询对账不平预警的个数
	 * @param params
	 * @return
	 */
	Integer findCheckStockWarnCount(Map<String, Object> params);
	

}
