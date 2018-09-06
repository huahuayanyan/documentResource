package com.huateng.scf.bas.dcr.service; 

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.vo.VbDcrLinInf;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * IbDcrLinInfService接口类
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
public interface IbDcrLinInfService {


	/**
	 * @param vbDcrLinInf
	 * @return
	 */
	public String add(@ScubeParam("vbDcrLinInf") VbDcrLinInf vbDcrLinInf);
	/**
	 * @param vbDcrLinInf
	 * @return
	 */
	public int update(@ScubeParam("vbDcrLinInf") VbDcrLinInf vbDcrLinInf);
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);

	/**
	 * @param key
	 * @return
	 */
	public VbDcrLinInf findVbDcrLinInfByKey(@ScubeParam("key") String key);
	
	/**
	 * @param key
	 * @return
	 */
	public List selectTreeByRootId(@ScubeParam("key") String key);
	
	/**
	 * @param key
	 * @return prdId
	 */
	public List selectTreePoByRootId(@ScubeParam("key") String key) ;
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param custId
	 * @param prdId
	 * @return Page
	 */
	public Page queryCusBDcrLinInf(@ScubeParam("pageNo")int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("custId")String custId,@ScubeParam("prdId")String prdId) ;
}
