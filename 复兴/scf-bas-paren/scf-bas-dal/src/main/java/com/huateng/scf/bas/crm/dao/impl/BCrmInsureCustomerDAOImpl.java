package com.huateng.scf.bas.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmInsureCustomerDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmInsureInfo;

@Repository("IBCrmInsureCustomerDAO")
public class BCrmInsureCustomerDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmInsureCustomerDAO {

	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate ibatisTemplate;

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.ibatisTemplate;
	}

	@Override
	public List queryInsureCustomerByParams(Map<String, Object> params, int pageNo, int pageSize) {
		Page page = new Page(pageSize, pageNo, 0);
		List list = this.searchListPageByMap("B_CRM_INSURE_INFO.selectInsureCustomerByParams", params, page);
		return list;
	}

	@Override
	public Integer queryInsureCustomerCount(Map<String, Object> params) {
		Integer count = (Integer) this.getSqlMapClientTemplate()
				.queryForObject("B_CRM_INSURE_INFO.selectInsureCustomerCount", params);
		return count;
	}

	@Override
	public List<BCrmBaseInfo> queryBCrmBaseInfoByParams(Map<String, Object> params, int pageNo, int pageSize) {
		Page page = new Page(pageSize, pageNo, 0);
		List<BCrmBaseInfo> list = this.searchListPageByMap("B_CRM_INSURE_INFO.selectBCrmEntInfoByParams", params, page);
		return list;
	}

	@Override
	public int queryBCrmBaseInfoCount(Map<String, Object> params) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("B_CRM_INSURE_INFO.selectBCrmEntInfoCount", params);
		return count;
	}
	
	@Override
	public List<BCrmEntInfo> queryBCrmEntInfoByParams(Map<String, Object> params, int pageNo, int pageSize) {
		Page page = new Page(pageSize, pageNo, 0);
		List<BCrmEntInfo> list = this.searchListPageByMap("B_CRM_INSURE_INFO.selectBCrmEntInfoByParams", params, page);
		return list;
	}
	
	@Override
	public int queryBCrmEntInfoCount(Map<String, Object> params) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("B_CRM_INSURE_INFO.selectBCrmEntInfoCount", params);
		return count;
	}


}
