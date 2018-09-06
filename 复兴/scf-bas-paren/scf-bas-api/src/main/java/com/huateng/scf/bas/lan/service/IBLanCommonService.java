package com.huateng.scf.bas.lan.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>借据基本信息接口</p>
 *
 * @author 	liph
 * @date 	2016年12月14日.上午11:13:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月14日.上午11:13:52	     新增
 *
 * </pre>
 */
public interface IBLanCommonService {
	/**业务申请主表数据插入*/
	public void saveBPbcAppliBaseInfo(@ScubeParam("bPbcAppliBaseInfo") BPbcAppliBaseInfo bPbcAppliBaseInfo,@ScubeParam("originalAppliStatus") String originalAppliStatus,@ScubeParam("appno") String appno) throws ScubeBizException;
	/**借据申请表插入*/
	public String saveBLanAppliLnciBase(@ScubeParam("appno")String appno,@ScubeParam("bLanAppliLnciBase") BLanAppliLnciBase bLanAppliLnciBase) throws ScubeBizException;
	/**保证金保存*/
	public void saveBMrnAppliAcctInfo(@ScubeParam("appno")String appno,@ScubeParam("list")List bailList);
	/**票据信息保存*/
	public void saveBLanApplyBillInfo(@ScubeParam("appno")String appno,@ScubeParam("debetno")String debetno,@ScubeParam("map")Map map);
	/**审批通过*/
	public void saveLoanInfo(@ScubeParam("appno")String appno,@ScubeParam("result")String result,@ScubeParam("map")Map map)throws ScubeBizException;

	/**金额校验*/
	public void checkLoanApplyInfo(@ScubeParam("appno")String appno,@ScubeParam("appInitCashEqtAmt")BigDecimal appInitCashEqtAmt);
	/**放款通过业务申请主表进行状态更新*/
	public void upAppliBaseInfo(String appno);
	
	/**
	 * 更新借据申请表的借据号
	 * @param appno
	 * @param debetId
	 */
	public void updateBLanAppliLnciBase(@ScubeParam("appno")String appno,@ScubeParam("debetId")String debetId)throws ScubeBizException;
}
