package com.huateng.scf.sto.smp.dao;

import com.huateng.base.common.beans.Page;
import java.util.List;
import java.util.Map;

public interface IMortAdjustPriceTypeQryDAO {

	List<Map<String,Object>> selectByPage(Map<String,Object> param, Page page);
}