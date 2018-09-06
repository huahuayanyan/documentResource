/**
 * 
 */
package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月7日上午9:59:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月7日上午9:59:07              新增
 *
 *            </pre>
 */
public interface INRBcpDebtBussDtlService {

	public String addRBcpDebtBussDtl(@ScubeParam("rBcpDebtBussDtl") RBcpDebtBussDtl rBcpDebtBussDtl);

	public int deleteRBcpDebtBussDtl(@ScubeParam("debtId") String debtId);

	public int updateRBcpDebtBussDtl(@ScubeParam("rBcpDebtBussDtl") RBcpDebtBussDtl rBcpDebtBussDtl);

	public Page findRBcpDebtBussDtlPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("rBcpDebtBussDtl") RBcpDebtBussDtl rBcpDebtBussDtl);


	// 池融资商纠登记审批通过出池操作
	@SuppressWarnings("rawtypes")
	public void saveDebtOutPoolInfoDtl(@ScubeParam("insertDebtList") List insertDebtList, @ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo bean)
			throws ScubeBizException;

	@SuppressWarnings("rawtypes")
	public void disputeInvoiceSetSubmit(@ScubeParam("list") List insertDebtList, @ScubeParam("tblDebtBussInfo") RBcpDebtBussInfo tblDebtBussInfo,
			@ScubeParam("financingType") String financingType) throws ScubeBizException;

	/**
	 * 催收申请+发票费用补录
	 * @param list
	 * @param rBcpDebtBussInfo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日下午3:01:09
	 */
	public void debtPressingSubmit(@ScubeParam("list") List<NDebtBillsInfoVO> list,@ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo rBcpDebtBussInfo) throws ScubeBizException;

	/**
	 * 根据APPNO查询流水明细表
	 * @param appno
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午2:53:49
	 */
	@SuppressWarnings("rawtypes")
	public List queryDebtBussDetailByBillsNo(@ScubeParam("appno") String appno,@ScubeParam("debtId") String debtId) throws ScubeBizException;

}
