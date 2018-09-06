package com.huateng.scf.bas.brp.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBBrpPrdFactoringService {
	
	public String add(@ScubeParam("bBrpPrdFactoring") BBrpPrdFactoring bBrpPrdFactoring);

	public int delete(@ScubeParam("productId") String productId);

	public int update(@ScubeParam("bBrpPrdFactoring") BBrpPrdFactoring bBrpPrdFactoring);

	public BBrpPrdFactoring findBBrpPrdFactoringByKey(
			@ScubeParam("productId") String productId);

	// 页面下拉菜单（）
	public Page findBBrpIndustryTypesTree(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BBrpPrdFactoring bBrpPrdFactoring);

	public Page findBBrpIndustryTypesByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bBrpPrdFactoring") BBrpPrdFactoring bBrpPrdFactoring);


}
