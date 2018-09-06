package com.huateng.scf.bas.lan.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>借据基本信息接口</p>
 *
 * @author 	liph
 * @date 	2016年12月14日.上午11:13:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月14日.上午11:13:52	     新增
 *
 * </pre>
 */

public interface IBLanApproveFindService {
	/**
	 * 担保提货-放款审批-预付类
	 */
	public Page findAccountLoanApplyByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("cname") String cname,
			@ScubeParam("mastContno") String mastContno,@ScubeParam("debetId") String debetId,@ScubeParam("status") String status);
	/**
	 * 应收账款-放款审批-应收类
	 */
	public Page findInvoiceFinancingApply(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("cname") String cname,
			@ScubeParam("mastContno") String mastContno,@ScubeParam("debetId") String debetId,@ScubeParam("status") String status);
	/**
	 * 现货抵押-放款审批-现货类
	 */
	public Page findMortgageLoanApply(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("cname") String cname,
			@ScubeParam("mastContno") String mastContno,@ScubeParam("debetId") String debetId,@ScubeParam("status") String status);
	/**
	 * 应收账款池-放款审批-应收类
	 */
	public Page findInvoicePoolFinancingApply(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("cname") String cname,
			@ScubeParam("mastContno") String mastContno,@ScubeParam("debetId") String debetId,@ScubeParam("status") String status);
}
