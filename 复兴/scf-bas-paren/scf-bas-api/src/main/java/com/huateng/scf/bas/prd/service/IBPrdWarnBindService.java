package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdWarnBind;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBPrdWarnBindService {
	public String add(@ScubeParam("bPrdWarnBind") BPrdWarnBind bPrdWarnBind) throws ScubeBizException;

	//批量添加
	public String batchAdd(@ScubeParam("bPrdWarnBindList") List<BPrdWarnBind> bPrdWarnBindList) throws ScubeBizException;

	
	public int delete(@ScubeParam("id") String id) throws ScubeBizException;

	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
    int  deleteByProductId(@ScubeParam("productId") String productId)throws ScubeBizException;
	
	public int update(@ScubeParam("bPrdWarnBind") BPrdWarnBind bPrdWarnBind) throws ScubeBizException;

	public BPrdWarnBind findBPrdWarnBindByKey(@ScubeParam("bPrdWarnBind") BPrdWarnBind bPrdWarnBind) throws ScubeBizException;

	// 下拉和正常分页均可
	public Page selectBPrdWarnBindByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdWarnBind bPrdWarnBind) throws ScubeBizException;

}
