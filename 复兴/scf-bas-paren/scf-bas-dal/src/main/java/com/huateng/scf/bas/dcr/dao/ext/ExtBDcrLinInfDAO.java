package com.huateng.scf.bas.dcr.dao.ext;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;

public interface ExtBDcrLinInfDAO {
	public List<BDcrLinInf>   selectTreeByRootId(String linId);
	public List   queryCusBDcrLinInf(String custId,String prdId,String linTyp,String stat,Page page);
}