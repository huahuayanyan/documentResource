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
public interface IBCrrDuebillAppService{
	/**
	 * @param bCrrDuebillApp
	 * @return
	 */
	public BCrrDuebillApp add(@ScubeParam("bCrrDuebillApp") BCrrDuebillApp bCrrDuebillApp);
	/**
	 * @param bCrrDuebillApp
	 * @return
	 */
	public int update(@ScubeParam("bCrrDuebillApp") BCrrDuebillApp bCrrDuebillApp);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrDuebillApp
	 * @return
	 */
	public Page findBCrrDuebillAppByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrDuebillApp") BCrrDuebillApp bCrrDuebillApp);
	/**
	 * 
	 * @param appId
	 * @return
	 */
	public BCrrDuebillApp findBCrrDuebillAppByAppId(@ScubeParam("appId") String appId);
	/**
	 * 
	 * @param bCrrDuebillApp
	 */
	public BCrrDuebillApp submit(@ScubeParam("bCrrDuebillApp") BCrrDuebillApp bCrrDuebillApp);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public BCrrDuebillApp findBCrrDuebillAppById(@ScubeParam("id") String id);
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrDuebillApp> list);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page queryLnConSource(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);
	/**
	 * 
	 * @param bCrrDuebillApp
	 * @param processEntity
	 */
	public void connectVid(@ScubeParam("bCrrDuebillApp") BCrrDuebillApp bCrrDuebillApp,@ScubeParam("processModel") ProcessModel processModel);
	/**
	 * 
	 * @param id
	 * @param flag
	 */
	public void isHide(@ScubeParam("id") String id,@ScubeParam("flag") String flag);
	
	public BCrrDuebillApp findBCrrDuebillAppByIdid(@ScubeParam("id") String id);
}
