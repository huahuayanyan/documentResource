package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.FactoringContVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IFactFinanceBaseService;
import com.huateng.scf.rec.bcp.service.IFactoringDebtBackService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtDisputRegService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtInPoolAccountService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpDebtInPoolAccountServiceImpl")
public class RBcpDebtInPoolAccountServiceImpl implements IRBcpDebtInPoolAccountService, DealInFlowService, DealEndFlowService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private final static List<RBcpAppliBussDtl> listdtl = new ArrayList<RBcpAppliBussDtl>();

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
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;

	// 应收账款基本信息
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService iRBcpDebtBaseInfoService;

	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rbcpapplibussdtldao;

	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rBcpAppliBussDtlService;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bcntdebtinfoservice;

	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rbcpdebtbussinfoservice;

	@Resource(name = "RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rbcpdebtbussdtlservice;

	@Autowired
	private IProcessService processService;

	// 任务基本信息
	@Override
	public com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(String appno) {
		String process = WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_INPOOL_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	/**
	 * 点击入池申请按钮，根据已有信息查询基本信息
	 * 
	 * @param debtBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getDebtInPoolBussInfo(DebtBussInfoVO debtBussInfoVO) throws ScubeBizException {
		Page p = new Page();

		log.debug("合同编号：" + debtBussInfoVO.getMastContno());
		String appno = debtBussInfoVO.getAppno();
		String mastContno = debtBussInfoVO.getMastContno();
		String custcdBuyer = debtBussInfoVO.getCustcdBuyer();
		String custcdSaller = debtBussInfoVO.getCustcdSaller();

		if (!StringUtil.isEmpty(appno)) {
			RBcpAppliBussInfo tabi = rBcpAppliBussInfoService.findByAppno(appno);
			mastContno = tabi.getMastContno();
			custcdBuyer = tabi.getCustcdBuyer();
			custcdSaller = tabi.getCustcdSaller();
		}

		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setCustcdBuyer_Q(custcdBuyer);
		commonQueryVO.setCustcdSaller_Q(custcdSaller);
		commonQueryVO.setAppno_Q(appno);

		List<FactoringContVO> resultList = new ArrayList<FactoringContVO>();
		FactoringContVO contVO = rbcpdebtdisputregservice.getFactContDetailByMastContno(mastContno);

		contVO.setCustcdBuyer(custcdBuyer);
		contVO.setCustcdSaller(contVO.getCustcd());

		List list = rbcpdebtpoolservice.queryDebtPollByMastContno(mastContno, custcdSaller);
		RBcpDebtPool tblDebtPool = (RBcpDebtPool) list.get(0);
		contVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
		contVO.setPoolRiskAmt(factfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));// 池敞口余额
		if (StringUtil.isEmpty(debtBussInfoVO.getAppno())) {
			// 业务品种名称
			BPrdInfo bPrdInfo = new BPrdInfo();
			bPrdInfo.setProductId(contVO.getSupplyChainPdId());
			String bussTypeName = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
			contVO.setBussType(contVO.getSupplyChainPdId());
			contVO.setBussTypeName(bussTypeName);
			// 买家名称
			// BCrmBaseInfo buyer = new BCrmBaseInfo();
			// buyer.setCustcd(contVO.getCustcdBuyer());
			// BCrmBaseInfo buyerinfo=
			// bcrmbaseinfoservice.findBCrmBaseInfoByKey(buyer);
			// contVO.setCnameBuyer(buyerinfo.getCname());
			// 卖家名称
			BCrmBaseInfo seller = new BCrmBaseInfo();
			seller.setCustcd(contVO.getCustcdSaller());
			BCrmBaseInfo sellerinfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(seller);
			contVO.setCnameSeller(sellerinfo.getCname());
			resultList.add(contVO);
			p.setRecords(resultList);
		} else {
			List templist = new ArrayList();
			RBcpAppliBussInfo appliVO = rBcpAppliBussInfoService.findByAppno(appno);
			DebtBussInfoVO bussVo = new DebtBussInfoVO();
			BeanUtils.copyProperties(appliVO, bussVo);
			DebtBussInfoVO debtContVO = factoringdebtbackservice.getContDebtInfoByMastContno(commonQueryVO);
			bussVo.setDebtContno(bussVo.getMastContno());
			bussVo.setCustcdSaller(debtContVO.getCustcdSaller());
			bussVo.setSupplyChainPdId(appliVO.getBussType());// 业务品种
			bussVo.setBussType(appliVO.getBussType());// 业务品种
			bussVo.setBailAcctNo(debtContVO.getBailAcctNo());// 保证金账号
			bussVo.setTotalDebtRemainAmount(contVO.getTotalDebtRemainAmount());// 池应收账款余额
			bussVo.setPoolRiskAmt(contVO.getPoolRiskAmt());// 池敞口
			bussVo.setStartDate(debtContVO.getStartDate());// 合同生效日期
			bussVo.setEndDate(debtContVO.getEndDate());// 合同到期日期
			bussVo.setRebateReason(appliVO.getReason());// 回购原因
			bussVo.setLoanPercent(debtContVO.getLoanPercent());// 融资比例
			// 业务品种名称
			BPrdInfo bPrdInfo = new BPrdInfo();
			bPrdInfo.setProductId(debtContVO.getSupplyChainPdId());
			String bussTypeName = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
			bussVo.setBussTypeName(bussTypeName);
			// 买家名称
			BCrmBaseInfo buyer = new BCrmBaseInfo();
			buyer.setCustcd(appliVO.getCustcdBuyer());
			BCrmBaseInfo buyerinfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(buyer);
			bussVo.setCnameBuyer(buyerinfo.getCname());
			// 卖家名称
			BCrmBaseInfo seller = new BCrmBaseInfo();
			seller.setCustcd(appliVO.getCustcdSaller());
			BCrmBaseInfo sellerinfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(seller);
			bussVo.setCnameSeller(sellerinfo.getCname());
			templist.add(bussVo);
			p.setRecords(templist);
		}
		return p;
	}

	/**
	 * 业务入池信息查询
	 * 
	 * @return
	 * @throws CommonException
	 */
	@Override
	public DebtBussInfoVO getDebtInPoolEdit(DebtBussInfoVO debtBussInfoVO, String cache) throws ScubeBizException {
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		String mastContno = debtBussInfoVO.getMastContno();
		String custcdSaller = debtBussInfoVO.getCustcdSaller();

		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setCustcdSaller_Q(custcdSaller);

		List<DebtBussInfoVO> list = getInPoolInfo(commonQueryVO);
		if (list != null && list.size() > 0) {
			debtVO = list.get(0);
			debtVO.setTotalAmount(new BigDecimal(0));
			debtVO.setTotalNum(new Integer(0));
			if (StringUtil.isEmpty(debtVO.getTotalDebtRemainAmount())) {
				debtVO.setTotalDebtRemainAmount(new BigDecimal(0));
			}
			if (StringUtil.isEmpty(debtVO.getPoolRemainingAmount())) {
				debtVO.setPoolRemainingAmount(new BigDecimal(0));
			}
			if (StringUtil.isEmpty(debtVO.getTotalCashAmount())) {
				debtVO.setTotalCashAmount(new BigDecimal(0));
			}
			if (StringUtil.isEmpty(debtVO.getPoolUseableAmount())) {
				debtVO.setPoolUseableAmount(new BigDecimal(0));
			}
		}
		return debtVO;
	}

	/**
	 *
	 * @Description: 应收账款反转让使用 获得业务申请业务明细表
	 * @author Administrator
	 * @Created 2012-7-26下午02:41:38
	 * @param appno
	 * @param bussType
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getInvoiceInpoolList(int pageNo, int pageSize, RBcpAppliBussInfo rBcpAppliBussInfo, String cache) throws ScubeBizException {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);

		List resultList = new ArrayList();
		if (rBcpAppliBussInfo == null) {
			page.setRecords(resultList);
			page.setTotalRecord(0);
			return page;
		}
		String appno = rBcpAppliBussInfo.getAppno();
		String bussType = "";
		String flag3 = "";
		List list = new ArrayList();
		if (StringUtil.isStrNotEmpty(appno)) {
			list = factoringdebtbackservice.getTblAppliBussDetail(appno, bussType);// TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】—B_PBC_APPLI_BASE_INFO
		}
		String id = "";
		if (StringUtil.isStrNotEmpty(rBcpAppliBussInfo.getId())) {
			id = rBcpAppliBussInfo.getId();
		}
		if (flag3 != null && flag3.equals("1")) {
			for (int i = 0; i < list.size(); i++) {// 获取流程业务中读取数据
				RBcpAppliBussDtl appliVO = (RBcpAppliBussDtl) list.get(i);
				if (id != null) {
					if (appliVO.getDebtId().equals(id)) {
						DebtBillsInfoVO billvo = new DebtBillsInfoVO();
						BeanUtils.copyProperties(billvo, appliVO);
						billvo.setId(appliVO.getDebtId());
						resultList.add(billvo);// bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
					}
				}
			}
		} else if (flag3 != null && flag3.equals("2")) {
			// 应收账款查询列表
			// PageQueryResult pageQueryResult =
			// financingService.getInvoiceFinancingQuery(debtCommonQryVO);
			// List list1=pageQueryResult.getQueryResult();//正式表读取发票
			// if(list1!=null && list1.size()>0){
			// Iterator iters = list1.iterator();
			// while(iters.hasNext()){
			// DebtBillsInfoVO debtVO = (DebtBillsInfoVO)iters.next();
			// debtVO.setDebtId(debtVO.getId());
			// if(!DataFormat.isEmpty(rebateAmount_Q)){
			// debtVO.setRebateAmounts(new BigDecimal(rebateAmount_Q));
			// }else{
			// debtVO.setRebateAmounts(new BigDecimal("0"));
			// }
			// debtVO.setRebatebalance(debtVO.getRemainingAmount().subtract(debtVO.getRebateAmounts()));
			// for(int i = 0; i < list.size() ; i++){
			// AppliBussDetailVO applyDebtVO = (AppliBussDetailVO) list.get(i);
			// if(debtVO.getId().equals(applyDebtVO.getDebtId())){
			// debtVO.setId(applyDebtVO.getDebtId());
			// debtVO.setDebtId(applyDebtVO.getDebtId());
			// list.remove(i);
			// break;
			// }
			// }
			// resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
			// }
			// }
		} else {
			if (cache.equals("0") || cache == "0") {
				listdtl.clear();
			}

			if (listdtl.size() > 0) {
				list.addAll(listdtl);
			}
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					RBcpAppliBussDtl bussdtl = (RBcpAppliBussDtl) list.get(i);
					AppliBussDetailVO applVO = new AppliBussDetailVO();
					BeanUtils.copyProperties(bussdtl, applVO);
					applVO.setId(applVO.getDebtId());
					com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
					if (!StringUtil.isEmpty(applVO.getDebtId())) {
						debtInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(applVO.getDebtId());
						applVO.setDeadline(debtInfo.getDeadline());
					}
					if (!debtInfo.getPoolFlag().equals(applVO.getPoolFlag())) {
						applVO.setPoolFlag(debtInfo.getPoolFlag());
					}
					resultList.add(applVO);// bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
		}
		page.setRecords(resultList);
		page.setTotalRecord(resultList.size());
		return page;
	}

	/**
	 *
	 * @Description: 根据合同号查询池信息
	 * @author jialei.zhang
	 * @Created 2013-5-14上午10:46:09
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<DebtBussInfoVO> getInPoolInfo(DebtCommonQryVO commonQueryVO) throws ScubeBizException {
		List<RBcpDebtPool> list = rbcpdebtpoolservice.getInPoolInfo(commonQueryVO);
		List resultList = new ArrayList();
		if (list != null && list.size() > 0) {
			for (RBcpDebtPool poolInfo : list) {
				DebtBussInfoVO debtVO = new DebtBussInfoVO();
				BeanUtils.copyProperties(poolInfo, debtVO);
				resultList.add(debtVO);
			}
		}
		return resultList;
	}

	/**
	 * 点击新增按钮列表查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @param list
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getInvoiceAdd(int pageNo, int pageSize, DebtCommonQryVO commonQueryVO, List<RBcpAppliBussDtl> list) throws ScubeBizException {
		// 用于判断是否选中勾选框
		String relation_v = "";
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> listqry = getInvoiceAdd(commonQueryVO, list);
		List resultList = new ArrayList();
		if (listqry != null && listqry.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtbaseinfo : listqry) {
				DebtBillsInfoVO debtVO = new DebtBillsInfoVO();
				BeanUtils.copyProperties(debtbaseinfo, debtVO);
				if (!StringUtil.isEmpty(relation_v)) {
					if (relation_v.indexOf(String.valueOf(debtVO.getId())) != -1) {
						debtVO.setSelect(true);
					}
				}
				resultList.add(debtVO);
			}

		}
		Page queryResult = new Page();
		queryResult.setRecords(resultList);
		queryResult.setPageNo(pageNo);
		queryResult.setPageSize(pageSize);
		queryResult.setTotalRecord(resultList.size());

		return queryResult;
	}

	/**
	 *
	 * @Description: 入池发票添加查询
	 * @author jialei.zhang
	 * @Created 2013-5-14下午01:57:46
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> getInvoiceAdd(DebtCommonQryVO commonQueryVO, List list) throws ScubeBizException {
		log.info("入池发票添加 method:getInvoiceAdd begin");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("status", DebtConstants.INVOICE_STATUS_PURCHASED);// 发票状态已承购
		omap.put("loanRemainingAmount", new BigDecimal(0));
		omap.put("poolFlag", DebtConstants.POOL_FLAG_OUT_POOL);// 池状态：非入池
		omap.put("issueFlag", DebtConstants.ISSUE_FLAG_FALSE);// 商纠状态：无争议
		omap.put("isLocked", ScfBasConstant.LOCKED);
		if (StringUtil.isStrNotEmpty(commonQueryVO.getAppno_Q())) {
			omap.put("lockAppno", commonQueryVO.getAppno_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno())) {
			omap.put("mastContno", commonQueryVO.getMastContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getCustcdBuyer_Q())) {
			omap.put("custcdBuyer", commonQueryVO.getCustcdBuyer_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getInsertDate_from_Q())) { // 发票登记日期
			omap.put("insertDate1", commonQueryVO.getInsertDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getInsertDate_to_Q())) { // 发票登记日期
			omap.put("insertDate2", commonQueryVO.getInsertDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getPurchaseDate_from_Q())) { // 承购日期起
			omap.put("purchaseDate1", commonQueryVO.getPurchaseDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getPurchaseDate_to_Q())) { // 承购日期止
			omap.put("purchaseDate2", commonQueryVO.getPurchaseDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsDate_from_Q())) { // 发票日期
			omap.put("billsDate1", commonQueryVO.getBillsDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsDate_to_Q())) { // 发票日期
			omap.put("billsDate2", commonQueryVO.getBillsDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getEndDate_from_Q())) { // 到期日
			omap.put("debtEnd1", commonQueryVO.getEndDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getEndDate_to_Q())) { // 到期日
			omap.put("debtEnd2", commonQueryVO.getEndDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsAmount_from_Q())) { // 发票金额
			omap.put("billsAmount1", commonQueryVO.getBillsAmount_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsAmount_to_Q())) { // 发票金额
			omap.put("billsAmount2", commonQueryVO.getBillsAmount_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsNo_Q())) {// 凭证编号
			omap.put("billsNo", commonQueryVO.getBillsNo_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsType_Q())) {// 凭证类型
			omap.put("billsType", commonQueryVO.getBillsType_Q());
		}

		log.info("入池发票添加 method:getInvoiceAdd end");

		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> listdebt = iRBcpDebtBaseInfoDAO.getInvoiceAdd(omap).getRecords();
		if (listdebt.size() > 0 && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RBcpAppliBussDtl bussdtl = (RBcpAppliBussDtl) list.get(i);
				RBcpDebtBaseInfo baseinfo = new RBcpDebtBaseInfo();
				BeanUtils.copyProperties(bussdtl, baseinfo);
				String billsNo = baseinfo.getBillsNo();
				for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo baseInfo2 : listdebt) {
					String billsNo2 = baseInfo2.getBillsNo();
					if (billsNo.equals(billsNo2) || billsNo == billsNo2) {
						listdebt.remove(baseInfo2);
						break;
					}
				}
			}
		}
		return listdebt;
	}

	/**
	 * 缓存应收账款列表信息
	 */
	@Override
	public void cacheAdd(List<RBcpAppliBussDtl> list) {
		log.debug("开始缓存=============");
		if (list.size() > 0) {
			for (RBcpAppliBussDtl dtl : list) {
				dtl.setDebtId(dtl.getId());
				listdtl.add(dtl);
			}
		}
	}

	@Override
	@Transactional
	public int batchDeleteRBcpDebtBaseInfo(List<RBcpAppliBussDtl> list, String appno) {
		int rows = 0;
		if (list.size() > 0) {
			for (RBcpAppliBussDtl rBcpAppliBussDtl : list) {
				String mrnid = rBcpAppliBussDtl.getId();
				if (StringUtil.isEmpty(appno)) {
					for (RBcpAppliBussDtl cachemrn : listdtl) {
						String cacheid = cachemrn.getId();
						if (mrnid.equals(cacheid)) {
							listdtl.remove(cachemrn);
							rows++;
							break;
						}
					}
				} else {
					RBcpAppliBussDtlExample exampledtl = new RBcpAppliBussDtlExample();
					RBcpAppliBussDtlExample.Criteria cridtl = exampledtl.createCriteria();
					cridtl.andDebtIdEqualTo(mrnid);
					cridtl.andAppnoEqualTo(appno);
					List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> flagdtl = rbcpapplibussdtldao.selectByExample(exampledtl);
					if (flagdtl.size() > 0) {
						String debtId = flagdtl.get(0).getDebtId();
						RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
						RBcpDebtBaseInfoExample.Criteria cri = example.createCriteria();
						cri.andIdEqualTo(debtId);
						com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo record = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
						record.setIsLocked("0");
						record.setLockAppno(null);
						iRBcpDebtBaseInfoDAO.updateByExampleSelective(record, example);
						rows += rbcpapplibussdtldao.deleteByExample(exampledtl);
					} else {
						if (listdtl.size() > 0) {
							for (RBcpAppliBussDtl cachemrn : listdtl) {
								String cacheid = cachemrn.getId();
								if (mrnid.equals(cacheid)) {
									listdtl.remove(cachemrn);
									rows++;
									break;
								}
							}
						}
					}
				}
			}
		}
		return rows;
	}

	/**
	 * 入池申请保存
	 * 
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public String InvoiceInpoolSaveUpdater(AppliBussInfoVO appliBussInfoVO, List<RBcpDebtBaseInfo> insertDebtList) throws ScubeBizException {
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		String in_appno = appliBussInfoVO.getAppno();
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfoVO, debtVO);
		// debtCURDService.invoiceInpoolAddSave(insertDebtList,debtVO);

		businessnoType = WorkflowConstant.APPLI_TYPE_ACCOUNTS_RECEIVABLE_INPOOL_APPLY;
		workApplyType = WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_INPOOL_APPLY;
		debtVO.setApplyType(businessnoType);
		if (StringUtil.isEmpty(in_appno)) {
			// 保存信息到申请基本信息表，生成appno并返回
			in_appno = scfApplyService.saveFactoringAppBasicInfo(debtVO, businessnoType, workApplyType);// 变更
			if (StringUtil.isEmpty(appliBussInfoVO.getAppno())) {
				// 工作流开始
				HashMap<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("modelId", workApplyType);
				paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
				paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
				try {
					scfWorkFlowService.commonStartFlow(in_appno, workApplyType, workApplyType, paramMap);
				} catch (FlowsharpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		debtVO.setAppno(in_appno);
		debtVO.setDebtNum(debtVO.getTotalNum());// 发票总份数
		debtVO.setTotalDebtAmount(debtVO.getTotalAmount()); // 发票总入池金额
		debtVO.setAmount(debtVO.getTotalAmount()); // 发票总入池金额
		debtVO.setToPoolAmount(debtVO.getTotalAmount());
		debtVO.setCommonDate(debtVO.getInsertDate());// 入池日期:将入池日期写入insertDate
		// 保存到TBL_APPLI_BUSS_INFO【业务申请业务主表】
		rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtVO);
		// 保存到 TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】
		rBcpAppliBussDtlService.updateAppliBussDetall(insertDebtList, in_appno);// 添加发票
		listdtl.clear();
		return in_appno;
	}

	/**
	 * 入池申请提交
	 */
	@Override
	public void InvoiceInpoolSubmitUpdater(String appno, boolean isProcess) throws ScubeBizException {
		if (StringUtil.isEmpty(appno)) {
			throw new ScubeBizException("申请号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		if (isProcess) {
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 入池申请审批
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void InvoiceInpoolApproveUpdater(AppliBussInfoVO appliBussInfoVO, List<RBcpDebtBaseInfo> insertDebtList, boolean isProcess)
			throws ScubeBizException {
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfoVO, debtVO);
		// 发票入池
		iRBcpDebtBaseInfoService.invoiceInpoolAddSave(insertDebtList, debtVO);
		// 池信息修改
		DebtContVO debtContVO = bcntdebtinfoservice.queryContInfoByMastContno(debtVO.getMastContno());
		List list = new ArrayList();
		list.add(debtContVO);
		rbcpdebtpoolservice.updateInpoolInfo(debtVO, list);
		// 流水表修改
		rbcpdebtbussinfoservice.updateInpoolInfo(debtVO, DebtConstants.APPLY_TYPE_IN_POOL);
		// 明细表修改
		rbcpdebtbussdtlservice.updateInpoolInfo(insertDebtList, debtVO);
		if (isProcess) {
			// 流程流转
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtVO.getAppno());
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		boolean isProcess = false;
		String process = WorkflowConstant.PROCNAME_ACCOUNTS_RECEIVABLE_INPOOL_APPLY;
		BPbcAppliBaseInfo pbcinfo = scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appNo, process);
		String processId = pbcinfo.getPiid();
		NodeEntity nodeEntity = new NodeEntity();
		try {
			nodeEntity = processService.getCurrentNodeEntity(processId);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nodeId = nodeEntity.getId();
		if (nodeId.equals("Write")) {// 申请
			InvoiceInpoolSubmitUpdater(appNo, isProcess);
		}
		if (nodeId.equals("Approve")) {// 审批
			AppliBussInfoVO appliBussInfoVO = new AppliBussInfoVO();
			RBcpAppliBussInfo bcpAppliBussInfo = rBcpAppliBussInfoService.findByAppno(appNo);
			BeanUtils.copyProperties(bcpAppliBussInfo, appliBussInfoVO);
			List<RBcpDebtBaseInfo> insertDebtList = factoringdebtbackservice.getTblAppliBussDetail(appNo, null);
			InvoiceInpoolApproveUpdater(appliBussInfoVO, insertDebtList, isProcess);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doWorkForPass(String appNo) {
		AppliBussInfoVO appliBussInfoVO = new AppliBussInfoVO();
		RBcpAppliBussInfo bcpAppliBussInfo = rBcpAppliBussInfoService.findByAppno(appNo);
		BeanUtils.copyProperties(bcpAppliBussInfo, appliBussInfoVO);
		appliBussInfoVO.setTotalAmount(appliBussInfoVO.getTotalDebtAmount());// 本次入池金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		List<RBcpAppliBussDtl> dtllist = factoringdebtbackservice.getTblAppliBussDetail(appNo, null);
		List<RBcpDebtBaseInfo> insertDebtList = new ArrayList<RBcpDebtBaseInfo>();
		if (dtllist.size() > 0) {
			for (RBcpAppliBussDtl dtl : dtllist) {
				RBcpDebtBaseInfo baseInfo = new RBcpDebtBaseInfo();
				BeanUtils.copyProperties(dtl, baseInfo);
				baseInfo.setId(dtl.getDebtId());
				insertDebtList.add(baseInfo);
			}
		}
		InvoiceInpoolApproveUpdater(appliBussInfoVO, insertDebtList, false);
	}

	@Override
	public void doWorkForReject(String appNo) {
		scfApplyService.releaseAppliDebtBaseInfo(appNo);
	}

	@Override
	public void doWorkForBack(String appNo) {
		factoringdebtbackservice.debtBackApplyBackToModify(appNo, false);
	}
}
