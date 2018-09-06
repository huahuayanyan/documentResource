package com.huateng.scf.bas.fin.service;

import com.huateng.scf.bas.fin.model.BFinCustDir;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BFinCustDir接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月4日下午2:23:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月4日下午2:23:24	     新增
 *
 * </pre>
 */
public interface IBFinCustDirService {
	/**
	 * 
	 * @param bFinCustDir
	 */
	public void add(@ScubeParam("bFinCustDir") BFinCustDir bFinCustDir);
	/**
	 * 
	 * @param mdlIds
	 * @return
	 */
	public String findBFinCustDirByMdlId(@ScubeParam("mdlIds") String mdlIds);
	/**
	 * 
	 * @param finDirId
	 * @return
	 */
	public BFinCustDir findBFinCustDirByFinDirId(@ScubeParam("finDirId") String finDirId);
}
