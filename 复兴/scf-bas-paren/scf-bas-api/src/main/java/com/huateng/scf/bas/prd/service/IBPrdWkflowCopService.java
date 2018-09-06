package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 流程组件信息接口
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月2日上午10:06:04
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
public interface IBPrdWkflowCopService {
	public String add(@ScubeParam("bPrdWkflowCop") BPrdWkflowCop bPrdWkflowCop)throws ScubeBizException;

	public int delete(@ScubeParam("id") String id)throws ScubeBizException;

	public int update(@ScubeParam("bPrdWkflowCop") BPrdWkflowCop bPrdWkflowCop)throws ScubeBizException;

	public BPrdWkflowCop findBPrdWkflowCopByKey(@ScubeParam("bPrdWkflowCop") BPrdWkflowCop bPrdWkflowCop)throws ScubeBizException;

	public List<BPrdWkflowCop> findBPrdWkflowCopByBPrd(
			@ScubeParam("bPrdWkflowCop") BPrdWkflowCop bPrdWkflowCop)throws ScubeBizException;

	public Page findBPrdWkflowCopByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdWkflowCop bPrdWkflowCop) throws ScubeBizException;
	/**
	 * 根据流程组件对象查询流程组件（单笔）
	 * @param bPrdWkflowCop
	 * @return
	 * @throws ScubeBizException
	 */
	public BPrdWkflowCop queryBPrdWkflowCopByBPrd(@ScubeParam("bPrdWkflowCop") BPrdWkflowCop bPrdWkflowCop)
			throws ScubeBizException;

}
