package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdReceMatl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 应收材料信息接口
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
 * </pre>
 */
public interface IBPrdReceMatlService {

	String add(@ScubeParam("bPrdReceMatl") BPrdReceMatl bPrdReceMatl)
			throws ScubeBizException;

	int delete(@ScubeParam("id") String id) throws ScubeBizException;

	int update(@ScubeParam("bPrdReceMatl") BPrdReceMatl bPrdReceMatl)
			throws ScubeBizException;

	BPrdReceMatl findBPrdReceMatlByKey(
			@ScubeParam("bPrdReceMatl") BPrdReceMatl bPrdReceMatl)
			throws ScubeBizException;

	List<BPrdReceMatl> findBPrdReceMatlByBPrd(
			@ScubeParam("bPrdReceMatl") BPrdReceMatl bPrdReceMatl)
			throws ScubeBizException;

	Page findBPrdReceMatlByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdReceMatl bPrdReceMatl)
			throws ScubeBizException;

	// 批量查询
	List<BPrdReceMatl> selectByIdList(@ScubeParam("idList") List<String> idList) throws ScubeBizException;
	
	//根据集合:idList查询出对象Page
	Page selectByIdListToPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("idList") List<String> idList)
			throws ScubeBizException;

}
