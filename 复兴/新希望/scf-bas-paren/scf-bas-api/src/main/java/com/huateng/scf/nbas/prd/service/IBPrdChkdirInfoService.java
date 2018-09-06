package com.huateng.scf.nbas.prd.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BPrdChkdirInfoVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>业务品种风险拦截模型绑定	接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月23日下午4:00:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月23日下午4:00:43	     新增
 *
 * </pre>
 */
public interface IBPrdChkdirInfoService {

	/**
	 * 根据业务品种查询各调用阶段风险拦截信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdChkdirInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:06:28
	 */
	public Page findBPrdChkdirInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPrdChkdirInfoVO") BPrdChkdirInfoVO bPrdChkdirInfoVO);

	/**
	 * 保存风险拦截模版信息
	 * @param list
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:09:15
	 */
	public void saveBPrdChkdirInfo(@ScubeParam("list") List<BPrdChkdirInfoVO> list,@ScubeParam("productId") String productId);

	/**
	 * 修改风险拦截模型绑定信息
	 * @param bPrdChkdirInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:12:35
	 */
	public void updateBPrdChkdir(@ScubeParam("bPrdChkdirInfoVO") BPrdChkdirInfoVO bPrdChkdirInfoVO);

	/**
	 * 删除绑定风险拦截模型信息
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:14:07
	 */
	public void deleteBPrdChkdirInfoByKey(@ScubeParam("list") List<BPrdChkdirInfoVO> list);

	/**
	 * 根据业务品种及调用阶段查询风险拦截模型信息
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午4:29:08
	 */
	public BPrdChkdirInfoVO findBPrdChkdirInfoByParam(@ScubeParam("omap") HashMap<String, Object> omap);

	/**
	 * 删除调用阶段为空的风险拦截模型信息
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月23日下午5:26:28
	 */
	public void deleteBPrdChkdirByExample(@ScubeParam("productId") String productId);
}
