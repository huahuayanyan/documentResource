package com.huateng.scf.bas.dcr.service; 

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.vo.VbDcrLinCnfg;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * BDcrLinCnfg接口类
 *
 * @author 	huateng
 * @date 	2016年7月6日
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * huateng			2016年7月6日			新增
 *
 * </pre>
 */
public interface BDcrLinCnfgService {


	/**
	 * @param bDcrLinCnfg
	 * @return
	 */
	public void add(@ScubeParam("vbDcrLinCnfg") VbDcrLinCnfg vbDcrLinCnfg);
	/**
	 * @param bDcrLinCnfg
	 * @return
	 */
	public int update(@ScubeParam("vbDcrLinCnfg") VbDcrLinCnfg vbDcrLinCnfg);
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param orgUser
	 * @return
	 */
	public Page findObjectConditionByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("vbDcrLinCnfg") VbDcrLinCnfg vbDcrLinCnfg);

	
	public List queryTypId();
	
	
}
