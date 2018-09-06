/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.ArrayList;

import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年6月5日下午3:38:47
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年6月5日下午3:38:47	      新增
 *
 *            </pre>
 */
public interface IDisputeRemoveService {
	// 商纠登记解除申请页面保存按钮
	public String saveOrUpdateDisputeRemoveInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("list") ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException;

	// 商纠登记解除申请页面提交按钮
	public void submitDisputeRemoveInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo, @ScubeParam("list") ArrayList<RBcpAppliBussDtl> ds)
			throws ScubeBizException;

	// 商纠登记解除首页提交按钮
	public void submitDisputeRemoveInfoApply(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 任务基本信息
	 * @param appno
	 * @param factType
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月29日上午11:11:43
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);
}
