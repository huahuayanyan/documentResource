/**
 * 
 */
package com.huateng.scf.bas.lan.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 借据申请信息接口
 * </p>
 *
 * @author huangshuidan
 * @date 2017年1月17日 下午3:00:16
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年1月17日下午3:00:16             新增
 *
 * </pre>
 */
public interface IBLanAppliLnciBaseService {
	public static final String BEAN_ID = "bLanAppliLnciBaseService";
	/**
	 * 根据业务申请号查询借据申请信息
	 * @param appno
	 * 		String-业务申请号
	 * @return BLanAppliLnciBase
	 * @throws ScubeBizException
	 */
	public BLanAppliLnciBase queryBLanAppliLnciBaseByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;
	/**
	 * 更新借据申请表信息（有修改字段更新）
	 * @param bLanAppliLnciBase
	 * 		BLanAppliLnciBase对象
	 * @throws ScubeBizException
	 */
	public void updateBLanAppliLnciBase(@ScubeParam("bLanAppliLnciBase") BLanAppliLnciBase bLanAppliLnciBase) throws ScubeBizException;
    /**
     * 根据借据号查询借据申请信息
     * @param debetId
     * @return BLanAppliLnciBase
     */
	public BLanAppliLnciBase findBLanAppliLnciBaseByDebtId(@ScubeParam("debetId") String debetId) throws ScubeBizException;
	/**
	 * 根据借据流水号查询借据申请信息
	 * @param debetNo
	 * @return
	 * @throws ScubeBizException
	 */
	public BLanAppliLnciBase queryBLanAppliLnciBaseByDebtNo(@ScubeParam("debetNo") String debetNo) throws ScubeBizException;
	/**
	 * 根据合同号查询流程中的借据敞口余额汇总
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月6日下午1:28:54
	 */
	public List<HashMap<String, BigDecimal>> getFlowRiskAmtByMastContno(@ScubeParam("mastContno") String mastContno);
	/**
	 * 统计流程中的借据金额
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月6日下午1:42:27
	 */
	public List<HashMap<String, BigDecimal>> getFlowKindsOfSumByMastContno(@ScubeParam("mastContno") String mastContno);
}
