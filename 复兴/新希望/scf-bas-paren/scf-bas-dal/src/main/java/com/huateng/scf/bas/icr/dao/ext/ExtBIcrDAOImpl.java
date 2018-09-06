package com.huateng.scf.bas.icr.dao.ext;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.ibatisEx.IbatisTemplate;

@Repository("ExtBIcrDAO")
public class ExtBIcrDAOImpl implements ExtBIcrDAO {
	
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ExtBIcrDAOImpl() {
        super();
    }

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List getTblCreditInfoByCreditQryVO(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("EXT_B_ICR_INFO.getTblCreditInfoByCreditQryVO", omap);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

}
