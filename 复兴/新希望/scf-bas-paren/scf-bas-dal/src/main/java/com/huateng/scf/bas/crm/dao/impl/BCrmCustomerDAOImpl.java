package com.huateng.scf.bas.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crm.dao.IBCrmCustomerDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;

@Repository("IBCrmCustomerDAO")
public class BCrmCustomerDAOImpl extends IbatisDaoAnnotation4Template implements IBCrmCustomerDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;
	
    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

	@Override
	public List<BCrmBaseInfo> queryContDebtInfoByBuyercustcd(Map<String, Object> params, int pageSize, int pageNo) {
		Page page = new Page(pageSize, pageNo, 0);
		List<BCrmBaseInfo> list =this.searchListPageByMap("B_CRM_CUSTOMER.selectContDebtInfoByBuyercustcd", params, page);
		return list;
	}
	
	@Override
	public Integer queryContDebtCountByBuyercustcd(Map<String, Object> params) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("B_CRM_CUSTOMER.selectContDebtCountByBuyercustcd", params);
		return count;
	}

	@Override
	public List selectFlcCustomerListByPage(Map<String, Object> params, Page page) {
		List list = this.searchListPageByMap("B_CRM_CUSTOMER.selectFlcCustomerListByPage", params, page);
		return list;
	}

	@Override
	public int selectFlcCustomerCount(Map<String, Object> params) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("B_CRM_CUSTOMER.selectFlcCustomerCount", params);
		return count;
	}



}
