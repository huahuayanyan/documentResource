package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpDebtInPoolAccountService {

	/**
	 * 
	 * @param appno
	 * @return
	 */
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(@ScubeParam("appno") String appno);
	/**
	 * 
	 * @param debtBussInfoVO
	 * @param cache
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getDebtInPoolBussInfo(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO) throws ScubeBizException;
	/**
	 * 
	 * @param debtBussInfoVO
	 * @param cache
	 * @return
	 * @throws ScubeBizException
	 */
	public DebtBussInfoVO getDebtInPoolEdit(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("cache") String cache) throws ScubeBizException;
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getInvoiceAdd(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO,@ScubeParam("list") List<RBcpAppliBussDtl> list)
			throws ScubeBizException;
	/**
	 * 
	 * @param list
	 */
	public void cacheAdd(@ScubeParam("list") List<RBcpAppliBussDtl> list);
	/**
	 * 
	 * @param list
	 * @param appno
	 * @return
	 */
	public int batchDeleteRBcpDebtBaseInfo(@ScubeParam("list") List<RBcpAppliBussDtl> list,@ScubeParam("appno") String appno);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpAppliBussInfo
	 * @param cache
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getInvoiceInpoolList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo,@ScubeParam("cache") String cache)
			throws ScubeBizException;
	/**
	 * 入池申请保存
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 */
	public String InvoiceInpoolSaveUpdater(@ScubeParam("appliBussInfoVO") AppliBussInfoVO appliBussInfoVO, @ScubeParam("insertDebtList")  List<RBcpDebtBaseInfo> insertDebtList)
			throws ScubeBizException;
	/**
	 * 入池申请提交
	 * @param appliBussInfoVO
	 * @throws ScubeBizException
	 */
	public void InvoiceInpoolSubmitUpdater(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;
	/**
	 * 入池申请审批
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 */
	public void InvoiceInpoolApproveUpdater(@ScubeParam("appliBussInfoVO") AppliBussInfoVO appliBussInfoVO,@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList,@ScubeParam("isProcess") boolean isProcess)
			throws ScubeBizException;
}
