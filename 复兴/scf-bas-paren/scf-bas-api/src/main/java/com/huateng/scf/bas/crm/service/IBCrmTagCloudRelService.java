package com.huateng.scf.bas.crm.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmTagCloudRel;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmTagCloudRelService {

	public Page findBCrmTagCloudInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmTagCloudRel") BCrmTagCloudRel bCrmTagCloudRel);

	public void add(@ScubeParam("bCrmTagCloudRel") BCrmTagCloudRel bCrmTagCloudRel);

	public void update(@ScubeParam("bCrmTagCloudRel") BCrmTagCloudRel bCrmTagCloudRel);

	public void delete(@ScubeParam("id") String id);
	
	public void refresh(@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);
	
	public BCrmTagCloudRel findByCustcdAndTagCode(@ScubeParam("custd") String custcd, @ScubeParam("tagCode") String tagCode);
}
