/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IFactFinanceBaseService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 *  应收类融资基础服务Service
 *
 * @author <a href="mailto:zhangwu@topscf.com">zhangwu</a>
 *
 * @version Revision: 1.0  Date: 2013-5-18 上午11:59:14
 *
 */

@ScubeService
@Service("FactFinanceBaseServiceImpl")
public class FactFinanceBaseServiceImpl implements IFactFinanceBaseService{

	private final Logger log = LoggerFactory.getLogger(getClass());
	//供应链借据基本信息
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rbcpdebtbaseinfoservice;
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice;
	
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;

	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bicrinfoservice;
	
	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bcntdebtinfoservice;

	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rbcpdebtpoolservice;
	
	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bbrpprdfactoringservice;

	@Resource(name = "BPrdCreditBindServiceImpl")
	IBPrdCreditBindService bprdcreditbindservice;
	
	/**
	 * 描述：查询融资列表信息
	 * @param debtLnciQryVO
	 * @return
	 * @throws ScubeBizException
	 * @date 2013-7-9
	 * @author zhonghuabin modified by jialei.zhang  2013-7-31
	 */
//	public PageQueryResult getFinanceApplyList(DebtLnciQryVO debtLnciQryVO) throws ScubeBizException {
//		FinanceServiceDAO dao = SCFDAOUtils.getFinanceServiceDAO();
//		if(ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(debtLnciQryVO.getFactType_Q())){
//			debtLnciQryVO.setFactType_Q("'" + ScfBasConstant.FACT_TYPE_INLAND
//							+ "','" + ScfBasConstant.FACT_TYPE_REVERSE + "','"
//							+ ScfBasConstant.FACT_TYPE_DEBT_PLEDGE + "'");//应收账款 标志位 反向保理，国内保理，应收账款质押
//		}else if(ScfBasConstant.T_FINANCING_TYPE_POOL.equals(debtLnciQryVO.getFactType_Q())){
//			debtLnciQryVO.setFactType_Q("'"+ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE
//							+"','"+ScfBasConstant.FACT_TYPE_DEBT_POOL
//							+"','"+ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE+"'");
//		}
//		PageQueryResult pageQueryResult = dao.getFinanceApplyList(debtLnciQryVO);
//		Iterator iter = pageQueryResult.getQueryResult().iterator();
//		List list = new ArrayList();
//		DebtLnciBaseInfoVO vo = null;
//		TblAppliBaseInfo tblAppliBaseInfo = null;
//		TblContBaseInfo tblContBaseInfo = null;
//		TblAppliLnciBaseInfo tblAppliLnciBaseInfo = null;
//		BigDecimal contOpentAmt = null;
//		AmountService amountService = AmountService.getInstance();
//
//		while(iter.hasNext()){
//			Object[] obj = (Object[]) iter.next();
//			vo = new DebtLnciBaseInfoVO();
//			tblAppliBaseInfo = (TblAppliBaseInfo)obj[0];
//			tblAppliLnciBaseInfo = (TblAppliLnciBaseInfo)obj[1];
//			tblContBaseInfo = SCFDAOUtils.getTblContBaseInfoDAO()
//					.getTblContBaseInfoByMastContCode(tblAppliLnciBaseInfo.getMastContcode());
///*			if (tblContBaseInfo != null){
//				CommonFunction.copyProperties(vo,tblContBaseInfo);
//			}*/
//			CommonFunction.copyProperties(vo,tblAppliBaseInfo);
//			CommonFunction.copyProperties(vo,tblAppliLnciBaseInfo);
//			vo.setCname((String)obj[2]);
//			if (tblContBaseInfo == null){
//				vo.setMastContno("");
//				vo.setBusinessNo("");
//			}
//			if (tblContBaseInfo != null){
//				vo.setContAmount(tblContBaseInfo.getContAmount());//合同金额
//				vo.setRiskAmt(tblContBaseInfo.getRiskAmt());//合同总敞口
//				vo.setBusinessNo(tblContBaseInfo.getBusinessNo());//业务合同号
//				vo.setLoanWay(tblContBaseInfo.getLoanWay());//出账方式
//				//计算信贷合同可用敞口
//				contOpentAmt = amountService.getContRiskAmtByCycle(tblContBaseInfo.getMastContno(),tblContBaseInfo.getCycle());
//				vo.setAvaliableRiskAmt(tblContBaseInfo.getRiskAmt().subtract(contOpentAmt));
//			}
//
//			/*TblCustBaseInfoDAO tblCustBaseInfoDAO=DAOUtils.getTblCustBaseInfoDAO();
//			TblCustBaseInfo tblCustBaseInfo=tblCustBaseInfoDAO.queryCustByCustno(vo.getCreditCustcd());
//			if (tblCustBaseInfo != null){
//				vo.setCreditCustcd(tblCustBaseInfo.getCustcd());
//			}*/
//
//           	//判断是否有领用间接额度
//          	BigDecimal creditUseBal=BigDecimal.ZERO;
//            //查询额度类型
//          	String hasIndirectCredit=tblAppliLnciBaseInfo.getHasIndirectCredit();//间接额度类型
//    		String factType = StringUtil.trim(SCFDAOUtils
//    				.getTblProductFactoringDAO().get(tblAppliBaseInfo.getSupplyChainPdId()).getFactType());
//    		if(ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(hasIndirectCredit)){
//          		TblProductCreditBind tblProductCreditBind=new TblProductCreditBind();
//            	tblProductCreditBind.setProductId(tblAppliBaseInfo.getSupplyChainPdId());
//            	tblProductCreditBind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_BUYER_AND_SELLER);//模式
//				if (factType.equals(ScfBasConstant.FACT_TYPE_INLAND)
//						|| factType.equals(ScfBasConstant.FACT_TYPE_REVERSE)
//						|| factType.equals(ScfBasConstant.FACT_TYPE_DEBT_PLEDGE)) {
//					tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_DEBT_FINANCING);//额度阶段
//				} else if (factType.equals(ScfBasConstant.FACT_TYPE_DOUBLE_FACT)) {
//					tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FACTORING_FINANCING);//额度阶段
//				} else if (factType.equals(ScfBasConstant.FACT_TYPE_CREDIT_FACT)) {
//					tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_FINANCING);//额度阶段
//				} else if (factType.equals(ScfBasConstant.FACT_TYPE_LEASE_FACT)) {
//					tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_LEASE_FACTORING_FINANCING);//额度阶段
//				}
//            	tblProductCreditBind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);//操作类型
//            	String creditType="";
//          		List<TblProductCreditBind> creditBindList = SCFDAOUtils.getTblProductCreditBindDAO().getTblProductCreditBind(tblProductCreditBind);
//          		if(creditBindList!=null&creditBindList.size()>0){
//          			TblProductCreditBind creditBind = creditBindList.get(0);
//          			 creditType = creditBind.getCreditType();  // 额度类型
//          		}
//
//	          	if(!DataFormat.isEmpty(creditType)){
//	          		CreditQryVO creditQryVO=new CreditQryVO();
//	        		creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
//	        		creditQryVO.setNodeType_Q(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);//领用额度
//	        		creditQryVO.setCustcd_Q(tblAppliLnciBaseInfo.getCreditCustcd());
//	        		creditQryVO.setOtherCustcd_Q(tblAppliLnciBaseInfo.getCustcd());//appliLnciBaseInfo.getCreditCustcd()
//	        		creditQryVO.setCreditType_Q(creditType);
//	        		creditQryVO.setPageIndex(1);
//	        		creditQryVO.setPageSize(Integer.MAX_VALUE);
//	                creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
//	        		PageQueryResult pageList=SCFDAOUtils.getTblCreditInfoDAO().getCurrenyEffectiveTblCreditInfoByCreditQryVO(creditQryVO);
//	        		List subLeafCreditInfoList=pageList.getQueryResult();
//	        		if (subLeafCreditInfoList!=null&&subLeafCreditInfoList.size()>0) {
//	        			vo.setFlag("1");
//	        		}else{
//	        			vo.setFlag("0");
//	        		}
//	          	}
//          	}
//
//			list.add(vo);
//		}
//		pageQueryResult.setQueryResult(list);
//		return pageQueryResult;
//	}

	/**
	 *
	 * @Description: 计算信贷合同下借据可用敞口余额
	 * @author jialei.zhang
	 * @Created 2013年8月2日下午4:43:49
	 * @param mastContno
	 * @return
	 */
//	private BigDecimal calculateContRiskAvailableAmt(String mastContno) {
//		List list = SCFDAOUtils.getTblLnciBaseInfoDAO().findByProperty("TblLnciBaseInfo", "mastContno", mastContno);
//		if(list !=null && list.size() > 0){
//			BigDecimal totalContRist = new BigDecimal(0);  //合同项下的借据敞口余额,等于合同可用敞口余额
//			TblLnciBaseInfo tblLnciBaseInfoTmp = null;
//			int count = list.size();
//			BigDecimal addBailAmount;
//			BigDecimal bailAmount;
//			BigDecimal initCashEqtAmt;
//			BigDecimal addCashEqtAmt;
//			BigDecimal lnciBal;
//
//			for(int i=0;i<count;i++){
//				tblLnciBaseInfoTmp = (TblLnciBaseInfo) list.get(i);
//				//借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
//				addBailAmount = (tblLnciBaseInfoTmp.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfoTmp.getAddBailAmount());
//				bailAmount = (tblLnciBaseInfoTmp.getBailAmount()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getBailAmount());
//				initCashEqtAmt = (tblLnciBaseInfoTmp.getInitCashEqtAmt()== null? new BigDecimal(0):tblLnciBaseInfoTmp.getInitCashEqtAmt());
//				addCashEqtAmt = (tblLnciBaseInfoTmp.getAddCashEqtAmt()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getAddCashEqtAmt());
//				lnciBal = tblLnciBaseInfoTmp.getLnciBal();
//				totalContRist = totalContRist.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
//			}
//			return totalContRist;
//		}else{
//			return new BigDecimal(0);
//		}
//
//	}

//	private BigDecimal calcLnciRiskAvailableAmt(String debetId) {
//		List list = SCFDAOUtils.getTblLnciBaseInfoDAO().findByProperty("TblLnciBaseInfo", "debetId", debetId);
//		if(list !=null && list.size() > 0){
//			BigDecimal totalContRist = new BigDecimal(0);  //合同项下的借据敞口余额,等于合同可用敞口余额
//			TblLnciBaseInfo tblLnciBaseInfoTmp = null;
//			int count = list.size();
//			BigDecimal addBailAmount;
//			BigDecimal bailAmount;
//			BigDecimal initCashEqtAmt;
//			BigDecimal addCashEqtAmt;
//			BigDecimal lnciBal;
//
//			tblLnciBaseInfoTmp = (TblLnciBaseInfo) list.get(0);
//			//借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
//			addBailAmount = (tblLnciBaseInfoTmp.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfoTmp.getAddBailAmount());
//			bailAmount = (tblLnciBaseInfoTmp.getBailAmount()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getBailAmount());
//			initCashEqtAmt = (tblLnciBaseInfoTmp.getInitCashEqtAmt()== null? new BigDecimal(0):tblLnciBaseInfoTmp.getInitCashEqtAmt());
//			addCashEqtAmt = (tblLnciBaseInfoTmp.getAddCashEqtAmt()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getAddCashEqtAmt());
//			lnciBal = tblLnciBaseInfoTmp.getLnciBal();
//			totalContRist = totalContRist.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
//
//			return totalContRist;
//		}else{
//			return new BigDecimal(0);
//		}
//
//	}

	/**
	 *
	 * @Description: 应收账款池融资合同项下生效的借据敞口余额汇总
	 * @author jialei.zhang
	 * @Created 2013-8-21下午8:19:11
	 * @param businessNo
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BigDecimal calculatePoolRiskAvailableAmtByBusinessNo(String businessNo) throws ScubeBizException{
		log.debug("businessNo="+businessNo);
		DebtLnciQryVO lnciQryVO =new DebtLnciQryVO();
		lnciQryVO.setPageIndex(1);
		lnciQryVO.setPageSize(Integer.MAX_VALUE);
		lnciQryVO.setBussContno(businessNo);
		lnciQryVO.setFlag(ScfBasConstant.FLAG_ON);//是否应收账款池敞口查询
		Page result = blanlncibaseservice.queryLnciInfoByBusinessNo(lnciQryVO);
		List flowList = bpbcapplibaseinfoservice.getFlowRiskAmtByBusinessNo(businessNo);
		List list = result.getRecords();
		BigDecimal totalContRist = new BigDecimal(0);
		if(list !=null && list.size() > 0){
			com.huateng.scf.bas.lan.dao.model.BLanLnciBase tblLnciBaseInfoTmp = null;
			int count = list.size();
			BigDecimal addBailAmount;
			BigDecimal bailAmount;
			BigDecimal initCashEqtAmt;
			BigDecimal addCashEqtAmt;
			BigDecimal lnciBal;

			for(int i=0;i<count;i++){
				tblLnciBaseInfoTmp = (com.huateng.scf.bas.lan.dao.model.BLanLnciBase) list.get(i);
				//借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
				addBailAmount = (tblLnciBaseInfoTmp.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfoTmp.getAddBailAmount());
				bailAmount = (tblLnciBaseInfoTmp.getBailAmount()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getBailAmount());
				initCashEqtAmt = (tblLnciBaseInfoTmp.getInitCashEqtAmt()== null? new BigDecimal(0):tblLnciBaseInfoTmp.getInitCashEqtAmt());
				addCashEqtAmt = (tblLnciBaseInfoTmp.getAddCashEqtAmt()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getAddCashEqtAmt());
				lnciBal = tblLnciBaseInfoTmp.getLnciBal();
				totalContRist = totalContRist.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
			}
		}
		// 流程中借据敞口余额也要统计  add by xiaolong.xiong 2013-09-29
		if(flowList != null && flowList.size() > 0){
			HashMap<String, Object> map = (HashMap<String, Object>) flowList.get(0);
			BigDecimal amt = (BigDecimal) (map.get("riskAmount") == null ? BigDecimal.ZERO : map.get("riskAmount"));
			totalContRist = totalContRist.add(amt);
		}
		return totalContRist;
	}
	/**
	 * 查询应收账款融资申请详细信息
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午3:34:41
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DebtLnciBaseInfoVO getInvoiceFinanceApplyInfo(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {
		BCrrLnCon contBaseInfo = bcrrlnconservice.findBCrrLnConByAppId(debtCommonQryVO.getMastContno()); //信贷合同信息
		BPbcAppliBaseInfo appliBaseInfo =bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtCommonQryVO.getAppno_Q());
		BCntDebtInfo contDebtInfo = null;
		if(contBaseInfo!=null){
			contDebtInfo = bcntdebtinfoservice.findBCntDebtInfoByKey(contBaseInfo.getVidNo()); // 保理合同信息
		}
		BLanAppliLnciBase appliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(debtCommonQryVO.getAppno_Q());// 借据申请信息
//		TblAppliBussDetail tblAppliBussDetail = tblAppliBussDetailDAO
//				.getDebtBussDtlByAppno(debtCommonQryVO.getAppno_Q());// 应收账款申请信息
		BigDecimal poolRemainDebtAmt=new BigDecimal(0.00);
		BigDecimal poolUseableAmount=new BigDecimal(0.00);//TBL_DEBT_POOL中可融资金额
		DebtLnciBaseInfoVO debtVO = new DebtLnciBaseInfoVO();

		if(contDebtInfo!=null){
			BeanUtils.copyProperties(contDebtInfo,debtVO);
			debtVO.setPoolRiskAmt(calculatePoolRiskAvailableAmtByBusinessNo(contDebtInfo.getDebtContno()));//池敞口
		}
		BeanUtils.copyProperties(appliLnciBaseInfo,debtVO);

		debtVO.setAppBrcode(appliBaseInfo.getAppBrcode());  //申请机构
		if(contBaseInfo!=null){
			BeanUtils.copyProperties(contBaseInfo,debtVO);
			debtVO.setRateType(appliLnciBaseInfo.getRateType());
			debtVO.setRateFloatType(appliLnciBaseInfo.getRateFloatType());
			debtVO.setRateFloatValue(appliLnciBaseInfo.getRateFloatValue());
			debtVO.setContRiskAmt(contBaseInfo.getLnAmt());
			//用统一的方法，计算信贷合同可用敞口。
			BigDecimal contOpenAmt = amountservice.getContRiskAmtByCycle(contBaseInfo.getAppId(), contBaseInfo.getControlType());
			debtVO.setAvaliableRiskAmt(contBaseInfo.getLnAmt().subtract(contOpenAmt));
		}
		BigDecimal riskAmt=new BigDecimal(0);
		riskAmt = (debtVO.getLnciAmt() == null ? BigDecimal.ZERO : debtVO.getLnciAmt())
				.subtract(debtVO.getBailAmount() == null ? BigDecimal.ZERO : debtVO.getBailAmount())
				.subtract(debtVO.getAddBailAmount() == null ? BigDecimal.ZERO : debtVO.getAddBailAmount())
				.subtract(debtVO.getInitCashEqtAmt() == null ? BigDecimal.ZERO : debtVO.getInitCashEqtAmt())
				.subtract(debtVO.getAddCashEqtAmt() == null ? BigDecimal.ZERO : debtVO.getAddCashEqtAmt());
		if(riskAmt.compareTo(new BigDecimal(0))>0){
			debtVO.setRiskAmt(riskAmt);
		}else{
			debtVO.setRiskAmt(new BigDecimal(0));
		}
		debtVO.setBillNum(appliLnciBaseInfo.getBillNum());
		debtVO.setFinacingStartDate(ScfDateUtil.numberToDate(appliLnciBaseInfo.getStartDate()));
		debtVO.setFinacingEndDate(ScfDateUtil.numberToDate(appliLnciBaseInfo.getEndDate()));
		debtVO.setBailAccount(contDebtInfo.getBailAcctNo());
		if(ScfBasConstant.T_FINANCING_TYPE_POOL
				.equals(debtCommonQryVO.getFactType_Q())&&contBaseInfo!=null){
			DebtCommonQryVO commonQueryVO=new DebtCommonQryVO();
			commonQueryVO.setPageIndex(1);
			commonQueryVO.setPageSize(Integer.MAX_VALUE);
			commonQueryVO.setMastContno(contBaseInfo.getVidNo());
			List<RBcpDebtPool> poollist = rbcpdebtpoolservice.getInPoolInfo(commonQueryVO);
			if(poollist!=null&&poollist.size()>0){
				RBcpDebtPool debtPool=(RBcpDebtPool)poollist.get(0);
				if(debtPool!=null){
					poolRemainDebtAmt=debtPool.getTotalDebtRemainAmount();
					poolUseableAmount = debtPool.getPoolUseableAmount();
					debtVO.setTotalBillsAmount(poolRemainDebtAmt);
					debtVO.setPoolUseableAmount(poolUseableAmount);
				}
			}
		}
		//查询额度类型
		String factType = bbrpprdfactoringservice.findBBrpPrdFactoringByKey(debtVO.getSupplyChainPdId()).getFactType().trim();
       	BPrdCreditBind tblProductCreditBind=new BPrdCreditBind();
       	tblProductCreditBind.setProductId(debtVO.getSupplyChainPdId());
		if (factType.equals(ScfBasConstant.FACT_TYPE_INLAND)
				|| factType.equals(ScfBasConstant.FACT_TYPE_REVERSE)
				|| factType.equals(ScfBasConstant.FACT_TYPE_DEBT_PLEDGE)) {
			tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_DEBT_FINANCING);//额度阶段
		} else if (factType.equals(ScfBasConstant.FACT_TYPE_DOUBLE_FACT)) {
			tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FACTORING_FINANCING);//额度阶段
		} else if (factType.equals(ScfBasConstant.FACT_TYPE_CREDIT_FACT)) {
			tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_FINANCING);//额度阶段
		} else if (factType.equals(ScfBasConstant.FACT_TYPE_LEASE_FACT)) {
			tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_LEASE_FACTORING_FINANCING);//额度阶段
		}
       	tblProductCreditBind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);//操作类型
		List<BPrdCreditBind> creditBindList = bprdcreditbindservice.getTblProductCreditBind(tblProductCreditBind);
		String creditType="";
		if(creditBindList!=null&creditBindList.size()>0){
			BPrdCreditBind creditBind = creditBindList.get(0);
 			 creditType = creditBind.getCreditType();  // 额度类型
 		}
		debtVO.setCreditType(debtVO.getHasIndirectCredit());
		if (!StringUtil.isEmpty(debtVO.getOtherCustcd()) && !StringUtil.isEmpty(creditType))
		{
			CreditQryVO creditQryVO = new CreditQryVO();
			creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
			creditQryVO.setNodeType_Q(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
			creditQryVO.setCreditType_Q(creditType);
			creditQryVO.setCustcd(debtVO.getOtherCustcd());
			creditQryVO.setOtherCustcd_Q(debtVO.getCustcd());
			creditQryVO.setPageIndex(1);
       		creditQryVO.setPageSize(Integer.MAX_VALUE);
            creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
			Page pageResult = bicrinfoservice.getCurrenyEffectiveTblCreditInfoByCreditQryVO(creditQryVO);
			List relist = pageResult.getRecords();
			if (relist != null && relist.size()>0){
				BIcrInfo tblCreditInfo = (BIcrInfo)relist.get(0);
				debtVO.setCreditUseBal(tblCreditInfo.getCreditUsableAmount());
			}else{
				debtVO.setCreditUseBal(new BigDecimal(0.0));
			}
		}
		debtVO.setFlag(debtCommonQryVO.getFlag());//保存标识
		if(appliBaseInfo!=null){
			debtVO.setMemo(appliBaseInfo.getMemo());
		}
		return debtVO;
	}

	/**
	 *
	 * @Description: 查询应收账款列表
	 * @author jialei.zhang
	 * @Created 2013-8-5下午4:39:29
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
//	public PageQueryResult queryAppliBussDetailByAppnoDebt(String appno) throws ScubeBizException {
//		TblAppliBussDetailDAO tblAppliBussDetailDAO = SCFDAOUtils.getTblAppliBussDetailDAO();
//		TblDebtBaseInfoDAO debtBaseDAO=SCFDAOUtils.getTblDebtBaseInfoDAO();
//		List<AppliBussDetailVO> relist = tblAppliBussDetailDAO.queryAppliBussDetailByAppnoDebt(appno);
//		PageQueryResult pageQueryResult = new PageQueryResult();
//		if (relist != null && relist.size() > 0){
//			Iterator ite=relist.iterator();
//			List list=new ArrayList();
//			while(ite.hasNext()){
//				AppliBussDetailVO dtlVO=(AppliBussDetailVO)ite.next();
//				TblDebtBaseInfo baseInfo=debtBaseDAO.get(dtlVO.getDebtId());
//				if(baseInfo!=null){
//					dtlVO.setBillsAmountView(baseInfo.getBillsAmountView());
//					dtlVO.setDeadLine(baseInfo.getDeadLine());
//					dtlVO.setConfirmDate(baseInfo.getConfirmDate());
//				}
//				list.add(dtlVO);
//			}
//			pageQueryResult.setQueryResult(list);
//		}
//		return pageQueryResult;
//	}
//	public PageQueryResult getFinanceApplyListForReg(DebtLnciQryVO debtLnciQryVO) throws ScubeBizException {
//		DebtCURDServiceDAO dao = SCFDAOUtils.getDebtCURDServiceDAO();
//		debtLnciQryVO.setSupplyChainPdId_Q(ScfBasConstant.PRODUCT_TYPE_GNFAC);
//		PageQueryResult pageQueryResult = dao.getFinanceApplyList(debtLnciQryVO);
//		Iterator iter = pageQueryResult.getQueryResult().iterator();
//		List list = new ArrayList();
//		DebtLnciBaseInfoVO vo = null;
//		TblContBaseInfo tblContBaseInfo = null;
//		TblLnciBaseInfo tblLnciBaseInfo = null;
//		BigDecimal contOpentAmt = null;
//		AmountService amountService = AmountService.getInstance();
//
//		while(iter.hasNext()){
//			Object[] obj = (Object[]) iter.next();
//			vo = new DebtLnciBaseInfoVO();
//			tblContBaseInfo = (TblContBaseInfo)obj[0];
//			tblLnciBaseInfo = (TblLnciBaseInfo)obj[1];
///*			if (tblContBaseInfo != null){
//				CommonFunction.copyProperties(vo,tblContBaseInfo);
//			}*/
//			CommonFunction.copyProperties(vo,tblContBaseInfo);
//			//CommonFunction.copyProperties(vo,tblLnciBaseInfo);
//			//tblLnciBaseInfo包含appno 不予拷贝
//			vo.setCname((String)obj[2]);
//			if (tblContBaseInfo == null){
//				vo.setMastContno("");
//				vo.setBusinessNo("");
//			}
//			if (tblContBaseInfo != null){
//				vo.setBusinessNo(tblContBaseInfo.getBusinessNo());//业务合同号
//				vo.setLoanWay(tblContBaseInfo.getLoanWay());//出账方式
//				vo.setStartDate(tblContBaseInfo.getStartDate());//合同生效日期
//				vo.setEndDate(tblContBaseInfo.getEndDate());//合同到期日期
//				vo.setCurcd(tblContBaseInfo.getCurcd());//币别
//				vo.setSupplyChainPdId(tblContBaseInfo.getSupplyChainPdId());//业务品种
//			}
//			if(tblLnciBaseInfo != null){
//				vo.setDebetId(tblLnciBaseInfo.getDebetId());//借据号
//				vo.setLnciRiskAmt(calcLnciRiskAvailableAmt(tblLnciBaseInfo.getDebetId()));//借据敞口余额
//				vo.setFinacingStartDate(tblLnciBaseInfo.getStartDate());//发放日
//				vo.setFinacingEndDate(tblLnciBaseInfo.getEndDate());//到期日
//				vo.setLnciAmt(tblLnciBaseInfo.getLnciAmt());//借据金额
//				vo.setMastContcode(tblLnciBaseInfo.getMastContcode());//信贷合同号
//				vo.setLnciType(tblLnciBaseInfo.getLnciType());//借据类型
//			}
//			list.add(vo);
//		}
//		pageQueryResult.setQueryResult(list);
//		return pageQueryResult;
//	}
	/**
	 *
	 * @param debtLnciQryVO
	 * @return
	 * @throws ScubeBizException
	 */
//	public PageQueryResult getPoolFinanceApplyListForReg(DebtLnciQryVO debtLnciQryVO) throws ScubeBizException {
//		DebtCURDServiceDAO dao = SCFDAOUtils.getDebtCURDServiceDAO();
//		debtLnciQryVO.setSupplyChainPdId_Q(ScfBasConstant.PRODUCT_TYPE_DEBT_POOL);
//		PageQueryResult pageQueryResult = dao.getPoolFinanceApplyList(debtLnciQryVO);
//		Iterator iter = pageQueryResult.getQueryResult().iterator();
//		List list = new ArrayList();
//		DebtBussInfoVO vo = null;
//		TblContBaseInfo tblContBaseInfo = null;
//		TblContDebtInfo tblContDebtInfo = null;
//		BigDecimal contOpentAmt = null;
//		AmountService amountService = AmountService.getInstance();
//
//		while(iter.hasNext()){
//			Object[] obj = (Object[]) iter.next();
//			vo = new DebtBussInfoVO();
//			tblContBaseInfo = (TblContBaseInfo)obj[0];
//			tblContDebtInfo = (TblContDebtInfo)obj[1];
///*			if (tblContBaseInfo != null){
//				CommonFunction.copyProperties(vo,tblContBaseInfo);
//			}*/
//			CommonFunction.copyProperties(vo,tblContBaseInfo);
//			CommonFunction.copyProperties(vo,tblContDebtInfo);
//			//tblLnciBaseInfo包含appno 不予拷贝
//			vo.setCnameSeller((String)obj[2]);//卖方名称
//			if (tblContBaseInfo == null){
//				vo.setMastContno("");
//				vo.setBusinessNo("");
//			}
//			if (tblContBaseInfo != null){
//				vo.setBusinessNo(tblContBaseInfo.getBusinessNo());//池合同号
//				vo.setLoanWay(tblContBaseInfo.getLoanWay());//出账方式
//				/*vo.setStartDate(tblContBaseInfo.getStartDate());//合同生效日期
//				vo.setEndDate(tblContBaseInfo.getEndDate());//合同到期日期
//*/				vo.setCurcd(tblContBaseInfo.getCurcd());//币别
//				vo.setSupplyChainPdId(tblContBaseInfo.getSupplyChainPdId());//业务品种
//			}
//			if(tblContDebtInfo != null){
//				vo.setContAmount(tblContDebtInfo.getContAmount());//合同金额
//				vo.setStartDate(tblContDebtInfo.getStartDate());//合同生效日期
//				vo.setEndDate(tblContDebtInfo.getEndDate());//合同到期日期
//				vo.setLoanPercent(tblContDebtInfo.getLoanPercent());//融资比例
//			}
//			list.add(vo);
//		}
//		pageQueryResult.setQueryResult(list);
//		return pageQueryResult;
//	}

	/**
	 *
	 * @Description: 买方付款发票列表查询
	 * @author mengjiajia
	 * @Created 2012-7-26下午03:22:27
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page invoiceBuyerPayList(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {
		Page pageQueryResult = new Page();
		pageQueryResult = rbcpdebtbaseinfoservice.getInvoiceSelectedQuery(debtCommonQryVO);
		return pageQueryResult;
	}
}
