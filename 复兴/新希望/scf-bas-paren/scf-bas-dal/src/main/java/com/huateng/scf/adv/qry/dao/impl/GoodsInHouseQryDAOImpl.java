package com.huateng.scf.adv.qry.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.qry.dao.IGoodsInHouseQryDAO;

@Repository("goodsInHouseQryDAO")
public class GoodsInHouseQryDAOImpl extends IbatisDaoAnnotation4Template implements IGoodsInHouseQryDAO {
	@Resource(name="sqlMapClientTemplate")
	
    private IbatisTemplate template;
	
	 public GoodsInHouseQryDAOImpl() {
	        super();
	    }
	 public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }

	@Override
	public List<Map<String, Object>> queryGoodsInHouse(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =  this.searchListPageMyObject("EXT_GOODSINHOUSEQUERY.queryGoodsInHouse",param, page);
        return list;
	}
}
