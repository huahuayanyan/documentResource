package com.huateng.scf.adv.qry.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseVO;

public interface IFourLnciDtlQryDAO {
	
	List<BLanLnciBaseVO> selectByPage(Map<String,Object> param, Page page);
	
	/***
	 * 购销合同列表查询
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	public Page queryBCntBuyInfoListByPage(String debetNo, Page page);
}
