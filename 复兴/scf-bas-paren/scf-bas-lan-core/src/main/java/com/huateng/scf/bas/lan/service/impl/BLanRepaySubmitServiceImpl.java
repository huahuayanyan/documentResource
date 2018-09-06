package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.brp.dao.IBBrpPrdFactoringDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoring;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.IBIcrPrdBindDAO;
import com.huateng.scf.bas.icr.dao.IBIcrTypeDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBind;
import com.huateng.scf.bas.icr.dao.model.BIcrType;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanCreditProcessBussAmt;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepaySubmitService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月10日下午1:39:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * liph		2016年12月10日下午1:39:20	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BLanRepaySubmitServiceImpl")
public class BLanRepaySubmitServiceImpl implements IBLanRepaySubmitService{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO ibCrrDuebillAppDAO;
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO irBcpAppliBussDtlDAO;
	@Resource(name = "BBrpPrdFactoringDAO")
	IBBrpPrdFactoringDAO ibBrpPrdFactoringDAO;
	@Resource(name = "BIcrPrdBindDAO")
	IBIcrPrdBindDAO ibIcrPrdBindDAO;
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO ibIcrInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO ibCntDebtInfoDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO irBcpAppliBussInfoDAO;
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO irBcpDebtBaseInfoDAO;
	@Resource(name = "BPrdCreditBindDAO")
	IBPrdCreditBindDAO ibPrdCreditBindDAO;
	@Resource(name = "BIcrTypeDAO")
	IBIcrTypeDAO ibIcrTypeDAO;
	@Resource(name = "BLanCommonServiceImpl")
	IBLanCommonService ibLanCommonService;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO ibPrdInfoDAO;
	@Autowired
	private ITaskService taskService;
	@Autowired
	private IProcessService processService;
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	
	@Transactional
	public void repaysubmit(String appno,BCrrDueBillDetail bCrrDueBillDetail) throws FlowsharpException {
		String mastContno = bCrrDueBillDetail.getAppId();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		String prdid = bCrrLnCon.getPrdId();//判断是银承还是流贷
		BCrrDueBillDetail dueDetail = new BCrrDueBillDetail();
		BeanUtils.copyProperties(bCrrDueBillDetail, dueDetail);
		RBcpAppliBussDtl rBussDtl = null;
		BigDecimal remainingAmt = BigDecimal.ZERO;
		if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(prdid)){
			List<RBcpAppliBussDtl> bussDtls = new ArrayList<RBcpAppliBussDtl>();
			if(ScfBasConstant.PRODUCT_TYPE_GNFAC.equals(bCrrDueBillDetail.getVidBusTyp())){
				bussDtls = irBcpAppliBussDtlDAO.selectByAppno(appno);
				if(bussDtls.size()>0&&bussDtls != null){
					for(int i=0;i<bussDtls.size();i++){
						rBussDtl = bussDtls.get(i);
						BigDecimal reAmt = rBussDtl.getRemainingAmount()==null?BigDecimal.ZERO:rBussDtl.getRemainingAmount();
						remainingAmt = remainingAmt.add(reAmt);
					}
				}
				dueDetail.setYsTotalAmt(remainingAmt);//应收账款总额
				//间接额度处理
				if("1".equals(dueDetail.getIndrctCrdt())){
					BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
					List<BIcrPrdBind> prdBindList = ibIcrPrdBindDAO.selectByPid(bLanAppliLnciBase.getProductId());
					dueDetail.setDrawbackTerm(bLanAppliLnciBase.getDrawbackTerm()==null?BigDecimal.ZERO:bLanAppliLnciBase.getDrawbackTerm());//赎货期限
					String creditType = "";
					if((prdBindList.size()>0)){
						BIcrPrdBind bind = prdBindList.get(0);
						creditType = bind.getCreditType();
					}
					
					//间接额度表
					BIcrInfo bIcrInfo = new BIcrInfo();
					bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
					bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
					bIcrInfo.setCustcd(bLanAppliLnciBase.getCreditCustcd());
					bIcrInfo.setOtherCustcd(bLanAppliLnciBase.getCustcd());
					bIcrInfo.setCreditType(creditType);
					bIcrInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);//有效
					List<BIcrInfo> icrList = ibIcrInfoDAO.selectByParam(bIcrInfo);
					BigDecimal creditUseBal = BigDecimal.ZERO;
					if(icrList.size()>0){
						BIcrInfo bInfo = icrList.get(0);
						creditUseBal = bInfo.getCreditUsableAmount();
						dueDetail.setCreditBalAmt(creditUseBal);//间接额度可用额度
					}
				}
			}
			String factType = "";
			if(dueDetail != null){
				BBrpPrdFactoring bBrpPrdFactoring = ibBrpPrdFactoringDAO.selectByPrimaryKey(bCrrLnCon.getVidBusiTyp());//根据业务品种获取保理业务类型
				factType = bBrpPrdFactoring.getFactType();
			}
			
			//放款金额校验
			this.checkFinanceApplyInfo(dueDetail,factType);
			//更新申请状态
			try {
				this.updateAppliBaseInfoState(appno,WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
				this.updateAppliBussInfo(dueDetail,ScfBasConstant.T_FINANCING_TYPE_INVOICE);
			} catch (Exception e) {
				log.info("更新申请状态异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
						BLanErrorConstant.SCF_BAS_LAN_20000);
			}
			//保存到业务申请业务明细表
			try {
				this.saveAppliBussDtl(bussDtls,dueDetail.getId());
			} catch (Exception e) {
				log.info("保存业务申请业务明细表异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20019),
						BLanErrorConstant.SCF_BAS_LAN_20019);
			}
			try {
				this.updateAppliLnciBaseInfo(dueDetail);
			} catch (Exception e) {
				log.info("更新申请借据表异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10002),
						BLanErrorConstant.SCF_BAS_LAN_10002);
			}
			//间接额度处理------先注释掉
			/*BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
			String hasIndirectCredit = bLanAppliLnciBase.getHasIndirectCredit()==null?"":bLanAppliLnciBase.getHasIndirectCredit().trim();
			if(ScfBasConstant.FLAG_ON.equals(hasIndirectCredit)){
				BigDecimal lnciRiskAmt = this.getLnciRiskAmtByAppno(appno);
				this.indirectCreditAppliCommonProcess(appno,null,ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY,lnciRiskAmt);
			}*/
			//节点调整提交
			BPbcAppliBaseInfo bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
			String processId= bPbcAppliBaseInfo.getPiid();
			UserInfo user = ContextHolder.getUserInfo();
			String userId = user.getTlrNo();
			String taskId = WorkflowConstant.WORKFLOW_BCRRDUEBILL_ADD;
			taskService.takeTask(taskId, processId, userId);
			String comment = "申请提交";
			if(!StringUtil.isEmpty(bCrrDueBillDetail.getTaskComment()))
			{
				comment = bCrrDueBillDetail.getTaskComment();
			}
			taskService.completeTask(taskId, processId, userId, comment);
			// 节点转移
			processService.signal(processId, WorkflowConstant.WORKFLOW_BCRRDUEBILL_CONFIRM);
			
			bPbcAppliBaseInfo.setApprover(userId); // 当前已审批人员
			bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
			bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new Date())); // 当前已审批日期
			bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
			ibPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
		}
	}
	
	/**
	 * @author liph
	 *  保里放款金额校验
	 */
	@Transactional
	public void checkFinanceApplyInfo(BCrrDueBillDetail bCrrDueBillDetail,String factType){
		String appno = bCrrDueBillDetail.getId();
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		String mastContno = "";
		if(bLanAppliLnciBase != null){
			mastContno = bLanAppliLnciBase.getMastContno();
		}
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		if(bCrrLnCon == null){
			log.info("信贷合同未获取到");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018),
					BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		BCntDebtInfo bCntDebtInfo = ibCntDebtInfoDAO.selectByPrimaryKey(bCrrLnCon.getVidNo());
		String cycle = bCrrLnCon.getControlType();//是否循环
		String protocolNo = bCntDebtInfo.getDebtContno();//关联业务协议/合同号
		List list = ibLanLnciBaseDAO.selectByCondition(protocolNo);//记录状态，是否结清，协议号
		BigDecimal totalLnciamt = BigDecimal.ZERO;   //合同项下的借据总金额
		BigDecimal totalContRist = BigDecimal.ZERO;  //业务合同下的的借据敞口余额
		BigDecimal tempRistAmt = BigDecimal.ZERO;
		BigDecimal contAmount = bCrrLnCon.getLnAmt(); //信贷合同金额
		//BigDecimal riskAmt = bCrrLnCon.getLnSum();// 信贷合同可用金额
		BigDecimal riskAmt = BigDecimal.ZERO;// 信贷合同可用敞口
		if(bLanAppliLnciBase.getBailAmount() == null){
			bLanAppliLnciBase.setBailAmount(BigDecimal.ZERO);
		}
		tempRistAmt = bLanAppliLnciBase.getLnciAmt().subtract(bLanAppliLnciBase.getBailAmount()).subtract(bCrrDueBillDetail.getCsxjdjwbl());
		if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)||ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)){
			if(!StringUtil.isEmpty(bCrrDueBillDetail.getIndrctCrdt())&&"1".equals(bCrrDueBillDetail.getIndrctCrdt())){
				if(tempRistAmt.compareTo(bCrrDueBillDetail.getCreditBalAmt())>0){
					log.info("保理买方间接额度可用余额不足！");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20007),
							BLanErrorConstant.SCF_BAS_LAN_20007);
				}
			}
		}
		if(list !=null && list.size() > 0){
			BLanLnciBase bLanLnciBase = null;
			BigDecimal addBailAmount;
			BigDecimal bailAmount;
			BigDecimal initCashEqtAmt;
			BigDecimal addCashEqtAmt;
			BigDecimal lnciBal;
			for(int i=0;i<list.size();i++){
				bLanLnciBase = (BLanLnciBase) list.get(i);
				//借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
				addBailAmount = (bLanLnciBase.getAddBailAmount()==null?BigDecimal.ZERO:bLanLnciBase.getAddBailAmount());
				bailAmount = (bLanLnciBase.getBailAmount()== null?BigDecimal.ZERO:bLanLnciBase.getBailAmount());
				initCashEqtAmt = (bLanLnciBase.getInitCashEqtAmt()==null?BigDecimal.ZERO:bLanLnciBase.getInitCashEqtAmt());
				addCashEqtAmt = (bLanLnciBase.getAddCashEqtAmt()==null?BigDecimal.ZERO:bLanLnciBase.getAddCashEqtAmt());
				lnciBal = bLanLnciBase.getLnciBal();
				totalContRist = totalContRist.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
			}
		}
		//增加流程中业务合同的出账金额
		List<Map> flowList = ibLanAppliLnciBaseDAO.getFlowRiskAmtByVidno(protocolNo);
		if(flowList.size()>0){
			Map map = flowList.get(0);
			BigDecimal bb = BigDecimal.ZERO;
			if(map.get("AMT")!=null){
				bb = (BigDecimal) map.get("AMT");
			}
			BigDecimal fowBigAmt = flowList.get(0)==null?BigDecimal.ZERO:bb;
			totalContRist = totalContRist.add(fowBigAmt);
		}
		//获得所有的出账金额
		totalLnciamt = ibLanLnciBaseDAO.getTotalLoanAmtInContInfo(bCrrLnCon.getAppId());
		//获取合同下的敞口余额
		BigDecimal contRistAmtTemp = this.getContRiskAmtByCycle(bCrrLnCon.getAppId(),cycle);
		riskAmt = bCrrLnCon.getLnAmt() == null ? BigDecimal.ZERO : bCrrLnCon.getLnAmt().subtract(contRistAmtTemp);
		//1-校验合同的可用额度是否足够
		//1.1 不可循环额度合同。
		// 规则：信贷合同项下所有借据金额 + 本次放款金额 <= 信贷合同金额
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)) {
			List<Map> listTemp = ibLanAppliLnciBaseDAO.getFlowKindsOfSumByMastContno(bCrrLnCon.getAppId());
			if(listTemp.size()>0){
				Map map = listTemp.get(0);
				BigDecimal flowLnciRiskAmt = BigDecimal.ZERO;
				if(map.get("LNCIAMT")!=null){
					flowLnciRiskAmt = (BigDecimal) map.get("LNCIAMT");
				}
				totalLnciamt = totalLnciamt.add(flowLnciRiskAmt);
			}
			if (totalLnciamt.add(bLanAppliLnciBase.getLnciAmt()).compareTo(contAmount) > 0) {
				log.info("(信贷合同项下所有放款的借据金额 + 本次放款金额)必须小于等于信贷合同金额");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20008),
						BLanErrorConstant.SCF_BAS_LAN_20008);
			}
			// 非循环合同，还需要在添加一个校验规则。
			//检查规则2是否满足
			if (contRistAmtTemp.add(tempRistAmt).compareTo(riskAmt) > 0) {
				log.info("信贷合同可用敞口不足！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20009),
						BLanErrorConstant.SCF_BAS_LAN_20009);
			}
			//1.2 可循环额度合同
	        //规则：借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
	        //规则：信贷合同项下所有生效的借据敞口余额 + 本笔风险敞口〈=信贷合同总敞口
	        //规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额
			if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)){
	            if(contRistAmtTemp.add(tempRistAmt).compareTo(riskAmt) > 0){
	            	log.info("(信贷合同项下所有生效的借据敞口余额 + 本次风险敞口)必须小于等于信贷合同总敞口");
	            	throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20010),
							BLanErrorConstant.SCF_BAS_LAN_20010);
	            }
	        }
			if((ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)||ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
					||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))){//池不校验买方额度
				//本笔风险敞口 <=  池应收账款余额 * 融资比例 + 池保证金余额 - 敞口余额
	        	BigDecimal compareAmt=new BigDecimal(0);//应收账款总额
	        	compareAmt=	(bCrrDueBillDetail.getTotalBillsAmount().multiply(bCrrDueBillDetail.getRzbl())
	        			.divide(new BigDecimal(100))).add(bCrrDueBillDetail.getPoolRiskAmt()).subtract(totalContRist);//池敞口余额（核心）
	        	if(tempRistAmt.compareTo(compareAmt)>0){
	        		log.info("应收账款池可融资金额不足！");
	        		throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20033),BLanErrorConstant.SCF_BAS_LAN_20033);
	        	}
	        }else{
	        	//本笔风险敞口 <= 应收账款余额 * 融资比例
	        	if(tempRistAmt.compareTo(bCrrDueBillDetail.getYsTotalAmt())>0){
	        		log.info("应收账款可融资金额不足！");
	        		throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20011),
							BLanErrorConstant.SCF_BAS_LAN_20011);
	        	}
	        }
		}
	}
	
	/**
	 * @author liph
	 */
	public BigDecimal getContRiskAmtByCycle(String mastContno,String cycle){
		BigDecimal avalibalRiskAmt = BigDecimal.ZERO;
		if(StringUtil.isEmpty(cycle)){
			cycle = ScfBasConstant.CONT_CREDIT_NOCYCLE;
		}
		List<Map> list = ibLanAppliLnciBaseDAO.getFlowRiskAmtByMastContno(mastContno);
		BigDecimal flowRiskAmt= BigDecimal.ZERO;
		Map map = new HashMap();
		if(list !=null && list.size() >0){
			map = list.get(0);
			if(map.get("RISKAMT")!=null){
				flowRiskAmt = (BigDecimal) map.get("RISKAMT");
			}
		}

		//非循环合同
		if(ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)){
			avalibalRiskAmt = getContRiskAmt(mastContno,cycle);
		}
		//循环合同
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)){
			avalibalRiskAmt = getContRiskAmt(mastContno,cycle);
		}
		//增加流程审批中的借据（仅仅包括已经提交给信贷，但是未审批通过）
		avalibalRiskAmt =avalibalRiskAmt.add(flowRiskAmt);
		return avalibalRiskAmt;
	}
	/**
	 * @author liph
	 */
	public BigDecimal getContRiskAmt(String mastContno,String cycle){
		BigDecimal riskAmt = BigDecimal.ZERO;
		BigDecimal totRiskAmt = BigDecimal.ZERO;
		List list =new ArrayList();
		//循环合同，已经结清的借据不需要要计算的。
		BLanLnciBase bLanLnciBase = new BLanLnciBase();
		bLanLnciBase.setMastContno(mastContno);
		bLanLnciBase.setState(ScfBasConstant.FLAG_ON);
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)){
			bLanLnciBase.setIsSettle(ScfBasConstant.FLAG_OFF);
		}
		List<BLanLnciBase> lncilist = ibLanLnciBaseDAO.queryByCondition(bLanLnciBase);
		if(lncilist.size()>0){
			for(int i=0;i<lncilist.size();i++){
				riskAmt = this.getLnciRiskAmt((BLanLnciBase)list.get(i),cycle);
				if(riskAmt == null){
					riskAmt = BigDecimal.ZERO;
				}
				totRiskAmt = totRiskAmt.add(riskAmt);
			}
		}
		return totRiskAmt;
	}
	
	/**
	 * @author liph
	 */
	public BigDecimal getLnciRiskAmt(BLanLnciBase bLanLnciBase,String cycle) {

		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (bLanLnciBase.getBailAmount()==null?new BigDecimal(0):bLanLnciBase.getBailAmount());
		addBailAmount= (bLanLnciBase.getAddBailAmount()==null?new BigDecimal(0):bLanLnciBase.getAddBailAmount());
		initCashEqtAmt = (bLanLnciBase.getInitCashEqtAmt()==null?new BigDecimal(0):bLanLnciBase.getInitCashEqtAmt());
		addCashEqtAmt = (bLanLnciBase.getAddCashEqtAmt()==null ? new BigDecimal(0):bLanLnciBase.getAddCashEqtAmt());
		if(ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle))
		{
			riskAmt = bLanLnciBase.getLnciAmt().subtract(bailAmount).subtract(initCashEqtAmt);
		}
		if(ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle))
		{

			riskAmt = bLanLnciBase.getLnciBal().subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		}
		return riskAmt;
	}
	/**
	 * 更新申请状态
	 */
	public void updateAppliBaseInfoState(String appno,String appliStatusDtlWaitcms){
		BPbcAppliBaseInfo baseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		if(baseInfo != null){
			baseInfo.setAppliStatusDtl(appliStatusDtlWaitcms);
			ibPbcAppliBaseInfoDAO.updateByPrimaryKey(baseInfo);
		}
	}
	/**
	 * @author liph
	 *  更新R_BCP_APPLI_BUSS_INFO表
	 */
	public void updateAppliBussInfo(BCrrDueBillDetail bCrrDueBillDetail,String factFlag){
		RBcpAppliBussInfo bussInfo = irBcpAppliBussInfoDAO.selectByAppno(bCrrDueBillDetail.getId());
		if(bussInfo != null){
			if(ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factFlag)){
				setBPbcAppliBaseInfo(bCrrDueBillDetail,bussInfo);
			}
		}else {
			bussInfo = new RBcpAppliBussInfo();
			if(ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factFlag)){
				setBPbcAppliBaseInfo(bCrrDueBillDetail,bussInfo);
			}
			bussInfo.setAppno(bCrrDueBillDetail.getId());
			bussInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());//登记人
			bussInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());//登记机构
			irBcpAppliBussInfoDAO.insert(bussInfo);
		}
		irBcpAppliBussInfoDAO.updateByPrimaryKey(bussInfo);
	}
	/**
	 * @author liph
	 *  pbcapplibussinfo--set方法
	 */
	private RBcpAppliBussInfo setBPbcAppliBaseInfo(BCrrDueBillDetail bCrrDueBillDetail,RBcpAppliBussInfo bussInfo){
		String mastContno = bCrrDueBillDetail.getAppId();
		String debtNo = bussInfo.getDebetNo();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(bCrrDueBillDetail.getId());
		bussInfo.setCustcdSaller(bCrrDueBillDetail.getCustCd());//卖方客户号
		bussInfo.setCustcdBuyer(bCrrDueBillDetail.getCrdtCustCd());//买方客户号
		bussInfo.setMastContno(mastContno);//合同号
		bussInfo.setBussType(bCrrLnCon.getVidBusiTyp());//业务品种
		bussInfo.setCurcd(bCrrDueBillDetail.getCurcd());//合同币别
		bussInfo.setBillDate(bCrrLnCon.getLnStrtDt());//合同生效日期
		bussInfo.setBillEndDate(bCrrLnCon.getLnEndDt());//合同到期日期	
		BLanLnciBase bLanLnciBase = ibLanLnciBaseDAO.selectByPrimaryKey(debtNo);
		if(bLanLnciBase != null){
			bussInfo.setAppDate(bLanLnciBase.getInsertDate()==null?"":bLanLnciBase.getInsertDate().toString()); //融资申请日期
		}
		
		bussInfo.setRateType(bLanAppliLnciBase.getRateType());//利率类型
		bussInfo.setBaseRate(bLanAppliLnciBase.getBaseYearRate() !=null?bLanAppliLnciBase.getBaseYearRate().toString():"");//年基准利率
		bussInfo.setUpDown(bLanAppliLnciBase.getRateFloatType());//浮动类型
		bussInfo.setUpDownPercent(bLanAppliLnciBase.getRateFloatValue() !=null?bLanAppliLnciBase.getRateFloatValue().toString():"");//浮动值
		bussInfo.setExecuteRate(bLanAppliLnciBase.getRate() !=null?bLanAppliLnciBase.getRate().toString():"");//执行利率

		bussInfo.setLoanType(bLanAppliLnciBase.getLoanType());//贷款种类
		bussInfo.setAccountNo(bLanAppliLnciBase.getAccountNo());//入账账号
		bussInfo.setDebtNum(bLanAppliLnciBase.getBillNum()==null?0:bLanAppliLnciBase.getBillNum().intValue());//应收总份数
		bussInfo.setTotalDebtAmount(bCrrDueBillDetail.getYsTotalAmt());//应收总额
		bussInfo.setAmount(bLanAppliLnciBase.getAvaliableAmt());//可融资金额
		bussInfo.setAppLoanDate(bLanAppliLnciBase.getStartDate());//融资发放日期
		bussInfo.setLoanDueDate(bLanAppliLnciBase.getEndDate());//融资到期日期
		return bussInfo;
	}
	/**
	 * 保存buss detail--dtl
	 */
	public void saveAppliBussDtl(List insertList,String appno){
		RBcpAppliBussDtl rAppliBussDtl = null;
		if(insertList !=null&&insertList.size()>0){
			//保存前先清掉之前数据
			List<RBcpAppliBussDtl> list = irBcpAppliBussDtlDAO.selectByAppno(appno);
			for(int i=0;i<list.size();i++){
				rAppliBussDtl = list.get(i);
				if(!StringUtil.isEmpty(rAppliBussDtl.getDebtId())){
					RBcpDebtBaseInfo rBaseInfo = irBcpDebtBaseInfoDAO.selectByPrimaryKey(rAppliBussDtl.getDebtId());
					if(rBaseInfo != null){
						rBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
						rBaseInfo.setLockAppno(null);
						irBcpDebtBaseInfoDAO.updateByPrimaryKey(rBaseInfo);
					}
				}
				irBcpAppliBussDtlDAO.deleteByPrimaryKey(rAppliBussDtl.getId());
			}
			for(int j=0;j<insertList.size();j++){
				rAppliBussDtl = (RBcpAppliBussDtl) insertList.get(j);
				irBcpAppliBussDtlDAO.insert(rAppliBussDtl);
				
				if(!StringUtil.isEmpty(rAppliBussDtl.getDebtId())){
					String detid = rAppliBussDtl.getDebtId();
					RBcpDebtBaseInfo rBaseInfo = irBcpDebtBaseInfoDAO.selectByPrimaryKey(detid);
					if(rBaseInfo != null){
						rBaseInfo.setIsLocked(ScfBasConstant.LOCKED);
						rBaseInfo.setLockAppno(appno);
						irBcpDebtBaseInfoDAO.updateByPrimaryKey(rBaseInfo);
					}
				}
			}
		}
	}
	
	/**
	 * @author LIPH
	 *  更新借据申请表
	 */
	public void updateAppliLnciBaseInfo(BCrrDueBillDetail bCrrDueBillDetail){
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(bCrrDueBillDetail.getId());
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bCrrDueBillDetail.getAppId());
		if(bLanAppliLnciBase != null){
			bLanAppliLnciBase.setCreditCustcd(bCrrDueBillDetail.getCustCd());
			bLanAppliLnciBase.setOtherCustcd(bCrrDueBillDetail.getCustCd());//买方
			bLanAppliLnciBase.setInitCashEqtAmt(bCrrDueBillDetail.getCsxjdjwbl());
			bLanAppliLnciBase.setProtocolNo(bCrrLnCon.getVidNo());//业务合同号
			ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
		}else{
			log.info("放款申请信息获取失败");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
					BLanErrorConstant.SCF_BAS_LAN_20000);
		}
	}
	/**
	 * @Description: 计算本笔借据的敞口余额(本笔数风险敞口)查询申请表
	 * @param appno
	 * @return
	 * @throws CommonException
	 */
	public BigDecimal getLnciRiskAmtByAppno(String appno){
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);	
			
		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (bLanAppliLnciBase.getBailAmount()==null?new BigDecimal(0):bLanAppliLnciBase.getBailAmount());
		addBailAmount= (bLanAppliLnciBase.getAddBailAmount()==null?new BigDecimal(0):bLanAppliLnciBase.getAddBailAmount());
		initCashEqtAmt = (bLanAppliLnciBase.getInitCashEqtAmt()==null?new BigDecimal(0):bLanAppliLnciBase.getInitCashEqtAmt());
		addCashEqtAmt = (bLanAppliLnciBase.getAddCashEqtAmt()==null ? new BigDecimal(0):bLanAppliLnciBase.getAddCashEqtAmt());
		riskAmt = bLanAppliLnciBase.getLnciBal().subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		return riskAmt;
	}
	/**
	 * 间接额度通用处理
	 */
	public void indirectCreditAppliCommonProcess(String appno,String debitNo,String operType,BigDecimal amt){
		BPbcAppliBaseInfo baseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno); 
		boolean breakFlag=false;
		String appliType=baseInfo.getAppliType();//申请业务类型
		if(StringUtil.isEmpty(appno)){
			log.info("申请号--appno丢失");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20020),
					BLanErrorConstant.SCF_BAS_LAN_20020);
		}
		String productId = baseInfo.getSupplyChainPdId();//产品编号
		if(StringUtil.isEmpty(productId)){
			log.info("产品编号丢失");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20021),
					BLanErrorConstant.SCF_BAS_LAN_20021);
		}
		String businessno="";//关联业务号
		String relaType=ScfBasConstant.CREDIT_RELA_TYPE_LNCI;//额度业务关联类型:借据
		String custcd = "";//客户号
		String otherCustcd = "";//交易对手,额度占用方
		String creditPhase="";//额度阶段
		String creditOprType="";//额度操作
		String releaseFlag=ScfBasConstant.FLAG_OFF;//是否放款退回：默认：否
		BLanAppliLnciBase bLanAppliLnciBase = null;
		List creditOpList=null;
		if(WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGAPPLY.equalsIgnoreCase(appliType)){
			bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
			businessno=bLanAppliLnciBase.getDebetId();
			if(StringUtil.isEmpty(businessno)){
				log.info("借据编号丢失");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20022),
						BLanErrorConstant.SCF_BAS_LAN_20022);
			}
			creditPhase=ScfBasConstant.CREDIT_PHASE_DEBT_FINANCING;
			relaType=ScfBasConstant.CREDIT_RELA_TYPE_LNCI;
			//放款通过
			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)){
				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
			}
			//放款退回
			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)){
				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
				releaseFlag=ScfBasConstant.FLAG_ON;//放款退回
			}
			custcd = bLanAppliLnciBase.getCreditCustcd();//买方
			otherCustcd = bLanAppliLnciBase.getCustcd();//卖方
		}
		//额度处理
		if(!breakFlag&&!StringUtil.isEmpty(productId)&&!StringUtil.isEmpty(creditPhase)
				&&!StringUtil.isEmpty(creditOprType)){
			BPrdCreditBind bind = new BPrdCreditBind();
			bind.setProductId(productId);
			bind.setCreditPhase(creditPhase);
			bind.setOprType(creditOprType);
			//根据产品ID和操作类型查询
			List<BPrdCreditBind> creditBindList = ibPrdCreditBindDAO.selectCreditBind(bind);
			if(creditBindList == null||creditBindList.size()==0){
				log.info("产品与额度类型关联信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),
						BLanErrorConstant.SCF_BAS_LAN_20002);
			}
			BLanCreditProcessBussAmt bussAmtVO = new BLanCreditProcessBussAmt();
			bussAmtVO.setRiskAmount(amt);
			//循环当前业务阶段的额度设定列表,依次处理额度列表中的各种额度
			for(int i=0;i<creditBindList.size();i++){
				BigDecimal amount = null;
				//获取产品绑定额度信息
				BPrdCreditBind creditBind = creditBindList.get(i);
				String creditType = creditBind.getCreditType();  // 额度类型
				String oprField = creditBind.getOprField(); // 额度操作金额
				BIcrType icrType = new BIcrType();
				icrType.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
				icrType.setCreditType(creditType);
				List<BIcrType> icrTypes = ibIcrTypeDAO.findBIcrTypeByBIcrType(icrType); 
				if(icrTypes != null&&icrTypes.size()>0){
					//获取额度操作的金额
					String oprFieldName = "";
					if("00".equals(oprField)){
						oprFieldName = "riskAmount";
					}else{
						oprFieldName = "bussAmount";
					}
				}
			}
		}
	}
	/**
	 * @des提交的业务逻辑处理
	 * @param appNo
	 * @throws FlowsharpException 
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public void flowCreditSubmit(String appNo,BCrrDueBillDetail bCrrDueBillDetail) throws FlowsharpException{
		BCrrDuebillApp bCrrDuebillApp = ibCrrDuebillAppDAO.selectByPrimaryKey(appNo);
		String mastContno = "";
		if(bCrrDuebillApp != null){
			mastContno = bCrrDuebillApp.getAppId();
		}
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		String prdid = "";
		if(bCrrLnCon != null){
			prdid = bCrrLnCon.getPrdId();
		}
		String vidBusTyp = bCrrLnCon.getVidBusiTyp();
		BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(vidBusTyp);
		String bigProdutId = bPrdInfo.getParentId();
		if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(prdid)&&ScfBasConstant.PRODUCT_TYPE_ACCR.equals(bigProdutId)&&(ScfBasConstant.PRODUCT_TYPE_GNFAC.equals(vidBusTyp)||ScfBasConstant.PRODUCT_TYPE_GNFAC.equals(vidBusTyp)||ScfBasConstant.PRODUCT_TYPE_GNFXBL.equals(vidBusTyp)||ScfBasConstant.PRODUCT_TYPE_YSZKZY.equals(vidBusTyp))){//应收-国内保理
			this.repaysubmit(appNo,bCrrDueBillDetail);
		}else if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(prdid)&&ScfBasConstant.PRODUCT_TYPE_ACCR.equals(bigProdutId)&&(ScfBasConstant.PRODUCT_TYPE_DEBT_POOL.equals(vidBusTyp)||ScfBasConstant.PRODUCT_TYPE_YSZKZY_POOL.equals(vidBusTyp)||ScfBasConstant.PRODUCT_TYPE_CKTS_POOL.equals(vidBusTyp))){//应收-国内保理池
			this.repaysubmit(appNo, bCrrDueBillDetail);
		}else if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(prdid)&&ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProdutId)){//现货抵押--流贷--供应链--提交
			//现货抵押-供应链补录-提交按钮触发事件
			try {
				ibLanCommonService.saveLoanInfo(appNo, "1", null);
			} catch (Exception e) {
				log.info("现货抵押--流贷--供应链补录异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),BLanErrorConstant.SCF_BAS_LAN_20000);
			}
			BPbcAppliBaseInfo bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appNo);
			//节点转移
			String processId= bPbcAppliBaseInfo.getPiid();
			UserInfo user = ContextHolder.getUserInfo();
			String userId = user.getTlrNo();
			String taskId = WorkflowConstant.WORKFLOW_BCRRDUEBILL_ADD;
			taskService.takeTask(taskId, processId, userId);
			
			String comment = "申请提交";
			if(!StringUtil.isEmpty(bCrrDueBillDetail.getTaskComment()))
			{
				comment = bCrrDueBillDetail.getTaskComment();
			}
			taskService.completeTask(taskId, processId, userId, comment);
			// 节点转移
			processService.signal(processId, WorkflowConstant.WORKFLOW_BCRRDUEBILL_CONFIRM);
			
			bPbcAppliBaseInfo.setApprover(userId); // 当前已审批人员
			bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
			bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new Date())); // 当前已审批日期
			bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
			/*com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
			BeanUtils.copyProperties(bPbcAppliBaseInfo, appliBaseInfo);*/
			ibPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
		}
		
	}
}
