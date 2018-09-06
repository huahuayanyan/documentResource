package com.huateng.scf.bas.cnt.dao.ext;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMtgBaseInfo;

public interface ExtIBCntContSlaveAndMortgageInfoDAO {

	public List<BCntMtgBaseInfo> getContSlaveBaseInfo(HashMap<String, Object> omap, Page page);

	public int countContSlaveBaseInfo(HashMap<String, Object> omap);
}