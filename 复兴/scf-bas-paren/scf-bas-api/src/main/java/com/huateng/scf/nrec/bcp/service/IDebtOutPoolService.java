/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年6月20日上午10:52:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年6月20日上午10:52:01	      新增
 *
 *            </pre>
 */
public interface IDebtOutPoolService {
	public static final String BeanId = "DebtOutPoolServiceImpl";

	/**
	 * 应收账款出池保存按钮
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @return
	 * @author lihao
	 * @date 2017年6月17日上午9:49:45
	 */
	public String saveOrUpdateOutPoolInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 应收账款出池申请页面提交按钮
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @author lihao
	 * @date 2017年6月17日上午9:49:04
	 */
	public void submitOutPoolInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 应收账款出池首页提交按钮
	 * 
	 * @param appno
	 * @author lihao
	 * @date 2017年6月17日上午9:48:44
	 */
	public void submitOutPoolInfoApply(@ScubeParam("key") String appno);

	/**
	 * 应收账款出池单据校验
	 * 
	 * @param appno
	 * @author lihao
	 * @date 2017年6月17日上午9:48:44
	 */
	public void checkOutpoolDebtRulses(@ScubeParam("list") List<RBcpDebtInfoVO> ds);

}
