/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.List;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年5月23日下午9:18:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年5月23日下午9:18:45	      新增
 *
 *            </pre>
 */
public interface ITransferApplyService {
	/**
	 * 应收账款转让保存按钮
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @return
	 * @author lihao
	 * @date 2017年6月17日上午9:49:45
	 */
	public String saveOrUpdateTransferInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 应收账款转让保存按钮
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @author lihao
	 * @date 2017年6月17日上午9:49:32
	 */
	public void updateTransferInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 应收账款转让申请页面提交按钮
	 * 
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @author lihao
	 * @date 2017年6月17日上午9:49:04
	 */
	public void submitTransferInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 应收账款转让首页提交按钮
	 * 
	 * @param appno
	 * @author lihao
	 * @date 2017年6月17日上午9:48:44
	 */
	public void submitTransferApply(@ScubeParam("key") String appno);

	/**
	 * 单据查重校验
	 * 
	 * @param ds
	 * @author mengjiajia
	 * @date 2017年6月17日上午9:49:59
	 */
	public void checkDebtRule(@ScubeParam("list") List<RBcpAppliBussDtl> ds);

	/**
	 * 上传单据规则校验
	 * 
	 * @param ds
	 * @return
	 * @author lihao
	 * @date 2017年6月28日上午11:21:24
	 */
	public Object checkUploadDebtListRule(@ScubeParam("list") List<RBcpDebtInfoVO> ds, @ScubeParam("key") String key);

	/**
	 * 任务基本信息
	 * @param appno
	 * @param factType
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月28日上午11:15:36
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);
}
