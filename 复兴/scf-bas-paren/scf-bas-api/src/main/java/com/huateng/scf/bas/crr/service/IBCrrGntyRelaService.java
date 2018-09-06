package com.huateng.scf.bas.crr.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrGntyRela;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BCrrGntyRela接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:30:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:30:08	     新增
 *
 * </pre>
 */
public interface IBCrrGntyRelaService {
	/**
	 * @param BCrrGntyRela
	 * @return
	 */
	public BCrrGntyRela add(@ScubeParam("bCrrGntyRela") BCrrGntyRela bCrrGntyRela);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyRela
	 * @return
	 */
	public Page findBCrrGntyRelaByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrGntyRela") BCrrGntyRela bCrrGntyRela);
	/**
	 * 
	 * @param bCrrGntyRela
	 * @return
	 */
	public BCrrGntyRela findBCrrGntyRelaByGntyId(@ScubeParam("rltNo") String rltNo);
	/**
	 * 缓存
	 * @param bCrrGntyRela
	 * @return
	 */
	public BCrrGntyRela cachadd(@ScubeParam("bCrrGntyRela") BCrrGntyRela bCrrGntyRela);
}
