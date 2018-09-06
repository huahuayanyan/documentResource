/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample.Criteria;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月7日上午10:12:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月7日上午10:12:46	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("RBcpDebtBaseInfoServiceImpl")
public class RBcpDebtBaseInfoServiceImpl implements IRBcpDebtBaseInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	/*
	 * scf.rec.bcp.10001 = 转换异常！ 10002 = 该应收账款信息已存在！ 10003 = 应收账款新增失败！ 10004 =
	 * 应收账款查询重复数据失败！ 10005 = 前台所传数据无效！ 10006 = 应收账款删除失败！ 10007 = 应收账款修改失败！ 10008
	 * = 查询具体应收账款信息失败！ 10009- 条件分页查询条件分页查询应收账款信息失败
	 */
	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO iRBcpDebtBussDtlDAO;
	// 应收账款单据明细信息
	@Resource(name = "rBcpDebtBussDtlService")
	IRBcpDebtBussDtlService iRBcpDebtBussDtlService;
	// 申请明细信息
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;
	// 产品工厂转译业务品种名称
	@Resource(name = "bPrdInfoService")
	IBPrdInfoService iBPrdInfoService;
	// 客户管理
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;
	// 应收账款单据TblDebtBussInfoDAO
	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rbcpdebtbussinfoservice;

	private static final String STATUS = "status";
	private static final String MASTCONTNO = "mastContno";

	// 应收账款信息新增
	@Override
	@Transactional
	public String addRBcpDebtBaseInfo(RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		if (rBcpDebtBaseInfo != null && !"".equals(rBcpDebtBaseInfo)) {
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
			try {
				BeanUtils.copyProperties(rBcpDebtBaseInfo, rBcpDebtBaseInfo1);
			} catch (Exception e) {// 10001 = 转换异常！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
						RBcpErrorConstant.SCF_REC_BCP_10001);
			}
			// RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new
			// RBcpDebtBaseInfoExample();
			// Criteria cri = rBcpDebtBaseInfoExample.createCriteria();
			try {// 应收账款基本信息新增成功之后，再新增应收账款单据基本信息(在新增应收账款单据信息的同时新增应收账款单据明细信息)
				rBcpDebtBaseInfo1.setId(UUIDGeneratorUtil.generate());
				iRBcpDebtBaseInfoDAO.insert(rBcpDebtBaseInfo1);
				RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
				try {
					BeanUtils.copyProperties(rBcpDebtBaseInfo1, rBcpDebtBussDtl);
				} catch (Exception e) {// 10001 = 转换异常！
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
							RBcpErrorConstant.SCF_REC_BCP_10001);
				}
				rBcpDebtBussDtl.setDebtId(rBcpDebtBaseInfo1.getId());
				iRBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);
				return null;
			} catch (Exception e) {// 10003 = 应收账款新增失败！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10003),
						RBcpErrorConstant.SCF_REC_BCP_10003);
			}
		} else {// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	// 批量新增应收账款基本信息（会同时新增收账款单据，应收账款单据明细表两张表的内容）
	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public ArrayList<RBcpDebtBaseInfo> batchAddRBcpDebtBaseInfo(ArrayList<RBcpDebtBaseInfo> ds) {
		if (ds != null && ds.size() > 0) {
			ArrayList<RBcpDebtBaseInfo> rBcpDebtBaseInfoList = new ArrayList<RBcpDebtBaseInfo>();
			for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : ds) {
				// 需要通过debtVO.getBillsNo(),debtVO.getCustcdSaller(),debtVO.getMastContno()
				RBcpDebtBaseInfo rBcpDebtBaseInfo3 = new RBcpDebtBaseInfo();
				rBcpDebtBaseInfo3.setBillsNo(rBcpDebtBaseInfo1.getBillsNo());
				rBcpDebtBaseInfo3.setCustcdSaller(rBcpDebtBaseInfo1.getCustcdSaller());
				rBcpDebtBaseInfo3.setMastContno(rBcpDebtBaseInfo1.getMastContno());
				RBcpDebtBaseInfo RBcpDebtBaseInfo = this.findRBcpDebtBaseInfoByKey(rBcpDebtBaseInfo3);
				if (RBcpDebtBaseInfo != null && !"".equals(RBcpDebtBaseInfo)) {// 去重！
					throw new ScubeBizException("凭证编号为" + RBcpDebtBaseInfo.getBillsNo() + "的信息已存在，请重新输入凭证编号！");
				}
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
				try {
					BeanUtils.copyProperties(rBcpDebtBaseInfo1, rBcpDebtBaseInfo2);
				} catch (Exception e) {// 10001 = 转换异常！
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
							RBcpErrorConstant.SCF_REC_BCP_10001);
				}
				try {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
					String insertTime = simpleDateFormat.format(new Date());
					if (rBcpDebtBaseInfo1.getDueTime() != null && !"".equals(rBcpDebtBaseInfo1.getDueTime())) {
						Date DebtEnd = simpleDateFormat.parse(rBcpDebtBaseInfo1.getDebtEnd());
						long DebtEndMil = DebtEnd.getTime();
						int DueTime = Integer.parseInt(rBcpDebtBaseInfo1.getDueTime());
						long DueTimeMil = (long) DueTime * 24 * 60 * 60 * 1000;
						Date date2 = new Date(DueTimeMil + DebtEndMil);
						String y = date2.getYear() + "";
						String m = date2.getMonth() + "";
						String d = date2.getDay() + "";
						if (date2.getMonth() < 10) {
							m = "0" + m;
						}
						if (date2.getDay() < 10) {
							d = "0" + d;
						}
						rBcpDebtBaseInfo2.setAssurePayDate(y + m + d);
					}
					// 池融资页面已经传了poolFlag
					rBcpDebtBaseInfo2.setInsertDate(insertTime);// 录入时间
					rBcpDebtBaseInfo2.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);// 未锁定状态
					rBcpDebtBaseInfo2.setIssueFlag(RBcpDebtConstant.ISSUE_FLAG_TPYE_FALSE);// 无商纠
					rBcpDebtBaseInfo2.setOverdueFlag(RBcpDebtConstant.OVERDUE_FLAG_NORMAL);// 无逾期
					rBcpDebtBaseInfo2.setFlawFlag(RBcpDebtConstant.FLAW_FLAG_FALSE);// 无瑕疵
					rBcpDebtBaseInfo2.setStatus(RBcpDebtConstant.INVOICE_STATUS_ENTRY);// 状态为已录入01
					rBcpDebtBaseInfo2.setIssueTimes(RBcpDebtConstant.R_BCP_ISSUETIMES);// 商纠次数0
					rBcpDebtBaseInfo2.setBadFlag(RBcpDebtConstant.BAD_FLAG_TYPE_FALSE);
					rBcpDebtBaseInfo2.setLoanOverdueFlag(RBcpDebtConstant.LOAN_OVERDUE_FLAG_NORMAL);
					rBcpDebtBaseInfo2.setId(UUIDGeneratorUtil.generate());
					rBcpDebtBaseInfo2.setLoanRemainingAmount(new BigDecimal(0));// 融资余额
					iRBcpDebtBaseInfoDAO.insert(rBcpDebtBaseInfo2);
					RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
					BeanUtils.copyProperties(rBcpDebtBaseInfo2, rBcpDebtBaseInfo);
					rBcpDebtBaseInfoList.add(rBcpDebtBaseInfo);
					// 应收账款基本信息新增成功之后，再新增应收账款单据基本信息(在新增应收账款单据信息的同时新增应收账款单据明细信息)
					RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
					try {
						BeanUtils.copyProperties(rBcpDebtBaseInfo2, rBcpDebtBussDtl);
					} catch (Exception e) {// 10001 = 转换异常！
						log.debug("" + e);
						throw new ScubeBizException(
								com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
								RBcpErrorConstant.SCF_REC_BCP_10001);
					}
					// 设置明细表中的对应的应收账款基本信息ID
					rBcpDebtBussDtl.setDebtId(rBcpDebtBaseInfo2.getId());
					rBcpDebtBussDtl.setStatus(RBcpDebtConstant.INVOICE_STATUS_ENTRY);// 状态为录入
					rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入
					iRBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);

				} catch (Exception e) {// 10003 = 应收账款新增失败！
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10003),
							RBcpErrorConstant.SCF_REC_BCP_10003);
				}
			}
			return rBcpDebtBaseInfoList;
		} else {// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	// 应收账款基本信息删除
	@Override
	@Transactional
	public int deleteRBcpDebtBaseInfo(String id) {
		if (id != null && !"".equals(id)) {
			try {// 先删除应收账款单据明细信息
				iRBcpDebtBussDtlService.deleteRBcpDebtBussDtl(id);
				return iRBcpDebtBaseInfoDAO.deleteByPrimaryKey(id);
			} catch (Exception e) {// 10006 = 应收账款删除失败！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10006),
						RBcpErrorConstant.SCF_REC_BCP_10006);
			}
		} else {// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	// 应收账款基本信息修改（应收账款单据基本信息需要新增）
	@Override
	@Transactional
	public int updateRBcpDebtBaseInfo(RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		if (rBcpDebtBaseInfo != null && StringUtil.isStrNotEmpty(rBcpDebtBaseInfo.getId())) {
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
			try {
				BeanUtils.copyProperties(rBcpDebtBaseInfo, rBcpDebtBaseInfo1);
			} catch (Exception e) {// // 10001 = 转换异常！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
						RBcpErrorConstant.SCF_REC_BCP_10001);
			}
			try {// 修改应收账款基本信息，添加应收张狂单据明细信息
				RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
				try {
					BeanUtils.copyProperties(rBcpDebtBaseInfo1, rBcpDebtBussDtl);
				} catch (Exception e) {// // 10001 = 转换异常！
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
							RBcpErrorConstant.SCF_REC_BCP_10001);
				}
				rBcpDebtBussDtl.setStatus(RBcpDebtConstant.INVOICE_STATUS_ENTRY);// 已录入
				rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_BILL_MODIFY);// 设置申请状态为修改。
				rBcpDebtBussDtl.setDebtId(rBcpDebtBaseInfo1.getId());
				iRBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);
				iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
				return 1;
			} catch (Exception e) {// 10007 = 应收账款修改失败！
				log.error(e.getMessage());
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007),
						RBcpErrorConstant.SCF_REC_BCP_10007);
			}
		} else {// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	// 查询具体应收账款信息（前台需要查重去重，应该根据，bussType业务品种，买卖方客户号，业务合同号 mastContno，凭证类型
	// billsType，ID，6个查询。）
	@Override
	public RBcpDebtBaseInfo findRBcpDebtBaseInfoByKey(RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		if (rBcpDebtBaseInfo != null && !"".equals(rBcpDebtBaseInfo)) {
			RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
			Criteria cri = rBcpDebtBaseInfoExample.createCriteria();
			// ID
			if (rBcpDebtBaseInfo.getId() != null && !"".equals(rBcpDebtBaseInfo.getId())) {
				cri.andIdEqualTo(rBcpDebtBaseInfo.getId());
			}
			// 卖方客户号 CustcdSaller
			if (rBcpDebtBaseInfo.getCustcdSaller() != null && !"".equals(rBcpDebtBaseInfo.getCustcdSaller())) {
				cri.andCustcdSallerEqualTo(rBcpDebtBaseInfo.getCustcdSaller());
			}
			// 买方客户号 CustcdBuyer
			if (rBcpDebtBaseInfo.getCustcdBuyer() != null && !"".equals(rBcpDebtBaseInfo.getCustcdBuyer())) {
				cri.andCustcdBuyerEqualTo(rBcpDebtBaseInfo.getCustcdBuyer());
			}
			// 凭证编号 billsNo
			if (rBcpDebtBaseInfo.getBillsNo() != null && !"".equals(rBcpDebtBaseInfo.getBillsNo())) {
				cri.andBillsNoEqualTo(rBcpDebtBaseInfo.getBillsNo());
			}
			// 凭证类型 billsType
			if (rBcpDebtBaseInfo.getBillsType() != null && !"".equals(rBcpDebtBaseInfo.getBillsType())) {
				cri.andBillsTypeEqualTo(rBcpDebtBaseInfo.getBillsType());
			}
			// 业务合同编号 MastContno
			if (rBcpDebtBaseInfo.getMastContno() != null && !"".equals(rBcpDebtBaseInfo.getMastContno())) {
				cri.andMastContnoEqualTo(rBcpDebtBaseInfo.getMastContno());
			}

			try {
				List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> byExample = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
				if (byExample != null && byExample.size() > 0) {
					com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo2 = byExample.get(0);
					try {
						BeanUtils.copyProperties(rBcpDebtBaseInfo2, rBcpDebtBaseInfo);
					} catch (Exception e) {// // 10001 = 转换异常！
						throw new ScubeBizException(
								com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
								RBcpErrorConstant.SCF_REC_BCP_10001);
					}
					return rBcpDebtBaseInfo;
				} else {
					return null;
				}
			} catch (Exception e) {// 10008 = 查询具体应收账款信息失败！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10008),
						RBcpErrorConstant.SCF_REC_BCP_10008);
			}
		} else {// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	// 条件分页查询应收账款信息（根据（买方客户名称）cnameBuyer，（卖方客户名称）cnameSeller，（业务合同编号）mastContno）
	// （凭证编号）billsNo，status应收账款单据状态：01-已录入、02-已转让、03-已核销、04-已融资 debtBussStatus
	// （业务品种）bussType，（凭证类型）billsType，（应收账款日期）billsDate，（应收账款到期日）debtEnd，
	// 注意页面的业务品种需要中文名称而不是ID，这里需要翻译下。 bussTypeName业务品种名称
	@Override
	public Page findRBcpDebtBaseInfoPageByPage(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		Criteria cri = example.createCriteria();
		if (rBcpDebtBaseInfo != null && !"".equals(rBcpDebtBaseInfo)) {
			// 1.（买方客户名称）cnameBuyer
			if (rBcpDebtBaseInfo.getCnameBuyer() != null && !"".equals(rBcpDebtBaseInfo.getCnameBuyer())) {
				cri.andCnameBuyerLike("%" + rBcpDebtBaseInfo.getCnameBuyer() + "%");
			}
			if (rBcpDebtBaseInfo.getCustcdBuyer() != null && !"".equals(rBcpDebtBaseInfo.getCustcdBuyer())) {
				cri.andCustcdBuyerEqualTo(rBcpDebtBaseInfo.getCustcdBuyer());
			}
			// 2.（卖方客户名称）cnameSellers
			if (rBcpDebtBaseInfo.getCnameSeller() != null && !"".equals(rBcpDebtBaseInfo.getCnameSeller())) {
				cri.andCnameSellerLike("%" + rBcpDebtBaseInfo.getCnameSeller() + "%");
			}
			if (rBcpDebtBaseInfo.getCustcdSaller() != null && !"".equals(rBcpDebtBaseInfo.getCustcdSaller())) {
				cri.andCustcdSallerEqualTo(rBcpDebtBaseInfo.getCustcdSaller());
			}
			// 3.（业务合同编号）mastContno）
			if (rBcpDebtBaseInfo.getMastContno() != null && !"".equals(rBcpDebtBaseInfo.getMastContno())) {
				cri.andMastContnoLike("%" + rBcpDebtBaseInfo.getMastContno() + "%");
			}
			// 4.（凭证编号）billsNo
			if (rBcpDebtBaseInfo.getBillsNo() != null && !"".equals(rBcpDebtBaseInfo.getBillsNo())) {
				cri.andBillsNoLike("%" + rBcpDebtBaseInfo.getBillsNo() + "%");
			}
			// 5.status应收账款单据状态 //modify yyl
			if (rBcpDebtBaseInfo.getStatus() != null && !"".equals(rBcpDebtBaseInfo.getStatus())) {
				if (rBcpDebtBaseInfo.getStatus().contains(",")) {
					List<String> statuList = new ArrayList<String>();
					String[] status = rBcpDebtBaseInfo.getStatus().split(",");
					for (String statu : status) {
						statuList.add(statu);
					}
					cri.andStatusIn(statuList);
				} else {
					cri.andStatusEqualTo(rBcpDebtBaseInfo.getStatus());
				}

			}
			// 6.bussType 业务品种
			if (StringUtils.isNotEmpty(rBcpDebtBaseInfo.getBussType())) {
				if (rBcpDebtBaseInfo.getBussType().contains(",")) {
					String[] bussType = rBcpDebtBaseInfo.getBussType().split(",");
					ArrayList<String> arrayList = new ArrayList<String>();
					for (int i = 0; i < bussType.length; i++) {
						arrayList.add(bussType[i]);
					}
					cri.andBussTypeIn(arrayList);
				} else {
					cri.andBussTypeEqualTo(rBcpDebtBaseInfo.getBussType());
				}
			}
			// 7.（凭证类型）billsType
			if (rBcpDebtBaseInfo.getBillsType() != null && !"".equals(rBcpDebtBaseInfo.getBillsType())) {
				cri.andBillsTypeEqualTo(rBcpDebtBaseInfo.getBillsType());
			}
			// 8. billsDate，（应收账款日期从）billsDateFrom, 大于等于,billsDateTo 小于等于,
			if (rBcpDebtBaseInfo.getBillsDateFrom() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateFrom())) {
				cri.andBillsDateGreaterThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateFrom());
			}
			// 8.billsDate，（应收账款日期到）billsDateTo 小于等于
			if (rBcpDebtBaseInfo.getBillsDateTo() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateTo())) {
				cri.andBillsDateLessThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateTo());
			}
			// 9.debtEnd，（应收账款到期日从） debtEndFrom 大于等于
			if (rBcpDebtBaseInfo.getDebtEndFrom() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndFrom())) {
				cri.andDebtEndGreaterThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndFrom());
			}
			// 9.debtEnd，（应收账款到期日到）debtEndTo 小于等于
			if (rBcpDebtBaseInfo.getDebtEndTo() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndTo())) {
				cri.andDebtEndLessThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndTo());
			}
			// 10.锁定状态 isLocked
			if (rBcpDebtBaseInfo.getIsLocked() != null && !"".equals(rBcpDebtBaseInfo.getIsLocked())) {
				cri.andIsLockedEqualTo(rBcpDebtBaseInfo.getIsLocked());
			}
			// 11.商纠状态 issueFlag
			if (rBcpDebtBaseInfo.getIssueFlag() != null && !"".equals(rBcpDebtBaseInfo.getIssueFlag())) {
				cri.andIssueFlagEqualTo(rBcpDebtBaseInfo.getIssueFlag());
			}
			// 12.瑕疵 flawFlag
			if (rBcpDebtBaseInfo.getFlawFlag() != null && !"".equals(rBcpDebtBaseInfo.getFlawFlag())) {
				cri.andFlawFlagEqualTo(rBcpDebtBaseInfo.getFlawFlag());
			}
			// 13. poolFlag add yyl
			if (rBcpDebtBaseInfo.getPoolFlag() != null && !"".equals(rBcpDebtBaseInfo.getPoolFlag())) {
				cri.andPoolFlagEqualTo(rBcpDebtBaseInfo.getPoolFlag());

			}
			// 14. remainingAmount add yyl
			if (rBcpDebtBaseInfo.getRemainingAmount() != null && !"".equals(rBcpDebtBaseInfo.getFlawFlag())) {
				cri.andRemainingAmountGreaterThan(rBcpDebtBaseInfo.getRemainingAmount());
			}
			// 15.lockAppno
			if (rBcpDebtBaseInfo.getLockAppno() != null && !"".equals(rBcpDebtBaseInfo.getLockAppno())) {
				cri.andLockAppnoEqualTo(rBcpDebtBaseInfo.getLockAppno());
			}
			// 16.factType 保理类型
			if (rBcpDebtBaseInfo.getFactType() != null && !"".equals(rBcpDebtBaseInfo.getFactType())) {
				List<String> values = new ArrayList<String>();
				String factType = rBcpDebtBaseInfo.getFactType();
				if(BCntBizConstant.T_FINANCING_TYPE_INVOICE.equals(factType)){//应收账款融资 产品
					values.add(BCntBizConstant.FACT_TYPE_INLAND);
					values.add(BCntBizConstant.FACT_TYPE_REVERSE);
					values.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);
				}else if(BCntBizConstant.T_FINANCING_TYPE_POOL.equals(factType)){//应收账款池
					values.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);
					values.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);
					values.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);
				}else if(BCntBizConstant.T_FINANCING_TYPE_CREDIT.equals(factType)){//信保保理
					values.add(BCntBizConstant.FACT_TYPE_CREDIT_FACT);
				}else if(BCntBizConstant.T_FINANCING_TYPE_DOUBLE.equals(factType)){//国内双保理
					values.add(BCntBizConstant.FACT_TYPE_DOUBLE_FACT);
				}else if(BCntBizConstant.T_FINANCING_TYPE_LEASE.equals(factType)){//租赁保理
					values.add(BCntBizConstant.FACT_TYPE_LEASE_FACT);
				}else if(BCntBizConstant.T_FINANCING_TYPE_EF.equals(factType)){//国际出口保理
					values.add(BCntBizConstant.FACT_TYPE_EF);
				}else if(BCntBizConstant.T_FINANCING_TYPE_IF.equals(factType)){//国际进口保理
					values.add(BCntBizConstant.FACT_TYPE_IF);
				}else{
					throw new ScubeBizException("业务品种不存在！");
				}
				cri.andFactTypeIn(values);
			}
		}
		String errorMessage = "";
		try {
			example.setOrderByClause(" INSERT_DATE DESC, MAST_CONTNO DESC");// 按照登记日期和合同号排序
			// 业务品种实际存储的是产品ID，到产品中查询就行了。
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByPage(example, p);
			if (rBcpDebtBaseInfoList != null && rBcpDebtBaseInfoList.size() > 0) {
				for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 : rBcpDebtBaseInfoList) {
					// 查询对应的业务产品名称 bussTypeName iBPrdInfoService
					BPrdInfo bPrdInfo = new BPrdInfo();
					bPrdInfo.setProductId(rBcpDebtBaseInfo1.getBussType());
					try {
						BPrdInfo bPrdInfo2 = iBPrdInfoService.findBPrdInfoByKey(bPrdInfo);
						rBcpDebtBaseInfo1.setBussTypeName(bPrdInfo2.getProductName());
					} catch (Exception e) {
						errorMessage = errorMessage + "单据业务品种名称查询失败！";
						throw new ScubeBizException(
								com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10010),
								RBcpErrorConstant.SCF_REC_BCP_10010);
					}
					// 买方名称翻译
					try {
						BCrmBaseInfoExample bCrmBaseInfoExample = new BCrmBaseInfoExample();
						if (rBcpDebtBaseInfo1.getCustcdBuyer() != null) {
							bCrmBaseInfoExample.createCriteria().andCustcdEqualTo(rBcpDebtBaseInfo1.getCustcdBuyer());
							List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfoList = iBCrmBaseInfoDAO
									.selectByExample(bCrmBaseInfoExample);
							if (bCrmBaseInfoList != null && bCrmBaseInfoList.size() == 1) {
								rBcpDebtBaseInfo1.setCnameBuyer(bCrmBaseInfoList.get(0).getCname());
							}
						}
					} catch (Exception e) {
						errorMessage = errorMessage + "单据买方客户名称翻译失败！";
						throw new ScubeBizException(errorMessage);
					}
					// 卖方名称翻译
					try {
						BCrmBaseInfoExample bCrmBaseInfoExample2 = new BCrmBaseInfoExample();
						if (rBcpDebtBaseInfo1.getCustcdSaller() != null) {
							bCrmBaseInfoExample2.createCriteria().andCustcdEqualTo(rBcpDebtBaseInfo1.getCustcdSaller());
							List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfoList2 = iBCrmBaseInfoDAO
									.selectByExample(bCrmBaseInfoExample2);
							if (bCrmBaseInfoList2 != null && bCrmBaseInfoList2.size() == 1) {
								rBcpDebtBaseInfo1.setCnameSeller(bCrmBaseInfoList2.get(0).getCname());
							}
						}
					} catch (Exception e) {
						errorMessage = errorMessage + "单据卖方客户名称翻译失败！";
						throw new ScubeBizException(errorMessage);
					}

				}
			}

			p.setRecords(rBcpDebtBaseInfoList);
			return p;
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			log.error("条件分页查询条件分页查询应收账款信息失败！");
			if ("".equals(errorMessage)) {
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
						RBcpErrorConstant.SCF_REC_BCP_10009);
			} else {
				throw new ScubeBizException(errorMessage);
			}
		}
	}

	// 用于页面新增时候的应收账款信息查重。要返回重复的数据
	@Override
	@Transactional
	public ArrayList<RBcpDebtBaseInfo> findRBcpDebtBaseInfoByKey2(ArrayList<RBcpDebtBaseInfo> ds) {
		if (ds == null || ds.size() == 0) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<RBcpDebtBaseInfo> rBcpDebtBaseInfoList = new ArrayList<RBcpDebtBaseInfo>();
		for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : ds) {
			if (rBcpDebtBaseInfo1.getBillsNo() != null && !"".equals(rBcpDebtBaseInfo1.getBillsNo())) {
				RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
				Criteria cri = example.createCriteria();
				cri.andBillsNoEqualTo(rBcpDebtBaseInfo1.getBillsNo());// 只根据凭证编号查重。
				try {
					List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList2 = iRBcpDebtBaseInfoDAO.selectByExample(example);
					if (rBcpDebtBaseInfoList2 != null && rBcpDebtBaseInfoList2.size() > 0) {
						RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
						BeanUtils.copyProperties(rBcpDebtBaseInfoList2.get(0), rBcpDebtBaseInfo);
						rBcpDebtBaseInfoList.add(rBcpDebtBaseInfo);
					}
				} catch (Exception e) {// 查询具体信息失败。
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10008),
							RBcpErrorConstant.SCF_REC_BCP_10008);
				}
			} else {// 如果里面没有凭证编号，则直接报错。
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10011),
						RBcpErrorConstant.SCF_REC_BCP_10011);
			}
		}
		return rBcpDebtBaseInfoList;

	}

	// 对应页面应收账款管理新增页面的保存并转让出质按钮功能
	@Override
	@Transactional
	public ArrayList<RBcpDebtBaseInfo> saveAndTransferRBcpDebtBaseInfo(ArrayList<RBcpDebtBaseInfo> ds) {
		// 1.数据校验
		if (ds == null || ds.size() == 0) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.保存对应的传输数据
		try {
			return this.batchAddRBcpDebtBaseInfo(ds);
		} catch (Exception e) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10003),
					RBcpErrorConstant.SCF_REC_BCP_10003);
		}

	}

	// 发票入池
	@Override
	public void invoiceInpoolAddSave(ArrayList<RBcpAppliBussDtl> rBcpAppliBussDtlList, DebtBussInfoVO debtVO) throws ScubeBizException {
		String financingType = debtVO.getFinancingType();
		// DebtBillsInfoVO billvo = null;
		// 修改发票入池状态
		for (RBcpAppliBussDtl rBcpAppliBussDtl : rBcpAppliBussDtlList) {
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo = iRBcpDebtBaseInfoDAO
					.selectByPrimaryKey(rBcpAppliBussDtl.getDebtId());
			if (rBcpDebtBaseInfo == null || "".equals(rBcpDebtBaseInfo)) {// 查询具体应收账款基本信息失败！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10008),
						RBcpErrorConstant.SCF_REC_BCP_10008);
			}
			if (DebtConstants.FINANCING_TYPE_INVOICE.equals(financingType)) {
				rBcpDebtBaseInfo.setPoolFlag("");
			} else {
				rBcpDebtBaseInfo.setPoolFlag("1");
			}
			rBcpDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			rBcpDebtBaseInfo.setLockAppno(null);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);
		}
	}

	/**
	 * @author liph
	 * @deprecated 流贷--应收账款放款申请添加
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page selectRBcpDebtBaseInfo(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) throws ScubeBizException {
		Map map = new HashMap();
		int total = iRBcpDebtBaseInfoDAO.countys();
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		p.setRecords(iRBcpDebtBaseInfoDAO.selectys(map, p));
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService iRBcpAppliBussDtlService;

	@Override
	public Page findInovListByCommonQueryVO(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) {

		String custcdSaller = rBcpDebtBaseInfo.getCustcdSaller();
		String mastContno = rBcpDebtBaseInfo.getMastContno();
		String custcdBuyer = rBcpDebtBaseInfo.getCustcdBuyer();

		String debtEndFrom = rBcpDebtBaseInfo.getDebtEndFrom();
		String debtEndTo = rBcpDebtBaseInfo.getDebtEndTo();
		String billsDateFrom = rBcpDebtBaseInfo.getBillsDateFrom();
		String billsDateTo = rBcpDebtBaseInfo.getBillsDateTo();

		String billsNo = rBcpDebtBaseInfo.getBillsNo();
		String billsType = rBcpDebtBaseInfo.getBillsType();

		String lockAppno = rBcpDebtBaseInfo.getLockAppno();

		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		Criteria cri = example.createCriteria();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(DebtConstants.INVOICE_STATUS_PURCHASED);
		arrayList.add(DebtConstants.INVOICE_STATUS_FINANCED);
		cri.andStatusIn(arrayList);
		if (StringUtils.isNotBlank(custcdSaller)) {
			cri.andCustcdSallerEqualTo(custcdSaller);
		}
		if (StringUtils.isNotBlank(custcdBuyer)) {
			cri.andCustcdBuyerEqualTo(custcdBuyer);
		}
		if (StringUtils.isNotBlank(mastContno)) {
			cri.andMastContnoEqualTo(mastContno);
		}
		// 如果被锁定则要申请号需要一致
		if (StringUtils.isNotBlank(lockAppno)) {
			cri.andLockAppnoEqualTo(lockAppno);
			cri.andIsLockedEqualTo("1");
		} /*
			 * else { cri.andIsLockedEqualTo("0"); cri.andLockAppnoIsNull();
			 * 
			 * Map<String, Object> parameters = new HashMap<String, Object>();
			 * parameters.put("custcdSaller", custcdSaller);
			 * parameters.put("mastContno", mastContno);
			 * parameters.put("custcdBuyer", custcdBuyer);
			 * 
			 * List<String> expBillslist =
			 * iRBcpAppliBussDtlService.findBillsBySallerBuyerAndContno(
			 * parameters); if (expBillslist.size() > 0 && expBillslist != null)
			 * { cri.andBillsNoNotIn(expBillslist); }
			 * 
			 * }
			 */

		if (StringUtils.isNotBlank(billsNo)) {
			cri.andBillsNoEqualTo(billsNo);
		}

		if (StringUtils.isNotBlank(billsType)) {
			cri.andBillsTypeEqualTo(billsType);
		}

		if (StringUtils.isNotBlank(billsDateFrom) && StringUtils.isNotBlank(billsDateTo)) {
			cri.andBillsDateBetween(billsDateFrom, billsDateTo);
		}

		if (StringUtils.isNotBlank(debtEndFrom) && StringUtils.isNotBlank(debtEndTo)) {
			cri.andDebtEndBetween(debtEndFrom, debtEndTo);
		}

		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> resultList = iRBcpDebtBaseInfoDAO.selectByExample(example);

		Page page = new Page();
		page.setPageNo(1);
		page.setPageSize(10);
		page.setRecords(resultList);
		page.setTotalRecord(iRBcpDebtBaseInfoDAO.countByExample(example));
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService#lockDebtBaseInfo
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public void lockDebtBaseInfo(String debtId, String appno) throws ScubeBizException {
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtBaseInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
		debtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(debtId);
		if (debtBaseInfo != null) {
			debtBaseInfo.setIsLocked(ScfBasConstant.LOCKED); // 锁定
			debtBaseInfo.setLockAppno(appno);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(debtBaseInfo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService#
	 * releaseDebtBaseInfo(java.lang.String)
	 */
	@Override
	@Transactional
	public void releaseDebtBaseInfo(String debtId) throws ScubeBizException {
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtBaseInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
		debtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(debtId);
		if (debtBaseInfo != null) {
			debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// 解锁
			debtBaseInfo.setLockAppno(null);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(debtBaseInfo);
		}
	}

	/**
	 * 查询未核销的应收账款
	 */
	@Override
	public List<RBcpDebtBaseInfo> queryValidDebtBaseInfo(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != debtCommonQryVO) {
			String mastContno = debtCommonQryVO.getMastContno();// 合同号
			if (StringUtil.isStrNotEmpty(mastContno)) {
				map.put(MASTCONTNO, mastContno);
			}
		}

		map.put(STATUS, ScfBasConstant.BILLS_STATUS_PAYOFF); // 是否结清
		List<RBcpDebtBaseInfo> list = new ArrayList<RBcpDebtBaseInfo>();
		RBcpDebtBaseInfo rBcpDebtBaseInfo = null;
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> listdal = iRBcpDebtBaseInfoDAO.queryValidDebtBaseInfo(map);
		if (listdal != null && listdal.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo info : listdal) {
				rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
				BeanUtils.copyProperties(info, rBcpDebtBaseInfo);
				list.add(rBcpDebtBaseInfo);
			}
		}

		return list;
	}

	/***
	 * 出池发票出池保存
	 */
	@Override
	public void invoiceOutPoolAddSave(List<DebtBillsInfoVO> insertDebtList, DebtBussInfoVO debtVO) {
		DebtBillsInfoVO billVO = null;
		// 修改发票出池状态
		try {
			for (int i = 0; i < insertDebtList.size(); i++) {

				billVO = (DebtBillsInfoVO) insertDebtList.get(i);

				RBcpDebtBaseInfo debtBaseInfo = this.get(billVO.getId());
				if (debtBaseInfo == null || "".equals(debtBaseInfo)) {// 查询具体应收账款基本信息失败！
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10008),
							RBcpErrorConstant.SCF_REC_BCP_10008);
				}
				debtBaseInfo.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);
				debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
				// debtBaseInfo.setLockAppno(null);
				debtBaseInfo.setLockAppno("");
				if (!StringUtils.isEmpty(billVO.getIssueReason())) {
					debtBaseInfo.setIssueReason(billVO.getIssueReason());
				}
				if (!StringUtils.isEmpty(billVO.getOtherReason())) {
					debtBaseInfo.setOtherReason(billVO.getOtherReason());
				}
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
				BeanUtils.copyProperties(debtBaseInfo, rBcpDebtBaseInfo1);
				iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			throw new ScubeBizException(e.getMessage());
		}
	}

	@Override
	public Page findCancelRBcpDebtBaseInfoPageByPage(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		Criteria cri = example.createCriteria();
		if (rBcpDebtBaseInfo != null && !"".equals(rBcpDebtBaseInfo)) {
			// 1.（买方客户名称）cnameBuyer
			if (rBcpDebtBaseInfo.getCnameBuyer() != null && !"".equals(rBcpDebtBaseInfo.getCnameBuyer())) {
				cri.andCnameBuyerLike("%" + rBcpDebtBaseInfo.getCnameBuyer() + "%");
			}
			// 2.（卖方客户名称）cnameSellers
			if (rBcpDebtBaseInfo.getCnameSeller() != null && !"".equals(rBcpDebtBaseInfo.getCnameSeller())) {
				cri.andCnameSellerLike("%" + rBcpDebtBaseInfo.getCnameSeller() + "%");
			}
			// 3.（业务合同编号）mastContno）
			if (rBcpDebtBaseInfo.getMastContno() != null && !"".equals(rBcpDebtBaseInfo.getMastContno())) {
				cri.andMastContnoEqualTo(rBcpDebtBaseInfo.getMastContno());
			}
			// 4.（凭证编号）billsNo
			if (rBcpDebtBaseInfo.getBillsNo() != null && !"".equals(rBcpDebtBaseInfo.getBillsNo())) {
				cri.andBillsNoEqualTo(rBcpDebtBaseInfo.getBillsNo());
			}
			// 5.status应收账款单据状态
			if (rBcpDebtBaseInfo.getStatus() != null && !"".equals(rBcpDebtBaseInfo.getStatus())) {
				cri.andStatusEqualTo(rBcpDebtBaseInfo.getStatus());
			}
			// 6.bussType 业务品种
			if (rBcpDebtBaseInfo.getBussType() != null && !"".equals(rBcpDebtBaseInfo.getBussType())) {
				cri.andBussTypeEqualTo(rBcpDebtBaseInfo.getBussType());
			}
			// 7.（凭证类型）billsType
			if (rBcpDebtBaseInfo.getBillsType() != null && !"".equals(rBcpDebtBaseInfo.getBillsType())) {
				cri.andBillsTypeEqualTo(rBcpDebtBaseInfo.getBillsType());
			}
			// 8. billsDate，（应收账款日期从）billsDateFrom, 大于等于,billsDateTo 小于等于,
			if (rBcpDebtBaseInfo.getBillsDateFrom() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateFrom())) {
				cri.andBillsDateGreaterThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateFrom());
			}
			// 8.billsDate，（应收账款日期到）billsDateTo 小于等于
			if (rBcpDebtBaseInfo.getBillsDateTo() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateTo())) {
				cri.andBillsDateLessThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateTo());
			}
			// 9.debtEnd，（应收账款到期日从） debtEndFrom 大于等于
			if (rBcpDebtBaseInfo.getDebtEndFrom() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndFrom())) {
				cri.andDebtEndGreaterThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndFrom());
			}
			// 9.debtEnd，（应收账款到期日到）debtEndTo 小于等于
			if (rBcpDebtBaseInfo.getDebtEndTo() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndTo())) {
				cri.andDebtEndLessThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndTo());
			}
			// 10.锁定状态 isLocked
			if (rBcpDebtBaseInfo.getIsLocked() != null && !"".equals(rBcpDebtBaseInfo.getIsLocked())) {
				cri.andIsLockedEqualTo(rBcpDebtBaseInfo.getIsLocked());
			}
		}
		try {
			// 业务品种实际存储的是产品ID，到产品中查询就行了。
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByPage(example, p);
			if (rBcpDebtBaseInfoList != null && rBcpDebtBaseInfoList.size() > 0) {
				try {// 业务产品名称转译
					for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 : rBcpDebtBaseInfoList) {
						// 查询对应的业务产品名称 bussTypeName iBPrdInfoService
						BPrdInfo bPrdInfo = new BPrdInfo();
						bPrdInfo.setProductId(rBcpDebtBaseInfo1.getBussType());
						BPrdInfo bPrdInfo2 = iBPrdInfoService.findBPrdInfoByKey(bPrdInfo);
						rBcpDebtBaseInfo1.setBussTypeName(bPrdInfo2.getProductName());
					}
				} catch (Exception e) {
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10010),
							RBcpErrorConstant.SCF_REC_BCP_10010);
				}
			}
			return p;
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			log.error("条件分页查询条件分页查询应收账款信息失败！");
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
					RBcpErrorConstant.SCF_REC_BCP_10009);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void invoiceOutpoolAddSave(List insertDebtList, DebtBussInfoVO debtVO) {
		RBcpAppliBussDtl billVO = null;
		// 修改发票出池状态
		for (int i = 0; i < insertDebtList.size(); i++) {
			billVO = (RBcpAppliBussDtl) insertDebtList.get(i);
			RBcpDebtBaseInfo debtBaseInfo = this.get(billVO.getId());
			debtBaseInfo.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);
			debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			debtBaseInfo.setLockAppno(null);
			if (!StringUtils.isEmpty(billVO.getIssueReason())) {
				debtBaseInfo.setIssueReason(billVO.getIssueReason());
			}
			if (!StringUtils.isEmpty(billVO.getOtherReason())) {
				debtBaseInfo.setOtherReason(billVO.getOtherReason());
			}
			this.updateRBcpDebtBaseInfo(debtBaseInfo);
		}

	}

	@Override
	public RBcpDebtBaseInfo get(String id) {
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfoDal = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(id);
		RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
		BeanUtils.copyProperties(rBcpDebtBaseInfoDal, rBcpDebtBaseInfo);
		return rBcpDebtBaseInfo;
	}

	/**
	 * 池应收账款
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public Page getDebtInfoQuery(int pageNo, int pageSize, String mastContno) {
		if (StringUtil.isEmpty(mastContno)) {
			log.info("appno不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20020), BLanErrorConstant.SCF_BAS_LAN_20020);
		}
		Map map = new HashMap();
		map.put("mastContno", mastContno);
		// mengjiajia,只查询已转让/出质状态的应收账款信息
		map.put("status", DebtConstants.INVOICE_STATUS_PURCHASED);
		map.put("factType", ScfBasConstant.T_FINANCING_TYPE_POOL);// 应收账款池融资
		map.put("debtPoolPledge", ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE);
		map.put("debtPool", ScfBasConstant.FACT_TYPE_DEBT_POOL);
		map.put("exportPoolPledge", ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> list = iRBcpDebtBaseInfoDAO.getDebtInfoQuery(map, page);

		return page;
	}

	@Override
	public RBcpDebtBaseInfo findRBcpDebtBaseInfoByPrimaryKey(String id) {
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo baseinfodal = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(id);
		RBcpDebtBaseInfo baseinfo = new RBcpDebtBaseInfo();
		BeanUtils.copyProperties(baseinfodal, baseinfo);
		return baseinfo;
	}

	/**
	 * @Description: 回购申请审批通过
	 * @author zhengzong.liu
	 * @Created 2012-8-1下午12:59:56
	 * @param insertDebtList
	 * @param tblDebtBussInfo
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	@Override
	public List factoringDebtBackAddApply(List<RBcpDebtBaseInfo> insertDebtList, RBcpDebtBussInfo tblDebtBussInfo) throws ScubeBizException {
		List list2 = new ArrayList();
		DebtBillsInfoVO baseDebtVo = new DebtBillsInfoVO();
		if (insertDebtList.size() > 0) {
			for (RBcpDebtBaseInfo baseinfo : insertDebtList) {
				BeanUtils.copyProperties(baseinfo, baseDebtVo);
				baseDebtVo.setBuyBackAmount(tblDebtBussInfo.getAmount());
				BigDecimal rebateAmounts = baseDebtVo.getBuyBackAmount() == null ? new BigDecimal("0") : baseDebtVo.getBuyBackAmount();// 本次回购金额
				RBcpDebtBaseInfo tblDebtBaseInfo = this.updateDebtStateByRemainingAmount(baseDebtVo, rebateAmounts, null, null);
				if (DebtConstants.INVOICE_STATUS_VERIFIED.equals(tblDebtBaseInfo.getStatus())) {// 若发票已核销，则添加到list2中
					baseDebtVo.setRemoveAmount(rebateAmounts);
					list2.add(baseDebtVo);
				}
				RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
				BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);
				tblDebtBussDetail.setId(UUIDGeneratorUtil.generate());
				tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
				tblDebtBussDetail.setApplyType(tblDebtBussInfo.getApplyType());
				tblDebtBussDetail.setAppno(tblDebtBussInfo.getAppno());
				tblDebtBussDetail.setBussType(tblDebtBaseInfo.getBussType());
				tblDebtBussDetail.setBuyBackAmount(tblDebtBussInfo.getAmount());// 回购金额
				tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
				tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
				tblDebtBussDetail.setMoney(baseDebtVo.getBuyBackAmount());
				iRBcpDebtBussDtlService.addRBcpDebtBussDtl(tblDebtBussDetail);

				BigDecimal buyBackAmount = tblDebtBaseInfo.getBuyBackAmount() == null ? new BigDecimal("0") : tblDebtBaseInfo.getBuyBackAmount();// 回购金额
				tblDebtBaseInfo.setBuyBackAmount(buyBackAmount.add(rebateAmounts));// 回购金额累加
				BigDecimal remainingUseableAmount = tblDebtBaseInfo.getRemainingUseableAmount() == null ? new BigDecimal("0")
						: tblDebtBaseInfo.getRemainingUseableAmount();
				BigDecimal loanPercent = tblDebtBaseInfo.getLoanPercent() == null ? new BigDecimal("0") : tblDebtBaseInfo.getLoanPercent();
				tblDebtBaseInfo.setRemainingUseableAmount(remainingUseableAmount
						.subtract(rebateAmounts.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));// 发票可融资余额
				BigDecimal remainingAmount = tblDebtBaseInfo.getRemainingAmount() == null ? new BigDecimal("0")
						: tblDebtBaseInfo.getRemainingAmount();// 发票余额
				BigDecimal amount = remainingAmount.subtract(rebateAmounts);// 得到回购后发票余额
				tblDebtBaseInfo.setRemainingAmount(amount);
				// 调用公共方法判断
				/*
				 * if((baseDebtVo.getRebatebalance()==null?new
				 * BigDecimal("0"):baseDebtVo.getRebatebalance()).compareTo(num)
				 * ==0){
				 * tblDebtBaseInfo.setStatus(DebtConstants.INVOICE_STATUS_03); }
				 */
				this.updateRBcpDebtBaseInfo(tblDebtBaseInfo);
			}
		}
		return list2;
	}

	/**
	 * 根据还款金额,还本金额，还息金额来改变发票的状态，对全部还款的发票改变状态为已销帐。
	 * 
	 * @author lei.wang
	 * @date 2011-12-29 updateDebtStateByRemainingAmount 方法
	 * @param debtVO
	 *            //发票信息
	 * @param removeAmount
	 *            还款金额（还融资金额、冲销金额）等金额，用于冲销发票金额
	 * @param rateAmount
	 *            还息金额 发票融资时用
	 * @param loanAmount
	 *            还本金额 发票融资时用
	 * @return
	 * @throws CommonException
	 */
	@Transactional
	public RBcpDebtBaseInfo updateDebtStateByRemainingAmount(DebtBillsInfoVO debtVO, BigDecimal removeAmount, BigDecimal rateAmount,
			BigDecimal loanAmount) throws ScubeBizException {
		com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo tblDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(debtVO.getId());
		if (tblDebtBaseInfo == null) {
			throw new ScubeBizException("发票列表获取失败！", RBcpErrorConstant.RECORD_NOT_EXIST);
		} else {
			BigDecimal remainingAmount = tblDebtBaseInfo.getRemainingAmount() == null ? new BigDecimal("0") : tblDebtBaseInfo.getRemainingAmount();// 发票余额
			BigDecimal loanRemainingAmount = tblDebtBaseInfo.getLoanRemainingAmount() == null ? new BigDecimal("0")
					: tblDebtBaseInfo.getLoanRemainingAmount();// 融资余额
			BigDecimal ownRateCollectAmount = tblDebtBaseInfo.getOwnRateCollectAmount() == null ? new BigDecimal("0")
					: tblDebtBaseInfo.getOwnRateCollectAmount();// 欠息总额
			rateAmount = rateAmount == null ? new BigDecimal("0") : rateAmount;// 还息金额
			loanAmount = loanAmount == null ? new BigDecimal("0") : loanAmount;// 还本金额
			removeAmount = removeAmount == null ? new BigDecimal("0") : removeAmount;// 冲销金额
			if (removeAmount.compareTo(remainingAmount) == 1) {// 若冲销金额大于发票余额
				throw new ScubeBizException("发票冲销金额溢出错误，请重新核对或发起新的申请！", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			} else if (loanRemainingAmount.compareTo(loanAmount) == -1) {// 若还本金额大于融资余额
				throw new ScubeBizException("发票还本金额溢出错误，请重新核对或发起新的申请！", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			} else if (ownRateCollectAmount.compareTo(rateAmount) == -1) {// 若还息金额大于欠息金额
				throw new ScubeBizException("发票还息金额溢出错误，请重新核对或发起新的申请！", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			} else if (removeAmount.compareTo(remainingAmount) == 0 && loanAmount.compareTo(loanRemainingAmount) == 0
					&& rateAmount.compareTo(ownRateCollectAmount) == 0) {
				// 若欠本，欠息和发票余额都能抵消为0
				tblDebtBaseInfo.setReturnStatus(DebtConstants.RETURN_STATUS_ALL_PAYMENT);// 全部还清
				tblDebtBaseInfo.setStatus(DebtConstants.INVOICE_STATUS_VERIFIED);// 已核销
			} else {// 部分还款
				tblDebtBaseInfo.setReturnStatus(DebtConstants.RETURN_STATUS_PART_PAYMENT);// 还款状态
				tblDebtBaseInfo.setStatus(DebtConstants.INVOICE_STATUS_PURCHASED);// 发票状态
			}
		}
		RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
		BeanUtils.copyProperties(tblDebtBaseInfo, rBcpDebtBaseInfo);
		return rBcpDebtBaseInfo;
	}

	/**
	 *
	 * @Description: 还款时，为已核销的发票添加业务流水信息
	 * @author lei.wang
	 * @Created 2012-7-30下午01:51:26
	 * @param insertDebtList
	 * @param debtBaseVO
	 * @throws CommonException
	 */
	@Override
	@Transactional
	public void saveDebtBussInfoWhenCanceled(List<DebtBillsInfoVO> insertDebtList, DebtBussInfoVO debtBaseVO) throws ScubeBizException {
		// String toSallerFlag=debtBaseVO.getIsInSeller();
		RBcpDebtBussInfo debtCancelBussInfo = new RBcpDebtBussInfo();// 流水总表
		String bussType = "";
		int number = 0;// 记录核销发票个数
		for (int i = 0; i < insertDebtList.size(); i++) {
			DebtBillsInfoVO debtVO = (DebtBillsInfoVO) insertDebtList.get(i);
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo tblDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(debtVO.getId());// debBaseVO更改为debtVO
																																			// mengjiajia;
			BigDecimal payPrincipalAmount = debtVO.getPayPrincipalAmount() == null ? new BigDecimal("0") : debtVO.getPayPrincipalAmount();// 还本
			BigDecimal payRateAmount = debtVO.getPayRateAmount() == null ? new BigDecimal("0") : debtVO.getPayRateAmount();// 还息
			BigDecimal removeAmount = debtVO.getRemoveAmount() == null ? new BigDecimal("0") : debtVO.getRemoveAmount();// 发票冲销金额
			// 1：为核销的发票信息，添加到流水详细信息
			RBcpDebtBussDtl debtBussDetail = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(debtVO, debtBussDetail);
			bussType = tblDebtBaseInfo.getBussType();
			debtBussDetail.setId(UUIDGeneratorUtil.generate());
			debtBussDetail.setDebtId(tblDebtBaseInfo.getId());// 发票id
			debtBussDetail.setApplyType(DebtConstants.APPLY_TYPE_VERIFY);// 申请类型
			debtBussDetail.setCustcdBuyer(debtBaseVO.getCustcdBuyer());// 买方
			// debtBussDetail.setCnameBuyer(debtBaseVO.getCnameBuyer());//买方名称
			// debtBussDetail.setCnameSeller(debtBaseVO.getCnameSeller());//卖方名称
			debtBussDetail.setCustcdSaller(debtBaseVO.getCustcdSaller());// 卖方
			debtBussDetail.setAppno(debtBaseVO.getAppno());// 申请号
			debtBussDetail.setMastContno(debtBaseVO.getMastContno());// 合同
			debtBussDetail.setLoanWay(debtVO.getLoanWay());// 出账方式
			debtBussDetail.setBussType(tblDebtBaseInfo.getBussType());// 业务品种
			debtBussDetail.setStatus(DebtConstants.INVOICE_STATUS_VERIFIED);// 已核销
			debtBussDetail.setAging(tblDebtBaseInfo.getAging());// 账龄
			debtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			debtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			debtBussDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));// 核销日期
			debtBussDetail.setMoney(removeAmount);// 核销金额
			debtBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));// 核销日期
			iRBcpDebtBussDtlService.addRBcpDebtBussDtl(debtBussDetail);
			// 2：统计核销的发票信息
			number++;// 记录增加
			debtCancelBussInfo.setDebtNum(number);// 记录付给流水总表
			BigDecimal returnAmount = debtCancelBussInfo.getReturnAmount() == null ? new BigDecimal("0") : debtCancelBussInfo.getReturnAmount();// 流水还款金额
			debtCancelBussInfo.setReturnAmount(debtCancelBussInfo.getReturnAmount() == null ? removeAmount : removeAmount.add(returnAmount));// 发票还款金额
			BigDecimal rateAmount = debtCancelBussInfo.getReturnInterestAmount() == null ? new BigDecimal("0")
					: debtCancelBussInfo.getReturnInterestAmount();// 流水还息金额
			BigDecimal captionAmount = debtCancelBussInfo.getReturnCapitalAmount() == null ? new BigDecimal("0")
					: debtCancelBussInfo.getReturnCapitalAmount();// 流水还本金额
			debtCancelBussInfo.setReturnCapitalAmount(
					debtCancelBussInfo.getReturnCapitalAmount() == null ? payPrincipalAmount : payPrincipalAmount.add(captionAmount));// 发票还本金额
			debtCancelBussInfo
					.setReturnInterestAmount(debtCancelBussInfo.getReturnInterestAmount() == null ? payRateAmount : payRateAmount.add(rateAmount));// 发票还息金额
		}
		// 核销发起流水业务
		if (number > 0) {// 若有核销的发票
			// 保存流水总表
			debtCancelBussInfo.setId(UUIDGeneratorUtil.generate());
			debtCancelBussInfo.setCustcdBuyer(debtBaseVO.getCustcdBuyer());// 买方
			debtCancelBussInfo.setCustcdSaller(debtBaseVO.getCustcdSaller());// 卖方
			debtCancelBussInfo.setAppno(debtBaseVO.getAppno());// 申请号
			debtCancelBussInfo.setMastContno(debtBaseVO.getMastContno());// 合同
			debtCancelBussInfo.setApplyType(DebtConstants.APPLY_TYPE_VERIFY);// 申请类型
			debtCancelBussInfo.setCostAccount(debtBaseVO.getBalanceAccount());// 帐号
			// debtCancelBussInfo.setTotalDebtAmount(debtVO.getTotalBillsAmount());
			debtCancelBussInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			debtCancelBussInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			debtCancelBussInfo.setAppDate(ScfDateUtil.formatDate(new Date()));
			debtCancelBussInfo.setInsertDate(ScfDateUtil.formatDate(new Date()));
			debtCancelBussInfo.setBussType(bussType);
			debtCancelBussInfo.setAmount(debtCancelBussInfo.getReturnAmount());
			rbcpdebtbussinfoservice.addRBcpDebtBussInfo(debtCancelBussInfo);
		}
	}

	@Override
	public Page invoiceBuyerPayList(DebtCommonQryVO debtCommonQryVO) {
		Page pageQueryResult = new Page();
		String id_Q = debtCommonQryVO.getId_Q();
		int pageIndex = debtCommonQryVO.getPageIndex();
		int pageSize = debtCommonQryVO.getPageSize();
		List<String> orderFileds = new ArrayList<String>();
		orderFileds.add("debtEnd asc");
		orderFileds.add("loanEndDate asc");
		orderFileds.add("billsNo");
		pageQueryResult = iRBcpDebtBaseInfoDAO.getInvoiceSelectedQuery(id_Q, pageIndex, pageSize, orderFileds);
		Iterator iterator = pageQueryResult.getRecords().iterator();
		List resultList = new ArrayList();
		while (iterator.hasNext()) {
			DebtBillsInfoVO debtVO = new DebtBillsInfoVO();
			BeanUtils.copyProperties(debtVO, iterator.next());
			resultList.add(debtVO);
		}
		pageQueryResult.setRecords(resultList);

		return pageQueryResult;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getInvoiceSelectedQuery(DebtCommonQryVO commonQueryVO) {
		String id_Q = commonQueryVO.getId_Q();
		int pageIndex = commonQueryVO.getPageIndex();
		int pageSize = commonQueryVO.getPageSize();
		Page pageQueryResult = iRBcpDebtBaseInfoDAO.getInvoiceSelectedQuery(id_Q, pageIndex, pageSize, null);
		if (null != pageQueryResult) {
			Iterator iterator = pageQueryResult.getRecords().iterator();
			List list = new ArrayList();
			while (iterator.hasNext()) {
				DebtBillsInfoVO debtVO = new DebtBillsInfoVO();
				BeanUtils.copyProperties(debtVO, iterator.next());
				list.add(debtVO);
			}
			pageQueryResult.setRecords(list);
		}
		return pageQueryResult;
	}

	@Override
	public Page getDebtBackActImpInfoQuery(DebtCommonQryVO commonQueryVO, Page page) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (StringUtils.isNotEmpty(commonQueryVO.getCustcdSaller_Q())) { // 卖方名称
			parameters.put("custcdSaller_Q", commonQueryVO.getCustcdSaller_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getMastContno())) { // 合同号
			parameters.put("mastContno", commonQueryVO.getMastContno());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getContStatus_Q())) { // 合同状态
			parameters.put("contStatus_Q", commonQueryVO.getContStatus_Q());
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getBussType_Q())) { // 保理业务类型
			parameters.put("bussType_Q", commonQueryVO.getBussType_Q());
		}
		if (commonQueryVO.getBussTypeList_Q()!=null && commonQueryVO.getBussTypeList_Q().size()>0) {
			parameters.put("bussTypeList", commonQueryVO.getBussTypeList_Q());
		}

		// if(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER.equals(commonQueryVO.getFlag_Q())){//按主管客户经理查询
		// sb.append(" and tbpd.mgrno = '" +
		// GlobalInfo.getCurrentInstance().getTlrno() + "'");
		// }else
		// if(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL.equals(commonQueryVO.getFlag_Q())){//按机构
		// //
		// sb.append(BctlService.getInstance().getBctlQueryCondition("tbpd.brcode",
		// SCFConstants.QUERY_TYPE_ALL,
		// GlobalInfo.getCurrentInstance().getBrcode()));
		// sb.append(" and exists (select 1 from Bctl_Affiliation where
		// child_Brcode = tbpd.brcode and parent_Brcode =
		// '"+GlobalInfo.getCurrentInstance().getBrcode()+"'"
		// + " and affiliation_Type = '"+ SCFConstants.BCTL_AFFILIATION_BELONG +
		// "')");
		// }else
		// if(ScfBasConstant.CUST_QUERY_TYPE_BY_MAA.equals(commonQueryVO.getFlag_Q())){//按主管客户经理+协管客户经理
		// sb.append(CustomerService.getInstance().getCustcdsQueryCondition("tbpd.custcd",
		// ScfBasConstant.QUERY_TYPE_MAG_ALL,
		// GlobalInfo.getCurrentInstance().getTlrno()));
		// }
		//
		List list = iRBcpDebtBaseInfoDAO.getDebtBackActImpInfoQuery(parameters, page);
		Integer count = iRBcpDebtBaseInfoDAO.getDebtBackActImpInfoQueryCount(parameters);
		Page pageResult = new Page(page.getPageSize(), page.getPageNo(), 0);

		pageResult.setRecords(list);
		pageResult.setTotalRecord(count);

		return pageResult;
	}

	/**
	 * 入池发票入池保存
	 *
	 * @author lu.chen
	 * @date 2011-10-10
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 * @throws CommonException
	 */
	@Override
	public void invoiceInpoolAddSave(List<RBcpDebtBaseInfo> insertDebtList, DebtBussInfoVO debtVO) throws ScubeBizException {
		String financingType = debtVO.getFinancingType();
		// DebtBillsInfoVO billvo = new DebtBillsInfoVO();
		// 修改发票入池状态
		for (RBcpDebtBaseInfo baseinfo : insertDebtList) {
			// BeanUtils.copyProperties(baseinfo, billvo);
			RBcpDebtBaseInfo debtBaseInfo = findRBcpDebtBaseInfoByPrimaryKey(baseinfo.getId());// billvo替换为baseinfo
			if (DebtConstants.FINANCING_TYPE_POOL.equals(financingType)) {
				debtBaseInfo.setPoolFlag("1");
			} else if (DebtConstants.FINANCING_TYPE_INVOICE.equals(financingType)) {
				debtBaseInfo.setPoolFlag("");
			} else {
				debtBaseInfo.setPoolFlag("1");
			}
			debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			debtBaseInfo.setLockAppno(null);
			updateRBcpDebtBaseInfo(debtBaseInfo);
		}
	}

	/**
	 * 应收账款信息查询
	 * 
	 * @param pageNo,
	 * @param pageSize
	 * @param commonQueryVO
	 * @return
	 */
	@Override
	public Page getDebtInfoByPerson(int pageNo, int pageSize, DebtCommonQryVO commonQueryVO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(commonQueryVO.getCustcdSaller_Q())) {
			parameters.put("custcdSaller_Q", commonQueryVO.getCustcdSaller_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getCustcdBuyer_Q())) {
			parameters.put("custcdBuyer_Q", commonQueryVO.getCustcdBuyer_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getMastContno())) {
			parameters.put("mastContno", commonQueryVO.getMastContno());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getBussType_Q())) {
			parameters.put("bussType_Q", commonQueryVO.getBussType_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getBillsNo_Q())) {
			parameters.put("billsNo_Q", commonQueryVO.getBillsNo_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getBillsType_Q())) {
			parameters.put("billsType_Q", commonQueryVO.getBillsType_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getStart_Q())) {
			parameters.put("start_Q", commonQueryVO.getStart_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getEnd_Q())) {
			parameters.put("end_Q", commonQueryVO.getEnd_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getDebtEnd_from_Q())) {
			parameters.put("debtEnd_from_Q", commonQueryVO.getDebtEnd_from_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getDebtEnd_to_Q())) {
			parameters.put("debtEnd_to_Q", commonQueryVO.getDebtEnd_to_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getStatus_Q())) {
			parameters.put("status_Q", commonQueryVO.getStatus_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getLoanWay_Q())) {
			parameters.put("LoanWay_Q", commonQueryVO.getLoanWay_Q());
		}
		if (StringUtils.isNotBlank(commonQueryVO.getBrcode())) {
			parameters.put("brcode", commonQueryVO.getBrcode());
		}
		List listResult = iRBcpDebtBaseInfoDAO.selectDebtInfoByPerson(pageNo, pageSize, parameters);
		Integer count = listResult.size();
		Page page = new Page(pageSize, pageNo, 0);
		page.setTotalRecord(count);
		page.setRecords(listResult);
		return page;
	}

	/**
	 * 核销申请审批通过
	 */
	@Transactional
	@Override
	public void factoringChargeOffAddSave(List<RBcpDebtBaseInfo> insertDebtList, RBcpDebtBussInfo tblDebtBussInfo) throws ScubeBizException {
		DebtBillsInfoVO baseDebtVo = new DebtBillsInfoVO();

		if (insertDebtList != null && insertDebtList.size() > 0) {

			for (RBcpDebtBaseInfo baseinfo : insertDebtList) {
				BeanUtils.copyProperties(baseinfo, baseDebtVo);

				// mengjiajia 核销金额与可融资余额相同，故直接使用
				BigDecimal rebateAmounts = baseDebtVo.getRemainingAmount() == null ? new BigDecimal("0") : baseDebtVo.getRemainingAmount();// 核销金额
				RBcpDebtBaseInfo tblDebtBaseInfo = this.updateDebtStateByRemainingAmount(baseDebtVo, rebateAmounts, null, null);

				RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
				BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);

				tblDebtBussDetail.setId(UUIDGeneratorUtil.generate());
				tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
				tblDebtBussDetail.setApplyType(tblDebtBussInfo.getApplyType());
				tblDebtBussDetail.setAppno(tblDebtBussInfo.getAppno());
				tblDebtBussDetail.setBussType(tblDebtBaseInfo.getBussType());
				tblDebtBussDetail.setRemoveAmount(tblDebtBussInfo.getAmount());// 核销金额
				tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
				tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
				tblDebtBussDetail.setReason(tblDebtBussInfo.getReason());
				tblDebtBussDetail.setOtherReason(tblDebtBussInfo.getOtherReason());
				tblDebtBussDetail.setMoney(tblDebtBussInfo.getAmount());
				iRBcpDebtBussDtlService.addRBcpDebtBussDtl(tblDebtBussDetail);

				BigDecimal removeAmount = tblDebtBaseInfo.getRemoveAmount() == null ? new BigDecimal("0") : tblDebtBaseInfo.getRemoveAmount();// 发票核销金额
				tblDebtBaseInfo.setRemoveAmount(removeAmount.add(rebateAmounts));
				BigDecimal remainingUseableAmount = tblDebtBaseInfo.getRemainingUseableAmount() == null ? new BigDecimal("0")
						: tblDebtBaseInfo.getRemainingUseableAmount();
				BigDecimal loanPercent = tblDebtBaseInfo.getLoanPercent() == null ? new BigDecimal("0") : tblDebtBaseInfo.getLoanPercent();
				tblDebtBaseInfo.setRemainingUseableAmount(remainingUseableAmount
						.subtract(rebateAmounts.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));// 发票可融资余额
				BigDecimal remainingAmount = tblDebtBaseInfo.getRemainingAmount() == null ? new BigDecimal("0")
						: tblDebtBaseInfo.getRemainingAmount();// 发票余额
				BigDecimal amount = remainingAmount.subtract(rebateAmounts);// 得到核销后发票余额
				tblDebtBaseInfo.setRemainingAmount(amount);
				log.info("核销后金额:——————————————————————" + baseDebtVo.getRebatebalance());
				/*
				 * if((baseDebtVo.getRebatebalance()==null?new
				 * BigDecimal("0"):baseDebtVo.getRebatebalance()).compareTo(num)
				 * ==0){
				 * tblDebtBaseInfo.setStatus(DebtConstants.INVOICE_STATUS_03); }
				 */

				tblDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
				tblDebtBaseInfo.setLockAppno("");

				this.updateRBcpDebtBaseInfo(tblDebtBaseInfo);

			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService#
	 * selectRBcpDebtBaseInfoForPay(int, int,
	 * com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo)
	 */
	@Override
	public Page selectRBcpDebtBaseInfoForPay(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		Criteria cri = example.createCriteria();
		if (rBcpDebtBaseInfo != null && !"".equals(rBcpDebtBaseInfo)) {
			// 1.（凭证编号）billsNo
			if (rBcpDebtBaseInfo.getBillsNo() != null && !"".equals(rBcpDebtBaseInfo.getBillsNo())) {
				cri.andBillsNoEqualTo(rBcpDebtBaseInfo.getBillsNo());
			}
			// 2.status应收账款单据状态 （发票状态已承购）
			cri.andStatusEqualTo(DebtConstants.INVOICE_STATUS_PURCHASED);

			// debetNo (要未融资)
			cri.andDebetNoIsNull();

			// loanWay
			cri.andLoanWayIsNull();

			// 3. billsDate，（应收账款日期从）billsDateFrom, 大于等于,billsDateTo 小于等于,
			if (rBcpDebtBaseInfo.getBillsDateFrom() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateFrom())) {
				cri.andBillsDateGreaterThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateFrom());
			}
			// 4.billsDate，（应收账款日期到）billsDateTo 小于等于
			if (rBcpDebtBaseInfo.getBillsDateTo() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateTo())) {
				cri.andBillsDateLessThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateTo());
			}
			// 5.debtEnd，（应收账款到期日从） debtEndFrom 大于等于
			if (rBcpDebtBaseInfo.getDebtEndFrom() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndFrom())) {
				cri.andDebtEndGreaterThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndFrom());
			}
			// 6.debtEnd，（应收账款到期日到）debtEndTo 小于等于
			if (rBcpDebtBaseInfo.getDebtEndTo() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndTo())) {
				cri.andDebtEndLessThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndTo());
			}
			// 7.锁定状态 isLocked（根据有无申请号）
			if (rBcpDebtBaseInfo.getIsLocked() != null) {
				cri.andIsLockedEqualTo(ScfBasConstant.UNLOCKED);
			} else {
				cri.andIsLockedIsNull();
			}
			// 8.商纠状态 issueFlag(无商纠)
			cri.andIssueFlagEqualTo(DebtConstants.ISSUE_FLAG_FALSE);

			// 9. poolFlag !"".equals(rBcpDebtBaseInfo.getPoolFlag() 代码不能去掉
			if (rBcpDebtBaseInfo.getPoolFlag() != null && !"".equals(rBcpDebtBaseInfo.getPoolFlag())) {
				cri.andPoolFlagEqualTo(rBcpDebtBaseInfo.getPoolFlag());
			}
			// 10. remainingAmount (必须大于零)
			cri.andRemainingAmountGreaterThan(new BigDecimal(0));

			// 11.loanRemainingAmount(必须等于零)
			cri.andLoanRemainingAmountEqualTo(new BigDecimal(0));

			// 12.overdueFlag 逾期状态,未逾期
			cri.andOverdueFlagEqualTo(DebtConstants.OVERDUE_FLAG_NORMAL);

			// 13.badFlag 呆账状态：否
			cri.andBadFlagEqualTo(DebtConstants.BAD_FLAG_FALSE);

			// 14.BillsAmountFrom
			if (rBcpDebtBaseInfo.getBillsAmountFrom() != null && !"".equals(rBcpDebtBaseInfo.getBillsAmountFrom())) {
				cri.andBillsAmountGreaterThanOrEqualTo(rBcpDebtBaseInfo.getBillsAmountFrom());
			}

			// 15.BillsAmountTo
			if (rBcpDebtBaseInfo.getBillsAmountTo() != null && !"".equals(rBcpDebtBaseInfo.getBillsAmountTo())) {
				cri.andBillsAmountLessThanOrEqualTo(rBcpDebtBaseInfo.getBillsAmountTo());
			}

			// 16.custcdBuyer
			if (rBcpDebtBaseInfo.getCustcdBuyer() != null) {
				cri.andCustcdBuyerEqualTo(rBcpDebtBaseInfo.getCustcdBuyer());
			}

			// 17.bussType
			if (rBcpDebtBaseInfo.getBussType() != null) {
				cri.andBussTypeEqualTo(rBcpDebtBaseInfo.getBussType());
			}
			if (StringUtil.isStrNotEmpty(rBcpDebtBaseInfo.getMastContno())) {
				cri.andMastContnoEqualTo(rBcpDebtBaseInfo.getMastContno());
			}
			try {
				example.setOrderByClause(" INSERT_DATE desc");// 按照登记日期排序
				// 业务品种实际存储的是产品ID，到产品中查询就行了。
				List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByPage(example, p);
				p.setRecords(rBcpDebtBaseInfoList);
				return p;
			} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
				log.error("条件分页查询条件分页查询应收账款信息失败！");
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
						RBcpErrorConstant.SCF_REC_BCP_10009);
			}

		} else {
			return p;
		}
	}

	/*
	 * 用于商纠首页
	 * 
	 * @lihao
	 */
	@Override
	public int countRBcpDebtBaseInfoByKey(RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		if (rBcpDebtBaseInfo == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		Criteria cri = example.createCriteria();
		// 根据卖方
		if (rBcpDebtBaseInfo.getMastContno() == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		} else {
			cri.andMastContnoEqualTo(rBcpDebtBaseInfo.getMastContno());
		}
		// 根据合同号
		if (rBcpDebtBaseInfo.getCustcdSaller() == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		} else {
			cri.andCustcdSallerEqualTo(rBcpDebtBaseInfo.getCustcdSaller());
		}
		// 根据商纠状态
		if (rBcpDebtBaseInfo.getIssueFlag() != null) {
			cri.andIssueFlagEqualTo(rBcpDebtBaseInfo.getIssueFlag());
		}
		// 根据池还是非池
		if (rBcpDebtBaseInfo.getFactType() != null) {
			cri.andFactTypeEqualTo(rBcpDebtBaseInfo.getFactType());
		}
		int n = iRBcpDebtBaseInfoDAO.countByExample(example);
		return n;
	}

	/*
	 * 减值页面信息回显
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService#
	 * findRBcpDebtBaseInfoForImpair(int, int,
	 * com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo)
	 */
	@Override
	public Page findRBcpDebtBaseInfoForImpair(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		if (rBcpDebtBaseInfo == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (rBcpDebtBaseInfo.getLockAppno() == null || "".equals(rBcpDebtBaseInfo.getLockAppno())) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}

		Page p = new Page(pageSize, pageNo, 0);
		ArrayList<RBcpDebtBaseInfo> arrayList = new ArrayList<com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo>();
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		example.createCriteria().andLockAppnoEqualTo(rBcpDebtBaseInfo.getLockAppno());
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByPage(example, p);
			if (rBcpDebtBaseInfoList != null && rBcpDebtBaseInfoList.size() > 0) {
				for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 : rBcpDebtBaseInfoList) {
					com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo rBcpDebtBaseInfo2 = new com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo();
					try {
						BeanUtils.copyProperties(rBcpDebtBaseInfo1, rBcpDebtBaseInfo2);
					} catch (Exception e) {// 10001 = 转换异常！
						throw new ScubeBizException(
								com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001),
								RBcpErrorConstant.SCF_REC_BCP_10001);
					}
					RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
					com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample.Criteria createCriteria = rBcpAppliBussDtlExample.createCriteria();
					// 根据申请号和单据ID锁定对应明细信息
					// 查询本次减值金额 rebateAmounts 计算rebatebalance 减值后余额（放在前台）
					createCriteria.andAppnoEqualTo(rBcpDebtBaseInfo.getLockAppno());
					createCriteria.andDebtIdEqualTo(rBcpDebtBaseInfo2.getId());
					List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO
							.selectByExample(rBcpAppliBussDtlExample);
					if (rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() == 1) {
						rBcpDebtBaseInfo2.setRebateAmounts(rBcpAppliBussDtlList.get(0).getRebateAmount());
					}
					arrayList.add(rBcpDebtBaseInfo2);

				}
			}
		} catch (Exception e) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
					RBcpErrorConstant.SCF_REC_BCP_10009);
		}

		p.setRecords(arrayList);
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService#
	 * findRBcpDebtBaseForImpair(int, int,
	 * com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo)
	 */
	@Override
	public Page findRBcpDebtBaseForImpair(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		if (rBcpDebtBaseInfo == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// custcdSaller,custcdBuyer
		Page p = new Page(pageSize, pageNo, 0);
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		Criteria cri = example.createCriteria();
		if (rBcpDebtBaseInfo != null && !"".equals(rBcpDebtBaseInfo)) {
			// 1.（业务合同编号）mastContno）
			if (rBcpDebtBaseInfo.getMastContno() != null && !"".equals(rBcpDebtBaseInfo.getMastContno())) {
				cri.andMastContnoEqualTo(rBcpDebtBaseInfo.getMastContno());
			}
			// 2.（凭证编号）billsNo
			if (rBcpDebtBaseInfo.getBillsNo() != null && !"".equals(rBcpDebtBaseInfo.getBillsNo())) {
				cri.andBillsNoLike("%" + rBcpDebtBaseInfo.getBillsNo() + "%");
			}
			// 卖方客户号 custcdSaller
			if (rBcpDebtBaseInfo.getCustcdSaller() != null && !"".equals(rBcpDebtBaseInfo.getCustcdSaller())) {
				cri.andCustcdSallerEqualTo(rBcpDebtBaseInfo.getCustcdSaller());
			}
			// 买方客户号
			if (rBcpDebtBaseInfo.getCustcdBuyer() != null && !"".equals(rBcpDebtBaseInfo.getCustcdBuyer())) {
				cri.andCustcdBuyerEqualTo(rBcpDebtBaseInfo.getCustcdBuyer());
			}
			// 3.status 应收账款单据状态 为已转让或者已融资
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(RBcpDebtConstant.INVOICE_STATUS_PURCHASED);// 02-已转让
			arrayList.add(RBcpDebtConstant.INVOICE_STATUS_FINANCED);// 04-已融资
			cri.andStatusIn(arrayList);

			// 4. billsDate，（应收账款日期从）billsDateFrom, 大于等于,billsDateTo 小于等于,
			if (rBcpDebtBaseInfo.getBillsDateFrom() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateFrom())) {
				cri.andBillsDateGreaterThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateFrom());
			}
			// 5.billsDate，（应收账款日期到）billsDateTo 小于等于
			if (rBcpDebtBaseInfo.getBillsDateTo() != null && !"".equals(rBcpDebtBaseInfo.getBillsDateTo())) {
				cri.andBillsDateLessThanOrEqualTo(rBcpDebtBaseInfo.getBillsDateTo());
			}
			// 6.debtEnd，（应收账款到期日从） debtEndFrom 大于等于
			if (rBcpDebtBaseInfo.getDebtEndFrom() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndFrom())) {
				cri.andDebtEndGreaterThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndFrom());
			}
			// 7.debtEnd，（应收账款到期日到）debtEndTo 小于等于
			if (rBcpDebtBaseInfo.getDebtEndTo() != null && !"".equals(rBcpDebtBaseInfo.getDebtEndTo())) {
				cri.andDebtEndLessThanOrEqualTo(rBcpDebtBaseInfo.getDebtEndTo());
			}
			// 8.锁定状态 isLocked
			if (rBcpDebtBaseInfo.getIsLocked() != null && !"".equals(rBcpDebtBaseInfo.getIsLocked())) {
				cri.andIsLockedEqualTo(rBcpDebtBaseInfo.getIsLocked());
			}
			// 9.商纠状态 issueFlag
			if (rBcpDebtBaseInfo.getIssueFlag() != null && !"".equals(rBcpDebtBaseInfo.getIssueFlag())) {
				cri.andIssueFlagEqualTo(rBcpDebtBaseInfo.getIssueFlag());
			}
			// 10.瑕疵 flawFlag
			if (rBcpDebtBaseInfo.getFlawFlag() != null && !"".equals(rBcpDebtBaseInfo.getFlawFlag())) {
				cri.andFlawFlagEqualTo(rBcpDebtBaseInfo.getFlawFlag());
			}
			// 11.factType 保理业务类别
			if (rBcpDebtBaseInfo.getFactType() != null && !"".equals(rBcpDebtBaseInfo.getFactType())) {
				cri.andFactTypeEqualTo(rBcpDebtBaseInfo.getFactType());
			}
			// 12.凭证类型 billsType
			if (rBcpDebtBaseInfo.getBillsType() != null && !"".equals(rBcpDebtBaseInfo.getBillsType())) {
				cri.andBillsTypeEqualTo(rBcpDebtBaseInfo.getBillsType());
			}

			try {
				List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByPage(example, p);
				p.setRecords(rBcpDebtBaseInfoList);
			} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
						RBcpErrorConstant.SCF_REC_BCP_10009);
			}
		}
		return p;
	}

	/*
	 * 应收类转让新增单据
	 * 
	 * 
	 */
	@Override
	public Page findRBcpDebtBaseInfoPageForTransfer(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo, List<RBcpDebtBaseInfo> bcpDatasource)
			throws ScubeBizException {
		if (rBcpDebtBaseInfo == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		if (bcpDatasource != null && bcpDatasource.size() > 0) {
			for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : bcpDatasource) {
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (null != rBcpDebtBaseInfo) {
			String lockAppno = rBcpDebtBaseInfo.getLockAppno();
			String mastContno = rBcpDebtBaseInfo.getMastContno();
			String custcdBuyer = rBcpDebtBaseInfo.getCustcdBuyer();
			String custcdSaller = rBcpDebtBaseInfo.getCustcdSaller();

			String billsDateFrom = rBcpDebtBaseInfo.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtBaseInfo.getBillsDateTo();
			String debtEndFrom = rBcpDebtBaseInfo.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtBaseInfo.getDebtEndTo();

			String billsNo = rBcpDebtBaseInfo.getBillsNo(); // 凭证编号
			String factType = rBcpDebtBaseInfo.getFactType();
			String flawFlag = rBcpDebtBaseInfo.getFlawFlag();
			String billsType = rBcpDebtBaseInfo.getBillsType(); // 凭证类型
			map.put("lockAppno", lockAppno);
			map.put("mastContno", mastContno);
			map.put("custcdBuyer", custcdBuyer);
			map.put("custcdSaller", custcdSaller);
			map.put("flawFlag", flawFlag);
			map.put("billsDateFrom", billsDateFrom);
			map.put("billsDateTo", billsDateTo);
			map.put("debtEndFrom", debtEndFrom);
			map.put("debtEndTo", debtEndTo);
			map.put("factType", factType);

			map.put("billsNo", billsNo);
			map.put("billsType", billsType);
			map.put("billsNoList", arrayList);
		}
		iRBcpDebtBaseInfoDAO.getDebtInvoiceInfoTransfer(map, page);
		return page;

	}

	/*
	 * 应收类商纠登记页面添加单据查询
	 * 
	 * 
	 */
	@Override
	public Page findRBcpDebtBaseInfoForPRegister(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo, List<RBcpDebtBaseInfo> bcpDatasource)
			throws ScubeBizException {
		if (rBcpDebtBaseInfo == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		if (bcpDatasource != null && bcpDatasource.size() > 0) {
			for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : bcpDatasource) {
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (null != rBcpDebtBaseInfo) {
			String lockAppno = rBcpDebtBaseInfo.getLockAppno();
			String mastContno = rBcpDebtBaseInfo.getMastContno();
			String custcdBuyer = rBcpDebtBaseInfo.getCustcdBuyer();
			String custcdSaller = rBcpDebtBaseInfo.getCustcdSaller();

			String billsDateFrom = rBcpDebtBaseInfo.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtBaseInfo.getBillsDateTo();
			String debtEndFrom = rBcpDebtBaseInfo.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtBaseInfo.getDebtEndTo();

			String billsNo = rBcpDebtBaseInfo.getBillsNo(); // 凭证编号
			String factType = rBcpDebtBaseInfo.getFactType();
			String flawFlag = rBcpDebtBaseInfo.getFlawFlag();
			String billsType = rBcpDebtBaseInfo.getBillsType(); // 凭证类型
			String poolFlag = rBcpDebtBaseInfo.getPoolFlag(); // 入池标识
			map.put("lockAppno", lockAppno);
			map.put("mastContno", mastContno);
			map.put("custcdBuyer", custcdBuyer);

			map.put("custcdSaller", custcdSaller);
			map.put("flawFlag", flawFlag);
			map.put("billsDateFrom", billsDateFrom);

			map.put("billsDateTo", billsDateTo);
			map.put("debtEndFrom", debtEndFrom);

			map.put("debtEndTo", debtEndTo);
			map.put("factType", factType);
			map.put("poolFlag", poolFlag);

			map.put("billsNo", billsNo);
			map.put("billsType", billsType);
			map.put("billsNoList", arrayList);
		}
		iRBcpDebtBaseInfoDAO.getDebtInvoiceInfoRegister(map, page);

		return page;
	}

	// 池融资纠纷解除（选择有纠纷的单据信息）,返回给页面的直接就是应收账款历程明细信息
	@Override
	public Page findRBcpDebtBaseInfoForPDRemove(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo, List<RBcpDebtBaseInfo> bcpDatasource)
			throws ScubeBizException {
		if (rBcpDebtBaseInfo == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		if (bcpDatasource != null && bcpDatasource.size() > 0) {
			for (RBcpDebtBaseInfo rBcpDebtBaseInfo1 : bcpDatasource) {
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (null != rBcpDebtBaseInfo) {
			String lockAppno = rBcpDebtBaseInfo.getLockAppno();
			String mastContno = rBcpDebtBaseInfo.getMastContno();
			String custcdBuyer = rBcpDebtBaseInfo.getCustcdBuyer();
			String custcdSaller = rBcpDebtBaseInfo.getCustcdSaller();

			String billsDateFrom = rBcpDebtBaseInfo.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtBaseInfo.getBillsDateTo();
			String debtEndFrom = rBcpDebtBaseInfo.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtBaseInfo.getDebtEndTo();

			String billsNo = rBcpDebtBaseInfo.getBillsNo(); // 凭证编号
			String factType = rBcpDebtBaseInfo.getFactType();
			String flawFlag = rBcpDebtBaseInfo.getFlawFlag();
			String billsType = rBcpDebtBaseInfo.getBillsType(); // 凭证类型
			String poolFlag = rBcpDebtBaseInfo.getPoolFlag(); // 入池标识
			map.put("lockAppno", lockAppno);
			map.put("mastContno", mastContno);
			map.put("custcdBuyer", custcdBuyer);

			map.put("custcdSaller", custcdSaller);
			map.put("flawFlag", flawFlag);
			map.put("billsDateFrom", billsDateFrom);

			map.put("billsDateTo", billsDateTo);
			map.put("debtEndFrom", debtEndFrom);

			map.put("debtEndTo", debtEndTo);
			map.put("factType", factType);
			map.put("poolFlag", poolFlag);

			map.put("billsNo", billsNo);
			map.put("billsType", billsType);
			map.put("billsNoList", arrayList);
		}
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.getDebtInvoiceInfoRemove(map, page);
			ArrayList<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> list = new ArrayList<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl>();

			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 : rBcpDebtBaseInfoList) {
				RBcpDebtBussDtlExample rBcpDebtBussDtlExample = new RBcpDebtBussDtlExample();
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample.Criteria rBcpDebtBussDtlCri = rBcpDebtBussDtlExample.createCriteria();
				rBcpDebtBussDtlCri.andDebtIdEqualTo(rBcpDebtBaseInfo1.getId());
				rBcpDebtBussDtlCri.andApplyTypeEqualTo(DebtConstants.APPLY_TYPE_ISSUE_SET);// 商纠设定
				rBcpDebtBussDtlExample.setOrderByClause(" APPNO desc");// 申请号是日期加上XXXX，取最大的（就是最新数据）
				List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> rBcpDebtBussDtlList = iRBcpDebtBussDtlDAO
						.selectByExample(rBcpDebtBussDtlExample);
				if (rBcpDebtBussDtlList != null && rBcpDebtBussDtlList.size() > 0) {
					rBcpDebtBussDtlList.get(0).setDeadline(rBcpDebtBaseInfo1.getDeadline());
					list.add(rBcpDebtBussDtlList.get(0));

				}
			}
			page.setRecords(list);

		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
					RBcpErrorConstant.SCF_REC_BCP_10009);
		}

		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService#
	 * findRBcpDebtBaseInfoForPDRemove2(int, int,
	 * com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo)
	 */
	@Override
	public Page findRBcpDebtBaseInfoForPDRemove2(int pageNo, int pageSize, RBcpDebtBaseInfo rBcpDebtBaseInfo) {
		if (rBcpDebtBaseInfo == null) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}

		Page page = new Page(pageSize, pageNo, 0);
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(rBcpDebtBaseInfo.getLockAppno());
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByPage(rBcpDebtBaseInfoExample,
					page);
			ArrayList<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> list = new ArrayList<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl>();

			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 : rBcpDebtBaseInfoList) {
				RBcpDebtBussDtlExample rBcpDebtBussDtlExample = new RBcpDebtBussDtlExample();
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample.Criteria rBcpDebtBussDtlCri = rBcpDebtBussDtlExample.createCriteria();
				rBcpDebtBussDtlCri.andDebtIdEqualTo(rBcpDebtBaseInfo1.getId());
				rBcpDebtBussDtlCri.andApplyTypeEqualTo(DebtConstants.APPLY_TYPE_ISSUE_SET);// 商纠设定
				rBcpDebtBussDtlExample.setOrderByClause(" APPNO desc");// 申请号是日期加上XXXX，取最大的（就是最新数据）
				List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> rBcpDebtBussDtlList = iRBcpDebtBussDtlDAO
						.selectByExample(rBcpDebtBussDtlExample);
				if (rBcpDebtBussDtlList != null && rBcpDebtBussDtlList.size() > 0) {
					rBcpDebtBussDtlList.get(0).setDeadline(rBcpDebtBaseInfo1.getDeadline());
					list.add(rBcpDebtBussDtlList.get(0));

				}
			}
			page.setRecords(list);

		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
					RBcpErrorConstant.SCF_REC_BCP_10009);
		}

		return page;
	}

}
