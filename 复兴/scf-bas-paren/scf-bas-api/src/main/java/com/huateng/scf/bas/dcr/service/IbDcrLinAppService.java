package com.huateng.scf.bas.dcr.service; 

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.vo.VbDcrLinApp;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * IbDcrLinAppService接口类
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
public interface IbDcrLinAppService {


	/**
	 * @param vbDcrLinApp
	 * @return
	 */
	public String add(@ScubeParam("vbDcrLinApp") VbDcrLinApp vbDcrLinApp);
	/**
	 * @param vbDcrLinApp
	 * @return
	 */
	public String update(@ScubeParam("vbDcrLinApp") VbDcrLinApp vbDcrLinApp);
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
	public Page findObjectConditionByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("vbDcrLinApp") VbDcrLinApp vbDcrLinTyp);

	

	public List queryCrNmSource();
	
	public Page  queryCustSource(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map value) ;

	
	/**
	 * @param key
	 * @return
	 */
	public VbDcrLinApp findVbDcrLinAppByKey(@ScubeParam("key") String key);
	
	/**
	 * @param key
	 * @return
	 */
	public void deleteBdcrLinApp(@ScubeParam("key") String key);
	
	/**
	 * @param vbDcrLinApp
	 * @return
	 */
	public int updateBDcrLinApp (@ScubeParam("vbDcrLinApp") VbDcrLinApp vbDcrLinApp);
	
	
	/**
	 * @param key
	 * @return
	 */
	public void   submitFlowForBDcrLinAppStat (@ScubeParam("key") String key);
	

	
	
}
