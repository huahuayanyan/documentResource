/**
 * 
 */
package com.huateng.scf.bas.cnt.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.common.model.DeliveryApplyQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 多方协议参与者接口
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月15日.上午10:44:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日.上午10:44:14	     新增
 *
 *            </pre>
 */

public interface IBCntMprotPartInfoService {
	public static final String BEAN_ID = "bCntMprotPartInfoService";

	/**
	 * 通过protocolNo获得参与者的信息
	 * 
	 * @param bCntMprotPartInfo
	 * @return
	 */
	List<BCntMprotPartInfo> findBCntMpartInfoByProtocolNo(@ScubeParam("protocolNo") String protocolNo) throws ScubeBizException;

	/**
	 * @Description: 根据协议号和角色类型返回对应的客户名称
	 * @author xu_hong
	 * @Created 2012-10-19上午09:52:04
	 * @param protocolNo
	 *            协议号
	 * @param role
	 *            角色类型
	 * @param returnFlag
	 *            返回类型
	 * @return
	 */
	String findCnameByProAndRole(@ScubeParam("protocolNo") String protocolNo, @ScubeParam("role") String role,
			@ScubeParam("returnFlag") String returnFlag);

	/**
	 * 通过protocolNo查找核心厂商
	 * 
	 * @param protocolNo
	 * @param role
	 * @return
	 * @throws ScubeBizException
	 */
	public BCntMprotPartInfo findCoreorCustByProtocolNo(@ScubeParam("protocolNo") String protocolNo, @ScubeParam("role") String role)
			throws ScubeBizException;

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getMutiProtPartInfoByPara(@ScubeParam("commonQueryVO") DeliveryApplyQryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 根据协议号和角色查询有效的监管合同信息
	 *
	 */
	public BCntMprotPartInfo getMoniMutiProtPartInfoByProAndRole(@ScubeParam("commonQueryVO") DeliveryApplyQryVO commonQueryVO)
			throws ScubeBizException;
	
	/**
	 * 
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月18日上午10:39:36
	 */
	public Page getMutiProtPartInfo(@ScubeParam("slaveContno") String slaveContno) throws ScubeBizException;

	/**
	 * 根据协议编号及角色查询参与者信息
	 * @param protocolNo
	 * @param role
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日上午10:25:00
	 */
	public BCntMprotPartInfo findCustByProtocolNoAndRole(@ScubeParam("protocolNo") String protocolNo,@ScubeParam("role") String role) throws ScubeBizException;
}
