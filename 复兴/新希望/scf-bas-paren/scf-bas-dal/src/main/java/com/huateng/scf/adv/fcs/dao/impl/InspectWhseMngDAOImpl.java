package com.huateng.scf.adv.fcs.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.fcs.dao.IInspectWhseMngDAO;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;

@Repository("inspectWhseMngDAO")
public class InspectWhseMngDAOImpl extends IbatisDaoAnnotation4Template implements IInspectWhseMngDAO {
	@Resource(name="sqlMapClientTemplate")
	
    private IbatisTemplate template;
	
	 public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }

	@Override
	public List<Map<String, Object>> queryCheckStockByPage(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =  this.searchListPageMyObject("EXT_INSPECTWHSEMNG.queryCheckStockByPage",param, page);
        return list;
	}

	@Override
	public List<Map<String, Object>> queryPclInfoByPage(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =  this.searchListPageMyObject("EXT_INSPECTWHSEMNG.queryPclInfoByPage",param, page);
        return list;
	}

	@Override
	public List<Map<String, Object>> queryCekStkDetailById(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =  this.searchListPageMyObject("EXT_INSPECTWHSEMNG.queryCekStkDetailById",param, page);
        return list;
	}

	@Override
	public Map<String, Object> getMortgageSumCountPriceByParam(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_INSPECTWHSEMNG.getMortgageSumCountPriceByParam", param, SqlExecutor.NO_SKIPPED_RESULTS, SqlExecutor.NO_MAXIMUM_RESULTS);
        return list != null ? list.get(0) : null;
	}

	@Override
	public List<Map<String, Object>> queryMortInfo(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = this.searchListPageMyObject("EXT_INSPECTWHSEMNG.queryMortInfo",param, page);
        return list;
	}
	
	@Override
	public List<Map<String, Object>> queryInspectMortInfo(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = this.searchListPageMyObject("EXT_INSPECTWHSEMNG.queryInspectMortInfo",param, page);
		return list;
	}

}
