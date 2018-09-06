package com.huateng.scf.bas.common.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>应收类业务配置版	公共类接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月31日下午3:11:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月31日下午3:11:17	     新增
 *
 * </pre>
 */
public interface IDebtFinancingService {

	@SuppressWarnings("rawtypes")
	public void lockLnciBaseInfo(@ScubeParam("appno") String appno,@ScubeParam("invoiceList") List invoiceList) throws ScubeBizException;

	/**
	 * 应收账款查询列表
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午2:15:25
	 */
	public Page getInvoiceFinancingQuery(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 发票融资发放发票添加
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午4:22:14
	 */
	public Page getInvoiceFinancingAddQry(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 应收账款单据查询
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月25日下午8:28:18
	 */
	public Page getDebtInfoQuery(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO,@ScubeParam("flag") boolean flag) throws ScubeBizException;

	/**
	 * 催收待添加发票查询
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月27日下午3:10:30
	 */
	public Page getDebtInvoiceInfoPressing(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO);

	/**
	 * 根据appno对流程锁定的应收账款进行解锁
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日下午3:11:11
	 */
	public void releaseAppliDebtBaseInfo(@ScubeParam("appno") String appno) throws ScubeBizException;
	/**
	 * 保存业务申请信息
	 * @param debtVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:32:47
	 */
	public String saveFactoringAppBasicInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO,@ScubeParam("businessnoType") String businessnoType,@ScubeParam("workApplyType") String workApplyType)
			throws ScubeBizException;

	/**
	 * 获取保理合同（有/无）追索类型
	 * @param mastContno
	 * @param custcdBuyer
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:39:24
	 */
	public String getDebtContRecoverType(@ScubeParam("mastContno") String mastContno,@ScubeParam("custcdBuyer") String custcdBuyer) throws ScubeBizException;

	/**
	 * 回购审批通过
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:42:06
	 */
	public void factoringDebtBackAddApply(@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList,@ScubeParam("debtVO") DebtBussInfoVO debtVO)
			throws ScubeBizException;

	/**
	 * 回购、核销更新池的发票总余额和可融资余额
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午10:57:09
	 */
	public void updatePoolRemainAmount(@ScubeParam("debtVO") DebtBussInfoVO debtVO) throws ScubeBizException;

	/**
	 * 核销申请发票添加查询
	 * @param commonQueryVO
	 * @param flag
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:14:34
	 */
	public Page getInvoiceChargeOffAddQry(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 核销审批通过
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午4:08:35
	 */
	public void factoringChargeOffAddSave(@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList,@ScubeParam("debtVO") DebtBussInfoVO debtVO)
			throws ScubeBizException;

	/**
	 * 查询应收账款列表
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:30:28
	 */
	public Page getAcquisitionsInformation(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 减值申请发票添加
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:58:07
	 */
	public Page getInvoiceAllowanceAddQry(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 减值审批通过
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午2:45:26
	 */
	public void factoringAllowanceAddApply(@ScubeParam("insertDebtList") List<NDebtBillsInfoVO> insertDebtList,@ScubeParam("debtVO") DebtBussInfoVO debtVO)
			throws ScubeBizException;
}
