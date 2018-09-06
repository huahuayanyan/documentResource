package com.huateng.scf.bas.crr.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrBillInfo;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BCrrBillInfo接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午7:56:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午7:56:08	     新增
 *
 * </pre>
 */
public interface IBCrrBillInfoService {
	/**
	 * @param bCrrBillInfo
	 * @return
	 */
	public BCrrBillInfo add(@ScubeParam("bCrrBillInfo") BCrrBillInfo bCrrBillInfo);
	/**
	 * @param bCrrBillInfo
	 * @return
	 */
	public int update(@ScubeParam("bCrrBillInfo") BCrrBillInfo bCrrBillInfo);
	/**
	 * @param bCrrBillInfo
	 * @return
	 */
	public int delete(@ScubeParam("bCrrBillInfo") BCrrBillInfo bCrrBillInfo);
	/**
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrBillInfo> list);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrBillInfo
	 * @return
	 */
	public Page findBCrrBillInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrBillInfo") BCrrBillInfo bCrrBillInfo);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public HashMap<String, BCrrBillInfo> findBCrrBillInfoById(@ScubeParam("id") String id);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page findBCrrBillInfoByPageExt(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value);
}
