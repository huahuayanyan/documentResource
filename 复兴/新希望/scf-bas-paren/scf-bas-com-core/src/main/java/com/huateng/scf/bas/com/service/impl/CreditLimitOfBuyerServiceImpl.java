package com.huateng.scf.bas.com.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICreditLimitOfBuyerService;
import com.huateng.scf.bas.common.service.ICreditServiceService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.icr.dao.IBIcrBusiRelDAO;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.domodel.BIcrInfoDO;
import com.huateng.scf.bas.icr.dao.model.BIcrBusiRel;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.BIcrDtl;
import com.huateng.scf.bas.icr.model.BIcrType;
import com.huateng.scf.bas.icr.model.CreditLimitOfBuyerDealVO;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.icr.service.IBIcrTypeService;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>买方信用限额处理类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月30日下午3:22:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月30日下午3:22:46	     新增
 *
 * </pre>
 */
@ScubeService
@Service("CreditLimitOfBuyerServiceImpl")
public class CreditLimitOfBuyerServiceImpl implements ICreditLimitOfBuyerService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "CreditServiceServiceImpl")
	ICreditServiceService creditserviceservice;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "BIcrTypeServiceImpl")
	IBIcrTypeService bicrtypeservice;
	
	@Resource(name = "BIcrBusiRelDAO")
	IBIcrBusiRelDAO bicrbusireldao;
	
	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bicrdtlservice;
	
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO bicrinfodao;
	
	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;
	
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bicrinfoservice;
	
	/**
	 *
	 * @Description: 买方信用限额查询
	 * @author wenkui.xu
	 * @Created 2013-7-11上午11:16:59
	 * @param debtCommonQryVO
	 * @return
	 * @throws CommonException
	 */
//	@SuppressWarnings("rawtypes")
//	public PageQueryResult getCreditLimitInfoOfBuyerByDebtCommonQryVO(CreditQryVO creditQryVO)throws CommonException {
//		DebtMngServiceDAO debtMngServiceDAO=SCFDAOUtils.getDebtMngServiceDAO();
//		BctlDAO dao=SCFDAOUtils.getBctlDAO();
//		Bctl bctl=dao.get(GlobalInfo.getCurrentInstance().getBrcode());
//		PageQueryResult pageQueryResult=debtMngServiceDAO.getCreditLimitInfoOfBuyerByDebtCommonQryVO(creditQryVO);
//		List list=pageQueryResult.getQueryResult();
//		List<CreditLimitOfBuyerVO> returnList=new ArrayList<CreditLimitOfBuyerVO>();
//		PageQueryResult pageQueryReturnResult=new PageQueryResult();
//		if(list!=null&&list.size()>0){
//			Iterator iter=list.iterator();
//			while(iter.hasNext()){
//				Object[] obj=(Object[])iter.next();
//				TblCreditInfo tci=(TblCreditInfo)obj[0];
//				TblCreditBusiRel tcbr=(TblCreditBusiRel)obj[1];
//				TblContDebtInfo tcdi=(TblContDebtInfo)obj[2];
//				CreditLimitOfBuyerVO creditLimitOfBuyerVO=new CreditLimitOfBuyerVO();
//				CommonFunction.copyProperties(creditLimitOfBuyerVO, tcbr);
//				CommonFunction.copyProperties(creditLimitOfBuyerVO, tci);
//				creditLimitOfBuyerVO.setSupplyChainPdId(tcdi.getSupplyChainPdId());
//				String factType=tcdi.getFactType();
//				if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equalsIgnoreCase(factType)){
//					creditLimitOfBuyerVO.setInsuranceCustcd(tcdi.getFactoringBrcode());
//				}
//				if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equalsIgnoreCase(factType)){
//					TblInsuranceContInfo tblInsuranceContInfo=SCFDAOUtils.getTblInsuranceContInfoDAO().getInsuranceContInfoByInsuranceNo(tcdi.getDebtContno());
//					if(tblInsuranceContInfo!=null){
//						creditLimitOfBuyerVO.setInsuranceCustcd(tblInsuranceContInfo.getInsuranceCustcd());
//					}
//				}
//				if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType)||ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
//						||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)){
//					if(!DataFormat.isNull(bctl)){
//						creditLimitOfBuyerVO.setInsuranceCustcd(bctl.getBrname());
//					}
//				}
//				if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)){
//					if(!DataFormat.isNull(bctl)){
//						creditLimitOfBuyerVO.setInsuranceCustcd(bctl.getBrname());
//					}
//				}
//				returnList.add(creditLimitOfBuyerVO);
//			}
//			pageQueryReturnResult=pageQueryResult;
//			pageQueryReturnResult.setQueryResult(returnList);
//		}
//
//		return pageQueryReturnResult;
//	}

	/**
	 *
	 * @Description: 买方信用限额流水查询
	 * @author wenkui.xu
	 * @Created 2013-7-11上午11:16:59
	 * @param debtCommonQryVO
	 * @return
	 * @throws CommonException
	 */
//	@SuppressWarnings("rawtypes")
//	public PageQueryResult getCreditLimitFlowInfoOfBuyerByDebtCommonQryVO(CreditQryVO creditQryVO)throws CommonException {
//		DebtMngServiceDAO debtMngServiceDAO=SCFDAOUtils.getDebtMngServiceDAO();
//		PageQueryResult pageQueryResult=debtMngServiceDAO.getCreditLimitFlowInfoOfBuyerByDebtCommonQryVO(creditQryVO);
//		List list=pageQueryResult.getQueryResult();
//		List<CreditLimitOfBuyerVO> returnList=new ArrayList<CreditLimitOfBuyerVO>();
//		PageQueryResult pageQueryReturnResult=new PageQueryResult();
//		if(list!=null&&list.size()>0){
//			Iterator iter=list.iterator();
//			while(iter.hasNext()){
//				Object[] obj=(Object[])iter.next();
//				TblCreditDetail tcd=(TblCreditDetail)obj[0];
//				TblCreditInfo tci=(TblCreditInfo)obj[1];
//				TblCreditBusiRel tcbr=(TblCreditBusiRel)obj[2];
//				TblContDebtInfo tcdi=(TblContDebtInfo)obj[3];
//				CreditLimitOfBuyerVO creditLimitOfBuyerVO=new CreditLimitOfBuyerVO();
//
//				CommonFunction.copyProperties(creditLimitOfBuyerVO, tci);
//				CommonFunction.copyProperties(creditLimitOfBuyerVO, tcd);
//
//				creditLimitOfBuyerVO.setSupplyChainPdId(tcdi.getSupplyChainPdId());
//				creditLimitOfBuyerVO.setBusinessNo(tcbr.getBusinessNo());
//				String factType=tcdi.getFactType();
//				if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equalsIgnoreCase(factType)){
//					creditLimitOfBuyerVO.setInsuranceCustcd(tcdi.getFactoringBrcode());
//				}
//				if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equalsIgnoreCase(factType)){
//					TblInsuranceContInfo tblInsuranceContInfo=SCFDAOUtils.getTblInsuranceContInfoDAO().getInsuranceContInfoByInsuranceNo(tcdi.getDebtContno());
//					if(tblInsuranceContInfo!=null){
//						creditLimitOfBuyerVO.setInsuranceCustcd(tblInsuranceContInfo.getInsuranceCustcd());
//					}
//				}
//				//应收账款转让
//				if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_AANWINST_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_AANWINST_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_AANWINST_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORINGAANWINSTAPPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())){
//					creditLimitOfBuyerVO.setApplyType(ScfBasConstant.TRANS_TYPE_ASSIGNMENT);
//				}
//				//应收账款反转让
//				if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_BUY_BACK_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_BUY_BACK_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_BUY_BACK_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())){
//					creditLimitOfBuyerVO.setApplyType(ScfBasConstant.TRANS_TYPE_ANTI_ASSIGNMENT);
//				}
//				//应收账款减值
//				if(WorkflowConstant.APPLI_TYPE_ALLOWANCEDOUBLEAPPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_ALLOWANCECREDITAPPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_ALLOWANCELEASEAPPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_ALLOWANCEAPPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())){
//					creditLimitOfBuyerVO.setApplyType(ScfBasConstant.TRANS_TYPE_ALLOWANCE);
//				}
//				//应收账款核销
//				if(WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())){
//					creditLimitOfBuyerVO.setApplyType(ScfBasConstant.TRANS_TYPE_CHARGE_OFF);
//				}
//				//应收账款回款
//				if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_PAYMENT_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_PAYMENT_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_PAYMENT_APPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())
//						||WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY.equalsIgnoreCase(creditLimitOfBuyerVO.getApplyType())){
//					creditLimitOfBuyerVO.setApplyType(ScfBasConstant.TRANS_TYPE_PAYMENT);
//				}
//				//保理商赔款
//				if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_FACTOR_REPARATION_APPLY.equals(creditLimitOfBuyerVO.getApplyType())){
//					creditLimitOfBuyerVO.setApplyType(ScfBasConstant.TRANS_TYPE_REPARATION);
//				}
//				//保险公司赔款
//				if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_INSURANCE_REPARATION_APPLY.equals(creditLimitOfBuyerVO.getApplyType())){
//					creditLimitOfBuyerVO.setApplyType(ScfBasConstant.TRANS_TYPE_INSURANCE_PAYMENT);
//				}
//				returnList.add(creditLimitOfBuyerVO);
//			}
//			pageQueryReturnResult=pageQueryResult;
//			pageQueryReturnResult.setQueryResult(returnList);
//		}
//
//		return pageQueryReturnResult;
//	}

	/**
	 * 买方信用限额操作VO参数校验
	 * @param creditLimitOfBuyerDealVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午3:47:13
	 */
	public void checkCreditLimitOfBuyerDealVO(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException
	{
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCreditType())){
			throw new ScubeBizException("额度种类信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCustcd())){
			throw new ScubeBizException("卖方客户信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getOtherCustcd())){
			throw new ScubeBizException("买方客户信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getBusinessNo())){
			throw new ScubeBizException("业务合同信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(creditLimitOfBuyerDealVO.getAmount()==null){
			throw new ScubeBizException("操作金额信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getOperType())){
			throw new ScubeBizException("操作类型信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}else{
			//生效(录入)
			if(ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())
					||ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())){// 变更){
			}else if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())//预占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 冻结
				||ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 解冻
				||ScfBasConstant.CREDIT_TRADE_TYPE_END.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 终止
				||ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 预占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType()))// 直接占用
			{
				if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getApplyType())){
					throw new ScubeBizException("交易类型信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
				}
			}else{
				throw new ScubeBizException("操作类型信息不存在！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
			}
		}
	}

	/**
	 * 买方信用限额查询校验是否存在
	 * @param businessNo
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午3:47:07
	 */
	@SuppressWarnings("rawtypes")
	public Boolean checkCreditLimitOfBuyer(String businessNo,String custcd, String otherCustcd,
			String creditType) throws ScubeBizException
	{
		CreditQryVO creditQryVO=new CreditQryVO();
		creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
		creditQryVO.setBusinessNo_Q(businessNo);
		creditQryVO.setCustcd(custcd);
		creditQryVO.setOtherCustcd_Q(otherCustcd);
		creditQryVO.setCreditType_Q(creditType);
		creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
		creditQryVO.setFlag(ScfBasConstant.FLAG_ON);
		creditQryVO.setPageIndex(1);
		creditQryVO.setPageSize(Integer.MAX_VALUE);
		creditQryVO.setPageFlag(false);
		Page pageQueryResult = creditserviceservice.getTblCreditInfoByCreditQryVO(creditQryVO);
		List list=pageQueryResult.getRecords();
		if (list != null && list.size() > 0) {
			return true;// 额度存在
		} else {
			return false;// 额度不存在
		}
	}

	/**
	 * 新增或修改买方信用限额接口
	 * @param creditLimitOfBuyerDealVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午3:25:17
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public void addOrModifyCreditLimitInfoOfBuyer(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException
	{
		log.debug("addOrModifyCreditLimitInfoOfBuyer=======================start");
		//校验传入参数  检查数据完整性
		checkCreditLimitOfBuyerDealVO(creditLimitOfBuyerDealVO);

		String operType=creditLimitOfBuyerDealVO.getOperType();
		String custcd=creditLimitOfBuyerDealVO.getCustcd();
		String otherCustcd=creditLimitOfBuyerDealVO.getOtherCustcd();
		String creditType=creditLimitOfBuyerDealVO.getCreditType();
		String businessNo=creditLimitOfBuyerDealVO.getBusinessNo();

		String custName="";
		String errString="";
		if(!StringUtil.isEmpty(custcd)){
			BCrmBaseInfo baseInfo = bcrmbaseinfodao.selectById(custcd);
			custName = baseInfo.getCname();
			errString+="卖方客户【"+custName+"】";
		}

		String otherCustcdName="";
		if(!StringUtil.isEmpty(otherCustcd)){
			BCrmBaseInfo baseInfo = bcrmbaseinfodao.selectById(otherCustcd);
			otherCustcdName = baseInfo.getCname();
			errString+="，买方客户【"+otherCustcdName+"】";
		}

		String creditTypeName="";
		if(!StringUtil.isEmpty(creditType)){
			BIcrType bIcrType = bicrtypeservice.getTblCreditTypeByCreditType(creditType);
			creditTypeName = bIcrType.getCreditName();
			errString+="，额度类型【"+creditTypeName+"】";
		}

		if (ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equals(operType))// 生效(录入)
		{
			// 检查额度是否存在 条件：当前日期 业务合同号，额度种类，卖方客户号，买方客户号 记录不存在则异常抛出错误
			if (checkCreditLimitOfBuyer(businessNo,custcd, otherCustcd, creditType))
			{
					throw new ScubeBizException(errString+"额度信息已存在！",
												RBcpErrorConstant.RECORD_HAS_EXIST);
			}

			//获取新生成的信用限额额度编号
			String creditNo = bicrinfoservice.getCreditNoOfLimitBuyer();
			creditLimitOfBuyerDealVO.setCreditNo(creditNo);

			// 记录流水新增
			addTblCreditLimitInfoOfBuyerDetail(creditLimitOfBuyerDealVO);

			// 额度信息新增B_ICR_INFO
			addTblCreditLimitInfoOfBuyerInfo(creditLimitOfBuyerDealVO);

			//额度关联信息新增B_ICR_BUSI_REL
			BIcrBusiRel bIcrBusiRel = new BIcrBusiRel();
			bIcrBusiRel.setId(UUIDGeneratorUtil.generate());
			bIcrBusiRel.setRelaType(ScfBasConstant.CREDIT_RELA_TYPE_CONT);
			bIcrBusiRel.setCreditNo(creditNo);
			bIcrBusiRel.setBusinessNo(creditLimitOfBuyerDealVO.getBusinessNo());
			bicrbusireldao.insertSelective(bIcrBusiRel);
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(operType)// 预占用
			||ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(operType)// 占用
			||ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(operType)// 直接占用
			||ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(operType)// 预占用恢复（释放）
			||ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(operType)// 占用恢复（释放）
			||ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(operType)// 冻结
			||ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(operType)// 解冻
			||ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(operType)// 变更
			||ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(operType))// 终止
		{
			// 检查额度是否存在 条件：当前日期 业务合同号，额度种类，卖方客户号，买方客户号 记录不存在则异常抛出错误
			if (!checkCreditLimitOfBuyer(businessNo,custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！",
						RBcpErrorConstant.RECORD_NOT_EXIST);
			}

			// 检查额度是否存在 条件：当前日期 额度种类，卖方客户号，买方客户号 记录存在则异常抛出错误
			CreditQryVO creditQryVO=new CreditQryVO();
			creditQryVO.setBusinessNo_Q(creditLimitOfBuyerDealVO.getBusinessNo());
			creditQryVO.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
			creditQryVO.setOtherCustcd_Q(creditLimitOfBuyerDealVO.getOtherCustcd());
			creditQryVO.setCreditType_Q(creditLimitOfBuyerDealVO.getCreditType());
			creditQryVO.setPageIndex(1);
			creditQryVO.setPageSize(Integer.MAX_VALUE);
			creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
			creditQryVO.setPageFlag(false);
			Page pageQueryResult = creditserviceservice.getTblCreditInfoByCreditQryVO(creditQryVO);
			List<BIcrInfoDO> plist = pageQueryResult.getRecords();
			BIcrInfoDO tblCreditInfo = plist.get(0);

			if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCreditNo()))
			{
				creditLimitOfBuyerDealVO.setCreditNo(tblCreditInfo.getCreditNo());

			}
			// 记录流水新增
			addTblCreditLimitInfoOfBuyerDetail(creditLimitOfBuyerDealVO);

			// 更新额度信息TBL_CREDIT_INFO
			modifyTblCreditLimitInfoOfBuyerInfo(creditLimitOfBuyerDealVO);

		}
	}

	/**
	 * 买方信用限额流水新增
	 * @param creditLimitOfBuyerDealVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午3:34:27
	 */
	public void addTblCreditLimitInfoOfBuyerDetail(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException
	{
		BIcrDtl bIcrDtl = new BIcrDtl();
		
		bIcrDtl.setId(null);
		bIcrDtl.setCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
		bIcrDtl.setApplyType(creditLimitOfBuyerDealVO.getApplyType());
		bIcrDtl.setTxdate(ScfDateUtil.getStringDate(new Date()));
		bIcrDtl.setTxtime(new Date());
		bIcrDtl.setAppno(creditLimitOfBuyerDealVO.getAppno());
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getAppno()))
		{
			bIcrDtl.setAppno(creditLimitOfBuyerDealVO.getCreditNo());
		}
		bIcrDtl.setRelaType(ScfBasConstant.CREDIT_RELA_TYPE_CONT);
		bIcrDtl.setBusinessno(creditLimitOfBuyerDealVO.getBusinessNo());
		bIcrDtl.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
		bIcrDtl.setOperType(creditLimitOfBuyerDealVO.getOperType());
		String operType=creditLimitOfBuyerDealVO.getOperType();
		BigDecimal amount=creditLimitOfBuyerDealVO.getAmount();
		bIcrDtl.setAmount(amount);
		BIcrInfo bIcrInfo = null;
		if (ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equals(operType))// 生效(录入)
		{
			bIcrDtl.setCreditAmount(new BigDecimal("0"));
			bIcrDtl.setPreUsedAmount(new BigDecimal("0"));
			bIcrDtl.setUsedAmount(new BigDecimal("0"));
			bIcrDtl.setFrzAmount(new BigDecimal("0"));
			bIcrDtl.setCreditUsableAmount(new BigDecimal("0"));
			bIcrDtl.setCommonAmount(creditLimitOfBuyerDealVO.getAmount());
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(operType)     // 预占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(operType)         // 冻结
				||ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(operType)){// 直接占用
			bIcrInfo = bicrinfodao.selectByPrimaryKey(creditLimitOfBuyerDealVO.getCreditNo());
			bIcrDtl.setCreditAmount(bIcrInfo.getCreditAmount());
			bIcrDtl.setPreUsedAmount(bIcrInfo.getPreUsedAmount());
			bIcrDtl.setUsedAmount(bIcrInfo.getUsedAmount());
			bIcrDtl.setFrzAmount(bIcrInfo.getFrzAmount());
			bIcrDtl.setCreditUsableAmount(bIcrInfo.getCreditUsableAmount());
			bIcrDtl.setCommonAmount(bIcrInfo.getCreditUsableAmount().subtract(amount));
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(operType)// 占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(operType)){// 终止
			bIcrInfo = bicrinfodao.selectByPrimaryKey(creditLimitOfBuyerDealVO.getCreditNo());
			bIcrDtl.setCreditAmount(bIcrInfo.getCreditAmount());
			bIcrDtl.setPreUsedAmount(bIcrInfo.getPreUsedAmount());
			bIcrDtl.setUsedAmount(bIcrInfo.getUsedAmount());
			bIcrDtl.setFrzAmount(bIcrInfo.getFrzAmount());
			bIcrDtl.setCreditUsableAmount(bIcrInfo.getCreditUsableAmount());
			bIcrDtl.setCommonAmount(bIcrInfo.getCreditUsableAmount());
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(operType)// 预占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(operType)// 占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(operType)){// 解冻
			bIcrInfo = bicrinfodao.selectByPrimaryKey(creditLimitOfBuyerDealVO.getCreditNo());
			bIcrDtl.setCreditAmount(bIcrInfo.getCreditAmount());
			bIcrDtl.setPreUsedAmount(bIcrInfo.getPreUsedAmount());
			bIcrDtl.setUsedAmount(bIcrInfo.getUsedAmount());
			bIcrDtl.setFrzAmount(bIcrInfo.getFrzAmount());
			bIcrDtl.setCreditUsableAmount(bIcrInfo.getCreditUsableAmount());
			bIcrDtl.setCommonAmount(bIcrInfo.getCreditUsableAmount().add(amount));
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(operType)){// 变更
			bIcrInfo = bicrinfodao.selectByPrimaryKey(creditLimitOfBuyerDealVO.getCreditNo());
			bIcrDtl.setCreditAmount(bIcrInfo.getCreditAmount());
			bIcrDtl.setPreUsedAmount(bIcrInfo.getPreUsedAmount());
			bIcrDtl.setUsedAmount(bIcrInfo.getUsedAmount());
			bIcrDtl.setFrzAmount(bIcrInfo.getFrzAmount());
			bIcrDtl.setCreditUsableAmount(bIcrInfo.getCreditUsableAmount());
			bIcrDtl.setCommonAmount(amount);
		}
		bIcrDtl.setCommonDate(ScfDateUtil.getStringDate(new Date()));
		bIcrDtl.setLastUpdTime(new Date());
		bIcrDtl.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		bIcrDtl.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bIcrDtl.setStatus(ScfBasConstant.CREDIT_STATUS_TERMINATE);
		bicrdtlservice.add(bIcrDtl);

	}

	/**
	 * 买方信用限额额度新增
	 * @param creditLimitOfBuyerDealVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午3:47:59
	 */
	public void addTblCreditLimitInfoOfBuyerInfo(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException
	{
		BCntBcpInfo bCntBcpInfo = bcntbcpinfodao.selectByPrimaryKey(creditLimitOfBuyerDealVO.getBusinessNo());
		BIcrInfo bIcrInfo = new BIcrInfo();
		bIcrInfo.setCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
		bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
		bIcrInfo.setCreditType(creditLimitOfBuyerDealVO.getCreditType());
		bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_ROOT);
		bIcrInfo.setUpCreditNo(null);
		bIcrInfo.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
		bIcrInfo.setOtherCustcd(creditLimitOfBuyerDealVO.getOtherCustcd());
		bIcrInfo.setCurcd(bCntBcpInfo.getCurcd());
		bIcrInfo.setControlType(ScfBasConstant.CREDIT_CLASS_CYCLE);
		bIcrInfo.setCreditAmount(creditLimitOfBuyerDealVO.getAmount());
		bIcrInfo.setCreditUsableAmount(creditLimitOfBuyerDealVO.getAmount());
		bIcrInfo.setPreUsedAmount(new BigDecimal("0"));
		bIcrInfo.setUsedAmount(new BigDecimal("0"));
		bIcrInfo.setFrzAmount(new BigDecimal("0"));
		bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
		bIcrInfo.setStartDate(bCntBcpInfo.getStartDate());
		bIcrInfo.setEndDate(bCntBcpInfo.getEndDate());
		bIcrInfo.setTerm(ScfDateUtil.getTenOr(ScfDateUtil.numberToDate(bIcrInfo.getStartDate()),ScfDateUtil.numberToDate(bIcrInfo.getEndDate())));
		bIcrInfo.setValidDate(ScfDateUtil.getStringDate(new Date()));
		bIcrInfo.setLastUpdTime(new Date());
		bIcrInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bIcrInfo.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		try
		{
			bicrinfodao.insertSelective(bIcrInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("买方信用限额额度新增异常");
		}
	}

	/**
	 * 买方信用限额额度修改
	 * @param creditLimitOfBuyerDealVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午3:57:11
	 */
	public void modifyTblCreditLimitInfoOfBuyerInfo(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException
	{

		String custName="";
		String errString="";
		if(!StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCustcd()))
		{
			BCrmBaseInfo baseInfo = bcrmbaseinfodao.selectById(creditLimitOfBuyerDealVO.getCustcd());
			custName = baseInfo.getCname();
			errString+="卖方客户【"+custName+"】";
		}

		String otherCustcdName="";
		if(!StringUtil.isEmpty(creditLimitOfBuyerDealVO.getOtherCustcd()))
		{
			BCrmBaseInfo baseInfo = bcrmbaseinfodao.selectById(creditLimitOfBuyerDealVO.getOtherCustcd());
			otherCustcdName = baseInfo.getCname();
			errString+="，买方客户【"+otherCustcdName+"】";
		}

		String creditTypeName="";
		if(!StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCreditType()))
		{
			BIcrType bIcrType = bicrtypeservice.getTblCreditTypeByCreditType(creditLimitOfBuyerDealVO.getCreditType());
			creditTypeName = bIcrType.getCreditName();
			errString+="，额度类型【"+creditTypeName+"】";
		}
		
		BIcrInfo bIcrInfo = bicrinfodao.selectByPrimaryKey(creditLimitOfBuyerDealVO.getCreditNo());
		//交易金额
		BigDecimal amount =(creditLimitOfBuyerDealVO.getAmount()==null?new BigDecimal("0"):creditLimitOfBuyerDealVO.getAmount());
		//可用余额
		BigDecimal creditUsableAmount=(bIcrInfo.getCreditUsableAmount()==null?new BigDecimal("0"):bIcrInfo.getCreditUsableAmount());
		//预占用金额
		BigDecimal preUsedAmount=(bIcrInfo.getPreUsedAmount()==null?new BigDecimal("0"):bIcrInfo.getPreUsedAmount());
		//已占用金额
		BigDecimal usedAmount=(bIcrInfo.getUsedAmount()==null?new BigDecimal("0"):bIcrInfo.getUsedAmount());
		//冻结金额
		BigDecimal frzAmount=(bIcrInfo.getFrzAmount()==null?new BigDecimal("0"):bIcrInfo.getFrzAmount());

		String operType=creditLimitOfBuyerDealVO.getOperType();
		if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(operType))//预占用
		{
			if(amount.compareTo(creditUsableAmount)==1){
				throw new ScubeBizException(errString+"的额度预占用时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
		 	//可用额度 = 前可用额度 – 交易金额
			bIcrInfo.setCreditUsableAmount(creditUsableAmount.subtract(amount));//可用金额减少
		 	//预占用额度 = 前预占用额度 + 交易金额
			bIcrInfo.setPreUsedAmount(preUsedAmount.add(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(operType))//预占用恢复（释放）
		{
			if(amount.compareTo(preUsedAmount)==1){
				throw new ScubeBizException(errString+"的额度恢复时操作金额大于预占用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
		 	//可用额度 = 前可用额度 + 交易金额
			bIcrInfo.setCreditUsableAmount(creditUsableAmount.add(amount));
			//预占用额度 = 前预占用额度 - 交易金额
			bIcrInfo.setPreUsedAmount(preUsedAmount.subtract(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(operType))//占用
		{
			if(amount.compareTo(preUsedAmount)==1){
				throw new ScubeBizException(errString+"的额度占用时操作金额大于预占用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//预占用额度 = 前预占用额度 - 交易金额
			bIcrInfo.setPreUsedAmount(preUsedAmount.subtract(amount));
			//实占用额度 = 前实占用额度 + 交易金额
			bIcrInfo.setUsedAmount(usedAmount.add(amount));
		}

		if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(operType))//占用恢复（释放）
		{
			if(amount.compareTo(usedAmount)==1){
				throw new ScubeBizException(errString+"的额度恢复时操作金额大于实占额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度余额 = 前额度余额 + 交易金额
			bIcrInfo.setCreditUsableAmount(creditUsableAmount.add(amount));
			//实占用额度 = 前实占用额度 - 交易金额
			bIcrInfo.setUsedAmount(usedAmount.subtract(amount));
		}

		if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(operType))//直接占用
		{
			if(amount.compareTo(creditUsableAmount)==1){
				throw new ScubeBizException(errString+"的额度直接占用时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
		 	//额度余额 = 前额度余额 – 交易金额
			bIcrInfo.setCreditUsableAmount(creditUsableAmount.subtract(amount));
			//实占用额度 = 前实占用额度 + 交易金额
			bIcrInfo.setUsedAmount(usedAmount.add(amount));
		}

		if(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(operType))//变更
		{
			if(amount.compareTo(usedAmount.add(frzAmount).add(preUsedAmount))<0){
				throw new ScubeBizException(errString+"的额度变更时操作金额小于已使用额度、预占用额度与冻结额度之和，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度总额=交易金额
			bIcrInfo.setCreditAmount(amount);
			//可用额度=交易金额-已使用额度-冻结额度-预占用额度
			bIcrInfo.setCreditUsableAmount(amount.subtract(usedAmount));

		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(operType))//冻结
		{
			if(amount.compareTo(creditUsableAmount)==1){
				throw new ScubeBizException(errString+"的额度冻结时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度余额 = 前额度余额 - 交易金额
			bIcrInfo.setCreditUsableAmount(creditUsableAmount.subtract(amount));
			//冻结金额 = 前冻结金额 + 交易金额
			bIcrInfo.setFrzAmount(frzAmount.add(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(operType))//解冻
		{
			if(amount.compareTo(frzAmount)==1){
				throw new ScubeBizException(errString+"的额度解冻时操作金额大于冻结金额，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度余额 = 前额度余额 + 交易金额
			bIcrInfo.setCreditUsableAmount(creditUsableAmount.add(usedAmount));
			//冻结金额 = 前冻结金额 - 交易金额
			bIcrInfo.setFrzAmount(frzAmount.subtract(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(operType))//终止
		{
			bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_TERMINATE);
		}
		bIcrInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		bIcrInfo.setLastUpdTime(new Date());
		bIcrInfo.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		try
		{
			bicrinfodao.updateByPrimaryKeySelective(bIcrInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("买方信用限额额度修改异常");
		}
	}

	/**
	 *
	 * @Description: 买方信用限额额度通用处理
	 * @author wenkui.xu
	 * @Created 2013-8-6上午10:49:47
	 * @param appno	        申请编号
	 * @param operType 操作类型
	 * 		    常量定义SCFConstant:
	 *        03-恢复释放（占用恢复）;09-直接占用
	 * @param amt 业务金额
	 * @throws CommonException
	 */
//	@SuppressWarnings("unchecked")
//	public void creditLimitOfBuyerAppliCommonProcess(String appno,String operType,BigDecimal amt) throws ScubeBizException
//	{
//		TblAppliBaseInfoDAO tblAppliBaseInfoDAO=SCFDAOUtils.getTblAppliBaseInfoDAO();
//		TblAppliBaseInfo tblAppliBaseInfo=tblAppliBaseInfoDAO.get(appno);
//		String businessno=tblAppliBaseInfo.getBusinessno();//业务合同号
//		String appliType=tblAppliBaseInfo.getAppliType();//申请类型
//		if(StringUtil.isEmpty(appno)){
//			throwCommonException("申请号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
//		}
//		String productId=tblAppliBaseInfo.getSupplyChainPdId();//产品编号
//		if(StringUtil.isEmpty(productId)){
//			throwCommonException("产品编号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
//		}
//
//		TblAppliBussInfoDAO tblAppliBussInfoDAO=SCFDAOUtils.getTblAppliBussInfoDAO();
//		TblAppliBussInfo tblAppliBussInfo=tblAppliBussInfoDAO.getAppliBussByAppno(appno);
//		String custcd =tblAppliBussInfo.getCustcdSaller();//客户号卖方
//		String otherCustcd =tblAppliBussInfo.getCustcdBuyer();//交易对手,买方
//
//		String creditPhase="";//额度阶段
//		String creditOprType="";//额度操作
//		// 国内双保理回款
//		if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_PAYMENT_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PAYMENT;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//国内双保理  保理商赔款
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_FACTOR_REPARATION_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_MANA_INSURANCE_PAYMENT;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//国内双保理 应收账款转让
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_AANWINST_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PURCHASE;
//			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)){
//				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
//			}
//			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)){
//				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//			}
//		}
//		//国内双保理 应收账款减值
//		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCEDOUBLEAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_ALLOWANCE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//国内双保理 应收账款反转让
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_BUY_BACK_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_BACK_PURCHASE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//国内双保理 应收账款核销
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_CHARGEOFF;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//信用保理 应收账款回款
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_PAYMENT_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_PAYMENT;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//信用保理 保险公司赔款
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_INSURANCE_REPARATION_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_COMPANY_INSURANCE_PAYMENT;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//信用保理 应收账款转让
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_AANWINST_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_PURCHASE;
//			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)){
//				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
//			}
//			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)){
//				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//			}
//		}
//		//信用保理 应收账款减值
//		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCECREDITAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_ALLOWANCE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//信用保理 应收账款反转让
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_BUY_BACK_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_BACK_PURCHASE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//信用保理 应收账款核销
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_CHARGEOFF;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//
//		//国内保理 应收账款回款
//		else if(WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_DEBT_PAYMENT;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//国内保理 应收账款转让
//		else if(WorkflowConstant.APPLI_TYPE_FACTORINGAANWINSTAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PURCHASE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
//		}
//		//国内保理 应收账款减值
//		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCEAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_ALLOWANCE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//国内保理 应收账款反转让
//		else if(WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTREPURAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_BACK_PURCHASE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//国内保理 应收账款核销
//		else if(WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTCANCELAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_CHARGEOFF;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//
//		//租赁保理回款
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_PAYMENT_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASEE_LEASE_FACTORING_INSURANCE_PAYMENT;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//租赁保理转让申请
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_AANWINST_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PURCHASE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
//		}
//		// 租赁保理减值
//		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCELEASEAPPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_ALLOWANCE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//租赁保理反转让
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_BUY_BACK_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_BACK_PURCHASE;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//		//租赁保理核销
//		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_LEASE_CHARGE_OFF_APPLY.equalsIgnoreCase(appliType)){
//			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_CHARGEOFF;
//			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
//		}
//
//		if(!StringUtil.isEmpty(productId)&&!StringUtil.isEmpty(creditPhase)&&!StringUtil.isEmpty(creditOprType)){
//			//根据产品Id及操作类型  获取当前业务阶段的额度设定列表
//			TblProductCreditBindDAO  productCreditBindDAO = SCFDAOUtils.getTblProductCreditBindDAO() ;
//			//设置查询条件
//			TblProductCreditBind productCreditBind = new TblProductCreditBind();
//			productCreditBind.setProductId(productId); // 产品Id
//			productCreditBind.setCreditPhase(creditPhase);
//			productCreditBind.setOprType(creditOprType);
//
//			//依据产品Id和操作类型查询
//			List<TblProductCreditBind> creditBindList = productCreditBindDAO.getTblProductCreditBind(productCreditBind);
//
//			CommonCreditProcessBussAmtVO bussAmtVO=new CommonCreditProcessBussAmtVO();
//			bussAmtVO.setBussAmount(amt);
//
//			//循环当前业务阶段的额度设定列表,依次处理额度列表中的各种额度
//			TblCreditTypeDAO tblCreditTypeDAO=SCFDAOUtils.getTblCreditTypeDAO();
//			for(int i=0; i<creditBindList.size(); i++){
//				BigDecimal amount = null;  // 操作金额
//
//				//获取产品额度绑定信息
//				TblProductCreditBind creditBind = creditBindList.get(i);
//				String creditType = creditBind.getCreditType();  // 额度类型
//				String oprField = creditBind.getOprField(); // 额度操作金额
//
//				CreditTypeQryVO creditTypeQryVO=new CreditTypeQryVO();
//				creditTypeQryVO.setPageIndex(1);
//				creditTypeQryVO.setPageSize(Integer.MAX_VALUE);
//				creditTypeQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
//				creditTypeQryVO.setCreditType_Q(creditType);
//				PageQueryResult pageQueryResult=tblCreditTypeDAO.getCreditTypeInfoByCreditTypeQryVO(creditTypeQryVO);
//				if(pageQueryResult.getQueryResult()!=null&&pageQueryResult.getTotalCount()>0){
//					//获取额度操作的金额
//					String oprFieldName = CreditOptFieldMap.fieldMap.get(oprField);
//					try {
//						String amountStr = BeanUtils.getProperty(bussAmtVO, oprFieldName);
//						if(StringUtil.isEmpty(amountStr)){
//							throwCommonException("额度操作金额配置错误！", RBcpErrorConstant.ERROR_CODE_UNKNOWN);
//						}
//						amount = new BigDecimal(amountStr);
//						if(amount.compareTo(new BigDecimal("0")) == 0){ // 如果操作金额为等于0则不进行处理
//							continue;
//						}
//					} catch (Throwable te) {
//						te.printStackTrace();
//						throwCommonException("额度操作金额配置错误！", RBcpErrorConstant.ERROR_CODE_UNKNOWN);
//					}
//
//					// 设置额度处理参数
//					CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO=new CreditLimitOfBuyerDealVO();
//					creditLimitOfBuyerDealVO.setApplyType(appliType);
//					creditLimitOfBuyerDealVO.setAmount(amount);
//					creditLimitOfBuyerDealVO.setOperType(operType);
//					creditLimitOfBuyerDealVO.setCustcd(custcd);
//					creditLimitOfBuyerDealVO.setOtherCustcd(otherCustcd);
//					creditLimitOfBuyerDealVO.setBusinessNo(businessno);
//					creditLimitOfBuyerDealVO.setCreditType(creditType);
//
//					addOrModifyCreditLimitInfoOfBuyer(creditLimitOfBuyerDealVO);
//				}
//			}
//		}
//	}
}
