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
 * @date 2017年5月31日上午11:27:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年5月31日上午11:27:30	      新增
 *
 *            </pre>
 */
public interface IDisputeRegisterService {
	/**
	 * 商纠登记申请页面保存按钮
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @return
	 * @throws ScubeBizException
	 * @author 	lihao
	 * @date 	2017年7月17日上午10:55:41
	 */
	public String saveOrUpdateDisputeRegisterInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("list") ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException;

	/**
	 * 商纠登记保存修改方法
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @throws ScubeBizException
	 * @author 	lihao
	 * @date 	2017年7月17日上午10:55:51
	 */
	public void updateDisputeRegisterInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("list") ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException;
	/**
	 * 商纠登记申请页面提交按钮
	 * @param rBcpAppliBussInfo
	 * @param ds
	 * @throws ScubeBizException
	 * @author 	lihao
	 * @date 	2017年7月17日上午10:56:01
	 */
	public void submitDisputeRegisterInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("list") ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException;

	/**
	 * 商纠登记首页提交按钮
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	lihao
	 * @date 	2017年7月17日上午10:56:10
	 */
	public void submitDisputeRegisterInfoApply(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 任务基本信息
	 * @param appno
	 * @param factType
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月29日上午11:07:33
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);

}
