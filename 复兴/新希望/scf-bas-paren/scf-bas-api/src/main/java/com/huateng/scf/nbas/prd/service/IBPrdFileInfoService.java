package com.huateng.scf.nbas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BPrdFileInfoVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>产品合同模板	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月15日下午5:10:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月15日下午5:10:48	     新增
 *
 * </pre>
 */
public interface IBPrdFileInfoService {

	/**
	 * 分页查询该业务品种下上传文件所需类型
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdContInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月15日下午5:10:52
	 */
	public Page findBPrdFileInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPrdFileInfoVO") BPrdFileInfoVO bPrdFileInfoVO);

	/**
	 * 新增合同模板信息
	 * @param list
	 * @param productId
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午9:58:03
	 */
	public void saveBPrdFileInfo(@ScubeParam("list") List<BPrdFileInfoVO> list,@ScubeParam("productId") String productId);

	/**
	 * 删除
	 * @param list
	 * @author 	mengjiajia
	 * @date 	2017年6月16日上午10:00:41
	 */
	public void deleteBPrdFileInfoById(@ScubeParam("list") List<BPrdFileInfoVO> list);

}
