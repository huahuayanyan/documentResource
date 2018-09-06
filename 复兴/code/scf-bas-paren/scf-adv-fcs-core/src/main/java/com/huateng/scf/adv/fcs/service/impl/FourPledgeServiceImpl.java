/**
 * 
 */
package com.huateng.scf.adv.fcs.service.impl;

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
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.adv.fcs.dao.IFourDAO;
import com.huateng.scf.adv.fcs.model.FourApplyVO;
import com.huateng.scf.adv.fcs.model.FourDeliveryQryVO;
import com.huateng.scf.adv.fcs.model.FourMortgageVO;
import com.huateng.scf.adv.fcs.service.IFourPledgeService;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotDealInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExt;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.nte.service.IBNteNoticeMtgService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.model.QualityApplyDO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年4月20日下午3:05:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月20日下午3:05:02              新增
 *
 *            </pre>
 */
@ScubeService
@Service("FourPledgeServiceImpl")
public class FourPledgeServiceImpl implements IFourPledgeService, DealInFlowService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "FourDAO")
	IFourDAO fourDAO;
	// 业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;
	// 抵质押合同
	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bCrrGntyConService;

	// 监管协议/担保提货协议/先票(款)后货协议信息
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bCntMprotBaseInfoService;

	// 多方协议参与者信息
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bCntMprotPartInfoService;
	// 预付款协议扩展信息
	@Resource(name = "BCntMprotDealInfoServiceImpl")
	IBCntMprotDealInfoService bCntMprotDealInfoService;

	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;

	// 押品信息
	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	// 产品信息
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;

	// 业务申请押品信息
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService;

	@Resource(name = "BNteNoticeMtgServiceImpl")
	IBNteNoticeMtgService bNteNoticeMtgService;

	@Resource(name = IScfWorkFlowService.BEAN_ID) // 供应链工作流
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bNteNoticeBaseService; // 通知书

	@Resource(name = "BCntMprotInfoServiceImpl")
	IBCntMprotInfoService bCntMprotInfoService; // 购销合同货物

	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService; // 押品种类信息

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService; // 流水号服务
	private static final String SLAVECONTNO = "slaveContno";
	private static final String NUM = "num";
	private static final String DELIVERYNO = "deliveryNo";
	private static final String PROTOCOLNO = "protocolNo";
	private static final String STARTDATE = "startDate";
	private static final String ENDDATE = "endDate";
	private static final String DEBETID = "debetId";
	private static final String ADDEDLIST = "addedList";

	/**
	 * 出质入库申请信息查询
	 */
	@Override
	public FourApplyVO queryFourPledgeBaseInfo(QualityApplyDO qualityApplyDO) throws ScubeBizException {
		// TODO Auto-generated method stub
		FourApplyVO fourPledgeVO = new FourApplyVO();
		if (qualityApplyDO != null) {
			String appno = qualityApplyDO.getAppNo();
			String conId = qualityApplyDO.getConId(); // 抵质押合同号
			if (StringUtil.isStrEmpty(appno)) {
				fourPledgeVO.setSlaveContno(conId);
			} else {
				BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
				fourPledgeVO.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
				fourPledgeVO.setMottgageTotAmount(bPbcAppliBaseInfo.getAmt());
				fourPledgeVO.setMottgageTotPrice(bPbcAppliBaseInfo.getAmt());

				fourPledgeVO.setAppno(appno);
			}
			// 抵质押合同信息
			BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(conId);
			if (bCrrGntyCon == null) {
				log.error("抵质押合同信息丢失！");
				throw new ScubeBizException("抵质押合同信息丢失！");
			}
			fourPledgeVO.setSlaveContcode(conId);// 抵质押合同纸质编号
			fourPledgeVO.setMonitorProtocolNo(bCrrGntyCon.getPrtclNo());// 质押监管协议
			fourPledgeVO.setRation(bCrrGntyCon.getRation());// 质押率
			fourPledgeVO.setCurcd(bCrrGntyCon.getGutCurcd());// 币种

			// 监管协议
			BCntMprotBaseInfo bCntMprotBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(bCrrGntyCon.getPrtclNo());
			// 保兑仓协议 核心厂商信息
			BCntMprotPartInfo bCntMprotPartInfo = bCntMprotPartInfoService.findCustByProtocolNoAndRole(bCntMprotBaseInfo.getOtherprotocolNo(),
					ScfBasConstant.PROTOCOL_PART_ROLE_CORE);

			// 监管公司名称
			BCntMprotPartInfo moniInfo = bCntMprotPartInfoService.findCustByProtocolNoAndRole(bCntMprotBaseInfo.getOtherprotocolNo(),
					ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			// 先票/款后货协议扩展表
			BCntMprotDealInfo mutiProtDealInfo = bCntMprotDealInfoService.findBCntMprotDealInfoByKey(bCntMprotBaseInfo.getOtherprotocolNo());
			fourPledgeVO.setCoreCustcd(bCntMprotPartInfo.getCustcd());
			fourPledgeVO.setCustcd(bCrrGntyCon.getGutId()); // 出质人
			fourPledgeVO.setBusinessno(bCntMprotBaseInfo.getOtherprotocolNo());// 四方协议号
			fourPledgeVO.setProtocolNo(bCntMprotBaseInfo.getOtherprotocolNo());// 四方协议号
			fourPledgeVO.setEndDate(bCntMprotBaseInfo.getEndDate());// 到期日期
			fourPledgeVO.setStartDate(bCntMprotBaseInfo.getStartDate());// 生效日期
			fourPledgeVO.setPledgeAmt(mutiProtDealInfo.getPledgeAmt() == null ? BigDecimal.ZERO : mutiProtDealInfo.getPledgeAmt());// 已到货总金额
			// 增加字段货押模式、业务品种、监管公司名称
			fourPledgeVO.setMoniType(bCntMprotBaseInfo.getMoniType()); // 货押模式
			fourPledgeVO.setProductId(bCntMprotBaseInfo.getProductId()); // 业务品种
			fourPledgeVO.setMoniCustcd(moniInfo.getCustcd()); // 监管公司名称

			// 卖方名称，出质人名称 ,监管公司名称 ,产品名称
			BCrmBaseInfo coreBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(bCntMprotPartInfo.getCustcd());
			if (coreBaseInfo != null) {
				fourPledgeVO.setCoreNm(coreBaseInfo.getCname());
			}
			BCrmBaseInfo bCrmBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(bCrrGntyCon.getGutId());
			if (bCrmBaseInfo != null) {
				fourPledgeVO.setCname(bCrmBaseInfo.getCname());
			}
			BCrmBaseInfo moniBaseInfo = bCrmBaseInfoService.findBCrmBaseInfoObjectByKey(moniInfo.getCustcd());
			if (moniBaseInfo != null) {
				fourPledgeVO.setMoniName(moniBaseInfo.getCname());
			}
			BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(bCntMprotBaseInfo.getProductId());
			if (bPrdInfo != null) {
				fourPledgeVO.setProductName(bPrdInfo.getProductName());
			}
			// 获取业务金额敞口
			// AmountVO amountVO = new
			// AmountVO(tblContSlaveInfo.getSupplyChainPdId(),fourPledgeVO.getSlaveContno());
			BigDecimal exposureAmount = null;// 敞口余额
			// exposureAmount = amountService.getPant(amountVO);
			// 统计先票/款后货协议项下的敞口余额
			exposureAmount = amountService.getLnciRiskAmtByProtocolNo(fourPledgeVO.getBusinessno(), BigDecimal.ZERO);
			fourPledgeVO.setExposureAmount(exposureAmount);// 敞口余额

			// 获取在库押品价值
			BigDecimal sendMortAmountSum = BigDecimal.ZERO;
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put(SLAVECONTNO, conId);
			sendMortAmountSum = bPbcMtgBaseInfoService.getMortgageSumPriceByParam(map);
			fourPledgeVO.setSendMortAmountSum(sendMortAmountSum);// 在库押品价值

		}
		return fourPledgeVO;
	}

	/**
	 * 先票/款后货到货出质入库发货通知已提交押品列表获取
	 */
	@Override
	public Page getFHPledgeDeliveryMortInfoList(int pageNo, int pageSize, FourDeliveryQryVO deliveryQryVO, List<FourMortgageVO> list)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != deliveryQryVO) {
			String slaveContno = deliveryQryVO.getSlaveContno();
			String protocolNo = "";
			String num = deliveryQryVO.getNum(); // 收款确认函编号
			String deliveryNo = deliveryQryVO.getDeliveryNo(); // 发货通知编号
			// 发货日
			String startDate = deliveryQryVO.getStartDate();
			String endDate = deliveryQryVO.getEndDate();
			String debetId = deliveryQryVO.getDebetId();// 借据号/承兑协议号
			// 抵质押合同信息
			BCrrGntyCon bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(slaveContno);
			if (bCrrGntyCon == null) {
				log.error("抵质押合同信息丢失！");
				throw new ScubeBizException("抵质押合同信息丢失！");
			}
			// 监管协议
			BCntMprotBaseInfo bCntMprotBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(bCrrGntyCon.getPrtclNo());
			if (bCntMprotBaseInfo == null) {
				log.error("监管协议信息丢失！");
				throw new ScubeBizException("监管协议信息丢失！");
			}
			protocolNo = bCntMprotBaseInfo.getProtocolNo();
			if (StringUtil.isStrNotEmpty(slaveContno)) {
				map.put(SLAVECONTNO, slaveContno);
			}
			if (StringUtil.isStrNotEmpty(protocolNo)) {
				map.put(PROTOCOLNO, protocolNo);
			}
			// 页面输入查询条件
			if (StringUtil.isStrNotEmpty(num)) {
				map.put(NUM, num);
			}
			if (StringUtil.isStrNotEmpty(deliveryNo)) {
				map.put(DELIVERYNO, deliveryNo);
			}
			if (StringUtil.isStrNotEmpty(startDate)) {
				map.put(STARTDATE, startDate);
			}
			if (StringUtil.isStrNotEmpty(endDate)) {
				map.put(ENDDATE, endDate);
			}
			if (StringUtil.isStrNotEmpty(debetId)) {
				map.put(DEBETID, debetId);
			}
		}
		// 列表已有的
		List<String> selectList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (FourMortgageVO info : list) {
				selectList.add(info.getMortgageNo());
			}
			map.put(ADDEDLIST, selectList);
		}

		fourDAO.getFHPledgeDeliveryMortInfoList(map, page);
		return page;
	}

	/**
	 * 本次申请入库押品列表
	 */
	@Override
	public Page queryNotifyMortgageList(int pageNo, int pageSize, FourDeliveryQryVO deliveryQryVO) throws ScubeBizException {
		// TODO Auto-generated method stub
		Page page = new Page(pageSize, pageNo, 0);

		if (null != deliveryQryVO) {
			String appno = deliveryQryVO.getAppno();
			// String mortgageNo = deliveryQryVO.getMortgageNo();
			// String deliveryNo = "";
			if (StringUtil.isStrNotEmpty(appno)) {
				AppliMortgageBaseQryVO appliMortgageBaseQryVO = new AppliMortgageBaseQryVO();
				appliMortgageBaseQryVO.setAppno_Q(appno);
				page = bPbcAppliMtgInfoService.getTblAppliMortgageBaseInfoByPara(appliMortgageBaseQryVO);
			}
		}
		return page;
	}

	/**
	 * 根据货物编号查询押品信息
	 */
	@Override
	public FourMortgageVO queryNotifyMortgageByMortgageNo(FourDeliveryQryVO deliveryQryVO) throws ScubeBizException {
		FourMortgageVO vo = new FourMortgageVO();
		if (null != deliveryQryVO) {
			String mortgageNo = deliveryQryVO.getMortgageNo();
			if (StringUtil.isStrNotEmpty(mortgageNo)) {
				Page page = bNteNoticeMtgService.getDeliveryNotifyMortList(null, mortgageNo, 1, 100);
				List list = page.getRecords();
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						// TblContBuyMortgageInfo buyMortgageInfo =
						// (TblContBuyMortgageInfo)list.get(i);
						BNteNoticeMtgExt buyMortgageInfo = (BNteNoticeMtgExt) list.get(i);
						BeanUtils.copyProperties(buyMortgageInfo, vo);
						// vo.setQuantity(BigDecimal.ZERO);//页面初始的时候默认数量为0
						BigDecimal price = buyMortgageInfo.getPrice() == null ? BigDecimal.ZERO : buyMortgageInfo.getPrice();
						vo.setTotPrice(vo.getQuantity().multiply(price));
						vo.setCurcd(ScfBasConstant.RMB);
						// TODO 需确定 BNteNoticeMtg 与 BPbcAppliMtgInfo JoinBatch
						// 值是否一致
						/*
						 * if(ScfBasConstant.JOIN_BATCH_YES.equals(vo.
						 * getJoinBatch())){
						 * vo.setJoinBatch(ScfBasConstant.JOIN_BATCH_YES);
						 * }else{ vo.setJoinBatch(ScfBasConstant.JOIN_BATCH_NO);
						 * }
						 */
						vo.setJoinBatch(vo.getJoinBatch());
						// 押品名称翻译
						String mortgageLevelOne = vo.getMortgageLevelOne();
						String mortgageLevelTwo = vo.getMortgageLevelTwo();
						BPbcMtgClass one = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelOne);
						vo.setMortgageLevelOneName(one.getMortgageName());
						BPbcMtgClass two = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelTwo);
						vo.setMortgageLevelTwoName(two.getMortgageName());
						// 设置监管模式以及购销合同信息；
						vo.setMoniType(ScfBasConstant.MONI_MODEL_STATIC);
						BCntMprotInfo buyMprotInfo = bCntMprotInfoService.findBCntMprotInfoByKey(vo.getMortgageNo());
						if (buyMprotInfo != null) {
							vo.setTradeContno(buyMprotInfo.getTradeContno());
						}
						// 设置发货通知编号以及将已有的Id置空
						vo.setDeliveryNo(vo.getDeliveryNo());
						vo.setQuantity(buyMortgageInfo.getBalQuantity());
						vo.setTotPrice(vo.getQuantity().multiply(vo.getPrice()));
						vo.setNid(vo.getId());
						vo.setId(null);
					}
				}
			}
		}
		return vo;
	}

	/**
	 * 先票款后货出质入库申请保存
	 */
	@Transactional
	@Override
	public String FHPledgeAppWriteSaveUpdate(FourApplyVO fourApplyVO, List<FourMortgageVO> list) throws ScubeBizException {
		// TODO Auto-generated method stub
		String businessnoType = WorkflowConstant.APPLI_TYPE_FOURHOUSEPLEDGEAPPLY;
		String workApplyType = WorkflowConstant.PROCNAME_FOURHOUSEPLEDGEAPPLY;
		fourApplyVO.setAmt(fourApplyVO.getMottgageTotAmount()); // 最低控货价值
		String appno = this.fHMortApplyWriteSaveUpdate(fourApplyVO, list, null, businessnoType, workApplyType);
		return appno;
	}

	/**
	 * 先票款后货出质入库申请提交
	 */
	@Transactional
	@Override
	public void FHPledgeAppWriteSubmitUpdate(FourApplyVO fourApplyVO, List<FourMortgageVO> list) throws ScubeBizException {
		// TODO Auto-generated method stub
		this.FHPledgeAppWriteSaveUpdate(fourApplyVO, list);
		// 流程流转
		String appno = fourApplyVO.getAppno();
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("工作流异常" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_10000), BComErrorConstant.SCF_BAS_COM_10000);
		}
	}

	/**
	 * 四方出质业务保存
	 */
	@Transactional
	public String fHMortApplyWriteSaveUpdate(FourApplyVO applyVO, List<FourMortgageVO> mortgageList, List<FourWareLoanVO> lncilist,
			String businessnoType, String workApplyType) throws ScubeBizException {
		String appno = applyVO.getAppno();
		if (StringUtil.isStrEmpty(appno)) {// 新增业务操作
			appno = bPbcAppliBaseInfoService.saveOrUpdateAppInfo(applyVO, businessnoType, workApplyType);
			applyVO.setAppno(appno);

			// 发起工作流
			String modelId = workApplyType;
			String custCd = applyVO.getCustcd();
			String custName = applyVO.getCname(); // 出质人名称
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
				log.error("工作流异常" + e.getMessage());
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_10000),
						BComErrorConstant.SCF_BAS_COM_10000);
			}

			// WorkFlowService.getInstance().commonStartFlow(appno,businessnoType,
			// workApplyType,paramMap);
		} else {// 修改业务操作
			appno = bPbcAppliBaseInfoService.saveOrUpdateAppInfo(applyVO, businessnoType, workApplyType);
			applyVO.setAppno(appno);
		}
		if (WorkflowConstant.APPLI_TYPE_FOURHOUSEPLEDGEAPPLY.equals(businessnoType)) {// 出质保存
			fhReceivedMortSelectSave(applyVO, mortgageList);
		} else if (WorkflowConstant.APPLI_TYPE_FOURHOUSEDELIVERYAPPLY.equals(businessnoType)) {// 提货保存
			// fhDeliverySave(appno, mortgageList);
			// fhDeliveryLnciInfoSave(applyVO, lncilist);
		} else if (WorkflowConstant.APPLI_TYPE_FOURHOUSEUPDELIVERYAPPLY.equals(businessnoType)) {// 向核心商提货保存
			// fhUpDeliverySave(appno, mortgageList);
		}
		return appno;
	}

	/**
	 * 四方保兑仓到货出质入库押品选择保存
	 * 
	 * @param appno
	 * @param newList
	 * @throws ScubeBizException
	 */
	@Transactional
	public void fhReceivedMortSelectSave(FourApplyVO applyVO, List<FourMortgageVO> newList) throws ScubeBizException {
		// 检验押品信息 先删除 重新添加
		String appno = applyVO.getAppno();
		Map<String, Object> map = bPbcAppliMtgInfoService.queryAppliMortgageByAppno(appno);
		BPbcAppliMtgInfo bean = null;
		if (newList != null && newList.size() > 0) {
			for (int i = 0; i < newList.size(); i++) {
				FourMortgageVO vo = (FourMortgageVO) newList.get(i);
				if (map.containsKey(vo.getMortgageNo())) {
					BPbcAppliMtgInfo bPbcAppliMtgInfo = (BPbcAppliMtgInfo) map.get(vo.getMortgageNo());
					bPbcAppliMtgInfo.setQuantity(vo.getQuantity());
					bPbcAppliMtgInfo.setTotPrice(vo.getTotPrice());
					bPbcAppliMtgInfo.setWarehouse(vo.getWarehouse());
					bPbcAppliMtgInfo.setConfirmPrice(vo.getConfirmPrice());
					bPbcAppliMtgInfo.setWarehouseAddress(vo.getWarehouseAddress());
					bPbcAppliMtgInfo.setMortgageLevelThree(vo.getMortgageLevelThree());
					bPbcAppliMtgInfo.setDescription(vo.getDescription());
					bPbcAppliMtgInfo.setFreightarea(vo.getFreightarea());
					bPbcAppliMtgInfo.setFreightlot(vo.getFreightlot());
					bPbcAppliMtgInfo.setMemo(vo.getMemo());
					bPbcAppliMtgInfo.setDeliveryNum(vo.getDeliveryNo()); // 发货编号
					bPbcAppliMtgInfoService.updateBPbcAppliMtgInfo(bPbcAppliMtgInfo);
					// SCFDAOUtils.getTblAppliMortgageBaseInfoDAO().getHibernateTemplate().merge(appliMortgageBaseInfo);
					map.remove(vo.getMortgageNo());
				} else {
					bean = new BPbcAppliMtgInfo();
					BeanUtils.copyProperties(vo, bean);
					bean.setCustcd(applyVO.getCustcd()); // 补充
					bean.setSlaveContno(applyVO.getSlaveContno());// 补充
					bean.setCurcd(vo.getCurcd());
					bean.setAppliMortBizType(ScfBasConstant.MORT_BIZ_TYPE_PLEDGE_IN);// 一般预入库
					bean.setMonitorProtocolNo(vo.getMonitorProtocolNo());// 监管协议
					bean.setOriginalTotPrice(bean.getPrice().multiply(bean.getQuantity()));
					bean.setAppno(appno);
					// 设置发货通知编号
					bean.setDeliveryNum(vo.getDeliveryNo());
					bPbcAppliMtgInfoService.addBPbcAppliMtgInfo(bean);
					// SCFDAOUtils.getTblAppliMortgageBaseInfoDAO().save(bean);
				}
			}
		}

		if (map != null && !map.isEmpty()) {
			Iterator iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				BPbcAppliMtgInfo tmbi = (BPbcAppliMtgInfo) map.get(key);
				bPbcAppliMtgInfoService.deleteBPbcAppliMtgInfo(tmbi.getId());
				// SCFDAOUtils.getTblAppliMortgageBaseInfoDAO().delete(tmbi);
			}
		}
	}

	/**
	 * 先票款后货出质入库核价信息保存
	 * 
	 * @param fourApplyVO
	 * @param list
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void FHPledgeAppPricingUpdate(FourApplyVO fourApplyVO, List<BPbcAppliMtgInfo> list) throws ScubeBizException {
		String appno = fourApplyVO.getAppno();
		bPbcAppliMtgInfoService.pledgeAppPricing(appno, list);
		// 更新申请金额
		bPbcAppliBaseInfoService.updatePledgeAppAmt(appno, fourApplyVO.getMottgageTotAmount());
	}

	/**
	 * 先票款后货出质入库核价信息流程提交
	 * 
	 * @param fourApplyVO
	 * @param list
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void FHPledgeAppPricingSubmitUpdate(FourApplyVO fourApplyVO, List<BPbcAppliMtgInfo> list) throws ScubeBizException {
		String appno = fourApplyVO.getAppno();
		// 生成出质清单确认通知书，价格确认，查询与出质通知书
		this.addPledgeMortNoticeByAppnoParam(appno);
		// 流程流转
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("工作流异常" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_10000), BComErrorConstant.SCF_BAS_COM_10000);
		}

	}

	/**
	 * 到货出质入库审批岗提交
	 */
	@Transactional
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		// 4、生成核库报告
		// fourService.copyAppChkStockToDest(appno);
		// 更新通知书状态
		bNteNoticeBaseService.updaterNoticeStatus(appNo, BNteConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);

	}

	/**
	 * 审批通过：出质入库回执确认
	 */
	@Transactional
	@Override
	public void doWorkForPass(String appNo) {
		// TODO Auto-generated method stub
		// 2、押品入库写入押品正式表&&流水表&&更新购销合同已出质金额
		bPbcMtgBaseInfoService.fhPledgeAppMortInfoDtlRecord(appNo);
		bNteNoticeBaseService.updaterNoticeStatus(appNo, BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		// 更新业务申请表状态
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForReject(java.
	 * lang.String)
	 */
	@Transactional
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForBack(java.
	 * lang.String)
	 */
	@Transactional
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

	/**
	 * 阶段性回购------生成出质清单确认通知书，价格确认，查询与出质通知书
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void addPledgeMortNoticeByAppnoParam(String appno) throws ScubeBizException {

		BPbcAppliBaseInfo appliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);

		if (appliBaseInfo == null) {
			log.error("主申请信息信息丢失，无法生成相关信息");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10004), BPbcErrorConstant.SCF_BAS_PBC_10004);
		}
		// 抵质押合同信息
		BCrrGntyCon bCrrGntyCon = null;
		if (!StringUtil.isEmpty(appliBaseInfo.getSlaveContno())) {
			bCrrGntyCon = bCrrGntyConService.findBCrrGntyConByConId(appliBaseInfo.getSlaveContno());
			if (bCrrGntyCon == null) {
				log.error("抵质押合同信息丢失，无法生成相关信息！");
				throw new ScubeBizException("抵质押合同信息丢失，无法生成相关信息");
			}
		}

		// 协议
		BCntMprotBaseInfo bCntMprotBaseInfo = null;
		if (!StringUtil.isEmpty(appliBaseInfo.getBusinessno())) {
			bCntMprotBaseInfo = bCntMprotBaseInfoService.findBCntMprotBaseInfoByKey(appliBaseInfo.getBusinessno());

			if (bCntMprotBaseInfo == null) {
				log.error("阶段性回购协议信息丢失，无法生成相关信息！");
				throw new ScubeBizException("阶段性回购协议信息丢失，无法生成相关信息");
			}

		}
		String noticeId = "";
		// 通知书中的货物信息表
		FourDeliveryQryVO fourDeliveryQryVO = new FourDeliveryQryVO();
		fourDeliveryQryVO.setAppno(appno);
		List<BPbcAppliMtgInfo> appliMortgageList = bPbcAppliMtgInfoService.getQualityNoticeMortList(fourDeliveryQryVO);

		// //出质入库生成出质清单确认通知书
		// noticeId =
		// NoticeService.getInstance().addNoticeBaseInfo(appliBaseInfo,
		// tblContSlaveInfo,
		// tblMutiProtBaseInfo,SCFConstants.MORTGAGE_CHANGE_TYPE_ADD,
		// NoticeConstants.NOTICE_TYPE_82);
		// NoticeService.getInstance().addPledgeNoticeMortInfo(noticeId,bussAppno,
		// appliMortgageList, SCFConstants.MORTGAGE_TYPE_IN);
		// 生成价格确认通知书
		// noticeId =
		// NoticeService.getInstance().addNoticeBaseInfo(appliBaseInfo,
		// tblContSlaveInfo,
		// tblMutiProtBaseInfo,SCFConstants.MORTGAGE_CHANGE_TYPE_ASJUST,
		// NoticeConstants.NOTICE_TYPE_92);
		// 修改价格调整通知书类型常量为NOTICE_TYPE_0 changhao.huang 2013-8-22
		// 0-押品价格确定调整通知书
		String noticeNo1 = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_0_NOTICE_NO);
		noticeId = bNteNoticeBaseService.addNoticeBaseInfo(appliBaseInfo, bCrrGntyCon, bCntMprotBaseInfo, ScfBasConstant.MORTGAGE_CHANGE_TYPE_ASJUST,
				BNteConstant.NOTICE_TYPE_0, noticeNo1);
		bNteNoticeMtgService.addConfirmPriceNoticeMortInfo(noticeId, appno, appliMortgageList, ScfBasConstant.MORTGAGE_TYPE_IN);
		// 查询及出质通知书
		// 81-四方保兑仓出质通知书（线下）
		String noticeNo81 = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_81_NOTICE_NO);
		noticeId = bNteNoticeBaseService.addNoticeBaseInfo(appliBaseInfo, bCrrGntyCon, bCntMprotBaseInfo, ScfBasConstant.MORTGAGE_CHANGE_TYPE_ADD,
				BNteConstant.NOTICE_TYPE_81, noticeNo81);
		bNteNoticeMtgService.addPledgeNoticeMortInfo(noticeId, appno, appliMortgageList, ScfBasConstant.MORTGAGE_TYPE_IN);

	}

}
