/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import com.huateng.scube.exception.ScubeBizException;

/**
 * <p>流程审批处理业务接口</p>
 *
 * @author 	yangdong
 * @date 	2016年11月23日上午11:26:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 *  yangdong		2016年11月12日上午11:26:13	                                 新增
 *
 * </pre>
 */
public interface DealInFlowService {
	/**
	 * 流程提交业务处理
	 * @param appNo  业务流水号                   
	 * @return void
	 */
	public  void  doWorkForSubmit(String  appNo)throws ScubeBizException;
	
	
}
