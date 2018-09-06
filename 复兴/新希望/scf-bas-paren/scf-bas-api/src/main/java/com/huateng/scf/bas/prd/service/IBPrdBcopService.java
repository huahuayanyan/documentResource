package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdBcop;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * <p>
 * 业务组件信息接口
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
public interface IBPrdBcopService {
	public String add(@ScubeParam("bPrdBcop") BPrdBcop bPrdBcop) throws ScubeBizException;

	public int delete(@ScubeParam("id") String id) throws ScubeBizException;

	public int update(@ScubeParam("bPrdBcop") BPrdBcop bPrdBcop)throws ScubeBizException;

	public BPrdBcop findBPrdBcopByKey(@ScubeParam("bPrdBcop") BPrdBcop bPrdBcop)throws ScubeBizException;

	public List<BPrdBcop> findBPrdBcopByBPrd(
			@ScubeParam("bPrdBcop") BPrdBcop bPrdBcop)throws ScubeBizException;

	// public int batchDelete(@ScubeParam("idList") List idList);

	/*
	 * // 专门用于页面下拉搜索框的分页查询
	 * Page selectBPrdBcopBySelect(@ScubeParam("pageNo") int pageNo,
	 * @ScubeParam("pageSize") int pageSize,
	 * 
	 * @ScubeParam("value") BPrdBcop BPrdBcop);
	 */

	public Page findBPrdBcopByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdBcop bPrdBcop) throws ScubeBizException;

}
