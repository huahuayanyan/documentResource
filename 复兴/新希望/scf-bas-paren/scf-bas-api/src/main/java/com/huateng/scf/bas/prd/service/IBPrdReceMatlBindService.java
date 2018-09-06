package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdReceMatlBind;
import com.huateng.scf.bas.prd.model.BPrdWarnBind;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;


/**
 * <p>
 * 应收材料关联表信息接口
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月1日上午10:06:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月1日上午10:06:04              新增
 *
 *            </pre>
 */
public interface IBPrdReceMatlBindService {
	String add(@ScubeParam("bPrdReceMatlBind") BPrdReceMatlBind bPrdReceMatlBind)
			throws ScubeBizException;
	//批量添加
		public String batchAdd(@ScubeParam("bPrdReceMatlBindList") List<BPrdReceMatlBind> bPrdReceMatlBindList) throws ScubeBizException;

	
	int delete(@ScubeParam("id") String id) throws ScubeBizException;

	/**
	 * 通过应收材料receMatlId删除
	 * @param receMatlId :应收材料Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	int deleteByReceMatlId(@ScubeParam("receMatlId") String receMatlId) throws ScubeBizException;
	
	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
    int  deleteByProductId(@ScubeParam("productId") String productId)throws ScubeBizException;
	
    int update(@ScubeParam("bPrdReceMatlBind") BPrdReceMatlBind bPrdReceMatlBind)
			throws ScubeBizException;

	BPrdReceMatlBind findBPrdReceMatlBindByKey(@ScubeParam("bPrdReceMatlBind") BPrdReceMatlBind bPrdReceMatlBind)
			throws ScubeBizException;

	List<BPrdReceMatlBind> findBPrdReceMatlBindByBPrd(@ScubeParam("bPrdReceMatlBind") BPrdReceMatlBind bPrdReceMatlBind)
			throws ScubeBizException;

	Page findBPrdReceMatlBindByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdReceMatlBind bPrdReceMatlBind)
			throws ScubeBizException;

	//根据productId查询
	List<BPrdReceMatlBind> findBPrdReceMatlBindByProductId(@ScubeParam("productId")
			String productId) throws ScubeBizException;

}
