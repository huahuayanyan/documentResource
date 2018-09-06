package com.huateng.scf.bas.sys.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.model.BSysLnCd;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BSysLnCd接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午11:20:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午11:20:24	     新增
 *
 * </pre>
 */
public interface IBSysLnCdService {
	/**
	 * 
	 * @param bSysLnCd
	 * @return
	 */
	public BSysLnCd add(@ScubeParam("bSysLnCd") BSysLnCd bSysLnCd);
	/**
	 * 
	 * @param bSysLnCd
	 * @return
	 */
	public int update(@ScubeParam("bSysLnCd") BSysLnCd bSysLnCd);
	/**
	 * 
	 * @param bSysLnCd
	 * @return
	 */
	public int delete(@ScubeParam("bSysLnCd") BSysLnCd bSysLnCd);
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BSysLnCd> list);
	/**
	 * 
	 * @param bSysLnCd
	 * @return
	 */
	public String checkLnCd(@ScubeParam("bSysLnCd") BSysLnCd bSysLnCd);
	/**
	 * 
	 * @param ratename
	 * @return
	 */
	public String checkRatename(@ScubeParam("ratename") String ratename);
	/**
	 * 
	 * @param ratecode
	 * @return
	 */
	public String checkRatecode(@ScubeParam("ratecode") String ratecode);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bSysLnCd
	 * @return
	 */
	public Page findBSysLnCdByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("bSysLnCd") BSysLnCd bSysLnCd);
	/**
	 * 
	 * @param ratecode
	 * @return
	 */
	public BSysLnCd findBSysLnCdByRatecode(@ScubeParam("ratecode") String ratecode);
}
