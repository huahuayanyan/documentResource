package com.huateng.scf.adv.fcs.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

public interface IInspectWhseMngDAO {
	
	/**
	 *核库信息查询列表
	 */
	List<Map<String,Object>> queryCheckStockByPage(Map<String,Object> param, Page page);
	
	/**
	 *待选抵质押合同查询
	 */
	List<Map<String,Object>> queryPclInfoByPage(Map<String,Object> param, Page page);
	
	/**
	 *查询详情页面
	 */
	List<Map<String,Object>> queryCekStkDetailById(Map<String,Object> param, Page page);
	
	/**
	 *获取总数量总金额
	 */
	Map<String,Object> getMortgageSumCountPriceByParam(Map<String,Object> param);
	
	/**
	 *查询库存押品信息
	 */
	List<Map<String, Object>> queryMortInfo(Map<String,Object> param, Page page);
	
	/**
	 *查询巡库押品信息
	 */
	List<Map<String, Object>> queryInspectMortInfo(Map<String,Object> param, Page page);
}
