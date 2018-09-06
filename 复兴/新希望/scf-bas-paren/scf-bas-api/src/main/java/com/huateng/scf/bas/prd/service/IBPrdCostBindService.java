package com.huateng.scf.bas.prd.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdCostBind;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBPrdCostBindService {

	public String add(@ScubeParam("bPrdCostBind") BPrdCostBind bPrdCostBind)throws ScubeBizException;

	public int delete(@ScubeParam("id") String id)throws ScubeBizException;

	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	public int deleteByProductId(@ScubeParam("productId") String productId)throws ScubeBizException;
	
	public int update(@ScubeParam("bPrdCostBind") BPrdCostBind bPrdCostBind)throws ScubeBizException;

	public BPrdCostBind findBPrdCostBindByKey(@ScubeParam("bPrdCostBind") BPrdCostBind bPrdCostBind)throws ScubeBizException;

	// 下拉和正常分页均可
	public Page selectBPrdCostBindByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdCostBind bPrdCostBind)throws ScubeBizException;

}
