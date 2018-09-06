package com.huateng.scf.sto.wrn.dao.ext;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.WarnQryVO;
import com.huateng.scf.sto.wrn.dao.model.WarnUnPatrolStoreVO;


public interface IBUnPatrolStoreWarningDAO {
	
	public static final String BeanID = "IBUnPatrolStoreWarningDAO";

	List<WarnUnPatrolStoreVO> findUnPatrolStoreWarningByPage(Map<String, Object> params, Page page);

	Integer countUnPatrolStoreWarning(Map<String, Object> params);
	
	public String getLastAppDateInWhseInspect(Map<String, Object> params);

}
