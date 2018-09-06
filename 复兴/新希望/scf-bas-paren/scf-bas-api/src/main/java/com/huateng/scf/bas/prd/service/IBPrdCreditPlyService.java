package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdCreditPly;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 授信政策服务接口
 * </p>
 * 
 * @author huangshuidan
 * @date 2016年12月7日上午10:06:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月7日上午10:06:04              新增
 * 
 * </pre>
 */
public interface IBPrdCreditPlyService {
	String add(@ScubeParam("bPrdCreditPly") BPrdCreditPly bPrdCreditPly)
			throws ScubeBizException;
	int update(@ScubeParam("bPrdCreditPly") BPrdCreditPly bPrdCreditPly)
			throws ScubeBizException;
	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
    int  deleteByProductId(@ScubeParam("productId") String productId)throws ScubeBizException;
	
    int delete(@ScubeParam("id") String id) throws ScubeBizException;

	BPrdCreditPly findBPrdCreditPlyByKey(@ScubeParam("bPrdCreditPly") BPrdCreditPly bPrdCreditPly)
			throws ScubeBizException;

	List<BPrdCreditPly> findBPrdCreditPlyByBPrd(@ScubeParam("bPrdCreditPly") BPrdCreditPly bPrdCreditPly)
			throws ScubeBizException;

	Page findBPrdCreditPlyByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdCreditPly bPrdCreditPly)
			throws ScubeBizException;
	
	//通过产品Id查询
	BPrdCreditPly findBPrdCreditPlyByProductId(@ScubeParam("bPrdCreditPly")BPrdCreditPly bPrdCreditPly)
			throws ScubeBizException;

}
