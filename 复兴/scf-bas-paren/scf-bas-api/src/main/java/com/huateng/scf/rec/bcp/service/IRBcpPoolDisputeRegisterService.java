package com.huateng.scf.rec.bcp.service;

import java.util.ArrayList;

import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpPoolDisputeRegisterService {
	public static final String BEAN_ID = "rBcpPoolDisputeRegisterService";

	/**
	 * 保存或者修改池融资纠纷解除申请信息（对应页面保存按钮）
	 * 
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public RBcpAppliBussInfo poolDisputeRegisterApplySaveUpdate(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds, @ScubeParam("processModel") ProcessModel processModel)
					throws ScubeBizException;

	public void addDisputInvoiceRegisterBussInfo(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds, @ScubeParam("appno") String appno) throws ScubeBizException;

	public void UpdateDebtAppliBussInfo(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds, @ScubeParam("appno") String appno) throws ScubeBizException;

	// 锁定对应基本信息并新增对应明细信息
	public void lockDebtBaseAndAddDtl(@ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> ds, @ScubeParam("appno") String appno);

	// 页面删除按钮(将对应的应收账款基本信息解锁)
	public void deleteRBcpDebtForRegister(@ScubeParam("RBcpAppliBussDtl") RBcpAppliBussDtl rBcpAppliBussDtl) throws ScubeBizException;

	/**
	 * 保存或者修改池融资纠纷解除申请信息（对应页面提交按钮）
	 * 
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	void submitPoolDisputeRegister(@ScubeParam("DebtBussInfoVO") DebtBussInfoVO debtVO,
			@ScubeParam("RBcpAppliBussDtl") ArrayList<RBcpAppliBussDtl> list) throws ScubeBizException;

}
