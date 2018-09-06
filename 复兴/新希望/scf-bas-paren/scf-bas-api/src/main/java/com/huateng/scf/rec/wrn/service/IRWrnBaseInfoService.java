package com.huateng.scf.rec.wrn.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.AccountDebtQryVO;
import com.huateng.scf.rec.wrn.model.BWrnDebtPdoInfoDetail;
import com.huateng.scf.rec.wrn.model.BWrnRiskOfInfoDetail;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>wrnbaseinfo接口类</p>
 *
 * @author 	liph
 * @date 	2016年12月27日下午3:11:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月27日下午3:11:42	     新增
 *
 * </pre>
 */
public interface IRWrnBaseInfoService {
	/**应收账款催收提示*/
	public Page findWrnBaseInfoByCondition(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, 
			@ScubeParam("bWrnDebtPdoInfoDetail") BWrnDebtPdoInfoDetail bWrnDebtPdoInfoDetail,@ScubeParam("flag") String flag);
	/**敞口无法覆盖预警*/
	public Page findWrnRiskOfInfoByCondition(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, 
			@ScubeParam("bWrnRiskOfInfoDetail") BWrnRiskOfInfoDetail bWrnRiskOfInfoDetail,@ScubeParam("flag") String flag);
	/**
	 * 应收账款到期提醒
	 * @param pageNo
	 * @param pageSize
	 * @param accountDebtQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page AccountDebtPromptWarn(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("accountDebtQryVO") AccountDebtQryVO accountDebtQryVO) throws ScubeBizException;
	
}
