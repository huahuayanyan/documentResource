package com.huateng.scf.bas.cnt.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BPbcMtgBaseInfoDO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntStockAdjustService {

	/**
	 * 新增库存
	 * 
	 * @param bPbcMtgBaseInfo
	 * @throws ScubeBizException
	 */
	public void saveStockAdjust(@ScubeParam("bPbcMtgBaseInfoDO") BPbcMtgBaseInfoDO bPbcMtgBaseInfoDO)
			throws ScubeBizException;

	public Page getSlaveContcode(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon);
	
	/**
	 * 调整库存
	 * @param bPbcMtgBaseInfoDO
	 * @throws ScubeBizException
	 */
	public void updateStockAdjust(@ScubeParam("bPbcMtgBaseInfoDO") BPbcMtgBaseInfoDO bPbcMtgBaseInfoDO)
			throws ScubeBizException;

}
