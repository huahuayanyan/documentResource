package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;

@Repository(IBNoConfirmPayWarnDAO.BeanId)
public class BNoConfirmPayWarnDAOImpl extends IbatisDaoAnnotation4Template implements IBNoConfirmPayWarnDAO {

	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate tempalte;

	@Override
	public List queryNoConfirmPayWarnListByPage(Map<String, Object> params, Page page) {
		List list = this.searchListPageMyObject("EXT_B_WRN_LNCI_CONFIRM.selectConfirmPayWarnList", params, page);
		return list;
	}

	@Override
	public Integer queryNoConfirmPayWarnListCount(Map<String, Object> params) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_LNCI_CONFIRM.countConfirmPayWarnList", params);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.tempalte;
	}

}
