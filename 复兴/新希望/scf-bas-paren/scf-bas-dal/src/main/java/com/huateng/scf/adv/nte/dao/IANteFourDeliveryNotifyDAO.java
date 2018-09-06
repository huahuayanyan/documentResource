package com.huateng.scf.adv.nte.dao;


import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.nte.dao.model.FourDeliveryNotifyVO;

public interface IANteFourDeliveryNotifyDAO {
	
	public static final String BeanId ="IANteFourDeliveryNotifyDAO";
	
	public List<FourDeliveryNotifyVO> findFourDeliveryNotifyByPage(Map<String, Object> params,Page page);
	
	public Integer findFourDeliveryNotifyCount(Map<String, Object> params);
	

}
