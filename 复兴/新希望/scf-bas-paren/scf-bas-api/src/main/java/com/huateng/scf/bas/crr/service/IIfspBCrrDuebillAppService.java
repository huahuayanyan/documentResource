package com.huateng.scf.bas.crr.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrDuebillApp;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BCrrDuebillApp接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:18:50
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:18:50	     新增
 *
 * </pre>
 */
public interface IIfspBCrrDuebillAppService{
	/**
	 * @param bCrrDuebillApp
	 * @return
	 */
	public BCrrDuebillApp add(@ScubeParam("bCrrDuebillApp") BCrrDuebillApp bCrrDuebillApp);
	public BCrrDuebillApp findBCrrDuebillAppByIfspAppno(@ScubeParam("ifspAppno")String ifspAppno);
}
