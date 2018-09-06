/**
 * 
 */
package com.huateng.scf.bas.brp.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpCostParam;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月3日 上午11:36:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年12月3日 上午11:36:29	                                    新增
 *
 *            </pre>
 */

public interface IBBrpCostParamService {
	public static final String BEAN_ID = "bBrpCostParamService";
	
	public String add(@ScubeParam("bBrpCostParam") BBrpCostParam bBrpCostParam);

	public int delete(@ScubeParam("id") String id);

	public int update(@ScubeParam("bBrpCostParam") BBrpCostParam bBrpCostParam);


	// 查找具体费用信息
	public BBrpCostParam findBBrpCostParamByKey(@ScubeParam("bBrpCostParam") BBrpCostParam bBrpCostParam);

	// 用于页面查询返回page对象
	public Page findBBrpCostParamByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BBrpCostParam bBrpCostParam);
}
