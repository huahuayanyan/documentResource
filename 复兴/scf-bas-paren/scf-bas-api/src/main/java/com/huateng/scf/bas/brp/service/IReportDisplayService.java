/**
 * 
 */
package com.huateng.scf.bas.brp.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年5月9日下午2:15:00
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年5月9日下午2:15:00              新增
 *
 * </pre>
 */
public interface IReportDisplayService {
	
	public List<TreeModel> ReportDisplayTreeGetter(@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;
	
	// 用于页面查询返回page对象
	public Page findBBrpNoticeModelByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BBrpNoticeModel bBrpNoticeModel);

}
