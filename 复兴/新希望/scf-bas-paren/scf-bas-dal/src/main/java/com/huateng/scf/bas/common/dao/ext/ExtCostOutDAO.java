package com.huateng.scf.bas.common.dao.ext;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;

public interface ExtCostOutDAO {

	@SuppressWarnings("rawtypes")
	List queryTblCostOut(HashMap<String, Object> omap, Page page);

	int countQueryTblCostOut(HashMap<String, Object> omap);

}
