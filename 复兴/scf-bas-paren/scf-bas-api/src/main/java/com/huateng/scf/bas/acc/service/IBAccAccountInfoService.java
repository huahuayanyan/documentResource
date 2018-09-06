/**
 * 
 */
package com.huateng.scf.bas.acc.service;

import java.util.List;

import com.huateng.authority.entity.BctlVO;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.model.BAccAccountInfo;
import com.huateng.scf.bas.common.model.CustAccountQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月22日下午19:35:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年11月22日下午19:35:24                                  新增
 *
 *            </pre>
 */

public interface IBAccAccountInfoService {
	public String add(@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo);

	public String addBAccAccountInfo(@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo);

	public int batchDelete(@ScubeParam("idList") List idList);

	public int batchDeleteBAccAccountInfoByCustcd(@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo);

	public int update(@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo);

	public BAccAccountInfo findBAccAccountInfoByKey(@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo);

	public List<BAccAccountInfo> findBAccAccountInfoByBAcc(@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo);

	public Page findBAccAccountInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bAccAccountInfo") BAccAccountInfo bAccAccountInfo);

	// 调用经办机构代码查询（页面下拉菜单）
	public Page selectOrgByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("value") BctlVO bctlVO);

	/**
	 * 根据客户号查询对应帐号
	 * mengjiajia
	 */
	public Page getCustAccountListByParam(@ScubeParam("custAccountQryVO") CustAccountQryVO custAccountQryVO) throws ScubeBizException;

}
