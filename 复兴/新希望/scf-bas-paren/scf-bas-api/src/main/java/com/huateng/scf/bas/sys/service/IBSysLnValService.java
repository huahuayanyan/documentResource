package com.huateng.scf.bas.sys.service;

import java.util.List;

import com.huateng.scf.bas.sys.model.BSysLnVal;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BSysLnVal接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午11:20:47
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午11:20:47	     新增
 *
 * </pre>
 */
public interface IBSysLnValService {
	/**
	 * 
	 * @param bSysLnVal
	 * @return
	 */
	public BSysLnVal add(@ScubeParam("bSysLnVal") BSysLnVal bSysLnVal);
	/**
	 * 
	 * @param bSysLnVal
	 * @return
	 */
	public int update(@ScubeParam("bSysLnVal") BSysLnVal bSysLnVal);
	/**
	 * 
	 * @param bSysLnVal
	 * @return
	 */
	public int delete(@ScubeParam("bSysLnVal") BSysLnVal bSysLnVal);
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BSysLnVal> list);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bSysLnVal
	 * @return
	 */
//	public Page findBSysLnValByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bSysLnVal") BSysLnVal bSysLnVal);
}
