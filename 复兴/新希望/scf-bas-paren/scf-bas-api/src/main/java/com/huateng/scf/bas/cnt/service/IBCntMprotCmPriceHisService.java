package com.huateng.scf.bas.cnt.service;

import com.huateng.scf.bas.cnt.model.BCntMprotCmPriceHis;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntMprotCmPriceHisService {
	
	public void add(@ScubeParam("mportcmprice") BCntMprotCmPriceHis mportcmprice);

}
