package com.huateng.scf.bas.crm.service;


import java.util.List;

import com.huateng.scf.bas.crm.model.BCrmBaseInfoAndEntInfo;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IIfspBcrmBaseService {

	// 用于客户新增页面，返回同时拥有两个表字段内容
	public List<BCrmBaseInfoAndEntInfo> findBCrmBaseInfoAndEnt(
			@ScubeParam("list") List<BCrmBaseInfoAndEntInfo> list);

}
