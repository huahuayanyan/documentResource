/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import com.huateng.scf.rec.bcp.model.RBcpAppliCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月24日下午3:34:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月24日下午3:34:45	      新增
 *
 *            </pre>
 */
public interface INRBcpAppliCostOutService {
	public static final String BEAN_ID = "rBcpAppliCostOutService";

	// 查询具体应收账款业务申请费用基本信息表
	public RBcpAppliCostOut findRBcpAppliCostOutByKey(@ScubeParam("rBcpAppliCostOut") RBcpAppliCostOut rBcpAppliCostOut);

	public void addRBcpAppliCostOut(@ScubeParam("rBcpAppliCostOut") RBcpAppliCostOut rBcpAppliCostOut) throws ScubeBizException;

	public void updateRBcpAppliCostOut(@ScubeParam("rBcpAppliCostOut") RBcpAppliCostOut rBcpAppliCostOut) throws ScubeBizException;

}
