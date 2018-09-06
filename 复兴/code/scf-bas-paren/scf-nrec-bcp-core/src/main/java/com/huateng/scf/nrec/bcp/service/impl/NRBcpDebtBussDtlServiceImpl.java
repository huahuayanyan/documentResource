/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample.Criteria;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
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
@Service("NRBcpDebtBussDtlServiceImpl")
public class NRBcpDebtBussDtlServiceImpl implements INRBcpDebtBussDtlService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;

	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rBcpDebtInfoDAO;

	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO iRBcpDebtBussDtlDAO;

	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO rBcpDebtBaseInfoDAO;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rBcpDebtInfoService;

	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rbcpapplibussdtldao;

	// 应收账款凭证票据明细信息新增(不需要新增时默认为已录入的申请类型。)
	@Override
	@Transactional
	public String addRBcpDebtBussDtl(RBcpDebtBussDtl rBcpDebtBussDtl) {
		log.debug("新增应收账款明细信息");
		if (rBcpDebtBussDtl != null) {
			// 添加时候申请类型默认为录入00，申请编号为流水号。操作员，经办机构，录入时间都是要初始化的。
			rBcpDebtBussDtl.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
			rBcpDebtBussDtl.setTlrcd(ContextHolder.getUserInfo().getTlrNo());// 创建人，操作员
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String insertTime = simpleDateFormat.format(new Date());
			rBcpDebtBussDtl.setInsertDate(insertTime);// 录入时间
			String id = bSysSerialNoService.genSerialNo(RBcpDebtConstant.R_BCP_DEBT_DTL_APPLY_NO);// 申请流水号
			rBcpDebtBussDtl.setId(id);
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl rBcpDebtBussDtl2 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl();
			try {
				BeanUtils.copyProperties(rBcpDebtBussDtl, rBcpDebtBussDtl2);
			} catch (BeansException e) {// 10001 = 转换异常！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
						RBcpErrorConstant.SCF_REC_BCP_10001);
			}
			try {
				iRBcpDebtBussDtlDAO.insertSelective(rBcpDebtBussDtl2);
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

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtBussDtl
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日下午5:57:22
	 */
	@Override
	public Page findRBcpDebtBussDtlPageByPage(int pageNo, int pageSize, RBcpDebtBussDtl rBcpDebtBussDtl) {
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
		
		int total = iRBcpDebtBussDtlDAO.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		
		try {
			example.setOrderByClause("ID DESC");// ID现在为序列号，现以ID倒叙
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> list = iRBcpDebtBussDtlDAO.selectByPage(example, page);
			if (list == null || list.size() == 0) {// 没有对应数据直接返回空值
				return null;
			}

			// 设置页面交易金额和业务品种名称
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl rBcpDebtBussDtl1 : list) {
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
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getRemoveAmount());
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
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getRemainingAmount());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_INVOICE_COST_RECORD)) {// 后收费用录取
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
					if (applyType.equals(RBcpDebtConstant.APPLY_TYPE_AFTER_COST_CHARGE)) {// 后收费用收取
						rBcpDebtBussDtl1.setMoney2(rBcpDebtBussDtl1.getMoney());
					}
				}
				// 买方名称
				BCrmBaseInfo buyer = bCrmBaseInfoService.findBCrmBaseInfoByCustcd(rBcpDebtBussDtl1.getCustcdBuyer());
				if (buyer != null) {
					rBcpDebtBussDtl1.setCnameBuyer(buyer.getCname());
				}
				// 卖方名称
				BCrmBaseInfo saller = bCrmBaseInfoService.findBCrmBaseInfoByCustcd(rBcpDebtBussDtl1.getCustcdSaller());
				if (saller != null) {
					rBcpDebtBussDtl1.setCnameSeller(saller.getCname());
				}
			}
			page.setRecords(list);
			page.setTotalRecord(total);
			return page;

		} catch (Exception e) {// 分页条件查询应收账款凭证票据信息失败！
			System.out.println(e);
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10016),
					RBcpErrorConstant.SCF_REC_BCP_10016);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void saveDebtOutPoolInfoDtl(List insertDebtList, RBcpDebtBussInfo tblDebtBussInfo) throws ScubeBizException {
		UserInfo gb = ContextHolder.getUserInfo();
		RBcpDebtInfo baseDebtVo = null;
		for (int i = 0; i < insertDebtList.size(); i++) {
			baseDebtVo = (RBcpDebtInfo) insertDebtList.get(i);
			RBcpDebtInfoVO tblDebtBaseInfo = rBcpDebtInfoService.queryRBcpDebtInfoById(baseDebtVo.getId());
			// 只有为已入池状态的单据才能新增对应的出池明细信息
			if (tblDebtBaseInfo.getPoolFlag().equals("1")) {
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
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void disputeInvoiceSetSubmit(List insertDebtList, RBcpDebtBussInfo tblDebtBussInfo, String financingType) throws ScubeBizException {
		RBcpAppliBussDtl baseDebtVo = null;
		String poolFlag = DebtConstants.POOL_FLAG_IN_POOL;//

		if ("2".equals(financingType)) {// 商纠设定后自动出池
			poolFlag = DebtConstants.POOL_FLAG_OUT_POOL;//
		}
		// 这里不仅要设置出池的明细信息，还要设定商纠设定的明细信息
		for (int i = 0; i < insertDebtList.size(); i++) {
			baseDebtVo = (RBcpAppliBussDtl) insertDebtList.get(i);
			RBcpDebtInfoVO tblDebtBaseInfo = rBcpDebtInfoService.queryRBcpDebtInfoById(baseDebtVo.getDebtId());
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
			// tblDebtBaseInfo.setBussType(tblDebtBussInfo.getBussType());
			tblDebtBaseInfo.setIssueFlag(DebtConstants.ISSUE_FLAG_TRUE);// DebtConstants.ISSUE_FLAG_TRUE
			tblDebtBaseInfo.setIssueReason(baseDebtVo.getIssueReason());
			tblDebtBaseInfo.setReason(null);// 防止存在这个单据中存在之前的争议解决方式，这里应该清空
			tblDebtBaseInfo.setOtherReason(baseDebtVo.getOtherReason());
			tblDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// SCFConstants.UNLOCKED
			tblDebtBaseInfo.setLockAppno(null);
			// tblDebtBaseInfo.setLockAppno("");
			// 商纠次数加一
			tblDebtBaseInfo.getIssueTimes();
			BigDecimal oldIssueTimes = tblDebtBaseInfo.getIssueTimes() == null ? new BigDecimal(0) : tblDebtBaseInfo.getIssueTimes();
			tblDebtBaseInfo.setIssueTimes(oldIssueTimes.add(new BigDecimal(1)));
			rBcpDebtInfoService.updateRBcpDebtInfo(tblDebtBaseInfo);

		}
		return;

	}

	/**
	 * 催收申请+发票费用补录
	 * 
	 * @param list
	 * @param rBcpDebtBussInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月31日下午2:59:08
	 */
	@Transactional
	@Override
	public void debtPressingSubmit(List<NDebtBillsInfoVO> list, RBcpDebtBussInfo rBcpDebtBussInfo) throws ScubeBizException {
		NDebtBillsInfoVO baseDebtVo = null;
		for (int i = 0; i < list.size(); i++) {
			baseDebtVo = (NDebtBillsInfoVO) list.get(i);

			RBcpDebtInfoVO bcpDebtInfoVO = rbcpdebtinfoservice.queryRBcpDebtInfoById(baseDebtVo.getId());
			RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
			if (bcpDebtInfoVO != null) {
				BeanUtils.copyProperties(bcpDebtInfoVO, rBcpDebtBussDtl);
			}

			rBcpDebtBussDtl.setInsertDate(baseDebtVo.getInsertDate());
			rBcpDebtBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpDebtBussDtl.setDebtId(bcpDebtInfoVO.getId());
			rBcpDebtBussDtl.setApplyType(rBcpDebtBussInfo.getApplyType());
			rBcpDebtBussDtl.setAppno(rBcpDebtBussInfo.getAppno());
			rBcpDebtBussDtl.setBussType(bcpDebtInfoVO.getBussType());

			rBcpDebtBussDtl.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			rBcpDebtBussDtl.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			String pressMode = baseDebtVo.getPressMode() == null ? "" : baseDebtVo.getPressMode().toString();
			rBcpDebtBussDtl.setReason(pressMode);
			rBcpDebtBussDtl.setMoney(baseDebtVo.getMoney() == null ? new BigDecimal("0") : baseDebtVo.getMoney());
			rBcpDebtBussDtl.setInsertDate(ScfDateUtil.formatDate(new Date()));

			rBcpDebtBussDtl.setCommonDate(ScfDateUtil.formatDate(new Date()));

			rBcpDebtBussDtl.setWarnCount(baseDebtVo.getWarnCount());
			rBcpDebtBussDtl.setPressCount(baseDebtVo.getPressCount());

			this.addRBcpDebtBussDtl(rBcpDebtBussDtl);

			if (StringUtils.isNotEmpty(rBcpDebtBussDtl.getDebtId())) {
				rbcpdebtinfoservice.lockDebtBaseInfo(rBcpDebtBussDtl.getDebtId(), rBcpDebtBussDtl.getAppno());
			}

		}
	}

	/**
	 * 根据APPNO查询流水明细表
	 * 
	 * @param appno
	 * @param debtId
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日下午2:53:36
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List queryDebtBussDetailByBillsNo(String appno, String debtId) throws ScubeBizException {
		RBcpDebtBussDtlExample example = new RBcpDebtBussDtlExample();
		RBcpDebtBussDtlExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		cri.andDebtIdEqualTo(debtId);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> list = iRBcpDebtBussDtlDAO.selectByExample(example);
		return list;
	}

}
