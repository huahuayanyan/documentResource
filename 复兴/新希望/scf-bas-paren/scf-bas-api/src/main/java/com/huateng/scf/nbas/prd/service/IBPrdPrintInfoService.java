package com.huateng.scf.nbas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BPrdPrintInfoVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>业务品种绑定打印模板	接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月17日下午2:51:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月17日下午2:51:30	     新增
 *
 * </pre>
 */
public interface IBPrdPrintInfoService {

	/**
	 * 分页查询业务品种绑定打印模板
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdPrintInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:28:26
	 */
	public Page findBPrdPrintInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPrdPrintInfoVO") BPrdPrintInfoVO bPrdPrintInfoVO);
	
	/**
	 * 新增
	 * @param bPrdPrintInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:46:34
	 */
	public void addBPrdPrintInfo(@ScubeParam("bPrdPrintInfoVO") BPrdPrintInfoVO bPrdPrintInfoVO);
	
	/**
	 * 删除
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:27:56
	 */
	public void deleteBPrdPrintInfo(@ScubeParam("list") List<BPrdPrintInfoVO> list);

	/**
	 * 根据ID查询文件模版信息
	 * @param id
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午3:53:37
	 */
	public BPrdPrintInfoVO findBPrdPrintInfoById(@ScubeParam("id") String id);

	/**
	 * 校验同一业务品种同一调用阶段模板信息是否存在
	 * @param productId
	 * @param invokPhase
	 * @author 	mengjiajia
	 * @date 	2017年6月17日下午4:24:29
	 */
	@SuppressWarnings("rawtypes")
	public List CheckBPrdPrintInfo(@ScubeParam("productId") String productId,@ScubeParam("invokPhase") String invokPhase);

}
