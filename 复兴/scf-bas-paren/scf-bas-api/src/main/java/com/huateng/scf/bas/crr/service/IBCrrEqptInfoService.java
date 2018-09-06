package com.huateng.scf.bas.crr.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrEqptInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrEqptInfo接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:58:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:58:38	     新增
 *
 * </pre>
 */
public interface IBCrrEqptInfoService {
	/**
	 * @param bCrrEqptInfo
	 * @return
	 */
	public BCrrEqptInfo add(@ScubeParam("bCrrEqptInfo") BCrrEqptInfo bCrrEqptInfo);
	/**
	 * @param bCrrEqptInfo
	 * @return
	 */
	public int update(@ScubeParam("bCrrEqptInfo") BCrrEqptInfo bCrrEqptInfo);
	/**
	 * @param eqptId
	 * @return
	 */
	public int delete(@ScubeParam("eqptId") String eqptId);
	/**
	 * @param eqptIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("eqptIds") String eqptIds);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrEqptInfo
	 * @return
	 */
	public Page findbCrrEqptInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrEqptInfo") BCrrEqptInfo bCrrEqptInfo);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public HashMap<String, BCrrEqptInfo> findBCrrEqptInfoById(@ScubeParam("id") String id);
}
