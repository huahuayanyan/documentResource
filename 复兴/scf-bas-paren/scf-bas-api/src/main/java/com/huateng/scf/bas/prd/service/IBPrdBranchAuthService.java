package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.scf.bas.prd.model.BPrdBranchAuth;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBPrdBranchAuthService {

	/**
	 * 根据产品ID和机构号查询信息，用于最低控货价值调整校验分支行是否有产品授权
	 * @param productId
	 * @param brcode
	 * @return
	 */
	public List<BPrdBranchAuth> findBPrdBranchAuthByProductIdAndBrcode(@ScubeParam("productId") String productId,@ScubeParam("brcode") String brcode);
}
