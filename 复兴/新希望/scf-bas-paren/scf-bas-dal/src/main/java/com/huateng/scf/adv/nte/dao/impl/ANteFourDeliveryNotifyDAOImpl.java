package com.huateng.scf.adv.nte.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.nte.dao.IANteFourDeliveryNotifyDAO;
import com.huateng.scf.adv.nte.dao.model.FourDeliveryNotifyVO;

@Repository(IANteFourDeliveryNotifyDAO.BeanId)
public class ANteFourDeliveryNotifyDAOImpl extends IbatisDaoAnnotation4Template implements IANteFourDeliveryNotifyDAO {

	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	@SuppressWarnings("unchecked")
	@Override
	public List<FourDeliveryNotifyVO> findFourDeliveryNotifyByPage(Map<String, Object> param, Page page) {
		List<FourDeliveryNotifyVO> list =this.searchListPageByMap("EXT_B_ADV_NTE_NOTICE.selectFourDeliveryNotify", param, page);
		return list;
	}

	@Override
	public Integer findFourDeliveryNotifyCount(Map<String, Object> param) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_ADV_NTE_NOTICE.countFourDeliveryNotify", param);
		return count;
	}
	

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return template;
	}

}
