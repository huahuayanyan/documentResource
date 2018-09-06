package com.huateng.scf.bas.lan.service;

import java.math.BigDecimal;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.vo.BillCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月21日下午4:20:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月21日下午4:20:10	     新增
 *
 * </pre>
 */
public interface IBillApplyMngService {

	/**
	 * 
	 * @param billno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午4:21:56
	 */
	public BigDecimal getBillNormalLoanAmt(@ScubeParam("billno") String billno);

	/**
	 * 
	 * @param qryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午2:42:15
	 */
	public Page getBillNormalAppChkStockInfo(@ScubeParam("qryVO") BillCommonQryVO qryVO) throws ScubeBizException;

}
