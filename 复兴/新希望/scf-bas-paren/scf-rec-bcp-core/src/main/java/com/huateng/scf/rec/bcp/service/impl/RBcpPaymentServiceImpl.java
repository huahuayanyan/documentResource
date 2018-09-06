package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.data.dto.BdDataDictDto;
import com.huateng.data.dto.DataItem;
import com.huateng.data.service.BdDataDictService;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import  com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.RBcpAppliRepaymentDAO;
import com.huateng.scf.rec.bcp.dao.ext.ExtBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.ext.ExtIRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample.Criteria;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.PayMentLanInfo;
import com.huateng.scf.rec.bcp.model.PaymentBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.service.IRBcpPaymentService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpPaymentServiceImpl")
public class RBcpPaymentServiceImpl implements IRBcpPaymentService,DealEndFlowService {

	@Resource(name = "bdDataDictService")
	BdDataDictService bdDataDictService;

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService iBCntDebtInfoService;
	
	@Resource(name = "RBcpAppliBussInfoServiceImpl")
	RBcpAppliBussInfoServiceImpl  rBcpAppliBussInfoServiceImpl;
	
	@Resource(name = "ExtIRBcpDebtBaseInfoDAO")
	ExtIRBcpDebtBaseInfoDAO extIRBcpDebtBaseInfoDAO;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Resource(name = "bPbcAppliBaseInfoService")	
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;
	
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
	
	
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;
	
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService  ibCrmBaseInfoService;
	
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;
	
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService bLanLnciBaseService;
	
	@Resource(name = "ExtBcpAppliBussDtlDAO")
	ExtBcpAppliBussDtlDAO  extBcpAppliBussDtlDAO;
	
	@Resource(name = "RBcpAppliRepaymentDAO")
	RBcpAppliRepaymentDAO  rBcpAppliRepaymentDAO;
	
	
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;
	
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService  irBcpDebtBaseInfoService;
	
	
	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO iRBcpDebtBussDtlDAO;
	
	@Resource(name = "RBcpAppliRepaymentServiceImpl")
	IRBcpAppliRepaymentService rbcpapplirepaymentservice;
	
	@Resource(name="RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;
	
	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rbcpdebtpoolservice;
	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;
	@Resource(name =IBMrnAppliAcctInfoService.BEAN_ID) //保证金及现金等价物业务申请
	IBMrnAppliAcctInfoService bMrnAppliAcctInfoService;
	
	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO bmrnappliacctinfodao;
	
	@Resource(name = "BPrdWkflowCopServiceImpl")
	IBPrdWkflowCopService bPrdWkflowCopService;
	
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO bcntdebtinfodao;
	
	@Resource(name = "NRBcpDebtBussInfoServiceImpl")
	INRBcpDebtBussInfoService nrbcpdebtbussinfoservice;
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List getLoanWayList(String debtContno, String dictCode) {
		// TODO Auto-generated method stub

		List<BdDataDictDto> bdDataDictDtoList = bdDataDictService.getConfigDictData(dictCode);
		boolean flag = false;
		List<DataItem> dataItems = null;
		List<DataItem> ndataItems = new ArrayList<DataItem>();
		for (BdDataDictDto bdDataDictDto : bdDataDictDtoList) {

			if (bdDataDictDto.getDictCode().equals(dictCode)) {
				dataItems = bdDataDictDto.getDataItems();
				break;
			}
		}
		if (dataItems != null) {
			BCntDebtInfo bCntDebtInfo = iBCntDebtInfoService.findBCntDebtInfoByKey(debtContno);
			String loanWay = bCntDebtInfo.getLoanWay();
			if (StringUtils.isNotBlank(loanWay)) {
				String[] loanWayarray = loanWay.split(",");
				for (int i = 0; i <loanWayarray.length; i++) {
					for (DataItem dataItem : dataItems) {
						if (dataItem.getDataVal().equals(loanWayarray[i])) {

							ndataItems.add(dataItem);
							break;

						}
					}
				}
			}

		}

		return ndataItems;
	}
	
	
	
	
	@Override
	public	PaymentBussInfo  getInvoicePaymentInfo(RBcpAppliBussInfo rBcpAppliBussInfo){
		
//		String mastContno_Q = rBcpAppliBussInfo.getMastContno(); // 内部合同号
//		String custcdBuyer_Q = rBcpAppliBussInfo.getCustcdBuyer();  // 买方客户号
		String appno =rBcpAppliBussInfo.getAppno();
		PaymentBussInfo debtVO = new PaymentBussInfo();
		
		RBcpAppliBussInfo applyVO	=rBcpAppliBussInfoServiceImpl.findByAppno(appno);
		try {
			BeanUtils.copyProperties(applyVO, debtVO);
		} catch (BeansException e) {
			log.error("转换异常", e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		debtVO.setProductId(applyVO.getBussType());
		debtVO.setRepayPurpose(applyVO.getReason());//回款用途
		//尾款金额 = 本次收款金额 – 偿还融资金额
		if(applyVO.getReturnAmount()!=null&&applyVO.getTotalOverAmount()!=null){
		  debtVO.setTotalRepayAmount(applyVO.getReturnAmount().subtract(applyVO.getTotalOverAmount()));
		}
		BCntDebtInfo contDebtInfo = iBCntDebtInfoService.queryContInfoByMastContno(applyVO.getMastContno());
		debtVO.setStartDate(contDebtInfo.getStartDate());
		debtVO.setEndDate(contDebtInfo.getEndDate());
		debtVO.setCurcd(contDebtInfo.getCurcd());
		debtVO.setContAmount(contDebtInfo.getContAmount());
		debtVO.setBailAccount(contDebtInfo.getBailAcctNo());
		BCrmBaseInfo sallerbCrmBaseInfovo=new  BCrmBaseInfo();
		sallerbCrmBaseInfovo.setCustcd(debtVO.getCustcdSaller());
		BCrmBaseInfo saller=ibCrmBaseInfoService.findBCrmBaseInfoByKey(sallerbCrmBaseInfovo);
		debtVO.setCnameSeller(saller.getCname());		
		BCrmBaseInfo buyervo=new  BCrmBaseInfo();
		buyervo.setCustcd(debtVO.getCustcdBuyer());
		BCrmBaseInfo buyer=ibCrmBaseInfoService.findBCrmBaseInfoByKey(buyervo);
 		debtVO.setCnameBuyer(buyer.getCname());

		BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(contDebtInfo.getSupplyChainPdId());
		debtVO.setBussTypeName(bPrdInfo.getProductName());	
		debtVO.setRepayPurpose(applyVO.getReason());
		//第一次新增初始化
		if(debtVO.getAssignRule()==null){
			//尾款规则
			if(StringUtils.isNotBlank(contDebtInfo.getDueBalanceRule())&&RBcpDebtConstant.DUE_BALANCE_RULE_TO_ACCOUNT.equals(contDebtInfo.getDueBalanceRule())){		
				debtVO.setToSallerFlag("1");

			}
			if(StringUtils.isNotBlank(contDebtInfo.getPaymentVerifyRule())){//回款核销规则
				if(RBcpDebtConstant.PAYMENT_VERIFY_RULE_DUE_FIRST.equals(contDebtInfo.getPaymentVerifyRule())){
					debtVO.setAssignRule(contDebtInfo.getPaymentVerifyRule());
				}
				if(RBcpDebtConstant.PAYMENT_VERIFY_RULE_AVERAGE.equals(contDebtInfo.getPaymentVerifyRule())){
					debtVO.setAssignRule(contDebtInfo.getPaymentVerifyRule());
				}
			}	
			debtVO.setTobailAmount(new BigDecimal("0"));
			debtVO.setReturnCapitalAmount(new BigDecimal("0"));
			debtVO.setReturnInterestAmount(new BigDecimal("0"));
			debtVO.setBailAccount(contDebtInfo.getBailAcctNo());
			String  todayDate=ScfDateUtil.formatDate(new Date());
			debtVO.setReturnDate(todayDate);
			//银承
		   if("02".equals(debtVO.getLoanWay())){   
			   debtVO.setRepayPurpose("01");
		   }else{   
			   debtVO.setRepayPurpose("02");
		   }
			
		   debtVO.setReturnAccount(contDebtInfo.getReturnAccount());	
		   debtVO.setAccountNo(contDebtInfo.getAccountNo());
		   debtVO.setTobailAmount(new BigDecimal("0"));
		}
		//应收账款池融资业务 add by huangshuidan 20170120
		RBcpDebtPool rBcpDebtPool=rbcpdebtpoolservice.queryInPoolInfoByMastContno(applyVO.getMastContno());
		if(null!=rBcpDebtPool){
			debtVO.setTotalBillsAmount(rBcpDebtPool.getTotalDebtRemainAmount());
		}
		debtVO.setPoolRiskAmt(amountService.calculatePoolRiskAvailableAmtByBusinessNo(applyVO.getMastContno()));//池敞口余额
		
		return debtVO;

	}
	
	
	@Override
	public Page findCancelRBcpDebtBaseInfoPageByPage(int pageNo, int pageSize, Map rBcpDebtBaseInfo, List list) {
		Page p = new Page(pageSize, pageNo, 0);
		List<String> billsNoList = new ArrayList<String>();
		if(null!=list && list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				Map<String, String> map = (Map<String, String>) list.get(i);
				String billNo = map.get("billsNo").toString();
				billsNoList.add(billNo);
			}
		}
//		if(billsNoList.size()>0)
//		{
//			rBcpDebtBaseInfo.put("billsNoList", billsNoList);
//		}		
		try {
			extIRBcpDebtBaseInfoDAO.findCancelRBcpDebtBaseInfoByPage(rBcpDebtBaseInfo, p);
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			log.error("条件分页查询条件分页查询应收账款信息失败！"+e);
			throw new ScubeBizException(ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009), RBcpErrorConstant.SCF_REC_BCP_10009);
		}
		List<RBcpDebtBaseInfo> listdal = p.getRecords();
		int total = p.getTotalRecord();
		List<RBcpDebtBaseInfo> result = listdal;
		if(null!=listdal && listdal.size()>0)
		{
			for(int i=0;i<listdal.size();i++)
			{
				RBcpDebtBaseInfo baseInfo = listdal.get(i);
				String billsNo = baseInfo.getBillsNo();
				for(String str:billsNoList)
				{
					if(str.equals(billsNo)||str==billsNo)
					{
						result.remove(baseInfo);
						total--;
					}
				}
			}
		}
		p.setRecords(result);
		p.setTotalRecord(total);
		return p;
	}




	@Override
	@Transactional
	public String addPaymentApply(RBcpAppliBussInfo rBcpAppliBussInfo) {
		// TODO Auto-generated method stub
		String businessnoType = "";
		String workApplyType = "";
		if(ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(rBcpAppliBussInfo.getFactType())){//应收账款
			businessnoType = WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY;
			workApplyType = WorkflowConstant.PROCNAME_CASH_PAYMENT_APPLY;
		}else if(ScfBasConstant.T_FINANCING_TYPE_POOL.equals(rBcpAppliBussInfo.getFactType())){//应收账款池
			businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_PAYMENT_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_PAYMENT_APPLY;
		}
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(workApplyType);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		String  appno=ibSysSerialNoService.genSerialNo("YS_HK_NO");
		BPbcAppliBaseInfo bPbcAppliBaseInfo=new  BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setProcessTemplateName(processName);
		bPbcAppliBaseInfo.setCustcd(rBcpAppliBussInfo.getCustcdSaller());
		bPbcAppliBaseInfo.setAppliType(businessnoType);
		bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		bPbcAppliBaseInfo.setSupplyChainPdId(rBcpAppliBussInfo.getBussType());//业务品种
		bPbcAppliBaseInfo.setAppno(appno);
		bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
	    try {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo record=new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();	
				record.setCustcdBuyer(rBcpAppliBussInfo.getCustcdBuyer());
				record.setCustcdSaller(rBcpAppliBussInfo.getCustcdSaller());
				record.setLoanWay(rBcpAppliBussInfo.getLoanWay());
				record.setMastContno(rBcpAppliBussInfo.getMastContno());
				record.setAppno(appno);// 申请号
				record.setToSallerFlag("1");
				record.setInsertDate(insertDate);// 登记时间
				record.setCrtTime(new Date());// 创建时间
				record.setLastUptTime(new Date());// 最后更新时间
				record.setId(UUIDGeneratorUtil.generate());// id
				record.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);
				record.setTlrcd(tlrcd);// 创建人，操作员
				record.setBrcode(brcode);// 设置经办机构信息
				record.setBussType(rBcpAppliBussInfo.getBussType());//业务品种
				rBcpAppliBussInfoDAO.insert(record);
				return appno;
	    } catch (Exception e) {
			//e.printStackTrace();
			log.error("业务申请基本信息插入异常！"+e);
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),BPbcErrorConstant.SCF_BAS_PBC_10001);
		}
	     
	}

	@Override
	@Transactional
	public void addRBcpAppliBussDtl(String appno,RBcpAppliBussDtl rBcpAppliBussDtl) {
		rBcpAppliBussDtl.setDebtId(rBcpAppliBussDtl.getId());
		rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
		rBcpAppliBussDtl.setAppno(appno);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期

		rBcpAppliBussDtl.setInsertDate(insertDate);
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl   daoRBcpAppliBussDt=new  com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
		try {
			BeanUtils.copyProperties(rBcpAppliBussDtl, daoRBcpAppliBussDt);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}
	    try {
			daoRBcpAppliBussDt.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);
			daoRBcpAppliBussDt.setPayAmount(new BigDecimal(0));
		    rBcpAppliBussDtlDAO.insert(daoRBcpAppliBussDt);
	    } catch (Exception e) {
	 			//e.printStackTrace();
	 			log.error("业务申请基本信息插入异常！"+e);
	 			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),BPbcErrorConstant.SCF_BAS_PBC_10001);
	 		}
	}
	
	
	@Override
	@Transactional
	public void updateRBcpAppliBussDtl(RBcpAppliBussDtl rBcpAppliBussDtl) {
		
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl   daoRBcpAppliBussDt=new  com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
		daoRBcpAppliBussDt.setId(rBcpAppliBussDtl.getId());
		daoRBcpAppliBussDt.setRemoveAmount(rBcpAppliBussDtl.getRemoveAmount());
		daoRBcpAppliBussDt.setPayAmount(rBcpAppliBussDtl.getPayAmount());
	    try {
	    	    BigDecimal  totalpayA=BigDecimal.ZERO;  
			    rBcpAppliBussDtlDAO.updateByPrimaryKeySelective(daoRBcpAppliBussDt);
				RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
				rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
				Criteria c=rBcpAppliBussDtlExample.createCriteria();
			    c.andAppnoEqualTo(rBcpAppliBussDtl.getAppno());
			    List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl>   dtlList=rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
			    for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rdtl:dtlList){
			    	BigDecimal   payA	=(rdtl.getPayAmount()==null?BigDecimal.ZERO:rdtl.getPayAmount());
			    	totalpayA=totalpayA.add(payA);
			    }
			    
			    
			    
			    String  appno=  rBcpAppliBussDtl.getAppno();
			    PayMentLanInfo payMentLanInfo=new  PayMentLanInfo();
			    payMentLanInfo.setAppno(appno);
			    payMentLanInfo.setDebetId(rBcpAppliBussDtl.getDebetNo());
			    payMentLanInfo.setRepayAmount(totalpayA);
			    updatePayMentLanInfo(appno, payMentLanInfo);
	    } catch (Exception e) {
	 			//e.printStackTrace();
	 			log.error("更新异常！"+e);
	 			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),BPbcErrorConstant.SCF_BAS_PBC_10001);
	 		}
	}
	
	
	
	@Override
	@Transactional
	public void deleteRBcpAppliBussDtl(RBcpAppliBussDtl rBcpAppliBussDtl) {
	
	    try {
		    rBcpAppliBussDtlDAO.deleteByPrimaryKey(rBcpAppliBussDtl.getId());
		    
			   RBcpAppliRepaymentExample  example=new  RBcpAppliRepaymentExample();
			   com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria  c=    example.createCriteria();
			   if(StringUtil.isStrNotEmpty(rBcpAppliBussDtl.getAppno())){
				   c.andAppnoEqualTo(rBcpAppliBussDtl.getAppno());
			   }
			   if(StringUtil.isStrNotEmpty(rBcpAppliBussDtl.getDebetNo())){
				   c.andDebetIdEqualTo(rBcpAppliBussDtl.getDebetNo());
			   }
		       rBcpAppliRepaymentDAO.deleteByExample(example);
			   countTotalOverAmount (rBcpAppliBussDtl.getAppno());
	    } catch (Exception e) {
	 			//e.printStackTrace();
	 			log.error("删除异常！"+e);
	 			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),BPbcErrorConstant.SCF_BAS_PBC_10001);
	 		}
	}
	
	
	
	
	@Override
	public Page findLoanByPage(int pageNo, int pageSize, String  appno) {
	    Page p = new Page(pageSize, pageNo, 0);
	    p.setRecords(new ArrayList());
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		if (appno != null && !"".equals(appno)) {
			   rBcpAppliBussDtlExample.setDistinct(true);
			   Criteria	cri = rBcpAppliBussDtlExample.createCriteria();
			   cri .andAppnoEqualTo(appno);
			    List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> appliBussDtlList =extBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		        List  debtNos=new ArrayList();
			    for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl:appliBussDtlList){
		        	  if(rBcpAppliBussDtl.getDebetNo()!=null){
			    	     debtNos.add(rBcpAppliBussDtl.getDebetNo());
		        	  }
		        } 
		      if(debtNos!=null&&debtNos.size()>0){
			    p=bLanLnciBaseService.findBLanLnciBasePageByDebtId(pageNo, pageSize, debtNos);
		      }
              List  payMentLanInfos=new ArrayList();
		      List<BLanLnciBase> records=   p.getRecords();
		  	try {
				      for(BLanLnciBase lanLnciBase:records){
				    	  
				    	    PayMentLanInfo   payMentLanInfo=  new     PayMentLanInfo();
				    	  
				  	
							BeanUtils.copyProperties(lanLnciBase, payMentLanInfo);
							if(payMentLanInfo.getLnciType()!=null){
											if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(payMentLanInfo.getLnciType())){ // 出账方式
												payMentLanInfo.setRepayIntamt(new BigDecimal("0"));
												payMentLanInfo.setRepayBalamt(new BigDecimal("0"));
											}else if(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(payMentLanInfo.getLnciType())){
												if(payMentLanInfo.getBailAmount()==null){
													payMentLanInfo.setBailAmount(new BigDecimal("0"));
												}
												if(payMentLanInfo.getAddBailAmount()==null){
													payMentLanInfo.setBailAmount(payMentLanInfo.getBailAmount().add(payMentLanInfo.getAddBailAmount()));
													payMentLanInfo.setAddBailAmount(new BigDecimal("0"));
												}
												payMentLanInfo.setRepayIntamt(null);
												payMentLanInfo.setRepayBalamt(null);
											}
								    	  if(payMentLanInfo.getLnciBal()==null){
								    		  payMentLanInfo.setLnciBal(new BigDecimal("0"));
								    	  }
								    	  if(payMentLanInfo.getBailAmount()==null){
								    		  payMentLanInfo.setBailAmount(new BigDecimal("0"));
								    	  }	
								    	  if(payMentLanInfo.getAddBailAmount()==null){
								    		  payMentLanInfo.setAddBailAmount(new BigDecimal("0"));
								    	  }	
								    	  if(payMentLanInfo.getInitCashEqtAmt()==null){
								    		  payMentLanInfo.setInitCashEqtAmt(new BigDecimal("0"));
								    	  }		
								    	  if(payMentLanInfo.getAddCashEqtAmt()==null){
								    		  payMentLanInfo.setAddCashEqtAmt(new BigDecimal("0"));
								    	  }		
											payMentLanInfo.setAvaliableRiskAmt(payMentLanInfo.getLnciBal()
													.subtract(payMentLanInfo.getBailAmount()).subtract(payMentLanInfo.getAddBailAmount())
													.subtract(payMentLanInfo.getInitCashEqtAmt().subtract(payMentLanInfo.getAddCashEqtAmt())));//敞口余额
											payMentLanInfo.setPayAmount(new BigDecimal("0"));
											payMentLanInfo.setRepayAmount(new BigDecimal("0"));
											payMentLanInfo.setAmountOver(new BigDecimal("0"));
											BigDecimal receInt=payMentLanInfo.getReceivableInt()!=null?payMentLanInfo.getReceivableInt():new BigDecimal(0);
											BigDecimal recePunInt=payMentLanInfo.getReceivablePunishInt()!=null?payMentLanInfo.getReceivablePunishInt():new BigDecimal(0);
											payMentLanInfo.setInTableInt(receInt.add(recePunInt));//表内欠息 = 应收欠息 + 应收罚息
									
							}
							
							
							  RBcpAppliRepaymentExample  example=new  RBcpAppliRepaymentExample();
							  com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria  c=    example.createCriteria();
							   c.andAppnoEqualTo(appno);
							   c.andDebetIdEqualTo(payMentLanInfo.getDebetId());
							  List<RBcpAppliRepayment>  rbcpAppliRepaymentList=	rBcpAppliRepaymentDAO.selectByExample(example);
							  if(rbcpAppliRepaymentList!=null&&rbcpAppliRepaymentList.size()>0){
									  payMentLanInfo.setRepayAmount(rbcpAppliRepaymentList.get(0).getRepayAmount());// 还款金额
									  payMentLanInfo.setPayAmount(rbcpAppliRepaymentList.get(0).getPayAmount());//入账金额
									  payMentLanInfo.setAmountOver( rbcpAppliRepaymentList.get(0).getAmountOver());//尾款金额
									  payMentLanInfo.setRepayIntamt(rbcpAppliRepaymentList.get(0).getRepayIntamt());//实际还息金额
									  payMentLanInfo.setRepayBalamt(rbcpAppliRepaymentList.get(0).getRepayBalamt());//实际还本金额
									  payMentLanInfo.setBailAccount(rbcpAppliRepaymentList.get(0).getAccountNo());//保证金账号  
							  }
				    	  
				    	  
				    	      payMentLanInfos.add(payMentLanInfo);
				    	  
				    	  
				      }
		      
			} catch (BeansException e) {
				log.warn("转换异常", e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
			}
			
		      p.setRecords(payMentLanInfos);
		      
		}

		return p;
	}

	/**
	 * 池现金回款关联的融资信息
	 */
	@Override
	public Page findPoolLoanByPage(int pageNo, int pageSize, String  appno) {
	    Page p = new Page(pageSize, pageNo, 0);
	    p.setRecords(new ArrayList());
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		if (appno != null && !"".equals(appno)) {
			List<com.huateng.scf.rec.bcp.model.RBcpAppliRepayment> loanList = rbcpapplirepaymentservice.queryTblAppliRepaymentInfoByAppno(appno); // 还款信息--流贷还本息信息
			List<BMrnAppliAcctInfo> billsList = bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appno); // 还款信息--银承入保证金信息
		        List  debtNos=new ArrayList();
			    for(com.huateng.scf.rec.bcp.model.RBcpAppliRepayment rBcpAppliRepayment:loanList){
		        	  if(rBcpAppliRepayment.getDebetId()!=null){
		        		  debtNos.add(rBcpAppliRepayment.getDebetId());
		        	  }
		        } 
			    for(BMrnAppliAcctInfo bMrnAppliAcctInfo:billsList){
		        	  if(bMrnAppliAcctInfo.getDebetNo()!=null){
		        		  com.huateng.scf.bas.lan.model.BLanLnciBase base =bLanLnciBaseService.findBLanLnciBaseByKey(bMrnAppliAcctInfo.getDebetNo());
		        		  if(base!=null){
		        			  debtNos.add(base.getDebetId());
		        		  }
		        	  }
		        } 
		      if(debtNos!=null&&debtNos.size()>0){
			    p=bLanLnciBaseService.findBLanLnciBasePageByDebtId(pageNo, pageSize, debtNos);
		      }
              List  payMentLanInfos=new ArrayList();
		      List<BLanLnciBase> records=   p.getRecords();
		  	try {
				      for(BLanLnciBase lanLnciBase:records){
				    	  
				    	    PayMentLanInfo   payMentLanInfo=  new     PayMentLanInfo();
				    	  
				  	
							BeanUtils.copyProperties(lanLnciBase, payMentLanInfo);
							if(payMentLanInfo.getLnciType()!=null){
											if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(payMentLanInfo.getLnciType())){ // 出账方式
												payMentLanInfo.setRepayIntamt(new BigDecimal("0"));
												payMentLanInfo.setRepayBalamt(new BigDecimal("0"));
											}else if(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(payMentLanInfo.getLnciType())){
												if(payMentLanInfo.getBailAmount()==null){
													payMentLanInfo.setBailAmount(new BigDecimal("0"));
												}
												if(payMentLanInfo.getAddBailAmount()==null){
													payMentLanInfo.setBailAmount(payMentLanInfo.getBailAmount().add(payMentLanInfo.getAddBailAmount()));
													payMentLanInfo.setAddBailAmount(new BigDecimal("0"));
												}
												payMentLanInfo.setRepayIntamt(null);
												payMentLanInfo.setRepayBalamt(null);
											}
								    	  if(payMentLanInfo.getLnciBal()==null){
								    		  payMentLanInfo.setLnciBal(new BigDecimal("0"));
								    	  }
								    	  if(payMentLanInfo.getBailAmount()==null){
								    		  payMentLanInfo.setBailAmount(new BigDecimal("0"));
								    	  }	
								    	  if(payMentLanInfo.getAddBailAmount()==null){
								    		  payMentLanInfo.setAddBailAmount(new BigDecimal("0"));
								    	  }	
								    	  if(payMentLanInfo.getInitCashEqtAmt()==null){
								    		  payMentLanInfo.setInitCashEqtAmt(new BigDecimal("0"));
								    	  }		
								    	  if(payMentLanInfo.getAddCashEqtAmt()==null){
								    		  payMentLanInfo.setAddCashEqtAmt(new BigDecimal("0"));
								    	  }		
											payMentLanInfo.setAvaliableRiskAmt(payMentLanInfo.getLnciBal()
													.subtract(payMentLanInfo.getBailAmount()).subtract(payMentLanInfo.getAddBailAmount())
													.subtract(payMentLanInfo.getInitCashEqtAmt().subtract(payMentLanInfo.getAddCashEqtAmt())));//敞口余额
											payMentLanInfo.setPayAmount(new BigDecimal("0"));
											payMentLanInfo.setRepayAmount(new BigDecimal("0"));
											payMentLanInfo.setAmountOver(new BigDecimal("0"));
											BigDecimal receInt=payMentLanInfo.getReceivableInt()!=null?payMentLanInfo.getReceivableInt():new BigDecimal(0);
											BigDecimal recePunInt=payMentLanInfo.getReceivablePunishInt()!=null?payMentLanInfo.getReceivablePunishInt():new BigDecimal(0);
											payMentLanInfo.setInTableInt(receInt.add(recePunInt));//表内欠息 = 应收欠息 + 应收罚息
									
							}
							
							
							  RBcpAppliRepaymentExample  example=new  RBcpAppliRepaymentExample();
							  com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria  c=    example.createCriteria();
							   c.andAppnoEqualTo(appno);
							   c.andDebetIdEqualTo(payMentLanInfo.getDebetId());
							  List<RBcpAppliRepayment>  rbcpAppliRepaymentList=	rBcpAppliRepaymentDAO.selectByExample(example);
							  if(rbcpAppliRepaymentList!=null&&rbcpAppliRepaymentList.size()>0){
									  payMentLanInfo.setRepayAmount(rbcpAppliRepaymentList.get(0).getRepayAmount());// 还款金额
									  payMentLanInfo.setPayAmount(rbcpAppliRepaymentList.get(0).getPayAmount());//入账金额
									  payMentLanInfo.setAmountOver( rbcpAppliRepaymentList.get(0).getAmountOver());//尾款金额
									  payMentLanInfo.setRepayIntamt(rbcpAppliRepaymentList.get(0).getRepayIntamt());//实际还息金额
									  payMentLanInfo.setRepayBalamt(rbcpAppliRepaymentList.get(0).getRepayBalamt());//实际还本金额
									  payMentLanInfo.setBailAccount(rbcpAppliRepaymentList.get(0).getAccountNo());//保证金账号  
							  }
							  
							  BMrnAppliAcctInfoExample Mrnexample =new BMrnAppliAcctInfoExample();
							  com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample.Criteria  Mrnc=   Mrnexample.createCriteria();
							  Mrnc.andAppnoEqualTo(appno);
							  Mrnc.andDebetNoEqualTo(payMentLanInfo.getDebetNo());
							  List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo>  Mrnlist =  bmrnappliacctinfodao.selectByExample(Mrnexample);
							  if(Mrnlist!=null&&Mrnlist.size()>0){
								  com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo  payBillsInfo =Mrnlist.get(0);
								  if(payBillsInfo != null){
									  payMentLanInfo.setRepayAmount(payBillsInfo.getAmount());// 还款金额
									  payMentLanInfo.setAddBailAmount(payBillsInfo.getAmount());// 还款金额
									  payMentLanInfo.setPayAmount(payBillsInfo.getPayAmount());//入账金额
									  payMentLanInfo.setAmountOver(payBillsInfo.getPayAmount().subtract(payBillsInfo.getAmount()));//尾款金额
									  payMentLanInfo.setBailAccount(payBillsInfo.getBailAccountno());//保证金账户
									}
					    	  
							  }
								
				    	      payMentLanInfos.add(payMentLanInfo);
				    	  
				    	  
				      }
		      
			} catch (BeansException e) {
				log.warn("转换异常", e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
			}
			
		      p.setRecords(payMentLanInfos);
		      p.setTotalPage(payMentLanInfos.size());
		      
		}

		return p;
	}

	   @Override
	   @Transactional
	   public void updatePayMentLanInfo(String  appno,PayMentLanInfo payMentLanInfo) throws ScubeBizException{
			   RBcpAppliRepaymentExample  example=new  RBcpAppliRepaymentExample();
			   com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria  c=    example.createCriteria();
			   if(StringUtil.isStrNotEmpty(appno)){
				   c.andAppnoEqualTo(appno);
			   }
			   if(StringUtil.isStrNotEmpty(payMentLanInfo.getDebetId())){
				   c.andDebetIdEqualTo(payMentLanInfo.getDebetId());
			   }
			   
			   
			   List<RBcpAppliRepayment>  rbcpList =   rBcpAppliRepaymentDAO.selectByExample(example);
			   if(rbcpList==null||rbcpList.size()==0){
					RBcpAppliRepayment  record=new  RBcpAppliRepayment();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
					String insertDate = simpleDateFormat.format(new Date());// 新增插入日期 
					String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
					String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
				    record.setId(UUIDGeneratorUtil.generate());
				    record.setAppno(appno);
				    record.setDebetNo(payMentLanInfo.getDebetNo());//借据表主键--供应链借据号
				    record.setDebetId(payMentLanInfo.getDebetId());//信贷正式借据编号
					record.setTlrcd(tlrcd);
					record.setBrcode(brcode);
					record.setRepayDate(insertDate);
					record.setCurcd(payMentLanInfo.getCurcd());// 币别 默认人民币
					record.setRepayAmount(payMentLanInfo.getRepayAmount());// 还款金额
					record.setPayAmount(payMentLanInfo.getRepayAmount());//入账金额
					record.setAmountOver(payMentLanInfo.getAmountOver());//尾款金额
					record.setRepayIntamt(payMentLanInfo.getRepayIntamt());//实际还息金额
					record.setRepayBalamt(payMentLanInfo.getRepayBalamt());//实际还本金额
					record.setAccountNo(payMentLanInfo.getBailAccount());//保证金账号
				    rBcpAppliRepaymentDAO.insert(record);
			   }else{
				   rbcpList.get(0).setRepayAmount(payMentLanInfo.getRepayAmount());
				   rbcpList.get(0).setAccountNo(payMentLanInfo.getBailAccount());//保证金账号
				   rBcpAppliRepaymentDAO.updateByPrimaryKeySelective(rbcpList.get(0));
			   }
			   countTotalOverAmount (appno);
		}
	   
	   
		@Transactional
	   public void countTotalOverAmount (String appno) {
			RBcpAppliBussInfoExample   example1=new  RBcpAppliBussInfoExample();
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample.Criteria c1=example1.createCriteria();
			c1.andAppnoEqualTo(appno);
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo>  appliBussInfoList=	rBcpAppliBussInfoDAO.selectByExample(example1);
			//尾款金额
		    BigDecimal totalOverAmount=appliBussInfoList.get(0).getTotalOverAmount();
			//本次入账总额 returnAmount
		    BigDecimal returnAmount=appliBussInfoList.get(0).getReturnAmount();
		    if(returnAmount!=null){
		    	  BigDecimal	totalRepayAmount=new  BigDecimal("0");
				  RBcpAppliRepaymentExample  rexample=new  RBcpAppliRepaymentExample();
				  com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria  rc=    rexample.createCriteria();
				  rc.andAppnoEqualTo(appno);
				  List<RBcpAppliRepayment>  rbcpAppliRepaymentList=	rBcpAppliRepaymentDAO.selectByExample(rexample);
				  if(rbcpAppliRepaymentList!=null&&rbcpAppliRepaymentList.size()>0){
					  for(RBcpAppliRepayment rbcpAppliRepayment:rbcpAppliRepaymentList){
						  totalRepayAmount=totalRepayAmount.add(rbcpAppliRepayment.getRepayAmount());
						  
					  }

				  }
		
			     appliBussInfoList.get(0).setTotalOverAmount(returnAmount.subtract(totalRepayAmount));

				 rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(appliBussInfoList.get(0));    
		    }
		   
	   }
	
	
		@Override
		@Transactional
		public void delPaymentApply(String appno) {

		    try {
				bPbcAppliBaseInfoService.deleteBPbcAppliBaseInfo(appno);
				RBcpAppliBussInfoExample   example=new  RBcpAppliBussInfoExample();
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample.Criteria c=example.createCriteria();
				c.andAppnoEqualTo(appno);
				rBcpAppliBussInfoDAO.deleteByExample(example);
				
		    } catch (Exception e) {
				//e.printStackTrace();
				log.error("业务申请基本信息插入异常！"+e);
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),BPbcErrorConstant.SCF_BAS_PBC_10001);
			}
		     
		}
	   
		@Override
		@Transactional  
		public String updatePaymentApply(PaymentBussInfo paymentBussInfo) {
			// TODO Auto-generated method stub
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo daoRBcpAppliBussInfo=new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();	

			try {
				BeanUtils.copyProperties(paymentBussInfo, daoRBcpAppliBussInfo);
			} catch (BeansException e) {
				log.warn("转换异常", e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
			}

		    try {
		    	    daoRBcpAppliBussInfo.setReason(paymentBussInfo.getRepayPurpose());
		    	    daoRBcpAppliBussInfo.setLastUptTime(new Date());// 最后更新时间
					rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(daoRBcpAppliBussInfo);		
					return daoRBcpAppliBussInfo.getAppno();
		    } catch (Exception e) {
				//e.printStackTrace();
				log.error("业务申请基本信息插入异常！"+e);
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001),BPbcErrorConstant.SCF_BAS_PBC_10001);
			}
		     
		}

		
		
		@Override
		@Transactional  
		public void	assignAmount(PaymentBussInfo paymentBussInfo){
			     //回款核销规则
			    String assignRule=paymentBussInfo.getAssignRule();
			    //本次入账总额
			    BigDecimal returnAmount= paymentBussInfo.getReturnAmount();
				if(assignRule!=null&&returnAmount!=null){
					RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
					rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
					Criteria c=rBcpAppliBussDtlExample.createCriteria();
				    c.andAppnoEqualTo(paymentBussInfo.getAppno());
				    List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl>   dtlList=rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
				    //初始化为0
				    
				    for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl  rbcpAppliBussDtl:dtlList){
				    	
				        RBcpAppliBussDtl   newRBcpAppliBussDtl =new  RBcpAppliBussDtl();
						BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);	 
						newRBcpAppliBussDtl.setPayAmount(BigDecimal.ZERO);
						newRBcpAppliBussDtl.setRemoveAmount(BigDecimal.ZERO);
					    updateRBcpAppliBussDtl(newRBcpAppliBussDtl); 

				    }
				    

					//按到期日
					if(RBcpDebtConstant.PAYMENT_VERIFY_RULE_DUE_FIRST.equals(assignRule)){
						
						for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl  rbcpAppliBussDtl:dtlList){
							
							    BigDecimal 	    remainingAmount=   rbcpAppliBussDtl.getRemainingAmount();
							    int comp=remainingAmount.compareTo(returnAmount);
							    if(comp>=0){
								    RBcpAppliBussDtl   newRBcpAppliBussDtl =new  RBcpAppliBussDtl();
									BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);	 
									newRBcpAppliBussDtl.setPayAmount(returnAmount);
									newRBcpAppliBussDtl.setRemoveAmount(returnAmount);
								    updateRBcpAppliBussDtl(newRBcpAppliBussDtl); 
								    break;

							    }else{
							    
							    	
								        RBcpAppliBussDtl   newRBcpAppliBussDtl =new  RBcpAppliBussDtl();
										BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);	 
										newRBcpAppliBussDtl.setPayAmount(remainingAmount);
										newRBcpAppliBussDtl.setRemoveAmount(remainingAmount);
									    updateRBcpAppliBussDtl(newRBcpAppliBussDtl); 
										returnAmount=returnAmount.subtract(remainingAmount);
							    	
							    }

						}

						
						
					}
					//按平均分配
					else if(RBcpDebtConstant.PAYMENT_VERIFY_RULE_AVERAGE.equals(assignRule)){
							  int   num=	dtlList.size();
							  if(num>0){
									for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl  rbcpAppliBussDtl:dtlList){
										    RBcpAppliBussDtl   newRBcpAppliBussDtl =new  RBcpAppliBussDtl();
											BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);	 
											newRBcpAppliBussDtl.setPayAmount(returnAmount.divide(BigDecimal.valueOf(num)));
											newRBcpAppliBussDtl.setRemoveAmount(returnAmount.divide(BigDecimal.valueOf(num)));
										    updateRBcpAppliBussDtl(newRBcpAppliBussDtl); 

								}
							  }
						
					}
					
				}
				
			
		}
		
		
		@Override
		@Transactional
		public void submitFlow(String key) {
			// TODO Auto-generated method stub		
			BPbcAppliBaseInfo bPbcAppliBaseInfo=new  BPbcAppliBaseInfo();
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE); 
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
			bPbcAppliBaseInfo.setAppno(key);
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			
			
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
			Criteria c=rBcpAppliBussDtlExample.createCriteria();
		    c.andAppnoEqualTo(key);
		    List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl>   dtlList=rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		    for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rdtl:dtlList){
		    	irBcpDebtBaseInfoService.lockDebtBaseInfo(rdtl.getDebtId(),key);  
		    }
			
			
			
			
		}




		@Override
		@Transactional
		public void doWorkForPass(String appNo) {
			BPbcAppliBaseInfo bPbcAppliBaseInfo=new  BPbcAppliBaseInfo();
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED); 
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
			bPbcAppliBaseInfo.setAppno(appNo);
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);	
			//增加还款-还贷处理 add by huangshuidan 2017-01-14 begin
			//R_BCP_APPLI_BUSS_INFO[应收账款业务申请流水基本信息表]
			RBcpAppliBussInfo rBcpAppliBussInfo=rBcpAppliBussInfoService.findByAppno(appNo);
			if(null==rBcpAppliBussInfo)
			{
				log.info("RBcpPaymentServiceImpl.doWorkForPass:业务申请信息不存在！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10004),BPbcErrorConstant.SCF_BAS_PBC_10004);
			}
			//1-还贷
			if(null!=rBcpAppliBussInfo.getReason()&&
					RBcpDebtConstant.RETURN_USAGE_REPAY.equals(rBcpAppliBussInfo.getReason())){
				//TODO 发往核心，冻结保证金信息接口还款暂时没有实现，需根据项目实施客户化定制完善
				//....
				//提前还款成功后，更新借据表的贷款余额 begin
				updateBLanLnciBase(appNo);
//				//根据业务申请号查询还款信息
//				List<com.huateng.scf.rec.bcp.model.RBcpAppliRepayment> appliRepaymentList = rbcpapplirepaymentservice
//						.queryTblAppliRepaymentInfoByAppno(appNo); // 还款信息--流贷还本息信息,R_BCP_APPLI_REPAYMENT[还款/回款申请流水信息表]
//					if(null!=appliRepaymentList && appliRepaymentList.size()>0){
//						for (int i = 0; i < appliRepaymentList.size(); i++) {
//							com.huateng.scf.rec.bcp.model.RBcpAppliRepayment appliPayInfo=(com.huateng.scf.rec.bcp.model.RBcpAppliRepayment)appliRepaymentList.get(i);
////							String debetNo = appliPayInfo.getDebetNo();//取出供应链借据号，这个值没有保存使用debetId
//							String debetId=appliPayInfo.getDebetId();//借据号
//							//根据debetNo查询B_LAN_LNCI_BASE[借据基本信息表]
//							com.huateng.scf.bas.lan.model.BLanLnciBase bLanLnciBase=bLanLnciBaseService.findBLanLnciBaseByDebtId(debetId);
//							BigDecimal  lnciBal = bLanLnciBase.getLnciBal()==null?new BigDecimal(0):bLanLnciBase.getLnciBal();
//							bLanLnciBase.setLnciBal(lnciBal.subtract(appliPayInfo.getRepayAmount())); //提前还款成功后，更新借据表
//							bLanLnciBaseService.setLnciIsSettle(bLanLnciBase);//如果敞口为零将借据置为已结清状态
//							bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase);
//						}
//					}
				//提前还款成功后，更新借据表的贷款余额 end
			}
			RBcpDebtBussInfo bussInfo = new RBcpDebtBussInfo();
			BeanUtils.copyProperties(rBcpAppliBussInfo, bussInfo);
			bussInfo.setRepayPurpose(bussInfo.getReason());
			nrbcpdebtbussinfoservice.addRBcpDebtBussInfo(bussInfo);
			//增加还款-还贷处理  add by huangshuidan 2017-01-14 end
			//处理回款应收账款
			BussDtlForPass(appNo);
			
    
		}
		/**
		 * 提前还款成功后，更新借据表的贷款余额 
		 * @param appNo
		 * 		String-业务申请号
		 * @throws ScubeBizException
		 */
		public void updateBLanLnciBase(String appNo) throws ScubeBizException{
			//根据业务申请号查询还款信息
			List<com.huateng.scf.rec.bcp.model.RBcpAppliRepayment> appliRepaymentList = rbcpapplirepaymentservice
					.queryTblAppliRepaymentInfoByAppno(appNo); // 还款信息--流贷还本息信息,R_BCP_APPLI_REPAYMENT[还款/回款申请流水信息表]
				if(null!=appliRepaymentList && appliRepaymentList.size()>0){
					for (int i = 0; i < appliRepaymentList.size(); i++) {
						com.huateng.scf.rec.bcp.model.RBcpAppliRepayment appliPayInfo=(com.huateng.scf.rec.bcp.model.RBcpAppliRepayment)appliRepaymentList.get(i);
						String debetId=appliPayInfo.getDebetId();//借据号
						//根据debetNo查询B_LAN_LNCI_BASE[借据基本信息表]
						com.huateng.scf.bas.lan.model.BLanLnciBase bLanLnciBase=bLanLnciBaseService.findBLanLnciBaseByDebtId(debetId);
						BigDecimal  lnciBal = bLanLnciBase.getLnciBal()==null?new BigDecimal(0):bLanLnciBase.getLnciBal();
						bLanLnciBase.setLnciBal(lnciBal.subtract(appliPayInfo.getRepayAmount())); //提前还款成功后，更新借据表
						bLanLnciBaseService.setLnciIsSettle(bLanLnciBase);//如果敞口为零将借据置为已结清状态
						bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase);
					}
				}
		} 
		
		
		
		




		@Override
		public void doWorkForReject(String appNo) {
			// TODO Auto-generated method stub
			BPbcAppliBaseInfo bPbcAppliBaseInfo=new  BPbcAppliBaseInfo();
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED); 
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
			bPbcAppliBaseInfo.setAppno(appNo);
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);	
			
			//释放锁
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
			Criteria c=rBcpAppliBussDtlExample.createCriteria();
		    c.andAppnoEqualTo(appNo);
		    List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl>   dtlList=rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		    for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rdtl:dtlList){
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtBaseInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
				debtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rdtl.getDebtId());
				debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
				debtBaseInfo.setLockAppno("");
				iRBcpDebtBaseInfoDAO.updateByPrimaryKeySelective(debtBaseInfo);
		    }
		}		
		
		
		@Transactional
		public void BussDtlForPass(String appNo) {
			// TODO Auto-generated method stub
			
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
			Criteria c=rBcpAppliBussDtlExample.createCriteria();
		    c.andAppnoEqualTo(appNo);
		    List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl>   dtlList=rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		    for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rdtl:dtlList){
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtBaseInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
				debtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rdtl.getDebtId());
				BigDecimal payAmount = debtBaseInfo.getPayAmount()==null?new BigDecimal("0"):debtBaseInfo.getPayAmount();
				debtBaseInfo.setPayAmount(payAmount.add(rdtl.getPayAmount()));//累加本次实际回款金额
				BigDecimal remainingAmount = debtBaseInfo.getRemainingAmount()==null?new BigDecimal("0"):debtBaseInfo.getRemainingAmount();//更新前发票余额
				BigDecimal removeAmount = debtBaseInfo.getRemoveAmount()==null?new BigDecimal("0"):debtBaseInfo.getRemoveAmount();

				debtBaseInfo.setRemainingAmount(remainingAmount.subtract(removeAmount));//发票余额

				rdtl.setRemainingAmount(remainingAmount.subtract(removeAmount));//设置核销应收账款余额
				rBcpAppliBussDtlDAO.updateByPrimaryKeySelective(rdtl);
				
				BigDecimal loanPercent = debtBaseInfo.getLoanPercent()==null?new BigDecimal("0"):debtBaseInfo.getLoanPercent();
				debtBaseInfo.setRemainingUseableAmount(debtBaseInfo.getRemainingAmount().multiply(loanPercent).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP));
				
				if(debtBaseInfo.getRemainingAmount().compareTo(new BigDecimal(0.00))==0){//发票余额为0则吧发票状态至为04核销
					debtBaseInfo.setStatus(ScfBasConstant.BILLS_STATUS_PAYOFF);//已核销
				}
				if(rdtl.getLoanRemainingAmount()!=null){
					debtBaseInfo.setLoanRemainingAmount(rdtl.getLoanRemainingAmount());//融资余额
				}
				debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
				debtBaseInfo.setLockAppno("");
				iRBcpDebtBaseInfoDAO.updateByPrimaryKeySelective(debtBaseInfo);
				
				RBcpDebtBussDtl  record=new  RBcpDebtBussDtl();

				try {
					BeanUtils.copyProperties(rdtl, record);
				} catch (BeansException e) {
					log.warn("转换异常", e);
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
				}
					
					record.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);
					record.setId(UUIDGeneratorUtil.generate());
					 iRBcpDebtBussDtlDAO.insert(record);

		    }
		   
		    
		    
		    
		}
		
		
		
		@Transactional
		public void BussDtlForReject(String appNo) {
			// TODO Auto-generated method stub
			
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
			Criteria c=rBcpAppliBussDtlExample.createCriteria();
		    c.andAppnoEqualTo(appNo);
		    List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl>   dtlList=rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		    for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rdtl:dtlList){
		    	    irBcpDebtBaseInfoService.releaseDebtBaseInfo(rdtl.getDebtId()); 
		    }
		    
		    
		    
		}




		@Override
		public void doWorkForBack(String appNo) {
			// TODO Auto-generated method stub
			
		}




		/**
		 * 应收账款池融资 融资列表查询
		 */
		@Override
		public Page findloanAddListByPage(int pageNo, int pageSize, DebtLnciQryVO debtLnciQryVO)throws ScubeBizException {
			String debetNo="";
			if(StringUtil.isStrNotEmpty(debtLnciQryVO.getDebetNo())){
				debetNo =debtLnciQryVO.getDebetNo();
			}
			Page page = new Page(pageSize,pageNo,0);
			page = bLanLnciBaseService.queryLnciInfoByBusinessNo(debtLnciQryVO);
			List list =page.getRecords();
			List resultList=new ArrayList();
			if(list!=null&&list.size()>0){
				Iterator ite= list.iterator();
				while(ite.hasNext()){
					DebtLnciBaseInfoVO lnciVO=new DebtLnciBaseInfoVO();
					BeanUtils.copyProperties(ite.next(),lnciVO);
					if(!StringUtil.isEmpty(debetNo)
							&&debetNo.indexOf(lnciVO.getDebetNo())!=-1){
						lnciVO.setSelect(true);
					}
					String protocolNo = lnciVO.getProtocolNo();
					com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo = bcntdebtinfodao.selectByPrimaryKey(protocolNo);
					if(null!=bCntDebtInfo)
					{
						lnciVO.setBailAccount(bCntDebtInfo.getBailAcctNo());
					}
					BigDecimal lnciBal=lnciVO.getLnciBal()!=null?lnciVO.getLnciBal():new BigDecimal(0);
					BigDecimal initCashEqtAmt=lnciVO.getInitCashEqtAmt()!=null?lnciVO.getInitCashEqtAmt():new BigDecimal(0);
					BigDecimal bailAmount=lnciVO.getBailAmount()!=null?lnciVO.getBailAmount():new BigDecimal(0);
					BigDecimal addBailAmount =lnciVO.getAddBailAmount()!=null?lnciVO.getAddBailAmount():new BigDecimal(0);
					BigDecimal addCashAmount=lnciVO.getAddCashEqtAmt()!=null?lnciVO.getAddCashEqtAmt():new BigDecimal(0);
					lnciVO.setAvaliableRiskAmt(lnciBal.subtract(initCashEqtAmt)
							.subtract(bailAmount).subtract(addCashAmount).subtract(addBailAmount));
					resultList.add(lnciVO);
				}
			}
			page.setRecords(resultList);
			page.setTotal(resultList.size());
			return page;
		}




		/**
		 * 应收账款池融资 融资信息保存
		 */
		@Transactional
		@Override
		public void addLoanInfoDtl(DebtBussInfoVO debtBussInfoVO, List<DebtLnciBaseInfoVO> lnciList) throws ScubeBizException{
			if(StringUtil.isStrNotEmpty(debtBussInfoVO.getRepayPurpose())
					&&!RBcpDebtConstant.RETURN_USAGE_IN_BAILAMOUNT.equals(debtBussInfoVO.getRepayPurpose())){
				
				//清空保证金表对应数据
				bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(debtBussInfoVO.getAppno());
		
				this.saveTblAppliRepaymentInfo(lnciList,debtBussInfoVO);// 保存还贷款、尾款信息
			}
			if(StringUtil.isStrNotEmpty(debtBussInfoVO.getRepayPurpose())
					&&RBcpDebtConstant.RETURN_USAGE_IN_BAILAMOUNT.equals(debtBussInfoVO.getRepayPurpose())){
				
				// 清空还款表对应数据
				rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(debtBussInfoVO.getAppno());
				
				this.saveTblAppliCustAccountInfo(lnciList,debtBussInfoVO);// 保存入保证金还款信息
			}
			
		}
		
		/**
		 * 现金回款 -- 保存还款信息
		 * @param lnciPayList
		 * @param paymentInfo
		 * @throws ScubeBizException
		 */
		@Transactional
		public void saveTblAppliRepaymentInfo(List lnciPayList, DebtBussInfoVO paymentInfo) throws ScubeBizException {
			
			//清空保证金表对应数据
			//bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(paymentInfo.getAppno());
	
			RBcpAppliRepayment record = null;
			String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
			String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
			//保存前先清掉APPNO查询到记录
			rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(paymentInfo.getAppno());
			DebtLnciBaseInfoVO debtVO = null;
			for (int i=0;i < lnciPayList.size();i++) {
				record = new RBcpAppliRepayment();
				debtVO = (DebtLnciBaseInfoVO) lnciPayList.get(i);
				if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(debtVO.getLnciType())){//融资方式是 流动资金贷款
					record.setId(UUIDGeneratorUtil.generate());
					record.setAppno(paymentInfo.getAppno());
					record.setDebetNo(debtVO.getDebetNo());//借据表主键
					record.setDebetId(debtVO.getDebetId());
					if(RBcpDebtConstant.RETURN_METHOD_BUYER_PAYMENT.equals(paymentInfo.getReturnMethod())){
						record.setCustcd(paymentInfo.getCustcdBuyer());//客户内部号
					}else{
						record.setCustcd(paymentInfo.getCustcdSaller());//客户内部号
					}
					record.setTlrcd(tlrcd);
					record.setBrcode(brcode);
					record.setRepayDate(BSysConstant.WORKDATE);
					record.setCurcd(debtVO.getCurcd());// 币别 默认人民币
					record.setReturnMethod(paymentInfo.getReturnMethod());// 还款类型
					record.setRepayAmount(debtVO.getRepayAmount());// 还款金额
					record.setMastContno(paymentInfo.getMastContno());//主合同号
					record.setPayAmount(debtVO.getRepayAmount());//入账金额
					record.setAmountOver(debtVO.getAmountOver());//尾款金额
					record.setRepayIntamt(debtVO.getRepayIntamt());//实际还息金额
					record.setRepayBalamt(debtVO.getRepayBalamt());//实际还本金额
					record.setAccountNo(debtVO.getBailAccount());//保证金账号
					record.setReturnType(paymentInfo.getReturnType());//还款方式
					rBcpAppliRepaymentDAO.insert(record);
				}
			}
		}
		
	/**
	 * 现金回款 -- 保存还款信息
	 * 
	 * @param lnciPayList
	 * @param paymentInfo
	 * @throws ScubeBizException
	 */
	public void saveTblAppliCustAccountInfo(List lnciPayList, DebtBussInfoVO paymentInfo) throws ScubeBizException {
		// 清空还款表对应数据
		//rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(paymentInfo.getAppno());
		
		BMrnAppliAcctInfo record = null;
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		// 保存前先清掉APPNO查询到记录
		bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(paymentInfo.getAppno());
		DebtLnciBaseInfoVO debtVO = null;
		for (int i = 0; i < lnciPayList.size(); i++) {
			record = new BMrnAppliAcctInfo();
			debtVO = (DebtLnciBaseInfoVO) lnciPayList.get(i);
			record.setId(UUIDGeneratorUtil.generate());
			record.setAppno(paymentInfo.getAppno());
			record.setDebetNo(debtVO.getDebetNo());// 借据表主键
			if (RBcpDebtConstant.RETURN_METHOD_BUYER_PAYMENT.equals(paymentInfo.getReturnMethod())) {
				record.setCustcd(paymentInfo.getCustcdBuyer());// 客户内部号
			} else {
				record.setCustcd(paymentInfo.getCustcdSaller());// 客户内部号
			}
			// record.setBrcode(brcode);
			record.setCurcd(debtVO.getCurcd());// 币别 默认人民币
			record.setMastContno(paymentInfo.getMastContno());// 主合同号
			record.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);// 保证金等价物类型：
																	// 03-保证金
			record.setInitType(ScfBasConstant.INIT_TYPE_ADD);// 保证金初始化类型： 02-追加
			record.setBailRate(debtVO.getBailPercent());// 保证金比例
			record.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);// 保证金及现金等价物确认状态：01-已确认
			record.setBailAccountno(debtVO.getBailAccount());// 保证金账号
			record.setAmount(debtVO.getRepayAmount());// 还款金额
			record.setPayAmount(debtVO.getRepayAmount());// 还款金额
			record.setBailAmount(debtVO.getRepayAmount());// 保证金金额
			bMrnAppliAcctInfoService.add(record);
		}
	}
		
}
