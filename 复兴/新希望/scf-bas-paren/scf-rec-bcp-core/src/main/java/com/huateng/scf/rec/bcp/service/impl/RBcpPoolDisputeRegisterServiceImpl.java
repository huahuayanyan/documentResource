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
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
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
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.service.IRBcpPoolDisputeRegisterService;
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
@Service("RBcpPoolDisputeRegisterServiceImpl")
public class RBcpPoolDisputeRegisterServiceImpl implements IRBcpPoolDisputeRegisterService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	// 应收账款信息
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	// 客户基本信息
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	// 应收类申请基本信息
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
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	/*
	 * 池融资商纠登记页面保存按钮
	 * 
	 *
	 */
	@Override
	@Transactional
	public RBcpAppliBussInfo poolDisputeRegisterApplySaveUpdate(DebtBussInfoVO debtVO, ArrayList<RBcpAppliBussDtl> ds, ProcessModel processModel)
			throws ScubeBizException {
		// 1.前台数据校验
		if (debtVO == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (ds == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		if (StringUtil.isEmpty(debtVO.getAppno())) {
			String businessnoType = "";
			String workApplyType = "";
			if (ScfBasConstant.FACT_TYPE_REVERSE.equals(debtVO.getFactType()) || ScfBasConstant.FACT_TYPE_INLAND.equals(debtVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEDOUBLEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTECREDITINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTELEASEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(debtVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEPOOLINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOICE_SET_APPLY;
			}
			// 2.保存申请基本信息 B_PBC_APPLI_BASE_INFO
			debtVO.setMastContcode(debtVO.getMastContno());
			String appno = iBPbcAppliBaseInfoService.saveBillsVendorAppliBaseInfo(debtVO, businessnoType, workApplyType);
			rBcpAppliBussInfo.setAppno(appno);// 用于返回页面的
			// 3.申请业务信息RBcpAppliBussInfo，申请业务明细信息 RBcpAppliBussDtl，锁定应收账款基本信息
			this.addDisputInvoiceRegisterBussInfo(debtVO, ds, appno);
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
			this.UpdateDebtAppliBussInfo(debtVO, ds, debtVO.getAppno());
		}
		return rBcpAppliBussInfo;
	}

	/*
	 * 申请业务信息RBcpAppliBussInfo，申请业务明细信息 RBcpAppliBussDtl，锁定应收账款基本信息
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpPoolDisputeRegisterService#
	 * addDisputInvoiceRegisterBussInfo(com.huateng.scf.rec.bcp.model.
	 * DebtBussInfoVO, java.util.ArrayList, java.lang.String)
	 */
	@Override
	@Transactional
	public void addDisputInvoiceRegisterBussInfo(DebtBussInfoVO debtVO, ArrayList<RBcpAppliBussDtl> ds, String appno) throws ScubeBizException {
		// 1.申请基本信息 RBcpAppliBussInfo
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
		// 2.锁定基本信息，新增申请明细信息
		lockDebtBaseAndAddDtl(ds, appno);
	}

	/*
	 * 保存按钮（有申请号就修改操作）
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpPoolDisputeRegisterService#
	 * UpdateDebtAppliBussInfo(com.huateng.scf.rec.bcp.model.DebtBussInfoVO,
	 * java.util.ArrayList, java.lang.String)
	 */
	@Override
	@Transactional
	public void UpdateDebtAppliBussInfo(DebtBussInfoVO debtVO, ArrayList<RBcpAppliBussDtl> ds, String appno) throws ScubeBizException {
		// 1.保存 应收账款业务申请流水基本信息表 R_BCP_APPLI_BUSS_INFO
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo3 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo3);
		rBcpAppliBussInfo3.setLastUptTime(new Date());// 最后更新时间
		try {
			rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(rBcpAppliBussInfo3);
		} catch (Exception e) {// 申请基本信息修改失败
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10023), RBcpErrorConstant.SCF_REC_BCP_10023);
		}

		// 2.解锁，删除原有申请明细信息，再加锁
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(debtVO.getAppno());
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(debtVO.getAppno());
		try {
			List<RBcpDebtBaseInfo> bcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
			if (bcpDebtBaseInfoList != null && bcpDebtBaseInfoList.size() > 0) {
				for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : bcpDebtBaseInfoList) {
					rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);// 设置对应的票据为未锁定状态。
					rBcpDebtBaseInfo1.setLockAppno(null);// 设置对应的锁定的申请号为空
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				}
			}
			// 删除对应申请号的申请明细信息
			rBcpAppliBussDtlDAO.deleteByExample(rBcpAppliBussDtlExample);
		} catch (Exception e) {// SCF_REC_BCP_10026 ，解锁失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		// 3.锁定基本信息，新增申请明细信息
		lockDebtBaseAndAddDtl(ds, appno);
	}

	/*
	 * 锁定对应基本信息并新增对应明细信息
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpPoolDisputeRegisterService#
	 * lockDebtBaseAndAddDtl(java.util.ArrayList, java.lang.String)
	 */
	@Override
	@Transactional
	public void lockDebtBaseAndAddDtl(ArrayList<RBcpAppliBussDtl> ds, String appno) {
		// 1.锁定对应的基本信息(此时前台为首次点击保存，锁定对应基本信息，新增对应申请明细信息)
		for (RBcpAppliBussDtl rBcpAppliBussDtl : ds) {
			// 根据有误申请号判断应收基本信息ID
			String debtId = "";
			if (rBcpAppliBussDtl.getAppno() != null) {
				debtId = rBcpAppliBussDtl.getDebtId();
			} else {
				debtId = rBcpAppliBussDtl.getId();
			}
			RBcpDebtBaseInfo rBcpDebtBaseInfo1 = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(debtId);
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
					log.error(e.getMessage());
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
							RBcpErrorConstant.SCF_REC_BCP_10025);
				}
			}
			// 2.新增对应的申请明细信息
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpAppliBussDtl2);
			rBcpAppliBussDtl2.setAppno(appno);
			rBcpAppliBussDtl2.setDebtId(debtId);
			rBcpAppliBussDtl2.setId(UUIDGeneratorUtil.generate());
			try {
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl2);
			} catch (Exception e) {// SCF_REC_BCP_10012
				log.error(e.getMessage());
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10012),
						RBcpErrorConstant.SCF_REC_BCP_10012);
			}

		}
	}

	/*
	 * 页面删除按钮（删除对应基本明细信息，解锁基本信息）
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpPoolDisputeRegisterService#
	 * deleteRBcpDebtForRegister(com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl)
	 */
	@Override
	@Transactional
	public void deleteRBcpDebtForRegister(RBcpAppliBussDtl rBcpAppliBussDtl) throws ScubeBizException {
		// 1.前台数据校验
		if (rBcpAppliBussDtl == null || "".equals(rBcpAppliBussDtl)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.如果没有申请号，解下锁
		if (rBcpAppliBussDtl.getAppno() == null) {
			rBcpdebtBaseInfoService.releaseDebtBaseInfo(rBcpAppliBussDtl.getId());
			return;
		}
		// 3.有申请号就删除对应的明细信息，然后再解锁基本信息
		try {
			RBcpDebtBaseInfo rBcpDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rBcpAppliBussDtl.getDebtId());
			rBcpDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// 解锁
			rBcpDebtBaseInfo.setLockAppno(null);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);
			// 4.删除对应的申请明细信息
			rBcpAppliBussDtlDAO.deleteByPrimaryKey(rBcpAppliBussDtl.getId());
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpPoolDisputeRegisterService#
	 * submitPoolDisputeRegister(com.huateng.scf.rec.bcp.model.DebtBussInfoVO,
	 * java.util.ArrayList)
	 */
	@Override
	@Transactional
	public void submitPoolDisputeRegister(DebtBussInfoVO debtVO, ArrayList<RBcpAppliBussDtl> list) throws ScubeBizException {
		// 1.数据校验
		if (debtVO.getAppno() == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.保存页面信息
		this.UpdateDebtAppliBussInfo(debtVO, list, debtVO.getAppno());
		// 3.流程跳转(领取任务，跳转流程，保存申请基本信息中的状态)
		scfWorkFlowService.takeTaskAndRelated(debtVO.getAppno());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForPass(java.
	 * lang.String)
	 */
	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// RBcpDebtDisputRegServiceImpl商纠登记的审批通过业务在这个类中
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
