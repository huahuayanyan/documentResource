package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.service.IFactFinanceBaseService;
import com.huateng.scf.rec.bcp.service.IFactoringDebtBackService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtDisputRegService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtOutPoolService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpDebtOutPoolServiceImpl")
public class RBcpDebtOutPoolServiceImpl implements IRBcpDebtOutPoolService, DealEndFlowService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfApplyService;

	@Resource(name = "RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;

	@Resource(name = "RBcpDebtDisputRegServiceImpl")
	IRBcpDebtDisputRegService rbcpdebtdisputregservice;

	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rbcpdebtpoolservice;

	@Resource(name = "FactFinanceBaseServiceImpl")
	IFactFinanceBaseService factfinancebaseservice;

	@Resource(name = "FactoringDebtBackServiceImpl")
	IFactoringDebtBackService factoringdebtbackservice;

	// 产品工厂信息
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;

	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO rBcpDebtBaseInfoDAO;

	// 应收账款基本信息
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;
	// 应收账款业务申请流水基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
	// 应收账款融资业务申请流水明细
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;// 业务申请表
	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rBcpAppliBussDtlService;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bCntDebtInfoService;

	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rBcpDebtBussInfoService;

	@Resource(name = "RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;

	private static final String STATUS = "status";
	private static final String LOANREMAININGAMOUNT = "loanRemainingAmount";
	private static final String POOLFLAG = "poolFlag";
	private static final String ISSUEFLAG = "issueFlag";
	private static final String ISLOCKED = "isLocked";
	private static final String LOCKAPPNO = "lockAppno";
	private static final String MASTCONTNO = "mastContno";
	private static final String CUSTCDBUYER = "custcdBuyer";
	private static final String CUSTCDSALLER = "custcdSaller";
	private static final String INSERTDATEFROM = "insertDateFrom";
	private static final String INSERTDATETO = "insertDateTo";
	private static final String PURCHASEDATEFROM = "purchaseDateFrom";
	private static final String PURCHASEDATETO = "purchaseDateTo";
	private static final String BILLSDATEFROM = "billsDateFrom";
	private static final String BILLSDATETO = "billsDateTo";
	private static final String DEBTENDFROM = "debtEndFrom";
	private static final String DEBTENDTO = "debtEndTo";
	private static final String BILLSNO = "billsNo";
	private static final String BILLSTYPE = "billsType";

	/**
	 * 出池待添加发票查询
	 */
	@Override
	public Page getInvoiceOut(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {
		log.debug("出池待添加发票查询");
		Page page = new Page(pageSize,pageNo,0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(STATUS, RBcpDebtConstant.INVOICE_STATUS_PURCHASED); // 发票状态已承购
		map.put(LOANREMAININGAMOUNT, new BigDecimal(0)); // 余额为0
		map.put(POOLFLAG, RBcpDebtConstant.POOL_FLAG_IN_POOL);// 池状态：已入池

		map.put(ISSUEFLAG, RBcpDebtConstant.ISSUE_FLAG_FALSE);// 商纠状态：无争议
		map.put(ISLOCKED, ScfBasConstant.LOCKED);// 发票未被锁定或是被本流程锁定

		if (null != debtCommonQryVO) {
			String lockAppno = debtCommonQryVO.getAppno_Q();
			String mastContno = debtCommonQryVO.getMastContno();
			String custcdBuyer = debtCommonQryVO.getCustcdBuyer_Q();
			String custcdSaller = debtCommonQryVO.getCustcdSaller_Q();
			String insertDateFrom = debtCommonQryVO.getInsertDate_from_Q();
			String insertDateTo = debtCommonQryVO.getInsertDate_to_Q();
			String purchaseDateFrom = debtCommonQryVO.getPurchaseDate_from_Q();
			String purchaseDateTo = debtCommonQryVO.getPurchaseDate_to_Q();
			String billsDateFrom = debtCommonQryVO.getBillsDate_from_Q();// 发票日期
			String billsDateTo = debtCommonQryVO.getBillsDate_to_Q();
			String debtEndFrom = debtCommonQryVO.getDebtEnd_from_Q();// 到期日
			String debtEndTo = debtCommonQryVO.getDebtEnd_to_Q();
			String billsNo = debtCommonQryVO.getBillsNo_Q(); // 凭证编号

			String billsType = debtCommonQryVO.getBillsType_Q(); // 凭证类型
			if (StringUtil.isStrNotEmpty(lockAppno)) {
				map.put(LOCKAPPNO, lockAppno);
			}
			if (StringUtil.isStrNotEmpty(mastContno)) {
				map.put(MASTCONTNO, mastContno);
			}
			if (StringUtil.isStrNotEmpty(custcdBuyer)) {
				map.put(CUSTCDBUYER, custcdBuyer);
			}
			if (StringUtil.isStrNotEmpty(custcdSaller)) {
				map.put(CUSTCDSALLER, custcdSaller);
			}
			if (StringUtil.isStrNotEmpty(insertDateFrom)) {
				map.put(INSERTDATEFROM, insertDateFrom);
			}

			if (StringUtil.isStrNotEmpty(insertDateTo)) {
				map.put(INSERTDATETO, insertDateTo);
			}
			if (StringUtil.isStrNotEmpty(purchaseDateFrom)) {
				map.put(PURCHASEDATEFROM, purchaseDateFrom);
			}
			if (StringUtil.isStrNotEmpty(purchaseDateTo)) {
				map.put(PURCHASEDATETO, purchaseDateTo);
			}
			if (StringUtil.isStrNotEmpty(billsDateFrom)) {
				map.put(BILLSDATEFROM, billsDateFrom);
			}
			if (StringUtil.isStrNotEmpty(billsDateTo)) {
				map.put(BILLSDATETO, billsDateTo);
			}
			if (StringUtil.isStrNotEmpty(debtEndFrom)) {
				map.put(DEBTENDFROM, debtEndFrom);
			}
			if (StringUtil.isStrNotEmpty(debtEndTo)) {
				map.put(DEBTENDTO, debtEndTo);
			}

			if (StringUtil.isStrNotEmpty(billsNo)) {
				map.put(BILLSNO, billsNo);
			}
			if (StringUtil.isStrNotEmpty(billsType)) {
				map.put(BILLSTYPE, billsType);
			}
		}

		rBcpDebtBaseInfoDAO.getInvoiceOut(map, page);
		return page;
	}

	/**
	 * 根据申请编号获得出账应收账款列表
	 */
	@Override
	public Page getInvoiceInpoolAppList(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		List<AppliBussDetailVO> resultList = new ArrayList<AppliBussDetailVO>();
		List<AppliBussDetailVO> list = new ArrayList<AppliBussDetailVO>();
		if (null != debtCommonQryVO) {
			String appno = debtCommonQryVO.getAppno();
			if (StringUtil.isStrNotEmpty(appno)) {
				list = rBcpAppliBussDtlService.getTblAppliBussDetail(appno, "");
			}
		}
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				AppliBussDetailVO applVO = (AppliBussDetailVO) list.get(i);
				applVO.setId(applVO.getDebtId());
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
				if (!StringUtil.isEmpty(applVO.getDebtId())) {
					debtInfo = rBcpDebtBaseInfoDAO.selectByPrimaryKey(applVO.getDebtId());
					applVO.setDeadline(debtInfo.getDeadline());
				}
				if (!debtInfo.getPoolFlag().equals(applVO.getPoolFlag())) {
					applVO.setPoolFlag(debtInfo.getPoolFlag());
				}
				resultList.add(applVO);// bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
			}
			page.setTotalRecord(list.size());
		} else {
			page.setTotalRecord(0);
		}
		page.setRecords(resultList);
		return page;
	}

	/**
	 * 出池申请保存
	 * 
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public String saveDebtOutPoolWriteApply(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,
			@ScubeParam("debtBillsInfoVOList") List<DebtBillsInfoVO> list) throws ScubeBizException {

		// 根据申请类型获取流程名称
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		String appno = "";
		businessnoType = WorkflowConstant.APPLI_TYPE_ACCOUNTS_RECEIVABLE_OUTPOOL_APPLY;
		workApplyType = WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_OUTPOOL_APPLY;
		if (StringUtil.isEmpty(debtBussInfoVO.getAppno())) {
			// 保存信息到申请基本信息表，生成appno并返回
			appno = scfApplyService.saveFactoringAppBasicInfo(debtBussInfoVO, businessnoType, workApplyType);
			String custCd = debtBussInfoVO.getCustcdSaller();
			String custName = debtBussInfoVO.getCnameSeller(); // 卖方名称
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
		}
		debtBussInfoVO.setAppno(appno);
		debtBussInfoVO.setDebtNum(debtBussInfoVO.getTotalNum());// 发票总份数
		debtBussInfoVO.setTotalDebtAmount(debtBussInfoVO.getTotalAmount()); // 发票总出池金额
		debtBussInfoVO.setAmount(debtBussInfoVO.getTotalAmount()); // 发票总出池金额
		debtBussInfoVO.setToPoolAmount(debtBussInfoVO.getTotalAmount());
		// debtBussInfoVO.setInsertDate(debtBussInfoVO.getInpoolDate());
		debtBussInfoVO.setCommonDate(debtBussInfoVO.getInpoolDate());// 出池日期
		// 保存到TBL_APPLI_BUSS_INFO【业务申请业务主表】
		rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);
		// 保存到 TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】
		rBcpAppliBussDtlService.updateAppliBussDetail(list, appno);// 添加发票;
		// TODO Auto-generated method stub
		return appno;
	}

	/**
	 * 入池申请提交
	 */
	@Transactional
	@Override
	public void saveDebtOutPoolWriteSubmit(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,
			@ScubeParam("debtBillsInfoVOList") List<DebtBillsInfoVO> list) throws ScubeBizException {
		String appno = debtBussInfoVO.getAppno();
		if (StringUtil.isEmpty(appno)) {
			throw new ScubeBizException("申请号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		// 保存到TBL_APPLI_BUSS_INFO【业务申请业务主表】
		rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);
		// 保存到 TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】
		rBcpAppliBussDtlService.updateAppliBussDetail(list, appno);// 添加发票;
		// 流程流转
		BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(appliinfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 应收账款出池审批通过
	 */
	@Transactional
	@Override
	public void doWorkForPass(String appNo) {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		// 根据申请编号获得本次的出池相关的信息
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo appliBussInfo = rBcpAppliBussInfoDAO.selectByAppno(appNo);
		// TODO DebtBussInfoVO
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfo, debtVO);
		debtVO.setTotalAmount(appliBussInfo.getTotalDebtAmount());// 本次出池金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		// 根据申请编号获得本次的发票list
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> appliList = rBcpAppliBussDtlDAO.selectByAppno(appNo);

		List<DebtBillsInfoVO> billList = new ArrayList<DebtBillsInfoVO>();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl dtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
		DebtBillsInfoVO invoiceVO = null;
		Iterator iter = appliList.iterator();
		while (iter.hasNext()) {
			dtl = (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl) iter.next();
			invoiceVO = new DebtBillsInfoVO();
			BeanUtils.copyProperties(dtl, invoiceVO);
			invoiceVO.setId(invoiceVO.getDebtId());
			billList.add(invoiceVO);
		}
		// 发票出池
		rBcpDebtBaseInfoService.invoiceOutPoolAddSave(billList, debtVO);
		// 池信息修改
		DebtContVO debtContVO = bCntDebtInfoService.queryContInfoByMastContno(debtVO.getMastContno());
		List<DebtContVO> list = new ArrayList<DebtContVO>();
		list.add(debtContVO);
		rbcpdebtpoolservice.updateOutpoolInfo(debtVO, list);
		// 流水表修改
		rBcpDebtBussInfoService.updateInpoolInfo(debtVO, DebtConstants.APPLY_TYPE_OUT_POOL);
		// 明细表修改
		rBcpDebtBussDtlService.updateOutpoolInfo(billList, debtVO);

		// 更新业务申请表状态
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
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

	/**
	 * (应收账款业务)保存或新增应业务申请信息表 saveOrUpdateDebtAppliBussInfo 方法
	 * 
	 * @param debtVO
	 * @throws ScubeBizException
	 */
	@Transactional
	public void saveOrUpdateDebtAppliBussInfo(DebtBussInfoVO debtVO) throws ScubeBizException {
		UserInfo user = ContextHolder.getUserInfo();
		String tlrNo = user.getTlrNo();
		String brCode = user.getBrNo();
		// RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		;
		List<com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo> list = rBcpAppliBussInfoService.queryAppliBussInfoBillsNo(debtVO.getAppno());// 获取票据
		if (list != null && list.size() > 0) {// 存在票据
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo debtVO_ = (com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo) iter.next();
				rBcpAppliBussInfo = rBcpAppliBussInfoDAO.selectByPrimaryKey(debtVO_.getId());
				// rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());//发票个数原
				rBcpAppliBussInfo.setDebtNum(debtVO.getDebtNum());// 发票个数
				rBcpAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日
				rBcpAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日
				// rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());//发票余额总额
				// 原
				rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalDebtAmount());// 发票余额总额
				rBcpAppliBussInfo.setTlrcd(tlrNo);
				rBcpAppliBussInfo.setBrcode(brCode);
				rBcpAppliBussInfo.setAmount(debtVO.getAmount());
				rBcpAppliBussInfo.setInsertDate(debtVO.getInsertDate());
				rBcpAppliBussInfo.setPurchaseDate(debtVO.getInsertDate());// 折让
				// rBcpAppliBussInfodal.setAppDate(debtVO.getPurchaseDate());
				// //承购日期
				rBcpAppliBussInfo.setAppDate(ScfDateUtil.getStringDate(new Date()));// 申请日期
				rBcpAppliBussInfo.setMemo(debtVO.getMemo()); // 备注
				if (StringUtil.isStrNotEmpty(debtVO.getPressMode())) {
					// 催收方式
					rBcpAppliBussInfo.setReturnType(debtVO.getPressMode());
				}
				// TODO
				try {
					rBcpAppliBussInfoDAO.updateByPrimaryKey(rBcpAppliBussInfo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("应收账款业务申请流水基本信息更新异常！");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10020),
							RBcpErrorConstant.SCF_REC_BCP_10020);
				}
				// tblAppliBussInfoDAO.update(rBcpAppliBussInfo);
			}
		} else {
			BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo);
			if (StringUtil.isEmpty(rBcpAppliBussInfo.getBussType()) && !StringUtil.isStrNotEmpty(debtVO.getProductId())) {
				rBcpAppliBussInfo.setBussType(debtVO.getProductId());// 业务品种
			}
			// rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());//发票个数原
			rBcpAppliBussInfo.setDebtNum(debtVO.getDebtNum());// 发票个数
			rBcpAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日
			rBcpAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日
			rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalDebtAmount());// 发票余额总额
			rBcpAppliBussInfo.setAmount(debtVO.getAmount());// 发票总争议金额
			rBcpAppliBussInfo.setInsertDate(debtVO.getInsertDate());// 争议日期
			rBcpAppliBussInfo.setTlrcd(tlrNo);
			rBcpAppliBussInfo.setBrcode(brCode);
			if (StringUtil.isStrNotEmpty(debtVO.getPressMode())) {
				// 催收方式
				rBcpAppliBussInfo.setReturnType(debtVO.getPressMode());
			}

			rBcpAppliBussInfo.setId(UUIDGeneratorUtil.generate());
			try {
				rBcpAppliBussInfoDAO.insert(rBcpAppliBussInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("应收账款业务申请流水基本信息插入异常！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10019),
						RBcpErrorConstant.SCF_REC_BCP_10019);
			}
			// tblAppliBussInfoDAO.save(rBcpAppliBussInfo);
		}
	}

}
