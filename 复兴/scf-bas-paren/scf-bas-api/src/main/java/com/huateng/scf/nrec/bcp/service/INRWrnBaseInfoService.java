package com.huateng.scf.nrec.bcp.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.AccountDebtQryVO;
import com.huateng.scf.nrec.bcp.vo.NBWrnDebtPdoInfoDetail;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface INRWrnBaseInfoService {
	
	public static final String BEAN_ID ="NRWrnBaseInfoServiceImpl";

	Page findWrnBaseInfoByCondition(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, 
			@ScubeParam("bWrnDebtPdoInfoDetail") NBWrnDebtPdoInfoDetail bWrnDebtPdoInfoDetail,@ScubeParam("flag") String flag);

	public Page AccountDebtPromptWarn(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,
									@ScubeParam("accountDebtQryVO") AccountDebtQryVO accountDebtQryVO) throws ScubeBizException;
	
	

}
