package com.huateng.scf.bas.common.dao.ext;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;

@Repository("ExtCostOutDAO")
public class ExtCostOutDAOImpl extends IbatisDaoAnnotation4Template implements ExtCostOutDAO {
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
    
	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
        return this.template;

	}
	
	/**
	 * 保证金转入信息列表查询
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List queryTblCostOut(HashMap<String, Object> omap,Page page)
	{
		List list = this.searchListPageMyObject("EXT_R_BCP.queryTblCostOut", omap, page);
        return list;
	}
	/**
	 *  保证金转入信息列表个数查询
	 */
	@Override
    public int countQueryTblCostOut(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_R_BCP.countQueryTblCostOut", omap);
        return count;
    }
}
