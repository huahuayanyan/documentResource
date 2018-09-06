package com.huateng.scf.rec.qry.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IRBcpDebtRepaymentInfoQryService {

	public Page getDebtRepaymentInfo(@ScubeParam("pageSize") int pageSize, @ScubeParam("pageNo") int pageNo,
			@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO);

}
