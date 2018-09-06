package com.huateng.scf.rec.qry.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpPoolDebtDtlInfoQryService {
	
	public Page getDebtQuery(@ScubeParam("commonQueryVO")DebtCommonQryVO commonQueryVO,@ScubeParam("pageSize") int pageSize,@ScubeParam("pageNo")int pageNo);

	public Page getInvoiceCourseInfoQry(@ScubeParam("commonQueryVO")DebtCommonQryVO commonQueryVO,@ScubeParam("pageSize") int pageSize,@ScubeParam("pageNo")int pageNo);
}
