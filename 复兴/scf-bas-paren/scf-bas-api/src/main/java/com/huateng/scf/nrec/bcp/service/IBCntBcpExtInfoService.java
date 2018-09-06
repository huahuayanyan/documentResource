package com.huateng.scf.nrec.bcp.service;

import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>合同交易对手信息	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月31日上午10:03:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月31日上午10:03:04	     新增
 *
 * </pre>
 */
public interface IBCntBcpExtInfoService {

	/**
	 * 根据合同号、买方客户号查询保理扩展表
	 * @param mastContno
	 * @param custcd
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午10:08:20
	 */
	public BCntBcpExtInfoVO queryContDebtExInfoByMastContno(@ScubeParam("mastContno") String mastContno,@ScubeParam("custcd") String custcd) throws ScubeBizException;

}
