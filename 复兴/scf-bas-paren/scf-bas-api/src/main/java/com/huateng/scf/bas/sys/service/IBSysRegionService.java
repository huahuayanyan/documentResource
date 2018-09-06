/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.model.BSysRegion;
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
public interface IBSysRegionService {

	/*
	 * public int delete(@ScubeParam("industryCode") String industryCode);
	 * 
	 * public int update(@ScubeParam("bSysRegion") BSysRegion bSysRegion);
	 * 
	 * public BSysRegion findBSysRegionByKey(@ScubeParam("bSysRegion")
	 * BSysRegion bSysRegion);
	 */
	public String add(@ScubeParam("bSysRegion") BSysRegion bSysRegion);

	public List<BSysRegion> findBSysRegionByBCrm(@ScubeParam("bSysRegion") BSysRegion bSysRegion);

	// 用于页面下拉菜单查询
	public Page findBSysRegionByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BSysRegion bSysRegion);

}
