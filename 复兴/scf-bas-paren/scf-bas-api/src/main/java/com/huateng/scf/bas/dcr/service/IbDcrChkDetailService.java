package com.huateng.scf.bas.dcr.service; 

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.vo.VbDcrChkDetail;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * IbDcrChkDetailService接口类
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
public interface IbDcrChkDetailService {


	/**
	 * @param vbDcrChkDetail
	 * @return
	 */
	public void add(@ScubeParam("vbDcrChkDetail") VbDcrChkDetail vbDcrChkDetail);
	/**
	 * @param vbDcrChkDetail
	 * @return
	 */
	public int update(@ScubeParam("vbDcrChkDetail") VbDcrChkDetail vbDcrChkDetail);
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param vbDcrChkDetail
	 * @return
	 */
	public Page findObjectConditionByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("vbDcrChkDetail") VbDcrChkDetail vbDcrChkDetail);
	/**
	 * @param key
	 * @return
	 */
	public VbDcrChkDetail findVbDcrChkDetailByKey(@ScubeParam("key") String key);
	

	
	
}
