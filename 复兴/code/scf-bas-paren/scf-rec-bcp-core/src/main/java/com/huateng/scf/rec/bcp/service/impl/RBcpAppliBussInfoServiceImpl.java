/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
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
import com.huateng.scf.rec.bcp.dao.model.CostOutModel;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOutExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpCostOut;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliCostOut;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月23日下午8:34:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月23日下午8:34:31	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("RBcpAppliBussInfoServiceImpl")
public class RBcpAppliBussInfoServiceImpl implements IRBcpAppliBussInfoService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	// 应收账款信息
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	// 客户基本信息
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	// 转让基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
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
	// @Autowired
	// private ITaskService taskService;
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
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	// 新增应收账款申请转让信息（新增基本信息，再新增费用信息，新增通知书信息，再新增明细信息,修改对应的应收账款基本信息中的票据的状态和锁定的申请号。需要返回新增基本信息数据）
	@Override
	@Transactional
	public RBcpAppliBussInfo addBcpAppliBussInfo(RBcpAppliBussInfo rcpAppliBussInfo, RBcpAppliCostOut rBcpAppliCostOut,
			ArrayList<RBcpAppliBussDtl> ds, ProcessModel processModel) {
		// 1.前台数据校验
		if (rcpAppliBussInfo == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.发起流程
		String appno = bSysSerialNoService.genSerialNo(RBcpDebtConstant.R_BCP_BUSS_APP_NO);// 申请流水号
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		processModel.setStartedUserId(tlrcd);
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
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022), RBcpErrorConstant.SCF_REC_BCP_10022);
		}
		// 3.新增申请基本信息
		String businessnoType = "";// 申请类型
		String workApplyType = "";// 流程名称
		String factType = rcpAppliBussInfo.getFactType();// 保理类型
		if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {
			businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_AANWINST_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_FACTORING_CREDIT_AANWINST_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {
			businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_AANWINST_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_AANWINST_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {
			businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_AANWINST_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_FACTORING_LEASE_AANWINST_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)) {
			businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_AANWINST_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_AANWINST_APPLY;
		} else {
			businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGAANWINSTAPPLY;
			workApplyType = WorkflowConstant.PROCNAME_FACTORING_AANWINST_APPLY;
		}
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);// 流程名称
		bPbcAppliBaseInfo.setAppliType(businessnoType);// 申请类型
		bPbcAppliBaseInfo.setAppDate(insertDate);// 申请日期
		bPbcAppliBaseInfo.setAppno(appno);// 申请号
		bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);// 选择主合同号
		bPbcAppliBaseInfo.setBusinessno(rcpAppliBussInfo.getMastContno());// 具体的主合同号
		bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 供应链
		bPbcAppliBaseInfo.setSupplyChainPdId(rcpAppliBussInfo.getBussType());// 产品类型
		bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认为流程未结束
		bPbcAppliBaseInfo.setCustcd(rcpAppliBussInfo.getCustcdSaller());// 卖方客户号
		bPbcAppliBaseInfo.setMoniCustcd(rcpAppliBussInfo.getCustcdBuyer());// 买方客户号
		bPbcAppliBaseInfo.setCurcd(rcpAppliBussInfo.getCurcd());// 币种
		bPbcAppliBaseInfo.setSupplyChainPdId(rcpAppliBussInfo.getBussType());// 业务品种
		bPbcAppliBaseInfo.setMastContno(rcpAppliBussInfo.getMastContno()); // 主合同号
		bPbcAppliBaseInfo.setAmt(rcpAppliBussInfo.getTotalDebtAmount());// 转让总金额
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);// 申请状态为未提交（未提交）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);// 申请状态明细（未提交）
		bPbcAppliBaseInfo.setPiid(processId);// 设置流程ID
		bPbcAppliBaseInfo.setStratDate(insertDate);// 开始日期
		try {
			iBPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} catch (Exception e) {// SCF_REC_BCP_10023 申请信息新增失败！
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10023), RBcpErrorConstant.SCF_REC_BCP_10023);
		}
		// 4.新增应收账款转让申请基本信息
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(rcpAppliBussInfo, rBcpAppliBussInfo2);
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

		// 6.新增应收账款转让费用信息 //按年时无费用信息，单笔是有
		if (rBcpAppliCostOut != null) {
			// 注意费用信息的brcode不是经办机构而是页面上的费用网点对应的经办机构信息
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut();
			BeanUtils.copyProperties(rBcpAppliCostOut, rBcpAppliCostOut2);
			rBcpAppliCostOut2.setAppno(appno);// 申请号
			rBcpAppliCostOut2.setInsertDate(insertDate);// 登记时间
			rBcpAppliCostOut2.setId(UUIDGeneratorUtil.generate());// id
			rBcpAppliCostOut2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
			rBcpAppliCostOut2.setStatus(RBcpDebtConstant.CHARGE_STATUS_UNCHARGED);// 费用收取状态为未收
			rBcpAppliCostOut2.setBussType(rBcpAppliBussInfo2.getBussType());// 设置业务品种
			rBcpAppliCostOut2.setTlrcd(tlrcd);// 创建人，操作员
			try {
				rBcpAppliCostOutDAO.insert(rBcpAppliCostOut2);// 新增应收账款转让对应的费用信息
			} catch (Exception e) {// SCF_REC_BCP_10036 ,应收账款业务费用信息新增失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10036),
						RBcpErrorConstant.SCF_REC_BCP_10036);
			}
		}
		// 7.新增应收账款明细信息，改变对应的应收账款基本信息锁定状态和锁定申请号
		for (RBcpAppliBussDtl rBcpAppliBussDtl : ds) {// 遍历新增应收账款转让的明细信息。
			// 新增的时候传过来的明细信息数据的ID就是RBcpDebtBaseInfo的ID
			RBcpDebtBaseInfo rBcpDebtBaseInfo1 = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(rBcpAppliBussDtl.getId());
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
			} else {// SCF_REC_BCP_10025 ,锁定应收账款基本信息失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
						RBcpErrorConstant.SCF_REC_BCP_10025);
			}
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			ScfCommonUtil.setCommonField(rBcpAppliBussDtl);// 设置公共字段
			BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpAppliBussDtl2);
			rBcpAppliBussDtl2.setAppno(appno);// 申请号
			rBcpAppliBussDtl2.setInsertDate(insertDate);// 登记时间
			rBcpAppliBussDtl2.setId(UUIDGeneratorUtil.generate());// id
			rBcpAppliBussDtl2.setDebtId(rBcpDebtBaseInfo1.getId());// 对应的应收账款基本信息的ID
			rBcpAppliBussDtl2.setBillsDate(rBcpDebtBaseInfo1.getBillsDate());// 应收账款日期（从应收账款基本信息表中查出来的）
			rBcpAppliBussDtl2.setDebtEnd(rBcpDebtBaseInfo1.getDebtEnd());// 应收账款到期日
			rBcpAppliBussDtl2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
			rBcpAppliBussDtl2.setBrcode(brcode);// 设置经办机构信息
			rBcpAppliBussDtl2.setTlrcd(tlrcd);// 设置经办机构信息
			try {
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl2);
			} catch (Exception e) {// SCF_REC_BCP_10027 新增应收账款业务历程明细信息失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10027),
						RBcpErrorConstant.SCF_REC_BCP_10027);
			}
		}
		BeanUtils.copyProperties(rBcpAppliBussInfo2, rcpAppliBussInfo);// 返回新增的应收账款转让信息
		return rcpAppliBussInfo;

	}

	// 删除应收账款申请转让信息（根据申请号,ID,先放在这里，肯定是很多很多的东西删除和改变。）
	@Override
	@Transactional
	public int deleteRBcpAppliBussInfo(RBcpAppliBussInfo rBcpAppliBussInfo) {
		if (rBcpAppliBussInfo != null && !"".equals(rBcpAppliBussInfo)) {
			RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
			if (rBcpAppliBussInfo.getId() != null && !"".equals(rBcpAppliBussInfo.getId())) {
				rBcpAppliBussInfoExample.createCriteria().andIdEqualTo(rBcpAppliBussInfo.getId());
			}
			if (rBcpAppliBussInfo.getAppno() != null && !"".equals(rBcpAppliBussInfo.getAppno())) {
				rBcpAppliBussInfoExample.createCriteria().andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
			}
			try {
				return rBcpAppliBussInfoDAO.deleteByExample(rBcpAppliBussInfoExample);
			} catch (Exception e) {
				throw new ScubeBizException("应收账款转让申请信息删除失败！");
			}
		} else {
			throw new ScubeBizException("删除应收账款申请转让信息,前台所传数据无效！");
		}
	}

	// 用于基本页面应收账款转让的第二次点击保存对应的修改功能。
	// 修改应收账款申请转让信息（修改基本信息，再修改费用信息，再全部删除对应明细信息，再新增页面的的明细信息，修改申请基本信息表中的总金额。）
	@Override
	@Transactional
	public int updateRBcpAppliBussInfo(RBcpAppliBussInfo rBcpAppliBussInfo, RBcpAppliCostOut rBcpAppliCostOut, ArrayList<RBcpAppliBussDtl> ds) {
		// 1.校验前台数据
		if (rBcpAppliBussInfo == null || "".equals(rBcpAppliBussInfo)) {// SCF_REC_BCP_10005
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (rBcpAppliBussInfo.getAppno() == null || "".equals(rBcpAppliBussInfo.getAppno())) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}

		// 2.修改申请基本信息中的转让总金额
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		bPbcAppliBaseInfo1.setAmt(rBcpAppliBussInfo.getTotalDebtAmount());// 转让总金额
		BeanUtils.copyProperties(bPbcAppliBaseInfo1, bPbcAppliBaseInfo);
		try {
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} catch (Exception e) {// 修改应收账款申请转让信息，修改申请基本信息的转让总金额失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}

		// 4.申请转让费用信息（如果有费用申请信息）
		if (rBcpAppliCostOut != null && !"".equals(rBcpAppliCostOut)) {
			try {
				RBcpAppliCostOutExample rBcpAppliCostOutExample = new RBcpAppliCostOutExample();
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut();
				BeanUtils.copyProperties(rBcpAppliCostOut, rBcpAppliCostOut2);
				rBcpAppliCostOutExample.createCriteria().andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
				rBcpAppliCostOutDAO.updateByExampleSelective(rBcpAppliCostOut2, rBcpAppliCostOutExample);
			} catch (Exception e) {// "修改应收账款申请转让信息，修改申请费用信息失败！"
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10029),
						RBcpErrorConstant.SCF_REC_BCP_10029);
			}
		}

		// 5.修改申请基本信息
		RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		try {
			BeanUtils.copyProperties(rBcpAppliBussInfo, rBcpAppliBussInfo2);
			rBcpAppliBussInfoExample.createCriteria().andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
			rBcpAppliBussInfoDAO.updateByExampleSelective(rBcpAppliBussInfo2, rBcpAppliBussInfoExample);
		} catch (Exception e) {// SCF_REC_BCP_10007,修改申请基本信息失败
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007), RBcpErrorConstant.SCF_REC_BCP_10007);
		}

		// 6.先删除原有的应收账款转让明细信息，再改变对应的应收账款转让基本信息，再新增应收账款转让明细信息，再改变对应的应收账款基本信息状态
		// 根据申请号删除对应的所有的应收账款转让申请明细信息,改变之前的对应应收账款基本信息的状态和锁定申请号，再将页面传过来的数据遍历新增。
		// 通过绑定申请号查询对应的之前的应收账款基本信息,改变状态和锁定申请号
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(rBcpAppliBussInfo.getAppno());
		try {
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
			rBcpAppliBussDtlDAO.deleteByExample(rBcpAppliBussDtlExample);
			List<RBcpDebtBaseInfo> bcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);

			if (bcpDebtBaseInfoList != null && bcpDebtBaseInfoList.size() > 0) {
				for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : bcpDebtBaseInfoList) {
					rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);// 设置对应的票据为未锁定状态。
					rBcpDebtBaseInfo1.setLockAppno(null);// 设置对应的锁定的申请号为空
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				}
			}
		} catch (Exception e) {// SCF_REC_BCP_10026 ，解锁失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		try {
			for (RBcpAppliBussDtl rBcpAppliBussDtl : ds) {// 遍历新增应收账款转让的明细信息。
				// 页面传过来的数据，如果有appno就是页面第一次加载查询出来的，没有就是后续从应收账款基本信息选取赋值到页面上的。
				String ID = "";
				if (rBcpAppliBussDtl.getAppno() != null && !"".equals(rBcpAppliBussDtl.getAppno())) {
					// 有，则应该使用debtId
					ID = rBcpAppliBussDtl.getDebtId();
				} else {
					// 没有，则说明传过来的本身就是应收账款基本信息，没有debtId,直接使用对应的id
					ID = rBcpAppliBussDtl.getId();
				}
				RBcpDebtBaseInfo rBcpDebtBaseInfo1 = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(ID);
				if (rBcpDebtBaseInfo1 != null && !"".equals(rBcpDebtBaseInfo1)) {
					// 防止在选择数据到确定保存的过程中，对应的单据信息被其他人锁定，所以这里要验证下。
					if (rBcpDebtBaseInfo1.getIsLocked().equals(RBcpDebtConstant.IS_LOCKED_TRUE)) {
						throw new ScubeBizException("凭证编号为" + rBcpDebtBaseInfo1.getBillsNo() + "的应收账款基本信息已经被锁定，无法使用！");
					}
					rBcpDebtBaseInfo1.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);// 设置对应的票据为锁定状态。
					rBcpDebtBaseInfo1.setLockAppno(rBcpAppliBussInfo.getAppno());// 设置对应的锁定的申请号
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				} else {// 锁定失败
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
							RBcpErrorConstant.SCF_REC_BCP_10025);
				}
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
				ScfCommonUtil.setCommonField(rBcpAppliBussDtl);// 设置公共字段
				BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpAppliBussDtl2);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
				String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
				rBcpAppliBussDtl2.setAppno(rBcpAppliBussInfo.getAppno());// 申请号
				rBcpAppliBussDtl2.setInsertDate(insertDate);// 登记时间
				rBcpAppliBussDtl2.setId(UUIDGeneratorUtil.generate());// id
				rBcpAppliBussDtl2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
				rBcpAppliBussDtl2.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
				rBcpAppliBussDtl2.setDebtId(rBcpDebtBaseInfo1.getId());// 对应的应收账款基本信息的ID
				rBcpAppliBussDtl2.setBillsDate(rBcpDebtBaseInfo1.getBillsDate());// 应收账款日期（从应收账款基本信息表中查出来的）
				rBcpAppliBussDtl2.setDebtEnd(rBcpDebtBaseInfo1.getDebtEnd());// 应收账款到期日
				try {
					rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl2);
				} catch (Exception e) {// SCF_REC_BCP_10027 新增应收账款业务历程明细信息失败！
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10027),
							RBcpErrorConstant.SCF_REC_BCP_10027);
				}
			}
		} catch (Exception e) {// 锁定失败
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025), RBcpErrorConstant.SCF_REC_BCP_10025);
		}
		return 0;
	}

	// 根据申请号查询应收账款申请转让信息(根据申请号，ID，主合同号)
	// 要翻译对应的卖方，买方客户号，客户名称，合同的生效日，到期日，合同金额。
	@Override
	public RBcpAppliBussInfo findBcpAppliBussInfoByKey(RBcpAppliBussInfo rBcpAppliBussInfo) {
		if (rBcpAppliBussInfo != null && !"".equals(rBcpAppliBussInfo)) {
			RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
			// ID
			if (rBcpAppliBussInfo.getId() != null && !"".equals(rBcpAppliBussInfo.getId())) {
				rBcpAppliBussInfoExample.createCriteria().andIdEqualTo(rBcpAppliBussInfo.getId());
			}
			// 申请号
			if (rBcpAppliBussInfo.getAppno() != null && !"".equals(rBcpAppliBussInfo.getAppno())) {
				rBcpAppliBussInfoExample.createCriteria().andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
			}
			try {
				List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> selectByExample = rBcpAppliBussInfoDAO
						.selectByExample(rBcpAppliBussInfoExample);
				if (selectByExample != null && selectByExample.size() > 0) {
					com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = selectByExample.get(0);
					RBcpAppliBussInfo rBcpAppliBussInfo3 = new RBcpAppliBussInfo();
					BeanUtils.copyProperties(rBcpAppliBussInfo2, rBcpAppliBussInfo3);
					// 买方客户号转译
					BCrmBaseInfoExample bCrmBaseInfoExample = new BCrmBaseInfoExample();
					bCrmBaseInfoExample.createCriteria().andCustcdEqualTo(rBcpAppliBussInfo3.getCustcdBuyer());
					List<BCrmBaseInfo> BuyerBCrmBaseInfoList = iBCrmBaseInfoDAO.selectByExample(bCrmBaseInfoExample);
					if (BuyerBCrmBaseInfoList != null && BuyerBCrmBaseInfoList.size() > 0) {
						rBcpAppliBussInfo3.setCnameBuyer(BuyerBCrmBaseInfoList.get(0).getCname());
					} else {
						throw new ScubeBizException("查询应收账款申请转让信息，无对应的买方客户！");
					}
					// 卖方客户名称转译
					BCrmBaseInfoExample SellerBCrmBaseInfoExample = new BCrmBaseInfoExample();
					SellerBCrmBaseInfoExample.createCriteria().andCustcdEqualTo(rBcpAppliBussInfo3.getCustcdSaller());
					List<BCrmBaseInfo> SellerBCrmBaseInfoList = iBCrmBaseInfoDAO.selectByExample(SellerBCrmBaseInfoExample);
					if (SellerBCrmBaseInfoList != null && SellerBCrmBaseInfoList.size() > 0) {
						rBcpAppliBussInfo3.setCnameSeller(SellerBCrmBaseInfoList.get(0).getCname());
					} else {
						throw new ScubeBizException("查询应收账款申请转让信息，无对应的卖方客户！");
					}
					if (rBcpAppliBussInfo2.getBussType() != null) {
						try {
							// 查询对应的业务产品名称 bussTypeName iBPrdInfoService
							BPrdInfo bPrdInfo = new BPrdInfo();
							bPrdInfo.setProductId(rBcpAppliBussInfo2.getBussType());
							BPrdInfo bPrdInfo2 = bPrdInfoService.findBPrdInfoByKey(bPrdInfo);
							rBcpAppliBussInfo3.setBussTypeName(bPrdInfo2.getProductName());
						} catch (Exception e) {
							throw new ScubeBizException("查询应收账款申请转让信息，业务品种名称转译失败！");
						}
					}

					BCntDebtInfo bCntDebtInfo = iBCntDebtInfoDAO.selectByPrimaryKey(rBcpAppliBussInfo3.getMastContno());
					if (bCntDebtInfo != null && !"".equals(bCntDebtInfo)) {
						rBcpAppliBussInfo3.setStartDate(bCntDebtInfo.getStartDate());// 合同生效日
						rBcpAppliBussInfo3.setEndDate(bCntDebtInfo.getEndDate());// 合同到期日
						rBcpAppliBussInfo3.setContAmount(bCntDebtInfo.getContAmount());// 合同对应的合同金额
					} else {
						throw new ScubeBizException("查询应收账款申请转让信息，未查询到对应应收账款合同信息");
					}
					return rBcpAppliBussInfo3;
				} else {
					return null;
				}
			} catch (Exception e) {// 查询具体应收账款申请转让信息失败！ SCF_REC_BCP_10030
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10030),
						RBcpErrorConstant.SCF_REC_BCP_10030);
			}
		} else {// 前台数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	// 应收账款转让页面的提交按钮(到下一节点)
	@Override
	@Transactional
	public void submitRBcpAppliBussInfo(RBcpAppliBussInfo rBcpAppliBussInfo, RBcpAppliCostOut rBcpAppliCostOut, ArrayList<RBcpAppliBussDtl> ds) {
		// 1.再次保存页面信息
		try {
			this.updateRBcpAppliBussInfo(rBcpAppliBussInfo, rBcpAppliCostOut, ds);
		} catch (Exception e) {// 应收账款转让申请提交,保存页面信息失败！ SCF_REC_BCP_10031
			log.error("应收账款转让申请提交,保存页面信息失败！" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		// 2.生成对应通知书
		String factType = rBcpAppliBussInfo.getFactType();// 保理类型

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String num = "";
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		// 合同有追/无追 (老代码 RepaymentApplyOperation AcquisitionWriteSubmitUpdater)
		// 调用应收账款管理公共方法
		if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				|| ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType) || ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)
				|| ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {

			BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
			if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType)) {
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_13);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_13);// 通知书类型
			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)) {
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_101);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_101);// 通知书类型
			}
			bNteNoticeBase.setId(UUIDGeneratorUtil.generate());// id
			if (rBcpAppliBussInfo.getAmount() != null) {// 这个数据可能为空
				bNteNoticeBase.setCommonAmt(rBcpAppliBussInfo.getAmount());
			}
			bNteNoticeBase.setCommonNum(rBcpAppliBussInfo.getDebtNum().toString());// 单据总份数
			bNteNoticeBase.setBussType(rBcpAppliBussInfo.getBussType());// 业务品种（实质是产品ID）
			bNteNoticeBase.setCustName(rBcpAppliBussInfo.getCnameSeller());// 卖方客户名称
			bNteNoticeBase.setCustcd(rBcpAppliBussInfo.getCustcdSaller());// 卖方客户号
			bNteNoticeBase.setOtherCustName(rBcpAppliBussInfo.getCnameBuyer());// 买方客户名称
			bNteNoticeBase.setOtherCustcd(rBcpAppliBussInfo.getCustcdBuyer());// 买方客户号
			bNteNoticeBase.setMastContno(rBcpAppliBussInfo.getMastContno());// 主合同号
			bNteNoticeBase.setBrcode(brcode);// 经办机构
			bNteNoticeBase.setTlrn(tlrcd);// 客户经理
			bNteNoticeBase.setAppliDate(insertDate);// 申请日期
			bNteNoticeBase.setSignDate(insertDate);// 签发日期
			bNteNoticeBase.setCommonDate(insertDate);// 回执日期
			bNteNoticeBase.setStatus(BNteConstant.NOTICE_BASE_STATUS_UNCONFIRM);
			bNteNoticeBase.setNum(num);// 通知书编号
			bNteNoticeBase.setAppno(rBcpAppliBussInfo.getAppno());// 申请编号
			try {
				bNteNoticeBaseDAO.insertSelective(bNteNoticeBase);// 通知书新增
			} catch (Exception e) {// 新增通知书信息失败！ SCF_REC_BCP_10032
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10032),
						RBcpErrorConstant.SCF_REC_BCP_10032);
			}
		} else {// 无对应通知书类型！SCF_REC_BCP_10033
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10033), RBcpErrorConstant.SCF_REC_BCP_10033);
		}
		// 3.流程跳转
		if (rBcpAppliBussInfo.getAppno() != null && !"".equals(rBcpAppliBussInfo.getAppno())) {
			scfWorkFlowService.takeTaskAndRelated(rBcpAppliBussInfo.getAppno());
			/*
			 * try { BPbcAppliBaseInfo bPbcAppliBaseInfo =
			 * iBPbcAppliBaseInfoService
			 * .findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno()); String
			 * processId = bPbcAppliBaseInfo.getPiid(); // 领取任务 NodeEntity
			 * nodeEntity = iProcessService.getCurrentNodeEntity(processId);//
			 * 根据processId取出节点ID String taskId = ""; if (null != nodeEntity) {
			 * taskId = nodeEntity.getCurrentTaskId();// 取当前任务ID }
			 * taskService.takeTask(taskId, processId, userId); // 任务提交d String
			 * comment = "发起流程"; taskService.completeTask(taskId, processId,
			 * userId, comment); // 节点转移(自己要再设置一下)
			 * iProcessService.autoSignal(processId);// 通知书回执节点(下一节点)
			 * bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.
			 * APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
			 * bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.
			 * APPLI_STATUS_DTL_APPROVING);// 已提交
			 * iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(
			 * bPbcAppliBaseInfo); } catch (Exception e) {// 流程跳转失败！
			 * SCF_REC_BCP_10034 log.error("流程跳转失败！" + e.getMessage()); throw
			 * new ScubeBizException(ScfMessageUtil.transErrMsgByKey(
			 * RBcpErrorConstant.SCF_REC_BCP_10034),
			 * RBcpErrorConstant.SCF_REC_BCP_10034); }
			 */

		} else {// 前台业务数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	// 应收账款转让、应收账款池转让回执确认
	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 1.校验前台数据
		if (appNo == null || "".equals(appNo)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String transferDate = simpleDateFormat.format(new Date());// 转让日期
		// 2.更新应收账款申请基本信息 RBcpAppliBussInfo
		RBcpAppliBussInfo rBcpAppliBussInfoVO = new RBcpAppliBussInfo();
		RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
		rBcpAppliBussInfoExample.createCriteria().andAppnoEqualTo(appNo);
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> rBcpAppliBussInfoList = rBcpAppliBussInfoDAO
					.selectByExample(rBcpAppliBussInfoExample);
			if (rBcpAppliBussInfoList != null && rBcpAppliBussInfoList.size() == 1) {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoX = rBcpAppliBussInfoList.get(0);
				BeanUtils.copyProperties(rBcpAppliBussInfoX, rBcpAppliBussInfoVO);// 底下要用到这里的数据（业务合同号）
				if (rBcpAppliBussInfoX.getBussType().equals(ScfBasConstant.PRODUCT_TYPE_GNFAC)) {// 国内保理
					rBcpAppliBussInfoVO.setFactType(ScfBasConstant.FACT_TYPE_INLAND);// 国内保理
				}else if(rBcpAppliBussInfoX.getBussType().equals(ScfBasConstant.PRODUCT_TYPE_GNFXBL)) {//反向保理
					rBcpAppliBussInfoVO.setFactType(ScfBasConstant.FACT_TYPE_REVERSE);
				}else if(rBcpAppliBussInfoX.getBussType().equals(ScfBasConstant.PRODUCT_TYPE_YSZKZY)) {//应收账款质押
					rBcpAppliBussInfoVO.setFactType(ScfBasConstant.FACT_TYPE_DEBT_PLEDGE);
				}
				else if (rBcpAppliBussInfoX.getBussType().equals(ScfBasConstant.PRODUCT_TYPE_DEBT_POOL)) {// 国内保理池
					rBcpAppliBussInfoVO.setFactType(ScfBasConstant.FACT_TYPE_DEBT_POOL);// 国内保理池
				}
				else if (rBcpAppliBussInfoX.getBussType().equals(ScfBasConstant.PRODUCT_TYPE_YSZKZY_POOL)) {// 应收账款池质押
					rBcpAppliBussInfoVO.setFactType(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE); 
				}
				else if (rBcpAppliBussInfoX.getBussType().equals(ScfBasConstant.PRODUCT_TYPE_CKTS_POOL)) {//出口退税池
					rBcpAppliBussInfoVO.setFactType(ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);
				}
				if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
					rBcpAppliBussInfoX.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
				} else if (ScfBasConstant.FACT_TYPE_INLAND.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_REVERSE.equals(rBcpAppliBussInfoVO.getFactType())|ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
					rBcpAppliBussInfoX.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
				}
				rBcpAppliBussInfoX.setPurchaseDate(transferDate);// 转让日期
				if (rBcpAppliBussInfoX.getTotalDebtAmount() != null) {
					rBcpAppliBussInfoX.setAmount(rBcpAppliBussInfoList.get(0).getTotalDebtAmount());
				}
				rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(rBcpAppliBussInfoX);

			} else {// SCF_REC_BCP_10030，查询具体应收账款失败，实际上是数据丢失了。
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10030),
						RBcpErrorConstant.SCF_REC_BCP_10030);
			}
		} catch (Exception e) {// SCF_REC_BCP_10035 修改应收账款业务流水信息失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10035), RBcpErrorConstant.SCF_REC_BCP_10035);
		}

		// 3.新增费用流水信息，修改申请转让费用信息 RBcpAppliCostOut,BCntCostInfo
		RBcpAppliCostOutExample rBcpAppliCostOutExample = new RBcpAppliCostOutExample();
		rBcpAppliCostOutExample.createCriteria().andAppnoEqualTo(appNo);
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut> rBcpAppliCostOutList = rBcpAppliCostOutDAO
					.selectByExample(rBcpAppliCostOutExample);
			if (rBcpAppliCostOutList != null && rBcpAppliCostOutList.size() == 1) {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut rBcpAppliCostOut = rBcpAppliCostOutList.get(0);

				if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
					rBcpAppliCostOut.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
				} else if (ScfBasConstant.FACT_TYPE_INLAND.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_REVERSE.equals(rBcpAppliBussInfoVO.getFactType())|ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
					rBcpAppliCostOut.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
				}
				rBcpAppliCostOutDAO.updateByPrimaryKeySelective(rBcpAppliCostOut);
				RBcpCostOut rBcpCostOut = new RBcpCostOut();
				CostOutModel costOutModel = new CostOutModel();
				// 因为这里的通用日期不同类型，直接copy会报错，所以这里要转换下。
				BeanUtils.copyProperties(rBcpAppliCostOut, costOutModel);
				BeanUtils.copyProperties(costOutModel, rBcpCostOut);
				if (rBcpAppliCostOut.getCommonDate() != null) {// commonDate
					SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
					rBcpCostOut.setCommonDate(simpleDateFormat2.parse(rBcpAppliCostOut.getCommonDate()));
				}
				rBcpCostOut.setChargeClass(ScfBasConstant.CHARGE_TYPE_ONLINE);// 系统收取
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String flowNo = sdf.format(new Date());
				rBcpCostOut.setTxFlowNo("F" + flowNo);// 交易流水号
				rBcpCostOut.setId(UUIDGeneratorUtil.generate());// ID
				rBcpCostOut.setBussContno(rBcpAppliBussInfoVO.getMastContno());// 业务合同号
				// 这里需要通过业务合同号去查询费用基本信息，得到对应的ID赋值给这里的费用基本信息ID字段
				com.huateng.scf.bas.cnt.model.BCntCostInfo bCntCostInfo = new com.huateng.scf.bas.cnt.model.BCntCostInfo();
				bCntCostInfo.setRelaNo(rBcpAppliBussInfoVO.getMastContno());
				com.huateng.scf.bas.cnt.model.BCntCostInfo bCntCostInfo2 = iBCntCostInfoService.findBCntCostInfoByKey(bCntCostInfo);
				rBcpCostOut.setCostInfoId(bCntCostInfo2.getId());// 费用基本信息ID
				iRBcpCostOutDAO.insert(rBcpCostOut);
			}
		} catch (Exception e) {// 回执确认,费用相关信息修改失败！ SCF_REC_BCP_10037
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10037), RBcpErrorConstant.SCF_REC_BCP_10037);
		}
		// 4.更新应收账款申请明细表信息。 RBcpAppliBussDtl,

		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(appNo);
		// 下面会用到 RBcpAppliBussDtlList 应收账款申请明细信息
		ArrayList<RBcpAppliBussDtl> RBcpAppliBussDtlList = new ArrayList<RBcpAppliBussDtl>();
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO
					.selectByExample(rBcpAppliBussDtlExample);
			if (rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() > 0) {
				for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl1 : rBcpAppliBussDtlList) {
					// 发票余额=发票票面金额（老代码感觉有问题 -_-！）
					rBcpAppliBussDtl1.setRemainingAmount(rBcpAppliBussDtl1.getBillsAmount());
					// 可融资余额 = 发票余额 * 融资比例
					BigDecimal remainingUseableAmount = null;
					if (rBcpAppliBussDtl1.getLoanPercent() == null || rBcpAppliBussDtl1.getLoanPercent().equals(new BigDecimal(0))) {
						remainingUseableAmount = rBcpAppliBussDtl1.getBillsAmount();
					} else {
						remainingUseableAmount = rBcpAppliBussDtl1.getBillsAmount()
								.multiply(rBcpAppliBussDtl1.getLoanPercent().divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
					}
					rBcpAppliBussDtl1.setRemainingUseableAmount(remainingUseableAmount);
					BigDecimal billsAmountView = rBcpAppliBussDtl1.getBillsAmountView() == null ? new BigDecimal("0")
							: rBcpAppliBussDtl1.getBillsAmountView();
					BigDecimal billsAmount = rBcpAppliBussDtl1.getBillsAmount() == null ? new BigDecimal("0") : rBcpAppliBussDtl1.getBillsAmount();
					BigDecimal assurePercent = rBcpAppliBussDtl1.getAssurePercent() == null ? new BigDecimal("0")
							: rBcpAppliBussDtl1.getAssurePercent();
					rBcpAppliBussDtl1.setBillsAmountView(billsAmountView);
					rBcpAppliBussDtl1.setBillsAmount(billsAmount);
					rBcpAppliBussDtl1.setMoney(billsAmount);
					rBcpAppliBussDtl1.setAssurePercent(assurePercent);
					rBcpAppliBussDtl1.setStatus(ScfBasConstant.BILLS_STATUS_PURCHASED);// 已转让/出质
					if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
						rBcpAppliBussDtl1.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
					} else if (ScfBasConstant.FACT_TYPE_INLAND.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_REVERSE.equals(rBcpAppliBussInfoVO.getFactType())|ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
						rBcpAppliBussDtl1.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
					}

					rBcpAppliBussDtl1.setPurchaseDate(transferDate);// 转让日期
					RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
					BeanUtils.copyProperties(rBcpAppliBussDtl1, rBcpAppliBussDtl);
					RBcpAppliBussDtlList.add(rBcpAppliBussDtl);
					rBcpAppliBussDtlDAO.updateByPrimaryKey(rBcpAppliBussDtl1);
				}
			} else {// 修改应收账款业务明细信息失败！ SCF_REC_BCP_10038
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10038),
						RBcpErrorConstant.SCF_REC_BCP_10038);
			}
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10038), RBcpErrorConstant.SCF_REC_BCP_10038);
		}
		// 5.解锁对应应收账款基本信息，新增对应的明细信息 （历程信息）；RBcpDebtBaseInfo,RBcpDebtBussDtl
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(appNo);
		try {
			List<RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
			if (rBcpDebtBaseInfoList != null && rBcpDebtBaseInfoList.size() > 0) {
				for (RBcpDebtBaseInfo rBcpDebtBaseInfo : rBcpDebtBaseInfoList) {
					// 发票余额 = 发票金额
					rBcpDebtBaseInfo.setRemainingAmount(rBcpDebtBaseInfo.getBillsAmount());

					// 可融资余额 = 发票余额 * 融资比例
					BigDecimal remainingUseableAmount = null;
					if (rBcpDebtBaseInfo.getLoanPercent() == null || rBcpDebtBaseInfo.getLoanPercent().equals(new BigDecimal(0))) {
						remainingUseableAmount = rBcpDebtBaseInfo.getBillsAmount();
					} else {
						remainingUseableAmount = rBcpDebtBaseInfo.getBillsAmount().multiply(rBcpDebtBaseInfo.getLoanPercent())
								.divide(new BigDecimal("100"));
					}
					rBcpDebtBaseInfo.setRemainingUseableAmount(remainingUseableAmount);

					BigDecimal billsAmountView = rBcpDebtBaseInfo.getBillsAmountView() == null ? new BigDecimal("0")
							: rBcpDebtBaseInfo.getBillsAmountView();
					BigDecimal billsAmount = rBcpDebtBaseInfo.getBillsAmount() == null ? new BigDecimal("0") : rBcpDebtBaseInfo.getBillsAmount();
					BigDecimal assurePercent = rBcpDebtBaseInfo.getAssurePercent() == null ? new BigDecimal("0")
							: rBcpDebtBaseInfo.getAssurePercent();
					rBcpDebtBaseInfo.setBillsAmountView(billsAmountView);
					rBcpDebtBaseInfo.setBillsAmount(billsAmount);
					rBcpDebtBaseInfo.setAssurePercent(assurePercent);
					if (rBcpDebtBaseInfo.getLoanPercent() != null && !rBcpDebtBaseInfo.getLoanPercent().equals(new BigDecimal(0))) {
						rBcpDebtBaseInfo.setLoanPercent(rBcpDebtBaseInfo.getLoanPercent());
					}
					rBcpDebtBaseInfo.setPurchaseDate(transferDate);// 转让日期
					rBcpDebtBaseInfo.setConfirmDate(transferDate);// 回执确认日期
					rBcpDebtBaseInfo.setStatus(ScfBasConstant.BILLS_STATUS_PURCHASED);// 已转让/出质
					rBcpDebtBaseInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);// 未锁定
					rBcpDebtBaseInfo.setLockAppno(null);// 解锁
					if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
						rBcpDebtBaseInfo.setPoolFlag("1");
					}
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);
					com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl rBcpDebtBussDtl = new com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl();
					BeanUtils.copyProperties(rBcpDebtBaseInfo, rBcpDebtBussDtl);
					rBcpDebtBussDtl.setMoney(billsAmount);
					rBcpDebtBussDtl.setDebtId(rBcpDebtBaseInfo.getId());// 对应ID
					rBcpDebtBussDtl.setStatus(RBcpDebtConstant.INVOICE_STATUS_PURCHASED);// 状态为已转让02
					rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
					rBcpDebtBussDtl.setPurchaseDate(transferDate);
					rBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);
					if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
						rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
						rBcpDebtBussDtl.setPoolFlag("1");
						rBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);
					}

				}
			} else {// 解锁失败 SCF_REC_BCP_10026
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026),
						RBcpErrorConstant.SCF_REC_BCP_10026);
			}
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}

		// 6.更新通知书状态 BNteNoticeBase
		BNteNoticeBaseExample bNteNoticeBaseExample = new BNteNoticeBaseExample();
		bNteNoticeBaseExample.createCriteria().andAppnoEqualTo(appNo);
		try {
			List<BNteNoticeBase> bNteNoticeBaseList = bNteNoticeBaseDAO.selectByExample(bNteNoticeBaseExample);
			if (bNteNoticeBaseList != null && bNteNoticeBaseList.size() == 1) {
				bNteNoticeBaseList.get(0).setStatus(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);// 已阅已确认
				bNteNoticeBaseList.get(0).setCommonDate(transferDate);
				bNteNoticeBaseList.get(0).setSignDate(transferDate);
				bNteNoticeBaseDAO.updateByPrimaryKeySelective(bNteNoticeBaseList.get(0));
			} else {// SCF_REC_BCP_10039 修改通知书信息失败
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10039),
						RBcpErrorConstant.SCF_REC_BCP_10039);
			}
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10039), RBcpErrorConstant.SCF_REC_BCP_10039);
		}
		// 7.更新申请基本信息(流程结束) isFlowEnd字段 BPbcAppliBaseInfo
		try {
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoDAO.selectByPrimaryKey(appNo);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);// 已通过(审批通过)
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);// 已通过
			bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_ON);// 设置流程结束了
			bPbcAppliBaseInfoDAO.updateByPrimaryKeySelective(bPbcAppliBaseInfo);
		} catch (Exception e) {// SCF_REC_BCP_10040 //修改申请基本信息失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040), RBcpErrorConstant.SCF_REC_BCP_10040);
		}

		// 8.入池（应收账款池转让） rBcpAppliBussInfoVO,RBcpAppliBussDtlList
		if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfoVO.getFactType())) {
			DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
			BeanUtils.copyProperties(rBcpAppliBussInfoVO, debtBussInfoVO);
			debtBussInfoVO.setFinancingType(DebtConstants.FINANCING_TYPE_POOL);// 池融资
			try {
				this.inPool(RBcpAppliBussDtlList, debtBussInfoVO);// 入池
			} catch (Exception e) {// SCF_REC_BCP_10041
				log.error(e.getMessage());
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10041),
						RBcpErrorConstant.SCF_REC_BCP_10041);
			}

		}
	}

	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub

	}

	// 应收账款池融资入池
	@Override
	@Transactional
	public void inPool(ArrayList<RBcpAppliBussDtl> rBcpAppliBussDtlList, DebtBussInfoVO debtVO) throws ScubeBizException {
		BigDecimal totalDebtAmount = new BigDecimal("0"); // [池发票总金额]
		BigDecimal totalDebtRemainAmount = new BigDecimal("0"); // TOTAL_DEBT_REMAIN_AMOUNT[池发票总余额]
		BigDecimal poolRemainingAmount = new BigDecimal("0"); // POOL_REMAINING_AMOUNT[池融资余额]
		BigDecimal poolUseableAmount = new BigDecimal("0"); // POOL_USEABLE_AMOUNT[池可融资余额]
		for (RBcpAppliBussDtl rBcpAppliBussDtl : rBcpAppliBussDtlList) {
			com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo rBcpDebtBaseInfo = new com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo();
			rBcpDebtBaseInfo.setId(rBcpAppliBussDtl.getDebtId());
			com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo tblDebtBaseInfo = rBcpdebtBaseInfoService.findRBcpDebtBaseInfoByKey(rBcpDebtBaseInfo);
			BigDecimal billsAmount = tblDebtBaseInfo.getBillsAmount() == null ? new BigDecimal("0") : tblDebtBaseInfo.getBillsAmount();
			BigDecimal loanAmount = tblDebtBaseInfo.getLoanAmount() == null ? new BigDecimal("0") : tblDebtBaseInfo.getLoanAmount();
			BigDecimal loanRemainingAmount = tblDebtBaseInfo.getLoanRemainingAmount() == null ? new BigDecimal("0")
					: tblDebtBaseInfo.getLoanRemainingAmount();
			BigDecimal remainingUseableAmount = tblDebtBaseInfo.getRemainingUseableAmount() == null ? new BigDecimal("0")
					: tblDebtBaseInfo.getRemainingUseableAmount();

			// 准备入池属性计算金额
			totalDebtAmount = totalDebtAmount.add(billsAmount);
			totalDebtRemainAmount = totalDebtRemainAmount.add(loanAmount);
			poolRemainingAmount = poolRemainingAmount.add(loanRemainingAmount);
			poolUseableAmount = poolUseableAmount.add(remainingUseableAmount);

		}

		com.huateng.scf.bas.cnt.model.BCntDebtInfo bCntDebtInfo = bCntDebtInfoService.findBCntDebtInfoByKey(debtVO.getMastContno());

		ArrayList<com.huateng.scf.bas.cnt.model.BCntDebtInfo> list = new ArrayList<com.huateng.scf.bas.cnt.model.BCntDebtInfo>();
		list.add(bCntDebtInfo);
		debtVO.setTotalAmount(totalDebtAmount); // 承购金额
		debtVO.setTotalNum(debtVO.getDebtNum());// 承购票据总数
		String purchaseDate = debtVO.getPurchaseDate();
		debtVO.setInpoolDate(purchaseDate);
		debtVO.setTotalDebtAmount(totalDebtAmount);
		debtVO.setTotalDebtRemainAmount(totalDebtRemainAmount);
		debtVO.setPoolRemainingAmount(poolRemainingAmount);
		debtVO.setPoolUseableAmount(poolUseableAmount);

		rBcpDebtPoolService.updateInpoolInfo(debtVO, list);
		// 发票入池（解锁对应票据，设置poolFlag为1）
		// rBcpdebtBaseInfoService.invoiceInpoolAddSave(rBcpAppliBussDtlList,
		// debtVO);
		// 流水表修改
		// tblDebtBussInfoDAO.updateInpoolInfo(debtVO,
		// DebtConstants.APPLY_TYPE_IN_POOL);
		// 明细表修改
		// tblDebtBussDetailDAO.updateInpoolInfo(rBcpAppliBussDtlList, debtVO);

	}

	/*
	 * (应收账款业务)保存或新增应业务申请信息表
	 * 
	 * @author daq
	 */
	@Transactional
	@Override
	public void saveOrUpdateDebtAppliBussInfo(DebtBussInfoVO debtVO) {
		UserInfo gb = ContextHolder.getUserInfo();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo tblAppliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> list = rBcpAppliBussInfoDAO.selectAppliBussInfoBillsNo(debtVO.getAppno());// 获取票据
		if (list != null && list.size() > 0) {// 存在票据
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo debtVO_ : list) {
				tblAppliBussInfo = rBcpAppliBussInfoDAO.selectByPrimaryKey(debtVO_.getId());
				// TODO老代码 是设置 debtVO.getTotalNum() 查看是否待修改
				tblAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票个数
				tblAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日
				tblAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日
				tblAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 发票余额总额

				tblAppliBussInfo.setTlrcd(gb.getTlrNo());

				tblAppliBussInfo.setBrcode(gb.getBrNo());
				tblAppliBussInfo.setAmount(debtVO.getAmount());// 发票总争议金额
				tblAppliBussInfo.setInsertDate(debtVO.getInsertDate());
				tblAppliBussInfo.setPurchaseDate(debtVO.getInsertDate());// 折让
				tblAppliBussInfo.setAppDate(debtVO.getPurchaseDate()); // 承购日期
				tblAppliBussInfo.setAppDate(debtVO.getAppDate());// 申请日期
				tblAppliBussInfo.setMemo(debtVO.getMemo()); // 备注
				// 买方名称
				tblAppliBussInfo.setCustcdBuyer(debtVO.getCustcdBuyer());
				if (StringUtils.isNotBlank(debtVO.getPressMode())) {
					// 催收方式
					tblAppliBussInfo.setReturnType(debtVO.getPressMode());
				}
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoDal = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
				BeanUtils.copyProperties(tblAppliBussInfo, rBcpAppliBussInfoDal);
				rBcpAppliBussInfoDAO.updateByPrimaryKey(rBcpAppliBussInfoDal);
			}
		} else {
			BeanUtils.copyProperties(debtVO, tblAppliBussInfo);
			if (StringUtils.isEmpty(tblAppliBussInfo.getBussType()) && !StringUtils.isEmpty(debtVO.getProductId())) {
				tblAppliBussInfo.setBussType(debtVO.getProductId());// 业务品种
			}
			tblAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票个数
			tblAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日
			tblAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日
			tblAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 发票余额总额
			tblAppliBussInfo.setAmount(debtVO.getAmount());// 发票总争议金额
			tblAppliBussInfo.setInsertDate(debtVO.getInsertDate());// 争议日期
			tblAppliBussInfo.setTlrcd(gb.getTlrNo());
			tblAppliBussInfo.setBrcode(gb.getBrNo());
			tblAppliBussInfo.setMemo(debtVO.getMemo()); // 备注
			if (StringUtils.isNotBlank(debtVO.getPressMode())) {
				// 催收方式
				tblAppliBussInfo.setReturnType(debtVO.getPressMode());
			}
			tblAppliBussInfo.setId(null);
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoDal = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
			BeanUtils.copyProperties(tblAppliBussInfo, rBcpAppliBussInfoDal);
			if (StringUtils.isBlank(rBcpAppliBussInfoDal.getId())) {
				rBcpAppliBussInfoDal.setId(UUIDGeneratorUtil.generate(rBcpAppliBussInfoDal));
			}
			rBcpAppliBussInfoDAO.insert(rBcpAppliBussInfoDal);

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @author by daq
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getTblAppliBussInfo(String appno) {
		RBcpAppliBussInfoExample example = new RBcpAppliBussInfoExample();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample.Criteria criteria = example.createCriteria();
		criteria.andAppnoEqualTo(appno);
		List list = rBcpAppliBussInfoDAO.selectByExample(example);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @author by daq
	 */
	@Override
	public RBcpAppliBussInfo findByAppno(String appno) {

		RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoDal = rBcpAppliBussInfoDAO.selectByAppno(appno);
		BeanUtils.copyProperties(rBcpAppliBussInfoDal, rBcpAppliBussInfo);
		return rBcpAppliBussInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService#
	 * saveDebtBackAppliBussInfo(com.huateng.scf.rec.bcp.model.DebtBussInfoVO)
	 */
	@Transactional
	@SuppressWarnings("rawtypes")
	@Override
	public String saveDebtBackAppliBussInfo(DebtBussInfoVO debtVO) throws ScubeBizException {
		String id = null;
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> list = rBcpAppliBussInfoDAO.selectAppliBussInfoBillsNo(debtVO.getAppno());// 获取票据
		if (list != null && list.size() > 0) {// 存在票据
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo debtVO_ = (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo) iter.next();
				rBcpAppliBussInfo = rBcpAppliBussInfoDAO.selectByPrimaryKey(debtVO_.getId());
				rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票份数
				rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 回购总金额
				rBcpAppliBussInfo.setReason(debtVO.getReason());// 回购原因
				rBcpAppliBussInfo.setOtherReason(debtVO.getOtherReason());// 其他原因
				rBcpAppliBussInfoDAO.updateByPrimaryKey(rBcpAppliBussInfo);
				id = debtVO_.getId();
			}
		} else {
			BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo);// 拷贝信息
			// 拷贝数据信息
			rBcpAppliBussInfo.setBussType(debtVO.getBussType());// 业务品种
			rBcpAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日期
			rBcpAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日期
			rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());// 发票份数
			rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());// 回购总金额
			rBcpAppliBussInfo.setReason(debtVO.getReason());// 回购原因
			rBcpAppliBussInfo.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussInfoDAO.insertSelective(rBcpAppliBussInfo);
			id = rBcpAppliBussInfo.getId();
		}
		return id;
	}

	@Override
	public List<RBcpAppliBussInfo> queryAppliBussInfoBillsNo(String appno) {

		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> listDal = rBcpAppliBussInfoDAO.selectAppliBussInfoBillsNo(appno);
		List<RBcpAppliBussInfo> resultList = new ArrayList<RBcpAppliBussInfo>();
		if (listDal != null && listDal.size() > 0) {
			for (int i = 0; i < listDal.size(); i++) {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoDal = listDal.get(i);
				RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
				BeanUtils.copyProperties(rBcpAppliBussInfoDal, rBcpAppliBussInfo);
				resultList.add(rBcpAppliBussInfo);
			}
		}

		return resultList;
	}

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

	/**
	 * 保存时取SEQ
	 * 
	 * @author mengjiajia
	 * @date 2011-11-09 save 方法
	 * @throws HibernateException
	 */
	@Override
	public void save(RBcpAppliBussInfo tblAppliBussInfo) throws ScubeBizException {
		if (StringUtils.isEmpty(tblAppliBussInfo.getId())) {
			tblAppliBussInfo.setId(UUIDGeneratorUtil.generate());
		}
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo appliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(tblAppliBussInfo, appliBussInfo);
		rBcpAppliBussInfoDAO.insertSelective(appliBussInfo);
	}

	/**
	 * findByProperty方法 根据单属性查询PO实例，返回list
	 * 
	 * @author mengjiajia
	 * @date 2010-12-8
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	public List<RBcpAppliBussInfo> findByProperty(String appno) {
		RBcpAppliBussInfoExample example = new RBcpAppliBussInfoExample();
		RBcpAppliBussInfoExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> listdal = rBcpAppliBussInfoDAO.selectByExample(example);
		List<RBcpAppliBussInfo> list = new ArrayList<RBcpAppliBussInfo>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo appliBussInfo : listdal) {
				RBcpAppliBussInfo bcpAppliBussInfo = new RBcpAppliBussInfo();
				try {
					BeanUtils.copyProperties(appliBussInfo, bcpAppliBussInfo);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(bcpAppliBussInfo);
			}
		}
		return list;
	}

	/**
	 * 保存时取SEQ
	 * 
	 * @author mengjiajia
	 * @date 2011-11-09 save 方法
	 * @throws HibernateException
	 */
	@Override
	public void update(RBcpAppliBussInfo tblAppliBussInfo) throws ScubeBizException {
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo appliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(tblAppliBussInfo, appliBussInfo);
		rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(appliBussInfo);
	}
}
