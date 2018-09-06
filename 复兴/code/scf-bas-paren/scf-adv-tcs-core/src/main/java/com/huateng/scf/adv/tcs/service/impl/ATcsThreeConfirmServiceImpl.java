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
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.adv.tcs.constant.ATcsErrorConstant;
import com.huateng.scf.adv.tcs.dao.IATcsThreeConfirmDAO;
import com.huateng.scf.adv.tcs.model.ThreeApplyVO;
import com.huateng.scf.adv.tcs.model.ThreeBuyMortgageInfoVO;
import com.huateng.scf.adv.tcs.model.ThreeConfirmVO;
import com.huateng.scf.adv.tcs.service.IATcsThreeConfirmService;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotDealInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.lan.model.BLanBillBaseInfo;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanBillBaseInfoService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.model.BNteNoticeBill;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.nte.service.IBNteNoticeBillService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
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
@Service("ATcsThreeConfirmServiceImpl")
public class ATcsThreeConfirmServiceImpl implements IATcsThreeConfirmService,DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "ATcsThreeConfirmDAO")
	private IATcsThreeConfirmDAO aTcsThreeConfirmDAO;
	@Resource(name = IBLanLnciBaseService.BEAN_ID)
	IBLanLnciBaseService bLanLnciBaseService; //借据基本信息
	@Resource(name = IBLanBillBaseInfoService.BEAN_ID)
	private IBLanBillBaseInfoService bLanBillBaseInfoService; //票据
	@Resource(name = "bCrrLnConService")
	IBCrrLnConService bCrrLnConService;
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
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
	@Resource(name = "bSysSerialNoService")
	private  IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name=IScfWorkFlowService.BEAN_ID) //供应链工作流
	IScfWorkFlowService scfWorkFlowService;

	private static final String SELLERNM = "sellerNm"; 
	private static final String CORENM="coreNm";
	private static final String PROTOCOLNO="protocolNo";
	private static final String MASTCONTNO = "mastContno"; 
	private static final String STARTDATE1="startDate1";
	private static final String STARTDATE2 = "startDate2"; 
	private static final String CONFIRMSTATUS = "confirmStatus"; 
	private static final String LOANWAY = "loanWay";
	private static final String BRCODES = "brCodes";

	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String PROTOCOLSTATE = "protocolState";
	private static final String STATE = "state";
	private static final String ISSETTLE = "isSettle";
	private static final String DEBETNO = "debetNo";
	private static final String TRADECONTNO = "tradeContno";
	private static final String MORTLEVELFIRST = "mortLevelFirst";
	private static final String MORTLEVELSECOND = "mortLevelSecond";
	
	@Override
	/**
	 * 收款确认查询列表
	 */
	public Page queryATcsThreeConfirmListByPage(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO)
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
			String brCode = deliveryQryVO.getBrcode();// 出账机构
/*			if(StringUtil.isStrNotEmpty(brCode)){
				////机构名称的集合
				BctlVO bctlVO = new BctlVO();
				bctlVO.setBrName(brCode);
				 // 获取当前用户 
			     UserInfo user = ContextHolder.getUserInfo(); 
			     bctlVO.setBrManagerNo(user.getBrManagerNo());
				Page p=scubeUserService.selectBctlByLike(pageNo, pageSize, bctlVO);
				if(p!=null&&p.getTotalRecord()>0){
					Iterator<?> iter=p.getRecords().iterator();
					List<String> brCodes=new ArrayList<String>();
					while(iter.hasNext()){
						BctlVO row=JSON.parseObject(iter.next().toString(), new TypeReference<BctlVO>(){});
						brCodes.add(row.getBrNo());
					}
					map.put(BRCODES, brCodes);
				}
			}*/
			
			 //数据权限控制：1、默认查询出当前登录人机构及其以下机构信息 2、查询条件已经选了机构的,根据已选择的查询机构及以下机构信息
			UserInfo user = ContextHolder.getUserInfo(); 
		    String userbrcode=user.getBrNo();
		    ArrayList<String> brCodes = new ArrayList<String>();
		    if(StringUtil.isStrNotEmpty(brCode)){
				List<BctlVO> bctList = scubeUserService.getBrListByBrNo(brCode,ScfCommonUtil.getBrManagerNo(scubeUserService));
				for(BctlVO bctlVO : bctList){
					String brNo = bctlVO.getBrNo();
					brCodes.add(brNo);
				}
			}else{
				List<BctlVO> bctList = scubeUserService.getBrListByBrNo(userbrcode,ScfCommonUtil.getBrManagerNo(scubeUserService));
				for(BctlVO bctlVO : bctList){
					String brNo = bctlVO.getBrNo();
					brCodes.add(brNo);
				}
			}
		    map.put(BRCODES, brCodes);
			
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
			String protocolType = deliveryQryVO.getProtocolType();
			if(StringUtil.isStrNotEmpty(protocolType)){
				map.put(PROTOCOLTYPE, protocolType);
			}
		}
		//map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_THREEWH);
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		map.put(PROTOCOLSTATE, ScfBasConstant.STATE_VALID); //监管协议状态
		map.put(STATE, BSysConstant.FLAG_OFF); //记录状态
		map.put(ISSETTLE, BSysConstant.FLAG_OFF); //是否结清
		aTcsThreeConfirmDAO.selectThreeConfirmList(map, page);
		List<ThreeConfirmVO> threeConfirmVOList = page.getRecords();
		List<ThreeConfirmVO> response = new ArrayList<ThreeConfirmVO>();
		if(threeConfirmVOList!=null&&threeConfirmVOList.size()>0){
			Iterator<?> iter=threeConfirmVOList.iterator();
			while(iter.hasNext()){
				ThreeConfirmVO  threeConfirmVO= new ThreeConfirmVO();
				com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO VO=(com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO) iter.next();
				if(StringUtil.isStrNotEmpty(VO.getBrcode())){
					BctlVO bctl = scubeUserService.selectBctlByBrNo(VO.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					VO.setBrcodeName(bctl.getBrName());
				}
				if(StringUtil.isStrNotEmpty(VO.getTlrno())){
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(VO.getTlrno(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					VO.setTlrName(userInfo.getTlrName());
				}

				BeanUtils.copyProperties(VO, threeConfirmVO);
				response.add(threeConfirmVO);
			}
		}
		
		page.setRecords(response);
		return page;
	}
	/**
	 * 
	 */
	@Override
	public ThreeConfirmVO queryContOrProByMastContno(DeliveryQryVO deliveryQryVO)
			throws ScubeBizException {
		ThreeConfirmVO threeConfirmVO = new ThreeConfirmVO();
		com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO dalVO = new  com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO();
		Map<String, Object> map = new HashMap<String, Object>();	
		if (null != deliveryQryVO) {
			String mastContno = deliveryQryVO.getMastContno();// 合同号 
			if(StringUtil.isStrNotEmpty(mastContno)){
				map.put(MASTCONTNO, mastContno);
			}
		}
		//map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_THREEWH);
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		dalVO=aTcsThreeConfirmDAO.getContOrProByMastContno(map);
		if(dalVO!=null){
			BeanUtils.copyProperties(dalVO, threeConfirmVO);
		}
		return threeConfirmVO;
	}
	@Override
	public ThreeConfirmVO queryThreeConfirmByDebet(DeliveryQryVO deliveryQryVO)
			throws ScubeBizException {
		ThreeConfirmVO threeConfirmVO = new ThreeConfirmVO();
		com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO dalVO = new  com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO();
		Map<String, String> map = new HashMap<String, String>();
		if (null != deliveryQryVO) {
			String debetNo = deliveryQryVO.getDebetNo();// 
			if(StringUtil.isStrNotEmpty(debetNo)){
				map.put(DEBETNO, debetNo);
			}
		}
		dalVO=aTcsThreeConfirmDAO.getThreeConfirmByDebet(map);
		
		BigDecimal initCashAndBailAmt=dalVO.getInitCashEqtAmt().add(dalVO.getBailAmount());
		BigDecimal addCashAndBailAmt=dalVO.getAddCashAndBailAmt().add(dalVO.getAddCashEqtAmt());
		dalVO.setInitCashAndBailAmt(initCashAndBailAmt);//初始现金及保证金金额
		dalVO.setAddCashAndBailAmt(addCashAndBailAmt);//追加现金及保证金金额
		
		if(dalVO!=null){
			BeanUtils.copyProperties(dalVO, threeConfirmVO);
		}
		return threeConfirmVO;
	}
	/**
	 * 根据借据号查询开票信息
	 */
	@Override
	public Page queryThreeConfirmBillListByPage(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != deliveryQryVO) {
			String debetNo = deliveryQryVO.getDebetNo();// 借据号
			if(StringUtil.isStrNotEmpty(debetNo)){
				map.put(DEBETNO, debetNo);
			}
		}
		aTcsThreeConfirmDAO.getThreeConfirmBillInfo(map, page);
		return page;
	}
	/**
	 * 根据借据号查询购销合同信息
	 */
	@Override
	public Page queryConfirmContTradeListByPage(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != deliveryQryVO) {
			String debetNo = deliveryQryVO.getDebetNo();// 借据号
			if(StringUtil.isStrNotEmpty(debetNo)){
				map.put(DEBETNO, debetNo);
			}
		}
		aTcsThreeConfirmDAO.getConfirmContTradeInfo(map, page);
		return page;
	}
	/**
	 * 根据购销合同号获得购销合同详情
	 */
	@Override
	public ThreeBuyMortgageInfoVO queryContBuyInfoDtl(DeliveryQryVO deliveryQryVO) throws ScubeBizException {
		ThreeBuyMortgageInfoVO threeBuyMortgageInfoVO = new ThreeBuyMortgageInfoVO();
		com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO dalVO = new  com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO();
		Map<String, Object> map = new HashMap<String, Object>();	
		if (null != deliveryQryVO) {
			String tradeContno = deliveryQryVO.getTradeContno();// 购销合同号 
			if(StringUtil.isStrNotEmpty(tradeContno)){
				map.put(TRADECONTNO, tradeContno);
			}
		}
		map.put(STATE, BSysConstant.FLAG_VALID);
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		dalVO=aTcsThreeConfirmDAO.getContBuyInfoDtl(map);
		if(dalVO!=null){
			BeanUtils.copyProperties(dalVO, threeBuyMortgageInfoVO);
		}
		return threeBuyMortgageInfoVO;
	}
	/**
	 * 根据购销合同号查询购销合同货物列表
	 */
	@Override
	public Page queryContBuyMprotListByPage(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != deliveryQryVO) {
			String tradeContno = deliveryQryVO.getTradeContno();// 购销合同号 
			if(StringUtil.isStrNotEmpty(tradeContno)){
				map.put(TRADECONTNO, tradeContno);
			}
		}
		map.put(MORTLEVELFIRST, ScfBasConstant.MORT_LEVEL_FIRST);
		map.put(MORTLEVELSECOND, ScfBasConstant.MORT_LEVEL_SECOND);
		aTcsThreeConfirmDAO.getContBuyMprotList(map, page);
		return page;
	}
	
	
	//发起流程

	/***
	 * 收款确认申请提交
	 */
	@Transactional
	@Override
	public void threeConfirmApplySubmit(ThreeConfirmVO threeConfirmVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		ThreeApplyVO  applyVO  =new ThreeApplyVO();
		if (null != threeConfirmVO) {
			String appno = threeConfirmVO.getAppno();
			String mastContno = threeConfirmVO.getMastContno();
			String debetNo = threeConfirmVO.getDebetNo();
			String custcd = threeConfirmVO.getCustcd();
			String  cname=threeConfirmVO.getCname(); 
			BigDecimal lnciAmt = threeConfirmVO.getLnciAmt();
			String protocolNo = threeConfirmVO.getProtocolNo();
			String protocolType = threeConfirmVO.getProtocolType(); //协议类型
			if(StringUtil.isStrNotEmpty(appno)){
				applyVO.setAppno(appno);
			}
			if(StringUtil.isStrNotEmpty(mastContno)){
				applyVO.setMastContno(mastContno);
			}
			if(StringUtil.isStrNotEmpty(debetNo)){
				applyVO.setDebetNo(debetNo);
			}
			if(StringUtil.isStrNotEmpty(custcd)){
				applyVO.setCustcd(custcd);
			}
			if(StringUtil.isStrNotEmpty(cname)){
				applyVO.setCname(cname);
			}
			if(StringUtil.isEmpty(lnciAmt)){
				applyVO.setLnciAmt(BigDecimal.ZERO);
			}else{
				applyVO.setLnciAmt(lnciAmt);
			}
			if(StringUtil.isStrNotEmpty(protocolNo)){
				applyVO.setProtocolNo(protocolNo);
			}
			if(StringUtil.isStrNotEmpty(protocolType)){
				applyVO.setProtocolType(protocolType);
			}
		}
		String	businessnoType="";
		String	modelId="";
		if(ScfBasConstant.MUTI_PROTOCOL_THREEWH.equals(threeConfirmVO.getProtocolType())){ //担保提货
			businessnoType = WorkflowConstant.APPLI_TYPE_THREE_ACCOUNTCONFIRM;
			modelId = WorkflowConstant.PROCMODEL_THREE_ACCOUNTCONFIRM_APPLY;
		
		}else if(ScfBasConstant.MUTI_PROTOCOL_FOURWH.equals(threeConfirmVO.getProtocolType())){ //先票款后货
			businessnoType = WorkflowConstant.APPLI_TYPE_FOURACCOUNTCONFIRMAPPLY;
			modelId = WorkflowConstant.PROCNAME_FOUR_ACCOUNT_CONFIRM_APPLY;
		}
		

		//发起流程并保存业务信息
		String appNo = this.saveThipartiteConfirmApply(applyVO, businessnoType, modelId);
		String  custCd=threeConfirmVO.getCustcd(); 
		String  custName=threeConfirmVO.getCname(); 
		
		//发起工作流
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("modelId", modelId);
		paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
		paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
		paramMap.put(WorkflowConstant.CUST_CD, custCd);
		paramMap.put(WorkflowConstant.CUST_NAME, custName);
		ProcessEntity processEntity = new ProcessEntity();
		try {
			processEntity = scfWorkFlowService.startWorkFlow(appNo, modelId, modelId, paramMap);
			//流程流转到下一节点
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
			bPbcAppliBaseInfo.setPiid(processEntity.getProcessId());
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			throw new ScubeBizException("工作流异常");
		}
		
	}
	
	/**
	 * 三方保兑仓收款确认申请0-流程互斥校验、1-借据锁定、2-保存流程信息、3-生成通知书
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public String  saveThipartiteConfirmApply(ThreeApplyVO applyVO, String businessnoType, String workApplyType) throws ScubeBizException{
		String appno=applyVO.getAppno();
		if(StringUtil.isEmpty(appno)){
			//0-流程互斥校验
			//BLanLnciBase baseInfo = bLanLnciBaseDAO.selectByPrimaryKey(applyVO.getDebetNo());
			BLanLnciBase baseInfo =bLanLnciBaseService.findBLanLnciBaseByKey(applyVO.getDebetNo());
			if(ScfBasConstant.LOCKED.equals(baseInfo.getIsLocked())){
				log.error("借据【"+baseInfo.getDebetId()+"】下存在尚未审批的收款确认流程【"+baseInfo.getLockAppno()+"】，无法提交本次申请。");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_20000),ATcsErrorConstant.SCF_ADV_TCS_20000);
			}
			//1-保存流程信息
			appno = this.saveThipartiteConfirmAppBasicInfo(applyVO,businessnoType,workApplyType);
			
			//借据锁定
			bLanLnciBaseService.lockDebtBaseInfo(applyVO.getDebetNo(), appno);
			//2-生成通知书
			this.saveConfirmNoticeInfo(appno,applyVO.getDebetNo());
		}
		return appno;
	}
	//保存流程信息
	@Transactional
	public String saveThipartiteConfirmAppBasicInfo(ThreeApplyVO applyVO,String businessnoType,String workApplyType) throws ScubeBizException {
		this.checkMastContnoIsExist(applyVO.getMastContno());//主合同是否存在
		String appno ="";
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		//BCrrLnCon bCrrLnCon = bCrrLnConDAO.selectByPrimaryKey(applyVO.getMastContno());
		if(StringUtil.isStrEmpty(applyVO.getAppno())){
			BCrrLnCon bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(applyVO.getMastContno());
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			BeanUtils.copyProperties(applyVO,bPbcAppliBaseInfo);
			bPbcAppliBaseInfo.setCustcd(applyVO.getCustcd());                             	// 客户号
			bPbcAppliBaseInfo.setCurcd(bCrrLnCon.getCurcd());                         	// 币种
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);              		 	// 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);                               	// 申请类型
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);        // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			bPbcAppliBaseInfo.setSupplyChainPdId(bCrrLnCon.getVidBusiTyp());         // 产品ID
			bPbcAppliBaseInfo.setMastContno(bCrrLnCon.getAppId());                   // 主合同号
			bPbcAppliBaseInfo.setProtocolNo(applyVO.getProtocolNo());						// 协议号
			bPbcAppliBaseInfo.setAmt(applyVO.getLnciAmt());									// 出账金额
			bPbcAppliBaseInfo.setMemo(applyVO.getMemo());                   	// 描述
			bPbcAppliBaseInfo.setExt1(applyVO.getDebetNo());                   				// 借据号
			if(ScfBasConstant.MUTI_PROTOCOL_THREEWH.equals(applyVO.getProtocolType())){ //担保提货
				appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_T_APP_NO); 
			
			}else if(ScfBasConstant.MUTI_PROTOCOL_FOURWH.equals(applyVO.getProtocolType())){ //先票款后货
				appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_F_APP_NO); 
			}
			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setWorkflowAppno(appno);
			bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}else{
			bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			bPbcAppliBaseInfo.setMemo(applyVO.getMemo());     // 描述
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		
		
		return bPbcAppliBaseInfo.getAppno();
	}
	
	/**
	 * 借据加锁
	 * @param debetNo
	 * @param lockAppno
	 * @throws ScubeBizException
	 */
	/*@Transactional
	public void lockDebtBaseInfo(String debetNo,String lockAppno) throws ScubeBizException{
		BLanLnciBase lanciBaseInfo = new BLanLnciBase();
		//lanciBaseInfo =bLanLnciBaseDAO.selectByPrimaryKey(debetNo);
		lanciBaseInfo=bLanLnciBaseService.findBLanLnciBaseByKey(debetNo);
		if(lanciBaseInfo != null){
			lanciBaseInfo.setIsLocked(ScfBasConstant.LOCKED);
			lanciBaseInfo.setLockAppno(lockAppno);
			//bLanLnciBaseDAO.updateByPrimaryKeySelective(lanciBaseInfo);
			bLanLnciBaseService.updateBLanLnciBase(lanciBaseInfo);
		}
	}*/
	/**
	 * 借据解锁
	 * @param debetNo
	 * @throws ScubeBizException
	 */
	/*@Transactional
	public void releaseDebtBaseInfo(String debetNo) throws ScubeBizException{
		BLanLnciBase lanciBaseInfo = new BLanLnciBase();
		lanciBaseInfo=bLanLnciBaseService.findBLanLnciBaseByKey(debetNo);
		if(lanciBaseInfo != null){
			lanciBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			lanciBaseInfo.setLockAppno("");
			bLanLnciBaseService.updateBLanLnciBase(lanciBaseInfo);
		}
	}*/
  /**
   * checkMastContnoIsExist 效验是否存在对应的合同号的主合同
   * @param mastContno
   * @return
   * @throws ScubeBizException
   */
	public boolean checkMastContnoIsExist(String mastContno)
			throws ScubeBizException {
		BCrrLnCon bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(mastContno);
		//BCrrLnCon bCrrLnCon = bCrrLnConDAO.selectByPrimaryKey(mastContno);
		if (bCrrLnCon != null) {
			return true;
		}
		return false;
	}
	/**
	 * 生成收款确认通知书(城商行)
	 * @param appno
	 * @param debetNo
	 * @throws ScubeBizException
	 */
	@Transactional
	 public void saveConfirmNoticeInfo(String appno,String debetNo)throws ScubeBizException{
		 Page p = new Page();
		 DeliveryQryVO deliveryQryVO = new DeliveryQryVO();
		 deliveryQryVO.setDebetNo(debetNo);
		/**根据借据号获得开票信息*/
		 List<BLanBillBaseInfo> billList = bLanBillBaseInfoService.findBLanBillInfoByDebetNo(debetNo);
		 /**根据借据号获得购销合同流水表*/
		 Page contp =queryConfirmContTradeListByPage(p.getPageNo(), p.getPageSize(), deliveryQryVO);	
		 List<com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO> list =contp.getRecords();
		 StringBuffer buff = new StringBuffer();
	    	if(list!=null&&list.size()>0){
	    		for(int i = 0; i< list.size() ;i++){
	    			com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO vo = list.get(i);
	    			String tradeContcode = vo.getTradeContcode();
	    			if(buff.length()>0){
	    				buff.append(",").append(tradeContcode);
	    			}else{
	    				buff.append(tradeContcode);
	    			}
	    		}
	    	}
	    	//借据信息
	    	//BLanLnciBase bLanLnciBase = bLanLnciBaseDAO.selectByPrimaryKey(debetNo);
	        BLanLnciBase bLanLnciBase =bLanLnciBaseService.findBLanLnciBaseByKey(debetNo);
	        BCntMprotBaseInfo  bCntMprotBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(bLanLnciBase.getProtocolNo()); //监管协议/担保提货协议/先票(款)后货协议信息表
	        String noticeType ="";
    		String noticeNo ="";//通知书编号
	        //add 先票款/后货 收款确认 通知书类型 begin
	        if(ScfBasConstant.MUTI_PROTOCOL_THREEWH.equals(bCntMprotBaseInfo.getProtocolType())){ //担保提货
	        	noticeType = BNteConstant.NOTICE_TYPE_75;//流贷收款确认
	        	noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_T_NOTICE_NO); 
	        	if(!ScfBasConstant.ACCOUNT_WAY_LOAN.equals(bLanLnciBase.getLnciType())){
					noticeType = BNteConstant.NOTICE_TYPE_78;//银承收款确认
					noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_T2_NOTICE_NO); 
				}
	        }
	        //先票款后货
	        else if(ScfBasConstant.MUTI_PROTOCOL_FOURWH.equals(bCntMprotBaseInfo.getProtocolType())){ 
	        	noticeType = BNteConstant.NOTICE_TYPE_77;//流贷收款确认
	        	noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_T_NOTICE_NO); 
	    		if(!ScfBasConstant.ACCOUNT_WAY_LOAN.equals(bLanLnciBase.getLnciType())){
	    			noticeType = BNteConstant.NOTICE_TYPE_79;//银承收款确认
	    			noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_SKQR_T2_NOTICE_NO); 
	    		}
			}
	        //add 先票款/后货 收款确认 通知书类型 end     
			BNteNoticeBase bNteNoticeBaseQuery = new BNteNoticeBase();
			bNteNoticeBaseQuery.setAppno(appno);
			bNteNoticeBaseQuery.setNoticeType(noticeType);
			List<BNteNoticeBase> noticelist = bNteNoticeBaseService.findBNteNoticeBaseByAppno(bNteNoticeBaseQuery);
			BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
			if(noticelist != null && noticelist.size()>0){
				bNteNoticeBase = noticelist.get(0) ;
			}
			bNteNoticeBase.setAppno(appno);
			bNteNoticeBase.setNoticeType(noticeType); //通知书类型
			bNteNoticeBase.setNum(noticeNo);  //通知书编号
			//bNteNoticeBase.setId(null);
			bNteNoticeBase.setProtocolNo(bCntMprotBaseInfo.getProtocolNo());
			bNteNoticeBase.setProtocolCode(bCntMprotBaseInfo.getProtocolCode());//
			if(billList != null && billList.size()>0){
				bNteNoticeBase.setCommonNum(String.valueOf(billList.size()));
			}
			//通过协议号查询参与方	
			List<BCntMprotPartInfo> partList  = bCntMprotPartInfoService.findBCntMpartInfoByProtocolNo(bLanLnciBase.getProtocolNo());//通过协议号查询参与方	
			for(int i=0;i<partList.size();i++){
				BCntMprotPartInfo mutiProtPartInfo = (BCntMprotPartInfo)partList.get(i);
				if(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(mutiProtPartInfo.getRole())){//授信客户
					bNteNoticeBase.setCustcd(mutiProtPartInfo.getCustcd());//借款人
					bNteNoticeBase.setCustName(mutiProtPartInfo.getCname());
				}else if(ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(mutiProtPartInfo.getRole())){//监管公司

				}else if(ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(mutiProtPartInfo.getRole())){//核心厂商
					bNteNoticeBase.setOtherCustcd(mutiProtPartInfo.getCustcd());//
					bNteNoticeBase.setOtherCustName(mutiProtPartInfo.getCname());
				}else if(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(mutiProtPartInfo.getRole())){//回购厂商
					
				}
			}
			 // 获取当前用户 
			UserInfo user = ContextHolder.getUserInfo(); 
			String tlrNo=user.getTlrNo();
			String brCode=user.getBrNo();
			bNteNoticeBase.setCommonAmt(bLanLnciBase.getLnciAmt());
			bNteNoticeBase.setBrcode(brCode);
			bNteNoticeBase.setDebetNo(bLanLnciBase.getDebetNo());
			bNteNoticeBase.setDebetId(bLanLnciBase.getDebetId());
			bNteNoticeBase.setAppliDate(BSysConstant.WORKDATE);
			bNteNoticeBase.setSignDate(BSysConstant.WORKDATE);
			bNteNoticeBase.setStatus(BNteConstant.NOTICE_BASE_STATUS_UNCONFIRM);
			bNteNoticeBase.setMastContcode(bLanLnciBase.getMastContcode());
			bNteNoticeBase.setMastContno(bLanLnciBase.getMastContno());
			bNteNoticeBase.setBussType(bLanLnciBase.getProductId());
			bNteNoticeBase.setTradeContno(buff.toString());//购销合同
			bNteNoticeBase.setTlrn(tlrNo);
	    	//通知书基本表中存入业务品种 
			BPbcAppliBaseInfo bPbcAppliBaseInfo =bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			String productId="";
			if(bPbcAppliBaseInfo!=null){
				productId= bPbcAppliBaseInfo.getSupplyChainPdId();
	    	}
			bNteNoticeBase.setBussType(productId);
			bNteNoticeBaseService.addBNteNoticeBase(bNteNoticeBase);

	    	if(billList!=null && billList.size()>0){
	    		List<BNteNoticeBill>  delNoticeBillList=bNteNoticeBillService.findBNteNoticeBillByAppno(appno);
	    		if(delNoticeBillList!= null && delNoticeBillList.size()>0){
	    			for(int i = 0; i<delNoticeBillList.size();i++){
	    				BNteNoticeBill tblNoticeBillInfo = (BNteNoticeBill) delNoticeBillList.get(i);
	    				bNteNoticeBillService.deleteBNteNoticeBill(tblNoticeBillInfo.getId());
	    			}
	    		}
	    		for(Iterator it = billList.iterator();it.hasNext(); ){
					BLanBillBaseInfo billBaseInfo = (BLanBillBaseInfo) it.next();
					BNteNoticeBill noticeBillInfo = new BNteNoticeBill();
					BeanUtils.copyProperties(billBaseInfo, noticeBillInfo);
					noticeBillInfo.setAppno(appno);
					noticeBillInfo.setPayee(billBaseInfo.getReceiverName());// 收款人
				
					bNteNoticeBillService.addBNteNoticeBill(noticeBillInfo);
					
				}
	    	}	
	 }
	
	
	//收款确认确认回执审批通过
	@Override
	@Transactional
	public void doWorkForPass(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		String debetNo=bPbcAppliBaseInfo.getExt1();//借据号
		//更新借据状态
		this.updateBusinessInfo(debetNo,ScfBasConstant.LNCI_CONFIRM_STATUS_POSITIVE);
		//更新通知书状态
		bNteNoticeBaseService.updaterNoticeStatus(appNo,BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		//借据解锁
		bLanLnciBaseService.releaseDebtBaseInfo(debetNo);
		//更新业务申请表状态
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}

	@Override
	@Transactional
	public void doWorkForReject(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		String debetNo=bPbcAppliBaseInfo.getExt1();//借据号
		//借据解锁
		bLanLnciBaseService.releaseDebtBaseInfo(debetNo);
    	//删除通知书
		bNteNoticeBaseService.deleteBNteNoticeBaseByAppno(appNo);
    	//更新业务申请表状态
    	bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED);
    	bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}
	
	/**
	 * 确认收款审批通过后修改借据状态(线下)
	 * @param debetNo
	 * @param confirmStatus
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	 public String updateBusinessInfo(String debetNo, String confirmStatus)throws ScubeBizException {
			BLanLnciBase bLanLnciBase =bLanLnciBaseService.findBLanLnciBaseByKey(debetNo);//借据基本信息
			BCrrLnCon bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(bLanLnciBase.getMastContno());//信贷合同信息
			//预付款协议扩展信息
			BCntMprotDealInfo  bCntMprotDealInfo =bCntMprotDealInfoService.findBCntMprotDealInfoByKey(bCrrLnCon.getVidNo());
			bLanLnciBase.setConfirmStatus(confirmStatus);
			//更新单笔出账业务（剩余提货金额 = 出账金额、累计提货金额 =  0）
			bLanLnciBase.setAmountIn(bLanLnciBase.getLnciAmt());
			bLanLnciBase.setAmountOut(BigDecimal.ZERO);
			//存入确认日期
			bLanLnciBase.setCommonDate(BSysConstant.WORKDATE);
			//更新借据剩余发货金额=借据金额 
			bLanLnciBase.setBalSendAmt(bLanLnciBase.getLnciAmt()); 
			bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase);
			//更新先票/款后货协议的累计剩余提货金额、收款总金额字段
			bCntMprotDealInfo.setAmountIn((bCntMprotDealInfo.getAmountIn() == null ? BigDecimal.ZERO : bCntMprotDealInfo.getAmountIn()).add(bLanLnciBase.getLnciAmt()));
			bCntMprotDealInfo.setLoanAmt((bCntMprotDealInfo.getLoanAmt() == null ? BigDecimal.ZERO : bCntMprotDealInfo.getLoanAmt()).add(bLanLnciBase.getLnciAmt()));
			bCntMprotDealInfoService.updateBCntMprotDealInfo(bCntMprotDealInfo);
			return bLanLnciBase.getLnciType();
		}
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}
}
