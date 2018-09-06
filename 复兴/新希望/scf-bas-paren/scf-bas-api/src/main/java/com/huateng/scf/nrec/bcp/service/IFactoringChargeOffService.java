package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>应收配置版	核销接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月2日上午11:25:00
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月2日上午11:25:00	     新增
 *
 * </pre>
 */
public interface IFactoringChargeOffService {

	/**
	 * 应收账款核销申请信息查询
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午1:51:10
	 */
	public DebtBussInfoVO RecievableChargeOffApplyBaseInfoGetter(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO) throws ScubeBizException;
	
	/**
	 * 获取任务信息
	 * @param appno
	 * @param factType
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午1:53:51
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);

	/**
	 * 应收账款列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午2:35:33
	 */
	public Page InvoiceChargeOffRecievableListGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO);

	/**
	 * 核销带选择应收账款列表
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:15:46
	 */
	public Page InvoiceChargeOffAddQryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO,@ScubeParam("list") List<RBcpAppliBussDtl> list)
			throws ScubeBizException;

	/**
	 * 应收账款核销申请保存
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:47:05
	 */
	public String DebtCancelApplyApplySaveUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException;

	/**
	 * 保理应收账款撤销申请流程录入
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:49:03
	 */
	public void DebtCancelApplyWriteSubmitUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException;

	/**
	 * 核销回执确认
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午5:03:16
	 */
	public void DebtCancelApplyReceiptUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException;

	/**
	 * 列表提交按钮提交，需通过appNo获取业务申请基本信息及明细信息
	 * @param appNo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月15日上午9:56:58
	 */
	public void submit(@ScubeParam("appNo") String appNo) throws ScubeBizException;
	
}
