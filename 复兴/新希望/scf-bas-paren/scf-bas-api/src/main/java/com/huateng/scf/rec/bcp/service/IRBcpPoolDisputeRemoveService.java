package com.huateng.scf.rec.bcp.service;

import java.util.ArrayList;

import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpPoolDisputeRemoveService {
	public static final String BEAN_ID = "rBcpPoolDisputeRemoveService";

	/**
	 * 保存或者修改池融资纠纷解除申请信息（对应页面保存按钮）
	 * 
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public RBcpAppliBussInfo PoolDisputeRemoveApplySaveUpdate(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("rBcpDebtBussDtl") ArrayList<RBcpDebtBussDtl> ds,
			@ScubeParam("processModel") ProcessModel processModel) throws ScubeBizException;

	public void addDisputInvoiceRemoveBussInfo(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("rBcpDebtBussDtl") ArrayList<RBcpDebtBussDtl> ds, @ScubeParam("appno") String appno)
					throws ScubeBizException;

	public void UpdateDebtAppliBussInfo(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("rBcpDebtBussDtl") ArrayList<RBcpDebtBussDtl> ds, @ScubeParam("appno") String appno)
					throws ScubeBizException;

	// 页面删除按钮(将对应的应收账款基本信息解锁)
	public void deleteRBcpDebt(@ScubeParam("rBcpDebtBussDtl") RBcpDebtBussDtl rBcpDebtBussDtl) throws ScubeBizException;

	/**
	 * 保存或者修改池融资纠纷解除申请信息（对应页面提交按钮）
	 * 
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	void DisputeInvoiceRemoveApplyWriteSubmitUpdate(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("rBcpDebtBussDtl") ArrayList<RBcpDebtBussDtl> list) throws ScubeBizException;

}
