package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.AmountVO;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoVO;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.ILoanApplyService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.vo.ProtocolQryVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月20日下午3:22:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月20日下午3:22:13	     新增
 *
 * </pre>
 */
@ScubeService
@Service("LoanApplyServiceImpl")
public class LoanApplyServiceImpl implements ILoanApplyService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ProductServiceImpl")
	IProductService productservice;
	
	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extblandao;
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bcrrgntyconservice;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;
	
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;
	
	@Resource(name = "BPrdCreditBindServiceImpl")
	IBPrdCreditBindService bprdcreditbindservice;
	
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bicrinfoservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;
	
	/**
	 * 放款申请列表
	 * @param loanApplyQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午3:27:14
	 */
	@Override
	public Page getLoanApplyList(LoanApplyQryVO loanApplyQryVO)	throws ScubeBizException
	{
		log.debug("getLoanApplyList-->放款申请列表查询");
		HashMap<String, Object> omap = new HashMap<String, Object>();

		//申请号
		if(!StringUtil.isEmpty(loanApplyQryVO.getAppno()))
		{
			omap.put("appno", loanApplyQryVO.getAppno());
		}
		
		// 信贷合同号
		if (!StringUtil.isEmpty(loanApplyQryVO.getMastContCode())) 
		{
			omap.put("mastContcode", loanApplyQryVO.getMastContCode());
		}
		// 借据号/承兑协议号
		if (!StringUtil.isEmpty(loanApplyQryVO.getDebetId()))
		{
			omap.put("debetId", loanApplyQryVO.getDebetId());
		}
		// 审批状态
		if (!StringUtil.isEmpty(loanApplyQryVO.getAppliStatusDtl())) 
		{
			omap.put("appliStatusDtl", loanApplyQryVO.getAppliStatusDtl());
		}
		if(!StringUtil.isEmpty(loanApplyQryVO.getCname()))
		{
			omap.put("cname", loanApplyQryVO.getCname());
		}
		// 业务种类
		if (!StringUtil.isEmpty(loanApplyQryVO.getSupplyChainPdId()))
		{
			omap.put("supplyChainPdId", loanApplyQryVO.getSupplyChainPdId());
		}
		
		String roleFlag = "0"; //放款审批岗标志位
		List<String> roleList = ContextHolder.getUserInfo().getRoleList();
		for (int i = 0; i < roleList.size(); i++) {
			String role = roleList.get(i);
			//判断方式：当前角色当中包含有放款审批岗，并且角色当中不含有客户经理岗位
			if(ScfBasConstant.ROLE_ID_LOAN_AUDIT.equals(String.valueOf(role))){
				roleFlag = "1";
			}else if(ScfBasConstant.ROLE_ID_MANAGER.equals(String.valueOf(role))){
				roleFlag = "0";
				break;
			}
		}
		if(roleFlag.equals("0"))
		{
			//增加客户经理权限控制 add by xiaolong.xiong 2013-08-30
			omap.put("mgrno", ContextHolder.getUserInfo().getTlrNo());
		}
		
		int total = extblandao.countBillNomalLoanApplyList(omap);
		Page page = new Page(loanApplyQryVO.getPageSize(), loanApplyQryVO.getPageIndex(), total);
		page.setRecords(extblandao.getBillNomalLoanApplyList(omap, page));
		
		return page;
	}
	
	/**
	 * 得到动产、汽车货物的贷款的详细信息。
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午2:50:36
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MortgageLnciBaseInfoVO getMortgageLoanApplyInfo(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{

		//汽车贷款、动产、预付款的VO对象。
		MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO = new MortgageLnciBaseInfoVO();
		BLanAppliLnciBase appliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(debtCommonQryVO.getAppno());// 借据申请信息
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtCommonQryVO.getAppno());
		mortgageLnciBaseInfoVO.setAppBrcode(tblAppliBaseInfo.getAppBrcode());  //申请机构号


		//1-获取借据表的信息
		BeanUtils.copyProperties(appliLnciBaseInfo, mortgageLnciBaseInfoVO);

		mortgageLnciBaseInfoVO.setLoanWay(appliLnciBaseInfo.getLnciType());  //出账方式
		//2-借款合同表的信息
		BCrrLnCon tblContBaseInfo = bcrrlnconservice.findBCrrLnConByAppId(mortgageLnciBaseInfoVO.getMastContcode());  //信贷合同号
		mortgageLnciBaseInfoVO.setContStartDate(tblContBaseInfo.getLnStrtDt());
		mortgageLnciBaseInfoVO.setContEndDate(tblContBaseInfo.getLnEndDt());
		mortgageLnciBaseInfoVO.setContAmount(tblContBaseInfo.getLnAmt());  //合同金额
		mortgageLnciBaseInfoVO.setContRiskAmt(tblContBaseInfo.getLnAmt());  //总敞口
		mortgageLnciBaseInfoVO.setCycle(tblContBaseInfo.getControlType());  //是否循环使用
		mortgageLnciBaseInfoVO.setMastContStatus(tblContBaseInfo.getAppStat()); //合同状态
		mortgageLnciBaseInfoVO.setMastContcode(tblContBaseInfo.getAppId());  //信贷合同号
        mortgageLnciBaseInfoVO.setMastContno(tblContBaseInfo.getAppId()); //信贷合同号(ID)
        mortgageLnciBaseInfoVO.setCurcd(tblContBaseInfo.getCurcd());   //币种
        mortgageLnciBaseInfoVO.setCreditProtNo(tblContBaseInfo.getCreditProtNo());  //额度协议流水号
        mortgageLnciBaseInfoVO.setRateType(tblContBaseInfo.getIntCd());//利率代码
        //设置借据申请表的产品ID信息
        String product_Q = debtCommonQryVO.getSupplyChainPdId_Q();
        if(!StringUtil.isEmpty(product_Q)){
        appliLnciBaseInfo.setProductId(product_Q);
        }
        String protocolNo = null;
        String productID = appliLnciBaseInfo.getProductId();
        String parentProductID = productservice.getParentIdById(productID);
        BigDecimal lowNewPrice = new BigDecimal(0);
        String businessNo  = tblContBaseInfo.getVidNo();  //业务合同号
        String moniModel="";

       //获取信贷合同的可用敞口   modify by fengjinfu 2013-10-17  start
		BigDecimal contOpenAmount = amountservice.getContRiskAmtByCycle(tblContBaseInfo.getAppId(),tblContBaseInfo.getControlType());
		mortgageLnciBaseInfoVO.setAvaliableRiskAmt(tblContBaseInfo.getLnAmt().subtract(contOpenAmount));
		//获取信贷合同的可用敞口   modify by fengjinfu 2013-10-17  start

        if(parentProductID.equals(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE) || parentProductID.equals(ScfBasConstant.PRODUCT_TYPE_CHATTLE))
        {
        	   //3-担保合同信息
            BCrrGntyCon tblContSlaveInfo = bcrrgntyconservice.findBCrrGntyConByConId(businessNo);  //担保合同号ID
            mortgageLnciBaseInfoVO.setSupplyChainPdId(tblContSlaveInfo.getVidPrdId());  //业务品种
            mortgageLnciBaseInfoVO.setSlaveContno(businessNo);
            mortgageLnciBaseInfoVO.setSlaveContcode(businessNo);  //质押合同号
            mortgageLnciBaseInfoVO.setRation(tblContSlaveInfo.getRation());  //质押率
            mortgageLnciBaseInfoVO.setBusinessNo(businessNo);
            protocolNo = tblContSlaveInfo.getPrtclNo();
            lowNewPrice = StringUtil.isEmpty(tblContSlaveInfo.getLowPriceNew())?BigDecimal.ZERO:tblContSlaveInfo.getLowPriceNew();
            moniModel = tblContSlaveInfo.getMoniMd();
        }
        //预付款
        if(parentProductID.equals(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE) )
        {
        	BCntMprotBaseInfo tblMutiProtBaseInfo = new BCntMprotBaseInfo();
        	mortgageLnciBaseInfoVO.setHasIndirectCredit(appliLnciBaseInfo.getHasIndirectCredit()); //间接额度类型
        	tblMutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(protocolNo);
        	mortgageLnciBaseInfoVO.setBusinessNo(tblMutiProtBaseInfo.getProtocolNo()); //先票款后货协议
        	mortgageLnciBaseInfoVO.setProtocolCode(tblMutiProtBaseInfo.getProtocolCode());
        	mortgageLnciBaseInfoVO.setSupplyChainPdId(tblMutiProtBaseInfo.getProductId());
        	String cname = bcntmprotpartinfoservice.findCnameByProAndRole(tblMutiProtBaseInfo.getProtocolNo(),ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE, ScfBasConstant.RETURN_FLAG_CNAME);
        	mortgageLnciBaseInfoVO.setAssureCname(cname); //担保方名称

        	//间接可用额度计算
            BigDecimal creditUseBal=BigDecimal.ZERO;
           //查询额度类型
           	BPrdCreditBind tblProductCreditBind = new BPrdCreditBind();
           	tblProductCreditBind.setProductId(appliLnciBaseInfo.getProductId());
           	tblProductCreditBind.setOprMode(ScfBasConstant.CREDIT_OPR_MODE_SELLER_AND_BUYER);//模式
           	tblProductCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT);//额度阶段
           	tblProductCreditBind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);//操作类型
           	String creditType="";
         		List<BPrdCreditBind> creditBindList = bprdcreditbindservice.getTblProductCreditBind(tblProductCreditBind);
         		if(creditBindList!=null&creditBindList.size()>0){
         			BPrdCreditBind creditBind = creditBindList.get(0);
         			 creditType = creditBind.getCreditType();  // 额度类型
         		}


         	if(!StringUtil.isEmpty(creditType))
         	{
         		CreditQryVO creditQryVO=new CreditQryVO();
	       		creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
	       		creditQryVO.setNodeType_Q(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
	       		creditQryVO.setCustcd(appliLnciBaseInfo.getCreditCustcd());
	       		creditQryVO.setOtherCustcd_Q(appliLnciBaseInfo.getCustcd());//appliLnciBaseInfo.getCreditCustcd()
	       		creditQryVO.setCreditType_Q(creditType);
	       		creditQryVO.setPageIndex(1);
	       		creditQryVO.setPageSize(Integer.MAX_VALUE);
                creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
       			Page pageList = bicrinfoservice.getCurrenyEffectiveTblCreditInfoByCreditQryVO(creditQryVO);
       			List subLeafCreditInfoList = pageList.getRecords();
	       		if (subLeafCreditInfoList!=null&&subLeafCreditInfoList.size()>0) 
	       		{
	       			BIcrInfo subLeafCreditInfo = (BIcrInfo)subLeafCreditInfoList.get(0);
	       			creditUseBal=subLeafCreditInfo.getCreditUsableAmount();//可用额度
	       			mortgageLnciBaseInfoVO.setIndirectCreaditLastAmt(creditUseBal);
	       		}
         	}
         	
         	//计算可用敞口
            AmountVO amountVO = new AmountVO(mortgageLnciBaseInfoVO.getSupplyChainPdId(),null,null,mortgageLnciBaseInfoVO.getDebetNo(),ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
            com.huateng.scf.bas.pbc.model.AmountVO amountVO2 = new com.huateng.scf.bas.pbc.model.AmountVO();
            BeanUtils.copyProperties(amountVO, amountVO2);
//            BigDecimal openAmount = amountservice.getPant(amountVO2);//敞口金额
            //本笔风险敞口
            //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额。页面端需要根据初始现金等价物的更新而变化。
            if(mortgageLnciBaseInfoVO.getBailAmount() == null)
            {
            	mortgageLnciBaseInfoVO.setBailAmount(new BigDecimal(0));  //判空处理
            }
            if(mortgageLnciBaseInfoVO.getInitCashEqtAmt() == null)
            {
            	mortgageLnciBaseInfoVO.setInitCashEqtAmt(new BigDecimal(0));   //判空处理
            }

            BigDecimal riskAmt = mortgageLnciBaseInfoVO.getLnciAmt().subtract(mortgageLnciBaseInfoVO.getBailAmount()).subtract(mortgageLnciBaseInfoVO.getInitCashEqtAmt());
            mortgageLnciBaseInfoVO.setRiskAmt(riskAmt);
        }

        //4-监管合同信息
        mortgageLnciBaseInfoVO.setProtocolNo(protocolNo);
        ProtocolQryVO protocolQryVO = new ProtocolQryVO();
        protocolQryVO.setProtocolNo(protocolNo);
        Page contractpageQueryResult = contractservice.getMonitorProtocolQuery(protocolQryVO);
        List contractList = contractpageQueryResult.getRecords();
        if(contractList != null && contractList.size()> 0)
        {
//        	MoniProtocolVO contractVO = (MoniProtocolVO) contractList.get(0);
        	Map<String, Object> contractVO = (Map<String, Object>) contractList.get(0);
        	mortgageLnciBaseInfoVO.setProtocolCode(contractVO.get("protocolCode").toString());
        	mortgageLnciBaseInfoVO.setMoniCustcd(contractVO.get("thrCd").toString());  //监管公司客户号
        	mortgageLnciBaseInfoVO.setMoniName(contractVO.get("thrName").toString());  //监管公司名称
        }

        //5-出质人名称
        BCrmBaseInfo tblCustBaseInfo = null;
        tblCustBaseInfo = bcrmbaseinfoservice.findBCrmBaseInfoByCustcd(mortgageLnciBaseInfoVO.getCustcd());
        mortgageLnciBaseInfoVO.setCname(tblCustBaseInfo.getCname());

        if(parentProductID.equals(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE) || parentProductID.equals(ScfBasConstant.PRODUCT_TYPE_CHATTLE))

        {
        	  //6-计算可用敞口
            AmountVO amountVO =  new AmountVO(mortgageLnciBaseInfoVO.getSupplyChainPdId(),mortgageLnciBaseInfoVO.getBusinessNo());
            com.huateng.scf.bas.pbc.model.AmountVO amountVO2 = new com.huateng.scf.bas.pbc.model.AmountVO();
            BeanUtils.copyProperties(amountVO, amountVO2);
            BigDecimal openAmount = amountservice.getPant(amountVO2);//敞口余额
            mortgageLnciBaseInfoVO.setOpenAmount(openAmount);
      //    mortgageLnciBaseInfoVO.setAvaliableRiskAmt(mortgageLnciBaseInfoVO.getContRiskAmt().subtract(openAmount));//信贷合同可用敞口

            //7-现货押品总价值
            AppliMortgageBaseQryVO commonQueryVO = new AppliMortgageBaseQryVO();
            commonQueryVO.setSlaveContno(mortgageLnciBaseInfoVO.getBusinessNo());
            List mortgageList = bpbcmtgbaseinfoservice.getTotPriceByParam(commonQueryVO);
            if(mortgageList!=null && mortgageList.size() > 0)
            {
            	Map<String, BigDecimal> mortgageBaseInfoVO = (Map<String, BigDecimal>)mortgageList.get(0);
            	mortgageLnciBaseInfoVO.setMortgageTotalValue(mortgageBaseInfoVO.get("totPrice"));  //押品总价值
            	if(null == mortgageLnciBaseInfoVO.getMortgageTotalValue() ){
            		mortgageLnciBaseInfoVO.setMortgageTotalValue(new BigDecimal("0"));
            	}
            }

            //8-可融资金额
            //规则：可融资金额 = 押品总价值*质押率 - 敞口余额
            BigDecimal avaliableAmt = BigDecimal.ZERO;
            if(ScfBasConstant.MONI_MODEL_STATIC.equals(moniModel)){//静态
            	avaliableAmt =mortgageLnciBaseInfoVO
            			.getMortgageTotalValue().multiply(
            					mortgageLnciBaseInfoVO.getRation()).divide(new BigDecimal(100)).subtract(
            							openAmount).setScale(
            									2, BigDecimal.ROUND_HALF_UP);
            }else{
            	avaliableAmt =lowNewPrice.multiply(
            					mortgageLnciBaseInfoVO.getRation()).divide(new BigDecimal(100)).subtract(
            							openAmount).setScale(
            									2, BigDecimal.ROUND_HALF_UP);
            }

            mortgageLnciBaseInfoVO.setAvaliableAmt(avaliableAmt);

            //9-本笔风险敞口
            //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额。页面端需要根据初始现金等价物的更新而变化。
            if(mortgageLnciBaseInfoVO.getBailAmount() == null)
            {
            	mortgageLnciBaseInfoVO.setBailAmount(new BigDecimal(0));  //判空处理
            }
            if(mortgageLnciBaseInfoVO.getInitCashEqtAmt() == null)
            {
            	mortgageLnciBaseInfoVO.setInitCashEqtAmt(new BigDecimal(0));   //判空处理
            }

            BigDecimal riskAmt = mortgageLnciBaseInfoVO.getLnciAmt().subtract(mortgageLnciBaseInfoVO.getBailAmount()).subtract(mortgageLnciBaseInfoVO.getInitCashEqtAmt());
            mortgageLnciBaseInfoVO.setRiskAmt(riskAmt);
            //对照老的系统逻辑，这段应该是有问题的，故注掉
           /* moniModel = ScfBasConstant.MONI_MODEL_STATIC;*/
            if(parentProductID.equals(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE)||moniModel.equals(ScfBasConstant.MONI_MODEL_STATIC)){
            	lowNewPrice=openAmount.multiply(new BigDecimal(100)).divide(mortgageLnciBaseInfoVO.getRation(),2,BigDecimal.ROUND_HALF_UP);
            	mortgageLnciBaseInfoVO.setLowPriceNew(lowNewPrice);
            }else{
            	mortgageLnciBaseInfoVO.setLowPriceNew(lowNewPrice);
            }


        }

		return mortgageLnciBaseInfoVO;
	}
}
