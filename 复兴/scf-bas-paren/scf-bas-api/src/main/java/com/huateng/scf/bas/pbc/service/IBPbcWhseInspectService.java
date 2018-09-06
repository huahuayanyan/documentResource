package com.huateng.scf.bas.pbc.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>押品变更流水信息接口</p>
 *
 * @author 	liph
 * @date 2016年12月29日上午9:43:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * liph		   2016年12月29日上午9:43:48              新增
 *
 * </pre>
 */
public interface IBPbcWhseInspectService {
	public Page findHk(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appno") String appno);
}
