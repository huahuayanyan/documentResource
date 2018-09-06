package com.huateng.scf.bas.sys.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkPl;
import com.huateng.scube.server.annotation.ScubeParam;


/**
 * @author HTRAD0055
 * 拦截方案接口
 */
public interface IBSysChkPlService {
	
	/**
	 * @param record
	 * @return
	 */
	public String add(@ScubeParam("otherform") BSysChkPl record);
	/**
	 * @param record
	 * @return
	 */
	public int update(@ScubeParam("otherform") BSysChkPl record);
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bSysChkDir
	 * @return
	 */
	public Page findBSysChkPlByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bSysChkPl") BSysChkPl record);
	
	/**
	 * @param key
	 * @return
	 */
	public BSysChkPl findBSysChkPlByKey(@ScubeParam("key") String key);


}
