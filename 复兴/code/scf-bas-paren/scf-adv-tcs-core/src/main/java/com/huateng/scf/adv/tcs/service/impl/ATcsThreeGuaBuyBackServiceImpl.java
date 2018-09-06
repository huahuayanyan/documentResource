/**
 * 
 */
package com.huateng.scf.adv.tcs.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.bcp.constant.ABcpErrorConstant;
import com.huateng.scf.adv.bcp.dao.IABcpAppliImprestBussDAO;
import com.huateng.scf.adv.bcp.dao.IABcpImprestBussInfoDAO;
import com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo;
import com.huateng.scf.adv.tcs.constant.ATcsErrorConstant;
import com.huateng.scf.adv.tcs.dao.IATcsThreeGuaBuyBackDAO;
import com.huateng.scf.adv.tcs.model.ThreeBalanceRefundLnciVO;
import com.huateng.scf.adv.tcs.model.ThreeBalanceRefundVO;
import com.huateng.scf.adv.tcs.model.ThreeWareQryVO;
import com.huateng.scf.adv.tcs.service.IATcsThreeGuaBuyBackService;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotDealInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanBillBaseInfoService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.constant.BNteErrorConstant;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.nte.service.IBNteNoticeBillService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>担保提货收款确认</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月9日上午10:10:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月9日上午10:10:14	     新增
 *
 * </pre>
 */
@ScubeService
@Service("ATcsThreeGuaBuyBackServiceImpl")
public class ATcsThreeGuaBuyBackServiceImpl implements IATcsThreeGuaBuyBackService,DealInFlowService,DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "ATcsThreeGuaBuyBackDAO")
	private IATcsThreeGuaBuyBackDAO aTcsThreeGuaBuyBackDAO;
	@Resource(name = IBLanLnciBaseService.BEAN_ID)
	IBLanLnciBaseService bLanLnciBaseService; //借据基本信息
	@Resource(name = IBLanBillBaseInfoService.BEAN_ID)
	private IBLanBillBaseInfoService bLanBillBaseInfoService; //票据
	@Resource(name = "bCrrLnConService")
	IBCrrLnConService bCrrLnConService;
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;//业务申请表
	@Resource(name = IBCntMprotBaseInfoService.BEAN_ID)
	IBCntMprotBaseInfoService bCntMprotBaseInfoService; //监管协议/担保提货协议/先票(款)后货协议信息表

	@Resource(name = IBNteNoticeBaseService.BEAN_ID)
	IBNteNoticeBaseService bNteNoticeBaseService; //通知书
	@Resource(name = IBCntMprotPartInfoService.BEAN_ID)
	IBCntMprotPartInfoService bCntMprotPartInfoService; //多方协议参入者信息
	@Resource(name = IBNteNoticeBillService.BEAN_ID)
	IBNteNoticeBillService bNteNoticeBillService; //通知书票据
	@Resource(name = IBCntMprotDealInfoService.BEAN_ID)
	IBCntMprotDealInfoService bCntMprotDealInfoService;//预付款协议扩展信息表
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO bCrrLnConDAO; //信贷合同DAO
	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO; //监管协议/担保提货协议/先票(款)后货协议信息表
	@Resource(name = "ABcpAppliImprestBussDAO")
	IABcpAppliImprestBussDAO aBcpAppliImprestBussDAO; 
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO bLanAppliLnciBaseDAO; 
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO bCntMprotPartInfoDAO; //多方协议参入者信息
	@Resource(name = "ABcpImprestBussInfoDAO")
	IABcpImprestBussInfoDAO aBcpImprestBussInfoDAO; 
	@Resource(name = "bSysSerialNoService")
	private  IBSysSerialNoService bSysSerialNoService;
	
	@Resource(name=IScfWorkFlowService.BEAN_ID) //供应链工作流
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;

	private static final String PROTOCOLNO="protocolNo";
	private static final String STATE = "state";
	private static final String ISSETTLE = "isSettle";
	private static final String STATUS = "status";
	private static final String NOTICETYPES = "noticeTypes";
	
	private static final String PROCESSTEMPLATENAME="processTemplateName";
	private static final String APPLISTATUSS="appliStatuss";
	private static final String APPLITYPE="appliType";
	
	private static final String APPNO="appno";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String ROLEBACKCORE = "roleBackcore";

	@Override
	/**
	 * 担保差额退款申请添加待退款列表
	 */
	public Page getBalRefundLnciByProtocolNo(int pageNo, int pageSize, ThreeWareQryVO threeWareQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != threeWareQryVO) {
			String protocolNo = threeWareQryVO.getProtocolNo();// 协议号
	
			if(StringUtil.isStrNotEmpty(protocolNo)){
				map.put(PROTOCOLNO, protocolNo);
			}
			map.put(STATE, BSysConstant.FLAG_OFF); //记录状态
			map.put(ISSETTLE, BSysConstant.FLAG_OFF); //是否结清
			map.put(STATUS, BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);  //通知书回执状态
			List<String> noticeTypes=new ArrayList<String>();
			noticeTypes.add(BNteConstant.NOTICE_TYPE_75);
			noticeTypes.add(BNteConstant.NOTICE_TYPE_78);
			map.put(NOTICETYPES, noticeTypes);
		}
	
		aTcsThreeGuaBuyBackDAO.getBalRefundLnciByProtocolNo(map, page);
		List<ThreeBalanceRefundLnciVO> threeVOList = page.getRecords();
		List<ThreeBalanceRefundLnciVO> response = new ArrayList<ThreeBalanceRefundLnciVO>();
		if(threeVOList!=null&&threeVOList.size()>0){
			Iterator<?> iter=threeVOList.iterator();
			while(iter.hasNext()){
				ThreeBalanceRefundLnciVO  threeBalanceRefundLnciVO= new ThreeBalanceRefundLnciVO();
				com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundLnciVO vo = (com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundLnciVO)iter.next();
				BigDecimal bailAmount = vo.getBailAmount()==null?new BigDecimal("0"):vo.getBailAmount();
				BigDecimal addBailAmount = vo.getAddBailAmount()==null?new BigDecimal("0"):vo.getAddBailAmount();
				BigDecimal lnciBal = vo.getLnciBal()==null?new BigDecimal("0"):vo.getLnciBal();
				BigDecimal initCashEqtAmt = vo.getInitCashEqtAmt()==null?new BigDecimal("0"):vo.getInitCashEqtAmt();
				BigDecimal addCashEqtAmt = vo.getAddCashEqtAmt()==null?new BigDecimal("0"):vo.getAddCashEqtAmt();
				//敞口金额=借据余额-初始保证金金额-追加保证金金额-初始现金等价物总额-追加现金等价物金额
				BigDecimal businessOpenAmount =BigDecimal.ZERO;
				businessOpenAmount =lnciBal.subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
				if(businessOpenAmount.compareTo(BigDecimal.ZERO)<0){
					businessOpenAmount =BigDecimal.ZERO;
				}
				vo.setBusinessOpenAmount(businessOpenAmount);
				
				BeanUtils.copyProperties(vo, threeBalanceRefundLnciVO);
				response.add(threeBalanceRefundLnciVO);
			}
		}
		page.setRecords(response);
		return page;
	}
	/**
	 * 根据申请编号查询差额退款基本信息 
	 */
	@Override
	public ThreeBalanceRefundVO getThreeBalanceRefundByAppno(ThreeWareQryVO threeWareQryVO)
			throws ScubeBizException {
		ThreeBalanceRefundVO threeBalanceRefundVO = new ThreeBalanceRefundVO();
		Map<String, Object> map=new HashMap<String, Object>();
		if(null!=threeWareQryVO){
			String appno=threeWareQryVO.getAppno();//申请号
			
			if(StringUtil.isStrNotEmpty(appno)){
				map.put(APPNO, appno);
			}
			
		}
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		map.put(ROLEBACKCORE, ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE);
		com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundVO dalVO = new  com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundVO();
		dalVO = aTcsThreeGuaBuyBackDAO.getThreeBalanceRefundByAppno(map);
		if(dalVO!=null){
			BeanUtils.copyProperties(dalVO, threeBalanceRefundVO);
		}
		return threeBalanceRefundVO;
	}
	/**
	 * 差额退款根据申请编号查询借据列表
	 */
	@Override
	public Page getInvoiceBuybackAppliByAppno(int pageNo, int pageSize, ThreeWareQryVO threeWareQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map=new HashMap<String, Object>();
		if(null!=threeWareQryVO){
			if(null!=threeWareQryVO){
				String appno=threeWareQryVO.getAppno();//申请号
				
				if(StringUtil.isStrNotEmpty(appno)){
					map.put(APPNO, appno);
				}
			}
			
		}
		map.put(STATUS, ScfBasConstant.LNCI_STATUS_NORMAL);  //借据状态
		aTcsThreeGuaBuyBackDAO.getInvoiceBuybackAppliByAppno(map, page);
		
		List<ThreeBalanceRefundLnciVO> threeVOList = page.getRecords();
		List<ThreeBalanceRefundLnciVO> response = new ArrayList<ThreeBalanceRefundLnciVO>();
		if(threeVOList!=null&&threeVOList.size()>0){
			Iterator<?> iter=threeVOList.iterator();
			while(iter.hasNext()){
				ThreeBalanceRefundLnciVO  threeBalanceRefundLnciVO= new ThreeBalanceRefundLnciVO();
				com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundLnciVO vo = (com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundLnciVO)iter.next();
				BigDecimal bailAmount = vo.getBailAmount()==null?new BigDecimal("0"):vo.getBailAmount();
				BigDecimal addBailAmount = vo.getAddBailAmount()==null?new BigDecimal("0"):vo.getAddBailAmount();
				BigDecimal lnciBal = vo.getLnciBal()==null?new BigDecimal("0"):vo.getLnciBal();
				BigDecimal initCashEqtAmt = vo.getInitCashEqtAmt()==null?new BigDecimal("0"):vo.getInitCashEqtAmt();
				BigDecimal addCashEqtAmt = vo.getAddCashEqtAmt()==null?new BigDecimal("0"):vo.getAddCashEqtAmt();
				//敞口金额=借据余额-初始保证金金额-追加保证金金额-初始现金等价物总额-追加现金等价物金额
				vo.setBusinessOpenAmount(lnciBal.subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
				BeanUtils.copyProperties(vo, threeBalanceRefundLnciVO);
				response.add(threeBalanceRefundLnciVO);
			}
		}
		page.setRecords(response);
		return page;
	}
	
	/**
	 * 担保差额退款申请保存
	 */
	@Transactional
	@Override
	public String saveBuybackWriteApply(ThreeBalanceRefundVO threeBalanceRefundVO ,List<ThreeBalanceRefundLnciVO> list) throws ScubeBizException{
		String appno = "";
		String protocolNo=threeBalanceRefundVO.getProtocolNo();
		if(StringUtil.isEmpty(threeBalanceRefundVO.getAppno())){
			String businessnoType = WorkflowConstant.APPLI_TYPE_THREE_BUYBACKAPPLI;
			String	modelId = WorkflowConstant.PROCMODEL_THREE_GUA_BUYBACK_APPLY;
			//同一（协议）只能有一笔在差额退款审批流程过程
			Map<String, Object> map = new HashMap<String, Object>();
			if(StringUtil.isStrNotEmpty(protocolNo)){
				map.put(PROTOCOLNO, protocolNo);
			}
			map.put(APPLITYPE, businessnoType);//申请类型
			map.put(PROCESSTEMPLATENAME, modelId);//流程id
			List<String> appliStatuss=new ArrayList<String>();
			appliStatuss.add(WorkflowConstant.APPLI_STATUS_APPROVED);
			appliStatuss.add(WorkflowConstant.APPLI_STATUS_REFUSED);
			map.put(APPLISTATUSS, appliStatuss); //申请状态：非【已通过(审批通过)，已拒绝(审批不通过)】
			
			List applist=bPbcAppliBaseInfoDAO.getBPbcAppInfoByProtocolNo(map);
			if(applist!=null&&applist.size()>0){
				log.error("协议号【"+protocolNo+"】下存在尚未审批的退款申请流程，无法提交本次申请。");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30000),ATcsErrorConstant.SCF_ADV_TCS_30000);
			}
			//业务信息保存
			appno = this.threeBalanceRefundAppInfo(threeBalanceRefundVO, businessnoType, modelId);
			threeBalanceRefundVO.setAppno(appno);
			
			String  custCd=threeBalanceRefundVO.getCustcd(); 
			String  custName=threeBalanceRefundVO.getSellerNm();  //买方名称
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
			}
			
			/*String  ProcessName = WorkflowConstant.PROCNAME_THREE_GUA_BUYBACK_APPLY;
			
			String  NodeId = WorkflowConstant.PROCNODE_APPLY;
			 // 获取当前用户 
		    UserInfo user = ContextHolder.getUserInfo(); 
		    String startedUserId=user.getTlrNo();
		    //扩展业务信息
			String  bizId=appno; 
			String  custCd=threeBalanceRefundVO.getCustcd(); 
			String  custName=threeBalanceRefundVO.getSellerNm();  //买方名称
			//流程发起
			ProcessEntity processEntity = processService.startProcess(modelId, ProcessName, NodeId, startedUserId, bizId,
					new String[]{bizId,custCd,custName,modelId});
			//更新业务申请表工作流实例号
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			String processId =processEntity.getProcessId();
			bPbcAppliBaseInfo.setPiid(processId); 
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);*/

		}else{
			appno = threeBalanceRefundVO.getAppno();
			BPbcAppliBaseInfo bPbcAppliBaseInfo =bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			bPbcAppliBaseInfo.setAmt(threeBalanceRefundVO.getAmount());
			threeBalanceRefundVO.setAppno(appno);
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		//保存到A_BCP_APPLI_IMPREST_BUSS【业务申请业务主表-预付款业务申请流水表】
		this.applyBussInfoSave(threeBalanceRefundVO, appno);
    	//保存到B_LAN_APPLI_LNCI_BASE【业务申请业务明细表】
		this.appliLnciBaseInfoSave(list, appno);

		return appno;
	}
	/**
	 * 担保提货差额退款流程保存流程申请信息
	 * @param threeBalanceRefundVO
	 * @param businessnoType
	 * @param modelId
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public String threeBalanceRefundAppInfo(ThreeBalanceRefundVO threeBalanceRefundVO,String businessnoType,String modelId) throws ScubeBizException  {
		//三方保兑协议信息
		BCntMprotBaseInfo bCntMprotBaseInfo = null;
		BCrrLnCon bCrrLnCon  = null; //信贷合同
		if(StringUtil.isStrNotEmpty(threeBalanceRefundVO.getMastContno())){
			bCrrLnCon =  bCrrLnConDAO.selectByPrimaryKey(threeBalanceRefundVO.getMastContno());
			bCntMprotBaseInfo = bCntMprotBaseInfoDAO.selectByPrimaryKey(bCrrLnCon.getVidNo());
		}else if(StringUtil.isStrNotEmpty(threeBalanceRefundVO.getProtocolNo())){
			bCntMprotBaseInfo = bCntMprotBaseInfoDAO.selectByPrimaryKey(threeBalanceRefundVO.getProtocolNo());
		}else{
			log.error("担保提货协议信息丢失");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30001),ATcsErrorConstant.SCF_ADV_TCS_30001);
		}

		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		if (StringUtil.isEmpty(threeBalanceRefundVO.getAppno())) {    //新增                                    // 保存新增
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			BeanUtils.copyProperties(threeBalanceRefundVO,bPbcAppliBaseInfo);
			bPbcAppliBaseInfo.setCustcd(threeBalanceRefundVO.getCustcd()==null?"":threeBalanceRefundVO.getCustcd());                    // 客户号
			//bPbcAppliBaseInfo.setCustcd(threeBalanceRefundVO.getCoreCustcd()==null?"":threeBalanceRefundVO.getCoreCustcd());  //TODO                          // 客户号
			bPbcAppliBaseInfo.setCurcd(bCntMprotBaseInfo.getCurcd());                         // 币种
			bPbcAppliBaseInfo.setProcessTemplateName(modelId);              		 // 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_PROTOCOLNO);
			bPbcAppliBaseInfo.setBusinessno(bCntMprotBaseInfo.getProtocolNo());                    // 协议(合同)号
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);         // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);  // 申请状态明细:未提交（默认）
			//bPbcAppliBaseInfo.setAppBrcode(globalInfo.getBranchBrcode());	
			//bPbcAppliBaseInfo.setApprover(globalInfo.getTlrno());
			//bPbcAppliBaseInfo.setApproveTime(DateUtil.getCurrentDate());
			//bPbcAppliBaseInfo.setAppDate(DateUtil.getCurrentDate());	                     // 登记时间
			//bPbcAppliBaseInfo.setStartTime(DateUtil.getCurrentDate());
			//bPbcAppliBaseInfo.setStratDate(DateUtil.getCurrentDate());
			//bPbcAppliBaseInfo.setStartBrcode(globalInfo.getBrcode());
			//bPbcAppliBaseInfo.setStartTlrcd(globalInfo.getTlrno());
			//bPbcAppliBaseInfo.setAppTlrcd(globalInfo.getTlrno());	                     // 登记人
			bPbcAppliBaseInfo.setSupplyChainPdId(threeBalanceRefundVO.getProductId());
			bPbcAppliBaseInfo.setAmt(threeBalanceRefundVO.getAmount());
			bPbcAppliBaseInfo.setMastContcode(bCrrLnCon==null?"":bCrrLnCon.getAppId());
			// 产品ID
			if(bCrrLnCon!=null){
				bPbcAppliBaseInfo.setMastContno(bCrrLnCon.getAppId());                     // 主合同号
			}
			//获得appno
			String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_CETK_T_APP_NO); 
			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setWorkflowAppno(appno);
			bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}else{//更新
			bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(threeBalanceRefundVO.getAppno());
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		return bPbcAppliBaseInfo.getAppno();
	}
	
/**
 * DESCRIPTION:差额退款基本信息保存 预付款业务申请流水表
 * @param vo
 * @param appno
 * @throws ScubeBizException
 */
	@Transactional
	public void applyBussInfoSave(ThreeBalanceRefundVO vo,String appno) throws ScubeBizException{
		ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(appno);
		  UserInfo user = ContextHolder.getUserInfo(); 
		if(abcpAppliImprestBuss != null){
			abcpAppliImprestBuss.setCustcd(vo.getCustcd());//买方客户号
			abcpAppliImprestBuss.setUpCustcd(vo.getCoreCustcd());//卖方客户号
			abcpAppliImprestBuss.setCommonAmt(vo.getAmount());//差额退款金额
			abcpAppliImprestBuss.setPaybackTerm(vo.getRefundTerm());//退款期限
			abcpAppliImprestBuss.setPayee(vo.getPayee());//付款人名称
			abcpAppliImprestBuss.setPaybackAcctNo(vo.getRefundAcctNo());//账号
			abcpAppliImprestBuss.setDepositBank(vo.getDepositBank());//开户行
			abcpAppliImprestBuss.setPaybackReason(vo.getPaybackReason());//原因
			try {
				aBcpAppliImprestBussDAO.updateByPrimaryKeySelective(abcpAppliImprestBuss);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("预付款业务申请流水更新异常");
				e.printStackTrace();
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10002),ABcpErrorConstant.SCF_ADV_BCP_10002);
			}
		}else{
			ABcpAppliImprestBuss taibi = new ABcpAppliImprestBuss();
			taibi.setCustcd(vo.getCustcd());//买方客户号
			taibi.setUpCustcd(vo.getCoreCustcd());//卖方客户号
			taibi.setCommonAmt(vo.getAmount());//差额退款金额
			taibi.setPaybackTerm(vo.getRefundTerm());//退款期限
			taibi.setPayee(vo.getPayee());//付款人名称
			taibi.setPaybackAcctNo(vo.getRefundAcctNo());//账号
			taibi.setDepositBank(vo.getDepositBank());//开户行
			taibi.setAppno(appno);//业务申请号
			taibi.setId(UUIDGeneratorUtil.generate());//主键
			taibi.setCreateDate(BSysConstant.WORKDATE);//建档日期
			taibi.setMgrno(user.getTlrNo());//客户经理
			taibi.setBrcode(user.getBrNo());//经办机构
			taibi.setPaybackReason(vo.getPaybackReason());
			try {
				aBcpAppliImprestBussDAO.insertSelective(taibi);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("预付款业务申请流水插入异常");
				e.printStackTrace();
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10001),ABcpErrorConstant.SCF_ADV_BCP_10001);
			}
		}
		
	}
	
	/***
	 * 担保提货差额退款录入B_LAN_APPLI_LNCI_BASE[借据申请表]保存
	 * @param list
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Transactional
	public void appliLnciBaseInfoSave(List list,String appno) throws ScubeBizException{
		this.appliLnciBaseInfoUpdate(appno);//清理数据
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			ThreeBalanceRefundLnciVO vo = (ThreeBalanceRefundLnciVO)iter.next();
			BLanAppliLnciBase bLanAppliLnciBase = new BLanAppliLnciBase();
			BeanUtils.copyProperties(vo, bLanAppliLnciBase);
			bLanAppliLnciBase.setLnciBal(vo.getBusinessOpenAmount());
			bLanAppliLnciBase.setDebetNo(vo.getDebetNo());
			bLanAppliLnciBase.setId(UUIDGeneratorUtil.generate());
			bLanAppliLnciBase.setAppno(appno);
			bLanAppliLnciBase.setNum(vo.getNum());
			try {
				bLanAppliLnciBaseDAO.insertSelective(bLanAppliLnciBase);
			} catch (Exception e) {
				log.error("借据申请信息插入异常");
				e.printStackTrace();
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10001),BLanErrorConstant.SCF_BAS_LAN_10001);
			}
		}
	}
	/**
	 * 保存前先清掉APPNO查询到记录
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Transactional
	public void appliLnciBaseInfoUpdate(String appno) throws ScubeBizException{
		List<BLanAppliLnciBase> list = bLanAppliLnciBaseDAO.selectByAppNo(appno);
		if(list!=null && list.size()>0){
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				BLanAppliLnciBase applyVO = (BLanAppliLnciBase)iter.next();
				try {
					bLanAppliLnciBaseDAO.deleteByPrimaryKey(applyVO.getId());
				} catch (Exception e) {
					log.error("借据申请信息插入异常");
					e.printStackTrace();
					throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10003),BLanErrorConstant.SCF_BAS_LAN_10003);
				}
			}
		}
	}
	/**
	 * 担保差额退款申请提交
	 */
	@Transactional
	@Override
	public void saveBuybackWriteSubmit(ThreeBalanceRefundVO threeBalanceRefundVO ,List<ThreeBalanceRefundLnciVO> list) throws ScubeBizException{
		//保存通知书
		this.saveThreeBalanceRefundNotice(threeBalanceRefundVO, list);
		//保存修改的信息
		String appno = this.saveBuybackWriteApply(threeBalanceRefundVO, list);
		/*CommonApplyDtlInfoVO commAppInfoVo = new CommonApplyDtlInfoVO();
		commAppInfoVo.setAttitude(WorkflowConstant.WORKFLOW_TRANS_AGREE);
		commAppInfoVo.setBussAppno(appno);
		commAppInfoVo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);*/
		// 流程流转
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*String processId= bPbcAppliBaseInfo.getPiid();
		UserInfo user = ContextHolder.getUserInfo();
		String userId = user.getTlrNo();
		// 领取任务
		String taskId = WorkflowConstant.TASKNODE_APPLY;
		taskService.takeTask(taskId, processId, userId);
		// 任务提交
		String comment = "申请提交";
		taskService.completeTask(taskId, processId, userId, comment);
		// 节点转移
		processService.signal(processId, WorkflowConstant.PROCNODE_APPROVE);
      //更新业务申请信息状态
		bPbcAppliBaseInfo.setApprover(userId); // 当前已审批人员
		bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
		bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new Date())); // 当前已审批日期
		bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);*/
	}
	
	/**
	 * DESCRIPTION:担保提货差额退款生成通知书
	 * @author zhoujun.hou
	 * @date 2013-7-10
	 * saveThreeBalanceRefundNotice 方法
	 * @param threeBalanceRefundVO
	 * @param updateList
	 * @throws CommonException
	 * @param commonQueryVO
	 * @return
	 */
	@Transactional
	public void saveThreeBalanceRefundNotice(ThreeBalanceRefundVO threeBalanceRefundVO,List<ThreeBalanceRefundLnciVO> list) throws ScubeBizException{
		BCntMprotBaseInfo bCntMprotBaseInfo = bCntMprotBaseInfoDAO.selectByPrimaryKey(threeBalanceRefundVO.getProtocolNo());//三方保兑仓协议信息
		if(bCntMprotBaseInfo==null){
			log.error("担保提货协议信息丢失");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30001),ATcsErrorConstant.SCF_ADV_TCS_30001);
		}
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal amountOut= BigDecimal.ZERO;
		BigDecimal amountIn = BigDecimal.ZERO;

		String bussType="";//业务类型
		//TblNoticeBaseInfoDAO tblNoticeBaseInfoDao = DAOUtils.getTblNoticeBaseInfoDAO();
		if(list!=null && list.size()>0){
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				ThreeBalanceRefundLnciVO vo = (ThreeBalanceRefundLnciVO)iter.next();
				//amount = amount.add(vo.getBusinessOpenAmount()==null?BigDecimal.ZERO:vo.getBusinessOpenAmount());
				amountIn = amountIn.add(vo.getAmountIn()==null?BigDecimal.ZERO:vo.getAmountIn());
				amountOut = amountOut.add(vo.getAmountOut()==null?BigDecimal.ZERO:vo.getAmountOut());

			}
		}
		//TblNoticeBaseInfoDAO tblNoticeBaseInfoDao = SCFDAOUtils.getTblNoticeBaseInfoDAO();
		//GlobalData gd = (GlobalData) GlobalInfo.getCurrentInstance();
		//通知书基本信息表（核心厂商）
		BNteNoticeBase bNteNoticeBase = null;
		BNteNoticeBase bNteNoticeBaseQry  =new BNteNoticeBase();
		bNteNoticeBaseQry.setAppno(threeBalanceRefundVO.getAppno());
		List<BNteNoticeBase> result = bNteNoticeBaseDAO.findBNteNoticeBaseByAppno(bNteNoticeBaseQry);
    	if(result!=null&&result.size()>0){
    		bNteNoticeBase = (BNteNoticeBase) result.get(0);
    	}else{
    		bNteNoticeBase = new BNteNoticeBase();
    		bNteNoticeBase.setId(UUIDGeneratorUtil.generate());
    		//通知书编号
    		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_CETK_T_NOTICE_NO); 
    		bNteNoticeBase.setNum(noticeNo);
    	}
    	List<BCntMprotPartInfo> list1  = bCntMprotPartInfoDAO.findBCntMpartInfoByProtocolNo(threeBalanceRefundVO.getProtocolNo());//通过协议号查询参与方
		//String coreCustcd = "";
		for(int i=0;i<list1.size();i++){
			BCntMprotPartInfo bCntMprotPartInfo = (BCntMprotPartInfo)list1.get(i);
			if(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(bCntMprotPartInfo.getRole())){//授信客户
				bNteNoticeBase.setCustcd(bCntMprotPartInfo.getCustcd());//借款人
				bNteNoticeBase.setCustName(bCntMprotPartInfo.getCname());
			}else if(ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(bCntMprotPartInfo.getRole())){//监管公司
				
			}else if(ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(bCntMprotPartInfo.getRole())){//核心厂商
				bNteNoticeBase.setOtherCustcd(bCntMprotPartInfo.getCustcd());//
				bNteNoticeBase.setOtherCustName(bCntMprotPartInfo.getCname());
			}else if(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(bCntMprotPartInfo.getRole())){//回购厂商
				
			}
		}
		// 获取当前用户 
	    UserInfo user = ContextHolder.getUserInfo(); 
		bNteNoticeBase.setAppno(threeBalanceRefundVO.getAppno());
		bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_71);
		bNteNoticeBase.setMastContno(threeBalanceRefundVO.getMastContno());
		bNteNoticeBase.setCommonNum(String.valueOf(list.size()));//货押品记录数
		//bNteNoticeBase.setBrcode(gd.getBrcode()==null?(gd.getBranchBrcode()==null?"":gd.getBranchBrcode()):gd.getBrcode());//分支行编号
		bNteNoticeBase.setBrcode(user.getBrNo()==null?(user.getBrManagerNo()==null?"":user.getBrManagerNo()):user.getBrNo());//分支行编号
		bNteNoticeBase.setAppliDate(BSysConstant.WORKDATE);
		bNteNoticeBase.setProtocolCode(bCntMprotBaseInfo.getProtocolCode());//三方协议纸质编号
		bNteNoticeBase.setProtocolNo(bCntMprotBaseInfo.getProtocolNo());//三方协议号
		bNteNoticeBase.setStatus(BNteConstant.NOTICE_BASE_STATUS_UNCONFIRM );
		bNteNoticeBase.setTlrn(user.getTlrNo());
		bNteNoticeBase.setCommonAmt(amountIn);
    	//通知书基本表中存入业务品种 add by changhao.huang 2013-9-13
		//通知书基本表中存入业务品种 
		BPbcAppliBaseInfo bPbcAppliBaseInfo =bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(threeBalanceRefundVO.getAppno());
		String productId="";
		if(bPbcAppliBaseInfo!=null){
			productId= bPbcAppliBaseInfo.getSupplyChainPdId();
    	}
    	bNteNoticeBase.setBussType(productId);//业务类型

    	bNteNoticeBase.setExt1Amount(amountOut);//累计提货金额
    	bNteNoticeBase.setExt2Amount(amountIn);//累计剩余提货金额
    	try {
			bNteNoticeBaseDAO.insertSelective(bNteNoticeBase);
		} catch (Exception e) {
			log.error("通知书基本信息插入异常！");
			e.printStackTrace();
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BNteErrorConstant.SCF_BAS_NTE_10001),BNteErrorConstant.SCF_BAS_NTE_10001);
		}
	}
	
	
	/**
	 * 差额退款提交审批
	 * @param appNo
	 * @throws ScubeBizException
	 */
	@Transactional
	public void doWorkForSubmit(String appNo) throws ScubeBizException{
		
        //业务流水记录
		ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(appNo);
		if(abcpAppliImprestBuss==null){
			log.error("业务申请流水信息丢失!");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30002),ATcsErrorConstant.SCF_ADV_TCS_30002);
		}
		//流水信息写入
		this.saveDeliveryTblBussInfo(abcpAppliImprestBuss);
	    //签发通知书
		bNteNoticeBaseService.updaterNoticeStatus(appNo,BNteConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);
		// 复核流程方法
	//	WorkFlowService.getInstance().processTasks(commAppInfoVo);
    	//更新业务申请表状态
    	BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
    	bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		
	}
	/**
	 * 差额退款审批拒绝
	 * @param appNo
	 * @throws ScubeBizException
	 */
	@Transactional
	public void buybackRefused(String appNo) throws ScubeBizException{
		// 流程方法
	//	WorkFlowService.getInstance().processTasks(commAppInfoVo);
    	//更新业务申请表状态
    	BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
    	bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		
	}
	
	/**
	 * 担保提货流水信息写入(线下)
	 * @param abcpAppliImprestBuss
	 * @throws ScubeBizException
	 */
	@Transactional
	public void saveDeliveryTblBussInfo(ABcpAppliImprestBuss abcpAppliImprestBuss) throws ScubeBizException{
    	log.info("------流水信息写入");
    	ABcpImprestBussInfo abcpImprestBussInfo  = new ABcpImprestBussInfo();
    	BeanUtils.copyProperties(abcpAppliImprestBuss, abcpImprestBussInfo);
    	abcpImprestBussInfo.setId(UUIDGeneratorUtil.generate());
    	abcpImprestBussInfo.setInsertDate(BSysConstant.WORKDATE);
    	aBcpImprestBussInfoDAO.insertSelective(abcpImprestBussInfo);
	 }
 /**
  * 担保提货更改通知书状态公共方法
  * @param appno
  * @param status
  * @throws ScubeBizException
  */
	/*@Transactional
    public void updaterNoticeStatus(String appno,String status) throws ScubeBizException{
		BNteNoticeBase noticeBaseQry = new BNteNoticeBase();
		noticeBaseQry.setAppno(appno);
		List<BNteNoticeBase> list =bNteNoticeBaseDAO.findBNteNoticeBaseByAppno(noticeBaseQry);
		BNteNoticeBase noticeBase = null;
    	if(list!=null && list.size()>0){
    		for(int i=0;i<list.size();i++){
    			noticeBase = (BNteNoticeBase) list.get(i);
    	    	if(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED.equals(status)){
    	    		//tblNoticeBaseInfo.setStatus(NoticeConstants.NOTICE_BASE_STATUS_CONFIRM_APPROVED);//已签发
    	    		noticeBase.setSignDate(BSysConstant.WORKDATE);//签发日期
    	    	}else if(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE.equals(status)){
    	    		noticeBase.setStatus(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);//已回执
    	    		noticeBase.setCommonDate(BSysConstant.WORKDATE);//回执日期
    	    	}
    	    	try {
					bNteNoticeBaseDAO.updateByPrimaryKeySelective(noticeBase);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		}else{
			log.error("申请基本信息:通知书信息丢失!");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10001),ATcsErrorConstant.SCF_ADV_TCS_10001);
		}
    }*/
    
	//收款确认确认回执审批通过
	@Override
	@Transactional
	public void doWorkForPass(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		//更新通知书状态
		bNteNoticeBaseService.updaterNoticeStatus(appNo,BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		//更新业务申请表状态
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		
	}

	/**
	 * 收款确认审批拒绝
	 */
	@Override
	@Transactional
	public void doWorkForReject(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		//更新业务申请表状态
    	BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
    	bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}
	


}
