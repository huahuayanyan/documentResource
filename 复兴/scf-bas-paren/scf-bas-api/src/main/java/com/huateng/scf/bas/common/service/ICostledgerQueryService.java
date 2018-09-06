package com.huateng.scf.bas.common.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.CostQryVO;
import com.huateng.scf.rec.bcp.model.RBcpCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>费用信息管理接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月17日上午9:05:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月17日上午9:05:13	     新增
 *
 * </pre>
 */
public interface ICostledgerQueryService {
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public Page CostledgerQueryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("costQryVO") CostQryVO costQryVO) throws ScubeBizException;

	/**
	 * 
	 * @return
	 * @throws ScubeBizException
	 */
	public HashMap<String, String> addCostOut() throws ScubeBizException;
	/**
	 * 
	 * @param debtValue
	 * @return
	 * @throws ScubeBizException
	 */
	public Page DebtContDropDownGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 */
	public Page AccountDropDownSelectGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;

	public void CostInfoRecordUpdate(@ScubeParam("bcpCostOut") RBcpCostOut bcpCostOut) throws ScubeBizException;
}
