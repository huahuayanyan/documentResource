package com.huateng.scf.rec.wrn.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IPromptPaymentNoticeQryService {
	/**通知书查询*/
	public Page queryPromptPayNotice(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, 
			@ScubeParam("conditionForm") HashMap<String,String> conditionForm);
	
}
