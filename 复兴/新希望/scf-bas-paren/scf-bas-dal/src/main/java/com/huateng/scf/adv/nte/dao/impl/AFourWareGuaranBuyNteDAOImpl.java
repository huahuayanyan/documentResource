package com.huateng.scf.adv.nte.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.nte.dao.IAFourWareGuaranBuyNteDAO;
import com.huateng.scf.bas.nte.dao.model.NoticeResultVO;

@Repository(IAFourWareGuaranBuyNteDAO.BeanId)
public class AFourWareGuaranBuyNteDAOImpl extends IbatisDaoAnnotation4Template implements IAFourWareGuaranBuyNteDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeResultVO> findFourWareGuaranBuyNteByPage(Map<String, Object> param, Page page) {
		List<NoticeResultVO> list =this.searchListPageMyObject("EXT_B_ADV_NTE_NOTICE.selectFourWareGuaranBuyNte", param, page);
		return list;
	}

	@Override
	public Integer findFourWareGuaranBuyNteCount(Map<String, Object> param) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_ADV_NTE_NOTICE.countFourWareGuaranBuyNte", param);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

}
