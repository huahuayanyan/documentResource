package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdCopLibBind;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 产品组件关联信息服务接口
 * </p>
 * 
 * @author huangshuidan
 * @date 2016-12-8 4:05:13 PM
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016-12-8 4:05:13 PM             新增
 * 
 * </pre>
 */

public interface IBPrdCopLibBindService {
	public String add(@ScubeParam("bPrdCopLibBind") BPrdCopLibBind bPrdCopLibBind)throws ScubeBizException;

	public int delete(@ScubeParam("id") String id)throws ScubeBizException;
	
	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	public int deleteByProductId(@ScubeParam("productId") String productId)throws ScubeBizException;

	public int update(@ScubeParam("bPrdCopLibBind") BPrdCopLibBind bPrdCopLibBind)throws ScubeBizException;

	public BPrdCopLibBind findBPrdCopLibBindByKey(@ScubeParam("bPrdCopLibBind") BPrdCopLibBind bPrdCopLibBind)throws ScubeBizException;

	public List<BPrdCopLibBind> findBPrdCopLibBindBPrd(
			@ScubeParam("bPrdCopLibBind") BPrdCopLibBind bPrdCopLibBind) throws ScubeBizException;

	public Page findBPrdCopLibBindByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdCopLibBind bPrdCopLibBind) throws ScubeBizException;

}
