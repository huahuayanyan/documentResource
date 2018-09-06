package com.huateng.scf.bas.brp.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpFileParamVO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>文件模板	接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月16日下午5:01:15
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月16日下午5:01:15	     新增
 *
 * </pre>
 */
public interface IBBrpFileParamService {

	/**
	 * 分页查询合同模版列表
	 * @param pageNo
	 * @param pageSize
	 * @param bBrpFileParamVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月17日上午11:49:53
	 */
	public Page findBBrpFileParamByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bBrpFileParamVO") BBrpFileParamVO bBrpFileParamVO);

	/**
	 * 新增
	 * @param bBrpFileParamVO
	 * @author 	mengjiajia
	 * @date 	2017年6月17日上午11:50:34
	 */
	public void addBBrpFileParam(@ScubeParam("bBrpFileParamVO") BBrpFileParamVO bBrpFileParamVO);

	/**
	 * 修改
	 * @param bBrpFileParamVO
	 * @author 	mengjiajia
	 * @date 	2017年6月17日上午11:50:41
	 */
	public void updateBBrpFileParam(@ScubeParam("bBrpFileParamVO") BBrpFileParamVO bBrpFileParamVO);

}
