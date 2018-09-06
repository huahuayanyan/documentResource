package com.huateng.scf.bas.pbc.dao.ext;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPrice;

public interface ExtIBPbcMtgMktPriceDAO {
	public List<BPbcMtgMktPrice> getBaiInfoMarketPri(Page page, Map map);
}