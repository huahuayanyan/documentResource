package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICustomerService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfoVO;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfoExample;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussInfoService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * 应收账款管理 接口实现类
 * </p>
 *
 * @author mengjiajia
 * @date 2017年5月22日下午3:38:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月22日下午3:38:11	     新增
 *
 *            </pre>
 */

@ScubeService
@Service("RBcpDebtInfoServiceImpl")
public class RBcpDebtInfoServiceImpl implements IRBcpDebtInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	/*
	 * scf.rec.bcp.10001 = 转换异常！ 10002 = 该应收账款信息已存在！ 10003 = 应收账款新增失败！ 10004 =
	 * 应收账款查询重复数据失败！ 10005 = 前台所传数据无效！ 10006 = 应收账款删除失败！ 10007 = 应收账款修改失败！ 10008
	 * = 查询具体应收账款信息失败！ 10009- 条件分页查询条件分页查询应收账款信息失败
	 */
	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rbcpdebtinfodao;

	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;

	@Resource(name = "NRBcpDebtBussDtlServiceImpl")
	INRBcpDebtBussDtlService nrbcpdebtbussdtlservice;
	// 客户管理
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	// 业务品种
	@Resource(name = "BPrdInfoDAO")
	private IBPrdInfoDAO bPrdInfoDAO;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bbrpprdfactoringservice;

	@Autowired
	ICustomerService customerservice;

	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO rbcpdebtbussdtldao;

	@Resource(name = "NRBcpDebtBussInfoServiceImpl")
	INRBcpDebtBussInfoService nrbcpdebtbussinfoservice;

	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bpbcapplibaseinfodao;
	
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rbcpapplibussdtldao;
	
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rbcpapplibussinfo;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	/**
	 * 新增应收账款信息
	 * 
	 * @param rBcpDebtInfoVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日下午3:57:41
	 */
	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public String addRBcpDebtInfo(RBcpDebtInfoVO rBcpDebtInfoVO)
	{
		log.debug("应收账款信息添加");
		if(rBcpDebtInfoVO != null && !"".equals(rBcpDebtInfoVO))
		{
			RBcpDebtInfo rBcpDebtInfo = new RBcpDebtInfo();
			try
			{
				BeanUtils.copyProperties(rBcpDebtInfoVO, rBcpDebtInfo);
			}catch (Exception e)
			{// 10001 = 转换异常！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
						.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001), RBcpErrorConstant.SCF_REC_BCP_10001);
			}
			// 需要通过debtVO.getBillsNo(),debtVO.getCustcdSaller(),debtVO.getMastContno()
			RBcpDebtInfoVO debtInfoVO = new RBcpDebtInfoVO();
			debtInfoVO.setBillsNo(rBcpDebtInfo.getBillsNo());
			debtInfoVO.setCustcdSaller(rBcpDebtInfo.getCustcdSaller());
			debtInfoVO.setCustcdBuyer(rBcpDebtInfo.getCustcdBuyer());
			debtInfoVO.setMastContno(rBcpDebtInfo.getMastContno());
			RBcpDebtInfoVO debtInfoVO2 = this.findRBcpDebtInfoByKey(debtInfoVO);
			if(debtInfoVO2 != null)
			{// 去重！
				throw new ScubeBizException("凭证编号为" + debtInfoVO2.getBillsNo() + "的单据信息已存在，请重新输入凭证编号！");
			}
			try
			{// 应收账款基本信息新增成功之后，再新增应收账款单据基本信息(在新增应收账款单据信息的同时新增应收账款单据明细信息)
				String insertTime = ScfDateUtil.getStringDate(new Date());
				if(rBcpDebtInfoVO.getDueTime() != null && !"".equals(rBcpDebtInfoVO.getDueTime()))
				{
					Date DebtEnd = ScfDateUtil.toDate(rBcpDebtInfo.getDebtEnd(), "yyyyMMdd");
					long DebtEndMil = DebtEnd.getTime();
					int DueTime = Integer.parseInt(debtInfoVO.getDueTime());
					long DueTimeMil = (long) DueTime * 24 * 60 * 60 * 1000;
					Date date2 = new Date(DueTimeMil + DebtEndMil);
					String y = date2.getYear() + "";
					String m = date2.getMonth() + "";
					String d = date2.getDay() + "";
					if(date2.getMonth() < 10)
					{
						m = "0" + m;
					}
					if(date2.getDay() < 10)
					{
						d = "0" + d;
					}
					debtInfoVO.setAssurePayDate(y + m + d);
				}
				// 池融资页面已经传了poolFlag
				rBcpDebtInfo.setInsertDate(insertTime);// 录入时间
				rBcpDebtInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);// 未锁定状态
				rBcpDebtInfo.setIssueFlag(RBcpDebtConstant.ISSUE_FLAG_TPYE_FALSE);// 无商纠
				rBcpDebtInfo.setOverdueFlag(RBcpDebtConstant.OVERDUE_FLAG_NORMAL);// 无逾期
				rBcpDebtInfo.setFlawFlag(RBcpDebtConstant.FLAW_FLAG_FALSE);// 无瑕疵
				rBcpDebtInfo.setStatus(RBcpDebtConstant.INVOICE_STATUS_PURCHASED);// 状态为已转让
				rBcpDebtInfo.setIssueTimes(new BigDecimal(RBcpDebtConstant.R_BCP_ISSUETIMES));// 商纠次数0
				rBcpDebtInfo.setBadFlag(RBcpDebtConstant.BAD_FLAG_TYPE_FALSE);
				rBcpDebtInfo.setLoanOverdueFlag(RBcpDebtConstant.LOAN_OVERDUE_FLAG_NORMAL);
				rBcpDebtInfo.setContStatus(ScfBasConstant.PROTOCOL_STATE_INVALID);
				rBcpDebtInfo.setId(UUIDGeneratorUtil.generate());
				rBcpDebtInfo.setLoanAmount(BigDecimal.ZERO);// 本次融资金额
				rBcpDebtInfo.setLoanRemainingAmount(rBcpDebtInfoVO.getRemainingUseableAmount());
				rBcpDebtInfo.setLockAppno(null);

				BBrpPrdFactoring bBrpPrdFactoring = bbrpprdfactoringservice
						.findBBrpPrdFactoringByKey(rBcpDebtInfo.getBussType());
				if(bBrpPrdFactoring != null)
				{
					rBcpDebtInfo.setFactType(bBrpPrdFactoring.getFactType());
					// rBcpDebtInfo.setFinancingType(bBrpPrdFactoring.getFinancingType());
				}
				rbcpdebtinfodao.insertSelective(rBcpDebtInfo);
				// 应收账款基本信息新增成功之后，再新增应收账款单据基本信息(在新增应收账款单据信息的同时新增应收账款单据明细信息)
				// 设置明细表中的对应的应收账款基本信息ID
				RBcpDebtBussDtl rBcpDebtBussDtl = new RBcpDebtBussDtl();
				try
				{
					BeanUtils.copyProperties(rBcpDebtInfo, rBcpDebtBussDtl);
				}catch (Exception e)
				{// 10001 = 转换异常！
					throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(
							RBcpErrorConstant.SCF_REC_BCP_10001), RBcpErrorConstant.SCF_REC_BCP_10001);
				}
				rBcpDebtBussDtl.setAppno(rBcpDebtInfoVO.getLockAppno());
				rBcpDebtBussDtl.setDebtId(rBcpDebtInfo.getId());
				// 原来是新增对应的单据信息时为录入，现在直接就是转让
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
				String transferDate = simpleDateFormat.format(new Date());// 转让日期
				rBcpDebtBussDtl.setMoney(rBcpDebtInfo.getBillsAmount());// 转让出质的金额就是有效金额，就是票面金额
				rBcpDebtBussDtl.setPurchaseDate(transferDate);// 转让日期
				rBcpDebtBussDtl.setStatus(RBcpDebtConstant.INVOICE_STATUS_PURCHASED);// 状态为转让
				rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
				nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(rBcpDebtBussDtl);
				return rBcpDebtInfo.getId();
			}catch (Exception e)
			{// 10003 = 应收账款新增失败！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
						.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10003), RBcpErrorConstant.SCF_REC_BCP_10003);
			}
		}
		else
		{// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	/**
	 * 删除应收账款信息
	 * 
	 * @param id
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日下午4:01:05
	 */
	@Override
	@Transactional
	public int deleteRBcpDebtInfo(List<RBcpDebtInfoVO> list)
	{
		int i = 0;
		if(list != null && list.size() > 0)
		{
			for(RBcpDebtInfoVO debtInfoVO : list)
			{
				String id = debtInfoVO.getId();
				try
				{// 先删除应收账款单据明细信息
					nrbcpdebtbussdtlservice.deleteRBcpDebtBussDtl(id);
					i += rbcpdebtinfodao.deleteByPrimaryKey(id);
				}catch (Exception e)
				{// 10006 = 应收账款删除失败！
					throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(
							RBcpErrorConstant.SCF_REC_BCP_10006), RBcpErrorConstant.SCF_REC_BCP_10006);
				}
			}
		}
		else
		{// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		return i;
	}

	/**
	 * 应收账款基本信息修改（应收账款单据基本信息需要新增）
	 * 
	 * @param rBcpDebtInfoVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日下午4:01:47
	 */
	@Override
	@Transactional
	public int updateRBcpDebtInfo(RBcpDebtInfoVO rBcpDebtInfoVO)
	{
		if(rBcpDebtInfoVO != null && StringUtil.isStrNotEmpty(rBcpDebtInfoVO.getId()))
		{
			RBcpDebtInfo bcpDebtInfo = new RBcpDebtInfo();
			try
			{
				BeanUtils.copyProperties(rBcpDebtInfoVO, bcpDebtInfo);
			}catch (Exception e)
			{// // 10001 = 转换异常！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
						.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10001), RBcpErrorConstant.SCF_REC_BCP_10001);
			}
			try
			{
				rbcpdebtinfodao.updateByPrimaryKeySelective(bcpDebtInfo);
				return 1;
			}catch (Exception e)
			{
				log.error(e.getMessage());
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
						.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007), RBcpErrorConstant.SCF_REC_BCP_10007);
			}
		}
		else
		{// 10005 = 前台所传数据无效！
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	/**
	 * 条件分页查询应收账款信息（根据（买方客户名称）cnameBuyer，（卖方客户名称）cnameSeller，（业务合同编号）mastContno）
	 * （凭证编号）billsNo，status应收账款单据状态：01-已录入、02-已转让、03-已核销、04-已融资 debtBussStatus
	 * （业务品种）bussType，（凭证类型）billsType，（应收账款日期）billsDate，（应收账款到期日）debtEnd，
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtInfoVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日下午4:29:54
	 */
	@Override
	public Page findRBcpDebtInfoByPage(int pageNo, int pageSize, HashMap<String, Object> value)
			throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(value!=null)
		{
			omap.putAll(value);
		}
		//查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		value.putAll(map);
		
		int total = extnrecbcpdao.countRBcpDebtInfo(omap);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extnrecbcpdao.findRBcpDebtInfoByPage(omap, page));
		page.setTotalRecord(total);
		return page;
	}

	// @Override
	public RBcpDebtInfoVO findRBcpDebtInfoByKey(RBcpDebtInfoVO rBcpDebtInfoVO)
	{
		if(rBcpDebtInfoVO != null)
		{
			RBcpDebtInfoExample example = new RBcpDebtInfoExample();
			RBcpDebtInfoExample.Criteria cri = example.createCriteria();
			// ID
			if(rBcpDebtInfoVO.getId() != null && !"".equals(rBcpDebtInfoVO.getId()))
			{
				cri.andIdEqualTo(rBcpDebtInfoVO.getId());
			}
			// 卖方客户号 CustcdSaller
			if(rBcpDebtInfoVO.getCustcdSaller() != null && !"".equals(rBcpDebtInfoVO.getCustcdSaller()))
			{
				cri.andCustcdSallerEqualTo(rBcpDebtInfoVO.getCustcdSaller());
			}
			// 买方客户号 CustcdBuyer
			if(rBcpDebtInfoVO.getCustcdBuyer() != null && !"".equals(rBcpDebtInfoVO.getCustcdBuyer()))
			{
				cri.andCustcdBuyerEqualTo(rBcpDebtInfoVO.getCustcdBuyer());
			}
			// 凭证编号 billsNo
			if(rBcpDebtInfoVO.getBillsNo() != null && !"".equals(rBcpDebtInfoVO.getBillsNo()))
			{
				cri.andBillsNoEqualTo(rBcpDebtInfoVO.getBillsNo());
			}
			// 凭证类型 billsType
			if(rBcpDebtInfoVO.getBillsType() != null && !"".equals(rBcpDebtInfoVO.getBillsType()))
			{
				cri.andBillsTypeEqualTo(rBcpDebtInfoVO.getBillsType());
			}
			// 业务合同编号 MastContno
			if(rBcpDebtInfoVO.getMastContno() != null && !"".equals(rBcpDebtInfoVO.getMastContno()))
			{
				cri.andMastContnoEqualTo(rBcpDebtInfoVO.getMastContno());
			}

			try
			{
				List<RBcpDebtInfo> byExample = rbcpdebtinfodao.selectByExample(example);
				if(byExample != null && byExample.size() > 0)
				{
					RBcpDebtInfo debtInfoVO = byExample.get(0);
					try
					{
						BeanUtils.copyProperties(debtInfoVO, rBcpDebtInfoVO);
					}catch (Exception e)
					{// // 10001 = 转换异常！
						throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(
								RBcpErrorConstant.SCF_REC_BCP_10001), RBcpErrorConstant.SCF_REC_BCP_10001);
					}
					return rBcpDebtInfoVO;
				}
				else
				{
					return null;
				}
			}catch (Exception e)
			{// 10008 = 查询具体应收账款信息失败！
				throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
						.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10008), RBcpErrorConstant.SCF_REC_BCP_10008);
			}
		}
		else
		{// 10005 = 前台所传数据无效！
			return null;
		}
	}

	/**
	 * 未生效合同信息生效
	 * 
	 * @param bcntBcpInfoVO
	 * @author mengjiajia
	 * @date 2017年5月22日下午1:39:57
	 */
	@Override
	@Transactional
	public void setContStatus(RBcpDebtInfoVO rBcpDebtInfoVO)
	{
		RBcpDebtInfo bcpDebtInfo = new RBcpDebtInfo();
		bcpDebtInfo.setContStatus(rBcpDebtInfoVO.getContStatus());
		bcpDebtInfo.setId(rBcpDebtInfoVO.getId());
		rbcpdebtinfodao.updateByPrimaryKeySelective(bcpDebtInfo);
	}

	// 页面客户名称下拉菜单
	@Override
	public Page selectBCrmBaseInfoByPage(int pageNo, int pageSize, BCrmBaseInfo bCrmBaseInfo)
	{
		Page p = new Page(pageSize, pageNo, 0);
		BCrmBaseInfoExample example = new BCrmBaseInfoExample();
		if(bCrmBaseInfo != null && !"".equals(bCrmBaseInfo))
		{
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria criteria = example.createCriteria();
			// 开户日期(openDate)，核心开户日期(coreOpenDate)，管户员(mgrno)只有这三个没有查询
			// 这里只有涉及名称和经办机构是用的模糊查询，但凡查询的日期都没有用between查询。如果有其他需要在更改。
			// 根据客户号查询custcd
			if(bCrmBaseInfo.getCustcd() != null && !"".equals(bCrmBaseInfo.getCustcd()))
			{
				criteria.andCustcdEqualTo(bCrmBaseInfo.getCustcd());
			}
			// 根据核心客户号查询custno
			if(bCrmBaseInfo.getCustno() != null && !"".equals(bCrmBaseInfo.getCustno()))
			{
				criteria.andCustnoEqualTo(bCrmBaseInfo.getCustno());
			}
			// 根据客户名称查询cname
			if(bCrmBaseInfo.getCname() != null && !"".equals(bCrmBaseInfo.getCname()))
			{
				criteria.andCnameLike("%" + bCrmBaseInfo.getCname() + "%");
			}
			// 根据客户类型查询custType
			if(bCrmBaseInfo.getCustType() != null && !"".equals(bCrmBaseInfo.getCustType()))
			{
				criteria.andCustTypeEqualTo(bCrmBaseInfo.getCustType());
			}
			// 证件类型 idtype
			if(bCrmBaseInfo.getIdtype() != null && !"".equals(bCrmBaseInfo.getIdtype()))
			{
				criteria.andIdtypeEqualTo(bCrmBaseInfo.getIdtype());
			}
			// 根据证件号码查询idno
			if(bCrmBaseInfo.getIdno() != null && !"".equals(bCrmBaseInfo.getIdno()))
			{
				criteria.andIdnoEqualTo(bCrmBaseInfo.getIdno());
			}
			// 客户英文名ename
			if(bCrmBaseInfo.getEname() != null && !"".equals(bCrmBaseInfo.getEname()))
			{
				criteria.andEnameLike("%" + bCrmBaseInfo.getEname() + "%");
			}
			// 客户别名aliasName
			if(bCrmBaseInfo.getAliasName() != null && !"".equals(bCrmBaseInfo.getAliasName()))
			{
				criteria.andAliasNameLike("%" + bCrmBaseInfo.getAliasName() + "%");
			}
			// 组织机构代码orgCode
			if(bCrmBaseInfo.getOrgCode() != null && !"".equals(bCrmBaseInfo.getOrgCode()))
			{
				criteria.andOrgCodeEqualTo(bCrmBaseInfo.getOrgCode());
			}
			// 社会信用代码socCreditNo
			if(bCrmBaseInfo.getSocCreditNo() != null && !"".equals(bCrmBaseInfo.getSocCreditNo()))
			{
				criteria.andSocCreditNoEqualTo(bCrmBaseInfo.getSocCreditNo());
			}
			// 营业执照注册号licenseNo
			if(bCrmBaseInfo.getLicenseNo() != null && !"".equals(bCrmBaseInfo.getLicenseNo()))
			{
				criteria.andLicenseNoEqualTo(bCrmBaseInfo.getLicenseNo());
			}
			// 营业执照到期日licenseDate
			if(bCrmBaseInfo.getLicenseDate() != null && !"".equals(bCrmBaseInfo.getLicenseDate()))
			{
				criteria.andLicenseDateEqualTo(bCrmBaseInfo.getLicenseDate());
			}
			// 客户状态custStatus
			if(bCrmBaseInfo.getCustStatus() != null && !"".equals(bCrmBaseInfo.getCustStatus()))
			{
				criteria.andCustStatusEqualTo(bCrmBaseInfo.getCustStatus());
			}
			// 是否核心厂商coreFlag
			if(bCrmBaseInfo.getCoreFlag() != null && !"".equals(bCrmBaseInfo.getCoreFlag()))
			{
				criteria.andCoreFlagEqualTo(bCrmBaseInfo.getCoreFlag());
			}
			// 根据是否是监管客户查询moniFlag
			if(bCrmBaseInfo.getMoniFlag() != null && !"".equals(bCrmBaseInfo.getMoniFlag()))
			{
				criteria.andMoniFlagEqualTo(bCrmBaseInfo.getMoniFlag());
			}
			// 是否期货经纪公司futuresFlag
			if(bCrmBaseInfo.getFuturesFlag() != null && !"".equals(bCrmBaseInfo.getFuturesFlag()))
			{
				criteria.andFuturesFlagEqualTo(bCrmBaseInfo.getFuturesFlag());
			}
			// 是否金融租赁公司flcFlag
			if(bCrmBaseInfo.getFlcFlag() != null && !"".equals(bCrmBaseInfo.getFlcFlag()))
			{
				criteria.andFlcFlagEqualTo(bCrmBaseInfo.getFlcFlag());
			}
			// 建档日期 createDate
			if(bCrmBaseInfo.getCreateDate() != null && !"".equals(bCrmBaseInfo.getCreateDate()))
			{
				criteria.andCreateDateEqualTo(bCrmBaseInfo.getCreateDate());
			}
			// 授信客户标识creditFlag
			if(bCrmBaseInfo.getCreditFlag() != null && !"".equals(bCrmBaseInfo.getCreditFlag()))
			{
				criteria.andCreditFlagEqualTo(bCrmBaseInfo.getCreditFlag());
			}
			// 黑名单标识blackFlag
			if(bCrmBaseInfo.getBlackFlag() != null && !"".equals(bCrmBaseInfo.getBlackFlag()))
			{
				criteria.andBlackFlagEqualTo(bCrmBaseInfo.getBlackFlag());
			}
			// 是否保险公司insureFlag
			if(bCrmBaseInfo.getInsureFlag() != null && !"".equals(bCrmBaseInfo.getInsureFlag()))
			{
				criteria.andInsureFlagEqualTo(bCrmBaseInfo.getInsureFlag());
			}
			// 根据是否是保理商查询factorFlag
			if(bCrmBaseInfo.getFactorFlag() != null && !"".equals(bCrmBaseInfo.getFactorFlag()))
			{
				criteria.andFactorFlagEqualTo(bCrmBaseInfo.getFactorFlag());
			}
			// 信贷客户号ccmsCustcd
			if(bCrmBaseInfo.getCcmsCustcd() != null && !"".equals(bCrmBaseInfo.getCcmsCustcd()))
			{
				criteria.andCcmsCustcdEqualTo(bCrmBaseInfo.getCcmsCustcd());
			}
			// 是否贸融重点客户importantFlag
			if(bCrmBaseInfo.getImportantFlag() != null && !"".equals(bCrmBaseInfo.getImportantFlag()))
			{
				criteria.andImportantFlagEqualTo(bCrmBaseInfo.getImportantFlag());
			}
			// 是否贸易对手commercialFalg
			if(bCrmBaseInfo.getCommercialFalg() != null && !"".equals(bCrmBaseInfo.getCommercialFalg()))
			{
				criteria.andCommercialFalgEqualTo(bCrmBaseInfo.getCommercialFalg());
			}
			// 是否境外overseasFlag
			if(bCrmBaseInfo.getOverseasFlag() != null && !"".equals(bCrmBaseInfo.getOverseasFlag()))
			{
				criteria.andOverseasFlagEqualTo(bCrmBaseInfo.getOverseasFlag());
			}
			// 是否是本行客户banksCustFlag
			if(bCrmBaseInfo.getBanksCustFlag() != null && !"".equals(bCrmBaseInfo.getBanksCustFlag()))
			{
				criteria.andBanksCustFlagEqualTo(bCrmBaseInfo.getBanksCustFlag());
			}
			// 是否是EF进口商efBuyerFlag
			if(bCrmBaseInfo.getEfBuyerFlag() != null && !"".equals(bCrmBaseInfo.getEfBuyerFlag()))
			{
				criteria.andEfBuyerFlagEqualTo(bCrmBaseInfo.getEfBuyerFlag());
			}
			// 是否是IF出口商ifSellerFlag
			if(bCrmBaseInfo.getIfSellerFlag() != null && !"".equals(bCrmBaseInfo.getIfSellerFlag()))
			{
				criteria.andIfSellerFlagEqualTo(bCrmBaseInfo.getIfSellerFlag());
			}
			// 是否是银行 isBank
			if(bCrmBaseInfo.getIsBank() != null && !"".equals(bCrmBaseInfo.getIsBank()))
			{
				criteria.andIsBankEqualTo(bCrmBaseInfo.getIsBank());
			}
			// FCI代号 fciCode
			if(bCrmBaseInfo.getFciCode() != null && !"".equals(bCrmBaseInfo.getFciCode()))
			{
				criteria.andFciCodeEqualTo(bCrmBaseInfo.getFciCode());
			}
			// 是否国际保理客户isIntl
			if(bCrmBaseInfo.getIsIntl() != null && !"".equals(bCrmBaseInfo.getIsIntl()))
			{
				criteria.andIsIntlEqualTo(bCrmBaseInfo.getIsIntl());
			}
			// 经办机构brcode
			if(bCrmBaseInfo.getBrcode() != null && !"".equals(bCrmBaseInfo.getBrcode()))
			{
				criteria.andBrcodeLike("%" + bCrmBaseInfo.getBrcode() + "%");
			}
			// 创建人tlrcd
			if(bCrmBaseInfo.getTlrcd() != null && !"".equals(bCrmBaseInfo.getTlrcd()))
			{
				criteria.andTlrcdEqualTo(bCrmBaseInfo.getTlrcd());
			}
			// 创建时间 crtTime
			if(bCrmBaseInfo.getCrtTime() != null && !"".equals(bCrmBaseInfo.getCrtTime()))
			{
				criteria.andCrtTimeEqualTo(bCrmBaseInfo.getCrtTime());
			}
			// 最后更新操作员 lastUpdTlrcd
			if(bCrmBaseInfo.getLastUpdTlrcd() != null && !"".equals(bCrmBaseInfo.getLastUpdTlrcd()))
			{
				criteria.andLastUpdTlrcdEqualTo(bCrmBaseInfo.getLastUpdTlrcd());
			}
			// 最后更新时间 lastUpdTime
			if(bCrmBaseInfo.getLastUpdTime() != null && !"".equals(bCrmBaseInfo.getLastUpdTime()))
			{
				criteria.andLastUpdTimeEqualTo(bCrmBaseInfo.getLastUpdTime());
			}
			// 管户员(mgrno)
			if(bCrmBaseInfo.getMgrno() != null && !"".equals(bCrmBaseInfo.getMgrno()))
			{
				criteria.andMgrnoEqualTo(bCrmBaseInfo.getMgrno());
			}
		}
		try
		{
			p.setRecords(iBCrmBaseInfoDAO.selectByPage(example, p));
			return p;
		}catch (Exception e)
		{
			log.error("（下拉框）条件分页查询客户信息失败！");
			throw new ScubeBizException("（下拉框）条件分页查询客户信息失败！", e);
		}
	}

	/**
	 * 根据主键获取信息
	 * 
	 * @param id
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午9:23:14
	 */
	@Override
	public RBcpDebtInfoVO queryRBcpDebtInfoById(String id) throws ScubeBizException
	{
		if(StringUtils.isEmpty(id))
		{
			return null;
		}
		RBcpDebtInfo rBcpDebtInfo = rbcpdebtinfodao.selectByPrimaryKey(id);
		if(rBcpDebtInfo != null)
		{
			RBcpDebtInfoVO rBcpDebtInfoVO = new RBcpDebtInfoVO();
			BeanUtils.copyProperties(rBcpDebtInfo, rBcpDebtInfoVO);
			return rBcpDebtInfoVO;
		}
		else
		{
			return null;
		}

	}

	// 应收账款转让新增单据页面条件查询
	@Override
	public Page findRBcpDebtBaseInfoPageForTransfer(int pageNo, int pageSize, RBcpDebtInfoVO rBcpDebtBaseInfo,
			List<RBcpDebtInfoVO> insertDebtList) throws ScubeBizException
	{
		if(rBcpDebtBaseInfo == null)
		{
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		if(insertDebtList != null && insertDebtList.size() > 0)
		{
			for(RBcpDebtInfoVO rBcpDebtBaseInfo1 : insertDebtList)
			{
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(null != rBcpDebtBaseInfo)
		{
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
		extnrecbcpdao.getDebtInvoiceInfoNTransfer(map, page);
		return page;
	}

	/**
	 * 解除锁定
	 * 
	 * @param debtId
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:01:43
	 */
	@Override
	@Transactional
	public void releaseDebtBaseInfo(String debtId) throws ScubeBizException
	{
		RBcpDebtInfo debtBaseInfo = new RBcpDebtInfo();
		debtBaseInfo = rbcpdebtinfodao.selectByPrimaryKey(debtId);
		if(debtBaseInfo != null)
		{
			debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// 解锁
			debtBaseInfo.setLockAppno("");
			rbcpdebtinfodao.updateByPrimaryKeySelective(debtBaseInfo);
		}
	}

	/**
	 * 锁定
	 * 
	 * @param debtId
	 * @param appno
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日上午10:12:42
	 */
	@Override
	@Transactional
	public void lockDebtBaseInfo(String debtId, String appno) throws ScubeBizException
	{
		RBcpDebtInfo debtInfo = new RBcpDebtInfo();
		debtInfo = rbcpdebtinfodao.selectByPrimaryKey(debtId);
		if(debtInfo != null)
		{
			debtInfo.setIsLocked(ScfBasConstant.LOCKED); // 锁定
			debtInfo.setLockAppno(appno);
			rbcpdebtinfodao.updateByPrimaryKeySelective(debtInfo);
		}
	}

	/**
	 * 获取选择的应收账款列表
	 * 
	 * @param commonQueryVO
	 * @param orderFileds
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月24日下午2:13:31
	 */
	@Override
	public Page getInvoiceSelectedQuery(DebtCommonQryVO commonQueryVO, List<String> orderFileds)
	{
		log.info("查询选中的应收账款列表  method:getInvoiceSelectedQuery begin");
		RBcpDebtInfoExample example = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria cri = example.createCriteria();
		String id_Q = commonQueryVO.getId_Q();
		int pageNo = commonQueryVO.getPageIndex();
		int pageSize = commonQueryVO.getPageSize();
		if(StringUtil.isEmpty(id_Q))
		{
			cri.andIdEqualTo("1");
		}
		else
		{
			if(id_Q.indexOf("/f") == -1)
			{
				cri.andIdEqualTo(id_Q);
			}
			else
			{
				List<String> ids = new ArrayList<String>();
				String[] id = id_Q.split("/f");
				for(int i = 0; i < id.length; i++)
				{
					if(!StringUtil.isEmpty(id[i]))
					{
						ids.add(id[i]);
					}
				}
				if(ids.size() > 0)
				{
					cri.andIdIn(ids);
				}
			}
		}
		if(orderFileds != null && orderFileds.size() > 0)
		{
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < orderFileds.size(); i++)
			{
				sb.append(orderFileds.get(i)).append(",");
			}
			String order = sb.toString().substring(0, sb.toString().lastIndexOf(","));
			example.setOrderByClause(order);
		}
		else
		{
			example.setOrderByClause("debtEnd");
		}
		int total = rbcpdebtinfodao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(rbcpdebtinfodao.selectByPage(example, page));
		page.setTotalRecord(total);
		log.info("查询选中的应收账款列表 method:getInvoiceSelectedQuery end");
		return page;
	}

	/**
	 * 发票融资申请发票添加
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月24日下午4:25:29
	 */
	@Override
	public Page getInvoiceFinancingAddQry(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		log.info("发票融资发票添加 method:getInvoiceAllowanceAddQry begin");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("status", DebtConstants.INVOICE_STATUS_PURCHASED);
		omap.put("issueFlag", DebtConstants.ISSUE_FLAG_FALSE);
		omap.put("overdueFlag", DebtConstants.OVERDUE_FLAG_NORMAL);
		omap.put("badFlag", DebtConstants.BAD_FLAG_FALSE);
		// 发票未被锁定或是被本流程锁定
		omap.put("isLocked", ScfBasConstant.LOCKED);// 不等于
		if(!StringUtil.isEmpty(debtCommonQryVO.getAppno()))
		{
			omap.put("lockAppno", debtCommonQryVO.getAppno());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdBuyer_Q()))
		{
			omap.put("custcdBuyer", debtCommonQryVO.getCustcdBuyer_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdSaller_Q()))
		{
			omap.put("custcdSaller", debtCommonQryVO.getCustcdSaller_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getMastContno()))
		{
			omap.put("mastContno", debtCommonQryVO.getMastContno());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_from_Q()))
		{ // 发票登记日期
			omap.put("insertDate1", debtCommonQryVO.getInsertDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_to_Q()))
		{ // 发票登记日期
			omap.put("insertDate2", debtCommonQryVO.getInsertDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getPurchaseDate_from_Q()))
		{ // 承购日期起
			omap.put("purchaseDate1", debtCommonQryVO.getPurchaseDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getPurchaseDate_to_Q()))
		{ // 承购日期止
			omap.put("purchaseDate2", debtCommonQryVO.getPurchaseDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_from_Q()))
		{ // 发票日期起
			omap.put("billsDate1", debtCommonQryVO.getBillsDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_to_Q()))
		{ // 发票日期止
			omap.put("billsDate2", debtCommonQryVO.getBillsDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getDebtEnd_from_Q()))
		{ // 到期日 起
			omap.put("debtEnd1", debtCommonQryVO.getDebtEnd_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getDebtEnd_to_Q()))
		{ // 到期日 止
			omap.put("debtEnd2", debtCommonQryVO.getDebtEnd_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_from_Q()))
		{ // 发票金额
			omap.put("billsAmount1", debtCommonQryVO.getBillsAmount_from_Q());// 起
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_to_Q()))
		{ // 发票金额
			omap.put("billsAmount2", debtCommonQryVO.getBillsAmount_to_Q());// 止
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBussTypeList_Q()))
		{
			omap.put("ids", debtCommonQryVO.getBussTypeList_Q());
		}
		int total = extnrecbcpdao.countInvoiceFinancingAddQry(omap);
		Page page = new Page(debtCommonQryVO.getPageSize(), debtCommonQryVO.getPageIndex(), total);
		page.setRecords(extnrecbcpdao.getInvoiceFinancingAddQry(omap, page));
		page.setTotalRecord(total);
		log.info("发票融资发票添加method:getInvoiceAllowanceAddQry end");
		return page;
	}

	/**
	 * 应收账款单据信息查询
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月25日下午8:22:41
	 */
	@Override
	public Page getDebtInfoQuery(DebtCommonQryVO debtCommonQryVO, boolean flag) throws ScubeBizException
	{
		log.info("应收账款单据信息查询 method:getDebtInfoQuery begin");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("status1", DebtConstants.INVOICE_STATUS_NEW);// 不等于,租金单新建状态不显示
		omap.put("poolFlag", DebtConstants.POOL_FLAG_IN_POOL);//入池
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdBuyer_Q()))
		{
			omap.put("custcdBuyer", debtCommonQryVO.getCustcdBuyer_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdSaller_Q()))
		{
			omap.put("custcdSaller", debtCommonQryVO.getCustcdSaller_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getMastContno()))
		{
			omap.put("mastContno", debtCommonQryVO.getMastContno());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_from_Q()))
		{ // 发票登记日期
			omap.put("insertDate1", debtCommonQryVO.getInsertDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_to_Q()))
		{ // 发票登记日期
			omap.put("insertDate2", debtCommonQryVO.getInsertDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_from_Q()))
		{ // 发票日期起
			omap.put("billsDate1", debtCommonQryVO.getBillsDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_to_Q()))
		{ // 发票日期止
			omap.put("billsDate2", debtCommonQryVO.getBillsDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getDebtEnd_from_Q()))
		{ // 到期日 起
			omap.put("debtEnd1", debtCommonQryVO.getDebtEnd_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getDebtEnd_to_Q()))
		{ // 到期日 止
			omap.put("debtEnd2", debtCommonQryVO.getDebtEnd_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_from_Q()))
		{ // 发票金额
			// 起
			omap.put("billsAmount1", debtCommonQryVO.getBillsAmount_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_to_Q()))
		{ // 发票金额
			// 止
			omap.put("billsAmount2", debtCommonQryVO.getBillsAmount_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getFlawFlag_Q()))
		{
			omap.put("flawFlag", debtCommonQryVO.getFlawFlag_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getOverdueFlag_Q()))
		{
			omap.put("overdueFlag", debtCommonQryVO.getOverdueFlag_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBadFlag_Q()))
		{
			omap.put("badFlag", debtCommonQryVO.getBadFlag_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getStatus_Q()))
		{ // 发票状态
			omap.put("status2", debtCommonQryVO.getStatus_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsNo_Q()))
		{ // 发票号码
			omap.put("billsNo", debtCommonQryVO.getBillsNo_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsType_Q()))
		{ // 应收账款类型
			omap.put("billsType", debtCommonQryVO.getBillsType_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBussType_Q()))
		{ // 业务品种
			omap.put("bussType", debtCommonQryVO.getBussType_Q());
		}
		List<String> factTypes = new ArrayList<String>();
		if(ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(debtCommonQryVO.getFinancingType_Q()))
		{
			factTypes.add(ScfBasConstant.FACT_TYPE_INLAND);// 国内保理
			factTypes.add(ScfBasConstant.FACT_TYPE_REVERSE);// 反向保理
			factTypes.add(ScfBasConstant.FACT_TYPE_DEBT_PLEDGE);// 应收账款质押
		}
		else if(ScfBasConstant.T_FINANCING_TYPE_POOL.equals(debtCommonQryVO.getFinancingType_Q()))
		{
			factTypes.add(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
			factTypes.add(ScfBasConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
			factTypes.add(ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
		}
		else if(ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(debtCommonQryVO.getFinancingType_Q()))
		{
			factTypes.add(ScfBasConstant.FACT_TYPE_CREDIT_FACT);// 信保保理
		}
		else if(ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(debtCommonQryVO.getFinancingType_Q()))
		{
			factTypes.add(ScfBasConstant.FACT_TYPE_DOUBLE_FACT);// 行内双保理
		}
		else if(ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(debtCommonQryVO.getFinancingType_Q()))
		{
			factTypes.add(ScfBasConstant.FACT_TYPE_LEASE_FACT);// 租赁保理
		}
		else
		{
			factTypes.add(ScfBasConstant.FACT_TYPE_INLAND);// 国内保理
			factTypes.add(ScfBasConstant.FACT_TYPE_REVERSE);// 反向保理
			factTypes.add(ScfBasConstant.FACT_TYPE_DEBT_PLEDGE);// 应收账款质押
		}
		if(factTypes.size() > 0)
		{
			omap.put("factTypes", factTypes);
		}

		if(!StringUtil.isEmpty(debtCommonQryVO.getFinancingType_Q()))
		{ // 融资方式
			omap.put("financingType", debtCommonQryVO.getFinancingType_Q());
		}
		List<RBcpDebtInfo> list =  this.getDuebillAppFlowRBcpDebtInfo();
		List<String> debtIds = new ArrayList<String>();
		if(list!=null&&list.size()>0)
		{
			for(RBcpDebtInfo debtInfo:list)
			{
				debtIds.add(debtInfo.getId());
			}
		}
		if(debtIds!=null&&debtIds.size()>0)
		{
			omap.put("ids", debtIds);
		}
		// 查询权限
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		omap.putAll(map);
		int total = extnrecbcpdao.countDebtInfoQuery(omap);
		Page page = new Page(debtCommonQryVO.getPageSize(), debtCommonQryVO.getPageIndex(), total);
		page.setRecords(extnrecbcpdao.getDebtInfoQuery(omap, page, flag));
		page.setTotalRecord(total);
		log.info("应收账款单据信息查询 method:getDebtInfoQuery end");
		return page;
	}

	/**
	 * 催收待添加发票信息查询
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月27日下午3:11:18
	 */
	@Override
	public Page getDebtInvoiceInfoPressing(DebtCommonQryVO debtCommonQryVO)
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> statusList = new ArrayList<String>();
		statusList.add(DebtConstants.INVOICE_STATUS_PURCHASED);
		statusList.add(DebtConstants.INVOICE_STATUS_FINANCED);
		omap.put("statusList", statusList);// 发票状态已承购
		omap.put("issueFlag", DebtConstants.ISSUE_FLAG_FALSE);
		// 发票未被锁定或是被本流程锁定
		omap.put("isLocked", ScfBasConstant.LOCKED);// 不等于
		if(!StringUtil.isEmpty(debtCommonQryVO.getAppno_Q()))
		{
			omap.put("lockAppno", debtCommonQryVO.getAppno_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getFlag()))
		{
			String pressMode = debtCommonQryVO.getFlag().trim();
			if(pressMode.equals(DebtConstants.DEBT_PRESS_MODE_PROMPT_PAYMENT))
			{// 提示付款
				omap.put("1debtEnd", ScfDateUtil.getStringDate(new Date()));// 大于等于
			}
			else if(pressMode.equals(DebtConstants.DEBT_PRESS_MODE_COLLECTION))
			{// 催收
				omap.put("2debtEnd", ScfDateUtil.getStringDate(new Date()));// 小于
			}
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdBuyer_Q()))
		{
			omap.put("custcdBuyer", debtCommonQryVO.getCustcdBuyer_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdSaller_Q()))
		{
			omap.put("custcdSaller", debtCommonQryVO.getCustcdSaller_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getMastContno()))
		{
			omap.put("mastContno", debtCommonQryVO.getMastContno());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_from_Q()))
		{ // 发票登记日期
			omap.put("insertDate1", debtCommonQryVO.getInsertDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_to_Q()))
		{ // 发票登记日期
			omap.put("insertDate2", debtCommonQryVO.getInsertDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_from_Q()))
		{ // 发票日期起
			omap.put("billsDate1", debtCommonQryVO.getBillsDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_to_Q()))
		{ // 发票日期止
			omap.put("billsDate2", debtCommonQryVO.getBillsDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getEndDate_from_Q()))
		{ // 到期日 起
			omap.put("debtEnd1", debtCommonQryVO.getEndDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getEndDate_to_Q()))
		{ // 到期日 止
			omap.put("debtEnd2", debtCommonQryVO.getEndDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsNo_Q()))
		{ // 发票号码
			omap.put("billsNo", debtCommonQryVO.getBillsNo_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_from_Q()))
		{ // 发票金额
			// 起
			omap.put("billsAmount1", debtCommonQryVO.getBillsAmount_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_to_Q()))
		{ // 发票金额
			// 止
			omap.put("billsAmount2", debtCommonQryVO.getBillsAmount_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBussTypeList_Q()))
		{
			omap.put("ids", debtCommonQryVO.getBussTypeList_Q());
		}
		int total = extnrecbcpdao.countDebtInvoiceInfoPressing(omap);
		Page page = new Page(debtCommonQryVO.getPageSize(), debtCommonQryVO.getPageIndex(), total);
		page.setRecords(extnrecbcpdao.getDebtInvoiceInfoPressing(omap, page));
		page.setTotalRecord(total);
		return page;
	}

	// 商纠登记
	@Override
	public Page findRBcpDebtInfoForPRegister(int pageNo, int pageSize, RBcpDebtInfoVO rBcpDebtInfoVO,
			List<RBcpDebtInfoVO> list) throws ScubeBizException
	{
		if(rBcpDebtInfoVO == null)
		{
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		if(list != null && list.size() > 0)
		{
			for(RBcpDebtInfoVO rBcpDebtBaseInfo1 : list)
			{
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(null != rBcpDebtInfoVO)
		{
			String lockAppno = rBcpDebtInfoVO.getLockAppno();
			String mastContno = rBcpDebtInfoVO.getMastContno();
			String custcdBuyer = rBcpDebtInfoVO.getCustcdBuyer();
			String custcdSaller = rBcpDebtInfoVO.getCustcdSaller();

			String billsDateFrom = rBcpDebtInfoVO.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtInfoVO.getBillsDateTo();
			String debtEndFrom = rBcpDebtInfoVO.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtInfoVO.getDebtEndTo();

			String billsNo = rBcpDebtInfoVO.getBillsNo(); // 凭证编号
			String factType = rBcpDebtInfoVO.getFactType();
			String flawFlag = rBcpDebtInfoVO.getFlawFlag();
			String billsType = rBcpDebtInfoVO.getBillsType(); // 凭证类型
			String poolFlag = rBcpDebtInfoVO.getPoolFlag(); // 入池标识
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
		extnrecbcpdao.getDebtInvoiceInfoRegister(map, page);
		return page;
	}

	/**
	 * 催收发票列表
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月31日上午10:53:15
	 */
	@Override
	public Page getDebtPressInvoicesInfo(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		log.info("查询催收发票列表 ");
		RBcpDebtInfoExample example = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria cri = example.createCriteria();
		if(!StringUtil.isEmpty(debtCommonQryVO.getId_Q()))
		{
			if(debtCommonQryVO.getId_Q().indexOf("/f") == -1)
			{
				cri.andIdEqualTo(debtCommonQryVO.getId_Q());
			}
			else
			{
				List<String> idList = new ArrayList<String>();
				String[] id = debtCommonQryVO.getId_Q().split("/f");
				for(int i = 0; i < id.length; i++)
				{
					if(!StringUtil.isEmpty(id[i]))
					{
						idList.add("'" + id[i] + "'");
					}
				}
			}
		}
		else
		{
			cri.andIdEqualTo("0");
		}
		example.setOrderByClause("BILLS_NO");

		int total = rbcpdebtinfodao.countByExample(example);
		Page page = new Page(debtCommonQryVO.getPageSize(), debtCommonQryVO.getPageIndex(), total);
		List<RBcpDebtInfo> list = rbcpdebtinfodao.selectByPage(example, page);
		int count1 = 0;// 提示
		int count2 = 0;// 催收
		List<NDebtBillsInfoVO> li = new ArrayList<NDebtBillsInfoVO>();
		for(int i = 0; i < list.size(); i++)
		{
			NDebtBillsInfoVO debtVO = new NDebtBillsInfoVO();
			BeanUtils.copyProperties(list.get(i), debtVO);
			RBcpDebtBussDtlExample exampledtl1 = new RBcpDebtBussDtlExample();
			RBcpDebtBussDtlExample.Criteria cridtl = exampledtl1.createCriteria();
			cridtl.andDebtIdEqualTo(debtVO.getId());
			cridtl.andApplyTypeEqualTo(DebtConstants.APPLY_TYPE_COLLECTION);
			cridtl.andInsertDateLessThanOrEqualTo(debtVO.getDebtEnd());
			count1 = rbcpdebtbussdtldao.countByExample(exampledtl1);
			RBcpDebtBussDtlExample exampledtl2 = new RBcpDebtBussDtlExample();
			cridtl = exampledtl2.createCriteria();
			cridtl.andDebtIdEqualTo(debtVO.getId());
			cridtl.andApplyTypeEqualTo(DebtConstants.APPLY_TYPE_COLLECTION);
			cridtl.andInsertDateGreaterThan(debtVO.getDebtEnd());
			count2 = rbcpdebtbussdtldao.countByExample(exampledtl2);
			debtVO.setWarnCount(new BigDecimal(count1));
			debtVO.setPressCount(new BigDecimal(count2));
			li.add(debtVO);
		}
		page.setRecords(li);
		page.setTotalRecord(total);
		return page;

	}

	/**
	 * 回购申请审批通过
	 * 
	 * @param insertDebtList
	 * @param tblDebtBussInfo
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午10:43:41
	 */
	@Transactional
	@Override
	public List<NDebtBillsInfoVO> factoringDebtBackAddApply(List<NDebtBillsInfoVO> insertDebtList,
			RBcpDebtBussInfo tblDebtBussInfo) throws ScubeBizException
	{
		List<NDebtBillsInfoVO> list2 = new ArrayList<NDebtBillsInfoVO>();
		NDebtBillsInfoVO baseDebtVo = null;
		if(insertDebtList.size() > 0)
		{
			for(NDebtBillsInfoVO baseinfo : insertDebtList)
			{
				baseDebtVo = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(baseinfo, baseDebtVo);
				BigDecimal buyBackAmounts = baseDebtVo.getBuyBackAmount() == null ? new BigDecimal("0")
						: baseDebtVo.getBuyBackAmount();// 本次回购金额
				RBcpDebtInfoVO bcpDebtInfoVO = this.updateDebtStateByRemainingAmount(baseDebtVo, buyBackAmounts, null,
						null);
				if(DebtConstants.INVOICE_STATUS_VERIFIED.equals(bcpDebtInfoVO.getStatus()))
				{// 若发票已核销，则添加到list2中
					baseDebtVo.setRemoveAmount(buyBackAmounts);
					list2.add(baseDebtVo);
				}
				RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
				BeanUtils.copyProperties(bcpDebtInfoVO, tblDebtBussDetail);
				tblDebtBussDetail.setId(UUIDGeneratorUtil.generate());
				tblDebtBussDetail.setDebtId(bcpDebtInfoVO.getId());
				tblDebtBussDetail.setApplyType(tblDebtBussInfo.getApplyType());
				tblDebtBussDetail.setAppno(tblDebtBussInfo.getAppno());
				tblDebtBussDetail.setBussType(bcpDebtInfoVO.getBussType());
				tblDebtBussDetail.setBuyBackAmount(buyBackAmounts);// 回购金额
				tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
				tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
				tblDebtBussDetail.setMoney(baseDebtVo.getBuyBackAmount());
				nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(tblDebtBussDetail);

				BigDecimal buyBackAmount = bcpDebtInfoVO.getBuyBackAmount() == null ? new BigDecimal("0")
						: bcpDebtInfoVO.getBuyBackAmount();// 回购金额
				bcpDebtInfoVO.setBuyBackAmount(buyBackAmount.add(buyBackAmounts));// 回购金额累加
				BigDecimal remainingUseableAmount = bcpDebtInfoVO.getRemainingUseableAmount() == null
						? new BigDecimal("0") : bcpDebtInfoVO.getRemainingUseableAmount();
				BigDecimal loanPercent = bcpDebtInfoVO.getLoanPercent() == null ? new BigDecimal("0")
						: bcpDebtInfoVO.getLoanPercent();
				bcpDebtInfoVO.setRemainingUseableAmount(remainingUseableAmount.subtract(buyBackAmounts
						.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));// 发票可融资余额
				BigDecimal remainingAmount = bcpDebtInfoVO.getRemainingAmount() == null ? new BigDecimal("0")
						: bcpDebtInfoVO.getRemainingAmount();// 发票余额
				BigDecimal amount = remainingAmount.subtract(buyBackAmounts);// 得到回购后发票余额
				bcpDebtInfoVO.setRemainingAmount(amount);
				BigDecimal loanRemainingAmount = bcpDebtInfoVO.getLoanRemainingAmount() == null ? new BigDecimal("0")
						: bcpDebtInfoVO.getLoanRemainingAmount();
				BigDecimal loanAmount = loanRemainingAmount.compareTo(buyBackAmounts) >= 0 ? buyBackAmounts
						: loanRemainingAmount;
				bcpDebtInfoVO.setLoanRemainingAmount(loanRemainingAmount.subtract(loanAmount));// 融资余额
				// 调用公共方法判断
				/*
				 * if((baseDebtVo.getRebatebalance()==null?new
				 * BigDecimal("0"):baseDebtVo.getRebatebalance()).compareTo(num)
				 * ==0){
				 * bcpDebtInfoVO.setStatus(DebtConstants.INVOICE_STATUS_03); }
				 */
				this.updateRBcpDebtInfo(bcpDebtInfoVO);
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
	public RBcpDebtInfoVO updateDebtStateByRemainingAmount(NDebtBillsInfoVO debtVO, BigDecimal removeAmount,
			BigDecimal rateAmount, BigDecimal loanAmount) throws ScubeBizException
	{
		RBcpDebtInfo bcpDebtInfo = rbcpdebtinfodao.selectByPrimaryKey(debtVO.getId());
		if(bcpDebtInfo == null)
		{
			throw new ScubeBizException("发票列表获取失败！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		else
		{
			BigDecimal remainingAmount = bcpDebtInfo.getRemainingAmount() == null ? new BigDecimal("0")
					: bcpDebtInfo.getRemainingAmount();// 发票余额
			BigDecimal loanRemainingAmount = bcpDebtInfo.getLoanRemainingAmount() == null ? new BigDecimal("0")
					: new BigDecimal(0);// 融资余额
			BigDecimal ownRateCollectAmount = bcpDebtInfo.getOwnRateCollectAmount() == null ? new BigDecimal("0")
					: bcpDebtInfo.getOwnRateCollectAmount();// 欠息总额
			rateAmount = rateAmount == null ? new BigDecimal("0") : rateAmount;// 还息金额
			loanAmount = loanAmount == null ? new BigDecimal("0") : loanAmount;// 还本金额
			removeAmount = removeAmount == null ? new BigDecimal("0") : removeAmount;// 冲销金额
			if(removeAmount.compareTo(remainingAmount) == 1)
			{// 若冲销金额大于发票余额
				throw new ScubeBizException("发票冲销金额溢出错误，请重新核对或发起新的申请！", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			else if(loanRemainingAmount.compareTo(loanAmount) == -1)
			{// 若还本金额大于融资余额
				throw new ScubeBizException("发票还本金额溢出错误，请重新核对或发起新的申请！", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			else if(ownRateCollectAmount.compareTo(rateAmount) == -1)
			{// 若还息金额大于欠息金额
				throw new ScubeBizException("发票还息金额溢出错误，请重新核对或发起新的申请！", RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
			}
			else if(removeAmount.compareTo(remainingAmount) == 0 && loanAmount.compareTo(loanRemainingAmount) == 0
					&& rateAmount.compareTo(ownRateCollectAmount) == 0)
			{
				// 若欠本，欠息和发票余额都能抵消为0
				bcpDebtInfo.setReturnStatus(DebtConstants.RETURN_STATUS_ALL_PAYMENT);// 全部还清
				bcpDebtInfo.setStatus(DebtConstants.INVOICE_STATUS_VERIFIED);// 已核销
			}
			else
			{// 部分还款
				bcpDebtInfo.setReturnStatus(DebtConstants.RETURN_STATUS_PART_PAYMENT);// 还款状态
				bcpDebtInfo.setStatus(DebtConstants.INVOICE_STATUS_PURCHASED);// 发票状态
			}
		}
		RBcpDebtInfoVO bcpDebtInfoVO = new RBcpDebtInfoVO();
		BeanUtils.copyProperties(bcpDebtInfo, bcpDebtInfoVO);
		return bcpDebtInfoVO;
	}

	/**
	 * 还款时，为已核销的发票添加业务流水信息
	 * 
	 * @param insertDebtList
	 * @param debtBaseVO
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月1日上午10:51:25
	 */
	@Override
	@Transactional
	public void saveDebtBussInfoWhenCanceled(List<NDebtBillsInfoVO> insertDebtList, DebtBussInfoVO debtBaseVO)
			throws ScubeBizException
	{
		// String toSallerFlag=debtBaseVO.getIsInSeller();
		RBcpDebtBussInfo debtCancelBussInfo = new RBcpDebtBussInfo();// 流水总表
		String bussType = "";
		int number = 0;// 记录核销发票个数
		for(int i = 0; i < insertDebtList.size(); i++)
		{
			NDebtBillsInfoVO debtVO = (NDebtBillsInfoVO) insertDebtList.get(i);
			RBcpDebtInfo bcpDebtInfo = rbcpdebtinfodao.selectByPrimaryKey(debtVO.getId());// debBaseVO更改为debtVO
																							// mengjiajia;
			BigDecimal payPrincipalAmount = debtVO.getPayPrincipalAmount() == null ? new BigDecimal("0")
					: debtVO.getPayPrincipalAmount();// 还本
			BigDecimal payRateAmount = debtVO.getPayRateAmount() == null ? new BigDecimal("0")
					: debtVO.getPayRateAmount();// 还息
			BigDecimal removeAmount = debtVO.getRemoveAmount() == null ? new BigDecimal("0") : debtVO.getRemoveAmount();// 发票冲销金额
			// 1：为核销的发票信息，添加到流水详细信息
			RBcpDebtBussDtl debtBussDetail = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(debtVO, debtBussDetail);
			bussType = bcpDebtInfo.getBussType();
			debtBussDetail.setId(UUIDGeneratorUtil.generate());
			debtBussDetail.setDebtId(bcpDebtInfo.getId());// 发票id
			debtBussDetail.setApplyType(DebtConstants.APPLY_TYPE_VERIFY);// 申请类型
			debtBussDetail.setCustcdBuyer(debtBaseVO.getCustcdBuyer());// 买方
			debtBussDetail.setCustcdSaller(debtBaseVO.getCustcdSaller());// 卖方
			debtBussDetail.setAppno(debtBaseVO.getAppno());// 申请号
			debtBussDetail.setMastContno(debtBaseVO.getMastContno());// 合同
			debtBussDetail.setLoanWay(debtVO.getLoanWay());// 出账方式
			debtBussDetail.setBussType(bcpDebtInfo.getBussType());// 业务品种
			debtBussDetail.setStatus(DebtConstants.INVOICE_STATUS_VERIFIED);// 已核销
			debtBussDetail.setAging(bcpDebtInfo.getAging());// 账龄
			debtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			debtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			debtBussDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));// 核销日期
			debtBussDetail.setMoney(removeAmount);// 核销金额
			debtBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));// 核销日期
			nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(debtBussDetail);
			// 2：统计核销的发票信息
			number++;// 记录增加
			debtCancelBussInfo.setDebtNum(number);// 记录付给流水总表
			BigDecimal returnAmount = debtCancelBussInfo.getReturnAmount() == null ? new BigDecimal("0")
					: debtCancelBussInfo.getReturnAmount();// 流水还款金额
			debtCancelBussInfo.setReturnAmount(
					debtCancelBussInfo.getReturnAmount() == null ? removeAmount : removeAmount.add(returnAmount));// 发票还款金额
			BigDecimal rateAmount = debtCancelBussInfo.getReturnInterestAmount() == null ? new BigDecimal("0")
					: debtCancelBussInfo.getReturnInterestAmount();// 流水还息金额
			BigDecimal captionAmount = debtCancelBussInfo.getReturnCapitalAmount() == null ? new BigDecimal("0")
					: debtCancelBussInfo.getReturnCapitalAmount();// 流水还本金额
			debtCancelBussInfo.setReturnCapitalAmount(debtCancelBussInfo.getReturnCapitalAmount() == null
					? payPrincipalAmount : payPrincipalAmount.add(captionAmount));// 发票还本金额
			debtCancelBussInfo.setReturnInterestAmount(debtCancelBussInfo.getReturnInterestAmount() == null
					? payRateAmount : payRateAmount.add(rateAmount));// 发票还息金额
		}
		// 核销发起流水业务
		if(number > 0)
		{// 若有核销的发票
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
			nrbcpdebtbussinfoservice.addRBcpDebtBussInfo(debtCancelBussInfo);
		}
	}

	/**
	 * 核销申请发票添加
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月2日下午3:24:50
	 */
	@Override
	public Page getInvoiceChargeOffAddQry(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		log.info("核销发票添加 method:getInvoiceChargeOffAddQry begin");
		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> statusList = new ArrayList<String>();
		statusList.add(DebtConstants.INVOICE_STATUS_PURCHASED);
		statusList.add(DebtConstants.INVOICE_STATUS_FINANCED);
		omap.put("statusList", statusList);// 发票状态已承购
		omap.put("issueFlag", DebtConstants.ISSUE_FLAG_FALSE);
		omap.put("poolFlag", DebtConstants.POOL_FLAG_IN_POOL);//在池状态
		// 发票未被锁定或是被本流程锁定
		omap.put("isLocked", ScfBasConstant.LOCKED);// 不等于
		if(!StringUtil.isEmpty(debtCommonQryVO.getAppno_Q()))
		{
			omap.put("lockAppno", debtCommonQryVO.getAppno_Q());
		}
		omap.put("state", ScfBasConstant.FLAG_ON);// 不等于
		omap.put("isSettle", ScfBasConstant.FLAG_ON);// 等于
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdBuyer_Q()))
		{
			omap.put("custcdBuyer", debtCommonQryVO.getCustcdBuyer_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdSaller_Q()))
		{
			omap.put("custcdSaller", debtCommonQryVO.getCustcdSaller_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getMastContno()))
		{
			omap.put("mastContno", debtCommonQryVO.getMastContno());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_from_Q()))
		{ // 发票登记日期
			omap.put("insertDate1", debtCommonQryVO.getInsertDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_to_Q()))
		{ // 发票登记日期
			omap.put("insertDate2", debtCommonQryVO.getInsertDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getPurchaseDate_from_Q()))
		{ // 承购日期起
			omap.put("purchaseDate1", debtCommonQryVO.getPurchaseDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getPurchaseDate_to_Q()))
		{ // 承购日期止
			omap.put("purchaseDate2", debtCommonQryVO.getPurchaseDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_from_Q()))
		{ // 发票日期起
			omap.put("billsDate1", debtCommonQryVO.getBillsDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_to_Q()))
		{ // 发票日期止
			omap.put("billsDate2", debtCommonQryVO.getBillsDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getEndDate_from_Q()))
		{ // 到期日 起
			omap.put("debtEnd1", debtCommonQryVO.getEndDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getEndDate_to_Q()))
		{ // 到期日 止
			omap.put("debtEnd2", debtCommonQryVO.getEndDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_from_Q()))
		{ // 发票金额
			omap.put("billsAmount1", debtCommonQryVO.getBillsAmount_from_Q());// 起
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_to_Q()))
		{ // 发票金额
			omap.put("billsAmount2", debtCommonQryVO.getBillsAmount_to_Q());// 止
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsNo_Q()))
		{ // 发票号码
			omap.put("billsNo", debtCommonQryVO.getBillsNo_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsType_Q()))
		{ // 应收账款类型
			omap.put("billsType", debtCommonQryVO.getBillsType_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBussTypeList_Q()))
		{
			omap.put("ids", debtCommonQryVO.getBussTypeList_Q());
		}
		int total = extnrecbcpdao.countInvoiceChargeOffAddQry(omap);
		Page page = new Page(debtCommonQryVO.getPageSize(), debtCommonQryVO.getPageIndex(), total);
		page.setRecords(extnrecbcpdao.getInvoiceChargeOffAddQry(omap, page, debtCommonQryVO.isPageFlag()));
		page.setTotalRecord(total);
		log.info("核销发票添加method:getInvoiceChargeOffAddQry end");
		return page;
	}

	/**
	 * 核销申请审批通过
	 * 
	 * @param insertDebtList
	 * @param bcpDebtBussInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月2日下午4:07:39
	 */
	@Override
	public void factoringChargeOffAddSave(List<NDebtBillsInfoVO> insertDebtList, RBcpDebtBussInfo bcpDebtBussInfo)
			throws ScubeBizException
	{
		//合同信息
		BCntBcpInfo bcpInfo = bcntbcpinfodao.selectByPrimaryKey(bcpDebtBussInfo.getMastContno());
		NDebtBillsInfoVO baseDebtVo = null;
		for(int i = 0; i < insertDebtList.size(); i++)
		{
			baseDebtVo = (NDebtBillsInfoVO) insertDebtList.get(i);
			BigDecimal removeAmounts = baseDebtVo.getRemoveAmount() == null ? new BigDecimal("0")
					: baseDebtVo.getRemoveAmount();// 核销金额
			RBcpDebtInfoVO bcpDebtInfoVO = this.updateDebtStateByRemainingAmount(baseDebtVo, removeAmounts, null, null);
			RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
			try
			{
				BeanUtils.copyProperties(bcpDebtInfoVO, tblDebtBussDetail);
			}catch (BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			tblDebtBussDetail.setDebtId(bcpDebtInfoVO.getId());
			tblDebtBussDetail.setApplyType(bcpDebtBussInfo.getApplyType());
			tblDebtBussDetail.setAppno(bcpDebtBussInfo.getAppno());
			tblDebtBussDetail.setBussType(bcpDebtInfoVO.getBussType());
			tblDebtBussDetail.setRemoveAmount(baseDebtVo.getRemoveAmount());// 核销金额
			tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			tblDebtBussDetail.setReason(bcpDebtBussInfo.getReason());
			tblDebtBussDetail.setOtherReason(bcpDebtBussInfo.getOtherReason());
			tblDebtBussDetail.setMoney(baseDebtVo.getRemoveAmount());
			//新增核销明细信息
			nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(tblDebtBussDetail);
			if(bcpInfo.getFinancingType().equals(DebtConstants.FINANCING_TYPE_POOL)
					&&bcpDebtInfoVO.getStatus().equals(DebtConstants.INVOICE_STATUS_VERIFIED))
			{//如果为池融资并且应收账款为核销状态 则设置出池，并新增出池历程
				bcpDebtInfoVO.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);//出池
				tblDebtBussDetail.setRemoveAmount(BigDecimal.ZERO);// 核销金额设置为0，交易金额不变
				tblDebtBussDetail.setApplyType(DebtConstants.APPLY_TYPE_OUT_POOL);
				//新增出池明细信息
				nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(tblDebtBussDetail);
			}
			BigDecimal removeAmount = bcpDebtInfoVO.getRemoveAmount() == null ? new BigDecimal("0")
					: bcpDebtInfoVO.getRemoveAmount();// 发票核销金额
			bcpDebtInfoVO.setRemoveAmount(removeAmount.add(removeAmounts));
			BigDecimal remainingUseableAmount = bcpDebtInfoVO.getRemainingUseableAmount() == null ? new BigDecimal("0")
					: bcpDebtInfoVO.getRemainingUseableAmount();
			BigDecimal loanPercent = bcpDebtInfoVO.getLoanPercent() == null ? new BigDecimal("0")
					: bcpDebtInfoVO.getLoanPercent();
			bcpDebtInfoVO.setRemainingUseableAmount(remainingUseableAmount.subtract(
					removeAmounts.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));// 发票可融资余额
			BigDecimal remainingAmount = bcpDebtInfoVO.getRemainingAmount() == null ? new BigDecimal("0")
					: bcpDebtInfoVO.getRemainingAmount();// 发票余额
			BigDecimal amount = remainingAmount.subtract(removeAmounts);// 得到核销后发票余额
			bcpDebtInfoVO.setRemainingAmount(amount);
			// log.info("核销后金额:——————————————————————"+baseDebtVo.getRebatebalance().toString());
			/*
			 * if((baseDebtVo.getRebatebalance()==null?new
			 * BigDecimal("0"):baseDebtVo.getRebatebalance()).compareTo(num)==0)
			 * { bcpDebtInfoVO.setStatus(DebtConstants.INVOICE_STATUS_03); }
			 */

			this.updateRBcpDebtInfo(bcpDebtInfoVO);
		}
	}

	/**
	 * 根据id查询应收账款列表
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日上午10:37:04
	 */
	@Override
	public Page getAcquisitionsInformation(DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		RBcpDebtInfoExample example = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria cri = example.createCriteria();
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsNo_Q()))
		{
			if(debtCommonQryVO.getBillsNo_Q().indexOf("/f") == -1)
			{
				cri.andIdEqualTo(debtCommonQryVO.getBillsNo_Q());
			}
			else
			{
				List<String> ids = new ArrayList<String>();
				String[] id = debtCommonQryVO.getBillsNo_Q().split("/f");
				for(int i = 0; i < id.length; i++)
				{
					if(!StringUtil.isEmpty(id[i]))
					{
						ids.add(id[i]);
					}
				}
				if(ids != null && ids.size() > 0)
				{
					cri.andIdIn(ids);
				}
			}
		}
		else
		{
			cri.andIdEqualTo("0");
		}
		example.setOrderByClause("DEBT_END,BILLS_NO");

		int total = rbcpdebtinfodao.countByExample(example);
		Page page = new Page(debtCommonQryVO.getPageSize(), debtCommonQryVO.getPageIndex(), total);
		page.setRecords(rbcpdebtinfodao.selectByPage(example, page));
		page.setTotalRecord(total);
		return page;
	}

	/**
	 * 减值申请发票添加查询
	 * 
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日上午11:00:52
	 */
	@Override
	public Page getInvoiceAllowanceAddQry(DebtCommonQryVO debtCommonQryVO, boolean flag) throws ScubeBizException
	{
		log.info("减值发票添加 method:getInvoiceAllowanceAddQry begin");

		HashMap<String, Object> omap = new HashMap<String, Object>();
		List<String> statusList = new ArrayList<String>();
		statusList.add(DebtConstants.INVOICE_STATUS_PURCHASED);
		statusList.add(DebtConstants.INVOICE_STATUS_FINANCED);
		omap.put("statusList", statusList);// 发票状态已承购或已融资
		omap.put("issueFlag", DebtConstants.ISSUE_FLAG_FALSE);
		// 发票未被锁定或是被本流程锁定
		omap.put("isLocked", ScfBasConstant.LOCKED);// 不等于
		if(!StringUtil.isEmpty(debtCommonQryVO.getAppno_Q()))
		{
			omap.put("lockAppno", debtCommonQryVO.getAppno_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdBuyer_Q()))
		{
			omap.put("custcdBuyer", debtCommonQryVO.getCustcdBuyer_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdSaller_Q()))
		{
			omap.put("custcdSaller", debtCommonQryVO.getCustcdSaller_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getMastContno()))
		{
			omap.put("mastContno", debtCommonQryVO.getMastContno());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_from_Q()))
		{ // 发票登记日期
			omap.put("insertDate1", debtCommonQryVO.getInsertDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getInsertDate_to_Q()))
		{ // 发票登记日期
			omap.put("insertDate2", debtCommonQryVO.getInsertDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getPurchaseDate_from_Q()))
		{ // 承购日期起
			omap.put("purchaseDate1", debtCommonQryVO.getPurchaseDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getPurchaseDate_to_Q()))
		{ // 承购日期止
			omap.put("purchaseDate2", debtCommonQryVO.getPurchaseDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_from_Q()))
		{ // 发票日期起
			omap.put("billsDate1", debtCommonQryVO.getBillsDate_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsDate_to_Q()))
		{ // 发票日期止
			omap.put("billsDate2", debtCommonQryVO.getBillsDate_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getDebtEnd_from_Q()))
		{ // 到期日 起
			omap.put("debtEnd1", debtCommonQryVO.getDebtEnd_from_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getDebtEnd_to_Q()))
		{ // 到期日 止
			omap.put("debtEnd2", debtCommonQryVO.getDebtEnd_to_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_from_Q()))
		{ // 发票金额
			omap.put("billsAmount1", debtCommonQryVO.getBillsAmount_from_Q());// 起
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsAmount_to_Q()))
		{ // 发票金额
			omap.put("billsAmount2", debtCommonQryVO.getBillsAmount_to_Q());// 止
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsNo_Q()))
		{ // 发票号码
			omap.put("billsNo", debtCommonQryVO.getBillsNo_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBillsType_Q()))
		{ // 应收账款类型
			omap.put("billsType", debtCommonQryVO.getBillsType_Q());
		}
		if(!StringUtil.isEmpty(debtCommonQryVO.getBussTypeList_Q()))
		{
			omap.put("ids", debtCommonQryVO.getBussTypeList_Q());
		}
		int total = extnrecbcpdao.countInvoiceAllowanceAddQry(omap);
		Page page = new Page(debtCommonQryVO.getPageSize(), debtCommonQryVO.getPageIndex(), total);
		page.setRecords(extnrecbcpdao.getInvoiceAllowanceAddQry(omap, page, flag));
		page.setTotalRecord(total);
		log.info("减值发票添加method:getInvoiceAllowanceAddQry end");
		return page;
	}

	/**
	 * 回购申请发票添加
	 * @param commonQueryVO
	 * @param flag
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年7月21日上午10:46:41
	 */
	@Override
	public Page getInvoiceDebtBackAddQry(DebtCommonQryVO commonQueryVO) throws ScubeBizException
	{
		log.info("回购发票添加 method:getInvoiceDebtBackAddQry begin");

		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("status1", DebtConstants.INVOICE_STATUS_PURCHASED);
		omap.put("status2", DebtConstants.INVOICE_STATUS_FINANCED);
		omap.put("issueFlag", DebtConstants.ISSUE_FLAG_FALSE);
		omap.put("poolFlag", DebtConstants.POOL_FLAG_OUT_POOL);
		omap.put("isLocked", ScfBasConstant.LOCKED);
		if(StringUtil.isStrNotEmpty(commonQueryVO.getAppno_Q()))
		{
			omap.put("lockAppno", commonQueryVO.getAppno_Q());
		}
		omap.put("state", ScfBasConstant.FLAG_ON);
		if(!StringUtil.isEmpty(commonQueryVO.getMastContno()))
		{
			omap.put("mastContno", commonQueryVO.getMastContno());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getCustcdBuyer_Q()))
		{
			omap.put("custcdBuyer", commonQueryVO.getCustcdBuyer_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getCustcdSaller_Q()))
		{
			omap.put("custcdSaller", commonQueryVO.getCustcdSaller_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getInsertDate_from_Q()))
		{ // 发票登记日期
			omap.put("insertDate1", commonQueryVO.getInsertDate_from_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getInsertDate_to_Q()))
		{ // 发票登记日期
			omap.put("insertDate2", commonQueryVO.getInsertDate_to_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getPurchaseDate_from_Q()))
		{ // 承购日期起
			omap.put("purchaseDate1", commonQueryVO.getPurchaseDate_from_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getPurchaseDate_to_Q()))
		{ // 承购日期止
			omap.put("purchaseDate2", commonQueryVO.getPurchaseDate_to_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBillsDate_from_Q()))
		{ // 发票日期
			omap.put("billsDate1", commonQueryVO.getBillsDate_from_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBillsDate_to_Q()))
		{ // 发票日期
			omap.put("billsDate2", commonQueryVO.getBillsDate_to_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getDebtEnd_from_Q()))
		{ // 到期日
			omap.put("debtEnd1", commonQueryVO.getDebtEnd_from_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getDebtEnd_to_Q()))
		{ // 到期日
			omap.put("debtEnd2", commonQueryVO.getDebtEnd_to_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBillsNo_Q()))
		{// 凭证编号
			omap.put("billsNo", commonQueryVO.getBillsNo_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBillsType_Q()))
		{// 凭证类型
			omap.put("billsType", commonQueryVO.getBillsType_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBussTypeList_Q()))
		{
			omap.put("ids", commonQueryVO.getBussTypeList_Q());
		}
		int total = extnrecbcpdao.countInvoiceDebtBackAddQry(omap);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(extnrecbcpdao.getInvoiceDebtBackAddQry(omap, page, commonQueryVO.isPageFlag()));
		page.setTotalRecord(total);
		log.info("回购发票添加method:getInvoiceDebtBackAddQry end");
		return page;
	}

	/**
	 * 折让申请审批通过
	 * 
	 * @param insertDebtList
	 * @param bcpDebtBussInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月5日下午2:58:37
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void factoringAllowanceAddApply(List<NDebtBillsInfoVO> insertDebtList, RBcpDebtBussInfo bcpDebtBussInfo)
			throws ScubeBizException
	{
		NDebtBillsInfoVO baseDebtVo = null;
		for(int i = 0; i < insertDebtList.size(); i++)
		{
			baseDebtVo = insertDebtList.get(i);
			RBcpDebtInfoVO tblDebtBaseInfo = this.queryRBcpDebtInfoById(baseDebtVo.getId());
			RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
			try
			{
				BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);
			}catch (BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			tblDebtBussDetail.setId(UUIDGeneratorUtil.generate());
			tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
			tblDebtBussDetail.setApplyType(bcpDebtBussInfo.getApplyType());
			tblDebtBussDetail.setAppno(bcpDebtBussInfo.getAppno());
			tblDebtBussDetail.setBussType(tblDebtBaseInfo.getBussType());
			tblDebtBussDetail.setRebateAmount(baseDebtVo.getRebateAmount());// 折让金额
			tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			tblDebtBussDetail.setMoney(baseDebtVo.getRebateAmount());
			tblDebtBussDetail.setCommonDate(ScfDateUtil.getStringDate(new Date()));
			//新增减值 应收账款明细
			nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(tblDebtBussDetail);
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> list = nrbcpdebtbussdtlservice
					.queryDebtBussDetailByBillsNo(tblDebtBussDetail.getAppno(), tblDebtBaseInfo.getId());
			if(list != null && list.size() > 0)
			{
				for(com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl debtVO : list)
				{
					RBcpDebtInfoVO debtInfoVO = this.queryRBcpDebtInfoById(debtVO.getDebtId());
					BigDecimal remainingAmount = debtInfoVO.getRemainingAmount() == null ? new BigDecimal("0")
							: debtInfoVO.getRemainingAmount();// 发票余额
					BigDecimal rebateAmount = debtInfoVO.getRebateAmount() == null ? new BigDecimal("0")
							: debtInfoVO.getRebateAmount();
					BigDecimal rebateAmounts = debtVO.getRebateAmount() == null ? new BigDecimal("0")
							: debtVO.getRebateAmount();// 明细表中折让金额
					debtInfoVO.setRebateAmount(rebateAmount.add(rebateAmounts));// 折让金额累加
					BigDecimal remainingUseableAmount = debtInfoVO.getRemainingUseableAmount() == null
							? new BigDecimal("0") : debtInfoVO.getRemainingUseableAmount();
					BigDecimal loanPercent = debtInfoVO.getLoanPercent() == null ? new BigDecimal("0")
							: debtInfoVO.getLoanPercent();
					debtInfoVO.setRemainingUseableAmount(remainingUseableAmount.subtract(rebateAmounts
							.multiply(loanPercent).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)));// 发票可融资余额
					BigDecimal amount = remainingAmount.subtract(rebateAmounts);// 得到折让后发票余额
					debtInfoVO.setRemainingAmount(amount);
					BigDecimal loanRemainingAmount = debtInfoVO.getLoanRemainingAmount();
					BigDecimal loanAmount = loanRemainingAmount.subtract(rebateAmounts);
					debtInfoVO.setLoanRemainingAmount(
							loanRemainingAmount.compareTo(rebateAmounts) >= 0 ? loanAmount : BigDecimal.ZERO);
					if("0".equals(amount.toString()))
					{//减值后应收账款余额为0
						//修改应收账款为核销状态
						debtInfoVO.setStatus(DebtConstants.INVOICE_STATUS_VERIFIED);
						//核销	新增核销明细信息
						tblDebtBussDetail.setApplyType(DebtConstants.APPLY_TYPE_VERIFY);
						tblDebtBussDetail.setRebateAmount(BigDecimal.ZERO);
						nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(tblDebtBussDetail);
						//如果应收账款为池应收账款且为入池状态，则自动出池
						if(debtInfoVO.getPoolFlag() != null && debtInfoVO.getPoolFlag().equals("1")){
							debtInfoVO.setPoolFlag("0");//自动出池
							//对应新增出池明细信息
							tblDebtBussDetail.setApplyType(DebtConstants.APPLY_TYPE_OUT_POOL);//出池
							nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(tblDebtBussDetail);
						}
					}
					debtInfoVO.setIsLocked(ScfBasConstant.UNLOCKED);
					debtInfoVO.setLockAppno("");
					this.updateRBcpDebtInfo(debtInfoVO);
				}
			}
			else
			{
				throw new ScubeBizException("获取流水明细表失败", RBcpErrorConstant.RECORD_HAS_EXIST);
			}
		}
	}

	// 商纠解除单据筛选
	@Override
	public Page findRBcpDebtInfoForRegisterRemove(int pageNo, int pageSize, RBcpDebtInfoVO rBcpDebtInfoVO,
			List<RBcpDebtInfoVO> list) throws ScubeBizException
	{
		if(rBcpDebtInfoVO == null)
		{
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		if(list != null && list.size() > 0)
		{
			for(RBcpDebtInfoVO rBcpDebtBaseInfo1 : list)
			{
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(null != rBcpDebtInfoVO)
		{
			String lockAppno = rBcpDebtInfoVO.getLockAppno();
			String mastContno = rBcpDebtInfoVO.getMastContno();
			String custcdBuyer = rBcpDebtInfoVO.getCustcdBuyer();
			String custcdSaller = rBcpDebtInfoVO.getCustcdSaller();

			String billsDateFrom = rBcpDebtInfoVO.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtInfoVO.getBillsDateTo();
			String debtEndFrom = rBcpDebtInfoVO.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtInfoVO.getDebtEndTo();

			String billsNo = rBcpDebtInfoVO.getBillsNo(); // 凭证编号
			String factType = rBcpDebtInfoVO.getFactType();
			String flawFlag = rBcpDebtInfoVO.getFlawFlag();
			String billsType = rBcpDebtInfoVO.getBillsType(); // 凭证类型
			String poolFlag = rBcpDebtInfoVO.getPoolFlag(); // 入池标识
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
		try
		{
			List<RBcpDebtInfo> rBcpDebtInfoList = extnrecbcpdao.getDebtInvoiceInfoRemove(map, page);
			ArrayList<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> rBcpDebtBussDtlList = new ArrayList<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl>();

			for(RBcpDebtInfo rBcpDebtInfo1 : rBcpDebtInfoList)
			{
				RBcpDebtBussDtlExample rBcpDebtBussDtlExample = new RBcpDebtBussDtlExample();
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtlExample.Criteria rBcpDebtBussDtlCri = rBcpDebtBussDtlExample
						.createCriteria();
				rBcpDebtBussDtlCri.andDebtIdEqualTo(rBcpDebtInfo1.getId());
				rBcpDebtBussDtlCri.andApplyTypeEqualTo(DebtConstants.APPLY_TYPE_ISSUE_SET);// 商纠设定
				// 这里现在是通过ID，之前是用过申请号排序。
				rBcpDebtBussDtlExample.setOrderByClause(" ID desc");// 申请号是日期加上XXXX，取最大的（就是最新数据）
				List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl> rBcpDebtBussDtlList2 = rbcpdebtbussdtldao
						.selectByExample(rBcpDebtBussDtlExample);
				if(rBcpDebtBussDtlList2 != null && rBcpDebtBussDtlList2.size() > 0)
				{
					rBcpDebtBussDtlList2.get(0).setDeadline(rBcpDebtInfo1.getDeadline());
					rBcpDebtBussDtlList.add(rBcpDebtBussDtlList2.get(0));
				}
			}
			page.setRecords(rBcpDebtBussDtlList);

		}catch (Exception e)
		{// 10009- 条件分页查询条件分页查询应收账款信息失败
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009), RBcpErrorConstant.SCF_REC_BCP_10009);
		}
		return page;
	}

	// 通过锁定的申请号，直接解锁。
	@Override
	@Transactional
	public void releaseDebtInfoByAppno(String appno) throws ScubeBizException
	{
		try
		{
			RBcpDebtInfoExample rBcpDebtInfoExample = new RBcpDebtInfoExample();
			RBcpDebtInfoExample.Criteria createCriteria = rBcpDebtInfoExample.createCriteria();
			createCriteria.andLockAppnoEqualTo(appno);
			List<RBcpDebtInfo> rBcpDebtInfoList = rbcpdebtinfodao.selectByExample(rBcpDebtInfoExample);
			if(rBcpDebtInfoList != null && rBcpDebtInfoList.size() > 0)
			{
				for(RBcpDebtInfo rBcpDebtInfo : rBcpDebtInfoList)
				{
					rBcpDebtInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);
					rBcpDebtInfo.setLockAppno("");
					rbcpdebtinfodao.updateByPrimaryKeySelective(rBcpDebtInfo);
				}
			}

		}catch (Exception e)
		{
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		return;
	}

	@Override
	public Page findRBcpDebtInfoForInPoolOrOutPool(int pageNo, int pageSize, RBcpDebtInfoVO rBcpDebtInfoVO,
			List<RBcpDebtInfoVO> list) throws ScubeBizException
	{
		if(rBcpDebtInfoVO == null)
		{
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
					.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		if(list != null && list.size() > 0)
		{
			for(RBcpDebtInfoVO rBcpDebtBaseInfo1 : list)
			{
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(null != rBcpDebtInfoVO)
		{
			String lockAppno = rBcpDebtInfoVO.getLockAppno();
			String mastContno = rBcpDebtInfoVO.getMastContno();
			String custcdBuyer = rBcpDebtInfoVO.getCustcdBuyer();
			String custcdSaller = rBcpDebtInfoVO.getCustcdSaller();

			String billsDateFrom = rBcpDebtInfoVO.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtInfoVO.getBillsDateTo();
			String debtEndFrom = rBcpDebtInfoVO.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtInfoVO.getDebtEndTo();

			String billsNo = rBcpDebtInfoVO.getBillsNo(); // 凭证编号
			String factType = rBcpDebtInfoVO.getFactType();
			String flawFlag = rBcpDebtInfoVO.getFlawFlag();
			String billsType = rBcpDebtInfoVO.getBillsType(); // 凭证类型
			String poolFlag = rBcpDebtInfoVO.getPoolFlag(); // 入池标识
			//当出池申请的时候，所查询的单据不能参加过放款。
			if(StringUtils.isNotEmpty(poolFlag)&& poolFlag.equals("1")){
				map.put("flag", "outPool");
			}
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
		extnrecbcpdao.getDebtInvoiceInfoForPoolManage(map, page);
		return page;
	}

	@Override
	public List<RBcpDebtInfoVO> findRBcpDebtInfoListByAppno(String appno) throws ScubeBizException
	{
		if(StringUtils.isEmpty(appno))
		{
			return null;
		}
		RBcpDebtInfoExample rBcpDebtInfoExample = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria criteria = rBcpDebtInfoExample.createCriteria();
		criteria.andLockAppnoEqualTo(appno);
		List<RBcpDebtInfo> rBcpDebtInfoList = rbcpdebtinfodao.selectByExample(rBcpDebtInfoExample);
		ArrayList<RBcpDebtInfoVO> arrayList = new ArrayList<RBcpDebtInfoVO>();
		if(rBcpDebtInfoList != null && rBcpDebtInfoList.size() > 0)
		{
			for(RBcpDebtInfo rBcpDebtInfo : rBcpDebtInfoList)
			{
				RBcpDebtInfoVO rBcpDebtInfoVO = new RBcpDebtInfoVO();
				BeanUtils.copyProperties(rBcpDebtInfo, rBcpDebtInfoVO);
				arrayList.add(rBcpDebtInfoVO);
			}
		}
		return arrayList;
	}

	/**
	 * 根据合同编号查询应收账款金额总值
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年7月5日上午9:51:53
	 */
	@Override
	public RBcpDebtInfoVO findSumRBcpDebtInfoByMastContno(String mastContno, String appno) throws ScubeBizException
	{
		if(StringUtil.isEmpty(mastContno))
		{
			throw new ScubeBizException("合同编号丢失");
		}
		RBcpDebtInfo param = new RBcpDebtInfo();
		param.setMastContno(mastContno);
		param.setPoolFlag(DebtConstants.POOL_FLAG_IN_POOL);// 入池
		param.setStatus(DebtConstants.INVOICE_STATUS_PURCHASED);// 转让状态
		if(!StringUtil.isEmpty(appno))
		{
			param.setLockAppno(appno);
			param.setIsLocked(DebtConstants.LOCKED);
		}
		RBcpDebtInfo bcpDebtInfo = extnrecbcpdao.findSumRBcpDebtInfoByMastContno(param);
		RBcpDebtInfoVO debtInfoVO = new RBcpDebtInfoVO();
		BeanUtils.copyProperties(bcpDebtInfo, debtInfoVO);
		return debtInfoVO;
	}

	/**
	 * 根据合同编号查询应收账款金额总值(非本次业务的已锁定应收账款)
	 * @param mastContno
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年7月18日下午4:43:27
	 */
	@Override
	public RBcpDebtInfoVO findOtherSumRBcpDebtInfoByMastContno(String mastContno, String appno) throws ScubeBizException
	{
		if(StringUtil.isEmpty(mastContno))
		{
			throw new ScubeBizException("合同编号丢失");
		}
		if(StringUtil.isEmpty(appno))
		{
			throw new ScubeBizException("业务申请编号丢失");
		}
		//获取非本次业务申请且在流程中（已锁定）的应收账款信息
		RBcpDebtInfoExample example = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria cri = example.createCriteria();
		cri.andMastContnoEqualTo(mastContno);
		cri.andStatusEqualTo(DebtConstants.INVOICE_STATUS_PURCHASED);// 转让状态
		cri.andPoolFlagEqualTo(DebtConstants.POOL_FLAG_IN_POOL);// 入池
		cri.andIsLockedEqualTo(DebtConstants.LOCKED);//锁定
		cri.andLockAppnoNotEqualTo(appno);
		List<RBcpDebtInfo> list = rbcpdebtinfodao.selectByExample(example);
		List<String> lockAppnos = new ArrayList<String>();
		List<RBcpDebtInfo> result = new ArrayList<RBcpDebtInfo>();
		if(list!=null&&list.size()>0)
		{
			for(RBcpDebtInfo bcpDebtInfo:list)
			{
				String lockAppno = bcpDebtInfo.getLockAppno();
				if(lockAppno.indexOf("SJDJ")>-1||lockAppno.indexOf("YSFZR")>-1||lockAppno.indexOf("YSHX")>-1||lockAppno.indexOf("YSCC")>-1)
				{//商纠登记，反转让，核销	，出池	此类业务申请最终将出池，不算入统计结果中
				}
				else if(lockAppno.indexOf("YSHK")>-1||lockAppno.indexOf("YSJZ")>-1||lockAppno.indexOf("FFK-")>-1)
				{//回款，减值，放款(池融资放款不锁定应收账款，故此类情况不存在，需另外统计)
					lockAppnos.add(lockAppno);
					result.add(bcpDebtInfo);
				}
			}
		}
		else
		{
			return null;
		}
		BigDecimal billsAmount = BigDecimal.ZERO;//预估应收账款有效金额
		BigDecimal remainingAmount = BigDecimal.ZERO;//预估应收账款余额
		BigDecimal loanAmount = BigDecimal.ZERO;//预估融资金额
		if(result!=null&&result.size()>0)
		{
			for(RBcpDebtInfo bcpDebtInfo:result)
			{
				billsAmount = billsAmount.add(bcpDebtInfo.getBillsAmount());//有效金额
				remainingAmount = remainingAmount.add(bcpDebtInfo.getRemainingAmount());//应收账款余额
			}
		}
		//放款流程中的应收账款信息
		List<RBcpDebtInfo> debtlist = this.getDuebillAppFlowRBcpDebtInfo();
		if(debtlist!=null&&debtlist.size()>0)
		{
			for(RBcpDebtInfo debtInfo:debtlist)
			{
				billsAmount = billsAmount.add(debtInfo.getBillsAmount());//有效金额
				remainingAmount = remainingAmount.add(debtInfo.getRemainingAmount());//应收账款余额
			}
		}
		//放款流程中的业务申请信息
		List<BPbcAppliBaseInfoVO> applist = bpbcapplibaseinfoservice.findInFlowDuebillAppByParam();
		if(applist!=null&&applist.size()>0)
		{
			for(BPbcAppliBaseInfoVO appliBaseInfoVO:applist)
			{
				//申请融资金额
				loanAmount = loanAmount.add(appliBaseInfoVO.getAmt());
			}
		}
		if(lockAppnos!=null&&lockAppnos.size()>0)
		{
			BPbcAppliBaseInfoExample example2 = new BPbcAppliBaseInfoExample();
			BPbcAppliBaseInfoExample.Criteria cri2 = example2.createCriteria();
			cri2.andAppnoIn(lockAppnos);
			List<BPbcAppliBaseInfo> appliBaseInfos = bpbcapplibaseinfodao.selectByExample(example2);
			if(appliBaseInfos!=null&&appliBaseInfos.size()>0)
			{
				for(BPbcAppliBaseInfo appliBaseInfo:appliBaseInfos)
				{
					String appliType = appliBaseInfo.getAppliType();
					if(WorkflowConstant.APPLI_TYPE_ALLOWANCEPOOLAPPLY.equals(appliType))
					{
						//应收账款减值
						BigDecimal rebateAmount = BigDecimal.ZERO;//减值金额
						RBcpAppliBussDtlExample example3 = new RBcpAppliBussDtlExample();
						RBcpAppliBussDtlExample.Criteria cri3 = example3.createCriteria();
						cri3.andAppnoEqualTo(appliBaseInfo.getAppno());
						cri3.andPoolFlagEqualTo(DebtConstants.POOL_FLAG_IN_POOL);//入池状态
						List<RBcpAppliBussDtl> bussDtls = rbcpapplibussdtldao.selectByExample(example3);
						if(bussDtls!=null&&bussDtls.size()>0)
						{
							for(RBcpAppliBussDtl bussDtl:bussDtls)
							{
								rebateAmount = rebateAmount.add(StringUtil.isEmpty(bussDtl.getRebateAmount())?BigDecimal.ZERO:bussDtl.getRebateAmount());
							}
						}
						remainingAmount = remainingAmount.subtract(rebateAmount);
					}
					else if(WorkflowConstant.APPLI_TYPE_FACTORING_POOL_PAYMENT_APPLY.equals(appliType))
					{
						//应收账款回款
						BigDecimal removeAmount = BigDecimal.ZERO;//核销金额
						RBcpAppliBussDtlExample example3 = new RBcpAppliBussDtlExample();
						RBcpAppliBussDtlExample.Criteria cri3 = example3.createCriteria();
						cri3.andAppnoEqualTo(appliBaseInfo.getAppno());
						cri3.andPoolFlagEqualTo(DebtConstants.POOL_FLAG_IN_POOL);//入池状态
						List<RBcpAppliBussDtl> bussDtls = rbcpapplibussdtldao.selectByExample(example3);
						if(bussDtls!=null&&bussDtls.size()>0)
						{
							for(RBcpAppliBussDtl bussDtl:bussDtls)
							{
								removeAmount = removeAmount.add(StringUtil.isEmpty(bussDtl.getRemoveAmount())?BigDecimal.ZERO:bussDtl.getRemoveAmount());
							}
						}
						RBcpAppliBussInfoExample example4 = new RBcpAppliBussInfoExample();
						RBcpAppliBussInfoExample.Criteria cri4 = example4.createCriteria();
						cri4.andAppnoEqualTo(appliBaseInfo.getAppno());
						List<RBcpAppliBussInfo> bussInfos = rbcpapplibussinfo.selectByExample(example4);
						if(bussInfos!=null&&bussInfos.size()>0)
						{
							RBcpAppliBussInfo bussInfo = bussInfos.get(0);
							BigDecimal amt = bussInfo.getReturnAmount().subtract(bussInfo.getTotalOverAmount());
							loanAmount = loanAmount.subtract(amt);//融资金额-偿还融资金额
						}
						remainingAmount = remainingAmount.subtract(removeAmount);
					}
				}
			}
		}
		else
		{
			return null;
		}
		RBcpDebtInfoVO debtInfoVO = new RBcpDebtInfoVO();
		debtInfoVO.setRemainingAmount(remainingAmount);
		debtInfoVO.setLoanAmount(loanAmount);
		return debtInfoVO;
	}
	
	/**
	 * 将获取到的列表信息分页
	 * @param pageNo
	 * @param pageSize
	 * @param list
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月19日下午4:41:41
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getListByPage(int pageNo, int pageSize, List list)
	{
		Page page = new Page(pageSize, pageNo, 0);
		// 根据返回的list 分页
		int totalRecord = list.size(); // 总条数
		int t = totalRecord / pageSize;
		int totalPage = totalRecord % pageSize != 0 ? ++t : t; // 总页数
		List result = new ArrayList();
		if(totalRecord > 0)
		{
			if(pageNo <= totalPage)
			{
				if(pageNo == 1)
				{
					if(totalRecord <= pageSize)
					{
						result = list.subList(0, totalRecord);
					}
					else
					{
						result = list.subList(0, pageSize);
					}
				}
				else
				{
					int start = (pageNo - 1) * pageSize;
					int end = pageNo * pageSize;
					if((totalRecord - end) % pageSize >= 0)
					{
						end = pageNo * pageSize;
					}
					else
					{
						end = (pageNo - 1) * pageSize + totalRecord % pageSize;
					}
					if(totalRecord >= end)
					{
						result = list.subList(start, end);
					}
					else
					{
						result = null;
					}

				}

			}
		}
		page.setRecords(result);
		page.setTotal(totalRecord);
		page.setTotalPage(totalPage);
		return page;
	}
	
	/**
	 * 获取放款流程中应收账款ID(目前在池融资中使用)
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月20日下午4:54:50
	 */
	public List<RBcpDebtInfo> getDuebillAppFlowRBcpDebtInfo()
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		//申请类型
		List<String> appliTypes = new ArrayList<String>();
		appliTypes.add(WorkflowConstant.APPLI_TYPE_FINANCINGPOOLAPPLY);//流贷放款
		omap.put("appliTypes", appliTypes);
		//流程ID
		List<String> modelIds = new ArrayList<String>();
		modelIds.add("N-"+WorkflowConstant.PROCNAME_FINANCING_POOL_APPLY);
		omap.put("modelIds", modelIds);
		//业务申请状态（流程中）
		List<String> appliStatus = new ArrayList<String>();
		appliStatus.add(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);//已提交
		appliStatus.add(WorkflowConstant.APPLI_STATUS_GOBACK);//已退回
		omap.put("appliStatus", appliStatus);
		List<RBcpDebtInfo> debtinfos = extnrecbcpdao.findInDuebillAppFlowRBcpDebtInfoByParam(omap);
		return debtinfos;
	}
}
