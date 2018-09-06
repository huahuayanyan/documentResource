/**
 * 
 */
package com.huateng.scf.adv.fcs.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.service.IABcpAppliImprestBussService;
import com.huateng.scf.adv.bcp.service.IABcpImprestBussInfoService;
import com.huateng.scf.adv.fcs.dao.IFourDAO;
import com.huateng.scf.adv.fcs.model.FourApplyVO;
import com.huateng.scf.adv.fcs.model.FourDeliveryVO;
import com.huateng.scf.adv.fcs.service.IFourDeliveryService;
import com.huateng.scf.adv.tcs.constant.ATcsErrorConstant;
import com.huateng.scf.adv.tcs.model.ThreeBuyMortgageInfoVO;
import com.huateng.scf.adv.tcs.service.IATcsThreeDeliveryService;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotDealInfoService;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.IndirectCreditConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyBizService;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.nte.service.IBNteNoticeMtgService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月28日下午3:58:36
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月28日下午3:58:36              新增
 *
 * </pre>
 */

@ScubeService
@Service("FourDeliveryServiceImpl")
public class FourDeliveryServiceImpl implements IFourDeliveryService ,DealInFlowService,DealEndFlowService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "FourDAO")
	IFourDAO fourDAO;
	@Resource(name = "ATcsThreeDeliveryServiceImpl")
	IATcsThreeDeliveryService aTcsThreeDeliveryService;
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService bLanLnciBaseService;//借据基本信息表
	@Resource(name = "amountService")
	IAmountService amountService; //金额
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	
	@Resource(name=IScfWorkFlowService.BEAN_ID) //供应链工作流
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService; //监管协议/担保提货协议/先票(款)后货协议信息表
	
	@Resource(name ="BLanLnciBuyBizServiceImpl" )
	IBLanLnciBuyBizService bLanLnciBuyBizService;  //放款购销合同
	
	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bMrnAppliAcctInfoService; //保证金及现金等价物业务申请信息
	
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bNteNoticeBaseService; //通知书
	
	@Resource(name = "ABcpAppliImprestBussServiceImpl")
	IABcpAppliImprestBussService aBcpAppliImprestBussService;
	
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService; //业务申请押品信息
	
	
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;
	
	@Resource(name = "BNteNoticeMtgServiceImpl")
	private  IBNteNoticeMtgService bNteNoticeMtgService;//通知书关联押品信息
	
	// 担保合同信息
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;
	
	// 间接额度通用处理
	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfIndirectCreditService;
	
	// 预付款业务流水
	@Resource(name = IABcpImprestBussInfoService.BEAN_ID)
	IABcpImprestBussInfoService aBcpImprestBussInfoService;
	
	@Resource(name = IBPbcMtgStorDeliService.BEAN_ID)
	IBPbcMtgStorDeliService bPbcMtgStorDeliService; //押品变更流水信息
	
	@Resource(name = "BCntMprotDealInfoServiceImpl")
	IBCntMprotDealInfoService bCntMprotDealInfoService;
	
	private static final String SELLERNM = "sellerNm"; 
	private static final String CORENM="coreNm";
	private static final String PROTOCOLNO="protocolNo";
	private static final String MASTCONTNO = "mastContno"; 
	private static final String STARTDATE1="startDate1";
	private static final String STARTDATE2 = "startDate2"; 
	private static final String CONFIRMSTATUS = "confirmStatus"; 
	private static final String LOANWAY = "loanWay";
	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String STATE = "state";
	private static final String ISSETTLE = "isSettle";
	private static final String DELIVERYMODE = "deliveryMode";
	private static final String APPNO = "appno";
	private static final String DEBETNO = "debetNo";
	//private static final String ADDEDLIST = "addedList";

  /**
   * 提货申请查询列表
   */
	@Override
	public Page queryFourDeliveryListByPage(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != deliveryQryVO) {
			String sellerNm = deliveryQryVO.getSellerNm();// 买方名称
			String coreNm = deliveryQryVO.getCoreNm();// 卖方名称
			String protocolNo = deliveryQryVO.getProtocolNo();// 协议号
			String mastContno = deliveryQryVO.getMastContno();// 信贷合同号
			String startDate1 = deliveryQryVO.getStartDate1();// 日期起
			String startDate2 = deliveryQryVO.getStartDate2(); // 日期至
			String loanWay = deliveryQryVO.getLoanWay(); // 出账方式
			String confirmStatus = deliveryQryVO.getStatus();// 收款确认状态
			if(StringUtil.isStrNotEmpty(sellerNm)){
				map.put(SELLERNM, sellerNm);
			}
			if(StringUtil.isStrNotEmpty(coreNm)){
				map.put(CORENM, coreNm);
			}
			if(StringUtil.isStrNotEmpty(protocolNo)){
				map.put(PROTOCOLNO, protocolNo);
			}
			if(StringUtil.isStrNotEmpty(mastContno)){
				map.put(MASTCONTNO, mastContno);
			}
			if(StringUtil.isStrNotEmpty(startDate1)){
				map.put(STARTDATE1, startDate1);
			}
			if(StringUtil.isStrNotEmpty(startDate2)){
				map.put(STARTDATE2, startDate2);
			}
	
			if(StringUtil.isStrNotEmpty(loanWay)){
				map.put(LOANWAY, loanWay);
			}
			if(StringUtil.isStrNotEmpty(confirmStatus)){
				map.put(CONFIRMSTATUS, confirmStatus);
			}
		}
		map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_FOURWH);
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		map.put(STATE, BSysConstant.FLAG_OFF); //记录状态
		map.put(ISSETTLE, BSysConstant.FLAG_OFF); //是否结清
		map.put(DELIVERYMODE, ScfBasConstant.MORTGAGE_MANAGE_MODE_ONETOONE); //押品对应方式:1,一一对应;2,总量对应
		fourDAO.selectFourDeliveryList(map, page);
		return page;
	}
	
	/**
	 * 提货申请信息
	 */
	@Override
	public FourDeliveryVO getFourDeliveryInfo(DeliveryQryVO deliveryQryVO) throws ScubeBizException {
		FourDeliveryVO fourDeliveryVO = new FourDeliveryVO();
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != deliveryQryVO) {
			String appno = deliveryQryVO.getAppno();
			String debetNo=  deliveryQryVO.getDebetNo();
			if(StringUtil.isStrNotEmpty(appno)){
				map.put(APPNO, appno);
			}
			if(StringUtil.isStrNotEmpty(debetNo)){
				map.put(DEBETNO, debetNo);
			}
			if(StringUtil.isStrNotEmpty(appno)){
				fourDeliveryVO=this.getFourDeliveryInfoByAppno(map);
			}else{
				fourDeliveryVO=this.getFourDeliveryInfoByDebetNo(map);
			}
		
		}
		return fourDeliveryVO;
	}
	/**
	 * 根据借据号查询提货信息
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public FourDeliveryVO getFourDeliveryInfoByDebetNo(Map<String, Object> map) throws ScubeBizException {
		FourDeliveryVO vo = new FourDeliveryVO();
		com.huateng.scf.adv.fcs.dao.model.FourDeliveryVO dalVO = new  com.huateng.scf.adv.fcs.dao.model.FourDeliveryVO();
		dalVO=fourDAO.getFourDeliveryInfoByDebetNo(map);
		if(dalVO!=null){
			BeanUtils.copyProperties(dalVO, vo);
		}
		//TODO
		AmountVO amountVO = new AmountVO();
		amountVO.setProductId(vo.getProductId());
		amountVO.setDebetNo(vo.getDebetNo());
		amountVO.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE); 
		BigDecimal canDeliveryAmt = BigDecimal.ZERO;
		BigDecimal openAmount = BigDecimal.ZERO;
		//AmountVO amountVO=new AmountVO(vo.getProductId(),null,null,vo.getDebetNo(),ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);//单笔模式
		canDeliveryAmt=amountService.getDelivery(amountVO);//可提货金额
		openAmount=amountService.getPant(amountVO);//敞口余额
		if(canDeliveryAmt.compareTo(BigDecimal.ZERO)<0){
			vo.setCanDeliveryAmt(BigDecimal.ZERO);
		}else{
			vo.setCanDeliveryAmt(canDeliveryAmt);
		}
		if(openAmount.compareTo(BigDecimal.ZERO)<0){
			vo.setOpenAmount(BigDecimal.ZERO);
		}else{
			vo.setOpenAmount(openAmount);
		}
		return vo;
	}
	
	/**
	 * 根据申请编号查询提货申请信息
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public FourDeliveryVO getFourDeliveryInfoByAppno(Map<String, Object> map) throws ScubeBizException {
		FourDeliveryVO vo = new FourDeliveryVO();
		com.huateng.scf.adv.fcs.dao.model.FourDeliveryVO dalVO = new  com.huateng.scf.adv.fcs.dao.model.FourDeliveryVO();
		dalVO=fourDAO.getFourDeliveryInfoByAppno(map);
		if(dalVO!=null){
			BeanUtils.copyProperties(dalVO, vo);
		}
		//TODO
		AmountVO amountVO = new AmountVO();
		amountVO.setProductId(vo.getProductId());
		amountVO.setDebetNo(vo.getDebetNo());
		amountVO.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
		//AmountVO amountVO=new AmountVO(vo.getProductId(),null,null,vo.getDebetNo(),ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
		amountVO.setAddBailAmount(vo.getAddBailAmount());
		BLanLnciBase lnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(vo.getDebetNo());
		amountVO.setLnciType(lnciBase.getLnciType());
		BigDecimal canDeliveryAmt = BigDecimal.ZERO;
		BigDecimal openAmount = BigDecimal.ZERO;
		canDeliveryAmt = amountService.getDelivery(amountVO);// 可提货金额
		openAmount = amountService.getPant(amountVO);// 敞口金额
		/*if (canDeliveryAmt.compareTo(BigDecimal.ZERO) < 0) {
			vo.setCanDeliveryAmt(BigDecimal.ZERO);
		} else {
			vo.setCanDeliveryAmt(canDeliveryAmt);
		}
		if (openAmount.compareTo(BigDecimal.ZERO) < 0) {
			vo.setOpenAmount(BigDecimal.ZERO);
		} else {
			vo.setOpenAmount(openAmount);
		}*/
		return vo;
	}
	/**
	 * 先票款后货提货申请保存
	 */
	@Override
	@Transactional
	public String saveFourDeliveryAppInfoUpdate(FourDeliveryVO fourDeliveryVO, List<ThreeBuyMortgageInfoVO> list)
			throws ScubeBizException {
		
		String appno =this.savaFourDeliveryInfo(fourDeliveryVO, list,false);
		return appno;
	}
	

	/**
	 * 先票款后货提货申请提交
	 * @throws FlowsharpException 
	 */
	@Transactional
	@Override
	public void saveFourDeliveryAppInfoSubmit(FourDeliveryVO fourDeliveryVO, List<ThreeBuyMortgageInfoVO> list)
			throws ScubeBizException, FlowsharpException {
		// TODO Auto-generated method stub
		String appno = this.savaFourDeliveryInfo(fourDeliveryVO, list,true);
		
		//流程流转
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
	
	}
	
	

	/**
	 * 提货申请提交审批
	 */
	@Transactional
	@Override
	public void doWorkForSubmit(String appno) throws ScubeBizException {
		// TODO Auto-generated method stub
		this.deliveryApproveCheck(appno);// 审批时校验数据
		// TODO 保证金冻结 暂无

		// 审批通过签发通知书
		bNteNoticeBaseService.updaterNoticeStatus(appno, BNteConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);
		// TODO通知书信息同步到FS系统 暂无
		// 业务申请表状态更新
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}
	
	/**
	 * 提货申请审批退回
	 */
	@Transactional
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		//删除通知书
    	bNteNoticeBaseService.deleteBNteNoticeBaseByAppno(appNo);
    	//更新业务申请表状态
    	BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
/*    	bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_GOBACK);
    	bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_GOBACK);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);*/
    	String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;//退回到上一个节点
    	try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo,status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("工作流异常"+e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_10000),BComErrorConstant.SCF_BAS_COM_10000); 
		}
	}
	
	/***
	 * 流程审批拒绝
	 */
	@Transactional
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		//流程借据解锁
		bLanLnciBaseService.releaseDebtBaseInfoByLockAppno(appNo);
    	//删除通知书
    	bNteNoticeBaseService.deleteBNteNoticeBaseByAppno(appNo);
    	//更新业务申请表状态
    	BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
    	bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED);
    	bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
    	bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}
	
	/**
	 * 提货申请审批通过
	 */
	@Override
	@Transactional
	public void doWorkForPass(String appno) {
		// TODO Auto-generated method stub
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String debetNo=bPbcAppliBaseInfo.getExt1();//借据号
		//写入正式表 通知书状态更新
    	this.updateFourDeliveryInfo(appno);
    	//借据解锁
    	bLanLnciBaseService.releaseDebtBaseInfoByLockAppno(appno);
		
        //释放额度
    	ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(appno);
		
    	Map<String, String> indirectMap = new HashMap<String, String>();
		indirectMap.put(IndirectCreditConstant.APP_NO, appno); //业务申请号
		indirectMap.put(IndirectCreditConstant.DEBIT_NO, debetNo);
		indirectMap.put(IndirectCreditConstant.OPER_TYPE, ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE); ////操作类型
		scfIndirectCreditService.indCreditAppliCommonProcess(indirectMap, abcpAppliImprestBuss.getAddBailAmt());
    	//IndirectCreditService.getInstance().indirectCreditAppliCommonProcess(commAppInfoVo.getBussAppno(), null,SCFConstants.CREDIT_TRADE_TYPE_RELEASE, tblAppliImprestBussInfo.getAddBailAmt());
		//更新业务申请表状态
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}


	
/**
 * DESCRIPTION:提货申请报存流程及业务信息(线下)
 * @param fourDeliveryVO
 * @param list
 * @param flag
 * @return
 * @throws ScubeBizException
 */
	@Transactional
	public String savaFourDeliveryInfo(FourDeliveryVO fourDeliveryVO,List<ThreeBuyMortgageInfoVO> list,Boolean flag) throws ScubeBizException{
		String appno="";
		FourApplyVO applyVO = new FourApplyVO();
	/*	applyVO.setDebetNo(fourDeliveryVO.getDebetNo());
		applyVO.setAmount(fourDeliveryVO.getAmount());
		applyVO.setMemo(fourDeliveryVO.getMemo());*/
		BeanUtils.copyProperties(fourDeliveryVO, applyVO); 
		//获得对应的监管协议号和抵质押合同，监管合同号查询下和抵质押合同查询会用到 add 
		String protocolNo = fourDeliveryVO.getProtocolNo(); //先票款后货协议号 
		List<BCntMprotBaseInfo> mutiList = bCntMprotBaseInfoService.getProtocolByOtherProtocol(protocolNo,ScfBasConstant.MUTI_PROTOCOL_MONI);
		if(mutiList!=null&&mutiList.size()>0){ 
			BCntMprotBaseInfo bCntMprotBaseInfo =mutiList.get(0);
			if (bCntMprotBaseInfo != null) { 
				applyVO.setMonitorProtocolNo(bCntMprotBaseInfo.getProtocolNo()); 
				List<BCrrGntyCon> slaveList = bCrrGntyConService.getContSlaveByProtocolNo(bCntMprotBaseInfo.getProtocolNo());
 				if (slaveList != null && slaveList.size() > 0) {
					applyVO.setSlaveContno(((BCrrGntyCon) slaveList.get(0)).getConId()); // 质押合同号
					}
			}
		}
		if(StringUtil.isEmpty(applyVO.getAppno())){
			String businessnoType = WorkflowConstant.APPLI_TYPE_FOURHOUSEDELIVERYAPPLY;
			String workApplyType  = WorkflowConstant.PROCNAME_ONE2ONEFOURDELIVERYAPPLY;
			//0-流程互斥校验
			//0-流程互斥校验
			BLanLnciBase baseInfo = bLanLnciBaseService.findBLanLnciBaseByKey(fourDeliveryVO.getDebetNo());
			
			if(ScfBasConstant.LOCKED.equals(baseInfo.getIsLocked())){
				log.error("借据【"+baseInfo.getDebetId()+"】下存在尚未审批的提货申请流程【"+baseInfo.getLockAppno()+"】，无法提交本次申请。");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_20000),ATcsErrorConstant.SCF_ADV_TCS_20000);
			}
			appno = bPbcAppliBaseInfoService.saveOrUpdateAppInfo(applyVO,businessnoType,workApplyType);//发起流程
			applyVO.setAppno(appno);
			fourDeliveryVO.setAppno(appno);

			this.saveFourDeliveryAppInfo(applyVO,fourDeliveryVO,list,flag);//保存业务信息
			//借据锁定
			bLanLnciBaseService.lockDebtBaseInfo(fourDeliveryVO.getDebetNo(), appno);
			   // 工作流开始
			String  custCd=fourDeliveryVO.getCustcd(); 
			String  custName=fourDeliveryVO.getCname();  //买方名称
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
			appno = applyVO.getAppno();
			applyVO.setAppno(applyVO.getAppno());
			fourDeliveryVO.setProtocolNo(applyVO.getProtocolNo());
			fourDeliveryVO.setMastContno(applyVO.getMastContno());
			fourDeliveryVO.setAppno(applyVO.getAppno());
			fourDeliveryVO.setCustcd(applyVO.getCustcd());
			fourDeliveryVO.setCoreCustcd(applyVO.getCoreCustcd());
			this.saveFourDeliveryAppInfo(applyVO,fourDeliveryVO,list,flag);//保存业务信息
			BPbcAppliBaseInfo appliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			//appliBaseInfo.setAmt(threeDeliveryVO.getLnciAmt());
			appliBaseInfo.setAmt(fourDeliveryVO.getAmount());
			//appliBaseInfo.setRiskamt(applyVO.getOpenAmount()); //弃用字段
			appliBaseInfo.setMemo(fourDeliveryVO.getMemo());
			//appliBaseInfo.setDescription(vo.getDescription());
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(appliBaseInfo);
		}
		return appno;
	}
	
	/**
	 * DESCRIPTION:提货申请业务信息保存(线下)
	 * @author zhoujun.hou
	 * @date 2013-4-26
	 * saveThreeDeliveryAppInfo 方法
	 * @param storDeliInfoVO
	 * @param basicVO
	 * @param list
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
	@Transactional
	public void saveFourDeliveryAppInfo(FourApplyVO  vo,FourDeliveryVO fourDeliveryVO,List<ThreeBuyMortgageInfoVO> list,Boolean flag) throws ScubeBizException{
		//基本申请信息校验&&获取
		BPbcAppliBaseInfo bean = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(fourDeliveryVO.getAppno());
		if(bean == null){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002),ATcsErrorConstant.SCF_ADV_TCS_10002);
		}
		//if(flag){
			//0、校验数据
			this.deliveryCheck(fourDeliveryVO,list,flag);
		//}
    	//1、保存业务流水信息
    	this.fourDeliveryAppBasicInfoSave(fourDeliveryVO,bean);
    	//2、保存货物信息申请表
    	this.fourDeliveryAppMortListSave(fourDeliveryVO,list);
    	//3生成通知书
    	if(flag){
    		this.fourDeliveryNoticeInfoSave(vo.getAppno());//生成通知书
    	}
	}
/**
 * DESCRIPTION:提货流程提交申请校验数据
 * @param deliveryVO
 * @param insertList
 * @param flag
 * @throws ScubeBizException
 */
	@Transactional
	public void deliveryCheck(FourDeliveryVO deliveryVO,List<ThreeBuyMortgageInfoVO> insertList,boolean flag) throws ScubeBizException{

		//验证提货金额不大于购销合同总金额

		Map<String,BigDecimal> map=new HashMap<String,BigDecimal>();
		if(insertList!=null && insertList.size()>0){
    		for(int i = 0 ; i < insertList.size() ; i++){
    			ThreeBuyMortgageInfoVO vo = (ThreeBuyMortgageInfoVO) insertList.get(i);
    			String tradeContno=vo.getTradeContno();
    			BigDecimal totPrice=vo.getTotPrice()==null?BigDecimal.ZERO:vo.getTotPrice();
    			if(!map.isEmpty()&&map!=null&&map.size()>0&&map.containsKey(tradeContno)){
    				BigDecimal ototPrice=(BigDecimal) map.get(tradeContno);
    				map.put(tradeContno,totPrice.add(ototPrice));
    			}else{
    				map.put(tradeContno,totPrice);
    			}
    		}

    		if(!map.isEmpty()&&map!=null&&map.size()>0){
	    		Iterator iter=map.keySet().iterator();
	    		while(iter.hasNext()){
	    			String tradeContno=(String) iter.next();
	    			BigDecimal totPrice=map.get(tradeContno);
	    			tradeContno=tradeContno==null?"":tradeContno.trim();
	    			//TblContBuyInfo tcbi=DAOUtils.getTblContBuyInfoDAO().get(tradeContno);
	    			//BigDecimal contAmt=tcbi.getAmt()==null?BigDecimal.ZERO:tcbi.getAmt();
	    			//BigDecimal accuDeliAmt=tcbi.getAccuDeliAmt()==null?BigDecimal.ZERO:tcbi.getAccuDeliAmt();
	    			//String tradeContCode=tcbi.getTradeContcode();
	    			BigDecimal loanAmt=BigDecimal.ZERO;
	    			BigDecimal accuWthdrawAmt=BigDecimal.ZERO;
	    			String tradeContCode="";
	    			BLanLnciBuyBiz bLanLnciBuyBizQry = new BLanLnciBuyBiz();
	    			bLanLnciBuyBizQry.setTradeContno(tradeContno);
	    			bLanLnciBuyBizQry.setDebetNo(deliveryVO.getDebetNo());
	    			List<BLanLnciBuyBiz> Bizlist =bLanLnciBuyBizService.findBLanLnciBuyBizByCondition(bLanLnciBuyBizQry);
	    			BLanLnciBuyBiz bLanLnciBuyBiz=null;
	    			if(Bizlist!=null&&Bizlist.size()>0){
	    				bLanLnciBuyBiz=(BLanLnciBuyBiz)Bizlist.get(0);
		    			 loanAmt=bLanLnciBuyBiz.getLoanAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getLoanAmt();//本次出账金额
		    			 accuWthdrawAmt=bLanLnciBuyBiz.getAccuWithdrawAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getAccuWithdrawAmt();//本次出账购销合同下的累计提货金额
		    			 tradeContCode=bLanLnciBuyBiz.getTradeContcode();
	    			}else{
	    				log.error("购销合同："+tradeContno+"获取放款购销合同失败！");
	    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40000),ATcsErrorConstant.SCF_ADV_TCS_40000);
	    			}

	    			if(totPrice.compareTo(loanAmt.subtract(accuWthdrawAmt))>0){
	    				log.error("购销合同号为【"+tradeContCode+"】的提货总金额【"+totPrice+"】大于当前放款购销合同下的可提货金额【"+loanAmt.subtract(accuWthdrawAmt)+"】！");
	    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40001),ATcsErrorConstant.SCF_ADV_TCS_40001);
	    			}
	    		}
    		}

		}

		//提交
		if(flag){
			//BigDecimal canDeliveryAmt = deliveryVO.getCanDeliveryAmt()==null?BigDecimal.ZERO:deliveryVO.getCanDeliveryAmt();//本次可提货金额
			BigDecimal amount = deliveryVO.getAmount()==null?BigDecimal.ZERO:deliveryVO.getAmount();//本次申请提货金额
	    	BigDecimal addBailAmount = deliveryVO.getAddBailAmount()==null?BigDecimal.ZERO:deliveryVO.getAddBailAmount();//本次追加保证金金额
			//查询产品编号
			String productId= "";
			/*ContractService service = ContractService.getInstance();
			List warelist = service.getTblProductWarehouse(SCFConstants.MUTI_PROTOCOL_THREEWH);
			if(warelist!=null && warelist.size()>0){
				TblProductWarehouse productWarehouse =(TblProductWarehouse)warelist.get(0);
				productId=productWarehouse.getProductId();
			}*/
			productId = deliveryVO.getProductId();
			AmountVO amountvo = new AmountVO();
			amountvo.setProductId(productId);
			amountvo.setDebetNo(deliveryVO.getDebetNo());
			amountvo.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
	    	//amountvo = new AmountVO(productId,null,null,deliveryVO.getDebetNo(),SCFConstants.ARRIVED_MANAGE_MODE_SINGLE);
	    	amountvo.setAddBailAmount(addBailAmount);
			BigDecimal canDeliveryAmt=BigDecimal.ZERO;//可提货金额
			canDeliveryAmt = amountService.getDelivery(amountvo); 


	    	if(amount.compareTo(canDeliveryAmt)>0){
	    		log.error("本次申请提货金额不能大于本次可提货金额！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40002),ATcsErrorConstant.SCF_ADV_TCS_40002);
	    	}
	    	if(insertList!=null && insertList.size()>0){
	    		for(int i = 0 ; i < insertList.size() ; i++){
	        		ThreeBuyMortgageInfoVO vo = (ThreeBuyMortgageInfoVO) insertList.get(i);
	        		String mortgageNo = vo.getMortgageNo();
	        		if(mortgageNo==null || mortgageNo.trim().equals("")){
	        			log.error("货物编号丢失！");
	    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40003),ATcsErrorConstant.SCF_ADV_TCS_40003);
	        		}
	        		String mortgageModel = vo.getMortgageModel();
	        		BigDecimal quantity= vo.getQuantity()==null?BigDecimal.ZERO:vo.getQuantity();
	        		BigDecimal totPrice = vo.getTotPrice()==null?BigDecimal.ZERO:vo.getTotPrice();
	        		if(StringUtil.isEmpty(mortgageModel)){
	        			log.error("货物编号:"+mortgageNo+"规格型号不能为空！");
	    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40004),ATcsErrorConstant.SCF_ADV_TCS_40004);
	        		}
	/*        		if(quantity.compareTo(BigDecimal.ZERO)<=0){
	        			ExceptionUtil.throwScubeBizException("货物编号:"+mortgageNo+"提货数量必须大于0！",SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR);
	        		}*/
	        		if(totPrice.compareTo(BigDecimal.ZERO)<=0){
	        			log.error("货物编号:"+mortgageNo+"提货金额必须大于0！");
	    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40005),ATcsErrorConstant.SCF_ADV_TCS_40005);
	        		}
	        	}
	    	}else{
	    		log.error("提货列表不能为空！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40006),ATcsErrorConstant.SCF_ADV_TCS_40006);
	    	}
	    	if(addBailAmount.compareTo(BigDecimal.ZERO)>0){
	    		List<BMrnAppliAcctInfo>  accountList = bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(deliveryVO.getAppno());
	    		if(accountList!=null && accountList.size()>0){
	    			BigDecimal totalAddBailAmount = BigDecimal.ZERO;
		        	for (int i = 0; i < accountList.size(); i++) {
		        		BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo) accountList.get(i);
		        		BigDecimal bailAmount = bean.getAmount()==null?BigDecimal.ZERO:bean.getAmount();//冻结保证金列表
		        		totalAddBailAmount=totalAddBailAmount.add(bailAmount);
		    		}
		        	if(addBailAmount.compareTo(totalAddBailAmount)!=0){
		        		log.error("追加冻结金额总金额必须等于本次追加保证金总额！");
	    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40009),ATcsErrorConstant.SCF_ADV_TCS_40009);
		        	}
	    		}else{
	    			log.error("保证金追加列表记录不能为空！");
    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40010),ATcsErrorConstant.SCF_ADV_TCS_40010);
	    		}
	    	}

		}
    }
	
	/**
	 *  DESCRIPTION:保存提货申请信息(线下)
	 * @param vo
	 * @param appliBaseInfo
	 * @throws ScubeBizException
	 */
	@Transactional
	public void fourDeliveryAppBasicInfoSave(FourDeliveryVO vo,BPbcAppliBaseInfo appliBaseInfo) throws ScubeBizException{
		BNteNoticeBase noticeBean = null;
		if(StringUtil.isStrNotEmpty(vo.getNoticeId())){
			noticeBean = bNteNoticeBaseService.findBNteNoticeBaseByKey(vo.getNoticeId());
			if(noticeBean==null){
				log.error("票/款确认书信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40007),ATcsErrorConstant.SCF_ADV_TCS_40007);
			}
		}
		BLanLnciBase  bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(vo.getDebetNo());
		if(bLanLnciBase==null){
			log.error("银票/借据信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40008),ATcsErrorConstant.SCF_ADV_TCS_40008);
		}
		ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(vo.getAppno());
		UserInfo user = ContextHolder.getUserInfo(); 
		if(abcpAppliImprestBuss!=null){
			abcpAppliImprestBuss.setCommonAmt(vo.getAmount());// 本次申请提货总金额
			abcpAppliImprestBuss.setPickAmt(vo.getCanDeliveryAmt());//本次可提货金额
			abcpAppliImprestBuss.setAddBailAmt(vo.getAddBailAmount());//本次追加保证金
			abcpAppliImprestBuss.setCoreBailAmt(vo.getCoreBailAmount());//核心保证金金额
			abcpAppliImprestBuss.setRiskAmt(vo.getOpenAmount()==null?BigDecimal.ZERO:vo.getOpenAmount());//敞口余额
			aBcpAppliImprestBussService.updateABcpAppliImprestBuss(abcpAppliImprestBuss);
		}else{
			ABcpAppliImprestBuss bean = new ABcpAppliImprestBuss();
			//3、存储数据
			bean.setAppno(vo.getAppno());
			bean.setCustcd(vo.getCustcd());//借款人
			bean.setUpCustcd(vo.getCoreCustcd());//上游厂商
			bean.setMastContno(appliBaseInfo.getMastContno());//主合同
			bean.setProtocolNo(vo.getProtocolNo());//担保提货协议编号
			bean.setDebetNo(appliBaseInfo.getExt1());//银承号/借据号
			bean.setCommonAmt(vo.getAmount());// 本次申请提货总金额
			bean.setUndeliveryAmt(vo.getAmountIn());//剩余提货金额
			bean.setDeliveryAmt(vo.getAmountOut());//累计提货金额
			bean.setCoreBailAmt(vo.getCoreBailAmount());//核心保证金金额
			bean.setAddBailAmt(vo.getAddBailAmount());//本次追加保证金
			bean.setInitAmtPercent(vo.getFirstBailRatio());//初始自有资金比例
			bean.setPickAmt(vo.getCanDeliveryAmt());//本次可提货金额
			bean.setCashEqtAmt(vo.getCashEqtAmt());//现金等价物
			bean.setBussType(vo.getProductId());//业务类型
			bean.setFirstBailType(vo.getFirstBailType());//保证金类型
			bean.setApplyType(appliBaseInfo.getAppliType());
			bean.setMgrno(user.getTlrNo());//客户经理
			bean.setBrcode(user.getBrNo());//经办机构
			bean.setCreateDate(BSysConstant.WORKDATE);
			if(noticeBean!=null){
				bean.setNum(noticeBean.getNum());//票款确认书编号
			}

			//借据敞口 = 借据余额-初始保证金金额-追加保证金金额-初始现金等价物金额-追加现金等价物金额
			BigDecimal lnciBal = bLanLnciBase.getLnciBal()==null?BigDecimal.ZERO:bLanLnciBase.getLnciBal();
			BigDecimal bailAmount = bLanLnciBase.getBailAmount() ==null?BigDecimal.ZERO:bLanLnciBase.getBailAmount();
			BigDecimal addBaillAmount  = bLanLnciBase.getAddBailAmount() ==null?BigDecimal.ZERO:bLanLnciBase.getAddBailAmount();
			BigDecimal addBaillAmount_v= vo.getAddBailAmount() ==null?BigDecimal.ZERO:vo.getAddBailAmount();
			BigDecimal addCashEqtAmt= bLanLnciBase.getAddCashEqtAmt() ==null?BigDecimal.ZERO:bLanLnciBase.getAddCashEqtAmt();
			BigDecimal initCashEqtAmt= bLanLnciBase.getInitCashEqtAmt() ==null?BigDecimal.ZERO:bLanLnciBase.getInitCashEqtAmt();
			BigDecimal tempAmt = lnciBal.subtract(bailAmount).subtract(addBaillAmount).subtract(addBaillAmount_v).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
			/*if(tempAmt.compareTo(new BigDecimal("0"))<=0){
				bean.setRiskAmt(new BigDecimal("0"));//敞口余额
			}else{
				bean.setRiskAmt(tempAmt);//敞口余额
			}*/
			bean.setRiskAmt(vo.getOpenAmount()==null?BigDecimal.ZERO:vo.getOpenAmount());//敞口余额

			bean.setLnciBal(bLanLnciBase.getLnciBal());//借据金额
			bean.setLnciAmt(bLanLnciBase.getLnciAmt());//借据余额
			//bean.setId(null);
			aBcpAppliImprestBussService.addABcpAppliImprestBuss(bean);
		}
	}
	
	/**
	 * DESCRIPTION:提货申请保存货物信息(线下)
	 * @author zhoujun.hou
	 * @date 2013-4-26
	 * ThreeDeliveryAppMortListSave 方法
	 * @param vo
	 * @param insertList
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public void fourDeliveryAppMortListSave(FourDeliveryVO vo,List<ThreeBuyMortgageInfoVO> insertList) throws ScubeBizException{

		//1、获得已存在押品列表
		List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(vo.getAppno());
    	//2、删除已存在押品列表
    	for (int i = 0; i < mortList.size(); i++) {
    		BPbcAppliMtgInfo bean = (BPbcAppliMtgInfo) mortList.get(i);
    		bPbcAppliMtgInfoService.deleteBPbcAppliMtgInfo(bean.getId());
		}
    	//3、添加押品列表
    	for (Iterator<ThreeBuyMortgageInfoVO> iterator = insertList.iterator(); iterator.hasNext();) {
			ThreeBuyMortgageInfoVO mortVO = (ThreeBuyMortgageInfoVO) iterator.next();
			BPbcAppliMtgInfo bean = new BPbcAppliMtgInfo();
			bean.setAppno(vo.getAppno());
			bean.setOtherProtocolNo(vo.getProtocolNo());//协议号
			bean.setMortgageNo(mortVO.getMortgageNo());
			bean.setMortgageName(mortVO.getMortgageName());
			bean.setMortgageLevelOne(mortVO.getMortgageLevelOne());
			bean.setMortgageLevelTwo(mortVO.getMortgageLevelTwo());
			bean.setMortgageModel(mortVO.getMortgageModel());//规格型号
			bean.setTradeContno(mortVO.getTradeContno());
			bean.setQuantity(mortVO.getOutQuantity());
			bean.setBillQuantity(mortVO.getQuantity());
			bean.setConfirmPrice(mortVO.getConfirmPrice());
			bean.setMortgageUnits(mortVO.getMortgageUnits()==null?(mortVO.getCountUnits()==null?"":mortVO.getCountUnits()):mortVO.getMortgageUnits());//计量单位
			bean.setTotPrice(mortVO.getTotPrice());
			bean.setDocumentNo(mortVO.getDocumentNo());//相关凭证号
			bean.setDescription(mortVO.getMemo());
			bean.setOriginalTotPrice(mortVO.getOriginalTotPrice());//原总价
			bean.setPrice(mortVO.getPrice());
			bean.setCurcd(mortVO.getCurcd());
			//bean.setBrcode(GlobalInfo.getCurrentInstance().getBrcode());
			bean.setManufactureDate(BSysConstant.WORKDATE);
			bean.setAppliMortBizType(WorkflowConstant.APPLI_TYPE_FOURHOUSEDELIVERYAPPLY);

			//bean.setId(null);
			bPbcAppliMtgInfoService.addBPbcAppliMtgInfo(bean);
		}

    }
	
	/**
	 * DESCRIPTION:保兑仓提货申请生成通知书(线下)
	 * @author zhoujun.hou
	 * @date 2013-4-26
	 * ThreeDeliveryNoticeInfoSave 方法
	 * @param appno
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
	@Transactional
	public void fourDeliveryNoticeInfoSave(String appno) throws ScubeBizException{
    	//1、通知书主表写入
		//通知书编号
		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_THSQ_F_NOTICE_NO); 
		String id = bNteNoticeBaseService.deliveryNoticeBasicInfoSave(appno, noticeNo);
    	//2、通知书押品信息表写入
		bNteNoticeMtgService.deliveryNoticeMortListSave(appno,id);
    }


	
	/**
	 * DESCRIPTION:提货流程审批校验数据
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Transactional
	public void deliveryApproveCheck (String appno) throws ScubeBizException{
		BPbcAppliBaseInfo baseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		ABcpAppliImprestBuss bean = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(appno);
		BigDecimal addBailAmount =bean.getAddBailAmt();
		AmountVO amountVO = new AmountVO();
		amountVO.setProductId(baseInfo.getSupplyChainPdId());
		amountVO.setDebetNo(baseInfo.getExt1());
		amountVO.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE); 
		//AmountVO amountVO=new AmountVO(baseInfo.getSupplyChainPdId(),null,null,baseInfo.getExt1(),SCFConstants.ARRIVED_MANAGE_MODE_SINGLE);
		amountVO.setAddBailAmount(addBailAmount);
		BigDecimal canDeliveryAmt=amountService.getDelivery(amountVO);//可提货金额
		BigDecimal openAmount=amountService.getPant(amountVO);//敞口金额
		List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
		BigDecimal totalPrice= BigDecimal.ZERO;
		for(int i=0;i<mortList.size();i++){
			BPbcAppliMtgInfo mortVO = (BPbcAppliMtgInfo)mortList.get(i);
			BigDecimal totPrice = mortVO.getTotPrice()==null?BigDecimal.ZERO:mortVO.getTotPrice();
			totalPrice = totalPrice.add(totPrice);
		}
		if(totalPrice.compareTo(canDeliveryAmt)>0){
			log.error("本次申请提货金额不能大于本次可提货金额！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40002),ATcsErrorConstant.SCF_ADV_TCS_40002);
		}
	}
	
	/**
	 * DESCRIPTION:审批通过签发通知书(线下)
	 * updateFourDeliveryInfo 方法
	 * @param appno
	 * @throws ScubeBizException
	 * @return
	 */
	public void updateFourDeliveryInfo(String appno) throws ScubeBizException{
    	//--数据准备
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if(bPbcAppliBaseInfo==null){
			log.error("申请基本信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10004),BPbcErrorConstant.SCF_BAS_PBC_10004);
		}
		BLanLnciBase bLanLnciBase  = bLanLnciBaseService.findBLanLnciBaseByKey(bPbcAppliBaseInfo.getExt1()); 
		if(bLanLnciBase==null){
			log.error("申请基本信息:借据信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40008),ATcsErrorConstant.SCF_ADV_TCS_40008);
		}
		ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(appno);
		if(abcpAppliImprestBuss==null){
			log.error("申请基本信息:流水信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30002),ATcsErrorConstant.SCF_ADV_TCS_30002);
		}
		//根据申请号和通知书类型查询通知书
		BNteNoticeBase bNteNoticeBaseQry  = new BNteNoticeBase();
		bNteNoticeBaseQry.setAppno(appno);
		bNteNoticeBaseQry.setNoticeType(BNteConstant.NOTICE_TYPE_83);
		List<BNteNoticeBase>  list= bNteNoticeBaseService.findBNteNoticeBaseByAppno(bNteNoticeBaseQry);
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		if(list==null||list.size()==0){
			log.error("申请基本信息:提货通知书信息丢失");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40007),ATcsErrorConstant.SCF_ADV_TCS_40007);
		}else{
			 bNteNoticeBase = list.get(0);
		}
		
		//1、借据信息更新
		bLanLnciBaseService.updateTblLnciBaseInfo(bLanLnciBase,abcpAppliImprestBuss);
		
		bCntMprotDealInfoService.updateDeliveryLnciBaseInfo(abcpAppliImprestBuss);
		
    	//2、流水信息写入
		aBcpImprestBussInfoService.saveDeliveryTblBussInfo(abcpAppliImprestBuss);
		//3、押品操作流水信息写入
		bPbcMtgStorDeliService.saveMortgageStockInfoDtl(bPbcAppliBaseInfo,abcpAppliImprestBuss);
    	//4、通知书状态更新
		this.updateDeliveryNoticeStatusInfo(bNteNoticeBase);
		//5、存追加保证金流水
		aTcsThreeDeliveryService.savecustAccountInfo(appno);

		//6、更新购销合同的已提货金额   出账购销合同提货金额
		aTcsThreeDeliveryService.updateTradeDeliveryTotprice(appno,bLanLnciBase.getDebetNo());
    }
	
	 /**
	  * DESCRIPTION:修改通知书回执(线下)
	  * updateDeliveryNoticeStatusInfo 方法
	  * @param tblNoticeBaseInfo
	  * @throws ScubeBizException
	  */
	@Transactional
   public void updateDeliveryNoticeStatusInfo(BNteNoticeBase bNteNoticeBase) throws ScubeBizException{
   	bNteNoticeBase.setStatus(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);//确认
   	bNteNoticeBase.setCommonDate(BSysConstant.WORKDATE);//回执日期
   	bNteNoticeBase.setSignDate(BSysConstant.WORKDATE); //0003386:提货申请通知书签发日期
   	bNteNoticeBaseService.updateBNteNoticeBase(bNteNoticeBase);
   }
}