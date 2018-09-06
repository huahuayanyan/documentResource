package com.huateng.scf.bas.crr.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrInvInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrInvInfo接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:54:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:54:30	     新增
 *
 * </pre>
 */
public interface IBCrrInvInfoService {
	/**
	 * @param bCrrInvInfo
	 * @return
	 */
	public BCrrInvInfo add(@ScubeParam("bCrrInvInfo") BCrrInvInfo bCrrInvInfo);
	/**
	 * @param bCrrInvInfo
	 * @return
	 */
	public int update(@ScubeParam("bCrrInvInfo") BCrrInvInfo bCrrInvInfo);
	/**
	 * @param invId
	 * @return
	 */
	public int delete(@ScubeParam("bCrrInvInfo") BCrrInvInfo bCrrInvInfo);
	/**
	 * @param invIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrInvInfo> list);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrInvInfo
	 * @return
	 */
	public Page findbCrrInvInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrInvInfo") BCrrInvInfo bCrrInvInfo);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public HashMap<String, BCrrInvInfo> findBCrrInvInfoById(@ScubeParam("id") String id);
}
