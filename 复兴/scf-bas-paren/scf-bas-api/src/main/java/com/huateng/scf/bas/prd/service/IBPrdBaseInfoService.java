package com.huateng.scf.bas.prd.service;

import com.huateng.scf.bas.prd.model.BPrdBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBPrdBaseInfoService {
	// 这里不会有分页条件查询
	public String add(@ScubeParam("bPrdBaseInfo") BPrdBaseInfo bPrdBaseInfo)throws ScubeBizException;

	public int delete(@ScubeParam("productId") String productId)throws ScubeBizException;

	public int update(@ScubeParam("bPrdBaseInfo") BPrdBaseInfo bPrdBaseInfo)throws ScubeBizException;

	public BPrdBaseInfo findBPrdBaseInfoByKey(@ScubeParam("bPrdBaseInfo") BPrdBaseInfo bPrdBaseInfo) throws ScubeBizException;

}
