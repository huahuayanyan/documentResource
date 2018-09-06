package com.huateng.scf.bas.common.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.common.dao.ext.ICommonQueryDAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository("commonQueryDAO")
public class CommonQueryDAOImpl extends IbatisDaoAnnotation4Template implements ICommonQueryDAO {
	
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
	
	 public CommonQueryDAOImpl() {
	        super();
	    }
	 public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }

	@Override
	public List<Map<String, Object>> selectByPage(String sqlId, Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =  this.searchListPageMyObject(sqlId,param, page);
        return list;
	}

}