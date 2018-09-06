package com.huateng.scf.sto.pbc.service.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.bcp.dao.ISBcpAppliLowerPriceDAO;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CommonQryVO;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.mrn.service.IMaxmumBailTransferQueryService;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeMtgDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliMtgInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample.Criteria;
import com.huateng.scf.bas.pbc.dao.vo.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.model.AmountVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.model.MortgageEnterDO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.sto.pcb.model.BPbcMtgBaseInfoVO;
import com.huateng.scf.sto.pcb.model.MortgageAdjustPriceVO;
import com.huateng.scf.sto.pcb.model.PriceAdjustVO;
import com.huateng.scf.sto.pcb.service.IAdjustPriceService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("AdjustPriceServiceImpl")
public class AdjustPriceServiceImpl implements IAdjustPriceService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final String CNAME = "cname";
	private static final String MONICNAME = "moniCname";
	private static final String SLAVECONTCODE = "slaveContcode";
	private static final String MORTGAGELEVELONENAME = "mortgageLevelOneName";
	private static final String MORTGAGELEVELTWONAME = "mortgageLevelTwoName";
	private static final String MORTGAGENAME = "mortgageName";
	private static final String SUPPPRODUCTNAME = "suppProductName";
	private static final String MONITORTYPE = "monitorType";
	private static final String ISLOCKED = "isLocked";
	private static final String STOCKSTATUS = "stockStatus";
	private static final String GUTID = "gutId";
	private static final String SLAVECONTNO = "slaveContno";

	@Resource(name = "MaxmumBailTransferQueryServiceImpl")
	IMaxmumBailTransferQueryService iMaxmumBailTransferQueryService;

	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO iBCrrGntyConDAO;

	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO iBCntMprotBaseInfoDAO;

	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO iBCntMprotPartInfoDAO;

	@Resource(name = "amountService")
	private IAmountService amountService;

	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO iBPbcAppliBaseInfoDAO;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Resource(name = IScfWorkFlowService.BEAN_ID) // 供应链工作流
	IScfWorkFlowService scfWorkFlowService;

	// 流程发起
	@Resource(name = "processService")
	IProcessService iProcessService;

	@Resource(name = "BPbcAppliMtgInfoDAO")
	IBPbcAppliMtgInfoDAO iBPbcAppliMtgInfoDAO;

	@Resource(name = "ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extbpbcmtgbaseinfodao;

	@Resource(name = "BNteNoticeMtgDAO")
	IBNteNoticeMtgDAO iBNteNoticeMtgDAO;

	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO iBNteNoticeBaseDAO;

	@Resource(name = "SBcpAppliLowerPriceDAO")
	ISBcpAppliLowerPriceDAO iSBcpAppliLowerPriceDAO;
	
	@Resource(name = "ExtBPbcMtgBaseInfoDAO")
	ExtIBPbcMtgBaseInfoDAO extIBPbcMtgBaseInfoDAO;
	
	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService; // 押品种类信息
	
	// 业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;
	
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bntenoticebaseservice;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	@Override
	public Page SlaveContractGetter(int pageNo, int pageSize, HashMap<String, String> value) throws ScubeBizException {
		if (value == null || value.get("custcd") == null || value.get("custcd").equals(""))
			throw new ScubeBizException("请先选择出质人");

		return iMaxmumBailTransferQueryService.SlaveContractGetter(pageNo, pageSize, value);
	}

	@Override
	public PriceAdjustVO getQueryResultWhenAppnoIsEmpty(CommonQryVO commonQryVO) throws ScubeBizException {
		String slaveContno = "";
		if (commonQryVO == null || commonQryVO.getSlaveContno() == null)
			throw new ScubeBizException("质押合同号丢失！");
		else
			slaveContno = commonQryVO.getSlaveContno();

		BCrrGntyCon bCrrGntyCon = iBCrrGntyConDAO.selectByPrimaryKey(slaveContno);
		BCntMprotBaseInfo bCntMprotBaseInfo = iBCntMprotBaseInfoDAO.selectByPrimaryKey(bCrrGntyCon.getPrtclNo());

		BCntMprotPartInfoExample example = new BCntMprotPartInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria criteria = example.createCriteria();
		if (bCrrGntyCon != null && bCrrGntyCon.getPrtclNo() != null) {
			criteria.andProtocolNoEqualTo(bCrrGntyCon.getPrtclNo());
		}
		BCntMprotPartInfo bCntMprotPartInfo = new BCntMprotPartInfo();
		List<BCntMprotPartInfo> bCntMprotPartInfoList = iBCntMprotPartInfoDAO.selectByExample(example);
		if (bCntMprotPartInfoList != null && bCntMprotPartInfoList.size() > 0)
			bCntMprotPartInfo = bCntMprotPartInfoList.get(0);

		PriceAdjustVO applyVO = new PriceAdjustVO();
		applyVO.setPrtclBrNm(bCntMprotPartInfo.getCname());
		applyVO.setAppno(null);
		applyVO.setProtocolCode(bCntMprotBaseInfo.getProtocolCode());
		applyVO.setPrtclNo(bCntMprotBaseInfo.getProtocolNo());
		applyVO.setConId(bCrrGntyCon.getConId());
		applyVO.setGutId(bCrrGntyCon.getGutId());
		applyVO.setGutNm(bCrrGntyCon.getGutNm());
		applyVO.setPledgeMode(ScfBasConstant.PLEDGE_MODE_SINGLE);
		applyVO.setMoniMd(bCntMprotBaseInfo.getMoniType());
		applyVO.setLowPriceNew(bCrrGntyCon.getLowPriceNew());
		applyVO.setRation(bCrrGntyCon.getRation());
		applyVO.setStratDate(new Date());
		// 计算敞口
		AmountVO amountVo = new AmountVO();
		amountVo.setProductId(bCrrGntyCon.getVidPrdId());
		amountVo.setSlaveContno(bCrrGntyCon.getConId());
		BigDecimal pant = amountService.getPant(amountVo);

		// 增加先票/款后货计算敞口
		if (!StringUtil.isEmpty(commonQryVO.getProtocolNo())) {

			com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample example1 = new com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample();
			com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample.Criteria criteria1 = example1.createCriteria();
			if (bCrrGntyCon != null && bCrrGntyCon.getPrtclNo() != null) {
				criteria1.andProtocolCodeEqualTo(bCrrGntyCon.getPrtclNo());
			}

			List<BCntMprotBaseInfo> baseInfoList = iBCntMprotBaseInfoDAO.selectByExample(example1);

			if (baseInfoList != null && baseInfoList.size() > 0) {
				if (!StringUtil.isEmpty(baseInfoList.get(0).getOtherprotocolNo())) {
					pant = amountService.getLnciRiskAmtByProtocolNo(baseInfoList.get(0).getOtherprotocolNo(),
							BigDecimal.ZERO);
				}
			}
		}
		applyVO.setBailAmount(amountVo.getAccountAmount());// 保证金及现金等价物总价值
		applyVO.setOpenAmount(pant);// 敞口
		applyVO.setLowPriceNew(bCrrGntyCon.getLowPriceNew());// 最低控货价值

		// 根据流程appno查询
		if (commonQryVO != null && commonQryVO.getAppno() != null) {
			BPbcAppliMtgInfoExample example1 = new BPbcAppliMtgInfoExample();
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample.Criteria c = example1.createCriteria();
			c.andAppnoEqualTo(commonQryVO.getAppno());
			List<BPbcAppliMtgInfo> bPbcAppliMtgInfoList = iBPbcAppliMtgInfoDAO.selectByExample(example1);
			if (bPbcAppliMtgInfoList != null && bPbcAppliMtgInfoList.size() > 0) {
				BigDecimal sumOriginalTotPrice = BigDecimal.ZERO;// 调整前押品总价值
				BigDecimal sumTotPrice = BigDecimal.ZERO;// 调整后押品总价值
				for (BPbcAppliMtgInfo bPbcAppliMtgInfo : bPbcAppliMtgInfoList) {
					sumOriginalTotPrice = sumOriginalTotPrice.add(bPbcAppliMtgInfo.getOriginalTotPrice() == null
							? BigDecimal.ZERO : bPbcAppliMtgInfo.getOriginalTotPrice());
					sumTotPrice = sumTotPrice.add(
							bPbcAppliMtgInfo.getTotPrice() == null ? BigDecimal.ZERO : bPbcAppliMtgInfo.getTotPrice());
				}
				applyVO.setOriginalTotPrice(sumOriginalTotPrice);
				applyVO.setTotPrice(sumTotPrice);
			}
			BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(commonQryVO.getAppno());
			applyVO.setMemo(bPbcAppliBaseInfo.getMemo());
		}

		return applyVO;
	}

	@Override
	public List getUnselectedMortgageBaseInfoBySlaveContno(String slaveContno, String locked) throws ScubeBizException {

		return null;
	}

	@Override
	public Page getMortListBySlaveContno(int pageNo, int pageSize, String slaveContno) throws ScubeBizException {

		// 查询开始
		BPbcMtgBaseInfoExample example = new BPbcMtgBaseInfoExample();
		Criteria cri = example.createCriteria();
		cri.andSlaveContnoEqualTo(slaveContno);
		example.setOrderByClause("MORTGAGE_NO DESC");

		int total = ibPbcMtgBaseInfoDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		List<BPbcMtgBaseInfo> list = ibPbcMtgBaseInfoDAO.selectByPage(example, p);
		List<com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO> result = 
				new ArrayList<com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO>();
		if(list!=null&&list.size()>0)
		{
			for(BPbcMtgBaseInfo baseInfo:list)
			{
				com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO baseInfoVO = new com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO();
				BeanUtils.copyProperties(baseInfo, baseInfoVO);
				// 押品名称翻译
				String mortgageLevelOne = baseInfo.getMortgageLevelOne();
				String mortgageLevelTwo = baseInfo.getMortgageLevelTwo();
				if (StringUtil.isStrNotEmpty(mortgageLevelOne)) {
					BPbcMtgClass one = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelOne);
					baseInfoVO.setMortgageLevelOneName(one.getMortgageName());
				}
				if (StringUtil.isStrNotEmpty(mortgageLevelTwo)) {
					BPbcMtgClass two = bPbcMtgClassService.translateMortgageNameByCode(mortgageLevelTwo);
					baseInfoVO.setMortgageLevelTwoName(two.getMortgageName());
				}
				result.add(baseInfoVO);
			}
		}
		p.setRecords(result);

		return p;
	}

	@Override
	@Transactional
	public String singlePriceAdjustWriteSaveUpdater(MortgageAdjustPriceVO applyVO, List<BPbcMtgBaseInfoVO> list)
			throws ScubeBizException {
		if (applyVO == null)
			throw new ScubeBizException("接受数据为空");

		String appno = applyVO.getAppno();
		String productId = applyVO.getProductId();// 获取业务品种
		String bussnissType = "";
		String workApplyType = "";

		if (productId.equals(ScfBasConstant.PRODUCT_TYPE_PLSY)) {// 现货静态
			bussnissType = WorkflowConstant.APPLI_TYPE_CHANGE_PRICE_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_ADJUSTPRICEAPPLY;
		} else if (productId.equals(ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL)) {// 普通非标仓单
			bussnissType = WorkflowConstant.APPLI_TYPE_CHANGE_PRICE_APPLY_BILL;
			workApplyType = WorkflowConstant.PROCNAME_PRICEADJUSTAPPLYBILL;
		} else if (productId.equals(ScfBasConstant.PRODUCT_TYPE_XPHH)) {// 先票款后货
			bussnissType = WorkflowConstant.APPLI_TYPE_CHANGE_PRICE_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_PRICEADJUSTAPPLYXPHH;
		}else if (productId.equals(ScfBasConstant.PRODUCT_TYPE_PLDY)) {// 现货动态
			bussnissType = WorkflowConstant.APPLI_TYPE_CHANGE_PRICE_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_PRICEADJUSTAPPLYXHDT;
		}


		// 检查押品是否锁定
		String msg = new String("押品编号为");
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			BPbcMtgBaseInfoVO vo = (BPbcMtgBaseInfoVO) list.get(i);
			BPbcMtgBaseInfo bPbcMtgBaseInfo = ibPbcMtgBaseInfoDAO.selectByPrimaryKey(vo.getMortgageNo());
			if (ScfBasConstant.LOCKED.equals(bPbcMtgBaseInfo.getIsLocked())
					&& !bPbcMtgBaseInfo.getLockAppno().equals(appno)) {
				msg = msg + vo.getMortgageNo() + ",";
				flag = true;
			}
		}
		if (msg.endsWith(",")) {
			msg = msg.substring(0, msg.length() - 1);
		}
		if (flag)
			throw new ScubeBizException(msg + "的押品已被锁定,不可调价");

		// 如果是第一次保存
		if (appno == null || StringUtil.isEmpty(appno.trim())) {
			// 保存申请信息

			appno = this.saveSingleApplyBaseInfo(applyVO, bussnissType, workApplyType);
			applyVO.setAppno(appno);
		} else {
			this.updateSingleApplyBaseInfo(applyVO);
		}

		// 3：保存申请基本信息
		this.savePriceAdjustBaseInfo(applyVO, list);

		return appno;
	}

	/**
	 * 保存单笔质物价格调整申请基本信息
	 * 
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws CommonException
	 */
	@Transactional
	public String saveSingleApplyBaseInfo(MortgageAdjustPriceVO applyVO, String businessnoType, String workApplyType)
			throws ScubeBizException {

		BCrrGntyCon bCrrGntyCon = iBCrrGntyConDAO.selectByPrimaryKey(applyVO.getSlaveContno());

		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.VALUE_INDEX_APP_NO);// 6位序列号

		bPbcAppliBaseInfo.setAppno(appno);
		bPbcAppliBaseInfo.setPledgeMode(ScfBasConstant.PLEDGE_MODE_SINGLE); // 发起方式
		bPbcAppliBaseInfo.setCustcd(applyVO.getCustcd()); // 客户号
		bPbcAppliBaseInfo.setCurcd(bCrrGntyCon.getGutCurcd()); // 币种
		bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);// 流程名称
		bPbcAppliBaseInfo.setAppliType(businessnoType); // 申请类型
		bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_PROTOCOLNO);// 从合同号类型
		bPbcAppliBaseInfo.setProtocolNo(bCrrGntyCon.getPrtclNo()); // 质押监管协议号
		bPbcAppliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		bPbcAppliBaseInfo.setSlaveContno(bCrrGntyCon.getConId());
		bPbcAppliBaseInfo.setSupplyChainPdId(bCrrGntyCon.getVidPrdId());
		UserInfo user = ContextHolder.getUserInfo(); // 获取当前用户信息
		bPbcAppliBaseInfo.setAppBrcode(user.getBrNo()); // 登记机构
		bPbcAppliBaseInfo.setAppTlrcd(user.getTlrNo()); // 登记人
		bPbcAppliBaseInfo.setStartTime(new Date());
		bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date()));
		bPbcAppliBaseInfo.setStartBrcode(user.getBrNo());
		bPbcAppliBaseInfo.setStartTlrcd(user.getTlrNo());
		bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);
		bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);
		bPbcAppliBaseInfo.setBusinessno(appno);
		bPbcAppliBaseInfo.setMemo(applyVO.getMemo());
		iBPbcAppliBaseInfoDAO.insert(bPbcAppliBaseInfo);

		String custCd = applyVO.getCustcd();
		String custName = applyVO.getGutNm();

		// 发起工作流
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("modelId", workApplyType);
		paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
		paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
		paramMap.put(WorkflowConstant.CUST_CD, custCd);
		paramMap.put(WorkflowConstant.CUST_NAME, custName);
		try {
			scfWorkFlowService.startWorkFlow(appno, workApplyType, workApplyType, paramMap);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appno;
	}

	/**
	 * 更新单笔质物价格调整申请基本信息
	 * 
	 * @param applyVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws CommonException
	 */
	@Transactional
	public void updateSingleApplyBaseInfo(MortgageAdjustPriceVO applyVO) throws ScubeBizException {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(applyVO.getAppno());
		bPbcAppliBaseInfo.setMemo(applyVO.getMemo());
		iBPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
	}

	/**
	 * 
	 * @param applyVO
	 * @param list
	 * @throws CommonException
	 */
	@Transactional
	public void savePriceAdjustBaseInfo(MortgageAdjustPriceVO applyVO, List list) throws ScubeBizException {
		log.info("------录入时保存申请信息 PriceAdjustService->savePriceAdjustBaseInfo begin------");
		if (applyVO == null || StringUtil.isEmpty(applyVO.getAppno())) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST),
					RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
		// 保存押品列表
		this.saveSinglePriceAdjustApplyBaseInfo(applyVO, list);// 保存基本信息
	}

	/**
	 * 保存质物价格调整基本信息
	 * 
	 * @param mdApplyVO
	 * @throws CommonException
	 */
	@Transactional
	public void saveSinglePriceAdjustApplyBaseInfo(MortgageAdjustPriceVO mdApplyVO, List insertList)
			throws ScubeBizException {

		if (mdApplyVO == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 1、删除以前的数据
		BPbcAppliMtgInfoExample bPbcAppliMtgInfoExample = new BPbcAppliMtgInfoExample();
		bPbcAppliMtgInfoExample.createCriteria().andAppnoEqualTo(mdApplyVO.getAppno());
		iBPbcAppliMtgInfoDAO.deleteByExample(bPbcAppliMtgInfoExample);
		// 2、保存押品信息
		BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO = null;
		BPbcAppliMtgInfo bPbcAppliMtgInfo = new BPbcAppliMtgInfo();
		for (int i = 0; i < insertList.size(); i++) {
			bPbcMtgBaseInfoVO = (BPbcMtgBaseInfoVO) insertList.get(i);
			BeanUtils.copyProperties(bPbcMtgBaseInfoVO, bPbcAppliMtgInfo);
			bPbcAppliMtgInfo.setOldConfirmPrice(bPbcMtgBaseInfoVO.getConfirmPrice());// 调整前单价
			bPbcAppliMtgInfo.setOriginalTotPrice(
					bPbcMtgBaseInfoVO.getConfirmPrice().multiply(bPbcMtgBaseInfoVO.getQuantity()));// 调整前总价值
			bPbcAppliMtgInfo.setConfirmPrice(bPbcMtgBaseInfoVO.getAfterConfirmPrice());// 调整后单价
			bPbcAppliMtgInfo.setTotPrice(bPbcMtgBaseInfoVO.getAfterConfirmPrice().multiply(bPbcMtgBaseInfoVO.getQuantity()));// 调整后总价值
			bPbcAppliMtgInfo.setAppno(mdApplyVO.getAppno());
			bPbcAppliMtgInfo.setId(UUIDGeneratorUtil.generate());
			bPbcAppliMtgInfo.setReason(bPbcMtgBaseInfoVO.getReason());
			iBPbcAppliMtgInfoDAO.insert(bPbcAppliMtgInfo);
			// 押品上锁
			this.checkMortLockInfo(mdApplyVO.getAppno(), bPbcAppliMtgInfo.getMortgageNo());
		}
	}

	/**
	 * 押品上锁
	 * 
	 * @param appno
	 * @param mortgageNo
	 * @throws CommonException
	 */
	@Transactional
	public void checkMortLockInfo(String appno, String mortgageNo) throws ScubeBizException {
		BPbcMtgBaseInfo bPbcMtgBaseInfo = ibPbcMtgBaseInfoDAO.selectByPrimaryKey(mortgageNo);
		if (bPbcMtgBaseInfo != null) {
			String isLock = bPbcMtgBaseInfo.getIsLocked();
			String lockAppno = bPbcMtgBaseInfo.getLockAppno();
			if (!StringUtil.isEmpty(isLock) && ScfBasConstant.LOCKED.equalsIgnoreCase(isLock)
					&& !StringUtil.isEmpty(lockAppno) && !appno.equalsIgnoreCase(lockAppno)) {
				throw new ScubeBizException("编号为【" + mortgageNo + "】的押品正在被申请编号为【" + lockAppno + "】的业务操作，暂不能在本流程中操作");
			}
			bPbcMtgBaseInfo.setIsLocked(ScfBasConstant.LOCKED);
			bPbcMtgBaseInfo.setLockAppno(appno);
			ibPbcMtgBaseInfoDAO.updateByPrimaryKeySelective(bPbcMtgBaseInfo);
		}
	}

	@Override
	@Transactional
	public String singlePriceAdjustSubmit(MortgageAdjustPriceVO applyVO, List<BPbcMtgBaseInfoVO> list)
			throws ScubeBizException {
		if (applyVO == null || list == null)
			throw new ScubeBizException("数据校验不通过");
		// 1、保存页面信息
		String appno = this.singlePriceAdjustWriteSaveUpdater(applyVO, list);
		// 2、生成或者修改通知书
		this.addOrUpdateNotice(appno);

		// 3、流程跳转
	/*	scfWorkFlowService.takeTaskAndRelated(appno);*/
		
		// 流程流转
		 com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("工作流异常" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_10000), BComErrorConstant.SCF_BAS_COM_10000);
		}
		return null;
	}

	@Override
	public Page getMortListByAppno(int pageNo, int pageSize, String appno) throws ScubeBizException {
		if (appno != null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("appno", appno);

			int total = extbpbcmtgbaseinfodao.countTblAppliMortgageBaseInfoByPara(map);
			Page pageQueryResult = new Page(pageSize, pageNo, total);
			List<BPbcAppliMtgInfoVO> list = extbpbcmtgbaseinfodao.getTblAppliMortgageBaseInfoByPara(map,
					pageQueryResult);
			for (BPbcAppliMtgInfoVO bPbcAppliMtgInfoVO : list) {
				bPbcAppliMtgInfoVO.setQuantity(
			bPbcAppliMtgInfoVO.getQuantity() == null ? BigDecimal.ZERO : bPbcAppliMtgInfoVO.getQuantity());// 数量赋值
			bPbcAppliMtgInfoVO.setTotChangePrice(
			bPbcAppliMtgInfoVO.getTotPrice() == null ? BigDecimal.ZERO : bPbcAppliMtgInfoVO.getTotPrice());// 调整后总价
			bPbcAppliMtgInfoVO.setTotPrice(bPbcAppliMtgInfoVO.getOriginalTotPrice() == null ? BigDecimal.ZERO
					: bPbcAppliMtgInfoVO.getOriginalTotPrice());// 调整前总价值
			bPbcAppliMtgInfoVO.setAfterConfirmPrice(bPbcAppliMtgInfoVO.getConfirmPrice());
			bPbcAppliMtgInfoVO.setConfirmPrice(bPbcAppliMtgInfoVO.getOldConfirmPrice());
			}
			return pageQueryResult;
		}
		return null;
	}

	/**
	 * 根据业务号决定新增或者修改通知书
	 * 
	 * @param applyVO
	 */
	@Transactional
	public void addOrUpdateNotice(String appno) {
		if (appno == null)
			throw new ScubeBizException("业务申请号不能为空");
		BNteNoticeMtgExample example = new BNteNoticeMtgExample();
		com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);

		List<BNteNoticeMtg> list = iBNteNoticeMtgDAO.selectByExample(example);
		if (list == null || list.size() == 0) {
			this.addMortgagePriceConfirmByAppnoParam(appno, WorkflowConstant.APPLI_TYPE_CHANGE_PRICE_APPLY);
		} else {
			this.modifyNoticeByMortgagePriceFloor(appno);
		}
	}

	/**
	 * 通过 申请号、业务类型 生成单个押品价格确定/调整通知书
	 * 
	 * @param bussAppno
	 * @param bussAppno
	 * @param appliType
	 */
	@Transactional
	public void addMortgagePriceConfirmByAppnoParam(String appno, String appliType) {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		if (bPbcAppliBaseInfo == null)
			throw new ScubeBizException("申请数据丢失");
		BCrrGntyCon bCrrGntyCon = iBCrrGntyConDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getSlaveContno());// 获得抵质押合同
		BCntMprotBaseInfo bCntMprotBaseInfo = iBCntMprotBaseInfoDAO
				.selectByPrimaryKey(bPbcAppliBaseInfo.getProtocolNo());// 获得监管协议

		String noticeId = "";
		// 通知书中的货物信息表
		BPbcAppliMtgInfoExample appliMtgInfoExample = new BPbcAppliMtgInfoExample();
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample.Criteria appliMtgInfoExampleCri = appliMtgInfoExample
				.createCriteria();
		appliMtgInfoExampleCri.andAppnoEqualTo(appno);
		noticeId = addNoticeBaseInfo(bPbcAppliBaseInfo, bCrrGntyCon, bCntMprotBaseInfo,
				ScfBasConstant.MORTGAGE_CHANGE_TYPE_ADD, NoticeConstant.NOTICE_TYPE_0);
		if (bCrrGntyCon == null || bCrrGntyCon.getConId() == null)
			throw new ScubeBizException("数据错误");
		else
			appliMtgInfoExampleCri.andSlaveContnoEqualTo(bCrrGntyCon.getConId());
		List<BPbcAppliMtgInfo> bPbcAppliMtgInfoList = iBPbcAppliMtgInfoDAO.selectByExample(appliMtgInfoExample);
		addNoticeMortgageInfo(noticeId, bPbcAppliMtgInfoList, ScfBasConstant.MORTGAGE_TYPE_UNDER);
	}

	/**
	 * 保存通知书基础信息
	 * 
	 * @param bCntMprotBaseInfo
	 * @param bCrrGntyCon
	 * @param bCntMprotBaseInfo
	 * @param mortgageChangeType
	 * @param noticeType
	 * @return
	 */
	@Transactional
	public String addNoticeBaseInfo(BPbcAppliBaseInfo bPbcAppliBaseInfo, BCrrGntyCon bCrrGntyCon,
			BCntMprotBaseInfo bCntMprotBaseInfo, String mortgageChangeType, String noticeType) {
		if (bPbcAppliBaseInfo == null || bCrrGntyCon == null || bCntMprotBaseInfo == null || mortgageChangeType == null
				|| noticeType == null)
			throw new ScubeBizException("数据校验失败");
		UserInfo user = ContextHolder.getUserInfo();
		// 通知书基本信息表
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		bNteNoticeBase.setAppno(bPbcAppliBaseInfo.getAppno());
		bNteNoticeBase.setMonitorProtocolNo(bCrrGntyCon.getPrtclNo());// 监管协议号
		bNteNoticeBase.setProtocolNo(bPbcAppliBaseInfo.getBusinessno());// 四方协议号
		bNteNoticeBase.setProtocolCode(
				bCntMprotBaseInfo.getProtocolCode() != null ? bCntMprotBaseInfo.getProtocolCode() : "");// 四方协议名称
		bNteNoticeBase.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
		bNteNoticeBase.setSlaveContcode(bCrrGntyCon.getConId());
		bNteNoticeBase.setNoticeType(noticeType);
		bNteNoticeBase.setMortgageChangeType(mortgageChangeType);

		BCntMprotPartInfoExample example2 = new BCntMprotPartInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria cri2 = example2.createCriteria();
		if (bCntMprotBaseInfo.getProtocolNo() != null)
			cri2.andProtocolNoEqualTo(bCntMprotBaseInfo.getProtocolNo());
		List<BCntMprotPartInfo> BCntMprotPartInfoList = iBCntMprotPartInfoDAO.selectByExample(example2);// 通过协议号查询参与方
		for (BCntMprotPartInfo bCntMprotPartInfo : BCntMprotPartInfoList) {
			if (ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(bCntMprotPartInfo.getRole())) {// 授信客户
				bNteNoticeBase.setCustcd(bCntMprotPartInfo.getCustcd());// 借款人
				bNteNoticeBase.setCustName(bCntMprotPartInfo.getCname());
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(bCntMprotPartInfo.getRole())) {// 监管公司
				bNteNoticeBase.setMoniOfCustcd(bCntMprotPartInfo.getCustcd());
				bNteNoticeBase.setMoniOfName(bCntMprotPartInfo.getCname());
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(bCntMprotPartInfo.getRole())) {// 核心厂商
				bNteNoticeBase.setOtherCustcd(bCntMprotPartInfo.getCustcd());//
				bNteNoticeBase.setOtherCustName(bCntMprotPartInfo.getCname());
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(bCntMprotPartInfo.getRole())) {// 回购厂商
			}
		}
		bNteNoticeBase.setBrcode(user.getBrNo());// 签发机构
		bNteNoticeBase.setTlrn(user.getTlrNo());// 签发人
		bNteNoticeBase.setAppliDate(ScfDateUtil.getStringDate(new Date()));// 日期
		if (NoticeConstant.NOTICE_TYPE_83.equals(noticeType)) {
			bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);// 已签发
		}else{
			bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);// 未签发
		}
		bNteNoticeBase.setCommonAmt(bPbcAppliBaseInfo.getAmt());
		String num = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_0_NOTICE_NO);

		bNteNoticeBase.setNum(num);
		if (NoticeConstant.NOTICE_TYPE_1.equals(noticeType)) {
			List<SBcpAppliLowerPrice> sBcpAppliLowerPriceList = iSBcpAppliLowerPriceDAO
					.selectByAppno(bPbcAppliBaseInfo.getAppno());
			if (sBcpAppliLowerPriceList != null && sBcpAppliLowerPriceList.size() > 0) {
				bNteNoticeBase.setExt1Amount(sBcpAppliLowerPriceList.get(0).getLowPriceNew());// 监管下限
				bNteNoticeBase.setExt2Amount(bCrrGntyCon.getLowPriceNew());// jiu监管下限
			} else {
				bNteNoticeBase.setExt1Amount(new BigDecimal(0.00));
				bNteNoticeBase.setExt2Amount(new BigDecimal(0.00));// jiu监管下限
			}
		}
		if (NoticeConstant.NOTICE_TYPE_83.equals(noticeType)) {
			bNteNoticeBase.setExt1Amount(bPbcAppliBaseInfo.getAmt());
		}

		// 通知书基本表中存入业务品种
		bNteNoticeBase.setBussType(bCrrGntyCon.getVidPrdId());

		bNteNoticeBase.setSignDate(null);
		bNteNoticeBase.setId(UUIDGeneratorUtil.generate());
		iBNteNoticeBaseDAO.insert(bNteNoticeBase);
		return bNteNoticeBase.getId();
	}

	/**
	 * 保存通知书中的货物信息(流程中)
	 * 
	 * @param noticeId
	 * @param applyMortgageList
	 * @param mortgageType货物类型
	 *            0：表示新入库。1:表示解除抵押，出库。
	 * @throws CommonException
	 */
	@Transactional
	public void addNoticeMortgageInfo(String noticeId, List<BPbcAppliMtgInfo> bPbcAppliMtgInfoList,
			String mortgageType) {
		for (BPbcAppliMtgInfo bPbcAppliMtgInfo : bPbcAppliMtgInfoList) {
			BNteNoticeMtg bNteNoticeMtg = new BNteNoticeMtg();
			BeanUtils.copyProperties(bPbcAppliMtgInfo, bNteNoticeMtg);
			bNteNoticeMtg.setMortgageType(mortgageType);// 货物类型
														// 0：表示新入库。1:表示解除抵押，出库。
			bNteNoticeMtg.setPid(noticeId);
			bNteNoticeMtg.setManufacturer(bPbcAppliMtgInfo.getManufacturer());
			bNteNoticeMtg.setId(UUIDGeneratorUtil.generate());
			iBNteNoticeMtgDAO.insert(bNteNoticeMtg);
		}

	}

	/**
	 * 通过APPNO修改通知书信息
	 * 
	 * @param bussAppno
	 * @throws CommonException
	 */
	@Transactional
	public void modifyNoticeByMortgagePriceFloor(String appno) {
		BigDecimal amt = BigDecimal.ZERO;
		List<SBcpAppliLowerPrice> sBcpAppliLowerPriceList = iSBcpAppliLowerPriceDAO.selectByAppno(appno);
		if (sBcpAppliLowerPriceList != null && sBcpAppliLowerPriceList.size() > 0
				&& sBcpAppliLowerPriceList.get(0).getLowPriceNew() != null)
			amt = sBcpAppliLowerPriceList.get(0).getLowPriceNew();
		// 查找通知书
		BNteNoticeBase bNteNoticeBaseQry = new BNteNoticeBase();
		bNteNoticeBaseQry.setAppno(appno);
		List<BNteNoticeBase> noticeList = iBNteNoticeBaseDAO.selectByCondition(bNteNoticeBaseQry);
		for (BNteNoticeBase bNteNoticeBase : noticeList) {
			// 根据APPNO 与 NOTICEID更新监管下限
			if ((bNteNoticeBase.getNoticeType()).equals(NoticeConstant.NOTICE_TYPE_1)) {// 监管下限
				bNteNoticeBase.setExt1Amount(amt);
				iBNteNoticeBaseDAO.updateByPrimaryKey(bNteNoticeBase);
			} //// 根据APPNO 与 NOTICEID更新押品
			else if (bNteNoticeBase.getNoticeType().equals(NoticeConstant.NOTICE_TYPE_0)
					|| (bNteNoticeBase.getNoticeType()).equals(NoticeConstant.NOTICE_TYPE_90)) {
				// 押品价格确定通知书 押品出质通知书
				BNteNoticeMtgExample bNteNoticeMtgExample = new BNteNoticeMtgExample();
				com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample.Criteria bNteNoticeMtgCri = bNteNoticeMtgExample
						.createCriteria();
				bNteNoticeMtgCri.andAppnoEqualTo(appno);
				bNteNoticeMtgCri.andPidEqualTo(bNteNoticeBase.getId());
				List<BNteNoticeMtg> bNteNoticeMtglist = iBNteNoticeMtgDAO.selectByExample(bNteNoticeMtgExample);
				for (BNteNoticeMtg bNteNoticeMtg : bNteNoticeMtglist) {
					iBNteNoticeMtgDAO.deleteByPrimaryKey(bNteNoticeMtg.getId());
				}
				// 通知书中的货物信息表
				List<BPbcAppliMtgInfo> bPbcAppliMtgInfoList = iBPbcAppliMtgInfoDAO.selectByAppno(appno);
				addNoticeMortgageInfo(bNteNoticeBase.getId(), bPbcAppliMtgInfoList, ScfBasConstant.MORTGAGE_TYPE_IN);
			}

		}

	}

	@Override
	public Page queryMortgageEnteringListByPage(int pageNo, int pageSize, MortgageEnterDO mortgageEnter)
			throws ScubeBizException {
		Map<String, String> map = new HashMap<String, String>();
		Page scfPage = new Page(pageSize, pageNo, 0);
		if (null != mortgageEnter) {
			String cname = mortgageEnter.getCname();// 出质人名称
			String moniCname = mortgageEnter.getMoniCname();// 监管公司名称
			String slaveContcode = mortgageEnter.getSlaveContcode();// 抵/质押合同号
			String mortgageLevelOneName = mortgageEnter.getMortgageLevelOneName();// 押品一级
			String mortgageLevelTwoName = mortgageEnter.getMortgageLevelTwoName();// 押品二级
			String mortgageName = mortgageEnter.getMortgageName();// 押品名称
			String suppProductName = mortgageEnter.getSuppProductName();// 业务品种
			String monitorType = mortgageEnter.getMonitorType();// 监管模式
			String isLocked = mortgageEnter.getIsLocked();// 是否锁定
			String stockStatus = mortgageEnter.getStockStatus();// 库存状态
			String gutId = mortgageEnter.getCustcd();// 出质人id
			String slaveContno = mortgageEnter.getSlaveContno();
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put(CNAME, cname);
			}
			if (StringUtil.isStrNotEmpty(moniCname)) {
				map.put(MONICNAME, moniCname);
			}
			if (StringUtil.isStrNotEmpty(slaveContcode)) {
				map.put(SLAVECONTCODE, slaveContcode);
			}
			if (StringUtil.isStrNotEmpty(mortgageLevelOneName)) {
				map.put(MORTGAGELEVELONENAME, mortgageLevelOneName);
			}
			if (StringUtil.isStrNotEmpty(mortgageLevelTwoName)) {
				map.put(MORTGAGELEVELTWONAME, mortgageLevelTwoName);
			}
			if (StringUtil.isStrNotEmpty(mortgageName)) {
				map.put(MORTGAGENAME, mortgageName);
			}
			if (StringUtil.isStrNotEmpty(suppProductName)) {
				map.put(SUPPPRODUCTNAME, suppProductName);
			}
			if (StringUtil.isStrNotEmpty(monitorType)) {
				map.put(MONITORTYPE, monitorType);
			}
			if (StringUtil.isStrNotEmpty(isLocked)) {
				map.put(ISLOCKED, isLocked);
			}else{
				/*map.put(ISLOCKED, ScfBasConstant.UNLOCKED);*///查询未锁定的
			}
			if (StringUtil.isStrNotEmpty(stockStatus)) {
				map.put(STOCKSTATUS, stockStatus);
			}
			if (StringUtil.isStrNotEmpty(gutId)) {
				map.put(GUTID, gutId);
			}
			if (StringUtil.isStrNotEmpty(slaveContno)) {
				map.put(SLAVECONTNO, slaveContno);
			}
		}
		extIBPbcMtgBaseInfoDAO.queryMortgageEnteringListByPriceAdjust(scfPage, map);// 分页查询
		return scfPage;
	}

	@Override
	public void adjustPriceAppSignUpdater(String appno ,String taskComment) {
		
		//填写通知书的签发日期
		@SuppressWarnings("unchecked")
		List<BNteNoticeBase>  noticeList = bntenoticebaseservice.getNoticeBaseInfoByAppno(appno);
		if(noticeList !=null && noticeList.size() > 0)
		{
			int count = noticeList.size();
			BNteNoticeBase tblNoticeBaseInfo = null;
			for(int i=0;i<count;i++)
			{
				tblNoticeBaseInfo = noticeList.get(i);
				tblNoticeBaseInfo.setCommonDate(ScfDateUtil.getStringDate(new Date()));
				tblNoticeBaseInfo.setStatus(NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
				com.huateng.scf.bas.nte.model.BNteNoticeBase bNteNoticeBase = 
						new com.huateng.scf.bas.nte.model.BNteNoticeBase();
				BeanUtils.copyProperties(tblNoticeBaseInfo, bNteNoticeBase);
				bntenoticebaseservice.updateBNteNoticeBase(bNteNoticeBase);
			}
		}
		//流程流转
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		applibaseinfo.setComment(taskComment);
		try {
			scfWorkFlowService.processTasks(applibaseinfo,WorkflowConstant.WORKFLOW_TRANS_AGREE);
		} catch (FlowsharpException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void adjustPriceDoBack(String appno, String taskComment) {
		//流程流转
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		applibaseinfo.setComment(taskComment);
		try {
			scfWorkFlowService.processTasks(applibaseinfo,WorkflowConstant.WORKFLOW_TRANS_GOBACK);//退回上一节点
		} catch (FlowsharpException e) {
			e.printStackTrace();
		}
	}

}
