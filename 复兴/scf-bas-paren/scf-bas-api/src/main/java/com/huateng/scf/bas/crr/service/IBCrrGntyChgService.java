package com.huateng.scf.bas.crr.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrGntyChg;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrGntyChg接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:41:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:41:46	     新增
 *
 * </pre>
 */
public interface IBCrrGntyChgService {
	/**
	 * @param bCrrGntyChg
	 * @return
	 */
	public void add(@ScubeParam("bCrrGntyChg") BCrrGntyChg bCrrGntyChg);
	/**
	 * @param bCrrGntyChg
	 * @return
	 */
	public int update(@ScubeParam("bCrrGntyChg") BCrrGntyChg bCrrGntyChg);
	/**
	 * @param serialno
	 * @return
	 */
	public int delete(@ScubeParam("serialno") String serialno);
	/**
	 * @param serialnos
	 * @return
	 */
	public int batchDelete(@ScubeParam("serialnos") String serialnos);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyChg
	 * @return
	 */
	public Page findbCrrGntyChgByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrGntyChg") BCrrGntyChg bCrrGntyChg);
}
