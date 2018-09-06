/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年6月20日上午10:51:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年6月20日上午10:51:27	      新增
 *
 *            </pre>
 */
public interface IDebtInPoolService {
	public static final String BeanId = "DebtInPoolServiceImpl";

	/**
	 * 应收账款入池保存按钮
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @return
	 * @author lihao
	 * @date 2017年6月17日上午9:49:45
	 */
	public String saveOrUpdateInPoolInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 池信息修改通用方法
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @author lihao
	 * @date 2017年6月20日上午10:59:15
	 */
	public void updatePoolInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 应收账款入池申请页面提交按钮
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @author lihao
	 * @date 2017年6月17日上午9:49:04
	 */
	public void submitInPoolInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 应收账款入池首页提交按钮
	 * 
	 * @param appno
	 * @author lihao
	 * @date 2017年6月17日上午9:48:44
	 */
	public void submitInPoolInfoApply(@ScubeParam("key") String appno);

	/**
	 * 应收账款入池单据校验
	 * 
	 * @param appno
	 * @author lihao
	 * @date 2017年6月17日上午9:48:44
	 */
	public void checkInpoolDebtRulses(@ScubeParam("list") List<RBcpDebtInfoVO> ds);

	/**
	 * 出入池申请页面查询
	 * 
	 * @param appno
	 * @author lihao
	 * @date 2017年6月17日上午9:48:44
	 */
	public Page queryPoolBPbcAppliBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException;

}
