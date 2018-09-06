package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.base.common.beans.Page;
import com.huateng.data.service.BdDataDictService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CreditInterParamVO;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmBrInfo;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpExtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.INRBcpPaymentDAO;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpAppliBaseInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.NPaymentBussInfo;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INBLanLnciBaseService;
import com.huateng.scf.nrec.bcp.service.INBMrnAppliAcctInfoService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliRepaymentService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.INRBcpPaymentService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliRepaymentDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.PayMentLanInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 现金回款处理:
 * </p>
 * 
 * @date 2017年5月27日上午9:42:18
 * @author Qinwei
 * @version 1.0
 * @param <E>
 * @param <E>
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 */
@ScubeService
@Service(INRBcpPaymentService.BeanId)
public class NRBcpPaymentServiceImpl implements INRBcpPaymentService, DealEndFlowService, DealInFlowService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;

	@Resource(name = INRBcpPaymentDAO.BeanId)
	INRBcpPaymentDAO nRBcpPaymentDAO;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nRBcpAppliBussDtlService;
	// 单据明细信息
	@Resource(name = "NRBcpDebtBussDtlServiceImpl")
	INRBcpDebtBussDtlService nRBcpDebtBussDtlService;
	// 申请基本信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;

	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;

	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rBcpDebtPoolService;

	@Autowired
	BdDataDictService bdDataDictService;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bCntBcpInfoService;

	@Resource(name = "IBCntBcpExtInfoDAO")
	IBCntBcpExtInfoDAO iBCntDebtExtInfoDAO;

	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extBLanDAO;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bCrmBaseInfoDAO;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;

	@Resource(name = "BPrdWkflowCopServiceImpl")
	IBPrdWkflowCopService bPrdWkflowCopService;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;

	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nRBcpAppliBussInfoService;

	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactfinancebaseservice;

	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rBcpDebtInfoDAO;

	@Resource(name = "IRBcpAppliRepaymentDAO")
	IRBcpAppliRepaymentDAO rBcpAppliRepaymentDAO;

	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO bMrnAppliAcctInfoDAO;

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;

	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService nRBcpDebtInfoService;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = INBMrnAppliAcctInfoService.BEAN_ID)
	INBMrnAppliAcctInfoService bMrnAppliAcctInfoService;

	@Resource(name = INRBcpAppliRepaymentService.BEAN_ID)
	INRBcpAppliRepaymentService rbcpapplirepaymentservice;

	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntBcpInfoDAO;

	@Resource(name = INBLanLnciBaseService.BeanId)
	INBLanLnciBaseService bLanLnciBaseService;

	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO rBcpDebtBussDtlDAO;

	@Resource(name = "NRBcpDebtBussInfoServiceImpl")
	INRBcpDebtBussInfoService nrbcpdebtbussinfoservice;

	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	IBLanAppliLnciBaseService bLanAppliLnciBaseService;

	@Resource(name = IScfIndirectCreditService.BEAN_ID)
	IScfIndirectCreditService scfIndirectCreditService;

	/**
	 * 
	 * @param infoVO
	 * @return
	 * @author Qinwei
	 * @date 2017年5月27日 上午9:43:31
	 * @returnType
	 */
	@Override
	public List<BPrdInfo> queryPrdInfoByVO(Map<String, Object> infoVO) {

		List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> bprdinfoList = nRBcpPaymentDAO.findBPrdInfoByVO(infoVO);
		List<BPrdInfo> responses = new ArrayList<BPrdInfo>();

		Iterator<com.huateng.scf.bas.prd.dao.model.BPrdInfo> itr = bprdinfoList.iterator();

		while (itr.hasNext()) {
			com.huateng.scf.bas.prd.dao.model.BPrdInfo element = itr.next();
			BPrdInfo target = new BPrdInfo();
			BeanUtils.copyProperties(element, target);
			responses.add(target);
		}

		return responses;
	}

	/**
	 * 查询现金回款申请列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param appliVO
	 * @return
	 * @author Qinwei
	 * @date 2017年5月27日 下午10:43:40
	 * @returnType
	 */
	@Override
	public Page queryBPbcAppliBaseInfoList(int pageNo, int pageSize, Map<String, Object> appliVO) {
		Page p = new Page(pageSize, pageNo, 0);

		List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> records = nRBcpPaymentDAO.findBPbcAppliBaseInfoByPage(p, appliVO);
		List<BCntBcpAppliBaseInfoVO> responses = new ArrayList<BCntBcpAppliBaseInfoVO>();
		BCntBcpAppliBaseInfoVO response = null;
		for (com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo bPbcAppliBaseInfo : records) {
			response = new BCntBcpAppliBaseInfoVO();
			BeanUtils.copyProperties(bPbcAppliBaseInfo, response);
			if (StringUtils.isNotBlank(bPbcAppliBaseInfo.getCustcd())) {
				com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo cuser = bCrmBaseInfoDAO.selectById(response.getCustcd());
				response.setCname(cuser.getCname());
			}
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> rapplibaseList = rBcpAppliBussInfoDAO
					.selectAppliBussInfoBillsNo(bPbcAppliBaseInfo.getAppno());
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rapplibase = null;
			if (rapplibaseList != null && rapplibaseList.size() > 0) {
				rapplibase = rapplibaseList.get(0);
				if (StringUtils.isNotBlank(rapplibase.getCustcdBuyer())) {
					com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo exchanger = bCrmBaseInfoDAO.selectById(rapplibase.getCustcdBuyer());
					response.setBusinessCname(exchanger.getCname());
				}
			}
			if (StringUtils.isNotBlank(bPbcAppliBaseInfo.getSupplyChainPdId())) {
				com.huateng.scf.bas.prd.dao.model.BPrdInfo bprdinfo = bPrdInfoDAO.selectByPrimaryKey(response.getSupplyChainPdId());
				response.setSupplyChainPdName(bprdinfo.getProductName());
			}
			responses.add(response);
		}
		p.setRecords(responses);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());

		return p;
	}

	/**
	 * 删除现金回款申请信息
	 * 
	 * @param appno
	 * @author Qinwei
	 * @date 2017年6月1日 下午5:06:18
	 */
	@Override
	@Transactional
	public void delPaymentApply(String appno) {

		try {
			if (StringUtils.isNotBlank(appno)) {
				bPbcAppliBaseInfoDAO.deleteByPrimaryKey(appno);
				RBcpAppliBussInfoExample example = new RBcpAppliBussInfoExample();
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample.Criteria c = example.createCriteria();
				c.andAppnoEqualTo(appno);
				rBcpAppliBussInfoDAO.deleteByExample(example);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			log.error("删除业务申请基本信息异常！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001), BPbcErrorConstant.SCF_BAS_PBC_10001);
		}

	}

	/**
	 * 查询用户列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author Qinwei
	 * @date 2017年5月31日 上午10:56:34
	 * @returnType
	 */
	@Override
	public Page queryBCrmBaseInfoByPage(int pageNo, int pageSize, BCrmBaseInfo value) {
		Map<String, Object> param = new HashMap<String, Object>();

		if (StringUtils.isNotEmpty(value.getCname())) {
			param.put("cname", value.getCname());
		}
		if (StringUtils.isNotEmpty(value.getCustcd())) {
			param.put("custcd", value.getCustcd());
		}
		if (StringUtils.isNotEmpty(value.getCreditFlag())) {
			param.put("creditFlag", value.getCreditFlag());
		}

		try {
			Page p = new Page(pageSize, pageNo, 0);
			List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> records = nRBcpPaymentDAO.findBCrmBaseByPage(param, p);
			p.setRecords(records);
			return p;
		} catch (Exception e) {
			log.error("（下拉框）条件分页查询客户信息失败！");
			throw new ScubeBizException("（下拉框）条件分页查询客户信息失败！", e);
		}
	}

	/**
	 * 页面下拉菜单查询保理合同基本信息（根据卖方客户号和业务合同号，业务品种翻译成业务品种名称）
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBcpInfoVO
	 * @return
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年5月31日 上午11:30:41
	 * @returnType
	 */
	@Override
	public Page queryBCntBcpInfoByPage(int pageNo, int pageSize, BCntBcpInfoVO bCntBcpInfoVO) throws ScubeBizException {
		if (bCntBcpInfoVO == null || StringUtils.isEmpty(bCntBcpInfoVO.getCustcd())) {
			throw new ScubeBizException("请先选择卖方客户！");
		}
		Map<String, Object> param = new HashMap<String, Object>();

		if (StringUtils.isNotBlank(bCntBcpInfoVO.getCustcd())) {
			param.put("custcd", bCntBcpInfoVO.getCustcd());
		}
		if (StringUtils.isNotBlank(bCntBcpInfoVO.getMastContno())) {
			param.put("mastContno", bCntBcpInfoVO.getMastContno());
		}
		// contStatus 合同状态
		if (StringUtils.isNotBlank(bCntBcpInfoVO.getContStatus())) {
			param.put("contStatus", bCntBcpInfoVO.getContStatus());
		}
		// financingType 融资模式：1-发票融资;2-池融资
		if (StringUtils.isNotBlank(bCntBcpInfoVO.getFinancingType())) {
			param.put("financingType", bCntBcpInfoVO.getFinancingType());
		}

		List<String> factTypeSet = new ArrayList<String>();

		factTypeSet.add(BCntBizConstant.FACT_TYPE_INLAND);// 国内保理
		factTypeSet.add(BCntBizConstant.FACT_TYPE_REVERSE);// 反向保理
		factTypeSet.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);// 应收账款质押
		factTypeSet.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
		factTypeSet.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
		factTypeSet.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资

		param.put("factTypeSet", factTypeSet);

		Page p = new Page(pageSize, pageNo, 0);

		List<BCntBcpInfo> bCntBcpInfoList = nRBcpPaymentDAO.findBCntBcpInfoByPage(param, p);
		List<BCntBcpInfoVO> responseList = new ArrayList<BCntBcpInfoVO>();
		Iterator<BCntBcpInfo> itr = bCntBcpInfoList.iterator();
		BCntBcpInfo source = null;
		while (itr.hasNext()) {
			source = itr.next();
			BCntBcpInfoVO target = new BCntBcpInfoVO();
			BeanUtils.copyProperties(source, target);
			com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(target.getSupplyChainPdId());
			String businessName = bPrdInfo.getProductName();
			target.setBusinessName(businessName);
			responseList.add(target);
		}

		p.setRecords(responseList);
		return p;

	}

	/**
	 * 分页条件查询应收账款融资交易对手信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBcpExtInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年5月31日 下午5:14:22
	 */
	@Override
	public Page queryBCntDebtExtInfoByPage(int pageNo, int pageSize, BCntBcpExtInfoVO bCntBcpExtInfo) {
		BCntBcpExtInfoExample example = new BCntBcpExtInfoExample();
		Page p = new Page(pageSize, pageNo, 0);
		if (bCntBcpExtInfo != null) {
			com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample.Criteria criteria = example.createCriteria();
			// businessNo 业务合同号
			if (bCntBcpExtInfo.getBusinessNo() != null && bCntBcpExtInfo.getBusinessNo().length() > 0) {
				criteria.andBusinessNoEqualTo(bCntBcpExtInfo.getBusinessNo());
				// id
				if (bCntBcpExtInfo.getId() != null && bCntBcpExtInfo.getId().length() > 0) {
					criteria.andIdEqualTo(bCntBcpExtInfo.getId());
				}
				// 买方客户名称 buyerName
				if (bCntBcpExtInfo.getBusinessName() != null && bCntBcpExtInfo.getBusinessName().length() > 0) {
					criteria.andBusinessNameLike("%" + bCntBcpExtInfo.getBusinessName() + "%");
				}
				try {
					List<BCntBcpExtInfo> selectByPage = iBCntDebtExtInfoDAO.selectByPage(example, p);
					for (BCntBcpExtInfo bCntBcpExtInfo1 : selectByPage) {
						BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
						bCrmBaseInfo.setCustcd(bCntBcpExtInfo1.getBusinessCustcd());
						com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo2 = bCrmBaseInfoDAO
								.selectById(bCntBcpExtInfo1.getBusinessCustcd());
						bCntBcpExtInfo1.setBusinessName(bCrmBaseInfo2.getCname());
					}
					p.setRecords(selectByPage);
					return p;
				} catch (Exception e) {
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30001),
							BCntErrorConstant.SCF_BAS_CNT_30001);
				}

			} else {
				throw new ScubeBizException("请选择业务合同号");
			}
		} else {// 传空值给后台
			throw new ScubeBizException("请选择业务合同号");
		}
	}

	/**
	 * 添加现金回款申请信息
	 * 
	 * @param rBcpAppliBussInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 上午10:27:16
	 * @returnType
	 */
	@Override
	@Transactional
	public String addPaymentApply(RBcpAppliBussInfo rBcpAppliBussInfo) {
		String businessnoType = "";
		String workApplyType = "";
		if (ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(rBcpAppliBussInfo.getFactType())) {// 应收账款
			businessnoType = WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY;
			workApplyType = WorkflowConstant.PROCNAME_CASH_PAYMENT_APPLY;
		} else if (ScfBasConstant.T_FINANCING_TYPE_POOL.equals(rBcpAppliBussInfo.getFactType())) {// 应收账款池
			businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_PAYMENT_APPLY;
			workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_PAYMENT_APPLY;
		}
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(workApplyType);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		String appno = ibSysSerialNoService.genSerialNo("YS_HK_NO");
		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setProcessTemplateName(processName);
		bPbcAppliBaseInfo.setCustcd(rBcpAppliBussInfo.getCustcdSaller());
		bPbcAppliBaseInfo.setAppliType(businessnoType);
		bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
		bPbcAppliBaseInfo.setSupplyChainPdId(rBcpAppliBussInfo.getBussType());// 业务品种
		bPbcAppliBaseInfo.setAppno(appno);
		iBPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		try {
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo record = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
			record.setCustcdBuyer(rBcpAppliBussInfo.getCustcdBuyer());
			record.setCustcdSaller(rBcpAppliBussInfo.getCustcdSaller());
			record.setLoanWay(rBcpAppliBussInfo.getLoanWay());
			record.setMastContno(rBcpAppliBussInfo.getMastContno());
			record.setAppno(appno);// 申请号
			record.setToSallerFlag("1");
			record.setInsertDate(insertDate);// 登记时间
			record.setCrtTime(new Date());// 创建时间
			record.setLastUptTime(new Date());// 最后更新时间
			record.setId(UUIDGeneratorUtil.generate());// id
			record.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);
			record.setTlrcd(tlrcd);// 创建人，操作员
			record.setBrcode(brcode);// 设置经办机构信息
			rBcpAppliBussInfoDAO.insert(record);
			return appno;
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("业务申请基本信息插入异常！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001), BPbcErrorConstant.SCF_BAS_PBC_10001);
		}

	}

	/**
	 * 
	 * @param custcd
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午2:05:21
	 * @returnType
	 */
	@Override
	public BCrmBaseInfo findBCrmBaseInfoByKey(String custcd) {
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfoDal = null;
		if (StringUtils.isNotBlank(custcd)) {
			bCrmBaseInfoDal = nRBcpPaymentDAO.findBCrmBaseInfoByKey(custcd);
		}

		BCrmBaseInfo bCrmBaseInfo = null;
		if (bCrmBaseInfoDal != null) {
			bCrmBaseInfo = new BCrmBaseInfo();
			BeanUtils.copyProperties(bCrmBaseInfoDal, bCrmBaseInfo);
		}
		return bCrmBaseInfo;
	}

	@Resource(name = INRBcpDebtPoolService.BEAN_ID)
	INRBcpDebtPoolService nrbcpdebtpoolservice;

	/**
	 * 
	 * @param rBcpAppliBussInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午1:57:30
	 * @returnType
	 */
	@Override
	public NPaymentBussInfo getInvoicePaymentInfo(RBcpAppliBussInfo rBcpAppliBussInfo) {

		// String mastContno_Q = rBcpAppliBussInfo.getMastContno(); // 内部合同号
		// String custcdBuyer_Q = rBcpAppliBussInfo.getCustcdBuyer(); // 买方客户号
		String appno = rBcpAppliBussInfo.getAppno();
		NPaymentBussInfo debtVO = new NPaymentBussInfo();

		RBcpAppliBussInfo applyVO = nRBcpAppliBussInfoService.findBcpAppliBussInfoByAppno(appno);
		try {
			BeanUtils.copyProperties(applyVO, debtVO);
		} catch (BeansException e) {
			log.error("转换异常", e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000), BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		debtVO.setProductId(applyVO.getBussType());
		debtVO.setRepayPurpose(applyVO.getReason());// 回款用途
		// 尾款金额 = 本次收款金额 – 偿还融资金额
		if (applyVO.getReturnAmount() != null && applyVO.getTotalOverAmount() != null) {
			debtVO.setTotalRepayAmount(applyVO.getReturnAmount().subtract(applyVO.getTotalOverAmount()));
		}
		BCntBcpInfoVO contDebtInfo = bCntBcpInfoService.queryBCntBcpInfoByMastContno(applyVO.getMastContno());

		if (contDebtInfo != null) {
			debtVO.setStartDate(contDebtInfo.getStartDate());
			debtVO.setEndDate(contDebtInfo.getEndDate());

			debtVO.setCurcd(contDebtInfo.getCurcd());
			debtVO.setContAmount(contDebtInfo.getContAmount());
			// debtVO.setBailAccount(contDebtInfo.getBailAcctNo());
			BCrmBaseInfo saller = this.findBCrmBaseInfoByKey(debtVO.getCustcdSaller());
			debtVO.setCnameSeller(saller.getCname());
			BCrmBaseInfo buyer = this.findBCrmBaseInfoByKey(debtVO.getCustcdBuyer());
			debtVO.setCnameBuyer(buyer.getCname());

			com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo = bPrdInfoDAO.selectByPrimaryKey(contDebtInfo.getSupplyChainPdId());
			debtVO.setBussTypeName(bPrdInfo.getProductName());
			debtVO.setRepayPurpose(applyVO.getReason());
			// 添加保理业务类别
			debtVO.setFactType(contDebtInfo.getFactType());
			// 第一次新增初始化
			if (debtVO.getAssignRule() == null) {
				// TODO
				// **********************************************//
				// 尾款规则
				// if(StringUtils.isNotBlank(contDebtInfo.getDueBalanceRule())&&RBcpDebtConstant.DUE_BALANCE_RULE_TO_ACCOUNT.equals(contDebtInfo.getDueBalanceRule())){
				// debtVO.setToSallerFlag("1");
				//
				// }
				// if(StringUtils.isNotBlank(contDebtInfo.getPaymentVerifyRule())){//回款核销规则
				// if(RBcpDebtConstant.PAYMENT_VERIFY_RULE_DUE_FIRST.equals(contDebtInfo.getPaymentVerifyRule())){
				// debtVO.setAssignRule(contDebtInfo.getPaymentVerifyRule());
				// }
				// if(RBcpDebtConstant.PAYMENT_VERIFY_RULE_AVERAGE.equals(contDebtInfo.getPaymentVerifyRule())){
				// debtVO.setAssignRule(contDebtInfo.getPaymentVerifyRule());
				// }
				// }
				// **********************************************//
				debtVO.setTobailAmount(new BigDecimal("0"));
				debtVO.setReturnCapitalAmount(new BigDecimal("0"));
				debtVO.setReturnInterestAmount(new BigDecimal("0"));
				// debtVO.setBailAccount(contDebtInfo.getBailAcctNo());
				String todayDate = ScfDateUtil.formatDate(new Date());
				debtVO.setReturnDate(todayDate);
				// 银承
				if ("02".equals(debtVO.getLoanWay())) {
					debtVO.setRepayPurpose("01");
				} else {
					debtVO.setRepayPurpose("02");
				}
				debtVO.setReturnAccount(contDebtInfo.getReturnAccount());
				debtVO.setAccountNo(contDebtInfo.getAccountNo());
				debtVO.setTobailAmount(new BigDecimal("0"));
			}

			// 应收账款池融资业务 add by huangshuidan 20170120
			String mastContno = applyVO.getMastContno();
			RBcpDebtPool rBcpDebtPool = nrbcpdebtpoolservice.queryInPoolInfoByMastContno(mastContno);

			if (null != rBcpDebtPool) {
				// 设置池应收账款余额
				debtVO.setTotalBillsAmount(rBcpDebtPool.getTotalDebtRemainAmount());
			}
			// 设置池敞口余额
			debtVO.setPoolRiskAmt(nfactfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(applyVO.getMastContno()));// 池敞口余额

		}
		return debtVO;

	}

	/**
	 * 现金回款关联的融资信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param appno
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:42:26
	 * @returnType
	 */
	@Override
	public Page findPoolLoanByPage(int pageNo, int pageSize, String appno) {
		Page p = new Page(pageSize, pageNo, 0);
		// p.setRecords(new ArrayList());
		// RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new
		// RBcpAppliBussDtlExample();
		if (appno != null && !"".equals(appno)) {
			// 还款/回款申请流水信息表
			List<RBcpAppliRepayment> loanList = rBcpAppliRepaymentDAO.selectByRBcpAppliRepaymentByAppno(appno);

			// 保证金及现金等价物业务申请信息表
			List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> billsList = bMrnAppliAcctInfoDAO.selectByAppno(appno);
			List debtIdList = new ArrayList();
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment rBcpAppliRepayment : loanList) {
				if (rBcpAppliRepayment.getDebetId() != null) {
					debtIdList.add(rBcpAppliRepayment.getDebetId());
				}
			}

			for (com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bMrnAppliAcctInfo : billsList) {
				if (bMrnAppliAcctInfo.getDebetNo() != null) {
					com.huateng.scf.bas.lan.dao.model.BLanLnciBase base = bLanLnciBaseDAO.selectByPrimaryKey(bMrnAppliAcctInfo.getDebetNo());
					if (base != null) {
						debtIdList.add(base.getDebetId());
					}
				}
			}
			if (debtIdList != null && debtIdList.size() > 0) {
				// p=bLanLnciBaseService.findBLanLnciBasePageByDebtId(pageNo,
				// pageSize, debtNos);
				BLanLnciBaseExample example = new BLanLnciBaseExample();
				com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample.Criteria critr = example.createCriteria();
				critr.andDebetIdIn(debtIdList);
				List<BLanLnciBase> lnciRecords = bLanLnciBaseDAO.selectByPage(example, p);
				p.setRecords(lnciRecords);
			}
			List payMentLanInfos = new ArrayList();
			List<BLanLnciBase> records = p.getRecords();
			if (records != null && records.size() > 0) {
				try {
					for (BLanLnciBase lanLnciBase : records) {

						PayMentLanInfo payMentLanInfo = new PayMentLanInfo();

						BeanUtils.copyProperties(lanLnciBase, payMentLanInfo);
						if (payMentLanInfo.getLnciType() != null) {
							if (ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(payMentLanInfo.getLnciType())) { // 出账方式
								payMentLanInfo.setRepayIntamt(new BigDecimal("0"));
								payMentLanInfo.setRepayBalamt(new BigDecimal("0"));
							} else if (ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(payMentLanInfo.getLnciType())) {
								if (payMentLanInfo.getBailAmount() == null) {
									payMentLanInfo.setBailAmount(new BigDecimal("0"));
								}
								if (payMentLanInfo.getAddBailAmount() == null) {
									payMentLanInfo.setBailAmount(payMentLanInfo.getBailAmount().add(payMentLanInfo.getAddBailAmount()));
									payMentLanInfo.setAddBailAmount(new BigDecimal("0"));
								}
								payMentLanInfo.setRepayIntamt(null);
								payMentLanInfo.setRepayBalamt(null);
							}
							if (payMentLanInfo.getLnciBal() == null) {
								payMentLanInfo.setLnciBal(new BigDecimal("0"));
							}
							if (payMentLanInfo.getBailAmount() == null) {
								payMentLanInfo.setBailAmount(new BigDecimal("0"));
							}
							if (payMentLanInfo.getAddBailAmount() == null) {
								payMentLanInfo.setAddBailAmount(new BigDecimal("0"));
							}
							if (payMentLanInfo.getInitCashEqtAmt() == null) {
								payMentLanInfo.setInitCashEqtAmt(new BigDecimal("0"));
							}
							if (payMentLanInfo.getAddCashEqtAmt() == null) {
								payMentLanInfo.setAddCashEqtAmt(new BigDecimal("0"));
							}
							payMentLanInfo.setAvaliableRiskAmt(
									payMentLanInfo.getLnciBal().subtract(payMentLanInfo.getBailAmount()).subtract(payMentLanInfo.getAddBailAmount())
											.subtract(payMentLanInfo.getInitCashEqtAmt().subtract(payMentLanInfo.getAddCashEqtAmt())));// 敞口余额
							payMentLanInfo.setPayAmount(new BigDecimal("0"));
							payMentLanInfo.setRepayAmount(new BigDecimal("0"));
							payMentLanInfo.setAmountOver(new BigDecimal("0"));
							BigDecimal receInt = payMentLanInfo.getReceivableInt() != null ? payMentLanInfo.getReceivableInt() : new BigDecimal(0);
							BigDecimal recePunInt = payMentLanInfo.getReceivablePunishInt() != null ? payMentLanInfo.getReceivablePunishInt()
									: new BigDecimal(0);
							payMentLanInfo.setInTableInt(receInt.add(recePunInt));// 表内欠息
																					// =
																					// 应收欠息
																					// +
																					// 应收罚息

						}

						RBcpAppliRepaymentExample example = new RBcpAppliRepaymentExample();
						com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria c = example.createCriteria();
						c.andAppnoEqualTo(appno);
						c.andDebetIdEqualTo(payMentLanInfo.getDebetId());
						List<RBcpAppliRepayment> rbcpAppliRepaymentList = rBcpAppliRepaymentDAO.selectByExample(example);
						if (rbcpAppliRepaymentList != null && rbcpAppliRepaymentList.size() > 0) {
							payMentLanInfo.setRepayAmount(rbcpAppliRepaymentList.get(0).getRepayAmount());// 还款金额
							payMentLanInfo.setPayAmount(rbcpAppliRepaymentList.get(0).getPayAmount());// 入账金额
							payMentLanInfo.setAmountOver(rbcpAppliRepaymentList.get(0).getAmountOver());// 尾款金额
							payMentLanInfo.setRepayIntamt(rbcpAppliRepaymentList.get(0).getRepayIntamt());// 实际还息金额
							payMentLanInfo.setRepayBalamt(rbcpAppliRepaymentList.get(0).getRepayBalamt());// 实际还本金额
							payMentLanInfo.setBailAccount(rbcpAppliRepaymentList.get(0).getAccountNo());// 保证金账号
						}

						BMrnAppliAcctInfoExample Mrnexample = new BMrnAppliAcctInfoExample();
						com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample.Criteria Mrnc = Mrnexample.createCriteria();
						Mrnc.andAppnoEqualTo(appno);
						Mrnc.andDebetNoEqualTo(payMentLanInfo.getDebetNo());
						List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> Mrnlist = bMrnAppliAcctInfoDAO.selectByExample(Mrnexample);
						if (Mrnlist != null && Mrnlist.size() > 0) {
							com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo payBillsInfo = Mrnlist.get(0);
							if (payBillsInfo != null) {
								payMentLanInfo.setRepayAmount(payBillsInfo.getAmount());// 还款金额
								payMentLanInfo.setAddBailAmount(payBillsInfo.getAmount());// 还款金额
								payMentLanInfo.setPayAmount(payBillsInfo.getPayAmount());// 入账金额
								payMentLanInfo.setAmountOver(payBillsInfo.getPayAmount().subtract(payBillsInfo.getAmount()));// 尾款金额
								payMentLanInfo.setBailAccount(payBillsInfo.getBailAccountno());// 保证金账户
							}

						}

						payMentLanInfos.add(payMentLanInfo);

					}

				} catch (BeansException e) {
					log.warn("转换异常", e);
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),
							BSysErrorConstant.SCF_BAS_DCR_50000);
				}
			}

			p.setRecords(payMentLanInfos);
			p.setTotalPage(payMentLanInfos.size());

		}

		return p;
	}

	/**
	 * 更新业务申请基本信息表
	 * 
	 * @param paymentBussInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:31:42
	 */
	@Override
	@Transactional
	public String updatePaymentApply(NPaymentBussInfo paymentBussInfo) {
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo daoRBcpAppliBussInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();

		try {
			BeanUtils.copyProperties(paymentBussInfo, daoRBcpAppliBussInfo);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000), BSysErrorConstant.SCF_BAS_DCR_50000);
		}

		try {
			daoRBcpAppliBussInfo.setReason(paymentBussInfo.getRepayPurpose());
			daoRBcpAppliBussInfo.setLastUptTime(new Date());// 最后更新时间
			rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(daoRBcpAppliBussInfo);
			return daoRBcpAppliBussInfo.getAppno();
		} catch (Exception e) {
			log.error("业务申请基本信息插入异常！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001), BPbcErrorConstant.SCF_BAS_PBC_10001);
		}

	}

	/**
	 * 
	 * @param rBcpAppliBussDtl
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:50:31
	 */
	@Override
	@Transactional
	public void updateRBcpAppliBussDtl(RBcpAppliBussDtl rBcpAppliBussDtl) {

		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl daoRBcpAppliBussDt = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
		daoRBcpAppliBussDt.setId(rBcpAppliBussDtl.getId());
		daoRBcpAppliBussDt.setRemoveAmount(rBcpAppliBussDtl.getRemoveAmount());
		daoRBcpAppliBussDt.setPayAmount(rBcpAppliBussDtl.getPayAmount());
		try {
			BigDecimal totalpayA = BigDecimal.ZERO;
			rBcpAppliBussDtlDAO.updateByPrimaryKeySelective(daoRBcpAppliBussDt);
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample.Criteria crt = rBcpAppliBussDtlExample.createCriteria();
			crt.andAppnoEqualTo(rBcpAppliBussDtl.getAppno());
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> dtlList = rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rdtl : dtlList) {
				BigDecimal payA = (rdtl.getPayAmount() == null ? BigDecimal.ZERO : rdtl.getPayAmount());
				totalpayA = totalpayA.add(payA);
			}

			String appno = rBcpAppliBussDtl.getAppno();
			PayMentLanInfo payMentLanInfo = new PayMentLanInfo();
			payMentLanInfo.setAppno(appno);
			payMentLanInfo.setDebetId(rBcpAppliBussDtl.getDebetNo());
			payMentLanInfo.setRepayAmount(totalpayA);
			this.updatePayMentLanInfo(appno, payMentLanInfo);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("更新异常！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001), BPbcErrorConstant.SCF_BAS_PBC_10001);
		}
	}

	/**
	 * 保存或更新还款申请信息
	 * 
	 * @param appno
	 * @param payMentLanInfo
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:57:58
	 */
	@Override
	@Transactional
	public void updatePayMentLanInfo(String appno, PayMentLanInfo payMentLanInfo) throws ScubeBizException {
		RBcpAppliRepaymentExample example = new RBcpAppliRepaymentExample();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria c = example.createCriteria();
		if (StringUtil.isStrNotEmpty(appno)) {
			c.andAppnoEqualTo(appno);
		}
		if (StringUtil.isStrNotEmpty(payMentLanInfo.getDebetId())) {
			c.andDebetIdEqualTo(payMentLanInfo.getDebetId());
		}

		List<RBcpAppliRepayment> rbcpList = rBcpAppliRepaymentDAO.selectByExample(example);
		if (rbcpList == null || rbcpList.size() == 0) {
			RBcpAppliRepayment record = new RBcpAppliRepayment();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
			String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
			String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
			record.setId(UUIDGeneratorUtil.generate());
			record.setAppno(appno);
			record.setDebetNo(payMentLanInfo.getDebetNo());// 借据表主键--供应链借据号
			record.setDebetId(payMentLanInfo.getDebetId());// 信贷正式借据编号
			record.setTlrcd(tlrcd);
			record.setBrcode(brcode);
			record.setRepayDate(insertDate);
			record.setCurcd(payMentLanInfo.getCurcd());// 币别 默认人民币
			record.setRepayAmount(payMentLanInfo.getRepayAmount());// 还款金额
			record.setPayAmount(payMentLanInfo.getRepayAmount());// 入账金额
			record.setAmountOver(payMentLanInfo.getAmountOver());// 尾款金额
			record.setRepayIntamt(payMentLanInfo.getRepayIntamt());// 实际还息金额
			record.setRepayBalamt(payMentLanInfo.getRepayBalamt());// 实际还本金额
			record.setAccountNo(payMentLanInfo.getBailAccount());// 保证金账号
			rBcpAppliRepaymentDAO.insert(record);
		} else {
			rbcpList.get(0).setRepayAmount(payMentLanInfo.getRepayAmount());
			rbcpList.get(0).setAccountNo(payMentLanInfo.getBailAccount());// 保证金账号
			rBcpAppliRepaymentDAO.updateByPrimaryKeySelective(rbcpList.get(0));
		}
		// 更新申请流水的尾款金额
		this.countTotalOverAmount(appno);
	}

	/**
	 * 根据回款申请的还款金额，更新申请流水的尾款金额
	 * 
	 * @param appno
	 * @author Qinwei
	 * @date 2017年6月2日 上午11:14:54
	 */
	@Transactional
	public void countTotalOverAmount(String appno) {
		RBcpAppliBussInfoExample example1 = new RBcpAppliBussInfoExample();
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample.Criteria c1 = example1.createCriteria();
		c1.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> appliBussInfoList = rBcpAppliBussInfoDAO.selectByExample(example1);
		// 尾款金额
		BigDecimal totalOverAmount = appliBussInfoList.get(0).getTotalOverAmount();
		// 本次入账总额 returnAmount
		BigDecimal returnAmount = appliBussInfoList.get(0).getReturnAmount();
		if (returnAmount != null) {
			BigDecimal totalRepayAmount = new BigDecimal("0");
			RBcpAppliRepaymentExample rexample = new RBcpAppliRepaymentExample();
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria rc = rexample.createCriteria();
			rc.andAppnoEqualTo(appno);
			List<RBcpAppliRepayment> rbcpAppliRepaymentList = rBcpAppliRepaymentDAO.selectByExample(rexample);
			if (rbcpAppliRepaymentList != null && rbcpAppliRepaymentList.size() > 0) {
				for (RBcpAppliRepayment rbcpAppliRepayment : rbcpAppliRepaymentList) {
					totalRepayAmount = totalRepayAmount.add(rbcpAppliRepayment.getRepayAmount());

				}
			}
			appliBussInfoList.get(0).setTotalOverAmount(returnAmount.subtract(totalRepayAmount));
			rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(appliBussInfoList.get(0));
		}

	}

	/**
	 * 根据规则，重新分配申请流水的入账金额和付款金额
	 * 
	 * @param paymentBussInfo
	 * @author Qinwei
	 * @date 2017年6月1日 下午8:10:37
	 * @returnType
	 */
	@Override
	@Transactional
	public void assignAmount(NPaymentBussInfo paymentBussInfo) {
		// 回款核销规则
		String assignRule = paymentBussInfo.getAssignRule();
		// 本次入账总额
		BigDecimal returnAmount = paymentBussInfo.getReturnAmount();
		if (assignRule != null && returnAmount != null) {
			RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
			rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample.Criteria crt = rBcpAppliBussDtlExample.createCriteria();
			crt.andAppnoEqualTo(paymentBussInfo.getAppno());
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> dtlList = rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
			// 初始化为0

			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rbcpAppliBussDtl : dtlList) {

				RBcpAppliBussDtl newRBcpAppliBussDtl = new RBcpAppliBussDtl();
				BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);
				newRBcpAppliBussDtl.setPayAmount(BigDecimal.ZERO);
				newRBcpAppliBussDtl.setRemoveAmount(BigDecimal.ZERO);
				this.updateRBcpAppliBussDtl(newRBcpAppliBussDtl);

			}

			// 按到期日
			if (RBcpDebtConstant.PAYMENT_VERIFY_RULE_DUE_FIRST.equals(assignRule)) {

				for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rbcpAppliBussDtl : dtlList) {

					BigDecimal remainingAmount = rbcpAppliBussDtl.getRemainingAmount();
					int comp = remainingAmount.compareTo(returnAmount);
					if (comp >= 0) {
						RBcpAppliBussDtl newRBcpAppliBussDtl = new RBcpAppliBussDtl();
						BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);
						newRBcpAppliBussDtl.setPayAmount(returnAmount);
						newRBcpAppliBussDtl.setRemoveAmount(returnAmount);
						this.updateRBcpAppliBussDtl(newRBcpAppliBussDtl);
						break;

					} else {

						RBcpAppliBussDtl newRBcpAppliBussDtl = new RBcpAppliBussDtl();
						BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);
						newRBcpAppliBussDtl.setPayAmount(remainingAmount);
						newRBcpAppliBussDtl.setRemoveAmount(remainingAmount);
						this.updateRBcpAppliBussDtl(newRBcpAppliBussDtl);
						returnAmount = returnAmount.subtract(remainingAmount);
					}
				}

			}
			// 按平均分配
			else if (RBcpDebtConstant.PAYMENT_VERIFY_RULE_AVERAGE.equals(assignRule)) {
				int num = dtlList.size();
				if (num > 0) {
					for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rbcpAppliBussDtl : dtlList) {
						RBcpAppliBussDtl newRBcpAppliBussDtl = new RBcpAppliBussDtl();
						BeanUtils.copyProperties(rbcpAppliBussDtl, newRBcpAppliBussDtl);
						newRBcpAppliBussDtl.setPayAmount(returnAmount.divide(BigDecimal.valueOf(num)));
						newRBcpAppliBussDtl.setRemoveAmount(returnAmount.divide(BigDecimal.valueOf(num)));
						this.updateRBcpAppliBussDtl(newRBcpAppliBussDtl);

					}
				}

			}

		}

	}

	/**
	 * 删除还款申请信息
	 * 
	 * @param rBcpAppliBussDtl
	 * @author Qinwei
	 * @date 2017年6月2日 上午11:13:32
	 */
	@Override
	@Transactional
	public void deleteRBcpAppliBussDtl(RBcpAppliBussDtl rBcpAppliBussDtl) {

		try {
			rBcpAppliBussDtlDAO.deleteByPrimaryKey(rBcpAppliBussDtl.getId());

			RBcpAppliRepaymentExample example = new RBcpAppliRepaymentExample();
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample.Criteria c = example.createCriteria();
			if (StringUtil.isStrNotEmpty(rBcpAppliBussDtl.getAppno())) {
				c.andAppnoEqualTo(rBcpAppliBussDtl.getAppno());
			}
			if (StringUtil.isStrNotEmpty(rBcpAppliBussDtl.getDebetNo())) {
				c.andDebetIdEqualTo(rBcpAppliBussDtl.getDebetNo());
			}
			rBcpAppliRepaymentDAO.deleteByExample(example);
			this.countTotalOverAmount(rBcpAppliBussDtl.getAppno());
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("删除异常！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001), BPbcErrorConstant.SCF_BAS_PBC_10001);
		}
	}

	/**
	 * 新增业务申请流水明细
	 * 
	 * @param appno
	 * @param rBcpAppliBussDtl
	 * @author Qinwei
	 * @date 2017年6月2日 上午11:21:56
	 */
	@Override
	@Transactional
	public void addRBcpAppliBussDtl(String appno, RBcpAppliBussDtl rBcpAppliBussDtl) {
		rBcpAppliBussDtl.setDebtId(rBcpAppliBussDtl.getId());
		rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
		rBcpAppliBussDtl.setAppno(appno);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期

		rBcpAppliBussDtl.setInsertDate(insertDate);
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl daoRBcpAppliBussDt = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
		try {
			BeanUtils.copyProperties(rBcpAppliBussDtl, daoRBcpAppliBussDt);
		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000), BSysErrorConstant.SCF_BAS_DCR_50000);
		}
		try {
			daoRBcpAppliBussDt.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);
			daoRBcpAppliBussDt.setPayAmount(new BigDecimal(0));
			rBcpAppliBussDtlDAO.insert(daoRBcpAppliBussDt);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("业务申请基本信息插入异常！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10001), BPbcErrorConstant.SCF_BAS_PBC_10001);
		}
	}

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtBaseInfo
	 * @param list
	 * @return
	 * @author Qinwei
	 * @date 2017年6月2日 下午2:11:52
	 */
	@Override
	public Page findCancelRBcpDebtBaseInfoPageByPage(int pageNo, int pageSize, RBcpDebtInfoVO rBcpDebtInfoVO, List<RBcpDebtInfoVO> list)
			throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<String> arrayList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (RBcpDebtInfoVO rBcpDebtBaseInfo1 : list) {
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
			map.put("billsNoList", arrayList);
		}

		if (null != rBcpDebtInfoVO) {
			String lockAppno = rBcpDebtInfoVO.getLockAppno();
			String mastContno = rBcpDebtInfoVO.getMastContno();
			String custcdBuyer = rBcpDebtInfoVO.getCustcdBuyer();
			String custcdSaller = rBcpDebtInfoVO.getCustcdSaller();

			String billsDateFrom = rBcpDebtInfoVO.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtInfoVO.getBillsDateTo();
			String debtEndFrom = rBcpDebtInfoVO.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtInfoVO.getDebtEndTo();

			String billsNo = rBcpDebtInfoVO.getBillsNo(); // 凭证编号
			String billsType = rBcpDebtInfoVO.getBillsType(); // 凭证类型
			String factType = rBcpDebtInfoVO.getFactType();
			map.put("lockAppno", lockAppno);
			map.put("mastContno", mastContno);
			map.put("custcdBuyer", custcdBuyer);
			map.put("custcdSaller", custcdSaller);

			map.put("billsDateFrom", billsDateFrom);
			map.put("billsDateTo", billsDateTo);
			map.put("debtEndFrom", debtEndFrom);
			map.put("debtEndTo", debtEndTo);

			map.put("factType", factType);
			map.put("billsNo", billsNo);
			map.put("billsType", billsType);
		}

		try {
			@SuppressWarnings("unchecked")
			List<RBcpDebtInfo> rBcpDebtInfoList = nRBcpPaymentDAO.findCancelRBcpDebtBaseInfoByPage(map, p);
			// 之前已经回款过的单据会保存有对应的回款金额以及核销金额字段，这里都需要清零。
			if (rBcpDebtInfoList != null && rBcpDebtInfoList.size() > 0) {
				for (RBcpDebtInfo rBcpDebtInfo : rBcpDebtInfoList) {
					rBcpDebtInfo.setRemoveAmount(BigDecimal.ZERO);
					rBcpDebtInfo.setPayAmount(BigDecimal.ZERO);
				}
				p.setRecords(rBcpDebtInfoList);
			}
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			log.error("条件分页查询条件分页查询应收账款信息失败！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009), RBcpErrorConstant.SCF_REC_BCP_10009);
		}
		return p;
	}

	@Override
	public Page findCancelRBcpDebtBaseInfoPageByPage2(int pageNo, int pageSize, RBcpDebtInfoVO rBcpDebtInfoVO, List<RBcpDebtInfoVO> list)
			throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<String> arrayList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (RBcpDebtInfoVO rBcpDebtBaseInfo1 : list) {
				arrayList.add("'" + rBcpDebtBaseInfo1.getBillsNo() + "'");
			}
			map.put("billsNoList", arrayList);
		}

		if (null != rBcpDebtInfoVO) {
			String lockAppno = rBcpDebtInfoVO.getLockAppno();
			String mastContno = rBcpDebtInfoVO.getMastContno();
			String custcdBuyer = rBcpDebtInfoVO.getCustcdBuyer();
			String custcdSaller = rBcpDebtInfoVO.getCustcdSaller();

			String billsDateFrom = rBcpDebtInfoVO.getBillsDateFrom();// 应收账款日期
			String billsDateTo = rBcpDebtInfoVO.getBillsDateTo();
			String debtEndFrom = rBcpDebtInfoVO.getDebtEndFrom();// 到期日
			String debtEndTo = rBcpDebtInfoVO.getDebtEndTo();

			String billsNo = rBcpDebtInfoVO.getBillsNo(); // 凭证编号
			String billsType = rBcpDebtInfoVO.getBillsType(); // 凭证类型
			String factType = rBcpDebtInfoVO.getFactType();// 单笔还是池的
			map.put("lockAppno", lockAppno);
			map.put("mastContno", mastContno);
			map.put("custcdBuyer", custcdBuyer);
			map.put("custcdSaller", custcdSaller);

			map.put("billsDateFrom", billsDateFrom);
			map.put("billsDateTo", billsDateTo);
			map.put("debtEndFrom", debtEndFrom);
			map.put("debtEndTo", debtEndTo);

			map.put("factType", factType);
			map.put("billsNo", billsNo);
			map.put("billsType", billsType);
		}

		try {
			nRBcpPaymentDAO.findCancelRBcpDebtBaseInfoByPage2(map, p);
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			log.error("条件分页查询条件分页查询应收账款信息失败！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009), RBcpErrorConstant.SCF_REC_BCP_10009);
		}
		return p;
	}

	/**
	 * 应收账款池融资 融资信息保存
	 * 
	 * @param debtBussInfoVO
	 * @param lnciList
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月2日 下午4:40:03
	 * @returnType
	 */
	@Transactional
	@Override
	public void addLoanInfoDtl(DebtBussInfoVO debtBussInfoVO, List<DebtLnciBaseInfoVO> lnciList) throws ScubeBizException {
		if (StringUtil.isStrNotEmpty(debtBussInfoVO.getRepayPurpose())
				&& !RBcpDebtConstant.RETURN_USAGE_IN_BAILAMOUNT.equals(debtBussInfoVO.getRepayPurpose())) {

			// 清空保证金表对应数据
			bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(debtBussInfoVO.getAppno());

			this.saveTblAppliRepaymentInfo(lnciList, debtBussInfoVO);// 保存还贷款、尾款信息
		}
		if (StringUtil.isStrNotEmpty(debtBussInfoVO.getRepayPurpose())
				&& RBcpDebtConstant.RETURN_USAGE_IN_BAILAMOUNT.equals(debtBussInfoVO.getRepayPurpose())) {

			// 清空还款表对应数据
			rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(debtBussInfoVO.getAppno());

			this.saveTblAppliCustAccountInfo(lnciList, debtBussInfoVO);// 保存入保证金还款信息
		}

	}

	/**
	 * 现金回款 -- 保存还款信息
	 * 
	 * @param lnciPayList
	 * @param paymentInfo
	 * @throws ScubeBizException
	 */
	@Transactional
	public void saveTblAppliRepaymentInfo(List lnciPayList, DebtBussInfoVO paymentInfo) throws ScubeBizException {

		// 清空保证金表对应数据
		// bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(paymentInfo.getAppno());

		RBcpAppliRepayment record = null;
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		// 保存前先清掉APPNO查询到记录
		rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(paymentInfo.getAppno());
		DebtLnciBaseInfoVO debtVO = null;
		for (int i = 0; i < lnciPayList.size(); i++) {
			record = new RBcpAppliRepayment();
			debtVO = (DebtLnciBaseInfoVO) lnciPayList.get(i);
			if (ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(debtVO.getLnciType())) {// 融资方式是
																						// 流动资金贷款
				record.setId(UUIDGeneratorUtil.generate());
				record.setAppno(paymentInfo.getAppno());
				record.setDebetNo(debtVO.getDebetNo());// 借据表主键
				record.setDebetId(debtVO.getDebetId());
				if (RBcpDebtConstant.RETURN_METHOD_BUYER_PAYMENT.equals(paymentInfo.getReturnMethod())) {
					record.setCustcd(paymentInfo.getCustcdBuyer());// 客户内部号
				} else {
					record.setCustcd(paymentInfo.getCustcdSaller());// 客户内部号
				}
				record.setTlrcd(tlrcd);
				record.setBrcode(brcode);
				record.setRepayDate(BSysConstant.WORKDATE);
				record.setCurcd(debtVO.getCurcd());// 币别 默认人民币
				record.setReturnMethod(paymentInfo.getReturnMethod());// 还款类型
				record.setRepayAmount(debtVO.getRepayAmount());// 还款金额
				record.setMastContno(paymentInfo.getMastContno());// 主合同号
				record.setPayAmount(debtVO.getRepayAmount());// 入账金额
				record.setAmountOver(debtVO.getAmountOver());// 尾款金额
				record.setRepayIntamt(debtVO.getRepayIntamt());// 实际还息金额
				record.setRepayBalamt(debtVO.getRepayBalamt());// 实际还本金额
				record.setAccountNo(debtVO.getBailAccount());// 保证金账号
				record.setReturnType(paymentInfo.getReturnType());// 还款方式
				rBcpAppliRepaymentDAO.insert(record);
			}
		}
	}

	/**
	 * 现金回款 -- 保存还款信息
	 * 
	 * @param lnciPayList
	 * @param paymentInfo
	 * @throws ScubeBizException
	 */
	public void saveTblAppliCustAccountInfo(List lnciPayList, DebtBussInfoVO paymentInfo) throws ScubeBizException {
		// 清空还款表对应数据
		// rbcpapplirepaymentservice.clearTblAppliRepaymentInfo(paymentInfo.getAppno());

		BMrnAppliAcctInfo record = null;
		// 保存前先清掉APPNO查询到记录
		bMrnAppliAcctInfoService.clearTblAppliCustAccountInfo(paymentInfo.getAppno());
		DebtLnciBaseInfoVO debtVO = null;
		for (int i = 0; i < lnciPayList.size(); i++) {
			record = new BMrnAppliAcctInfo();
			debtVO = (DebtLnciBaseInfoVO) lnciPayList.get(i);
			record.setId(UUIDGeneratorUtil.generate());
			record.setAppno(paymentInfo.getAppno());
			record.setDebetNo(debtVO.getDebetNo());// 借据表主键
			if (RBcpDebtConstant.RETURN_METHOD_BUYER_PAYMENT.equals(paymentInfo.getReturnMethod())) {
				record.setCustcd(paymentInfo.getCustcdBuyer());// 客户内部号
			} else {
				record.setCustcd(paymentInfo.getCustcdSaller());// 客户内部号
			}
			// record.setBrcode(brcode);
			record.setCurcd(debtVO.getCurcd());// 币别 默认人民币
			record.setMastContno(paymentInfo.getMastContno());// 主合同号
			record.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);// 保证金等价物类型：
																// 03-保证金
			record.setInitType(ScfBasConstant.INIT_TYPE_ADD);// 保证金初始化类型： 02-追加
			record.setBailRate(debtVO.getBailPercent());// 保证金比例
			record.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);// 保证金及现金等价物确认状态：01-已确认
			record.setBailAccountno(debtVO.getBailAccount());// 保证金账号
			record.setAmount(debtVO.getRepayAmount());// 还款金额
			record.setPayAmount(debtVO.getRepayAmount());// 还款金额
			record.setBailAmount(debtVO.getRepayAmount());// 保证金金额
			bMrnAppliAcctInfoService.add(record);
		}
	}

	@Override
	public BCrmBrInfo findBCrmBrInfo(BCrmBrInfo bCrmBrInfo) {
		BCrmBrInfo bCrmBrInfo2 = new BCrmBrInfo();
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		bCrmBrInfo2.setBrNo(BctlVO.getBrNo());
		bCrmBrInfo2.setBrName(BctlVO.getBrName());
		bCrmBrInfo2.setBrManagerNo(BctlVO.getBrManagerNo());
		bCrmBrInfo2.setBrManagerName(BctlVO.getBrManagerName());
		bCrmBrInfo2.setTxnDate(ScfBaseData.getScfGlobalInfoData().getTxnDate());
		bCrmBrInfo2.setSysDate(ScfBaseData.getScfGlobalInfoData().getSysDate());
		return bCrmBrInfo2;
	}

	// ****************************************************************************//
	// ****************************************************************************//

	/**
	 * 首页提交按钮
	 * 
	 * @param key
	 * @author Qinwei
	 * @date 2017年6月2日 下午3:10:57
	 * @returnType
	 */
	@Override
	@Transactional
	public void submitCashPaymentInfo(String appno) {
		// 1.数据校验
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		RBcpAppliBussInfo rBcpAppliBussInfo = nRBcpAppliBussInfoService.findBcpAppliBussInfoByAppno(appno);
		if (rBcpAppliBussInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		List<RBcpAppliBussDtl> rBcpAppliBussDtlList = nRBcpAppliBussDtlService.queryRBcpAppliBussDtlByAppno(appno);
		if (rBcpAppliBussDtlList == null || rBcpAppliBussDtlList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		// 判断是否已发起流程为退回提交

		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 3.如果为空发起流程，修改状态
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 3.1发起流程
			String workApplyType = bPbcAppliBaseInfo1.getProcessTemplateName();// 流程名称
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), workApplyType, paramMap);
			} catch (FlowsharpException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
			// 3.2修改通知书状态
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 申请状态为//已提交
			bPbcAppliBaseInfo1.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 申请状态明细
			try {
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040),
						RBcpErrorConstant.SCF_REC_BCP_10040);
			}
		} else {
			try {
				scfWorkFlowService.backSubmitCommon(bPbcAppliBaseInfo1);
			} catch (ScubeBizException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			} catch (FlowsharpException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			}
		}
	}

	/*
	 * 首页提交按钮
	 */
	@Override
	@Transactional
	public void submitCashPaymentInfoApply(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		RBcpAppliBussInfo rBcpAppliBussInfo = nRBcpAppliBussInfoService.findBcpAppliBussInfoByAppno(appno);
		if (rBcpAppliBussInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		// 2.申请基本信息修改状态为已提交

		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 申请状态为//已提交
		bPbcAppliBaseInfo1.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 申请状态明细
		try {
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
		} catch (Exception e) {// 修改应收账款申请转让信息，修改申请基本信息的转让总金额失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 3.发起流程
		String workApplyType = "";
		BCntBcpInfo bcntBcpInfo = bcntBcpInfoDAO.selectByPrimaryKey(rBcpAppliBussInfo.getMastContno());

		if ("8".equals(bcntBcpInfo.getFactType())) {
			workApplyType = "N-FactoringPoolPaymentApply";
		} else if ("1".equals(bcntBcpInfo.getFactType())) {
			workApplyType = "N-CashPaymentApply";
		}
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("modelId", workApplyType);
		paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
		paramMap.put("", WorkflowConstant.PROCNODE_APPLY);
		paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
		try {
			scfWorkFlowService.commonStartFlow(rBcpAppliBussInfo.getAppno(), workApplyType, workApplyType, paramMap);
		} catch (FlowsharpException e) {
			log.debug(e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022), RBcpErrorConstant.SCF_REC_BCP_10022);
		}
	}

	@Transactional
	public void BussDtlForPass(String appNo, BigDecimal repayAmount) {

		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		rBcpAppliBussDtlExample.setOrderByClause("DEBT_END  ASC");
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample.Criteria c = rBcpAppliBussDtlExample.createCriteria();
		c.andAppnoEqualTo(appNo);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> dtlList = rBcpAppliBussDtlDAO.selectByExample(rBcpAppliBussDtlExample);
		if (dtlList == null || dtlList.size() == 0) {
			throw new ScubeBizException("回款申请明细信息丢失！");
		}
		String mastContno = dtlList.get(0).getMastContno();// 业务合同号
		// 业务合同信息
		BCntBcpInfo bCntBcpInfo = bcntbcpinfodao.selectByPrimaryKey(mastContno);

		// 1.单据金额计算以及解锁
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rdtl : dtlList) {
			RBcpDebtInfo debtBaseInfo = new RBcpDebtInfo();
			rdtl.setLoanWay(bCntBcpInfo.getExt1());// 出账方式
			debtBaseInfo = rBcpDebtInfoDAO.selectByPrimaryKey(rdtl.getDebtId());
			// 本次入账实际金额计算
			BigDecimal payAmount = debtBaseInfo.getPayAmount() == null ? new BigDecimal("0") : debtBaseInfo.getPayAmount();
			BigDecimal removeAmount2 = debtBaseInfo.getRemoveAmount() == null ? new BigDecimal("0") : debtBaseInfo.getRemoveAmount();
			debtBaseInfo.setPayAmount(payAmount.add(rdtl.getPayAmount()));// 累加本次实际回款金额
			BigDecimal remainingAmount = debtBaseInfo.getRemainingAmount() == null ? new BigDecimal("0") : debtBaseInfo.getRemainingAmount();// 更新前发票余额
			// 核销金额计算
			BigDecimal removeAmount = rdtl.getRemoveAmount() == null ? new BigDecimal("0") : rdtl.getRemoveAmount();
			debtBaseInfo.setRemoveAmount(removeAmount2.add(removeAmount));// 累加本次核销金额
			debtBaseInfo.setRemainingAmount(remainingAmount.subtract(removeAmount));// 发票余额
			rdtl.setRemainingAmount(remainingAmount.subtract(removeAmount));// 设置核销应收账款余额
			rBcpAppliBussDtlDAO.updateByPrimaryKeySelective(rdtl);

			BigDecimal loanPercent = debtBaseInfo.getLoanPercent() == null ? new BigDecimal("0") : debtBaseInfo.getLoanPercent();
			debtBaseInfo.setRemainingUseableAmount(
					debtBaseInfo.getRemainingAmount().multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));

			if (debtBaseInfo.getRemainingAmount().compareTo(new BigDecimal(0.00)) == 0) {// 发票余额为0则吧发票状态至为03核销
				debtBaseInfo.setStatus(ScfBasConstant.BILLS_STATUS_PAYOFF);// 已核销
				//如果是入池状态的单据自动出池
				if(debtBaseInfo.getPoolFlag() != null && debtBaseInfo.getPoolFlag().equals("1")){
					debtBaseInfo.setPoolFlag("0");//自动出池
				}
			}
			if (rdtl.getLoanRemainingAmount() != null) {
				debtBaseInfo.setLoanRemainingAmount(rdtl.getLoanRemainingAmount());// 融资余额
			}
			debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			debtBaseInfo.setLockAppno("");
			rBcpDebtInfoDAO.updateByPrimaryKeySelective(debtBaseInfo);

			com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl record = new com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl();

			try {
				BeanUtils.copyProperties(rdtl, record);
			} catch (BeansException e) {
				log.warn("转换异常", e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),
						BSysErrorConstant.SCF_BAS_DCR_50000);
			}

			record.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);
			nRBcpDebtBussDtlService.addRBcpDebtBussDtl(record);
			// 如果单据处于核销状态，则需要再添加一笔核销的历程信息
			if (debtBaseInfo.getStatus().equals(ScfBasConstant.BILLS_STATUS_PAYOFF)) {
				record.setApplyType(RBcpDebtConstant.APPLY_TYPE_VERIFY);
				record.setMoney(record.getRemoveAmount());// 核销
				nRBcpDebtBussDtlService.addRBcpDebtBussDtl(record);
				if(debtBaseInfo.getPoolFlag() != null && debtBaseInfo.getPoolFlag().equals("0")){
					//新增对应出池明细信息
					record.setApplyType(RBcpDebtConstant.APPLY_TYPE_OUT_POOL);//出池
					nRBcpDebtBussDtlService.addRBcpDebtBussDtl(record);
				}
			}
		}
		
		// 2.如果是池合同则需要进行池信息修改
		// 这里还是用老公式，池的可用融资余额总和*融资比例-池敞口金额
		if (bCntBcpInfo == null) {
			throw new ScubeBizException("回款对应合同信息丢失！");
		}
		if (bCntBcpInfo.getFinancingType().equals("2")) {
			RBcpDebtPool rBcpDebtPool = rBcpDebtPoolService.findRBcpDebtPoolByMastContno(mastContno);
			if (rBcpDebtPool == null) {
				throw new ScubeBizException("回款对应合同池信息丢失！");
			}
			BCntBcpInfoVO bcpInfoVO = new BCntBcpInfoVO();
			BeanUtils.copyProperties(bCntBcpInfo, bcpInfoVO);
			BigDecimal poolRemainingAmount =rBcpDebtPool.getPoolRemainingAmount()== null ?BigDecimal.ZERO: rBcpDebtPool.getPoolRemainingAmount();
			poolRemainingAmount=poolRemainingAmount.subtract(repayAmount);
			if(poolRemainingAmount.compareTo(BigDecimal.ZERO) < 0){
				log.debug("回款时poolRemainingAmount小于0，无法进行回款！");
				throw new ScubeBizException("回款金额大于池融资金额，无法回款！");
			}
			rBcpDebtPool.setPoolRemainingAmount(poolRemainingAmount);
			nrbcpdebtpoolservice.updatePoolRemainAmount(rBcpDebtPool,bcpInfoVO,ScfBasConstant.INVOKE_PHASE_REPAYMENT);
		}
		return;
	}

	/**
	 * 提前还款成功后，更新借据表的贷款余额
	 * 
	 * @param appNo
	 *            String-业务申请号
	 * @throws ScubeBizException
	 */
	@Transactional
	public void updateBLanLnciBase(String appNo) throws ScubeBizException {
		// 根据业务申请号查询还款信息
		List<com.huateng.scf.rec.bcp.model.RBcpAppliRepayment> appliRepaymentList = rbcpapplirepaymentservice
				.queryTblAppliRepaymentInfoByAppno(appNo); // 还款信息--流贷还本息信息,R_BCP_APPLI_REPAYMENT[还款/回款申请流水信息表]
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		String appliType = bPbcAppliBaseInfo.getAppliType();
		if (null != appliRepaymentList && appliRepaymentList.size() > 0) {
			for (int i = 0; i < appliRepaymentList.size(); i++) {
				com.huateng.scf.rec.bcp.model.RBcpAppliRepayment appliPayInfo = (com.huateng.scf.rec.bcp.model.RBcpAppliRepayment) appliRepaymentList
						.get(i);
				String debetId = appliPayInfo.getDebetNo();// 借据号
				// 根据debetNo查询B_LAN_LNCI_BASE[借据基本信息表]
				com.huateng.scf.bas.lan.model.BLanLnciBase bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByDebtId(debetId);
				if (bLanLnciBase != null) {
					// 1.借据余额修改
					BigDecimal lnciBal = bLanLnciBase.getLnciBal() == null ? new BigDecimal(0) : bLanLnciBase.getLnciBal();
					bLanLnciBase.setLnciBal(lnciBal.subtract(appliPayInfo.getRepayAmount())); // 提前还款成功后，更新借据表
					bLanLnciBaseService.setLnciIsSettle(bLanLnciBase);// 如果敞口为零将借据置为已结清状态
					// 2.对应额度释放，通过借据流水号查询对应的放款申请信息，得到对应的额度编号，释放额度
					BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.findBLanAppliLnciBaseByDebtId(bLanLnciBase.getDebetId());
					if (bLanAppliLnciBase == null) {
						throw new ScubeBizException("借据申请基本信息丢失，间接额度释放失败！");
					}
					CreditInterParamVO creditInterParam = new CreditInterParamVO();
					creditInterParam.setCreditNo(bLanAppliLnciBase.getCreditNo());
					creditInterParam.setRelaType(ScfBasConstant.CREDIT_RELA_TYPE_LNCI);
					creditInterParam.setReleaseFlag(ScfBasConstant.FLAG_ON);
					creditInterParam.setApplyType(appliType);
					creditInterParam.setBusinessno(bLanLnciBase.getDebetId());// 借据号
					creditInterParam.setAmount(appliPayInfo.getRepayAmount());// 释放额度（还款金额）
					creditInterParam.setAppno(appNo);
					creditInterParam.setOtherCustcd(bLanLnciBase.getCustcd());// 与放款对应占用额度相同客户号
					try {
						scfIndirectCreditService.indirectCreditDealWithByCreditNo(creditInterParam, ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE);
					} catch (Exception e) {
						throw new ScubeBizException("间接额度释放失败！");
					}
				} else {
					throw new ScubeBizException("借据信息丢失！");
				}
			}
		}
	}

	// ==========================================================================//

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 1.申请基本信息处理。
		// 2.尾款处理。有无尾款，有的话按照页面选择是到结算账户还是到尾款账户。
		// 3.还款。远程调用接口，等待还款信息，如果成功，则继续业务，不成功，直接报错。
		// 这里如果无追索权还需要稀释客户信用额度
		// 4.单据凭证处理
		// 5.融资信息（借据）处理
		// 6.如果是池融资。合同池信息处理。

		// 业务信息校验
		RBcpAppliBussInfo rBcpAppliBussInfo = nRBcpAppliBussInfoService.findByAppno(appNo);
		if (null == rBcpAppliBussInfo) {
			log.info("RBcpPaymentServiceImpl.doWorkForPass:业务申请信息不存在！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10004), BPbcErrorConstant.SCF_BAS_PBC_10004);
		}
		RBcpDebtBussInfo bussInfo = new RBcpDebtBussInfo();
		BeanUtils.copyProperties(rBcpAppliBussInfo, bussInfo);
		bussInfo.setRepayPurpose(bussInfo.getReason());
		nrbcpdebtbussinfoservice.addRBcpDebtBussInfo(bussInfo);
		BigDecimal returnAmount = rBcpAppliBussInfo.getReturnAmount();
		BigDecimal totalOverAmount = rBcpAppliBussInfo.getTotalOverAmount();
		BigDecimal repayAmount = returnAmount.subtract(totalOverAmount);// 本次实际还款金额
		// 4.单据凭证处理(3.额度释放 5.融资信息 6.池信息处理)
		this.BussDtlForPass(appNo, repayAmount);
		// 5.融资信息（借据）处理// 3.额度释放
		this.updateBLanLnciBase(appNo);
		// 6.如果是池融资。合同池信息处理。（这里还是用老公式，池的可用融资余额总和*融资比例-池敞口金额）

		// 1.申请基本信息处理。
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "pass");
	}

	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		// 改变申请状态，解锁对应单据。
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "reject");
		// 解锁对应借据
		bLanLnciBaseService.releaseBLanLnciBase(appNo);
	}

	@Override
	@Transactional
	public void doWorkForBack(String appNo) {
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "back");
	}

	/**
	 * 应收账款池融资 现金回款页面融资列表信息回显
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param debtLnciQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月日 下午4:47:21
	 * @returnType
	 */
	@Override
	public Page findloanAddListByPage(int pageNo, int pageSize, DebtLnciQryVO debtLnciQryVO, List<com.huateng.scf.bas.lan.model.BLanLnciBase> list)
			throws ScubeBizException {
		if (debtLnciQryVO == null || StringUtils.isEmpty(debtLnciQryVO.getAppno())) {
			return null;
		}
		String appno = debtLnciQryVO.getAppno();
		Page page = new Page(pageSize, pageNo, 0);
		// 1.通过页面传递的申请信息搜索对应的回款申请明细信息
		RBcpAppliRepaymentExample rBcpAppliRepaymentExample = new RBcpAppliRepaymentExample();
		RBcpAppliRepaymentExample.Criteria criteriaR = rBcpAppliRepaymentExample.createCriteria();
		criteriaR.andAppnoEqualTo(appno);
		List<RBcpAppliRepayment> rBcpAppliRepayList = rBcpAppliRepaymentDAO.selectByPage(rBcpAppliRepaymentExample, page);
		ArrayList<DebtLnciBaseInfoVO> arrayList3 = new ArrayList<DebtLnciBaseInfoVO>();
		if (rBcpAppliRepayList != null && rBcpAppliRepayList.size() > 0) {
			for (RBcpAppliRepayment rBcpAppliRepayment : rBcpAppliRepayList) {
				if (StringUtils.isNotEmpty(rBcpAppliRepayment.getDebetNo())) {
					BLanLnciBaseExample bLanLnciBaseExample = new BLanLnciBaseExample();
					BLanLnciBaseExample.Criteria criteriaL = bLanLnciBaseExample.createCriteria();
					criteriaL.andDebetIdEqualTo(rBcpAppliRepayment.getDebetNo());
					List<BLanLnciBase> bLanLnciBaseList = bLanLnciBaseDAO.selectByExample(bLanLnciBaseExample);
					if (bLanLnciBaseList != null && bLanLnciBaseList.size() == 1) {
						BLanLnciBase bLanLnciBase = bLanLnciBaseList.get(0);
						DebtLnciBaseInfoVO debtLnciBaseInfoVO = new DebtLnciBaseInfoVO();
						BeanUtils.copyProperties(bLanLnciBase, debtLnciBaseInfoVO);
						debtLnciBaseInfoVO.setLnciBal(rBcpAppliRepayment.getRepayBalamt());// 这个里面存的是借据余额
						debtLnciBaseInfoVO.setInTableInt(rBcpAppliRepayment.getRepayIntamt());// 这里存储的是欠息总额
						debtLnciBaseInfoVO.setRepayAmount(rBcpAppliRepayment.getRepayAmount());
						debtLnciBaseInfoVO.setLnciStatus(rBcpAppliRepayment.getMemo());// 这里存储的借据状态
						arrayList3.add(debtLnciBaseInfoVO);
					}
				}
			}
			page.setRecords(arrayList3);
			page.setTotalRecord(arrayList3.size());
			return page;
		} else {
			return null;
		}
	}

	@Override
	public List<RBcpAppliBussDtl> sequenceDebtAndReturnAmount(BigDecimal returnAmount, String assignRule, List<RBcpAppliBussDtl> list)
			throws ScubeBizException {
		// 如果未传assignRule，核销规则，则只排序
		// 1.按照到期日倒叙排列（页面会判断list.length>1 ，才触发方法）
		if (StringUtils.isEmpty(assignRule)) {
			Collections.sort(list, new Comparator<RBcpAppliBussDtl>() {
				@Override
				public int compare(RBcpAppliBussDtl a, RBcpAppliBussDtl b) {
					String one = a.getDebtEnd();
					String two = b.getDebtEnd();
					return one.compareTo(two);
				}
			});
		}
		// 2.按照核销规则（如果没有核销规则,直接返回排序好的单据。 TODO
		if (StringUtils.isNotEmpty(assignRule)) {
			// 按到期日
			if (RBcpDebtConstant.PAYMENT_VERIFY_RULE_DUE_FIRST.equals(assignRule)) {
				for (RBcpAppliBussDtl rbcpAppliBussDtl : list) {

					BigDecimal remainingAmount = rbcpAppliBussDtl.getRemainingAmount();
					int comp = remainingAmount.compareTo(returnAmount);
					if (comp >= 0) {
						rbcpAppliBussDtl.setPayAmount(returnAmount);
						rbcpAppliBussDtl.setRemoveAmount(returnAmount);
						break;
					} else {
						rbcpAppliBussDtl.setPayAmount(remainingAmount);
						rbcpAppliBussDtl.setRemoveAmount(remainingAmount);
						returnAmount = returnAmount.subtract(remainingAmount);
					}
				}

			}
			// 按平均分配
			else if (RBcpDebtConstant.PAYMENT_VERIFY_RULE_AVERAGE.equals(assignRule)) {
				int num = list.size();
				// 取整数
				BigDecimal average = returnAmount.divide(BigDecimal.valueOf(num), 0, RoundingMode.FLOOR);
				if (num > 0) {
					for (RBcpAppliBussDtl rbcpAppliBussDtl : list) {
						rbcpAppliBussDtl.setPayAmount(average);
						rbcpAppliBussDtl.setRemoveAmount(average);
					}
				}
			}
		}
		return list;
	}

	@Override
	public List<DebtLnciBaseInfoVO> repayLoanInfoAuto(BigDecimal returnAmount,String assignRule, List<DebtLnciBaseInfoVO> list) throws ScubeBizException {
		if (returnAmount == null || returnAmount.compareTo(BigDecimal.ZERO) == 0) {
			return list;
		}
		
		if (StringUtils.isNotEmpty(assignRule)) {
			// 按到期日
			if (RBcpDebtConstant.PAYMENT_VERIFY_RULE_DUE_FIRST.equals(assignRule)) {
				for (DebtLnciBaseInfoVO debtLnciBaseInfo : list) {
					BigDecimal lnciBal = debtLnciBaseInfo.getLnciBal();// 借据余额
					int compareTo = lnciBal.compareTo(returnAmount);
					if (compareTo > 0) {
						debtLnciBaseInfo.setRepayAmount(returnAmount);
						break;
					} else {
						debtLnciBaseInfo.setRepayAmount(lnciBal);
						returnAmount = returnAmount.subtract(lnciBal);
					}
				}
			}
			// 按平均分配
			else if (RBcpDebtConstant.PAYMENT_VERIFY_RULE_AVERAGE.equals(assignRule)) {
				int num = list.size();
				// 取整数
				BigDecimal average = returnAmount.divide(BigDecimal.valueOf(num), 0, RoundingMode.FLOOR);
				if (num > 0) {
					for (DebtLnciBaseInfoVO debtLnciBaseInfo : list) {
						debtLnciBaseInfo.setRepayAmount(average);
					}
				}
			}
		}
		
		
		return list;
	}

	@Override
	@Transactional
	public String saveCashPaymentInfoApply(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> debtList,
			List<com.huateng.scf.bas.lan.model.BLanLnciBase> loanList) throws ScubeBizException {
		// 1.前台数据校验
		if (rBcpAppliBussInfo == null || debtList == null || debtList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		String appno = "";
		// 判断是否有appno
		if (StringUtils.isEmpty(rBcpAppliBussInfo.getAppno())) {
			String businessnoType = "";// 申请类型
			String workApplyType = "";// 流程名称
			String factType = rBcpAppliBussInfo.getFactType();// 保理类型
			if (!StringUtil.isEmpty(factType)) {
				if (ScfBasConstant.FACT_TYPE_REVERSE.equals(factType) || ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
						|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {// 应收账款
					businessnoType = WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_CASH_PAYMENT_APPLY;
				} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
						|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {// 应收账款池
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_PAYMENT_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_PAYMENT_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(factType)) {// 信保
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_PAYMENT_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_PAYMENT_CREDIT_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(factType)) {// 双保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_PAYMENT_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_PAYMENT_DOUBLE_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(factType)) {// 租赁
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_PAYMENT_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_PAYMENT_LEASE_APPLY;
				}
			} else {
				throw new ScubeBizException("没有匹配到对应的流程参数", RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
			}
			workApplyType = "N-" + workApplyType;
			appno = bSysSerialNoService.genSerialNo("YS_HK_NO");// 申请流水号
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
			String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
			String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
			// 2.新增申请基本信息、
			com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
			BeanUtils.copyProperties(rBcpAppliBussInfo, bPbcAppliBaseInfo);
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);// 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);// 申请类型
			bPbcAppliBaseInfo.setAppDate(insertDate);// 申请日期
			bPbcAppliBaseInfo.setAppno(appno);// 申请号
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);// 选择主合同号
			bPbcAppliBaseInfo.setBusinessno(rBcpAppliBussInfo.getMastContno());// 具体的主合同号
			bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 供应链
			bPbcAppliBaseInfo.setSupplyChainPdId(rBcpAppliBussInfo.getBussType());// 产品类型
			bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认为流程未结束
			bPbcAppliBaseInfo.setCustcd(rBcpAppliBussInfo.getCustcdSaller());// 卖方客户号
			bPbcAppliBaseInfo.setMoniCustcd(rBcpAppliBussInfo.getCustcdBuyer());// 买方客户号
			bPbcAppliBaseInfo.setCurcd(rBcpAppliBussInfo.getCurcd());// 币种
			bPbcAppliBaseInfo.setSupplyChainPdId(rBcpAppliBussInfo.getBussType());// 业务品种
			bPbcAppliBaseInfo.setMastContno(rBcpAppliBussInfo.getMastContno()); // 主合同号
			bPbcAppliBaseInfo.setAmt(rBcpAppliBussInfo.getReturnAmount());// 回款金额
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);// 申请状态为未提交（未提交）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);// 申请状态明细（未提交）
			bPbcAppliBaseInfo.setStratDate(insertDate);// 开始日期
			try {
				iBPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			} catch (Exception e) {// SCF_REC_BCP_10023 申请信息新增失败！
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10023),
						RBcpErrorConstant.SCF_REC_BCP_10023);
			}

			// 3.应收类业务申请信息
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
			BeanUtils.copyProperties(rBcpAppliBussInfo, rBcpAppliBussInfo2);
			rBcpAppliBussInfo2.setAppno(appno);// 申请号
			rBcpAppliBussInfo2.setInsertDate(insertDate);// 登记时间
			rBcpAppliBussInfo2.setCrtTime(new Date());// 创建时间
			rBcpAppliBussInfo2.setLastUptTime(new Date());// 最后更新时间
			rBcpAppliBussInfo2.setId(UUIDGeneratorUtil.generate());// id
			rBcpAppliBussInfo2.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPAYMENT);// 申请状态为还款
			rBcpAppliBussInfo2.setTlrcd(tlrcd);// 创建人，操作员
			rBcpAppliBussInfo2.setBrcode(brcode);// 设置经办机构信息
			try {
				rBcpAppliBussInfoDAO.insertSelective(rBcpAppliBussInfo2);
			} catch (Exception e) {// SCF_REC_BCP_10024 ，新增应收账款业务流水信息失败！
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10024),
						RBcpErrorConstant.SCF_REC_BCP_10024);
			}
			// 4.保存申请明细信息,锁定对应单据信息。
			nRBcpAppliBussDtlService.addRBcpAppliBussDtlAndLockedDebt(appno, debtList);
			// 5.保存回款申请明细信息(锁定对应的借据信息)
			rBcpAppliBussInfo.setAppno(appno);
			if (loanList != null && loanList.size() > 0) {
				bLanLnciBaseService.addRepayInfoAndLockLnciBase(rBcpAppliBussInfo, loanList);
			}

		} else {
			// 保存修改信息
			appno = rBcpAppliBussInfo.getAppno();
			updateCashPaymentInfoApply(rBcpAppliBussInfo, debtList, loanList);
		}
		return appno;
	}

	@Override
	@Transactional
	public void updateCashPaymentInfoApply(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> debtList,
			List<com.huateng.scf.bas.lan.model.BLanLnciBase> loanList) throws ScubeBizException {
		// 1.保存申请基本信息（只改变回款总金额）
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		bPbcAppliBaseInfo1.setAmt(rBcpAppliBussInfo.getReturnAmount());// 回款金额
		try {
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
		} catch (Exception e) {// 修改应收账款申请转让信息，修改申请基本信息的转让总金额失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 2.申请业务信息
		RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
		RBcpAppliBussInfoExample.Criteria criteria = rBcpAppliBussInfoExample.createCriteria();
		criteria.andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> rBcpAppliBussInfoList = rBcpAppliBussInfoDAO
				.selectByExample(rBcpAppliBussInfoExample);
		if (rBcpAppliBussInfoList == null || rBcpAppliBussInfoList.size() != 1) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007), RBcpErrorConstant.SCF_REC_BCP_10007);
		} else {
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = rBcpAppliBussInfoList.get(0);
			rBcpAppliBussInfo2.setReturnMethod(rBcpAppliBussInfo.getReturnMethod());
			rBcpAppliBussInfo2.setAmount(rBcpAppliBussInfo.getAmount());
			rBcpAppliBussInfo2.setAssignRule(rBcpAppliBussInfo.getAssignRule());

			rBcpAppliBussInfo2.setSettleMethod(rBcpAppliBussInfo.getSettleMethod());// 回款结算方式
			rBcpAppliBussInfo2.setTransactionNo(rBcpAppliBussInfo.getTransactionNo());
			rBcpAppliBussInfo2.setReturnAccountBalance(rBcpAppliBussInfo.getReturnAccountBalance());

			rBcpAppliBussInfo2.setReturnAmount(rBcpAppliBussInfo.getReturnAmount());
			rBcpAppliBussInfo2.setTotalOverAmount(rBcpAppliBussInfo.getTotalOverAmount());
			rBcpAppliBussInfo2.setToSallerFlag(rBcpAppliBussInfo.getToSallerFlag());

			rBcpAppliBussInfo2.setMemo(rBcpAppliBussInfo.getMemo());
			rBcpAppliBussInfo2.setLastUptTime(new Date());
			try {
				rBcpAppliBussInfoDAO.updateByPrimaryKey(rBcpAppliBussInfo2);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007),
						RBcpErrorConstant.SCF_REC_BCP_10007);
			}
		}
		// 3.申请业务明细信息
		nRBcpAppliBussDtlService.deleteRBcpAppliBussDtlAndReleaseDebt(rBcpAppliBussInfo.getAppno());
		nRBcpAppliBussDtlService.addRBcpAppliBussDtlAndLockedDebt(rBcpAppliBussInfo.getAppno(), debtList);
		// 4.回款信息（融资借据信息。）
		if (loanList != null && loanList.size() > 0) {
			bLanLnciBaseService.deleteRepayInfoAndReleaseLnciBase(rBcpAppliBussInfo.getAppno());
			bLanLnciBaseService.addRepayInfoAndLockLnciBase(rBcpAppliBussInfo, loanList);
		}
		return;
	}

	@Override
	@Transactional
	public void submitCashPaymentInfoApplyInfo(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> debtList,
			List<com.huateng.scf.bas.lan.model.BLanLnciBase> loanList) throws ScubeBizException {
		// 1.前台数据校验
		if (rBcpAppliBussInfo == null || debtList == null || debtList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.保存页面数据
		updateCashPaymentInfoApply(rBcpAppliBussInfo, debtList, loanList);
		// 判断是否已发起流程为退回提交
		String appno = rBcpAppliBussInfo.getAppno();
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 3.如果为空发起流程，修改状态
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 3.1发起流程
			String workApplyType = bPbcAppliBaseInfo1.getProcessTemplateName();// 流程名称
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), workApplyType, paramMap);
			} catch (FlowsharpException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 申请状态为//已提交
			bPbcAppliBaseInfo1.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 申请状态明细
			try {
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040),
						RBcpErrorConstant.SCF_REC_BCP_10040);
			}
		} else {
			try {
				scfWorkFlowService.backSubmitCommon(bPbcAppliBaseInfo1);
			} catch (ScubeBizException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			} catch (FlowsharpException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			}
		}

	}

	@Override
	@Transactional
	public void deleteCashPaymentInfo(String appno) throws ScubeBizException {

		bPbcAppliBaseInfoDAO.deleteByPrimaryKey(appno);
		nRBcpAppliBussInfoService.deleteByAppno(appno);
		// 删除原有申请明细信息，如果有对应的单据信息，则解锁。
		nRBcpAppliBussDtlService.deleteRBcpAppliBussDtlAndReleaseDebt(appno);
		// 借据信息的解锁，回款明细信息的删除
		bLanLnciBaseService.deleteRepayInfoAndReleaseLnciBase(appno);
	}

	@Override
	public List<DebtLnciBaseInfoVO> sequenceLoanInfo(List<DebtLnciBaseInfoVO> list) throws ScubeBizException {
		if (list == null || list.size() == 0) {
			return null;
		}
		Collections.sort(list, new Comparator<DebtLnciBaseInfoVO>() {
			@Override
			public int compare(DebtLnciBaseInfoVO a, DebtLnciBaseInfoVO b) {
				String one = a.getEndDate();
				String two = b.getEndDate();
				return one.compareTo(two);
			}
		});
		return list;
	}

	@Override
	public Page queryLoanByPageForPay(int pageNo, int pageSize, DebtLnciQryVO debtLnciQryVO, List<com.huateng.scf.bas.lan.model.BLanLnciBase> list)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<String> arrayList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (com.huateng.scf.bas.lan.model.BLanLnciBase bLanLnciBase : list) {
				arrayList.add("'" + bLanLnciBase.getDebetId() + "'");
			}
			map.put("debetIdList", arrayList);
		}
		if (debtLnciQryVO != null) {
			String appno = debtLnciQryVO.getAppno();
			String loanAppno = debtLnciQryVO.getLoanAppno();
			String debetId = debtLnciQryVO.getDebetId();
			String beginDate = debtLnciQryVO.getBeginDate();
			String bussContno = debtLnciQryVO.getBussContno();
			String endDateFrom = debtLnciQryVO.getEndDateFrom();
			String endDateTo = debtLnciQryVO.getEndDateTo();
			map.put("loanAppno", loanAppno);
			map.put("debetId", debetId);
			map.put("startDate", beginDate);
			map.put("bussContno", bussContno);
			map.put("lockAppno", appno);
			map.put("endDateFrom", endDateFrom);
			map.put("endDateTo", endDateTo);
		}
		try {
			List<BLanLnciBase> bLanLnciBaseList = extBLanDAO.findBLanListForPay(map, page);
			ArrayList<DebtLnciBaseInfoVO> arrayList3 = new ArrayList<DebtLnciBaseInfoVO>();
			if (bLanLnciBaseList != null && bLanLnciBaseList.size() > 0) {
				for (BLanLnciBase bLanLnciBase : bLanLnciBaseList) {
					DebtLnciBaseInfoVO debtLnciBaseInfoVO = new DebtLnciBaseInfoVO();
					BeanUtils.copyProperties(bLanLnciBase, debtLnciBaseInfoVO);
					BigDecimal receInt = debtLnciBaseInfoVO.getReceivableInt() != null ? debtLnciBaseInfoVO.getReceivableInt() : new BigDecimal(0);
					BigDecimal recePunInt = debtLnciBaseInfoVO.getReceivablePunishInt() != null ? debtLnciBaseInfoVO.getReceivablePunishInt()
							: new BigDecimal(0);
					debtLnciBaseInfoVO.setInTableInt(receInt.add(recePunInt));// 欠息总额=应收欠息+应收罚息
					debtLnciBaseInfoVO.setRepayAmount(BigDecimal.ZERO);
					arrayList3.add(debtLnciBaseInfoVO);
				}
				page.setRecords(arrayList3);
			}
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			log.error("条件分页查询条件分页查询应收账款信息失败！" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009), RBcpErrorConstant.SCF_REC_BCP_10009);
		}
		return page;
	}

	/**
	 * 任务基本信息
	 * 
	 * @param appno
	 * @param factType
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月28日下午3:10:44
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno, String factType) {
		String process = "";
		if (ScfBasConstant.FACT_TYPE_REVERSE.equals(factType) || ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
				|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {// 应收账款
			process = WorkflowConstant.PROCNAME_CASH_PAYMENT_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {// 应收账款池
			process = WorkflowConstant.PROCNAME_FACTORING_POOL_PAYMENT_APPLY;
		} else if (ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(factType)) {// 信保
			process = WorkflowConstant.PROCNAME_PAYMENT_CREDIT_APPLY;
		} else if (ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(factType)) {// 双保理
			process = WorkflowConstant.PROCNAME_PAYMENT_DOUBLE_APPLY;
		} else if (ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(factType)) {// 租赁
			process = WorkflowConstant.PROCNAME_PAYMENT_LEASE_APPLY;
		}
		process = "N-" + process;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub

	}

	/**
	 *  通过申请号查找回款锁定借据信息
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	lihao
	 * @date 	2017年7月20日下午4:25:41
	 */
	@Override
	public List<DebtLnciBaseInfoVO> getDebtLnciBaseListByAppno(String appno) throws ScubeBizException {
		if(StringUtils.isEmpty(appno)){
			return null;
		}
		
		// 1.通过页面传递的申请信息搜索对应的回款申请明细信息
		RBcpAppliRepaymentExample rBcpAppliRepaymentExample = new RBcpAppliRepaymentExample();
		RBcpAppliRepaymentExample.Criteria criteriaR = rBcpAppliRepaymentExample.createCriteria();
		criteriaR.andAppnoEqualTo(appno);
		List<RBcpAppliRepayment> rBcpAppliRepayList = rBcpAppliRepaymentDAO.selectByExample(rBcpAppliRepaymentExample);
		ArrayList<DebtLnciBaseInfoVO> arrayList3 = new ArrayList<DebtLnciBaseInfoVO>();
		if (rBcpAppliRepayList != null && rBcpAppliRepayList.size() > 0) {
			for (RBcpAppliRepayment rBcpAppliRepayment : rBcpAppliRepayList) {
				if (StringUtils.isNotEmpty(rBcpAppliRepayment.getDebetNo())) {
					BLanLnciBaseExample bLanLnciBaseExample = new BLanLnciBaseExample();
					BLanLnciBaseExample.Criteria criteriaL = bLanLnciBaseExample.createCriteria();
					criteriaL.andDebetIdEqualTo(rBcpAppliRepayment.getDebetNo());
					List<BLanLnciBase> bLanLnciBaseList = bLanLnciBaseDAO.selectByExample(bLanLnciBaseExample);
					if (bLanLnciBaseList != null && bLanLnciBaseList.size() == 1) {
						BLanLnciBase bLanLnciBase = bLanLnciBaseList.get(0);
						DebtLnciBaseInfoVO debtLnciBaseInfoVO = new DebtLnciBaseInfoVO();
						BeanUtils.copyProperties(bLanLnciBase, debtLnciBaseInfoVO);
						debtLnciBaseInfoVO.setLnciBal(rBcpAppliRepayment.getRepayBalamt());// 这个里面存的是借据余额
						debtLnciBaseInfoVO.setInTableInt(rBcpAppliRepayment.getRepayIntamt());// 这里存储的是欠息总额
						debtLnciBaseInfoVO.setRepayAmount(rBcpAppliRepayment.getRepayAmount());
						debtLnciBaseInfoVO.setLnciStatus(rBcpAppliRepayment.getMemo());// 这里存储的借据状态
						arrayList3.add(debtLnciBaseInfoVO);
					}
				}
			}
		}
		return arrayList3;
	}
}
