package com.huateng.scf.nrec.bcp.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>应收类配置版	减值申请接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月5日上午9:41:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月5日上午9:41:29	     新增
 *
 * </pre>
 */
public interface INDebtImpairmentService {

	/**
	 * 获取任务信息
	 * @param appno
	 * @param factType
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午9:44:17
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);

	/**
	 * 查询减值申请基本信息
	 * @param debtBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:10:53
	 */
	public DebtBussInfoVO FactoringAllowanceApplyAddGetter(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO) throws ScubeBizException;

	/**
	 * 应收账款减值业务申请应收账款列表
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:45:14
	 */
	public Page InvoiceAllowanceQuryHandleGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO);

	/**
	 * 减值申请发票添加
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:59:16
	 */
	public Page InvoiceAllowanceAddQryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO,@ScubeParam("list") List<RBcpAppliBussDtl> list)
			throws ScubeBizException;

	/**
	 * 应收账款折让 保存(减值申请保存)
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午2:19:54
	 */
	public String FactoringAllowanceSaveUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException;

	/**
	 * 应收账款折让Write岗 应收账款折让申请任务提交
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午2:27:49
	 */
	public void FactoringAllowanceAddSave(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException;

	/**
	 * 应收账款折让审批通过
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午3:26:37
	 */
	public void AllowanceReviewSubmitUpdater(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException;

	/**
	 * 列表提交按钮提交，需通过appNo获取业务申请基本信息及明细信息
	 * @param appNo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月15日上午9:41:07
	 */
	public void submit(@ScubeParam("appNo") String appNo) throws ScubeBizException;

	/**
	 * 应收账款减值业务申请明细信息（重新赋值减值金额，已减值金额，减值后余额）
	 * @param appno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月21日上午9:42:29
	 */
	public List<AppliBussDetailVO> queryRBcpAppliBussDtlByAppno(@ScubeParam("appno") String appno);
}
