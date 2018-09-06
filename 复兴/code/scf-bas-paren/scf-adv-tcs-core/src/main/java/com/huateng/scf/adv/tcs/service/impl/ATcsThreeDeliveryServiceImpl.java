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
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.bcp.constant.ABcpErrorConstant;
import com.huateng.scf.adv.bcp.dao.IABcpAppliImprestBussDAO;
import com.huateng.scf.adv.bcp.dao.IABcpImprestBussInfoDAO;
import com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo;
import com.huateng.scf.adv.tcs.constant.ATcsErrorConstant;
import com.huateng.scf.adv.tcs.dao.IATcsThreeDeliveryDAO;
import com.huateng.scf.adv.tcs.model.ThreeApplyVO;
import com.huateng.scf.adv.tcs.model.ThreeBuyMortgageInfoVO;
import com.huateng.scf.adv.tcs.model.ThreeDeliveryVO;
import com.huateng.scf.adv.tcs.service.IATcsThreeDeliveryService;
import com.huateng.scf.bas.cnt.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.model.DataItemsDO;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.cnt.model.DeliveryQryVO;
import com.huateng.scf.bas.cnt.service.IBCntBuyInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
//import com.huateng.scf.bas.common.model.AmountVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.icr.constant.BIcrConstant;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyBizService;
import com.huateng.scf.bas.mrn.model.AppendBailAmountVO;
import com.huateng.scf.bas.mrn.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.model.DebetListVO;
import com.huateng.scf.bas.mrn.service.IBMrnAcctBussInfoService;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.nte.service.IBNteNoticeMtgService;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.model.BPbcMtgStorDeli;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStockDtlService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStorDeliService;
import com.huateng.scf.bas.pbc.service.IMortgageEnteringService;
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
 * @date 2016年12月25日下午2:51:39
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月25日下午2:51:39              新增
 *
 * </pre>
 */
@ScubeService
@Service("ATcsThreeDeliveryServiceImpl")
public class ATcsThreeDeliveryServiceImpl implements IATcsThreeDeliveryService ,DealInFlowService,DealEndFlowService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "ATcsThreeDeliveryDAO")
	private IATcsThreeDeliveryDAO aTcsThreeDeliveryDAO;
	@Resource(name = "ABcpAppliImprestBussDAO")
	IABcpAppliImprestBussDAO aBcpAppliImprestBussDAO;
	@Resource(name = "ABcpImprestBussInfoDAO")
	IABcpImprestBussInfoDAO aBcpImprestBussInfoDAO; 
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;//业务申请表
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService bLanLnciBaseService;//借据基本信息表
	@Resource(name = "bCrrLnConService")
	IBCrrLnConService bCrrLnConService;
	@Resource(name = IBLanLnciBuyBizService.BEAN_ID)
	IBLanLnciBuyBizService bLanLnciBuyBizService;
	@Resource(name = IBNteNoticeBaseService.BEAN_ID)
	IBNteNoticeBaseService bNteNoticeBaseService; //通知书
	@Resource(name = IBPbcAppliMtgInfoService.BEAN_ID)
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService; //业务申请押品信息
	@Resource(name = IBMrnAppliAcctInfoService.BEAN_ID)
	IBMrnAppliAcctInfoService bMrnAppliAcctInfoService; //保证金及现金等价物业务申请信息
	@Resource(name = IBCntMprotBaseInfoService.BEAN_ID)
	IBCntMprotBaseInfoService bCntMprotBaseInfoService; //监管协议/担保提货协议/先票(款)后货协议信息表
	@Resource(name = IBCntMprotPartInfoService.BEAN_ID)
	IBCntMprotPartInfoService bCntMprotPartInfoService; //多方协议参入者信息
	@Resource(name = IBNteNoticeMtgService.BEAN_ID)
	IBNteNoticeMtgService bNteNoticeMtgService;//通知书关联押品信息
	@Resource(name ="iBCntBuyInfoService") //TODO
	IBCntBuyInfoService bCntBuyInfoService;//购销合同信息
	@Resource(name = IBPbcMtgStorDeliService.BEAN_ID)
	IBPbcMtgStorDeliService bPbcMtgStorDeliService; //押品变更流水信息
	@Resource(name = IBPbcMtgStockDtlService.BEAN_ID)
	IBPbcMtgStockDtlService bPbcMtgStockDtlService; //押品信息变更明细
	@Resource(name = IBMrnAcctBussInfoService.BEAN_ID)
	IBMrnAcctBussInfoService bMrnAcctBussInfoService; //保证金及现金等价物交易流水
	@Resource(name = IBIcrInfoService.BEAN_ID)
	IBIcrInfoService bIcrInfoService; //额度信息
	@Resource(name = "amountService")
	IAmountService amountService; //金额
	@Resource(name = "mortgageEnteringService")
	IMortgageEnteringService mortgageEnteringService; //押品
	
	@Resource(name = "bSysSerialNoService")
	private  IBSysSerialNoService bSysSerialNoService;
	
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
	private static final String PROTOCOLTYPE = "protocolType";
	private static final String ROLECREDIT = "roleCredit";
	private static final String ROLECORE = "roleCore";
	private static final String STATE = "state";
	private static final String ISSETTLE = "isSettle";
	private static final String APPNO = "appno";
	private static final String DEBETNO = "debetNo";
	private static final String ADDEDLIST = "addedList";

  /**
   * 提货申请查询列表
   */
	@Override
	public Page queryATcsThreeDeliveryListByPage(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO)
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
		map.put(PROTOCOLTYPE, ScfBasConstant.MUTI_PROTOCOL_THREEWH);
		map.put(ROLECREDIT, ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		map.put(ROLECORE, ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		map.put(STATE, BSysConstant.FLAG_OFF); //记录状态
		map.put(ISSETTLE, BSysConstant.FLAG_OFF); //是否结清
		aTcsThreeDeliveryDAO.selectThreeDeliveryList(map, page);
		return page;
	}

	/**
	 * 提货申请信息
	 */
	@Override
	public ThreeDeliveryVO getThreeDeliveryInfo(DeliveryQryVO deliveryQryVO) throws ScubeBizException {
		ThreeDeliveryVO threeDeliveryVO = new ThreeDeliveryVO();
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
				threeDeliveryVO=this.getThreeDeliveryInfoByAppno(map);
			}else{
				threeDeliveryVO=this.getThreeDeliveryInfoByDebetNo(map);
			}
		
		}
		return threeDeliveryVO;
	}
	/**
	 * 根据借据号查询提货信息
	 * @param deliveryQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public ThreeDeliveryVO getThreeDeliveryInfoByDebetNo(Map<String, Object> map) throws ScubeBizException {
		ThreeDeliveryVO vo = new ThreeDeliveryVO();
		com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO dalVO = new  com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO();
		dalVO=aTcsThreeDeliveryDAO.getThreeDeliveryInfoByDebetNo(map);
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
	public ThreeDeliveryVO getThreeDeliveryInfoByAppno(Map<String, Object> map) throws ScubeBizException {
		ThreeDeliveryVO vo = new ThreeDeliveryVO();
		com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO dalVO = new  com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO();
		dalVO=aTcsThreeDeliveryDAO.getThreeDeliveryInfoByAppno(map);
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
		BLanLnciBase lnciBase =bLanLnciBaseService.findBLanLnciBaseByKey(vo.getDebetNo());
		BPbcAppliBaseInfo appbase=bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(vo.getAppno());
		if(appbase.getChannelFlag()!=null&&appbase.getChannelFlag().equals(ScfBasConstant.CHANNEL_FLAG_IFSP)) {
			vo.setIfspFlag("true");
			amountVO.setLnciType(lnciBase.getLnciType());
			BigDecimal canDeliveryAmt = BigDecimal.ZERO;
			BigDecimal openAmount = BigDecimal.ZERO;
			canDeliveryAmt=amountService.getDelivery(amountVO);//可提货金额
			openAmount=amountService.getPant(amountVO);//敞口金额
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
		}
		return vo;
	}

	/**
	 * 根据借据号查询对应出账的贸易合同押品信息
	 */
	@Override
	public Page getTripartiteDeliveryAppMortList(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO,List<ThreeBuyMortgageInfoVO>list)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
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
			if(StringUtil.isEmpty(debetNo)){
				if(StringUtil.isStrNotEmpty(appno)){
					BPbcAppliBaseInfo bean = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
					if(bean==null){
						log.error("申请基本信息丢失");
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002),ATcsErrorConstant.SCF_ADV_TCS_10002);
					}else{
						debetNo = bean.getExt1();//借据号
					}
				}else{
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002),ATcsErrorConstant.SCF_ADV_TCS_10002);
				}
			}
			if(StringUtil.isEmpty(debetNo)){
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002),ATcsErrorConstant.SCF_ADV_TCS_10002);
			}
		}
		//列表已有的
		List<String> selectList = new ArrayList<String>();
		if(list!=null&&list.size()>0){
			for(ThreeBuyMortgageInfoVO info:list){
				selectList.add(info.getMortgageNo());	
			}
			map.put(ADDEDLIST,selectList);
		}
	
		aTcsThreeDeliveryDAO.getTripartiteDeliveryAppMortList(map, page);
		return page;
	}
	
	/**
	 * 根据申请编号查询提货货物信息(线下)
	 */
	@Override
	public Page getDeliveryMortgageListByAppno(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		if (null != deliveryQryVO) {
			String appno = deliveryQryVO.getAppno();
			if(StringUtil.isStrEmpty(appno)){
				log.error("申请编号丢失");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10003),ATcsErrorConstant.SCF_ADV_TCS_10003);
			}
		  	//1、获得已存在押品列表
			List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
			List<ThreeBuyMortgageInfoVO> queryResult = new ArrayList<ThreeBuyMortgageInfoVO>();
			if(mortList!=null&&mortList.size()>0){
				for (int j = 0; j < mortList.size(); j++) {
					BPbcAppliMtgInfo bean = (BPbcAppliMtgInfo) mortList.get(j);
					ThreeBuyMortgageInfoVO vo = new ThreeBuyMortgageInfoVO();
					BCntBuyInfo bCntBuyInfo = bCntBuyInfoService.findBCntBuyInfoByKey(bean.getTradeContno());
					vo.setTradeContno(bean.getTradeContno());//购销合同号
					if(bCntBuyInfo!=null){
						vo.setTradeContcode(bCntBuyInfo.getTradeContcode());
					}
					vo.setAppno(bean.getAppno());
					vo.setMortgageNo(bean.getMortgageNo());
					vo.setMortgageName(bean.getMortgageName());
					String mortgageLevelOne =bean.getMortgageLevelOne();
					vo.setMortgageLevelOne(mortgageLevelOne);
					String mortgageLevelTwo =bean.getMortgageLevelTwo();
					vo.setMortgageLevelTwo(mortgageLevelTwo);
					//押品等级
					DataItemsDO dataItemsDOOne = new DataItemsDO();
					dataItemsDOOne.setLevels(ScfBasConstant.MORTGAGE_LEVEL_ONE);
					List<DataItemsVO> OneList =mortgageEnteringService.getMortgageLevel(dataItemsDOOne);
					
					if(OneList!=null&&OneList.size()>0){
						Iterator<?> iter=OneList.iterator();
						while(iter.hasNext()){
							DataItemsVO  VO= (DataItemsVO) iter.next();
						    if(VO.getCode().equals(mortgageLevelOne)){
						    	vo.setMortgageLevelOneName(VO.getCodeName());
						    	break;
						 }
						}
					}
					DataItemsDO dataItemsDOTwo = new DataItemsDO();
					dataItemsDOTwo.setLevels(ScfBasConstant.MORTGAGE_LEVEL_TWO);
					List<DataItemsVO> TwoList =mortgageEnteringService.getMortgageLevel(dataItemsDOTwo);
					
					if(TwoList!=null&&TwoList.size()>0){
						Iterator<?> iter=TwoList.iterator();
						while(iter.hasNext()){
							DataItemsVO  VO= (DataItemsVO) iter.next();
						    if(VO.getCode().equals(mortgageLevelTwo)){
						    	vo.setMortgageLevelTwoName(VO.getCodeName());
						    	break;
						 }
						}
					}
					vo.setMortgageModel(bean.getMortgageModel());//规格型号
					vo.setQuantity(bean.getBillQuantity());//库数量
					vo.setOutQuantity(bean.getQuantity());//提货数量
					vo.setConfirmPrice(bean.getConfirmPrice());
					vo.setMortgageUnits(bean.getMortgageUnits());//计量单位
					vo.setTotPrice(bean.getTotPrice());
					vo.setOriginalTotPrice(bean.getOriginalTotPrice());//原总价
					vo.setDocumentNo(bean.getDocumentNo());//凭证
					vo.setMemo(bean.getDescription());
					vo.setPrice(bean.getPrice());
	    			queryResult.add(vo);
				}
				page.setTotal(queryResult.size());
				page.setRecords(queryResult);
			}
		}
		return page;
	}

	/**
	 * 担保提货申请保存
	 */
	@Override
	@Transactional
	public String saveThreeDeliveryAppInfo(ThreeDeliveryVO threeDeliveryVO, List<ThreeBuyMortgageInfoVO> list)
			throws ScubeBizException {
		String appno =this.saveThreeDeliveryInfo(threeDeliveryVO, list,false);
		return appno;
	}
	

	/**
	 * 担保提货申请提交
	 * @throws FlowsharpException 
	 */
	@Transactional
	@Override
	public void saveThreeDeliveryAppInfoSubmit(ThreeDeliveryVO threeDeliveryVO, List<ThreeBuyMortgageInfoVO> list)
			throws ScubeBizException, FlowsharpException {
		// TODO Auto-generated method stub
		String appno = this.saveThreeDeliveryInfo(threeDeliveryVO, list,true);
		
		//流程流转
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		
//		String processId= bPbcAppliBaseInfo.getPiid();
//		UserInfo user = ContextHolder.getUserInfo();
//		String userId = user.getTlrNo();
//		// 领取任务
//		String taskId = WorkflowConstant.TASKNODE_APPLY;
//		taskService.takeTask(taskId, processId, userId);
//		// 任务提交
//		String comment = "申请提交";
//		taskService.completeTask(taskId, processId, userId, comment);
//		// 节点转移
//		processService.signal(processId, WorkflowConstant.PROCNODE_APPROVE);
//      //更新业务申请信息状态
//		bPbcAppliBaseInfo.setApprover(userId); // 当前已审批人员
//		bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
//		bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new Date())); // 当前已审批日期
//		bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
//		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
//		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
//		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		
	}
	
	/**
	 * DESCRIPTION:提货申请保存流程及业务信息(线下)
	 * savaThreeDeliveryInfo 方法
	 * @param vo
	 * @param basicVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 */
	@Transactional
	public String saveThreeDeliveryInfo(ThreeDeliveryVO threeDeliveryVO,List<ThreeBuyMortgageInfoVO> list,Boolean flag) throws ScubeBizException{
		//ApplyService applyService = ApplyService.getInstance();
		String appno="";
		ThreeApplyVO applyVO = new ThreeApplyVO();
		
		//CommonFunction.copyProperties(applyVOVo, vo);
/*		applyVO.setDebetNo(threeDeliveryVO.getDebetNo());
		applyVO.setAmount(threeDeliveryVO.getAmount());
		applyVO.setMemo(threeDeliveryVO.getMemo());
		applyVO.setMastContno(threeDeliveryVO.getMastContno());*/
		BeanUtils.copyProperties(threeDeliveryVO, applyVO);
		if(StringUtil.isEmpty(threeDeliveryVO.getAppno())){
			String businessnoType = WorkflowConstant.APPLI_TYPE_THREE_DELIVERYAPPLY;
			String modelId  = WorkflowConstant.PROCMODEL_THREE_DELIVERY_APPLY;
			//0-流程互斥校验
			BLanLnciBase baseInfo = bLanLnciBaseService.findBLanLnciBaseByKey(threeDeliveryVO.getDebetNo());
			
			if(ScfBasConstant.LOCKED.equals(baseInfo.getIsLocked())){
				log.error("借据【"+baseInfo.getDebetId()+"】下存在尚未审批的收款确认流程【"+baseInfo.getLockAppno()+"】，无法提交本次申请。");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_20000),ATcsErrorConstant.SCF_ADV_TCS_20000);
			}
			
			appno = this.saveThreeDeliveryAppBasicInfo(applyVO, businessnoType, modelId);//发起流程
			applyVO.setAppno(appno);
			threeDeliveryVO.setAppno(appno);

			this.saveThreeDeliveryAppInfo(applyVO,threeDeliveryVO,list,flag);//保存业务信息
			//借据锁定
			bLanLnciBaseService.lockDebtBaseInfo(threeDeliveryVO.getDebetNo(), appno);
			String  custCd=threeDeliveryVO.getCustcd(); 
			String  custName=threeDeliveryVO.getCname();  //买方名称
			
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
			
			/*
			  // 获取当前用户 
		    UserInfo user = ContextHolder.getUserInfo(); 
		    String startedUserId=user.getTlrNo();
		    //扩展业务信息
			String  bizId=appno; 
			String  custCd=threeDeliveryVO.getCustcd(); 
			String  custName=threeDeliveryVO.getCname();  //买方名称
			 String  ProcessName = WorkflowConstant.PROCNAME_THREE_DELIVERY_APPLY;
			
			String  NodeId = WorkflowConstant.PROCNODE_APPLY;
			
			//流程发起
			ProcessEntity processEntity = processService.startProcess(modelId, ProcessName, NodeId, startedUserId, bizId,
					new String[]{bizId,custCd,custName,modelId});
			//更新业务申请表工作流实例号
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			String processId =processEntity.getProcessId();
			bPbcAppliBaseInfo.setPiid(processId); 
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);*/
		
			return appno;
		}else{
			appno = threeDeliveryVO.getAppno();
			
			applyVO.setAppno(threeDeliveryVO.getAppno());
			threeDeliveryVO.setProtocolNo(applyVO.getProtocolNo());
			threeDeliveryVO.setMastContno(applyVO.getMastContno());
			threeDeliveryVO.setAppno(appno);
			threeDeliveryVO.setCustcd(applyVO.getCustcd());
			threeDeliveryVO.setCoreCustcd(applyVO.getCoreCustcd());
			this.saveThreeDeliveryAppInfo(applyVO,threeDeliveryVO,list,flag);//保存业务信息
			BPbcAppliBaseInfo  appliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			appliBaseInfo.setAmt(threeDeliveryVO.getAmount());
			//appliBaseInfo.setRiskamt(threeDeliveryVO.getOpenAmount());
			appliBaseInfo.setMemo(threeDeliveryVO.getMemo());
			//appliBaseInfo.setDescription(vo.getDescription());
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(appliBaseInfo);
			return appno;
		}
	}
	
	/**
	 * DESCRIPTION:三方保兑仓提货申请保存流程信息(线下)
	 * saveThreeDeliveryAppBasicInfo 方法
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @return
	 */
	@Transactional
	public String saveThreeDeliveryAppBasicInfo(ThreeApplyVO applyVO,String businessnoType,String workApplyType) throws ScubeBizException {
		this.checkMastContnoIsExist(applyVO.getMastContno());//主合同是否存在
		applyVO.setAppno("");
		BCrrLnCon bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(applyVO.getMastContno());
		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		BeanUtils.copyProperties(applyVO,bPbcAppliBaseInfo);// 拷贝信息
		bPbcAppliBaseInfo.setCustcd(applyVO.getCustcd()); // 客户号
		bPbcAppliBaseInfo.setCurcd(bCrrLnCon.getCurcd()); // 币种
		bPbcAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
		bPbcAppliBaseInfo.setAppliType(businessnoType); // 申请类型
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）

		bPbcAppliBaseInfo.setSupplyChainPdId(applyVO.getProductId()); // 产品ID
		bPbcAppliBaseInfo.setMastContno(bCrrLnCon.getAppId());    // 主合同号
		bPbcAppliBaseInfo.setAmt(applyVO.getAmount()); // 提货金额
		bPbcAppliBaseInfo.setMemo(applyVO.getMemo()); // 描述
		bPbcAppliBaseInfo.setExt1(applyVO.getDebetNo()); // 借据号
		// tblAppliBaseInfo.setBusinessnoType(contBaseInfo.getLoanWay());
		bPbcAppliBaseInfo.setBusinessno(applyVO.getProtocolNo());
		String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_THSQ_T_APP_NO); 
		bPbcAppliBaseInfo.setAppno(appno);
		bPbcAppliBaseInfo.setWorkflowAppno(appno);
		bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);

		return bPbcAppliBaseInfo.getAppno();
	}
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
		 * DESCRIPTION:提货申请业务信息保存(线下)
		 * saveThreeDeliveryAppInfo 方法
		 * @param storDeliInfoVO
		 * @param basicVO
		 * @param list
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		@Transactional
		public void saveThreeDeliveryAppInfo(ThreeApplyVO vo,ThreeDeliveryVO threeDeliveryVO,List<ThreeBuyMortgageInfoVO> list,Boolean flag) throws ScubeBizException{
			//基本申请信息校验&&获取
			BPbcAppliBaseInfo bean = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(threeDeliveryVO.getAppno());
			if(bean == null){
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002),ATcsErrorConstant.SCF_ADV_TCS_10002);
			}
			//if(flag){
				//0、校验数据
				this.deliveryCheck(threeDeliveryVO,list,flag);
			//}
	    	//1、保存业务流水信息
	    	this.threeDeliveryAppBasicInfoSave(threeDeliveryVO,bean);
	    	//2、保存货物信息申请表
	    	this.ThreeDeliveryAppMortListSave(threeDeliveryVO,list);
	    	//3生成通知书
	    	if(flag){
	    		this.ThreeDeliveryNoticeInfoSave(vo.getAppno());//生成通知书
	    	}
		}
		/**
		 * DESCRIPTION:提货申请保存货物信息(线下)
		 * ThreeDeliveryAppMortListSave 方法
		 * @param vo
		 * @param insertList
		 * @param commonQueryVO
		 * @return
		 * @throws ScubeBizException
		 */
		@Transactional
		public void ThreeDeliveryAppMortListSave(ThreeDeliveryVO vo,List<ThreeBuyMortgageInfoVO> list) throws ScubeBizException{

	    	//1、获得已存在押品列表
			List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(vo.getAppno());
	    	//2、删除已存在押品列表
	    	for (int i = 0; i < mortList.size(); i++) {
	    		BPbcAppliMtgInfo bean = (BPbcAppliMtgInfo) mortList.get(i);
	    		bPbcAppliMtgInfoService.deleteBPbcAppliMtgInfo(bean.getId());
			}
	    	//3、添加押品列表
	    	for (Iterator<ThreeBuyMortgageInfoVO> iterator = list.iterator(); iterator.hasNext();) {
				ThreeBuyMortgageInfoVO mortVO = (ThreeBuyMortgageInfoVO) iterator.next();
				BPbcAppliMtgInfo bean = new BPbcAppliMtgInfo();
				bean.setAppno(vo.getAppno());
				bean.setCustcd(vo.getCustcd());
				bean.setOtherProtocolNo(vo.getProtocolNo());//协议号
				bean.setMortgageNo(mortVO.getMortgageNo());
				bean.setMortgageName(mortVO.getMortgageName());
				bean.setMortgageLevelOne(mortVO.getMortgageLevelOne());
				bean.setMortgageLevelTwo(mortVO.getMortgageLevelTwo());
				bean.setMortgageModel(mortVO.getMortgageModel());//规格型号
				bean.setTradeContno(mortVO.getTradeContno());
				bean.setQuantity(mortVO.getOutQuantity()); //本次提货数量
				bean.setBillQuantity(mortVO.getQuantity());//货物重量/数量
				bean.setConfirmPrice(mortVO.getConfirmPrice());
				bean.setMortgageUnits(mortVO.getMortgageUnits()==null?(mortVO.getCountUnits()==null?"":mortVO.getCountUnits()):mortVO.getMortgageUnits());//计量单位
				bean.setTotPrice(mortVO.getTotPrice());
				bean.setDocumentNo(mortVO.getDocumentNo());//相关凭证号
				bean.setDescription(mortVO.getMemo());//todo
				bean.setOriginalTotPrice(mortVO.getOriginalTotPrice());//原总价
				bean.setPrice(mortVO.getPrice());
				bean.setCurcd(mortVO.getCurcd());
				bean.setManufactureDate(BSysConstant.WORKDATE);
				bean.setAppliMortBizType(WorkflowConstant.APPLI_TYPE_THREE_DELIVERYAPPLY);
				bPbcAppliMtgInfoService.addBPbcAppliMtgInfo(bean);
			}

	    }
		
		/**
		 * DESCRIPTION:提货流程提交申请校验数据
		 * @author zhoujun.hou
		 * @date 2013-4-26
		 * checkPickUpMortgage 方法
		 * @param insertList
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		public void deliveryCheck(ThreeDeliveryVO deliveryVO,List<ThreeBuyMortgageInfoVO> list,boolean flag) throws ScubeBizException{

			//验证提货金额不大于购销合同总金额

			Map<String,BigDecimal> map=new HashMap<String,BigDecimal>();
			if(list!=null && list.size()>0){
	    		for(int i = 0 ; i < list.size() ; i++){
	    			ThreeBuyMortgageInfoVO vo = (ThreeBuyMortgageInfoVO) list.get(i);
	    			String tradeContno=vo.getTradeContno();
	    			BigDecimal totPrice=vo.getTotPrice()==null?BigDecimal.ZERO:vo.getTotPrice();
	    			if(!map.isEmpty()&&map!=null&&map.size()>0&&map.containsKey(tradeContno)){
	    				BigDecimal OtotPrice=(BigDecimal) map.get(tradeContno);
	    				map.put(tradeContno,totPrice.add(OtotPrice));
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
		    			//List list=SCFDAOUtils.getTblLnciBuyInfoDAO().queryByCondition(" po.tradeContno='"+tradeContno+"' and po.debetNo='"+deliveryVO.getDebetNo()+"'");
		    			BLanLnciBuyBiz bLanLnciBuyBiz=null;
		    			if(list!=null&&list.size()>0){
		    				bLanLnciBuyBiz=(BLanLnciBuyBiz)Bizlist.get(0);
			    			 loanAmt=bLanLnciBuyBiz.getLoanAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getLoanAmt();//本次出账金额
			    			 accuWthdrawAmt=bLanLnciBuyBiz.getAccuWithdrawAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getAccuWithdrawAmt();//本次出账购销合同下的累计提货金额
			    			 tradeContCode=bLanLnciBuyBiz.getTradeContcode();
		    			}else{
		    				log.error("购销合同："+tradeContno+"获取放款购销合同失败！");
		    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40000),ATcsErrorConstant.SCF_ADV_TCS_40000);
		    			}
		    			BLanLnciBase  lnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(bLanLnciBuyBiz.getDebetNo());

		    			BPbcAppliBaseInfo appbase=bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(lnciBase.getAppno());
		    			if(appbase==null){
		    				log.error("购销合同对应的借据的申请信息丢失！");
		    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40011),ATcsErrorConstant.SCF_ADV_TCS_40011);
		    			}
		    		if(appbase.getChannelFlag()!=null&&appbase.getChannelFlag().equals(ScfBasConstant.CHANNEL_FLAG_IFSP)) {
		    				if(totPrice.compareTo(loanAmt.add(lnciBase.getOwnFundPayAmt()==null?BigDecimal.ZERO:lnciBase.getOwnFundPayAmt()).subtract(accuWthdrawAmt))>0){
		    					log.error("购销合同号为【"+tradeContCode+"】的提货总金额【"+totPrice+"】大于当前放款购销合同下的可提货金额【"+loanAmt.subtract(accuWthdrawAmt)+"】！");
			    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40001),ATcsErrorConstant.SCF_ADV_TCS_40001);
			    			}
		    			}else{
			    			if(totPrice.compareTo(loanAmt.subtract(accuWthdrawAmt))>0){
			    				log.error("购销合同号为【"+tradeContCode+"】的提货总金额【"+totPrice+"】大于当前放款购销合同下的可提货金额【"+loanAmt.subtract(accuWthdrawAmt)+"】！");
			    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40001),ATcsErrorConstant.SCF_ADV_TCS_40001);
			    			}
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
		    	//amountvo = new AmountVO(productId,null,null,deliveryVO.getDebetNo(),ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
		    	amountvo.setAddBailAmount(addBailAmount);
				BLanLnciBase  lnciInfo = bLanLnciBaseService.findBLanLnciBaseByKey(deliveryVO.getDebetNo());

				amountvo.setLnciType(lnciInfo.getLnciType());//ifsp流贷借据类型判断后续使用
				BigDecimal canDeliveryAmt=BigDecimal.ZERO;//可提货金额
				//TODO
				canDeliveryAmt = amountService.getDelivery(amountvo);


		    	if(amount.compareTo(canDeliveryAmt)>0){
		    		log.error("本次申请提货金额不能大于本次可提货金额！");
    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40002),ATcsErrorConstant.SCF_ADV_TCS_40002);
		    	}
		    	if(list!=null && list.size()>0){
		    		for(int i = 0 ; i < list.size() ; i++){
		        		ThreeBuyMortgageInfoVO vo = (ThreeBuyMortgageInfoVO) list.get(i);
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
		 * DESCRIPTION:保存提货申请信息(线下)
		 * threeDeliveryAppBasicInfoSave 方法
		 * @param vo
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		@Transactional
		public void threeDeliveryAppBasicInfoSave(ThreeDeliveryVO vo,BPbcAppliBaseInfo appliBaseInfo) throws ScubeBizException{
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
			ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(vo.getAppno());
			UserInfo user = ContextHolder.getUserInfo(); 
			if(abcpAppliImprestBuss!=null){
				abcpAppliImprestBuss.setCommonAmt(vo.getAmount());// 本次申请提货总金额
				abcpAppliImprestBuss.setPickAmt(vo.getCanDeliveryAmt());//本次可提货金额
				abcpAppliImprestBuss.setAddBailAmt(vo.getAddBailAmount());//本次追加保证金
				abcpAppliImprestBuss.setCoreBailAmt(vo.getCoreBailAmount());//核心保证金金额
				abcpAppliImprestBuss.setRiskAmt(vo.getOpenAmount()==null?BigDecimal.ZERO:vo.getOpenAmount());//敞口余额
				try {
					aBcpAppliImprestBussDAO.updateByPrimaryKeySelective(abcpAppliImprestBuss);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.error("预付款业务申请流水更新异常");
					e.printStackTrace();
					throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10002),ABcpErrorConstant.SCF_ADV_BCP_10002);
				}
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
				
				bean.setCreateDate(BSysConstant.WORKDATE);//建档日期
				bean.setMgrno(user.getTlrNo());//客户经理
				bean.setBrcode(user.getBrNo());//经办机构
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
				if(tempAmt.compareTo(new BigDecimal("0"))<=0){
					bean.setRiskAmt(new BigDecimal("0"));//敞口余额
				}else{
					bean.setRiskAmt(tempAmt);//敞口余额
				}
				bean.setRiskAmt(vo.getOpenAmount()==null?BigDecimal.ZERO:vo.getOpenAmount());//敞口余额

				bean.setLnciBal(bLanLnciBase.getLnciBal());//借据金额
				bean.setLnciAmt(bLanLnciBase.getLnciAmt());//借据余额

				bean.setId(UUIDGeneratorUtil.generate());//主键
				
				try {
					aBcpAppliImprestBussDAO.insertSelective(bean);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("预付款业务申请流水插入异常");
					e.printStackTrace();
					throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10001),ABcpErrorConstant.SCF_ADV_BCP_10001);
				}

			}
		}
		

		/**
		 * DESCRIPTION:三方保兑仓提货申请生成通知书(线下)
		 * ThreeDeliveryNoticeInfoSave 方法
		 * @param appno
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		@Transactional
		public void ThreeDeliveryNoticeInfoSave(String appno) throws ScubeBizException{
	    	//1、通知书主表写入
	    	//String id = this.deliveryNoticeBasicInfoSave(appno);
			//通知书编号
    		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_THSQ_T_NOTICE_NO); 
    		String id = bNteNoticeBaseService.deliveryNoticeBasicInfoSave(appno, noticeNo);
	    	//2、通知书押品信息表写入
	    	this.threeDeliveryNoticeMortListSave(appno,id);

	    }
	    /**
	     * DESCRIPTION:保兑仓提货申请生成通知书(城商行)
	     * @param appno
	     * @return
	     * @throws ScubeBizException
	     * @param commonQueryVO
	     * @return
	     */
/*		@Transactional
	    public String deliveryNoticeBasicInfoSave(String appno) throws ScubeBizException{
	    	//检查通知书是否已经存在
			//2、数据准备
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			if(bPbcAppliBaseInfo==null){
				log.error("申请基本信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002),ATcsErrorConstant.SCF_ADV_TCS_10002);
			}

	        //业务流水记录
			ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(appno);
			if(abcpAppliImprestBuss==null){
				log.error("业务申请流水信息丢失!");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30002),ATcsErrorConstant.SCF_ADV_TCS_30002);
			}
			BCrrLnCon  bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(bPbcAppliBaseInfo.getMastContno());
			if(bCrrLnCon==null){
				log.error("合同信息丢失!");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10003),ATcsErrorConstant.SCF_ADV_TCS_10003);
			}
			BCntMprotBaseInfo baseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(bPbcAppliBaseInfo.getProtocolNo());
	    	BNteNoticeBase  bNteNoticeBase = null;
	    	BNteNoticeBase  bNteNoticeBaseQry = new BNteNoticeBase();
	    	bNteNoticeBaseQry.setAppno(appno);
	    	//提货申请只有一张通知书 使用该方法  两张以上的通知书不适用
	    	List<BNteNoticeBase>  result = bNteNoticeBaseService.findBNteNoticeBaseByAppno(bNteNoticeBaseQry);
	    	if(result!=null&&result.size()>0){
	    		bNteNoticeBase = (BNteNoticeBase) result.get(0);
	    	}else{
	    		bNteNoticeBase = new BNteNoticeBase();
	    		//通知书编号
	    		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_THSQ_T_NOTICE_NO); 
	    		bNteNoticeBase.setNum(noticeNo);
				bNteNoticeBase.setId(null);
	    	}

	    	bNteNoticeBase.setAppno(appno);
	    	//通过协议号查询参与方	
	    	List<BCntMprotPartInfo> partList = bCntMprotPartInfoService.findBCntMpartInfoByProtocolNo(bPbcAppliBaseInfo.getProtocolNo());//通过协议号查询参与方
			//String coreCustcd = "";
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
			bNteNoticeBase.setMastContno(bPbcAppliBaseInfo.getMastContno());//主合同
			bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_80);//预付款提货通知书
			bNteNoticeBase.setProtocolNo(bCrrLnCon.getVidNo());//三方协议
			bNteNoticeBase.setProtocolCode(baseInfo.getProtocolCode());
			bNteNoticeBase.setOrderNo(abcpAppliImprestBuss.getNum()==null?"":abcpAppliImprestBuss.getNum());//收款确认函编号
			bNteNoticeBase.setCommonAmt(abcpAppliImprestBuss.getCommonAmt());//本次提货金额

			bNteNoticeBase.setDebetNo(abcpAppliImprestBuss.getDebetNo());//借据号

	    	BLanLnciBase bLanLnciBase=bLanLnciBaseService.findBLanLnciBaseByKey(abcpAppliImprestBuss.getDebetNo());
	    	bNteNoticeBase.setDebetId(bLanLnciBase==null?null:bLanLnciBase.getDebetId());

	    	//bNteNoticeBase.setBussType(abcpAppliImprestBuss.getBussType());//业务类型

	    	bNteNoticeBase.setBrcode(brCode);//签发机构
	    	bNteNoticeBase.setTlrn(tlrNo);//签发人
	    	bNteNoticeBase.setAppliDate(BSysConstant.WORKDATE);//日期
	    	bNteNoticeBase.setStatus(BNteConstant.NOTICE_BASE_STATUS_UNCONFIRM);//未签发
	    	//通知书基本表中存入业务品种 
			String productId="";
			if(bPbcAppliBaseInfo!=null){
				productId= bPbcAppliBaseInfo.getSupplyChainPdId();
				bNteNoticeBase.setBussType(productId);
	    	}

	    	if(bNteNoticeBase.getId()==null){//新增
	    		bNteNoticeBaseService.addBNteNoticeBase(bNteNoticeBase);
	    	}else{
	    		bNteNoticeBaseService.updateBNteNoticeBase(bNteNoticeBase);
	    	}
	    	return bNteNoticeBase.getId();
	    }*/
	    /**
		 * DESCRIPTION:三方保兑仓提货申请通知书保存押品信息(线下)
		 * threeDeliveryNoticeMortListSave 方法
		 * @param appno
		 * @param id
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		@Transactional
		public void threeDeliveryNoticeMortListSave(String appno,String id) throws ScubeBizException{
			//1、获得已存在押品列表
			List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
			 //2、校验通知书押品列表--删除重新写入
			 List<BNteNoticeMtg> list = bNteNoticeMtgService.findBNteNoticeMtgByAppno(appno);
			 for (int i = 0; i < list.size(); i++) {
				 BNteNoticeMtg bean = (BNteNoticeMtg) list.get(i);
				 bNteNoticeMtgService.deleteBNteNoticeMtg(bean.getId());
			 }
			 for (int i = 0; i < mortList.size(); i++) {
				 BPbcAppliMtgInfo unitBean = (BPbcAppliMtgInfo) mortList.get(i);
				 BNteNoticeMtg bNteNoticeMtg = new BNteNoticeMtg();
                 BeanUtils.copyProperties(unitBean, bNteNoticeMtg);

                 bNteNoticeMtg.setAppno(appno);
                 bNteNoticeMtg.setPid(id);
                 bNteNoticeMtg.setMortgageName(unitBean.getMortgageName());
                 bNteNoticeMtg.setMortgageNo(unitBean.getMortgageNo());//押品编号
                 bNteNoticeMtg.setMortgageLevelOne(unitBean.getMortgageLevelOne());
                 bNteNoticeMtg.setMortgageLevelTwo(unitBean.getMortgageLevelTwo());
                 bNteNoticeMtg.setMortgageModel(unitBean.getMortgageModel());
                 bNteNoticeMtg.setQuantity(unitBean.getQuantity());
                 bNteNoticeMtg.setMortgageUnits(unitBean.getMortgageUnits());
                 bNteNoticeMtg.setTotPrice(unitBean.getTotPrice());
                 bNteNoticeMtg.setDocumentNo(unitBean.getDocumentNo());//相关凭证号
                 bNteNoticeMtg.setMemo(unitBean.getDescription());
                 //bNteNoticeMtg.setId(null);
                 bNteNoticeMtgService.addBNteNoticeMtg(bNteNoticeMtg);
			 }
		}
		/**
		 * 担保提货提货申请提交审批
		 */
		@Transactional
		@Override
		public void doWorkForSubmit(String appno) throws ScubeBizException {
			//三方保兑仓提货申请复核（城商行）
        	this.deliveryApproveCheck(appno);//审批时校验数据
	       //TODO 保证金冻结  暂无
	
	        //审批通过签发通知书
	        bNteNoticeBaseService.updaterNoticeStatus(appno,BNteConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);
	        //DODO通知书信息同步到FS系统  暂无
	        //业务申请表状态更新
	        BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
	        bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
	        bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
	        bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			
		}
		/**
		 * 担保提货提货申请回执审批通过
		 */
		@Transactional
		@Override
		public void doWorkForPass(String appno)throws ScubeBizException {
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			String debetNo=bPbcAppliBaseInfo.getExt1();//借据号
			//写入正式表 通知书状态更新
        	this.updateThreeDeliveryInfo(appno);
        	//借据解锁
    		bLanLnciBaseService.releaseDebtBaseInfo(debetNo);
	        //释放额度
			ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(appno);
			//TODO 释放额度
			bIcrInfoService.indirectCreditAppliCommonProcess(appno, null,BIcrConstant.CREDIT_TRADE_TYPE_RELEASE, abcpAppliImprestBuss.getAddBailAmt());


			//更新业务申请表状态
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			//WorkFlowService.getInstance().processTasks(commAppInfoVo);
			
		}

		/**
		 * 担保提货提货申请审批拒绝
		 */
		@Transactional
		@Override
		public void doWorkForReject(String appNo) throws ScubeBizException{
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
		 * DESCRIPTION:提货流程审批校验数据
		 * deliveryApproveCheck 方法
		 * @param appno
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		public void deliveryApproveCheck (String appno) throws ScubeBizException{
			BPbcAppliBaseInfo baseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			//TblAppliBussInfo bean = DAOUtils.getTblAppliBussInfoDAO().getAppliBussByAppno(appno);
			ABcpAppliImprestBuss bean = aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(appno);
			BigDecimal addBailAmount =bean.getAddBailAmt();
			AmountVO amountVO = new AmountVO();
			amountVO.setProductId(baseInfo.getSupplyChainPdId());
			amountVO.setDebetNo(baseInfo.getExt1());
			amountVO.setArrivedManageModel(ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE); 
			//AmountVO amountVO=new AmountVO(baseInfo.getSupplyChainPdId(),null,null,baseInfo.getExt1(),ScfBasConstant.ARRIVED_MANAGE_MODE_SINGLE);
			amountVO.setAddBailAmount(addBailAmount);
			//借据信息
			BLanLnciBase  bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(bean.getDebetNo());
			amountVO.setLnciType(bLanLnciBase.getLnciType());//ifsp流贷借据类型判断后续使用
			//TODO 可提货金额敞口金额
			//BigDecimal canDeliveryAmt= BigDecimal.ZERO;
			BigDecimal canDeliveryAmt=amountService.getDelivery(amountVO);//可提货金额
			//BigDecimal openAmount=amountService.getPant(amountVO);//敞口金额 ?
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
		 * updateThreeDeliveryInfo 方法
		 * @param appno
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		@Transactional
		public void updateThreeDeliveryInfo(String appno) throws ScubeBizException{
	    	//--数据准备
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			if(bPbcAppliBaseInfo==null){
				log.error("申请基本信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10002),ATcsErrorConstant.SCF_ADV_TCS_10002);
			}
			BLanLnciBase bLanLnciBase  = bLanLnciBaseService.findBLanLnciBaseByKey(bPbcAppliBaseInfo.getExt1()); 
			if(bLanLnciBase==null){
				log.error("申请基本信息:借据信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40008),ATcsErrorConstant.SCF_ADV_TCS_40008);
			}
			ABcpAppliImprestBuss abcpAppliImprestBuss = aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(appno);
			if(abcpAppliImprestBuss==null){
				log.error("申请基本信息:流水信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_30002),ATcsErrorConstant.SCF_ADV_TCS_30002);
			}
			//根据申请号和通知书类型查询通知书
			BNteNoticeBase bNteNoticeBaseQry  = new BNteNoticeBase();
			bNteNoticeBaseQry.setAppno(appno);
			bNteNoticeBaseQry.setNoticeType(BNteConstant.NOTICE_TYPE_80);
			List<BNteNoticeBase>  list= bNteNoticeBaseService.findBNteNoticeBaseByAppno(bNteNoticeBaseQry);
			BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
			if(list==null||list.size()==0){
				log.error("申请基本信息:提货通知书信息丢失");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40007),ATcsErrorConstant.SCF_ADV_TCS_40007);
			}else{
				 bNteNoticeBase = list.get(0);
			}

			//1、借据信息更新
			this.updateTblLnciBaseInfo(bLanLnciBase,abcpAppliImprestBuss);
	    	//2、流水信息写入
			this.saveDeliveryTblBussInfo(abcpAppliImprestBuss);
			//3、押品操作流水信息写入
			this.saveMortgageStockInfoDtl(bPbcAppliBaseInfo,abcpAppliImprestBuss);
	    	//4、通知书状态更新
			this.updateDeliveryNoticeStatusInfo(bNteNoticeBase);
			//5、存追加保证金流水
			this.savecustAccountInfo(appno);

			//6、更新购销合同的已提货金额   出账购销合同提货金额
			this.updateTradeDeliveryTotprice(appno,bLanLnciBase.getDebetNo());
	    }
	 
	  /**
	   * DESCRIPTION:提货借据更新(线下)
	   * updateTblLnciBaseInfo 方法
	   * @param bLanLnciBase
	   * @param abcpAppliImprestBuss
	   * @throws ScubeBizException
	   */
		@Transactional
		public void updateTblLnciBaseInfo(BLanLnciBase bLanLnciBase,ABcpAppliImprestBuss abcpAppliImprestBuss)throws ScubeBizException{
			bLanLnciBase.setAmountIn(bLanLnciBase.getAmountIn().subtract(abcpAppliImprestBuss.getCommonAmt()));// 剩余提货金额
			bLanLnciBase.setAmountOut(bLanLnciBase.getAmountOut().add(abcpAppliImprestBuss.getCommonAmt()));// 累计提货金额
	    	BigDecimal addBailAmount = bLanLnciBase.getAddBailAmount()==null?BigDecimal.ZERO:bLanLnciBase.getAddBailAmount();//借据保证金金额
	    	BigDecimal addBailAmount_v = abcpAppliImprestBuss.getAddBailAmt()==null?BigDecimal.ZERO:abcpAppliImprestBuss.getAddBailAmt();//本次追加保证金金额
	    	bLanLnciBase.setAddBailAmount(addBailAmount.add(addBailAmount_v));  //modify  借据表的追加保证金金额
	    	bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase);
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
		 * DESCRIPTION:提货押品操作流水信息写入(线下)
		 * saveMortgageStockInfoDtl 方法
		 * @param tblAppliBaseInfo
		 * @param tblAppliBussInfo
		 * @throws ScubeBizException
		 * @param commonQueryVO
		 * @return
		 */
		@Transactional
		public void saveMortgageStockInfoDtl(BPbcAppliBaseInfo bPbcAppliBaseInfo,ABcpAppliImprestBuss aBcpAppliImprestBuss) throws ScubeBizException{
	    	//1、数据准备
			
			UserInfo user = ContextHolder.getUserInfo(); 
			String tlrNo=user.getTlrNo();
			//String brCode=user.getBrNo();
	    	//获得已存在押品列表
			List<BPbcAppliMtgInfo> mortList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(bPbcAppliBaseInfo.getAppno());
	    	
	    	if(mortList==null){
	    		log.error("申请基本信息:提货押品列表丢失!");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40006),ATcsErrorConstant.SCF_ADV_TCS_40006);
	    	}
	    	BCrrLnCon  bCrrLnCon = bCrrLnConService.findBCrrLnConByAppId(bPbcAppliBaseInfo.getMastContno());
			if(bCrrLnCon==null){
				log.error("合同信息丢失!");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_10003),ATcsErrorConstant.SCF_ADV_TCS_10003);
			}
	    	//2、押品操作流水信息写入--差额回购提货：总括表TBL_MORTGAGE_STOR_DELI_INFO
				BPbcMtgStorDeli bPbcMtgStorDeli = null;
	    	//--校验是否记录已存在
	    	List<BPbcMtgStorDeli> storDeliInfoList = bPbcMtgStorDeliService.findBPbcMtgStorDeliByAppno(bPbcAppliBaseInfo.getAppno());
	    	if(storDeliInfoList!=null&&storDeliInfoList.size()>0){
	    		bPbcMtgStorDeli = (BPbcMtgStorDeli) storDeliInfoList.get(0);
	    		bPbcMtgStorDeli.setAppno(bPbcAppliBaseInfo.getAppno());
	    		bPbcMtgStorDeli.setOtherProtocolNo(bPbcAppliBaseInfo.getProtocolNo());
	    		bPbcMtgStorDeli.setTxdate(BSysConstant.WORKDATE);
	    		//bPbcMtgStorDeli.setTxtime(globalInfo.txnDate);
	    		bPbcMtgStorDeli.setTlrcd(tlrNo);
	    		bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_OUT);
	    		bPbcMtgStorDeli.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);
	    		bPbcMtgStorDeli.setCurcd(ScfBasConstant.RMB);
	    		bPbcMtgStorDeli.setTotPrice(aBcpAppliImprestBuss.getCommonAmt());//提货金额
	    		bPbcMtgStorDeli.setBussType(bCrrLnCon.getVidBusiTyp());
	    		bPbcMtgStorDeliService.updateBPbcMtgStorDeli(bPbcMtgStorDeli);

	    	}else{
	    		bPbcMtgStorDeli = new BPbcMtgStorDeli();
	    		bPbcMtgStorDeli.setAppno(bPbcAppliBaseInfo.getAppno());
	    		bPbcMtgStorDeli.setOtherProtocolNo(bPbcAppliBaseInfo.getProtocolNo());
	    		bPbcMtgStorDeli.setTxdate(BSysConstant.WORKDATE);
	    		//bPbcMtgStorDeli.setTxtime(globalInfo.txnDate);
	    		bPbcMtgStorDeli.setTlrcd(tlrNo);
	    		bPbcMtgStorDeli.setStorOrDeli(ScfBasConstant.STOR_OR_DELI_OUT);
	    		bPbcMtgStorDeli.setStorDeliBizType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);
	    		bPbcMtgStorDeli.setCurcd(ScfBasConstant.RMB);
	    		bPbcMtgStorDeli.setTotPrice(aBcpAppliImprestBuss.getCommonAmt());//提货金额
	    		bPbcMtgStorDeli.setId(null);
	    		bPbcMtgStorDeliService.addBPbcMtgStorDeli(bPbcMtgStorDeli);
	    	}

	    	//3、押品操作流水信息写入--差额回购提货：总括表TBL_MORTGAGE_STOCK_INFO
	    	//--查询已存在记录  删除全部 重新添加记录
	    	List<BPbcMtgStockDtl> appList = bPbcMtgStockDtlService.findBPbcMtgStockDtlByAppno(bPbcAppliBaseInfo.getAppno());
	    	for (int i = 0; i < appList.size(); i++) {
	    		BPbcMtgStockDtl bean = (BPbcMtgStockDtl) appList.get(i);
	    		bPbcMtgStockDtlService.deleteBPbcMtgStockDtl(bean.getId());
			}
	    	for (int i = 0; i < mortList.size(); i++) {
	    		BPbcAppliMtgInfo bPbcAppliMtgInfo = (BPbcAppliMtgInfo) mortList.get(i);
	    		BPbcMtgStockDtl bPbcMtgStockDtl = new BPbcMtgStockDtl();

	    		bPbcMtgStockDtl.setFirstAppno(bPbcAppliMtgInfo.getAppno());
	    		bPbcMtgStockDtl.setMortgageNo(bPbcAppliMtgInfo.getMortgageNo());
	    		bPbcMtgStockDtl.setExt1(bPbcAppliMtgInfo.getMortgageName());//押品名称
	    		bPbcMtgStockDtl.setMortgageLevelOne(bPbcAppliMtgInfo.getMortgageLevelOne());
	    		bPbcMtgStockDtl.setMortgageModel(bPbcAppliMtgInfo.getMortgageModel());
	    		bPbcMtgStockDtl.setQuantity(bPbcAppliMtgInfo.getQuantity());
	    		//提货数量本次
	    		bPbcMtgStockDtl.setBillQuantity(bPbcAppliMtgInfo.getBillQuantity());
	    	
	    		bPbcMtgStockDtl.setMortgageUnits(bPbcAppliMtgInfo.getMortgageUnits());
	    		bPbcMtgStockDtl.setTotPrice(bPbcAppliMtgInfo.getTotPrice());
	    		bPbcMtgStockDtl.setIncomeNo(bPbcAppliMtgInfo.getWarehouse());//相关凭证号
	    		bPbcMtgStockDtl.setExt2(bPbcAppliMtgInfo.getDescription());//Description
	    		bPbcMtgStockDtl.setType(ScfBasConstant.STOR_DELI_BIZ_TYPE_DELIVERY);//
	    		bPbcMtgStockDtl.setSupplyChainPdId(bCrrLnCon.getVidBusiTyp());
	    		bPbcMtgStockDtl.setExt3(bPbcAppliBaseInfo.getBusinessno());//借据号
	    		bPbcMtgStockDtlService.addBPbcMtgStockDtl(bPbcMtgStockDtl);
			}

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
		/**
		 * DESCRIPTION:提货申请保存冻结保证金列表
		 * savecustAccountInfo 方法
		 * @param appno
		 * @throws ScubeBizException
		 * @param ScubeBizException
		 * @return
		 */
		@Transactional
		@Override
		public void savecustAccountInfo(String appno) throws ScubeBizException{
	    	//1、获得冻结保证金列表
			List<BMrnAppliAcctInfo> accountList = bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appno);
	    	for (int i = 0; i < accountList.size(); i++) {
	    		BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo) accountList.get(i);
	    		BMrnAcctBussInfo accountBussInfo = new BMrnAcctBussInfo();
	    		BeanUtils.copyProperties(bean,accountBussInfo);
	    		bMrnAcctBussInfoService.addBMrnAcctBussInfo(accountBussInfo);
			}
		}
		/**
		 * 更新购销合同的已提货金额
		 * @param appno
		 * @throws ScubeBizException
		 */
		@Transactional
		@Override
		public void updateTradeDeliveryTotprice(String appno,String debtNo) throws ScubeBizException{
			List<BPbcAppliMtgInfo> list=bPbcAppliMtgInfoService.getTradeAppliTotPriceByAppno(appno);
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					BPbcAppliMtgInfo bPbcAppliMtgInfo = list.get(i) ;
					String tradeContno=bPbcAppliMtgInfo.getTradeContno();
					BigDecimal totprice=bPbcAppliMtgInfo.getTotPrice();
					totprice=totprice==null?BigDecimal.ZERO:totprice;
					//更新购销合同累计提货金额 -tradeContno
					BCntBuyInfo bCntBuyInfo =bCntBuyInfoService.findBCntBuyInfoByKey(tradeContno);
					BigDecimal oTotprice=bCntBuyInfo.getAccuDeliAmt()==null?BigDecimal.ZERO:bCntBuyInfo.getAccuDeliAmt();
					bCntBuyInfo.setAccuDeliAmt(totprice.add(oTotprice));
					bCntBuyInfoService.updateBCntBuyInfoObject(bCntBuyInfo);

					//更新出账下购销合同的累计提货金额 -tradeno,debtNo
	    			BLanLnciBuyBiz bLanLnciBuyBizQry = new BLanLnciBuyBiz();
	    			bLanLnciBuyBizQry.setTradeContno(tradeContno);
	    			bLanLnciBuyBizQry.setDebetNo(debtNo);
	    			List<BLanLnciBuyBiz> buyList =bLanLnciBuyBizService.findBLanLnciBuyBizByCondition(bLanLnciBuyBizQry);
	    			
					if(buyList!=null&&buyList.size()>0){
						BLanLnciBuyBiz bLanLnciBuyBiz=(BLanLnciBuyBiz)buyList.get(0);
		    			BigDecimal accuWithdrawAmt=bLanLnciBuyBiz.getAccuWithdrawAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getAccuWithdrawAmt();
		    			bLanLnciBuyBiz.setAccuWithdrawAmt(totprice.add(accuWithdrawAmt));
		    			bLanLnciBuyBizService.updateBLanLnciBuyBiz(bLanLnciBuyBiz);
	    			}else{
	    				log.error("购销合同："+tradeContno+"获取放款购销合同失败！");
	    				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40000),ATcsErrorConstant.SCF_ADV_TCS_40000);
	    			}



				}
			}
		}

		@Override
		public void doWorkForBack(String appNo) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * 保证金冻结借据信息查询
		 */
		@Override
		public Page getDebetList(int pageNo, int pageSize, DeliveryQryVO deliveryQryVO) throws ScubeBizException {
			// TODO Auto-generated method stub
			Page page = new Page(pageSize, pageNo, 0);
			if(ScfBasConstant.BAIL_ADD_OP_TYPE_CHATTLE_DELIVERY.equals(deliveryQryVO.getOperationType())
					||ScfBasConstant.BAIL_ADD_OP_TYPE_BILLNORMAL_DELIVERY.equals(deliveryQryVO.getOperationType())){
				//page=this.getLnciBaseInfoByBusinessNo(deliveryQryVO);
			}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_ASSURE_DELIVERY.equals(deliveryQryVO.getOperationType())){ //担保提货提货
				page = this.getLnciBaseInfoByDebetNo(deliveryQryVO);
			}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_BILLFIRST_DELIVERY.equals(deliveryQryVO.getOperationType())){ //先票后货提货
				page=this.getLnciBaseInfoByProtocolNo(deliveryQryVO);
			}else if(ScfBasConstant.BAIL_ADD_OP_TYPE_CARMORT_DELIVERY.equals(deliveryQryVO.getOperationType())||
					ScfBasConstant.BAIL_ADD_OP_TYPE_CARMORT_REPLACE.equals(deliveryQryVO.getOperationType()))
			{
				//page=this.getLnciBaseInfoByBusinessNo(deliveryQryVO);
			}
			return page;
		}
		
		/**
		 * DESCRIPTION:根据借据号查询借据信息
		 * getLnciBaseInfoByDebetNo 方法
		 * @param deliveryQryVO
		 * @return
		 * @throws ScubeBizException
		 * @return
		 */
		public Page getLnciBaseInfoByDebetNo(DeliveryQryVO deliveryQryVO) throws ScubeBizException{
			Page page = new Page();
			List<BLanLnciBase> list =bLanLnciBaseService.queryLnciBaseInfoByDebetNo(deliveryQryVO.getBusinessNo(), deliveryQryVO.getPageIndex(), deliveryQryVO.getPageSize());
			List<DebetListVO> resultList=new ArrayList<DebetListVO>();
			DebetListVO debetListVO = null;
			BLanLnciBase bLanLnciBase = null;
			BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					debetListVO = new DebetListVO();
					bLanLnciBase=(BLanLnciBase)list.get(i);
					BeanUtils.copyProperties(bLanLnciBase,debetListVO);
					debetListVO.setRiskAmt(amountService.getLnciRiskAmt(bLanLnciBase));  //敞口余额
					//应收欠息
					BigDecimal receivableInt=bLanLnciBase.getReceivableInt()==null?BigDecimal.ZERO:bLanLnciBase.getReceivableInt();
					BigDecimal receivablePunishInt=bLanLnciBase.getReceivablePunishInt()==null?BigDecimal.ZERO:bLanLnciBase.getReceivablePunishInt();
					//催收欠息
					BigDecimal collectionInt=bLanLnciBase.getCollectionInt()==null?BigDecimal.ZERO:bLanLnciBase.getCollectionInt();
					BigDecimal	collectionPunishInt=bLanLnciBase.getCollectionPunishInt()==null?BigDecimal.ZERO:bLanLnciBase.getCollectionPunishInt();
					BigDecimal compoundInt=bLanLnciBase.getCompoundInt()==null?BigDecimal.ZERO:bLanLnciBase.getCompoundInt();
					//表内欠息
					BigDecimal tabIntAmt=receivableInt.add(receivablePunishInt);
					//表外欠息
					BigDecimal tabOutAmt=collectionInt.add(collectionPunishInt).add(compoundInt);

					debetListVO.setReceivableInt(tabIntAmt.add(tabOutAmt));
					bPbcAppliBaseInfo= bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(bLanLnciBase.getAppno());
					if(null!=bPbcAppliBaseInfo){
						debetListVO.setIncomeAppno(bPbcAppliBaseInfo.getIncomeAppno()==null?"":bPbcAppliBaseInfo.getIncomeAppno());  //出账流水号
						debetListVO.setLoanAppno(bPbcAppliBaseInfo.getIncomeAppno()==null?"":bPbcAppliBaseInfo.getIncomeAppno());
					}
					resultList.add(debetListVO);
				}
			}
	
			page.setRecords(resultList);
			page.setTotal(resultList.size());
			return page;
		}

		/**
		 * 根据协议号查询借据信息
		 * @param deliveryQryVO
		 * @return
		 * @throws ScubeBizException
		 */
		public Page getLnciBaseInfoByProtocolNo(DeliveryQryVO deliveryQryVO) throws ScubeBizException
		{
			Page pageQueryResult = bLanLnciBaseService.getLnciBaseInfoByProtocolNo(deliveryQryVO.getProtocolNo(), deliveryQryVO.getPageIndex(), deliveryQryVO.getPageSize());
			List<com.huateng.scf.bas.lan.dao.model.BLanLnciBase> result = pageQueryResult.getRecords();
			List<DebetListVO> list=new ArrayList<DebetListVO>();
			if(result!=null&&result.size()>0)
			{
				for(int i=0;i<result.size();i++)
				{
					com.huateng.scf.bas.lan.dao.model.BLanLnciBase tblLnciBaseInfo = 
							(com.huateng.scf.bas.lan.dao.model.BLanLnciBase) result.get(i);
					DebetListVO debetListVO = new DebetListVO();
					BeanUtils.copyProperties(tblLnciBaseInfo, debetListVO);
					
					BLanLnciBase bLanLnciBase = new BLanLnciBase();
					BeanUtils.copyProperties(tblLnciBaseInfo, bLanLnciBase);
					debetListVO.setRiskAmt(amountService.getLnciRiskAmt(bLanLnciBase));  //敞口余额;
					
					//应收欠息
					BigDecimal receivableInt = tblLnciBaseInfo.getReceivableInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivableInt();
					BigDecimal receivablePunishInt = tblLnciBaseInfo.getReceivablePunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivablePunishInt();
					//催收欠息
					BigDecimal collectionInt = tblLnciBaseInfo.getCollectionInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionInt();
					BigDecimal	collectionPunishInt = tblLnciBaseInfo.getCollectionPunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionPunishInt();
					BigDecimal compoundInt = tblLnciBaseInfo.getCompoundInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCompoundInt();
					//表内欠息
					BigDecimal tabIntAmt = receivableInt.add(receivablePunishInt);
					//表外欠息
					BigDecimal tabOutAmt = collectionInt.add(collectionPunishInt).add(compoundInt);

					debetListVO.setReceivableInt(tabIntAmt.add(tabOutAmt));
					list.add(debetListVO);
				}
			}
			pageQueryResult.setRecords(list);
			return pageQueryResult;
		}
		
		/**
		 * 根据申请编号查询冻结保证金信息
		 */
		@Override
		public Page getAddBailAmountListByAppno(String appno,int pageNo, int pageSize) throws ScubeBizException {
			Page page = new Page(pageSize, pageNo, 0);
			List listAdd = aTcsThreeDeliveryDAO.getAddBailAmountListByAppno(appno, page);
			Iterator it=page.getRecords().iterator();
			List<DebetListVO> list=new ArrayList<DebetListVO>();
			BLanLnciBase bLanLnciBase = null;
			BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
			while(it.hasNext()){
				com.huateng.scf.bas.mrn.dao.model.DebetListVO VO = (com.huateng.scf.bas.mrn.dao.model.DebetListVO) it.next();
				DebetListVO debetListVO = new DebetListVO();
				BeanUtils.copyProperties(VO, debetListVO);
				bLanLnciBase=bLanLnciBaseService.findBLanLnciBaseByKey(debetListVO.getDebetNo());
				debetListVO.setRiskAmt(amountService.getLnciRiskAmt(bLanLnciBase));  //敞口余额;
				bPbcAppliBaseInfo =bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(bLanLnciBase.getAppno());
				if(null!=bPbcAppliBaseInfo){
					debetListVO.setIncomeAppno(bPbcAppliBaseInfo.getIncomeAppno());  //出账流水号
					debetListVO.setLoanAppno(bPbcAppliBaseInfo.getIncomeAppno());
				}
				list.add(debetListVO);
			}
			page.setRecords(list);
			page.setTotal(list.size());
			return page;
		}

		/**
		 * 保存冻结保证金申请信息
		 * @param vo
		 * @param debetList
		 * @throws ScubeBizException
		 */
		@Transactional
		@Override
		public void ThreeDeliveryAddBailAmountSave(AppendBailAmountVO vo, List<DebetListVO> debetList)
				throws ScubeBizException {
	    	//1、获得冻结保证金列表
	    	List<BMrnAppliAcctInfo> accountList = bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(vo.getAppno());
	    	//2、删除已存在押品列表
	    	for (int i = 0; i < accountList.size(); i++) {
	    		BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo) accountList.get(i);
	    		bMrnAppliAcctInfoService.delete(bean);
			}
	    	//3、添加冻结保证金列表
	    	for (Iterator iterator = debetList.iterator(); iterator.hasNext();) {
	    		DebetListVO debetListVO = (DebetListVO) iterator.next();
	    		BMrnAppliAcctInfo bean = new BMrnAppliAcctInfo();
				bean.setAppno(vo.getAppno());
				bean.setDebetNo(debetListVO.getDebetNo());
				bean.setBailAccountno(debetListVO.getBailAccount());
				bean.setBailAmount(debetListVO.getAddBailAmount());
				bean.setMastContno(debetListVO.getMastContno());
				bean.setCustcd(vo.getCustcd());
				bean.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);//保证金
				bean.setInitType(ScfBasConstant.INIT_TYPE_INIT);//追加
				bean.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);//已确认
				bean.setProtocolNo(vo.getProtocolNo());
				bean.setSlaveContno(vo.getSlaveContno());
				bean.setAmount(vo.getAddBailAmount());
				//bean.setId(null);
				bMrnAppliAcctInfoService.add(bean);
			}

			
		}

		/**
		 * 本次追加保证金总额后计算可提货金额
		 */
		@Override
		public BigDecimal getCanDeliveryAmt(ThreeDeliveryVO threeDeliveryVO) throws ScubeBizException {
			// TODO Auto-generated method stub
			BigDecimal canDeliveryAmt = BigDecimal.ZERO;
			String firstBailType = threeDeliveryVO.getFirstBailType();// 首笔保证金提货模式
			BigDecimal openAmount = threeDeliveryVO.getOpenAmount();// 敞口金额
			BigDecimal amountIn = threeDeliveryVO.getAmountIn();// 剩余可提货金额
			BigDecimal amountOut = threeDeliveryVO.getAmountOut();// 累计提货金额
			BigDecimal addBailAmount = threeDeliveryVO.getAddBailAmount();// 本次追加保证金
			//出账信息begin
			// BigDecimal lnciAmt=threeDeliveryVO.getLnciBal();//借据余额
			BigDecimal initCashAndBailAmt = threeDeliveryVO.getInitCashAndBailAmt();// 初始现金及保证金金额
			BigDecimal addCashAndBailAmt = threeDeliveryVO.getAddCashAndBailAmt();// 追加现金及保证金金额
			String lnciType = threeDeliveryVO.getLoanWay();// 出账方式
			BigDecimal bailAmount = threeDeliveryVO.getBailAmount();// 初始保证金
			//出账信息end
			BigDecimal initCashEqtAmt = threeDeliveryVO.getInitCashEqtAmt();// 初始现金等价物
			BigDecimal initBailCashAmt = bailAmount.add(initCashEqtAmt);// 初始保证金及现金等价物
			BigDecimal firstBailRatio = threeDeliveryVO.getFirstBailRatio();// 初始保证金比例(%)
			String ifspFlag = threeDeliveryVO.getIfspFlag();
			if (ifspFlag!=null&&ifspFlag.equals("true") && lnciType.equals(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL)) {
	
			} else {
				// 首笔保证金可全额提货：本次可提货金额 = 初始保证金及等价物金额 + 追加保证金及等价物金额 – 已累计提货金额
				if (ScfBasConstant.FIRST_BAIL_TYPE_ONE .equals(firstBailType)) {
					// canDeliveryAmt=lnciAmt-openAmount+addBailAmount-amountOut;
					canDeliveryAmt = initCashAndBailAmt.add(addCashAndBailAmt).add(addBailAmount).subtract(amountOut);
				}
				// 首笔保证金在后期按比例提货:本次可提货金额 = 追加保证金及等价物金额/(1-初始自有资金比例) – 已累计提货金额
				else if (ScfBasConstant.FIRST_BAIL_TYPE_TWO.equals(firstBailType)) {
					// canDeliveryAmt=parseFloat(((lnciAmt-openAmount-initBailCashAmt+addBailAmount)*100)/(100-firstBailRatio))-amountOut;
					canDeliveryAmt = ((addCashAndBailAmt.add(addBailAmount)).multiply(new BigDecimal(100))
							.divide((new BigDecimal(100).subtract(firstBailRatio)), 2, BigDecimal.ROUND_DOWN))
									.subtract(amountOut);
				}
				// 首笔保证金全额最后提货:
				else if (ScfBasConstant.FIRST_BAIL_TYPE_THREE.equals(firstBailType)) {
					// 敞口余额 = 0，本次可提货金额 = 剩余提货金额
					if (openAmount.equals(BigDecimal.ZERO)) {
						canDeliveryAmt = amountIn;
					}
					// 敞口余额 >0, 本次可提货金额 =追加保证金及等价物金额-已累计提货金额
					else if (openAmount.compareTo(BigDecimal.ZERO) > 0) {
						// canDeliveryAmt=lnciAmt-openAmount-initBailCashAmt+addBailAmount-amountOut;
						canDeliveryAmt = addCashAndBailAmt.add(addBailAmount).subtract(amountOut);
					}
				} else {
					log.error("获取首笔保证金提货模式失败!");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ATcsErrorConstant.SCF_ADV_TCS_40012),
							ATcsErrorConstant.SCF_ADV_TCS_40012);
				}
	
			}
			if(canDeliveryAmt.compareTo(BigDecimal.ZERO)<0){
				canDeliveryAmt=BigDecimal.ZERO;
			}
			return canDeliveryAmt;
	
		}
}
