package com.huateng.scf.adv.nte.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.nte.dao.IAQuantityNoticeDAO;
import com.huateng.scf.bas.nte.dao.model.NoticeResultVO;

@Repository(IAQuantityNoticeDAO.BeanId)
public class AQuantityNoticeDAOImpl extends IbatisDaoAnnotation4Template implements IAQuantityNoticeDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate temaplate;

	@Override
	public List<NoticeResultVO> findQuantityNoticeListByPage(Map<String, Object> param, Page page) {
		List<NoticeResultVO> list =this.searchListPageMyObject("EXT_B_ADV_NTE_NOTICE.selectQuantityNoticeList", param, page);
		return list;
	}

	@Override
	public Integer findQuantityNoticeCount(Map<String, Object> param) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_ADV_NTE_NOTICE.countQuantityNotice", param);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.temaplate;
	}

}
