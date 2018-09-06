package com.huateng.scf.bas.crr.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrDuebill;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrDuebill接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:00:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:00:49	     新增
 *
 * </pre>
 */
public interface IBCrrDuebillService {
	/**
	 * @param bCrrDuebill
	 * @return
	 */
	public void add(@ScubeParam("bCrrDuebill") BCrrDuebill bCrrDuebill);
	/**
	 * @param bCrrDuebill
	 * @return
	 */
	public int update(@ScubeParam("bCrrDuebill") BCrrDuebill bCrrDuebill);
	/**
	 * @param cinos
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrDuebill> list);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrDuebill
	 * @return
	 */
	public Page findBCrrDuebillByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrDuebill") BCrrDuebill bCrrDuebill);
}
