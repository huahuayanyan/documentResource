package com.huateng.scf.rec.bcp.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.PayMentLanInfo;
import com.huateng.scf.rec.bcp.model.PaymentBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpPaymentService {
	

	public List getLoanWayList(@ScubeParam("debtContno") String debtContno,@ScubeParam("dictCode") String dictCode);
	public PaymentBussInfo  getInvoicePaymentInfo(@ScubeParam("rBcpAppliBussInfo")RBcpAppliBussInfo rBcpAppliBussInfo);
    public   String  addPaymentApply(@ScubeParam("rBcpAppliBussInfo")RBcpAppliBussInfo rBcpAppliBussInfo); 
	public Page findCancelRBcpDebtBaseInfoPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("value")Map rBcpDebtBaseInfo,@ScubeParam("list") List list);
	public void addRBcpAppliBussDtl(@ScubeParam("appno")String appno,@ScubeParam("rBcpAppliBussDtl")RBcpAppliBussDtl rBcpAppliBussDtl);
	public void updateRBcpAppliBussDtl(@ScubeParam("rBcpAppliBussDtl")RBcpAppliBussDtl rBcpAppliBussDtl);
	public void deleteRBcpAppliBussDtl(@ScubeParam("rBcpAppliBussDtl")RBcpAppliBussDtl rBcpAppliBussDtl);
	
	public Page findLoanByPage(@ScubeParam("pageNo")int pageNo, @ScubeParam("pageSize")int pageSize, @ScubeParam("appno")String  appno);
	
	public void updatePayMentLanInfo(@ScubeParam("appno")String  appno,@ScubeParam("payMentLanInfo")PayMentLanInfo payMentLanInfo) throws ScubeBizException;
	
	public void delPaymentApply(@ScubeParam("appno")String appno);
	
	public String updatePaymentApply(@ScubeParam("paymentBussInfo")PaymentBussInfo paymentBussInfo);
	public void	assignAmount(@ScubeParam("paymentBussInfo")PaymentBussInfo paymentBussInfo);
	
	public void submitFlow(@ScubeParam("key")String key) ;
	
	/***
	 * 池现金回款关联的融资信息
	 * @param pageNo
	 * @param pageSize
	 * @param appno
	 * @return
	 */
	public Page findPoolLoanByPage(@ScubeParam("pageNo")int pageNo, @ScubeParam("pageSize")int pageSize, @ScubeParam("appno")String  appno);
	
	
	/**
	 * 应收账款池融资 融资列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtLnciQryVO
	 * @return
	 */
	public Page findloanAddListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("debtLnciQryVO")DebtLnciQryVO debtLnciQryVO)throws ScubeBizException;
	
	/**
	 * 应收账款池融资 融资信息保存
	 * @param debtBussInfoVO
	 * @param lnciList
	 */
	public void addLoanInfoDtl(@ScubeParam("debtBussInfoVO")DebtBussInfoVO debtBussInfoVO,@ScubeParam("debtLnciBaseInfoVOList")List<DebtLnciBaseInfoVO> lnciList) throws ScubeBizException;
}
