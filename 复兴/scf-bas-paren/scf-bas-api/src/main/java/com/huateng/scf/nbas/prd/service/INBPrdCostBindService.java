package com.huateng.scf.nbas.prd.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BPrdCostBindVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>产品费用绑定	接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月16日上午10:30:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月16日上午10:30:48	     新增
 *
 * </pre>
 */
public interface INBPrdCostBindService {

	/**
	 * 分页查询产品费用信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdCostBindVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午10:54:08
	 */
	public Page findBPrdCostBindByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPrdCostBindVO") BPrdCostBindVO bPrdCostBindVO);

	/**
	 * 保存产品费用信息
	 * @param list
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午11:21:25
	 */
	public void saveBPrdCostBind(@ScubeParam("list") List<BPrdCostBindVO> list,@ScubeParam("productId") String productId);

	/**
	 * 修改产品费用信息
	 * @param bPrdCostBindVO
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午11:27:59
	 */
	public void updateBPrdCostBind(@ScubeParam("bPrdCostBindVO") BPrdCostBindVO bPrdCostBindVO);

	/**
	 * 删除产品费用信息
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午11:29:29
	 */
	public void deleteBPrdCostBindByKey(@ScubeParam("list") List<BPrdCostBindVO> list);

	/**
	 * 根据productId和costPhase查询业务品种费用信息
	 * @param productId
	 * @param costPhase
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午1:29:24
	 */
	public List<?> findBPrdCostInfoByProductIdAndCostPhase(@ScubeParam("omap") HashMap<String, Object> omap);

	/**
	 * 删除调用阶段为空的绑定费用信息信息
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月24日上午10:13:57
	 */
	public void deleteBPrdCostBindByExample(@ScubeParam("productId") String productId);

}
