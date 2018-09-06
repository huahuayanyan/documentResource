package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfChattelCreditService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrBillInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliBillInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanBillBaseInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyBizDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyInfoDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepayApproveCommonService;
import com.huateng.scf.bas.mrn.dao.IBMrnAcctBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeLnciDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeLnci;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月10日下午1:39:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * liph		2016年12月10日下午1:39:20	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BLanRepayApproveCommonServiceImpl")
public class BLanRepayApproveCommonServiceImpl implements IBLanRepayApproveCommonService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO ibPrdInfoDAO;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO ibCrmBaseInfoDAO;
	@Resource(name = "BLanAppliBillInfoDAO")
	IBLanAppliBillInfoDAO ibLanAppliBillInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO ibMrnAppliAcctInfoDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	@Resource(name = "BMrnAcctBussInfoDAO")
	IBMrnAcctBussInfoDAO ibMrnAcctBussInfoDAO;
	@Resource(name = "IBCrrBillInfoDAO")
	IBCrrBillInfoDAO ibCrrBillInfoDAO;
	@Resource(name = "BLanBillBaseInfoDAO")
	IBLanBillBaseInfoDAO ibLanBillBaseInfoDAO;
	@Resource(name = "BCntBuyInfoDAO")
	IBCntBuyInfoDAO ibCntBuyInfoDAO;
	@Resource(name = "BLnaLnciBuyBizDAO")
	IBLanLnciBuyBizDAO ibLanLnciBuyBizDAO;
	@Resource(name = "BLanLnciBuyInfoDAO")
	IBLanLnciBuyInfoDAO ibLanLnciBuyInfoDAO;
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO irBcpAppliBussDtlDAO;
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO irBcpDebtBaseInfoDAO;
	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO irBcpDebtBussDtlDAO;
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO ibCrrGntyConDAO;
	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO ibCntMprotBaseInfoDAO;
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO ibNteNoticeBaseDAO;
	@Resource(name = "BNteNoticeLnciDAO")
	IBNteNoticeLnciDAO ibNteNoticeLnciDAO;
	@Resource(name = "BLanCommonServiceImpl")
	IBLanCommonService ibLanCommonService;
	
	//动产额度处理类
	@Resource(name = "ScfChattelCreditServiceImpl")
	IScfChattelCreditService scfchattelcreditservice;

	// 放款申请审核通过
	@Override
	@Transactional
	public String repayapprove(Map map) {
		String appliType = "";// 流程编号
		String appno = "";
		// 申请表信息判断
		String ccmsappno = (String) map.get("APP_NO");// 信贷申请号
		BPbcAppliBaseInfo bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(ccmsappno);// 信贷申请号
		if (bPbcAppliBaseInfo == null) {
			log.info("申请信息不存在");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20005), BLanErrorConstant.SCF_BAS_LAN_20005);
		} else {
			appliType = bPbcAppliBaseInfo.getAppliType();// 申请类型
			appno = bPbcAppliBaseInfo.getAppno();
			BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(ccmsappno);
			// 判断供应链是否提交审批
			String result = (String) map.get("opinion");
			if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)) {
				if (!WorkflowConstant.APPLI_STATUS_DTL_WAITCMS.equals(bPbcAppliBaseInfo.getAppliStatusDtl())) {
					log.info("供应链未提交审批");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20006),
							BLanErrorConstant.SCF_BAS_LAN_20006);
				}
			} else {// 拒绝
				if (!WorkflowConstant.APPLI_STATUS_DTL_WAITCMS.equals(bPbcAppliBaseInfo.getAppliStatusDtl())) {
					log.info("供应链未提交审批");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20006),
							BLanErrorConstant.SCF_BAS_LAN_20006);
				}
			}
			// -------------------分种类判断------------------
			if (WorkflowConstant.APPLI_TYPE_THREE_BILLPPLI.equals(appliType)) {// 银承--预付类
				if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)) {
					// 更新借据正式表信息--保证金--购销合同，额度释放
					try {
						ibLanCommonService.saveLoanInfo(appno, result, map);
						//ibLanCommonService.upAppliBaseInfo(appno);
					} catch (Exception e) {
						log.info("数据库表操作异常");
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			}
			//先票后货放款
			else if(WorkflowConstant.APPLI_TYPE_FOUR_BILL_APPLY.equals(appliType)
					||WorkflowConstant.APPLI_TYPE_FOUR_LETTER_GUARANTEE_APPLY.equals(appliType)
					||WorkflowConstant.APPLI_TYPE_FOUR_LETTER_GUARANTEE_NO_APPLY.equals(appliType)
					||WorkflowConstant.APPLI_TYPE_FOUR_GUARANTEE_DISCOUNT_APPLY.equals(appliType)
					||WorkflowConstant.APPLI_TYPE_FOUR_CREDIT_APPLY.equals(appliType)
					||WorkflowConstant.APPLI_TYPE_FOUR_LOAN_APPLY.equals(appliType)){
				//更新放款信息
				if(WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)){
					try {
						ibLanCommonService.saveLoanInfo(appno, result, map);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			}
			else if (WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGAPPLY.equals(appliType)) {// 应收类-流贷-国内保理
				if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)) {
					// 更新正式表信息
					try {
						ibLanCommonService.saveLoanInfo(appno, result, map);
						this.updateDebtInfoByAppno(appno, bLanAppliLnciBase);
						this.releaseAppliDebtBaseInfo(appno); // 解锁应收账款
						//ibLanCommonService.upAppliBaseInfo(appno);
					} catch (Exception e) {
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			} else if (WorkflowConstant.APPLI_TYPE_FINANCINGPOOLAPPLY.equals(appliType)) {// 应收-流贷-国内保理池
				if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)) {
					/// 更新信息
					try {
						ibLanCommonService.saveLoanInfo(appno, result, map);
						//ibLanCommonService.upAppliBaseInfo(appno);
					} catch (Exception e) {
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			} else if (WorkflowConstant.APPLI_TYPE_MORTGAGE_CASH_LOAN_APPLY.equals(appliType)// 现货抵押--流贷
					||WorkflowConstant.APPLI_TYPE_MORTGAGE_BILL_LOAN_APPLY.equals(appliType)// 现货抵押--银承
					|| WorkflowConstant.APPLI_TYPE_CAR_MORTGAGE_CASH_LOAN_APPLY.equals(appliType))
			{
				if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)) {
					try {
						ibLanCommonService.saveLoanInfo(appno, result, map);
						this.loanReviewNotice(appno);
						this.updateNoticeStatus(appno, NoticeConstant.NOTICE_TYPE_132, NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
						//ibLanCommonService.upAppliBaseInfo(appno);
					} catch (Exception e) {
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			}
			else if (WorkflowConstant.APPLI_TYPE_BILL_NORMAL_CASH_LOAN_APPLY.equals(appliType)//非标仓单放款-流贷
					||WorkflowConstant.APPLI_TYPE_BILL_NORMAL_BILL_LOAN_APPLY.equals(appliType))//非标仓单放款-银承
			{//普通仓单放款
				if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)) {
					try {
						ibLanCommonService.saveLoanInfo(appno, result, map);
						this.loanReviewNotice(appno);
						this.updateNoticeStatus(appno, NoticeConstant.NOTICE_TYPE_132, NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
						if(ScfBasConstant.FLAG_ON.equals(bLanAppliLnciBase.getHasIndirectCredit())){
							//监管公司额度占用 客户融资额度占用
							scfchattelcreditservice.chattelAppliCreditProcess(appno,ScfBasConstant.BUSINESS_STATUS_APPROVAL_CONFIRM);
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
								BLanErrorConstant.SCF_BAS_LAN_20000);
					}
				}
			}
			if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(result)) {
				try {
					ibLanCommonService.upAppliBaseInfo(appno);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error(e.getMessage());
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
							BLanErrorConstant.SCF_BAS_LAN_20000);
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @Description: 根据appno更新应收账款单据状态
	 * @author liph
	 */
	public void updateDebtInfoByAppno(String appno, BLanAppliLnciBase bLanAppliLnciBase) {
		List list = ibLanLnciBaseDAO.selectByAppno(appno);
		BLanLnciBase bLanLnciBase = new BLanLnciBase();
		if (list != null && list.size() > 0) {
			bLanLnciBase = (BLanLnciBase) list.get(0);
		}
		BCrrLnCon bCrrLnCon = null;
		if (bLanAppliLnciBase != null) {
			bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bLanAppliLnciBase.getMastContno());
		}
		List applist = irBcpAppliBussDtlDAO.selectByAppno(appno);
		if (applist != null && applist.size() > 0) {
			for (int i = 0; i < applist.size(); i++) {
				RBcpAppliBussDtl appliDetail = (RBcpAppliBussDtl) applist.get(i);
				if (appliDetail != null) {
					RBcpDebtBaseInfo rBcpDebtBaseInfo = irBcpDebtBaseInfoDAO.selectByPrimaryKey(appliDetail.getDebtId());
					String BussContcode = "";// 商务合同号
					BigDecimal RemainingAmount = new BigDecimal(0);// 应收账款余额
					if (rBcpDebtBaseInfo != null) {
						BussContcode = rBcpDebtBaseInfo.getBussContcode();
						RemainingAmount = rBcpDebtBaseInfo.getRemainingAmount();
						rBcpDebtBaseInfo.setStatus(RBcpDebtConstant.INVOICE_STATUS_FINANCED);// 已融资
						rBcpDebtBaseInfo.setDebetNo(bLanLnciBase.getDebetId());// 借据号
						rBcpDebtBaseInfo.setLoanWay(bLanLnciBase.getLnciType());// 出账方式
						irBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);
					}
					RBcpDebtBussDtl bussDetail = new RBcpDebtBussDtl();
					bussDetail.setAppno(appliDetail.getAppno());
					bussDetail.setDebtId(appliDetail.getDebtId());
					bussDetail.setApplyType(RBcpDebtConstant.APPLY_TYPE_INVOICE_FINANCING);

					bussDetail.setBussContcode(BussContcode);
					bussDetail.setRemainingAmount(RemainingAmount);

					bussDetail.setBillsNo(appliDetail.getBillsNo());
					bussDetail.setBillsAmount(appliDetail.getBillsAmount());
					bussDetail.setBillsAmountView(appliDetail.getBillsAmountView());
					bussDetail.setRemainingUseableAmount(appliDetail.getRemainingUseableAmount());
					bussDetail.setCurcd(appliDetail.getCurcd());
					bussDetail.setLoanPercent(appliDetail.getLoanPercent());
					bussDetail.setInsertDate(appliDetail.getInsertDate());
					bussDetail.setPurchaseDate(appliDetail.getPurchaseDate());
					bussDetail.setBillsDate(appliDetail.getBillsDate());
					bussDetail.setDebtEnd(appliDetail.getDebtEnd());
					bussDetail.setBillsType(appliDetail.getBillsType());
					bussDetail.setCustcdSaller(appliDetail.getCustcdSaller());
					bussDetail.setBussType(appliDetail.getBussType());
					bussDetail.setCnameBuyer(appliDetail.getCnameBuyer());
					bussDetail.setCnameSeller(appliDetail.getCnameSeller());
					bussDetail.setMoney(bLanLnciBase.getLnciAmt());// 在历程信息中显示交易金额
					if (bCrrLnCon != null) {
						bussDetail.setMastContno(bCrrLnCon.getVidNo());
					}
					bussDetail.setCustcdBuyer(appliDetail.getCustcdBuyer());
					bussDetail.setId(UUIDGeneratorUtil.generate());
					irBcpDebtBussDtlDAO.insert(bussDetail);
				}
			}
		}

	}

	/**
	 * @author liph 根据appno对流程锁定的应收账款进行解锁
	 */
	public void releaseAppliDebtBaseInfo(String appno) {
		List<RBcpAppliBussDtl> list = irBcpAppliBussDtlDAO.selectByAppno(appno);
		for (int i = 0; i < list.size(); i++) {
			RBcpAppliBussDtl applibuss = list.get(i);
			if (!StringUtil.isEmpty(applibuss.getDebtId())) {
				// 发票解锁
				RBcpDebtBaseInfo debtBaseInfo = new RBcpDebtBaseInfo();
				debtBaseInfo = irBcpDebtBaseInfoDAO.selectByPrimaryKey(applibuss.getDebtId());
				if (debtBaseInfo != null) {
					debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
					debtBaseInfo.setLockAppno(null);
					irBcpDebtBaseInfoDAO.updateByPrimaryKey(debtBaseInfo);
				}
			}
		}
	}

	/**
	 * @author liph 修改通知书状态
	 */
	public void loanReviewNotice(String appno) {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		if (bPbcAppliBaseInfo == null) {
			log.info("申请信息获取失败");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002), BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bPbcAppliBaseInfo.getMastContno());
		if (bCrrLnCon == null) {
			log.info("合同信息获取失败");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002), BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		BNteNoticeBase noticeBaseInfo = new BNteNoticeBase();
		BNteNoticeLnci notice = new BNteNoticeLnci();
		String protocolNo = null;
		String businessNo = bCrrLnCon.getVidNo(); // 业务合同号
		BCrrGntyCon bCrrGntyCon = ibCrrGntyConDAO.selectByPrimaryKey(businessNo);// 质押合同号
		if (bCrrGntyCon != null) {
			notice.setRation(bCrrGntyCon.getRation()); // 质押率
			protocolNo = bCrrGntyCon.getPrtclNo();// 监管合同编号
			String noticeType = NoticeConstant.NOTICE_TYPE_132;
			noticeBaseInfo.setId(null);
			noticeBaseInfo.setNum(null);
			noticeBaseInfo.setAppno(appno);
			noticeBaseInfo.setNoticeType(noticeType);
			Map map = new HashMap();
			map.put("protocolNo", protocolNo);
			map.put("onecode", ScfBasConstant.PROTOCOL_PART_ROLE_BANK);// 质权
			map.put("twocode", ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);//// 出质--授信客户
			map.put("threecode", ScfBasConstant.PROTOCOL_PART_ROLE_MONI);// 监管
			List<Map> list = ibCntMprotBaseInfoDAO.selectByCondition(map);
			if (list.size() > 0 && list != null) {
				Map resultMap = list.get(0);
				String no = (String) resultMap.get("NO");
				String thrname = (String) resultMap.get("NAME");
				noticeBaseInfo.setProtocolCode(no);
				noticeBaseInfo.setMoniOfName(thrname); // 监管公司名称
			}
			BMrnAppliAcctInfo bMrnAppliAcctInfo = new BMrnAppliAcctInfo();
			List<BMrnAppliAcctInfo> acctList = ibMrnAppliAcctInfoDAO.selectByAppno(appno);
			if (acctList.size() > 0 && acctList != null) {
				bMrnAppliAcctInfo = acctList.get(0);
				noticeBaseInfo.setAccountNo(bMrnAppliAcctInfo.getBailAccountno());// 保证金账号
			}
			noticeBaseInfo.setSlaveContno(bPbcAppliBaseInfo.getSlaveContno());
			noticeBaseInfo.setSlaveContcode(bPbcAppliBaseInfo.getSlaveContno());
			noticeBaseInfo.setCustcd(bPbcAppliBaseInfo.getCustcd());
			noticeBaseInfo.setProtocolNo(protocolNo);
			noticeBaseInfo.setMastContno(bPbcAppliBaseInfo.getMastContno());
			noticeBaseInfo.setCommonAmt(bPbcAppliBaseInfo.getAmt());
			noticeBaseInfo.setBrcode(bPbcAppliBaseInfo != null ? bPbcAppliBaseInfo.getStartBrcode() : "");// 分支行名称
			noticeBaseInfo.setTlrn(bPbcAppliBaseInfo != null ? bPbcAppliBaseInfo.getStartTlrcd() : "");// 申请客户经理
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(new Date());
			noticeBaseInfo.setAppliDate(date);
			noticeBaseInfo.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
			if (StringUtil.isEmpty(noticeBaseInfo.getId())) {
				noticeBaseInfo.setId(UUIDGeneratorUtil.generate());
			}
			String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_FKQR_T_NOTICE_NO);
			if (StringUtil.isEmpty(noticeBaseInfo.getNum())) {
				noticeBaseInfo.setNum(noticeNo);
			}
			String pid = noticeBaseInfo.getId();
			ibNteNoticeBaseDAO.insert(noticeBaseInfo);

			notice.setPid(pid);
			notice.setAppno(appno);// 业务流水号
			notice.setStartDate(bLanAppliLnciBase.getStartDate());// 起始日期
			notice.setEndDate(bLanAppliLnciBase.getEndDate());// 结束日期
			notice.setDebetId(bLanAppliLnciBase.getDebetId());// 借据号
			notice.setLoanWay(bLanAppliLnciBase.getLnciType());// 出账方式
			notice.setSlaveLimit(bLanAppliLnciBase.getSlaveLimit());// 填平敞口日期
			notice.setBailAmount(bLanAppliLnciBase.getBailAmount());// 保证金金额
			notice.setBailAccountNo(bLanAppliLnciBase.getBailAccount());// 保证金帐户号
			notice.setRate(bLanAppliLnciBase.getRate());// 利率
			notice.setRiskAmount(bLanAppliLnciBase.getRiskAmt());// 本笔风险敞口
			notice.setFirstBailRatio(bLanAppliLnciBase.getFirstBailRatio());// 现金等价物初始比例(%)
			notice.setId(UUIDGeneratorUtil.generate());
			ibNteNoticeLnciDAO.insert(notice);
		}
	}

	/**
	 * 更新通知书状态
	 */
	@Override
	public void updateNoticeStatus(String appno, String noticeType, String status) {
		BNteNoticeBase bNoticeBase = new BNteNoticeBase();
		bNoticeBase.setAppno(appno);
		bNoticeBase.setNoticeType(noticeType);
		List<BNteNoticeBase> list = ibNteNoticeBaseDAO.selectByCondition(bNoticeBase);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				BNteNoticeBase base = list.get(i);
				BNteNoticeBase bNteNoticeBase = ibNteNoticeBaseDAO.selectByPrimaryKey(base.getId());
				bNteNoticeBase.setStatus(status);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String date = sdf.format(new Date());
				bNteNoticeBase.setSignDate(date);
				ibNteNoticeBaseDAO.updateByPrimaryKey(bNteNoticeBase);
			}
		}
	}
}
