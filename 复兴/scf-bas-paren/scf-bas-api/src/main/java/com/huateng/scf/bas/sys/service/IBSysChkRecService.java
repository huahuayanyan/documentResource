package com.huateng.scf.bas.sys.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkRec;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * @author HTRAD0055
 *	拦截记录接口
 */
public interface IBSysChkRecService {

	/**
	 * @param record
	 * @return
	 */
	public String add(@ScubeParam("otherform") BSysChkRec record);
	/**
	 * @param record
	 * @return
	 */
	public int update(@ScubeParam("otherform") BSysChkRec record);
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
	public Page findBSysChkRecByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bSysChkRec") BSysChkRec record);
	
	/**
	 * @param key
	 * @return
	 */
	public BSysChkRec findBSysChkRecByKey(@ScubeParam("key") String key);
	
	
	/**
	 * 调用dao查询所有列表
	 * @return
	 */
	public List<BSysChkRec> findAllBsysChkRecList();
}
