package com.huateng.scf.bas.com.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfChattelCreditService;
import com.huateng.scf.bas.common.service.IScfCreditService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>动产额度处理类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月25日下午3:12:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月25日下午3:12:32	     新增
 *
 * </pre>
 */
@ScubeService
@Service("ScfChattelCreditServiceImpl")
public class ScfChattelCreditServiceImpl implements IScfChattelCreditService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	private IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;//多方协议参与者信息表
	
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	private IBLanAppliLnciBaseService bLanAppliLnciBaseService; //借据申请信息
	
	@Resource(name = "BPrdCreditBindServiceImpl")
	private IBPrdCreditBindService  bPrdCreditBindService;//产品额度绑定表
	
	@Resource(name = "ScfCreditServiceImpl")
	IScfCreditService scfcreditservice;//额度接口
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	/**
	 * 动产申请获取信息
	 * @param appno
	 * @param businessState
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:14:23
	 */
	@SuppressWarnings("unused")
	@Override
	public void chattelAppliCreditProcess(String appno,String businessState) throws ScubeBizException
	{
		if(StringUtil.isEmpty(appno))
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:申请号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST),
					RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(businessState))
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:业务状态丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST),
					RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}

		//获取申请基本信息
		BPbcAppliBaseInfo tblAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if(tblAppliBaseInfo == null)
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:业务申请信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
//		String slaveContno=tblAppliBaseInfo.getSlaveContno();
		String protocolNo=tblAppliBaseInfo.getProtocolNo();
		if(tblAppliBaseInfo.getSupplyChainPdId().equals(ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL))
		{
			BCrrGntyCon bCrrGntyCon = bcrrgntycondao.selectByPrimaryKey(tblAppliBaseInfo.getProtocolNo());
			if(bCrrGntyCon!=null)
			{
				protocolNo = bCrrGntyCon.getPrtclNo();
			}
		}
		String businessnoType=tblAppliBaseInfo.getAppliType();
		String productId=tblAppliBaseInfo.getSupplyChainPdId();
		if(StringUtil.isEmpty(businessnoType))
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:业务申请类型丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		if(StringUtil.isEmpty(productId))
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:业务申请产品编号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		//获取客户信息和监管公司信息
		BCntMprotPartInfo custTblMutiProtPartInfo = bcntmprotpartinfoservice.findCustByProtocolNoAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		if(custTblMutiProtPartInfo==null)
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:客户信息信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		String custcd=custTblMutiProtPartInfo.getCustcd();
		BCntMprotPartInfo moniCustTblMutiProtPartInfo = bcntmprotpartinfoservice.findCustByProtocolNoAndRole(protocolNo, ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		if(custTblMutiProtPartInfo==null)
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:监管公司信息信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		String moniCustcd=moniCustTblMutiProtPartInfo.getCustcd();

		//获取发放金额
		BLanAppliLnciBase tblAppliLnciBaseInfo = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(appno);
		BigDecimal amount=tblAppliLnciBaseInfo.getLnciAmt();

		String creditType="";
		String moniCreditType="";
		BPrdCreditBind productCreditBind = new BPrdCreditBind();
//		productCreditBind.setCreditPhase(ScfBasConstant.CREDIT_PHASE_CHATTEL_LOAN);
		productCreditBind.setOprType(ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY);
		productCreditBind.setProductId(productId);
		List<BPrdCreditBind> creditBindList = bPrdCreditBindService.getTblProductCreditBind(productCreditBind);
		if(creditBindList==null||creditBindList.size()==0)
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:产品额度占用关系未绑定！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		else
		{
			for(int i=0;i<creditBindList.size();i++){
				BPrdCreditBind tpcb=(BPrdCreditBind)creditBindList.get(i);
				if(ScfBasConstant.CREDIT_TYPE_LOAN.equalsIgnoreCase(tpcb.getOprField())){
					creditType=tpcb.getCreditType();
				}
				if(ScfBasConstant.CREDIT_TYPE_MONITOR.equalsIgnoreCase(tpcb.getOprField())){
					moniCreditType=tpcb.getCreditType();
				}
			}
		}
		if(StringUtil.isEmpty(creditType))
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:动产融资额度占用关系未绑定！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		if(StringUtil.isEmpty(moniCreditType))
		{
			log.info("===================>>IScfChattelCreditService.chattelAppliCreditProcess:动产监管额度占用关系未绑定！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.RECORD_NOT_EXIST),
					RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		//监管公司监管额度处理 客户融资额度处理
		chattelCreditProcess(appno,custcd,moniCustcd,businessnoType,businessState,creditType,moniCreditType,amount);
	}

	/**
	 * 动产额度处理
	 *     放款申请  监管额度预占用与恢复 监管额度占用 融资额度预占用与恢复 融资额度占用
	 * @param custcd  		客户或监管公司额度
	 * @param businessnoType业务类型
	 * @param op			业务操作 ：预占用 预占用恢复 占用
	 * @param amount        操作额度
	 * @throws CommonException
	 */
	public void chattelCreditProcess(String appno,String custcd,String moniCustcd,String businessnoType,String businessState,String creditType,String moniCreditType,BigDecimal amount) throws ScubeBizException{


	    //动产融资放款申请
		if(WorkflowConstant.APPLI_TYPE_LOAN_APPLY.equalsIgnoreCase(businessnoType)){
			CreditInterParamBean creditInterParamBean=new CreditInterParamBean();
			creditInterParamBean.setAppno(appno);
			creditInterParamBean.setApplyType(businessnoType);
			creditInterParamBean.setBusinessno(appno);
			creditInterParamBean.setRelaType(ScfBasConstant.CREDIT_RELA_TYPE_CONT);
			if(ScfBasConstant.BUSINESS_STATUS_SUBMIT.equalsIgnoreCase(businessState)){ // 提交审批(包括提交申请和退回修改后重新提交申请)
				//监管公司监管额度预占用
				scfcreditservice.credit(creditInterParamBean,moniCustcd,
							null,moniCreditType, ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY,amount);
				//客户授信额度预占用
				scfcreditservice.credit(creditInterParamBean,custcd,
						null,creditType, ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY,amount);
			}
			if(ScfBasConstant.BUSINESS_STATUS_APPROVAL_REFUSED.equalsIgnoreCase(businessState)){// 审批拒绝(包括审批拒绝和退回修改)
				//监管公司监管额度预占用恢复
				scfcreditservice.credit(creditInterParamBean,moniCustcd,
							null,moniCreditType, ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE,amount);
				//客户授信额度预占用恢复
				scfcreditservice.credit(creditInterParamBean,custcd,
						null,creditType, ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE,amount);
			}
			if(ScfBasConstant.BUSINESS_STATUS_APPROVAL_CONFIRM.equalsIgnoreCase(businessState)){ // 审批确认(回执确认)
				//监管公司监管额度监管额度占用
				scfcreditservice.credit(creditInterParamBean,moniCustcd,
							null,moniCreditType, ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY,amount);
				//客户授信额度占用
				scfcreditservice.credit(creditInterParamBean,custcd,
						null,creditType, ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY,amount);
			}
		}
	}
}
