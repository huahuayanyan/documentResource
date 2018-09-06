package com.huateng.scf.nbas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BPrdFileInfoVO;
import com.huateng.scf.nbas.prd.model.BPrdInfoVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>产品基本信息	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月15日下午3:01:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月15日下午3:01:04	     新增
 *
 * </pre>
 */
public interface INBPrdInfoService {

	/**
	 * 分页查询产品列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月15日下午3:19:58
	 */
	public Page findBPrdInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPrdInfoVO") BPrdInfoVO bPrdInfoVO);

	public void addBPrdInfo(@ScubeParam("bPrdInfoVO") BPrdInfoVO bPrdInfoVO,@ScubeParam("list") List<BPrdFileInfoVO> list);

	public void updateBPrdInfo(@ScubeParam("bPrdInfoVO") BPrdInfoVO bPrdInfoVO);

}
