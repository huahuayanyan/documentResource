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
 * <p>应收账款催收	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月27日下午2:49:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月27日下午2:49:24	     新增
 *
 * </pre>
 */
public interface INDebtPressApplyService {

	/**
	 * 催收添加发票--发票查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月27日下午3:05:39
	 */
	public Page DebtInvoiceInfoAddQueryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,
			@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO, @ScubeParam("list") List<RBcpAppliBussDtl> list)
			throws ScubeBizException;

	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno,@ScubeParam("factType") String factType);

	/**
	 * 获取业务申请基本信息
	 * @param debtBussInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月27日下午4:34:59
	 */
	public List<?> DisputeInvoiceSetApplyAddGetter(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO);

	/**
	 * 保存催收申请信息并发起流程
	 * @param debtBussInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午9:39:40
	 */
	public String DebtPressingApplySaveUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("list") List<NDebtBillsInfoVO> list) throws ScubeBizException;

	/**
	 * 催收管理申请提交
	 * @param debtBussInfoVO
	 * @param list
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午9:51:49
	 */
	public void DebtPressingApplyWriteSubmitUpdate(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,@ScubeParam("list") List<NDebtBillsInfoVO> list)
			throws ScubeBizException;

	/**
	 * 催收发票列表
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午11:17:26
	 */
	public Page DebtPressInvoicesInfoGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO)
			throws ScubeBizException;

	/**
	 * 列表提交按钮提交，需通过appNo获取业务申请基本信息及明细信息
	 * @param appNo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月15日上午9:28:51
	 */
	public void submit(@ScubeParam("appNo") String appNo) throws ScubeBizException;
}
