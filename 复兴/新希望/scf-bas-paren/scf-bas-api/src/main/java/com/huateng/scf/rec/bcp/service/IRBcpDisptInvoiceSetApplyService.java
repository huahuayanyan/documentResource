package com.huateng.scf.rec.bcp.service;

import java.util.List;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntDebtInfoVO;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpDisptInvoiceSetApplyService {
	
//	public DebtBussInfoVO convertToDebtBussInfoVO(@ScubeParam("bCntDebtInfo") BCntDebtInfo bCntDebtInfo) throws ScubeBizException;
	
	public Page queryBCntDebtInfoListByPage(@ScubeParam("pageNo")  int pageNo,@ScubeParam("pageSize")  int pageSize,
			@ScubeParam("mastContQryVO")  MastContQryVO mastContQryVO) throws ScubeBizException;
	
	public String disputeInvoiceSetApplySaveUpdate(@ScubeParam("debtVO") DebtBussInfoVO debtVO,@ScubeParam("insertList") List<DebtBillsInfoVO> insertList) throws ScubeBizException;
	
	@SuppressWarnings("rawtypes")
	public void disputeInvoiceSetApplyWriteSubmitUpdate(@ScubeParam("debtVO") DebtBussInfoVO debtVO,@ScubeParam("insertList") List<DebtBillsInfoVO> insertList,@ScubeParam("isProcess") boolean isProcess) throws ScubeBizException;
	
	public void disputeInvoiceSetApplyReceiptUpdate(@ScubeParam("debtVO") DebtBussInfoVO debtVO,@ScubeParam("insertList") List<RBcpAppliBussDtl> insertList, @ScubeParam("appNo") String in_appno) throws ScubeBizException;
	
//	@SuppressWarnings("rawtypes")
//	public List getInvoiceListInWrkPrcsPage(@ScubeParam("appno") String appno,@ScubeParam("bussType") String bussType) throws ScubeBizException;
	
//	public com.huateng.scf.rec.bcp.model.AppliBussInfoVO queuySavedPageResult(@ScubeParam("appno") String appno) throws ScubeBizException;
	
//	public AppliBussInfoVO queryVOFromAppliBaseInfo(@ScubeParam("appno") String appno) throws ScubeBizException;
	
	public BCntDebtInfoVO queuyUnTakeTaskDetailPage(@ScubeParam("appno") String appno,@ScubeParam("buyerCustcd")String buyerCustcd) throws ScubeBizException;
	
	public Page getInvoiceListBySallerBuyerAndContno(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize")int pageSize,@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;
	
//	public void submitSignal(@ScubeParam("rBcpAppliBussInfo") DebtBussInfoVO rBcpAppliBussInfo,@ScubeParam("comment") String comment) throws Exception;
	
	public Page queryInvoiceRelatedFinancing(@ScubeParam("debtQueryVO") RBcpDebtQueryVO debtQueryVO,@ScubeParam("pageSize") int pageSize,@ScubeParam("pageNo") int pageNo);

	public DebtBussInfoVO DisputeInvoiceSetApplyAdd(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO);

	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno);

	public Page DisputeInvoiceSetQueryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO);
}
