package com.huateng.scf.rec.wrn.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.rec.wrn.dao.IPromptPaymentNoticeQryDAO;

@Repository("PromptPaymentNoticeQryDAO")
public class PromptPaymentNoticeQryDAOImpl extends IbatisDaoAnnotation4Template implements IPromptPaymentNoticeQryDAO {
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
	public PromptPaymentNoticeQryDAOImpl() {
        super();
    }
	@Override
	 public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }
	@Override
	@SuppressWarnings("unchecked")
	public List<BNteNoticeBase> getDebtNoticeInfo(HashMap<String, String> omap, Page page) {
		List<BNteNoticeBase> list = this.searchListPageMyObject("EXT_PROMPTPAYMENTNOTICEQRY.queryPromptPayNotice", omap, page);
	        return list;
	}

}
