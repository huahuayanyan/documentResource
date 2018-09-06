package com.huateng.scf.bas.crr.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrLnApp;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BCrrLnApp接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:54:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:54:10	     新增
 *
 * </pre>
 */
public interface IBCrrLnAppService{
	/**
	 * @param bCrrLnApp
	 * @return
	 */
	public BCrrLnApp add(@ScubeParam("bCrrLnApp") BCrrLnApp bCrrLnApp);
	/**
	 * @param bCrrLnApp
	 * @return
	 */
	public BCrrLnApp cachadd(@ScubeParam("bCrrLnApp") BCrrLnApp bCrrLnApp);
	/**
	 * @param bCrrLnApp
	 * @return
	 */
	public int update(@ScubeParam("bCrrLnApp") BCrrLnApp bCrrLnApp);
	/**
	 * @param appId
	 * @return
	 */
	public int delete(@ScubeParam("bCrrLnApp") BCrrLnApp bCrrLnApp);
	/**
	 * @param appIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrLnApp> list);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param BCrrLnApp
	 * @return
	 */
	public Page findBCrrLnAppByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnApp") BCrrLnApp bCrrLnApp);
	/**
	 * 
	 * @param bCrrLnApp
	 * @return
	 * @throws Exception 
	 */
	public String submit(@ScubeParam("bCrrLnApp") BCrrLnApp bCrrLnApp);
	/**
	 * 
	 * @param appId
	 * @return
	 */
	public BCrrLnApp findBCrrLnAppByAppId(@ScubeParam("appId") String appId);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page queryCustSource(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);
}
