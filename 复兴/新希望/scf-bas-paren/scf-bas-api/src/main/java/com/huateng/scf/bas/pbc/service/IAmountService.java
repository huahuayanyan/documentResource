/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import java.math.BigDecimal;

import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月22日下午19:35:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			          Content
 * lihao		2016年11月22日下午19:35:24                                  新增
 *
 *            </pre>
 */

public interface IAmountService {
	
	/**
	 * 获取可提货金额
	 * @param amountVO
	 * @return
	 */
	public BigDecimal getDelivery(@ScubeParam("amountVO") AmountVO amountVO);
	
	public BigDecimal getPant(@ScubeParam("amountVO") AmountVO amountVO);

	public BigDecimal getLnciRiskAmt(@ScubeParam("bLanLnciBase") BLanLnciBase bLanLnciBase) throws ScubeBizException;

	BigDecimal getMortAmtBySlaveContNo(@ScubeParam("slaveContno") String slaveContno,@ScubeParam("midProductId") String midProductId);
	//池敞口余额
	public BigDecimal calculatePoolRiskAvailableAmtByBusinessNo(@ScubeParam("bussinessNo")String businessNo);

	public BigDecimal getContRiskAmtByCycle(@ScubeParam("mastContno") String mastContno, @ScubeParam("cycle") String cycle) ;

	public BigDecimal getContRiskAmt(@ScubeParam("mastContno") String mastContno,@ScubeParam("cycle") String cycle);
	
	/**
	 * 计算本笔借据的敞口余额(本笔数风险敞口)查询申请表
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public BigDecimal getLnciRiskAmtByAppno(@ScubeParam("appno")String appno) throws ScubeBizException;
	
	/**
	 * 计算协议项下敞口余额（先票款后货）
	 * @param protocolNo
	 * @return
	 * @throws ScubeBizException
	 */
	public BigDecimal getLnciRiskAmtByProtocolNo(@ScubeParam("protocolNo")String protocolNo,@ScubeParam("newAddBailAmount")BigDecimal newAddBailAmount) throws ScubeBizException;
	
}
