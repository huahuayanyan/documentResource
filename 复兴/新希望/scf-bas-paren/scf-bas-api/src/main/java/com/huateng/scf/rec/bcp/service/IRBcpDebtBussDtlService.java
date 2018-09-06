/**
 * 
 */
package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
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
public interface IRBcpDebtBussDtlService {
	public static final String BEAN_ID = "rBcpDebtBussDtlService";

	public String addRBcpDebtBussDtl(@ScubeParam("rBcpDebtBussDtl") RBcpDebtBussDtl rBcpDebtBussDtl);

	public int deleteRBcpDebtBussDtl(@ScubeParam("debtId") String debtId);

	public int updateRBcpDebtBussDtl(@ScubeParam("rBcpDebtBussDtl") RBcpDebtBussDtl rBcpDebtBussDtl);

	public RBcpDebtBussDtl findRBcpDebtBussDtlByKey(@ScubeParam("rBcpDebtBussDtl") RBcpDebtBussDtl rBcpDebtBussDtl);

	// public List<RBcpDebtBussDtl> findRBcpDebtBussDtlListByKey(
	// @ScubeParam("RBcpDebtBussDtl") RBcpDebtBussDtl RBcpDebtBussDtl);

	public Page findRBcpDebtBussDtlPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtBussDtl rBcpDebtBussDtl);

	public RBcpDebtBussInfo saveDebtChargeBussInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO);

	public void disputeInvoiceSetSubmit(@ScubeParam("insertDebtList") List insertDebtList,
			@ScubeParam("tblDebtBussInfo") RBcpDebtBussInfo tblDebtBussInfo, @ScubeParam("financingType") String financingType);

	public void saveDebtOutPoolInfoDtl(@ScubeParam("insertDebtList") List insertDebtList, @ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo bean);

	// 池融资商纠登记审批通过出池操作
	public void saveDebtOutPoolInfoDtl2(@ScubeParam("insertDebtList") List insertDebtList, @ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo bean);

	/**
	 * 催收申请+发票费用补录
	 * 
	 * @param list
	 * @param rBcpDebtBussInfo
	 * @throws ScubeBizException
	 */
	public void debtPressingSubmit(@ScubeParam("debtBillsInfoVOList") List<DebtBillsInfoVO> list,
			@ScubeParam("rBcpDebtBussInfo") RBcpDebtBussInfo rBcpDebtBussInfo) throws ScubeBizException;

	/**
	 * 应收账款出池流水明细新增
	 * 
	 * @param insertDebtList
	 * @param debtVO_p
	 * @throws ScubeBizException
	 */
	public void updateOutpoolInfo(@ScubeParam("insertDebtList") List<DebtBillsInfoVO> insertDebtList, @ScubeParam("debtVO") DebtBussInfoVO debtVO_p)
			throws ScubeBizException;

	/**
	 * 
	 * @param insertDebtList
	 * @param debtVO_p
	 * @throws ScubeBizException
	 */
	public void updateInpoolInfo(@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList, @ScubeParam("debtVO_p") DebtBussInfoVO debtVO_p)
			throws ScubeBizException;

	@SuppressWarnings("rawtypes")
	public void disputeInvoiceSetSubmitApp(@ScubeParam("insertDebtList") List insertDebtList, @ScubeParam("debtVO") DebtBussInfoVO debtVO)
			throws ScubeBizException;

	public void disputeInvoiceSetSubmit2(@ScubeParam("insertDebtList") List insertDebtList,
			@ScubeParam("tblDebtBussInfo") RBcpDebtBussInfo tblDebtBussInfo, @ScubeParam("financingType") String financingType);
}
