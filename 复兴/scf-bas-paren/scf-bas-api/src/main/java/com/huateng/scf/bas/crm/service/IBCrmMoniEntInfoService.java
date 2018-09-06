package com.huateng.scf.bas.crm.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.model.BCrmMoniEntInfo;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmMoniEntInfoService {
	// 监管公司信息新增
	public String add(@ScubeParam("bCrmMoniEntInfo") BCrmMoniEntInfo bCrmMoniEntInfo);

	// 监管公司信息删除（根据客户号）
	public int delete(@ScubeParam("key") String key);

	// 监管公司信息删除（根据客户号）
	public int deleteMoniRelatedByCustcd(@ScubeParam("key") String custcd);

	// 监管公司信息修改
	public int update(@ScubeParam("bCrmMoniEntInfo") BCrmMoniEntInfo bCrmMoniEntInfo);

	// 查询监管公司信息，返回单个对象。
	public BCrmMoniEntInfo findBCrmMoniEntInfoByKey(@ScubeParam("bCrmMoniEntInfo") BCrmMoniEntInfo bCrmMoniEntInfo);

	/*
	 * // 查询监管公司信息，返回单个对象。(给table表显示的，需要把多选的选项给拆分成集合) public BCrmMoniEntInfo
	 * findBCrmMoniEntInfoByKeyForTable(@ScubeParam("bCrmMoniEntInfo")
	 * BCrmMoniEntInfo bCrmMoniEntInfo);
	 */

	// 查询监管公司信息，返回对象集合。
	public List<BCrmMoniEntInfo> findBCrmMoniEntInfoByBCrm(@ScubeParam("bCrmMoniEntInfo") BCrmMoniEntInfo bCrmMoniEntInfo);

	// 查询监管公司信息，返回分页对象。
	public Page findBCrmMoniEntInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmMoniEntInfo") BCrmMoniEntInfo bCrmMoniEntInfo);

}
