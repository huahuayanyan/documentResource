package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.common.constant.IndirectCreditConstant;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICommonLoanApplyService;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.service.IScfChattelCreditService;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrDuebillAppService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.LoanApplyVO;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepayApproveCommonService;
import com.huateng.scf.bas.lan.service.IBillLoanApplyService;
import com.huateng.scf.bas.lan.service.IBillNormalLoanApplyService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.sto.nwr.vo.BillCommonQryVO;
import com.huateng.scf.sto.nwr.vo.BillLnciBaseInfoVO;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BillNormalLoanApplyServiceImpl")
public class BillNormalLoanApplyServiceImpl implements IBillNormalLoanApplyService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ProductServiceImpl")
	IProductService productservice;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
	@Resource(name = "CommonLoanApplyServiceImpl")
	ICommonLoanApplyService commonloanapplyservice;
	
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bpbcapplibaseinfodao;
	
	@Resource(name = "BillLoanApplyServiceImpl")
	IBillLoanApplyService billloanapplyservice;
	
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice;
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BLanCommonServiceImpl")
	IBLanCommonService blancommonservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	//间接额度处理
	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfindirectcreditservice;
	
	//动产额度处理类
	@Resource(name = "ScfChattelCreditServiceImpl")
	IScfChattelCreditService scfchattelcreditservice;
	
	//出账申请
	@Resource(name = "BCrrDuebillAppServiceImpl")
	IBCrrDuebillAppService bcrrduebillappservice;
	
	//信贷合同信息
	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;
	
	@Resource(name = "BLanRepayApproveCommonServiceImpl")
	IBLanRepayApproveCommonService blanrepayapprovecommonservice;
	/**
	 * 获得放款申请列表
	 * @param pageNo
	 * @param pageSize
	 * @param loanApplyQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午3:24:27
	 */
	@Override
	public Page getBillNormalLoanApplyList(int pageNo, int pageSize, LoanApplyQryVO loanApplyQryVO)
	{
		log.debug("非标仓单放款审批查询========================");
		String flag = loanApplyQryVO.getFlag();//flga==6为非标仓单
		String supplyChainPdId="";
		
		if(ScfBasConstant.PRODUCT_TYPE_CHATTLE_DYNAMIC.equals(flag))
		{//动态
			supplyChainPdId = productservice.getProductDynamic();
		}
		else if(ScfBasConstant.PRODUCT_TYPE_CHATTLE_STATIC.equals(flag))
		{//静态
			supplyChainPdId = productservice.getProductStatic();
		}
		else if(ScfBasConstant.PRODUCT_TYPE_CARPLEDGE.equals(flag))  //汽车货押
		{
			supplyChainPdId = productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE);
		}
		else if(ScfBasConstant.PRODUCT_TYPE_FOURWARE.equals(flag))
		{
			supplyChainPdId = bprdinfoservice.getProductIdByFlag(ScfBasConstant.PRODUCT_TYPE_FOURWARE);
		}
		else if(ScfBasConstant.PRODUCT_TYPE_CAR_FIRST.equals(flag))
		{
			supplyChainPdId = productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY);
		}
		else if(ScfBasConstant.PRODUCT_TYPE_NORMAL_BILL.equals(flag))
		{ // 普通仓单
			supplyChainPdId = bprdinfoservice.getProductIdByFlag(ScfBasConstant.PRODUCT_TYPE_NORMAL_BILL);
		}
		else if(ScfBasConstant.PRODUCT_TYPE_STANDARD_BILL.equals(flag))
		{ // 标准仓单
			supplyChainPdId = bprdinfoservice.getProductIdByFlag(ScfBasConstant.PRODUCT_TYPE_STANDARD_BILL);
		}
		loanApplyQryVO.setSupplyChainPdId(supplyChainPdId);
		// 查询
		loanApplyQryVO.setPageIndex(pageNo);
		loanApplyQryVO.setPageSize(pageSize);
		Page pageResult =commonloanapplyservice.getLoanApplyList(loanApplyQryVO);
		return pageResult;
	}
	
	/**
	 *  任务基本信息
	 */
	@Override
	public com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno) 
	{
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String loanWay = appliBaseInfo.getExt1();
		String process = "";
		if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay))
		{ // 普通仓单-流贷
			process = WorkflowConstant.PROCNAME_NORMAL_CASH_LOAN_APPLY;
		}
		else if(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(loanWay))
		{ // 普通仓单-银承
			process = WorkflowConstant.PROCNAME_NORMAL_BILL_LOAN_APPLY;
		}
		
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 得到普通仓单贷款申请信息
	 * @param billCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月21日上午11:17:53
	 */
	@Override
	public BillLnciBaseInfoVO BillNormalLoanApplyBaseInfoGetter(BillCommonQryVO billCommonQryVO)
	{
        String supplyChainPdId = billCommonQryVO.getSupplyChainPdId();

		//有可能产品ID为空，通过申请号重新获取下
        if(StringUtil.isEmpty(billCommonQryVO.getSupplyChainPdId()))
        {
        	BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfodao.selectByPrimaryKey(billCommonQryVO.getAppno());
        	supplyChainPdId = tblAppliBaseInfo.getSupplyChainPdId();
        	billCommonQryVO.setSupplyChainPdId(supplyChainPdId);
        }

    	Page page = billloanapplyservice.getBillNormalLoanApplyInfo(billCommonQryVO);
    	BillLnciBaseInfoVO billLnciBaseInfoVO = new BillLnciBaseInfoVO();
    	if(page.getRecords()!=null&&page.getRecords().size()>0)
    	{
    		billLnciBaseInfoVO = (BillLnciBaseInfoVO) page.getRecords().get(0);
    	}
    	if(StringUtil.isEmpty(billLnciBaseInfoVO.getSupplyChainPdId()))
    	{
    		billLnciBaseInfoVO.setSupplyChainPdId(billLnciBaseInfoVO.getProductId());
    	}
		return billLnciBaseInfoVO;
	}
	
	/**
	 * 业务管理-押品清单查询
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月24日上午10:13:34
	 */
	@Override
	public Page ApplyBillNormalListGetter(int pageNo, int pageSize, BillNormalVO billNormalVO)
	{
		String modelId = billNormalVO.getModelId();
		billNormalVO.setPageIndex(pageNo);
		billNormalVO.setPageSize(pageSize);
		if(!StringUtil.isEmpty(modelId)){
			if(modelId.equals("BillNormalCashLoanApply") || modelId.equals("BillNormalBillLoanApply")){
				billNormalVO.setStatus(ScfBasConstant.BILL_MANAGE_STATUS_PLEDGE);
			}
		}
//		Page page = billstandardpledgeappservice.getBillnormalListBySlaveContno(billNormalVO);
		Page page = null;
		return page;
	}
	
	/**
	 * 查询核库列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param billCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午2:36:47
	 */
	@Override
	public Page BillMortgageChkStockInfoGetter(int pageNo, int pageSize, BillCommonQryVO billCommonQryVO)
	{
		billCommonQryVO.setPageIndex(pageNo);
		billCommonQryVO.setPageSize(pageSize);
		Page page = billloanapplyservice.getBillNormalAppChkStockInfo(billCommonQryVO);
		return page;
	}
	
	/**
	 * 放款申请的公用的保存方法(供应链补录)
	 * @param billLnciBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午3:48:28
	 */
	@Override
	public void BillNormalLoanApplySaveUpdate(BillLnciBaseInfoVO billLnciBaseInfoVO)
	{
		LoanApplyVO loanApplyVO = new LoanApplyVO();
		loanApplyVO.setMastContcode(billLnciBaseInfoVO.getMastContcode());
		loanApplyVO.setAppno(billLnciBaseInfoVO.getAppno());

		loanApplyVO.setMastContcode(billLnciBaseInfoVO.getMastContcode());
		String appno = bpbcapplibaseinfoservice.saveLoanAppBasicInfo(loanApplyVO);
		billLnciBaseInfoVO.setAppno(appno);
		// 放款校验
		blancommonservice.checkLoanApplyInfo(appno,billLnciBaseInfoVO.getInitCashEqtAmt());

		// 保存借据申请表的信息
		billloanapplyservice.saveLoanApplyInfo(billLnciBaseInfoVO);
	}
	
	/**
	 * 动产融资放款申请填写岗信息录入提交
	 * @param billLnciBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午4:16:33
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void BillNormalLoanApplyWriteSubmitUpdater(BillLnciBaseInfoVO billLnciBaseInfoVO)
	{
		String productId = billLnciBaseInfoVO.getSupplyChainPdId();
//		String midProductId = productservice.getParentIdById(productId);
		
		if(ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(productId)//非标仓单
				||ScfBasConstant.PRODUCT_TYPE_BILL_STANDARD.equals(productId))//标准仓单
		{
			BLanAppliLnciBase tblAppliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(billLnciBaseInfoVO.getAppno());
			String hasIndirectCredit=tblAppliLnciBaseInfo.getHasIndirectCredit()==null?"":tblAppliLnciBaseInfo.getHasIndirectCredit().trim();
			if(ScfBasConstant.FLAG_ON.equals(hasIndirectCredit)){//有间接额度
				BigDecimal lnciRiskAmt = amountservice.getLnciRiskAmtByAppno(billLnciBaseInfoVO.getAppno());
				Map indirectMap=new HashMap();
				indirectMap.put(IndirectCreditConstant.APP_NO, billLnciBaseInfoVO.getAppno());
				indirectMap.put(IndirectCreditConstant.DEBIT_NO, billLnciBaseInfoVO.getDebetNo());
				indirectMap.put(IndirectCreditConstant.OPER_TYPE, ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY);//操作类型
				scfindirectcreditservice.indCreditAppliCommonProcess(indirectMap, lnciRiskAmt);
			}
		}
		//现货质押、汽车货押占用监管商额度 add by huangshuidan 2014-02-12 end
		
		//放款校验
		blancommonservice.checkLoanApplyInfo(billLnciBaseInfoVO.getAppno(),billLnciBaseInfoVO.getInitCashEqtAmt());
		//保存借据申请表的信息
		billloanapplyservice.saveLoanApplyInfo(billLnciBaseInfoVO);

//		TblSysParam id = new TblSysParam();
//		id.setParamId(SCFConstants.CCMS_PARAMID);
//		id.setParamIndex(SCFConstants.CCMS_PARAMINDEX);
//		TblSysParam tblSysParam = SysParamMgrService.getInstance().getTblSysParam(id);
//		if ((tblSysParam != null)&&(ScfBasConstant.CCMS_OPEN.equals(tblSysParam.getParamValue()))){
//			TblAppliBaseInfo tblAppliBaseInfo=SCFDAOUtils.getTblAppliBaseInfoDAO().get(tblAppliLnciInfo.getAppno());
//			G012ReqData g012ReqData= new G012ReqData();
//			g012ReqData.setCcmsAppno(tblAppliBaseInfo.getIncomeAppno());
//			g012ReqData.setOpinion(ScfBasConstant.SCF_LOAN_AGREE);
//			g012ReqData.setRemark("");
//			CcmsClientService.getInstance().doG012(g012ReqData);
//		}
		// 工作流处理
     	String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//退回首节点
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billLnciBaseInfoVO.getAppno());
		applibaseinfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(applibaseinfo);
	}
	
	/**
	 * 普通仓单融资放款申请审批拒绝
	 * @param billLnciBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:13:22
	 */
	@Override
	public void BillNormalLoanApplyRefuseSubmitUpdater(BillLnciBaseInfoVO billLnciBaseInfoVO)
	{
		BLanAppliLnciBase appliLnciInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(billLnciBaseInfoVO.getAppno());
		if(ScfBasConstant.FLAG_ON.equals(appliLnciInfo.getHasIndirectCredit())){
			//预占用合同的监管公司监管额度，客户的融资额度恢复
			scfchattelcreditservice.chattelAppliCreditProcess(billLnciBaseInfoVO.getAppno(),ScfBasConstant.BUSINESS_STATUS_APPROVAL_REFUSED);
		}
		// 工作流处理
     	String status = WorkflowConstant.WORKFLOW_TRANS_REFUSE;//审批拒绝
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(billLnciBaseInfoVO.getAppno());
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BCrrDuebillApp bCrrDuebillApp = bcrrduebillappservice.findBCrrDuebillAppByIdid(billLnciBaseInfoVO.getAppno());
		// 审批不通过，更新出账信息状态
		bCrrDuebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_REFUSED);
		bcrrduebillappservice.update(bCrrDuebillApp);
		// 更新合同可用余额
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebillApp.getAppId());
		Double lnSum = bCrrLnCon.getLnSum().doubleValue();
		Double duebillLnAmt = bCrrDuebillApp.getLnAmt().doubleValue();
		lnSum = lnSum + duebillLnAmt;
		BCrrLnCon lncon = new BCrrLnCon();
		lncon.setLnSum(BigDecimal.valueOf(lnSum));
		lncon.setAppId(bCrrLnCon.getAppId());
		bcrrlnconservice.update(lncon);
		//修改通知书状态
		blanrepayapprovecommonservice.updateNoticeStatus(billLnciBaseInfoVO.getAppno(), NoticeConstant.NOTICE_TYPE_132, NoticeConstant.NOTICE_BASE_STATUS_REFUSE);
	}
}
