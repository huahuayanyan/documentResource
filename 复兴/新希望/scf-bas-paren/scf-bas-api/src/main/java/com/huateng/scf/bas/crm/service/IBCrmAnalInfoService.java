package com.huateng.scf.bas.crm.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmAnalInfo;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmAnalInfoService {

	public String add(@ScubeParam("bCrmAnalInfo") BCrmAnalInfo bCrmAnalInfo);

	public int delete(@ScubeParam("key") String id);

	public int deleteByCustcd(@ScubeParam("key") String custcd);

	public int update(@ScubeParam("bCrmAnalInfo") BCrmAnalInfo bCrmAnalInfo);

	// public int batchDelete(@ScubeParam("voList") List custcdList);

	public Page findBCrmAnalInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmAnalInfo") BCrmAnalInfo bCrmAnalInfo);

}
