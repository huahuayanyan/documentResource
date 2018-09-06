package com.huateng.scf.nrec.bcp.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;

public interface IBCntBcpNoticeQryDAO {
	
	public static final String BeanId ="IBCntBcpNoticeQryDAO";

	/**
	 * @param bNteNoticeBaseCon
	 * @param page
	 * @return
	 */
	List<BNteNoticeBase> findFactoringNoticeCommon(Map<String, Object> bNteNoticeBaseCon, Page page);

	int countFactoringNoticeCommon(Map<String, Object> bNteNoticeBaseCon);

}
