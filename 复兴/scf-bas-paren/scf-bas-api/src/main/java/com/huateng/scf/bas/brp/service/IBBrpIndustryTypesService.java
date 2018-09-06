/**
 * 
 */
package com.huateng.scf.bas.brp.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpIndustryTypes;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月21日 下午17:10:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年11月21日 下午17:10:24	                                    新增
 *
 *            </pre>
 */
// 查询只根据行业代码条件查询，给的条件为空，则返回所有数据。BBrpIndustryTypesServiceImpl
public interface IBBrpIndustryTypesService {

	public String add(@ScubeParam("bBrpIndustryTypes") BBrpIndustryTypes bBrpIndustryTypes);

	public int delete(@ScubeParam("industryCode") String industryCode);

	public int update(@ScubeParam("bBrpIndustryTypes") BBrpIndustryTypes bBrpIndustryTypes);

	public BBrpIndustryTypes findBBrpIndustryTypesByKey(
			@ScubeParam("bBrpIndustryTypes") BBrpIndustryTypes bBrpIndustryTypes);

	// 页面下拉菜单（根据行业代码,行业名称和industryLevel类别级别）
	public Page findBBrpIndustryTypesTree(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BBrpIndustryTypes bBrpIndustryTypes);

	public Page findBBrpIndustryTypesByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bBrpIndustryTypes") BBrpIndustryTypes bBrpIndustryTypes);

}
