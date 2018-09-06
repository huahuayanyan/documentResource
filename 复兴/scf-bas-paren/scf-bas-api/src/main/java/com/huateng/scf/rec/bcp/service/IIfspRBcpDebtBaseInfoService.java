/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.ArrayList;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月7日上午9:58:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月7日上午9:58:43              新增
 *
 *            </pre>
 */
public interface IIfspRBcpDebtBaseInfoService {
	public Page getDebtInfoForFinace(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContno") String mastContno);






}
