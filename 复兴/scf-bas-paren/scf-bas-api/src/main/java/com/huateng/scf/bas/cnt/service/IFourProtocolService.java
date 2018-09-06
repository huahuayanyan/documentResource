/**
 * 
 */
package com.huateng.scf.bas.cnt.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.model.FourProtocolVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 先票/款后货协议
 * </p>
 *
 * @author lihao
 * @date 2017年4月5日下午3:58:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * lihao	   2017年4月5日下午3:58:51              新增
 *
 *            </pre>
 */
public interface IFourProtocolService {
	// 新增修改钱的页面下拉菜单输入数据校验
	public void checkSelectForfranchiserProtocol(@ScubeParam("FourProtocolVO") FourProtocolVO deliveryQryVO) throws ScubeBizException;

	// 新增先票/款后货协议（四方保兑仓）
	public void franchiserProtocolAdd(@ScubeParam("FourProtocolVO") FourProtocolVO deliveryQryVO) throws ScubeBizException;

	// 修改先票/款后货协议（四方保兑仓）
	public void franchiserProtocolModify(@ScubeParam("FourProtocolVO") FourProtocolVO deliveryQryVO) throws ScubeBizException;

	// 先票/款后货协议页面查询
	public Page getFranchiserProtocolQuery(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("deliveryQryVO") DeliveryQryVO deliveryQryVO) throws ScubeBizException;
	
	/**
	 * 差额退款页面查询
	 * @param pageNo
	 * @param pageSize
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getFranchiserProtocolQueryCETK(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("deliveryQryVO") DeliveryQryVO deliveryQryVO) throws ScubeBizException;
	
	/**
	 * 通过map查询先票/款后货协议
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page getFranchiserProtocolQueryByMap(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") HashMap<String, String> value);

}
