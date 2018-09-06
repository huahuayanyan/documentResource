/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>审批公共服务接口
 * 1.审批意见<br>
 * 2.审批历史<br>
 * </p>
 *
 * @author 	huangshuidan
 * @date 2016年11月16日下午5:58:48	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月16日下午5:58:48              新增
 *
 * </pre>
 */
public interface IBSysApplyDtlService {
	/**
	 * 保存审批意见
	 * @param bSysApplyDtl
	 * 		BSysApplyDtl对象
	 * @return String
	 */
	public String saveBSysApplyDtl(@ScubeParam("bSysApplyDtl") BSysApplyDtl bSysApplyDtl) throws ScubeBizException;
	/**
	 * 分页查询审批意见、审批历史记录
	 * @param pageNo
	 * 		int-当前页码
	 * @param pageSize
	 * 		int-每页大小
	 * @param bSysApplyDtl
	 * 		BSysApplyDtl对象
	 * @return Page对象
	 * @throws ScubeBizException
	 */
	public Page queryBSysApplyDtlListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bSysApplyDtl") BSysApplyDtl bSysApplyDtl) throws ScubeBizException;
}
