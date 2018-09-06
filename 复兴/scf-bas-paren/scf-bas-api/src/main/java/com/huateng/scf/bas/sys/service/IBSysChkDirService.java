package com.huateng.scf.bas.sys.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkDir;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * @author HTRAD0055
 * 拦截目录接口
 */
public interface IBSysChkDirService {
	/**
	 * @param record
	 * @return
	 */
	public String add(@ScubeParam("otherform") BSysChkDir record);
	/**
	 * @param record
	 * @return
	 */
	public int update(@ScubeParam("otherform") BSysChkDir record);
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
	public Page findBSysChkDirByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bSysChkDir") BSysChkDir record);
	
	/**
	 * @param key
	 * @return
	 */
	public BSysChkDir findBSysChkDirByKey(@ScubeParam("key") String key);
	
	/**
	 * @param key
	 * @return
	 */
	public BSysChkDir findSysChkDirChkItIds();


}
