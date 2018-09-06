/**
 * 
 */
package com.huateng.scf.adv.fcs.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.service.IABcpAppliImprestBussService;
import com.huateng.scf.adv.bcp.service.IABcpImprestBussInfoService;
import com.huateng.scf.adv.fcs.model.FourWareLoanQryVO;
import com.huateng.scf.adv.fcs.service.IFourGuaBuyBackService;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotDealInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>* </p>
 *
 * @author shangxiujuan
 * @date 2017年5月4日下午4:37:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年5月4日下午4:37:08              新增
 *
 *            </pre>
 */
@ScubeService
@Service("FourGuaBuybackApplyServiceImpl")
public class FourGuaBuyBackServiceImpl implements IFourGuaBuyBackService ,DealInFlowService,DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService; // 监管协议/担保提货协议/先票(款)后货协议信息表
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bCntMprotPartInfoService; // 多方协议参与者信息

	@Resource(name = "BCntMprotDealInfoServiceImpl")
	IBCntMprotDealInfoService bCntMprotDealInfoService; // [预付款协议扩展信息

	@Resource(name = "ABcpAppliImprestBussServiceImpl") // 预付款业务申请流水
	IABcpAppliImprestBussService aBcpAppliImprestBussService;

	@Resource(name = IABcpImprestBussInfoService.BEAN_ID) // 预付款业务流水
	IABcpImprestBussInfoService aBcpImprestBussInfoService;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	
	@Resource(name = IScfApplyService.BEAN_ID) //供应链业务申请
	IScfApplyService ScfApplyService;
	
	@Resource(name=IScfWorkFlowService.BEAN_ID) //供应链工作流
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bNteNoticeBaseService; //通知书
	
	@Resource(name = "bSysSerialNoService")
	IBSysSerialNoService bSysSerialNoService; //流水号服务
	
	//客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;
		
	/**
	 * 差额退款协议申请信息
	 */
	@Override
	public FourWareLoanVO getFourGuaBuyBackInfo(FourWareLoanQryVO fourQryVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		FourWareLoanVO fourWareLoanVO = new FourWareLoanVO();
		if (null != fourQryVO) {
			String appno = fourQryVO.getAppno();
			if (StringUtil.isStrNotEmpty(appno)) {
				fourWareLoanVO = this.queryBalanceRefundByAppno(appno);
			} else {
				fourWareLoanVO = this.getMarginByProtocolNo(fourQryVO);
			}

		}
		return fourWareLoanVO;
	}

	/**
	 * @Description: 差额退款协议基本信息
	 * @param fourQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public FourWareLoanVO getMarginByProtocolNo(FourWareLoanQryVO fourQryVO) throws ScubeBizException {

		BCntMprotBaseInfo bCntMprotBaseInfo = bCntMprotBaseInfoService
				.findBCntMprotBaseInfoByKey(fourQryVO.getProtocolNo());
		FourWareLoanVO fourVO = new FourWareLoanVO();
		fourVO.setProtocolNo(bCntMprotBaseInfo.getProtocolNo());
		List<BCntMprotPartInfo> list1 = bCntMprotPartInfoService
				.findBCntMpartInfoByProtocolNo(bCntMprotBaseInfo.getProtocolNo());// 通过协议号查询参与方
		for (int j = 0; j < list1.size(); j++) {
			BCntMprotPartInfo mutiProtPartInfo = (BCntMprotPartInfo) list1.get(j);
			if (ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(mutiProtPartInfo.getRole())) {// 授信客户
				fourVO.setCustcd(mutiProtPartInfo.getCustcd());// 借款人
				// 买方名称
				BCrmBaseInfo  sellBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(mutiProtPartInfo.getCustcd());
				if(sellBaseInfo!=null){
					fourVO.setSellerNm(sellBaseInfo.getCname());
				}
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(mutiProtPartInfo.getRole())) {// 监管公司

			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(mutiProtPartInfo.getRole())) {// 核心厂商
				fourVO.setCoreCustcd(mutiProtPartInfo.getCustcd());//
				// 卖方名称
				BCrmBaseInfo  coreBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(mutiProtPartInfo.getCustcd());
				if(coreBaseInfo!=null){
					fourVO.setCoreNm(coreBaseInfo.getCname());
				}
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(mutiProtPartInfo.getRole())) {// 回购厂商
				fourVO.setBackCustcd(mutiProtPartInfo.getCustcd());
				// 承担方
				BCrmBaseInfo  backBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(mutiProtPartInfo.getCustcd());
				if(backBaseInfo!=null){
					fourVO.setBackCustName(backBaseInfo.getCname());
				}
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BANK.equals(mutiProtPartInfo.getRole())) {
				fourVO.setBrcode(mutiProtPartInfo.getCustcd());
			}
		}

		BCntMprotDealInfo tblMutiProtDealInfo = bCntMprotDealInfoService
				.findBCntMprotDealInfoByKey(bCntMprotBaseInfo.getProtocolNo());
		fourVO.setIsInsurance(tblMutiProtDealInfo.getIsInsurance());// 是否购买保险
		fourVO.setStartDate(bCntMprotBaseInfo.getStartDate());
		fourVO.setMastContno(fourQryVO.getMastContno());// TODO
		fourVO.setProductId(bCntMprotBaseInfo.getProductId());
		BigDecimal amountOut = tblMutiProtDealInfo.getAmountOut() == null ? BigDecimal.ZERO
				: tblMutiProtDealInfo.getAmountOut();
		BigDecimal loanAmt = tblMutiProtDealInfo.getLoanAmt() == null ? BigDecimal.ZERO
				: tblMutiProtDealInfo.getLoanAmt();
		fourVO.setAmountOut(amountOut);
		fourVO.setLoanAmt(loanAmt);
		fourVO.setUndeliveryAmt(loanAmt.subtract(amountOut));
		return fourVO;
	}

	/**
	 * DESCRIPTION:根据申请编号查询预付款流水表 
	 * queryBalanceRefundByAppno 方法
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @return
	 */
	public FourWareLoanVO queryBalanceRefundByAppno(String appno) throws ScubeBizException {

		ABcpAppliImprestBuss aBcpAppliImprestBuss = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(appno);
		FourWareLoanVO vo = new FourWareLoanVO();
		if (aBcpAppliImprestBuss != null) {
			BeanUtils.copyProperties(aBcpAppliImprestBuss, vo);
			// 买方名称
			BCrmBaseInfo  sellBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(vo.getCustcd());
			if(sellBaseInfo!=null){
				vo.setSellerNm(sellBaseInfo.getCname());
			}
			vo.setCoreCustcd(aBcpAppliImprestBuss.getUpCustcd());
			// 卖方名称
			BCrmBaseInfo  coreBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(aBcpAppliImprestBuss.getUpCustcd());
			if(coreBaseInfo!=null){
				vo.setCoreNm(coreBaseInfo.getCname());
			}			
			vo.setBackCustcd(aBcpAppliImprestBuss.getGuaranteeCustcd());
			// 承担方名称
			BCrmBaseInfo  backBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(aBcpAppliImprestBuss.getGuaranteeCustcd());
			if(backBaseInfo!=null){
				vo.setBackCustName(backBaseInfo.getCname());
			}				
			vo.setLoanAmt(aBcpAppliImprestBuss.getCollectedAmt());
			vo.setAmountOut(aBcpAppliImprestBuss.getDeliveryAmt());
			vo.setProductId(aBcpAppliImprestBuss.getBussType());
		}
		return vo;
	}

	/**
	 * 先票款后货差额退款申请保存
	 * @param fourWareLoanVO
	 * @param list
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public String saveFourBuybackWriteApply(FourWareLoanVO fourWareLoanVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		String appno = this.saveFourBackInfo(fourWareLoanVO);
		return appno;
	}
	
	/**
	 * 先票款后货差额退款申请提交
	 * @param fourWareLoanVO
	 * @param list
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void saveFourBuybackWriteSubmit(FourWareLoanVO fourWareLoanVO) throws ScubeBizException {
		fourWareLoanVO.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		//差额退款信息的保存--
		String appno = this.saveFourBackInfo(fourWareLoanVO);
		// 保存信息进通知书表
		//通知书编号
		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_CETK_F_NOTICE_NO); 
		fourWareLoanVO.setNum(noticeNo);
		bNteNoticeBaseService.saveFourMarginNoticBaseInfo(appno,fourWareLoanVO);
		//额度校验
		//FourCreditService.getInstance().fourWareCreditProcess(appno, SCFConstants.BUSINESS_STATUS_SUBMIT);
		// 流程流转
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/***
	 * 先票款后货-差额退款审批提交
	 */
	@Transactional
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
	//更新业务申请表状态
	//ThreeService.getInstance().updaterNoticeStatus(commAppInfoVo.getBussAppno(),NoticeConstants.NOTICE_BASE_STATUS_CONFIRM_APPROVED);
	BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
	bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
	bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
	bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
	bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForReject(java.lang.String)
	 */
	@Transactional
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForBack(java.lang.String)
	 */
	@Transactional
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 先票款后货-差额退款 回执确认审批通过
	 */
	@Transactional
	@Override
	public void doWorkForPass(String appNo) {
		// TODO Auto-generated method stub
		bNteNoticeBaseService.updaterNoticeStatus(appNo,BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		aBcpImprestBussInfoService.saveImprestBussInfo(appNo);
		//更新业务申请表状态
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}


	/**
	 * @Description: 四方差额退款申请保存
	 * @param vo
	 * @throws ScubeBizException
	 */
	@Transactional
	public String saveFourBackInfo(FourWareLoanVO vo) throws ScubeBizException{
		String businessnoType = WorkflowConstant.APPLI_TYPE_FOURGUARANTEEBUYBACKAPPLY ;
		String workApplyType = WorkflowConstant.PROCNAME_FOUR_GUA_BUYBACK_APPLY;
		String appno="";
		if(StringUtil.isEmpty(vo.getAppno())){
			appno = ScfApplyService.saveFourBalanceAppBasicInfo(vo,businessnoType,workApplyType);
			vo.setAppno(appno);
			String  custCd=vo.getCustcd(); 
			String  custName=vo.getSellerNm();  //买方名称
			String modelId = workApplyType;
			//发起工作流
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", modelId);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			paramMap.put(WorkflowConstant.CUST_CD, custCd);
			paramMap.put(WorkflowConstant.CUST_NAME, custName);
			try {
				scfWorkFlowService.startWorkFlow(appno, modelId, modelId, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("工作流异常"+e.getMessage());
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_10000),BComErrorConstant.SCF_BAS_COM_10000);
			}
		}else{
			appno = vo.getAppno();
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			bPbcAppliBaseInfo.setAmt(vo.getUndeliveryAmt());
			bPbcAppliBaseInfo.setAppliStatus(vo.getAppliStatus());
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		//保存差额退款流水信息
		this.saveAppliImprestBussInfo(vo);
		return appno;
	}
	/**
	 * DESCRIPTION:先票/款后货差额退款流水保存
	 * saveImprestBussInfo 方法
	 * @param vo
	 * @throws ScubeBizException
	 * @return
	 */
	@Transactional
	public void saveAppliImprestBussInfo(FourWareLoanVO vo) throws ScubeBizException{
		//保存流水信息
		ABcpAppliImprestBuss info = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(vo.getAppno());
		 UserInfo user = ContextHolder.getUserInfo(); 
		if(info != null){
			info.setCollectedAmt(vo.getLoanAmt());//收到款项总计
			info.setDeliveryAmt(vo.getAmountOut());//已发货总计
			info.setUndeliveryAmt(vo.getUndeliveryAmt());//未发货总计
			info.setPaybackTerm(vo.getPaybackTerm());//退款期限
			info.setPaybackAcctNo(vo.getPaybackAcctNo());//账号
			info.setPaybackReason(vo.getPaybackReason());//退款原因
			info.setPayee(vo.getPayee());//收款人名称
			info.setDepositBank(vo.getDepositBank());//开户行
			info.setMgrno(user.getTlrNo());//客户经理
			info.setBrcode(user.getBrNo());//经办机构
			aBcpAppliImprestBussService.updateABcpAppliImprestBuss(info);
		}else{
			ABcpAppliImprestBuss aBcpAppliImprestBuss = new ABcpAppliImprestBuss();
			BeanUtils.copyProperties(vo,aBcpAppliImprestBuss);
			aBcpAppliImprestBuss.setUpCustcd(vo.getCoreCustcd());//卖方客户号
			aBcpAppliImprestBuss.setGuaranteeCustcd(vo.getBackCustcd());//担保方客户号
			aBcpAppliImprestBuss.setCollectedAmt(vo.getLoanAmt());//收到款项总计
			aBcpAppliImprestBuss.setDeliveryAmt(vo.getAmountOut());//已发货总计
			aBcpAppliImprestBuss.setMgrno(user.getTlrNo());//客户经理
			aBcpAppliImprestBuss.setBrcode(user.getBrNo());//经办机构
			aBcpAppliImprestBuss.setBussType(vo.getProductId());//业务品种
			aBcpAppliImprestBussService.addABcpAppliImprestBuss(aBcpAppliImprestBuss);
		}
	}

 
}
