package com.huateng.scf.rec.wrn.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("ExtBWrnDAO")
public class ExtBWrnDAOImpl extends IbatisDaoAnnotation4Template implements ExtBWrnDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ExtBWrnDAOImpl() {
        super();
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }
    
    @SuppressWarnings("rawtypes")
	@Override
    public List getAccountDebtPromptWarnInfo(HashMap<String, Object> omap,Page page)
    {
    	List list = this.searchListPageByMap("EXT_B_WRN.getAccountDebtPromptWarnInfo", omap, page);
    	return list;
    }
    
    @Override
    public int countByHashMap(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_WRN.countByHashMap", omap);
        return count;
    }
}