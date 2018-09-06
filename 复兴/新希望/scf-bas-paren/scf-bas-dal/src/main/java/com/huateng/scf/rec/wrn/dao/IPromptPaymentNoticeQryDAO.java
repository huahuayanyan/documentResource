package com.huateng.scf.rec.wrn.dao;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;

public interface IPromptPaymentNoticeQryDAO {
	/**分页查询通知书B_NTE_NOTICE_BASE*/
	List<BNteNoticeBase> getDebtNoticeInfo(HashMap<String, String> omap, Page page);

}
