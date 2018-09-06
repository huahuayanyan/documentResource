package com.huateng.scf.bas.icr.dao.ext;

import java.util.HashMap;
import java.util.List;

public interface ExtBIcrDAO {

	@SuppressWarnings("rawtypes")
	List getTblCreditInfoByCreditQryVO(HashMap<String, Object> omap);
    
}