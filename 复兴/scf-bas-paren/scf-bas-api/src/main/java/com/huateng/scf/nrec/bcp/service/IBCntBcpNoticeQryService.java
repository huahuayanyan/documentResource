package com.huateng.scf.nrec.bcp.service;

import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntBcpNoticeQryService {
	
	public static final String BeanId ="BCntBcpNoticeQryServiceImpl";

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bNteNoticeBaseCon
	 * @return
	 */
	Page queryFactoringNoticeCommon(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize")  int pageSize, @ScubeParam("commonQueryVO")  Map<String, Object> bNteNoticeBaseCon);

}
