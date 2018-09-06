package com.huateng.scf.adv.qry.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

public interface IGoodsInHouseQryDAO {
	List<Map<String,Object>> queryGoodsInHouse(Map<String,Object> param, Page page);
}
