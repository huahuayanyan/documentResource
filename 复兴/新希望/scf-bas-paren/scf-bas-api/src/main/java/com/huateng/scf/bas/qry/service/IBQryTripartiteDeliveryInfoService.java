package com.huateng.scf.bas.qry.service;


import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scube.server.annotation.ScubeParam;


public interface IBQryTripartiteDeliveryInfoService {
	
	public Page findThreeLnciInfoQuery(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("deliveryQryVO") DeliveryQryVO deliveryQryVO);

	public Page getContBuyInfoByDebetNo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debetNo") String debetNo);
}
