/**
 * 
 */
package com.huateng.scf.bas.cnt.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.model.ThreeProtocolVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>担保提货协议接口</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月22日下午3:58:51	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午3:58:51              新增
 *
 * </pre>
 */
public interface IThreeProtocolService {
	/**
	 * 分页查询担保提货协议
	 * 
	 * @param pageNo
	 *            int-当前页码
	 * @param pageSize
	 *            int-每页大小
	 * @param bSysApplyDtl
	 *            BSysApplyDtl对象
	 * @return Page对象
	 * @throws ScubeBizException
	 */
	public Page queryThreeProtocolListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("deliveryQryVO") DeliveryQryVO deliveryQryVO) throws ScubeBizException;
	/**
	 * 根据担保提货协议对象查询担保提货记录
	 * @param threeProtocolVO
	 * 		ThreeProtocolVO对象
	 * @return
	 * @throws ScubeBizException
	 */
	public ThreeProtocolVO queryThreeProtocolForOneObject(
			@ScubeParam("threeProtocolVO") ThreeProtocolVO threeProtocolVO) throws ScubeBizException;
	/**
	 * 担保提货协议保存
	 * @param threeProtocolVO
	 * 		ThreeProtocolVO对象
	 * @throws ScubeBizException
	 */
	public void threeProtocolAdd(@ScubeParam("threeProtocolVO") ThreeProtocolVO threeProtocolVO) throws ScubeBizException; 
	/**
	 * 担保提货协议修改
	 * @param threeProtocolVO
	 * 		ThreeProtocolVO对象
	 * @throws ScubeBizException
	 */
	public void threeProtocolModify(@ScubeParam("threeProtocolVO") ThreeProtocolVO threeProtocolVO) throws ScubeBizException;
	/**
	 * 担保提货协议删除
	 * @param threeProtocolVO
	 * 		ThreeProtocolVO对象
	 * @throws ScubeBizException
	 */
	public void threeProtocolDelete(@ScubeParam("threeProtocolVO") ThreeProtocolVO threeProtocolVO) throws ScubeBizException;
	
	/**
	 * 初始化页面的用户及机构信息
	 * @return ThreeProtocolVO
	 * @throws ScubeBizException
	 */
	public ThreeProtocolVO initPageUserOrg() throws ScubeBizException;
	
}
