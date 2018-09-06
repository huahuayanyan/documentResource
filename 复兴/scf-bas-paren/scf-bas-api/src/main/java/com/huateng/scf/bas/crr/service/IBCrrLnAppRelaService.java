package com.huateng.scf.bas.crr.service;

import com.huateng.scf.bas.crr.model.BCrrLnAppRela;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrLnAppRela接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:21:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:21:35	     新增
 *
 * </pre>
 */
public interface IBCrrLnAppRelaService {
	/**
	 * @param bCrrLnAppRela
	 * @return
	 */
	public void add(@ScubeParam("bCrrLnAppRela") BCrrLnAppRela bCrrLnAppRela);
}
