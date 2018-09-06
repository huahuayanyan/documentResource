package com.huateng.scf.nbas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BPrdWarnBindVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>产品风险预警绑定	接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月16日下午5:00:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月16日下午5:00:29	     新增
 *
 * </pre>
 */
public interface INBPrdWarnBindService {

	/**
	 * 分页查询产品风险预警列表
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdWarnBindVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午2:28:58
	 */
	public Page findBPrdWarnBindByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPrdWarnBindVO") BPrdWarnBindVO bPrdWarnBindVO);

	/**
	 * 保存产品风险预警信息
	 * @param list
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午2:33:36
	 */
	public void saveBPrdWarnBind(@ScubeParam("list") List<BPrdWarnBindVO> list,@ScubeParam("productId") String productId);
	
	/**
	 * 新增预警绑定信息
	 * @param bPrdWarnBindVO
	 * @author 	mengjiajia
	 * @date 	2017年6月24日下午12:24:34
	 */
	void addBPrdWarnBind(@ScubeParam("bPrdWarnBindVO") BPrdWarnBindVO bPrdWarnBindVO);

	/**
	 * 删除风险预警信息
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午2:34:48
	 */
	public void deleteBPrdWarnBindByKey(@ScubeParam("list") List<BPrdWarnBindVO> list);

}
