/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.ArrayList;
import java.util.List;

import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月23日下午8:03:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月23日下午8:03:02	      新增
 *
 *            </pre>
 */
public interface IIfspRBcpAppliBussInfoService {

	// 新增应收账款申请转让信息（新增基本信息，再新增费用信息，再新增明细信息,改变对应的应收账款基本信息状态。）
	public RBcpAppliBussInfo addBcpAppliBussInfo(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("rBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds
			);
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(@ScubeParam("appno")String appno) throws ScubeBizException;


}
