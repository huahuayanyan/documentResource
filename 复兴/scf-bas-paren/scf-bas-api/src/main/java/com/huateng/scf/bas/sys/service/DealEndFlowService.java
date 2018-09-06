/**
 * 
 */
package com.huateng.scf.bas.sys.service;

/**
 * <p>流程结束处理业务接口</p>
 *
 * @author 	yangdong
 * @date 	2016年11月12日上午11:26:13
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
public interface DealEndFlowService {
	/**
	 * 审批通过业务处理
	 * @param appNo  业务流水号                   
	 * @return void
	 */
	public  void  doWorkForPass(String  appNo);
	
	/**
	 * 审批否决业务处理
	 * @param appNo  业务流水号                   
	 * @return void
	 */
	public  void  doWorkForReject(String  appNo);
	
	/**
	 * 退回修改业务处理
	 * @param appNo
	 */
	public void doWorkForBack(String appNo);
	
}
