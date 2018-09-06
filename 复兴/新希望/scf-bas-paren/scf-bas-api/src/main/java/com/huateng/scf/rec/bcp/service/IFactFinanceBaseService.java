package com.huateng.scf.rec.bcp.service;

import java.math.BigDecimal;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IFactFinanceBaseService {

	public BigDecimal calculatePoolRiskAvailableAmtByBusinessNo(@ScubeParam("businessNo") String businessNo) throws ScubeBizException;

	public Page invoiceBuyerPayList(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	public DebtLnciBaseInfoVO getInvoiceFinanceApplyInfo(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;
}
