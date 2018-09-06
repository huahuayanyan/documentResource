package com.huateng.scf.bas.crm.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfo;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * @author fangquan
 * @date 2017-05-12
 *                           
 */
public interface IBCrmContactsInfoService {
	public Page findContractsInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("custcd") String custcd);
	
	public String add(@ScubeParam("bCrmContactsInfo") BCrmContactsInfo bCrmContactsInfo);

	public int delete(@ScubeParam("key") String[] custcds);

	public int update(@ScubeParam("bCrmContactsInfo") BCrmContactsInfo bCrmContactsInfo);
	
}
