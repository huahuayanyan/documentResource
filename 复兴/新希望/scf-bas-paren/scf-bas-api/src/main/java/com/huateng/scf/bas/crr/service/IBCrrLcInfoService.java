package com.huateng.scf.bas.crr.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrLcInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrLcInfo接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:56:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:56:51	     新增
 *
 * </pre>
 */
public interface IBCrrLcInfoService {
	/**
	 * @param bCrrLcInfo
	 * @return
	 */
	public BCrrLcInfo add(@ScubeParam("bCrrLcInfo") BCrrLcInfo bCrrLcInfo);
	/**
	 * @param bCrrLcInfo
	 * @return
	 */
	public int update(@ScubeParam("bCrrLcInfo") BCrrLcInfo bCrrLcInfo);
	/**
	 * @param lcId
	 * @return
	 */
	public int delete(@ScubeParam("lcId") String lcId);
	/**
	 * @param lcIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("lcIds") String lcIds);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrLcInfo
	 * @return
	 */
	public Page findbCrrLcInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLcInfo") BCrrLcInfo bCrrLcInfo);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public HashMap<String, BCrrLcInfo> findBCrrLcInfoById(@ScubeParam("id") String id);
}
