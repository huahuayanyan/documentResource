package com.huateng.scf.bas.nte.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.IBNetNoticeQryVODAO;
import java.util.Map;
import com.huateng.scf.bas.nte.dao.model.NoticeQryVO;

@Repository("BNetNoticeQryVODAO")
public class BNetNoticeQryVODAOImpl extends IbatisDaoAnnotation4Template
		implements IBNetNoticeQryVODAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BNetNoticeQryVODAOImpl() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<NoticeQryVO> queryNoticeQryVO(Map<String,Object> param,Page page) {
		List<NoticeQryVO> list = this.searchListPageMyObject("B_NTE_NOTICE_QRY_VO.queryNoticeQryVO", param,page);
        return list;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

}
