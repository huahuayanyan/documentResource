/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliCostOutDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpCostOutDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.service.IRBcpPoolDisputeRemoveService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年1月20日上午10:14:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年1月20日上午10:14:05	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("RBcpPoolDisputeRemoveServiceImpl")
public class RBcpPoolDisputeRemoveServiceImpl implements IRBcpPoolDisputeRemoveService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	@Autowired
	private IProcessService processService;
	// 应收账款信息
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	// 客户基本信息
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	// 转让基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
	@Resource(name = "RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;
	// 转让明细信息
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;
	// 通知书
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	// 转让对应的费用信息
	@Resource(name = "IRBcpAppliCostOutDAO")
	IRBcpAppliCostOutDAO rBcpAppliCostOutDAO;
	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpdebtBaseInfoService;
	// 应收账款明细信息
	@Resource(name = "RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;
	// 流程申请基本信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;
	// 流程发起
	@Resource(name = "processService")
	IProcessService iProcessService;
	// 任务服务
	@Autowired
	private ITaskService taskService;
	// 费用流水号
	@Resource(name = "IRBcpCostOutDAO")
	IRBcpCostOutDAO iRBcpCostOutDAO;
	// 费用基本信息
	@Resource(name = "BCntCostInfoServiceImpl")
	IBCntCostInfoService iBCntCostInfoService;
	// 保理合同
	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bCntDebtInfoService;
	// 应收池
	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rBcpDebtPoolService;

	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rBcpAppliBussDtlService;
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;
	@Resource(name = "BNteNoticeBaseServiceImpl")
	IBNteNoticeBaseService bNteNoticeBaseService;
	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO iRBcpDebtBussDtlDAO;

	// 1.池融资纠纷解除(保存按钮)
	@Override
	@Transactional
	public RBcpAppliBussInfo PoolDisputeRemoveApplySaveUpdate(DebtBussInfoVO debtVO, ArrayList<RBcpDebtBussDtl> list, ProcessModel processModel)
			throws ScubeBizException {
		// 1.前台数据校验
		if (debtVO == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (list == null || list.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		if (StringUtil.isEmpty(debtVO.getAppno())) {
			String businessnoType = "";
			String workApplyType = "";
			businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICREMOVEAPPLY;
			workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOIC_REMOVE_APPLY;
			if (ScfBasConstant.FACT_TYPE_REVERSE.equals(debtVO.getFactType()) || ScfBasConstant.FACT_TYPE_INLAND.equals(debtVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOIC_REMOVE_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEDOUBLEINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOIC_REMOVE_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTECREDITINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOIC_REMOVE_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTELEASEINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOIC_REMOVE_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(debtVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEPOOLINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOIC_REMOVE_APPLY;
			}
			// 2.保存申请基本信息 B_PBC_APPLI_BASE_INFO
			debtVO.setMastContcode(debtVO.getMastContno());
			String appno = iBPbcAppliBaseInfoService.saveBillsVendorAppliBaseInfo(debtVO, businessnoType, workApplyType);
			rBcpAppliBussInfo.setAppno(appno);// 用于返回页面的

			// 3.应收账款业务流程表，锁定应收账款基本信息。
			this.addDisputInvoiceRemoveBussInfo(debtVO, list, appno);
			// 4.发起流程
			String processId = "";
			try {
				processModel.setBizId(appno);
				processModel.getBizData()[0] = appno;
				processModel.getBizData()[4] = ContextHolder.getUserInfo().getTlrName();
				ProcessEntity processEntity = iProcessService.startProcess(processModel.getModelId(), processModel.getProcessName(),
						processModel.getNodeId(), processModel.getStartedUserId(), processModel.getBizId(), processModel.getBizData());
				processId = processEntity.getProcessId();
			} catch (Exception e) {// SCF_REC_BCP_10022,发起流程失败
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
			BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			bPbcAppliBaseInfo.setPiid(processId);
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}

		// 有申请号就保存修改操作
		if (StringUtils.isNotEmpty(debtVO.getAppno())) {
			this.UpdateDebtAppliBussInfo(debtVO, list, debtVO.getAppno());
		}
		return rBcpAppliBussInfo;
	}

	// 2.新增应收账款业务明细信息，锁定对应的应收账款基本信息
	@Override
	@Transactional
	public void addDisputInvoiceRemoveBussInfo(DebtBussInfoVO debtVO, ArrayList<RBcpDebtBussDtl> ds, String appno) throws ScubeBizException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo2);
		rBcpAppliBussInfo2.setAppno(appno);// 申请号
		rBcpAppliBussInfo2.setInsertDate(insertDate);// 登记时间
		rBcpAppliBussInfo2.setCrtTime(new Date());// 创建时间
		rBcpAppliBussInfo2.setLastUptTime(new Date());// 最后更新时间
		rBcpAppliBussInfo2.setId(UUIDGeneratorUtil.generate());// id
		rBcpAppliBussInfo2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
		rBcpAppliBussInfo2.setTlrcd(tlrcd);// 创建人，操作员
		rBcpAppliBussInfo2.setBrcode(brcode);// 设置经办机构信息
		try {
			rBcpAppliBussInfoDAO.insert(rBcpAppliBussInfo2);
		} catch (Exception e) {// SCF_REC_BCP_10024 ，新增应收账款业务流水信息失败！
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10024), RBcpErrorConstant.SCF_REC_BCP_10024);
		}

		// 这里要将争议解决方法放进
		for (RBcpDebtBussDtl rBcpDebtBussDtl1 : ds) {
			// 页面传过来的debtId才是RBcpDebtBaseInfo的ID
			RBcpDebtBaseInfo rBcpDebtBaseInfo1 = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rBcpDebtBussDtl1.getDebtId());
			if (rBcpDebtBaseInfo1 != null && !"".equals(rBcpDebtBaseInfo1)) {
				// 防止在选择数据到确定保存的过程中，对应的单据信息被其他人锁定，所以这里要验证下。
				if (rBcpDebtBaseInfo1.getIsLocked().equals(RBcpDebtConstant.IS_LOCKED_TRUE)) {
					throw new ScubeBizException("凭证编号为" + rBcpDebtBaseInfo1.getBillsNo() + "的应收账款基本信息已经被锁定，无法使用！");
				}
				rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);// 设置对应的票据为锁定状态。
				rBcpDebtBaseInfo1.setLockAppno(appno);// 设置对应的锁定的申请号
				try {
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				} catch (Exception e) {
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
							RBcpErrorConstant.SCF_REC_BCP_10025);
				}
				RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
				BeanUtils.copyProperties(rBcpDebtBussDtl1, rBcpAppliBussDtl);
				rBcpAppliBussDtl.setAppno(appno);
				rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
				/*
				 * // 要将争议解决方法也放进最新的明细信息中 RBcpDebtBussDtlExample
				 * rBcpDebtBussDtlExample = new RBcpDebtBussDtlExample();
				 * Criteria createCriteria =
				 * rBcpDebtBussDtlExample.createCriteria();
				 * createCriteria.andDebtIdEqualTo(rBcpDebtBaseInfo1.getId());
				 * createCriteria.andApplyTypeEqualTo(DebtConstants.
				 * APPLY_TYPE_ISSUE_SET);
				 * rBcpDebtBussDtlExample.setOrderByClause(" APPNO desc");//
				 * 申请号越大越新
				 * List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl>
				 * rBcpDebtBussDtlList = iRBcpDebtBussDtlDAO
				 * .selectByExample(rBcpDebtBussDtlExample); if
				 * (rBcpDebtBussDtlList != null && rBcpDebtBussDtlList.size() >
				 * 0) { com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl
				 * rBcpDebtBussDtl2 = rBcpDebtBussDtlList.get(0);
				 * rBcpDebtBussDtl2.setReason(rBcpDebtBussDtl1.getReason()); if
				 * (rBcpDebtBussDtl1.getOtherReason() != null) {
				 * rBcpDebtBussDtl2.setOtherReason(rBcpDebtBussDtl1.
				 * getOtherReason()); } if (rBcpDebtBussDtl1.getMemo() != null)
				 * { rBcpDebtBussDtl2.setMemo(rBcpDebtBussDtl1.getMemo()); }
				 * iRBcpDebtBussDtlDAO.updateByPrimaryKey(rBcpDebtBussDtl2); }
				 * else { throw new
				 * ScubeBizException(ScfMessageUtil.transErrMsgByKey(
				 * RBcpErrorConstant.SCF_REC_BCP_10025),
				 * RBcpErrorConstant.SCF_REC_BCP_10025); }
				 */

			} else {// SCF_REC_BCP_10025 ,锁定应收账款基本信息失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
						RBcpErrorConstant.SCF_REC_BCP_10025);
			}
		}
	}

	// 3.保存操作（已经有申请号）
	@Override
	@Transactional
	public void UpdateDebtAppliBussInfo(DebtBussInfoVO debtVO, ArrayList<RBcpDebtBussDtl> ds, String appno) throws ScubeBizException {
		// 1.保存 应收账款业务申请流水基本信息表 R_BCP_APPLI_BUSS_INFO
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo3 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo3);
		rBcpAppliBussInfo3.setLastUptTime(new Date());// 最后更新时间
		rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(rBcpAppliBussInfo3);
		// 2.锁定的应收账款基本信息(先解锁，删除原有，再锁定)
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(debtVO.getAppno());
		try {
			List<RBcpDebtBaseInfo> bcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
			if (bcpDebtBaseInfoList != null && bcpDebtBaseInfoList.size() > 0) {
				for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : bcpDebtBaseInfoList) {
					rBcpDebtBaseInfo1.setReason(null);// 解决争议方法为空
					rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);// 设置对应的票据为未锁定状态。
					rBcpDebtBaseInfo1.setLockAppno(null);// 设置对应的锁定的申请号为空
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				}
			}
		} catch (Exception e) {// SCF_REC_BCP_10026 ，解锁失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		// 删除原有申请明细信息
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(appno);
		rBcpAppliBussDtlDAO.deleteByExample(rBcpAppliBussDtlExample);

		for (RBcpDebtBussDtl rBcpDebtBussDtl1 : ds) {
			// 页面传过来的debtId才是RBcpDebtBaseInfo的ID
			RBcpDebtBaseInfo rBcpDebtBaseInfo1 = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rBcpDebtBussDtl1.getDebtId());
			if (rBcpDebtBaseInfo1 != null && !"".equals(rBcpDebtBaseInfo1)) {
				// 防止在选择数据到确定保存的过程中，对应的单据信息被其他人锁定，所以这里要验证下。
				if (rBcpDebtBaseInfo1.getIsLocked().equals(RBcpDebtConstant.IS_LOCKED_TRUE)) {
					throw new ScubeBizException("凭证编号为" + rBcpDebtBaseInfo1.getBillsNo() + "的应收账款基本信息已经被锁定，无法使用！");
				}
				rBcpDebtBaseInfo1.setReason(rBcpDebtBussDtl1.getReason());
				rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);// 设置对应的票据为锁定状态。
				rBcpDebtBaseInfo1.setLockAppno(debtVO.getAppno());// 设置对应的锁定的申请号
				try {
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				} catch (Exception e) {
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
							RBcpErrorConstant.SCF_REC_BCP_10025);
				}
				RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
				BeanUtils.copyProperties(rBcpDebtBussDtl1, rBcpAppliBussDtl);
				rBcpAppliBussDtl.setAppno(appno);
				rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
			} else {// SCF_REC_BCP_10025 ,锁定应收账款基本信息失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
						RBcpErrorConstant.SCF_REC_BCP_10025);
			}
		}
	}

	// 4.应收类(池)融资纠纷解除（页面提交按钮）
	@Override
	@Transactional
	public void DisputeInvoiceRemoveApplyWriteSubmitUpdate(DebtBussInfoVO debtVO, ArrayList<RBcpDebtBussDtl> list) throws ScubeBizException {
		// 1.先保存页面信息
		this.UpdateDebtAppliBussInfo(debtVO, list, debtVO.getAppno());
		// 2.流程跳转
		String userId = ContextHolder.getUserInfo().getTlrNo();// 操作员
		if (debtVO.getAppno() != null && !"".equals(debtVO.getAppno())) {
			try {
				BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(debtVO.getAppno());
				String processId = bPbcAppliBaseInfo.getPiid();
				NodeEntity nodeEntity = processService.getCurrentNodeEntity(processId);
				String taskId = nodeEntity.getCurrentTaskId();
				taskService.takeTask(taskId, processId, userId);
				// 任务提交d
				String comment = "发起流程";
				taskService.completeTask(taskId, processId, userId, comment);
				iProcessService.autoSignal(processId);// 通知书回执节点(下一节点)
				bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
				bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 已提交
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			} catch (Exception e) {// 流程跳转失败！ SCF_REC_BCP_10034
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			}
		} else {// 前台业务数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}

	}

	// 审批通过结束流程
	@Override
	@Transactional
	public void doWorkForPass(String appNo) {

		// 1. 解锁应收账款基本信息(新增对应明细信息)
		try {
			RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
			rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(appNo);
			List<RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
			if (rBcpDebtBaseInfoList != null && rBcpDebtBaseInfoList.size() > 0) {
				for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : rBcpDebtBaseInfoList) {

					// 当这里是自动入池的时候可以再次添加方法。这里是为了之后的入池操作准备参数 rBcpAppliBussDtlList
					/*
					 * RBcpAppliBussDtl rBcpAppliBussDtl = new
					 * RBcpAppliBussDtl();
					 * rBcpAppliBussDtl.setDebtId(rBcpDebtBaseInfo1.getId());
					 * rBcpAppliBussDtlList.add(rBcpAppliBussDtl);
					 */

					rBcpDebtBaseInfo1.setIssueFlag(DebtConstants.ISSUE_FLAG_FALSE);// 无商纠
					rBcpDebtBaseInfo1.setIssueReason(null);// 争议原因为空
					rBcpDebtBaseInfo1.setOtherReason(null);// 当争议原因为其他的时候会设置其他争议原因。
					rBcpDebtBaseInfo1.setIsLocked(ScfBasConstant.UNLOCKED);// 解锁
					rBcpDebtBaseInfo1.setLockAppno(null);
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
					RBcpDebtBussDtlExample rBcpDebtBussDtlExample = new RBcpDebtBussDtlExample();
					rBcpDebtBussDtlExample.createCriteria().andDebtIdEqualTo(rBcpDebtBaseInfo1.getId());
					rBcpDebtBussDtlExample.setOrderByClause(" APPNO desc");// 申请号越大越新
					List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> rBcpDebtBussDtlList = iRBcpDebtBussDtlDAO
							.selectByExample(rBcpDebtBussDtlExample);
					if (rBcpDebtBussDtlList != null && rBcpDebtBussDtlList.size() > 0) {
						com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl rBcpDebtBussDtl = new com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl();
						BeanUtils.copyProperties(rBcpDebtBussDtlList.get(0), rBcpDebtBussDtl);
						rBcpDebtBussDtl.setApplyType(DebtConstants.APPLY_TYPE_ISSUE_REMOVE);// 商纠解除
						rBcpDebtBussDtl.setDebtId(rBcpDebtBaseInfo1.getId());// 对应ID
						rBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);
					} else {
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026),
								RBcpErrorConstant.SCF_REC_BCP_10026);
					}
				}
			} else {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026),
						RBcpErrorConstant.SCF_REC_BCP_10026);
			}
		} catch (Exception e) {// SCF_REC_BCP_10026 解锁失败
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		// 2.申请基本信息修改状态
		try {
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoDAO.selectByPrimaryKey(appNo);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);// 已通过(审批通过)
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);// 已通过
			bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_ON);// 设置流程结束了
			bPbcAppliBaseInfoDAO.updateByPrimaryKeySelective(bPbcAppliBaseInfo);
		} catch (Exception e) {// SCF_REC_BCP_10040 //修改申请基本信息失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040), RBcpErrorConstant.SCF_REC_BCP_10040);
		}
		// 4.入池操作（解除的对应单据金额入池） rBcpAppliBussDtlList，debtBussInfoVO
		/*
		 * RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new
		 * RBcpAppliBussInfoExample();
		 * rBcpAppliBussInfoExample.createCriteria().andAppnoEqualTo(appNo); try
		 * { List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo>
		 * rBcpAppliBussInfoList = rBcpAppliBussInfoDAO
		 * .selectByExample(rBcpAppliBussInfoExample); if (rBcpAppliBussInfoList
		 * != null && rBcpAppliBussInfoList.size() == 1) {
		 * com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo
		 * rBcpAppliBussInfoX = rBcpAppliBussInfoList.get(0); DebtBussInfoVO
		 * debtBussInfoVO = new DebtBussInfoVO();
		 * BeanUtils.copyProperties(rBcpAppliBussInfoX, debtBussInfoVO);//
		 * 底下要用到这里的数据（业务合同号）
		 * rBcpAppliBussInfoService.inPool(rBcpAppliBussDtlList,
		 * debtBussInfoVO);// 入池 } else { // log.error(e.getMessage());入池失败！
		 * throw new
		 * ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.
		 * SCF_REC_BCP_10041), RBcpErrorConstant.SCF_REC_BCP_10041); } } catch
		 * (Exception e) { log.error(e.getMessage()); throw new
		 * ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.
		 * SCF_REC_BCP_10041), RBcpErrorConstant.SCF_REC_BCP_10041); }
		 */

	}

	// 将对应的应收账款基本信息解锁
	@Override
	@Transactional
	public void deleteRBcpDebt(RBcpDebtBussDtl rBcpDebtBussDtl) throws ScubeBizException {
		if (rBcpDebtBussDtl == null || "".equals(rBcpDebtBussDtl)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		String id = "";
		if (rBcpDebtBussDtl.getAppno() != null && !"".equals(rBcpDebtBussDtl.getAppno())) {
			id = rBcpDebtBussDtl.getDebtId();
		} else {
			id = rBcpDebtBussDtl.getId();
		}
		try {
			RBcpDebtBaseInfo rBcpDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(id);
			rBcpDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// 解锁
			rBcpDebtBaseInfo.setLockAppno(null);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}

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

}
