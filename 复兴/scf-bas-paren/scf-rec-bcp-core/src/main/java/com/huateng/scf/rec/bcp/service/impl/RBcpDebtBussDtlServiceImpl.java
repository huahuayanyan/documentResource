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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfGlobalInfoUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample.Criteria;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月7日上午10:17:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月7日上午10:17:01	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("RBcpDebtBussDtlServiceImpl")
public class RBcpDebtBussDtlServiceImpl implements IRBcpDebtBussDtlService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO iRBcpDebtBussDtlDAO;
	// 产品工厂转译业务品种名称
	@Resource(name = "bPrdInfoService")
	IBPrdInfoService iBPrdInfoService;
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;
	@Resource(name = "rBcpDebtBaseInfoService")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;

	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO rBcpDebtBaseInfoDAO;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bbrpprdfactoringservice;

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bcntdebtinfoservice;

	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rbcpdebtpoolservice;

	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rbcpdebtbussinfoservice;

	@Resource(name = "RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rbcpdebtbussdtlservice;

	// 应收账款凭证票据明细信息新增(不需要新增时默认为已录入的申请类型。)
	@Override
	@Transactional
	public String addRBcpDebtBussDtl(RBcpDebtBussDtl rBcpDebtBussDtl) {
		if (rBcpDebtBussDtl != null && !"".equals(rBcpDebtBussDtl)) {
			// 添加时候申请类型默认为录入00，申请编号为流水号。操作员，经办机构，录入时间都是要初始化的。
			rBcpDebtBussDtl.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
			rBcpDebtBussDtl.setTlrcd(ContextHolder.getUserInfo().getTlrNo());// 创建人，操作员
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String insertTime = simpleDateFormat.format(new Date());
			rBcpDebtBussDtl.setInsertDate(insertTime);// 录入时间
			String appno = bSysSerialNoService.genSerialNo(RBcpDebtConstant.R_BCP_DEBT_DTL_APPLY_NO);// 申请流水号
			rBcpDebtBussDtl.setAppno(appno);
			rBcpDebtBussDtl.setId(UUIDGeneratorUtil.generate());
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl rBcpDebtBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl();
			try {
				BeanUtils.copyProperties(rBcpDebtBussDtl, rBcpDebtBussDtl2);
			} catch (Exception e) {// 10001 = 转换异常！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
						RBcpErrorConstant.SCF_REC_BCP_10001);
			}
			try {
				iRBcpDebtBussDtlDAO.insert(rBcpDebtBussDtl2);
				return null;
			} catch (Exception e) {// 10012 应收账款单据信息新增失败!
				System.out.println("" + e);
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10012),
						RBcpErrorConstant.SCF_REC_BCP_10012);
			}
		} else {// 10013 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10013),
					RBcpErrorConstant.SCF_REC_BCP_10013);
		}
	}

	// 应收账款凭证票据信息删除，现在先不用删除。(用凭证编号删除。)
	@Override
	@Transactional
	public int deleteRBcpDebtBussDtl(String debtId) {
		if (debtId != null && !"".equals(debtId)) {
			RBcpDebtBussDtlExample rBcpDebtBussDtlExample = new RBcpDebtBussDtlExample();
			Criteria criteria = rBcpDebtBussDtlExample.createCriteria();
			criteria.andDebtIdEqualTo(debtId);
			try {
				return iRBcpDebtBussDtlDAO.deleteByExample(rBcpDebtBussDtlExample);
			} catch (Exception e) {
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10017),
						RBcpErrorConstant.SCF_REC_BCP_10017);
			}
		} else {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10013),
					RBcpErrorConstant.SCF_REC_BCP_10013);
		}
	}

	// 应收账款凭证单据明细信息修改（现在用不到。）
	@Override
	@Transactional
	public int updateRBcpDebtBussDtl(RBcpDebtBussDtl rBcpDebtBussDtl) {
		if (rBcpDebtBussDtl != null && !"".equals(rBcpDebtBussDtl)) {
			if (rBcpDebtBussDtl.getId() != null && !"".equals(rBcpDebtBussDtl.getId())) {
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl rBcpDebtBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl();
				try {
					BeanUtils.copyProperties(rBcpDebtBussDtl, rBcpDebtBussDtl2);
				} catch (Exception e) {// 10001 = 转换异常！
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
							RBcpErrorConstant.SCF_REC_BCP_10001);
				}
				try {
					return iRBcpDebtBussDtlDAO.updateByPrimaryKeySelective(rBcpDebtBussDtl2);

				} catch (Exception e) { // 10014=应收账款凭证票据信息修改失败！
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10014),
							RBcpErrorConstant.SCF_REC_BCP_10014);
				}
			} else {// 前台所传数据无效！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10013),
						RBcpErrorConstant.SCF_REC_BCP_10013);
			}
		} else {// 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10013),
					RBcpErrorConstant.SCF_REC_BCP_10013);
		}
	}

	// 查询具体应收账款凭证票据信息
	@Override
	public RBcpDebtBussDtl findRBcpDebtBussDtlByKey(RBcpDebtBussDtl rBcpDebtBussDtl) {
		// TODO Auto-generated method stub
		return null;
	}

	// 分页条件查询应收账款凭证票据信息(页面应收账款历程信息查询方法。)
	@Override
	public Page findRBcpDebtBussDtlPageByPage(int pageNo, int pageSize, RBcpDebtBussDtl rBcpDebtBussDtl) {
		Page p = new Page(pageSize, pageNo, 0);
		RBcpDebtBussDtlExample example = new RBcpDebtBussDtlExample();
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample.Criteria criteria = example.createCriteria();
		if (rBcpDebtBussDtl != null && !"".equals(rBcpDebtBussDtl)) {
			// 获得页面的应收账款基本信息id
			if (rBcpDebtBussDtl.getDebtId() != null && !"".equals(rBcpDebtBussDtl.getDebtId())) {
				criteria.andDebtIdEqualTo(rBcpDebtBussDtl.getDebtId());
			}
			// 根据ID
			if (rBcpDebtBussDtl.getId() != null && !"".equals(rBcpDebtBussDtl.getDebtId())) {
				criteria.andIdEqualTo(rBcpDebtBussDtl.getId());
			}
			// 根据凭证编号 billsNo(这里是应收账款编号)
			if (rBcpDebtBussDtl.getBillsNo() != null && !"".equals(rBcpDebtBussDtl.getBillsNo())) {
				criteria.andBillsNoEqualTo(rBcpDebtBussDtl.getBillsNo());
			}
			// example.setOrderByClause("INSERT_DATE desc");
		}
		try {
			example.setOrderByClause("APPNO DESC");
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> page = iRBcpDebtBussDtlDAO.selectByPage(example, p);
			if (page == null || page.size() == 0) {// 没有对应数据直接返回空值
				ArrayList<RBcpDebtBussDtl> list2 = new ArrayList<RBcpDebtBussDtl>();
				p.setRecords(list2);
				return p;
			}

			// 设置页面交易金额和业务品种名称
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl rBcpDebtBussDtl1 : page) {
				String applyType = rBcpDebtBussDtl1.getApplyType();
				if (applyType != null) {
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_ENTRY)) {// 发票录入
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getBillsAmount());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_PURCHASE)) {// 发票承购
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getBillsAmount());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_IN_POOL)) {// 发票入池
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_OUT_POOL)) {// 发票出池
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_DISCOUNT)) {// 发票折让
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getRebateAmount());
					}

					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_REPURCHASE)) {// 发票回购
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getBuyBackAmount());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_VERIFY)) {// 发票核销
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_INVOICE_AGE_CHANGE)) {// 发票账龄变更
						rBcpDebtBussDtl1.setMoney2(new BigDecimal("0"));
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_REPAYMENT)) {// 还款
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getPayAmount());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_ISSUE_SET)) {// 发票商纠设定
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}

					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_INVOICE_FINANCING)) {// 发票融资,放款
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_BILL_MODIFY)) {// 发票修改
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getBillsAmount());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_ISSUE_REMOVE)) {// 发票商纠解除
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_COLLECTION)) {// 催收
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getLoanRemainingAmount());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_INVOICE_COST_RECORD)) {// 后收费用录取
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_AFTER_COST_CHARGE)) {// 后收费用收取
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
				}
				if (rBcpDebtBussDtl1.getBussType() != null && !"".equals(rBcpDebtBussDtl1.getBussType())) {// 翻译品种类型
					// 查询对应的业务产品名称 bussTypeName iBPrdInfoService
					try {
						BPrdInfo bPrdInfo = new BPrdInfo();
						bPrdInfo.setProductId(rBcpDebtBussDtl1.getBussType());
						BPrdInfo bPrdInfo2 = iBPrdInfoService.findBPrdInfoByKey(bPrdInfo);
						rBcpDebtBussDtl1.setBussTypeName(bPrdInfo2.getProductName());
					} catch (Exception e) {
						throw new ScubeBizException(
								com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10015),
								RBcpErrorConstant.SCF_REC_BCP_10015);
					}
				}
			}
			p.setRecords(page);
			return p;

		} catch (Exception e) {// 分页条件查询应收账款凭证票据信息失败！
			System.out.println(e);
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10016),
					RBcpErrorConstant.SCF_REC_BCP_10016);
		}
	}

	@Override
	public RBcpDebtBussInfo saveDebtChargeBussInfo(DebtBussInfoVO debtVO) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 提交流水表详细信息写入---商纠设定
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void disputeInvoiceSetSubmit(List insertDebtList, RBcpDebtBussInfo tblDebtBussInfo, String financingType) {
		// ScfGlobalInfo gb = ScfGlobalInfoUtil.getScfGlobalInfo();
		RBcpAppliBussDtl baseDebtVo = null;
		String poolFlag = DebtConstants.POOL_FLAG_IN_POOL;//

		if ("2".equals(financingType)) {// 商纠设定后自动出池
			poolFlag = DebtConstants.POOL_FLAG_OUT_POOL;//
		}
		for (int i = 0; i < insertDebtList.size(); i++) {
			baseDebtVo = (RBcpAppliBussDtl) insertDebtList.get(i);
			RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
			// rBcpDebtBaseInfo.setId(baseDebtVo.getId());
			rBcpDebtBaseInfo.setId(baseDebtVo.getDebtId());
			RBcpDebtBaseInfo tblDebtBaseInfo = rBcpDebtBaseInfoService.findRBcpDebtBaseInfoByKey(rBcpDebtBaseInfo);
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl tblDebtBussDetail = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl();
			BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);
			String uuid = "SJDJ" + ScfDateUtil.formatDate(new Date()) + "01" + UUIDGeneratorUtil.generate(tblDebtBussDetail).substring(26);
			tblDebtBussDetail.setId(uuid);
			tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
			tblDebtBussDetail.setApplyType(tblDebtBussInfo.getApplyType());
			tblDebtBussDetail.setAppno(tblDebtBussInfo.getAppno());
			tblDebtBussDetail.setBussType(baseDebtVo.getBussType());
			tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			tblDebtBussDetail.setMoney(baseDebtVo.getMoney());
			tblDebtBussDetail.setIssueFlag(DebtConstants.ISSUE_FLAG_TPYE_TRUE);// 有
			// DebtConstants.ISSUE_FLAG_TRUE
			tblDebtBussDetail.setIssueReason(baseDebtVo.getIssueReason());
			tblDebtBussDetail.setOtherReason(baseDebtVo.getOtherReason());
			tblDebtBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));
			// 转换date 为timeStamp
			tblDebtBussDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));
			if (StringUtils.isNotBlank(tblDebtBaseInfo.getPoolFlag())) {
				tblDebtBussDetail.setPoolFlag(poolFlag);
			}
			iRBcpDebtBussDtlDAO.insertSelective(tblDebtBussDetail);
			// 更新发票
			if (StringUtils.isNotBlank(tblDebtBaseInfo.getPoolFlag())) {
				tblDebtBaseInfo.setPoolFlag(poolFlag);
			}
			tblDebtBaseInfo.setBussType(tblDebtBussInfo.getBussType());
			tblDebtBaseInfo.setIssueFlag(DebtConstants.ISSUE_FLAG_TRUE);// DebtConstants.ISSUE_FLAG_TRUE
			tblDebtBaseInfo.setIssueReason(baseDebtVo.getIssueReason());
			tblDebtBaseInfo.setOtherReason(baseDebtVo.getOtherReason());
			tblDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// SCFConstants.UNLOCKED
			tblDebtBaseInfo.setLockAppno(null);
			// tblDebtBaseInfo.setLockAppno("");
			// 商纠次数加一
			tblDebtBaseInfo.getIssueTimes();
			int oldIssueTimes = tblDebtBaseInfo.getIssueTimes() == null ? 0 : tblDebtBaseInfo.getIssueTimes();
			tblDebtBaseInfo.setIssueTimes(oldIssueTimes + 1);
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
			BeanUtils.copyProperties(tblDebtBaseInfo, rBcpDebtBaseInfo2);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo2);
			return;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void saveDebtOutPoolInfoDtl(List insertDebtList, RBcpDebtBussInfo tblDebtBussInfo) {

		UserInfo gb = ContextHolder.getUserInfo();
		RBcpAppliBussDtl baseDebtVo = null;
		for (int i = 0; i < insertDebtList.size(); i++) {
			baseDebtVo = (RBcpAppliBussDtl) insertDebtList.get(i);
			RBcpDebtBaseInfo tblDebtBaseInfo = rBcpDebtBaseInfoService.get(baseDebtVo.getId());
			RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);
			String uuid = UUIDGeneratorUtil.generate(tblDebtBussDetail);
			tblDebtBussDetail.setId(uuid);
			tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
			tblDebtBussDetail.setApplyType(tblDebtBussInfo.getApplyType());
			tblDebtBussDetail.setAppno(tblDebtBussInfo.getAppno());
			tblDebtBussDetail.setBussType(tblDebtBussInfo.getBussType());
			tblDebtBussDetail.setTlrcd(gb.getTlrNo());
			tblDebtBussDetail.setBrcode(gb.getBrNo());
			tblDebtBussDetail.setMoney(tblDebtBaseInfo.getRemainingAmount());
			if ((tblDebtBussInfo.getApplyType()).equals(com.huateng.scf.bas.sys.constant.DebtConstants.APPLY_TYPE_IN_POOL)) {// 入池
				tblDebtBussDetail.setIssueFlag(com.huateng.scf.bas.sys.constant.DebtConstants.ISSUE_FLAG_FALSE);// 无
			} else {
				tblDebtBussDetail.setIssueFlag(com.huateng.scf.bas.sys.constant.DebtConstants.ISSUE_FLAG_TRUE);// 有
			}
			tblDebtBussDetail.setIssueReason(baseDebtVo.getIssueReason());
			tblDebtBussDetail.setOtherReason(baseDebtVo.getOtherReason());
			tblDebtBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));
			tblDebtBussDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));
			this.addRBcpDebtBussDtl(tblDebtBussDetail);
		}

	}

	@Override
	@Transactional
	public void saveDebtOutPoolInfoDtl2(List insertDebtList, RBcpDebtBussInfo tblDebtBussInfo) {

		UserInfo gb = ContextHolder.getUserInfo();
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo baseDebtVo = null;
		for (int i = 0; i < insertDebtList.size(); i++) {
			baseDebtVo = (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo) insertDebtList.get(i);
			RBcpDebtBaseInfo tblDebtBaseInfo = rBcpDebtBaseInfoService.get(baseDebtVo.getId());
			RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);
			String uuid = UUIDGeneratorUtil.generate(tblDebtBussDetail);
			tblDebtBussDetail.setId(uuid);
			tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
			tblDebtBussDetail.setApplyType(tblDebtBussInfo.getApplyType());
			tblDebtBussDetail.setAppno(tblDebtBussInfo.getAppno());
			tblDebtBussDetail.setBussType(tblDebtBussInfo.getBussType());
			tblDebtBussDetail.setTlrcd(gb.getTlrNo());
			tblDebtBussDetail.setBrcode(gb.getBrNo());
			tblDebtBussDetail.setMoney(tblDebtBaseInfo.getRemainingAmount());
			if ((tblDebtBussInfo.getApplyType()).equals(com.huateng.scf.bas.sys.constant.DebtConstants.APPLY_TYPE_IN_POOL)) {// 入池
				tblDebtBussDetail.setIssueFlag(com.huateng.scf.bas.sys.constant.DebtConstants.ISSUE_FLAG_FALSE);// 无
			} else {
				tblDebtBussDetail.setIssueFlag(com.huateng.scf.bas.sys.constant.DebtConstants.ISSUE_FLAG_TRUE);// 有
			}
			tblDebtBussDetail.setIssueReason(baseDebtVo.getIssueReason());
			tblDebtBussDetail.setOtherReason(baseDebtVo.getOtherReason());
			tblDebtBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));
			tblDebtBussDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));
			this.addRBcpDebtBussDtl(tblDebtBussDetail);
		}

	}

	/**
	 * 应收账款入池流水明细新增
	 *
	 * @author lu.chen
	 * @date 2011-10-12
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public void updateInpoolInfo(List<RBcpDebtBaseInfo> insertDebtList, DebtBussInfoVO debtVO_p) throws ScubeBizException {
		// DebtBillsInfoVO debtVO = new DebtBillsInfoVO();
		for (RBcpDebtBaseInfo baseInfo : insertDebtList) {
			RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(baseInfo, tblDebtBussDetail);

			tblDebtBussDetail.setId(UUIDGeneratorUtil.generate());
			tblDebtBussDetail.setDebtId(baseInfo.getId());
			tblDebtBussDetail.setBussType(baseInfo.getBussType());
			tblDebtBussDetail.setAppno(debtVO_p.getAppno());
			tblDebtBussDetail.setMastContno(debtVO_p.getMastContno());
			tblDebtBussDetail.setCustcdBuyer(debtVO_p.getCustcdBuyer());
			tblDebtBussDetail.setCustcdSaller(debtVO_p.getCustcdSaller());
			tblDebtBussDetail.setApplyType(DebtConstants.APPLY_TYPE_IN_POOL);
			// tblDebtBussDetail.setInsertDate(ScfDateUtil.formatDate(debtVO_p.getInpoolDate()));
			tblDebtBussDetail.setBillsNo(baseInfo.getBillsNo());
			tblDebtBussDetail.setPurchaseDate(baseInfo.getPurchaseDate());
			tblDebtBussDetail.setBillsDate(baseInfo.getBillsDate());
			tblDebtBussDetail.setDebtEnd(baseInfo.getDebtEnd());
			tblDebtBussDetail.setCurcd(baseInfo.getCurcd());
			BigDecimal billsAmount = baseInfo.getBillsAmount() == null ? new BigDecimal("0") : baseInfo.getBillsAmount();
			tblDebtBussDetail.setBillsAmount(billsAmount);
			BigDecimal remainingAmount = baseInfo.getRemainingAmount() == null ? new BigDecimal("0") : baseInfo.getRemainingAmount();
			tblDebtBussDetail.setRemainingAmount(remainingAmount);
			tblDebtBussDetail.setAging(baseInfo.getAging().toString());
			tblDebtBussDetail.setCnameBuyer(debtVO_p.getCnameBuyer());
			tblDebtBussDetail.setCnameSeller(debtVO_p.getCnameSeller());
			tblDebtBussDetail.setPoolFlag(DebtConstants.POOL_FLAG_IN_POOL);
			tblDebtBussDetail.setMoney(remainingAmount);// 入池金额
			this.addRBcpDebtBussDtl(tblDebtBussDetail);
		}
	}

	/**
	 * 应收账款出池流水明细新增
	 */
	@Override
	public void updateOutpoolInfo(List<DebtBillsInfoVO> insertDebtList, DebtBussInfoVO debtVO_p) throws ScubeBizException {
		// GlobalInfo gb = GlobalInfo.getCurrentInstance();
		DebtBillsInfoVO debtVO = new DebtBillsInfoVO();
		for (int i = 0; i < insertDebtList.size(); i++) {
			debtVO = (DebtBillsInfoVO) insertDebtList.get(i);
			RBcpDebtBaseInfo baseInfo = rBcpDebtBaseInfoService.get(debtVO.getDebtId());
			RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(baseInfo, rBcpDebtBussDtl);
			rBcpDebtBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpDebtBussDtl.setDebtId(baseInfo.getId());
			rBcpDebtBussDtl.setBussType(baseInfo.getBussType());
			rBcpDebtBussDtl.setMastContno(debtVO_p.getMastContno());
			rBcpDebtBussDtl.setCustcdBuyer(debtVO_p.getCustcdBuyer());
			rBcpDebtBussDtl.setCustcdSaller(debtVO_p.getCustcdSaller());
			rBcpDebtBussDtl.setApplyType(DebtConstants.APPLY_TYPE_OUT_POOL);
			rBcpDebtBussDtl.setInsertDate(debtVO_p.getInpoolDate());
			rBcpDebtBussDtl.setAppno(debtVO_p.getAppno());
			rBcpDebtBussDtl.setBillsNo(baseInfo.getBillsNo());
			rBcpDebtBussDtl.setPurchaseDate(baseInfo.getPurchaseDate());
			rBcpDebtBussDtl.setBillsDate(baseInfo.getBillsDate());
			rBcpDebtBussDtl.setDebtEnd(baseInfo.getDebtEnd());
			rBcpDebtBussDtl.setCurcd(baseInfo.getCurcd());
			BigDecimal billsAmount = baseInfo.getBillsAmount() == null ? BigDecimal.ZERO : baseInfo.getBillsAmount();
			rBcpDebtBussDtl.setBillsAmount(billsAmount);
			BigDecimal remainingAmount = baseInfo.getRemainingAmount() == null ? BigDecimal.ZERO : baseInfo.getRemainingAmount();
			rBcpDebtBussDtl.setRemainingAmount(remainingAmount);
			if (StringUtil.isStrNotEmpty(baseInfo.getAging())) {
				rBcpDebtBussDtl.setAging(baseInfo.getAging().toString());
			}

			// tblDebtBussDetail.setCnameBuyer(debtVO_p.getBuyerName());
			// tblDebtBussDetail.setCnameSeller(debtVO_p.getSellerName());
			rBcpDebtBussDtl.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);
			rBcpDebtBussDtl.setMoney(remainingAmount);// 出池金额
			this.addRBcpDebtBussDtl(rBcpDebtBussDtl);
		}

	}

	/**
	 * 催收申请+发票费用补录
	 */
	@Transactional
	@Override
	public void debtPressingSubmit(List<DebtBillsInfoVO> list, RBcpDebtBussInfo rBcpDebtBussInfo) throws ScubeBizException {
		ScfGlobalInfo gb = ScfBaseData.getScfGlobalInfo();
		DebtBillsInfoVO baseDebtVo = null;
		for (int i = 0; i < list.size(); i++) {
			baseDebtVo = (DebtBillsInfoVO) list.get(i);

			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo = rBcpDebtBaseInfoDAO.selectByPrimaryKey(baseDebtVo.getId());
			RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
			if (rBcpDebtBaseInfo != null) {
				BeanUtils.copyProperties(rBcpDebtBaseInfo, rBcpDebtBussDtl);
			}

			rBcpDebtBussDtl.setInsertDate(baseDebtVo.getInsertDate());
			rBcpDebtBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpDebtBussDtl.setDebtId(rBcpDebtBaseInfo.getId());
			rBcpDebtBussDtl.setApplyType(rBcpDebtBussInfo.getApplyType());
			rBcpDebtBussDtl.setAppno(rBcpDebtBussInfo.getAppno());
			// rBcpDebtBussDtl.setBussType(rBcpDebtBussInfo.getBussType());
			rBcpDebtBussDtl.setBussType(rBcpDebtBaseInfo.getBussType());

			rBcpDebtBussDtl.setTlrcd(gb.getTlrNo());
			rBcpDebtBussDtl.setBrcode(gb.getBrCode());
			String pressMode = baseDebtVo.getPressMode() == null ? "" : baseDebtVo.getPressMode().toString();
			rBcpDebtBussDtl.setReason(pressMode);
			rBcpDebtBussDtl.setMoney(baseDebtVo.getMoney() == null ? new BigDecimal("0") : baseDebtVo.getMoney());
			rBcpDebtBussDtl.setInsertDate(ScfDateUtil.formatDate(new Date()));

			rBcpDebtBussDtl.setCommonDate(ScfDateUtil.formatDate(new Date()));

			rBcpDebtBussDtl.setWarnCount(baseDebtVo.getWarnCount());
			rBcpDebtBussDtl.setPressCount(baseDebtVo.getPressCount());

			this.addRBcpDebtBussDtl(rBcpDebtBussDtl);

			if (StringUtils.isNotEmpty(rBcpDebtBussDtl.getDebtId())) {
				rBcpDebtBaseInfoService.lockDebtBaseInfo(rBcpDebtBussDtl.getDebtId(), rBcpDebtBussDtl.getAppno());
			}

		}

	}

	/**
	 * DESCRIPTION:商业纠纷设定申请提交
	 * 
	 * @author mengjiajia
	 * @date 2011-10-20 disputeInvoiceSetSubmitApp 方法
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void disputeInvoiceSetSubmitApp(List insertDebtList, DebtBussInfoVO debtVO) throws ScubeBizException {
		log.debug("bussType:" + debtVO.getBussType());
		debtVO.setApplyType(DebtConstants.APPLY_TYPE_ISSUE_SET);
		// TblDebtBussInfoDAO tblDebtBussInfoDAO =
		// SCFDAOUtils.getTblDebtBussInfoDAO();
		// TblDebtBussDetailDAO tblDebtBussDetailDAO
		// =SCFDAOUtils.getTblDebtBussDetailDAO();

		// 池融资出池相关操作
		BBrpPrdFactoring tblProductFactoring = bbrpprdfactoringservice.findBBrpPrdFactoringByKey(debtVO.getBussType());
		if (tblProductFactoring != null) {
			if (DebtConstants.FINANCING_TYPE_POOL.equals(tblProductFactoring.getFinancingType())) {// 池融资
				// 发票出池
				rBcpDebtBaseInfoService.invoiceOutpoolAddSave(insertDebtList, debtVO);
				// 池信息修改
				List<DebtContVO> list = new ArrayList<DebtContVO>();
				list.add(bcntdebtinfoservice.queryContInfoByMastContno(debtVO.getMastContno()));
				rbcpdebtpoolservice.updateOutpoolInfo(debtVO, list);
				// 明细表修改
				// tblDebtBussDetailDAO.updateOutpoolDisputeInfo(insertDebtList,
				// tblDebtBussInfo);
				debtVO.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);// 出池

				// 添加出池流水信息--主表
				RBcpDebtBussInfo bean = rbcpdebtbussinfoservice.saveDebtOutPoolInfo(debtVO, DebtConstants.APPLY_TYPE_OUT_POOL);// 出池
				// 添加出池流水信息--详细信息表
				rbcpdebtbussdtlservice.saveDebtOutPoolInfoDtl(insertDebtList, bean);
			}

			// 添加业务流水表主表
			BigDecimal amount = new BigDecimal(0);
			if (insertDebtList != null && insertDebtList.size() > 0) {
				Iterator ite = insertDebtList.iterator();
				while (ite.hasNext()) {
					RBcpAppliBussDtl disVO = (RBcpAppliBussDtl) ite.next();
					if (!StringUtil.isEmpty(disVO.getMoney())) {
						amount = amount.add(disVO.getMoney());
					}
				}
				debtVO.setAmount(amount);// 争议总金额
			}
			RBcpDebtBussInfo tblDebtBussInfo = rbcpdebtbussinfoservice.debtBussInfoAdd(debtVO);
			// 添加流水详细信息表//更新发票表
			rbcpdebtbussdtlservice.disputeInvoiceSetSubmit(insertDebtList, tblDebtBussInfo, tblProductFactoring.getFinancingType());
		}
	}

	/*
	 * 提交流水表详细信息写入---商纠设定
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void disputeInvoiceSetSubmit2(List insertDebtList, RBcpDebtBussInfo tblDebtBussInfo, String financingType) {
		ScfGlobalInfo gb = ScfGlobalInfoUtil.getScfGlobalInfo();
		RBcpAppliBussDtl baseDebtVo = null;
		String poolFlag = DebtConstants.POOL_FLAG_IN_POOL;//

		if ("2".equals(financingType)) {// 商纠设定后自动出池
			poolFlag = DebtConstants.POOL_FLAG_OUT_POOL;//
		}
		// 这里不仅要设置出池的明细信息，还要设定商纠设定的明细信息
		for (int i = 0; i < insertDebtList.size(); i++) {
			baseDebtVo = (RBcpAppliBussDtl) insertDebtList.get(i);
			RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
			// rBcpDebtBaseInfo.setId(baseDebtVo.getId());
			rBcpDebtBaseInfo.setId(baseDebtVo.getDebtId());
			RBcpDebtBaseInfo tblDebtBaseInfo = rBcpDebtBaseInfoService.findRBcpDebtBaseInfoByKey(rBcpDebtBaseInfo);
			RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);
			String uuid = "SJDJ" + ScfDateUtil.formatDate(new Date()) + "01" + UUIDGeneratorUtil.generate(tblDebtBussDetail).substring(26);
			tblDebtBussDetail.setId(uuid);
			tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
			tblDebtBussDetail.setApplyType(tblDebtBussInfo.getApplyType());
			tblDebtBussDetail.setAppno(tblDebtBussInfo.getAppno());
			tblDebtBussDetail.setBussType(baseDebtVo.getBussType());
			tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			tblDebtBussDetail.setMoney(baseDebtVo.getMoney());
			tblDebtBussDetail.setIssueFlag(DebtConstants.ISSUE_FLAG_TPYE_TRUE);// 有
			// DebtConstants.ISSUE_FLAG_TRUE
			tblDebtBussDetail.setIssueReason(baseDebtVo.getIssueReason());
			tblDebtBussDetail.setReason(null);// 清空之前可能存在的争议解决方式
			tblDebtBussDetail.setMemo(null);
			tblDebtBussDetail.setOtherReason(baseDebtVo.getOtherReason());
			tblDebtBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));
			// 转换date 为timeStamp
			tblDebtBussDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));
			if (StringUtils.isNotBlank(tblDebtBaseInfo.getPoolFlag())) {
				tblDebtBussDetail.setPoolFlag(poolFlag);
			}
			this.addRBcpDebtBussDtl(tblDebtBussDetail);
			// 更新发票
			if (StringUtils.isNotBlank(tblDebtBaseInfo.getPoolFlag())) {
				tblDebtBaseInfo.setPoolFlag(poolFlag);
			}
			tblDebtBaseInfo.setBussType(tblDebtBussInfo.getBussType());
			tblDebtBaseInfo.setIssueFlag(DebtConstants.ISSUE_FLAG_TRUE);// DebtConstants.ISSUE_FLAG_TRUE
			tblDebtBaseInfo.setIssueReason(baseDebtVo.getIssueReason());
			tblDebtBaseInfo.setReason(null);// 防止存在这个单据中存在之前的争议解决方式，这里应该清空
			tblDebtBaseInfo.setOtherReason(baseDebtVo.getOtherReason());
			tblDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// SCFConstants.UNLOCKED
			tblDebtBaseInfo.setLockAppno(null);
			// tblDebtBaseInfo.setLockAppno("");
			// 商纠次数加一
			tblDebtBaseInfo.getIssueTimes();
			int oldIssueTimes = tblDebtBaseInfo.getIssueTimes() == null ? 0 : tblDebtBaseInfo.getIssueTimes();
			tblDebtBaseInfo.setIssueTimes(oldIssueTimes + 1);
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
			BeanUtils.copyProperties(tblDebtBaseInfo, rBcpDebtBaseInfo2);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo2);
		}
		return;
	}

}
