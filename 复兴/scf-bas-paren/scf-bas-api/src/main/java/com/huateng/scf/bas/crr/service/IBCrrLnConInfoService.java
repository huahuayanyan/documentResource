package com.huateng.scf.bas.crr.service;

import java.util.List;

import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>放款申请，供应链补录，信贷合同信息列表显示</p>
 *
 * @author 	liph
 * @date 	2016年12月12日.下午1:45:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月12日.下午1:45:35	     新增
 *
 * </pre>
 */

public interface IBCrrLnConInfoService {
	@SuppressWarnings("rawtypes")
	public List findBCrrLnConInfoByPage(@ScubeParam("id")String appId,@ScubeParam("appno")String appno);
}
