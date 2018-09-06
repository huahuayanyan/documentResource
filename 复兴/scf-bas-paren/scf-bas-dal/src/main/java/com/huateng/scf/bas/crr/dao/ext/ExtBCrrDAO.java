package com.huateng.scf.bas.crr.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;

public interface ExtBCrrDAO {
	/**
	 * 查询客户信息
	 * @param omap
	 * @param page
	 * @return
	 */
	List<HashMap<String, String>> queryCustSource(Map<String, String> omap, Page page);
	/**
	 * 查询担保人信息
	 * @param omap
	 * @param page
	 * @return
	 */
	List<HashMap<String, String>> queryCrnoSource(Map<String, String> omap, Page page);
	/**
	 * 查询贷款合同信息
	 * @param omap
	 * @param page
	 * @return
	 */
	List<HashMap<String, String>> queryLnConSource(Map<String, String> omap, Page page);
	/**
	 * 查询业务品种信息
	 * @param omap
	 * @param page
	 * @return
	 */
	List<HashMap<String, String>> queryPrdMdSource(Map<String, String> omap, Page page);
	/**
	 * 查询利率信息
	 * @param omap
	 * @param page
	 * @return
	 */
	List<HashMap<String, String>> queryLnSource(Map<String, String> omap, Page page);
	/**
	 * 根据合同号查询出账信息
	 * @param appId
	 * @return
	 */
	BCrrDuebillApp selectByAppId(String appId);
	/**
	 * 查询业务申请关联担保合同数
	 * @param omap
	 * @return
	 */
	int countAppByExample(HashMap<String, String> omap);
	/**
	 * 查询信贷合同关联担保合同数
	 * @param omap
	 * @return
	 */
	int countConByExample(HashMap<String, String> omap);
	/**
	 * 查询业务申请关联担保合同信息
	 * @param omap
	 * @param page
	 * @return
	 */
	List<BCrrGntyCon> selectAppByPage(HashMap<String, String> omap, Page page);
	/**
	 * 查询信贷合同关联担保合同列表
	 * @param omap
	 * @param page
	 * @return
	 */
	List<BCrrGntyCon> selectConByPage(HashMap<String, String> omap, Page page);
	/**
	 * 根据指定条件查询主合同
	 * @param omap
	 * @param page
	 * @return
	 */
	List<BCrrGntyCon> getMastContByPara(HashMap<String, Object> omap, Page page);
	/**
	 * 根据指定条件查询主合同个数
	 * @param omap
	 * @return
	 */
	int countMastContByPara(HashMap<String, Object> omap);
	/**
	 * 担保合同下拉选择列表
	 * @param omap
	 * @return
	 */
	int countContSlaveBaseInfo(HashMap<String, Object> omap);
	/**
	 * 担保合同下拉选择列表总数
	 * @param omap
	 * @param page
	 * @return
	 */
	List<BCrrGntyCon> getContSlaveBaseInfo(HashMap<String, Object> omap, Page page);
	/**
	 * 存货类抵质押合同查询总数
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月12日上午11:14:42
	 */
	int countBCrrGntyConForCHL(HashMap<String, Object> omap);
	/**
	 * 存货类抵质押合同查询列表
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月12日上午11:15:55
	 */
	List<BCrrGntyCon> findBCrrGntyConForCHL(HashMap<String, Object> omap, Page page);
	/**
	 * 根据出质人查询质押合同编号列表个数
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午3:47:46
	 */
	int countSlaveContnoByPageForCHL(HashMap<String, Object> omap);
	/**
	 * 根据出质人查询质押合同编号列表
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月13日下午3:47:50
	 */
	List<BCrrGntyCon> findSlaveContnoByPageForCHL(HashMap<String, Object> omap, Page page);
	
	/**
	 * 查询抵质押合同列表个数
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午1:34:16
	 */
	int countSlaveContList(HashMap<String, Object> omap);
	
	/**
	 * 查询抵质押合同列表
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午1:34:53
	 */
	@SuppressWarnings("rawtypes")
	List getSlaveContList(HashMap<String, Object> omap, Page page);
}
