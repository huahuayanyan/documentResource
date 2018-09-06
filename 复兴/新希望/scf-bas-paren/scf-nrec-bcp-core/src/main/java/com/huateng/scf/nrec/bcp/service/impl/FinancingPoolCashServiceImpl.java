package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CreditInterParamVO;
import com.huateng.scf.bas.common.service.ICommonLoanApplyService;
import com.huateng.scf.bas.common.service.IDebtFinancingService;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.dcr.dao.BDcrLinInfDAO;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDuebillAppDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillApp;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.IFinancingPoolCashService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收账款池融资流贷放款	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月25日下午7:04:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月25日下午7:04:45	     新增
 *
 * </pre>
 */
@ScubeService
@Service("FinancingPoolCashServiceImpl")
public class FinancingPoolCashServiceImpl implements IFinancingPoolCashService,DealInFlowService,DealEndFlowService
{
private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO blanlncibasedao;
	
	//应收账款
	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;
	
	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;
	
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO blanapplilncibasedao;

	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	//放款申请公共方法
	@Resource(name = "CommonLoanApplyServiceImpl")
	ICommonLoanApplyService commonloanapplyservice;

	@Resource(name = "IRBcpDuebillAppDAO")
	IRBcpDuebillAppDAO rbcpduebillappdao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;//业务编号生成器
	
	@Resource(name = "NRBcpDebtBussDtlServiceImpl")
	INRBcpDebtBussDtlService nrbcpdebtbussdtlservice;
	
	@Resource(name = "BDcrLinInfDAO")
	BDcrLinInfDAO bdcrlininfdao;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;
	
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;
	
	@Resource(name = "DebtFinancingServiceImpl")
	IDebtFinancingService debtfinancingservice;
	
	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;
	
	// 自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfIndirectCreditService;
	
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException
	{
		//更新申请状态
		commonloanapplyservice.updateAppliBaseInfoWithParam(appNo,WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
	}

	@Override
	public void doWorkForPass(String appNo) {
		//判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_DUEBILL_APP;//放款申请阶段
		String callerpath = "FinancingPoolCashServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if(flag)
		{
			return;
		}
		//1.更新放款申请状态信息
		RBcpDuebillApp duebillApp = new RBcpDuebillApp();
		duebillApp.setAppno(appNo);
		duebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_APPROVED);
		rbcpduebillappdao.updateByPrimaryKeySelective(duebillApp);
		//2.获取放款申请信息
		RBcpDuebillApp bcpDuebillApp = rbcpduebillappdao.selectByPrimaryKey(appNo);
		//3.获取借据申请表信息并保存正式借据信息
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase appliLnciBase = blanapplilncibasedao.selectByAppno(appNo);
		BLanLnciBase lnciBase = new BLanLnciBase();
		BeanUtils.copyProperties(appliLnciBase, lnciBase);
		
		String debetNo = lnciBase.getDebetNo();// 主键
		String cino = ibSysSerialNoService.genSerialNo("DUE_NO");// 借据流水号
		lnciBase.setDebetId(cino);
		lnciBase.setLnciStatus(ScfBasConstant.LNCI_STATUS_NORMAL);// 借据状态
		lnciBase.setState(ScfBasConstant.LNCI_STATE_NEW);// 信贷放款通过时借据记录状态直接为新建
		lnciBase.setIsSettle(ScfBasConstant.FLAG_OFF);
		lnciBase.setConfirmStatus(ScfBasConstant.LNCI_CONFIRM_NOTRECEIVED);
		lnciBase.setTimestamps(new Date());// 记录更新时间
		lnciBase.setPayBrcode(bcpDuebillApp.getActBrCd());// 放款机构
		BLanLnciBase bLanLnciBase = blanlncibasedao.selectByPrimaryKey(debetNo);
		try {
			if (bLanLnciBase == null) {
				blanlncibasedao.insertSelective(lnciBase);
			} else {
				blanlncibasedao.updateByPrimaryKeySelective(lnciBase);
			}

		} catch (Exception e) {
			log.info("插入借据正式表异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000), BLanErrorConstant.SCF_BAS_LAN_20000);
		}
		//4.将借据申请表中的借据号回显到借据申请表中
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase lanAppliLnciBase = 
				new com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase();
		lanAppliLnciBase.setId(appliLnciBase.getId());
		lanAppliLnciBase.setAppno(appNo);
		lanAppliLnciBase.setDebetId(cino);
		blanapplilncibasedao.updateByPrimaryKeySelective(lanAppliLnciBase);
		//5.修改应收账款融资余额为0，并生成应收账款明细信息
		List<RBcpAppliBussDtl> list = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appNo);
		if(list!=null&&list.size()>0)
		{
			for(RBcpAppliBussDtl bussDtl:list)
			{
				RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
				BeanUtils.copyProperties(bussDtl, rBcpDebtBussDtl);
				//5-2.应收账款可融资余额loanRemainingAmout字段置为零
				RBcpDebtInfoVO infoVO = new RBcpDebtInfoVO();
				infoVO.setId(bussDtl.getDebtId());
				infoVO.setLoanRemainingAmount(BigDecimal.ZERO);
				rbcpdebtinfoservice.updateRBcpDebtInfo(infoVO);
				//5-3.生成明细信息
				rBcpDebtBussDtl.setAppno(appNo);
				rBcpDebtBussDtl.setDebtId(bussDtl.getDebtId());
				rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_POOL_FINANCING);
				nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(rBcpDebtBussDtl);
			}
		}
		//6.池融资不涉及到应收账款数据操作，故不进行下列操作，需对应修改应收账款池信息表
		//6-1.应收账款池信息修改
		DebtCommonQryVO commonQueryVO=new DebtCommonQryVO();
		commonQueryVO.setMastContno(bcpDuebillApp.getMastContno());
		commonQueryVO.setCustcdBuyer_Q(bcpDuebillApp.getBusinessCustcd());
		List<RBcpDebtPool> poollist= nrbcpdebtpoolservice.getInPoolInfo(commonQueryVO);
		if(poollist!=null&&poollist.size()>0)
		{
			RBcpDebtPool debtPool = poollist.get(0);
			RBcpDebtInfoVO debtInfoVO = rbcpdebtinfoservice.findSumRBcpDebtInfoByMastContno(bcpDuebillApp.getMastContno(), null);
			BCntBcpInfoVO bcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(bcpDuebillApp.getMastContno());
			if(debtPool!=null){
				BigDecimal lnAmt = bcpDuebillApp.getLnAmt();//本次放款金额
				BigDecimal poolRemainingAmount = StringUtil.isEmpty(debtPool.getPoolRemainingAmount())?BigDecimal.ZERO:debtPool.getPoolRemainingAmount();
				debtPool.setPoolRemainingAmount(poolRemainingAmount.add(lnAmt));//融资总余额（融资总额）
				nrbcpdebtpoolservice.updateRBcpDebtPoolDebtAmount(debtPool, debtInfoVO, bcpInfoVO.getLoanPercent(), ScfBasConstant.INVOKE_PHASE_DUEBILL_APP);
			}
		}
		//7.额度信息修改
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appNo);
		CreditInterParamVO creditInterParam = new CreditInterParamVO();
		creditInterParam.setCreditNo(bcpDuebillApp.getCrNo());
		creditInterParam.setRelaType(ScfBasConstant.CREDIT_RELA_TYPE_LNCI);
		creditInterParam.setReleaseFlag(ScfBasConstant.FLAG_OFF);
		creditInterParam.setApplyType(appliBaseInfo.getAppliType());
		creditInterParam.setBusinessno(cino);
		creditInterParam.setAmount(bcpDuebillApp.getLnAmt());
		creditInterParam.setAppno(appNo);
		creditInterParam.setOtherCustcd(bcpDuebillApp.getCustcd());
		creditInterParam.setCustcd(bcpDuebillApp.getBusinessCustcd());
		scfIndirectCreditService.indirectCreditDealWithByCreditNo(creditInterParam,ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "pass");
	}

	@Override
	public void doWorkForReject(String appNo) {
		RBcpDuebillApp duebillApp = rbcpduebillappdao.selectByPrimaryKey(appNo);
		duebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_REFUSED);
		rbcpduebillappdao.updateByPrimaryKeySelective(duebillApp);
		//额度信息恢复（此处未占用额度）
//		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appNo);
//		CreditInterParamVO creditInterParam = new CreditInterParamVO();
//		creditInterParam.setCreditNo(duebillApp.getCrNo());
//		creditInterParam.setRelaType(ScfBasConstant.CREDIT_RELA_TYPE_CONT);
//		creditInterParam.setReleaseFlag(ScfBasConstant.FLAG_OFF);
//		creditInterParam.setApplyType(appliBaseInfo.getAppliType());
//		creditInterParam.setBusinessno(appliBaseInfo.getMastContno());
//		creditInterParam.setAmount(appliBaseInfo.getAmt());
//		creditInterParam.setAppno(appNo);
//		creditInterParam.setOtherCustcd(appliBaseInfo.getCustcd());
//		scfIndirectCreditService.indirectCreditDealWithByCreditNo(creditInterParam,ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "reject");
	}

	@Override
	@Transactional
	public void doWorkForBack(String appNo) {
		RBcpDuebillApp duebillApp = new RBcpDuebillApp();
		duebillApp.setAppno(appNo);
		duebillApp.setAppStat(WorkflowConstant.APPLI_STATUS_GOBACK);
		rbcpduebillappdao.updateByPrimaryKeySelective(duebillApp);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "back");
	}
}
