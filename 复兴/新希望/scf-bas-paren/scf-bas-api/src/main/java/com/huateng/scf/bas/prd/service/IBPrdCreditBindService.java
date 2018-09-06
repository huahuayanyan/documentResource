package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
* <p>
* 产品额度绑定服务接口
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
public interface IBPrdCreditBindService {
	
	public String add(@ScubeParam("bPrdCreditBind") BPrdCreditBind bPrdCreditBind)throws ScubeBizException;

	public int delete(@ScubeParam("id") String id) throws ScubeBizException;

	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	public int deleteByProductId(@ScubeParam("productId") String productId)throws ScubeBizException;
	
	public int update(@ScubeParam("bPrdCreditBind") BPrdCreditBind bPrdCreditBind)throws ScubeBizException;

	public BPrdCreditBind findBPrdCreditBindByKey(@ScubeParam("bPrdCreditBind") BPrdCreditBind bPrdCreditBind)throws ScubeBizException;

	public List<BPrdCreditBind> findBPrdCreditBindBPrd(
			@ScubeParam("bPrdCreditBind") BPrdCreditBind bPrdCreditBind) throws ScubeBizException;

	public Page findBPrdCreditBindByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdCreditBind bPrdCreditBind) throws ScubeBizException;
	/**
	 * 
	 * @param tblProductCreditBind
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BPrdCreditBind> getTblProductCreditBind(@ScubeParam("tblProductCreditBind") BPrdCreditBind tblProductCreditBind) throws ScubeBizException;

}
