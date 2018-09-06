/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.math.BigDecimal;
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
import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtExtInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CreditOptFieldMap;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.icr.dao.IBIcrBusiRelDAO;
import com.huateng.scf.bas.icr.dao.ext.ExtBIcrDAO;
import com.huateng.scf.bas.icr.model.BIcrDtl;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.BIcrType;
import com.huateng.scf.bas.icr.model.CommonCreditProcessBussAmtVO;
import com.huateng.scf.bas.icr.model.CreditLimitOfBuyerDealVO;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.model.CreditTypeQryVO;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.icr.service.IBIcrTypeService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>供应链业务申请</p>
 *
 * @author 	huangshuidan
 * @date 2016年12月29日下午4:23:29	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月29日下午4:23:29             新增
 *
 * </pre>
 */
@ScubeService
@Service(IScfApplyService.BEAN_ID)
public class ScfApplyServiceImpl implements IScfApplyService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name="BCntDebtInfoServiceImpl")
	IBCntDebtInfoService  bCntDebtInfoService;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;//流水号生成服务
	
	//业务申请信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	//应收账款单据基本信息	TblDebtBussInfo
	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rbcpdebtbussinfoservice;
	
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rbcpdebtbaseinfoservice;
	
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;
	
	@Resource(name="RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rBcpAppliBussDtlService;
	
	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rbcpdebtpoolservice;
	
	@Resource(name = "BCntDebtExtInfoServiceImpl")
	IBCntDebtExtInfoService bcntdebtextinfoservice;
	
	@Resource(name="RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rbcpapplibussinfoservice;

	@Resource(name = "BPrdCreditBindServiceImpl")
	IBPrdCreditBindService bprdcreditbindservice;
	
	@Resource(name = "BIcrTypeServiceImpl")
	IBIcrTypeService bicrtypeservice;
	
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bicrinfoservice;
	
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;
	
	@Resource(name = "BIcrBusiRelDAO")
	IBIcrBusiRelDAO bicrbusireldao;
	
	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bicrdtlservice;
	
	@Resource(name = "ExtBIcrDAO")
	ExtBIcrDAO extbicrdao;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService; //监管协议/担保提货协议/先票(款)后货协议信息表
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.common.service.IScfApplyService#saveFactoringAppBasicInfo(com.huateng.scf.rec.bcp.model.DebtBussInfoVO, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public String saveFactoringAppBasicInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType)
			throws ScubeBizException {
		BCntDebtInfo bCntDebtInfo=bCntDebtInfoService.queryContInfoByMastContno(debtVO.getMastContno());
		BPbcAppliBaseInfo bPbcAppliBaseInfo=null;
		String appNo=null;
		if (StringUtil.isEmpty(debtVO.getAppno())) {                                       // 保存新增
			if(workApplyType.equals(WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_INPOOL_APPLY))
			{//应收账款入池
				appNo=bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSRC_T_APP_NO);
			}
			//应收账款出池
			if(workApplyType.equals(WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_OUTPOOL_APPLY)){
				appNo=bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSCC_T_APP_NO);
				
			}
			if(workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_POOL_BUYBACK_APPLY)||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_ACCOUNTREPUR_APPLY))
			{//应收账款反转让
				appNo=bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSFZR_T_APP_NO);
			}
			if(workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_POOL_CHARGEOFF_APPLY)||workApplyType.equals(WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY))
			{//应收账款核销、应收账款池核销
				appNo=bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSHX_T_APP_NO);
			}
			//			ScfGlobalInfo scfGlobalInfo=ScfBaseData.getScfGlobalInfoData();// 全局信息                      
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			try {
				BeanUtils.copyProperties(debtVO,bPbcAppliBaseInfo);// 拷贝信息                      
				bPbcAppliBaseInfo.setCustcd(debtVO.getCustcdSaller());  // 客户号
				bPbcAppliBaseInfo.setMoniCustcd(debtVO.getCustcdBuyer());
				bPbcAppliBaseInfo.setCurcd(bCntDebtInfo.getCurcd());                         // 币种
				bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);              		 // 流程名称
				bPbcAppliBaseInfo.setAppliType(businessnoType);
				bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
				bPbcAppliBaseInfo.setBusinessno(bCntDebtInfo.getDebtContno());
				bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);         // 申请状态:未提交（默认）
				bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
				bPbcAppliBaseInfo.setAppBrcode(ContextHolder.getOrgInfo().getBrNo());	                     // 登记机构
				bPbcAppliBaseInfo.setApprover(ContextHolder.getUserInfo().getTlrNo());
				bPbcAppliBaseInfo.setApproveTime(new Date());
				bPbcAppliBaseInfo.setAppDate(ScfDateUtil.getStringDate(new Date()));	                     // 登记时间
				bPbcAppliBaseInfo.setStartTime(new Date());
				bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date()));
				bPbcAppliBaseInfo.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());
				bPbcAppliBaseInfo.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo());
				bPbcAppliBaseInfo.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo());	                     // 登记人
//				bPbcAppliBaseInfo.setMortgageName(debtVO.getPayType());					//还款类别
//				bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getProductId());               // 产品ID
				bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getBussType());				//业务品种
				bPbcAppliBaseInfo.setMastContno(bCntDebtInfo.getDebtContno());                     // 主合同号
				bPbcAppliBaseInfo.setMemo(debtVO.getDescription());
				bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
				bPbcAppliBaseInfo.setAmt(debtVO.getTotalDebtAmount());	// 转让总金额
//				appNo=bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSFZR_T_APP_NO);
				bPbcAppliBaseInfo.setAppno(appNo);
				if (StringUtil.isEmpty(bPbcAppliBaseInfo.getBusinessno())) {
					bPbcAppliBaseInfo.setBusinessno(bPbcAppliBaseInfo.getAppno());
				}
				if (StringUtil.isEmpty(bPbcAppliBaseInfo.getChannelFlag())) {
					bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);//默认渠道标识为供应链
				}
				if (StringUtil.isEmpty(bPbcAppliBaseInfo.getIsFlowEnd())) {
					bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);//默认流程未结束
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException();
			}
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfodal = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
			try {
				BeanUtils.copyProperties(bPbcAppliBaseInfo, bPbcAppliBaseInfodal);
			} catch (BeansException e) {
				e.printStackTrace();
				log.error("业务申请基本信息转换异常！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10000),BPbcErrorConstant.SCF_BAS_PBC_10000);
			} 
			bPbcAppliBaseInfoDAO.insertSelective(bPbcAppliBaseInfodal);
		}else{//更新
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfodal =bPbcAppliBaseInfoDAO.selectByPrimaryKey(debtVO.getAppno());
			bPbcAppliBaseInfodal.setMemo(debtVO.getDescription());
			bPbcAppliBaseInfodal.setAmt(debtVO.getTotalDebtAmount());	// 转让总金额
			bPbcAppliBaseInfoDAO.updateByPrimaryKeySelective(bPbcAppliBaseInfodal);
			appNo=bPbcAppliBaseInfodal.getAppno();
		}
		return bPbcAppliBaseInfo.getAppno();
	}
	

	/**
	 * DESCRIPTION:先票/款后货差额退款申请保存
	 * saveFourBalanceAppBasicInfo 方法
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public String saveFourBalanceAppBasicInfo(FourWareLoanVO fourWareLoanVO, String businessnoType,
			String workApplyType) throws ScubeBizException {
		BCntMprotBaseInfo bCntMprotBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(fourWareLoanVO.getProtocolNo());
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		String appno="";
		if (StringUtil.isEmpty(fourWareLoanVO.getAppno())) {                                       // 保存新增
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			BeanUtils.copyProperties(fourWareLoanVO, bPbcAppliBaseInfo);                       // 拷贝信息
			bPbcAppliBaseInfo.setCustcd(fourWareLoanVO.getCustcd());                             	// 客户号
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);              		 	// 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);                               	// 申请类型
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_PROTOCOLNO); 	// 从合同号类型
			bPbcAppliBaseInfo.setBusinessno(fourWareLoanVO.getProtocolNo());   			//借据号
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);        // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			//bPbcAppliBaseInfo.setAppBrcode(globalInfo.getBrcode());	                     	// 登记机构
			//bPbcAppliBaseInfo.setAppDate(DateUtil.getCurrentDate());	                     	// 登记时间
			//bPbcAppliBaseInfo.setAppTlrcd(globalInfo.getTlrno());	                     	// 登记人
			//bPbcAppliBaseInfo.setStartTime(DateUtil.getCurrentDate());
			//bPbcAppliBaseInfo.setStratDate(DateUtil.getCurrentDate());
			//bPbcAppliBaseInfo.setStartBrcode(globalInfo.getBrcode());
			//bPbcAppliBaseInfo.setStartTlrcd(globalInfo.getTlrno());
			bPbcAppliBaseInfo.setSupplyChainPdId(bCntMprotBaseInfo.getProductId());               // 产品ID
			bPbcAppliBaseInfo.setAmt(fourWareLoanVO.getUndeliveryAmt()); 							//未发货金额
			bPbcAppliBaseInfo.setProtocolNo(bCntMprotBaseInfo.getProtocolNo());					//协议号
			//获得appno
			appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_CETK_F_APP_NO); 
			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setWorkflowAppno(appno);
			bpbcapplibaseinfoservice.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}else{
			appno = fourWareLoanVO.getAppno();
			BPbcAppliBaseInfo baseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			baseInfo.setAmt(fourWareLoanVO.getUndeliveryAmt());
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		return appno;
	}
	
	/**
     * 根据参数更新主申请表
     * @param GlobalInfo
     * @param wiTask
     * @param bussAppno
     * @param status
     * @return WorkFlowResultBean
     * @author huaidong.li
     * @Date 2011-4-27
     */
	@Override
    public void updateTblAppBaseInfo(String tlrno,String brcode,Integer processStatus, String bussAppno,String status,String appliStatusDtl){
//    	WorkFlowResultBean workFlowResultBean = new WorkFlowResultBean();
    	BPbcAppliBaseInfo tblAppbaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(bussAppno); // 主申请表
		tblAppbaseInfo.setApprover(tlrno); // 当前已审批人员
		tblAppbaseInfo.setApproveBrcode(brcode); // 当前已审批机构
		tblAppbaseInfo.setApproveDate(ScfDateUtil.formatDate(new Date())); // 当前已审批日期
		tblAppbaseInfo.setApproveTime(new Date()); // 当前已审批时间

		String lastStatus = tblAppbaseInfo.getAppliStatusDtl();
		String nowStatus = null;
		String detailStatus = null;
//		boolean isApproved = false;

		if(processStatus != 16){
			if(WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(status)){//同意
				 if(WorkflowConstant.APPLI_STATUS_DTL_GOBACK.equals(lastStatus)
						 || WorkflowConstant.APPLI_STATUS_DTL_BACKMODIFY.equals(lastStatus)){//如果上次意见是退回
					 nowStatus = WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE;//修改已提交
				 }
				 else if(WorkflowConstant.APPLI_STATUS_DTL_WRITING.equals(lastStatus)){
					 nowStatus = WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE;//提交审批中
				 }
				 else{//上次意见不是退回
					 nowStatus = WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE;//状态设为审批中
				 }
				 detailStatus = WorkflowConstant.APPLI_STATUS_DTL_APPROVING;//已提交
			 }
			 if (WorkflowConstant.WORKFLOW_TRANS_REFUSE.equals(status)) {// 拒绝
				 nowStatus = WorkflowConstant.APPLI_STATUS_REFUSED;
				 detailStatus = WorkflowConstant.APPLI_STATUS_DTL_REFUSED;
			 }
			 if (WorkflowConstant.WORKFLOW_TRANS_GOBACK.equals(status)) {// 被退回到首节点
				 nowStatus = WorkflowConstant.APPLI_STATUS_GOBACK;
				 detailStatus = WorkflowConstant.APPLI_STATUS_DTL_GOBACK;
			 }
			 if (WorkflowConstant.WORKFLOW_TRANS_BACKTOLAST.equals(status)) {// 被退回到上一节点
				 nowStatus = WorkflowConstant.APPLI_STATUS_GOBACK;
				 detailStatus = WorkflowConstant.APPLI_STATUS_DTL_GOBACK;
			 }
//			 workFlowResultBean.setNextTaskName("");
		}
		//如果没有下一个任务
		else if(processStatus == 16){
			if(WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(status)){
				nowStatus = WorkflowConstant.APPLI_STATUS_APPROVED;//审批通过
				detailStatus = WorkflowConstant.APPLI_STATUS_DTL_APPROVED;
//				isApproved = true;
			}
			if(WorkflowConstant.WORKFLOW_TRANS_REFUSE.equals(status)){//拒绝
				nowStatus = WorkflowConstant.APPLI_STATUS_REFUSED;
				detailStatus = WorkflowConstant.APPLI_STATUS_DTL_REFUSED;
//				isApproved = false;
			}
//			workFlowResultBean.setNextTaskName("");
		}
		tblAppbaseInfo.setAppliStatus(nowStatus);
		if(!StringUtil.isEmpty(appliStatusDtl)){//放款审批的状态是定制化的，需通过传参方式设值
			tblAppbaseInfo.setAppliStatusDtl(appliStatusDtl);
		}else{//若没有传明细状态，则采用供应链内部公共处理方法 add by xiaolong.xiong 2013-08-27
			tblAppbaseInfo.setAppliStatusDtl(detailStatus);
		}
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(tblAppbaseInfo);
		
//		workFlowResultBean.setLastTrans(status);
//		workFlowResultBean.setApproved(isApproved);
    }
	
	/**
	 * @Description: 回购审批通过
	 * @author zhengzong.liu
	 * @Created 2012-8-1下午12:59:04
	 * @param insertDebtList
	 * @param debtVO
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public void factoringDebtBackAddApply(List<RBcpDebtBaseInfo> insertDebtList,DebtBussInfoVO debtVO) throws ScubeBizException 
	{
		debtVO.setApplyType(DebtConstants.APPLY_TYPE_REPURCHASE);
		debtVO.setReason(debtVO.getReason());
		debtVO.setAmount(debtVO.getTotalAmount());//回购金额
		
		RBcpDebtBussInfo tblDebtBussInfo =rbcpdebtbussinfoservice.debtBussInfoAdd(debtVO);
		tblDebtBussInfo.setAmount(debtVO.getTotalAmount());//回购金额
		List cancelList = rbcpdebtbaseinfoservice.factoringDebtBackAddApply(insertDebtList, tblDebtBussInfo);
		//核销流水
		rbcpdebtbaseinfoservice.saveDebtBussInfoWhenCanceled(cancelList, debtVO);
	}

	/**
	 *
	 * @Description:  根据appno对流程锁定的应收账款进行解锁
	 * @author zhangwu
	 * @Created 2013-5-2下午01:58:36
	 * @param appno
	 * @throws CommonException
	 */
	@Override
	public void releaseAppliDebtBaseInfo(String appno) throws ScubeBizException {
		RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
		rBcpAppliBussDtl.setAppno(appno);
		List<RBcpAppliBussDtl> bussDetailList = rBcpAppliBussDtlService.findRBcpAppliBussDtlByAppno(rBcpAppliBussDtl);
		for(int i = 0; i < bussDetailList.size(); i++){
			RBcpAppliBussDtl busdtl = bussDetailList.get(i);
			AppliBussDetailVO bussDetail = new AppliBussDetailVO();
			BeanUtils.copyProperties(busdtl, bussDetail);
			if(!StringUtil.isEmpty(bussDetail.getDebtId())){
				rBcpDebtBaseInfoService.releaseDebtBaseInfo(bussDetail.getDebtId());
			}
		}
	}
	
	/**回购、核销更新池的发票总余额和可融资余额
	 * @author zhoujun.hou
	 * @date 2012-01-06
	 * 编辑 updatePoolRemainAmount 方法的文档注释
	 * @param debtVO
	 * @throws CommonException
	 */
	@Override
	@Transactional
	public void updatePoolRemainAmount(DebtBussInfoVO debtVO) throws ScubeBizException{
		BCntDebtInfo baseInfo = bCntDebtInfoService.findBCntDebtInfoByKey(debtVO.getMastContno());//获取合同信息
		if(baseInfo != null && !StringUtil.isEmpty(baseInfo.getFinancingType())
				&&DebtConstants.FINANCING_TYPE_POOL.equals(baseInfo.getFinancingType())){
			BigDecimal amount = debtVO.getTotalAmount()==null?new BigDecimal("0"):debtVO.getTotalAmount();
			List<RBcpDebtPool> list =rbcpdebtpoolservice.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());//获取池信息
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++)
				{
					RBcpDebtPool debtpool = list.get(i);
//					DebtBussInfoVO poolDebtVo = new DebtBussInfoVO();
//					BeanUtils.copyProperties(debtpool, poolDebtVo);
					RBcpDebtPool debtPool =rbcpdebtpoolservice.findRBcpDebtPoolByKey(debtpool.getId());
					rbcpdebtpoolservice.updatePoolRemainAmount(debtPool, baseInfo, amount);
				}
			}else{
				throw new ScubeBizException("应收账款池信息获取失败！", RBcpErrorConstant.RECORD_HAS_EXIST);
			}
		}
	}
	

	/**
	 * 获取保理合同（有/无）追索类型
	 * @Description: 获取保理合同（有/无）追索类型
	 * @author zhangwu
	 * @Created 2013-12-21下午04:41:35
	 * @param mastContno
	 * @param custcdBuyer
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String getDebtContRecoverType(String mastContno,String custcdBuyer) throws ScubeBizException{
		BCntDebtExtInfo debtExtInfo =bcntdebtextinfoservice.queryContDebtExInfoByMastContno(mastContno,custcdBuyer);
		if(debtExtInfo == null){
			throw new ScubeBizException("保理合同信息丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		return debtExtInfo.getRecoverType();
	}
	
	/**
	 *
	 * @Description: 买方信用限额额度通用处理
	 * @author wenkui.xu
	 * @Created 2013-8-6上午10:49:47
	 * @param appno	        申请编号
	 * @param operType 操作类型
	 * 		    常量定义SCFConstant:
	 *        03-恢复释放（占用恢复）;09-直接占用
	 * @param amt 业务金额
	 * @throws CommonException
	 */
	@Override
	public void  creditLimitOfBuyerAppliCommonProcess(String appno,String operType,BigDecimal amt) throws ScubeBizException{
		BPbcAppliBaseInfo tblAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String businessno=tblAppliBaseInfo.getBusinessno();//业务合同号
		String appliType=tblAppliBaseInfo.getAppliType();//申请类型
		if(StringUtil.isEmpty(appno)){
			throw new ScubeBizException("申请号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		String productId=tblAppliBaseInfo.getSupplyChainPdId();//产品编号
		if(StringUtil.isEmpty(productId)){
			throw new ScubeBizException("产品编号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}

		RBcpAppliBussInfo tblAppliBussInfo = rbcpapplibussinfoservice.findByAppno(appno);
		String custcd =tblAppliBussInfo.getCustcdSaller();//客户号卖方
		String otherCustcd =tblAppliBussInfo.getCustcdBuyer();//交易对手,买方

		String creditPhase="";//额度阶段
		String creditOprType="";//额度操作
		// 国内双保理回款
		if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_PAYMENT_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PAYMENT;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//国内双保理  保理商赔款
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_FACTOR_REPARATION_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_MANA_INSURANCE_PAYMENT;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//国内双保理 应收账款转让
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_AANWINST_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PURCHASE;
			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)){
				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)){
				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
			}
		}
		//国内双保理 应收账款减值
		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCEDOUBLEAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_ALLOWANCE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//国内双保理 应收账款反转让
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_BUY_BACK_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_BACK_PURCHASE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//国内双保理 应收账款核销
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_CHARGEOFF;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//信用保理 应收账款回款
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_PAYMENT_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_PAYMENT;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//信用保理 保险公司赔款
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_INSURANCE_REPARATION_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_COMPANY_INSURANCE_PAYMENT;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//信用保理 应收账款转让
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_AANWINST_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_PURCHASE;
			if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)){
				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
			}
			if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)){
				creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
			}
		}
		//信用保理 应收账款减值
		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCECREDITAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_ALLOWANCE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//信用保理 应收账款反转让
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_BUY_BACK_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_BACK_PURCHASE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//信用保理 应收账款核销
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_INSURANCE_CHARGEOFF;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}

		//国内保理 应收账款回款
		else if(WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_DEBT_PAYMENT;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//国内保理 应收账款转让
		else if(WorkflowConstant.APPLI_TYPE_FACTORINGAANWINSTAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PURCHASE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
		}
		//国内保理 应收账款减值
		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCEAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_ALLOWANCE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//国内保理 应收账款反转让
		else if(WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTREPURAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_BACK_PURCHASE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//国内保理 应收账款核销
		else if(WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTCANCELAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_CHARGEOFF;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}

		//租赁保理回款
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_PAYMENT_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASEE_LEASE_FACTORING_INSURANCE_PAYMENT;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//租赁保理转让申请
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_AANWINST_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_PURCHASE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
		}
		// 租赁保理减值
		else if(WorkflowConstant.APPLI_TYPE_ALLOWANCELEASEAPPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_ALLOWANCE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//租赁保理反转让
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_BUY_BACK_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_BACK_PURCHASE;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}
		//租赁保理核销
		else if(WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_LEASE_CHARGE_OFF_APPLY.equalsIgnoreCase(appliType)){
			creditPhase=ScfBasConstant.CREDIT_PHASE_FACTORING_CHARGEOFF;
			creditOprType=ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
		}

		if(!StringUtil.isEmpty(productId)&&!StringUtil.isEmpty(creditPhase)&&!StringUtil.isEmpty(creditOprType)){
			//根据产品Id及操作类型  获取当前业务阶段的额度设定列表
			//设置查询条件
			BPrdCreditBind productCreditBind = new BPrdCreditBind();
			productCreditBind.setProductId(productId); // 产品Id
			productCreditBind.setCreditPhase(creditPhase);
			productCreditBind.setOprType(creditOprType);

			//依据产品Id和操作类型查询
			List<BPrdCreditBind> creditBindList = bprdcreditbindservice.getTblProductCreditBind(productCreditBind);

			CommonCreditProcessBussAmtVO bussAmtVO=new CommonCreditProcessBussAmtVO();
			bussAmtVO.setBussAmount(amt);

			//循环当前业务阶段的额度设定列表,依次处理额度列表中的各种额度
			for(int i=0; i<creditBindList.size(); i++){
				BigDecimal amount = null;  // 操作金额

				//获取产品额度绑定信息
				BPrdCreditBind creditBind = creditBindList.get(i);
				String creditType = creditBind.getCreditType();  // 额度类型
				String oprField = creditBind.getOprField(); // 额度操作金额
				CreditTypeQryVO creditTypeQryVO=new CreditTypeQryVO();
				creditTypeQryVO.setPageIndex(1);
				creditTypeQryVO.setPageSize(Integer.MAX_VALUE);
				creditTypeQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
				creditTypeQryVO.setCreditType_Q(creditType);
				List<BIcrType> listresult = bicrtypeservice.getCreditTypeInfoByCreditTypeQryVO(creditTypeQryVO);
				if(listresult.size()>0){
					//获取额度操作的金额
					String oprFieldName = CreditOptFieldMap.fieldMap.get(oprField);
					try {
						String amountStr = org.apache.commons.beanutils.BeanUtils.getProperty(bussAmtVO, oprFieldName);
						if(StringUtil.isEmpty(amountStr)){
							throw new ScubeBizException("额度操作金额配置错误！", RBcpErrorConstant.ERROR_CODE_UNKNOWN);
						}
						amount = new BigDecimal(amountStr);
						if(amount.compareTo(new BigDecimal("0")) == 0){ // 如果操作金额为等于0则不进行处理
							continue;
						}
					} catch (Throwable te) {
						te.printStackTrace();
						throw new ScubeBizException("额度操作金额配置错误！", RBcpErrorConstant.ERROR_CODE_UNKNOWN);
					}

					// 设置额度处理参数
					CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO=new CreditLimitOfBuyerDealVO();
					creditLimitOfBuyerDealVO.setApplyType(appliType);
					creditLimitOfBuyerDealVO.setAmount(amount);
					creditLimitOfBuyerDealVO.setOperType(operType);
					creditLimitOfBuyerDealVO.setCustcd(custcd);
					creditLimitOfBuyerDealVO.setOtherCustcd(otherCustcd);
					creditLimitOfBuyerDealVO.setBusinessNo(businessno);
					creditLimitOfBuyerDealVO.setCreditType(creditType);
					this.addOrModifyCreditLimitInfoOfBuyer(creditLimitOfBuyerDealVO);
				}
			}
		}
	}
	
	/**
	 *
	 * @Description:新增或修改买方信用限额接口
	 * @author wenkui.xu
	 * @Created 2013-7-16下午04:34:16
	 * @param CreditLimitOfBuyerDealVO
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	public void addOrModifyCreditLimitInfoOfBuyer(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException {

		//校验传入参数  检查数据完整性
		checkCreditLimitOfBuyerDealVO(creditLimitOfBuyerDealVO);
//		bcrmbaseinfoservice
//		TblCustBaseInfoDAO tblCustBaseInfoDAO=SCFDAOUtils.getTblCustBaseInfoDAO();
//		bicrtypeservice
//		TblCreditTypeDAO tblCreditTypeDAO=SCFDAOUtils.getTblCreditTypeDAO();
//		bicrinfoservice
//		TblCreditInfoDAO tblCreditInfoDAO=SCFDAOUtils.getTblCreditInfoDAO();
//		bicrbusireldao
//		TblCreditBusiRelDAO tblCreditBusiRelDAO=SCFDAOUtils.getTblCreditBusiRelDAO();
//		CreditServiceDAO creditServiceDAO=SCFDAOUtils.getCreditServiceDAO();

		String operType=creditLimitOfBuyerDealVO.getOperType();
		String custcd=creditLimitOfBuyerDealVO.getCustcd();
		String otherCustcd=creditLimitOfBuyerDealVO.getOtherCustcd();
		String creditType=creditLimitOfBuyerDealVO.getCreditType();
		String businessNo=creditLimitOfBuyerDealVO.getBusinessNo();

		String custName="";
		String errString="";
		if(!StringUtil.isEmpty(custcd)){
			BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			bCrmBaseInfo.setCustcd(custcd);
			BCrmBaseInfo tblCustBaseInfo=bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			custName=tblCustBaseInfo.getCname();
			errString+="卖方客户【"+custName+"】";
		}

		String otherCustcdName="";
		if(!StringUtil.isEmpty(otherCustcd)){
			BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			bCrmBaseInfo.setCustcd(otherCustcd);
			BCrmBaseInfo tblCustBaseInfo=bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			otherCustcdName=tblCustBaseInfo.getCname();
			errString+="，买方客户【"+otherCustcdName+"】";
		}

		String creditTypeName="";
		if(!StringUtil.isEmpty(creditType)){
			BIcrType tblCreditType = bicrtypeservice.getTblCreditTypeByCreditType(creditType);
			creditTypeName=tblCreditType.getCreditName();
			errString+="，额度类型【"+creditTypeName+"】";
		}

		if (ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equals(operType))// 生效(录入)
		{
			// 检查额度是否存在 条件：当前日期 业务合同号，额度种类，卖方客户号，买方客户号 记录不存在则异常抛出错误
			if (checkCreditLimitOfBuyer(businessNo,custcd, otherCustcd, creditType)) {
					throw new ScubeBizException(errString+"额度信息已存在！", RBcpErrorConstant.RECORD_HAS_EXIST);
			}

			//获取新生成的信用限额额度编号
			String creditNo = bicrinfoservice.getCreditNoOfLimitBuyer();
			creditLimitOfBuyerDealVO.setCreditNo(creditNo);

			// 记录流水新增
			addTblCreditLimitInfoOfBuyerDetail(creditLimitOfBuyerDealVO);

			// 额度信息新增TBL_CREDIT_INFO
			addTblCreditLimitInfoOfBuyerInfo(creditLimitOfBuyerDealVO);

			//额度关联信息新增TBL_CREDIT_BUSI_REL
			bicrbusireldao.addTblCreditBusiRel(ScfBasConstant.CREDIT_RELA_TYPE_CONT,creditNo,creditLimitOfBuyerDealVO.getBusinessNo());
		}
		if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(operType)// 预占用
			||ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(operType)// 占用
			||ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(operType)// 直接占用
			||ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(operType)// 预占用恢复（释放）
			||ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(operType)// 占用恢复（释放）
			||ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(operType)// 冻结
			||ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(operType)// 解冻
			||ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(operType)// 变更
			||ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(operType))// 终止
		{
			// 检查额度是否存在 条件：当前日期 业务合同号，额度种类，卖方客户号，买方客户号 记录不存在则异常抛出错误
			if (!checkCreditLimitOfBuyer(businessNo,custcd, otherCustcd, creditType)) {
				throw new ScubeBizException(errString+"额度信息不存在！", RBcpErrorConstant.RECORD_NOT_EXIST);
			}

			// 检查额度是否存在 条件：当前日期 额度种类，卖方客户号，买方客户号 记录存在则异常抛出错误
			CreditQryVO creditQryVO=new CreditQryVO();
			creditQryVO.setBusinessNo_Q(creditLimitOfBuyerDealVO.getBusinessNo());
			creditQryVO.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
			creditQryVO.setOtherCustcd_Q(creditLimitOfBuyerDealVO.getOtherCustcd());
			creditQryVO.setCreditType_Q(creditLimitOfBuyerDealVO.getCreditType());
			creditQryVO.setPageIndex(1);
			creditQryVO.setPageSize(Integer.MAX_VALUE);
			creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
			Page pageQueryResult = getTblCreditInfoByCreditQryVO(creditQryVO);
			List plist=pageQueryResult.getRecords();
			Object[] obj=(Object[])plist.get(0);
			BIcrInfo tblCreditInfo=(BIcrInfo)obj[0];

			if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCreditNo())){
				creditLimitOfBuyerDealVO.setCreditNo(tblCreditInfo.getCreditNo());

			}
			// 记录流水新增
			addTblCreditLimitInfoOfBuyerDetail(creditLimitOfBuyerDealVO);

			// 更新额度信息TBL_CREDIT_INFO
			modifyTblCreditLimitInfoOfBuyerInfo(creditLimitOfBuyerDealVO);

		}
	}
	
	/**
	 *
	 * @Description: 买方信用限额操作VO参数校验
	 * @author wenkui.xu
	 * @Created 2013-7-16下午04:37:48
	 * @param creditLimitOfBuyerDealVO
	 * @throws CommonException
	 */
	public void checkCreditLimitOfBuyerDealVO(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException {

		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCreditType())){
			throw new ScubeBizException("额度种类信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCustcd())){
			throw new ScubeBizException("卖方客户信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getOtherCustcd())){
			throw new ScubeBizException("买方客户信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getBusinessNo())){
			throw new ScubeBizException("业务合同信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(creditLimitOfBuyerDealVO.getAmount()==null){
			throw new ScubeBizException("操作金额信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getOperType())){
			throw new ScubeBizException("操作类型信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}else{
			//生效(录入)
			if(ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())
					||ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())){// 变更){
			}else if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())//预占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 冻结
				||ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 解冻
				||ScfBasConstant.CREDIT_TRADE_TYPE_END.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 终止
				||ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType())// 预占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(creditLimitOfBuyerDealVO.getOperType()))// 直接占用
			{
				if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getApplyType())){
					throw new ScubeBizException("交易类型信息丢失！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
				}
			}else{
				throw new ScubeBizException("操作类型信息不存在！", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
			}
		}
	}
	
	/**
	 *
	 * @Description:买方信用限额查询校验是否存在
	 * @author wenkui.xu
	 * @Created 2012-9-13上午09:22:16
	 * @param custcd
	 * @param otherCustcd
	 * @param creditType
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	public Boolean checkCreditLimitOfBuyer(String businessNo,String custcd, String otherCustcd,
			String creditType) throws ScubeBizException {
//		CreditServiceDAO creditServiceDAO = SCFDAOUtils.getCreditServiceDAO();
		CreditQryVO creditQryVO=new CreditQryVO();
		creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
		creditQryVO.setBusinessNo_Q(businessNo);
		creditQryVO.setCustcd(custcd);
		creditQryVO.setOtherCustcd_Q(otherCustcd);
		creditQryVO.setCreditType_Q(creditType);
		creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
		creditQryVO.setFlag(ScfBasConstant.FLAG_ON);
		creditQryVO.setPageIndex(1);
		creditQryVO.setPageSize(Integer.MAX_VALUE);
		Page pageQueryResult = getTblCreditInfoByCreditQryVO(creditQryVO);
		List list=pageQueryResult.getRecords();
		if (list != null && list.size() > 0) {
			return true;// 额度存在
		} else {
			return false;// 额度不存在
		}
	}
	
	/**
	 *
	 * @Description: 买方信用限额流水新增
	 * @author wenkui.xu
	 * @Created 2013-7-17上午09:32:31
	 * @param creditLimitOfBuyerDealVO
	 */
	public void addTblCreditLimitInfoOfBuyerDetail(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO)throws ScubeBizException {
		BIcrDtl tblCreditDetail=new BIcrDtl();
		tblCreditDetail.setId(null);
		tblCreditDetail.setCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
		tblCreditDetail.setApplyType(creditLimitOfBuyerDealVO.getApplyType());
		tblCreditDetail.setTxdate(ScfDateUtil.formatDate(new Date()));
		tblCreditDetail.setTxtime(new Date());
		tblCreditDetail.setAppno(creditLimitOfBuyerDealVO.getAppno());
		if(StringUtil.isEmpty(creditLimitOfBuyerDealVO.getAppno())){
			tblCreditDetail.setAppno(creditLimitOfBuyerDealVO.getCreditNo());
		}
		tblCreditDetail.setRelaType(ScfBasConstant.CREDIT_RELA_TYPE_CONT);
		tblCreditDetail.setBusinessno(creditLimitOfBuyerDealVO.getBusinessNo());
		tblCreditDetail.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
		tblCreditDetail.setOperType(creditLimitOfBuyerDealVO.getOperType());
		String operType=creditLimitOfBuyerDealVO.getOperType();
		BigDecimal amount=creditLimitOfBuyerDealVO.getAmount();
		tblCreditDetail.setAmount(amount);
		BIcrInfo tblCreditInfo=null;
		if (ScfBasConstant.CREDIT_TRADE_TYPE_INPUT.equals(operType))// 生效(录入)
		{
			tblCreditDetail.setCreditAmount(new BigDecimal("0"));
			tblCreditDetail.setPreUsedAmount(new BigDecimal("0"));
			tblCreditDetail.setUsedAmount(new BigDecimal("0"));
			tblCreditDetail.setFrzAmount(new BigDecimal("0"));
			tblCreditDetail.setCreditUsableAmount(new BigDecimal("0"));
			tblCreditDetail.setCommonAmount(creditLimitOfBuyerDealVO.getAmount());
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(operType)     // 预占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(operType)         // 冻结
				||ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(operType)){// 直接占用
			tblCreditInfo=bicrinfoservice.findBIcrInfoByCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
			tblCreditDetail.setCreditAmount(tblCreditInfo.getCreditAmount());
			tblCreditDetail.setPreUsedAmount(tblCreditInfo.getPreUsedAmount());
			tblCreditDetail.setUsedAmount(tblCreditInfo.getUsedAmount());
			tblCreditDetail.setFrzAmount(tblCreditInfo.getFrzAmount());
			tblCreditDetail.setCreditUsableAmount(tblCreditInfo.getCreditUsableAmount());
			tblCreditDetail.setCommonAmount(tblCreditInfo.getCreditUsableAmount().subtract(amount));
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(operType)// 占用
				||ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(operType)){// 终止
			tblCreditInfo=bicrinfoservice.findBIcrInfoByCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
			tblCreditDetail.setCreditAmount(tblCreditInfo.getCreditAmount());
			tblCreditDetail.setPreUsedAmount(tblCreditInfo.getPreUsedAmount());
			tblCreditDetail.setUsedAmount(tblCreditInfo.getUsedAmount());
			tblCreditDetail.setFrzAmount(tblCreditInfo.getFrzAmount());
			tblCreditDetail.setCreditUsableAmount(tblCreditInfo.getCreditUsableAmount());
			tblCreditDetail.setCommonAmount(tblCreditInfo.getCreditUsableAmount());
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(operType)// 预占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(operType)// 占用恢复（释放）
				||ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(operType)){// 解冻
			tblCreditInfo=bicrinfoservice.findBIcrInfoByCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
			tblCreditDetail.setCreditAmount(tblCreditInfo.getCreditAmount());
			tblCreditDetail.setPreUsedAmount(tblCreditInfo.getPreUsedAmount());
			tblCreditDetail.setUsedAmount(tblCreditInfo.getUsedAmount());
			tblCreditDetail.setFrzAmount(tblCreditInfo.getFrzAmount());
			tblCreditDetail.setCreditUsableAmount(tblCreditInfo.getCreditUsableAmount());
			tblCreditDetail.setCommonAmount(tblCreditInfo.getCreditUsableAmount().add(amount));
		}else if (ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(operType)){// 变更
			tblCreditInfo=bicrinfoservice.findBIcrInfoByCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
			tblCreditDetail.setCreditAmount(tblCreditInfo.getCreditAmount());
			tblCreditDetail.setPreUsedAmount(tblCreditInfo.getPreUsedAmount());
			tblCreditDetail.setUsedAmount(tblCreditInfo.getUsedAmount());
			tblCreditDetail.setFrzAmount(tblCreditInfo.getFrzAmount());
			tblCreditDetail.setCreditUsableAmount(tblCreditInfo.getCreditUsableAmount());
			tblCreditDetail.setCommonAmount(amount);
		}
		tblCreditDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));
		tblCreditDetail.setLastUpdTime(new Date());;
		tblCreditDetail.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		tblCreditDetail.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());;
		tblCreditDetail.setStatus(ScfBasConstant.CREDIT_STATUS_TERMINATE);
		bicrdtlservice.update(tblCreditDetail);
	}
	
	/**
	 *
	 * @Description: 买方信用限额额度新增
	 * @author wenkui.xu
	 * @Created 2013-7-17上午09:32:31
	 * @param creditLimitOfBuyerDealVO
	 */
	public void addTblCreditLimitInfoOfBuyerInfo(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO)throws ScubeBizException {
		BCntDebtInfo tblContDebtInfo=bCntDebtInfoService.findBCntDebtInfoByKey(creditLimitOfBuyerDealVO.getBusinessNo());
		BIcrInfo tblCreditInfo=new BIcrInfo();
		tblCreditInfo.setCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
		tblCreditInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_LIMIT_BUYER);
		tblCreditInfo.setCreditType(creditLimitOfBuyerDealVO.getCreditType());
		tblCreditInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_ROOT);
		tblCreditInfo.setUpCreditNo(null);
		tblCreditInfo.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
		tblCreditInfo.setOtherCustcd(creditLimitOfBuyerDealVO.getOtherCustcd());
		tblCreditInfo.setCurcd(tblContDebtInfo.getCurcd());
		tblCreditInfo.setControlType(ScfBasConstant.CREDIT_CLASS_CYCLE);
		tblCreditInfo.setCreditAmount(creditLimitOfBuyerDealVO.getAmount());
		tblCreditInfo.setCreditUsableAmount(creditLimitOfBuyerDealVO.getAmount());
		tblCreditInfo.setPreUsedAmount(new BigDecimal("0"));
		tblCreditInfo.setUsedAmount(new BigDecimal("0"));
		tblCreditInfo.setFrzAmount(new BigDecimal("0"));
		tblCreditInfo.setStatus(ScfBasConstant.CREDIT_STATUS_NORMAL);
		tblCreditInfo.setStartDate(tblContDebtInfo.getStartDate());
		tblCreditInfo.setEndDate(tblContDebtInfo.getEndDate());
		//TODO 计算时间差(tblCreditInfo.getStartDate(),tblCreditInfo.getEndDate())
		tblCreditInfo.setTerm(ScfDateUtil.getTenOr(ScfDateUtil.numberToDate(tblCreditInfo.getStartDate()), ScfDateUtil.numberToDate(tblCreditInfo.getEndDate())));
		tblCreditInfo.setValidDate(ScfDateUtil.formatDate(new Date()));
		tblCreditInfo.setLastUpdTime(new Date());

		tblCreditInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		tblCreditInfo.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());;
		bicrinfoservice.updateBIcrInfo(tblCreditInfo);
	}

	/**
	 *
	 * @Description: 买方信用限额额度修改
	 * @author wenkui.xu
	 * @Created 2013-7-17上午09:32:31
	 * @param creditLimitOfBuyerDealVO
	 */
	public void modifyTblCreditLimitInfoOfBuyerInfo(CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO)throws ScubeBizException 
	{
		String custName="";
		String errString="";
		if(!StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCustcd())){
			BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			bCrmBaseInfo.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
			BCrmBaseInfo tblCustBaseInfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			custName=tblCustBaseInfo.getCname();
			errString+="卖方客户【"+custName+"】";
		}

		String otherCustcdName="";
		if(!StringUtil.isEmpty(creditLimitOfBuyerDealVO.getOtherCustcd())){
			BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			bCrmBaseInfo.setCustcd(creditLimitOfBuyerDealVO.getCustcd());
			BCrmBaseInfo tblCustBaseInfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			otherCustcdName=tblCustBaseInfo.getCname();
			errString+="，买方客户【"+otherCustcdName+"】";
		}

		String creditTypeName="";
		if(!StringUtil.isEmpty(creditLimitOfBuyerDealVO.getCreditType())){
			BIcrType tblCreditType = bicrtypeservice.getTblCreditTypeByCreditType(creditLimitOfBuyerDealVO.getCreditType());
			creditTypeName=tblCreditType.getCreditName();
			errString+="，额度类型【"+creditTypeName+"】";
		}
		BIcrInfo updateTblCreditInfo = bicrinfoservice.findBIcrInfoByCreditNo(creditLimitOfBuyerDealVO.getCreditNo());
		//交易金额
		BigDecimal amount =(creditLimitOfBuyerDealVO.getAmount()==null?new BigDecimal("0"):creditLimitOfBuyerDealVO.getAmount());
		//可用余额
		BigDecimal creditUsableAmount=(updateTblCreditInfo.getCreditUsableAmount()==null?new BigDecimal("0"):updateTblCreditInfo.getCreditUsableAmount());
		//预占用金额
		BigDecimal preUsedAmount=(updateTblCreditInfo.getPreUsedAmount()==null?new BigDecimal("0"):updateTblCreditInfo.getPreUsedAmount());
		//已占用金额
		BigDecimal usedAmount=(updateTblCreditInfo.getUsedAmount()==null?new BigDecimal("0"):updateTblCreditInfo.getUsedAmount());
		//冻结金额
		BigDecimal frzAmount=(updateTblCreditInfo.getFrzAmount()==null?new BigDecimal("0"):updateTblCreditInfo.getFrzAmount());

		String operType=creditLimitOfBuyerDealVO.getOperType();
		if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_OCCUPY.equals(operType))//预占用
		{
			if(amount.compareTo(creditUsableAmount)==1){
				throw new ScubeBizException(errString+"的额度预占用时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
		 	//可用额度 = 前可用额度 – 交易金额
			updateTblCreditInfo.setCreditUsableAmount(creditUsableAmount.subtract(amount));//可用金额减少
		 	//预占用额度 = 前预占用额度 + 交易金额
			updateTblCreditInfo.setPreUsedAmount(preUsedAmount.add(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_PRE_RELEASE.equals(operType))//预占用恢复（释放）
		{
			if(amount.compareTo(preUsedAmount)==1){
				throw new ScubeBizException(errString+"的额度恢复时操作金额大于预占用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
		 	//可用额度 = 前可用额度 + 交易金额
			updateTblCreditInfo.setCreditUsableAmount(creditUsableAmount.add(amount));
			//预占用额度 = 前预占用额度 - 交易金额
			updateTblCreditInfo.setPreUsedAmount(preUsedAmount.subtract(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_OCCUPY.equals(operType))//占用
		{
			if(amount.compareTo(preUsedAmount)==1){
				throw new ScubeBizException(errString+"的额度占用时操作金额大于预占用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//预占用额度 = 前预占用额度 - 交易金额
			updateTblCreditInfo.setPreUsedAmount(preUsedAmount.subtract(amount));
			//实占用额度 = 前实占用额度 + 交易金额
			updateTblCreditInfo.setUsedAmount(usedAmount.add(amount));
		}

		if(ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equals(operType))//占用恢复（释放）
		{
			if(amount.compareTo(usedAmount)==1){
				throw new ScubeBizException(errString+"的额度恢复时操作金额大于实占额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度余额 = 前额度余额 + 交易金额
			updateTblCreditInfo.setCreditUsableAmount(creditUsableAmount.add(amount));
			//实占用额度 = 前实占用额度 - 交易金额
			updateTblCreditInfo.setUsedAmount(usedAmount.subtract(amount));
		}

		if(ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equals(operType))//直接占用
		{
			if(amount.compareTo(creditUsableAmount)==1){
				throw new ScubeBizException(errString+"的额度直接占用时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
		 	//额度余额 = 前额度余额 – 交易金额
			updateTblCreditInfo.setCreditUsableAmount(creditUsableAmount.subtract(amount));
			//实占用额度 = 前实占用额度 + 交易金额
			updateTblCreditInfo.setUsedAmount(usedAmount.add(amount));
		}

		if(ScfBasConstant.CREDIT_TRADE_TYPE_CHANGE.equals(operType))//变更
		{
			if(amount.compareTo(usedAmount.add(frzAmount).add(preUsedAmount))<0){
				throw new ScubeBizException(errString+"的额度变更时操作金额小于已使用额度、预占用额度与冻结额度之和，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度总额=交易金额
			updateTblCreditInfo.setCreditAmount(amount);
			//可用额度=交易金额-已使用额度-冻结额度-预占用额度
			updateTblCreditInfo.setCreditUsableAmount(amount.subtract(usedAmount));

		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_FREEZE.equals(operType))//冻结
		{
			if(amount.compareTo(creditUsableAmount)==1){
				throw new ScubeBizException(errString+"的额度冻结时操作金额大于可用额度，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度余额 = 前额度余额 - 交易金额
			updateTblCreditInfo.setCreditUsableAmount(creditUsableAmount.subtract(amount));
			//冻结金额 = 前冻结金额 + 交易金额
			updateTblCreditInfo.setFrzAmount(frzAmount.add(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_UNFREEZE.equals(operType))//解冻
		{
			if(amount.compareTo(frzAmount)==1){
				throw new ScubeBizException(errString+"的额度解冻时操作金额大于冻结金额，请检查数据", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			//额度余额 = 前额度余额 + 交易金额
			updateTblCreditInfo.setCreditUsableAmount(creditUsableAmount.add(usedAmount));
			//冻结金额 = 前冻结金额 - 交易金额
			updateTblCreditInfo.setFrzAmount(frzAmount.subtract(amount));
		}
		if(ScfBasConstant.CREDIT_TRADE_TYPE_END.equals(operType))//终止
		{
			updateTblCreditInfo.setStatus(ScfBasConstant.CREDIT_STATUS_TERMINATE);
		}
		updateTblCreditInfo.setLastUpdTlrcd(ContextHolder.getUserInfo().getTlrNo());
		updateTblCreditInfo.setLastUpdTime(new Date());;
		updateTblCreditInfo.setLastUpdBrcode(ContextHolder.getOrgInfo().getBrNo());
		bicrinfoservice.updateBIcrInfo(updateTblCreditInfo);
	}
	

	/**
	 * 
	 * @Description: 连表查询额度信息 
	 * @author wenkui.xu
	 * @Created 2013-8-13上午11:32:54
	 * @param creditQryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getTblCreditInfoByCreditQryVO(CreditQryVO creditQryVO)throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		StringBuffer  sb=new StringBuffer(" select tci,tcbr  from  TblCreditInfo tci,TblCreditBusiRel tcbr ");
		sb.append(" where tci.creditNo=tcbr.creditNo ");
		if(!StringUtil.isEmpty(creditQryVO.getCreditClass_Q())){
			sb.append(" and  tci.creditClass=?");
			omap.put("creditClass", creditQryVO.getCreditClass_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getNodeType_Q())){
			sb.append(" and  tci.nodeType=?");
			omap.put("nodeType", creditQryVO.getNodeType_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCreditType_Q())){
			sb.append(" and  tci.creditType=?");
			omap.put("creditType", creditQryVO.getCreditType_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCreditNo_Q())){
			sb.append(" and  tci.creditNo=?");
			omap.put("creditNo", creditQryVO.getCreditNo_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getCustcd())){
			sb.append(" and tci.custcd=? ");
			omap.put("custcd", creditQryVO.getCustcd());
		}
		if(!StringUtil.isEmpty(creditQryVO.getOtherCustcd_Q())){
			sb.append(" and tci.otherCustcd=? ");
			omap.put("otherCustcd", creditQryVO.getOtherCustcd_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getStatus_Q())){
			sb.append(" and  tci.status=?");
			omap.put("status", creditQryVO.getStatus_Q());
		}
		if(!StringUtil.isEmpty(creditQryVO.getBusinessNo_Q())){
			sb.append(" and  tcbr.businessNo=?");
			omap.put("businessNo", creditQryVO.getBusinessNo_Q());
		}
		if(ScfBasConstant.FLAG_ON.equalsIgnoreCase(creditQryVO.getFlag())){//是否查询当前日期有效协议
			omap.put("startDate", ScfDateUtil.formatDate(new Date()));
			omap.put("endDate", ScfDateUtil.formatDate(new Date()));
		}
		
		List list = extbicrdao.getTblCreditInfoByCreditQryVO(omap);
		Page pageQueryResult = new Page();
		pageQueryResult.setPageNo(creditQryVO.getPageIndex());
		pageQueryResult.setPageSize(creditQryVO.getPageSize());
		pageQueryResult.setRecords(list);
		pageQueryResult.setTotalRecord(list.size());
		return pageQueryResult;
	}

	
}
