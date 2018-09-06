package com.huateng.scf.nrec.bcp.service.impl;

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
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.common.adapter.IScfAbsAdapter;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterInput;
import com.huateng.scf.bas.common.adapter.impl.ScfCustBaseInfoAdapterOutput;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICommonLoanApplyService;
import com.huateng.scf.bas.common.service.IDebtFinancingService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.icr.constant.BIcrConstant;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBaseExample;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IRBcpDuebillAppDAO;
import com.huateng.scf.nrec.bcp.dao.domodel.BCntBcpInfoDO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillApp;
import com.huateng.scf.nrec.bcp.model.RBcpDuebillAppVO;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDuebillAppService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
import com.huateng.toprules.bizobject.PricingGroup;
import com.huateng.toprules.xom.ProductInfo;

/**
 * 
 * <p>应收类放款业务	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月23日上午10:18:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月23日上午10:18:42	     新增
 *
 * </pre>
 */
@ScubeService
@Service("RBcpDuebillAppServiceImpl")
public class RBcpDuebillAppServiceImpl implements IRBcpDuebillAppService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IRBcpDuebillAppDAO")
	IRBcpDuebillAppDAO rbcpduebillappdao;
	
	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO baccaccountinfodao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;//业务编号生成器
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	//放款申请公共方法
	@Resource(name = "CommonLoanApplyServiceImpl")
	ICommonLoanApplyService commonloanapplyservice;
	
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO blanapplilncibasedao;
	
	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactfinancebaseservice;

	@Resource(name = "DebtFinancingServiceImpl")
	IDebtFinancingService debtfinancingservice;
	
	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;
	
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO bicrinfodao;
	
	//应收合同信息
	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;
	
	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bbrpprdfactoringservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;
	
	//产品利率定价规则
	@Resource(name = "prodPricingTableRuleAdapter")
	IScfAbsAdapter prodPricingTableRuleAdapter;
	
	//产品信息
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bprdinfodao;
	
	/**
	 * 放款申请列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDuebillAppVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午3:06:15
	 */
	@Override
	public Page queryRBcpDuebillAppByPage(int pageNo, int pageSize, RBcpDuebillAppVO rBcpDuebillAppVO) {
		log.debug("放款申请列表查询===========================");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (rBcpDuebillAppVO != null) {
			//融资企业
			if(!StringUtil.isEmpty(rBcpDuebillAppVO.getCname()))
			{
				omap.put("cname", rBcpDuebillAppVO.getCname());
			}
			//贸易对手
			if(!StringUtil.isEmpty(rBcpDuebillAppVO.getBusinessName()))
			{
				omap.put("businessName", rBcpDuebillAppVO.getBusinessName());
			}
			//合同编号
			if(!StringUtil.isEmpty(rBcpDuebillAppVO.getMastContno()))
			{
				omap.put("mastContno", rBcpDuebillAppVO.getMastContno());
			}
			//业务品种
			if(!StringUtil.isEmpty(rBcpDuebillAppVO.getSupplyChainPdId()))
			{
				omap.put("supplyChainPdId", rBcpDuebillAppVO.getSupplyChainPdId());
			}
			//状态
			if(!StringUtil.isEmpty(rBcpDuebillAppVO.getAppStat()))
			{
				omap.put("appStat", rBcpDuebillAppVO.getAppStat());
			}
			//开始日期
			if(!StringUtil.isEmpty(rBcpDuebillAppVO.getStartDate()))
			{
				omap.put("startDate", rBcpDuebillAppVO.getStartDate());
			}
			//结束日期
			if(!StringUtil.isEmpty(rBcpDuebillAppVO.getEndDate()))
			{
				omap.put("endDate", rBcpDuebillAppVO.getEndDate());
			}
		}
		//查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);
		int total = extnrecbcpdao.countRBcpDuebillApp(omap);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extnrecbcpdao.queryRBcpDuebillApp(omap,page));
		page.setTotalRecord(total);
		return page;
	}
	
	/**
	 * 根据业务编号获取业务合同信息
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午4:22:50
	 */
	@Override
	public RBcpDuebillAppVO findBCntBcpInfoByMastContno(RBcpDuebillAppVO rBcpDuebillAppVO, String appno)
	{
		RBcpDuebillAppVO bcpDuebillAppVO = null;
		if(!StringUtil.isEmpty(appno))
		{
			RBcpDuebillApp duebillApp = rbcpduebillappdao.selectByPrimaryKey(appno);
			if(duebillApp!=null)
			{
				bcpDuebillAppVO = new RBcpDuebillAppVO();
				BeanUtils.copyProperties(duebillApp, bcpDuebillAppVO);
				bcpDuebillAppVO.setCname(bcrmbaseinfodao.selectById(bcpDuebillAppVO.getCustcd()).getCname());
				bcpDuebillAppVO.setBusinessName(bcrmbaseinfodao.selectById(bcpDuebillAppVO.getBusinessCustcd()).getCname());
				bcpDuebillAppVO.setLoanPercent(bcntbcpinfodao.selectByPrimaryKey(bcpDuebillAppVO.getMastContno()).getLoanPercent());
			}
		}
		else
		{
			String mastContno = rBcpDuebillAppVO.getMastContno();
			if(!StringUtil.isEmpty(mastContno))
			{
				HashMap<String, Object> omap = new HashMap<String, Object>();
				omap.put("mastContno", mastContno);
				List<BCntBcpInfoDO> list = extnrecbcpdao.queryBCntBcpInfoByPage(omap, null, false);
				if(list!=null&&list.size()>0)
				{
					BCntBcpInfoDO bcpInfo = list.get(0);
					bcpDuebillAppVO = new RBcpDuebillAppVO();
					BeanUtils.copyProperties(bcpInfo, bcpDuebillAppVO);
					bcpDuebillAppVO.setAppno(rBcpDuebillAppVO.getAppno());
				}
			}
		}
		if(bcpDuebillAppVO!=null)
		{
			BBrpPrdFactoring bBrpPrdFactoring = bbrpprdfactoringservice.findBBrpPrdFactoringByKey(bcpDuebillAppVO.getSupplyChainPdId());
			bcpDuebillAppVO.setFactType(bBrpPrdFactoring.getFactType());
			bcpDuebillAppVO.setFinancingType(bBrpPrdFactoring.getFinancingType());
			bcpDuebillAppVO.setAppno(appno);
			if(!StringUtil.isEmpty(bcpDuebillAppVO.getActBrCd()))
			{
				bcpDuebillAppVO.setActBrNm(bcrmbaseinfodao.selectById(bcpDuebillAppVO.getActBrCd()).getCname());
			}
			BAccAccountInfoExample example1 = new BAccAccountInfoExample();
			BAccAccountInfoExample.Criteria cri = example1.createCriteria();
			//结算账号、收款账号信息
			cri.andAccountNoEqualTo(bcpDuebillAppVO.getAccountNo());
			cri.andAccountTypeEqualTo("1");
			cri.andCustcdEqualTo(bcpDuebillAppVO.getCustcd());
			List<BAccAccountInfo> list1 = baccaccountinfodao.selectByExample(example1);
			if(list1!=null&&list1.size()>0)
			{
				BAccAccountInfo accountInfo = list1.get(0);
				bcpDuebillAppVO.setAccountName(accountInfo.getAccountName());
				bcpDuebillAppVO.setAccountBank(accountInfo.getOpenAccBankNm());
			}
			//回款账号信息
			BAccAccountInfoExample example2 = new BAccAccountInfoExample();
			cri = example2.createCriteria();
			cri.andAccountNoEqualTo(bcpDuebillAppVO.getReturnAccount());
			cri.andAccountTypeEqualTo("2");
			cri.andCustcdEqualTo(bcpDuebillAppVO.getCustcd());
			List<BAccAccountInfo> list2 = baccaccountinfodao.selectByExample(example2);
			if(list2!=null&&list2.size()>0)
			{
				BAccAccountInfo accountInfo = list2.get(0);
				bcpDuebillAppVO.setReturnAccountName(accountInfo.getAccountName());
				bcpDuebillAppVO.setReturnAccountBank(accountInfo.getOpenAccBankNm());
			}
			//资金提供方账号信息
			if(!StringUtil.isEmpty(bcpDuebillAppVO.getPayActNo()))
			{
				BAccAccountInfoExample example3 = new BAccAccountInfoExample();
				cri = example3.createCriteria();
				cri.andAccountNoEqualTo(bcpDuebillAppVO.getPayActNo());
				cri.andAccountTypeEqualTo("1");
				cri.andCustcdEqualTo(bcpDuebillAppVO.getActBrCd());
				List<BAccAccountInfo> list3 = baccaccountinfodao.selectByExample(example3);
				if(list3!=null&&list3.size()>0)
				{
					BAccAccountInfo accountInfo = list3.get(0);
					bcpDuebillAppVO.setPayActName(accountInfo.getAccountName());
					bcpDuebillAppVO.setPayActBank(accountInfo.getOpenAccBankNm());
				}
			}
			if(!StringUtil.isEmpty(bcpDuebillAppVO.getCrNo()))
			{
				BIcrInfo bIcrInfo = bicrinfodao.selectByPrimaryKey(bcpDuebillAppVO.getCrNo());
				bcpDuebillAppVO.setAbleNum(bIcrInfo.getCreditUsableAmount());
				bcpDuebillAppVO.setTotalPrice(bIcrInfo.getCreditAmount());
			}
			if(ScfBasConstant.T_FINANCING_TYPE_POOL.equals(bcpDuebillAppVO.getFinancingType()))
			{
				bcpDuebillAppVO.setPoolRiskAmt(nfactfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(bcpDuebillAppVO.getMastContno()));//池敞口
				BigDecimal poolRemainDebtAmt=new BigDecimal(0.00);
				BigDecimal poolUseableAmount=new BigDecimal(0.00);//R_BCP_DEBT_POOL中可融资余额
				DebtCommonQryVO commonQueryVO=new DebtCommonQryVO();
				commonQueryVO.setMastContno(bcpDuebillAppVO.getMastContno());
				commonQueryVO.setCustcdBuyer_Q(bcpDuebillAppVO.getBusinessCustcd());
				List<RBcpDebtPool> poollist= nrbcpdebtpoolservice.getInPoolInfo(commonQueryVO);
				if(poollist!=null&&poollist.size()>0){
					RBcpDebtPool debtPool = poollist.get(0);
					if(debtPool!=null){
						poolRemainDebtAmt = debtPool.getTotalDebtRemainAmount();
						poolUseableAmount = debtPool.getPoolUseableAmount();
						bcpDuebillAppVO.setTotalBillsAmount(poolRemainDebtAmt);
						bcpDuebillAppVO.setPoolUseableAmount(poolUseableAmount);
					}
				}
			}
		}
		return bcpDuebillAppVO;
	}
	
	/**
	 * 查询融资客户授信额度信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午5:30:01
	 */
	@Override
	public Page queryCustBDcrLinInf(int pageNo,int pageSize,HashMap<String, Object> value)
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		//1.间接额度 CREDIT_CLASS=3
		//2.买方保理额度 CREDIT_TYPE=ICR20161115000000756
		//3.节点类型 NODE_TYPE=3
		//3.已领用，切客户编号符合放款申请条件
		//占用买方信用额度
		omap.putAll(value);
		omap.put("creditClass",BIcrConstant.CREDIT_CLASS_INDIRECT);
//		omap.put("nodeType", BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		omap.put("nodeType", BIcrConstant.CREDIT_NODE_TYPE_LEAF);
		omap.put("creditType", "ICR20161115000000756");
		omap.put("status", ScfBasConstant.FLAG_ON);
		int total = extnrecbcpdao.countCustBIcrInfo(omap);
		if(total==0)
		{
			throw new ScubeBizException("融资企业的买方保理额度未维护！");
		}
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extnrecbcpdao.queryCustBIcrInfo(omap,page));
		page.setTotalRecord(total);
		return page;
	}
	
	/**
	 * 保存修改放款信息
	 * @param rBcpDuebillAppVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午7:31:06
	 */
	@Override
	@Transactional
	public String DebtFinancingApplySaveUpdate(RBcpDuebillAppVO rBcpDuebillAppVO,List<RBcpAppliBussDtl> debtList)
	{
		UserInfo userInfo = ContextHolder.getUserInfo();
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		String appno = rBcpDuebillAppVO.getAppno();
		RBcpDuebillApp duebillApp = new RBcpDuebillApp();
		rBcpDuebillAppVO.setBillNum(new BigDecimal(debtList.size()));
		BeanUtils.copyProperties(rBcpDuebillAppVO, duebillApp);
		if(!StringUtil.isEmpty(appno))
		{
			duebillApp.setLnSum(duebillApp.getLnAmt());
			duebillApp.setLstUpdTlr(userInfo.getTlrNo());
			duebillApp.setLstUpdTlrNm(userInfo.getTlrName());
			duebillApp.setLstUpdDt(ScfDateUtil.getStringDate(new Date()));
			duebillApp.setLstUpdBrCd(bctlVO.getBrNo());
			duebillApp.setLstUpdBrNm(bctlVO.getBrName());
			rbcpduebillappdao.updateByPrimaryKeySelective(duebillApp);
			this.saveFactoringLanAppliBase(rBcpDuebillAppVO);
		}
		else
		{
			//获取当前业务品种对用流程模板
			HashMap<String, String> flowMap = scfWorkFlowService.getWkflowMode(rBcpDuebillAppVO.getMastContno());
			String modelId = flowMap.get("modelId");
			String appliType = flowMap.get("appliType"); //流程申请类型
			rBcpDuebillAppVO.setAppliType(appliType);
			rBcpDuebillAppVO.setProcessName(modelId);
			//保存业务申请基本信息
			appno = this.saveFactoringLanAppliBase(rBcpDuebillAppVO);
			//保存放款申请基本信息
			duebillApp.setAppno(appno);
			duebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_UNSUBMIT);
			duebillApp.setLnSum(duebillApp.getLnAmt());
			duebillApp.setTlrNo(userInfo.getTlrNo());
			duebillApp.setTlrNm(userInfo.getTlrName());
			duebillApp.setInpDt(ScfDateUtil.getStringDate(new Date()));
			duebillApp.setBrCd(bctlVO.getBrNo());
			duebillApp.setBrNm(bctlVO.getBrName());
			duebillApp.setLstUpdTlr(userInfo.getTlrNo());
			duebillApp.setLstUpdTlrNm(userInfo.getTlrName());
			duebillApp.setLstUpdDt(ScfDateUtil.getStringDate(new Date()));
			duebillApp.setLstUpdBrCd(bctlVO.getBrNo());
			duebillApp.setLstUpdBrNm(bctlVO.getBrName());
			rbcpduebillappdao.insertSelective(duebillApp);
		}
		//更新R_BCP_APPLI_BUSS_INFO
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase appliLnciBase = blanapplilncibasedao.selectByAppno(appno);
		DebtLnciBaseInfoVO lnciVO = new DebtLnciBaseInfoVO();
		BeanUtils.copyProperties(appliLnciBase, lnciVO);
		lnciVO.setCustcdBuyer(rBcpDuebillAppVO.getBusinessCustcd());
		lnciVO.setAvaliableAmt(lnciVO.getLnciAmt());
		commonloanapplyservice.updateAppliBussInfoWithLnciVO(lnciVO, rBcpDuebillAppVO.getFinancingType());
		//保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
		commonloanapplyservice.saveAppliBussDetall(debtList,lnciVO.getAppno(),rBcpDuebillAppVO.getFinancingType());//添加发票
		//更新TBL_APPLI_LNCI_BASE_INFO
//		commonloanapplyservice.updateAppliLnciBaseInfo(lnciVO);
		return appno;
	}
	
	/**
	 * 详情页提交按钮(发起流程并跳转)
	 * @param rBcpDuebillAppVO
	 * @param debtList
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午3:01:43
	 */
	@Override
	@Transactional
	public void DebtFinancingApplySubmitUpdate(RBcpDuebillAppVO rBcpDuebillAppVO,List<RBcpAppliBussDtl> debtList)
	{
		String appno = rBcpDuebillAppVO.getAppno();
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		
		BCntBcpInfo bCntBcpInfo = bcntbcpinfodao.selectByPrimaryKey(rBcpDuebillAppVO.getMastContno());
		String factType = bCntBcpInfo.getFactType();//保理类型
		
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase appliLnciBase = blanapplilncibasedao.selectByAppno(appno);
		DebtLnciBaseInfoVO lnciVO = new DebtLnciBaseInfoVO();
		BeanUtils.copyProperties(appliLnciBase, lnciVO);
		if(!StringUtil.isEmpty(rBcpDuebillAppVO.getLoanRemainingAmount()))
		{//页面详情页使用原值
			lnciVO.setTotalBillsAmount(rBcpDuebillAppVO.getLoanRemainingAmount());
		}
		else
		{//列表页进入则根据保理类型区分
			BigDecimal loanRemainingAmount = new BigDecimal(0);
			if(debtList!=null&&debtList.size()>0)
			{//业务申请明细不为空，则说明不为池融资
				for(RBcpAppliBussDtl appliBussDtl:debtList)
				{
					loanRemainingAmount = loanRemainingAmount.add(appliBussDtl.getLoanRemainingAmount());
				}
			}
			else
			{//从列表页点击提交进入方法时，池融资不保存明细信息，故此处根据锁定appno获取应收账款信息
				if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)
						||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))
				{//国内保理池，应收账款质押池，出口退税池
					DebtCommonQryVO commonQueryVO=new DebtCommonQryVO();
					commonQueryVO.setMastContno(rBcpDuebillAppVO.getMastContno());
					commonQueryVO.setCustcdBuyer_Q(rBcpDuebillAppVO.getBusinessCustcd());
					List<RBcpDebtPool> poollist= nrbcpdebtpoolservice.getInPoolInfo(commonQueryVO);
					if(poollist!=null&&poollist.size()>0){
						RBcpDebtPool debtPool = poollist.get(0);
						if(debtPool!=null){
							//池应收账款可融资余额
							loanRemainingAmount = debtPool.getPoolUseableAmount();
						}
					}
				}
			}
			lnciVO.setTotalBillsAmount(loanRemainingAmount);
		}
		//放款金额校验
		commonloanapplyservice.checkFinanceApplyInfo(lnciVO,rBcpDuebillAppVO.getFactType());
		//更新业务申请信息
		rBcpDuebillAppVO.setAppStat(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		UserInfo userInfo = ContextHolder.getUserInfo();
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		RBcpDuebillApp duebillApp = new RBcpDuebillApp();
		rBcpDuebillAppVO.setBillNum(new BigDecimal(debtList.size()));
		BeanUtils.copyProperties(rBcpDuebillAppVO, duebillApp);
		duebillApp.setLstUpdTlr(userInfo.getTlrNo());
		duebillApp.setLstUpdTlrNm(userInfo.getTlrName());
		duebillApp.setLstUpdDt(ScfDateUtil.getStringDate(new Date()));
		duebillApp.setLstUpdBrCd(bctlVO.getBrNo());
		duebillApp.setLstUpdBrNm(bctlVO.getBrName());
		try
		{
			rbcpduebillappdao.updateByPrimaryKeySelective(duebillApp);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新业务申请信息异常");
		}
		this.saveFactoringLanAppliBase(rBcpDuebillAppVO);
		//更新R_BCP_APPLI_BUSS_INFO
		commonloanapplyservice.updateAppliBussInfoWithLnciVO(lnciVO, rBcpDuebillAppVO.getFinancingType());//ScfBasConstant.T_FINANCING_TYPE_INVOICE
		//保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
		commonloanapplyservice.saveAppliBussDetall(debtList,lnciVO.getAppno(),rBcpDuebillAppVO.getFinancingType());//添加发票

		//流程操作
		scfWorkFlowService.FactoringProcessDone(appliBaseInfo);
	}
	
	/**
	 * 页面列表提交按钮(暂不使用)
	 * @param rBcpDuebillAppVO
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午2:54:08
	 */
	@Override
	@Transactional
	public void submit(RBcpDuebillAppVO rBcpDuebillAppVO)
	{
		List<RBcpAppliBussDtl> debtList = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(rBcpDuebillAppVO.getAppno());
		if(debtList!=null)
		{
			for(RBcpAppliBussDtl dtl:debtList)
			{
				dtl.setId(dtl.getDebtId());
			}
		}
		this.DebtFinancingApplySubmitUpdate(rBcpDuebillAppVO, debtList);
	}
	
	/**
	 * 保存更新业务申请信息及借据申请信息
	 * @param rBcpDuebillAppVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月6日下午1:55:13
	 */
	public String saveFactoringLanAppliBase(RBcpDuebillAppVO rBcpDuebillAppVO)
	{
		//保存信息到申请基本信息表
		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		BeanUtils.copyProperties(rBcpDuebillAppVO, bPbcAppliBaseInfo);
		String appno = rBcpDuebillAppVO.getAppno();
		if(!StringUtil.isEmpty(appno))
		{
			bPbcAppliBaseInfo.setAmt(rBcpDuebillAppVO.getLnAmt());//出账金额
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		else
		{
			appno = ibSysSerialNoService.genSerialNo("FFK_APP_NO");
			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setMoniCustcd(rBcpDuebillAppVO.getBusinessCustcd());
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
			bPbcAppliBaseInfo.setProcessTemplateName(rBcpDuebillAppVO.getProcessName());//工作流模版名
			bPbcAppliBaseInfo.setAmt(rBcpDuebillAppVO.getLnAmt());//出账金额
			bPbcAppliBaseInfo.setAppliType(rBcpDuebillAppVO.getAppliType());//业务申请类型
			bPbcAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT);//申请状态-已提交提交
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);//供应链补录--已提交
			bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);//默认取到标识为供应链
			bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);//默认流程未结束
			bPbcAppliBaseInfo.setCurcd(ScfBasConstant.RMB);//币种
			bPbcAppliBaseInfo.setExt1(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL);//出账方式
			bPbcAppliBaseInfo.setMastContcode(rBcpDuebillAppVO.getMastContno());
			bPbcAppliBaseInfo.setSlaveContno(rBcpDuebillAppVO.getMastContno());
			bpbcapplibaseinfoservice.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		
		//借据申请信息保存
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBase = blanapplilncibasedao.selectByAppno(appno);
		if(bLanAppliLnciBase != null){//判断是否保存过
			try {
				bLanAppliLnciBase.setLnciAmt(rBcpDuebillAppVO.getLnAmt());
				bLanAppliLnciBase.setLnciBal(rBcpDuebillAppVO.getLnAmt());
				blanapplilncibasedao.updateByPrimaryKey(bLanAppliLnciBase);
			} catch (Exception e) {
				log.info("借据申请表更新异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10002),
						BLanErrorConstant.SCF_BAS_LAN_10002);
			}
		}else{
			BLanAppliLnciBase appliLnciBase = new BLanAppliLnciBase();
			BeanUtils.copyProperties(rBcpDuebillAppVO, appliLnciBase);
			appliLnciBase.setLoanUse(null);//贷款用途
			appliLnciBase.setMgrno(ContextHolder.getUserInfo().getTlrNo());//客户经理
			appliLnciBase.setLnciType(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL);//出账方式
			appliLnciBase.setDebetId(appno);//承兑协议号
			appliLnciBase.setOrgDebetId(null);//原来借据信息
			appliLnciBase.setProductId(rBcpDuebillAppVO.getSupplyChainPdId());//产品id
			appliLnciBase.setRate(rBcpDuebillAppVO.getBlFeeRate());//执行利率
			appliLnciBase.setBussBrcode(ContextHolder.getOrgInfo().getBrNo());//申请机构号
			appliLnciBase.setAppno(appno);
			appliLnciBase.setLoanAppno(appno);
			appliLnciBase.setDebetNo(null);
			appliLnciBase.setLnciAmt(rBcpDuebillAppVO.getLnAmt());
			appliLnciBase.setLnciBal(rBcpDuebillAppVO.getLnAmt());
			appliLnciBase.setMastContcode(rBcpDuebillAppVO.getMastContno());
			appliLnciBase.setSlaveContno(rBcpDuebillAppVO.getMastContno());
			appliLnciBase.setHasIndirectCredit(ScfBasConstant.FLAG_ON);
			appliLnciBase.setCreditCustcd(rBcpDuebillAppVO.getBusinessCustcd());
			appliLnciBase.setOtherCustcd(rBcpDuebillAppVO.getBusinessCustcd());
			appliLnciBase.setCreditNo(rBcpDuebillAppVO.getCrNo());
			try {
				commonloanapplyservice.saveBLanAppliLnciBase(appno,appliLnciBase);
			} catch (Exception e) {
				log.info("借据申请表插入异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10001),
						BLanErrorConstant.SCF_BAS_LAN_10001);
			}
		}
		return appno;
	}
	
	/**
	 * 应收账款列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午2:18:53
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page InvoiceFinancingDebtQueryGetter(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO)
	{
		String appno = debtCommonQryVO.getAppno_Q();
		String flag = debtCommonQryVO.getFlag();
		Page pageResult = new Page();
		if(!StringUtil.isEmpty(appno))
		{
			pageResult = nfactfinancebaseservice.queryAppliBussDetailByAppnoDebt(pageNo, pageSize, appno);
		}
		List<AppliBussDetailVO> list =pageResult.getRecords();
		List resultList =new ArrayList();
		debtCommonQryVO.setPageIndex(pageNo);
		debtCommonQryVO.setPageSize(pageSize);
		if(flag!=null&&flag.equals("2"))
		{
			Page pageQueryResult = debtfinancingservice.getInvoiceFinancingQuery(debtCommonQryVO);
			List<DebtBillsInfoVO> list1 = pageQueryResult.getRecords();//正式表读取发票
			if(list1!=null && list1.size()>0)
			{
				for(DebtBillsInfoVO debtVO:list1)
				{
					debtVO.setDebtId(debtVO.getId());
					if(list!=null){
						for(int i = 0; i < list.size() ; i++){
							AppliBussDetailVO applyDebtVO = (AppliBussDetailVO) list.get(i);
							if(debtVO.getId().equals(applyDebtVO.getDebtId())){
								debtVO.setId(applyDebtVO.getDebtId());
								debtVO.setDebtId(applyDebtVO.getDebtId());
								list.remove(i);
								break;
							}
						}
					}
					resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
				}
			}
		}
		else
		{
			if(list!=null)
			{
				for(AppliBussDetailVO applVO:list)
				{
					applVO.setId(applVO.getDebtId());
					resultList.add(applVO);//bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
		}	
		pageResult.setRecords(resultList);
		return pageResult;
	}
	
	/**
	 * 发票融资申请发票添加
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午4:24:32
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page InvoiceFinancingAddQryGetter(int pageNo, int pageSize, 
			DebtCommonQryVO debtCommonQryVO, List<RBcpAppliBussDtl> list)
	{
		List<String> debtIds = new ArrayList<String>();
		if(list!=null&&list.size()>0)
		{
			for(RBcpAppliBussDtl bussDtl:list)
			{
				debtIds.add(bussDtl.getDebtId());
			}
		}
		if(debtIds!=null&&debtIds.size()>0)
		{
			debtCommonQryVO.setBussTypeList_Q(debtIds);
		}
		debtCommonQryVO.setPageIndex(pageNo);
		debtCommonQryVO.setPageSize(pageSize);
		if(!StringUtil.isEmpty(debtCommonQryVO.getAppno_Q()))
		{
			debtCommonQryVO.setAppno(debtCommonQryVO.getAppno_Q());
		}
		Page page = debtfinancingservice.getInvoiceFinancingAddQry(debtCommonQryVO);
		List<NDebtBillsInfoVO> resultList = page.getRecords();
		if(resultList!=null&&resultList.size()>0)
		{
			for(NDebtBillsInfoVO billsInfoVO:resultList)
			{
				billsInfoVO.setLoanAmount(billsInfoVO.getLoanRemainingAmount());
			}
		}
		return page;
	}
	
	/**
	 * 应收账款单据查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月25日下午8:28:42
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page DebtFindGetter(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO)
	{
		debtCommonQryVO.setPageIndex(pageNo);
		debtCommonQryVO.setPageSize(pageSize);
		if(!StringUtil.isEmpty(debtCommonQryVO.getAppno_Q()))
		{
			debtCommonQryVO.setAppno(debtCommonQryVO.getAppno_Q());
		}
		Page page = debtfinancingservice.getDebtInfoQuery(debtCommonQryVO, debtCommonQryVO.isPageFlag());
		List<NDebtBillsInfoVO> resultList = page.getRecords();
		if(resultList!=null&&resultList.size()>0)
		{
			for(NDebtBillsInfoVO billsInfoVO:resultList)
			{
				billsInfoVO.setLoanAmount(billsInfoVO.getBillsAmountView());
			}
		}
		return page;
	}
	
	/**
	 * 根据主键删除信息
	 * @param appno
	 * @author 	mengjiajia
	 * @date 	2017年5月25日上午11:06:53
	 */
	@Override
	@Transactional
	public void delete(String appno)
	{
		if(!StringUtil.isEmpty(appno))
		{
			try
			{
				//1.删除放款申请基本信息
				rbcpduebillappdao.deleteByPrimaryKey(appno);
				//2.删除业务申请基本信息
				bpbcapplibaseinfoservice.deleteBPbcAppliBaseInfo(appno);
				//3.删除借据申请基本信息
				BLanAppliLnciBaseExample example = new BLanAppliLnciBaseExample();
				BLanAppliLnciBaseExample.Criteria cri = example.createCriteria();
				cri.andAppnoEqualTo(appno);
				blanapplilncibasedao.deleteByExample(example);
				//4.删除业务基本信息
				nrbcpapplibussinfoservice.deleteByAppno(appno);
				//5.删除业务明细信息并解锁应收账款
				nrbcpapplibussdtlservice.deleteRBcpAppliBussDtlAndReleaseDebt(appno);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("删除异常");
			}
		}
	}
	
	/**
	 * 通过利率定价模型获取利率信息
	 * @param productRate
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月20日上午9:56:59
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal CheckActInt(String productId)
	{
		BPrdInfo info = bprdinfodao.selectByPrimaryKey(productId);
		String productRate = "";
		if(info!=null)
		{
			productRate = info.getExt1();
		}
		if(StringUtil.isEmpty(productRate))
		{
			throw new ScubeBizException("该产品利率定价模型未定义，请在产品配置中定义！");
		}
		ScfCustBaseInfoAdapterInput input = new ScfCustBaseInfoAdapterInput();
		PricingGroup group = new PricingGroup();
		group.setPricId(productRate);
		input.setPricingGroup(group);
		List<ScfCustBaseInfoAdapterOutput> outputs = (List<ScfCustBaseInfoAdapterOutput>) prodPricingTableRuleAdapter.process(input);
		BigDecimal normPricing = new BigDecimal(0.15);
		if(outputs!=null&&outputs.size()>0)
		{
			ProductInfo productInfo = outputs.get(0).getProductInfo();
			normPricing = productInfo.getNormPricing().setScale(2,BigDecimal.ROUND_HALF_DOWN);
		}
		return normPricing;
	}
}
