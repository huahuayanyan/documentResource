package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.WarnQryVO;

public interface IBThreeCheckStockWarnDAO {
	
	public static  final String BEAN_ID = "IBThreeCheckStockWarnDAO";

	Page getCheckStockWarnInfo(WarnQryVO warnQryVO, Page page);

}
