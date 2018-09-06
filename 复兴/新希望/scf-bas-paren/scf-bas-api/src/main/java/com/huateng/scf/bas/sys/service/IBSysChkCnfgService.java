package com.huateng.scf.bas.sys.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfg;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * @author HTRAD0055
 * 拦截项配置接口
 */
public interface IBSysChkCnfgService {
	
	/**
	 * @param record
	 * @return
	 */
	public String add(@ScubeParam("otherform") BSysChkCnfg record);
	/**
	 * @param record
	 * @return
	 */
	public int update(@ScubeParam("otherform") BSysChkCnfg record);
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bSysChkCnfg
	 * @return
	 */
	public Page findBSysChkCnfgByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bSysChkCnfg") BSysChkCnfg record);
	
	/**
	 * @param key
	 * @return
	 */
	public BSysChkCnfg findBSysChkCnfgByKey(@ScubeParam("key") String key);

	
	/**
	 * @return key 为index value为值的 Map
	 */
	public Map<String,String> findBSysChkCnfgChkItIdMap();
	
	/**
	 * @return 字段的List
	 */
	public List<String> findBSysChkCnfgChkItIds();
	
	
	/**
	 * @return 所有的BSysChkCnfg对象List
	 */
	public List<BSysChkCnfg> findAllBSysChkCnfgList();

}
