package com.huateng.scf.nbas.prd.service;

import com.huateng.scf.nbas.prd.model.BPrdBaseInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>产品出账方式绑定	接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月16日下午5:00:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月16日下午5:00:51	     新增
 *
 * </pre>
 */
public interface INBPrdBaseInfoService {

	/**
	 * 查询产品出账方式
	 * @param bPrdBaseInfoVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午5:18:26
	 */
	public BPrdBaseInfoVO findBPrdBaseInfoByKey(@ScubeParam("bPrdBaseInfoVO") BPrdBaseInfoVO bPrdBaseInfoVO) throws ScubeBizException;

	/**
	 * 保存产品出账方式
	 * @param bPrdBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月16日下午5:24:19
	 */
	public void saveBPrdBaseInfo(@ScubeParam("bPrdBaseInfoVO") BPrdBaseInfoVO bPrdBaseInfoVO,@ScubeParam("productId") String productId);

}
