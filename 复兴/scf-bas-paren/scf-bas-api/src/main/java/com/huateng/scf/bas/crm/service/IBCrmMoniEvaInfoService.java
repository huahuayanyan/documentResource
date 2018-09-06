package com.huateng.scf.bas.crm.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmMoniEvaInfo;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmMoniEvaInfoService {
	// 监管公司信息新增
	public String add(@ScubeParam("bCrmMoniEvaInfo") BCrmMoniEvaInfo bCrmMoniEvaInfo);

	// 监管公司信息删除（根据客户号）
	public int delete(@ScubeParam("key") String key);

	// 监管公司信息修改
	public int update(@ScubeParam("bCrmMoniEvaInfo") BCrmMoniEvaInfo bCrmMoniEvaInfo);

	// 查询监管公司信息，返回单个对象。
	public BCrmMoniEvaInfo findBCrmMoniEvaInfoByKey(@ScubeParam("bCrmMoniEvaInfo") BCrmMoniEvaInfo bCrmMoniEvaInfo);

	// 查询监管公司信息，返回对象集合。
	public List<BCrmMoniEvaInfo> findBCrmMoniEvaInfoByBCrm(
			@ScubeParam("bCrmMoniEvaInfo") BCrmMoniEvaInfo bCrmMoniEvaInfo);

	// 查询监管公司信息，返回分页对象。
	public Page findBCrmMoniEvaInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmMoniEvaInfo") BCrmMoniEvaInfo bCrmMoniEvaInfo);

}
