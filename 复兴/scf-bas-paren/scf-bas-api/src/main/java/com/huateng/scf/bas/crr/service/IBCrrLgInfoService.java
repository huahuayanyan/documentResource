package com.huateng.scf.bas.crr.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrLgInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月15日上午8:54:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月15日上午8:54:34	     新增
 *
 * </pre>
 */
public interface IBCrrLgInfoService {
	/**
	 * @param bCrrLgInfo
	 * @return
	 */
	public BCrrLgInfo add(@ScubeParam("bCrrLgInfo") BCrrLgInfo bCrrLgInfo);
	/**
	 * @param bCrrLgInfo
	 * @return
	 */
	public int update(@ScubeParam("bCrrLgInfo") BCrrLgInfo bCrrLgInfo);
	/**
	 * @param lgId
	 * @return
	 */
	public int delete(@ScubeParam("lgId") String lgId);
	/**
	 * @param lgIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("lgIds") String lgIds);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrLgInfo
	 * @return
	 */
	public Page findbCrrLgInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLgInfo") BCrrLgInfo bCrrLgInfo);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public HashMap<String, BCrrLgInfo> findBCrrLgInfoById(@ScubeParam("id") String id);
}
