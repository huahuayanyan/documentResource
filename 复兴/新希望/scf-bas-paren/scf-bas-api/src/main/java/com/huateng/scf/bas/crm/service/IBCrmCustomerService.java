package com.huateng.scf.bas.crm.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.CustomerQryVO;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmCustomerService {

	public Page findFactorCustRelationPageByCust(@ScubeParam("customerQryVO") CustomerQryVO customerQryVO,
			@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize);
	
	public Page findFlcCustomerPage(@ScubeParam("customerQryVO") CustomerQryVO customerQryVO,
			@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize);

}