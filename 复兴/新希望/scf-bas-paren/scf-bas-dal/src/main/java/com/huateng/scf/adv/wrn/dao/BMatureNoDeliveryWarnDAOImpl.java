package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.BWrnMortRedeemInfo;

@Repository(IBMatureNoDeliveryWarnDAO.BeanId)
public class BMatureNoDeliveryWarnDAOImpl extends IbatisDaoAnnotation4Template implements IBMatureNoDeliveryWarnDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	@SuppressWarnings("unchecked")
	@Override
	public List<BWrnMortRedeemInfo> selectNoDeliveryWarningListByPage(Map<String, Object> params, Page page) {
		List<BWrnMortRedeemInfo> list =this.searchListPageByMap("EXT_B_WRN_NO_DELIVERY.selectNoDeliveryWarningList", params, page);
		return list;
	}

	@Override
	public Integer selectNoDeliveryWarningCount(Map<String, Object> params) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_NO_DELIVERY.CountNoDeliveryWarning", params);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

}
