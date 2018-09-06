/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import java.util.Map;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.RoleInfoVO;
import com.huateng.base.common.beans.Page;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>公用接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月28日.下午6:05:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月28日.下午6:05:21	     新增
 *
 * </pre>
 */

public interface IBSysCommonService {

	/**业务品种筛选
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	Page selectBusinessType(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);

	/**账户筛选(结算账号,回款保证金账号,回款专户) 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	Page selectAccountNo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);

	/**经办机构
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	Page selectBranchInfo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") BctlVO bctlVO);
	
	/**合作机构
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	Page selectCooperationBranch(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") BctlVO bctlVO);
	
	/**业务品种筛选
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	Page selectBusinessTypeByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);
	
	/**
	 * 通知书类型筛选	 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page selectNoticeType(@ScubeParam("pageNo")int pageNo, @ScubeParam("pageSize")int pageSize,@ScubeParam("value")Map<String, String> value);
	/**
	 * 角色筛选
	 * @param pageNo
	 * @param pageSize
	 * @param roleInfoVO
	 * @return
	 */
	public Page selectRoleInfo(@ScubeParam("pageNo")int pageNo, @ScubeParam("pageSize")int pageSize,@ScubeParam("value")RoleInfoVO roleInfoVO);
	/**流程名称筛选
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	Page selectWKFlowByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, Object> value);

	/**
	 * 保险公司信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月13日上午11:20:28
	 */
	public Page selectBCrmBaseInfo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, Object> value) throws ScubeBizException;

}
