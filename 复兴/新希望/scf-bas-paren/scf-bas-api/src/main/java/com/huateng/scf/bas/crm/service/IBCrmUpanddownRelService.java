package com.huateng.scf.bas.crm.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmUpanddownRel;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmUpanddownRelService {
	// 上下游客户关系新增bCrmUpanddownRel
	public String add(@ScubeParam("bCrmUpanddownRel") BCrmUpanddownRel bCrmUpanddownRel);

	// 上下游客户关系删除
	public int delete(@ScubeParam("key") String key);

	// 上下游客户关系删除根据客户号
	public int deleteByCustcd(@ScubeParam("key") String custcd);

	// 上下游客户关系修改(修改是根据客户号，现在不考虑一个客户既是上游，又是下游客户的情况。)
	public int update(@ScubeParam("bCrmUpanddownRel") BCrmUpanddownRel bCrmUpanddownRel);

	// 查询上下游客户关系，返回单个对象。
	public BCrmUpanddownRel findBCrmUpanddownRelByKey(@ScubeParam("bCrmUpanddownRel") BCrmUpanddownRel bCrmUpanddownRel);

	// 查询上下游客户关系，返回对象集合。
	public List<BCrmUpanddownRel> findBCrmUpanddownRelByBCrm(@ScubeParam("bCrmUpanddownRel") BCrmUpanddownRel bCrmUpanddownRel);

	// 查询上下游客户关系，返回分页对象。
	public Page findBCrmUpanddownRelByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmUpanddownRel") BCrmUpanddownRel bCrmUpanddownRel);
}
