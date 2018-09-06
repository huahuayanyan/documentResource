package com.huateng.scf.bas.sys.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.authority.entity.RoleInfoVO;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.model.BSysQueryLimitsVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>数据查询权限非配</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月10日上午10:24:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月10日上午10:24:13	     新增
 *
 * </pre>
 */
public interface IBSysQueryLimitsService {

	/**
	 * 查询角色列表
	 * @param pageNo
	 * @param pageSize
	 * @param roleInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月10日上午11:50:02
	 */
	public Page findRoleInfoAndLimitsByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("roleInfoVO") RoleInfoVO roleInfoVO);

	/**
	 * 保存角色查询权限
	 * @param bSysQueryLimitsVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月10日上午11:52:27
	 */
	public void saveQueryLimits(@ScubeParam("bSysQueryLimitsVO") BSysQueryLimitsVO bSysQueryLimitsVO) throws ScubeBizException;

	/**
	 * 根据数据查询权限获取不同权限信息
	 * @param tlrNo
	 * @param brNo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月10日下午3:05:37
	 */
	public HashMap<String, List<String>> getTlrNoListByRoleModel();

}
