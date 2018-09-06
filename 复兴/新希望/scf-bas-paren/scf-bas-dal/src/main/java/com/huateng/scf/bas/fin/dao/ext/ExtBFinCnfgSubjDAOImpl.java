package com.huateng.scf.bas.fin.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDef;

@Repository("ExtBFinCnfgSubjDAO")
public class ExtBFinCnfgSubjDAOImpl extends IbatisDaoAnnotation4Template implements ExtBFinCnfgSubjDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
    
	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
        return this.template;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> querySubjList(Map<String, String> omap, Page page) {
		// TODO Auto-generated method stub
        List<HashMap<String, String>> list = this.searchListPageMyObject("B_FIN_CNFG_SUBJ.querySubjList", omap, page);
		return  list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BFinCnfgCl> queryMdlByMdlId(Map<String, String> omap, Page page) {
		List<BFinCnfgCl> list = this.searchListPageMyObject("EXT_B_FIN.queryMdlList", omap, page);
		return list;
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BFinCnfgDef> queryBFinCnfgDefSubjByPage(HashMap<String, String> omap, Page page)
	{
		List<BFinCnfgDef> list = this.searchListPageMyObject("EXT_B_FIN.queryBFinCnfgDefSubjByPage", omap, page);
		return list;
	}
   
	@Override
	public int countBFinCnfgDefSubjByPage(HashMap<String, String> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_FIN.countBFinCnfgDefSubjByPage", omap);
        return count;
    }
}