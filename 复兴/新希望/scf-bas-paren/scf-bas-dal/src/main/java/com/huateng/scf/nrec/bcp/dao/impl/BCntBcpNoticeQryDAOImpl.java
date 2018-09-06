package com.huateng.scf.nrec.bcp.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpNoticeQryDAO;

@Repository(IBCntBcpNoticeQryDAO.BeanId)
public class BCntBcpNoticeQryDAOImpl extends IbatisDaoAnnotation4Template implements IBCntBcpNoticeQryDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;
	
	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	/**
	 * 分页查询应收账款转让/出质通知书列表
	 * @param bNteNoticeBaseCon
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BNteNoticeBase> findFactoringNoticeCommon(Map<String, Object> bNteNoticeBaseCon, Page page) {
		List<BNteNoticeBase> list =this.searchListPageByMap("EXT_NREC_NOTICE_QRY.selectFactoringNoticeCommon", bNteNoticeBaseCon, page);
		return list;
	}

	@Override
	public int countFactoringNoticeCommon(Map<String, Object> bNteNoticeBaseCon)
	{
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NREC_NOTICE_QRY.countFactoringNoticeCommon", bNteNoticeBaseCon);
		return count;
	}

}
