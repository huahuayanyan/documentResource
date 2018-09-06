/**
 * 
 */
package com.huateng.scf.bas.cnt.service;



import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * XXX
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年11月28日.下午4:51:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月28日.下午4:51:24	     新增
 *
 *            </pre>
 */

public interface IIfspBCntDebtInfoService {

	
	// ext
	/***
	 * 应收账款合同列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page queryBCntDebtInfoListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	
	




	

	
}
