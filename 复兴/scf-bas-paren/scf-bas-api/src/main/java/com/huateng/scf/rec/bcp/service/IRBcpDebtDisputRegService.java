package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfoVO;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.FactoringContVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpDebtDisputRegService {

	public DebtBussInfoVO convertToDebtBussInfoVO(@ScubeParam("bCntDebtInfo") BCntDebtInfo bCntDebtInfo)
			throws ScubeBizException;

	public Page queryBCntDebtInfoListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	public String disputeInvoiceSetApplySaveUpdate(@ScubeParam("debtVO") DebtBussInfoVO debtVO,
			@ScubeParam("insertList") List<DebtBillsInfoVO> insertList,
			@ScubeParam("processModel") ProcessModel processModel) throws ScubeBizException;

	public void disputeInvoiceSetApplyWriteSubmitUpdate(@ScubeParam("debtVO") DebtBussInfoVO debtVO,
			@ScubeParam("insertList") List<DebtBillsInfoVO> insertList) throws ScubeBizException;

	public void disputeInvoiceSetApplyReceiptUpdate(@ScubeParam("debtVO") DebtBussInfoVO debtVO,
			@ScubeParam("insertList") List<RBcpAppliBussDtl> insertList, @ScubeParam("appNo") String in_appno)
					throws ScubeBizException;

	public List getInvoiceList(@ScubeParam("appno") String appno, @ScubeParam("bussType") String bussType)
			throws ScubeBizException;

	public com.huateng.scf.rec.bcp.model.AppliBussInfoVO queuySavedPageResult(@ScubeParam("appno") String appno)
			throws ScubeBizException;

	public AppliBussInfoVO queryVOFromAppliBaseInfo(@ScubeParam("appno") String appno) throws ScubeBizException;

	public BCntDebtInfoVO queuyUnTakeTaskDetailPage(@ScubeParam("appno") String appno,
			@ScubeParam("buyerCustcd") String buyerCustcd) throws ScubeBizException;

	public Page getInvoiceListBySallerBuyerAndContno(@ScubeParam("commonQueryVO") RBcpDebtQueryVO commonQueryVO)
			throws ScubeBizException;

	public void submitSignal(@ScubeParam("rBcpAppliBussInfo") DebtBussInfoVO rBcpAppliBussInfo,
			@ScubeParam("comment") String comment) throws Exception;

	public Page queryInvoiceRelatedFinancing();

	public Page getDisputeInvoiceSetApplyAdd(@ScubeParam("appno") String appno, @ScubeParam("flag") String flag,
			@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContno") String mastContno, @ScubeParam("custcdSaller") String custcdSaller);
	/**
	 * 
	 * @param mastContno
	 * @return
	 */
	public FactoringContVO getFactContDetailByMastContno(@ScubeParam("mastContno") String mastContno);
}
