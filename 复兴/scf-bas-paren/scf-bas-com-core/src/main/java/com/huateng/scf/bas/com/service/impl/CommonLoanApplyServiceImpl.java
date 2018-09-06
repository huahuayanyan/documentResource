package com.huateng.scf.bas.com.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICommonLoanApplyService;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.dao.model.LoanApplyListVO;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.lan.service.ILoanApplyService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>放款审批公共类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月20日下午3:13:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月20日下午3:13:04	     新增
 *
 * </pre>
 */
@ScubeService
@Service("CommonLoanApplyServiceImpl")
public class CommonLoanApplyServiceImpl implements ICommonLoanApplyService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ProductServiceImpl")
	IProductService productservice;
	
	@Resource(name = "LoanApplyServiceImpl")
	ILoanApplyService loanapplyservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO bcrrlncondao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;
	
	@Resource(name = "BPrdCreditBindServiceImpl")
	IBPrdCreditBindService bprdcreditbindservice;
	
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bicrinfoservice;
	
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO blanapplilncibasedao;
	
	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;

	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;
	
	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice;
	
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;
	
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO blanlncibasedao;
	
	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;

	@Resource(name = IBLanLnciBaseService.BEAN_ID)
	IBLanLnciBaseService blanlncibaseservice;
	
	//应收账款
	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rbcpdebtinfodao;
	
	/**
	 * 获得放款申请列表
	 * @param loanApplyQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午3:24:27
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page getLoanApplyList(LoanApplyQryVO loanApplyQryVO)
	{
		log.debug("获得放款申请列表========================");
		Page pageQueryResult = loanapplyservice.getLoanApplyList(loanApplyQryVO);
		List<LoanApplyListVO> list  = pageQueryResult.getRecords();
		List listTmp = new ArrayList();
		LoanApplyListVO loanApplyListVO = null;
		BCrrLnCon tblContBaseInfo = null;
		BCrrGntyCon tblContSlaveInfo = null;
//		AmountVO amountVO = null;
		//获得合同信息、客户信息。因为有可能这两个信息都没有。
		if(list !=null && list.size()>0)
		{
            for(int i=0;i<list.size();i++)
            {
            	loanApplyListVO = (LoanApplyListVO) list.get(i);
            	String mastContcode  = loanApplyListVO.getMastContcode();
            	//如果合同存在
            	if(!StringUtil.isEmpty(mastContcode))
            	{

            		tblContBaseInfo = bcrrlncondao.selectByPrimaryKey(mastContcode);
            		if(tblContBaseInfo !=null)
            		{
            			loanApplyListVO.setMastContno(tblContBaseInfo.getAppId());
                		loanApplyListVO.setCurcd(tblContBaseInfo.getCurcd());

                		loanApplyListVO.setContAmount(tblContBaseInfo.getLnAmt());  //合同金额
                		loanApplyListVO.setRiskAmt(tblContBaseInfo.getLnAmt());  //信贷合同总敞口

                		String businessNo = tblContBaseInfo.getVidNo();  //

                		//获取信贷合同的可用敞口   modify by fengjinfu 2013-10-17  start
        				BigDecimal openAmount=amountservice.getContRiskAmtByCycle(tblContBaseInfo.getAppId(),tblContBaseInfo.getControlType());
        				loanApplyListVO.setAvaliableRiskAmt(tblContBaseInfo.getLnAmt().subtract(openAmount));
        				//获取信贷合同的可用敞口   modify by fengjinfu 2013-10-17  end

                		//先票/款后货 查询协议
                		String midProductId = bprdinfoservice.getSubClassProductIds(loanApplyQryVO.getSupplyChainPdId());
                		//若业务合同号有值，说明该信贷合同已经关联了质押合同了。
                		if(!StringUtil.isEmpty(businessNo))
                		{
                			if(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId))
                			{
                				BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(businessNo);
                				if(tblMutiProtBaseInfo!=null)
                				{
                					loanApplyListVO.setBusinessNo(businessNo);
                					//根据先票/款后货协议查询对应的购销合同
                					ContSlaveQryVO qryVO = new ContSlaveQryVO();
                					qryVO.setProtocolNo(businessNo);
                					List slaveList = bcntmprotbaseinfoservice.getContSlaveByCustcdAndCore(qryVO).getRecords();
                					if(slaveList!=null&&slaveList.size()>0){
                						tblContSlaveInfo = (BCrrGntyCon) slaveList.get(0);
                						loanApplyListVO.setSlaveContcode(tblContSlaveInfo.getConId());

                					}
                				}

        						//计算可用敞口
        					//	amountVO=new AmountVO(loanApplyListVO.getSupplyChainPdId(),null,null,loanApplyListVO.getDebetNo(),ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
        			        //    BigDecimal openAmount=AmountService.getInstance().getPant(amountVO);//敞口余额
                				/*Map map=DAOUtils.getTblLnciBaseInfoDAO().getLnciRiskAmtByParam(tblContBaseInfo.getMastContno());
                				BigDecimal bailAmount=(BigDecimal) map.get("bailAmount");
                				BigDecimal cashEqtAmt=(BigDecimal) map.get("cashEqtAmt");
                				BigDecimal lnciBal=(BigDecimal) map.get("lnciBal");
                				BigDecimal openAmount=lnciBal.subtract(bailAmount).subtract(cashEqtAmt);
                				//增加流程中的借据敞口余额汇总 add by changhao.huang 2013-10-11 begin
                				BigDecimal flowOpenAmount = BigDecimal.ZERO;
                				List flowList = DAOUtils.getTblAppliLnciBaseInfoDAO().getFlowRiskAmtByBusinessNo(businessNo);
                				if(flowList!=null&&flowList.size()>0){
                					flowOpenAmount = (BigDecimal) flowList.get(0);
                				}
                				if(flowOpenAmount!=null){
                					loanApplyListVO.setAvaliableRiskAmt(tblContBaseInfo.getRiskAmt().subtract(openAmount).add(flowOpenAmount));
                				}else{
                					loanApplyListVO.setAvaliableRiskAmt(tblContBaseInfo.getRiskAmt().subtract(openAmount));
                				}*/
                				//增加流程中的借据敞口余额汇总 add by changhao.huang 2013-10-11 end



                				//判断是否有领用间接额度
        		                //查询额度类型
                				BPrdCreditBind tblProductCreditBind=new BPrdCreditBind();
    		                 	tblProductCreditBind.setProductId(loanApplyListVO.getSupplyChainPdId());
    		                 	tblProductCreditBind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);//模式
    		                 	tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);//额度阶段
    		                 	tblProductCreditBind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);//操作类型
    		                 	String creditType="";
    		               		List<BPrdCreditBind> creditBindList = bprdcreditbindservice.getTblProductCreditBind(tblProductCreditBind);
    		               		if(creditBindList!=null&creditBindList.size()>0)
    		               		{
    		               			BPrdCreditBind creditBind = creditBindList.get(0);
    		               			 creditType = creditBind.getCreditType();  // 额度类型
    		               		}


        		               	if(!StringUtil.isEmpty(creditType)){
        		               		CreditQryVO creditQryVO=new CreditQryVO();
        		             		creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
        		             		creditQryVO.setNodeType_Q(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);//领用额度
        		             		creditQryVO.setCustcd(loanApplyListVO.getCreditCustcd());
        		             		creditQryVO.setOtherCustcd_Q(loanApplyListVO.getCustcd());//appliLnciBaseInfo.getCreditCustcd()
        		             		creditQryVO.setCreditType_Q(creditType);
        		             		creditQryVO.setPageIndex(1);
        		             		creditQryVO.setPageSize(Integer.MAX_VALUE);
        		                    creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
        		             		Page pageList = bicrinfoservice.getCurrenyEffectiveTblCreditInfoByCreditQryVO(creditQryVO);
        		             		List subLeafCreditInfoList=pageList.getRecords();
        		             		if (subLeafCreditInfoList!=null&&subLeafCreditInfoList.size()>0) {
        		             			loanApplyListVO.setFlag("1");
        		             		}else{
        		             			loanApplyListVO.setFlag("0");
        		             		}
        		               	}
        			            //END

                			}
                			else
                			{
                				tblContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(businessNo);
	                			if(tblContSlaveInfo != null)
	                			{
	                				loanApplyListVO.setBusinessNo(businessNo);
	                				loanApplyListVO.setSlaveContcode(tblContSlaveInfo.getConId()); //业务
	                			}
                			}
                		}
            		}
            	}
            	listTmp.add(loanApplyListVO);
            }
		}

		pageQueryResult.setRecords(listTmp);

		return pageQueryResult;

	}
	
	/**
	 * 保存借据申请信息
	 * @param appno
	 * @param bLanAppliLnciBase
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午8:27:53
	 */
	@Transactional
	@Override
	public String saveBLanAppliLnciBase(String appno, BLanAppliLnciBase bLanAppliLnciBase) throws ScubeBizException {
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase appliLnciBase = new com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase();
		BeanUtils.copyProperties(bLanAppliLnciBase, appliLnciBase);
		List<com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase> list = 
				blanapplilncibasedao.selectByAppNo(appno);
		appliLnciBase.setId(UUIDGeneratorUtil.generate());
		appliLnciBase.setDebetNo(UUIDGeneratorUtil.generate());
		if (list == null || list.size() == 0) {
			blanapplilncibasedao.insertSelective(appliLnciBase);
		}
		else
		{
			appliLnciBase = (com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase) list.get(0);
			blanapplilncibasedao.updateByPrimaryKeySelective(appliLnciBase);
		}
		return appliLnciBase.getDebetNo();
	}
	
	/**
	 * 放款保存更新appliBussInfo
	 * @param lnciVO
	 * @param factFlag
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日上午9:45:06
	 */
	@Override
	public void updateAppliBussInfoWithLnciVO(DebtLnciBaseInfoVO lnciVO,String factFlag) throws ScubeBizException
	{
		RBcpAppliBussInfo tblAppliBussInfo = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(lnciVO.getAppno());
		if(tblAppliBussInfo!=null)
		{
			if(ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factFlag))
			{
				getInvoiceInfoWithLnciVO(lnciVO,tblAppliBussInfo);
			}
		}
		else
		{
			tblAppliBussInfo=new RBcpAppliBussInfo();
			if(ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factFlag))
			{
				getInvoiceInfoWithLnciVO(lnciVO,tblAppliBussInfo);
			}
			tblAppliBussInfo.setAppno(lnciVO.getAppno());
			tblAppliBussInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			tblAppliBussInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			nrbcpapplibussinfoservice.save(tblAppliBussInfo);
		}
		nrbcpapplibussinfoservice.update(tblAppliBussInfo);
	}
	
	/**
	 * 获取对象信息
	 * @param lnciVO
	 * @param appliBussInfo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月24日上午9:44:24
	 */
	private RBcpAppliBussInfo getInvoiceInfoWithLnciVO(DebtLnciBaseInfoVO lnciVO,RBcpAppliBussInfo appliBussInfo)
	{
		BeanUtils.copyProperties(lnciVO, appliBussInfo);
		appliBussInfo.setCustcdBuyer(lnciVO.getCustcdBuyer());//买方客户号
		appliBussInfo.setCustcdSaller(lnciVO.getCustcd());//卖方客户号
		appliBussInfo.setMastContno(lnciVO.getMastContno());//合同号
		appliBussInfo.setOtherReason(lnciVO.getProductId());//业务品种
		appliBussInfo.setBussType(lnciVO.getProductId());//业务品种
		appliBussInfo.setCurcd(lnciVO.getCurcd());//合同币别
		appliBussInfo.setBillDate(lnciVO.getStartDate());//合同生效日期
		appliBussInfo.setBillEndDate(lnciVO.getEndDate());//合同到期日期
		appliBussInfo.setAppDate(ScfDateUtil.getStringDate(new Date())); //融资申请日期
		appliBussInfo.setRateType(lnciVO.getRateType());//利率类型

		appliBussInfo.setBaseRate(lnciVO.getBaseYearRate() !=null?lnciVO.getBaseYearRate().toString():"");//年基准利率
		appliBussInfo.setUpDown(lnciVO.getRateFloatType());//浮动类型
		appliBussInfo.setUpDownPercent(lnciVO.getRateFloatValue() !=null?lnciVO.getRateFloatValue().toString():"");//浮动值
		appliBussInfo.setExecuteRate(lnciVO.getRate() !=null?lnciVO.getRate().toString():"");//执行利率

		appliBussInfo.setLoanType(lnciVO.getLoanType());//贷款种类
		appliBussInfo.setAccountNo(lnciVO.getAccountNo());//入账账号
		appliBussInfo.setDebtNum(Integer.valueOf(lnciVO.getBillNum().toString()));//应收总份数
		appliBussInfo.setTotalDebtAmount(lnciVO.getTotalBillsAmount());//应收总可融资余额
		appliBussInfo.setAmount(lnciVO.getAvaliableAmt());//可融资金额
		appliBussInfo.setAppLoanDate(lnciVO.getStartDate());//融资发放日期
		appliBussInfo.setLoanDueDate(lnciVO.getEndDate());//融资到期日期
		return appliBussInfo;
	}
	
	/**
	 * 发票发放  添加融资发票 【业务申请业务明细表】
	 * @param insertList
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日上午9:47:37
	 */
	@Override
	public void saveAppliBussDetall(List<RBcpAppliBussDtl> insertList, String appno, String financingType) throws ScubeBizException
	{
		DebtBillsInfoVO debtVo = new DebtBillsInfoVO();
		if(insertList!=null&&insertList.size()>0)
		{
			//保存前先清掉APPNO查询到记录
			nrbcpapplibussdtlservice.appliBussDetailUpdate(appno);
			for (int i = 0; i < insertList.size(); i++)
			{
				RBcpAppliBussDtl tblAppliBussDetail = insertList.get(i);
				try
				{
					BeanUtils.copyProperties(tblAppliBussDetail, debtVo);
					if(financingType.equals(DebtConstants.FINANCING_TYPE_INVOICE))
					{
						debtVo.setFinancingAmount(tblAppliBussDetail.getLoanAmount());
					}
				}
				catch(BeansException e)
				{
					e.printStackTrace();
				}
				tblAppliBussDetail.setMoney(debtVo.getFinancingAmount());//本次融资金额
				tblAppliBussDetail.setAppno(appno);
				tblAppliBussDetail.setDebetNo(debtVo.getDebtNo());
				tblAppliBussDetail.setDebtId(debtVo.getId());
				tblAppliBussDetail.setId(null);
				nrbcpapplibussdtlservice.save(tblAppliBussDetail);
				if(financingType.equals(DebtConstants.FINANCING_TYPE_INVOICE))
				{
					if(!StringUtil.isEmpty(tblAppliBussDetail.getDebtId()))
					{
						rbcpdebtinfoservice.lockDebtBaseInfo(tblAppliBussDetail.getDebtId(), tblAppliBussDetail.getAppno());
					}
				}
			}
		}
	}
	
	/**
	 * 放款更新appli_lnci_base
	 * @param lnciVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日上午10:18:39
	 */
	@Override
	public void updateAppliLnciBaseInfo(DebtLnciBaseInfoVO lnciVO) throws ScubeBizException
	{
		BLanAppliLnciBase appLnci= blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(lnciVO.getAppno());
		if(appLnci!=null)
		{
			appLnci.setCreditCustcd(lnciVO.getOtherCustcd());
			appLnci.setOtherCustcd(lnciVO.getOtherCustcd());
			appLnci.setInitCashEqtAmt(lnciVO.getInitCashEqtAmt());
			appLnci.setProtocolNo(lnciVO.getBusinessNo());//业务合同号
			blanapplilncibaseservice.updateBLanAppliLnciBase(appLnci);
		}
		else
		{
			throw new ScubeBizException("放款申请信息获取失败", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
	}
	

	/**
	 * 放款更新申请状态
	 * @param appno
	 * @param appliStatusDtlWaitcms
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午3:11:53
	 */
	@Override
	public void updateAppliBaseInfoWithParam(String appno, String appliStatusDtlWaitcms) throws ScubeBizException
	{
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo tabi = bPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		if(tabi==null)
		{
			throw new ScubeBizException("在申请表里未找到申请号为"+"【"+appno+"】"+"的申请信息");
		}
		tabi.setAppliStatusDtl(appliStatusDtlWaitcms);
		bPbcAppliBaseInfoDAO.updateByPrimaryKeySelective(tabi);
	}
	
	/**
	 * 放款金额校验
	 * @param debtLnciBaseInfoVO
	 * @param factType
	 * @author 	mengjiajia
	 * @date 	2017年6月6日上午10:52:22
	 */
	@Override
	public void checkFinanceApplyInfo(DebtLnciBaseInfoVO debtLnciBaseInfoVO,String factType)
	{
		BLanAppliLnciBase tblAppliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(debtLnciBaseInfoVO.getAppno());
		String mastContno = tblAppliLnciBaseInfo.getMastContno();
		BCntBcpInfoVO tblContDebtInfo = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(mastContno);

		String cycle = "";

		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andProtocolNoEqualTo(mastContno);
		cri.andStateNotEqualTo(BSysConstant.FLAG_ON);// 记录状态不等于
		cri.andIsSettleEqualTo(BSysConstant.FLAG_OFF);// 是否结清
		List<BLanLnciBase> list = blanlncibasedao.selectByExample(example);

		//获得信贷合同项下的所有的借据金额、借据敞口余额。
		BigDecimal totalLnciamt = new BigDecimal(0);   //合同项下的借据总金额
		//获得所有的出账金额（放款通过）
		totalLnciamt = this.getTotalLoanAmtInContInfo(mastContno);
		
		BigDecimal totalContRist = new BigDecimal(0);  //业务合同下的的借据敞口余额
		if(list !=null && list.size() > 0){
			BLanLnciBase tblLnciBaseInfoTmp = null;
			int count = list.size();
			BigDecimal addBailAmount;
			BigDecimal bailAmount;
			BigDecimal initCashEqtAmt;
			BigDecimal addCashEqtAmt;
			BigDecimal lnciBal;

			for(int i=0;i<count;i++){
				tblLnciBaseInfoTmp = (BLanLnciBase) list.get(i);
	//			totalLnciamt = totalLnciamt.add(tblLnciBaseInfoTmp.getLnciAmt());

				//借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
				addBailAmount = (tblLnciBaseInfoTmp.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfoTmp.getAddBailAmount());
				bailAmount = (tblLnciBaseInfoTmp.getBailAmount()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getBailAmount());
				initCashEqtAmt = (tblLnciBaseInfoTmp.getInitCashEqtAmt()== null? new BigDecimal(0):tblLnciBaseInfoTmp.getInitCashEqtAmt());
				addCashEqtAmt = (tblLnciBaseInfoTmp.getAddCashEqtAmt()== null ? new BigDecimal(0):tblLnciBaseInfoTmp.getAddCashEqtAmt());
				lnciBal = tblLnciBaseInfoTmp.getLnciBal();
				totalContRist = totalContRist.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
			}
		}
		
		BigDecimal tempRistAmt = new BigDecimal(0);

		//计算本笔风险敞口
		if(tblAppliLnciBaseInfo.getBailAmount()==null){
			tblAppliLnciBaseInfo.setBailAmount(new BigDecimal(0.00));
		}
		tempRistAmt = tblAppliLnciBaseInfo.getLnciBal().
    			subtract(tblAppliLnciBaseInfo.getBailAmount()).subtract(StringUtil.isEmpty(debtLnciBaseInfoVO.getInitCashEqtAmt())?BigDecimal.ZERO:debtLnciBaseInfoVO.getInitCashEqtAmt());

		if((ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE+"','"
					+ScfBasConstant.FACT_TYPE_DEBT_POOL+"','"
					+ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE).indexOf(factType)==-1)
		{//池不校验买方额度
			if(!StringUtil.isEmpty(debtLnciBaseInfoVO.getCreditType())
	    			&&ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(debtLnciBaseInfoVO.getCreditType()))
			{
	    		if(tempRistAmt.compareTo(debtLnciBaseInfoVO.getCreditUseBal())>0)
	    		{
	    			throw new ScubeBizException("保理买方间接额度可用余额不足！", BLanErrorConstant.SCF_BAS_LAN_20007);
	    		}
	    	}
		}

		//增加流程中业务合同的出账金额
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("mastContno", mastContno);
		//用于计算流程中的借据敞口，配置版放款除审批通过及否决，均在流程中
		List<String> appliStatusDtl = new ArrayList<String>();
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		omap.put("appliStatusDtl", appliStatusDtl);
		List<HashMap<String, Object>> flowList = extnrecbcpdao.getFlowRiskAmtByMastContno(omap);
		if(flowList!=null && flowList.size()>0)
		{
			HashMap<String, Object> map = (HashMap<String, Object>) flowList.get(0);
			BigDecimal fowBigAmt = (BigDecimal) (StringUtil.isEmpty(map.get("AMT")) ? BigDecimal.ZERO : map.get("AMT"));
			totalContRist = totalContRist.add(fowBigAmt);
		}

		//获取合同下的敞口余额。
//    	BigDecimal contRistAmtTemp = this.getContRiskAmtByCycle(mastContno,cycle);

		//1-校验合同的可用额度是否足够
		//1.1 不可循环额度合同。
		// 规则：信贷合同项下所有借据金额 + 本次放款金额 <= 信贷合同金额
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle))
		{
			//流程中（借据金额）
			List<HashMap<String, BigDecimal>> listTemp = blanapplilncibaseservice.getFlowKindsOfSumByMastContno(mastContno);
			if (listTemp != null && listTemp.size() > 0) {
				BigDecimal flowLnciRiskAmt = (BigDecimal) (StringUtil.isEmpty(listTemp.get(0).get("lnciAmt"))? BigDecimal.ZERO: listTemp.get(0).get("lnciAmt"));
				totalLnciamt = totalLnciamt.add(flowLnciRiskAmt);
			}
		}
        //1.2 可循环额度合同	没有信贷合同，不使用
        //规则：借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
        //规则：信贷合同项下所有生效的借据敞口余额 + 本笔风险敞口〈=信贷合同总敞口
        //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额
        if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
        {
        }
    	if((ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE+"','"
				+ScfBasConstant.FACT_TYPE_DEBT_POOL+"','"
				+ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE).indexOf(factType)==1)
    	{//池不校验买方额度
        	//本笔风险敞口 <=  池应收账款余额 * 融资比例 + 池保证金余额 - 敞口余额
        	BigDecimal compareAmt=new BigDecimal(0);
        	compareAmt=	(debtLnciBaseInfoVO.getTotalBillsAmount().multiply(tblContDebtInfo.getLoanPercent())
        			.divide(new BigDecimal(100))).subtract(totalContRist);
        	if(tempRistAmt.compareTo(compareAmt)>0)
        	{
        		throw new ScubeBizException("应收账款池可融资金额不足！",  BLanErrorConstant.SCF_BAS_LAN_20033);
        	}
        }
    	else
    	{
        	//本笔风险敞口 <= 应收账款余额 * 融资比例
        	if(tempRistAmt.compareTo(StringUtil.isEmpty(debtLnciBaseInfoVO.getTotalBillsAmount())?BigDecimal.ZERO:debtLnciBaseInfoVO.getTotalBillsAmount())>0)
        	{
        		throw new ScubeBizException("应收账款可融资金额不足！", BLanErrorConstant.SCF_BAS_LAN_20011);
        	}
        }
	}
	
	/**
	 * 查询放款合同累计出账金额
	 * @param mastContno
	 * @return
	 * @throws CommonException
	 * @author 	mengjiajia
	 * @date 	2017年6月6日上午11:20:31
	 */
	public BigDecimal getTotalLoanAmtInContInfo(String mastContno) throws ScubeBizException
	{
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andMastContnoEqualTo(mastContno);
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		List<BLanLnciBase> list = blanlncibasedao.selectByExample(example);

		BigDecimal totalLnciBal = new BigDecimal("0");
		if(list!=null && list.size()>0){
			for(BLanLnciBase bLanLnciBase:list)
			{
				BigDecimal lnciAmt = bLanLnciBase.getLnciAmt();
				totalLnciBal = totalLnciBal.add(StringUtil.isEmpty(lnciAmt)?new BigDecimal("0"):lnciAmt);
			}
		}
		return totalLnciBal;
	}
	
	/**
	 * 获取敞口余额
	 * 根据合同类型，计算敞口余额。
	 * 循环合同：  敞口余额 = 信贷合同项下所有已经出账成功的敞口余额之和+供应链已经提交给信贷的借据的敞口余额之和（未 出账）
	 * 非循环合同： 敞口余额 = ∑（借据金额-初始保证金金额-初始现金等价物金额）【含出账已经成功和已经提交给信贷的】
	 * 该方法仅适合放款时的校验使用！！！
	 * @param mastContno
	 * @param cycle
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月6日上午11:28:09
	 */
	@Override
	public BigDecimal getContRiskAmtByCycle(String mastContno,String cycle) throws ScubeBizException
	{
		BigDecimal avalibalRiskAmt = new BigDecimal(0);
		List<HashMap<String, BigDecimal>> list = blanapplilncibaseservice.getFlowRiskAmtByMastContno(mastContno);
		BigDecimal flowRiskAmt= new BigDecimal(0);

		if(list !=null && list.size() >0)
		{
			flowRiskAmt = (BigDecimal) (list.get(0).get("AMT") == null ? BigDecimal.ZERO : list.get(0).get("AMT"));
		}

		//非循环合同
		if(ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle))
		{
			avalibalRiskAmt = getContRiskAmt(mastContno,cycle);
		}
		//循环合同
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
		{
			avalibalRiskAmt = getContRiskAmt(mastContno,cycle);
		}
		//增加流程审批中的借据（仅仅包括已经提交给信贷，但是未审批通过）
		avalibalRiskAmt =avalibalRiskAmt.add(flowRiskAmt);
		return avalibalRiskAmt;
	}
	
	/**
	 * 计算信贷合同向下所有借据的敞口余额
	 * @param mastContno
	 * @param cycle
	 * @return
	 * @throws CommonException
	 * @author 	mengjiajia
	 * @date 	2017年6月6日下午1:30:32
	 */
	public BigDecimal getContRiskAmt(String mastContno,String cycle) throws ScubeBizException
	{
		BigDecimal riskAmt = BigDecimal.ZERO;
		BigDecimal totRiskAmt = BigDecimal.ZERO;
		BLanLnciBaseExample example = new BLanLnciBaseExample();
		BLanLnciBaseExample.Criteria cri = example.createCriteria();
		cri.andMastContnoEqualTo(mastContno);
		cri.andStateNotEqualTo(ScfBasConstant.FLAG_ON);
		//循环合同，已经结清的借据不需要要计算的。
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
		{
			cri.andIsSettleEqualTo(ScfBasConstant.FLAG_OFF);
		}

		List<BLanLnciBase> list = blanlncibasedao.selectByExample(example);
		if (list != null && list.size() >0)
		{
			for (BLanLnciBase bLanLnciBase:list)
			{
				riskAmt = this.getLnciRiskAmt(bLanLnciBase,cycle);
				if (riskAmt == null){
					riskAmt = BigDecimal.ZERO;
				}
				totRiskAmt = totRiskAmt.add(riskAmt);
			}
		}
		return totRiskAmt;
	}
	
	/**
	 * 计算本笔借据的敞口余额(本笔数风险敞口)
	 * @param tblLnciBaseInfo
	 * @param cycle
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月6日下午1:33:49
	 */
	public BigDecimal getLnciRiskAmt(BLanLnciBase tblLnciBaseInfo,String cycle) throws ScubeBizException
	{

		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (tblLnciBaseInfo.getBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getBailAmount());
		addBailAmount= (tblLnciBaseInfo.getAddBailAmount()==null?new BigDecimal(0):tblLnciBaseInfo.getAddBailAmount());
		initCashEqtAmt = (tblLnciBaseInfo.getInitCashEqtAmt()==null?new BigDecimal(0):tblLnciBaseInfo.getInitCashEqtAmt());
		addCashEqtAmt = (tblLnciBaseInfo.getAddCashEqtAmt()==null ? new BigDecimal(0):tblLnciBaseInfo.getAddCashEqtAmt());
		if(ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle))
		{
			riskAmt = tblLnciBaseInfo.getLnciAmt().subtract(bailAmount).subtract(initCashEqtAmt);
		}
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
		{

			riskAmt = tblLnciBaseInfo.getLnciBal().subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		}

		return riskAmt;
	}
}
