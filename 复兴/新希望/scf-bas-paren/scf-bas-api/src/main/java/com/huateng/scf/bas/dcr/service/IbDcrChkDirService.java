package com.huateng.scf.bas.dcr.service; 

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.vo.VbDcrChkDir;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * IbDcrChkDirService接口类
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
public interface IbDcrChkDirService {


	/**
	 * @param vbDcrChkDir
	 * @return
	 */
	public void add(@ScubeParam("vbDcrChkDir") VbDcrChkDir vbDcrChkDir);
	/**
	 * @param vbDcrChkDir
	 * @return
	 */
	public int update(@ScubeParam("vbDcrChkDir") VbDcrChkDir vbDcrChkDir);
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param vbDcrChkDir
	 * @return
	 */
	public Page findObjectConditionByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("vbDcrChkDir") VbDcrChkDir vbDcrChkDir);
	/**
	 * @param key
	 * @return
	 */
	public VbDcrChkDir findVbDcrChkDirByKey(@ScubeParam("key") String key);
	
	/**
	 * @param key
	 * @return
	 */

	public List selectTreeByRootId(@ScubeParam("key") String key) ;
	
	
}
