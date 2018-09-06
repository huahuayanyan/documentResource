package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.common.constant.IndirectCreditConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CommonApplyDtlInfoVO;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IMtgLoanApplyDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.ApplyBuyContVO;
import com.huateng.scf.bas.lan.model.BlanApproveDetail;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.LoanApplyVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoVO;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyInfoService;
import com.huateng.scf.bas.lan.service.IBLanLoanApplyService;
import com.huateng.scf.bas.lan.service.ILoanApplyService;
import com.huateng.scf.bas.lan.service.IMtgLoanApplyService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.service.IFactFinanceBaseService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>现货质押放款	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月15日下午2:28:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月15日下午2:28:55	     新增
 *
 * </pre>
 */
@ScubeService
@Service("MtgLoanApplyServiceImpl")
public class MtgLoanApplyServiceImpl implements IMtgLoanApplyService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService blanapplilncibaseservice;
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO ibCrmBaseInfoDAO;
	
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	
	@Resource(name="MtgLoanApplyDAOImpl")
	IMtgLoanApplyDAO mtgLoanApplyDAO;
	
	@Resource(name = "ProductServiceImpl")
	IProductService productservice;
	
	@Resource(name = "LoanApplyServiceImpl")
	ILoanApplyService loanapplyservice;
	
	@Resource(name = "FactFinanceBaseServiceImpl")
	IFactFinanceBaseService factfinancebaseservice;
	
	@Resource(name = "BLanCommonServiceImpl")
	IBLanCommonService ibLanCommonService;
	
	@Resource(name = "BLanLoanApplyServiceImpl")
	IBLanLoanApplyService blanloanapplyservice;

	// 放款申请购销合同申请表
	@Resource(name = "BLanLnciBuyInfoServiceImpl")
	IBLanLnciBuyInfoService blanlncibuyinfoservice;
	
	@Resource(name = "AmountServiceImpl")
	IAmountService amountservice;
	
	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfIndirectCreditService;
	
	/**
	 *  任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno) 
	{
		log.debug("获取任务信息=======================");
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String loanWay = appliBaseInfo.getExt1();
		String process = "";
		if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay))
		{ // 动产-放款申请-流贷
			process = WorkflowConstant.PROCNAME_MORTGAGECASHLOANAPPLY;
		}
		else if(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(loanWay))
		{ // 动产-放款申请-银承
			process = WorkflowConstant.PROCNAME_MORTGAGEBILLLOANAPPLY;
		}
		
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	@Override
	public Page findMtgLoanApplyListByPage(int pageNo, int pageSize, LoanApplyQryVO loanApplyQryVO){
		
//		LoanApplyQryVO loanApplyQryVO = new LoanApplyQryVO();
//		loanApplyQryVO.getCname();
//		loanApplyQryVO.getMastContno();
//		loanApplyQryVO.getDebetId();
//		loanApplyQryVO.getAppliStatusDtl();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cname", loanApplyQryVO.getCname());
		map.put("mastContno", loanApplyQryVO.getMastContno());
		map.put("debetId", loanApplyQryVO.getDebetId());
		map.put("status", loanApplyQryVO.getAppliStatusDtl());
		map.put("proid", ScfBasConstant.PRODUCT_TYPE_PLSY);
		List<String> processNameSet = new ArrayList<String>();
		processNameSet.add(WorkflowConstant.PROCNAME_MORTGAGECASHLOANAPPLY);
		processNameSet.add(WorkflowConstant.PROCNAME_MORTGAGEBILLLOANAPPLY);
		map.put("processNameSet", processNameSet);
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> list =mtgLoanApplyDAO.findMtgLoanApplyByProductId(map,page);
		List<BlanApproveDetail> resultList = new ArrayList<BlanApproveDetail>();
		if(list.size()>0||list!=null){
			for(int i=0;i<list.size();i++){
				BlanApproveDetail approveDetail = new BlanApproveDetail();
				com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = list.get(i);
				String appno = bPbcAppliBaseInfo.getAppno();
				approveDetail.setAppno(appno);
				approveDetail.setPiid(bPbcAppliBaseInfo.getPiid());
				BLanAppliLnciBase appliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
				if(appliLnciBase != null){
					approveDetail.setDebetId(appliLnciBase.getDebetId());
				}
				approveDetail.setMastContno(bPbcAppliBaseInfo.getMastContcode());
				com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getMastContcode());
				if(bCrrLnCon != null){
					approveDetail.setVidNo(bCrrLnCon.getVidNo());
					approveDetail.setVidBusTyp(bCrrLnCon.getVidBusiTyp());
					approveDetail.setLnAmt(bCrrLnCon.getLnAmt());
					approveDetail.setLnSum(bCrrLnCon.getLnSum());
				}
				BCrmBaseInfo bCrmBaseInfo = ibCrmBaseInfoDAO.selectById(bPbcAppliBaseInfo.getCustcd());
				if(bCrmBaseInfo != null){
					approveDetail.setCustName(bCrmBaseInfo.getCname());
				}
				approveDetail.setExt1(bPbcAppliBaseInfo.getExt1());
				approveDetail.setAmt(bPbcAppliBaseInfo.getAmt());
				approveDetail.setStatus(bPbcAppliBaseInfo.getAppliStatusDtl());
				
				resultList.add(approveDetail);
			}
		}
		page.setRecords(resultList);
		return page;		
	}
	
	/**
	 * 得到动产、汽车货物的贷款的详细信息
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午2:41:48
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List LoanApplyBaseInfo(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		String supplyChainPdId = debtCommonQryVO.getSupplyChainPdId_Q();
        String midSupplyChainPdID = null;
        List list = new ArrayList();
        MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO = new MortgageLnciBaseInfoVO();
        DebtLnciBaseInfoVO debtLnciBaseInfoVO = new DebtLnciBaseInfoVO();
		//有可能产品ID为空，通过申请号重新获取下
        if(StringUtil.isEmpty(debtCommonQryVO.getSupplyChainPdId_Q()))
        {
        	BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtCommonQryVO.getAppno());
        	supplyChainPdId = tblAppliBaseInfo.getSupplyChainPdId();
        	debtCommonQryVO.setSupplyChainPdId_Q(supplyChainPdId);
        }

		midSupplyChainPdID = productservice.getParentIdById(supplyChainPdId);

			//现货类.包括：动产动态、动产静态、汽车货押
        if(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midSupplyChainPdID) || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(midSupplyChainPdID))
        {
        	mortgageLnciBaseInfoVO = loanapplyservice.getMortgageLoanApplyInfo(debtCommonQryVO);
        	list.add(mortgageLnciBaseInfoVO);
		}
		else
		{
			debtLnciBaseInfoVO = factfinancebaseservice.getInvoiceFinanceApplyInfo(debtCommonQryVO);
			list.add(debtLnciBaseInfoVO);
		}

		return list;
	}
	
	/**
	 * 放款申请的公用的保存方法
	 * @param mortgageLnciBaseInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午4:58:00
	 */
	@Override
	public void MortgageLoanApplySaveUpdate(MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO) throws ScubeBizException
	{
		String midProductId = productservice.getParentIdById(mortgageLnciBaseInfoVO.getProductId());
		//动产、汽车货押、先票后货
		if(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId) || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId))
		{

			LoanApplyVO loanApplyVO = new LoanApplyVO();
			loanApplyVO.setMastContcode(mortgageLnciBaseInfoVO.getMastContcode());
			loanApplyVO.setAppno(mortgageLnciBaseInfoVO.getAppno());

			loanApplyVO.setMastContcode(mortgageLnciBaseInfoVO.getMastContcode());
			String appno = bpbcapplibaseinfoservice.saveLoanAppBasicInfo(loanApplyVO);
			mortgageLnciBaseInfoVO.setAppno(appno);
			// 放款校验
			ibLanCommonService.checkLoanApplyInfo(appno,mortgageLnciBaseInfoVO.getInitCashEqtAmt());

			// 保存借据申请表的信息
			blanloanapplyservice.saveLoanApplyInfo(mortgageLnciBaseInfoVO);
			// 先票款后货保存购销合同出账申请信息;
			if (ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId)) 
			{
				List<ApplyBuyContVO> list = new ArrayList<ApplyBuyContVO>();
				blanlncibuyinfoservice.saveLoanApplyBuyContnoInfo(list,appno,false);
			}

		}
	}
	
	/**
	 * 流程跳转
	 * @param applibaseinfo
	 * @param status
	 * @author 	mengjiajia
	 * @date 	2017年5月9日上午10:04:22
	 */
	public void processTasks(String appno, String status, String taskComment)
	{
		BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		applibaseinfo.setComment(taskComment);
		try {
			scfWorkFlowService.processTasks(applibaseinfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 动产融资放款申请填写岗信息录入提交
	 * @param mortgageLnciBaseInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午5:25:48
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void MortgageLoanApplyWriteSubmitUpdater(MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO) throws ScubeBizException
	{

		String productId = mortgageLnciBaseInfoVO.getSupplyChainPdId();
		String midProductId = productservice.getParentIdById(productId);
		if(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId) || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(midProductId)
				|| ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId))
		{
			//放款校验
			ibLanCommonService.checkLoanApplyInfo(mortgageLnciBaseInfoVO.getAppno(),mortgageLnciBaseInfoVO.getInitCashEqtAmt());
			//保存借据申请表的信息
			blanloanapplyservice.saveLoanApplyInfo(mortgageLnciBaseInfoVO);

			// 先票款后货保存购销合同出账申请信息;
			if (ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId)) {
				List<ApplyBuyContVO> list = new ArrayList<ApplyBuyContVO>();
				blanlncibuyinfoservice.saveLoanApplyBuyContnoInfo(list,mortgageLnciBaseInfoVO.getAppno(),true);
			}
			//现货质押、汽车货押占用监管商额度 add by huangshuidan 2014-02-12 begin
			if(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(midProductId) || ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(midProductId)){
				com.huateng.scf.bas.lan.model.BLanAppliLnciBase tblAppliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(mortgageLnciBaseInfoVO.getAppno());
				String hasIndirectCredit=tblAppliLnciBaseInfo.getHasIndirectCredit()==null?"":tblAppliLnciBaseInfo.getHasIndirectCredit().trim();
				if(ScfBasConstant.FLAG_ON.equals(hasIndirectCredit)){//有间接额度
					BigDecimal lnciRiskAmt = amountservice.getLnciRiskAmtByAppno(mortgageLnciBaseInfoVO.getAppno());
					Map indirectMap=new HashMap();
					indirectMap.put(IndirectCreditConstant.APP_NO, mortgageLnciBaseInfoVO.getAppno());
					indirectMap.put(IndirectCreditConstant.DEBIT_NO, null);
					indirectMap.put(IndirectCreditConstant.OPER_TYPE, ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY);//操作类型
					scfIndirectCreditService.indCreditAppliCommonProcess(indirectMap, lnciRiskAmt);
				}
			}
			//现货质押、汽车货押占用监管商额度 add by huangshuidan 2014-02-12 end

			//现票后货占用间接额度
			if(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(midProductId)){
				com.huateng.scf.bas.lan.model.BLanAppliLnciBase tblAppliLnciBaseInfo = blanapplilncibaseservice.queryBLanAppliLnciBaseByAppno(mortgageLnciBaseInfoVO.getAppno());
				String hasIndirectCredit=tblAppliLnciBaseInfo.getHasIndirectCredit()==null?"":tblAppliLnciBaseInfo.getHasIndirectCredit().trim();

				if(ScfBasConstant.FLAG_ON.equals(hasIndirectCredit)){//有间接额度
					BigDecimal lnciRiskAmt = amountservice.getLnciRiskAmtByAppno(mortgageLnciBaseInfoVO.getAppno());
					Map indirectMap=new HashMap();
					indirectMap.put(IndirectCreditConstant.APP_NO, mortgageLnciBaseInfoVO.getAppno());
					indirectMap.put(IndirectCreditConstant.DEBIT_NO, null);
					indirectMap.put(IndirectCreditConstant.OPER_TYPE, ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY);//操作类型
					scfIndirectCreditService.indCreditAppliCommonProcess(indirectMap, lnciRiskAmt);
				}
			}
		}
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;//跳转下一节点
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(mortgageLnciBaseInfoVO.getAppno());
		applibaseinfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
		this.processTasks(mortgageLnciBaseInfoVO.getAppno(), status, mortgageLnciBaseInfoVO.getTaskComment());
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(applibaseinfo);
	}
	
	/**
	 * 动产融资放款申请退回
	 * @param applyDtlInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日上午9:23:00
	 */
	@Override
	public void LoanApplyBackSubmitUpdater(CommonApplyDtlInfoVO applyDtlInfoVO) throws ScubeBizException
	{
//		String switchType = SysParamUnit.getCcmsFlag();
//		if (SCFConstants.FLAG_ON.equals(switchType)){
//			G012ReqData g012ReqData= new  G012ReqData();
//			g012ReqData.setCcmsAppno(tblAppliBaseInfo.getIncomeAppno());
//			g012ReqData.setOpinion(SCFConstants.SCF_LOAN_BACK);
//			g012ReqData.setRemark(commAppInfoVo.getReason());
//			CcmsClientService.getInstance().doG012(g012ReqData);
//		}
		// 工作流处理
		String status = WorkflowConstant.WORKFLOW_TRANS_BACKTOLAST;//跳转下一节点
		this.processTasks(applyDtlInfoVO.getAppno(), status, applyDtlInfoVO.getComment());
	}
}
