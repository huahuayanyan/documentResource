package com.huateng.scf.bas.common.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.CostQryVO;
import com.huateng.scf.rec.bcp.model.RBcpCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface ICostService {

	/**
	 * 
	 * @param costQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryTblCostOut(@ScubeParam("costQryVO") CostQryVO costQryVO) throws ScubeBizException;

	public void saveTblCostOut(@ScubeParam("tblCostOut") RBcpCostOut tblCostOut) throws ScubeBizException;

}
