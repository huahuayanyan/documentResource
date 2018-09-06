package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
@Repository(IBOverMoniLimitWrnDAO.BeanId)
public class BOverMoniLimitWrnDAOImpl extends IbatisDaoAnnotation4Template implements IBOverMoniLimitWrnDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	@Override
	public List findOverMoniLimitWrnListByPage(Map<String, Object> params, Page page) {
		List list =this.searchListPageByMap("EXT_WRN_OVER_MONI.selectBWrnOverMoniByPage", params, page);
		return list;
	}

	@Override
	public Integer findOverMoniLimitWrnCount(Map<String, Object> params) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_WRN_OVER_MONI.selectBWrnOverMoniCount", params);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		
		return this.template;
	}

}
