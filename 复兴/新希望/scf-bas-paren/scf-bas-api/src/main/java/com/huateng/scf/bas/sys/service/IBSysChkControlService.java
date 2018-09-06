package com.huateng.scf.bas.sys.service;

import java.util.List;
import java.util.Map;

import com.huateng.scf.bas.sys.dao.model.BSysChkRec;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * @author HTRAD0055
 * 风险检查处理器
 */
public interface IBSysChkControlService {


	/**
	 * @param  bSysChkRec  检查方案对象
	 * @param  chkMap  检查对象map
	 * @return  BSysChkRec  检查结果对象
	 */
	public BSysChkRec executeSingleSysChk(@ScubeParam("bSysChkRec")BSysChkRec bSysChkRec,@ScubeParam("chkMap") Map chkMap);
	
	
	/**
	 * @param  modelId  业务拦截模型id
	 * @return  List         业务拦截方案List
	 */
	public  List queryBSysChkPlList(@ScubeParam("modelId")String modelId);
}
