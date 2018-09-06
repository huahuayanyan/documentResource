package com.huateng.scf.bas.crm.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmRelationInfo;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmRelationInfoService {
	// 客户关联关系新增
	public String add(@ScubeParam("bCrmRelationInfo") BCrmRelationInfo bCrmRelationInfo);

	// 客户关联关系删除
	public int delete(@ScubeParam("key") String key);

	// 客户关联关系修改
	public int update(@ScubeParam("bCrmRelationInfo") BCrmRelationInfo bCrmRelationInfo);

	// 查询客户关联关系，返回单个对象。
	public BCrmRelationInfo findBCrmRelationInfoByKey(
			@ScubeParam("bCrmRelationInfo") BCrmRelationInfo bCrmRelationInfo);

	// 查询客户关联关系，返回对象集合。
	public List<BCrmRelationInfo> findBCrmRelationInfoByBCrm(
			@ScubeParam("bCrmRelationInfo") BCrmRelationInfo bCrmRelationInfo);

	// 查询客户关联关系，返回分页对象。
	public Page findBCrmRelationInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmRelationInfo") BCrmRelationInfo bCrmRelationInfo);
}
