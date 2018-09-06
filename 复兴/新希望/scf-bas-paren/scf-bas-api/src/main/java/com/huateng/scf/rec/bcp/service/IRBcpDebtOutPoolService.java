package com.huateng.scf.rec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpDebtOutPoolService {
	public static final String BEAN_ID = "rBcpDebtOutPoolService";

	/**
	 * 出池待添加发票查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getInvoiceOut(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;
	
/**
 * 根据申请编号获得应收账款列表
 * @param pageNo
 * @param pageSize
 * @param rBcpAppliBussInfo
 * @return
 * @throws ScubeBizException
 */
	public Page getInvoiceInpoolAppList(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO)
			throws ScubeBizException;
	
	/**
	 * 入池申请保存
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveDebtOutPoolWriteApply(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("debtBillsInfoVOList") List<DebtBillsInfoVO> list)
			throws ScubeBizException;
	/**
	 * 入池申请提交
	 * @param appliBussInfoVO
	 * @throws ScubeBizException
	 */
	public void saveDebtOutPoolWriteSubmit(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("debtBillsInfoVOList") List<DebtBillsInfoVO> list) throws ScubeBizException;


}
