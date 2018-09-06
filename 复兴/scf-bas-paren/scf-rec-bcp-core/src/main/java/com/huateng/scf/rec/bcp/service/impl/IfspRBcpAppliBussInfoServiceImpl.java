/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.cnt.model.BCntCostInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtExtInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scf.bas.sys.service.IBSysAcctBctlService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliCostOutDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.service.IIfspRBcpAppliBussInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>应收账款池融资转让申请接口
 * </p>
 *
 * @author zhangcheng
 * @date 2017年3月4日下午8:34:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年3月4日下午8:34:31	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IfspRBcpAppliBussInfoServiceImpl")
public class IfspRBcpAppliBussInfoServiceImpl implements IIfspRBcpAppliBussInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	// 转让基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
	// 转让明细信息
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;

	// 转让对应的费用信息
	@Resource(name = "IRBcpAppliCostOutDAO")
	IRBcpAppliCostOutDAO rBcpAppliCostOutDAO;
	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;
	
	// 流程申请基本信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;
	// 业务合同基本信息
	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bCntDebtInfoService;
	// 业务合同扩展信息
	@Resource(name = "BCntDebtExtInfoServiceImpl")
	IBCntDebtExtInfoService bCntDebtExtInfoService;
	// 费用基本信息
	@Resource(name = "BCntCostInfoServiceImpl")
	IBCntCostInfoService bCntCostInfoService;
	// 客户基本信息
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bCrmBaseInfoDAO;
	
	// 流程发起
	@Resource(name = "processService")
	IProcessService iProcessService;
	@Resource(name = "BSysAcctBctlServiceImpl")
	IBSysAcctBctlService bSysAcctBctlService;
	@Resource(name = "userService")
	UserService userService;
	// 新增应收账款申请转让信息（新增基本信息，再新增费用信息，新增通知书信息，再新增明细信息,修改对应的应收账款基本信息中的票据的状态和锁定的申请号。需要返回新增基本信息数据）
	@Override
	@Transactional
	public RBcpAppliBussInfo addBcpAppliBussInfo(RBcpAppliBussInfo rcpAppliBussInfo, 
			ArrayList<RBcpAppliBussDtl> ds) {
		 ProcessModel processModel=new ProcessModel();
		 processModel.setModelId("FactoringPoolAanwinstApply");
		 processModel.setProcessName("应收账款池融资转让申请");
		 processModel.setNodeId("Write");
		 String[] bizData=new String[5];
		// 1.前台数据校验
		if (rcpAppliBussInfo == null || "".equals(rcpAppliBussInfo)) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if(rcpAppliBussInfo.getMastContno()==null||"".equals(rcpAppliBussInfo.getMastContno())){
			throw new ScubeBizException("池合同号不能为空！");
		}
		BCntDebtInfo debtInfo=bCntDebtInfoService.findBCntDebtInfoByKey(rcpAppliBussInfo.getMastContno());
		BCntDebtExtInfo ext=new BCntDebtExtInfo();
		ext.setBusinessNo(debtInfo.getDebtContno());
	    ext=bCntDebtExtInfoService.findBCntDebtExtInfoByKey(ext);
		BCntCostInfo costInfo=bCntCostInfoService.getTblCostInfoByBusniessNoAndCostCode(rcpAppliBussInfo.getMastContno(), ScfBasConstant.COST_TYPE);
		if(debtInfo==null){
			throw new ScubeBizException("池合同号信息不存在！");
		}
		if(costInfo==null){
			costInfo=new BCntCostInfo();
		}
		BigDecimal totalFee=new BigDecimal(0.00);//费用总额
		BigDecimal totalReduce=new BigDecimal(0.00);//减免总额
		BigDecimal receiveAmount=new BigDecimal(0.00);//实收费用总额
		BigDecimal totalDebtAmount=rcpAppliBussInfo.getTotalDebtAmount();//应收账款总额
		if("1".equals(costInfo.getCostCalcType())){//固定费用
			totalFee=costInfo.getCostAmt();
			receiveAmount=totalFee;
		}else if("1".equals(costInfo.getCostCalcType())){//按比例收费
			if(totalDebtAmount!=null){
				totalFee=totalDebtAmount.multiply(costInfo.getCostRate()).divide(new BigDecimal(100));
				receiveAmount=totalFee;
			}
		}
		
			// 2.发起流程
		String appno = bSysSerialNoService.genSerialNo(RBcpDebtConstant.R_BCP_BUSS_APP_NO);// 申请流水号
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		//String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		//String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		String processId = "";
		BCrmBaseInfo sellcrmBase=bCrmBaseInfoDAO.selectById(rcpAppliBussInfo.getCustcdSaller());
		BCrmBaseInfo buycrmBase=bCrmBaseInfoDAO.selectById(rcpAppliBussInfo.getCustcdBuyer());

		try {
			processModel.setBizId(appno);
			processModel.setStartedUserId(debtInfo.getTlrcd());
			bizData[0]=appno;
			bizData[1]=rcpAppliBussInfo.getCustcdSaller();
			bizData[2]=sellcrmBase.getCname();
			bizData[3]="FactoringPoolAanwinstApply";
			UserInfo userInfo1 = new UserInfo();
			userInfo1.setTlrNo(debtInfo.getTlrcd());// 搜索创建人对应的名称。
			List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
			if (userList != null && userList.size() == 1) {
				TlrInfoVO vo=userList.get(0);
				bizData[4]=vo.getTlrName();
			} else {
				throw new ScubeBizException("操作员号为" + debtInfo.getTlrcd() + " 的操作员信息有误！");
			}
			processModel.setBizData(bizData);
			ProcessEntity processEntity = iProcessService.startProcess(processModel.getModelId(),
					processModel.getProcessName(), processModel.getNodeId(), processModel.getStartedUserId(),
					processModel.getBizId(), processModel.getBizData());
			processId = processEntity.getProcessId();
		} catch (Exception e) {// SCF_REC_BCP_10022,发起流程失败
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
					RBcpErrorConstant.SCF_REC_BCP_10022);
		}
		// 3.新增申请基本信息
		String businessnoType = "";// 申请类型
		String workApplyType = "";// 流程名称
		String factType = debtInfo.getFactType();// 保理类型
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
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
		rcpAppliBussInfo.setFactType(factType);
		rcpAppliBussInfo.setCnameBuyer(buycrmBase.getCname());
		rcpAppliBussInfo.setCnameSeller(sellcrmBase.getCname());
		bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);// 流程名称
		bPbcAppliBaseInfo.setAppliType(businessnoType);// 申请类型
		bPbcAppliBaseInfo.setAppDate(insertDate);// 申请日期
		bPbcAppliBaseInfo.setAppno(appno);// 申请号
		bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);// 选择主合同号
		bPbcAppliBaseInfo.setBusinessno(debtInfo.getDebtContno());// 具体的主合同号
		bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_IFSP);// 供应链
		bPbcAppliBaseInfo.setSupplyChainPdId(debtInfo.getSupplyChainPdId());// 产品类型
		bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认为流程未结束
		bPbcAppliBaseInfo.setCustcd(rcpAppliBussInfo.getCustcdSaller());// 卖方客户号
		bPbcAppliBaseInfo.setMoniCustcd(rcpAppliBussInfo.getCustcdBuyer());// 买方客户号
		bPbcAppliBaseInfo.setCurcd(debtInfo.getCurcd());// 币种
		bPbcAppliBaseInfo.setAmt(rcpAppliBussInfo.getTotalDebtAmount());// 转让总金额
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);// 申请状态为未提交（未提交）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);// 申请状态明细（未提交）
		bPbcAppliBaseInfo.setPiid(processId);// 设置流程ID
		bPbcAppliBaseInfo.setStratDate(insertDate);// 开始日期
		bPbcAppliBaseInfo.setIfspAppno(rcpAppliBussInfo.getAppno());
		// 设置公共字段
		bPbcAppliBaseInfo.setAppBrcode(debtInfo.getBrcode());// 登记机构
		bPbcAppliBaseInfo.setApprover(debtInfo.getTlrcd());
		bPbcAppliBaseInfo.setApproveTime(new Date());
		bPbcAppliBaseInfo.setAppDate(ScfDateUtil.getStringDate(new Date())); // 登记时间
		bPbcAppliBaseInfo.setAppTlrcd(debtInfo.getTlrcd());// 登记人

		bPbcAppliBaseInfo.setStartTime(new Date()); // 流程启动时间
		if (StringUtil.isEmpty(bPbcAppliBaseInfo.getStratDate())) {
			bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date())); // 流程启动日期
		}
		bPbcAppliBaseInfo.setStartBrcode(debtInfo.getBrcode()); // 流程发起机构
		bPbcAppliBaseInfo.setStartTlrcd(debtInfo.getTlrcd()); // 流程启动人
		try {
			//iBPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			bPbcAppliBaseInfoDAO.insertSelective(bPbcAppliBaseInfo);
		} catch (Exception e) {// SCF_REC_BCP_10023 申请信息新增失败！
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10023),
					RBcpErrorConstant.SCF_REC_BCP_10023);
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
		rBcpAppliBussInfo2.setTlrcd(debtInfo.getTlrcd());// 创建人，操作员
		rBcpAppliBussInfo2.setBrcode(debtInfo.getBrcode());// 设置经办机构信息
		rBcpAppliBussInfo2.setReduceAmount(totalReduce);//减免金额
		rBcpAppliBussInfo2.setTotalReduce(totalReduce);//减免金额
		rBcpAppliBussInfo2.setReceiveAmount(receiveAmount);//收费金额
		rBcpAppliBussInfo2.setTotalFee(totalFee);//费用总额
		rBcpAppliBussInfo2.setTotalDebtAmount(totalDebtAmount);
		rBcpAppliBussInfo2.setDebtNum(rcpAppliBussInfo.getDebtNum());
		rBcpAppliBussInfo2.setPurchaseDate(rcpAppliBussInfo.getPurchaseDate());
		rBcpAppliBussInfo2.setBussType(debtInfo.getSupplyChainPdId());
		try {
			rBcpAppliBussInfoDAO.insert(rBcpAppliBussInfo2);
		} catch (Exception e) {// SCF_REC_BCP_10024 ，新增应收账款业务流水信息失败！
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10024),
					RBcpErrorConstant.SCF_REC_BCP_10024);
		}

		// 6.新增应收账款转让费用信息
		// 注意费用信息的brcode不是经办机构而是页面上的费用网点对应的经办机构信息
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut();
		BeanUtils.copyProperties(costInfo, rBcpAppliCostOut2);
		rBcpAppliCostOut2.setAppno(appno);// 申请号
		rBcpAppliCostOut2.setInsertDate(insertDate);// 登记时间
		rBcpAppliCostOut2.setId(UUIDGeneratorUtil.generate());// id
		rBcpAppliCostOut2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
		rBcpAppliCostOut2.setStatus(RBcpDebtConstant.CHARGE_STATUS_UNCHARGED);// 费用收取状态为未收
		rBcpAppliCostOut2.setBussType(debtInfo.getSupplyChainPdId());// 设置业务品种
		rBcpAppliCostOut2.setReduceAmt(totalReduce);
		rBcpAppliCostOut2.setReceiveAmount(receiveAmount);
		rBcpAppliCostOut2.setTotalAmt(totalFee);
		BSysAcctBctl bSysAcctBctl=new BSysAcctBctl();
		bSysAcctBctl.setStatus("1");
		Page page=bSysAcctBctlService.findBSysAcctBctlByPage(1,10,bSysAcctBctl);
		if(page!=null){
			List<RSysAcctBctl> costList=page.getRecords();
			if(costList!=null&&costList.size()>0){
				String brcode=costList.get(0).getBrcode();
				rBcpAppliCostOut2.setBrcode(brcode);
			}
		}
		//rBcpAppliCostOut2.setTlrcd(tlrcd);// 创建人，操作员
		try {
			rBcpAppliCostOutDAO.insert(rBcpAppliCostOut2);// 新增应收账款转让对应的费用信息
		} catch (Exception e) {// SCF_REC_BCP_10036 ,应收账款业务费用信息新增失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10036),
					RBcpErrorConstant.SCF_REC_BCP_10036);
		}
		// 7.新增应收账款明细信息，改变对应的应收账款基本信息锁定状态和锁定申请号
		for (RBcpAppliBussDtl rBcpAppliBussDtl : ds) {// 遍历新增应收账款转让的明细信息。
			// 新增的时候传过来的明细信息数据的ID就是RBcpDebtBaseInfo的ID
			RBcpDebtBaseInfo rBcpDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByBillsNo(rBcpAppliBussDtl.getBillsNo());
			if (rBcpDebtBaseInfo != null) {
					//throw new ScubeBizException("凭证编号为" + rBcpDebtBaseInfo.getBillsNo() + "的应收账款基本信息已经已存在，无法再次转让！");
				if(RBcpDebtConstant.INVOICE_STATUS_ENTRY.equals(rBcpDebtBaseInfo.getStatus())&&RBcpDebtConstant.IS_LOCKED_FALSE.equals(rBcpDebtBaseInfo.getIsLocked())){
				String id=rBcpDebtBaseInfo.getId();
				BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpDebtBaseInfo);
				// 池融资页面已经传了poolFlag
				rBcpDebtBaseInfo.setId(id);
				rBcpDebtBaseInfo.setInsertDate(insertDate);// 录入时间
				rBcpDebtBaseInfo.setPurchaseDate(insertDate);
				rBcpDebtBaseInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);// 锁定状态
				rBcpDebtBaseInfo.setLockAppno(appno);
				rBcpDebtBaseInfo.setIssueFlag(RBcpDebtConstant.ISSUE_FLAG_TPYE_FALSE);// 无商纠
				rBcpDebtBaseInfo.setOverdueFlag(RBcpDebtConstant.OVERDUE_FLAG_NORMAL);// 无逾期
				rBcpDebtBaseInfo.setFlawFlag(RBcpDebtConstant.FLAW_FLAG_FALSE);// 无瑕疵
				rBcpDebtBaseInfo.setStatus(RBcpDebtConstant.INVOICE_STATUS_ENTRY);// 状态为已录入01
				rBcpDebtBaseInfo.setIssueTimes(RBcpDebtConstant.R_BCP_ISSUETIMES);// 商纠次数0
				rBcpDebtBaseInfo.setBadFlag(RBcpDebtConstant.BAD_FLAG_TYPE_FALSE);
				rBcpDebtBaseInfo.setOverdueFlag(RBcpDebtConstant.OVERDUE_FLAG_NORMAL);
				rBcpDebtBaseInfo.setLoanOverdueFlag(RBcpDebtConstant.LOAN_OVERDUE_FLAG_NORMAL);
				rBcpDebtBaseInfo.setCnameBuyer(buycrmBase.getCname());
				rBcpDebtBaseInfo.setCustcdBuyer(buycrmBase.getCustcd());
				rBcpDebtBaseInfo.setCustcdSaller(sellcrmBase.getCustcd());
				rBcpDebtBaseInfo.setCnameSeller(sellcrmBase.getCname());
				rBcpDebtBaseInfo.setBussType(debtInfo.getSupplyChainPdId());
				rBcpDebtBaseInfo.setMastContno(debtInfo.getDebtContno());
				rBcpDebtBaseInfo.setRemainingAmount(rBcpAppliBussDtl.getBillsAmount());
				rBcpDebtBaseInfo.setRemainingUseableAmount(rBcpAppliBussDtl.getBillsAmount());
				rBcpDebtBaseInfo.setFactType(debtInfo.getFactType());
				rBcpDebtBaseInfo.setDeadline(rBcpAppliBussDtl.getDeadline());
				rBcpDebtBaseInfo.setGracePeriod(ext.getDebtGraceDays());
				rBcpDebtBaseInfo.setAging(ext.getLoanDays().toString());
				rBcpDebtBaseInfo.setLoanRemainingAmount(new BigDecimal(0));
				iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);
				}else{
					throw new ScubeBizException("凭证编号为" + rBcpDebtBaseInfo.getBillsNo() + "的应收账款基本信息已经已存在，无法再次转让！");
	
				}
			} else {
				rBcpDebtBaseInfo=new RBcpDebtBaseInfo();
				BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpDebtBaseInfo);
				// 池融资页面已经传了poolFlag
				rBcpDebtBaseInfo.setInsertDate(insertDate);// 录入时间
				rBcpDebtBaseInfo.setPurchaseDate(insertDate);
				rBcpDebtBaseInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);// 锁定状态
				rBcpDebtBaseInfo.setLockAppno(appno);
				rBcpDebtBaseInfo.setIssueFlag(RBcpDebtConstant.ISSUE_FLAG_TPYE_FALSE);// 无商纠
				rBcpDebtBaseInfo.setOverdueFlag(RBcpDebtConstant.OVERDUE_FLAG_NORMAL);// 无逾期
				rBcpDebtBaseInfo.setFlawFlag(RBcpDebtConstant.FLAW_FLAG_FALSE);// 无瑕疵
				rBcpDebtBaseInfo.setStatus(RBcpDebtConstant.INVOICE_STATUS_ENTRY);// 状态为已录入01
				rBcpDebtBaseInfo.setIssueTimes(RBcpDebtConstant.R_BCP_ISSUETIMES);// 商纠次数0
				rBcpDebtBaseInfo.setBadFlag(RBcpDebtConstant.BAD_FLAG_TYPE_FALSE);
				rBcpDebtBaseInfo.setOverdueFlag(RBcpDebtConstant.OVERDUE_FLAG_NORMAL);
				rBcpDebtBaseInfo.setLoanOverdueFlag(RBcpDebtConstant.LOAN_OVERDUE_FLAG_NORMAL);
				rBcpDebtBaseInfo.setCnameBuyer(buycrmBase.getCname());
				rBcpDebtBaseInfo.setCustcdBuyer(buycrmBase.getCustcd());
				rBcpDebtBaseInfo.setCustcdSaller(sellcrmBase.getCustcd());
				rBcpDebtBaseInfo.setCnameSeller(sellcrmBase.getCname());
				rBcpDebtBaseInfo.setBussType(debtInfo.getSupplyChainPdId());
				rBcpDebtBaseInfo.setMastContno(debtInfo.getDebtContno());
				rBcpDebtBaseInfo.setRemainingAmount(rBcpAppliBussDtl.getBillsAmount());
				rBcpDebtBaseInfo.setRemainingUseableAmount(rBcpAppliBussDtl.getBillsAmount());
				rBcpDebtBaseInfo.setFactType(debtInfo.getFactType());
				rBcpDebtBaseInfo.setId(UUIDGeneratorUtil.generate());
				rBcpDebtBaseInfo.setDeadline(rBcpAppliBussDtl.getDeadline());
				rBcpDebtBaseInfo.setGracePeriod(ext.getDebtGraceDays());
				rBcpDebtBaseInfo.setAging(ext.getLoanDays().toString());
				rBcpDebtBaseInfo.setLoanRemainingAmount(new BigDecimal(0));
			    iRBcpDebtBaseInfoDAO.insert(rBcpDebtBaseInfo);
				
			}
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			//ScfCommonUtil.setCommonField(rBcpAppliBussDtl);// 设置公共字段
			
			BeanUtils.copyProperties(rBcpDebtBaseInfo, rBcpAppliBussDtl2);
			rBcpAppliBussDtl2.setAppno(appno);// 申请号
			rBcpAppliBussDtl2.setInsertDate(insertDate);// 登记时间
			rBcpAppliBussDtl2.setId(UUIDGeneratorUtil.generate());// id
			rBcpAppliBussDtl2.setDebtId(rBcpDebtBaseInfo.getId());// 对应的应收账款基本信息的ID
			rBcpAppliBussDtl2.setBillsDate(rBcpDebtBaseInfo.getBillsDate());// 应收账款日期（从应收账款基本信息表中查出来的）
			rBcpAppliBussDtl2.setDebtEnd(rBcpDebtBaseInfo.getDebtEnd());// 应收账款到期日
			rBcpAppliBussDtl2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
			rBcpAppliBussDtl2.setBrcode(debtInfo.getBrcode());// 设置经办机构信息
			rBcpAppliBussDtl2.setTlrcd(debtInfo.getTlrcd());// 创建人
			rBcpAppliBussDtl2.setLastUpdTlrcd(debtInfo.getTlrcd());//最后更新人
			rBcpAppliBussDtl2.setCrtTime(new Date());
			rBcpAppliBussDtl2.setLastUpdTime(new Date());
		    rBcpAppliBussDtl2.setLastUpdBrcode(debtInfo.getBrcode());
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

	@Transactional
	@Override
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(String ifspAppno) throws ScubeBizException {
		if (StringUtil.isEmpty(ifspAppno)) {
			log.info("ifspAppno不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20020), BLanErrorConstant.SCF_BAS_LAN_20020);
		}
		
		return iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByIfspAppno(ifspAppno);
         
	}
}
