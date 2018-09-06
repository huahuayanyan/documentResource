package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdBizSurBind;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
* <p>
* 产品业务调查关联服务接口
* </p>
*
* @author huangshuidan
* @date 2016年11月22日上午10:06:04
* @version 1.0
* @Copyright Shanghai Huateng Software Systems Co., Ltd.
*
*            <pre>
* =================Modify Record=======================
* Modifier			   date			              Content
* huangshuidan		   2016年12月2日上午10:06:04              新增
*
*            </pre>
*/
public interface IBPrdBizSurBindService {
	String add(@ScubeParam("bPrdBizSurBind") BPrdBizSurBind bPrdBizSurBind)
			throws ScubeBizException;
	//批量添加
		public String batchAdd(@ScubeParam("bPrdBizSurBindList") List<BPrdBizSurBind> bPrdBizSurBindList) throws ScubeBizException;

	int delete(@ScubeParam("id") String id) throws ScubeBizException;
		
	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	int deleteByProductId(@ScubeParam("productId") String productId) throws ScubeBizException;
	
	int update(@ScubeParam("bPrdBizSurBind") BPrdBizSurBind bPrdBizSurBind)
			throws ScubeBizException;

	BPrdBizSurBind findBPrdBizSurBindByKey(@ScubeParam("bPrdBizSurBind") BPrdBizSurBind bPrdBizSurBind)
			throws ScubeBizException;

	List<BPrdBizSurBind> findBPrdBizSurBindByBPrd(@ScubeParam("bPrdBizSurBind") BPrdBizSurBind bPrdBizSurBind)
			throws ScubeBizException;

	Page findBPrdBizSurBindByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdBizSurBind bPrdBizSurBind)
			throws ScubeBizException;
}
