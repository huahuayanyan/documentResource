package com.huateng.scf.bas.fin.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDef;

public interface ExtBFinCnfgSubjDAO {
    List<HashMap<String, String>> querySubjList(Map<String, String> omap, Page page);
    
    List<BFinCnfgCl> queryMdlByMdlId(Map<String, String> omap, Page page);

	List<BFinCnfgDef> queryBFinCnfgDefSubjByPage(HashMap<String, String> omap, Page page);

	int countBFinCnfgDefSubjByPage(HashMap<String, String> omap);
}