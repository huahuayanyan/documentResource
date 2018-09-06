package com.huateng.scf.nrec.bcp.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.model.RBcpDuebillRegisterVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>出账登记	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月26日下午1:18:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月26日下午1:18:51	     新增
 *
 * </pre>
 */
public interface IRBcpDuebillRegisterService {

	/**
	 * 出账登记列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDuebillRegisterVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午2:09:21
	 */
	public Page queryRBcpDuebillRegisterByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("rBcpDuebillRegisterVO") RBcpDuebillRegisterVO rBcpDuebillRegisterVO);

	/**
	 * 根据融资客户筛选放款信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午2:37:06
	 */
	public Page getAppnoByCustcd(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;

	/**
	 * 根据主键或放款编号查询信息
	 * @param rBcpDuebillRegisterVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午2:51:39
	 */
	public RBcpDuebillRegisterVO findRBcpDuebillRegisterByAppno(@ScubeParam("rBcpDuebillRegisterVO") RBcpDuebillRegisterVO rBcpDuebillRegisterVO);

	/**
	 * 保存或修改出账登记信息
	 * @param rBcpDuebillRegisterVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午4:25:04
	 */
	public String saveAndUpdate(@ScubeParam("rBcpDuebillRegisterVO") RBcpDuebillRegisterVO rBcpDuebillRegisterVO);

	/**
	 * 删除出账登记信息
	 * @param rBcpDuebillRegisterVO
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午4:25:48
	 */
	public void delete(@ScubeParam("rBcpDuebillRegisterVO") RBcpDuebillRegisterVO rBcpDuebillRegisterVO);

	/**
	 * 出账确认
	 * @param rBcpDuebillRegisterVO
	 * @author 	mengjiajia
	 * @date 	2017年5月26日下午5:15:46
	 */
	public void submit(@ScubeParam("rBcpDuebillRegisterVO") RBcpDuebillRegisterVO rBcpDuebillRegisterVO);

	/**
	 * 根据receiveNo查询出账登记信息
	 * @param receiveNo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月8日下午7:54:31
	 */
	public RBcpDuebillRegisterVO findRBcpDuebillRegisterByReceiveNo(@ScubeParam("receiveNo") String receiveNo);

	/**
	 * 模拟银行返回凭证编号
	 * @param rBcpDuebillRegisterVO
	 * @author 	mengjiajia
	 * @date 	2017年6月26日下午5:38:36
	 */
	public void BankCheckAndSendBillNo(@ScubeParam("rBcpDuebillRegisterVO") RBcpDuebillRegisterVO rBcpDuebillRegisterVO);
}
