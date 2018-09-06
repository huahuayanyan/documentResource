/**
 * 
 */
package com.huateng.scf.bas.cnt.service;

import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.bas.cnt.model.BCntMprotDealInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>预付款协议扩展信息接口</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月15日.上午10:59:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日.上午10:59:17	     新增
 *
 * </pre>
 */

public interface IBCntMprotDealInfoService {
	public static final String BEAN_ID = "bCntMprotDealInfoService";
	
	public void addBCntMprotDealInfo(@ScubeParam("bCntMprotDealInfo") BCntMprotDealInfo bCntMprotDealInfo) throws ScubeBizException;
	/**
	 * @param bCntMprotDealInfo
	 * @return
	 */
	public int updateBCntMprotDealInfo(@ScubeParam("bCntMprotDealInfo") BCntMprotDealInfo bCntMprotDealInfo) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public int deleteBCntMprotDealInfo(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BCntMprotDealInfo findBCntMprotDealInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	public void updateDeliveryLnciBaseInfo(@ScubeParam("abcpAppliImprestBuss") ABcpAppliImprestBuss abcpAppliImprestBuss);

}
