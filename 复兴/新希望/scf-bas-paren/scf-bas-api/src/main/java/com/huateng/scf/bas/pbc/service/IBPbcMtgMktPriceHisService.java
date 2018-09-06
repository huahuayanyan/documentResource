package com.huateng.scf.bas.pbc.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcMtgMktPriceHis;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBPbcMtgMktPriceHisService {
	/**
	 * @param PageNo
	 * @param pageSize
	 * @param dataItemsDO
	 * @return
	 */
	public Page getMortMarketPriByProId(@ScubeParam("pageNo") int PageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPbcMtgMktPriceHis bPbcMtgMktPriceHis);

}
