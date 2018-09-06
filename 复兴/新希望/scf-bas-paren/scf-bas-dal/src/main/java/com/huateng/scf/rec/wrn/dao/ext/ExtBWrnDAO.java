package com.huateng.scf.rec.wrn.dao.ext;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;

public interface ExtBWrnDAO {

	@SuppressWarnings("rawtypes")
	List getAccountDebtPromptWarnInfo(HashMap<String, Object> omap, Page page);

	int countByHashMap(HashMap<String, Object> omap);
    
}