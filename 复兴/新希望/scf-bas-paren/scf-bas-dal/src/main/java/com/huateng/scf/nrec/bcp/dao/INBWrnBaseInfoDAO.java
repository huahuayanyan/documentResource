package com.huateng.scf.nrec.bcp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.domodel.NBWrnDebtPdoInfoDetailDO;

public interface INBWrnBaseInfoDAO {
	
	public static final String BEAN_ID= "NBWrnBaseInfoDAOImpl";

	List<NBWrnDebtPdoInfoDetailDO> getAccountDebtPromptWarnInfo(Map<String, Object> map, Page page);

	List getAccountDebtPromptWarnInfo(HashMap<String, Object> omap, Page page);
	

}
