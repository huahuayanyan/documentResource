package com.huateng.scf.nbas.prd.dao.ext;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdCostInfoDO;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdFileInfoDO;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfo;

public interface ExtNBPrdDAO {

	/**
	 * 分页查询业务品种对应合同类型数量
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午9:19:55
	 */
	int countBPrdFileInfoByPage(HashMap<String, Object> omap);

	/**
	 * 分页查询业务品种对应合同类型
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午9:20:19
	 */
	List<BPrdFileInfoDO> findBPrdFileInfoByPage(HashMap<String, Object> omap, Page page, boolean flag);

	/**
	 * 分页查询业务品种对应打印模板数量
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午2:58:37
	 */
	int countBPrdPrintInfoByPage(HashMap<String, Object> omap);

	/**
	 * 分页查询业务品种对应打印模板
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午2:59:02
	 */
	List<BPrdPrintInfo> findBPrdPrintInfoByPage(HashMap<String, Object> omap, Page page);

	/**
	 * 查询业务品种费用绑定信息
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月19日上午11:12:01
	 */
	List<BPrdCostInfoDO> queryProductCost(HashMap<String, Object> omap);
   
}