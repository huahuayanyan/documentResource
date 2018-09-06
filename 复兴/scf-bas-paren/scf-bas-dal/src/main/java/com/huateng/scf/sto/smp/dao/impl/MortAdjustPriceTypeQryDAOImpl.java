package com.huateng.scf.sto.smp.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.smp.dao.IMortAdjustPriceTypeQryDAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository("mortAdjustPriceTypeQryDAO")
public class MortAdjustPriceTypeQryDAOImpl extends IbatisDaoAnnotation4Template implements IMortAdjustPriceTypeQryDAO {
	
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
	
	 public MortAdjustPriceTypeQryDAOImpl() {
	        super();
	    }
	 public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }

	@Override
	public List<Map<String, Object>> selectByPage(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =  this.searchListPageMyObject("EXT_MORTADJUSTPRICETYPEQRY.selectByPage",param, page);
        return list;
	}

}