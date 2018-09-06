/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfo;
import com.huateng.scf.bas.sys.model.BSysLnCd;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>供应链系统全局信息</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月25日下午1:59:54	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月25日下午1:59:54                新增
 * fangquan		   2017年6月17日下午2:30                                        新增
 * </pre>
 */
public interface IBSysGlobalInfoService {
	public static final String BEAN_ID = "bSysGlobalInfoService";
	/**
	 * 根据BSysGlobalInfo对象查询BSysGlobalInfo信息
	 * @param bSysGlobalInfo
	 * 		BSysGlobalInfo对象
	 * @return BSysGlobalInfo
	 * @throws ScubeBizException
	 */
	public BSysGlobalInfo queryBSysGlobalInfo(@ScubeParam("bSysGlobalInfo") BSysGlobalInfo bSysGlobalInfo) throws ScubeBizException;
	
	public Page findBSysGlobalInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("bSysGlobalInfo") BSysGlobalInfo bSysGlobalInfo);
	
	public void update(@ScubeParam("bSysGlobalInfo") BSysGlobalInfo bSysGlobalInfo);
}
