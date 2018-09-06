package com.huateng.scf.bas.dcr.dao.ext;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;

@Repository
public class ExtBDcrLinTypDAOImpl extends IbatisDaoAnnotation4Template implements ExtBDcrLinTypDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
    
	@Override
	public List  queryCrNmSource(Map omap){	
		return  getSqlMapClientTemplate().queryForList("EXT_DCR.queryCrNmSource", omap);
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
        return this.template;

	}

//	@Override
//	public List queryCustList(Map omap) {
//		// TODO Auto-generated method stub
//		return  getSqlMapClientTemplate().queryForList("EXT_DCR.queryCustList", omap);
//
//	}
//	
	
	@Override
	public List queryCustList(Map omap, Page page) {
		// TODO Auto-generated method stub
        List list = this.searchListPageMyObject("EXT_DCR.queryCustList", omap, page);
		return  list;

	}	
	
	
   
}