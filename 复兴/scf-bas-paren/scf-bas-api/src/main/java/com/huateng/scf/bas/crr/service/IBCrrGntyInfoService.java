package com.huateng.scf.bas.crr.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrGntyInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrGntyInfo接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:33:59
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:33:59	     新增
 *
 * </pre>
 */
public interface IBCrrGntyInfoService {
	/**
	 * @param bCrrGntyInfo
	 * @return
	 */
	public void add(@ScubeParam("bCrrGntyInfo") BCrrGntyInfo bCrrGntyInfo);
	/**
	 * @param bCrrGntyInfo
	 * @return
	 */
	public int update(@ScubeParam("bCrrGntyInfo") BCrrGntyInfo bCrrGntyInfo);
	/**
	 * @param guarantyids
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrGntyInfo> list);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyInfo
	 * @return
	 */
	public Page findBCrrGntyInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrGntyInfo") BCrrGntyInfo bCrrGntyInfo);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param list
	 * @return
	 */
	public Page findBCrrGntyInfoByPageAndConId(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("list") List<BCrrGntyCon> list);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public List<TreeModel> changeGuarantyListToTree(@ScubeParam("value") HashMap<String, String> value);
}
