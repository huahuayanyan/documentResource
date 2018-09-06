package com.huateng.scf.bas.dcr.service; 

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.vo.VbDcrLin;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * IbDcrLinService接口类
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
public interface IbDcrLinService {
	
	
	/**
	 * @param key
	 * @return
	 */
	public String approveBDcrLin(@ScubeParam("key") String key);

    
	/**
	 * @param vbDcrLin
	 * @return
	 */
	public String add(@ScubeParam("vbDcrLin") VbDcrLin vbDcrLin);


	/**
	 * @param pageNo
	 * @param pageSize
	 * @param vbDcrLin
	 * @return
	 */
	public Page findObjectConditionByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("vbDcrLin") VbDcrLin vbDcrLin);
	
	/**
	 * @param key
	 * @return
	 */
	public VbDcrLin findVbDcrLinByKey(@ScubeParam("key") String key);
	
	
	/**
	 * @param key
	 * @return
	 */
	public void freezeVbDcrLinByKey(@ScubeParam("key") String key);
	
	
	/**
	 * @param key
	 * @return
	 */
	public void unfreezeVbDcrLinByKey(@ScubeParam("key") String key);
	

}
